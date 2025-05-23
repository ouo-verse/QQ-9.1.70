package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryFloatLayerPart;
import com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryPreloadPart;
import com.tencent.mobileqq.guild.feed.part.GuildFeedRichMediaDownLoadPart;
import com.tencent.mobileqq.guild.feed.part.av;
import com.tencent.mobileqq.guild.feed.part.l;
import com.tencent.mobileqq.guild.feed.part.m;
import com.tencent.mobileqq.guild.feed.part.o;
import com.tencent.mobileqq.guild.feed.part.u;
import com.tencent.mobileqq.guild.feed.part.x;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class GuildFeedGalleryPageFragment extends GuildQBasePartFragment {
    private GuildFeedGalleryInitBean C;
    private o D;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initIntentData() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            return;
        }
        if (intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (serializableExtra instanceof GuildFeedGalleryInitBean) {
                guildFeedGalleryInitBean = (GuildFeedGalleryInitBean) serializableExtra;
                if (guildFeedGalleryInitBean != null) {
                    QLog.e("GuildFeedGalleryPageFragment", 1, "initIntentData galleryInitBean == nul");
                    return;
                }
                GProStFeed feed = guildFeedGalleryInitBean.getFeed();
                if (feed != null && feed.channelInfo.sign.guildId <= 0 && !TextUtils.isEmpty(guildFeedGalleryInitBean.getGuildId())) {
                    try {
                        QLog.i("GuildFeedGalleryPageFragment", 1, "initIntentData setGuildId=" + guildFeedGalleryInitBean.getGuildId());
                        feed.channelInfo.sign.guildId = Long.parseLong(guildFeedGalleryInitBean.getGuildId());
                    } catch (Exception unused) {
                        QLog.e("GuildFeedGalleryPageFragment", 1, "initIntentData parseGuildId failed");
                    }
                }
                if (feed != null && feed.channelInfo.sign.channelId <= 0 && !TextUtils.isEmpty(guildFeedGalleryInitBean.getChannelId())) {
                    try {
                        QLog.i("GuildFeedGalleryPageFragment", 1, "initIntentData setChannelId=" + guildFeedGalleryInitBean.getChannelId());
                        feed.channelInfo.sign.channelId = Long.parseLong(guildFeedGalleryInitBean.getChannelId());
                    } catch (Exception unused2) {
                        QLog.e("GuildFeedGalleryPageFragment", 1, "initIntentData parseChannel failed");
                    }
                }
                if (feed != null && feed.idd.isEmpty() && !TextUtils.isEmpty(guildFeedGalleryInitBean.getFeedId())) {
                    QLog.i("GuildFeedGalleryPageFragment", 1, "initIntentData setFeedId=" + guildFeedGalleryInitBean.getFeedId());
                    feed.idd = guildFeedGalleryInitBean.getFeedId();
                }
                this.C = guildFeedGalleryInitBean;
                return;
            }
        }
        guildFeedGalleryInitBean = null;
        if (guildFeedGalleryInitBean != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pageDtReport(View view) {
        boolean z16;
        String posterId;
        String str;
        String str2;
        List<GuildFeedRichMediaData> richMediaDataList;
        Intent intent = getActivity().getIntent();
        if (intent != null && view != null) {
            if (intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
                Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
                if (!(serializableExtra instanceof GuildFeedGalleryInitBean)) {
                    return;
                } else {
                    this.C = (GuildFeedGalleryInitBean) serializableExtra;
                }
            }
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.C;
            if (guildFeedGalleryInitBean == null) {
                QLog.e("GuildFeedGalleryPageFragment", 1, "pageDtReport mGalleryInitBean == nul");
                return;
            }
            GProStFeed feed = guildFeedGalleryInitBean.getFeed();
            boolean z17 = false;
            if (feed != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            String rh5 = rh(this.C);
            String ph5 = ph(this.C);
            if (z16) {
                posterId = this.C.getFeed().poster.idd;
            } else {
                posterId = this.C.getPosterId();
            }
            String str3 = posterId;
            int fromPage = this.C.getFromPage();
            String str4 = this.C.getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_page_id");
            if (!"pg_sgrp_forum_viewer_feeds".equals(str4)) {
                if (this.C.getBusinessType() == 7) {
                    str2 = this.C.getTroopUin();
                    str = "pg_group_sgrp_forum_viewer";
                    int enterPos = this.C.getEnterPos();
                    richMediaDataList = this.C.getRichMediaDataList();
                    if (richMediaDataList != null && richMediaDataList.size() > enterPos && richMediaDataList.get(enterPos).getType() == 1) {
                        z17 = true;
                    }
                    Map<String, ?> c16 = com.tencent.mobileqq.guild.feed.report.f.c(rh5, ph5, str3, fromPage, str2, z17);
                    if (feed == null && !feed.idd.isEmpty()) {
                        c16.put("sgrp_content_id", feed.idd);
                        c16.put("sgrp_feed_id", feed.idd);
                    } else if (!TextUtils.isEmpty(this.C.getFeedId())) {
                        c16.put("sgrp_content_id", this.C.getFeedId());
                        c16.put("sgrp_feed_id", this.C.getFeedId());
                    }
                    QLog.i("GuildFeedGalleryPageFragment", 1, "pageDtReport guildId=" + rh5 + " channelId=" + ph5);
                    c16.putAll(this.C.getJumpExtraInfo().getReportInfoMap());
                    c16.putAll(com.tencent.mobileqq.guild.report.b.d());
                    c16.put("sgrp_entry_type", Integer.valueOf(this.C.getOpenType()));
                    if (!this.C.isVideoFeed()) {
                        c16.put("sgrp_type", 2);
                    } else {
                        c16.put("sgrp_type", 1);
                    }
                    GuildChannelReportManager.f231987a.b(getQBaseActivity(), ((GuildQBasePartFragment) this).mContentView, GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_MEDIA_VIEWER, str, c16);
                }
                str4 = "pg_sgrp_forum_viewer";
            }
            str = str4;
            str2 = "";
            int enterPos2 = this.C.getEnterPos();
            richMediaDataList = this.C.getRichMediaDataList();
            if (richMediaDataList != null) {
                z17 = true;
            }
            Map<String, ?> c162 = com.tencent.mobileqq.guild.feed.report.f.c(rh5, ph5, str3, fromPage, str2, z17);
            if (feed == null) {
            }
            if (!TextUtils.isEmpty(this.C.getFeedId())) {
            }
            QLog.i("GuildFeedGalleryPageFragment", 1, "pageDtReport guildId=" + rh5 + " channelId=" + ph5);
            c162.putAll(this.C.getJumpExtraInfo().getReportInfoMap());
            c162.putAll(com.tencent.mobileqq.guild.report.b.d());
            c162.put("sgrp_entry_type", Integer.valueOf(this.C.getOpenType()));
            if (!this.C.isVideoFeed()) {
            }
            GuildChannelReportManager.f231987a.b(getQBaseActivity(), ((GuildQBasePartFragment) this).mContentView, GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_MEDIA_VIEWER, str, c162);
        }
    }

    private String ph(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        GProStFeed feed = guildFeedGalleryInitBean.getFeed();
        if (feed != null) {
            long j3 = feed.channelInfo.sign.channelId;
            if (j3 > 0) {
                return String.valueOf(j3);
            }
        }
        if (!TextUtils.isEmpty(guildFeedGalleryInitBean.getChannelId())) {
            return guildFeedGalleryInitBean.getChannelId();
        }
        QLog.e("GuildFeedGalleryPageFragment", 1, "getChannelId initBean invalid");
        return "0";
    }

    private com.tencent.mobileqq.guild.feed.part.f qh() {
        if (this.C.getBusinessType() == 7 && !TextUtils.isEmpty(this.C.getTroopUin())) {
            return new av(this.C.getTroopUin());
        }
        return new x();
    }

    private String rh(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        GProStFeed feed = guildFeedGalleryInitBean.getFeed();
        if (feed != null) {
            long j3 = feed.channelInfo.sign.guildId;
            if (j3 > 0) {
                return String.valueOf(j3);
            }
        }
        if (!TextUtils.isEmpty(guildFeedGalleryInitBean.getGuildId())) {
            return guildFeedGalleryInitBean.getGuildId();
        }
        QLog.e("GuildFeedGalleryPageFragment", 1, "getGuildId initBean invalid");
        return "0";
    }

    private o sh() {
        if (this.D == null) {
            this.D = new o();
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        initIntentData();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GuildFeedGalleryPreloadPart());
        arrayList.add(new GuildFeedGalleryFloatLayerPart());
        arrayList.add(new u());
        arrayList.add(sh());
        arrayList.add(new l());
        arrayList.add(new m());
        arrayList.add(qh());
        arrayList.add(new GuildFeedRichMediaDownLoadPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eoa;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedGalleryPageFragment";
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildQBasePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildQBasePartFragment
    protected boolean needSupportFullScreen() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuildChannelReportManager.f231987a.g(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_MEDIA_VIEWER);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        enableFlingRight(false);
        pageDtReport(((GuildQBasePartFragment) this).mContentView);
        GuildChannelReportManager.f231987a.e(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_MEDIA_VIEWER, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_MEDIA_VIEWER, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
    }
}
