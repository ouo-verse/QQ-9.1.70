package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.ae.play.AEQuDongConstants;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.e;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.g;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.activity.photo.album.j;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.activity.photo.album.photolist.d;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.activity.richmedia.f;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qqslideshow.ISlideShowController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.XMPCoreUtil;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import js.a;
import qs.c;

/* loaded from: classes10.dex */
public class PhotoListCustomizationQzone extends PhotoListCustomizationDefault implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name */
    public static final String f184396f0;

    /* renamed from: g0, reason: collision with root package name */
    public static boolean f184397g0;

    /* renamed from: h0, reason: collision with root package name */
    public static boolean f184398h0;
    public String F;
    private boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    private boolean L;
    private LinkedHashMap<String, LocalMediaInfo> M;
    protected boolean N;
    private boolean P;
    int Q;
    boolean R;
    HashMap<String, Integer> S;
    boolean T;
    long U;
    int V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    boolean f184399a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f184400b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f184401c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f184402d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f184403e0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        f184396f0 = PhotoListCustomizationQzone.class.getName();
        f184397g0 = false;
        f184398h0 = false;
    }

    PhotoListCustomizationQzone(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
            return;
        }
        this.F = "";
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.P = false;
        this.Q = 0;
        this.R = false;
        this.T = false;
        this.Y = false;
        this.Z = "";
        this.f184401c0 = false;
    }

    private boolean R0() {
        if (!this.I && !this.H && !this.J && !this.X && !this.P) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        PhotoListSceneBase photoListSceneBase = this.f184313i;
        if (photoListSceneBase.H != null && this.M != null) {
            List<LocalMediaInfo> U0 = U0(photoListSceneBase.I.findFirstVisibleItemPosition(), this.f184313i.I.findLastVisibleItemPosition());
            if (U0 != null && this.M != null) {
                for (LocalMediaInfo localMediaInfo : U0) {
                    if (!this.M.containsKey(localMediaInfo.path)) {
                        this.M.put(localMediaInfo.path, localMediaInfo);
                    }
                }
            }
            this.Y = true;
        }
    }

    private List<LocalMediaInfo> U0(int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        if (i3 >= 0 && i16 >= 0 && i3 <= i16) {
            while (i3 <= i16) {
                try {
                    if (i3 < this.f184313i.Q.getNUM_BACKGOURND_ICON()) {
                        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
                        if (m06.mMimeType.equals("image/jpeg")) {
                            arrayList.add(m06);
                        }
                    }
                    i3++;
                } catch (Exception e16) {
                    QLog.e("QQAlbum", 2, "getExposedMedia error!", e16);
                }
            }
        }
        return arrayList;
    }

    private void W0() {
        if (d1()) {
            QZLog.e("QQAlbum", 2, "audio video invalid.");
            QQToast.makeText(this.D, 0, R.string.hld, 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(AECameraConstants.EXTRA_ACTIVITY_START_TIME, System.currentTimeMillis());
        bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
        bundle.putInt("edit_video_type", 10001);
        bundle.putInt("entrance_type", 122);
        bundle.putInt(PeakConstants.BUSI_TYPE, 3);
        bundle.putInt(IJumpUtil.EDIT_VIDEO_WAY, 12);
        bundle.putInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, 1);
        bundle.putInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, 5);
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, a.R.b());
        bundle.putBoolean(PeakConstants.EXTRA_DIRECTLY_BACK, true);
        bundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        bundle.putBoolean(PeakConstants.DIRECT_BACK_TO_QZONE, true);
        bundle.putString(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME, NewPhotoListActivity.class.getName());
        bundle.putBoolean(ShortVideoConstants.ENABLE_EDIT_VIDEO, true);
        bundle.putBoolean(AECameraConstants.KEY_ENABLE_INPUT_TEXT, false);
        bundle.putBoolean(AECameraConstants.KEY_ENABLE_PRIV_LIST, false);
        bundle.putInt(PeakConstants.KEY_ENTRY_SOURCE, 5);
        bundle.putBoolean("support_record", true);
        bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, false);
        bundle.putBoolean("enable_local_button", false);
        bundle.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, false);
        bundle.putBoolean("enterPtu", false);
        bundle.putInt(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 1);
        QZoneHelper.forwardToQzoneVideoCaptureNew(this.D, bundle, 10001);
    }

    private void X0(int i3, Intent intent) {
        Intent intent2 = this.D.getIntent();
        intent2.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent2.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        int intValue = m06.position.intValue();
        if (!f184397g0 && QAlbumUtil.getMediaType(m06) == 1) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            ArrayList<String> arrayList = photoCommonBaseData.mediaPathsList;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                photoCommonBaseData.mediaPathsList = new ArrayList<>();
            }
            this.f184310e.mediaPathsList.add(m06.path);
            PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
            ArrayList<String> arrayList2 = photoCommonBaseData2.selectedPhotoList;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                photoCommonBaseData2.selectedPhotoList = new ArrayList<>();
            }
            this.f184310e.selectedPhotoList.add(m06.path);
            PhotoCommonBaseData<O> photoCommonBaseData3 = this.f184310e;
            ArrayList<Integer> arrayList3 = photoCommonBaseData3.selectedIndex;
            if (arrayList3 != null) {
                arrayList3.clear();
            } else {
                photoCommonBaseData3.selectedIndex = new ArrayList<>();
            }
            this.f184310e.selectedIndex.add(0);
            PhotoCommonBaseData<O> photoCommonBaseData4 = this.f184310e;
            HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData4.selectedMediaInfoHashMap;
            if (hashMap != null) {
                hashMap.clear();
            } else {
                photoCommonBaseData4.selectedMediaInfoHashMap = new HashMap<>();
            }
            this.f184310e.selectedMediaInfoHashMap.put(m06.path, m06);
            intent2.putExtra("PhotoConst.IS_SINGLE_MODE", true);
            intValue = 0;
        }
        intent2.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, intValue);
        intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
        intent2.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, this.f184310e.selectedIndex);
        intent2.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent2.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, ((h) this.f184311f).f184248f);
        intent2.putExtra(QAlbumConstants.SHOW_ALBUM, true);
        intent2.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, this.C.A);
        intent2.putExtra("PasterConstants.paster_id", this.C.C);
        intent2.putExtra("PasterConstants.paster_cate_id", this.C.D);
        com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
        if (!this.f184310e.selectedMediaInfoHashMap.containsKey(m06.path)) {
            this.f184310e.selectedMediaInfoHashMap.put(m06.path, m06);
        }
        intent2.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184310e.selectedMediaInfoHashMap);
        intent2.putExtra("PasterConstants.pasters_data", this.C.B);
        intent2.setClass(this.D, NewPhotoPreviewActivity.class);
        boolean z16 = this.I;
        if (z16) {
            intent.putExtra(PeakConstants.FROM_SHUOSHUO, z16);
        }
        intent2.putExtra(PeakConstants.FROM_QZONE, this.P);
        intent2.addFlags(603979776);
        ArrayList<String> arrayList4 = this.f184310e.selectedPhotoList;
        if (arrayList4 != null && arrayList4.size() > 0) {
            ReportController.n(null, "CliOper", "", ((h) this.f184311f).f184249h, "0X8005674", "0X8005674", 0, this.f184310e.selectedPhotoList.size(), 0, "", "", "", "");
        }
        if (this.W) {
            this.D.startActivityForResult(intent, 10010);
        } else {
            this.D.startActivity(intent2);
            this.D.finish();
        }
        QAlbumUtil.anim(this.D, true, true);
    }

    private void Y0(LocalMediaInfo localMediaInfo, Intent intent) {
        Intent intent2 = new Intent(this.D, (Class<?>) ShortVideoPreviewActivity.class);
        intent2.putExtras(intent);
        intent2.putExtra("file_send_path", localMediaInfo.path);
        intent2.putExtra(ShortVideoConstants.FILE_SEND_SIZE, localMediaInfo.fileSize);
        intent2.putExtra(ShortVideoConstants.FILE_SEND_DURATION, localMediaInfo.mDuration);
        intent2.putExtra(ShortVideoConstants.FILE_WIDTH, localMediaInfo.mediaWidth);
        intent2.putExtra(ShortVideoConstants.FILE_HEIGHT, localMediaInfo.mediaHeight);
        intent2.putExtra("uin", this.C.J);
        intent2.putExtra("uintype", this.C.H);
        intent2.putExtra(ShortVideoConstants.FILE_SOURCE, "album");
        intent2.putExtra(ShortVideoConstants.IS_FROM_SYSTEM_MEDIA, localMediaInfo.isSystemMeidaStore);
        if (this.C.f184293d) {
            intent2.putExtra(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
            intent2.putExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        }
        if ((this.H || (this.I && f184397g0 && !f184398h0)) && this.C.f184293d) {
            intent2.putExtra(ShortVideoPreviewActivity.PREVIEW_ONLY, true);
        }
        this.D.startActivityForResult(intent2, 17);
    }

    private void a1(Intent intent) {
        int i3;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_content");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String str = stringExtra;
            int intExtra = intent.getIntExtra("key_priv", 1);
            ArrayList<String> arrayList = (ArrayList) intent.getSerializableExtra(AEEditorConstants.KEY_PRIV_UIN_LIST);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            ArrayList<String> arrayList2 = arrayList;
            int intExtra2 = intent.getIntExtra(AEEditorConstants.KEY_FONT_ID, -1);
            int intExtra3 = intent.getIntExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, 0);
            String stringExtra2 = intent.getStringExtra(AEEditorConstants.KEY_FONT_URL);
            int intExtra4 = intent.getIntExtra(AEEditorConstants.KEY_SUPER_FONT_ID, -1);
            String stringExtra3 = intent.getStringExtra(AEEditorConstants.KEY_SUPER_FONT_INFO);
            boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.KEY_GENERATE_GIF, false);
            boolean booleanExtra2 = intent.getBooleanExtra(AEEditorConstants.KEY_TIMER_DELETE, false);
            PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
            if (publishParam == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQAlbum", 2, "handleQzoneEditVideoResult: publishParam == null");
                    return;
                }
                return;
            }
            int i16 = publishParam.I;
            if (i16 <= 5) {
                i3 = i16;
            } else {
                i3 = 0;
            }
            u1(publishParam.Q, i3, publishParam.P, publishParam.f69067e, publishParam.f69066d, (int) publishParam.E, intent.getIntExtra(AECameraConstants.KEY_VIDEO_FRAME_COUNT, 0), (c) ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback(), str, intExtra, arrayList2, intExtra2, intExtra3, stringExtra2, intExtra4, stringExtra3, booleanExtra, booleanExtra2, intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN, false));
        }
    }

    private void b1(Intent intent) {
        this.F = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        boolean z16 = false;
        this.f184399a0 = intent.getBooleanExtra(PeakConstants.IS_TRIM_VIDEO_BLACK_LIST, false);
        this.R = intent.getBooleanExtra(PeakConstants.FROM_DYNAMIC_ALBUM, false);
        this.f184400b0 = intent.getBooleanExtra(PeakConstants.IS_FROM_P2V, false);
        this.L = intent.getBooleanExtra("NEED_QZONE_MACHINE_LEARNING_REPORT", false);
        f184397g0 = intent.getBooleanExtra("QZONE_SUPPORT_MIX_MOOD", false);
        this.N = intent.getBooleanExtra(PeakConstants.QZONE_PEAK_SUPPORT_VIDEO_EDIT_WHEN_PREVIEW, false);
        f184398h0 = intent.getBooleanExtra(PeakConstants.KEY_UPLOAD_SINGLE_VIDEO, false);
        this.Q = intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        this.f184403e0 = intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, -1);
        this.S = (HashMap) intent.getSerializableExtra(PeakConstants.PANORAMA_IMAGES);
        this.T = intent.getBooleanExtra(PeakConstants.IS_NO_PANORAMA, false);
        this.U = intent.getLongExtra(PeakConstants.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION, Long.MAX_VALUE);
        this.X = intent.getBooleanExtra("from_qzoneshare", false);
        this.Z = intent.getStringExtra("report_from");
        if (intent.getIntExtra(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 0) != 0) {
            z16 = true;
        }
        this.f184401c0 = z16;
        this.f184402d0 = intent.getStringExtra(PeakConstants.QZONE_SINGLE_PHOTO_PATH_EDITED);
    }

    private void c1(Intent intent) {
        PhotoCommonBaseData<O> photoCommonBaseData;
        ArrayList<String> arrayList;
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((stringArrayListExtra == null || stringArrayListExtra.isEmpty()) && (photoCommonBaseData = this.f184310e) != 0 && (arrayList = photoCommonBaseData.selectedPhotoList) != null) {
            arrayList.clear();
        }
        if (this.f184401c0 && !TextUtils.isEmpty(this.f184402d0)) {
            Z0(this.f184402d0);
            j.m(this);
        }
    }

    private boolean d1() {
        IModule moduleByName = AVBizModuleFactory.getModuleByName(Constants.Business.DEFAULT_CAMERA);
        if (moduleByName != null && !"true".equals(moduleByName.checkAVFocus())) {
            return true;
        }
        return false;
    }

    private boolean e1(String str) {
        if (!QZoneHelper.UPLOAD_PHOTO.equals(str) && !((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName().equals(str) && !"com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(str) && !QZoneHelper.QZONE_FEEDACTIONPANELACTIVITY.equals(str) && !QZoneHelper.QQ_PUBLIC_ACCOUNT_PUBLISH_PAGE.equals(str) && !this.R && !this.K) {
            return false;
        }
        return true;
    }

    private boolean f1(String str) {
        if (!"com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(str) && !((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName().equals(str) && !QZoneHelper.QQ_PUBLIC_ACCOUNT_PUBLISH_PAGE.equals(str) && !"com.tencent.qcircle.QCirclePublishFeedActivity".equals(str)) {
            return false;
        }
        return true;
    }

    private boolean g1(String str) {
        return "com.qzone.publish.ui.activity.QZonePublishVoiceMoodActivity".equals(str);
    }

    private boolean h1(String str) {
        return QZoneHelper.UPLOAD_PHOTO.equals(str);
    }

    private boolean i1(LocalMediaInfo localMediaInfo, Intent intent, String str) {
        boolean z16 = true;
        if (this.N) {
            if ("qzone_plugin.apk".equals(str)) {
                String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                if (stringExtra != null && !stringExtra.contains("TrimVideoActivity")) {
                    ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
                    if (arrayList != null && arrayList.size() > 0) {
                        QQToast.makeText(this.D, "\u4e0d\u80fd\u540c\u65f6\u9009\u62e9\u7167\u7247\u548c\u89c6\u9891", 0).show();
                        this.C.f184243x = false;
                        return true;
                    }
                    if (localMediaInfo.mDuration < this.f184310e.filter.videoMaxDuration) {
                        this.C.f184243x = true;
                    } else {
                        this.C.f184243x = false;
                        StringBuilder sb5 = new StringBuilder();
                        long j3 = this.f184310e.filter.videoMaxDuration / 1000;
                        if (j3 > 60) {
                            long j16 = j3 / 60;
                            if (j16 > 60) {
                                sb5.append(j16 / 60);
                                sb5.append("\u5c0f\u65f6");
                            } else {
                                sb5.append(j16);
                                sb5.append("\u5206\u949f");
                            }
                        } else {
                            sb5.append(j3);
                            sb5.append("\u79d2");
                        }
                        sb5.append("\u4ee5\u4e0a\u7684\u89c6\u9891\u4e0d\u53ef\u9009");
                        QQToast.makeText(this.D, sb5.toString(), 0).show();
                        return true;
                    }
                } else if (this.W) {
                    this.C.f184243x = true;
                } else {
                    g gVar = this.C;
                    if (localMediaInfo.mDuration <= this.f184310e.filter.videoMaxDuration) {
                        z16 = false;
                    }
                    gVar.f184243x = z16;
                    intent.putExtra(PeakConstants.IS_PREVIEW_VIDEO, z16);
                }
            }
        } else if ("qzone_plugin.apk".equals(str)) {
            String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            if (stringExtra2 != null && !stringExtra2.contains("TrimVideoActivity")) {
                if (!this.f184399a0 && localMediaInfo.mDuration <= this.f184310e.filter.videoMaxDuration && !this.H && (!this.I || !f184397g0)) {
                    this.C.f184243x = false;
                    intent.putExtra("support_record", false);
                    intent.putExtra("support_trim", true);
                    intent.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
                    intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                    intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
                    intent.putExtra(PeakConstants.SHOW_MAGIC_USE_PASTER, this.C.A);
                } else {
                    this.C.f184243x = true;
                }
            } else if (this.W) {
                this.C.f184243x = true;
            } else {
                g gVar2 = this.C;
                if (localMediaInfo.mDuration <= this.f184310e.filter.videoMaxDuration) {
                    z16 = false;
                }
                gVar2.f184243x = z16;
                intent.putExtra(PeakConstants.IS_PREVIEW_VIDEO, z16);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(LocalMediaInfo localMediaInfo) {
        QZLog.i("QQAlbum", "loadPanoramaPhoto");
        XMPCoreUtil.getInstance().loadXMPCoreJarModule(new XMPCoreUtil.XMPCoreJarLoadListener(localMediaInfo) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.3
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ LocalMediaInfo f184407a;

            {
                this.f184407a = localMediaInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationQzone.this, (Object) localMediaInfo);
                }
            }

            @Override // cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener
            public void loadState(boolean z16) {
                int i3;
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                QZLog.i("QQAlbum", "loadPanoramaPhoto loadXMPCoreModuleSuccess");
                if (z16) {
                    LocalMediaInfo localMediaInfo2 = this.f184407a;
                    if (localMediaInfo2.rotation == 90 && (i3 = localMediaInfo2.mediaWidth) < (i16 = localMediaInfo2.mediaHeight)) {
                        localMediaInfo2.mediaHeight = i3;
                        localMediaInfo2.mediaWidth = i16;
                        QZLog.i("QQAlbum", "loadPanoramaPhoto LocalTake");
                        ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).setPanoramaType(this.f184407a);
                        return;
                    }
                    QZLog.i("QQAlbum", "loadPanoramaPhoto NotLocalTake");
                    ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).setPanoramaType(this.f184407a);
                }
            }
        });
    }

    private void k1(List<LocalMediaInfo> list) {
        QZLog.i("QQAlbum", "loadPanoramaPhotoList");
        ThreadManagerV2.excute(new Runnable(list) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f184405d;

            {
                this.f184405d = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationQzone.this, (Object) list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f184405d);
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) arrayList.get(i16);
                    int i17 = localMediaInfo.mediaWidth;
                    if (i17 > 0 && (i3 = localMediaInfo.mediaHeight) > 0) {
                        if (i17 / i3 != 2.0f && i17 / i3 < 4.0f && i3 / i17 < 4.0f) {
                            localMediaInfo.panoramaPhotoType = 3;
                        } else {
                            QZLog.i("QQAlbum", "loadPanoramaPhotoList LoadPanoramaPhoto");
                            PhotoListCustomizationQzone.this.j1(localMediaInfo);
                        }
                    }
                }
                if (((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).D != null && ((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).C.P != null) {
                    QZLog.i("QQAlbum", "loadPanoramaPhotoList HandlerPost");
                    ((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).C.P.post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            d dVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).D != null && (dVar = PhotoListCustomizationQzone.this.f184313i.Q) != null) {
                                dVar.notifyDataSetChanged();
                                QZLog.i("QQAlbum", "loadPanoramaPhotoList NotifyDataSetChanged");
                            }
                        }
                    });
                }
            }
        }, 16, null, false);
    }

    private ArrayList<String> l1(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    arrayList.add(str2);
                }
            }
        } catch (NullPointerException unused) {
            QLog.e("QQAlbum", 2, "parseBlockPaths error!");
        }
        return arrayList;
    }

    private void m1(Intent intent) {
        d dVar;
        if (this.f184310e.selectedMediaInfoHashMap != null && this.M != null) {
            try {
                if (!this.Y && (dVar = this.f184313i.Q) != null && dVar.getNUM_BACKGOURND_ICON() > 0) {
                    S0();
                }
                int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_ML_EXPOSED_MEDIA_UPPER_BOUND, 50) - this.f184310e.selectedMediaInfoHashMap.size();
                if (config > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Map.Entry<String, LocalMediaInfo>> it = this.M.entrySet().iterator();
                    int i3 = 0;
                    while (it.hasNext() && i3 < config) {
                        LocalMediaInfo value = it.next().getValue();
                        if (!this.f184310e.selectedMediaInfoHashMap.containsKey(value.path)) {
                            arrayList.add(value);
                            i3++;
                        }
                    }
                    intent.putExtra(PeakConstants.QZONE_ALBUM_ML_EXPOSED_MEDIA_LST, arrayList);
                }
            } catch (Exception e16) {
                QLog.e("QQAlbum", 2, "prepareExposedMediaInfo error!", e16);
            }
        }
    }

    private void n1(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            hashMap.put("result_photo", "1");
                            QLog.i("QQAlbum", 2, "result_photo");
                        }
                    } else {
                        hashMap.put("result_video", "1");
                        QLog.i("QQAlbum", 2, "result_video");
                    }
                } else {
                    hashMap.put("click_pass", "1");
                    QLog.i("QQAlbum", 2, "click_pass");
                }
            } else {
                hashMap.put("click_fail", "1");
                QLog.i("QQAlbum", 2, "click_fail");
            }
        } else if (!this.G) {
            this.G = true;
            hashMap.put(QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, "1");
            QLog.i("QQAlbum", 2, QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE);
        }
        if (hashMap.size() > 0) {
            QLog.i("QQAlbum", 2, "begin report");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.QZONE_CHOOSE_PHOTO_CAMERA_TAG, true, 0L, 0L, hashMap, (String) null, true);
        } else {
            QLog.i("QQAlbum", 2, "no param");
        }
    }

    private void o1() {
        String str;
        Iterator<String> it = this.f184310e.selectedPhotoList.iterator();
        boolean z16 = false;
        boolean z17 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (this.f184310e.selectedMediaInfoHashMap.containsKey(next) && QAlbumUtil.getMediaType(this.f184310e.selectedMediaInfoHashMap.get(next)) == 1) {
                it.remove();
                z16 = true;
            } else if (!this.f184310e.selectedMediaInfoHashMap.containsKey(next) && next.startsWith("https://qzs.qq.com") && next.toLowerCase().endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                it.remove();
                z17 = true;
            }
        }
        if (this.f184310e.selectedPhotoList.size() > this.f184310e.maxSelectNum) {
            str = this.D.getResources().getString(R.string.cu5, Integer.valueOf(this.f184310e.maxSelectNum));
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
            arrayList.subList(photoCommonBaseData.maxSelectNum, arrayList.size()).clear();
        } else if (z16) {
            str = this.D.getResources().getString(R.string.cu9);
        } else if (z17) {
            str = this.D.getResources().getString(R.string.cu8);
        } else {
            str = null;
        }
        if (str != null) {
            QQToast.makeText(this.D, str, 0).show();
        }
    }

    private void p1() {
        Iterator<String> it = this.f184310e.selectedPhotoList.iterator();
        while (it.hasNext()) {
            if (QAlbumUtil.getMediaType(this.f184310e.selectedMediaInfoHashMap.get(it.next())) == 1) {
                it.remove();
            }
        }
    }

    private void q1(int i3) {
        int i16;
        int i17;
        if (TextUtils.isEmpty(this.Z)) {
            return;
        }
        int size = this.f184310e.selectedPhotoList.size();
        int i18 = 2;
        if (size == 0) {
            i17 = 601;
            i16 = 0;
        } else {
            if (size == 1) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            i17 = 600;
        }
        if (i3 == R.id.ivTitleBtnLeft) {
            i18 = 3;
        } else if (i3 != R.id.ivTitleBtnRightText) {
            if (i3 == R.id.fyh) {
                i18 = 4;
            } else if (i3 == R.id.send_btn) {
                i18 = 1;
            } else if (i3 == R.id.ekt) {
                i18 = 5;
            } else {
                return;
            }
        }
        if (this.Q == 1 && i3 == R.id.send_btn) {
            LpReportInfo_pf00064.allReport(586, 47, 3, String.valueOf(size));
        } else {
            LpReportInfo_pf00064.allReport(i17, i16, i18);
        }
    }

    private void r1(Intent intent) {
        Serializable serializableExtra;
        if (intent != null) {
            try {
                if (this.M != null && (serializableExtra = intent.getSerializableExtra(PeakConstants.QZONE_ALBUM_ML_EXPOSED_MEDIA_LST)) != null) {
                    for (LocalMediaInfo localMediaInfo : (List) serializableExtra) {
                        this.M.put(localMediaInfo.path, localMediaInfo);
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQAlbum", 2, "restoreUnSelectedExposedData error!", e16);
            }
        }
    }

    private void s1(LocalMediaInfo localMediaInfo, Intent intent) {
        intent.putExtra("file_send_path", localMediaInfo.path);
        intent.putExtra(PeakConstants.IS_VIDEO_SELECTED, true);
        intent.putExtra(PeakConstants.VIDEO_SIZE, localMediaInfo.fileSize);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, localMediaInfo.mDuration);
        intent.putExtra(ShortVideoConstants.FILE_WIDTH, localMediaInfo.mediaWidth);
        intent.putExtra(ShortVideoConstants.FILE_HEIGHT, localMediaInfo.mediaHeight);
        intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMediaInfo.path);
        PhotoUtils.sendPhoto(this.D, intent, arrayList, 2, false);
    }

    private void u1(String str, int i3, String str2, String str3, String str4, int i16, int i17, c cVar, String str5, int i18, ArrayList<String> arrayList, int i19, int i26, String str6, int i27, String str7, boolean z16, boolean z17, boolean z18) {
        if (TextUtils.isEmpty(str2)) {
            QLog.e("QQAlbum", 1, "videoFilePath is empty.");
            return;
        }
        String parent = new File(str2).getParent();
        if (!TextUtils.isEmpty(str4)) {
            ((IPtvFilterUtil) QRoute.api(IPtvFilterUtil.class)).createFakeVidConfigFile(parent, str4);
        }
        VideoSendPublicParamBase videoSendPublicParamBase = new VideoSendPublicParamBase();
        videoSendPublicParamBase.mContext = this.D;
        videoSendPublicParamBase.mVideoCacheDir = parent;
        videoSendPublicParamBase.mEncodeMode = i3;
        videoSendPublicParamBase.mVideoFilePath = str2;
        videoSendPublicParamBase.mThumbFilePath = str3;
        videoSendPublicParamBase.mThumbWidth = 0;
        videoSendPublicParamBase.mThumbHeight = 0;
        videoSendPublicParamBase.fakeVid = str4;
        videoSendPublicParamBase.recordTime = i16;
        videoSendPublicParamBase.mUserCallBack = cVar;
        videoSendPublicParamBase.mContent = str5;
        videoSendPublicParamBase.mPriv = i18;
        videoSendPublicParamBase.mPrivUinList = arrayList;
        videoSendPublicParamBase.mEnableEditVideo = true;
        videoSendPublicParamBase.topicSyncQzone = false;
        videoSendPublicParamBase.fontId = i19;
        videoSendPublicParamBase.fontFormatType = i26;
        videoSendPublicParamBase.fontUrl = str6;
        videoSendPublicParamBase.superFontId = i27;
        videoSendPublicParamBase.superFontInfo = str7;
        videoSendPublicParamBase.generateGif = z16;
        videoSendPublicParamBase.timerDelete = z17;
        videoSendPublicParamBase.isUploadOrigin = z18;
        videoSendPublicParamBase.entrySource = 5;
        videoSendPublicParamBase.mUin = "";
        videoSendPublicParamBase.mUinType = 0;
        videoSendPublicParamBase.mTroopUin = "";
        ((IMediaCodecSendTask) QRoute.api(IMediaCodecSendTask.class)).execute(videoSendPublicParamBase);
    }

    private void v1(Intent intent) {
        String stringExtra = intent.getStringExtra("PhotoConst.PLUGIN_APK");
        String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if ("qzone_plugin.apk".equals(stringExtra) && QZoneHelper.QZONE_VIDEO_TRIM.equals(stringExtra2)) {
            intent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
            intent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
            intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        }
        if ("qzone_plugin.apk".equals(stringExtra)) {
            intent.putExtra(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, intent.getBooleanExtra(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, false));
        }
        if (this.H || ((this.I && f184397g0) || this.K)) {
            intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f184310e.selectedMediaInfoHashMap);
        }
        if (this.L) {
            m1(intent);
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null) {
            f.l(arrayList);
        }
        intent.putExtra(PeakConstants.PANORAMA_IMAGES, this.S);
        if (1 == this.Q) {
            intent.putExtra(PeakConstants.KEY_SHOW_TYPE, 1);
            intent.putExtra(PeakConstants.KEY_SHOW_ORIGIN_TYPE, 1);
        } else {
            intent.putExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        }
        intent.putExtra(PeakConstants.KEY_STATE_TYPE, this.f184403e0);
        intent.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        B0(intent, false, this.f184310e.selectedPhotoList);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void B(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent);
        } else {
            n1(5);
            super.B(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    protected void B0(Intent intent, boolean z16, ArrayList<String> arrayList) {
        LocalMediaInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, intent, Boolean.valueOf(z16), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (int i16 = 0; i16 < this.f184310e.selectedPhotoList.size(); i16++) {
            String str = this.f184310e.selectedPhotoList.get(i16);
            if (!ImageManager.isNetworkUrl(str)) {
                if (((h) this.f184311f).b(this.f184310e, str) == 1 && (a16 = ((h) this.f184311f).a(this.f184310e, str)) != null) {
                    SendVideoInfo sendVideoInfo = new SendVideoInfo();
                    sendVideoInfo.fileSize = a16.fileSize;
                    sendVideoInfo.duration = a16.mDuration;
                    hashMap.put(Integer.valueOf(i3), sendVideoInfo);
                }
                i3++;
            }
        }
        if (!hashMap.isEmpty()) {
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
        }
        if (z16) {
            ((IAlbumUtils) QRoute.api(IAlbumUtils.class)).sendPhoto(this.D, intent, this.f184310e.selectedPhotoList, this.C.f184242w, ((h) this.f184311f).f184248f, false);
        } else {
            PhotoUtils.sendPhoto(this.D, intent, this.f184310e.selectedPhotoList, ((h) this.f184311f).f184248f, this.C.f184241v);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void C(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) intent);
        } else {
            n1(4);
            super.C(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        Intent intent = this.D.getIntent();
        if (this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
            StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumRecent", true, 0L, 0L, null, "");
        } else if (!this.f184310e.albumName.equalsIgnoreCase("Camera") && !this.f184310e.albumName.equalsIgnoreCase("camera") && !this.f184310e.albumName.contains("Camera") && !this.f184310e.albumName.contains("camera")) {
            StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumOther", true, 0L, 0L, null, "");
        } else {
            StatisticCollector.getInstance(this.D).collectPerformance(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        }
        PresendPicMgr f16 = PresendPicMgr.f();
        g gVar = this.C;
        if (gVar.A && (!TextUtils.isEmpty(gVar.C) || !TextUtils.isEmpty(this.C.D))) {
            TextView textView = this.D.magicStickBtn;
            if (textView != null) {
                textView.performClick();
                return;
            }
            return;
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null) {
            m.n(intent, arrayList.size());
            m.i(intent, this.f184310e.selectedPhotoList.size(), ((h) this.f184311f).f184248f);
        }
        if (((h) this.f184311f).f184248f == 2) {
            if (f16 != null) {
                f16.a(1008);
                f16.d();
            }
            ReportController.o(null, "CliOper", "", "", "0X8005148", "0X8005148", 0, 0, "", "", "", "");
        }
        v1(intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void D(Message message) {
        int j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) message);
            return;
        }
        this.C.P.a();
        Object obj = message.obj;
        if (obj instanceof String) {
            String str = (String) obj;
            QZLog.d("QQAlbum", 2, "onEncodeSuccess = ", str);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            if (photoCommonBaseData.selectedPhotoList == null) {
                photoCommonBaseData.selectedPhotoList = new ArrayList<>();
            }
            if (this.I) {
                j3 = com.tencent.mobileqq.utils.e.l();
            } else {
                j3 = com.tencent.mobileqq.utils.e.j();
            }
            if (this.f184310e.selectedPhotoList.size() >= this.f184310e.maxSelectNum) {
                BasePhotoListActivity basePhotoListActivity = this.D;
                QQToast.makeText(basePhotoListActivity, String.format(basePhotoListActivity.getResources().getString(R.string.cu_), Integer.valueOf(this.f184310e.maxSelectNum)), 0).show();
            } else if (V0() >= j3) {
                BasePhotoListActivity basePhotoListActivity2 = this.D;
                QQToast.makeText(basePhotoListActivity2, String.format(basePhotoListActivity2.getResources().getString(R.string.cub), Integer.valueOf(j3)), 0).show();
            } else {
                this.f184310e.selectedPhotoList.add(str);
                j.m(this);
            }
            j.k(this.D, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        this.W = intent.getBooleanExtra("from_qzone_slideshow", false);
        super.E(intent);
        b1(intent);
        if (!TextUtils.isEmpty(this.F)) {
            this.H = h1(this.F);
            this.I = f1(this.F);
            this.J = g1(this.F);
            this.P = e1(this.F);
        }
        if (this.f184400b0) {
            this.K = true;
            this.I = true;
        }
        if (this.L) {
            this.M = new LinkedHashMap<>();
            r1(intent);
        }
        if (this.S == null) {
            this.S = new HashMap<>();
        }
        if (this.J) {
            this.V = intent.getIntExtra("imageSizeLimit", 0);
        }
        if (this.Q == 1) {
            o1();
        }
        if (this.N) {
            p1();
        }
        if (this.W && this.D.getIntent().getIntExtra("qq_sub_business_id", -1) == 3) {
            SlideShowPhotoListManager.n().B(22);
            SlideShowPhotoListManager.n().A(14);
            SlideShowPhotoListManager.n().H();
            this.D.getIntent().removeExtra("qq_sub_business_id");
        }
        if ((this.P && this.f184310e.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) || (this.R && this.T)) {
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_RECENT_PHOTO_LIMIT_SIZE, 20480);
            int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_RECENT_PHOTO_LIMIT_WIDTH, 100);
            String config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_RECENT_PHOTO_BLOCK_PATHS, QzoneConfig.RECENT_PHOTO_BLOCK_PATHS_DEFAULT);
            if (config3 != null) {
                arrayList = l1(config3);
            } else {
                arrayList = null;
            }
            MediaFileFilter mediaFileFilter = this.f184310e.filter;
            mediaFileFilter.imageMinWidth = config2;
            mediaFileFilter.imageMinHeight = config2;
            mediaFileFilter.imageMinSize = config;
            mediaFileFilter.blockPaths = arrayList;
            mediaFileFilter.needHeif = true;
        }
        c1(intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.F();
        if (this.W) {
            boolean booleanExtra = this.D.getIntent().getBooleanExtra(ISlideShowController.KEY_REPORT_FIRST_EXPOSURE, true);
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).initPhotoListController(this.D, this.f184313i.D, this, booleanExtra);
            t1();
            if (booleanExtra) {
                this.D.getIntent().putExtra(ISlideShowController.KEY_REPORT_FIRST_EXPOSURE, false);
            }
        }
        this.f184313i.H.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationQzone.this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                    return;
                }
                if (PhotoListCustomizationQzone.this.L && i3 == 0) {
                    PhotoListCustomizationQzone photoListCustomizationQzone = PhotoListCustomizationQzone.this;
                    PhotoListSceneBase photoListSceneBase = photoListCustomizationQzone.f184313i;
                    if (photoListSceneBase.H != null && photoListSceneBase.Q != null && photoListCustomizationQzone.f184310e.selectedMediaInfoHashMap != null) {
                        photoListCustomizationQzone.S0();
                    }
                }
                if (i3 == 0) {
                    oy3.a.a().c("list_photo", false);
                } else {
                    oy3.a.a().b("list_photo");
                }
            }
        });
        if (TextUtils.isEmpty(this.f184310e.customSendBtnText) && 1 == this.Q) {
            String string = this.D.getString(R.string.cuc);
            TextView textView = this.D.imgCountTipsTv;
            if (textView != null) {
                textView.setVisibility(0);
                BasePhotoListActivity basePhotoListActivity = this.D;
                basePhotoListActivity.imgCountTipsTv.setText(basePhotoListActivity.getString(R.string.cuo));
                ViewGroup.LayoutParams layoutParams = this.D.imgCountTipsTv.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = ViewUtils.dpToPx(32.0f);
                    layoutParams2.topMargin = ViewUtils.dpToPx(5.0f);
                    this.D.imgCountTipsTv.setLayoutParams(layoutParams);
                }
            }
            Button button = this.f184313i.K;
            if (button != null) {
                button.setText(string);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && i3 == 24747) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).onClipFinish(intent, this.f184310e.selectedMediaInfoHashMap);
        }
        boolean z16 = this.W;
        if (z16 && i16 == -1 && i3 != 24747) {
            this.D.setResult(i16, intent);
            this.D.finish();
            return;
        }
        if (i3 == 10001) {
            if (i16 == -1) {
                a1(intent);
            } else if (z16 && intent != null) {
                String stringExtra = intent.getStringExtra(PeakConstants.FROM_QQSTORY_SLIDESHOW_FILE_DATA);
                if (!TextUtils.isEmpty(stringExtra)) {
                    FileUtils.deleteDirectory(new File(stringExtra).getParent());
                }
                this.D.setResult(0, intent);
                this.D.finish();
            }
        }
        super.G(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void J(View view, int i3, CheckBox checkBox) {
        View childAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, view, Integer.valueOf(i3), checkBox);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (this.W && !((IQQStoryFlowManager) QRoute.api(IQQStoryFlowManager.class)).isValidMedia(this.D, m06)) {
            return;
        }
        if (m06.selectStatus != 1) {
            z16 = false;
        }
        if (!z16) {
            String[] mimeType = MimeHelper.getMimeType(m06.mMimeType);
            if (this.C.f184293d && mimeType != null && "video".equals(mimeType[0]) && !com.tencent.mobileqq.utils.e.d(this.D, V0(), m06, this.I)) {
                m06.selectStatus = 2;
                return;
            }
        }
        super.J(view, i3, checkBox);
        if (this.W) {
            if (((ISlideShowController) QRoute.api(ISlideShowController.class)).getPhotoList().isEmpty() && (childAt = this.f184313i.H.getChildAt(i3 - this.f184313i.I.findFirstVisibleItemPosition())) != null) {
                float height = this.f184313i.H.getHeight() - childAt.getY();
                PhotoListSceneBase photoListSceneBase = this.f184313i;
                if (height < photoListSceneBase.Q.J) {
                    photoListSceneBase.H.smoothScrollBy(ISlideShowController.RECYCLERVIEW_HEIGHT, 500);
                }
            }
            ISlideShowController iSlideShowController = (ISlideShowController) QRoute.api(ISlideShowController.class);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            iSlideShowController.onItemsSelectChanged(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.allMediaInfoHashMap);
        }
        if (!z16) {
            MimeHelper.getMimeType(m06.mMimeType);
            this.S.put(m06.path, Integer.valueOf(m06.panoramaPhotoType));
        } else {
            MimeHelper.getMimeType(m06.mMimeType);
            this.S.remove(m06.path);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void K(boolean z16, int i3, int i16) {
        View childAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.K(z16, i3, i16);
        if (this.W) {
            if (((ISlideShowController) QRoute.api(ISlideShowController.class)).getPhotoList().isEmpty() && (childAt = this.f184313i.H.getChildAt(i3 - this.f184313i.I.findFirstVisibleItemPosition())) != null) {
                float height = this.f184313i.H.getHeight() - childAt.getY();
                PhotoListSceneBase photoListSceneBase = this.f184313i;
                if (height < photoListSceneBase.Q.J) {
                    photoListSceneBase.H.smoothScrollBy(ISlideShowController.RECYCLERVIEW_HEIGHT, 500);
                }
            }
            ISlideShowController iSlideShowController = (ISlideShowController) QRoute.api(ISlideShowController.class);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            iSlideShowController.onItemsSelectChanged(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.allMediaInfoHashMap);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void L(View view) {
        BasePhotoListActivity basePhotoListActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
            return;
        }
        q1(view.getId());
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null && (basePhotoListActivity = this.D) != null) {
            basePhotoListActivity.getIntent().putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList);
        }
        super.L(view);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean N(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) list)).booleanValue();
        }
        if (super.N(list)) {
            if (this.W) {
                PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
                T0(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.selectedMediaInfoHashMap);
                ISlideShowController iSlideShowController = (ISlideShowController) QRoute.api(ISlideShowController.class);
                PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
                iSlideShowController.onItemsSelectChanged(photoCommonBaseData2.selectedPhotoList, photoCommonBaseData2.allMediaInfoHashMap);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) view);
            return;
        }
        q1(view.getId());
        Button button = this.f184313i.K;
        if (button != null) {
            button.setClickable(false);
        }
        if (!this.f184310e.selectedPhotoList.isEmpty()) {
            this.f184313i.s(this.f184310e.selectedPhotoList.get(r1.size() - 1));
        }
        com.tencent.mobileqq.utils.e.e();
        if (this.f184310e.selectedPhotoList.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(AEQuDongConstants.INTENT_KEY_PHOTOLIST, 2, "size == 0");
                return;
            }
            return;
        }
        Intent intent = this.D.getIntent();
        if (intent.getBooleanExtra(PeakConstants.IS_SEND_FILESIZE_LIMIT, false)) {
            Iterator<String> it = this.f184310e.selectedPhotoList.iterator();
            while (it.hasNext()) {
                FileUtils.getFileSizes(it.next());
            }
            if (FileManagerUtil.is2GOr3G()) {
                FMDialogUtil.a(this.D, R.string.b_v, R.string.f170958ba0, new FMDialogUtil.c() { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.5
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationQzone.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
                    public void a() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this);
                            return;
                        }
                        Button button2 = PhotoListCustomizationQzone.this.f184313i.K;
                        if (button2 != null) {
                            button2.setClickable(true);
                        }
                    }

                    @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
                    public void b() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            PhotoListCustomizationQzone.this.C0();
                        }
                    }
                });
                return;
            }
        }
        if (this.X) {
            String stringExtra = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            }
            intent.addFlags(603979776);
            QzonePluginProxyActivity.setActivityNameToIntent(intent, stringExtra);
            QZoneHelper.forwardToFriendFeed(this.D, QZoneHelper.UserInfo.getInstance(), intent, -1, (DialogInterface.OnDismissListener) null);
            return;
        }
        C0();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View view) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            q1(view.getId());
        }
        Intent intent = this.D.getIntent();
        QAlbumUtil.clearSelectItemInfo();
        com.tencent.mobileqq.utils.e.e();
        PresendPicMgr f16 = PresendPicMgr.f();
        if (f16 != null) {
            f16.a(1006);
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        m.e(intent, i3);
        if (!this.C.G) {
            if (this.W) {
                ((ISlideShowController) QRoute.api(ISlideShowController.class)).setData(((ISlideShowController) QRoute.api(ISlideShowController.class)).getTemp());
            }
            this.D.finish();
            QAlbumUtil.anim(this.D, false, false);
            return;
        }
        String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
        if (stringExtra == null) {
            return;
        }
        intent.setClassName(stringExtra2, stringExtra);
        intent.removeExtra("PhotoConst.PHOTO_PATHS");
        intent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (this.H) {
            intent.removeExtra("PeakConstants.selectedMediaInfoHashMap");
        }
        intent.addFlags(603979776);
        if (!intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
            this.D.startActivity(intent);
        } else {
            intent.getStringExtra("PhotoConst.PLUGIN_NAME");
            String stringExtra3 = intent.getStringExtra("PhotoConst.PLUGIN_APK");
            String stringExtra4 = intent.getStringExtra("PhotoConst.UIN");
            if ("qzone_plugin.apk".equals(stringExtra3)) {
                QzonePluginProxyActivity.setActivityNameToIntent(intent, stringExtra);
                QZoneHelper.launchQZone(this.D, stringExtra4, intent, 2);
            } else if ("qqfav.apk".equals(stringExtra3)) {
                QfavHelper.D(this.D, stringExtra4, intent, 2);
            } else {
                QLog.e("QQAlbum", 1, "Watermark has been deleted!");
            }
        }
        this.D.finish();
        QAlbumUtil.anim(this.D, false, false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void R(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
        } else if (this.Q == 1) {
            PublicFragmentActivity.b.a(this.D, intent, PublicFragmentActivityForPeak.class, QzonePhotoPreviewActivity.class);
        } else {
            super.R(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.T();
        String str = this.f184310e.customSendBtnText;
        boolean z16 = true;
        if (str == null) {
            if (1 == this.Q) {
                str = this.D.getString(R.string.cuc);
            } else {
                str = this.D.getString(R.string.ctx);
            }
        }
        if (1 != this.Q) {
            if (this.f184310e.selectedPhotoList.size() <= 0) {
                z16 = false;
            }
            if (z16) {
                str = str + "(" + this.f184310e.selectedPhotoList.size() + ")";
            }
        } else if (this.f184310e.selectedPhotoList.size() < 3) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(PeakConstants.TAG, 2, "updateButton selectedPhotoList.size()=" + this.f184310e.selectedPhotoList.size());
        }
        Button button = this.f184313i.K;
        if (button != null) {
            button.setText(str);
            this.f184313i.K.setEnabled(z16);
        }
    }

    void T0(List<String> list, HashMap<String, LocalMediaInfo> hashMap) {
        if (list != null && hashMap != null && this.f184310e.allMediaInfoHashMap != null) {
            for (String str : list) {
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, this.f184310e.allMediaInfoHashMap.get(str));
                }
            }
        }
    }

    public int V0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        Iterator<Map.Entry<String, LocalMediaInfo>> it = this.f184310e.selectedMediaInfoHashMap.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (QAlbumUtil.getMediaType(it.next().getValue()) == 1) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public void X(boolean z16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), intent);
            return;
        }
        intent.putExtra(PeakConstants.FROM_QZONE, this.P);
        intent.putExtra("readSource", this.Z);
        intent.putExtra(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 3);
        boolean z17 = this.I;
        if (z17) {
            intent.putExtra(PeakConstants.FROM_SHUOSHUO, z17);
        }
        super.X(z16, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public String Y(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) localMediaInfo);
        }
        String Y = super.Y(localMediaInfo);
        long j3 = this.f184310e.maxSelectNum;
        if (localMediaInfo != null) {
            String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
            if (V0() <= 0 && (!this.C.f184293d || mimeType == null || !"video".equals(mimeType[0]))) {
                if (this.Q == 1) {
                    return this.D.getResources().getString(R.string.cu5, Long.valueOf(j3));
                }
                return Y;
            }
            if (V0() == j3 && this.C.f184293d && mimeType != null && "video".equals(mimeType[0])) {
                this.D.getResources().getString(R.string.w2o, Long.valueOf(j3));
            }
            if (this.W) {
                return this.D.getResources().getString(R.string.w2n, Long.valueOf(j3));
            }
            return this.D.getResources().getString(R.string.cu_, Long.valueOf(j3));
        }
        return Y;
    }

    protected void Z0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.postImmediately(new Runnable(str) { // from class: com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f184409d;

                {
                    this.f184409d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListCustomizationQzone.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).D != null && ((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).C.P != null && !((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).D.isFinishing()) {
                        Message obtain = Message.obtain();
                        obtain.what = 4;
                        String j3 = j.j(this.f184409d);
                        Bundle bundle = new Bundle();
                        bundle.putString("SRC_SAVE_PATH", this.f184409d);
                        bundle.putString("DES_SAVE_PATH", j3);
                        obtain.setData(bundle);
                        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                        j.d(localMediaInfo, j3);
                        com.tencent.mobileqq.activity.photo.album.photolist.e.f184289u.put(j3, localMediaInfo);
                        ((PhotoListCustomizationDefault) PhotoListCustomizationQzone.this).C.P.sendMessage(obtain);
                    }
                }
            }, null, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public boolean a(LocalMediaInfo localMediaInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, localMediaInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if (z16) {
            String[] mimeType = MimeHelper.getMimeType(localMediaInfo.mMimeType);
            if (this.C.f184293d && mimeType != null && "video".equals(mimeType[0]) && !com.tencent.mobileqq.utils.e.d(this.D, V0(), localMediaInfo, this.I)) {
                return false;
            }
        }
        boolean a16 = super.a(localMediaInfo, z16);
        if (a16) {
            if (z16) {
                this.S.put(localMediaInfo.path, Integer.valueOf(localMediaInfo.panoramaPhotoType));
            } else {
                this.S.remove(localMediaInfo.path);
            }
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void c(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view, i3);
            return;
        }
        if (!Utils.B()) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.h9v), 0).show();
        } else if (!this.I && !this.H) {
            this.D.dispatchTakePictureIntent();
        } else {
            W0();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.b
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (View) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        if (this.W) {
            LayoutInflater layoutInflater = (LayoutInflater) this.D.getSystemService("layout_inflater");
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.inflate(R.layout.f168928b82, (ViewGroup) null);
        }
        return super.d();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase
    public void g0(List<LocalMediaInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if ((this.I || this.H) && QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PANORAMA_PHOTO_CHECK, 1) != 0) {
            k1(list);
        } else {
            QLog.i("QQAlbum", 2, "@panoramatest isnot fromqzone");
        }
        super.g0(list);
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void i(SlideItemInfo slideItemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) slideItemInfo);
            return;
        }
        d dVar = this.f184313i.Q;
        if (dVar != null && slideItemInfo != null) {
            List<LocalMediaInfo> n06 = dVar.n0();
            int i3 = 0;
            while (true) {
                if (i3 < n06.size()) {
                    if (n06.get(i3).path.equals(slideItemInfo.f94291i)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                this.S.remove(dVar.m0(i3).path);
            }
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        if (dVar != null && slideItemInfo != null) {
            List<LocalMediaInfo> n07 = dVar.n0();
            int i16 = 0;
            while (true) {
                if (i16 < n07.size()) {
                    if (n07.get(i16).path.equals(slideItemInfo.f94291i)) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 >= 0 && i16 < n07.size()) {
                LocalMediaInfo m06 = dVar.m0(i16);
                m06.selectStatus = 2;
                String str = m06.path;
                String[] mimeType = MimeHelper.getMimeType(m06.mMimeType);
                if (this.C.f184293d && mimeType != null && "video".equals(mimeType[0])) {
                    g gVar = this.C;
                    int i17 = gVar.f184294e - 1;
                    gVar.f184294e = i17;
                    if (i17 == 1) {
                        gVar.f184296g = m06;
                    }
                }
                if (!TextUtils.isEmpty(m06.mMimeType) && "image/gif".equals(m06.mMimeType)) {
                    this.C.f184295f--;
                }
                this.f184310e.selectedPhotoList.remove(str);
                this.f184310e.selectedIndex.remove(m06.position);
                this.f184310e.selectedMediaInfoHashMap.remove(str);
                LinkedHashMap<String, Integer> linkedHashMap = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
                if (linkedHashMap != null) {
                    linkedHashMap.remove(str);
                }
                HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
                if (hashMap.containsKey(str)) {
                    hashMap.remove(str);
                }
                h0(false, m06);
                this.f184313i.u(i16, false);
                T();
                ((ISlideShowController) QRoute.api(ISlideShowController.class)).onItemsSelectChanged(arrayList, this.f184310e.allMediaInfoHashMap);
                return;
            }
            if (i16 == -1) {
                arrayList.remove(slideItemInfo.f94291i);
                this.f184310e.selectedMediaInfoHashMap.remove(slideItemInfo.f94291i);
                LinkedHashMap<String, Integer> linkedHashMap2 = QAlbumUtil.sSelectItemPosMap.get(this.f184310e.albumId);
                if (linkedHashMap2 != null) {
                    linkedHashMap2.remove(slideItemInfo.f94291i);
                }
                HashMap<String, Pair<String, String>> hashMap2 = QAlbumUtil.sSelectItemAlbum;
                if (hashMap2.containsKey(slideItemInfo.f94291i)) {
                    hashMap2.remove(slideItemInfo.f94291i);
                }
                this.f184313i.v();
                T();
                ((ISlideShowController) QRoute.api(ISlideShowController.class)).onItemsSelectChanged(arrayList, this.f184310e.allMediaInfoHashMap);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public Intent k(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Intent) iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, i3);
        }
        Intent k3 = super.k(view, i3);
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (this.I && !f184397g0) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            if (photoCommonBaseData.allMediaInfoHashMap != null) {
                if (this.Q == 1) {
                    k3.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", photoCommonBaseData.selectedPhotoList);
                } else {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    int i16 = i3 - 1;
                    int size = this.f184310e.mediaPathsList.size();
                    int i17 = i16;
                    int i18 = 0;
                    for (int i19 = 0; i19 < size; i19++) {
                        String str = this.f184310e.mediaPathsList.get(i19);
                        LocalMediaInfo localMediaInfo = this.f184310e.allMediaInfoHashMap.get(str);
                        if (QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                            arrayList.add(str);
                            ArrayList<String> arrayList3 = this.f184310e.selectedPhotoList;
                            if (arrayList3 != null && arrayList3.contains(str)) {
                                arrayList2.add(Integer.valueOf(i18));
                            }
                            if (localMediaInfo.position.intValue() == i16) {
                                i17 = i18;
                            }
                            i18++;
                        }
                    }
                    this.f184310e.mediaPathsList = arrayList;
                    k3.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
                    k3.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
                    k3.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, arrayList2);
                    if (QAlbumUtil.getMediaType(m06) == 0) {
                        k3.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, i17);
                    }
                }
            }
        }
        k3.putExtra(PeakConstants.FROM_QZONE, this.P);
        boolean z16 = this.I;
        if (z16) {
            k3.putExtra(PeakConstants.FROM_SHUOSHUO, z16);
        }
        return k3;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void l(View view, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, i3);
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (this.J && m06.mediaWidth > 0 && m06.mediaHeight > 0 && (i16 = this.V) > 0 && m06.fileSize > i16) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.f171172cw1, Integer.valueOf(this.V / 1048576)), 0).show(this.D.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else {
            super.l(view, i3);
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void n(int i3, int i16) {
        com.tencent.mobileqq.activity.photo.album.photolist.a aVar;
        NumberCheckBox numberCheckBox;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ArrayList<String> arrayList = this.f184310e.selectedPhotoList;
        d dVar = this.f184313i.Q;
        if (i3 >= 0 && i3 < arrayList.size() && i16 >= 0 && i16 < arrayList.size()) {
            Collections.swap(arrayList, i3, i16);
            int findFirstVisibleItemPosition = this.f184313i.I.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.f184313i.I.findLastVisibleItemPosition();
            for (int i17 = findFirstVisibleItemPosition; i17 <= findLastVisibleItemPosition; i17++) {
                LocalMediaInfo m06 = dVar.m0(i17);
                int indexOf = arrayList.indexOf(m06.path);
                if (indexOf >= 0 && (aVar = (com.tencent.mobileqq.activity.photo.album.photolist.a) this.f184313i.H.getChildAt(m06.position.intValue() - findFirstVisibleItemPosition).getTag()) != null && (numberCheckBox = aVar.J) != null) {
                    numberCheckBox.setCheckedNumber(indexOf + 1);
                }
            }
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).onItemsSelectChanged(arrayList, this.f184310e.allMediaInfoHashMap);
        }
        this.f184313i.t(true);
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.e
    public void o(String str) {
        LocalMediaInfo m06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
            return;
        }
        Intent intent = this.D.getIntent();
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        ArrayList<String> arrayList = photoCommonBaseData.selectedPhotoList;
        HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
        intent.putExtra(QAlbumConstants.ALBUM_NAME, photoCommonBaseData.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", arrayList);
        int size = arrayList.size();
        ArrayList<Integer> arrayList2 = new ArrayList<>(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList2.add(Integer.valueOf(i3));
        }
        intent.putIntegerArrayListExtra(QAlbumConstants.SELECTED_INDEXS, arrayList2);
        int indexOf = arrayList.indexOf(str);
        if (indexOf > 0 && indexOf < this.f184313i.Q.getNUM_BACKGOURND_ICON() && (m06 = this.f184313i.Q.m0(indexOf)) != null && !hashMap.containsKey(m06.path)) {
            hashMap.put(m06.path, m06);
        }
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap);
        intent.putExtra(QAlbumConstants.SHOW_ALBUM, false);
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        com.tencent.mobileqq.activity.photo.album.photolist.e.f184288t = this.f184313i.I.findFirstVisibleItemPosition();
        intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, arrayList.indexOf(str));
        intent.setClass(this.D, NewPhotoPreviewActivity.class);
        intent.addFlags(603979776);
        R(intent);
        QAlbumUtil.anim(this.D, true, true);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, i3);
            return;
        }
        if (!Utils.B()) {
            BasePhotoListActivity basePhotoListActivity = this.D;
            QQToast.makeText(basePhotoListActivity, basePhotoListActivity.getResources().getString(R.string.h9v), 0).show();
            return;
        }
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 == null) {
            return;
        }
        Intent intent = this.D.getIntent();
        String stringExtra = intent.getStringExtra("PhotoConst.PLUGIN_APK");
        String stringExtra2 = intent.getStringExtra(PeakConstants.VIDEO_REFER);
        if (!TextUtils.isEmpty(stringExtra2) && (stringExtra2.contains(PeakConstants.VIDEO_REFER_FROM_MOOD) || stringExtra2.contains(PeakConstants.VIDEO_REFER_FROM_ALBUM))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            long longExtra = intent.getLongExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION, Long.MAX_VALUE);
            if (m06.mDuration > longExtra) {
                QQToast.makeText(this.D, "\u8bf7\u9009\u62e9\u4e0d\u8d85\u8fc7" + ((longExtra / 60) / 1000) + "\u5206\u949f\u7684\u89c6\u9891", 0).show(this.D.getTitleBarHeight());
                return;
            }
            long videoCanUploadSize = QZoneHelper.getVideoCanUploadSize();
            if (m06.fileSize > videoCanUploadSize) {
                QQToast.makeText(this.D, "\u8bf7\u9009\u62e9\u4e0d\u8d85\u8fc7" + (((((float) videoCanUploadSize) / 1024.0f) / 1024.0f) / 1024.0f) + "G\u7684\u89c6\u9891", 0).show(this.D.getTitleBarHeight());
                return;
            }
        }
        if (!z16 && m06.fileSize > this.f184310e.filter.videoSizeLimit) {
            QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.D, "\u4f60\u9009\u62e9\u7684\u89c6\u9891\u6587\u4ef6\u8fc7\u5927\uff0c\u65e0\u6cd5\u53d1\u9001\u3002");
            createNoTitleDialog.setPositiveButton(R.string.f171151ok, new DialogUtil.DialogOnClickAdapter());
            createNoTitleDialog.show();
            return;
        }
        HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
        if (!hashMap.containsKey(m06.path)) {
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            hashMap.put(m06.path, new Pair<>(photoCommonBaseData.albumId, photoCommonBaseData.albumName));
        }
        this.f184313i.s(m06.path);
        if (QZoneVideoCommonUtils.REFER_SHORT_VIDEO_FOR_VIDEO_COVER.equals(stringExtra2) && m06.mDuration / 1000 > this.U / 1000) {
            String str = "\u89c6\u9891\u65f6\u95f4\u4e0d\u80fd\u8d85\u8fc7" + (this.U / 1000) + "s\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9";
            QQToast.makeText(this.D, str, 0).show(this.D.getTitleBarHeight());
            QLog.i("QQAlbum", 1, "QQToast:" + str);
            return;
        }
        if (i1(m06, intent, stringExtra)) {
            return;
        }
        g gVar = this.C;
        if (!gVar.f184243x) {
            s1(m06, intent);
            return;
        }
        if ((!this.H && !this.I && !this.K && !this.W) || (!gVar.f184293d && !this.N)) {
            Y0(m06, intent);
        } else {
            X0(i3, intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        if (this.W) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).onPhotoListDestroy();
        }
        super.r();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        super.t();
        if (this.W) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).onResume();
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).setPhotoListController();
        }
    }

    void t1() {
        List<SlideItemInfo> photoList = ((ISlideShowController) QRoute.api(ISlideShowController.class)).getPhotoList();
        if (this.C.L) {
            ((ISlideShowController) QRoute.api(ISlideShowController.class)).setTemp(photoList);
        }
        for (SlideItemInfo slideItemInfo : photoList) {
            if (slideItemInfo != null) {
                if (!this.f184310e.selectedPhotoList.contains(slideItemInfo.f94291i)) {
                    this.f184310e.selectedPhotoList.add(slideItemInfo.f94291i);
                }
                if (!this.f184310e.selectedIndex.contains(slideItemInfo.f94287d.position)) {
                    this.f184310e.selectedIndex.add(slideItemInfo.f94287d.position);
                }
                this.f184310e.selectedMediaInfoHashMap.put(slideItemInfo.f94291i, slideItemInfo.f94287d);
            }
        }
        if (this.f184310e.selectedPhotoList.size() > 0) {
            ISlideShowController iSlideShowController = (ISlideShowController) QRoute.api(ISlideShowController.class);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            iSlideShowController.onItemsSelectChanged(photoCommonBaseData.selectedPhotoList, photoCommonBaseData.allMediaInfoHashMap, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void u(Intent intent) {
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
            return;
        }
        if (this.L) {
            m1(intent);
        }
        if (this.P) {
            intent.putExtra(PeakConstants.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES, true);
            intent.putExtra(PeakConstants.RECENT_IMAGES_MAX_COUNT, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_MAX_RECENT_PHOTO_NUM, 200));
            intent.putExtra(PeakConstants.RECENT_IMAGES_LIMIT_SIZE, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_RECENT_PHOTO_LIMIT_SIZE, 20480));
            intent.putExtra(PeakConstants.RECENT_IMAGES_LIMIT_WIDTH, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_RECENT_PHOTO_LIMIT_WIDTH, 100));
            String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_RECENT_PHOTO_BLOCK_PATHS, QzoneConfig.RECENT_PHOTO_BLOCK_PATHS_DEFAULT);
            if (config != null) {
                arrayList = l1(config);
            } else {
                arrayList = null;
            }
            intent.putStringArrayListExtra(PeakConstants.RECENT_IMAGES_BLOCK_PATHS, arrayList);
            intent.putExtra(PeakConstants.FROM_QZONE, this.P);
        }
        super.u(intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void w0(View view, Bundle bundle, int i3, Intent intent) {
        Intent startEditPic;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, view, bundle, Integer.valueOf(i3), intent);
            return;
        }
        q1(view.getId());
        Intent intent2 = this.D.getIntent();
        if (this.f184310e.selectedPhotoList.size() > 0) {
            intent2.removeExtra(QAlbumConstants.PARAM_INITTIME);
            intent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
            intent2.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.f184310e.selectedPhotoList);
            intent2.putExtra(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 7);
            ReportController.o(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
            HashMap<String, Object> hashMap = new HashMap<>(1);
            PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
            HashMap<String, LocalMediaInfo> hashMap2 = photoCommonBaseData.selectedMediaInfoHashMap;
            if (hashMap2 != null && hashMap2.get(photoCommonBaseData.selectedPhotoList.get(0)) != null) {
                PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184310e;
                hashMap.put(AEEditorConstants.PARAM_LOCALMEDIAINFO, photoCommonBaseData2.selectedMediaInfoHashMap.get(photoCommonBaseData2.selectedPhotoList.get(0)));
            }
            if (R0()) {
                startEditPic = ((IEditPicForQzone) QRoute.api(IEditPicForQzone.class)).newPictureEditIntentWithoutPublish(this.D, this.f184310e.selectedPhotoList.get(0));
            } else {
                startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic((Activity) this.D, this.f184310e.selectedPhotoList.get(0), true, true, true, true, true, 3, 142, 5, hashMap);
            }
            this.D.startActivity(startEditPic);
            TextView textView = this.D.magicStickBtn;
            if (textView != null) {
                textView.setClickable(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a y(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (com.tencent.mobileqq.activity.photo.album.photolist.a) iPatchRedirector.redirect((short) 22, (Object) this, (Object) aVar, i3);
        }
        if (this.I || this.H) {
            n1(1);
        }
        return super.y(aVar, i3);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public com.tencent.mobileqq.activity.photo.album.photolist.a z(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (com.tencent.mobileqq.activity.photo.album.photolist.a) iPatchRedirector.redirect((short) 21, (Object) this, (Object) aVar, i3);
        }
        com.tencent.mobileqq.activity.photo.album.photolist.a z16 = super.z(aVar, i3);
        LocalMediaInfo m06 = this.f184313i.Q.m0(i3);
        if (m06 != null && ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isPanoramaPhoto(m06.panoramaPhotoType) && (this.I || this.H)) {
            aVar.E.setVisibility(0);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void z0(LocalMediaInfo localMediaInfo, int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) localMediaInfo, i3);
            return;
        }
        Intent intent = this.D.getIntent();
        if (!this.C.E && (z16 = this.I)) {
            intent.putExtra(PeakConstants.FROM_SHUOSHUO, z16);
        }
        super.z0(localMediaInfo, i3);
    }
}
