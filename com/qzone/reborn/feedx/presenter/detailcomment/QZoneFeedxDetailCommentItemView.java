package com.qzone.reborn.feedx.presenter.detailcomment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.j;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.detail.DetailUtil;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.util.d;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneVipCommentIconInfo;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedxDetailCommentItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.aa;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.QZoneCommentNickView;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.qzone.util.l;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gf.e;
import ho.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x8.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxDetailCommentItemView extends QZoneFeedDetailBaseCommentWidget implements View.OnClickListener {
    private QZoneRichTextView C;
    private QZoneCommentNickView D;
    private LinearLayout E;
    private ImageView F;
    private TextView G;
    private TextView H;
    private Comment I;
    private RecyclerView J;
    private com.qzone.reborn.feedx.widget.comment.a K;
    private gf.a L;
    private TextView M;

    /* renamed from: i, reason: collision with root package name */
    private QZoneUserAvatarView f55617i;

    /* renamed from: m, reason: collision with root package name */
    private QZoneNickNameView f55618m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFeedxDetailCommentItemView.this.s0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneFeedxDetailCommentItemView.this.I != null && QZoneFeedxDetailCommentItemView.this.I.user != null && QZoneFeedxDetailCommentItemView.this.I.user.uin > 0 && (QZoneFeedxDetailCommentItemView.this.getContext() instanceof Activity)) {
                h.b((Activity) QZoneFeedxDetailCommentItemView.this.getContext(), QZoneFeedxDetailCommentItemView.this.I.user.uin);
                fh.c.a(QZoneFeedxDetailCommentItemView.this.f55603e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements CellTextView.d {
        c() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
        public List<TextCell> a(List<TextCell> list) {
            return com.qzone.reborn.feedx.widget.b.c(list, QZoneFeedxDetailCommentItemView.this.getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    public QZoneFeedxDetailCommentItemView(Context context) {
        super(context);
        E0();
    }

    private String A0(boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        String str = this.I.user.nickName;
        if (z16) {
            sb5.append(gh.a.e(str, false, true));
            sb5.append("  ");
            return DetailUtil.buildNicknameString(this.I.user.uin, sb5.toString());
        }
        sb5.append(str);
        return sb5.toString();
    }

    private void B0() {
        String str;
        if (this.f55603e == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ef.b.a(this.f55603e));
        Comment comment = this.I;
        if (comment != null) {
            str = comment.commentid;
        } else {
            str = "";
        }
        sb5.append(str);
        final String sb6 = sb5.toString();
        RFWIocAbilityProvider.g().getIoc(e.class).originView(this).done(new OnPromiseResolved() { // from class: pg.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneFeedxDetailCommentItemView.this.F0(sb6, (gf.e) obj);
            }
        }).run();
    }

    private Map<String, Object> C0() {
        HashMap hashMap = new HashMap();
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_HIGHLIGHT, "0");
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) p(GroupAlbumFeedDetailViewModel.class);
        if (groupAlbumFeedDetailViewModel != null && this.I != null && TextUtils.isEmpty(groupAlbumFeedDetailViewModel.getLocationReplyId()) && TextUtils.equals(groupAlbumFeedDetailViewModel.getLocationCommentId(), this.I.commentid)) {
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_HIGHLIGHT, "1");
        }
        return hashMap;
    }

    private void D0() {
        if (r0() != null) {
            r0().R6(this.f55603e, this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(String str, e eVar) {
        eVar.k5(this.M, "em_qz_comment_reply_icon", str, this.f55603e);
        eVar.f9(this.C, "em_qz_comment_information", str, C0(), this.f55603e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(Comment comment, View view, int i3) {
        gf.a q06 = q0();
        if (q06 != null) {
            q06.H7(view, this.f55603e, comment, null, this.dataPosInList);
        }
    }

    private void H0() {
        this.f55617i.setUser(this.I.user);
    }

    private void I0() {
        Resources resources;
        int i3;
        if (x.f55790a.i(this.f55603e)) {
            this.E.setVisibility(0);
            this.E.setOnClickListener(this);
            p0(this.E);
            this.F.setSelected(this.I.isliked);
            int i16 = this.I.likeNum;
            if (i16 > 0) {
                this.G.setText(d.l(i16));
                this.G.setVisibility(0);
            } else {
                this.G.setVisibility(8);
            }
        } else {
            this.E.setVisibility(8);
        }
        LinearLayout linearLayout = this.E;
        if (this.I.isliked) {
            resources = getResources();
            i3 = R.string.jkb;
        } else {
            resources = getResources();
            i3 = R.string.f2202368k;
        }
        AccessibilityUtil.c(linearLayout, resources.getString(i3), Button.class.getName());
    }

    private void J0(final Comment comment) {
        ArrayList<PictureItem> arrayList;
        ArrayList<PictureItem> arrayList2 = comment.commentPictureItems;
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList = comment.commentPictureItems;
        } else {
            arrayList = comment.pictureItems;
        }
        if (bl.b(arrayList)) {
            this.J.setVisibility(8);
            return;
        }
        this.J.setVisibility(0);
        if (this.K == null) {
            com.qzone.reborn.feedx.widget.comment.a aVar = new com.qzone.reborn.feedx.widget.comment.a();
            this.K = aVar;
            aVar.j0(new QZoneFeedxCommentImageItem.d() { // from class: pg.b
                @Override // com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem.d
                public final void a(View view, int i3) {
                    QZoneFeedxDetailCommentItemView.this.G0(comment, view, i3);
                }
            });
            this.J.setAdapter(this.K);
        }
        this.K.i0(comment);
        this.K.setDatas(arrayList);
    }

    private void K0() {
        String pokeLikeComment;
        boolean isEmpty = TextUtils.isEmpty(this.I.comment);
        this.C.setVisibility(isEmpty ? 8 : 0);
        this.C.setUrlColorRes(getResources().getColor(R.color.qui_common_text_secondary));
        this.C.setFont(this.I.getFontId(false), this.I.getFontUrl(false), this.I.getFontType(false));
        QZoneFeedxViewUtils.j(this.C, this.I.getSuperFontInfo(false));
        boolean z16 = this.I.hasPokeLike() && (TextUtils.isEmpty(this.I.comment) || "\u2000".equals(this.I.comment));
        Comment comment = this.I;
        QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = comment.getBarrageEffectInfo(comment.feedType == 4097);
        if (barrageEffectInfo != null && barrageEffectInfo.f51896id > 0 && !z16) {
            this.C.setBarrageEffect(true, barrageEffectInfo);
        } else {
            this.C.setBarrageEffect(false, null);
        }
        this.C.setDrawBackground(true);
        this.C.setColorBackground(getResources().getColor(R.color.qui_common_fill_light_secondary_pressed));
        QZoneRichTextView qZoneRichTextView = this.C;
        String str = "";
        if (isEmpty) {
            pokeLikeComment = "";
        } else {
            pokeLikeComment = this.I.getPokeLikeComment();
        }
        qZoneRichTextView.setRichText(pokeLikeComment);
        this.C.setTextColorLink(getResources().getColor(R.color.qui_common_text_link));
        if (i.H().S0()) {
            QZoneRichTextView qZoneRichTextView2 = this.C;
            if (!isEmpty) {
                str = DetailUtil.EmoCode2Text(this.I.comment);
            }
            qZoneRichTextView2.setContentDescription(str);
        }
    }

    private void L0() {
        String A0;
        Comment comment = this.I;
        if (comment.user == null) {
            return;
        }
        boolean b16 = aa.b(this.f55603e, comment, getData().f426127e);
        boolean g16 = j.g(this.I.user.vipCommentInfo);
        if (g16) {
            A0 = O0(b16);
        } else {
            A0 = A0(b16);
        }
        this.D.s0(A0);
        if (aa.b(this.f55603e, this.I, getData().f426127e)) {
            this.D.setFeedDetail(true);
            this.D.setHasBarrageEffect(false);
            this.D.o0(g16, aa.h(this.f55603e), null);
            this.D.p0(aa.d(this.f55603e));
            fh.c.b(this.f55603e);
        } else {
            this.D.n0(Integer.valueOf(getResources().getColor(R.color.qui_common_text_primary)));
        }
        AccessibilityUtil.s(this.f55617i, this.I.user.nickName + l.a(R.string.gqz));
    }

    private void M0() {
        this.M.setVisibility(0);
        if (w0()) {
            this.M.setVisibility(8);
        }
    }

    private void N0() {
        String str;
        String str2 = this.I.refer;
        if (str2 != null && str2.length() > 0) {
            str = " " + this.I.refer;
        } else {
            str = "";
        }
        this.H.setText(com.qzone.proxy.feedcomponent.util.c.d(this.I.time) + str);
    }

    private gf.a q0() {
        if (this.L == null) {
            this.L = (gf.a) getIocInterface(gf.a.class);
        }
        return this.L;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cha;
    }

    @Override // com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedDetailBaseCommentWidget
    protected String getLogTag() {
        return "QZoneFeedxDetailCommentItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedDetailBaseCommentWidget, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(pg.a aVar, int i3) {
        super.bindData(aVar, i3);
        if (aVar == null) {
            return;
        }
        this.I = aVar.f426125c;
        H0();
        L0();
        K0();
        I0();
        N0();
        J0(this.I);
        M0();
        B0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.met) {
            D0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private String O0(boolean z16) {
        String e16 = j.e(2);
        QzoneVipCommentIconInfo qzoneVipCommentIconInfo = this.I.user.vipCommentInfo;
        d.a aVar = new d.a(qzoneVipCommentIconInfo.f51898d, e16, qzoneVipCommentIconInfo.f51899e, qzoneVipCommentIconInfo.f51900f, Boolean.FALSE);
        return DetailUtil.buildVipNicknameString(this.I.user.uin, gh.a.e(this.I.user.nickName, false, z16), aVar);
    }

    private void E0() {
        this.f55617i = (QZoneUserAvatarView) findViewById(R.id.nby);
        QZoneCommentNickView qZoneCommentNickView = (QZoneCommentNickView) findViewById(R.id.mrw);
        this.D = qZoneCommentNickView;
        this.f55618m = (QZoneNickNameView) qZoneCommentNickView.findViewById(R.id.mrm);
        this.C = (QZoneRichTextView) findViewById(R.id.nbg);
        this.E = (LinearLayout) findViewById(R.id.met);
        this.F = (ImageView) findViewById(R.id.lq8);
        this.G = (TextView) findViewById(R.id.f162959nj4);
        this.H = (TextView) findViewById(R.id.nic);
        TextView textView = (TextView) findViewById(R.id.njw);
        this.M = textView;
        textView.setOnClickListener(new a());
        this.f55618m.setMaxLine(-1);
        this.f55618m.setParseUrl(false);
        this.f55618m.setDrawBackground(true);
        this.f55618m.setOnClickListener(new b());
        this.C.setPreDecorateListener(new c());
        v0(this.C);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.msz);
        this.J = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }
}
