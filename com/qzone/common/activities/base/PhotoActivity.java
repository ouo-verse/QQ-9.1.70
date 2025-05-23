package com.qzone.common.activities.base;

import FileUpload.MarkUinInPhoto;
import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import PROTO_EXT_TO_UGCSVR.Font;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.album.data.model.GifInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneSuperFontPanel;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.common.tool.PhotoFilterTool;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.service.PersonalFontService;
import com.qzone.publish.ui.activity.QZonePublishMoodActivity;
import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.publish.ui.publishmodule.LBSModule;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.P2VUtil;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import com.qzone.widget.AsyncMarkGifImageView;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.ExtendGridView;
import com.qzone.widget.ExtendScrollView;
import com.qzone.widget.MoodPicLabel;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.qzone.widget.RapidCommentEmoView;
import com.qzone.widget.RedDotImageView;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.util.ImageQualityPreference;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.font.IFontManager;
import com.tencent.widget.ActionSheet;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZonePublishConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.util.RecentPhotoManger;
import cooperation.qzone.util.XMPCoreUtil;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes39.dex */
public abstract class PhotoActivity extends BaseFragment implements IObserver.main, QZoneWriteOperationService.n {

    /* renamed from: q2, reason: collision with root package name */
    public static final HashMap<String, LocalMediaInfo> f45074q2 = new HashMap<>();

    /* renamed from: r2, reason: collision with root package name */
    public static final ArrayList<String> f45075r2 = new ArrayList<>();

    /* renamed from: s2, reason: collision with root package name */
    static int f45076s2 = 0;
    protected HashMap<String, PicInfo> A0;
    protected View B0;
    protected boolean B1;
    public com.qzone.common.activities.titlebuilder.a C;
    public com.qzone.album.ui.widget.g C0;
    protected boolean C1;
    protected boolean D1;
    protected com.qzone.common.business.service.b E;
    protected volatile boolean E1;
    protected com.qzone.common.business.service.e F;
    public boolean F1;
    private HashMap<String, String> G1;
    private View H1;
    protected com.qzone.publish.ui.publishmodule.c I1;
    protected com.qzone.publish.ui.publishmodule.d J1;
    protected int K1;
    public LbsDataV2.PoiInfo L0;
    public QZoneMediaBusiness L1;
    public ExtendScrollView M;
    public LbsDataV2.PoiInfo M0;
    protected boolean M1;
    public ViewGroup N;
    public gm.c N1;
    LinearLayout O0;
    public hm.b O1;
    public DynamicGridView P;
    public com.qzone.reborn.part.publish.mood.sync.o P1;
    public AsyncMarkGifImageView Q;
    public MoodPicLabel Q0;
    protected QZonePublishMoodInitBean Q1;
    public TextView R;
    public FrameLayout R0;
    private Dialog R1;
    public TextView S;
    public int S0;
    public int S1;
    public e9.a T;
    public LocalImageShootInfo T0;
    boolean T1;
    public ArrayList<LocalImageShootInfo> U0;
    public HashMap<String, MarkUinInfoBeforeUpload> U1;
    public HashMap<String, Boolean> V1;
    protected int W0;
    public HashMap<String, Boolean> W1;
    public HashMap<String, ArrayList<FaceData>> X1;
    private boolean Y1;
    private String Z1;

    /* renamed from: a2, reason: collision with root package name */
    public boolean f45079a2;

    /* renamed from: b1, reason: collision with root package name */
    private int f45081b1;

    /* renamed from: b2, reason: collision with root package name */
    private final xk.d f45082b2;

    /* renamed from: c0, reason: collision with root package name */
    private String f45083c0;

    /* renamed from: c2, reason: collision with root package name */
    private final Runnable f45085c2;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f45086d0;

    /* renamed from: d2, reason: collision with root package name */
    protected EditVideoTimeOutRunnable f45088d2;

    /* renamed from: e0, reason: collision with root package name */
    protected ActionSheet f45089e0;

    /* renamed from: e2, reason: collision with root package name */
    private int f45091e2;

    /* renamed from: f0, reason: collision with root package name */
    protected View f45092f0;

    /* renamed from: f2, reason: collision with root package name */
    private int f45094f2;

    /* renamed from: g0, reason: collision with root package name */
    protected RapidCommentEmoView f45095g0;

    /* renamed from: g1, reason: collision with root package name */
    public String f45096g1;

    /* renamed from: g2, reason: collision with root package name */
    private int f45097g2;

    /* renamed from: h0, reason: collision with root package name */
    public QZoneFontTabView f45098h0;

    /* renamed from: h1, reason: collision with root package name */
    protected long f45099h1;

    /* renamed from: h2, reason: collision with root package name */
    private String f45100h2;

    /* renamed from: i0, reason: collision with root package name */
    protected InputMethodManager f45101i0;

    /* renamed from: i2, reason: collision with root package name */
    public int f45103i2;

    /* renamed from: j0, reason: collision with root package name */
    public ExtendEditText f45104j0;

    /* renamed from: j2, reason: collision with root package name */
    EmoticonCallback f45106j2;

    /* renamed from: k2, reason: collision with root package name */
    private final Runnable f45109k2;

    /* renamed from: l0, reason: collision with root package name */
    protected ImageView f45110l0;

    /* renamed from: l1, reason: collision with root package name */
    public int f45111l1;

    /* renamed from: l2, reason: collision with root package name */
    protected ExtendScrollView.a f45112l2;

    /* renamed from: m0, reason: collision with root package name */
    protected RedDotImageView f45113m0;

    /* renamed from: m2, reason: collision with root package name */
    private EncodeResultRunnable f45115m2;

    /* renamed from: n0, reason: collision with root package name */
    protected RedDotImageView f45116n0;

    /* renamed from: n2, reason: collision with root package name */
    public boolean f45118n2;

    /* renamed from: o0, reason: collision with root package name */
    protected View f45119o0;

    /* renamed from: o2, reason: collision with root package name */
    protected volatile boolean f45121o2;

    /* renamed from: p0, reason: collision with root package name */
    protected View f45122p0;

    /* renamed from: p1, reason: collision with root package name */
    private QQCustomDialog f45123p1;

    /* renamed from: p2, reason: collision with root package name */
    private QQPermission f45124p2;

    /* renamed from: q0, reason: collision with root package name */
    public View f45125q0;

    /* renamed from: s0, reason: collision with root package name */
    public String f45129s0;

    /* renamed from: y0, reason: collision with root package name */
    public List<Friend> f45141y0;
    protected String D = "";
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    protected boolean J = false;
    protected boolean K = false;
    protected boolean L = false;
    public final DynamicArrayList<String> U = new DynamicArrayList<>();
    public final ArrayList<String> V = new ArrayList<>();
    public final HashMap<String, LocalMediaInfo> W = new HashMap<>();
    public final HashMap<String, ShuoshuoVideoInfo> X = new HashMap<>();
    public final HashMap<String, GpsInfo4LocalImage> Y = new HashMap<>();
    public final HashMap<String, ShuoshuoVideoInfo> Z = new HashMap<>();

    /* renamed from: a0, reason: collision with root package name */
    protected final HashMap<String, String> f45077a0 = new HashMap<>();

    /* renamed from: b0, reason: collision with root package name */
    public final HashMap<String, Integer> f45080b0 = new HashMap<>();

    /* renamed from: k0, reason: collision with root package name */
    protected boolean f45107k0 = false;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f45127r0 = false;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f45131t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    protected boolean f45133u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f45135v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    protected boolean f45137w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f45139x0 = true;

    /* renamed from: z0, reason: collision with root package name */
    public ArrayList<NetImageInfo> f45143z0 = new ArrayList<>();
    public int D0 = 0;
    public int E0 = 0;
    public int F0 = 0;
    public boolean G0 = true;
    public boolean H0 = false;
    public boolean I0 = false;
    public boolean J0 = false;
    public int K0 = 0;
    protected int N0 = 0;
    public boolean P0 = false;
    public boolean V0 = false;
    public boolean X0 = true;
    public boolean Y0 = false;
    protected String Z0 = "";

    /* renamed from: a1, reason: collision with root package name */
    public boolean f45078a1 = true;

    /* renamed from: c1, reason: collision with root package name */
    public boolean f45084c1 = false;

    /* renamed from: d1, reason: collision with root package name */
    protected boolean f45087d1 = false;

    /* renamed from: e1, reason: collision with root package name */
    public boolean f45090e1 = false;

    /* renamed from: f1, reason: collision with root package name */
    protected boolean f45093f1 = false;

    /* renamed from: i1, reason: collision with root package name */
    public int f45102i1 = 1;

    /* renamed from: j1, reason: collision with root package name */
    protected boolean f45105j1 = false;

    /* renamed from: k1, reason: collision with root package name */
    public int f45108k1 = 0;

    /* renamed from: m1, reason: collision with root package name */
    public boolean f45114m1 = false;

    /* renamed from: n1, reason: collision with root package name */
    public String f45117n1 = "";

    /* renamed from: o1, reason: collision with root package name */
    public boolean f45120o1 = false;

    /* renamed from: q1, reason: collision with root package name */
    private boolean f45126q1 = true;

    /* renamed from: r1, reason: collision with root package name */
    protected int f45128r1 = -1;

    /* renamed from: s1, reason: collision with root package name */
    protected String f45130s1 = "";

    /* renamed from: t1, reason: collision with root package name */
    protected ArrayList<GifInfo> f45132t1 = new ArrayList<>();

    /* renamed from: u1, reason: collision with root package name */
    protected boolean f45134u1 = false;

    /* renamed from: v1, reason: collision with root package name */
    protected int f45136v1 = 0;

    /* renamed from: w1, reason: collision with root package name */
    protected int f45138w1 = -1;

    /* renamed from: x1, reason: collision with root package name */
    public ConcurrentHashMap<String, float[]> f45140x1 = new ConcurrentHashMap<>();

    /* renamed from: y1, reason: collision with root package name */
    public ConcurrentHashMap<String, int[]> f45142y1 = new ConcurrentHashMap<>();

    /* renamed from: z1, reason: collision with root package name */
    protected boolean f45144z1 = true;
    public String A1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_NEED_GETPICMARKER, "1");

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes39.dex */
    public class EditVideoTimeOutRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public String f45185d;

        protected EditVideoTimeOutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoActivity.this.Hj();
        }
    }

    /* loaded from: classes39.dex */
    public class EncodeResultRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f45186d;

        /* renamed from: e, reason: collision with root package name */
        String f45187e;

        /* renamed from: f, reason: collision with root package name */
        boolean f45188f;

        public EncodeResultRunnable(String str, String str2, boolean z16) {
            this.f45186d = str;
            this.f45187e = str2;
            this.f45188f = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            int indexOf;
            Bundle bundle;
            ShuoshuoVideoInfo shuoshuoVideoInfo = PhotoActivity.this.Z.get(this.f45186d);
            if (shuoshuoVideoInfo != null && (indexOf = PhotoActivity.this.U.indexOf(this.f45186d)) >= 0) {
                if (this.f45188f) {
                    String str = this.f45187e;
                    shuoshuoVideoInfo.mVideoPath = str;
                    shuoshuoVideoInfo.mVideoType = 1;
                    PhotoActivity.this.f45077a0.put(this.f45186d, str);
                    PhotoActivity.this.U.set(indexOf, this.f45187e);
                    PhotoActivity photoActivity = PhotoActivity.this;
                    photoActivity.X.remove(photoActivity.f45083c0);
                    PhotoActivity.this.Z.remove(this.f45186d);
                    PhotoActivity.this.Z.put(this.f45187e, shuoshuoVideoInfo);
                    shuoshuoVideoInfo.mNeedProcess = false;
                    e9.a aVar = PhotoActivity.this.T;
                    if (aVar != null) {
                        aVar.b0(indexOf);
                        PhotoActivity photoActivity2 = PhotoActivity.this;
                        photoActivity2.T.B0(photoActivity2.Z);
                        PhotoActivity.this.T.notifyDataSetChanged();
                    }
                    PhotoActivity.this.pi(shuoshuoVideoInfo, 2);
                    try {
                        File file = new File(this.f45186d);
                        if (file.exists() && file.isDirectory()) {
                            FileUtils.deleteDirectory(this.f45186d);
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastComposeFail", "\u5408\u6210\u5931\u8d25"), 3);
                    PhotoActivity.this.pi(shuoshuoVideoInfo, 3);
                    PhotoActivity.this.T.b0(indexOf);
                }
                PhotoActivity.this.f45086d0 = false;
                Iterator<String> it = PhotoActivity.this.U.iterator();
                while (it.hasNext()) {
                    ShuoshuoVideoInfo shuoshuoVideoInfo2 = PhotoActivity.this.Z.get(it.next());
                    if (shuoshuoVideoInfo2 != null && (bundle = shuoshuoVideoInfo2.mExtras) != null && bundle.getInt("video_state", 0) == 1) {
                        QZoneWriteOperationService.v0().n0(shuoshuoVideoInfo2);
                        PhotoActivity.this.f45086d0 = true;
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return PhotoActivity.this.Xk(view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PhotoActivity photoActivity = PhotoActivity.this;
            if (!photoActivity.f45135v0) {
                photoActivity.f45113m0.setContentDescription(com.qzone.util.l.a(R.string.p3w));
                PhotoActivity.this.pm();
            } else {
                photoActivity.f45113m0.setContentDescription(com.qzone.util.l.a(R.string.p3t));
                PhotoActivity.this.showKeyboard();
                PhotoActivity.this.bk();
            }
            EventCollector.getInstance().onViewClicked(view);
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
            PhotoActivity photoActivity = PhotoActivity.this;
            if (!photoActivity.f45131t0) {
                photoActivity.nm();
            } else {
                photoActivity.showKeyboard();
                PhotoActivity.this.ak();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements QZoneFontPanel.e {
        e() {
        }

        @Override // com.qzone.common.activities.base.QZoneFontPanel.e
        public void a(PersonalFontData.FontInfo fontInfo) {
            QZoneSuperFontPanel qZoneSuperFontPanel;
            int i3;
            QZoneFontTabView qZoneFontTabView = PhotoActivity.this.f45098h0;
            if (qZoneFontTabView != null && (qZoneSuperFontPanel = qZoneFontTabView.f45369m) != null && fontInfo != null && ((i3 = fontInfo.fontFormatType) == 3 || i3 == 4)) {
                qZoneSuperFontPanel.l0();
                ((IFontManager) QRoute.api(IFontManager.class)).setDefaultSuperFont(LoginData.getInstance().getUin(), null);
            }
            PhotoActivity.this.showKeyboard();
            PhotoActivity.this.bk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements QZoneSuperFontPanel.c {
        f() {
        }

        @Override // com.qzone.common.activities.base.QZoneSuperFontPanel.c
        public void a(int i3) {
            PhotoActivity.this.showKeyboard();
            PhotoActivity.this.bk();
        }

        @Override // com.qzone.common.activities.base.QZoneSuperFontPanel.c
        public void onClick(int i3) {
            QZoneFontPanel qZoneFontPanel;
            PersonalFontData.FontInfo R;
            int i16;
            PhotoActivity photoActivity = PhotoActivity.this;
            if (photoActivity.f45104j0 == null) {
                return;
            }
            QZoneFontTabView qZoneFontTabView = photoActivity.f45098h0;
            if (qZoneFontTabView != null && (qZoneFontPanel = qZoneFontTabView.f45368i) != null && (R = qZoneFontPanel.R()) != null && ((i16 = R.fontFormatType) == 3 || i16 == 4)) {
                PhotoActivity.this.f45098h0.f45368i.y0();
            }
            if (PhotoActivity.this.f45104j0.getText() == null || PhotoActivity.this.f45104j0.getText().length() <= 0) {
                PhotoActivity.this.showKeyboard();
                PhotoActivity.this.bk();
            }
        }
    }

    /* loaded from: classes39.dex */
    class g implements EmoticonCallback {
        g() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            ExtendEditText extendEditText = PhotoActivity.this.f45104j0;
            if (extendEditText == null || extendEditText.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = PhotoActivity.this.f45104j0.getText();
                int selectionStart = PhotoActivity.this.f45104j0.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(PhotoActivity.this.f45104j0.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = PhotoActivity.this.f45104j0.getSelectionStart();
                int selectionEnd = PhotoActivity.this.f45104j0.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                if (emoticonInfo.type == 1) {
                    PhotoActivity.this.f45104j0.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                } else {
                    PhotoActivity.this.f45104j0.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getEmojiString(((SystemEmoticonInfo) emoticonInfo).code));
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f45196d;

        h(RelativeLayout relativeLayout) {
            this.f45196d = relativeLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PhotoActivity.this.mi();
            int height = this.f45196d.getHeight();
            if (PhotoActivity.this.f45081b1 - height <= 150) {
                if (height - PhotoActivity.this.f45081b1 > 150) {
                    PhotoActivity photoActivity = PhotoActivity.this;
                    if (!photoActivity.f45131t0 && !photoActivity.f45135v0) {
                        photoActivity.f45125q0.setVisibility(4);
                        PhotoActivity.this.ik();
                    }
                }
            } else {
                PhotoActivity.this.f45125q0.requestLayout();
                PhotoActivity photoActivity2 = PhotoActivity.this;
                photoActivity2.f45125q0.setVisibility(photoActivity2.uk() ? 0 : 4);
                PhotoActivity.this.jk();
                PhotoActivity.this.Ci();
            }
            PhotoActivity.this.f45081b1 = height;
        }
    }

    /* loaded from: classes39.dex */
    class i implements ExtendScrollView.a {

        /* renamed from: a, reason: collision with root package name */
        private long f45198a = 0;

        i() {
        }

        @Override // com.qzone.widget.ExtendScrollView.a
        public boolean onDown(MotionEvent motionEvent) {
            if (PhotoActivity.this.Bk(motionEvent)) {
                PhotoActivity.this.gk(motionEvent);
                this.f45198a = 0L;
                PhotoActivity.this.f45078a1 = false;
                return false;
            }
            if (PhotoActivity.this.Fi(motionEvent)) {
                return true;
            }
            if (!PhotoActivity.this.dk(true) && !PhotoActivity.this.ak() && !PhotoActivity.this.bk() && !PhotoActivity.this.gk(motionEvent)) {
                this.f45198a = 0L;
                return false;
            }
            this.f45198a = motionEvent.getDownTime();
            return true;
        }

        @Override // com.qzone.widget.ExtendScrollView.a
        public boolean onTouch(MotionEvent motionEvent) {
            return this.f45198a == motionEvent.getDownTime();
        }
    }

    /* loaded from: classes39.dex */
    class l implements View.OnTouchListener {
        l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            Intent intent = PhotoActivity.this.getIntent();
            int intExtra = intent != null ? intent.getIntExtra("key_photo_oprate_type", 1) : 1;
            PhotoActivity photoActivity = PhotoActivity.this;
            photoActivity.Wk(photoActivity.P, 0, photoActivity.oj(), intExtra, true);
            PhotoActivity.this.Ej();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class m implements ActionSheet.OnDismissListener {
        m() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            PhotoActivity.this.Cl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class n implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f45206d;

        n(ActionSheet actionSheet) {
            this.f45206d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[Actvity] ");
            sb5.append(PhotoActivity.this.simpleClassname);
            if (view != null) {
                sb5.append("  click view  id:");
                sb5.append(Integer.toHexString(view.getId()));
            }
            sb5.append("which:");
            sb5.append(i3);
            RDMEtraMsgCollector.getInstance().addUserAction(sb5.toString());
            if (i3 == 0) {
                PhotoActivity.this.Ml(0);
            } else if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && PhotoActivity.this.qm()) {
                        PhotoActivity.this.Bm();
                    }
                } else if (PhotoActivity.this.qm()) {
                    PhotoActivity.this.Ol();
                } else {
                    PhotoActivity.this.Bm();
                }
            } else if (!PhotoActivity.this.qm()) {
                PhotoActivity.this.Ol();
            } else {
                PhotoActivity.this.Dl();
                PhotoActivity.this.Dk();
            }
            this.f45206d.superDismiss();
        }
    }

    public PhotoActivity() {
        this.B1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_IN_ACTIONSHEET, 1) == 1;
        this.C1 = P2VUtil.d().g();
        this.D1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_SHOW_MAKEVIDEO_IN_TOOLBAR, 1) == 1;
        this.E1 = true;
        this.L1 = QZoneMediaBusiness.QZONE_SHUOSHUO_UPLOAD_PIC;
        this.S1 = 0;
        this.T1 = false;
        this.U1 = new HashMap<>();
        this.V1 = new HashMap<>();
        this.W1 = new HashMap<>();
        this.X1 = new HashMap<>();
        this.Y1 = false;
        this.f45082b2 = new xk.d(new o());
        this.f45085c2 = new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (!FaceScanDownloadManager.i()) {
                    if (PhotoActivity.this.getActivity() == null) {
                        QZLog.e(BaseFragment.TAG, "mCheckFaceRunnable PhotoActivity.this.getActivity() == null");
                        return;
                    }
                    q4.a.l().m(PhotoActivity.this.getActivity());
                    QZLog.d("[PhotoAlbum]FaceFuntion", 1, "isFaceResourceReady false");
                    if (!NetworkState.isWifiConn()) {
                        QZLog.d("[PhotoAlbum]FaceFuntion", 1, "not ready to download face so");
                        return;
                    } else {
                        q4.a.l().q();
                        return;
                    }
                }
                if (PhotoActivity.this.oj() != null && PhotoActivity.this.oj().size() != 0) {
                    PhotoActivity.this.oj().get(0);
                } else {
                    QZLog.w(BaseFragment.TAG, "mCheckFaceRunnable PhotoActivity: no photo were selected...");
                }
            }
        };
        this.f45088d2 = new EditVideoTimeOutRunnable();
        this.f45091e2 = 0;
        this.f45094f2 = -1;
        this.f45097g2 = -1;
        this.f45100h2 = "";
        this.f45103i2 = 0;
        this.f45106j2 = new g();
        this.f45109k2 = new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.25
            @Override // java.lang.Runnable
            public void run() {
                QZoneSuperFontPanel qZoneSuperFontPanel;
                QZoneFontPanel qZoneFontPanel;
                PhotoActivity photoActivity = PhotoActivity.this;
                QZoneFontTabView qZoneFontTabView = photoActivity.f45098h0;
                if (qZoneFontTabView != null && (qZoneFontPanel = qZoneFontTabView.f45368i) != null && photoActivity.f45113m0 != null) {
                    long O = qZoneFontPanel.O();
                    if (PhotoActivity.this.yk() && LocalMultiProcConfig.getLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, -1L) < O) {
                        PhotoActivity.this.f45113m0.h(true);
                    }
                    if (!PersonalFontService.K().M()) {
                        PhotoActivity.this.f45098h0.f45368i.d0(false);
                    }
                }
                QZoneFontTabView qZoneFontTabView2 = PhotoActivity.this.f45098h0;
                if (qZoneFontTabView2 == null || (qZoneSuperFontPanel = qZoneFontTabView2.f45369m) == null) {
                    return;
                }
                qZoneSuperFontPanel.U(false);
            }
        };
        this.f45112l2 = new i();
        this.f45118n2 = false;
        this.f45121o2 = false;
        this.E = com.qzone.common.business.service.b.f();
        this.F = com.qzone.common.business.service.e.D();
        ci();
        this.f45141y0 = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        getHandler().postDelayed(this.f45109k2, 200L);
    }

    private void Dj(String str, long j3, long j16, int i3, int i16) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) EditLocalVideoActivity.class);
        intent.putExtra("short_video_refer", getClass().getName());
        intent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        intent.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        intent.putExtra(PeakConstants.DIRECT_BACK_TO_QZONE, true);
        intent.putExtra("qzone_plugin_activity_name", getRealActivity().getClass().getName());
        intent.putExtra(PeakConstants.EDIT_LOCAL_VIDEO_ENTRY, 1);
        intent.putExtra("file_send_path", str);
        intent.putExtra(PeakConstants.VIDEO_SIZE, j3);
        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, j16);
        intent.putExtra(ShortVideoConstants.FILE_WIDTH, i3);
        intent.putExtra(ShortVideoConstants.FILE_HEIGHT, i16);
        startActivity(intent);
    }

    private void Fj() {
        if (this.W0 != oj().size()) {
            ((LBSModule) hj(LBSModule.class)).J();
        }
    }

    @Deprecated
    private boolean Hk(ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, String str) {
        return ((URLUtil.isNetworkUrl(str) && !hashMap.containsKey(str)) || arrayList.contains(str) || this.f45077a0.containsValue(str)) ? false : true;
    }

    private void Hl() {
        Activity outActivity = getOutActivity();
        if (outActivity == null) {
            return;
        }
        if (this.f45124p2 == null) {
            this.f45124p2 = QQPermissionFactory.getQQPermission(outActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA));
        }
        QQPermission qQPermission = this.f45124p2;
        if (qQPermission == null) {
            return;
        }
        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new QQPermission.BasePermissionsListener() { // from class: com.qzone.common.activities.base.PhotoActivity.31
            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.31.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PhotoActivity photoActivity = PhotoActivity.this;
                        photoActivity.J = true;
                        photoActivity.D = photoActivity.Ii();
                    }
                });
            }
        });
    }

    private boolean Ik(ArrayList<String> arrayList, String str) {
        if (getShowType() == 1) {
            return true;
        }
        if (URLUtil.isNetworkUrl(str) || arrayList.contains(str)) {
            return false;
        }
        String fj5 = fj(str);
        if (tk(str) || TextUtils.equals(fj5, AECameraConstants.MEDIA_FROM_EDIT) || TextUtils.equals(fj5, "MEDIA_FROM_CAMERA")) {
            return false;
        }
        LocalMediaInfo localMediaInfo = this.W.get(str);
        if (localMediaInfo == null) {
            return true;
        }
        return TextUtils.isEmpty(localMediaInfo.missionID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        this.f45100h2 = "";
        this.f45094f2 = -1;
        this.f45097g2 = -1;
    }

    private void Ji() {
        Bundle bundle = new Bundle();
        bundle.putLong(AECameraConstants.EXTRA_ACTIVITY_START_TIME, System.currentTimeMillis());
        bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
        bundle.putInt("edit_video_type", 10001);
        bundle.putInt("entrance_type", 122);
        bundle.putInt(PeakConstants.BUSI_TYPE, 3);
        bundle.putInt(IJumpUtil.EDIT_VIDEO_WAY, 12);
        bundle.putInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, 1);
        bundle.putInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, 5);
        bundle.putBoolean(PeakConstants.EXTRA_DIRECTLY_BACK, false);
        bundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        bundle.putBoolean(PeakConstants.DIRECT_BACK_TO_QZONE, true);
        bundle.putInt(PeakConstants.KEY_ENTRY_SOURCE, 5);
        bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, false);
        bundle.putBoolean("enable_local_button", false);
        bundle.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, true);
        QZoneHelper.forwardToQzoneVideoCaptureNew(getActivity(), bundle, 10001);
    }

    private void Ki(int i3) {
        Bundle bundle = new Bundle();
        bundle.putLong(AECameraConstants.EXTRA_ACTIVITY_START_TIME, System.currentTimeMillis());
        bundle.putBoolean(PeakConstants.ARG_ALBUM, false);
        bundle.putInt("edit_video_type", 10001);
        bundle.putInt("entrance_type", 122);
        bundle.putInt(PeakConstants.BUSI_TYPE, 3);
        bundle.putInt(IJumpUtil.EDIT_VIDEO_WAY, 12);
        bundle.putInt(AECameraConstants.KEY_CAMERA_PHOTO_EDIT_TYPE, 1);
        bundle.putInt(AECameraConstants.KEY_CAMERA_VIDEO_EDIT_TYPE, 5);
        bundle.putBoolean(PeakConstants.EXTRA_DIRECTLY_BACK, false);
        bundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        bundle.putBoolean(PeakConstants.DIRECT_BACK_TO_QZONE, true);
        bundle.putInt(PeakConstants.KEY_ENTRY_SOURCE, i3);
        bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, false);
        bundle.putBoolean("enable_local_button", false);
        bundle.putBoolean(AEEditorConstants.GO_PUBLISH_ACTIVITY, true);
        bundle.putBoolean(ShortVideoConstants.ENABLE_EDIT_VIDEO, true);
        bundle.putInt(PeakConstants.QZONE_PHOTO_EDIT_SOURCE_TYPE, 9);
        bundle.putStringArrayList("PhotoConst.SELECTED_PATHS", oj());
        bundle.putBoolean(AECameraConstants.KEY_ENABLE_PRIV_LIST, false);
        bundle.putBoolean(AECameraConstants.KEY_ENABLE_INPUT_TEXT, false);
        QZoneHelper.forwardToQzoneVideoCaptureNew(getActivity(), bundle, 10001);
    }

    private void Mj(Intent intent, ArrayList<String> arrayList, boolean z16) {
        int intExtra = intent.getIntExtra("onClickPhotoPlus", -1);
        this.f45128r1 = intExtra;
        if (intExtra != -1 && intExtra < this.U.size()) {
            String str = this.U.get(this.f45128r1);
            vl(str);
            ArrayList arrayList2 = (ArrayList) oj().clone();
            if (arrayList.size() == 1) {
                oj().clear();
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    if (i3 == this.f45128r1) {
                        fi(arrayList.get(0));
                        fi((String) arrayList2.get(i3));
                    } else {
                        fi((String) arrayList2.get(i3));
                    }
                }
                if (arrayList2.size() == this.f45128r1) {
                    fi(arrayList.get(0));
                }
                if (!z16) {
                    HashMap<String, Boolean> hashMap = this.V1;
                    if (hashMap != null && hashMap.containsKey(str)) {
                        this.V1.put(arrayList.get(0), this.V1.get(str));
                        this.V1.remove(str);
                    }
                    HashMap<String, MarkUinInfoBeforeUpload> hashMap2 = this.U1;
                    if (hashMap2 != null && hashMap2.containsKey(str)) {
                        this.U1.put(arrayList.get(0), this.U1.get(str));
                        this.U1.remove(str);
                    }
                    HashMap<String, ArrayList<FaceData>> hashMap3 = this.X1;
                    if (hashMap3 != null && hashMap3.containsKey(str)) {
                        this.X1.put(arrayList.get(0), this.X1.get(str));
                        this.X1.remove(str);
                    }
                    HashMap<String, Boolean> hashMap4 = this.W1;
                    if (hashMap4 != null && hashMap4.containsKey(str)) {
                        this.W1.put(arrayList.get(0), this.W1.get(str));
                        this.W1.remove(str);
                    }
                }
            }
        }
        this.T1 = false;
    }

    private void Nj(ArrayList<String> arrayList) {
        if (arrayList.size() > 0) {
            fi(arrayList.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Oi(CharSequence charSequence, int i3) {
        return aj.e(charSequence, i3, this.f45103i2, this.f45141y0, this.f45094f2, this.f45097g2, this.f45100h2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ol() {
        if (f45076s2 > 0) {
            Pl();
            Rl("1");
            Fl();
            ClickReport.c(com.tencent.luggage.wxa.nf.i.CTRL_INDEX, 51, "1", true, new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pj(final boolean z16, final String str) {
        runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (!z16) {
                    PhotoActivity.this.dismissWaitingDialog();
                    ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGifComposeFail", "GIF\u5408\u6210\u5931\u8d25,\u8bf7\u9009\u62e9\u5c3a\u5bf8\u6bd4\u4f8b\u7c7b\u4f3c\u7684\u56fe\u7247"), 4);
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                    PhotoActivity.this.fi(str);
                    PhotoActivity.this.hi(str);
                }
                PhotoActivity.this.dismissWaitingDialog();
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGifComposeSuccess", "GIF\u5408\u6210\u6210\u529f,\u73b0\u5728\u8fdb\u5165\u9884\u89c8"), 5);
                PhotoActivity photoActivity = PhotoActivity.this;
                photoActivity.Wk(photoActivity.P, photoActivity.oj().size() - 1, PhotoActivity.this.oj(), 1, false);
            }
        });
    }

    private void Qi() {
        HashMap<String, MarkUinInfoBeforeUpload> hashMap = this.U1;
        if (hashMap == null) {
            this.U1 = new HashMap<>();
        } else {
            hashMap.values().removeAll(Collections.singleton(null));
        }
        HashMap<String, ArrayList<FaceData>> hashMap2 = this.X1;
        if (hashMap2 == null) {
            this.X1 = new HashMap<>();
        } else {
            hashMap2.values().removeAll(Collections.singleton(null));
        }
        HashMap<String, Boolean> hashMap3 = this.V1;
        if (hashMap3 == null) {
            this.V1 = new HashMap<>();
        } else {
            hashMap3.values().removeAll(Collections.singleton(null));
        }
        HashMap<String, Boolean> hashMap4 = this.W1;
        if (hashMap4 == null) {
            this.W1 = new HashMap<>();
        } else {
            hashMap4.values().removeAll(Collections.singleton(null));
        }
    }

    private void Qj(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                fi(next);
                hi(next);
            }
        }
    }

    private void Qk(int i3, int i16, Intent intent) {
        String str;
        HashMap<String, String> hashMap;
        Qi();
        this.T.n0(null);
        if (intent != null && (hashMap = (HashMap) intent.getExtras().getSerializable("beautifyImageMap")) != null) {
            this.G1 = hashMap;
            Dm();
        }
        if (i16 == 1 && intent != null) {
            int intExtra = intent.getIntExtra(PeakConstants.SELECT_INDEX, -1);
            if (intExtra != -1) {
                Vk(intExtra);
                return;
            }
            return;
        }
        if (i16 == 3) {
            Kl();
            return;
        }
        Fj();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            ArrayList arrayList = (ArrayList) extras.getSerializable("picturelist");
            this.f45144z1 = extras.getBoolean(PictureConst.KEY_NEED_OPEN_FACE);
            this.U1.clear();
            if (arrayList != null) {
                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                    ArrayList<MarkUinInPhoto> arrayList2 = new ArrayList<>();
                    if (((PhotoInfo) arrayList.get(i17)).mFaceList != null) {
                        for (int i18 = 0; i18 < ((PhotoInfo) arrayList.get(i17)).mFaceList.size(); i18++) {
                            FaceData faceData = ((PhotoInfo) arrayList.get(i17)).mFaceList.get(i18);
                            if (faceData.targetuin != 0) {
                                MarkUinInPhoto markUinInPhoto = new MarkUinInPhoto();
                                markUinInPhoto.f24905x = faceData.f390865x;
                                markUinInPhoto.f24906y = faceData.f390866y;
                                markUinInPhoto.f24904w = faceData.f390864w;
                                markUinInPhoto.f24903h = faceData.f390863h;
                                if (TextUtils.isEmpty(faceData.targetGroupid)) {
                                    str = faceData.groupid;
                                } else {
                                    str = faceData.targetGroupid;
                                }
                                markUinInPhoto.groupid = str;
                                markUinInPhoto.is_recommend = faceData.isRecommend;
                                markUinInPhoto.target_uin = faceData.targetuin;
                                QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[upload] marks.x:", Long.valueOf(markUinInPhoto.f24905x), " marks.y:", Long.valueOf(markUinInPhoto.f24906y), " marks.w:", Long.valueOf(markUinInPhoto.f24904w), " marks.h:", Long.valueOf(markUinInPhoto.f24903h), " marks.groupid:", markUinInPhoto.groupid, " marks.target_uin:", Long.valueOf(markUinInPhoto.target_uin));
                                arrayList2.add(markUinInPhoto);
                            }
                        }
                    }
                    MarkUinInfoBeforeUpload markUinInfoBeforeUpload = new MarkUinInfoBeforeUpload();
                    markUinInfoBeforeUpload.marks = arrayList2;
                    String str2 = (String) cj(oj(), i17);
                    if (TextUtils.isEmpty(str2)) {
                        QZLog.e(BaseFragment.TAG, 1, "[onActivityResultForPreview] image url key is empty, flow end...");
                        return;
                    }
                    PhotoInfo photoInfo = (PhotoInfo) cj(arrayList, i17);
                    if (photoInfo == null) {
                        QZLog.e(BaseFragment.TAG, 1, "[onActivityResultForPreview] photo info should not be null, error: ", new Exception());
                        return;
                    }
                    this.U1.put(str2, markUinInfoBeforeUpload);
                    this.V1.put(str2, Boolean.valueOf(photoInfo.hasCheckFace));
                    this.X1.put(str2, photoInfo.mFaceList);
                    this.W1.put(str2, Boolean.valueOf(photoInfo.needShowFaceIcon));
                }
            }
        }
    }

    private void Rj(Intent intent) {
        final String stringExtra = intent.getStringExtra("file_send_path");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        ti();
        final long longExtra = intent.getLongExtra("start_time", 0L);
        final long longExtra2 = intent.getLongExtra(ShortVideoConstants.FILE_SEND_DURATION, 0L);
        final long longExtra3 = intent.getLongExtra("end_time", 0L);
        if (longExtra3 == 0) {
            longExtra3 = longExtra + longExtra2;
        }
        final boolean booleanExtra = intent.getBooleanExtra(PeakConstants.VIDEO_NEED_PROCESS, false);
        final String stringExtra2 = intent.getStringExtra(PeakConstants.VIDEO_THUMBNAIL_PATH);
        int intExtra = intent.getIntExtra(PeakConstants.VIDEO_TYPE, 1);
        if (this.X.containsKey(stringExtra)) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.X.get(stringExtra);
            shuoshuoVideoInfo.mStartTime = longExtra;
            shuoshuoVideoInfo.mEndTime = longExtra3;
            shuoshuoVideoInfo.mDuration = longExtra2;
            shuoshuoVideoInfo.mNeedProcess = booleanExtra;
            shuoshuoVideoInfo.mCoverUrl = stringExtra2;
            shuoshuoVideoInfo.mVideoType = intExtra;
            e9.a aVar = this.T;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LocalMediaInfo localMediaInfo = PhotoActivity.this.W.get(stringExtra);
                if (localMediaInfo != null) {
                    String str = localMediaInfo.path;
                    long j3 = localMediaInfo.fileSize;
                    String str2 = stringExtra2;
                    int i3 = localMediaInfo.thumbHeight;
                    int i16 = localMediaInfo.thumbWidth;
                    long j16 = longExtra;
                    ShuoshuoVideoInfo q16 = com.qzone.util.ag.q(str, j3, 1, str2, i3, i16, j16, longExtra3 - j16, localMediaInfo.mDuration, booleanExtra, null);
                    if (q16 != null) {
                        q16.mEndTime = longExtra3;
                        q16.mDuration = longExtra2;
                        PhotoActivity.this.X.put(stringExtra, q16);
                        PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e9.a aVar2 = PhotoActivity.this.T;
                                if (aVar2 != null) {
                                    aVar2.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    private void Rk(int i3, int i16, Intent intent) {
        int intExtra = intent.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_QUALITY", this.D0);
        int intExtra2 = intent.getIntExtra("com.qzone.publish.ui.activity.QZoneUploadQualityActivity_UPLOAD_VIDEO_QUALITY", this.E0);
        if (intExtra != this.D0) {
            this.D0 = intExtra;
            u5.b.L0("photo", intExtra, LoginData.getInstance().getUin());
        }
        if (intExtra2 != this.E0) {
            this.E0 = intExtra2;
            u5.b.L0("video", intExtra2, LoginData.getInstance().getUin());
        }
    }

    private void Sk(int i3, int i16, Intent intent) {
        this.E.z(getActivity());
        if (TextUtils.isEmpty(this.D) && u5.b.B("PIC_TMP_PATH")) {
            this.D = u5.b.h0("PIC_TMP_PATH", "");
        }
        u5.b.z0("PIC_TMP_PATH");
        String str = this.D;
        if (str != null) {
            if (!str.equals("")) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        List<ImageInfo> b16 = com.qzone.util.image.e.b(PhotoActivity.this.getActivity().getApplicationContext());
                        if (b16 != null) {
                            Iterator<ImageInfo> it = b16.iterator();
                            while (it.hasNext()) {
                                PhotoActivity.this.hi(it.next().mPath);
                            }
                        }
                    }
                });
                hi(this.D);
            }
            fi(this.D);
            this.T.notifyDataSetChanged();
            al();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Vj(Intent intent) {
        String stringExtra = intent.getStringExtra(PeakConstants.ORIGN_PATH);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(PeakConstants.ORIGN_LIST_PATH);
        String stringExtra2 = intent.getStringExtra(PeakConstants.DOODLE_BITMAP_PATH);
        String stringExtra3 = intent.getStringExtra(PeakConstants.COMBINE_IMAGE_PATH);
        int intExtra = intent.getIntExtra(PeakConstants.GIF_DELAY_TIME, -1);
        boolean z16 = false;
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.USE_ORIGN, false);
        GifInfo gifInfo = new GifInfo(stringExtra, stringArrayListExtra, stringExtra2, stringExtra3, intExtra, booleanExtra);
        int indexOf = this.U.indexOf(stringExtra3);
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, "useOrign:" + booleanExtra + " index:" + indexOf + " gifInfo.mSavePath:" + gifInfo.mSavePath);
        }
        if (booleanExtra) {
            File file = new File(gifInfo.mSavePath);
            if (file.exists()) {
                if (!gifInfo.mOrignPath.equals(gifInfo.mCombineImagePath)) {
                    new File(gifInfo.mCombineImagePath).delete();
                }
                vl(gifInfo.mCombineImagePath);
                ei(indexOf, gifInfo.mSavePath);
                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                if (z16) {
                    return;
                }
                this.f45132t1.clear();
                this.f45132t1.add(gifInfo);
                e9.a aVar = this.T;
                if (aVar != null) {
                    aVar.H0(indexOf);
                } else {
                    this.f45134u1 = true;
                }
                String str = gifInfo.mSavePath;
                if (QZLog.isColorLevel()) {
                    String str2 = BaseFragment.TAG;
                    QZLog.d(str2, 2, "gifOrignPath:" + stringExtra + " doodleBitmapPath:" + stringExtra2 + " combinePath:" + stringExtra3 + " delay:" + intExtra);
                    if (stringArrayListExtra != null) {
                        QZLog.d(str2, 2, "picsOrignPath size: " + stringArrayListExtra.size());
                        Iterator<String> it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            QZLog.d(BaseFragment.TAG, 2, "path: " + next);
                        }
                    }
                }
                if (gifInfo.isBaseGif) {
                    xi(gifInfo, str);
                    return;
                } else {
                    yi(stringArrayListExtra, gifInfo, str);
                    return;
                }
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<LocalMediaInfo> Xi(Intent intent) {
        try {
            return (ArrayList) intent.getSerializableExtra(QQWinkConstants.EXTRA_EXPORT_LOCAL_MEDIA_INFO_LIST);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(LocalMediaInfo localMediaInfo, int i3) {
        QZLog.d(BaseFragment.TAG, 1, "addSelectMediaInfo localMediaInfo is " + localMediaInfo);
        if (localMediaInfo == null) {
            return;
        }
        if (i3 != -1 && this.U.size() >= i3) {
            this.U.add(i3, localMediaInfo.path);
        } else {
            this.U.add(localMediaInfo.path);
        }
        ki(localMediaInfo);
    }

    private void di(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        String shortVideoPath = ShortVideoUtils.getShortVideoPath(file);
        String shortVideoPath2 = ShortVideoUtils.getShortVideoPath(file, "qz_origin_");
        if (!TextUtils.isEmpty(shortVideoPath)) {
            hi(shortVideoPath);
        }
        if (TextUtils.isEmpty(shortVideoPath2)) {
            return;
        }
        hi(shortVideoPath2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWaitingDialog() {
        try {
            Dialog dialog = this.R1;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.R1.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private String fj(String str) {
        LocalMediaInfo localMediaInfo;
        HashMap<String, Serializable> hashMap;
        if (!this.W.isEmpty() && (localMediaInfo = this.W.get(str)) != null && (hashMap = localMediaInfo.extData) != null) {
            Serializable serializable = hashMap.get(AECameraConstants.MEDIA_FROM);
            if (serializable instanceof String) {
                return (String) serializable;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST, str);
        RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST, str);
        RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_BANNER_RECENT_PHOTO_BLACKLIST, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(boolean z16) {
        if (this.f45078a1 && !z16) {
            this.f45125q0.setVisibility(4);
            getPartManager().broadcastMessage("hide_bottom_lab_bar", null);
        } else {
            this.f45125q0.setVisibility(0);
        }
    }

    private boolean lk() {
        int j3;
        if (this instanceof QZonePublishMoodActivity) {
            j3 = com.tencent.mobileqq.utils.e.l();
        } else {
            j3 = com.tencent.mobileqq.utils.e.j();
        }
        if (Cj() >= j3) {
            if (QZLog.isColorLevel()) {
                QZLog.d(BaseFragment.TAG, 2, "isNewUploadLoaded false :     " + jj() + "  " + Cj() + "  " + j3);
            }
            return false;
        }
        if (QZonePublishConfig.isUseQCirclePublish()) {
            boolean isCameraResReady = ((IAEEditorManagerForQzone) QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady();
            QZLog.d(BaseFragment.TAG, 1, "IAECameraLauncher ready :" + isCameraResReady);
            return isCameraResReady;
        }
        QZoneVideoCommonUtils.VideoSupport recordSupport = QZoneVideoCommonUtils.getRecordSupport();
        if (PhotoFilterTool.e() && recordSupport.isAvailable()) {
            return true;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, "isQQFilterSoDownloaded false");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        com.qzone.publish.ui.publishmodule.d dVar = this.J1;
        if (dVar != null) {
            dVar.t();
        }
    }

    private int mj() {
        Iterator<String> it = this.U.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (this.Z.containsKey(it.next())) {
                i3++;
            }
        }
        return i3;
    }

    private boolean mk(String str) {
        LocalMediaInfo localMediaInfo;
        if (this.W.isEmpty() || (localMediaInfo = this.W.get(str)) == null) {
            return false;
        }
        return !TextUtils.isEmpty(localMediaInfo.missionID);
    }

    private void parseIntent() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        this.Q1 = (QZonePublishMoodInitBean) intent.getParcelableExtra("qzone_route_bean");
        String str = BaseFragment.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init bean is null : ");
        sb5.append(this.Q1 == null);
        QLog.i(str, 1, sb5.toString());
        com.qzone.reborn.util.l.f59550a.a(this.Q1, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl() {
        Dm();
        qi();
        ui();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qm() {
        return this.E1 && this.B1 && !this.f45090e1 && this.C1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sk(String str, boolean z16) {
        return aj.j(str, z16, this.f45141y0, this.f45094f2, this.f45097g2, this.f45100h2);
    }

    private boolean tk(String str) {
        LocalMediaInfo localMediaInfo;
        if (xk(str) || Ak(str)) {
            return true;
        }
        if (this.W.isEmpty() || (localMediaInfo = this.W.get(str)) == null) {
            return false;
        }
        return localMediaInfo.isVideoShareToQZone;
    }

    private int tl(LocalMediaInfo localMediaInfo) {
        LocalMediaInfo localMediaInfo2;
        ArrayList<String> oj5 = oj();
        if (oj5 == null) {
            return -1;
        }
        for (int i3 = 0; i3 < oj5.size(); i3++) {
            String str = oj5.get(i3);
            if (str != null && (localMediaInfo2 = this.W.get(str)) != null && TextUtils.equals(localMediaInfo2.missionID, localMediaInfo.missionID)) {
                oj5.remove(str);
                return i3;
            }
        }
        return -1;
    }

    private void um(String str) {
        if (this.R1 == null) {
            ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
            this.R1 = reportDialog;
            reportDialog.setContentView(R.layout.bqd);
            this.R1.findViewById(R.id.kja).setVisibility(8);
            this.R1.findViewById(R.id.cib).setVisibility(0);
        }
        ((TextView) this.R1.findViewById(R.id.dialogText)).setText(str);
        this.R1.show();
    }

    private void xi(final GifInfo gifInfo, final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                boolean b16 = com.qzone.util.image.c.b(gifInfo);
                final int indexOf = PhotoActivity.this.U.indexOf(gifInfo.mCombineImagePath);
                if (b16) {
                    PhotoActivity.this.hi(str);
                    gifInfo.mDestPath = str;
                    PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.13.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e9.a aVar = PhotoActivity.this.T;
                            if (aVar != null) {
                                aVar.b0(indexOf);
                            } else {
                                QZLog.d(BaseFragment.TAG, 2, "adapter is null");
                            }
                            File file = new File(str);
                            if (file.exists()) {
                                GifInfo gifInfo2 = gifInfo;
                                if (!gifInfo2.mOrignPath.equals(gifInfo2.mCombineImagePath)) {
                                    new File(gifInfo.mCombineImagePath).delete();
                                }
                                if (QZLog.isColorLevel()) {
                                    QZLog.d(BaseFragment.TAG, 2, "index:" + indexOf);
                                }
                                AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                PhotoActivity.this.vl(gifInfo.mCombineImagePath);
                                AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                                PhotoActivity.this.ei(indexOf, str);
                                PhotoActivity.this.ni();
                                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                            }
                        }
                    });
                    return;
                }
                PhotoActivity.this.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastComposeFail", "\u5408\u6210\u5931\u8d25"), 1);
                PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.13.2
                    @Override // java.lang.Runnable
                    public void run() {
                        e9.a aVar = PhotoActivity.this.T;
                        if (aVar != null) {
                            aVar.b0(indexOf);
                        }
                    }
                });
            }
        });
    }

    private void yi(final ArrayList<String> arrayList, final GifInfo gifInfo, final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.14
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList2 = arrayList;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    return;
                }
                final int indexOf = PhotoActivity.this.U.indexOf(gifInfo.mCombineImagePath);
                if (com.qzone.util.image.c.e(gifInfo)) {
                    PhotoActivity.this.hi(str);
                    gifInfo.mDestPath = str;
                    PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e9.a aVar = PhotoActivity.this.T;
                            if (aVar != null) {
                                aVar.b0(indexOf);
                            }
                            File file = new File(str);
                            if (file.exists()) {
                                GifInfo gifInfo2 = gifInfo;
                                if (!gifInfo2.mOrignPath.equals(gifInfo2.mCombineImagePath)) {
                                    new File(gifInfo.mCombineImagePath).delete();
                                }
                                if (QZLog.isColorLevel()) {
                                    QZLog.d(BaseFragment.TAG, 2, "index:" + indexOf);
                                }
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                PhotoActivity.this.vl(gifInfo.mCombineImagePath);
                                AnonymousClass14 anonymousClass142 = AnonymousClass14.this;
                                PhotoActivity.this.ei(indexOf, str);
                                PhotoActivity.this.ni();
                                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                            }
                        }
                    });
                    return;
                }
                PhotoActivity.this.toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastComposeFail", "\u5408\u6210\u5931\u8d25"), 1);
                PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.14.2
                    @Override // java.lang.Runnable
                    public void run() {
                        e9.a aVar = PhotoActivity.this.T;
                        if (aVar != null) {
                            aVar.b0(indexOf);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(ArrayList<String> arrayList, List<LocalMediaInfo> list) {
        QZLog.d(BaseFragment.TAG, 1, "addSelectMediaInfos");
        if (list == null) {
            return;
        }
        wi(arrayList);
        for (int i3 = 0; i3 < list.size(); i3++) {
            LocalMediaInfo localMediaInfo = list.get(i3);
            if (localMediaInfo != null) {
                ki(localMediaInfo);
            }
        }
    }

    protected HashMap<String, PicInfo> Ai(Intent intent, ArrayList<String> arrayList) {
        HashMap hashMap;
        if (intent.getBooleanExtra("PhotoActivity.is_image_may_too_much", false)) {
            hashMap = (HashMap) f45074q2.clone();
        } else {
            hashMap = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        }
        Al(hashMap);
        HashMap<String, PicInfo> hashMap2 = new HashMap<>();
        if (arrayList != null) {
            HashMap<String, PicInfo> hashMap3 = this.A0;
            if (hashMap3 != null && hashMap3.size() > 0) {
                hashMap2.putAll(this.A0);
            }
            if (intent.hasExtra(PeakConstants.PHOTO_INFOS)) {
                this.A0 = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_INFOS);
            }
        }
        return hashMap2;
    }

    protected int Aj() {
        return R.layout.bqa;
    }

    protected boolean Ak(String str) {
        return false;
    }

    public void Al(Map<String, LocalMediaInfo> map) {
        this.W.clear();
        if (map != null) {
            this.W.putAll(map);
        }
    }

    protected boolean Bi(LocalMediaInfo localMediaInfo, Intent intent) {
        return false;
    }

    protected abstract void Bj(Boolean bool, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Bk(MotionEvent motionEvent) {
        return aj.l(motionEvent, this.f45104j0, getTitleBarHeight(), this.mStatusBarHeight, this.f45125q0);
    }

    public void Bl(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.X.clear();
        if (hashMap != null) {
            this.X.putAll(hashMap);
        }
    }

    public int Cj() {
        Iterator<String> it = this.U.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (this.X.containsKey(next) || this.Z.containsKey(next)) {
                i3++;
            }
        }
        return i3;
    }

    protected boolean Ck(String str) {
        LocalMediaInfo localMediaInfo = this.W.get(str);
        return localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 1;
    }

    protected boolean Cm(ArrayList<String> arrayList, ConcurrentHashMap<String, String> concurrentHashMap, String str) {
        String stringExtra;
        int i3 = this.f45084c1 ? 2 : 6;
        int dj5 = dj();
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, "maxPhotoCnt=" + dj5);
        }
        Bundle bundle = new Bundle();
        if (this.f45087d1) {
            bundle.putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID);
            Intent intent = getIntent();
            if (intent != null && (stringExtra = intent.getStringExtra(QAlbumConstants.ALBUM_NAME)) != null) {
                bundle.putString(QAlbumConstants.ALBUM_NAME, stringExtra);
            }
            i3 = 5;
        }
        return bl(getActivity(), arrayList, dj5, false, i3, this.f45093f1, concurrentHashMap, bundle, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Di(String str) {
        if (!vl(str)) {
            return false;
        }
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        ViewGroup viewGroup = this.N;
        if (viewGroup == null) {
            return true;
        }
        viewGroup.invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dk() {
        if (si()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("PhotoConst.IS_SINGLE_MODE", false);
        bundle.putString(QAlbumConstants.ALBUM_NAME, QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME);
        bundle.putString(QAlbumConstants.ALBUM_ID, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
        bundle.putInt("PhotoConst.MAXUM_SELECTED_NUM", P2VGlobalConfig.MAX_P2V_RECOMMEND_INT);
        bundle.putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
        long j3 = P2VGlobalConfig.VIDEO_CAN_UPLOAD_LIMIT_MS;
        bundle.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, j3);
        bundle.putLong(PeakConstants.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION, j3);
        bundle.putLong(QAlbumConstants.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT, j3);
        bundle.putBoolean("from_qzone_slideshow", true);
        bundle.putInt("edit_video_type", 10001);
        bundle.putInt("qq_sub_business_id", 3);
        bundle.putLong("qzone_slide_enable_mask", 50043L);
        bundle.putBoolean("QZONE_SUPPORT_MIX_MOOD", com.qzone.publish.ui.model.b.f51931e);
        bundle.putString("qzone_plugin_activity_name", lc.b.b().getName());
        bundle.putLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        this.E.r(getRealActivity(), 3, bundle);
    }

    public void Dm() {
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.n0(this.G1);
            this.T.t0(this.U);
            this.T.A0(this.f45080b0);
            this.T.v0(this.W);
            this.T.C0(this.X);
            this.T.B0(this.Z);
            this.T.notifyDataSetChanged();
        }
    }

    protected void Ei(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, "delectPhotoMarkerResult path : " + str);
        }
        ConcurrentHashMap<String, float[]> concurrentHashMap = this.f45140x1;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0 && this.f45140x1.containsKey(str)) {
            this.f45140x1.remove(str);
        }
        ConcurrentHashMap<String, int[]> concurrentHashMap2 = this.f45142y1;
        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0 && this.f45142y1.containsKey(str)) {
            this.f45142y1.remove(str);
        }
        HashMap<String, MarkUinInfoBeforeUpload> hashMap = this.U1;
        if (hashMap != null && hashMap.containsKey(str)) {
            this.U1.remove(str);
        }
        HashMap<String, Boolean> hashMap2 = this.V1;
        if (hashMap2 != null && hashMap2.containsKey(str)) {
            this.V1.remove(str);
        }
        HashMap<String, ArrayList<FaceData>> hashMap3 = this.X1;
        if (hashMap3 != null && hashMap3.containsKey(str)) {
            this.X1.remove(str);
        }
        HashMap<String, Boolean> hashMap4 = this.W1;
        if (hashMap4 == null || !hashMap4.containsKey(str)) {
            return;
        }
        this.W1.remove(str);
    }

    protected boolean Fi(MotionEvent motionEvent) {
        return false;
    }

    @Deprecated
    protected void Gj(ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap) {
        Iterator it = ((ArrayList) oj().clone()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (Hk(arrayList, hashMap, str)) {
                vl(str);
            }
        }
        ArrayList arrayList2 = (ArrayList) oj().clone();
        oj().clear();
        int i3 = 0;
        int i16 = 0;
        while (i3 < arrayList2.size() && i16 < arrayList.size()) {
            if (URLUtil.isNetworkUrl((String) arrayList2.get(i3))) {
                if (getShowType() != 1) {
                    fi((String) arrayList2.get(i3));
                }
            } else if (((String) arrayList2.get(i3)).equals(arrayList.get(i16))) {
                fi(arrayList.get(i16));
                i3++;
                i16++;
            }
            i3++;
        }
        while (i3 < arrayList2.size()) {
            fi((String) arrayList2.get(i3));
            i3++;
        }
        while (i16 < arrayList.size()) {
            if (this.f45077a0.containsKey(arrayList.get(i16))) {
                fi(this.f45077a0.get(arrayList.get(i16)));
            } else {
                fi(arrayList.get(i16));
            }
            i16++;
        }
        Iterator<Map.Entry<String, ShuoshuoVideoInfo>> it5 = this.Z.entrySet().iterator();
        while (it5.hasNext()) {
            if (!oj().contains(it5.next().getKey())) {
                it5.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gk() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                l5.a k3 = com.qzone.business.plusunion.business.a.h().k();
                long currentTimeMillis = System.currentTimeMillis();
                if (!(k3 == null || k3.isCacheExpired(currentTimeMillis))) {
                    if (k3.isCurrentTimeValid(currentTimeMillis)) {
                        PhotoActivity.this.Gm(k3);
                        return;
                    }
                    return;
                }
                com.qzone.business.plusunion.business.a.h().j(PhotoActivity.this.getHandler());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gm(final l5.a aVar) {
        com.qzone.publish.ui.publishmodule.d dVar = this.J1;
        if (dVar != null) {
            dVar.G(aVar);
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                PhotoActivity photoActivity = PhotoActivity.this;
                if (photoActivity.f45104j0 == null || photoActivity.f45107k0) {
                    return;
                }
                if (photoActivity.G && !aVar.isMoodTextEmpty()) {
                    PhotoActivity.this.f45104j0.setHint(aVar.textShuoshuo);
                    return;
                }
                if (PhotoActivity.this.I && !aVar.isPhotoTextEmpty()) {
                    PhotoActivity.this.f45104j0.setHint(aVar.textPhoto);
                } else {
                    if (!PhotoActivity.this.f45084c1 || aVar.isVideoTextEmpty()) {
                        return;
                    }
                    PhotoActivity.this.f45104j0.setHint(aVar.textVideo);
                }
            }
        });
    }

    protected void Hm() {
        com.qzone.album.ui.widget.g gVar = this.C0;
        if (gVar == null || this.f45090e1) {
            return;
        }
        gVar.h(oj(), this.D0);
    }

    protected String Ii() {
        return this.E.v(getRealActivity(), new Bundle());
    }

    public boolean Jk() {
        return true;
    }

    public void Jl() {
        if (pk()) {
            if (this.f45120o1) {
                ForwardSdkBaseOption.G(getActivity(), getIntent(), true);
            } else {
                ForwardSdkBaseOption.G(getActivity(), getIntent(), false);
            }
        }
    }

    protected abstract boolean Kk();

    protected boolean Li() {
        return true;
    }

    protected abstract boolean Lk();

    public boolean Ll(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Ok();
        arrayList.addAll(this.U);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        ClickReport.e(4, getIntent().getStringExtra("refer"), 309, 4, 307);
        return Cm(arrayList, concurrentHashMap, str);
    }

    public boolean Mi() {
        ExtendEditText extendEditText;
        if ((this.f45084c1 && !oi()) || (extendEditText = this.f45104j0) == null) {
            return false;
        }
        if (!TextUtils.isEmpty(tj(extendEditText).trim())) {
            return true;
        }
        ArrayList<String> oj5 = oj();
        if (oj5 == null || oj5.isEmpty()) {
            return this.f45084c1;
        }
        return true;
    }

    protected boolean Mk() {
        return false;
    }

    public void Ml(int i3) {
        if (QZonePermission.requestStoragePermission(getActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            if (i3 == 1) {
                this.L1 = QZoneMediaBusiness.QZONE_SHUOSHUO_LONGPIC;
            } else {
                this.L1 = QZoneMediaBusiness.QZONE_SHUOSHUO_UPLOAD_PIC;
            }
            this.K = false;
            Kl();
            El();
            com.qzone.publish.ui.publishmodule.d dVar = this.J1;
            if (dVar == null) {
                return;
            }
            if (this.f45079a2) {
                this.f45079a2 = false;
                if (dVar.C()) {
                    this.T.G0(this.f45079a2);
                } else if (this.J1.B()) {
                    this.J1.H(false, this.P, this.T, null, getActivity());
                }
                ClickReport.q("586", WadlProxyConsts.OPER_TYPE_APK_SIGN, "2", true);
            }
            this.J1.F();
        }
    }

    protected abstract boolean Nk();

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ok() {
        if (this.U.size() > 0) {
            ArrayList arrayList = (ArrayList) this.U.clone();
            this.U.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null && URLUtil.isNetworkUrl(str) && !str.startsWith("http://qzs.qq.com")) {
                    HashMap<String, PicInfo> hashMap = this.A0;
                    if (hashMap != null && hashMap.size() > 0 && this.A0.containsKey(str)) {
                        this.U.add(str);
                    } else {
                        String imageFilePath = CacheManager.getImageFilePath(getActivity(), str);
                        if ((this.M1 || xk(str)) && !TextUtils.isEmpty(imageFilePath)) {
                            if (FileUtils.fileExists(imageFilePath)) {
                                this.U.add(imageFilePath);
                                Fm(str, imageFilePath);
                                if (this.V.contains(str)) {
                                    this.V.remove(str);
                                    this.V.add(imageFilePath);
                                }
                            } else {
                                com.qzone.common.activities.titlebuilder.a aVar = this.C;
                                if (aVar != null && aVar.u() != null) {
                                    this.C.u().setEnabled(false);
                                }
                            }
                        } else {
                            this.U.add(str);
                        }
                    }
                } else {
                    this.U.add(str);
                }
            }
        }
    }

    public void Ql(boolean z16) {
        this.K = z16;
    }

    public void Rl(String str) {
        this.Z1 = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sl() {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText == null) {
            return;
        }
        extendEditText.addTextChangedListener(new a());
        this.f45104j0.setOnTouchListener(new b());
    }

    protected void Tk() {
        View root = getRoot();
        if (root instanceof RelativeLayout) {
            RelativeLayout relativeLayout = (RelativeLayout) root;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            LinearLayout linearLayout = new LinearLayout(getActivity());
            this.O0 = linearLayout;
            linearLayout.setId(R.id.f69193i3);
            this.O0.setOrientation(1);
            this.f45125q0 = LayoutInflater.from(getActivity()).inflate(Aj(), (ViewGroup) null);
            if (QQTheme.isNowThemeIsNightForQzone() && this.f45125q0.findViewById(R.id.bmt) != null) {
                this.f45125q0.findViewById(R.id.bmt).setVisibility(8);
            }
            this.f45125q0.setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_white2gray_color));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            this.f45125q0.setVisibility(4);
            im(this.O0, layoutParams2);
            this.O0.addView(this.f45125q0, layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bjh, (ViewGroup) null);
            this.f45092f0 = inflate;
            this.O0.addView(inflate, layoutParams3);
            this.O0.addView(this.f45095g0, new LinearLayout.LayoutParams(-1, -2));
            this.f45095g0.setVisibility(8);
            this.f45095g0.setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_white2gray_color));
            relativeLayout.addView(this.O0, layoutParams);
            View findViewById = findViewById(R.id.f69243i8);
            if (findViewById != null) {
                ViewGroup.LayoutParams layoutParams4 = findViewById.getLayoutParams();
                if (layoutParams4 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
                    layoutParams5.addRule(2, R.id.f69193i3);
                    findViewById.setLayoutParams(layoutParams5);
                }
            }
            hm(relativeLayout);
            this.f45081b1 = relativeLayout.getHeight();
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new h(relativeLayout));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Tl() {
        RedDotImageView redDotImageView = this.f45113m0;
        if (redDotImageView == null) {
            return;
        }
        redDotImageView.setOnClickListener(new c());
    }

    public int Ui() {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText != null) {
            return com.qzone.util.am.d(tj(extendEditText)).length();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Uj(int i3) {
        if (!this.K || (i3 != 6000 && i3 != 6001 && i3 != 6003 && i3 != 23333333)) {
            return false;
        }
        if (i3 == 6001) {
            Intent intent = new Intent();
            intent.putExtra(QZoneHelper.QZoneAlbumConstants.CANCELED_FROM_CHOOSE_LOCAL_PHOTO, true);
            getActivity().setResult(0, intent);
        } else {
            getActivity().setResult(0);
        }
        finish();
        return true;
    }

    protected void Uk(int i3, Intent intent) {
        ArrayList<ResultRecord> parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
        nl(parcelableArrayListExtra);
        Xh(parcelableArrayListExtra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ul() {
        ImageView imageView = this.f45110l0;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new d());
    }

    public final String Vi() {
        return aj.f(this.f45104j0, this.f45141y0, this.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vl(QZoneFontPanel.f fVar) {
        QZoneFontPanel qZoneFontPanel;
        QZoneFontTabView qZoneFontTabView = this.f45098h0;
        if (qZoneFontTabView == null || (qZoneFontPanel = qZoneFontTabView.f45368i) == null) {
            return;
        }
        qZoneFontPanel.setReportCallback(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Wi() {
        return this.Z1;
    }

    public boolean Wj() {
        ExtendEditText extendEditText = this.f45104j0;
        if (extendEditText == null) {
            return false;
        }
        if (!TextUtils.isEmpty(tj(extendEditText).trim())) {
            return true;
        }
        if (this.f45090e1) {
            return false;
        }
        ArrayList<String> oj5 = oj();
        if (oj5 == null || oj5.isEmpty()) {
            return this.f45084c1 && !TextUtils.isEmpty(this.f45096g1);
        }
        return true;
    }

    public void Xh(ArrayList<ResultRecord> arrayList) {
        if (this.f45104j0 == null) {
            return;
        }
        if (this.f45141y0 == null) {
            this.f45141y0 = new ArrayList();
        }
        if (this.f45127r0) {
            int selectionStart = this.f45104j0.getSelectionStart();
            Editable editableText = this.f45104j0.getEditableText();
            if (editableText != null && !TextUtils.isEmpty(editableText.toString())) {
                int i3 = selectionStart - 1;
                if (editableText.toString().substring(i3, selectionStart).equals("@")) {
                    editableText.delete(i3, selectionStart);
                }
            }
            this.f45127r0 = false;
        }
        this.f45103i2 = aj.c(this.f45104j0, arrayList, this.f45141y0, this.f45103i2);
        showKeyboard();
    }

    public boolean Xj() {
        QZoneFontPanel qZoneFontPanel;
        PersonalFontData.FontInfo R;
        QZoneFontTabView qZoneFontTabView = this.f45098h0;
        return (qZoneFontTabView == null || (qZoneFontPanel = qZoneFontTabView.f45368i) == null || (R = qZoneFontPanel.R()) == null || R.f51895id <= 0 || TextUtils.isEmpty(R.fontUrl)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Xk(View view, MotionEvent motionEvent) {
        ak();
        bk();
        if (this.f45107k0 || this.f45104j0 == null) {
            return false;
        }
        this.f45107k0 = true;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Xl(int i3, String... strArr) {
        String string;
        boolean z16;
        String str;
        this.K0 = i3;
        if (i3 == 0) {
            string = getString(R.string.f173025gk1);
        } else if (i3 != 1 && i3 != 3) {
            string = getString(R.string.f173025gk1);
        } else if (strArr != null && strArr.length > 0) {
            if (!TextUtils.isEmpty(strArr[0])) {
                str = strArr[0];
            } else {
                str = "";
            }
            if (strArr.length > 1 && !TextUtils.isEmpty(strArr[1])) {
                String str2 = strArr[1];
                string = str;
                z16 = true;
                if (z16 && !this.X0) {
                    this.X0 = true;
                }
                Yl(string);
                if (this.Q0 != null && !TextUtils.isEmpty(string)) {
                    if (i3 == 0) {
                        this.Q0.setText(string);
                        this.Q0.setCheck(true);
                    } else {
                        this.Q0.setText("\u6dfb\u52a0\u5730\u70b9");
                        this.Q0.setCheck(false);
                    }
                }
                zm();
            }
            string = str;
        } else {
            string = getString(R.string.f173025gk1);
        }
        z16 = false;
        if (z16) {
            this.X0 = true;
        }
        Yl(string);
        if (this.Q0 != null) {
            if (i3 == 0) {
            }
        }
        zm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Yh() {
        this.f45104j0.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        try {
            RapidCommentEmoView rapidCommentEmoView = new RapidCommentEmoView(getActivity());
            this.f45095g0 = rapidCommentEmoView;
            rapidCommentEmoView.j(getActivity(), true, this.f45106j2, false, null, false, false, vk());
            Tk();
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Font Yi() {
        QZoneFontTabView qZoneFontTabView = this.f45098h0;
        if (qZoneFontTabView == null || qZoneFontTabView.C == null) {
            return null;
        }
        Font font = new Font();
        if (this.f45098h0.C.k()) {
            font.font_size = 1;
        }
        if (this.f45098h0.C.m()) {
            font.hideFlag = 1;
        } else {
            font.hideFlag = 0;
        }
        this.f45098h0.C.s();
        return font;
    }

    public boolean Yj() {
        QZoneSuperFontPanel qZoneSuperFontPanel;
        QZoneFontTabView qZoneFontTabView = this.f45098h0;
        if (qZoneFontTabView == null || (qZoneSuperFontPanel = qZoneFontTabView.f45369m) == null) {
            return false;
        }
        return qZoneSuperFontPanel.K();
    }

    public void Yk(int i3) {
        e9.a aVar = this.T;
        if (aVar == null || aVar.a0().size() == 0) {
            return;
        }
        ArrayList<Integer> a06 = this.T.a0();
        for (int i16 = 0; i16 < a06.size(); i16++) {
            int intValue = a06.get(i16).intValue();
            if (intValue == i3) {
                a06.set(i16, -1);
            } else if (intValue > i3) {
                a06.set(i16, Integer.valueOf(intValue - 1));
            }
        }
    }

    public void Yl(String str) {
        getPartManager().broadcastMessage("location_select", str);
    }

    public Map<String, String> Zi(Map<String, String> map) {
        QZoneFontPanel qZoneFontPanel;
        QZoneFontTabView qZoneFontTabView = this.f45098h0;
        if (qZoneFontTabView != null && (qZoneFontPanel = qZoneFontTabView.f45368i) != null) {
            PersonalFontData.FontInfo R = qZoneFontPanel.R();
            if (R != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("diy_font_id", R.f51895id + "");
                map.put("diy_font_type", R.fontFormatType + "");
                map.put("diy_font_url", R.fontUrl);
                if (!TextUtils.isEmpty(R.strBackgroundFileJson)) {
                    map.put("diy_font_bgurl", R.strBackgroundFileJson);
                } else {
                    map.put("diy_font_bgurl", "");
                }
            }
            this.f45098h0.f45368i.g0();
        }
        return map;
    }

    public void Zk(int i3, int i16) {
        int intValue;
        e9.a aVar = this.T;
        if (aVar == null || aVar.a0().size() == 0) {
            return;
        }
        ArrayList<Integer> a06 = this.T.a0();
        for (int i17 = 0; i17 < a06.size() && (intValue = a06.get(i17).intValue()) >= 0; i17++) {
            if (i3 > i16) {
                if (intValue >= i16 && intValue < i3) {
                    a06.set(i17, Integer.valueOf(intValue + 1));
                } else if (intValue == i3 && a06.contains(Integer.valueOf(i3))) {
                    a06.set(i17, Integer.valueOf(i16));
                }
            } else if (i16 > i3) {
                if (intValue <= i16 && intValue > i3) {
                    a06.set(i17, Integer.valueOf(intValue - 1));
                } else if (intValue == i3 && a06.contains(Integer.valueOf(i3))) {
                    a06.set(i17, Integer.valueOf(i16));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ai() {
        QZoneFontTabView qZoneFontTabView = new QZoneFontTabView(getActivity(), this, this.f45104j0, LoginData.getInstance().getUin());
        this.f45098h0 = qZoneFontTabView;
        qZoneFontTabView.setOrientation(1);
        this.f45098h0.setVisibility(8);
        this.f45098h0.setIsKuolie(this.F1);
        this.O0.addView(this.f45098h0, new LinearLayout.LayoutParams(-1, -2));
        RedDotImageView redDotImageView = (RedDotImageView) $(R.id.hrr);
        this.f45113m0 = redDotImageView;
        redDotImageView.setContentDescription(com.qzone.util.l.a(R.string.p3v));
        this.f45113m0.setVisibility(0);
        this.f45113m0.setOffSet(com.qzone.util.ar.e(6.0f), 0);
        this.f45116n0 = (RedDotImageView) $(R.id.hrs);
        this.f45098h0.e(Kk());
        this.f45098h0.setFontItemClickListener(new e());
        if (Nk()) {
            this.f45098h0.h();
            this.f45098h0.setSuperFontItemClickListener(new f());
        }
        if (Lk()) {
            this.f45098h0.g();
        }
    }

    public void aj() {
        if (this.C0 != null) {
            if ((this instanceof QZonePublishMoodActivity) && !this.Y1 && oj() != null && oj().size() > 0) {
                if (!Zj()) {
                    this.D0 = v5.a.a().d(ImageQualityPreference.TYPE_SHUOSHUO_ALL_PIC);
                }
                this.Y1 = true;
            }
            this.C0.h(oj(), this.D0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ak() {
        RapidCommentEmoView rapidCommentEmoView = this.f45095g0;
        boolean z16 = false;
        if (rapidCommentEmoView == null || this.f45092f0 == null || this.f45110l0 == null || !this.f45131t0) {
            return false;
        }
        this.f45131t0 = false;
        rapidCommentEmoView.setVisibility(8);
        this.f45092f0.setVisibility(8);
        if (this.f45131t0 && this.f45135v0) {
            z16 = true;
        }
        ji(z16);
        this.f45110l0.setImageResource(wj());
        return true;
    }

    public void am() {
        XMPCoreUtil.getInstance().loadXMPCoreJarModule(new AnonymousClass30());
    }

    public QZonePublishMoodInitBean bj() {
        return this.Q1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bk() {
        QZoneFontTabView qZoneFontTabView = this.f45098h0;
        boolean z16 = false;
        if (qZoneFontTabView == null || this.f45092f0 == null || this.f45113m0 == null || !this.f45135v0) {
            return false;
        }
        this.f45135v0 = false;
        qZoneFontTabView.n();
        lm();
        this.f45092f0.setVisibility(8);
        if (this.f45131t0 && this.f45135v0) {
            z16 = true;
        }
        ji(z16);
        return true;
    }

    public void bm(com.qzone.common.activities.titlebuilder.a aVar) {
        this.C = aVar;
        if (aVar != null) {
            aVar.H4(0);
        }
    }

    protected void ci() {
        EventCenter.getInstance().addUIObserver(this, "Local", 1);
        EventCenter.getInstance().addUIObserver(this, "WriteOperation", 35);
    }

    public void cm(ArrayList<NetImageInfo> arrayList) {
        this.U.clear();
        this.f45143z0.clear();
        if (arrayList != null) {
            Iterator<NetImageInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                fi(it.next().getSmallPath());
            }
            this.f45143z0.addAll(arrayList);
            return;
        }
        ui();
    }

    protected abstract int dj();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dk(boolean z16) {
        ExtendEditText extendEditText;
        InputMethodManager inputMethodManager = this.f45101i0;
        if (inputMethodManager != null && (extendEditText = this.f45104j0) != null) {
            if (!this.f45078a1 && inputMethodManager.hideSoftInputFromWindow(extendEditText.getWindowToken(), 0)) {
                if (z16) {
                    this.f45104j0.clearFocus();
                }
                this.f45078a1 = true;
                return true;
            }
            this.f45078a1 = true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dl(Bundle bundle) {
        this.Q1 = (QZonePublishMoodInitBean) bundle.getParcelable("qzone_route_bean");
        this.J = bundle.getBoolean("mIsTakingPhoto", false);
        this.K = bundle.getBoolean("mActionFromFriendFeeds", false);
        yl(bundle.getStringArrayList("mSelectedImageList"));
        this.f45128r1 = bundle.getInt("mPhotoPlusPos", -1);
        this.F0 = com.qzone.reborn.util.l.f59550a.w(this.Q1, bundle);
        this.U1 = (HashMap) bundle.getSerializable("mMarksUploadMap");
        this.X1 = (HashMap) bundle.getSerializable("mMarksFaceDataMap");
        this.V1 = (HashMap) bundle.getSerializable("mMarkHasCheckFacesMap");
        this.W1 = (HashMap) bundle.getSerializable("mMarkNeedShowFaceIconMap");
        Qi();
    }

    public void dm(ArrayList<String> arrayList) {
        if (!wk()) {
            yl(arrayList);
        } else {
            if (arrayList == null) {
                return;
            }
            Ek();
            kl(arrayList);
        }
    }

    public boolean ei(int i3, String str) {
        ArrayList<String> oj5 = oj();
        if (oj5 == null || oj5.contains(str)) {
            return false;
        }
        if (oj5.size() >= dj()) {
            toast(String.format(getString(R.string.cai), Integer.valueOf(dj())));
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            if (i3 <= oj().size() && i3 >= 0) {
                oj().add(i3, str);
            } else {
                oj().add(str);
            }
            qi();
            ui();
            return true;
        }
        return false;
    }

    protected abstract int ej();

    /* JADX INFO: Access modifiers changed from: protected */
    public void el(Bundle bundle) {
        bundle.putParcelable("qzone_route_bean", this.Q1);
        bundle.putBoolean("mIsTakingPhoto", this.J);
        bundle.putBoolean("mActionFromFriendFeeds", this.K);
        bundle.putStringArrayList("mSelectedImageList", this.U);
        bundle.putInt("mPhotoPlusPos", this.f45128r1);
        bundle.putInt(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, this.F0);
        bundle.putSerializable("mMarksUploadMap", this.U1);
        bundle.putSerializable("mMarksFaceDataMap", this.X1);
        bundle.putSerializable("mMarkHasCheckFacesMap", this.V1);
        bundle.putSerializable("mMarkNeedShowFaceIconMap", this.W1);
    }

    public void em(HashMap<String, PicInfo> hashMap) {
        this.A0 = hashMap;
    }

    public boolean fi(String str) {
        ArrayList<String> oj5 = oj();
        if (oj5 == null || oj5.contains(str)) {
            return false;
        }
        if (oj5.size() >= dj()) {
            toast(String.format(getString(R.string.cai), Integer.valueOf(dj())));
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            oj().add(str);
            qi();
            ui();
            return true;
        }
        return false;
    }

    public void fk(boolean z16) {
        if (this.f45104j0 == null) {
            return;
        }
        dk(z16);
        hk();
    }

    public void fl() {
        boolean z16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_TAKE_PHOTO_USING_QQ_CAMERA, 1) == 1;
        QZoneVideoCommonUtils.VideoSupport recordSupport = QZoneVideoCommonUtils.getRecordSupport();
        if (z16 && CacheManager.isExternalAvailable() && PhotoFilterTool.e() && recordSupport.isAvailable()) {
            Ji();
        } else {
            Hl();
        }
    }

    public void fm(View view) {
        this.H1 = view;
    }

    public abstract int getAppId();

    @Override // com.qzone.common.activities.base.BaseFragment
    public Activity getOutActivity() {
        if (getRealActivity().getParent() == null) {
            return getRealActivity();
        }
        if (getRealActivity().getParent() instanceof BasePluginActivity) {
            return getRealActivity().getParent();
        }
        return getActivity();
    }

    public Activity getRealActivity() {
        return null;
    }

    public abstract View getRoot();

    public int getShowType() {
        Integer value = this.O1.a2().getValue();
        if (value == null) {
            QZLog.e(BaseFragment.TAG, "getShowType value is null");
            return 0;
        }
        return value.intValue();
    }

    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public void gi(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.V.add(str);
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, str, " add to share image list");
        }
    }

    public int gj() {
        return qj() + lj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean gk(MotionEvent motionEvent) {
        com.qzone.publish.ui.publishmodule.d dVar = this.J1;
        if (dVar != null) {
            return dVar.x(motionEvent);
        }
        return false;
    }

    public void gl(int i3) {
        if (QZonePublishConfig.isUseQCirclePublish()) {
            Bundle bundle = new Bundle();
            bundle.putString("from", "qzoneShuoshuoCamera");
            this.E.v(getRealActivity(), bundle);
            return;
        }
        boolean z16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_TAKE_PHOTO_USING_QQ_CAMERA, 1) == 1;
        QZoneVideoCommonUtils.VideoSupport recordSupport = QZoneVideoCommonUtils.getRecordSupport();
        boolean isExternalAvailable = CacheManager.isExternalAvailable();
        QZLog.i(BaseFragment.TAG, "onTakePhoto, useQqCamera: " + z16 + ", isExternalAvailable: " + isExternalAvailable + ", isQQFilterSoDownloaded: " + PhotoFilterTool.e() + ", recordSupport: " + recordSupport);
        if (z16 && isExternalAvailable && PhotoFilterTool.e() && recordSupport.isAvailable()) {
            Ki(i3);
        } else {
            Hl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gm(boolean z16) {
        View view = this.H1;
        if (view != null) {
            view.setEnabled(z16);
        }
    }

    public <T extends com.qzone.publish.ui.publishmodule.b> T hj(Class<T> cls) {
        return (T) this.I1.a(cls);
    }

    protected void hk() {
        ak();
        bk();
        ji(this.f45131t0 && this.f45135v0);
        this.f45092f0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hl() {
        int Ui = Ui() - ej();
        if (Ui > 0) {
            ToastUtil.s(com.qzone.util.l.a(R.string.p3x) + Ui + com.qzone.util.l.a(R.string.p3u), 1);
        }
        ui();
    }

    @Override // com.qzone.common.business.service.QZoneWriteOperationService.n
    public void i3(String str, String str2, boolean z16, Intent intent) {
        if (this.f45115m2 != null) {
            getHandler().removeCallbacks(this.f45115m2);
            this.f45115m2 = null;
        }
        EncodeResultRunnable encodeResultRunnable = new EncodeResultRunnable(str, str2, z16);
        this.f45115m2 = encodeResultRunnable;
        runOnUiThread(encodeResultRunnable);
    }

    protected void ik() {
        this.I1.b();
    }

    public int jj() {
        return this.U.size() - Cj();
    }

    protected void jk() {
        this.I1.c();
        getPartManager().broadcastMessage("input_menu_open", null);
    }

    public void jl() {
        String str;
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("share_uin");
        String string2 = extras.getString("open_id");
        long j3 = extras.getLong("req_share_id");
        if (!TextUtils.isEmpty(string)) {
            if (string.equals(LoginData.getInstance().getUinString())) {
                return;
            }
            sm(getActivity());
        } else {
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            OpenID openID = QZoneShareManager.getOpenID(LoginData.getInstance().getQZoneRuntime(), String.valueOf(j3), new j(string2));
            if (openID == null || (str = openID.openID) == null || str.equals(string2)) {
                return;
            }
            sm(getActivity());
        }
    }

    public void jm(CharSequence charSequence) {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || aVar.u() == null) {
            return;
        }
        this.C.u().setText(charSequence);
    }

    protected int kj() {
        return 0;
    }

    protected void kk() {
        this.I1 = com.qzone.publish.ui.publishmodule.c.d(this);
        this.J1 = (com.qzone.publish.ui.publishmodule.d) hj(com.qzone.publish.ui.publishmodule.d.class);
    }

    public void km(String str) {
        this.f45096g1 = str;
        this.f45084c1 = !TextUtils.isEmpty(str);
    }

    public void li(LocalMediaInfo localMediaInfo) {
        if (TextUtils.isEmpty(localMediaInfo.thumbnailPath)) {
            Si(localMediaInfo.path, localMediaInfo);
            return;
        }
        ShuoshuoVideoInfo b16 = com.qzone.util.ag.b(localMediaInfo);
        if (b16 != null) {
            this.X.put(localMediaInfo.path, b16);
        }
    }

    protected void ll(int i3) {
        this.f45128r1 = i3;
        this.T1 = true;
    }

    protected void lm() {
        this.f45113m0.setImageResource(zj());
    }

    protected void ml(Intent intent) {
        intent.putExtra("onClickPhotoPlus", this.f45128r1);
    }

    public boolean mm() {
        return this.P0;
    }

    public HashMap<String, ShuoshuoVideoInfo> nj() {
        return this.Z;
    }

    public boolean nk() {
        return !TextUtils.isEmpty(this.f45117n1) && this.f45117n1.equals(QZoneShareManager.GLORY_OF_KINGS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nm() {
        if (this.f45095g0 == null || this.f45092f0 == null || this.f45110l0 == null || this.f45133u0) {
            return;
        }
        ck();
        bk();
        this.f45104j0.requestFocus();
        this.f45133u0 = true;
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.19
            @Override // java.lang.Runnable
            public void run() {
                PhotoActivity.this.f45095g0.setVisibility(0);
                PhotoActivity.this.f45095g0.l();
                if (!QQTheme.isNowThemeIsNightForQzone()) {
                    PhotoActivity.this.f45092f0.setVisibility(0);
                }
                PhotoActivity photoActivity = PhotoActivity.this;
                photoActivity.f45110l0.setImageResource(photoActivity.xj());
                PhotoActivity photoActivity2 = PhotoActivity.this;
                photoActivity2.f45131t0 = true;
                photoActivity2.f45133u0 = false;
                photoActivity2.ji(true);
                PhotoActivity.this.Gi();
            }
        }, 100L);
        if ((this instanceof QZonePublishMoodActivity) || (this instanceof QZonePublishMoodNewStyleActivity)) {
            LpReportInfo_pf00064.allReport(586, 29);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean oi() {
        return true;
    }

    public ArrayList<String> oj() {
        return this.U;
    }

    protected boolean ok() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.N1 = (gm.c) getViewModel(gm.c.class);
        this.O1 = (hm.b) getViewModel(hm.b.class);
        this.P1 = (com.qzone.reborn.part.publish.mood.sync.o) getViewModel(com.qzone.reborn.part.publish.mood.sync.o.class);
        this.N1.S1().postValue(this.U);
        this.N1.e2(this.X);
        this.N1.c2(this.Z);
        this.N1.d2(this.W);
        kk();
        this.f45101i0 = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        QZoneWriteOperationService.v0().Z1(this);
        PhotoFilterTool.d();
        Intent intent = getIntent();
        if (intent != null) {
            com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
            this.F0 = lVar.v(this.Q1, intent);
            this.f45084c1 = bundle == null && lVar.S(this.Q1, intent);
            this.f45090e1 = "\u52a8\u611f\u5f71\u96c6".equals(intent.getStringExtra("shareSource"));
            this.f45093f1 = lVar.R(this.Q1, intent);
            this.H0 = intent.getBooleanExtra("UploadPhoto.key_from_create_new_album", false);
            if (this.f45084c1) {
                Kl();
            }
            if (!lVar.P(this.Q1, intent)) {
                return;
            }
            QZLog.d(BaseFragment.TAG, 1, "onCreate loadFromAlbumList");
            Fk(getIntent());
            if (lVar.W(this.Q1, intent) && oj() != null && !oj().isEmpty()) {
                Vk(oj().size() - 1);
            }
            Ti(intent);
        }
        this.M1 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_THIRD_WEB_DOWNLOAD, 0) == 1;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        QZLog.d(BaseFragment.TAG, 1, "onActivityResult");
        super.onActivityResult(i3, i16, intent);
        this.I1.f(i3, i16, intent);
        if (i3 == 1701032054 && intent != null && intent.getBooleanExtra("isNeedCloseNotChoosegif", false)) {
            finish();
        }
        if (i3 == 608) {
            pm();
            return;
        }
        if (i3 == 6000) {
            this.J = false;
        }
        if (i3 == 6002) {
            Qk(i3, i16, intent);
            return;
        }
        if (i16 == 0) {
            this.f45127r0 = false;
            return;
        }
        if (i16 == 8215 && i3 == 6000) {
            return;
        }
        if (i3 == 607) {
            Rk(i3, i16, intent);
        } else if (i3 == 6000) {
            Sk(i3, i16, intent);
        } else if (i3 == 6003) {
            cm(ParcelableWrapper.getArrayListFromIntent(intent, QZoneContant.OUTPUT_IMAGES));
            e9.a aVar = this.T;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        } else if (i3 == 20221) {
            Uk(i16, intent);
        }
        Hm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBack() {
        this.I1.g();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.I1.j();
        if (this.f45115m2 != null) {
            getHandler().removeCallbacks(this.f45115m2);
            this.f45115m2 = null;
        }
        QZoneWriteOperationService.v0().p2(this);
        EventCenter.getInstance().removeObserver(this);
        QzoneGuideBubbleHelper.g().f();
        f45074q2.clear();
        f45075r2.clear();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        String str = BaseFragment.TAG;
        QZLog.d(str, 1, str + " onDetach");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message == null) {
            return;
        }
        this.I1.l(message);
        if (message.what == 1000094) {
            Ij(message);
        }
        xm(message);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.I1.m(intent);
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("extra_from_select_photo_for_synthesizing_gif", false);
            boolean booleanExtra2 = intent.getBooleanExtra("extra_from_download_video_so", false);
            if (booleanExtra) {
                Am(intent);
            } else if (!booleanExtra2) {
                QZLog.d(BaseFragment.TAG, 1, "onNewIntent loadFromAlbumList");
                Fk(intent);
            }
            if (intent.getBooleanExtra(PeakConstants.IS_VIDEO_SELECTED, false)) {
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "5", null);
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_PUBLISH, "2", null);
            }
        }
        if (intent != null) {
            aj();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.I1.n();
        ek();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBar();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        el(bundle);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.I1.n();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16 && this.f45126q1 && pk()) {
            jl();
            this.f45126q1 = false;
            try {
                Intent intent = new Intent();
                intent.setAction(JumpActivity.BROCAST_RECEIVER_ACTION);
                getActivity().sendBroadcast(intent);
                QZLog.i(BaseFragment.TAG, "sendBroadcast to finish the last activity.");
            } catch (Throwable th5) {
                QZLog.e(BaseFragment.TAG, "sendBroadcast to finish the last activity error", th5);
            }
        }
    }

    public HashMap<String, LocalMediaInfo> pj() {
        return this.W;
    }

    public boolean pk() {
        if (!TextUtils.isEmpty(this.f45117n1)) {
            return true;
        }
        Intent intent = getIntent();
        String stringExtra = intent == null ? null : intent.getStringExtra(QZoneShareManager.QZONE_SHARE_HULIAN_APPID);
        this.f45117n1 = stringExtra;
        return !TextUtils.isEmpty(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pm() {
        if (this.f45098h0 == null || this.f45092f0 == null || this.f45113m0 == null || this.f45137w0) {
            return;
        }
        ak();
        ck();
        this.f45104j0.requestFocus();
        this.f45137w0 = true;
        getHandler().postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.20
            @Override // java.lang.Runnable
            public void run() {
                PhotoActivity.this.f45098h0.y();
                long j3 = LocalMultiProcConfig.getLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, -1L);
                long O = PhotoActivity.this.f45098h0.f45368i.O();
                if (PhotoActivity.this.f45113m0.f() && O > j3) {
                    LocalMultiProcConfig.putLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, O);
                }
                if (!QQTheme.isNowThemeIsNightForQzone()) {
                    PhotoActivity.this.f45092f0.setVisibility(0);
                }
                PhotoActivity photoActivity = PhotoActivity.this;
                photoActivity.f45113m0.setImageResource(photoActivity.yj());
                PhotoActivity.this.f45113m0.h(false);
                PhotoActivity photoActivity2 = PhotoActivity.this;
                photoActivity2.f45135v0 = true;
                photoActivity2.f45137w0 = false;
                photoActivity2.ji(true);
                PhotoActivity.this.Hi();
            }
        }, 100L);
    }

    public void qi() {
        boolean z16 = this.U.size() < dj();
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.o0(z16, true);
        }
    }

    public boolean qk() {
        return com.qzone.reborn.util.l.f59550a.L(this.Q1, getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ql(int i3) {
        if (this.U.size() <= i3) {
            return;
        }
        for (int size = this.U.size() - 1; size >= i3; size--) {
            this.U.remove(size);
        }
    }

    public void ri(boolean z16) {
        boolean z17 = false;
        boolean z18 = this.U.size() < dj();
        e9.a aVar = this.T;
        if (aVar != null) {
            if (z18 && z16) {
                z17 = true;
            }
            aVar.o0(z17, true);
        }
    }

    public HashMap<String, PicInfo> rj() {
        return this.A0;
    }

    protected boolean rk(String str) {
        return !this.W.containsKey(str) && str.toLowerCase().endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END);
    }

    public boolean rl() {
        boolean z16 = false;
        for (int size = this.U.size() - 1; size >= 0; size--) {
            if (rk(this.U.get(size))) {
                this.U.remove(size);
                z16 = true;
            }
        }
        return z16;
    }

    protected void setStatusBar() {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.E1(R.color.skin_color_title_immersive_bar, R.drawable.qq_title_immersive_bar, false);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void setTitle(int i3) {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.setTitle(i3);
        } else {
            super.setTitle(i3);
        }
    }

    public void showKeyboard() {
        ExtendEditText extendEditText;
        InputMethodManager inputMethodManager = this.f45101i0;
        if (inputMethodManager == null || (extendEditText = this.f45104j0) == null) {
            return;
        }
        inputMethodManager.showSoftInput(extendEditText, 2);
        this.f45078a1 = false;
    }

    protected boolean si() {
        if (this.U.size() < dj()) {
            return false;
        }
        toast(String.format(getString(R.string.cai), Integer.valueOf(dj())));
        return true;
    }

    public HashMap<String, ShuoshuoVideoInfo> sj() {
        return this.X;
    }

    protected void ti() {
        if (zk()) {
            return;
        }
        this.U.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tm() {
        if (QZonePermission.requestStoragePermission(getActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            ek();
            if (!Mk()) {
                Kl();
                return;
            }
            ActionSheet actionSheet = this.f45089e0;
            if (actionSheet == null || !actionSheet.isShowing()) {
                ActionSheet create = ActionSheet.create(getActivity());
                if (this.f45079a2 && !this.F1) {
                    create.addButtonWithRightIcon(getString(R.string.gnp), R.drawable.skin_tips_dot, 1);
                } else {
                    create.addButton(R.string.gnp, 1);
                }
                if (qm()) {
                    create.addButton(getString(R.string.f173014gh2), 1);
                }
                int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHUOSHUO_SHOW_WEBPICTURE, 0);
                f45076s2 = config;
                if (config > 0) {
                    create.addButton(getString(R.string.gnu), 1);
                }
                create.addButton(!lk() ? R.string.gnq : R.string.gnr, 1);
                create.addCancelButton(R.string.cancel);
                create.setOnDismissListener(new m());
                create.setOnButtonClickListener(new n(create));
                create.show();
                this.f45089e0 = create;
            }
        }
    }

    public void ui() {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar == null || aVar.u() == null) {
            return;
        }
        this.C.u().setEnabled(Mi());
    }

    public Map<String, String> uj(Map<String, String> map) {
        QZoneSuperFontPanel qZoneSuperFontPanel;
        QZoneFontTabView qZoneFontTabView = this.f45098h0;
        return (qZoneFontTabView == null || (qZoneSuperFontPanel = qZoneFontTabView.f45369m) == null) ? map : qZoneSuperFontPanel.E(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uk() {
        return true;
    }

    public com.qzone.reborn.part.publish.mood.sync.o vj() {
        return this.P1;
    }

    protected boolean vk() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vl(String str) {
        ArrayList<String> oj5 = oj();
        if (!TextUtils.isEmpty(str) && oj5 != null && oj5.size() > 0) {
            Iterator<String> it = oj5.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.compareTo(str) == 0) {
                    oj5.remove(next);
                    QZLog.d(BaseFragment.TAG, 1, "removeSelectImage ", next);
                    HashMap<String, PicInfo> hashMap = this.A0;
                    if (hashMap != null && hashMap.size() > 0) {
                        this.A0.remove(next);
                    }
                    HashMap<String, ShuoshuoVideoInfo> hashMap2 = this.Z;
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        this.Z.remove(next);
                    }
                    qi();
                    ui();
                    return true;
                }
            }
        }
        return false;
    }

    protected void wi(ArrayList<String> arrayList) {
        ArrayList<String> oj5 = oj();
        if (oj5 != null) {
            Iterator it = ((ArrayList) oj5.clone()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (Ik(arrayList, str)) {
                    vl(str);
                }
            }
        }
        ArrayList arrayList2 = (ArrayList) this.U.clone();
        oj().clear();
        int i3 = 0;
        int i16 = 0;
        while (i3 < arrayList2.size() && i16 < arrayList.size()) {
            String str2 = (String) arrayList2.get(i3);
            String fj5 = fj(str2);
            if (URLUtil.isNetworkUrl((String) arrayList2.get(i3))) {
                if (getShowType() != 1) {
                    fi((String) arrayList2.get(i3));
                }
            } else if (mk((String) arrayList2.get(i3))) {
                fi((String) arrayList2.get(i3));
            } else if (((String) arrayList2.get(i3)).equals(arrayList.get(i16))) {
                fi(arrayList.get(i16));
                i3++;
                i16++;
            } else if (tk(str2) || TextUtils.equals(fj5, AECameraConstants.MEDIA_FROM_EDIT) || TextUtils.equals(fj5, "MEDIA_FROM_CAMERA")) {
                fi(str2);
            }
            i3++;
        }
        while (i3 < arrayList2.size()) {
            fi((String) arrayList2.get(i3));
            i3++;
        }
        while (i16 < arrayList.size()) {
            fi(arrayList.get(i16));
            i16++;
        }
        Iterator<Map.Entry<String, LocalMediaInfo>> it5 = this.W.entrySet().iterator();
        while (it5.hasNext()) {
            if (!oj().contains(it5.next().getKey())) {
                it5.remove();
            }
        }
        Iterator<Map.Entry<String, ShuoshuoVideoInfo>> it6 = this.X.entrySet().iterator();
        while (it6.hasNext()) {
            if (!oj().contains(it6.next().getKey())) {
                it6.remove();
            }
        }
    }

    protected int wj() {
        return R.drawable.qzone_skin_toolbar_btn_face_click;
    }

    protected boolean wk() {
        return false;
    }

    public boolean wl() {
        boolean z16 = false;
        for (int size = this.U.size() - 1; size >= 0; size--) {
            if (Ck(this.U.get(size))) {
                this.U.remove(size);
                z16 = true;
            }
        }
        return z16;
    }

    protected int xj() {
        return R.drawable.qzone_skin_toolbar_btn_keyboard_click;
    }

    public boolean xk(String str) {
        Iterator<String> it = this.V.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(str) && str.equals(next)) {
                if (QZLog.isColorLevel()) {
                    QZLog.d(BaseFragment.TAG, 2, str, " is share image");
                }
                return true;
            }
        }
        return false;
    }

    public void xl(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.Z.clear();
        if (hashMap != null) {
            this.Z.putAll(hashMap);
        }
    }

    protected int yj() {
        return R.drawable.qzone_skin_toolbar_btn_keyboard_click;
    }

    protected boolean yk() {
        return true;
    }

    public void yl(ArrayList<String> arrayList) {
        this.U.clear();
        if (arrayList != null) {
            this.U.addAll(arrayList);
        }
    }

    protected int zj() {
        return R.drawable.qzone_skin_toolbar_btn_font_click;
    }

    protected boolean zk() {
        return false;
    }

    /* renamed from: com.qzone.common.activities.base.PhotoActivity$30, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass30 implements XMPCoreUtil.XMPCoreJarLoadListener {
        AnonymousClass30() {
        }

        @Override // cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener
        public void loadState(boolean z16) {
            if (z16) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.30.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i3;
                        int i16;
                        int intValue;
                        Iterator it = ((ArrayList) PhotoActivity.this.oj().clone()).iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            if (!TextUtils.isEmpty(str) && !str.endsWith("http") && !str.endsWith("https")) {
                                if (PhotoActivity.this.f45080b0.get(str) == null) {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    SafeBitmapFactory.decodeFile(str, options);
                                    i3 = options.outWidth;
                                    i16 = options.outHeight;
                                } else {
                                    i3 = 0;
                                    i16 = 0;
                                }
                                Integer imagePath2Rotation = DecodeImageTask.getImagePath2Rotation(str);
                                if (imagePath2Rotation == null) {
                                    intValue = JpegExifReader.getRotationDegree(str);
                                    DecodeImageTask.putImagePath2Rotation(str, intValue);
                                } else {
                                    intValue = imagePath2Rotation.intValue();
                                }
                                PhotoActivity.this.f45080b0.put(str, Integer.valueOf((intValue != 90 || i3 >= i16) ? PhotoActivity.this.ij(i3, i16, str) : PhotoActivity.this.ij(i16, i3, str)));
                            }
                        }
                        PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.30.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                e9.a aVar = PhotoActivity.this.T;
                                if (aVar != null) {
                                    aVar.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bm() {
        this.K = false;
        gl(3);
        Gl();
    }

    public boolean Kl() {
        return Ll(null);
    }

    public boolean Nl() {
        this.f45087d1 = true;
        return Kl();
    }

    public boolean ck() {
        return dk(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ek() {
        fk(true);
    }

    public void vi() {
        this.f45121o2 = false;
        if (QZLog.isColorLevel()) {
            QZLog.d(BaseFragment.TAG, 2, "clearMarkerMap");
        }
        e9.a aVar = this.T;
        if (aVar != null) {
            aVar.I();
        }
        ConcurrentHashMap<String, int[]> concurrentHashMap = this.f45142y1;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, float[]> concurrentHashMap2 = this.f45140x1;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f45200d;

        j(String str) {
            this.f45200d = str;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            String str;
            if (i3 != 1 || !(obj instanceof OpenID) || (str = ((OpenID) obj).openID) == null || str.equals(this.f45200d)) {
                return;
            }
            PhotoActivity photoActivity = PhotoActivity.this;
            photoActivity.sm(photoActivity.getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class k implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f45202d;

        k(Activity activity) {
            this.f45202d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                return;
            }
            ForwardSdkBaseOption.G(this.f45202d, PhotoActivity.this.getIntent(), false);
            this.f45202d.setResult(0);
            this.f45202d.finish();
        }
    }

    /* loaded from: classes39.dex */
    class o implements xk.a {
        o() {
        }

        @Override // xk.a
        public void a(ArrayList<String> arrayList, List<LocalMediaInfo> list, HashMap<String, PicInfo> hashMap, Intent intent) {
            PhotoActivity photoActivity = PhotoActivity.this;
            photoActivity.A0 = hashMap;
            photoActivity.zl(arrayList, list);
            if (list != null && list.size() > 0) {
                PhotoActivity.this.Kj(list, intent);
            }
            PhotoActivity.this.pl();
        }

        @Override // xk.a
        public void b() {
            PhotoActivity.this.Uj(6001);
        }

        @Override // xk.a
        public void d(LocalMediaInfo localMediaInfo, Intent intent) {
            if (localMediaInfo == null) {
                return;
            }
            PhotoActivity.this.Zl(localMediaInfo, "MEDIA_FROM_CAMERA");
            PhotoActivity.this.bi(localMediaInfo, -1);
            PhotoActivity.this.pl();
        }

        @Override // xk.a
        public void c(LocalMediaInfo localMediaInfo, Intent intent) {
            if (localMediaInfo == null || intent == null) {
                return;
            }
            PhotoActivity.this.Zl(localMediaInfo, AECameraConstants.MEDIA_FROM_EDIT);
            if (PhotoActivity.this.Bi(localMediaInfo, intent)) {
                QZLog.d(BaseFragment.TAG, 1, "dealWithExportData by child");
                return;
            }
            if (!intent.getBooleanExtra("needRemoveAllLocalPathWhenExport", false)) {
                PhotoActivity.this.bi(localMediaInfo, PhotoActivity.this.ul(localMediaInfo, intent));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(localMediaInfo);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(localMediaInfo.path);
                ArrayList Xi = PhotoActivity.this.Xi(intent);
                if (Xi != null) {
                    Iterator it = Xi.iterator();
                    while (it.hasNext()) {
                        LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) it.next();
                        arrayList2.add(localMediaInfo2.path);
                        arrayList.add(localMediaInfo2);
                    }
                }
                PhotoActivity.this.zl(arrayList2, arrayList);
            }
            PhotoActivity.this.Jm(intent);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(localMediaInfo);
            PhotoActivity.this.Kj(arrayList3, intent);
            PhotoActivity.this.pl();
        }
    }

    private void Si(final String str, final LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.12
            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity = PhotoActivity.this.getActivity();
                LocalMediaInfo localMediaInfo2 = localMediaInfo;
                long j3 = localMediaInfo2._id;
                String str2 = localMediaInfo2.path;
                long j16 = localMediaInfo2.fileSize;
                int i3 = localMediaInfo2.thumbHeight;
                int i16 = localMediaInfo2.thumbWidth;
                long j17 = localMediaInfo2.mDuration;
                ShuoshuoVideoInfo p16 = com.qzone.util.ag.p(activity, j3, str2, j16, 1, null, i3, i16, 0L, j17, j17, false, null);
                if (p16 != null) {
                    LocalMediaInfo localMediaInfo3 = localMediaInfo;
                    p16.mEstimateSize = com.qzone.util.ag.j(localMediaInfo3.path, localMediaInfo3.mTotalDuration, localMediaInfo3.mDuration, false, true);
                    PhotoActivity.this.X.put(str, p16);
                }
            }
        });
    }

    public static String tj(EditText editText) {
        if (editText == null) {
            return "";
        }
        Editable text = editText.getText();
        if (text instanceof QQTextBuilder) {
            return ((QQTextBuilder) text).toPlainText();
        }
        return text.toString();
    }

    protected void Ij(Message message) {
        Object obj;
        l5.a aVar;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        QZoneResult qZoneResult = (QZoneResult) obj;
        if (!qZoneResult.getSucceed() || this.f45104j0 == null || (aVar = (l5.a) qZoneResult.getData()) == null || !aVar.isCurrentTimeValid(System.currentTimeMillis())) {
            return;
        }
        Gm(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jm(Intent intent) {
        ExtendEditText extendEditText;
        if (intent == null || !intent.hasExtra(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT)) {
            return;
        }
        String stringExtra = intent.getStringExtra(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT);
        if (TextUtils.isEmpty(stringExtra) || (extendEditText = this.f45104j0) == null) {
            return;
        }
        extendEditText.setText(stringExtra);
        QLog.d(BaseFragment.TAG, 1, "updateTextContent: ", stringExtra);
    }

    public Map<String, String> Ni(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(QZonePublishMoodRequest.KEY_APPID_FOR_CLIENT_FAKE_FEED, String.valueOf(4));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ti(Intent intent) {
        if (intent != null) {
            this.f45136v1 = intent.getIntExtra(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, 0);
            this.f45138w1 = intent.getIntExtra(QZoneHelper.Constants.KEY_PUBLISH_SUB_COME_FROM, -1);
        }
    }

    protected void Vk(int i3) {
        ll(i3);
        String str = this.U.get(this.f45128r1);
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.Z.get(str);
        if (shuoshuoVideoInfo != null) {
            Dj(shuoshuoVideoInfo.mVideoPath, shuoshuoVideoInfo.mSize, shuoshuoVideoInfo.mDuration, shuoshuoVideoInfo.mVideoWidth, shuoshuoVideoInfo.mVideoHeight);
            return;
        }
        LocalMediaInfo localMediaInfo = this.W.get(str);
        if ((localMediaInfo != null && localMediaInfo.mMimeType.contains("gif")) || this.U.get(this.f45128r1).contains("gif")) {
            Bundle bundle = new Bundle();
            bundle.putString(PeakConstants.GIF_PATH, this.U.get(this.f45128r1));
            bundle.putSerializable(PeakConstants.GIF_MEDIA_INFO, localMediaInfo);
            bundle.putInt(PeakConstants.GIF_PHOTOPLUS_POS, this.f45128r1);
            bundle.putString(PeakConstants.GIF_CLASS_NAME, getRealActivity().getClass().getName());
            bundle.putInt("onClickPhotoPlus", this.f45128r1);
            bundle.putBoolean("support_edit_video", true);
            QZoneVideoCommonUtils.forwardInstallAndStartUpOtherActivity(LoginData.getInstance().getUin(), getRealActivity(), QZoneVideoCommonUtils.REFER_GIF, null, bundle);
            return;
        }
        if (getIntent().getParcelableArrayListExtra(PeakConstants.GIF_PHOTO_PATHS) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(PeakConstants.GIF_PHOTO_PATHS, getIntent().getParcelableArrayListExtra(PeakConstants.GIF_PHOTO_PATHS));
            bundle2.putInt(PeakConstants.GIF_DELAY, getIntent().getIntExtra(PeakConstants.GIF_DELAY, 100));
            bundle2.putSerializable(PeakConstants.GIF_MEDIA_INFO, localMediaInfo);
            bundle2.putInt(PeakConstants.GIF_PHOTOPLUS_POS, this.f45128r1);
            bundle2.putString(PeakConstants.GIF_CLASS_NAME, getRealActivity().getClass().getName());
            bundle2.putInt("onClickPhotoPlus", this.f45128r1);
            bundle2.putBoolean("support_edit_video", true);
            QZoneVideoCommonUtils.forwardInstallAndStartUpOtherActivity(LoginData.getInstance().getUin(), getRealActivity(), QZoneVideoCommonUtils.REFER_GIF, null, bundle2);
            return;
        }
        if (localMediaInfo != null && (localMediaInfo.mMimeType.equals("video/mp4") || this.U.get(this.f45128r1).contains("mp4"))) {
            Dj(localMediaInfo.path, localMediaInfo.fileSize, localMediaInfo.mDuration, localMediaInfo.mediaWidth, localMediaInfo.mediaHeight);
            return;
        }
        Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(getRealActivity(), this.U.get(this.f45128r1), true, true, true, true, true, 3);
        ml(startEditPic);
        QzonePluginProxyActivity.setActivityNameToIntent(startEditPic, getActivity().getClass().getName());
        startEditPic.putExtra("cleartop", true);
        startEditPic.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
        startEditPic.putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        startEditPic.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        startEditPic.putExtra(PeakConstants.DIRECT_BACK_TO_QZONE, true);
        startActivity(startEditPic);
    }

    public boolean Zj() {
        for (int i3 = 0; i3 < this.U.size(); i3++) {
            LocalMediaInfo localMediaInfo = this.W.get(this.U.get(i3));
            if ((localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 1) || this.Z.containsKey(this.U.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public void ii(boolean z16) {
        int j3;
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        if (z16 || this.W.size() <= 0) {
            return;
        }
        if (this instanceof QZonePublishMoodActivity) {
            j3 = com.tencent.mobileqq.utils.e.l();
        } else {
            j3 = com.tencent.mobileqq.utils.e.j();
        }
        int i3 = 0;
        for (Map.Entry<String, LocalMediaInfo> entry : this.W.entrySet()) {
            if (entry.getKey() instanceof String) {
                String key = entry.getKey();
                LocalMediaInfo value = entry.getValue();
                if (QAlbumUtil.getMediaType(entry.getValue()) == 1) {
                    if (i3 <= j3 && !this.X.containsKey(key)) {
                        if (value != null && !value.isVideoReady) {
                            ShuoshuoVideoInfo shuoshuoVideoInfo2 = new ShuoshuoVideoInfo();
                            shuoshuoVideoInfo2.mVideoPath = value.path;
                            shuoshuoVideoInfo2.mSize = value.fileSize;
                            long j16 = value.mDuration;
                            shuoshuoVideoInfo2.mDuration = j16;
                            shuoshuoVideoInfo2.mTotalDuration = j16;
                            shuoshuoVideoInfo2.mCoverUrl = value.thumbnailPath;
                            shuoshuoVideoInfo2.mVideoWidth = value.thumbWidth;
                            shuoshuoVideoInfo2.mVideoHeight = value.thumbHeight;
                            this.X.put(key, shuoshuoVideoInfo2);
                            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).postDelayed(this.f45088d2, QzoneConfig.getInstance().getConfig("qqcircle", QzoneConfig.SECONDARY_QCIRCLE_EDIT_VIDEO_TIME_OUT, 60000));
                            this.f45088d2.f45185d = value.missionID;
                        } else {
                            Si(key, value);
                        }
                        i3++;
                    } else if (this.X.containsKey(key) && (shuoshuoVideoInfo = this.X.get(key)) != null) {
                        shuoshuoVideoInfo.mCoverUrl = value.thumbnailPath;
                    }
                }
            }
        }
    }

    public int lj() {
        LocalMediaInfo localMediaInfo;
        int i3 = 0;
        for (int i16 = 0; i16 < this.U.size(); i16++) {
            String str = this.U.get(i16);
            if (!TextUtils.isEmpty(str) && (localMediaInfo = this.W.get(str)) != null && !TextUtils.isEmpty(localMediaInfo.missionID)) {
                i3++;
            }
        }
        return i3;
    }

    public void om() {
        QzoneGuideBubbleHelper.g().n(getActivity(), this.P.getChildAt(0), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "GuideBubbleMarkFriend", "\u6807\u8bb0\u597d\u53cb"), 0, 16.0f, 5.0d, 10.0d, 3000L, -16669697, false, true, -ViewUtils.dpToPx(10.0f), null, 0, true, 1.0f, new l());
    }

    public int qj() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.U.size(); i16++) {
            if (this.U.get(i16) != null && (this.U.get(i16).startsWith("http://") || this.U.get(i16).startsWith("https://"))) {
                i3++;
            }
        }
        return i3;
    }

    private void Am(Intent intent) {
        final ArrayList<String> q16;
        if (intent == null || (q16 = com.qzone.reborn.util.l.f59550a.q(this.Q1, intent)) == null || q16.isEmpty()) {
            return;
        }
        if (q16.size() == 1) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastChooseGifToCompose", "\u8bf7\u9009\u62e9\u591a\u5f20\u7167\u7247\u6765\u5408\u6210GIF"), 4);
            return;
        }
        final boolean booleanExtra = intent.getBooleanExtra("extra_original", false);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                GifCoder gifCoder = new GifCoder();
                gifCoder.setUseOrignalBitmap(booleanExtra);
                gifCoder.setEncoderDither(true);
                String cameraPath = PhotoUtils.getCameraPath(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), "IMG", QzoneEmotionUtils.SIGN_ICON_URL_END);
                long currentTimeMillis = System.currentTimeMillis();
                boolean encodeGif = gifCoder.encodeGif(cameraPath, q16, 200);
                gifCoder.closeEncoder();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                QZLog.i(BaseFragment.TAG, "encodeGif: duration=" + currentTimeMillis2);
                PhotoActivity.this.Pj(encodeGif, cameraPath);
            }
        });
        um(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastGifComposing", "\u6b63\u5728\u5408\u6210GIF"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zl(LocalMediaInfo localMediaInfo, String str) {
        if (localMediaInfo == null) {
            return;
        }
        if (localMediaInfo.extData == null) {
            localMediaInfo.extData = new HashMap<>();
        }
        localMediaInfo.extData.put(AECameraConstants.MEDIA_FROM, str);
    }

    public static <T> T cj(List<T> list, int i3) {
        if (list == null || list.isEmpty() || i3 < 0 || i3 >= list.size()) {
            return null;
        }
        return list.get(i3);
    }

    private void ki(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return;
        }
        if (QAlbumUtil.getMediaType(localMediaInfo) == 1) {
            li(localMediaInfo);
        }
        this.W.put(localMediaInfo.path, localMediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(ShuoshuoVideoInfo shuoshuoVideoInfo, int i3) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        if (shuoshuoVideoInfo.mExtras == null) {
            shuoshuoVideoInfo.mExtras = new Bundle();
        }
        shuoshuoVideoInfo.mExtras.putInt("video_state", i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ul(LocalMediaInfo localMediaInfo, Intent intent) {
        if (intent != null && !intent.getBooleanExtra("needRemoveOriginPath", true)) {
            return -1;
        }
        int tl5 = tl(localMediaInfo);
        if (tl5 != -1) {
            return tl5;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = localMediaInfo.mOriginPath;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra("editFileOriginPath");
            if (!TextUtils.isEmpty(stringExtra)) {
                arrayList.add(stringExtra);
            }
        }
        return sl(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fk(Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.f45082b2.a(intent)) {
            QZLog.d(BaseFragment.TAG, 1, "dealWith QCircleIntent: true");
            return;
        }
        ArrayList<String> q16 = com.qzone.reborn.util.l.f59550a.q(this.Q1, intent);
        if (q16 != null) {
            QZLog.d(BaseFragment.TAG, 1, "loadFromAlbumList pic size: ", Integer.valueOf(q16.size()));
        } else {
            QZLog.d(BaseFragment.TAG, 1, "loadFromAlbumList pic is null");
        }
        HashMap<String, PicInfo> Ai = Ai(intent, q16);
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.EDIT_VIDEO_FOR_QZONE_UPLOAD_PHOTO_ACTIVITY, false);
        boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.IS_VIDEO_SELECTED, false);
        boolean booleanExtra3 = intent.getBooleanExtra(PeakConstants.IS_VIDEO_RECORDED, false);
        boolean z16 = intent.getIntExtra(PeakConstants.EDIT_LOCAL_VIDEO_ENTRY, 0) == 1;
        boolean booleanExtra4 = intent.getBooleanExtra("PasterConstants.delete_pictures", false);
        boolean booleanExtra5 = intent.getBooleanExtra("extra_from_take_photo_using_qq_camera", false);
        boolean booleanExtra6 = intent.getBooleanExtra(PeakConstants.IS_RECORD_GIF, false);
        this.T1 = intent.getBooleanExtra("isEnterPhotoPlus", this.T1);
        boolean booleanExtra7 = intent.getBooleanExtra(PeakConstants.HAS_CROP, false);
        boolean booleanExtra8 = intent.getBooleanExtra(PeakConstants.EDIT_COME_FROM_NEWFLOW, false);
        ii(booleanExtra);
        if (q16 == null && !booleanExtra2 && !booleanExtra && !booleanExtra3 && !z16) {
            if (this.f45084c1 && TextUtils.isEmpty(this.f45096g1)) {
                finish();
                return;
            } else {
                this.f45084c1 = !TextUtils.isEmpty(this.f45096g1);
                Uj(6001);
                return;
            }
        }
        if (booleanExtra2) {
            if (Tj(intent)) {
                return;
            }
        } else if (z16) {
            if (Jj(intent)) {
                return;
            }
        } else if (booleanExtra3) {
            if (Sj(intent)) {
                return;
            }
        } else if (booleanExtra) {
            Rj(intent);
        } else {
            Lj(intent, q16, Ai, booleanExtra4, booleanExtra5, booleanExtra6, booleanExtra7, booleanExtra8);
        }
        if (intent.getBooleanExtra(PeakConstants.NEED_COMBINE_GIF, false)) {
            Vj(intent);
        }
        e9.a aVar = this.T;
        if (aVar != null && !this.f45084c1) {
            QZLog.d(BaseFragment.TAG, 1, "loadFromAlbumList  notifyDataSetChanged: ", String.valueOf(aVar.getCount()), String.valueOf(oj() != null ? oj().size() : 0));
            this.T.notifyDataSetChanged();
            com.qzone.publish.ui.publishmodule.d dVar = this.J1;
            if (dVar != null) {
                dVar.H(false, this.P, this.T, null, getActivity());
            }
        }
        if (this.H0 && this.G0) {
            this.G0 = false;
            zi();
        }
    }

    public void il(ArrayList<ResultRecord> arrayList) {
        int i3;
        if (arrayList == null) {
            return;
        }
        if (this.f45141y0 == null) {
            this.f45141y0 = new ArrayList();
        }
        if (arrayList.size() <= 0) {
            return;
        }
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            Friend friend = new Friend();
            if (!TextUtils.isEmpty(next.name)) {
                friend.mName = next.name;
            } else {
                friend.mName = next.uin;
            }
            try {
                long longValue = Long.valueOf(next.uin).longValue();
                String str = "@" + friend.mName;
                if (this.f45103i2 < str.length()) {
                    i3 = str.length();
                } else {
                    i3 = this.f45103i2;
                }
                this.f45103i2 = i3;
                friend.mUin = longValue;
                this.f45141y0.add(friend);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object[] objArr;
        if (event == null) {
            return;
        }
        this.I1.k(event);
        if ("Local".equals(event.source.getName())) {
            if (event.what != 1 || (objArr = (Object[]) event.params) == null || objArr.length <= 0) {
                return;
            }
            String str = (String) objArr[0];
            Di(str);
            Ei(str);
            return;
        }
        if ("WriteOperation".equals(event.source.getName())) {
            Object[] objArr2 = (Object[]) event.params;
            if (event.what == 35) {
                Bj((Boolean) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.f45125q0.getVisibility() == 0) {
                hk();
                return true;
            }
            onBack();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.qzone.common.activities.base.ActivityCallBackInterface
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            ek();
        }
        return super.getActivity().onKeyUp(i3, keyEvent);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void setTitle(CharSequence charSequence) {
        com.qzone.common.activities.titlebuilder.a aVar = this.C;
        if (aVar != null) {
            aVar.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    protected final void sm(Activity activity) {
        if (activity == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.f45123p1;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f45123p1 = null;
        }
        k kVar = new k(activity);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        this.f45123p1 = createCustomDialog;
        createCustomDialog.setMessage(R.string.d65);
        this.f45123p1.setTitle(R.string.b1v);
        this.f45123p1.setNegativeButton(R.string.cancel, kVar);
        this.f45123p1.setPositiveButton(R.string.hin, kVar);
        this.f45123p1.setCancelable(false);
        if (activity.isFinishing()) {
            return;
        }
        try {
            this.f45123p1.show();
        } catch (Exception e16) {
            QZLog.e("showOpenIdConfirmDialog", e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wm(boolean z16) {
        if (z16) {
            this.K = false;
        } else {
            this.K = true;
        }
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        ArrayList<NetImageInfo> arrayList2 = this.f45143z0;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        return this.E.u(getActivity(), arrayList, dj());
    }

    private boolean Jj(Intent intent) {
        String str;
        this.f45083c0 = intent.getStringExtra("file_send_path");
        String stringExtra = intent.getStringExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOPATH);
        String str2 = BaseFragment.TAG;
        Log.d(str2, "lastVideoPath:" + this.f45083c0);
        Log.d(str2, "videoPath:" + stringExtra);
        if (TextUtils.isEmpty(this.f45083c0) || TextUtils.isEmpty(stringExtra)) {
            return true;
        }
        ti();
        long longExtra = intent.getLongExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOSIZE, 0L);
        int intExtra = intent.getIntExtra(RemoteHandleConst.VIDEO_PARAM_VIDEOTYPE, 1);
        String stringExtra2 = intent.getStringExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILPATH);
        int intExtra2 = intent.getIntExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILWIDTH, 0);
        int intExtra3 = intent.getIntExtra(RemoteHandleConst.VIDEO_PARAM_THUMBNAILHEIGHT, 0);
        long longExtra2 = intent.getLongExtra(RemoteHandleConst.VIDEO_PARAM_STARTTIME, 0L);
        long longExtra3 = intent.getLongExtra("param.duration", 0L);
        long longExtra4 = intent.getLongExtra(RemoteHandleConst.VIDEO_PARAM_TOTALDURATION, 0L);
        boolean booleanExtra = intent.getBooleanExtra(RemoteHandleConst.VIDEO_PARAM_NEEDPROCESS, false);
        Bundle bundleExtra = intent.getBundleExtra(RemoteHandleConst.VIDEO_PARAM_EXTRAS);
        boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.EDIT_LOCAL_VIDEO_DONOTHING_RETURN, false);
        ShuoshuoVideoInfo vm5 = vm(stringExtra, longExtra, intExtra, stringExtra2, intExtra3, intExtra2, longExtra2, longExtra3, longExtra4, booleanExtra, bundleExtra);
        int indexOf = this.U.indexOf(this.f45083c0);
        if (indexOf != -1) {
            str = stringExtra;
            this.U.set(indexOf, str);
        } else {
            str = stringExtra;
            fi(str);
        }
        if (booleanExtra && !booleanExtra2) {
            if (vm5 != null) {
                pi(vm5, 4);
            }
            this.Z.put(str, vm5);
            this.W.remove(str);
            this.X.remove(str);
            e9.a aVar = this.T;
            if (aVar != null) {
                aVar.B0(this.Z);
                this.T.notifyDataSetChanged();
            }
            return false;
        }
        if (!this.f45083c0.equals(str)) {
            if (this.X.containsKey(this.f45083c0)) {
                this.X.remove(this.f45083c0);
                this.X.put(str, vm5);
            }
            if (this.W.containsKey(this.f45083c0)) {
                LocalMediaInfo localMediaInfo = this.W.get(this.f45083c0);
                localMediaInfo.path = str;
                this.W.put(str, localMediaInfo);
                this.W.remove(this.f45083c0);
            }
            e9.a aVar2 = this.T;
            if (aVar2 != null) {
                aVar2.notifyDataSetChanged();
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v22 */
    private boolean Sj(Intent intent) {
        PhotoActivity photoActivity;
        ?? r16;
        final String stringExtra = intent.getStringExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR);
        if (TextUtils.isEmpty(stringExtra)) {
            return true;
        }
        ti();
        fi(stringExtra);
        di(stringExtra);
        final int intExtra = intent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, 0);
        final int intExtra2 = intent.getIntExtra(PeakConstants.VIDEO_TYPE, 1);
        final String stringExtra2 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
        final int intExtra3 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, 0);
        final int intExtra4 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, 0);
        final boolean booleanExtra = intent.getBooleanExtra(PeakConstants.VIDEO_NEED_PROCESS, false);
        final String stringExtra3 = intent.getStringExtra(ShortVideoConstants.VIDEO_NEW_FAKE_VID);
        final Bundle bundleExtra = intent.getBundleExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS);
        final boolean booleanExtra2 = intent.getBooleanExtra("from_qzone_slideshow", false);
        this.L = intent.getBooleanExtra(ShortVideoConstants.VIDEO_MOOD_TIMER_DELETE, false);
        long j3 = intExtra;
        ShuoshuoVideoInfo vm5 = vm(stringExtra, 0L, intExtra2, stringExtra2, intExtra4, intExtra3, 0L, j3, j3, booleanExtra, bundleExtra);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                final ShuoshuoVideoInfo q16 = com.qzone.util.ag.q(stringExtra, 0L, intExtra2, stringExtra2, intExtra4, intExtra3, 0L, intExtra, intExtra, booleanExtra, bundleExtra);
                if (q16 != null) {
                    q16.fakeVid = stringExtra3;
                    if (booleanExtra2 && P2VUtil.d().h()) {
                        q16.mIsUploadOrigin = true;
                    }
                    PhotoActivity.this.runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.PhotoActivity.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HashMap<String, ShuoshuoVideoInfo> hashMap = PhotoActivity.this.Z;
                            ShuoshuoVideoInfo shuoshuoVideoInfo = q16;
                            hashMap.put(shuoshuoVideoInfo.mVideoPath, shuoshuoVideoInfo);
                        }
                    });
                }
            }
        });
        if (vm5 != null) {
            vm5.fakeVid = stringExtra3;
            PhotoActivity photoActivity2 = this;
            if (photoActivity2.T != null) {
                photoActivity2.T.H0(photoActivity2.U.indexOf(vm5.mVideoPath));
            }
            if (booleanExtra2 && P2VUtil.d().h()) {
                r16 = 1;
                vm5.mIsUploadOrigin = true;
            } else {
                r16 = 1;
            }
            photoActivity2.pi(vm5, r16);
            boolean z16 = photoActivity2.f45086d0;
            photoActivity = photoActivity2;
            if (!z16) {
                QZoneWriteOperationService.v0().n0(vm5);
                photoActivity2.f45086d0 = r16;
                photoActivity = photoActivity2;
            }
        } else {
            photoActivity = this;
        }
        photoActivity.Z.put(stringExtra, vm5);
        e9.a aVar = photoActivity.T;
        if (aVar != null) {
            aVar.B0(photoActivity.Z);
            photoActivity.T.notifyDataSetChanged();
        }
        return false;
    }

    private int sl(ArrayList<String> arrayList) {
        ArrayList<String> oj5;
        int indexOf;
        if (arrayList == null || (oj5 = oj()) == null) {
            return -1;
        }
        int i3 = -1;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            if (str != null && (indexOf = oj5.indexOf(str)) >= 0 && indexOf < oj5.size()) {
                oj5.remove(str);
                if (i3 == -1) {
                    i3 = indexOf;
                }
                QZLog.d(BaseFragment.TAG, 1, "removeOriginMergeList remove path:" + str);
            }
        }
        return i3;
    }

    private ShuoshuoVideoInfo vm(String str, long j3, int i3, String str2, int i16, int i17, long j16, long j17, long j18, boolean z16, Bundle bundle) {
        ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
        shuoshuoVideoInfo.mVideoPath = str;
        shuoshuoVideoInfo.mSize = j3;
        shuoshuoVideoInfo.mEstimateSize = com.qzone.util.ag.j(str, j18, j17, false, z16);
        shuoshuoVideoInfo.mVideoType = i3;
        shuoshuoVideoInfo.mCoverUrl = str2;
        shuoshuoVideoInfo.mVideoHeight = i16;
        shuoshuoVideoInfo.mVideoWidth = i17;
        shuoshuoVideoInfo.mStartTime = j16;
        shuoshuoVideoInfo.mEndTime = j16 + j17;
        shuoshuoVideoInfo.mNeedProcess = z16;
        shuoshuoVideoInfo.mDuration = j17;
        shuoshuoVideoInfo.mTotalDuration = j18;
        shuoshuoVideoInfo.mExtras = bundle;
        QZLog.d(BaseFragment.TAG, 2, "prepareVideoInfos mCoverUrl: " + shuoshuoVideoInfo.mCoverUrl);
        return shuoshuoVideoInfo;
    }

    public HashMap<String, String> Wl(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        Iterator<String> it = this.U.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.f45080b0.size() > 0 && this.f45080b0.containsKey(next)) {
                hashMap.put(next, String.valueOf(this.f45080b0.get(next)));
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bl(Activity activity, ArrayList<String> arrayList, int i3, boolean z16, int i16, boolean z17, ConcurrentHashMap<String, String> concurrentHashMap, Bundle bundle, String str) {
        String str2;
        int i17;
        boolean z18;
        boolean z19 = (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_EDITOR, QzoneConfig.SECONDARY_SHOW_MAGIC_STICK, 1) == 1) && xo.a.b();
        Intent intent = getIntent();
        if (intent != null) {
            str2 = com.qzone.reborn.util.l.f59550a.I(this.Q1, intent);
        } else {
            str2 = "";
        }
        String str3 = str2;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putSerializable("PeakConstants.selectedMediaInfoHashMap", this.W);
        bundle2.putSerializable(PeakConstants.PANORAMA_IMAGES, this.f45080b0);
        if (zk() && !this.f45105j1 && getShowType() != 1) {
            bundle2.putBoolean("QZONE_SUPPORT_MIX_MOOD", com.qzone.publish.ui.model.b.f51931e);
        }
        bundle2.putBoolean("from_qzoneshare", pk());
        bundle2.putBoolean("from_qun", ok());
        if (intent != null) {
            bundle2.putBoolean(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, intent.getBooleanExtra(QZoneHelper.Constants.KEY_IS_EMBED_IN_TAB_ACTIVITY, false));
        }
        if (!TextUtils.isEmpty(str)) {
            bundle2.putString(QAlbumConstants.ALBUM_ID, str);
            if (QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(str)) {
                bundle2.putString(QAlbumConstants.ALBUM_NAME, QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME);
            }
        }
        bundle2.putInt(PeakConstants.KEY_SHOW_TYPE, getShowType());
        bundle2.putInt(PeakConstants.KEY_STATE_TYPE, this.K1);
        if (getShowType() == 1) {
            bundle2.putInt("PhotoConst.MAXUM_SELECTED_NUM", 30);
            bundle2.putInt("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 0);
            z18 = false;
            i17 = 1;
        } else {
            i17 = i16;
            z18 = z19;
        }
        bundle2.putInt(PeakConstants.KEY_SHOW_ORIGIN_TYPE, getShowType());
        return this.E.n(activity, this, arrayList, this.A0, i3, z16, i17, z17, z18, concurrentHashMap, str3, bundle2, this.W, this.L1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cl(Activity activity, ArrayList<String> arrayList, int i3, boolean z16, int i16, boolean z17, ConcurrentHashMap<String, String> concurrentHashMap, boolean z18, boolean z19, String str) {
        LbsDataV2.GpsInfo gpsInfo;
        if (activity == null) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "PhotoActivity.onLocalPhoto, activity is null");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(PeakConstants.IS_EMBEDED_IN_TAB, z18);
        bundle.putInt(PeakConstants.PHOTO_CURRENT_RECORD_VIDEO_COUNT, mj());
        bundle.putBoolean("NEED_QZONE_MACHINE_LEARNING_REPORT", z19);
        LbsDataV2.PoiInfo poiInfo = this.M0;
        if (poiInfo != null && (gpsInfo = poiInfo.gpsInfo) != null) {
            bundle.putDouble(AECameraConstants.KEY_LATITUDE, (gpsInfo.lat * 1.0d) / 1000000.0d);
            bundle.putDouble(AECameraConstants.KEY_LONGTITUDE, (this.M0.gpsInfo.lon * 1.0d) / 1000000.0d);
        } else {
            bundle.putDouble(AECameraConstants.KEY_LATITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).b());
            bundle.putDouble(AECameraConstants.KEY_LONGTITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT).d());
        }
        boolean booleanExtra = getIntent().getBooleanExtra(PeakConstants.KEY_UPLOAD_SINGLE_VIDEO, false);
        this.f45105j1 = booleanExtra;
        bundle.putBoolean(PeakConstants.KEY_UPLOAD_SINGLE_VIDEO, booleanExtra);
        bundle.putInt(PeakConstants.KEY_SHOW_TYPE, getShowType());
        return bl(activity, arrayList, i3, z16, i16, z17, concurrentHashMap, bundle, str);
    }

    public void nl(ArrayList<ResultRecord> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ResultRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                if (next != null && !TextUtils.isEmpty(next.uin)) {
                    RFWLog.i(BaseFragment.TAG, RFWLog.USR, "at user uin is " + next.uin + " " + next.name);
                } else {
                    RFWLog.e(BaseFragment.TAG, RFWLog.USR, "at user is illegal ");
                }
            }
            return;
        }
        RFWLog.e(BaseFragment.TAG, RFWLog.USR, "at user list is null ");
    }

    private boolean Tj(Intent intent) {
        String str;
        this.f45084c1 = true;
        String stringExtra = intent.getStringExtra("file_send_path");
        if (TextUtils.isEmpty(stringExtra) || ((str = this.f45096g1) != null && stringExtra.equals(str))) {
            return true;
        }
        ti();
        long longExtra = intent.getLongExtra(ShortVideoConstants.FILE_SEND_DURATION, 0L);
        this.f45096g1 = stringExtra;
        if (QZLog.isDevelopLevel()) {
            QZLog.d(BaseFragment.TAG, 4, "Video selected:" + this.f45096g1);
        }
        this.f45099h1 = intent.getLongExtra(PeakConstants.VIDEO_SIZE, 0L);
        this.f45102i1 = intent.getIntExtra(PeakConstants.VIDEO_TYPE, 1);
        String stringExtra2 = intent.getStringExtra(PeakConstants.VIDEO_THUMBNAIL_PATH);
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.VIDEO_NEED_PROCESS, false);
        long longExtra2 = intent.getLongExtra("start_time", 0L);
        int intExtra = intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, 0);
        int intExtra2 = intent.getIntExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, 0);
        long longExtra3 = intent.getLongExtra(PeakConstants.VIDEO_TOTAL_DURATION, longExtra);
        Bundle bundleExtra = intent.getBundleExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS);
        if (lc.b.b().getName().equals(intent.getStringExtra(PeakConstants.VIDEO_REFER))) {
            ClickReport.m(IPreloadResource.ABI_64, "350", "4");
        }
        Oj(stringExtra2, intExtra, intExtra2, longExtra2, longExtra, longExtra3, booleanExtra, bundleExtra);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wk(ExtendGridView extendGridView, int i3, List<String> list, int i16, boolean z16) {
        Bundle bundle;
        if (i3 >= this.U.size()) {
            return;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.Z.get(this.U.get(i3));
        if (shuoshuoVideoInfo != null && (bundle = shuoshuoVideoInfo.mExtras) != null && ((bundle.getInt("video_state", 0) == 1 || shuoshuoVideoInfo.mExtras.getInt("video_state", 0) == 3) && !this.T.g0(i3))) {
            this.T.H0(i3);
            this.T.notifyDataSetChanged();
            QZoneWriteOperationService.v0().n0(shuoshuoVideoInfo);
        }
        if (this.T.g0(i3)) {
            toast(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastPhotoComposing", "\u6b63\u5728\u5408\u6210\u4e2d\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
            return;
        }
        this.W0 = list == null ? 0 : list.size();
        Intent intent = new Intent();
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.W);
        intent.putExtra(PictureConst.KEY_MARKER_RESULT, this.f45142y1);
        intent.putExtra(PictureConst.KEY_SHOW_PROGRESSVIEW, false);
        intent.putExtra(PictureConst.KEY_CLASSNAME, getRealActivity().getClass().getName());
        intent.putExtra(PeakConstants.SELECTED_FACE_HAS_CHECK_MAP, this.V1);
        intent.putExtra(PeakConstants.SELECTED_NEED_SHOW_FACE_ICON_MAP, this.W1);
        intent.putExtra(PeakConstants.PHOTO_INFOS, this.A0);
        intent.putExtra(QQWinkConstants.EDITOR_TEMPORARY_ENTRANCE_RECOVERFOR_VOLUME, true);
        intent.putExtra(PictureConst.KEY_NEED_FACE_FUNTION, ok() ? 0 : QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_UPLOAD_FACE_FUNTION, 1));
        if (z16) {
            intent.putExtra(PictureConst.KEY_NEED_OPEN_FACE, z16);
        }
        intent.putExtra(PeakConstants.PANORAMA_IMAGES, this.f45080b0);
        intent.putExtra(PeakConstants.KEY_SHOW_TYPE, getShowType());
        intent.putExtra(PeakConstants.KEY_MIN_PHOTO_COUNT, kj());
        Zh(intent);
        Ri(intent);
        com.qzone.reborn.util.l.f59550a.b(list, this.W, this.X);
        this.E.t(getRealActivity(), extendGridView, i3, list, this.W, this.X, this.Z, this.X1, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            boolean z16;
            PhotoActivity.this.f45104j0.removeTextChangedListener(this);
            if (charSequence == null) {
                PhotoActivity.this.f45104j0.addTextChangedListener(this);
                PhotoActivity.this.Il();
                return;
            }
            if (!TextUtils.isEmpty(PhotoActivity.this.f45129s0)) {
                PhotoActivity.this.f45091e2 = 0;
                PhotoActivity.this.f45129s0 = null;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                PhotoActivity.this.f45091e2++;
            }
            if (PhotoActivity.this.Li()) {
                PhotoActivity photoActivity = PhotoActivity.this;
                if ((photoActivity.H || !(z16 = photoActivity.G) || (z16 && photoActivity.f45091e2 > 1)) && i17 == 1 && i16 == 0 && charSequence.toString().substring(i3, i3 + 1).equals("@")) {
                    PhotoActivity.this.fk(false);
                    PhotoActivity.this.f45127r0 = true;
                    Intent intent = new Intent();
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
                    if (PhotoActivity.this.H) {
                        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 41);
                        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.o0());
                    } else {
                        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.M());
                    }
                    Activity realActivity = PhotoActivity.this.getRealActivity();
                    if (realActivity instanceof BasePluginActivity) {
                        realActivity = ((BasePluginActivity) realActivity).getOutActivity();
                    }
                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(realActivity, intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
                }
            }
            PhotoActivity photoActivity2 = PhotoActivity.this;
            if (photoActivity2.sk(photoActivity2.f45100h2, true)) {
                PhotoActivity.this.f45104j0.getEditableText().delete(PhotoActivity.this.f45094f2, PhotoActivity.this.f45097g2);
            }
            PhotoActivity.this.Il();
            PhotoActivity.this.hl();
            PhotoActivity.this.f45104j0.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if ((i16 == 1 || i16 == 2) && i17 == 0) {
                try {
                    PhotoActivity photoActivity = PhotoActivity.this;
                    photoActivity.f45094f2 = photoActivity.Oi(charSequence, i3 + i16);
                    if (PhotoActivity.this.f45094f2 == -1) {
                        PhotoActivity.this.Il();
                    } else {
                        PhotoActivity.this.f45097g2 = i3;
                        PhotoActivity.this.f45100h2 = charSequence.toString().substring(PhotoActivity.this.f45094f2, PhotoActivity.this.f45097g2 + i16);
                    }
                } catch (Exception unused) {
                    PhotoActivity.this.Il();
                    return;
                }
            }
            ExtendEditText extendEditText = PhotoActivity.this.f45104j0;
            if (extendEditText != null) {
                extendEditText.setBeforeChangeLineCount(extendEditText.getLineCount());
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    }

    private void Lj(Intent intent, ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        HashMap<String, LocalMediaInfo> hashMap2;
        LocalMediaInfo localMediaInfo;
        HashMap<String, Integer> hashMap3;
        if (!z16) {
            if (z17) {
                Qj(arrayList);
            } else if (this.T1) {
                Mj(intent, arrayList, z19);
            } else if (z18) {
                Nj(arrayList);
            } else {
                QZLog.d(BaseFragment.TAG, 1, "loadFromAlbumList handleCommonResult: ");
                Gj(arrayList, hashMap);
            }
            rm();
            QZLog.d("[PhotoAlbum]FaceFuntion", 1, "[loadFromAlbumList] hasCrop:", Boolean.valueOf(z19));
            if (oj().size() == 1 && (hashMap2 = this.W) != null && (localMediaInfo = hashMap2.get(oj().get(0))) != null && (hashMap3 = this.f45080b0) != null && hashMap3.get(oj().get(0)) != null) {
                localMediaInfo.panoramaPhotoType = this.f45080b0.get(oj().get(0)).intValue();
            }
        }
        ym();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Pi(CharSequence charSequence, int i3, int i16) {
        while (i3 < i16) {
            int i17 = i3;
            for (int i18 = 1; i17 >= 0 && i18 <= this.f45103i2; i18++) {
                if (charSequence.charAt(i17) == '@' && sk(charSequence.toString().substring(i17, i3 + 1), false)) {
                    return true;
                }
                i17--;
            }
            i3++;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ij(int i3, int i16, String str) {
        if (i3 != 0 && i16 != 0) {
            if (i16 >= 1000 && i3 / i16 == 2.0f) {
                return XMPCoreUtil.getInstance().isPanorama(str) ? 2 : 3;
            }
            if (i16 >= 512 && i3 / i16 >= 4.0f) {
                return 1;
            }
        }
        return 3;
    }

    protected void Cl() {
    }

    protected void Dl() {
    }

    protected void Ej() {
    }

    protected void Ek() {
    }

    protected void El() {
    }

    public void Em() {
    }

    protected void Fl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gi() {
    }

    protected void Gl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hi() {
    }

    protected void Hj() {
    }

    public void Im() {
    }

    public void Km() {
    }

    public void Pk() {
    }

    protected void Pl() {
    }

    protected void Ri(Intent intent) {
    }

    protected void Zh(Intent intent) {
    }

    protected void al() {
    }

    protected void hm(RelativeLayout relativeLayout) {
    }

    protected void kl(ArrayList<String> arrayList) {
    }

    protected void ni() {
    }

    public void ol() {
    }

    protected void rm() {
    }

    protected void xm(Message message) {
    }

    protected void ym() {
    }

    protected void zi() {
    }

    protected void zm() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fm(String str, String str2) {
    }

    public void Kj(List<LocalMediaInfo> list, Intent intent) {
    }

    protected void im(LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Oj(String str, int i3, int i16, long j3, long j16, long j17, boolean z16, Bundle bundle) {
    }
}
