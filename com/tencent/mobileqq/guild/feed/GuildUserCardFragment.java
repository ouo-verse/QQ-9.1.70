package com.tencent.mobileqq.guild.feed;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.event.GuildOpenUserProfileEvent;
import com.tencent.mobileqq.guild.event.GuildUserCardDismissEvent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildUserCardFragment extends PublicBaseFragment implements SimpleEventReceiver {
    public static String H = "guild_key_user_card";
    private View C;
    private String D;
    private String E;
    private String F;
    private FeedImpeachData G;

    private void initData() {
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra(H);
        this.D = bundleExtra.getString("key_guild_id");
        this.E = bundleExtra.getString("key_channel_id");
        this.F = bundleExtra.getString("key_tiny_id");
        this.G = (FeedImpeachData) bundleExtra.getSerializable("impeachData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (getActivity() != null) {
            QLog.i("GuildUserCardFragment", 1, "finish by click");
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit rh(Boolean bool) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildOpenUserProfileEvent(bool), true);
        return null;
    }

    private void th() {
        GuildProfileData guildProfileData = new GuildProfileData(this.D, "", this.F, 0, 8);
        guildProfileData.getGuildBaseProfileData().r(this.E);
        guildProfileData.setFeedImpeachData(this.G);
        guildProfileData.getExtras().putBoolean(GuildProfileData.KEY_IS_FROM_STANDALONE, true);
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).openProfileOnClick(getActivity(), guildProfileData, new Function1() { // from class: com.tencent.mobileqq.guild.feed.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit rh5;
                rh5 = GuildUserCardFragment.rh((Boolean) obj);
                return rh5;
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildUserCardDismissEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (QQTheme.isNowThemeIsNight()) {
            sh(activity, Color.parseColor("#1d1d20"));
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        } else {
            sh(activity, -1);
            ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        this.C = frameLayout;
        th();
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildUserCardFragment.this.lambda$onCreateView$0(view);
            }
        });
        return frameLayout;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildUserCardDismissEvent) {
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.GuildUserCardFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GuildUserCardFragment.this.getActivity() != null) {
                        GuildUserCardFragment.this.getActivity().finish();
                        QLog.i("GuildUserCardFragment", 1, "finish by receiveEvent");
                    }
                }
            }, 300L);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.i("GuildUserCardFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public static void sh(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        window.setNavigationBarColor(i3);
    }
}
