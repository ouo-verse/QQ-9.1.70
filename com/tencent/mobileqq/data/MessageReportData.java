package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "uinType,senderUin,recieverUin,msgType,entrance,entrance2,onlineStatus,terminal,isFirst")
/* loaded from: classes10.dex */
public class MessageReportData extends Entity {
    private static final String IMAME_MSG_FORMAT = "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|";
    private static final String MSG_FORMAT = "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|";
    private static final String TEXT_MSG_FORMAT = "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|";
    public String entrance;
    public String entrance2;
    public String isFirst;
    public int msgCount;
    public String msgSize;
    public String msgType;
    public String onlineStatus;
    public String recieverUin;
    public String senderUin;
    public String terminal;
    public String uinType;

    public MessageReportData() {
        this.uinType = "";
        this.senderUin = "";
        this.recieverUin = "";
        this.msgType = "";
        this.entrance = "";
        this.entrance2 = "";
        this.msgSize = "";
        this.onlineStatus = "";
        this.terminal = "";
        this.isFirst = "";
    }

    public boolean equals(Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageReportData) {
            if (this.uinType != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            MessageReportData messageReportData = (MessageReportData) obj;
            if (messageReportData.uinType != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!(z16 ^ z17)) {
                if (this.senderUin != null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (messageReportData.senderUin != null) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!(z18 ^ z19)) {
                    if (this.recieverUin != null) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    if (messageReportData.recieverUin != null) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    if (!(z26 ^ z27)) {
                        if (this.msgType != null) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        if (messageReportData.msgType != null) {
                            z29 = true;
                        } else {
                            z29 = false;
                        }
                        if (!(z28 ^ z29)) {
                            if (this.entrance != null) {
                                z36 = true;
                            } else {
                                z36 = false;
                            }
                            if (messageReportData.entrance != null) {
                                z37 = true;
                            } else {
                                z37 = false;
                            }
                            if (!(z36 ^ z37)) {
                                if (this.entrance2 != null) {
                                    z38 = true;
                                } else {
                                    z38 = false;
                                }
                                if (messageReportData.entrance2 != null) {
                                    z39 = true;
                                } else {
                                    z39 = false;
                                }
                                if (!(z38 ^ z39)) {
                                    if (this.msgSize != null) {
                                        z46 = true;
                                    } else {
                                        z46 = false;
                                    }
                                    if (messageReportData.msgSize != null) {
                                        z47 = true;
                                    } else {
                                        z47 = false;
                                    }
                                    if (!(z46 ^ z47)) {
                                        if (this.onlineStatus != null) {
                                            z48 = true;
                                        } else {
                                            z48 = false;
                                        }
                                        if (messageReportData.onlineStatus != null) {
                                            z49 = true;
                                        } else {
                                            z49 = false;
                                        }
                                        if (!(z48 ^ z49)) {
                                            if (this.terminal != null) {
                                                z55 = true;
                                            } else {
                                                z55 = false;
                                            }
                                            if (messageReportData.terminal != null) {
                                                z56 = true;
                                            } else {
                                                z56 = false;
                                            }
                                            if (!(z55 ^ z56)) {
                                                if (this.isFirst != null) {
                                                    z57 = true;
                                                } else {
                                                    z57 = false;
                                                }
                                                if (messageReportData.isFirst != null) {
                                                    z58 = true;
                                                } else {
                                                    z58 = false;
                                                }
                                                if (!(z57 ^ z58) && getWholeMsgReport().equals(messageReportData.getWholeMsgReport())) {
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return super.equals(obj);
    }

    public String getMsgReport() {
        String str = this.entrance2;
        if (str != null && str.equals("")) {
            return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|", this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst, Integer.valueOf(this.msgCount));
        }
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|", this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst, Integer.valueOf(this.msgCount));
    }

    public String getWholeMsgReport() {
        return String.format(MSG_FORMAT, this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst);
    }

    public MessageReportData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.uinType = str;
        this.senderUin = str2;
        this.recieverUin = str3;
        this.msgType = str4;
        this.entrance = str5;
        this.entrance2 = str6;
        this.msgSize = str7;
        this.onlineStatus = str8;
        this.terminal = str9;
        this.isFirst = str10;
    }
}
