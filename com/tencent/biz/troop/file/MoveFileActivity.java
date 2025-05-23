package com.tencent.biz.troop.file;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import ef0.j;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MoveFileActivity extends IphoneTitleBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a0, reason: collision with root package name */
    protected long f96798a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f96799b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f96800c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f96801d0;

    /* renamed from: e0, reason: collision with root package name */
    private XListView f96802e0;

    /* renamed from: h0, reason: collision with root package name */
    private Button f96805h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f96806i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f96807j0;

    /* renamed from: k0, reason: collision with root package name */
    private TroopFileManager f96808k0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f96811n0;

    /* renamed from: s0, reason: collision with root package name */
    protected String f96816s0;

    /* renamed from: w0, reason: collision with root package name */
    private QQProgressDialog f96820w0;

    /* renamed from: f0, reason: collision with root package name */
    private ArrayList<n> f96803f0 = new ArrayList<>();

    /* renamed from: g0, reason: collision with root package name */
    private h f96804g0 = new h();

    /* renamed from: l0, reason: collision with root package name */
    private int f96809l0 = -1;

    /* renamed from: m0, reason: collision with root package name */
    private int f96810m0 = 15;

    /* renamed from: o0, reason: collision with root package name */
    private int f96812o0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    private int f96813p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    private ByteStringMicro f96814q0 = ByteStringMicro.copyFromUtf8("");

    /* renamed from: r0, reason: collision with root package name */
    private ef0.f f96815r0 = new c();

    /* renamed from: t0, reason: collision with root package name */
    int f96817t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f96818u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    private ef0.b f96819v0 = new g();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements TextUtils.EllipsizeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f96822a;

        a(TextView textView) {
            this.f96822a = textView;
        }

        @Override // android.text.TextUtils.EllipsizeCallback
        public void ellipsized(int i3, int i16) {
            if (i3 == i16) {
                this.f96822a.setText(MoveFileActivity.this.f96801d0);
                return;
            }
            String substring = MoveFileActivity.this.f96801d0.substring(0, i3);
            String substring2 = MoveFileActivity.this.f96801d0.substring(i16, MoveFileActivity.this.f96801d0.length());
            this.f96822a.setText(substring + MiniBoxNoticeInfo.APPNAME_SUFFIX + substring2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends j {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f96824d;

        b(n nVar) {
            this.f96824d = nVar;
        }

        @Override // ef0.j
        protected void c(boolean z16, int i3, String str) {
            int i16;
            String str2;
            MoveFileActivity.this.hideJuhua();
            Intent intent = new Intent();
            intent.putExtra("fileId", MoveFileActivity.this.f96800c0);
            intent.putExtra("folderId", this.f96824d.f294916b);
            int dimensionPixelSize = MoveFileActivity.this.getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            if (z16) {
                MoveFileActivity moveFileActivity = MoveFileActivity.this;
                QQAppInterface qQAppInterface = moveFileActivity.app;
                String l3 = Long.toString(moveFileActivity.f96798a0);
                if (MoveFileActivity.this.f96799b0.equals("/")) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_files", "", "file", "move_suc", 0, 0, l3, str2, "", "");
                QQToast.makeText(MoveFileActivity.this.getActivity(), 2, HardCodeUtil.qqStr(R.string.o_0), 0).show(dimensionPixelSize);
                MoveFileActivity.this.setResult(-1, intent);
            } else {
                if (i3 != -407) {
                    if (i3 != -406) {
                        if (i3 != -302 && i3 != -301) {
                            if (i3 != -136) {
                                if (i3 != -107) {
                                    if (i3 != -103) {
                                        if (i3 != -102) {
                                            QQToast.makeText(MoveFileActivity.this.getActivity(), 1, MoveFileActivity.this.getString(R.string.dpu), 0).show(dimensionPixelSize);
                                            MoveFileActivity.this.setResult(0, intent);
                                        }
                                    }
                                }
                                QQToast.makeText(MoveFileActivity.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.o9w), 0).show(dimensionPixelSize);
                                MoveFileActivity.this.setResult(0, intent);
                            } else {
                                MoveFileActivity moveFileActivity2 = MoveFileActivity.this;
                                ReportController.o(moveFileActivity2.app, "P_CliOper", "Grp_files", "", "file", "fail_move", 0, 0, Long.toString(moveFileActivity2.f96798a0), "", "", "");
                                i16 = 0;
                                QQToast.makeText(MoveFileActivity.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.o9x), 0).show(dimensionPixelSize);
                                MoveFileActivity.this.setResult(0, intent);
                            }
                        }
                        MoveFileActivity moveFileActivity3 = MoveFileActivity.this;
                        ReportController.o(moveFileActivity3.app, "P_CliOper", "Grp_files", "", "file", "fail_move_nofile", 0, 0, Long.toString(moveFileActivity3.f96798a0), "", "", "");
                        i16 = 0;
                        QQToast.makeText(MoveFileActivity.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.o9t), 0).show(dimensionPixelSize);
                        MoveFileActivity.this.setResult(0, intent);
                    } else {
                        i16 = 0;
                        QQToast.makeText(MoveFileActivity.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.o9s), 0).show(dimensionPixelSize);
                        MoveFileActivity.this.setResult(0, intent);
                    }
                } else {
                    i16 = 0;
                    QQToast.makeText(MoveFileActivity.this.getActivity(), 1, HardCodeUtil.qqStr(R.string.o9u), 0).show(dimensionPixelSize);
                    MoveFileActivity.this.setResult(0, intent);
                }
                MoveFileActivity.this.finish();
                MoveFileActivity.this.overridePendingTransition(i16, R.anim.f154458a7);
            }
            i16 = 0;
            MoveFileActivity.this.finish();
            MoveFileActivity.this.overridePendingTransition(i16, R.anim.f154458a7);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c extends ef0.f {
        c() {
        }

        @Override // ef0.f
        public void c(boolean z16, boolean z17, int i3, int i16, int i17, ByteStringMicro byteStringMicro, List<n> list, Bundle bundle) {
            MoveFileActivity.this.c3(true);
            if (z16 && list != null) {
                MoveFileActivity.this.f96813p0 = i17;
                MoveFileActivity.this.f96811n0 = z17;
                boolean z18 = bundle.getBoolean("isFirstPage");
                for (n nVar : list) {
                    if (MoveFileActivity.this.f96808k0.f301893e.get(nVar.f294916b) == null) {
                        nVar.f294915a = UUID.randomUUID();
                        MoveFileActivity.this.f96808k0.f301893e.put(nVar.f294916b, nVar);
                    }
                }
                if (z18) {
                    MoveFileActivity.this.f96803f0.clear();
                    if (!MoveFileActivity.this.f96799b0.equals("/")) {
                        n nVar2 = new n();
                        nVar2.f294917c = HardCodeUtil.qqStr(R.string.o9y);
                        nVar2.f294916b = "/";
                        nVar2.B = true;
                        nVar2.f294933s = -1;
                        MoveFileActivity.this.f96803f0.add(nVar2);
                    }
                }
                MoveFileActivity.this.f96812o0 = i3;
                if (!MoveFileActivity.this.f96799b0.equals("/")) {
                    int size = list.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        if (!list.get(size).f294916b.equals(MoveFileActivity.this.f96799b0)) {
                            size--;
                        } else if (MoveFileActivity.this.f96809l0 == -1) {
                            MoveFileActivity moveFileActivity = MoveFileActivity.this;
                            moveFileActivity.f96809l0 = (moveFileActivity.f96803f0.size() + size) - 1;
                            MoveFileActivity.this.f96805h0.setEnabled(true);
                            MoveFileActivity.this.f96805h0.setBackgroundResource(R.drawable.f1721if);
                            MoveFileActivity.this.f96805h0.setTextAppearance(MoveFileActivity.this.getActivity(), R.style.f173650i0);
                        }
                    }
                    MoveFileActivity.this.f96803f0.addAll(MoveFileActivity.this.f96803f0.size() - 1, list);
                } else {
                    MoveFileActivity.this.f96803f0.addAll(list);
                }
                MoveFileActivity.this.f96804g0.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.biz.widgets.a aVar = (com.tencent.biz.widgets.a) dialogInterface;
            if (TextUtils.isEmpty(aVar.getInputValue().trim())) {
                QQToast.makeText(HardCodeUtil.sContex, 1, HardCodeUtil.qqStr(R.string.f180213ag), 0).show();
                return;
            }
            MoveFileActivity.this.f96816s0 = aVar.getInputValue().trim();
            if (MoveFileActivity.this.f96816s0.length() > TroopFileUtils.f301968a) {
                aVar.P(MoveFileActivity.this.getString(R.string.elx), SupportMenu.CATEGORY_MASK);
                ReportController.o(MoveFileActivity.this.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, MoveFileActivity.this.f96798a0 + "", "", "", "");
                return;
            }
            if (TroopFileUtils.y(MoveFileActivity.this.f96816s0)) {
                aVar.P(MoveFileActivity.this.getString(R.string.ely), SupportMenu.CATEGORY_MASK);
                ReportController.o(MoveFileActivity.this.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, MoveFileActivity.this.f96798a0 + "", "0", "", "");
                return;
            }
            aVar.dismiss();
            MoveFileActivity moveFileActivity = MoveFileActivity.this;
            if (TroopFileUtils.d(moveFileActivity.app, moveFileActivity, moveFileActivity.f96798a0) == 0) {
                return;
            }
            MoveFileActivity moveFileActivity2 = MoveFileActivity.this;
            com.tencent.biz.troop.file.a.b(moveFileActivity2.app, moveFileActivity2.f96798a0, "/", moveFileActivity2.f96816s0, moveFileActivity2.f96819v0);
            MoveFileActivity.this.showJuhua(R.string.f171379ek3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g extends ef0.b {
        g() {
        }

        @Override // ef0.b
        protected void c(boolean z16, int i3, n nVar) {
            String string;
            if (MoveFileActivity.this.getActivity().isFinishing()) {
                return;
            }
            MoveFileActivity.this.hideJuhua();
            int dimensionPixelSize = MoveFileActivity.this.getActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            if (z16) {
                MoveFileActivity.this.f96803f0.add(0, nVar);
                MoveFileActivity.this.f96809l0 = 0;
                MoveFileActivity.this.f96805h0.setEnabled(true);
                MoveFileActivity.this.f96805h0.setBackgroundResource(R.drawable.f1721if);
                MoveFileActivity.this.f96805h0.setTextAppearance(MoveFileActivity.this.getActivity(), R.style.f173650i0);
                MoveFileActivity.this.f96808k0.h(nVar);
                MoveFileActivity.this.f96804g0.notifyDataSetChanged();
                ReportController.o(MoveFileActivity.this.app, "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, MoveFileActivity.this.f96798a0 + "", nVar.f294916b, "", "");
                QQToast.makeText(MoveFileActivity.this.getActivity(), 2, HardCodeUtil.qqStr(R.string.o9z), 0).show(dimensionPixelSize);
                return;
            }
            if (i3 != -405) {
                if (i3 != -313) {
                    if (i3 != -303) {
                        if (i3 != -134) {
                            if (i3 != -107 && i3 != -102) {
                                QQToast.makeText(MoveFileActivity.this.getActivity(), 1, MoveFileActivity.this.getString(R.string.dpu), 0).show(dimensionPixelSize);
                                return;
                            } else {
                                QQToast.makeText(MoveFileActivity.this.getActivity(), 1, MoveFileActivity.this.getString(R.string.elv), 0).show(dimensionPixelSize);
                                return;
                            }
                        }
                        string = MoveFileActivity.this.getString(R.string.ely);
                        ReportController.o(MoveFileActivity.this.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, MoveFileActivity.this.f96798a0 + "", "1", "", "");
                    } else {
                        string = MoveFileActivity.this.getString(R.string.elz);
                        QQToast.makeText(MoveFileActivity.this.getActivity(), 1, string, 0).show(dimensionPixelSize);
                    }
                } else {
                    string = MoveFileActivity.this.getString(R.string.elt);
                    ReportController.o(MoveFileActivity.this.app, "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, MoveFileActivity.this.f96798a0 + "", "1", "", "");
                }
                MoveFileActivity moveFileActivity = MoveFileActivity.this;
                moveFileActivity.d3(moveFileActivity.getResources().getString(R.string.epv), null, MoveFileActivity.this.f96816s0, string);
                return;
            }
            QQToast.makeText(MoveFileActivity.this.getActivity(), 1, MoveFileActivity.this.getString(R.string.elw), 0).show(dimensionPixelSize);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class h extends BaseAdapter implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private int f96832d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f96833e = 0;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a extends View.AccessibilityDelegate {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f96835a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f96836b;

            a(String str, int i3) {
                this.f96835a = str;
                this.f96836b = i3;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setContentDescription(this.f96835a);
                boolean z16 = true;
                accessibilityNodeInfo.setCheckable(true);
                if (this.f96836b != MoveFileActivity.this.f96809l0) {
                    z16 = false;
                }
                accessibilityNodeInfo.setChecked(z16);
            }
        }

        h() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MoveFileActivity.this.f96803f0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return MoveFileActivity.this.f96803f0.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = MoveFileActivity.this.getLayoutInflater().inflate(R.layout.ai_, (ViewGroup) MoveFileActivity.this.f96802e0, false);
                i iVar = new i();
                iVar.f96838i = (TextView) view.findViewById(R.id.cgo);
                iVar.f96839m = (ImageView) view.findViewById(R.id.cgn);
                iVar.C = (TextView) view.findViewById(R.id.awy);
                view.setTag(iVar);
            }
            i iVar2 = (i) view.getTag();
            n nVar = (n) MoveFileActivity.this.f96803f0.get(i3);
            if (nVar != null) {
                if (MoveFileActivity.this.b3(i3)) {
                    iVar2.f96838i.setText(nVar.f294917c);
                    iVar2.f96839m.setImageResource(R.drawable.e3g);
                } else {
                    iVar2.f96838i.setText(HardCodeUtil.qqStr(R.string.o9v));
                    iVar2.f96839m.setImageResource(R.drawable.e3i);
                }
                if (i3 == MoveFileActivity.this.f96809l0) {
                    iVar2.C.setVisibility(0);
                } else {
                    iVar2.C.setVisibility(4);
                }
            }
            iVar2.f96838i.setAccessibilityDelegate(new a(iVar2.f96838i.getText().toString(), i3));
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            this.f96833e = i17;
            this.f96832d = ((i3 + i16) - 1) - 1;
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0) {
                QLog.e("IphoneTitleBarActivity", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
                if (this.f96832d == this.f96833e - 2) {
                    if (MoveFileActivity.this.f96811n0) {
                        MoveFileActivity.this.c3(true);
                        return;
                    }
                    MoveFileActivity.this.c3(false);
                    MoveFileActivity moveFileActivity = MoveFileActivity.this;
                    if (TroopFileUtils.d(moveFileActivity.app, moveFileActivity, moveFileActivity.f96798a0) != 0) {
                        MoveFileActivity.this.Y2();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class i extends k {
        public TextView C;

        /* renamed from: i, reason: collision with root package name */
        public TextView f96838i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f96839m;

        i() {
        }
    }

    public static Intent Z2(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", MoveFileActivity.class.getName());
        intent.putExtra("troop_uin", str);
        if (str2 == null) {
            str2 = "/";
        }
        intent.putExtra("folder_id", str2);
        intent.putExtra("file_id", str3);
        intent.putExtra("file_name", str4);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b3(int i3) {
        if (this.f96799b0.equals("/") || i3 < this.f96803f0.size() - 1) {
            return true;
        }
        return false;
    }

    private void init() {
        Y2();
    }

    public void Y2() {
        com.tencent.biz.troop.file.a.g(this.app, this.f96798a0, this.f96812o0, 0, this.f96810m0, 3, 1, "/", 1, 0L, null, this.f96813p0, true, this.f96814q0, this.f96815r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c3(boolean z16) {
        if (this.f96802e0.getFirstVisiblePosition() == 0) {
            this.f96806i0.setVisibility(8);
            return;
        }
        if (z16) {
            this.f96806i0.setVisibility(8);
            return;
        }
        this.f96806i0.setVisibility(0);
        this.f96807j0.setText(R.string.hqg);
        Drawable drawable = getResources().getDrawable(R.drawable.f160545jt);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f96807j0.setCompoundDrawables(drawable, null, null, null);
        ((Animatable) drawable).start();
    }

    public void d3(String str, String str2, String str3, String str4) {
        com.tencent.biz.widgets.a N = com.tencent.biz.widgets.a.N(this, str, "", R.string.cancel, R.string.a8j, new d(), new e());
        final EditText editText = N.getEditText();
        if (!TextUtils.isEmpty(str3)) {
            editText.setText(str3);
            editText.setSelectAllOnFocus(true);
        }
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(48)});
        editText.setHint(R.string.erv);
        editText.addTextChangedListener(new f(editText));
        if (!TextUtils.isEmpty(str4)) {
            N.P(str4, SupportMenu.CATEGORY_MASK);
        }
        N.show();
        editText.postDelayed(new Runnable() { // from class: com.tencent.biz.troop.file.MoveFileActivity.7
            @Override // java.lang.Runnable
            public void run() {
                editText.requestFocus();
                InputMethodUtil.show(editText);
            }
        }, 100L);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("troop_uin");
        if (TextUtils.isEmpty(string)) {
            finish();
            return false;
        }
        this.f96798a0 = Long.valueOf(string).longValue();
        String string2 = extras.getString("folder_id");
        this.f96799b0 = string2;
        if (TextUtils.isEmpty(string2)) {
            finish();
            return false;
        }
        String string3 = extras.getString("file_name");
        this.f96801d0 = string3;
        if (TextUtils.isEmpty(string3)) {
            finish();
            return false;
        }
        String string4 = extras.getString("file_id");
        this.f96800c0 = string4;
        if (TextUtils.isEmpty(string4)) {
            finish();
            return false;
        }
        this.f96808k0 = TroopFileManager.F(this.app, this.f96798a0);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.f168598ai4, (ViewGroup) null);
        XListView xListView = (XListView) inflate.findViewById(R.id.common_xlistview);
        this.f96802e0 = xListView;
        xListView.setVerticalScrollBarEnabled(false);
        this.f96802e0.setDivider(null);
        this.f96802e0.setFocusable(false);
        this.f96802e0.setOnItemClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.bbo);
        this.f96805h0 = (Button) inflate.findViewById(R.id.b7m);
        textView.setOnClickListener(this);
        this.f96805h0.setOnClickListener(this);
        setContentView(inflate);
        setTitle(R.string.erl);
        TextView textView2 = (TextView) findViewById(R.id.ivTitleBtnRightText);
        textView2.setText(R.string.cancel);
        textView2.setOnClickListener(this);
        textView2.setVisibility(0);
        this.leftView.setVisibility(8);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ca5);
        TextUtils.ellipsize(this.f96801d0, textView3.getPaint(), BaseAIOUtils.f(230.0f, getResources()), TextUtils.TruncateAt.MIDDLE, false, new a(textView3));
        View inflate2 = layoutInflater.inflate(R.layout.ai9, (ViewGroup) null);
        this.f96806i0 = inflate2;
        inflate2.findViewById(R.id.giy).setBackgroundResource(R.drawable.bg_texture);
        this.f96802e0.addFooterView(this.f96806i0);
        this.f96806i0.setVisibility(8);
        TextView textView4 = (TextView) this.f96806i0.findViewById(R.id.giz);
        this.f96807j0 = textView4;
        textView4.setTextColor(getResources().getColor(R.color.skin_black));
        this.f96802e0.setOnScrollListener(this.f96804g0);
        this.f96802e0.setAdapter((ListAdapter) this.f96804g0);
        init();
        ReportController.o(this.app, "P_CliOper", "Grp_files", "", "file", "move_file", 0, 0, Long.toString(this.f96798a0), "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
    }

    public void hideJuhua() {
        try {
            QQProgressDialog qQProgressDialog = this.f96820w0;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f96820w0.dismiss();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("IphoneTitleBarActivity", 2, e16.toString());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightText) {
            ReportController.o(this.app, "P_CliOper", "Grp_files", "", "file", "move_cancel", 0, 0, Long.toString(this.f96798a0), "", "", "");
            finish();
            overridePendingTransition(0, R.anim.f154458a7);
        } else if (id5 == R.id.bbo) {
            if (TroopFileUtils.d(this.app, this, this.f96798a0) != 0) {
                d3(getResources().getString(R.string.epv), null, this.f96816s0, "");
            }
        } else if (id5 == R.id.b7m) {
            n nVar = this.f96803f0.get(this.f96809l0);
            if (this.f96799b0.equals(nVar.f294916b)) {
                finish();
                overridePendingTransition(0, R.anim.f154458a7);
            } else {
                try {
                    if (TroopFileUtils.d(this.app, this, this.f96798a0) != 0) {
                        com.tencent.biz.troop.file.a.l(this.app, this.f96798a0, nVar.f294919e, this.f96800c0, this.f96799b0, nVar.f294916b, new b(nVar));
                        showJuhua(R.string.erm);
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        if (i3 == this.f96809l0) {
            return;
        }
        this.f96805h0.setEnabled(true);
        this.f96805h0.setBackgroundResource(R.drawable.f1721if);
        this.f96805h0.setTextAppearance(getActivity(), R.style.f173650i0);
        this.f96809l0 = i3;
        this.f96804g0.notifyDataSetChanged();
    }

    public void showJuhua(int i3) {
        try {
            if (this.f96820w0 == null) {
                this.f96820w0 = new QQProgressDialog(this, getTitleBarHeight());
            }
            this.f96820w0.setMessage(i3);
            this.f96820w0.setBackAndSearchFilter(false);
            this.f96820w0.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("IphoneTitleBarActivity", 2, e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f96829d;

        f(EditText editText) {
            this.f96829d = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (i17 > 0) {
                String charSequence2 = charSequence.toString();
                String g16 = TroopFileUtils.g(charSequence2);
                if (charSequence2 != null && !charSequence2.equals(g16)) {
                    MoveFileActivity moveFileActivity = MoveFileActivity.this;
                    moveFileActivity.f96817t0 = i3;
                    moveFileActivity.f96818u0 = true;
                    this.f96829d.setText(g16);
                    return;
                }
                MoveFileActivity moveFileActivity2 = MoveFileActivity.this;
                if (moveFileActivity2.f96818u0) {
                    this.f96829d.setSelection(moveFileActivity2.f96817t0);
                    MoveFileActivity.this.f96818u0 = false;
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
