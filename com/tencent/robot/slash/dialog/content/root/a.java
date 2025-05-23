package com.tencent.robot.slash.dialog.content.root;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import com.tencent.robot.slash.dialog.content.root.SlashRootUIState;
import com.tencent.robot.widget.bottomdialog.adorn.msgintent.BottomSheetDialogAdornMsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/root/a;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "", "Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVM;", "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "", "E", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends SlashDialogVM<Object, SlashRootUIState, e<c>> {
    public a() {
        super(false, 1, null);
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    protected void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof BottomSheetDialogAdornMsgIntent.DisplayModeChange) {
            BottomSheetDialogAdornMsgIntent.DisplayModeChange displayModeChange = (BottomSheetDialogAdornMsgIntent.DisplayModeChange) event;
            updateUI(new SlashRootUIState.OnDisplayModeUpdated(displayModeChange.getNewMode(), displayModeChange.getOldMode()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(u64.c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogAdornMsgIntent.DisplayModeChange.class)));
        return listOf;
    }
}
