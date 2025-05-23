package com.tencent.ecommerce.base.ui.stateview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001\u0004B'\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00109\u001a\u00020\f\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0014R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0014\u0010\"\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0013R\u0014\u0010$\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0014\u0010&\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0014\u0010(\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001dR\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R*\u00104\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006="}, d2 = {"Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/base/list/IStateCenterView;", "", "c", "d", "setSucceededState", "", "loadingTip", "setLoadingState", "description", "token", "", "backgroundColor", "setEmptyState", "errorMsg", "setFailedState", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "Landroid/view/View;", "loadingLayout", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "loadingContentLayout", "f", "loadingIconView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "loadingTipView", "i", "errorLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "emptyLayout", BdhLogUtil.LogTag.Tag_Conn, "errorTipView", "D", "errorRetryView", "E", "emptyTipView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "emptyIconView", "Lkotlin/Function0;", "G", "Lkotlin/jvm/functions/Function0;", "b", "()Lkotlin/jvm/functions/Function0;", "setRetryListener", "(Lkotlin/jvm/functions/Function0;)V", "retryListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECStateCenterView extends FrameLayout implements IStateCenterView {

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView errorTipView;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView errorRetryView;

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView emptyTipView;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView emptyIconView;

    /* renamed from: G, reason: from kotlin metadata */
    private Function0<Unit> retryListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View loadingLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout loadingContentLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View loadingIconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView loadingTipView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final View errorLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View emptyLayout;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final a f101248d = new a();

        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECStateCenterView", "loading view click interrupt.");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function0<Unit> b16 = ECStateCenterView.this.b();
            if (b16 != null) {
                b16.invoke();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECStateCenterView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void d() {
        View view = this.loadingIconView;
        if (view instanceof PAGView) {
            ((PAGView) view).stop();
        } else if (view instanceof ImageView) {
            view.clearAnimation();
        }
    }

    public final Function0<Unit> b() {
        return this.retryListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // com.tencent.ecommerce.base.list.IStateCenterView
    public void setEmptyState(String description, String token, int backgroundColor) {
        c();
        this.emptyLayout.setVisibility(0);
        TextView textView = this.emptyTipView;
        if (description.length() == 0) {
            description = getResources().getString(R.string.wof);
        }
        textView.setText(description);
        int i3 = this.emptyIconView.getLayoutParams().width;
        int i16 = this.emptyIconView.getLayoutParams().height;
        ECSkin.INSTANCE.getDrawable(token, (i3 <= 0 || i16 <= 0) ? null : new IECImageLoader.ImageLoaderOption(i3, i16, 0, null, null, null, false, false, null, 508, null), new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.base.ui.stateview.ECStateCenterView$setEmptyState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable drawable) {
                ImageView imageView;
                ImageView imageView2;
                if (drawable != null) {
                    imageView2 = ECStateCenterView.this.emptyIconView;
                    imageView2.setImageDrawable(drawable);
                } else {
                    imageView = ECStateCenterView.this.emptyIconView;
                    imageView.setVisibility(8);
                }
            }
        });
        if (backgroundColor != 0) {
            this.emptyLayout.setBackgroundColor(backgroundColor);
        }
    }

    @Override // com.tencent.ecommerce.base.list.IStateCenterView
    public void setFailedState(String errorMsg) {
        c();
        this.errorLayout.setVisibility(0);
        TextView textView = this.errorTipView;
        if (errorMsg.length() == 0) {
            errorMsg = getResources().getString(R.string.woa);
        }
        textView.setText(errorMsg);
    }

    @Override // com.tencent.ecommerce.base.list.IStateCenterView
    public void setLoadingState(String loadingTip) {
        c();
        this.loadingLayout.setVisibility(0);
        if (loadingTip.length() > 0) {
            this.loadingTipView.setText(loadingTip);
        }
        View view = this.loadingIconView;
        if (view instanceof PAGView) {
            ((PAGView) view).play();
        } else if (view instanceof ImageView) {
            ECViewUtilKt.c(view);
        }
    }

    public final void setRetryListener(Function0<Unit> function0) {
        this.retryListener = function0;
    }

    @Override // com.tencent.ecommerce.base.list.IStateCenterView
    public void setSucceededState() {
        c();
        setVisibility(8);
    }

    public ECStateCenterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final void c() {
        setVisibility(0);
        this.loadingLayout.setVisibility(8);
        d();
        this.errorLayout.setVisibility(8);
        this.emptyLayout.setVisibility(8);
    }

    public /* synthetic */ ECStateCenterView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECStateCenterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ImageView imageView;
        LayoutInflater.from(getContext()).inflate(R.layout.cpq, this);
        View findViewById = findViewById(R.id.nw9);
        this.loadingLayout = findViewById;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.o3l);
        this.loadingContentLayout = linearLayout;
        this.loadingTipView = (TextView) findViewById(R.id.o3m);
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSo()) {
            PAGView pAGView = new PAGView(context);
            pAGView.setPath("assets://pag/ecommerce_skin_loading_img_sangedian.pag");
            pAGView.setRepeatCount(-1);
            Unit unit = Unit.INSTANCE;
            imageView = pAGView;
        } else {
            ImageView imageView2 = new ImageView(context);
            imageView2.setBackgroundResource(R.drawable.di9);
            Unit unit2 = Unit.INSTANCE;
            imageView = imageView2;
        }
        this.loadingIconView = imageView;
        linearLayout.addView(imageView, 0, new LinearLayout.LayoutParams(e.c(25.0f), e.c(25.0f)));
        findViewById.setOnClickListener(a.f101248d);
        this.emptyLayout = findViewById(R.id.nw7);
        this.errorLayout = findViewById(R.id.nw8);
        this.errorTipView = (TextView) findViewById(R.id.nyb);
        TextView textView = (TextView) findViewById(R.id.f163072o52);
        this.errorRetryView = textView;
        textView.setOnClickListener(new b());
        this.emptyTipView = (TextView) findViewById(R.id.f163031ny1);
        this.emptyIconView = (ImageView) findViewById(R.id.f163030ny0);
    }
}
