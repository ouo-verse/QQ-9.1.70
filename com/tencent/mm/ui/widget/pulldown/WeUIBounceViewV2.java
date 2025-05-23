package com.tencent.mm.ui.widget.pulldown;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u00a2\u0006\u0004\bM\u0010NB\u0011\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u00a2\u0006\u0004\bM\u0010OJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u001c\u0010\u001c\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u001e\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J(\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u001a\u0010%\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u000bH\u0016J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010.\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010'\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R$\u00109\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010=\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010A\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00104\u001a\u0004\b?\u00106\"\u0004\b@\u00108R\"\u0010E\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00104\u001a\u0004\bC\u00106\"\u0004\bD\u00108R\u0016\u0010H\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006P"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/WeUIBounceViewV2;", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView;", "Landroid/view/View;", "contentView", "", "setView", "", NodeProps.ENABLED, "setBounceEnabled", "isBounceEnabled", "", "color", "setStart2EndBgColor", "setEnd2StartBgColor", "setBgColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setStart2EndBg", "setEnd2StartBg", "setStart2EndBgColorByActionBar", "setEnd2StartBgColorByNavigationBar", "setBg", "getView", "initBounce", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "callback", "target", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "setAtEndCallback", "getOffset", "child", "axes", "type", "onStartNestedScroll", "offset", "setOffset", "P", "Landroid/view/View;", "mBackgroundView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getMContentView", "()Landroid/view/View;", "setMContentView", "(Landroid/view/View;)V", "mContentView", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/FrameLayout;", "mContentContainer", ExifInterface.LATITUDE_SOUTH, "Landroid/graphics/drawable/Drawable;", "getMStart2EndBg", "()Landroid/graphics/drawable/Drawable;", "setMStart2EndBg", "(Landroid/graphics/drawable/Drawable;)V", "mStart2EndBg", "T", "getMEnd2StartBg", "setMEnd2StartBg", "mEnd2StartBg", "U", "getMStart2EndBgByActionBar", "setMStart2EndBgByActionBar", "mStart2EndBgByActionBar", "V", "getMEnd2StartBgByNavigationBar", "setMEnd2StartBgByNavigationBar", "mEnd2StartBgByNavigationBar", "W", "I", "mOffsetSign", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class WeUIBounceViewV2 extends NestedBounceView implements IBounceView {

    /* renamed from: P, reason: from kotlin metadata */
    public View mBackgroundView;

    /* renamed from: Q, reason: from kotlin metadata */
    public View mContentView;

    /* renamed from: R, reason: from kotlin metadata */
    public FrameLayout mContentContainer;

    /* renamed from: S, reason: from kotlin metadata */
    public Drawable mStart2EndBg;

    /* renamed from: T, reason: from kotlin metadata */
    public Drawable mEnd2StartBg;

    /* renamed from: U, reason: from kotlin metadata */
    public Drawable mStart2EndBgByActionBar;

    /* renamed from: V, reason: from kotlin metadata */
    public Drawable mEnd2StartBgByNavigationBar;

    /* renamed from: W, reason: from kotlin metadata */
    public int mOffsetSign;

    public /* synthetic */ WeUIBounceViewV2(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    @Nullable
    public final View getMContentView() {
        return this.mContentView;
    }

    @Nullable
    public final Drawable getMEnd2StartBg() {
        return this.mEnd2StartBg;
    }

    @NotNull
    public final Drawable getMEnd2StartBgByNavigationBar() {
        return this.mEnd2StartBgByNavigationBar;
    }

    @Nullable
    public final Drawable getMStart2EndBg() {
        return this.mStart2EndBg;
    }

    @NotNull
    public final Drawable getMStart2EndBgByActionBar() {
        return this.mStart2EndBgByActionBar;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public int getOffset() {
        return getOffset(null);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void initBounce() {
        View view = this.mContentView;
        if (view instanceof ViewGroup) {
            ArrayList arrayList = new ArrayList(32);
            arrayList.add(view);
            while (!arrayList.isEmpty()) {
                View view2 = (View) WeUIBounceViewV2Kt.removeFirstCompat(arrayList);
                if (view2 instanceof AbsListView) {
                    AbsListView absListView = (AbsListView) view2;
                    absListView.setNestedScrollingEnabled(true);
                    absListView.setOverScrollMode(2);
                } else if (view2 instanceof RecyclerView) {
                    RecyclerView recyclerView = (RecyclerView) view2;
                    recyclerView.setNestedScrollingEnabled(true);
                    recyclerView.setOverScrollMode(2);
                } else if (view2 instanceof ScrollView) {
                    ScrollView scrollView = (ScrollView) view2;
                    scrollView.setNestedScrollingEnabled(true);
                    scrollView.setOverScrollMode(2);
                    if (getMCompatScrollViewChild() == null) {
                        setMCompatScrollViewChild(scrollView);
                    }
                } else if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        if (viewGroup.getChildAt(i3) instanceof ViewGroup) {
                            View childAt = viewGroup.getChildAt(i3);
                            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                            arrayList.add((ViewGroup) childAt);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public boolean isBounceEnabled() {
        return getMIsEnabled();
    }

    @Override // com.tencent.mm.ui.widget.pulldown.NestedBounceView, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!getMIsEnabled()) {
            if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
                Log.d(NestedBounceView.TAG, "[onStartNestedScroll] mIsEnabled:" + getMIsEnabled());
                return false;
            }
            return false;
        }
        return super.onStartNestedScroll(child, target, axes, type);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setAtEndCallback(@Nullable AtEndCallback callback, @Nullable View target) {
        if (target != null) {
            WeUIBounceCommonKt.setAtEndCallback(target, callback);
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setAtStartCallback(@Nullable AtStartCallback callback, @Nullable View target) {
        if (target != null) {
            WeUIBounceCommonKt.setAtStartCallback(target, callback);
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setBg(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setStart2EndBg(drawable);
        setEnd2StartBg(drawable);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setBgColor(int color) {
        setStart2EndBgColor(color);
        setEnd2StartBgColor(color);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setBounceEnabled(boolean enabled) {
        setMIsEnabled(enabled);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setEnd2StartBg(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mEnd2StartBg = drawable;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setEnd2StartBgColor(int color) {
        this.mEnd2StartBg = new ColorDrawable(color);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setEnd2StartBgColorByNavigationBar(int color) {
        this.mEnd2StartBgByNavigationBar = new ColorDrawable(color);
    }

    public final void setMContentView(@Nullable View view) {
        this.mContentView = view;
    }

    public final void setMEnd2StartBg(@Nullable Drawable drawable) {
        this.mEnd2StartBg = drawable;
    }

    public final void setMEnd2StartBgByNavigationBar(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.mEnd2StartBgByNavigationBar = drawable;
    }

    public final void setMStart2EndBg(@Nullable Drawable drawable) {
        this.mStart2EndBg = drawable;
    }

    public final void setMStart2EndBgByActionBar(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.mStart2EndBgByActionBar = drawable;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.NestedBounceView, com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void setOffset(@Nullable View child, int offset) {
        int i3 = 0;
        if (offset < 0) {
            if ((getMPullDownEnableFlag() & 2) != 0) {
                i3 = offset;
            }
            if (this.mOffsetSign != -1) {
                this.mOffsetSign = -1;
                View view = this.mBackgroundView;
                if (view != null) {
                    Drawable drawable = this.mEnd2StartBg;
                    if (drawable == null) {
                        drawable = this.mEnd2StartBgByNavigationBar;
                    }
                    view.setBackground(drawable);
                }
            }
        } else if (offset > 0) {
            if ((getMPullDownEnableFlag() & 1) != 0) {
                i3 = offset;
            }
            if (this.mOffsetSign != 1) {
                this.mOffsetSign = 1;
                View view2 = this.mBackgroundView;
                if (view2 != null) {
                    Drawable drawable2 = this.mStart2EndBg;
                    if (drawable2 == null) {
                        drawable2 = this.mStart2EndBgByActionBar;
                    }
                    view2.setBackground(drawable2);
                }
            }
        } else {
            this.mOffsetSign = 0;
            View view3 = this.mBackgroundView;
            if (view3 != null) {
                view3.setBackground(null);
            }
            i3 = offset;
        }
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        if (nestedBounceParam.isPullDownDebugOpen()) {
            Log.i(NestedBounceView.TAG, "[setOffset] offset:" + offset + " offsetFinal:" + i3 + " flag:" + getMPullDownEnableFlag());
        }
        nestedBounceParam.getOverScrollMode().setOffset(this.mContentContainer, i3);
        b(i3);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setStart2EndBg(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mStart2EndBg = drawable;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setStart2EndBgColor(int color) {
        this.mStart2EndBg = new ColorDrawable(color);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setStart2EndBgColorByActionBar(int color) {
        this.mStart2EndBgByActionBar = new ColorDrawable(color);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    public void setView(@Nullable View contentView) {
        Integer num;
        boolean z16;
        int i3;
        int i16;
        this.mContentView = contentView;
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mContentContainer = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (contentView != null) {
            ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
            Integer num2 = null;
            if (layoutParams != null) {
                num = Integer.valueOf(layoutParams.width);
            } else {
                num = null;
            }
            boolean z17 = false;
            if (num == null || num.intValue() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = -1;
            } else {
                i3 = layoutParams.width;
            }
            if (layoutParams != null) {
                num2 = Integer.valueOf(layoutParams.height);
            }
            if (num2 == null || num2.intValue() == 0) {
                z17 = true;
            }
            if (z17) {
                i16 = -1;
            } else {
                i16 = layoutParams.height;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i16);
            FrameLayout frameLayout2 = this.mContentContainer;
            if (frameLayout2 != null) {
                frameLayout2.addView(contentView, layoutParams2);
            }
        }
        NestedScrollView nestedScrollView = new NestedScrollView(getContext());
        nestedScrollView.setOverScrollMode(2);
        nestedScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        nestedScrollView.addView(new LinearLayout(getContext()), new ViewGroup.LayoutParams(-1, -1));
        nestedScrollView.setImportantForAccessibility(2);
        this.mBackgroundView = nestedScrollView;
        addView(nestedScrollView);
        addView(this.mContentContainer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeUIBounceViewV2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStart2EndBgByActionBar = new ColorDrawable(0);
        this.mEnd2StartBgByNavigationBar = new ColorDrawable(0);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.NestedBounceView, com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getOffset(@Nullable View child) {
        return NestedBounceParam.INSTANCE.getOverScrollMode().getOffset(this.mContentContainer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WeUIBounceViewV2(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceView
    @NotNull
    public View getView() {
        return this;
    }
}
