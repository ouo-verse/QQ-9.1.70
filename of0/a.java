package of0;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicEmoticonService;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends RemoteCommand {

    /* renamed from: a, reason: collision with root package name */
    private boolean f422587a;

    /* compiled from: P */
    /* renamed from: of0.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10907a implements IQQComicEmoticonService.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RemoteCommand.OnInvokeFinishLinstener f422588a;

        C10907a(RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
            this.f422588a = onInvokeFinishLinstener;
        }

        @Override // com.tencent.comic.api.IQQComicEmoticonService.a
        public void a(Bundle bundle) {
            this.f422588a.onInvokeFinish(bundle);
        }
    }

    public a(String str, boolean z16) {
        super(str);
        this.f422587a = z16;
    }

    public static void a() {
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (pluginCommunicationHandler != null) {
            pluginCommunicationHandler.register(new a("qqcomicemoticonipccmd", false));
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
        AppRuntime a16 = com.tencent.comic.utils.a.a();
        if (!(a16 instanceof BaseQQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("VipComicEmoticonUploadRemoteCmd", 2, "onRemoteInvoke cannot get QQAppInterface");
            }
            return null;
        }
        if ("Remotecall_uploadEmoticon".equals(bundle.getString("qqcomicemoticonipccmd"))) {
            ((IQQComicEmoticonService) a16.getRuntimeService(IQQComicEmoticonService.class, "")).uploadComicEmoticon(bundle, new C10907a(onInvokeFinishLinstener));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public boolean isSynchronized() {
        return this.f422587a;
    }
}
