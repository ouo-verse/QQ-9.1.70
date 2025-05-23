package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.runnable.RelationRunnable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendBindContactGuideBuilderV3 extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public com.tencent.mobileqq.newfriend.msg.f C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements com.tencent.relation.common.runnable.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendBindContactGuideBuilderV3.this);
            }
        }

        @Override // com.tencent.relation.common.runnable.a
        public void callback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NewFriendBindContactGuideBuilderV3.this.p();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class b extends d.b {
        static IPatchRedirector $redirector_;
        public ImageButton I;
        public Button J;
        public TextView K;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) anonymousClass1);
        }
    }

    public NewFriendBindContactGuideBuilderV3(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        } else {
            this.C = (com.tencent.mobileqq.newfriend.msg.f) iVar;
        }
    }

    private void n() {
        Runnable runnable;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102153", false);
        if (QLog.isColorLevel()) {
            QLog.i("NewFriendBindContactGuideBuilderV3", 2, "leakOptSwitch\uff1a" + isSwitchOn);
        }
        if (isSwitchOn) {
            runnable = new RelationRunnable(new a());
        } else {
            runnable = new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV3.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendBindContactGuideBuilderV3.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        NewFriendBindContactGuideBuilderV3.this.p();
                    }
                }
            };
        }
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).checkReadContactPermission(runnable, this.f254108e);
    }

    private void o() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f254109f.i(this);
            this.f254109f.notifyDataSetChanged();
        } else {
            this.f254108e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV3.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendBindContactGuideBuilderV3.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    NewFriendBindContactGuideBuilderV3 newFriendBindContactGuideBuilderV3 = NewFriendBindContactGuideBuilderV3.this;
                    newFriendBindContactGuideBuilderV3.f254109f.i(newFriendBindContactGuideBuilderV3);
                    NewFriendBindContactGuideBuilderV3.this.f254109f.notifyDataSetChanged();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        b bVar;
        String string;
        View view2 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view2);
        }
        if (view2 != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            view2 = LayoutInflater.from(this.f254107d).inflate(R.layout.h5h, (ViewGroup) null);
            bVar = new b(null);
            bVar.J = (Button) view2.findViewById(R.id.f163917c5);
            bVar.K = (TextView) view2.findViewById(R.id.title);
            bVar.I = (ImageButton) view2.findViewById(R.id.close);
            view2.setTag(bVar);
        }
        if (!this.C.f254033e) {
            string = this.f254107d.getString(R.string.f237147g_);
        } else {
            string = this.f254107d.getString(R.string.f237157ga);
        }
        bVar.K.setText(string);
        view2.setOnClickListener(this);
        bVar.I.setOnClickListener(this);
        bVar.J.setOnClickListener(this);
        com.tencent.mobileqq.newfriend.utils.a.h(view2, false);
        NewFriendServiceImpl newFriendServiceImpl = (NewFriendServiceImpl) this.f254108e.getRuntimeService(INewFriendService.class, "");
        if (!this.C.f254033e) {
            if (!newFriendServiceImpl.isGuidePermissionReported()) {
                newFriendServiceImpl.setIsGuidePermissionReported(true);
                ReportController.o(this.f254108e, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
            }
        } else if (!newFriendServiceImpl.isGuideBindReported()) {
            newFriendServiceImpl.setIsGuideBindReported(true);
            ReportController.o(this.f254108e, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.close) {
                ((NewFriendServiceImpl) this.f254108e.getRuntimeService(INewFriendService.class, "")).setContactGuideCancelByUser();
                o();
            } else if (id5 == R.id.f163917c5 || id5 == R.id.a_9) {
                if (!NetworkUtil.isNetSupport(this.f254107d)) {
                    BaseApplication context = BaseApplication.getContext();
                    QQToast.makeText(context, 1, R.string.cjm, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                } else if (this.C.f254033e) {
                    ReportController.o(this.f254108e, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
                    p();
                } else {
                    ReportController.o(this.f254108e, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
                    n();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NewFriendBindContactGuideBuilderV3", 2, "uploadContact");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV3.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewFriendBindContactGuideBuilderV3.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IPhoneContactService iPhoneContactService = (IPhoneContactService) NewFriendBindContactGuideBuilderV3.this.f254108e.getRuntimeService(IPhoneContactService.class, "");
                iPhoneContactService.uploadOrUpdateContact();
                iPhoneContactService.setNeedUploadResultTip(true);
            }
        }, 16, null, false);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.f254108e, 15, 2, null);
        o();
    }
}
