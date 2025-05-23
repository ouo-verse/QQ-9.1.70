package com.tencent.mobileqq.troop.troopsquare.aio.helper;

import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.api.observer.f;
import com.tencent.mobileqq.troop.troopsquare.api.ITroopSquareApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ab;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u001b\u001f\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", IProfileProtocolConst.PARAM_TARGET_UIN, "", "g", "", "i", "j", "", "getId", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "", "interestedIn", "d", "Lcom/tencent/aio/main/businesshelper/b;", "e", "Ljava/lang/String;", "troopUin", "f", "Ljava/lang/Boolean;", "curSwitchOn", "com/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper$c", h.F, "Lcom/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper$c;", "troopPushObserver", "com/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper$b", "Lcom/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper$b;", "troopMngObserver", "Lcom/tencent/qqnt/troop/ab;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/troop/ab;", "troopInfoChangedObserver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class TroopSquareAIOHelper implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean curSwitchOn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c troopPushObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b troopMngObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ab troopInfoChangedObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper$b", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "reqtype", "result", "", "troopUin", "", "l", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareAIOHelper.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int reqtype, int result, @Nullable String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(reqtype), Integer.valueOf(result), troopUin);
                return;
            }
            if (TroopSquareAIOHelper.this.g(troopUin)) {
                if (2 == reqtype || 9 == reqtype) {
                    com.tencent.aio.main.businesshelper.b bVar = TroopSquareAIOHelper.this.param;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                        bVar = null;
                    }
                    bVar.a().e().h(new AIOTitleEvent.TroopSquareUpdateEvent(false));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/aio/helper/TroopSquareAIOHelper$c", "Lcom/tencent/mobileqq/troop/api/observer/f;", "", "troopUin", "", "reason", "Lcom/tencent/mobileqq/troop/api/handler/ITroopPushHandler$PushType;", "pushType", "", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareAIOHelper.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(@Nullable String troopUin, int reason, @Nullable ITroopPushHandler.PushType pushType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopUin, Integer.valueOf(reason), pushType);
                return;
            }
            if (TroopSquareAIOHelper.this.g(troopUin)) {
                com.tencent.aio.main.businesshelper.b bVar = TroopSquareAIOHelper.this.param;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar = null;
                }
                bVar.a().e().h(new AIOTitleEvent.TroopSquareUpdateEvent(false));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            C = new a(null);
        }
    }

    public TroopSquareAIOHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        this.troopPushObserver = new c();
        this.troopMngObserver = new b();
        this.troopInfoChangedObserver = new ab() { // from class: com.tencent.mobileqq.troop.troopsquare.aio.helper.a
            @Override // com.tencent.qqnt.troop.ab
            public final void a(TroopInfo troopInfo) {
                TroopSquareAIOHelper.h(TroopSquareAIOHelper.this, troopInfo);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(String targetUin) {
        boolean z16;
        if (targetUin != null && targetUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !Intrinsics.areEqual(targetUin, this.troopUin)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TroopSquareAIOHelper this$0, TroopInfo it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.troopUin.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(it.troopuin, this$0.troopUin)) {
            this$0.i();
        }
    }

    private final void i() {
        boolean isSwitchOn = ((ITroopSquareApi) QRoute.api(ITroopSquareApi.class)).isSwitchOn(this.troopUin);
        QLog.i("TroopSquare.Aio.TroopSquareAIOHelper", 1, "isSwitchOn:" + isSwitchOn + ", curSwitchOn:" + this.curSwitchOn);
        if (!Intrinsics.areEqual(this.curSwitchOn, Boolean.valueOf(isSwitchOn))) {
            com.tencent.aio.main.businesshelper.b bVar = this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            bVar.a().e().h(new AIOTitleEvent.TroopSquareUpdateEvent(isSwitchOn));
            this.curSwitchOn = Boolean.valueOf(isSwitchOn);
        }
        if (isSwitchOn) {
            j();
        }
    }

    private final void j() {
        ((ITroopSquareApi) QRoute.api(ITroopSquareApi.class)).getGroupSquareRedpoint(Long.parseLong(this.troopUin), new TroopSquareAIOHelper$updateRedpointInfo$1(this));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.f350690y1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopSquare.Aio.TroopSquareAIOHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.param = param;
        this.troopUin = param.a().g().r().c().j();
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
        if (state != 0) {
            if (state == 12) {
                this.curSwitchOn = null;
                AppInterface e16 = bg.e();
                if (e16 != null) {
                    e16.removeObserver(this.troopPushObserver);
                }
                AppInterface e17 = bg.e();
                if (e17 != null) {
                    e17.removeObserver(this.troopMngObserver);
                }
                ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.troopInfoChangedObserver);
                return;
            }
            return;
        }
        this.curSwitchOn = null;
        AppInterface e18 = bg.e();
        if (e18 != null) {
            e18.addObserver(this.troopPushObserver);
        }
        AppInterface e19 = bg.e();
        if (e19 != null) {
            e19.addObserver(this.troopMngObserver);
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(null, this.troopInfoChangedObserver);
        i();
    }
}
