package com.tencent.biz.pubaccount.weishi.download;

import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.g;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/download/WSPagDownloadUtil;", "", "", "f", "", "url", "b", "e", "", "g", "Ljava/io/File;", "c", "Z", "isInitPagSuccess", "Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "vasTempApi", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSPagDownloadUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final WSPagDownloadUtil f80656a = new WSPagDownloadUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isInitPagSuccess;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy vasTempApi;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IVasTempApi>() { // from class: com.tencent.biz.pubaccount.weishi.download.WSPagDownloadUtil$vasTempApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IVasTempApi invoke() {
                IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
                QRouteApi api = QRoute.api(IVasTempApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
                return (IVasTempApi) api;
            }
        });
        vasTempApi = lazy;
    }

    WSPagDownloadUtil() {
    }

    @JvmStatic
    public static final String b(String url) {
        List split$default;
        Object last;
        Intrinsics.checkNotNullParameter(url, "url");
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{"/"}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/" + ((String) last);
    }

    private final File c(String url) {
        return new File(b(url));
    }

    private final IVasTempApi d() {
        return (IVasTempApi) vasTempApi.getValue();
    }

    @JvmStatic
    public static final boolean e(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return f80656a.c(url).exists();
    }

    @JvmStatic
    public static final boolean f() {
        if (isInitPagSuccess) {
            x.i("WSPagDownloadUtil", "isPagSOLoad: true");
            return true;
        }
        boolean initPagSo = f80656a.d().initPagSo();
        isInitPagSuccess = initPagSo;
        x.i("WSPagDownloadUtil", "isPagSOLoad: " + initPagSo);
        return isInitPagSuccess;
    }

    @JvmStatic
    public static final void g(final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        final File c16 = f80656a.c(url);
        if (c16.exists()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.download.c
            @Override // java.lang.Runnable
            public final void run() {
                WSPagDownloadUtil.h(url, c16);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String url, File saveFile) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(saveFile, "$saveFile");
        ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(new g(url, saveFile), MobileQQ.sMobileQQ.peekAppRuntime());
    }
}
