package com.tencent.mobileqq.qqvideoedit.zplan.parts;

import android.app.Activity;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.view.BorderView;
import com.tencent.mobileqq.qqvideoedit.zplan.view.ZootopiaVideoSelectView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.rendermodel.RenderModel;
import ik2.GifClipData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/parts/c;", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "Lcom/tencent/tavcut/session/d;", "Lcom/tencent/mobileqq/qqvideoedit/zplan/view/ZootopiaVideoSelectView$a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "A9", "initAfterInflation", "L9", "onRenderDataApplied", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "newData", "", "duration", "mediaDuration", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lik2/d;", "data", "z6", "Lcom/tencent/mobileqq/qqvideoedit/zplan/view/ZootopiaVideoSelectView;", "D", "Lcom/tencent/mobileqq/qqvideoedit/zplan/view/ZootopiaVideoSelectView;", "cutSelectView", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView;", "E", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView;", "stickerBorderView", "", UserInfo.SEX_FEMALE, "Z", "isFirstRenderChanged", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends com.tencent.mobileqq.qqvideoedit.editor.d implements com.tencent.tavcut.session.d, ZootopiaVideoSelectView.a {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ZootopiaVideoSelectView cutSelectView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private BorderView stickerBorderView;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFirstRenderChanged;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(c this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaVideoSelectView zootopiaVideoSelectView = this$0.cutSelectView;
        if (zootopiaVideoSelectView != null) {
            zootopiaVideoSelectView.g(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.f1170470d;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void L9() {
        com.tencent.tavcut.session.a l3;
        aw F9 = F9();
        if (F9 != null && (l3 = F9.l()) != null) {
            l3.k(this);
        }
        BorderView borderView = this.stickerBorderView;
        if (borderView != null) {
            borderView.setBorderViewEventConsumable(false);
        }
    }

    @Override // com.tencent.tavcut.session.d
    public void a1(@NotNull RenderModel newData, long duration, long mediaDuration) {
        final int i3;
        Integer num;
        Integer num2;
        Intrinsics.checkNotNullParameter(newData, "newData");
        if (!this.isFirstRenderChanged) {
            this.isFirstRenderChanged = true;
            Activity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.R9(c.this);
                    }
                });
            }
        }
        if (duration > 0) {
            Size size = newData.getPainting().renderSize;
            final int i16 = 0;
            if (size != null && (num2 = size.width) != null) {
                i3 = num2.intValue();
            } else {
                i3 = 0;
            }
            Size size2 = newData.getPainting().renderSize;
            if (size2 != null && (num = size2.height) != null) {
                i16 = num.intValue();
            }
            ZootopiaVideoSelectView zootopiaVideoSelectView = this.cutSelectView;
            if (zootopiaVideoSelectView != null) {
                zootopiaVideoSelectView.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.parts.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.S9(c.this, i3, i16);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@Nullable View rootView) {
        ZootopiaVideoSelectView zootopiaVideoSelectView;
        if (rootView instanceof ZootopiaVideoSelectView) {
            zootopiaVideoSelectView = (ZootopiaVideoSelectView) rootView;
        } else {
            zootopiaVideoSelectView = null;
        }
        this.cutSelectView = zootopiaVideoSelectView;
        if (zootopiaVideoSelectView != null) {
            zootopiaVideoSelectView.setOnClipChangedListener(this);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.stickerBorderView = (BorderView) rootView.findViewById(R.id.f88404wz);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.view.ZootopiaVideoSelectView.a
    public void z6(@NotNull GifClipData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        C9().a(data);
    }

    @Override // com.tencent.tavcut.session.d
    public void onRenderDataApplied() {
    }
}
