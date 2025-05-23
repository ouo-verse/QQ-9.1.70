package com.tencent.robot.slash.dialog.content.avatarbar;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarMsgIntent;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarUIState;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/avatarbar/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/d;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVM;", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "", "E", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", DomainData.DOMAIN_NAME, "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends SlashDialogVM<AvatarClickIntent, AvatarBarUIState, e<u54.c>> {
    public c() {
        super(false, 1, null);
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    protected void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof AvatarBarMsgIntent.SubmitList) {
            updateUI(new AvatarBarUIState.SubmitList(((AvatarBarMsgIntent.SubmitList) event).a()));
        } else if (event instanceof AvatarBarMsgIntent.SelectPosition) {
            updateUI(new AvatarBarUIState.SelectPosition(((AvatarBarMsgIntent.SelectPosition) event).getPosition()));
        }
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    protected List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{u64.c.c(Reflection.getOrCreateKotlinClass(AvatarBarMsgIntent.SubmitList.class)), u64.c.c(Reflection.getOrCreateKotlinClass(AvatarBarMsgIntent.SelectPosition.class))});
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull AvatarClickIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        ((e) getMContext()).e().h(new AvatarBarMsgIntent.OnClickAvatar(intent.getUiData(), intent.getAvatarPosition()));
    }
}
