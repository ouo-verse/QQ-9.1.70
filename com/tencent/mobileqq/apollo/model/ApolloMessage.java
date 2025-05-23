package com.tencent.mobileqq.apollo.model;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloMessage implements Serializable {
    private static final long serialVersionUID = 714986505912054930L;
    public String extStr;
    public int peerStatus;
    public int senderStatus;
    public int status;

    /* renamed from: id, reason: collision with root package name */
    public int f194386id = 0;
    public byte[] name = null;
    public byte[] text = null;
    public int flag = 0;
    public long peerUin = 0;
    public long senderTs = 0;
    public long peerTs = 0;
    public boolean isPlayed = false;

    public Apollo3DMessage get3DMessage() {
        Apollo3DMessage apollo3DMessage = null;
        if (TextUtils.isEmpty(this.extStr)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(this.extStr).optJSONObject("mApollo3DMessage");
            if (optJSONObject == null) {
                return null;
            }
            Apollo3DMessage apollo3DMessage2 = new Apollo3DMessage();
            try {
                apollo3DMessage2.setMessageWithJSONObject(optJSONObject);
                return apollo3DMessage2;
            } catch (Throwable th5) {
                th = th5;
                apollo3DMessage = apollo3DMessage2;
                QLog.e("ApolloMessage", 1, "get3DMessage exception", th);
                return apollo3DMessage;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String getActionName() {
        Apollo3DMessage apollo3DMessage = get3DMessage();
        if (apollo3DMessage != null) {
            return apollo3DMessage.actionName3D;
        }
        byte[] bArr = this.name;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return new String(bArr);
    }
}
