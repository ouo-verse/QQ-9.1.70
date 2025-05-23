package com.tencent.mobileqq.wink.aiavatar.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarFinishEvent;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.report.AlbumSelectionData;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0014J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001eH\u0016J\u001a\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarCoupleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/UniversalMediaPickerFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Gi", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Zh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "di", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "gi", "event", "onReceiveEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "P5", "Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarMediaPickerViewModel;", "Z", "Lkotlin/Lazy;", "Ei", "()Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarMediaPickerViewModel;", "viewModel", "<init>", "()V", "b0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarCoupleMediaPickerFragment extends UniversalMediaPickerFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f317747a0 = new LinkedHashMap();

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J8\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarCoupleMediaPickerFragment$a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMedias", "", "Lcom/tencent/mobileqq/wink/picker/MediaInfo;", "b", "Landroid/content/Context;", "context", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "ignoreContextExtras", "", "requestCode", "selectedMedia", "Landroid/content/Intent;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarCoupleMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
        
            if (r3 == null) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final List<MediaInfo> b(List<? extends LocalMediaInfo> localMedias) {
            String str;
            MediaType mediaType;
            Object orNull;
            ArrayList arrayList = new ArrayList();
            if (localMedias != null) {
                for (LocalMediaInfo localMediaInfo : localMedias) {
                    ArrayList<String> mOriginPath = localMediaInfo.mOriginPath;
                    if (mOriginPath != null) {
                        Intrinsics.checkNotNullExpressionValue(mOriginPath, "mOriginPath");
                        orNull = CollectionsKt___CollectionsKt.getOrNull(mOriginPath, 0);
                        str = (String) orNull;
                    }
                    str = localMediaInfo.path;
                    String localMediaPath = str;
                    if (localMediaPath != null) {
                        Intrinsics.checkNotNullExpressionValue(localMediaPath, "localMediaPath");
                        if (localMediaInfo.isCaptured) {
                            w53.b.f("WinkAIAvatarCoupleMediaPickerFragment", "getMediaInfoFromLocalMediaInfo " + localMediaInfo.path + " isCaptured");
                        }
                        if (localMediaInfo.isCaptured) {
                            mediaType = MediaType.TEMP_CAPTURED;
                        } else {
                            mediaType = MediaType.LOCAL_IMAGE;
                        }
                        arrayList.add(new MediaInfo(mediaType, null, 0, 0, localMediaPath, null, null, 0, 0, null, null, 0L, 4078, null));
                    }
                }
            }
            return arrayList;
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull MetaMaterial material, boolean ignoreContextExtras, int requestCode, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
            List<MediaInfo> list;
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
            aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
            if (selectedMedia != null && (!selectedMedia.isEmpty())) {
                list = CollectionsKt___CollectionsKt.toList(WinkAIAvatarCoupleMediaPickerFragment.INSTANCE.b(selectedMedia));
                aVar.c(list);
            }
            aVar.j(2);
            aVar.f(true);
            aVar.g(AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER_FROM_AI_AVATAR_CP);
            aVar.l(false);
            Unit unit = Unit.INSTANCE;
            intent.putExtras(UniversalMediaPickerFragment.Companion.b(companion, aVar.a(), null, 2, null));
            return intent;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarCoupleMediaPickerFragment$b", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaPickerFactory;", "", "requestCode", "", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends UniversalMediaPickerFactory {
        b() {
            super(false);
        }

        @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
        public boolean c(int requestCode) {
            return WinkAIAvatarCoupleMediaPickerFragment.this.P5(requestCode);
        }
    }

    public WinkAIAvatarCoupleMediaPickerFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarMediaPickerViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarCoupleMediaPickerFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarMediaPickerViewModel invoke() {
                return (WinkAIAvatarMediaPickerViewModel) WinkAIAvatarCoupleMediaPickerFragment.this.getViewModel(WinkAIAvatarMediaPickerViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAIAvatarMediaPickerViewModel Ei() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkAIAvatarMediaPickerViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(WinkAIAvatarCoupleMediaPickerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(this$0.getActivity());
    }

    private final void Gi() {
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

    public final boolean P5(int requestCode) {
        Resources resources;
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(QQWinkConstants.ENTRY_QQ_OTHER)) {
            return false;
        }
        String str = null;
        if (Wh().b2()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                com.tencent.mobileqq.emotionintegrate.media.b.e(activity, 0, 2, null);
            }
        } else if (!FastClickUtils.isFastDoubleClick("key_show_toast_interval", 2000L)) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (resources = activity2.getResources()) != null) {
                str = resources.getString(R.string.f174142v2, Integer.valueOf(Wh().getMaxSelectMediaSize()));
            }
            QQToast.makeText(getActivity(), str + "\u56fe\u7247", 0).show();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.d Zh() {
        return new b();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.f317747a0.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new a());
        return assembleParts;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        FragmentActivity activity;
        if (!Wh().getSelectedMedia().isEmpty() && (activity = getActivity()) != null) {
            d93.c.INSTANCE.c(activity, Wh().getSelectedMedia(), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarCoupleMediaPickerFragment$onNextBtnClick$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    WinkSelectedMediaViewModel Wh;
                    WinkAIAvatarMediaPickerViewModel Ei;
                    bg bgVar = bg.f302144a;
                    Wh = WinkAIAvatarCoupleMediaPickerFragment.this.Wh();
                    ArrayList n3 = bgVar.n(Wh.getSelectedMedia());
                    Ei = WinkAIAvatarCoupleMediaPickerFragment.this.Ei();
                    WinkAIAvatarMediaPickerViewModel.c2(Ei, WinkAIAvatarCoupleMediaPickerFragment.this.getContext(), n3, null, 4, null);
                }
            });
        }
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
        ArrayList arrayList;
        boolean z16;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4) {
            if (data == null) {
                w53.b.c("WinkAIAvatarCoupleMediaPickerFragment", "onActivityResult intent is null");
                return;
            }
            Serializable serializableExtra = data.getSerializableExtra("OUTPUT_MEDIA");
            if (serializableExtra instanceof ArrayList) {
                arrayList = (ArrayList) serializableExtra;
            } else {
                arrayList = null;
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && resultCode == -1) {
                Object obj = arrayList.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "outputMedia[0]");
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                localMediaInfo.isCaptured = true;
                WinkSelectedMediaViewModel.P1(Wh(), localMediaInfo, 0, 2, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Gi();
        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady();
        SimpleEventBus.getInstance().registerReceiver(this);
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
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
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.b
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarCoupleMediaPickerFragment.Fi(WinkAIAvatarCoupleMediaPickerFragment.this);
            }
        }, 16, null, true);
    }
}
