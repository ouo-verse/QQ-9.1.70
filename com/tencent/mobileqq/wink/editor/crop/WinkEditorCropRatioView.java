package com.tencent.mobileqq.wink.editor.crop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003456B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b-\u00101B#\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\u000b\u00a2\u0006\u0004\b-\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0002J0\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0004R8\u0010!\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u001eR\u00020\u00000\u001dj\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060\u001eR\u00020\u0000`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010 R,\u0010%\u001a\u001a\u0012\b\u0012\u00060\u001eR\u00020\u00000\"j\f\u0012\b\u0012\u00060\u001eR\u00020\u0000`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010&R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView;", "Landroid/widget/FrameLayout;", "", "f", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "newType", "", "opposite", "needResize", tl.h.F, "changed", "", "left", "top", "right", "bottom", "onLayout", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$a;", "listener", "setListener", "type", "setDefaultRatioType", "setSelectedStatus", "d", "e", "j", "currentType", "", "c", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioView;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "ratioTypeViewMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "ratioTypeViews", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "defaultRatioType", "selectRatioType", "i", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "RatioType", "RatioView", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorCropRatioView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<RatioType, RatioView> ratioTypeViewMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RatioView> ratioTypeViews;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RatioType defaultRatioType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RatioType selectRatioType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a listener;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319770m;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "", "(Ljava/lang/String;I)V", "getDTReportString", "", "getOppositeRatioType", "Origin", "FreeRatio", "Ratio9to16", "Ratio3to4", "Ratio1to1", "Ratio4to3", "Ratio16to9", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum RatioType {
        Origin,
        FreeRatio,
        Ratio9to16,
        Ratio3to4,
        Ratio1to1,
        Ratio4to3,
        Ratio16to9;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f319771a;

            static {
                int[] iArr = new int[RatioType.values().length];
                try {
                    iArr[RatioType.Origin.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RatioType.FreeRatio.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RatioType.Ratio9to16.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RatioType.Ratio3to4.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RatioType.Ratio1to1.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[RatioType.Ratio4to3.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[RatioType.Ratio16to9.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f319771a = iArr;
            }
        }

        @NotNull
        public final String getDTReportString() {
            switch (a.f319771a[ordinal()]) {
                case 1:
                    return "original";
                case 2:
                    return "free";
                case 3:
                    return "9to16";
                case 4:
                    return "3to4";
                case 5:
                    return "1to1";
                case 6:
                    return "4to3";
                case 7:
                    return "16to9";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        @NotNull
        public final RatioType getOppositeRatioType() {
            switch (a.f319771a[ordinal()]) {
                case 1:
                    return Origin;
                case 2:
                    return FreeRatio;
                case 3:
                    return Ratio16to9;
                case 4:
                    return Ratio4to3;
                case 5:
                    return Ratio1to1;
                case 6:
                    return Ratio3to4;
                case 7:
                    return Ratio9to16;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001c\u0010 B#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010!\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0015\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioView;", "Landroid/widget/FrameLayout;", "", "e", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "type", "", "isSelected", "", "a", "d", "g", "Landroid/widget/ImageView;", "Lkotlin/Lazy;", "b", "()Landroid/widget/ImageView;", "ratioImageView", "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "ratioTextView", "f", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "getType", "()Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;)V", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView;Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class RatioView extends FrameLayout {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy ratioImageView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy ratioTextView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private RatioType type;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        public Map<Integer, View> f319775h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ WinkEditorCropRatioView f319776i;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f319777a;

            static {
                int[] iArr = new int[RatioType.values().length];
                try {
                    iArr[RatioType.FreeRatio.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RatioType.Ratio9to16.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RatioType.Ratio3to4.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RatioType.Ratio1to1.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RatioType.Ratio4to3.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[RatioType.Ratio16to9.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f319777a = iArr;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RatioView(@NotNull WinkEditorCropRatioView winkEditorCropRatioView, Context context) {
            this(winkEditorCropRatioView, context, null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        private final int a(RatioType type, boolean isSelected) {
            if (isSelected) {
                switch (a.f319777a[type.ordinal()]) {
                    case 1:
                        return R.drawable.oe_;
                    case 2:
                        return R.drawable.oe8;
                    case 3:
                        return R.drawable.f162681oe4;
                    case 4:
                        return R.drawable.f162679oe2;
                    case 5:
                        return R.drawable.oe6;
                    case 6:
                        return R.drawable.f162677oe0;
                    default:
                        return R.drawable.oeb;
                }
            }
            switch (a.f319777a[type.ordinal()]) {
                case 1:
                    return R.drawable.oe9;
                case 2:
                    return R.drawable.oe7;
                case 3:
                    return R.drawable.f162680oe3;
                case 4:
                    return R.drawable.f162678oe1;
                case 5:
                    return R.drawable.oe5;
                case 6:
                    return R.drawable.odz;
                default:
                    return R.drawable.oea;
            }
        }

        private final ImageView b() {
            Object value = this.ratioImageView.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-ratioImageView>(...)");
            return (ImageView) value;
        }

        private final TextView c() {
            Object value = this.ratioTextView.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-ratioTextView>(...)");
            return (TextView) value;
        }

        private final int d(RatioType type) {
            switch (a.f319777a[type.ordinal()]) {
                case 1:
                    return R.string.f239267m0;
                case 2:
                    return R.string.f239257lz;
                case 3:
                    return R.string.f239237lx;
                case 4:
                    return R.string.f239227lw;
                case 5:
                    return R.string.f239247ly;
                case 6:
                    return R.string.f239217lv;
                default:
                    return R.string.f239277m1;
            }
        }

        private final void e() {
            LayoutInflater.from(getContext()).inflate(R.layout.i5a, (ViewGroup) this, true);
            g();
        }

        public final void f(@NotNull RatioType ratioType) {
            Intrinsics.checkNotNullParameter(ratioType, "<set-?>");
            this.type = ratioType;
        }

        public final void g() {
            boolean z16;
            ImageView b16 = b();
            RatioType ratioType = this.type;
            if (this.f319776i.selectRatioType == this.type) {
                z16 = true;
            } else {
                z16 = false;
            }
            b16.setImageResource(a(ratioType, z16));
            c().setText(d(this.type));
            if (this.f319776i.selectRatioType == this.type) {
                c().setTextColor(ContextCompat.getColor(getContext(), R.color.bdu));
            } else {
                c().setTextColor(-1);
            }
            postInvalidate();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RatioView(@NotNull WinkEditorCropRatioView winkEditorCropRatioView, @Nullable Context context, AttributeSet attributeSet) {
            this(winkEditorCropRatioView, context, attributeSet, 0);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RatioView(@NotNull WinkEditorCropRatioView winkEditorCropRatioView, @Nullable Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            Lazy lazy;
            Lazy lazy2;
            Intrinsics.checkNotNullParameter(context, "context");
            this.f319776i = winkEditorCropRatioView;
            this.f319775h = new LinkedHashMap();
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView$RatioView$ratioImageView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    return (ImageView) WinkEditorCropRatioView.RatioView.this.findViewById(R.id.f122607ee);
                }
            });
            this.ratioImageView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.editor.crop.WinkEditorCropRatioView$RatioView$ratioTextView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) WinkEditorCropRatioView.RatioView.this.findViewById(R.id.f122617ef);
                }
            });
            this.ratioTextView = lazy2;
            this.type = RatioType.FreeRatio;
            e();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$a;", "", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropRatioView$RatioType;", "type", "", "opposite", "needResize", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NotNull RatioType type, boolean opposite, boolean needResize);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropRatioView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f() {
        for (final RatioType ratioType : RatioType.values()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            RatioView ratioView = new RatioView(this, context);
            ratioView.f(ratioType);
            VideoReport.setElementId(ratioView, WinkDaTongReportConstant.ElementId.EM_XSJ_VIDEO_SIZE_BUTTON);
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_SIZE_BUTTON, ratioType.getDTReportString());
            VideoReport.setElementParams(ratioView, buildElementParams);
            ratioView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.crop.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorCropRatioView.g(WinkEditorCropRatioView.this, ratioType, view);
                }
            });
            ratioView.g();
            addView(ratioView);
            this.ratioTypeViews.add(ratioView);
            this.ratioTypeViewMap.put(ratioType, ratioView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WinkEditorCropRatioView this$0, RatioType type, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        i(this$0, type, false, true, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h(RatioType newType, boolean opposite, boolean needResize) {
        if (!opposite && newType == this.selectRatioType) {
            return;
        }
        RatioView ratioView = this.ratioTypeViewMap.get(this.selectRatioType);
        RatioView ratioView2 = this.ratioTypeViewMap.get(newType);
        this.selectRatioType = newType;
        a aVar = this.listener;
        if (aVar != null) {
            aVar.a(newType, opposite, needResize);
        }
        if (ratioView != null) {
            ratioView.g();
        }
        if (ratioView2 != null) {
            ratioView2.g();
        }
    }

    static /* synthetic */ void i(WinkEditorCropRatioView winkEditorCropRatioView, RatioType ratioType, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        winkEditorCropRatioView.h(ratioType, z16, z17);
    }

    @NotNull
    public final String c(@NotNull RatioType currentType) {
        Intrinsics.checkNotNullParameter(currentType, "currentType");
        return currentType.getDTReportString();
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RatioType getDefaultRatioType() {
        return this.defaultRatioType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final RatioType getSelectRatioType() {
        return this.selectRatioType;
    }

    public final void j() {
        i(this, this.defaultRatioType, false, false, 6, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int paddingRight = (((right - getPaddingRight()) - getPaddingLeft()) - left) / getChildCount();
        int paddingLeft = left + getPaddingLeft();
        int i3 = bottom - top;
        Iterator<T> it = this.ratioTypeViews.iterator();
        while (it.hasNext()) {
            int i16 = paddingLeft + paddingRight;
            ((RatioView) it.next()).layout(paddingLeft, 0, i16, i3);
            paddingLeft = i16;
        }
    }

    public final void setDefaultRatioType(@NotNull RatioType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.defaultRatioType = type;
    }

    public final void setListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setSelectedStatus(@NotNull RatioType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        RatioView ratioView = this.ratioTypeViewMap.get(this.selectRatioType);
        RatioView ratioView2 = this.ratioTypeViewMap.get(type);
        this.selectRatioType = type;
        if (ratioView != null) {
            ratioView.g();
        }
        if (ratioView2 != null) {
            ratioView2.g();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropRatioView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorCropRatioView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f319770m = new LinkedHashMap();
        this.ratioTypeViewMap = new HashMap<>();
        this.ratioTypeViews = new ArrayList<>();
        RatioType ratioType = RatioType.FreeRatio;
        this.defaultRatioType = ratioType;
        this.selectRatioType = ratioType;
        f();
    }
}
