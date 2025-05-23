package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTroopFee extends ChatMessage {
    public String actionUrl;
    public String backgroundColor = "#FD9527";
    public String brief;
    public String source;
    public String summary;
    public String title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends DefaultHandler {

        /* renamed from: a, reason: collision with root package name */
        MessageForTroopFee f203104a = new MessageForTroopFee();

        /* renamed from: b, reason: collision with root package name */
        public String f203105b = "";

        a() {
        }

        public MessageForTroopFee a() {
            return this.f203104a;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) throws SAXException {
            String str = new String(cArr, i3, i16);
            if (this.f203105b.equals("title")) {
                this.f203104a.title = str;
            } else if (this.f203105b.equals("summary")) {
                this.f203104a.summary = str;
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str3.equals("msg")) {
                this.f203104a.actionUrl = attributes.getValue("url");
                this.f203104a.brief = attributes.getValue("brief");
                return;
            }
            if (str3.equals("title")) {
                this.f203105b = "title";
                return;
            }
            if (str3.equals("summary")) {
                this.f203105b = "summary";
            } else if (str3.equals("source")) {
                this.f203104a.source = attributes.getValue("name");
            }
        }
    }

    public static MessageForTroopFee decodeMsgFromXmlBuff(QQAppInterface qQAppInterface, int i3, long j3, byte[] bArr, int i16) {
        if (bArr != null && bArr.length >= 2) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(i.j(new String(k.i(bArr, i16), "utf-8")).getBytes());
                a aVar = new a();
                try {
                    SAXParserFactory.newInstance().newSAXParser().parse(byteArrayInputStream, aVar);
                    byteArrayInputStream.close();
                    MessageForTroopFee a16 = aVar.a();
                    if (a16.checkParams() && QLog.isColorLevel()) {
                        QLog.d("StructMsg", 2, "decode MessageForTroopFee for xml buff by stream success");
                    }
                    return a16;
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_TROOP_FEE, 2, "decode MessageForTroopFee for xml buff by stream", e16);
                    }
                    return null;
                } catch (ParserConfigurationException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_TROOP_FEE, 2, "decode MessageForTroopFee for xml buff by stream", e17);
                    }
                    return null;
                } catch (SAXException e18) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_TROOP_FEE, 2, "decode MessageForTroopFee for xml buff by stream", e18);
                    }
                    return null;
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_TROOP_FEE, 2, "decode MessageForTroopFee for xml buff by stream", e19);
                    }
                    return null;
                }
            } catch (UnsupportedEncodingException e26) {
                e26.printStackTrace();
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "decode MessageForTroopFee for xml buff by stream failed. xmlbuff is null or lenght<2");
        }
        return null;
    }

    public boolean checkParams() {
        if (!TextUtils.isEmpty(this.title) && !TextUtils.isEmpty(this.summary) && !TextUtils.isEmpty(this.source) && !TextUtils.isEmpty(this.actionUrl) && !TextUtils.isEmpty(this.brief)) {
            return true;
        }
        return false;
    }

    public void copyFrom(MessageForTroopFee messageForTroopFee) {
        this.title = messageForTroopFee.title;
        this.summary = messageForTroopFee.summary;
        this.source = messageForTroopFee.source;
        this.actionUrl = messageForTroopFee.actionUrl;
        this.brief = messageForTroopFee.brief;
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
        Exception e16;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
                } catch (Exception e17) {
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
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_FEE, 2, "convert byte array to MessageForTroopFee failed", e16);
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
        return this.brief + this.title;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        ObjectOutputStream objectOutputStream;
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Exception e17) {
                    objectOutputStream = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    if (0 != 0) {
                        try {
                            objectOutputStream2.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (Exception e19) {
                        e19.printStackTrace();
                        throw th;
                    }
                }
                try {
                    writeExternal(objectOutputStream);
                    objectOutputStream.close();
                    this.msgData = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                } catch (Exception e27) {
                    e16 = e27;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_FEE, 2, "convert MessageForTroopFee to byte array failed", e16);
                    }
                    e16.printStackTrace();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e28) {
                            e28.printStackTrace();
                        }
                    }
                    byteArrayOutputStream.close();
                }
            } catch (Exception e29) {
                e29.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.title = objectInput.readUTF();
        this.summary = objectInput.readUTF();
        this.source = objectInput.readUTF();
        this.actionUrl = objectInput.readUTF();
        this.brief = objectInput.readUTF();
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.title);
        objectOutput.writeUTF(this.summary);
        objectOutput.writeUTF(this.source);
        objectOutput.writeUTF(this.actionUrl);
        objectOutput.writeUTF(this.brief);
    }
}
