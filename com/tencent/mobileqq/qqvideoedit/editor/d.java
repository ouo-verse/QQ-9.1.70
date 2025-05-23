package com.tencent.mobileqq.qqvideoedit.editor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import ik2.GifClipData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0004J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0014J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0004J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0004J\b\u0010 \u001a\u00020\u001fH\u0004J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0004J\b\u0010#\u001a\u00020\u0002H\u0004J\n\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010&\u001a\u00020%H\u0016R\u001c\u0010*\u001a\n '*\u0004\u0018\u00010%0%8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00108\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bA\u00103\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "Lcom/tencent/biz/richframework/part/Part;", "", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "L9", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "editMode", "J9", "Lik2/d;", "data", "I9", "", "isAdd", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "text", "M9", "Landroid/os/Bundle;", "args", "O9", "H9", "K9", "x9", "onDismiss", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw;", "F9", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorFragment;", "D9", "Lck2/i;", "C9", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "z9", "B9", "getRootView", "", "getLogTag", "kotlin.jvm.PlatformType", "d", "Ljava/lang/String;", "TAG", "e", "Landroid/view/View;", "partRootView", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "partRootViewStub", tl.h.F, "Z", "G9", "()Z", "setViewStubIsInflated", "(Z)V", "viewStubIsInflated", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "i", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "E9", "()Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "N9", "(Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;)V", "videoEditorViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.VISIBLE, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class d extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final String TAG = getClass().getSimpleName();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View partRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewStub partRootViewStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean viewStubIsInflated;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public VideoEditorViewModel videoEditorViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean visible;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/d$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/HashMap;", "", "a", "KEY_ATTRS", "Ljava/lang/String;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.d$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashMap<String, String> a(@Nullable Activity activity) {
            if (activity != null && activity.getIntent() != null) {
                Serializable serializableExtra = activity.getIntent().getSerializableExtra("key_attrs");
                if (serializableExtra instanceof HashMap) {
                    activity.getIntent().removeExtra("key_attrs");
                    return (HashMap) serializableExtra;
                }
            }
            return new HashMap<>();
        }

        Companion() {
        }
    }

    @IdRes
    public abstract int A9();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int B9() {
        Intent intent;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 5;
        }
        return intent.getIntExtra("uintype", 5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ck2.i C9() {
        PartManager partManager = getPartManager();
        Intrinsics.checkNotNull(partManager, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.parts.VideoEditPartManager");
        return (ck2.i) partManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final VideoEditorFragment D9() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof VideoEditorFragment) {
            return (VideoEditorFragment) hostFragment;
        }
        return null;
    }

    @NotNull
    public final VideoEditorViewModel E9() {
        VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
        if (videoEditorViewModel != null) {
            return videoEditorViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final aw F9() {
        VideoEditorFragment D9 = D9();
        if (D9 != null) {
            return D9.getCurTavCut();
        }
        return null;
    }

    /* renamed from: G9, reason: from getter */
    public final boolean getViewStubIsInflated() {
        return this.viewStubIsInflated;
    }

    protected final void H9() {
        ViewStub viewStub;
        if (!this.viewStubIsInflated && (viewStub = this.partRootViewStub) != null) {
            this.viewStubIsInflated = true;
            Intrinsics.checkNotNull(viewStub);
            View inflate = viewStub.inflate();
            this.partRootView = inflate;
            Intrinsics.checkNotNull(inflate);
            initAfterInflation(inflate);
            J9(E9().getEditMode());
        }
    }

    public void I9(@NotNull GifClipData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void J9(@NotNull VideoEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K9(@Nullable Bundle args) {
        if (this.visible) {
            return;
        }
        this.visible = true;
        View view = this.partRootView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(0);
    }

    public void M9(boolean isAdd, @NotNull MetaMaterial text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public final void N9(@NotNull VideoEditorViewModel videoEditorViewModel) {
        Intrinsics.checkNotNullParameter(videoEditorViewModel, "<set-?>");
        this.videoEditorViewModel = videoEditorViewModel;
    }

    public void O9(@Nullable Bundle args) {
        if (this.visible || this.partRootView == null) {
            return;
        }
        H9();
        K9(args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return TAG;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    /* renamed from: getRootView, reason: from getter */
    public View getPartRootView() {
        return this.partRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        if (!this.visible) {
            return;
        }
        this.visible = false;
        View view = this.partRootView;
        Intrinsics.checkNotNull(view);
        view.setVisibility(4);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(A9());
        this.partRootView = findViewById;
        if (findViewById instanceof ViewStub) {
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            this.partRootViewStub = (ViewStub) findViewById;
        } else {
            this.visible = true;
            this.viewStubIsInflated = true;
        }
        ViewModel viewModel = getViewModel(VideoEditorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(VideoEditorViewModel::class.java)");
        N9((VideoEditorViewModel) viewModel);
    }

    public void x9() {
        if (!this.visible || getPartRootView() == null) {
            return;
        }
        onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final LocalMediaInfo z9() {
        ArrayList arrayList;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            arrayList = intent.getParcelableArrayListExtra(AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS);
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        return (LocalMediaInfo) arrayList.get(0);
    }

    public void L9() {
    }
}
