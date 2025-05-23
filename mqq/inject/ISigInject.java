package mqq.inject;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ISigInject {
    boolean banSkeyAccess();

    String getFakeSkey(String str);

    void getLoginSig(long j3, long j16, ILoginMainTicketCallback iLoginMainTicketCallback);
}
