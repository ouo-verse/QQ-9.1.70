package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class LoginResult {
    public Account account = new Account();
    public LoginTicketInfo ticket = new LoginTicketInfo();
    public LoginRspInfo rspInfo = new LoginRspInfo();

    public Account getAccount() {
        return this.account;
    }

    public LoginRspInfo getRspInfo() {
        return this.rspInfo;
    }

    public LoginTicketInfo getTicket() {
        return this.ticket;
    }

    public String toString() {
        return "LoginResult{account=" + this.account + ",ticket=" + this.ticket + ",rspInfo=" + this.rspInfo + ",}";
    }
}
