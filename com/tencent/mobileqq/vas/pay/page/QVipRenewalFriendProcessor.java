package com.tencent.mobileqq.vas.pay.page;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalFriendProcessor;", "Lcom/tencent/mobileqq/friend/processor/BaseFriendProcessor;", "Lcom/tencent/mobileqq/data/Friends;", GuildMsgItem.NICK_FRIEND, "Lfriendlist/FriendInfo;", "friendResp", "", "onUpdateFriendInfo", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "app", "<init>", "(Lmqq/app/AppRuntime;)V", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QVipRenewalFriendProcessor extends BaseFriendProcessor {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArrayList<WeakReference<n>> f310336c = new CopyOnWriteArrayList<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime app;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalFriendProcessor$a;", "", "Lcom/tencent/mobileqq/vas/pay/page/n;", "l", "", "a", "b", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "updateFriendInfoListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.pay.page.QVipRenewalFriendProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull n l3) {
            Intrinsics.checkNotNullParameter(l3, "l");
            try {
                QVipRenewalFriendProcessor.f310336c.add(new WeakReference(l3));
            } catch (Exception e16) {
                QLog.e("QVipRenewalFriendProcessor", 1, "putFriendInfoListener exception:" + e16);
            }
        }

        public final void b(@NotNull n l3) {
            Intrinsics.checkNotNullParameter(l3, "l");
            try {
                for (WeakReference weakReference : QVipRenewalFriendProcessor.f310336c) {
                    if (Intrinsics.areEqual(l3, weakReference.get())) {
                        QVipRenewalFriendProcessor.f310336c.remove(weakReference);
                    }
                }
            } catch (Exception e16) {
                QLog.e("QVipRenewalFriendProcessor", 1, "putFriendInfoListener exception:" + e16);
            }
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipRenewalFriendProcessor(@NotNull AppRuntime app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateFriendInfo(@Nullable Friends friend, @Nullable FriendInfo friendResp) {
        super.onUpdateFriendInfo(friend, friendResp);
        if (friend != null) {
            try {
                Iterator<T> it = f310336c.iterator();
                while (it.hasNext()) {
                    n nVar = (n) ((WeakReference) it.next()).get();
                    if (nVar != null) {
                        nVar.a(friend);
                    }
                }
            } catch (Exception e16) {
                QLog.e("QVipRenewalFriendProcessor", 1, "process exception:" + e16);
            }
        }
    }
}
