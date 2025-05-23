package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\b\u0010 \u001a\u00020\u001bH\u0002J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000fJ\u0019\u0010#\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\tJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0018J\b\u0010*\u001a\u00020\u001bH\u0002R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTags;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mCurrentPosition", "mCurrentTagClickListener", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTags$OnCurrentTagClickListener;", "mSelectedTagType", "Lcom/tencent/biz/qui/quitagview/QUITagType;", "mTagArray", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;", "[Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;", "mTagMargin", "mTagSize", "Lcom/tencent/biz/qui/quitagview/QUITagSize;", "mUnSelectedTagType", "addTag", "", "position", "info", "getCurrentShowTag", "", "notifyDataSetChanged", "setCurrentTagClickListener", "listener", "setTagArray", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "([Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppTagInfo;)V", "setTagMargin", "margin", "setTagSize", "size", "updateTagViews", "Companion", "OnCurrentTagClickListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRankTags extends LinearLayout {
    private static final String TAG = "MiniAppExpDesktopRankTabs";
    private int mCurrentPosition;
    private OnCurrentTagClickListener mCurrentTagClickListener;
    private QUITagType mSelectedTagType;
    private MiniAppTagInfo[] mTagArray;
    private int mTagMargin;
    private QUITagSize mTagSize;
    private QUITagType mUnSelectedTagType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppExpDesktopRankTags$OnCurrentTagClickListener;", "", "onCurrentTagClick", "", "position", "", "view", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface OnCurrentTagClickListener {
        boolean onCurrentTagClick(int position, QUITagView view);
    }

    public MiniAppExpDesktopRankTags(Context context) {
        super(context);
        this.mTagSize = QUITagSize.SMALL;
        this.mSelectedTagType = QUITagType.COLOR_BLUE;
        this.mUnSelectedTagType = QUITagType.FILL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTag$lambda$0(MiniAppExpDesktopRankTags this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnCurrentTagClickListener onCurrentTagClickListener = this$0.mCurrentTagClickListener;
        boolean z16 = false;
        if (onCurrentTagClickListener != null) {
            if (onCurrentTagClickListener.onCurrentTagClick(i3, view instanceof QUITagView ? (QUITagView) view : null)) {
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
        MiniAppTagInfo[] miniAppTagInfoArr = this.mTagArray;
        if (miniAppTagInfoArr == null) {
            return;
        }
        if (miniAppTagInfoArr.length != getChildCount()) {
            QLog.e(TAG, 1, "updateTagViews but array count not equals childCount");
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            QUITagView qUITagView = childAt instanceof QUITagView ? (QUITagView) childAt : null;
            if (qUITagView == null) {
                return;
            }
            QUITagType specialTag = miniAppTagInfoArr[i3].getSpecialTag();
            if (specialTag == null) {
                if (i3 == this.mCurrentPosition) {
                    specialTag = this.mSelectedTagType;
                } else {
                    specialTag = this.mUnSelectedTagType;
                }
            }
            qUITagView.setConfig(new QUITagViewConfig(specialTag, this.mTagSize, null, miniAppTagInfoArr[i3].getTitle()));
        }
    }

    public final Object getCurrentShowTag() {
        if (this.mCurrentPosition < getChildCount()) {
            return getChildAt(this.mCurrentPosition).getTag();
        }
        return null;
    }

    public final void setCurrentTagClickListener(OnCurrentTagClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mCurrentTagClickListener = listener;
    }

    public final void setTagArray(MiniAppTagInfo[] tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (tags.length != 0) {
            this.mTagArray = tags;
            notifyDataSetChanged();
        }
    }

    public final void setTagMargin(int margin) {
        this.mTagMargin = margin;
    }

    public final void setTagSize(QUITagSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.mTagSize = size;
    }

    private final void addTag(final int position, MiniAppTagInfo info) {
        if (info == null) {
            QLog.e(TAG, 1, "addTag, but title is null or empty.");
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        QUITagView qUITagView = new QUITagView(context, null, 2, null);
        QUITagType specialTag = info.getSpecialTag();
        if (specialTag == null) {
            if (position == this.mCurrentPosition) {
                specialTag = this.mSelectedTagType;
            } else {
                specialTag = this.mUnSelectedTagType;
            }
        }
        qUITagView.setConfig(new QUITagViewConfig(specialTag, this.mTagSize, null, info.getTitle()));
        qUITagView.setTag(info.getViewTag());
        qUITagView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppExpDesktopRankTags.addTag$lambda$0(MiniAppExpDesktopRankTags.this, position, view);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        if (position == 0) {
            layoutParams.leftMargin = 0;
        }
        layoutParams.rightMargin = this.mTagMargin;
        addView(qUITagView, position, layoutParams);
    }

    public MiniAppExpDesktopRankTags(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTagSize = QUITagSize.SMALL;
        this.mSelectedTagType = QUITagType.COLOR_BLUE;
        this.mUnSelectedTagType = QUITagType.FILL;
    }

    public MiniAppExpDesktopRankTags(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTagSize = QUITagSize.SMALL;
        this.mSelectedTagType = QUITagType.COLOR_BLUE;
        this.mUnSelectedTagType = QUITagType.FILL;
    }

    public MiniAppExpDesktopRankTags(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mTagSize = QUITagSize.SMALL;
        this.mSelectedTagType = QUITagType.COLOR_BLUE;
        this.mUnSelectedTagType = QUITagType.FILL;
    }
}
