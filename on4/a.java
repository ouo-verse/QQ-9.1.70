package on4;

import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMGroupManager;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\tH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lon4/a;", "Lln4/b;", "Lln4/a;", "listener", "", "a", "c", "", "groupId", "Lcom/tencent/timi/game/utils/IResultListener;", "", "Lln4/c;", "callback", "b", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "v2TIMGroupListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "groupListeners", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements ln4.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final V2TIMGroupListener v2TIMGroupListener = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<ln4.a> groupListeners = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"on4/a$b", "Lkn4/a;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements kn4.a {
        b() {
        }

        @Override // kn4.a
        public void onError(int errorCode, @Nullable String errorMsg) {
            l.b("GroupManager", "addGroupListener errorCode = [" + errorCode + "], errorMsg = [" + errorMsg + "]");
        }

        @Override // kn4.a
        public void onSuccess() {
            V2TIMManager.getInstance().setGroupListener(a.this.v2TIMGroupListener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"on4/a$c", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberFullInfo;", "p0", "", "a", "", "", "p1", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements V2TIMValueCallback<List<? extends V2TIMGroupMemberFullInfo>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<List<ln4.c>> f423226a;

        c(IResultListener<List<ln4.c>> iResultListener) {
            this.f423226a = iResultListener;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable List<? extends V2TIMGroupMemberFullInfo> p06) {
            List<ln4.c> emptyList;
            int collectionSizeOrDefault;
            IResultListener<List<ln4.c>> iResultListener = this.f423226a;
            if (p06 == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                List<? extends V2TIMGroupMemberFullInfo> list = p06;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                emptyList = new ArrayList<>(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    emptyList.add(new on4.b((V2TIMGroupMemberFullInfo) it.next()));
                }
            }
            iResultListener.onSuccess(emptyList);
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int p06, @Nullable String p16) {
            this.f423226a.onError(p06, p16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"on4/a$d", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "", "groupID", "", "onGroupCreated", "Lcom/tencent/imsdk/v2/V2TIMGroupMemberInfo;", "opUser", "onGroupDismissed", "", "memberList", "onMemberKicked", "onMemberInvited", "member", "onMemberLeave", "", "customData", "onReceiveRESTCustomData", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends V2TIMGroupListener {
        d() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onGroupCreated(@Nullable String groupID) {
            l.i("GroupManager", "onGroupCreated: " + groupID);
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onGroupDismissed(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo opUser) {
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(opUser, "opUser");
            l.i("GroupManager", "onGroupDismissed: " + groupID);
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                Iterator it = a.this.groupListeners.iterator();
                while (it.hasNext()) {
                    ((ln4.a) it.next()).c(data, new on4.b(opUser));
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onMemberInvited(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo opUser, @NotNull List<V2TIMGroupMemberInfo> memberList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(opUser, "opUser");
            Intrinsics.checkNotNullParameter(memberList, "memberList");
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                for (ln4.a aVar : a.this.groupListeners) {
                    on4.b bVar = new on4.b(opUser);
                    List<V2TIMGroupMemberInfo> list = memberList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new on4.b((V2TIMGroupMemberInfo) it.next()));
                    }
                    aVar.a(data, bVar, arrayList);
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onMemberKicked(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo opUser, @NotNull List<V2TIMGroupMemberInfo> memberList) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(opUser, "opUser");
            Intrinsics.checkNotNullParameter(memberList, "memberList");
            l.i("GroupManager", "onMemberKicked: " + groupID);
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                for (ln4.a aVar : a.this.groupListeners) {
                    on4.b bVar = new on4.b(opUser);
                    List<V2TIMGroupMemberInfo> list = memberList;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new on4.b((V2TIMGroupMemberInfo) it.next()));
                    }
                    aVar.d(data, bVar, arrayList);
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onMemberLeave(@NotNull String groupID, @NotNull V2TIMGroupMemberInfo member) {
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            Intrinsics.checkNotNullParameter(member, "member");
            ULong uLongOrNull = UStringsKt.toULongOrNull(groupID);
            if (uLongOrNull != null) {
                long data = uLongOrNull.getData();
                Iterator it = a.this.groupListeners.iterator();
                while (it.hasNext()) {
                    ((ln4.a) it.next()).b(data, new on4.b(member));
                }
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onReceiveRESTCustomData(@NotNull String groupID, @Nullable byte[] customData) {
            Intrinsics.checkNotNullParameter(groupID, "groupID");
            super.onReceiveRESTCustomData(groupID, customData);
            l.b("GroupManager", "onReceiveRESTCustomData() called with: groupID = [" + groupID + "]");
            try {
                MessageOuterClass$TimMsgBody timMsg = new MessageOuterClass$TimMsgBody().mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(customData, 0));
                kn4.b bVar = (kn4.b) mm4.b.b(kn4.b.class);
                Intrinsics.checkNotNullExpressionValue(timMsg, "timMsg");
                bVar.q3(groupID, timMsg);
            } catch (InvalidProtocolBufferMicroException e16) {
                l.f("GroupManager", "onReceiveRESTCustomData error", e16);
            }
        }
    }

    @Override // ln4.b
    public void a(@Nullable ln4.a listener) {
        if (!this.groupListeners.contains(listener)) {
            this.groupListeners.add(listener);
        }
        ((kn4.b) mm4.b.b(kn4.b.class)).T1(new b());
    }

    @Override // ln4.b
    public void b(long groupId, @NotNull IResultListener<List<ln4.c>> callback) {
        List<String> mutableListOf;
        Intrinsics.checkNotNullParameter(callback, "callback");
        V2TIMGroupManager groupManager = V2TIMManager.getGroupManager();
        String a16 = nn4.a.a(groupId);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(V2TIMManager.getInstance().getLoginUser());
        groupManager.getGroupMembersInfo(a16, mutableListOf, new c(callback));
    }

    @Override // ln4.b
    public void c(@Nullable ln4.a listener) {
        this.groupListeners.remove(listener);
    }
}
