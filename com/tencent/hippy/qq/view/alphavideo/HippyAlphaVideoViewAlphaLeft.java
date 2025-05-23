package com.tencent.hippy.qq.view.alphavideo;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.ad.alphavideo.MaskAdAlphaVideoView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAlphaVideoViewAlphaLeft extends HippyAlphaVideoView {
    private static final int ERR_CODE = 100;
    private static final String TAG = "HippyAlphaVideoViewAlphaLeft";
    private MaskAdAlphaVideoView mAlphaVideoView;

    public HippyAlphaVideoViewAlphaLeft(@NonNull Context context) {
        super(context);
    }

    private void callbackError(int i3, String str) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("errcode", i3);
        hippyMap.pushString("errorMsg", str);
        sendEvent("onError", hippyMap);
    }

    private void checkFileAndPlay() {
        if (TextUtils.isEmpty(this.mUrl)) {
            QLog.e(TAG, 1, "checkFileAndAutoPlay error: url is null");
            callbackError(100, "play error: url is null");
            return;
        }
        MaskAdAlphaVideoView maskAdAlphaVideoView = this.mAlphaVideoView;
        if (maskAdAlphaVideoView == null) {
            QLog.e(TAG, 1, "checkFileAndAutoPlay error: view is null");
            callbackError(100, "play error: view is null");
        } else {
            maskAdAlphaVideoView.e(new MaskAdAlphaVideoView.b() { // from class: com.tencent.hippy.qq.view.alphavideo.a
                @Override // com.tencent.mobileqq.ad.alphavideo.MaskAdAlphaVideoView.b
                public final void a(boolean z16, String str) {
                    HippyAlphaVideoViewAlphaLeft.this.lambda$checkFileAndPlay$0(z16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkFileAndPlay$0(boolean z16, String str) {
        if (!z16) {
            callbackError(100, str);
        }
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void init() {
        this.mAlphaVideoView = new MaskAdAlphaVideoView(getContext());
        addView(this.mAlphaVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void play() {
        checkFileAndPlay();
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void setIsLoop(boolean z16) {
        super.setIsLoop(z16);
        MaskAdAlphaVideoView maskAdAlphaVideoView = this.mAlphaVideoView;
        if (maskAdAlphaVideoView == null) {
            callbackError(100, "setIsLoop error: view is null");
        } else {
            maskAdAlphaVideoView.setIsLoop(z16);
        }
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void setUrl(String str) {
        super.setUrl(str);
        MaskAdAlphaVideoView maskAdAlphaVideoView = this.mAlphaVideoView;
        if (maskAdAlphaVideoView == null) {
            callbackError(100, "setUrl error: view is null");
        } else {
            maskAdAlphaVideoView.setResUrl(str);
        }
    }

    @Override // com.tencent.hippy.qq.view.alphavideo.HippyAlphaVideoView
    public void stop() {
        MaskAdAlphaVideoView maskAdAlphaVideoView = this.mAlphaVideoView;
        if (maskAdAlphaVideoView != null) {
            maskAdAlphaVideoView.l();
        }
    }

    public HippyAlphaVideoViewAlphaLeft(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
