package com.qzone.reborn.feedx.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneListRefreshHeader extends QZoneBaseWidgetView implements IRefreshHeader {

    /* renamed from: e, reason: collision with root package name */
    private ProgressBar f55944e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f55945f;

    /* renamed from: h, reason: collision with root package name */
    private static final String f55941h = HardCodeUtil.qqStr(R.string.f133546e);

    /* renamed from: i, reason: collision with root package name */
    private static final String f55942i = HardCodeUtil.qqStr(R.string.f133536d);

    /* renamed from: m, reason: collision with root package name */
    private static final String f55943m = HardCodeUtil.qqStr(R.string.f133556f);
    private static final String C = HardCodeUtil.qqStr(R.string.f133566g);
    private static final String D = HardCodeUtil.qqStr(R.string.f133526c);

    /* compiled from: P */
    /* loaded from: classes37.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f55946a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f55946a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f55946a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f55946a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f55946a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public QZoneListRefreshHeader(Context context) {
        this(context, null);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int i3, float f16, boolean z16) {
        return false;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129686q;
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
        this.f55944e.setVisibility(8);
        if (z16) {
            this.f55945f.setText(C);
            return 500;
        }
        this.f55945f.setText(D);
        return 500;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(IRefreshLayout iRefreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i3 = a.f55946a[refreshState2.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.f55945f.setText(f55941h);
            this.f55944e.setVisibility(8);
        } else if (i3 == 3) {
            this.f55945f.setText(f55942i);
            this.f55944e.setVisibility(0);
        } else {
            if (i3 != 4) {
                return;
            }
            this.f55945f.setText(f55943m);
        }
    }

    public QZoneListRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m0();
    }

    private void m0() {
        this.f55944e = (ProgressBar) findViewById(R.id.nea);
        this.f55945f = (TextView) findViewById(R.id.ne9);
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
