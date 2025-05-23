package com.tencent.mobileqq.app.hiddenchat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi;
import com.tencent.qqnt.chats.biz.hiddenchat.d;
import com.tencent.qqnt.kernel.nativeinterface.RecentHiddenSesionInfo;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class HiddenChatSettingFragment extends QIphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    private FormSwitchItem D;
    private FormSwitchItem E;
    private d F;
    private CardObserver G;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends CardObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HiddenChatSettingFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onSetHiddenSession(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            super.onSetHiddenSession(z16, i3);
            if (QLog.isColorLevel()) {
                QLog.d("HiddenChatSetting", 2, "onSetHiddenSession " + z16 + " type=" + i3);
            }
            if (i3 == 42318) {
                if (!z16) {
                    ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).getShowUnReadNum(HiddenChatSettingFragment.this.F, 0, null);
                }
            } else if (i3 == 42319 && !z16) {
                HiddenChatSettingFragment hiddenChatSettingFragment = HiddenChatSettingFragment.this;
                hiddenChatSettingFragment.uh(hiddenChatSettingFragment.E, b.d(HiddenChatSettingFragment.this.C.getCurrentUin(), HiddenChatSettingFragment.this.getQBaseActivity()));
            }
        }
    }

    public HiddenChatSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.F = new d() { // from class: com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HiddenChatSettingFragment.this);
                    }
                }

                @Override // com.tencent.qqnt.chats.biz.hiddenchat.d
                public void a(boolean z16, int i3, TextView textView) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), textView);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable(z16) { // from class: com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f195703d;

                            {
                                this.f195703d = z16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z16));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    HiddenChatSettingFragment hiddenChatSettingFragment = HiddenChatSettingFragment.this;
                                    hiddenChatSettingFragment.uh(hiddenChatSettingFragment.D, this.f195703d);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.qqnt.chats.biz.hiddenchat.d
                public void b(ArrayList<RecentHiddenSesionInfo> arrayList) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) arrayList);
                    }
                }
            };
            this.G = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(FormSwitchItem formSwitchItem, boolean z16) {
        formSwitchItem.setOnCheckedChangeListener(null);
        formSwitchItem.setChecked(z16);
        formSwitchItem.setOnCheckedChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (getQBaseActivity().getAppRuntime() instanceof QQAppInterface) {
            this.C = (QQAppInterface) getQBaseActivity().getAppRuntime();
            this.D = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qq_setting_sync_msg_switch);
            this.E = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.m2i);
            this.C.addObserver(this.G);
            ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).getShowUnReadNum(this.F, 0, null);
            uh(this.E, b.d(this.C.getCurrentUin(), getQBaseActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.ce9;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        int i3;
        int i16;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton == this.D.getSwitch()) {
            ((CardHandler) this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).V4(z16, 42318);
            AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
            if (z16) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X800A34C", "0X800A34C", i16, 0, "0", "0", "", "");
        } else if (compoundButton == this.E.getSwitch()) {
            ((CardHandler) this.C.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).V4(z16, 42319);
            AppRuntime appRuntime2 = getQBaseActivity().getAppRuntime();
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(appRuntime2, "dc00898", "", "", "0X800A350", "0X800A350", i3, 0, "0", "0", "", "");
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        View onCreateCenterView = super.onCreateCenterView();
        setTitle(getQBaseActivity().getString(R.string.hhb));
        return onCreateCenterView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDestroy();
            this.C.removeObserver(this.G);
        }
    }
}
