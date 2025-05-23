package com.tencent.mobileqq.wink.preview.part.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\tH&J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0004R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewMediaPart;", "Lp53/a;", "", "M9", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel$b;", "data", "E9", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "L9", "Lcom/tencent/image/URLDrawable;", "J9", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "initView", "Q9", "Landroidx/cardview/widget/CardView;", "d", "Landroidx/cardview/widget/CardView;", "K9", "()Landroidx/cardview/widget/CardView;", "V9", "(Landroidx/cardview/widget/CardView;)V", "playerFrame", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "G9", "()Landroid/widget/TextView;", "T9", "(Landroid/widget/TextView;)V", "errorRetry", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "H9", "()Landroid/widget/ImageView;", "U9", "(Landroid/widget/ImageView;)V", "loadingBg", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", tl.h.F, "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "I9", "()Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "setLoadingDialog", "(Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;)V", "loadingDialog", "Lcom/tencent/mobileqq/wink/editor/dr;", "i", "Lcom/tencent/mobileqq/wink/editor/dr;", "F9", "()Lcom/tencent/mobileqq/wink/editor/dr;", "S9", "(Lcom/tencent/mobileqq/wink/editor/dr;)V", "cut", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkBaseSharePreviewMediaPart extends p53.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected CardView playerFrame;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected TextView errorRetry;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected ImageView loadingBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected dr cut;

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(WinkBasePreviewShareViewModel.PreviewData data) {
        w53.b.a(getTAG(), "buildPreview: " + data.getWinkEditDataWrapper());
        WinkEditorResourceManager.a1().i0(data.getMaterial());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WinkPlayerContainerView winkPlayerContainerView = new WinkPlayerContainerView(context);
        K9().addView(winkPlayerContainerView);
        S9(WinkPlayerContainerView.f(winkPlayerContainerView, data.getWinkTavCutParams(), null, null, false, null, 30, null));
        F9().setAutoPlay(true);
        dr F9 = F9();
        Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
        ((WinkVideoTavCut) F9).Q2(new a());
    }

    private final void M9() {
        LiveData<Result<WinkBasePreviewShareViewModel.PreviewData>> U1 = L9().U1();
        BasePartFragment hostFragment = getHostFragment();
        final Function1<Result<? extends WinkBasePreviewShareViewModel.PreviewData>, Unit> function1 = new Function1<Result<? extends WinkBasePreviewShareViewModel.PreviewData>, Unit>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends WinkBasePreviewShareViewModel.PreviewData> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends WinkBasePreviewShareViewModel.PreviewData> it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!Result.m483isSuccessimpl(it.getValue())) {
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(it.getValue());
                    if (m479exceptionOrNullimpl != null) {
                        WinkBaseSharePreviewMediaPart winkBaseSharePreviewMediaPart = WinkBaseSharePreviewMediaPart.this;
                        if (m479exceptionOrNullimpl instanceof CancellationException) {
                            return;
                        }
                        w53.b.d(winkBaseSharePreviewMediaPart.getTAG(), "observa video prepare fail", m479exceptionOrNullimpl);
                        winkBaseSharePreviewMediaPart.G9().setVisibility(0);
                        QCircleCommonLoadingDialog loadingDialog = winkBaseSharePreviewMediaPart.getLoadingDialog();
                        if (loadingDialog != null) {
                            loadingDialog.dismiss();
                            return;
                        }
                        return;
                    }
                    return;
                }
                WinkBaseSharePreviewMediaPart winkBaseSharePreviewMediaPart2 = WinkBaseSharePreviewMediaPart.this;
                Object value = it.getValue();
                ResultKt.throwOnFailure(value);
                winkBaseSharePreviewMediaPart2.E9((WinkBasePreviewShareViewModel.PreviewData) value);
            }
        };
        U1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.preview.part.base.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkBaseSharePreviewMediaPart.N9(Function1.this, obj);
            }
        });
        LiveData<t73.a<WinkBasePreviewShareViewModel.c>> W1 = L9().W1();
        BasePartFragment hostFragment2 = getHostFragment();
        final Function1<t73.a<? extends WinkBasePreviewShareViewModel.c>, Unit> function12 = new Function1<t73.a<? extends WinkBasePreviewShareViewModel.c>, Unit>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart$initObserve$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(t73.a<? extends WinkBasePreviewShareViewModel.c> aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(t73.a<? extends WinkBasePreviewShareViewModel.c> aVar) {
                QCircleCommonLoadingDialog loadingDialog;
                if (!Intrinsics.areEqual(aVar.b(), WinkBasePreviewShareViewModel.c.d.f325447a) || (loadingDialog = WinkBaseSharePreviewMediaPart.this.getLoadingDialog()) == null) {
                    return;
                }
                loadingDialog.dismiss();
            }
        };
        W1.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.preview.part.base.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkBaseSharePreviewMediaPart.O9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(WinkBaseSharePreviewMediaPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(WinkBaseSharePreviewMediaPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    protected final dr F9() {
        dr drVar = this.cut;
        if (drVar != null) {
            return drVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cut");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView G9() {
        TextView textView = this.errorRetry;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("errorRetry");
        return null;
    }

    @NotNull
    protected final ImageView H9() {
        ImageView imageView = this.loadingBg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingBg");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: I9, reason: from getter */
    public final QCircleCommonLoadingDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    @NotNull
    public abstract URLDrawable J9();

    @NotNull
    protected final CardView K9() {
        CardView cardView = this.playerFrame;
        if (cardView != null) {
            return cardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("playerFrame");
        return null;
    }

    @NotNull
    public abstract WinkBasePreviewShareViewModel L9();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q9() {
        if (!NetworkUtil.isNetSupport(getContext())) {
            G9().setVisibility(0);
            w53.b.c(BlockPart.TAG, "preparePreview: net error");
            return;
        }
        G9().setVisibility(8);
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).n(false).h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.preview.part.base.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkBaseSharePreviewMediaPart.R9(WinkBaseSharePreviewMediaPart.this, view);
            }
        }).p(getContext().getResources().getString(R.string.f216385y6)).j("photowall_share_preview").a();
        this.loadingDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    protected final void S9(@NotNull dr drVar) {
        Intrinsics.checkNotNullParameter(drVar, "<set-?>");
        this.cut = drVar;
    }

    protected final void T9(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.errorRetry = textView;
    }

    protected final void U9(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.loadingBg = imageView;
    }

    protected final void V9(@NotNull CardView cardView) {
        Intrinsics.checkNotNullParameter(cardView, "<set-?>");
        this.playerFrame = cardView;
    }

    public final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.f25850by);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.player_frame)");
        V9((CardView) findViewById);
        View findViewById2 = getPartRootView().findViewById(R.id.uwl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.errorRetry)");
        T9((TextView) findViewById2);
        View findViewById3 = getPartRootView().findViewById(R.id.ef9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.loading_bg)");
        U9((ImageView) findViewById3);
        H9().setImageDrawable(J9());
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.oeo);
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewExKt.d(16), ViewExKt.d(16));
            G9().setCompoundDrawables(drawable, null, null, null);
            G9().setCompoundDrawablePadding(ViewExKt.d(4));
        }
        TextViewCompat.setCompoundDrawableTintList(G9(), ColorStateList.valueOf(-1));
        G9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.preview.part.base.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkBaseSharePreviewMediaPart.P9(WinkBaseSharePreviewMediaPart.this, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View mRootView) {
        super.onInitView(mRootView);
        initView();
        M9();
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        if (this.cut != null) {
            F9().release();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewMediaPart$a", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "", "a", "I", "firstTimes", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements IRenderTimeListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int firstTimes;

        a() {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
            if (this.firstTimes > 1) {
                return;
            }
            ICutSession session = WinkBaseSharePreviewMediaPart.this.F9().getSession();
            if (this.firstTimes > 0 && session != null) {
                WinkBasePreviewShareViewModel L9 = WinkBaseSharePreviewMediaPart.this.L9();
                dr F9 = WinkBaseSharePreviewMediaPart.this.F9();
                Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.WinkVideoTavCut");
                L9.c2(session, ((WinkVideoTavCut) F9).r1());
            }
            this.firstTimes++;
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }
    }
}
