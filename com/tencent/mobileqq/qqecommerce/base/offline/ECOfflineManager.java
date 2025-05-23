package com.tencent.mobileqq.qqecommerce.base.offline;

import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.offline.api.IECOfflineManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J5\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u0017j\u0002`\u001aH\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/offline/ECOfflineManager;", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager;", "", "bid", "", "deleteOffline", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$OfflineDownloadState;", "Lkotlin/ParameterName;", "name", "downloadState", "resultBlock", "downloadOffline", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$a;", "offlineStrongCallback", "getBidVersion", "filePath", "Ljava/io/File;", "getOfflineFile", "loadOffline", "", "offlineExist", "url", "Lkotlin/Function2;", "", "", "Lcom/tencent/ecommerce/base/offline/api/ECLoadUrlOfflineCallback;", "callback", "loadOfflineWithUrl", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECOfflineManager implements IECOfflineManager {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/offline/ECOfflineManager$b", "Lcom/tencent/biz/common/offline/a;", "", "param1", "", "code", "", "loaded", "progress", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f262438d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, Long, Unit> f262439e;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function2<? super Integer, ? super Long, Unit> function2) {
            this.f262438d = str;
            this.f262439e = function2;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String param1, int code) {
            JSONObject t16 = HtmlOffline.t(this.f262438d);
            long optLong = t16 != null ? t16.optLong("version", 0L) : 0L;
            this.f262439e.invoke(Integer.valueOf(code), Long.valueOf(optLong));
            QLog.i("ECOfflineManager", 1, "[loadOfflineWithUrl] loaded code = " + code + " params = " + param1 + " version = " + optLong);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
            QLog.i("ECOfflineManager", 1, "[loadOfflineWithUrl] progress = " + progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String bid) {
        Intrinsics.checkNotNullParameter(bid, "$bid");
        HtmlOffline.o(c.c(bid) + bid, bid);
    }

    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    public void deleteOffline(final String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.base.offline.a
            @Override // java.lang.Runnable
            public final void run() {
                ECOfflineManager.b(bid);
            }
        });
    }

    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    public void downloadOffline(String bid, Function1<? super IECOfflineManager.OfflineDownloadState, Unit> resultBlock) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        HtmlOffline.k(bid, BaseApplicationImpl.getApplication().getRuntime(), new com.tencent.mobileqq.qqecommerce.base.offline.b(resultBlock), true, 0, true);
    }

    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    public String getBidVersion(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        String z16 = HtmlOffline.z(bid);
        return z16 == null ? "" : z16;
    }

    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    public File getOfflineFile(String bid, String filePath) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            String c16 = c.c(bid);
            if (c16 == null) {
                return null;
            }
            File file = new File((c16 + bid + File.separator) + filePath);
            if (file.exists()) {
                return file;
            }
            QLog.w("ECOfflineManager", 1, "offline file not exist: " + filePath + ", bid: " + bid);
            return null;
        } catch (Exception e16) {
            QLog.e("ECOfflineManager", 1, "getOfflineFile error: bid: " + bid + ", filePath: " + filePath + ", e: " + e16);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0012, code lost:
    
        r2 = kotlin.io.FilesKt__FileReadWriteKt.readText$default(r2, null, 1, null);
     */
    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String loadOffline(String bid, String filePath) {
        String readText$default;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File offlineFile = getOfflineFile(bid, filePath);
        return (offlineFile == null || readText$default == null) ? "" : readText$default;
    }

    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    public void loadOfflineWithUrl(String bid, String url, Function2<? super Integer, ? super Long, Unit> callback) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ECOfflineManager", 1, "[loadOfflineWithUrl] start url = " + url);
        BidDownloader bidDownloader = new BidDownloader(bid, BaseApplicationImpl.getApplication().getRuntime(), new b(bid, callback), true, 3);
        bidDownloader.L = 0;
        bidDownloader.E = true;
        bidDownloader.f78391h = true;
        bidDownloader.I = url;
        bidDownloader.J = 0;
        bidDownloader.e();
    }

    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    public boolean offlineExist(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        String c16 = c.c(bid);
        if (c16 == null) {
            return false;
        }
        return new File(c16 + bid + File.separator).exists();
    }

    @Override // com.tencent.ecommerce.base.offline.api.IECOfflineManager
    public void downloadOffline(String bid, final IECOfflineManager.OfflineStrongCallback offlineStrongCallback) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        com.tencent.mobileqq.qqecommerce.base.offline.b bVar = new com.tencent.mobileqq.qqecommerce.base.offline.b(new Function1<IECOfflineManager.OfflineDownloadState, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.offline.ECOfflineManager$downloadOffline$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IECOfflineManager.OfflineDownloadState offlineDownloadState) {
                invoke2(offlineDownloadState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IECOfflineManager.OfflineDownloadState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                IECOfflineManager.OfflineStrongCallback offlineStrongCallback2 = IECOfflineManager.OfflineStrongCallback.this;
                if (offlineStrongCallback2 != null) {
                    offlineStrongCallback2.b(null);
                    Function1<IECOfflineManager.OfflineDownloadState, Unit> a16 = offlineStrongCallback2.a();
                    if (a16 != null) {
                        a16.invoke(it);
                    }
                }
            }
        });
        if (offlineStrongCallback != null) {
            offlineStrongCallback.b(bVar);
        }
        HtmlOffline.k(bid, BaseApplicationImpl.getApplication().getRuntime(), bVar, true, 0, true);
    }
}
