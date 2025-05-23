package com.tencent.mobileqq.guild.feed.share;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager;
import com.tencent.mobileqq.guild.feed.util.aj;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b extends com.tencent.mobileqq.guild.feed.share.a {

    /* renamed from: d, reason: collision with root package name */
    private GuildFeedRichMediaDownLoadManager.c f223356d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f223357e;

    /* renamed from: f, reason: collision with root package name */
    private View f223358f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            b.this.k();
        }
    }

    private void h() {
        aj.a(a(), 2, new a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CHANNEL_FEED, QQPermissionConstants.Business.SCENE.CHANNEL_FEED_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(c cVar) {
        String str;
        GProStFeed c16;
        boolean z16;
        String e16;
        String a16;
        String h16;
        boolean z17;
        if (this.f223357e == null || this.f223358f == null) {
            this.f223357e = new FrameLayout(a());
            View view = new View(a());
            this.f223358f = view;
            this.f223357e.addView(view);
        }
        if (cVar == null) {
            return;
        }
        GuildFeedBaseInitBean q16 = ax.q(a());
        String str2 = "pg_sgrp_forum_viewer";
        String str3 = "";
        if (q16 != null) {
            String str4 = q16.getFeedReportSourceInfo().getReportInfoMap().get("extra_feeds_page_id");
            if ("pg_sgrp_forum_viewer_feeds".equals(str4)) {
                str = "";
                str2 = str4;
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
                String str5 = h16;
                int d16 = cVar.d();
                if (cVar.f().getType() != 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                Map<String, Object> c17 = com.tencent.mobileqq.guild.feed.report.f.c(e16, a16, str5, d16, str, z17);
                VideoReport.setPageId(this.f223357e, str2);
                VideoReport.setPageParams(this.f223357e, new PageParams((Map<String, ?>) c17));
                VideoReport.setElementId(this.f223358f, "em_sgrp_forum_viewer_save");
                VideoReport.reportEvent("ev_sgrp_forum_viewer_save", this.f223358f, c17);
            }
            if (q16.getBusinessType() == 7) {
                str3 = q16.getTroopUin();
                str2 = "pg_group_sgrp_forum_viewer";
            }
        }
        str = str3;
        c16 = cVar.c();
        if (c16 == null) {
        }
        if (!z16) {
        }
        if (!z16) {
        }
        if (!z16) {
        }
        String str52 = h16;
        int d162 = cVar.d();
        if (cVar.f().getType() != 1) {
        }
        Map<String, Object> c172 = com.tencent.mobileqq.guild.feed.report.f.c(e16, a16, str52, d162, str, z17);
        VideoReport.setPageId(this.f223357e, str2);
        VideoReport.setPageParams(this.f223357e, new PageParams((Map<String, ?>) c172));
        VideoReport.setElementId(this.f223358f, "em_sgrp_forum_viewer_save");
        VideoReport.reportEvent("ev_sgrp_forum_viewer_save", this.f223358f, c172);
    }

    private void j() {
        if (b() != null && b().c() != null) {
            GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(b().c(), "").K("download").J("success").Y("pg_channel_forum_page")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        GuildFeedRichMediaDownLoadManager.c cVar = this.f223356d;
        if (cVar != null) {
            cVar.a();
        }
        GuildFeedRichMediaDownLoadManager.DownLoadParams n3 = n();
        n3.h(this.f223356d);
        GuildFeedRichMediaDownLoadManager.l().k(n3);
    }

    private String l() {
        if (b().f().getVideo() == null || TextUtils.isEmpty(b().f().getVideo().playUrl)) {
            return "";
        }
        String str = b().f().getVideo().playUrl;
        QLog.d("GuildFeedGallerySaveOperation", 1, "get origin video downLoad url success");
        return str;
    }

    private String m() {
        GProStImage image;
        if (b().f().getImage() == null || (image = b().f().getImage()) == null) {
            return "";
        }
        if (image.vecImageUrlList.size() > 0) {
            String d16 = bm.d(b().f());
            QLog.d("GuildFeedGallerySaveOperation", 1, "get pic downLoad url success | url: " + d16);
            return d16;
        }
        if (TextUtils.isEmpty(image.getPicUrl())) {
            return "";
        }
        String picUrl = image.getPicUrl();
        QLog.d("GuildFeedGallerySaveOperation", 1, "get pic downLoad url success | getPicUrl: " + picUrl);
        return picUrl;
    }

    private GuildFeedRichMediaDownLoadManager.DownLoadParams n() {
        GuildFeedRichMediaDownLoadManager.DownLoadParams downLoadParams = new GuildFeedRichMediaDownLoadManager.DownLoadParams();
        int type = b().f().getType();
        int i3 = 1;
        if (type != 0) {
            if (type == 1) {
                downLoadParams.i(l(), 0, b().f().getVideo().fileId);
            }
        } else {
            String m3 = m();
            if (b().f().getImage().isGif) {
                i3 = 2;
            }
            downLoadParams.i(m3, i3, b().f().getImage().picId);
        }
        return downLoadParams;
    }

    public void o() {
        if (b() != null && b().f() != null && a() != null) {
            if (!HostNetworkUtils.isNetworkAvailable()) {
                QQToast.makeText(a(), HardCodeUtil.qqStr(R.string.f1510816q), 0).show();
                QLog.d("GuildFeedGallerySaveOperation", 4, "network not available");
                return;
            } else {
                j();
                i(b());
                h();
                return;
            }
        }
        QLog.e("GuildFeedGallerySaveOperation", 1, "operate, check the building params");
    }

    public void p(GuildFeedRichMediaDownLoadManager.c cVar) {
        this.f223356d = cVar;
    }
}
