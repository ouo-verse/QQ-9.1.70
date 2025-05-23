package cooperation.vip.qqbanner.manager;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tenpay.ErrorCode;
import cooperation.qzone.util.QZLog;
import j15.c;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VasADBannerCountDownManager extends VasADBannerManager {
    private TextView H;
    private TextView I;
    private TextView J;
    private Timer K;
    private TimerTask L;
    private c M;

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b0(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(20.0f));
        gradientDrawable.setColor(q(str));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c0() {
        i15.a k3;
        c cVar = this.M;
        if (cVar == null || (k3 = cVar.k()) == null) {
            return "";
        }
        if (k3.f407038a != 1) {
            return k3.f407046i;
        }
        return d0(k3.f407039b, k3.f407040c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d0(int i3, int i16) {
        String str;
        String str2 = "00";
        if (i3 > 99) {
            str = ThemeBackground.DIY_UPLOAD_BG_ID;
        } else if (i3 >= 10 && i3 <= 99) {
            str = String.valueOf(i3);
        } else if (i3 < 0 || i3 >= 10) {
            str = "00";
        } else {
            str = "0" + String.valueOf(i3);
        }
        if (i16 > 59) {
            str2 = ErrorCode.ERR_NET;
        } else if (i16 >= 10 && i16 <= 59) {
            str2 = String.valueOf(i16);
        } else if (i16 >= 0 && i16 < 10) {
            str2 = "0" + String.valueOf(i16);
        }
        return str + ":" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(String str) {
        if (TextUtils.isEmpty(str)) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
            this.J.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        g0();
        this.K = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: cooperation.vip.qqbanner.manager.VasADBannerCountDownManager.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADBannerCountDownManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VasADBannerCountDownManager.this.J != null && !TextUtils.isEmpty(VasADBannerCountDownManager.this.J.getText())) {
                            if (QZLog.isColorLevel()) {
                                QZLog.i("VasADBannerManager", 2, "count down text = " + ((Object) VasADBannerCountDownManager.this.J.getText()));
                            }
                            String[] split = VasADBannerCountDownManager.this.J.getText().toString().split(":");
                            if (split == null || split.length != 2) {
                                VasADBannerCountDownManager.this.g0();
                                if (QZLog.isColorLevel()) {
                                    QZLog.i("VasADBannerManager", 2, "stopTimer split error text = " + ((Object) VasADBannerCountDownManager.this.J.getText()));
                                    return;
                                }
                                return;
                            }
                            try {
                                int intValue = Integer.valueOf(split[0]).intValue();
                                int intValue2 = Integer.valueOf(split[1]).intValue() - 1;
                                if (intValue2 < 0) {
                                    intValue--;
                                    intValue2 = 59;
                                }
                                String str = "";
                                if (VasADBannerCountDownManager.this.M != null && VasADBannerCountDownManager.this.M.k() != null) {
                                    str = VasADBannerCountDownManager.this.M.k().f407046i;
                                }
                                if (intValue >= 0 && intValue2 >= 0) {
                                    VasADBannerCountDownManager vasADBannerCountDownManager = VasADBannerCountDownManager.this;
                                    vasADBannerCountDownManager.e0(vasADBannerCountDownManager.d0(intValue, intValue2));
                                    return;
                                }
                                VasADBannerCountDownManager.this.e0(str);
                                VasADBannerCountDownManager.this.g0();
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                });
            }
        };
        this.L = timerTask;
        this.K.schedule(timerTask, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        TimerTask timerTask = this.L;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.K;
        if (timer != null) {
            timer.cancel();
        }
        this.K = null;
        this.L = null;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public View A() {
        View A = super.A();
        if (A == null) {
            return null;
        }
        this.H = (TextView) A.findViewById(R.id.k9g);
        this.I = (TextView) A.findViewById(R.id.kai);
        this.J = (TextView) A.findViewById(R.id.k5t);
        return A;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void F() {
        super.F();
        g0();
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    protected void J(final j15.a aVar) {
        super.J(aVar);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.vip.qqbanner.manager.VasADBannerCountDownManager.1
            @Override // java.lang.Runnable
            public void run() {
                j15.a aVar2 = aVar;
                if (aVar2 == null || !(aVar2 instanceof c)) {
                    return;
                }
                VasADBannerCountDownManager.this.M = (c) aVar2;
                i15.a k3 = VasADBannerCountDownManager.this.M.k();
                if (k3 == null) {
                    return;
                }
                VasADBannerCountDownManager.this.H.setText(VasADBannerCountDownManager.this.j(k3.f407041d));
                VasADBannerCountDownManager.this.I.setText(VasADBannerCountDownManager.this.j(k3.f407042e));
                VasADBannerCountDownManager.this.H.setTextColor(VasADBannerCountDownManager.this.q(k3.f407043f));
                VasADBannerCountDownManager.this.I.setTextColor(VasADBannerCountDownManager.this.q(k3.f407043f));
                VasADBannerCountDownManager vasADBannerCountDownManager = VasADBannerCountDownManager.this;
                vasADBannerCountDownManager.e0(vasADBannerCountDownManager.c0());
                VasADBannerCountDownManager.this.J.setBackgroundDrawable(VasADBannerCountDownManager.this.b0(k3.f407044g));
                VasADBannerCountDownManager.this.J.setTextColor(VasADBannerCountDownManager.this.q(k3.f407045h));
                if (k3.f407038a == 1) {
                    VasADBannerCountDownManager.this.f0();
                }
            }
        });
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    protected int p() {
        return R.layout.hgu;
    }

    @Override // cooperation.vip.qqbanner.manager.VasADBannerManager
    public void x() {
        super.x();
        g0();
    }
}
