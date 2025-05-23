package com.tencent.mobileqq.msgbackup.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupDateFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private RadioGroup C;
    private LinearLayout D;
    private RelativeLayout E;
    private TextView F;
    private RelativeLayout G;
    private TextView H;
    private RadioGroup I;
    private ActionSheet J;
    private IphonePickerView K;
    private int L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f251190a0;

    /* renamed from: b0, reason: collision with root package name */
    private long f251191b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f251192c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f251193d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f251194e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f251195f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f251196g0;

    /* renamed from: h0, reason: collision with root package name */
    private Calendar f251197h0;

    /* renamed from: i0, reason: collision with root package name */
    private Calendar f251198i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f251199j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f251200k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f251201l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f251202m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f251203n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f251204o0;

    /* renamed from: p0, reason: collision with root package name */
    View.OnClickListener f251205p0;

    /* renamed from: q0, reason: collision with root package name */
    View.OnClickListener f251206q0;

    /* renamed from: r0, reason: collision with root package name */
    RadioGroup.OnCheckedChangeListener f251207r0;

    /* renamed from: s0, reason: collision with root package name */
    RadioGroup.OnCheckedChangeListener f251208s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f251209t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupDateFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (MsgBackupDateFragment.this.f251204o0 == 0) {
                    com.tencent.mobileqq.msgbackup.util.d.e("0X800A237");
                } else if (MsgBackupManager.N) {
                    com.tencent.mobileqq.msgbackup.util.d.e("0X800A25C");
                }
                MsgBackupDateFragment.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupDateFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (MsgBackupDateFragment.this.f251204o0 == 0) {
                    com.tencent.mobileqq.msgbackup.util.d.e("0X800A236");
                } else if (MsgBackupManager.N) {
                    com.tencent.mobileqq.msgbackup.util.d.e("0X800A25B");
                }
                MsgBackupDateFragment.this.onBackEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements RadioGroup.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupDateFragment.this);
            }
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) radioGroup, i3);
            } else {
                if (i3 == R.id.lf5) {
                    MsgBackupDateFragment.this.f251193d0 = false;
                    MsgBackupDateFragment.this.f251191b0 = 0L;
                    MsgBackupDateFragment.this.f251192c0 = 0L;
                    MsgBackupDateFragment.this.D.setVisibility(8);
                } else if (i3 == R.id.lf6) {
                    MsgBackupDateFragment.this.f251193d0 = true;
                    MsgBackupDateFragment.this.D.setVisibility(0);
                }
                if (MsgBackupDateFragment.this.f251193d0) {
                    if (MsgBackupDateFragment.this.f251194e0 && MsgBackupDateFragment.this.f251195f0) {
                        h92.a.a(MsgBackupDateFragment.this, true);
                    } else if (!TextUtils.isEmpty(MsgBackupDateFragment.this.f251202m0) && !TextUtils.isEmpty(MsgBackupDateFragment.this.f251203n0)) {
                        h92.a.a(MsgBackupDateFragment.this, true);
                    } else {
                        h92.a.a(MsgBackupDateFragment.this, false);
                    }
                } else {
                    h92.a.a(MsgBackupDateFragment.this, true);
                }
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements RadioGroup.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupDateFragment.this);
            }
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) radioGroup, i3);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "checkedId = " + i3);
                }
                if (i3 == R.id.lee) {
                    MsgBackupDateFragment.this.f251196g0 = 1;
                } else if (i3 == R.id.lef) {
                    MsgBackupDateFragment.this.f251196g0 = 2;
                }
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements IphonePickerView.IphonePickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupDateFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (MsgBackupDateFragment.this.J != null && MsgBackupDateFragment.this.J.isShowing()) {
                MsgBackupDateFragment.this.J.dismiss();
                MsgBackupDateFragment.this.ai();
                MsgBackupDateFragment.this.Uh();
                MsgBackupDateFragment msgBackupDateFragment = MsgBackupDateFragment.this;
                msgBackupDateFragment.Xh(msgBackupDateFragment.f251209t0);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (MsgBackupDateFragment.this.f251209t0 == 1) {
                            MsgBackupDateFragment.this.N = i16;
                        } else if (MsgBackupDateFragment.this.f251209t0 == 2) {
                            MsgBackupDateFragment.this.R = i16;
                        }
                    }
                } else if (MsgBackupDateFragment.this.f251209t0 == 1) {
                    MsgBackupDateFragment.this.M = i16;
                } else if (MsgBackupDateFragment.this.f251209t0 == 2) {
                    MsgBackupDateFragment.this.Q = i16;
                }
            } else if (MsgBackupDateFragment.this.f251209t0 == 1) {
                MsgBackupDateFragment.this.L = i16;
            } else if (MsgBackupDateFragment.this.f251209t0 == 2) {
                MsgBackupDateFragment.this.P = i16;
            }
            MsgBackupDateFragment msgBackupDateFragment = MsgBackupDateFragment.this;
            msgBackupDateFragment.Vh(msgBackupDateFragment.f251209t0);
            MsgBackupDateFragment.this.Uh();
            if (MsgBackupDateFragment.this.K != null) {
                if (i3 == 0 || i3 == 1) {
                    MsgBackupDateFragment.this.K.notifyDataSetChange(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupDateFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (MsgBackupDateFragment.this.J != null && MsgBackupDateFragment.this.J.isShowing()) {
                MsgBackupDateFragment.this.J.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g implements IphonePickerView.PickerViewAdapter {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupDateFragment.this);
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
                    if (MsgBackupDateFragment.this.f251209t0 == 1) {
                        calendar.set(1, MsgBackupDateFragment.this.L + MsgBackupDateFragment.this.f251199j0);
                        calendar.set(2, MsgBackupDateFragment.this.M);
                        calendar.set(5, 1);
                    } else {
                        calendar.set(1, MsgBackupDateFragment.this.P + MsgBackupDateFragment.this.f251199j0);
                        calendar.set(2, MsgBackupDateFragment.this.Q);
                        calendar.set(5, 1);
                    }
                    return calendar.getActualMaximum(5);
                }
                return 12;
            }
            return (MsgBackupDateFragment.this.V - MsgBackupDateFragment.this.f251199j0) + 1;
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
                    return (i16 + 1) + HardCodeUtil.qqStr(R.string.o_j);
                }
                return (i16 + 1) + HardCodeUtil.qqStr(R.string.o_4);
            }
            return (MsgBackupDateFragment.this.f251199j0 + i16) + HardCodeUtil.qqStr(R.string.o_k);
        }

        /* synthetic */ g(MsgBackupDateFragment msgBackupDateFragment, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgBackupDateFragment, (Object) aVar);
        }
    }

    public MsgBackupDateFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251191b0 = 0L;
        this.f251192c0 = 0L;
        this.f251193d0 = false;
        this.f251194e0 = false;
        this.f251195f0 = false;
        this.f251196g0 = 1;
        this.f251205p0 = new a();
        this.f251206q0 = new b();
        this.f251207r0 = new c();
        this.f251208s0 = new d();
        this.f251209t0 = 0;
    }

    private void Th() {
        if (this.f251191b0 != 0 && this.f251192c0 != 0) {
            ((RadioButton) this.C.findViewById(R.id.lf6)).setChecked(true);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.f251191b0 * 1000);
            String format = String.format("%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
            this.f251202m0 = format;
            this.F.setText(format);
            Yh(this.F, this.f251202m0);
            calendar.setTimeInMillis(this.f251192c0 * 1000);
            String format2 = String.format("%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
            this.f251203n0 = format2;
            this.H.setText(format2);
            Yh(this.H, this.f251203n0);
            h92.a.a(this, true);
        } else {
            ((RadioButton) this.C.findViewById(R.id.lf5)).setChecked(true);
        }
        int i3 = this.f251196g0;
        if (i3 == 1) {
            this.I.check(R.id.lee);
        } else if (i3 == 2) {
            this.I.check(R.id.lef);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        if (this.f251209t0 == 1) {
            this.Y = this.f251199j0 + this.L;
            Calendar calendar = Calendar.getInstance();
            calendar.set(this.Y, this.M, this.N + 1);
            this.Y = calendar.get(1);
            this.Z = calendar.get(2) + 1;
            this.f251190a0 = calendar.get(5);
            return;
        }
        this.Y = this.f251199j0 + this.P;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(this.Y, this.Q, this.R + 1);
        this.Y = calendar2.get(1);
        this.Z = calendar2.get(2) + 1;
        this.f251190a0 = calendar2.get(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(int i3) {
        if (i3 == 1) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, this.f251199j0 + this.L);
            calendar.set(2, this.M);
            calendar.set(5, this.N + 1);
            if (calendar.before(this.f251198i0)) {
                this.L = 0;
                this.M = this.f251200k0 - 1;
                this.N = this.f251201l0 - 1;
                this.K.setSelection(0, 0);
                this.K.setSelection(1, this.M);
                this.K.setSelection(2, this.N);
            } else if (calendar.after(this.f251197h0)) {
                int i16 = this.V - this.f251199j0;
                this.L = i16;
                this.M = this.W - 1;
                this.N = this.X - 1;
                this.K.setSelection(0, i16);
                this.K.setSelection(1, this.M);
                this.K.setSelection(2, this.N);
            }
            if (this.f251195f0) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(this.f251192c0 * 1000);
                if (calendar.after(calendar2)) {
                    this.L = calendar2.get(1) - this.f251199j0;
                    this.M = calendar2.get(2);
                    this.N = calendar2.get(5) - 1;
                    this.K.setSelection(0, this.L);
                    this.K.setSelection(1, this.M);
                    this.K.setSelection(2, this.N);
                    return;
                }
                return;
            }
            return;
        }
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(1, this.f251199j0 + this.P);
        calendar3.set(2, this.Q);
        calendar3.set(5, this.R + 1);
        if (calendar3.before(this.f251198i0)) {
            this.P = 0;
            this.Q = this.f251200k0 - 1;
            this.R = this.f251201l0 - 1;
            this.K.setSelection(0, 0);
            this.K.setSelection(1, this.Q);
            this.K.setSelection(2, this.R);
        } else if (calendar3.after(this.f251197h0)) {
            int i17 = this.V - this.f251199j0;
            this.P = i17;
            this.Q = this.W - 1;
            this.R = this.X - 1;
            this.K.setSelection(0, i17);
            this.K.setSelection(1, this.Q);
            this.K.setSelection(2, this.R);
        }
        if (i3 == 2) {
            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTimeInMillis(this.f251191b0 * 1000);
            if (calendar3.before(calendar4)) {
                this.P = calendar4.get(1) - this.f251199j0;
                this.Q = calendar4.get(2);
                this.R = calendar4.get(5) - 1;
                this.K.setSelection(0, this.P);
                this.K.setSelection(1, this.Q);
                this.K.setSelection(2, this.R);
            }
        }
    }

    private void Wh() {
        setTitle(getActivity().getString(R.string.ij7));
        setRightButton(R.string.ij5, this.f251205p0);
        setLeftButton(R.string.f170554ij4, this.f251206q0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(int i3) {
        if (i3 == 1) {
            String format = String.format("%d.%d.%d", Integer.valueOf(this.Y), Integer.valueOf(this.Z), Integer.valueOf(this.f251190a0));
            this.f251202m0 = format;
            this.f251194e0 = true;
            this.F.setText(format);
            Yh(this.F, this.f251202m0);
            Calendar calendar = Calendar.getInstance();
            calendar.set(this.Y, this.Z - 1, this.f251190a0, 0, 0, 0);
            this.f251191b0 = calendar.getTimeInMillis() / 1000;
            return;
        }
        if (i3 == 2) {
            String format2 = String.format("%d.%d.%d", Integer.valueOf(this.Y), Integer.valueOf(this.Z), Integer.valueOf(this.f251190a0));
            this.f251203n0 = format2;
            this.H.setText(format2);
            Yh(this.H, this.f251203n0);
            this.f251195f0 = true;
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(this.Y, this.Z - 1, this.f251190a0, 23, 59, 59);
            this.f251192c0 = calendar2.getTimeInMillis() / 1000;
            if (this.f251194e0 && this.f251195f0) {
                h92.a.a(this, true);
            }
        }
    }

    private void Yh(View view, String str) {
        if (AppSetting.f99565y) {
            view.setContentDescription(str);
        }
    }

    private void Zh() {
        IphonePickerView iphonePickerView;
        ActionSheet actionSheet = this.J;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
        a aVar = null;
        if (this.J == null) {
            IphonePickerView iphonePickerView2 = (IphonePickerView) getActivity().getLayoutInflater().inflate(R.layout.avo, (ViewGroup) null);
            this.K = iphonePickerView2;
            if (iphonePickerView2 == null) {
                return;
            }
            iphonePickerView2.initialize(new g(this, aVar));
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(getActivity());
            this.J = createMenuSheet;
            createMenuSheet.setCloseAutoRead(true);
            this.J.setActionContentView(this.K, null);
            DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) this.J.findViewById(R.id.f163936cz);
            dispatchActionMoveScrollView.dispatchActionMove = true;
            dispatchActionMoveScrollView.setBackgroundResource(17170445);
            Window window = this.J.getWindow();
            if (window != null) {
                window.setFlags(16777216, 16777216);
            }
            this.K.setPickListener(new e());
        }
        IphonePickerView iphonePickerView3 = this.K;
        if (iphonePickerView3 != null) {
            ((TextView) iphonePickerView3.findViewById(R.id.maf)).setTextColor(getResources().getColor(R.color.f157830cb));
            TextView textView = (TextView) this.K.findViewById(R.id.f166840im0);
            Button button = (Button) this.K.findViewById(R.id.maf);
            ((Button) this.K.findViewById(R.id.jlr)).setText(HardCodeUtil.qqStr(R.string.o_g));
            button.setVisibility(0);
            button.setOnClickListener(new f());
            int i3 = this.f251209t0;
            if (i3 == 1) {
                textView.setText(HardCodeUtil.qqStr(R.string.o_5));
                textView.setVisibility(0);
                textView.setCompoundDrawables(null, null, null, null);
            } else if (i3 == 2) {
                textView.setText(HardCodeUtil.qqStr(R.string.o_6));
                textView.setVisibility(0);
                textView.setCompoundDrawables(null, null, null, null);
            }
        }
        if (!this.J.isShowing() && (iphonePickerView = this.K) != null) {
            int i16 = this.f251209t0;
            if (i16 == 1) {
                if (this.f251194e0) {
                    iphonePickerView.setSelection(0, this.L);
                    this.K.setSelection(1, this.M);
                    this.K.setSelection(2, this.N);
                } else {
                    iphonePickerView.setSelection(0, this.S);
                    this.K.setSelection(1, this.T);
                    this.K.setSelection(2, this.U);
                }
            } else if (i16 == 2) {
                if (this.f251195f0) {
                    iphonePickerView.setSelection(0, this.P);
                    this.K.setSelection(1, this.Q);
                    this.K.setSelection(2, this.R);
                } else {
                    iphonePickerView.setSelection(0, this.S);
                    this.K.setSelection(1, this.T);
                    this.K.setSelection(2, this.U);
                }
            }
            try {
                this.J.show();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        int i3 = this.f251209t0;
        if (i3 == 1) {
            this.L = this.K.getSelection(0);
            this.M = this.K.getSelection(1);
            this.N = this.K.getSelection(2);
        } else if (i3 == 2) {
            this.P = this.K.getSelection(0);
            this.Q = this.K.getSelection(1);
            this.R = this.K.getSelection(2);
        }
    }

    private void initData() {
        Intent intent;
        this.f251191b0 = 0L;
        this.f251192c0 = 0L;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            this.f251191b0 = intent.getLongExtra("session_start_time", 0L);
            this.f251192c0 = intent.getLongExtra("session_end_time", 0L);
            this.f251196g0 = intent.getIntExtra("session_content_type", 1);
            this.f251204o0 = intent.getIntExtra("backup_select_from", 0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "startTime = " + this.f251191b0 + ", endTime = " + this.f251192c0 + ", mCurContentType = " + this.f251196g0);
        }
        Calendar calendar = Calendar.getInstance();
        this.f251197h0 = calendar;
        calendar.setTimeInMillis(System.currentTimeMillis());
        this.V = this.f251197h0.get(1);
        this.W = this.f251197h0.get(2) + 1;
        this.X = this.f251197h0.get(5);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        this.Y = calendar2.get(1);
        this.Z = calendar2.get(2) + 1;
        this.f251190a0 = calendar2.get(5);
        Calendar calendar3 = Calendar.getInstance();
        this.f251198i0 = calendar3;
        calendar3.setTimeInMillis(System.currentTimeMillis());
        this.f251198i0.add(1, -30);
        this.f251198i0.add(5, 1);
        this.f251199j0 = this.f251198i0.get(1);
        this.f251200k0 = this.f251198i0.get(2) + 1;
        this.f251201l0 = this.f251198i0.get(5);
        int i3 = this.V - this.f251199j0;
        this.L = i3;
        int i16 = this.W - 1;
        this.M = i16;
        int i17 = this.X - 1;
        this.N = i17;
        this.S = i3;
        this.T = i16;
        this.U = i17;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, String.format("initData date range: %s-%s-%s to %s-%s-%s", Integer.valueOf(this.f251199j0), Integer.valueOf(this.f251200k0), Integer.valueOf(this.f251201l0), Integer.valueOf(this.V), Integer.valueOf(this.W), Integer.valueOf(this.X)));
        }
    }

    private void initUI() {
        RadioGroup radioGroup = (RadioGroup) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.l_s);
        this.C = radioGroup;
        radioGroup.setOnCheckedChangeListener(this.f251207r0);
        RadioGroup radioGroup2 = (RadioGroup) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.l_p);
        this.I = radioGroup2;
        radioGroup2.setOnCheckedChangeListener(this.f251208s0);
        this.D = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lfb);
        RelativeLayout relativeLayout = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.l_q);
        this.E = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.F = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lf9);
        RelativeLayout relativeLayout2 = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.l_r);
        this.G = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.H = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.lf_);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Wh();
        initUI();
        initData();
        Th();
    }

    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (getActivity() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "date fragment finish called! before is correct date time-------> startTime = " + this.f251191b0 + ", endtime = " + this.f251192c0 + ", contentType = " + this.f251196g0);
            }
            long j3 = this.f251191b0;
            long j16 = this.f251192c0;
            if (j3 >= j16) {
                this.f251191b0 = j16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.BackupAndMigrateDateFragment", 2, "date fragment finish called! after is correct date time-------> startTime = " + this.f251191b0 + ", endtime = " + this.f251192c0 + ", contentType = " + this.f251196g0);
            }
            Intent intent = new Intent();
            intent.putExtra("session_start_time", this.f251191b0);
            intent.putExtra("session_end_time", this.f251192c0);
            intent.putExtra("session_start_time_str", this.f251202m0);
            intent.putExtra("session_end_time_str", this.f251203n0);
            intent.putExtra("session_content_type", this.f251196g0);
            getActivity().setResult(0, intent);
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.cbt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.lf9 && id5 != R.id.l_q) {
                if ((id5 == R.id.l_r || id5 == R.id.lf_) && (this.f251194e0 || (this.f251191b0 != 0 && this.f251202m0 != null))) {
                    this.f251209t0 = 2;
                    Zh();
                }
            } else {
                this.f251209t0 = 1;
                Zh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
