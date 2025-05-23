package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RefreshTicketResult {
    public LoginTicketInfo ticket = new LoginTicketInfo();
    public SvrErrorInfo errorInfo = new SvrErrorInfo();
    public Account account = new Account();

    public Account getAccount() {
        return this.account;
    }

    public SvrErrorInfo getErrorInfo() {
        return this.errorInfo;
    }

    public LoginTicketInfo getTicket() {
        return this.ticket;
    }

    public String toString() {
        return "RefreshTicketResult{ticket=" + this.ticket + ",errorInfo=" + this.errorInfo + ",account=" + this.account + ",}";
    }
}
