package com.tencent.mobileqq.guild.feed.share;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.libra.LibraPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.util.Map;

/* loaded from: classes13.dex */
public class GuildFeedPicViewerShareQQGuildOperation extends com.tencent.mobileqq.guild.feed.share.a {

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f223330d;

    /* renamed from: e, reason: collision with root package name */
    private View f223331e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f223334e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z16, String str) {
            super(z16);
            this.f223334e = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if (loadState == LoadState.STATE_SUCCESS) {
                String c16 = com.tencent.mobileqq.guild.picload.e.a().c(option);
                QLog.i("GuildFeedPicViewerShareQQGuildOperation", 1, "shareToQQOrChannelByPic  | url = " + this.f223334e + " | localPath = " + c16);
                GuildFeedPicViewerShareQQGuildOperation.this.i(option, c16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final Option option, final String str) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.share.GuildFeedPicViewerShareQQGuildOperation.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    QLog.e("GuildFeedPicViewerShareQQGuildOperation", 1, "picFileShare  localPath == null");
                    return;
                }
                String str2 = str;
                if (str2.endsWith(LibraPicLoader.PIC_LOCAL_PATH_END_SUFFIX)) {
                    str2 = str.replace(LibraPicLoader.PIC_LOCAL_PATH_END_SUFFIX, ".jpg");
                }
                QLog.i("GuildFeedPicViewerShareQQGuildOperation", 1, "picFileShare  copyFile  result = " + FileUtils.copyFile(str, str2));
                File file = new File(str2);
                Bundle bundle = new Bundle();
                bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, false);
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, str2);
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str2);
                AIOPictureData aIOPictureData = new AIOPictureData();
                aIOPictureData.friendUin = GuildFeedPicViewerShareQQGuildOperation.this.c().uin;
                aIOPictureData.largeImageFile = str2;
                aIOPictureData.originImageFile = str2;
                aIOPictureData.picServerUrl = option.getUrl();
                aIOPictureData.thumbImageFile = str2;
                if (GuildFeedPicViewerShareQQGuildOperation.this.c().action == 171) {
                    ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToChannel(file, false, aIOPictureData, bundle, GuildFeedPicViewerShareQQGuildOperation.this.a(), GuildFeedPicViewerShareQQGuildOperation.this.c().action, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
                } else {
                    ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardPicToFriend(file, false, aIOPictureData, bundle, GuildFeedPicViewerShareQQGuildOperation.this.a(), GuildFeedPicViewerShareQQGuildOperation.this.c().action, GuildFeedPicViewerShareQQGuildOperation.this.c().uin, GuildFeedPicViewerShareQQGuildOperation.this.c().uinType, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j(int i3, c cVar) {
        String str;
        GProStFeed c16;
        boolean z16;
        String e16;
        String a16;
        String h16;
        boolean z17;
        String str2;
        String str3;
        if (this.f223330d == null || this.f223331e == null) {
            this.f223330d = new FrameLayout(a());
            View view = new View(a());
            this.f223331e = view;
            this.f223330d.addView(view);
        }
        if (cVar == null) {
            return;
        }
        GuildFeedBaseInitBean q16 = ax.q(a());
        String str4 = "pg_sgrp_forum_viewer";
        String str5 = "";
        if (q16 != null) {
            String str6 = q16.getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_page_id");
            if ("pg_sgrp_forum_viewer_feeds".equals(str6)) {
                str = "";
                str4 = str6;
                c16 = cVar.c();
                if (c16 == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    e16 = String.valueOf(c16.channelInfo.sign.guildId);
                } else {
                    e16 = cVar.e();
                }
                if (!z16) {
                    a16 = String.valueOf(c16.channelInfo.sign.channelId);
                } else {
                    a16 = cVar.a();
                }
                if (!z16) {
                    h16 = c16.poster.idd;
                } else {
                    h16 = cVar.h();
                }
                String str7 = h16;
                int d16 = cVar.d();
                if (cVar.f().getType() != 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                Map<String, Object> c17 = com.tencent.mobileqq.guild.feed.report.f.c(e16, a16, str7, d16, str, z17);
                if (i3 != 171) {
                    str2 = "em_sgrp_forum_viewer_channel";
                    str3 = "ev_sgrp_forum_viewer_channel";
                } else {
                    str2 = "em_sgrp_forum_viewer_friend";
                    str3 = "ev_sgrp_forum_viewer_friend";
                }
                VideoReport.setPageId(this.f223330d, str4);
                VideoReport.setPageParams(this.f223330d, new PageParams((Map<String, ?>) c17));
                VideoReport.setElementId(this.f223331e, str2);
                VideoReport.reportEvent(str3, this.f223331e, c17);
            }
            if (q16.getBusinessType() == 7) {
                str5 = q16.getTroopUin();
                str4 = "pg_group_sgrp_forum_viewer";
            }
        }
        str = str5;
        c16 = cVar.c();
        if (c16 == null) {
        }
        if (!z16) {
        }
        if (!z16) {
        }
        if (!z16) {
        }
        String str72 = h16;
        int d162 = cVar.d();
        if (cVar.f().getType() != 1) {
        }
        Map<String, Object> c172 = com.tencent.mobileqq.guild.feed.report.f.c(e16, a16, str72, d162, str, z17);
        if (i3 != 171) {
        }
        VideoReport.setPageId(this.f223330d, str4);
        VideoReport.setPageParams(this.f223330d, new PageParams((Map<String, ?>) c172));
        VideoReport.setElementId(this.f223331e, str2);
        VideoReport.reportEvent(str3, this.f223331e, c172);
    }

    private void k() {
        String d16 = bm.d(b().f());
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(d16), new a(true, d16));
    }

    public void h() {
        if (b() != null && b().f() != null && a() != null && c() != null) {
            if (b().f().getType() == 1) {
                QLog.e("GuildFeedPicViewerShareQQGuildOperation", 1, "shareToQQ  video not share");
                return;
            } else {
                j(c().action, b());
                k();
                return;
            }
        }
        QLog.e("GuildFeedPicViewerShareQQGuildOperation", 1, "operate  params error");
    }
}
