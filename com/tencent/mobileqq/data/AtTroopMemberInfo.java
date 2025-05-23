package com.tencent.mobileqq.data;

import com.tencent.imcore.message.s;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AtTroopMemberInfo {
    public static Callback sCallback = new AtTroopMemberInfoDummyCallback();
    public short startPos = 0;
    public short textLen = 0;
    public byte flag = 0;
    public long uin = 0;
    public long channelId = 0;
    public short wExtBufLen = 0;
    public boolean isResvAttr = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface Callback {
        void dWord2Byte(byte[] bArr, int i3, long j3);

        long getLongData(byte[] bArr, int i3);

        short getShortData(byte[] bArr, int i3);

        void word2Byte(byte[] bArr, int i3, short s16);
    }

    static {
        s.a();
    }

    public static void dWord2Byte(byte[] bArr, int i3, long j3) {
        sCallback.dWord2Byte(bArr, i3, j3);
    }

    public static long getLongData(byte[] bArr, int i3) {
        return sCallback.getLongData(bArr, i3);
    }

    public static short getShortData(byte[] bArr, int i3) {
        return sCallback.getShortData(bArr, i3);
    }

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    public static AtTroopMemberInfo setFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AtTroopMemberInfo atTroopMemberInfo = new AtTroopMemberInfo();
        try {
            atTroopMemberInfo.flag = (byte) ((Integer) jSONObject.get("flag")).intValue();
            atTroopMemberInfo.uin = jSONObject.getLong("uin");
            atTroopMemberInfo.channelId = jSONObject.optLong("channelId", 0L);
            atTroopMemberInfo.startPos = (short) ((Integer) jSONObject.get("startPos")).intValue();
            atTroopMemberInfo.textLen = (short) ((Integer) jSONObject.get("textLen")).intValue();
            atTroopMemberInfo.isResvAttr = jSONObject.optBoolean("isResvAttr");
            return atTroopMemberInfo;
        } catch (ClassCastException e16) {
            QLog.e("AtTroopMemberInfo", 1, e16, new Object[0]);
            return null;
        } catch (JSONException e17) {
            QLog.e("AtTroopMemberInfo", 1, e17, new Object[0]);
            return null;
        }
    }

    public static void word2Byte(byte[] bArr, int i3, short s16) {
        sCallback.word2Byte(bArr, i3, s16);
    }

    public boolean isIncludingAll() {
        if (this.flag == 1 && this.uin == 0) {
            return true;
        }
        return false;
    }

    public boolean isIncludingMe(long j3) {
        if (this.flag == 0 && this.uin == j3) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (this.startPos >= 0 && this.textLen > 0) {
            return true;
        }
        return false;
    }

    public int length() {
        return this.wExtBufLen + 11;
    }

    public boolean readFrom(byte[] bArr, int i3) {
        if (bArr != null && i3 >= 0 && bArr.length >= i3 + 11) {
            this.startPos = getShortData(bArr, i3 + 0);
            this.textLen = getShortData(bArr, i3 + 2);
            this.flag = bArr[i3 + 4];
            this.uin = getLongData(bArr, i3 + 5);
            this.wExtBufLen = getShortData(bArr, i3 + 9);
            return true;
        }
        return false;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("flag", (int) this.flag);
        jSONObject.put("uin", this.uin);
        jSONObject.put("channelId", this.channelId);
        jSONObject.put("startPos", (int) this.startPos);
        jSONObject.put("textLen", (int) this.textLen);
        jSONObject.put("isResvAttr", this.isResvAttr);
        return jSONObject;
    }

    public String toString() {
        return "flag:" + ((int) this.flag) + " uin:" + this.uin + " channelId:" + this.channelId + " startPos:" + ((int) this.startPos) + " textLen:" + ((int) this.textLen) + "\n";
    }

    public boolean writeTo(byte[] bArr, int i3) {
        if (bArr == null || i3 < 0 || bArr.length < i3 + 11) {
            return false;
        }
        word2Byte(bArr, i3 + 0, this.startPos);
        word2Byte(bArr, i3 + 2, this.textLen);
        bArr[i3 + 4] = this.flag;
        dWord2Byte(bArr, i3 + 5, this.uin);
        word2Byte(bArr, i3 + 9, (short) 0);
        return true;
    }
}
