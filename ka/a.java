package ka;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxExpicPicInitBean;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxMediaListInitBean;
import com.qzone.reborn.albumx.qzone.fragment.QZoneAlbumxLocalPhotoRecommendMediaLayerFragment;
import com.qzone.reborn.albumx.qzone.fragment.QZoneAlbumxMediaListFragment;
import com.qzone.reborn.albumx.qzone.vas.QZoneAlbumExpirePicFragment;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QzoneWinkOutputRouter;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.util.PerfTracer;
import ho.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import yo.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJD\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006JW\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001cj\b\u0012\u0004\u0012\u00020\u0002`\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001f\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J6\u0010&\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u000e\u0010'\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010)\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020(\u00a8\u0006,"}, d2 = {"Lka/a;", "Lho/a;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "a", "Landroid/content/Context;", "context", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxMediaListInitBean;", "initBean", "", "g", "d", "Landroid/os/Bundle;", "bundle", "e", "", "templateId", "firstMediaPath", "", "mediaInfoList", "classifyId", "", "maxPicNum", "k", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "from", "requestCode", h.F, "(Landroid/app/Activity;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Landroid/os/Bundle;I)V", "Landroid/widget/ImageView;", "clickView", "clickPos", CommonConstant.KEY_DISPLAY_NAME, "f", "c", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxExpicPicInitBean;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements ho.a {
    private final RFWLayerItemMediaInfo a(LocalMediaInfo localMediaInfo) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo.setLocalPath(localMediaInfo.path);
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
        rFWPicInfo2.setLocalPath(localMediaInfo.path);
        rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
        rFWLayerPicInfo.setBigPicInfo(rFWPicInfo2);
        rFWLayerPicInfo.setPicId(localMediaInfo.path);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        return rFWLayerItemMediaInfo;
    }

    public final void b(Context context, QZoneAlbumxExpicPicInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page_in_qzone_process").withSerializable("key_bundle_common_init_bean", initBean).withString("public_fragment_class", QZoneAlbumExpirePicFragment.class.getName()).request();
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d.d("https://rule.tencent.com/rule/202309190001", context, null);
    }

    public final void d(Context context, QZoneAlbumxMediaListInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intent b16 = ak.b(context);
        b16.putExtra("key_bundle_common_init_bean", initBean);
        com.qzone.feed.utils.b.d(context, b16);
    }

    public final void e(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent m3 = ak.m(context);
        m3.putExtras(bundle);
        com.qzone.feed.utils.b.d(context, m3);
    }

    public final void g(Context context, QZoneAlbumxMediaListInitBean initBean) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneAlbumxMediaListFragment.class.getName()).withSerializable("key_bundle_common_init_bean", initBean).request();
    }

    public final void h(Activity activity, ArrayList<LocalMediaInfo> mediaInfoList, String classifyId, Integer from, Bundle bundle, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intent intent = new Intent(activity, (Class<?>) QZoneUploadPhotoRealActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("PhotoConst.WINK_MEDIA_PICKER_PATHS", com.tencent.qzonehub.api.impl.a.b(mediaInfoList));
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, mediaInfoList);
        intent.putExtra(QQWinkConstants.PUBLISH_DISABLE_SHOW_SYNC_TO_QCIRCLE, true);
        intent.putExtra("PhotoConst.IS_FROM_WINK_MEDIA_PICKER", true);
        intent.putExtra("QZoneUploadRecommend.CLASSIFY_ID", classifyId);
        intent.putExtra(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, from);
        if (lc.b.d()) {
            String uinString = LoginData.getInstance().getUinString();
            Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
            QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = new QZAlbumxUploadAlbumInitBean(uinString, 0, true, null, 0);
            qZAlbumxUploadAlbumInitBean.setRequestCode(requestCode);
            i.x().l(activity, qZAlbumxUploadAlbumInitBean, intent);
            return;
        }
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        activity.startActivityForResult(intent, requestCode);
    }

    public final void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IQQWinkLauncher.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQWinkLauncher::class.java)");
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToTemplateLibMainPage(context, IQQWinkLauncher.DefaultImpls.fillInnerJumpBundle$default((IQQWinkLauncher) api, context, null, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(Context context, String templateId, String firstMediaPath, List<? extends LocalMediaInfo> mediaInfoList, String classifyId, int maxPicNum) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        if (firstMediaPath == null || firstMediaPath.length() == 0) {
            QLog.e("QZoneAlbumxNativeLauncher", 1, "[launchWinkTemplatePreviewPage] first media path is null or empty");
            return;
        }
        List<? extends LocalMediaInfo> arrayList = new ArrayList<>();
        for (Object obj : mediaInfoList) {
            String str = ((LocalMediaInfo) obj).path;
            if (!(str == null || str.length() == 0)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.e("QZoneAlbumxNativeLauncher", 1, "[launchWinkTemplatePreviewPage] filterMediaInfoList is empty");
            return;
        }
        if (arrayList.size() > maxPicNum) {
            arrayList = arrayList.subList(0, maxPicNum);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQWinkConstants.PUBLISH_DISABLE_SHOW_SYNC_TO_QCIRCLE, true);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        bundle.putBoolean("needRemoveAllLocalPathWhenExport", true);
        bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_RECOMMEND);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QZoneHelper.UPLOAD_PHOTO);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        bundle.putString("app_key", "0AND0MWZXR4U3RVU");
        bundle.putLong("wink_output_point", 35L);
        bundle.putString("wink_output_route", QzoneWinkOutputRouter.ROUTE_PATH);
        bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_RECOMMEND, firstMediaPath);
        bundle.putBoolean(QQWinkConstants.PUBLISH_DISABLE_SHOW_SYNC_TO_QCIRCLE, true);
        bundle.putInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, 1);
        if (templateId != null) {
            bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_ID, templateId);
        }
        if (classifyId != null) {
            bundle.putString(QQWinkConstants.KEY_QZONE_CLASSIFY_ID, classifyId);
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null ? extras.getBoolean(QZoneContant.LOCAL_PHOTO_RECOMMEND_VIDEO_FEED_STANDALONE) : false) {
                bundle.putBoolean(QZoneContant.LOCAL_PHOTO_RECOMMEND_VIDEO_FEED_STANDALONE, true);
                Bundle extras2 = activity.getIntent().getExtras();
                bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", extras2 != null ? extras2.getString("PhotoConst.INIT_ACTIVITY_CLASS_NAME") : null);
                Bundle extras3 = activity.getIntent().getExtras();
                bundle.putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, extras3 != null ? extras3.getString(PeakConstants.DEST_ACTIVITY_CLASS_NAME) : null);
                bundle.putInt(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, 3);
            }
        }
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToRecommendPreview(context, bundle, arrayList);
    }

    public final void f(Context context, ImageView clickView, int clickPos, String displayName, List<? extends LocalMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clickView, "clickView");
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        if (mediaInfoList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = mediaInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(a((LocalMediaInfo) it.next()));
        }
        Bundle bundle = new Bundle();
        if (displayName != null) {
            bundle.putString("key_display_name", displayName);
        }
        RFWLayerLaunchUtil.jumpToGallery$default(context, clickView, arrayList, clickPos, QZoneFeedXGalleryActivity.class, QZoneAlbumxLocalPhotoRecommendMediaLayerFragment.class, bundle, 0, 128, null);
    }

    public static /* synthetic */ void l(a aVar, Context context, String str, String str2, List list, String str3, int i3, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            i3 = 35;
        }
        aVar.k(context, str, str2, list, str3, i3);
    }

    public static /* synthetic */ void i(a aVar, Activity activity, ArrayList arrayList, String str, Integer num, Bundle bundle, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ((i16 & 32) != 0) {
            i3 = 0;
        }
        aVar.h(activity, arrayList, str, num, bundle2, i3);
    }
}
