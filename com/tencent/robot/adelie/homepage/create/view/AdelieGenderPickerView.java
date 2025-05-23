package com.tencent.robot.adelie.homepage.create.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u00a2\u0006\u0004\b'\u0010(J \u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J3\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\rJ1\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\rJ\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieGenderPickerView;", "Landroid/widget/RelativeLayout;", "Landroid/widget/LinearLayout;", "selectedLayout", "", "layouts", "", "l", "Landroid/graphics/drawable/Drawable;", "d", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/BotGender;", "gender", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onClickListener", "Landroid/view/View;", "f", tl.h.F, "", NodeProps.ENABLED, "setEnabled", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "Landroid/view/View;", "contentView", "Landroid/widget/LinearLayout;", "maleLayout", "femaleLayout", "unknownLayout", "i", "Ljava/util/List;", "Lcom/tencent/qqnt/kernel/nativeinterface/BotGender;", "currentGender", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieGenderPickerView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout maleLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout femaleLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout unknownLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends LinearLayout> layouts;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BotGender currentGender;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366195a;

        static {
            int[] iArr = new int[BotGender.values().length];
            try {
                iArr[BotGender.KMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BotGender.KFEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BotGender.KOTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BotGender.KDEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f366195a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieGenderPickerView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(CommonExKt.l(getContext().getColor(R.color.qui_common_fill_light_primary), 0.5f));
        gradientDrawable.setCornerRadius(c24.a.a(4));
        return gradientDrawable;
    }

    private final Drawable e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(CommonExKt.l(getContext().getColor(R.color.qui_common_fill_light_primary), 0.5f));
        gradientDrawable.setCornerRadius(c24.a.a(4));
        gradientDrawable.setStroke(c24.a.a(1), getContext().getColor(R.color.qui_common_brand_standard));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 onClickListener, AdelieGenderPickerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BotGender botGender = BotGender.KMALE;
        onClickListener.invoke(botGender);
        this$0.m(botGender);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 onClickListener, AdelieGenderPickerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BotGender botGender = BotGender.KFEMALE;
        onClickListener.invoke(botGender);
        this$0.m(botGender);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 onClickListener, AdelieGenderPickerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BotGender botGender = BotGender.KOTHER;
        onClickListener.invoke(botGender);
        this$0.m(botGender);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l(LinearLayout selectedLayout, List<? extends LinearLayout> layouts) {
        for (LinearLayout linearLayout : layouts) {
            if (Intrinsics.areEqual(linearLayout, selectedLayout)) {
                linearLayout.setBackground(e());
            } else {
                linearLayout.setBackground(d());
            }
        }
    }

    @Nullable
    public final View f(@NotNull BotGender gender, @NotNull Function1<? super BotGender, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        this.contentView = LayoutInflater.from(getContext()).inflate(R.layout.drz, this);
        h(gender, onClickListener);
        return this.contentView;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final BotGender getCurrentGender() {
        return this.currentGender;
    }

    public final void h(@NotNull BotGender gender, @NotNull final Function1<? super BotGender, Unit> onClickListener) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        List<? extends LinearLayout> listOf;
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        View view = this.contentView;
        if (view != null) {
            FontSettingManager.resetViewSize2Normal(getContext(), view);
            ImageView imageView = (ImageView) view.findViewById(R.id.ywn);
            if (imageView != null) {
                imageView.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.qui_male, R.color.qui_common_brand_standard, 1001));
            }
            ImageView imageView2 = (ImageView) view.findViewById(R.id.v4p);
            if (imageView2 != null) {
                imageView2.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.qui_female, R.color.b47, 1001));
            }
            ImageView imageView3 = (ImageView) view.findViewById(R.id.f114166sl);
            if (imageView3 != null) {
                imageView3.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.qui_asexuality, R.color.qui_common_text_secondary, 1001));
            }
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ywm);
            this.maleLayout = linearLayout3;
            if (linearLayout3 != null) {
                linearLayout3.setBackground(d());
            }
            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.v4o);
            this.femaleLayout = linearLayout4;
            if (linearLayout4 != null) {
                linearLayout4.setBackground(d());
            }
            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.f114156sk);
            this.unknownLayout = linearLayout5;
            if (linearLayout5 != null) {
                linearLayout5.setBackground(d());
            }
            LinearLayout linearLayout6 = this.maleLayout;
            if (linearLayout6 != null && (linearLayout = this.femaleLayout) != null && (linearLayout2 = this.unknownLayout) != null) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new LinearLayout[]{linearLayout6, linearLayout, linearLayout2});
                this.layouts = listOf;
                linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieGenderPickerView.i(Function1.this, this, view2);
                    }
                });
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieGenderPickerView.j(Function1.this, this, view2);
                    }
                });
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AdelieGenderPickerView.k(Function1.this, this, view2);
                    }
                });
            }
            m(gender);
        }
    }

    public final void m(@NotNull BotGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        this.currentGender = gender;
        int i3 = a.f366195a[gender.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        l(null, this.layouts);
                        return;
                    }
                    return;
                }
                l(this.unknownLayout, this.layouts);
                return;
            }
            l(this.femaleLayout, this.layouts);
            return;
        }
        l(this.maleLayout, this.layouts);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        LinearLayout linearLayout = this.maleLayout;
        if (linearLayout != null) {
            linearLayout.setEnabled(enabled);
        }
        LinearLayout linearLayout2 = this.femaleLayout;
        if (linearLayout2 != null) {
            linearLayout2.setEnabled(enabled);
        }
        LinearLayout linearLayout3 = this.unknownLayout;
        if (linearLayout3 != null) {
            linearLayout3.setEnabled(enabled);
        }
    }

    public /* synthetic */ AdelieGenderPickerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieGenderPickerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layouts = new ArrayList();
        this.currentGender = BotGender.KDEFAULT;
    }
}
