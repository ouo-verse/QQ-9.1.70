package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StImage;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
    protected View.OnClickListener mAvatarClickListener;
    protected View mContainer;
    protected View.OnClickListener mContainerClickListener;
    protected Context mContext;
    protected QFSMessageItemInfo mItemInfo;
    protected int mLastPos;
    protected View.OnClickListener mLikeViewClickListener;
    protected View.OnClickListener mMessageClickListener;
    protected View.OnLongClickListener mOnItemLongClickListener;
    private QCircleReportBean mReportBean;
    protected int mViewType;
    protected int mLaunchTo = -1;
    protected int mCurrentSelectedType = -1;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.fragments.message.presenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class ViewOnTouchListenerC0870a implements View.OnTouchListener {
        ViewOnTouchListenerC0870a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (a.this.mContainer == null) {
                return false;
            }
            int action = motionEvent.getAction();
            View view2 = a.this.mContainer;
            boolean z16 = true;
            if (action == 1 || action == 3) {
                z16 = false;
            }
            view2.setHovered(z16);
            return false;
        }
    }

    public a(int i3) {
        this.mViewType = i3;
    }

    protected void adjustAuthIconLayout(ImageView imageView, FeedCloudMeta$StImage feedCloudMeta$StImage) {
        if (feedCloudMeta$StImage.width.get() != 0 && feedCloudMeta$StImage.height.get() != 0) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = cx.a(feedCloudMeta$StImage.height.get());
            layoutParams.width = cx.a(feedCloudMeta$StImage.width.get());
            imageView.setLayoutParams(layoutParams);
        }
    }

    protected abstract void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3);

    public final void bindData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        this.mItemInfo = qFSMessageItemInfo;
        bindCustomData(qFSMessageItemInfo, i3);
        initClickListener();
        this.mLastPos = i3;
        updateBackground(qFSMessageItemInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getLogTag();

    protected int getPageId() {
        String logTag;
        if (TextUtils.isEmpty(getLogTag())) {
            logTag = "";
        } else {
            logTag = getLogTag();
        }
        return QCircleReportBean.getPageId(logTag, this.mReportBean);
    }

    protected abstract void initClickListener();

    protected abstract void initCustomView(Context context, @NonNull View view);

    public final void initView(Context context, View view) {
        this.mContext = context;
        if (view == null) {
            return;
        }
        this.mContainer = view;
        view.setBackground(ResourcesCompat.getDrawable(view.getResources(), R.drawable.qui_comment_panel_item_click_bg, null));
        initCustomView(context, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLabelBackground(View view, float f16) {
        if (view == null) {
            return;
        }
        int c16 = QFSQUIUtilsKt.c(view.getContext(), R.color.qui_common_text_secondary, 0.1f);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{c16, c16});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(cx.a(f16));
        view.setBackground(gradientDrawable);
    }

    public void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.mOnItemLongClickListener = onLongClickListener;
    }

    public void setPageParam(int i3, int i16) {
        this.mLaunchTo = i3;
        this.mCurrentSelectedType = i16;
    }

    public void setTouchLister(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new ViewOnTouchListenerC0870a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUserTypeLabel(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateBackground(QFSMessageItemInfo qFSMessageItemInfo) {
        if (qFSMessageItemInfo != null && this.mContainer != null) {
            if (qFSMessageItemInfo.canShowNoAnimHighLight()) {
                Drawable drawable = ResourcesCompat.getDrawable(this.mContainer.getResources(), R.drawable.qui_common_overlay_light_bg, null);
                if (drawable != null) {
                    drawable.setAlpha(140);
                }
                this.mContainer.setBackground(drawable);
                return;
            }
            View view = this.mContainer;
            view.setBackground(ResourcesCompat.getDrawable(view.getResources(), R.drawable.qui_comment_panel_item_click_bg, null));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean == null) {
            return new QCircleReportBean();
        }
        return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), qCircleReportBean);
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }
}
