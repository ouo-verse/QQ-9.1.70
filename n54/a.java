package n54;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import com.tencent.robot.slash.dialog.content.tip.SlashTipContentUIState;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import h64.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Ln54/a;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "Lh64/a;", "Lcom/tencent/robot/slash/dialog/content/tip/SlashTipContentUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVM;", "", "r", "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends SlashDialogVM<h64.a, SlashTipContentUIState, e<c>> {
    public a() {
        super(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        QLog.i(FrameworkVM.TAG, 1, "handleOnClickRetry , peerUid = " + ((c) ((e) getMContext()).f()).getPeerUid());
        ((e) getMContext()).e().h(SlashDialogMsgIntent.RetryRequestMsgIntent.f368546e);
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    protected void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SlashDialogMsgIntent.ShowLoadingState) {
            updateUI(SlashTipContentUIState.ShowLoadingState.f368498d);
        } else if (event instanceof SlashDialogMsgIntent.ShowEmptyState) {
            updateUI(new SlashTipContentUIState.ShowEmptyState(false));
        } else if (event instanceof SlashDialogMsgIntent.ShowFailedState) {
            updateUI(SlashTipContentUIState.ShowFailedState.f368497d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowLoadingState.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowEmptyState.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowFailedState.class))});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull h64.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            r();
        } else {
            boolean z16 = intent instanceof a.C10417a;
        }
    }
}
