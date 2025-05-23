package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ActionSheet f297039a;

    /* renamed from: b, reason: collision with root package name */
    private IphonePickerView f297040b;

    /* renamed from: c, reason: collision with root package name */
    private Context f297041c;

    /* renamed from: d, reason: collision with root package name */
    private int f297042d;

    /* renamed from: e, reason: collision with root package name */
    private int f297043e;

    /* renamed from: f, reason: collision with root package name */
    private int f297044f;

    /* renamed from: g, reason: collision with root package name */
    private IphonePickerView.PickerViewAdapter f297045g;

    /* renamed from: h, reason: collision with root package name */
    private c f297046h;

    /* renamed from: i, reason: collision with root package name */
    private d f297047i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements IphonePickerView.IphonePickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (b.this.f297046h != null) {
                b.this.f297046h.a(b.this.f297042d, b.this.f297043e, b.this.f297044f);
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
                b.this.f297042d = i16;
            } else if (i3 == 1) {
                b.this.f297043e = i16;
            } else if (i3 == 2) {
                b.this.f297044f = i16;
            }
            b.e(b.this);
            if (b.this.f297040b != null && (i3 == 0 || i3 == 1)) {
                b.this.f297040b.notifyDataSetChange(2);
                if (b.this.f297044f >= b.this.f297045g.getRowCount(2)) {
                    b bVar = b.this;
                    bVar.f297044f = bVar.f297045g.getRowCount(2) - 1;
                }
            }
            b.f(b.this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.homework.entry.ui.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8737b implements ActionSheet.WatchDismissActions {
        static IPatchRedirector $redirector_;

        C8737b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public void onDismissOperations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (b.this.f297047i != null) {
                b.this.f297047i.onDismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface d {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface e {
    }

    public b(Context context, IphonePickerView.PickerViewAdapter pickerViewAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) pickerViewAdapter);
        } else {
            this.f297041c = context;
            this.f297045g = pickerViewAdapter;
        }
    }

    static /* bridge */ /* synthetic */ e e(b bVar) {
        bVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ e f(b bVar) {
        bVar.getClass();
        return null;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ActionSheet actionSheet = this.f297039a;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.f297039a.dismiss();
        }
    }

    public IphonePickerView.PickerViewAdapter n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IphonePickerView.PickerViewAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f297045g;
    }

    public void o(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f297046h = cVar;
        }
    }

    public void p(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            this.f297047i = dVar;
        }
    }

    public void q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f297044f = i16;
                }
            } else {
                this.f297043e = i16;
            }
        } else {
            this.f297042d = i16;
        }
        IphonePickerView iphonePickerView = this.f297040b;
        if (iphonePickerView != null) {
            iphonePickerView.setSelection(i3, i16);
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f297039a == null) {
            IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this.f297041c).inflate(R.layout.avo, (ViewGroup) null);
            this.f297040b = iphonePickerView;
            iphonePickerView.initialize(this.f297045g);
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this.f297041c);
            this.f297039a = createMenuSheet;
            createMenuSheet.setCloseAutoRead(true);
            this.f297039a.setActionContentView(this.f297040b, null);
            DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) this.f297039a.findViewById(R.id.f163936cz);
            dispatchActionMoveScrollView.dispatchActionMove = true;
            dispatchActionMoveScrollView.setBackgroundResource(17170445);
            Window window = this.f297039a.getWindow();
            if (window != null) {
                window.setFlags(16777216, 16777216);
            }
            this.f297040b.setPickListener(new a());
            this.f297039a.registerWatchDisMissActionListener(new C8737b());
        }
        if (!this.f297039a.isShowing()) {
            this.f297040b.setSelection(0, this.f297042d);
            this.f297040b.setSelection(1, this.f297043e);
            this.f297040b.setSelection(2, this.f297044f);
            try {
                this.f297039a.show();
            } catch (Exception unused) {
            }
        }
    }
}
