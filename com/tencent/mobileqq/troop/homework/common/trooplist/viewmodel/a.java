package com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.common.HWPageType;
import com.tencent.mobileqq.troop.homework.common.trooplist.data.TroopItemType;
import com.tencent.mobileqq.troop.homework.common.trooplist.event.HWTroopListEvent;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetGroupSchoolRoleReq;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetGroupSchoolRoleRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolRole;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetUserGroupSchoolRoleCallback;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001?B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\u0003J$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u0011R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010(\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R#\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170*0.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\r048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0017088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetUserGroupSchoolRoleCallback;", "", "W1", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolRole;", "role", "", "T1", "U1", "S1", "isSelected", "R1", "", "troopUin", "O1", "init", "", "errCode", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchGetGroupSchoolRoleRsp;", "rsp", "onResult", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/a;", "itemInfo", "Q1", "P1", "L1", "Landroid/os/Bundle;", "i", "Landroid/os/Bundle;", "bundle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "N1", "()Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "I", "getPageFrom", "()I", "pageFrom", "Landroidx/lifecycle/MutableLiveData;", "", "D", "Landroidx/lifecycle/MutableLiveData;", "_troopList", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "troopList", "", UserInfo.SEX_FEMALE, "Ljava/util/Set;", "selectedTroopSet", "", "G", "Ljava/util/List;", "allTroopList", "<init>", "(Landroid/os/Bundle;)V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ViewModel implements IBatchGetUserGroupSchoolRoleCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int pageFrom;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a>> _troopList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a>> troopList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Set<String> selectedTroopSet;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a> allTroopList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a$a, reason: collision with other inner class name and from kotlin metadata */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f296649a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45993);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TroopItemType.values().length];
            try {
                iArr[TroopItemType.ITEM_TYPE_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopItemType.ITEM_TYPE_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f296649a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class c<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(Long.parseLong(((com.tencent.mobileqq.troop.homework.common.trooplist.data.a) t16).d())), Long.valueOf(Long.parseLong(((com.tencent.mobileqq.troop.homework.common.trooplist.data.a) t17).d())));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45996);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.bundle = bundle;
        String string = bundle.getString("TROOP_UIN");
        this.troopUin = string == null ? "0" : string;
        this.pageFrom = bundle.getInt("PAGE_FROM", HWPageType.PAGE_TYPE_NOTICE.ordinal());
        MutableLiveData<List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a>> mutableLiveData = new MutableLiveData<>();
        this._troopList = mutableLiveData;
        this.troopList = mutableLiveData;
        this.selectedTroopSet = new LinkedHashSet();
        this.allTroopList = new ArrayList();
    }

    private final void O1(String troopUin) {
        for (com.tencent.mobileqq.troop.homework.common.trooplist.data.a aVar : this.allTroopList) {
            if (Intrinsics.areEqual(aVar.d(), troopUin)) {
                aVar.g(!aVar.f());
                if (aVar.f()) {
                    this.selectedTroopSet.add(aVar.d());
                    return;
                } else {
                    this.selectedTroopSet.remove(troopUin);
                    return;
                }
            }
        }
    }

    private final void R1(boolean isSelected) {
        for (com.tencent.mobileqq.troop.homework.common.trooplist.data.a aVar : this.allTroopList) {
            if (aVar.e()) {
                aVar.g(isSelected);
                if (isSelected) {
                    this.selectedTroopSet.add(aVar.d());
                } else {
                    this.selectedTroopSet.remove(aVar.d());
                }
            }
        }
    }

    private final boolean S1() {
        Iterator<com.tencent.mobileqq.troop.homework.common.trooplist.data.a> it = this.allTroopList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().e()) {
                i3++;
            }
        }
        if (i3 != this.selectedTroopSet.size()) {
            return false;
        }
        return true;
    }

    private final boolean T1(GroupSchoolRole role) {
        int i3;
        int i16 = this.pageFrom;
        if (i16 == HWPageType.PAGE_TYPE_NOTICE.ordinal()) {
            int i17 = role.roleId;
            if (i17 == 332 || i17 == 333) {
                return true;
            }
            return false;
        }
        if (i16 != HWPageType.PAGE_TYPE_CLOCK_IN.ordinal()) {
            return false;
        }
        int i18 = role.roleId;
        if ((i18 == 332 || i18 == 333) && ((i3 = role.groupRoleId) == 2 || i3 == 1)) {
            return true;
        }
        return false;
    }

    private final void U1() {
        List sortedWith;
        List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a> mutableList;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.troop.homework.common.trooplist.data.a aVar : this.allTroopList) {
            arrayList.add(new com.tencent.mobileqq.troop.homework.common.trooplist.data.a(aVar.d(), aVar.c(), aVar.b(), aVar.f(), null, aVar.e(), 16, null));
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new c());
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) sortedWith);
        if (!mutableList.isEmpty()) {
            mutableList.add(0, new com.tencent.mobileqq.troop.homework.common.trooplist.data.a(null, null, 0, S1(), TroopItemType.ITEM_TYPE_HEADER, false, 39, null));
        }
        this._troopList.postValue(mutableList);
    }

    private final void W1() {
        int i3;
        ArrayList arrayList = new ArrayList();
        for (TroopInfo troopInfo : ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache()) {
            if (!Intrinsics.areEqual(troopInfo.troopuin, this.troopUin) && troopInfo.isHomeworkTroop()) {
                String troopUin = troopInfo.getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
                arrayList.add(Long.valueOf(Long.parseLong(troopUin)));
            }
        }
        if (this.pageFrom == HWPageType.PAGE_TYPE_NOTICE.ordinal()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        BatchGetGroupSchoolRoleReq batchGetGroupSchoolRoleReq = new BatchGetGroupSchoolRoleReq(arrayList, i3);
        r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
        if (groupSchoolService != null) {
            groupSchoolService.batchGetUserGroupSchoolRole(batchGetGroupSchoolRoleReq, this);
        }
    }

    public final int L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a> list = this.allTroopList;
        int i3 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((com.tencent.mobileqq.troop.homework.common.trooplist.data.a) it.next()).f() && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i3;
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a>> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopList;
    }

    @NotNull
    public final String N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final void P1() {
        boolean z16;
        String valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        String str = "";
        for (com.tencent.mobileqq.troop.homework.common.trooplist.data.a aVar : this.allTroopList) {
            if (aVar.f()) {
                arrayList.add(aVar.d());
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                String c16 = aVar.c();
                if (z16) {
                    valueOf = "\u3001" + c16;
                } else {
                    valueOf = String.valueOf(c16);
                }
                str = str + valueOf;
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new HWTroopListEvent.TroopRangeChanged(new com.tencent.mobileqq.troop.homework.common.trooplist.data.b(arrayList, str)));
    }

    public final void Q1(@NotNull com.tencent.mobileqq.troop.homework.common.trooplist.data.a itemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) itemInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        int i3 = b.f296649a[itemInfo.a().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                O1(itemInfo.d());
            }
        } else {
            R1(itemInfo.f());
        }
        U1();
    }

    public final int getPageFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.pageFrom;
    }

    public final void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ArrayList<String> stringArrayList = this.bundle.getStringArrayList("NOTICE_TROOP_LIST");
        if (stringArrayList != null) {
            this.selectedTroopSet.addAll(stringArrayList);
        }
        W1();
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchGetUserGroupSchoolRoleCallback
    public void onResult(int errCode, @Nullable String errMsg, @Nullable BatchGetGroupSchoolRoleRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(errCode), errMsg, rsp);
            return;
        }
        if (errCode == 0 && rsp != null) {
            Iterator<GroupSchoolRole> it = rsp.roles.iterator();
            while (it.hasNext()) {
                GroupSchoolRole role = it.next();
                Intrinsics.checkNotNullExpressionValue(role, "role");
                if (T1(role)) {
                    this.allTroopList.add(new com.tencent.mobileqq.troop.homework.common.trooplist.data.a(String.valueOf(role.groupCode), HWNoticeUtils.f297171a.g(String.valueOf(role.groupCode)), role.studentNum, this.selectedTroopSet.contains(String.valueOf(role.groupCode)), null, !role.overLimit, 16, null));
                }
            }
        }
        U1();
    }
}
