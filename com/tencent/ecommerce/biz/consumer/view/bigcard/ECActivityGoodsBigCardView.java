package com.tencent.ecommerce.biz.consumer.view.bigcard;

import ah0.a;
import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.consumer.resp.ButtonInfo;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0017\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010:\u001a\u000207\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u0002J\"\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0005R\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0014\u0010&\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010(\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u0014\u0010*\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u0014\u0010,\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010.\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\"R\u0014\u00100\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\"R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u0010:\u001a\u0002078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006A"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/bigcard/ECActivityGoodsBigCardView;", "Landroid/widget/FrameLayout;", "", "g", "Lah0/a$a;", "Landroid/view/View;", "view", "d", "c", "", "uiType", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "clickListener", "Landroid/view/View$OnClickListener;", "closeListener", "e", "k", "f", "smallCardLayout", "onCloseAnimStartListener", "onCloseAnimEndListener", h.F, "j", "mediumCardLayout", "i", "Landroid/view/View;", "root", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "backgroundView", "cover", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "title", "countDownText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "promotionText", BdhLogUtil.LogTag.Tag_Conn, "closeBtn", "D", "actionBtn", "E", "actionBtnText", UserInfo.SEX_FEMALE, "actionBtnPriceText", "G", "actionBtnOriginPriceText", "Lah0/a;", "H", "Lah0/a;", "smallToBigAnim", "I", "mediumToBigAnim", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "J", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "K", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECActivityGoodsBigCardView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView closeBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private final View actionBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView actionBtnText;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView actionBtnPriceText;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView actionBtnOriginPriceText;

    /* renamed from: H, reason: from kotlin metadata */
    private a smallToBigAnim;

    /* renamed from: I, reason: from kotlin metadata */
    private a mediumToBigAnim;

    /* renamed from: J, reason: from kotlin metadata */
    public final ECContentInfo contentInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View root;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView backgroundView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView cover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView countDownText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView promotionText;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IECGoodsCardView.IGoodsCardClickListener f101814e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ UIInfo f101815f;

        b(IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener, UIInfo uIInfo) {
            this.f101814e = iGoodsCardClickListener;
            this.f101815f = uIInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IECGoodsCardView.IGoodsCardClickListener iGoodsCardClickListener = this.f101814e;
            if (iGoodsCardClickListener != null) {
                IECGoodsCardView.IGoodsCardClickListener.a.a(iGoodsCardClickListener, ECActivityGoodsBigCardView.this, ECGoodsCommonUtils.f101579a.o(this.f101815f.getJumpInfoArray()), null, 4, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101816d;

        c(View.OnClickListener onClickListener) {
            this.f101816d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View.OnClickListener onClickListener = this.f101816d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECActivityGoodsBigCardView(Context context, ECContentInfo eCContentInfo) {
        super(context);
        this.contentInfo = eCContentInfo;
        View inflate = LayoutInflater.from(context).inflate(R.layout.cri, (ViewGroup) this, true);
        this.root = inflate;
        this.backgroundView = (ImageView) inflate.findViewById(R.id.f163044o04);
        this.cover = (ImageView) inflate.findViewById(R.id.o0_);
        this.title = (TextView) inflate.findViewById(R.id.o0b);
        this.countDownText = (TextView) inflate.findViewById(R.id.o09);
        this.promotionText = (TextView) inflate.findViewById(R.id.o0a);
        this.closeBtn = (ImageView) inflate.findViewById(R.id.o08);
        this.actionBtn = inflate.findViewById(R.id.f163043o03);
        this.actionBtnText = (TextView) inflate.findViewById(R.id.o07);
        this.actionBtnPriceText = (TextView) inflate.findViewById(R.id.o06);
        TextView textView = (TextView) inflate.findViewById(R.id.f163045o05);
        this.actionBtnOriginPriceText = textView;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        a.Companion companion = a.INSTANCE;
        companion.a(this.backgroundView);
        companion.a(this.cover);
        companion.a(this.title);
        companion.a(this.countDownText);
        companion.a(this.promotionText);
        companion.a(this.closeBtn);
        companion.a(this.actionBtn);
    }

    public final void f() {
        a aVar = this.smallToBigAnim;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.mediumToBigAnim;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public final void k(UIInfo uiInfo) {
        if (uiInfo.getActivityStartTime().length() > 0) {
            if (uiInfo.getActivityEndTime().length() > 0) {
                long serverTimeMillis = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis() / 1000;
                if (serverTimeMillis >= Long.parseLong(uiInfo.getActivityEndTime())) {
                    this.countDownText.setVisibility(8);
                    this.actionBtnText.setText("\u7acb\u5373\u8d2d\u4e70");
                    this.actionBtnPriceText.setText("");
                    this.actionBtnOriginPriceText.setText("");
                    return;
                }
                this.countDownText.setVisibility(0);
                String c16 = ECGoodsCommonUtils.f101579a.c(serverTimeMillis, Long.parseLong(uiInfo.getActivityEndTime()));
                this.countDownText.setText("\u5269\u4f59 " + c16);
                TextView textView = this.actionBtnText;
                ButtonInfo buttonInfo = uiInfo.getButtonInfo();
                textView.setText(buttonInfo != null ? buttonInfo.getButtonText() : null);
                this.actionBtnPriceText.setText(uiInfo.getPrice());
                this.actionBtnOriginPriceText.setText(uiInfo.getOriginPrice());
                return;
            }
        }
        this.countDownText.setVisibility(8);
        this.actionBtnText.setText("\u7acb\u5373\u8d2d\u4e70");
        this.actionBtnPriceText.setText("");
        this.actionBtnOriginPriceText.setText("");
    }

    public final void e(int uiType, UIInfo uiInfo, IECGoodsCardView.IGoodsCardClickListener clickListener, View.OnClickListener closeListener) {
        String buttonText;
        int b16;
        cg0.a.b("ECActivityGoodsBigCardView", "onConfigUI uiType:" + uiType);
        if (uiType == 10302) {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().load(getContext(), uiInfo.getPicUrl(), this.cover, new IECImageLoader.ImageLoaderOption(this.cover.getLayoutParams().width, this.cover.getLayoutParams().height, 0, null, null, null, false, false, null, 508, null));
            this.title.setText(uiInfo.getTitle());
            if (uiInfo.getSubtitle().length() > 0) {
                this.promotionText.setVisibility(0);
                this.promotionText.setText(uiInfo.getSubtitle());
            } else {
                this.promotionText.setVisibility(8);
            }
            ButtonInfo buttonInfo = uiInfo.getButtonInfo();
            if (buttonInfo != null && (buttonText = buttonInfo.getButtonText()) != null) {
                if (buttonText.length() > 0) {
                    this.actionBtn.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = this.actionBtn.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        layoutParams = null;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (marginLayoutParams != null) {
                        if (this.promotionText.getVisibility() == 0) {
                            b16 = e.b(173.0f, null, 1, null);
                        } else {
                            b16 = e.b(150.0f, null, 1, null);
                        }
                        marginLayoutParams.topMargin = b16;
                    }
                    k(uiInfo);
                    this.root.setOnClickListener(new b(clickListener, uiInfo));
                    this.closeBtn.setTag(R.id.nte, 10302);
                    this.closeBtn.setTag(R.id.o5t, 10302);
                    this.closeBtn.setOnClickListener(new c(closeListener));
                }
            }
            this.actionBtn.setVisibility(8);
            k(uiInfo);
            this.root.setOnClickListener(new b(clickListener, uiInfo));
            this.closeBtn.setTag(R.id.nte, 10302);
            this.closeBtn.setTag(R.id.o5t, 10302);
            this.closeBtn.setOnClickListener(new c(closeListener));
        }
    }

    public final void h(View smallCardLayout, View.OnClickListener onCloseAnimStartListener, View.OnClickListener onCloseAnimEndListener) {
        a.C0035a g16;
        a.C0035a g17;
        a.C0035a g18;
        View findViewById = smallCardLayout.findViewById(R.id.oas);
        View findViewById2 = smallCardLayout.findViewById(R.id.oak);
        a.C0035a c0035a = new a.C0035a(400L);
        ImageView imageView = this.backgroundView;
        ECVideoFeedsGoodsCardView.Companion companion = ECVideoFeedsGoodsCardView.INSTANCE;
        a.C0035a k3 = c0035a.k(imageView, imageView, smallCardLayout, companion.b());
        ImageView imageView2 = this.backgroundView;
        g16 = k3.g(imageView2, imageView2, smallCardLayout, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        TextView textView = this.title;
        a.C0035a k16 = g16.k(textView, textView, findViewById, companion.b());
        TextView textView2 = this.title;
        g17 = k16.g(textView2, textView2, findViewById, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        ImageView imageView3 = this.cover;
        a.C0035a k17 = g17.k(imageView3, imageView3, findViewById2, companion.b());
        ImageView imageView4 = this.cover;
        g18 = k17.g(imageView4, imageView4, findViewById2, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        a c16 = c(c(c(c(g18, this.closeBtn), this.countDownText), this.actionBtn), this.promotionText).d(new d(onCloseAnimStartListener, onCloseAnimEndListener)).c();
        c16.b();
        Unit unit = Unit.INSTANCE;
        this.smallToBigAnim = c16;
    }

    public final void i(View mediumCardLayout) {
        a.C0035a g16;
        a.C0035a g17;
        a.C0035a g18;
        View findViewById = mediumCardLayout.findViewById(R.id.o4v);
        View findViewById2 = mediumCardLayout.findViewById(R.id.o4_);
        View findViewById3 = mediumCardLayout.findViewById(R.id.o4l);
        View findViewById4 = mediumCardLayout.findViewById(R.id.o4f);
        View findViewById5 = mediumCardLayout.findViewById(R.id.o4c);
        a.C0035a c0035a = new a.C0035a(400L);
        ImageView imageView = this.backgroundView;
        ECVideoFeedsGoodsCardView.Companion companion = ECVideoFeedsGoodsCardView.INSTANCE;
        a.C0035a k3 = c0035a.k(imageView, mediumCardLayout, imageView, companion.b());
        ImageView imageView2 = this.backgroundView;
        g16 = k3.g(imageView2, mediumCardLayout, imageView2, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        TextView textView = this.title;
        a.C0035a k16 = g16.k(textView, findViewById, textView, companion.b());
        TextView textView2 = this.title;
        g17 = k16.g(textView2, findViewById, textView2, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        if (findViewById2.getVisibility() == 0) {
            TextView textView3 = this.promotionText;
            g17.k(textView3, findViewById2, textView3, companion.b());
        } else {
            d(g17, this.promotionText);
        }
        Unit unit = Unit.INSTANCE;
        ImageView imageView3 = this.cover;
        a.C0035a k17 = g17.k(imageView3, findViewById3, imageView3, companion.b());
        ImageView imageView4 = this.cover;
        g18 = k17.g(imageView4, findViewById3, imageView4, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        if (findViewById4.getVisibility() == 0) {
            View view = this.actionBtn;
            g18.k(view, findViewById4, view, companion.b());
            View view2 = this.actionBtn;
            g18.g(view2, findViewById4, view2, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        } else {
            d(g18, this.actionBtn);
        }
        if (findViewById5.getVisibility() == 0) {
            TextView textView4 = this.countDownText;
            g18.k(textView4, findViewById5, textView4, companion.b());
        } else {
            d(g18, this.countDownText);
        }
        a c16 = d(d(d(g18, this.closeBtn), this.countDownText), this.actionBtn).c();
        c16.b();
        this.mediumToBigAnim = c16;
    }

    public final void j(View smallCardLayout) {
        a.C0035a g16;
        a.C0035a g17;
        a.C0035a g18;
        View findViewById = smallCardLayout.findViewById(R.id.oas);
        View findViewById2 = smallCardLayout.findViewById(R.id.oak);
        a.C0035a c0035a = new a.C0035a(400L);
        ImageView imageView = this.backgroundView;
        ECVideoFeedsGoodsCardView.Companion companion = ECVideoFeedsGoodsCardView.INSTANCE;
        a.C0035a k3 = c0035a.k(imageView, smallCardLayout, imageView, companion.b());
        ImageView imageView2 = this.backgroundView;
        g16 = k3.g(imageView2, smallCardLayout, imageView2, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        TextView textView = this.title;
        a.C0035a k16 = g16.k(textView, findViewById, textView, companion.b());
        TextView textView2 = this.title;
        g17 = k16.g(textView2, findViewById, textView2, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        ImageView imageView3 = this.cover;
        a.C0035a k17 = g17.k(imageView3, findViewById2, imageView3, companion.b());
        ImageView imageView4 = this.cover;
        g18 = k17.g(imageView4, findViewById2, imageView4, (r16 & 8) != 0 ? 0.0f : 0.0f, (r16 & 16) != 0 ? 0.0f : 0.0f, (r16 & 32) != 0 ? null : companion.a());
        a c16 = d(d(d(g18, this.closeBtn), this.countDownText), this.actionBtn).c();
        c16.b();
        Unit unit = Unit.INSTANCE;
        this.smallToBigAnim = c16;
    }

    private final a.C0035a c(a.C0035a c0035a, View view) {
        a.C0035a a16;
        a16 = c0035a.a(view, 1.0f, 0.0f, (r26 & 8) != 0 ? c0035a.duration : 200L, (r26 & 16) != 0 ? 0L : 0L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
        return a16;
    }

    private final a.C0035a d(a.C0035a c0035a, View view) {
        a.C0035a a16;
        a16 = c0035a.a(view, 0.0f, 1.0f, (r26 & 8) != 0 ? c0035a.duration : 200L, (r26 & 16) != 0 ? 0L : 200L, (r26 & 32) != 0, (r26 & 64) != 0, (r26 & 128) != 0 ? null : null, (r26 & 256) != 0 ? null : null);
        return a16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/consumer/view/bigcard/ECActivityGoodsBigCardView$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101818e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f101819f;

        d(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            this.f101818e = onClickListener;
            this.f101819f = onClickListener2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            View.OnClickListener onClickListener = this.f101819f;
            if (onClickListener != null) {
                onClickListener.onClick(ECActivityGoodsBigCardView.this.closeBtn);
            }
            ECActivityGoodsBigCardView.this.g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            View.OnClickListener onClickListener = this.f101819f;
            if (onClickListener != null) {
                onClickListener.onClick(ECActivityGoodsBigCardView.this.closeBtn);
            }
            ECActivityGoodsBigCardView.this.g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            View.OnClickListener onClickListener = this.f101818e;
            if (onClickListener != null) {
                onClickListener.onClick(ECActivityGoodsBigCardView.this.closeBtn);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }
}
