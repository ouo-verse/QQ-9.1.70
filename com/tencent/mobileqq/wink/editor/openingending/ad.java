package com.tencent.mobileqq.wink.editor.openingending;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClippingMenuPart;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J$\u0010\u000b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0014J$\u0010\f\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0014J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u00158\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/ad;", "Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClippingMenuPart;", "", "B9", "Landroid/os/Bundle;", "args", "", "L9", "Lkotlin/Function0;", "onStartAction", "onEndAction", "ua", "ta", "bottomOffset", "topOffset", "ra", "qa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartResume", "", "n0", "Z", "isFirstShow", "o0", "needPlay", "p0", "X9", "()Z", "autoAnimate", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ad extends WinkEditorTemplateCollClippingMenuPart {

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstShow = true;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean needPlay = true;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final boolean autoAnimate;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tb(ad this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.needPlay) {
            dr H9 = this$0.H9();
            if (H9 != null) {
                H9.play();
                return;
            }
            return;
        }
        dr H92 = this$0.H9();
        if (H92 != null) {
            H92.pause();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClippingMenuPart, com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zzc;
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClippingMenuPart, com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    protected void L9(@Nullable Bundle args) {
        super.L9(args);
        dr H9 = H9();
        if (H9 != null) {
            H9.play();
        }
        if (this.isFirstShow) {
            dr H92 = H9();
            if (H92 != null) {
                H92.j();
            }
            this.isFirstShow = false;
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    /* renamed from: X9, reason: from getter */
    protected boolean getAutoAnimate() {
        return this.autoAnimate;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        boolean z16;
        dr H9 = H9();
        if (H9 != null) {
            z16 = H9.isPlaying();
        } else {
            z16 = true;
        }
        this.needPlay = z16;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad.tb(ad.this);
            }
        });
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
