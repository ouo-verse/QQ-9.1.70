package mqq.app;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class MSFServlet extends Servlet {
    public static final AtomicInteger APP_SEQ_FACTORY;
    private static final int INITIAL_VALUE;
    private static final SecureRandom SECURE_RANDOM;
    public static final String TAG = "MSFServlet";
    private final Map<Integer, Intent> mIntents = new ConcurrentHashMap();

    static {
        SecureRandom secureRandom = new SecureRandom();
        SECURE_RANDOM = secureRandom;
        int nextInt = secureRandom.nextInt(1000) + 1;
        INITIAL_VALUE = nextInt;
        APP_SEQ_FACTORY = new AtomicInteger(nextInt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T decodePacket(byte[] bArr, String str, T t16) {
        return (T) Packet.decodePacket(bArr, str, t16);
    }

    public String[] getPreferSSOCommands() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.Servlet
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent onReceive(FromServiceMsg fromServiceMsg) {
        Intent remove = this.mIntents.remove(Integer.valueOf(fromServiceMsg.getAppSeq()));
        onReceive(remove, fromServiceMsg);
        return remove;
    }

    public abstract void onReceive(Intent intent, FromServiceMsg fromServiceMsg);

    public abstract void onSend(Intent intent, Packet packet);

    Intent removeRequest(int i3) {
        return this.mIntents.remove(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        toServiceMsg.setAppSeq(APP_SEQ_FACTORY.incrementAndGet());
        if (toServiceMsg.isNeedCallback() && intent != null) {
            this.mIntents.put(Integer.valueOf(toServiceMsg.getAppSeq()), intent);
        }
        getAppRuntime().getService().sendMessageToMSF(toServiceMsg, this);
    }

    @Override // mqq.app.Servlet
    public void service(Intent intent) {
        Packet packet = new Packet(getAppRuntime().getAccount());
        onSend(intent, packet);
        ToServiceMsg msg2 = packet.toMsg();
        if (msg2 != null) {
            sendToMSF(intent, msg2);
        }
    }
}
