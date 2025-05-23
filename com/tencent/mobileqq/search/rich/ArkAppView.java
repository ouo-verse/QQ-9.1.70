package com.tencent.mobileqq.search.rich;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.presenter.k;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ArkAppView extends ArkTextureView implements ArkViewImplement.LoadCallback {

    /* renamed from: d, reason: collision with root package name */
    private a f283725d;

    /* renamed from: e, reason: collision with root package name */
    protected k.d f283726e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onFirstFrame();

        void onLoadFailed(String str, int i3, boolean z16);

        void onLoadSuccess();

        void onLoading();
    }

    public ArkAppView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l91.a.a();
    }

    public void c(ArkNodeContainer arkNodeContainer, a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(ArkTextureView.TAG, 2, "init");
        }
        if (arkNodeContainer == null) {
            return;
        }
        this.f283725d = aVar;
        super.initArkView(arkNodeContainer);
        setOnTouchListener(this);
        setLoadCallback(this);
    }

    public void d() {
        this.f283725d = null;
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onFirstPaint() {
        a aVar = this.f283725d;
        if (aVar != null) {
            aVar.onFirstFrame();
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    @TargetApi(14)
    public void onLoadFailed(int i3, int i16, String str, boolean z16) {
    }

    @Override // com.tencent.ark.ArkViewImplement.LoadCallback
    @TargetApi(14)
    public void onLoadState(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(ArkTextureView.TAG, 2, "attachArkView onLoadFinish state=" + i3);
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadSuccess() {
        if (QLog.isColorLevel()) {
            QLog.d(ArkTextureView.TAG, 2, "onLoadSuccess");
        }
        super.onLoadSuccess();
        a aVar = this.f283725d;
        if (aVar != null) {
            aVar.onLoadSuccess();
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoading() {
        if (QLog.isColorLevel()) {
            QLog.d(ArkTextureView.TAG, 2, "onLoading");
        }
        setVisibility(8);
        a aVar = this.f283725d;
        if (aVar != null) {
            aVar.onLoading();
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        k.d dVar;
        if (motionEvent.getAction() == 1 && (dVar = this.f283726e) != null) {
            dVar.onAction();
        }
        return super.onTouch(view, motionEvent);
    }

    public void setOnActionListener(k.d dVar) {
        this.f283726e = dVar;
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadFailed(String str, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(ArkTextureView.TAG, 2, "onLoadFailed");
        }
        ArkViewModel viewModel = this.mViewImpl.getViewModel();
        if (viewModel == null) {
            return;
        }
        if (viewModel.GetAppScriptType() == 2 && !((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isJSCLibExist()) {
            QLog.e(ArkTextureView.TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
            onLoading();
            return;
        }
        setVisibility(8);
        a aVar = this.f283725d;
        if (aVar != null) {
            aVar.onLoadFailed(str, i3, z16);
        }
    }
}
