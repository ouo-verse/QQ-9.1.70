package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.widget.theme.GuildMediaThemeChooseDialog;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016JU\u0010\u0017\u001a\u00020\u00022K\u0010\u0016\u001aG\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J_\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00102M\u0010\u0016\u001aI\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00020\u000fH\u0016JL\u0010)\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00102\"\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`'H\u0016JT\u0010,\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\"\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`'H\u0016J<\u00100\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\"\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`'H\u0016J(\u00102\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J!\u00107\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u000205H\u0016\u00a2\u0006\u0004\b7\u00108J\b\u00109\u001a\u00020\u0010H\u0016\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildMediaChannelApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildMediaChannelApi;", "", "checkNetwork", "", "getDefaultTaskUrl", "getDefaultRankUrl", "Landroid/content/Context;", "getContext", "", "curChannelHasInputPermission", "isLowDisplayMode", "openIndex", "tag", "openMediaThemeChooseDialog", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "retCode", "retMsg", "needToast", "callback", "openMicByClickInviteMsg", "checkHasAlreadyDoRequest", "", "extra", "handleGiftItemTipsClick", "guildId", "tinyId", "handleGiftNickNameClick", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "suc", "filePath", "getGiftResFilePathByMaterialId", "url", "channelId", "panelHeight", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QQBrowserActivity.APP_PARAM, "openGiftTaskH5", "rankType", "durationType", "openGiftRankingH5", "Landroid/view/View;", "view", "paramMap", "handleCommonAioTipsClick", "channelType", "handleCommonNickNameClick", "", "receiverTinyId", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "showPanel", "(Ljava/lang/Long;Landroidx/fragment/app/FragmentActivity;)V", "getDefaultGiftDrawableResId", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildMediaChannelApiImpl implements IGuildMediaChannelApi {

    @NotNull
    private static final String TAG = "QGMC.GuildMediaChannelApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/api/impl/GuildMediaChannelApiImpl$b", "Lcom/tencent/mobileqq/guild/gift/module/d;", "", "success", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "pngFilePath", "apngFilePath", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mobileqq.guild.gift.module.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<Function3<Boolean, Integer, String, Unit>> f214387a;

        b(WeakReference<Function3<Boolean, Integer, String, Unit>> weakReference) {
            this.f214387a = weakReference;
        }

        @Override // com.tencent.mobileqq.guild.gift.module.d
        public void a(boolean success, int materialId, @Nullable String pngFilePath, @Nullable String apngFilePath) {
            Function3<Boolean, Integer, String, Unit> function3 = this.f214387a.get();
            if (function3 != null) {
                function3.invoke(Boolean.valueOf(success), Integer.valueOf(materialId), pngFilePath);
            }
        }
    }

    private final void checkNetwork() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.cib);
        }
    }

    private final Context getContext() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        QBaseActivity qBaseActivity2 = null;
        if (qBaseActivity != null) {
            if (qBaseActivity.isDestroyed() || qBaseActivity.isFinishing()) {
                qBaseActivity = null;
            }
            qBaseActivity2 = qBaseActivity;
        }
        if (qBaseActivity2 == null) {
            return BaseApplication.getContext();
        }
        return qBaseActivity2;
    }

    private final String getDefaultRankUrl() {
        return QQGuildMCParser.INSTANCE.f("100915", "giftRankUrl", "https://qun.qq.com/qunng/next/h5/gift-ranks");
    }

    private final String getDefaultTaskUrl() {
        return QQGuildMCParser.INSTANCE.f("100915", "giftTaskUrl", "https://qun.qq.com/qunng/next/h5/free-gift-tasks");
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public int checkHasAlreadyDoRequest() {
        if (com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228101i) {
            return getHAS_OPEN_MIC();
        }
        if (com.tencent.mobileqq.guild.media.core.j.a().N().getSelfHasEnQueue()) {
            return getHAS_IN_MIC_QUEUE();
        }
        if (com.tencent.mobileqq.guild.media.core.j.a().T().getSelfHasRequestRaiseHand()) {
            return getHAS_RAISE_HAND();
        }
        if (com.tencent.mobileqq.guild.media.core.j.c().N()) {
            return getHAS_OPEN_MIC();
        }
        return getNONE();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public boolean curChannelHasInputPermission() {
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        if (!a16.isInChannel()) {
            QLog.i(TAG, 1, "curChannelHasInputPermission, isInChannel[false]");
            return false;
        }
        MediaChannelPermissionHelper S = a16.S();
        boolean H0 = S.H0();
        if (!H0) {
            QLog.i(TAG, 1, "curChannelHasInputPermission, checkVisitorHasTalkRight[" + H0 + "]");
            return false;
        }
        boolean i06 = S.i0();
        if (i06) {
            QLog.i(TAG, 1, "curChannelHasInputPermission, checkSpeakThresholdLimit[" + i06 + "]");
            return false;
        }
        boolean d06 = S.d0();
        if (d06) {
            QLog.i(TAG, 1, "curChannelHasInputPermission, checkSelfMute[" + d06 + "]");
            return false;
        }
        boolean c06 = S.c0();
        if (!c06) {
            return true;
        }
        QLog.i(TAG, 1, "curChannelHasInputPermission, checkSelfBannedInChannel[" + c06 + "]");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    @NotNull
    public String getCLICK_DETAIL_FOR_MORE_FREE_GIFT() {
        return IGuildMediaChannelApi.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    @NotNull
    public String getCLICK_GOTO_PROFILE_PAGE_FREE_GIFT() {
        return IGuildMediaChannelApi.a.b(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    @NotNull
    public String getCLICK_GOTO_PROFILE_PAGE_PAY_GIFT() {
        return IGuildMediaChannelApi.a.c(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    @NotNull
    public String getCLICK_IMMEDIATELY_SEND_FREE_GIFT() {
        return IGuildMediaChannelApi.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public int getDefaultGiftDrawableResId() {
        return R.drawable.guild_media_bottom_free_gift;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void getGiftResFilePathByMaterialId(int materialId, @NotNull Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.guild.media.core.j.a().b0().a(materialId, new b(new WeakReference(callback)));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public int getHAS_IN_MIC_QUEUE() {
        return IGuildMediaChannelApi.a.e(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public int getHAS_OPEN_MIC() {
        return IGuildMediaChannelApi.a.f(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public int getHAS_RAISE_HAND() {
        return IGuildMediaChannelApi.a.g(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public int getNONE() {
        return IGuildMediaChannelApi.a.h(this);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void handleCommonAioTipsClick(@NotNull String tag, @NotNull View view, @NotNull HashMap<String, String> paramMap) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(paramMap, "paramMap");
        if (Intrinsics.areEqual(tag, "click_immediately_send_free_gift")) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null) {
                com.tencent.mobileqq.guild.media.core.j.a().b0().K(qBaseActivity, ShowPanelTab.Pack);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(TAG, "[handleCommonAioTipsClick] showPanel");
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(tag, "click_detail_for_more_free_gift")) {
            com.tencent.mobileqq.guild.media.core.l c16 = com.tencent.mobileqq.guild.media.core.j.c();
            IGuildMediaChannelApi.a.j(this, null, c16.r(), c16.e(), 0, null, 25, null);
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(TAG, "[handleCommonAioTipsClick] openGiftTaskH5");
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(tag, getCLICK_GOTO_PROFILE_PAGE_PAY_GIFT())) {
            String f16 = ch.f();
            Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
            GLiveChannelStartParams s16 = GLiveChannelCore.f226698a.s();
            handleCommonNickNameClick(s16.getGuildId(), s16.getChannelId(), 5, f16);
            return;
        }
        if (Intrinsics.areEqual(tag, "click_detail_open_third_panel")) {
            ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).openMediaThemeChooseDialog("2", TAG);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void handleCommonNickNameClick(@NotNull String guildId, @NotNull String channelId, int channelType, @NotNull String tinyId) {
        int i3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (channelType == 2) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        GuildProfileData guildProfileData = new GuildProfileData(guildId, channelId, tinyId, channelType, i3);
        guildProfileData.getGuildBaseProfileData().r(channelId);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d(TAG, "[handleCommonNickNameClick] guildProfileData " + guildProfileData);
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(qBaseActivity, guildProfileData);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void handleGiftItemTipsClick(@NotNull String tag, @NotNull Object extra) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(extra, "extra");
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void handleGiftNickNameClick(@NotNull String guildId, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public boolean isLowDisplayMode() {
        return GuildMediaUtils.m();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void openGiftRankingH5(@NotNull String guildId, @NotNull String channelId, @NotNull String url, @NotNull String rankType, @NotNull String durationType, @NotNull HashMap<String, String> extraParams) {
        boolean z16;
        HashMap hashMapOf;
        Unit unit;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(rankType, "rankType");
        Intrinsics.checkNotNullParameter(durationType, "durationType");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            url = getDefaultRankUrl();
        }
        String currentUserType = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(guildId);
        if (currentUserType == null) {
            currentUserType = "";
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("guildId", guildId), TuplesKt.to("channelId", channelId), TuplesKt.to(MessageRoamJsPlugin.USERTYPE, currentUserType), TuplesKt.to("rankType", rankType), TuplesKt.to("durationType", durationType), TuplesKt.to("_wv", String.valueOf(16781313L)), TuplesKt.to("_wwv", String.valueOf(8713L)), TuplesKt.to("statusHeight", String.valueOf(ImmersiveUtils.getStatusBarHeight(QBaseActivity.sTopActivity))));
        for (Map.Entry entry : hashMapOf.entrySet()) {
            url = URLUtil.addParameter(url, (String) entry.getKey(), (String) entry.getValue());
            Intrinsics.checkNotNullExpressionValue(url, "addParameter(rankingUrl, it.key, it.value)");
        }
        Logger.f235387a.d().d(TAG, 1, "[openGiftRankingH5] final url " + ((Object) url));
        Intent intent = new Intent();
        intent.putExtra("url", url);
        intent.putExtra("titleBarStyle", 13);
        intent.putExtra("hide_title_left_arrow", true);
        Context context = getContext();
        if (context != null) {
            QRoute.createNavigator(context, RouterConstants.UI_ROUTE_BROWSER).withAll(intent.getExtras()).request();
            checkNetwork();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(TAG, 1, "[openGiftRankingH5] context is null or invalid!");
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void openGiftTaskH5(@NotNull String url, @NotNull String guildId, @NotNull String channelId, int panelHeight, @NotNull HashMap<String, String> extraParams) {
        boolean z16;
        int roundToInt;
        HashMap hashMapOf;
        Unit unit;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            url = getDefaultTaskUrl();
        }
        if (panelHeight == 0 && (panelHeight = com.tencent.mobileqq.guild.media.core.j.a().b0().v()) == 0) {
            panelHeight = ViewUtils.dpToPx(456.0f);
        }
        String currentUserType = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(guildId);
        if (currentUserType == null) {
            currentUserType = "";
        }
        roundToInt = MathKt__MathJVMKt.roundToInt((panelHeight * 1.0f) / ViewUtils.getDensity());
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("guildId", guildId), TuplesKt.to("channelId", channelId), TuplesKt.to(MessageRoamJsPlugin.USERTYPE, currentUserType), TuplesKt.to("panelHeight", String.valueOf(roundToInt)), TuplesKt.to("_wv", String.valueOf(4097L)), TuplesKt.to("_wwv", String.valueOf(8969L)));
        for (Map.Entry entry : hashMapOf.entrySet()) {
            url = URLUtil.addParameter(url, (String) entry.getKey(), (String) entry.getValue());
            Intrinsics.checkNotNullExpressionValue(url, "addParameter(taskUrl, it.key, it.value)");
        }
        Logger.f235387a.d().d(TAG, 1, "[openGiftTaskH5] final url " + ((Object) url));
        Intent intent = new Intent();
        intent.putExtra("url", url);
        intent.putExtra("titleBarStyle", 13);
        intent.putExtra("hide_title_left_arrow", true);
        Context context = getContext();
        if (context != null) {
            QRoute.createNavigator(context, RouterConstants.UI_ROUTE_TRANSLUCENT_BROWSER).withAll(intent.getExtras()).request();
            checkNetwork();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(TAG, 1, "[openGiftTaskH5] context is null or invalid!");
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void openMediaThemeChooseDialog(@Nullable String openIndex, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (QBaseActivity.sTopActivity != null) {
            GuildMediaThemeChooseDialog.Companion companion = GuildMediaThemeChooseDialog.INSTANCE;
            FragmentManager supportFragmentManager = QBaseActivity.sTopActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "sTopActivity.supportFragmentManager");
            companion.e(openIndex, supportFragmentManager, tag);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void openMicByClickInviteMsg(@NotNull Function3<? super Integer, ? super String, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (checkHasAlreadyDoRequest() != getNONE()) {
            callback.invoke(0, "HasAlreadyDoRequest", Boolean.FALSE);
        } else {
            MediaChannelCore.INSTANCE.a().f().f(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMediaChannelApi
    public void showPanel(@Nullable Long receiverTinyId, @NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.tencent.mobileqq.guild.media.core.j.a().b0().J(receiverTinyId, activity, ShowPanelTab.Pack);
    }
}
