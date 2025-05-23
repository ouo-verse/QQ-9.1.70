package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ReqHead extends JceStruct {
    public int assistantAPILevel;
    public int assistantVersionCode;
    public int cmdId;
    public byte encryptWithPack;
    public String hostPackageName;
    public int hostVersionCode;
    public Net net;
    public String phoneGuid;
    public String qua;
    public int requestId;
    public RomInfo romInfo;
    public SdkInfo sdkInfo;
    public Terminal terminal;
    public TerminalExtra terminalExtra;
    public Ticket ticket;
    public int yybVersion;
    static Terminal cache_terminal = new Terminal();
    static Net cache_net = new Net();
    static SdkInfo cache_sdkInfo = new SdkInfo();
    static RomInfo cache_romInfo = new RomInfo();
    static Ticket cache_ticket = new Ticket();
    static TerminalExtra cache_terminalExtra = new TerminalExtra();

    public ReqHead() {
        this.requestId = 0;
        this.cmdId = 0;
        this.phoneGuid = "";
        this.qua = "";
        this.encryptWithPack = (byte) 0;
        this.terminal = null;
        this.assistantAPILevel = 0;
        this.assistantVersionCode = 0;
        this.net = null;
        this.hostPackageName = "";
        this.hostVersionCode = 0;
        this.sdkInfo = null;
        this.romInfo = null;
        this.ticket = null;
        this.terminalExtra = null;
        this.yybVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.phoneGuid = jceInputStream.readString(2, true);
        this.qua = jceInputStream.readString(3, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 4, false);
        this.terminal = (Terminal) jceInputStream.read((JceStruct) cache_terminal, 5, false);
        this.assistantAPILevel = jceInputStream.read(this.assistantAPILevel, 6, false);
        this.assistantVersionCode = jceInputStream.read(this.assistantVersionCode, 7, false);
        this.net = (Net) jceInputStream.read((JceStruct) cache_net, 8, false);
        this.hostPackageName = jceInputStream.readString(9, false);
        this.hostVersionCode = jceInputStream.read(this.hostVersionCode, 10, false);
        this.sdkInfo = (SdkInfo) jceInputStream.read((JceStruct) cache_sdkInfo, 11, false);
        this.romInfo = (RomInfo) jceInputStream.read((JceStruct) cache_romInfo, 12, false);
        this.ticket = (Ticket) jceInputStream.read((JceStruct) cache_ticket, 13, false);
        this.terminalExtra = (TerminalExtra) jceInputStream.read((JceStruct) cache_terminalExtra, 14, false);
        this.yybVersion = jceInputStream.read(this.yybVersion, 15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.phoneGuid, 2);
        jceOutputStream.write(this.qua, 3);
        jceOutputStream.write(this.encryptWithPack, 4);
        Terminal terminal = this.terminal;
        if (terminal != null) {
            jceOutputStream.write((JceStruct) terminal, 5);
        }
        jceOutputStream.write(this.assistantAPILevel, 6);
        jceOutputStream.write(this.assistantVersionCode, 7);
        Net net = this.net;
        if (net != null) {
            jceOutputStream.write((JceStruct) net, 8);
        }
        String str = this.hostPackageName;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        jceOutputStream.write(this.hostVersionCode, 10);
        SdkInfo sdkInfo = this.sdkInfo;
        if (sdkInfo != null) {
            jceOutputStream.write((JceStruct) sdkInfo, 11);
        }
        RomInfo romInfo = this.romInfo;
        if (romInfo != null) {
            jceOutputStream.write((JceStruct) romInfo, 12);
        }
        Ticket ticket = this.ticket;
        if (ticket != null) {
            jceOutputStream.write((JceStruct) ticket, 13);
        }
        TerminalExtra terminalExtra = this.terminalExtra;
        if (terminalExtra != null) {
            jceOutputStream.write((JceStruct) terminalExtra, 14);
        }
        jceOutputStream.write(this.yybVersion, 15);
    }

    public ReqHead(int i3, int i16, String str, String str2, byte b16, Terminal terminal, int i17, int i18, Net net, String str3, int i19, SdkInfo sdkInfo, RomInfo romInfo, Ticket ticket, TerminalExtra terminalExtra, int i26) {
        this.requestId = i3;
        this.cmdId = i16;
        this.phoneGuid = str;
        this.qua = str2;
        this.encryptWithPack = b16;
        this.terminal = terminal;
        this.assistantAPILevel = i17;
        this.assistantVersionCode = i18;
        this.net = net;
        this.hostPackageName = str3;
        this.hostVersionCode = i19;
        this.sdkInfo = sdkInfo;
        this.romInfo = romInfo;
        this.ticket = ticket;
        this.terminalExtra = terminalExtra;
        this.yybVersion = i26;
    }
}
