package com.tencent.mobileqq.wink.editor.nextbtn;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014R(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/nextbtn/WinkNextBtnUIData;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "", "updateInner", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "value", "getCaptureMate", "()Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "setCaptureMate", "(Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;)V", "captureMate", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getTemplateMate", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setTemplateMate", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "templateMate", "getEditorTemplateMate", "setEditorTemplateMate", "editorTemplateMate", "Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;", "part", "<init>", "(Lcom/tencent/mobileqq/wink/editor/nextbtn/NextBtnPart;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNextBtnUIData extends WinkEditUIData {

    @NotNull
    private static final String KEY_NEXT_BTN_CAPTURE_MATE = "KEY_NEXT_BTN_CAPTURE_MATE";

    @NotNull
    private static final String KEY_NEXT_BTN_EDITOR_TEMPLATE_MATE = "KEY_NEXT_BTN_EDITOR_TEMPLATE_MATE";

    @NotNull
    private static final String KEY_NEXT_BTN_TEMPLATE_MATE = "KEY_NEXT_BTN_TEMPLATE_MATE";
    private static final long serialVersionUID = -3587094007141971741L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNextBtnUIData(@NotNull NextBtnPart part) {
        super(part);
        Intrinsics.checkNotNullParameter(part, "part");
    }

    @Nullable
    public final AEMaterialMetaData getCaptureMate() {
        return (AEMaterialMetaData) getSerializable(KEY_NEXT_BTN_CAPTURE_MATE, null);
    }

    @Nullable
    public final MetaMaterial getEditorTemplateMate() {
        return (MetaMaterial) getSerializable(KEY_NEXT_BTN_EDITOR_TEMPLATE_MATE, null);
    }

    @Nullable
    public final MetaMaterial getTemplateMate() {
        return (MetaMaterial) getSerializable(KEY_NEXT_BTN_TEMPLATE_MATE, null);
    }

    public final void setCaptureMate(@Nullable AEMaterialMetaData aEMaterialMetaData) {
        putSerializable(KEY_NEXT_BTN_CAPTURE_MATE, aEMaterialMetaData);
    }

    public final void setEditorTemplateMate(@Nullable MetaMaterial metaMaterial) {
        putSerializable(KEY_NEXT_BTN_EDITOR_TEMPLATE_MATE, metaMaterial);
    }

    public final void setTemplateMate(@Nullable MetaMaterial metaMaterial) {
        putSerializable(KEY_NEXT_BTN_TEMPLATE_MATE, metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
