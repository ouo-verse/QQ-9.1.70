package com.tencent.mobileqq.jubao;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.dt.api.JubaoMsgData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends QIPCModule implements BusinessObserver {
    static IPatchRedirector $redirector_;
    private static b G;
    private String C;
    private String D;
    private String E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<ChatMessage> f238929d;

    /* renamed from: e, reason: collision with root package name */
    private String f238930e;

    /* renamed from: f, reason: collision with root package name */
    private String f238931f;

    /* renamed from: h, reason: collision with root package name */
    private int f238932h;

    /* renamed from: i, reason: collision with root package name */
    private String f238933i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<JubaoMsgData> f238934m;

    b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static b b() {
        if (G == null) {
            synchronized (b.class) {
                if (G == null) {
                    G = new b("JubaoIPCServer");
                }
            }
        }
        return G;
    }

    private QQAppInterface getAppInterface() {
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("JubaoIPCServer", 2, "jubaoIpcServer onCall= " + str + ",callbackId = " + i3);
        }
        this.F = i3;
        this.f238930e = bundle.getString("jubao_chat_uin");
        this.f238931f = bundle.getString("jubao_group_code");
        this.f238932h = bundle.getInt("jubao_chat_type");
        this.f238933i = bundle.getString("jubao_evil_uin");
        this.f238934m = (ArrayList) bundle.getSerializable("jubao_msg_list");
        QQAppInterface appInterface = getAppInterface();
        NewIntent newIntent = new NewIntent(appInterface.getApplication().getApplicationContext(), e.class);
        newIntent.putExtra("jubao_evil_uin", this.f238933i);
        newIntent.putExtra("jubao_chat_uin", this.f238930e);
        newIntent.putExtra("jubao_group_code", this.f238931f);
        newIntent.putExtra("jubao_chat_type", this.f238932h);
        newIntent.putExtra("jubao_msg_list", this.f238934m);
        int i16 = this.f238932h;
        if (i16 == 10007) {
            String string = bundle.getString("jubao_game_sig");
            this.C = string;
            newIntent.putExtra("jubao_game_sig", string);
            String string2 = BaseApplication.getContext().getSharedPreferences("jubao_game", 0).getString("jubao_game_evil_uin_".concat(appInterface.getCurrentUin()), "");
            if (!TextUtils.isEmpty(string2)) {
                this.f238930e = string2;
                newIntent.putExtra("jubao_chat_uin", string2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("JubaoIPCServer", 2, "  jubaoIpcServer uin= " + str + ",sig = " + this.C);
            }
        } else if (i16 == 1001) {
            String string3 = bundle.getString("jubao_nearby_sig");
            this.D = string3;
            newIntent.putExtra("jubao_nearby_sig", string3);
        } else if (i16 == 1046) {
            String string4 = bundle.getString("jubao_matchfriend_sig");
            this.E = string4;
            newIntent.putExtra("jubao_matchfriend_sig", string4);
        } else if (i16 == 119) {
            newIntent.putExtra("jubao_nearbypro_sig", bundle.getString("jubao_nearbypro_sig"));
        }
        if (QLog.isColorLevel()) {
            QLog.d("JubaoIPCServer", 2, "jubaoIpcServer onCall= " + str + ",callbackId = " + i3);
        }
        newIntent.setObserver(this);
        appInterface.startServlet(newIntent);
        return null;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        EIPCResult eIPCResult = new EIPCResult();
        bundle.putBoolean("receive_success", z16);
        eIPCResult.data = bundle;
        ArrayList<ChatMessage> arrayList = this.f238929d;
        if (arrayList != null) {
            arrayList.clear();
        }
        callbackResult(this.F, eIPCResult);
    }
}
