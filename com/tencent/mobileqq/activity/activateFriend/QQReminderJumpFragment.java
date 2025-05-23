package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQReminderJumpFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    private ab C;

    public QQReminderJumpFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void ph(Context context, String str) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("msgid", str);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, QQReminderJumpFragment.class);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onActivityCreated(bundle);
        ab abVar = new ab(getQBaseActivity());
        this.C = abVar;
        abVar.show();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroyView();
        ab abVar = this.C;
        if (abVar != null && abVar.isShowing()) {
            this.C.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        String string = getArguments().getString("msgid");
        if (!StringUtil.isEmpty(string)) {
            ThreadManagerV2.excute(new Runnable(string) { // from class: com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f177882d;

                {
                    this.f177882d = string;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderJumpFragment.this, (Object) string);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                        qQAppInterface.runOnUiThread(new Runnable(((IQQReminderCalendarService) qQAppInterface.getRuntimeService(IQQReminderCalendarService.class, "")).queryCalendarEntity(this.f177882d)) { // from class: com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ List f177883d;

                            {
                                this.f177883d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                List list = this.f177883d;
                                if (list != null && list.size() != 0) {
                                    QBaseActivity qBaseActivity = QQReminderJumpFragment.this.getQBaseActivity();
                                    List list2 = this.f177883d;
                                    ae.m(qBaseActivity, (CalendarEntity) list2.get(list2.size() - 1));
                                } else {
                                    QQToast.makeText(QQReminderJumpFragment.this.getQBaseActivity(), 1, HardCodeUtil.qqStr(R.string.f211525l2), 0).show();
                                    QLog.e("QQReminderJumpFragment", 1, "get msgid: ", AnonymousClass1.this.f177882d, " res is null");
                                }
                                QQReminderJumpFragment.this.getQBaseActivity().finish();
                            }
                        });
                    }
                }
            }, 32, null, true);
        }
    }
}
