package com.tencent.mobileqq.activity.qqsettingme;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements IElementDynamicParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f185006a;

        a(boolean z16) {
            this.f185006a = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, m.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IElementDynamicParams
        public Map<String, Object> getElementDynamicParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("is_red_tips_em", Integer.valueOf(this.f185006a ? 1 : 0));
            return hashMap;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements IElementDynamicParams {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f185008a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f185009b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f185010c;

        b(boolean z16, int i3, String str) {
            this.f185008a = z16;
            this.f185009b = i3;
            this.f185010c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, m.this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IElementDynamicParams
        public Map<String, Object> getElementDynamicParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("is_red_tips_em", Integer.valueOf(this.f185008a ? 1 : 0));
            hashMap.put("open_page_type", Integer.valueOf(this.f185009b));
            if ("d_zplan".equals(this.f185010c)) {
                hashMap.put("zplan_act_id", Integer.valueOf(m.this.d()));
            }
            return hashMap;
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        PBInt32Field pBInt32Field;
        BusinessInfoCheckUpdate.AppInfo e16 = e();
        if (e16 == null || (pBInt32Field = e16.iNewFlag) == null || pBInt32Field.get() == 0) {
            return -1;
        }
        String str = e16.buffer.get();
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return new JSONObject(str).optInt("_show_mission", -1);
        } catch (Throwable th5) {
            QLog.e("QQSettingDTParamBuilder", 1, "getZPlanReportParams failed.", th5);
            return -1;
        }
    }

    private BusinessInfoCheckUpdate.AppInfo e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return ((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_DRAWER_ZPLAN));
    }

    public IElementDynamicParams b(boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IElementDynamicParams) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        }
        return new b(z16, i3, str);
    }

    public IElementDynamicParams c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IElementDynamicParams) iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
        return new a(z16);
    }
}
