package com.tencent.mobileqq.wink.magicstudio.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioActivityResult;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010=\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/ImageCreateImagePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "R9", "Q9", "L9", "Landroid/os/Bundle;", "data", "K9", "M9", "N9", "", "path", "U9", "I9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/mobileqq/wink/magicstudio/p;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/p;", "jumpViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "e", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "vm", "Landroid/widget/EditText;", "f", "Landroid/widget/EditText;", "promptDesc", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "styleTitle", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "switchGradient", BdhLogUtil.LogTag.Tag_Conn, "imgbg", "D", InnerWebView.API_UPLOAD_IMAGE, "E", "Landroid/view/View;", "changeImgBtn", "Lcom/tencent/mobileqq/wink/magicstudio/view/TagAdapter;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/magicstudio/view/TagAdapter;", "tagAdapter", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "G", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "magicStudioVm", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/p;Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ImageCreateImagePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView imgbg;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView uploadImage;

    /* renamed from: E, reason: from kotlin metadata */
    private View changeImgBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TagAdapter tagAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicStudioVm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.magicstudio.p jumpViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicStudioCreationViewModel vm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private EditText promptDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView tags;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView styleTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView switchGradient;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/view/ImageCreateImagePart$b", "Lcom/tencent/biz/richframework/part/block/base/SafeStaggeredGridLayoutManager;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends SafeStaggeredGridLayoutManager {
        b() {
            super(1, 0);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/view/ImageCreateImagePart$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex() < 1) {
                outRect.bottom = ViewExKt.d(5);
            } else {
                outRect.top = ViewExKt.d(5);
            }
            outRect.right = ViewExKt.d(6);
        }
    }

    public ImageCreateImagePart(@NotNull com.tencent.mobileqq.wink.magicstudio.p jumpViewModel, @NotNull MagicStudioCreationViewModel vm5) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(jumpViewModel, "jumpViewModel");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.jumpViewModel = jumpViewModel;
        this.vm = vm5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.ImageCreateImagePart$magicStudioVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final MagicStudioViewModel invoke() {
                Activity activity = ImageCreateImagePart.this.getActivity();
                FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
                if (fragmentActivity != null) {
                    return (MagicStudioViewModel) new ViewModelProvider(fragmentActivity).get(MagicStudioViewModel.class);
                }
                return null;
            }
        });
        this.magicStudioVm = lazy;
    }

    private final void I9() {
        ImageView imageView = this.switchGradient;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switchGradient");
            imageView = null;
        }
        imageView.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, getContext().getResources().getColor(R.color.qui_common_bg_bottom_light)}));
    }

    private final MagicStudioViewModel J9() {
        return (MagicStudioViewModel) this.magicStudioVm.getValue();
    }

    private final void K9(Bundle data) {
        LocalMediaInfo localMediaInfo;
        String str;
        MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle;
        String str2;
        boolean z16;
        String compressPath;
        MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle2 = null;
        if (data != null) {
            localMediaInfo = (LocalMediaInfo) data.getParcelable(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH);
        } else {
            localMediaInfo = null;
        }
        if (!(localMediaInfo instanceof LocalMediaInfo)) {
            localMediaInfo = null;
        }
        if (localMediaInfo != null) {
            w53.b.f("ImageCreationFragment", "image picker path: " + localMediaInfo.path);
            str = localMediaInfo.path;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (data != null) {
            magicStudioUploadImgAndStyle = (MagicStudioUploadImgAndStyle) data.getParcelable(AECameraConstants.FRAGMENT_CAMERA_RESULT_MAGIC_INFO);
        } else {
            magicStudioUploadImgAndStyle = null;
        }
        if (!(magicStudioUploadImgAndStyle instanceof MagicStudioUploadImgAndStyle)) {
            magicStudioUploadImgAndStyle = null;
        }
        if (magicStudioUploadImgAndStyle != null) {
            w53.b.f("ImageCreationFragment", "image MagicStudioUploadImgAndStyle: " + magicStudioUploadImgAndStyle);
            magicStudioUploadImgAndStyle2 = magicStudioUploadImgAndStyle;
        }
        if (magicStudioUploadImgAndStyle2 != null) {
            MagicStudioUploadImgInfo currentImg = magicStudioUploadImgAndStyle2.getCurrentImg();
            if (currentImg == null || (str2 = currentImg.getCompressPath()) == null) {
                str2 = str;
            }
            w53.b.f("ImageCreationFragment", "image file: " + str2);
            if (str2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                MagicStudioUploadImgInfo currentImg2 = magicStudioUploadImgAndStyle2.getCurrentImg();
                if (currentImg2 != null && (compressPath = currentImg2.getCompressPath()) != null) {
                    str = compressPath;
                }
                U9(str);
                this.vm.y3(magicStudioUploadImgAndStyle2);
            }
        }
    }

    private final void L9() {
        EditText editText = this.promptDesc;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
            editText = null;
        }
        editText.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        EditText editText3 = this.promptDesc;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
            editText3 = null;
        }
        editText3.setHintTextColor(getContext().getColor(R.color.qui_common_text_secondary));
        EditText editText4 = this.promptDesc;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
            editText4 = null;
        }
        editText4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        EditText editText5 = this.promptDesc;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
        } else {
            editText2 = editText5;
        }
        editText2.addTextChangedListener(new a());
    }

    private final void M9() {
        w53.b.a("ImageCreationFragment", "initFromArgument handleResult");
        Bundle arguments = getHostFragment().getArguments();
        if (arguments == null) {
            return;
        }
        K9(arguments);
    }

    private final void N9() {
        LiveData<MagicStudioActivityResult> X1;
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        MagicStudioViewModel J9 = J9();
        if (J9 != null && (X1 = J9.X1()) != null) {
            X1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.view.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ImageCreateImagePart.O9(ImageCreateImagePart.this, (MagicStudioActivityResult) obj);
                }
            });
        }
        this.jumpViewModel.L1().observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.view.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ImageCreateImagePart.P9(ImageCreateImagePart.this, (Bundle) obj);
            }
        });
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new ImageCreateImagePart$initObserver$3(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new ImageCreateImagePart$initObserver$4(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(ImageCreateImagePart this$0, MagicStudioActivityResult magicStudioActivityResult) {
        MagicStudioViewModel J9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (52129 == magicStudioActivityResult.getRequestCode() && magicStudioActivityResult.getResultCode() == -1 && (J9 = this$0.J9()) != null) {
            J9.T1(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ImageCreateImagePart this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9(bundle);
    }

    private final void Q9() {
        RecyclerView recyclerView = this.tags;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new b());
        RecyclerView recyclerView3 = this.tags;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            recyclerView3 = null;
        }
        TagAdapter tagAdapter = new TagAdapter(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.ImageCreateImagePart$initTagsUI$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void invoke(int i3) {
                ImageCreateImagePart.this.vm.i3(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        });
        this.tagAdapter = tagAdapter;
        recyclerView3.setAdapter(tagAdapter);
        RecyclerView recyclerView4 = this.tags;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.addItemDecoration(new c());
    }

    private final void R9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f114636tv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.uploadImg)");
        this.uploadImage = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f165787xl0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.imgbg)");
        this.imgbg = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.tr6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.changeImg)");
        this.changeImgBtn = findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f9250582);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tags)");
        this.tags = (RecyclerView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f28680jl);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.promptDesc)");
        this.promptDesc = (EditText) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f911754g);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.switchGradient)");
        this.switchGradient = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f898050r);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.styleTitle)");
        TextView textView = (TextView) findViewById7;
        this.styleTitle = textView;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleTitle");
            textView = null;
        }
        textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        rootView.findViewById(R.id.ub9).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ImageCreateImagePart.S9(ImageCreateImagePart.this, view2);
            }
        });
        View view2 = this.changeImgBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeImgBtn");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ImageCreateImagePart.T9(ImageCreateImagePart.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(ImageCreateImagePart this$0, View view) {
        Object obj;
        InputMethodManager inputMethodManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.promptDesc;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
            editText = null;
        }
        if (editText.hasFocus()) {
            EditText editText3 = this$0.promptDesc;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                editText3 = null;
            }
            editText3.clearFocus();
            Context context = this$0.getHostFragment().getContext();
            if (context != null) {
                obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            } else {
                obj = null;
            }
            if (obj instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) obj;
            } else {
                inputMethodManager = null;
            }
            if (inputMethodManager != null) {
                EditText editText4 = this$0.promptDesc;
                if (editText4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promptDesc");
                } else {
                    editText2 = editText4;
                }
                inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(ImageCreateImagePart this$0, View view) {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        Fragment findFragmentByTag;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        View view2 = null;
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (findFragmentByTag = supportFragmentManager.findFragmentByTag("AIGC_LOGIC")) != null) {
            MagicStudioLogicFragment.Companion companion = MagicStudioLogicFragment.INSTANCE;
            Activity activity2 = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            companion.d(activity2, findFragmentByTag, new Bundle());
        }
        View view3 = this$0.changeImgBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeImgBtn");
            view3 = null;
        }
        VideoReport.setElementId(view3, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_PICTURE);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        View view4 = this$0.changeImgBtn;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeImgBtn");
        } else {
            view2 = view4;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view2, buildElementParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void U9(String path) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new ImageCreateImagePart$onSelectedPic$1(path, this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        R9(rootView);
        L9();
        Q9();
        I9();
        N9();
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        this.vm.o3();
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/view/ImageCreateImagePart$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            ImageCreateImagePart.this.vm.d3(String.valueOf(s16));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
