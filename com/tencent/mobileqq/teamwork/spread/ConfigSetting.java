package com.tencent.mobileqq.teamwork.spread;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONObject;
import ta1.q;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ConfigSetting {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f292355a;

    /* renamed from: b, reason: collision with root package name */
    private int f292356b;

    /* renamed from: c, reason: collision with root package name */
    private q f292357c;

    /* renamed from: d, reason: collision with root package name */
    private long f292358d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.spread.ConfigSetting$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ConfigSetting this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f292355a.getApp().getSharedPreferences(this.this$0.f292355a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit().putInt("file_str_key_max_count_local", this.this$0.f292356b).commit();
            com.tencent.mobileqq.filemanager.util.d.d(HardCodeUtil.qqStr(R.string.kzx));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a implements WtTicketPromise {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* bridge */ /* synthetic */ q a(a aVar) {
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* bridge */ /* synthetic */ WeakReference b(a aVar) {
            throw null;
        }
    }

    public ConfigSetting(QQAppInterface qQAppInterface) {
        this.f292355a = qQAppInterface;
        r();
    }

    private q g() {
        if (this.f292357c == null) {
            this.f292357c = TencentDocTipsConfigProcessor.a();
        }
        return this.f292357c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void o(final q qVar) {
        if (qVar == null) {
            return;
        }
        try {
            ((ITeamWorkHandler) this.f292355a.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).getTemplateListByHttp(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.spread.e
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    ConfigSetting.n(q.this, obj);
                }
            });
        } catch (Exception e16) {
            QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + e16.toString());
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(q qVar, Object obj) {
        if (!(obj instanceof JSONObject)) {
            return;
        }
        qVar.n((JSONObject) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(final q qVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.f
                @Override // java.lang.Runnable
                public final void run() {
                    ConfigSetting.this.o(qVar);
                }
            }, 128, null, false);
            return;
        }
        QLog.i("ConfigSetting", 1, "pskey async is empty, domain: docs.qq.com");
        q qVar2 = this.f292357c;
        if (qVar2 != null) {
            qVar2.p(false);
        }
    }

    private void r() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.ConfigSetting.1
            @Override // java.lang.Runnable
            public void run() {
                ConfigSetting.this.f292356b = ConfigSetting.this.f292355a.getApp().getSharedPreferences(ConfigSetting.this.f292355a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).getInt("file_str_key_max_count_local", 0);
            }
        });
    }

    public int h() {
        return this.f292356b;
    }

    public q.b i(String str) {
        for (q.b bVar : g().i()) {
            if (bVar.f435750a.contains(str)) {
                return bVar;
            }
        }
        return null;
    }

    public String k(com.tencent.mobileqq.teamwork.spread.a aVar) {
        if (!(aVar instanceof BuddyFileAIOMsgTips) && !(aVar instanceof TroopFileAIOMsgTips)) {
            if (aVar instanceof j) {
                List<q.b> i3 = g().i();
                SparseArray<q.a> j3 = g().j();
                String a16 = aVar.a();
                for (q.b bVar : i3) {
                    if (a16.contains(bVar.f435750a) && j3.valueAt(bVar.f435752c) != null) {
                        return j3.valueAt(bVar.f435752c).f435748c;
                    }
                }
                return "";
            }
            return "";
        }
        Map<String, q.a> b16 = g().b();
        String j16 = com.tencent.mobileqq.filemanager.util.q.j(aVar.a());
        Iterator<String> it = b16.keySet().iterator();
        while (it.hasNext()) {
            q.a aVar2 = b16.get(it.next());
            for (String str : aVar2.f435749d) {
                if (str.equalsIgnoreCase(j16)) {
                    return aVar2.f435748c;
                }
            }
        }
        return "";
    }

    public String l(com.tencent.mobileqq.teamwork.spread.a aVar) {
        if (!(aVar instanceof BuddyFileAIOMsgTips) && !(aVar instanceof TroopFileAIOMsgTips)) {
            if (aVar instanceof j) {
                List<q.b> i3 = g().i();
                SparseArray<q.a> j3 = g().j();
                String a16 = aVar.a();
                for (q.b bVar : i3) {
                    if (a16.contains(bVar.f435750a) && j3.valueAt(bVar.f435752c) != null) {
                        return j3.valueAt(bVar.f435752c).f435747b;
                    }
                }
                return "";
            }
            return "";
        }
        Map<String, q.a> b16 = g().b();
        String j16 = com.tencent.mobileqq.filemanager.util.q.j(aVar.a());
        Iterator<String> it = b16.keySet().iterator();
        while (it.hasNext()) {
            q.a aVar2 = b16.get(it.next());
            for (String str : aVar2.f435749d) {
                if (str.equalsIgnoreCase(j16)) {
                    return aVar2.f435747b;
                }
            }
        }
        return "";
    }

    public String[] m(com.tencent.mobileqq.teamwork.spread.a aVar) {
        Map<String, q.a> b16 = g().b();
        List<q.b> i3 = g().i();
        if (!(aVar instanceof BuddyFileAIOMsgTips) && !(aVar instanceof TroopFileAIOMsgTips)) {
            String[] strArr = new String[i3.size()];
            for (int i16 = 0; i16 < i3.size(); i16++) {
                strArr[i16] = i3.get(i16).f435750a;
            }
            return strArr;
        }
        String j3 = com.tencent.mobileqq.filemanager.util.q.j(aVar.a());
        Iterator<String> it = b16.keySet().iterator();
        while (it.hasNext()) {
            q.a aVar2 = b16.get(it.next());
            for (String str : aVar2.f435749d) {
                if (str.equalsIgnoreCase(j3)) {
                    return aVar2.f435746a;
                }
            }
        }
        return new String[0];
    }

    public boolean q() {
        if (System.currentTimeMillis() - this.f292358d > g().c() * 1000) {
            return true;
        }
        return false;
    }

    public void s(ChatMessage chatMessage) {
        if (!(chatMessage instanceof MessageForText)) {
            this.f292358d = System.currentTimeMillis();
        }
        this.f292356b++;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.ConfigSetting.2
            @Override // java.lang.Runnable
            public void run() {
                ConfigSetting.this.f292355a.getApp().getSharedPreferences(ConfigSetting.this.f292355a.getCurrentAccountUin() + "_m_str_teamwork_tips_sp", 0).edit().putInt("file_str_key_max_count_local", ConfigSetting.this.f292356b).commit();
            }
        });
    }

    public void t(final q qVar) {
        if (qVar == null) {
            return;
        }
        this.f292357c = qVar;
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.spread.d
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
            public final void a(String str) {
                ConfigSetting.this.p(qVar, str);
            }
        });
    }
}
