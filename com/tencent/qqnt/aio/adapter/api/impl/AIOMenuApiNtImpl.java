package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOMenuApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOMenuApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOMenuApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "isTroopOwnerOrAdmin", "isOverTimeTwoMinutes", "isSupportRevoke", "", "getTroopTodoType", "Landroid/content/Context;", "isCancel", "", "onTroopTodoClicked", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMenuApiNtImpl implements IAIOMenuApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int REVOKE_SUPPORT_TIME_ELAPSED = 120000;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOMenuApiNtImpl$a;", "", "", "REVOKE_SUPPORT_TIME_ELAPSED", "I", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOMenuApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30862);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMenuApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public boolean checkSupportReply(@NotNull Context context, @NotNull AIOMsgItem aIOMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) aIOMsgItem)).booleanValue();
        }
        return IAIOMenuApi.a.a(this, context, aIOMsgItem);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public int getTroopTodoType(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return 0;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public boolean isSupportRevoke(@NotNull com.tencent.aio.api.runtime.a context, @NotNull AIOMsgItem msgItem, boolean isTroopOwnerOrAdmin, boolean isOverTimeTwoMinutes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, msgItem, Boolean.valueOf(isTroopOwnerOrAdmin), Boolean.valueOf(isOverTimeTwoMinutes))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!msgItem.isSelf() && !isTroopOwnerOrAdmin) {
            return false;
        }
        QLog.d("CustomWithdrawConfig", 1, "isOverTimeTwoMinutes is " + isOverTimeTwoMinutes);
        return !isOverTimeTwoMinutes;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMenuApi
    public void onTroopTodoClicked(@NotNull Context context, @NotNull AIOMsgItem msgItem, boolean isCancel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, msgItem, Boolean.valueOf(isCancel));
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        }
    }
}
