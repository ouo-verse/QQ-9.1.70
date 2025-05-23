package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tavcut.core.render.player.IPlayer;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/a;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "", "va", "oa", "", "wa", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/os/Bundle;", "M", "Landroid/os/Bundle;", "pickerBundle", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class a extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Bundle pickerBundle;

    private final void va() {
        String str;
        int i3;
        int i16;
        boolean z16;
        dr H9;
        IPlayer currentPlayer;
        w53.b.a(this.TAG, "addCustomSticker");
        Bundle bundle = this.pickerBundle;
        if (bundle == null || (str = bundle.getString(QQWinkConstants.CUSTOM_STICKER_PHOTO_PATH)) == null) {
            str = "";
        }
        String str2 = str;
        Bundle bundle2 = this.pickerBundle;
        if (bundle2 != null) {
            i3 = bundle2.getInt(QQWinkConstants.CUSTOM_STICKER_PHOTO_WIDTH);
        } else {
            i3 = 0;
        }
        Bundle bundle3 = this.pickerBundle;
        if (bundle3 != null) {
            i16 = bundle3.getInt(QQWinkConstants.CUSTOM_STICKER_PHOTO_HEIGHT);
        } else {
            i16 = 0;
        }
        Bundle bundle4 = this.pickerBundle;
        if (bundle4 != null) {
            z16 = bundle4.getBoolean(QQWinkConstants.CUSTOM_STICKER_IS_SEGMENT);
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            MetaMaterial D2 = G9().D2();
            if (D2 != null) {
                dr H92 = H9();
                WinkEditorFragment F9 = F9();
                Intrinsics.checkNotNull(F9);
                l.f(D2, H92, F9, str2, i3, i16, z16);
            }
        } else {
            ms.a.c(this.TAG, "custom sticker pick photo error: photo path is empty!");
        }
        if (G9().getEditMode() == WinkEditorViewModel.EditMode.Video && (H9 = H9()) != null && (currentPlayer = H9.getCurrentPlayer()) != null) {
            currentPlayer.play();
        }
        G9().U4(null);
        this.pickerBundle = null;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        if (this.pickerBundle != null) {
            w53.b.a(this.TAG, "onEditModeChanged addCustomSticker");
            va();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        w53.b.a(this.TAG, "onActivityResult requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (requestCode == wa() && data != null && resultCode == -1) {
            this.pickerBundle = data.getExtras();
            if (H9() != null) {
                va();
            } else {
                w53.b.a(this.TAG, "onActivityResult tavcut null, pending addCustomSticker");
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        this.pickerBundle = null;
    }

    public abstract int wa();

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
