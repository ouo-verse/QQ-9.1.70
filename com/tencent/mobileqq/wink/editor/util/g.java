package com.tencent.mobileqq.wink.editor.util;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/g;", "", "", "c", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "editorViewModel", "", "isFromDraft", "Landroid/content/Intent;", "intent", "e", "f", "d", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "b", "a", "<set-?>", "Z", "g", "()Z", "isEnableEditorABTest", "i", "isEnableStickerFakeFeedView", tl.h.F, "isEnableImageResizeAfterCrop", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f322634a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableEditorABTest = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableStickerFakeFeedView = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableImageResizeAfterCrop = true;

    g() {
    }

    private final void c() {
        isEnableEditorABTest = true;
        isEnableStickerFakeFeedView = true;
        isEnableImageResizeAfterCrop = true;
    }

    private final void d() {
        isEnableEditorABTest = false;
    }

    private final void e(WinkEditorViewModel editorViewModel, boolean isFromDraft, Intent intent) {
        boolean z16;
        boolean z17;
        f();
        if (!isFromDraft) {
            if (intent != null) {
                z16 = intent.getBooleanExtra(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
            } else {
                z16 = false;
            }
            editorViewModel.b5(z16);
            Intent activityIntent = editorViewModel.getActivityIntent();
            boolean z18 = true;
            if (activityIntent != null && activityIntent.getIntExtra("edit_image_mode", -1) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            ArrayList<LocalMediaInfo> R2 = editorViewModel.R2();
            if (R2 == null || R2.size() != 1) {
                z18 = false;
            }
            if (z18 && editorViewModel.getIsAllImages() && !editorViewModel.getIsAutoTemplate() && !z17) {
                editorViewModel.Y4(WinkEditorViewModel.EditMode.Image);
                editorViewModel.a5(false);
            } else {
                editorViewModel.Y4(WinkEditorViewModel.EditMode.Video);
            }
        }
    }

    private final void f() {
        isEnableEditorABTest = false;
        isEnableStickerFakeFeedView = false;
        isEnableImageResizeAfterCrop = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000c. Please report as an issue. */
    public final void a(@NotNull WinkEditorViewModel editorViewModel, @Nullable String businessName, boolean isFromDraft, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(editorViewModel, "editorViewModel");
        if (businessName != null) {
            switch (businessName.hashCode()) {
                case -1322459498:
                    if (businessName.equals("qqstranger")) {
                        f();
                        return;
                    }
                    break;
                case -221673174:
                    if (businessName.equals(QQWinkConstants.ENTRY_BUSINESS_KANDIAN)) {
                        d();
                        return;
                    }
                    break;
                case -176742241:
                    if (businessName.equals("qqnearby")) {
                        f();
                        return;
                    }
                    break;
                case 77564797:
                    if (businessName.equals("QZONE")) {
                        e(editorViewModel, isFromDraft, intent);
                        return;
                    }
                    break;
            }
        }
        c();
    }

    public final void b(@Nullable String businessName) {
        if (businessName != null) {
            switch (businessName.hashCode()) {
                case -1322459498:
                    if (businessName.equals("qqstranger")) {
                        f();
                        return;
                    }
                    break;
                case -221673174:
                    if (businessName.equals(QQWinkConstants.ENTRY_BUSINESS_KANDIAN)) {
                        d();
                        return;
                    }
                    break;
                case -176742241:
                    if (businessName.equals("qqnearby")) {
                        f();
                        return;
                    }
                    break;
                case 77564797:
                    if (businessName.equals("QZONE")) {
                        f();
                        return;
                    }
                    break;
            }
        }
        c();
    }

    public final boolean g() {
        return isEnableEditorABTest;
    }

    public final boolean h() {
        return isEnableImageResizeAfterCrop;
    }

    public final boolean i() {
        return isEnableStickerFakeFeedView;
    }
}
