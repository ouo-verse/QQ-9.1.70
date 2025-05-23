package com.tencent.mobileqq.wink.editor.mosaic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010/\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R#\u0010=\u001a\n 8*\u0004\u0018\u000107078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/WinkEditorMosaicContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lq83/a;", "", "M9", "P9", "U9", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", "Lkotlin/collections/ArrayList;", "result", "", "isCancel", "O9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "onBackEvent", "", "unDoSize", "redoSize", "y4", "Lcom/tencent/mobileqq/wink/editor/mosaic/MosaicLayout;", "d", "Lcom/tencent/mobileqq/wink/editor/mosaic/MosaicLayout;", "mosaicLayout", "Lcom/tencent/widget/HorizontalListView;", "e", "Lcom/tencent/widget/HorizontalListView;", "horizontalListView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivConfirm", tl.h.F, "ivCancel", "i", "ivUndo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ivRestore", "Lz63/a;", BdhLogUtil.LogTag.Tag_Conn, "Lz63/a;", "videoListViewAdapter", "D", "I", "lastSelectIndex", "La73/a;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", "N9", "()La73/a;", "mosaicViewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorMosaicContentPart extends Part implements View.OnClickListener, q83.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private z63.a videoListViewAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastSelectIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mosaicViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MosaicLayout mosaicLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HorizontalListView horizontalListView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivConfirm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCancel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivUndo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivRestore;

    public WinkEditorMosaicContentPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a73.a>() { // from class: com.tencent.mobileqq.wink.editor.mosaic.WinkEditorMosaicContentPart$mosaicViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a73.a invoke() {
                return (a73.a) WinkEditorMosaicContentPart.this.getViewModel(a73.a.class);
            }
        });
        this.mosaicViewModel = lazy;
    }

    private final void M9() {
        ImageView imageView = this.ivConfirm;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivConfirm");
            imageView = null;
        }
        VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_MOSAIC_SUBMIT_BUTTON);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        ImageView imageView3 = this.ivConfirm;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivConfirm");
        } else {
            imageView2 = imageView3;
        }
        VideoReport.setElementParams(imageView2, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a73.a N9() {
        return (a73.a) this.mosaicViewModel.getValue();
    }

    private final void O9(ArrayList<MosaicData> result, boolean isCancel) {
        com.tencent.mobileqq.wink.editor.a aVar;
        FragmentManager childFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        w53.b.a("WinkEditorMosaicContentPart", "goBackToWinkEditorFragment result = " + result + " isCancel:" + isCancel);
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQWinkConstants.IS_FROM_MOSAIC, true);
        bundle.putBoolean("KEY_IS_CANCEL", isCancel);
        bundle.putSerializable("KEY_MEDIA_MOSAIC_RESULT", result);
        ActivityResultCaller parentFragment = getHostFragment().getParentFragment();
        if (parentFragment instanceof WinkEditorFragment) {
            WinkEditorFragment winkEditorFragment = (WinkEditorFragment) parentFragment;
            if (winkEditorFragment.getArguments() == null) {
                winkEditorFragment.setArguments(new Bundle());
            }
            Bundle arguments = winkEditorFragment.getArguments();
            if (arguments != null) {
                arguments.putAll(bundle);
            }
            Fragment parentFragment2 = getHostFragment().getParentFragment();
            if (parentFragment2 != null && (childFragmentManager = parentFragment2.getChildFragmentManager()) != null && (beginTransaction = childFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(getHostFragment())) != null) {
                remove.commit();
            }
            if (parentFragment instanceof com.tencent.mobileqq.wink.editor.a) {
                aVar = (com.tencent.mobileqq.wink.editor.a) parentFragment;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.g1(false);
                return;
            }
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void P9() {
        LiveData<ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a>> T1 = N9().T1();
        Fragment hostFragment = getHostFragment();
        final WinkEditorMosaicContentPart$observerLiveData$1 winkEditorMosaicContentPart$observerLiveData$1 = new WinkEditorMosaicContentPart$observerLiveData$1(this);
        T1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.editor.mosaic.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMosaicContentPart.Q9(Function1.this, obj);
            }
        });
        LiveData<Integer> Q1 = N9().Q1();
        Fragment hostFragment2 = getHostFragment();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.editor.mosaic.WinkEditorMosaicContentPart$observerLiveData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                MosaicLayout mosaicLayout;
                a73.a N9;
                MosaicLayout mosaicLayout2;
                WinkEditorMosaicContentPart winkEditorMosaicContentPart = WinkEditorMosaicContentPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkEditorMosaicContentPart.lastSelectIndex = it.intValue();
                mosaicLayout = WinkEditorMosaicContentPart.this.mosaicLayout;
                MosaicLayout mosaicLayout3 = null;
                if (mosaicLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
                    mosaicLayout = null;
                }
                N9 = WinkEditorMosaicContentPart.this.N9();
                mosaicLayout.setData(N9, it.intValue());
                mosaicLayout2 = WinkEditorMosaicContentPart.this.mosaicLayout;
                if (mosaicLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
                } else {
                    mosaicLayout3 = mosaicLayout2;
                }
                mosaicLayout3.setMosaicPaintUpdateCallback(WinkEditorMosaicContentPart.this);
                WinkEditorMosaicContentPart.this.U9();
            }
        };
        Q1.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.mosaic.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMosaicContentPart.R9(Function1.this, obj);
            }
        });
        LiveData<Boolean> S1 = N9().S1();
        Fragment hostFragment3 = getHostFragment();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.mosaic.WinkEditorMosaicContentPart$observerLiveData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                ImageView imageView4;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ImageView imageView5 = null;
                if (it.booleanValue()) {
                    imageView3 = WinkEditorMosaicContentPart.this.ivUndo;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                        imageView3 = null;
                    }
                    imageView3.setAlpha(1.0f);
                    imageView4 = WinkEditorMosaicContentPart.this.ivUndo;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                    } else {
                        imageView5 = imageView4;
                    }
                    imageView5.setClickable(true);
                    return;
                }
                imageView = WinkEditorMosaicContentPart.this.ivUndo;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                    imageView = null;
                }
                imageView.setAlpha(0.1f);
                imageView2 = WinkEditorMosaicContentPart.this.ivUndo;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                } else {
                    imageView5 = imageView2;
                }
                imageView5.setClickable(false);
            }
        };
        S1.observe(hostFragment3, new Observer() { // from class: com.tencent.mobileqq.wink.editor.mosaic.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMosaicContentPart.S9(Function1.this, obj);
            }
        });
        LiveData<Boolean> R1 = N9().R1();
        Fragment hostFragment4 = getHostFragment();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.mosaic.WinkEditorMosaicContentPart$observerLiveData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                ImageView imageView4;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ImageView imageView5 = null;
                if (it.booleanValue()) {
                    imageView3 = WinkEditorMosaicContentPart.this.ivRestore;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                        imageView3 = null;
                    }
                    imageView3.setAlpha(1.0f);
                    imageView4 = WinkEditorMosaicContentPart.this.ivRestore;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                    } else {
                        imageView5 = imageView4;
                    }
                    imageView5.setClickable(true);
                    return;
                }
                imageView = WinkEditorMosaicContentPart.this.ivRestore;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                    imageView = null;
                }
                imageView.setAlpha(0.1f);
                imageView2 = WinkEditorMosaicContentPart.this.ivRestore;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                } else {
                    imageView5 = imageView2;
                }
                imageView5.setClickable(false);
            }
        };
        R1.observe(hostFragment4, new Observer() { // from class: com.tencent.mobileqq.wink.editor.mosaic.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMosaicContentPart.T9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9() {
        ImageView imageView = null;
        if (N9().W1()) {
            ImageView imageView2 = this.ivUndo;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                imageView2 = null;
            }
            imageView2.setAlpha(1.0f);
            ImageView imageView3 = this.ivUndo;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                imageView3 = null;
            }
            imageView3.setClickable(true);
        } else {
            ImageView imageView4 = this.ivUndo;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                imageView4 = null;
            }
            imageView4.setAlpha(0.1f);
            ImageView imageView5 = this.ivUndo;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                imageView5 = null;
            }
            imageView5.setClickable(false);
        }
        if (N9().U1()) {
            ImageView imageView6 = this.ivRestore;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                imageView6 = null;
            }
            imageView6.setAlpha(1.0f);
            ImageView imageView7 = this.ivRestore;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
            } else {
                imageView = imageView7;
            }
            imageView.setClickable(true);
            return;
        }
        ImageView imageView8 = this.ivRestore;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
            imageView8 = null;
        }
        imageView8.setAlpha(0.1f);
        ImageView imageView9 = this.ivRestore;
        if (imageView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
        } else {
            imageView = imageView9;
        }
        imageView.setClickable(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        FragmentManager fragmentManager;
        int i3;
        String str;
        FragmentManager.BackStackEntry backStackEntryAt;
        Fragment hostFragment = getHostFragment();
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (hostFragment != null) {
            fragmentManager = hostFragment.getChildFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            i3 = fragmentManager.getBackStackEntryCount();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            if (fragmentManager != null && (backStackEntryAt = fragmentManager.getBackStackEntryAt(i3 - 1)) != null) {
                str = backStackEntryAt.getName();
            } else {
                str = null;
            }
            if (fragmentManager != null) {
                fragmentManager.popBackStack();
            }
            if (Intrinsics.areEqual(str, "MOSAIC_TAG")) {
                ActivityResultCaller hostFragment2 = getHostFragment();
                if (hostFragment2 instanceof com.tencent.mobileqq.wink.editor.a) {
                    aVar = (com.tencent.mobileqq.wink.editor.a) hostFragment2;
                }
                if (aVar != null) {
                    aVar.g1(false);
                }
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        MosaicLayout mosaicLayout = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.xyk) {
            a73.a N9 = N9();
            MosaicLayout mosaicLayout2 = this.mosaicLayout;
            if (mosaicLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
                mosaicLayout2 = null;
            }
            N9.a2(MosaicLayout.l(mosaicLayout2, null, 1, null));
            O9(N9().N1(), false);
        } else if (num != null && num.intValue() == R.id.xyi) {
            O9(new ArrayList<>(), true);
        } else if (num != null && num.intValue() == R.id.xzj) {
            MosaicLayout mosaicLayout3 = this.mosaicLayout;
            if (mosaicLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
            } else {
                mosaicLayout = mosaicLayout3;
            }
            mosaicLayout.m();
        } else if (num != null && num.intValue() == R.id.xyx) {
            MosaicLayout mosaicLayout4 = this.mosaicLayout;
            if (mosaicLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
            } else {
                mosaicLayout = mosaicLayout4;
            }
            mosaicLayout.j();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.zfa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.mosaic_content_view)");
        this.mosaicLayout = (MosaicLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f24770_1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.pic_horizontal_listview)");
        this.horizontalListView = (HorizontalListView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.xyk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.ivConfirm)");
        this.ivConfirm = (ImageView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.xyi);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.ivCancel)");
        this.ivCancel = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.xzj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.ivUndo)");
        this.ivUndo = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.xyx);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.ivRestore)");
        this.ivRestore = (ImageView) findViewById6;
        ImageView imageView = this.ivConfirm;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivConfirm");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        ImageView imageView3 = this.ivCancel;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCancel");
            imageView3 = null;
        }
        imageView3.setOnClickListener(this);
        ImageView imageView4 = this.ivUndo;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
            imageView4 = null;
        }
        imageView4.setOnClickListener(this);
        ImageView imageView5 = this.ivRestore;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
        } else {
            imageView2 = imageView5;
        }
        imageView2.setOnClickListener(this);
        P9();
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // q83.a
    public void y4(int unDoSize, int redoSize) {
        N9().c2(unDoSize, redoSize);
    }
}
