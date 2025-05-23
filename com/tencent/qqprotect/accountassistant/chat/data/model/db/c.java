package com.tencent.qqprotect.accountassistant.chat.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Entity(tableName = "assistant_robot_message_table")
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @PrimaryKey
    @NotNull
    public final String f363473a;

    /* renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "msg_seq")
    public final long f363474b;

    /* renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "conversation_id")
    public final String f363475c;

    /* renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = QQHealthReportApiImpl.MSG_TYPE_KEY)
    public final int f363476d;

    /* renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "msg_sender_type")
    public final int f363477e;

    /* renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME)
    public final long f363478f;

    /* renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "msg_text")
    public final String f363479g;

    /* renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "msg_ext_text")
    public final String f363480h;

    /* renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "msg_send_status")
    public final int f363481i;

    /* renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "need_reply")
    public final boolean f363482j;

    /* renamed from: k, reason: collision with root package name */
    @ColumnInfo(name = "row_id")
    public final long f363483k;

    public c(@NotNull String str, long j3, String str2, int i3, int i16, long j16, String str3, String str4, int i17, boolean z16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), str2, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16), str3, str4, Integer.valueOf(i17), Boolean.valueOf(z16), Long.valueOf(j17));
            return;
        }
        this.f363473a = str;
        this.f363474b = j3;
        this.f363475c = str2;
        this.f363476d = i3;
        this.f363477e = i16;
        this.f363478f = j16;
        this.f363479g = str3;
        this.f363480h = str4;
        this.f363481i = i17;
        this.f363482j = z16;
        this.f363483k = j17;
    }

    public static c a(JSONObject jSONObject) {
        return new c(jSONObject.optString("msgID"), jSONObject.optLong("msgSeq"), jSONObject.optString("conversationID"), jSONObject.optInt("msgContentType"), jSONObject.optInt("msgSender"), jSONObject.optLong("msgTime"), jSONObject.optString(RemoteMessageConst.MessageBody.MSG_CONTENT), jSONObject.optString("msgExtContent"), jSONObject.optInt("msgSendStatus"), jSONObject.optBoolean("needReply"), jSONObject.optLong("rowID"));
    }

    public static c b(JSONObject jSONObject, long j3) {
        return new c(jSONObject.optString("msgID"), jSONObject.optLong("msgSeq"), jSONObject.optString("conversationID"), jSONObject.optInt("msgContentType"), jSONObject.optInt("msgSender"), jSONObject.optLong("msgTime"), jSONObject.optString(RemoteMessageConst.MessageBody.MSG_CONTENT), jSONObject.optString("msgExtContent"), jSONObject.optInt("msgSendStatus"), jSONObject.optBoolean("needReply"), j3);
    }

    public static String c(JSONObject jSONObject) {
        return jSONObject.optString("msgID");
    }

    public static String d(c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgID", cVar.f363473a);
            jSONObject.put("msgSeq", cVar.f363474b);
            jSONObject.put("conversationID", cVar.f363475c);
            jSONObject.put("msgContentType", cVar.f363476d);
            jSONObject.put("msgSender", cVar.f363477e);
            jSONObject.put("msgTime", cVar.f363478f);
            jSONObject.put(RemoteMessageConst.MessageBody.MSG_CONTENT, cVar.f363479g);
            jSONObject.put("msgExtContent", cVar.f363480h);
            jSONObject.put("msgSendStatus", cVar.f363481i);
            jSONObject.put("needReply", cVar.f363482j);
            jSONObject.put("rowID", cVar.f363483k);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
