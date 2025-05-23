package com.tencent.ecommerce.biz.live.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.live.HotLabel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveLabelView;", "Landroid/widget/LinearLayout;", "", "prefix", "", "setPrefix", "content", "setContent", "Lcom/tencent/ecommerce/repo/live/HotLabel;", "data", "c", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "labelPrefix", "Landroid/view/View;", "e", "Landroid/view/View;", "divider", "f", "labelContent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveLabelView extends LinearLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f102682h;

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f102683i;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView labelPrefix;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View divider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView labelContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveLabelView$a;", "", "", "PADDING$delegate", "Lkotlin/Lazy;", "b", "()I", "PADDING", "HEIGHT$delegate", "a", "HEIGHT", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.ui.ECLiveLabelView$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return ((Number) ECLiveLabelView.f102683i.getValue()).intValue();
        }

        public final int b() {
            return ((Number) ECLiveLabelView.f102682h.getValue()).intValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveLabelView$Companion$PADDING$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(4.0f);
            }
        });
        f102682h = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.live.ui.ECLiveLabelView$Companion$HEIGHT$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return e.c(16.0f);
            }
        });
        f102683i = lazy2;
    }

    public ECLiveLabelView(Context context) {
        this(context, null, 0, 6, null);
    }

    public final void c(HotLabel data) {
        boolean isBlank;
        boolean isBlank2;
        String textPrefix = data.getTextPrefix();
        if (textPrefix != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(textPrefix);
            if (!isBlank2) {
                String textPrefix2 = data.getTextPrefix();
                Intrinsics.checkNotNull(textPrefix2);
                setPrefix(textPrefix2);
            }
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(data.getText());
        if (!isBlank) {
            setContent(data.getText());
        }
    }

    public final void setContent(String content) {
        this.labelContent.setText(content);
    }

    public final void setPrefix(String prefix) {
        this.labelPrefix.setText(prefix);
        this.labelPrefix.setVisibility(0);
        this.divider.setVisibility(0);
    }

    public ECLiveLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ECLiveLabelView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public ECLiveLabelView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(getContext()).inflate(R.layout.crs, this);
        this.labelPrefix = (TextView) findViewById(R.id.o2d);
        this.divider = findViewById(R.id.nvn);
        this.labelContent = (TextView) findViewById(R.id.o2c);
        Companion companion = INSTANCE;
        setPadding(companion.b(), 0, companion.b(), 0);
        setBackground(getContext().getDrawable(R.drawable.f159721bx2));
    }
}
