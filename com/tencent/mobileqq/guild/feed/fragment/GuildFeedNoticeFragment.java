package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart;
import com.tencent.mobileqq.guild.feed.part.al;
import com.tencent.mobileqq.guild.feed.part.ap;
import com.tencent.mobileqq.guild.feed.part.notice.GuildFeedNoticeCommentPart;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedNoticeFragment extends QQGuildTitleBarFragment implements com.tencent.mobileqq.pad.d {
    private ap T;
    private String U = "";
    private final GPServiceObserver V = new a();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(String str) {
            super.onDeleteGuild(str);
            if (GuildFeedNoticeFragment.this.U.equals(str)) {
                GuildFeedNoticeFragment.this.onBackEvent();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            super.onDestoryGuild(str);
            if (GuildFeedNoticeFragment.this.U.equals(str)) {
                GuildFeedNoticeFragment.this.onBackEvent();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            super.onRemoveGuild(str);
            if (GuildFeedNoticeFragment.this.U.equals(str)) {
                GuildFeedNoticeFragment.this.onBackEvent();
            }
        }
    }

    private GuildFeedBaseInitBean Eh() {
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        if (getActivity() != null) {
            Bundle g16 = GuildSplitViewUtils.f235370a.g(this);
            if (TextUtils.isEmpty(this.U)) {
                this.U = g16.getString("extra_guild_id", "");
            }
            if (this.U == null) {
                this.U = "";
            }
            String string = g16.getString("extra_channel_id", "");
            guildFeedBaseInitBean.setGuildId(this.U);
            guildFeedBaseInitBean.setChannelId(string);
        }
        guildFeedBaseInitBean.getAttrs().put("service_type", 0);
        guildFeedBaseInitBean.setBusinessType(19);
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam();
        joinInfoParam.setMainAndSubSource(UinConfigManager.KEY_ADS, "notice_pgrp");
        guildFeedBaseInitBean.setJoinInfoParam(joinInfoParam);
        return guildFeedBaseInitBean;
    }

    @NonNull
    private static Intent Fh(String str, String str2, String str3, int i3, int i16) {
        Intent intent = new Intent();
        intent.putExtra("extra_guild_id", str);
        intent.putExtra("extra_channel_id", str2);
        intent.putExtra("detailId", str3);
        intent.putExtra("extra_key_jump_type", i3);
        intent.putExtra(IFileBrowserService.FILE_BROWSER_PAGE_FROM, i16);
        return intent;
    }

    public static void Gh(String str, String str2, String str3, int i3, int i16) {
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.getContext();
        }
        Intent Fh = Fh(str, str2, str3, i3, i16);
        if (!(context instanceof Activity)) {
            Fh.addFlags(268435456);
        }
        Fh.putExtra("_extra_param_report_task", com.tencent.mobileqq.guild.util.report.b.a("guild_notice"));
        GuildSplitViewUtils.f235370a.o(context, Fh, GuildFeedNoticeFragment.class, LaunchMode.standard);
    }

    public static void Hh(String str, int i3, int i16) {
        Gh(null, null, str, i3, i16);
    }

    private void Ih() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.U)) {
            hashMap.put("sgrp_channel_id", this.U);
            IGProGuildInfo guildInfo = ((IGPSService) ch.S0(IGPSService.class, "")).getGuildInfo(this.U);
            if (guildInfo != null) {
                hashMap.put("sgrp_user_type", Integer.valueOf(v.d(guildInfo.isMember(), guildInfo.getUserType())));
            }
        }
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        GuildChannelReportManager.f231987a.b(getActivity(), getFragmentContentView(), GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, "pg_sgrp_new_notification", hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        this.T = new ap(R.id.f165538wj3, 0, com.tencent.mobileqq.guild.util.report.b.b(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new InputSendPart());
        arrayList.add(new GuildFeedNoticeCommentPart());
        arrayList.add(new xm1.e());
        arrayList.add(this.T);
        arrayList.add(new al());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eut;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedNoticeFragment";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null && getActivity().getWindow() != null) {
            getActivity().getWindow().setSoftInputMode(48);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (1001 == i16) {
            onBackEvent();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.f235370a.t(getActivity(), false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        f12.f.f397616a.g("feed_inbox_message", true);
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        f12.f.f397616a.g("feed_inbox_message", false);
        GuildChannelReportManager.f231987a.g(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST);
        super.onDestroy();
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.V);
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
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.V);
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        guildSplitViewUtils.B(this.N);
        guildSplitViewUtils.A(getActivity(), this.N, R.drawable.qui_common_bg_bottom_light_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        setTitle(getString(R.string.f141820hp));
        rh();
        com.tencent.mobileqq.guild.feed.performance.report.g.a("feed_notice_on_create_view");
        this.T.ja(Eh());
        Ih();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_bottom_light);
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return false;
    }
}
