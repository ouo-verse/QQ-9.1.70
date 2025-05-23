package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.structmsg.k;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForStarLeague extends ChatMessage {
    public static final int LEVEL_STATUS_DOWN = 2;
    public static final int LEVEL_STATUS_UP = 1;
    public String actionUrl;
    public String brief;
    public int levelStatus;
    public String starAvatar;
    public String starName;
    public String subTitle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends DefaultHandler {

        /* renamed from: a, reason: collision with root package name */
        MessageForStarLeague f203102a = (MessageForStarLeague) q.d(MessageRecord.MSG_TYPE_TROOP_STAR_LEAGUE);

        /* renamed from: b, reason: collision with root package name */
        public String f203103b = "";

        a() {
        }

        public MessageForStarLeague a() {
            return this.f203102a;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) throws SAXException {
            String str = new String(cArr, i3, i16);
            if (str.equals("\n")) {
                return;
            }
            if (this.f203103b.equals("title")) {
                MessageForStarLeague messageForStarLeague = this.f203102a;
                String str2 = messageForStarLeague.starName;
                if (str2 != null) {
                    str = str2.concat(str);
                }
                messageForStarLeague.starName = str;
                this.f203102a.starName.trim();
                return;
            }
            if (this.f203103b.equals("summary")) {
                MessageForStarLeague messageForStarLeague2 = this.f203102a;
                String str3 = messageForStarLeague2.subTitle;
                if (str3 != null) {
                    str = str3.concat(str);
                }
                messageForStarLeague2.subTitle = str;
                this.f203102a.subTitle.trim();
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str3.equals("msg")) {
                this.f203102a.actionUrl = attributes.getValue("url");
                try {
                    this.f203102a.levelStatus = Integer.parseInt(attributes.getValue("levelStatus"));
                } catch (Exception e16) {
                    QLog.e("StructMsg", 1, "levelStatus parse failed!", e16);
                }
                this.f203102a.brief = attributes.getValue("brief");
                return;
            }
            if (str3.equals("picture")) {
                this.f203102a.starAvatar = attributes.getValue("cover");
            } else if (str3.equals("title")) {
                this.f203103b = "title";
            } else if (str3.equals("summary")) {
                this.f203103b = "summary";
            }
        }
    }

    public static MessageForStarLeague decodeMsgFromXmlBuff(QQAppInterface qQAppInterface, int i3, long j3, byte[] bArr, int i16) {
        if (bArr != null && bArr.length >= 2) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(i.j(new String(k.i(bArr, i16), "utf-8")).getBytes());
                a aVar = new a();
                try {
                    SAXParserFactory.newInstance().newSAXParser().parse(byteArrayInputStream, aVar);
                    byteArrayInputStream.close();
                    return aVar.a();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_TROOP_FEE, 2, "decode MessageForTroopFee for xml buff by stream", e16);
                    }
                    return null;
                }
            } catch (UnsupportedEncodingException e17) {
                e17.printStackTrace();
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "decode MessageForTroopFee for xml buff by stream failed. xmlbuff is null or lenght<2");
        }
        return null;
    }

    private String getNotNullString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private void readExternal(ObjectInput objectInput) throws IOException {
        this.starName = objectInput.readUTF();
        this.starAvatar = objectInput.readUTF();
        this.subTitle = objectInput.readUTF();
        this.actionUrl = objectInput.readUTF();
        this.brief = objectInput.readUTF();
        try {
            this.levelStatus = Integer.parseInt(objectInput.readUTF());
        } catch (Exception unused) {
        }
    }

    private void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(getNotNullString(this.starName));
        objectOutput.writeUTF(getNotNullString(this.starAvatar));
        objectOutput.writeUTF(getNotNullString(this.subTitle));
        objectOutput.writeUTF(getNotNullString(this.actionUrl));
        objectOutput.writeUTF(String.valueOf(getNotNullString(this.brief)));
        objectOutput.writeUTF(String.valueOf(this.levelStatus));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        Throwable th5;
        ObjectInputStream objectInputStream;
        IOException e16;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
                } catch (IOException e17) {
                    objectInputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    throw th5;
                }
                try {
                    readExternal(objectInputStream);
                    this.f203106msg = getSummaryMsg();
                    objectInputStream.close();
                } catch (IOException e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert byte array to MessageForTroopGift failed", e16);
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        objectInputStream2.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                throw th5;
            }
        } catch (Exception e26) {
            e26.printStackTrace();
        }
    }

    public byte[] getBytes() {
        prewrite();
        return this.msgData;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (!TextUtils.isEmpty(this.brief)) {
            return this.brief;
        }
        return this.subTitle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        Throwable th5;
        ObjectOutputStream objectOutputStream;
        IOException e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException e17) {
                objectOutputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                th5 = th6;
                if (0 != 0) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e18);
                    }
                }
                throw th5;
            }
            try {
                writeExternal(objectOutputStream);
                objectOutputStream.close();
                this.msgData = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e19);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e26) {
                    e = e26;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e);
                }
            } catch (IOException e27) {
                e16 = e27;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e16);
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e28) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e28);
                        }
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e29) {
                    e = e29;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e);
                }
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                try {
                    objectOutputStream2.close();
                } catch (Exception e36) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e36);
                    }
                }
            }
            byteArrayOutputStream.close();
            throw th5;
        }
    }
}
