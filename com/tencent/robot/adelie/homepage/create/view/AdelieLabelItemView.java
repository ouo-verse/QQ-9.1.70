package com.tencent.robot.adelie.homepage.create.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\tR#\u0010\u0010\u001a\n \n*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0013\u001a\n \n*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelItemView;", "Landroid/widget/LinearLayout;", "", "selected", "", "setSelected", "", "text", IECSearchBar.METHOD_SET_TEXT, "", "kotlin.jvm.PlatformType", "d", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Lazy;", "b", "()Landroid/graphics/drawable/Drawable;", "iconNormalDrawable", "e", "c", "iconSelectedDrawable", "Lhn2/a;", "f", "a", "()Lhn2/a;", "binding", tl.h.F, "Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieLabelItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy iconNormalDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy iconSelectedDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean selected;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieLabelItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final hn2.a a() {
        return (hn2.a) this.binding.getValue();
    }

    private final Drawable b() {
        return (Drawable) this.iconNormalDrawable.getValue();
    }

    private final Drawable c() {
        return (Drawable) this.iconSelectedDrawable.getValue();
    }

    public final CharSequence d() {
        return a().f405340d.getText();
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        if (this.selected == selected) {
            return;
        }
        if (selected) {
            a().f405339c.setImageDrawable(c());
            a().f405340d.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
        } else {
            a().f405339c.setImageDrawable(b());
            a().f405340d.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        a().f405338b.setSelected(selected);
        this.selected = selected;
    }

    public final void setText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        a().f405340d.setText(text);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieLabelItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieLabelItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieLabelItemView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieLabelItemView$iconNormalDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return ie0.a.f().o(context, R.drawable.qui_add, R.color.qui_common_icon_primary, 1000);
            }
        });
        this.iconNormalDrawable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieLabelItemView$iconSelectedDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return ie0.a.f().o(context, R.drawable.qui_add, R.color.qui_common_brand_standard, 1000);
            }
        });
        this.iconSelectedDrawable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<hn2.a>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieLabelItemView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final hn2.a invoke() {
                return hn2.a.f(LayoutInflater.from(context), this);
            }
        });
        this.binding = lazy3;
        FontSettingManager.resetViewSize2Normal(context, a().getRoot());
        a().f405339c.setImageDrawable(b());
        a().f405340d.setTextColor(context.getColor(R.color.qui_common_text_primary));
    }
}
