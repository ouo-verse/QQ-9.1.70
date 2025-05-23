package com.tencent.mobileqq.wink.picker.qcircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.InitBean;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopBannerPart;
import com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopDetectFacePart;
import com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.TemplateLibMediaPickerFactory;
import com.tencent.mobileqq.wink.picker.qcircle.viewmodel.QCircleTemplateMediaPickerViewModel;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u001a\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J \u0010%\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J \u0010&\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleTemplateLibraryMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "Lcom/tencent/mobileqq/wink/picker/InitBean;", "", "Ji", "Ei", "", "", "", "Fi", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Zh", "Oh", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "Landroid/content/Context;", "context", "onAttach", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getLogTag", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "di", "hi", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "X", "Lkotlin/Lazy;", "Hi", "()Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "templateMediaPickerViewModel", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "Y", "Gi", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Ii", "()Z", "isZShowMaterial", "<init>", "()V", "a0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleTemplateLibraryMediaPickerFragment extends WinkMediaPickerMainBaseFragment<InitBean> {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy templateMediaPickerViewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    @NotNull
    public Map<Integer, View> Z = new LinkedHashMap();

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004Ju\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleTemplateLibraryMediaPickerFragment$a;", "", "Landroid/content/Context;", "context", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "templateLibraryMaterial", "Landroid/content/Intent;", "a", "", "traceId", "Lcom/tencent/mobileqq/wink/picker/TabType;", "mediaPickerTabType", "", "needFaceDetect", "", "holderTimeSlot", "", "toReplacedMediaIndex", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedMediaPath", "originalAssetData", "b", "(Landroid/content/Context;Ljava/lang/String;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/picker/TabType;Ljava/lang/Boolean;FILjava/util/ArrayList;Ljava/lang/String;)Landroid/content/Intent;", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull MetaMaterial templateLibraryMaterial) {
            Bundle bundle;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(templateLibraryMaterial, "templateLibraryMaterial");
            Intent intent = new Intent();
            if (context instanceof Activity) {
                bundle = ((Activity) context).getIntent().getExtras();
            } else {
                bundle = null;
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.setClass(context, QQWinkActivity.class);
            intent.putExtra("public_fragment_class", QCircleTemplateLibraryMediaPickerFragment.class.getName());
            intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
            intent.putExtra(QQWinkConstants.MEDIA_PICKER_SCENE, MediaPickerScene.TEMPLATE_LIBRARY);
            intent.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, templateLibraryMaterial);
            return intent;
        }

        @NotNull
        public final Intent b(@NotNull Context context, @Nullable String traceId, @Nullable MetaMaterial templateLibraryMaterial, @Nullable TabType mediaPickerTabType, @Nullable Boolean needFaceDetect, float holderTimeSlot, int toReplacedMediaIndex, @Nullable ArrayList<String> selectedMediaPath, @Nullable String originalAssetData) {
            Activity activity;
            Serializable serializable;
            MediaPickerScene mediaPickerScene;
            MediaPickerScene mediaPickerScene2;
            String str;
            Intent intent;
            Intent intent2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent3 = new Intent();
            intent3.setClass(context, QQWinkActivity.class);
            intent3.putExtra("public_fragment_class", QCircleTemplateLibraryMediaPickerFragment.class.getName());
            intent3.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
            boolean z16 = context instanceof Activity;
            Activity activity2 = null;
            if (z16) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                serializable = intent2.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
            } else {
                serializable = null;
            }
            if (serializable instanceof MediaPickerScene) {
                mediaPickerScene = (MediaPickerScene) serializable;
            } else {
                mediaPickerScene = null;
            }
            if (mediaPickerScene == null) {
                mediaPickerScene = MediaPickerScene.TEMPLATE_LIBRARY;
            }
            if (mediaPickerScene == MediaPickerScene.TEMPLATE_ZSHOW) {
                mediaPickerScene2 = MediaPickerScene.TEMPLATE_ZSHOW_REPLACE;
            } else {
                mediaPickerScene2 = MediaPickerScene.TEMPLATE_LIBRARY_REPLACE;
            }
            intent3.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
            intent3.putExtra(QQWinkConstants.MEDIA_PICKER_SCENE, mediaPickerScene2);
            intent3.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, templateLibraryMaterial);
            intent3.putExtra(QQWinkConstants.MEDIA_PICKER_TAB_TYPE, mediaPickerTabType);
            intent3.putExtra(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT, needFaceDetect);
            intent3.putExtra(QQWinkConstants.MEDIA_PICKER_TEMPLATE_LIBRARY_HOLDER_TIME_SLOT, holderTimeSlot);
            intent3.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_INDEX, toReplacedMediaIndex);
            intent3.putExtra(QQWinkConstants.PICK_TEMPLATE_SELECTED_RECORD, selectedMediaPath);
            intent3.putExtra(QQWinkConstants.PICK_TEMPLATE_CLIP_SCRIPT_PARAMS, originalAssetData);
            if (z16) {
                activity2 = (Activity) context;
            }
            if (activity2 == null || (intent = activity2.getIntent()) == null || (str = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME)) == null) {
                str = "QCIRCLE";
            }
            intent3.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, str);
            return intent3;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/QCircleTemplateLibraryMediaPickerFragment$b", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkMediaPickerNextStepDialogPart.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        @NotNull
        public List<LocalMediaInfo> a() {
            return QCircleTemplateLibraryMediaPickerFragment.this.Wh().getSelectedMedia();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public boolean b() {
            return QCircleTemplateLibraryMediaPickerFragment.this.Gi().isRunning.get();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public void onCancelClick() {
            QCircleTemplateLibraryMediaPickerFragment.this.Gi().f();
        }
    }

    public QCircleTemplateLibraryMediaPickerFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QCircleTemplateMediaPickerViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment$templateMediaPickerViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QCircleTemplateMediaPickerViewModel invoke() {
                return c.f324971a.f(QCircleTemplateLibraryMediaPickerFragment.this);
            }
        });
        this.templateMediaPickerViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                return new WinkMediaPickerNextStepHelper(q.e(QCircleTemplateLibraryMediaPickerFragment.this));
            }
        });
        this.nextStepHelper = lazy2;
    }

    private final void Ei() {
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MEDIA_IMPORT);
        w53.b.f("QCircleMediaPickerFragment", "performClickNextStep invoke, selectedMedia.size=" + Wh().getSelectedMedia().size() + ", ");
        WinkContext.Companion companion = WinkContext.INSTANCE;
        String str = null;
        Bundle bundle = null;
        if (companion.d().u("ECOMMERCE")) {
            OutputData.Companion companion2 = OutputData.INSTANCE;
            List<LocalMediaInfo> selectedMedia = Wh().getSelectedMedia();
            Intent intent = getHostActivity().getIntent();
            if (intent != null) {
                bundle = intent.getExtras();
            }
            companion.d().m().k(requireActivity(), companion2.b(1L, selectedMedia, null, bundle));
            return;
        }
        final Intent intent2 = new Intent();
        Intent intent3 = getHostActivity().getIntent();
        if (intent3 != null) {
            Intrinsics.checkNotNullExpressionValue(intent3, "intent");
            intent2.putExtras(intent3);
            MetaMaterial templateLibMaterial = Hi().getTemplateLibMaterial();
            if (templateLibMaterial != null) {
                str = templateLibMaterial.f30533id;
            }
            intent2.putExtra("lib_template_id", str);
        }
        WinkMediaPickerNextStepHelper Gi = Gi();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        WinkMediaPickerNextStepHelper.i(Gi, hostActivity, Nh().getLocalMediaTabType(), Wh().getSelectedMedia(), false, Hi().getMediaPickerScene(), null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment$autoTemplateJumpToWinkEditor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                invoke2(mediaPickerOutput);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MediaPickerOutput it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Activity hostActivity2 = QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity();
                Intrinsics.checkNotNullExpressionValue(hostActivity2, "hostActivity");
                com.tencent.mobileqq.wink.picker.g.d(hostActivity2, intent2, it);
            }
        }, 32, null);
    }

    private final Map<String, Object> Fi() {
        boolean z16;
        Intent intent;
        String stringExtra;
        TemplateLibraryData Q1 = Hi().Q1();
        HashMap hashMap = new HashMap();
        String str = "";
        if (Q1 != null) {
            String str2 = Q1.getTemplateLibraryMaterial().f30533id;
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("xsj_template_id", str2);
            String a06 = com.tencent.mobileqq.wink.editor.c.a0(Q1.getTemplateLibraryMaterial());
            if (a06 == null) {
                a06 = "";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, a06);
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_TYPE));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PAITONGKUAN_ID));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE));
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE)) != null) {
            str = stringExtra;
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, str);
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, str);
        } else {
            WinkDatongCurrentParams.params.remove(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMediaPickerNextStepHelper Gi() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleTemplateMediaPickerViewModel Hi() {
        return (QCircleTemplateMediaPickerViewModel) this.templateMediaPickerViewModel.getValue();
    }

    private final boolean Ii() {
        Serializable serializable;
        Intent intent;
        Activity hostActivity = getHostActivity();
        MediaPickerScene mediaPickerScene = null;
        if (hostActivity != null && (intent = hostActivity.getIntent()) != null) {
            serializable = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
        } else {
            serializable = null;
        }
        if (serializable instanceof MediaPickerScene) {
            mediaPickerScene = (MediaPickerScene) serializable;
        }
        if (mediaPickerScene == MediaPickerScene.TEMPLATE_ZSHOW_REPLACE) {
            return true;
        }
        return false;
    }

    private final void Ji() {
        ArrayList arrayList;
        final TemplateLibraryData Q1;
        String str;
        LocalMediaInfo mediaInfo;
        if (!NetworkUtil.isNetworkAvailable()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.m
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleTemplateLibraryMediaPickerFragment.Ki(QCircleTemplateLibraryMediaPickerFragment.this);
                }
            });
            return;
        }
        final List<TemplateLibraryHolderInfo> value = Hi().a2().getValue();
        if (value == null) {
            return;
        }
        if (Hi().o2()) {
            arrayList = new ArrayList();
            for (TemplateLibraryHolderInfo templateLibraryHolderInfo : value) {
                if (templateLibraryHolderInfo.getMediaInfo() == null) {
                    mediaInfo = ba3.a.a();
                } else {
                    mediaInfo = templateLibraryHolderInfo.getMediaInfo();
                }
                if (mediaInfo != null) {
                    arrayList.add(mediaInfo);
                }
            }
        } else {
            arrayList = new ArrayList();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                LocalMediaInfo mediaInfo2 = ((TemplateLibraryHolderInfo) it.next()).getMediaInfo();
                if (mediaInfo2 != null) {
                    arrayList.add(mediaInfo2);
                }
            }
        }
        final ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty() || (Q1 = Hi().Q1()) == null) {
            return;
        }
        if (Hi().getMediaPickerScene() == MediaPickerScene.TEMPLATE_LIBRARY) {
            if (Hi().getTemplateLibMaterial() != null) {
                WinkEditorResourceManager a16 = WinkEditorResourceManager.a1();
                MetaMaterial templateLibMaterial = Hi().getTemplateLibMaterial();
                Intrinsics.checkNotNull(templateLibMaterial);
                if (a16.q(templateLibMaterial)) {
                    String a06 = com.tencent.mobileqq.wink.editor.c.a0(Q1.getTemplateLibraryMaterial());
                    String str2 = Q1.getTemplateLibraryMaterial().f30533id;
                    Intrinsics.checkNotNullExpressionValue(str2, "templateLibraryData.templateLibraryMaterial.id");
                    com.tencent.mobileqq.wink.picker.report.a.e(getView(), "ev_xsj_camera_action", com.tencent.mobileqq.wink.picker.report.a.m(WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON, arrayList2, a06, str2));
                }
            }
            MetaMaterial templateLibMaterial2 = Hi().getTemplateLibMaterial();
            if (templateLibMaterial2 != null) {
                str = templateLibMaterial2.f30533id;
            } else {
                str = null;
            }
            w53.b.c("QCircleTemplateLibraryMediaPickerFragment", "id:" + str + ", template dir is not exits!");
            return;
        }
        Q1.e(getHostActivity().getIntent().getStringExtra(QQWinkConstants.PICK_TEMPLATE_CLIP_SCRIPT_PARAMS));
        w53.b.f("QCircleTemplateLibraryMediaPickerFragment", "performClickNextStep invoke, selectedMedia.size=" + Wh().getSelectedMedia().size() + ", useVideoTemplate=false");
        WinkMediaPickerNextStepHelper Gi = Gi();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        Gi.h(hostActivity, Nh().getLocalMediaTabType(), arrayList2, false, Hi().getMediaPickerScene(), Q1, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment$templateJumpToWinkEditor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                invoke2(mediaPickerOutput);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MediaPickerOutput it5) {
                QCircleTemplateMediaPickerViewModel Hi;
                Intrinsics.checkNotNullParameter(it5, "it");
                Hi = QCircleTemplateLibraryMediaPickerFragment.this.Hi();
                if (Hi.getMediaPickerScene() == MediaPickerScene.TEMPLATE_LIBRARY) {
                    QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity().getIntent().putExtra("template_holder_slot", new ArrayList(value));
                    Intent intent = QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity().getIntent();
                    List<LocalMediaInfo> list = arrayList2;
                    boolean z16 = false;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it6 = list.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                break;
                            } else if (e93.i.D((LocalMediaInfo) it6.next())) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    intent.putExtra(QQWinkConstants.NEED_AUTO_FILL_TEMPLATE_LIBRARY_HOLDERS, z16);
                    Activity hostActivity2 = QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity();
                    Intrinsics.checkNotNullExpressionValue(hostActivity2, "hostActivity");
                    Intent intent2 = QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent2, "hostActivity.intent");
                    com.tencent.mobileqq.wink.picker.g.d(hostActivity2, intent2, it5);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_INDEX, Q1.getToReplacedMediaIndex());
                intent3.putExtra(QQWinkConstants.INPUT_MEDIA_ORIGINAL, new ArrayList(it5.f()));
                intent3.putExtra(QQWinkConstants.MEDIA_PICKER_TEMPLATE_LIBRARY_HOLDER_TIME_SLOT, QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity().getIntent().getFloatExtra(QQWinkConstants.MEDIA_PICKER_TEMPLATE_LIBRARY_HOLDER_TIME_SLOT, 0.0f));
                intent3.putExtra("key_template_asset", it5.getVideoTemplateData().getTemplateJsAsset());
                List<LocalMediaInfo> e16 = it5.e();
                if (e16 != null) {
                    intent3.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(e16));
                }
                QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity().setResult(-1, intent3);
                QCircleTemplateLibraryMediaPickerFragment.this.getHostActivity().finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(QCircleTemplateLibraryMediaPickerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getActivity(), R.string.f240027o2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public Config Fh(@NotNull Config config) {
        MediaFilter c16;
        Config copy;
        Config copy2;
        Intrinsics.checkNotNullParameter(config, "config");
        if (Hi().getIsAutoTempPicker()) {
            QLog.d("QCircleTemplateLibraryMediaPickerFragment", 1, "AutoTempPicker-Yes \u4f20\u5165 config.maxSize:" + config.getMaxSelectMediaSize() + ", vmModel.maxHolderCount:" + Hi().getMediaHolderCount());
            copy2 = config.copy((r34 & 1) != 0 ? config.localMediaTabType : null, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : null, (r34 & 8) != 0 ? config.ZoneMediaTabType : TabType.ALL_MEDIA, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : 0, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : null, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : c.f324971a.c(), (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
            return copy2;
        }
        QLog.d("QCircleTemplateLibraryMediaPickerFragment", 1, "AutoTempPicker-No \u4f20\u5165 config.maxSize:" + config.getMaxSelectMediaSize() + ", vmModel.maxHolderCount:" + Hi().getMediaHolderCount());
        TabType tabType = Hi().getTabType();
        TabType tabType2 = Hi().getTabType();
        int mediaHolderCount = Hi().getMediaHolderCount();
        if (Ii()) {
            c16 = c.f324971a.e();
        } else {
            c16 = c.f324971a.c();
        }
        copy = config.copy((r34 & 1) != 0 ? config.localMediaTabType : tabType, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : tabType2, (r34 & 8) != 0 ? config.ZoneMediaTabType : null, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : mediaHolderCount, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : null, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : c16, (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public InitBean Oh() {
        return new InitBean(false, null, 3, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.Inspiration;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.d Zh() {
        return new TemplateLibMediaPickerFactory(Hi(), Hi().getIsAutoTempPicker());
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.Z.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        QQWinkActivity qQWinkActivity;
        byte b16;
        List<Part> assembleParts = super.assembleParts();
        boolean z16 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        assembleParts.add(new WinkMediaPickerNextStepDialogPart(new b(), false, 2, null));
        boolean z17 = true;
        z17 = true;
        if (Hi().getNeedFaceDetect()) {
            assembleParts.add(new QCircleMediaPickerTopBannerPart(true));
            Activity hostActivity = getHostActivity();
            if (hostActivity instanceof QQWinkActivity) {
                qQWinkActivity = (QQWinkActivity) hostActivity;
            } else {
                qQWinkActivity = null;
            }
            if (qQWinkActivity != null && qQWinkActivity.J2()) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 != false) {
                if (!QQTheme.isNowThemeIsNight() && !QQTheme.isDefaultTheme()) {
                    z17 = false;
                }
            } else {
                z17 = QQTheme.isNowThemeIsNight();
            }
            assembleParts.add(new QCircleMediaPickerTopDetectFacePart(z17, false, 2, null));
        } else {
            assembleParts.add(new QCircleMediaPickerTopBannerPart(z16, z17 ? 1 : 0, defaultConstructorMarker));
        }
        return assembleParts;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        if (Hi().getIsAutoTempPicker()) {
            Ei();
        } else {
            Ji();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g67;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleTemplateLibraryMediaPickerFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        QCircleTemplateMediaPickerViewModel Hi = Hi();
        Intent intent = getHostActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
        Hi.e2(intent);
        Wh().h2(Hi().getNeedFaceDetect());
        if (Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE") && Wh().getNeedFaceDetectWhenSelect()) {
            ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport("exp_xsj_fbq_aiface_cluster_v2");
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Gi().p();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Intent intent;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        t53.a.b(intent, t53.a.f435443a.d(), new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment$onResume$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                dc5507Report.b(1002);
                dc5507Report.j(1);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.yzh);
        findViewById.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        if (Hi().getIsAutoTempPicker()) {
            findViewById.setVisibility(8);
        }
        ((ConstraintLayout) view.findViewById(R.id.root)).setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity(), "pg_xsj_choose_media_new_page", true, Fi(), 0, false, false, null, 480, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void hi(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
    }
}
