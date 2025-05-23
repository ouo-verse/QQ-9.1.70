package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import ag3.a;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.view.StaggerItemContent;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.o;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m84.b;
import pv4.p;
import tc4.a;
import tl.h;
import zf3.StaggerItemData;
import zf3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u000f\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R\u0014\u0010(\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010\u001bR\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010:\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemContent;", "Landroid/widget/FrameLayout;", "Lag3/a;", "", "", "c", "Lyf3/a;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lzf3/e;", "data", "", "selfPos", "g", "i", "k", "", "d", "l", "canPlay", "e", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lzf3/e;", "mData", "I", "mState", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "mBgArea", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", h.F, "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "mBgMediaView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mDescArea", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mDescTxv", BdhLogUtil.LogTag.Tag_Conn, "mTitleTxv", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemIconLabel;", "D", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemIconLabel;", "mLeftTopLabel", "E", "mRightTopLabel", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemLeftBtmLabel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemLeftBtmLabel;", "mLeftBtmLabel", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemRightBtmLabel;", "G", "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemRightBtmLabel;", "mRightBtmLabel", "H", "mBtmLabelContainer", "Lcom/tencent/sqshow/zootopia/card/report/a;", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "J", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StaggerItemContent extends FrameLayout implements a {

    /* renamed from: J, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView mTitleTxv;

    /* renamed from: D, reason: from kotlin metadata */
    private final StaggerItemIconLabel mLeftTopLabel;

    /* renamed from: E, reason: from kotlin metadata */
    private final StaggerItemIconLabel mRightTopLabel;

    /* renamed from: F, reason: from kotlin metadata */
    private final StaggerItemLeftBtmLabel mLeftBtmLabel;

    /* renamed from: G, reason: from kotlin metadata */
    private final StaggerItemRightBtmLabel mRightBtmLabel;

    /* renamed from: H, reason: from kotlin metadata */
    private final RelativeLayout mBtmLabelContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.card.report.a reportHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private StaggerItemData mData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout mBgArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZPlanMediaView mBgMediaView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mDescArea;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView mDescTxv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemContent$a;", "", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "a", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.card.impl.view.stagger.view.StaggerItemContent$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextView a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setTextColor(-16777216);
            textView.setTextSize(1, 13.0f);
            d dVar = d.f452428a;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dVar.m(), -2);
            textView.setPadding(dVar.n(), 0, dVar.n(), 0);
            textView.setLayoutParams(layoutParams);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            return textView;
        }

        public final TextView b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setTextColor(-7829368);
            textView.setTextSize(1, 10.0f);
            d dVar = d.f452428a;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dVar.m(), -2);
            textView.setPadding(dVar.n(), 0, dVar.n(), 0);
            textView.setLayoutParams(layoutParams);
            return textView;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerItemContent(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mState = 2;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.mBgArea = relativeLayout;
        ZPlanMediaView zPlanMediaView = new ZPlanMediaView(context);
        this.mBgMediaView = zPlanMediaView;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.mDescArea = linearLayout;
        Companion companion = INSTANCE;
        TextView a16 = companion.a(context);
        this.mDescTxv = a16;
        TextView b16 = companion.b(context);
        this.mTitleTxv = b16;
        StaggerItemIconLabel staggerItemIconLabel = new StaggerItemIconLabel(context);
        this.mLeftTopLabel = staggerItemIconLabel;
        StaggerItemIconLabel staggerItemIconLabel2 = new StaggerItemIconLabel(context);
        this.mRightTopLabel = staggerItemIconLabel2;
        StaggerItemLeftBtmLabel staggerItemLeftBtmLabel = new StaggerItemLeftBtmLabel(context);
        this.mLeftBtmLabel = staggerItemLeftBtmLabel;
        StaggerItemRightBtmLabel staggerItemRightBtmLabel = new StaggerItemRightBtmLabel(context);
        this.mRightBtmLabel = staggerItemRightBtmLabel;
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.mBtmLabelContainer = relativeLayout2;
        this.reportHelper = new com.tencent.sqshow.zootopia.card.report.a();
        d dVar = d.f452428a;
        addView(relativeLayout, new FrameLayout.LayoutParams(-1, dVar.f()));
        relativeLayout.addView(zPlanMediaView, new RelativeLayout.LayoutParams(-1, -1));
        zPlanMediaView.setRadius(5);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, dVar.e());
        layoutParams.leftMargin = i.b(4);
        layoutParams.topMargin = i.b(1);
        relativeLayout.addView(staggerItemIconLabel, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, dVar.g());
        layoutParams2.rightMargin = i.b(1);
        layoutParams2.topMargin = i.b(1);
        layoutParams2.addRule(11);
        relativeLayout.addView(staggerItemIconLabel2, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = i.a(9.5f);
        layoutParams3.leftMargin = i.a(7.5f);
        layoutParams3.rightMargin = i.a(3.6f);
        relativeLayout.addView(relativeLayout2, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        relativeLayout2.addView(staggerItemLeftBtmLabel, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(15);
        layoutParams5.addRule(11);
        relativeLayout2.addView(staggerItemRightBtmLabel, layoutParams5);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = dVar.f();
        addView(linearLayout, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = dVar.a();
        linearLayout.addView(a16, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = dVar.p();
        linearLayout.addView(b16, layoutParams8);
    }

    private final void c() {
        RelativeLayout relativeLayout = this.mBgArea;
        d dVar = d.f452428a;
        b.c(relativeLayout, -1, dVar.f(), null, 4, null);
        b.b(this.mDescArea, -1, -2, new Rect(0, dVar.f(), 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(yf3.a card, StaggerItemContent this$0, int i3, StaggerItemData data, View view) {
        Intrinsics.checkNotNullParameter(card, "$card");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_tab_id", card.e());
        com.tencent.sqshow.zootopia.card.report.a.b(this$0.reportHelper, this$0, card.b(), i3, a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, data.getOriginData().f427681b, null, 2, null), card.a(), data.getOriginData(), hashMap, null, 128, null);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, data.getJumpUrl());
    }

    private final void i() {
        final StaggerItemData staggerItemData = this.mData;
        if (staggerItemData == null) {
            return;
        }
        this.mDescArea.setVisibility(8);
        this.mBtmLabelContainer.setVisibility(8);
        this.mLeftTopLabel.setVisibility(8);
        this.mRightTopLabel.setVisibility(8);
        a.C11285a.a(this.mBgMediaView, R.drawable.imf, null, 2, null);
        aa.d(this, new View.OnClickListener() { // from class: bg3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StaggerItemContent.j(StaggerItemContent.this, staggerItemData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(StaggerItemContent this$0, StaggerItemData data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, data.getJumpUrl());
    }

    private final void k() {
        this.mBgMediaView.stop();
    }

    public boolean d(yf3.a card, StaggerItemData data, int selfPos) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(data, "data");
        c();
        if (!Intrinsics.areEqual(this.mData, data)) {
            this.mData = data;
            long currentTimeMillis = System.currentTimeMillis();
            g(card, data, selfPos);
            QLog.i("StaggerItemContent_", 1, "refreshView cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, mediaType:" + data.getMaterial().f427435b + ", mediaUrl:" + data.getMaterial());
        }
        this.mState = 1;
        return true;
    }

    public boolean e(boolean canPlay) {
        StaggerItemData staggerItemData = this.mData;
        if (staggerItemData == null) {
            return false;
        }
        boolean b16 = o.b(staggerItemData.getMaterial());
        if (!o.b(staggerItemData.getMaterial())) {
            this.mBgMediaView.e(staggerItemData.getMaterial());
        } else if (canPlay) {
            this.mBgMediaView.e(staggerItemData.getMaterial());
        }
        QLog.d("StaggerItemContent_", 1, "focused canPlay:" + canPlay + ", materialType:" + staggerItemData.getMaterial().f427435b + ", isCanStopMaterial:" + b16);
        return canPlay && o.b(staggerItemData.getMaterial());
    }

    public boolean f() {
        StaggerItemData staggerItemData = this.mData;
        if (staggerItemData == null) {
            return false;
        }
        return o.b(staggerItemData.getMaterial());
    }

    public void m() {
        k();
    }

    public void l() {
        this.mState = 2;
        k();
    }

    private final void g(final yf3.a card, final StaggerItemData data, final int selfPos) {
        if (data.o()) {
            i();
            return;
        }
        this.mDescArea.setVisibility(0);
        this.mBtmLabelContainer.setVisibility(0);
        this.mLeftTopLabel.setVisibility(0);
        this.mRightTopLabel.setVisibility(0);
        this.mBgMediaView.J(data.getMaterial());
        String str = data.getMainDesc().f427702a;
        if (str == null || str.length() == 0) {
            this.mDescTxv.setVisibility(8);
        } else {
            this.mDescTxv.setVisibility(0);
        }
        String str2 = data.getSubTitle().f427702a;
        if (str2 == null || str2.length() == 0) {
            this.mTitleTxv.setVisibility(8);
        } else {
            this.mTitleTxv.setVisibility(0);
        }
        l84.b.a(this.mDescTxv, data.getMainDesc(), -16777216);
        l84.b.a(this.mTitleTxv, data.getSubTitle(), -7829368);
        if (data.getJumpUrl().length() == 0) {
            setOnClickListener(null);
        } else {
            aa.d(this, new View.OnClickListener() { // from class: bg3.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StaggerItemContent.h(yf3.a.this, this, selfPos, data, view);
                }
            });
        }
        StaggerItemIconLabel staggerItemIconLabel = this.mLeftTopLabel;
        List<p> h16 = data.h();
        d dVar = d.f452428a;
        StaggerItemIconLabel.c(staggerItemIconLabel, h16, dVar.e(), null, 4, null);
        this.mRightTopLabel.b(data.m(), dVar.g(), ImageView.ScaleType.FIT_END);
        this.mLeftBtmLabel.a(data.getLeftBottomIcon(), data.getLeftBottomTxt());
        this.mRightBtmLabel.c(data.l());
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_tab_id", card.e());
        com.tencent.sqshow.zootopia.card.report.a.d(this.reportHelper, this, card.b(), selfPos, a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, data.getOriginData().f427681b, null, 2, null), card.a(), data.getOriginData(), hashMap, null, null, false, 896, null);
    }
}
