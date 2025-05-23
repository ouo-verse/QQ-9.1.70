package com.tencent.qqnt.aio.helper;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.cmd0x1132.oidb_0x1132$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001\u001c\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/helper/dy;", "Lcom/tencent/aio/main/businesshelper/h;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "", tl.h.F, "troopUin", "g", "e", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "peerUid", "Lcom/tencent/aio/main/businesshelper/b;", "helpParam", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "f", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mDialogSafetyReminder", "com/tencent/qqnt/aio/helper/dy$b", "Lcom/tencent/qqnt/aio/helper/dy$b;", "troopFansObserver", "<init>", "()V", "i", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class dy implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String peerUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helpParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQCustomDialog mDialogSafetyReminder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b troopFansObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/helper/dy$a;", "", "", "troopUin", "", "b", "peerUid", "", "a", "MMKV_KEY_TROOPFANS_CHECK", "Ljava/lang/String;", "TAG", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.dy$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(String troopUin) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(app.applicationCont\u2026t, QMMKVFile.FILE_COMMON)");
            return from.decodeStringSet("MMKV_KEY_TROOPFANS_CHECK", new HashSet()).contains(troopUin);
        }

        public final void a(String peerUid) {
            String str;
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str2 = "";
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
            TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(peerUid);
            if (findTroopInfo == null || !findTroopInfo.isOwnerOrAdmin()) {
                return;
            }
            boolean t16 = StudyModeManager.t();
            Card findFriendCardByUin = ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).findFriendCardByUin(peekAppRuntime);
            boolean z16 = findFriendCardByUin != null && findFriendCardByUin.age < 18;
            if (t16 || z16) {
                if (b(peerUid)) {
                    QLog.i("TroopFansHelper", 1, "has check troopUin:" + peerUid);
                    return;
                }
                if (!TextUtils.isEmpty(findTroopInfo.troopname)) {
                    str2 = "" + findTroopInfo.troopname;
                }
                if (!TextUtils.isEmpty(findTroopInfo.mRichFingerMemo)) {
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2 + "|" + findTroopInfo.mRichFingerMemo;
                    } else {
                        str = findTroopInfo.mRichFingerMemo;
                        Intrinsics.checkNotNullExpressionValue(str, "{\n                    tr\u2026gerMemo\n                }");
                    }
                    str2 = str;
                }
                if (!TextUtils.isEmpty(str2) && (peekAppRuntime instanceof AppInterface)) {
                    Object businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopFansHandlerName());
                    Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.fans.api.ITroopFansHandler");
                    ((com.tencent.mobileqq.troop.fans.api.a) businessHandler).c1(peerUid, str2);
                }
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/helper/dy$b", "Lcom/tencent/mobileqq/troop/fans/api/b;", "", "isSuccess", "", IProfileProtocolConst.PARAM_TROOP_CODE, "", "info", "", "result", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.troop.fans.api.b {
        b() {
        }

        @Override // com.tencent.mobileqq.troop.fans.api.b
        protected void a(boolean isSuccess, String troopCode, Object info, int result) {
            String str = dy.this.peerUid;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUid");
                str = null;
            }
            if (Intrinsics.areEqual(str, troopCode) && result == 0 && (info instanceof oidb_0x1132$RspBody)) {
                oidb_0x1132$RspBody oidb_0x1132_rspbody = (oidb_0x1132$RspBody) info;
                if (!oidb_0x1132_rspbody.match_status.has() || oidb_0x1132_rspbody.match_status.get() <= 0) {
                    return;
                }
                dy.this.h(troopCode);
            }
        }
    }

    private final void e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).removeObserver(this.troopFansObserver);
        }
        this.mDialogSafetyReminder = null;
    }

    private final void g(String troopUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        MMKVOptionEntity from = QMMKV.from(peekAppRuntime != null ? peekAppRuntime.getApplicationContext() : null, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(app?.applicationCon\u2026t, QMMKVFile.FILE_COMMON)");
        Set<String> decodeStringSet = from.decodeStringSet("MMKV_KEY_TROOPFANS_CHECK", new HashSet());
        decodeStringSet.add(troopUin);
        from.encodeStringSet("MMKV_KEY_TROOPFANS_CHECK", decodeStringSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final String troopCode) {
        if (this.mDialogSafetyReminder == null) {
            com.tencent.aio.main.businesshelper.b bVar = this.helpParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helpParam");
                bVar = null;
            }
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(bVar.a().c().getContext(), 230).setMessage(R.string.f180083a4).setPositiveButton(R.string.f180073a3, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.dx
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dy.i(dy.this, troopCode, dialogInterface, i3);
                }
            });
            this.mDialogSafetyReminder = positiveButton;
            Intrinsics.checkNotNull(positiveButton);
            positiveButton.setCancelable(false);
            QQCustomDialog qQCustomDialog = this.mDialogSafetyReminder;
            Intrinsics.checkNotNull(qQCustomDialog);
            qQCustomDialog.setCanceledOnTouchOutside(false);
        }
        QQCustomDialog qQCustomDialog2 = this.mDialogSafetyReminder;
        if (qQCustomDialog2 == null || qQCustomDialog2.isShowing()) {
            return;
        }
        qQCustomDialog2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(dy this$0, String troopCode, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopCode, "$troopCode");
        this$0.g(troopCode);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.P;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopFansHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.helpParam = param;
        this.peerUid = param.a().g().r().c().j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((QQAppInterface) peekAppRuntime).addObserver(this.troopFansObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            e();
        }
    }
}
