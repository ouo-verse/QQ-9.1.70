package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes28.dex */
public class MiPushMessage implements PushMessageHandler.a {
    private static final String KEY_ALIAS = "alias";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DESC = "description";
    private static final String KEY_EXTRA = "extra";
    private static final String KEY_MESSAGE_ID = "messageId";
    private static final String KEY_MESSAGE_TYPE = "messageType";
    private static final String KEY_NOTIFIED = "isNotified";
    private static final String KEY_NOTIFY_ID = "notifyId";
    private static final String KEY_NOTIFY_TYPE = "notifyType";
    private static final String KEY_PASS_THROUGH = "passThrough";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TOPIC = "topic";
    private static final String KEY_USER_ACCOUNT = "user_account";
    public static final int MESSAGE_TYPE_ACCOUNT = 3;
    public static final int MESSAGE_TYPE_ALIAS = 1;
    public static final int MESSAGE_TYPE_REG = 0;
    public static final int MESSAGE_TYPE_TOPIC = 2;
    private static final long serialVersionUID = 1;
    private String alias;
    private String category;
    private String content;
    private String description;
    private boolean isNotified;
    private String messageId;
    private int messageType;
    private int notifyId;
    private int notifyType;
    private int passThrough;
    private String title;
    private String topic;
    private String userAccount;
    private boolean arrived = false;
    private HashMap<String, String> extra = new HashMap<>();

    public static MiPushMessage fromBundle(Bundle bundle) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.messageId = bundle.getString(KEY_MESSAGE_ID);
        miPushMessage.messageType = bundle.getInt(KEY_MESSAGE_TYPE);
        miPushMessage.passThrough = bundle.getInt(KEY_PASS_THROUGH);
        miPushMessage.alias = bundle.getString("alias");
        miPushMessage.userAccount = bundle.getString(KEY_USER_ACCOUNT);
        miPushMessage.topic = bundle.getString("topic");
        miPushMessage.content = bundle.getString("content");
        miPushMessage.description = bundle.getString("description");
        miPushMessage.title = bundle.getString("title");
        miPushMessage.isNotified = bundle.getBoolean(KEY_NOTIFIED);
        miPushMessage.notifyId = bundle.getInt("notifyId");
        miPushMessage.notifyType = bundle.getInt(KEY_NOTIFY_TYPE);
        miPushMessage.category = bundle.getString("category");
        miPushMessage.extra = (HashMap) bundle.getSerializable("extra");
        return miPushMessage;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCategory() {
        return this.category;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getPassThrough() {
        return this.passThrough;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public boolean isArrivedMessage() {
        return this.arrived;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setArrivedMessage(boolean z16) {
        this.arrived = z16;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtra(Map<String, String> map) {
        this.extra.clear();
        if (map != null) {
            this.extra.putAll(map);
        }
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i3) {
        this.messageType = i3;
    }

    public void setNotified(boolean z16) {
        this.isNotified = z16;
    }

    public void setNotifyId(int i3) {
        this.notifyId = i3;
    }

    public void setNotifyType(int i3) {
        this.notifyType = i3;
    }

    public void setPassThrough(int i3) {
        this.passThrough = i3;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public void setUserAccount(String str) {
        this.userAccount = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE_ID, this.messageId);
        bundle.putInt(KEY_PASS_THROUGH, this.passThrough);
        bundle.putInt(KEY_MESSAGE_TYPE, this.messageType);
        if (!TextUtils.isEmpty(this.alias)) {
            bundle.putString("alias", this.alias);
        }
        if (!TextUtils.isEmpty(this.userAccount)) {
            bundle.putString(KEY_USER_ACCOUNT, this.userAccount);
        }
        if (!TextUtils.isEmpty(this.topic)) {
            bundle.putString("topic", this.topic);
        }
        bundle.putString("content", this.content);
        if (!TextUtils.isEmpty(this.description)) {
            bundle.putString("description", this.description);
        }
        if (!TextUtils.isEmpty(this.title)) {
            bundle.putString("title", this.title);
        }
        bundle.putBoolean(KEY_NOTIFIED, this.isNotified);
        bundle.putInt("notifyId", this.notifyId);
        bundle.putInt(KEY_NOTIFY_TYPE, this.notifyType);
        if (!TextUtils.isEmpty(this.category)) {
            bundle.putString("category", this.category);
        }
        HashMap<String, String> hashMap = this.extra;
        if (hashMap != null) {
            bundle.putSerializable("extra", hashMap);
        }
        return bundle;
    }

    public String toString() {
        return "messageId={" + this.messageId + "},passThrough={" + this.passThrough + "},alias={" + this.alias + "},topic={" + this.topic + "},userAccount={" + this.userAccount + "},content={" + this.content + "},description={" + this.description + "},title={" + this.title + "},isNotified={" + this.isNotified + "},notifyId={" + this.notifyId + "},notifyType={" + this.notifyType + "}, category={" + this.category + "}, extra={" + this.extra + "}";
    }
}
