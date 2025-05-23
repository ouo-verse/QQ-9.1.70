package com.tencent.mobileqq.flock.publish.part;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishPrivacyPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "d", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "uiViewModel", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishPrivacyPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiViewModel;

    public FlockPublishPrivacyPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishUIStateViewModel>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishPrivacyPart$uiViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishPrivacyPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FlockPublishUIStateViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FlockPublishUIStateViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockPublishPrivacyPart flockPublishPrivacyPart = FlockPublishPrivacyPart.this;
                    Intent intent = flockPublishPrivacyPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.f(flockPublishPrivacyPart, intent);
                }
            });
            this.uiViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final FlockPublishUIStateViewModel A9() {
        return (FlockPublishUIStateViewModel) this.uiViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(FlockPublishPrivacyPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(compoundButton.getTag(), Boolean.TRUE)) {
            compoundButton.setTag(Boolean.FALSE);
        } else {
            this$0.A9().C2(z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
        final Switch r46 = (Switch) rootView.findViewById(R.id.vbh);
        r46.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.flock.publish.part.y
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                FlockPublishPrivacyPart.B9(FlockPublishPrivacyPart.this, compoundButton, z16);
            }
        });
        LiveData<Boolean> d26 = A9().d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishPrivacyPart$onInitView$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Switch.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    if (Intrinsics.areEqual(Boolean.valueOf(Switch.this.isChecked()), it)) {
                        return;
                    }
                    Switch.this.setTag(Boolean.TRUE);
                    Switch r06 = Switch.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    r06.setChecked(it.booleanValue());
                }
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishPrivacyPart.C9(Function1.this, obj);
            }
        });
    }
}
