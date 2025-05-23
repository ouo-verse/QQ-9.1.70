package com.tencent.mobileqq.datareportviewer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DataReportSettingFragment extends IphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    protected FormSwitchItem C;
    protected FormSwitchItem D;
    protected ListView E;
    protected ArrayList<com.tencent.mobileqq.datareportviewer.a> F;
    protected d G;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportSettingFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if (z16) {
                com.tencent.mobileqq.datareportviewer.b.i().g();
            } else {
                com.tencent.mobileqq.datareportviewer.b.i().f();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportSettingFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                if (!z16) {
                    com.tencent.mobileqq.datareportviewer.b.i().n();
                }
                com.tencent.mobileqq.datareportviewer.b.F = z16;
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                QQCustomDialog qQCustomDialog = (QQCustomDialog) dialogInterface;
                EditText editText = (EditText) qQCustomDialog.findViewById(R.id.f5m);
                EditText editText2 = (EditText) qQCustomDialog.findViewById(R.id.f163920c9);
                if (!TextUtils.isEmpty(editText.getText().toString()) && !TextUtils.isEmpty(editText2.getText().toString())) {
                    com.tencent.mobileqq.datareportviewer.c cVar = new com.tencent.mobileqq.datareportviewer.c();
                    cVar.f203342a = editText.getText().toString();
                    cVar.f203351c = editText2.getText().toString();
                    cVar.f203353e = true;
                    com.tencent.mobileqq.datareportviewer.b.i().e(cVar);
                    DataReportSettingFragment.this.G.notifyDataSetChanged();
                    return;
                }
                QQToast.makeText(DataReportSettingFragment.this.getBaseActivity(), 1, HardCodeUtil.qqStr(R.string.l99), 0).show();
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportSettingFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                DialogUtil.createCustomDialog(DataReportSettingFragment.this.getBaseActivity(), 0, R.layout.f168406v8, HardCodeUtil.qqStr(R.string.l9b), "", HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new a(), new b()).show();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportSettingFragment.this);
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.datareportviewer.a getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.datareportviewer.a) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return DataReportSettingFragment.this.F.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return DataReportSettingFragment.this.F.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            f fVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(DataReportSettingFragment.this.getBaseActivity()).inflate(R.layout.f168404v6, viewGroup, false);
                    fVar = new f();
                    fVar.f203303a = (FormSwitchItem) view.findViewById(R.id.f165876dr4);
                    e eVar = new e();
                    fVar.f203304b = eVar;
                    fVar.f203303a.setOnCheckedChangeListener(eVar);
                    fVar.f203303a.setOnLongClickListener(fVar.f203304b);
                    view.setTag(fVar);
                } else {
                    fVar = (f) view.getTag();
                }
                com.tencent.mobileqq.datareportviewer.a item = getItem(i3);
                fVar.f203303a.setChecked(item.f203343b);
                if (item instanceof com.tencent.mobileqq.datareportviewer.c) {
                    fVar.f203303a.setText(item.f203342a + " - " + ((com.tencent.mobileqq.datareportviewer.c) item).f203351c);
                } else {
                    fVar.f203303a.setText(item.f203342a);
                }
                fVar.f203304b.f203299d = item;
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class e implements CompoundButton.OnCheckedChangeListener, View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.mobileqq.datareportviewer.a f203299d;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    com.tencent.mobileqq.datareportviewer.b.i().l(e.this.f203299d);
                    DataReportSettingFragment.this.G.notifyDataSetChanged();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        protected e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportSettingFragment.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                com.tencent.mobileqq.datareportviewer.a aVar = this.f203299d;
                if (aVar != null) {
                    aVar.f203343b = z16;
                    com.tencent.mobileqq.datareportviewer.b.i().m();
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view)).booleanValue();
            } else {
                DialogUtil.createCustomDialog(DataReportSettingFragment.this.getBaseActivity(), 230, null, HardCodeUtil.qqStr(R.string.l9d), new a(), new b()).show();
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    protected class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        FormSwitchItem f203303a;

        /* renamed from: b, reason: collision with root package name */
        e f203304b;

        protected f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DataReportSettingFragment.this);
            }
        }
    }

    public DataReportSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bx5);
        this.D = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.a1o);
        this.E = (ListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166862iq0);
        this.C.setChecked(com.tencent.mobileqq.datareportviewer.b.i().k());
        this.C.setOnCheckedChangeListener(new a());
        this.D.setOnCheckedChangeListener(new b());
        setRightButton(R.string.f170028dd, new c());
        this.F = com.tencent.mobileqq.datareportviewer.b.i().h();
        d dVar = new d();
        this.G = dVar;
        this.E.setAdapter((ListAdapter) dVar);
        qh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.f168405v7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(HardCodeUtil.qqStr(R.string.l98));
        return onCreateCenterView;
    }

    protected void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/data/0e9a7ce1473f44db9732a452360195ae.json";
        g gVar = new g("https://pub.idqqimg.com/pc/misc/files/20180717/0e9a7ce1473f44db9732a452360195ae.json", new File(str));
        gVar.A = 60L;
        ((DownloaderFactory) getBaseActivity().app.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1).startDownload(gVar, new com.tencent.mobileqq.vip.f(str) { // from class: com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f203289a;

            {
                this.f203289a = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DataReportSettingFragment.this, (Object) str);
                }
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onDone(g gVar2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) gVar2);
                    return;
                }
                if (gVar2.f313006d == 0) {
                    File file = new File(this.f203289a);
                    if (file.exists()) {
                        try {
                            JSONArray jSONArray = new JSONArray(FileUtils.readFileContent(file));
                            ArrayList arrayList = new ArrayList(jSONArray.length());
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                                if (TextUtils.isEmpty(optJSONObject.optString(VipFunCallConstants.KEY_GROUP))) {
                                    arrayList.add(com.tencent.mobileqq.datareportviewer.c.c(optJSONObject));
                                } else {
                                    arrayList.add(com.tencent.mobileqq.datareportviewer.d.c(optJSONObject));
                                }
                            }
                            DataReportSettingFragment.this.getBaseActivity().runOnUiThread(new Runnable(arrayList) { // from class: com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ ArrayList f203291d;

                                {
                                    this.f203291d = arrayList;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) arrayList);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    com.tencent.mobileqq.datareportviewer.b.i().o(this.f203291d);
                                    DataReportSettingFragment.this.G.notifyDataSetChanged();
                                    QQToast.makeText(DataReportSettingFragment.this.getBaseActivity(), HardCodeUtil.qqStr(R.string.l9_), 0).show();
                                }
                            });
                            return;
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IphoneTitleBarFragment", 2, "downloadGuide failed");
                }
            }
        }, new Bundle());
    }
}
