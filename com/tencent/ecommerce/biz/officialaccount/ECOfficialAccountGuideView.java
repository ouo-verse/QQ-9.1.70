package com.tencent.ecommerce.biz.officialaccount;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.submitsucceed.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0007\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u001c\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/officialaccount/ECOfficialAccountGuideView;", "Landroid/widget/LinearLayout;", "", "f", "g", h.F, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "brandView", "e", "officialAccountHintView", "selectIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "selectText", "i", "cancelText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "confirmText", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setOnCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onCancelClickListener", "D", "setOnConfirmFollowListener", "onConfirmFollowListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOfficialAccountGuideView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private Function0<Unit> onCancelClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private Function0<Unit> onConfirmFollowListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView brandView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView officialAccountHintView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView selectIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView selectText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView cancelText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView confirmText;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/officialaccount/ECOfficialAccountGuideView$initViews$3$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECOfficialAccountGuideView.this.g();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/officialaccount/ECOfficialAccountGuideView$initViews$4$beforeSwitchCheckSpan$1", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ECOfficialAccountGuideView.this.g();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            super.updateDrawState(ds5);
            ds5.setColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/officialaccount/ECOfficialAccountGuideView$initViews$4$afterSwitchCheckSpan$1", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends ClickableSpan {
        d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ECOfficialAccountGuideView.this.g();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            super.updateDrawState(ds5);
            ds5.setColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
            ds5.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/officialaccount/ECOfficialAccountGuideView$initViews$5$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.f104808a.a(ECOfficialAccountGuideView.a(ECOfficialAccountGuideView.this).isSelected());
            Function0<Unit> d16 = ECOfficialAccountGuideView.this.d();
            if (d16 != null) {
                d16.invoke();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/officialaccount/ECOfficialAccountGuideView$initViews$6$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.f104808a.c(ECOfficialAccountGuideView.a(ECOfficialAccountGuideView.this).isSelected());
            ECOfficialAccountGuideView.this.h();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/officialaccount/ECOfficialAccountGuideView$g", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "p0", "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g extends ClickableSpan {
        g() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View p06) {
            pg0.a.f426137b.a();
            cg0.a.b("ECOfficialAccountGuideView", "open official Account page");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            super.updateDrawState(ds5);
            ds5.setColor(ECSkin.INSTANCE.getColor(R.color.f6932w));
            ds5.setUnderlineText(false);
        }
    }

    public ECOfficialAccountGuideView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.csc, (ViewGroup) this, true);
        f();
    }

    public static final /* synthetic */ ImageView a(ECOfficialAccountGuideView eCOfficialAccountGuideView) {
        ImageView imageView = eCOfficialAccountGuideView.selectIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectIcon");
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ImageView imageView = this.selectIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectIcon");
        }
        boolean z16 = !imageView.isSelected();
        ImageView imageView2 = this.selectIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectIcon");
        }
        imageView2.setSelected(z16);
        a.f104808a.b(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        ImageView imageView = this.selectIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectIcon");
        }
        if (imageView.isSelected()) {
            Function0<Unit> function0 = this.onConfirmFollowListener;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        ImageView imageView2 = this.selectIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectIcon");
        }
        imageView2.setSelected(true);
        final com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(getContext());
        gVar.setTitle(getContext().getString(R.string.wi_));
        gVar.Y(getContext().getString(R.string.wia, getContext().getString(R.string.wor)));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.officialaccount.ECOfficialAccountGuideView$tryFollowOfficialAccount$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
                ECOfficialAccountGuideView.a(this).setSelected(false);
                a.f104808a.d();
            }
        });
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.officialaccount.ECOfficialAccountGuideView$tryFollowOfficialAccount$$inlined$also$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
                Function0<Unit> e16 = this.e();
                if (e16 != null) {
                    e16.invoke();
                }
                a.f104808a.e();
            }
        });
        gVar.show();
        a.f104808a.f();
    }

    public final Function0<Unit> d() {
        return this.onCancelClickListener;
    }

    public final Function0<Unit> e() {
        return this.onConfirmFollowListener;
    }

    public final void setOnCancelClickListener(Function0<Unit> function0) {
        this.onCancelClickListener = function0;
    }

    public final void setOnConfirmFollowListener(Function0<Unit> function0) {
        this.onConfirmFollowListener = function0;
    }

    private final void f() {
        this.brandView = (ImageView) findViewById(R.id.o1_);
        ECSkin eCSkin = ECSkin.INSTANCE;
        String url = eCSkin.getUrl("qecommerce_skin_ic_fuwu_logo");
        if (url != null) {
            ImageView imageView = this.brandView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("brandView");
            }
            ImageViewKt.b(imageView, url, com.tencent.ecommerce.biz.util.e.c(26.0f), com.tencent.ecommerce.biz.util.e.c(26.0f), 0, 8, null);
        }
        this.officialAccountHintView = (ImageView) findViewById(R.id.o1n);
        String url2 = eCSkin.getUrl("qecommerce_skin_img_fuwu_toast");
        if (url2 != null) {
            ImageView imageView2 = this.officialAccountHintView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("officialAccountHintView");
            }
            ImageViewKt.b(imageView2, url2, com.tencent.ecommerce.biz.util.e.c(343.0f), com.tencent.ecommerce.biz.util.e.c(180.0f), 0, 8, null);
        }
        ImageView imageView3 = (ImageView) findViewById(R.id.nt7);
        imageView3.setOnClickListener(new b());
        Unit unit = Unit.INSTANCE;
        this.selectIcon = imageView3;
        TextView textView = (TextView) findViewById(R.id.oe9);
        String string = getContext().getString(R.string.wor);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(R.string.wop, string));
        int length = string.length() + 4;
        spannableStringBuilder.setSpan(new g(), 2, length, 33);
        spannableStringBuilder.setSpan(new c(), 0, 2, 33);
        spannableStringBuilder.setSpan(new d(), length, spannableStringBuilder.length(), 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
        this.selectText = textView;
        TextView textView2 = (TextView) findViewById(R.id.od7);
        textView2.setOnClickListener(new e());
        this.cancelText = textView2;
        TextView textView3 = (TextView) findViewById(R.id.o1f);
        textView3.setOnClickListener(new f());
        this.confirmText = textView3;
    }
}
