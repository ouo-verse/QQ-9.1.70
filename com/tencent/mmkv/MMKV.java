package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import dalvik.annotation.optimization.FastNative;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    private static boolean C;
    private static final HashMap<String, Parcelable.Creator<?>> D;
    private static com.tencent.mmkv.b E;
    private static c F;
    private static boolean G;
    private static boolean H;
    private static com.tencent.mmkv.a I;

    /* renamed from: d, reason: collision with root package name */
    private static final EnumMap<MMKVRecoverStrategic, Integer> f154043d;

    /* renamed from: e, reason: collision with root package name */
    private static final EnumMap<MMKVLogLevel, Integer> f154044e;

    /* renamed from: f, reason: collision with root package name */
    private static final MMKVLogLevel[] f154045f;

    /* renamed from: h, reason: collision with root package name */
    private static final Set<Long> f154046h;

    /* renamed from: i, reason: collision with root package name */
    private static String f154047i;

    /* renamed from: m, reason: collision with root package name */
    private static AtomicBoolean f154048m;
    private final long nativeHandle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f154049a;

        static {
            int[] iArr = new int[MMKVLogLevel.values().length];
            f154049a = iArr;
            try {
                iArr[MMKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f154049a[MMKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f154049a[MMKVLogLevel.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f154049a[MMKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f154049a[MMKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void loadLibrary(String str);
    }

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>((Class<MMKVRecoverStrategic>) MMKVRecoverStrategic.class);
        f154043d = enumMap;
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.OnErrorDiscard, (MMKVRecoverStrategic) 0);
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.OnErrorRecover, (MMKVRecoverStrategic) 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>((Class<MMKVLogLevel>) MMKVLogLevel.class);
        f154044e = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel, (MMKVLogLevel) 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel2, (MMKVLogLevel) 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel3, (MMKVLogLevel) 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel4, (MMKVLogLevel) 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel5, (MMKVLogLevel) 4);
        f154045f = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        f154046h = new HashSet();
        f154047i = null;
        f154048m = new AtomicBoolean(false);
        C = true;
        D = new HashMap<>();
        G = false;
        H = false;
    }

    MMKV(long j3) {
        this.nativeHandle = j3;
    }

    private byte[] R(@NonNull Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static String T(Context context) {
        return U(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo, null);
    }

    public static String U(Context context, String str, b bVar, MMKVLogLevel mMKVLogLevel, com.tencent.mmkv.b bVar2) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            w();
        } else {
            y();
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        E = bVar2;
        if (bVar2 != null && bVar2.wantLogRedirecting()) {
            G = true;
        }
        String x16 = x(str, absolutePath, bVar, mMKVLogLevel, G);
        if (E != null) {
            setCallbackHandler(G, true);
        }
        if (bVar2 instanceof c) {
            c cVar = (c) bVar2;
            F = cVar;
            boolean wantModeCheck = cVar.wantModeCheck();
            H = wantModeCheck;
            setWantModeCheck(wantModeCheck);
        }
        return x16;
    }

    @Deprecated
    public static String V(String str) {
        return x(str, str + "/.tmp", null, MMKVLogLevel.LevelInfo, false);
    }

    @Deprecated
    public static String W(String str, b bVar) {
        return x(str, str + "/.tmp", bVar, MMKVLogLevel.LevelInfo, false);
    }

    private static int X(MMKVLogLevel mMKVLogLevel) {
        int i3 = a.f154049a[mMKVLogLevel.ordinal()];
        if (i3 != 1) {
            int i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    i16 = 4;
                    if (i3 != 4) {
                        return 1;
                    }
                }
            }
            return i16;
        }
        return 0;
    }

    public static MMKV Y(String str, int i3, int i16, String str2) throws RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i3, i16, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public static MMKV Z(Context context, String str, int i3, int i16, @Nullable String str2) throws RuntimeException {
        MMKV a16;
        if (f154047i != null) {
            String b16 = MMKVContentProvider.b(context, Process.myPid());
            if (b16 != null && b16.length() != 0) {
                if (b16.contains(":")) {
                    Uri a17 = MMKVContentProvider.a(context);
                    if (a17 != null) {
                        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
                        h0(mMKVLogLevel, "getting parcelable mmkv in process, Uri = " + a17);
                        Bundle bundle = new Bundle();
                        bundle.putInt("KEY_SIZE", i3);
                        bundle.putInt("KEY_MODE", i16);
                        if (str2 != null) {
                            bundle.putString("KEY_CRYPT", str2);
                        }
                        Bundle call = context.getContentResolver().call(a17, "mmkvFromAshmemID", str, bundle);
                        if (call != null) {
                            call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                            ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable("KEY");
                            if (parcelableMMKV != null && (a16 = parcelableMMKV.a()) != null) {
                                h0(mMKVLogLevel, a16.mmapID() + " fd = " + a16.ashmemFD() + ", meta fd = " + a16.ashmemMetaFD());
                                return a16;
                            }
                        }
                    } else {
                        h0(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                        throw new IllegalStateException("MMKVContentProvider has invalid authority");
                    }
                }
                h0(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
                long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i3, i16 | 8, str2);
                if (mMKVWithIDAndSize != 0) {
                    return new MMKV(mMKVWithIDAndSize);
                }
                throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + str + "]");
            }
            h0(MMKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV a0(String str, int i3) throws RuntimeException {
        if (f154047i != null) {
            return b(getMMKVWithID(str, i3, null, null, 0L), str, i3);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private native long actualSize(long j3);

    private native String[] allKeys(long j3, boolean z16);

    private static MMKV b(long j3, String str, int i3) throws RuntimeException {
        String str2;
        if (j3 != 0) {
            if (!C) {
                return new MMKV(j3);
            }
            Set<Long> set = f154046h;
            synchronized (set) {
                if (!set.contains(Long.valueOf(j3))) {
                    if (!checkProcessMode(j3)) {
                        if (i3 == 1) {
                            str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                        } else {
                            str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                        }
                        throw new IllegalArgumentException(str2);
                    }
                    set.add(Long.valueOf(j3));
                }
            }
            return new MMKV(j3);
        }
        throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
    }

    public static MMKV b0(String str, int i3, @Nullable String str2) throws RuntimeException {
        if (f154047i != null) {
            return b(getMMKVWithID(str, i3, str2, null, 0L), str, i3);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, @Nullable String str3);

    public static MMKV c0(String str, int i3, @Nullable String str2, String str3) throws RuntimeException {
        if (f154047i != null) {
            return b(getMMKVWithID(str, i3, str2, str3, 0L), str, i3);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native boolean checkProcessMode(long j3);

    private native boolean containsKey(long j3, String str);

    private native long count(long j3, boolean z16);

    private static native long createNB(int i3);

    public static void d0(com.tencent.mmkv.a aVar) {
        boolean z16;
        I = aVar;
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        setWantsContentChangeNotify(z16);
    }

    private native boolean decodeBool(long j3, String str, boolean z16);

    @Nullable
    private native byte[] decodeBytes(long j3, String str);

    private native double decodeDouble(long j3, String str, double d16);

    private native float decodeFloat(long j3, String str, float f16);

    private native int decodeInt(long j3, String str, int i3);

    private native long decodeLong(long j3, String str, long j16);

    @Nullable
    private native String decodeString(long j3, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j3, String str);

    private static native void destroyNB(long j3, int i3);

    public static void e0(com.tencent.mmkv.b bVar) {
        E = bVar;
        boolean wantLogRedirecting = bVar.wantLogRedirecting();
        G = wantLogRedirecting;
        setCallbackHandler(wantLogRedirecting, true);
        if (bVar instanceof c) {
            c cVar = (c) bVar;
            F = cVar;
            boolean wantModeCheck = cVar.wantModeCheck();
            H = wantModeCheck;
            setWantModeCheck(wantModeCheck);
        }
    }

    private native boolean encodeBool(long j3, String str, boolean z16);

    private native boolean encodeBool_2(long j3, String str, boolean z16, int i3);

    private native boolean encodeBytes(long j3, String str, @Nullable byte[] bArr);

    private native boolean encodeBytes_2(long j3, String str, @Nullable byte[] bArr, int i3);

    private native boolean encodeDouble(long j3, String str, double d16);

    private native boolean encodeDouble_2(long j3, String str, double d16, int i3);

    private native boolean encodeFloat(long j3, String str, float f16);

    private native boolean encodeFloat_2(long j3, String str, float f16, int i3);

    private native boolean encodeInt(long j3, String str, int i3);

    private native boolean encodeInt_2(long j3, String str, int i3, int i16);

    private native boolean encodeLong(long j3, String str, long j16);

    private native boolean encodeLong_2(long j3, String str, long j16, int i3);

    private native boolean encodeSet(long j3, String str, @Nullable String[] strArr);

    private native boolean encodeSet_2(long j3, String str, @Nullable String[] strArr, int i3);

    private native boolean encodeString(long j3, String str, @Nullable String str2);

    private native boolean encodeString_2(long j3, String str, @Nullable String str2, int i3);

    public static void g0(MMKVLogLevel mMKVLogLevel) {
        if (!f154048m.get()) {
            setLogLevel(X(mMKVLogLevel));
        }
    }

    private static native long getDefaultMMKV(int i3, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i3, int i16, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i3, @Nullable String str2, @Nullable String str3, long j3);

    private static native long getMMKVWithIDAndSize(String str, int i3, int i16, @Nullable String str2);

    private static void h0(MMKVLogLevel mMKVLogLevel, String str) {
        int intValue;
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = f154044e.get(mMKVLogLevel);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        mmkvLogImp(intValue, stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private native boolean isCompareBeforeSetEnabled();

    @FastNative
    private native boolean isEncryptionEnabled();

    @FastNative
    private native boolean isExpirationEnabled();

    public static native boolean isFileValid(String str, @Nullable String str2);

    private static native void jniInitialize(String str, String str2, int i3, boolean z16);

    private static void mmkvLogImp(int i3, String str, int i16, String str2, String str3) {
        com.tencent.mmkv.b bVar = E;
        if (bVar != null && G) {
            bVar.mmkvLog(f154045f[i3], str, i16, str2, str3);
            return;
        }
        int i17 = a.f154049a[f154045f[i3].ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 == 5) {
                        Log.i("MMKV", str3);
                        return;
                    }
                    return;
                }
                Log.e("MMKV", str3);
                return;
            }
            Log.w("MMKV", str3);
            return;
        }
        Log.d("MMKV", str3);
    }

    private static boolean modeCheckImp(String str, int i3) {
        c cVar = F;
        if (cVar != null && H) {
            return cVar.modeCheck(str, i3);
        }
        return true;
    }

    @FastNative
    private native void nativeEnableCompareBeforeSet();

    private static void onContentChangedByOuterProcess(String str) {
        com.tencent.mmkv.a aVar = I;
        if (aVar != null) {
            aVar.onContentChangedByOuterProcess(str);
        }
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        com.tencent.mmkv.b bVar = E;
        if (bVar != null) {
            mMKVRecoverStrategic = bVar.onMMKVCRCCheckFail(str);
        }
        h0(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f154043d.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        com.tencent.mmkv.b bVar = E;
        if (bVar != null) {
            mMKVRecoverStrategic = bVar.onMMKVFileLengthError(str);
        }
        h0(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f154043d.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    private native void removeValueForKey(long j3, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, @Nullable String str3);

    private static native void setCallbackHandler(boolean z16, boolean z17);

    public static native void setLoadOnNecessaryEnable(boolean z16);

    private static native void setLogLevel(int i3);

    public static native void setSharedLockFirstWhenReload(boolean z16);

    private static native void setWantModeCheck(boolean z16);

    private static native void setWantsContentChangeNotify(boolean z16);

    private native void sync(boolean z16);

    private native long totalSize(long j3);

    public static MMKV u() throws RuntimeException {
        if (f154047i != null) {
            return b(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV v(int i3, @Nullable String str) throws RuntimeException {
        if (f154047i != null) {
            return b(getDefaultMMKV(i3, str), "DefaultMMKV", i3);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private native int valueSize(long j3, String str, boolean z16);

    public static native String version();

    public static void w() {
        synchronized (f154046h) {
            C = false;
        }
        Log.i("MMKV", "Disable checkProcessMode()");
    }

    private native int writeValueToNB(long j3, String str, long j16, int i3);

    private static String x(String str, String str2, b bVar, MMKVLogLevel mMKVLogLevel, boolean z16) {
        if (f154048m.compareAndSet(false, true)) {
            if (bVar != null) {
                bVar.loadLibrary("mmkv");
            } else {
                System.loadLibrary("mmkv");
            }
            jniInitialize(str, str2, X(mMKVLogLevel), z16);
            f154047i = str;
        } else {
            h0(MMKVLogLevel.LevelWarning, "doInitialize already inited");
        }
        return f154047i;
    }

    public static void y() {
        synchronized (f154046h) {
            C = true;
        }
        Log.i("MMKV", "Enable checkProcessMode()");
    }

    public boolean A(String str, double d16, int i3) {
        return encodeDouble_2(this.nativeHandle, str, d16, i3);
    }

    public boolean B(String str, float f16) {
        return encodeFloat(this.nativeHandle, str, f16);
    }

    public boolean C(String str, float f16, int i3) {
        return encodeFloat_2(this.nativeHandle, str, f16, i3);
    }

    public boolean D(String str, int i3) {
        return encodeInt(this.nativeHandle, str, i3);
    }

    public boolean E(String str, int i3, int i16) {
        return encodeInt_2(this.nativeHandle, str, i3, i16);
    }

    public boolean F(String str, long j3) {
        return encodeLong(this.nativeHandle, str, j3);
    }

    public boolean G(String str, long j3, int i3) {
        return encodeLong_2(this.nativeHandle, str, j3, i3);
    }

    public boolean H(String str, @Nullable Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, null);
        }
        return encodeBytes(this.nativeHandle, str, R(parcelable));
    }

    public boolean I(String str, @Nullable Parcelable parcelable, int i3) {
        if (parcelable == null) {
            return encodeBytes_2(this.nativeHandle, str, null, i3);
        }
        return encodeBytes_2(this.nativeHandle, str, R(parcelable), i3);
    }

    public boolean J(String str, @Nullable String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean K(String str, @Nullable String str2, int i3) {
        return encodeString_2(this.nativeHandle, str, str2, i3);
    }

    public boolean L(String str, @Nullable Set<String> set) {
        String[] strArr;
        long j3 = this.nativeHandle;
        if (set == null) {
            strArr = null;
        } else {
            strArr = (String[]) set.toArray(new String[0]);
        }
        return encodeSet(j3, str, strArr);
    }

    public boolean M(String str, @Nullable Set<String> set, int i3) {
        String[] strArr;
        long j3 = this.nativeHandle;
        if (set == null) {
            strArr = null;
        } else {
            strArr = (String[]) set.toArray(new String[0]);
        }
        return encodeSet_2(j3, str, strArr, i3);
    }

    public boolean N(String str, boolean z16) {
        return encodeBool(this.nativeHandle, str, z16);
    }

    public boolean O(String str, boolean z16, int i3) {
        return encodeBool_2(this.nativeHandle, str, z16, i3);
    }

    public boolean P(String str, @Nullable byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    public boolean Q(String str, @Nullable byte[] bArr, int i3) {
        return encodeBytes_2(this.nativeHandle, str, bArr, i3);
    }

    public int S(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    if (value instanceof Boolean) {
                        encodeBool(this.nativeHandle, key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        encodeInt(this.nativeHandle, key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        encodeLong(this.nativeHandle, key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        encodeFloat(this.nativeHandle, key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        encodeDouble(this.nativeHandle, key, ((Double) value).doubleValue());
                    } else if (value instanceof String) {
                        encodeString(this.nativeHandle, key, (String) value);
                    } else if (value instanceof Set) {
                        L(key, (Set) value);
                    } else {
                        h0(MMKVLogLevel.LevelError, "unknown type: " + value.getClass());
                    }
                }
            }
            return all.size();
        }
        return 0;
    }

    public void a() {
        sync(false);
    }

    public long actualSize() {
        return actualSize(this.nativeHandle);
    }

    @Nullable
    public String[] allKeys() {
        return allKeys(this.nativeHandle, false);
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean c(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return c(str);
    }

    public long count() {
        return count(this.nativeHandle, false);
    }

    @Nullable
    public native String cryptKey();

    public boolean d(String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    public boolean e(String str, boolean z16) {
        return decodeBool(this.nativeHandle, str, z16);
    }

    public native boolean enableAutoKeyExpire(int i3);

    @Nullable
    public byte[] f(String str) {
        return g(str, null);
    }

    public void f0(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    @Nullable
    public byte[] g(String str, @Nullable byte[] bArr) {
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        if (decodeBytes != null) {
            return decodeBytes;
        }
        return bArr;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z16) {
        return decodeBool(this.nativeHandle, str, z16);
    }

    public byte[] getBytes(String str, @Nullable byte[] bArr) {
        return g(str, bArr);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f16) {
        return decodeFloat(this.nativeHandle, str, f16);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i3) {
        return decodeInt(this.nativeHandle, str, i3);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j3) {
        return decodeLong(this.nativeHandle, str, j3);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return s(str, set);
    }

    public int getValueActualSize(String str) {
        return valueSize(this.nativeHandle, str, true);
    }

    public int getValueSize(String str) {
        return valueSize(this.nativeHandle, str, false);
    }

    public double h(String str, double d16) {
        return decodeDouble(this.nativeHandle, str, d16);
    }

    public float i(String str, float f16) {
        return decodeFloat(this.nativeHandle, str, f16);
    }

    public void i0() {
        sync(true);
    }

    public int j(String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public int k(String str, int i3) {
        return decodeInt(this.nativeHandle, str, i3);
    }

    public long l(String str) {
        return decodeLong(this.nativeHandle, str, 0L);
    }

    public native void lock();

    public long m(String str, long j3) {
        return decodeLong(this.nativeHandle, str, j3);
    }

    public native String mmapID();

    @Nullable
    public <T extends Parcelable> T n(String str, Class<T> cls) {
        return (T) o(str, cls, null);
    }

    @Nullable
    public <T extends Parcelable> T o(String str, Class<T> cls, @Nullable T t16) {
        Parcelable.Creator<?> creator;
        if (cls == null) {
            return t16;
        }
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        if (decodeBytes == null) {
            return t16;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decodeBytes, 0, decodeBytes.length);
        obtain.setDataPosition(0);
        try {
            String cls2 = cls.toString();
            HashMap<String, Parcelable.Creator<?>> hashMap = D;
            synchronized (hashMap) {
                creator = hashMap.get(cls2);
                if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                    hashMap.put(cls2, creator);
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(obtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + cls2);
        } catch (Exception e16) {
            h0(MMKVLogLevel.LevelError, e16.toString());
            return t16;
        } finally {
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    @Nullable
    public String p(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z16) {
        encodeBool(this.nativeHandle, str, z16);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f16) {
        encodeFloat(this.nativeHandle, str, f16);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i3) {
        encodeInt(this.nativeHandle, str, i3);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j3) {
        encodeLong(this.nativeHandle, str, j3);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        L(str, set);
        return this;
    }

    @Nullable
    public String q(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Nullable
    public Set<String> r(String str) {
        return s(str, null);
    }

    public native boolean reKey(@Nullable String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        f0(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    @Nullable
    public Set<String> s(String str, @Nullable Set<String> set) {
        return t(str, set, HashSet.class);
    }

    @Nullable
    public Set<String> t(String str, @Nullable Set<String> set, Class<? extends Set> cls) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set<String> newInstance = cls.newInstance();
            newInstance.addAll(Arrays.asList(decodeStringSet));
            return newInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public boolean z(String str, double d16) {
        return encodeDouble(this.nativeHandle, str, d16);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }
}
