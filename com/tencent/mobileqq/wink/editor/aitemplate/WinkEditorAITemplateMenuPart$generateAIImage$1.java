package com.tencent.mobileqq.wink.editor.aitemplate;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public /* synthetic */ class WinkEditorAITemplateMenuPart$generateAIImage$1 extends FunctionReferenceImpl implements Function2<List<? extends String>, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkEditorAITemplateMenuPart$generateAIImage$1(Object obj) {
        super(2, obj, WinkEditorAITemplateMenuPart.class, "onGenerateSuccess", "onGenerateSuccess(Ljava/util/List;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list, Boolean bool) {
        invoke((List<String>) list, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<String> p06, boolean z16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((WinkEditorAITemplateMenuPart) this.receiver).Za(p06, z16);
    }
}
