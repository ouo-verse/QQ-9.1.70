package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.part.al;
import com.tencent.mobileqq.guild.feed.part.ap;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/fragment/GuildTroopFeedNoticeFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "troopUin", "", "Fh", "guildId", "channelId", "Eh", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onResume", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "Lcom/tencent/mobileqq/guild/feed/part/ap;", "T", "Lcom/tencent/mobileqq/guild/feed/part/ap;", "blockPart", "U", "Ljava/lang/Integer;", GetAdInfoRequest.SOURCE_FROM, "<init>", "()V", "V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildTroopFeedNoticeFragment extends QQGuildTitleBarFragment {

    /* renamed from: T, reason: from kotlin metadata */
    private ap blockPart;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Integer sourceFrom = 0;

    private final void Eh(String guildId, String channelId, String troopUin) {
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", troopUin);
        hashMap.put("group_uin_type", Integer.valueOf(((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildRole(troopUin)));
        hashMap.put("sgrp_channel_id", guildId);
        hashMap.put("sgrp_sub_channel_id", channelId);
        GuildChannelReportManager guildChannelReportManager = GuildChannelReportManager.f231987a;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
        View fragmentContentView = getFragmentContentView();
        Intrinsics.checkNotNullExpressionValue(fragmentContentView, "fragmentContentView");
        GuildChannelReportManager.d(guildChannelReportManager, activity, fragmentContentView, GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, "pg_group_sgrp_forum_msg_list", hashMap, null, 32, null);
    }

    private final void Fh(final String troopUin) {
        boolean z16;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual("0", troopUin)) {
            final AppRuntime m3 = ax.m(getContext());
            if (m3 == null) {
                return;
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.fragment.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildTroopFeedNoticeFragment.Gh(AppRuntime.this, troopUin);
                }
            });
            return;
        }
        QLog.e("GuildTroopFeedNoticeFragment", 1, "markRead troopUin = " + troopUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(AppRuntime appRuntime, String str) {
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        ((ITroopGuildUnreadCntService) appRuntime.getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(str, GuildGroupSceneType.KFEEDNUMERIC, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ap apVar = null;
        this.blockPart = new ap(R.id.f165538wj3, 1, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new xm1.e());
        ap apVar2 = this.blockPart;
        if (apVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockPart");
        } else {
            apVar = apVar2;
        }
        arrayList.add(apVar);
        arrayList.add(new al());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eut;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getInt("key_source_from", 0) == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuildChannelReportManager.f231987a.g(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GuildChannelReportManager.f231987a.e(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        Integer num;
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        Bundle arguments = getArguments();
        ap apVar = null;
        if (arguments != null) {
            str = arguments.getString("key_guild_id");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("key_channel_id");
        } else {
            str2 = null;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str3 = arguments3.getString("key_troop_id");
        } else {
            str3 = null;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            num = Integer.valueOf(arguments4.getInt("key_source_from"));
        } else {
            num = null;
        }
        this.sourceFrom = num;
        QLog.d("GuildTroopFeedNoticeFragment", 1, "onViewCreatedBeforePartInit guildId = " + str + ", channelId = " + str2 + ", troopUin = " + str3);
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setGuildId(str);
        guildFeedBaseInitBean.setChannelId(str2);
        guildFeedBaseInitBean.setTroopUin(str3);
        HashMap<String, Serializable> attrs = guildFeedBaseInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs, "bean.attrs");
        attrs.put("service_type", 1);
        guildFeedBaseInitBean.setBusinessType(7);
        ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
        String troopUin = guildFeedBaseInitBean.getTroopUin();
        Intrinsics.checkNotNullExpressionValue(troopUin, "bean.troopUin");
        guildFeedBaseInitBean.setTroopRole(iTroopGuildApi.getTroopGuildRole(troopUin));
        if (!AppSetting.t(getActivity())) {
            ax.K(getActivity(), guildFeedBaseInitBean);
        }
        ap apVar2 = this.blockPart;
        if (apVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockPart");
        } else {
            apVar = apVar2;
        }
        apVar.ja(guildFeedBaseInitBean);
        String str4 = "";
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 != null) {
            str4 = str3;
        }
        Eh(str, str2, str4);
        Fh(str3);
        setTitle(getString(R.string.f1514317o));
        GuildSplitViewUtils.f235370a.B(this.N);
    }
}
