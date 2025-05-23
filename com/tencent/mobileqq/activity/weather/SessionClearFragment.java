package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.activity.lastclean.LastCleanMMKVHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.messageclean.ak;
import com.tencent.mobileqq.app.message.messageclean.q;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.w;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.util.Pair;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SessionClearFragment extends IphoneTitleBarFragment implements en {
    static IPatchRedirector $redirector_;
    private PinnedHeaderExpandableListView C;
    private com.tencent.mobileqq.activity.weather.b D;
    private Button E;
    private TextView F;
    private Button G;
    private RelativeLayout H;
    private boolean I;
    private int J;
    private QQProgressDialog K;
    private Activity L;
    private int M;
    private LinearLayout N;
    private ak P;
    private long Q;
    private long R;
    private QQAppInterface S;
    private ak.e T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SessionClearFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (SessionClearFragment.this.J == 0) {
                SessionClearFragment.this.E.setText(HardCodeUtil.qqStr(R.string.tbk));
                SessionClearFragment.this.J = 1;
                SessionClearFragment.this.D.v();
                ReportController.o(null, "dc00898", "", "", "0X800A0C6", "0X800A0C6", 0, 0, String.valueOf(SessionClearFragment.this.M), String.valueOf(SessionClearFragment.this.R), "", "");
            } else {
                SessionClearFragment.this.E.setText(HardCodeUtil.qqStr(R.string.tbi));
                SessionClearFragment.this.J = 0;
                SessionClearFragment.this.D.x();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                ReportController.o(null, "dc00898", "", "", "0X800A0C7", "0X800A0C7", 0, 0, String.valueOf(SessionClearFragment.this.M), String.valueOf(SessionClearFragment.this.R), "", "");
                SessionClearFragment.this.P.Q1();
                SessionClearFragment.this.Sh();
                LastCleanMMKVHelper.f183341a.f(SessionClearFragment.this.S.getCurrentAccountUin());
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.weather.SessionClearFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class DialogInterfaceOnClickListenerC7214b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnClickListenerC7214b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
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

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SessionClearFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SessionClearFragment.this.Vh(DialogUtil.createCustomDialog(SessionClearFragment.this.L, 230, HardCodeUtil.qqStr(R.string.tbn), HardCodeUtil.qqStr(R.string.tbl), R.string.cancel, R.string.zne, new a(), new DialogInterfaceOnClickListenerC7214b()));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements QQProgressDialog.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SessionClearFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SessionClearFragment.this.L.onBackPressed();
            }
        }
    }

    public SessionClearFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.J = 0;
        this.M = 0;
        this.R = 0L;
    }

    private void Jh() {
        this.I = this.L.getIntent().getBooleanExtra(IQQComicPluginUtil.PPP_PRELOAD_DATA, false);
        this.S = QQStoryContext.g();
        ak akVar = (ak) com.tencent.mobileqq.mvvm.h.b(LifeCycleFragment.ph((QBaseActivity) this.L), ak.J).get(ak.class);
        this.P = akVar;
        akVar.getRepository().q(this.I);
        com.tencent.mobileqq.activity.weather.b bVar = new com.tencent.mobileqq.activity.weather.b(getContext(), this.S, this.C, this.P);
        this.D = bVar;
        this.C.setAdapter(bVar);
        this.D.w(this.C.getHeaderView());
        this.P.R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Kh((Boolean) obj);
            }
        });
        this.P.W1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Lh((Boolean) obj);
            }
        });
        this.P.S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Mh((Pair) obj);
            }
        });
        this.P.b2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Nh((Boolean) obj);
            }
        });
        this.P.X1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Oh((Boolean) obj);
            }
        });
        this.P.T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Ph((ak.e) obj);
            }
        });
        this.P.a2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Qh((Boolean) obj);
            }
        });
        this.P.Z1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.activity.weather.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SessionClearFragment.this.Rh((Boolean) obj);
            }
        });
        this.P.d2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(Boolean bool) {
        QLog.d("SessionClearFragment", 4, "getChosenChange observe notifyDataSetChanged isChange: " + bool);
        this.D.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(Boolean bool) {
        QLog.d("SessionClearFragment", 4, "getIsAllSelect observe change isSelectAll: " + bool);
        Wh(bool.booleanValue() ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void Mh(Pair pair) {
        this.R = ((Long) pair.first).longValue();
        this.M = ((Integer) pair.second).intValue();
        QLog.d("SessionClearFragment", 4, "getChosenChatSize observe change selectSize: " + this.R + " selectNumber: " + this.M);
        if (this.R == 0) {
            this.F.setVisibility(8);
            return;
        }
        this.F.setVisibility(0);
        this.F.setText(HardCodeUtil.qqStr(R.string.tbr) + q.f(this.R));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh(Boolean bool) {
        QLog.d("SessionClearFragment", 4, "getIsShowDialog observe isShow: " + bool);
        if (bool.booleanValue()) {
            showProgressDialog();
        } else {
            dismissProgressDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(Boolean bool) {
        QLog.d("SessionClearFragment", 4, "getIsDeleteEnable observe change : " + bool);
        this.G.setEnabled(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ph(ak.e eVar) {
        QLog.d("SessionClearFragment", 4, "getIsDeleteSuccess observe change :" + eVar.toString());
        this.T = eVar;
        dismissProgressDialog();
        this.F.setVisibility(8);
        Wh(0);
        Context context = getContext();
        if (context == null) {
            return;
        }
        QQToast.makeText(context, 2, R.string.ak7, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        Activity activity = this.L;
        if (activity == null) {
            QLog.d("SessionClearFragment", 1, "deleteSuccessful activity null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_delete_total_file_size", this.P.U1());
        activity.setResult(-1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(Boolean bool) {
        QLog.d("SessionClearFragment", 4, "getIsLoadAllMsgStart observe change: " + bool);
        if (bool.booleanValue()) {
            this.Q = System.currentTimeMillis();
            showProgressDialog();
            return;
        }
        dismissProgressDialog();
        if (this.Q != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.Q;
            w.a("storageMessageRecord", currentTimeMillis - j3, j3, currentTimeMillis, this.S.getCurrentAccountUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rh(Boolean bool) {
        QLog.d("SessionClearFragment", 4, "getIsEmpty observe change : " + bool);
        this.H.setVisibility(0);
        if (bool.booleanValue()) {
            this.N.setVisibility(0);
        } else {
            QLog.d("SessionClearFragment", 4, "getIsEmpty observe notifyDataSetChanged");
            this.D.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        HashMap hashMap = new HashMap();
        ak.e eVar = this.T;
        if (eVar != null) {
            hashMap.put("is_included_channels", Integer.valueOf(eVar.f196135a ? 1 : 0));
            hashMap.put("is_included_group", Integer.valueOf(this.T.f196137c ? 1 : 0));
            hashMap.put("is_included_person", Integer.valueOf(this.T.f196136b ? 1 : 0));
        }
        VideoReport.reportEvent("dt_clck", this.G, hashMap);
    }

    private void Th() {
        VideoReport.setElementId(this.E, "em_bas_select_all");
        VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_ALL);
        VideoReport.setElementId(this.G, "em_bas_delete");
    }

    private void Uh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getView(), "pg_bas_clear_chat_history");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(Dialog dialog) {
        Activity activity;
        if (dialog != null && (activity = this.L) != null && !activity.isFinishing()) {
            try {
                dialog.show();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("SessionClearFragment", 2, "showDialogSafe exception: " + th5.getMessage());
                }
            }
        }
    }

    private void Wh(int i3) {
        if (i3 == 1) {
            this.E.setText(HardCodeUtil.qqStr(R.string.tbt));
        } else {
            this.E.setText(HardCodeUtil.qqStr(R.string.tbh));
        }
        this.J = i3;
    }

    private void initUI(View view) {
        setTitle(getBaseActivity().getString(R.string.tbq));
        PinnedHeaderExpandableListView pinnedHeaderExpandableListView = (PinnedHeaderExpandableListView) view.findViewById(R.id.iov);
        this.C = pinnedHeaderExpandableListView;
        pinnedHeaderExpandableListView.setIsDrawIndicator(false);
        this.E = (Button) view.findViewById(R.id.ilv);
        this.J = 0;
        this.F = (TextView) view.findViewById(R.id.iz9);
        this.G = (Button) view.findViewById(R.id.bfl);
        this.H = (RelativeLayout) view.findViewById(R.id.f164635ad4);
        this.N = (LinearLayout) view.findViewById(R.id.f165084bw1);
        this.E.setOnClickListener(new a());
        this.G.setOnClickListener(new b());
    }

    protected void dismissProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.K;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.K.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SessionClearFragment", 2, "doOnCreateView");
        }
        initUI(((IphoneTitleBarFragment) this).mContentView);
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.byr;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.onAttach(activity);
        this.L = activity;
        if (QLog.isColorLevel()) {
            QLog.d("SessionClearFragment", 2, "onAttach");
        }
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SessionClearFragment", 2, "onBackPressed");
        }
        this.L.finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("SessionClearFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        if (this.I) {
            this.P.f2();
        } else {
            this.P.e2();
        }
        this.D.destroy();
        QQProgressDialog qQProgressDialog = this.K;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        this.L = null;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else if (QLog.isColorLevel()) {
            QLog.d("SessionClearFragment", 2, "onNewIntent");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        Uh();
        Th();
    }

    protected void showProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.K;
        if (qQProgressDialog == null) {
            this.K = new QQProgressDialog(this.L, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else if (qQProgressDialog.isShowing()) {
            return;
        }
        this.K.setCancelable(false);
        this.K.setCanceledOnTouchOutside(false);
        this.K.setMessage(HardCodeUtil.qqStr(R.string.tbo));
        this.K.show();
        this.K.O(new c());
    }
}
