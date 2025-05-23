package com.tencent.mobileqq.flock.publish.part;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.publish.part.FlockPublishTimePart$pickerSheetBottomConfig$2;
import com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel;
import com.tencent.mobileqq.flock.widget.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0001\u000e\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishTimePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "L9", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "d", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "uiViewModel", "com/tencent/mobileqq/flock/publish/part/FlockPublishTimePart$pickerSheetBottomConfig$2$a", "e", "E9", "()Lcom/tencent/mobileqq/flock/publish/part/FlockPublishTimePart$pickerSheetBottomConfig$2$a;", "pickerSheetBottomConfig", "<init>", "()V", "f", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishTimePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pickerSheetBottomConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishTimePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.part.FlockPublishTimePart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishTimePart$b", "Lcom/tencent/mobileqq/flock/widget/g$c;", "", "onDismiss", "", "", "selectItems", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements g.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishTimePart.this);
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.g.c
        public void a(@NotNull List<Integer> selectItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) selectItems);
                return;
            }
            Intrinsics.checkNotNullParameter(selectItems, "selectItems");
            if (!FlockPublishTimePart.this.F9().w2(selectItems)) {
                QQToastUtil.showQQToast(1, "\u5f00\u59cb\u65f6\u95f4\u4e0d\u53ef\u665a\u4e8e\u7ed3\u675f\u65f6\u95f4");
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.g.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishTimePart$c", "Lcom/tencent/mobileqq/flock/widget/g$c;", "", "onDismiss", "", "", "selectItems", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements g.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishTimePart.this);
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.g.c
        public void a(@NotNull List<Integer> selectItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) selectItems);
                return;
            }
            Intrinsics.checkNotNullParameter(selectItems, "selectItems");
            FlockPublishTimePart.this.F9().z2(selectItems);
            if (FlockPublishTimePart.this.F9().X1().getValue() == null) {
                FlockPublishTimePart.this.K9();
            }
        }

        @Override // com.tencent.mobileqq.flock.widget.g.c
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockPublishTimePart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishUIStateViewModel>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishTimePart$uiViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishTimePart.this);
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
                    FlockPublishTimePart flockPublishTimePart = FlockPublishTimePart.this;
                    Intent intent = flockPublishTimePart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.f(flockPublishTimePart, intent);
                }
            });
            this.uiViewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishTimePart$pickerSheetBottomConfig$2.a>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishTimePart$pickerSheetBottomConfig$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishTimePart$pickerSheetBottomConfig$2$a", "Lcom/tencent/mobileqq/flock/widget/g$a;", "", "a", "", "b", "", "c", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes12.dex */
                public static final class a implements g.a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ FlockPublishTimePart f210298a;

                    a(FlockPublishTimePart flockPublishTimePart) {
                        this.f210298a = flockPublishTimePart;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) flockPublishTimePart);
                        }
                    }

                    @Override // com.tencent.mobileqq.flock.widget.g.a
                    public boolean a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                        }
                        return true;
                    }

                    @Override // com.tencent.mobileqq.flock.widget.g.a
                    public int b() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                        }
                        return R.string.f199174op;
                    }

                    @Override // com.tencent.mobileqq.flock.widget.g.a
                    public void c() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this);
                        } else {
                            this.f210298a.F9().v2();
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishTimePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(FlockPublishTimePart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.pickerSheetBottomConfig = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final FlockPublishTimePart$pickerSheetBottomConfig$2.a E9() {
        return (FlockPublishTimePart$pickerSheetBottomConfig$2.a) this.pickerSheetBottomConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FlockPublishUIStateViewModel F9() {
        return (FlockPublishUIStateViewModel) this.uiViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(FlockPublishTimePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(FlockPublishTimePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.F9().l2().getValue() == null) {
            this$0.L9();
        } else {
            this$0.K9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new com.tencent.mobileqq.flock.widget.g(context, F9().Z1(), new b(), E9()).m();
    }

    private final void L9() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new com.tencent.mobileqq.flock.widget.g(context, F9().m2(), new c(), null, 8, null).m();
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
        final TextView textView = (TextView) rootView.findViewById(R.id.vbz);
        LiveData<String> l26 = F9().l2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>(textView) { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishTimePart$onInitView$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = textView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) textView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                this.$this_apply.setText(str);
                TextView textView2 = this.$this_apply;
                textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.qui_common_text_primary));
            }
        };
        l26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishTimePart.G9(Function1.this, obj);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlockPublishTimePart.H9(FlockPublishTimePart.this, view);
            }
        });
        final TextView textView2 = (TextView) rootView.findViewById(R.id.vby);
        LiveData<String> X1 = F9().X1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>(textView2) { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishTimePart$onInitView$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextView $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = textView2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) textView2);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                    return;
                }
                this.$this_apply.setText(str);
                TextView textView3 = this.$this_apply;
                textView3.setTextColor(textView3.getContext().getResources().getColor(R.color.qui_common_text_primary));
            }
        };
        X1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishTimePart.I9(Function1.this, obj);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlockPublishTimePart.J9(FlockPublishTimePart.this, view);
            }
        });
    }
}
