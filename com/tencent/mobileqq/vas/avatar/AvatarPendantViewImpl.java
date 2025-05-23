package com.tencent.mobileqq.vas.avatar;

import QC.UniBusinessItem;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IAvatarPhotoPickerHelperApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.config.impl.QCircleDynamicNameApiImpl;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl;
import com.tencent.mobileqq.vas.inject.IAvatarPendantView;
import com.tencent.mobileqq.vas.mask.VasMaskUtils;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IWinkAIApi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarApngProcessor;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor;
import com.tencent.mobileqq.zplan.hotpatch.api.IZPlanHotPatchApi;
import com.tencent.mobileqq.zplan.meme.api.IMemeHelper;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.state.report.SquareReportConst;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeResult;
import cooperation.peak.PeakConstants;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yh3.ZPlanHotPatchVersionInfo;

/* loaded from: classes20.dex */
public class AvatarPendantViewImpl implements IAvatarPendantView, View.OnClickListener {
    private ImageView C;
    public String J;
    Uri K;
    String M;
    private kf3.e R;
    private IZPlanAvatarVideoProcessor V;
    private IZPlanAvatarApngProcessor W;
    private boolean X;
    private long Y;
    private IAvatarPendantView.OnZplanAvatarUpdateListener Z;

    /* renamed from: a0, reason: collision with root package name */
    private Activity f308660a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f308661b0;

    /* renamed from: c0, reason: collision with root package name */
    private j f308662c0;

    /* renamed from: d0, reason: collision with root package name */
    private IAvatarPendantView.a f308664d0;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f308665e;

    /* renamed from: f, reason: collision with root package name */
    private View f308667f;

    /* renamed from: h, reason: collision with root package name */
    private AvatarLayout f308670h;

    /* renamed from: i, reason: collision with root package name */
    private QQProAvatarView f308672i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f308673m;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f308663d = null;
    public long D = -1;
    public long E = -1;
    public long F = -1;
    public int G = -1;
    public boolean H = false;
    public int I = -1;
    volatile boolean L = false;
    long N = 0;
    AtomicBoolean P = new AtomicBoolean(false);
    AtomicBoolean Q = new AtomicBoolean(false);
    private final int S = AbstractGifImage.DoAccumulativeRunnable.DELAY;
    private boolean T = false;
    private boolean U = false;

    /* renamed from: e0, reason: collision with root package name */
    private final com.tencent.mobileqq.avatar.observer.a f308666e0 = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.2
        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onGetHeadInfo(boolean z16, Setting setting) {
            String str;
            if (setting != null && (str = AvatarPendantViewImpl.this.J) != null && str.equals(setting.uin)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AvatarPendantViewImpl", 2, "onGetHeadInfo: uin=" + setting.uin);
                }
                final String str2 = AvatarDownloadUtil.get1080QQHeadDownLoadUrl(setting.url, setting.bFaceFlags);
                if (!TextUtils.isEmpty(str2)) {
                    str2 = MsfSdkUtils.insertMtype("QQHeadIcon", str2);
                }
                AvatarPendantViewImpl.this.N = setting.headImgTimestamp;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AvatarPendantViewImpl.this.c0(str2);
                    }
                });
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AvatarPendantViewImpl", 2, "onGetHeadInfo\uff0c fail");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            if (z16) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                        avatarPendantViewImpl.V(avatarPendantViewImpl.J);
                    }
                }, 32, null, false);
                AvatarPendantViewImpl.this.z0();
            }
        }
    };

    /* renamed from: f0, reason: collision with root package name */
    private final com.tencent.mobileqq.zplan.servlet.b f308668f0 = new com.tencent.mobileqq.zplan.servlet.b() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.3
        private void a(final List<kf3.d> list, final int i3) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.3.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.tencent.mobileqq.vas.b) AvatarPendantViewImpl.this.f308665e.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)) != null) {
                        AvatarPendantViewImpl.this.R = null;
                        List list2 = list;
                        if (list2 != null && list2.size() > 0) {
                            AvatarPendantViewImpl.this.R = new kf3.e();
                            AvatarPendantViewImpl.this.R.f412308c = new ArrayList();
                            AvatarPendantViewImpl.this.R.f412308c.addAll(list);
                            AvatarPendantViewImpl.this.R.f412307b = i3;
                            AvatarPendantViewImpl.this.R.f412306a = true;
                        }
                        AvatarPendantViewImpl.this.i0();
                        return;
                    }
                    QLog.e("AvatarPendantViewImpl", 1, "onGetZPlanAvatar apManager is null");
                }
            });
        }

        private void b(final boolean z16) {
            QLog.i("AvatarPendantViewImpl", 1, "onZplanRegister " + z16);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.3.1
                @Override // java.lang.Runnable
                public void run() {
                    AvatarPendantViewImpl.this.T = z16;
                    if (AvatarPendantViewImpl.this.R != null) {
                        AvatarPendantViewImpl.this.R.f412306a = AvatarPendantViewImpl.this.T;
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (i3 == 2) {
                if (z16 && obj != null) {
                    try {
                        Object[] objArr = (Object[]) obj;
                        QLog.i("AvatarPendantViewImpl", 1, "NOTIFY_TYPE_GET_ZPLAN_AVATAR_LIST, data size:" + objArr.length);
                        if (objArr.length > 1) {
                            a((List) objArr[0], ((Integer) objArr[1]).intValue());
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        QLog.e("AvatarPendantViewImpl", 1, "[onUpdate] NOTIFY_TYPE_GET_ZPLAN_AVATAR_CMSHOW_FACE_LIST. exception = ", th5);
                        return;
                    }
                }
                QLog.i("AvatarPendantViewImpl", 1, "NOTIFY_TYPE_GET_ZPLAN_AVATAR_LIST, isSuccess:" + z16 + ", data:" + obj);
                return;
            }
            if (i3 == 1 && z16 && obj != null) {
                try {
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2.length > 0) {
                        b(((Boolean) objArr2[0]).booleanValue());
                    }
                } catch (Throwable th6) {
                    QLog.e("AvatarPendantViewImpl", 1, "[onUpdate] NOTIFY_TYPE_ZPLAN_REGISTER. exception = ", th6);
                }
            }
        }
    };

    /* renamed from: g0, reason: collision with root package name */
    private final com.tencent.zplan.meme.a f308669g0 = new com.tencent.zplan.meme.a() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.4
        @Override // com.tencent.zplan.meme.a
        public void l9(final boolean z16, @NotNull final MemeResult memeResult) {
            AvatarPendantViewImpl.this.r0(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.4.1
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    MemeAction action = memeResult.getAction();
                    String recordPath = memeResult.getRecordPath();
                    MODE mode = memeResult.getAction().getMode();
                    if (action != null && mode == MODE.APNG) {
                        ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).putAction2ApngFilePath(action.getActionId(), recordPath);
                    }
                    if (action != null) {
                        QLog.d("AvatarPendantViewImpl", 1, "onRecordDone:" + action.getActionId() + " success:" + z16 + ", recordPath:" + recordPath + ", mode : " + mode.toString());
                    }
                    if (AvatarPendantViewImpl.this.I0()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onRecordDone:");
                        if (action != null) {
                            i3 = action.getActionId();
                        } else {
                            i3 = 0;
                        }
                        sb5.append(i3);
                        sb5.append(" zplan avatar list is empty");
                        QLog.e("AvatarPendantViewImpl", 1, sb5.toString());
                        return;
                    }
                    if (action == null) {
                        return;
                    }
                    kf3.d dVar = null;
                    for (kf3.d dVar2 : AvatarPendantViewImpl.this.R.f412308c) {
                        if (dVar2.f() == action.getActionId()) {
                            dVar2.h(recordPath);
                            dVar2.m(mode);
                            dVar = dVar2;
                        }
                    }
                    if (dVar == null) {
                        QLog.e("AvatarPendantViewImpl", 1, "onRecordDone:" + action.getActionId() + " target is null");
                        return;
                    }
                    if (!z16) {
                        QLog.e("AvatarPendantViewImpl", 1, "onRecordDone:" + action.getActionId() + " success:" + z16);
                        return;
                    }
                    if (AvatarPendantViewImpl.this.Z != null) {
                        AvatarPendantViewImpl.this.Z.onZplanAvatarUpdate();
                    }
                    if (AvatarPendantViewImpl.this.G == action.getActionId()) {
                        AvatarPendantViewImpl.this.t0();
                    }
                }
            });
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(@NonNull MemeAction memeAction, float f16) {
        }
    };

    /* renamed from: h0, reason: collision with root package name */
    private final ji3.d f308671h0 = new g();

    /* renamed from: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl$14, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ AvatarPendantViewImpl this$0;

        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x009c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            final Bitmap bitmap = null;
            if (FaceUtil.isUploadingAvatar()) {
                try {
                    String tempAvatarFilePath = FaceUtil.getTempAvatarFilePath();
                    File file = new File(tempAvatarFilePath);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    if (this.this$0.Q.get()) {
                        options.inSampleSize = (int) BaseImageUtil.getOptRatio(bufferedInputStream, this.this$0.f308670h.getWidth(), this.this$0.f308670h.getHeight());
                    } else {
                        options.inSampleSize = (int) BaseImageUtil.getOptRatio(bufferedInputStream, 120, 120);
                    }
                    bufferedInputStream.close();
                    Bitmap d16 = com.tencent.mobileqq.util.j.d(tempAvatarFilePath, options);
                    if (d16 != null) {
                        try {
                            QQAppInterface unused = this.this$0.f308665e;
                            d16 = QQAppInterface.getCircleFaceBitmap(d16, d16.getWidth(), d16.getHeight());
                        } catch (Exception e16) {
                            bitmap = d16;
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.d("AvatarPendantActivity", 2, e.toString());
                            }
                            if (bitmap == null) {
                            }
                            if (!QLog.isColorLevel()) {
                            }
                        }
                    }
                    bitmap = d16;
                } catch (Exception e17) {
                    e = e17;
                }
            }
            if (bitmap == null) {
                this.this$0.r0(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass14.this.this$0.f308670h.setStaticAvatar(bitmap);
                        AnonymousClass14.this.this$0.P.set(true);
                    }
                });
            } else {
                AvatarPendantViewImpl avatarPendantViewImpl = this.this$0;
                avatarPendantViewImpl.V(avatarPendantViewImpl.J);
            }
            if (!QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("AvatarPendantActivity decode Avatar, bitmap is null:");
                if (bitmap == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map f308710d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f308711e;

        a(Map map, ActionSheet actionSheet) {
            this.f308710d = map;
            this.f308711e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 >= 0 && i3 <= 1) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        Intent intent = new Intent(AvatarPendantViewImpl.this.f308660a0, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", VasToggle.VAS_AVATAR_SHEET.getStringDataSet(IndividuationUrlHelper.UrlId.PENDANT_HOME, "https://zb.vip.qq.com/v2/pages/newMinePage?appid=4&_nav_titleclr=000000&_nav_txtclr=000000&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiNDUifQ%3D%3D"));
                        AvatarPendantViewImpl.this.f308660a0.startActivity(intent);
                        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onMyPendantButton(102);
                        this.f308710d.put("dt_eid", "em_my_pendant");
                        this.f308710d.put("dt_pgid", "pg_user_avatar");
                        VideoReport.reportEvent("clck", this.f308710d);
                    }
                } else {
                    Intent intent2 = new Intent(AvatarPendantViewImpl.this.f308660a0, (Class<?>) QQBrowserActivity.class);
                    intent2.putExtra("url", VasToggle.VAS_AVATAR_SHEET.getStringDataSet("avatar", "https://zb.vip.qq.com/v2/pages/newMinePage?appid=23&_nav_titleclr=000000&_nav_txtclr=000000&traceDetail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiNDUifQ%3D%3D"));
                    AvatarPendantViewImpl.this.f308660a0.startActivity(intent2);
                    ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onMyAvatarButton(102);
                    this.f308710d.put("dt_eid", "em_my_avatar");
                    this.f308710d.put("dt_pgid", "pg_user_avatar");
                    VideoReport.reportEvent("clck", this.f308710d);
                }
                try {
                    this.f308711e.dismiss();
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onCancelButton(102);
            this.f308710d.put("dt_eid", "em_center_cancel");
            this.f308710d.put("dt_pgid", "pg_user_avatar");
            VideoReport.reportEvent("clck", view, this.f308710d);
            this.f308711e.dismiss();
        }
    }

    /* loaded from: classes20.dex */
    class b implements BusinessObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16) {
                QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 2, R.string.f237597hh, 0).show();
                AvatarPendantViewImpl.this.z0();
                AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                avatarPendantViewImpl.X = avatarPendantViewImpl.Y();
                QLog.e("AvatarPendantViewImpl", 1, "TYPE_UNI_GET_RSP success: ");
                return;
            }
            QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 1, R.string.bce, 0).show();
            QLog.e("AvatarPendantViewImpl", 1, "TYPE_UNI_GET_RSP: " + z16 + " data=" + obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements IZPlanAvatarApngProcessor.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarApngProcessor.a
        public void a(boolean z16, int i3) {
            AvatarPendantViewImpl.this.e0(z16, i3);
            if (z16) {
                IApolloDtReportHelper iApolloDtReportHelper = (IApolloDtReportHelper) QRoute.api(IApolloDtReportHelper.class);
                AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                iApolloDtReportHelper.report("avatarQQPage", "successSet", "expose", avatarPendantViewImpl.P(true, i3, avatarPendantViewImpl.f308665e.getCurrentUin()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements IZPlanAvatarVideoProcessor.a {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarVideoProcessor.a
        public void a(boolean z16, int i3, String str) {
            AvatarPendantViewImpl.this.e0(z16, i3);
            if (z16) {
                IApolloDtReportHelper iApolloDtReportHelper = (IApolloDtReportHelper) QRoute.api(IApolloDtReportHelper.class);
                AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                iApolloDtReportHelper.report("avatarQQPage", "successSet", "expose", avatarPendantViewImpl.P(true, i3, avatarPendantViewImpl.f308665e.getCurrentUin()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e implements IZPlanAvatarFileManager.a {
        e() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.api.IZPlanAvatarFileManager.a
        public void a(boolean z16, List<String> list, int i3) {
            AvatarPendantViewImpl.this.d0(z16, list, i3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class f implements ProfileCardUtil.c {
        f() {
        }

        @Override // com.tencent.mobileqq.util.ProfileCardUtil.c
        public void onResult(boolean z16) {
            if (!z16) {
                AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                avatarPendantViewImpl.V(avatarPendantViewImpl.J);
            }
        }
    }

    /* loaded from: classes20.dex */
    class g implements ji3.d {
        g() {
        }

        @Override // ji3.d
        public void a(ZPlanHotPatchVersionInfo zPlanHotPatchVersionInfo) {
            QLog.d("AvatarPendantViewImpl", 1, "zplan engine hot patching started.");
        }

        @Override // ji3.d
        public void b(int i3) {
            QLog.d("AvatarPendantViewImpl", 1, "zplan engine hot patching finished with errCode: ", Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class h extends BroadcastReceiver {
        h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QQToast.makeText(context, 2, R.string.f237447h3, 1).show();
            context.unregisterReceiver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class i extends QQPermission.BasePermissionsListener {
        i() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            AvatarPendantViewImpl.this.w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class j implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        private final int f308721a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<AvatarPendantViewImpl> f308722b;

        public j(int i3, AvatarPendantViewImpl avatarPendantViewImpl) {
            this.f308721a = i3;
            this.f308722b = new WeakReference<>(avatarPendantViewImpl);
        }

        @Nullable
        private AvatarPendantViewImpl b() {
            AvatarPendantViewImpl avatarPendantViewImpl;
            WeakReference<AvatarPendantViewImpl> weakReference = this.f308722b;
            if (weakReference == null || (avatarPendantViewImpl = weakReference.get()) == null || avatarPendantViewImpl.G != this.f308721a) {
                return null;
            }
            return avatarPendantViewImpl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            AvatarPendantViewImpl b16 = b();
            if (b16 != null) {
                b16.previewAvatar(this.f308721a, b16.H);
            }
        }

        public void d() {
            this.f308722b = null;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            QLog.i("AvatarPendantViewImpl", 1, "face:" + this.f308721a + " download fail");
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.c
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarPendantViewImpl.j.this.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class k implements ProfileCardUtil.c {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AvatarPendantViewImpl> f308723a;

        public k(AvatarPendantViewImpl avatarPendantViewImpl) {
            this.f308723a = new WeakReference<>(avatarPendantViewImpl);
        }

        @Override // com.tencent.mobileqq.util.ProfileCardUtil.c
        public void onResult(boolean z16) {
            AvatarPendantViewImpl avatarPendantViewImpl = this.f308723a.get();
            if (avatarPendantViewImpl != null && !z16) {
                avatarPendantViewImpl.V(avatarPendantViewImpl.J);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        long j3;
        long j16;
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.J), "AvatarPendantViewImpl");
        if (vasSimpleInfoWithUid != null) {
            j3 = vasSimpleInfoWithUid.pendantId;
        } else {
            j3 = this.E;
        }
        if (vasSimpleInfoWithUid != null) {
            j16 = vasSimpleInfoWithUid.pendantDiyId;
        } else {
            j16 = this.F;
        }
        if (this.D != -1 && this.E == j3 && this.F == j16) {
            I(this.D, VasMaskUtils.INSTANCE.getDefSpecialShapeMaskId(this.J), (int) this.F);
            return;
        }
        if (vasSimpleInfoWithUid != null) {
            long j17 = vasSimpleInfoWithUid.pendantId;
            if (j17 != 0) {
                this.E = j17;
                this.F = vasSimpleInfoWithUid.pendantDiyId;
                if (n.d(this.f308672i) != this.E) {
                    I(this.E, ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.J).getSpecialAvatarId(), (int) this.F);
                    return;
                }
                return;
            }
        }
        this.f308673m.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
        this.f308673m.setVisibility(4);
        if (n.d(this.f308672i) >= 0) {
            I(0L, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Intent intent) {
        ProfileCardUtil.c fVar;
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (stringExtra != null) {
            if (ar.b("shouyouye", "2024-01-29", "vas_bug_119922515").isEnable(true)) {
                fVar = new k(this);
            } else {
                fVar = new f();
            }
            if (ProfileCardUtil.i0(this.f308665e, stringExtra, intent, fVar)) {
                t0();
                IAvatarPendantView.a aVar = this.f308664d0;
                if (aVar != null) {
                    aVar.a();
                }
                int intExtra = intent.getIntExtra("fromWhereClick", -1);
                if (intExtra != 10) {
                    if (intExtra == 11) {
                        ReportController.o(this.f308665e, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 0, 0, "0", "", "", "");
                        return;
                    }
                    return;
                }
                ReportController.o(this.f308665e, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 1, 0, "1", "", "", "");
                return;
            }
            QQToast.makeText(this.f308660a0, 1, R.string.hfc, 0).show();
        }
    }

    private void C0(kf3.d dVar) {
        if (dVar.g()) {
            F0(dVar);
        } else {
            G0(dVar.f());
        }
    }

    private void D0(kf3.d dVar, IZPlanAvatarApngProcessor.a aVar) {
        if (this.W != null) {
            QLog.d("AvatarPendantViewImpl", 1, "start upload ZPlan avatar.");
            int f16 = dVar.f();
            this.W.setProcessFinishListener(aVar);
            this.W.process(f16, true);
        }
    }

    private void E0(kf3.a aVar, IZPlanAvatarVideoProcessor.a aVar2) {
        IZPlanAvatarVideoProcessor iZPlanAvatarVideoProcessor = this.V;
        if (iZPlanAvatarVideoProcessor != null) {
            iZPlanAvatarVideoProcessor.setProcessFinishListener(aVar2);
            this.V.process(aVar);
        }
    }

    private void F0(kf3.d dVar) {
        kf3.c cVar = new kf3.c();
        cVar.f412297a = dVar.f();
        cVar.f412298b = dVar.b();
        if (dVar.e() == MODE.APNG) {
            D0(dVar, new c());
        } else {
            E0(cVar, new d());
        }
    }

    private void G0(int i3) {
        ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).getSingleFrameFile(i3, this.f308665e.getCurrentUin(), new e());
    }

    private void H(int i3, int i16) {
        n.g(this.f308672i, this.J, i3, 1, 7, i16);
    }

    private List<AvatarPendantItem> H0(List<kf3.d> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (kf3.d dVar : list) {
                AvatarPendantItem avatarPendantItem = new AvatarPendantItem();
                avatarPendantItem.appid = 23;
                AvatarPendantItem.ZplanAvatarInfo zplanAvatarInfo = new AvatarPendantItem.ZplanAvatarInfo();
                avatarPendantItem.zplanAvatarInfo = zplanAvatarInfo;
                zplanAvatarInfo.portraitId = dVar.f();
                avatarPendantItem.zplanAvatarInfo.isDynamic = dVar.g();
                avatarPendantItem.zplanAvatarInfo.iconUrl = dVar.d();
                avatarPendantItem.zplanAvatarInfo.coverIndex = dVar.b();
                avatarPendantItem.zplanAvatarInfo.avatarPath = dVar.a();
                avatarPendantItem.zplanAvatarInfo.featureKey = dVar.c();
                if (dVar.e() != null) {
                    avatarPendantItem.zplanAvatarInfo.mode = dVar.e().ordinal();
                }
                avatarPendantItem.itemId = dVar.f();
                avatarPendantItem.name = "";
                avatarPendantItem.feeType = 1;
                avatarPendantItem.itemBgColor = "";
                avatarPendantItem.imageUrl = dVar.d();
                avatarPendantItem.price = 0;
                arrayList.add(avatarPendantItem);
            }
        }
        return arrayList;
    }

    private void I(long j3, int i3, int i16) {
        n.h(this.f308672i, this.J, j3, i16, PendantConstant.PENDANT_TARGET_ID_MARKET, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I0() {
        List<kf3.d> list;
        kf3.e eVar = this.R;
        if (eVar != null && (list = eVar.f412308c) != null && list.size() > 0) {
            return false;
        }
        return true;
    }

    private boolean J() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Y < 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.Y = currentTimeMillis;
        return z16;
    }

    private kf3.d K(int i3) {
        if (!I0()) {
            for (kf3.d dVar : this.R.f412308c) {
                if (dVar.f() == i3) {
                    return dVar;
                }
            }
            return null;
        }
        return null;
    }

    private View L(ActionSheet actionSheet, ArrayList<Integer> arrayList, int i3) {
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            if (arrayList.get(i16).intValue() == i3) {
                return actionSheet.findViewById(i16);
            }
        }
        return null;
    }

    private Drawable M() {
        return this.f308672i.getBackground();
    }

    private int N(int i3) {
        switch (i3) {
            case 1:
                return 23;
            case 2:
                return 27;
            case 3:
                return 13;
            case 4:
                return 24;
            case 5:
            case 8:
            default:
                return -1;
            case 6:
                return 22;
            case 7:
                return 34;
            case 9:
                return 36;
            case 10:
                return 37;
        }
    }

    private void O() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.10
            @Override // java.lang.Runnable
            public void run() {
                ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).getZPlanAvatarData();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public HashMap<String, String> P(boolean z16, int i3, String str) {
        int i16 = 2;
        rj3.a j3 = new rj3.a().e(2).c(String.valueOf(i3)).j(String.valueOf(System.currentTimeMillis() / 1000));
        if (z16) {
            i16 = 1;
        }
        return j3.f(i16).i(str).a();
    }

    @NotNull
    private ArrayList<Integer> Q(boolean z16, ActionSheet actionSheet) {
        String[] stringArray = this.f308660a0.getResources().getStringArray(R.array.f155206av);
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (com.tencent.relation.common.config.toggle.c.f364699l.g(false)) {
            T(z16, actionSheet, stringArray, arrayList);
        } else {
            S(z16, actionSheet, stringArray, arrayList);
        }
        actionSheet.addCancelButton(stringArray[16]);
        return arrayList;
    }

    private boolean R(boolean z16, ActionSheet actionSheet, ArrayList<Integer> arrayList) {
        int N;
        String d16 = com.tencent.relation.common.config.toggle.c.f364699l.d(IProfileCardConst.AVATAR_ACTION_SHEET_MALL, "");
        if (TextUtils.isEmpty(d16)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(d16);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.has("id") && jSONObject.has("title")) {
                    int i16 = jSONObject.getInt("id");
                    if ((!z16 || i16 != 1) && ((z16 || i16 != 2) && ((i16 != 7 || ((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable()) && ((i16 != 9 || ((IQQAvatarAigcMagicAvatarApi) QRoute.api(IQQAvatarAigcMagicAvatarApi.class)).enableAigcMagicAvatar()) && i16 != 10 && (N = N(i16)) >= 0)))) {
                        String optString = jSONObject.optString("title", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (optString.contains("\u8d85\u7ea7QQ\u79c0")) {
                                p0();
                            }
                            if (optString.contains(QCircleDynamicNameApiImpl.ORIGIN_OLD_NAME)) {
                                n0();
                            }
                            actionSheet.addButton(optString);
                            arrayList.add(Integer.valueOf(N));
                        }
                        if (((IWinkAIApi) QRoute.api(IWinkAIApi.class)).enableAIAvatar() && arrayList.size() == 1) {
                            actionSheet.addButton("\u5236\u4f5cAI\u5934\u50cf");
                            arrayList.add(37);
                        }
                    }
                }
                QLog.e("AvatarPendantViewImpl", 1, "initActionSheetButtonsByConfig fail. invalid config");
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AvatarPendantViewImpl", 2, "initActionSheetButtonsByConfig:" + arrayList.toString());
            }
            return true;
        } catch (JSONException e16) {
            QLog.e("AvatarPendantViewImpl", 1, e16, new Object[0]);
            return false;
        }
    }

    private void S(boolean z16, ActionSheet actionSheet, String[] strArr, ArrayList<Integer> arrayList) {
        if (z16) {
            actionSheet.addButton(strArr[27]);
            arrayList.add(27);
        } else {
            actionSheet.addButton(strArr[23]);
            arrayList.add(23);
        }
        if (((DynamicAvatarManager) this.f308665e.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).x()) {
            actionSheet.addButton(strArr[22]);
            arrayList.add(22);
        }
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable()) {
            actionSheet.addButton(strArr[34]);
            arrayList.add(34);
            p0();
        }
        actionSheet.addButton(strArr[24]);
        arrayList.add(24);
        actionSheet.addButton(strArr[13]);
        arrayList.add(13);
    }

    private void T(boolean z16, ActionSheet actionSheet, String[] strArr, ArrayList<Integer> arrayList) {
        if (R(z16, actionSheet, arrayList)) {
            if (((IWinkAIApi) QRoute.api(IWinkAIApi.class)).enableAIAvatar()) {
                actionSheet.addButton(strArr[13]);
                arrayList.add(13);
                return;
            }
            return;
        }
        if (actionSheet == null) {
            return;
        }
        actionSheet.clear();
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (z16) {
            actionSheet.addButton(strArr[27]);
            arrayList.add(27);
        } else {
            actionSheet.addButton(strArr[23]);
            arrayList.add(23);
        }
        actionSheet.addButton(strArr[24]);
        arrayList.add(24);
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable()) {
            actionSheet.addButton(strArr[34]);
            arrayList.add(34);
            p0();
        }
        actionSheet.addButton(strArr[13]);
        arrayList.add(13);
        if (((DynamicAvatarManager) this.f308665e.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).x()) {
            actionSheet.addButton(strArr[22]);
            arrayList.add(22);
        }
    }

    private void U() {
        IZPlanAvatarVideoProcessor iZPlanAvatarVideoProcessor = (IZPlanAvatarVideoProcessor) QRoute.api(IZPlanAvatarVideoProcessor.class);
        this.V = iZPlanAvatarVideoProcessor;
        iZPlanAvatarVideoProcessor.init(this.f308665e);
        IZPlanAvatarApngProcessor iZPlanAvatarApngProcessor = (IZPlanAvatarApngProcessor) QRoute.api(IZPlanAvatarApngProcessor.class);
        this.W = iZPlanAvatarApngProcessor;
        iZPlanAvatarApngProcessor.init(this.f308665e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantViewImpl", 2, "initHDHeadUrl: uin=" + str);
        }
        ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).downloadHDAvatar(this.f308665e.getCurrentAccountUin(), this.f308665e);
        Setting qQHeadSettingFromDB = this.f308665e.getQQHeadSettingFromDB(str);
        if (qQHeadSettingFromDB != null && !TextUtils.isEmpty(qQHeadSettingFromDB.url)) {
            final String str2 = AvatarDownloadUtil.get1080QQHeadDownLoadUrl(qQHeadSettingFromDB.url, qQHeadSettingFromDB.bFaceFlags);
            if (!TextUtils.isEmpty(str2)) {
                str2 = MsfSdkUtils.insertMtype("QQHeadIcon", str2);
            }
            this.N = qQHeadSettingFromDB.headImgTimestamp;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    AvatarPendantViewImpl.this.c0(str2);
                }
            });
            return;
        }
        this.f308665e.refreshFace(str);
    }

    private void W(ActionSheet actionSheet, ArrayList<Integer> arrayList) {
        View L = L(actionSheet, arrayList, 34);
        if (L == null) {
            return;
        }
        final ImageView imageView = (ImageView) L.findViewById(R.id.f166773i54);
        final TextView textView = (TextView) L.findViewById(R.id.action_sheet_button);
        this.f308661b0 = null;
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).requestAvatarEditEntranceRedDotData(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.6
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(String str) {
                if (imageView == null) {
                    return null;
                }
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportAvatarEditEntranceRedDotData(AvatarPendantViewImpl.this.f308665e, str, 101, 1);
                AvatarPendantViewImpl.this.f308661b0 = str;
                imageView.post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        if (imageView != null && textView != null && AvatarPendantViewImpl.this.f308660a0 != null) {
                            ((View) imageView.getParent()).getLayoutParams().height = -1;
                            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).topMargin = ((textView.getMeasuredHeight() - 18) * (-1)) / 2;
                            imageView.setVisibility(0);
                            AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                            imageView.setImageDrawable(ResourcesCompat.getDrawable(AvatarPendantViewImpl.this.f308660a0.getResources(), R.drawable.skin_tips_dot, null));
                        }
                    }
                });
                return null;
            }
        });
    }

    private void X() {
        this.T = BaseApplicationImpl.getApplication().getSharedPreferences("zplan_sp" + this.f308665e.getCurrentUin(), 0).getBoolean("zplan_register", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y() {
        return ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.J).isSplendid();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean Z() {
        int parseInt;
        boolean z16 = false;
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn()) {
            return false;
        }
        if (!TextUtils.isEmpty(this.M)) {
            String[] split = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), IDPCApiConstant.HEAD_CONFIG_DEFAULT).split("\\|");
            if (split.length > 3) {
                parseInt = Integer.parseInt(split[3]);
                if (parseInt != 0) {
                    z16 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AvatarPendantViewImpl", 2, "isNeedShowHDHead, result=" + z16 + ", hdHeadUrl=" + this.M + ",openflag=" + parseInt);
                }
                this.Q.set(z16);
                return z16;
            }
        }
        parseInt = 0;
        if (QLog.isColorLevel()) {
        }
        this.Q.set(z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Activity activity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            try {
                QLog.d("AvatarPendantViewImpl", 1, "registerAvatarUpdateListener unregister call");
                BroadcastReceiver broadcastReceiver = this.f308663d;
                this.f308663d = null;
                activity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e("AvatarPendantViewImpl", 1, "registerAvatarUpdateListener unregister2", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(Map map, ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onCancelButton(102);
        map.put("dt_eid", "em_center_cancel");
        map.put("dt_pgid", "pg_user_avatar");
        VideoReport.reportEvent("clck", view, map);
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0111, code lost:
    
        if (r1.pendantId != 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c0(String str) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantViewImpl", 2, "onGetHDHeadUrl: url=" + str);
        }
        if (this.f308672i instanceof QQProAvatarView) {
            t0();
            IAvatarPendantView.a aVar = this.f308664d0;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        this.M = str;
        if (Z()) {
            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.f308665e, 1, this.J);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = this.f308670h.getWidth();
            obtain.mRequestHeight = this.f308670h.getHeight();
            obtain.mFailedDrawable = faceDrawable;
            obtain.mLoadingDrawable = faceDrawable;
            obtain.mHostForHttpsVerify = "q.qlogo.cn";
            if (this.P.get()) {
                obtain.mLoadingDrawable = M();
                this.P.set(false);
            }
            String str2 = this.M + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + this.N;
            this.M = str2;
            URLDrawable.removeMemoryCacheByUrl(str2, obtain);
            URLDrawable drawable = URLDrawable.getDrawable(this.M, obtain);
            drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
            drawable.setTag(new int[]{640, 640});
            if (QLog.isColorLevel()) {
                QLog.d("AvatarPendantViewImpl", 2, "onGetHDHeadUrl: newDisplayHDHead");
            }
            this.f308670h.setFaceDrawable(this.f308665e, drawable, 1, 200, this.J, 640, true, null, false, true, false, true, 7);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantViewImpl", 2, "onGetHDHeadUrl: oldDisplayHead");
        }
        if (this.D == -1) {
            if (!QQTheme.isNowSimpleUI() && !SimpleUIUtil.isNowElderMode()) {
                NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.J), "AvatarPendantViewImpl");
                if (vasSimpleInfoWithUid != null) {
                }
            }
            z16 = true;
            this.f308670h.setFaceDrawable(this.f308665e, 1, this.J, 640, true, true, true, false, 7, z16, 106);
        }
        z16 = false;
        this.f308670h.setFaceDrawable(this.f308665e, 1, this.J, 640, true, true, true, false, 7, z16, 106);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(final boolean z16, final List<String> list, final int i3, final boolean z17) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.19
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    List list2 = list;
                    if (list2 != null && list2.size() > 0) {
                        Intent intent = new Intent();
                        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String) list.get(0));
                        intent.putExtra(FaceConstant.HeadParams.PARAM_ZPLAN_AVATAR, z17);
                        AvatarPendantViewImpl.this.B0(intent);
                        QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 2, R.string.f237497h8, 0).show();
                        return;
                    }
                    return;
                }
                QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 1, R.string.hfc, 0).show();
                QLog.e("AvatarPendantViewImpl", 1, "OnProcessFinishListener avatar frame process error! actionId: " + i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(final boolean z16, final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.17
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 2, R.string.f237497h8, 0).show();
                    return;
                }
                QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 1, R.string.hfc, 0).show();
                QLog.e("AvatarPendantViewImpl", 1, "OnProcessFinishListener avatar video process error! actionId: " + i3);
            }
        });
    }

    private void f0(kf3.d dVar) {
        if (dVar == null) {
            return;
        }
        if (TextUtils.isEmpty(dVar.a()) && !((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableUploadUnRecordZPlanAvatar()) {
            QQToast.makeText(this.f308660a0, ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getUploadUnRecordZPlanAvatarHint(), 0).show();
            QLog.e("AvatarPendantViewImpl", 1, "onUploadZPlanAvatarClicked fail, avatar unRecorded");
        } else {
            QQToast.makeText(this.f308660a0, "\u5f55\u5236\u4e2d\uff0c\u8bf7\u7a0d\u540e", 0).show();
            ((IApolloDtReportHelper) QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "setBtn", "click", P(true, dVar.f(), this.f308665e.getCurrentUin()));
            C0(dVar);
            this.I = this.G;
        }
    }

    private void g0(kf3.d dVar) {
        if (dVar == null) {
            QLog.e("AvatarPendantViewImpl", 1, "add ZPlan avatar preview failed, ZPlanAvatarInfo null.");
            return;
        }
        t0();
        IAvatarPendantView.a aVar = this.f308664d0;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        if (com.tencent.relation.common.config.toggle.c.D.g(false)) {
            QLog.i("AvatarPendantViewImpl", 1, "recordZplanAvatars, zplanAvatarEditToggleSwitch is true stop old avatar record");
            return;
        }
        if (I0()) {
            QLog.i("AvatarPendantViewImpl", 1, "recordZplanAvatars, zplanAvatarListIsEmpty, return");
            return;
        }
        if (com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date())) {
            QLog.i("AvatarPendantViewImpl", 1, "recordZplanAvatars, underMaintenance, return");
            return;
        }
        ((IMemeHelper) QRoute.api(IMemeHelper.class)).toggleQueuePauseState(false, "AvatarPendantShow");
        int zPlanOffscreenHeight = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZPlanOffscreenHeight();
        for (kf3.d dVar : this.R.f412308c) {
            dVar.k(String.valueOf(System.currentTimeMillis()));
            if (dVar.g()) {
                ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).recordDynamicAvatar(dVar.f(), this.f308665e.getCurrentUin(), zPlanOffscreenHeight, zPlanOffscreenHeight, this.f308669g0);
            } else {
                ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).recordStaticAvatar(dVar.f(), this.f308665e.getCurrentUin(), zPlanOffscreenHeight, zPlanOffscreenHeight, this.f308669g0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void j0(final Activity activity) {
        BroadcastReceiver broadcastReceiver = this.f308663d;
        if (broadcastReceiver != null) {
            try {
                this.f308663d = null;
                activity.unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e("AvatarPendantViewImpl", 1, "registerAvatarUpdateListener unregister1", e16);
            }
        }
        this.f308663d = new h();
        activity.registerReceiver(this.f308663d, new IntentFilter(FaceConstant.HeadBroadcast.BROADCAST_QQHEAD_SELF_UPDATE));
        if (activity instanceof LifecycleOwner) {
            ((LifecycleOwner) activity).getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.vas.avatar.b
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    AvatarPendantViewImpl.this.a0(activity, lifecycleOwner, event);
                }
            });
        }
    }

    private void k0() {
        ((IZPlanHotPatchApi) QRoute.api(IZPlanHotPatchApi.class)).registerHotPatchStatusListener(this.f308671h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_user_avatar");
        hashMap.put("dt_eid", "em_bas_ai_avatar");
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        VideoReport.reportEvent("dt_clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", "em_bas_take_picture");
        hashMap.put("dt_pgid", "pg_user_avatar");
        VideoReport.reportEvent(str, hashMap);
    }

    private void n0() {
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, "2");
        hashMap.put("dt_pgid", "pg_user_avatar");
        hashMap.put("dt_eid", "em_xsj_live_avatar_entrance");
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", "1");
        hashMap.put("zplan_action_type", "click");
        VideoReport.reportEvent("ev_zplan_avatar_edit_entrance", hashMap);
    }

    private void p0() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", "1");
        hashMap.put("zplan_action_type", "imp");
        VideoReport.reportEvent("ev_zplan_avatar_edit_entrance", hashMap);
    }

    private void q0() {
        if (this.U) {
            this.U = false;
            String currentAccountUin = this.f308665e.getCurrentAccountUin();
            if (currentAccountUin != null) {
                ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).queryRegister(currentAccountUin);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Runnable runnable) {
        ThreadManagerV2.getUIHandlerV2().post(runnable);
    }

    private void s0(int i3, int i16, String str, BusinessObserver businessObserver) {
        IJce build = VasUtil.getService().getJceRequset().build("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniSet", "stReq", "rsp");
        UniSetReq uniSetReq = new UniSetReq();
        uniSetReq.stLogin = IJce.Util.getLoginInfo();
        UniBusinessItem uniBusinessItem = new UniBusinessItem();
        uniSetReq.stUniBusinessItem = uniBusinessItem;
        uniBusinessItem.appid = i3;
        uniBusinessItem.itemid = i16;
        uniSetReq.operationid = str;
        build.request("uniSet", uniSetReq, new UniSetRsp(), businessObserver, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (!(this.f308672i instanceof QQProAvatarView)) {
            return;
        }
        this.f308672i.x(1, this.J, new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(this.J)).b(true).j(true).p(7).c(true).m(7).d(true).n(1).o(3).g(640).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        Intent intent = new Intent();
        int x16 = ProfileCardUtil.x(this.f308660a0);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", 100);
        intent.putExtra("BUSINESS_ORIGIN_NEW", 100);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 6);
        intent.putExtra("fromWhereClick", 11);
        intent.putExtra("AVATAR_TO_CIRCLE_PUBLISH_ALBUM", true);
        intent.putExtra("FROM_VAS_SHOPPING_PAGE", true);
        if (((IAvatarPhotoPickerHelperApi) QRoute.api(IAvatarPhotoPickerHelperApi.class)).useNewPhotoPicker()) {
            Bundle bundle = new Bundle(intent.getExtras());
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.f308660a0.getClass().getName());
            bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", this.f308660a0.getPackageName());
            ((IAvatarPhotoPickerHelperApi) QRoute.api(IAvatarPhotoPickerHelperApi.class)).startPhotoPicker(this.f308660a0, bundle);
            return;
        }
        Activity activity = this.f308660a0;
        PhotoUtils.startPhotoListEdit(intent, activity, activity.getClass().getName(), x16, x16, 1080, 1080, FaceUtil.getUploadAvatarTempPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        boolean z16;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this.f308660a0, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.AVATAR_PTOTO));
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new i());
        } else {
            w0();
        }
    }

    private void y0() {
        ((IZPlanHotPatchApi) QRoute.api(IZPlanHotPatchApi.class)).unregisterHotPatchStatusListener(this.f308671h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        String currentAccountUin = this.f308665e.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin)) {
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).requestAndUpdateData(currentAccountUin, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void cancelPreviewAvatar() {
        t0();
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void cancelPreviewPendant() {
        this.D = -1L;
        A0();
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        Activity activity;
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicAvatar", 2, "record dynamic avatar! resultCode:" + i16);
            }
            if (i16 == -1) {
                t0();
                IAvatarPendantView.a aVar = this.f308664d0;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            return;
        }
        if (i16 != -1 || i3 != 5 || (activity = this.f308660a0) == null) {
            return;
        }
        String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(activity, this.K);
        int x16 = ProfileCardUtil.x(this.f308660a0);
        Intent intent2 = new Intent();
        intent2.putExtra("Business_Origin", 100);
        intent2.putExtra("BUSINESS_ORIGIN_NEW", 100);
        intent2.putExtra("fromWhereClick", 10);
        intent2.putExtra("AVATAR_TO_CIRCLE_PUBLISH_PHOTO", true);
        intent2.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
        Activity activity2 = this.f308660a0;
        PhotoUtils.startPhotoEdit(intent2, activity2, activity2.getClass().getName(), x16, x16, 1080, 1080, realPathFromContentURI, FaceUtil.getUploadAvatarTempPath());
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void doOnDestroy() {
        QQAppInterface qQAppInterface = this.f308665e;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f308666e0);
            this.f308665e.removeObserver(this.f308668f0);
        }
        this.Z = null;
        ((IZPlanAvatarFileManager) QRoute.api(IZPlanAvatarFileManager.class)).reset();
        y0();
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void doOnNewIntent(Intent intent) {
        B0(intent);
        A0();
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void doOnPause() {
        AbstractGifImage.DoAccumulativeRunnable.DELAY = this.S;
        ApngImage.pauseAll();
        AbstractVideoImage.pauseAll();
        ((com.tencent.mobileqq.vas.b) this.f308665e.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).clear();
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void doOnResume() {
        ApngImage.playByTag(10);
        AbstractVideoImage.resumeAll();
        AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
        AbstractGifImage.resumeAll();
        A0();
        q0();
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public boolean enableZplanAvatar() {
        return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, this.f308665e.getLongAccountUin());
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public View getHeadView() {
        return this.f308667f;
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public List<AvatarPendantItem> getZplanData() {
        if (!I0()) {
            return H0(this.R.f412308c);
        }
        return null;
    }

    @QQPermissionGrant(1)
    public void grant() {
        DynamicAvatarRecordActivity.S0(this.f308660a0, 1, 1);
        ReportController.o(this.f308665e, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public boolean handleMagicAvatarBannerClick(View view, JSONObject jSONObject) {
        boolean handleAigcMagicAvatarBannerClick = ((IQQAvatarAigcMagicAvatarApi) QRoute.api(IQQAvatarAigcMagicAvatarApi.class)).handleAigcMagicAvatarBannerClick(this.f308660a0, jSONObject);
        if (handleAigcMagicAvatarBannerClick) {
            j0(this.f308660a0);
        }
        return handleAigcMagicAvatarBannerClick;
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void initView(QBaseActivity qBaseActivity) {
        this.f308660a0 = qBaseActivity;
        QQAppInterface qQAppInterface = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.f308665e = qQAppInterface;
        this.J = qQAppInterface.getCurrentAccountUin();
        View inflate = View.inflate(this.f308660a0, R.layout.hgg, null);
        this.f308667f = inflate;
        AvatarLayout avatarLayout = (AvatarLayout) inflate.findViewById(R.id.kgu);
        this.f308670h = avatarLayout;
        avatarLayout.setOnClickListener(this);
        this.f308670h.f308659e = 1;
        QQProAvatarView qQProAvatarView = (QQProAvatarView) this.f308667f.findViewById(R.id.a6e);
        this.f308672i = qQProAvatarView;
        this.f308670h.d(0, qQProAvatarView, false);
        ImageView imageView = (ImageView) this.f308667f.findViewById(R.id.f167074kh0);
        this.f308673m = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.C = (ImageView) this.f308667f.findViewById(R.id.a6f);
        if (SimpleUIUtil.getSimpleUISwitch()) {
            this.C.setVisibility(8);
        }
        this.X = Y();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                avatarPendantViewImpl.V(avatarPendantViewImpl.J);
            }
        }, 32, null, false);
        if (enableZplanAvatar()) {
            X();
            O();
            U();
            k0();
        }
        this.f308665e.addObserver(this.f308668f0);
        this.f308665e.addObserver(this.f308666e0);
        t0();
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public boolean isCurrentPreviewSplendidAvatar() {
        return this.X;
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public boolean isEnable() {
        QLog.i("AvatarPendantViewImpl", 1, "success");
        return false;
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public boolean isUserWearPendant() {
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.J), "AvatarPendantViewImpl");
        if (vasSimpleInfoWithUid != null && vasSimpleInfoWithUid.pendantId != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && !J() && view.getId() == R.id.kgu && !QQTheme.isNowSimpleUI()) {
            if (FaceUtil.isUploadingAvatar()) {
                QQToast.makeText(this.f308660a0, 1, R.string.ibh, 0).show();
            } else {
                u0();
            }
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPreviewClick();
            HashMap hashMap = new HashMap();
            hashMap.put("dt_eid", "em_avatar");
            hashMap.put("dt_pgid", "pg_user_avatar");
            VideoReport.reportEvent("clck", hashMap);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void previewAvatar(int i3, boolean z16) {
        int i16;
        cancelPreviewPendant();
        this.G = i3;
        this.H = z16;
        ImageView imageView = this.f308673m;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 4;
        }
        imageView.setVisibility(i16);
        kf3.d K = K(i3);
        if (K != null) {
            g0(K);
            return;
        }
        this.X = false;
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 23L);
        String a16 = com.tencent.mobileqq.vas.avatar.h.a(i3, com.tencent.mobileqq.vas.avatar.h.b(640));
        if (businessInstance.isFileExist(a16)) {
            H(this.G, ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.J).getSpecialAvatarId());
            return;
        }
        j jVar = this.f308662c0;
        if (jVar != null) {
            jVar.d();
        }
        j jVar2 = new j(i3, this);
        this.f308662c0 = jVar2;
        businessInstance.addDownLoadListener(a16, jVar2);
        businessInstance.startDownload(a16);
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void previewPendant(int i3, boolean z16) {
        this.f308673m.setVisibility(0);
        if (Y()) {
            c0("https://q.qlogo.cn/g?b=qq&s=100&nk=0");
            this.X = false;
        } else {
            H(0, ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.J).getSpecialAvatarId());
        }
        long j3 = i3;
        this.D = j3;
        I(j3, 0, 0);
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void setAvatar(int i3, String str) {
        kf3.d K = K(i3);
        if (K != null) {
            f0(K);
            this.X = Y();
        } else {
            s0(23, i3, str, new b());
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void setAvatarChangeListener(IAvatarPendantView.a aVar) {
        this.f308664d0 = aVar;
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void setOnZplanAvatarUpdateListener(IAvatarPendantView.OnZplanAvatarUpdateListener onZplanAvatarUpdateListener) {
        this.Z = onZplanAvatarUpdateListener;
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void setPendant(final int i3) {
        if (Y()) {
            s0(23, 0, "", null);
        }
        s0(4, i3, "", new BusinessObserver() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.13
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i16, boolean z16, Object obj) {
                if (z16) {
                    QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 2, R.string.f237597hh, 0).show();
                    if (AvatarPendantViewImpl.this.f308665e != null) {
                        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(AvatarPendantViewImpl.this.J), AvatarPendantViewImpl.this.J);
                        nTVasSimpleInfo.c();
                        nTVasSimpleInfo.pendantId = i3;
                        nTVasSimpleInfo.pendantDiyId = 0;
                        nTVasSimpleInfo.timestamp = System.currentTimeMillis();
                        ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo, "AvatarPendantViewImpl", (hx3.c<NTVasSimpleInfo>) null);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AvatarPendantViewImpl.this.A0();
                            }
                        });
                    }
                    QLog.e("AvatarPendantViewImpl", 1, "TYPE_UNI_GET_RSP success: ");
                    return;
                }
                QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, 1, R.string.bce, 0).show();
                QLog.e("AvatarPendantViewImpl", 1, "TYPE_UNI_GET_RSP: " + z16 + " data=" + obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView
    public void showSelfMenu() {
        v0();
    }

    public void u0() {
        boolean z16;
        int h06 = ea.h0(this.f308660a0, this.f308665e.getCurrentAccountUin());
        if (h06 != -1 && h06 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f308660a0, null);
        final ArrayList<Integer> Q = Q(z16, actionSheet);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.5

            /* renamed from: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl$5$a */
            /* loaded from: classes20.dex */
            class a extends QQPermission.BasePermissionsListener {
                a() {
                }

                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    AvatarPendantViewImpl.this.grant();
                }
            }

            /* renamed from: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl$5$b */
            /* loaded from: classes20.dex */
            class b extends QQPermission.BasePermissionsListener {
                b() {
                }

                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                    avatarPendantViewImpl.K = ProfileCardUtils.enterSnapshot(avatarPendantViewImpl.f308660a0, 5);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                boolean z17;
                if (i3 >= 0 && i3 < Q.size()) {
                    int intValue = ((Integer) Q.get(i3)).intValue();
                    boolean z18 = false;
                    if (intValue != 13) {
                        if (intValue != 27) {
                            if (intValue != 34) {
                                if (intValue != 36) {
                                    if (intValue != 37) {
                                        switch (intValue) {
                                            case 22:
                                                boolean isShortVideoSoLibLoaded = VideoEnvironment.isShortVideoSoLibLoaded();
                                                if (!com.tencent.mobileqq.qqaudio.audioplayer.f.j() && !DeviceInfoMonitor.getModel().contains("Redmi 3") && !DeviceInfoMonitor.getModel().contains("M3S")) {
                                                    if (isShortVideoSoLibLoaded) {
                                                        QQPermission qQPermission = QQPermissionFactory.getQQPermission(AvatarPendantViewImpl.this.f308660a0, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.AVATAR_CAMERA));
                                                        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                                                            z17 = true;
                                                        } else {
                                                            z17 = false;
                                                        }
                                                        if (qQPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
                                                            z18 = true;
                                                        }
                                                        if (!z17 && !z18) {
                                                            DynamicAvatarRecordActivity.S0(AvatarPendantViewImpl.this.f308660a0, 1, 1);
                                                            ReportController.o(AvatarPendantViewImpl.this.f308665e, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
                                                        } else {
                                                            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new a());
                                                        }
                                                    } else {
                                                        if (!AvatarPendantViewImpl.this.L) {
                                                            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.AvatarPendantViewImpl.5.2
                                                                @Override // java.lang.Runnable
                                                                public void run() {
                                                                    if (!VideoEnvironment.checkAndLoadAVCodec()) {
                                                                        ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
                                                                        ShortVideoResourceManager.s(AvatarPendantViewImpl.this.f308665e, null);
                                                                    }
                                                                }
                                                            }, null, true);
                                                            AvatarPendantViewImpl.this.L = true;
                                                        }
                                                        QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, HardCodeUtil.qqStr(R.string.jut), 0).show();
                                                    }
                                                } else {
                                                    QQToast.makeText(AvatarPendantViewImpl.this.f308660a0, HardCodeUtil.qqStr(R.string.jup), 0).show();
                                                }
                                                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onDynamicButton(102);
                                                HashMap hashMap = new HashMap();
                                                hashMap.put("dt_eid", "em_dynamic_avatar");
                                                hashMap.put("dt_pgid", "pg_user_avatar");
                                                VideoReport.reportEvent("clck", hashMap);
                                                break;
                                            case 23:
                                                ProfileCardUtil.G0(AvatarPendantViewImpl.this.f308665e, AvatarPendantViewImpl.this.f308660a0, AvatarPendantViewImpl.this.f308672i, AvatarPendantViewImpl.this.J, 0, 0);
                                                break;
                                            case 24:
                                                AvatarPendantViewImpl.this.x0();
                                                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPictureButton(102);
                                                HashMap hashMap2 = new HashMap();
                                                hashMap2.put("dt_eid", "em_album_avatar");
                                                hashMap2.put("dt_pgid", "pg_user_avatar");
                                                VideoReport.reportEvent("clck", hashMap2);
                                                AvatarPendantViewImpl avatarPendantViewImpl = AvatarPendantViewImpl.this;
                                                avatarPendantViewImpl.j0(avatarPendantViewImpl.f308660a0);
                                                break;
                                        }
                                    } else {
                                        Intent intent = new Intent();
                                        intent.putExtra("come_from", "0");
                                        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkAIAvatarMainFragment(AvatarPendantViewImpl.this.f308660a0, intent);
                                        AvatarPendantViewImpl.this.l0();
                                    }
                                } else {
                                    ((IQQAvatarAigcMagicAvatarApi) QRoute.api(IQQAvatarAigcMagicAvatarApi.class)).handleActionSheetItemClick(AvatarPendantViewImpl.this.f308660a0);
                                    AvatarPendantViewImpl avatarPendantViewImpl2 = AvatarPendantViewImpl.this;
                                    avatarPendantViewImpl2.j0(avatarPendantViewImpl2.f308660a0);
                                }
                            } else {
                                ((IZPlanApi) QRoute.api(IZPlanApi.class)).openZPlanAvatarPicEditPage(AvatarPendantViewImpl.this.f308660a0, "1", null);
                                AvatarPendantViewImpl.this.o0();
                                if (AvatarPendantViewImpl.this.f308661b0 != null) {
                                    ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportAvatarEditEntranceRedDotData(AvatarPendantViewImpl.this.f308665e, AvatarPendantViewImpl.this.f308661b0, 102, 1);
                                    AvatarPendantViewImpl.this.f308661b0 = null;
                                }
                            }
                        } else {
                            Intent intent2 = new Intent(AvatarPendantViewImpl.this.f308660a0, (Class<?>) QQBrowserActivity.class);
                            intent2.putExtra("url", ProfileContants.HISTORY_HEAD_VIEW_URL);
                            intent2.putExtra("AVATAR_TO_CIRCLE_PUBLISH_HISTORY", true);
                            AvatarPendantViewImpl.this.f308660a0.startActivity(intent2);
                            ReportController.o(AvatarPendantViewImpl.this.f308665e, "dc00898", "", "", "0X8007C10", "0X8007C10", 0, 0, "", "", "", "");
                            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onSeeHistoryButton(102);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("dt_eid", "em_check_avatar");
                            hashMap3.put("dt_pgid", "pg_user_avatar");
                            VideoReport.reportEvent("clck", hashMap3);
                        }
                    } else {
                        QQPermission qQPermission2 = QQPermissionFactory.getQQPermission(AvatarPendantViewImpl.this.f308660a0, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.AVATAR_CAMERA));
                        if (qQPermission2.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                            z18 = true;
                        }
                        if (z18) {
                            qQPermission2.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new b());
                        } else {
                            AvatarPendantViewImpl avatarPendantViewImpl3 = AvatarPendantViewImpl.this;
                            avatarPendantViewImpl3.K = ProfileCardUtils.enterSnapshot(avatarPendantViewImpl3.f308660a0, 5);
                        }
                        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPhotoButton(102);
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("dt_eid", "em_picture_avatar");
                        hashMap4.put("dt_pgid", "pg_user_avatar");
                        VideoReport.reportEvent("clck", hashMap4);
                        AvatarPendantViewImpl avatarPendantViewImpl4 = AvatarPendantViewImpl.this;
                        avatarPendantViewImpl4.j0(avatarPendantViewImpl4.f308660a0);
                        if (((IWinkAIApi) QRoute.api(IWinkAIApi.class)).enableAIAvatar()) {
                            AvatarPendantViewImpl.this.m0("clck");
                        }
                    }
                    try {
                        actionSheet.dismiss();
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                HashMap hashMap5 = new HashMap();
                hashMap5.put("dt_eid", "em_avatar_edit_cancel");
                hashMap5.put("dt_pgid", "pg_user_avatar");
                VideoReport.reportEvent("clck", hashMap5);
                actionSheet.dismiss();
            }
        });
        try {
            if (!this.f308660a0.isFinishing()) {
                actionSheet.show();
                W(actionSheet, Q);
                View findViewById = actionSheet.findViewById(0);
                if (findViewById != null) {
                    findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.juu));
                }
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPreviewListExpose();
                HashMap hashMap = new HashMap();
                hashMap.put("dt_eid", "em_avatar_edit_actionsheet");
                hashMap.put("dt_pgid", "pg_user_avatar");
                VideoReport.reportEvent("imp", hashMap);
                if (((IWinkAIApi) QRoute.api(IWinkAIApi.class)).enableAIAvatar()) {
                    m0("imp");
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantActivity", 2, "showActionSheet, historyHeadNumFlag=" + h06);
        }
        ReportController.o(this.f308665e, "dc00898", "", "", "0X800A8C8", "0X800A8C8", 0, 0, "", "", "", "");
    }

    public void v0() {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f308660a0, null);
        actionSheet.addButton(this.f308660a0.getString(R.string.f175382ye));
        actionSheet.addButton(this.f308660a0.getString(R.string.f175392yf));
        actionSheet.addCancelButton(this.f308660a0.getString(R.string.d2d));
        final HashMap hashMap = new HashMap();
        actionSheet.setOnButtonClickListener(new a(hashMap, actionSheet));
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.avatar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarPendantViewImpl.b0(hashMap, actionSheet, view);
            }
        });
        try {
            if (!this.f308660a0.isFinishing()) {
                actionSheet.show();
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onMineChooseListExpose();
                hashMap.put("dt_eid", "em_avatar_center_actionsheet");
                hashMap.put("dt_pgid", "pg_user_avatar");
                VideoReport.reportEvent("imp", hashMap);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
