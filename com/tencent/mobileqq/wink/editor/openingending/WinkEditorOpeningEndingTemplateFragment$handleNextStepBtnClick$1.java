package com.tencent.mobileqq.wink.editor.openingending;

import android.os.Handler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", IXWebBroadcastListener.STAGE_FINISHED, "", "success", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingTemplateFragment$handleNextStepBtnClick$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ WinkEditorOpeningEndingTemplateFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingTemplateFragment$handleNextStepBtnClick$1(WinkEditorOpeningEndingTemplateFragment winkEditorOpeningEndingTemplateFragment) {
        super(2);
        this.this$0 = winkEditorOpeningEndingTemplateFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WinkEditorOpeningEndingTemplateFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(WinkEditorOpeningEndingTemplateFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), R.string.f241317rj, 0).show();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
        invoke(bool.booleanValue(), bool2.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, boolean z17) {
        this.this$0.Th();
        if (z16) {
            if (z17) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final WinkEditorOpeningEndingTemplateFragment winkEditorOpeningEndingTemplateFragment = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.av
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorOpeningEndingTemplateFragment$handleNextStepBtnClick$1.c(WinkEditorOpeningEndingTemplateFragment.this);
                    }
                });
            } else {
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final WinkEditorOpeningEndingTemplateFragment winkEditorOpeningEndingTemplateFragment2 = this.this$0;
                uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.aw
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorOpeningEndingTemplateFragment$handleNextStepBtnClick$1.d(WinkEditorOpeningEndingTemplateFragment.this);
                    }
                });
            }
        }
    }
}
