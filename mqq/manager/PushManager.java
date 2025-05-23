package mqq.manager;

/* loaded from: classes28.dex */
public interface PushManager extends Manager {

    /* loaded from: classes28.dex */
    public enum MessageType {
        text,
        video,
        A9,
        qzone,
        mail,
        pengyou,
        dada,
        album,
        customer,
        discuss
    }

    void registProxyMessagePush(int i3, String str, String str2, String... strArr);

    @Deprecated
    void unregistAllNotifyPush();

    void unregistProxyMessagePush(int i3, String str);
}
