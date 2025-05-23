package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f301993a;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f301994a;

        /* renamed from: b, reason: collision with root package name */
        public String f301995b;

        /* renamed from: c, reason: collision with root package name */
        public String f301996c;

        /* renamed from: d, reason: collision with root package name */
        public String f301997d;

        /* renamed from: e, reason: collision with root package name */
        public int f301998e;

        /* renamed from: f, reason: collision with root package name */
        public String f301999f;

        /* renamed from: g, reason: collision with root package name */
        public int f302000g;

        /* renamed from: h, reason: collision with root package name */
        public int f302001h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f301994a = 1;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "TroopBusinessMessage,nick" + ContainerUtils.KEY_VALUE_DELIMITER + this.f301997d + ",flag" + ContainerUtils.KEY_VALUE_DELIMITER + this.f301994a + ",clk" + ContainerUtils.KEY_VALUE_DELIMITER + this.f301996c + ",head" + ContainerUtils.KEY_VALUE_DELIMITER + this.f301995b;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76714);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301993a = ac.class.getName();
        }
    }

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a(MessageRecord messageRecord) {
        a aVar;
        if (messageRecord != null && "1".equals(messageRecord.getExtInfoFromExtStr("troop_msg_has"))) {
            aVar = new a();
            aVar.f301994a = Integer.parseInt(messageRecord.getExtInfoFromExtStr("troop_msg_flag"));
            aVar.f301995b = messageRecord.getExtInfoFromExtStr("troop_msg_head_url");
            aVar.f301996c = messageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
            aVar.f301997d = messageRecord.getExtInfoFromExtStr("troop_msg_nickname");
            aVar.f301999f = messageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
            try {
                aVar.f301998e = Integer.parseInt(messageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
                aVar.f302000g = Integer.parseInt(messageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
                aVar.f302001h = Integer.parseInt(messageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
            } catch (Exception e16) {
                QLog.e(f301993a, 2, "the color string cannot parse to int. " + e16.getMessage());
            }
        } else {
            aVar = null;
        }
        if (messageRecord != null && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND))) {
            TianShuManager.getInstance().cacheTraceInfo(messageRecord.getExtInfoFromExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND));
        }
        return aVar;
    }
}
