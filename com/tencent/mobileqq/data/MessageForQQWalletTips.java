package com.tencent.mobileqq.data;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxa.gf.y;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForQQWalletTips extends ChatMessage implements ISafeStream {
    public static final int HB_GOLD_CHANNEL = 999;
    private static final int MSG_SUBTYPE_GOLD = 1;
    private static final int MSG_TYPE_GOLD = 8;
    private static final int MSG_TYPE_IDOM = 7;
    private static final String TAG = "MessageForQQWalletTips";
    public String authKey;
    public String memberUin;
    public String reciverContent;
    public String reciverUin;
    public String senderContent;
    public String senderUin;
    public int subChannel;
    public int subType;
    public String summary;
    public int type;
    protected final String TAG_CMD = "cmd";
    protected final String TAG_JUMP = "jump";
    public boolean bGetTroopMemberInfo = true;
    public int highLightStart = 0;
    public int highLightEnd = 0;
    public String textColor = "";
    public String url = "";
    public int idiomSeq = 0;
    public String idiom = "";
    public int msgType = 0;
    public String richContent = "";
    public String lastPinyin = "";
    public String bytes_jumpurl = "";
    public String poemRule = "";

    private int getHbType() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "msgtype: " + this.msgType + ", subtype: " + this.subType);
        }
        int i3 = this.msgType;
        if (i3 == 7) {
            return 524288;
        }
        if (this.subType != 1 && i3 != 8) {
            return 1;
        }
        return 999;
    }

    private String parseListIdStr(JSONObject jSONObject) {
        int indexOf;
        String optString = jSONObject.optString("data");
        if (optString != null && (indexOf = optString.indexOf("listid=")) >= 0) {
            String substring = optString.substring(indexOf);
            int indexOf2 = substring.indexOf(ContainerUtils.FIELD_DELIMITER);
            if (indexOf2 > 0 && indexOf2 > 7) {
                return substring.substring(7, indexOf2);
            }
            return substring.substring(7);
        }
        return "";
    }

    public void addQQWalletTips(QQAppInterface qQAppInterface, String str, int i3, int i16, String str2, String str3) {
        g gVar = new g(this.frienduin, qQAppInterface.getCurrentAccountUin(), str.toString(), this.istroop, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, ErrorCode.YT_SDK_JSON_PARAM_ERROR, e.K0());
        Bundle bundle = new Bundle();
        bundle.putString("textColor", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle.putInt("key_action", 1);
            bundle.putString("key_action_DATA", str3);
        }
        gVar.b(i3, i16, bundle);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        f.a(qQAppInterface, messageForUniteGrayTip);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        Throwable th5;
        QwSafeInputStream qwSafeInputStream;
        Exception e16;
        QwSafeInputStream qwSafeInputStream2 = null;
        try {
            try {
                qwSafeInputStream = new QwSafeInputStream(this.msgData);
            } catch (Exception e17) {
                qwSafeInputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                th5 = th6;
                if (0 != 0) {
                }
                throw th5;
            }
            try {
                readExternal(qwSafeInputStream);
            } catch (Exception e18) {
                e16 = e18;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "MessageForQQWalletTips doParse fail\uff1a");
                }
                e16.printStackTrace();
                if (qwSafeInputStream == null) {
                    return;
                }
                qwSafeInputStream.close();
            }
            qwSafeInputStream.close();
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                qwSafeInputStream2.close();
            }
            throw th5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    @Override // com.tencent.mobileqq.data.ISafeStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] flushMsgData(int i3) {
        QwSafeOutputStream qwSafeOutputStream;
        try {
            qwSafeOutputStream = new QwSafeOutputStream();
            try {
                writeExternal(qwSafeOutputStream);
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.QQWALLET_MSG, 2, "QQWalletRedPacketMsg write Exception", e);
                }
                if (qwSafeOutputStream != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            qwSafeOutputStream = null;
        }
        if (qwSafeOutputStream != null) {
            return null;
        }
        return qwSafeOutputStream.flushDataAndCloseStream();
    }

    public byte[] getBytes() {
        prewrite();
        return this.msgData;
    }

    public String getQQWalletTips(QQAppInterface qQAppInterface, String str) {
        JSONObject jSONObject;
        if (str != null && !TextUtils.isEmpty(str)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Matcher matcher = Pattern.compile(ITeamWorkUtils.TROOP_FORM_GREY_PATTERN).matcher(str);
            int i3 = 0;
            while (true) {
                if (!matcher.find()) {
                    break;
                }
                int start = matcher.start();
                int end = matcher.end();
                String substring = str.substring(start + 1, end);
                String substring2 = str.substring(i3, start);
                int i16 = end + 1;
                spannableStringBuilder.append((CharSequence) substring2);
                try {
                    jSONObject = new JSONObject(substring);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (jSONObject.has("jump")) {
                    SpannableString parseJumpTag = parseJumpTag(jSONObject);
                    this.highLightStart = spannableStringBuilder.length();
                    if (parseJumpTag != null) {
                        spannableStringBuilder.append((CharSequence) parseJumpTag);
                    }
                    this.highLightEnd = spannableStringBuilder.length();
                    i3 = i16;
                    break;
                }
                continue;
                i3 = i16;
            }
            if (i3 != str.length()) {
                spannableStringBuilder.append(str.subSequence(i3, str.length()));
            }
            return spannableStringBuilder.toString();
        }
        return null;
    }

    public void onReceiveGrapTips() {
        QQAppInterface qQAppInterface;
        String str;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        try {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            if (getHbType() == 524288) {
                str = this.richContent;
            } else if (currentAccountUin.equals(this.senderUin)) {
                str = this.senderContent;
            } else if (currentAccountUin.equals(this.reciverUin)) {
                str = this.reciverContent;
            } else {
                str = this.reciverContent;
            }
            Matcher matcher = Pattern.compile(ITeamWorkUtils.TROOP_FORM_GREY_PATTERN).matcher(str);
            String str2 = "";
            while (matcher.find()) {
                str2 = parseListIdStr(new JSONObject(str.substring(matcher.start() + 1, matcher.end())));
                if (!StringUtil.isEmpty(str2)) {
                    break;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onReceiveGrapTips|listId: " + str2 + ",msgType:" + this.msgType);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    protected SpannableString parseJumpTag(JSONObject jSONObject) {
        if (!jSONObject.optString("jump").equals("1")) {
            return null;
        }
        String optString = jSONObject.optString("desc");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(optString);
        this.textColor = jSONObject.optString("textColor");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (!TextUtils.isEmpty(this.textColor)) {
            if (!this.textColor.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING) && !this.textColor.startsWith("0X")) {
                if (this.textColor.length() == 6) {
                    this.textColor = "#FF" + this.textColor;
                } else if (this.textColor.length() == 8) {
                    this.textColor = "#" + this.textColor;
                } else {
                    this.textColor = "#FF40A0FF";
                }
            } else if (this.textColor.length() == 8) {
                this.textColor = "#FF" + this.textColor.substring(2);
            } else if (this.textColor.length() == 10) {
                this.textColor = "#" + this.textColor.substring(2);
            } else {
                this.textColor = "#FF40A0FF";
            }
        } else {
            this.textColor = "#FF40A0FF";
        }
        this.url = jSONObject.optString("data");
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        byte[] flushMsgData = flushMsgData(this.msgType);
        if (flushMsgData != null) {
            this.msgData = flushMsgData;
        }
    }

    public void readExternal(QwSafeInputStream qwSafeInputStream) throws Exception {
        this.senderUin = qwSafeInputStream.readUTF();
        this.reciverUin = qwSafeInputStream.readUTF();
        this.senderContent = qwSafeInputStream.readUTF();
        this.reciverContent = qwSafeInputStream.readUTF();
        this.authKey = qwSafeInputStream.readUTF();
        this.type = qwSafeInputStream.readInt();
        this.subType = qwSafeInputStream.readInt();
        this.msgType = qwSafeInputStream.readInt();
        this.idiomSeq = qwSafeInputStream.readInt();
        this.idiom = qwSafeInputStream.readUTF();
        this.richContent = qwSafeInputStream.readUTF();
        this.lastPinyin = qwSafeInputStream.readUTF();
        this.bytes_jumpurl = qwSafeInputStream.readUTF();
        this.subChannel = qwSafeInputStream.readInt();
    }

    public void updateMsg(QQAppInterface qQAppInterface) {
        MqqHandler handler;
        if (qQAppInterface != null && (handler = qQAppInterface.getHandler(ChatActivity.class)) != null) {
            Message message = new Message();
            message.what = 80;
            message.arg1 = y.CTRL_INDEX;
            Bundle bundle = new Bundle();
            bundle.putLong("messageUniseq", this.uniseq);
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }

    public void writeExternal(QwSafeOutputStream qwSafeOutputStream) throws Exception {
        qwSafeOutputStream.writeUTF(this.senderUin);
        qwSafeOutputStream.writeUTF(this.reciverUin);
        qwSafeOutputStream.writeUTF(this.senderContent);
        qwSafeOutputStream.writeUTF(this.reciverContent);
        qwSafeOutputStream.writeUTF(this.authKey);
        qwSafeOutputStream.writeInt(this.type);
        qwSafeOutputStream.writeInt(this.subType);
        qwSafeOutputStream.writeInt(this.msgType);
        qwSafeOutputStream.writeInt(this.idiomSeq);
        qwSafeOutputStream.writeUTF(this.idiom);
        qwSafeOutputStream.writeUTF(this.richContent);
        qwSafeOutputStream.writeUTF(this.lastPinyin);
        qwSafeOutputStream.writeUTF(this.bytes_jumpurl);
        qwSafeOutputStream.writeInt(this.subChannel);
    }

    public void writeHeader(QwSafeOutputStream qwSafeOutputStream, int i3) throws Exception {
    }

    public void buildQQWalletTips(QQAppInterface qQAppInterface, Context context, TextView textView) {
    }
}
