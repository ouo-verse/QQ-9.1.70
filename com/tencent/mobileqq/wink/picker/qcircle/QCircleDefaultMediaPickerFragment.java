package com.tencent.mobileqq.wink.picker.qcircle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b93.OutputData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.monitor.WinkPerformanceHelper;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleDefaultMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/UniversalMediaPickerFragment;", "", "Bi", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getLogTag", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "", "isFromQZoneMedia", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "di", "<init>", "()V", "Z", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleDefaultMediaPickerFragment extends UniversalMediaPickerFragment {
    private final void Bi() {
        Intent intent;
        String stringExtra;
        WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.T_PICKER_NO_SO).traceId(WinkPerformanceHelper.INSTANCE.a().getTraceId()).getReportData();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME)) != null) {
            WinkPublishReportQueue.INSTANCE.report(reportData, stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public Config Fh(@NotNull Config config) {
        Config copy;
        Intrinsics.checkNotNullParameter(config, "config");
        MediaFilter.Companion companion = MediaFilter.INSTANCE;
        MediaFilter.a aVar = new MediaFilter.a();
        aVar.g(WinkConfig.f317649a.a());
        aVar.k(1500000000L);
        Unit unit = Unit.INSTANCE;
        copy = config.copy((r34 & 1) != 0 ? config.localMediaTabType : null, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : null, (r34 & 8) != 0 ? config.ZoneMediaTabType : null, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : 0, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : null, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : aVar.a(), (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.QVideoDefault;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        Bundle bundle;
        w53.b.f("QCircleDefaultMediaPickerFragment", "onNextBtnClick");
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (companion.d().u("QCIRCLE")) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                com.tencent.mobileqq.wink.picker.g gVar = com.tencent.mobileqq.wink.picker.g.f324860a;
                Intent intent = activity.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "it.intent");
                gVar.g(activity, intent, new ArrayList(Wh().getSelectedMedia()));
                return;
            }
            return;
        }
        OutputData.Companion companion2 = OutputData.INSTANCE;
        List<LocalMediaInfo> selectedMedia2 = Wh().getSelectedMedia();
        Intent intent2 = getHostActivity().getIntent();
        if (intent2 != null) {
            bundle = intent2.getExtras();
        } else {
            bundle = null;
        }
        companion.d().m().k(requireActivity(), companion2.b(1L, selectedMedia2, null, bundle));
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleDefaultMediaPickerFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bi();
    }
}
