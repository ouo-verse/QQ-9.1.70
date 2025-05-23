package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes22.dex */
public class AuthorityControlRefreshHeader extends FrameLayout implements IRefreshHeader {

    /* renamed from: d, reason: collision with root package name */
    private ProgressBar f339571d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f339572e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f339573f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f339574h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f339575i;

    /* renamed from: m, reason: collision with root package name */
    private static final String f339570m = HardCodeUtil.qqStr(R.string.hqh);
    private static final String C = HardCodeUtil.qqStr(R.string.hqg);
    private static final String D = HardCodeUtil.qqStr(R.string.hqj);
    private static final String E = HardCodeUtil.qqStr(R.string.hqk);
    private static final String F = HardCodeUtil.qqStr(R.string.hqe);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f339576a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f339576a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f339576a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f339576a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f339576a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AuthorityControlRefreshHeader(@NonNull Context context) {
        this(context, null);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void a(Context context) {
        View.inflate(context, R.layout.dzf, this);
        this.f339571d = (ProgressBar) findViewById(R.id.i5n);
        this.f339571d.setIndeterminateDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        this.f339571d.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.i5p);
        this.f339573f = textView;
        textView.setText(f339570m);
        this.f339572e = (ImageView) findViewById(R.id.i5l);
        this.f339574h = context.getResources().getDrawable(R.drawable.qui_arrowhead_down);
        this.f339575i = context.getResources().getDrawable(R.drawable.qui_arrowhead_up);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int i3, float f16, boolean z16) {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NonNull
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public int onFinish(@NonNull IRefreshLayout iRefreshLayout, boolean z16) {
        String str;
        this.f339571d.setVisibility(8);
        this.f339572e.setVisibility(8);
        TextView textView = this.f339573f;
        if (z16) {
            str = E;
        } else {
            str = F;
        }
        textView.setText(str);
        return 800;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull IRefreshLayout iRefreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        int i3 = a.f339576a[refreshState2.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    this.f339573f.setText(D);
                    this.f339572e.setImageDrawable(this.f339575i);
                    this.f339571d.setVisibility(8);
                    return;
                }
                return;
            }
            this.f339573f.setText(C);
            this.f339571d.setVisibility(0);
            this.f339572e.setVisibility(8);
            return;
        }
        this.f339573f.setText(f339570m);
        this.f339572e.setVisibility(0);
        this.f339572e.setImageDrawable(this.f339574h);
        this.f339571d.setVisibility(8);
    }

    public AuthorityControlRefreshHeader(@NonNull Context context, @Nullable @org.jetbrains.annotations.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NonNull
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
    public void onInitialized(@NonNull IRefreshKernel iRefreshKernel, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onReleased(@NonNull IRefreshLayout iRefreshLayout, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(@NonNull IRefreshLayout iRefreshLayout, int i3, int i16) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onMoving(boolean z16, float f16, int i3, int i16, int i17) {
    }
}
