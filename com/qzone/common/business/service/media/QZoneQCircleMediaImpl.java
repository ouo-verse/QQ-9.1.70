package com.qzone.common.business.service.media;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qzone.common.account.LoginData;
import com.qzone.preview.LocalPictureViewer;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.publish.business.process.base.a;
import com.qzone.reborn.configx.g;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.widget.ExtendGridView;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.util.LocalMediaInfoGenerator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.impl.QzoneWinkOutputRouter;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQCircleMediaImpl implements com.qzone.common.business.service.media.a {

    /* renamed from: a, reason: collision with root package name */
    private final wk.a f45810a = new wk.a();

    /* renamed from: b, reason: collision with root package name */
    private a.InterfaceC0438a<ShuoshuoVideoInfo> f45811b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements com.tencent.mobileqq.wink.api.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f45823a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f45824b;

        b(Activity activity, QQProgressDialog qQProgressDialog) {
            this.f45823a = activity;
            this.f45824b = qQProgressDialog;
        }

        @Override // com.tencent.mobileqq.wink.api.b
        public void a(boolean z16) {
            ms.a.f("upload2_QZoneQCircleMediaImpl", "onCompleted  need finish ");
            this.f45823a.finish();
            this.f45824b.dismiss();
        }
    }

    public static boolean A() {
        VideoEnvironment64BitUtils.checkIs64bit();
        return true;
    }

    private void m(Activity activity, ArrayList<PictureItem> arrayList, Intent intent, int i3, int i16) {
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.uin = LoginData.getInstance().getUin();
        cellPictureInfo.balbum = false;
        cellPictureInfo.pics = arrayList;
        intent.putExtra("RECEIVE_DATA_CLASS_NAME", activity.getClass().getName());
        PictureViewerFactory.N(activity, cellPictureInfo, i16, 6002, i3, 0, 0, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Activity activity, LocalMediaInfo localMediaInfo, QZoneMediaBusiness qZoneMediaBusiness) {
        QZLog.i("upload2_QZoneQCircleMediaImpl", "compressVideoAndGoEdit");
        final QQProgressDialog[] qQProgressDialogArr = {null};
        QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.common.business.service.media.QZoneQCircleMediaImpl.2
            @Override // java.lang.Runnable
            public void run() {
                QQProgressDialog[] qQProgressDialogArr2 = qQProgressDialogArr;
                Activity activity2 = activity;
                qQProgressDialogArr2[0] = new QQProgressDialog(activity2, activity2.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                qQProgressDialogArr[0].setMessage(R.string.f2201468b);
                qQProgressDialogArr[0].show();
            }
        });
        ShuoshuoVideoInfo b16 = ag.b(localMediaInfo);
        b16.mIsUploadOrigin = true;
        a aVar = new a(qQProgressDialogArr, activity, localMediaInfo, qZoneMediaBusiness);
        this.f45811b = aVar;
        new com.qzone.publish.business.process.c(b16, aVar, false).o();
    }

    public static void p(LocalMediaInfo localMediaInfo) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            } catch (Exception e16) {
                ms.a.d("upload2_QZoneQCircleMediaImpl", "fixVideoWidthAndHeight", e16);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static Activity r(Activity activity) {
        return activity instanceof BasePluginActivity ? ((BasePluginActivity) activity).getOutActivity() : activity;
    }

    private Bundle s(Activity activity) {
        Bundle bundle = new Bundle();
        q(activity, bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Activity activity, String str, String str2, String str3, QZoneMediaBusiness qZoneMediaBusiness) {
        u(activity, str, str2, str3, qZoneMediaBusiness, Boolean.FALSE);
    }

    private void u(Activity activity, String str, String str2, String str3, QZoneMediaBusiness qZoneMediaBusiness, Boolean bool) {
        QZLog.i("upload2_QZoneQCircleMediaImpl", "onEditMedia, missionId=" + str2 + ", originPathUrl=" + str3);
        Bundle extras = activity.getIntent().getExtras();
        String string = extras.getString("RECEIVE_DATA_CLASS_NAME");
        Bundle s16 = s(activity);
        s16.putString("xsj_ref_pgid", qZoneMediaBusiness.getBusinessName());
        s16.putString("editFileOriginPath", str3);
        s16.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", string);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        s16.putStringArrayList(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST, arrayList);
        s16.putString(QQWinkConstants.MISSION_ID, str2);
        if (extras.getBoolean(QQWinkConstants.EDITOR_TEMPORARY_ENTRANCE_RECOVERFOR_VOLUME, false)) {
            s16.putBoolean(QQWinkConstants.EDITOR_TEMPORARY_ENTRANCE_RECOVERFOR_VOLUME, true);
        }
        if (TextUtils.isEmpty(str2)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str);
            s16.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, LocalMediaInfoGenerator.buildLocalMediaInfos(arrayList2));
            s16.putInt(QQWinkConstants.EDITOR_ENTRANCE, 0);
        } else {
            s16.putInt(QQWinkConstants.EDITOR_ENTRANCE, 6);
        }
        QzoneConfig.getInstance();
        Boolean valueOf = Boolean.valueOf(QzoneConfig.isQzoneCompressSwitch(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()));
        ms.a.f("upload2_QZoneQCircleMediaImpl", " enableCompress " + valueOf);
        if (bool.booleanValue() && valueOf.booleanValue()) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            qQProgressDialog.setMessage(R.string.f2201468b);
            qQProgressDialog.show();
            ms.a.f("upload2_QZoneQCircleMediaImpl", "checkCompressPic ");
            ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditorWithCompressMedia(r(activity), s16, new b(activity, qQProgressDialog));
            return;
        }
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditor(r(activity), s16);
        activity.finish();
    }

    public static boolean w() {
        return A() && ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady();
    }

    @Override // com.qzone.common.business.service.media.a
    public void c(Activity activity, c cVar) {
        QZLog.i("upload2_QZoneQCircleMediaImpl", "onLocalPhoto mediaSource\uff1a" + cVar);
        if (activity == null) {
            return;
        }
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        Bundle bundle = cVar.f45832e;
        q(activity, bundle);
        bundle.putBoolean("needRemoveAllLocalPathWhenExport", !g.f53821a.b().d0());
        this.f45810a.k(cVar);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(r(activity), bundle);
    }

    @Override // com.qzone.common.business.service.media.a
    public void d(Activity activity, int i3, Bundle bundle) {
        QZLog.i("upload2_QZoneQCircleMediaImpl", "onLocalPhotoForP2V");
        b(activity, null, null, null, 0, 0, false, false, null, null, null, new HashMap<>(), QZoneMediaBusiness.QZONE_SHUOSHUO_MAKE_VIDEO);
    }

    @Override // com.qzone.common.business.service.media.a
    public void e(Activity activity, ExtendGridView extendGridView, int i3, ArrayList<PictureItem> arrayList, HashMap<String, LocalMediaInfo> hashMap, int i16, Intent intent) {
        PictureItem pictureItem;
        LocalMediaInfo exportVideoInfo;
        VideoInfo videoInfo;
        QZLog.i("upload2_QZoneQCircleMediaImpl", "onPhotoPreview");
        if (activity == null || arrayList == null || arrayList.size() < i3 || (pictureItem = arrayList.get(i3)) == null || TextUtils.isEmpty(pictureItem.localFileUrl)) {
            return;
        }
        String str = pictureItem.localFileUrl;
        if (x(pictureItem)) {
            Bundle s16 = s(activity);
            s16.putString("xsj_ref_pgid", LocalPictureViewer.j5(intent).getBusinessName());
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(str);
            s16.putStringArrayList(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST, arrayList2);
            s16.putString(QQWinkConstants.MISSION_ID, pictureItem.missionId);
            if (pictureItem.missionId != null) {
                s16.putBoolean(QQWinkConstants.EDITOR_TEMPORARY_ENTRANCE_RECOVERFOR_VOLUME, true);
            }
            String str2 = pictureItem.missionId;
            if (str2 != null && str2.length() > 0) {
                s16.putInt(QQWinkConstants.EDITOR_ENTRANCE, 6);
            } else {
                s16.putInt(QQWinkConstants.EDITOR_ENTRANCE, 0);
            }
            ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkPreview(r(activity), s16);
            return;
        }
        if (!TextUtils.isEmpty(pictureItem.missionId) && (exportVideoInfo = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).getExportVideoInfo(pictureItem.missionId)) != null && (videoInfo = pictureItem.videodata) != null) {
            videoInfo.videoUrl = new VideoUrl(exportVideoInfo.path);
        }
        z(activity, i3, arrayList, i16, intent);
    }

    @Override // com.qzone.common.business.service.media.a
    public int f() {
        return 1;
    }

    @Override // com.qzone.common.business.service.media.a
    public void g(Activity activity, File file, int i3, Bundle bundle, QZoneMediaBusiness qZoneMediaBusiness) {
        QZLog.i("upload2_QZoneQCircleMediaImpl", "goToCameraActivity mediaBusiness:" + qZoneMediaBusiness);
        if (activity == null) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        q(activity, bundle);
        bundle.putBoolean("needRemoveAllLocalPathWhenExport", true);
        this.f45810a.l(bundle, qZoneMediaBusiness);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(r(activity), bundle);
    }

    public void y(Activity activity, String str, ArrayList<String> arrayList, String str2, Bundle bundle) {
        QZLog.i("upload2_QZoneQCircleMediaImpl", "[jumpToWinkEditorAfterProcessContent]");
        if (activity == null) {
            QZLog.e("upload2_QZoneQCircleMediaImpl", "[jumpToWinkEditorAfterProcessContent] activity is null");
            return;
        }
        if (arrayList == null && (str2 == null || str2.length() == 0)) {
            QZLog.e("upload2_QZoneQCircleMediaImpl", "[jumpToWinkEditorAfterProcessContent] mediaPaths and textContent is null");
            return;
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putString("ACTION_QCIRCLE_SYNC_PREVIEW", "ACTION_QCIRCLE_PREVIEW_VAL_TRUE");
        bundle2.putString(QQWinkConstants.EDITOR_NEXT_BUTTON_TEXT, "\u5b8c\u6210");
        bundle2.putBoolean(QQWinkConstants.IS_QCIRCLE_AUTO_TEMPLATE, activity.getIntent().getBooleanExtra(QQWinkConstants.IS_QCIRCLE_AUTO_TEMPLATE, false));
        q(activity, bundle2);
        bundle2.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, true);
        bundle2.putBoolean(QQWinkConstants.EDITOR_DISABLE_SAVE_PUBLISH_DRAFT, true);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToWinkEditorAfterProcessContent(BaseApplication.getContext(), "QCIRCLE", str, arrayList, str2, bundle2, null);
    }

    public void z(Activity activity, int i3, ArrayList<PictureItem> arrayList, int i16, Intent intent) {
        QZLog.i("upload2_QZoneQCircleMediaImpl", "onPhotoPreviewByQZone");
        if (arrayList == null) {
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ArrayList<PictureItem> arrayList2 = new ArrayList<>();
        if (intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0) != 1) {
            if (arrayList.size() > i3) {
                arrayList2.add(arrayList.get(i3));
            }
            if (arrayList2.isEmpty()) {
                return;
            } else {
                arrayList = arrayList2;
            }
        }
        l(activity, arrayList, intent, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements a.InterfaceC0438a<ShuoshuoVideoInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog[] f45818a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f45819b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f45820c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZoneMediaBusiness f45821d;

        a(QQProgressDialog[] qQProgressDialogArr, Activity activity, LocalMediaInfo localMediaInfo, QZoneMediaBusiness qZoneMediaBusiness) {
            this.f45818a = qQProgressDialogArr;
            this.f45819b = activity;
            this.f45820c = localMediaInfo;
            this.f45821d = qZoneMediaBusiness;
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void f(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, int i3, String str) {
            QZLog.i("upload2_QZoneQCircleMediaImpl", "compressVideoAndGoEdit onProcessFailed code:" + i3 + ",msg:" + str);
            ToastUtil.s(this.f45819b.getString(R.string.f2201368a), 4);
            QZoneQCircleMediaImpl.this.o(this.f45818a[0]);
            QZoneQCircleMediaImpl.this.f45811b = null;
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void d(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2) {
            if (shuoshuoVideoInfo2 == null) {
                return;
            }
            QZoneQCircleMediaImpl.this.o(this.f45818a[0]);
            QZLog.i("upload2_QZoneQCircleMediaImpl", "compressVideoAndGoEdit onProcessSucceed");
            QZoneQCircleMediaImpl.this.t(this.f45819b, shuoshuoVideoInfo2.mVideoPath, shuoshuoVideoInfo2.mProcessMissionID, this.f45820c.path, this.f45821d);
            QZoneQCircleMediaImpl.this.f45811b = null;
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo) {
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void e(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo) {
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void c(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2) {
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void a(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2, float f16) {
        }
    }

    private void q(Activity activity, Bundle bundle) {
        if (activity != null) {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        }
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        bundle.putString("app_key", "0AND0MWZXR4U3RVU");
        bundle.putLong("wink_output_point", 35L);
        bundle.putString("wink_output_route", QzoneWinkOutputRouter.ROUTE_PATH);
        wk.b.f445744a.a(bundle);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        QzonePluginProxyActivity.toExActivityWithResult(bundle);
    }

    @Override // com.qzone.common.business.service.media.a
    @Deprecated
    public void b(Activity activity, Fragment fragment, ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, int i3, int i16, boolean z16, boolean z17, ConcurrentHashMap<String, String> concurrentHashMap, String str, Bundle bundle, HashMap<String, LocalMediaInfo> hashMap2, QZoneMediaBusiness qZoneMediaBusiness) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("PICKER_MAX_COUNT_SUPPORT", i3);
        c cVar = new c(qZoneMediaBusiness);
        cVar.f45828a = i3;
        cVar.f45830c = arrayList;
        cVar.f45831d = hashMap;
        cVar.f45832e = bundle;
        c(activity, cVar);
    }

    public void v(c cVar) {
        if (cVar == null) {
            QZLog.e("upload2_QZoneQCircleMediaImpl", "initJumpBundle selectMediaParams is null");
            return;
        }
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        q(null, cVar.f45832e);
        this.f45810a.k(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final QQProgressDialog qQProgressDialog) {
        if (qQProgressDialog == null) {
            return;
        }
        QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.common.business.service.media.QZoneQCircleMediaImpl.4
            @Override // java.lang.Runnable
            public void run() {
                if (qQProgressDialog.isShowing()) {
                    qQProgressDialog.dismiss();
                }
            }
        });
    }

    private boolean x(PictureItem pictureItem) {
        return pictureItem != null && pictureItem.type == 1000 && !TextUtils.isEmpty(pictureItem.missionId) && ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).getExportVideoInfo(pictureItem.missionId) == null;
    }

    @Override // com.qzone.common.business.service.media.a
    public void a(final Activity activity, PhotoInfo photoInfo, final QZoneMediaBusiness qZoneMediaBusiness) {
        if (photoInfo == null || activity == null) {
            return;
        }
        if (TextUtils.isEmpty(photoInfo.missionId) && photoInfo.videodata != null) {
            final LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = photoInfo.bigUrl;
            localMediaInfo.missionID = photoInfo.missionId;
            p(localMediaInfo);
            if (Math.min(localMediaInfo.mediaWidth, localMediaInfo.mediaHeight) > QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_EDIT_MIN_WIDTH_MAX_SUPPORT_VALUE_QCIRCLE_PUBLISH, 1080)) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.VideoThread).post(new Runnable() { // from class: com.qzone.common.business.service.media.QZoneQCircleMediaImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneQCircleMediaImpl.this.n(activity, localMediaInfo, qZoneMediaBusiness);
                    }
                });
                return;
            } else {
                String str = photoInfo.bigUrl;
                t(activity, str, photoInfo.missionId, str, qZoneMediaBusiness);
                return;
            }
        }
        String str2 = photoInfo.bigUrl;
        u(activity, str2, photoInfo.missionId, str2, qZoneMediaBusiness, Boolean.TRUE);
    }

    private void l(Activity activity, ArrayList<PictureItem> arrayList, Intent intent, int i3) {
        m(activity, arrayList, intent, i3, 0);
    }
}
