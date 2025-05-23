package com.qzone.reborn.feedx.widget.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.util.LoadingUtil;

/* loaded from: classes37.dex */
public class QZoneOnlyProgressRefreshHeader extends QZoneBaseWidgetView implements IRefreshHeader {

    /* renamed from: e, reason: collision with root package name */
    private ProgressBar f56515e;

    /* loaded from: classes37.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56516a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f56516a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56516a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56516a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56516a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public QZoneOnlyProgressRefreshHeader(Context context) {
        this(context, null);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int i3, float f16, boolean z16) {
        return false;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cm7;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public int onFinish(IRefreshLayout iRefreshLayout, boolean z16) {
        this.f56515e.setVisibility(8);
        return 500;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(IRefreshLayout iRefreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i3 = a.f56516a[refreshState2.ordinal()];
        if (i3 == 1) {
            this.f56515e.setVisibility(8);
        } else if (i3 == 2 || i3 == 3) {
            this.f56515e.setVisibility(0);
        }
    }

    public QZoneOnlyProgressRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m0(context);
    }

    private void m0(Context context) {
        this.f56515e = (ProgressBar) findViewById(R.id.nea);
        this.f56515e.setIndeterminateDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public View getView() {
        return this;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void setPrimaryColors(int... iArr) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onHorizontalDrag(float f16, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onInitialized(IRefreshKernel iRefreshKernel, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onReleased(IRefreshLayout iRefreshLayout, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(IRefreshLayout iRefreshLayout, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onMoving(boolean z16, float f16, int i3, int i16, int i17) {
    }
}
