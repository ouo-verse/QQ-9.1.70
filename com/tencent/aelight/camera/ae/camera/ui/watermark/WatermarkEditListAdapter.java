package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.light.bean.WMElement;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WatermarkEditListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements DatePicker.OnDateChangedListener {
    private TextView C;

    /* renamed from: d, reason: collision with root package name */
    private final List<WMElement> f63379d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f63380e;

    /* renamed from: f, reason: collision with root package name */
    private j f63381f;

    /* renamed from: i, reason: collision with root package name */
    private WMElement f63383i;

    /* renamed from: m, reason: collision with root package name */
    private EditText f63384m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f63382h = true;
    private final SimpleDateFormat D = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WMElement f63386d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f63387e;

        a(WMElement wMElement, i iVar) {
            this.f63386d = wMElement;
            this.f63387e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WMElement.TYPE_CHECK_IN.equals(this.f63386d.type)) {
                WatermarkEditListAdapter.this.G(this.f63387e);
            } else {
                this.f63387e.f63403d.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            InputMethodManager inputMethodManager = (InputMethodManager) AEModule.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (WatermarkEditListAdapter.this.f63384m != null) {
                inputMethodManager.hideSoftInputFromWindow(WatermarkEditListAdapter.this.f63384m.getWindowToken(), 0);
                WatermarkEditListAdapter watermarkEditListAdapter = WatermarkEditListAdapter.this;
                watermarkEditListAdapter.y(watermarkEditListAdapter.f63384m);
                WatermarkEditListAdapter.this.f63384m.setTextColor(-1);
            }
            if (WatermarkEditListAdapter.this.f63381f != null) {
                WatermarkEditListAdapter.this.f63381f.c();
            }
            AESelectLocationFragment.th(WatermarkEditListAdapter.this.f63380e, 203);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f63390d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WMElement f63391e;

        c(i iVar, WMElement wMElement) {
            this.f63390d = iVar;
            this.f63391e = wMElement;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((InputMethodManager) AEModule.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(WatermarkEditListAdapter.this.f63384m.getWindowToken(), 0);
            WatermarkEditListAdapter.this.f63384m.setTextColor(-1);
            WatermarkEditListAdapter watermarkEditListAdapter = WatermarkEditListAdapter.this;
            watermarkEditListAdapter.y(watermarkEditListAdapter.f63384m);
            WatermarkEditListAdapter.this.f63384m = this.f63390d.f63403d;
            if (gq.a.r(WatermarkEditListAdapter.this.f63380e.getIntent())) {
                WatermarkEditListAdapter.this.f63384m.setTextColor(WatermarkEditListAdapter.this.f63380e.getResources().getColor(R.color.afb));
            } else {
                WatermarkEditListAdapter.this.f63384m.setTextColor(WatermarkEditListAdapter.this.f63380e.getResources().getColor(R.color.afc));
            }
            WatermarkEditListAdapter.this.f63383i = this.f63391e;
            if (WatermarkEditListAdapter.this.f63381f != null) {
                WatermarkEditListAdapter.this.f63381f.b(WatermarkEditListAdapter.this.C(this.f63391e.getInnerValue()));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f63396d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WMElement f63397e;

        e(i iVar, WMElement wMElement) {
            this.f63396d = iVar;
            this.f63397e = wMElement;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            WatermarkEditListAdapter.this.D(this.f63396d.f63403d, this.f63397e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f63400d;

        g(i iVar) {
            this.f63400d = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            i iVar = this.f63400d;
            iVar.f63406h = true;
            iVar.f63403d.setText("1");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i extends RecyclerView.ViewHolder {
        public TextView C;
        public ImageView D;

        /* renamed from: d, reason: collision with root package name */
        public EditText f63403d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f63404e;

        /* renamed from: f, reason: collision with root package name */
        public Button f63405f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f63406h;

        /* renamed from: i, reason: collision with root package name */
        public View f63407i;

        /* renamed from: m, reason: collision with root package name */
        public View f63408m;

        public i(View view) {
            super(view);
            this.f63403d = (EditText) view.findViewById(R.id.rso);
            this.f63404e = (ImageView) view.findViewById(R.id.rry);
            this.f63405f = (Button) view.findViewById(R.id.rzl);
            this.f63407i = view.findViewById(R.id.f163768rx0);
            this.f63408m = view.findViewById(R.id.rsl);
            this.C = (TextView) view.findViewById(R.id.rwz);
            this.D = (ImageView) view.findViewById(R.id.rvw);
            this.f63406h = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface j {
        void a();

        void b(Date date);

        void c();
    }

    public WatermarkEditListAdapter(Activity activity, List<WMElement> list) {
        this.f63379d = list;
        this.f63380e = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Date C(String str) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            ms.a.d("WatermarkEditListAdapter", "parseToDate---parseLong error: ", e16);
            j3 = 0;
        }
        return new Date(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(EditText editText, WMElement wMElement) {
        this.f63384m.setTextColor(-1);
        this.f63384m = editText;
        this.f63383i = wMElement;
        editText.setCursorVisible(true);
        j jVar = this.f63381f;
        if (jVar != null) {
            jVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(i iVar) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this.f63384m.getContext(), R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.vji));
        qQCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.vjn));
        qQCustomDialog.setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), new f());
        qQCustomDialog.setPositiveButton(HardCodeUtil.qqStr(R.string.vjk), new g(iVar));
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
    }

    public void A() {
        WMElement wMElement;
        List<WMElement> list = this.f63379d;
        if (list == null || list.isEmpty() || this.f63384m == null || (wMElement = this.f63383i) == null) {
            return;
        }
        if (!WMElement.TYPE_SINCE.equals(wMElement.type) && !WMElement.TYPE_COUNTDOWN.equals(this.f63383i.type)) {
            if (WMElement.TYPE_PLAIN_TEXT.equals(this.f63383i.type)) {
                this.f63384m.requestFocus();
                EditText editText = this.f63384m;
                editText.setSelection(editText.getText().toString().length());
                ((InputMethodManager) AEModule.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.f63384m, 1);
                j jVar = this.f63381f;
                if (jVar != null) {
                    jVar.a();
                    return;
                }
                return;
            }
            return;
        }
        if (gq.a.r(this.f63380e.getIntent())) {
            this.f63384m.setTextColor(this.f63380e.getResources().getColor(R.color.afb));
        } else {
            this.f63384m.setTextColor(this.f63380e.getResources().getColor(R.color.afc));
        }
        j jVar2 = this.f63381f;
        if (jVar2 != null) {
            jVar2.b(C(this.f63383i.getInnerValue()));
        }
    }

    public void E(j jVar) {
        this.f63381f = jVar;
    }

    public void F(String str) {
        if (this.f63379d == null) {
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(str);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WMElement> list = this.f63379d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        WMElement wMElement = this.f63379d.get(i3);
        if (wMElement == null) {
            return;
        }
        i iVar = (i) viewHolder;
        if (i3 == 0) {
            if (this.f63382h) {
                this.f63382h = false;
                this.f63384m = iVar.f63403d;
                this.f63383i = wMElement;
            }
            if (getItemCount() == 1) {
                iVar.f63403d.setSingleLine(false);
            }
        }
        if (i3 == getItemCount() - 1) {
            iVar.f63404e.setVisibility(8);
        }
        iVar.f63405f.setOnClickListener(new a(wMElement, iVar));
        if (WMElement.TYPE_EDITABLE_LOCATION.equals(wMElement.type)) {
            iVar.f63408m.setVisibility(8);
            iVar.f63407i.setVisibility(0);
            TextView textView = iVar.C;
            this.C = textView;
            if (textView != null) {
                textView.setText(B(wMElement));
                iVar.f63407i.setOnClickListener(new b());
                return;
            }
            return;
        }
        if (!WMElement.TYPE_SINCE.equals(wMElement.type) && !WMElement.TYPE_COUNTDOWN.equals(wMElement.type)) {
            if (WMElement.TYPE_CHECK_IN.equals(wMElement.type) || WMElement.TYPE_PLAIN_TEXT.equals(wMElement.type)) {
                iVar.f63408m.setVisibility(0);
                iVar.f63407i.setVisibility(8);
                iVar.f63403d.setText(B(wMElement));
                if (WMElement.TYPE_CHECK_IN.equals(wMElement.type)) {
                    iVar.f63403d.setFocusable(false);
                    iVar.f63403d.setFocusableInTouchMode(false);
                    iVar.f63405f.setBackgroundResource(R.drawable.f159981ix0);
                    iVar.f63405f.setVisibility(0);
                } else {
                    iVar.f63403d.setFocusable(true);
                    iVar.f63403d.setFocusableInTouchMode(true);
                    iVar.f63403d.requestFocus();
                    iVar.f63405f.setBackgroundResource(R.drawable.iwz);
                    iVar.f63405f.setVisibility(0);
                }
                iVar.f63403d.setOnFocusChangeListener(new d(iVar, wMElement));
                iVar.f63403d.setOnClickListener(new e(iVar, wMElement));
                return;
            }
            return;
        }
        iVar.f63408m.setVisibility(0);
        iVar.f63407i.setVisibility(8);
        iVar.f63405f.setVisibility(4);
        iVar.f63403d.setText(B(wMElement));
        iVar.f63403d.setFocusable(false);
        iVar.f63403d.setCursorVisible(false);
        iVar.f63403d.setOnClickListener(new c(iVar, wMElement));
        z(iVar.f63403d);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new i(LayoutInflater.from(this.f63380e).inflate(R.layout.f167492dm1, viewGroup, false));
    }

    @Override // android.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i3, int i16, int i17) {
        String str;
        if (this.f63384m == null || this.f63383i == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append(HardCodeUtil.qqStr(R.string.vjm));
        int i18 = i16 + 1;
        String str2 = "0";
        if (i18 < 10) {
            str = "0";
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(i18);
        sb5.append(HardCodeUtil.qqStr(R.string.vjh));
        if (i17 >= 10) {
            str2 = "";
        }
        sb5.append(str2);
        sb5.append(i17);
        sb5.append(HardCodeUtil.qqStr(R.string.vjl));
        this.f63384m.setText(sb5.toString());
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i16, i17);
        this.f63384m.setTag(calendar.getTime());
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements View.OnFocusChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f63393d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WMElement f63394e;

        d(i iVar, WMElement wMElement) {
            this.f63393d = iVar;
            this.f63394e = wMElement;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                WatermarkEditListAdapter.this.D(this.f63393d.f63403d, this.f63394e);
                this.f63393d.f63405f.setBackgroundResource(R.drawable.iwz);
                this.f63393d.f63405f.setVisibility(0);
                return;
            }
            this.f63393d.f63405f.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final EditText editText) {
        if (editText != null) {
            editText.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.8
                @Override // java.lang.Runnable
                public void run() {
                    editText.clearFocus();
                    editText.setCursorVisible(false);
                }
            }, 200L);
        }
    }

    private void z(EditText editText) {
        if (editText != null) {
            editText.setCustomSelectionActionModeCallback(new h());
        }
    }

    private String B(WMElement wMElement) {
        long j3;
        if (wMElement == null) {
            return null;
        }
        String innerValue = wMElement.getInnerValue();
        if (!WMElement.TYPE_SINCE.equals(wMElement.type) && !WMElement.TYPE_COUNTDOWN.equals(wMElement.type)) {
            return innerValue;
        }
        try {
            j3 = Long.parseLong(innerValue);
        } catch (NumberFormatException e16) {
            ms.a.d("WatermarkEditListAdapter", "getDisplayText---parseLong error: ", e16);
            j3 = 0;
        }
        return this.D.format(new Date(j3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements ActionMode.Callback {
        h() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
