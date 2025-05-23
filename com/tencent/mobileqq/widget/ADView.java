package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.WorkSpaceView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ADView extends LinearLayout {
    protected int C;
    protected int D;
    protected boolean E;
    public final String F;
    protected boolean G;
    private b H;

    /* renamed from: d, reason: collision with root package name */
    protected int f315348d;

    /* renamed from: e, reason: collision with root package name */
    protected int f315349e;

    /* renamed from: f, reason: collision with root package name */
    protected LinearLayout f315350f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f315351h;

    /* renamed from: i, reason: collision with root package name */
    protected WorkSpaceView f315352i;

    /* renamed from: m, reason: collision with root package name */
    protected float f315353m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements WorkSpaceView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayout f315354a;

        a(LinearLayout linearLayout) {
            this.f315354a = linearLayout;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0024, code lost:
        
            if (r5 == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x002b, code lost:
        
            if (r5 == r0) goto L11;
         */
        @Override // com.tencent.mobileqq.widget.WorkSpaceView.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i3) {
            View childAt;
            int childCount = this.f315354a.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = this.f315354a.getChildAt(i16);
                if (childAt2 != null) {
                    childAt2.setEnabled(false);
                }
            }
            if (ADView.this.G) {
                if (i3 != -1) {
                }
                i3 = childCount - 1;
            } else {
                if (i3 != -1) {
                }
                i3 = 0;
            }
            if (i3 > -1 && i3 < childCount && (childAt = this.f315354a.getChildAt(i3)) != null) {
                childAt.setEnabled(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ADView> f315356a;

        /* renamed from: b, reason: collision with root package name */
        private ADView f315357b;

        public b(ADView aDView) {
            this.f315356a = new WeakReference<>(aDView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WorkSpaceView workSpaceView;
            int i3;
            int i16 = message.what;
            if (i16 != 0) {
                if (i16 == 1) {
                    removeMessages(0);
                }
            } else {
                ADView aDView = this.f315356a.get();
                this.f315357b = aDView;
                if (aDView != null && (workSpaceView = aDView.f315352i) != null) {
                    if (workSpaceView.getChildCount() > 1 && this.f315357b.f315352i.getWidth() > 0) {
                        WorkSpaceView workSpaceView2 = this.f315357b.f315352i;
                        workSpaceView2.e(workSpaceView2.b() + 1);
                    }
                    try {
                        WorkSpaceView workSpaceView3 = this.f315357b.f315352i;
                        com.tencent.mobileqq.struct.a aVar = (com.tencent.mobileqq.struct.a) workSpaceView3.getChildAt(workSpaceView3.b()).getTag();
                        i3 = aVar.f290272d * 1000;
                        this.f315357b.setContentDescription(aVar.f290284p);
                    } catch (Exception unused) {
                        i3 = 5000;
                    }
                    sendEmptyMessageDelayed(0, i3);
                    this.f315357b = null;
                } else {
                    return;
                }
            }
            super.handleMessage(message);
        }
    }

    public ADView(Context context) {
        super(context);
        this.f315348d = R.drawable.f160051a1;
        this.f315349e = R.drawable.f160051a1;
        this.f315351h = false;
        this.f315352i = null;
        this.f315353m = getResources().getDisplayMetrics().density;
        this.C = 2;
        this.D = 0;
        this.E = true;
        this.F = "ADView";
        this.G = true;
        this.H = new b(this);
        g(context);
    }

    protected void a(LinearLayout linearLayout, boolean z16) {
        LinearLayout.LayoutParams layoutParams;
        ImageView imageView = new ImageView(getContext());
        if (this.D > 0) {
            int i3 = this.D;
            float f16 = this.f315353m;
            layoutParams = new LinearLayout.LayoutParams((int) (i3 * f16), (int) (i3 * f16));
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        int i16 = 0;
        layoutParams.setMargins(0, 0, (int) (this.C * this.f315353m), 0);
        imageView.setLayoutParams(layoutParams);
        try {
            imageView.setImageDrawable(getContext().getResources().getDrawable(this.f315349e));
            if (z16) {
                imageView.setEnabled(true);
            } else {
                imageView.setEnabled(false);
            }
        } catch (Exception unused) {
            imageView.setImageResource(this.f315348d);
        }
        linearLayout.addView(imageView);
        if (linearLayout.getChildCount() <= 1) {
            i16 = 4;
        }
        linearLayout.setVisibility(i16);
    }

    public void b(View view, int i3) {
        LinearLayout linearLayout;
        boolean z16 = true;
        if (this.f315350f.getChildCount() == 0) {
            this.f315350f.setPadding(0, 0, 0, 0);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout = new LinearLayout(getContext());
            this.f315352i = new WorkSpaceView(getContext());
            setCircle(this.G);
            this.f315352i.setOnScreenChangeListener(new a(linearLayout));
            this.f315352i.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.f315352i.setId(100000);
            relativeLayout.addView(this.f315352i, layoutParams);
            h(linearLayout);
            relativeLayout.addView(linearLayout);
            this.f315350f.addView(relativeLayout, new LinearLayout.LayoutParams(-1, -1));
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f315350f.getChildAt(0);
            this.f315352i = (WorkSpaceView) viewGroup.getChildAt(0);
            z16 = false;
            linearLayout = (LinearLayout) viewGroup.getChildAt(1);
        }
        try {
            WorkSpaceView workSpaceView = this.f315352i;
            workSpaceView.addView(view, workSpaceView.getChildCount());
            a(linearLayout, z16);
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent.banner", 4, "addViewToWorkspace");
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        int i3;
        this.H.removeMessages(0);
        try {
            WorkSpaceView workSpaceView = this.f315352i;
            com.tencent.mobileqq.struct.a aVar = (com.tencent.mobileqq.struct.a) workSpaceView.getChildAt(workSpaceView.b()).getTag();
            i3 = aVar.f290272d * 1000;
            setContentDescription(aVar.f290284p);
        } catch (Exception unused) {
            i3 = 5000;
        }
        this.H.sendEmptyMessageDelayed(0, i3);
    }

    public void d() {
        this.H.sendEmptyMessage(1);
    }

    public boolean e() {
        return this.G;
    }

    public ViewGroup f(int i3) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f315350f.getChildAt(i3);
        if (relativeLayout != null) {
            return (WorkSpaceView) relativeLayout.getChildAt(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Context context) {
        setPadding(0, 0, 0, 0);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f315350f = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
    }

    protected void h(LinearLayout linearLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, 100000);
        layoutParams.addRule(14, 100000);
        layoutParams.setMargins(0, 0, 0, (int) (this.f315353m * 6.0f));
        linearLayout.setGravity(16);
        linearLayout.setBackgroundResource(R.drawable.bqj);
        float f16 = this.f315353m;
        linearLayout.setPadding((int) (4.0f * f16), 0, (int) (f16 * 2.0f), 0);
        linearLayout.setLayoutParams(layoutParams);
    }

    public void i() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f315350f.getChildAt(0);
        if (relativeLayout == null) {
            return;
        }
        ((WorkSpaceView) relativeLayout.getChildAt(0)).removeAllViews();
        this.f315350f.removeAllViews();
    }

    public void j(int i3, int i16) {
        int i17;
        try {
            QZLog.i("removeFromWorkSpace", "@newcard TABINDEX " + i3 + "page" + i16);
            ViewGroup viewGroup = (ViewGroup) this.f315350f.getChildAt(i3);
            WorkSpaceView workSpaceView = (WorkSpaceView) viewGroup.getChildAt(0);
            workSpaceView.removeViewAt(i16);
            LinearLayout linearLayout = (LinearLayout) viewGroup.getChildAt(1);
            linearLayout.removeViewAt(i16);
            if (linearLayout.getChildCount() > 1) {
                i17 = 0;
            } else {
                i17 = 4;
            }
            linearLayout.setVisibility(i17);
            if (i16 > 0) {
                workSpaceView.e(i16 - 1);
            }
        } catch (Exception e16) {
            for (int i18 = 0; i18 < this.f315350f.getChildCount() - 1; i18++) {
                QZLog.i("ADView", "@newcard " + this.f315350f.getChildAt(i18).getClass());
            }
            QZLog.i("ADView", 2, "@newcard  ", e16);
        }
    }

    public void k(int i3, int i16, View view) {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) this.f315350f.getChildAt(i3);
            int i17 = 0;
            WorkSpaceView workSpaceView = (WorkSpaceView) relativeLayout.getChildAt(0);
            workSpaceView.removeView(view);
            LinearLayout linearLayout = (LinearLayout) relativeLayout.getChildAt(1);
            linearLayout.removeViewAt(i16);
            if (linearLayout.getChildCount() <= 1) {
                i17 = 4;
            }
            linearLayout.setVisibility(i17);
            if (i16 > 0) {
                workSpaceView.e(i16 - 1);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.E) {
            int action = motionEvent.getAction();
            if (action == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCircle(boolean z16) {
        WorkSpaceView workSpaceView = this.f315352i;
        if (workSpaceView != null) {
            workSpaceView.setCircle(z16);
        }
        this.G = z16;
    }

    public void setIsCloseADView(boolean z16) {
        this.f315351h = true;
    }

    public ADView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315348d = R.drawable.f160051a1;
        this.f315349e = R.drawable.f160051a1;
        this.f315351h = false;
        this.f315352i = null;
        this.f315353m = getResources().getDisplayMetrics().density;
        this.C = 2;
        this.D = 0;
        this.E = true;
        this.F = "ADView";
        this.G = true;
        this.H = new b(this);
        g(context);
    }
}
