package com.tencent.qqnt.impl;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.e;
import com.tencent.mobileqq.troop.handler.TroopMemberCardHandler;
import com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopMemberCardApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.a;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.troop.TroopListRepo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0019\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/impl/TroopMemberCardApiImpl;", "Lcom/tencent/qqnt/ITroopMemberCardApi;", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "cardInfo", "", "from", "", "requestTroopMemberInfo", "troopUin", "", "isQiDianPrivateTroop", "isGatherFriend", "", "categoryId", "getGroupName", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Dialog;", "createTroopMoreLoadingDialog", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "allInOne", "checkAndUpdateTroopInfo", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopMemberCardApiImpl implements ITroopMemberCardApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopMemberCardApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/impl/TroopMemberCardApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.impl.TroopMemberCardApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberCardApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ITroopMemberCardApi
    public void checkAndUpdateTroopInfo(@Nullable TroopInfo troopInfo, @Nullable AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopInfo, (Object) allInOne);
            return;
        }
        if (allInOne != null && troopInfo != null && ProfilePAUtils.isFromTroopMemberCard(allInOne.f260789pa) && TextUtils.isEmpty(allInOne.troopUin)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[checkAndUpdateTroopInfo] troopUin:" + troopInfo.troopuin + ", troopCode:" + troopInfo.troopcode);
            }
            allInOne.troopUin = troopInfo.troopcode;
            allInOne.troopCode = troopInfo.troopuin;
        }
    }

    @Override // com.tencent.qqnt.ITroopMemberCardApi
    @NotNull
    public Dialog createTroopMoreLoadingDialog(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Dialog) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, 0, R.layout.gza, 17);
        qQProgressDialog.setHeightParams(-1);
        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.uco));
        qQProgressDialog.setCancelable(true);
        qQProgressDialog.show();
        return qQProgressDialog;
    }

    @Override // com.tencent.qqnt.ITroopMemberCardApi
    @Nullable
    public String getGroupName(int categoryId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, categoryId);
        }
        for (a aVar : ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsCategoryBaseInfo(TAG)) {
            if (aVar.b() == categoryId) {
                return aVar.d();
            }
        }
        return "";
    }

    @Override // com.tencent.qqnt.ITroopMemberCardApi
    public boolean isGatherFriend(@Nullable ProfileCardInfo cardInfo) {
        boolean z16;
        Byte n3;
        AllInOne allInOne;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cardInfo)).booleanValue();
        }
        boolean z17 = true;
        if (cardInfo != null && (allInOne = cardInfo.allInOne) != null && allInOne.f260789pa == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(cardInfo.allInOne.uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, TAG);
        if (friendsSimpleInfoWithUid == null || (n3 = friendsSimpleInfoWithUid.n()) == null || n3.byteValue() != 1) {
            z17 = false;
        }
        return z17;
    }

    @Override // com.tencent.qqnt.ITroopMemberCardApi
    public boolean isQiDianPrivateTroop(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin)).booleanValue();
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
        if (iTroopInfoService == null) {
            return false;
        }
        return iTroopInfoService.isQidianPrivateTroop(troopUin);
    }

    @Override // com.tencent.qqnt.ITroopMemberCardApi
    public void requestTroopMemberInfo(@Nullable AppInterface app, @Nullable ProfileCardInfo cardInfo, @Nullable String from) {
        AllInOne allInOne;
        boolean z16;
        boolean z17;
        ArrayList<String> arrayListOf;
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, app, cardInfo, from);
            return;
        }
        if (app != null) {
            com.tencent.mobileqq.troop.troopmanager.api.a aVar = null;
            if (cardInfo != null) {
                allInOne = cardInfo.allInOne;
            } else {
                allInOne = null;
            }
            if (allInOne != null && cardInfo.isTroopMemberCard) {
                AllInOne allInOne2 = cardInfo.allInOne;
                String troopUin = allInOne2.troopCode;
                String uin = allInOne2.uin;
                if (troopUin != null && troopUin.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (uin != null && uin.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        if (!NetworkUtil.isNetworkAvailable()) {
                            QLog.i(TAG, 1, "[requestTroopMemberInfo] from:" + from + ", network not available");
                            return;
                        }
                        try {
                            Intrinsics.checkNotNullExpressionValue(uin, "uin");
                            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uin);
                            TroopInfo troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(troopUin);
                            checkAndUpdateTroopInfo(troopInfoFromCache, cardInfo.allInOne);
                            Object businessHandler = app.getBusinessHandler(TroopMemberCardHandler.class.getName());
                            if (businessHandler instanceof e) {
                                eVar = (e) businessHandler;
                            } else {
                                eVar = null;
                            }
                            if (troopInfoFromCache != null && eVar != null) {
                                eVar.i1(troopUin, troopInfoFromCache.troopcode, arrayListOf);
                                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                                eVar.f2(Long.parseLong(troopUin), Long.parseLong(uin));
                                if (!isQiDianPrivateTroop(troopUin)) {
                                    QLog.d(TAG, 2, "[requestTroopMemberInfo] from:" + from + ", requestGlobalTroopLevel");
                                    Object businessHandler2 = app.getBusinessHandler(TroopManagerBizHandler.class.getName());
                                    if (businessHandler2 instanceof com.tencent.mobileqq.troop.troopmanager.api.a) {
                                        aVar = (com.tencent.mobileqq.troop.troopmanager.api.a) businessHandler2;
                                    }
                                    if (aVar != null) {
                                        aVar.R(Long.parseLong(uin));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            QLog.d(TAG, 1, "[requestTroopMemberInfo] from:" + from + ", troopInfo or memberCardHandler is null");
                            return;
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "[requestTroopMemberInfo] from:" + from + ", " + e16);
                            return;
                        }
                    }
                }
                QLog.i(TAG, 1, "[requestTroopMemberInfo] from:" + from + ", troopUin or uin is empty");
                return;
            }
        }
        QLog.i(TAG, 1, "[requestTroopMemberInfo] from:" + from + ", app or allInOne is null");
    }
}
