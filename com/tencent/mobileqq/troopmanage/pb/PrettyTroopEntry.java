package com.tencent.mobileqq.troopmanage.pb;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes19.dex */
public final class PrettyTroopEntry {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f303175a;

    /* renamed from: b, reason: collision with root package name */
    public static String f303176b;

    /* renamed from: c, reason: collision with root package name */
    public static String f303177c;

    /* renamed from: d, reason: collision with root package name */
    public static String f303178d;

    /* renamed from: e, reason: collision with root package name */
    public static String f303179e;

    /* loaded from: classes19.dex */
    public static final class GetCareTextReply extends MessageMicro<GetCareTextReply> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"textLeft", "textRight", "JumpUrl", "report", "NextReqTime"}, new Object[]{"", "", "", null, 0L}, GetCareTextReply.class);
        public final PBStringField textLeft = PBField.initString("");
        public final PBStringField textRight = PBField.initString("");
        public final PBStringField JumpUrl = PBField.initString("");
        public final PBRepeatMessageField<ReportKvItem> report = PBField.initRepeatMessage(ReportKvItem.class);
        public final PBUInt64Field NextReqTime = PBField.initUInt64(0);
    }

    /* loaded from: classes19.dex */
    public static final class GetCareTextRequest extends MessageMicro<GetCareTextRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"GroupCode"}, new Object[]{0L}, GetCareTextRequest.class);
        public final PBUInt64Field GroupCode = PBField.initUInt64(0);
    }

    /* loaded from: classes19.dex */
    public static final class ReportKvItem extends MessageMicro<ReportKvItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ReportKvItem.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f303175a = "key_for_pretty_troop_entry_info_req_time";
        f303176b = "key_for_pretty_troop_entry_text_left";
        f303177c = "key_for_pretty_troop_entry_text_right";
        f303178d = "key_for_pretty_troop_entry_jump_url";
        f303179e = "key_for_pretty_troop_entry_report_value";
    }

    public static String a(AppInterface appInterface, String str) {
        return appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin() + "_" + str, 0).getString(f303178d, "");
    }

    public static void b(AppInterface appInterface, String str, long j3, String str2, String str3, String str4, String str5) {
        appInterface.getApp().getSharedPreferences(appInterface.getCurrentAccountUin() + "_" + str, 0).edit().putLong(f303175a, j3).putString(f303176b, str2).putString(f303177c, str3).putString(f303178d, str4).putString(f303179e, str5).apply();
    }
}
