package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.VasTempConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\nH&JF\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H&J\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/api/ITroopGiftApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBirthPagPath", "", "getHeadPagPath", "tianquanId", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "", "preLoadGiftHeadPag", "", "reportTroopBirthGift", "pageId", "itemId", "subItemId", "itemType", "actionId", "busiInfoMap", "", "startGiftPagDownload", "callback", "Lkotlin/Function0;", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ITroopGiftApi extends QRouteApi {

    @NotNull
    public static final String BG_PAG_EFFECT_BIRTH = "https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_anim.pag";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String PAG_FILE_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/vas_qq_arnopeng/guild_aio_gift_head.pag";

    @NotNull
    public static final String PAG_FILE_URL_FRO_BIRTH = "https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_avatars.pag";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/ITroopGiftApi$Companion;", "", "()V", "BG_PAG_EFFECT_BIRTH", "", "PAG_FILE_SAVE_PATH", "getPAG_FILE_SAVE_PATH", "()Ljava/lang/String;", "PAG_FILE_SAVE_PATH_FOR_BIRTH", "getPAG_FILE_SAVE_PATH_FOR_BIRTH", "PAG_FILE_URL", "PAG_FILE_URL_FRO_BIRTH", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String BG_PAG_EFFECT_BIRTH = "https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_anim.pag";

        @NotNull
        private static final String PAG_FILE_SAVE_PATH;

        @NotNull
        private static final String PAG_FILE_SAVE_PATH_FOR_BIRTH;

        @NotNull
        public static final String PAG_FILE_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/vas_qq_arnopeng/guild_aio_gift_head.pag";

        @NotNull
        public static final String PAG_FILE_URL_FRO_BIRTH = "https://tianquan.gtimg.cn/uncategorized/vas_groupgift_birthark_avatars.pag";

        static {
            String str = VasTempConstant.GUILD_DOWN_LOAD_DIR;
            PAG_FILE_SAVE_PATH = str + "guild_aio_gift_head.pag";
            PAG_FILE_SAVE_PATH_FOR_BIRTH = str + "birth_gift_head.pag";
        }

        Companion() {
        }

        @NotNull
        public final String getPAG_FILE_SAVE_PATH() {
            return PAG_FILE_SAVE_PATH;
        }

        @NotNull
        public final String getPAG_FILE_SAVE_PATH_FOR_BIRTH() {
            return PAG_FILE_SAVE_PATH_FOR_BIRTH;
        }
    }

    @NotNull
    String getBirthPagPath();

    @NotNull
    String getHeadPagPath(int tianquanId);

    boolean isDownloaded(int tianquanId);

    void preLoadGiftHeadPag();

    void reportTroopBirthGift(@NotNull String pageId, @NotNull String itemId, @NotNull String subItemId, @NotNull String itemType, int actionId, @Nullable Map<String, String> busiInfoMap);

    void startGiftPagDownload(int tianquanId, @NotNull Function0<Unit> callback);
}
