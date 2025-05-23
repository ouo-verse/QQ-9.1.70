package aq;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Laq/d;", "", "", "d", "", "url", "i", h.F, "e", "", "g", "b", "Ljava/lang/Object;", "mLock", "c", "Ljava/lang/String;", "DOWNLOAD_PATH_ONLINE", "Z", "hasLoaded", "hasHited", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f26717a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Object mLock = new Object();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String DOWNLOAD_PATH_ONLINE = u53.b.f438374e + File.separator + "opengl_version.json";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasLoaded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasHited;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"aq/d$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a extends TypeToken<ArrayList<String>> {
        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"aq/d$b", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements INetEngineListener {
        b() {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            ms.a.f("EncodeEGLVersionHelper", "download succeeded : " + (resp.mResult == 0));
            if (FileUtils.fileExists(d.DOWNLOAD_PATH_ONLINE)) {
                ms.a.f("EncodeEGLVersionHelper", "download loadLocalConfigJson");
                d.f26717a.h();
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq req, long curOffset, long totalLen) {
            Intrinsics.checkNotNullParameter(req, "req");
        }
    }

    d() {
    }

    private final void d() {
        String configUrl = uq3.c.l7();
        ms.a.f("EncodeEGLVersionHelper", "configUrl = " + configUrl);
        os.a aVar = os.a.f423933a;
        String d16 = aVar.d("EncodeEGLVersionHelper", "https://downv6.qq.com/shadow_qqcamera/Android/res/opengl_version.json");
        ms.a.f("EncodeEGLVersionHelper", "localUrl = " + d16);
        if (Intrinsics.areEqual(configUrl, d16) && FileUtils.fileExists(DOWNLOAD_PATH_ONLINE)) {
            if (hasLoaded) {
                return;
            }
            ms.a.f("EncodeEGLVersionHelper", "downloadConfigIfNeed loadLocalConfigJson");
            h();
            return;
        }
        q.d(DOWNLOAD_PATH_ONLINE);
        Intrinsics.checkNotNullExpressionValue(configUrl, "configUrl");
        aVar.h("EncodeEGLVersionHelper", configUrl);
        i(configUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        ms.a.f("EncodeEGLVersionHelper", "downloadConfigInSubThread");
        f26717a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        boolean z16;
        boolean z17 = true;
        hasLoaded = true;
        try {
            String z18 = QIMPtvTemplateManager.z(new File(DOWNLOAD_PATH_ONLINE));
            ms.a.f("EncodeEGLVersionHelper", "loadLocalConfigJson json = " + z18 + "\uff0c MODEL = " + DeviceInfoMonitor.getModel());
            ArrayList arrayList = (ArrayList) new Gson().fromJson(z18, new a().getType());
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (DeviceInfoMonitor.getModel().equals((String) it.next())) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
            if (z16) {
                z17 = false;
            }
            hasHited = z17;
        } catch (Exception e16) {
            ms.a.d("EncodeEGLVersionHelper", "loadLocalConfigJson encounter error(not crash)", e16);
            hasHited = false;
        }
    }

    private final void i(String url) {
        ms.a.f("EncodeEGLVersionHelper", "realDownloadConfig = " + url);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = url;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = DOWNLOAD_PATH_ONLINE;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 30000L;
        httpNetReq.mCallback = new b();
        try {
            ((IHttpEngineService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            ms.a.c("EncodeEGLVersionHelper", "[downloadEnhance], error=" + e16);
        }
    }

    public final void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: aq.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f();
            }
        }, 16, null, false);
    }

    public final boolean g() {
        ms.a.f("EncodeEGLVersionHelper", "isOpen hasHited = " + hasHited);
        return hasHited;
    }
}
