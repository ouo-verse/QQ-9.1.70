package cooperation.plugin;

import android.R;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes28.dex */
public class PluginIphoneTitleBarActivity extends PluginBaseActivity {
    protected ViewGroup C;
    public RelativeLayout E;
    private boolean F;
    protected float G;
    private Drawable J;
    private Drawable[] K;
    private int L;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f390240e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f390241f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f390242h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f390243i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f390244m;
    public View D = null;
    protected boolean H = true;
    protected View.OnClickListener I = new a();

    /* loaded from: classes28.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PluginIphoneTitleBarActivity.this.j0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @TargetApi(11)
    public static void p0(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(1, null);
    }

    @Override // cooperation.plugin.PluginBaseActivity, com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected void i0(Intent intent) {
        ((FrameLayout) findViewById(R.id.content)).setForeground(getResources().getDrawable(com.tencent.mobileqq.R.drawable.skin_header_bar_shadow));
        if (this.f390240e == null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(com.tencent.mobileqq.R.id.rlCommenTitle);
            this.C = viewGroup;
            p0(viewGroup);
            l0();
            k0();
            m0();
            q0(intent);
        }
    }

    protected boolean j0() {
        finish();
        return false;
    }

    protected View k0() {
        TextView textView = (TextView) findViewById(com.tencent.mobileqq.R.id.ivTitleName);
        this.f390241f = textView;
        return textView;
    }

    protected View l0() {
        TextView textView = (TextView) findViewById(com.tencent.mobileqq.R.id.ivTitleBtnLeft);
        this.f390240e = textView;
        if (textView != null) {
            textView.setOnClickListener(this.I);
            p0(this.f390240e);
        }
        return this.f390240e;
    }

    protected View m0() {
        this.f390242h = (TextView) findViewById(com.tencent.mobileqq.R.id.ivTitleBtnRightText);
        this.f390244m = (ImageView) findViewById(com.tencent.mobileqq.R.id.ivTitleBtnRightImage);
        this.f390243i = (TextView) findViewById(com.tencent.mobileqq.R.id.k4w);
        p0(this.f390242h);
        p0(this.f390244m);
        return this.f390242h;
    }

    public void n0(View view, boolean z16) {
        this.G = getResources().getDisplayMetrics().density;
        if (z16) {
            requestWindowFeature(7);
            super.setContentView(view);
            getWindow().setFeatureInt(7, com.tencent.mobileqq.R.layout.f167828is);
            i0(getIntent());
            return;
        }
        requestWindowFeature(1);
        super.setContentView(view);
    }

    public void o0(int i3) {
        this.G = getResources().getDisplayMetrics().density;
        requestWindowFeature(1);
        super.setContentView(i3);
        i0(getIntent());
    }

    @Override // cooperation.plugin.PluginBaseActivity, com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void q0(Intent intent) {
        TextView textView = this.f390240e;
        if (textView != null && (textView instanceof TextView) && intent != null && intent.getExtras() != null) {
            TextView textView2 = this.f390240e;
            String string = intent.getExtras().getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
            if (string == null) {
                string = getString(com.tencent.mobileqq.R.string.button_back);
            }
            if (this.H) {
                textView2.setText("  ");
            } else {
                textView2.setText(string);
            }
        }
    }

    protected void r0(int i3, View.OnClickListener onClickListener) {
        s0(getString(i3), onClickListener);
    }

    protected void s0(CharSequence charSequence, View.OnClickListener onClickListener) {
        this.F = false;
        this.f390242h.setVisibility(0);
        this.f390242h.setText(charSequence);
        this.f390242h.setEnabled(true);
        if (onClickListener != null) {
            this.f390242h.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, android.app.Activity
    public void setContentView(int i3) {
        Intent intent = getIntent();
        boolean z16 = true;
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("showTitleBar", true) : true;
        if (!this.f390221d) {
            if (booleanExtra) {
                requestWindowFeature(7);
            }
            super.setContentView(i3);
            if (booleanExtra) {
                getWindow().setFeatureInt(7, com.tencent.mobileqq.R.layout.f167828is);
            }
        } else if (booleanExtra) {
            LayoutInflater from = LayoutInflater.from(this);
            View inflate = from.inflate(com.tencent.mobileqq.R.layout.f167829iw, (ViewGroup) null);
            try {
                View inflate2 = from.inflate(i3, (ViewGroup) inflate, false);
                this.E = (RelativeLayout) inflate.findViewById(com.tencent.mobileqq.R.id.jqh);
                if (ImmersiveUtils.isSupporImmersive() == 1) {
                    this.E.setFitsSystemWindows(true);
                    this.E.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(3, com.tencent.mobileqq.R.id.rlCommenTitle);
                this.E.addView(inflate2, layoutParams);
                this.mContentView = inflate2;
                super.setContentView(this.E);
                z16 = false;
            } catch (InflateException e16) {
                e16.printStackTrace();
            } catch (RuntimeException e17) {
                e17.printStackTrace();
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.e("IphoneTitleBarActivity", 2, "layout with merge ,use framelayout to immersive" + getComponentName());
                }
                super.setContentView(i3);
                getWindow().setFeatureInt(7, com.tencent.mobileqq.R.layout.f167828is);
                View view = this.D;
                if (view != null) {
                    view.setVisibility(0);
                }
                this.G = getResources().getDisplayMetrics().density;
                i0(getIntent());
                return;
            }
        } else {
            super.setContentView(i3);
        }
        this.G = getResources().getDisplayMetrics().density;
        if (booleanExtra) {
            i0(getIntent());
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, android.app.Activity
    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f390241f;
        if (textView == null || !(textView instanceof TextView)) {
            return;
        }
        textView.setText(charSequence);
        super.setTitle(charSequence);
    }

    protected boolean t0() {
        if (this.J == null) {
            this.J = getResources().getDrawable(com.tencent.mobileqq.R.drawable.common_loading6);
            this.K = this.f390241f.getCompoundDrawables();
            this.L = this.f390241f.getCompoundDrawablePadding();
            this.f390241f.setCompoundDrawablePadding(10);
            TextView textView = this.f390241f;
            Drawable drawable = this.J;
            Drawable[] drawableArr = this.K;
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawableArr[1], drawableArr[2], drawableArr[3]);
            ((Animatable) this.J).start();
            return true;
        }
        return false;
    }

    protected boolean u0() {
        Object obj = this.J;
        if (obj == null) {
            return false;
        }
        ((Animatable) obj).stop();
        this.J = null;
        this.f390241f.setCompoundDrawablePadding(this.L);
        TextView textView = this.f390241f;
        Drawable[] drawableArr = this.K;
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
        return true;
    }

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, android.app.Activity
    public void setTitle(int i3) {
        setTitle(getString(i3));
    }

    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, android.app.Activity
    public void setContentView(View view) {
        n0(view, true);
    }
}
