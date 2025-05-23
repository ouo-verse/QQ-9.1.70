package com.tencent.hippy.qq.view.alphavideo;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAlphaVideoView extends FrameLayout implements HippyViewBase {
    private static final String TAG = "HippyAlphaVideoView";
    protected boolean mAutoPlay;
    protected boolean mIsLoop;
    protected String mUrl;

    public HippyAlphaVideoView(@NonNull Context context) {
        super(context);
        this.mIsLoop = false;
        this.mAutoPlay = false;
    }

    public void autoPlay() {
        if (!TextUtils.isEmpty(this.mUrl) && this.mAutoPlay) {
            play();
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public void sendEvent(String str, HippyMap hippyMap) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendEvent, eventName:", str, ", data:", hippyMap);
        }
        new HippyViewEvent(str).send(this, hippyMap);
    }

    public void setAutoPlay(boolean z16) {
        this.mAutoPlay = z16;
        autoPlay();
    }

    public void setIsLoop(boolean z16) {
        this.mIsLoop = z16;
    }

    public void setUrl(String str) {
        this.mUrl = str;
        autoPlay();
    }

    public HippyAlphaVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsLoop = false;
        this.mAutoPlay = false;
    }

    public void init() {
    }

    public void play() {
    }

    public void stop() {
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
