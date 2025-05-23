package com.tencent.mobileqq.wink.editor.music.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/view/WinkMusicTab;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "", "initParams", "", "position", "", "title", "addTab", "setCurrentPosition", "", "getUnderLineRect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicTab extends QUIPageTabBar {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f321153d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkMusicTab(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initParams() {
        this.mCheckedTextColor = getContext().getColorStateList(R.color.cla);
        this.mUncheckedTextColor = getContext().getColorStateList(R.color.cli);
        this.mUnderlineColor = getContext().getColorStateList(R.color.qui_common_icon_white);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        Context context;
        int i3;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(14.0f);
        if (position == getCurrentPosition()) {
            context = getContext();
            i3 = R.color.cla;
        } else {
            context = getContext();
            i3 = R.color.cli;
        }
        textView.setTextColor(context.getColor(i3));
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ViewUtils.dpToPx(20.0f);
        this.mTabContainer.addView(textView, position, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    @NotNull
    public int[] getUnderLineRect(int position) {
        View childAt = this.mTabContainer.getChildAt(position);
        if (childAt == null) {
            return new int[]{0, 0, 0, 0};
        }
        int width = childAt.getWidth();
        int height = getHeight();
        this.mPaint.measureText(this.mTabTexts[position]);
        int left = childAt.getLeft() + ((width - ViewUtils.dpToPx(14.0f)) / 2);
        int right = childAt.getRight() - ((width - ViewUtils.dpToPx(14.0f)) / 2);
        int dpToPx = (height / 2) + (ViewUtils.dpToPx(14.0f) / 2) + ViewUtils.dpToPx(6.0f);
        return new int[]{left, dpToPx, right, ViewUtils.dpToPx(2.0f) + dpToPx};
    }

    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void setCurrentPosition(int position) {
        if (getCurrentPosition() == position) {
            return;
        }
        super.setCurrentPosition(position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkMusicTab(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f321153d = new LinkedHashMap();
        initParams();
    }

    public /* synthetic */ WinkMusicTab(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
