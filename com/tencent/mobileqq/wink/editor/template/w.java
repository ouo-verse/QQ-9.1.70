package com.tencent.mobileqq.wink.editor.template;

import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/w;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/WinkEditorTextMenuPart;", "Lcom/tencent/mobileqq/wink/editor/sticker/text/bb;", "cc", "", "B9", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "<init>", "()V", "I0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class w extends WinkEditorTextMenuPart {
    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart, com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.f905652t;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.TEMPLATE_TEXT;
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.text.WinkEditorTextMenuPart
    @NotNull
    public com.tencent.mobileqq.wink.editor.sticker.text.bb cc() {
        ViewModel viewModel = getViewModel("template_", com.tencent.mobileqq.wink.editor.sticker.text.bb.class);
        com.tencent.mobileqq.wink.editor.sticker.text.bb bbVar = (com.tencent.mobileqq.wink.editor.sticker.text.bb) viewModel;
        bbVar.C2(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(KEY_PREFIX,\u2026plateText(true)\n        }");
        return bbVar;
    }
}
