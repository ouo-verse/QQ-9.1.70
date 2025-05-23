package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/GuildTroopApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IGuildTroopApi;", "", "troopUin", "Landroid/os/Bundle;", "getFeedFragmentArgs", "Landroid/content/Context;", "context", "Lkotlin/Pair;", "", "getScreenSize", "", "", "fetchGuildTroopTitleData", "", "isGuildTroop", "Landroidx/fragment/app/Fragment;", "getFeedFragment", "Landroid/view/View;", "getLoadingView", "view", "", "startLoadingAnim", "stopLoadingAnim", "url", "width", "height", "Landroid/graphics/drawable/Drawable;", "getAvatarDrawable", "isNeedHideTroopGuildEntrance", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GuildTroopApiImpl implements IGuildTroopApi {
    private static final String TROOP_GUILD_ENTRANCE_HIDE_CONFIG_ID = "101026";
    private static final String TROOP_GUILD_ENTRANCE_HIDE_JSON_KEY = "hide_troop_guild_entrance";

    private final Bundle getFeedFragmentArgs(String troopUin) {
        String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(troopUin);
        IGProChannelInfo troopFeedChannelInfo = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelInfo(troopGuildId);
        if (troopFeedChannelInfo == null || troopFeedChannelInfo.getChannelUin() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IGuildFeedConfigAPi.PARAM_GUILD_ID, troopGuildId);
        bundle.putString(IGuildFeedConfigAPi.PARAM_CHANNEL_ID, troopFeedChannelInfo.getChannelUin());
        bundle.putString(IGuildFeedConfigAPi.PARAM_CHANNEL_NAME, troopFeedChannelInfo.getChannelName());
        bundle.putString(IGuildFeedConfigAPi.PARAM_TROOP_UIN, troopUin);
        return bundle;
    }

    private final Pair<Integer, Integer> getScreenSize(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public Map<String, Object> fetchGuildTroopTitleData() {
        Map<String, Object> titleData = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getTitleData();
        Intrinsics.checkNotNullExpressionValue(titleData, "api(IGuildTempApi::class.java).titleData");
        return titleData;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public Drawable getAvatarDrawable(String url, int width, int height) {
        Intrinsics.checkNotNullParameter(url, "url");
        return ((IQQGuildAvatarApi) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(url, width, height, null, true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public Fragment getFeedFragment(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Bundle feedFragmentArgs = getFeedFragmentArgs(troopUin);
        if (feedFragmentArgs == null) {
            return null;
        }
        Object troopFeedFragment = ((IGuildFeedConfigAPi) QRoute.api(IGuildFeedConfigAPi.class)).getTroopFeedFragment(feedFragmentArgs);
        Intrinsics.checkNotNull(troopFeedFragment, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) troopFeedFragment;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public View getLoadingView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getLoadingView(context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public boolean isGuildTroop(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return (peekAppRuntime == null || !((ITroopGuildInfoService) peekAppRuntime.getRuntimeService(ITroopGuildInfoService.class, "")).getCurrentAioTroopGuildSwitch(troopUin) || isNeedHideTroopGuildEntrance()) ? false : true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public boolean isNeedHideTroopGuildEntrance() {
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(TROOP_GUILD_ENTRANCE_HIDE_CONFIG_ID, new byte[0]);
        boolean z16 = true;
        if (!(loadRawConfig.length == 0)) {
            String str = new String(loadRawConfig, Charsets.UTF_8);
            try {
                if (str.length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    return new JSONObject(str).optBoolean(TROOP_GUILD_ENTRANCE_HIDE_JSON_KEY, false);
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public void startLoadingAnim(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View loadingAnimView = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getLoadingAnimView(view);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Pair<Integer, Integer> screenSize = getScreenSize(context);
        float intValue = screenSize.getFirst().intValue();
        float intValue2 = screenSize.getSecond().intValue();
        TranslateAnimation translateAnimation = new TranslateAnimation(intValue * (-0.6f), intValue * 0.6f, (-0.6f) * intValue2, intValue2 * 0.6f);
        translateAnimation.setDuration(2400L);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        if (loadingAnimView != null) {
            loadingAnimView.setVisibility(0);
        }
        if (loadingAnimView != null) {
            loadingAnimView.startAnimation(translateAnimation);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGuildTroopApi
    public void stopLoadingAnim(View view) {
        Animation animation;
        Intrinsics.checkNotNullParameter(view, "view");
        View loadingAnimView = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getLoadingAnimView(view);
        if (loadingAnimView != null && (animation = loadingAnimView.getAnimation()) != null) {
            animation.cancel();
        }
        if (loadingAnimView == null) {
            return;
        }
        loadingAnimView.setVisibility(8);
    }
}
