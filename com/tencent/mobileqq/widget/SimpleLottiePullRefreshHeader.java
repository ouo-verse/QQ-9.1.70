package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qui.dragrefresh.QUIDragRefreshView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.friend.contact.api.IContactApi;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes20.dex */
public class SimpleLottiePullRefreshHeader extends RelativeLayout implements q, ListView.OnSpringBackListener {
    private static HashMap<Class, Class> C;

    /* renamed from: d, reason: collision with root package name */
    private int f316244d;

    /* renamed from: e, reason: collision with root package name */
    private Context f316245e;

    /* renamed from: f, reason: collision with root package name */
    protected View f316246f;

    /* renamed from: h, reason: collision with root package name */
    protected wc1.a f316247h;

    /* renamed from: i, reason: collision with root package name */
    public long f316248i;

    /* renamed from: m, reason: collision with root package name */
    private int f316249m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SimpleLottiePullRefreshHeader.this.f316246f.setScaleY(floatValue);
            SimpleLottiePullRefreshHeader.this.f316246f.setScaleX(floatValue);
        }
    }

    static {
        HashMap<Class, Class> hashMap = new HashMap<>();
        C = hashMap;
        hashMap.put(RefreshView.class, ((IContactApi) QRoute.api(IContactApi.class)).getContactRefreshViewWrapClass());
        C.put(QUIDragRefreshView.class, ((IContactApi) QRoute.api(IContactApi.class)).getContactDragRefreshViewWrapClass());
    }

    public SimpleLottiePullRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316244d = 0;
        this.f316248i = 0L;
        this.f316249m = 0;
        this.f316245e = context;
    }

    private void n() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101640", false);
        if (QLog.isColorLevel()) {
            QLog.i("SimpleLottiePullRefreshHeader", 1, "useNewPullRefreshView: " + isSwitchOn);
        }
        if (isSwitchOn) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f72273qe);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f316246f.getLayoutParams();
            int dip2px = DisplayUtil.dip2px(this.f316245e, 66.0f);
            layoutParams.height = dip2px;
            layoutParams.width = dip2px;
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            int id5 = this.f316246f.getId();
            relativeLayout.removeAllViews();
            QUIDragRefreshView qUIDragRefreshView = new QUIDragRefreshView(this.f316245e);
            this.f316246f = qUIDragRefreshView;
            qUIDragRefreshView.setId(id5);
            relativeLayout.addView(this.f316246f, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams2.height = DisplayUtil.dip2px(this.f316245e, 82.0f);
            layoutParams2.width = -1;
            relativeLayout.setLayoutParams(layoutParams2);
        }
    }

    public Object f(int i3, Object obj) {
        boolean z16;
        if (i3 == 6) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f72273qe);
            if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        if (i3 == 8) {
            return Integer.valueOf(indexOfChild((View) obj));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void h(long j3) {
        if (this.f316246f.getVisibility() != 0) {
            this.f316246f.setVisibility(0);
            this.f316246f.setScaleX(1.0f);
            this.f316246f.setScaleY(1.0f);
        }
        this.f316247h.a();
        this.f316249m = 3;
    }

    public void j(int i3, Object obj) {
        if (i3 == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f72273qe);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.addRule(12);
            relativeLayout.setLayoutParams(layoutParams);
            try {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.skin_refresh_background));
                return;
            } catch (Exception e16) {
                QLog.d("SimpleLottiePullRefreshHeader", 1, "setBackgroundColor failed: " + e16);
                return;
            }
        }
        if (i3 == 2) {
            View view = (View) obj;
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.lts);
            if (indexOfChild(view) < 0) {
                viewGroup.addView(view);
            }
            viewGroup.setVisibility(0);
            return;
        }
        if (i3 == 3) {
            o(((Float) obj).floatValue());
            return;
        }
        if (i3 == 4) {
            ((RelativeLayout) findViewById(R.id.f72273qe)).setVisibility(((Integer) obj).intValue());
            return;
        }
        if (i3 == 10) {
            removeView((View) obj);
            return;
        }
        if (i3 == 14) {
            ((RelativeLayout) findViewById(R.id.f72273qe)).setBackgroundColor(((Integer) obj).intValue());
            return;
        }
        if (i3 == 21) {
            this.f316246f.setVisibility(8);
            this.f316249m = 2;
        } else if (i3 == 22) {
            ((RelativeLayout.LayoutParams) ((RelativeLayout) findViewById(R.id.lts)).getLayoutParams()).bottomMargin = ((Integer) obj).intValue();
        } else if (i3 == 24) {
            m();
        } else if (i3 == 27) {
            this.f316247h.b();
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public long k() {
        return this.f316248i;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void l(int i3) {
        this.f316247h.b();
    }

    protected void m() {
        this.f316247h.onPostThemeChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(float f16) {
        float c16 = this.f316247h.c(f16);
        if (c16 < 0.0f) {
            return;
        }
        this.f316247h.setProgress(c16);
        this.f316249m = 1;
    }

    @Override // android.view.View
    @SuppressLint({"WrongViewCast"})
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f316246f = findViewById(R.id.f72393qq);
        n();
        try {
            this.f316247h = (wc1.a) C.get(this.f316246f.getClass()).getConstructor(this.f316246f.getClass()).newInstance(this.f316246f);
        } catch (IllegalAccessException e16) {
            throw new RuntimeException(e16);
        } catch (InstantiationException e17) {
            throw new RuntimeException(e17);
        } catch (NoSuchMethodException e18) {
            throw new RuntimeException(e18);
        } catch (InvocationTargetException e19) {
            throw new RuntimeException(e19);
        }
    }

    @Override // com.tencent.widget.ListView.OnSpringBackListener
    public void onSpringBack() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.SimpleLottiePullRefreshHeader.2
            @Override // java.lang.Runnable
            public void run() {
                SimpleLottiePullRefreshHeader.this.f316246f.setVisibility(4);
                SimpleLottiePullRefreshHeader.this.f316247h.setProgress(0.0f);
            }
        }, 100L);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgColor(int i3) {
        setBackgroundColor(i3);
    }

    @Override // com.tencent.mobileqq.widget.p
    @TargetApi(16)
    public void setHeaderBgDrawable(Drawable drawable) {
        setBackground(drawable);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgRes(int i3) {
        setBackgroundResource(i3);
    }

    public void setPullType(int i3) {
        if (this.f316244d != i3) {
            this.f316244d = i3;
        }
    }

    public SimpleLottiePullRefreshHeader(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316244d = 0;
        this.f316248i = 0L;
        this.f316249m = 0;
        this.f316245e = context;
    }

    @Override // com.tencent.mobileqq.widget.p
    public View b() {
        return this;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void g() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void d(long j3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void i(long j3) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void c(int i3, String str) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setTextColor(int i3, int i16, int i17, int i18, int i19) {
    }
}
