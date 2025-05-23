package com.tencent.mobileqq.wink.picker.qcircle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b93.OutputData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleCommentMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "", "", "", "getReportParams", "Ei", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Ze", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "a0", "Lkotlin/Lazy;", "Di", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleCommentMediaPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/QCircleCommentMediaPickerFragment$a", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements WinkMediaPickerNextStepDialogPart.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        @NotNull
        public List<LocalMediaInfo> a() {
            return QCircleCommentMediaPickerFragment.this.Wh().getSelectedMedia();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public boolean b() {
            return QCircleCommentMediaPickerFragment.this.Di().isRunning.get();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public void onCancelClick() {
            QCircleCommentMediaPickerFragment.this.Di().f();
        }
    }

    public QCircleCommentMediaPickerFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleCommentMediaPickerFragment$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                return new WinkMediaPickerNextStepHelper(q.e(QCircleCommentMediaPickerFragment.this));
            }
        });
        this.nextStepHelper = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMediaPickerNextStepHelper Di() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    private final String Ei() {
        Object obj;
        HashMap hashMap;
        Bundle arguments = getArguments();
        if (arguments != null) {
            obj = arguments.get("key_attrs");
        } else {
            obj = null;
        }
        if (obj instanceof HashMap) {
            hashMap = (HashMap) obj;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            return null;
        }
        return (String) hashMap.get("xsj_resource_type");
    }

    private final Map<String, Object> getReportParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("xsj_resource_type", Ei());
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public Config Fh(@NotNull Config config) {
        Object obj;
        HashMap hashMap;
        Config copy;
        Intrinsics.checkNotNullParameter(config, "config");
        TabType tabType = TabType.ALL_MEDIA;
        Bundle arguments = getArguments();
        String str = null;
        if (arguments != null) {
            obj = arguments.get("key_attrs");
        } else {
            obj = null;
        }
        if (obj instanceof HashMap) {
            hashMap = (HashMap) obj;
        } else {
            hashMap = null;
        }
        com.tencent.mobileqq.wink.schema.d dVar = com.tencent.mobileqq.wink.schema.d.f326305a;
        if (hashMap != null) {
            str = (String) hashMap.get(QCircleScheme.AttrQQPublish.PICKER_CONFIG);
        }
        Map<String, String> b16 = dVar.b(str);
        if (b16 != null) {
            tabType = TabType.INSTANCE.a(b16.get("tabType"));
        }
        copy = config.copy((r34 & 1) != 0 ? config.localMediaTabType : tabType, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : null, (r34 & 8) != 0 ? config.ZoneMediaTabType : null, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : 0, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : null, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : c.f324971a.c(), (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable LocalMediaInfo mediaInfo) {
        List<? extends LocalMediaInfo> listOf;
        Bundle bundle;
        List listOf2;
        if (mediaInfo == null) {
            return;
        }
        if (e93.i.I(mediaInfo)) {
            WinkMediaPickerNextStepHelper Di = Di();
            Activity hostActivity = getHostActivity();
            Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
            TabType localMediaTabType = Nh().getLocalMediaTabType();
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(mediaInfo);
            WinkMediaPickerNextStepHelper.i(Di, hostActivity, localMediaTabType, listOf2, false, MediaPickerScene.STANDARD, null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleCommentMediaPickerFragment$onMediaSelect$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Activity hostActivity2 = QCircleCommentMediaPickerFragment.this.getHostActivity();
                    Intrinsics.checkNotNullExpressionValue(hostActivity2, "hostActivity");
                    Intent intent = QCircleCommentMediaPickerFragment.this.getHostActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
                    com.tencent.mobileqq.wink.picker.g.d(hostActivity2, intent, it);
                }
            }, 32, null);
        } else {
            OutputData.Companion companion = OutputData.INSTANCE;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaInfo);
            Intent intent = getHostActivity().getIntent();
            if (intent != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            WinkContext.INSTANCE.d().m().k(getActivity(), companion.b(1L, listOf, null, bundle));
            SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 15, null));
        }
        Map<String, Object> reportParams = getReportParams();
        Intrinsics.checkNotNull(reportParams, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String?, kotlin.Any?>");
        Map asMutableMap = TypeIntrinsics.asMutableMap(reportParams);
        asMutableMap.put("dt_pgid", "pg_xsj_choose_media_new_page");
        asMutableMap.put("xsj_eid", "em_xsj_clck_preview");
        com.tencent.mobileqq.wink.picker.report.a.g(null, null, "em_xsj_clck_preview", asMutableMap, 2, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new WinkMediaPickerNextStepDialogPart(new a(), false, 2, null));
        return assembleParts;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity requireActivity = requireActivity();
        if (Ph().getAttachToWinkHome()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity, "pg_xsj_choose_media_new_page", false, null, i3, c.f324971a.b(this).getHasBanner(), false, getReportParams(), 128, null);
    }
}
