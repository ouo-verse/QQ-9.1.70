package com.tencent.mobileqq.aio.robot;

import com.tencent.mobileqq.aio.factory.param.o;
import com.tencent.mobileqq.aio.msglist.AIOMsgRepo;
import com.tencent.mobileqq.aio.msglist.msgrepo.RobotMsgRepoAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.g;
import com.tencent.mobileqq.aio.msglist.msgrepo.m;
import com.tencent.mobileqq.aio.msglist.y;
import com.tencent.mobileqq.aio.robot.msgrepo.RobotReportAbility;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R2\u0010\u000b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005`\u00068\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/d;", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "", "P0", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "k0", "()Ljava/util/ArrayList;", "msgRepoAbilityList", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/y;", "weakMsgListVMApi", "Lcom/tencent/mobileqq/aio/factory/param/o;", "msgDelegate", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/aio/factory/param/o;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends AIOMsgRepo {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<g<?>> msgRepoAbilityList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope, @NotNull WeakReference<y> weakMsgListVMApi, @Nullable o oVar) {
        super(aioContext, scope, weakMsgListVMApi, oVar);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(weakMsgListVMApi, "weakMsgListVMApi");
        ArrayList<g<?>> k06 = super.k0();
        k06.add(new com.tencent.mobileqq.aio.robot.msgrepo.c(this, D(), scope));
        k06.add(new RobotMsgRepoAbility(this, D(), scope));
        k06.add(new m(this, D(), scope));
        k06.add(new RobotReportAbility(this, D(), scope));
        this.msgRepoAbilityList = k06;
    }

    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo
    public int P0() {
        if (D().g().l().getBoolean("key_hide_history_msg")) {
            return 0;
        }
        return super.P0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.AIOMsgRepo, com.tencent.mobileqq.aio.msglist.BaseMsgRepo
    @NotNull
    public ArrayList<g<?>> k0() {
        return this.msgRepoAbilityList;
    }
}
