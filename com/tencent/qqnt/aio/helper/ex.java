package com.tencent.qqnt.aio.helper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001'\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ex;", "Lcom/tencent/aio/main/businesshelper/h;", "", "i", "", "o", "", "troopUin", "curUin", "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "peerUid", "e", "Lcom/tencent/aio/main/businesshelper/b;", "helpParam", "f", "Z", "isTroopOwner", "Lcom/tencent/mobileqq/troop/api/observer/b;", tl.h.F, "Lcom/tencent/mobileqq/troop/api/observer/b;", "getTroopMngObserver", "()Lcom/tencent/mobileqq/troop/api/observer/b;", "setTroopMngObserver", "(Lcom/tencent/mobileqq/troop/api/observer/b;)V", "troopMngObserver", "com/tencent/qqnt/aio/helper/ex$c", "Lcom/tencent/qqnt/aio/helper/ex$c;", "troopPushObserver", "Lmqq/app/AppRuntime;", DomainData.DOMAIN_NAME, "()Lmqq/app/AppRuntime;", "app", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ex implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String peerUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b helpParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isTroopOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.api.observer.b troopMngObserver = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final c troopPushObserver = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/helper/ex$c", "Lcom/tencent/mobileqq/troop/api/observer/f;", "", "troopUin", "", "reason", "Lcom/tencent/mobileqq/troop/api/handler/ITroopPushHandler$PushType;", "pushType", "", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.f {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.f
        public void b(String troopUin, int reason, ITroopPushHandler.PushType pushType) {
            String str = ex.this.peerUid;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUid");
                str = null;
            }
            if (Intrinsics.areEqual(str, troopUin)) {
                ex.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        com.tencent.aio.main.businesshelper.b bVar = this.helpParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helpParam");
            bVar = null;
        }
        bVar.a().e().h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String troopUin, String curUin) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopResignHelper", 2, "clearBAFGrayTipSP troopUin=" + troopUin);
        }
        AppRuntime n3 = n();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(n3 != null ? n3.getApp() : null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%s_%s_%s", Arrays.copyOf(new Object[]{"sp_baf_data_check_flag_members", curUin, troopUin}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        defaultSharedPreferences.edit().putLong(format, 0L).apply();
    }

    private final void k() {
        if (n() instanceof AppInterface) {
            AppRuntime n3 = n();
            Intrinsics.checkNotNull(n3, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) n3).removeObserver(this.troopMngObserver);
            AppRuntime n16 = n();
            Intrinsics.checkNotNull(n16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) n16).removeObserver(this.troopPushObserver);
        }
    }

    private final void m() {
        this.isTroopOwner = o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime n() {
        return com.tencent.mobileqq.troop.utils.bg.f();
    }

    private final boolean o() {
        boolean equals;
        AppRuntime n3 = n();
        Manager manager = n3 != null ? n3.getManager(QQManagerFactory.TROOP_MANAGER) : null;
        TroopManager troopManager = manager instanceof TroopManager ? (TroopManager) manager : null;
        if (troopManager == null) {
            return false;
        }
        String str = this.peerUid;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUid");
            str = null;
        }
        TroopInfo k3 = troopManager.k(str);
        if (k3 == null) {
            return false;
        }
        AppRuntime n16 = n();
        equals = StringsKt__StringsJVMKt.equals(n16 != null ? n16.getCurrentAccountUin() : null, k3.troopowneruin, true);
        return equals;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.M;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopResignHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.helpParam = param;
        this.peerUid = param.a().g().r().c().j();
        if (n() instanceof AppInterface) {
            AppRuntime n3 = n();
            Intrinsics.checkNotNull(n3, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) n3).addObserver(this.troopMngObserver);
            AppRuntime n16 = n();
            Intrinsics.checkNotNull(n16, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) n16).addObserver(this.troopPushObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 3};
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/helper/ex$b", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "troopuin", "", "b", "", "reqtype", "result", "troopUin", "l", "k", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.b {
        b() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void b(String troopuin) {
            Intrinsics.checkNotNullParameter(troopuin, "troopuin");
            String str = ex.this.peerUid;
            com.tencent.aio.main.businesshelper.b bVar = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("peerUid");
                str = null;
            }
            if (Intrinsics.areEqual(str, troopuin)) {
                com.tencent.aio.main.businesshelper.b bVar2 = ex.this.helpParam;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("helpParam");
                } else {
                    bVar = bVar2;
                }
                bVar.a().e().h(new ExternalCommIntent("close_aio", new Bundle()));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int reqtype, int result, String troopUin) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            if (reqtype == 2 || reqtype == 9) {
                com.tencent.aio.main.businesshelper.b bVar = null;
                String str = null;
                if (result != 0) {
                    com.tencent.aio.main.businesshelper.b bVar2 = ex.this.helpParam;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("helpParam");
                    } else {
                        bVar = bVar2;
                    }
                    FragmentActivity activity = bVar.a().c().getActivity();
                    if (activity != null) {
                        QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.f172807ud0), 0).show();
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopResignHelper", 2, "onTroopManagerSuccess, isTroopOwner = " + ex.this.isTroopOwner);
                }
                ex.this.i();
                AppRuntime n3 = ex.this.n();
                if (n3 != null) {
                    ex exVar = ex.this;
                    String currentUin = n3.getCurrentUin();
                    Intrinsics.checkNotNullExpressionValue(currentUin, "it.currentUin");
                    exVar.j(troopUin, currentUin);
                    com.tencent.mobileqq.troop.utils.x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) n3.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
                    String str2 = exVar.peerUid;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("peerUid");
                    } else {
                        str = str2;
                    }
                    troopBatchAddFriendMgr.P(str);
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void k(int reqtype, int result) {
            if (reqtype == 9) {
                QLog.i("TroopResignHelper", 1, "TroopManagerFailed reqtype: " + reqtype + " result: " + result);
                if (ex.this.isTroopOwner) {
                    String qqStr = HardCodeUtil.qqStr(R.string.f172808ud2);
                    if (result == 2013004 || result == 2013005 || result == 2013006) {
                        return;
                    }
                    com.tencent.aio.main.businesshelper.b bVar = ex.this.helpParam;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("helpParam");
                        bVar = null;
                    }
                    FragmentActivity activity = bVar.a().c().getActivity();
                    if (activity != null) {
                        QQToast.makeText(activity, 1, qqStr, 0).show();
                    }
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            m();
        } else {
            if (state != 12) {
                return;
            }
            k();
        }
    }
}
