package mqq.manager;

import android.content.Context;
import java.util.HashMap;
import mqq.app.TicketManagerListener;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WTLoginRecordSnapshot;
import oicq.wlogin_sdk.request.WtTicketPromise;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TicketManager extends Manager {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface IPskeyManager {
        void reportGetPskey(String[] strArr);
    }

    int addWTLoginRecordFromNT(WTLoginRecordSnapshot wTLoginRecordSnapshot);

    void clearA1(long j3, int i3);

    byte[] getA1(long j3, long j16, byte[] bArr);

    String getA2(String str);

    void getA2(long j3, int i3, MainTicketCallback mainTicketCallback);

    void getD2(long j3, int i3, MainTicketCallback mainTicketCallback);

    Ticket getD2Ticket(String str);

    void getMainTicket(long j3, int i3, MainTicketCallback mainTicketCallback);

    String getOpenA2(String str);

    String getPskey(String str, String str2);

    Ticket getPskey(String str, long j3, String[] strArr, WtTicketPromise wtTicketPromise);

    Ticket getPskeyForOpen(String str, long j3, String[] strArr, byte[] bArr, WtTicketPromise wtTicketPromise);

    String getPt4Token(String str, String str2);

    String getRealSkey(String str);

    @Deprecated
    String getSkey(String str);

    byte[] getSt(String str, int i3);

    byte[] getStkey(String str, int i3);

    String getStweb(String str);

    WTLoginRecordSnapshot getWTLoginRecordSnapshot(long j3, int i3);

    boolean isQQNTSignToWTRefreshSuccess(long j3);

    void registTicketManagerListener(TicketManagerListener ticketManagerListener);

    void reloadCache(Context context);

    int sendRPCData(long j3, String str, String str2, byte[] bArr, int i3);

    void setAlterTicket(HashMap<String, String> hashMap);

    void setPskeyManager(IPskeyManager iPskeyManager);

    void unregistTicketManagerListener(TicketManagerListener ticketManagerListener);

    boolean useAsyncTicketInterface();
}
