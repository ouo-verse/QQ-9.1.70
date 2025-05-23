package com.tencent.mobileqq.activity.bless;

import android.content.Context;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.bless.o;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstractElementData;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0019\u001a\u00020\u0010R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/activity/bless/o;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/bless/BlessManager;", "manager", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactData;", "j", "", "content", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAbstractElementData;", "Lkotlin/collections/ArrayList;", "i", "Ljava/lang/Runnable;", "r", "", ReportConstant.COSTREPORT_PREFIX, "v", "Lcom/tencent/mobileqq/activity/bless/o$a;", "listener", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callBack", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "b", "Z", "getHasEntrance", "()Z", "setHasEntrance", "(Z)V", "hasEntrance", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f180597a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasEntrance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/activity/bless/o$a;", "", "", "b", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/bless/o$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "result", "", "errMsg", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IOperateCallback f180599a;

        b(IOperateCallback iOperateCallback) {
            this.f180599a = iOperateCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iOperateCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int result, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, result, (Object) errMsg);
                return;
            }
            QLog.e("BlessNTUtil", 1, "removeBlessRecentContactData succeed " + result + " errorMessage : " + errMsg);
            IOperateCallback iOperateCallback = this.f180599a;
            if (iOperateCallback != null) {
                iOperateCallback.onResult(result, errMsg);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f180597a = new o();
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<MsgAbstractElementData> i(String content) {
        MsgAbstractElementData msgAbstractElementData = new MsgAbstractElementData(1, content, "", 0, 0);
        ArrayList<MsgAbstractElementData> arrayList = new ArrayList<>();
        arrayList.add(msgAbstractElementData);
        return arrayList;
    }

    private final RecentContactData j(Context context, BlessManager manager) {
        AppInterface appInterface;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            QLog.e("BlessNTUtil", 1, "app is null");
            return null;
        }
        BlessTask X = manager.X();
        String string = context.getResources().getString(R.string.f170625wa);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026qui.R.string.bless_title)");
        if (X != null) {
            string = X.starWord;
            Intrinsics.checkNotNullExpressionValue(string, "task.starWord");
            str = X.entranceHint;
            Intrinsics.checkNotNullExpressionValue(str, "task.entranceHint");
        } else {
            str = "";
        }
        RecentContactData recentContactData = new RecentContactData(AppConstants.SEND_BLESS_UIN, 9003L, string, 133, manager.d0(), "", manager.I(), 2, i(str), 0L, null, null, new ArrayList());
        QLog.d("BlessNTUtil", 2, "getRecentContactData:" + recentContactData);
        return recentContactData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(a listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(a listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final a listener, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (arrayList != null && arrayList.size() >= 1) {
            f180597a.s(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.l
                @Override // java.lang.Runnable
                public final void run() {
                    o.o(o.a.this);
                }
            });
            QLog.d("BlessNTUtil", 1, "hasEntrance is " + hasEntrance);
            return;
        }
        f180597a.s(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.m
            @Override // java.lang.Runnable
            public final void run() {
                o.p(o.a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(a listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(a listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(aa aaVar, IOperateCallback iOperateCallback, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null && arrayList.size() >= 1) {
            aaVar.deleteRecentContacts(arrayList, new b(iOperateCallback));
        } else if (iOperateCallback != null) {
            iOperateCallback.onResult(0, "");
        }
    }

    private final void s(Runnable r16) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            r16.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(r16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d("BlessNTUtil", 1, "setMsgRead result: " + i3 + " , errMsg: " + errMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(int i3, String str) {
        QLog.i("BlessNTUtil", 1, "onResult:" + i3 + " ,errMsg:" + str);
    }

    public final void k(@NotNull final a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            s(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.i
                @Override // java.lang.Runnable
                public final void run() {
                    o.l(o.a.this);
                }
            });
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("BlessNTUtil", 1, "hasEntrance service is null");
            s(new Runnable() { // from class: com.tencent.mobileqq.activity.bless.j
                @Override // java.lang.Runnable
                public final void run() {
                    o.m(o.a.this);
                }
            });
        } else {
            recentContactService.F0(new Contact(133, AppConstants.SEND_BLESS_UIN, ""), new IGetContactsCallback() { // from class: com.tencent.mobileqq.activity.bless.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    o.n(o.a.this, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    public final void q(@Nullable final IOperateCallback callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callBack);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        final aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("BlessNTUtil", 1, "removeBlessRecentContactData service is null");
            if (callBack != null) {
                callBack.onResult(-1, "removeBlessRecentContactData service is null");
                return;
            }
            return;
        }
        recentContactService.F0(new Contact(133, AppConstants.SEND_BLESS_UIN, ""), new IGetContactsCallback() { // from class: com.tencent.mobileqq.activity.bless.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
            public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                o.r(aa.this, callBack, i3, str, arrayList, arrayList2);
            }
        });
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("BlessNTUtil", 1, "clearUnreadNum service is null");
        } else {
            msgService.setMsgRead(new Contact(133, AppConstants.SEND_BLESS_UIN, ""), new IOperateCallback() { // from class: com.tencent.mobileqq.activity.bless.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    o.u(i3, str);
                }
            });
        }
    }

    public final void v(@NotNull Context context, @NotNull BlessManager manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) manager);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(manager, "manager");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("BlessNTUtil", 1, "updateMessageList service is null");
        } else {
            recentContactService.upsertRecentContactManually(j(context, manager), new IOperateCallback() { // from class: com.tencent.mobileqq.activity.bless.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    o.w(i3, str);
                }
            });
            QLog.e("BlessNTUtil", 1, "updateMessageList succeed");
        }
    }
}
