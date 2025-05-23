package com.tencent.robot.slash.dialog.content.middle;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import com.tencent.robot.slash.dialog.content.middle.SlashContainerUIState;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.slash.manager.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import w64.e;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0014J\u0010\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0014J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0013\u001a\u00020\bH\u0016R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/middle/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "", "Lcom/tencent/robot/slash/dialog/content/middle/SlashContainerUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVM;", "context", "", "p", "", "", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Lcom/tencent/mvi/base/route/k;", "I", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Object;", "mCurrentState", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends SlashDialogVM<Object, SlashContainerUIState, e<u54.c>> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Object mCurrentState;

    public c() {
        super(false, 1, null);
        this.mCurrentState = SlashDialogMsgIntent.ShowLoadingState.f368549e;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    protected void E(@NotNull MsgIntent event) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z18 = true;
        if (event instanceof SlashDialogMsgIntent.ShowNormalState) {
            z16 = true;
        } else {
            z16 = event instanceof SlashDialogMsgIntent.ShowEmptyState;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = event instanceof SlashDialogMsgIntent.ShowFailedState;
        }
        if (!z17) {
            z18 = event instanceof SlashDialogMsgIntent.ShowLoadingState;
        }
        if (z18) {
            this.mCurrentState = event;
            updateUI(new SlashContainerUIState.UpdateContainerTipState(event));
        }
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    protected k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SlashDialogMsgIntent.GetCurrentState) {
            return new e.a(this.mCurrentState);
        }
        return new j54.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowNormalState.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowEmptyState.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowFailedState.class)), u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.ShowLoadingState.class))});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    public List<String> o() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(u64.c.c(Reflection.getOrCreateKotlinClass(SlashDialogMsgIntent.GetCurrentState.class)));
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((w64.e) getMContext()).b().a(m.class).c(j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p */
    public void onCreate(@NotNull w64.e<u54.c> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((w64.e) getMContext()).b().a(m.class).a(j());
    }
}
