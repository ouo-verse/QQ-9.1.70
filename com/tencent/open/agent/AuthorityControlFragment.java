package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.notify.CommonAuthorityEvent;
import com.tencent.open.manager.OpenAgentHandler;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AuthorityControlFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    private ListView C;
    private fp3.c D;
    private Context E;
    private View F;
    private QQAppInterface G;
    private SmartRefreshLayout H;
    private com.tencent.open.manager.a I;
    private OpenAgentHandler J;
    private TextView K;
    private ColorStateList L;
    View.OnTouchListener M;

    @NonNull
    private ArrayList<AppInfo> N = new ArrayList<>();
    private QQProgressDialog P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends MqqHandler {
        b() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            List list;
            if (message.what == 1 && (list = (List) message.obj) != null && list.size() > 0) {
                AuthorityControlFragment.this.Lh(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BaseActivity baseActivity = AuthorityControlFragment.this.getBaseActivity();
            if (baseActivity != null) {
                baseActivity.doOnBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d extends com.tencent.open.manager.a {
        d() {
        }

        @Override // com.tencent.open.manager.a
        protected void b(boolean z16, List<AppInfo> list) {
            String str;
            if (QLog.isColorLevel()) {
                QLog.i("AuthorityControlActivity", 2, "onDelApp: invoked.  isSuccess: " + z16 + " infos: " + list);
            }
            if (list != null) {
                SimpleEventBus.getInstance().dispatchEvent(new CommonAuthorityEvent(list));
            }
            if (z16 && list != null && list.size() > 0) {
                AuthorityControlFragment.this.Lh(list);
                QQToast.makeText(AuthorityControlFragment.this.E, 2, String.format(HardCodeUtil.qqStr(R.string.jsr), Integer.valueOf(list.size())), 0).show();
            } else {
                QQToast.makeText(AuthorityControlFragment.this.E, 1, HardCodeUtil.qqStr(R.string.jsv), 0).show();
            }
            QQAppInterface qQAppInterface = AuthorityControlFragment.this.G;
            if (z16) {
                str = "0";
            } else {
                str = "1";
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009E1D", "0X8009E1D", 0, 0, str, "", "", "");
        }

        @Override // com.tencent.open.manager.a
        protected void c(boolean z16, List<AppInfo> list, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("AuthorityControlActivity", 2, "onGetAuthorizeAppList: invoked.  isSuccess: " + z16 + " infos: " + list);
            }
            if (!z16) {
                AuthorityControlFragment.this.Nh();
            } else {
                if (list == null) {
                    list = new ArrayList<>();
                }
                AuthorityControlFragment.this.D.k(list);
                AuthorityControlFragment.this.N = new ArrayList(list);
                if (AuthorityControlFragment.this.D.getCount() == 0) {
                    AuthorityControlFragment.this.Nh();
                } else {
                    AuthorityControlFragment.this.K.setVisibility(0);
                    AuthorityControlFragment authorityControlFragment = AuthorityControlFragment.this;
                    authorityControlFragment.setRightButton(R.string.f170505t2, authorityControlFragment);
                }
                AuthorityControlFragment.this.D.notifyDataSetChanged();
            }
            if (AuthorityControlFragment.this.P.isShowing() && !AuthorityControlFragment.this.isRemoving()) {
                try {
                    AuthorityControlFragment.this.P.dismiss();
                } catch (Throwable unused) {
                }
            }
            AuthorityControlFragment.this.Kh(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AuthorityControlFragment.this.H.setEnableRefresh(true);
            AuthorityControlFragment.this.D.m();
            AuthorityControlFragment authorityControlFragment = AuthorityControlFragment.this;
            authorityControlFragment.setTextWithTalk(authorityControlFragment.rightViewText, R.string.f170505t2);
            AuthorityControlFragment authorityControlFragment2 = AuthorityControlFragment.this;
            authorityControlFragment2.rightViewText.setTextColor(authorityControlFragment2.L);
            AuthorityControlFragment.this.rightViewText.setEnabled(true);
            AuthorityControlFragment.this.setLeftButton("", (View.OnClickListener) null);
            AuthorityControlFragment.this.leftView.setVisibility(0);
            AuthorityControlFragment.this.K.setText(R.string.f170513t8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Eh() {
        this.G.setHandler(AuthorityControlFragment.class, new b());
    }

    private void Fh() {
        this.I = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(IRefreshLayout iRefreshLayout) {
        OpenAgentHandler openAgentHandler = (OpenAgentHandler) this.G.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER);
        this.J = openAgentHandler;
        openAgentHandler.E2();
        this.D.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(List list, ActionSheet actionSheet, View view, int i3) {
        if (i3 == 0) {
            this.J.D2(list, null);
            actionSheet.dismiss();
        }
    }

    public static void Ih(Activity activity) {
        PublicFragmentActivity.start(activity, AuthorityControlFragment.class);
    }

    private void Jh() {
        this.G = getBaseActivity().app;
        this.E = getBaseActivity();
        initViews();
        Fh();
        Eh();
        if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication)) {
            QQToast.makeText(this.E, R.string.b3j, 0).show();
            Nh();
            return;
        }
        OpenAgentHandler openAgentHandler = (OpenAgentHandler) this.G.getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER);
        this.J = openAgentHandler;
        openAgentHandler.E2();
        try {
            this.P.show();
        } catch (Throwable unused) {
        }
        this.L = this.rightViewText.getTextColors();
        this.M = new a();
        ReportController.o(this.G, "dc00898", "", "", "0X8009DC3", "0X8009DC3", 0, 0, "", "", "", "");
        com.tencent.open.agent.util.g.R(this.G, "0X800B92E", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(boolean z16) {
        this.H.finishRefresh(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(List<AppInfo> list) {
        fp3.c cVar = this.D;
        if (cVar == null) {
            return;
        }
        cVar.j(list);
        this.D.g();
        if (this.D.getCount() == 0) {
            Nh();
        }
    }

    private void Mh() {
        String qqStr;
        final List<AppInfo> d16 = this.D.d();
        if (d16.size() == 0) {
            com.tencent.open.agent.util.g.R(this.G, "0X800B933", null);
            return;
        }
        if (d16.size() == 1) {
            qqStr = this.E.getResources().getString(R.string.f173060h10, d16.get(0).e());
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.jsp);
        }
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.E, null);
        actionSheet.setRoundCornerTop(true);
        actionSheet.setMainTitle(qqStr);
        actionSheet.addButton(R.string.j2t, 3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.open.agent.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                AuthorityControlFragment.this.Hh(d16, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        try {
            actionSheet.show();
        } catch (Throwable unused) {
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        for (AppInfo appInfo : this.D.d()) {
            sb5.append(String.valueOf(appInfo.c()));
            sb5.append(" ");
            sb6.append(appInfo.e());
            sb6.append(" ");
        }
        ReportController.o(this.G, "dc00898", "", "", "0X8009DC6", "0X8009DC6", 0, 0, "", "", sb5.toString(), "");
        com.tencent.open.agent.util.g.R(this.G, "0X800B933", new String[]{"", "", sb6.toString(), ""});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        this.H.setVisibility(8);
        this.K.setVisibility(8);
        this.F.setVisibility(0);
        this.rightViewText.setVisibility(8);
        setLeftButton("", (View.OnClickListener) null);
        this.mLeftBackIcon.setVisibility(0);
    }

    private void Oh() {
        this.D.l();
        this.H.setEnableRefresh(false);
        setTextWithTalk(this.rightViewText, R.string.f170512t3);
        this.rightViewText.setTextColor(getResources().getColorStateList(R.color.f156783bk));
        this.rightViewText.setOnTouchListener(this.M);
        this.rightViewText.setEnabled(false);
        setLeftButton(R.string.cancel, new e());
        ViewGroup.LayoutParams layoutParams = this.leftViewNotBack.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(18, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            this.leftViewNotBack.setLayoutParams(layoutParams2);
        }
        this.leftView.setVisibility(8);
        this.K.setText(R.string.f173061h11);
        Kh(true);
        com.tencent.open.agent.util.g.R(this.G, "0X800B932", null);
    }

    private void initViews() {
        setTitle(getString(R.string.f170503t0));
        this.D = new fp3.c(this, this.G);
        this.C = (ListView) findViewById(R.id.f166070ec2);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.f86434rn);
        this.H = smartRefreshLayout;
        smartRefreshLayout.setEnableOverScrollDrag(true);
        this.H.setEnableRefresh(true);
        this.H.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.open.agent.c
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                AuthorityControlFragment.this.Gh(iRefreshLayout);
            }
        });
        View inflate = LayoutInflater.from(this.E).inflate(R.layout.f167667ds, (ViewGroup) this.C, false);
        this.C.addHeaderView(inflate);
        this.F = findViewById(R.id.bw5);
        this.K = (TextView) inflate.findViewById(R.id.a1f);
        this.C.setAdapter((ListAdapter) this.D);
        Context context = this.E;
        QQProgressDialog qQProgressDialog = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        this.P = qQProgressDialog;
        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.f171618jt0));
        this.P.setBackAndSearchFilter(false);
        this.P.setOnCancelListener(new c());
    }

    protected final <T extends View> T findViewById(int i3) {
        return (T) ((IphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167542a8;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 996 && i16 == -1) {
            Lh(new ArrayList<AppInfo>((AppInfo) intent.getParcelableExtra("KEY_DELETED_INFO")) { // from class: com.tencent.open.agent.AuthorityControlFragment.6
                final /* synthetic */ AppInfo val$deleted;

                {
                    this.val$deleted = r2;
                    add(r2);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.rightViewText.getId() == view.getId()) {
            if (this.D.e()) {
                Mh();
            } else {
                Oh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.G.removeHandler(AuthorityControlFragment.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ArrayList<AppInfo> arrayList = this.N;
        if (arrayList != null && this.D != null && arrayList.size() == this.D.getCount()) {
            ReportController.o(this.G, "dc00898", "", "", "0X8009DC7", "0X8009DC7", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.G.addObserver(this.I);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.G.removeObserver(this.I);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Jh();
    }
}
