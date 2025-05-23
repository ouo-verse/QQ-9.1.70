package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B:\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/c;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/DetailMediaEditManager;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "", "count", "", "D", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/b;", "K", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/b;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/b;", "dataModel", "", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "height", "notifyRecyclerViewHeight", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends DetailMediaEditManager<GroupSchoolTaskData> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.b dataModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String troopUin, @NotNull CoroutineScope scope, @NotNull Function1<? super Integer, Unit> notifyRecyclerViewHeight) {
        super(troopUin, scope, notifyRecyclerViewHeight);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(notifyRecyclerViewHeight, "notifyRecyclerViewHeight");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, scope, notifyRecyclerViewHeight);
        } else {
            this.dataModel = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.b(scope, troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.DetailMediaEditManager
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataModel;
    }

    public final void D(int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, count);
        } else {
            k().y(count);
            A();
        }
    }
}
