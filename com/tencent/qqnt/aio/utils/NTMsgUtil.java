package com.tencent.qqnt.aio.utils;

import android.os.Handler;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EnterOrExitAioInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/utils/NTMsgUtil;", "", "", "chatType", "", "peerUid", "", "g", tl.h.F, "i", "l", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "f", "()Landroid/os/Handler;", "sCommonHandler", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/utils/NTMsgUtil$a;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "enterOrExitAIOListeners", "", "d", "e", "()Z", "enableCheckPadFocus", "<init>", "()V", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NTMsgUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTMsgUtil f352264a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy sCommonHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<a> enterOrExitAIOListeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableCheckPadFocus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/utils/NTMsgUtil$a;", "", "", "chatType", "", "peerUid", "", "b", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        @MainThread
        void a(int chatType, @NotNull String peerUid);

        @MainThread
        void b(int chatType, @NotNull String peerUid);
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47950);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f352264a = new NTMsgUtil();
        lazy = LazyKt__LazyJVMKt.lazy(NTMsgUtil$sCommonHandler$2.INSTANCE);
        sCommonHandler = lazy;
        enterOrExitAIOListeners = new ArrayList<>();
        lazy2 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) NTMsgUtil$enableCheckPadFocus$2.INSTANCE);
        enableCheckPadFocus = lazy2;
    }

    NTMsgUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e() {
        return ((Boolean) enableCheckPadFocus.getValue()).booleanValue();
    }

    private final Handler f() {
        return (Handler) sCommonHandler.getValue();
    }

    private final void g(int chatType, String peerUid) {
        Iterator<T> it = enterOrExitAIOListeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(chatType, peerUid);
        }
    }

    private final void h(int chatType, String peerUid) {
        Iterator<T> it = enterOrExitAIOListeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(chatType, peerUid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, String peerUid) {
        ArrayList<EnterOrExitAioInfo> arrayListOf;
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new EnterOrExitAioInfo(new Contact(i3, peerUid, ""), 1));
            e16.enterOrExitAio(arrayListOf, new IOperateCallback() { // from class: com.tencent.qqnt.aio.utils.y
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    NTMsgUtil.k(i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String str) {
        QLog.d("NTMsgUtil", 1, "onEnterNotify: err=" + i3 + ", msg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(int i3, String peerUid) {
        ArrayList<EnterOrExitAioInfo> arrayListOf;
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new EnterOrExitAioInfo(new Contact(i3, peerUid, ""), 2));
            e16.enterOrExitAio(arrayListOf, new IOperateCallback() { // from class: com.tencent.qqnt.aio.utils.z
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    NTMsgUtil.n(i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3, String str) {
        QLog.d("NTMsgUtil", 1, "onExitNotify: err=" + i3 + ", msg=" + str);
    }

    public final void i(final int chatType, @NotNull final String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, chatType, (Object) peerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (e() && com.tencent.qqnt.util.b.f362976b.isSplitViewMode(BaseApplication.context)) {
            com.tencent.qqnt.kernel.util.b.f359257a.d(peerUid);
        }
        if (Intrinsics.areEqual(peerUid, "")) {
            return;
        }
        f().post(new Runnable() { // from class: com.tencent.qqnt.aio.utils.w
            @Override // java.lang.Runnable
            public final void run() {
                NTMsgUtil.j(chatType, peerUid);
            }
        });
        g(chatType, peerUid);
    }

    public final void l(final int chatType, @NotNull final String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, chatType, (Object) peerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        com.tencent.qqnt.kernel.util.b.f359257a.d(null);
        if (Intrinsics.areEqual(peerUid, "")) {
            return;
        }
        f().post(new Runnable() { // from class: com.tencent.qqnt.aio.utils.x
            @Override // java.lang.Runnable
            public final void run() {
                NTMsgUtil.m(chatType, peerUid);
            }
        });
        h(chatType, peerUid);
    }
}
