package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.service.message.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForArkBabyqReply extends ChatMessage {
    public String arkMsgId;
    public int arkSearchType;
    public String babyqReplyText;
    public String compatibleMsg;
    public int forwardID;
    public ArrayList<ArkBabyqCardInfo> mArkBabyqReplyCardList;
    public String resIDForLongMsg;
    public boolean showAsBabyq = true;
    public boolean isFailed = false;
    public boolean isSingleApp = true;
    public boolean mHasReportRecv = false;

    public void doOnEvent(int i3) {
        ArrayList<ArkBabyqCardInfo> arrayList = this.mArkBabyqReplyCardList;
        if (arrayList != null) {
            Iterator<ArkBabyqCardInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ArkBabyqCardInfo next = it.next();
                if (next != null) {
                    next.doOnEvent(i3);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        if (this.mArkBabyqReplyCardList == null) {
            this.mArkBabyqReplyCardList = new ArrayList<>();
        }
        fromBytes(this.msgData);
        this.mHasReportRecv = "1".equals(getExtInfoFromExtStr(i.f286264g));
    }

    public boolean fromAppXml(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.babyqReplyText = jSONObject.optString("desc");
            this.arkMsgId = jSONObject.optString("msgId");
            this.arkSearchType = jSONObject.optInt("type", 1);
            this.showAsBabyq = jSONObject.optBoolean("showAsBabyq");
            this.isFailed = jSONObject.optBoolean("fail");
            JSONArray optJSONArray = jSONObject.optJSONArray("apps");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                ArkBabyqCardInfo arkBabyqCardInfo = new ArkBabyqCardInfo(this);
                arkBabyqCardInfo.fromAppXml(optString);
                if (this.mArkBabyqReplyCardList == null) {
                    this.mArkBabyqReplyCardList = new ArrayList<>();
                }
                if (i3 < this.mArkBabyqReplyCardList.size()) {
                    this.mArkBabyqReplyCardList.set(i3, arkBabyqCardInfo);
                } else {
                    this.mArkBabyqReplyCardList.add(arkBabyqCardInfo);
                }
            }
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean fromBytes(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            if (!fromAppXml((String) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject())) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public int getArkBabyqCardCount() {
        ArrayList<ArkBabyqCardInfo> arrayList = this.mArkBabyqReplyCardList;
        int i3 = 0;
        if (arrayList != null) {
            Iterator<ArkBabyqCardInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ArkBabyqCardInfo next = it.next();
                if (next != null) {
                    i3 += next.getArkBabyqCardCount();
                }
            }
        }
        return i3;
    }

    public int getArkBabyqCardCountForApp(String str) {
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        ArrayList<ArkBabyqCardInfo> arrayList = this.mArkBabyqReplyCardList;
        if (arrayList != null) {
            Iterator<ArkBabyqCardInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ArkBabyqCardInfo next = it.next();
                if (next != null) {
                    i3 += next.getArkBabyqCardCountForApp(str);
                }
            }
        }
        return i3;
    }

    public ArkBabyqCardInfo getArkCardByPosition(int i3) {
        int arkBabyqCardCount = getArkBabyqCardCount();
        if (arkBabyqCardCount <= 0 || i3 < 0 || i3 >= arkBabyqCardCount) {
            return null;
        }
        for (int i16 = 0; i16 < this.mArkBabyqReplyCardList.size(); i16++) {
            ArkBabyqCardInfo arkBabyqCardInfo = this.mArkBabyqReplyCardList.get(i16);
            int arkBabyqCardCount2 = arkBabyqCardInfo.getArkBabyqCardCount();
            if (i3 < arkBabyqCardCount2) {
                if (i3 == 0) {
                    return arkBabyqCardInfo;
                }
                return arkBabyqCardInfo.mExtendedArkBabyqCardList.get(i3 - 1);
            }
            i3 -= arkBabyqCardCount2;
        }
        return null;
    }

    public String getSummery() {
        if (!TextUtils.isEmpty(this.babyqReplyText)) {
            return this.babyqReplyText;
        }
        return BaseApplicationImpl.sApplication.getString(R.string.f170467s2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        this.msgData = toBytes();
        this.f203106msg = this.babyqReplyText;
    }

    public String toAppXml() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("desc", this.babyqReplyText);
            jSONObject.put("msgId", this.arkMsgId);
            jSONObject.put("type", this.arkSearchType);
            jSONObject.put("showAsBabyq", this.showAsBabyq);
            jSONObject.put("fail", this.isFailed);
            JSONArray jSONArray = new JSONArray();
            if (this.mArkBabyqReplyCardList != null) {
                for (int i3 = 0; i3 < this.mArkBabyqReplyCardList.size(); i3++) {
                    jSONArray.put(i3, this.mArkBabyqReplyCardList.get(i3).toAppXml());
                }
            }
            jSONObject.put("apps", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(toAppXml());
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public byte[] toPbData() {
        String appXml = toAppXml();
        if (appXml == null) {
            return null;
        }
        try {
            return appXml.getBytes("utf-8");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
