package p91;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;
import o91.b;
import o91.c;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<AppRuntime> f425799d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<Long, Bundle> f425800e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f425801f = null;

    /* renamed from: h, reason: collision with root package name */
    private Handler f425802h = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f425803i = false;

    /* renamed from: m, reason: collision with root package name */
    private long f425804m = 120000;
    private final Object C = new Object();
    private c D = new C10991a();

    /* compiled from: P */
    /* renamed from: p91.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C10991a implements c {
        C10991a() {
        }

        @Override // o91.c
        public void a(boolean z16, JSONObject jSONObject, Object obj) {
            String str;
            AppRuntime appRuntime = (AppRuntime) a.this.f425799d.get();
            if (appRuntime != null && obj != null && (obj instanceof Bundle)) {
                Bundle bundle = (Bundle) obj;
                long j3 = bundle.getLong("key_process_message_uniseq");
                String string = bundle.getString("key_process_message_friend_uin");
                int i3 = bundle.getInt("key_process_message_uin_type");
                synchronized (a.this.C) {
                    if (((Bundle) a.this.f425800e.get(Long.valueOf(j3))) != null) {
                        a.this.f425800e.remove(Long.valueOf(j3));
                        a.this.f425802h.removeMessages(1, bundle);
                        if (!(appRuntime instanceof QQAppInterface)) {
                            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.sArkMsgPrepCallback.failed should in main process, uniseq=", Long.valueOf(j3));
                            return;
                        }
                        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                        MessageRecord w06 = qQAppInterface.getMessageFacade().w0(string, i3, j3);
                        if (!(w06 instanceof MessageForArkApp)) {
                            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.sArkMsgPrepCallback find ArkMsg failed!");
                            return;
                        }
                        MessageForArkApp messageForArkApp = (MessageForArkApp) w06;
                        if (QLog.isColorLevel()) {
                            QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.sArkMsgPrepCallback  uniseq=", Long.valueOf(j3), ", processState=", Integer.valueOf(messageForArkApp.getProcessState()), ", success=", Boolean.valueOf(z16), String.format(" ,msg=%h", messageForArkApp), ", this=", messageForArkApp.getBaseInfoString(), ", msgJson=", jSONObject);
                        }
                        if (messageForArkApp.ark_app_message != null) {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("appid", messageForArkApp.ark_app_message.appName);
                            if (z16) {
                                str = "1";
                            } else {
                                str = "2";
                            }
                            hashMap.put("result", str);
                            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShareCallback", true, 0L, 0L, hashMap, null);
                        }
                        if (z16) {
                            messageForArkApp.updateArkAppMetaData(jSONObject);
                            messageForArkApp.updateProcessStateAndExtraFlag(1002);
                            messageForArkApp.saveMsgData(qQAppInterface);
                            messageForArkApp.saveMsgExtStrAndFlag(qQAppInterface);
                            qQAppInterface.getMessageFacade().D0(messageForArkApp, null);
                            return;
                        }
                        messageForArkApp.updateProcessStateAndExtraFlag(1003);
                        messageForArkApp.saveMsgData(qQAppInterface);
                        messageForArkApp.saveMsgExtStrAndFlag(qQAppInterface);
                        qQAppInterface.getMsgCache().G1(messageForArkApp.frienduin, messageForArkApp.istroop, messageForArkApp.uniseq);
                        a.this.h(qQAppInterface, messageForArkApp);
                        return;
                    }
                    QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.sArkMsgPrepCallback.failed for msg callback timeout uniseq=", Long.valueOf(j3));
                    return;
                }
            }
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.sArkMsgPrepCallback invalid param app=", appRuntime, ",userData=", obj);
        }
    }

    public a(AppRuntime appRuntime) {
        this.f425799d = new WeakReference<>(appRuntime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(QQAppInterface qQAppInterface, MessageForArkApp messageForArkApp) {
        if (qQAppInterface != null && messageForArkApp != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.notifyUpdateMsgUI uniseq=", Long.valueOf(messageForArkApp.uniseq), ", frienduin=", messageForArkApp.frienduin);
            }
            int processState = messageForArkApp.getProcessState();
            if (processState == 1001) {
                qQAppInterface.getMsgHandler().notifyUI(6003, true, new String[]{messageForArkApp.frienduin, String.valueOf(messageForArkApp.uniseq)});
                return;
            }
            if (processState == 1003) {
                Object[] objArr = new Object[8];
                objArr[0] = messageForArkApp.frienduin;
                objArr[1] = Integer.valueOf(messageForArkApp.istroop);
                objArr[2] = 0;
                objArr[3] = null;
                objArr[4] = Long.valueOf(g());
                objArr[5] = Long.valueOf(messageForArkApp.uniseq);
                qQAppInterface.getMsgHandler().notifyBusiness(3001, false, objArr);
            }
        }
    }

    public boolean f(QQAppInterface qQAppInterface, String str, SessionInfo sessionInfo, MessageForArkApp messageForArkApp) {
        String str2;
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && sessionInfo != null && messageForArkApp != null) {
            b a16 = ((IArkAsyncShareMsgService) qQAppInterface.getRuntimeService(IArkAsyncShareMsgService.class, "")).getMessagePreprocessorMgr().a(str);
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.shareData curType=", Integer.valueOf(sessionInfo.f179555d), ", curFriendUin= ", sessionInfo.f179557e, ", troopUin=", sessionInfo.f179559f, ", istroop=", Integer.valueOf(messageForArkApp.istroop), ", \n --shareMessage=", messageForArkApp.ark_app_message.toShareMsgJSONObject());
            }
            if (a16 != null) {
                boolean a17 = a16.a(messageForArkApp.ark_app_message.toShareMsgJSONObject());
                if (QLog.isColorLevel()) {
                    QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.sendArkMessage needProcess=", Boolean.valueOf(a17));
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("appid", str);
                if (a17) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                hashMap.put("isProcess", str2);
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShare", true, 0L, 0L, hashMap, null);
                if (a17) {
                    messageForArkApp.updateProcessStateAndExtraFlag(1001);
                    qQAppInterface.getMessageFacade().m(messageForArkApp);
                    a16.b(messageForArkApp.ark_app_message.toShareMsgJSONObject(), this.D, i(messageForArkApp));
                    return true;
                }
            }
            return false;
        }
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.checkToAsyncShareArkMsg invalid");
        return false;
    }

    public long g() {
        QLog.d("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.get timeout=", Long.valueOf(this.f425804m));
        return this.f425804m;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        QQAppInterface qQAppInterface;
        if (message.what == 1) {
            AppRuntime appRuntime = this.f425799d.get();
            Object obj = message.obj;
            if (appRuntime != null && obj != null && (obj instanceof Bundle)) {
                Bundle bundle = (Bundle) obj;
                long j3 = bundle.getLong("key_process_message_uniseq");
                String string = bundle.getString("key_process_message_friend_uin");
                int i3 = bundle.getInt("key_process_message_uin_type");
                synchronized (this.C) {
                    if (this.f425800e.get(Long.valueOf(j3)) != null) {
                        this.f425800e.remove(Long.valueOf(j3));
                        if (appRuntime instanceof QQAppInterface) {
                            qQAppInterface = (QQAppInterface) appRuntime;
                        } else {
                            qQAppInterface = null;
                        }
                        if (qQAppInterface == null) {
                            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.--handleMessage should in main process, uniseq=", Long.valueOf(j3));
                            return true;
                        }
                        MessageRecord w06 = qQAppInterface.getMessageFacade().w0(string, i3, j3);
                        if (!(w06 instanceof MessageForArkApp)) {
                            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.handleMessage find ArkMsg failed!");
                            return true;
                        }
                        MessageForArkApp messageForArkApp = (MessageForArkApp) w06;
                        if (QLog.isColorLevel()) {
                            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.handleMessage find ArkMsg uniseq=", Long.valueOf(j3), ", frienduin=", string, ", type=", Integer.valueOf(i3), "\n ------>msgR=", w06.getLogColorContent());
                        }
                        messageForArkApp.updateProcessStateAndExtraFlag(1003);
                        messageForArkApp.saveMsgExtStrAndFlag(qQAppInterface);
                        qQAppInterface.getMsgCache().G1(messageForArkApp.frienduin, messageForArkApp.istroop, messageForArkApp.uniseq);
                        h(qQAppInterface, messageForArkApp);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.--handleMessage return bundle=", Integer.valueOf(System.identityHashCode(bundle)), ", uniseq=", Long.valueOf(j3));
                        }
                        return true;
                    }
                }
            } else {
                QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.handleMessage param invalid app=", appRuntime, ",userData=", obj);
                return true;
            }
        }
        return true;
    }

    public Bundle i(MessageForArkApp messageForArkApp) {
        if (messageForArkApp == null) {
            return null;
        }
        synchronized (this.C) {
            Bundle bundle = this.f425800e.get(Long.valueOf(messageForArkApp.uniseq));
            if (bundle != null) {
                if (QLog.isColorLevel()) {
                    QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.allready add to timeout check bundle=", bundle.toString());
                }
                return bundle;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putLong("key_process_message_uniseq", messageForArkApp.uniseq);
            bundle2.putString("key_process_message_friend_uin", messageForArkApp.frienduin);
            bundle2.putInt("key_process_message_uin_type", messageForArkApp.istroop);
            this.f425800e.put(Long.valueOf(messageForArkApp.uniseq), bundle2);
            if (!this.f425803i) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Ark-Msg-Monitor");
                this.f425801f = baseHandlerThread;
                baseHandlerThread.start();
                this.f425802h = new Handler(this.f425801f.getLooper(), this);
            }
            this.f425802h.sendMessageDelayed(this.f425802h.obtainMessage(1, bundle2), this.f425804m);
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.--add timeout check bundle=", Integer.valueOf(System.identityHashCode(bundle2)), ", content", bundle2.toString());
            }
            return bundle2;
        }
    }
}
