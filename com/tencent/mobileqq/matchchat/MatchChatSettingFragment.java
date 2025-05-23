package com.tencent.mobileqq.matchchat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.manager.d;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.e;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import vg2.f;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MatchChatSettingFragment extends IphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    private FormSwitchItem D;
    private Button E;
    private ExpandObserver F;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends ExpandObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MatchChatSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void j(boolean z16, ArrayList<f> arrayList, boolean z17, int i3, ArrayList<String> arrayList2, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), arrayList, Boolean.valueOf(z17), Integer.valueOf(i3), arrayList2, Boolean.valueOf(z18));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + z16 + " chatSwitchOpen:" + z17);
            }
            if (z16) {
                MatchChatSettingFragment.this.uh(z17);
            }
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void u(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + z16);
            }
            if (!z16) {
                MatchChatSettingFragment.this.uh(!r4.D.isChecked());
            }
        }
    }

    public MatchChatSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.F = new a();
        }
    }

    private void initUI(View view) {
        if (view == null) {
            return;
        }
        this.D = (FormSwitchItem) view.findViewById(R.id.m2k);
        this.E = (Button) view.findViewById(R.id.m2j);
        this.D.setOnCheckedChangeListener(this);
        this.E.setOnClickListener(this);
    }

    private void th() {
        boolean d16 = ((d) this.C.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).d(this.C);
        uh(d16);
        if (QLog.isColorLevel()) {
            QLog.i("MatchChatSettingFragment", 2, "initDefaultValue chatSwitchOpen:" + d16);
        }
        ((e) this.C.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).k1(this.C.getCurrentUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(boolean z16) {
        this.D.setOnCheckedChangeListener(null);
        this.D.setChecked(z16);
        this.D.setOnCheckedChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) getBaseActivity().getAppRuntime();
            this.C = qQAppInterface;
            if (qQAppInterface != null) {
                qQAppInterface.addObserver(this.F);
                initUI(((IphoneTitleBarFragment) this).mContentView);
                th();
                return;
            }
            return;
        }
        QLog.w("MatchChatSettingFragment", 1, "error runtime?" + getQBaseActivity().getAppRuntime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.ceb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton == this.D.getSwitch()) {
            if (NetworkUtil.isNetSupport(getBaseActivity())) {
                ((e) this.C.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).k0(this.C.getCurrentUin(), z16);
                ReportController.o(this.C, "dc00898", "", "", "0X800A690", "0X800A690", !z16 ? 1 : 0, 0, "", "", "", "");
                HashMap hashMap = new HashMap();
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("ext_int1", str);
                ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_setting_page#dnd_mode", true, -1L, -1L, hashMap, true, true);
            } else {
                uh(!z16);
                QQToast.makeText(getBaseActivity(), R.string.f171140iv0, 0).show();
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (view.getId() == R.id.m2j) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MatchChatSettingFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (MatchChatSettingFragment.this.C == null) {
                        return;
                    }
                    ReportController.o(MatchChatSettingFragment.this.C, "dc00898", "", "", "0X800A699", "0X800A699", 0, 0, "", "", "", "");
                    ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#message_setting_page#delete_all_message", true, -1L, -1L, null, true, true);
                    MatchChatMsgUtil.a(MatchChatSettingFragment.this.C);
                    ((IExpandChatUtils) QRoute.api(IExpandChatUtils.class)).clearAllMatchChatLocalData(MatchChatSettingFragment.this.C);
                    ((com.tencent.mobileqq.qqexpand.manager.e) MatchChatSettingFragment.this.C.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).U();
                    ((d) MatchChatSettingFragment.this.C.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a();
                    ((IceBreakingMng) MatchChatSettingFragment.this.C.getManager(QQManagerFactory.ICE_BREAKING_MNG)).P();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchchat.MatchChatSettingFragment.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            BaseActivity baseActivity = MatchChatSettingFragment.this.getBaseActivity();
                            if (baseActivity != null) {
                                QQToast.makeText(baseActivity, R.string.iya, 0).show();
                            }
                        }
                    });
                }
            }, 16, null, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getBaseActivity().getString(R.string.iy9));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.F);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#message_setting_page#view", true, -1L, -1L, null, true, true);
        }
    }
}
