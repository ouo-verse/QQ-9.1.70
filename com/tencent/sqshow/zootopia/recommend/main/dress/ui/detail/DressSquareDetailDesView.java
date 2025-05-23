package com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailDesView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.sqshow.zootopia.widget.AlphaClickableLinearLayout;
import fb4.a;
import ib4.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.au;
import pu4.j;
import pu4.l;
import pu4.n;
import pu4.p;
import pu4.r;
import pu4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001'B#\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010!\u001a\u00020\t\u00a2\u0006\u0004\b\"\u0010#B\u0013\b\u0016\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\"\u0010$B\u001f\b\u0016\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b\"\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J)\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006("}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/detail/DressSquareDetailDesView;", "Landroid/widget/RelativeLayout;", "", "g", "Lpu4/n;", "outfitWorksInfo", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "i", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "", "id", "", "uin", DomainData.DOMAIN_NAME, "(ILjava/lang/String;Ljava/lang/Long;)V", "Lfb4/a;", "d", "Lfb4/a;", "getRepository", "()Lfb4/a;", "repository", "Ln74/au;", "e", "Ln74/au;", "getBinding", "()Ln74/au;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressSquareDetailDesView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a repository;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final au binding;

    public DressSquareDetailDesView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.repository = new a(ZootopiaSource.INSTANCE.g());
        au g16 = au.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.binding = g16;
    }

    private final void g() {
        this.binding.f418747b.setVisibility(4);
        AlphaClickableLinearLayout alphaClickableLinearLayout = this.binding.f418752g;
        Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout, "binding.privacyLl");
        aa.d(alphaClickableLinearLayout, new View.OnClickListener() { // from class: jb4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailDesView.h(DressSquareDetailDesView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DressSquareDetailDesView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("DressSquareDetailDesView", 1, "show visible scope Dialog");
        h.t(h.f407398a, this$0.getContext(), "", 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DressSquareDetailDesView this$0, n nVar, ZootopiaSource zootopiaSource, View view) {
        s sVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kb4.a aVar = kb4.a.f411993a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String valueOf = String.valueOf((nVar == null || (sVar = nVar.f427500c) == null) ? 0L : sVar.f427518a);
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.ZootopiaActivity, "", null, 4, null);
        }
        aVar.e(context, valueOf, zootopiaSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DressSquareDetailDesView this$0, n nVar, View view) {
        l lVar;
        j jVar;
        l lVar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("DressSquareDetailDesView", 1, "click dress layout, do jump");
        kb4.a aVar = kb4.a.f411993a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = null;
        String str2 = (nVar == null || (lVar2 = nVar.f427499b) == null) ? null : lVar2.f427476a;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = (nVar == null || (jVar = nVar.f427498a) == null) ? null : jVar.f427463b;
        if (nVar != null && (lVar = nVar.f427499b) != null) {
            str = lVar.f427484i;
        }
        aVar.i(context, str2, str3, str != null ? str : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(n nVar, DressSquareDetailDesView this$0, View view) {
        l lVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d("DressSquareDetailDesView", 1, "click little world");
        String str = (nVar == null || (lVar = nVar.f427499b) == null) ? null : lVar.f427489n;
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(this$0.getContext(), R.string.xm9, 0).show();
            return;
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(n nVar, View view) {
        p84.a.f425784a.b(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DressSquareDetailDesView this$0, String str, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("DressSquareDetailDesView", 1, "show visible scope Dialog");
        h hVar = h.f407398a;
        Context context = this$0.getContext();
        if (str == null) {
            str = "";
        }
        hVar.s(context, str, i3);
    }

    public final void i(final n outfitWorksInfo, final ZootopiaSource sourceCurrent) {
        l lVar;
        r rVar;
        p[] pVarArr;
        l lVar2;
        String str;
        s sVar;
        String str2;
        s sVar2;
        j jVar;
        j jVar2;
        this.binding.f418753h.setVisibility(8);
        int i3 = (outfitWorksInfo == null || (jVar2 = outfitWorksInfo.f427498a) == null) ? 1 : jVar2.f427466e;
        Long l3 = null;
        String str3 = (outfitWorksInfo == null || (jVar = outfitWorksInfo.f427498a) == null) ? null : jVar.f427462a;
        if (outfitWorksInfo != null && (sVar2 = outfitWorksInfo.f427500c) != null) {
            l3 = Long.valueOf(sVar2.f427518a);
        }
        n(i3, str3, l3);
        if (outfitWorksInfo != null && (sVar = outfitWorksInfo.f427500c) != null && (str2 = sVar.f427519b) != null) {
            if (str2.length() > 0) {
                this.binding.f418755j.setText(getContext().getResources().getString(R.string.xnz, str2));
            }
        }
        TextView textView = this.binding.f418755j;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        aa.d(textView, new View.OnClickListener() { // from class: jb4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailDesView.j(DressSquareDetailDesView.this, outfitWorksInfo, sourceCurrent, view);
            }
        });
        if (outfitWorksInfo != null && (lVar2 = outfitWorksInfo.f427499b) != null && (str = lVar2.f427477b) != null) {
            this.binding.f418748c.setText(str);
        }
        int length = (outfitWorksInfo == null || (lVar = outfitWorksInfo.f427499b) == null || (rVar = lVar.f427480e) == null || (pVarArr = rVar.f427517a) == null) ? 0 : pVarArr.length;
        if (length == 0) {
            QLog.d("DressSquareDetailDesView", 1, "dressCount is 0, hide dress layout");
            this.binding.f418749d.setVisibility(8);
        } else {
            this.binding.f418749d.setVisibility(0);
            this.binding.f418750e.setText(getContext().getResources().getString(R.string.f169799xo1, Integer.valueOf(length)));
        }
        LinearLayout linearLayout = this.binding.f418749d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.dressLl");
        aa.d(linearLayout, new View.OnClickListener() { // from class: jb4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailDesView.k(DressSquareDetailDesView.this, outfitWorksInfo, view);
            }
        });
        LinearLayout linearLayout2 = this.binding.f418754i;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.tagLl");
        aa.d(linearLayout2, new View.OnClickListener() { // from class: jb4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailDesView.l(pu4.n.this, this, view);
            }
        });
        TextView textView2 = this.binding.f418747b;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.debugView");
        aa.d(textView2, new View.OnClickListener() { // from class: jb4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressSquareDetailDesView.m(pu4.n.this, view);
            }
        });
    }

    public final void n(final int showType, final String id5, Long uin) {
        QLog.d("DressSquareDetailDesView", 1, "show visible scope Dialog " + showType + " , id: " + id5 + " , uin: " + uin);
        if (w.f373306a.c(String.valueOf(uin != null ? uin.longValue() : 0L))) {
            QLog.d("DressSquareDetailDesView", 1, "updatePrivacyLayout, is self, showType:" + showType);
            if (showType == 1) {
                this.binding.f418752g.setVisibility(4);
            } else if (showType == 2) {
                this.binding.f418752g.setVisibility(0);
            }
            AlphaClickableLinearLayout alphaClickableLinearLayout = this.binding.f418752g;
            Intrinsics.checkNotNullExpressionValue(alphaClickableLinearLayout, "binding.privacyLl");
            aa.d(alphaClickableLinearLayout, new View.OnClickListener() { // from class: jb4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DressSquareDetailDesView.o(DressSquareDetailDesView.this, id5, showType, view);
                }
            });
            return;
        }
        QLog.d("DressSquareDetailDesView", 1, "updatePrivacyLayout, is not self, showType:" + showType);
        this.binding.f418752g.setVisibility(4);
    }

    public DressSquareDetailDesView(Context context) {
        this(context, null);
    }

    public DressSquareDetailDesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.binding.getRoot(), layoutParams);
        g();
    }
}
