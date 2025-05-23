package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.open.ArkView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HippyArkView extends LinearLayout implements ArkViewImplement.LoadCallback, HippyViewBase {

    /* renamed from: d, reason: collision with root package name */
    private ArkView f264557d;

    /* renamed from: e, reason: collision with root package name */
    private QQGameMsgInfo f264558e;

    /* renamed from: f, reason: collision with root package name */
    private long f264559f;

    public HippyArkView(Context context) {
        super(context);
        d();
    }

    private void d() {
        ViewGroup.LayoutParams layoutParams;
        LayoutInflater.from(getContext()).inflate(R.layout.ebd, this);
        this.f264557d = (ArkView) findViewById(R.id.cvu);
        i f16 = x.f(getContext());
        if (f16.f185860a < com.tencent.mobileqq.qqgamepub.utils.g.a(350.0f, getResources()) && (layoutParams = this.f264557d.getLayoutParams()) != null) {
            layoutParams.width = f16.f185860a;
            this.f264557d.setLayoutParams(layoutParams);
        }
    }

    public void a() {
        QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView destory");
        ArkView arkView = this.f264557d;
        if (arkView != null) {
            arkView.onDestroy();
        }
    }

    public void b(QQGameMsgInfo qQGameMsgInfo) {
        QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView init");
        if (this.f264557d != null) {
            g();
            this.f264558e = qQGameMsgInfo;
            this.f264557d.getViewTreeObserver().dispatchOnGlobalLayout();
            ArkViewModelBase.clearAppSizeHintCache(qQGameMsgInfo.arkAppName, qQGameMsgInfo.arkAppView);
            this.f264557d.load(qQGameMsgInfo.arkAppName, qQGameMsgInfo.arkAppView, qQGameMsgInfo.arkAppMinVersion, qQGameMsgInfo.arkMetaList, qQGameMsgInfo.arkAppConfig, this);
            this.f264559f = SystemClock.elapsedRealtime();
        }
    }

    public void c(HippyArray hippyArray) {
        QQGameMsgInfo qQGameMsgInfo = new QQGameMsgInfo();
        qQGameMsgInfo.arkAppName = hippyArray.getString(0);
        qQGameMsgInfo.arkAppView = hippyArray.getString(1);
        qQGameMsgInfo.arkAppMinVersion = hippyArray.getString(2);
        qQGameMsgInfo.arkMetaList = hippyArray.getString(3);
        qQGameMsgInfo.arkAppConfig = hippyArray.getString(4);
        qQGameMsgInfo.paMsgid = hippyArray.getString(5);
        b(qQGameMsgInfo);
    }

    public void e() {
        QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView onAfterUpdateProps ");
    }

    public void f() {
        QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView pause");
        ArkView arkView = this.f264557d;
        if (arkView != null) {
            arkView.onPause();
        }
    }

    public void g() {
        QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView postDraw");
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public void h() {
        QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView resume");
        ArkView arkView = this.f264557d;
        if (arkView != null) {
            arkView.onResume();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (getChildAt(0) != null) {
            getChildAt(0).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    public void onLoadFailed(int i3, int i16, String str, boolean z16) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_HippyArkView", 1, "onLoadFailed");
        }
        if (this.f264558e != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f264559f;
            WadlReportBuilder gameAppId = GamePubAccountHelper.r(GamePubAccountHelper.s()).setModuleType("76918").setOperId("207984").setExt(2, this.f264558e.advId).setGameAppId(this.f264558e.gameAppId);
            if (elapsedRealtime <= 0) {
                str2 = "";
            } else {
                str2 = String.valueOf(elapsedRealtime);
            }
            gameAppId.setExt(17, str2).setExt(18, this.f264558e.arkAppName).setExt(19, i3 + "").setExt(20, i16 + "").setExt(21, str).setExt(22, z16 + "").report();
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    public void onLoadState(int i3) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_HippyArkView", 1, "onLoadState state=" + i3);
        }
        if (this.f264558e != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f264559f;
            WadlReportBuilder gameAppId = GamePubAccountHelper.r(GamePubAccountHelper.s()).setModuleType("76918").setOperId("207984").setExt(2, this.f264558e.advId).setGameAppId(this.f264558e.gameAppId);
            if (elapsedRealtime <= 0) {
                str = "";
            } else {
                str = String.valueOf(elapsedRealtime);
            }
            gameAppId.setExt(17, str).setExt(18, this.f264558e.arkAppName).setExt(29, i3 + "").report();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildAt(0) != null) {
            getChildAt(0).measure(i3, i16);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
