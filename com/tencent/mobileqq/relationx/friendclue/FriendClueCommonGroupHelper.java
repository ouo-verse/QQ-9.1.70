package com.tencent.mobileqq.relationx.friendclue;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FriendClueCommonGroupHelper implements Handler.Callback {
    static IPatchRedirector $redirector_;
    com.tencent.mobileqq.friends.intimate.d C;

    /* renamed from: d, reason: collision with root package name */
    private IntimateInfoHandler f280715d;

    /* renamed from: e, reason: collision with root package name */
    private Context f280716e;

    /* renamed from: f, reason: collision with root package name */
    private String f280717f;

    /* renamed from: h, reason: collision with root package name */
    private IntimateInfo f280718h;

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f280719i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f280720m;

    public FriendClueCommonGroupHelper(QQAppInterface qQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
            return;
        }
        this.C = new com.tencent.mobileqq.friends.intimate.d() { // from class: com.tencent.mobileqq.relationx.friendclue.FriendClueCommonGroupHelper.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendClueCommonGroupHelper.this);
                }
            }

            @Override // com.tencent.mobileqq.friends.intimate.d
            protected void onGetIntimateInfo(boolean z16, String str, IntimateInfo intimateInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, intimateInfo);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
                }
                FriendClueCommonGroupHelper.this.f280719i.removeObserver(FriendClueCommonGroupHelper.this.C);
                FriendClueCommonGroupHelper.this.f280720m.removeMessages(1);
                if (z16) {
                    FriendClueCommonGroupHelper.this.f280718h = intimateInfo;
                    FriendClueCommonGroupHelper.this.g();
                } else {
                    FriendClueCommonGroupHelper.this.f280720m.post(new Runnable() { // from class: com.tencent.mobileqq.relationx.friendclue.FriendClueCommonGroupHelper.2.1
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
                            } else {
                                QQToast.makeText(FriendClueCommonGroupHelper.this.f280716e, 1, FriendClueCommonGroupHelper.this.f280716e.getResources().getString(R.string.byt), 1).show();
                            }
                        }
                    });
                    QLog.e("FriendClueCommonGroupHelper", 1, "get intimateInfo failed");
                }
            }
        };
        this.f280716e = context;
        this.f280719i = qQAppInterface;
        this.f280720m = new Handler(Looper.getMainLooper(), this);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f280719i.removeObserver(this.C);
        }
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f280717f = str;
        if (!TextUtils.isEmpty(str)) {
            if (NetworkUtil.isNetworkAvailable(this.f280716e)) {
                if (this.f280715d == null) {
                    this.f280715d = (IntimateInfoHandler) this.f280719i.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
                }
                this.f280719i.addObserver(this.C);
                this.f280715d.G2(str, false);
                Message obtainMessage = this.f280720m.obtainMessage();
                obtainMessage.what = 1;
                this.f280720m.sendMessageDelayed(obtainMessage, 10000L);
                return;
            }
            this.f280720m.post(new Runnable() { // from class: com.tencent.mobileqq.relationx.friendclue.FriendClueCommonGroupHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendClueCommonGroupHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(FriendClueCommonGroupHelper.this.f280716e, 1, FriendClueCommonGroupHelper.this.f280716e.getResources().getString(R.string.hpk), 1).show();
                    }
                }
            });
            if (QLog.isColorLevel()) {
                QLog.d("FriendClueCommonGroupHelper", 1, String.format("requestIntimateInfo network is not available, uin: %s", str));
            }
        }
    }

    void g() {
        if (this.f280718h.commonTroopInfoList != null) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendClueCommonGroupHelper", 2, "get intimateInfo finished");
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putParcelableArrayListExtra("common_troop_list", (ArrayList) this.f280718h.commonTroopInfoList);
            intent.putExtra("report_friend_type", 1);
            PublicFragmentActivity.start(this.f280716e, intent, CommonTroopListActivity.class);
            return;
        }
        String str = this.f280717f;
        if (str != null) {
            TroopWithCommonFriendsFragment.Ih(str);
            TroopWithCommonFriendsFragment.zh(this.f280716e, 2);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            this.f280719i.removeObserver(this.C);
            QQToast.makeText(this.f280716e, 1, this.f280716e.getResources().getString(R.string.byt), 1).show();
        }
        return true;
    }
}
