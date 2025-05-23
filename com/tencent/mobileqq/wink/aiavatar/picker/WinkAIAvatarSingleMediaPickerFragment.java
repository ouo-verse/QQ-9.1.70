package com.tencent.mobileqq.wink.aiavatar.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarFinishEvent;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.report.AlbumSelectionData;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import cooperation.qzone.QzoneIPCModule;
import e93.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\"\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c0\u001bH\u0016R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarSingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Fi", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Ze", "gi", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "P5", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarMediaPickerViewModel;", "a0", "Lkotlin/Lazy;", "Di", "()Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarMediaPickerViewModel;", "viewModel", "<init>", "()V", "c0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarSingleMediaPickerFragment extends SingleMediaPickerFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f317757b0 = new LinkedHashMap();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarSingleMediaPickerFragment$a;", "", "Landroid/content/Context;", "context", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "ignoreContextExtras", "", "requestCode", "Landroid/content/Intent;", "a", "CAMERA_FRAGMENT_REQUEST_CODE", "I", "", "CAMERA_FRAGMENT_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarSingleMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull MetaMaterial material, boolean ignoreContextExtras, int requestCode) {
            Bundle extras;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(material, "material");
            Intent intent = new Intent();
            if ((context instanceof Activity) && !ignoreContextExtras && (extras = ((Activity) context).getIntent().getExtras()) != null) {
                intent.putExtras(extras);
            }
            WinkAIAvatarUtils.f317678a.e(intent);
            intent.putExtra("selected_style_material", material);
            intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
            intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, requestCode);
            UniversalMediaPickerFragment.Companion companion = UniversalMediaPickerFragment.INSTANCE;
            Config.Companion companion2 = Config.INSTANCE;
            Config.a aVar = new Config.a();
            aVar.i(TabType.ONLY_IMAGE);
            aVar.f(true);
            aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
            aVar.e(requestCode);
            Unit unit = Unit.INSTANCE;
            intent.putExtras(UniversalMediaPickerFragment.Companion.b(companion, aVar.a(), null, 2, null));
            return intent;
        }

        Companion() {
        }
    }

    public WinkAIAvatarSingleMediaPickerFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarMediaPickerViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarSingleMediaPickerFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarMediaPickerViewModel invoke() {
                return (WinkAIAvatarMediaPickerViewModel) WinkAIAvatarSingleMediaPickerFragment.this.getViewModel(WinkAIAvatarMediaPickerViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAIAvatarMediaPickerViewModel Di() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkAIAvatarMediaPickerViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(WinkAIAvatarSingleMediaPickerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(this$0.getActivity());
    }

    private final void Fi() {
        int i3;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (AppSetting.o(activity)) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            activity.setRequestedOrientation(i3);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public boolean P5(int requestCode) {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(QQWinkConstants.ENTRY_QQ_OTHER)) {
            w53.b.c("WinkAIAvatarSingleMediaPickerFragment", "onCaptureSelect camera res not ready");
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            com.tencent.mobileqq.emotionintegrate.media.b.d(activity, requestCode);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable final LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            w53.b.c("WinkAIAvatarSingleMediaPickerFragment", "select media is null");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            d93.c.INSTANCE.b(activity, i.x(mediaInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarSingleMediaPickerFragment$onMediaSelect$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WinkAIAvatarMediaPickerViewModel Di;
                    ArrayList arrayListOf;
                    Di = WinkAIAvatarSingleMediaPickerFragment.this.Di();
                    Context context = WinkAIAvatarSingleMediaPickerFragment.this.getContext();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(mediaInfo);
                    WinkAIAvatarMediaPickerViewModel.c2(Di, context, arrayListOf, null, 4, null);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.f317757b0.clear();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WinkAIAvatarFinishEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void gi() {
        w53.b.f(getTAG(), "onPickerExit invoke");
        AlbumSelectionData.a();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Activity activity;
        super.onActivityResult(requestCode, resultCode, data);
        Activity activity2 = null;
        if (requestCode != 100) {
            if (requestCode == 101) {
                if (data == null) {
                    Context context = getContext();
                    if (context != null) {
                        Di().h2(context);
                    }
                    w53.b.c("WinkAIAvatarSingleMediaPickerFragment", "onActivityResult intent is null, capture failed");
                    return;
                }
                if (resultCode == -1) {
                    Context context2 = getContext();
                    if (context2 instanceof Activity) {
                        activity = (Activity) context2;
                    } else {
                        activity = null;
                    }
                    if (activity != null) {
                        activity.setResult(-1, data);
                    }
                    Context context3 = getContext();
                    if (context3 instanceof Activity) {
                        activity2 = (Activity) context3;
                    }
                    if (activity2 != null) {
                        activity2.finish();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (data == null) {
            Context context4 = getContext();
            if (context4 != null) {
                Di().h2(context4);
            }
            w53.b.c("WinkAIAvatarSingleMediaPickerFragment", "onActivityResult intent is null, capture failed");
            return;
        }
        if (resultCode == -1) {
            Context context5 = getContext();
            if (context5 instanceof Activity) {
                activity2 = (Activity) context5;
            }
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Fi();
        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady();
        SimpleEventBus.getInstance().registerReceiver(this);
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        FragmentActivity activity;
        if (event instanceof WinkAIAvatarFinishEvent) {
            FragmentActivity activity2 = getActivity();
            boolean z16 = false;
            if (activity2 != null && !activity2.isFinishing()) {
                z16 = true;
            }
            if (z16 && (activity = getActivity()) != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.f
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarSingleMediaPickerFragment.Ei(WinkAIAvatarSingleMediaPickerFragment.this);
            }
        }, 16, null, true);
    }
}
