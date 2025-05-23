package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
class GpMsgHelperView extends FrameLayout implements HippyViewBase, GameContentView.a {

    /* renamed from: d, reason: collision with root package name */
    private GameSessionView f264552d;

    /* renamed from: e, reason: collision with root package name */
    private int f264553e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f264554f;

    public GpMsgHelperView(@NonNull Context context, int i3) {
        super(context);
        this.f264554f = false;
        this.f264553e = i3;
        d();
    }

    private void d() {
        QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView initView");
        GameSessionView gameSessionView = new GameSessionView(getContext());
        this.f264552d = gameSessionView;
        addView(gameSessionView, -1, -1);
        this.f264552d.q(MobileQQ.sMobileQQ.waitAppRuntime(null), this);
        this.f264552d.setVisibility(0);
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, HippyMap hippyMap) {
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.f264553e);
        if (engineInstance != null) {
            ((EventDispatcher) engineInstance.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, hippyMap);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.GameContentView.a
    public void M3() {
        QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView refreshGameContentView");
        e();
        if (this.f264554f) {
            this.f264554f = false;
            return;
        }
        GameSessionView gameSessionView = this.f264552d;
        if (gameSessionView != null) {
            if (gameSessionView.getVisibility() == 8) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("action", 5);
                hippyMap.pushInt("height", 0);
                f("onGameFeedsEvent", hippyMap);
                return;
            }
            this.f264552d.post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperView.1
                @Override // java.lang.Runnable
                public void run() {
                    GpMsgHelperView.this.f264552d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    float b16 = com.tencent.mobileqq.qqgamepub.utils.g.b(GpMsgHelperView.this.f264552d.getMeasuredHeight(), GpMsgHelperView.this.getResources());
                    QLog.d("QQGamePub_GpMsgHelperView", 1, "refreshGameContentView111 heightDp = " + b16);
                    HippyMap hippyMap2 = new HippyMap();
                    hippyMap2.pushInt("action", 5);
                    hippyMap2.pushInt("height", (int) b16);
                    GpMsgHelperView.this.f("onGameFeedsEvent", hippyMap2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.GameContentView.a
    public void O5(long j3) {
        QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView postDraw");
        this.f264554f = true;
        if (j3 == 0) {
            final HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("action", 5);
            hippyMap.pushInt("height", 0);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperView.2
                @Override // java.lang.Runnable
                public void run() {
                    GpMsgHelperView.this.f("onGameFeedsEvent", hippyMap);
                }
            }, 500L);
            return;
        }
        int i3 = (int) (500 + j3);
        try {
            View view = QQGameUIHelper.f264698a;
            if (view != null) {
                QQGameUIHelper.i(j3, this.f264552d, view);
                final HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushInt("action", 5);
                hippyMap2.pushInt("height", 0);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        GpMsgHelperView.this.f("onGameFeedsEvent", hippyMap2);
                    }
                }, i3);
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView destory");
        GameSessionView gameSessionView = this.f264552d;
        if (gameSessionView != null) {
            gameSessionView.s();
        }
    }

    public void e() {
        QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView postDraw");
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (getChildAt(0) != null) {
            getChildAt(0).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildAt(0) != null) {
            getChildAt(0).measure(i3, i16);
        }
    }

    public GpMsgHelperView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264553e = Integer.MIN_VALUE;
        this.f264554f = false;
        d();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
