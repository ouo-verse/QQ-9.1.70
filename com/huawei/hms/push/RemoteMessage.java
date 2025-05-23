package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f37393a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f37394b;

    /* renamed from: c, reason: collision with root package name */
    public static final long[] f37395c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Object> f37396d;

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<String, Object> f37397e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap<String, Object> f37398f;

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap<String, Object> f37399g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap<String, Object> f37400h;

    /* renamed from: i, reason: collision with root package name */
    public Bundle f37401i;

    /* renamed from: j, reason: collision with root package name */
    public Notification f37402j;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f37403a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, String> f37404b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f37403a = bundle;
            this.f37404b = new HashMap();
            bundle.putString("to", str);
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.f37404b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f37404b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.f37403a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put(RemoteMessageConst.TTL, this.f37403a.getInt(RemoteMessageConst.TTL));
                    jSONObject3.put(RemoteMessageConst.SEND_MODE, this.f37403a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.f37403a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put("msgId", this.f37403a.getString("msgId"));
                    jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(x.f37492a));
                    bundle.putString("to", this.f37403a.getString("to"));
                    bundle.putString(RemoteMessageConst.MSGTYPE, this.f37403a.getString(RemoteMessageConst.MSGTYPE));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f37404b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f37403a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f37404b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f37404b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f37403a.putString("msgId", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f37403a.putString(RemoteMessageConst.MSGTYPE, str);
            return this;
        }

        public Builder setReceiptMode(int i3) {
            if (i3 != 1 && i3 != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.f37403a.putInt(RemoteMessageConst.RECEIPT_MODE, i3);
            return this;
        }

        public Builder setSendMode(int i3) {
            if (i3 != 0 && i3 != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.f37403a.putInt(RemoteMessageConst.SEND_MODE, i3);
            return this;
        }

        public Builder setTtl(int i3) {
            if (i3 >= 1 && i3 <= 1296000) {
                this.f37403a.putInt(RemoteMessageConst.TTL, i3);
                return this;
            }
            throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface MessagePriority {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Notification implements Serializable {
        public final long[] A;
        public final String B;

        /* renamed from: a, reason: collision with root package name */
        public final String f37405a;

        /* renamed from: b, reason: collision with root package name */
        public final String f37406b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f37407c;

        /* renamed from: d, reason: collision with root package name */
        public final String f37408d;

        /* renamed from: e, reason: collision with root package name */
        public final String f37409e;

        /* renamed from: f, reason: collision with root package name */
        public final String[] f37410f;

        /* renamed from: g, reason: collision with root package name */
        public final String f37411g;

        /* renamed from: h, reason: collision with root package name */
        public final String f37412h;

        /* renamed from: i, reason: collision with root package name */
        public final String f37413i;

        /* renamed from: j, reason: collision with root package name */
        public final String f37414j;

        /* renamed from: k, reason: collision with root package name */
        public final String f37415k;

        /* renamed from: l, reason: collision with root package name */
        public final String f37416l;

        /* renamed from: m, reason: collision with root package name */
        public final String f37417m;

        /* renamed from: n, reason: collision with root package name */
        public final Uri f37418n;

        /* renamed from: o, reason: collision with root package name */
        public final int f37419o;

        /* renamed from: p, reason: collision with root package name */
        public final String f37420p;

        /* renamed from: q, reason: collision with root package name */
        public final int f37421q;

        /* renamed from: r, reason: collision with root package name */
        public final int f37422r;

        /* renamed from: s, reason: collision with root package name */
        public final int f37423s;

        /* renamed from: t, reason: collision with root package name */
        public final int[] f37424t;

        /* renamed from: u, reason: collision with root package name */
        public final String f37425u;

        /* renamed from: v, reason: collision with root package name */
        public final int f37426v;

        /* renamed from: w, reason: collision with root package name */
        public final String f37427w;

        /* renamed from: x, reason: collision with root package name */
        public final int f37428x;

        /* renamed from: y, reason: collision with root package name */
        public final String f37429y;

        /* renamed from: z, reason: collision with root package name */
        public final String f37430z;

        public /* synthetic */ Notification(Bundle bundle, b bVar) {
            this(bundle);
        }

        public final Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return a(this.f37427w);
        }

        public String getBody() {
            return this.f37408d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f37410f;
            if (strArr == null) {
                return new String[0];
            }
            return (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f37409e;
        }

        public String getChannelId() {
            return this.f37417m;
        }

        public String getClickAction() {
            return this.f37415k;
        }

        public String getColor() {
            return this.f37414j;
        }

        public String getIcon() {
            return this.f37411g;
        }

        public Uri getImageUrl() {
            String str = this.f37420p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.f37429y);
        }

        public String getIntentUri() {
            return this.f37416l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f37424t;
            if (iArr == null) {
                return new int[0];
            }
            return (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f37418n;
        }

        public int getNotifyId() {
            return this.f37419o;
        }

        public String getSound() {
            return this.f37412h;
        }

        public String getTag() {
            return this.f37413i;
        }

        public String getTicker() {
            return this.f37430z;
        }

        public String getTitle() {
            return this.f37405a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f37407c;
            if (strArr == null) {
                return new String[0];
            }
            return (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f37406b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            if (jArr == null) {
                return new long[0];
            }
            return (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f37425u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f37425u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            if (this.f37428x == 1) {
                return true;
            }
            return false;
        }

        public boolean isDefaultLight() {
            if (this.f37421q == 1) {
                return true;
            }
            return false;
        }

        public boolean isDefaultSound() {
            if (this.f37422r == 1) {
                return true;
            }
            return false;
        }

        public boolean isDefaultVibrate() {
            if (this.f37423s == 1) {
                return true;
            }
            return false;
        }

        public boolean isLocalOnly() {
            if (this.f37426v == 1) {
                return true;
            }
            return false;
        }

        public Notification(Bundle bundle) {
            this.f37405a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f37408d = bundle.getString("content");
            this.f37406b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f37409e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f37407c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f37410f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f37411g = bundle.getString("icon");
            this.f37414j = bundle.getString("color");
            this.f37412h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f37413i = bundle.getString("tag");
            this.f37417m = bundle.getString("channelId");
            this.f37415k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f37416l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f37419o = bundle.getInt("notifyId");
            String string = bundle.getString("url");
            this.f37418n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f37420p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f37421q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f37422r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f37423s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f37424t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f37425u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f37426v = bundle.getInt("localOnly");
            this.f37427w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.f37428x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f37429y = bundle.getString("priority", null);
            this.f37430z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString("visibility", null);
        }
    }

    static {
        String[] strArr = new String[0];
        f37393a = strArr;
        int[] iArr = new int[0];
        f37394b = iArr;
        long[] jArr = new long[0];
        f37395c = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        f37396d = hashMap;
        hashMap.put("from", "");
        hashMap.put(RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(RemoteMessageConst.SEND_TIME, "");
        hashMap.put(RemoteMessageConst.TTL, 86400);
        hashMap.put(RemoteMessageConst.URGENCY, 2);
        hashMap.put(RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        f37397e = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f37398f = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put(RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        f37399g = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put(RemoteMessageConst.Notification.WHEN, "");
        hashMap4.put("localOnly", 1);
        hashMap4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put("priority", "");
        hashMap4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put("visibility", "");
        hashMap4.put("channelId", "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        f37400h = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        hashMap5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
        CREATOR = new b();
    }

    public RemoteMessage(Bundle bundle) {
        this.f37401i = a(bundle);
    }

    public static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(w.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("param");
        }
        return null;
    }

    public static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject b16 = b(bundle);
        JSONObject a16 = a(b16);
        String string = JsonUtil.getString(a16, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(a16, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject d16 = d(a16);
        JSONObject b17 = b(d16);
        JSONObject c16 = c(d16);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && s.a(a16, d16, string)) {
            bundle2.putString("data", w.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString("to");
        String string3 = bundle.getString(RemoteMessageConst.MSGTYPE);
        String string4 = JsonUtil.getString(a16, "msgId", null);
        bundle2.putString("to", string2);
        bundle2.putString("data", string);
        bundle2.putString("msgId", string4);
        bundle2.putString(RemoteMessageConst.MSGTYPE, string3);
        JsonUtil.transferJsonObjectToBundle(b16, bundle2, f37396d);
        bundle2.putBundle("notification", a(b16, a16, d16, b17, c16));
        return bundle2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f37401i.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap hashMap = new HashMap();
        String string = this.f37401i.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.f37401i.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f37401i.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f37401i.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f37401i.getString("from");
    }

    public String getMessageId() {
        return this.f37401i.getString("msgId");
    }

    public String getMessageType() {
        return this.f37401i.getString(RemoteMessageConst.MSGTYPE);
    }

    public Notification getNotification() {
        Bundle bundle = this.f37401i.getBundle("notification");
        b bVar = null;
        if (this.f37402j == null && bundle != null) {
            this.f37402j = new Notification(bundle, bVar);
        }
        if (this.f37402j == null) {
            this.f37402j = new Notification(new Bundle(), bVar);
        }
        return this.f37402j;
    }

    public int getOriginalUrgency() {
        int i3 = this.f37401i.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i3 != 1 && i3 != 2) {
            return 0;
        }
        return i3;
    }

    public int getReceiptMode() {
        return this.f37401i.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f37401i.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f37401i.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f37401i.getString("to");
    }

    public String getToken() {
        return this.f37401i.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f37401i.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i3 = this.f37401i.getInt(RemoteMessageConst.URGENCY);
        if (i3 != 1 && i3 != 2) {
            return 0;
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeBundle(this.f37401i);
        parcel.writeSerializable(this.f37402j);
    }

    public RemoteMessage(Parcel parcel) {
        this.f37401i = parcel.readBundle();
        this.f37402j = (Notification) parcel.readSerializable();
    }

    public static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    public final Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f37397e);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f37398f);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f37399g);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f37400h);
        bundle.putInt("notifyId", JsonUtil.getInt(jSONObject2, "notifyId", 0));
        return bundle;
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
