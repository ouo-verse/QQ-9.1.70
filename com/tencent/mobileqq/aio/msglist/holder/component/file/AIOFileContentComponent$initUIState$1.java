package com.tencent.mobileqq.aio.msglist.holder.component.file;

import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public /* synthetic */ class AIOFileContentComponent$initUIState$1 extends AdaptedFunctionReference implements Function3<AIOMsgItem, FileElement, View, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIOFileContentComponent$initUIState$1(Object obj) {
        super(3, obj, AIOFileContentComponent.class, "onClickFileBubble", "onClickFileBubble(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;Landroid/view/View;Z)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AIOMsgItem aIOMsgItem, FileElement fileElement, View view) {
        invoke2(aIOMsgItem, fileElement, view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull AIOMsgItem p06, @Nullable FileElement fileElement, @NotNull View p26) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p26, "p2");
        AIOFileContentComponent.O1((AIOFileContentComponent) this.receiver, p06, fileElement, p26, false, 8, null);
    }
}
