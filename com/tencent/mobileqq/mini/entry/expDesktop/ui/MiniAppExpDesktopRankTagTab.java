package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\tJ\b\u0010!\u001a\u0004\u0018\u00010\"J\u0013\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001aH\u0002J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fJ\u0019\u0010)\u001a\u00020\u001a2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\tJ\b\u0010.\u001a\u00020\u001aH\u0002R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u00110\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTagTab;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mCurrentPosition", "mOnTagClickListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTagTab$OnTagClickListener;", "mSelectTextColor", "Landroid/content/res/ColorStateList;", "mTagArray", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;", "[Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;", "mTagMargin", "mUnSelectTextColor", "kotlin.jvm.PlatformType", "addTag", "", "position", "info", "getBgColor", "selected", "", "getCurrentSelectedIndex", "getCurrentShowTag", "", "getTagArray", "()[Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;", "notifyDataSetChanged", "setCurrentPosition", "setOnTagClickListener", "listener", "setTagArray", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "([Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;)V", "setTagMargin", "margin", "updateTagViews", "Companion", "OnTagClickListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRankTagTab extends LinearLayout {
    private static final String TAG = "MiniAppExpDesktopRankTabs";
    private int mCurrentPosition;
    private OnTagClickListener mOnTagClickListener;
    private ColorStateList mSelectTextColor;
    private MiniAppTagInfo[] mTagArray;
    private int mTagMargin;
    private ColorStateList mUnSelectTextColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTagTab$OnTagClickListener;", "", "onTagClick", "", "position", "", "view", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppRankTagView;", "fromUserClick", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface OnTagClickListener {
        boolean onTagClick(int position, MiniAppRankTagView view, boolean fromUserClick);
    }

    public MiniAppExpDesktopRankTagTab(Context context) {
        super(context);
        ColorStateList valueOf = ColorStateList.valueOf(Color.parseColor("#0099ff"));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.parseColor(\"#0099ff\"))");
        this.mSelectTextColor = valueOf;
        this.mUnSelectTextColor = AppCompatResources.getColorStateList(getContext(), R.color.qui_common_text_primary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTag$lambda$0(MiniAppExpDesktopRankTagTab this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnTagClickListener onTagClickListener = this$0.mOnTagClickListener;
        boolean z16 = false;
        if (onTagClickListener != null) {
            if (onTagClickListener.onTagClick(i3, view instanceof MiniAppRankTagView ? (MiniAppRankTagView) view : null, true)) {
                z16 = true;
            }
        }
        if (z16) {
            this$0.mCurrentPosition = i3;
            this$0.updateTagViews();
        }
    }

    private final void notifyDataSetChanged() {
        removeAllViews();
        MiniAppTagInfo[] miniAppTagInfoArr = this.mTagArray;
        if (miniAppTagInfoArr == null) {
            return;
        }
        int length = miniAppTagInfoArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            addTag(i3, miniAppTagInfoArr[i3]);
        }
    }

    private final void updateTagViews() {
        ColorStateList colorStateList;
        MiniAppTagInfo[] miniAppTagInfoArr = this.mTagArray;
        if (miniAppTagInfoArr == null) {
            return;
        }
        if (miniAppTagInfoArr.length != getChildCount()) {
            QLog.e(TAG, 1, "updateTagViews but array count not equals childCount");
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            MiniAppRankTagView miniAppRankTagView = childAt instanceof MiniAppRankTagView ? (MiniAppRankTagView) childAt : null;
            if (miniAppRankTagView == null) {
                return;
            }
            miniAppRankTagView.updateContent(miniAppTagInfoArr[i3].getTitle());
            ColorStateList bgColor = getBgColor(i3 == this.mCurrentPosition);
            if (i3 == this.mCurrentPosition) {
                colorStateList = this.mSelectTextColor;
            } else {
                colorStateList = this.mUnSelectTextColor;
            }
            Intrinsics.checkNotNullExpressionValue(colorStateList, "if (i == mCurrentPositio\u2026r else mUnSelectTextColor");
            miniAppRankTagView.updateType(bgColor, colorStateList);
            i3++;
        }
    }

    /* renamed from: getCurrentSelectedIndex, reason: from getter */
    public final int getMCurrentPosition() {
        return this.mCurrentPosition;
    }

    public final Object getCurrentShowTag() {
        if (this.mCurrentPosition < getChildCount()) {
            return getChildAt(this.mCurrentPosition).getTag();
        }
        return null;
    }

    /* renamed from: getTagArray, reason: from getter */
    public final MiniAppTagInfo[] getMTagArray() {
        return this.mTagArray;
    }

    public final void setCurrentPosition(int position) {
        this.mCurrentPosition = position;
        OnTagClickListener onTagClickListener = this.mOnTagClickListener;
        boolean z16 = false;
        if (onTagClickListener != null) {
            View childAt = getChildAt(position);
            if (onTagClickListener.onTagClick(position, childAt instanceof MiniAppRankTagView ? (MiniAppRankTagView) childAt : null, false)) {
                z16 = true;
            }
        }
        if (z16) {
            this.mCurrentPosition = position;
            updateTagViews();
        }
        notifyDataSetChanged();
    }

    public final void setOnTagClickListener(OnTagClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnTagClickListener = listener;
    }

    public final void setTagArray(MiniAppTagInfo[] tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (this.mCurrentPosition >= tags.length) {
            this.mCurrentPosition = 0;
        }
        if (!(tags.length == 0)) {
            this.mTagArray = tags;
            notifyDataSetChanged();
        }
    }

    public final void setTagMargin(int margin) {
        this.mTagMargin = margin;
    }

    private final ColorStateList getBgColor(boolean selected) {
        String str;
        if (selected) {
            if (QQTheme.isNowThemeIsNight()) {
                str = "#400099FF";
            } else {
                str = "#1A0099FF";
            }
        } else if (QQTheme.isNowThemeIsNight()) {
            str = "#505050";
        } else {
            str = "#0A0051FE";
        }
        ColorStateList valueOf = ColorStateList.valueOf(Color.parseColor(str));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.parseColor(color))");
        return valueOf;
    }

    private final void addTag(final int position, MiniAppTagInfo info) {
        ColorStateList colorStateList;
        if (info == null) {
            QLog.e(TAG, 1, "addTag, but title is null or empty.");
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        MiniAppRankTagView miniAppRankTagView = new MiniAppRankTagView(context, null, 2, null);
        miniAppRankTagView.updateContent(info.getTitle());
        ColorStateList bgColor = getBgColor(position == this.mCurrentPosition);
        if (position == this.mCurrentPosition) {
            colorStateList = this.mSelectTextColor;
        } else {
            colorStateList = this.mUnSelectTextColor;
        }
        Intrinsics.checkNotNullExpressionValue(colorStateList, "if (position == mCurrent\u2026r else mUnSelectTextColor");
        miniAppRankTagView.updateType(bgColor, colorStateList);
        miniAppRankTagView.setTag(info.getViewTag());
        miniAppRankTagView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppExpDesktopRankTagTab.addTag$lambda$0(MiniAppExpDesktopRankTagTab.this, position, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        if (position == 0) {
            layoutParams.leftMargin = 0;
        }
        layoutParams.rightMargin = this.mTagMargin;
        addView(miniAppRankTagView, position, layoutParams);
    }

    public MiniAppExpDesktopRankTagTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ColorStateList valueOf = ColorStateList.valueOf(Color.parseColor("#0099ff"));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.parseColor(\"#0099ff\"))");
        this.mSelectTextColor = valueOf;
        this.mUnSelectTextColor = AppCompatResources.getColorStateList(getContext(), R.color.qui_common_text_primary);
    }

    public MiniAppExpDesktopRankTagTab(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ColorStateList valueOf = ColorStateList.valueOf(Color.parseColor("#0099ff"));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.parseColor(\"#0099ff\"))");
        this.mSelectTextColor = valueOf;
        this.mUnSelectTextColor = AppCompatResources.getColorStateList(getContext(), R.color.qui_common_text_primary);
    }

    public MiniAppExpDesktopRankTagTab(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        ColorStateList valueOf = ColorStateList.valueOf(Color.parseColor("#0099ff"));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.parseColor(\"#0099ff\"))");
        this.mSelectTextColor = valueOf;
        this.mUnSelectTextColor = AppCompatResources.getColorStateList(getContext(), R.color.qui_common_text_primary);
    }
}
