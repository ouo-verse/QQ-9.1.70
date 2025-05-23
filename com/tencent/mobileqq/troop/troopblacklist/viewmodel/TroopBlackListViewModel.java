package com.tencent.mobileqq.troop.troopblacklist.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopblacklist.model.c;
import com.tencent.mobileqq.troop.troopblacklist.viewmodel.a;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistDelApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistDelApplyRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistGetAllApplyItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistGetAllApplyReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistGetAllApplyRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGroupBlacklistDelApplyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGroupBlacklistGetAllApplyCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u0004R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R*\u00103\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0011078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00110;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;", "Landroidx/lifecycle/ViewModel;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "i2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBlacklistGetAllApplyRsp;", "rsp", "d2", "Z1", "Lcom/tencent/mobileqq/troop/troopblacklist/model/e;", "S1", "", "", "", "Lcom/tencent/mobileqq/troop/troopblacklist/model/c;", "R1", "Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/a;", "intent", "U1", "Landroid/os/Bundle;", "pageArguments", "init", "memberModel", "isCheck", "m2", "", "uin", ICustomDataEditor.STRING_ARRAY_PARAM_2, "b2", "", "X1", "f2", "", "i", "Ljava/lang/String;", "troopUin", "Ljava/util/concurrent/CopyOnWriteArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CopyOnWriteArrayList;", "memberList", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "memberToRemove", "value", "D", "Z", "c2", "()Z", "l2", "(Z)V", "isRemoveMemberState", "E", "J", "reqStartUin", "Lkotlinx/coroutines/flow/MutableSharedFlow;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_intentMutableStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "G", "Lkotlinx/coroutines/flow/SharedFlow;", "W1", "()Lkotlinx/coroutines/flow/SharedFlow;", "intentStateFlow", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBlackListViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, com.tencent.mobileqq.troop.troopblacklist.model.c> memberToRemove;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isRemoveMemberState;

    /* renamed from: E, reason: from kotlin metadata */
    private long reqStartUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableSharedFlow<a> _intentMutableStateFlow;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<a> intentStateFlow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.troop.troopblacklist.model.c> memberList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel$a;", "", "", "MAX_SELECT_COUNT", "I", "", "REQUEST_PAG_SIZE", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopblacklist.viewmodel.TroopBlackListViewModel$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopBlackListViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        this.memberList = new CopyOnWriteArrayList<>();
        this.memberToRemove = new LinkedHashMap();
        MutableSharedFlow<a> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this._intentMutableStateFlow = MutableSharedFlow$default;
        this.intentStateFlow = MutableSharedFlow$default;
    }

    private final Map<Character, List<com.tencent.mobileqq.troop.troopblacklist.model.c>> R1() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (com.tencent.mobileqq.troop.troopblacklist.model.c memberModel : this.memberList) {
            if (linkedHashMap.get(Character.valueOf(memberModel.a())) == null) {
                linkedHashMap.put(Character.valueOf(memberModel.a()), new ArrayList());
            }
            List list = (List) linkedHashMap.get(Character.valueOf(memberModel.a()));
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(memberModel, "memberModel");
                list.add(memberModel);
            }
        }
        return linkedHashMap;
    }

    private final com.tencent.mobileqq.troop.troopblacklist.model.e S1() {
        List mutableList;
        if (Z1()) {
            return new com.tencent.mobileqq.troop.troopblacklist.model.e(null, null, 3, null);
        }
        Map<Character, List<com.tencent.mobileqq.troop.troopblacklist.model.c>> R1 = R1();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) R1.keySet());
        Collections.sort(mutableList, new Comparator() { // from class: com.tencent.mobileqq.troop.troopblacklist.viewmodel.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int T1;
                T1 = TroopBlackListViewModel.T1((Character) obj, (Character) obj2);
                return T1;
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            char charValue = ((Character) it.next()).charValue();
            List<com.tencent.mobileqq.troop.troopblacklist.model.c> list = R1.get(Character.valueOf(charValue));
            if (list != null) {
                arrayList.add(new com.tencent.mobileqq.troop.troopblacklist.model.b(charValue, list.size()));
                arrayList.addAll(list);
            }
        }
        return new com.tencent.mobileqq.troop.troopblacklist.model.e(arrayList, mutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int T1(Character ch5, Character ch6) {
        if (ch5 == null && ch6 == null) {
            return 0;
        }
        if (ch5 != null && (ch6 == null || ch6.charValue() != '#')) {
            if (ch6 != null && ch5.charValue() != '#') {
                return ch5.charValue() - ch6.charValue();
            }
            return 1;
        }
        return -1;
    }

    private final void U1(a intent) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopBlackListViewModel$emitIntent$1(this, intent, null), 3, null);
    }

    private final boolean Z1() {
        return this.memberList.isEmpty();
    }

    private final void d2(final GroupBlacklistGetAllApplyRsp rsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopblacklist.viewmodel.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopBlackListViewModel.e2(GroupBlacklistGetAllApplyRsp.this, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(GroupBlacklistGetAllApplyRsp rsp, TroopBlackListViewModel this$0) {
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<GroupBlacklistGetAllApplyItem> arrayList = rsp.items;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.items");
        for (GroupBlacklistGetAllApplyItem getAllApplyItem : arrayList) {
            CopyOnWriteArrayList<com.tencent.mobileqq.troop.troopblacklist.model.c> copyOnWriteArrayList = this$0.memberList;
            c.Companion companion = com.tencent.mobileqq.troop.troopblacklist.model.c.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(getAllApplyItem, "getAllApplyItem");
            copyOnWriteArrayList.add(companion.a(getAllApplyItem));
        }
        long j3 = rsp.nextStart;
        if (j3 != 0) {
            this$0.reqStartUin = j3;
            this$0.i2(true);
        } else {
            this$0.U1(new a.C8788a(this$0.Z1(), this$0.S1()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(GroupBlacklistDelApplyReq req, TroopBlackListViewModel this$0, Integer num, String str, GroupBlacklistDelApplyRsp groupBlacklistDelApplyRsp) {
        ArrayList<Long> arrayList;
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.troopblacklist.utils.b bVar = com.tencent.mobileqq.troop.troopblacklist.utils.b.f299466a;
        String a16 = bVar.a(req.uins);
        if (groupBlacklistDelApplyRsp != null) {
            arrayList = groupBlacklistDelApplyRsp.failUins;
        } else {
            arrayList = null;
        }
        QLog.i("TroopBlackListViewModel", 1, "[doRemove] errCode = " + num + " errMsg = " + str + " req = " + a16 + " rsp = " + bVar.a(arrayList));
        if (num != null && num.intValue() == 0 && groupBlacklistDelApplyRsp != null) {
            Iterator<T> it = this$0.memberToRemove.values().iterator();
            while (true) {
                boolean z16 = false;
                if (it.hasNext()) {
                    com.tencent.mobileqq.troop.troopblacklist.model.c cVar = (com.tencent.mobileqq.troop.troopblacklist.model.c) it.next();
                    ArrayList<Long> arrayList2 = groupBlacklistDelApplyRsp.failUins;
                    if (arrayList2 != null && arrayList2.contains(Long.valueOf(cVar.c()))) {
                        z16 = true;
                    }
                    if (!z16) {
                        this$0.memberList.remove(cVar);
                    }
                } else {
                    this$0.memberToRemove.clear();
                    this$0.U1(new a.C8788a(this$0.Z1(), this$0.S1()));
                    this$0.l2(false);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopblacklist.viewmodel.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            TroopBlackListViewModel.h2();
                        }
                    });
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2() {
        QQToastUtil.showQQToast(2, R.string.f2325774x);
    }

    private final void i2(boolean isLoadMore) {
        Long longOrNull;
        long j3 = 0;
        if (!isLoadMore) {
            this.reqStartUin = 0L;
            this.memberList.clear();
        }
        GroupBlacklistGetAllApplyReq groupBlacklistGetAllApplyReq = new GroupBlacklistGetAllApplyReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        }
        groupBlacklistGetAllApplyReq.groupCode = j3;
        groupBlacklistGetAllApplyReq.num = 500L;
        groupBlacklistGetAllApplyReq.start = this.reqStartUin;
        s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.groupBlacklistGetAllApply(groupBlacklistGetAllApplyReq, new IGroupBlacklistGetAllApplyCallback() { // from class: com.tencent.mobileqq.troop.troopblacklist.viewmodel.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupBlacklistGetAllApplyCallback
                public final void onResult(int i3, String str, GroupBlacklistGetAllApplyRsp groupBlacklistGetAllApplyRsp) {
                    TroopBlackListViewModel.k2(TroopBlackListViewModel.this, Integer.valueOf(i3), str, groupBlacklistGetAllApplyRsp);
                }
            });
        }
    }

    static /* synthetic */ void j2(TroopBlackListViewModel troopBlackListViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        troopBlackListViewModel.i2(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(TroopBlackListViewModel this$0, Integer num, String str, GroupBlacklistGetAllApplyRsp groupBlacklistGetAllApplyRsp) {
        Integer num2;
        ArrayList<GroupBlacklistGetAllApplyItem> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (groupBlacklistGetAllApplyRsp != null && (arrayList = groupBlacklistGetAllApplyRsp.items) != null) {
            num2 = Integer.valueOf(arrayList.size());
        } else {
            num2 = null;
        }
        QLog.i("TroopBlackListViewModel", 1, "[getMemberList] errCode = " + num + " errMsg = " + str + " rsp = " + num2);
        if (num != null && num.intValue() == 0 && groupBlacklistGetAllApplyRsp != null) {
            this$0.d2(groupBlacklistGetAllApplyRsp);
        } else {
            this$0.U1(new a.C8788a(this$0.Z1(), this$0.S1()));
        }
    }

    @NotNull
    public final SharedFlow<a> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.intentStateFlow;
    }

    public final int X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.memberToRemove.size();
    }

    public final boolean a2(long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, uin)).booleanValue();
        }
        return this.memberToRemove.containsKey(Long.valueOf(uin));
    }

    public final boolean b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.memberToRemove.size() >= 100) {
            return true;
        }
        return false;
    }

    public final boolean c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isRemoveMemberState;
    }

    public final void f2() {
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        final GroupBlacklistDelApplyReq groupBlacklistDelApplyReq = new GroupBlacklistDelApplyReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        groupBlacklistDelApplyReq.groupCode = j3;
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.addAll(this.memberToRemove.keySet());
        groupBlacklistDelApplyReq.uins = arrayList;
        s b16 = com.tencent.qqnt.f.f356721a.b();
        if (b16 != null) {
            b16.groupBlacklistDelApply(groupBlacklistDelApplyReq, new IGroupBlacklistDelApplyCallback() { // from class: com.tencent.mobileqq.troop.troopblacklist.viewmodel.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupBlacklistDelApplyCallback
                public final void onResult(int i3, String str, GroupBlacklistDelApplyRsp groupBlacklistDelApplyRsp) {
                    TroopBlackListViewModel.g2(GroupBlacklistDelApplyReq.this, this, Integer.valueOf(i3), str, groupBlacklistDelApplyRsp);
                }
            });
        }
    }

    public final void init(@NotNull Bundle pageArguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pageArguments);
            return;
        }
        Intrinsics.checkNotNullParameter(pageArguments, "pageArguments");
        String string = pageArguments.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "pageArguments.getString(\u2026stants.Key.TROOP_UIN, \"\")");
        this.troopUin = string;
        QLog.i("TroopBlackListViewModel", 1, "[init] troopUin = " + string);
        if (NetworkUtil.isNetworkAvailable()) {
            j2(this, false, 1, null);
        } else {
            QQToastUtil.showQQToast(1, R.string.f235097aq);
            U1(new a.C8788a(true, new com.tencent.mobileqq.troop.troopblacklist.model.e(null, null, 3, null)));
        }
    }

    public final void l2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        this.isRemoveMemberState = z16;
        if (!z16) {
            this.memberToRemove.clear();
        }
        U1(new a.b(z16, Z1(), this.memberToRemove.size()));
    }

    public final void m2(@NotNull com.tencent.mobileqq.troop.troopblacklist.model.c memberModel, boolean isCheck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, memberModel, Boolean.valueOf(isCheck));
            return;
        }
        Intrinsics.checkNotNullParameter(memberModel, "memberModel");
        if (!this.isRemoveMemberState) {
            return;
        }
        if (isCheck) {
            this.memberToRemove.put(Long.valueOf(memberModel.c()), memberModel);
        } else {
            this.memberToRemove.remove(Long.valueOf(memberModel.c()));
        }
        U1(new a.c(this.memberToRemove.size()));
    }
}
