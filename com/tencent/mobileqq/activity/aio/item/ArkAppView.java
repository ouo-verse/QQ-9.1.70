package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ArkAppView extends ArkTextureView implements ArkAppContainer.c {

    /* renamed from: d, reason: collision with root package name */
    public ArkAppLoadLayout f179281d;

    /* renamed from: e, reason: collision with root package name */
    private b f179282e;

    /* renamed from: f, reason: collision with root package name */
    private ArkViewModelBase.AppInfo f179283f;

    /* renamed from: h, reason: collision with root package name */
    f71.a f179284h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArkViewModel f179285d;

        a(ArkViewModel arkViewModel) {
            this.f179285d = arkViewModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ArkViewModel arkViewModel = this.f179285d;
            if (arkViewModel != null) {
                arkViewModel.reinitArkContainer();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
    }

    public ArkAppView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179282e = null;
        this.f179284h = null;
        l91.a.a();
        f71.a aVar = new f71.a(this);
        this.f179284h = aVar;
        setInputCallback(aVar);
    }

    private void d() {
        int i3;
        int i16;
        ArkViewModel viewModel = this.mViewImpl.getViewModel();
        if (viewModel != null) {
            if (viewModel instanceof ArkAppContainer) {
                ArkViewModelBase.Size g16 = ((ArkAppContainer) viewModel).g();
                if (g16 == null || (i16 = g16.height) <= 0) {
                    i16 = 0;
                }
                if (g16 == null || (i3 = g16.width) <= 0) {
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
            i16 = BaseAIOUtils.f(352.0f, this.f179281d.getResources());
        }
        if (i3 <= 0) {
            i3 = BaseChatItemLayout.N;
        }
        if (this.mViewImpl.mBorderType == 2 && i3 > BaseChatItemLayout.d()) {
            int d16 = BaseChatItemLayout.d() / 2;
            i3 -= d16;
            if (this.mViewImpl.mAlignLeft) {
                ArkAppLoadLayout arkAppLoadLayout = this.f179281d;
                arkAppLoadLayout.setPadding(d16, arkAppLoadLayout.getPaddingTop(), this.f179281d.getPaddingRight(), this.f179281d.getPaddingBottom());
            } else {
                ArkAppLoadLayout arkAppLoadLayout2 = this.f179281d;
                arkAppLoadLayout2.setPadding(arkAppLoadLayout2.getPaddingLeft(), this.f179281d.getPaddingTop(), d16, this.f179281d.getPaddingBottom());
            }
        }
        ViewGroup.LayoutParams layoutParams = this.f179281d.getLayoutParams();
        layoutParams.height = i16;
        layoutParams.width = i3;
        if (QLog.isColorLevel()) {
            QLog.i(ArkTextureView.TAG, 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", this, Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    private void e(View view, int i3) {
        View findViewById;
        RelativeLayout relativeLayout = (RelativeLayout) view.getParent();
        if (relativeLayout != null && (findViewById = relativeLayout.findViewById(R.id.f164453yc)) != null) {
            findViewById.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.c
    public void a(ArkAppContainer arkAppContainer, ArkAppLoadLayout arkAppLoadLayout) {
        c(arkAppContainer, arkAppLoadLayout, true);
    }

    public void c(ArkAppContainer arkAppContainer, ArkAppLoadLayout arkAppLoadLayout, boolean z16) {
        if (arkAppContainer == null) {
            return;
        }
        this.f179283f = arkAppContainer.d();
        this.f179281d = arkAppLoadLayout;
        if (arkAppLoadLayout != null) {
            arkAppLoadLayout.setArkView(this.mViewImpl);
        }
        this.mOnStartTemporaryDetach = arkAppContainer.isGpuRenderingEnabled();
        super.initArkView(arkAppContainer, z16);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public Rect getInputRect() {
        Rect inputRect = super.getInputRect();
        f71.a aVar = this.f179284h;
        if (aVar != null) {
            inputRect.bottom += aVar.a();
        }
        return inputRect;
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onFirstPaint() {
        b bVar = this.f179282e;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadFailed(String str, int i3, boolean z16) {
        int i16;
        if (this.f179281d == null) {
            return;
        }
        ArkViewModel viewModel = this.mViewImpl.getViewModel();
        if (viewModel != null && viewModel.GetAppScriptType() == 2 && !((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isJSCLibExist()) {
            QLog.i(ArkTextureView.TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
            onLoading();
            return;
        }
        ArkAppLoadLayout arkAppLoadLayout = this.f179281d;
        if (z16) {
            arkAppLoadLayout.setOnClickListener(new a(viewModel));
        } else {
            arkAppLoadLayout.setOnClickListener(null);
        }
        d();
        setVisibility(8);
        arkAppLoadLayout.setVisibility(0);
        View findViewById = arkAppLoadLayout.findViewById(R.id.loading);
        View findViewById2 = arkAppLoadLayout.findViewById(R.id.i5h);
        e(arkAppLoadLayout, 0);
        requestLayout();
        if (findViewById != null) {
            findViewById.setVisibility(4);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
            TextView textView = (TextView) findViewById2.findViewById(R.id.i5p);
            if (textView != null) {
                if (str == null) {
                    textView.setText(getResources().getString(R.string.f170470s5));
                } else {
                    textView.setText(str);
                }
            }
            View findViewById3 = findViewById2.findViewById(R.id.i5l);
            if (findViewById3 != null) {
                if (z16) {
                    i16 = R.drawable.c_j;
                } else {
                    i16 = R.drawable.c_i;
                }
                findViewById3.setBackgroundDrawable(findViewById3.getResources().getDrawable(i16));
            }
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadSuccess() {
        super.onLoadSuccess();
        if (this.f179282e != null && this.mViewImpl.mRectView.isEmpty()) {
            return;
        }
        ArkAppLoadLayout arkAppLoadLayout = this.f179281d;
        if (arkAppLoadLayout != null) {
            arkAppLoadLayout.setVisibility(8);
            e(arkAppLoadLayout, 8);
        }
        b bVar = this.f179282e;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoading() {
        setVisibility(8);
        ArkAppLoadLayout arkAppLoadLayout = this.f179281d;
        if (arkAppLoadLayout == null) {
            return;
        }
        d();
        arkAppLoadLayout.setVisibility(0);
        View findViewById = arkAppLoadLayout.findViewById(R.id.loading);
        View findViewById2 = arkAppLoadLayout.findViewById(R.id.i5h);
        e(arkAppLoadLayout, 0);
        requestLayout();
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(4);
        }
    }

    public void setCallback(b bVar) {
        this.f179282e = bVar;
    }

    public void setClickEnable(boolean z16) {
        if (z16) {
            setOnTouchListener(this);
        }
    }

    public void setInputHolderAnchor(ViewGroup viewGroup) {
        f71.a aVar = this.f179284h;
        if (aVar != null) {
            aVar.c(viewGroup);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public void setOnVisibleChangeListener(c cVar) {
    }
}
