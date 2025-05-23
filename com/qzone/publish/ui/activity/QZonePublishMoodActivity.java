package com.qzone.publish.ui.activity;

import BOSSStrategyCenter.tAdvDesc;
import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_OPERATION.operation_forward_req;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import PROTO_EXT_TO_UGCSVR.Font;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.business.photogroupgrade.PhotoGroupOptimizeFuncSwitcher;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.activities.base.aj;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneAdvService;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.common.tool.ReportUtils;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.publish.ui.publishmodule.LBSModule;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.ar;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.AsyncMarkGifImageView;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.ExtendScrollView;
import com.qzone.widget.MoodPicLabel;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.qzone.widget.RedDotImageView;
import com.qzone.widget.UrlExtendEditText;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.qzone.widget.particle.ParticleManager;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.image.JpegExifReader;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkpublish.util.ImageQualityPreference;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Switch;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MediaUtil;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.util.RecentPhotoManger;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import cooperation.qzone.widget.QzoneEmotionUtils;
import e9.a;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes39.dex */
public class QZonePublishMoodActivity extends QZonePublishMoodBaseActivity implements View.OnClickListener, IQZoneServiceListener, com.qzone.publish.ui.controller.a {

    /* renamed from: x6, reason: collision with root package name */
    private static final String f51340x6 = "com.qzone.publish.ui.activity.QZonePublishMoodActivity";

    /* renamed from: y6, reason: collision with root package name */
    private static long f51341y6;

    /* renamed from: l6, reason: collision with root package name */
    private String f51345l6;

    /* renamed from: m6, reason: collision with root package name */
    private String f51346m6;

    /* renamed from: o6, reason: collision with root package name */
    private so.a f51348o6;

    /* renamed from: r6, reason: collision with root package name */
    ActionSheet f51351r6;

    /* renamed from: i6, reason: collision with root package name */
    public View.OnClickListener f51342i6 = new p();

    /* renamed from: j6, reason: collision with root package name */
    private BroadcastReceiver f51343j6 = null;

    /* renamed from: k6, reason: collision with root package name */
    CompoundButton.OnCheckedChangeListener f51344k6 = new ab();

    /* renamed from: n6, reason: collision with root package name */
    private TextWatcher f51347n6 = new l();

    /* renamed from: p6, reason: collision with root package name */
    private Animation.AnimationListener f51349p6 = new n();

    /* renamed from: q6, reason: collision with root package name */
    private Animation.AnimationListener f51350q6 = new o();

    /* renamed from: s6, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f51352s6 = new s();

    /* renamed from: t6, reason: collision with root package name */
    private boolean f51353t6 = false;

    /* renamed from: u6, reason: collision with root package name */
    private boolean f51354u6 = false;

    /* renamed from: v6, reason: collision with root package name */
    IQzoneShareApi.WXShareListener f51355v6 = new x();

    /* renamed from: w6, reason: collision with root package name */
    public View.OnClickListener f51356w6 = new y();

    /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodActivity$50, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass50 implements Runnable {
        final /* synthetic */ QZonePublishMoodActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.lq();
        }
    }

    /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodActivity$6, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f51391d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f51392e;
        final /* synthetic */ QZonePublishMoodActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f51391d;
            if (view != null && this.f51392e) {
                view.setOnClickListener(this.this$0);
            } else if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodActivity$8, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass8 extends QZoneAlbumUtil.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51400d;

        AnonymousClass8(String str) {
            this.f51400d = str;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
            if (QZonePublishMoodActivity.this.isFinishing()) {
                return;
            }
            QZonePublishMoodActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.8.1

                /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodActivity$8$1$a */
                /* loaded from: classes39.dex */
                class a implements View.OnClickListener {
                    a() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        QZoneHelper.forwardToBrowser(QZonePublishMoodActivity.this.getActivity(), AnonymousClass8.this.f51400d, -1, null, null);
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView = (ImageView) QZonePublishMoodActivity.this.$(R.id.heg);
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    imageView.setOnClickListener(new a());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!QZonePublishMoodActivity.this.Lo() && z16) {
                QZonePublishMoodActivity.this.G4.setChecked(false);
                QZonePublishMoodActivity.this.mq();
            } else {
                QZonePublishMoodActivity.this.H4 = z16;
                if (z16) {
                    try {
                        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_PRESET, "medium");
                        ActivityManager activityManager = (ActivityManager) QZonePublishMoodActivity.this.getActivity().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        int g16 = ag.g(config, true);
                        if (memoryInfo.availMem < g16) {
                            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastLessMemoryToTrim", "\u5f53\u524d\u53ef\u7528\u5185\u5b58\u8fc7\u5c11\uff0c\u53ef\u80fd\u5f71\u54cd\u88c1\u526a\u64cd\u4f5c"));
                        }
                        if (QZLog.isColorLevel()) {
                            QZLog.d(QZonePublishMoodActivity.f51340x6, 2, "availMem=" + memoryInfo.availMem + ", threshold=" + memoryInfo.threshold + ", lowMem=" + memoryInfo.lowMemory + ", minRam=" + g16 + ", preset=" + config);
                        }
                    } catch (Exception e16) {
                        QZLog.w(e16);
                    }
                }
            }
            for (int i3 = 0; i3 < QZonePublishMoodActivity.this.U.size(); i3++) {
                QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                ShuoshuoVideoInfo shuoshuoVideoInfo = qZonePublishMoodActivity.X.get(qZonePublishMoodActivity.U.get(i3));
                if (shuoshuoVideoInfo == null) {
                    QZonePublishMoodActivity qZonePublishMoodActivity2 = QZonePublishMoodActivity.this;
                    shuoshuoVideoInfo = qZonePublishMoodActivity2.Z.get(qZonePublishMoodActivity2.U.get(i3));
                }
                if (shuoshuoVideoInfo != null) {
                    ag.C(shuoshuoVideoInfo, QZonePublishMoodActivity.this.G4.isChecked());
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class aa implements View.OnClickListener {
        aa() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishMoodActivity.this.simpleClassname, view);
            QZonePublishMoodActivity.this.fk(false);
            Intent intent = new Intent();
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.M());
            Activity realActivity = QZonePublishMoodActivity.this.getRealActivity();
            if (realActivity instanceof BasePluginActivity) {
                realActivity = ((BasePluginActivity) realActivity).getOutActivity();
            }
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(realActivity, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
            LpReportInfo_pf00064.allReport(586, 31);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class ab implements CompoundButton.OnCheckedChangeListener {
        ab() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (compoundButton.getId() == R.id.m7u) {
                if (z16) {
                    if (QZonePublishMoodActivity.this.rl()) {
                        QZonePublishMoodActivity.this.T.notifyDataSetChanged();
                        ToastUtil.s(QZonePublishMoodActivity.this.getResources().getString(R.string.ivf), 4);
                    }
                    QZonePublishMoodActivity.this.S1 = 1;
                    LpReportInfo_pf00064.allReport(586, 47, 2);
                } else {
                    QZonePublishMoodActivity.this.S1 = 0;
                }
                QZonePublishMoodActivity.this.Km();
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class ac implements View.OnClickListener {
        ac() {
        }

        private void a() {
            Intent qZoneVideoDownloadActivityIntent = QZoneHelper.getQZoneVideoDownloadActivityIntent(QZonePublishMoodActivity.this.getActivity().getApplicationContext());
            qZoneVideoDownloadActivityIntent.putExtra("video_type", QZonePublishMoodActivity.this.I4.mVideoType);
            qZoneVideoDownloadActivityIntent.putExtra("file_send_path", QZonePublishMoodActivity.this.I4.mVideoPath);
            qZoneVideoDownloadActivityIntent.putExtra("preview_video", true);
            qZoneVideoDownloadActivityIntent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, QZonePublishMoodActivity.this.I4.mExtras);
            qZoneVideoDownloadActivityIntent.putExtra(PeakConstants.VIDEO_REFER, PeakConstants.VIDEO_REFER_FROM_MOOD);
            QZonePublishMoodActivity.this.startActivity(qZoneVideoDownloadActivityIntent);
        }

        private void b() {
            Intent P = ak.P(QZonePublishMoodActivity.this.getActivity().getApplicationContext());
            P.putExtra("video_type", QZonePublishMoodActivity.this.I4.mVideoType);
            P.putExtra("video_source_path", QZonePublishMoodActivity.this.I4.mVideoPath);
            P.putExtra("start_time", QZonePublishMoodActivity.this.I4.mStartTime);
            P.putExtra("end_time", QZonePublishMoodActivity.this.I4.mEndTime);
            QZonePublishMoodActivity.this.startActivity(P);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object obj;
            EventCollector.getInstance().onViewClickedBefore(view);
            ShuoshuoVideoInfo shuoshuoVideoInfo = QZonePublishMoodActivity.this.I4;
            if (shuoshuoVideoInfo != null && !FileUtils.fileExists(shuoshuoVideoInfo.mVideoPath)) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFileNotExist", ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC), 4);
            } else {
                ShuoshuoVideoInfo shuoshuoVideoInfo2 = QZonePublishMoodActivity.this.I4;
                if (shuoshuoVideoInfo2 != null && shuoshuoVideoInfo2.mVideoType == 0) {
                    a();
                } else if (shuoshuoVideoInfo2 == null || 1 != shuoshuoVideoInfo2.mVideoType) {
                    String str = QZonePublishMoodActivity.f51340x6;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("goto preview, video type error, type=");
                    ShuoshuoVideoInfo shuoshuoVideoInfo3 = QZonePublishMoodActivity.this.I4;
                    if (shuoshuoVideoInfo3 != null) {
                        obj = Integer.valueOf(shuoshuoVideoInfo3.mVideoType);
                    } else {
                        obj = "";
                    }
                    sb5.append(obj);
                    QZLog.w(str, sb5.toString());
                } else if (!QZoneVideoCommonUtils.getTrimSupport().isAvailable()) {
                    com.qzone.common.business.service.b.f().w(QZonePublishMoodActivity.this.getActivity(), QZonePublishMoodActivity.this.I4);
                } else {
                    b();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePublishMoodActivity.this.Lo()) {
                QZonePublishMoodActivity.this.Ip("jhan_shipin");
                ClickReport.e(311, "publishmood", ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, 1, 2);
            } else {
                QZonePublishMoodActivity.this.Ip("jhan_shipin");
                ClickReport.e(311, "publishmood", ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, 1, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (QZonePublishMoodActivity.this.T.d0(i3) && QZonePublishMoodActivity.this.T.H(view)) {
                QZonePublishMoodActivity.this.Cp();
                return;
            }
            Intent intent = QZonePublishMoodActivity.this.getIntent();
            int intExtra = intent != null ? intent.getIntExtra("key_photo_oprate_type", 1) : 1;
            QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
            if (1 == qZonePublishMoodActivity.S1) {
                intExtra = 4;
            }
            qZonePublishMoodActivity.Wk(qZonePublishMoodActivity.P, i3, qZonePublishMoodActivity.oj(), intExtra, ((PhotoActivity) QZonePublishMoodActivity.this).f45144z1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
            qZonePublishMoodActivity.Wk(qZonePublishMoodActivity.P, 0, qZonePublishMoodActivity.oj(), 4, ((PhotoActivity) QZonePublishMoodActivity.this).f45144z1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e extends a.i {
        e() {
        }

        @Override // e9.a.i
        public boolean a() {
            if (QZonePublishMoodActivity.this.T.U() < com.qzone.publish.ui.model.b.f51929c) {
                QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                if (!qZonePublishMoodActivity.I0 && !qZonePublishMoodActivity.pk()) {
                    return true;
                }
            }
            return false;
        }

        @Override // e9.a.i
        public boolean b() {
            if (!QZonePermission.requestStoragePermission(QZonePublishMoodActivity.this.getActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
                return false;
            }
            QZonePublishMoodActivity.this.Cp();
            return true;
        }

        @Override // e9.a.i
        public boolean c(int i3) {
            if (((PhotoActivity) QZonePublishMoodActivity.this).f45139x0) {
                QZonePublishMoodActivity.this.hq(i3);
                ((PhotoActivity) QZonePublishMoodActivity.this).f45139x0 = false;
                return true;
            }
            QZonePublishMoodActivity.this.Oo(i3);
            return true;
        }

        @Override // e9.a.i
        public void d() {
            QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
            ExtendScrollView extendScrollView = qZonePublishMoodActivity.M;
            if (extendScrollView != null) {
                extendScrollView.e(qZonePublishMoodActivity.P.getId());
            }
        }

        @Override // e9.a.i
        public void e() {
            QZonePublishMoodActivity.this.ui();
        }

        @Override // e9.a.i
        public boolean f(View view) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements DynamicGridView.s {
        g() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void a(int i3, int i16) {
            QZonePublishMoodActivity.this.Zk(i3, i16);
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void b(int i3, int i16) {
            if (i16 == 0) {
                ClickReport.m("46", "5", "1");
            } else if (i16 == 1) {
                ClickReport.m("46", "5", "3");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
            ExtendEditText extendEditText = qZonePublishMoodActivity.f45104j0;
            if (extendEditText != null) {
                qZonePublishMoodActivity.S4.setTextDraft(extendEditText.getText().toString());
            }
            QZonePublishMoodActivity qZonePublishMoodActivity2 = QZonePublishMoodActivity.this;
            qZonePublishMoodActivity2.S4.setmPriv(qZonePublishMoodActivity2.k3);
            QZonePublishMoodActivity qZonePublishMoodActivity3 = QZonePublishMoodActivity.this;
            qZonePublishMoodActivity3.S4.setmPrivUinList(qZonePublishMoodActivity3.l3);
            u5.b.N0(QZonePublishMoodActivity.this.S4, QZonePublishMoodActivity.this.Y2.g());
            QZonePublishMoodActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements UrlExtendEditText.a {
        i() {
        }

        @Override // com.qzone.widget.UrlExtendEditText.a
        public void a(String str, int i3, int i16) {
            QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
            if (!qZonePublishMoodActivity.Pi(qZonePublishMoodActivity.f45104j0.getText(), i3, i16)) {
                if (QZonePublishMoodActivity.this.oj().isEmpty()) {
                    QZoneWriteOperationService.v0().B0(null, str);
                    return;
                }
                return;
            }
            ((UrlExtendEditText) QZonePublishMoodActivity.this.f45104j0).setUrlState(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f51417d;

        j(int i3) {
            this.f51417d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZonePublishMoodActivity.this.Oo(this.f51417d);
        }
    }

    /* loaded from: classes39.dex */
    class k extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f51419a;

        k(Intent intent) {
            this.f51419a = intent;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QZLog.e(QZonePublishMoodActivity.f51340x6, "requestStoragePermission grant");
            QZonePublishMoodActivity.this.No(this.f51419a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QZLog.e(QZonePublishMoodActivity.f51340x6, "requestStoragePermission deny");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class m implements DialogInterface.OnClickListener {
        m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZonePublishMoodActivity.this.Ip("an_yuanshipin");
        }
    }

    /* loaded from: classes39.dex */
    class n extends AnimateUtils.AnimationAdapter {
        n() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZonePublishMoodActivity.this.Qo();
        }
    }

    /* loaded from: classes39.dex */
    class o extends AnimateUtils.AnimationAdapter {
        o() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZonePublishMoodActivity.this.Po();
        }
    }

    /* loaded from: classes39.dex */
    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishMoodActivity.this.simpleClassname, view);
            com.qzone.misc.network.report.b.c(QZonePublishMoodActivity.this.U4);
            QZonePublishMoodActivity.this.onBack();
            QZonePublishMoodActivity.this.fn();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class q implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51426d;

        q(String str) {
            this.f51426d = str;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QZonePublishMoodActivity.this.simpleClassname + " QQCustomDialog click :" + this.f51426d);
            QZonePublishMoodActivity.this.f51351r6.dismiss();
            QZonePublishMoodActivity.this.Yp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class r implements ActionSheet.OnDismissListener {
        r() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QZonePublishMoodActivity.this.simpleClassname + " QQCustomDialog click :\u53d6\u6d88");
            QZonePublishMoodActivity.this.gm(true);
        }
    }

    /* loaded from: classes39.dex */
    class s implements CompoundButton.OnCheckedChangeListener {
        s() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[Actvity]");
            sb5.append(QZonePublishMoodActivity.this.simpleClassname);
            if (compoundButton != null) {
                sb5.append(" click  view id:");
                sb5.append(Integer.toHexString(compoundButton.getId()));
            }
            sb5.append(" isChecked:");
            sb5.append(z16);
            RDMEtraMsgCollector.getInstance().addUserAction(sb5.toString());
            if (!z16) {
                QZonePublishMoodActivity.this.Tp(0);
            } else {
                com.qzone.misc.network.report.b.o(QZonePublishMoodActivity.this.U4);
                QZonePublishMoodActivity.this.Tp(2);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class t implements DialogInterface.OnClickListener {
        t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
            qZonePublishMoodActivity.k3 = 1;
            qZonePublishMoodActivity.Yp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class u implements DialogInterface.OnClickListener {
        u() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZonePublishMoodActivity.this.Yp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class w extends BroadcastReceiver {
        w() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("gamemates");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                ArrayList<ResultRecord> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray(stringExtra);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String optString = jSONObject.optString("uin");
                    String optString2 = jSONObject.optString("nickname");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        ResultRecord resultRecord = new ResultRecord();
                        resultRecord.name = optString2;
                        resultRecord.uin = optString;
                        arrayList.add(resultRecord);
                    }
                }
                if (arrayList.size() > 0) {
                    QZonePublishMoodActivity.this.Xh(arrayList);
                }
            } catch (Exception e16) {
                QZLog.e(QZonePublishMoodActivity.f51340x6, 1, e16, new Object[0]);
            }
        }
    }

    /* loaded from: classes39.dex */
    class x implements IQzoneShareApi.WXShareListener {
        x() {
        }

        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            int i3 = baseResp.errCode;
            if (i3 == 0) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShared", "\u5df2\u5206\u4eab"), 5);
            } else if (i3 != -2) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShareFail", ShareJsPlugin.ERRMSG_INVITE_REQUIRE), 4);
            }
        }
    }

    /* loaded from: classes39.dex */
    class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePublishMoodActivity.this.fm(view);
            QZonePublishMoodActivity.this.gm(false);
            if (QZonePublishMoodActivity.this.F1) {
                LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("84", "4"), false, false);
            }
            QZonePublishMoodActivity.this.f51459f6 = UUID.randomUUID().toString();
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(586, 3, QZonePublishMoodActivity.this.Zm());
            lpReportInfo_pf00064.reserves3 = QZonePublishMoodActivity.this.f51459f6;
            String str3 = "1";
            if (com.qzone.business.tianshu.c.j().t()) {
                lpReportInfo_pf00064.reserves4 = "1";
            } else {
                lpReportInfo_pf00064.reserves4 = "0";
            }
            if (QZonePublishMoodActivity.this.Zm() == 9) {
                if (QzoneFrame.isNewConciseFragment()) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                lpReportInfo_pf00064.reserves8 = str2;
                if (!QQTheme.isNowSimpleUI()) {
                    str3 = "0";
                }
                lpReportInfo_pf00064.reserves9 = str3;
            } else {
                CheckBox checkBox = QZonePublishMoodActivity.this.J2;
                if (checkBox != null && checkBox.isChecked()) {
                    str = "1";
                } else {
                    str = "0";
                }
                lpReportInfo_pf00064.reserves7 = str;
                if (!QZonePublishMoodActivity.this.an().d()) {
                    str3 = "0";
                }
                lpReportInfo_pf00064.reserves8 = str3;
            }
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
            if (QZonePublishMoodActivity.this.getActivity() != null && QZonePublishMoodActivity.this.getActivity().getIntent() != null) {
                com.qzone.misc.network.report.b.i(QZonePublishMoodActivity.this.getActivity().getIntent(), 2);
            }
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishMoodActivity.this.simpleClassname, view);
            if (QZonePublishMoodActivity.this.Ui() <= QZonePublishMoodActivity.this.ej()) {
                QZonePublishMoodActivity.this.Ko();
            } else {
                QZonePublishMoodActivity.this.toast(R.string.f173054gr0);
            }
            CheckBox checkBox2 = QZonePublishMoodActivity.this.J2;
            if (checkBox2 != null && checkBox2.isChecked()) {
                QZonePublishMoodActivity.this.vn();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class z implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51436d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f51437e;

        z(String str, String str2) {
            this.f51436d = str;
            this.f51437e = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (System.currentTimeMillis() - QZonePublishMoodActivity.f51341y6 >= 1000) {
                QZonePublishMoodActivity.f51341y6 = System.currentTimeMillis();
                QZonePublishMoodActivity.this.lp();
                String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_PICK_GAME_MATES, "https://s.gamecenter.qq.com/gc/social-node/pick-mates.html?hulian_extra_scene={hulian_extra_scene}&appid={appid}&openid={openid}").replace("{hulian_extra_scene}", URLEncoder.encode(this.f51436d)).replace("{appid}", QZonePublishMoodActivity.this.f45117n1).replace("{openid}", this.f51437e);
                yo.d.b(QZonePublishMoodActivity.this.getRealActivity(), new yo.g(replace));
                LpReportInfo_pf00064.report(122, 7, 2, QZonePublishMoodActivity.this.f45117n1);
                if (QZLog.isColorLevel()) {
                    QZLog.e(QZonePublishMoodActivity.f51340x6, "pickgamemates:" + replace);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void Ap(Bundle bundle) {
        String string = bundle.getString("logo_pic");
        String string2 = bundle.getString("trace_info");
        if (!TextUtils.isEmpty(string)) {
            this.f51455e5 = true;
            if (this.f51448c5 == null) {
                this.f51448c5 = (AsyncImageView) findViewById(R.id.ito);
            }
            this.f51448c5.setAsyncImage(string);
            if (!TextUtils.isEmpty(string2)) {
                this.f51452d5 = string2;
            }
            Up(string, string2);
            if (this.f51464h5 && !TextUtils.isEmpty(string2)) {
                Op();
                this.f51464h5 = false;
            }
        }
        QZLog.d(f51340x6, 1, "makeShuoshuoAdShow logoUrl:" + string + " traceInfo:" + string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co(RelativeLayout relativeLayout) {
        if (this.f51485t5 != null) {
            this.f51482s5 = new ImageView(getActivity());
            Drawable loadImage = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_2FkI4iOAWN.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.59
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    QZonePublishMoodActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.59.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageView imageView = QZonePublishMoodActivity.this.f51482s5;
                            if (imageView != null) {
                                imageView.setImageDrawable(drawable);
                            }
                        }
                    });
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                }
            }, (ImageLoader.Options) null);
            if (loadImage != null) {
                this.f51482s5.setImageDrawable(loadImage);
            }
            relativeLayout.addView(this.f51482s5, new RelativeLayout.LayoutParams(ar.e(116.0f), ar.e(43.0f)));
            this.f51482s5.setVisibility(8);
        }
    }

    private void Cq() {
        CheckBox checkBox;
        this.C2.setChecked(this.f51478r3);
        CheckBox checkBox2 = this.G2;
        if (checkBox2 != null) {
            checkBox2.setChecked(this.f51481s3);
        }
        if (!this.Y4 || (checkBox = this.J2) == null) {
            return;
        }
        checkBox.setChecked(this.f51444b4);
    }

    private void Dq(long j3, int i3) {
        if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin()) & 33554432) != 0) {
            this.f51444b4 = u5.b.D(Vo("wezone_last_selected", j3), false);
        } else {
            this.f51444b4 = (i3 & 64) != 0;
        }
    }

    private void Eo(Intent intent) {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null) {
            if (extendEditText.getEditableText() != null) {
                this.f45129s0 = this.f45104j0.getEditableText().toString();
            }
            this.f45104j0.addTextChangedListener(this.f51347n6);
        }
        if (QZoneHelper.Constants.INTENT_ACTION_QZONE_OPEN_SHARE.equalsIgnoreCase(intent.getAction())) {
            this.Z4 = true;
            View view = this.F2;
            if (view != null) {
                this.f51481s3 = false;
                view.setVisibility(8);
            }
            this.f45111l1 = 206;
            String stringExtra = intent.getStringExtra(QZoneHelper.Constants.KEY_FILE_PATH);
            Kp(stringExtra);
            QZLog.d(f51340x6, 2, "parseIntent videoPath:" + stringExtra);
        }
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || aVar.v() == null) {
            return;
        }
        this.C.v().setTextSize(17.0f);
    }

    private void Ep(final boolean z16) {
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.51
            @Override // java.lang.Runnable
            public void run() {
                if (((PhotoActivity) QZonePublishMoodActivity.this).f45101i0 != null) {
                    if (z16) {
                        QZonePublishMoodActivity.this.showKeyboard();
                        return;
                    }
                    QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                    if (qZonePublishMoodActivity.f45104j0 != null) {
                        ((PhotoActivity) qZonePublishMoodActivity).f45101i0.hideSoftInputFromWindow(QZonePublishMoodActivity.this.f45104j0.getWindowToken(), 0);
                    }
                }
            }
        }, 300L);
    }

    private void Fp(final PicInfo picInfo) {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.u().setEnabled(false);
        }
        final String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastChoosePicFailForNetWork", "\u56fe\u7247\u9009\u62e9\u5931\u8d25\uff0c\u7f51\u7edc\u9519\u8bef");
        ImageLoader.getInstance().downloadImageOnly(picInfo.pic_url, new ImageLoader.ImageDownloadListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.46
            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadCanceled(String str) {
                com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodActivity.this.C;
                if (aVar2 != null) {
                    aVar2.u().setEnabled(false);
                }
                ToastUtil.r(config);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadFailed(String str) {
                com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodActivity.this.C;
                if (aVar2 != null) {
                    aVar2.u().setEnabled(false);
                }
                ToastUtil.r(config);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadProgress(String str, long j3, final float f16) {
                QZonePublishMoodActivity.this.getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.46.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodActivity.this.C;
                        if (aVar2 != null) {
                            aVar2.u().setText("" + (f16 * 100.0f) + "%");
                        }
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadSucceed(final String str) {
                QZonePublishMoodActivity.this.getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.46.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodActivity.this.C;
                        if (aVar2 != null) {
                            aVar2.u().setEnabled(true);
                        }
                        QZLog.d(QZonePublishMoodActivity.f51340x6, 4, "download succeed, " + str);
                        if (QZonePublishMoodActivity.this.fi(str)) {
                            e9.a aVar3 = QZonePublishMoodActivity.this.T;
                            if (aVar3 != null) {
                                aVar3.notifyDataSetChanged();
                            }
                            AnonymousClass46 anonymousClass46 = AnonymousClass46.this;
                            HashMap<String, PicInfo> hashMap = QZonePublishMoodActivity.this.f51486u2;
                            PicInfo picInfo2 = picInfo;
                            hashMap.put(picInfo2.pic_url, picInfo2);
                        }
                    }
                });
            }
        });
    }

    private void Gp() {
        com.qzone.publish.ui.model.e eVar = this.L4;
        String str = eVar != null ? eVar.f51976b : null;
        final String str2 = eVar != null ? eVar.f51978d : null;
        if (str != null && str.length() > 0 && getActivity() != null) {
            try {
                yo.d.d(str, getActivity(), null);
                QZLog.i(f51340x6, 1, "click tips view,handle scheme:" + str);
            } catch (Throwable th5) {
                QZLog.w(f51340x6, "click tips view,exception handle scheme:" + str, th5);
            }
        } else {
            this.D4.setVisibility(8);
            com.qzone.publish.ui.model.e eVar2 = this.L4;
            if (eVar2 != null) {
                eVar2.a();
            }
            QZLog.i(f51340x6, 1, "click tips view,set invisible");
        }
        if (str2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.49
                @Override // java.lang.Runnable
                public void run() {
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str2, null);
                }
            });
        }
    }

    private boolean Ho() {
        if (this.f51489v5 == null || this.k3 == 1 || this.f51353t6) {
            return false;
        }
        this.f51353t6 = true;
        long j3 = LocalMultiProcConfig.getLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_EVENTTAG_MODIFYPRIV_COUNT, 0L);
        if (j3 >= 3) {
            return false;
        }
        long j16 = LocalMultiProcConfig.getLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_EVENTTAG_MODIFYPRIV_DATE, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= j16 + 86400000) {
            return false;
        }
        LocalMultiProcConfig.putLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_EVENTTAG_MODIFYPRIV_COUNT, j3 + 1);
        LocalMultiProcConfig.putLong(QZoneHelper.QzoneSharePrefrenceConstants.KEY_EVENTTAG_MODIFYPRIV_DATE, currentTimeMillis);
        jq();
        return true;
    }

    private void Hp(Intent intent) {
        if (this.f51486u2 == null) {
            this.f51486u2 = new HashMap<>();
        }
        PicInfo picInfo = new PicInfo();
        picInfo.picwidth = intent.getIntExtra("mood_web_pic_width", 500);
        picInfo.picheight = intent.getIntExtra("mood_web_pic_height", 300);
        picInfo.pic_url = intent.getStringExtra("mood_web_pic_url");
        picInfo.sourceType = 2;
        int intExtra = intent.getIntExtra("mood_web_pic_sourceid", -1);
        if (this.M1 && !picInfo.pic_url.startsWith("http://qzs.qq.com") && !picInfo.pic_url.startsWith("https://qzs.qq.com")) {
            Fp(picInfo);
        } else if (fi(picInfo.pic_url)) {
            e9.a aVar = this.T;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            this.f51486u2.put(picInfo.pic_url, picInfo);
        }
        this.f51446b6.put(picInfo.pic_url, new Pair<>(Wi(), String.valueOf(intExtra)));
        this.J1.H(false, this.P, this.T, null, getActivity());
        if (QZLog.isColorLevel()) {
            QZLog.d(f51340x6, 2, "onWebPicSelected:", picInfo.pic_url, ",entryid:", Wi(), ",source_id:", Integer.valueOf(intExtra));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io(String str) {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.A2.entrySet()) {
            if (str.contains(entry.getKey())) {
                sb5.append(entry.getValue() + "_");
            }
        }
        if (sb5.length() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(VRReportDefine$ReportParam.SCENE_TYPE, sb5.substring(0, sb5.length() - 1));
        if (QZLog.isColorLevel()) {
            QZLog.i(f51340x6, 2, "scene_type: " + sb5.substring(0, sb5.length() - 1));
        }
        com.qzone.business.plusunion.business.a.h().t(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip(String str) {
        ak.Q(getActivity(), ak.r(getActivity(), str, getResources().getString(R.string.gln), false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 999);
    }

    private void Jo() {
        if (u5.b.D(QZoneHelper.QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG, false)) {
            u5.b.o0(QZoneHelper.QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG, false);
            fl();
        }
    }

    private HashMap<String, String> Jp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.substring(str.lastIndexOf("#") + 1).split(ContainerUtils.FIELD_DELIMITER);
        if (split != null) {
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    private void Kp(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final long c16 = ag.c(str);
        final long m3 = com.tencent.mobileqq.filemanager.util.q.m(str);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.55
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    QZonePublishMoodActivity.this.Z4 = false;
                    ToastUtil.o(R.string.glj, 4);
                } else {
                    if (!new File(str).exists()) {
                        QZonePublishMoodActivity.this.Z4 = false;
                        ToastUtil.o(R.string.glj, 4);
                        return;
                    }
                    QZonePublishMoodActivity.this.I4 = ag.q(str, m3, 1, null, 0, 0, 0L, c16, c16, false, null);
                    QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                    qZonePublishMoodActivity.f45084c1 = true;
                    qZonePublishMoodActivity.f45096g1 = str;
                    qZonePublishMoodActivity.Gn(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lo() {
        return LoginData.getInstance().isQzoneVip();
    }

    private void Mo() {
        String j3;
        Bundle bundle = new Bundle();
        bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, this.k3);
        ArrayList<String> arrayList = this.l3;
        if (arrayList != null && arrayList.size() > 0) {
            bundle.putStringArrayList("uin_list", this.l3);
            ArrayList<String> arrayList2 = new ArrayList<>(this.l3.size());
            Iterator<String> it = this.l3.iterator();
            while (it.hasNext()) {
                arrayList2.add(s8.f.f().g(it.next()));
            }
            bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
        }
        if (com.qzone.feed.utils.h.h(this.k3) && !TextUtils.isEmpty(this.m3)) {
            bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.m3);
        }
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, "https://h5.qzone.qq.com/ugc/setting?_wv=3&type={type}&uin={uin}&qua={qua}");
        if (this.F1) {
            j3 = yo.f.j(config, "{type}", "nuanshuoshuo");
        } else {
            j3 = yo.f.j(config, "{type}", "mood");
        }
        yo.d.k(getActivity(), j3, com.qzone.publish.ui.model.b.f51928b, bundle, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void No(Intent intent) {
        PerfTracer.trace(PerfTracer.PUBLISHMOOD_INITUI, PerfTracer.PUBLISHMOOD_INITDATA);
        initData(intent);
        PerfTracer.traceEnd(PerfTracer.PUBLISHMOOD_INITDATA);
        Eo(intent);
        PerfTracer.traceEnd(PerfTracer.PUBLISHMOOD_ONCREATE);
    }

    private void Np(String str, boolean z16) {
        String str2;
        ro.a aVar = this.U4;
        String str3 = QzoneVideoBeaconReport.DEFULALT_REFER;
        if (aVar != null) {
            String b16 = aVar.b();
            if (!TextUtils.isEmpty(b16)) {
                str3 = b16;
            }
        }
        if (z16) {
            if (!this.f51491w5 && !this.f51494x5) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), str, str3, str2);
            return;
        }
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), str, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oo(int i3) {
        ClickReport.m("46", "5", "2");
        final String str = (oj() == null || i3 >= oj().size()) ? null : oj().get(i3);
        Yk(i3);
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap != null && hashMap.size() > 0) {
                this.Z.remove(str);
            }
            HashMap<String, MarkUinInfoBeforeUpload> hashMap2 = this.U1;
            if (hashMap2 != null && hashMap2.containsKey(str)) {
                this.U1.remove(str);
            }
            HashMap<String, Boolean> hashMap3 = this.V1;
            if (hashMap3 != null && hashMap3.containsKey(str)) {
                this.V1.remove(str);
            }
            HashMap<String, ArrayList<FaceData>> hashMap4 = this.X1;
            if (hashMap4 != null && hashMap4.containsKey(str)) {
                this.X1.remove(str);
            }
            HashMap<String, Boolean> hashMap5 = this.W1;
            if (hashMap5 != null && hashMap5.containsKey(str)) {
                this.W1.remove(str);
            }
        }
        this.P.n1(i3, new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.20
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && ((PhotoActivity) QZonePublishMoodActivity.this).A0 != null && ((PhotoActivity) QZonePublishMoodActivity.this).A0.size() > 0) {
                    ((PhotoActivity) QZonePublishMoodActivity.this).A0.remove(str);
                }
                if (QZonePublishMoodActivity.this.oj() != null && QZonePublishMoodActivity.this.oj().size() < QZonePublishMoodActivity.this.dj()) {
                    QZonePublishMoodActivity.this.T.o0(true, true);
                }
                QZonePublishMoodActivity.this.ui();
                QZonePublishMoodActivity.this.Mp();
                QZonePublishMoodActivity.this.Im();
            }
        });
    }

    private void Op() {
        if (this.f51458f5 || oj().size() <= 0 || TextUtils.isEmpty(this.f51452d5) || !Wp(oj())) {
            return;
        }
        this.f51458f5 = true;
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.f51452d5, LoginData.getInstance().getUinString());
        QZLog.i(f51340x6, "reportExposeAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        ImageView imageView = this.f51482s5;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.f51482s5 = null;
        }
        RedDotImageView redDotImageView = this.f45116n0;
        if (redDotImageView != null) {
            redDotImageView.setVisibility(8);
        }
        this.f51485t5 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qo() {
        ImageView imageView = this.f51487u5;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.f51487u5 = null;
        }
        RedDotImageView redDotImageView = this.f45116n0;
        if (redDotImageView != null) {
            redDotImageView.setVisibility(8);
        }
    }

    private void Qp() {
        if (this.f51461g5 == null) {
            this.f51461g5 = PreferenceManager.getCachePreference(BaseApplication.getContext(), LoginData.getInstance().getUin());
        }
        if (this.f51448c5 == null) {
            this.f51448c5 = (AsyncImageView) findViewById(R.id.ito);
        }
        String string = this.f51461g5.getString(LoginData.getInstance().getUin() + "SP_SHUOSHUO_PIC_KEY", "");
        if (!TextUtils.isEmpty(string)) {
            QZLog.d(f51340x6, 1, "restoreShuoshuoPicShow picUrl:" + string);
            this.f51448c5.setAsyncImage(string);
        }
        this.f51452d5 = this.f51461g5.getString(LoginData.getInstance().getUin() + "SP_SHUOSHUO_REPORT_PIC_KEY", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ro() {
        if (this.f51482s5 != null) {
            this.f45113m0.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(280L);
            alphaAnimation.setFillAfter(true);
            this.f45116n0.startAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            scaleAnimation.setStartOffset(160L);
            scaleAnimation.setAnimationListener(this.f51350q6);
            this.f51482s5.startAnimation(scaleAnimation);
        }
    }

    private void Rp() {
        if (this.f51489v5 == null || y5.a.H() == null) {
            return;
        }
        long longValue = !TextUtils.isEmpty(this.f51489v5.uin) ? Long.valueOf(this.f51489v5.uin).longValue() : 0L;
        long longValue2 = TextUtils.isEmpty(this.f51489v5.time) ? 0L : Long.valueOf(this.f51489v5.time).longValue();
        y5.a H = y5.a.H();
        PublishEventTag publishEventTag = this.f51489v5;
        H.J(longValue, longValue2, publishEventTag.title, publishEventTag.picUrl, publishEventTag.f45886id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void So() {
        if (this.f51487u5 != null) {
            this.f45113m0.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(280L);
            alphaAnimation.setFillAfter(true);
            this.f45116n0.startAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            scaleAnimation.setStartOffset(160L);
            scaleAnimation.setAnimationListener(this.f51349p6);
            this.f51487u5.startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void To() {
        String f16 = ag.f(this.I4.mVideoPath);
        if (TextUtils.isEmpty(f16)) {
            return;
        }
        this.I4.mCoverUrl = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tp(int i3) {
        if (this.D0 != i3) {
            this.D0 = i3;
        }
        u5.b.L0(ImageQualityPreference.TYPE_SHUOSHUO_ALL_PIC, i3, LoginData.getInstance().getUin());
    }

    private void Up(String str, String str2) {
        if (this.f51461g5 == null) {
            this.f51461g5 = PreferenceManager.getCachePreference(BaseApplication.getContext(), LoginData.getInstance().getUin());
        }
        if (TextUtils.isEmpty(str) || this.f51461g5 == null || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = this.f51461g5.edit();
        edit.putString(LoginData.getInstance().getUin() + "SP_SHUOSHUO_PIC_KEY", str);
        edit.putString(LoginData.getInstance().getUin() + "SP_SHUOSHUO_REPORT_PIC_KEY", str2);
        edit.commit();
        this.f51455e5 = true;
        QZLog.d(f51340x6, 1, "saveShuoShuoPicUrlAndReport picUrl:" + str + " reportStr:" + str2);
    }

    public static String Vo(String str, long j3) {
        return str + "_" + j3;
    }

    private void Vp(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 == 1) {
            hashMap.put("publish_page_schedule_delete_exposure", "1");
            QZLog.i(f51340x6, "publish page schedule delete exposure");
        } else if (i3 == 2) {
            hashMap.put("publish_page_schedule_delete", "1");
            QZLog.i(f51340x6, "publish page schedule delete");
        } else if (i3 == 3) {
            hashMap.put("publish_page_schedule_delete_has_video", "1");
            QZLog.i(f51340x6, "publish page schedule delete has video");
        }
        if (hashMap.size() > 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.QZONE_MOOD_SCHEDULE_DELETE_VIDEO_TAG, true, 0L, 0L, hashMap, (String) null, true);
        }
    }

    private void Wo() {
        if (this.T.N() == null || this.U == null) {
            return;
        }
        for (int i3 = 0; i3 < this.U.size(); i3++) {
            if (this.T.N() != null && this.T.N().containsKey(this.U.get(i3)) && this.T.N().get(this.U.get(i3)) != null) {
                String str = this.T.N().get(this.U.get(i3));
                this.U.remove(i3);
                this.U.add(str);
            }
        }
    }

    private void Yo(Intent intent) {
        PublishEventTag publishEventTag = (PublishEventTag) ParcelableWrapper.getDataFromeIntent(intent, "publish_event_tag_intent_key");
        this.f51489v5 = publishEventTag;
        if (publishEventTag == null) {
            this.f51489v5 = u5.b.b0("_shuoshuo", LoginData.getInstance().getUin());
        }
        if (this.f51489v5 == null) {
            String stringExtra = intent.getStringExtra("tagtitle");
            String stringExtra2 = intent.getStringExtra("taguin");
            String stringExtra3 = intent.getStringExtra("adId");
            PublishEventTag assembleFakeTag = PublishEventTag.assembleFakeTag(stringExtra, stringExtra2);
            this.f51489v5 = assembleFakeTag;
            if (assembleFakeTag == null || TextUtils.isEmpty(stringExtra3)) {
                return;
            }
            this.f51489v5.advId = stringExtra3;
        }
    }

    private void bp(Intent intent) {
        PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
        if (publishParam != null) {
            if (publishParam.M == 1) {
                intent.putExtra(PeakConstants.IS_VIDEO_RECORDED, false);
            } else {
                intent.putExtra(PeakConstants.IS_VIDEO_RECORDED, true);
                intent.putExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR, publishParam.P);
                intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) publishParam.E);
                intent.putExtra(PeakConstants.VIDEO_TYPE, publishParam.Y);
                intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, publishParam.f69067e);
                intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, publishParam.C);
                intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, publishParam.D);
                intent.putExtra(PeakConstants.VIDEO_NEED_PROCESS, true);
                intent.putExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID, publishParam.f69066d);
            }
        } else if (QLog.isColorLevel()) {
            QLog.e(f51340x6, 2, "");
        }
        onNewIntent(intent);
    }

    private void cp() {
        com.qzone.misc.network.report.b.p(this.U4);
        int i3 = this.k3;
        if (i3 == 4 || i3 == 16) {
            boolean z16 = this.f51478r3;
            if (!z16) {
                boolean z17 = !z16;
                this.f51478r3 = z17;
                this.C2.setChecked(z17);
            } else {
                boolean z18 = !z16;
                this.f51478r3 = z18;
                this.C2.setChecked(z18);
            }
        } else if (i3 != 64) {
            boolean z19 = !this.f51478r3;
            this.f51478r3 = z19;
            this.C2.setChecked(z19);
            this.Y2.p();
        }
        if (this.k3 != 64) {
            if (this.f51478r3) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSyncToQQ", "\u53d1\u8868\u540e\u5c06\u540c\u6b65\u5230QQ\u4e2a\u6027\u7b7e\u540d"), 6);
            } else {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCancelSyncToQQ", "\u5df2\u53d6\u6d88\u540c\u6b65QQ\u4e2a\u6027\u7b7e\u540d"), 5);
            }
        }
    }

    private void dp() {
        if (this.k3 == 64) {
            return;
        }
        boolean z16 = !this.f51496y3;
        this.f51496y3 = z16;
        if (z16) {
            ToastUtil.s(getString(R.string.f2200067y, getString(R.string.f2199667u)), 6);
        } else {
            ToastUtil.s(getString(R.string.f2200067y, getString(R.string.f2199667u)), 5);
        }
        this.H2.setChecked(this.f51496y3);
    }

    private void dq(final QbossAdvDesc qbossAdvDesc) {
        String str;
        try {
            RedDotImageView redDotImageView = this.f45113m0;
            if (redDotImageView == null) {
                return;
            }
            if (qbossAdvDesc == null) {
                redDotImageView.setImageResource(R.drawable.qzone_skin_toolbar_btn_font_click);
                return;
            }
            try {
                str = new JSONObject(qbossAdvDesc.res_data).getString("img");
            } catch (Exception unused) {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                this.f45113m0.setImageResource(R.drawable.qzone_skin_toolbar_btn_font_click);
                return;
            }
            if (!this.S5 && str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                String str2 = f51340x6;
                QZLog.i(str2, "entergif");
                if (this.T5) {
                    QZLog.i(str2, "isDoingShowGif");
                    return;
                }
                this.T5 = true;
                this.f45113m0.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f45113m0.setPlayingGif(true);
                this.f45113m0.setNeedGifStream(true);
                this.f45113m0.setAsyncImageListener(new AsyncImageable.AsyncImageListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.61
                    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                    public void onImageFailed(AsyncImageable asyncImageable) {
                        QZonePublishMoodActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.61.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ((PhotoActivity) QZonePublishMoodActivity.this).f45113m0.setPlayingGif(false);
                                ((PhotoActivity) QZonePublishMoodActivity.this).f45113m0.setNeedGifStream(false);
                                ((PhotoActivity) QZonePublishMoodActivity.this).f45113m0.setImageResource(R.drawable.qzone_skin_toolbar_btn_font_click);
                            }
                        });
                    }

                    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                    public void onImageLoaded(AsyncImageable asyncImageable) {
                        if (asyncImageable == null || !(asyncImageable.getDrawable() instanceof NewGifDrawable)) {
                            return;
                        }
                        QZLog.i(QZonePublishMoodActivity.f51340x6, "onImageLoaded");
                        NewGifDrawable newGifDrawable = (NewGifDrawable) asyncImageable.getDrawable();
                        newGifDrawable.setLoopCount(1);
                        newGifDrawable.setGifPlayListener(new a());
                    }

                    /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodActivity$61$a */
                    /* loaded from: classes39.dex */
                    class a implements NewGifDrawable.GifPlayListener {
                        a() {
                        }

                        @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                        public void onGifStartPlay(NewGifDrawable newGifDrawable) {
                            QZLog.i(QZonePublishMoodActivity.f51340x6, "onGifStartPlay");
                        }

                        @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                        public void onGifStopPlay(NewGifDrawable newGifDrawable) {
                            QZLog.i(QZonePublishMoodActivity.f51340x6, "onGifStopPlay");
                            newGifDrawable.stop();
                            QZonePublishMoodActivity.this.S5 = true;
                            newGifDrawable.recycleForGifPlay();
                            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(qbossAdvDesc.res_traceinfo, LoginData.getInstance().getUinString());
                        }

                        @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                        public void onGifPlaying(NewGifDrawable newGifDrawable) {
                        }
                    }

                    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                    public void onImageStarted(AsyncImageable asyncImageable) {
                    }

                    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                    public void onImageProgress(AsyncImageable asyncImageable, float f16) {
                    }
                });
                QZLog.i(str2, "\u64ad\u653egif");
            } else {
                if (!str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                    this.f45113m0.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    if (this.X2) {
                        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(qbossAdvDesc.res_traceinfo, LoginData.getInstance().getUinString());
                    }
                } else {
                    this.f45113m0.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                this.f45113m0.setNeedGifStream(false);
                QZLog.i(f51340x6, "\u64ad\u653e\u9759\u6001\u56fe");
            }
            QZLog.i(f51340x6, "fontgifurl =" + str);
            this.f45113m0.getImageOption().needCache = false;
            this.f45113m0.setAsyncImage(str);
        } catch (Exception unused2) {
        }
    }

    private void ep() {
        com.qzone.misc.network.report.b.g(this.U4);
        fk(false);
        Intent C = ak.C(getActivity());
        C.putExtra("SchedualPublishTime", this.f51457f3);
        C.putExtra("SchedualDeleteTime", this.f51460g3);
        if (this.M5) {
            boolean kn5 = kn();
            C.putExtra("HideSchedualDeleteTime", in(kn5));
            C.putExtra("VideoSelected", kn5);
        }
        startActivityForResult(C, 6004);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eq(RelativeLayout relativeLayout) {
        if (!ParticleManager.j(getActivity()) || this.F1) {
            return;
        }
        this.f51487u5 = new ImageView(getActivity());
        Drawable loadImage = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20181029170118_ziGweKysMR.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.60
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                QZonePublishMoodActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.60.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageView imageView = QZonePublishMoodActivity.this.f51487u5;
                        if (imageView != null) {
                            imageView.setImageDrawable(drawable);
                        }
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        }, (ImageLoader.Options) null);
        if (loadImage != null) {
            this.f51487u5.setImageDrawable(loadImage);
        }
        relativeLayout.addView(this.f51487u5, new RelativeLayout.LayoutParams(ar.e(223.0f), ar.e(43.0f)));
        this.f51487u5.setVisibility(8);
    }

    private void fq(int i3) {
        Drawable drawable;
        String str = this.j3;
        if (i3 == 1) {
            drawable = getResources().getDrawable(R.drawable.gat);
            str = getString(R.string.ghc);
            if (this.F1) {
                $(R.id.j9s).setVisibility(0);
            }
        } else if (i3 == 4) {
            drawable = getResources().getDrawable(R.drawable.gaw);
        } else if (i3 == 64) {
            drawable = getResources().getDrawable(R.drawable.gax);
            str = getString(R.string.ghd);
        } else if (i3 == 16) {
            drawable = getResources().getDrawable(R.drawable.gav);
            str = this.J5;
        } else if (i3 == 128) {
            drawable = getResources().getDrawable(R.drawable.gay);
            str = this.K5;
            if (this.F1) {
                $(R.id.j9s).setVisibility(0);
            }
        } else {
            drawable = null;
        }
        this.f51477q5.setImageAndText(drawable, str);
        this.f51480r5.setImageAndText(drawable, str);
        this.f51477q5.setCheck(true);
        this.f51480r5.setCheck(true);
        Do();
    }

    private void gp() {
        if (!this.f51481s3 && (this.f51457f3 > 0 || this.f51460g3 > 0)) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotSyncToWeixin", "\u8bbe\u7f6e\u4e86\u65f6\u6548\u7684\u8bf4\u8bf4\u65e0\u6cd5\u540c\u6b65\u5230\u5fae\u4fe1"), 6);
            return;
        }
        if (this.f45090e1 && u5.b.h0("key_dynamic_share_url", "null").equals("null")) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastWeakNetWork", "\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\u3002"), 6);
            return;
        }
        com.qzone.misc.network.report.b.q(this.U4);
        int i3 = this.k3;
        if (i3 == 4 || i3 == 16) {
            boolean z16 = !this.f51481s3;
            this.f51481s3 = z16;
            this.G2.setChecked(z16);
        } else if (i3 != 64) {
            boolean z17 = !this.f51481s3;
            this.f51481s3 = z17;
            this.G2.setChecked(z17);
        }
        if (this.k3 != 64) {
            if (this.f51481s3) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSyncToWechat", "\u53d1\u8868\u540e\u5c06\u540c\u6b65\u5230\u670b\u53cb\u5708"), 6);
            } else {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCancelSyncToWechat", "\u5df2\u53d6\u6d88\u540c\u6b65\u670b\u53cb\u5708"), 5);
            }
        }
    }

    private void hp() {
        if (this.k3 == 64) {
            return;
        }
        boolean z16 = !this.f51444b4;
        this.f51444b4 = z16;
        if (z16) {
            ToastUtil.s(getString(R.string.f2200067y, getString(R.string.f2203168s)), 6);
        } else {
            ToastUtil.s(getString(R.string.f2192365v, getString(R.string.f2203168s)), 5);
        }
        this.J2.setChecked(this.f51444b4);
        long uin = LoginData.getInstance().getUin();
        if (this.F1) {
            uin *= 100;
        }
        u5.b.o0(Vo("wezone_last_selected", uin), this.f51444b4);
        LpReportInfo_pf00064.allReport(586, 51, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(int i3) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpPhoto", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u5f20\u7167\u7247\u5417\uff1f");
        e9.a aVar = this.T;
        if (aVar != null && aVar.h0(i3)) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpVideo", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u4e2a\u89c6\u9891\u5417\uff1f");
        }
        new com.qzone.component.e().g(getActivity(), config, null, new j(i3), null);
    }

    private void initConfig() {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_MOOD_PHOTO_MAX_NUM, 50);
        com.qzone.publish.ui.model.b.f51929c = config;
        if (config > com.qzone.util.y.b()) {
            com.qzone.publish.ui.model.b.f51929c = com.qzone.util.y.b();
        }
        boolean z16 = false;
        this.V4 = LocalMultiProcConfig.getInt4Uin(LocalMultiProcConfig.QZONE_SYNC_KUOLIE, 0, LoginData.getInstance().getUin()) == 1 && QZoneConfigHelper.n();
        this.W4 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NEED_SYNC_TO_WEISHI, 1) == 1;
        this.B5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_ENABLE_TEMPLATESHUOSHUO, 1) == 1;
        this.C5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_ENABLE_VOICE_SHUOSHUO_H5, 0) == 1;
        this.A5 = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_MOOD_EVENT_TAG_JUMP_PAGE, QzoneConfig.QZONE_MOOD_EVENT_TAG_USE_H5, 1) == 1;
        this.X4 = hn();
        if (uq3.c.z6() && !com.qzone.util.l.a(R.string.f172540rs4).equals(this.V5)) {
            z16 = true;
        }
        this.Y4 = z16;
    }

    private void initUI() {
        np();
        op();
        up();
        rp();
        mp();
        pp();
        yp();
        Cq();
        if (this.F1) {
            ip();
            $(R.id.itr).setBackgroundColor(-1);
        }
        this.J1.z();
        qp();
    }

    private void jq() {
        new com.qzone.component.e().f(getActivity(), 230, "", getActivity().getApplicationContext().getResources().getString(R.string.gef), getActivity().getApplicationContext().getResources().getString(R.string.gee), getActivity().getApplicationContext().getResources().getString(R.string.gd5), new t(), new u());
    }

    private void kq() {
        RedDotImageView redDotImageView;
        if (this.f51485t5 != null && (redDotImageView = this.f45113m0) != null) {
            redDotImageView.setVisibility(4);
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.23
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodActivity.this.yq();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp() {
        if (this.f51343j6 == null) {
            this.f51343j6 = new w();
            getRealActivity().registerReceiver(this.f51343j6, new IntentFilter("qzone.pickgamemates"));
        }
    }

    private void mp() {
        if (!this.f45090e1 && !QZoneJsConstants.SHARE_SOURCE_TYPE_MSGTAB_CAMERA.equals(this.V5)) {
            ImageView imageView = (ImageView) $(R.id.hrt);
            this.f51490w2 = imageView;
            imageView.setVisibility(0);
            this.f51490w2.setOnClickListener(this);
            LpReportInfo_pf00064.allReport(586, 47, 1);
        }
        RedDotImageView redDotImageView = (RedDotImageView) $(R.id.hro);
        this.f51492x2 = redDotImageView;
        redDotImageView.setOffSet(ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(2.0f));
        this.f51492x2.setOnClickListener(this);
        this.f51443b3 = $(R.id.hrw);
        this.f51447c3 = (ImageView) $(R.id.hrv);
        this.f51450d3 = (TextView) $(R.id.ih6);
        this.f51443b3.setOnClickListener(this);
        View $ = $(R.id.iua);
        this.f51463h3 = $;
        $.setOnClickListener(this);
        this.i3 = (TextView) $(R.id.f166878iu3);
        if (this.f45090e1) {
            this.f51463h3.setVisibility(0);
            this.f51468l5.setVisibility(8);
        } else {
            this.f51463h3.setVisibility(8);
            this.f51468l5.setVisibility(0);
        }
        this.f51471o3 = $(R.id.m8t);
        Switch r06 = (Switch) $(R.id.m7u);
        this.f51473p3 = r06;
        r06.setOnCheckedChangeListener(this.f51344k6);
        Im();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq() {
        QZoneHelper.showQzoneVipOriginalVideoDialog(getActivity(), new m());
    }

    private void nq() {
        RedDotImageView redDotImageView;
        if (this.f51487u5 != null && (redDotImageView = this.f45113m0) != null) {
            redDotImageView.setVisibility(4);
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.26
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodActivity.this.zq();
            }
        }, 300L);
    }

    private void oq() {
        if (this.f51467k5 != null && !this.f45131t0 && !this.f45135v0 && Go()) {
            this.f51467k5.setVisibility(0);
            this.f51468l5.setVisibility(4);
            return;
        }
        View view = this.f51467k5;
        if (view != null) {
            view.setVisibility(8);
            this.f51468l5.setVisibility(0);
        }
    }

    private void pp() {
        ak();
        if (this.f51445b5) {
            com.qzone.common.activities.titlebuilder.a aVar = this.C;
            if (aVar != null && aVar.R0() != null) {
                this.C.R0().setPadding(this.C.R0().getPaddingLeft(), 0, this.C.R0().getPaddingRight(), this.C.R0().getPaddingBottom());
            }
            com.qzone.common.activities.titlebuilder.a aVar2 = this.C;
            if (aVar2 != null && aVar2.E5() != null) {
                this.C.E5().setVisibility(8);
            }
        }
        PublishEventTag publishEventTag = this.f51489v5;
        if (publishEventTag != null) {
            iq(publishEventTag);
        }
    }

    private void pq(String str) {
        ActionSheet actionSheet = this.f51351r6;
        if (actionSheet == null) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogUpload", "\u7acb\u5373\u4e0a\u4f20");
            ActionSheet create = ActionSheet.create(getActivity());
            this.f51351r6 = create;
            create.setMainTitle(str);
            this.f51351r6.addButton(config, 0);
            this.f51351r6.addCancelButton(com.qzone.util.l.a(R.string.j6l));
            this.f51351r6.setOnButtonClickListener(new q(config));
            this.f51351r6.setOnDismissListener(new r());
            this.f51351r6.show();
            return;
        }
        if (actionSheet.isShowing()) {
            return;
        }
        this.f51351r6.show();
    }

    private void qp() {
        if (pk() && nk() && QzoneConfig.isEnablePickGameMates()) {
            String stringExtra = getIntent().getStringExtra(QZoneShareManager.QZONE_SHARE_EXTSTRING);
            String stringExtra2 = getIntent().getStringExtra("open_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    String optString = new JSONObject(stringExtra).optString("hulian_extra_scene");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    HashMap<String, String> Jp = Jp(optString);
                    if (Jp != null && Jp.get("gameseq") != null && !Jp.get("gameseq").equals("0")) {
                        if ("1".equals(Jp.get("hasFriends"))) {
                            $(R.id.iuk).setVisibility(8);
                            LinearLayout linearLayout = (LinearLayout) $(R.id.fss);
                            this.Y5 = linearLayout;
                            linearLayout.setVisibility(0);
                            this.f51442a6 = (TextView) $(R.id.fsu);
                            this.Z5 = (ImageView) $(R.id.fst);
                            this.Y5.setOnClickListener(new z(optString, stringExtra2));
                            LpReportInfo_pf00064.report(122, 7, 1, this.f45117n1);
                            return;
                        }
                        return;
                    }
                    if (QZLog.isColorLevel()) {
                        QZLog.i(f51340x6, "hulian_extra_scene:" + optString);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QZLog.e(f51340x6, 1, e16, new Object[0]);
                    return;
                }
            }
            if (QZLog.isColorLevel()) {
                QZLog.i(f51340x6, "extString:" + stringExtra + " openId" + stringExtra2);
            }
        }
    }

    private void qq() {
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.48
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodActivity.this.rq();
            }
        });
    }

    private void tp(com.qzone.publish.ui.model.c cVar) {
        if ("friendRelation".equals(this.V5)) {
            cVar.H = 68;
        } else if ("miniApp".equals(this.V5)) {
            cVar.H = 70;
            String stringExtra = getIntent().getStringExtra("key_mini_appid");
            String stringExtra2 = getIntent().getStringExtra(QZoneShareManager.QZONE_SHARE_KEY_MINI_APP_TAIL);
            if (!TextUtils.isEmpty(stringExtra)) {
                cVar.e().put(operation_forward_req.XCX_MAPEX_KEY_APPID, stringExtra);
                cVar.e().put("comm_recom_bottom", stringExtra2);
            }
            QZLog.d(f51340x6, 1, "mini app comm_recom_bottom: " + stringExtra2);
        }
        if (this.f45117n1 != null) {
            cVar.e().put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, this.f45117n1);
        }
        cVar.e().put(QZonePublishMoodRequest.KEY_APPID_FOR_CLIENT_FAKE_FEED, String.valueOf(311));
    }

    private void tq() {
        QZLog.d(f51340x6, 4, "Need syncDynamicToWechat:" + this.f51481s3);
        if (this.f51481s3) {
            String h06 = u5.b.h0("key_dynamic_share_url", "null");
            String h07 = u5.b.h0("key_dynamic_share_cover_url", "null");
            String stringExtra = getIntent().getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_NAME);
            if (!h06.equals("null") && !h07.equals("null")) {
                ShareUtils.g gVar = new ShareUtils.g();
                gVar.f44740a = h06;
                gVar.f44743d = h07;
                gVar.f44741b = stringExtra;
                ShareUtils.q(getActivity(), 10, gVar);
            } else {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSyncWechatFailForWeakNetWork", "\u7f51\u7edc\u4e0d\u4f73\uff0c\u540c\u6b65\u670b\u53cb\u5708\u5931\u8d25"), 6);
            }
            ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 3, "3", true, new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq(String str) {
        String str2;
        MoodPicLabel moodPicLabel = this.f51472o5;
        if (moodPicLabel == null) {
            str2 = "";
        } else {
            str2 = moodPicLabel.c();
        }
        String str3 = str2.equals(getString(R.string.f173026gk2)) ? "" : str2;
        DynamicArrayList<String> dynamicArrayList = this.U;
        if (dynamicArrayList != null && !dynamicArrayList.isEmpty()) {
            com.qzone.publish.utils.a aVar = new com.qzone.publish.utils.a(getActivity(), str, str3, uj(Zi(null)));
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap e16 = aVar.e(oj());
            if (QZLog.isColorLevel()) {
                QZLog.i(f51340x6, "bitmap create time cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (e16 != null) {
                String str4 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                StringBuilder sb5 = new StringBuilder();
                String str5 = IQzoneShareApi.PHOTO_PATH;
                sb5.append(str5);
                sb5.append(str4);
                String sb6 = sb5.toString();
                try {
                    File file = new File(str5);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } catch (Throwable th5) {
                    QZLog.e(f51340x6, th5.getMessage());
                }
                com.qzone.util.image.c.V(e16, sb6, Bitmap.CompressFormat.JPEG, 100, true);
                if (this.Q5) {
                    ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(this.f51355v6);
                    ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), sb6, null, 1);
                    xq();
                    if (QZLog.isColorLevel()) {
                        QZLog.i(f51340x6, "wxshare time cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    return;
                }
                return;
            }
            xq();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                xq();
                String emoToWechatEmo = QzoneEmotionUtils.emoToWechatEmo(lp.a.c(str));
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(this.f51355v6);
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareText(emoToWechatEmo, 1);
                return;
            } catch (Throwable th6) {
                QZLog.e(f51340x6, th6.getMessage());
                return;
            }
        }
        xq();
    }

    private boolean vp() {
        Intent intent = getIntent();
        return intent != null && intent.getIntExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, -1) == 13;
    }

    private void xq() {
        QQProgressDialog qQProgressDialog = this.R5;
        if (qQProgressDialog != null && qQProgressDialog.isShowing() && getActivity() != null && !getActivity().isFinishing()) {
            this.Q5 = false;
            try {
                this.R5.dismiss();
            } catch (Exception e16) {
                QZLog.e(f51340x6, "dialog dismiss error", e16);
            }
            Fo();
            return;
        }
        this.Q5 = false;
        Fo();
    }

    private void yp() {
        long uin = LoginData.getInstance().getUin();
        if (this.F1) {
            uin *= 100;
        }
        int G = u5.b.G(Vo("shuoshuo_sync_bits", uin), 0);
        this.f51478r3 = (G & 1) != 0;
        this.f51481s3 = (G & 4) != 0;
        this.f51484t3 = (G & 8) != 0;
        this.f51496y3 = (G & 32) != 0;
        Dq(uin, G);
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KUOLIE_SYNC_BUTTON, false)) {
            this.f51493x3 = (G & 16) != 0;
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void An() {
        LbsDataV2.PoiInfo poiInfo;
        this.f51451d4.setVisibility(0);
        this.P.setVisibility(4);
        this.T2.setVisibility(8);
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.I4;
        if (shuoshuoVideoInfo != null && shuoshuoVideoInfo.mVideoType == 1) {
            this.C4.setVisibility(0);
            ln();
            qq();
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.I4;
        if (shuoshuoVideoInfo2 != null && shuoshuoVideoInfo2.mVideoType == 0 && (poiInfo = this.M0) != null) {
            if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
                Xl(1, this.M0.poiDefaultName);
            } else {
                ((LBSModule) hj(LBSModule.class)).J();
            }
        }
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null && aVar.u() != null) {
            this.C.u().setEnabled(oi());
        }
        if (this.Z2 != 2) {
            setTitle(R.string.i1w);
        }
        jm(getText(R.string.glp));
        this.B2.setVisibility(8);
        kp();
    }

    public void Aq() {
        TextView u16;
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || (u16 = aVar.u()) == null) {
            return;
        }
        u16.setTextColor(getResources().getColorStateList(R.color.f157916aa0));
        u16.setTextSize(2, 14.0f);
        u16.setPadding(ar.e(15.0f), ar.e(3.5f), ar.e(15.0f), ar.e(3.5f));
        u16.getLayoutParams().height = ar.e(29.0f);
        if (com.tencent.mobileqq.simpleui.b.c() && SimpleUIUtil.getSimpleUiBgColor() != -1 && SimpleUIUtil.getSimpleUiBgColor() != -657670) {
            u16.setBackgroundResource(R.drawable.hin);
            u16.setTextColor(-16777216);
        } else {
            u16.setBackgroundResource(R.drawable.art);
        }
        u16.setMaxWidth(ViewUtils.dpToPx(100.0f));
        ((RelativeLayout.LayoutParams) u16.getLayoutParams()).setMargins(0, 0, ar.d(12.0f), 0);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Bj(Boolean bool, String str, String str2, String str3) {
        if (bool.booleanValue() && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (((UrlExtendEditText) this.f45104j0).x(str, str2)) {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                this.Z0 = str3;
                fi(str3);
                this.T.w0(this.Z0);
                this.T.notifyDataSetChanged();
                return;
            }
            ((UrlExtendEditText) this.f45104j0).setUrlState(0);
            return;
        }
        ((UrlExtendEditText) this.f45104j0).setUrlState(0);
        QZLog.e(f51340x6, "get URL info failed!");
    }

    protected boolean Bp() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_URL_ANALYSIS, 0) == 1;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Cl() {
        com.qzone.misc.network.report.b.b(this.U4);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Di(String str) {
        boolean Di = super.Di(str);
        if (Di) {
            u5.b.q("_shuoshuo", LoginData.getInstance().getUin());
        }
        return Di;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Dl() {
        com.qzone.misc.network.report.b.j(this.U4);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Dn() {
        int i3;
        if (this.f51493x3 && (i3 = this.k3) != 128 && i3 != 1) {
            yn();
        } else {
            Pm();
        }
    }

    public void Dp() {
        if (this.f51455e5) {
            QZLog.i(f51340x6, 1, "onAddBtnLoadAdResource already pull ad");
        } else {
            QZoneAdvService.c().g(getHandler(), 2, 2542);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Ek() {
        ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).G();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void El() {
        com.qzone.misc.network.report.b.n(this.U4);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Em() {
        View view = this.f51471o3;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.f51473p3.setChecked(this.S1 == 1);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void En(long j3) {
        this.f51454e3 = j3;
        if (j3 > 0) {
            this.f51447c3.setImageResource(R.drawable.bwx);
            this.f51450d3.setVisibility(0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5HH\u65f6mm\u5206");
            this.f51450d3.setText(simpleDateFormat.format(Long.valueOf(this.f51454e3 * 1000)));
            this.f51450d3.setContentDescription(simpleDateFormat2.format(Long.valueOf(this.f51454e3 * 1000)));
            return;
        }
        this.f51447c3.setImageResource(R.drawable.bww);
        this.f51450d3.setVisibility(8);
        this.f51454e3 = 0L;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Fi(MotionEvent motionEvent) {
        View childAt;
        DynamicGridView dynamicGridView = this.P;
        if (dynamicGridView != null && this.T != null) {
            int lastVisiblePosition = dynamicGridView.getLastVisiblePosition();
            if (!this.f45084c1 && this.T.d0(lastVisiblePosition) && (childAt = this.P.getChildAt(lastVisiblePosition)) != null && this.T.H(childAt) && aj.k(motionEvent, childAt, getTitleBarHeight(), this.mStatusBarHeight) && (dk(true) || ak() || bk() || gk(motionEvent))) {
                Cp();
                return true;
            }
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Fl() {
        com.qzone.misc.network.report.b.m(this.U4);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Gl() {
        com.qzone.misc.network.report.b.r(this.U4);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Gm(l5.a aVar) {
        super.Gm(aVar);
        aq(aVar);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Gn(boolean z16) {
        if (!this.f45084c1 || TextUtils.isEmpty(this.f45096g1) || this.f51451d4 == null || this.f51479r4 == null || this.f51474p4 == null || this.I4 == null) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.34
            @Override // java.lang.Runnable
            public void run() {
                String str = QZonePublishMoodActivity.this.I4.mVideoPath;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!new File(str).exists()) {
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (TextUtils.isEmpty(QZonePublishMoodActivity.this.I4.mCoverUrl)) {
                    QZonePublishMoodActivity.this.To();
                } else if (!new File(QZonePublishMoodActivity.this.I4.mCoverUrl).exists()) {
                    QZonePublishMoodActivity.this.To();
                }
                QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                qZonePublishMoodActivity.f51474p4.setAsyncImage(qZonePublishMoodActivity.I4.mCoverUrl);
                String i3 = ag.i(QZonePublishMoodActivity.this.I4.mDuration);
                QZonePublishMoodActivity.this.f51479r4.setText("" + i3);
                QZonePublishMoodActivity.this.An();
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Im() {
        if (Xo() >= 3 && !kn() && !this.f45090e1) {
            if (this.f51471o3 == null) {
                this.f51471o3 = $(R.id.m8t);
            }
            this.f51471o3.setVisibility(0);
            LpReportInfo_pf00064.allReport(586, 47, 1);
            return;
        }
        View view = this.f51471o3;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Kk() {
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Km() {
        DynamicArrayList<String> dynamicArrayList;
        if (this.S1 == 1 && (dynamicArrayList = this.U) != null && !dynamicArrayList.isEmpty()) {
            int size = this.U.size();
            int i3 = this.f51476q3;
            if (size > i3) {
                ql(i3);
                this.T.notifyDataSetChanged();
                ToastUtil.s(getResources().getString(R.string.cu5, Integer.valueOf(this.f51476q3)), 4);
            }
            this.P.setVisibility(8);
            this.Q.setAsyncImage(this.U.get(0));
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.S.setVisibility(0);
            this.H2.setChecked(false);
            this.I2.setVisibility(8);
            this.K2.setVisibility(8);
        } else {
            this.P.setVisibility(0);
            this.Q.setVisibility(8);
            this.R.setVisibility(4);
            this.S.setVisibility(8);
            Fn(kn());
        }
        Im();
        Em();
    }

    protected void Ko() {
        long C;
        if (NetworkState.isWifiConn()) {
            Yp();
            return;
        }
        if (this.f45084c1) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.I4;
            if (shuoshuoVideoInfo != null) {
                C = 1 == shuoshuoVideoInfo.mIsNew ? 0L : Math.round(shuoshuoVideoInfo.mEstimateSize);
            } else {
                C = this.f45099h1;
            }
        } else {
            C = com.qzone.util.image.c.C(Uo(), oj(), this.D0, this.E0);
        }
        if (com.qzone.util.image.c.M(C)) {
            pq(com.qzone.util.image.c.H(C, this.f45084c1));
        } else {
            Yp();
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Lk() {
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Mk() {
        return true;
    }

    public void Mp() {
        if (com.qzone.publish.ui.model.b.f51931e) {
            com.qzone.album.ui.widget.g gVar = this.C0;
            if (gVar != null) {
                gVar.f(false);
            }
            if (kn()) {
                View view = this.C4;
                if (view != null) {
                    view.setVisibility(0);
                    ln();
                    qq();
                }
            } else {
                View view2 = this.C4;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            boolean kn5 = kn();
            String str = f51340x6;
            QZLog.d(str, 2, "refreshMixMoodQualityUI has selectVideomIsDynamic : is" + this.f45090e1);
            if (kn5 && !this.f45090e1) {
                View view3 = this.F2;
                if (view3 != null) {
                    view3.setVisibility(8);
                    this.f51481s3 = false;
                    this.G2.setChecked(false);
                }
                View view4 = this.B2;
                if (view4 != null) {
                    view4.setVisibility(8);
                    this.f51478r3 = false;
                    this.C2.setChecked(false);
                }
                QZLog.d(str, 2, "has video ,set qq and wechat icon gone");
            } else if (!kn5 && !this.f45090e1) {
                View view5 = this.B2;
                if (view5 != null) {
                    view5.setVisibility(0);
                }
                QZLog.d(str, 2, "don't has video ,set qq and wechat icon visible");
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.52
                    @Override // java.lang.Runnable
                    public void run() {
                        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
                        if (iQzoneShareApi.isWXinstalled() && iQzoneShareApi.isWxSupportTimeLine()) {
                            QZonePublishMoodActivity.this.getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.52.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                                    if (qZonePublishMoodActivity.F2 == null || qZonePublishMoodActivity.kn()) {
                                        return;
                                    }
                                    QZonePublishMoodActivity qZonePublishMoodActivity2 = QZonePublishMoodActivity.this;
                                    if (qZonePublishMoodActivity2.f45090e1) {
                                        return;
                                    }
                                    qZonePublishMoodActivity2.F2.setVisibility(0);
                                }
                            });
                        }
                    }
                });
            }
            if (in(kn5) && this.f51457f3 > 0) {
                ToastUtil.o(R.string.glk, 3);
                this.f51457f3 = 0L;
                Bq(0L, this.f51460g3);
            }
            if (kn5 && !this.M5) {
                kp();
            } else if (!this.f45090e1 && !this.F1) {
                View view6 = this.f51443b3;
                if (view6 != null) {
                    view6.setVisibility(0);
                    if (!this.L5) {
                        this.L5 = true;
                        Vp(1);
                    }
                }
            } else {
                kp();
            }
            Fn(kn5);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Nk() {
        return true;
    }

    @Override // com.qzone.publish.ui.controller.a
    public void O4(View view) {
        View.OnClickListener onClickListener = this.f51342i6;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Oj(final String str, final int i3, final int i16, final long j3, final long j16, final long j17, final boolean z16, final Bundle bundle) {
        super.Oj(str, i3, i16, j3, j16, j17, z16, bundle);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.54
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(QZonePublishMoodActivity.this.f45096g1)) {
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (!new File(QZonePublishMoodActivity.this.f45096g1).exists()) {
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("videomood", 4, "handleSelectVideoResult...");
                }
                QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                qZonePublishMoodActivity.I4 = ag.q(qZonePublishMoodActivity.f45096g1, ((PhotoActivity) qZonePublishMoodActivity).f45099h1, QZonePublishMoodActivity.this.f45102i1, str, i3, i16, j3, j16, j17, z16, bundle);
                QZonePublishMoodActivity qZonePublishMoodActivity2 = QZonePublishMoodActivity.this;
                if (1 == qZonePublishMoodActivity2.f45102i1 && qZonePublishMoodActivity2.L4 == null) {
                    qZonePublishMoodActivity2.zp();
                }
                QZonePublishMoodActivity.this.Gn(false);
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Ok() {
        DynamicArrayList<String> dynamicArrayList;
        if (this.M1 && (dynamicArrayList = this.U) != null && dynamicArrayList.size() > 0) {
            Iterator it = ((ArrayList) this.U.clone()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (this.f51446b6.containsKey(str)) {
                    Pair<String, String> pair = this.f51446b6.get(str);
                    String imageFilePath = CacheManager.getImageFilePath(getActivity(), str);
                    if (!TextUtils.isEmpty(imageFilePath)) {
                        this.f51446b6.put(imageFilePath, pair);
                    }
                }
            }
        }
        super.Ok();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Pl() {
        yo.d.l(getActivity(), QzoneConfig.getInstance().getConfig("H5Url", "EasterEgg", "https://h5.qzone.qq.com/mood/photoselector?_wv=2097155&_proxy=1&qua={qua}"), 200, null);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Pm() {
        CheckBox checkBox;
        if (com.qzone.feed.utils.h.h(this.k3) && !TextUtils.isEmpty(this.n3)) {
            this.j3 = this.n3;
        } else {
            this.j3 = com.qzone.feed.utils.h.f(this.k3);
        }
        String replace = this.j3.replace(",", "\u3001");
        this.j3 = replace;
        this.i3.setText(replace);
        fq(this.k3);
        float f16 = this.k3 == 64 ? 0.5f : 1.0f;
        CheckBox checkBox2 = this.C2;
        if (checkBox2 != null) {
            checkBox2.setAlpha(f16);
        }
        CheckBox checkBox3 = this.G2;
        if (checkBox3 != null) {
            checkBox3.setAlpha(f16);
        }
        CheckBox checkBox4 = this.E2;
        if (checkBox4 != null) {
            checkBox4.setAlpha(f16);
        }
        CheckBox checkBox5 = this.H2;
        if (checkBox5 != null) {
            checkBox5.setAlpha(f16);
        }
        CheckBox checkBox6 = this.J2;
        if (checkBox6 != null) {
            checkBox6.setAlpha(f16);
        }
        int i3 = this.k3;
        if (i3 == 1 || i3 == 128 || (checkBox = this.E2) == null) {
            return;
        }
        checkBox.setChecked(false);
        this.f51493x3 = false;
    }

    @Override // com.qzone.publish.ui.controller.a
    public boolean Q() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Qm() {
        u5.b.A0("peitu_entry_sourceid", LoginData.getInstance().getUin());
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    protected int Rm() {
        return R.anim.f155012v2;
    }

    protected void Sp(ArrayList<String> arrayList) {
        final ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (o7.b.a(next)) {
                arrayList2.add(next);
            } else if (o7.b.c(next)) {
                this.f51491w5 = true;
            }
        }
        if (arrayList2.size() > 0) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.41
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        String str = (String) it5.next();
                        MediaUtil.saveFileToSystemAlbum(QZonePublishMoodActivity.this.getActivity(), str, System.currentTimeMillis() + QzoneEmotionUtils.SIGN_ICON_URL_END);
                    }
                }
            });
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    protected int Tm() {
        return R.anim.f155010v0;
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public String Um() {
        return ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).H;
    }

    public HashMap<String, ShuoshuoVideoInfo> Uo() {
        HashMap<String, ShuoshuoVideoInfo> hashMap = new HashMap<>();
        for (int i3 = 0; i3 < this.U.size(); i3++) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.X.get(this.U.get(i3));
            if (shuoshuoVideoInfo == null) {
                shuoshuoVideoInfo = this.Z.get(this.U.get(i3));
            }
            if (shuoshuoVideoInfo != null) {
                hashMap.put(this.U.get(i3), shuoshuoVideoInfo);
            }
        }
        return hashMap;
    }

    @Override // com.qzone.publish.ui.controller.a
    public void Vf(View view) {
        View.OnClickListener onClickListener = this.f51356w6;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public HashMap<String, PicInfo> Vm() {
        return this.f51486u2;
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Wm() {
        ((LBSModule) hj(LBSModule.class)).J();
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public String Xm() {
        if (this.f51472o5.c().toString().equals(getString(R.string.f173026gk2))) {
            return null;
        }
        return this.f51472o5.c();
    }

    public int Xo() {
        HashMap<String, PicInfo> hashMap;
        DynamicArrayList<String> dynamicArrayList = this.U;
        int i3 = 0;
        if (dynamicArrayList != null && this.W != null) {
            Iterator<String> it = dynamicArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                LocalMediaInfo localMediaInfo = this.W.get(next);
                if (localMediaInfo == null) {
                    localMediaInfo = (LocalMediaInfo) ((IMiniAppService) QRoute.api(IMiniAppService.class)).getPhotoLocalMediaInfoByPath(next);
                }
                if ((localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 0) || ((hashMap = this.A0) != null && hashMap.containsKey(next))) {
                    i3++;
                }
            }
            QZLog.d(f51340x6, 2, "has normal images\uff1a " + i3);
        }
        return i3;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Yl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.equals(getString(R.string.f173025gk1)) && !str.equals(getString(R.string.f173026gk2))) {
            MoodPicLabel moodPicLabel = this.f51472o5;
            if (moodPicLabel != null) {
                moodPicLabel.setCheck(true);
            }
            MoodPicLabel moodPicLabel2 = this.f51475p5;
            if (moodPicLabel2 != null) {
                moodPicLabel2.setCheck(true);
            }
        } else {
            str = getString(R.string.f173026gk2);
            MoodPicLabel moodPicLabel3 = this.f51472o5;
            if (moodPicLabel3 != null) {
                moodPicLabel3.setCheck(false);
            }
            MoodPicLabel moodPicLabel4 = this.f51475p5;
            if (moodPicLabel4 != null) {
                moodPicLabel4.setCheck(false);
            }
        }
        MoodPicLabel moodPicLabel5 = this.f51472o5;
        if (moodPicLabel5 != null) {
            moodPicLabel5.setImageAndText(null, str);
        }
        MoodPicLabel moodPicLabel6 = this.f51475p5;
        if (moodPicLabel6 != null) {
            moodPicLabel6.setImageAndText(null, str);
        }
        Do();
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public ShuoshuoVideoInfo Ym() {
        return this.I4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x02f3, code lost:
    
        if (r0.mDuration != r0.mTotalDuration) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0593 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void Yp() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intent intent;
        DynamicArrayList<String> dynamicArrayList;
        DynamicArrayList<String> dynamicArrayList2;
        int i3;
        Intent intent2;
        DynamicArrayList<String> dynamicArrayList3;
        Intent intent3;
        int i16;
        LocalMediaInfo localMediaInfo;
        boolean z16;
        HashMap<String, Integer> hashMap;
        boolean z17;
        int i17;
        if (this.f51354u6) {
            return;
        }
        if (this.f45090e1) {
            ArrayList<String> oj5 = oj();
            for (int i18 = 0; i18 < oj5.size(); i18++) {
                if (!oj5.get(i18).startsWith("http://") && !oj5.get(i18).startsWith("https://") && !com.qzone.publish.utils.c.b(oj5.get(i18))) {
                    ToastUtil.r(getString(R.string.gav));
                    gm(true);
                    return;
                }
            }
        }
        QZoneWriteOperationService.v0().p2(this);
        if (this.f45084c1 && this.I4 == null) {
            QZLog.w("videomood", "sendMood mVideo == null");
            gm(true);
            return;
        }
        ek();
        if (Ho()) {
            gm(true);
            return;
        }
        Rp();
        this.f51353t6 = false;
        if (this.f51454e3 > (System.currentTimeMillis() / 1000) + com.qzone.publish.ui.model.b.f51927a) {
            ToastUtil.r(getString(R.string.glv));
            gm(true);
            return;
        }
        this.f51354u6 = true;
        this.f51454e3 = (this.f51454e3 / 60) * 60;
        String Vi = Vi();
        boolean isChecked = this.C2.isChecked();
        if (isChecked) {
            Vi = "qm" + Vi;
        }
        final String str6 = Vi;
        u5.b.f1(1, LoginData.getInstance().getUin());
        String string4Uin = ((this.F1 || this.f51493x3) && !TextUtils.isEmpty(LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOLNAME, "", LoginData.getInstance().getUin()))) ? LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOLNAME, "", LoginData.getInstance().getUin()) : "";
        if (this.F1) {
            str = "use_kuolie=1&scene=kuolie";
        } else {
            str = this.f51493x3 ? "use_kuolie=1&scene=qzone" : "";
        }
        if (!TextUtils.isEmpty(str)) {
            str = this.k3 == 64 ? str + "&right=kuolie" : str + "&right=qzone";
        }
        String str7 = str;
        List<String> list = this.R2;
        if (list != null && list.size() > 0) {
            for (String str8 : this.R2) {
                if (!TextUtils.isEmpty(str8)) {
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_BANNER_RECENT_PHOTO_BLACKLIST, str8);
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST, str8);
                }
            }
            this.R2.clear();
        }
        QZonePreUploadInfo qZonePreUploadInfo = new QZonePreUploadInfo();
        qZonePreUploadInfo.preUploadedPaths = null;
        qZonePreUploadInfo.preUploadingRequest = null;
        qZonePreUploadInfo.preUploadType = 0;
        Intent intent4 = getIntent();
        String stringExtra = intent4 != null ? intent4.getStringExtra("key_ext_param") : null;
        boolean z18 = !this.V0 && ((i17 = this.K0) == 1 || i17 == 3) && this.T0 == null;
        Ok();
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("is_feeds_long_pics_browsing_mode", 1 == this.S1 ? "1" : "0");
        if (!TextUtils.isEmpty(this.W5)) {
            hashMap2.put(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, this.W5);
        }
        if (!TextUtils.isEmpty(this.X5)) {
            hashMap2.put(PeakConstants.KEY_QQ_CAMERA_SCHEME, this.X5);
        }
        Lp(hashMap2);
        if (this.f51496y3 && this.I2.getVisibility() == 0 && this.X4) {
            str2 = "0";
            QZLog.d(f51340x6, 1, "sendMood... certifiedPUin:", this.f51449c6);
            LpReportInfo_pf00064.allReport(586, 50);
            hashMap2.put(QZonePublishMoodRequest.EXT_INFO_KEY_SYNC_TO_RENZHENHAO, this.f51449c6);
        } else {
            str2 = "0";
        }
        if (this.f51444b4 && this.K2.getVisibility() == 0 && this.Y4) {
            QZLog.d(f51340x6, 1, "sendMood... wezoneExtValue:", this.f51453d6);
            hashMap2.put("circle_info", this.f51453d6);
        }
        if (this.f45090e1) {
            tq();
        } else if (this.f51481s3) {
            if (oj() != null && oj().size() > 0) {
                if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHAREWX_MULTIPIC, 0) == 0) {
                    QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), ViewUtils.dip2px(100.0f));
                    this.R5 = qQProgressDialog;
                    qQProgressDialog.setMessage(com.qzone.util.l.a(R.string.s5i));
                    this.R5.show();
                    this.R5.O(new v());
                    vq();
                } else {
                    wq(oj());
                }
            } else {
                vq();
            }
        }
        if (((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).H != null) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).H = "";
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("videomood", 4, "sendMood mVideoInfo=" + this.I4);
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.I4;
        if (shuoshuoVideoInfo != null) {
            boolean z19 = this.H4;
            shuoshuoVideoInfo.mIsUploadOrigin = z19;
            if (shuoshuoVideoInfo.mNeedProcess) {
                if (z19) {
                    str3 = "";
                    str4 = string4Uin;
                } else {
                    str3 = "";
                    str4 = string4Uin;
                }
                z17 = true;
                shuoshuoVideoInfo.mNeedProcess = z17;
            } else {
                str3 = "";
                str4 = string4Uin;
            }
            z17 = false;
            shuoshuoVideoInfo.mNeedProcess = z17;
        } else {
            str3 = "";
            str4 = string4Uin;
        }
        String stringExtra2 = intent4 != null ? intent4.getStringExtra("refer") : null;
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = "shuoshuoOther";
        }
        String str9 = stringExtra2;
        Map<String, String> z26 = ((LBSModule) hj(LBSModule.class)).z();
        if (z26 == null) {
            z26 = new HashMap<>();
        }
        Map<String, String> map = z26;
        if (this.L) {
            map.put(QZonePublishMoodRequest.EXT_INFO_KEY_DELETE_TIME, String.valueOf(86400L));
        }
        if (pk()) {
            String stringExtra3 = getIntent().getStringExtra(QZoneShareManager.QZONE_SHARE_EXTSTRING);
            Map<? extends String, ? extends String> hashMap3 = new HashMap<>();
            intent = intent4;
            try {
                JSONObject jSONObject = new JSONObject(stringExtra3);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Iterator it = keys;
                    String str10 = (String) keys.next();
                    str5 = str3;
                    try {
                        hashMap3.put(str10, jSONObject.getString(str10));
                        str3 = str5;
                        keys = it;
                    } catch (Exception e16) {
                        e = e16;
                        QZLog.e(f51340x6, "parse shareinfo error", e);
                        map.put(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, this.f45117n1);
                        if (hashMap3.size() > 0) {
                        }
                        map.putAll(hashMap2);
                        Map<String, String> uj5 = uj(Zi(map));
                        Font Yi = Yi();
                        String str11 = str4;
                        if (this.f51460g3 > 0) {
                        }
                        HashMap<String, String> Wl = Wl(new HashMap<>());
                        this.f45121o2 = false;
                        Wo();
                        com.qzone.publish.ui.model.c cVar = new com.qzone.publish.ui.model.c();
                        cVar.f51934b = str6;
                        cVar.f51936c = oj();
                        cVar.f51954p = uj5;
                        cVar.f51938d = this.Q4;
                        cVar.f51946h = this.I4;
                        cVar.f51947i = this.f51486u2;
                        cVar.f51948j = !z18 ? this.M0 : null;
                        cVar.f51949k = false;
                        cVar.f51950l = isChecked;
                        cVar.f51952n = this.S2;
                        cVar.f51953o = qZonePreUploadInfo;
                        cVar.f51955q = Yi;
                        cVar.V = this.O5;
                        cVar.f51956r = this.D0;
                        cVar.f51957s = this.f51457f3;
                        cVar.f51958t = this.f51460g3;
                        cVar.f51959u = this.k3;
                        cVar.f51960v = this.l3;
                        cVar.f51961w = stringExtra;
                        cVar.f51962x = this.M0;
                        cVar.f51964z = this.f45111l1;
                        cVar.C = this.f51489v5;
                        cVar.E = hashMap2;
                        cVar.I = str9;
                        cVar.L = Wl;
                        cVar.S = str7;
                        cVar.T = str11;
                        cVar.f51951m = this.f51444b4;
                        tp(cVar);
                        cVar.f51945g0 = this.f51459f6;
                        if (!this.f45090e1) {
                        }
                        dynamicArrayList = this.U;
                        if (dynamicArrayList != null) {
                            final ArrayList arrayList = new ArrayList(this.U);
                            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.38
                                @Override // java.lang.Runnable
                                public void run() {
                                    EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList.toArray());
                                }
                            });
                        }
                        this.f45120o1 = true;
                        if (this.I4 != null) {
                        }
                        dynamicArrayList2 = this.U;
                        if (dynamicArrayList2 != null) {
                        }
                        i3 = 0;
                        this.f45103i2 = i3;
                        intent2 = new Intent();
                        intent2.putExtra("finish_video_component", true);
                        if (!TextUtils.isEmpty(str6)) {
                        }
                        dynamicArrayList3 = this.U;
                        if (dynamicArrayList3 != null) {
                            intent2.putExtra("imageUrl", this.U);
                            while (i16 < 3) {
                                localMediaInfo = this.W.get(this.U.get(i16));
                                if (localMediaInfo != null) {
                                }
                            }
                        }
                        getActivity().setResult(-1, intent2);
                        if (!"android.intent.action.SEND".equals(getIntent().getAction())) {
                        }
                    }
                }
                str5 = str3;
            } catch (Exception e17) {
                e = e17;
                str5 = str3;
            }
            map.put(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, this.f45117n1);
            if (hashMap3.size() > 0) {
                map.putAll(hashMap3);
            }
        } else {
            str5 = str3;
            intent = intent4;
        }
        map.putAll(hashMap2);
        Map<String, String> uj52 = uj(Zi(map));
        Font Yi2 = Yi();
        String str112 = str4;
        if (this.f51460g3 > 0) {
            if (uj52 == null) {
                uj52 = new HashMap<>();
            }
            uj52.put(QZonePublishMoodRequest.EXT_INFO_KEY_DELETE_TIME, String.valueOf(this.f51460g3));
        }
        HashMap<String, String> Wl2 = Wl(new HashMap<>());
        this.f45121o2 = false;
        Wo();
        com.qzone.publish.ui.model.c cVar2 = new com.qzone.publish.ui.model.c();
        cVar2.f51934b = str6;
        cVar2.f51936c = oj();
        cVar2.f51954p = uj52;
        cVar2.f51938d = this.Q4;
        cVar2.f51946h = this.I4;
        cVar2.f51947i = this.f51486u2;
        cVar2.f51948j = !z18 ? this.M0 : null;
        cVar2.f51949k = false;
        cVar2.f51950l = isChecked;
        cVar2.f51952n = this.S2;
        cVar2.f51953o = qZonePreUploadInfo;
        cVar2.f51955q = Yi2;
        cVar2.V = this.O5;
        cVar2.f51956r = this.D0;
        cVar2.f51957s = this.f51457f3;
        cVar2.f51958t = this.f51460g3;
        cVar2.f51959u = this.k3;
        cVar2.f51960v = this.l3;
        cVar2.f51961w = stringExtra;
        cVar2.f51962x = this.M0;
        cVar2.f51964z = this.f45111l1;
        cVar2.C = this.f51489v5;
        cVar2.E = hashMap2;
        cVar2.I = str9;
        cVar2.L = Wl2;
        cVar2.S = str7;
        cVar2.T = str112;
        cVar2.f51951m = this.f51444b4;
        tp(cVar2);
        cVar2.f51945g0 = this.f51459f6;
        if (!this.f45090e1) {
            Xp(str6, cVar2);
        } else {
            Zp(cVar2);
        }
        dynamicArrayList = this.U;
        if (dynamicArrayList != null && dynamicArrayList.size() > 0) {
            final ArrayList arrayList2 = new ArrayList(this.U);
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.38
                @Override // java.lang.Runnable
                public void run() {
                    EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList2.toArray());
                }
            });
        }
        this.f45120o1 = true;
        if (this.I4 != null) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_UPLOAD, str2, null);
        }
        dynamicArrayList2 = this.U;
        if (dynamicArrayList2 != null || dynamicArrayList2.size() <= 0 || (hashMap = this.f45080b0) == null) {
            i3 = 0;
        } else {
            int i19 = 0;
            int i26 = 0;
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry != null && entry.getValue() != null) {
                    if (entry.getValue().intValue() == 2) {
                        i19++;
                    } else if (entry.getValue().intValue() == 1) {
                        i26++;
                    }
                }
            }
            IPanoramaUtil iPanoramaUtil = (IPanoramaUtil) QRoute.api(IPanoramaUtil.class);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.U.size());
            String str12 = str5;
            sb5.append(str12);
            i3 = 0;
            iPanoramaUtil.reportMta("upload_all_count", sb5.toString(), 0);
            ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_sphere", i19 + str12, 0);
            ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_cylinder", i26 + str12, 0);
        }
        this.f45103i2 = i3;
        intent2 = new Intent();
        intent2.putExtra("finish_video_component", true);
        if (!TextUtils.isEmpty(str6)) {
            intent2.putExtra("BULLET_CONTENT", str6);
        }
        dynamicArrayList3 = this.U;
        if (dynamicArrayList3 != null && dynamicArrayList3.size() > 0) {
            intent2.putExtra("imageUrl", this.U);
            for (i16 = 0; i16 < 3 && i16 < this.U.size(); i16++) {
                localMediaInfo = this.W.get(this.U.get(i16));
                if (localMediaInfo != null) {
                    if (localMediaInfo.isRecord) {
                        z16 = true;
                    } else {
                        z16 = true;
                        if (QAlbumUtil.getMediaType(localMediaInfo) != 1) {
                        }
                    }
                    intent2.putExtra(BaseProfileQZoneComponent.KEY_IS_VIDEO + i16, z16);
                }
            }
        }
        getActivity().setResult(-1, intent2);
        if (!"android.intent.action.SEND".equals(getIntent().getAction())) {
            Fo();
            return;
        }
        if (this.A2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.39
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishMoodActivity.this.Io(str6);
                }
            });
        }
        if (intent != null) {
            intent3 = intent;
            if (intent3.getBooleanExtra("key_back_to_friend_feed", false)) {
                if (this.f51348o6 == null) {
                    so.a aVar = new so.a(getActivity());
                    this.f51348o6 = aVar;
                    aVar.a();
                }
                this.f51348o6.b();
            }
        } else {
            intent3 = intent;
        }
        Fo();
        this.Y2.d();
        getActivity().sendBroadcast(new Intent(QZoneHelper.Constants.ACTION_SEND_MOOD_FINISH));
        Sp(oj());
        EventCenter.getInstance().post("WriteOperation", 62);
        if (this.f51457f3 > 0) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.40
                @Override // java.lang.Runnable
                public void run() {
                    EventCenter.getInstance().post("TimerShuoShuo", 2, (Object[]) null);
                }
            }, 2000L);
        }
        Np(QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_PUBLISH_CLICK, true);
        this.J1.E(false);
        pn(false);
        if (intent3 != null) {
            int intExtra = intent3.getIntExtra(QZoneHelper.Constants.KEY_PHOTO_EVENT_TYPE, -1);
            if (intExtra == 0) {
                PhotoGroupOptimizeFuncSwitcher.b(PhotoGroupOptimizeFuncSwitcher.f42531b);
            } else if (intExtra == 1) {
                PhotoGroupOptimizeFuncSwitcher.b(PhotoGroupOptimizeFuncSwitcher.f42532c);
            }
        }
        if (!TextUtils.isEmpty(this.f51499z5)) {
            QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_GUIDE_PAGE_PUBLISH);
        }
        if (this.f51494x5 || this.f51497y5) {
            QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_GIF_ICON_PUBLISH);
        }
        if (vp()) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 14, 1);
        }
        if (this.f51466j5) {
            LpReportInfo_pf00064.allReport(586, 2, 6);
        }
        dn();
    }

    protected void Zo() {
        if (this.A5) {
            String replace = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_MOOD_EVENT_TAG_JUMP_PAGE, QzoneConfig.QZONE_MOOD_EVENT_TAG_H5_URL, QzoneConfig.DefaultValue.QZONE_MOOD_ADD_EVENT_TAG_PAGE_H5_URL_DEFAULT).replace("{hostuin}", String.valueOf(LoginData.getInstance().getUin()));
            PublishEventTag publishEventTag = this.f51489v5;
            if (publishEventTag != null) {
                if (!TextUtils.isEmpty(publishEventTag.f45886id)) {
                    replace = replace + "&tagid=" + this.f51489v5.f45886id;
                } else {
                    replace = replace + "&tagid=0";
                }
            }
            yo.d.d(replace, getActivity(), null);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean ak() {
        boolean ak5 = super.ak();
        if (ak5) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).M(true);
        }
        return ak5;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    public void bq(HashMap<String, PicInfo> hashMap) {
        this.f51486u2 = hashMap;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, c5.a
    public boolean checkNetworkConnect() {
        if (super.checkNetworkConnect()) {
            return true;
        }
        getHandler().sendEmptyMessage(100001);
        return false;
    }

    protected void cq() {
        View view = this.f45119o0;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new aa());
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int dj() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getIntExtra("key_max_photo_count", com.qzone.publish.ui.model.b.f51929c);
        }
        return com.qzone.publish.ui.model.b.f51929c;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void dl(Bundle bundle) {
        super.dl(bundle);
        int i3 = bundle.getInt("mStateType");
        this.Z2 = i3;
        com.qzone.publish.ui.state.a e16 = com.qzone.publish.ui.state.a.e(i3, this);
        this.Y2 = e16;
        e16.q(this.J);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int ej() {
        return 10000;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void el(Bundle bundle) {
        super.el(bundle);
        bundle.putInt("mStateType", this.Z2);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void en(boolean z16) {
        ImageView imageView;
        this.I0 = z16;
        if (!z16 || (imageView = this.f51488v2) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        if (this.G && !this.f45090e1 && this.Y2 != null && this.U2 && Wj()) {
            this.Y2.o();
        }
        vi();
        if (this.Q5) {
            return;
        }
        super.finish();
        overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        com.qzone.publish.ui.state.a aVar = this.Y2;
        if (aVar != null) {
            aVar.c();
        }
        Jl();
        QzoneGuideBubbleHelper.g().f();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public int getAppId() {
        return WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FOLDER;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f169033bq1;
    }

    @Override // com.qzone.publish.ui.controller.a
    public String getCurrentUrl() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public Activity getHostActivity() {
        return null;
    }

    @Override // com.qzone.publish.ui.controller.a
    public WebViewFragment getHostFragment() {
        return null;
    }

    @Override // com.qzone.publish.ui.controller.a
    public WebView getHostWebView() {
        return null;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public Activity getRealActivity() {
        QZonePublishMoodTabActivity qZonePublishMoodTabActivity = this.f51441a5;
        if (qZonePublishMoodTabActivity != null) {
            return qZonePublishMoodTabActivity;
        }
        if (getActivity() == null || !(getActivity() instanceof QZonePublishMoodRealActivity)) {
            return null;
        }
        return getActivity();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public View getRoot() {
        return this.f51440a3;
    }

    @Override // com.qzone.publish.ui.controller.a
    public Share getShare() {
        return null;
    }

    @Override // com.qzone.publish.ui.controller.a
    public CustomWebView getWebView() {
        return null;
    }

    protected void gq(int i3) {
        this.f51467k5.setVisibility(i3);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void hl() {
        if (((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).F()) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).L(false);
        }
        super.hl();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void hm(final RelativeLayout relativeLayout) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.58
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodActivity.this.f51485t5 = m5.a.H().J(LoginData.getInstance().getUin(), 2656);
                if (QZonePublishMoodActivity.this.f51485t5 != null) {
                    File imageFile = ImageLoader.getInstance().getImageFile("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_2FkI4iOAWN.png");
                    if (imageFile != null && imageFile.exists()) {
                        QZonePublishMoodActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.58.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass58 anonymousClass58 = AnonymousClass58.this;
                                QZonePublishMoodActivity.this.Co(relativeLayout);
                            }
                        });
                        return;
                    } else {
                        ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_2FkI4iOAWN.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                        return;
                    }
                }
                if (ParticleManager.u()) {
                    File imageFile2 = ImageLoader.getInstance().getImageFile("https://qzonestyle.gtimg.cn/aoi/sola/20181029170118_ziGweKysMR.png");
                    if (imageFile2 != null && imageFile2.exists()) {
                        QZonePublishMoodActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.58.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass58 anonymousClass58 = AnonymousClass58.this;
                                QZonePublishMoodActivity.this.eq(relativeLayout);
                            }
                        });
                    } else {
                        ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20181029170118_ziGweKysMR.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                    }
                }
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void im(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f169032bq0, (ViewGroup) null);
        this.f51467k5 = inflate;
        inflate.setVisibility(4);
        linearLayout.addView(this.f51467k5, layoutParams);
    }

    @Override // com.qzone.publish.ui.controller.a
    public boolean isActivityResume() {
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void jk() {
        if (this.f45090e1) {
            this.f51492x2.setVisibility(8);
            return;
        }
        oq();
        kq();
        nq();
        dq(this.U5);
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_GIF_ICON_EXPLODE);
    }

    public void jp() {
        super.ck();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void kl(ArrayList<String> arrayList) {
        HashMap<String, PicInfo> hashMap = new HashMap<>();
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            String[] split = ((String) arrayList2.get(i3)).split("\\<");
            if (split.length == 1) {
                arrayList3.add(split[0]);
            } else if (split.length == 3) {
                PicInfo picInfo = new PicInfo();
                picInfo.imageId = split[2];
                picInfo.sourceType = 1;
                hashMap.put(split[1], picInfo);
                arrayList3.add(split[1]);
            } else if (split.length == 5) {
                PicInfo picInfo2 = new PicInfo();
                picInfo2.pic_url = split[1];
                picInfo2.imageId = split[2];
                try {
                    picInfo2.picwidth = Integer.valueOf(split[3]).intValue();
                    picInfo2.picheight = Integer.valueOf(split[4]).intValue();
                } catch (Throwable th5) {
                    QZLog.e(f51340x6, "failed to parse picInfo->picwidth/picheight.", th5);
                }
                picInfo2.sourceType = 2;
                hashMap.put(picInfo2.pic_url, picInfo2);
                arrayList3.add(picInfo2.pic_url);
            }
        }
        bq(hashMap);
        yl(arrayList3);
        xp();
    }

    public void kp() {
        View view = this.f51443b3;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f51457f3 = 0L;
        this.f51460g3 = 0L;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void lm() {
        QbossAdvDesc qbossAdvDesc = this.U5;
        if (qbossAdvDesc == null) {
            dq(qbossAdvDesc);
        }
    }

    public void lq() {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null) {
            extendEditText.setFocusable(true);
            this.f45104j0.requestFocus();
            this.f45104j0.setClearFocusOnBack(true);
            Ep(this.f45104j0.isFocused());
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void mn(boolean z16) {
        this.J1.E(z16);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void nm() {
        super.nm();
        ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).M(false);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void nn() {
        com.qzone.misc.network.report.b.k(this.U4);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean oi() {
        if (this.f45084c1 && !TextUtils.isEmpty(this.f45096g1)) {
            return super.oi();
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void ol() {
        com.qzone.publish.ui.state.a aVar = this.Y2;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void on() {
        com.qzone.misc.network.report.b.l(this.U4);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity, com.qzone.common.activities.base.PhotoActivity, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        PerfTracer.traceStart(PerfTracer.PUBLISHMOOD_ONCREATE);
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 62);
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 63);
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 64);
        EventCenter.getInstance().addUIObserver(this, "NewCardSkinFollowFeeds", 2);
        EventCenter.getInstance().addUIObserver(this, "FontQbossGifShow", 2);
        this.V2 = System.currentTimeMillis();
        this.S0 = 1;
        this.U4 = ro.a.a(getIntent());
        getWindow().setSoftInputMode(3);
        Intent intent = getIntent();
        this.f51445b5 = intent.getBooleanExtra(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, false);
        this.f51465i5 = intent.getBooleanExtra(QZoneJsConstants.DYNAMIC_ALBUM_IS_FROM_DRAFT, false);
        this.V5 = intent.getStringExtra("shareSource");
        this.W5 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE);
        this.X5 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME);
        this.f51466j5 = intent.getBooleanExtra(QZoneJsConstants.WRITE_MOOD_FROM_PROFILE_CARD, false);
        PerfTracer.traceStart(PerfTracer.PUBLISHMOOD_INITUI);
        this.I1.h(getIntent());
        Bundle bundle2 = QZonePublishMoodBaseActivity.f51439h6;
        if (bundle2 != null) {
            dl(bundle2);
        } else {
            sp(intent);
        }
        if (intent.getBooleanExtra("key_from_kuolie", false)) {
            this.F1 = true;
        }
        Yo(intent);
        initConfig();
        initUI();
        if (intent.getBooleanExtra(QZoneShareManager.QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION, false)) {
            if (QZonePermission.requestStoragePermission(getRealActivity(), new k(intent), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_READ_MEDIA)) {
                No(intent);
            }
        } else {
            No(intent);
        }
        PerfTracer.traceEnd(PerfTracer.PUBLISHMOOD_ONCREATE);
        if (this.f45084c1) {
            com.qzone.misc.network.report.e.a(1, this.U4);
        } else {
            com.qzone.misc.network.report.e.a(3, this.U4);
        }
        com.qzone.misc.network.report.b.h(this.U4, intent);
        Np(QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_EXPLODE, false);
        HashMap hashMap = new HashMap();
        hashMap.put("publishMoodExplose", String.valueOf(1));
        ReportUtils.b("guessPhoto", hashMap);
        m5.a.H().F(2748, true);
        this.I1.i();
        Mp();
        if (QZLog.isColorLevel()) {
            QZLog.d("publishmood_time_tag" + f51340x6, 2, "onActivityCreated");
        }
        bn();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        PublishEventTag publishEventTag;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 6000) {
            com.qzone.publish.ui.state.a aVar = this.Y2;
            if (aVar != null) {
                aVar.q(false);
            }
            this.J1.y();
            Dn();
        }
        if (i3 == 23333333 && i16 != 0) {
            Uj(i3);
            return;
        }
        if (i3 != 23333333 && i16 == 0) {
            Uj(i3);
            return;
        }
        if (i16 == 8215 && i3 == 6000) {
            Uj(i3);
            return;
        }
        if (i3 != com.qzone.publish.ui.model.b.f51928b) {
            if (i3 == 200) {
                ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).z();
                if (i16 == -1) {
                    Hp(intent);
                }
            }
            if (i3 == 999 && i16 == -1) {
                this.K4.setText(getResources().getString(R.string.gls));
                this.J4.setText(getResources().getString(R.string.glt));
            }
            if (i3 == 1210 && i16 == -1 && (publishEventTag = (PublishEventTag) ParcelableWrapper.getDataFromeIntent(intent, "publish_event_tag_intent_key")) != null) {
                iq(publishEventTag);
            }
            if (i3 == 6004 && i16 == -1) {
                this.f51457f3 = intent.getLongExtra("SchedualPublishTime", 0L);
                long longExtra = intent.getLongExtra("SchedualDeleteTime", 0L);
                this.f51460g3 = longExtra;
                Bq(this.f51457f3, longExtra);
            }
            if (i3 == 20226 && i16 == -1) {
                Fo();
            }
            if (i3 == 10001 && i16 == -1) {
                bp(intent);
            }
            Mp();
            return;
        }
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
                this.k3 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE, 1);
            }
            if (extras.containsKey("uin_list")) {
                if (this.l3 == null) {
                    this.l3 = new ArrayList<>();
                }
                this.l3.clear();
                ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
                if (stringArrayList != null) {
                    this.l3.addAll(stringArrayList);
                }
            }
            if (this.k3 == 64) {
                if (this.f51478r3 || this.f51481s3 || this.f51484t3 || this.f51496y3 || this.f51444b4) {
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastPerssionShuoshuoCannotSync", "\u5df2\u8bbe\u7f6e\u6743\u9650\u7684\u8bf4\u8bf4\u4e0d\u80fd\u8fdb\u884c\u540c\u6b65"), 3);
                }
                this.f51478r3 = false;
                this.f51481s3 = false;
                this.f51484t3 = false;
                this.f51496y3 = false;
                this.f51444b4 = false;
            }
            if (com.qzone.feed.utils.h.h(this.k3)) {
                this.m3 = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
                this.n3 = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
            }
            com.qzone.publish.ui.state.a aVar2 = this.Y2;
            if (aVar2 != null) {
                aVar2.j(this.k3);
            }
            Cq();
            Dn();
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.publish.ui.controller.a
    public void onBack() {
        ck();
        this.Y2.r();
        if (vp()) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 14, 2);
        }
        if (this.f51466j5) {
            LpReportInfo_pf00064.allReport(586, 3, 6);
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity, com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
        so.a aVar = this.f51348o6;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f51343j6 != null) {
            getRealActivity().unregisterReceiver(this.f51343j6);
        }
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this.f51355v6);
        QzoneGuideBubbleHelper.g().f();
        super.onDestroy();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment
    protected void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message != null && message.what == 2542) {
            QZoneResult unpack = QZoneResult.unpack(message);
            if (unpack == null) {
                QZLog.e(f51340x6, "onHandleMessage result is null");
            } else {
                Ap((Bundle) unpack.getData());
            }
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        PerfTracer.traceStart(PerfTracer.PUBLISHMOOD_ONRESUME);
        ui();
        qi();
        Jo();
        Im();
        Fn(kn());
        super.onResume();
        Aq();
        PerfTracer.traceEnd(PerfTracer.PUBLISHMOOD_ONRESUME);
        PerfTracer.traceClick2Completed(this);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ik();
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (201 == qZoneTask.mType) {
            ap(qZoneTask);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            Intent intent = getIntent();
            if (intent != null && intent.getBooleanExtra("key_show_input_panel", false)) {
                intent.removeExtra("key_show_input_panel");
                ExtendEditText extendEditText = this.f45104j0;
                if (extendEditText != null) {
                    extendEditText.setFocusable(true);
                    this.f45104j0.requestFocus();
                    this.f45104j0.setClearFocusOnBack(true);
                    getHandler().postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            ExtendEditText extendEditText2 = QZonePublishMoodActivity.this.f45104j0;
                            if (extendEditText2 != null) {
                                Editable text = extendEditText2.getText();
                                QZonePublishMoodActivity.this.f45104j0.setSelection(text != null ? text.length() : 0);
                            }
                            QZonePublishMoodActivity.this.showKeyboard();
                        }
                    }, 300L);
                    return;
                }
                return;
            }
            if (intent != null && intent.getExtras() != null && TextUtils.equals(intent.getExtras().getString("showFont"), "1")) {
                intent.getExtras().remove("showFont");
                pm();
                return;
            }
            if (intent != null) {
                if ("1".equals(intent.getStringExtra("showFont"))) {
                    this.f45098h0.setBottomTab(0);
                    intent.removeExtra("showFont");
                    pm();
                } else if ("sparkle".equals(intent.getStringExtra("inputTab"))) {
                    this.f45098h0.setBottomTab(1);
                    intent.removeExtra("inputTab");
                    pm();
                }
            }
        }
    }

    @Override // com.qzone.publish.ui.controller.a
    public void pd(QZonePublishMoodTabActivity qZonePublishMoodTabActivity) {
        this.f51441a5 = qZonePublishMoodTabActivity;
    }

    @Override // com.qzone.publish.ui.controller.a
    public int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
        return 0;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void pm() {
        super.pm();
        this.T5 = false;
        if (this.U5 != null) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(this.U5.res_traceinfo, LoginData.getInstance().getUinString());
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void pn(final boolean z16) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.57
            @Override // java.lang.Runnable
            public void run() {
                if (QZonePublishMoodActivity.this.V2 != -1) {
                    System.currentTimeMillis();
                    long j3 = QZonePublishMoodActivity.this.V2;
                }
                if (QZonePublishMoodActivity.this.W2 != -1) {
                    System.currentTimeMillis();
                    long j16 = QZonePublishMoodActivity.this.W2;
                }
                if (QZonePublishMoodActivity.this.Vi().length() > 0) {
                    QZonePublishMoodActivity.this.E5 |= 8;
                }
                if (QZonePublishMoodActivity.this.U != null) {
                    int i3 = 0;
                    for (int i16 = 0; i16 < QZonePublishMoodActivity.this.U.size(); i16++) {
                        QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                        LocalMediaInfo localMediaInfo = qZonePublishMoodActivity.W.get(qZonePublishMoodActivity.U.get(i16));
                        if (localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                            i3++;
                        } else if (localMediaInfo != null) {
                            QAlbumUtil.getMediaType(localMediaInfo);
                        }
                    }
                    if (i3 > 0) {
                        QZonePublishMoodActivity.this.E5 |= 4;
                    }
                    try {
                        Iterator<String> it = QZonePublishMoodActivity.this.U.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (JpegExifReader.isCrashJpeg(next)) {
                                QLog.d(QZonePublishMoodActivity.f51340x6, 4, QZonePublishMoodActivity.f51340x6 + "#reportShuoshuoBehavior photo exif date info parse exception");
                            } else {
                                ExifInterface exifInterface = new ExifInterface(next);
                                boolean z17 = (exifInterface.getAttribute("GPSLatitude") != null) | (exifInterface.getAttribute("GPSLongitude") != null) | (exifInterface.getAttribute("DateTime") != null) | (exifInterface.getAttribute("Make") != null) | (exifInterface.getAttribute("Model") != null);
                            }
                        }
                    } catch (IOException unused) {
                        QZLog.e(QZonePublishMoodActivity.f51340x6, "reportShuoshuoBehavior gets IOException when reading exif data");
                    }
                }
                QZonePublishMoodActivity qZonePublishMoodActivity2 = QZonePublishMoodActivity.this;
                if (qZonePublishMoodActivity2.f51489v5 != null) {
                    qZonePublishMoodActivity2.E5 |= 2;
                }
                MoodPicLabel moodPicLabel = qZonePublishMoodActivity2.f51472o5;
                if (moodPicLabel != null && moodPicLabel.isSelected()) {
                    QZonePublishMoodActivity qZonePublishMoodActivity3 = QZonePublishMoodActivity.this;
                    qZonePublishMoodActivity3.E5 = 1 | qZonePublishMoodActivity3.E5;
                }
                if (z16) {
                    QZonePublishMoodActivity.this.E5 |= 16;
                }
                if (((PhotoActivity) QZonePublishMoodActivity.this).J1.w() != null) {
                    QZonePublishMoodActivity.this.E5 |= 32;
                }
            }
        });
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void rn() {
        if (this.f51446b6 == null) {
            Qm();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Pair<String, String>> entry : this.f51446b6.entrySet()) {
                String key = entry.getKey();
                Pair<String, String> value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    String str = (String) value.first;
                    String str2 = (String) value.second;
                    jSONObject.put(URLEncoder.encode(key, "UTF-8"), str + "_" + str2);
                }
            }
            u5.b.x0("peitu_entry_sourceid", jSONObject.toString(), LoginData.getInstance().getUin());
        } catch (UnsupportedEncodingException e16) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 1, e16, new Object[0]);
        } catch (JSONException e17) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 1, e17, new Object[0]);
        }
    }

    @Override // com.qzone.publish.ui.controller.a
    public boolean setShareUrl(String str) {
        return false;
    }

    @Override // com.qzone.publish.ui.controller.a
    public boolean setSummary(String str, String str2, String str3, String str4, Bundle bundle) {
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            onResume();
        } else {
            onPause();
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    protected void sn() {
        RelativeLayout relativeLayout = this.f51440a3;
        if (relativeLayout == null || this.J2 == null || this.L2 == null) {
            return;
        }
        int[] iArr = new int[2];
        relativeLayout.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.J2.getLocationOnScreen(iArr2);
        int measuredHeight = (iArr2[1] - iArr[1]) + this.J2.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.L2.getLayoutParams();
        layoutParams.setMargins(iArr2[0], measuredHeight, 0, 0);
        this.L2.setLayoutParams(layoutParams);
    }

    @Override // com.qzone.publish.ui.controller.a
    public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
        return 0;
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void tn(String str) {
        ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).H = str;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void ui() {
        super.ui();
        QZonePublishMoodTabActivity qZonePublishMoodTabActivity = this.f51441a5;
        if (qZonePublishMoodTabActivity != null && qZonePublishMoodTabActivity.T2() != null) {
            this.f51441a5.T2().setEnabled(Mi());
            return;
        }
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || aVar.u() == null) {
            return;
        }
        this.C.u().setEnabled(Mi());
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void un(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        this.I4 = shuoshuoVideoInfo;
    }

    @Override // com.qzone.publish.ui.controller.a
    public String v0() {
        return null;
    }

    protected void vq() {
        if (this.f51481s3) {
            this.Q5 = true;
            ClickReport.q(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, "1", "1", true);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.42
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
                    qZonePublishMoodActivity.uq(qZonePublishMoodActivity.Vi());
                }
            });
        }
    }

    @Override // com.qzone.publish.ui.controller.a
    public String w() {
        return null;
    }

    protected void wq(ArrayList<String> arrayList) {
        if (!this.f51481s3 || arrayList == null || arrayList.size() == 0) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList(arrayList);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.43
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList3 = arrayList2;
                if (arrayList3 == null || arrayList3.size() == 0) {
                    return;
                }
                ArrayList<File> arrayList4 = new ArrayList<>();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (URLUtil.isNetworkUrl(str)) {
                        File imageFile = ImageLoader.getInstance().getImageFile(str);
                        if (imageFile != null && imageFile.exists()) {
                            arrayList4.add(imageFile);
                        }
                    } else {
                        arrayList4.add(new File(str));
                    }
                    if (arrayList4.size() >= 9) {
                        break;
                    }
                }
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareMutilPicToWehat(BaseApplication.getContext(), arrayList4);
            }
        });
    }

    @Override // com.qzone.publish.ui.controller.a
    public void x4() {
        jp();
    }

    public void xp() {
        String[] split;
        String j06 = u5.b.j0("peitu_entry_sourceid", "", LoginData.getInstance().getUin());
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(j06);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString = jSONObject.optString(str);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(str) && (split = optString.split("_")) != null && split.length == 2) {
                    hashMap.put(URLDecoder.decode(str, "UTF-8"), new Pair(split[0], split[1]));
                }
            }
        } catch (UnsupportedEncodingException e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, 1, e16, new Object[0]);
        } catch (JSONException e17) {
            QZLog.e(QZLog.TO_DEVICE_TAG, 1, e17, new Object[0]);
        }
        this.f51446b6.clear();
        this.f51446b6.putAll(hashMap);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean yk() {
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean zk() {
        return true;
    }

    public void zp() {
        if (u5.b.H("show_video_vip_tips", 1, LoginData.getInstance().getUin()) == 0) {
            return;
        }
        QZLog.i(f51340x6, 4, "send req loadVideoVipTipsInfos");
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), 2454), getHandler(), this, 201));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements DynamicGridView.t {
        f() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.t
        public void onEditModeChanged(boolean z16) {
            if (!z16 || QZonePublishMoodActivity.this.T.e0()) {
                return;
            }
            QZonePublishMoodActivity.this.T.L(true);
        }
    }

    /* loaded from: classes39.dex */
    class l implements TextWatcher {
        l() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (obj.equals(QZonePublishMoodActivity.this.f51345l6)) {
                return;
            }
            QZonePublishMoodActivity.this.f51345l6 = obj;
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            QZonePublishMoodActivity qZonePublishMoodActivity = QZonePublishMoodActivity.this;
            if (!qZonePublishMoodActivity.F5) {
                qZonePublishMoodActivity.D5.append(1);
                QZonePublishMoodActivity.this.F5 = true;
            }
            ((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).C(obj);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null || !charSequence.toString().equals(QZonePublishMoodActivity.this.f51346m6)) {
                if (charSequence != null) {
                    QZonePublishMoodActivity.this.f51346m6 = charSequence.toString();
                }
                if (((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).A() == 0) {
                    ((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).D();
                    ((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).L(false);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp() {
        int i3;
        this.f45128r1 = -1;
        if (oj().size() < dj()) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).z();
            tm();
            if (this.f45079a2 && this.J1.B()) {
                i3 = 1;
            } else {
                i3 = (this.f45079a2 && this.J1.C()) ? 2 : 3;
            }
            LpReportInfo_pf00064.allReport(586, 40, i3);
            if (!TextUtils.isEmpty(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHUOSHUO_CAMERA_ICON, ""))) {
                LpReportInfo_pf00064.allReport(586, 40, 4);
            }
        }
        Dp();
    }

    private boolean Go() {
        int[] iArr = new int[2];
        this.f51468l5.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        getRoot().getLocationInWindow(iArr2);
        int height = getRoot().getHeight();
        int height2 = this.f51468l5.getHeight();
        int height3 = this.f45125q0.getHeight();
        if (height3 == 0) {
            height3 = this.f45125q0.getMeasuredHeight();
        }
        return iArr[1] + height2 > (iArr2[1] + height) - height3 && !this.f45090e1;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Cm(ArrayList<String> arrayList, ConcurrentHashMap<String, String> concurrentHashMap, String str) {
        this.f45121o2 = false;
        int gj5 = gj();
        int i3 = this.f45084c1 ? 2 : 5;
        boolean z16 = !QZoneVideoCommonUtils.getTrimSupport().isAvailable();
        this.f51445b5 = getIntent().getBooleanExtra(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, false);
        boolean A = this.J1.A();
        int i16 = this.S1 == 1 ? 1 : i3;
        QZonePublishMoodTabActivity qZonePublishMoodTabActivity = this.f51441a5;
        if (qZonePublishMoodTabActivity != null) {
            int dj5 = dj() - gj5;
            HashMap<String, PicInfo> hashMap = this.A0;
            return cl(qZonePublishMoodTabActivity, arrayList, dj5 + (hashMap != null ? hashMap.size() : 0), false, i16, z16, concurrentHashMap, this.f51445b5, A, str);
        }
        Activity realActivity = getRealActivity();
        int dj6 = dj() - gj5;
        HashMap<String, PicInfo> hashMap2 = this.A0;
        return cl(realActivity, arrayList, dj6 + (hashMap2 != null ? hashMap2.size() : 0), false, i16, z16, concurrentHashMap, this.f51445b5, A, str);
    }

    protected void Fo() {
        this.U2 = false;
        finish();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void fl() {
        ClickReport.e(311, "publishmood", 309, 4, 306);
        super.fl();
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void gn() {
        this.J0 = true;
        ImageView imageView = this.f51488v2;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void ik() {
        gq(4);
        if (this.f45090e1) {
            return;
        }
        this.f51468l5.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class v implements QQProgressDialog.b {
        v() {
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            ToastUtil.s(com.qzone.util.l.a(R.string.s5z), 3);
            QZonePublishMoodActivity.this.Q5 = false;
            QZonePublishMoodActivity.this.Fo();
        }
    }

    private void aq(l5.a aVar) {
        if (aVar == null || aVar.openBusiness != 1 || TextUtils.isEmpty(aVar.businessURL) || TextUtils.isEmpty(aVar.imageUrl)) {
            return;
        }
        ImageLoader.getInstance().loadImageAsync(aVar.imageUrl, new AnonymousClass8(aVar.businessURL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq() {
        View view = this.C4;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (this.D4 == null) {
            this.D4 = (RelativeLayout) ((ViewStub) $(R.id.iul)).inflate();
        }
        this.D4.setOnClickListener(this);
        this.E4 = (TextView) $(this.D4, R.id.ium);
        com.qzone.publish.ui.model.e eVar = this.L4;
        if (eVar == null) {
            return;
        }
        String str = eVar.f51975a;
        long j3 = eVar.f51977c;
        final String str2 = eVar.f51978d;
        if (j3 <= 0 || str == null || str.length() <= 0) {
            return;
        }
        u5.b.r0("show_video_vip_tips", 0, LoginData.getInstance().getUin());
        QzoneGuideBubbleHelper.g().k(getActivity(), this.G4, str, 0, 14.0f, 5.0d, 10.0d, 1000 * j3, -15550475, false, true, ViewUtils.dpToPx(4.0f));
        QZLog.i(f51340x6, 1, "show tips");
        if (str2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.47
                @Override // java.lang.Runnable
                public void run() {
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(str2, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        RedDotImageView redDotImageView;
        if (this.f51482s5 != null && this.f51485t5 != null && (redDotImageView = this.f45113m0) != null) {
            int[] iArr = new int[2];
            redDotImageView.getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            getRoot().getLocationInWindow(iArr2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            this.f45116n0.startAnimation(scaleAnimation);
            this.f45113m0.setVisibility(4);
            this.f45116n0.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f51482s5.getLayoutParams();
            layoutParams.width = ar.e(148.0f);
            int e16 = ar.e(43.0f);
            layoutParams.height = e16;
            layoutParams.topMargin = (iArr[1] - iArr2[1]) - e16;
            layoutParams.leftMargin = ((iArr[0] - iArr2[0]) - (layoutParams.width / 2)) + ar.e(23.0f);
            this.f51482s5.bringToFront();
            this.f51482s5.requestLayout();
            this.f51482s5.setVisibility(0);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(280L);
            scaleAnimation2.setStartOffset(280L);
            this.f51482s5.startAnimation(scaleAnimation2);
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.f51485t5.res_traceinfo, LoginData.getInstance().getUinString());
            VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.24
                @Override // java.lang.Runnable
                public void run() {
                    m5.a.H().C(LoginData.getInstance().getUinString(), 2656);
                    QZonePublishMoodActivity.this.f51485t5 = null;
                }
            });
            runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.25
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishMoodActivity.this.Ro();
                }
            }, 1600L);
            return;
        }
        RedDotImageView redDotImageView2 = this.f45113m0;
        if (redDotImageView2 != null) {
            redDotImageView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq() {
        RedDotImageView redDotImageView;
        if (this.f51487u5 != null && (redDotImageView = this.f45113m0) != null) {
            int[] iArr = new int[2];
            redDotImageView.getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            getRoot().getLocationInWindow(iArr2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            this.f45116n0.startAnimation(scaleAnimation);
            this.f45113m0.setVisibility(4);
            this.f45116n0.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f51487u5.getLayoutParams();
            layoutParams.width = ar.e(223.0f);
            int e16 = ar.e(43.0f);
            layoutParams.height = e16;
            layoutParams.topMargin = (iArr[1] - iArr2[1]) - e16;
            layoutParams.leftMargin = ((iArr[0] - iArr2[0]) - (layoutParams.width / 2)) + ar.e(23.0f);
            this.f51487u5.bringToFront();
            this.f51487u5.requestLayout();
            this.f51487u5.setVisibility(0);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(280L);
            scaleAnimation2.setStartOffset(280L);
            this.f51487u5.startAnimation(scaleAnimation2);
            ClickReport.q("46", "12", "8", true);
            ParticleManager.M(getActivity(), false);
            runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.27
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishMoodActivity.this.So();
                }
            }, 1600L);
            return;
        }
        RedDotImageView redDotImageView2 = this.f45113m0;
        if (redDotImageView2 != null) {
            redDotImageView2.setVisibility(0);
        }
    }

    private boolean Wp(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && (next.endsWith("jpg") || next.endsWith(MimeHelper.IMAGE_SUBTYPE_JPEG) || next.endsWith("bmp") || next.endsWith(MimeHelper.IMAGE_SUBTYPE_BITMAP) || next.endsWith("png") || next.endsWith("gif"))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void ip() {
        $(R.id.iuj).setVisibility(8);
        $(R.id.j9s).setVisibility(0);
        $(R.id.f0x).setVisibility(8);
        $(R.id.f0y).setVisibility(8);
        $(R.id.itq).setVisibility(8);
        kp();
    }

    private void np() {
        this.f51440a3 = (RelativeLayout) $(R.id.hkh);
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.T3(R.string.gd5, this.f51342i6);
            this.C.P(R.string.d7o, this.f51356w6, false);
            this.C.x().setTextSize(17.0f);
            this.C.u().setTextSize(17.0f);
        }
        ExtendEditText extendEditText = (ExtendEditText) $(R.id.itv);
        this.f45104j0 = extendEditText;
        extendEditText.setFixedHeight(true);
        if (Bp()) {
            ((UrlExtendEditText) this.f45104j0).setInputUrlListener(new i());
        }
        ExtendScrollView extendScrollView = (ExtendScrollView) $(R.id.l57);
        this.M = extendScrollView;
        extendScrollView.b(R.id.itv);
        this.M.setOnDownListener(this.f45112l2);
        Yh();
        if (!this.f45090e1) {
            ai();
            Tl();
        }
        this.f45119o0 = $(R.id.hrp);
        cq();
        this.f45122p0 = $(R.id.hrq);
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_SHUOSHUO_TOOLBAR_SHOW_DONGGANYINGJI, 0);
        this.f45122p0.setOnClickListener(this);
        int config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_CLOSE_DYNAMIC, 0);
        if (config > 0 && config2 != 1 && !this.f45090e1) {
            this.f45119o0.setVisibility(8);
            this.f45122p0.setVisibility(0);
        }
        this.f45110l0 = (ImageView) $(R.id.ius);
        Sl();
        Ul();
        View $ = $(R.id.dwc);
        this.I2 = $;
        $.setOnClickListener(this);
        CheckBox checkBox = (CheckBox) $(R.id.dw9);
        this.H2 = checkBox;
        checkBox.setOnClickListener(this);
        if (this.X4) {
            this.I2.setVisibility(0);
        } else {
            this.f51496y3 = false;
            this.H2.setChecked(false);
            this.I2.setVisibility(8);
        }
        this.K2 = $(R.id.f85294ok);
        this.L2 = $(R.id.f166118yr0);
        this.M2 = (ImageView) $(R.id.y_0);
        this.N2 = (ImageView) $(R.id.y9z);
        this.O2 = (TextView) $(R.id.f1063768j);
        this.K2.setOnClickListener(this);
        CheckBox checkBox2 = (CheckBox) $(R.id.f85284oj);
        this.J2 = checkBox2;
        checkBox2.setOnClickListener(this);
        if (this.Y4) {
            this.K2.setVisibility(0);
        } else {
            this.f51444b4 = false;
            this.J2.setChecked(false);
            this.K2.setVisibility(8);
        }
        View $2 = $(R.id.iuw);
        this.B2 = $2;
        $2.setOnClickListener(this);
        CheckBox checkBox3 = (CheckBox) $(R.id.iuv);
        this.C2 = checkBox3;
        checkBox3.setOnClickListener(this);
        if (this.V4 && !this.f45090e1) {
            View $3 = $(R.id.iuu);
            this.D2 = $3;
            $3.setVisibility(0);
            this.D2.setOnClickListener(this);
            CheckBox checkBox4 = (CheckBox) $(R.id.iut);
            this.E2 = checkBox4;
            checkBox4.setOnClickListener(this);
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(84, 21, 1), false, false);
        }
        View $4 = $(R.id.iuy);
        this.F2 = $4;
        $4.setOnClickListener(this);
        CheckBox checkBox5 = (CheckBox) $(R.id.iux);
        this.G2 = checkBox5;
        checkBox5.setOnClickListener(this);
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        if (this.f51465i5) {
            this.F2.setVisibility(8);
        } else if (iQzoneShareApi.isWXinstalled() && iQzoneShareApi.isWxSupportTimeLine()) {
            this.F2.setVisibility(0);
        } else {
            this.F2.setVisibility(8);
        }
    }

    private void op() {
        this.N = (ViewGroup) $(R.id.fpg);
        this.Q = (AsyncMarkGifImageView) $(R.id.dwb);
        this.R = (TextView) $(R.id.a4g);
        this.S = (TextView) $(R.id.k7m);
        this.R.setBackgroundColor(Color.argb(13, 0, 0, 0));
        DynamicGridView dynamicGridView = (DynamicGridView) $(R.id.fpf);
        this.P = dynamicGridView;
        dynamicGridView.setNumColumns(3);
        this.P.setTranscriptMode(1);
        this.P.setOnItemClickListener(new c());
        this.Q.setOnClickListener(new d());
        this.T = new e9.a(getActivity(), this.P, 2, 1.15f, 0);
        if (pk()) {
            this.T.q0(true);
        }
        this.T.y0(new e());
        this.P.setAdapter((ListAdapter) this.T);
        this.P.setLetParentInterceptTouchEventAt23(false);
        this.P.setEditModeEnabled(true);
        this.P.setOnEditModeChangeListener(new f());
        if (this.f45134u1) {
            this.T.H0(0);
            this.f45134u1 = false;
        }
        this.P.setOnDragListener(new g());
        this.M.b(this.P.getId());
        this.M.a(this.P.getId());
        this.D0 = v5.a.a().d(ImageQualityPreference.TYPE_SHUOSHUO_ALL_PIC);
        this.T2 = (RelativeLayout) $(R.id.fpj);
        this.O4 = $(R.id.br6);
        AsyncImageView asyncImageView = (AsyncImageView) $(R.id.br7);
        this.P4 = asyncImageView;
        asyncImageView.setOnClickListener(new h());
        View $ = $(R.id.f164258p8);
        this.B0 = $;
        com.qzone.album.ui.widget.g gVar = new com.qzone.album.ui.widget.g(this.T2, $, this.D0);
        this.C0 = gVar;
        gVar.d(this.f51352s6);
        this.C0.f(false);
    }

    private void rp() {
        this.f51468l5 = $(R.id.itn);
        this.f51469m5 = (MoodPicLabel) $(R.id.f0x);
        this.f51472o5 = (MoodPicLabel) $(R.id.f0z);
        this.f51477q5 = (MoodPicLabel) $(R.id.f166325f11);
        this.f51470n5 = (MoodPicLabel) this.f51467k5.findViewById(R.id.f0y);
        this.f51475p5 = (MoodPicLabel) this.f51467k5.findViewById(R.id.f166324f10);
        this.f51480r5 = (MoodPicLabel) this.f51467k5.findViewById(R.id.f166326f12);
        this.f51469m5.setOnClickListener(this);
        this.f51472o5.setOnClickListener(this);
        this.f51477q5.setOnClickListener(this);
        this.f51470n5.setOnClickListener(this);
        this.f51475p5.setOnClickListener(this);
        this.f51480r5.setOnClickListener(this);
    }

    private void up() {
        String string;
        this.f51451d4 = $(R.id.kt9);
        this.f51479r4 = (TextView) $(R.id.kqr);
        AsyncImageView asyncImageView = (AsyncImageView) $(R.id.kt_);
        this.f51474p4 = asyncImageView;
        asyncImageView.setOnClickListener(new ac());
        this.C4 = $(R.id.ktc);
        this.F4 = (TextView) $(R.id.kte);
        Switch r06 = (Switch) $(R.id.ktd);
        this.G4 = r06;
        r06.setOnCheckedChangeListener(new a());
        this.J4 = (TextView) $(R.id.ktn);
        this.K4 = (Button) $(R.id.ktm);
        this.J4 = (TextView) $(R.id.ktn);
        this.K4 = (Button) $(R.id.ktm);
        long longValue = Long.valueOf(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT, String.valueOf(1048576000L))).longValue();
        this.M4 = longValue;
        String format = String.format(getResources().getString(R.string.glt), Integer.valueOf((int) ((longValue / 1024) / 1024)));
        if (Lo()) {
            string = getResources().getString(R.string.gls);
            this.K4.setEnabled(true);
        } else {
            string = getResources().getString(R.string.glr);
            this.K4.setEnabled(true);
        }
        this.J4.setText(format);
        this.K4.setText(string);
        this.K4.getPaint().setFakeBoldText(true);
        this.K4.setOnClickListener(new b());
    }

    public void Lp(Map<String, String> map) {
        if (map == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        if (oj() != null) {
            Iterator<String> it = oj().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.f51446b6.containsKey(next)) {
                    Pair<String, String> pair = this.f51446b6.get(next);
                    String str = (String) pair.first;
                    String str2 = (String) pair.second;
                    sb5.append(str);
                    sb5.append("_");
                    sb6.append(str2);
                    sb6.append("_");
                }
            }
        }
        int length = sb5.length();
        int length2 = sb6.length();
        if (length < 1 || length <= 1) {
            return;
        }
        sb5.delete(length - 1, length);
        sb6.delete(length2 - 1, length2);
        map.put("peitu_entrance", sb5.toString());
        map.put("peitu_source", sb6.toString());
        if (QZLog.isColorLevel()) {
            QZLog.d(f51340x6, 2, "peitu_entrance:", sb5.toString(), ",peitu_source:", sb6.toString());
        }
    }

    public void Pp(final ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodActivity.56
            @Override // java.lang.Runnable
            public void run() {
                long uin = LoginData.getInstance().getUin();
                ShuoshuoVideoInfo shuoshuoVideoInfo2 = shuoshuoVideoInfo;
                boolean z16 = shuoshuoVideoInfo2.mNeedProcess;
                long j3 = shuoshuoVideoInfo2.mSize;
                int networkType = NetworkState.getNetworkType();
                HashMap hashMap = new HashMap();
                hashMap.put("extra_network_type", networkType + "");
                hashMap.put("extra_file_size", j3 + "");
                hashMap.put("extra_quality", (z16 ? 1 : 0) + "");
                shuoshuoVideoInfo.perfKey = UUID.randomUUID().toString();
                QzoneVideoPerfReport.a(shuoshuoVideoInfo.perfKey, 0).c(uin, "event_extra", hashMap);
                QzoneVideoUploadActionReport.b().d(shuoshuoVideoInfo.mVideoPath, "start_publish", 0);
            }
        });
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public String Sm() {
        return getString(R.string.f173026gk2);
    }

    protected void initData(Intent intent) {
        RelativeLayout relativeLayout;
        ExtendEditText extendEditText;
        if (intent == null) {
            return;
        }
        this.T4 = intent.hasExtra("PasterConstants.intent_params_refer");
        this.f51499z5 = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.GUIDE_REFER_FLAG);
        if (!TextUtils.isEmpty(intent.getStringExtra("mood_web_pic_url"))) {
            Hp(intent);
        }
        this.S4 = new ShuoshuoContent();
        this.Y2.i(intent);
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_operate_mood_hint");
        if (TextUtils.isEmpty(charSequenceExtra)) {
            super.Gk();
            if (this.F1) {
                String string4Uin = LocalMultiProcConfig.getString4Uin("kuoliehint_text", getString(R.string.w6g), LoginData.getInstance().getUin());
                ExtendEditText extendEditText2 = this.f45104j0;
                if (extendEditText2 != null) {
                    extendEditText2.setHint(string4Uin);
                }
            }
        } else {
            ExtendEditText extendEditText3 = this.f45104j0;
            if (extendEditText3 != null) {
                extendEditText3.setHint(charSequenceExtra);
            }
        }
        String stringExtra = intent.getStringExtra("key_default_mood_text");
        if (!TextUtils.isEmpty(stringExtra) && (extendEditText = this.f45104j0) != null) {
            extendEditText.setText(stringExtra);
        }
        if (intent.getIntExtra(PeakConstants.VIDEO_TYPE, -1) == 1) {
            zp();
        }
        this.Z2 = this.Y2.h();
        this.Y2.b();
        if (this.F1) {
            setTitle(R.string.vtb);
        }
        if (oj().size() <= 0 || (relativeLayout = this.T2) == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        Qp();
        this.f51464h5 = true;
        Dp();
    }

    public void iq(PublishEventTag publishEventTag) {
        String config;
        boolean z16;
        if (publishEventTag != null && !TextUtils.isEmpty(publishEventTag.title)) {
            this.f51489v5 = publishEventTag;
            config = publishEventTag.title;
            z16 = true;
        } else {
            this.f51489v5 = null;
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleEventTagActivity", "\u6dfb\u52a0\u6807\u7b7e");
            z16 = false;
        }
        this.f51469m5.setImageAndText(null, config);
        this.f51470n5.setImageAndText(null, config);
        this.f51469m5.setCheck(z16);
        this.f51470n5.setCheck(z16);
        Do();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object obj;
        if (event == null) {
            return;
        }
        super.onEventUIThread(event);
        if ("WriteOperation".equals(event.source.getName())) {
            switch (event.what) {
                case 62:
                    Fo();
                    return;
                case 63:
                    Object obj2 = event.params;
                    if (obj2 instanceof Object[]) {
                        iq((PublishEventTag) ((Object[]) obj2)[0]);
                        return;
                    } else {
                        iq(null);
                        return;
                    }
                case 64:
                    Object obj3 = event.params;
                    if (obj3 instanceof Object[]) {
                        iq((PublishEventTag) ((Object[]) obj3)[0]);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        if ("FontQbossGifShow".equals(event.source.getName()) && event.what == 2 && (obj = event.params) != null) {
            this.U5 = (QbossAdvDesc) obj;
            RedDotImageView redDotImageView = this.f45113m0;
            if (redDotImageView == null || redDotImageView.getVisibility() != 0) {
                return;
            }
            dq(this.U5);
        }
    }

    private void Xp(String str, com.qzone.publish.ui.model.c cVar) {
        String str2;
        String stringExtra = getIntent().getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_NAME);
        String stringExtra2 = getIntent().getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_DESC);
        String stringExtra3 = getIntent().getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID);
        String stringExtra4 = getIntent().getStringExtra("music_id");
        String stringExtra5 = getIntent().getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID);
        String stringExtra6 = getIntent().getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START);
        String stringExtra7 = getIntent().getStringExtra(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE);
        shuoshuo_privacy shuoshuo_privacyVar = new shuoshuo_privacy();
        shuoshuo_privacyVar.mood_permission = String.valueOf(this.k3);
        ArrayList<String> arrayList = this.l3;
        if (arrayList == null || arrayList.size() <= 0) {
            str2 = stringExtra6;
        } else {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            str2 = stringExtra6;
            for (int i3 = 0; i3 < this.l3.size(); i3++) {
                arrayList2.add(Long.valueOf(this.l3.get(i3)));
            }
            shuoshuo_privacyVar.mood_allowuins = arrayList2;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_NAME, stringExtra);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_DESC, stringExtra2);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID, stringExtra3);
        hashMap.put("music_id", stringExtra4);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID, stringExtra5);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START, str2);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE, stringExtra7);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_MOOD_TEXT, str);
        ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 3, "2", true, new String[0]);
        Pp(this.I4);
        cVar.f51944g = shuoshuo_privacyVar;
        cVar.f51942f = hashMap;
        QZoneWriteOperationService.v0().O1(cVar);
        QZLog.d("[upload2][uploadalbum]", 1, "publish dynamic" + cVar.toString());
    }

    private void Zp(com.qzone.publish.ui.model.c cVar) {
        List<LocalMediaInfo> list;
        HashMap<String, PicInfo> hashMap = this.A0;
        if (hashMap != null && hashMap.size() > 0) {
            if (this.f51486u2 == null) {
                this.f51486u2 = new HashMap<>();
            }
            this.f51486u2.putAll(this.A0);
        }
        Pp(this.I4);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (int i16 = 0; i16 < this.U.size(); i16++) {
            String str = this.U.get(i16);
            LocalMediaInfo sq5 = sq(this.Z.get(str));
            if (sq5 == null) {
                sq5 = this.W.get(str);
            }
            if (sq5 != null) {
                arrayList.add(sq5);
                if (sq5.isRecord) {
                    i3++;
                    if (this.I4 == null) {
                        ShuoshuoVideoInfo y16 = ag.y(getActivity(), sq5._id, sq5.path, sq5.fileSize, sq5.mVideoType, null, sq5.thumbHeight, sq5.thumbWidth, sq5.mStartTime, sq5.mDuration, sq5.mTotalDuration, sq5.needProcess, sq5.bundle);
                        this.I4 = y16;
                        if (y16 != null) {
                            y16.mIsUploadOrigin = this.H4;
                            y16.fakeVid = sq5.fakeVid;
                        }
                    }
                } else if (QAlbumUtil.getMediaType(sq5) != 0 && QAlbumUtil.getMediaType(sq5) == 1) {
                    i3++;
                    sq5.needProcess = !this.H4;
                    if (sq5.isMakeVideo) {
                        sq5.needProcess = false;
                        sq5.mIsUploadOrigin = true;
                    }
                    if (this.I4 == null) {
                        FragmentActivity activity = getActivity();
                        long j3 = sq5._id;
                        String str2 = sq5.path;
                        long j16 = sq5.fileSize;
                        int i17 = sq5.thumbHeight;
                        int i18 = sq5.thumbWidth;
                        long j17 = sq5.mDuration;
                        this.I4 = ag.y(activity, j3, str2, j16, 1, null, i17, i18, 0L, j17, j17, false, null);
                    }
                }
            } else {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.path = this.U.get(i16);
                arrayList.add(localMediaInfo);
            }
        }
        boolean z16 = i3 >= 1;
        HashMap hashMap2 = new HashMap();
        HashMap<String, MarkUinInfoBeforeUpload> hashMap3 = this.U1;
        if (hashMap3 != null) {
            for (String str3 : hashMap3.keySet()) {
                hashMap2.put(str3, this.U1.get(str3).toByteArray());
            }
        }
        ConcurrentHashMap<String, float[]> concurrentHashMap = this.f45140x1;
        HashMap hashMap4 = (concurrentHashMap == null || concurrentHashMap.isEmpty()) ? null : new HashMap();
        cVar.f51947i = this.f51486u2;
        cVar.f51940e = arrayList;
        cVar.G = hashMap4;
        cVar.B = this.f45132t1;
        cVar.a(this.U1);
        if (this.f51484t3 && (list = cVar.f51940e) != null && list.size() == 1) {
            cVar.f51940e.get(0).isSyncToWeishi = true;
        }
        if (this.f51460g3 > 0) {
            Vp(2);
            if (z16) {
                Vp(3);
            }
        }
        if (com.qzone.publish.ui.model.b.f51931e && z16) {
            QZoneWriteOperationService.v0().R1(getActivity(), cVar);
            QZLog.d("[upload2][uploadalbum]", 1, "publish MixVideoPicUpload" + cVar.toString());
            return;
        }
        if (this.I4 == null) {
            oj();
        }
        QZoneWriteOperationService.v0().O1(cVar);
        QZLog.d("[upload2][uploadalbum]", 1, "publish Nornmal" + cVar.toString());
    }

    private void sp(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && action.equals(QZoneHelper.Constants.INTENT_ACTION_PUBLISH_QR_CODE)) {
                this.Y2 = com.qzone.publish.ui.state.a.e(1, this);
                ImageLoader.getInstance().clear(intent.getStringExtra(QZoneHelper.Constants.KEY_FILE_PATH));
                ClickReport.e(311, "QRcode", 313, 8);
                return;
            }
        }
        if (this.f45084c1) {
            this.Y2 = com.qzone.publish.ui.state.a.e(2, this);
            return;
        }
        if (this.f45090e1) {
            this.Y2 = com.qzone.publish.ui.state.a.e(3, this);
            return;
        }
        if (this.F0 == 2) {
            com.qzone.publish.ui.state.a e16 = com.qzone.publish.ui.state.a.e(0, this);
            this.Y2 = e16;
            e16.q(true);
            this.F0 = 0;
            return;
        }
        this.Y2 = com.qzone.publish.ui.state.a.e(u5.b.g0("_shuoshuo", 0, LoginData.getInstance().getUin()), this);
    }

    private LocalMediaInfo sq(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.isRecord = true;
        localMediaInfo.path = shuoshuoVideoInfo.mVideoPath;
        localMediaInfo.thumbnailPath = shuoshuoVideoInfo.mCoverUrl;
        localMediaInfo.fileSize = shuoshuoVideoInfo.mSize;
        localMediaInfo.mVideoType = shuoshuoVideoInfo.mVideoType;
        localMediaInfo.mStartTime = shuoshuoVideoInfo.mStartTime;
        localMediaInfo.mTotalDuration = shuoshuoVideoInfo.mTotalDuration;
        localMediaInfo.mDuration = shuoshuoVideoInfo.mDuration;
        localMediaInfo.needProcess = shuoshuoVideoInfo.mNeedProcess;
        localMediaInfo.bundle = shuoshuoVideoInfo.mExtras;
        localMediaInfo.fakeVid = shuoshuoVideoInfo.fakeVid;
        localMediaInfo.mIsUploadOrigin = this.H4;
        return localMediaInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        RDMEtraMsgCollector.getInstance().addNoramlClickAction(this.simpleClassname, view);
        if (view != this.G2 && view != this.F2) {
            if (view != this.B2 && view != this.C2) {
                if (view != this.D2 && view != this.E2) {
                    if (view == this.f51443b3) {
                        ep();
                    } else if (view != this.H2 && view != this.I2) {
                        if (view != this.J2 && view != this.K2) {
                            if (view != this.f51463h3 && view != this.f51477q5 && view != this.f51480r5) {
                                if (view == this.f51490w2) {
                                    Ml(1);
                                    LpReportInfo_pf00064.allReport(586, 47, 2);
                                } else if (view == this.D4) {
                                    Gp();
                                } else if (view == this.f51495y2) {
                                    fp();
                                } else if (view == this.f45122p0) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("extra_from_select_photo_for_dongganyingji", true);
                                    com.qzone.common.business.service.b.f().q(getActivity(), null, null, 30, true, 6, false, false, null, "", bundle, QZoneMediaBusiness.QZONE_VIDEO_ALBUM);
                                    ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 9, "0", true, new String[0]);
                                } else if (view != this.f51469m5 && view != this.f51470n5) {
                                    if (view == this.f51472o5 || view == this.f51475p5) {
                                        RDMEtraMsgCollector.getInstance().addNoramlClickAction(this.simpleClassname, view);
                                        com.qzone.misc.network.report.b.e(this.U4);
                                        ((LBSModule) hj(LBSModule.class)).C();
                                        ClickReport.m("437", "1", "2");
                                        if (!this.I5) {
                                            this.D5.append(4);
                                            this.I5 = true;
                                        }
                                    }
                                } else {
                                    Zo();
                                    LpReportInfo_pf00064.allReport(586, 25);
                                    if (!this.H5) {
                                        this.D5.append(3);
                                        this.H5 = true;
                                    }
                                }
                            } else {
                                if (this.F1) {
                                    LpReportInfo_pf00064.allReport(84, 23, 1);
                                }
                                Mo();
                                com.qzone.misc.network.report.b.f(this.U4);
                            }
                        } else {
                            hp();
                            fn();
                        }
                    } else {
                        dp();
                    }
                } else {
                    cn();
                }
            } else {
                cp();
            }
        } else {
            gp();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        boolean z16 = intent != null && intent.getBooleanExtra("extra_select_net_pic_from_gif_list", false);
        this.f51497y5 = z16;
        if (z16) {
            Hp(intent);
            return;
        }
        if (intent != null && intent.getBooleanExtra("extra_from_select_photo_for_dongganyingji", false)) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
                ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 9, "3", true, new String[0]);
                com.qzone.album.base.Service.e.e().v(stringArrayListExtra);
                yo.d.d(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_ALBUM_URL, QzoneConfig.DEFAULT_DYNAMIC_ALBUM_URL), getActivity(), null);
            }
        } else {
            super.onNewIntent(intent);
            Op();
        }
        if (intent != null) {
            this.S1 = intent.getIntExtra(PeakConstants.KEY_SHOW_ORIGIN_TYPE, 0);
        }
        Km();
    }

    private void ap(QZoneTask qZoneTask) {
        JceStruct jceStruct;
        Map<Integer, ArrayList<tAdvDesc>> map;
        ArrayList<tAdvDesc> arrayList;
        if (qZoneTask == null) {
            return;
        }
        if (qZoneTask.getResult(201).getReturnCode() != 0) {
            QZLog.e(f51340x6, "get qboss video vip tips info failed,code = " + qZoneTask.mResultCode);
            return;
        }
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if ((qZoneRequest instanceof QzoneQBossAdvRequest) && (jceStruct = ((QzoneQBossAdvRequest) qZoneRequest).rsp) != null && (jceStruct instanceof MobileQbossAdvRsp) && (map = ((MobileQbossAdvRsp) jceStruct).mapAdv) != null && (arrayList = map.get(2454)) != null && arrayList.size() > 0) {
            tAdvDesc tadvdesc = arrayList.get(0);
            if (this.L4 == null) {
                this.L4 = new com.qzone.publish.ui.model.e();
            }
            com.qzone.publish.ui.model.e eVar = this.L4;
            eVar.f51978d = tadvdesc.res_traceinfo;
            if (wp(tadvdesc.res_data, eVar)) {
                QZLog.i(f51340x6, 1, "get qboss video tips info succ." + this.L4);
                qq();
                return;
            }
            QZLog.w(f51340x6, "get qboss video tips info fail.");
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Ej() {
        LpReportInfo_pf00064.allReport(586, 35, 2);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Fk(Intent intent) {
        View view;
        HashMap hashMap;
        if (intent != null && this.R4 != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PeakConstants.QZONE_ALBUM_ML_EXPOSED_MEDIA_LST);
            if (serializableExtra != null) {
                try {
                    this.R4.addAll((List) serializableExtra);
                } catch (ClassCastException unused) {
                    QZLog.e(f51340x6, 4, "ClassCastException caused by objFromAlbumExpose to exposedMediaLst");
                }
            } else {
                QZLog.d(f51340x6, 4, "exposedMediaLst is null");
            }
        }
        if (this.W2 == -1) {
            this.W2 = System.currentTimeMillis();
        }
        this.J1.y();
        try {
            super.Fk(intent);
        } catch (ClassCastException e16) {
            QZLog.d(f51340x6, 4, e16.getMessage());
        }
        Mp();
        HashMap<String, PicInfo> hashMap2 = this.A0;
        boolean z16 = hashMap2 != null && hashMap2.size() > 0;
        if ((this.f45084c1 || z16) && (view = this.F2) != null) {
            view.setVisibility(8);
            this.f51481s3 = false;
        }
        if (intent != null && this.f45080b0 != null && (hashMap = (HashMap) intent.getSerializableExtra(PeakConstants.PANORAMA_IMAGES)) != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!this.f45080b0.containsKey(entry.getKey())) {
                    this.f45080b0.put((String) entry.getKey(), (Integer) entry.getValue());
                }
            }
        }
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.u0(this.W, this.X, this.f45080b0, true);
        }
        if (this.G5) {
            return;
        }
        this.D5.append(2);
        this.G5 = true;
    }

    private static boolean wp(String str, com.qzone.publish.ui.model.e eVar) {
        if (eVar != null && str != null && !TextUtils.isEmpty(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                eVar.f51975a = jSONObject.optString("text");
                eVar.f51976b = jSONObject.optString(ZPlanPublishSource.FROM_SCHEME);
                String optString = jSONObject.optString("showtime");
                if (optString == null || optString.length() <= 0) {
                    return true;
                }
                eVar.f51977c = Integer.parseInt(optString);
                return true;
            } catch (Throwable th5) {
                QZLog.w(th5);
            }
        }
        return false;
    }

    public void Bq(long j3, long j16) {
        CheckBox checkBox;
        CheckBox checkBox2;
        CheckBox checkBox3;
        if (j3 <= 0 && j16 <= 0) {
            this.f51447c3.setImageResource(R.drawable.bww);
            return;
        }
        this.f51447c3.setImageResource(R.drawable.bwx);
        boolean z16 = this.f51481s3;
        if (z16 && (checkBox3 = this.G2) != null) {
            boolean z17 = !z16;
            this.f51481s3 = z17;
            checkBox3.setChecked(z17);
        }
        if (this.X4 && this.I2 != null) {
            boolean z18 = this.f51496y3;
            if (z18 && (checkBox2 = this.H2) != null) {
                boolean z19 = !z18;
                this.f51496y3 = z19;
                checkBox2.setChecked(z19);
                toast(getString(R.string.f21966671, getString(R.string.f2199667u)));
            }
            this.I2.setVisibility(8);
        }
        if (!this.Y4 || this.K2 == null) {
            return;
        }
        if (this.f51444b4 && this.J2 != null && (checkBox = this.H2) != null) {
            this.f51444b4 = false;
            checkBox.setChecked(false);
            toast(getString(R.string.f21966671, getString(R.string.f2203168s)));
        }
        this.K2.setVisibility(8);
    }

    private void Do() {
    }

    private void fp() {
    }

    @Override // com.qzone.publish.ui.controller.a
    public void showActionSheet() {
    }

    @Override // com.qzone.publish.ui.controller.a
    public void gotoSelectPicture(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
    }
}
