package com.tencent.mobileqq.troopAddFrd.nt;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.mobileqq.troopAddFrd.nt.NtTroopMsgHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u001f\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troopAddFrd/nt/e;", "Lcom/tencent/aio/main/businesshelper/h;", "", "e", "c", h.F, "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/mobileqq/troopAddFrd/nt/c;", "d", "Lcom/tencent/mobileqq/troopAddFrd/nt/c;", "troopObserverHelper", "Ljava/lang/String;", "troopUin", "Ljava/lang/ref/WeakReference;", "Lmqq/app/AppRuntime;", "f", "Ljava/lang/ref/WeakReference;", "appRef", "Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper;", "Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper;", "ntTroopMsgHelper", "com/tencent/mobileqq/troopAddFrd/nt/e$a", "i", "Lcom/tencent/mobileqq/troopAddFrd/nt/e$a;", "msgUpdateListener", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class e implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c troopObserverHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AppRuntime> appRef;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NtTroopMsgHelper ntTroopMsgHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a msgUpdateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troopAddFrd/nt/e$a", "Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper$b;", "Lcom/tencent/qqnt/msg/d;", "msg", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements NtTroopMsgHelper.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.troopAddFrd.nt.NtTroopMsgHelper.b
        public void a(@NotNull com.tencent.qqnt.msg.d msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.b() && (msg2.a().atType & 2) != 0) {
                QLog.i(e.this.getTag(), 1, "[onMsgUpdate] handleAtOrReplyMsg. msgRecord.atType=ATTYPEONE");
                NtTroopMsgHelper ntTroopMsgHelper = e.this.ntTroopMsgHelper;
                if (ntTroopMsgHelper != null) {
                    ntTroopMsgHelper.d(msg2, true);
                }
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.msgUpdateListener = new a();
        }
    }

    private final void c() {
        QLog.i(getTag(), 1, "doOnCreate");
        NtTroopMsgHelper ntTroopMsgHelper = new NtTroopMsgHelper();
        this.ntTroopMsgHelper = ntTroopMsgHelper;
        String str = this.troopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        ntTroopMsgHelper.h(str, this.msgUpdateListener);
    }

    private final void e() {
        QLog.i(getTag(), 1, "doOnDelayLoad");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troopAddFrd.nt.d
            @Override // java.lang.Runnable
            public final void run() {
                e.g(e.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e this$0) {
        AppRuntime appRuntime;
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<AppRuntime> weakReference = this$0.appRef;
        String str = null;
        if (weakReference != null) {
            appRuntime = weakReference.get();
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        com.tencent.mobileqq.troopAddFrd.strategy.a a16 = com.tencent.mobileqq.troopAddFrd.strategy.c.a(4);
        String[] strArr = new String[1];
        String str2 = this$0.troopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str2 = null;
        }
        strArr[0] = str2;
        a16.a(qQAppInterface, strArr);
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "qApp.getRuntimeService(I\u2026va, ProcessConstant.MAIN)");
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) runtimeService).getTroopBatchAddFriendMgr();
        String str3 = this$0.troopUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str3 = null;
        }
        troopBatchAddFriendMgr.K(str3, 0);
        com.tencent.mobileqq.troopAddFrd.strategy.a a17 = com.tencent.mobileqq.troopAddFrd.strategy.c.a(1);
        String[] strArr2 = new String[1];
        String str4 = this$0.troopUin;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
        } else {
            str = str4;
        }
        strArr2[0] = str;
        a17.a(qQAppInterface, strArr2);
    }

    private final void h() {
        QLog.i(getTag(), 1, "doOnDestroy");
        NtTroopMsgHelper ntTroopMsgHelper = this.ntTroopMsgHelper;
        if (ntTroopMsgHelper != null) {
            ntTroopMsgHelper.f();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.S0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopBatchAddFriendHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 4, 9, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.troopUin = param.a().g().r().c().j();
        this.appRef = new WeakReference<>(MobileQQ.sMobileQQ.peekAppRuntime());
        this.troopObserverHelper = new c();
        String tag = getTag();
        String str = this.troopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopUin");
            str = null;
        }
        QLog.i(tag, 1, "onCreate\uff0c troopUin=" + str);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, state);
            return;
        }
        c cVar = this.troopObserverHelper;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopObserverHelper");
            cVar = null;
        }
        cVar.h(state);
        if (state != 0) {
            if (state != 4) {
                if (state == 12) {
                    h();
                    return;
                }
                return;
            }
            e();
            return;
        }
        c();
    }
}
