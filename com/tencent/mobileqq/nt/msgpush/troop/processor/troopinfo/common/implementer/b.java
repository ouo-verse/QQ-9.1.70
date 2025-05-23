package com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.nt_msg_common$Group;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/common/implementer/b;", "Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/common/implementer/a;", "", "msgFlag", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "memberUin", "", "d", "c", "Lcom/tencent/mobileqq/nt/msgpush/troop/processor/a;", "troopBusinessData", "", "b", "a", "Ljava/lang/String;", "troopUin", "Z", "isNeedNotifyIdChanged", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String memberUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedNotifyIdChanged;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopinfo/common/implementer/b$a;", "", "", "ADMIN_FLAG", "I", "OWNER_FLAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.b$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59466);
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
        } else {
            this.troopUin = "";
            this.memberUin = "";
        }
    }

    private final boolean c(int msgFlag, TroopInfo troopInfo, String memberUin) {
        boolean contains$default;
        String str;
        String replace$default;
        String replace$default2;
        boolean z16;
        boolean contains$default2;
        if ((msgFlag & 22) != 0) {
            String str2 = troopInfo.Administrator;
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                troopInfo.Administrator = memberUin;
                return true;
            }
            String str3 = troopInfo.Administrator;
            Intrinsics.checkNotNullExpressionValue(str3, "troopInfo.Administrator");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) memberUin, false, 2, (Object) null);
            if (!contains$default2) {
                troopInfo.Administrator = troopInfo.Administrator + "|" + memberUin;
                return true;
            }
        } else {
            String str4 = troopInfo.Administrator;
            if (str4 != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str4, (CharSequence) memberUin, false, 2, (Object) null);
                if (contains$default) {
                    str = str4;
                } else {
                    str = null;
                }
                if (str != null) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(str, memberUin + "|", "", false, 4, (Object) null);
                    replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "|" + memberUin, "", false, 4, (Object) null);
                    troopInfo.Administrator = replace$default2;
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean d(int msgFlag, TroopInfo troopInfo, String memberUin) {
        if ((msgFlag & 8) != 0 && !Intrinsics.areEqual(memberUin, troopInfo.troopowneruin)) {
            troopInfo.troopowneruin = memberUin;
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.a
    public void a() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.isNeedNotifyIdChanged) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface == null) {
                return;
            }
            BusinessHandler businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.handler.TroopInfoHandler");
            ((TroopInfoHandler) businessHandler).notifyUI(e.TYPE_TROOP_MEMBER_LEVEL_SINGLE_CHANGED, true, new String[]{this.troopUin, this.memberUin});
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.troop.processor.troopinfo.common.implementer.a
    public void b(@NotNull TroopInfo troopInfo, @NotNull com.tencent.mobileqq.nt.msgpush.troop.processor.a troopBusinessData) {
        boolean z16;
        boolean z17;
        PBUInt32Field pBUInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo, (Object) troopBusinessData);
            return;
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(troopBusinessData, "troopBusinessData");
        if (!troopBusinessData.i()) {
            return;
        }
        boolean z18 = false;
        this.isNeedNotifyIdChanged = false;
        String troopUin = troopInfo.getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String h16 = troopBusinessData.h();
            if (h16 != null && h16.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                String troopUin2 = troopInfo.getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin2, "troopInfo.troopUin");
                this.troopUin = troopUin2;
                this.memberUin = troopBusinessData.h();
                nt_msg_common$Group c16 = troopBusinessData.c();
                if (c16 != null && (pBUInt32Field = c16.msg_flag) != null) {
                    int i3 = pBUInt32Field.get();
                    if (d(i3, troopInfo, this.memberUin) || c(i3, troopInfo, this.memberUin)) {
                        z18 = true;
                    }
                    this.isNeedNotifyIdChanged = z18;
                    return;
                }
                return;
            }
        }
        this.troopUin = "";
        this.memberUin = "";
    }
}
