package com.tencent.ecommerce.biz.consumer.view.xinghuan;

import ah0.a;
import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u0001:\u0001GB\u0017\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010A\u001a\u00020>\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J@\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JX\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J8\u0010$\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J8\u0010%\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006H"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanShapedCardView;", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanBaseBigCardView;", "Landroid/animation/Animator$AnimatorListener;", "listener", "", "o", "", "uiType", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "bigBtn", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "clickListener", "Landroid/view/View$OnClickListener;", "closeListener", "f", "i", "smallBgWidth", "smallBgHeight", "smallIconWidth", "smallIconHeight", "", "smallBgLoc", "smallTitleLoc", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mediumBgWidth", "mediumBgHeight", "mediumCoverWidth", "mediumCoverHeight", "mediumBtnWidth", "mediumBtnHeight", "mediumBgLoc", "mediumBtnLoc", "mediumTitleLoc", "l", "k", "j", h.F, "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "bigPicContainer", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanPagView;", "E", "Lcom/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanPagView;", "bigPagContainer", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "bigCloseImageView", "Lah0/a;", "G", "Lah0/a;", "ecAnimationSet", "H", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "bigCardUIInfo", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "I", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "J", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECXingHuanShapedCardView extends ECXingHuanBaseBigCardView {

    /* renamed from: C, reason: from kotlin metadata */
    private final View parentView;

    /* renamed from: D, reason: from kotlin metadata */
    private final ViewGroup bigPicContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private final ECXingHuanPagView bigPagContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView bigCloseImageView;

    /* renamed from: G, reason: from kotlin metadata */
    private a ecAnimationSet;

    /* renamed from: H, reason: from kotlin metadata */
    private UIInfo bigCardUIInfo;

    /* renamed from: I, reason: from kotlin metadata */
    public final ECContentInfo contentInfo;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f101937d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IECGoodsCardView.IGoodsCardClickListener f101938e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ UIInfo f101939f;

        b(int i3, IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener, UIInfo uIInfo) {
            this.f101937d = i3;
            this.f101938e = iGoodsCardClickListener;
            this.f101939f = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            view.setTag(R.id.ntd, 1);
            view.setTag(R.id.nte, Integer.valueOf(this.f101937d));
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = this.f101938e;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, view, ECGoodsCommonUtils.f101579a.o(this.f101939f.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101941e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101942f;

        c(int i3, View.OnClickListener onClickListener) {
            this.f101941e = i3;
            this.f101942f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECXingHuanShapedCardView.this.setTag(R.id.nte, Integer.valueOf(this.f101941e));
            ECXingHuanShapedCardView.this.setTag(R.id.o5t, Integer.valueOf(this.f101941e));
            View.OnClickListener onClickListener = this.f101942f;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECXingHuanShapedCardView(Context context, ECContentInfo eCContentInfo) {
        super(context);
        this.contentInfo = eCContentInfo;
        this.parentView = LayoutInflater.from(context).inflate(R.layout.cvb, (ViewGroup) this, true);
        this.bigPicContainer = (ViewGroup) findViewById(R.id.nqp);
        this.bigPagContainer = (ECXingHuanPagView) findViewById(R.id.nqo);
        this.bigCloseImageView = (ImageView) findViewById(R.id.nqk);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void f(int uiType, UIInfo uiInfo, IECXingHuanGameButton bigBtn, IECGoodsCardView.IGoodsCardClickListener clickListener, View.OnClickListener closeListener) {
        cg0.a.b("ECXingHuanShapedCardView", "configBigCardUI uiType:" + uiType);
        this.bigCardUIInfo = uiInfo;
        this.bigPagContainer.i(uiInfo.getPagUrl(), uiInfo.getPicUrl());
        this.bigPicContainer.setOnClickListener(new b(uiType, clickListener, uiInfo));
        this.bigCloseImageView.setOnClickListener(new c(uiType, closeListener));
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void h() {
        this.parentView.setTranslationX(0.0f);
        this.parentView.setTranslationY(0.0f);
        this.bigPicContainer.setScaleX(1.0f);
        this.bigPicContainer.setScaleY(1.0f);
        this.bigPicContainer.setAlpha(1.0f);
        this.bigPagContainer.m();
        this.bigPicContainer.invalidate();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void i() {
        this.ecAnimationSet = a.C0035a.j(new a.C0035a(700L), this.parentView, -r1.getWidth(), 0.0f, 0.0f, 0.0f, 0L, false, ECXingHuanGameCardView.INSTANCE.b(), new d(), 96, null).c().b();
        g(this.contentInfo.getContentId());
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void l(int mediumBgWidth, int mediumBgHeight, int mediumCoverWidth, int mediumCoverHeight, int mediumBtnWidth, int mediumBtnHeight, int[] mediumBgLoc, int[] mediumBtnLoc, int[] mediumTitleLoc, Animator.AnimatorListener listener) {
        o(listener);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void m(int smallBgWidth, int smallBgHeight, int smallIconWidth, int smallIconHeight, int[] smallBgLoc, int[] smallTitleLoc, Animator.AnimatorListener listener) {
        o(listener);
    }

    private final void o(Animator.AnimatorListener listener) {
        a.C0035a a16;
        a.C0035a c0035a = new a.C0035a(700L);
        ViewGroup viewGroup = this.bigPicContainer;
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        a16 = r19.a(this.bigPicContainer, 0.0f, 1.0f, (r26 & 8) != 0 ? a.C0035a.f(c0035a, viewGroup, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0L, false, companion.a(), null, 0L, 3488, null).duration : 0L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : new e(listener));
        this.ecAnimationSet = a16.c().b();
        g(this.contentInfo.getContentId());
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void j(int mediumBgWidth, int mediumBgHeight, int mediumCoverWidth, int mediumCoverHeight, int[] mediumBgLoc, Animator.AnimatorListener listener) {
        a.C0035a a16;
        int[] iArr = new int[2];
        this.bigPicContainer.getLocationInWindow(iArr);
        a.C0035a c0035a = new a.C0035a(700L);
        View view = this.parentView;
        float f16 = mediumBgLoc[0] - iArr[0];
        float f17 = mediumBgLoc[1] - iArr[1];
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        a16 = r27.a(this.bigPicContainer, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.j(c0035a, view, 0.0f, 0.0f, f16, f17, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a.C0035a.f(a16, this.bigPicContainer, 1.0f, mediumBgWidth / r4.getWidth(), 1.0f, mediumBgHeight / this.bigPicContainer.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null).c().b();
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanBaseBigCardView
    public void k(int smallBgWidth, int smallBgHeight, int smallIconWidth, int smallIconHeight, int[] smallBgLoc, Animator.AnimatorListener listener) {
        a.C0035a a16;
        int[] iArr = new int[2];
        this.bigPicContainer.getLocationInWindow(iArr);
        a.C0035a c0035a = new a.C0035a(700L);
        View view = this.parentView;
        float f16 = smallBgLoc[0] - iArr[0];
        float f17 = smallBgLoc[1] - iArr[1];
        ECXingHuanBaseBigCardView.Companion companion = ECXingHuanBaseBigCardView.INSTANCE;
        a16 = r27.a(this.bigPicContainer, 1.0f, 0.0f, (r26 & 8) != 0 ? a.C0035a.j(c0035a, view, 0.0f, 0.0f, f16, f17, 0L, false, companion.a(), null, g.CTRL_INDEX, null).duration : 500L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : companion.a(), (r26 & 256) != 0 ? null : null);
        this.ecAnimationSet = a.C0035a.f(a16, this.bigPicContainer, 1.0f, smallBgWidth / r4.getWidth(), 1.0f, smallBgHeight / this.bigPicContainer.getHeight(), 0.0f, 0.0f, 0L, false, companion.a(), listener, 0L, 2464, null).c().b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanShapedCardView$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ECXingHuanShapedCardView.this.bigPagContainer.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/xinghuan/ECXingHuanShapedCardView$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Animator.AnimatorListener f101945e;

        e(Animator.AnimatorListener animatorListener) {
            this.f101945e = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f101945e.onAnimationEnd(animation);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ECXingHuanShapedCardView.this.bigPagContainer.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }
}
