package com.qzone.reborn.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.feed.utils.QZonePlusIconBubbleController;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.publish.bean.QZonePublishTagBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.ak;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J`\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t`\n2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f`\nH\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0002J\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ^\u0010\"\u001a\u00020\u000e2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t`\n2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f`\nJ\u0012\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010#J\u001a\u0010+\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010,\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010-\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010/\u001a\u00020.2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u00102\u001a\u00020.2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u00101\u001a\u0004\u0018\u000100J\u001a\u00103\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u00104\u001a\u00020.2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u00105\u001a\u00020.2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u00106\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u00107\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u00108\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u00109\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010:\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010;\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010<\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001c\u0010=\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010>\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J.\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`@2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010B\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010C\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010D\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010E\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010F\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010G\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010H\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010I\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010J\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010K\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010L\u001a\u00020.2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010M\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010N\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010O\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010P\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010Q\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010R\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010S\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J.\u0010T\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010?j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`@2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010U\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u001a\u0010V\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u0010\u0010W\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0016J\u001a\u0010X\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u000e\u0010Z\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020.\u00a8\u0006]"}, d2 = {"Lcom/qzone/reborn/util/l;", "", "", "M", "K", "", "originPath", "finalPath", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/HashMap;", "selectedMediaInfoMap", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "selectedVideoInfoMap", "", "Z", "X", "state", "b0", "Y", "c0", "a0", "Lcom/qzone/reborn/route/QZonePublishMoodInitBean;", "bean", "d0", "V", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/Fragment;", "hostFragment", "U", "T", "", "list", "b", "Lcom/qzone/common/event/ui/model/PublishEventTag;", "eventTag", "Lcom/qzone/reborn/publish/bean/QZonePublishTagBean;", "e", "initBean", "Landroid/content/Intent;", "intent", "", "u", "o", ExifInterface.LATITUDE_SOUTH, "", "v", "Landroid/os/Bundle;", "bundle", "w", "P", "p", "r", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f", "c", "E", "d", UserInfo.SEX_FEMALE, "D", "t", HippyTKDListViewAdapter.X, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "W", "O", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Req, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "l", "G", "k", "L", "J", tl.h.F, "i", "g", "H", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "N", "a", "uploadEntrance", "j", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f59550a = new l();

    l() {
    }

    private final boolean K() {
        if (!TextUtils.isEmpty(u5.b.S("_shuoshuo", LoginData.getInstance().getUin()))) {
            QLog.i("QZonePublishMoodUtil", 1, "has draft content");
            return true;
        }
        List<String> W = u5.b.W("_shuoshuo", LoginData.getInstance().getUin());
        if (!(W == null || W.isEmpty())) {
            QLog.i("QZonePublishMoodUtil", 1, "has draft selectedImagesList");
            return true;
        }
        if (u5.b.Y("_shuoshuo", LoginData.getInstance().getUin()) == null) {
            return false;
        }
        QLog.i("QZonePublishMoodUtil", 1, "has draft selectedImagesList");
        return true;
    }

    private final boolean M() {
        return i.b().d("allow_second_bubble_show", true);
    }

    private final void Z(String originPath, String finalPath, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap) {
        ShuoshuoVideoInfo remove;
        LocalMediaInfo remove2;
        if (selectedMediaInfoMap.containsKey(originPath) && (remove2 = selectedMediaInfoMap.remove(originPath)) != null) {
            remove2.path = finalPath;
            selectedMediaInfoMap.put(finalPath, remove2);
        }
        if (!selectedVideoInfoMap.containsKey(originPath) || (remove = selectedVideoInfoMap.remove(originPath)) == null) {
            return;
        }
        remove.mVideoPath = finalPath;
        selectedVideoInfoMap.put(finalPath, remove);
    }

    public final boolean T(Activity activity, Fragment hostFragment) {
        if (activity == null) {
            QLog.e("QZonePublishMoodUtil", 1, "activity is null");
            return false;
        }
        com.qzone.reborn.a aVar = com.qzone.reborn.a.f52169a;
        if (!aVar.d("exp_qzone_publishlink_shuoshuojumptopicker", "_B") && !aVar.d("exp_qzone_compactmode_pluspanel", "_B")) {
            QLog.i("QZonePublishMoodUtil", 1, "not in experiment");
            return false;
        }
        k kVar = k.f59549a;
        if (kVar.e(activity) || kVar.d(activity) || K()) {
            return false;
        }
        com.qzone.common.business.service.media.c cVar = new com.qzone.common.business.service.media.c(QZoneMediaBusiness.QZONE_PLUS_ICON_ENTRANCE);
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        if (hostFragment != null) {
            cVar.f45832e.putString("public_origin_fragment_class", hostFragment.getClass().getName());
        }
        if (activity.getIntent() != null) {
            Parcelable parcelableExtra = activity.getIntent().getParcelableExtra("key_bundle_common_init_bean");
            Serializable serializableExtra = activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
            if (parcelableExtra != null) {
                cVar.f45832e.putParcelable("key_bundle_common_init_bean", parcelableExtra);
            } else if (serializableExtra != null) {
                cVar.f45832e.putSerializable("key_bundle_common_init_bean", serializableExtra);
            }
            cVar.f45832e.putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, lc.b.b().getName());
            cVar.f45832e.putBoolean(PeakConstants.SHOW_QZONE_MEDIA_PICKER_PUBLISH_TEXT_MOOD_ENTRANCE, true);
        }
        com.qzone.common.business.service.b.f().l(activity, cVar);
        return true;
    }

    public final boolean V() {
        return X() || Y();
    }

    public final boolean X() {
        if (!com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp_qzone_pluslongpress", null, 2, null)) {
            QLog.i("QZonePublishMoodUtil", 1, "not in experiment");
            return false;
        }
        return i.b().d("long_click_first_bubble", true);
    }

    public final boolean Y() {
        if (!com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp_qzone_pluslongpress", null, 2, null)) {
            QLog.i("QZonePublishMoodUtil", 1, "not in experiment");
            return false;
        }
        if (!M()) {
            QLog.i("QZonePublishMoodUtil", 1, "not allow to show second bubble any more");
            return false;
        }
        if (X()) {
            return false;
        }
        return i.b().d("long_click_second_bubble", false);
    }

    public final void a(QZonePublishMoodInitBean initBean, Intent intent) {
        if (initBean != null && intent != null) {
            Bundle extras = intent.getExtras();
            if ((extras == null || extras.containsKey(PerfTracer.PARAM_CLICK_TIME)) ? false : true) {
                intent.putExtra(PerfTracer.PARAM_CLICK_TIME, initBean.getEnterTime());
            }
            if (initBean.getStartUpSceneId() != null) {
                Bundle extras2 = intent.getExtras();
                if ((extras2 == null || extras2.containsKey(PerfTracer.PARAM_STARTUP_SCENEID)) ? false : true) {
                    intent.putExtra(PerfTracer.PARAM_STARTUP_SCENEID, initBean.getStartUpSceneId());
                }
            }
            if (initBean.getIsUploadVideo() != null) {
                Bundle extras3 = intent.getExtras();
                if ((extras3 == null || extras3.containsKey("key_is_upload_video")) ? false : true) {
                    intent.putExtra("key_is_upload_video", initBean.getIsUploadVideo());
                }
            }
            if (initBean.getKeyType() != null) {
                Bundle extras4 = intent.getExtras();
                if ((extras4 == null || extras4.containsKey(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE)) ? false : true) {
                    intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, initBean.getKeyType());
                }
            }
            if (initBean.getNeedLoadPhotoFromIntent() != null) {
                Bundle extras5 = intent.getExtras();
                if ((extras5 == null || extras5.containsKey(QZoneHelper.Constants.KEY_NEED_LOAD_PHOTO_FROM_INTENT)) ? false : true) {
                    intent.putExtra(QZoneHelper.Constants.KEY_NEED_LOAD_PHOTO_FROM_INTENT, initBean.getNeedLoadPhotoFromIntent());
                }
            }
            if (initBean.getUploadEntrance() != null) {
                Bundle extras6 = intent.getExtras();
                if ((extras6 == null || extras6.containsKey(QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE)) ? false : true) {
                    intent.putExtra(QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE, initBean.getUploadEntrance());
                }
            }
            if (initBean.getIsShowNewCard() != null) {
                Bundle extras7 = intent.getExtras();
                if ((extras7 == null || extras7.containsKey(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW)) ? false : true) {
                    intent.putExtra(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW, initBean.getIsShowNewCard());
                }
            }
            String adId = initBean.getAdId();
            if (!(adId == null || adId.length() == 0)) {
                Bundle extras8 = intent.getExtras();
                if ((extras8 == null || extras8.containsKey("adId")) ? false : true) {
                    intent.putExtra("adId", initBean.getAdId());
                }
            }
            String tagTitle = initBean.getTagTitle();
            if (!(tagTitle == null || tagTitle.length() == 0)) {
                Bundle extras9 = intent.getExtras();
                if ((extras9 == null || extras9.containsKey("tagtitle")) ? false : true) {
                    intent.putExtra("tagtitle", initBean.getTagTitle());
                }
            }
            String tagUin = initBean.getTagUin();
            if (!(tagUin == null || tagUin.length() == 0)) {
                Bundle extras10 = intent.getExtras();
                if ((extras10 == null || extras10.containsKey("taguin")) ? false : true) {
                    intent.putExtra("taguin", initBean.getTagUin());
                }
            }
            String tagProtocol = initBean.getTagProtocol();
            if (!(tagProtocol == null || tagProtocol.length() == 0)) {
                Bundle extras11 = intent.getExtras();
                if ((extras11 == null || extras11.containsKey("tagprotocol")) ? false : true) {
                    intent.putExtra("tagprotocol", initBean.getTagProtocol());
                }
            }
            if (initBean.getTagBean() != null) {
                Bundle extras12 = intent.getExtras();
                if ((extras12 == null || extras12.containsKey("publish_event_tag_intent_key")) ? false : true) {
                    ParcelableWrapper.putDataToIntent(intent, "publish_event_tag_intent_key", um.a.a(initBean.getTagBean()));
                }
            }
            String refer = initBean.getRefer();
            if (!(refer == null || refer.length() == 0)) {
                Bundle extras13 = intent.getExtras();
                if ((extras13 == null || extras13.containsKey("refer")) ? false : true) {
                    intent.putExtra("refer", initBean.getRefer());
                }
            }
            if (initBean.getIsFromEventTag() != null) {
                Bundle extras14 = intent.getExtras();
                if ((extras14 == null || extras14.containsKey("is_from_event_tag_feed_intent_key")) ? false : true) {
                    intent.putExtra("is_from_event_tag_feed_intent_key", initBean.getIsFromEventTag());
                }
            }
            ArrayList<String> w3 = initBean.w();
            if (!(w3 == null || w3.isEmpty())) {
                Bundle extras15 = intent.getExtras();
                if ((extras15 == null || extras15.containsKey("PhotoConst.PHOTO_PATHS")) ? false : true) {
                    intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", initBean.w());
                }
            }
            if (initBean.getNeedJumpToEditPage() != null) {
                Bundle extras16 = intent.getExtras();
                if ((extras16 == null || extras16.containsKey("key_need_jump_to_edit_page")) ? false : true) {
                    intent.putExtra("key_need_jump_to_edit_page", initBean.getNeedJumpToEditPage());
                }
            }
            if (initBean.getOperateType() != null) {
                Bundle extras17 = intent.getExtras();
                if ((extras17 == null || extras17.containsKey("key_photo_oprate_type")) ? false : true) {
                    intent.putExtra("key_photo_oprate_type", initBean.getOperateType());
                }
            }
            if (initBean.getNeedSaveDraft() != null) {
                Bundle extras18 = intent.getExtras();
                if ((extras18 == null || extras18.containsKey("key_need_save_draft")) ? false : true) {
                    intent.putExtra("key_need_save_draft", initBean.getNeedSaveDraft());
                }
            }
            if (initBean.getIsJumpReeditPublishFlow() != null) {
                Bundle extras19 = intent.getExtras();
                if ((extras19 == null || extras19.containsKey(QZoneHelper.QZoneReeditConstants.KEY_IS_JUMP_REEDIT_PUBLISH_FLOW)) ? false : true) {
                    intent.putExtra(QZoneHelper.QZoneReeditConstants.KEY_IS_JUMP_REEDIT_PUBLISH_FLOW, initBean.getIsJumpReeditPublishFlow());
                }
            }
            String defaultText = initBean.getDefaultText();
            if (!(defaultText == null || defaultText.length() == 0)) {
                Bundle extras20 = intent.getExtras();
                if ((extras20 == null || extras20.containsKey(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT)) ? false : true) {
                    intent.putExtra(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, initBean.getDefaultText());
                }
            }
            if (initBean.getIsTrimVideoBlackList() != null) {
                Bundle extras21 = intent.getExtras();
                if ((extras21 == null || extras21.containsKey("key_trim_video_black_list")) ? false : true) {
                    intent.putExtra("key_trim_video_black_list", initBean.getIsTrimVideoBlackList());
                }
            }
            String qzoneUin = initBean.getQzoneUin();
            if (!(qzoneUin == null || qzoneUin.length() == 0)) {
                Bundle extras22 = intent.getExtras();
                if ((extras22 == null || extras22.containsKey("qzone_uin")) ? false : true) {
                    intent.putExtra("qzone_uin", initBean.getQzoneUin());
                }
            }
            String qzoneNickname = initBean.getQzoneNickname();
            if (!(qzoneNickname == null || qzoneNickname.length() == 0)) {
                Bundle extras23 = intent.getExtras();
                if ((extras23 == null || extras23.containsKey("nickname")) ? false : true) {
                    intent.putExtra("nickname", initBean.getQzoneNickname());
                }
            }
            String filePath = initBean.getFilePath();
            if (!(filePath == null || filePath.length() == 0)) {
                Bundle extras24 = intent.getExtras();
                if ((extras24 == null || extras24.containsKey(QZoneHelper.Constants.KEY_FILE_PATH)) ? false : true) {
                    intent.putExtra(QZoneHelper.Constants.KEY_FILE_PATH, initBean.getFilePath());
                }
            }
            String title = initBean.getTitle();
            if (!(title == null || title.length() == 0)) {
                Bundle extras25 = intent.getExtras();
                if ((extras25 == null || extras25.containsKey("key_title")) ? false : true) {
                    intent.putExtra("key_title", initBean.getTitle());
                }
            }
            String description = initBean.getDescription();
            if (!(description == null || description.length() == 0)) {
                Bundle extras26 = intent.getExtras();
                if ((extras26 == null || extras26.containsKey("key_desc")) ? false : true) {
                    intent.putExtra("key_desc", initBean.getDescription());
                }
            }
            if (initBean.getHideAddBtn() != null) {
                Bundle extras27 = intent.getExtras();
                if ((extras27 == null || extras27.containsKey("key_is_hide_add_btn")) ? false : true) {
                    intent.putExtra("key_is_hide_add_btn", initBean.getHideAddBtn());
                }
            }
            if (initBean.getStateType() != null) {
                Bundle extras28 = intent.getExtras();
                if ((extras28 == null || extras28.containsKey(QZoneHelper.Constants.KEY_STATE_TYPE_SRC)) ? false : true) {
                    intent.putExtra(QZoneHelper.Constants.KEY_STATE_TYPE_SRC, initBean.getStateType());
                }
            }
            String albumId = initBean.getAlbumId();
            if (!(albumId == null || albumId.length() == 0)) {
                Bundle extras29 = intent.getExtras();
                if ((extras29 == null || extras29.containsKey("UploadPhoto.key_album_id")) ? false : true) {
                    intent.putExtra("UploadPhoto.key_album_id", initBean.getAlbumId());
                }
            }
            String str = initBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String();
            if (!(str == null || str.length() == 0)) {
                Bundle extras30 = intent.getExtras();
                if ((extras30 == null || extras30.containsKey("UploadPhoto.key_album_name")) ? false : true) {
                    intent.putExtra("UploadPhoto.key_album_name", initBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
                }
            }
            String albumCover = initBean.getAlbumCover();
            if (!(albumCover == null || albumCover.length() == 0)) {
                Bundle extras31 = intent.getExtras();
                if ((extras31 == null || extras31.containsKey("UploadPhoto.key_album_cover")) ? false : true) {
                    intent.putExtra("UploadPhoto.key_album_cover", initBean.getAlbumCover());
                }
            }
            String uploadImageClientKey = initBean.getUploadImageClientKey();
            if (!(uploadImageClientKey == null || uploadImageClientKey.length() == 0)) {
                Bundle extras32 = intent.getExtras();
                if ((extras32 == null || extras32.containsKey(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY)) ? false : true) {
                    intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY, initBean.getUploadImageClientKey());
                }
            }
            String uploadPhotoComeFrom = initBean.getUploadPhotoComeFrom();
            if (!(uploadPhotoComeFrom == null || uploadPhotoComeFrom.length() == 0)) {
                Bundle extras33 = intent.getExtras();
                if ((extras33 == null || extras33.containsKey("report_from")) ? false : true) {
                    intent.putExtra("report_from", initBean.getUploadPhotoComeFrom());
                }
            }
            String groupId = initBean.getGroupId();
            if (!(groupId == null || groupId.length() == 0)) {
                Bundle extras34 = intent.getExtras();
                if ((extras34 == null || extras34.containsKey(QZoneHelper.Constants.KEY_QUN_ID)) ? false : true) {
                    intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, initBean.getGroupId());
                }
            }
            String groupName = initBean.getGroupName();
            if (!(groupName == null || groupName.length() == 0)) {
                Bundle extras35 = intent.getExtras();
                if ((extras35 == null || extras35.containsKey(QZoneHelper.Constants.KEY_QUN_NAME)) ? false : true) {
                    intent.putExtra(QZoneHelper.Constants.KEY_QUN_NAME, initBean.getGroupName());
                }
            }
            ArrayList<String> C = initBean.C();
            if (!(C == null || C.isEmpty())) {
                Bundle extras36 = intent.getExtras();
                if ((extras36 == null || extras36.containsKey("QZoneUploadPhotoActivity.key_selected_image_path")) ? false : true) {
                    intent.putStringArrayListExtra("QZoneUploadPhotoActivity.key_selected_image_path", initBean.C());
                }
            }
            String repairSrTaskId = initBean.getRepairSrTaskId();
            if (!(repairSrTaskId == null || repairSrTaskId.length() == 0)) {
                Bundle extras37 = intent.getExtras();
                if ((extras37 == null || extras37.containsKey(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_TASK_ID)) ? false : true) {
                    intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_TASK_ID, initBean.getRepairSrTaskId());
                }
            }
            String repairSrUrl = initBean.getRepairSrUrl();
            if (repairSrUrl == null || repairSrUrl.length() == 0) {
                return;
            }
            Bundle extras38 = intent.getExtras();
            if ((extras38 == null || extras38.containsKey(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_URL)) ? false : true) {
                intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_URL, initBean.getRepairSrUrl());
                return;
            }
            return;
        }
        QLog.i("QZonePublishMoodUtil", 1, "init bean or intent is null");
    }

    public final void a0(boolean state) {
        i.b().l("allow_second_bubble_show", state);
    }

    public final void b(List<String> list, HashMap<String, LocalMediaInfo> selectedMediaInfoMap, HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap) {
        Intrinsics.checkNotNullParameter(selectedMediaInfoMap, "selectedMediaInfoMap");
        Intrinsics.checkNotNullParameter(selectedVideoInfoMap, "selectedVideoInfoMap");
        if (com.qzone.reborn.configx.g.f53821a.b().y()) {
            List<String> list2 = list;
            boolean z16 = false;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(list2);
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                String str = (String) listIterator.next();
                if (!RFWFileUtils.fileExists(str)) {
                    String finalPath = FakeShuoShuoDataCacheHelper.c(str);
                    if (!RFWFileUtils.fileExists(finalPath)) {
                        finalPath = str;
                    }
                    if (!TextUtils.equals(str, finalPath)) {
                        Intrinsics.checkNotNullExpressionValue(finalPath, "finalPath");
                        listIterator.set(finalPath);
                        Z(str, finalPath, selectedMediaInfoMap, selectedVideoInfoMap);
                        z16 = true;
                    }
                }
            }
            if (z16) {
                list.clear();
                list.addAll(arrayList);
            }
        }
    }

    public final void b0(boolean state) {
        i.b().l("long_click_first_bubble", state);
    }

    public final void c0(boolean state) {
        i.b().l("long_click_second_bubble", state);
    }

    public final void d0(QZonePublishMoodInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        QZoneBubbleInfo k3 = com.qzone.business.tianshu.c.j().k();
        if (k3 != null && !TextUtils.isEmpty(k3.getPublishTag()) && !TextUtils.isEmpty(k3.getPublishTagUin())) {
            bean.J0(e(PublishEventTag.assembleFakeTag(k3.getPublishTag(), k3.getPublishTagUin())));
        }
        if (QZonePlusIconBubbleController.d() != null) {
            ak.g(QZonePlusIconBubbleController.d(), 139);
            bean.j0(String.valueOf(QZonePlusIconBubbleController.d().iAdId.get()));
        }
    }

    public final String A(QZonePublishMoodInitBean initBean, Intent intent) {
        String repairSrTaskId;
        String repairSrTaskId2 = initBean != null ? initBean.getRepairSrTaskId() : null;
        if (repairSrTaskId2 == null || repairSrTaskId2.length() == 0) {
            if (intent == null || (repairSrTaskId = intent.getStringExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_TASK_ID)) == null) {
                return "";
            }
        } else if (initBean == null || (repairSrTaskId = initBean.getRepairSrTaskId()) == null) {
            return "";
        }
        return repairSrTaskId;
    }

    public final String B(QZonePublishMoodInitBean initBean, Intent intent) {
        String repairSrUrl;
        String repairSrUrl2 = initBean != null ? initBean.getRepairSrUrl() : null;
        if (repairSrUrl2 == null || repairSrUrl2.length() == 0) {
            if (intent == null || (repairSrUrl = intent.getStringExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_REPAIR_SR_URL)) == null) {
                return "";
            }
        } else if (initBean == null || (repairSrUrl = initBean.getRepairSrUrl()) == null) {
            return "";
        }
        return repairSrUrl;
    }

    public final String D(QZonePublishMoodInitBean initBean, Intent intent) {
        String tagProtocol;
        String tagProtocol2 = initBean != null ? initBean.getTagProtocol() : null;
        if (tagProtocol2 == null || tagProtocol2.length() == 0) {
            if (intent == null || (tagProtocol = intent.getStringExtra("tagprotocol")) == null) {
                return "";
            }
        } else if (initBean == null || (tagProtocol = initBean.getTagProtocol()) == null) {
            return "";
        }
        return tagProtocol;
    }

    public final String E(QZonePublishMoodInitBean initBean, Intent intent) {
        String tagTitle;
        String tagTitle2 = initBean != null ? initBean.getTagTitle() : null;
        if (tagTitle2 == null || tagTitle2.length() == 0) {
            if (intent == null || (tagTitle = intent.getStringExtra("tagtitle")) == null) {
                return "";
            }
        } else if (initBean == null || (tagTitle = initBean.getTagTitle()) == null) {
            return "";
        }
        return tagTitle;
    }

    public final String F(QZonePublishMoodInitBean initBean, Intent intent) {
        String tagUin;
        String tagUin2 = initBean != null ? initBean.getTagUin() : null;
        if (tagUin2 == null || tagUin2.length() == 0) {
            if (intent == null || (tagUin = intent.getStringExtra("taguin")) == null) {
                return "";
            }
        } else if (initBean == null || (tagUin = initBean.getTagUin()) == null) {
            return "";
        }
        return tagUin;
    }

    public final String G(QZonePublishMoodInitBean initBean, Intent intent) {
        String title;
        String title2 = initBean != null ? initBean.getTitle() : null;
        if (title2 == null || title2.length() == 0) {
            if (intent == null || (title = intent.getStringExtra("key_title")) == null) {
                return "";
            }
        } else if (initBean == null || (title = initBean.getTitle()) == null) {
            return "";
        }
        return title;
    }

    public final String H(QZonePublishMoodInitBean initBean, Intent intent) {
        String uploadImageClientKey;
        String uploadImageClientKey2 = initBean != null ? initBean.getUploadImageClientKey() : null;
        if (uploadImageClientKey2 == null || uploadImageClientKey2.length() == 0) {
            if (intent == null || (uploadImageClientKey = intent.getStringExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY)) == null) {
                return "";
            }
        } else if (initBean == null || (uploadImageClientKey = initBean.getUploadImageClientKey()) == null) {
            return "";
        }
        return uploadImageClientKey;
    }

    public final String I(QZonePublishMoodInitBean initBean, Intent intent) {
        String uploadPhotoComeFrom;
        String uploadPhotoComeFrom2 = initBean != null ? initBean.getUploadPhotoComeFrom() : null;
        if (uploadPhotoComeFrom2 == null || uploadPhotoComeFrom2.length() == 0) {
            if (intent == null || (uploadPhotoComeFrom = intent.getStringExtra("report_from")) == null) {
                return "";
            }
        } else if (initBean == null || (uploadPhotoComeFrom = initBean.getUploadPhotoComeFrom()) == null) {
            return "";
        }
        return uploadPhotoComeFrom;
    }

    public final int J(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getStateType() : null) == null) {
            if (intent != null) {
                return intent.getIntExtra(QZoneHelper.Constants.KEY_STATE_TYPE_SRC, -1);
            }
            return -1;
        }
        Integer stateType = initBean.getStateType();
        if (stateType != null) {
            return stateType.intValue();
        }
        return -1;
    }

    public final boolean L(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getHideAddBtn() : null) == null) {
            if (intent != null) {
                return intent.getBooleanExtra("key_is_hide_add_btn", false);
            }
            return false;
        }
        Boolean hideAddBtn = initBean.getHideAddBtn();
        if (hideAddBtn != null) {
            return hideAddBtn.booleanValue();
        }
        return false;
    }

    public final boolean N(QZonePublishMoodInitBean initBean) {
        Boolean enterByLongClick;
        if ((initBean != null ? initBean.getEnterByLongClick() : null) == null || (enterByLongClick = initBean.getEnterByLongClick()) == null) {
            return false;
        }
        return enterByLongClick.booleanValue();
    }

    public final boolean O(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getIsJumpReeditPublishFlow() : null) == null) {
            if (intent != null) {
                return intent.getBooleanExtra(QZoneHelper.QZoneReeditConstants.KEY_IS_JUMP_REEDIT_PUBLISH_FLOW, false);
            }
            return false;
        }
        Boolean isJumpReeditPublishFlow = initBean.getIsJumpReeditPublishFlow();
        if (isJumpReeditPublishFlow != null) {
            return isJumpReeditPublishFlow.booleanValue();
        }
        return false;
    }

    public final boolean P(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getNeedLoadPhotoFromIntent() : null) == null) {
            if (intent != null) {
                return intent.getBooleanExtra(QZoneHelper.Constants.KEY_NEED_LOAD_PHOTO_FROM_INTENT, true);
            }
            return true;
        }
        Boolean needLoadPhotoFromIntent = initBean.getNeedLoadPhotoFromIntent();
        if (needLoadPhotoFromIntent != null) {
            return needLoadPhotoFromIntent.booleanValue();
        }
        return true;
    }

    public final boolean Q(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getIsShowNewCard() : null) == null) {
            if (intent != null) {
                return intent.getBooleanExtra(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW, false);
            }
            return false;
        }
        Boolean isShowNewCard = initBean.getIsShowNewCard();
        if (isShowNewCard != null) {
            return isShowNewCard.booleanValue();
        }
        return false;
    }

    public final boolean R(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getIsTrimVideoBlackList() : null) == null) {
            if (intent != null) {
                return intent.getBooleanExtra("key_trim_video_black_list", false);
            }
            return false;
        }
        Boolean isTrimVideoBlackList = initBean.getIsTrimVideoBlackList();
        if (isTrimVideoBlackList != null) {
            return isTrimVideoBlackList.booleanValue();
        }
        return false;
    }

    public final boolean S(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getIsUploadVideo() : null) == null) {
            if (intent != null) {
                return intent.getBooleanExtra("key_is_upload_video", false);
            }
            return false;
        }
        Boolean isUploadVideo = initBean.getIsUploadVideo();
        if (isUploadVideo != null) {
            return isUploadVideo.booleanValue();
        }
        return false;
    }

    public final boolean W(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getNeedJumpToEditPage() : null) == null) {
            if (intent != null) {
                return intent.getBooleanExtra("key_need_jump_to_edit_page", false);
            }
            return false;
        }
        Boolean needJumpToEditPage = initBean.getNeedJumpToEditPage();
        if (needJumpToEditPage != null) {
            return needJumpToEditPage.booleanValue();
        }
        return false;
    }

    public final boolean c(QZonePublishMoodInitBean initBean, Intent intent) {
        Bundle extras;
        if ((initBean != null ? initBean.getAdId() : null) != null) {
            return !TextUtils.isEmpty(initBean.getAdId());
        }
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.containsKey("adId");
    }

    public final boolean d(QZonePublishMoodInitBean initBean, Intent intent) {
        Bundle extras;
        if ((initBean != null ? initBean.getTagTitle() : null) != null) {
            return !TextUtils.isEmpty(initBean.getTagTitle());
        }
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.containsKey("tagtitle");
    }

    public final QZonePublishTagBean e(PublishEventTag eventTag) {
        if (eventTag != null) {
            return um.a.b(eventTag);
        }
        return null;
    }

    public final String f(QZonePublishMoodInitBean initBean, Intent intent) {
        String adId;
        String adId2 = initBean != null ? initBean.getAdId() : null;
        if (adId2 == null || adId2.length() == 0) {
            if (intent == null || (adId = intent.getStringExtra("adId")) == null) {
                return "";
            }
        } else if (initBean == null || (adId = initBean.getAdId()) == null) {
            return "";
        }
        return adId;
    }

    public final String g(QZonePublishMoodInitBean initBean, Intent intent) {
        String albumCover;
        String albumCover2 = initBean != null ? initBean.getAlbumCover() : null;
        if (albumCover2 == null || albumCover2.length() == 0) {
            if (intent == null || (albumCover = intent.getStringExtra("UploadPhoto.key_album_cover")) == null) {
                return "";
            }
        } else if (initBean == null || (albumCover = initBean.getAlbumCover()) == null) {
            return "";
        }
        return albumCover;
    }

    public final String h(QZonePublishMoodInitBean initBean, Intent intent) {
        String albumId;
        String albumId2 = initBean != null ? initBean.getAlbumId() : null;
        if (albumId2 == null || albumId2.length() == 0) {
            if (intent == null || (albumId = intent.getStringExtra("UploadPhoto.key_album_id")) == null) {
                return "";
            }
        } else if (initBean == null || (albumId = initBean.getAlbumId()) == null) {
            return "";
        }
        return albumId;
    }

    public final String i(QZonePublishMoodInitBean initBean, Intent intent) {
        String str;
        String str2 = initBean != null ? initBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String() : null;
        if (str2 == null || str2.length() == 0) {
            if (intent == null || (str = intent.getStringExtra("UploadPhoto.key_album_name")) == null) {
                return "";
            }
        } else if (initBean == null || (str = initBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String()) == null) {
            return "";
        }
        return str;
    }

    public final String k(QZonePublishMoodInitBean initBean, Intent intent) {
        String description;
        String description2 = initBean != null ? initBean.getDescription() : null;
        if (description2 == null || description2.length() == 0) {
            if (intent == null || (description = intent.getStringExtra("key_desc")) == null) {
                return "";
            }
        } else if (initBean == null || (description = initBean.getDescription()) == null) {
            return "";
        }
        return description;
    }

    public final String l(QZonePublishMoodInitBean initBean, Intent intent) {
        String filePath;
        String filePath2 = initBean != null ? initBean.getFilePath() : null;
        if (filePath2 == null || filePath2.length() == 0) {
            if (intent == null || (filePath = intent.getStringExtra(QZoneHelper.Constants.KEY_FILE_PATH)) == null) {
                return "";
            }
        } else if (initBean == null || (filePath = initBean.getFilePath()) == null) {
            return "";
        }
        return filePath;
    }

    public final String m(QZonePublishMoodInitBean initBean, Intent intent) {
        String groupId;
        String groupId2 = initBean != null ? initBean.getGroupId() : null;
        if (groupId2 == null || groupId2.length() == 0) {
            if (intent == null || (groupId = intent.getStringExtra(QZoneHelper.Constants.KEY_QUN_ID)) == null) {
                return "";
            }
        } else if (initBean == null || (groupId = initBean.getGroupId()) == null) {
            return "";
        }
        return groupId;
    }

    public final String n(QZonePublishMoodInitBean initBean, Intent intent) {
        String groupName;
        String groupName2 = initBean != null ? initBean.getGroupName() : null;
        if (groupName2 == null || groupName2.length() == 0) {
            if (intent == null || (groupName = intent.getStringExtra(QZoneHelper.Constants.KEY_QUN_NAME)) == null) {
                return "";
            }
        } else if (initBean == null || (groupName = initBean.getGroupName()) == null) {
            return "";
        }
        return groupName;
    }

    public final String o(QZonePublishMoodInitBean initBean, Intent intent) {
        String action;
        String action2 = initBean != null ? initBean.getAction() : null;
        if (action2 == null || action2.length() == 0) {
            if (intent == null || (action = intent.getAction()) == null) {
                return "";
            }
        } else if (initBean == null || (action = initBean.getAction()) == null) {
            return "";
        }
        return action;
    }

    public final int p(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getUploadEntrance() : null) == null) {
            if (intent != null) {
                return intent.getIntExtra(QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE, 23);
            }
            return 23;
        }
        Integer uploadEntrance = initBean.getUploadEntrance();
        if (uploadEntrance != null) {
            return uploadEntrance.intValue();
        }
        return 23;
    }

    public final int r(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getUploadEntrance() : null) == null) {
            if (intent != null) {
                return intent.getIntExtra("UploadPhoto.key_upload_entrance", 14);
            }
            return 14;
        }
        Integer uploadEntrance = initBean.getUploadEntrance();
        if (uploadEntrance != null) {
            return uploadEntrance.intValue();
        }
        return 14;
    }

    public final String s(QZonePublishMoodInitBean initBean, Intent intent) {
        String defaultText;
        String defaultText2 = initBean != null ? initBean.getDefaultText() : null;
        if (defaultText2 == null || defaultText2.length() == 0) {
            if (intent == null || (defaultText = intent.getStringExtra(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT)) == null) {
                return "";
            }
        } else if (initBean == null || (defaultText = initBean.getDefaultText()) == null) {
            return "";
        }
        return defaultText;
    }

    public final PublishEventTag t(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getTagBean() : null) == null) {
            return (PublishEventTag) ParcelableWrapper.getDataFromeIntent(intent, "publish_event_tag_intent_key");
        }
        return um.a.a(initBean.getTagBean());
    }

    public final long u(QZonePublishMoodInitBean initBean, Intent intent) {
        if (initBean != null) {
            return initBean.getEnterTime();
        }
        if (intent != null) {
            return intent.getLongExtra(PerfTracer.PARAM_CLICK_TIME, 0L);
        }
        return 0L;
    }

    public final int v(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.getKeyType() : null) == null) {
            if (intent != null) {
                return intent.getIntExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 0);
            }
            return 0;
        }
        Integer keyType = initBean.getKeyType();
        if (keyType != null) {
            return keyType.intValue();
        }
        return 0;
    }

    public final int w(QZonePublishMoodInitBean initBean, Bundle bundle) {
        if ((initBean != null ? initBean.getKeyType() : null) == null) {
            if (bundle != null) {
                return bundle.getInt(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 0);
            }
            return 0;
        }
        Integer keyType = initBean.getKeyType();
        if (keyType != null) {
            return keyType.intValue();
        }
        return 0;
    }

    public final String x(QZonePublishMoodInitBean initBean, Intent intent) {
        String refer;
        String refer2 = initBean != null ? initBean.getRefer() : null;
        if (refer2 == null || refer2.length() == 0) {
            if (intent == null || (refer = intent.getStringExtra("refer")) == null) {
                return "";
            }
        } else if (initBean == null || (refer = initBean.getRefer()) == null) {
            return "";
        }
        return refer;
    }

    public final String y(QZonePublishMoodInitBean initBean, Intent intent) {
        String qzoneNickname;
        String qzoneNickname2 = initBean != null ? initBean.getQzoneNickname() : null;
        if (qzoneNickname2 == null || qzoneNickname2.length() == 0) {
            if (intent == null || (qzoneNickname = intent.getStringExtra("nickname")) == null) {
                return "";
            }
        } else if (initBean == null || (qzoneNickname = initBean.getQzoneNickname()) == null) {
            return "";
        }
        return qzoneNickname;
    }

    public final String z(QZonePublishMoodInitBean initBean, Intent intent) {
        String qzoneUin;
        String qzoneUin2 = initBean != null ? initBean.getQzoneUin() : null;
        if (qzoneUin2 == null || qzoneUin2.length() == 0) {
            if (intent == null || (qzoneUin = intent.getStringExtra("qzone_uin")) == null) {
                return "";
            }
        } else if (initBean == null || (qzoneUin = initBean.getQzoneUin()) == null) {
            return "";
        }
        return qzoneUin;
    }

    public final ArrayList<String> C(QZonePublishMoodInitBean initBean, Intent intent) {
        ArrayList<String> C = initBean != null ? initBean.C() : null;
        if (C == null || C.isEmpty()) {
            if (intent != null) {
                return intent.getStringArrayListExtra("QZoneUploadPhotoActivity.key_selected_image_path");
            }
            return null;
        }
        if (initBean != null) {
            return initBean.C();
        }
        return null;
    }

    public final String j(int uploadEntrance) {
        switch (uploadEntrance) {
            case 11:
                return "1";
            case 12:
                return "2";
            case 13:
                return "4";
            case 14:
                return "6";
            case 15:
                return "3";
            case 16:
            default:
                return "";
            case 17:
                return "5";
        }
    }

    public final ArrayList<String> q(QZonePublishMoodInitBean initBean, Intent intent) {
        if ((initBean != null ? initBean.w() : null) != null) {
            return initBean.w();
        }
        if (intent != null) {
            return intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        }
        return null;
    }

    public final boolean U(Activity activity, Fragment hostFragment) {
        if (activity == null) {
            QLog.e("QZonePublishMoodUtil", 1, "activity is null");
            return false;
        }
        k kVar = k.f59549a;
        if (kVar.e(activity) || kVar.d(activity) || K()) {
            return false;
        }
        com.qzone.common.business.service.media.c cVar = new com.qzone.common.business.service.media.c(QZoneMediaBusiness.QZONE_PLUS_ICON_ENTRANCE);
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        if (hostFragment != null) {
            cVar.f45832e.putString("public_origin_fragment_class", hostFragment.getClass().getName());
        }
        if (activity.getIntent() != null) {
            Parcelable parcelableExtra = activity.getIntent().getParcelableExtra("key_bundle_common_init_bean");
            Serializable serializableExtra = activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
            if (parcelableExtra != null) {
                cVar.f45832e.putParcelable("key_bundle_common_init_bean", parcelableExtra);
            } else if (serializableExtra != null) {
                cVar.f45832e.putSerializable("key_bundle_common_init_bean", serializableExtra);
            }
            cVar.f45832e.putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, lc.b.b().getName());
            cVar.f45832e.putBoolean(PeakConstants.SHOW_QZONE_MEDIA_PICKER_PUBLISH_TEXT_MOOD_ENTRANCE, false);
        }
        com.qzone.common.business.service.b.f().l(activity, cVar);
        return true;
    }
}
