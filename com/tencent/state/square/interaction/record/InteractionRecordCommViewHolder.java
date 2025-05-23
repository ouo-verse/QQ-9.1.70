package com.tencent.state.square.interaction.record;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareItemInteractionRecordCommBinding;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.utils.RegexUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordCommViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/state/square/interaction/record/IInteractionRecordViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemInteractionRecordCommBinding;", "reporter", "Lcom/tencent/state/square/IReporter;", "bind", "", "data", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class InteractionRecordCommViewHolder extends RecyclerView.ViewHolder implements IInteractionRecordViewHolder {
    private final VasSquareItemInteractionRecordCommBinding binding;
    private final IReporter reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionRecordCommViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        VasSquareItemInteractionRecordCommBinding bind = VasSquareItemInteractionRecordCommBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquareItemInteraction\u2026ordCommBinding.bind(view)");
        this.binding = bind;
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
    }

    @Override // com.tencent.state.square.interaction.record.IInteractionRecordViewHolder
    public void bind(Object data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof InteractionRecordData)) {
            data = null;
        }
        final InteractionRecordData interactionRecordData = (InteractionRecordData) data;
        if (interactionRecordData != null) {
            TextView textView = this.binding.interactionRecordName;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.interactionRecordName");
            textView.setText(interactionRecordData.getName());
            TextView textView2 = this.binding.interactionRecordTime;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.interactionRecordTime");
            textView2.setText(interactionRecordData.getTime());
            TextView textView3 = this.binding.squareInteractionRecordContent;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.squareInteractionRecordContent");
            textView3.setText(interactionRecordData.getContent());
            TextView textView4 = this.binding.squareInteractionRecordContent;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            textView4.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.f80860));
            TextView textView5 = this.binding.vasSquareInteractionRecordActionText;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.vasSquareInteractionRecordActionText");
            textView5.setText(interactionRecordData.getActionString());
            this.binding.vasSquareInteractionRecordActionIcon.setImageResource(interactionRecordData.getActionIcon());
            IReporter iReporter = this.reporter;
            LinearLayout linearLayout = this.binding.vasSquareInteractionRecordAction;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.vasSquareInteractionRecordAction");
            if (interactionRecordData.isInSquare()) {
                str = SquareReportConst.ElementId.ELEMENT_ID_MSG_BOX_FIND_BTN;
            } else {
                str = SquareReportConst.ElementId.ELEMENT_ID_MSG_BOX_ADD_BTN;
            }
            iReporter.setElementInfo(linearLayout, str, new LinkedHashMap(), false, false);
            this.binding.vasSquareInteractionRecordAction.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.record.InteractionRecordCommViewHolder$bind$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IReporter iReporter2;
                    Map<String, Object> mutableMapOf;
                    InteractionRecordData.this.getAction().invoke();
                    iReporter2 = this.reporter;
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", Long.valueOf(InteractionRecordData.this.getUin())));
                    iReporter2.reportEvent("clck", view, mutableMapOf);
                }
            });
            if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, interactionRecordData.getContentIcon(), false, 2, null)) {
                this.binding.squareInteractionRecordContentIcon.setImageDrawable(URLDrawable.getDrawable(interactionRecordData.getContentIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
            }
            FaceUtils.INSTANCE.loadHeadIcon(Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.interactionRecordHeader, String.valueOf(interactionRecordData.getUin()), false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.interaction.record.InteractionRecordCommViewHolder$bind$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(String str2) {
                    return Boolean.valueOf(invoke2(str2));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(String str2) {
                    return TextUtils.equals(str2, String.valueOf(InteractionRecordData.this.getUin()));
                }
            });
        }
    }
}
