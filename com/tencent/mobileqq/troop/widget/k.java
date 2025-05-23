package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f302579a;

    /* renamed from: b, reason: collision with root package name */
    private int f302580b;

    /* renamed from: c, reason: collision with root package name */
    private int f302581c;

    /* renamed from: d, reason: collision with root package name */
    private int f302582d;

    /* renamed from: e, reason: collision with root package name */
    private long f302583e;

    /* renamed from: f, reason: collision with root package name */
    private ActionSheet f302584f;

    /* renamed from: g, reason: collision with root package name */
    private WheelPickerLayout f302585g;

    /* renamed from: h, reason: collision with root package name */
    private c f302586h;

    /* renamed from: i, reason: collision with root package name */
    private Calendar f302587i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements WheelPickerLayout.g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.widget.WheelPickerLayout.g
        public void onItemSelected(int i3, int i16) {
            int i17;
            int i18;
            int i19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (k.this.f302585g != null) {
                if (i3 == 0) {
                    if (k.this.f302587i != null) {
                        i18 = k.this.f302586h.b(k.this.f302587i, i16);
                        i19 = k.this.f302586h.c(k.this.f302587i, i16, i18);
                    } else {
                        i18 = 0;
                        i19 = 0;
                    }
                    k.this.f302585g.setSelection(1, i18);
                    k.this.f302585g.i(1);
                    k.this.f302585g.setSelection(2, i19);
                    k.this.f302585g.i(2);
                } else if (i3 == 1) {
                    if (k.this.f302587i != null) {
                        i17 = k.this.f302586h.c(k.this.f302587i, k.this.f302585g.g(0), i16);
                    } else {
                        i17 = 0;
                    }
                    k.this.f302585g.setSelection(2, i17);
                    k.this.f302585g.i(2);
                }
                k kVar = k.this;
                kVar.f302587i = kVar.f302586h.d(k.this.f302585g.g(0), k.this.f302585g.g(1), k.this.f302585g.g(2));
                if (QLog.isColorLevel()) {
                    QLog.i("TroopPickerViewHelper", 2, Arrays.toString(k.this.f302586h.e(k.this.f302587i.getTimeInMillis())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f302589d;

        b(d dVar) {
            this.f302589d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this, (Object) dVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (k.this.f302584f != null && k.this.f302584f.isShowing()) {
                    k.this.f302584f.dismiss();
                }
                if (this.f302589d != null && k.this.f302587i != null) {
                    this.f302589d.a(k.this.f302587i.getTimeInMillis());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements WheelPickerLayout.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final DateFormat f302591a;

        /* renamed from: b, reason: collision with root package name */
        private WheelPickerLayout f302592b;

        /* renamed from: c, reason: collision with root package name */
        private Date f302593c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f302594d;

        public c(WheelPickerLayout wheelPickerLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this, (Object) wheelPickerLayout);
                return;
            }
            this.f302591a = new SimpleDateFormat("M\u6708d\u65e5");
            this.f302594d = true;
            this.f302592b = wheelPickerLayout;
            this.f302593c = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.f302593c);
            calendar.set(13, 0);
            calendar.set(14, 0);
            int i3 = calendar.get(11);
            if (i3 >= k.this.f302581c) {
                calendar.add(5, 1);
                calendar.set(11, k.this.f302580b);
                calendar.set(12, 0);
                this.f302594d = false;
            } else if (i3 < k.this.f302580b) {
                calendar.set(11, k.this.f302580b);
                calendar.set(12, 0);
            } else {
                calendar.add(12, k.this.f302579a - (calendar.get(12) % k.this.f302579a));
            }
            this.f302593c = calendar.getTime();
        }

        private String a(int i3) {
            StringBuilder sb5 = new StringBuilder();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.f302593c);
            if (i3 > 0) {
                calendar.add(5, i3);
            }
            long time = this.f302593c.getTime();
            long timeInMillis = calendar.getTimeInMillis();
            int i16 = (int) ((timeInMillis - time) / 86400000);
            if (!this.f302594d) {
                i16++;
            }
            if (i16 != 0) {
                sb5.append(this.f302591a.format(Long.valueOf(timeInMillis)));
                sb5.append(" ");
            }
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        sb5.append(f(calendar.get(7)));
                    } else {
                        sb5.append("\u540e\u5929");
                    }
                } else {
                    sb5.append("\u660e\u5929");
                }
            } else {
                sb5.append("\u4eca\u5929");
            }
            return sb5.toString();
        }

        private String f(int i3) {
            switch (i3) {
                case 1:
                    return HardCodeUtil.qqStr(R.string.uoo);
                case 2:
                    return HardCodeUtil.qqStr(R.string.f172851up1);
                case 3:
                    return HardCodeUtil.qqStr(R.string.uos);
                case 4:
                    return HardCodeUtil.qqStr(R.string.uom);
                case 5:
                    return HardCodeUtil.qqStr(R.string.uok);
                case 6:
                    return HardCodeUtil.qqStr(R.string.f172850up0);
                case 7:
                    return HardCodeUtil.qqStr(R.string.f172852up2);
                default:
                    return "";
            }
        }

        public int b(Calendar calendar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) calendar, i3)).intValue();
            }
            int i16 = calendar.get(11) - d(i3).get(11);
            if (i16 <= 0) {
                return 0;
            }
            return i16;
        }

        public int c(Calendar calendar, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, this, calendar, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            int i17 = (int) ((calendar.get(12) - d(i3, i16).get(12)) / k.this.f302579a);
            if (i17 <= 0) {
                return 0;
            }
            return i17;
        }

        public Calendar d(int... iArr) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Calendar) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iArr);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.f302593c);
            int i16 = iArr[0];
            if (i16 > 0) {
                calendar.add(5, i16);
                calendar.set(11, k.this.f302580b);
                calendar.set(12, 0);
            }
            if (iArr.length > 1 && (i3 = iArr[1]) > 0) {
                calendar.add(11, i3);
                calendar.set(12, 0);
            }
            if (iArr.length > 2) {
                calendar.add(12, iArr[2] * k.this.f302579a);
            }
            return calendar;
        }

        public int[] e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (int[]) iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.f302593c);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j3);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            int timeInMillis = (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
            Calendar d16 = d(timeInMillis);
            calendar2.setTimeInMillis(j3);
            int i3 = calendar2.get(11) - d16.get(11);
            int[] iArr = {timeInMillis, i3, (calendar2.get(12) - d(iArr[0], i3).get(12)) / k.this.f302579a};
            return iArr;
        }

        @Override // com.tencent.mobileqq.troop.widget.WheelPickerLayout.e
        public int getRowCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            if (i3 == 0) {
                return k.this.f302582d;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    return 0;
                }
                return (60 - d(this.f302592b.g(0), this.f302592b.g(1)).get(12)) / k.this.f302579a;
            }
            return (k.this.f302581c - d(this.f302592b.g(0)).get(11)) + 1;
        }

        @Override // com.tencent.mobileqq.troop.widget.WheelPickerLayout.e
        public String getText(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "";
                    }
                    return String.format("%d\u5206", Integer.valueOf(d(this.f302592b.g(0), this.f302592b.g(1), i16).get(12)));
                }
                return String.format("%d\u70b9", Integer.valueOf(d(this.f302592b.g(0), i16).get(11)));
            }
            return a(i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface d {
        void a(long j3);
    }

    public k(int i3, int i16, int i17, int i18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3));
            return;
        }
        this.f302579a = i3;
        this.f302580b = i16;
        this.f302581c = i17;
        this.f302582d = i18;
        this.f302583e = j3;
    }

    public void j(Activity activity, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) dVar);
            return;
        }
        if (this.f302584f == null) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.ajf, (ViewGroup) null);
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(activity);
            this.f302584f = createMenuSheet;
            createMenuSheet.setCloseAutoRead(true);
            this.f302584f.setActionContentView(inflate, null);
            this.f302585g = (WheelPickerLayout) inflate.findViewById(R.id.jwg);
            WheelPickerLayout.f fVar = new WheelPickerLayout.f();
            Resources resources = activity.getResources();
            fVar.f302498a = 33;
            fVar.f302499b = 23;
            fVar.f302500c = resources.getColor(R.color.afs);
            fVar.f302501d = 17;
            fVar.f302502e = 23;
            fVar.f302503f = resources.getColor(R.color.skin_black);
            c cVar = new c(this.f302585g);
            this.f302586h = cVar;
            this.f302585g.h(cVar, fVar);
            this.f302585g.setPickListener(new a());
            View findViewById = inflate.findViewById(R.id.agd);
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(dVar));
            }
        }
        if (!this.f302584f.isShowing()) {
            int[] e16 = this.f302586h.e(this.f302583e);
            for (int i3 = 0; i3 < e16.length; i3++) {
                this.f302585g.setSelection(i3, e16[i3]);
                this.f302585g.i(i3);
            }
            this.f302587i = this.f302586h.d(e16);
            try {
                this.f302584f.show();
            } catch (Exception unused) {
            }
        }
    }
}
