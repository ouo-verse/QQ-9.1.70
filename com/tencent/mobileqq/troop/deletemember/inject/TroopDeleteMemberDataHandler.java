package com.tencent.mobileqq.troop.deletemember.inject;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchTroopMemberApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.deletemember.inject.items.b;
import com.tencent.mobileqq.troop.deletemember.inject.items.c;
import com.tencent.mobileqq.troop.deletemember.inject.items.d;
import com.tencent.mobileqq.troop.deletemember.inject.items.e;
import com.tencent.mobileqq.troop.deletemember.inject.items.f;
import com.tencent.mobileqq.troop.deletemember.inject.items.g;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberIllegalInfoResult;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b4\u00105J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0002J)\u0010\u0015\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010.R\u001d\u00103\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b1\u00102\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/TroopDeleteMemberDataHandler;", "Lcom/tencent/mobileqq/troop/selectmember/inject/a;", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMembers", h.F, "", "j", "k", "", "from", "o", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "Lkotlin/collections/ArrayList;", "g", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "vmOperator", "", "a", "(Ljava/util/List;Lcom/tencent/mobileqq/troop/selectmember/vm/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "curVMOperator", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "b", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", DownloadInfo.spKey_Config, "c", "Ljava/util/List;", "showTroopMembers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "gagMembers", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", "illegalGroupInfo", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "troopUin", "Landroidx/lifecycle/LifecycleOwner;", "l", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopDeleteMemberDataHandler implements com.tencent.mobileqq.troop.selectmember.inject.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.selectmember.vm.a curVMOperator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends TroopMemberInfo> showTroopMembers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Long> gagMembers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GroupMemberIllegalInfoResult illegalGroupInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy lifecycleOwner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/TroopDeleteMemberDataHandler$a;", "", "", "INDEX_GROUP_ILLEGAL_ACCOUNT", "I", "INDEX_GROUP_MUTE", "INDEX_GROUP_NOT_SENDMSG_ONEMONTH", "INDEX_GROUP_NOT_SENDMSG_SIXMONTH", "INDEX_GROUP_NOT_SENDMSG_TWOMONTH", "INDEX_GROUP_SENDMSG_RENCENT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.deletemember.inject.TroopDeleteMemberDataHandler$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopDeleteMemberDataHandler() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectMemberConfig>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.TroopDeleteMemberDataHandler$config$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberDataHandler.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopSelectMemberConfig invoke() {
                    com.tencent.mobileqq.troop.selectmember.vm.a aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopSelectMemberConfig) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    aVar = TroopDeleteMemberDataHandler.this.curVMOperator;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("curVMOperator");
                        aVar = null;
                    }
                    return aVar.G1();
                }
            });
            this.config = lazy;
            this.showTroopMembers = new ArrayList();
            this.gagMembers = new HashMap<>();
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.TroopDeleteMemberDataHandler$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberDataHandler.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    TroopSelectMemberConfig i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    i3 = TroopDeleteMemberDataHandler.this.i();
                    return i3.q();
                }
            });
            this.troopUin = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LifecycleOwner>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.TroopDeleteMemberDataHandler$lifecycleOwner$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberDataHandler.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final LifecycleOwner invoke() {
                    com.tencent.mobileqq.troop.selectmember.vm.a aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LifecycleOwner) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    aVar = TroopDeleteMemberDataHandler.this.curVMOperator;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("curVMOperator");
                        aVar = null;
                    }
                    return aVar.getLifecycleOwner();
                }
            });
            this.lifecycleOwner = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final ArrayList<b> g() {
        ArrayList<b> arrayList = new ArrayList<>();
        arrayList.add(new c(this.illegalGroupInfo));
        arrayList.add(new d());
        arrayList.add(new f());
        arrayList.add(new g());
        arrayList.add(new e());
        arrayList.add(new com.tencent.mobileqq.troop.deletemember.inject.items.h());
        return arrayList;
    }

    private final List<TroopMemberInfo> h(List<? extends TroopMemberInfo> troopMembers) {
        ArrayList arrayList = new ArrayList();
        for (TroopMemberInfo troopMemberInfo : troopMembers) {
            if (Utils.M(troopMemberInfo.memberuin) && (TextUtils.isEmpty(troopMemberInfo.memberuin) || !Intrinsics.areEqual(troopMemberInfo.memberuin, "50000000"))) {
                troopMemberInfo.displayedNamePinyinFirst = troopMemberInfo.nickInfo.getUIInfo().getShowNamePyFirst();
                arrayList.add(troopMemberInfo);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectMemberConfig i() {
        return (TroopSelectMemberConfig) this.config.getValue();
    }

    private final void j() {
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopMemberGapInfo(m(), l(), new Function2<Boolean, Map<String, ? extends Long>, Unit>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.TroopDeleteMemberDataHandler$getGagMembersServers$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberDataHandler.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends Long> map) {
                invoke(bool.booleanValue(), (Map<String, Long>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull Map<String, Long> uin2ShuntUpTimeMap) {
                HashMap hashMap;
                HashMap hashMap2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uin2ShuntUpTimeMap);
                    return;
                }
                Intrinsics.checkNotNullParameter(uin2ShuntUpTimeMap, "uin2ShuntUpTimeMap");
                if (QLog.isColorLevel()) {
                    QLog.d("TroopDeleteMemberDataHandler", 2, "[getGagMembersServers] isSuccess:" + z16 + ". shutUpMap:" + uin2ShuntUpTimeMap);
                }
                hashMap = TroopDeleteMemberDataHandler.this.gagMembers;
                hashMap.clear();
                hashMap2 = TroopDeleteMemberDataHandler.this.gagMembers;
                hashMap2.putAll(uin2ShuntUpTimeMap);
                TroopDeleteMemberDataHandler.this.o("getGagMembersServers");
            }
        });
    }

    private final void k() {
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopMemberIllegalUinList(m(), l(), new Function2<Boolean, GroupMemberIllegalInfoResult, Unit>() { // from class: com.tencent.mobileqq.troop.deletemember.inject.TroopDeleteMemberDataHandler$getIllegalMembers$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberDataHandler.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
                invoke(bool.booleanValue(), groupMemberIllegalInfoResult);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), groupMemberIllegalInfoResult);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopDeleteMemberDataHandler", 2, "[getIllegalMembers] isSuccess:" + z16 + ", illegalInfoResult:" + groupMemberIllegalInfoResult);
                }
                ArrayList arrayList = new ArrayList();
                if (z16 && groupMemberIllegalInfoResult != null && groupMemberIllegalInfoResult.getUinList() != null) {
                    Iterator<Long> it = groupMemberIllegalInfoResult.getUinList().iterator();
                    while (it.hasNext()) {
                        arrayList.add(String.valueOf(it.next()));
                    }
                }
                TroopDeleteMemberDataHandler.this.illegalGroupInfo = groupMemberIllegalInfoResult;
                TroopDeleteMemberDataHandler.this.o("getIllegalMembers");
            }
        });
    }

    private final LifecycleOwner l() {
        return (LifecycleOwner) this.lifecycleOwner.getValue();
    }

    private final String m() {
        return (String) this.troopUin.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[Catch: NumberFormatException -> 0x0095, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0095, blocks: (B:9:0x005e, B:11:0x0062, B:13:0x0068, B:15:0x006c, B:17:0x0074, B:22:0x0080), top: B:8:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<com.tencent.mobileqq.troop.selectmember.bean.b> n() {
        boolean z16;
        GroupMemberIllegalInfoResult groupMemberIllegalInfoResult;
        ArrayList<Long> uinList;
        String str;
        boolean z17;
        ArrayList<b> g16 = g();
        Calendar calendar = Calendar.getInstance();
        long serverTime = NetConnInfoCenter.getServerTime();
        long j3 = 1000;
        calendar.setTimeInMillis(serverTime * j3);
        Calendar calendar2 = Calendar.getInstance();
        for (TroopMemberInfo troopMemberInfo : this.showTroopMembers) {
            long j16 = troopMemberInfo.last_active_time;
            if (j16 == 0) {
                j16 = troopMemberInfo.join_time;
            }
            calendar2.setTimeInMillis(j16 * j3);
            int i3 = 1;
            int i16 = (((calendar.get(1) - calendar2.get(1)) * 365) + calendar.get(6)) - calendar2.get(6);
            Long l3 = this.gagMembers.get(troopMemberInfo.memberuin);
            try {
                groupMemberIllegalInfoResult = this.illegalGroupInfo;
            } catch (NumberFormatException e16) {
                QLog.e("TroopDeleteMemberDataHandler", 1, "[groupMembers] exception: ", e16);
            }
            if (groupMemberIllegalInfoResult != null && (uinList = groupMemberIllegalInfoResult.getUinList()) != null) {
                GroupMemberIllegalInfoResult groupMemberIllegalInfoResult2 = this.illegalGroupInfo;
                if (groupMemberIllegalInfoResult2 != null) {
                    str = groupMemberIllegalInfoResult2.getSubGroupTitle();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        String str2 = troopMemberInfo.memberuin;
                        Intrinsics.checkNotNullExpressionValue(str2, "info.memberuin");
                        z16 = uinList.contains(Long.valueOf(Long.parseLong(str2)));
                        if (!z16) {
                            i3 = 0;
                        } else if (l3 == null || l3.longValue() <= serverTime) {
                            if (i16 >= 180) {
                                i3 = 2;
                            } else if (i16 >= 60) {
                                i3 = 3;
                            } else if (i16 >= 30) {
                                i3 = 4;
                            } else {
                                i3 = 5;
                            }
                        }
                        boolean canSelectToRemove = ((ISearchTroopMemberApi) QRoute.api(ISearchTroopMemberApi.class)).canSelectToRemove(troopMemberInfo);
                        b bVar = g16.get(i3);
                        Intrinsics.checkNotNullExpressionValue(bVar, "groups[groupIndex]");
                        g16.get(i3).i(new com.tencent.mobileqq.troop.deletemember.inject.items.a(troopMemberInfo, bVar, canSelectToRemove));
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
            z16 = false;
            if (!z16) {
            }
            boolean canSelectToRemove2 = ((ISearchTroopMemberApi) QRoute.api(ISearchTroopMemberApi.class)).canSelectToRemove(troopMemberInfo);
            b bVar2 = g16.get(i3);
            Intrinsics.checkNotNullExpressionValue(bVar2, "groups[groupIndex]");
            g16.get(i3).i(new com.tencent.mobileqq.troop.deletemember.inject.items.a(troopMemberInfo, bVar2, canSelectToRemove2));
        }
        Iterator<T> it = g16.iterator();
        while (it.hasNext()) {
            ((b) it.next()).k();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (((b) obj).canShow()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String from) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopDeleteMemberDataHandler", 2, "[updateShowDatas] from:" + from);
        }
        com.tencent.mobileqq.troop.selectmember.vm.a aVar = this.curVMOperator;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curVMOperator");
            aVar = null;
        }
        aVar.Q(n());
    }

    @Override // com.tencent.mobileqq.troop.selectmember.inject.a
    @Nullable
    public Object a(@NotNull List<? extends TroopMemberInfo> list, @NotNull com.tencent.mobileqq.troop.selectmember.vm.a aVar, @NotNull Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, list, aVar, continuation);
        }
        this.curVMOperator = aVar;
        this.showTroopMembers = h(list);
        j();
        k();
        return Boxing.boxBoolean(true);
    }
}
