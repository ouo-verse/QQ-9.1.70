package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class VideoDrawableHandler implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static int L;
    public static int M;
    public static int N;
    public static int P;
    Handler C;
    long D;
    long E;
    boolean F;
    private String G;
    final Object H;
    private Bitmap I;
    a J;
    private AppInterface K;

    /* renamed from: d, reason: collision with root package name */
    Vector<WeakReference<com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a>> f200086d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f200087e;

    /* renamed from: f, reason: collision with root package name */
    Bitmap f200088f;

    /* renamed from: h, reason: collision with root package name */
    MediaMetadataRetriever f200089h;

    /* renamed from: i, reason: collision with root package name */
    LinkedList<DecodeFrameTask> f200090i;

    /* renamed from: m, reason: collision with root package name */
    boolean f200091m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class DecodeFrameTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f200092d;

        public DecodeFrameTask(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoDrawableHandler.this, i3);
            } else {
                this.f200092d = i3;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        @TargetApi(10)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i3;
            a aVar;
            VideoDrawableHandler videoDrawableHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Bitmap f16 = VideoDrawableHandler.this.f(this.f200092d);
            if (f16 == null) {
                f16 = VideoDrawableHandler.this.I;
                if (f16 == null) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
            } else {
                i3 = 0;
            }
            if (f16 != null) {
                VideoDrawableHandler videoDrawableHandler2 = VideoDrawableHandler.this;
                if (videoDrawableHandler2.f200087e != f16) {
                    synchronized (videoDrawableHandler2.H) {
                        videoDrawableHandler = VideoDrawableHandler.this;
                        videoDrawableHandler.f200088f = videoDrawableHandler.f200087e;
                        videoDrawableHandler.f200087e = f16;
                    }
                    videoDrawableHandler.C.obtainMessage(0, 0, 0).sendToTarget();
                    aVar = VideoDrawableHandler.this.J;
                    if (aVar != null) {
                        aVar.U1(this.f200092d, i3);
                    }
                    if (!QLog.isColorLevel()) {
                        QLog.i("VideoDrawableHandler", 2, "task run at:" + this.f200092d + " bmp:" + VideoDrawableHandler.this.f200087e);
                        return;
                    }
                    return;
                }
            }
            VideoDrawableHandler.this.C.obtainMessage(0, 1, 0).sendToTarget();
            aVar = VideoDrawableHandler.this.J;
            if (aVar != null) {
            }
            if (!QLog.isColorLevel()) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void U1(int i3, int i16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70971);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        L = 0;
        M = 1;
        N = 2;
        P = 4;
    }

    public VideoDrawableHandler(AppInterface appInterface, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) aVar);
            return;
        }
        this.f200086d = new Vector<>();
        this.f200090i = new LinkedList<>();
        this.f200091m = true;
        this.C = new Handler(Looper.getMainLooper(), this);
        this.D = 0L;
        this.E = 0L;
        this.F = true;
        this.H = new Object();
        this.K = appInterface;
        this.J = aVar;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0098: MOVE (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:153), block:B:108:0x0098 */
    public static Bitmap d(String str) {
        Object obj;
        Class<?> cls;
        Object obj2;
        Bitmap bitmap;
        Object obj3 = null;
        try {
            try {
                try {
                    cls = Class.forName("android.media.MediaMetadataRetriever");
                    try {
                        obj2 = cls.newInstance();
                    } catch (ClassNotFoundException e16) {
                        e = e16;
                        obj2 = null;
                    } catch (IllegalAccessException e17) {
                        e = e17;
                        obj2 = null;
                    } catch (IllegalArgumentException unused) {
                        obj2 = null;
                    } catch (InstantiationException e18) {
                        e = e18;
                        obj2 = null;
                    } catch (NoSuchMethodException e19) {
                        e = e19;
                        obj2 = null;
                    } catch (RuntimeException unused2) {
                        obj2 = null;
                    } catch (InvocationTargetException e26) {
                        e = e26;
                        obj2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (obj3 != null) {
                            try {
                                cls.getMethod("release", new Class[0]).invoke(obj3, new Object[0]);
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (ClassNotFoundException e27) {
                    e = e27;
                    cls = null;
                    obj2 = null;
                } catch (IllegalAccessException e28) {
                    e = e28;
                    cls = null;
                    obj2 = null;
                } catch (IllegalArgumentException unused4) {
                    cls = null;
                    obj2 = null;
                } catch (InstantiationException e29) {
                    e = e29;
                    cls = null;
                    obj2 = null;
                } catch (NoSuchMethodException e36) {
                    e = e36;
                    cls = null;
                    obj2 = null;
                } catch (RuntimeException unused5) {
                    cls = null;
                    obj2 = null;
                } catch (InvocationTargetException e37) {
                    e = e37;
                    cls = null;
                    obj2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    cls = null;
                }
                try {
                    cls.getMethod("setDataSource", String.class).invoke(obj2, str);
                    byte[] bArr = (byte[]) cls.getMethod("getEmbeddedPicture", new Class[0]).invoke(obj2, new Object[0]);
                    if (bArr != null) {
                        try {
                            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        } catch (OutOfMemoryError e38) {
                            if (QLog.isColorLevel()) {
                                QLog.i("VideoDrawableHandler", 2, e38.getMessage(), e38);
                            }
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            if (obj2 != null) {
                                try {
                                    cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                                } catch (Exception unused6) {
                                }
                            }
                            return bitmap;
                        }
                    }
                    Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
                    if (createVideoThumbnail != null) {
                        if (obj2 != null) {
                            try {
                                cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                            } catch (Exception unused7) {
                            }
                        }
                        return createVideoThumbnail;
                    }
                    Bitmap bitmap2 = (Bitmap) cls.getMethod("getFrameAtTime", new Class[0]).invoke(obj2, new Object[0]);
                    if (obj2 != null) {
                        try {
                            cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                        } catch (Exception unused8) {
                        }
                    }
                    return bitmap2;
                } catch (ClassNotFoundException e39) {
                    e = e39;
                    Log.e("VideoDrawableHandler", "createVideoThumbnail", e);
                    if (obj2 != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    return null;
                } catch (IllegalAccessException e46) {
                    e = e46;
                    Log.e("VideoDrawableHandler", "createVideoThumbnail", e);
                    if (obj2 != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    return null;
                } catch (IllegalArgumentException unused9) {
                    if (obj2 != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    return null;
                } catch (InstantiationException e47) {
                    e = e47;
                    Log.e("VideoDrawableHandler", "createVideoThumbnail", e);
                    if (obj2 != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    return null;
                } catch (NoSuchMethodException e48) {
                    e = e48;
                    Log.e("VideoDrawableHandler", "createVideoThumbnail", e);
                    if (obj2 != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    return null;
                } catch (RuntimeException unused10) {
                    if (obj2 != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    return null;
                } catch (InvocationTargetException e49) {
                    e = e49;
                    Log.e("VideoDrawableHandler", "createVideoThumbnail", e);
                    if (obj2 != null) {
                        cls.getMethod("release", new Class[0]).invoke(obj2, new Object[0]);
                    }
                    return null;
                }
            } catch (Exception unused11) {
                return null;
            }
        } catch (Throwable th7) {
            th = th7;
            obj3 = obj;
        }
    }

    private void l() {
        DecodeFrameTask poll;
        if (this.f200091m && (poll = this.f200090i.poll()) != null) {
            this.f200091m = false;
            ThreadManagerV2.postImmediately(poll, null, true);
        }
    }

    public void b(com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.H) {
            if (!this.f200086d.contains(aVar)) {
                this.f200086d.add(new WeakReference<>(aVar));
            }
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        synchronized (this.H) {
            this.f200090i.clear();
        }
    }

    @TargetApi(10)
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        c();
        this.C.removeCallbacksAndMessages(null);
        MediaMetadataRetriever mediaMetadataRetriever = this.f200089h;
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
            this.f200089h = null;
        }
    }

    @TargetApi(10)
    public Bitmap f(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        Bitmap bitmap;
        int i26;
        boolean z16;
        boolean z17;
        boolean z18;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        long j3 = i3 + this.E;
        MediaMetadataRetriever mediaMetadataRetriever = this.f200089h;
        Bitmap bitmap2 = null;
        if (mediaMetadataRetriever == null) {
            return null;
        }
        if (this.I != null) {
            i16 = P | 0;
        } else {
            i16 = 0;
        }
        int i28 = 3;
        if (this.F) {
            i17 = 2;
        } else {
            i17 = 3;
        }
        if (L < 3) {
            try {
                bitmap2 = mediaMetadataRetriever.getFrameAtTime(j3 * 1000, i17);
                if (bitmap2 == null) {
                    i27 = 1;
                } else {
                    i27 = 0;
                }
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("VideoDrawableHandler", 2, e16.getMessage(), e16);
                }
                i27 = 3;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.i("VideoDrawableHandler", 2, th5.getMessage(), th5);
                }
                i27 = 2;
            }
            if (bitmap2 != null) {
                i16 |= M;
            }
            i18 = i16;
            i19 = 1;
            bitmap = bitmap2;
            i26 = i27;
        } else {
            i18 = i16;
            i19 = 1;
            bitmap = null;
            i26 = 0;
        }
        if (i26 == i19 || i26 == 2) {
            L += i19;
        }
        if (bitmap == null && i26 != 3) {
            try {
                bitmap = this.f200089h.getFrameAtTime(1000 * j3, i17);
                i28 = bitmap == null ? 1 : 0;
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("VideoDrawableHandler", 2, e17.getMessage(), e17);
                }
            } catch (Throwable th6) {
                if (QLog.isColorLevel()) {
                    QLog.i("VideoDrawableHandler", 2, th6.getMessage(), th6);
                }
                i28 = 2;
            }
            if (bitmap != null) {
                i18 |= N;
            }
        } else {
            i28 = 0;
        }
        int i29 = (i28 << 2) | i26;
        if (bitmap == null) {
            z16 = true;
            QLog.i("VideoDrawableHandler", 1, "getBitmapAt at:" + j3 + " status:" + i18 + " errorReason:" + i29);
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getBitmapAt ");
            sb5.append(j3);
            sb5.append(" failCount:");
            sb5.append(L);
            sb5.append(" bmp!=null:");
            if (bitmap != null) {
                z18 = z16;
            } else {
                z18 = false;
            }
            sb5.append(z18);
            sb5.append(" status:");
            sb5.append(i18);
            sb5.append(" errorReason:");
            sb5.append(i29);
            QLog.i("VideoDrawableHandler", 2, sb5.toString());
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_DeviceType", ah.u() + "");
        hashMap.put("param_ErrorArbitary", i26 + "");
        hashMap.put("param_ErrorKey", i28 + "");
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        String currentAccountUin = this.K.getCurrentAccountUin();
        if (bitmap != null) {
            z17 = z16;
        } else {
            z17 = false;
        }
        statisticCollector.collectPerformance(currentAccountUin, "CMD_EXTRACT_FRAME", z17, i18, i29, hashMap, "");
        return bitmap;
    }

    public Bitmap g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.I;
    }

    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.D;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 0) {
            int i3 = message.arg1;
            synchronized (this.H) {
                if (i3 == 0) {
                    k();
                    Bitmap bitmap2 = this.f200088f;
                    if (bitmap2 != null && !bitmap2.isRecycled() && (bitmap = this.f200088f) != this.f200087e && bitmap != this.I) {
                        bitmap.recycle();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("VideoDrawableHandler", 2, "refresh. pending task size:" + this.f200090i.size());
                    }
                }
                this.f200091m = true;
                l();
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f8  */
    @TargetApi(10)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(String str, long j3, long j16, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16))).booleanValue();
        }
        this.F = z16;
        try {
            MediaMetadataRetriever mediaMetadataRetriever = this.f200089h;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
            this.f200089h = mediaMetadataRetriever2;
            mediaMetadataRetriever2.setDataSource(str);
            long longValue = Long.valueOf(this.f200089h.extractMetadata(9)).longValue();
            this.D = longValue;
            if (longValue > j3 && j3 >= 0 && j16 >= 0) {
                if (longValue < j3 + j16) {
                    this.D = longValue - j3;
                } else {
                    this.D = j16;
                }
                this.E = j3;
            }
            if (QLog.isColorLevel()) {
                QLog.i("VideoDrawableHandler", 2, "duration:" + this.D);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("VideoDrawableHandler", 2, e16.getMessage(), e16);
            }
        }
        if (this.D > 0) {
            z17 = true;
            if (QLog.isColorLevel()) {
                QLog.i("VideoDrawableHandler", 2, "init suc:" + z17 + " path:" + str);
            }
            if (z17) {
                this.G = str;
                this.I = d(str);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("init suc:");
            sb5.append(z17);
            sb5.append(" thumb!=Null:");
            if (this.I != null) {
                z18 = true;
            }
            sb5.append(z18);
            sb5.append(" path:");
            sb5.append(str);
            QLog.i("VideoDrawableHandler", 1, sb5.toString());
            return z17;
        }
        z17 = false;
        if (QLog.isColorLevel()) {
        }
        if (z17) {
        }
        StringBuilder sb52 = new StringBuilder();
        sb52.append("init suc:");
        sb52.append(z17);
        sb52.append(" thumb!=Null:");
        if (this.I != null) {
        }
        sb52.append(z18);
        sb52.append(" path:");
        sb52.append(str);
        QLog.i("VideoDrawableHandler", 1, sb52.toString());
        return z17;
    }

    public void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        DecodeFrameTask decodeFrameTask = new DecodeFrameTask(i3);
        synchronized (this.H) {
            this.f200090i.add(decodeFrameTask);
            if (this.f200090i.size() > 2) {
                this.f200090i.removeFirst();
            }
            l();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.f200086d.size(); i3++) {
            WeakReference<com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.a> weakReference = this.f200086d.get(i3);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().c(this.f200087e);
            }
        }
    }
}
