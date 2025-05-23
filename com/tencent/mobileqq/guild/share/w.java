package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.guild.share.util.GuildShareToWXInfo;
import com.tencent.mobileqq.guild.share.util.GuildWXShareUtils;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private final y f235146a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f235147b;

    /* renamed from: d, reason: collision with root package name */
    private final GuildSharePageSource f235149d;

    /* renamed from: c, reason: collision with root package name */
    private final IShareActionHelper f235148c = (IShareActionHelper) QRoute.api(IShareActionHelper.class);

    /* renamed from: e, reason: collision with root package name */
    private boolean f235150e = false;

    public w(@NonNull Activity activity, @NonNull y yVar, @NonNull GuildSharePageSource guildSharePageSource) {
        this.f235146a = yVar;
        this.f235147b = activity;
        this.f235149d = guildSharePageSource;
    }

    private Intent d() {
        Intent intent = new Intent();
        com.tencent.mobileqq.sharehelper.a e16 = this.f235146a.e();
        if (e16 != null) {
            com.tencent.mobileqq.guild.share.util.d.a(e16, intent);
        }
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(AppConstants.Key.GUILD_SOURCE_ID, this.f235146a.u());
        intent.putExtra(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, this.f235146a.t());
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 6);
        intent.putExtra("businessType", this.f235146a.h());
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.ShareActionExecutor", 2, "sourceGuildId: ", Long.valueOf(this.f235146a.u()), "sourceChannelId: ", Long.valueOf(this.f235146a.t()));
        }
        intent.putExtra("call_by_forward", true);
        return intent;
    }

    private Intent e(int i3, String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", i3);
        bundle.putString("key_direct_show_uin", str);
        intent.putExtras(bundle);
        intent.putExtra("caller_name", this.f235147b.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        intent.putExtra("forward_source_sub_business_type", "");
        return intent;
    }

    private Intent f() {
        Intent intent = new Intent();
        intent.putExtra("title", this.f235146a.q());
        intent.putExtra("desc", this.f235146a.d());
        intent.putExtra("image_url", this.f235146a.g());
        intent.putExtra("detail_url", this.f235146a.s());
        GuildForwardUtilKt.m(intent, new SharePublishGuildFeedParam.LinkTypeParam(com.tencent.mobileqq.guild.discoveryv2.hotlive.f.a(this.f235146a.s()), com.tencent.mobileqq.guild.discoveryv2.hotlive.f.a(this.f235146a.g()), com.tencent.mobileqq.guild.discoveryv2.hotlive.f.a(this.f235146a.q()), com.tencent.mobileqq.guild.discoveryv2.hotlive.f.a(this.f235146a.d())));
        return intent;
    }

    private Intent h(int i3, String str) {
        Intent intent = new Intent();
        intent.putExtras(d());
        intent.putExtras(f());
        intent.putExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, this.f235149d.ordinal());
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, !this.f235150e);
        if (i3 != -1 && !TextUtils.isEmpty(str)) {
            intent.putExtras(e(i3, str));
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Intent intent) {
        RouteUtils.startActivityForResult(this.f235147b, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.ShareActionExecutor", 1, "shareToFriend success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Intent intent) {
        RouteUtils.startActivityForResult(this.f235147b, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.ShareActionExecutor", 1, "directlyShareToFriend success");
        }
    }

    private void l(int i3) {
        GuildActionSheetAttaUtil.o(this.f235146a.s(), i3, this.f235149d.ordinal(), "");
    }

    private void o() {
        BaseApplication context = BaseApplication.getContext();
        y yVar = this.f235146a;
        GuildWXShareUtils.p(context, GuildShareToWXInfo.f(yVar, yVar.f235162a, yVar.f235164c));
    }

    private void v(int i3) {
        this.f235148c.doShareLinkToWeChat("guildShare", i3, this.f235146a.v(), this.f235147b, String.valueOf(System.currentTimeMillis()), this.f235146a.d(), this.f235146a.q(), this.f235146a.g(), null);
    }

    private void z(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f235146a.G(str);
            if (QLog.isDebugVersion()) {
                QLog.d("Guild.share.ShareActionExecutor", 1, "update ark", str);
                return;
            }
            return;
        }
        QLog.d("Guild.share.ShareActionExecutor", 1, "don't update arkMsg");
    }

    public void c() {
        ClipboardMonitor.setPrimaryClip((ClipboardManager) this.f235147b.getSystemService("clipboard"), ClipData.newPlainText("group_pro_number", this.f235146a.k()));
        QQToast.makeText(this.f235147b, 2, this.f235146a.l(), 0).show(R.dimen.title_bar_height);
    }

    public Intent g() {
        return h(-1, "");
    }

    public void k() {
        GuildActionSheetAttaUtil.k(this.f235147b, this.f235146a.f235162a.getGuildID(), this.f235149d.ordinal());
    }

    public void m(List<ResultRecord> list) {
        GuildActionSheetAttaUtil.q(list, this.f235146a.s(), this.f235149d.ordinal(), this.f235146a.f());
    }

    public void n() {
        this.f235150e = true;
    }

    public void p() {
        ClipboardMonitor.setPrimaryClip((ClipboardManager) this.f235147b.getSystemService("clipboard"), ClipData.newPlainText("group_pro_url", this.f235146a.m()));
        QQToast.makeText(this.f235147b, 2, this.f235146a.n(), 0).show(R.dimen.title_bar_height);
        l(197);
    }

    public void q() {
        r(new com.tencent.mobileqq.guild.share.util.g() { // from class: com.tencent.mobileqq.guild.share.u
            @Override // com.tencent.mobileqq.guild.share.util.g
            public final void a(Intent intent) {
                w.this.i(intent);
            }
        });
    }

    public void r(com.tencent.mobileqq.guild.share.util.g gVar) {
        GuildActionSheetAttaUtil.j(g(), this.f235146a.s(), this.f235149d.ordinal(), this.f235146a.f(), null, gVar);
    }

    public void s(String str, int i3) {
        if (this.f235146a.e() == null) {
            com.tencent.mobileqq.guild.util.s.e("Guild.share.ShareActionExecutor", "shareToFriendByUin exception", new RuntimeException());
            QLog.e("Guild.share.ShareActionExecutor", 1, "shareToFriendByUin, no ark data!!!");
        }
        GuildActionSheetAttaUtil.j(h(i3, str), this.f235146a.s(), this.f235149d.ordinal(), this.f235146a.f(), null, new com.tencent.mobileqq.guild.share.util.g() { // from class: com.tencent.mobileqq.guild.share.v
            @Override // com.tencent.mobileqq.guild.share.util.g
            public final void a(Intent intent) {
                w.this.j(intent);
            }
        });
    }

    public void t() {
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(this.f235147b, g(), 20000);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.ShareActionExecutor", 1, "shareToGuild success");
        }
    }

    public void u() {
        this.f235148c.doShareToQZoneWithLink("guildShare", this.f235147b, this.f235146a.r());
        l(3);
    }

    public void w() {
        if (!m02.d.i()) {
            QQToastUtil.showQQToast(R.string.f156731l0);
        } else {
            v(10);
            l(10);
        }
    }

    public void x() {
        if (!m02.d.i()) {
            QQToastUtil.showQQToast(R.string.f156731l0);
            return;
        }
        if (this.f235146a.h() != 9 && this.f235146a.h() != 7) {
            v(9);
        } else {
            o();
        }
        l(9);
    }

    public void y(b bVar) {
        z(bVar.getTemplateData());
        this.f235146a.F(bVar.a());
    }
}
