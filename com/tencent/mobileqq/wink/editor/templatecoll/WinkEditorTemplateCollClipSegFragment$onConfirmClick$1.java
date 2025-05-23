package com.tencent.mobileqq.wink.editor.templatecoll;

import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/b;", "it", "", "invoke", "(Lcom/tencent/mobileqq/wink/picker/b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes21.dex */
final class WinkEditorTemplateCollClipSegFragment$onConfirmClick$1 extends Lambda implements Function1<MediaPickerOutput, Unit> {
    final /* synthetic */ Intent $data;
    final /* synthetic */ WinkEditorTemplateCollClipSegFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorTemplateCollClipSegFragment$onConfirmClick$1(Intent intent, WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment) {
        super(1);
        this.$data = intent;
        this.this$0 = winkEditorTemplateCollClipSegFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorTemplateCollClipSegFragment this$0, Intent data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Fragment targetFragment = this$0.getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(100, 202, data);
        }
        this$0.Gh();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
        invoke2(mediaPickerOutput);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull MediaPickerOutput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$data.putExtra("ARG_NEED_REPLACE_MEDIA", true);
        this.$data.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_INDEX, this.this$0.getMediaIndex());
        this.$data.putExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL, new ArrayList(it.f()));
        Intent intent = this.$data;
        TemplateLibraryHolderInfo holderInfo = this.this$0.getHolderInfo();
        intent.putExtra(QQWinkConstants.MEDIA_PICKER_TEMPLATE_LIBRARY_HOLDER_TIME_SLOT, holderInfo != null ? holderInfo.getHolderTimeSlot() : 0.0f);
        this.$data.putExtra("key_template_asset", it.getVideoTemplateData().getTemplateJsAsset());
        List<LocalMediaInfo> e16 = it.e();
        if (e16 != null) {
            this.$data.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(e16));
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment = this.this$0;
        final Intent intent2 = this.$data;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.m
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorTemplateCollClipSegFragment$onConfirmClick$1.b(WinkEditorTemplateCollClipSegFragment.this, intent2);
            }
        });
    }
}
