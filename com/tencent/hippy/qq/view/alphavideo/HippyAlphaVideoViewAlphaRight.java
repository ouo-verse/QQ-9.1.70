package com.tencent.hippy.qq.view.alphavideo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAlphaVideoViewAlphaRight extends HippyAlphaVideoView {
    private static final String TAG = "HippyAlphaVideoViewAlphaRight";
    private Drawable mAlphaDrawable;
    private ImageView mAlphaVideoView;

    public HippyAlphaVideoViewAlphaRight(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void init() {
        this.mAlphaVideoView = new ImageView(getContext());
        addView(this.mAlphaVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void play() {
        if (TextUtils.isEmpty(this.mUrl)) {
            QLog.e(TAG, 1, "play url is null");
            return;
        }
        Drawable drawable = this.mAlphaDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        Drawable alphaDrawable = HippyAlphaHelper.getInstance().getAlphaDrawable(this.mUrl, this.mIsLoop);
        this.mAlphaDrawable = alphaDrawable;
        if (alphaDrawable != null) {
            alphaDrawable.setCallback(this.mAlphaVideoView);
            QLog.d(TAG, 1, "play alpha drawable");
            this.mAlphaVideoView.setImageDrawable(this.mAlphaDrawable);
        } else {
            QLog.e(TAG, 1, "alpha drawable is null");
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("errcode", 100);
            hippyMap.pushString("errorMsg", "fail to getDrawable");
            sendEvent("onError", hippyMap);
        }
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void setUrl(String str) {
        super.setUrl(str);
        autoPlay();
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void stop() {
        ImageView imageView = this.mAlphaVideoView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.mAlphaVideoView.setVisibility(8);
        }
    }

    public HippyAlphaVideoViewAlphaRight(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
