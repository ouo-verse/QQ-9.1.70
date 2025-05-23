package com.tencent.mobileqq.flock.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishRepeatPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "d", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "uiViewModel", "e", "Landroid/view/View;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "repeatDesc", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishRepeatPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView repeatDesc;

    public FlockPublishRepeatPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishUIStateViewModel>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishRepeatPart$uiViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishRepeatPart.this);
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
                    FlockPublishRepeatPart flockPublishRepeatPart = FlockPublishRepeatPart.this;
                    Intent intent = flockPublishRepeatPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.f(flockPublishRepeatPart, intent);
                }
            });
            this.uiViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final FlockPublishUIStateViewModel C9() {
        return (FlockPublishUIStateViewModel) this.uiViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(FlockPublishRepeatPart this$0, FlockRepeatType flockRepeatType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(FlockPublishRepeatPart this$0, Date date) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(FlockPublishRepeatPart this$0, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = null;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                View view2 = this$0.container;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                } else {
                    view = view2;
                }
                view.setVisibility(0);
                return;
            }
        }
        View view3 = this$0.container;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9() {
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.f(activity, C9().k2(), C9().i2(), C9().W1());
    }

    private final void H9() {
        TextView textView = this.repeatDesc;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repeatDesc");
            textView = null;
        }
        textView.setText(C9().g2());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Serializable serializable;
        FlockRepeatType flockRepeatType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            Date date = null;
            if (data != null) {
                serializable = data.getSerializableExtra("key_flock_repeat_type");
            } else {
                serializable = null;
            }
            if (serializable instanceof FlockRepeatType) {
                flockRepeatType = (FlockRepeatType) serializable;
            } else {
                flockRepeatType = null;
            }
            if (flockRepeatType == null) {
                return;
            }
            C9().y2(flockRepeatType);
            Serializable serializableExtra = data.getSerializableExtra("key_flock_repeat_end_time");
            if (serializableExtra instanceof Date) {
                date = (Date) serializableExtra;
            }
            C9().x2(date);
        }
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
        View onInitView$lambda$0 = rootView.findViewById(R.id.vbr);
        Intrinsics.checkNotNullExpressionValue(onInitView$lambda$0, "onInitView$lambda$0");
        com.tencent.mobileqq.flock.ktx.i.d(onInitView$lambda$0, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishRepeatPart$onInitView$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishRepeatPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    FlockPublishRepeatPart.this.G9();
                }
            }
        }, 1, null);
        onInitView$lambda$0.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(onInitView$lambda$0, "rootView.findViewById<Vi\u2026ity = View.GONE\n        }");
        this.container = onInitView$lambda$0;
        View findViewById = rootView.findViewById(R.id.vbq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lock_publish_repeat_name)");
        this.repeatDesc = (TextView) findViewById;
        C9().j2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishRepeatPart.D9(FlockPublishRepeatPart.this, (FlockRepeatType) obj);
            }
        });
        C9().h2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishRepeatPart.E9(FlockPublishRepeatPart.this, (Date) obj);
            }
        });
        C9().l2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishRepeatPart.F9(FlockPublishRepeatPart.this, (String) obj);
            }
        });
    }
}
