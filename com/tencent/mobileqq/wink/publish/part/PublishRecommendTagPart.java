package com.tencent.mobileqq.wink.publish.part;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.publish.util.WinkPublishConfigUtil;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishSettingItemState;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010%R#\u0010,\u001a\n (*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010+R#\u00101\u001a\n (*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b/\u00100R#\u00106\u001a\n (*\u0004\u0018\u000102028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishRecommendTagPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "", "W9", "aa", "", "position", "", "label", "V9", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qqcircle/publish/view/edittext/ExtendEditText;", "d", "Lcom/tencent/biz/qqcircle/publish/view/edittext/ExtendEditText;", "mEditTextView", "e", "Landroid/view/View;", "tagLayoutContainer", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "tagRecyclerView", "Lcom/tencent/mobileqq/wink/publish/adapter/c;", tl.h.F, "Lcom/tencent/mobileqq/wink/publish/adapter/c;", "tagAdapter", "Landroid/widget/TextView;", "i", "Lkotlin/Lazy;", "T9", "()Landroid/widget/TextView;", "recommendTips", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "S9", "()Landroid/view/View;", "recommendIndicator", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "R9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "publishViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "D", "Q9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PartsStateViewModel;", "partsStateViewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel;", "E", "U9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishTagViewModel;", "tagViewModel", UserInfo.SEX_FEMALE, "I", "tagRecomType", "<init>", "()V", "G", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishRecommendTagPart extends j {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy publishViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy partsStateViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy tagViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private int tagRecomType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ExtendEditText mEditTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View tagLayoutContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView tagRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.publish.adapter.c tagAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy recommendTips;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy recommendIndicator;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/publish/part/PublishRecommendTagPart$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f325759d;

        b(int i3) {
            this.f325759d = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = this.f325759d;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.left = 0;
            }
        }
    }

    public PublishRecommendTagPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$recommendTips$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) PublishRecommendTagPart.this.getPartRootView().findViewById(R.id.f71543of);
            }
        });
        this.recommendTips = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$recommendIndicator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return PublishRecommendTagPart.this.getPartRootView().findViewById(R.id.f71293nr);
            }
        });
        this.recommendIndicator = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PublishViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$publishViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishViewModel invoke() {
                return (PublishViewModel) PublishRecommendTagPart.this.getViewModel(PublishViewModel.class);
            }
        });
        this.publishViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<PartsStateViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$partsStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PartsStateViewModel invoke() {
                return (PartsStateViewModel) PublishRecommendTagPart.this.getViewModel(PartsStateViewModel.class);
            }
        });
        this.partsStateViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<PublishTagViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$tagViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishTagViewModel invoke() {
                return (PublishTagViewModel) PublishRecommendTagPart.this.getViewModel(PublishTagViewModel.class);
            }
        });
        this.tagViewModel = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PartsStateViewModel Q9() {
        return (PartsStateViewModel) this.partsStateViewModel.getValue();
    }

    private final PublishViewModel R9() {
        return (PublishViewModel) this.publishViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View S9() {
        Object value = this.recommendIndicator.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-recommendIndicator>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView T9() {
        Object value = this.recommendTips.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-recommendTips>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PublishTagViewModel U9() {
        return (PublishTagViewModel) this.tagViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(int position, String label) {
        boolean isBlank;
        com.tencent.mobileqq.wink.publish.adapter.c cVar;
        View view;
        isBlank = StringsKt__StringsJVMKt.isBlank(label);
        if (isBlank) {
            return;
        }
        try {
            ExtendEditText extendEditText = this.mEditTextView;
            ExtendEditText extendEditText2 = null;
            if (extendEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditTextView");
                extendEditText = null;
            }
            int selectionStart = extendEditText.getSelectionStart();
            ExtendEditText extendEditText3 = this.mEditTextView;
            if (extendEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditTextView");
                extendEditText3 = null;
            }
            int selectionEnd = extendEditText3.getSelectionEnd();
            String str = "#" + label + " ";
            ExtendEditText extendEditText4 = this.mEditTextView;
            if (extendEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditTextView");
                extendEditText4 = null;
            }
            extendEditText4.getText().replace(selectionStart, selectionEnd, str);
            ExtendEditText extendEditText5 = this.mEditTextView;
            if (extendEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditTextView");
            } else {
                extendEditText2 = extendEditText5;
            }
            extendEditText2.setSelection(selectionStart + str.length());
            if (this.tagRecomType == 1 && (cVar = this.tagAdapter) != null) {
                cVar.k0(position);
                if (cVar.getNUM_BACKGOURND_ICON() <= 0 && (view = this.tagLayoutContainer) != null) {
                    view.setVisibility(8);
                }
            }
        } catch (Exception e16) {
            QLog.e("PublishRecommendTagPart", 1, "[insertRecommendTag]", e16);
        }
    }

    private final void W9() {
        if (!R9().A2()) {
            MutableLiveData<ArrayList<LocalMediaInfo>> mutableLiveData = R9().C;
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<ArrayList<LocalMediaInfo>, Unit> function1 = new Function1<ArrayList<LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$observeData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<LocalMediaInfo> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ArrayList<LocalMediaInfo> arrayList) {
                    PublishTagViewModel U9;
                    U9 = PublishRecommendTagPart.this.U9();
                    U9.c2(arrayList);
                }
            };
            mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.az
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PublishRecommendTagPart.X9(Function1.this, obj);
                }
            });
        }
        LiveData<PublishTagViewModel.TagData> R1 = U9().R1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final PublishRecommendTagPart$observeData$2 publishRecommendTagPart$observeData$2 = new PublishRecommendTagPart$observeData$2(this);
        R1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.ba
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishRecommendTagPart.Y9(Function1.this, obj);
            }
        });
        MediatorLiveData<PublishSettingItemState> h26 = Q9().h2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<PublishSettingItemState, Unit> function12 = new Function1<PublishSettingItemState, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$observeData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishSettingItemState publishSettingItemState) {
                invoke2(publishSettingItemState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishSettingItemState publishSettingItemState) {
                View view;
                view = PublishRecommendTagPart.this.tagLayoutContainer;
                if (view == null) {
                    return;
                }
                view.setVisibility(publishSettingItemState.getVisible() ? 0 : 8);
            }
        };
        h26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishRecommendTagPart.Z9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa() {
        View view = this.tagLayoutContainer;
        if (view == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ObjectAnimator.ofFloat(view, "translationY", ViewExKt.d(-16), 0.0f));
        animatorSet.start();
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishRecommendTagPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.bys);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.et_content)");
        this.mEditTextView = (ExtendEditText) findViewById;
        this.tagLayoutContainer = rootView.findViewById(R.id.f71503ob);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f71513oc);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new b(ViewExKt.d(4) * 2));
            com.tencent.mobileqq.wink.publish.adapter.c cVar = new com.tencent.mobileqq.wink.publish.adapter.c(new Function2<Integer, LabelInfo, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishRecommendTagPart$onInitView$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, LabelInfo labelInfo) {
                    invoke(num.intValue(), labelInfo);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull LabelInfo tagInfo) {
                    PublishTagViewModel U9;
                    ExtendEditText extendEditText;
                    Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
                    U9 = PublishRecommendTagPart.this.U9();
                    if (U9.X1()) {
                        extendEditText = PublishRecommendTagPart.this.mEditTextView;
                        if (extendEditText == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mEditTextView");
                            extendEditText = null;
                        }
                        String obj = extendEditText.getText().toString();
                        WinkPublishConfigUtil winkPublishConfigUtil = WinkPublishConfigUtil.f325969a;
                        int size = winkPublishConfigUtil.f(obj).size();
                        if (size >= winkPublishConfigUtil.e()) {
                            QLog.d("PublishRecommendTagPart", 1, "[on adapter item click] exceed max tag count, " + size);
                            QCircleToast.k(QCircleToast.f91644d, winkPublishConfigUtil.d(), 0, true);
                            return;
                        }
                    }
                    PublishRecommendTagPart publishRecommendTagPart = PublishRecommendTagPart.this;
                    String str = tagInfo.name;
                    Intrinsics.checkNotNullExpressionValue(str, "tagInfo.name");
                    publishRecommendTagPart.V9(i3, str);
                }
            });
            this.tagAdapter = cVar;
            recyclerView.setAdapter(cVar);
        } else {
            recyclerView = null;
        }
        this.tagRecyclerView = recyclerView;
        W9();
    }
}
