package com.tencent.mobileqq.activity.history;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ChatHistoryC2CSettingFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    FormSimpleItem C;
    FormSimpleItem D;
    public int E;
    private String F;

    public ChatHistoryC2CSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void Ah(Context context, String str) {
        QLog.d("ChatHistoryC2CSettingFragmentC2CSettingFragment", 1, "startSettingActivity " + str);
        Intent intent = new Intent();
        intent.putExtra("key_peerId", str);
        PublicFragmentActivity.startForResult((Activity) context, intent, ChatHistoryC2CSettingFragment.class, 100);
    }

    private void Bh() {
        String string;
        int i3 = getBaseActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + getBaseActivity().app.getCurrentAccountUin(), 0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            string = null;
                        } else {
                            string = getResources().getString(R.string.g3r);
                        }
                    } else {
                        string = getResources().getString(R.string.g3p);
                    }
                } else {
                    string = getResources().getString(R.string.g3q);
                }
            } else {
                string = getResources().getString(R.string.g3s);
            }
        } else {
            string = getResources().getString(R.string.f172963g45);
        }
        if (!TextUtils.isEmpty(string)) {
            FormSimpleItem formSimpleItem = this.C;
            if (formSimpleItem != null) {
                formSimpleItem.setRightText(string);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryC2CSettingFragmentC2CSettingFragment", 2, "messge roam flag is error ,is : " + i3);
        }
    }

    private void uh(int i3) {
        Intent intent = new Intent();
        intent.putExtra("result_code", i3);
        getQBaseActivity().setResult(-1, intent);
        getQBaseActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean xh(NTFriendSettingHelper.a aVar) {
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(QQAppInterface qQAppInterface, DialogInterface dialogInterface, int i3) {
        boolean checkBoxState = ((QQCustomDialog) dialogInterface).getCheckBoxState();
        NTFriendSettingHelper.f352067a.v(new NTFriendSettingHelper.a(qQAppInterface, "", this.F, checkBoxState, 0), new Function1() { // from class: com.tencent.mobileqq.activity.history.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean xh5;
                xh5 = ChatHistoryC2CSettingFragment.xh((NTFriendSettingHelper.a) obj);
                return xh5;
            }
        });
        if (checkBoxState) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A17E", "0X800A17E", 2, 0, "", "", "", "");
        } else {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A180", "0X800A180", 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zh(QQAppInterface qQAppInterface, DialogInterface dialogInterface, int i3) {
        if (((QQCustomDialog) dialogInterface).getCheckBoxState()) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A17D", "0X800A17D", 2, 0, "", "", "", "");
        } else {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A17F", "0X800A17F", 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getString(R.string.a1c));
        this.C = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ajo);
        this.D = (FormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ago);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.f167766gj;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        try {
            vh(i3, i16, intent);
        } catch (Exception e16) {
            QLog.i("ChatHistoryC2CSettingFragmentC2CSettingFragment", 1, "onActivityResult", e16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ajo) {
                if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    QQAppInterface qQAppInterface = getBaseActivity().app;
                    this.E = qQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + qQAppInterface.getCurrentAccountUin(), -1);
                    ff.T(qQAppInterface, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 1, 0, "0", "0", "msgHistory");
                    Intent intent = new Intent(getBaseActivity(), (Class<?>) QQBrowserActivity.class);
                    String url = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_CHAT_ROAM_CELL);
                    if (!TextUtils.isEmpty(url)) {
                        if (url.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                            str = url + "&ADTAG=msgHistory";
                        } else {
                            str = url + "?ADTAG=msgHistory";
                        }
                        intent.putExtra("url", str);
                        startActivityForResult(intent, 2011);
                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A0AE", "0X800A0AE", 0, 0, "", "", "", "");
                    }
                } else {
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.h3f, 1).show();
                }
            } else if (id5 == R.id.ago) {
                ReportController.o(getBaseActivity().app, "dc00898", "", "", "0X800A17C", "0X800A17C", 2, 0, "", "", "", "");
                final QQAppInterface qQAppInterface2 = getBaseActivity().app;
                QQCustomDialog createDialogWithCheckBox = DialogUtil.createDialogWithCheckBox(getContext(), 230, null, HardCodeUtil.qqStr(R.string.lhw), HardCodeUtil.qqStr(R.string.lhy), false, HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.history.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ChatHistoryC2CSettingFragment.wh(dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.history.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ChatHistoryC2CSettingFragment.this.yh(qQAppInterface2, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.history.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ChatHistoryC2CSettingFragment.zh(QQAppInterface.this, dialogInterface, i3);
                    }
                });
                com.tencent.mobileqq.simpleui.c.j(createDialogWithCheckBox, 1000);
                createDialogWithCheckBox.show();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.F = getArguments().getString("key_peerId");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onResume();
            Bh();
        }
    }

    public void vh(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 2011) {
            if (i3 == 5011 && i16 == -1 && getBaseActivity() != null && !getBaseActivity().isFinishing() && intent != null) {
                int intExtra = intent.getIntExtra("result_code", 0);
                QLog.i("ChatHistoryC2CSettingFragmentC2CSettingFragment", 1, "doOnActivityResult tool code=" + intExtra);
                if (intExtra == 1) {
                    uh(1);
                    return;
                }
                return;
            }
            return;
        }
        int i17 = getBaseActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + getBaseActivity().app.getCurrentAccountUin(), -1);
        if (i17 == this.E) {
            return;
        }
        this.E = i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void wh(DialogInterface dialogInterface, int i3) {
    }
}
