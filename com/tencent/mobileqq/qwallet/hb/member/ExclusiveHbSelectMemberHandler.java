package com.tencent.mobileqq.qwallet.hb.member;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.selectmember.api.ITroopSelectMemberApi;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.selectmember.inject.a;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qidian.api.IQidianManagerApi;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J)\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/member/ExclusiveHbSelectMemberHandler;", "Lcom/tencent/mobileqq/troop/selectmember/inject/a;", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMembers", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "vmOperator", "", "a", "(Ljava/util/List;Lcom/tencent/mobileqq/troop/selectmember/vm/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "curVMOperator", "Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/troop/robot/api/ITroopRobotService;", "troopRobotService", "Lcom/tencent/qidian/api/IQidianManagerApi;", "()Lcom/tencent/qidian/api/IQidianManagerApi;", "qiDianManagerApi", "<init>", "()V", "d", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ExclusiveHbSelectMemberHandler implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.selectmember.vm.a curVMOperator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopRobotService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qiDianManagerApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/member/ExclusiveHbSelectMemberHandler$a;", "", "", "troopUin", "", "selectUinList", "", "a", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.member.ExclusiveHbSelectMemberHandler$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull String troopUin, @NotNull List<String> selectUinList) {
            String currentAccountUin;
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(selectUinList, "selectUinList");
            ITroopSelectMemberApi iTroopSelectMemberApi = (ITroopSelectMemberApi) QRoute.api(ITroopSelectMemberApi.class);
            TroopSelectMemberConfig troopSelectMemberConfig = new TroopSelectMemberConfig(troopUin, 3, 0, 4, null);
            troopSelectMemberConfig.o().f("\u9009\u62e9\u9886\u53d6\u4eba");
            troopSelectMemberConfig.o().e("");
            troopSelectMemberConfig.x(true);
            troopSelectMemberConfig.v(false);
            troopSelectMemberConfig.w(false);
            Object[] array = selectUinList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            troopSelectMemberConfig.u((String[]) array);
            AppInterface e16 = bg.e();
            if (e16 != null && (currentAccountUin = e16.getCurrentAccountUin()) != null) {
                Intrinsics.checkNotNullExpressionValue(currentAccountUin, "currentAccountUin");
                troopSelectMemberConfig.s(new String[]{currentAccountUin});
            }
            com.tencent.mobileqq.troop.selectmember.config.a.k(troopSelectMemberConfig, Reflection.getOrCreateKotlinClass(ExclusiveHbSelectMemberHandler.class).getQualifiedName());
            iTroopSelectMemberApi.launchSelectTroopMemberFragment(troopSelectMemberConfig);
        }

        Companion() {
        }
    }

    public ExclusiveHbSelectMemberHandler() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ITroopRobotService>() { // from class: com.tencent.mobileqq.qwallet.hb.member.ExclusiveHbSelectMemberHandler$troopRobotService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ITroopRobotService invoke() {
                return (ITroopRobotService) bg.m(ITroopRobotService.class, "all");
            }
        });
        this.troopRobotService = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IQidianManagerApi>() { // from class: com.tencent.mobileqq.qwallet.hb.member.ExclusiveHbSelectMemberHandler$qiDianManagerApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IQidianManagerApi invoke() {
                return (IQidianManagerApi) bg.l(IQidianManagerApi.class);
            }
        });
        this.qiDianManagerApi = lazy2;
    }

    private final IQidianManagerApi b() {
        return (IQidianManagerApi) this.qiDianManagerApi.getValue();
    }

    private final ITroopRobotService c() {
        return (ITroopRobotService) this.troopRobotService.getValue();
    }

    @JvmStatic
    public static final void d(@NotNull String str, @NotNull List<String> list) {
        INSTANCE.a(str, list);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (r4 != false) goto L20;
     */
    @Override // com.tencent.mobileqq.troop.selectmember.inject.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull List<? extends TroopMemberInfo> list, @NotNull com.tencent.mobileqq.troop.selectmember.vm.a aVar, @NotNull Continuation<? super Boolean> continuation) {
        int size;
        boolean z16;
        this.curVMOperator = aVar;
        ArrayList arrayList = new ArrayList();
        if ((list instanceof AbstractList) && list.size() - 1 >= 0) {
            while (true) {
                int i3 = size - 1;
                String memberUin = list.get(size).memberuin;
                ITroopRobotService c16 = c();
                boolean z17 = true;
                if (c16 != null && c16.isRobotUin(memberUin)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    IQidianManagerApi b16 = b();
                    if (b16 == null || !b16.isQidianMaster(memberUin)) {
                        z17 = false;
                    }
                }
                ((AbstractList) list).remove(size);
                Intrinsics.checkNotNullExpressionValue(memberUin, "memberUin");
                arrayList.add(memberUin);
                if (i3 < 0) {
                    break;
                }
                size = i3;
            }
        }
        com.tencent.mobileqq.troop.selectmember.vm.a aVar2 = this.curVMOperator;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curVMOperator");
            aVar2 = null;
        }
        aVar2.q0(arrayList);
        return Boxing.boxBoolean(false);
    }
}
