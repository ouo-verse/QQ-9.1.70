package hh4;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.RecommendProxyOuterClass$KuolieRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lhh4/a;", "", "", "c", "", "a", "I", "whiteFlag", "", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "b", "Ljava/util/List;", "()Ljava/util/List;", "setUserRoomList", "(Ljava/util/List;)V", "userRoomList", "", "<init>", "(ILjava/util/List;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final int f404928d = 1;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int whiteFlag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<RecommendProxyOuterClass$KuolieRoomInfo> userRoomList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lhh4/a$a;", "", "", "WHITE_USER", "I", "a", "()I", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hh4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return a.f404928d;
        }

        Companion() {
        }
    }

    public a(int i3, @NotNull List<RecommendProxyOuterClass$KuolieRoomInfo> userRoomList) {
        Intrinsics.checkNotNullParameter(userRoomList, "userRoomList");
        ArrayList arrayList = new ArrayList();
        this.userRoomList = arrayList;
        this.whiteFlag = i3;
        arrayList.addAll(userRoomList);
    }

    @NotNull
    public final List<RecommendProxyOuterClass$KuolieRoomInfo> b() {
        return this.userRoomList;
    }

    public final boolean c() {
        if (this.whiteFlag == f404928d) {
            return true;
        }
        return false;
    }
}
