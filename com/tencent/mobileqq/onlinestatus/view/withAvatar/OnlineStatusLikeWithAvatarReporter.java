package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.mobileqq.onlinestatus.utils.z;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0004`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarReporter;", "", "", "index", "", "hasAvatar", "", "b", "Lcom/tencent/mobileqq/onlinestatus/model/d;", GuildMsgItem.NICK_FRIEND, "d", "likeType", "c", "", "a", "Ljava/util/List;", "friends", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "toExpList", "Lkotlin/Lazy;", "()I", "from", "outFrom", "<init>", "(Ljava/util/List;I)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusLikeWithAvatarReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.onlinestatus.model.d> friends;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Boolean> toExpList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy from;

    public OnlineStatusLikeWithAvatarReporter(@NotNull List<com.tencent.mobileqq.onlinestatus.model.d> friends, final int i3) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(friends, "friends");
        this.friends = friends;
        this.toExpList = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarReporter$from$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int i16 = i3;
                int i17 = 1;
                if (i16 != 1 && i16 != 3) {
                    if (i16 != 4) {
                        if (i16 != 5) {
                            i17 = 2;
                        }
                    }
                    return Integer.valueOf(i17);
                }
                i17 = 0;
                return Integer.valueOf(i17);
            }
        });
        this.from = lazy;
    }

    private final int a() {
        return ((Number) this.from.getValue()).intValue();
    }

    public final void b(int index, boolean hasAvatar) {
        if (index >= 0 && index < this.friends.size()) {
            com.tencent.mobileqq.onlinestatus.model.d dVar = this.friends.get(index);
            if (this.toExpList.containsKey(dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
                this.toExpList.put(dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), Boolean.valueOf(hasAvatar));
            } else {
                this.toExpList.put(dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), Boolean.valueOf(hasAvatar));
                z.i(hasAvatar, bs.r(ae.c(dVar.getStatus()), dVar.getStatus().e0()).f256383a, a());
            }
        }
    }

    public final void c(int likeType, @NotNull com.tencent.mobileqq.onlinestatus.model.d friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        int i3 = bs.r(ae.c(friend.getStatus()), friend.getStatus().e0()).f256383a;
        Boolean bool = this.toExpList.get(friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        z.j(bool.booleanValue(), i3, a(), likeType - 1);
    }

    public final void d(@NotNull com.tencent.mobileqq.onlinestatus.model.d friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        int i3 = bs.r(ae.c(friend.getStatus()), friend.getStatus().e0()).f256383a;
        Boolean bool = this.toExpList.get(friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        z.k(bool.booleanValue(), i3, a());
    }
}
