package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.qqnt.aio.api.INTZPlanAvatarView;
import com.tencent.qqnt.aio.api.f;
import com.tencent.qqnt.aio.api.g;
import com.tencent.qqnt.aio.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&J8\u0010#\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H&J\u0012\u0010'\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0007H&J\b\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J \u0010.\u001a\u00020,2\u0006\u0010+\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,H&J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020$2\u0006\u00100\u001a\u00020/H\u0016J \u00104\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020$2\u0006\u00102\u001a\u00020,2\u0006\u00100\u001a\u000203H\u0016J \u00108\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020$2\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u0016H\u0016J$\u0010<\u001a\u0004\u0018\u00010;2\u0006\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010=\u001a\u00020\u000eH\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J\b\u0010?\u001a\u00020\u000eH\u0016J\u0018\u0010B\u001a\u00020\u00072\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\u0007H\u0016\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOTofuApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "aioCreate", "aioResume", "", "selfUin", "aioDelayLoad", "aioStop", "aioDestroy", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/aio/data/msglist/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "clickTofu", "uin", "Landroid/graphics/drawable/Drawable;", "getHeadDrawable", "Landroid/widget/ImageView;", "targetView", "url", "loadDrawableByUrl", "isTheTofuNeedFiltered", "Landroid/view/View;", "mAvatarStatusView", "Lcom/tencent/qqnt/aio/k;", "curOnlineStatus", "Landroidx/constraintlayout/widget/ConstraintLayout;", "tofuWithQQShowContainer", "Lcom/tencent/qqnt/aio/api/d;", "iNTAvatarStatusViewCb", "updateAvatarStatusView", "", "id", "checkNeedTimeStampForQQShowTofu", "getApngDrawable", "getConfig", "isRevealEnable", "isRingRevealEnable", "businessId", "", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "getBackgroundTextColor", "Lcom/tencent/qqnt/aio/api/g;", "cb", "getIsLike", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "Lcom/tencent/qqnt/aio/api/f;", "sendLikeStatus", "Landroid/widget/TextView;", "tv", "iv", "setOnlineStatusTextAndIcon", "busiExtra", "tofuWithZPlanAvatarContainer", "Lcom/tencent/qqnt/aio/api/INTZPlanAvatarView;", "updateZPlanAvatarView", "isHitZPlanAvatarExperiment", "getTofuConfig", "isTofuExperimentC", "busId", "text", "parseTofuContent", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOTofuApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull IAIOTofuApi iAIOTofuApi) {
            return "";
        }

        @NotNull
        public static String b(@NotNull IAIOTofuApi iAIOTofuApi) {
            return " {\"useNew\": bool}";
        }

        public static boolean c(@NotNull IAIOTofuApi iAIOTofuApi) {
            return false;
        }

        public static boolean d(@NotNull IAIOTofuApi iAIOTofuApi) {
            return true;
        }

        public static boolean e(@NotNull IAIOTofuApi iAIOTofuApi) {
            return true;
        }

        public static boolean f(@NotNull IAIOTofuApi iAIOTofuApi) {
            return true;
        }

        @NotNull
        public static String g(@NotNull IAIOTofuApi iAIOTofuApi, long j3, @NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return text;
        }

        @Nullable
        public static INTZPlanAvatarView h(@NotNull IAIOTofuApi iAIOTofuApi, @NotNull String busiExtra, @Nullable ConstraintLayout constraintLayout, @NotNull com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb) {
            Intrinsics.checkNotNullParameter(busiExtra, "busiExtra");
            Intrinsics.checkNotNullParameter(iNTAvatarStatusViewCb, "iNTAvatarStatusViewCb");
            return null;
        }
    }

    void aioCreate(@NotNull AIOParam aioParam);

    void aioDelayLoad(@NotNull String selfUin);

    void aioDestroy();

    void aioResume();

    void aioStop();

    boolean checkNeedTimeStampForQQShowTofu(long id5);

    void clickTofu(@NotNull Context context, boolean isScaleChat, @NotNull com.tencent.aio.data.msglist.a item);

    @Nullable
    Drawable getApngDrawable(@NotNull String url);

    int getBackgroundTextColor(long businessId, @NotNull String url, int defaultColor);

    @NotNull
    String getConfig();

    @Nullable
    Drawable getHeadDrawable(@Nullable String uin);

    void getIsLike(long uin, @NotNull g cb5);

    @NotNull
    String getTofuConfig();

    boolean isHitZPlanAvatarExperiment();

    boolean isRevealEnable();

    boolean isRingRevealEnable();

    boolean isTheTofuNeedFiltered(@NotNull com.tencent.aio.data.msglist.a item);

    boolean isTofuExperimentC();

    void loadDrawableByUrl(@NotNull ImageView targetView, @Nullable String url);

    @NotNull
    String parseTofuContent(long busId, @NotNull String text);

    void sendLikeStatus(long uin, int clickType, @NotNull f cb5);

    void setOnlineStatusTextAndIcon(long uin, @NotNull TextView tv5, @NotNull ImageView iv5);

    @Nullable
    View updateAvatarStatusView(@NotNull com.tencent.aio.data.msglist.a item, @Nullable View mAvatarStatusView, @Nullable k curOnlineStatus, @Nullable ConstraintLayout tofuWithQQShowContainer, @NotNull com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb);

    @Nullable
    INTZPlanAvatarView updateZPlanAvatarView(@NotNull String busiExtra, @Nullable ConstraintLayout tofuWithZPlanAvatarContainer, @NotNull com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb);
}
