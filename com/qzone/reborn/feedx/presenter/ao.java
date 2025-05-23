package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ao extends cm implements Observer<af.c> {
    private QZoneRichTextView F;
    private QZoneRichTextView G;
    private ImageView H;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements CellTextView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f55540a;

        a(View view) {
            this.f55540a = view;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
        public List<TextCell> a(List<TextCell> list) {
            return com.qzone.reborn.feedx.widget.b.c(list, this.f55540a.getResources().getColor(R.color.qui_common_text_primary));
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
            if (!(textCell instanceof UserNameCell) || ((UserNameCell) textCell).getUin().longValue() == 0) {
                return;
            }
            ho.h.b(((vg.a) ao.this).C, textCell.getUin().longValue());
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }
    }

    private void M() {
        final String a16 = ef.b.a(this.f441565h);
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this.f441563e).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.presenter.an
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                ao.this.P(a16, (gf.e) obj);
            }
        }).run();
    }

    private int O() {
        return com.qzone.reborn.feedx.util.x.f55790a.c(o()) ? 15 : 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(String str, gf.e eVar) {
        eVar.k5(this.F, "em_qz_like_message", str, this.f441565h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        H(this.f441565h, this.C);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void S(ArrayList<CellLikeInfo.LikeMan> arrayList, int i3) {
        String L = L(arrayList, i3);
        this.F.setVisibility(0);
        this.F.setRichText("      " + L);
        this.F.setOnCellClickListener(new b());
    }

    private void T() {
        Space space;
        if (com.qzone.reborn.feedx.util.x.f55790a.c(o()) || (space = (Space) this.f441563e.findViewById(R.id.mcj)) == null) {
            return;
        }
        space.setVisibility(8);
        if (this.f441562d.getVisibility() == 0 && com.tencent.mobileqq.utils.bl.b(this.f441565h.getCommentInfo().commments)) {
            space.setVisibility(0);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        U(businessFeedData);
        if (!TextUtils.isEmpty(ef.b.a(businessFeedData))) {
            ze.a.a().observerGlobalState(new af.c(ef.b.a(businessFeedData), businessFeedData.cellLikeInfo), this);
        }
        M();
        this.H.setImageResource(com.qzone.reborn.feedx.util.x.f55790a.b(businessFeedData));
    }

    @Override // vg.a
    public void B() {
        super.B();
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedLikeListPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnq;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        super.z();
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.c cVar) {
        if (cVar == null || !TextUtils.equals(cVar.a(), ef.b.a(this.f441565h))) {
            return;
        }
        this.f441565h.cellLikeInfo = cVar.b();
        U(this.f441565h);
    }

    protected void U(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getLikeInfoV2() != null && businessFeedData.getLikeInfoV2().likeNum > 0) {
            this.f441562d.setVisibility(0);
            S(businessFeedData.getLikeInfoV2().likeMans, businessFeedData.getLikeInfoV2().likeNum);
        } else {
            this.f441562d.setVisibility(8);
        }
        T();
    }

    private String N(int i3) {
        if (i3 <= 2) {
            return BaseApplication.getContext().getString(R.string.o3u);
        }
        return BaseApplication.getContext().getString(R.string.o48, Integer.valueOf(i3));
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (QZoneRichTextView) view.findViewById(R.id.n6o);
        this.H = (ImageView) view.findViewById(R.id.n6m);
        this.G = (QZoneRichTextView) view.findViewById(R.id.n6l);
        this.F.setTextSize(com.qzone.util.ar.e(14.0f));
        this.F.setPreDecorateListener(new a(view));
        this.F.setLineSpace(com.qzone.util.ar.d(3.0f));
        this.G.setLineSpace(com.qzone.util.ar.d(3.0f));
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ao.this.Q(view2);
            }
        });
    }

    private String L(ArrayList<CellLikeInfo.LikeMan> arrayList, int i3) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            int min = Math.min(arrayList.size(), O());
            for (int i16 = 0; i16 < min; i16++) {
                CellLikeInfo.LikeMan likeMan = arrayList.get(i16);
                if (likeMan != null) {
                    sb5.append(gh.a.a(likeMan.user, false));
                    if (i16 < arrayList.size() - 1) {
                        sb5.append("\u3001");
                    }
                }
            }
            return ((Object) sb5) + " " + N(i3);
        }
        return BaseApplication.getContext().getString(R.string.f169535o40, Integer.valueOf(i3));
    }
}
