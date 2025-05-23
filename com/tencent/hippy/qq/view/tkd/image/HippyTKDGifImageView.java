package com.tencent.hippy.qq.view.tkd.image;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.image.HippyImageView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDGifImageView extends HippyImageView implements HippyTKDSkinHandler.HippyQBCommonSkin {
    public static final String TAG = "HippyGifImage";
    private HippyMap mClipInfoMap;
    private boolean mEnableNoPicMode;
    String mGIFUrl;
    private NativeGestureDispatcher mGestureDispatcher;
    protected HippyEngineContext mHippyEngineContext;
    private OnErrorEvent mOnErrorEvent;
    private OnLoadEvent mOnLoadEvent;
    private OnLoadStartEvent mOnLoadStartEvent;
    private OnStartPlayEvent mOnStartPlayEvent;
    private OnStopPlayEvent mOnStopPlayEvent;
    private HippyMap mReportData;
    boolean mUserRequestPlay;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class OnErrorEvent extends HippyViewEvent {
        public OnErrorEvent(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class OnLoadEvent extends HippyViewEvent {
        public OnLoadEvent(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class OnLoadStartEvent extends HippyViewEvent {
        public OnLoadStartEvent(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class OnStartPlayEvent extends HippyViewEvent {
        public OnStartPlayEvent(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class OnStopPlayEvent extends HippyViewEvent {
        public OnStopPlayEvent(String str) {
            super(str);
        }
    }

    public HippyTKDGifImageView(Context context) {
        super(context);
        this.mReportData = null;
        this.mClipInfoMap = null;
        this.mEnableNoPicMode = false;
        this.mGIFUrl = null;
        this.mUserRequestPlay = false;
        this.mHippyEngineContext = context instanceof HippyInstanceContext ? ((HippyInstanceContext) context).getEngineContext() : null;
    }

    private OnErrorEvent getOnErrorEvent() {
        if (this.mOnErrorEvent == null) {
            this.mOnErrorEvent = new OnErrorEvent("onError");
        }
        return this.mOnErrorEvent;
    }

    private OnLoadEvent getOnLoadEvent() {
        if (this.mOnLoadEvent == null) {
            this.mOnLoadEvent = new OnLoadEvent("onLoad");
        }
        return this.mOnLoadEvent;
    }

    private OnLoadStartEvent getOnLoadStartEvent() {
        if (this.mOnLoadStartEvent == null) {
            this.mOnLoadStartEvent = new OnLoadStartEvent(HippyQQPagView.EventName.ON_LOAD_START);
        }
        return this.mOnLoadStartEvent;
    }

    private OnStartPlayEvent getOnStartPlayEvent() {
        if (this.mOnStartPlayEvent == null) {
            this.mOnStartPlayEvent = new OnStartPlayEvent("onStartPlay");
        }
        return this.mOnStartPlayEvent;
    }

    private OnStopPlayEvent getOnStopPlayEvent() {
        if (this.mOnStopPlayEvent == null) {
            this.mOnStopPlayEvent = new OnStopPlayEvent("onStopPlay");
        }
        return this.mOnStopPlayEvent;
    }

    public HippyMap getClipInfo() {
        return this.mClipInfoMap;
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return this.mGestureDispatcher;
    }

    public HippyMap getReportData() {
        return this.mReportData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mUserRequestPlay = false;
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        NativeGestureDispatcher nativeGestureDispatcher = this.mGestureDispatcher;
        if (nativeGestureDispatcher != null) {
            return onTouchEvent | nativeGestureDispatcher.handleTouchEvent(motionEvent);
        }
        return onTouchEvent;
    }

    public void setClipInfo(HippyMap hippyMap) {
        this.mClipInfoMap = hippyMap;
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        this.mGestureDispatcher = nativeGestureDispatcher;
    }

    public void setReportData(HippyMap hippyMap) {
        this.mReportData = hippyMap;
    }

    public void handleNoPicModeChange() {
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin
    public void hippySwitchSkin() {
    }

    public void stopPlay() {
    }

    public void setGifUrl(String str) {
    }

    public void setNoPicModeOption(boolean z16) {
    }

    public void setSustainedPlay(boolean z16) {
    }
}
