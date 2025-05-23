package com.qzone.reborn.feedx.presenter.detailcomment;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.detail.DetailUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.util.c;
import com.qzone.publish.ui.model.QzoneVipCommentIconInfo;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedxDetailReplyItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gf.d;
import gf.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x8.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxDetailReplyItemView extends QZoneFeedDetailBaseCommentWidget implements View.OnClickListener {
    private QZoneRichTextView C;
    private LinearLayout D;
    private ImageView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private pg.a I;

    /* renamed from: i, reason: collision with root package name */
    private QZoneUserAvatarView f55625i;

    /* renamed from: m, reason: collision with root package name */
    private QZoneNickNameView f55626m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFeedxDetailReplyItemView.this.s0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements CellTextView.d {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
        public List<TextCell> a(List<TextCell> list) {
            return com.qzone.reborn.feedx.widget.b.c(list, QZoneFeedxDetailReplyItemView.this.getResources().getColor(R.color.qui_common_text_secondary));
        }
    }

    public QZoneFeedxDetailReplyItemView(Context context) {
        super(context);
        C0();
    }

    private Map<String, Object> A0() {
        HashMap hashMap = new HashMap();
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_HIGHLIGHT, "0");
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) p(GroupAlbumFeedDetailViewModel.class);
        if (groupAlbumFeedDetailViewModel != null) {
            pg.a aVar = this.I;
            if (aVar.f426125c != null && aVar.f426126d != null && TextUtils.equals(groupAlbumFeedDetailViewModel.getLocationCommentId(), this.I.f426125c.commentid) && TextUtils.equals(groupAlbumFeedDetailViewModel.getLocationReplyId(), this.I.f426126d.replyId)) {
                hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_HIGHLIGHT, "1");
            }
        }
        return hashMap;
    }

    private void B0() {
        if (r0() != null) {
            d r06 = r0();
            BusinessFeedData businessFeedData = this.f55603e;
            pg.a aVar = this.I;
            r06.P0(businessFeedData, aVar.f426125c, aVar.f426126d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(String str, e eVar) {
        eVar.f9(this.C, "em_qz_comment_information", str, A0(), this.f55603e);
    }

    private void E0() {
        this.f55625i.setUser(this.I.f426126d.user);
    }

    private void F0() {
        String sb5;
        User user;
        pg.a aVar = this.I;
        Comment comment = aVar.f426125c;
        Reply reply = aVar.f426126d;
        boolean isEmpty = TextUtils.isEmpty(reply.content);
        this.C.setVisibility(isEmpty ? 8 : 0);
        this.C.setUrlColorRes(getResources().getColor(R.color.qui_common_text_secondary));
        this.C.setFont(reply.getFontId(false), reply.getFontUrl(false), reply.getFontType(false));
        QZoneFeedxViewUtils.j(this.C, reply.getSuperFontInfo(false));
        StringBuilder sb6 = new StringBuilder();
        if (comment != null && (user = reply.targetUser) != null && comment.user.uin != user.uin) {
            sb6.append("{text:");
            sb6.append(" \u56de\u590d ");
            sb6.append(",color:");
            sb6.append(Integer.toHexString(j.o()));
            sb6.append(",useDefaultFont:1,useSuperFont:0}");
            User user2 = reply.targetUser;
            if (user2.actiontype == 2) {
                sb6.append(DetailUtil.buildActionUrlString(user2.actionurl, user2.nickName));
            } else {
                sb6.append(DetailUtil.buildNicknameString(user2.uin, user2.nickName));
            }
            sb6.append("{text:");
            sb6.append(MsgSummary.STR_COLON);
            sb6.append(",color:");
            sb6.append(Integer.toHexString(j.o()));
            sb6.append(",useDefaultFont:1,useSuperFont:0}");
        }
        sb6.append(reply.content);
        this.C.setDrawBackground(true);
        this.C.setColorBackground(getResources().getColor(R.color.qui_common_fill_light_secondary_pressed));
        QZoneRichTextView qZoneRichTextView = this.C;
        String str = "";
        if (isEmpty) {
            sb5 = "";
        } else {
            sb5 = sb6.toString();
        }
        qZoneRichTextView.setRichText(sb5);
        if (i.H().S0()) {
            QZoneRichTextView qZoneRichTextView2 = this.C;
            if (!isEmpty) {
                str = DetailUtil.EmoCode2Text(reply.content);
            }
            qZoneRichTextView2.setContentDescription(str);
        }
    }

    private void G0() {
        User user;
        String buildNicknameString;
        Reply reply = this.I.f426126d;
        if (reply == null || (user = reply.user) == null) {
            return;
        }
        if (ch.j.g(user.vipCommentInfo)) {
            buildNicknameString = L0();
        } else {
            User user2 = this.I.f426126d.user;
            buildNicknameString = DetailUtil.buildNicknameString(user2.uin, user2.nickName);
        }
        H0(y0(buildNicknameString));
    }

    private void H0(String str) {
        String EmoCode2Text;
        this.f55626m.setRichText(str);
        if (i.H().S0()) {
            QZoneNickNameView qZoneNickNameView = this.f55626m;
            if (TextUtils.isEmpty(str)) {
                EmoCode2Text = "";
            } else {
                EmoCode2Text = DetailUtil.EmoCode2Text(this.I.f426126d.user.nickName + " \u56de\u590d " + this.I.f426126d.targetUser.nickName);
            }
            qZoneNickNameView.setContentDescription(EmoCode2Text);
        }
    }

    private void I0() {
        Resources resources;
        int i3;
        if (x.f55790a.i(this.f55603e)) {
            this.D.setVisibility(0);
            this.D.setOnClickListener(this);
            p0(this.D);
            this.E.setSelected(this.I.f426126d.isliked);
            int i16 = this.I.f426126d.likeNum;
            if (i16 > 0) {
                this.F.setText(com.qzone.proxy.feedcomponent.util.d.l(i16));
                this.F.setVisibility(0);
            } else {
                this.F.setVisibility(8);
            }
        } else {
            this.D.setVisibility(8);
        }
        LinearLayout linearLayout = this.D;
        if (this.I.f426126d.isliked) {
            resources = getResources();
            i3 = R.string.jkb;
        } else {
            resources = getResources();
            i3 = R.string.f2202368k;
        }
        AccessibilityUtil.c(linearLayout, resources.getString(i3), Button.class.getName());
    }

    private void J0() {
        this.H.setVisibility(0);
        if (w0()) {
            this.H.setVisibility(8);
        }
    }

    private void K0() {
        String str;
        String str2 = this.I.f426126d.refer;
        if (str2 != null && str2.length() > 0) {
            str = " " + this.I.f426126d.refer;
        } else {
            str = "";
        }
        this.G.setText(c.d(this.I.f426126d.date) + str);
    }

    private String y0(String str) {
        StringBuilder sb5 = new StringBuilder();
        Reply reply = this.I.f426126d;
        long j3 = reply.targetUser.uin;
        User user = reply.user;
        if (j3 != user.uin) {
            if (user.actiontype == 2) {
                sb5.append(DetailUtil.buildActionUrlString(user.actionurl, user.nickName));
            } else {
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    private void z0() {
        String str;
        if (this.f55603e == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ef.b.a(this.f55603e));
        Comment comment = this.I.f426125c;
        String str2 = "";
        if (comment == null) {
            str = "";
        } else {
            str = comment.commentid;
        }
        sb5.append(str);
        Reply reply = this.I.f426126d;
        if (reply != null) {
            str2 = reply.replyId;
        }
        sb5.append(str2);
        final String sb6 = sb5.toString();
        RFWIocAbilityProvider.g().getIoc(e.class).originView(this).done(new OnPromiseResolved() { // from class: pg.e
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneFeedxDetailReplyItemView.this.D0(sb6, (gf.e) obj);
            }
        }).run();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chc;
    }

    @Override // com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedDetailBaseCommentWidget
    protected String getLogTag() {
        return "QZoneFeedxDetailReplyItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedDetailBaseCommentWidget, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(pg.a aVar, int i3) {
        super.bindData(aVar, i3);
        if (aVar == null) {
            return;
        }
        this.I = aVar;
        E0();
        G0();
        F0();
        I0();
        K0();
        J0();
        z0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.met) {
            B0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private String L0() {
        String e16 = ch.j.e(2);
        QzoneVipCommentIconInfo qzoneVipCommentIconInfo = this.I.f426126d.user.vipCommentInfo;
        d.a aVar = new d.a(qzoneVipCommentIconInfo.f51898d, e16, qzoneVipCommentIconInfo.f51899e, qzoneVipCommentIconInfo.f51900f, Boolean.FALSE);
        User user = this.I.f426126d.user;
        return DetailUtil.buildVipNicknameString(user.uin, user.nickName, aVar);
    }

    private void C0() {
        this.f55625i = (QZoneUserAvatarView) findViewById(R.id.nby);
        this.f55626m = (QZoneNickNameView) findViewById(R.id.n87);
        this.C = (QZoneRichTextView) findViewById(R.id.nbg);
        this.D = (LinearLayout) findViewById(R.id.met);
        this.E = (ImageView) findViewById(R.id.lq8);
        this.F = (TextView) findViewById(R.id.f162959nj4);
        this.G = (TextView) findViewById(R.id.nic);
        TextView textView = (TextView) findViewById(R.id.njw);
        this.H = textView;
        textView.setOnClickListener(new a());
        this.f55626m.setParseUrl(false);
        this.f55626m.setDrawBackground(true);
        this.f55626m.setTextColorLink(getResources().getColor(R.color.qui_common_text_primary));
        this.C.setPreDecorateListener(new b());
        this.C.setTextColorLink(getResources().getColor(R.color.qui_common_text_link));
        v0(this.C);
    }
}
