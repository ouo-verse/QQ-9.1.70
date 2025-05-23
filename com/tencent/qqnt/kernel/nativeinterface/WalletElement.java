package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class WalletElement {
    public String authkey;
    public String billNo;
    public int channelId;
    public int confType;
    public int envelopeId;
    public int grabState;
    public long grabbedAmount;
    public ArrayList<Long> grapUin;
    public int msgFrom;
    public int msgPriority;
    public int msgType;
    public String name;
    public byte[] pbReserve;
    public byte[] pcBody;
    public WalletAio receiver;
    public int redChannel;
    public int redType;
    public int resend;
    public long sendUin;
    public WalletAio sender;
    public int sessiontype;
    public byte[] stringIndex;
    public int templateId;

    public WalletElement() {
        this.sender = new WalletAio();
        this.receiver = new WalletAio();
        this.billNo = "";
        this.authkey = "";
        this.name = "";
        this.pcBody = new byte[0];
        this.stringIndex = new byte[0];
        this.grapUin = new ArrayList<>();
        this.pbReserve = new byte[0];
    }

    public String getAuthkey() {
        return this.authkey;
    }

    public String getBillNo() {
        return this.billNo;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public int getConfType() {
        return this.confType;
    }

    public int getEnvelopeId() {
        return this.envelopeId;
    }

    public int getGrabState() {
        return this.grabState;
    }

    public long getGrabbedAmount() {
        return this.grabbedAmount;
    }

    public ArrayList<Long> getGrapUin() {
        return this.grapUin;
    }

    public int getMsgFrom() {
        return this.msgFrom;
    }

    public int getMsgPriority() {
        return this.msgPriority;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getName() {
        return this.name;
    }

    public byte[] getPbReserve() {
        return this.pbReserve;
    }

    public byte[] getPcBody() {
        return this.pcBody;
    }

    public WalletAio getReceiver() {
        return this.receiver;
    }

    public int getRedChannel() {
        return this.redChannel;
    }

    public int getRedType() {
        return this.redType;
    }

    public int getResend() {
        return this.resend;
    }

    public long getSendUin() {
        return this.sendUin;
    }

    public WalletAio getSender() {
        return this.sender;
    }

    public int getSessiontype() {
        return this.sessiontype;
    }

    public byte[] getStringIndex() {
        return this.stringIndex;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "WalletElement{sendUin=" + this.sendUin + ",sender=" + this.sender + ",receiver=" + this.receiver + ",channelId=" + this.channelId + ",templateId=" + this.templateId + ",resend=" + this.resend + ",msgPriority=" + this.msgPriority + ",redType=" + this.redType + ",billNo=" + this.billNo + ",authkey=" + this.authkey + ",sessiontype=" + this.sessiontype + ",msgType=" + this.msgType + ",envelopeId=" + this.envelopeId + ",name=" + this.name + ",confType=" + this.confType + ",msgFrom=" + this.msgFrom + ",pcBody=" + this.pcBody + ",stringIndex=" + this.stringIndex + ",redChannel=" + this.redChannel + ",grapUin=" + this.grapUin + ",pbReserve=" + this.pbReserve + ",grabState=" + this.grabState + ",grabbedAmount=" + this.grabbedAmount + ",}";
    }

    public WalletElement(long j3, WalletAio walletAio, WalletAio walletAio2, int i3, int i16, int i17, int i18, int i19, String str, String str2, int i26, int i27, int i28, String str3, int i29, int i36, byte[] bArr, byte[] bArr2, int i37, ArrayList<Long> arrayList, byte[] bArr3, int i38, long j16) {
        this.sender = new WalletAio();
        this.receiver = new WalletAio();
        this.billNo = "";
        this.authkey = "";
        this.name = "";
        this.pcBody = new byte[0];
        this.stringIndex = new byte[0];
        new ArrayList();
        this.sendUin = j3;
        this.sender = walletAio;
        this.receiver = walletAio2;
        this.channelId = i3;
        this.templateId = i16;
        this.resend = i17;
        this.msgPriority = i18;
        this.redType = i19;
        this.billNo = str;
        this.authkey = str2;
        this.sessiontype = i26;
        this.msgType = i27;
        this.envelopeId = i28;
        this.name = str3;
        this.confType = i29;
        this.msgFrom = i36;
        this.pcBody = bArr;
        this.stringIndex = bArr2;
        this.redChannel = i37;
        this.grapUin = arrayList;
        this.pbReserve = bArr3;
        this.grabState = i38;
        this.grabbedAmount = j16;
    }
}
