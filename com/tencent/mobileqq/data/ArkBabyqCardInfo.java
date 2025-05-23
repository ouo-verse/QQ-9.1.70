package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.ark.d;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.util.QQCustomArkDialogUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ArkBabyqCardInfo implements com.tencent.mobileqq.ark.a {
    public final String TAG = "ArkBabyqCardInfo";
    public String appDesc;
    public String appIntent;
    public String appMinVersion;
    public String appName;
    public String appView;
    public String bizSrc;
    public String compatibleText;
    public String config;
    public String extra;
    public com.tencent.mobileqq.activity.aio.item.b mArkBabyqContainer;
    public WeakReference<MessageForArkBabyqReply> mBabyQReplyMsg;
    public LinkedList<ArkBabyqCardInfo> mExtendedArkBabyqCardList;
    public String metaList;
    public String promptText;

    public ArkBabyqCardInfo(MessageForArkBabyqReply messageForArkBabyqReply) {
        reset();
        this.mBabyQReplyMsg = new WeakReference<>(messageForArkBabyqReply);
    }

    public void doOnEvent(int i3) {
        LinkedList<ArkBabyqCardInfo> linkedList = this.mExtendedArkBabyqCardList;
        if (linkedList != null) {
            Iterator<ArkBabyqCardInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ArkBabyqCardInfo next = it.next();
                if (next != null) {
                    next.doOnEvent(i3);
                }
            }
        }
        com.tencent.mobileqq.activity.aio.item.b bVar = this.mArkBabyqContainer;
        if (bVar != null) {
            bVar.doOnEvent(i3);
            if (i3 == 2) {
                this.mArkBabyqContainer = null;
            }
        }
    }

    public boolean fromAppXml(String str) {
        reset();
        if (str != null && str.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.appName = jSONObject.optString("name");
                this.appIntent = jSONObject.optString("intent");
                this.appView = jSONObject.optString("view");
                this.bizSrc = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                this.appDesc = jSONObject.optString("desc");
                this.appMinVersion = jSONObject.optString("ver");
                this.promptText = jSONObject.optString("prompt");
                this.metaList = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
                this.config = jSONObject.optString(DownloadInfo.spKey_Config);
                this.extra = jSONObject.optString("extra");
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public int getArkBabyqCardCount() {
        LinkedList<ArkBabyqCardInfo> linkedList = this.mExtendedArkBabyqCardList;
        int i3 = 0;
        if (linkedList != null) {
            Iterator<ArkBabyqCardInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ArkBabyqCardInfo next = it.next();
                if (next != null) {
                    i3 += next.getArkBabyqCardCount();
                }
            }
        }
        return i3 + 1;
    }

    public int getArkBabyqCardCountForApp(String str) {
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        LinkedList<ArkBabyqCardInfo> linkedList = this.mExtendedArkBabyqCardList;
        if (linkedList != null) {
            Iterator<ArkBabyqCardInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                ArkBabyqCardInfo next = it.next();
                if (next != null && str.equals(next.appName)) {
                    i3 += next.getArkBabyqCardCount();
                }
            }
        }
        if (str.equals(this.appName)) {
            return i3 + 1;
        }
        return i3;
    }

    public void reset() {
        this.promptText = null;
        this.appName = null;
        this.appIntent = null;
        this.appDesc = null;
        this.appView = null;
        this.appMinVersion = null;
        this.metaList = null;
        this.config = null;
        this.compatibleText = null;
        this.extra = null;
    }

    public String toAppXml() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.appName;
            if (str != null) {
                jSONObject.put("name", str);
            }
            String str2 = this.appIntent;
            if (str2 != null) {
                jSONObject.put("intent", str2);
            }
            String str3 = this.appDesc;
            if (str3 != null) {
                jSONObject.put("desc", str3);
            }
            String str4 = this.appView;
            if (str4 != null) {
                jSONObject.put("view", str4);
            }
            String str5 = this.bizSrc;
            if (str5 != null) {
                jSONObject.put(QQCustomArkDialogUtil.BIZ_SRC, str5);
            }
            String str6 = this.appMinVersion;
            if (str6 != null) {
                jSONObject.put("ver", str6);
            }
            String str7 = this.promptText;
            if (str7 != null) {
                jSONObject.put("prompt", str7);
            }
            String str8 = this.extra;
            if (str8 != null) {
                jSONObject.put("extra", str8);
            }
            if (this.metaList != null) {
                try {
                    jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, new JSONObject(this.metaList));
                } catch (Exception e16) {
                    d.d("ArkBabyqCardInfo", "toAppXml fail, metaList, err=" + e16.getMessage());
                }
            }
            if (this.config != null) {
                try {
                    jSONObject.put(DownloadInfo.spKey_Config, new JSONObject(this.config));
                } catch (Exception e17) {
                    d.d("ArkBabyqCardInfo", "toAppXml fail, config, err=" + e17.getMessage());
                }
            }
            return jSONObject.toString();
        } catch (JSONException e18) {
            e18.printStackTrace();
            return null;
        } catch (Exception e19) {
            e19.printStackTrace();
            return null;
        }
    }
}
