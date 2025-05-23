package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.content.ComponentCallbacks2;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorFragment;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.TimelineViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropMenuPart;", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/h;", "", "da", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/MenuType;", "T9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "Y9", "", "A9", "Landroid/os/Bundle;", "args", "K9", "Lbk2/b;", "I", "Lbk2/b;", "mVideoEditorTemplateViewModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "J", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "mVideoEditorViewModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/TimelineViewModel;", "K", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/TimelineViewModel;", "mTimelineViewModel", "Lvj2/a;", "L", "Lkotlin/Lazy;", "ca", "()Lvj2/a;", "cropViewModel", "<init>", "()V", "M", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorCropMenuPart extends com.tencent.mobileqq.qqvideoedit.editor.menu.h {

    /* renamed from: I, reason: from kotlin metadata */
    private bk2.b mVideoEditorTemplateViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private VideoEditorViewModel mVideoEditorViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private TimelineViewModel mTimelineViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy cropViewModel;

    public VideoEditorCropMenuPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<vj2.a>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.VideoEditorCropMenuPart$cropViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final vj2.a invoke() {
                ComponentCallbacks2 activity = VideoEditorCropMenuPart.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
                return (vj2.a) new ViewModelProvider((ViewModelStoreOwner) activity).get(vj2.a.class);
            }
        });
        this.cropViewModel = lazy;
    }

    private final vj2.a ca() {
        return (vj2.a) this.cropViewModel.getValue();
    }

    private final void da() {
        ArrayList<MediaClip> ui5;
        Object orNull;
        VideoEditorFragment D9 = D9();
        if (D9 != null && (ui5 = D9.ui()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(ui5, 0);
            MediaClip mediaClip = (MediaClip) orNull;
            if (mediaClip != null) {
                VideoEditorViewModel videoEditorViewModel = this.mVideoEditorViewModel;
                com.tencent.mobileqq.qqvideoedit.editor.a aVar = null;
                if (videoEditorViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoEditorViewModel");
                    videoEditorViewModel = null;
                }
                Long value = videoEditorViewModel.U1().getValue();
                if (value == null) {
                    value = 0L;
                }
                getHostFragment().getChildFragmentManager().beginTransaction().add(R.id.f1177672b, VideoEditorCropFragment.INSTANCE.a(mediaClip, value.longValue(), true), "TAG_CROP").addToBackStack("TAG_CROP").commit();
                ActivityResultCaller hostFragment = getHostFragment();
                if (hostFragment instanceof com.tencent.mobileqq.qqvideoedit.editor.a) {
                    aVar = (com.tencent.mobileqq.qqvideoedit.editor.a) hostFragment;
                }
                if (aVar != null) {
                    aVar.g1(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(VideoEditorCropMenuPart this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw F9 = this$0.F9();
        if (F9 != null) {
            F9.X((Matrix) pair.getFirst(), (RectF) pair.getSecond());
        }
        TimelineViewModel timelineViewModel = this$0.mTimelineViewModel;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimelineViewModel");
            timelineViewModel = null;
        }
        timelineViewModel.k2((Matrix) pair.getFirst(), (RectF) pair.getSecond());
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public int A9() {
        return R.id.ubm;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h, com.tencent.mobileqq.qqvideoedit.editor.d
    protected void K9(@Nullable Bundle args) {
        super.K9(args);
        da();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h
    @NotNull
    public MenuType T9() {
        return MenuType.CROP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@Nullable View rootView) {
        super.initAfterInflation(rootView);
        ViewModel viewModel = getViewModel(bk2.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(VideoEditor\u2026ateViewModel::class.java)");
        this.mVideoEditorTemplateViewModel = (bk2.b) viewModel;
        ViewModel viewModel2 = getViewModel(VideoEditorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(VideoEditorViewModel::class.java)");
        this.mVideoEditorViewModel = (VideoEditorViewModel) viewModel2;
        ViewModel viewModel3 = getViewModel(TimelineViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(TimelineViewModel::class.java)");
        this.mTimelineViewModel = (TimelineViewModel) viewModel3;
        ca().L1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.crop.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorCropMenuPart.ea(VideoEditorCropMenuPart.this, (Pair) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.menu.h
    public void Y9() {
    }
}
