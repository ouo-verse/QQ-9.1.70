package iq;

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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Liq/d;", "", "", "d", "", "url", "i", h.F, "e", "", "g", "b", "Ljava/lang/String;", "DOWNLOAD_PATH_ONLINE", "", "c", "Z", "hasLoaded", "I", "buffersize", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasLoaded;

    /* renamed from: a, reason: collision with root package name */
    public static final d f408183a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String DOWNLOAD_PATH_ONLINE = u53.b.f438374e + File.separator + "capture_buffer_size.json";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile int buffersize = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"iq/d$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"iq/d$b", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements INetEngineListener {
        b() {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            ms.a.f("CaptureBufferSizeHelper", "download succeeded : " + (resp.mResult == 0));
            if (FileUtils.fileExists(d.DOWNLOAD_PATH_ONLINE)) {
                ms.a.f("CaptureBufferSizeHelper", "download loadLocalConfigJson");
                d.f408183a.h();
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
        String configUrl = uq3.c.O0();
        ms.a.f("CaptureBufferSizeHelper", "configUrl = " + configUrl);
        os.a aVar = os.a.f423933a;
        String d16 = aVar.d("CaptureBufferSizeHelper", "https://downv6.qq.com/shadow_qqcamera/Android/capture_buffer_size.json");
        ms.a.f("CaptureBufferSizeHelper", "localUrl = " + d16);
        if (Intrinsics.areEqual(configUrl, d16) && FileUtils.fileExists(DOWNLOAD_PATH_ONLINE)) {
            if (hasLoaded) {
                return;
            }
            ms.a.f("CaptureBufferSizeHelper", "downloadConfigIfNeed loadLocalConfigJson");
            h();
            return;
        }
        q.d(DOWNLOAD_PATH_ONLINE);
        Intrinsics.checkNotNullExpressionValue(configUrl, "configUrl");
        aVar.h("CaptureBufferSizeHelper", configUrl);
        i(configUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        ms.a.f("CaptureBufferSizeHelper", "downloadConfigInSubThread");
        f408183a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        boolean z16;
        Set keySet;
        hasLoaded = true;
        try {
            String z17 = QIMPtvTemplateManager.z(new File(DOWNLOAD_PATH_ONLINE));
            ms.a.f("CaptureBufferSizeHelper", "loadLocalConfigJson json = " + z17 + "\uff0c MODEL = " + DeviceInfoMonitor.getModel());
            Map map = (Map) new Gson().fromJson(z17, new a().getType());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("modelsMap = ");
            sb5.append(map);
            ms.a.f("CaptureBufferSizeHelper", sb5.toString());
            if (map != null && (keySet = map.keySet()) != null && !keySet.isEmpty()) {
                Iterator it = keySet.iterator();
                while (it.hasNext()) {
                    if (DeviceInfoMonitor.getModel().equals((String) it.next())) {
                        z16 = false;
                        break;
                    }
                }
            }
            z16 = true;
            if (!z16) {
                String str = (String) map.get(DeviceInfoMonitor.getModel());
                buffersize = str != null ? Integer.parseInt(str) : 1;
            }
        } catch (Exception e16) {
            ms.a.d("CaptureBufferSizeHelper", "loadLocalConfigJson encounter error(not crash)", e16);
        }
    }

    private final void i(String url) {
        ms.a.f("CaptureBufferSizeHelper", "realDownloadConfig = " + url);
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
            ms.a.c("CaptureBufferSizeHelper", "[downloadEnhance], error=" + e16);
        }
    }

    public final void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: iq.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f();
            }
        }, 16, null, false);
    }

    public final int g() {
        ms.a.f("CaptureBufferSizeHelper", "getBufferSize bufferSize = " + buffersize);
        return buffersize;
    }
}
