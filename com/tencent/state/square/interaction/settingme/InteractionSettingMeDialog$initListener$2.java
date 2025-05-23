package com.tencent.state.square.interaction.settingme;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.databinding.VasSquareInteractionSettingMeActionBinding;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.interaction.InteractionSettingOption;
import com.tencent.state.utils.FastClickUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionSettingMeDialog$initListener$2 implements View.OnClickListener {
    final /* synthetic */ InteractionSettingMeDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InteractionSettingMeDialog$initListener$2(InteractionSettingMeDialog interactionSettingMeDialog) {
        this.this$0 = interactionSettingMeDialog;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r0 = r11.this$0.currentOption;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        FastClickUtils fastClickUtils;
        boolean z16;
        InteractionSettingOption interactionSettingOption;
        final InteractionSettingOption copy;
        fastClickUtils = this.this$0.clickUtils;
        if (fastClickUtils.isFastDoubleClick()) {
            return;
        }
        z16 = this.this$0.isPublishing;
        if (z16 || interactionSettingOption == null) {
            return;
        }
        this.this$0.isPublishing = true;
        copy = interactionSettingOption.copy((r18 & 1) != 0 ? interactionSettingOption.optionId : 0L, (r18 & 2) != 0 ? interactionSettingOption.optionIcon : null, (r18 & 4) != 0 ? interactionSettingOption.optionText : null, (r18 & 8) != 0 ? interactionSettingOption.fixedText : null, (r18 & 16) != 0 ? interactionSettingOption.customText : null, (r18 & 32) != 0 ? interactionSettingOption.defaultText : null, (r18 & 64) != 0 ? interactionSettingOption.resultMotion : null);
        if (TextUtils.isEmpty(copy.getCustomText())) {
            copy.setCustomText(copy.getDefaultText());
        }
        InteractionManager.INSTANCE.textCheck(copy.getCustomText(), new Function2<Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeDialog$initListener$2$$special$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String msg2) {
                Function2 function2;
                int i16;
                VasSquareInteractionSettingMeActionBinding vasSquareInteractionSettingMeActionBinding;
                Intrinsics.checkNotNullParameter(msg2, "msg");
                this.this$0.isPublishing = false;
                if (i3 == -10032) {
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    commonUtils.showToast(context, R.string.xee, 1);
                    return;
                }
                if (i3 == 0) {
                    function2 = this.this$0.settingDoneCb;
                    InteractionSettingOption interactionSettingOption2 = InteractionSettingOption.this;
                    i16 = this.this$0.hasChangeText;
                    function2.invoke(interactionSettingOption2, Integer.valueOf(i16));
                    vasSquareInteractionSettingMeActionBinding = this.this$0.binding;
                    vasSquareInteractionSettingMeActionBinding.vasSquareInteractionSettingMeInput.clearFocus();
                    this.this$0.dismiss();
                    return;
                }
                ICommonUtils commonUtils2 = Square.INSTANCE.getConfig().getCommonUtils();
                Context context2 = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                commonUtils2.showToast(context2, msg2, 1);
            }
        });
        this.this$0.reportBtn("clck");
    }
}
