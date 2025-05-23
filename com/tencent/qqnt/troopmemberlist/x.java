package com.tencent.qqnt.troopmemberlist;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/x;", "Lcom/tencent/qqnt/helper/ITroopMemberInfoUpdateProcessor;", "", "groupCode", "", "a", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "", "d", "", "I", "requestingDBVersion", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", tl.h.F, "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkv", "<init>", "()V", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class x implements ITroopMemberInfoUpdateProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int requestingDBVersion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/x$a;", "", "", "groupCode", "", "a", "version", "", "b", "KEY_TROOP_MEMBER_INFO_DB_VERSION", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.x$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a(@NotNull String groupCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupCode)).intValue();
            }
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP)");
            return fromV2.getInt(groupCode + "KEY_TROOP_MEMBER_INFO_DB_VERSION", 0);
        }

        public final void b(@NotNull String groupCode, int version) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) groupCode, version);
                return;
            }
            Intrinsics.checkNotNullParameter(groupCode, "groupCode");
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP)");
            fromV2.putInt(groupCode + "KEY_TROOP_MEMBER_INFO_DB_VERSION", version);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63421);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MMKVOptionEntityV2 h() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP)");
        return fromV2;
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public boolean a(@NotNull String groupCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupCode)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        int i3 = h().getInt(groupCode + "KEY_TROOP_MEMBER_INFO_DB_VERSION", 0);
        int troopMemberInfoDBVersion = TroopMemberListRepo.INSTANCE.getTroopMemberInfoDBVersion();
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoDBVersionUpdateProcessor", 2, "onLoadData: curDBVersion=" + i3 + ", ntDBVersion=" + troopMemberInfoDBVersion);
        }
        this.requestingDBVersion = troopMemberInfoDBVersion;
        if (i3 >= troopMemberInfoDBVersion) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    @NotNull
    public ITroopMemberInfoUpdateProcessor.Strategy b(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ITroopMemberInfoUpdateProcessor.Strategy) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return ITroopMemberInfoUpdateProcessor.a.b(this, str);
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public boolean c(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return ITroopMemberInfoUpdateProcessor.a.d(this, str);
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void d(@NotNull String groupCode, boolean isSuccess, @NotNull List<? extends TroopMemberInfo> troopMemberList) {
        BusinessHandler businessHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupCode, Boolean.valueOf(isSuccess), troopMemberList);
            return;
        }
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        if (isSuccess) {
            INSTANCE.b(groupCode, this.requestingDBVersion);
            for (TroopMemberInfo troopMemberInfo : troopMemberList) {
                IUixConvertAdapterApi iUixConvertAdapterApi = (IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class);
                String str = troopMemberInfo.memberuin;
                Intrinsics.checkNotNullExpressionValue(str, "info.memberuin");
                String str2 = troopMemberInfo.memberUid;
                Intrinsics.checkNotNullExpressionValue(str2, "info.memberUid");
                iUixConvertAdapterApi.saveUidByUin(str, str2);
            }
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
            boolean isSwitchOn = ((IUnitedConfigManager) api).isSwitchOn("102285", true);
            QLog.d("TroopMemberInfoDBVersionUpdateProcessor", 1, "onUpdateTroopMemberInfo: enableUpdateLevel=" + isSwitchOn);
            AppInterface e16 = bg.e();
            TroopInfoHandler troopInfoHandler = null;
            if (e16 != null) {
                businessHandler = e16.getBusinessHandler(TroopInfoHandler.class.getName());
            } else {
                businessHandler = null;
            }
            if (businessHandler instanceof TroopInfoHandler) {
                troopInfoHandler = (TroopInfoHandler) businessHandler;
            }
            if (isSwitchOn && troopInfoHandler != null) {
                troopInfoHandler.notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, groupCode);
            }
            Object[] objArr = {groupCode, troopMemberList};
            if (troopInfoHandler != null) {
                troopInfoHandler.notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LIST_FIRST_INIT, true, objArr);
            }
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void e(@NotNull String str, boolean z16, boolean z17, @NotNull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
        } else {
            ITroopMemberInfoUpdateProcessor.a.e(this, str, z16, z17, list);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void f(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            ITroopMemberInfoUpdateProcessor.a.a(this, str);
        }
    }

    @Override // com.tencent.qqnt.helper.ITroopMemberInfoUpdateProcessor
    public void g(@NotNull String str, boolean z16, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), str2);
        } else {
            ITroopMemberInfoUpdateProcessor.a.g(this, str, z16, str2);
        }
    }
}
