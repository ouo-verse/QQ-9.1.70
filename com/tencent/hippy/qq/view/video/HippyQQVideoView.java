package com.tencent.hippy.qq.view.video;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQVideoView extends HippyViewGroup {
    public static String TAG = "HippyVideoView";
    private Activity mActivity;
    private boolean mHasExictlySize;
    private HippyEngineContext mHippyContext;
    private boolean mIsDoingFullscreen;
    private int mOriginalHeight;
    private int mOriginalIndex;
    private ViewGroup.LayoutParams mOriginalLayoutParams;
    private ViewGroup mOriginalParent;
    private int mOriginalWidth;
    private OnVideoViewControlListener mVideoViewControlListener;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnVideoViewControlListener {
        void afterChangeFullScreen(HippyQQVideoView hippyQQVideoView);

        void beforeChangeFullScreen(HippyQQVideoView hippyQQVideoView);

        void enterFullScreen(int i3, HippyQQVideoView hippyQQVideoView, boolean z16, Promise promise);

        void exitFullScreen(HippyQQVideoView hippyQQVideoView, Promise promise);

        void getPlayInfo(HippyQQVideoView hippyQQVideoView, Promise promise);

        boolean isFullScreen();

        void onActivityCreate();

        void onActivityDestroy();

        void onActivityPause();

        void onActivityResume();

        void onActivityStart();

        void onActivityStop();

        void open(HippyQQVideoView hippyQQVideoView, JSONObject jSONObject);

        void pause(HippyQQVideoView hippyQQVideoView);

        void play(HippyQQVideoView hippyQQVideoView);

        void preplay(HippyQQVideoView hippyQQVideoView);

        void replay(HippyQQVideoView hippyQQVideoView);

        void resetSrc(HippyQQVideoView hippyQQVideoView, JSONObject jSONObject);

        void seek(HippyQQVideoView hippyQQVideoView, int i3);

        void setEndWithLastFrame(boolean z16);

        void setLoopBack(boolean z16);

        void setMuted(HippyQQVideoView hippyQQVideoView, boolean z16);

        void setResize(HippyQQVideoView hippyQQVideoView, String str);

        void setStartPosition(int i3);

        void setTimeInterval(HippyQQVideoView hippyQQVideoView, int i3);

        void stop(HippyQQVideoView hippyQQVideoView);
    }

    public HippyQQVideoView(@NonNull Context context) {
        super(context);
        this.mOriginalIndex = 0;
        this.mHasExictlySize = true;
        this.mIsDoingFullscreen = false;
        if (context instanceof HippyInstanceContext) {
            HippyInstanceContext hippyInstanceContext = (HippyInstanceContext) context;
            this.mHippyContext = hippyInstanceContext.getEngineContext();
            if (hippyInstanceContext.getBaseContext() instanceof Activity) {
                this.mActivity = (Activity) hippyInstanceContext.getBaseContext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceViewMeasure(View view) {
        int left;
        int top;
        if (view != null && !this.mIsDoingFullscreen) {
            int i3 = this.mOriginalWidth;
            if (i3 == 0) {
                i3 = view.getWidth();
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            int i16 = this.mOriginalHeight;
            if (i16 == 0) {
                i16 = view.getHeight();
            }
            view.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
            int left2 = view.getLeft();
            int top2 = view.getTop();
            if (this.mOriginalWidth == 0) {
                left = view.getRight();
            } else {
                left = view.getLeft() + this.mOriginalWidth;
            }
            if (this.mOriginalHeight == 0) {
                top = view.getBottom();
            } else {
                top = view.getTop() + this.mOriginalHeight;
            }
            view.layout(left2, top2, left, top);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "forceViewMeasure mIsDoingFullscreen:" + this.mIsDoingFullscreen);
            }
        }
    }

    public void endHotSwap() {
        OnVideoViewControlListener onVideoViewControlListener = this.mVideoViewControlListener;
        if (onVideoViewControlListener != null) {
            onVideoViewControlListener.afterChangeFullScreen(this);
        }
    }

    public void enterFullScreen(int i3) {
        this.mIsDoingFullscreen = true;
        this.mOriginalLayoutParams = getLayoutParams();
        this.mOriginalParent = (ViewGroup) getParent();
        ViewGroup.LayoutParams layoutParams = this.mOriginalLayoutParams;
        if (layoutParams.height <= 0 || layoutParams.width <= 0) {
            this.mHasExictlySize = false;
            this.mOriginalWidth = getWidth();
            this.mOriginalHeight = getHeight();
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            Window window = activity.getWindow();
            if (getParent() instanceof ViewGroup) {
                this.mOriginalIndex = ((ViewGroup) getParent()).indexOfChild(this);
                startHotSwap();
                ((ViewGroup) getParent()).removeView(this);
                endHotSwap();
            }
            window.addContentView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void exitFullScreen(int i3) {
        this.mIsDoingFullscreen = false;
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            startHotSwap();
            ((ViewGroup) getParent()).removeView(this);
            endHotSwap();
        }
        if (!this.mHasExictlySize) {
            ViewGroup.LayoutParams layoutParams = this.mOriginalLayoutParams;
            layoutParams.height = this.mOriginalHeight;
            layoutParams.width = this.mOriginalWidth;
        }
        this.mOriginalParent.addView(this, this.mOriginalIndex, this.mOriginalLayoutParams);
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public OnVideoViewControlListener getVideoViewControlListener() {
        return this.mVideoViewControlListener;
    }

    public void initView() {
        Activity activity = this.mActivity;
        if (activity != null) {
            setVideoViewControlListener(new HVideoDelegate(activity, this, 102));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16 && getChildAt(0) != null) {
            getChildAt(0).layout(i3, i16, i17, i18);
            getChildAt(0).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onLayout mIsDoingFullscreen:" + this.mIsDoingFullscreen + ",changed:" + z16);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildAt(0) != null) {
            getChildAt(0).measure(i3, i16);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        post(new Runnable() { // from class: com.tencent.hippy.qq.view.video.HippyQQVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                HippyQQVideoView hippyQQVideoView = HippyQQVideoView.this;
                hippyQQVideoView.forceViewMeasure(hippyQQVideoView);
            }
        });
        super.requestLayout();
    }

    public void setVideoViewControlListener(OnVideoViewControlListener onVideoViewControlListener) {
        this.mVideoViewControlListener = onVideoViewControlListener;
    }

    public void startHotSwap() {
        OnVideoViewControlListener onVideoViewControlListener = this.mVideoViewControlListener;
        if (onVideoViewControlListener != null) {
            onVideoViewControlListener.beforeChangeFullScreen(this);
        }
    }

    public void videoViewFireEvent(String str, HippyMap hippyMap) {
        ((EventDispatcher) this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), str, hippyMap);
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
