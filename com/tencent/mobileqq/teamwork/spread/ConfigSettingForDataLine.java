package com.tencent.mobileqq.teamwork.spread;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.q;
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
import ta1.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ConfigSettingForDataLine {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f292359a;

    /* renamed from: b, reason: collision with root package name */
    private int f292360b;

    /* renamed from: c, reason: collision with root package name */
    private ta1.g f292361c;

    /* renamed from: d, reason: collision with root package name */
    private long f292362d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine$3, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ConfigSettingForDataLine this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f292359a.getApp().getSharedPreferences(this.this$0.f292359a.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).edit().putInt("file_str_key_max_count_local", this.this$0.f292360b).commit();
            com.tencent.mobileqq.filemanager.util.d.d(HardCodeUtil.qqStr(R.string.kzv));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a implements WtTicketPromise {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* bridge */ /* synthetic */ ta1.g a(a aVar) {
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* bridge */ /* synthetic */ WeakReference b(a aVar) {
            throw null;
        }
    }

    public ConfigSettingForDataLine(QQAppInterface qQAppInterface) {
        this.f292359a = qQAppInterface;
        r();
    }

    private ta1.g h() {
        if (this.f292361c == null) {
            this.f292361c = TencentDocDataLineTipsConfigProcessor.a();
        }
        return this.f292361c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void o(final ta1.g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            ((ITeamWorkHandler) this.f292359a.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER)).getTemplateListByHttp(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.spread.h
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    ConfigSettingForDataLine.n(ta1.g.this, obj);
                }
            });
        } catch (Exception e16) {
            QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + e16.toString());
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(ta1.g gVar, Object obj) {
        if (!(obj instanceof JSONObject)) {
            return;
        }
        gVar.h((JSONObject) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(final ta1.g gVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.i
                @Override // java.lang.Runnable
                public final void run() {
                    ConfigSettingForDataLine.this.o(gVar);
                }
            }, 128, null, false);
            return;
        }
        QLog.i("ConfigSettingForDataLine", 1, "pskey async is empty, domain: docs.qq.com");
        ta1.g gVar2 = this.f292361c;
        if (gVar2 != null) {
            gVar2.j(false);
        }
    }

    private void r() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.1
            @Override // java.lang.Runnable
            public void run() {
                ConfigSettingForDataLine.this.f292360b = ConfigSettingForDataLine.this.f292359a.getApp().getSharedPreferences(ConfigSettingForDataLine.this.f292359a.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).getInt("file_str_key_max_count_local", 0);
            }
        });
    }

    public int i() {
        return this.f292360b;
    }

    public String k(b bVar) {
        if (bVar instanceof c) {
            Map<String, g.a> a16 = h().a();
            String j3 = q.j(bVar.a());
            Iterator<String> it = a16.keySet().iterator();
            while (it.hasNext()) {
                g.a aVar = a16.get(it.next());
                for (String str : aVar.f435673d) {
                    if (str.equalsIgnoreCase(j3)) {
                        return aVar.f435672c;
                    }
                }
            }
            return "";
        }
        return "";
    }

    public String l(b bVar) {
        if (bVar instanceof c) {
            Map<String, g.a> a16 = h().a();
            String j3 = q.j(bVar.a());
            Iterator<String> it = a16.keySet().iterator();
            while (it.hasNext()) {
                g.a aVar = a16.get(it.next());
                for (String str : aVar.f435673d) {
                    if (str.equalsIgnoreCase(j3)) {
                        return aVar.f435671b;
                    }
                }
            }
            return "";
        }
        return "";
    }

    public String[] m(b bVar) {
        Map<String, g.a> a16 = h().a();
        List<g.b> e16 = h().e();
        if (bVar instanceof c) {
            String j3 = q.j(bVar.a());
            Iterator<String> it = a16.keySet().iterator();
            while (it.hasNext()) {
                g.a aVar = a16.get(it.next());
                for (String str : aVar.f435673d) {
                    if (str.equalsIgnoreCase(j3)) {
                        return aVar.f435670a;
                    }
                }
            }
            return new String[0];
        }
        String[] strArr = new String[e16.size()];
        for (int i3 = 0; i3 < e16.size(); i3++) {
            strArr[i3] = e16.get(i3).f435674a;
        }
        return strArr;
    }

    public boolean q() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f292359a.getApp().getSharedPreferences(this.f292359a.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).getLong("file_str_lstat_show_time_local", 0L);
        this.f292362d = j3;
        if (currentTimeMillis - j3 <= h().b() * 1000) {
            return false;
        }
        return true;
    }

    public void s(DataLineMsgRecord dataLineMsgRecord) {
        this.f292362d = System.currentTimeMillis();
        this.f292360b++;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences sharedPreferences = ConfigSettingForDataLine.this.f292359a.getApp().getSharedPreferences(ConfigSettingForDataLine.this.f292359a.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0);
                sharedPreferences.edit().putInt("file_str_key_max_count_local", ConfigSettingForDataLine.this.f292360b).commit();
                sharedPreferences.edit().putLong("file_str_lstat_show_time_local", ConfigSettingForDataLine.this.f292362d).commit();
            }
        });
    }

    public void t(final ta1.g gVar) {
        if (gVar == null) {
            return;
        }
        this.f292361c = gVar;
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.teamwork.spread.g
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
            public final void a(String str) {
                ConfigSettingForDataLine.this.p(gVar, str);
            }
        });
    }
}
