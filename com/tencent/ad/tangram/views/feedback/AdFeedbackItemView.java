package com.tencent.ad.tangram.views.feedback;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdFeedbackItemView extends LinearLayout implements AdImageViewAdapter.Callback {
    private static final String JUMP_ICON_URL = "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/QQmobile/qui_chevron_right.png";
    public static final String TAG = "AdFeedbackItemView";
    private final WeakReference<AdImageViewBuilder.Listener> mImageViewListener;
    private AdFeedbackItemModel mModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Params {
        AdFeedbackItemModel model;
        AdFeedbackDialogFragment.NoClickAccessibilityDelegate noClickAccessibilityDelegate;

        @Nullable
        WeakReference<View.OnClickListener> listener = null;
        int styleId = 0;
        boolean isDarkMode = false;

        public boolean isValid() {
            AdFeedbackItemModel adFeedbackItemModel = this.model;
            if (adFeedbackItemModel != null && !TextUtils.isEmpty(adFeedbackItemModel.mIconUrl) && !TextUtils.isEmpty(this.model.mText)) {
                return true;
            }
            return false;
        }
    }

    public AdFeedbackItemView(Context context) {
        this(context, new Params());
    }

    private void initAntiSpam(View view, AdFeedbackDialogFragment.NoClickAccessibilityDelegate noClickAccessibilityDelegate) {
        if (noClickAccessibilityDelegate != null && view != null) {
            view.setAccessibilityDelegate(noClickAccessibilityDelegate);
            setAccessibilityDelegate(noClickAccessibilityDelegate);
        } else {
            AdLog.i(TAG, "[initAntiSpam] params is null");
        }
    }

    private void initChildView(@Nullable Params params) {
        float f16;
        if (params != null && params.isValid()) {
            if (params.styleId == 1) {
                f16 = 20.0f;
            } else {
                f16 = 25.0f;
            }
            int dp2px = AdUIUtils.dp2px(f16, getResources());
            AdImageViewBuilder.Params params2 = new AdImageViewBuilder.Params();
            params2.callback = new WeakReference<>(this);
            params2.context = new WeakReference<>(getContext());
            params2.url = params.model.mIconUrl;
            params2.listener = this.mImageViewListener;
            View buildImageView = AdImageViewBuilder.getInstance().buildImageView(params2);
            if (!(buildImageView instanceof ImageView)) {
                return;
            }
            Integer iconColorFilter = AdFeedback.getInstance().getIconColorFilter(getContext());
            if (iconColorFilter != null) {
                ((ImageView) buildImageView).setColorFilter(iconColorFilter.intValue());
            } else {
                AdLog.e(TAG, "[initChildView] iconColorFilter is null");
            }
            ((ImageView) buildImageView).setScaleType(ImageView.ScaleType.FIT_CENTER);
            buildImageView.setLayoutParams(new LinearLayout.LayoutParams(dp2px, dp2px));
            initAntiSpam(buildImageView, params.noClickAccessibilityDelegate);
            addView(buildImageView);
            TextView textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            float f17 = 15.0f;
            layoutParams.setMargins(AdUIUtils.dp2px(15.0f, getResources()), 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            Integer buttonTextColor = AdFeedback.getInstance().getButtonTextColor(getContext());
            if (buttonTextColor != null) {
                textView.setTextColor(buttonTextColor.intValue());
            } else {
                AdLog.e(TAG, "[initChildView] textColor is null");
            }
            textView.setText(params.model.mText);
            if (params.styleId == 1) {
                f17 = 12.0f;
            }
            textView.setTextSize(1, f17);
            initAntiSpam(textView, params.noClickAccessibilityDelegate);
            addView(textView);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
            addView(view);
            if (!TextUtils.isEmpty(params.model.mJumpUrl)) {
                AdImageViewBuilder.Params params3 = new AdImageViewBuilder.Params();
                params3.callback = new WeakReference<>(this);
                params3.context = new WeakReference<>(getContext());
                params3.url = JUMP_ICON_URL;
                params3.listener = this.mImageViewListener;
                View buildImageView2 = AdImageViewBuilder.getInstance().buildImageView(params3);
                if (!(buildImageView2 instanceof ImageView)) {
                    return;
                }
                ImageView imageView = (ImageView) buildImageView2;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                Integer iconColorFilter2 = AdFeedback.getInstance().getIconColorFilter(getContext());
                if (iconColorFilter2 != null) {
                    imageView.setColorFilter(iconColorFilter2.intValue());
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dp2px, dp2px);
                layoutParams2.addRule(11);
                buildImageView2.setLayoutParams(layoutParams2);
                addView(buildImageView2);
            }
            WeakReference<View.OnClickListener> weakReference = params.listener;
            if (weakReference != null) {
                setOnClickListener(weakReference.get());
            }
        }
    }

    private void initView(@Nullable Params params) {
        int i3;
        float f16;
        if (params != null && params.isValid()) {
            boolean z16 = false;
            setOrientation(0);
            setGravity(16);
            if (params.styleId == 1) {
                z16 = true;
            }
            if (z16) {
                i3 = AdUIUtils.dp2px(260.0f, getResources());
            } else {
                i3 = -2;
            }
            setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
            float f17 = 15.0f;
            if (z16) {
                f16 = 15.0f;
            } else {
                f16 = 19.0f;
            }
            int dp2px = AdUIUtils.dp2px(f16, getResources());
            if (z16) {
                f17 = 12.0f;
            }
            int dp2px2 = AdUIUtils.dp2px(f17, getResources());
            setPadding(dp2px2, dp2px, dp2px2, dp2px);
        }
    }

    public AdFeedbackItemModel getModel() {
        return this.mModel;
    }

    public AdFeedbackItemView(Context context, @Nullable Params params) {
        super(context);
        this.mImageViewListener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.feedback.AdFeedbackItemView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdFeedbackItemView.this.onStopLoad(z16);
            }
        });
        if (params == null || !params.isValid()) {
            return;
        }
        this.mModel = params.model;
        initView(params);
        initChildView(params);
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
    }
}
