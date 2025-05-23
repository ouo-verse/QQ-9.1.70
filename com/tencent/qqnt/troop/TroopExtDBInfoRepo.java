package com.tencent.qqnt.troop;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.inner.ITroopInfoInnerService;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.MemberLevelName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bm\u0010!J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JY\u0010\u0014\u001a\u00020\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b21\b\u0002\u0010\u0013\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\u0004\u0018\u0001`\u0012H\u0002J.\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002J?\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0011H\u0000\u00a2\u0006\u0004\b \u0010!J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b$\u0010%J\u001d\u0010+\u001a\u00020\u00112\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u0006H\u0000\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\tJ(\u00100\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020'2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020'2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u00102\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u00101\u001a\u00020-2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u00104\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u00106\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u00105\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u00108\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u00107\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010:\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\t2\u0006\u00109\u001a\u00020'2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010<\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020'2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010>\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020-2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010@\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010?\u001a\u00020-2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010B\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010A\u001a\u00020-2\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010D\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0016J*\u0010H\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020'H\u0016J\u001a\u0010J\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010I\u001a\u00020\tH\u0016J\u001a\u0010L\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010K\u001a\u00020\tH\u0016J\u001a\u0010N\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010M\u001a\u00020\tH\u0016J\"\u0010Q\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010O\u001a\u00020-2\u0006\u0010P\u001a\u00020-H\u0016J\u001a\u0010S\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010R\u001a\u00020-H\u0016J\"\u0010V\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020-H\u0016J$\u0010Z\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\b\u0010W\u001a\u0004\u0018\u00010\t2\u0006\u0010Y\u001a\u00020XH\u0016J\u001a\u0010\\\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010[\u001a\u00020'H\u0016J\u001a\u0010^\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020-H\u0016J-\u0010a\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\b\u0010_\u001a\u0004\u0018\u00010X2\b\u0010`\u001a\u0004\u0018\u00010XH\u0016\u00a2\u0006\u0004\ba\u0010bJ\u001a\u0010e\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u0006\u0010d\u001a\u00020cH\u0016R\u0014\u0010f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020-8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bh\u0010iR \u0010k\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010l\u00a8\u0006n"}, d2 = {"Lcom/tencent/qqnt/troop/TroopExtDBInfoRepo;", "Lcom/tencent/qqnt/troop/ITroopExtInfoDBApi;", "", "troopUin", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getTroopInfo", "", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "infoList", "", "from", "Lcom/tencent/qqnt/troop/a;", "checkUpdateCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "updatedInfoList", "", "Lcom/tencent/qqnt/troop/UpdateExtInfoFinishedCallback;", "updateFinishedCallback", "updateExtInfo", "Lcom/tencent/mobileqq/persistence/EntityManager;", "em", "troopUinList", "queryTroopExtInfo", "querySingleTroopExtInfo", "queryTroopExtInfoForSubList", "selection", "", "selectionArgs", "query", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "preloadTroopExtInfo$qqtroop_impl_release", "()V", "preloadTroopExtInfo", "info", "configTroopExtInfo$qqtroop_impl_release", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "configTroopExtInfo", "", "list", "removeTroopExtInfo$qqtroop_impl_release", "(Ljava/util/List;)V", "removeTroopExtInfo", "getTroopExtInfoSync", "", "fileVideoIsWhite", "fileVideoReqInterval", "updateTroopFileVideo", "picId", "updateAvatarId", "headerUinNew", "updateHeaderUinNew", "headerUinOld", "updateHeaderUinOld", "picListJson", "updatePicListJson", "oldMemberNickIconSeq", "updateOldMemberNickIconSeq", "newTroopNameTimeStamp", "updateNewTroopNameTimeStamp", "type", "updateTroopType", "specialClass", "updateSpecialClass", "memberNumClient", "updateMemberNumClient", "memberList", "updateTroopSettingMemberList", "lastInsertBAFTipTime", "insertBAFTipCount", "lastBAFTipMsgUniSeq", "updateBatchAddFriendData", "dailyNewMemberUins", "updateDailyNewMemberUins", "announcement", "updateAnnouncement", "uins", "updateAtOrReplyMeUins", "showGameSwitchStatus", "gameSwitchStatus", "updateGameSwitchStatus", "grayFlag", "updateTroopHonorGrayFlag", "feedsId", "repeatType", "updateTroopNotificationData", "honorList", "", "honorRichFlag", "updateMyTroopHonor", "honorUpdateTime", "updateHonorUpdateTime", "guildSwitchOpen", "updateGuildSwitchOpen", "rankUserFlag", "newRankUserFlag", "updateTroopLevelSwitch", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Byte;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "groupMemberExtList", "updateTroopLevelInfo", "TAG", "Ljava/lang/String;", "QUERY_PER_MAX", "I", "Ljava/util/concurrent/ConcurrentHashMap;", "extInfoCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopExtDBInfoRepo implements ITroopExtInfoDBApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final TroopExtDBInfoRepo INSTANCE;
    private static final int QUERY_PER_MAX = 50;

    @NotNull
    private static final String TAG = "TroopExtDBInfoRepo";

    @NotNull
    private static final ConcurrentHashMap<String, TroopExtDBInfo> extInfoCacheMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$a", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            int i3 = dbInfo.avatarId;
            int i16 = updateInfo.avatarId;
            if (i3 != i16) {
                dbInfo.avatarId = i16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$b", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            if (!Intrinsics.areEqual(dbInfo.headerUinsNew, updateInfo.headerUinsNew)) {
                dbInfo.headerUinsNew = updateInfo.headerUinsNew;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$c", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            if (!Intrinsics.areEqual(dbInfo.headerUinsOld, updateInfo.headerUinsOld)) {
                dbInfo.headerUinsOld = updateInfo.headerUinsOld;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$d", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            int i3 = dbInfo.memberNumClient;
            int i16 = updateInfo.memberNumClient;
            if (i3 != i16) {
                dbInfo.memberNumClient = i16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$e", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            long j3 = dbInfo.newTroopNameTimeStamp;
            long j16 = updateInfo.newTroopNameTimeStamp;
            if (j3 != j16) {
                dbInfo.newTroopNameTimeStamp = j16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$f", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            long j3 = dbInfo.oldMemberNickIconSeq;
            long j16 = updateInfo.oldMemberNickIconSeq;
            if (j3 != j16) {
                dbInfo.oldMemberNickIconSeq = j16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$g", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class g implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            if (!Intrinsics.areEqual(dbInfo.picListJson, updateInfo.picListJson)) {
                dbInfo.picListJson = updateInfo.picListJson;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$h", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class h implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            int i3 = dbInfo.specialClass;
            int i16 = updateInfo.specialClass;
            if (i3 != i16) {
                dbInfo.specialClass = i16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$i", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class i implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            int i3 = dbInfo.fileVideoIsWhite;
            int i16 = updateInfo.fileVideoIsWhite;
            if (i3 != i16) {
                dbInfo.fileVideoIsWhite = i16;
                z16 = true;
            } else {
                z16 = false;
            }
            long j3 = dbInfo.fileVideoReqInterval;
            long j16 = updateInfo.fileVideoReqInterval;
            if (j3 != j16) {
                dbInfo.fileVideoReqInterval = j16;
                return true;
            }
            return z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troop/TroopExtDBInfoRepo$j", "Lcom/tencent/qqnt/troop/a;", "Lcom/tencent/mobileqq/data/troop/TroopExtDBInfo;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class j implements com.tencent.qqnt.troop.a {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troop.a
        public boolean a(@NotNull TroopExtDBInfo dbInfo, @NotNull TroopExtDBInfo updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            int i3 = dbInfo.troopType;
            int i16 = updateInfo.troopType;
            if (i3 != i16) {
                dbInfo.troopType = i16;
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new TroopExtDBInfoRepo();
            extInfoCacheMap = new ConcurrentHashMap<>();
        }
    }

    TroopExtDBInfoRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final TroopInfo getTroopInfo(Object troopUin) {
        String str;
        if (troopUin instanceof Long) {
            str = String.valueOf(((Number) troopUin).longValue());
        } else if (troopUin instanceof String) {
            str = (String) troopUin;
        } else {
            return null;
        }
        return ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void preloadTroopExtInfo$lambda$2(long j3) {
        Iterable<TroopExtDBInfo> arrayList;
        try {
            EntityManager b16 = com.tencent.qqnt.e.b();
            if (b16 == null) {
                QLog.e(TAG, 1, "[preloadTroopExtInfo] em is null");
                return;
            }
            List query$default = query$default(INSTANCE, b16, null, null, 6, null);
            if (query$default == null || arrayList == null) {
                arrayList = new ArrayList();
            }
            for (TroopExtDBInfo troopExtDBInfo : arrayList) {
                String troopUin = troopExtDBInfo.troopUin;
                if (troopUin != null) {
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                    extInfoCacheMap.put(troopUin, troopExtDBInfo);
                }
            }
            ITroopInfoInnerService e16 = com.tencent.qqnt.f.f356721a.e();
            if (e16 != null) {
                e16.onLoadTroopExtInfoFinish();
            }
            QLog.i(TAG, 1, "[preloadTroopExtInfo] timeCost:" + com.tencent.qqnt.e.n(j3));
        } catch (Exception e17) {
            QLog.e(TAG, 1, "[preloadTroopExtInfo] exception", e17);
        }
    }

    private final List<TroopExtDBInfo> query(EntityManager em5, String selection, String[] selectionArgs) {
        List query = em5.query(TroopExtDBInfo.class, false, selection, selectionArgs, null, null, null, null);
        if (!(query instanceof List)) {
            return null;
        }
        return query;
    }

    static /* synthetic */ List query$default(TroopExtDBInfoRepo troopExtDBInfoRepo, EntityManager entityManager, String str, String[] strArr, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            strArr = null;
        }
        return troopExtDBInfoRepo.query(entityManager, str, strArr);
    }

    private final TroopExtDBInfo querySingleTroopExtInfo(EntityManager em5, String troopUin, String from) {
        boolean z16;
        Object firstOrNull;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[querySingleTroopExtInfo] from:" + from);
        }
        List<TroopExtDBInfo> query = query(em5, "troopUin=?", new String[]{troopUin});
        if (query != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) query);
            return (TroopExtDBInfo) firstOrNull;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<TroopExtDBInfo> queryTroopExtInfo(EntityManager em5, List<String> troopUinList, String from) {
        int coerceAtMost;
        Collection arrayList;
        Object first;
        ArrayList arrayList2 = new ArrayList();
        if (troopUinList.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) troopUinList);
            TroopExtDBInfo querySingleTroopExtInfo = querySingleTroopExtInfo(em5, (String) first, from);
            if (querySingleTroopExtInfo != null) {
                arrayList2.add(querySingleTroopExtInfo);
            }
            return arrayList2;
        }
        int i3 = 0;
        while (i3 < troopUinList.size()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 + 50, troopUinList.size());
            List<TroopExtDBInfo> queryTroopExtInfoForSubList = queryTroopExtInfoForSubList(em5, troopUinList.subList(i3, coerceAtMost));
            if (queryTroopExtInfoForSubList == null || arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList2.addAll(arrayList);
            i3 = coerceAtMost;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[queryTroopExtInfo] from:" + from + ", size:" + troopUinList.size() + ", resSize:" + arrayList2.size());
        }
        return arrayList2;
    }

    private final List<TroopExtDBInfo> queryTroopExtInfoForSubList(EntityManager em5, List<String> troopUinList) {
        String join = TextUtils.join(" OR ", Collections.nCopies(troopUinList.size(), "troopUin=?"));
        int size = troopUinList.size();
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = "";
        }
        int size2 = troopUinList.size();
        for (int i16 = 0; i16 < size2; i16++) {
            strArr[i16] = troopUinList.get(i16);
        }
        return query(em5, join, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeTroopExtInfo$lambda$7(List deleteList) {
        Intrinsics.checkNotNullParameter(deleteList, "$deleteList");
        EntityManager b16 = com.tencent.qqnt.e.b();
        Iterator it = deleteList.iterator();
        while (it.hasNext()) {
            TroopExtDBInfo troopExtDBInfo = (TroopExtDBInfo) it.next();
            if (b16 != null) {
                b16.remove(troopExtDBInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateAnnouncement$lambda$25$lambda$24(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        if (!Intrinsics.areEqual(dbInfo.strLastAnnouncement, updateInfo.strLastAnnouncement)) {
            dbInfo.strLastAnnouncement = updateInfo.strLastAnnouncement;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateAtOrReplyMeUins$lambda$27$lambda$26(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        if (!Intrinsics.areEqual(dbInfo.atOrReplyMeUins, updateInfo.atOrReplyMeUins)) {
            dbInfo.atOrReplyMeUins = updateInfo.atOrReplyMeUins;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateBatchAddFriendData$lambda$21$lambda$20(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        long j3 = dbInfo.lastInsertBAFTipTime;
        long j16 = updateInfo.lastInsertBAFTipTime;
        if (j3 != j16) {
            dbInfo.lastInsertBAFTipTime = j16;
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = dbInfo.insertBAFTipCount;
        int i16 = updateInfo.insertBAFTipCount;
        if (i3 != i16) {
            dbInfo.insertBAFTipCount = i16;
            z16 = true;
        }
        long j17 = dbInfo.lastBAFTipMsgUniSeq;
        long j18 = updateInfo.lastBAFTipMsgUniSeq;
        if (j17 != j18) {
            dbInfo.lastBAFTipMsgUniSeq = j18;
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateDailyNewMemberUins$lambda$23$lambda$22(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        if (!Intrinsics.areEqual(dbInfo.dailyNewMemberUins, updateInfo.dailyNewMemberUins)) {
            dbInfo.dailyNewMemberUins = updateInfo.dailyNewMemberUins;
            return true;
        }
        return false;
    }

    private final void updateExtInfo(final List<? extends TroopExtDBInfo> infoList, final String from, final com.tencent.qqnt.troop.a checkUpdateCallback, final Function1<? super List<? extends TroopExtDBInfo>, Unit> updateFinishedCallback) {
        com.tencent.qqnt.e.f(false, new Runnable() { // from class: com.tencent.qqnt.troop.y
            @Override // java.lang.Runnable
            public final void run() {
                TroopExtDBInfoRepo.updateExtInfo$lambda$49(from, infoList, checkUpdateCallback, updateFinishedCallback);
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateExtInfo$default(TroopExtDBInfoRepo troopExtDBInfoRepo, List list, String str, com.tencent.qqnt.troop.a aVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        troopExtDBInfoRepo.updateExtInfo(list, str, aVar, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateExtInfo$lambda$49(String from, List infoList, com.tencent.qqnt.troop.a checkUpdateCallback, Function1 function1) {
        List filterNotNull;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Object firstOrNull;
        String str;
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(infoList, "$infoList");
        Intrinsics.checkNotNullParameter(checkUpdateCallback, "$checkUpdateCallback");
        if (QLog.isDebugVersion()) {
            int size = infoList.size();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) infoList);
            TroopExtDBInfo troopExtDBInfo = (TroopExtDBInfo) firstOrNull;
            if (troopExtDBInfo != null) {
                str = troopExtDBInfo.troopUin;
            } else {
                str = null;
            }
            QLog.d(TAG, 4, "[updateExtInfo] from:" + from + ", size:" + size + ", troopUin:" + str);
        }
        try {
            EntityManager b16 = com.tencent.qqnt.e.b();
            if (b16 == null) {
                QLog.e(TAG, 1, "[updateExtInfo] em is null");
                return;
            }
            StringBuilder sb5 = new StringBuilder(1024);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = infoList.iterator();
            while (it.hasNext()) {
                String str2 = ((TroopExtDBInfo) it.next()).troopUin;
                if (str2 != null) {
                    arrayList3.add(str2);
                }
            }
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(INSTANCE.queryTroopExtInfo(b16, arrayList3, from));
            List list = filterNotNull;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list) {
                linkedHashMap.put(((TroopExtDBInfo) obj).troopUin, obj);
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it5 = infoList.iterator();
            while (it5.hasNext()) {
                TroopExtDBInfo troopExtDBInfo2 = (TroopExtDBInfo) it5.next();
                TroopExtDBInfo troopExtDBInfo3 = (TroopExtDBInfo) linkedHashMap.get(troopExtDBInfo2.troopUin);
                if (troopExtDBInfo3 == null) {
                    arrayList.add(new PersistTransaction(troopExtDBInfo2));
                    arrayList2.add(troopExtDBInfo2);
                    sb5.append("|");
                    sb5.append(troopExtDBInfo2.troopUin);
                    arrayList4.add(troopExtDBInfo2);
                } else if (checkUpdateCallback.a(troopExtDBInfo3, troopExtDBInfo2)) {
                    arrayList2.add(troopExtDBInfo3);
                    arrayList.add(new UpdateTransaction(troopExtDBInfo3));
                    arrayList4.add(troopExtDBInfo3);
                    if (QLog.isDebugVersion()) {
                        QLog.d(TAG, 4, "[updateExtInfo] from:" + from + ", needUpdate");
                    }
                } else if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "[updateExtInfo] extInfo is null or needUpdate() is false, extInfo:" + troopExtDBInfo3);
                }
            }
            if (!arrayList.isEmpty()) {
                b16.doMultiDBOperateByTransaction(arrayList);
            }
            if (function1 != null) {
                function1.invoke(arrayList2);
            }
            if (QLog.isDebugVersion() && sb5.length() > 0) {
                QLog.d(TAG, 1, "[updateExtInfo] from:" + from + ",  notInDb:" + ((Object) sb5));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[updateExtInfo] from:" + from + " exception", e16);
            if (function1 != null) {
                function1.invoke(new ArrayList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateGameSwitchStatus$lambda$29$lambda$28(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        int i3 = dbInfo.showGameSwitchStatus;
        int i16 = updateInfo.showGameSwitchStatus;
        if (i3 != i16) {
            dbInfo.showGameSwitchStatus = i16;
            z16 = true;
        } else {
            z16 = false;
        }
        int i17 = dbInfo.gameSwitchStatus;
        int i18 = updateInfo.gameSwitchStatus;
        if (i17 != i18) {
            dbInfo.gameSwitchStatus = i18;
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateGuildSwitchOpen$lambda$39$lambda$38(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        int i3 = dbInfo.troopGuildSwitchOpen;
        int i16 = updateInfo.troopGuildSwitchOpen;
        if (i3 != i16) {
            dbInfo.troopGuildSwitchOpen = i16;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateHonorUpdateTime$lambda$37$lambda$36(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        long j3 = dbInfo.lastMsgUpdateMyHonorRichTime;
        long j16 = updateInfo.lastMsgUpdateMyHonorRichTime;
        if (j3 != j16) {
            dbInfo.lastMsgUpdateMyHonorRichTime = j16;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateMyTroopHonor$lambda$35$lambda$34(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        if (!Intrinsics.areEqual(dbInfo.myHonorList, updateInfo.myHonorList)) {
            dbInfo.myHonorList = updateInfo.myHonorList;
            z16 = true;
        } else {
            z16 = false;
        }
        byte b16 = dbInfo.myHonorRichFlag;
        byte b17 = updateInfo.myHonorRichFlag;
        if (b16 != b17) {
            dbInfo.myHonorRichFlag = b17;
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateTroopHonorGrayFlag$lambda$31$lambda$30(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        int i3 = dbInfo.troopHonorGrayFlag;
        int i16 = updateInfo.troopHonorGrayFlag;
        if (i3 != i16) {
            dbInfo.troopHonorGrayFlag = i16;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateTroopLevelInfo$lambda$46$lambda$45(TroopInfo info, TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        if (!Intrinsics.areEqual(dbInfo.newLevelMapStr, updateInfo.newLevelMapStr)) {
            dbInfo.newLevelMapStr = updateInfo.newLevelMapStr;
            z16 = true;
        } else {
            z16 = false;
        }
        byte b16 = dbInfo.cNewGroupRankUserFlag;
        byte b17 = updateInfo.cNewGroupRankUserFlag;
        if (b16 != b17) {
            dbInfo.cNewGroupRankUserFlag = b17;
            z16 = true;
        }
        info.extDBInfo.hadInitLevelInfo = 1;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateTroopLevelSwitch$lambda$43$lambda$42(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        byte b16 = dbInfo.cGroupRankUserFlag;
        byte b17 = updateInfo.cGroupRankUserFlag;
        if (b16 != b17) {
            dbInfo.cGroupRankUserFlag = b17;
            z16 = true;
        } else {
            z16 = false;
        }
        byte b18 = dbInfo.cNewGroupRankUserFlag;
        byte b19 = updateInfo.cNewGroupRankUserFlag;
        if (b18 != b19) {
            dbInfo.cNewGroupRankUserFlag = b19;
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateTroopNotificationData$lambda$33$lambda$32(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        if (!Intrinsics.areEqual(dbInfo.feedsId, updateInfo.feedsId)) {
            dbInfo.feedsId = updateInfo.feedsId;
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = dbInfo.troopRepeatType;
        int i16 = updateInfo.troopRepeatType;
        if (i3 != i16) {
            dbInfo.troopRepeatType = i16;
            return true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateTroopSettingMemberList$lambda$19$lambda$18(TroopExtDBInfo dbInfo, TroopExtDBInfo updateInfo) {
        Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
        Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
        if (!Intrinsics.areEqual(dbInfo.troopSettingMemberList, updateInfo.troopSettingMemberList)) {
            dbInfo.troopSettingMemberList = updateInfo.troopSettingMemberList;
            return true;
        }
        return false;
    }

    public final void configTroopExtInfo$qqtroop_impl_release(@NotNull TroopInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        TroopExtDBInfo troopExtDBInfo = extInfoCacheMap.get(info.getTroopUin());
        if (troopExtDBInfo != null) {
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "[configTroopExtInfo] troopUin:" + info.getTroopUin() + ", extInfo:" + troopExtDBInfo);
            }
            info.extDBInfo = troopExtDBInfo;
            info.onLoadExtInfoFromDB();
        }
    }

    @Nullable
    public final TroopExtDBInfo getTroopExtInfoSync(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopExtDBInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin);
        }
        try {
            EntityManager b16 = com.tencent.qqnt.e.b();
            if (b16 == null) {
                QLog.e(TAG, 1, "[getTroopExtInfoSync] em is null");
                return null;
            }
            return querySingleTroopExtInfo(b16, troopUin, "getTroopExtInfoSync");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getTroopExtInfoSync: ", e16);
            return null;
        }
    }

    public final void preloadTroopExtInfo$qqtroop_impl_release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            com.tencent.qqnt.e.f(false, new Runnable() { // from class: com.tencent.qqnt.troop.z
                @Override // java.lang.Runnable
                public final void run() {
                    TroopExtDBInfoRepo.preloadTroopExtInfo$lambda$2(currentTimeMillis);
                }
            }, 1, null);
        }
    }

    public final void removeTroopExtInfo$qqtroop_impl_release(@NotNull List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            TroopExtDBInfo extInfo = extInfoCacheMap.remove(String.valueOf(((Number) it.next()).longValue()));
            if (extInfo != null) {
                Intrinsics.checkNotNullExpressionValue(extInfo, "extInfo");
                arrayList.add(extInfo);
            }
        }
        com.tencent.qqnt.e.f(false, new Runnable() { // from class: com.tencent.qqnt.troop.q
            @Override // java.lang.Runnable
            public final void run() {
                TroopExtDBInfoRepo.removeTroopExtInfo$lambda$7(arrayList);
            }
        }, 1, null);
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateAnnouncement(@Nullable String troopUin, @NotNull String announcement) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) troopUin, (Object) announcement);
            return;
        }
        Intrinsics.checkNotNullParameter(announcement, "announcement");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.strLastAnnouncement = announcement;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateAnnouncement", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.aa
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateAnnouncement$lambda$25$lambda$24;
                    updateAnnouncement$lambda$25$lambda$24 = TroopExtDBInfoRepo.updateAnnouncement$lambda$25$lambda$24(troopExtDBInfo2, troopExtDBInfo3);
                    return updateAnnouncement$lambda$25$lambda$24;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateAtOrReplyMeUins(@Nullable String troopUin, @NotNull String uins) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) troopUin, (Object) uins);
            return;
        }
        Intrinsics.checkNotNullParameter(uins, "uins");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.atOrReplyMeUins = uins;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateAtOrReplyMeUins", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.p
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateAtOrReplyMeUins$lambda$27$lambda$26;
                    updateAtOrReplyMeUins$lambda$27$lambda$26 = TroopExtDBInfoRepo.updateAtOrReplyMeUins$lambda$27$lambda$26(troopExtDBInfo2, troopExtDBInfo3);
                    return updateAtOrReplyMeUins$lambda$27$lambda$26;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateAvatarId(@Nullable String troopUin, int picId, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, Integer.valueOf(picId), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.avatarId = picId;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-avatarId", new a(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateBatchAddFriendData(@Nullable String troopUin, long lastInsertBAFTipTime, int insertBAFTipCount, long lastBAFTipMsgUniSeq) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, troopUin, Long.valueOf(lastInsertBAFTipTime), Integer.valueOf(insertBAFTipCount), Long.valueOf(lastBAFTipMsgUniSeq));
            return;
        }
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.lastInsertBAFTipTime = lastInsertBAFTipTime;
            troopExtDBInfo.insertBAFTipCount = insertBAFTipCount;
            troopExtDBInfo.lastBAFTipMsgUniSeq = lastBAFTipMsgUniSeq;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateBatchAddFriendData", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.t
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateBatchAddFriendData$lambda$21$lambda$20;
                    updateBatchAddFriendData$lambda$21$lambda$20 = TroopExtDBInfoRepo.updateBatchAddFriendData$lambda$21$lambda$20(troopExtDBInfo2, troopExtDBInfo3);
                    return updateBatchAddFriendData$lambda$21$lambda$20;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateDailyNewMemberUins(@Nullable String troopUin, @NotNull String dailyNewMemberUins) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) troopUin, (Object) dailyNewMemberUins);
            return;
        }
        Intrinsics.checkNotNullParameter(dailyNewMemberUins, "dailyNewMemberUins");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.dailyNewMemberUins = dailyNewMemberUins;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateDailyNewMemberUins", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.r
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateDailyNewMemberUins$lambda$23$lambda$22;
                    updateDailyNewMemberUins$lambda$23$lambda$22 = TroopExtDBInfoRepo.updateDailyNewMemberUins$lambda$23$lambda$22(troopExtDBInfo2, troopExtDBInfo3);
                    return updateDailyNewMemberUins$lambda$23$lambda$22;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateGameSwitchStatus(@Nullable String troopUin, int showGameSwitchStatus, int gameSwitchStatus) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, troopUin, Integer.valueOf(showGameSwitchStatus), Integer.valueOf(gameSwitchStatus));
            return;
        }
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.showGameSwitchStatus = showGameSwitchStatus;
            troopExtDBInfo.gameSwitchStatus = gameSwitchStatus;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateGameSwitchStatus", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.x
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateGameSwitchStatus$lambda$29$lambda$28;
                    updateGameSwitchStatus$lambda$29$lambda$28 = TroopExtDBInfoRepo.updateGameSwitchStatus$lambda$29$lambda$28(troopExtDBInfo2, troopExtDBInfo3);
                    return updateGameSwitchStatus$lambda$29$lambda$28;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateGuildSwitchOpen(@Nullable String troopUin, int guildSwitchOpen) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) troopUin, guildSwitchOpen);
            return;
        }
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.troopGuildSwitchOpen = guildSwitchOpen;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "guildSwitch", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.o
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateGuildSwitchOpen$lambda$39$lambda$38;
                    updateGuildSwitchOpen$lambda$39$lambda$38 = TroopExtDBInfoRepo.updateGuildSwitchOpen$lambda$39$lambda$38(troopExtDBInfo2, troopExtDBInfo3);
                    return updateGuildSwitchOpen$lambda$39$lambda$38;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateHeaderUinNew(@Nullable String troopUin, @NotNull String headerUinNew, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, headerUinNew, from);
            return;
        }
        Intrinsics.checkNotNullParameter(headerUinNew, "headerUinNew");
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            com.tencent.qqnt.troop.inner.b.f362726a.e(troopUin, troopInfo.mMemberNumSeq);
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.headerUinsNew = headerUinNew;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-headerUinNew", new b(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateHeaderUinOld(@Nullable String troopUin, @NotNull String headerUinOld, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, headerUinOld, from);
            return;
        }
        Intrinsics.checkNotNullParameter(headerUinOld, "headerUinOld");
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.headerUinsOld = headerUinOld;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-headerUinOld", new c(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateHonorUpdateTime(@Nullable String troopUin, long honorUpdateTime) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, troopUin, Long.valueOf(honorUpdateTime));
            return;
        }
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.lastMsgUpdateMyHonorRichTime = honorUpdateTime;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "honorUpdateTime", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.n
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateHonorUpdateTime$lambda$37$lambda$36;
                    updateHonorUpdateTime$lambda$37$lambda$36 = TroopExtDBInfoRepo.updateHonorUpdateTime$lambda$37$lambda$36(troopExtDBInfo2, troopExtDBInfo3);
                    return updateHonorUpdateTime$lambda$37$lambda$36;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateMemberNumClient(@Nullable String troopUin, int memberNumClient, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, Integer.valueOf(memberNumClient), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            troopInfo.setMemberNumClient(memberNumClient);
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopInfo.extDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-MemberNumClient", new d(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateMyTroopHonor(@Nullable String troopUin, @Nullable String honorList, byte honorRichFlag) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, honorList, Byte.valueOf(honorRichFlag));
            return;
        }
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.myHonorList = honorList;
            troopExtDBInfo.myHonorRichFlag = honorRichFlag;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateMyTroopHonor", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.m
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateMyTroopHonor$lambda$35$lambda$34;
                    updateMyTroopHonor$lambda$35$lambda$34 = TroopExtDBInfoRepo.updateMyTroopHonor$lambda$35$lambda$34(troopExtDBInfo2, troopExtDBInfo3);
                    return updateMyTroopHonor$lambda$35$lambda$34;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateNewTroopNameTimeStamp(@Nullable String troopUin, long newTroopNameTimeStamp, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, troopUin, Long.valueOf(newTroopNameTimeStamp), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.newTroopNameTimeStamp = newTroopNameTimeStamp;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-newTroopNameTimeStamp", new e(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateOldMemberNickIconSeq(@NotNull String troopUin, long oldMemberNickIconSeq, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, troopUin, Long.valueOf(oldMemberNickIconSeq), from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.oldMemberNickIconSeq = oldMemberNickIconSeq;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-updateOldMemberNickIconSeq", new f(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updatePicListJson(@Nullable String troopUin, @NotNull String picListJson, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, picListJson, from);
            return;
        }
        Intrinsics.checkNotNullParameter(picListJson, "picListJson");
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.picListJson = picListJson;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-picListJson", new g(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateSpecialClass(@Nullable String troopUin, int specialClass, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopUin, Integer.valueOf(specialClass), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.specialClass = specialClass;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-specialClass", new h(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopFileVideo(long troopUin, int fileVideoIsWhite, long fileVideoReqInterval, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(troopUin), Integer.valueOf(fileVideoIsWhite), Long.valueOf(fileVideoReqInterval), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(Long.valueOf(troopUin));
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.fileVideoIsWhite = fileVideoIsWhite;
            troopExtDBInfo.fileVideoReqInterval = fileVideoReqInterval;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-fileVideo", new i(), null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopHonorGrayFlag(@Nullable String troopUin, int grayFlag) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) troopUin, grayFlag);
            return;
        }
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.troopHonorGrayFlag = grayFlag;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateTroopHonorGrayFlag", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.w
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateTroopHonorGrayFlag$lambda$31$lambda$30;
                    updateTroopHonorGrayFlag$lambda$31$lambda$30 = TroopExtDBInfoRepo.updateTroopHonorGrayFlag$lambda$31$lambda$30(troopExtDBInfo2, troopExtDBInfo3);
                    return updateTroopHonorGrayFlag$lambda$31$lambda$30;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopLevelInfo(@Nullable String troopUin, @NotNull GroupMemberExtListResult groupMemberExtList) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) troopUin, (Object) groupMemberExtList);
            return;
        }
        Intrinsics.checkNotNullParameter(groupMemberExtList, "groupMemberExtList");
        final TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            com.tencent.mobileqq.troop.util.b bVar = com.tencent.mobileqq.troop.util.b.f301848a;
            ArrayList<MemberLevelName> arrayList = groupMemberExtList.msgLevelNameNew;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.msgLevelNameNew");
            troopExtDBInfo.newLevelMapStr = bVar.a(arrayList);
            TroopExtDBInfo troopExtDBInfo2 = troopInfo.extDBInfo;
            troopExtDBInfo2.cNewGroupRankUserFlag = (byte) groupMemberExtList.userShowFlagNew;
            troopExtDBInfo2.hadInitLevelInfo = 1;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo2);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateTroopLevelMap", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.l
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo3, TroopExtDBInfo troopExtDBInfo4) {
                    boolean updateTroopLevelInfo$lambda$46$lambda$45;
                    updateTroopLevelInfo$lambda$46$lambda$45 = TroopExtDBInfoRepo.updateTroopLevelInfo$lambda$46$lambda$45(TroopInfo.this, troopExtDBInfo3, troopExtDBInfo4);
                    return updateTroopLevelInfo$lambda$46$lambda$45;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopLevelSwitch(@Nullable String troopUin, @Nullable Byte rankUserFlag, @Nullable Byte newRankUserFlag) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, troopUin, rankUserFlag, newRankUserFlag);
            return;
        }
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            if (rankUserFlag != null) {
                troopInfo.extDBInfo.cGroupRankUserFlag = rankUserFlag.byteValue();
            }
            if (newRankUserFlag != null) {
                troopInfo.extDBInfo.cNewGroupRankUserFlag = newRankUserFlag.byteValue();
            }
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopInfo.extDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateTroopLevelMap", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.u
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo, TroopExtDBInfo troopExtDBInfo2) {
                    boolean updateTroopLevelSwitch$lambda$43$lambda$42;
                    updateTroopLevelSwitch$lambda$43$lambda$42 = TroopExtDBInfoRepo.updateTroopLevelSwitch$lambda$43$lambda$42(troopExtDBInfo, troopExtDBInfo2);
                    return updateTroopLevelSwitch$lambda$43$lambda$42;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopNotificationData(@Nullable String troopUin, @NotNull String feedsId, int repeatType) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, troopUin, feedsId, Integer.valueOf(repeatType));
            return;
        }
        Intrinsics.checkNotNullParameter(feedsId, "feedsId");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.feedsId = feedsId;
            troopExtDBInfo.troopRepeatType = repeatType;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateTroopNotificationData", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.s
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateTroopNotificationData$lambda$33$lambda$32;
                    updateTroopNotificationData$lambda$33$lambda$32 = TroopExtDBInfoRepo.updateTroopNotificationData$lambda$33$lambda$32(troopExtDBInfo2, troopExtDBInfo3);
                    return updateTroopNotificationData$lambda$33$lambda$32;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopSettingMemberList(@Nullable String troopUin, @NotNull List<String> memberList) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) troopUin, (Object) memberList);
            return;
        }
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            String convertMemberUinListToString = TroopInfo.convertMemberUinListToString(memberList, 24);
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.troopSettingMemberList = convertMemberUinListToString;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, "updateTroopSettingMemberList", new com.tencent.qqnt.troop.a() { // from class: com.tencent.qqnt.troop.v
                @Override // com.tencent.qqnt.troop.a
                public final boolean a(TroopExtDBInfo troopExtDBInfo2, TroopExtDBInfo troopExtDBInfo3) {
                    boolean updateTroopSettingMemberList$lambda$19$lambda$18;
                    updateTroopSettingMemberList$lambda$19$lambda$18 = TroopExtDBInfoRepo.updateTroopSettingMemberList$lambda$19$lambda$18(troopExtDBInfo2, troopExtDBInfo3);
                    return updateTroopSettingMemberList$lambda$19$lambda$18;
                }
            }, null, 8, null);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopType(@Nullable String troopUin, int type, @NotNull String from) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, Integer.valueOf(type), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        TroopInfo troopInfo = getTroopInfo(troopUin);
        if (troopInfo != null) {
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            troopExtDBInfo.troopType = type;
            TroopExtDBInfoRepo troopExtDBInfoRepo = INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(troopExtDBInfo);
            updateExtInfo$default(troopExtDBInfoRepo, arrayListOf, from + "-troopType", new j(), null, 8, null);
        }
    }
}
