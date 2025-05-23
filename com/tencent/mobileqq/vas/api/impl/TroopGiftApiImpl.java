package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.api.ITroopGiftApi;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\tH\u0016JF\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/TroopGiftApiImpl;", "Lcom/tencent/mobileqq/vas/api/ITroopGiftApi;", "", "getBirthPagPath", "", "tianquanId", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "Lkotlin/Function0;", "", "callback", "startGiftPagDownload", "getHeadPagPath", "preLoadGiftHeadPag", "pageId", "itemId", "subItemId", "itemType", "actionId", "", "busiInfoMap", "reportTroopBirthGift", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TroopGiftApiImpl implements ITroopGiftApi {

    @NotNull
    private static final String TAG = "TroopGiftApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/api/impl/TroopGiftApiImpl$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f308477a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f308478b;

        b(String str, Function0<Unit> function0) {
            this.f308477a = str;
            this.f308478b = function0;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("onLoadSuccess " + this.f308477a + " reply");
            this.f308478b.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preLoadGiftHeadPag$lambda$0() {
        ITroopGiftApi.Companion companion = ITroopGiftApi.INSTANCE;
        if (!new File(companion.getPAG_FILE_SAVE_PATH()).exists()) {
            ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(new com.tencent.mobileqq.vip.g("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/vas_qq_arnopeng/guild_aio_gift_head.pag", new File(companion.getPAG_FILE_SAVE_PATH())), MobileQQ.sMobileQQ.peekAppRuntime());
        }
        if (!new File(companion.getPAG_FILE_SAVE_PATH_FOR_BIRTH()).exists()) {
            ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(new com.tencent.mobileqq.vip.g("https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_avatars.pag", new File(companion.getPAG_FILE_SAVE_PATH_FOR_BIRTH())), MobileQQ.sMobileQQ.peekAppRuntime());
        }
        String birthPagPath = ((ITroopGiftApi) QRoute.api(ITroopGiftApi.class)).getBirthPagPath();
        if (!new File(birthPagPath).exists()) {
            ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(new com.tencent.mobileqq.vip.g("https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_anim.pag", new File(birthPagPath)), MobileQQ.sMobileQQ.peekAppRuntime());
        }
    }

    @Override // com.tencent.mobileqq.vas.api.ITroopGiftApi
    @NotNull
    public String getBirthPagPath() {
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) com.tencent.mobileqq.qqgift.updatasystem.c.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026:class.java\n            )");
        String savePath = ((QQGiftResourceBusiness) businessInstance).getSavePath("birth_bg");
        Intrinsics.checkNotNullExpressionValue(savePath, "giftResourceBusiness.getSavePath(\"birth_bg\")");
        return savePath;
    }

    @Override // com.tencent.mobileqq.vas.api.ITroopGiftApi
    @NotNull
    public String getHeadPagPath(int tianquanId) {
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) com.tencent.mobileqq.qqgift.updatasystem.c.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026:class.java\n            )");
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) businessInstance;
        String savePath = qQGiftResourceBusiness.getSavePath(qQGiftResourceBusiness.f(tianquanId, 3));
        Intrinsics.checkNotNullExpressionValue(savePath, "giftResourceBusiness.getSavePath(scId)");
        return savePath;
    }

    @Override // com.tencent.mobileqq.vas.api.ITroopGiftApi
    public boolean isDownloaded(int tianquanId) {
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) com.tencent.mobileqq.qqgift.updatasystem.c.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026:class.java\n            )");
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) businessInstance;
        return qQGiftResourceBusiness.isFileExist(qQGiftResourceBusiness.f(tianquanId, 3));
    }

    @Override // com.tencent.mobileqq.vas.api.ITroopGiftApi
    public void preLoadGiftHeadPag() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.w
            @Override // java.lang.Runnable
            public final void run() {
                TroopGiftApiImpl.preLoadGiftHeadPag$lambda$0();
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.vas.api.ITroopGiftApi
    public void reportTroopBirthGift(@NotNull String pageId, @NotNull String itemId, @NotNull String subItemId, @NotNull String itemType, int actionId, @Nullable Map<String, String> busiInfoMap) {
        Map<String, String> map;
        String str;
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(subItemId, "subItemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        if (busiInfoMap == null) {
            map = MapsKt__MapsKt.emptyMap();
        } else {
            map = busiInfoMap;
        }
        try {
            str = new JSONObject(map).toString();
        } catch (Exception unused) {
            str = null;
        }
        String str2 = str;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 4, "report to 04586: pageId:" + pageId + " itemId:" + itemId + " subItemId:" + subItemId + " itemType:" + itemType + " actionId:" + actionId + " busin:" + str2);
        }
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction("group_gift", pageId, "", "", itemId, subItemId, itemType, actionId, 0, 0, "", str2, "");
    }

    @Override // com.tencent.mobileqq.vas.api.ITroopGiftApi
    public void startGiftPagDownload(int tianquanId, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) com.tencent.mobileqq.qqgift.updatasystem.c.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026:class.java\n            )");
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) businessInstance;
        String f16 = qQGiftResourceBusiness.f(tianquanId, 3);
        if (!qQGiftResourceBusiness.isFileExist(f16)) {
            qQGiftResourceBusiness.addDownLoadListener(f16, new b(f16, callback));
            qQGiftResourceBusiness.startDownload(f16);
        } else {
            callback.invoke();
        }
    }
}
