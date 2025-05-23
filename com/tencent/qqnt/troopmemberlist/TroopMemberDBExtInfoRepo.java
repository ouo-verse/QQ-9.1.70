package com.tencent.qqnt.troopmemberlist;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.troopmemberlist.cache.ITroopMemberCacheService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002Jv\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2F\b\u0002\u0010\u0013\u001a@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0003\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rj\u0004\u0018\u0001`\u0012H\u0002J\"\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J0\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J&\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J7\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ)\u0010$\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0000\u00a2\u0006\u0004\b\"\u0010#J3\u0010(\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010!\u001a\u00020%H\u0000\u00a2\u0006\u0004\b&\u0010'J9\u0010(\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0000\u00a2\u0006\u0004\b&\u0010)J>\u0010.\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\"\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+0*j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+`,2\u0006\u0010\n\u001a\u00020\u0002H\u0016J,\u00100\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020+2\u0006\u0010\n\u001a\u00020\u0002H\u0016J,\u00103\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u00102\u001a\u0002012\u0006\u0010\n\u001a\u00020\u0002H\u0016J,\u00106\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000201042\u0006\u0010\n\u001a\u00020\u0002H\u0016J.\u00109\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u000107042\u0006\u0010\n\u001a\u00020\u0002H\u0016J(\u0010<\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010=\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020+8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo;", "Lcom/tencent/qqnt/troopmemberlist/ITroopMemberExtDBApi;", "", "troopUin", "memberUin", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "getUpdateMemberList", "", "infoList", "from", "Lcom/tencent/qqnt/troopmemberlist/a;", "checkUpdateCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "updatedInfoList", "", "Lcom/tencent/qqnt/troopmemberlist/UpdateExtInfoFinishedCallback;", "updateFinishedCallback", "updateExtInfo", "Lcom/tencent/mobileqq/persistence/EntityManager;", "em", "queryTroopMemberExtInfo", "memberUinList", "queryTroopMemberExtInfoForSubList", "querySingleTroopMemberExtInfo", "selection", "", "selectionArgs", "query", "(Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "Lcom/tencent/qqnt/troopmemberlist/i;", "callback", "fetchTroopMemberExtInfoList$qqtroop_impl_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/troopmemberlist/i;)V", "fetchTroopMemberExtInfoList", "Lcom/tencent/qqnt/troopmemberlist/h;", "fetchTroopMemberExtInfo$qqtroop_impl_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/troopmemberlist/h;)V", "fetchTroopMemberExtInfo", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/qqnt/troopmemberlist/i;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "commonFriendCountMap", "updateCommonFriendCount", "identity", "updateHwIdentity", "", "lastMsgUpdateHonorRichTime", "updateLastMsgUpdateHonorRichTime", "", "uinToFlagEx3", "updateTroopMemberFlagEx3", "", "uinToInfoBuffer", "updateTroopMemberNickIconInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "updateTroopMemberShowNamePinyin", "TAG", "Ljava/lang/String;", "QUERY_UIN_MAX", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberDBExtInfoRepo implements ITroopMemberExtDBApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final TroopMemberDBExtInfoRepo INSTANCE;
    private static final int QUERY_UIN_MAX = 50;

    @NotNull
    private static final String TAG = "TroopMemberDBExtInfoRepo";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$a", "Lcom/tencent/qqnt/troopmemberlist/i;", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "extInfoList", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.qqnt.troopmemberlist.i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f362749a;

        a(com.tencent.qqnt.troopmemberlist.h hVar, String str) {
            this.f362749a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar, (Object) str);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.i
        public void a(@NotNull List<TroopMemberInfoExt> extInfoList) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) extInfoList);
                return;
            }
            Intrinsics.checkNotNullParameter(extInfoList, "extInfoList");
            String str = this.f362749a;
            Iterator<T> it = extInfoList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((TroopMemberInfoExt) obj).memberUin, str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            throw null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$b", "Lcom/tencent/qqnt/troopmemberlist/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.qqnt.troopmemberlist.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.a
        public boolean a(@NotNull TroopMemberInfoExt dbInfo, @NotNull TroopMemberInfoExt updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            int i3 = dbInfo.commonFrdCnt;
            int i16 = updateInfo.commonFrdCnt;
            if (i3 != i16) {
                dbInfo.commonFrdCnt = i16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$c", "Lcom/tencent/qqnt/troopmemberlist/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.qqnt.troopmemberlist.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.a
        public boolean a(@NotNull TroopMemberInfoExt dbInfo, @NotNull TroopMemberInfoExt updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            int i3 = dbInfo.hwIdentity;
            int i16 = updateInfo.hwIdentity;
            if (i3 != i16) {
                dbInfo.hwIdentity = i16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$d", "Lcom/tencent/qqnt/troopmemberlist/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements com.tencent.qqnt.troopmemberlist.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.a
        public boolean a(@NotNull TroopMemberInfoExt dbInfo, @NotNull TroopMemberInfoExt updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            long j3 = dbInfo.lastMsgUpdateHonorRichTime;
            long j16 = updateInfo.lastMsgUpdateHonorRichTime;
            if (j3 != j16) {
                dbInfo.lastMsgUpdateHonorRichTime = j16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$e", "Lcom/tencent/qqnt/troopmemberlist/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements com.tencent.qqnt.troopmemberlist.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.a
        public boolean a(@NotNull TroopMemberInfoExt dbInfo, @NotNull TroopMemberInfoExt updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            long j3 = dbInfo.flagEx3;
            long j16 = updateInfo.flagEx3;
            if (j3 != j16) {
                dbInfo.flagEx3 = j16;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002<\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$f", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "troopUin", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "updatedInfoList", "", "Lcom/tencent/qqnt/troopmemberlist/UpdateExtInfoFinishedCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements Function2<String, List<? extends TroopMemberInfoExt>, Unit> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(@NotNull String troopUin, @NotNull List<TroopMemberInfoExt> updatedInfoList) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) updatedInfoList);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(updatedInfoList, "updatedInfoList");
            if (!updatedInfoList.isEmpty()) {
                Iterator<T> it = updatedInfoList.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.troop.troopidentity.processor.b.f300409a.f(troopUin, (TroopMemberInfoExt) it.next());
                }
            }
            if (!updatedInfoList.isEmpty() && com.tencent.mobileqq.troop.troopgame.g.f300288a.b(troopUin)) {
                for (TroopMemberInfoExt troopMemberInfoExt : updatedInfoList) {
                    if ((troopMemberInfoExt.flagEx3 & 1) == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    com.tencent.mobileqq.troop.troopgame.g.f300288a.c(troopUin, troopMemberInfoExt.memberUin, z16);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends TroopMemberInfoExt> list) {
            a(str, list);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$g", "Lcom/tencent/qqnt/troopmemberlist/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class g implements com.tencent.qqnt.troopmemberlist.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.a
        public boolean a(@NotNull TroopMemberInfoExt dbInfo, @NotNull TroopMemberInfoExt updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            if (!Arrays.equals(dbInfo.nickIconRepeatMsgBuffer, updateInfo.nickIconRepeatMsgBuffer)) {
                dbInfo.nickIconRepeatMsgBuffer = updateInfo.nickIconRepeatMsgBuffer;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002<\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$h", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "troopUin", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "updatedInfoList", "", "Lcom/tencent/qqnt/troopmemberlist/UpdateExtInfoFinishedCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class h implements Function2<String, List<? extends TroopMemberInfoExt>, Unit> {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(@NotNull String troopUin, @NotNull List<TroopMemberInfoExt> updatedInfoList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) updatedInfoList);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(updatedInfoList, "updatedInfoList");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<TroopMemberInfoExt> it = updatedInfoList.iterator();
            while (it.hasNext()) {
                String str = it.next().memberUin;
                if (str != null) {
                    linkedHashSet.add(str);
                }
            }
            if (!linkedHashSet.isEmpty()) {
                ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.y(troopUin, linkedHashSet));
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends TroopMemberInfoExt> list) {
            a(str, list);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/troopmemberlist/TroopMemberDBExtInfoRepo$i", "Lcom/tencent/qqnt/troopmemberlist/a;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "dbInfo", "updateInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class i implements com.tencent.qqnt.troopmemberlist.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.a
        public boolean a(@NotNull TroopMemberInfoExt dbInfo, @NotNull TroopMemberInfoExt updateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dbInfo, (Object) updateInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(dbInfo, "dbInfo");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            if (!Intrinsics.areEqual(dbInfo.showNameForPinyin, updateInfo.showNameForPinyin)) {
                dbInfo.showNameForPinyin = updateInfo.showNameForPinyin;
                dbInfo.showNamePinyinFirst = updateInfo.showNamePinyinFirst;
                dbInfo.showNamePinyinAll = updateInfo.showNamePinyinAll;
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new TroopMemberDBExtInfoRepo();
        }
    }

    TroopMemberDBExtInfoRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberExtInfo$lambda$1(String str, String from, List list, com.tencent.qqnt.troopmemberlist.i callback, long j3) {
        List<TroopMemberInfoExt> filterNotNull;
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            EntityManager b16 = com.tencent.qqnt.e.b();
            if (b16 != null) {
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(INSTANCE.queryTroopMemberExtInfo(b16, str, list, from));
                callback.a(filterNotNull);
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "[fetchTroopMemberExtInfo] troopUin:" + str + ", from:" + from + ", timeCost:" + (System.currentTimeMillis() - j3));
                    return;
                }
                return;
            }
            QLog.e(TAG, 1, "[fetchTroopMemberExtInfo] troopUin:" + str + ", from:" + from + ", em is null");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[fetchTroopMemberExtInfo] exception, troopUin:" + str, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
    
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void fetchTroopMemberExtInfoList$lambda$0(String str, String from, com.tencent.qqnt.troopmemberlist.i callback, long j3) {
        List<TroopMemberInfoExt> arrayList;
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            EntityManager b16 = com.tencent.qqnt.e.b();
            if (b16 == null) {
                QLog.e(TAG, 1, "[fetchTroopMemberExtInfoList] troopUin:" + str + ", from:" + from + ",  em is null");
                return;
            }
            List<TroopMemberInfoExt> queryTroopMemberExtInfo = INSTANCE.queryTroopMemberExtInfo(b16, str);
            if (queryTroopMemberExtInfo == null || arrayList == null) {
                arrayList = new ArrayList<>();
            }
            callback.a(arrayList);
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "[fetchTroopMemberExtInfoList] troopUin:" + str + ", from:" + from + ", timeCost:" + (System.currentTimeMillis() - j3));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[fetchTroopMemberExtInfoList] exception, troopUin:" + str, e16);
        }
    }

    private final List<TroopMemberInfoExt> getUpdateMemberList(String troopUin, String memberUin) {
        ArrayList arrayList = new ArrayList();
        TroopMemberInfoExt troopMemberInfoExt = new TroopMemberInfoExt();
        troopMemberInfoExt.troopUin = troopUin;
        troopMemberInfoExt.memberUin = memberUin;
        arrayList.add(troopMemberInfoExt);
        return arrayList;
    }

    private final List<TroopMemberInfoExt> query(EntityManager em5, String selection, String[] selectionArgs) {
        List query = em5.query(TroopMemberInfoExt.class, false, selection, selectionArgs, null, null, null, null);
        if (!(query instanceof List)) {
            return null;
        }
        return query;
    }

    private final TroopMemberInfoExt querySingleTroopMemberExtInfo(EntityManager em5, String troopUin, String memberUin) {
        boolean z16;
        boolean z17;
        Object firstOrNull;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        if (memberUin != null && memberUin.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return null;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[querySingleTroopMemberExtInfo] single");
        }
        List<TroopMemberInfoExt> query = query(em5, "troopUin=? and memberUin=?", new String[]{troopUin, memberUin});
        if (query != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) query);
            return (TroopMemberInfoExt) firstOrNull;
        }
        return null;
    }

    private final List<TroopMemberInfoExt> queryTroopMemberExtInfo(EntityManager em5, String troopUin) {
        return query(em5, "troopUin=?", new String[]{troopUin});
    }

    private final List<TroopMemberInfoExt> queryTroopMemberExtInfoForSubList(EntityManager em5, String troopUin, List<String> memberUinList) {
        String str = "troopUin=? AND  (" + TextUtils.join(" OR ", Collections.nCopies(memberUinList.size(), "memberUin=?")) + ")";
        int size = memberUinList.size() + 1;
        String[] strArr = new String[size];
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            strArr[i16] = "";
        }
        strArr[0] = troopUin;
        int size2 = memberUinList.size();
        while (i3 < size2) {
            int i17 = i3 + 1;
            strArr[i17] = memberUinList.get(i3);
            i3 = i17;
        }
        return query(em5, str, strArr);
    }

    private final void updateExtInfo(final String troopUin, final List<TroopMemberInfoExt> infoList, final String from, final com.tencent.qqnt.troopmemberlist.a checkUpdateCallback, final Function2<? super String, ? super List<TroopMemberInfoExt>, Unit> updateFinishedCallback) {
        TroopMemberInfoExt troopMemberInfoExt;
        final ITroopMemberCacheService a16 = com.tencent.qqnt.troopmemberlist.cache.impl.c.a();
        Iterator<TroopMemberInfoExt> it = infoList.iterator();
        while (true) {
            TroopMemberInfo troopMemberInfo = null;
            if (it.hasNext()) {
                TroopMemberInfoExt next = it.next();
                if (a16 != null) {
                    troopMemberInfo = a16.getMemberInfoWithExtInfo(troopUin, String.valueOf(next.memberUin));
                }
                if (troopMemberInfo != null && (troopMemberInfoExt = troopMemberInfo.extInfo) != null) {
                    checkUpdateCallback.a(troopMemberInfoExt, next);
                }
            } else {
                com.tencent.qqnt.e.f(false, new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberDBExtInfoRepo.updateExtInfo$lambda$10(infoList, troopUin, from, checkUpdateCallback, a16, updateFinishedCallback);
                    }
                }, 1, null);
                return;
            }
        }
    }

    static /* synthetic */ void updateExtInfo$default(TroopMemberDBExtInfoRepo troopMemberDBExtInfoRepo, String str, List list, String str2, com.tencent.qqnt.troopmemberlist.a aVar, Function2 function2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            function2 = null;
        }
        troopMemberDBExtInfoRepo.updateExtInfo(str, list, str2, aVar, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateExtInfo$lambda$10(List infoList, String troopUin, String from, com.tencent.qqnt.troopmemberlist.a checkUpdateCallback, ITroopMemberCacheService iTroopMemberCacheService, Function2 function2) {
        List filterNotNull;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(infoList, "$infoList");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(from, "$from");
        Intrinsics.checkNotNullParameter(checkUpdateCallback, "$checkUpdateCallback");
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
                String str = ((TroopMemberInfoExt) it.next()).memberUin;
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(INSTANCE.queryTroopMemberExtInfo(b16, troopUin, arrayList3, from));
            List list = filterNotNull;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list) {
                linkedHashMap.put(((TroopMemberInfoExt) obj).memberUin, obj);
            }
            ArrayList<TroopMemberInfoExt> arrayList4 = new ArrayList<>();
            Iterator it5 = infoList.iterator();
            while (it5.hasNext()) {
                TroopMemberInfoExt troopMemberInfoExt = (TroopMemberInfoExt) it5.next();
                TroopMemberInfoExt troopMemberInfoExt2 = (TroopMemberInfoExt) linkedHashMap.get(troopMemberInfoExt.memberUin);
                if (troopMemberInfoExt2 == null) {
                    arrayList.add(new PersistTransaction(troopMemberInfoExt));
                    arrayList2.add(troopMemberInfoExt);
                    sb5.append("|");
                    sb5.append(troopMemberInfoExt.memberUin);
                    arrayList4.add(troopMemberInfoExt);
                } else if (checkUpdateCallback.a(troopMemberInfoExt2, troopMemberInfoExt)) {
                    arrayList2.add(troopMemberInfoExt2);
                    arrayList.add(new UpdateTransaction(troopMemberInfoExt2));
                    arrayList4.add(troopMemberInfoExt2);
                }
            }
            if (!arrayList.isEmpty()) {
                b16.doMultiDBOperateByTransaction(arrayList);
                if (iTroopMemberCacheService != null) {
                    iTroopMemberCacheService.putExtInfo(arrayList4);
                }
            }
            if (function2 != null) {
                function2.invoke(troopUin, arrayList2);
            }
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 1, "[updateExtInfo] from:" + from + ",  notInDb:" + ((Object) sb5));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[updateExtInfo] from:" + from + " exception", e16);
        }
    }

    public final void fetchTroopMemberExtInfo$qqtroop_impl_release(@Nullable String troopUin, @Nullable String memberUin, @NotNull String from, @NotNull com.tencent.qqnt.troopmemberlist.h callback) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, memberUin, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(troopUin == null || troopUin.length() == 0)) {
            if (!(memberUin == null || memberUin.length() == 0) && !Intrinsics.areEqual(memberUin, "0")) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(memberUin);
                fetchTroopMemberExtInfo$qqtroop_impl_release(troopUin, listOf, from, new a(callback, memberUin));
                return;
            }
        }
        QLog.e(TAG, 1, "[fetchTroopMemberExtInfo] troopUin:" + troopUin + ". memberUin:" + memberUin + ", from:" + from);
        callback.a(null);
    }

    public final void fetchTroopMemberExtInfoList$qqtroop_impl_release(@Nullable final String troopUin, @NotNull final String from, @NotNull final com.tencent.qqnt.troopmemberlist.i callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "[fetchTroopMemberExtInfoList] troopUin:" + troopUin + ", from:" + from);
            callback.a(new ArrayList());
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.qqnt.e.f(false, new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.m
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberDBExtInfoRepo.fetchTroopMemberExtInfoList$lambda$0(troopUin, from, callback, currentTimeMillis);
            }
        }, 1, null);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateCommonFriendCount(@Nullable String troopUin, @NotNull HashMap<String, Integer> commonFriendCountMap, @NotNull String from) {
        boolean z16;
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, commonFriendCountMap, from);
            return;
        }
        Intrinsics.checkNotNullParameter(commonFriendCountMap, "commonFriendCountMap");
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "[updateCommonFriendCount] troopUin:" + troopUin);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : commonFriendCountMap.keySet()) {
            TroopMemberInfoExt troopMemberInfoExt = new TroopMemberInfoExt();
            troopMemberInfoExt.troopUin = troopUin;
            troopMemberInfoExt.memberUin = str;
            Integer num = commonFriendCountMap.get(str);
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            troopMemberInfoExt.commonFrdCnt = intValue;
            arrayList.add(troopMemberInfoExt);
        }
        updateExtInfo$default(this, troopUin, arrayList, from + "-cmdFrd", new b(), null, 16, null);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateHwIdentity(@Nullable String troopUin, @Nullable String memberUin, int identity, @NotNull String from) {
        boolean z16;
        Object firstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, memberUin, Integer.valueOf(identity), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (memberUin == null || memberUin.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                List<TroopMemberInfoExt> updateMemberList = getUpdateMemberList(troopUin, memberUin);
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) updateMemberList);
                TroopMemberInfoExt troopMemberInfoExt = (TroopMemberInfoExt) firstOrNull;
                if (troopMemberInfoExt != null) {
                    troopMemberInfoExt.hwIdentity = identity;
                }
                updateExtInfo$default(this, troopUin, updateMemberList, from + "-identity", new c(), null, 16, null);
                return;
            }
        }
        QLog.e(TAG, 1, "[updateHwIdentity] troopUin:" + troopUin + ", memberUin:" + memberUin);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateLastMsgUpdateHonorRichTime(@Nullable String troopUin, @Nullable String memberUin, long lastMsgUpdateHonorRichTime, @NotNull String from) {
        boolean z16;
        Object firstOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, memberUin, Long.valueOf(lastMsgUpdateHonorRichTime), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (memberUin == null || memberUin.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                List<TroopMemberInfoExt> updateMemberList = getUpdateMemberList(troopUin, memberUin);
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) updateMemberList);
                TroopMemberInfoExt troopMemberInfoExt = (TroopMemberInfoExt) firstOrNull;
                if (troopMemberInfoExt != null) {
                    troopMemberInfoExt.lastMsgUpdateHonorRichTime = lastMsgUpdateHonorRichTime;
                }
                updateExtInfo$default(this, troopUin, updateMemberList, from + "-honorTime", new d(), null, 16, null);
                return;
            }
        }
        QLog.e(TAG, 1, "[updateLastMsgUpdateHonorRichTime] troopUin:" + troopUin + ", memberUin:" + memberUin);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateTroopMemberFlagEx3(@NotNull String troopUin, @NotNull Map<String, Long> uinToFlagEx3, @NotNull String from) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, uinToFlagEx3, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinToFlagEx3, "uinToFlagEx3");
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !uinToFlagEx3.isEmpty()) {
            ArrayList arrayList = new ArrayList(uinToFlagEx3.size());
            for (Map.Entry<String, Long> entry : uinToFlagEx3.entrySet()) {
                TroopMemberInfoExt troopMemberInfoExt = new TroopMemberInfoExt();
                troopMemberInfoExt.troopUin = troopUin;
                troopMemberInfoExt.memberUin = entry.getKey();
                troopMemberInfoExt.flagEx3 = entry.getValue().longValue();
                arrayList.add(troopMemberInfoExt);
            }
            updateExtInfo(troopUin, arrayList, from, new e(), new f());
            return;
        }
        QLog.e(TAG, 1, "[updateTroopMemberFlagEx3] troopUin:" + troopUin + ", uinToFlagEx3:" + uinToFlagEx3.size());
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateTroopMemberNickIconInfo(@NotNull String troopUin, @NotNull Map<String, byte[]> uinToInfoBuffer, @NotNull String from) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, uinToInfoBuffer, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinToInfoBuffer, "uinToInfoBuffer");
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e(TAG, 1, "[updateTroopMemberNickIconInfo] troopUin:" + troopUin);
            return;
        }
        ArrayList arrayList = new ArrayList(uinToInfoBuffer.size());
        for (Map.Entry<String, byte[]> entry : uinToInfoBuffer.entrySet()) {
            TroopMemberInfoExt troopMemberInfoExt = new TroopMemberInfoExt();
            troopMemberInfoExt.memberUin = entry.getKey();
            troopMemberInfoExt.troopUin = troopUin;
            troopMemberInfoExt.nickIconRepeatMsgBuffer = entry.getValue();
            arrayList.add(troopMemberInfoExt);
        }
        updateExtInfo(troopUin, arrayList, from, new g(), new h());
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateTroopMemberShowNamePinyin(@Nullable String troopUin, @NotNull List<? extends TroopMemberInfo> troopMemberList, @NotNull String from) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, troopMemberList, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "[updateTroopMemberShowNamePinyin] troopUin:" + troopUin);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = troopMemberList.iterator();
        while (it.hasNext()) {
            TroopMemberInfoExt troopMemberInfoExt = ((TroopMemberInfo) it.next()).extInfo;
            if (troopMemberInfoExt != null) {
                arrayList.add(troopMemberInfoExt);
            }
        }
        updateExtInfo$default(this, troopUin, arrayList, from, new i(), null, 16, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<TroopMemberInfoExt> queryTroopMemberExtInfo(EntityManager em5, String troopUin, List<String> memberUinList, String from) {
        int coerceAtMost;
        Collection arrayList;
        Object first;
        ArrayList arrayList2 = new ArrayList();
        if (memberUinList.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) memberUinList);
            TroopMemberInfoExt querySingleTroopMemberExtInfo = querySingleTroopMemberExtInfo(em5, troopUin, (String) first);
            if (querySingleTroopMemberExtInfo != null) {
                arrayList2.add(querySingleTroopMemberExtInfo);
            }
            return arrayList2;
        }
        int i3 = 0;
        while (i3 < memberUinList.size()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 + 50, memberUinList.size());
            List<TroopMemberInfoExt> queryTroopMemberExtInfoForSubList = queryTroopMemberExtInfoForSubList(em5, troopUin, memberUinList.subList(i3, coerceAtMost));
            if (queryTroopMemberExtInfoForSubList == null || arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList2.addAll(arrayList);
            i3 = coerceAtMost;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[queryTroopMemberExtInfo] from:" + from + ", size:" + memberUinList.size() + ", resSize:" + arrayList2.size());
        }
        return arrayList2;
    }

    public final void fetchTroopMemberExtInfo$qqtroop_impl_release(@Nullable final String troopUin, @Nullable final List<String> memberUinList, @NotNull final String from, @NotNull final com.tencent.qqnt.troopmemberlist.i callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, memberUinList, from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(troopUin == null || troopUin.length() == 0)) {
            List<String> list = memberUinList;
            if (!(list == null || list.isEmpty())) {
                final long currentTimeMillis = System.currentTimeMillis();
                com.tencent.qqnt.e.f(false, new Runnable() { // from class: com.tencent.qqnt.troopmemberlist.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberDBExtInfoRepo.fetchTroopMemberExtInfo$lambda$1(troopUin, from, memberUinList, callback, currentTimeMillis);
                    }
                }, 1, null);
                return;
            }
        }
        callback.a(new ArrayList());
        QLog.e(TAG, 1, "[fetchTroopMemberExtInfo] troopUin:" + troopUin + ", from:" + from);
    }
}
