package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/e;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/PublishMediaEditManager;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "items", "", "c0", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/e;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/e;", "b0", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/e;", "dataModel", "", "troopUin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends PublishMediaEditManager {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.e dataModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull String troopUin, @NotNull CoroutineScope scope) {
        super(troopUin, scope, 0, 4, null);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin, (Object) scope);
            return;
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.e eVar = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.e();
        eVar.k().setMaxWordCount(500);
        this.dataModel = eVar;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager
    @NotNull
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.e K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataModel;
    }

    public final void c0(@Nullable List<? extends BaseItem> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) items);
            return;
        }
        if (items != null) {
            K().t(items);
        }
        Q();
    }
}
