package com.tencent.mobileqq.wink.picker.qcircle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleAvatarPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Landroid/view/View;", "view", "", "elementId", "", "", "extParams", "", "Ci", "Bi", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Ze", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "<init>", "()V", "a0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleAvatarPickerFragment extends SingleMediaPickerFragment {
    private final void Bi() {
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_AVATAR_ADJUST_PAGE);
        map.put("xsj_eid", "em_xsj_return_button");
        VideoReport.reportEvent("dt_clck", map);
    }

    private final void Ci(View view, String elementId, Map<String, ? extends Object> extParams) {
        boolean z16;
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (extParams != null && !extParams.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            buildElementParams.putAll(extParams);
        }
        VideoReport.setPageId(getFragmentContentView(), "pg_xsj_choose_media_new_page");
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public Config Fh(@NotNull Config config) {
        Config copy;
        Intrinsics.checkNotNullParameter(config, "config");
        copy = config.copy((r34 & 1) != 0 ? config.localMediaTabType : TabType.ONLY_IMAGE, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : null, (r34 & 8) != 0 ? config.ZoneMediaTabType : null, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : 0, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : null, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : null, (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.QVideoAvatar;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable LocalMediaInfo mediaInfo) {
        String str;
        Intent intent;
        if (mediaInfo == null) {
            return;
        }
        File file = new File(mediaInfo.path);
        String str2 = com.tencent.mobileqq.qcircle.api.constant.a.f261580e + "qcircle_thumb" + File.separator + "thumb_" + System.currentTimeMillis() + "_" + u.i2(file.getName()) + ".jpg";
        Intent intent2 = new Intent();
        intent2.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
        intent2.putExtra("FROM_WHERE", "FROM_QCIRCLE_AVATAR");
        intent2.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
        intent2.putExtra(PeakConstants.REQUEST_CODE, 10019);
        intent2.putExtra(PeakConstants.TITLE_BAR_BLACK_BG, true);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra(QQWinkConstants.AVATAR_OLD_HD_PATH);
        } else {
            str = null;
        }
        intent2.putExtra(QQWinkConstants.AVATAR_OLD_HD_PATH, str);
        ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEditForResult(getActivity(), intent2, mediaInfo.path, str2, 106, 10019);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleAvatarPickerFragment";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bi();
        if (requestCode == 10019 && resultCode == -1) {
            FragmentActivity requireActivity = requireActivity();
            requireActivity.setResult(-1, data);
            requireActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ci(view, "em_xsj_content", null);
        View findViewById = view.findViewById(R.id.ivTitleBtnLeft);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.te\u2026qqui.R.id.ivTitleBtnLeft)");
        Ci(findViewById, "em_xsj_close_button", null);
    }
}
