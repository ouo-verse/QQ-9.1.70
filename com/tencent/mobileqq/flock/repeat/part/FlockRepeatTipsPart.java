package com.tencent.mobileqq.flock.repeat.part;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/part/FlockRepeatTipsPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "Landroid/view/ViewGroup;", "viewGroup", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/flock/repeat/b;", "d", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/flock/repeat/b;", "viewModel", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tipsView", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockRepeatTipsPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tipsView;

    public FlockRepeatTipsPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.repeat.b>() { // from class: com.tencent.mobileqq.flock.repeat.part.FlockRepeatTipsPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockRepeatTipsPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.flock.repeat.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.repeat.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockRepeatTipsPart flockRepeatTipsPart = FlockRepeatTipsPart.this;
                    Intent intent = flockRepeatTipsPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.d(flockRepeatTipsPart, intent);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A9(ViewGroup viewGroup) {
        TextView textView = new TextView(getContext());
        int dpToPx = ViewUtils.dpToPx(16.0f);
        int dpToPx2 = ViewUtils.dpToPx(6.0f);
        textView.setPadding(dpToPx, dpToPx2, dpToPx, dpToPx2);
        textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_secondary));
        textView.setTextSize(0, textView.getResources().getDimension(R.dimen.aw5));
        this.tipsView = textView;
        viewGroup.addView(textView);
    }

    private final com.tencent.mobileqq.flock.repeat.b B9() {
        return (com.tencent.mobileqq.flock.repeat.b) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(FlockRepeatTipsPart this$0, FlockRepeatType flockRepeatType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(FlockRepeatTipsPart this$0, Date date) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
    }

    private final void E9() {
        TextView textView = this.tipsView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            textView = null;
        }
        textView.setText(B9().N1());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        A9((ViewGroup) rootView);
        B9().R1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.flock.repeat.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockRepeatTipsPart.C9(FlockRepeatTipsPart.this, (FlockRepeatType) obj);
            }
        });
        B9().O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.flock.repeat.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockRepeatTipsPart.D9(FlockRepeatTipsPart.this, (Date) obj);
            }
        });
    }
}
