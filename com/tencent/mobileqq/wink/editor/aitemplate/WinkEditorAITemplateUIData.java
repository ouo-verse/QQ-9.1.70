package com.tencent.mobileqq.wink.editor.aitemplate;

import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014R$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "", "updateInner", "", "value", "getSelectedMaterialId", "()Ljava/lang/String;", "setSelectedMaterialId", "(Ljava/lang/String;)V", "selectedMaterialId", "getSelectedAIImagePath", "setSelectedAIImagePath", "selectedAIImagePath", "getOriginalImagePath", "setOriginalImagePath", "originalImagePath", "Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart;", "part", "<init>", "(Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorAITemplateUIData extends WinkEditUIData {

    @NotNull
    private static final String ORIGINAL_IMAGE_PATH = "ORIGINAL_IMAGE_PATH";

    @NotNull
    private static final String SELECTED_AI_RESULT_IMAGE_PATH = "SELECTED_AI_RESULT_IMAGE_PATH";

    @NotNull
    private static final String SELECTED_MATERIAL_ID = "SELECTED_MATERIAL_ID";
    private static final long serialVersionUID = 2595223325402102827L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorAITemplateUIData(@NotNull WinkEditorAITemplateMenuPart part) {
        super(part);
        Intrinsics.checkNotNullParameter(part, "part");
    }

    @NotNull
    public final String getOriginalImagePath() {
        String string = getString(ORIGINAL_IMAGE_PATH, "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(ORIGINAL_IMAGE_PATH, \"\")");
        return string;
    }

    @NotNull
    public final String getSelectedAIImagePath() {
        String string = getString(SELECTED_AI_RESULT_IMAGE_PATH, "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(SELECTED_AI_RESULT_IMAGE_PATH, \"\")");
        return string;
    }

    @NotNull
    public final String getSelectedMaterialId() {
        String string = getString(SELECTED_MATERIAL_ID, "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(SELECTED_MATERIAL_ID, \"\")");
        return string;
    }

    public final void setOriginalImagePath(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        putString(ORIGINAL_IMAGE_PATH, value);
    }

    public final void setSelectedAIImagePath(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        putString(SELECTED_AI_RESULT_IMAGE_PATH, value);
    }

    public final void setSelectedMaterialId(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        putString(SELECTED_MATERIAL_ID, value);
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
