package mqq.app;

import mqq.manager.PushManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes28.dex */
public class PushManagerImpl implements PushManager {
    private AppRuntime app;
    private boolean registered;

    public PushManagerImpl(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    boolean isRegistered() {
        return this.registered;
    }

    @Override // mqq.manager.PushManager
    public void registProxyMessagePush(int i3, String str, String str2, String... strArr) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1025);
        newIntent.putExtra("appid", i3);
        newIntent.putExtra("processName", str);
        newIntent.putExtra("broadcastName", str2);
        newIntent.putExtra("commands", strArr);
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.PushManager
    public void unregistProxyMessagePush(int i3, String str) {
        NewIntent newIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 1026);
        newIntent.putExtra("appid", i3);
        newIntent.putExtra("processName", str);
        newIntent.runNow = true;
        this.app.startServlet(newIntent);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }

    @Override // mqq.manager.PushManager
    public void unregistAllNotifyPush() {
    }
}
