package com.tencent.mobileqq.wink.editor.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018B!\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/ui/LyricStyleStickerImageVIew;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "c", "", "state", "setState", "(Ljava/lang/Integer;)V", "d", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setCurrentState", "currentState", "Landroidx/appcompat/widget/AppCompatImageView;", "e", "Landroidx/appcompat/widget/AppCompatImageView;", "mImageView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class LyricStyleStickerImageVIew extends LinearLayoutCompat {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer currentState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AppCompatImageView mImageView;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f321132f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricStyleStickerImageVIew(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f321132f = new LinkedHashMap();
        this.currentState = 2;
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.l67);
        c();
    }

    private final void c() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setImageResource(R.drawable.f162052nr2);
        int c16 = x.c(appCompatImageView.getContext(), 20.0f);
        addView(appCompatImageView, new LinearLayout.LayoutParams(c16, c16));
        appCompatImageView.setContentDescription("\u6b4c\u8bcd");
        this.mImageView = appCompatImageView;
        addView(new View(getContext()), new LinearLayout.LayoutParams(x.c(getContext(), 8.0f), x.c(getContext(), 1.0f)));
        View view = new View(getContext());
        view.setBackgroundColor(1728053247);
        addView(view, new LinearLayout.LayoutParams(x.c(getContext(), 1.0f), x.c(getContext(), 10.0f)));
        View view2 = new View(getContext());
        view2.setBackgroundColor(0);
        addView(view2, new LinearLayout.LayoutParams(x.c(getContext(), 6.0f), x.c(getContext(), 1.0f)));
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getCurrentState() {
        return this.currentState;
    }

    public final void setCurrentState(@Nullable Integer num) {
        this.currentState = num;
    }

    public final void setState(@Nullable Integer state) {
        this.currentState = state;
        if (state != null && state.intValue() == 3) {
            setVisibility(0);
            AppCompatImageView appCompatImageView = this.mImageView;
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R.drawable.f162052nr2);
                return;
            }
            return;
        }
        if (state != null && state.intValue() == 1) {
            setVisibility(0);
            AppCompatImageView appCompatImageView2 = this.mImageView;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(R.drawable.f162051nr1);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricStyleStickerImageVIew(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f321132f = new LinkedHashMap();
        this.currentState = 2;
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.l67);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricStyleStickerImageVIew(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f321132f = new LinkedHashMap();
        this.currentState = 2;
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.l67);
        c();
    }
}
