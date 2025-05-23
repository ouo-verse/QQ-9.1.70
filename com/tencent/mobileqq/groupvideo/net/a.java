package com.tencent.mobileqq.groupvideo.net;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupAudioMemNumChangeNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoInviteMemberUpdateNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoMemNumPushInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener;
import com.tencent.qqnt.kernel.nativeinterface.InviteInfo;
import com.tencent.qqnt.kernel.nativeinterface.s;
import com.tencent.widget.ProcessUtil;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/net/a;", "", "", "data", "", "c", "d", "f", "Lcom/tencent/mobileqq/groupvideo/api/b;", "listener", "b", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "ntPushListenerList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "com/tencent/mobileqq/groupvideo/net/a$a", "Lcom/tencent/mobileqq/groupvideo/net/a$a;", "ntKernelListener", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f213804a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<com.tencent.mobileqq.groupvideo.api.b> ntPushListenerList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean isInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C7660a ntKernelListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/groupvideo/net/a$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAVSDKListener;", "", "actionType", "", "buffer", "", "onActionToAVSDK", "", "OnGroupVideoServerPushToAVSDK", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupVideoMemNumPushInfo;", "notifyInfo", "OnGroupVideoMemNumPushInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAudioMemNumChangeNotifyInfo;", "onGroupAudioMemNumChange", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupVideoInviteMemberUpdateNotifyInfo;", "onGroupVideoInviteMemberUpdate", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.net.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7660a implements IKernelAVSDKListener {
        static IPatchRedirector $redirector_;

        C7660a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public /* synthetic */ void OnGroupVideoActionToAVSDK(int i3, String str) {
            s.a(this, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public void OnGroupVideoMemNumPushInfo(@Nullable GroupVideoMemNumPushInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) notifyInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupVideoNTPushHandler", 1, "OnGroupVideoMemNumPushInfo " + notifyInfo + " ");
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public void OnGroupVideoServerPushToAVSDK(int actionType, @Nullable byte[] buffer) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, actionType, (Object) buffer);
                return;
            }
            if (QLog.isColorLevel()) {
                if (buffer != null) {
                    num = Integer.valueOf(buffer.length);
                } else {
                    num = null;
                }
                QLog.d("GroupVideoNTPushHandler", 1, "OnGroupVideoActionToAVSDK " + actionType + ", buffer lenth " + num);
            }
            if (actionType == 17 && buffer != null) {
                a.f213804a.c(buffer);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public /* synthetic */ void OnInviteActionToAVSDK(InviteInfo inviteInfo, int i3, String str) {
            s.d(this, inviteInfo, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public void onActionToAVSDK(int actionType, @Nullable String buffer) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, actionType, (Object) buffer);
                return;
            }
            if (QLog.isColorLevel()) {
                if (buffer != null) {
                    num = Integer.valueOf(buffer.length());
                } else {
                    num = null;
                }
                QLog.d("GroupVideoNTPushHandler", 1, "onActionToAVSDK " + actionType + ", buffer lenth " + num);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public void onGroupAudioMemNumChange(@Nullable GroupAudioMemNumChangeNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) notifyInfo);
            } else if (QLog.isColorLevel()) {
                QLog.d("GroupVideoNTPushHandler", 1, "onGroupAudioMemNumChange " + notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public void onGroupVideoInviteMemberUpdate(@Nullable GroupVideoInviteMemberUpdateNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) notifyInfo);
            } else if (QLog.isColorLevel()) {
                QLog.d("GroupVideoNTPushHandler", 1, "onGroupVideoInviteMemberUpdate " + notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener
        public /* synthetic */ void onRecvGroupVideoJsonBufferRsp(int i3, int i16, String str, String str2) {
            s.h(this, i3, i16, str, str2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f213804a = new a();
        ntPushListenerList = new CopyOnWriteArrayList<>();
        isInit = new AtomicBoolean(false);
        ntKernelListener = new C7660a();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(byte[] data) {
        Iterator<com.tencent.mobileqq.groupvideo.api.b> it = ntPushListenerList.iterator();
        while (it.hasNext()) {
            it.next().onReceivePushMessage(0, data);
        }
    }

    public final void b(@NotNull com.tencent.mobileqq.groupvideo.api.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<com.tencent.mobileqq.groupvideo.api.b> copyOnWriteArrayList = ntPushListenerList;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
        }
    }

    public final void d() {
        com.tencent.qqnt.kernel.api.e eVar;
        IKernelService iKernelService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String currentProcessName = ProcessUtil.getCurrentProcessName(BaseApplication.context);
        AtomicBoolean atomicBoolean = isInit;
        QLog.i("GroupVideoNTPushHandler", 1, "init " + currentProcessName + ", isInit : " + atomicBoolean.get() + " ");
        if (!TextUtils.equals(currentProcessName, "com.tencent.mobileqq") || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            eVar = iKernelService.getAVSDKService();
        } else {
            eVar = null;
        }
        if (eVar != null) {
            eVar.addKernelAVSDKListener(ntKernelListener);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("GroupVideoNTPushHandler", 1, "init error, avsdkService is null!");
        }
    }

    public final void e(@NotNull com.tencent.mobileqq.groupvideo.api.b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<com.tencent.mobileqq.groupvideo.api.b> copyOnWriteArrayList = ntPushListenerList;
        if (copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.remove(listener);
        }
    }

    public final void f() {
        com.tencent.qqnt.kernel.api.e eVar;
        IKernelService iKernelService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String currentProcessName = ProcessUtil.getCurrentProcessName(BaseApplication.context);
        AtomicBoolean atomicBoolean = isInit;
        QLog.i("GroupVideoNTPushHandler", 1, "unInit " + currentProcessName + ", isInit : " + atomicBoolean.get());
        if (!TextUtils.equals(currentProcessName, "com.tencent.mobileqq") || !atomicBoolean.compareAndSet(true, false)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Unit unit = null;
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            eVar = iKernelService.getAVSDKService();
        } else {
            eVar = null;
        }
        if (eVar != null) {
            eVar.removeKernelAVSDKListener(ntKernelListener);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("GroupVideoNTPushHandler", 1, "unInit error, avsdkService is null!");
        }
    }
}
