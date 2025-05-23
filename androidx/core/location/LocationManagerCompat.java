package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;

    @GuardedBy("sGnssStatusListeners")
    private static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

    /* compiled from: P */
    @RequiresApi(28)
    /* loaded from: classes.dex */
    private static class Api28Impl {
        Api28Impl() {
        }

        @DoNotInline
        static String getGnssHardwareModelName(LocationManager locationManager) {
            String gnssHardwareModelName;
            gnssHardwareModelName = locationManager.getGnssHardwareModelName();
            return gnssHardwareModelName;
        }

        @DoNotInline
        static int getGnssYearOfHardware(LocationManager locationManager) {
            int gnssYearOfHardware;
            gnssYearOfHardware = locationManager.getGnssYearOfHardware();
            return gnssYearOfHardware;
        }

        @DoNotInline
        static boolean isLocationEnabled(LocationManager locationManager) {
            boolean isLocationEnabled;
            isLocationEnabled = locationManager.isLocationEnabled();
            return isLocationEnabled;
        }
    }

    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    private static class Api30Impl {
        Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void getCurrentLocation(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull final Consumer<Location> consumer) {
            android.os.CancellationSignal cancellationSignal2;
            if (cancellationSignal != null) {
                cancellationSignal2 = (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject();
            } else {
                cancellationSignal2 = null;
            }
            locationManager.getCurrentLocation(str, cancellationSignal2, executor, new java.util.function.Consumer<Location>() { // from class: androidx.core.location.LocationManagerCompat.Api30Impl.1
                @Override // java.util.function.Consumer
                public void accept(Location location) {
                    Consumer.this.accept(location);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z16;
            if (callback != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i3) {
            this.mCallback.onFirstFix(i3);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            boolean z16;
            if (callback != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        @Override // android.location.GpsStatus.Listener
        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i3) {
            GpsStatus gpsStatus;
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                            final GnssStatusCompat wrap = GnssStatusCompat.wrap(gpsStatus);
                            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (GpsStatusTransport.this.mExecutor != executor) {
                                        return;
                                    }
                                    GpsStatusTransport.this.mCallback.onSatelliteStatusChanged(wrap);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus2 != null) {
                        final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                        executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (GpsStatusTransport.this.mExecutor != executor) {
                                    return;
                                }
                                GpsStatusTransport.this.mCallback.onFirstFix(timeToFirstFix);
                            }
                        });
                        return;
                    }
                    return;
                }
                executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GpsStatusTransport.this.mExecutor != executor) {
                            return;
                        }
                        GpsStatusTransport.this.mCallback.onStopped();
                    }
                });
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.GpsStatusTransport.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GpsStatusTransport.this.mExecutor != executor) {
                        return;
                    }
                    GpsStatusTransport.this.mCallback.onStarted();
                }
            });
        }

        public void register(Executor executor) {
            boolean z16;
            if (this.mExecutor == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkState(z16);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else {
                if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                    return;
                }
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        @Nullable
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z16;
            if (callback != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i3) {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.3
                @Override // java.lang.Runnable
                public void run() {
                    if (PreRGnssStatusTransport.this.mExecutor != executor) {
                        return;
                    }
                    PreRGnssStatusTransport.this.mCallback.onFirstFix(i3);
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PreRGnssStatusTransport.this.mExecutor != executor) {
                        return;
                    }
                    PreRGnssStatusTransport.this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PreRGnssStatusTransport.this.mExecutor != executor) {
                        return;
                    }
                    PreRGnssStatusTransport.this.mCallback.onStarted();
                }
            });
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PreRGnssStatusTransport.this.mExecutor != executor) {
                        return;
                    }
                    PreRGnssStatusTransport.this.mCallback.onStopped();
                }
            });
        }

        public void register(Executor executor) {
            boolean z16;
            boolean z17 = true;
            if (executor != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "invalid null executor");
            if (this.mExecutor != null) {
                z17 = false;
            }
            Preconditions.checkState(z17);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    LocationManagerCompat() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull final Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        final Location lastKnownLocation = LocationMonitor.getLastKnownLocation(locationManager, str);
        if (lastKnownLocation != null && SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) < 10000) {
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.1
                @Override // java.lang.Runnable
                public void run() {
                    Consumer.this.accept(lastKnownLocation);
                }
            });
            return;
        }
        final CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
        LocationMonitor.requestLocationUpdates(locationManager, str, 0L, 0.0f, cancellableLocationListener, Looper.getMainLooper());
        if (cancellationSignal != null) {
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.core.location.LocationManagerCompat.2
                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
                public void onCancel() {
                    CancellableLocationListener.this.cancel();
                }
            });
        }
        cancellableLocationListener.startTimeout(30000L);
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        if (!locationManager.isProviderEnabled("network") && !locationManager.isProviderEnabled("gps")) {
            return false;
        }
        return true;
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, new InlineHandlerExecutor(handler), callback);
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.remove(callback);
                if (gnssStatusTransport != null) {
                    locationManager.unregisterGnssStatusCallback(gnssStatusTransport);
                }
            }
            return;
        }
        if (i3 >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
            return;
        }
        SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.remove(callback);
            if (gpsStatusTransport != null) {
                gpsStatusTransport.unregister();
                locationManager.removeGpsStatusListener(gpsStatusTransport);
            }
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x010b A[Catch: all -> 0x0127, TryCatch #2 {all -> 0x0127, blocks: (B:88:0x00e9, B:89:0x0100, B:76:0x0103, B:78:0x010b, B:80:0x0113, B:81:0x0119, B:82:0x011a, B:83:0x011f, B:84:0x0120, B:85:0x0126, B:71:0x00d8), top: B:53:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0120 A[Catch: all -> 0x0127, TryCatch #2 {all -> 0x0127, blocks: (B:88:0x00e9, B:89:0x0100, B:76:0x0103, B:78:0x010b, B:80:0x0113, B:81:0x0119, B:82:0x011a, B:83:0x011f, B:84:0x0120, B:85:0x0126, B:71:0x00d8), top: B:53:0x0098 }] */
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean registerGnssStatusCallback(final LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
        boolean registerGnssStatusCallback;
        boolean registerGnssStatusCallback2;
        int i3 = Build.VERSION.SDK_INT;
        boolean z16 = true;
        if (i3 >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.get(callback);
                if (gnssStatusTransport == null) {
                    gnssStatusTransport = new GnssStatusTransport(callback);
                }
                registerGnssStatusCallback2 = locationManager.registerGnssStatusCallback(executor, gnssStatusTransport);
                if (!registerGnssStatusCallback2) {
                    return false;
                }
                simpleArrayMap.put(callback, gnssStatusTransport);
                return true;
            }
        }
        if (i3 >= 24) {
            Preconditions.checkArgument(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.get(callback);
                if (preRGnssStatusTransport == null) {
                    preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                } else {
                    preRGnssStatusTransport.unregister();
                }
                preRGnssStatusTransport.register(executor);
                registerGnssStatusCallback = locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler);
                if (!registerGnssStatusCallback) {
                    return false;
                }
                simpleArrayMap2.put(callback, preRGnssStatusTransport);
                return true;
            }
        }
        Preconditions.checkArgument(handler != null);
        SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            final GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.get(callback);
            if (gpsStatusTransport == null) {
                gpsStatusTransport = new GpsStatusTransport(locationManager, callback);
            } else {
                gpsStatusTransport.unregister();
            }
            gpsStatusTransport.register(executor);
            FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: androidx.core.location.LocationManagerCompat.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
                public Boolean call() {
                    return Boolean.valueOf(LocationMonitor.addGpsStatusListener(locationManager, gpsStatusTransport));
                }
            });
            if (Looper.myLooper() == handler.getLooper()) {
                futureTask.run();
            } else if (!handler.post(futureTask)) {
                throw new IllegalStateException(handler + " is shutting down");
            }
            try {
                try {
                    long nanos = TimeUnit.SECONDS.toNanos(5L);
                    long nanoTime = System.nanoTime() + nanos;
                    boolean z17 = false;
                    while (((Boolean) futureTask.get(nanos, TimeUnit.NANOSECONDS)).booleanValue()) {
                        try {
                            try {
                                sGnssStatusListeners.put(callback, gpsStatusTransport);
                                if (z17) {
                                    Thread.currentThread().interrupt();
                                }
                                return true;
                            } catch (InterruptedException unused) {
                                nanos = nanoTime - System.nanoTime();
                                z17 = true;
                            } catch (ExecutionException e16) {
                                e = e16;
                                if (e.getCause() instanceof RuntimeException) {
                                }
                            } catch (TimeoutException e17) {
                                e = e17;
                                throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                            } catch (Throwable th5) {
                                th = th5;
                                z16 = z17;
                                if (z16) {
                                    Thread.currentThread().interrupt();
                                }
                                throw th;
                            }
                        } catch (ExecutionException e18) {
                            e = e18;
                            if (e.getCause() instanceof RuntimeException) {
                                if (e.getCause() instanceof Error) {
                                    throw ((Error) e.getCause());
                                }
                                throw new IllegalStateException(e);
                            }
                            throw ((RuntimeException) e.getCause());
                        } catch (TimeoutException e19) {
                            e = e19;
                            throw new IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                        }
                    }
                    if (z17) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                } catch (ExecutionException e26) {
                    e = e26;
                } catch (TimeoutException e27) {
                    e = e27;
                } catch (Throwable th6) {
                    th = th6;
                    z16 = false;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());

        @Nullable
        Runnable mTimeoutRunnable;

        @GuardedBy("this")
        private boolean mTriggered;

        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            LocationMonitor.removeUpdates(this.mLocationManager, this);
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                cleanup();
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable final Location location) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                this.mTriggered = true;
                final Consumer<Location> consumer = this.mConsumer;
                this.mExecutor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat.CancellableLocationListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        consumer.accept(location);
                    }
                });
                cleanup();
            }
        }

        @Override // android.location.LocationListener
        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String str) {
            onLocationChanged((Location) null);
        }

        public void startTimeout(long j3) {
            synchronized (this) {
                if (this.mTriggered) {
                    return;
                }
                Runnable runnable = new Runnable() { // from class: androidx.core.location.LocationManagerCompat.CancellableLocationListener.1
                    @Override // java.lang.Runnable
                    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
                    public void run() {
                        CancellableLocationListener cancellableLocationListener = CancellableLocationListener.this;
                        cancellableLocationListener.mTimeoutRunnable = null;
                        cancellableLocationListener.onLocationChanged((Location) null);
                    }
                };
                this.mTimeoutRunnable = runnable;
                this.mTimeoutHandler.postDelayed(runnable, j3);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i3, Bundle bundle) {
        }
    }
}
