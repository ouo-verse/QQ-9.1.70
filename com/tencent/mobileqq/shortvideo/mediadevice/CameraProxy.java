package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes18.dex */
public class CameraProxy implements Camera.PreviewCallback, Camera2Control.i {

    /* renamed from: c0, reason: collision with root package name */
    private static HandlerThread f288133c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final Object f288134d0 = new Object();
    public final c K;
    public final CameraPreviewObservable L;
    public CameraExceptionHandler M;
    private int[] V;
    private int[] W;
    private Camera.FaceDetectionListener X;

    /* renamed from: b0, reason: collision with root package name */
    private e f288136b0;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f288137d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f288138e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f288139f = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f288140h = 0;

    /* renamed from: i, reason: collision with root package name */
    g f288141i = new g();

    /* renamed from: m, reason: collision with root package name */
    public g f288142m = new g();
    public g C = new g();
    g D = new g();
    g E = new g();
    g F = new g();
    g G = new g();
    g H = new g();
    public Map<String, g> I = new HashMap();
    public Map<String, h> J = new HashMap();
    private int N = Integer.MAX_VALUE;
    private String P = "";
    private String[] Q = null;
    private String R = null;
    private String S = null;
    private boolean T = false;
    private boolean U = false;
    private boolean Y = false;
    private volatile boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f288135a0 = false;

    /* loaded from: classes18.dex */
    public static class CameraPreviewObservable extends yq2.b {

        /* renamed from: c, reason: collision with root package name */
        public Handler f288143c;

        public CameraPreviewObservable(Handler handler) {
            if (handler != null) {
                this.f288143c = handler;
            } else {
                this.f288143c = new Handler(Looper.getMainLooper());
            }
        }

        @Override // yq2.b
        public void c(final int i3, final Object... objArr) {
            Handler handler = this.f288143c;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraPreviewObservable.super.c(i3, objArr);
                }
            });
        }
    }

    /* loaded from: classes18.dex */
    public static class WaitDoneBundle {

        /* renamed from: b, reason: collision with root package name */
        public final Object f288147b = new Object();

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f288146a = new Runnable() { // from class: com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (WaitDoneBundle.this.f288147b) {
                    WaitDoneBundle.this.f288147b.notifyAll();
                }
            }
        };

        WaitDoneBundle() {
        }

        static void a(Message message) {
            if (message == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof WaitDoneBundle) {
                ((WaitDoneBundle) obj).f288146a.run();
            }
        }
    }

    /* loaded from: classes18.dex */
    class b implements Camera.AutoFocusCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f288150d;

        b(d dVar) {
            this.f288150d = dVar;
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            this.f288150d.a(z16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class c extends Handler implements Camera.AutoFocusCallback {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes18.dex */
        public class a implements Camera.AutoFocusCallback {
            a() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z16, Camera camera2) {
                if (QLog.isColorLevel()) {
                    QLog.i("CameraProxy", 2, "Request Focus onAutoFocus");
                }
            }
        }

        c(Looper looper) {
            super(looper);
        }

        @TargetApi(14)
        private void c(Rect rect, Rect rect2, Camera.AutoFocusCallback autoFocusCallback) {
            if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
            }
            Camera.Parameters o16 = CameraControl.u().o();
            if (rect != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("CameraProxy", 2, "[handleMessage] focus area = " + rect);
                }
                o16.setFocusMode("auto");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(rect, 1000));
                o16.setFocusAreas(arrayList);
                if (o16.getMaxNumMeteringAreas() > 0 && rect2 != null) {
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(new Camera.Area(new Rect(rect2), 1000));
                    o16.setMeteringAreas(arrayList2);
                }
                CameraControl.u().f288082c.setParameters(o16);
            }
            if (autoFocusCallback == null) {
                autoFocusCallback = new a();
            }
            CameraControl.u().j(autoFocusCallback);
        }

        public String a() {
            if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
            }
            Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
            return "continuous-picture";
        }

        public String b() {
            if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[@] getRecordingFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
            }
            if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
                return "continuous-picture";
            }
            return "continuous-video";
        }

        /* JADX WARN: Removed duplicated region for block: B:370:0x0b5f A[Catch: all -> 0x0d25, Exception -> 0x0d29, TRY_LEAVE, TryCatch #1 {Exception -> 0x0d29, blocks: (B:41:0x007c, B:42:0x0095, B:44:0x0096, B:46:0x009c, B:47:0x00a2, B:50:0x00ab, B:51:0x00b4, B:52:0x00c1, B:53:0x00d0, B:54:0x00e7, B:56:0x00ff, B:57:0x0104, B:59:0x010e, B:62:0x0118, B:64:0x0122, B:66:0x0148, B:68:0x014e, B:69:0x0154, B:71:0x0164, B:72:0x0174, B:74:0x017e, B:76:0x0186, B:77:0x018b, B:80:0x0194, B:81:0x0197, B:83:0x01a1, B:85:0x01a7, B:86:0x01ad, B:87:0x01c0, B:89:0x01c8, B:91:0x01ce, B:92:0x01e5, B:94:0x0202, B:96:0x020a, B:97:0x021e, B:99:0x0224, B:100:0x022a, B:103:0x0235, B:105:0x023f, B:107:0x024f, B:109:0x0255, B:110:0x025b, B:112:0x0269, B:113:0x0279, B:115:0x027f, B:116:0x0285, B:118:0x0293, B:119:0x02a3, B:121:0x02a9, B:122:0x02af, B:124:0x02bd, B:125:0x02d3, B:126:0x02e2, B:128:0x02e8, B:129:0x02ee, B:131:0x02f8, B:132:0x030e, B:134:0x0314, B:135:0x031a, B:137:0x0328, B:139:0x0332, B:141:0x033c, B:142:0x0352, B:144:0x0358, B:145:0x036f, B:147:0x0379, B:149:0x0381, B:151:0x0385, B:153:0x038b, B:154:0x03a2, B:156:0x03a6, B:158:0x03b6, B:159:0x03bb, B:161:0x03c1, B:162:0x03d8, B:164:0x03dc, B:166:0x03e5, B:167:0x03ec, B:169:0x03f2, B:170:0x03f8, B:172:0x03fc, B:174:0x0406, B:176:0x0416, B:178:0x0420, B:179:0x042e, B:181:0x0434, B:182:0x043a, B:184:0x043e, B:186:0x0448, B:188:0x045b, B:190:0x0465, B:192:0x0475, B:194:0x047f, B:195:0x048d, B:199:0x04c5, B:201:0x04ca, B:202:0x04e9, B:203:0x04fa, B:204:0x050b, B:205:0x0520, B:206:0x0535, B:208:0x053b, B:209:0x0541, B:210:0x054a, B:212:0x0550, B:213:0x0556, B:215:0x055e, B:218:0x056d, B:219:0x058f, B:221:0x05c6, B:222:0x05ea, B:224:0x05f6, B:225:0x0602, B:227:0x060a, B:229:0x0614, B:231:0x062f, B:233:0x0632, B:234:0x0639, B:236:0x0660, B:239:0x0672, B:241:0x067c, B:244:0x068e, B:246:0x06a1, B:249:0x06b3, B:250:0x06db, B:252:0x0621, B:253:0x06bf, B:255:0x06c9, B:258:0x06fa, B:259:0x070b, B:260:0x0720, B:262:0x0726, B:263:0x072c, B:265:0x073e, B:267:0x0744, B:270:0x074e, B:272:0x0752, B:275:0x0761, B:276:0x0772, B:278:0x079e, B:279:0x07cc, B:281:0x0808, B:282:0x0814, B:284:0x081c, B:286:0x0826, B:290:0x083d, B:291:0x0856, B:293:0x085e, B:295:0x086a, B:299:0x0890, B:300:0x0893, B:302:0x089d, B:305:0x08b2, B:307:0x08d0, B:308:0x08d5, B:309:0x0916, B:311:0x0924, B:313:0x092e, B:315:0x0938, B:316:0x094e, B:318:0x0958, B:321:0x096d, B:323:0x084a, B:324:0x08ed, B:326:0x08f7, B:329:0x0909, B:331:0x090f, B:332:0x099e, B:334:0x09a4, B:335:0x09ab, B:337:0x09c7, B:338:0x09ef, B:342:0x09f8, B:346:0x09ff, B:348:0x0a0a, B:349:0x0aa2, B:351:0x0aaa, B:353:0x0ab4, B:356:0x0ac9, B:358:0x0ad0, B:360:0x0ad7, B:363:0x0ade, B:365:0x0ae5, B:367:0x0aef, B:370:0x0b5f, B:373:0x0b83, B:375:0x0b8f, B:378:0x0ba4, B:380:0x0bab, B:382:0x0bb1, B:385:0x0bb9, B:386:0x0bbc, B:388:0x0bda, B:389:0x0bdf, B:391:0x0bf7, B:393:0x0bfe, B:395:0x0c04, B:397:0x0c0a, B:398:0x0c17, B:400:0x0c1d, B:401:0x0c20, B:402:0x0c50, B:404:0x0c5e, B:406:0x0c68, B:408:0x0c72, B:409:0x0c88, B:411:0x0c92, B:414:0x0ca7, B:416:0x0afc, B:418:0x0b02, B:420:0x0b0d, B:422:0x0b1a, B:424:0x0b30, B:425:0x0b28, B:428:0x0b3f, B:430:0x0b55, B:431:0x0c27, B:433:0x0c31, B:436:0x0c43, B:438:0x0c49, B:439:0x0a10, B:442:0x0a1a, B:444:0x0a1f, B:447:0x0a28, B:448:0x0a2e, B:451:0x0a40, B:453:0x0a47, B:455:0x0a4c, B:458:0x0a54, B:459:0x0a59, B:462:0x0a6e, B:464:0x0a74, B:466:0x0a79, B:469:0x0a81, B:470:0x0a86, B:473:0x0a98, B:475:0x0a9e, B:476:0x0cd8, B:479:0x0ced, B:481:0x0cf3, B:482:0x0cfa, B:485:0x0d08, B:486:0x0d0b, B:489:0x0d2d, B:491:0x0d46, B:492:0x0d4d, B:494:0x0d6c, B:498:0x0d81, B:501:0x0da9, B:503:0x0db3, B:506:0x0dc7), top: B:2:0x0010, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:373:0x0b83 A[Catch: all -> 0x0d25, Exception -> 0x0d29, TRY_ENTER, TryCatch #1 {Exception -> 0x0d29, blocks: (B:41:0x007c, B:42:0x0095, B:44:0x0096, B:46:0x009c, B:47:0x00a2, B:50:0x00ab, B:51:0x00b4, B:52:0x00c1, B:53:0x00d0, B:54:0x00e7, B:56:0x00ff, B:57:0x0104, B:59:0x010e, B:62:0x0118, B:64:0x0122, B:66:0x0148, B:68:0x014e, B:69:0x0154, B:71:0x0164, B:72:0x0174, B:74:0x017e, B:76:0x0186, B:77:0x018b, B:80:0x0194, B:81:0x0197, B:83:0x01a1, B:85:0x01a7, B:86:0x01ad, B:87:0x01c0, B:89:0x01c8, B:91:0x01ce, B:92:0x01e5, B:94:0x0202, B:96:0x020a, B:97:0x021e, B:99:0x0224, B:100:0x022a, B:103:0x0235, B:105:0x023f, B:107:0x024f, B:109:0x0255, B:110:0x025b, B:112:0x0269, B:113:0x0279, B:115:0x027f, B:116:0x0285, B:118:0x0293, B:119:0x02a3, B:121:0x02a9, B:122:0x02af, B:124:0x02bd, B:125:0x02d3, B:126:0x02e2, B:128:0x02e8, B:129:0x02ee, B:131:0x02f8, B:132:0x030e, B:134:0x0314, B:135:0x031a, B:137:0x0328, B:139:0x0332, B:141:0x033c, B:142:0x0352, B:144:0x0358, B:145:0x036f, B:147:0x0379, B:149:0x0381, B:151:0x0385, B:153:0x038b, B:154:0x03a2, B:156:0x03a6, B:158:0x03b6, B:159:0x03bb, B:161:0x03c1, B:162:0x03d8, B:164:0x03dc, B:166:0x03e5, B:167:0x03ec, B:169:0x03f2, B:170:0x03f8, B:172:0x03fc, B:174:0x0406, B:176:0x0416, B:178:0x0420, B:179:0x042e, B:181:0x0434, B:182:0x043a, B:184:0x043e, B:186:0x0448, B:188:0x045b, B:190:0x0465, B:192:0x0475, B:194:0x047f, B:195:0x048d, B:199:0x04c5, B:201:0x04ca, B:202:0x04e9, B:203:0x04fa, B:204:0x050b, B:205:0x0520, B:206:0x0535, B:208:0x053b, B:209:0x0541, B:210:0x054a, B:212:0x0550, B:213:0x0556, B:215:0x055e, B:218:0x056d, B:219:0x058f, B:221:0x05c6, B:222:0x05ea, B:224:0x05f6, B:225:0x0602, B:227:0x060a, B:229:0x0614, B:231:0x062f, B:233:0x0632, B:234:0x0639, B:236:0x0660, B:239:0x0672, B:241:0x067c, B:244:0x068e, B:246:0x06a1, B:249:0x06b3, B:250:0x06db, B:252:0x0621, B:253:0x06bf, B:255:0x06c9, B:258:0x06fa, B:259:0x070b, B:260:0x0720, B:262:0x0726, B:263:0x072c, B:265:0x073e, B:267:0x0744, B:270:0x074e, B:272:0x0752, B:275:0x0761, B:276:0x0772, B:278:0x079e, B:279:0x07cc, B:281:0x0808, B:282:0x0814, B:284:0x081c, B:286:0x0826, B:290:0x083d, B:291:0x0856, B:293:0x085e, B:295:0x086a, B:299:0x0890, B:300:0x0893, B:302:0x089d, B:305:0x08b2, B:307:0x08d0, B:308:0x08d5, B:309:0x0916, B:311:0x0924, B:313:0x092e, B:315:0x0938, B:316:0x094e, B:318:0x0958, B:321:0x096d, B:323:0x084a, B:324:0x08ed, B:326:0x08f7, B:329:0x0909, B:331:0x090f, B:332:0x099e, B:334:0x09a4, B:335:0x09ab, B:337:0x09c7, B:338:0x09ef, B:342:0x09f8, B:346:0x09ff, B:348:0x0a0a, B:349:0x0aa2, B:351:0x0aaa, B:353:0x0ab4, B:356:0x0ac9, B:358:0x0ad0, B:360:0x0ad7, B:363:0x0ade, B:365:0x0ae5, B:367:0x0aef, B:370:0x0b5f, B:373:0x0b83, B:375:0x0b8f, B:378:0x0ba4, B:380:0x0bab, B:382:0x0bb1, B:385:0x0bb9, B:386:0x0bbc, B:388:0x0bda, B:389:0x0bdf, B:391:0x0bf7, B:393:0x0bfe, B:395:0x0c04, B:397:0x0c0a, B:398:0x0c17, B:400:0x0c1d, B:401:0x0c20, B:402:0x0c50, B:404:0x0c5e, B:406:0x0c68, B:408:0x0c72, B:409:0x0c88, B:411:0x0c92, B:414:0x0ca7, B:416:0x0afc, B:418:0x0b02, B:420:0x0b0d, B:422:0x0b1a, B:424:0x0b30, B:425:0x0b28, B:428:0x0b3f, B:430:0x0b55, B:431:0x0c27, B:433:0x0c31, B:436:0x0c43, B:438:0x0c49, B:439:0x0a10, B:442:0x0a1a, B:444:0x0a1f, B:447:0x0a28, B:448:0x0a2e, B:451:0x0a40, B:453:0x0a47, B:455:0x0a4c, B:458:0x0a54, B:459:0x0a59, B:462:0x0a6e, B:464:0x0a74, B:466:0x0a79, B:469:0x0a81, B:470:0x0a86, B:473:0x0a98, B:475:0x0a9e, B:476:0x0cd8, B:479:0x0ced, B:481:0x0cf3, B:482:0x0cfa, B:485:0x0d08, B:486:0x0d0b, B:489:0x0d2d, B:491:0x0d46, B:492:0x0d4d, B:494:0x0d6c, B:498:0x0d81, B:501:0x0da9, B:503:0x0db3, B:506:0x0dc7), top: B:2:0x0010, outer: #0 }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            g gVar;
            CameraControl.b bVar;
            boolean b06;
            CameraControl.b L;
            boolean b07;
            CameraControl.b[] B;
            CameraControl.b[] h16;
            CameraControl.b bVar2;
            CameraControl.b bVar3;
            super.handleMessage(message);
            int i3 = message.what;
            try {
                try {
                    if (i3 == 1) {
                        ms.a.f("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
                        int intValue = ((Integer) ((Object[]) message.obj)[0]).intValue();
                        if (QLog.isColorLevel()) {
                            QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
                        }
                        int Q = CameraControl.u().Q(intValue);
                        ms.a.f("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + Q);
                        if (Q == 5) {
                            CameraProxy.this.L.c(1, Boolean.TRUE);
                            WaitDoneBundle.a(message);
                            return;
                        }
                        if (Q != 0) {
                            CameraProxy.this.L.c(1, "open camera failed:errcode=" + CameraControl.m(Q));
                            WaitDoneBundle.a(message);
                            return;
                        }
                        if (!CameraControl.u().W()) {
                            CameraProxy.this.L.c(1, "open camera failed, orientation error.");
                            WaitDoneBundle.a(message);
                        } else {
                            CameraProxy.this.L.c(1, Boolean.TRUE);
                            CameraProxy.this.f288138e = false;
                        }
                    } else if (i3 != 2) {
                        String str = "";
                        if (i3 == 6) {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
                            }
                            int parseInt = Integer.parseInt(message.obj.toString());
                            int i16 = message.arg1;
                            int i17 = message.arg2;
                            CameraProxy cameraProxy = CameraProxy.this;
                            cameraProxy.f288138e = false;
                            cameraProxy.T = false;
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[@] surfaceChanged start, format = " + parseInt + ",width = " + i16 + ",height = " + i17);
                            }
                            CameraProxy cameraProxy2 = CameraProxy.this;
                            int i18 = cameraProxy2.f288139f;
                            if (i18 > 0 && i16 > i18) {
                                i16 = i18;
                            }
                            int i19 = cameraProxy2.f288140h;
                            if (i19 > 0 && i17 > i19) {
                                i17 = i19;
                            }
                            CameraControl u16 = CameraControl.u();
                            if (CameraProxy.this.f288137d == 1) {
                                gVar = CameraProxy.this.f288141i;
                            } else if (CameraProxy.this.f288137d == 3) {
                                int i26 = com.tencent.mobileqq.activity.richmedia.c.f185845b;
                                if (i26 == 1) {
                                    gVar = CameraProxy.this.C;
                                } else if (i26 == 2) {
                                    gVar = CameraProxy.this.f288142m;
                                } else {
                                    CameraProxy.this.L.c(2, "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                            } else if (CameraProxy.this.f288137d == 2) {
                                int i27 = com.tencent.mobileqq.activity.richmedia.c.f185845b;
                                if (i27 == 1) {
                                    gVar = CameraProxy.this.E;
                                } else if (i27 == 2) {
                                    gVar = CameraProxy.this.D;
                                } else {
                                    CameraProxy.this.L.c(2, "set preview format failed[Camera Kind error:RATIO_SCREEN]");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                            } else if (CameraProxy.this.f288137d == 4) {
                                int i28 = com.tencent.mobileqq.activity.richmedia.c.f185845b;
                                if (i28 == 1) {
                                    gVar = CameraProxy.this.G;
                                } else if (i28 == 2) {
                                    gVar = CameraProxy.this.F;
                                } else {
                                    CameraProxy.this.L.c(2, "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                            } else if (CameraProxy.this.f288137d == 5) {
                                gVar = CameraProxy.this.H;
                            } else {
                                CameraProxy.this.L.c(2, "set preview format failed[Preview Selector Error]");
                                WaitDoneBundle.a(message);
                                return;
                            }
                            if (!gVar.f288161a.get()) {
                                if (!CameraControl.u().Z()) {
                                    CameraProxy.this.L.c(2, "set preview format failed");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                                if (CameraProxy.this.f288137d != 1 && CameraProxy.this.f288137d != 3 && CameraProxy.this.f288137d != 4) {
                                    if (CameraProxy.this.f288137d == 2) {
                                        CameraControl.b r16 = u16.r(CodecParam.DST_VIDEO_WIDTH, CodecParam.DST_VIDEO_HEIGHT, i16, i17);
                                        if (r16 != null) {
                                            b07 = CameraControl.u().b0(r16);
                                            b06 = b07;
                                            bVar = null;
                                            if (!b06) {
                                                CameraProxy.this.L.c(2, "set preview size failed" + str);
                                                WaitDoneBundle.a(message);
                                                return;
                                            }
                                            if (!CameraControl.u().a0(CodecParam.VIDEO_FPS)) {
                                                CameraProxy.this.L.c(2, "set preview fps failed");
                                                WaitDoneBundle.a(message);
                                                return;
                                            }
                                            if (CameraProxy.this.f288137d != 1 && CameraProxy.this.f288137d != 4 && CameraProxy.this.f288137d != 5 && bVar != null) {
                                                u16.g0(bVar);
                                            }
                                            gVar.f288162b = CameraControl.u().D();
                                            gVar.f288165e = CameraControl.u().y();
                                            CameraControl.b w3 = CameraControl.u().w();
                                            if (w3 != null) {
                                                gVar.f288167g = w3;
                                                gVar.f288166f = true;
                                            }
                                            int[] E = CameraControl.u().E();
                                            gVar.f288163c = E[0];
                                            gVar.f288164d = E[1];
                                            if (CameraProxy.this.f288137d != 1 && CameraProxy.this.f288137d != 3 && CameraProxy.this.f288137d != 4 && CameraProxy.this.f288137d != 5) {
                                                gVar.f288167g = CameraControl.u().w();
                                                gVar.f288166f = true;
                                            }
                                            if (CameraProxy.this.f288137d == 4) {
                                                gVar.f288166f = false;
                                            }
                                            gVar.f288161a.getAndSet(true);
                                        }
                                        b07 = false;
                                        b06 = b07;
                                        bVar = null;
                                        if (!b06) {
                                        }
                                    } else if (CameraProxy.this.f288137d == 5) {
                                        if (Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && DeviceInfoMonitor.getModel().equals("MI 3")) {
                                            L = new CameraControl.b();
                                            L.f288111a = 640;
                                            L.f288112b = 480;
                                        } else {
                                            L = u16.L(480);
                                        }
                                        if (L != null) {
                                            b07 = CameraControl.u().b0(L);
                                            b06 = b07;
                                            bVar = null;
                                            if (!b06) {
                                            }
                                        }
                                        b07 = false;
                                        b06 = b07;
                                        bVar = null;
                                        if (!b06) {
                                        }
                                    } else {
                                        str = " :[Preview Selector Error]";
                                        bVar = null;
                                        b06 = false;
                                        if (!b06) {
                                        }
                                    }
                                }
                                int i29 = CodecParam.DST_VIDEO_WIDTH;
                                int i36 = CodecParam.DST_VIDEO_HEIGHT;
                                CameraProxy cameraProxy3 = CameraProxy.this;
                                CameraControl.b[] z16 = u16.z(i29, i36, cameraProxy3.f288139f, cameraProxy3.f288140h);
                                CameraControl.b bVar4 = z16[0];
                                bVar = z16[1];
                                if (bVar4 != null) {
                                    b06 = CameraControl.u().b0(bVar4);
                                    if (!b06) {
                                    }
                                }
                                b06 = false;
                                if (!b06) {
                                }
                            } else if (!CameraControl.u().U(gVar)) {
                                CameraProxy.this.L.c(2, "set Camera Params failed");
                                WaitDoneBundle.a(message);
                                return;
                            } else if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
                            }
                            if (!CameraControl.u().Y(a()) && !CameraControl.u().Y("auto") && !CameraControl.u().j(this)) {
                                CameraProxy.this.L.c(9, HardCodeUtil.qqStr(R.string.f171687k73));
                            }
                            if (!CameraControl.u().W()) {
                                CameraProxy.this.L.c(2, "set display orientation failed");
                                WaitDoneBundle.a(message);
                            } else {
                                CameraProxy.this.L.c(2, CameraControl.u().y(), Integer.valueOf(CameraControl.u().D()), CameraControl.u().E());
                            }
                        } else if (i3 == 7) {
                            Object[] objArr = (Object[]) message.obj;
                            CameraControl.b bVar5 = (CameraControl.b) objArr[0];
                            CameraControl.b bVar6 = (CameraControl.b) objArr[1];
                            int intValue2 = ((Integer) objArr[2]).intValue();
                            int intValue3 = ((Integer) objArr[3]).intValue();
                            boolean booleanValue = ((Boolean) objArr[4]).booleanValue();
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + bVar5 + " , viewSize = " + bVar6 + " , selectMode = " + intValue2 + " , resolutionMode = " + booleanValue);
                            }
                            CameraProxy cameraProxy4 = CameraProxy.this;
                            cameraProxy4.f288138e = false;
                            cameraProxy4.T = false;
                            CameraControl u17 = CameraControl.u();
                            String str2 = CameraControl.u().f288084e + "#" + bVar5 + "#" + bVar6 + "#" + intValue2;
                            g gVar2 = CameraProxy.this.I.get(str2);
                            if (gVar2 == null) {
                                gVar2 = new g();
                                CameraProxy.this.I.put(str2, gVar2);
                            }
                            if (!gVar2.f288161a.get()) {
                                if (!CameraControl.u().Z()) {
                                    CameraProxy.this.L.c(2, "set preview format failed");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                                if (!booleanValue) {
                                    B = u17.A(bVar5.f288111a, bVar5.f288112b, bVar6.f288111a, bVar6.f288112b);
                                } else {
                                    B = u17.B(bVar5.f288111a, bVar5.f288112b, bVar6.f288111a, bVar6.f288112b);
                                }
                                CameraControl.b bVar7 = B[0];
                                CameraControl.b bVar8 = B[1];
                                if (!(bVar7 != null ? CameraControl.u().b0(bVar7) : false)) {
                                    CameraProxy.this.L.c(2, "set preview size failed");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                                if (bVar8 != null) {
                                    u17.g0(bVar8);
                                }
                                if (!CameraControl.u().a0(intValue3)) {
                                    CameraProxy.this.L.c(2, "set preview fps failed");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                                gVar2.f288162b = CameraControl.u().D();
                                gVar2.f288165e = CameraControl.u().y();
                                CameraControl.b w16 = CameraControl.u().w();
                                if (w16 != null) {
                                    gVar2.f288167g = w16;
                                    gVar2.f288166f = true;
                                }
                                int[] E2 = CameraControl.u().E();
                                gVar2.f288163c = E2[0];
                                gVar2.f288164d = E2[1];
                                gVar2.f288161a.getAndSet(true);
                            } else if (!CameraControl.u().U(gVar2)) {
                                CameraProxy.this.L.c(2, "set Camera Params failed");
                                WaitDoneBundle.a(message);
                                return;
                            } else if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
                            }
                            if (!CameraControl.u().Y(a()) && !CameraControl.u().Y("auto") && !CameraControl.u().j(this)) {
                                CameraProxy.this.L.c(9, HardCodeUtil.qqStr(R.string.f171684k70));
                            }
                            if (!CameraControl.u().W()) {
                                CameraProxy.this.L.c(2, "set display orientation failed");
                                WaitDoneBundle.a(message);
                            } else {
                                CameraProxy.this.L.c(2, CameraControl.u().y(), Integer.valueOf(CameraControl.u().D()), CameraControl.u().E());
                            }
                        } else if (i3 == 301) {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
                            }
                            com.tencent.mobileqq.activity.richmedia.f.c("received");
                            i iVar = (i) message.obj;
                            CameraControl u18 = CameraControl.u();
                            if (!u18.f288090k) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
                                }
                                WaitDoneBundle.a(message);
                            } else {
                                File file = iVar.f288172a;
                                if (file == null) {
                                    CameraProxy.this.L.c(2, "take picture error");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                                u18.p0(file, iVar.f288173b, iVar.f288174c, iVar.f288175d, iVar.f288176e, iVar.f288177f);
                            }
                        } else if (i3 == 601) {
                            CameraControl.u().c0(((Integer) ((Object[]) message.obj)[0]).intValue());
                        } else if (i3 == 701) {
                            CameraControl.u().h0((String) ((Object[]) message.obj)[0]);
                        } else if (i3 == 1005) {
                            Object[] objArr2 = (Object[]) message.obj;
                            CameraControl.b bVar9 = (CameraControl.b) objArr2[0];
                            CameraControl.b bVar10 = (CameraControl.b) objArr2[1];
                            boolean booleanValue2 = ((Boolean) objArr2[4]).booleanValue();
                            StringBuilder sb5 = new StringBuilder();
                            Camera2Control.J();
                            sb5.append(Camera2Control.T);
                            sb5.append("#");
                            sb5.append(bVar9);
                            sb5.append("#");
                            sb5.append(bVar10);
                            String sb6 = sb5.toString();
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + bVar9 + " , viewSize = " + bVar10 + ",resolutionMode:" + booleanValue2);
                            }
                            h hVar = CameraProxy.this.J.get(sb6);
                            if (hVar == null) {
                                hVar = new h();
                                CameraProxy.this.J.put(sb6, hVar);
                            }
                            if (!hVar.f288168a.get()) {
                                Camera2Control.h G = Camera2Control.J().G();
                                if (!booleanValue2) {
                                    h16 = com.tencent.mobileqq.shortvideo.camera2.d.g(bVar9.f288111a, bVar9.f288112b, bVar10.f288111a, bVar10.f288112b, G);
                                } else {
                                    h16 = com.tencent.mobileqq.shortvideo.camera2.d.h(bVar9.f288111a, bVar9.f288112b, bVar10.f288111a, bVar10.f288112b, G);
                                }
                                if (h16 == null || h16.length < 2) {
                                    bVar2 = null;
                                    bVar3 = null;
                                } else {
                                    bVar3 = h16[0];
                                    bVar2 = h16[1];
                                }
                                CameraControl.b k06 = Camera2Control.J().k0(new CameraControl.b(Math.max(bVar10.f288111a, bVar10.f288112b), Math.min(bVar10.f288111a, bVar10.f288112b)));
                                if (!Camera2Control.J().g0(bVar3)) {
                                    CameraProxy.this.L.c(14, "[Camera2]setCamera2 previewSize error!");
                                    WaitDoneBundle.a(message);
                                    return;
                                }
                                if (!Camera2Control.J().i0(bVar2)) {
                                    CameraProxy.this.L.c(14, "[Camera2]setCamera2 pictureSize error!");
                                    WaitDoneBundle.a(message);
                                    return;
                                } else if (!Camera2Control.J().f0(((Integer) objArr2[3]).intValue())) {
                                    CameraProxy.this.L.c(14, "[Camera2]setCamera2 fps error!");
                                    WaitDoneBundle.a(message);
                                    return;
                                } else {
                                    hVar.f288169b = bVar3;
                                    hVar.f288170c = bVar2;
                                    hVar.f288171d = k06;
                                    hVar.f288168a.getAndSet(true);
                                }
                            } else if (!Camera2Control.J().Z(hVar)) {
                                CameraProxy.this.L.c(14, "[Camera2]setCamera2ParamOnce error!");
                                WaitDoneBundle.a(message);
                                return;
                            }
                            CameraProxy.this.L.c(14, Camera2Control.J().M(), Camera2Control.J().H());
                        } else if (i3 == 1010) {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                            }
                            i iVar2 = (i) message.obj;
                            if (iVar2.f288172a == null) {
                                CameraProxy.this.L.c(2, "take picture error");
                                WaitDoneBundle.a(message);
                                return;
                            }
                            Camera2Control.j jVar = new Camera2Control.j();
                            jVar.f287831c = iVar2.f288174c;
                            jVar.f287833e = iVar2.f288176e;
                            jVar.f287832d = iVar2.f288175d;
                            jVar.f287829a = iVar2.f288172a;
                            jVar.f287830b = iVar2.f288173b;
                            Camera2Control.J().r0(jVar);
                        } else if (i3 == 1021) {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                            }
                            Camera2Control.J().p0();
                        } else if (i3 == 1040) {
                            Camera2Control.J().l0(((Integer) ((Object[]) message.obj)[0]).intValue());
                        } else if (i3 == 1050) {
                            Camera2Control.J().b0(((Boolean) ((Object[]) message.obj)[0]).booleanValue());
                        } else if (i3 == 1060) {
                            Camera2Control.J().e0((Camera.PreviewCallback) ((Object[]) message.obj)[0]);
                        } else if (i3 == 1070) {
                            com.tencent.mobileqq.shortvideo.camera2.d.a(2, "[Camera2] error:" + message.arg1);
                            ms.a.c("CameraProxy", "\u3010Camera2 Open Error\u3011CAMERA2_ERROR_CALLBACK:" + message.arg1);
                            int i37 = message.arg1;
                            if (i37 != -105 && i37 != -102) {
                                switch (i37) {
                                    case -203:
                                    case -202:
                                    case -201:
                                        CameraProxy.this.L.c(14, "[Camera2]setCamera2 previewSize error:" + i37);
                                        break;
                                }
                            } else {
                                CameraProxy.this.L.c(13, Integer.valueOf(i37));
                            }
                        } else if (i3 == 401) {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
                            }
                            int i38 = message.arg1;
                            if (i38 == 0) {
                                if (!CameraControl.u().o0()) {
                                    CameraProxy.this.L.c(6, "switch flash light failed");
                                }
                            } else if (i38 == 1) {
                                if (!CameraControl.u().q0(true)) {
                                    CameraProxy.this.L.c(6, "turn on flash light failed");
                                }
                            } else if (i38 == 2 && !CameraControl.u().q0(false)) {
                                CameraProxy.this.L.c(6, "turn off flash light failed");
                            }
                        } else if (i3 == 402) {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
                            }
                            int i39 = message.arg1;
                            if (i39 == 1) {
                                if (!CameraControl.u().r0(true)) {
                                    CameraProxy.this.L.c(6, "turn on flash light failed");
                                }
                            } else if (i39 == 2 && !CameraControl.u().r0(false)) {
                                CameraProxy.this.L.c(6, "turn off flash light failed");
                            }
                        } else if (i3 == 501) {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + message.arg1);
                            }
                            int i46 = message.arg1;
                            if (i46 == 1) {
                                CameraProxy.this.p();
                            } else if (i46 == 2) {
                                CameraProxy.this.w();
                            }
                        } else if (i3 != 502) {
                            switch (i3) {
                                case 101:
                                    if (QLog.isColorLevel()) {
                                        QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
                                    }
                                    if (!CameraControl.u().Y(a()) && !CameraControl.u().Y("auto") && !CameraControl.u().j(this)) {
                                        CameraProxy.this.L.c(9, HardCodeUtil.qqStr(R.string.f171686k72));
                                        break;
                                    }
                                    break;
                                case 102:
                                    if (QLog.isColorLevel()) {
                                        QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
                                    }
                                    if (!CameraControl.u().Y("auto")) {
                                        CameraProxy.this.L.c(9, HardCodeUtil.qqStr(R.string.f171685k71));
                                        break;
                                    }
                                    break;
                                case 103:
                                    f fVar = (f) message.obj;
                                    c(fVar.f288154a, fVar.f288155b, fVar.f288157d);
                                    break;
                                case 104:
                                    if (QLog.isColorLevel()) {
                                        QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
                                    }
                                    if (!CameraControl.u().Y(b())) {
                                        CameraProxy.this.L.c(9, HardCodeUtil.qqStr(R.string.k6w));
                                        break;
                                    }
                                    break;
                                default:
                                    switch (i3) {
                                        case 201:
                                            if (QLog.isColorLevel()) {
                                                QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
                                            }
                                            if (!CameraControl.u().f0((SurfaceTexture) message.obj)) {
                                                CameraProxy.this.L.c(2, "set preview texture failed");
                                                break;
                                            }
                                            break;
                                        case 202:
                                            if (QLog.isColorLevel()) {
                                                QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
                                            }
                                            if (!CameraControl.u().i0((SurfaceHolder) message.obj)) {
                                                CameraProxy.this.L.c(2, "set surface holder failed");
                                                break;
                                            }
                                            break;
                                        case 203:
                                            if (QLog.isColorLevel()) {
                                                QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
                                            }
                                            if (!CameraControl.u().d0((Camera.PreviewCallback) message.obj, message.arg1 > 0)) {
                                                CameraProxy.this.L.c(2, "set preview callback failed");
                                                break;
                                            }
                                            break;
                                        case 204:
                                            if (QLog.isColorLevel()) {
                                                QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
                                            }
                                            if (!CameraControl.u().k0()) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
                                                }
                                                ms.a.f("CameraProxy", "[handleMessage] PREVIEW_START");
                                                CameraProxy.this.L.c(3, "start preview failed");
                                                break;
                                            } else {
                                                CameraControl u19 = CameraControl.u();
                                                if (u19.f288084e == 1) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + u19.f288084e);
                                                    }
                                                    ms.a.f("CameraProxy", "\u3010Camera \u3011PREVIEW_START success cameraID:" + u19.f288084e);
                                                    if (u19.n0() && CameraProxy.this.X != null) {
                                                        QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
                                                        u19.X(CameraProxy.this.X);
                                                        u19.j0();
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 205:
                                            if (QLog.isColorLevel()) {
                                                QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
                                            }
                                            ms.a.f("CameraProxy", "\u3010Camera\u3011PREVIEW_STOP success");
                                            if (!CameraControl.u().m0()) {
                                                CameraProxy.this.L.c(4, "stop preview failed");
                                                break;
                                            } else {
                                                CameraControl u26 = CameraControl.u();
                                                if (u26.n0() && CameraProxy.this.X != null) {
                                                    u26.l0();
                                                    break;
                                                }
                                            }
                                            break;
                                        default:
                                            switch (i3) {
                                                case 1001:
                                                    ms.a.f("CameraProxy", "camera2 open in.");
                                                    Object[] objArr3 = (Object[]) message.obj;
                                                    int intValue4 = ((Integer) objArr3[0]).intValue();
                                                    Object obj = objArr3[1];
                                                    Camera2Control.i iVar3 = obj instanceof Camera2Control.i ? (Camera2Control.i) obj : null;
                                                    if (Camera2Control.J().U()) {
                                                        com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2] camera2 is opening!");
                                                        WaitDoneBundle.a(message);
                                                        return;
                                                    }
                                                    int W = Camera2Control.J().W(intValue4, iVar3);
                                                    if (W != 0) {
                                                        ms.a.c("CameraProxy", "\u3010Camera2 Open Error\u3011EVENT_CAMERA2_ERROR:" + W);
                                                        CameraProxy.this.L.c(13, Integer.valueOf(W));
                                                        break;
                                                    }
                                                    break;
                                                case 1002:
                                                    Camera2Control.J().n0((SurfaceTexture) ((Object[]) message.obj)[0]);
                                                    ms.a.f("CameraProxy", "\u3010Camera2\u3011PREVIEW_START");
                                                    break;
                                                case 1003:
                                                    Camera2Control.J().D();
                                                    ms.a.f("CameraProxy", "\u3010Camera2\u3011CAMERA2_RELEASE");
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 1030:
                                                            Camera2Control.J().z((f) message.obj);
                                                            break;
                                                        case 1031:
                                                            Camera2Control.J().c0();
                                                            break;
                                                        case 1032:
                                                            if (QLog.isColorLevel()) {
                                                                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_START_VIDEO");
                                                            }
                                                            Camera2Control.J().d0();
                                                            break;
                                                        default:
                                                            throw new RuntimeException("Unimplemented CameraProxy message=" + message.what);
                                                    }
                                            }
                                    }
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + message.arg1);
                            }
                            CameraControl u27 = CameraControl.u();
                            if (u27.n0() && CameraProxy.this.X != null) {
                                int i47 = message.arg1;
                                if (i47 == 1) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + u27.f288084e);
                                    }
                                    if (u27.f288084e == 1) {
                                        u27.X(CameraProxy.this.X);
                                        u27.j0();
                                    }
                                } else if (i47 == 2) {
                                    u27.l0();
                                }
                            }
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
                        }
                        CameraControl.u().S();
                        CameraProxy.this.f288138e = true;
                        try {
                            LockMethodProxy.sleep(50L);
                        } catch (InterruptedException unused) {
                        }
                        ms.a.f("CameraProxy", "\u3010Camera\u3011RELEASE success");
                        CameraProxy.this.L.c(11, "camera destory");
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("CameraProxy", 2, "[Camera2Handler.handleMessage]", e16);
                    }
                }
            } finally {
                WaitDoneBundle.a(message);
            }
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z16, Camera camera2) {
            if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[onAutoFocus]success " + z16);
            }
            CameraControl.u().Y(a());
        }
    }

    /* loaded from: classes18.dex */
    public interface d {
        void a(boolean z16, boolean z17);
    }

    /* loaded from: classes18.dex */
    public interface e {
        void onPreviewFrame(byte[] bArr, Camera camera2);
    }

    /* loaded from: classes18.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        Rect f288154a;

        /* renamed from: b, reason: collision with root package name */
        Rect f288155b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.mobileqq.shortvideo.camera2.e f288156c;

        /* renamed from: d, reason: collision with root package name */
        Camera.AutoFocusCallback f288157d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.mobileqq.shortvideo.camera2.b f288158e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f288159f = false;

        public f() {
        }
    }

    /* loaded from: classes18.dex */
    public static class g {

        /* renamed from: b, reason: collision with root package name */
        int f288162b;

        /* renamed from: c, reason: collision with root package name */
        int f288163c;

        /* renamed from: d, reason: collision with root package name */
        int f288164d;

        /* renamed from: e, reason: collision with root package name */
        public CameraControl.b f288165e;

        /* renamed from: g, reason: collision with root package name */
        CameraControl.b f288167g;

        /* renamed from: a, reason: collision with root package name */
        public AtomicBoolean f288161a = new AtomicBoolean(false);

        /* renamed from: f, reason: collision with root package name */
        boolean f288166f = false;
    }

    /* loaded from: classes18.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public AtomicBoolean f288168a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public CameraControl.b f288169b;

        /* renamed from: c, reason: collision with root package name */
        public CameraControl.b f288170c;

        /* renamed from: d, reason: collision with root package name */
        public CameraControl.b f288171d;
    }

    /* loaded from: classes18.dex */
    private class i {

        /* renamed from: a, reason: collision with root package name */
        File f288172a;

        /* renamed from: b, reason: collision with root package name */
        Rect f288173b;

        /* renamed from: c, reason: collision with root package name */
        CameraCover.a f288174c;

        /* renamed from: d, reason: collision with root package name */
        int f288175d;

        /* renamed from: e, reason: collision with root package name */
        boolean f288176e;

        /* renamed from: f, reason: collision with root package name */
        int f288177f;
    }

    public CameraProxy(Context context, Handler handler) {
        synchronized (f288134d0) {
            if (f288133c0 == null) {
                HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("Camera2 Handler Thread", 0);
                f288133c0 = newFreeHandlerThread;
                newFreeHandlerThread.start();
            }
        }
        this.L = new CameraPreviewObservable(handler);
        this.K = new c(f288133c0.getLooper());
    }

    private void C(e eVar) {
        this.f288136b0 = eVar;
    }

    @TargetApi(9)
    private boolean E(Camera.Parameters parameters, int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "setFpsRange " + iArr[0] + " " + iArr[1]);
        }
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        return true;
    }

    private boolean F(Camera.Parameters parameters, String str) {
        if (!StringUtil.isEmpty(str) && this.S != null) {
            if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "set iso to =" + str);
            }
            parameters.set(this.S, str);
            return true;
        }
        return false;
    }

    private boolean G(Camera.Parameters parameters) {
        String str;
        String[] strArr;
        if (!this.T) {
            v(parameters);
        }
        if (this.U && (strArr = this.Q) != null && strArr.length > 0) {
            str = strArr[strArr.length - 1];
        } else {
            str = null;
        }
        if (!StringUtil.isEmpty(str) && this.S != null) {
            return F(parameters, str);
        }
        return false;
    }

    private void N(SurfaceTexture surfaceTexture) {
        try {
            z();
            this.K.obtainMessage(1002, new Object[]{surfaceTexture}).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    private void O(SurfaceTexture surfaceTexture, e eVar, boolean z16) {
        if (surfaceTexture != null) {
            J(surfaceTexture);
        }
        if (eVar != null) {
            C(eVar);
            I(this, z16);
        }
        try {
            this.K.obtainMessage(204).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    private boolean Q(Camera.Parameters parameters) {
        if (!this.T) {
            v(parameters);
        }
        return this.U;
    }

    private void k(int i3) {
        try {
            Object[] objArr = {Integer.valueOf(i3), this};
            ms.a.f("CameraProxy", "camera2 open out.");
            this.K.obtainMessage(1001, objArr).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    public void p() {
        if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "enterNightMode");
        }
        Camera.Parameters o16 = CameraControl.u().o();
        if (Q(o16)) {
            if (StringUtil.isEmpty(this.P)) {
                this.P = s(o16);
            }
            G(o16);
        }
        if (this.N == Integer.MAX_VALUE) {
            this.N = o16.getExposureCompensation();
        }
        o16.setExposureCompensation(o16.getMaxExposureCompensation());
        if (this.V == null) {
            this.V = r(o16);
        }
        if (this.W == null) {
            this.W = t(o16);
        }
        E(o16, this.W);
        CameraControl.u().f288082c.setParameters(o16);
    }

    @TargetApi(9)
    private int[] r(Camera.Parameters parameters) {
        int[] iArr = new int[2];
        parameters.getPreviewFpsRange(iArr);
        if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "getCurrentFpsRange " + iArr[0] + " " + iArr[1]);
        }
        return iArr;
    }

    private String s(Camera.Parameters parameters) {
        String str;
        String str2;
        if (!this.T) {
            v(parameters);
        }
        if (this.U && (str2 = this.S) != null) {
            str = parameters.get(str2);
        } else {
            str = null;
        }
        if (StringUtil.isEmpty(str)) {
            this.U = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "getCurrentISO=" + str);
        }
        return str;
    }

    @TargetApi(9)
    private int[] t(Camera.Parameters parameters) {
        new ArrayList();
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        int[] iArr = new int[2];
        if (supportedPreviewFpsRange != null) {
            int i3 = Integer.MAX_VALUE;
            for (int[] iArr2 : supportedPreviewFpsRange) {
                int i16 = iArr2[0];
                if (i16 < i3) {
                    iArr = iArr2;
                    i3 = i16;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "getCurrentFpsRange " + iArr[0] + " " + iArr[1]);
        }
        return iArr;
    }

    private void u() {
        if (!this.Y) {
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]initIsSupportCamera2:" + this.Y);
            this.f288135a0 = false;
            return;
        }
        int camera2ForceOpenSdkVersion = ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).getCamera2ForceOpenSdkVersion();
        int camera2SwitchValue = ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).getCamera2SwitchValue();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Camera2]initIsSupportCamera2 sdkVersion:");
        sb5.append(camera2ForceOpenSdkVersion);
        sb5.append(", camera2Switch:");
        sb5.append(camera2SwitchValue);
        sb5.append(", version:");
        int i3 = Build.VERSION.SDK_INT;
        sb5.append(i3);
        com.tencent.mobileqq.shortvideo.camera2.d.a(1, sb5.toString());
        if (camera2ForceOpenSdkVersion > -1 && camera2SwitchValue > -1) {
            if (ah.p0() && i3 >= 28 && ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isSamSungCameraOpen()) {
                camera2SwitchValue = 1;
            }
            if (camera2ForceOpenSdkVersion >= 23 && i3 >= camera2ForceOpenSdkVersion && camera2SwitchValue != 2) {
                this.f288135a0 = Camera2Control.T();
                return;
            }
            if (camera2SwitchValue == 0) {
                this.f288135a0 = false;
                return;
            }
            this.f288135a0 = Camera2Control.T();
            com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]initIsSupportCamera2 result:" + this.f288135a0);
            return;
        }
        this.f288135a0 = false;
    }

    private void v(Camera.Parameters parameters) {
        this.T = true;
        String flatten = parameters.flatten();
        if (flatten.contains("iso-values")) {
            this.R = "iso-values";
            this.S = "iso";
        } else if (flatten.contains("iso-mode-values")) {
            this.R = "iso-mode-values";
            this.S = "iso";
        } else if (flatten.contains("iso-speed-values")) {
            this.R = "iso-speed-values";
            this.S = "iso-speed";
        } else if (flatten.contains("nv-picture-iso-values")) {
            this.R = "nv-picture-iso-values";
            this.S = "nv-picture-iso";
        }
        if (this.S != null) {
            String substring = flatten.substring(flatten.indexOf(this.R));
            String substring2 = substring.substring(substring.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
            if (substring2.contains(";")) {
                substring2 = substring2.substring(0, substring2.indexOf(";"));
            }
            this.Q = substring2.split(",");
            if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "init iso key=" + this.S + " value key" + this.R + " Values=" + substring2);
                return;
            }
            return;
        }
        this.U = false;
        if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "init iso not support");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(14)
    public void w() {
        if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "leaveNightMode");
        }
        Camera.Parameters o16 = CameraControl.u().o();
        if (Q(o16) && !StringUtil.isEmpty(this.P)) {
            F(o16, this.P);
        }
        int i3 = this.N;
        if (i3 != Integer.MAX_VALUE) {
            o16.setExposureCompensation(i3);
        }
        int[] iArr = this.V;
        if (iArr != null) {
            E(o16, iArr);
        }
        CameraControl.u().f288082c.setParameters(o16);
    }

    private void z() {
        try {
            this.K.obtainMessage(1060, new Object[]{this}).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void A(boolean z16) {
        this.Y = z16;
        com.tencent.mobileqq.shortvideo.camera2.d.a(1, "[Camera2]setCamera2Usable:" + this.Y);
    }

    public void B(CameraExceptionHandler cameraExceptionHandler) {
        this.M = cameraExceptionHandler;
    }

    public void D() {
        try {
            if (this.f288135a0) {
                this.K.obtainMessage(1031).sendToTarget();
            } else {
                this.K.obtainMessage(101).sendToTarget();
            }
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void H(CameraControl.b bVar, CameraControl.b bVar2, int i3, int i16, boolean z16) {
        try {
            if (this.f288135a0) {
                this.K.obtainMessage(1005, new Object[]{bVar, bVar2, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16)}).sendToTarget();
            } else {
                this.K.obtainMessage(7, new Object[]{bVar, bVar2, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16)}).sendToTarget();
            }
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void I(Camera.PreviewCallback previewCallback, boolean z16) {
        int i3;
        try {
            c cVar = this.K;
            if (z16) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            cVar.obtainMessage(203, i3, 0, previewCallback).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void J(SurfaceTexture surfaceTexture) {
        try {
            this.K.obtainMessage(201, surfaceTexture).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void K(String str) {
        try {
            this.K.obtainMessage(701, new Object[]{str}).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void L(SurfaceHolder surfaceHolder) {
        try {
            this.K.obtainMessage(202, surfaceHolder).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void M(int i3) {
        int i16;
        try {
            Object[] objArr = {Integer.valueOf(i3)};
            if (this.f288135a0) {
                i16 = 1040;
            } else {
                i16 = 601;
            }
            this.K.obtainMessage(i16, objArr).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void P(SurfaceHolder surfaceHolder, e eVar, boolean z16) {
        if (surfaceHolder != null) {
            L(surfaceHolder);
        }
        if (eVar != null) {
            C(eVar);
            I(this, z16);
        }
        try {
            this.K.obtainMessage(204).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void R(boolean z16) {
        int i3 = 1;
        if (this.f288135a0) {
            this.K.obtainMessage(1050, new Object[]{Boolean.valueOf(z16)}).sendToTarget();
            return;
        }
        c cVar = this.K;
        if (!z16) {
            i3 = 2;
        }
        cVar.obtainMessage(401, i3, 0).sendToTarget();
    }

    public void S(yq2.c cVar) {
        this.L.e(cVar);
    }

    public void T(long j3, String str) {
        String str2 = "Timeout waiting " + j3 + "ms for " + str;
        long uptimeMillis = SystemClock.uptimeMillis() + j3;
        try {
            WaitDoneBundle waitDoneBundle = new WaitDoneBundle();
            this.K.post(waitDoneBundle.f288146a);
            synchronized (waitDoneBundle.f288147b) {
                waitDoneBundle.f288147b.wait(j3);
            }
            if (SystemClock.uptimeMillis() > uptimeMillis) {
                throw new IllegalStateException(str2);
            }
        } catch (InterruptedException unused) {
            if (SystemClock.uptimeMillis() <= uptimeMillis) {
            } else {
                throw new IllegalStateException(str2);
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.camera2.Camera2Control.i
    public void a(int i3) {
        try {
            this.K.obtainMessage(1070, i3, 0).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void g() {
        try {
            this.K.obtainMessage(1003).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    @Deprecated
    public void h(int i3, int i16, int i17) {
        try {
            this.K.obtainMessage(6, i16, i17, Integer.valueOf(i3)).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    public void i() {
        j(com.tencent.mobileqq.activity.richmedia.c.f185845b);
    }

    public synchronized void j(int i3) {
        Object cameraCreatedResultInfo;
        if (QLog.isColorLevel()) {
            QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.Z), " id:", Integer.valueOf(i3));
        }
        if (this.Z) {
            if (((IAsyncControl) QRoute.api(IAsyncControl.class)).isCameraCreated()) {
                if (((IAsyncControl) QRoute.api(IAsyncControl.class)).isCameraCreatedResult()) {
                    cameraCreatedResultInfo = Boolean.valueOf(((IAsyncControl) QRoute.api(IAsyncControl.class)).isCameraCreatedResult());
                } else {
                    cameraCreatedResultInfo = ((IAsyncControl) QRoute.api(IAsyncControl.class)).getCameraCreatedResultInfo();
                }
                this.L.c(1, cameraCreatedResultInfo);
                if (QLog.isColorLevel()) {
                    QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
                }
            }
            return;
        }
        this.Z = true;
        u();
        if (this.f288135a0) {
            k(i3);
        } else {
            try {
                this.K.obtainMessage(1, new Object[]{Integer.valueOf(i3)}).sendToTarget();
            } catch (RuntimeException e16) {
                CameraExceptionHandler cameraExceptionHandler = this.M;
                if (cameraExceptionHandler != null) {
                    cameraExceptionHandler.a(e16);
                }
            }
        }
    }

    public synchronized void l(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraProxy", 2, "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.Z));
        }
        if (!this.Z) {
            return;
        }
        this.Z = false;
        try {
            if (this.f288135a0) {
                g();
            } else if (!z16) {
                this.K.sendEmptyMessage(2);
            } else {
                this.K.obtainMessage(2).sendToTarget();
                T(3500L, "release camera");
            }
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.shortvideo.camera2.c.a();
            }
        }, 16, null, false);
    }

    public void m(SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder, e eVar, boolean z16) {
        if (this.f288135a0) {
            if (surfaceTexture == null) {
                a(-201);
                return;
            }
            if (eVar != null) {
                C(eVar);
            }
            N(surfaceTexture);
            return;
        }
        if (surfaceTexture != null) {
            O(surfaceTexture, eVar, z16);
        } else {
            P(surfaceHolder, eVar, z16);
        }
    }

    public void n() {
        o(false);
    }

    public void o(boolean z16) {
        try {
            C(null);
            if (!this.f288135a0) {
                if (!z16) {
                    this.K.sendEmptyMessage(205);
                } else {
                    this.K.obtainMessage(205).sendToTarget();
                    T(3500L, "stop preview");
                }
            }
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        e eVar = this.f288136b0;
        if (eVar != null) {
            eVar.onPreviewFrame(bArr, camera2);
        }
    }

    public c q() {
        return this.K;
    }

    public void x(yq2.c cVar) {
        this.L.a(cVar, 1, 2, 3, 4, 6, 7, 10, 11, 12, 13, 14);
    }

    public void y(com.tencent.mobileqq.shortvideo.camera2.e eVar, d dVar) {
        int i3;
        try {
            f fVar = new f();
            if (this.f288135a0) {
                if (eVar != null && eVar.f287843g && dVar != null) {
                    dVar.a(true, true);
                    return;
                }
                com.tencent.mobileqq.shortvideo.camera2.b bVar = new com.tencent.mobileqq.shortvideo.camera2.b();
                bVar.f287835a = 1;
                bVar.f287836b = new a(dVar);
                fVar.f288158e = bVar;
                fVar.f288156c = eVar;
                i3 = 1030;
            } else {
                if (eVar != null && eVar.a()) {
                    fVar.f288154a = eVar.f287842f.a(eVar.f287837a, eVar.f287838b, eVar.f287839c, eVar.f287840d, 1.0f);
                    fVar.f288155b = eVar.f287842f.a(eVar.f287837a, eVar.f287838b, eVar.f287839c, eVar.f287840d, 1.5f);
                }
                fVar.f288157d = new b(dVar);
                i3 = 103;
            }
            this.K.obtainMessage(i3, fVar).sendToTarget();
        } catch (RuntimeException e16) {
            CameraExceptionHandler cameraExceptionHandler = this.M;
            if (cameraExceptionHandler != null) {
                cameraExceptionHandler.a(e16);
            }
        }
    }

    /* loaded from: classes18.dex */
    class a implements Camera2Control.i {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f288148d;

        a(d dVar) {
            this.f288148d = dVar;
        }

        @Override // com.tencent.mobileqq.shortvideo.camera2.Camera2Control.i
        public void b(int i3, boolean z16) {
            d dVar;
            if (i3 == 1 && (dVar = this.f288148d) != null) {
                dVar.a(z16, true);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.camera2.Camera2Control.i
        public void a(int i3) {
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.camera2.Camera2Control.i
    public void b(int i3, boolean z16) {
    }
}
