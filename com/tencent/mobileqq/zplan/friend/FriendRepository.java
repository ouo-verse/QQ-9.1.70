package com.tencent.mobileqq.zplan.friend;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.zplan.friend.r;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u00062\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0004\u0012\u00020\u00060\u000bJ(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0004\u0012\u00020\u00060\u000bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/FriendRepository;", "", "", "roleType", "Lcom/tencent/mobileqq/zplan/friend/c;", "info", "", "g", "friendInfo", "", tl.h.F, "Lkotlin/Function1;", "", "cb", "d", "f", "Lcom/tencent/common/app/AppInterface;", "a", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/friend/api/IFriendDataService;", "b", "Lcom/tencent/mobileqq/friend/api/IFriendDataService;", "friendService", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final IFriendDataService friendService;

    public FriendRepository(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        IRuntimeService runtimeService = app.getRuntimeService(IFriendDataService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026ava, ProcessConstant.ALL)");
        this.friendService = (IFriendDataService) runtimeService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final FriendRepository this$0, final Function1 cb5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        final ArrayList arrayList = new ArrayList();
        this$0.f(1, new Function1<List<? extends FriendInfo>, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.FriendRepository$fetch$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendInfo> list) {
                invoke2((List<FriendInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FriendInfo> friendList) {
                Intrinsics.checkNotNullParameter(friendList, "friendList");
                arrayList.addAll(friendList);
                FriendRepository friendRepository = this$0;
                final List<FriendInfo> list = arrayList;
                final Function1<List<FriendInfo>, Unit> function1 = cb5;
                friendRepository.f(0, new Function1<List<? extends FriendInfo>, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.FriendRepository$fetch$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendInfo> list2) {
                        invoke2((List<FriendInfo>) list2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<FriendInfo> botList) {
                        Intrinsics.checkNotNullParameter(botList, "botList");
                        list.addAll(botList);
                        function1.invoke(list);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        r6 = kotlin.text.StringsKt___StringsKt.firstOrNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int roleType, FriendInfo info) {
        char c16;
        Character firstOrNull;
        boolean z16 = true;
        if (info.getName() == null) {
            info.i(this.friendService.getFriend(info.getUin(), true, true).getFriendNick());
        }
        info.j(ChnToSpell.d(info.getName(), 2));
        if (roleType == 0) {
            info.h('#');
            return;
        }
        String namePinyin = info.getNamePinyin();
        if (namePinyin != null && firstOrNull != null) {
            char charValue = firstOrNull.charValue();
            if (!('A' <= charValue && charValue < '[')) {
                if (!('a' <= charValue && charValue < '{')) {
                    z16 = false;
                }
            }
            if (!z16) {
                firstOrNull = null;
            }
            if (firstOrNull != null) {
                c16 = Character.valueOf(Character.toUpperCase(firstOrNull.charValue()));
                info.h(c16);
            }
        }
        c16 = '#';
        info.h(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(FriendInfo friendInfo) {
        String str = "0";
        if (Intrinsics.areEqual(friendInfo.getUin(), com.tencent.sqshow.zootopia.utils.w.f373306a.b())) {
            return "0";
        }
        Character firstChar = friendInfo.getFirstChar();
        if (firstChar != null && firstChar.charValue() == '#') {
            str = "1";
        }
        Character firstChar2 = friendInfo.getFirstChar();
        Object namePinyin = friendInfo.getNamePinyin();
        if (namePinyin == null) {
            namePinyin = friendInfo.getFirstChar();
        }
        return str + "_" + firstChar2 + "_" + namePinyin;
    }

    public final void d(final Function1<? super List<FriendInfo>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.friend.i
            @Override // java.lang.Runnable
            public final void run() {
                FriendRepository.e(FriendRepository.this, cb5);
            }
        }, 16, null, true);
    }

    public final void f(final int roleType, final Function1<? super List<FriendInfo>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        r.f333732a.d(this.app, roleType, new Function1<List<? extends r.RoleInfo>, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.FriendRepository$fetchFriendList$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes34.dex */
            public static final class a<T> implements Comparator {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FriendRepository f333657d;

                public a(FriendRepository friendRepository) {
                    this.f333657d = friendRepository;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    String h16;
                    String h17;
                    int compareValues;
                    h16 = this.f333657d.h((FriendInfo) t16);
                    h17 = this.f333657d.h((FriendInfo) t17);
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(h16, h17);
                    return compareValues;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends r.RoleInfo> list) {
                invoke2((List<r.RoleInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<r.RoleInfo> roleList) {
                int collectionSizeOrDefault;
                List<FriendInfo> sortedWith;
                Intrinsics.checkNotNullParameter(roleList, "roleList");
                List<r.RoleInfo> list = roleList;
                int i3 = roleType;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (r.RoleInfo roleInfo : list) {
                    arrayList.add(new FriendInfo(roleInfo.getUin(), i3 == 1 ? null : roleInfo.getHead(), roleInfo.getImage(), roleInfo.getName(), null, null, roleInfo.getGender(), 48, null));
                }
                FriendRepository friendRepository = this;
                int i16 = roleType;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    friendRepository.g(i16, (FriendInfo) it.next());
                }
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a(this));
                cb5.invoke(sortedWith);
            }
        });
    }
}
