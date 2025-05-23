package com.tencent.mobileqq.wink.picker.core.part;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.MediaProcessState;
import com.tencent.mobileqq.wink.picker.MediaProcessStateType;
import com.tencent.mobileqq.wink.picker.interceptor.MediaInterceptorMonitor;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 62\u00020\u0001:\u000278B\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR#\u0010*\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR\u001b\u00100\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "H9", "J9", "Lcom/tencent/mobileqq/wink/picker/c;", "mediaProcessState", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog;", "D9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroidx/fragment/app/Fragment;", "fragment", "L9", "F9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "d", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "callback", "", "e", "Z", "isFromTemplateColl", "()Z", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/m;", "f", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/m;", "nextStepUIStateViewModel", tl.h.F, "isQZoneDialogInit", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "downloadQZoneMediaDialog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isProcessMediaDialogInit", BdhLogUtil.LogTag.Tag_Conn, "G9", "()Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog;", "processMediaDialog", "D", "Landroidx/fragment/app/Fragment;", "_fragment", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;Z)V", "E", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaPickerNextStepDialogPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy processMediaDialog;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Fragment _fragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isFromTemplateColl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.picker.core.viewmodel.m nextStepUIStateViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isQZoneDialogInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy downloadQZoneMediaDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isProcessMediaDialogInit;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        @NotNull
        List<LocalMediaInfo> a();

        boolean b();

        void onCancelClick();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324538a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324539b;

        static {
            int[] iArr = new int[MediaProcessStateType.values().length];
            try {
                iArr[MediaProcessStateType.SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaProcessStateType.DISMISS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaProcessStateType.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaProcessStateType.UPDATE_STEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MediaProcessStateType.UPDATE_VIDEO_TEMPLATE_PROGRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MediaProcessStateType.UPDATE_TEMPLATE_LIB_PREPROCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MediaProcessStateType.UPDATE_COMPRESS_PROGRESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MediaProcessStateType.UPDATE_EXPORT_PROGRESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MediaProcessStateType.FINISH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f324538a = iArr;
            int[] iArr2 = new int[PhotoListLogicPreDealDialog.PreDealStep.values().length];
            try {
                iArr2[PhotoListLogicPreDealDialog.PreDealStep.STEP_EXTRACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_MUSIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_MUSIC_STUCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[PhotoListLogicPreDealDialog.PreDealStep.STEP_FETCH_TEMPLATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            f324539b = iArr2;
        }
    }

    public /* synthetic */ WinkMediaPickerNextStepDialogPart(a aVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i3 & 2) != 0 ? false : z16);
    }

    private final PhotoListLogicPreDealDialog D9(MediaProcessState mediaProcessState) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (!G9().t() && this.callback.b()) {
            if (mediaProcessState.getMediaPickerScene() == MediaPickerScene.STANDARD) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !mediaProcessState.getUseVideoTemplate() && this.callback.a().size() > 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            PhotoListLogicPreDealDialog G9 = G9();
            int size = MediaCompressUtils.f325262a.q(this.callback.a()).size();
            if (com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.manualTurnOnSmartClip && !this.isFromTemplateColl) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z16 && mediaProcessState.getUseVideoTemplate()) {
                z19 = true;
            } else {
                z19 = false;
            }
            G9.p(size, z18, z17, z17, z17, z19, mediaProcessState.getUseVideoTemplate(), false, !mediaProcessState.getUseVideoTemplate());
            G9().w();
            MediaInterceptorMonitor.f324886a.n(true);
        }
        return G9();
    }

    private final QCircleCommonLoadingDialog E9() {
        return (QCircleCommonLoadingDialog) this.downloadQZoneMediaDialog.getValue();
    }

    private final PhotoListLogicPreDealDialog G9() {
        return (PhotoListLogicPreDealDialog) this.processMediaDialog.getValue();
    }

    private final void H9() {
        LiveData<MediaProcessStateType> N1;
        com.tencent.mobileqq.wink.picker.core.viewmodel.m mVar = this.nextStepUIStateViewModel;
        if (mVar != null && (N1 = mVar.N1()) != null) {
            N1.observe(F9(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaPickerNextStepDialogPart.I9(WinkMediaPickerNextStepDialogPart.this, (MediaProcessStateType) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(WinkMediaPickerNextStepDialogPart this$0, MediaProcessStateType mediaProcessStateType) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (mediaProcessStateType == null) {
            i3 = -1;
        } else {
            i3 = c.f324538a[mediaProcessStateType.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    this$0.E9().dismiss();
                    return;
                } else {
                    this$0.E9().dismiss();
                    QQToast.makeText(this$0.getContext(), R.string.f238867kx, 1).show();
                    return;
                }
            }
            this$0.E9().dismiss();
            return;
        }
        this$0.E9().show();
    }

    private final void J9() {
        LiveData<MediaProcessState> O1;
        com.tencent.mobileqq.wink.picker.core.viewmodel.m mVar = this.nextStepUIStateViewModel;
        if (mVar != null && (O1 = mVar.O1()) != null) {
            O1.observe(F9(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMediaPickerNextStepDialogPart.K9(WinkMediaPickerNextStepDialogPart.this, (MediaProcessState) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(WinkMediaPickerNextStepDialogPart this$0, MediaProcessState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (c.f324538a[it.getType().ordinal()]) {
            case 1:
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.D9(it);
                return;
            case 2:
                this$0.G9().m();
                return;
            case 3:
                this$0.G9().m();
                if (it.getErrorMsgResId() != 0) {
                    QQToast.makeText(this$0.getContext(), it.getErrorMsgResId(), 1).show();
                    return;
                }
                return;
            case 4:
                int i3 = c.f324539b[it.getStep().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                this$0.D9(it).H(true);
                                return;
                            }
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        this$0.D9(it).F(true);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this$0.D9(it).D(true);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.D9(it).B(true);
                return;
            case 5:
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.D9(it).R(it.getProgress());
                return;
            case 6:
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.D9(it).P(it.getProgress());
                return;
            case 7:
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.D9(it).z(it.getItemIndex(), it.getProgress());
                return;
            case 8:
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.D9(it).K(it.getProgress());
                return;
            case 9:
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.D9(it).x();
                return;
            default:
                return;
        }
    }

    @NotNull
    public final Fragment F9() {
        Fragment fragment = this._fragment;
        if (fragment == null) {
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "{\n            hostFragment\n        }");
            return hostFragment;
        }
        Intrinsics.checkNotNull(fragment);
        return fragment;
    }

    public final void L9(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this._fragment = fragment;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "WinkMediaPickerProcessDialogPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        this.nextStepUIStateViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.e(F9());
        H9();
        J9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        if (this.isQZoneDialogInit && E9().isShowing()) {
            E9().dismiss();
        }
        if (this.isProcessMediaDialogInit && G9().t()) {
            G9().m();
        }
    }

    public WinkMediaPickerNextStepDialogPart(@NotNull a callback, boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.isFromTemplateColl = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new WinkMediaPickerNextStepDialogPart$downloadQZoneMediaDialog$2(this));
        this.downloadQZoneMediaDialog = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new WinkMediaPickerNextStepDialogPart$processMediaDialog$2(this));
        this.processMediaDialog = lazy2;
    }
}
