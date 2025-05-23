package com.tencent.mobileqq.wink.editor.openingending;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J$\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0014R\u001a\u0010\u0013\u001a\u00020\u000e8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/bc;", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateTextListMenuPart;", "", "B9", "Lkotlin/Function0;", "", "onStartAction", "onEndAction", "ua", "ta", "bottomOffset", "topOffset", "ra", "qa", "", "a0", "Z", "X9", "()Z", "autoAnimate", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class bc extends WinkEditorTemplateTextListMenuPart {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final boolean autoAnimate;

    @Override // com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateTextListMenuPart, com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zzf;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    /* renamed from: X9, reason: from getter */
    protected boolean getAutoAnimate() {
        return this.autoAnimate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ta(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        super.ta(onStartAction, onEndAction);
        onStartAction.invoke();
        onEndAction.invoke();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    protected void ua(@NotNull Function0<Unit> onStartAction, @NotNull Function0<Unit> onEndAction) {
        Intrinsics.checkNotNullParameter(onStartAction, "onStartAction");
        Intrinsics.checkNotNullParameter(onEndAction, "onEndAction");
        super.ta(onStartAction, onEndAction);
        onStartAction.invoke();
        onEndAction.invoke();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void qa() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ra(int bottomOffset, int topOffset) {
    }
}
