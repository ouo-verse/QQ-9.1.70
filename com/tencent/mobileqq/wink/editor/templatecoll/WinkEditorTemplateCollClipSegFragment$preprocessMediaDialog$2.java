package com.tencent.mobileqq.wink.editor.templatecoll;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkEditorTemplateCollClipSegFragment$preprocessMediaDialog$2 extends Lambda implements Function0<PhotoListLogicPreDealDialog> {
    final /* synthetic */ WinkEditorTemplateCollClipSegFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClipSegFragment$preprocessMediaDialog$2$a", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$a;", "", "onBackPressed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements PhotoListLogicPreDealDialog.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkEditorTemplateCollClipSegFragment f322455a;

        a(WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment) {
            this.f322455a = winkEditorTemplateCollClipSegFragment;
        }

        @Override // com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog.a
        public void onBackPressed() {
            WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper;
            winkMediaPickerNextStepHelper = this.f322455a.stepHelper;
            winkMediaPickerNextStepHelper.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorTemplateCollClipSegFragment$preprocessMediaDialog$2(WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment) {
        super(0);
        this.this$0 = winkEditorTemplateCollClipSegFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorTemplateCollClipSegFragment this$0, View view) {
        WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        winkMediaPickerNextStepHelper = this$0.stepHelper;
        winkMediaPickerNextStepHelper.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final PhotoListLogicPreDealDialog invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        PhotoListLogicPreDealDialog photoListLogicPreDealDialog = new PhotoListLogicPreDealDialog(requireContext, R.style.f173547a45);
        final WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment = this.this$0;
        photoListLogicPreDealDialog.v(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorTemplateCollClipSegFragment$preprocessMediaDialog$2.b(WinkEditorTemplateCollClipSegFragment.this, view);
            }
        });
        photoListLogicPreDealDialog.u(new a(winkEditorTemplateCollClipSegFragment));
        return photoListLogicPreDealDialog;
    }
}
