package com.tencent.mobileqq.flock.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishTopicPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "F9", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivTopic", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "topicTv", "f", "closeIv", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", tl.h.F, "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "uiViewModel", "<init>", "()V", "i", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishTopicPart extends Part {
    static IPatchRedirector $redirector_;
    private static final int C;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static final int f210300m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivTopic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView topicTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView closeIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishTopicPart$a;", "", "", "TOPIC_SEARCH_REQUEST_CODE", "I", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.part.FlockPublishTopicPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        f210300m = Color.parseColor("#FF000000");
        C = Color.parseColor("#FFFFFFFF");
    }

    public FlockPublishTopicPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishUIStateViewModel>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishTopicPart$uiViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishTopicPart.this);
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
                    FlockPublishTopicPart flockPublishTopicPart = FlockPublishTopicPart.this;
                    Intent intent = flockPublishTopicPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.f(flockPublishTopicPart, intent);
                }
            });
            this.uiViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final FlockPublishUIStateViewModel E9() {
        return (FlockPublishUIStateViewModel) this.uiViewModel.getValue();
    }

    private final void F9() {
        LiveData<b55.g> n26 = E9().n2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<b55.g, Unit> function1 = new Function1<b55.g, Unit>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishTopicPart$observerData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishTopicPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b55.g gVar) {
                invoke2(gVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable b55.g gVar) {
                Unit unit;
                TextView textView;
                ImageView imageView;
                ImageView imageView2;
                TextView textView2;
                ImageView imageView3;
                ImageView imageView4;
                ImageView imageView5;
                Map mutableMapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                    return;
                }
                ImageView imageView6 = null;
                if (gVar != null) {
                    FlockPublishTopicPart flockPublishTopicPart = FlockPublishTopicPart.this;
                    textView2 = flockPublishTopicPart.topicTv;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicTv");
                        textView2 = null;
                    }
                    textView2.setText("#" + gVar.f27974b);
                    imageView3 = flockPublishTopicPart.closeIv;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIv");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(0);
                    imageView4 = flockPublishTopicPart.ivTopic;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivTopic");
                        imageView4 = null;
                    }
                    imageView4.setVisibility(8);
                    imageView5 = flockPublishTopicPart.closeIv;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIv");
                        imageView5 = null;
                    }
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("activity_topic", gVar.f27974b));
                    VideoReport.setElementParams(imageView5, mutableMapOf);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    FlockPublishTopicPart flockPublishTopicPart2 = FlockPublishTopicPart.this;
                    textView = flockPublishTopicPart2.topicTv;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicTv");
                        textView = null;
                    }
                    textView.setText("\u6dfb\u52a0\u8bdd\u9898");
                    imageView = flockPublishTopicPart2.closeIv;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("closeIv");
                        imageView = null;
                    }
                    imageView.setVisibility(8);
                    imageView2 = flockPublishTopicPart2.ivTopic;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivTopic");
                    } else {
                        imageView6 = imageView2;
                    }
                    imageView6.setVisibility(0);
                }
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.publish.part.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockPublishTopicPart.G9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(FlockPublishTopicPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9().E2(null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.k(activity, 10000);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        byte[] byteArrayExtra;
        b55.g d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10000 && resultCode == -1 && data != null && (byteArrayExtra = data.getByteArrayExtra("KEY_RESULT_FOR_TOPIC")) != null && (d16 = b55.g.d(byteArrayExtra)) != null) {
            E9().E2(d16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.vbw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026flock_publish_topic_part)");
        com.tencent.mobileqq.flock.ktx.i.d(findViewById, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishTopicPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishTopicPart.this);
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
                    FlockPublishTopicPart.this.I9();
                }
            }
        }, 1, null);
        View findViewById2 = rootView.findViewById(R.id.y_6);
        ImageView imageView = (ImageView) findViewById2;
        Drawable drawable = imageView.getDrawable();
        com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
        if (QQTheme.isNowThemeIsNight()) {
            i3 = C;
        } else {
            i3 = f210300m;
        }
        Drawable e16 = a16.e(drawable, i3);
        if (e16 != null) {
            imageView.setImageDrawable(e16);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Im\u2026)\n            }\n        }");
        this.ivTopic = imageView;
        View findViewById3 = rootView.findViewById(R.id.juh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.topic_title)");
        this.topicTv = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f100235ry);
        ImageView imageView2 = (ImageView) findViewById4;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlockPublishTopicPart.H9(FlockPublishTopicPart.this, view);
            }
        });
        VideoReport.setElementId(imageView2, "em_bas_delete_topic");
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<Im\u2026S_DELETE_TOPIC)\n        }");
        this.closeIv = imageView2;
        F9();
    }
}
