package d63;

import android.widget.RelativeLayout;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0018\u0010\n\u001a\u00020\u0005*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u001a\n\u0010\u000b\u001a\u00020\u0005*\u00020\u0000\u001a\u0012\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/WinkEditorClippingFragment;", "Landroid/widget/RelativeLayout;", "smartClipBtn", "", "isStatusOn", "", "b", "", "Lcom/tencent/videocut/model/MediaClip;", "videos", "c", "d", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "f", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    public static final void b(@NotNull WinkEditorClippingFragment winkEditorClippingFragment, @NotNull RelativeLayout smartClipBtn, boolean z16) {
        Intrinsics.checkNotNullParameter(winkEditorClippingFragment, "<this>");
        Intrinsics.checkNotNullParameter(smartClipBtn, "smartClipBtn");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_MUSIC_BUTTON);
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_SETTING_CLCK_STATUS, Integer.valueOf(z16 ? 1 : 0));
        VideoReport.reportEvent("ev_xsj_camera_action", smartClipBtn, buildElementParams);
    }

    public static final void c(@NotNull WinkEditorClippingFragment winkEditorClippingFragment, @NotNull List<? extends MediaClip> videos) {
        float f16;
        boolean z16;
        Intrinsics.checkNotNullParameter(winkEditorClippingFragment, "<this>");
        Intrinsics.checkNotNullParameter(videos, "videos");
        StringBuilder sb5 = new StringBuilder();
        boolean z17 = false;
        int i3 = 0;
        for (Object obj : videos) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MediaClip mediaClip = (MediaClip) obj;
            if (i3 > 0) {
                sb5.append(",");
            }
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                f16 = (((float) resourceModel.selectDuration) * 1.0f) / ((float) resourceModel.scaleDuration);
            } else {
                f16 = 1.0f;
            }
            if (f16 == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
            sb5.append(f16);
            i3 = i16;
        }
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_CLCK_CAMERA_CUT_FINISH, 1);
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_SPEED_LIST, sb5);
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SPEED_CHANGE, Boolean.valueOf(z17));
    }

    public static final void d(@NotNull WinkEditorClippingFragment winkEditorClippingFragment) {
        Intrinsics.checkNotNullParameter(winkEditorClippingFragment, "<this>");
        ThreadManagerV2.excute(new Runnable() { // from class: d63.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e();
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        long timeCost = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_TIMELINE_GENERATE, 5);
        if (timeCost <= 0) {
            return;
        }
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Long valueOf = Long.valueOf(timeCost);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TIMELINE_GENERATE_TIME, valueOf);
    }

    public static final void f(@NotNull WinkEditorClippingFragment winkEditorClippingFragment, int i3) {
        Intrinsics.checkNotNullParameter(winkEditorClippingFragment, "<this>");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_VOLUME_ADJUST_PANEL);
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_VALUE, Float.valueOf(i3 / 100.0f));
        VideoReport.reportEvent("ev_xsj_camera_action", null, buildElementParams);
    }
}
