package com.qzone.publish.ui.activity;

import BOSSStrategyCenter.tAdvDesc;
import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_OPERATION.operation_forward_req;
import NS_MOBILE_QBOSS_PROTO.MobileQbossAdvRsp;
import PROTO_EXT_TO_UGCSVR.Font;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.business.photogroupgrade.PhotoGroupOptimizeFuncSwitcher;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.common.activities.base.aj;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.common.tool.ReportUtils;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.service.QzoneNewCardSkinService;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.publish.ui.publishmodule.LBSModule;
import com.qzone.reborn.albumx.qzonex.activity.QZonePublishXMoodRealActivity;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.reborn.part.publish.mood.QZonePublishPart;
import com.qzone.reborn.part.publish.mood.imageai.QZonePublishPicToTextPart;
import com.qzone.reborn.part.publish.mood.sync.QZonePublishSyncQCirclePart;
import com.qzone.util.P2VUtil;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.ak;
import com.qzone.util.ar;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.qzone.widget.AsyncMarkGifImageView;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.ExtendScrollView;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.qzone.widget.RedDotImageView;
import com.qzone.widget.UrlExtendEditText;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.qzone.widget.particle.ParticleManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.compat.RFWNinePatchUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.qzone.bean.a;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.util.ImageQualityPreference;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
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
import cooperation.qzone.widget.QzoneEmotionUtils;
import e9.a;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

/* loaded from: classes39.dex */
public class QZonePublishMoodNewStyleActivity extends QZonePublishMoodBaseActivity implements View.OnClickListener, IQZoneServiceListener, com.qzone.publish.ui.controller.a {
    private static long N6;
    private String C6;
    private String D6;
    private so.a F6;
    ActionSheet I6;

    /* renamed from: r6, reason: collision with root package name */
    private fm.b f51522r6;

    /* renamed from: s6, reason: collision with root package name */
    private bm.a f51523s6;

    /* renamed from: t6, reason: collision with root package name */
    private com.qzone.reborn.part.publish.mood.sync.o f51524t6;

    /* renamed from: u6, reason: collision with root package name */
    private com.qzone.reborn.part.publish.mood.imageai.l f51525u6;

    /* renamed from: v6, reason: collision with root package name */
    private zl.d f51526v6;

    /* renamed from: w6, reason: collision with root package name */
    private com.tencent.mobileqq.service.qzone.bean.c f51527w6;

    /* renamed from: x6, reason: collision with root package name */
    private LinearLayout f51528x6;

    /* renamed from: y6, reason: collision with root package name */
    private String f51529y6;

    /* renamed from: i6, reason: collision with root package name */
    public String f51513i6 = "";

    /* renamed from: j6, reason: collision with root package name */
    public String f51514j6 = "";

    /* renamed from: k6, reason: collision with root package name */
    public String f51515k6 = "";

    /* renamed from: l6, reason: collision with root package name */
    public HashMap<String, Map<String, String>> f51516l6 = new HashMap<>();

    /* renamed from: m6, reason: collision with root package name */
    private final QZonePublishPart f51517m6 = new QZonePublishPart(this);

    /* renamed from: n6, reason: collision with root package name */
    private final com.qzone.reborn.part.publish.mood.a f51518n6 = new com.qzone.reborn.part.publish.mood.a();

    /* renamed from: o6, reason: collision with root package name */
    private QZonePublishSyncQCirclePart f51519o6 = null;

    /* renamed from: p6, reason: collision with root package name */
    private final hm.a f51520p6 = new hm.a(this);

    /* renamed from: q6, reason: collision with root package name */
    private final ym.a f51521q6 = new ym.a();

    /* renamed from: z6, reason: collision with root package name */
    private boolean f51530z6 = true;
    public View.OnClickListener A6 = new s();
    private BroadcastReceiver B6 = null;
    private final TextWatcher E6 = new i();
    private final Animation.AnimationListener G6 = new k();
    private final Animation.AnimationListener H6 = new l();
    private boolean J6 = false;
    private boolean K6 = false;
    public View.OnClickListener L6 = new r();
    public final HashMap<String, Pair<String, String>> M6 = new HashMap<>();

    /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity$44, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass44 implements Runnable {
        final /* synthetic */ QZonePublishMoodNewStyleActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.Lq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity$6, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass6 extends QZoneAlbumUtil.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51569d;

        AnonymousClass6(String str) {
            this.f51569d = str;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
            if (QZonePublishMoodNewStyleActivity.this.isFinishing()) {
                return;
            }
            QZonePublishMoodNewStyleActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.6.1

                /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity$6$1$a */
                /* loaded from: classes39.dex */
                class a implements View.OnClickListener {
                    a() {
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        QZoneHelper.forwardToBrowser(QZonePublishMoodNewStyleActivity.this.getActivity(), AnonymousClass6.this.f51569d, -1, null, null);
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView = (ImageView) QZonePublishMoodNewStyleActivity.this.$(R.id.heg);
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    imageView.setOnClickListener(new a());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a extends a.i {
        a() {
        }

        @Override // e9.a.i
        public boolean a() {
            if (QZonePublishMoodNewStyleActivity.this.T.U() < com.qzone.publish.ui.model.b.f51929c) {
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
                if (!qZonePublishMoodNewStyleActivity.I0 && !qZonePublishMoodNewStyleActivity.pk() && !QZonePublishMoodNewStyleActivity.this.qk()) {
                    return true;
                }
            }
            return false;
        }

        @Override // e9.a.i
        public boolean b() {
            QZonePublishMoodNewStyleActivity.this.fq();
            return true;
        }

        @Override // e9.a.i
        public boolean c(int i3) {
            if (((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45139x0) {
                QZonePublishMoodNewStyleActivity.this.Iq(i3);
                ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45139x0 = false;
                return true;
            }
            QZonePublishMoodNewStyleActivity.this.dp(i3);
            return true;
        }

        @Override // e9.a.i
        public void d() {
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
            ExtendScrollView extendScrollView = qZonePublishMoodNewStyleActivity.M;
            if (extendScrollView != null) {
                extendScrollView.e(qZonePublishMoodNewStyleActivity.P.getId());
            }
        }

        @Override // e9.a.i
        public void e() {
            QZonePublishMoodNewStyleActivity.this.ui();
        }

        @Override // e9.a.i
        public boolean f(View view) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements DynamicGridView.s {
        c() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void a(int i3, int i16) {
            QZonePublishMoodNewStyleActivity.this.Zk(i3, i16);
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
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long uin;
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
            ExtendEditText extendEditText = qZonePublishMoodNewStyleActivity.f45104j0;
            if (extendEditText != null) {
                qZonePublishMoodNewStyleActivity.S4.setTextDraft(extendEditText.getText().toString());
            }
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity2 = QZonePublishMoodNewStyleActivity.this;
            qZonePublishMoodNewStyleActivity2.S4.setmPriv(qZonePublishMoodNewStyleActivity2.O1.U1());
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity3 = QZonePublishMoodNewStyleActivity.this;
            qZonePublishMoodNewStyleActivity3.S4.setmPrivUinList(qZonePublishMoodNewStyleActivity3.O1.W1().getValue());
            com.qzone.publish.ui.state.a aVar = QZonePublishMoodNewStyleActivity.this.Y2;
            if (aVar != null) {
                uin = aVar.g();
            } else {
                uin = LoginData.getInstance().getUin();
            }
            u5.b.N0(QZonePublishMoodNewStyleActivity.this.S4, uin);
            QZonePublishMoodNewStyleActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
            qZonePublishMoodNewStyleActivity.Wk(qZonePublishMoodNewStyleActivity.P, 0, qZonePublishMoodNewStyleActivity.oj(), 4, ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45144z1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements UrlExtendEditText.a {
        f() {
        }

        @Override // com.qzone.widget.UrlExtendEditText.a
        public void a(String str, int i3, int i16) {
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
            if (!qZonePublishMoodNewStyleActivity.Pi(qZonePublishMoodNewStyleActivity.f45104j0.getText(), i3, i16)) {
                if (QZonePublishMoodNewStyleActivity.this.oj().isEmpty()) {
                    QZoneWriteOperationService.v0().B0(null, str);
                    return;
                }
                return;
            }
            ((UrlExtendEditText) QZonePublishMoodNewStyleActivity.this.f45104j0).setUrlState(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g extends InputFilter.LengthFilter {
        g(int i3) {
            super(i3);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            String str;
            if (spanned == null || i17 <= 0) {
                str = "";
            } else {
                str = "" + spanned.subSequence(0, i17).toString();
            }
            if (charSequence != null && i16 > i3) {
                str = str + charSequence.subSequence(i3, i16).toString();
            }
            if (spanned != null && spanned.length() > i18) {
                str = str + spanned.subSequence(i18, spanned.length()).toString();
            }
            if (str.length() > 12) {
                ToastUtil.s(QZonePublishMoodNewStyleActivity.this.getString(R.string.f2194866j, 12), 0);
                if (spanned == null || spanned.length() >= 12 || Character.isSurrogatePair(str.charAt(str.length() - 2), str.charAt(str.length() - 1))) {
                    return "";
                }
                return str.substring(spanned.length(), 12);
            }
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f51581d;

        h(int i3) {
            this.f51581d = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZonePublishMoodNewStyleActivity.this.dp(this.f51581d);
        }
    }

    /* loaded from: classes39.dex */
    class j extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f51584a;

        j(Intent intent) {
            this.f51584a = intent;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QZLog.e("QZonePublishMoodNewStyleActivity", "requestStoragePermission grant");
            QZonePublishMoodNewStyleActivity.this.cp(this.f51584a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QZLog.e("QZonePublishMoodNewStyleActivity", "requestStoragePermission deny");
        }
    }

    /* loaded from: classes39.dex */
    class k extends AnimateUtils.AnimationAdapter {
        k() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZonePublishMoodNewStyleActivity.this.fp();
        }
    }

    /* loaded from: classes39.dex */
    class l extends AnimateUtils.AnimationAdapter {
        l() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZonePublishMoodNewStyleActivity.this.ep();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class m implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51588d;

        m(String str) {
            this.f51588d = str;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QZonePublishMoodNewStyleActivity.this.simpleClassname + " QQCustomDialog click :" + this.f51588d);
            QZonePublishMoodNewStyleActivity.this.I6.dismiss();
            QZonePublishMoodNewStyleActivity.this.Bq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class n implements ActionSheet.OnDismissListener {
        n() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            RDMEtraMsgCollector.getInstance().addUserAction("[Actvity]" + QZonePublishMoodNewStyleActivity.this.simpleClassname + " QQCustomDialog click :\u53d6\u6d88");
            QZonePublishMoodNewStyleActivity.this.gm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class o implements Observer<Integer> {
        o() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            DynamicArrayList<String> dynamicArrayList;
            boolean z16;
            if (num.intValue() == 1) {
                if (QZonePublishMoodNewStyleActivity.this.rl()) {
                    ToastUtil.s(QZonePublishMoodNewStyleActivity.this.getResources().getString(R.string.ivf), 4);
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QZonePublishMoodNewStyleActivity.this.wl()) {
                    z16 = true;
                }
                if (z16) {
                    QZonePublishMoodNewStyleActivity.this.T.notifyDataSetChanged();
                }
            }
            if (QZonePublishMoodNewStyleActivity.this.f51522r6.T1()) {
                return;
            }
            if (num.intValue() == 1 && (dynamicArrayList = QZonePublishMoodNewStyleActivity.this.U) != null && !dynamicArrayList.isEmpty()) {
                int size = QZonePublishMoodNewStyleActivity.this.U.size();
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
                int i3 = qZonePublishMoodNewStyleActivity.f51476q3;
                if (size > i3) {
                    qZonePublishMoodNewStyleActivity.ql(i3);
                    QZonePublishMoodNewStyleActivity.this.T.notifyDataSetChanged();
                    ToastUtil.s(QZonePublishMoodNewStyleActivity.this.getResources().getString(R.string.cu5, Integer.valueOf(QZonePublishMoodNewStyleActivity.this.f51476q3)), 4);
                }
                QZonePublishMoodNewStyleActivity.this.P.setVisibility(8);
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity2 = QZonePublishMoodNewStyleActivity.this;
                qZonePublishMoodNewStyleActivity2.Q.setAsyncImage(qZonePublishMoodNewStyleActivity2.U.get(0));
                QZonePublishMoodNewStyleActivity.this.Q.setVisibility(0);
                QZonePublishMoodNewStyleActivity.this.R.setVisibility(0);
                QZonePublishMoodNewStyleActivity.this.S.setVisibility(0);
                return;
            }
            QZonePublishMoodNewStyleActivity.this.P.setVisibility(0);
            QZonePublishMoodNewStyleActivity.this.Q.setVisibility(8);
            QZonePublishMoodNewStyleActivity.this.R.setVisibility(8);
            QZonePublishMoodNewStyleActivity.this.S.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class p implements DialogInterface.OnClickListener {
        p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QZonePublishMoodNewStyleActivity.this.getPartManager().broadcastMessage("set_permission_public", null);
            QZonePublishMoodNewStyleActivity.this.Bq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class q implements DialogInterface.OnClickListener {
        q() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZonePublishMoodNewStyleActivity.this.Bq();
        }
    }

    /* loaded from: classes39.dex */
    class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Object obj;
            Object obj2;
            String str2;
            String str3;
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePublishMoodNewStyleActivity.this.fm(view);
            QZonePublishMoodNewStyleActivity.this.gm(false);
            if (QZonePublishMoodNewStyleActivity.this.F1) {
                LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("84", "4"), false, false);
            }
            QZonePublishMoodNewStyleActivity.this.f51459f6 = UUID.randomUUID().toString();
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(586, 3, QZonePublishMoodNewStyleActivity.this.Zm());
            lpReportInfo_pf00064.reserves3 = QZonePublishMoodNewStyleActivity.this.f51459f6;
            String str4 = "1";
            if (com.qzone.business.tianshu.c.j().t()) {
                lpReportInfo_pf00064.reserves4 = "1";
            } else {
                lpReportInfo_pf00064.reserves4 = "0";
            }
            if (QZonePublishMoodNewStyleActivity.this.Zm() == 9) {
                if (QzoneFrame.isNewConciseFragment()) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                lpReportInfo_pf00064.reserves8 = str2;
                if (QQTheme.isNowSimpleUI()) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                lpReportInfo_pf00064.reserves9 = str3;
            } else {
                lpReportInfo_pf00064.reserves7 = "0";
                if (QZonePublishMoodNewStyleActivity.this.an().d()) {
                    str = "1";
                } else {
                    str = "0";
                }
                lpReportInfo_pf00064.reserves8 = str;
            }
            LpReportInfo_pf00064 up5 = QZonePublishMoodNewStyleActivity.this.up(lpReportInfo_pf00064);
            LpReportManager.getInstance().reportToPF00064(up5, false, false);
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.b(140, up5.reserves10, ""));
            if (QZonePublishMoodNewStyleActivity.this.getActivity() != null && QZonePublishMoodNewStyleActivity.this.getActivity().getIntent() != null) {
                com.qzone.misc.network.report.b.i(QZonePublishMoodNewStyleActivity.this.getActivity().getIntent(), 2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(v4.b.CLIENTKEY, QZonePublishMoodNewStyleActivity.this.f51459f6);
            Pair<Integer, Integer> Q1 = QZonePublishMoodNewStyleActivity.this.N1.Q1();
            hashMap.put("pic_cnt", Q1.first);
            hashMap.put("video_number", Q1.second);
            hashMap.put("qq_is_atomize_publish", 0);
            if (QZonePublishMoodNewStyleActivity.this.Mp()) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("is_holiday", obj);
            hashMap.put("come_from", Integer.valueOf(((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45136v1));
            hashMap.put("qz_adid", com.qzone.reborn.util.l.f59550a.f(((PhotoActivity) QZonePublishMoodNewStyleActivity.this).Q1, QZonePublishMoodNewStyleActivity.this.getIntent()));
            eo.c cVar = eo.c.f396879a;
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, cVar.c());
            if (QZonePublishMoodNewStyleActivity.this.N4) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            hashMap.put("is_from_draft", obj2);
            hashMap.put("visibility_range", Integer.valueOf(QZonePublishMoodNewStyleActivity.this.O1.U1()));
            hashMap.put("publisher_gameplay", QZonePublishMoodNewStyleActivity.this.f51521q6.E9());
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EDIT_PAGE_GAMEPLAY, QZonePublishMoodNewStyleActivity.this.f51521q6.C9());
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.IS_SHARE_ORIGINAL_PICTURE, QZonePublishMoodNewStyleActivity.this.f51521q6.D9());
            QZonePublishMoodNewStyleActivity.this.f51521q6.H9(QZonePublishMoodNewStyleActivity.this.U);
            if (!Boolean.TRUE.equals(QZonePublishMoodNewStyleActivity.this.P1.U1().getValue())) {
                str4 = "0";
            }
            hashMap.put("is_sync_moments", str4);
            if (QZonePublishMoodNewStyleActivity.this.f51525u6 != null && QZonePublishMoodNewStyleActivity.this.f51523s6 != null && com.qzone.reborn.part.publish.mood.imageai.f.b()) {
                hashMap.put("polish_text_use", QZonePublishMoodNewStyleActivity.this.f51525u6.a2(QZonePublishMoodNewStyleActivity.this.f51523s6.O1()));
                hashMap.put("pic_generate_text_id", QZonePublishMoodNewStyleActivity.this.qp());
            }
            hashMap.putAll(QZonePublishMoodNewStyleActivity.this.getChildDaTongPageParams());
            fo.c.e("em_qz_talk_publish_button", QZonePublishMoodNewStyleActivity.this.getDaTongPageId(), QZonePublishMoodNewStyleActivity.this.f51440a3, hashMap);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishMoodNewStyleActivity.this.simpleClassname, view);
            if (QZonePublishMoodNewStyleActivity.this.Ui() <= QZonePublishMoodNewStyleActivity.this.ej()) {
                QZonePublishMoodNewStyleActivity.this.ap();
            } else {
                QZonePublishMoodNewStyleActivity.this.toast(R.string.f173054gr0);
            }
            cVar.a();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishMoodNewStyleActivity.this.simpleClassname, view);
            com.qzone.misc.network.report.b.c(QZonePublishMoodNewStyleActivity.this.U4);
            QZonePublishMoodNewStyleActivity.this.onBack();
            QZonePublishMoodNewStyleActivity.this.fn();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZonePublishMoodNewStyleActivity.this.simpleClassname, view);
            QZonePublishMoodNewStyleActivity.this.fk(false);
            Intent intent = new Intent();
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.M());
            Activity realActivity = QZonePublishMoodNewStyleActivity.this.getRealActivity();
            if (realActivity instanceof BasePluginActivity) {
                realActivity = ((BasePluginActivity) realActivity).getOutActivity();
            }
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(realActivity, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
            LpReportInfo_pf00064.allReport(586, 31);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class v extends BroadcastReceiver {
        v() {
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
                    QZonePublishMoodNewStyleActivity.this.Xh(arrayList);
                }
            } catch (Exception e16) {
                QZLog.e("QZonePublishMoodNewStyleActivity", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class w implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51600d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f51601e;

        w(String str, String str2) {
            this.f51600d = str;
            this.f51601e = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (System.currentTimeMillis() - QZonePublishMoodNewStyleActivity.N6 >= 1000) {
                QZonePublishMoodNewStyleActivity.N6 = System.currentTimeMillis();
                QZonePublishMoodNewStyleActivity.this.Ap();
                String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_PICK_GAME_MATES, "https://s.gamecenter.qq.com/gc/social-node/pick-mates.html?hulian_extra_scene={hulian_extra_scene}&appid={appid}&openid={openid}").replace("{hulian_extra_scene}", URLEncoder.encode(this.f51600d)).replace("{appid}", QZonePublishMoodNewStyleActivity.this.f45117n1).replace("{openid}", this.f51601e);
                yo.d.b(QZonePublishMoodNewStyleActivity.this.getRealActivity(), new yo.g(replace));
                LpReportInfo_pf00064.report(122, 7, 2, QZonePublishMoodNewStyleActivity.this.f45117n1);
                if (QZLog.isColorLevel()) {
                    QZLog.e("QZonePublishMoodNewStyleActivity", "pickgamemates:" + replace);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class x implements View.OnClickListener {
        x() {
        }

        private void a() {
            Intent qZoneVideoDownloadActivityIntent = QZoneHelper.getQZoneVideoDownloadActivityIntent(QZonePublishMoodNewStyleActivity.this.getActivity().getApplicationContext());
            qZoneVideoDownloadActivityIntent.putExtra("video_type", QZonePublishMoodNewStyleActivity.this.I4.mVideoType);
            qZoneVideoDownloadActivityIntent.putExtra("file_send_path", QZonePublishMoodNewStyleActivity.this.I4.mVideoPath);
            qZoneVideoDownloadActivityIntent.putExtra("preview_video", true);
            qZoneVideoDownloadActivityIntent.putExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS, QZonePublishMoodNewStyleActivity.this.I4.mExtras);
            qZoneVideoDownloadActivityIntent.putExtra(PeakConstants.VIDEO_REFER, PeakConstants.VIDEO_REFER_FROM_MOOD);
            QZonePublishMoodNewStyleActivity.this.startActivity(qZoneVideoDownloadActivityIntent);
        }

        private void b() {
            Intent P = com.qzone.common.activities.base.ak.P(QZonePublishMoodNewStyleActivity.this.getActivity().getApplicationContext());
            P.putExtra("video_type", QZonePublishMoodNewStyleActivity.this.I4.mVideoType);
            P.putExtra("video_source_path", QZonePublishMoodNewStyleActivity.this.I4.mVideoPath);
            P.putExtra("start_time", QZonePublishMoodNewStyleActivity.this.I4.mStartTime);
            P.putExtra("end_time", QZonePublishMoodNewStyleActivity.this.I4.mEndTime);
            QZonePublishMoodNewStyleActivity.this.startActivity(P);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ShuoshuoVideoInfo shuoshuoVideoInfo = QZonePublishMoodNewStyleActivity.this.I4;
            if (shuoshuoVideoInfo != null) {
                if (!FileUtils.fileExists(shuoshuoVideoInfo.mVideoPath)) {
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFileNotExist", ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC), 4);
                } else {
                    int i3 = QZonePublishMoodNewStyleActivity.this.I4.mVideoType;
                    if (i3 == 0) {
                        a();
                    } else if (1 == i3) {
                        if (!QZoneVideoCommonUtils.getTrimSupport().isAvailable()) {
                            com.qzone.common.business.service.b.f().w(QZonePublishMoodNewStyleActivity.this.getActivity(), QZonePublishMoodNewStyleActivity.this.I4);
                        } else {
                            b();
                        }
                    } else {
                        QZLog.w("QZonePublishMoodNewStyleActivity", "goto preview, video type error, type=" + QZonePublishMoodNewStyleActivity.this.I4.mVideoType);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZonePublishMoodNewStyleActivity.this.bp()) {
                QZonePublishMoodNewStyleActivity.this.lq("jhan_shipin");
                ClickReport.e(311, "publishmood", ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, 1, 2);
            } else {
                QZonePublishMoodNewStyleActivity.this.lq("jhan_shipin");
                ClickReport.e(311, "publishmood", ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, 1, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class z implements AdapterView.OnItemClickListener {
        z() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (QZonePublishMoodNewStyleActivity.this.T.d0(i3) && QZonePublishMoodNewStyleActivity.this.T.H(view)) {
                if (QZonePermission.requestStoragePermission(QZonePublishMoodNewStyleActivity.this.getActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
                    QZonePublishMoodNewStyleActivity.this.fq();
                    fo.c.b("dt_clck", view, "em_qz_add_video_pictures", null);
                    return;
                }
                return;
            }
            Intent intent = QZonePublishMoodNewStyleActivity.this.getIntent();
            int intExtra = intent != null ? intent.getIntExtra("key_photo_oprate_type", 1) : 1;
            if (1 == QZonePublishMoodNewStyleActivity.this.getShowType()) {
                intExtra = 4;
            }
            if (QZonePublishMoodNewStyleActivity.this.f51522r6.Q1()) {
                intExtra = 0;
            }
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
            qZonePublishMoodNewStyleActivity.Wk(qZonePublishMoodNewStyleActivity.P, i3, qZonePublishMoodNewStyleActivity.oj(), intExtra, ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45144z1);
            fo.c.b("dt_clck", view, "em_qz_picture", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ap() {
        if (this.B6 == null) {
            this.B6 = new v();
            getRealActivity().registerReceiver(this.B6, new IntentFilter("qzone.pickgamemates"));
        }
    }

    private void Bp() {
        P2VUtil.d().j(getActivity().getApplicationContext());
        com.qzone.publish.ui.model.b.f51930d = true;
        RedDotImageView redDotImageView = (RedDotImageView) $(R.id.hro);
        this.f51492x2 = redDotImageView;
        redDotImageView.setOffSet(ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(2.0f));
        this.f51492x2.setOnClickListener(this);
    }

    private void Ep() {
        ak();
        if (this.f51445b5) {
            com.qzone.common.activities.titlebuilder.a aVar = this.C;
            if (aVar != null && aVar.R0() != null) {
                this.C.R0().setPadding(this.C.R0().getPaddingLeft(), 0, this.C.R0().getPaddingRight(), this.C.R0().getPaddingBottom());
            }
            com.qzone.common.activities.titlebuilder.a aVar2 = this.C;
            if (aVar2 == null || aVar2.E5() == null) {
                return;
            }
            this.C.E5().setVisibility(8);
        }
    }

    private void Gp() {
        String g16;
        if (Mp()) {
            this.f51527w6 = com.tencent.mobileqq.service.qzone.a.f286399a.c();
            QLog.w("QZonePublishMoodNewStyleActivity", 1, "initHolidayUI   confBean=$confBean");
            if (this.f51527w6 == null) {
                return;
            }
            Fp();
            this.f45119o0.setVisibility(8);
            Uq();
            try {
                if (com.qzone.reborn.util.k.f59549a.f()) {
                    g16 = this.f51527w6.h();
                } else {
                    g16 = this.f51527w6.g();
                }
                this.f45104j0.setTextColor(Color.parseColor(g16));
            } catch (Exception e16) {
                QLog.e("QZonePublishMoodNewStyleActivity", 1, "initHolidayUI  e = " + e16);
            }
            if (!TextUtils.isEmpty(this.f51527w6.f())) {
                this.f45104j0.setHint(this.f51527w6.f());
            }
            Xq();
        }
    }

    private void Gq(final QbossAdvDesc qbossAdvDesc) {
        String str;
        try {
            RedDotImageView redDotImageView = this.f45113m0;
            if (redDotImageView == null) {
                return;
            }
            if (qbossAdvDesc == null) {
                redDotImageView.setImageResource(zj());
                return;
            }
            try {
                str = new JSONObject(qbossAdvDesc.res_data).getString("img");
            } catch (Exception unused) {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                this.f45113m0.setImageResource(zj());
                return;
            }
            if (!this.S5 && str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                QZLog.i("QZonePublishMoodNewStyleActivity", "entergif");
                if (this.T5) {
                    QZLog.i("QZonePublishMoodNewStyleActivity", "isDoingShowGif");
                    return;
                }
                this.T5 = true;
                this.f45113m0.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f45113m0.setPlayingGif(true);
                this.f45113m0.setNeedGifStream(true);
                this.f45113m0.setAsyncImageListener(new AsyncImageable.AsyncImageListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.54
                    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                    public void onImageFailed(AsyncImageable asyncImageable) {
                        QZonePublishMoodNewStyleActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.54.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45113m0.setPlayingGif(false);
                                ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45113m0.setNeedGifStream(false);
                                ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45113m0.setImageResource(QZonePublishMoodNewStyleActivity.this.zj());
                            }
                        });
                    }

                    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                    public void onImageLoaded(AsyncImageable asyncImageable) {
                        if (asyncImageable == null || !(asyncImageable.getDrawable() instanceof NewGifDrawable)) {
                            return;
                        }
                        QZLog.i("QZonePublishMoodNewStyleActivity", "onImageLoaded");
                        NewGifDrawable newGifDrawable = (NewGifDrawable) asyncImageable.getDrawable();
                        newGifDrawable.setLoopCount(1);
                        newGifDrawable.setGifPlayListener(new a());
                    }

                    /* renamed from: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity$54$a */
                    /* loaded from: classes39.dex */
                    class a implements NewGifDrawable.GifPlayListener {
                        a() {
                        }

                        @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                        public void onGifStartPlay(NewGifDrawable newGifDrawable) {
                            QZLog.i("QZonePublishMoodNewStyleActivity", "onGifStartPlay");
                        }

                        @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                        public void onGifStopPlay(NewGifDrawable newGifDrawable) {
                            QZLog.i("QZonePublishMoodNewStyleActivity", "onGifStopPlay");
                            newGifDrawable.stop();
                            QZonePublishMoodNewStyleActivity.this.S5 = true;
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
                QZLog.i("QZonePublishMoodNewStyleActivity", "\u64ad\u653egif");
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
                QZLog.i("QZonePublishMoodNewStyleActivity", "\u64ad\u653e\u9759\u6001\u56fe");
            }
            QZLog.i("QZonePublishMoodNewStyleActivity", "fontgifurl =" + str);
            this.f45113m0.getImageOption().needCache = false;
            this.f45113m0.setAsyncImage(str);
        } catch (Exception unused2) {
        }
    }

    private void Hp() {
        if (pk() && nk() && QzoneConfig.isEnablePickGameMates()) {
            String stringExtra = getIntent().getStringExtra(QZoneShareManager.QZONE_SHARE_EXTSTRING);
            String stringExtra2 = getIntent().getStringExtra("open_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    String optString = new JSONObject(stringExtra).optString("hulian_extra_scene");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    HashMap<String, String> oq3 = oq(optString);
                    if (oq3 != null && oq3.get("gameseq") != null && !oq3.get("gameseq").equals("0")) {
                        if ("1".equals(oq3.get("hasFriends"))) {
                            LinearLayout linearLayout = (LinearLayout) $(R.id.fss);
                            this.Y5 = linearLayout;
                            linearLayout.setVisibility(0);
                            this.f51442a6 = (TextView) $(R.id.fsu);
                            this.Z5 = (ImageView) $(R.id.fst);
                            this.Y5.setOnClickListener(new w(optString, stringExtra2));
                            LpReportInfo_pf00064.report(122, 7, 1, this.f45117n1);
                            return;
                        }
                        return;
                    }
                    if (QZLog.isColorLevel()) {
                        QZLog.i("QZonePublishMoodNewStyleActivity", "hulian_extra_scene:" + optString);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QZLog.e("QZonePublishMoodNewStyleActivity", 1, e16, new Object[0]);
                    return;
                }
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("QZonePublishMoodNewStyleActivity", "extString:" + stringExtra + " openId" + stringExtra2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq(RelativeLayout relativeLayout) {
        if (!ParticleManager.j(getActivity()) || this.F1) {
            return;
        }
        this.f51487u5 = new ImageView(getActivity());
        Drawable loadImage = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20181029170118_ziGweKysMR.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.53
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                QZonePublishMoodNewStyleActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.53.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageView imageView = QZonePublishMoodNewStyleActivity.this.f51487u5;
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

    private void Ip(com.qzone.publish.ui.model.c cVar) {
        HashMap<String, String> b16;
        String stringExtra = getIntent().getStringExtra("extendInfo");
        if (TextUtils.isEmpty(stringExtra) || (b16 = com.qzone.util.r.b(stringExtra)) == null || b16.isEmpty()) {
            return;
        }
        cVar.d().putAll(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iq(int i3) {
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpPhoto", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u5f20\u7167\u7247\u5417\uff1f");
        e9.a aVar = this.T;
        if (aVar != null && aVar.h0(i3)) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGiveUpVideo", "\u653e\u5f03\u4e0a\u4f20\u8fd9\u4e2a\u89c6\u9891\u5417\uff1f");
        }
        new com.qzone.component.e().g(getActivity(), config, null, new h(i3), null);
    }

    private void Jq() {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.qzone.util.l.a(R.string.gef), com.qzone.util.l.a(R.string.gd5), com.qzone.util.l.a(R.string.gee), new p(), new q()).show();
    }

    private void Kp(com.qzone.publish.ui.model.c cVar) {
        bm.a aVar;
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
            QZLog.d("QZonePublishMoodNewStyleActivity", 1, "mini app comm_recom_bottom: " + stringExtra2);
        }
        String tp5 = tp();
        if (!TextUtils.isEmpty(tp5)) {
            cVar.e().put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, tp5);
            if (!TextUtils.isEmpty(this.f51514j6)) {
                QZLog.d("QZonePublishMoodNewStyleActivity", 2, "third_party_id: " + tp5 + ",third_party_url: " + this.f51514j6);
                cVar.e().put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, this.f51514j6);
            }
        }
        Map<String, String> sp5 = sp();
        if (sp5 != null) {
            cVar.e().putAll(sp5);
        }
        cVar.e().put(QZonePublishMoodRequest.KEY_APPID_FOR_CLIENT_FAKE_FEED, String.valueOf(311));
        if (this.f51527w6 != null) {
            cVar.e().put(QZonePublishMoodRequest.KEY_INFO_HOLIDAY_PUBLISH, this.f51527w6.c());
            cVar.e().put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, this.f51527w6.i());
            com.qzone.reborn.util.i.b().r(com.qzone.common.business.service.d.INSTANCE.b(this.f51459f6), this.f51527w6.c());
        }
        cVar.e().put(QZonePublishMoodRequest.IS_INTEGRATION_VIDEO, "0");
        if (this.f51525u6 != null && (aVar = this.f51523s6) != null) {
            cVar.e().put(QZonePublishMoodRequest.KEY_EDIT_MEHOD, this.f51525u6.X1(aVar.O1()));
        }
        if (mq()) {
            cVar.e().put("keyIsSyncWechat", Qp());
        }
    }

    private void Kq() {
        RedDotImageView redDotImageView;
        if (this.f51485t5 != null && (redDotImageView = this.f45113m0) != null) {
            redDotImageView.setVisibility(4);
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.20
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodNewStyleActivity.this.Sq();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Mp() {
        fm.b bVar = this.f51522r6;
        return bVar != null && bVar.S1();
    }

    private void Mq() {
        RedDotImageView redDotImageView;
        if (this.f51487u5 != null && (redDotImageView = this.f45113m0) != null) {
            redDotImageView.setVisibility(4);
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.23
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodNewStyleActivity.this.Tq();
            }
        }, 300L);
    }

    private boolean Np() {
        return com.qzone.reborn.util.l.f59550a.v(this.Q1, getIntent()) == 13;
    }

    private void Nq(String str) {
        ActionSheet actionSheet = this.I6;
        if (actionSheet == null) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogUpload", "\u7acb\u5373\u4e0a\u4f20");
            ActionSheet create = ActionSheet.create(getActivity());
            this.I6 = create;
            create.setMainTitle(str);
            this.I6.addButton(config, 0);
            this.I6.addCancelButton(com.qzone.util.l.a(R.string.j6l));
            this.I6.setOnButtonClickListener(new m(config));
            this.I6.setOnDismissListener(new n());
            this.I6.show();
            return;
        }
        if (actionSheet.isShowing()) {
            return;
        }
        this.I6.show();
    }

    private boolean Op() {
        hm.b bVar = this.O1;
        return bVar != null && bVar.Q1().getValue() == Boolean.TRUE;
    }

    private boolean Pp() {
        Boolean value = this.O1.S1().getValue();
        return value != null && value.booleanValue();
    }

    private String Qp() {
        com.qzone.reborn.part.publish.mood.sync.o oVar = this.f51524t6;
        if (oVar != null && Boolean.TRUE.equals(oVar.U1().getValue())) {
            return "true";
        }
        return "false";
    }

    private void Rq() {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText == null) {
            return;
        }
        extendEditText.setFocusable(true);
        this.f45104j0.requestFocus();
        this.f45104j0.setFocusableInTouchMode(true);
        this.f45104j0.setClearFocusOnBack(true);
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.30
            @Override // java.lang.Runnable
            public void run() {
                ExtendEditText extendEditText2 = QZonePublishMoodNewStyleActivity.this.f45104j0;
                if (extendEditText2 != null) {
                    Editable text = extendEditText2.getText();
                    QZonePublishMoodNewStyleActivity.this.f45104j0.setSelection(text != null ? text.length() : 0);
                }
                QZonePublishMoodNewStyleActivity.this.showKeyboard();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sp(long j3) {
        if (com.qzone.util.image.c.M(j3)) {
            Nq(com.qzone.util.image.c.H(j3, this.f45084c1));
        } else {
            Bq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void To(RelativeLayout relativeLayout) {
        if (this.f51485t5 != null) {
            this.f51482s5 = new ImageView(getActivity());
            Drawable loadImage = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_2FkI4iOAWN.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.52
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    QZonePublishMoodNewStyleActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.52.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageView imageView = QZonePublishMoodNewStyleActivity.this.f51482s5;
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Tp() {
        final long C;
        if (this.f45084c1) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.I4;
            if (shuoshuoVideoInfo != null) {
                C = 1 == shuoshuoVideoInfo.mIsNew ? 0L : Math.round(shuoshuoVideoInfo.mEstimateSize);
            } else {
                C = this.f45099h1;
            }
        } else {
            C = com.qzone.util.image.c.C(kp(), oj(), this.D0, this.E0);
        }
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.h
            @Override // java.lang.Runnable
            public final void run() {
                QZonePublishMoodNewStyleActivity.this.Sp(C);
            }
        });
    }

    private void Uo(Intent intent) {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null) {
            if (extendEditText.getEditableText() != null) {
                this.f45129s0 = this.f45104j0.getEditableText().toString();
            }
            this.f45104j0.addTextChangedListener(this.E6);
        }
        com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
        if (QZoneHelper.Constants.INTENT_ACTION_QZONE_OPEN_SHARE.equalsIgnoreCase(lVar.o(this.Q1, intent))) {
            this.Z4 = true;
            this.f45111l1 = 206;
            String l3 = lVar.l(this.Q1, intent);
            pq(l3);
            QZLog.d("QZonePublishMoodNewStyleActivity", 2, "parseIntent videoPath:" + l3);
        }
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || aVar.v() == null) {
            return;
        }
        this.C.v().setTextSize(17.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Up(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Rq();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Uq() {
        String d16;
        if (com.qzone.reborn.util.k.f59549a.f()) {
            d16 = this.f51527w6.e();
        } else {
            d16 = this.f51527w6.d();
        }
        String a16 = com.tencent.mobileqq.service.qzone.e.f286406a.a(d16);
        Option obtain = Option.obtain();
        obtain.setUrl(a16);
        obtain.setIsNinePatch(true);
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new IPicLoadStateListener() { // from class: com.qzone.publish.ui.activity.g
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZonePublishMoodNewStyleActivity.this.Zp(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vp() {
        this.f51528x6.performClick();
    }

    private void Vq() {
        ExtendEditText extendEditText;
        if (TextUtils.isEmpty(this.f51529y6) || (extendEditText = this.f45104j0) == null) {
            return;
        }
        extendEditText.setHint(this.f51529y6);
    }

    private boolean Wo() {
        return !this.f45090e1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Wp(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f51528x6.post(new Runnable() { // from class: com.qzone.publish.ui.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePublishMoodNewStyleActivity.this.Vp();
                }
            });
        }
        return this.f45104j0.dispatchTouchEvent(motionEvent);
    }

    private boolean Xo() {
        if (lp() == null || this.O1.U1() == 1 || this.J6) {
            return false;
        }
        this.J6 = true;
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
        Jq();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Xp(View view) {
        this.f45104j0.performLongClick();
        return true;
    }

    private void Xq() {
        this.f45104j0.setFilters(new InputFilter[]{new g(12), new InputFilter() { // from class: com.qzone.publish.ui.activity.c
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
                CharSequence aq5;
                aq5 = QZonePublishMoodNewStyleActivity.aq(charSequence, i3, i16, spanned, i17, i18);
                return aq5;
            }
        }});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yo(String str) {
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
            QZLog.i("QZonePublishMoodNewStyleActivity", 2, "scene_type: " + sb5.substring(0, sb5.length() - 1));
        }
        com.qzone.business.plusunion.business.a.h().t(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yp() {
        com.tencent.mobileqq.service.qzone.bean.c cVar = this.f51527w6;
        if (cVar != null && !TextUtils.isEmpty(cVar.f())) {
            this.f45104j0.setHint(this.f51527w6.f());
        }
        Vq();
    }

    private void Zo() {
        if (u5.b.D(QZoneHelper.QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG, false)) {
            u5.b.o0(QZoneHelper.QZONE_KEY_PUBLISH_MOOD_CAMERA_FLAG, false);
            fl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zp(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess() && option.getResultBitMap() != null && NinePatch.isNinePatchChunk(option.getResultBitMap().getNinePatchChunk())) {
            this.f45104j0.setBackground(RFWNinePatchUtils.getNinePatchDrawable(option.getResultBitMap()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bp() {
        return LoginData.getInstance().isQzoneVip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(Intent intent) {
        PerfTracer.trace(PerfTracer.PUBLISHMOOD_INITUI, PerfTracer.PUBLISHMOOD_INITDATA);
        initData(intent);
        PerfTracer.traceEnd(PerfTracer.PUBLISHMOOD_INITDATA);
        Uo(intent);
    }

    private void cq() {
        Wq(u5.b.G(mp("shuoshuo_sync_bits"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(int i3) {
        ClickReport.m("46", "5", "2");
        final String str = (oj() == null || i3 >= oj().size()) ? null : oj().get(i3);
        Yk(i3);
        if (!TextUtils.isEmpty(str)) {
            HashMap<String, ShuoshuoVideoInfo> hashMap = this.Z;
            if (hashMap != null && hashMap.size() > 0) {
                this.Z.remove(str);
            }
            HashMap<String, MarkUinInfoBeforeUpload> hashMap2 = this.U1;
            if (hashMap2 != null) {
                hashMap2.remove(str);
            }
            HashMap<String, Boolean> hashMap3 = this.V1;
            if (hashMap3 != null) {
                hashMap3.remove(str);
            }
            HashMap<String, ArrayList<FaceData>> hashMap4 = this.X1;
            if (hashMap4 != null) {
                hashMap4.remove(str);
            }
            HashMap<String, Boolean> hashMap5 = this.W1;
            if (hashMap5 != null) {
                hashMap5.remove(str);
            }
        }
        this.P.n1(i3, new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.18
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).A0 != null && ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).A0.size() > 0) {
                    ((PhotoActivity) QZonePublishMoodNewStyleActivity.this).A0.remove(str);
                }
                if (QZonePublishMoodNewStyleActivity.this.oj() != null && QZonePublishMoodNewStyleActivity.this.oj().size() < QZonePublishMoodNewStyleActivity.this.dj()) {
                    QZonePublishMoodNewStyleActivity.this.T.o0(true, true);
                }
                QZonePublishMoodNewStyleActivity.this.ui();
                QZonePublishMoodNewStyleActivity.this.rq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep() {
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
    public void fp() {
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

    private void gq() {
        if (Mp()) {
            if (TextUtils.isEmpty(this.f45104j0.getText().toString()) && this.W.isEmpty()) {
                Vo();
                return;
            }
            ActionSheet create = ActionSheet.create(getActivity());
            create.addButton(R.string.f2192265u, 3);
            create.addButton(R.string.cancel, 5);
            create.setOnButtonClickListener(new t(create));
            create.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp() {
        if (this.f51482s5 != null) {
            this.f45113m0.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(280L);
            alphaAnimation.setFillAfter(true);
            this.f45116n0.startAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            scaleAnimation.setStartOffset(160L);
            scaleAnimation.setAnimationListener(this.H6);
            this.f51482s5.startAnimation(scaleAnimation);
        }
    }

    private void hq(final boolean z16) {
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.45
            @Override // java.lang.Runnable
            public void run() {
                if (((PhotoActivity) QZonePublishMoodNewStyleActivity.this).f45101i0 != null) {
                    if (z16) {
                        QZonePublishMoodNewStyleActivity.this.showKeyboard();
                        return;
                    }
                    QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
                    if (qZonePublishMoodNewStyleActivity.f45104j0 != null) {
                        ((PhotoActivity) qZonePublishMoodNewStyleActivity).f45101i0.hideSoftInputFromWindow(QZonePublishMoodNewStyleActivity.this.f45104j0.getWindowToken(), 0);
                    }
                }
            }
        }, 300L);
    }

    private void initConfig() {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_MOOD_PHOTO_MAX_NUM, 50);
        com.qzone.publish.ui.model.b.f51929c = config;
        if (config > com.qzone.util.y.b()) {
            com.qzone.publish.ui.model.b.f51929c = com.qzone.util.y.b();
        }
        this.B5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_ENABLE_TEMPLATESHUOSHUO, 1) == 1;
        this.C5 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_ENABLE_VOICE_SHUOSHUO_H5, 0) == 1;
        this.A5 = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_MOOD_EVENT_TAG_JUMP_PAGE, QzoneConfig.QZONE_MOOD_EVENT_TAG_USE_H5, 1) == 1;
        this.Y4 = uq3.c.z6() && !com.qzone.util.l.a(R.string.f172540rs4).equals(this.V5);
    }

    private void initUI() {
        Cp();
        Dp();
        Lp();
        Bp();
        Ep();
        cq();
        this.J1.z();
        Hp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ip() {
        if (this.f51487u5 != null) {
            this.f45113m0.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(280L);
            alphaAnimation.setFillAfter(true);
            this.f45116n0.startAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            scaleAnimation.setStartOffset(160L);
            scaleAnimation.setAnimationListener(this.G6);
            this.f51487u5.startAnimation(scaleAnimation);
        }
    }

    private void iq(final PicInfo picInfo) {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.u().setEnabled(false);
        }
        final String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastChoosePicFailForNetWork", "\u56fe\u7247\u9009\u62e9\u5931\u8d25\uff0c\u7f51\u7edc\u9519\u8bef");
        ImageLoader.getInstance().downloadImageOnly(picInfo.pic_url, new ImageLoader.ImageDownloadListener() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.39
            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadCanceled(String str) {
                com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodNewStyleActivity.this.C;
                if (aVar2 != null) {
                    aVar2.u().setEnabled(false);
                }
                ToastUtil.r(config);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadFailed(String str) {
                com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodNewStyleActivity.this.C;
                if (aVar2 != null) {
                    aVar2.u().setEnabled(false);
                }
                ToastUtil.r(config);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadProgress(String str, long j3, final float f16) {
                QZonePublishMoodNewStyleActivity.this.getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.39.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodNewStyleActivity.this.C;
                        if (aVar2 != null) {
                            aVar2.u().setText("" + (f16 * 100.0f) + "%");
                        }
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
            public void onDownloadSucceed(final String str) {
                QZonePublishMoodNewStyleActivity.this.getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.qzone.common.activities.titlebuilder.a aVar2 = QZonePublishMoodNewStyleActivity.this.C;
                        if (aVar2 != null) {
                            aVar2.u().setEnabled(true);
                        }
                        QZLog.d("QZonePublishMoodNewStyleActivity", 4, "download succeed, " + str);
                        if (QZonePublishMoodNewStyleActivity.this.fi(str)) {
                            e9.a aVar3 = QZonePublishMoodNewStyleActivity.this.T;
                            if (aVar3 != null) {
                                aVar3.notifyDataSetChanged();
                            }
                            AnonymousClass39 anonymousClass39 = AnonymousClass39.this;
                            HashMap<String, PicInfo> hashMap = QZonePublishMoodNewStyleActivity.this.f51486u2;
                            PicInfo picInfo2 = picInfo;
                            hashMap.put(picInfo2.pic_url, picInfo2);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jp() {
        String f16 = ag.f(this.I4.mVideoPath);
        if (TextUtils.isEmpty(f16)) {
            return;
        }
        this.I4.mCoverUrl = f16;
    }

    private void jq() {
        com.qzone.publish.ui.model.e eVar = this.L4;
        String str = eVar != null ? eVar.f51976b : null;
        final String str2 = eVar != null ? eVar.f51978d : null;
        if (str != null && str.length() > 0 && getActivity() != null) {
            try {
                yo.d.d(str, getActivity(), null);
                QZLog.i("QZonePublishMoodNewStyleActivity", 1, "click tips view,handle scheme:" + str);
            } catch (Throwable th5) {
                QZLog.w("QZonePublishMoodNewStyleActivity", "click tips view,exception handle scheme:" + str, th5);
            }
        } else {
            this.D4.setVisibility(8);
            com.qzone.publish.ui.model.e eVar2 = this.L4;
            if (eVar2 != null) {
                eVar2.a();
            }
            QZLog.i("QZonePublishMoodNewStyleActivity", 1, "click tips view,set invisible");
        }
        if (str2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.43
                @Override // java.lang.Runnable
                public void run() {
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str2, null);
                }
            });
        }
    }

    private void kq(Intent intent) {
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
            iq(picInfo);
        } else if (fi(picInfo.pic_url)) {
            e9.a aVar = this.T;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            this.f51486u2.put(picInfo.pic_url, picInfo);
        }
        this.M6.put(picInfo.pic_url, new Pair<>(Wi(), String.valueOf(intExtra)));
        this.J1.H(false, this.P, this.T, null, getActivity());
        if (QZLog.isColorLevel()) {
            QZLog.d("QZonePublishMoodNewStyleActivity", 2, "onWebPicSelected:", picInfo.pic_url, ",entryid:", Wi(), ",source_id:", Integer.valueOf(intExtra));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(String str) {
        com.qzone.common.activities.base.ak.Q(getActivity(), com.qzone.common.activities.base.ak.r(getActivity(), str, getResources().getString(R.string.gln), false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 999);
    }

    public static String mp(String str) {
        return str + "_" + LoginData.getInstance().getUin();
    }

    private boolean mq() {
        return oo.b.m() && !bl.b(oj());
    }

    private void np() {
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

    private Map<String, String> op(Map<String, String> map) {
        fm.b bVar = this.f51522r6;
        if (bVar != null && bVar.S1()) {
            com.tencent.mobileqq.service.qzone.bean.c c16 = com.tencent.mobileqq.service.qzone.a.f286399a.c();
            if (c16 == null) {
                return map;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("feed_res", new Gson().toJson(new com.tencent.mobileqq.service.qzone.bean.a(new a.C8576a("", "", c16.d(), c16.e(), c16.g(), c16.h()))));
        }
        return map;
    }

    private HashMap<String, String> oq(String str) {
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

    private String pp() {
        if (getIntent() == null || getIntent().getExtras() == null) {
            return null;
        }
        return getIntent().getExtras().getString(QQWinkConstants.PUBLISH_JS_BRIDGE_AD_ID);
    }

    private void pq(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final long c16 = ag.c(str);
        final long m3 = com.tencent.mobileqq.filemanager.util.q.m(str);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.48
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    QZonePublishMoodNewStyleActivity.this.Z4 = false;
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (!new File(str).exists()) {
                    QZonePublishMoodNewStyleActivity.this.Z4 = false;
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
                String str2 = str;
                long j3 = m3;
                long j16 = c16;
                qZonePublishMoodNewStyleActivity.I4 = ag.q(str2, j3, 1, null, 0, 0, 0L, j16, j16, false, null);
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity2 = QZonePublishMoodNewStyleActivity.this;
                qZonePublishMoodNewStyleActivity2.f45084c1 = true;
                qZonePublishMoodNewStyleActivity2.f45096g1 = str;
                qZonePublishMoodNewStyleActivity2.Gn(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String qp() {
        if (TextUtils.isEmpty(this.f51515k6)) {
            this.f51515k6 = com.qzone.reborn.part.publish.mood.imageai.f.c();
        }
        return this.f51515k6;
    }

    private QZonePublishSyncQCirclePart rp() {
        if (this.f51519o6 == null) {
            QZonePublishSyncQCirclePart qZonePublishSyncQCirclePart = new QZonePublishSyncQCirclePart();
            this.f51519o6 = qZonePublishSyncQCirclePart;
            qZonePublishSyncQCirclePart.Cb(586, 62);
            Bundle bundle = new Bundle();
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_PART_NAME, QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_SHUOSHUO);
            String pp5 = pp();
            if (!TextUtils.isEmpty(pp5)) {
                bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, pp5);
            } else {
                bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, "qzone-syncshuoshuo-0001");
            }
            this.f51519o6.Eb(bundle);
        }
        return this.f51519o6;
    }

    private Map<String, String> sp() {
        DynamicArrayList<String> dynamicArrayList = this.U;
        if (dynamicArrayList == null || dynamicArrayList.size() <= 0) {
            return null;
        }
        return this.f51516l6.get(this.U.get(0));
    }

    private void sq() {
        this.O1.a2().observeForever(new o());
    }

    private String tp() {
        if (!TextUtils.isEmpty(this.f51513i6)) {
            QZLog.d("QZonePublishMoodNewStyleActivity", 2, "getThirdPartyAppId: from mThirdPartyAppId" + this.f51513i6);
            return this.f51513i6;
        }
        if (!TextUtils.isEmpty(this.f45117n1)) {
            QZLog.d("QZonePublishMoodNewStyleActivity", 2, "getThirdPartyAppId: from open_appid" + this.f51513i6);
            return this.f45117n1;
        }
        return "";
    }

    private void tq(String str, boolean z16) {
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

    private void uq() {
        if (this.f51458f5 || oj().size() <= 0 || TextUtils.isEmpty(this.f51452d5) || !Aq(oj())) {
            return;
        }
        this.f51458f5 = true;
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.f51452d5, LoginData.getInstance().getUinString());
        QZLog.i("QZonePublishMoodNewStyleActivity", "reportExposeAd");
    }

    private void vq() {
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("leadtype");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            LpReportInfo_pf00064.allReport(133, 19, 2, (String) null, (String) null, stringExtra);
        }
    }

    private void xp(Intent intent) {
        com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
        String E = lVar.E(this.Q1, intent);
        String F = lVar.F(this.Q1, intent);
        if (TextUtils.isEmpty(E) || TextUtils.isEmpty(F)) {
            return;
        }
        PublishEventTag publishEventTag = new PublishEventTag();
        String f16 = lVar.f(this.Q1, intent);
        String D = lVar.D(this.Q1, intent);
        if (!TextUtils.isEmpty(D)) {
            publishEventTag = new PublishEventTag();
            publishEventTag.title = E;
            publishEventTag.uin = F;
            publishEventTag.f45887protocol = D;
            publishEventTag.advId = f16;
        } else if (!TextUtils.isEmpty(F) && (publishEventTag = PublishEventTag.assembleFakeTag(E, F)) != null) {
            publishEventTag.advId = f16;
        }
        EventCenter.getInstance().post("WriteOperation", 63, publishEventTag);
    }

    public static void zq(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 == 1) {
            hashMap.put("publish_page_schedule_delete_exposure", "1");
            QZLog.i("QZonePublishMoodNewStyleActivity", "publish page schedule delete exposure");
        } else if (i3 == 2) {
            hashMap.put("publish_page_schedule_delete", "1");
            QZLog.i("QZonePublishMoodNewStyleActivity", "publish page schedule delete");
        } else if (i3 == 3) {
            hashMap.put("publish_page_schedule_delete_has_video", "1");
            QZLog.i("QZonePublishMoodNewStyleActivity", "publish page schedule delete has video");
        }
        if (hashMap.size() > 0) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.QZONE_MOOD_SCHEDULE_DELETE_VIDEO_TAG, true, 0L, 0L, hashMap, (String) null, true);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int Aj() {
        return R.layout.bq6;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Ak(String str) {
        return this.f51516l6.containsKey(str);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void An() {
        LbsDataV2.PoiInfo poiInfo;
        this.f51451d4.setVisibility(0);
        this.P.setVisibility(4);
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.I4;
        if (shuoshuoVideoInfo != null && shuoshuoVideoInfo.mVideoType == 1) {
            Oq();
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
        QZLog.e("QZonePublishMoodNewStyleActivity", "get URL info failed!");
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f9, code lost:
    
        if (r4.mDuration != r4.mTotalDuration) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0566  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x034e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Bq() {
        Intent intent;
        Intent intent2;
        String str;
        Intent intent3;
        String str2;
        Long value;
        Long value2;
        Map<String, String> map;
        Map<String, String> map2;
        Integer value3;
        DynamicArrayList<String> dynamicArrayList;
        com.qzone.publish.ui.state.a aVar;
        DynamicArrayList<String> dynamicArrayList2;
        int i3;
        Intent intent4;
        DynamicArrayList<String> dynamicArrayList3;
        Intent intent5;
        int i16;
        LocalMediaInfo localMediaInfo;
        boolean z16;
        HashMap<String, Integer> hashMap;
        boolean z17;
        int i17;
        com.qzone.publish.ui.state.a aVar2;
        if (this.K6) {
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
        if (Xo()) {
            gm(true);
            return;
        }
        xq(lp());
        this.J6 = false;
        Long value4 = this.O1.Z1().getValue();
        if (value4 != null && value4.longValue() > (System.currentTimeMillis() / 1000) + com.qzone.publish.ui.model.b.f51927a) {
            ToastUtil.r(getString(R.string.glv));
            gm(true);
            return;
        }
        this.K6 = true;
        String Vi = Vi();
        Boolean value5 = this.P1.T1().getValue();
        if (value5 != null && value5.booleanValue()) {
            Vi = "qm" + Vi;
        }
        final String str3 = Vi;
        u5.b.f1(1, LoginData.getInstance().getUin());
        List<String> list = this.R2;
        if (list != null && list.size() > 0) {
            for (String str4 : this.R2) {
                if (!TextUtils.isEmpty(str4)) {
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_BANNER_RECENT_PHOTO_BLACKLIST, str4);
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST, str4);
                }
            }
            this.R2.clear();
        }
        if (this.G && !this.f45090e1 && (aVar2 = this.Y2) != null) {
            aVar2.k();
        }
        QZonePreUploadInfo qZonePreUploadInfo = new QZonePreUploadInfo();
        qZonePreUploadInfo.preUploadedPaths = null;
        qZonePreUploadInfo.preUploadingRequest = null;
        qZonePreUploadInfo.preUploadType = 0;
        Intent intent6 = getIntent();
        String stringExtra = intent6 != null ? intent6.getStringExtra("key_ext_param") : null;
        boolean z18 = !this.V0 && ((i17 = this.K0) == 1 || i17 == 3) && this.T0 == null;
        Ok();
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("is_feeds_long_pics_browsing_mode", 1 == getShowType() ? "1" : "0");
        if (!TextUtils.isEmpty(this.W5)) {
            hashMap2.put(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, this.W5);
        }
        if (!TextUtils.isEmpty(this.X5)) {
            hashMap2.put(PeakConstants.KEY_QQ_CAMERA_SCHEME, this.X5);
        }
        qq(hashMap2);
        if (!mq()) {
            this.f51517m6.E9(getIntent());
        }
        String str5 = "";
        if (((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).H != null) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).H = "";
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("videomood", 4, "sendMood mVideoInfo=" + this.I4);
        }
        if (this.I4 != null) {
            boolean Pp = Pp();
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.I4;
            shuoshuoVideoInfo.mIsUploadOrigin = Pp;
            if (shuoshuoVideoInfo.mNeedProcess) {
                if (Pp) {
                    intent = intent6;
                } else {
                    intent = intent6;
                }
                z17 = true;
                shuoshuoVideoInfo.mNeedProcess = z17;
            } else {
                intent = intent6;
            }
            z17 = false;
            shuoshuoVideoInfo.mNeedProcess = z17;
        } else {
            intent = intent6;
        }
        if (intent != null) {
            intent2 = intent;
            str = com.qzone.reborn.util.l.f59550a.x(this.Q1, intent2);
        } else {
            intent2 = intent;
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "shuoshuoOther";
        }
        String str6 = str;
        Map<String, String> z19 = ((LBSModule) hj(LBSModule.class)).z();
        if (z19 == null) {
            z19 = new HashMap<>();
        }
        Map<String, String> map3 = z19;
        if (this.L) {
            map3.put(QZonePublishMoodRequest.EXT_INFO_KEY_DELETE_TIME, String.valueOf(86400L));
        }
        if (pk()) {
            String stringExtra2 = getIntent().getStringExtra(QZoneShareManager.QZONE_SHARE_EXTSTRING);
            Map<? extends String, ? extends String> hashMap3 = new HashMap<>();
            intent3 = intent2;
            try {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Iterator it = keys;
                    String str7 = (String) keys.next();
                    str2 = str5;
                    try {
                        hashMap3.put(str7, jSONObject.getString(str7));
                        str5 = str2;
                        keys = it;
                    } catch (Exception e16) {
                        e = e16;
                        QZLog.e("QZonePublishMoodNewStyleActivity", "parse shareinfo error", e);
                        map3.put(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, this.f45117n1);
                        if (hashMap3.size() > 0) {
                        }
                        map3.putAll(hashMap2);
                        Map<String, String> uj5 = uj(Zi(map3));
                        Font Yi = Yi();
                        value = this.O1.Z1().getValue();
                        value2 = this.O1.X1().getValue();
                        if (value2 == null) {
                        }
                        if (value == null) {
                        }
                        if (value2.longValue() > 0) {
                        }
                        map = uj5;
                        map2 = op(map);
                        HashMap<String, String> Wl = Wl(new HashMap<>());
                        this.f45121o2 = false;
                        np();
                        if (!this.f51518n6.C9()) {
                        }
                        com.qzone.publish.ui.model.c cVar = new com.qzone.publish.ui.model.c();
                        cVar.f51934b = str3;
                        cVar.f51954p = map2;
                        cVar.f51938d = this.Q4;
                        cVar.f51946h = this.I4;
                        cVar.f51947i = this.f51486u2;
                        cVar.f51948j = !z18 ? this.M0 : null;
                        cVar.f51949k = false;
                        cVar.f51952n = this.S2;
                        cVar.f51953o = qZonePreUploadInfo;
                        cVar.f51955q = Yi;
                        cVar.V = this.O5;
                        cVar.f51956r = this.D0;
                        cVar.f51936c = oj();
                        cVar.f51950l = value5.booleanValue();
                        cVar.f51957s = value.longValue();
                        cVar.f51958t = value2.longValue();
                        value3 = this.O1.T1().getValue();
                        if (value3 != null) {
                        }
                        cVar.f51960v = this.O1.W1().getValue();
                        cVar.f51951m = this.f51444b4;
                        cVar.f51961w = stringExtra;
                        cVar.f51962x = this.M0;
                        cVar.f51964z = this.f45111l1;
                        cVar.C = lp();
                        cVar.E = hashMap2;
                        cVar.I = str6;
                        cVar.L = Wl;
                        Kp(cVar);
                        Ip(cVar);
                        cVar.f51945g0 = this.f51459f6;
                        if (!this.f45090e1) {
                        }
                        dynamicArrayList = this.U;
                        if (dynamicArrayList != null) {
                            final ArrayList arrayList = new ArrayList(this.U);
                            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.34
                                @Override // java.lang.Runnable
                                public void run() {
                                    EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList.toArray());
                                }
                            });
                        }
                        getPartManager().broadcastMessage("event_on_send_mood", this.f51459f6);
                        this.f45120o1 = true;
                        aVar = this.Y2;
                        if (aVar != null) {
                        }
                        if (this.I4 != null) {
                        }
                        if (this.f51518n6.C9()) {
                        }
                        dynamicArrayList2 = this.U;
                        if (dynamicArrayList2 != null) {
                        }
                        i3 = 0;
                        this.f45103i2 = i3;
                        intent4 = new Intent();
                        intent4.putExtra("finish_video_component", true);
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        dynamicArrayList3 = this.U;
                        if (dynamicArrayList3 != null) {
                            intent4.putStringArrayListExtra("imageUrl", this.U);
                            while (i16 < 3) {
                                localMediaInfo = this.W.get(this.U.get(i16));
                                if (localMediaInfo != null) {
                                }
                            }
                        }
                        intent4.putExtra("PUBLISH_RESULT_CODE", 1);
                        getActivity().setResult(-1, intent4);
                        intent5 = intent3;
                        if (!"android.intent.action.SEND".equals(com.qzone.reborn.util.l.f59550a.o(this.Q1, intent5))) {
                        }
                    }
                }
                str2 = str5;
            } catch (Exception e17) {
                e = e17;
                str2 = str5;
            }
            map3.put(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, this.f45117n1);
            if (hashMap3.size() > 0) {
                map3.putAll(hashMap3);
            }
        } else {
            intent3 = intent2;
            str2 = "";
        }
        map3.putAll(hashMap2);
        Map<String, String> uj52 = uj(Zi(map3));
        Font Yi2 = Yi();
        value = this.O1.Z1().getValue();
        value2 = this.O1.X1().getValue();
        if (value2 == null) {
            value2 = 0L;
        }
        if (value == null) {
            value = 0L;
        }
        if (value2.longValue() > 0) {
            if (uj52 == null) {
                uj52 = new HashMap<>();
            }
            uj52.put(QZonePublishMoodRequest.EXT_INFO_KEY_DELETE_TIME, String.valueOf(value2));
        }
        map = uj52;
        try {
            map2 = op(map);
        } catch (Exception e18) {
            QLog.e("QZonePublishMoodNewStyleActivity", 1, "getHolidayBubbleInfo   e = " + e18);
            map2 = map;
        }
        HashMap<String, String> Wl2 = Wl(new HashMap<>());
        this.f45121o2 = false;
        np();
        if (!this.f51518n6.C9()) {
            this.O5 = null;
        }
        com.qzone.publish.ui.model.c cVar2 = new com.qzone.publish.ui.model.c();
        cVar2.f51934b = str3;
        cVar2.f51954p = map2;
        cVar2.f51938d = this.Q4;
        cVar2.f51946h = this.I4;
        cVar2.f51947i = this.f51486u2;
        cVar2.f51948j = !z18 ? this.M0 : null;
        cVar2.f51949k = false;
        cVar2.f51952n = this.S2;
        cVar2.f51953o = qZonePreUploadInfo;
        cVar2.f51955q = Yi2;
        cVar2.V = this.O5;
        cVar2.f51956r = this.D0;
        cVar2.f51936c = oj();
        cVar2.f51950l = value5.booleanValue();
        cVar2.f51957s = value.longValue();
        cVar2.f51958t = value2.longValue();
        value3 = this.O1.T1().getValue();
        if (value3 != null) {
            cVar2.f51959u = value3.intValue();
        }
        cVar2.f51960v = this.O1.W1().getValue();
        cVar2.f51951m = this.f51444b4;
        cVar2.f51961w = stringExtra;
        cVar2.f51962x = this.M0;
        cVar2.f51964z = this.f45111l1;
        cVar2.C = lp();
        cVar2.E = hashMap2;
        cVar2.I = str6;
        cVar2.L = Wl2;
        Kp(cVar2);
        Ip(cVar2);
        cVar2.f51945g0 = this.f51459f6;
        if (!this.f45090e1) {
            this.f51517m6.G9(getIntent(), str3, cVar2);
        } else {
            Cq(cVar2);
        }
        dynamicArrayList = this.U;
        if (dynamicArrayList != null && dynamicArrayList.size() > 0) {
            final ArrayList arrayList2 = new ArrayList(this.U);
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.34
                @Override // java.lang.Runnable
                public void run() {
                    EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList2.toArray());
                }
            });
        }
        getPartManager().broadcastMessage("event_on_send_mood", this.f51459f6);
        this.f45120o1 = true;
        aVar = this.Y2;
        if (aVar != null) {
            aVar.n();
        }
        if (this.I4 != null) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_UPLOAD, "0", null);
        }
        if (this.f51518n6.C9()) {
            QzoneNewCardSkinService.F().O();
            QzoneNewCardSkinService.F().N();
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
            String str8 = str2;
            sb5.append(str8);
            i3 = 0;
            iPanoramaUtil.reportMta("upload_all_count", sb5.toString(), 0);
            ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_sphere", i19 + str8, 0);
            ((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).reportMta("upload_panorama_cylinder", i26 + str8, 0);
        }
        this.f45103i2 = i3;
        intent4 = new Intent();
        intent4.putExtra("finish_video_component", true);
        if (!TextUtils.isEmpty(str3)) {
            intent4.putExtra("BULLET_CONTENT", str3);
        }
        dynamicArrayList3 = this.U;
        if (dynamicArrayList3 != null && dynamicArrayList3.size() > 0) {
            intent4.putStringArrayListExtra("imageUrl", this.U);
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
                    intent4.putExtra(BaseProfileQZoneComponent.KEY_IS_VIDEO + i16, z16);
                }
            }
        }
        intent4.putExtra("PUBLISH_RESULT_CODE", 1);
        getActivity().setResult(-1, intent4);
        intent5 = intent3;
        if (!"android.intent.action.SEND".equals(com.qzone.reborn.util.l.f59550a.o(this.Q1, intent5))) {
            Vo();
            return;
        }
        if (this.A2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.35
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishMoodNewStyleActivity.this.Yo(str3);
                }
            });
        }
        if (intent5 != null && intent5.getBooleanExtra("key_back_to_friend_feed", false)) {
            if (this.F6 == null) {
                so.a aVar3 = new so.a(getActivity());
                this.F6 = aVar3;
                aVar3.a();
            }
            this.F6.b();
        }
        Vo();
        if (intent5 != null && intent5.getBooleanExtra(PeakConstants.KEY_IS_FROM_QZONE_AUTO_TEMPLATE, false)) {
            QZoneHelper.forwardToQZoneFriendFeedActivity(getActivity(), new Intent(getActivity(), (Class<?>) QZoneFriendFeedXActivity.class), false);
            EventCenter.getInstance().post("PageClose", 1);
            EventCenter.getInstance().post("PageClose", 2);
        }
        com.qzone.publish.ui.state.a aVar4 = this.Y2;
        if (aVar4 != null) {
            aVar4.d();
        }
        getActivity().sendBroadcast(new Intent(QZoneHelper.Constants.ACTION_SEND_MOOD_FINISH));
        yq(oj());
        if (this.f45136v1 != 4) {
            EventCenter.getInstance().post("WriteOperation", 62);
        }
        if (value.longValue() > 0) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.36
                @Override // java.lang.Runnable
                public void run() {
                    EventCenter.getInstance().post("TimerShuoShuo", 2, (Object[]) null);
                }
            }, 2000L);
        }
        tq(QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_PUBLISH_CLICK, true);
        this.J1.E(false);
        pn(false);
        if (intent5 != null) {
            int intExtra = intent5.getIntExtra(QZoneHelper.Constants.KEY_PHOTO_EVENT_TYPE, -1);
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
        if (Np()) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 14, 1);
        }
        if (this.f51466j5) {
            LpReportInfo_pf00064.allReport(586, 2, 6);
        }
        dn();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Cl() {
        com.qzone.misc.network.report.b.b(this.U4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean Di(String str) {
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

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Ek() {
        ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).G();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void El() {
        com.qzone.misc.network.report.b.n(this.U4);
    }

    public void Eq(HashMap<String, PicInfo> hashMap) {
        this.f51486u2 = hashMap;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Fi(MotionEvent motionEvent) {
        View childAt;
        DynamicGridView dynamicGridView = this.P;
        if (dynamicGridView != null && this.T != null) {
            int lastVisiblePosition = dynamicGridView.getLastVisiblePosition();
            if (!this.f45084c1 && this.T.d0(lastVisiblePosition) && (childAt = this.P.getChildAt(lastVisiblePosition)) != null && this.T.H(childAt) && aj.k(motionEvent, childAt, getTitleBarHeight(), this.mStatusBarHeight) && !Op() && (dk(true) || ak() || bk() || gk(motionEvent))) {
                fq();
                return true;
            }
        }
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Fl() {
        com.qzone.misc.network.report.b.m(this.U4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Fm(String str, String str2) {
        super.Fm(str, str2);
        Map<String, String> map = this.f51516l6.get(str);
        if (map != null) {
            this.f51516l6.put(str2, map);
            this.f51516l6.remove(str);
        }
    }

    protected void Fq() {
        View view = this.f45119o0;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Gi() {
        super.Gi();
        getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.27
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodNewStyleActivity.this.gp();
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Gl() {
        com.qzone.misc.network.report.b.r(this.U4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Gm(l5.a aVar) {
        super.Gm(aVar);
        Dq(aVar);
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                QZonePublishMoodNewStyleActivity.this.Yp();
            }
        });
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Gn(boolean z16) {
        if (!this.f45084c1 || TextUtils.isEmpty(this.f45096g1) || this.f51451d4 == null || this.f51479r4 == null || this.f51474p4 == null || this.I4 == null) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.31
            @Override // java.lang.Runnable
            public void run() {
                String str = QZonePublishMoodNewStyleActivity.this.I4.mVideoPath;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!new File(str).exists()) {
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (TextUtils.isEmpty(QZonePublishMoodNewStyleActivity.this.I4.mCoverUrl)) {
                    QZonePublishMoodNewStyleActivity.this.jp();
                } else if (!new File(QZonePublishMoodNewStyleActivity.this.I4.mCoverUrl).exists()) {
                    QZonePublishMoodNewStyleActivity.this.jp();
                }
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
                qZonePublishMoodNewStyleActivity.f51474p4.setAsyncImage(qZonePublishMoodNewStyleActivity.I4.mCoverUrl);
                String i3 = ag.i(QZonePublishMoodNewStyleActivity.this.I4.mDuration);
                QZonePublishMoodNewStyleActivity.this.f51479r4.setText("" + i3);
                QZonePublishMoodNewStyleActivity.this.An();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Hi() {
        super.Hi();
        getHandler().post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.55
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodNewStyleActivity.this.gp();
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Kj(List<LocalMediaInfo> list, Intent intent) {
        ArrayList<String> arrayList;
        super.Kj(list, intent);
        if (intent.hasExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID)) {
            this.f51513i6 = intent.getStringExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID);
            QLog.i("QZonePublishMoodNewStyleActivity", 1, "handleMediaParseIntent: " + this.f51513i6);
        }
        if (intent.hasExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL)) {
            this.f51514j6 = intent.getStringExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL);
            QLog.i("QZonePublishMoodNewStyleActivity", 1, "handleMediaParseIntent: " + this.f51514j6);
        }
        for (LocalMediaInfo localMediaInfo : list) {
            Map<String, String> nq5 = nq(localMediaInfo);
            if (nq5 == null && (arrayList = localMediaInfo.mOriginPath) != null && !arrayList.isEmpty()) {
                nq5 = this.f51516l6.get(localMediaInfo.mOriginPath.get(0));
            }
            if (nq5 != null) {
                QLog.i("QZonePublishMoodNewStyleActivity", 1, "handleMediaParseIntent map: " + nq5);
                oo.d dVar = oo.d.f423238a;
                String a16 = dVar.a(nq5);
                if (!TextUtils.isEmpty(localMediaInfo.path)) {
                    this.f51516l6.put(localMediaInfo.path, nq5);
                    if (!TextUtils.isEmpty(a16)) {
                        dVar.b(localMediaInfo.path, a16);
                    }
                }
            }
        }
        this.f51521q6.F9(intent);
        xp(intent);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Kk() {
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Li() {
        fm.b bVar = this.f51522r6;
        return bVar == null || !bVar.S1();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Lk() {
        return true;
    }

    public void Lq() {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null) {
            extendEditText.setFocusable(true);
            this.f45104j0.requestFocus();
            this.f45104j0.setClearFocusOnBack(true);
            hq(this.f45104j0.isFocused());
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Mk() {
        return true;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Nk() {
        return !Mp();
    }

    @Override // com.qzone.publish.ui.controller.a
    public void O4(View view) {
        View.OnClickListener onClickListener = this.A6;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Oj(final String str, final int i3, final int i16, final long j3, final long j16, final long j17, final boolean z16, final Bundle bundle) {
        super.Oj(str, i3, i16, j3, j16, j17, z16, bundle);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.47
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(QZonePublishMoodNewStyleActivity.this.f45096g1)) {
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (!new File(QZonePublishMoodNewStyleActivity.this.f45096g1).exists()) {
                    ToastUtil.o(R.string.glj, 4);
                    return;
                }
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("videomood", 4, "handleSelectVideoResult...");
                }
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
                qZonePublishMoodNewStyleActivity.I4 = ag.q(qZonePublishMoodNewStyleActivity.f45096g1, ((PhotoActivity) qZonePublishMoodNewStyleActivity).f45099h1, QZonePublishMoodNewStyleActivity.this.f45102i1, str, i3, i16, j3, j16, j17, z16, bundle);
                QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity2 = QZonePublishMoodNewStyleActivity.this;
                if (1 == qZonePublishMoodNewStyleActivity2.f45102i1 && qZonePublishMoodNewStyleActivity2.L4 == null) {
                    qZonePublishMoodNewStyleActivity2.dq();
                }
                QZonePublishMoodNewStyleActivity.this.Gn(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Ok() {
        DynamicArrayList<String> dynamicArrayList;
        if (this.M1 && (dynamicArrayList = this.U) != null && dynamicArrayList.size() > 0) {
            Iterator it = ((ArrayList) this.U.clone()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (this.M6.containsKey(str)) {
                    Pair<String, String> pair = this.M6.get(str);
                    String imageFilePath = CacheManager.getImageFilePath(getActivity(), str);
                    if (!TextUtils.isEmpty(imageFilePath)) {
                        this.M6.put(imageFilePath, pair);
                    }
                }
            }
        }
        super.Ok();
    }

    public void Oq() {
        runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.42
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodNewStyleActivity.this.Pq();
            }
        });
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Pl() {
        yo.d.l(getActivity(), QzoneConfig.getInstance().getConfig("H5Url", "EasterEgg", "https://h5.qzone.qq.com/mood/photoselector?_wv=2097155&_proxy=1&qua={qua}"), 200, null);
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
        return R.anim.v3;
    }

    public void So() {
        s5.a.j(this.f45104j0);
        s5.a.m(this.f45104j0);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    protected int Tm() {
        return R.anim.f155011v1;
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public String Um() {
        return ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).H;
    }

    @Override // com.qzone.publish.ui.controller.a
    public void Vf(View view) {
        View.OnClickListener onClickListener = this.L6;
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

    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Xh(ArrayList<ResultRecord> arrayList) {
        super.Xh(arrayList);
        if (this.f51526v6 != null) {
            this.f51526v6.K9(aj.f(this.f45104j0, this.f45141y0, this.H), this.f45141y0);
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public String Xm() {
        return null;
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public ShuoshuoVideoInfo Ym() {
        return this.I4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean ak() {
        boolean ak5 = super.ak();
        if (ak5) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).M(true);
        }
        return ak5;
    }

    protected void ap() {
        if (NetworkState.isWifiConn()) {
            Bq();
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.publish.ui.activity.b
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePublishMoodNewStyleActivity.this.Tp();
                }
            });
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fm.a());
        arrayList.add(this.f51520p6);
        arrayList.add(new com.qzone.reborn.part.publish.mood.sync.a(this));
        arrayList.add(this.f51517m6);
        arrayList.add(this.f51518n6);
        if (QZonePublishSyncQCirclePart.Ka()) {
            arrayList.add(rp());
        }
        arrayList.add(new em.a(this));
        zl.d dVar = new zl.d();
        this.f51526v6 = dVar;
        arrayList.add(dVar);
        arrayList.add(new QZonePublishPicToTextPart(this));
        arrayList.add(this.f51521q6);
        arrayList.add(new am.d(this));
        if (lc.b.d()) {
            arrayList.add(new qb.a("qzone_publishx_publish_mood"));
        } else {
            arrayList.add(new qb.a("qzone_publish_old_publish_mood"));
        }
        return arrayList;
    }

    public void bq() {
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
        this.M6.clear();
        this.M6.putAll(hashMap);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, c5.a
    public boolean checkNetworkConnect() {
        if (super.checkNetworkConnect()) {
            return true;
        }
        getHandler().sendEmptyMessage(100001);
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    public int dj() {
        Intent intent = getIntent();
        if (intent != null) {
            return intent.getIntExtra("key_max_photo_count", com.qzone.publish.ui.model.b.f51929c);
        }
        return com.qzone.publish.ui.model.b.f51929c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void dl(Bundle bundle) {
        super.dl(bundle);
        if (Mp()) {
            return;
        }
        int i3 = bundle.getInt("mStateType");
        this.Z2 = i3;
        com.qzone.publish.ui.state.a e16 = com.qzone.publish.ui.state.a.e(i3, this);
        this.Y2 = e16;
        e16.q(this.J);
    }

    public void dq() {
        if (u5.b.H("show_video_vip_tips", 1, LoginData.getInstance().getUin()) == 0) {
            return;
        }
        QZLog.i("QZonePublishMoodNewStyleActivity", 4, "send req loadVideoVipTipsInfos");
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), 2454), getHandler(), this, 201));
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int ej() {
        return 10000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void el(Bundle bundle) {
        super.el(bundle);
        if (Mp()) {
            return;
        }
        bundle.putInt("mStateType", this.Z2);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void en(boolean z16) {
        this.I0 = z16;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected boolean enableDaTongPageRegister() {
        return true;
    }

    protected boolean eq() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_URL_ANALYSIS, 0) == 1;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        if (this.G && !this.f45090e1 && this.Y2 != null && this.U2 && Wj()) {
            this.Y2.o();
        }
        vi();
        if (this.f51517m6.F9()) {
            return;
        }
        super.finish();
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

    @Override // com.qzone.common.activities.base.BaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("come_from", Integer.valueOf(this.f45136v1));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.SUB_SOURCE_ID, Integer.valueOf(this.f45138w1));
        hashMap.put("qz_adid", com.qzone.reborn.util.l.f59550a.f(this.Q1, getIntent()));
        if (Mp()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_holiday", str);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c());
        if (com.qzone.reborn.part.publish.mood.imageai.f.b()) {
            hashMap.put("pic_generate_text_id", qp());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return Mp() ? R.layout.f169012hl0 : R.layout.f169034bq2;
    }

    @Override // com.qzone.publish.ui.controller.a
    public String getCurrentUrl() {
        return null;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    protected String getDaTongPageId() {
        return "pg_qz_space_says_publish";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public Activity getHostActivity() {
        return getActivity();
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
        if (getActivity() == null) {
            return null;
        }
        if ((getActivity() instanceof QZonePublishMoodRealActivity) || (getActivity() instanceof QZonePublishXMoodRealActivity)) {
            return getActivity();
        }
        return null;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void hl() {
        if (((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).F()) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).L(false);
        }
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null) {
            this.f51523s6.Q1(extendEditText.getText(), aj.f(this.f45104j0, this.f45141y0, this.H));
        }
        super.hl();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void hm(final RelativeLayout relativeLayout) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.51
            @Override // java.lang.Runnable
            public void run() {
                QZonePublishMoodNewStyleActivity.this.f51485t5 = m5.a.H().J(LoginData.getInstance().getUin(), 2656);
                if (QZonePublishMoodNewStyleActivity.this.f51485t5 != null) {
                    File imageFile = ImageLoader.getInstance().getImageFile("https://qzonestyle.gtimg.cn/aoi/sola/20180328150434_2FkI4iOAWN.png");
                    if (imageFile != null && imageFile.exists()) {
                        QZonePublishMoodNewStyleActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.51.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass51 anonymousClass51 = AnonymousClass51.this;
                                QZonePublishMoodNewStyleActivity.this.To(relativeLayout);
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
                        QZonePublishMoodNewStyleActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.51.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass51 anonymousClass51 = AnonymousClass51.this;
                                QZonePublishMoodNewStyleActivity.this.Hq(relativeLayout);
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
    protected void ik() {
        getPartManager().broadcastMessage("keyboard_hide", null);
    }

    @Override // com.qzone.publish.ui.controller.a
    public boolean isActivityResume() {
        return false;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void jk() {
        getPartManager().broadcastMessage("input_menu_open", null);
        if (this.f45090e1) {
            this.f51492x2.setVisibility(8);
            return;
        }
        Kq();
        Mq();
        Gq(this.U5);
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_GIF_ICON_EXPLODE);
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
                    QZLog.e("QZonePublishMoodNewStyleActivity", "failed to parse picInfo->picwidth/picheight.", th5);
                }
                picInfo2.sourceType = 2;
                hashMap.put(picInfo2.pic_url, picInfo2);
                arrayList3.add(picInfo2.pic_url);
            }
        }
        Eq(hashMap);
        yl(arrayList3);
        bq();
    }

    public HashMap<String, ShuoshuoVideoInfo> kp() {
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

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void lm() {
        QbossAdvDesc qbossAdvDesc = this.U5;
        if (qbossAdvDesc == null) {
            Gq(qbossAdvDesc);
        }
    }

    public PublishEventTag lp() {
        return this.O1.O1().getValue();
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void mn(boolean z16) {
        this.J1.E(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void nm() {
        super.nm();
        ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).M(false);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void nn() {
        com.qzone.misc.network.report.b.k(this.U4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public boolean oi() {
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
        com.qzone.common.activities.titlebuilder.a aVar;
        super.onActivityCreated(bundle);
        PerfTracer.traceStart(PerfTracer.PUBLISHMOOD_ONCREATE);
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 62);
        EventCenter.getInstance().addUIObserver(this, "NewCardSkinFollowFeeds", 2);
        EventCenter.getInstance().addUIObserver(this, "FontQbossGifShow", 2);
        this.V2 = System.currentTimeMillis();
        this.S0 = 1;
        this.U4 = ro.a.a(getIntent());
        getWindow().setSoftInputMode(3);
        Intent intent = getIntent();
        this.f51513i6 = intent.getStringExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID);
        this.f51514j6 = intent.getStringExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL);
        this.f51445b5 = intent.getBooleanExtra(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, false);
        this.f51465i5 = intent.getBooleanExtra(QZoneJsConstants.DYNAMIC_ALBUM_IS_FROM_DRAFT, false);
        this.V5 = intent.getStringExtra("shareSource");
        this.W5 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE);
        this.X5 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME);
        this.f51466j5 = intent.getBooleanExtra(QZoneJsConstants.WRITE_MOOD_FROM_PROFILE_CARD, false);
        this.f51529y6 = intent.getStringExtra("placeholder");
        if (getActivity() != null) {
            getActivity().setTheme(R.style.a6t);
        }
        PerfTracer.traceStart(PerfTracer.PUBLISHMOOD_INITUI);
        this.I1.h(getIntent());
        Bundle bundle2 = QZonePublishMoodBaseActivity.f51439h6;
        if (bundle2 != null) {
            dl(bundle2);
        } else if (Mp() && (aVar = this.C) != null) {
            aVar.setTitle(R.string.i1w);
        } else {
            Jp(intent);
        }
        if (intent.getBooleanExtra("key_from_kuolie", false)) {
            this.F1 = true;
        }
        initConfig();
        initUI();
        if (intent.getBooleanExtra(QZoneShareManager.QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION, false)) {
            if (QZonePermission.requestStoragePermission(getRealActivity(), new j(intent), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_READ_MEDIA)) {
                cp(intent);
            }
        } else {
            cp(intent);
        }
        PerfTracer.traceEnd(PerfTracer.PUBLISHMOOD_ONCREATE);
        if (this.f45084c1) {
            com.qzone.misc.network.report.e.a(1, this.U4);
        } else {
            com.qzone.misc.network.report.e.a(3, this.U4);
        }
        com.qzone.misc.network.report.b.h(this.U4, intent);
        tq(QzoneVideoBeaconReport.EVENT_SHUOSHUO_PAGE_EXPLODE, false);
        HashMap hashMap = new HashMap();
        hashMap.put("publishMoodExplose", String.valueOf(1));
        ReportUtils.b("guessPhoto", hashMap);
        m5.a.H().F(2748, true);
        this.I1.i();
        rq();
        QZLog.d("QZonePublishMoodNewStyleActivity", 1, "onActivityCreated");
        try {
            Gp();
        } catch (Exception e16) {
            QZLog.e("QZonePublishMoodNewStyleActivity", 1, "initHolidayUI  e = " + e16);
        }
        Vq();
        sq();
        for (LocalMediaInfo localMediaInfo : this.W.values()) {
            Map<String, String> nq5 = nq(localMediaInfo);
            if (nq5 != null) {
                QLog.i("QZonePublishMoodNewStyleActivity", 1, "handleMediaParseIntent map: " + nq5);
                this.f51516l6.put(localMediaInfo.path, nq5);
            }
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 6000) {
            com.qzone.publish.ui.state.a aVar = this.Y2;
            if (aVar != null) {
                aVar.q(false);
            }
            this.J1.y();
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
        if (i3 == 200) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).z();
            if (i16 == -1) {
                kq(intent);
            }
        }
        if (i3 == 999 && i16 == -1) {
            this.K4.setText(getResources().getString(R.string.gls));
            this.J4.setText(getResources().getString(R.string.glt));
        }
        if (i3 == 20226 && i16 == -1) {
            Vo();
        }
        rq();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.publish.ui.controller.a
    public void onBack() {
        ck();
        com.qzone.publish.ui.state.a aVar = this.Y2;
        if (aVar != null) {
            aVar.r();
        }
        if (Np()) {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 14, 2);
        }
        if (this.f51466j5) {
            LpReportInfo_pf00064.allReport(586, 3, 6);
        }
        gq();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f51522r6 = (fm.b) getViewModel(fm.b.class);
        if (getActivity() != null) {
            this.f51522r6.setIntent(getActivity().getIntent());
        }
        this.f51523s6 = (bm.a) getViewModel(bm.a.class);
        this.f51524t6 = (com.qzone.reborn.part.publish.mood.sync.o) getViewModel(com.qzone.reborn.part.publish.mood.sync.o.class);
        this.f51525u6 = (com.qzone.reborn.part.publish.mood.imageai.l) getViewModel(com.qzone.reborn.part.publish.mood.imageai.l.class);
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity, com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        InputMethodManager inputMethodManager;
        EventCenter.getInstance().removeObserver(this);
        so.a aVar = this.F6;
        if (aVar != null) {
            aVar.c();
        }
        if (this.B6 != null) {
            getRealActivity().unregisterReceiver(this.B6);
        }
        QzoneGuideBubbleHelper.g().f();
        super.onDestroy();
        if (getActivity() == null || getActivity().getCurrentFocus() == null || (inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message == null) {
            return;
        }
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            QZLog.e("QZonePublishMoodNewStyleActivity", "onHandleMessage result is null");
        } else if (message.what == 1000406 && unpack.getSucceed()) {
            rp().Db(((Bundle) unpack.getData()).getBoolean(LocalMultiProcConfig.QZONE_PERMISSION_PUBLIC));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        PerfTracer.traceStart(PerfTracer.PUBLISHMOOD_ONRESUME);
        ui();
        ri(!this.f51522r6.Q1());
        Zo();
        super.onResume();
        PerfTracer.traceEnd(PerfTracer.PUBLISHMOOD_ONRESUME);
        PerfTracer.traceClick2Completed(this);
        QZLog.d("QZonePublishMoodNewStyleActivity", 1, "onResume");
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ik();
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (201 == qZoneTask.mType) {
            vp(qZoneTask);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            if (this.f51530z6) {
                Rq();
                this.f51530z6 = false;
            }
            Intent intent = getIntent();
            if (intent != null && intent.getBooleanExtra("key_show_bootom_bar_list", false)) {
                intent.removeExtra("key_show_bootom_bar_list");
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void pm() {
        super.pm();
        this.T5 = false;
        if (this.U5 != null) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(this.U5.res_traceinfo, LoginData.getInstance().getUinString());
        }
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void pn(final boolean z16) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.50
            @Override // java.lang.Runnable
            public void run() {
                if (QZonePublishMoodNewStyleActivity.this.V2 != -1) {
                    System.currentTimeMillis();
                    long j3 = QZonePublishMoodNewStyleActivity.this.V2;
                }
                if (QZonePublishMoodNewStyleActivity.this.W2 != -1) {
                    System.currentTimeMillis();
                    long j16 = QZonePublishMoodNewStyleActivity.this.W2;
                }
                if (QZonePublishMoodNewStyleActivity.this.Vi().length() > 0) {
                    QZonePublishMoodNewStyleActivity.this.E5 |= 8;
                }
                if (QZonePublishMoodNewStyleActivity.this.U != null) {
                    int i3 = 0;
                    for (int i16 = 0; i16 < QZonePublishMoodNewStyleActivity.this.U.size(); i16++) {
                        QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
                        LocalMediaInfo localMediaInfo = qZonePublishMoodNewStyleActivity.W.get(qZonePublishMoodNewStyleActivity.U.get(i16));
                        if (localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                            i3++;
                        } else if (localMediaInfo != null) {
                            QAlbumUtil.getMediaType(localMediaInfo);
                        }
                    }
                    if (i3 > 0) {
                        QZonePublishMoodNewStyleActivity.this.E5 |= 4;
                    }
                }
                if (QZonePublishMoodNewStyleActivity.this.lp() != null) {
                    QZonePublishMoodNewStyleActivity.this.E5 |= 2;
                }
                if (!TextUtils.isEmpty(QZonePublishMoodNewStyleActivity.this.O1.P1().getValue())) {
                    QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity2 = QZonePublishMoodNewStyleActivity.this;
                    qZonePublishMoodNewStyleActivity2.E5 = 1 | qZonePublishMoodNewStyleActivity2.E5;
                }
                if (z16) {
                    QZonePublishMoodNewStyleActivity.this.E5 |= 16;
                }
                if (((PhotoActivity) QZonePublishMoodNewStyleActivity.this).J1.w() != null) {
                    QZonePublishMoodNewStyleActivity.this.E5 |= 32;
                }
            }
        });
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void rn() {
        if (this.M6 == null) {
            Qm();
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Pair<String, String>> entry : this.M6.entrySet()) {
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

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean vk() {
        return true;
    }

    @Override // com.qzone.publish.ui.controller.a
    public String w() {
        return null;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int wj() {
        return R.drawable.qui_emoticon;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity, com.qzone.common.activities.base.PhotoActivity
    public boolean wk() {
        return super.wk();
    }

    public void wp(View view) {
        RDMEtraMsgCollector.getInstance().addNoramlClickAction(this.simpleClassname, view);
        com.qzone.misc.network.report.b.e(this.U4);
        ((LBSModule) hj(LBSModule.class)).C();
        ClickReport.m("437", "1", "2");
        if (this.I5) {
            return;
        }
        this.D5.append(4);
        this.I5 = true;
    }

    @Override // com.qzone.publish.ui.controller.a
    public void x4() {
        zp();
        gp();
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int xj() {
        return R.drawable.qui_keyboard_circle;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int yj() {
        return R.drawable.qui_keyboard_circle;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean yk() {
        return false;
    }

    protected void yq(ArrayList<String> arrayList) {
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
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.37
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        String str = (String) it5.next();
                        MediaUtil.saveFileToSystemAlbum(QZonePublishMoodNewStyleActivity.this.getActivity(), str, System.currentTimeMillis() + QzoneEmotionUtils.SIGN_ICON_URL_END);
                    }
                }
            });
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected int zj() {
        return R.drawable.qui_aa_method;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean zk() {
        return true;
    }

    public void zp() {
        super.ck();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements DynamicGridView.t {
        b() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.t
        public void onEditModeChanged(boolean z16) {
            if (!z16 || QZonePublishMoodNewStyleActivity.this.T.e0()) {
                return;
            }
            QZonePublishMoodNewStyleActivity.this.T.L(true);
        }
    }

    /* loaded from: classes39.dex */
    class i implements TextWatcher {
        i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (obj.equals(QZonePublishMoodNewStyleActivity.this.C6)) {
                return;
            }
            QZonePublishMoodNewStyleActivity.this.C6 = obj;
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = QZonePublishMoodNewStyleActivity.this;
            if (!qZonePublishMoodNewStyleActivity.F5) {
                qZonePublishMoodNewStyleActivity.D5.append(1);
                QZonePublishMoodNewStyleActivity.this.F5 = true;
            }
            ((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodNewStyleActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).C(obj);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null || !charSequence.toString().equals(QZonePublishMoodNewStyleActivity.this.D6)) {
                if (charSequence != null) {
                    QZonePublishMoodNewStyleActivity.this.D6 = charSequence.toString();
                }
                if (((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodNewStyleActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).A() == 0) {
                    ((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodNewStyleActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).D();
                    ((com.qzone.publish.ui.publishmodule.a) QZonePublishMoodNewStyleActivity.this.hj(com.qzone.publish.ui.publishmodule.a.class)).L(false);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class t implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f51596d;

        t(ActionSheet actionSheet) {
            this.f51596d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                QZonePublishMoodNewStyleActivity.this.Vo();
            }
            this.f51596d.dismiss();
        }
    }

    private void Wq(int i3) {
        this.Y4 = false;
        this.f51444b4 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq() {
        int i3;
        this.f45128r1 = -1;
        if (oj().size() < dj()) {
            ((com.qzone.publish.ui.publishmodule.a) hj(com.qzone.publish.ui.publishmodule.a.class)).z();
            Ml(0);
            if (this.f45079a2 && this.J1.B()) {
                i3 = 1;
            } else {
                i3 = (this.f45079a2 && this.J1.C()) ? 2 : 3;
            }
            LpReportInfo_pf00064.allReport(586, 40, i3);
            if (TextUtils.isEmpty(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHUOSHUO_CAMERA_ICON, ""))) {
                return;
            }
            LpReportInfo_pf00064.allReport(586, 40, 4);
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Cm(ArrayList<String> arrayList, ConcurrentHashMap<String, String> concurrentHashMap, String str) {
        this.f45121o2 = false;
        int gj5 = gj();
        int i3 = this.f45084c1 ? 2 : 5;
        this.f51445b5 = getIntent().getBooleanExtra(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, false);
        boolean A = this.J1.A();
        QZonePublishMoodTabActivity qZonePublishMoodTabActivity = this.f51441a5;
        if (qZonePublishMoodTabActivity != null) {
            int dj5 = dj() - gj5;
            HashMap<String, PicInfo> hashMap = this.A0;
            return cl(qZonePublishMoodTabActivity, arrayList, dj5 + (hashMap != null ? hashMap.size() : 0), false, i3, true, concurrentHashMap, this.f51445b5, A, str);
        }
        Activity realActivity = getRealActivity();
        int dj6 = dj() - gj5;
        HashMap<String, PicInfo> hashMap2 = this.A0;
        return cl(realActivity, arrayList, dj6 + (hashMap2 != null ? hashMap2.size() : 0), false, i3, true, concurrentHashMap, this.f51445b5, A, str);
    }

    public void Vo() {
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
    }

    private void Dq(l5.a aVar) {
        if (aVar == null || aVar.openBusiness != 1 || TextUtils.isEmpty(aVar.businessURL) || TextUtils.isEmpty(aVar.imageUrl)) {
            return;
        }
        ImageLoader.getInstance().loadImageAsync(aVar.imageUrl, new AnonymousClass6(aVar.businessURL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pq() {
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
        QzoneGuideBubbleHelper.g().k(getActivity(), this.f51520p6.P, str, 0, 14.0f, 5.0d, 10.0d, 1000 * j3, -15550475, false, true, ViewUtils.dpToPx(4.0f));
        QZLog.i("QZonePublishMoodNewStyleActivity", 1, "show tips");
        if (str2 != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.41
                @Override // java.lang.Runnable
                public void run() {
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(str2, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sq() {
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
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.21
                @Override // java.lang.Runnable
                public void run() {
                    m5.a.H().C(LoginData.getInstance().getUinString(), 2656);
                    QZonePublishMoodNewStyleActivity.this.f51485t5 = null;
                }
            });
            runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.22
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishMoodNewStyleActivity.this.hp();
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
    public void Tq() {
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
            runOnUiThread(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.24
                @Override // java.lang.Runnable
                public void run() {
                    QZonePublishMoodNewStyleActivity.this.ip();
                }
            }, 1600L);
            return;
        }
        RedDotImageView redDotImageView2 = this.f45113m0;
        if (redDotImageView2 != null) {
            redDotImageView2.setVisibility(0);
        }
    }

    private Map<String, String> nq(LocalMediaInfo localMediaInfo) {
        HashMap<String, Serializable> hashMap;
        if (localMediaInfo == null || (hashMap = localMediaInfo.extData) == null || !hashMap.containsKey("third_party_extend_map")) {
            return null;
        }
        Serializable serializable = localMediaInfo.extData.get("third_party_extend_map");
        if (com.qzone.util.r.a(serializable)) {
            return (Map) serializable;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LpReportInfo_pf00064 up(LpReportInfo_pf00064 lpReportInfo_pf00064) {
        if (lpReportInfo_pf00064 != null && getIntent() != null && getIntent().getExtras() != null) {
            getIntent().getExtras();
            com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
            if (lVar.c(this.Q1, getIntent())) {
                lpReportInfo_pf00064.reserves10 = lVar.f(this.Q1, getIntent());
            } else {
                String pp5 = pp();
                if (!TextUtils.isEmpty(pp5)) {
                    lpReportInfo_pf00064.reserves10 = pp5;
                }
            }
            if (lVar.d(this.Q1, getIntent())) {
                lpReportInfo_pf00064.reserves11 = lVar.E(this.Q1, getIntent());
            }
        }
        return lpReportInfo_pf00064;
    }

    public void xq(PublishEventTag publishEventTag) {
        if (publishEventTag == null || y5.a.H() == null) {
            return;
        }
        try {
            y5.a.H().J(!TextUtils.isEmpty(publishEventTag.uin) ? Long.parseLong(publishEventTag.uin) : 0L, TextUtils.isEmpty(publishEventTag.time) ? 0L : Long.parseLong(publishEventTag.time), publishEventTag.title, publishEventTag.picUrl, publishEventTag.f45886id);
        } catch (NumberFormatException unused) {
            QLog.e("QZonePublishMoodNewStyleActivity", 1, "savaEventTag numberFormat error,uin:", publishEventTag.uin, ",time:", publishEventTag.time);
        }
    }

    private boolean Aq(ArrayList<String> arrayList) {
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

    private void Cp() {
        this.f51440a3 = (RelativeLayout) $(R.id.hkh);
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.T3(R.string.gd5, this.A6);
            this.C.P(R.string.d7o, this.L6, false);
            this.C.x().setTextSize(17.0f);
            this.C.u().setTextSize(17.0f);
        }
        ExtendEditText extendEditText = (ExtendEditText) $(R.id.itv);
        this.f45104j0 = extendEditText;
        extendEditText.setMaxLineToScrollAlways(extendEditText.getMaxLines());
        if (eq()) {
            ((UrlExtendEditText) this.f45104j0).setInputUrlListener(new f());
        }
        ExtendScrollView extendScrollView = (ExtendScrollView) $(R.id.l57);
        this.M = extendScrollView;
        extendScrollView.b(R.id.itv);
        this.M.setOnDownListener(this.f45112l2);
        Yh();
        if (Wo()) {
            ai();
            Tl();
        } else {
            $(R.id.hrr).setVisibility(8);
        }
        this.f45119o0 = $(R.id.hrp);
        Fq();
        this.f45110l0 = (ImageView) $(R.id.ius);
        Sl();
        Ul();
        So();
    }

    private void Dp() {
        this.N = (ViewGroup) $(R.id.fpg);
        this.P = (DynamicGridView) $(R.id.fpf);
        TextView textView = (TextView) $(R.id.a4g);
        this.R = textView;
        textView.setBackgroundColor(Color.argb(13, 0, 0, 0));
        this.P.setNumColumns(3);
        this.P.setTranscriptMode(1);
        this.P.setStretchable(true);
        this.P.setOnItemClickListener(new z());
        e9.a aVar = new e9.a(getActivity(), this.P, 1000, 1.15f, 0);
        this.T = aVar;
        aVar.x0(true);
        if (pk()) {
            this.T.q0(true);
        }
        this.T.y0(new a());
        this.P.setAdapter((ListAdapter) this.T);
        this.P.setLetParentInterceptTouchEventAt23(false);
        this.P.setEditModeEnabled(true ^ this.f51522r6.Q1());
        this.P.setOnEditModeChangeListener(new b());
        if (this.f45134u1) {
            this.T.H0(0);
            this.f45134u1 = false;
        }
        this.P.setOnDragListener(new c());
        this.D0 = v5.a.a().d(ImageQualityPreference.TYPE_SHUOSHUO_ALL_PIC);
        this.O4 = $(R.id.br6);
        AsyncImageView asyncImageView = (AsyncImageView) $(R.id.br7);
        this.P4 = asyncImageView;
        asyncImageView.setOnClickListener(new d());
        this.Q = (AsyncMarkGifImageView) $(R.id.dwb);
        AsyncMarkGifImageView asyncMarkGifImageView = (AsyncMarkGifImageView) findViewById(R.id.dwb);
        this.Q = asyncMarkGifImageView;
        asyncMarkGifImageView.setCornerRadius(ViewUtils.dip2px(4.0f));
        this.S = (TextView) $(R.id.k7m);
        this.Q.setOnClickListener(new e());
    }

    private void Fp() {
        String str;
        LinearLayout linearLayout = (LinearLayout) $(R.id.yol);
        this.f51528x6 = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.publish.ui.activity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePublishMoodNewStyleActivity.this.Up(view);
            }
        });
        this.f51528x6.setOnTouchListener(new View.OnTouchListener() { // from class: com.qzone.publish.ui.activity.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Wp;
                Wp = QZonePublishMoodNewStyleActivity.this.Wp(view, motionEvent);
                return Wp;
            }
        });
        this.f51528x6.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.publish.ui.activity.f
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean Xp;
                Xp = QZonePublishMoodNewStyleActivity.this.Xp(view);
                return Xp;
            }
        });
        if (QQTheme.isNowThemeIsNightForQzone()) {
            str = "#0D0D0D";
        } else {
            str = "#FFFFFF";
        }
        this.f51528x6.setBackgroundColor(Color.parseColor(str));
    }

    private void Lp() {
        String string;
        this.f51451d4 = $(R.id.kt9);
        this.f51479r4 = (TextView) $(R.id.kqr);
        AsyncImageView asyncImageView = (AsyncImageView) $(R.id.kt_);
        this.f51474p4 = asyncImageView;
        asyncImageView.setOnClickListener(new x());
        this.J4 = (TextView) $(R.id.ktn);
        this.K4 = (Button) $(R.id.ktm);
        this.J4 = (TextView) $(R.id.ktn);
        this.K4 = (Button) $(R.id.ktm);
        long longValue = Long.valueOf(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT, String.valueOf(1048576000L))).longValue();
        this.M4 = longValue;
        String format = String.format(getResources().getString(R.string.glt), Integer.valueOf((int) ((longValue / 1024) / 1024)));
        if (bp()) {
            string = getResources().getString(R.string.gls);
            this.K4.setEnabled(true);
        } else {
            string = getResources().getString(R.string.glr);
            this.K4.setEnabled(true);
        }
        this.J4.setText(format);
        this.K4.setText(string);
        this.K4.getPaint().setFakeBoldText(true);
        this.K4.setOnClickListener(new y());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.PhotoActivity
    public void Fk(Intent intent) {
        HashMap hashMap;
        if (intent != null && this.R4 != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PeakConstants.QZONE_ALBUM_ML_EXPOSED_MEDIA_LST);
            if (serializableExtra != null) {
                try {
                    this.R4.addAll((List) serializableExtra);
                } catch (ClassCastException unused) {
                    QZLog.e("QZonePublishMoodNewStyleActivity", 4, "ClassCastException caused by objFromAlbumExpose to exposedMediaLst");
                }
            } else {
                QZLog.d("QZonePublishMoodNewStyleActivity", 4, "exposedMediaLst is null");
            }
        }
        if (this.W2 == -1) {
            this.W2 = System.currentTimeMillis();
        }
        this.J1.y();
        super.Fk(intent);
        rq();
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

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public String Sm() {
        return getString(R.string.f173026gk2);
    }

    protected void initData(Intent intent) {
        ExtendEditText extendEditText;
        if (intent == null) {
            return;
        }
        this.T4 = intent.hasExtra("PasterConstants.intent_params_refer");
        this.f51499z5 = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.GUIDE_REFER_FLAG);
        if (!TextUtils.isEmpty(intent.getStringExtra("mood_web_pic_url"))) {
            kq(intent);
        }
        this.S4 = new ShuoshuoContent();
        com.qzone.publish.ui.state.a aVar = this.Y2;
        if (aVar != null) {
            aVar.i(intent);
        }
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_operate_mood_hint");
        if (TextUtils.isEmpty(charSequenceExtra)) {
            super.Gk();
        } else {
            ExtendEditText extendEditText2 = this.f45104j0;
            if (extendEditText2 != null) {
                extendEditText2.setHint(charSequenceExtra);
            }
        }
        String stringExtra = intent.getStringExtra("key_default_mood_text");
        if (!TextUtils.isEmpty(stringExtra) && (extendEditText = this.f45104j0) != null) {
            extendEditText.setText(stringExtra);
        }
        ExtendEditText extendEditText3 = this.f45104j0;
        if (extendEditText3 != null && TextUtils.isEmpty(extendEditText3.getText())) {
            Jm(getIntent());
        }
        if (intent.getIntExtra(PeakConstants.VIDEO_TYPE, -1) == 1) {
            dq();
        }
        com.qzone.publish.ui.state.a aVar2 = this.Y2;
        if (aVar2 != null) {
            this.Z2 = aVar2.h();
            this.Y2.b();
        }
        if (this.F1) {
            setTitle(R.string.vtb);
        }
        a8.b.O().P(getHandler());
        com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
        lVar.c0(true ^ lVar.N(this.Q1));
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object obj;
        Object obj2;
        if (event == null) {
            return;
        }
        super.onEventUIThread(event);
        if ("WriteOperation".equals(event.source.getName())) {
            if (event.what != 62) {
                return;
            }
            Vo();
            vq();
            return;
        }
        if ("FontQbossGifShow".equals(event.source.getName())) {
            if (event.what == 2 && (obj2 = event.params) != null) {
                this.U5 = (QbossAdvDesc) obj2;
                RedDotImageView redDotImageView = this.f45113m0;
                if (redDotImageView == null || redDotImageView.getVisibility() != 0) {
                    return;
                }
                Gq(this.U5);
                return;
            }
            return;
        }
        if ("NewCardSkinFollowFeeds".equals(event.source.getName()) && event.what == 2 && (obj = event.params) != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                this.O5 = (FeedSkinData) objArr[1];
            }
        }
    }

    public void qq(Map<String, String> map) {
        if (map == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        if (oj() != null) {
            Iterator<String> it = oj().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.M6.containsKey(next)) {
                    Pair<String, String> pair = this.M6.get(next);
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
        if (length <= 1) {
            return;
        }
        sb5.delete(length - 1, length);
        sb6.delete(length2 - 1, length2);
        map.put("peitu_entrance", sb5.toString());
        map.put("peitu_source", sb6.toString());
        if (QZLog.isColorLevel()) {
            QZLog.d("QZonePublishMoodNewStyleActivity", 2, "peitu_entrance:", sb5.toString(), ",peitu_source:", sb6.toString());
        }
    }

    public void wq(final ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity.49
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

    private void Cq(com.qzone.publish.ui.model.c cVar) {
        HashMap<String, PicInfo> hashMap = this.A0;
        if (hashMap != null && hashMap.size() > 0) {
            if (this.f51486u2 == null) {
                this.f51486u2 = new HashMap<>();
            }
            this.f51486u2.putAll(this.A0);
        }
        wq(this.I4);
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        int i3 = 0;
        for (int i16 = 0; i16 < this.U.size(); i16++) {
            String str = this.U.get(i16);
            LocalMediaInfo Qq = Qq(this.Z.get(str));
            if (Qq == null) {
                Qq = this.W.get(str);
            }
            if (Qq != null) {
                arrayList.add(Qq);
                if (Qq.isRecord) {
                    i3++;
                    if (this.I4 == null) {
                        ShuoshuoVideoInfo y16 = ag.y(getActivity(), Qq._id, Qq.path, Qq.fileSize, Qq.mVideoType, null, Qq.thumbHeight, Qq.thumbWidth, Qq.mStartTime, Qq.mDuration, Qq.mTotalDuration, Qq.needProcess, Qq.bundle);
                        this.I4 = y16;
                        if (y16 != null) {
                            y16.mIsUploadOrigin = Pp();
                            this.I4.fakeVid = Qq.fakeVid;
                        }
                    }
                    zm.e.f452772a.c(Qq, false);
                } else if (QAlbumUtil.getMediaType(Qq) != 0 && QAlbumUtil.getMediaType(Qq) == 1) {
                    i3++;
                    Qq.needProcess = !Pp();
                    zm.e.f452772a.c(Qq, false);
                    if (Qq.isMakeVideo) {
                        Qq.needProcess = false;
                        Qq.mIsUploadOrigin = true;
                    }
                    if (this.I4 == null) {
                        FragmentActivity activity = getActivity();
                        long j3 = Qq._id;
                        String str2 = Qq.path;
                        long j16 = Qq.fileSize;
                        String str3 = Qq.thumbnailPath;
                        int i17 = Qq.thumbHeight;
                        int i18 = Qq.thumbWidth;
                        long j17 = Qq.mDuration;
                        this.I4 = ag.y(activity, j3, str2, j16, 1, str3, i17, i18, 0L, j17, j17, false, null);
                    }
                }
            } else {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.path = this.U.get(i16);
                arrayList.add(localMediaInfo);
            }
        }
        boolean z17 = i3 >= 1;
        HashMap hashMap2 = new HashMap();
        HashMap<String, MarkUinInfoBeforeUpload> hashMap3 = this.U1;
        if (hashMap3 != null) {
            for (String str4 : hashMap3.keySet()) {
                MarkUinInfoBeforeUpload markUinInfoBeforeUpload = this.U1.get(str4);
                if (markUinInfoBeforeUpload != null) {
                    hashMap2.put(str4, markUinInfoBeforeUpload.toByteArray());
                }
            }
        }
        ConcurrentHashMap<String, float[]> concurrentHashMap = this.f45140x1;
        HashMap hashMap4 = (concurrentHashMap == null || concurrentHashMap.isEmpty()) ? null : new HashMap();
        cVar.f51947i = this.f51486u2;
        cVar.f51940e = arrayList;
        cVar.G = hashMap4;
        cVar.B = this.f45132t1;
        cVar.a(this.U1);
        if (this.f51460g3 > 0) {
            zq(2);
            if (z17) {
                zq(3);
            }
        }
        pc.b bVar = (pc.b) getViewModel(pc.b.class);
        FragmentActivity activity2 = getActivity();
        if (com.qzone.publish.ui.model.b.f51931e && z17) {
            z16 = true;
        }
        bVar.Q1(activity2, cVar, z16);
    }

    private void Jp(Intent intent) {
        if (intent != null) {
            com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
            String o16 = lVar.o(this.Q1, intent);
            if (!TextUtils.isEmpty(o16) && o16.equals(QZoneHelper.Constants.INTENT_ACTION_PUBLISH_QR_CODE)) {
                this.Y2 = com.qzone.publish.ui.state.a.e(1, this);
                ImageLoader.getInstance().clear(lVar.l(this.Q1, intent));
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

    private LocalMediaInfo Qq(ShuoshuoVideoInfo shuoshuoVideoInfo) {
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
        localMediaInfo.mIsUploadOrigin = Pp();
        return localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CharSequence aq(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        while (i3 < i16) {
            if (charSequence != null && charSequence.length() > i3 && charSequence.charAt(i3) == '\n') {
                return "";
            }
            i3++;
        }
        return null;
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected boolean Bi(LocalMediaInfo localMediaInfo, Intent intent) {
        if (intent == null || !com.qzone.reborn.part.publish.mood.sync.o.a2(intent)) {
            return false;
        }
        rp().sa(localMediaInfo, intent);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        RDMEtraMsgCollector.getInstance().addNoramlClickAction(this.simpleClassname, view);
        if (view == this.f51488v2) {
            LpReportInfo_pf00064.allReport(586, 45, 2);
            Dk();
        } else if (view == this.D4) {
            jq();
        } else if (view == this.f51495y2) {
            yp();
        } else if (view == this.f45122p0) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("extra_from_select_photo_for_dongganyingji", true);
            com.qzone.common.business.service.b.f().q(getActivity(), null, null, 30, true, 6, false, false, null, "", bundle, QZoneMediaBusiness.QZONE_VIDEO_ALBUM);
            ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 9, "0", true, new String[0]);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.common.activities.base.PhotoActivity, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        boolean z16 = intent != null && intent.getBooleanExtra("extra_select_net_pic_from_gif_list", false);
        this.f51497y5 = z16;
        if (z16) {
            kq(intent);
            return;
        }
        if (intent != null && intent.getBooleanExtra("extra_from_select_photo_for_dongganyingji", false)) {
            ArrayList<String> q16 = com.qzone.reborn.util.l.f59550a.q(this.Q1, intent);
            if (q16 != null && !q16.isEmpty()) {
                ClickReport.c(TroopInfo.PAY_PRIVILEGE_ALL, 9, "3", true, new String[0]);
                com.qzone.album.base.Service.e.e().v(q16);
                yo.d.d(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DYNAMIC_ALBUM_URL, QzoneConfig.DEFAULT_DYNAMIC_ALBUM_URL), getActivity(), null);
            }
        } else {
            super.onNewIntent(intent);
            uq();
        }
        Km();
        Ti(intent);
    }

    private void vp(QZoneTask qZoneTask) {
        JceStruct jceStruct;
        Map<Integer, ArrayList<tAdvDesc>> map;
        ArrayList<tAdvDesc> arrayList;
        if (qZoneTask == null) {
            return;
        }
        if (qZoneTask.getResult(201).getReturnCode() != 0) {
            QZLog.e("QZonePublishMoodNewStyleActivity", "get qboss video vip tips info failed,code = " + qZoneTask.mResultCode);
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
            if (Rp(tadvdesc.res_data, eVar)) {
                QZLog.i("QZonePublishMoodNewStyleActivity", 1, "get qboss video tips info succ." + this.L4);
                Oq();
                return;
            }
            QZLog.w("QZonePublishMoodNewStyleActivity", "get qboss video tips info fail.");
        }
    }

    @Override // com.qzone.common.activities.base.PhotoActivity
    protected void Ej() {
        LpReportInfo_pf00064.allReport(586, 35, 2);
    }

    private static boolean Rp(String str, com.qzone.publish.ui.model.e eVar) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void gp() {
    }

    private void yp() {
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Dn() {
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void En(long j3) {
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    public void Pm() {
    }

    public void rq() {
    }

    @Override // com.qzone.publish.ui.controller.a
    public void showActionSheet() {
    }

    @Override // com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity
    protected void sn() {
    }

    @Override // com.qzone.publish.ui.controller.a
    public void gotoSelectPicture(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
    }
}
