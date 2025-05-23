package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IphonePickerView f183269a;

    /* renamed from: b, reason: collision with root package name */
    private int f183270b;

    /* renamed from: c, reason: collision with root package name */
    private int f183271c;

    /* renamed from: d, reason: collision with root package name */
    private int f183272d;

    /* renamed from: e, reason: collision with root package name */
    private Calendar f183273e;

    /* renamed from: f, reason: collision with root package name */
    private final int f183274f;

    /* renamed from: g, reason: collision with root package name */
    private final int f183275g;

    /* renamed from: h, reason: collision with root package name */
    private final int f183276h;

    /* renamed from: i, reason: collision with root package name */
    private Calendar f183277i;

    /* renamed from: j, reason: collision with root package name */
    private final int f183278j;

    /* renamed from: k, reason: collision with root package name */
    private final int f183279k;

    /* renamed from: l, reason: collision with root package name */
    private final int f183280l;

    /* renamed from: m, reason: collision with root package name */
    a f183281m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(int i3, int i16, int i17);

        void onConfirmBtClicked();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class b implements IphonePickerView.PickerViewAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final int f183282a;

        public b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, i3);
            } else {
                this.f183282a = i3;
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return 3;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return 0;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(1, j.this.f183270b + j.this.f183278j);
                    calendar.set(2, j.this.f183271c);
                    calendar.set(5, 1);
                    return calendar.getActualMaximum(5);
                }
                return 12;
            }
            return this.f183282a;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "";
                    }
                    return j.this.o(i16) + HardCodeUtil.qqStr(R.string.j8j);
                }
                return j.this.p(i16) + HardCodeUtil.qqStr(R.string.j8i);
            }
            return j.this.q(i16) + HardCodeUtil.qqStr(R.string.j8l);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class c implements IphonePickerView.IphonePickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            a aVar = j.this.f183281m;
            if (aVar != null) {
                aVar.onConfirmBtClicked();
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == 0) {
                j.this.f183270b = i16;
            } else if (i3 == 1) {
                j.this.f183271c = i16;
            } else if (i3 == 2) {
                j.this.f183272d = i16;
            }
            j.this.m();
            if (j.this.f183269a != null && (i3 == 0 || i3 == 1)) {
                j.this.f183269a.notifyDataSetChange(2);
            }
            j jVar = j.this;
            if (jVar.f183281m != null) {
                int q16 = jVar.q(jVar.f183270b);
                j jVar2 = j.this;
                int p16 = jVar2.p(jVar2.f183271c);
                j jVar3 = j.this;
                j.this.f183281m.a(q16, p16, jVar3.o(jVar3.f183272d));
            }
        }
    }

    public j(Context context, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        Calendar calendar = Calendar.getInstance();
        this.f183273e = calendar;
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i16 = this.f183273e.get(1);
        this.f183274f = i16;
        int i17 = this.f183273e.get(2) + 1;
        this.f183275g = i17;
        int i18 = this.f183273e.get(5);
        this.f183276h = i18;
        Calendar calendar2 = Calendar.getInstance();
        this.f183277i = calendar2;
        calendar2.setTimeInMillis(System.currentTimeMillis());
        this.f183277i.add(1, -120);
        this.f183277i.add(5, 1);
        int i19 = this.f183277i.get(1);
        this.f183278j = i19;
        int i26 = this.f183277i.get(2) + 1;
        this.f183279k = i26;
        int i27 = this.f183277i.get(5);
        this.f183280l = i27;
        IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(context).inflate(R.layout.avo, (ViewGroup) null);
        this.f183269a = iphonePickerView;
        iphonePickerView.initialize(new b((i16 - i19) + 1));
        this.f183269a.setPickListener(new c());
        this.f183269a.setBackgroundColor(context.getResources().getColor(R.color.skin_color_white));
        s(i3);
        if (z16) {
            this.f183269a.hideTitle();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BirthdayPickHelper", 2, String.format("BirthdayPickHelper date range: %s-%s-%s to %s-%s-%s", Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.f183278j + this.f183270b);
        calendar.set(2, this.f183271c);
        calendar.set(5, this.f183272d + 1);
        if (calendar.before(this.f183277i)) {
            this.f183270b = 0;
            this.f183271c = this.f183279k - 1;
            this.f183272d = this.f183280l - 1;
            this.f183269a.setSelection(0, 0);
            this.f183269a.setSelection(1, this.f183271c);
            this.f183269a.setSelection(2, this.f183272d);
            return;
        }
        if (calendar.after(this.f183273e)) {
            int i3 = this.f183274f - this.f183278j;
            this.f183270b = i3;
            this.f183271c = this.f183275g - 1;
            this.f183272d = this.f183276h - 1;
            this.f183269a.setSelection(0, i3);
            this.f183269a.setSelection(1, this.f183271c);
            this.f183269a.setSelection(2, this.f183272d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(int i3) {
        return i3 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(int i3) {
        return i3 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q(int i3) {
        return this.f183278j + i3;
    }

    public IphonePickerView n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IphonePickerView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183269a;
    }

    public void r(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f183281m = aVar;
        }
    }

    public void s(int i3) {
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 <= 0) {
            i18 = 2000 - this.f183278j;
            i17 = 0;
            i16 = 0;
        } else {
            i16 = ((65280 & i3) >>> 8) - 1;
            i17 = (i3 & 255) - 1;
            i18 = (((-65536) & i3) >>> 16) - this.f183278j;
        }
        this.f183270b = i18;
        this.f183271c = i16;
        this.f183272d = i17;
        this.f183269a.setSelection(0, i18);
        this.f183269a.setSelection(1, i16);
        this.f183269a.setSelection(2, i17);
    }
}
