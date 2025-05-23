package com.tencent.aelight.camera.aioeditor.capture.util;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.view.ComboProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f67210i = {106, R.drawable.f162420b32, R.drawable.f162420b32, R.id.gl6};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f67211j = {101, R.drawable.f162421b33, R.drawable.f162421b33, R.id.gl7};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f67212k = {103, R.drawable.b36, R.drawable.b36, R.id.gl_};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f67213l = {104, R.drawable.f162422b34, R.drawable.f162422b34, R.id.gl8};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f67214m = {108, R.drawable.iz4, R.drawable.iz4, R.id.glb};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f67215n = {104};

    /* renamed from: a, reason: collision with root package name */
    private int f67216a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<int[]> f67217b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public boolean f67218c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f67219d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f67220e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f67221f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f67222g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f67223h = true;

    public h(int i3) {
        this.f67216a = 0;
        this.f67216a = i3;
    }

    public int b() {
        return this.f67217b.size();
    }

    public boolean f(int i3) {
        for (int i16 : f67215n) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        this.f67217b.clear();
        int i3 = this.f67216a;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return;
                        }
                    }
                }
                if (this.f67218c) {
                    this.f67217b.add(f67210i);
                    this.f67217b.add(f67211j);
                    this.f67217b.add(f67212k);
                }
                this.f67217b.add(f67213l);
                this.f67217b.add(f67214m);
                return;
            }
            if (this.f67218c) {
                this.f67217b.add(f67210i);
                this.f67217b.add(f67211j);
                this.f67217b.add(f67212k);
                return;
            }
            return;
        }
        if (this.f67218c) {
            if (this.f67220e) {
                this.f67217b.add(f67211j);
            }
            if (this.f67223h) {
                this.f67217b.add(f67213l);
            }
            if (this.f67222g) {
                this.f67217b.add(f67210i);
            }
        }
    }

    public void i(boolean z16) {
        this.f67219d = z16;
    }

    public void j(boolean z16) {
        this.f67222g = z16;
    }

    public void k(boolean z16) {
        this.f67218c = z16;
    }

    public void l(boolean z16) {
        this.f67221f = z16;
    }

    public void m(boolean z16) {
        this.f67220e = z16;
    }

    public void n(boolean z16) {
        this.f67223h = z16;
    }

    public int c(int i3) {
        if (i3 < 0 || i3 > this.f67217b.size()) {
            return 0;
        }
        return this.f67217b.get(i3)[1];
    }

    public int d(int i3) {
        if (i3 < 0 || i3 > this.f67217b.size()) {
            return -1;
        }
        return this.f67217b.get(i3)[0];
    }

    public int e(int i3) {
        if (i3 < 0 || i3 > this.f67217b.size()) {
            return 0;
        }
        return this.f67217b.get(i3)[2];
    }

    public void o(int i3) {
        if (i3 >= 0 && i3 < this.f67217b.size()) {
            int i16 = this.f67217b.get(i3)[0];
            if (i16 == 101) {
                m.n().Y(1, 0, "");
                return;
            } else {
                if (i16 == 106) {
                    m.n().Y(6, 0, "");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("ProviderViewBuilder", 2, "updateRedDotHasShow failed out bounds" + i3 + " size:" + this.f67217b.size());
        }
    }

    public boolean h(int i3) {
        if (i3 >= 0 && i3 <= this.f67217b.size()) {
            int i16 = this.f67217b.get(i3)[0];
            if (i16 == 101) {
                return m.F(1, 0, "");
            }
            if (i16 == 106) {
                return m.F(6, 0, "");
            }
        }
        return false;
    }

    public ProviderView a(Context context, int i3) {
        ProviderView qIMFilterProviderView;
        if (i3 == 101) {
            if (this.f67220e) {
                qIMFilterProviderView = new QIMFilterProviderView(context);
                qIMFilterProviderView.setId(R.id.apf);
            }
            qIMFilterProviderView = null;
        } else if (i3 == 106) {
            if (this.f67222g) {
                qIMFilterProviderView = new ComboProviderView(context);
                qIMFilterProviderView.setId(R.id.apd);
            }
            qIMFilterProviderView = null;
        } else if (i3 == 108) {
            qIMFilterProviderView = new TransitionProviderView(context);
        } else if (i3 != 103) {
            if (i3 != 104) {
                if (QLog.isColorLevel()) {
                    QLog.d("ProviderViewBuilder", 2, "bad id=" + i3);
                }
            } else if (this.f67223h) {
                qIMFilterProviderView = new MusicProviderView(context);
                qIMFilterProviderView.setId(R.id.apn);
            }
            qIMFilterProviderView = null;
        } else {
            qIMFilterProviderView = new StaticStickerProviderView(context);
            qIMFilterProviderView.setId(R.id.apo);
        }
        if (qIMFilterProviderView != null) {
            qIMFilterProviderView.setCaptureScene(this.f67216a);
            if (this.f67216a == 0) {
                qIMFilterProviderView.setTabBarPosition(2);
                qIMFilterProviderView.m(206);
            } else {
                qIMFilterProviderView.setTabBarPosition(1);
                if (qIMFilterProviderView.q()) {
                    qIMFilterProviderView.m(213);
                } else {
                    qIMFilterProviderView.m(249);
                }
            }
        }
        return qIMFilterProviderView;
    }
}
