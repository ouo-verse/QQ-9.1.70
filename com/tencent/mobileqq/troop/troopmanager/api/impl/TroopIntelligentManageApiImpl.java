package com.tencent.mobileqq.troop.troopmanager.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi;
import com.tencent.pb.troop.intelligentmanage.GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq;
import com.tencent.pb.troop.intelligentmanage.GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingRsp;
import com.tencent.pb.troop.intelligentmanage.IntelligentManageSvrPB$GetManagePageReq;
import com.tencent.pb.troop.intelligentmanage.IntelligentManageSvrPB$GetManagePageRsp;
import com.tencent.pb.troop.intelligentmanage.RobotTipsSvrPB$CancelAdministratorReq;
import com.tencent.pb.troop.intelligentmanage.RobotTipsSvrPB$CancelAdministratorRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x934.cmd0x934$ReqBody;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH\u0016J:\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/api/impl/TroopIntelligentManageApiImpl;", "Lcom/tencent/mobileqq/troop/troopmanager/api/ITroopIntelligentManageApi;", "", "troopUin", "Lcom/tencent/mobileqq/troop/troopmanager/api/ITroopIntelligentManageApi$d;", "callback", "", "getIntelligentSettingItem", "robotUin", "Lcom/tencent/mobileqq/troop/troopmanager/api/ITroopIntelligentManageApi$c;", "getCancelAdminTips", "", "", "instructionTypeList", "targetTroopUinList", "Lcom/tencent/mobileqq/troop/troopmanager/api/ITroopIntelligentManageApi$a;", "applyInstructionCopy", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIntelligentManageApiImpl implements ITroopIntelligentManageApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String APPLY_INSTRUCTION_COPY_CMD_0X92C4 = "OidbSvcTrpcTcp.0x92c4_0";
    private static final int APPLY_INSTRUCTION_COPY_COMMAND = 37572;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String INTELLIGENT_MANAGE_GET_PAGE_CMD_0X91F2 = "OidbSvcTrpcTcp.0x91f2_0";
    private static final int INTELLIGENT_MANAGE_GET_PAGE_COMMAND = 37362;

    @NotNull
    public static final String TAG = "TroopIntelligentManageRepo";

    @NotNull
    private static final String UNSET_ROBOT_ADMIN_TIPS_CMD_0X91F1 = "OidbSvcTrpcTcp.0x91f1_0";
    private static final int UNSET_ROBOT_ADMIN_TIPS_COMMAND = 37361;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/api/impl/TroopIntelligentManageApiImpl$a;", "", "", "APPLY_INSTRUCTION_COPY_CMD_0X92C4", "Ljava/lang/String;", "", "APPLY_INSTRUCTION_COPY_COMMAND", "I", "INTELLIGENT_MANAGE_GET_PAGE_CMD_0X91F2", "INTELLIGENT_MANAGE_GET_PAGE_COMMAND", "TAG", "UNSET_ROBOT_ADMIN_TIPS_CMD_0X91F1", "UNSET_ROBOT_ADMIN_TIPS_COMMAND", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmanager.api.impl.TroopIntelligentManageApiImpl$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/api/impl/TroopIntelligentManageApiImpl$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "troopUin", "", "rtnCode", "msg", "", "b", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "onResult", "errorMsg", "", "onError", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f300505d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ITroopIntelligentManageApi.a f300506e;

        b(String str, ITroopIntelligentManageApi.a aVar) {
            this.f300505d = str;
            this.f300506e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) aVar);
            }
        }

        private final void b(String troopUin, int rtnCode, String msg2) {
            this.f300506e.a(rtnCode, msg2);
            QLog.e(TroopIntelligentManageApiImpl.TAG, 1, "[applyInstructionCopy] [handleErrorResp] troopUin = " + troopUin + " rtnCode = " + rtnCode + ", msg = " + msg2);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
            }
            b(this.f300505d, errorCode, "[onError] errorMsg = " + errorMsg);
            return false;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode == 0 && data != null) {
                try {
                    GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingRsp mergeFrom = new GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingRsp().mergeFrom(data);
                    ITroopIntelligentManageApi.a aVar = this.f300506e;
                    int i3 = mergeFrom.errcode.get();
                    String str = mergeFrom.toast_msg.get();
                    Intrinsics.checkNotNullExpressionValue(str, "resp.toast_msg.get()");
                    aVar.a(i3, str);
                    return;
                } catch (Exception e16) {
                    b(this.f300505d, errorCode, "[resp parse error] e = " + e16);
                    return;
                }
            }
            b(this.f300505d, errorCode, "[onSuccess] data = " + data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/api/impl/TroopIntelligentManageApiImpl$c", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "troopUin", "", "rtnCode", "msg", "", "b", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "onResult", "errorMsg", "", "onError", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f300507d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ITroopIntelligentManageApi.c f300508e;

        c(String str, ITroopIntelligentManageApi.c cVar) {
            this.f300507d = str;
            this.f300508e = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) cVar);
            }
        }

        private final void b(String troopUin, int rtnCode, String msg2) {
            this.f300508e.a(false, false, "");
            QLog.e(TroopIntelligentManageApiImpl.TAG, 1, "[getCancelAdminTips] [handleErrorResp] troopUin = " + troopUin + " rtnCode = " + rtnCode + ", msg = " + msg2);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
            }
            b(this.f300507d, errorCode, "[onError] errorMsg = " + errorMsg);
            return false;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode == 0 && data != null) {
                try {
                    RobotTipsSvrPB$CancelAdministratorRsp mergeFrom = new RobotTipsSvrPB$CancelAdministratorRsp().mergeFrom(data);
                    if (mergeFrom.has_tips.has() && mergeFrom.has_tips.get() && mergeFrom.tips.has() && !TextUtils.isEmpty(mergeFrom.tips.get())) {
                        ITroopIntelligentManageApi.c cVar = this.f300508e;
                        String str = mergeFrom.tips.get();
                        Intrinsics.checkNotNullExpressionValue(str, "resp.tips.get()");
                        cVar.a(true, true, str);
                    } else {
                        this.f300508e.a(true, false, "");
                    }
                    QLog.i(TroopIntelligentManageApiImpl.TAG, 1, "[getCancelAdminTips] [onSuccess] troopUin = " + this.f300507d + " has_tips = " + mergeFrom.has_tips.get() + " tips = " + mergeFrom.tips.get());
                    return;
                } catch (Exception e16) {
                    b(this.f300507d, errorCode, "[resp parse error] e = " + e16);
                    return;
                }
            }
            b(this.f300507d, errorCode, "[onSuccess] data = " + data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/api/impl/TroopIntelligentManageApiImpl$d", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "troopUin", "", "rtnCode", "msg", "", "b", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "onResult", "errorMsg", "", "onError", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f300509d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ITroopIntelligentManageApi.d f300510e;

        d(String str, ITroopIntelligentManageApi.d dVar) {
            this.f300509d = str;
            this.f300510e = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) dVar);
            }
        }

        private final void b(String troopUin, int rtnCode, String msg2) {
            this.f300510e.a(false, null);
            QLog.e(TroopIntelligentManageApiImpl.TAG, 1, "[getCancelAdminTips] [handleErrorResp] troopUin = " + troopUin + " rtnCode = " + rtnCode + ", msg = " + msg2);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
            }
            b(this.f300509d, errorCode, "[onError] errorMsg = " + errorMsg);
            return super.onError(errorCode, errorMsg, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode == 0 && data != null) {
                try {
                    this.f300510e.a(true, new IntelligentManageSvrPB$GetManagePageRsp().mergeFrom(data));
                    QLog.i(TroopIntelligentManageApiImpl.TAG, 1, "[getIntelligentSettingItem] [onSuccess] troopUin = " + this.f300509d);
                    return;
                } catch (Exception e16) {
                    b(this.f300509d, errorCode, "[resp parse error] e = " + e16);
                    return;
                }
            }
            b(this.f300509d, errorCode, "[onSuccess] data = " + data);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIntelligentManageApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi
    public void applyInstructionCopy(@Nullable String troopUin, @Nullable List<Integer> instructionTypeList, @Nullable List<String> targetTroopUinList, @NotNull ITroopIntelligentManageApi.a callback) {
        boolean z16;
        Integer num;
        boolean z17;
        Long longOrNull;
        long j3;
        Long longOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, instructionTypeList, targetTroopUinList, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            List<Integer> list = instructionTypeList;
            if (list != null && !list.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                List<String> list2 = targetTroopUinList;
                if (list2 == null || list2.isEmpty()) {
                    z18 = true;
                }
                if (!z18) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = targetTroopUinList.iterator();
                    while (it.hasNext()) {
                        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                        if (longOrNull2 != null) {
                            arrayList.add(Long.valueOf(longOrNull2.longValue()));
                        }
                    }
                    GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq guanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq = new GuanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq();
                    guanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq.guanjia_settings.set(instructionTypeList);
                    PBUInt64Field pBUInt64Field = guanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq.from_group;
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                    if (longOrNull != null) {
                        j3 = longOrNull.longValue();
                    } else {
                        j3 = 0;
                    }
                    pBUInt64Field.set(j3);
                    guanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq.to_groups.set(arrayList);
                    b bVar = new b(troopUin, callback);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                    ProtoUtils.a((AppInterface) peekAppRuntime, bVar, guanjiaInstructionCopySvrPB$CopyGuanjiaSettingReq.toByteArray(), APPLY_INSTRUCTION_COPY_CMD_0X92C4, APPLY_INSTRUCTION_COPY_COMMAND, 0);
                    return;
                }
            }
        }
        callback.a(-1, "\u72b6\u6001\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5!");
        Integer num2 = null;
        if (instructionTypeList != null) {
            num = Integer.valueOf(instructionTypeList.size());
        } else {
            num = null;
        }
        if (targetTroopUinList != null) {
            num2 = Integer.valueOf(targetTroopUinList.size());
        }
        QLog.e(TAG, 1, "[applyInstructionCopy] troopUin = " + troopUin + " instructionTypeList = " + num + " targetTroopUinList = " + num2);
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi
    public void getCancelAdminTips(@NotNull String troopUin, @NotNull String robotUin, @NotNull ITroopIntelligentManageApi.c callback) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, robotUin, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RobotTipsSvrPB$CancelAdministratorReq robotTipsSvrPB$CancelAdministratorReq = new RobotTipsSvrPB$CancelAdministratorReq();
        PBUInt64Field pBUInt64Field = robotTipsSvrPB$CancelAdministratorReq.group_code;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        pBUInt64Field.set(j3);
        PBUInt64Field pBUInt64Field2 = robotTipsSvrPB$CancelAdministratorReq.robot_uin;
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(robotUin);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        pBUInt64Field2.set(j16);
        c cVar = new c(troopUin, callback);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ProtoUtils.a((AppInterface) peekAppRuntime, cVar, robotTipsSvrPB$CancelAdministratorReq.toByteArray(), UNSET_ROBOT_ADMIN_TIPS_CMD_0X91F1, UNSET_ROBOT_ADMIN_TIPS_COMMAND, 0);
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi
    public void getIntelligentSettingItem(@NotNull String troopUin, @NotNull ITroopIntelligentManageApi.d callback) {
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        cmd0x934$ReqBody cmd0x934_reqbody = new cmd0x934$ReqBody();
        cmd0x934_reqbody.cmd.set(1);
        PBUInt64Field pBUInt64Field = cmd0x934_reqbody.group_id;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        pBUInt64Field.set(j3);
        cmd0x934_reqbody.robot_uin.set(ITroopIntelligentManageApi.SMART_MANAGER_REBOOT_UIN);
        cmd0x934_reqbody.version.set(0);
        IntelligentManageSvrPB$GetManagePageReq intelligentManageSvrPB$GetManagePageReq = new IntelligentManageSvrPB$GetManagePageReq();
        intelligentManageSvrPB$GetManagePageReq.cmd0x934_req_body.set(cmd0x934_reqbody);
        d dVar = new d(troopUin, callback);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ProtoUtils.a((AppInterface) peekAppRuntime, dVar, intelligentManageSvrPB$GetManagePageReq.toByteArray(), INTELLIGENT_MANAGE_GET_PAGE_CMD_0X91F2, INTELLIGENT_MANAGE_GET_PAGE_COMMAND, 0);
    }
}
