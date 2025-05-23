package com.tencent.biz.anonymous;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.ae;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AnonyStatus;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.msg.f;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final int f78355d = Color.rgb(64, 64, 65);

    /* renamed from: e, reason: collision with root package name */
    public static final int f78356e = Color.rgb(166, 166, 166);

    /* renamed from: f, reason: collision with root package name */
    public static final int f78357f = Color.argb(205, 255, 255, 255);

    /* renamed from: g, reason: collision with root package name */
    public static final int f78358g = Color.argb(154, 255, 255, 255);

    /* renamed from: h, reason: collision with root package name */
    public static final int f78359h = Color.rgb(19, 19, 19);

    /* renamed from: i, reason: collision with root package name */
    public static long f78360i = -1;

    /* renamed from: j, reason: collision with root package name */
    public static a f78361j;

    /* renamed from: b, reason: collision with root package name */
    public c f78363b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f78364c = false;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, b> f78362a = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.anonymous.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0789a {

        /* renamed from: a, reason: collision with root package name */
        public int f78365a;

        /* renamed from: b, reason: collision with root package name */
        public String f78366b;

        /* renamed from: c, reason: collision with root package name */
        public String f78367c;

        /* renamed from: d, reason: collision with root package name */
        public int f78368d;

        /* renamed from: e, reason: collision with root package name */
        public int f78369e;

        /* renamed from: f, reason: collision with root package name */
        public String f78370f;

        public byte[] a() {
            if (TextUtils.isEmpty(this.f78366b)) {
                return null;
            }
            try {
                return this.f78366b.getBytes("ISO-8859-1");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.d("AnonymousChatHelper", 2, "getByteAnId UnsupportedEncodingException");
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f78371a;

        /* renamed from: b, reason: collision with root package name */
        public long f78372b;

        /* renamed from: c, reason: collision with root package name */
        public int f78373c;

        /* renamed from: d, reason: collision with root package name */
        public String f78374d;

        /* renamed from: e, reason: collision with root package name */
        public int f78375e;

        /* renamed from: f, reason: collision with root package name */
        public String f78376f;

        /* renamed from: g, reason: collision with root package name */
        public String f78377g;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f78378a;

        /* renamed from: b, reason: collision with root package name */
        public String f78379b;

        /* renamed from: c, reason: collision with root package name */
        public String f78380c;

        public c() {
        }
    }

    public static C0789a e(MessageRecord messageRecord) {
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("anonymous");
        C0789a c0789a = new C0789a();
        try {
            JSONObject jSONObject = new JSONObject(extInfoFromExtStr);
            if (jSONObject.has(WadlProxyConsts.FLAGS)) {
                c0789a.f78365a = jSONObject.getInt(WadlProxyConsts.FLAGS);
            }
            if (jSONObject.has("an_id")) {
                c0789a.f78366b = jSONObject.getString("an_id");
            }
            if (jSONObject.has("an_nick")) {
                c0789a.f78367c = jSONObject.getString("an_nick");
            }
            if (jSONObject.has("head_protrait")) {
                c0789a.f78368d = jSONObject.getInt("head_protrait");
            }
            if (jSONObject.has(VasQQSettingMeImpl.EXPIRE_TIME)) {
                c0789a.f78369e = jSONObject.getInt(VasQQSettingMeImpl.EXPIRE_TIME);
            }
            if (jSONObject.has("rankColor")) {
                c0789a.f78370f = jSONObject.optString("rankColor");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return c0789a;
    }

    public static String f(int i3) {
        return "https://pub.idqqimg.com/pc/group/anony/portrait/img/" + i3 + ".png";
    }

    public static a h() {
        if (f78361j == null) {
            f78361j = new a();
        }
        return f78361j;
    }

    public static String i(int i3, String str, String str2, int i16, int i17, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WadlProxyConsts.FLAGS, i3);
            jSONObject.put("an_id", str);
            jSONObject.put("an_nick", str2);
            jSONObject.put("head_protrait", i16);
            jSONObject.put(VasQQSettingMeImpl.EXPIRE_TIME, i17);
            jSONObject.put("rankColor", str3);
            return jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AnonymousChatHelper", 2, "getJsonStr JSONException:" + e16.toString());
            }
            e16.printStackTrace();
            return "";
        }
    }

    public static int k(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 0;
        }
        TroopInfo troopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
        String currentUin = peekAppRuntime.getCurrentUin();
        if (troopInfo == null || TextUtils.isEmpty(currentUin)) {
            return 0;
        }
        if (troopInfo.isOwnerOrAdmin()) {
            return 3;
        }
        if (troopInfo.isOwner()) {
            return 2;
        }
        return 1;
    }

    public static boolean l(int i3) {
        if ((i3 & 3) == 3) {
            return true;
        }
        return false;
    }

    public static boolean m(MessageRecord messageRecord) {
        return l(messageRecord.extLong);
    }

    public static boolean n(MessageRecord messageRecord) {
        boolean z16;
        if ((messageRecord instanceof ChatMessage) && ((ChatMessage) messageRecord).fakeSenderType == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !messageRecord.isMultiMsg && e(messageRecord).f78365a == 2) {
            return true;
        }
        return false;
    }

    public static void p(MessageRecord messageRecord) {
        messageRecord.extLong |= 3;
    }

    public void a(MessageRecord messageRecord) {
        if (this.f78364c) {
            int i3 = messageRecord.longMsgCount;
            if (i3 == messageRecord.longMsgIndex + 1 || i3 == 0) {
                this.f78364c = false;
                return;
            }
            return;
        }
        if (d(messageRecord.frienduin)) {
            b g16 = g(messageRecord.frienduin);
            messageRecord.vipBubbleID = g16.f78372b;
            messageRecord.extLong |= 3;
            messageRecord.saveExtInfoToExtStr("anonymous", i(2, g16.f78376f, g16.f78374d, g16.f78373c, g16.f78375e, g16.f78377g));
        }
    }

    public void b(MessageRecord messageRecord) {
        if (this.f78364c) {
            int i3 = messageRecord.longMsgCount;
            if (i3 == messageRecord.longMsgIndex + 1 || i3 == 0) {
                this.f78364c = false;
                return;
            }
            return;
        }
        if (d(messageRecord.frienduin)) {
            b g16 = g(messageRecord.frienduin);
            messageRecord.vipBubbleID = g16.f78372b;
            messageRecord.extLong |= 3;
            messageRecord.saveExtInfoToExtStr("anonymous", i(2, null, g16.f78374d, g16.f78373c, g16.f78375e, g16.f78377g));
        }
    }

    public void c() {
        this.f78362a.clear();
    }

    public boolean d(String str) {
        if (this.f78362a.containsKey(str)) {
            return this.f78362a.get(str).f78371a;
        }
        return false;
    }

    public b g(String str) {
        return this.f78362a.get(str);
    }

    public String j(String str, String str2) {
        c cVar;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (cVar = this.f78363b) == null) {
            return null;
        }
        return cVar.f78380c;
    }

    public void o(String str, long j3, int i3, String str2, int i16, String str3, String str4) {
        AnonyStatus anonyStatus;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AnonymousUpdate", 2, "nickName=" + str2 + ", vipBubbleId=" + j3 + ", headId=" + i3);
        }
        GroupAnonymousInfo anonymousInfo = f.e().getAnonymousInfo(str);
        if (anonymousInfo == null) {
            anonyStatus = new AnonyStatus();
        } else {
            anonyStatus = anonymousInfo.getAnonyStatus();
        }
        GroupAnonymousInfo groupAnonymousInfo = new GroupAnonymousInfo(true, new byte[0], str2, i3, (int) j3, i16, anonyStatus, str4);
        QLog.d("AnonymousUpdate", 1, "info=" + groupAnonymousInfo);
        f.e().updateAnonymousInfo(str, groupAnonymousInfo);
    }

    public void q(String str, String str2, MessageRecord messageRecord) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && messageRecord != null) {
            String p16 = ae.p(messageRecord);
            if (TextUtils.isEmpty(p16)) {
                return;
            }
            if (this.f78363b == null) {
                this.f78363b = new c();
            }
            c cVar = this.f78363b;
            cVar.f78378a = str;
            cVar.f78379b = str2;
            cVar.f78380c = p16;
        }
    }
}
