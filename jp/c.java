package jp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ActionSheet f410769a;

    /* renamed from: b, reason: collision with root package name */
    private IphonePickerView f410770b;

    /* renamed from: c, reason: collision with root package name */
    private Context f410771c;

    /* renamed from: d, reason: collision with root package name */
    private int f410772d;

    /* renamed from: e, reason: collision with root package name */
    private int f410773e;

    /* renamed from: f, reason: collision with root package name */
    private int f410774f;

    /* renamed from: g, reason: collision with root package name */
    private IphonePickerView.PickerViewAdapter f410775g;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC10604c f410776h;

    /* renamed from: i, reason: collision with root package name */
    private d f410777i;

    /* renamed from: j, reason: collision with root package name */
    private e f410778j;

    /* renamed from: k, reason: collision with root package name */
    private e f410779k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements ActionSheet.WatchDismissActions {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public void onDismissOperations() {
            if (c.this.f410777i != null) {
                c.this.f410777i.onDismiss();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: jp.c$c, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10604c {
        void a(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface d {
        void onDismiss();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface e {
        void onItemSelected(int i3, int i16);
    }

    public c(Context context, IphonePickerView.PickerViewAdapter pickerViewAdapter) {
        this.f410771c = context;
        this.f410775g = pickerViewAdapter;
    }

    public void m() {
        ActionSheet actionSheet = this.f410769a;
        if (actionSheet == null || !actionSheet.isShowing()) {
            return;
        }
        this.f410769a.dismiss();
    }

    public IphonePickerView.PickerViewAdapter n() {
        return this.f410775g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(e eVar) {
        this.f410779k = eVar;
    }

    public void p(InterfaceC10604c interfaceC10604c) {
        this.f410776h = interfaceC10604c;
    }

    public void q(d dVar) {
        this.f410777i = dVar;
    }

    public void s() {
        if (this.f410769a == null) {
            IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this.f410771c).inflate(R.layout.avo, (ViewGroup) null);
            this.f410770b = iphonePickerView;
            iphonePickerView.initialize(this.f410775g);
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this.f410771c);
            this.f410769a = createMenuSheet;
            createMenuSheet.setCloseAutoRead(true);
            this.f410769a.setActionContentView(this.f410770b, null);
            DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) this.f410769a.findViewById(R.id.f163936cz);
            dispatchActionMoveScrollView.dispatchActionMove = true;
            dispatchActionMoveScrollView.setBackgroundResource(17170445);
            Window window = this.f410769a.getWindow();
            if (window != null) {
                window.setFlags(16777216, 16777216);
                window.clearFlags(67108864);
                window.setStatusBarColor(0);
                ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), window);
            }
            this.f410770b.setPickListener(new a());
            this.f410769a.registerWatchDisMissActionListener(new b());
        }
        if (this.f410769a.isShowing()) {
            return;
        }
        this.f410770b.setSelection(0, this.f410772d);
        this.f410770b.setSelection(1, this.f410773e);
        this.f410770b.setSelection(2, this.f410774f);
        try {
            this.f410769a.show();
        } catch (Exception e16) {
            QZLog.e("QzoneTimePicker", "catch an exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements IphonePickerView.IphonePickListener {
        a() {
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            if (c.this.f410776h != null) {
                c.this.f410776h.a(c.this.f410772d, c.this.f410773e, c.this.f410774f);
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            if (i3 == 0) {
                c.this.f410772d = i16;
            } else if (i3 == 1) {
                c.this.f410773e = i16;
            } else if (i3 == 2) {
                c.this.f410774f = i16;
            }
            if (c.this.f410779k != null) {
                c.this.f410779k.onItemSelected(i3, i16);
            }
            if (c.this.f410770b != null && (i3 == 0 || i3 == 1)) {
                c.this.f410770b.notifyDataSetChange(2);
                if (c.this.f410774f >= c.this.f410775g.getRowCount(2)) {
                    c cVar = c.this;
                    cVar.f410774f = cVar.f410775g.getRowCount(2) - 1;
                }
            }
            if (c.this.f410778j != null) {
                c.this.f410778j.onItemSelected(i3, i16);
            }
        }
    }

    public void r(int i3, int i16) {
        if (i3 == 0) {
            this.f410772d = i16;
        } else if (i3 == 1) {
            this.f410773e = i16;
        } else if (i3 == 2) {
            this.f410774f = i16;
        }
        IphonePickerView iphonePickerView = this.f410770b;
        if (iphonePickerView != null) {
            iphonePickerView.setSelection(i3, i16);
        }
        QZLog.d("QzoneTimePicker", 2, "setSelection column:" + i3 + ",row:" + i16);
    }
}
