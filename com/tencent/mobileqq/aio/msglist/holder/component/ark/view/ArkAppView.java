package com.tencent.mobileqq.aio.msglist.holder.component.ark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.aio.BaseArkAppView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppLoadLayout;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppView extends BaseArkAppView {

    /* renamed from: d, reason: collision with root package name */
    public ArkAppLoadLayout f190681d;

    /* renamed from: e, reason: collision with root package name */
    private b f190682e;

    /* renamed from: f, reason: collision with root package name */
    private String f190683f;

    /* renamed from: h, reason: collision with root package name */
    private MsgRecord f190684h;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArkViewModel f190685d;

        a(ArkViewModel arkViewModel) {
            this.f190685d = arkViewModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ArkViewModel arkViewModel = this.f190685d;
            if (arkViewModel != null) {
                arkViewModel.reinitArkContainer();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void onFirstPaint();

        void onLoadSuccess();
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
    }

    public ArkAppView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f190682e = null;
        ((IArkApi) com.tencent.qqnt.aio.adapter.a.b(IArkApi.class)).initArkEnv();
        setOnTouchListener(this);
    }

    private void e() {
        int i3;
        int i16;
        ArkViewModel viewModel = this.mViewImpl.getViewModel();
        if (viewModel != null) {
            if (viewModel instanceof ArkAppContainer) {
                ArkViewModelBase.Size f16 = ((ArkAppContainer) viewModel).f();
                if (f16 == null || (i16 = f16.height) <= 0) {
                    i16 = 0;
                }
                if (f16 == null || (i3 = f16.width) <= 0) {
                    i3 = 0;
                }
            } else {
                i3 = 0;
                i16 = 0;
            }
            ArkViewModelBase.Size containerHintSize = viewModel.getContainerHintSize();
            if (i16 <= 0) {
                i16 = (int) (containerHintSize.height * this.mViewImpl.mScale);
            }
            if (i3 <= 0) {
                i3 = (int) (containerHintSize.width * this.mViewImpl.mScale);
            }
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i16 <= 0) {
            i16 = ViewUtils.dip2px(352.0f);
        }
        if (i3 <= 0) {
            i3 = a.C7329a.f192417a.b();
        }
        int dip2px = ViewUtils.dip2px(8.0f);
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement.mBorderType == 2 && i3 > dip2px) {
            int i17 = dip2px / 2;
            i3 -= i17;
            if (arkViewImplement.mAlignLeft) {
                ArkAppLoadLayout arkAppLoadLayout = this.f190681d;
                arkAppLoadLayout.setPadding(i17, arkAppLoadLayout.getPaddingTop(), this.f190681d.getPaddingRight(), this.f190681d.getPaddingBottom());
            } else {
                ArkAppLoadLayout arkAppLoadLayout2 = this.f190681d;
                arkAppLoadLayout2.setPadding(arkAppLoadLayout2.getPaddingLeft(), this.f190681d.getPaddingTop(), i17, this.f190681d.getPaddingBottom());
            }
        }
        ViewGroup.LayoutParams layoutParams = this.f190681d.getLayoutParams();
        layoutParams.height = i16;
        layoutParams.width = i3;
        if (QLog.isColorLevel()) {
            QLog.i(ArkTextureView.TAG, 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", this, Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    private void f(View view, int i3) {
        View findViewById;
        RelativeLayout relativeLayout = (RelativeLayout) view.getParent();
        if (relativeLayout != null && (findViewById = relativeLayout.findViewById(R.id.f164453yc)) != null) {
            findViewById.setVisibility(i3);
        }
    }

    public String c() {
        return this.f190683f;
    }

    public void d(ArkAppContainer arkAppContainer, ArkAppLoadLayout arkAppLoadLayout, boolean z16) {
        if (arkAppContainer == null) {
            return;
        }
        this.f190681d = arkAppLoadLayout;
        if (arkAppLoadLayout != null) {
            arkAppLoadLayout.setArkView(this.mViewImpl);
        }
        this.mOnStartTemporaryDetach = arkAppContainer.isGpuRenderingEnabled();
        super.initArkView(arkAppContainer, z16);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onFirstPaint() {
        b bVar = this.f190682e;
        if (bVar != null) {
            bVar.onFirstPaint();
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadFailed(String str, int i3, boolean z16) {
        if (this.f190681d == null) {
            return;
        }
        ArkViewModel viewModel = this.mViewImpl.getViewModel();
        if (viewModel != null && viewModel.GetAppScriptType() == 2) {
            if (QLog.isColorLevel()) {
                QLog.i(ArkTextureView.TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
            }
            onLoading();
            return;
        }
        ArkAppLoadLayout arkAppLoadLayout = this.f190681d;
        if (z16) {
            arkAppLoadLayout.setOnClickListener(new a(viewModel));
        } else {
            arkAppLoadLayout.setOnClickListener(null);
        }
        e();
        setVisibility(8);
        arkAppLoadLayout.setVisibility(0);
        f(arkAppLoadLayout, 0);
        arkAppLoadLayout.b(str, z16);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadSuccess() {
        super.onLoadSuccess();
        if (this.f190682e != null && this.mViewImpl.mRectView.isEmpty()) {
            return;
        }
        ArkAppLoadLayout arkAppLoadLayout = this.f190681d;
        if (arkAppLoadLayout != null) {
            arkAppLoadLayout.setVisibility(8);
            f(arkAppLoadLayout, 8);
        }
        b bVar = this.f190682e;
        if (bVar != null) {
            bVar.onLoadSuccess();
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoading() {
        setVisibility(8);
        ArkAppLoadLayout arkAppLoadLayout = this.f190681d;
        if (arkAppLoadLayout == null) {
            return;
        }
        e();
        arkAppLoadLayout.setVisibility(0);
        arkAppLoadLayout.c();
        f(arkAppLoadLayout, 0);
        requestLayout();
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    public void setCallback(b bVar) {
        this.f190682e = bVar;
    }

    public void setMsgRecord(MsgRecord msgRecord) {
        this.f190684h = msgRecord;
    }

    public void setViewKey(String str) {
        this.f190683f = str;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public void setOnVisibleChangeListener(c cVar) {
    }
}
