package com.tencent.mobileqq.troop.honor.processor;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.mutualmark.nt.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/honor/processor/b;", "Lcom/tencent/qqnt/aio/msg/b;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "", "peerUin", "", "chatType", "", "e", "troopUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "memberInfo", h.F, "Lcom/tencent/qqnt/aio/msg/e;", "c", "memberUin", "honorList", "", "honorRichFlag", "g", "", "d", "getBusinessType", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements com.tencent.qqnt.aio.msg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/honor/processor/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.honor.processor.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final e c(String troopUin, TroopMemberInfo memberInfo, AIOMsgItem msg2) {
        if (memberInfo != null && !TextUtils.isEmpty(memberInfo.honorList)) {
            String str = memberInfo.memberuin;
            Intrinsics.checkNotNullExpressionValue(str, "memberInfo.memberuin");
            String str2 = memberInfo.honorList;
            Intrinsics.checkNotNullExpressionValue(str2, "memberInfo.honorList");
            if (d(troopUin, str, str2, memberInfo.mHonorRichFlag)) {
                String str3 = memberInfo.honorList;
                Intrinsics.checkNotNullExpressionValue(str3, "memberInfo.honorList");
                return new e(str3, memberInfo.mHonorRichFlag);
            }
            return null;
        }
        return null;
    }

    private final boolean d(String troopUin, String memberUin, String honorList, byte honorRichFlag) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopHonorService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        if (((ITroopHonorService) runtimeService).getHonorIcon(new ITroopHonorService.b(troopUin, memberUin, honorList, Byte.valueOf(honorRichFlag)), new com.tencent.mobileqq.troop.honor.e(memberUin, troopUin, honorList, honorRichFlag)).size() > 0) {
            return true;
        }
        return false;
    }

    private final void e(AppRuntime app, final AIOMsgItem msg2, final String peerUin, int chatType) {
        String str;
        Byte b16 = null;
        if (d.s(msg2)) {
            msg2.D1(null);
            if (QLog.isDevelopLevel()) {
                QLog.i("TroopHonorMsgProcessor", 4, "[processMsg]: anonymousMsg set mutualMaskInfo to null, msgId is " + msg2.getMsgId());
                return;
            }
            return;
        }
        if (chatType == 2) {
            IRuntimeService runtimeService = app.getRuntimeService(ITroopHonorService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
            if (((ITroopHonorService) runtimeService).isSupportTroopHonor(peerUin)) {
                final long j3 = msg2.getMsgRecord().senderUin;
                if (j3 == 0) {
                    return;
                }
                IRuntimeService runtimeService2 = app.getRuntimeService(ITroopMemberInfoService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
                h(peerUin, ((ITroopMemberInfoService) runtimeService2).getTroopMemberFromCacheOrFetchAsync(peerUin, String.valueOf(j3), "TroopHonorMsgProcessor", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.honor.processor.a
                    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                    public final void a(TroopMemberInfo troopMemberInfo) {
                        b.f(peerUin, j3, this, msg2, troopMemberInfo);
                    }
                }), msg2);
                if (QLog.isDebugVersion()) {
                    long j16 = msg2.getMsgRecord().msgId;
                    e X = msg2.X();
                    if (X != null) {
                        str = X.c();
                    } else {
                        str = null;
                    }
                    e X2 = msg2.X();
                    if (X2 != null) {
                        b16 = Byte.valueOf(X2.d());
                    }
                    QLog.i("TroopHonorMsgProcessor", 4, "[processMsg]: msgId is " + j16 + ", peerUin is " + peerUin + ", memeberUin is " + j3 + " honorStr is " + str + ", richFlag is " + b16 + " ");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String peerUin, long j3, b this$0, AIOMsgItem msg2, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        if (troopMemberInfo == null) {
            QLog.e("TroopHonorMsgProcessor", 2, "processMsg: memberInfo null, peerUin=" + peerUin + ", senderUin=" + j3);
            return;
        }
        e c16 = this$0.c(peerUin, troopMemberInfo, msg2);
        if (!Intrinsics.areEqual(c16, msg2.X())) {
            msg2.D1(c16);
            String str = troopMemberInfo.memberuin;
            Intrinsics.checkNotNullExpressionValue(str, "it.memberuin");
            String str2 = troopMemberInfo.honorList;
            Intrinsics.checkNotNullExpressionValue(str2, "it.honorList");
            this$0.g(peerUin, str, str2, troopMemberInfo.mHonorRichFlag);
            if (QLog.isDebugVersion()) {
                QLog.d("TroopHonorMsgProcessor", 4, "[processMsg]: msgId is " + msg2.getMsgRecord().msgId + ", refresh");
            }
        }
    }

    private final void g(String troopUin, String memberUin, String honorList, byte honorRichFlag) {
        QLog.i("TroopHonorMsgProcessor", 1, "[refresh] troopUin: " + troopUin + ", memberUin: " + memberUin + ", honorList: " + honorList + " honorRichFlag: " + ((int) honorRichFlag));
        if (d(troopUin, memberUin, honorList, honorRichFlag)) {
            f.f252196a.o(memberUin, troopUin, honorList, honorRichFlag);
        }
    }

    private final void h(String troopUin, TroopMemberInfo memberInfo, AIOMsgItem msg2) {
        if (memberInfo != null && !TextUtils.isEmpty(memberInfo.honorList)) {
            String str = memberInfo.memberuin;
            Intrinsics.checkNotNullExpressionValue(str, "memberInfo.memberuin");
            String str2 = memberInfo.honorList;
            Intrinsics.checkNotNullExpressionValue(str2, "memberInfo.honorList");
            if (d(troopUin, str, str2, memberInfo.mHonorRichFlag)) {
                String str3 = memberInfo.honorList;
                Intrinsics.checkNotNullExpressionValue(str3, "memberInfo.honorList");
                msg2.D1(new e(str3, memberInfo.mHonorRichFlag));
                return;
            }
            return;
        }
        msg2.D1(null);
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public void a(@NotNull AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        String peerUin = msg2.getMsgRecord().peerUid;
        int i3 = msg2.getMsgRecord().chatType;
        Intrinsics.checkNotNullExpressionValue(app, "app");
        Intrinsics.checkNotNullExpressionValue(peerUin, "peerUin");
        e(app, msg2, peerUin, i3);
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }
}
