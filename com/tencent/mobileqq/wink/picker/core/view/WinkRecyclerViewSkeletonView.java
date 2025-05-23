package com.tencent.mobileqq.wink.picker.core.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/view/WinkRecyclerViewSkeletonView;", "Landroid/widget/FrameLayout;", "Landroid/widget/LinearLayout;", "b", "Landroid/view/View;", "a", "", "d", "I", "itemSpace", "e", "itemViewSize", "f", "itemBackgroundColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkRecyclerViewSkeletonView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int itemSpace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int itemViewSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int itemBackgroundColor;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f324749h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkRecyclerViewSkeletonView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final View a() {
        View view = new View(getContext());
        int i3 = this.itemViewSize;
        view.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
        view.setBackgroundColor(this.itemBackgroundColor);
        return view;
    }

    private final LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        for (int i3 = 1; i3 < 4; i3++) {
            linearLayout.addView(a());
        }
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getContext(), R.drawable.f162703m64));
        linearLayout.setShowDividers(2);
        return linearLayout;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkRecyclerViewSkeletonView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkRecyclerViewSkeletonView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f324749h = new LinkedHashMap();
        this.itemSpace = ImmersiveUtils.dpToPx(2.0f);
        this.itemViewSize = (ImmersiveUtils.getScreenWidth() - (this.itemSpace * 2)) / 3;
        int ceil = (int) Math.ceil(ImmersiveUtils.getScreenHeight() / this.itemViewSize);
        this.itemBackgroundColor = Color.parseColor("#F5F5F5");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-1);
        int i16 = 1;
        linearLayout.setOrientation(1);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(context, R.drawable.f162703m64));
        linearLayout.setShowDividers(2);
        if (1 <= ceil) {
            while (true) {
                linearLayout.addView(b());
                if (i16 == ceil) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ WinkRecyclerViewSkeletonView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
