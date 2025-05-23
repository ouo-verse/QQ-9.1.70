package com.tencent.mobileqq.troop.troopfullmember;

import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopfullmember.event.GetSubTroopsInfo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetSubGroupInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GetSubGroupInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetSubGroupInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.SubGroupSimpleInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/c;", "Landroidx/lifecycle/ViewModel;", "", "troopUin", "", "P1", "M1", "Q1", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "i", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "O1", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "setTroopInfo", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "troopInfo", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SubGroupSimpleInfo;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "getSubTroopsInfo", "()Ljava/util/ArrayList;", "setSubTroopsInfo", "(Ljava/util/ArrayList;)V", "subTroopsInfo", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopInfo troopInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<SubGroupSimpleInfo> subTroopsInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopfullmember.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57513);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopInfo = new TroopInfo("");
            this.subTroopsInfo = new ArrayList<>();
        }
    }

    private final void M1(String troopUin) {
        GetSubGroupInfoReq getSubGroupInfoReq = new GetSubGroupInfoReq();
        getSubGroupInfoReq.groupCode = Long.parseLong(troopUin);
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.getSubGroupInfo(getSubGroupInfoReq, new IGetSubGroupInfoCallback() { // from class: com.tencent.mobileqq.troop.troopfullmember.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetSubGroupInfoCallback
                public final void onResult(int i16, String str, GetSubGroupInfoRsp getSubGroupInfoRsp) {
                    c.N1(c.this, i16, str, getSubGroupInfoRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(c this$0, int i3, String str, GetSubGroupInfoRsp getSubGroupInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("TroopFullMemberChangeViewModel", 1, "errCode: " + i3 + " errMsg: " + str);
        if (getSubGroupInfoRsp.subGroups.isEmpty()) {
            QLog.d("TroopFullMemberChangeViewModel", 1, "subGroups isEmpty()");
            return;
        }
        ArrayList<SubGroupSimpleInfo> arrayList = getSubGroupInfoRsp.subGroups;
        Intrinsics.checkNotNullExpressionValue(arrayList, "result.subGroups");
        this$0.subTroopsInfo = arrayList;
        SimpleEventBus.getInstance().dispatchEvent(new GetSubTroopsInfo(this$0.subTroopsInfo));
    }

    private final void P1(String troopUin) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(troopUin);
        Intrinsics.checkNotNullExpressionValue(findTroopInfo, "troopInfoService.findTroopInfo(troopUin)");
        this.troopInfo = findTroopInfo;
    }

    @NotNull
    public final TroopInfo O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopInfo;
    }

    public final void Q1(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        M1(troopUin);
        P1(troopUin);
    }
}
