package com.tencent.mobileqq.activity.chathistory;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private String C;
    private String D;
    private ar E;

    /* renamed from: d, reason: collision with root package name */
    public QQProgressDialog f180652d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<QBaseActivity> f180653e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<QQAppInterface> f180654f;

    /* renamed from: h, reason: collision with root package name */
    public int f180655h;

    /* renamed from: i, reason: collision with root package name */
    private final WeakReferenceHandler f180656i;

    /* renamed from: m, reason: collision with root package name */
    private int f180657m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGetFriendNickBatch(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            b.this.f180656i.removeMessages(1);
            QQProgressDialog qQProgressDialog = b.this.f180652d;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                b.this.f180652d.dismiss();
                MultiMsgManager.w().L.clear();
                if (z16 && obj != null) {
                    MultiMsgManager.w().L.putAll((Map) obj);
                }
                if (MultiMsgManager.w().L.size() == 0) {
                    QBaseActivity qBaseActivity = b.this.f180653e.get();
                    QQAppInterface qQAppInterface = b.this.f180654f.get();
                    if (qBaseActivity != null && qQAppInterface != null) {
                        QQToast.makeText(qQAppInterface.getApp(), R.string.f6t, 0).show(qBaseActivity.getTitleBarHeight());
                    }
                } else {
                    b.this.i((Map) obj, MultiMsgManager.w().K);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + obj);
                    return;
                }
                return;
            }
            QLog.e("SeparateForward", 1, "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(z16));
        }
    }

    public b(QBaseActivity qBaseActivity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, i3);
            return;
        }
        this.f180656i = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.E = new a();
        this.f180653e = new WeakReference<>(qBaseActivity);
        this.f180655h = i3;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            this.f180654f = new WeakReference<>((QQAppInterface) runtime);
        }
        Intent intent = qBaseActivity.getIntent();
        this.f180657m = intent.getIntExtra("uintype", -1);
        this.C = intent.getStringExtra("uin");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit d(Boolean bool, Map map) {
        e(bool.booleanValue(), map);
        return null;
    }

    private void e(boolean z16, Map<String, String> map) {
        this.f180656i.removeMessages(1);
        QQProgressDialog qQProgressDialog = this.f180652d;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            QQProgressDialog qQProgressDialog2 = this.f180652d;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.dismiss();
            }
            MultiMsgManager.w().L.clear();
            if (z16 && map != null) {
                MultiMsgManager.w().L.putAll(map);
                if (QLog.isDevelopLevel()) {
                    QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + map);
                }
            } else if (QLog.isDevelopLevel()) {
                QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
            }
            if (MultiMsgManager.w().L.size() == 0) {
                QBaseActivity qBaseActivity = this.f180653e.get();
                if (qBaseActivity != null) {
                    QQToast.makeText(qBaseActivity, R.string.f6t, 0).show(qBaseActivity.getTitleBarHeight());
                    return;
                }
                return;
            }
            i(map, MultiMsgManager.w().K);
            return;
        }
        QLog.e("SeparateForward", 1, "onBatchTroopCardDefaultNick timeout, isSuccess:", Boolean.valueOf(z16));
    }

    public void c(List<ChatMessage> list) {
        QQProgressDialog qQProgressDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        QBaseActivity qBaseActivity = this.f180653e.get();
        QQAppInterface qQAppInterface = this.f180654f.get();
        if (qBaseActivity != null && qQAppInterface != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<ChatMessage> c16 = i.c(qQAppInterface, (ArrayList) list);
            MultiMsgManager.w().Y(c16);
            if (this.f180652d == null) {
                this.f180652d = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
            }
            this.f180652d.setMessage(R.string.f6s);
            this.f180652d.show();
            for (ChatMessage chatMessage : c16) {
                if (!arrayList.contains(chatMessage.senderuin)) {
                    arrayList.add(chatMessage.senderuin);
                }
            }
            MultiMsgManager.w().K.clear();
            MultiMsgManager.w().K.addAll(c16);
            int i3 = this.f180657m;
            if (i3 == 1) {
                ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopMemberNickName(this.C, arrayList, false, null, null, new Function2() { // from class: com.tencent.mobileqq.activity.chathistory.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit d16;
                        d16 = b.this.d((Boolean) obj, (Map) obj2);
                        return d16;
                    }
                });
            } else if (i3 != 0 && i3 != 3000) {
                if (i3 == 10014) {
                    i(new HashMap(), MultiMsgManager.w().K);
                    QQProgressDialog qQProgressDialog2 = this.f180652d;
                    if (qQProgressDialog2 != null && qQProgressDialog2.isShowing() && (qQProgressDialog = this.f180652d) != null) {
                        qQProgressDialog.dismiss();
                        return;
                    }
                    return;
                }
            } else {
                ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(arrayList);
            }
            Message obtainMessage = this.f180656i.obtainMessage(1);
            obtainMessage.arg1 = arrayList.size();
            this.f180656i.sendMessageDelayed(obtainMessage, 30000L);
            return;
        }
        QLog.e("SeparateForward", 1, "sendMultiMsg, activity or app recyled");
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f180654f.get();
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.E);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f180654f.get();
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.E);
        }
    }

    public void h(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        QQAppInterface qQAppInterface = this.f180654f.get();
        if (com.tencent.mobileqq.structmsg.i.d(intent.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES)) != null && qQAppInterface != null) {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = intent.getIntExtra("uintype", 0);
            sessionInfo.f179557e = intent.getStringExtra("uin");
            sessionInfo.f179559f = intent.getStringExtra("troop_uin");
            MultiMsgManager w3 = MultiMsgManager.w();
            w3.W(qQAppInterface, sessionInfo, w3.K);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            QBaseActivity qBaseActivity = this.f180653e.get();
            QQProgressDialog qQProgressDialog = this.f180652d;
            if (qQProgressDialog != null && qBaseActivity != null) {
                qQProgressDialog.dismiss();
                QQToast.makeText(qBaseActivity, R.string.f6u, 0).show(qBaseActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
        return false;
    }

    public void i(Map<String, String> map, ArrayList<ChatMessage> arrayList) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) map, (Object) arrayList);
            return;
        }
        QBaseActivity qBaseActivity = this.f180653e.get();
        QQAppInterface qQAppInterface = this.f180654f.get();
        if (qBaseActivity != null && qQAppInterface != null) {
            int i3 = this.f180657m;
            if (i3 == 0) {
                str = ac.B(qQAppInterface, this.C);
            } else if (i3 != 1 && i3 != 3000) {
                str = " ";
            } else {
                str = this.D;
            }
            AbsShareMsg Z = ChatActivityFacade.Z(qBaseActivity, str, arrayList, map, true);
            if (Z == null) {
                return;
            }
            Z.mMsg_A_ActionData = null;
            Intent intent = new Intent();
            intent.putExtra("forward_type", -3);
            intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, Z.getBytes());
            intent.putExtra("is_need_show_sources", false);
            intent.putExtra("forward_msg_from_together", 1);
            intent.putExtra("forwardDirect", true);
            ForwardBaseOption.startForwardActivityForResult(qBaseActivity, intent, this.f180655h);
            return;
        }
        QLog.e("SeparateForward", 1, "sendMultiMsg, activity or app recyled");
    }
}
