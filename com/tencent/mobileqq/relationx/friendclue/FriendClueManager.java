package com.tencent.mobileqq.relationx.friendclue;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FriendClueManager implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    private AllInOne C;
    private boolean D;
    ProfileCardObserver E;

    /* renamed from: d, reason: collision with root package name */
    private FriendClueCommonGroupHelper f280723d;

    /* renamed from: e, reason: collision with root package name */
    private BusinessCard f280724e;

    /* renamed from: f, reason: collision with root package name */
    private CardHandler f280725f;

    /* renamed from: h, reason: collision with root package name */
    private Context f280726h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f280727i;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f280728m;

    public FriendClueManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.D = false;
        this.E = new ProfileCardObserver() { // from class: com.tencent.mobileqq.relationx.friendclue.FriendClueManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendClueManager.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onGetProfileCard(boolean z16, Object obj) {
                Card card;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FriendClueManager", 2, String.format("the result of onCardDownload is:%b", Boolean.valueOf(z16)));
                }
                FriendClueManager.this.f280727i.removeMessages(1);
                FriendClueManager.this.f280728m.removeObserver(FriendClueManager.this.E);
                if (z16) {
                    if (obj instanceof Card) {
                        card = (Card) obj;
                    } else {
                        card = null;
                    }
                    if (card != null) {
                        Message message = new Message();
                        message.obj = card;
                        message.what = 2;
                        FriendClueManager.this.f280727i.sendMessage(message);
                        return;
                    }
                    return;
                }
                FriendClueManager.this.f280727i.post(new Runnable() { // from class: com.tencent.mobileqq.relationx.friendclue.FriendClueManager.2.1
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
                            QQToast.makeText(FriendClueManager.this.f280726h, 1, R.string.byt, 1).show();
                        }
                    }
                });
                QLog.e("FriendClueManager", 1, "get intimateInfo failed");
            }
        };
        this.f280728m = qQAppInterface;
        this.f280726h = BaseApplication.getContext();
        this.f280727i = new Handler(Looper.getMainLooper(), this);
    }

    private void d(String str) {
        if (NetworkUtil.isNetworkAvailable(this.f280726h)) {
            if (this.f280725f == null) {
                this.f280725f = (CardHandler) this.f280728m.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            }
            BusinessCardManager businessCardManager = (BusinessCardManager) this.f280728m.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
            if (businessCardManager != null) {
                this.D = businessCardManager.j(1);
            }
            AllInOne allInOne = new AllInOne(str, 1);
            this.C = allInOne;
            this.f280725f.m3(this.f280728m.getCurrentAccountUin(), str, 1, 0L, (byte) 1, 0L, 0L, null, "", ProfileUtils.getControl(allInOne, this.D), 10004, null, (byte) 0);
            Message obtainMessage = this.f280727i.obtainMessage();
            obtainMessage.what = 1;
            this.f280727i.sendMessageDelayed(obtainMessage, 10000L);
            return;
        }
        this.f280727i.post(new Runnable() { // from class: com.tencent.mobileqq.relationx.friendclue.FriendClueManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendClueManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(FriendClueManager.this.f280726h, 1, FriendClueManager.this.f280726h.getResources().getString(R.string.hpk), 1).show();
                }
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("FriendClueManager", 2, String.format("network is not available, uin: %s", str));
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (this.f280723d == null) {
            this.f280723d = new FriendClueCommonGroupHelper(this.f280728m, context);
        }
        this.f280723d.f(str);
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendClueManager", 2, String.format("jumpToRemarkEdit, uin: %s", str));
        }
        if (this.f280724e == null) {
            this.f280724e = new BusinessCard();
        }
        this.f280728m.addObserver(this.E);
        d(str);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                Object obj = message.obj;
                if (obj instanceof Card) {
                    card = (Card) obj;
                } else {
                    card = null;
                }
                if (card != null) {
                    BusinessCard b16 = BusinessCardUtils.b(card.bCardInfo);
                    this.f280724e = b16;
                    b16.bindUin = this.C.uin;
                    Intent intent = new Intent(this.f280726h, (Class<?>) BusinessCardEditActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("mode_type", 2);
                    intent.putExtra("source_activity", 1);
                    intent.putExtra("cur_card_body", this.f280724e);
                    intent.putExtra("is_edit_mode", true);
                    intent.putExtra("finish_immedia", true);
                    this.f280726h.startActivity(intent);
                } else {
                    QLog.e("FriendClueManager", 1, "card get failed ");
                }
            }
        } else {
            this.f280728m.removeObserver(this.E);
            QQToast.makeText(this.f280726h, 1, R.string.byt, 1).show();
        }
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f280728m.removeObserver(this.E);
        FriendClueCommonGroupHelper friendClueCommonGroupHelper = this.f280723d;
        if (friendClueCommonGroupHelper != null) {
            friendClueCommonGroupHelper.e();
        }
    }
}
