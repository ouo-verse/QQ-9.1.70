package com.qzone.reborn.feedx.widget.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.j;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.detail.DetailUtil;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneVipCommentIconInfo;
import com.qzone.reborn.feedx.util.aa;
import com.qzone.reborn.feedx.widget.QZoneCommentNickView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedCommentWidget;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem;
import com.qzone.util.ar;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.bl;
import fh.c;
import gf.e;
import java.util.ArrayList;
import java.util.List;
import x8.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedCommentWidget extends QZoneFeedBaseCommentWidget {
    private QZoneCommentNickView C;
    private QZoneRichTextView D;
    private RecyclerView E;
    private com.qzone.reborn.feedx.widget.comment.a F;
    private gf.a G;
    private Comment H;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f56002m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements CellTextView.d {
        a() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
        public List<TextCell> a(List<TextCell> list) {
            return com.qzone.reborn.feedx.widget.b.b(list, QZoneFeedCommentWidget.this.getResources().getColor(R.color.qui_common_text_primary), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements TextCellLayout.OnCellClickListener {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            QZoneFeedCommentWidget.this.D.k(textCell);
            QZoneFeedCommentWidget qZoneFeedCommentWidget = QZoneFeedCommentWidget.this;
            if (aa.b(qZoneFeedCommentWidget.f55996e, qZoneFeedCommentWidget.H, ((BaseWidgetView) QZoneFeedCommentWidget.this).dataPosInList)) {
                c.a(QZoneFeedCommentWidget.this.f55996e);
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }
    }

    public QZoneFeedCommentWidget(Context context) {
        super(context);
        H0();
    }

    private String C0(Comment comment) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(E0(comment));
        boolean isEmpty = TextUtils.isEmpty(comment.comment);
        ArrayList<PictureItem> F0 = F0(comment);
        if (!isEmpty) {
            return ((Object) sb5) + comment.getPokeLikeComment();
        }
        if (!bl.b(F0)) {
            return sb5.toString();
        }
        return "";
    }

    private String E0(Comment comment) {
        User user = comment.user;
        if (user != null && j.g(user.vipCommentInfo)) {
            return N0(comment);
        }
        return gh.a.b(comment.user, true, aa.b(this.f55996e, this.H, this.dataPosInList));
    }

    private ArrayList<PictureItem> F0(Comment comment) {
        ArrayList<PictureItem> arrayList = comment.commentPictureItems;
        if (arrayList != null && arrayList.size() > 0) {
            return comment.commentPictureItems;
        }
        return comment.pictureItems;
    }

    private void G0() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.E = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.E.setHasFixedSize(true);
        this.E.setNestedScrollingEnabled(false);
        com.qzone.reborn.feedx.widget.comment.a aVar = new com.qzone.reborn.feedx.widget.comment.a();
        this.F = aVar;
        aVar.j0(new QZoneFeedxCommentImageItem.d() { // from class: oh.e
            @Override // com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem.d
            public final void a(View view, int i3) {
                QZoneFeedCommentWidget.this.J0(view, i3);
            }
        });
        this.E.setAdapter(this.F);
    }

    private void H0() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f56002m = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f56002m, new FrameLayout.LayoutParams(-1, -2));
        QZoneCommentNickView qZoneCommentNickView = new QZoneCommentNickView(getContext());
        this.C = qZoneCommentNickView;
        this.f56002m.addView(qZoneCommentNickView, new LinearLayout.LayoutParams(-1, -2));
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) this.C.findViewById(R.id.mrm);
        this.D = qZoneRichTextView;
        qZoneRichTextView.setTextSize(ar.e(14.0f));
        this.D.setPreDecorateListener(new a());
        this.D.setOnCellClickListener(new b());
        u0(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(String str, e eVar) {
        eVar.k5(this.D, "em_qz_comment_information", str, this.f55996e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(View view, int i3) {
        gf.a p06 = p0();
        if (p06 == null || getData() == null) {
            return;
        }
        p06.H7(view, this.f55996e, getData().f422673a, null, this.dataPosInList);
    }

    private void K0(Comment comment) {
        this.D.setFont(comment.getFontId(false), comment.getFontUrl(false), comment.getFontType(false));
        oh.c.a(this.D, comment.getSuperFontInfo(false));
        boolean z16 = comment.hasPokeLike() && (TextUtils.isEmpty(comment.comment) || "\u2000".equals(comment.comment));
        QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = comment.getBarrageEffectInfo(comment.feedType == 4097);
        boolean z17 = (barrageEffectInfo == null || barrageEffectInfo.f51896id <= 0 || z16) ? false : true;
        if (z17) {
            this.D.setBarrageEffect(true, barrageEffectInfo);
        } else {
            this.D.setBarrageEffect(false, null);
        }
        M0(comment);
        if (aa.b(this.f55996e, comment, this.dataPosInList)) {
            boolean g16 = j.g(comment.user.vipCommentInfo);
            this.C.setHasBarrageEffect(z17);
            this.C.o0(g16, aa.h(this.f55996e), barrageEffectInfo);
            this.C.p0(aa.d(this.f55996e));
            c.b(this.f55996e);
            return;
        }
        this.C.n0(Integer.valueOf(getResources().getColor(R.color.qui_common_text_primary)));
    }

    private void L0(Comment comment) {
        RecyclerView recyclerView;
        ArrayList<PictureItem> F0 = F0(comment);
        if (bl.b(F0) && (recyclerView = this.E) != null) {
            recyclerView.setVisibility(8);
            return;
        }
        if (this.E == null) {
            G0();
            this.f56002m.addView(this.E);
        }
        this.E.setVisibility(0);
        this.F.i0(comment);
        this.F.setDatas(F0);
    }

    private void M0(Comment comment) {
        String EmoCode2Text;
        this.D.setLineSpace(ImmersiveUtils.dpToPx(1.0f));
        this.D.setDrawBackground(true);
        this.D.setColorBackground(getResources().getColor(R.color.qui_common_fill_light_secondary_pressed));
        this.D.setTextColorLink(getResources().getColor(R.color.qui_common_text_link));
        this.C.s0(C0(comment));
        if (i.H().S0()) {
            boolean isEmpty = TextUtils.isEmpty(comment.comment);
            QZoneRichTextView qZoneRichTextView = this.D;
            if (isEmpty) {
                EmoCode2Text = "";
            } else {
                EmoCode2Text = DetailUtil.EmoCode2Text(comment.comment);
            }
            qZoneRichTextView.setContentDescription(EmoCode2Text);
        }
    }

    private String N0(Comment comment) {
        String e16 = j.e(q0());
        QzoneVipCommentIconInfo qzoneVipCommentIconInfo = comment.user.vipCommentInfo;
        return gh.a.d(comment.user, new d.a(qzoneVipCommentIconInfo.f51898d, e16, qzoneVipCommentIconInfo.f51899e, qzoneVipCommentIconInfo.f51900f, Boolean.TRUE), aa.b(this.f55996e, this.H, this.dataPosInList));
    }

    private gf.a p0() {
        if (this.G == null) {
            this.G = (gf.a) getIocInterface(gf.a.class);
        }
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void bindData(oh.b bVar, int i3) {
        Comment comment = bVar.f422673a;
        this.H = comment;
        K0(comment);
        L0(this.H);
        D0(this.H);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedx.widget.comment.QZoneFeedBaseCommentWidget
    protected String getLogTag() {
        return "QZoneFeedCommentWidget";
    }

    private void D0(Comment comment) {
        if (comment == null || this.D == null) {
            return;
        }
        final String str = comment.uniKey;
        RFWIocAbilityProvider.g().getIoc(e.class).originView(this).done(new OnPromiseResolved() { // from class: oh.d
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneFeedCommentWidget.this.I0(str, (gf.e) obj);
            }
        }).run();
    }
}
