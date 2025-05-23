package com.qzone.reborn.qzmoment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.richframework.widget.refresh.layout.util.SmartUtil;
import sn.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFeedRefreshHeader extends LinearLayout implements IRefreshHeader {

    /* renamed from: d, reason: collision with root package name */
    private TextView f59049d;

    /* renamed from: e, reason: collision with root package name */
    private QZMPathsView f59050e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f59051f;

    /* renamed from: h, reason: collision with root package name */
    private d f59052h;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f59053a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f59053a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59053a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f59053a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f59053a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public QZMFeedRefreshHeader(Context context) {
        super(context);
        a(context);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int i3, float f16, boolean z16) {
        return false;
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
        this.f59052h.stop();
        if (z16) {
            this.f59049d.setText("\u5237\u65b0\u5b8c\u6210");
            return 500;
        }
        this.f59049d.setText("\u5237\u65b0\u5931\u8d25");
        return 500;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(IRefreshLayout iRefreshLayout, int i3, int i16) {
        this.f59052h.start();
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(IRefreshLayout iRefreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i3 = a.f59053a[refreshState2.ordinal()];
        if (i3 == 1 || i3 == 2) {
            this.f59049d.setText("\u4e0b\u62c9\u5f00\u59cb\u5237\u65b0");
            this.f59050e.setVisibility(0);
            this.f59051f.setVisibility(8);
            this.f59050e.animate().rotation(0.0f);
            return;
        }
        if (i3 == 3) {
            this.f59049d.setText("\u6b63\u5728\u5237\u65b0");
            this.f59051f.setVisibility(0);
            this.f59050e.setVisibility(8);
        } else {
            if (i3 != 4) {
                return;
            }
            this.f59049d.setText("\u91ca\u653e\u7acb\u5373\u5237\u65b0");
            this.f59050e.animate().rotation(180.0f);
        }
    }

    public QZMFeedRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        setGravity(17);
        this.f59049d = new TextView(context);
        this.f59052h = new d();
        this.f59050e = new QZMPathsView(context);
        ImageView imageView = new ImageView(context);
        this.f59051f = imageView;
        imageView.setImageDrawable(this.f59052h);
        this.f59050e.a("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
        addView(this.f59051f, SmartUtil.dp2px(20.0f), SmartUtil.dp2px(20.0f));
        addView(this.f59050e, SmartUtil.dp2px(20.0f), SmartUtil.dp2px(20.0f));
        addView(new View(context), SmartUtil.dp2px(20.0f), SmartUtil.dp2px(20.0f));
        addView(this.f59049d, -2, -2);
        setMinimumHeight(SmartUtil.dp2px(60.0f));
    }

    public QZMFeedRefreshHeader(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public View getView() {
        return this;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void setPrimaryColors(int... iArr) {
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
    public void onMoving(boolean z16, float f16, int i3, int i16, int i17) {
    }
}
