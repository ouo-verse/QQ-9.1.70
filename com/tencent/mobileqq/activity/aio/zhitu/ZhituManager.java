package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.activity.aio.zhitu.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg$ReqBody;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import tencent.im.zhitu.gate.ZhituSafeGate$ReqBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ZhituManager implements Manager, Handler.Callback, g.c {

    /* renamed from: g0, reason: collision with root package name */
    private static int f180302g0 = 0;

    /* renamed from: h0, reason: collision with root package name */
    private static volatile boolean f180303h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private static volatile boolean f180304i0 = false;
    private Typeface E;
    private HandlerThread H;
    private Handler I;
    private Executor J;
    private b L;
    private Map<File, Boolean> M;
    public LinearLayout Q;
    public ZhituEmotionHorizonListView R;
    public ZhituPanelView S;
    public ZhituPicAdapter T;
    public ZhituPanelView.c U;
    private boolean W;
    private AppInterface Z;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.zhitu.b f180308d;

    /* renamed from: m, reason: collision with root package name */
    private int f180316m;

    /* renamed from: i, reason: collision with root package name */
    private String f180315i = "";
    private volatile String C = "";
    private boolean D = false;
    private volatile int F = 0;
    private int N = 0;
    private int P = 0;
    private boolean X = true;
    private boolean Y = false;

    /* renamed from: a0, reason: collision with root package name */
    private final int f180305a0 = 180;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f180306b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f180307c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private long f180309d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    private int f180311e0 = 180;

    /* renamed from: f0, reason: collision with root package name */
    private Handler f180313f0 = new a(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f180310e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, String> f180312f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private BlockingDeque<d> f180314h = new LinkedBlockingDeque();
    private List<HttpNetReq> K = new LinkedList();
    private Map<String, ZhituResponse> G = new HashMap();
    private List<String> V = new LinkedList();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ZhituManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.I0(Looper.myQueue());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager$12, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ ZhituManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.q();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 == 11) {
                        String str = (String) message.obj;
                        if (QLog.isColorLevel()) {
                            QLog.d("ZhituManager", 2, "response is empty, errorMsg is " + str);
                        }
                        ZhituPanelView.c cVar = ZhituManager.this.U;
                        if (cVar != null) {
                            cVar.r(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int i16 = message.arg1;
                String str2 = (String) message.obj;
                if (!str2.equals(ZhituManager.this.N())) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ZhituManager", 2, ZhituManager.x(str2, "main handler", "reqKey is outdated, skip"));
                        return;
                    }
                    return;
                }
                ZhituPicAdapter zhituPicAdapter = ZhituManager.this.T;
                if (zhituPicAdapter != null) {
                    zhituPicAdapter.g(i16, str2);
                }
                ZhituPanelView.c cVar2 = ZhituManager.this.U;
                if (cVar2 != null) {
                    cVar2.t(i16, str2);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.activity.aio.zhitu.c cVar3 = (com.tencent.mobileqq.activity.aio.zhitu.c) message.obj;
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, ZhituManager.w(cVar3.f180387f, "main handler", cVar3.f180388g, "all img process is finished, now is in main thread"));
            }
            ZhituManager.this.Y0(cVar3);
        }
    }

    public ZhituManager(AppInterface appInterface) {
        this.Z = appInterface;
        s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Bitmap A0(int i3, int i16) {
        try {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            w0(e16);
            return null;
        }
    }

    private void B0(String str) {
        this.f180313f0.sendMessage(this.f180313f0.obtainMessage(11, str));
    }

    private void C0(Message message) {
        int i3 = message.arg1;
        String str = (String) message.obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.equals(N())) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, x(str, "MSG_WHAT_REQUEST_MORE_IMG", "more img key is not the last req key, stop."));
            }
        } else {
            ZhituResponse zhituResponse = this.G.get(str);
            if (zhituResponse != null) {
                c0(zhituResponse, str, i3, C());
            }
        }
    }

    @NonNull
    private String D(ZhituImgResponse zhituImgResponse) {
        return com.tencent.securitysdk.utils.c.b(zhituImgResponse.url) + "_" + zhituImgResponse.md5;
    }

    private void D0(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        this.f180313f0.sendMessage(this.f180313f0.obtainMessage(5, cVar));
    }

    private File E(File file, ZhituImgResponse zhituImgResponse) {
        return new File(file, D(zhituImgResponse));
    }

    private File F() {
        return R();
    }

    private File G() {
        return new File(F(), "font");
    }

    private void G0(String str, int i3, String str2, String str3, String str4, String str5, com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        cVar.f180387f = str;
        cVar.f180388g = i3;
        cVar.f180382a = str2;
        cVar.f180389h = str3;
        d dVar = new d();
        dVar.f180397b = str3;
        dVar.f180398c = str4;
        dVar.f180396a = str5;
        dVar.f180400e = s(this.F);
        dVar.f180401f = C();
        cVar.f180393l = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static AbstractGifImage H(String str) {
        Object g16 = ImageCacheHelper.f98636a.g(str);
        if (g16 instanceof Pair) {
            return (AbstractGifImage) ((Pair) g16).first;
        }
        return null;
    }

    private void H0(MessageQueue messageQueue) {
        messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.4
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                ZhituManager.this.T0();
                return false;
            }
        });
    }

    public static ZhituManager I(AppInterface appInterface) {
        return (ZhituManager) appInterface.getManager(QQManagerFactory.ZHITU_MANAGER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(MessageQueue messageQueue) {
        messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.3
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                ZhituManager.this.X0(true);
                return true;
            }
        });
        H0(messageQueue);
    }

    private File J() {
        return new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.SDCARD_PATH_ZHITU + File.separator + "origin/"));
    }

    public static void J0(boolean z16) {
        if (f180303h0 == z16) {
            return;
        }
        synchronized (ZhituManager.class) {
            f180303h0 = z16;
        }
    }

    private File K(ZhituImgResponse zhituImgResponse) {
        return E(J(), zhituImgResponse);
    }

    private int L() {
        return this.f180316m;
    }

    @Nullable
    private Rect M(String str, ZhituImgResponse zhituImgResponse) {
        Rect rect = new Rect();
        String[] split = zhituImgResponse.coord.split("\\|");
        try {
            rect.left = Integer.parseInt(split[0]);
            rect.top = Integer.parseInt(split[1]);
            rect.right = rect.left + Integer.parseInt(split[2]);
            rect.bottom = rect.top + Integer.parseInt(split[3]);
            return rect;
        } catch (Exception unused) {
            QLog.d("ZhituManager", 1, x(str, "startImgGenerate", "unknown rect format: " + zhituImgResponse.coord));
            return null;
        }
    }

    public static void M0(boolean z16) {
        if (f180304i0 == z16) {
            return;
        }
        synchronized (ZhituManager.class) {
            f180304i0 = z16;
        }
    }

    private File P() {
        return new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.SDCARD_PATH_ZHITU + File.separator + "sent/"));
    }

    private int Q(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt != 0) {
                if (parseInt != 1) {
                    return 2;
                }
                return 1;
            }
            return 0;
        } catch (NumberFormatException unused) {
            if (!QLog.isColorLevel()) {
                return 2;
            }
            QLog.d("ZhituManager", 2, "img response has invalid style");
            return 2;
        }
    }

    private File R() {
        return new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.SDCARD_PATH_ZHITU));
    }

    private void U0(ZhituResponse zhituResponse, String str, AppInterface appInterface, int i3, ZhituImgResponse zhituImgResponse, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("ZhituRespose", zhituResponse);
        bundle.putParcelable("ImgResponse", zhituImgResponse);
        bundle.putString("ReqUniqueKey", str);
        bundle.putInt("IdxInRes", i3);
        bundle.putString("QueryText", str2);
        bundle.putLong("StartTs", System.currentTimeMillis());
        File K = K(zhituImgResponse);
        int i16 = 1;
        if (K.exists()) {
            n(K.getAbsolutePath());
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, w(str, "startEachImgDownloadRequest", i3, "md5 matched, the origin img is downloaded and just skip download."));
            }
            if (this.P != 2) {
                boolean lastModified = K.setLastModified(System.currentTimeMillis());
                if (this.P == 0 && QLog.isColorLevel()) {
                    QLog.d("ZhituManager", 2, "set last modified time is supported? " + lastModified);
                }
                if (!lastModified) {
                    i16 = 2;
                }
                this.P = i16;
            }
            Message obtainMessage = this.I.obtainMessage(3);
            obtainMessage.obj = bundle;
            this.I.sendMessage(obtainMessage);
            return;
        }
        if (this.L == null) {
            this.L = new b(this.I);
        }
        String str3 = zhituImgResponse.url;
        IHttpEngineService iHttpEngineService = (IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mNeedIpConnect = true;
        httpNetReq.mNeedNotReferer = true;
        httpNetReq.mCallback = this.L;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mReqUrl = str3;
        httpNetReq.mOutPath = K.getAbsolutePath();
        httpNetReq.mPrioty = 0;
        httpNetReq.setUserData(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, w(str, "startEachImgDownloadRequest", i3, "start send img download request, " + str3));
        }
        this.K.add(httpNetReq);
        iHttpEngineService.sendReq(httpNetReq);
    }

    private boolean V0(ZhituResponse zhituResponse, List<ZhituImgResponse> list, int i3, int i16, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, x(str, "startImgDownload", "start / end idx: " + i3 + " / " + i16));
        }
        File J = J();
        int i17 = 0;
        if (!J.exists() && !J.mkdirs()) {
            QLog.d("ZhituManager", 1, x(str, "startImgDownload", "can not create dir."));
            return false;
        }
        try {
            v(J);
        } catch (IOException unused) {
        }
        if (i3 != 0) {
            i17 = -1;
        }
        int i18 = i17;
        for (int i19 = i3; i19 < i16; i19++) {
            U0(zhituResponse, str, this.Z, i19, list.get(i19 + i18), str2, null);
        }
        return true;
    }

    private void W(Message message) {
        Bundle bundle = (Bundle) message.obj;
        final String string = bundle.getString("ReqUniqueKey");
        if (!N().equals(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, x(string, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "reqKey is outdated, skip."));
                return;
            }
            return;
        }
        final ZhituResponse zhituResponse = (ZhituResponse) bundle.getParcelable("ZhituRespose");
        final ZhituImgResponse zhituImgResponse = (ZhituImgResponse) bundle.getParcelable("ImgResponse");
        final int i3 = bundle.getInt("IdxInRes");
        final String string2 = bundle.getString("QueryText");
        if (zhituResponse != null && zhituImgResponse != null) {
            final int Q = Q(zhituImgResponse.style);
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, w(string, "MSG_WHAT_IMG_DOWNLOAD_SUCC", i3, "style is " + Q));
            }
            boolean z16 = true;
            if (U() != 1) {
                z16 = false;
            }
            if (Q != 2) {
                this.J.execute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ZhituManager.this.W0(string, i3, zhituResponse, zhituImgResponse, Q, string2);
                    }
                });
                return;
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ZhituManager", 2, "zhitutest handleImgDownloadSucc key = " + string + " |idxinRes = " + i3 + " | originQueryText = " + string2);
                }
                if (M(string, zhituImgResponse) != null) {
                    this.J.execute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.7
                        @Override // java.lang.Runnable
                        public void run() {
                            ZhituManager.this.W0(string, i3, zhituResponse, zhituImgResponse, Q, string2);
                        }
                    });
                    return;
                } else {
                    r0(string, i3, zhituImgResponse);
                    return;
                }
            }
            r0(string, i3, zhituImgResponse);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, x(string, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "originResponse or originImgResponse is null, skip."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(String str, int i3, ZhituResponse zhituResponse, ZhituImgResponse zhituImgResponse, int i16, String str2) {
        String str3;
        String str4;
        boolean z16;
        String str5;
        String str6 = str;
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, w(str6, "startImgGenerate", i3, "start"));
        }
        f180302g0++;
        String str7 = zhituImgResponse.url;
        String substring = str7.substring(str7.lastIndexOf("."));
        Rect M = M(str6, zhituImgResponse);
        if (M == null) {
            return;
        }
        String absolutePath = K(zhituImgResponse).getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        if (QzoneEmotionUtils.SIGN_ICON_URL_END.equalsIgnoreCase(substring)) {
            try {
                try {
                    if (U() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    try {
                        if (i3 == 0 || z16) {
                            str4 = "startImgGenerate";
                            com.tencent.mobileqq.activity.aio.zhitu.a aVar = new com.tencent.mobileqq.activity.aio.zhitu.a(new File(absolutePath), false, 0.0f);
                            if (QLog.isColorLevel()) {
                                QLog.d("ZhituManager", 2, "get width: " + i3 + " / " + aVar.getWidth() + " / " + aVar.e());
                            }
                            try {
                                g.a m3 = g.l().m(aVar.getWidth(), aVar.getHeight(), str2, zhituResponse.tokens, zhituImgResponse.textColor, M, i16, str, i3, this.E);
                                aVar.f(m3);
                                if (QLog.isColorLevel()) {
                                    str6 = str;
                                    str5 = "ZhituManager";
                                    try {
                                        QLog.d(str5, 2, w(str6, "generateGifImage", i3, "take time " + Long.toString(System.currentTimeMillis() - currentTimeMillis)));
                                    } catch (IOException e16) {
                                        e = e16;
                                        str3 = str5;
                                    }
                                } else {
                                    str6 = str;
                                    str5 = "ZhituManager";
                                }
                                str3 = str5;
                                try {
                                    l0(aVar, m3, absolutePath, null, str, i3, zhituImgResponse.url, zhituImgResponse.md5, zhituImgResponse.style, zhituImgResponse.pass);
                                    return;
                                } catch (IOException e17) {
                                    e = e17;
                                }
                            } catch (IOException e18) {
                                e = e18;
                                str6 = str;
                                str3 = "ZhituManager";
                            }
                        } else {
                            try {
                                AbstractGifImage nativeGifImage = new NativeGifImage(new File(absolutePath), false);
                                l0(nativeGifImage, g.l().m(nativeGifImage.getWidth(), nativeGifImage.getHeight(), str2, zhituResponse.tokens, zhituImgResponse.textColor, M, i16, str, i3, this.E), absolutePath, null, str, i3, zhituImgResponse.url, zhituImgResponse.md5, zhituImgResponse.style, zhituImgResponse.pass);
                                return;
                            } catch (IOException e19) {
                                e = e19;
                                str4 = "startImgGenerate";
                                str6 = str;
                                str3 = "ZhituManager";
                            }
                        }
                    } catch (IOException e26) {
                        e = e26;
                        str3 = str6;
                        str6 = str;
                    }
                } catch (OutOfMemoryError e27) {
                    w0(e27);
                    return;
                }
            } catch (IOException e28) {
                e = e28;
                str3 = "ZhituManager";
                str4 = "startImgGenerate";
            }
            QLog.e(str3, 1, w(str6, str4, i3, "open gif file fail, " + e));
            return;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
            if (decodeFile == null) {
                QLog.e("ZhituManager", 1, w(str6, "generateZhitu", i3, "decode bitmap fail"));
                return;
            }
            Bitmap g16 = g.l().g(absolutePath, str2, zhituResponse.tokens, zhituImgResponse.textColor, M, i16, str, i3, this.E);
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, w(str6, "generateBitmap", i3, "take time " + Long.toString(System.currentTimeMillis() - currentTimeMillis)));
            }
            if (g16 == null) {
                return;
            }
            k0(decodeFile, g16, str, i3, zhituImgResponse.url, zhituImgResponse.md5, zhituImgResponse.style, zhituImgResponse.pass, false);
        } catch (OutOfMemoryError unused) {
            QLog.e("ZhituManager", 1, "decode origin file but oom");
        }
    }

    private void X(NewIntent newIntent, Handler handler) {
        if (this.f180308d == null) {
            this.f180308d = new com.tencent.mobileqq.activity.aio.zhitu.b(handler);
        }
        newIntent.setObserver(this.f180308d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(boolean z16) {
        if (this.f180314h.size() == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        while (!this.f180314h.isEmpty() && (linkedList.size() <= 100 || !z16)) {
            linkedList.add(this.f180314h.poll());
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ZhituReportMsg$ReqBody a16 = ((d) it.next()).a();
            if (a16 != null) {
                NewIntent newIntent = new NewIntent(this.Z.getApp(), f.class);
                newIntent.putExtra("ZhituCMD", "MQInference.ZhituReport");
                newIntent.putExtra("ZhituRequestBytes", a16.toByteArray());
                this.Z.startServlet(newIntent);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "send " + linkedList.size() + " reports, take " + Long.toString(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void Y(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        NativeGifImage nativeGifImage;
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "handleRequestDecodeGif font fail, picData is null.");
                return;
            }
            return;
        }
        boolean z16 = true;
        if (U() != 1) {
            z16 = false;
        }
        String A = A(cVar);
        if (H(A) != null) {
            D0(cVar);
            return;
        }
        try {
            if (cVar.f180385d != null && (cVar.f180394m || z16)) {
                com.tencent.mobileqq.activity.aio.zhitu.a aVar = new com.tencent.mobileqq.activity.aio.zhitu.a(new File(cVar.f180384c), false, 0.0f);
                aVar.f(cVar.f180385d);
                nativeGifImage = aVar;
            } else {
                if (cVar.f180384c == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ZhituManager", 2, "decode gif picData.originPath is null: " + cVar.toString());
                        return;
                    }
                    return;
                }
                nativeGifImage = new NativeGifImage(new File(cVar.f180384c), false);
            }
            d0(A, nativeGifImage);
            this.V.add(A);
            D0(cVar);
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "decode gif fail: " + e16);
            }
        } catch (OutOfMemoryError e17) {
            w0(e17);
        }
    }

    private void c0(final ZhituResponse zhituResponse, final String str, int i3, final String str2) {
        List<ZhituImgResponse> list = zhituResponse.list;
        if (list == null) {
            QLog.d("ZhituManager", 1, x(str, "handleZhituResponse", "the list is null"));
            if (i3 == 0) {
                B0(this.Z.getApp().getResources().getString(R.string.ihi));
                return;
            }
            return;
        }
        this.G.put(str, zhituResponse);
        if (i3 == 0 && list.isEmpty()) {
            B0(this.Z.getApp().getResources().getString(R.string.ihi));
            return;
        }
        final int min = Math.min(list.size(), i3 + L());
        if (!V0(zhituResponse, list, i3, min, str, str2)) {
            QLog.d("ZhituManager", 1, x(str, "handleZhituResponse", "fail to start download"));
            return;
        }
        Message obtainMessage = this.f180313f0.obtainMessage(6);
        int i16 = min - i3;
        obtainMessage.arg1 = i16;
        if (i3 == 0) {
            obtainMessage.arg1 = i16 + 1;
        }
        obtainMessage.arg2 = zhituResponse.hasMore;
        obtainMessage.obj = str;
        this.f180313f0.sendMessage(obtainMessage);
        if (i3 == 0) {
            this.J.execute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.9
                @Override // java.lang.Runnable
                public void run() {
                    ZhituManager.this.y(zhituResponse, str, min, str2);
                }
            });
        }
    }

    private void d0(String str, AbstractGifImage abstractGifImage) {
        ImageCacheHelper.f98636a.i(str, new Pair(abstractGifImage, Integer.valueOf(abstractGifImage.getByteSize())), Business.AIO);
    }

    public static boolean f0() {
        boolean z16;
        synchronized (ZhituManager.class) {
            z16 = f180304i0;
        }
        return z16;
    }

    public static boolean g0(MessageForPic messageForPic) {
        PicMessageExtraData picMessageExtraData;
        if (messageForPic != null && (picMessageExtraData = messageForPic.picExtraData) != null && picMessageExtraData.isZhitu()) {
            return true;
        }
        return false;
    }

    public static boolean h0(MessageForPic messageForPic) {
        boolean z16;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            z16 = I((QQAppInterface) runtime).j0();
        } else {
            z16 = false;
        }
        if (!g0(messageForPic) || z16) {
            return false;
        }
        return true;
    }

    private void k0(Bitmap bitmap, Bitmap bitmap2, String str, int i3, String str2, String str3, String str4, String str5, boolean z16) {
        BitmapDrawable bitmapDrawable;
        if (!str.equals(N())) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, x(str, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
                return;
            }
            return;
        }
        com.tencent.mobileqq.activity.aio.zhitu.c cVar = new com.tencent.mobileqq.activity.aio.zhitu.c();
        cVar.f180390i = new BitmapDrawable(this.Z.getApp().getResources(), bitmap2);
        if (bitmap != null) {
            bitmapDrawable = new BitmapDrawable(this.Z.getApp().getResources(), bitmap);
        } else {
            bitmapDrawable = null;
        }
        cVar.f180391j = bitmapDrawable;
        boolean z17 = false;
        cVar.f180392k = false;
        if (i3 == 0) {
            z17 = true;
        }
        cVar.f180394m = z17;
        cVar.f180395n = z16;
        G0(str, i3, str2, str3, str4, str5, cVar);
        D0(cVar);
    }

    private void l0(AbstractGifImage abstractGifImage, g.a aVar, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7) {
        if (!str3.equals(N())) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, x(str3, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
                return;
            }
            return;
        }
        com.tencent.mobileqq.activity.aio.zhitu.c cVar = new com.tencent.mobileqq.activity.aio.zhitu.c();
        cVar.f180385d = aVar;
        boolean z16 = true;
        cVar.f180392k = true;
        cVar.f180384c = str;
        cVar.f180383b = str2;
        cVar.f180386e = true;
        if (i3 != 0) {
            z16 = false;
        }
        cVar.f180394m = z16;
        G0(str3, i3, str4, str5, str6, str7, cVar);
        final String A = A(cVar);
        d0(A, abstractGifImage);
        Handler handler = this.I;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.8
                @Override // java.lang.Runnable
                public void run() {
                    ZhituManager.this.V.add(A);
                }
            });
        }
        D0(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String n(String str) {
        String str2 = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str2 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        } catch (UnsatisfiedLinkError unused) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                    if (d16 != null) {
                        str2 = d16;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "calcMD5", "md5:" + str2 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return str2;
    }

    private void n0(int i3, ZhituResponse zhituResponse, String str, int i16, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, x(str, "onResponse", "error code: " + i3 + " / " + zhituResponse + " startIdx: " + i16));
        }
        if (i3 != 0) {
            return;
        }
        v0(str, zhituResponse);
        c0(zhituResponse, str, i16, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(List<HttpNetReq> list) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "cancel all pending net req: " + list.size());
        }
        IHttpEngineService iHttpEngineService = (IHttpEngineService) this.Z.getRuntimeService(IHttpEngineService.class, "all");
        Iterator<HttpNetReq> it = list.iterator();
        while (it.hasNext()) {
            iHttpEngineService.cancelReq(it.next());
        }
    }

    private void p() {
        if (this.I != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "cancelAllRequestMessage");
            }
            for (int i3 = 1; i3 < 10; i3++) {
                this.I.removeMessages(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Iterator<String> it = this.V.iterator();
        while (it.hasNext()) {
            ImageCacheHelper.f98636a.m(it.next());
        }
        this.V.clear();
    }

    private String r(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3000) {
                    if (i3 != 7220) {
                        return Integer.toString(i3);
                    }
                    return TabPreloadItem.TAB_NAME_KANDIAN;
                }
                return "discussion";
            }
            return "troop";
        }
        return "c2c";
    }

    private void r0(String str, int i3, ZhituImgResponse zhituImgResponse) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, w(str, "passThroughOriginImg", i3, "start"));
        }
        String str2 = zhituImgResponse.url;
        if (QzoneEmotionUtils.SIGN_ICON_URL_END.equalsIgnoreCase(str2.substring(str2.lastIndexOf(".")))) {
            try {
                String absolutePath = K(zhituImgResponse).getAbsolutePath();
                l0(new NativeGifImage(new File(absolutePath), false), null, absolutePath, absolutePath, str, i3, zhituImgResponse.url, zhituImgResponse.md5, zhituImgResponse.style, zhituImgResponse.pass);
                return;
            } catch (IOException unused) {
                QLog.e("ZhituManager", 1, x(str, "passThroughOriginImg", "convert to gif drawable fail"));
                return;
            }
        }
        k0(null, BitmapFactory.decodeFile(K(zhituImgResponse).getAbsolutePath()), str, i3, zhituImgResponse.url, zhituImgResponse.md5, zhituImgResponse.style, zhituImgResponse.pass, false);
    }

    private String s(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3000) {
                    if (i3 != 7220) {
                        return "tempchat";
                    }
                    return TabPreloadItem.TAB_NAME_KANDIAN;
                }
                return "discuss";
            }
            return VipFunCallConstants.KEY_GROUP;
        }
        return "c2c";
    }

    private void s0() {
        this.X = ea.c2(this.Z.getApp(), this.Z.getCurrentAccountUin());
        this.W = ea.d2(this.Z.getApp(), this.Z.getCurrentAccountUin());
        this.f180316m = ea.X1(this.Z.getApp(), this.Z.getCurrentAccountUin());
        this.f180306b0 = ea.b2(this.Z.getApp(), this.Z.getCurrentAccountUin());
        this.f180307c0 = ea.a2(this.Z.getApp(), this.Z.getCurrentAccountUin());
        this.f180309d0 = ea.Z1(this.Z.getApp(), this.Z.getCurrentAccountUin());
        this.f180311e0 = ea.Y1(this.Z.getApp(), this.Z.getCurrentAccountUin());
        this.Y = true;
    }

    private int t(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                if (i3 != 7220) {
                    return i3;
                }
                return 4;
            }
            return 2;
        }
        return 3;
    }

    private void t0(QQAppInterface qQAppInterface, String str, ZhituRequest zhituRequest, int i3, Handler handler) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), f.class);
        String jSONObject = JSONUtils.a(zhituRequest).toString();
        newIntent.putExtra("ZhituCMD", "AIMessage.Text2Image");
        newIntent.putExtra("ZhituRequestBytes", jSONObject.getBytes());
        X(newIntent, handler);
        newIntent.putExtra("ZhituReqKey", str);
        newIntent.putExtra("StartIdx", i3);
        newIntent.putExtra("QueryText", zhituRequest.text);
        qQAppInterface.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, x(str, "realSendZhituRequest", "send request: " + zhituRequest));
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800ADCB", "0X800ADCB", 0, 0, "", "", zhituRequest.text, "");
    }

    public static int u(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                if (i3 != 7220) {
                    return 4;
                }
                return 5;
            }
            return 2;
        }
        return 3;
    }

    private void u0(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "realSendZhituSafeGateRequest start");
        }
        if (StringUtil.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("ZhituManager", 1, "realSendZhituSafeGateRequest iCurrentUin is Empty");
                return;
            }
            return;
        }
        ZhituSafeGate$ReqBody zhituSafeGate$ReqBody = new ZhituSafeGate$ReqBody();
        try {
            zhituSafeGate$ReqBody.uint64_src_uin.set(Long.parseLong(str));
            zhituSafeGate$ReqBody.uint32_src_term.set(3);
        } catch (Throwable unused) {
        }
        NewIntent newIntent = new NewIntent(this.Z.getApp(), f.class);
        newIntent.putExtra("ZhituCMD", "ZhituGate.Check");
        newIntent.putExtra("ZhituRequestBytes", zhituSafeGate$ReqBody.toByteArray());
        this.Z.startServlet(newIntent);
    }

    private synchronized void v(File file) throws IOException {
        if (this.M == null) {
            this.M = new HashMap();
        }
        if (!this.M.containsKey(file)) {
            File file2 = new File(file, ".nomedia");
            if (!file2.exists() && file2.createNewFile()) {
                this.M.put(file, Boolean.TRUE);
            }
        }
    }

    private void v0(String str, ZhituResponse zhituResponse) {
        List<ZhituImgResponse> list = zhituResponse.list;
        if (list == null) {
            QLog.d("ZhituManager", 1, x(str, "removeDuplicateImg", "the list is null"));
            return;
        }
        HashSet hashSet = new HashSet(list.size());
        ArrayList arrayList = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!hashSet.add(list.get(i3))) {
                if (QLog.isColorLevel()) {
                    QLog.e("ZhituManager", 2, x(str, "removeDuplicateImg", "find duplication res: " + list.get(i3)));
                }
            } else {
                arrayList.add(list.get(i3));
            }
        }
        zhituResponse.list = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String w(String str, String str2, int i3, String str3) {
        return x(str, str2, "[" + i3 + "]" + str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w0(OutOfMemoryError outOfMemoryError) {
        com.tencent.qqperf.monitor.crash.catchedexception.a.c(outOfMemoryError, "ZhituCreateBitmapCatchedExceptionOOM when create bitmap with count: " + f180302g0);
        QLog.d("ZhituManager", 1, "create bitmap but oom, " + f180302g0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String x(String str, String str2, String str3) {
        return String.format("[%s][%s]: %s", str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ZhituResponse zhituResponse, String str, int i3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, w(str, "generateFullTextZhitu", i3, ""));
        }
        Bitmap A0 = A0(200, 200);
        if (A0 == null) {
            return;
        }
        Canvas canvas = new Canvas(A0);
        Paint paint = new Paint();
        paint.setColor(-1);
        Rect rect = new Rect(0, 0, 200, 200);
        canvas.drawRect(rect, paint);
        Bitmap h16 = g.l().h(A0, str2, zhituResponse.tokens, "#000000", rect, 3, str, i3, this.E);
        if (h16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "generate full text zhitu fail");
            }
        } else {
            k0(null, h16, str, i3, "https://img.qq.com/zhitu/fulltext.jpg", "mario" + System.currentTimeMillis(), "WhiteBack", null, true);
        }
    }

    private void z0(Bundle bundle) {
        String string = bundle.getString("ReqUniqueKey");
        if (!N().equals(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, x(string, "retryFailDownload", "reqKey is outdated, skip."));
                return;
            }
            return;
        }
        int i3 = bundle.getInt("RetryCount", 0);
        int i16 = bundle.getInt("IdxInRes");
        String string2 = bundle.getString("ReqUniqueKey");
        if (i3 >= 3) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, x(string2, "retryFailDownload", "max retry limitation is reached."));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, x(string2, "retryFailDownload", "current retry count is " + i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, x(string2, "retryFailDownload", "retry img download"));
        }
        bundle.putInt("RetryCount", i3 + 1);
        ZhituResponse zhituResponse = (ZhituResponse) bundle.getParcelable("ZhituRespose");
        ZhituImgResponse zhituImgResponse = (ZhituImgResponse) bundle.getParcelable("ImgResponse");
        String string3 = bundle.getString("QueryText");
        bundle.remove("ErrorCode");
        U0(zhituResponse, string2, this.Z, i16, zhituImgResponse, string3, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String A(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        boolean z16 = true;
        if (U() != 1) {
            z16 = false;
        }
        Object obj = TtmlNode.ATTR_TTS_ORIGIN;
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Zhitu_");
            sb5.append(cVar.f180384c);
            sb5.append("_");
            g.a aVar = cVar.f180385d;
            if (aVar != null) {
                obj = Integer.valueOf(aVar.hashCode());
            }
            sb5.append(obj);
            return sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Zhitu_");
        sb6.append(cVar.f180384c);
        sb6.append("_");
        g.a aVar2 = cVar.f180385d;
        if (aVar2 != null && cVar.f180394m) {
            obj = Integer.valueOf(aVar2.hashCode());
        }
        sb6.append(obj);
        return sb6.toString();
    }

    public int B() {
        return this.F;
    }

    public synchronized String C() {
        return this.C;
    }

    public void E0(QQAppInterface qQAppInterface, String str, int i3, String str2, List<String> list, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, x(str, "sendZhituRequest", "start sending request"));
        }
        ZhituRequest zhituRequest = new ZhituRequest();
        zhituRequest.uin = qQAppInterface.getCurrentUin();
        zhituRequest.f180376os = "android";
        zhituRequest.text = str2;
        zhituRequest.styles = 3;
        zhituRequest.chat = r(i3);
        zhituRequest.version = AppSetting.f99551k;
        if (this.f180310e.containsKey(qQAppInterface.getCurrentUin())) {
            e eVar = new e();
            eVar.f180405a = list;
            eVar.f180408d = this.f180312f.get(qQAppInterface.getCurrentUin());
            eVar.f180407c = this.f180310e.get(qQAppInterface.getCurrentUin());
            eVar.f180406b = t(i3);
            zhituRequest.report = eVar;
        }
        t0(qQAppInterface, str, zhituRequest, 0, this.I);
    }

    public void F0(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest start");
        }
        if (!com.tencent.mobileqq.flashchat.e.d(qQAppInterface).f(qQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest isZhituLegalOpen is fales return");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - T();
        if (currentTimeMillis < S() * 60000) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest time is short return time = " + currentTimeMillis);
                return;
            }
            return;
        }
        u0(qQAppInterface.getCurrentUin());
    }

    public void K0(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "setPageLen: " + i3);
        }
        this.f180316m = i3;
        ea.o5(this.Z.getApp(), this.Z.getCurrentAccountUin(), i3);
    }

    public synchronized void L0(String str, String str2) {
        this.f180315i = str;
        this.C = str2;
    }

    public synchronized String N() {
        return this.f180315i;
    }

    public void N0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "setZhituConfigOpen: " + z16);
        }
        this.W = z16;
        ea.t5(this.Z.getApp(), this.Z.getCurrentAccountUin(), z16);
    }

    public File O(@NonNull String str, @Nullable String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            return b(str2);
        }
        int lastIndexOf = str.lastIndexOf("/") + 1;
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf < lastIndexOf2) {
            str3 = str.substring(lastIndexOf, lastIndexOf2);
        } else {
            str3 = "fakeFileName";
        }
        return new File(P(), str3 + "_" + System.currentTimeMillis());
    }

    public void O0(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "setZhituSafeGateRequestInterval: " + i3);
        }
        this.f180311e0 = i3;
        ea.p5(this.Z.getApp(), this.Z.getCurrentAccountUin(), i3);
    }

    public void P0(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "setZhituSafeGateRequestTime: " + j3);
        }
        this.f180309d0 = j3;
        ea.q5(this.Z.getApp(), this.Z.getCurrentAccountUin(), j3);
    }

    public void R0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "setZhituSafeGateSwitch: " + z16);
        }
        this.f180307c0 = z16;
        ea.r5(this.Z.getApp(), this.Z.getCurrentAccountUin(), z16);
    }

    public int S() {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "getZhituSafeGateRequestInterval = " + this.f180311e0);
        }
        return this.f180311e0;
    }

    public void S0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "setZhituSaveAndShareSwitch: " + z16);
        }
        this.f180306b0 = z16;
        ea.s5(this.Z.getApp(), this.Z.getCurrentAccountUin(), z16);
    }

    public long T() {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "getZhituSafeGateRequestTime = " + this.f180309d0);
        }
        return this.f180309d0;
    }

    public void T0() {
        if (this.D) {
            return;
        }
        File F = F();
        if (!F.exists() && !F.mkdirs()) {
            return;
        }
        File file = new File(F, "font");
        if (file.exists() && "f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(n(file.getAbsolutePath()))) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "startDownload Font but file is exist and correct");
            }
            this.E = Typeface.createFromFile(file);
            this.D = true;
            return;
        }
        IHttpEngineService iHttpEngineService = (IHttpEngineService) this.Z.getRuntimeService(IHttpEngineService.class, "all");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mNeedIpConnect = true;
        httpNetReq.mNeedNotReferer = true;
        httpNetReq.mCallback = new c(this.I);
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mReqUrl = "https://dl.url.cn/myapp/qq_desk/qqrm/smartgif/lantingyuan.ttf";
        httpNetReq.mOutPath = file.getAbsolutePath();
        httpNetReq.mPrioty = 0;
        iHttpEngineService.sendReq(httpNetReq);
    }

    public int U() {
        AppInterface appInterface = this.Z;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            return com.tencent.mobileqq.flashchat.e.d((QQAppInterface) appInterface).i();
        }
        return 0;
    }

    public void V(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        this.I.sendMessage(this.I.obtainMessage(10, cVar));
    }

    public void Y0(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.T.h(cVar);
        }
        ZhituPanelView zhituPanelView = this.S;
        if (zhituPanelView != null && zhituPanelView.getVisibility() == 0) {
            this.U.u(cVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.zhitu.g.c
    public String a() {
        File P = P();
        if (!P.exists() && !P.mkdirs()) {
            return null;
        }
        try {
            v(P);
        } catch (IOException unused) {
        }
        return P.getAbsolutePath();
    }

    public void a0(final QQAppInterface qQAppInterface, Editable editable, final int i3, boolean z16) {
        long j3;
        M0(true);
        final String obj = editable.toString();
        if (!TextUtils.isEmpty(obj) && obj.length() <= 24 && e0(editable)) {
            ZhituPanelView zhituPanelView = this.S;
            if (zhituPanelView != null && zhituPanelView.F() != null) {
                this.S.F().setEnabled(false);
            }
            y0();
            p();
            if (this.H == null) {
                HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("ZhituThread", 8);
                this.H = newFreeHandlerThread;
                newFreeHandlerThread.start();
                Handler handler = new Handler(this.H.getLooper(), this);
                this.I = handler;
                I0(handler.getLooper().getQueue());
                ThreadPoolParams threadPoolParams = new ThreadPoolParams();
                threadPoolParams.corePoolsize = 1;
                threadPoolParams.maxPooolSize = 1;
                threadPoolParams.priority = 8;
                threadPoolParams.poolThreadName = "ZhituImgGenerateThreadPool";
                this.J = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
            }
            final String str = com.tencent.securitysdk.utils.c.b(obj) + "_" + System.currentTimeMillis();
            L0(str, obj);
            Message obtainMessage = this.I.obtainMessage(1, new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ZhituManager.this.F = i3;
                    ZhituManager zhituManager = ZhituManager.this;
                    zhituManager.o(zhituManager.K);
                    ZhituManager.this.G.clear();
                    ZhituManager.this.q();
                    ZhituManager.this.E0(qQAppInterface, str, i3, obj.trim(), null, 0);
                }
            });
            Handler handler2 = this.I;
            if (z16) {
                j3 = 500;
            } else {
                j3 = 0;
            }
            handler2.sendMessageDelayed(obtainMessage, j3);
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, x(str, "pending request", ""));
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.zhitu.g.c
    public File b(@NonNull String str) {
        return new File(P(), new File(str).getName() + "_" + System.currentTimeMillis());
    }

    public void b0(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        V(cVar);
    }

    public boolean e0(Editable editable) {
        String obj = editable.toString();
        boolean z16 = false;
        if (!TextUtils.isEmpty(obj) && com.tencent.mobileqq.text.TextUtils.hasEmoji(obj) <= -1 && !com.tencent.mobileqq.text.TextUtils.hasSysEmotion(obj)) {
            ArrayList arrayList = new ArrayList();
            com.tencent.mobileqq.troop.text.a.c(editable, arrayList);
            if (arrayList.size() <= 0) {
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "isLegal: " + z16 + " / " + com.tencent.securitysdk.utils.c.b(obj));
        }
        return z16;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Typeface typeface;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 7) {
                            if (i3 != 8) {
                                if (i3 != 10) {
                                    if (i3 != 100) {
                                        if (i3 == 101) {
                                            this.N++;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("ZhituManager", 2, "download font fail, retry count: " + this.N);
                                            }
                                            if (this.N <= 3) {
                                                H0(Looper.myQueue());
                                            }
                                        }
                                    } else {
                                        File G = G();
                                        if (G.exists()) {
                                            typeface = Typeface.createFromFile(G);
                                        } else {
                                            typeface = null;
                                        }
                                        this.E = typeface;
                                        this.D = true;
                                    }
                                } else {
                                    Y((com.tencent.mobileqq.activity.aio.zhitu.c) message.obj);
                                }
                            } else {
                                Object obj = message.obj;
                                if (obj instanceof HttpNetReq) {
                                    this.K.remove(obj);
                                }
                            }
                        } else {
                            C0(message);
                        }
                    } else {
                        z0((Bundle) message.obj);
                    }
                } else {
                    W(message);
                }
            } else {
                Bundle bundle = (Bundle) message.obj;
                n0(bundle.getInt("ErrorCode"), (ZhituResponse) bundle.getParcelable("Response"), bundle.getString("UniqueKey"), bundle.getInt("StartIdx", 0), bundle.getString("QueryText"));
            }
        } else {
            ((Runnable) message.obj).run();
        }
        return true;
    }

    public boolean i0() {
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "isZhituSafeGateSwitch = " + this.f180307c0);
        }
        return this.f180307c0;
    }

    public boolean j0() {
        return this.f180306b0;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        if (this.Q != null) {
            this.Q = null;
            this.R = null;
            this.T = null;
        }
        if (this.S != null) {
            this.S = null;
            this.U = null;
        }
        if (this.H != null && this.I != null) {
            p();
            this.I.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.13
                @Override // java.lang.Runnable
                public void run() {
                    ZhituManager zhituManager = ZhituManager.this;
                    zhituManager.o(zhituManager.K);
                    ZhituManager.this.X0(false);
                    Looper.myLooper().quit();
                }
            });
        }
        Executor executor = this.J;
        if (executor instanceof ExecutorService) {
            ((ExecutorService) executor).shutdown();
        }
    }

    public void p0(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        QQAppInterface qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "onSend:" + cVar);
        }
        this.f180312f.put(this.Z.getCurrentAccountUin(), C());
        this.f180310e.put(this.Z.getCurrentAccountUin(), cVar.f180389h);
        d dVar = cVar.f180393l;
        dVar.f180399d = 1;
        this.f180314h.add(dVar);
        AppInterface appInterface = this.Z;
        if (appInterface instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appInterface;
        } else {
            qQAppInterface = null;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800ADCD", "0X800ADCD", 0, 0, "", "", cVar.f180389h, "");
    }

    public void q0(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        QQAppInterface qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "onShow:" + cVar);
        }
        d dVar = cVar.f180393l;
        dVar.f180399d = 0;
        this.f180314h.add(dVar);
        AppInterface appInterface = this.Z;
        if (appInterface instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appInterface;
        } else {
            qQAppInterface = null;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800ADCC", "0X800ADCC", 0, 0, "", "", cVar.f180389h, "");
    }

    public void x0(int i3, String str) {
        QQAppInterface qQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, w(str, "requestDownloadMoreImg", i3, ""));
        }
        Message obtainMessage = this.I.obtainMessage(7);
        obtainMessage.obj = str;
        obtainMessage.arg1 = i3;
        this.I.sendMessage(obtainMessage);
        AppInterface appInterface = this.Z;
        if (appInterface instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appInterface;
        } else {
            qQAppInterface = null;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8008C73", "0X8008C73", u(this.F), 0, "", "", "", "");
    }

    public void y0() {
        ZhituPanelView.c cVar;
        ZhituPanelView zhituPanelView = this.S;
        if (zhituPanelView != null && zhituPanelView.getVisibility() == 0 && (cVar = this.U) != null) {
            cVar.q();
        }
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            ZhituPicAdapter zhituPicAdapter = (ZhituPicAdapter) this.R.getAdapter();
            this.T = zhituPicAdapter;
            if (zhituPicAdapter == null) {
                return;
            }
            zhituPicAdapter.f();
            this.R.resetCurrentX(0);
            this.T.notifyDataSetChanged();
        }
    }

    @Nullable
    public String z(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
        if (cVar.f180386e && cVar.f180385d != null) {
            return g.l().i(cVar.f180384c, cVar.f180385d, cVar.f180387f, cVar.f180388g, this);
        }
        return null;
    }

    public void m0(com.tencent.mobileqq.activity.aio.zhitu.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        private Handler f180341d;

        b(Handler handler) {
            this.f180341d = handler;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            Message message;
            Message obtainMessage = this.f180341d.obtainMessage(8);
            obtainMessage.obj = netResp.mReq;
            this.f180341d.sendMessage(obtainMessage);
            Bundle bundle = (Bundle) netResp.mReq.getUserData();
            String string = bundle.getString("ReqUniqueKey");
            int i3 = bundle.getInt("IdxInRes");
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, ZhituManager.w(string, "onResp", i3, " zhitu img download onResp result fileSize = " + netResp.mTotalFileLen + " file.path = " + netResp.mReq.mOutPath + " resp.result = " + netResp.mResult + " take time: " + Long.toString(System.currentTimeMillis() - bundle.getLong("StartTs"))));
            }
            int i16 = netResp.mResult;
            if (i16 == 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("ZhituManager", 2, ZhituManager.w(string, "OnResp", i3, "result downloading, "));
                    return;
                }
                return;
            }
            if (i16 == 0) {
                ZhituImgResponse zhituImgResponse = (ZhituImgResponse) bundle.getParcelable("ImgResponse");
                ZhituManager.n(netResp.mReq.mOutPath);
                if (zhituImgResponse != null) {
                    message = this.f180341d.obtainMessage(3);
                    message.obj = bundle;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("ZhituManager", 2, ZhituManager.x(string, "onResp", "download succ but md5 is mismatched"));
                    }
                    message = this.f180341d.obtainMessage(4);
                    bundle.putInt("ErrorCode", 99999);
                    message.obj = bundle;
                }
            } else {
                Message obtainMessage2 = this.f180341d.obtainMessage(4);
                bundle.putInt("ErrorCode", netResp.mErrCode);
                obtainMessage2.obj = bundle;
                message = obtainMessage2;
            }
            this.f180341d.sendMessage(message);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        private Handler f180342d;

        c(Handler handler) {
            this.f180342d = handler;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituManager", 2, "FontDownloadListener onResp: " + netResp);
            }
            int i3 = netResp.mResult;
            if (i3 == 3) {
                return;
            }
            if (i3 == 0) {
                if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(ZhituManager.n(netResp.mReq.mOutPath))) {
                    this.f180342d.sendEmptyMessage(100);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ZhituManager", 2, "font download but md5 is not matched");
                }
                this.f180342d.sendEmptyMessage(101);
                return;
            }
            this.f180342d.sendEmptyMessage(101);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
