package com.tencent.mobileqq.wink.editor.openingending;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateFragment;
import com.tencent.mobileqq.wink.view.ai;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.render.extension.MediaClipUseType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 g2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\bd\u0010eB9\b\u0016\u0012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\n0\u0002\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010c\u001a\u00020G\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010^\u00a2\u0006\u0004\bd\u0010fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u001a\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020(H\u0014J\u001a\u0010,\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020(H\u0014J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0006\u00104\u001a\u00020\u0005J\b\u00105\u001a\u00020\u0005H\u0016R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0003018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\n018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010=R\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010IR\u0016\u0010X\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010IR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010=R\u0018\u0010]\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010I\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategoryList", "", "ni", "initView", "", "Wh", "Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "Zh", "ai", "initViewPager", "gi", "bi", "ci", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "Sh", "Ph", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Qh", "url", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayParam;", "Vh", "imageUrl", "Oh", "mi", "showLoadingDialog", "Th", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "aigcData", "Yh", "Landroid/view/View;", "view", "registerDaTongReportPageId", "fi", "li", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "getStatusBarColor", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "dismiss", "onDestroyView", "Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Xh", "()Lcom/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingViewModel;", "viewModel", "D", "Ljava/util/List;", "categories", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "E", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "videoView", "Lcom/tencent/mobileqq/wink/view/ai;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/view/ai;", "loadingDialog", "", "G", "Z", "needDismiss", "Lkotlinx/coroutines/Job;", "H", "Lkotlinx/coroutines/Job;", "selectMaterialJob", "I", "deletedMediaClips", "Lcom/google/android/material/tabs/d;", "J", "Lcom/google/android/material/tabs/d;", "tabLayoutMediator", "K", "isVideoPlaying", "L", "isAigcPageShowing", "M", "mediaClips", "N", "Ljava/lang/String;", "selectedCategoryId", "Lcom/tencent/videocut/model/BackgroundModel;", "P", "Lcom/tencent/videocut/model/BackgroundModel;", "backgroundModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isFromClipping", "<init>", "()V", "(Ljava/util/List;Ljava/lang/String;ZLcom/tencent/videocut/model/BackgroundModel;)V", ExifInterface.LATITUDE_SOUTH, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorOpeningEndingTemplateFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<MetaCategory> categories;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private BaseVideoView videoView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.view.ai loadingDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needDismiss;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Job selectMaterialJob;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<MediaClip> deletedMediaClips;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.google.android.material.tabs.d tabLayoutMediator;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isVideoPlaying;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isAigcPageShowing;

    /* renamed from: M, reason: from kotlin metadata */
    private List<? extends MediaClip> mediaClips;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String selectedCategoryId;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private BackgroundModel backgroundModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isFromClipping;

    @NotNull
    public Map<Integer, View> R;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateFragment$b", "Lcom/tencent/mobileqq/wink/utils/v;", "", "b", "", "l", "l1", "onPlayProgress", "onFirstFrameRendered", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.wink.utils.v {
        b() {
        }

        private final void b() {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorOpeningEndingTemplateFragment winkEditorOpeningEndingTemplateFragment = WinkEditorOpeningEndingTemplateFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.au
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorOpeningEndingTemplateFragment.b.c(WinkEditorOpeningEndingTemplateFragment.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WinkEditorOpeningEndingTemplateFragment this$0) {
            String str;
            ImageView imageView;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MetaMaterial selectedMaterial = this$0.Xh().getSelectedMaterial();
            String str2 = null;
            if (selectedMaterial != null) {
                str = selectedMaterial.f30533id;
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(str, "CLEAR_OPENING_MATERIAL_ID")) {
                if (selectedMaterial != null) {
                    str2 = selectedMaterial.f30533id;
                }
                if (!Intrinsics.areEqual(str2, "CLEAR_ENDING_MATERIAL_ID") && (imageView = (ImageView) this$0.yh(R.id.f1171370m)) != null) {
                    imageView.setVisibility(0);
                }
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long l3) {
            b();
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long l3, long l16) {
            b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/openingending/WinkEditorOpeningEndingTemplateFragment$c", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNull(fragmentActivity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            MetaCategory metaCategory = (MetaCategory) WinkEditorOpeningEndingTemplateFragment.this.categories.get(position);
            List list = WinkEditorOpeningEndingTemplateFragment.this.mediaClips;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
                list = null;
            }
            return new WinkEditorOpeningEndingTemplateGridFragment(metaCategory, list, WinkEditorOpeningEndingTemplateFragment.this.isFromClipping);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return WinkEditorOpeningEndingTemplateFragment.this.categories.size();
        }
    }

    public WinkEditorOpeningEndingTemplateFragment() {
        Lazy lazy;
        this.R = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorOpeningEndingViewModel>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkEditorOpeningEndingViewModel invoke() {
                FragmentActivity activity = WinkEditorOpeningEndingTemplateFragment.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                ViewModel viewModel = new ViewModelProvider(activity).get(WinkEditorOpeningEndingViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider((activ\u2026ingViewModel::class.java)");
                return (WinkEditorOpeningEndingViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
        this.categories = new ArrayList();
        this.deletedMediaClips = new ArrayList();
    }

    private final void Oh(String imageUrl) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.wink.utils.aa.f326656a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(imageUrl, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(imageUrl, options)");
        ((URLImageView) yh(R.id.xhv)).setImageDrawable(drawable2);
        ((CardView) yh(R.id.f1171270l)).setVisibility(0);
        ((ImageView) yh(R.id.f1171370m)).setVisibility(0);
        ((URLImageView) yh(R.id.xhv)).setVisibility(0);
        try {
            ((URLImageView) yh(R.id.xhv)).setImageDrawable(drawable2);
            ((URLImageView) yh(R.id.xhv)).setVisibility(0);
        } catch (Exception unused) {
            ((URLImageView) yh(R.id.xhv)).setVisibility(8);
            w53.b.c("WinkEditorOpeningEndingTemplateFragment", "bindImagePreview failed: " + imageUrl);
        }
    }

    private final void Ph(MetaMaterial metaMaterial) {
        List<String> split$default;
        ((LinearLayout) yh(R.id.f920656v)).setVisibility(0);
        ((LinearLayout) yh(R.id.f920656v)).removeAllViews();
        split$default = StringsKt__StringsKt.split$default((CharSequence) com.tencent.mobileqq.wink.editor.c.B0(metaMaterial), new String[]{"\uff5c"}, false, 0, 6, (Object) null);
        for (String str : split$default) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.he_, (ViewGroup) yh(R.id.f920656v), false);
            TextView textView = (TextView) inflate.findViewById(R.id.f920856x);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R.id.tagTextView)");
                textView.setText(str);
            }
            ((LinearLayout) yh(R.id.f920656v)).addView(inflate);
        }
    }

    private final void Qh(String videoUrl) {
        ((CardView) yh(R.id.f1171270l)).setVisibility(0);
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setVisibility(0);
        }
        BaseVideoView baseVideoView2 = this.videoView;
        if (baseVideoView2 != null) {
            baseVideoView2.setVideoParam(Vh(videoUrl));
        }
        BaseVideoView baseVideoView3 = this.videoView;
        if (baseVideoView3 != null) {
            baseVideoView3.play();
        }
        BaseVideoView baseVideoView4 = this.videoView;
        if (baseVideoView4 != null) {
            baseVideoView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.at
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorOpeningEndingTemplateFragment.Rh(WinkEditorOpeningEndingTemplateFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(WinkEditorOpeningEndingTemplateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseVideoView baseVideoView = this$0.videoView;
        boolean z16 = false;
        if (baseVideoView != null && baseVideoView.isPlaying()) {
            z16 = true;
        }
        if (z16) {
            BaseVideoView baseVideoView2 = this$0.videoView;
            if (baseVideoView2 != null) {
                baseVideoView2.pause();
            }
        } else {
            BaseVideoView baseVideoView3 = this$0.videoView;
            if (baseVideoView3 != null) {
                baseVideoView3.resume();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(MetaMaterial metaMaterial) {
        if (!Intrinsics.areEqual(metaMaterial.f30533id, "CLEAR_ENDING_MATERIAL_ID") && !Intrinsics.areEqual(metaMaterial.f30533id, "CLEAR_OPENING_MATERIAL_ID")) {
            if (com.tencent.mobileqq.wink.editor.c.T(metaMaterial) == MaterialType.IMAGE) {
                Oh(com.tencent.mobileqq.wink.editor.c.s0(metaMaterial));
            } else {
                Qh(com.tencent.mobileqq.wink.editor.c.S0(metaMaterial));
            }
            ((TextView) yh(R.id.f98165mc)).setVisibility(0);
            ((TextView) yh(R.id.f98165mc)).setText(com.tencent.mobileqq.wink.editor.c.p(metaMaterial) + "\uff5c" + com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            ((TextView) yh(R.id.ugj)).setText(com.tencent.mobileqq.wink.editor.c.O(metaMaterial));
            ((TextView) yh(R.id.ugj)).setVisibility(0);
            Ph(metaMaterial);
            return;
        }
        ((TextView) yh(R.id.f165087uu2)).setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
        ((LinearLayout) yh(R.id.f165086uu1)).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.as
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingTemplateFragment.Uh(WinkEditorOpeningEndingTemplateFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(WinkEditorOpeningEndingTemplateFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.view.ai aiVar = this$0.loadingDialog;
        if (aiVar != null) {
            aiVar.dismiss();
        }
        this$0.loadingDialog = null;
    }

    private final VideoPlayParam Vh(String url) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mUrls = new String[]{url};
        videoPlayParam.mVideoFormat = 101;
        videoPlayParam.mIsLocal = false;
        videoPlayParam.mIsLoop = true;
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mSceneId = 153;
        videoPlayParam.mCallback = new b();
        videoPlayParam.mSceneId = 157;
        return videoPlayParam;
    }

    private final String Wh() {
        String str = this.selectedCategoryId;
        if (str == null) {
            if (Intrinsics.areEqual(Xh().getLastSelectedCategoryId(), "ending")) {
                return "ending";
            }
            return "opening";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorOpeningEndingViewModel Xh() {
        return (WinkEditorOpeningEndingViewModel) this.viewModel.getValue();
    }

    private final void Yh(OpeningEndingAigcData aigcData, MediaClip mediaClip) {
        boolean z16;
        FragmentManager childFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        FragmentTransaction addToBackStack;
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            z16 = baseVideoView.isPlaying();
        } else {
            z16 = false;
        }
        this.isVideoPlaying = z16;
        this.isAigcPageShowing = true;
        BaseVideoView baseVideoView2 = this.videoView;
        if (baseVideoView2 != null) {
            baseVideoView2.pause();
        }
        List<? extends MediaClip> list = this.mediaClips;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            list = null;
        }
        WinkEditorOpeningEndingAigcImageSelectFragment winkEditorOpeningEndingAigcImageSelectFragment = new WinkEditorOpeningEndingAigcImageSelectFragment(list, mediaClip, this.isFromClipping, true, this.backgroundModel, aigcData);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (childFragmentManager = parentFragment.getChildFragmentManager()) != null && (beginTransaction = childFragmentManager.beginTransaction()) != null && (add = beginTransaction.add(R.id.xhy, winkEditorOpeningEndingAigcImageSelectFragment, "WinkEditorOpeningEndingAigcImageSelectFragment")) != null && (addToBackStack = add.addToBackStack("WinkEditorOpeningEndingAigcImageSelectFragment")) != null) {
            addToBackStack.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(MediaClip mediaClip) {
        if (com.tencent.videocut.render.extension.e.k(mediaClip) != null) {
            Yh(com.tencent.videocut.render.extension.e.k(mediaClip), mediaClip);
        } else {
            Xh().E2(getActivity(), mediaClip, this.isFromClipping);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        if (r2 == com.tencent.mobileqq.wink.editor.MaterialType.OPEN_END_AIGC_TEMPLATE) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ai() {
        List<? extends MediaClip> mutableList;
        MaterialType materialType;
        String str;
        String str2;
        Object last;
        Object last2;
        Object first;
        Object first2;
        MaterialType materialType2;
        String str3;
        Object last3;
        MediaClip mediaClip;
        Object first3;
        MaterialType materialType3;
        li();
        List<? extends MediaClip> list = this.mediaClips;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaClips");
            list = null;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        mutableList.removeAll(this.deletedMediaClips);
        MetaMaterial w26 = Xh().w2();
        if (w26 != null) {
            materialType = com.tencent.mobileqq.wink.editor.c.T(w26);
        } else {
            materialType = null;
        }
        if (materialType != MaterialType.TEMPLATE) {
            MetaMaterial w27 = Xh().w2();
            if (w27 != null) {
                materialType3 = com.tencent.mobileqq.wink.editor.c.T(w27);
            } else {
                materialType3 = null;
            }
        }
        MetaMaterial w28 = Xh().w2();
        if (w28 != null) {
            str = com.tencent.mobileqq.wink.editor.c.o(w28);
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "opening")) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
            if (com.tencent.videocut.render.extension.e.r((MediaClip) first) == MediaClipUseType.OPENING) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
                Zh((MediaClip) first2);
                return;
            }
        }
        MetaMaterial w29 = Xh().w2();
        if (w29 != null) {
            str2 = com.tencent.mobileqq.wink.editor.c.o(w29);
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str2, "ending")) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mutableList);
            if (com.tencent.videocut.render.extension.e.r((MediaClip) last) == MediaClipUseType.ENDING) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) mutableList);
                Zh((MediaClip) last2);
                return;
            }
        }
        MetaMaterial w210 = Xh().w2();
        if (w210 != null) {
            materialType2 = com.tencent.mobileqq.wink.editor.c.T(w210);
        } else {
            materialType2 = null;
        }
        if (materialType2 == MaterialType.OPEN_END_AIGC_TEMPLATE) {
            MetaMaterial w211 = Xh().w2();
            if (w211 != null) {
                str3 = com.tencent.mobileqq.wink.editor.c.o(w211);
            } else {
                str3 = null;
            }
            if (Intrinsics.areEqual(str3, "opening")) {
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
                mediaClip = (MediaClip) first3;
            } else {
                last3 = CollectionsKt___CollectionsKt.last((List<? extends Object>) mutableList);
                mediaClip = (MediaClip) last3;
            }
            Yh(null, mediaClip);
            return;
        }
        showLoadingDialog();
        Xh().A2(getActivity(), mutableList, this.isFromClipping, new WinkEditorOpeningEndingTemplateFragment$handleNextStepBtnClick$1(this));
    }

    private final void bi() {
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(16).setBackgroundColorType(0).setHalfScreenState(true).setThemeType(2).build();
        build.setScaleX(1.25f);
        build.setScaleY(1.25f);
        ((FrameLayout) yh(R.id.f165088uu3)).addView(build);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) build.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.gravity = 17;
        }
    }

    private final void ci() {
        Job launch$default;
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new WinkEditorOpeningEndingTemplateFragment$initLiveData$1(this, null), 3, null);
        this.selectMaterialJob = launch$default;
        LiveData<List<MetaCategory>> t26 = Xh().t2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends MetaCategory>, Unit> function1 = new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateFragment$initLiveData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaCategory> list) {
                invoke2((List<MetaCategory>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MetaCategory> it) {
                List<MetaCategory> list = it;
                if ((list == null || list.isEmpty()) || !WinkEditorOpeningEndingTemplateFragment.this.categories.isEmpty()) {
                    return;
                }
                WinkEditorOpeningEndingTemplateFragment winkEditorOpeningEndingTemplateFragment = WinkEditorOpeningEndingTemplateFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkEditorOpeningEndingTemplateFragment.ni(it);
            }
        };
        t26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingTemplateFragment.di(Function1.this, obj);
            }
        });
        LiveData<Pair<Boolean, Boolean>> q26 = Xh().q2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Pair<? extends Boolean, ? extends Boolean>, Unit> function12 = new Function1<Pair<? extends Boolean, ? extends Boolean>, Unit>() { // from class: com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingTemplateFragment$initLiveData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
                invoke2((Pair<Boolean, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
            
                r3 = r2.this$0.videoView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Pair<Boolean, Boolean> pair) {
                boolean z16;
                BaseVideoView baseVideoView;
                boolean booleanValue = pair.component2().booleanValue();
                WinkEditorOpeningEndingTemplateFragment.this.isAigcPageShowing = false;
                if (booleanValue) {
                    z16 = WinkEditorOpeningEndingTemplateFragment.this.isVideoPlaying;
                    if (!z16 || baseVideoView == null) {
                        return;
                    }
                    baseVideoView.play();
                }
            }
        };
        q26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.openingending.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorOpeningEndingTemplateFragment.ei(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void fi() {
        VideoReport.setElementId((TextView) yh(R.id.zqm), WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON);
        VideoReport.setElementParams((TextView) yh(R.id.zqm), WinkDTParamBuilder.buildElementParams());
        VideoReport.setElementEndExposePolicy((TextView) yh(R.id.zqm), EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy((TextView) yh(R.id.zqm), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy((TextView) yh(R.id.zqm), ExposurePolicy.REPORT_ALL);
    }

    private final void gi() {
        this.videoView = new BaseVideoView(getContext(), 153L, Vh(""), null, null, false);
        ((CardView) yh(R.id.f1171270l)).addView(this.videoView, 0, new RelativeLayout.LayoutParams(-1, -1));
        mi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(WinkEditorOpeningEndingTemplateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(WinkEditorOpeningEndingTemplateFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ai();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView() {
        ((ImageView) yh(R.id.t2c)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorOpeningEndingTemplateFragment.hi(WinkEditorOpeningEndingTemplateFragment.this, view);
            }
        });
        ((TextView) yh(R.id.zqm)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.openingending.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorOpeningEndingTemplateFragment.ii(WinkEditorOpeningEndingTemplateFragment.this, view);
            }
        });
        initViewPager();
        gi();
        bi();
        Xh().I2();
        List<MetaCategory> value = Xh().t2().getValue();
        if (value != null && (!value.isEmpty())) {
            ni(value);
        }
        fi();
    }

    private final void initViewPager() {
        ((ViewPager2) yh(R.id.toz)).setAdapter(new c(getActivity()));
        com.google.android.material.tabs.d dVar = new com.google.android.material.tabs.d((TabLayout) yh(R.id.toy), (ViewPager2) yh(R.id.toz), new d.b() { // from class: com.tencent.mobileqq.wink.editor.openingending.ar
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i3) {
                WinkEditorOpeningEndingTemplateFragment.ji(WinkEditorOpeningEndingTemplateFragment.this, gVar, i3);
            }
        });
        this.tabLayoutMediator = dVar;
        dVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(WinkEditorOpeningEndingTemplateFragment this$0, TabLayout.g tab, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.t(this$0.categories.get(i3).name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(WinkEditorOpeningEndingTemplateFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        this$0.needDismiss = false;
    }

    private final void li() {
        String str;
        VideoReport.setElementId((TextView) yh(R.id.zqm), WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        MetaMaterial selectedMaterial = Xh().getSelectedMaterial();
        if (selectedMaterial != null) {
            str = selectedMaterial.f30533id;
        } else {
            str = null;
        }
        reportMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, str);
        VideoReport.reportEvent("dt_clck", (TextView) yh(R.id.zqm), reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi() {
        ((LinearLayout) yh(R.id.f165086uu1)).setVisibility(8);
        ((TextView) yh(R.id.f98165mc)).setVisibility(4);
        ((TextView) yh(R.id.ugj)).setVisibility(4);
        ((LinearLayout) yh(R.id.f920656v)).setVisibility(4);
        ((CardView) yh(R.id.f1171270l)).setVisibility(4);
        ((ImageView) yh(R.id.f1171370m)).setVisibility(4);
        ((URLImageView) yh(R.id.xhv)).setVisibility(8);
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setVisibility(8);
        }
        BaseVideoView baseVideoView2 = this.videoView;
        if (baseVideoView2 != null) {
            baseVideoView2.pause();
        }
        BaseVideoView baseVideoView3 = this.videoView;
        if (baseVideoView3 != null) {
            baseVideoView3.setVideoParam(Vh(""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public final void ni(List<MetaCategory> metaCategoryList) {
        this.categories.clear();
        this.categories.addAll(metaCategoryList);
        Iterator<MetaCategory> it = this.categories.iterator();
        final int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().f30532id, Wh())) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.aq
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorOpeningEndingTemplateFragment.oi(WinkEditorOpeningEndingTemplateFragment.this, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(WinkEditorOpeningEndingTemplateFragment this$0, int i3) {
        ViewPager2 viewPager2;
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager22 = (ViewPager2) this$0.yh(R.id.toz);
        if (viewPager22 != null && (adapter = viewPager22.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
        if (i3 > -1 && (viewPager2 = (ViewPager2) this$0.yh(R.id.toz)) != null) {
            viewPager2.setCurrentItem(i3, false);
        }
    }

    private final void registerDaTongReportPageId(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, WinkDaTongReportConstant.PageId.PG_XSJ_OPENING_ENDING_PREVIEW_PAGE);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    private final void showLoadingDialog() {
        String str;
        ai.b bVar = new ai.b(getContext());
        Context context = getContext();
        if (context == null || (str = context.getString(R.string.f241327rk)) == null) {
            str = "";
        }
        com.tencent.mobileqq.wink.view.ai a16 = bVar.i(str).h(false).b(true).f(getView()).a();
        this.loadingDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.R.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    public final void dismiss() {
        Job job = this.selectMaterialJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        VideoReport.traversePage(getView());
        try {
            getParentFragmentManager().popBackStack();
        } catch (Throwable th5) {
            w53.b.e("WinkEditorOpeningEndingTemplateFragment", th5);
        }
        Xh().H2(this.isFromClipping);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.he8;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewPager2) yh(R.id.toz)).setAdapter(null);
        com.google.android.material.tabs.d dVar = this.tabLayoutMediator;
        if (dVar != null) {
            dVar.b();
        }
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.pause();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        BaseVideoView baseVideoView;
        super.onResume();
        if (!this.isAigcPageShowing && (baseVideoView = this.videoView) != null) {
            baseVideoView.play();
        }
        if (this.needDismiss) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.openingending.an
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorOpeningEndingTemplateFragment.ki(WinkEditorOpeningEndingTemplateFragment.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerDaTongReportPageId(view);
        initView();
        ci();
    }

    @Nullable
    public View yh(int i3) {
        View findViewById;
        Map<Integer, View> map = this.R;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View view2 = getView();
            if (view2 != null && (findViewById = view2.findViewById(i3)) != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public /* synthetic */ WinkEditorOpeningEndingTemplateFragment(List list, String str, boolean z16, BackgroundModel backgroundModel, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? null : backgroundModel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorOpeningEndingTemplateFragment(@NotNull List<? extends MediaClip> mediaClips, @Nullable String str, boolean z16, @Nullable BackgroundModel backgroundModel) {
        this();
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        this.mediaClips = mediaClips;
        this.selectedCategoryId = str;
        this.isFromClipping = z16;
        this.backgroundModel = backgroundModel;
    }
}
