package com.qzone.reborn.part.plus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.feed.utils.QZonePlusIconBubbleController;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.ag;
import com.qzone.util.ak;
import com.qzone.util.l;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.entrancewidget.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QzoneWinkOutputRouter;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import ho.h;
import ho.i;
import java.util.HashMap;
import yo.g;

/* compiled from: P */
/* loaded from: classes37.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f58519a;

    /* renamed from: b, reason: collision with root package name */
    private final String f58520b;

    public f(Activity activity, String str) {
        this.f58519a = activity;
        this.f58520b = str;
    }

    private void a() {
        vo.c.u(this.f58519a, LoginData.getInstance().getUin(), QCircleDaTongConstant.ElementParamValue.PLUS);
    }

    private void b() {
        vo.c.W(this.f58519a);
    }

    private void c(String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(QzoneVerticalVideoConst.KEY_SUPPORTPIC, true);
        bundle.putInt(PeakConstants.KEY_ENTRY_SOURCE, 1);
        bundle.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, true);
        bundle.putString(AECameraConstants.KEY_CONFIRM_TEXT, l.a(R.string.rww));
        bundle.putDouble(AECameraConstants.KEY_LATITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).b());
        bundle.putDouble(AECameraConstants.KEY_LONGTITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).d());
        bundle.putInt("UseQQCameraCompression", QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, "UseQQCameraCompression", 2));
        ag.m(this.f58519a, PeakConstants.VIDEO_REFER_FROM_MOOD, bundle, str, true, new Object[0]);
    }

    private void d() {
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0(this.f58520b);
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        j(qZonePublishMoodInitBean);
        i.w().c(this.f58519a, qZonePublishMoodInitBean);
    }

    private void e() {
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM);
        Activity activity = this.f58519a;
        if (activity != null && QZonePermission.requestStoragePermission(activity, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            i(1, "toolBar");
        }
    }

    private void f() {
        int int4Uin = LocalMultiProcConfig.getInt4Uin("qzone_plus_live_show", 0, LoginData.getInstance().getUin());
        if (QZLog.isColorLevel()) {
            QZLog.d("QZonePlusMenuHelper", 2, "plusItemClickListener liveConfig:" + int4Uin);
        }
        if (int4Uin > 0) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_LIVE_VIDEO_ENTRY, "0", null);
            LpReportInfo_dc00321 lpReportInfo_dc00321 = new LpReportInfo_dc00321(com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
            lpReportInfo_dc00321.actiontype = 8;
            lpReportInfo_dc00321.subactiontype = 1;
            LpReportManager.getInstance().reportToDC00321(lpReportInfo_dc00321, false, true);
            yo.c.e(this.f58519a, int4Uin);
        }
    }

    private void g() {
        String str;
        Intent intent = new Intent();
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 10);
        intent.putExtra(QQWinkConstants.WINK_PUBLISH_TASK_ID, "qzone-synclingganku-0001");
        intent.putExtra(QQWinkConstants.IS_TO_TEMPLATE_TAB, true);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", lc.b.b().getName());
        intent.putExtra("key_need_save_draft", false);
        intent.putExtra(QQWinkConstants.KEY_QZONE_SYNC_QCIRCLE, LocalMultiProcConfig.getBoolean4Uin(LocalMultiProcConfig.QZONE_PERMISSION_PUBLIC, false, LoginData.getInstance().getUin()));
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_PART_NAME, QQWinkConstants.QZONE_LIBTEMPLATE);
        intent.putExtra("app_key", "0AND0MWZXR4U3RVU");
        intent.putExtra("wink_output_route", QzoneWinkOutputRouter.ROUTE_PATH);
        intent.putExtra("wink_output_point", 35L);
        try {
            if (QzoneFrame.isNewConciseFragment()) {
                str = WinkDaTongReportConstant.ElementParamValue.XSJ_QZONE_MODE_EXPERIENCE;
            } else {
                str = "normal";
            }
            intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, str);
            intent.putExtra("xsj_ref_pgid", "qzone_myshuoshuo_list_photo");
            intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_ENTRANCE, "qzone_plus");
        } catch (Exception e16) {
            QLog.i("QZonePlusMenuHelper", 1, "jumpToWinkTemplateFeed report error " + e16.getMessage());
            e16.printStackTrace();
        }
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkTemplateFeed(this.f58519a, intent);
    }

    private void j(QZonePublishMoodInitBean qZonePublishMoodInitBean) {
        QZoneBubbleInfo k3 = com.qzone.business.tianshu.c.j().k();
        if (k3 != null && !TextUtils.isEmpty(k3.getPublishTag()) && !TextUtils.isEmpty(k3.getPublishTagUin())) {
            qZonePublishMoodInitBean.J0(com.qzone.reborn.util.l.f59550a.e(PublishEventTag.assembleFakeTag(k3.getPublishTag(), k3.getPublishTagUin())));
        }
        if (QZonePlusIconBubbleController.d() != null) {
            ak.g(QZonePlusIconBubbleController.d(), 139);
            qZonePublishMoodInitBean.j0(String.valueOf(QZonePlusIconBubbleController.d().iAdId.get()));
        }
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("mqzone://arouse/writemood")) {
            d();
            return;
        }
        if (str.startsWith(QZoneJsConstants.SCHEME_PREFIX_UPLOAD_PHOTO)) {
            e();
            return;
        }
        if (str.startsWith("mqzone://arouse/takevideo")) {
            c(str);
            return;
        }
        if (str.startsWith("mqzone://arouse/newmoodsignin")) {
            b();
            return;
        }
        if (str.startsWith("mqzone://arouse/openluckymoneyvc")) {
            a();
            return;
        }
        if (str.startsWith("mqzone://arouse/launchlive")) {
            f();
            return;
        }
        if (str.startsWith("mqqapi://arouse/openqqpublish/mood?target=2")) {
            g();
            return;
        }
        if (str.startsWith("mqqapi://videostory/takevideo")) {
            b.d d16 = com.tencent.biz.videostory.entrancewidget.b.c().d(QCircleDaTongConstant.ElementParamValue.PLUS);
            if (VSConfigManager.c().h() && d16 != null) {
                String str2 = d16.f97118b;
                if (!TextUtils.isEmpty(str2)) {
                    str = str.replace("&widgetid=", "&widgetid=" + str2);
                    VSConfigManager.c().i();
                }
            }
            QQPlayerService.K0(this.f58519a);
            ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(this.f58519a, false, 5);
        }
        HashMap hashMap = new HashMap();
        g gVar = new g(str);
        gVar.f450714g = hashMap;
        gVar.m(this.f58519a);
    }

    public void i(int i3, String str) {
        h.f(this.f58519a, i3, str, 11);
    }
}
