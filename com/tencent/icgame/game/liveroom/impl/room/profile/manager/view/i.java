package com.tencent.icgame.game.liveroom.impl.room.profile.manager.view;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.util.HashMap;
import java.util.Map;
import qw0.m;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i extends ReportDialogFragment {
    protected g C;
    private String E;

    /* renamed from: e, reason: collision with root package name */
    protected ListView f115585e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f115586f;

    /* renamed from: i, reason: collision with root package name */
    public String f115588i;

    /* renamed from: m, reason: collision with root package name */
    private e f115589m;

    /* renamed from: d, reason: collision with root package name */
    private IAegisLogApi f115584d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: h, reason: collision with root package name */
    protected String[] f115587h = new String[0];
    private SparseArray<TextView> D = new SparseArray<>();
    private View.OnLayoutChangeListener F = new c();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            i.c(i.this);
            i.b(i.this);
            if (i.this.f115589m != null) {
                i.this.f115589m.a(i3, i.this.f115587h[i3]);
            }
            Map<String, String> h16 = i.this.h();
            VideoReport.setElementId(view, "em_icgame_manage_users_selection");
            i iVar = i.this;
            h16.put("icgame_manage_users_button_location", iVar.j(iVar.f115587h[i3]));
            ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("clck", view, i.this.h());
            i.this.i();
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (i.this.getDialog() != null) {
                try {
                    i.this.getDialog().dismiss();
                } catch (Exception e16) {
                    i.this.f115584d.e("ICGameSlidingDialog", "mTextView onClick e=" + e16);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements View.OnLayoutChangeListener {
        c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            i.f(i.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface e {
        void a(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface f {
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class g extends BaseAdapter {
        public g() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return i.this.f115587h.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return i.this.f115587h[i3];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(i.this.f115585e.getContext());
            textView.setWidth(viewGroup.getWidth());
            textView.setHeight(m.b(i.this.f115585e.getContext(), 50.0f));
            textView.setText(i.this.f115587h[i3]);
            textView.setTextSize(16.0f);
            textView.setTextColor(-16777216);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.lng);
            i.this.D.put(i3, textView);
            textView.setContentDescription(i.this.f115587h[i3]);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return textView;
        }
    }

    static /* bridge */ /* synthetic */ com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.a b(i iVar) {
        iVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ d c(i iVar) {
        iVar.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ f f(i iVar) {
        iVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(String str) {
        if (str.equals(getString(R.string.f1355701t))) {
            return "0";
        }
        if (str.equals(getString(R.string.zib))) {
            return "5";
        }
        if (str.equals(getString(R.string.f168152ev))) {
            return "1";
        }
        if (str.equals(getString(R.string.f225526lv))) {
            return "3";
        }
        if (str.equals(getString(R.string.zig))) {
            return "4";
        }
        return "";
    }

    protected Map<String, String> h() {
        HashMap hashMap = new HashMap();
        hashMap.put("zengzhi_moduleid", "em_icgame_inf_module");
        return hashMap;
    }

    public void i() {
        if (getDialog() != null) {
            try {
                getDialog().dismiss();
            } catch (Exception e16) {
                this.f115584d.e("ICGameSlidingDialog", "closeDialog e=" + e16);
            }
        }
    }

    public void k(String[] strArr) {
        this.f115587h = strArr;
    }

    public void l(e eVar) {
        this.f115589m = eVar;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = new g();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168195fb0, viewGroup, false);
        this.f115585e = (ListView) inflate.findViewById(R.id.uhu);
        this.f115586f = (TextView) inflate.findViewById(R.id.cancel);
        this.f115585e.setOverScrollMode(2);
        this.f115585e.addOnLayoutChangeListener(this.F);
        if (!TextUtils.isEmpty(this.f115588i)) {
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            textView.setVisibility(0);
            textView.setText(this.f115588i);
        }
        this.f115585e.setAdapter((ListAdapter) this.C);
        this.C.notifyDataSetChanged();
        this.f115585e.setOnItemClickListener(new a());
        this.f115586f.setOnClickListener(new b());
        if (!TextUtils.isEmpty(this.E)) {
            this.f115586f.setText(this.E);
        }
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().requestWindowFeature(1);
            getDialog().getWindow().setWindowAnimations(R.style.a0d);
            getDialog().setCanceledOnTouchOutside(true);
            getDialog().getWindow().setDimAmount(0.4f);
        }
        FragmentCollector.onFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        this.D.clear();
        this.f115585e.removeOnLayoutChangeListener(this.F);
        this.f115586f = null;
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().clearFlags(131080);
        }
        try {
            super.onDismiss(dialogInterface);
        } catch (Exception e16) {
            this.f115584d.e("ICGameSlidingDialog", "onDismiss e=" + e16);
        }
        this.f115589m = null;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (getShowsDialog()) {
            Window window = getDialog().getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(window.getWindowManager().getDefaultDisplay().getWidth(), -2);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setGravity(80);
        }
    }
}
