package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.Gson;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.api.ITofuActionApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.cardcontainer.api.IParseEMCodeApi;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tofumsg.NewTofuManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.TofuProcessSimpleEvent;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.api.INTZPlanAvatarView;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.state.report.SquareReportConst;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.json.JSONObject;
import xy2.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 [2\u00020\u0001:\u0001\\B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J&\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J \u0010&\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020%H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010'\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\u0014\u0010+\u001a\u0004\u0018\u00010(2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J8\u00103\u001a\u0004\u0018\u00010,2\u0006\u0010\u0003\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020%H\u0016J\u001a\u00107\u001a\u00020\u00112\u0006\u00106\u001a\u0002052\b\u0010'\u001a\u0004\u0018\u00010\rH\u0016J \u0010;\u001a\u0002092\u0006\u00108\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\r2\u0006\u0010:\u001a\u000209H\u0016J\b\u0010<\u001a\u00020\rH\u0016J\b\u0010=\u001a\u00020\u0004H\u0016J\u0018\u0010@\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020>H\u0016J \u0010C\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u001f2\u0006\u0010A\u001a\u0002092\u0006\u0010?\u001a\u00020BH\u0016J \u0010G\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u000205H\u0016J\b\u0010H\u001a\u00020\u0004H\u0016J$\u0010L\u001a\u0004\u0018\u00010K2\u0006\u0010I\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000201H\u0016J\b\u0010M\u001a\u00020\u0004H\u0016J\b\u0010N\u001a\u00020\rH\u0016J\b\u0010O\u001a\u00020\u0004H\u0016J\u0018\u0010R\u001a\u00020\r2\u0006\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\rH\u0016R$\u0010S\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010X\u00a8\u0006]"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTofuApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOTofuApi;", "Lcom/tencent/mobileqq/aio/msg/ah;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "isOfflineStatusTofu", "tofuItem", "Lcom/tencent/mobileqq/onlinestatus/v;", "info", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "forLastShowStatus", "furtherToCheckFilterPolicy", "", "key", "Lcom/tencent/qqnt/aio/k;", "onlineStatus", "", "saveStatusToMMKV", "processNormalOnlineStatusToFu", "uin", "getKeyForLastShowedStatus", "statusString", "parseOnlineStatus", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "aioCreate", "selfUin", "aioDelayLoad", "aioResume", "aioStop", "", "id", "checkNeedTimeStampForQQShowTofu", "Landroid/content/Context;", "context", "isScaleChat", "Lcom/tencent/aio/data/msglist/a;", "clickTofu", "url", "Landroid/graphics/drawable/Drawable;", "getApngDrawable", "aioDestroy", "getHeadDrawable", "Landroid/view/View;", "curAvatarView", "curOnlineStatus", "Landroidx/constraintlayout/widget/ConstraintLayout;", "tofuWithQQShowContainer", "Lcom/tencent/qqnt/aio/api/d;", "iNTAvatarStatusViewCb", "updateAvatarStatusView", "isTheTofuNeedFiltered", "Landroid/widget/ImageView;", "targetView", "loadDrawableByUrl", "businessId", "", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "getBackgroundTextColor", "getConfig", "isRevealEnable", "Lcom/tencent/qqnt/aio/api/g;", "cb", "getIsLike", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "Lcom/tencent/qqnt/aio/api/f;", "sendLikeStatus", "Landroid/widget/TextView;", "tv", "iv", "setOnlineStatusTextAndIcon", "isRingRevealEnable", "busiExtra", "tofuWithZPlanAvatarContainer", "Lcom/tencent/qqnt/aio/api/INTZPlanAvatarView;", "updateZPlanAvatarView", "isHitZPlanAvatarExperiment", "getTofuConfig", "isTofuExperimentC", "busId", "text", "parseTofuContent", "mCurFriendUin", "Ljava/lang/String;", "getMCurFriendUin", "()Ljava/lang/String;", "setMCurFriendUin", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOTofuApiImpl implements IAIOTofuApi {
    public static final String KEY_LAST_SHOWED_STATUS_SUFFIX = "_last_showed_new_year_tofu_status";
    public static final String LOG_LAST_STATUS_PREFIX = "FOR_LAST_STATUS::: ";
    public static final String TAG = "Reveal8978.AIOTofuApiImpl";
    public static final String TOFU_FILTER_TAG = "AIOTofuApiImpl_tofu_filter";
    private String mCurFriendUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOTofuApiImpl$c", "Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "", "a", "", "dressKey", "b", "", "success", "onLoad", NodeProps.ON_CLICK, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements aj.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.api.d f348572a;

        c(com.tencent.qqnt.aio.api.d dVar) {
            this.f348572a = dVar;
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void onLoad(boolean success) {
            QLog.i(AIOTofuApiImpl.TAG, 1, "AvatarStatusView load success? " + success);
            this.f348572a.onLoad(success);
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void a() {
            QLog.i(AIOTofuApiImpl.TAG, 1, "AvatarStatusView show first frame png success");
            this.f348572a.a();
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void onClick() {
            QLog.i(AIOTofuApiImpl.TAG, 1, "onClick mAvatarStatusView");
            this.f348572a.onClick();
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
        public void b(String dressKey) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBackgroundTextColor$lambda$4(String url, int i3, VasMMKVProxy mmkv) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(mmkv, "$mmkv");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        try {
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (drawable != null) {
                int status = drawable.getStatus();
                b bVar = new b(i3, mmkv, url);
                if (status != 1) {
                    drawable.setURLDrawableListener(bVar);
                } else {
                    bVar.onLoadSuccessed(drawable);
                }
                drawable.startDownload();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private final String getKeyForLastShowedStatus(String uin) {
        return uin + KEY_LAST_SHOWED_STATUS_SUFFIX;
    }

    private final boolean isOfflineStatusTofu(com.tencent.mobileqq.aio.msg.ah item) {
        String uid = item.getMsgRecord().peerUid;
        if (uid == null || uid.length() == 0) {
            return false;
        }
        IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(uid, TOFU_FILTER_TAG);
        if (onlineStatusSimpleInfoWithUid == null) {
            return false;
        }
        return onlineStatusSimpleInfoWithUid.u() == 20 || onlineStatusSimpleInfoWithUid.u() == 40;
    }

    private final com.tencent.qqnt.aio.k parseOnlineStatus(String statusString) {
        QLog.i(TOFU_FILTER_TAG, 1, "start to parseOnlineStatus: " + statusString);
        if (TextUtils.isEmpty(statusString)) {
            return null;
        }
        try {
            return (com.tencent.qqnt.aio.k) new Gson().fromJson(statusString, com.tencent.qqnt.aio.k.class);
        } catch (Exception e16) {
            QLog.i(TOFU_FILTER_TAG, 1, "parseOnlineStatus exception:", e16);
            return null;
        }
    }

    private final void processNormalOnlineStatusToFu(com.tencent.mobileqq.aio.msg.ah tofuItem) {
        com.tencent.mobileqq.onlinestatus.v avatarStatusInfo = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getAvatarStatusInfo(MobileQQ.sMobileQQ.peekAppRuntime(), String.valueOf(tofuItem.getMsgRecord().peerUin));
        tofuItem.A2(((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getTofuBackgroundImage(avatarStatusInfo.f256383a, avatarStatusInfo.f256385c));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioCreate(AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        String b16 = su3.c.b(aioParam);
        this.mCurFriendUin = b16;
        if (TextUtils.isEmpty(b16)) {
            QLog.d(TAG, 1, "AIO CREATE, friendUin illegal, return");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        ((NewTofuManager) manager).B(aioParam);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioDelayLoad(String selfUin) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        if (TextUtils.isEmpty(this.mCurFriendUin)) {
            QLog.d(TAG, 1, "AIO DELAY_LOAD, friendUin illegal, return");
            SimpleEventBus.getInstance().dispatchEvent(new TofuProcessSimpleEvent(true));
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        ((NewTofuManager) manager).C(this.mCurFriendUin);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioDestroy() {
        ((IOnlineStatusLikeStatusApi) QRoute.api(IOnlineStatusLikeStatusApi.class)).clearOnlineStatusCallback();
        if (TextUtils.isEmpty(this.mCurFriendUin)) {
            QLog.d(TAG, 1, "AIO DESTROY, friendUin illegal, return");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        ((NewTofuManager) manager).D();
        this.mCurFriendUin = null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioResume() {
        if (TextUtils.isEmpty(this.mCurFriendUin)) {
            QLog.d(TAG, 1, "AIO RESUME, friendUin illegal, return");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        ((NewTofuManager) manager).E();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void aioStop() {
        if (TextUtils.isEmpty(this.mCurFriendUin)) {
            QLog.d(TAG, 1, "AIO STOP, friendUin illegal, return");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        ((NewTofuManager) manager).F();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean checkNeedTimeStampForQQShowTofu(long id5) {
        QRouteApi api = QRoute.api(IZootopiaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaApi::class.java)");
        IZootopiaApi iZootopiaApi = (IZootopiaApi) api;
        return (id5 == ((long) iZootopiaApi.getSuperQQShowBeancurdId()) && iZootopiaApi.shouldHideSmallHomeEntry()) ? false : true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void clickTofu(Context context, boolean isScaleChat, com.tencent.aio.data.msglist.a item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof com.tencent.mobileqq.aio.msg.ah) {
            com.tencent.mobileqq.aio.msg.ah ahVar = (com.tencent.mobileqq.aio.msg.ah) item;
            long n26 = ahVar.n2();
            QLog.i(TAG, 1, "click tofu buSid " + n26);
            com.tencent.qqnt.aio.adapter.clickresponder.l.f348732a.a(n26).a(context, isScaleChat, ahVar);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public Drawable getApngDrawable(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return IVasApngFactory.INSTANCE.api().getDynamicDrawable(url);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public int getBackgroundTextColor(long businessId, final String url, final int defaultColor) {
        Intrinsics.checkNotNullParameter(url, "url");
        if ((url.length() == 0) || businessId != 1 || !VasNormalToggle.TOFU_TEXT_COLOR.isEnable(true)) {
            return defaultColor;
        }
        final VasMMKVProxy tofuColor = VipMMKV.INSTANCE.getTofuColor();
        if (tofuColor.containsKey(url)) {
            return Math.abs(xy2.b.b(tofuColor.decodeInt(url, defaultColor)) - xy2.b.b(defaultColor)) > 0.5d ? Color.rgb(255 - Color.red(defaultColor), 255 - Color.green(defaultColor), 255 - Color.blue(defaultColor)) : defaultColor;
        }
        y13.d.b(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.aa
            @Override // java.lang.Runnable
            public final void run() {
                AIOTofuApiImpl.getBackgroundTextColor$lambda$4(url, defaultColor, tofuColor);
            }
        });
        return defaultColor;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public String getConfig() {
        return com.tencent.qqnt.lightbusinesskit.c.a();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public Drawable getHeadDrawable(String uin) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return FaceDrawable.getFaceDrawable((QQAppInterface) runtime, 1, uin);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void getIsLike(long uin, com.tencent.qqnt.aio.api.g cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            cb5.a(false);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(uin));
        ((IOnlineStatusLikeStatusApi) QRoute.api(IOnlineStatusLikeStatusApi.class)).getLikeStatusUserReq((AppInterface) peekAppRuntime, arrayList, cb5, 1);
    }

    public final String getMCurFriendUin() {
        return this.mCurFriendUin;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public String getTofuConfig() {
        com.tencent.mobileqq.tofumsg.j jVar = (com.tencent.mobileqq.tofumsg.j) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101424");
        String a16 = jVar != null ? jVar.a() : null;
        if (a16 != null) {
            return a16;
        }
        String a17 = new com.tencent.mobileqq.tofumsg.j().a();
        Intrinsics.checkNotNullExpressionValue(a17, "TofuConfigNew().getConfigString()");
        return a17;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isHitZPlanAvatarExperiment() {
        Map mapOf;
        boolean showAIOZPlanTofu = ((IZPlanApi) QRoute.api(IZPlanApi.class)).showAIOZPlanTofu();
        if (showAIOZPlanTofu) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY));
            VideoReport.reportEvent("ev_zplan_aio_avatartofu_show_imp", mapOf);
        }
        return showAIOZPlanTofu;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isRevealEnable() {
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isRingRevealEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_ring_reveal_8983_887026677", true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isTheTofuNeedFiltered(com.tencent.aio.data.msglist.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (!(item instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return false;
        }
        com.tencent.mobileqq.aio.msg.ah ahVar = (com.tencent.mobileqq.aio.msg.ah) item;
        if (ahVar.r2().d() && !isRevealEnable()) {
            QLog.d(TAG, 1, "isTheTofuNeedFiltered:: isRevealEnable=false, need filter");
            return true;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        Manager manager = qQAppInterface.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        NewTofuManager newTofuManager = (NewTofuManager) manager;
        if (!newTofuManager.v(ahVar.getMsgRecord().msgTime)) {
            QLog.d(TOFU_FILTER_TAG, 1, "filter tofu, out of date, need filter; msg = " + item);
            return true;
        }
        if ((((int) ahVar.n2()) == 18 || ((int) ahVar.n2()) == 16) && OnlineStatusToggleUtils.i() && isOfflineStatusTofu(ahVar)) {
            QLog.d(TOFU_FILTER_TAG, 1, "filter offline status tofu, msg = " + item);
            return true;
        }
        if (((int) ahVar.n2()) == 18) {
            QLog.d(TOFU_FILTER_TAG, 1, "need show normalStatusTofu " + item);
            processNormalOnlineStatusToFu(ahVar);
            return false;
        }
        if (((int) ahVar.n2()) != 16) {
            QLog.d(TOFU_FILTER_TAG, 1, "filter NewYear QQShow tofu, cur busiid is not BUSIID_NEWYEAR_QQSHOW, msg = " + item);
            return false;
        }
        if (!((ITofuActionApi) QRoute.api(ITofuActionApi.class)).isEnableNewYearTofu(qQAppInterface)) {
            QLog.d(TOFU_FILTER_TAG, 1, "filter NewYear QQShow tofu, disable NewYear QQShow tofu, need filter; msg = " + item);
            return true;
        }
        if (ahVar.k2() != 4) {
            QLog.d(TOFU_FILTER_TAG, 1, "filter NewYear QQShow tofu, cur tofu style is not TYPE_QQ_SHOW, need filter; msg = " + item);
            return true;
        }
        if (!TextUtils.isEmpty(qQAppInterface.getAccount()) && ahVar.getMsgRecord().peerUin != 0) {
            if (!((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isDeviceSupportFilament()) {
                QLog.i(TOFU_FILTER_TAG, 1, "filter NewYear QQShow tofu, device do not support filament, need filter; msg = " + item);
                return true;
            }
            long j3 = ahVar.getMsgRecord().peerUin;
            String account = qQAppInterface.getAccount();
            Intrinsics.checkNotNullExpressionValue(account, "app.account");
            if (j3 == Long.parseLong(account)) {
                QLog.i(TOFU_FILTER_TAG, 1, "filter NewYear QQShow tofu, selfUin == friendUin; need filter; msg = " + item);
                return true;
            }
            com.tencent.mobileqq.onlinestatus.v r16 = newTofuManager.r();
            MMKVOptionEntity from = QMMKV.from(qQAppInterface.getApplicationContext(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(app.applicationCont\u2026t, QMMKVFile.FILE_COMMON)");
            if (!furtherToCheckFilterPolicy(ahVar, r16, from, false)) {
                newTofuManager.h2(null);
                return false;
            }
            if (r16 == null) {
                QLog.i(TOFU_FILTER_TAG, 1, "FOR_LAST_STATUS::: filter NewYear QQShow tofu, cur status is null, need filter; msgInfo:" + item);
                return true;
            }
            if (!((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(r16.f256383a)) {
                String keyForLastShowedStatus = getKeyForLastShowedStatus(String.valueOf(ahVar.getMsgRecord().peerUin));
                int i3 = r16.f256383a;
                String str = r16.f256384b;
                Intrinsics.checkNotNullExpressionValue(str, "info.desc");
                saveStatusToMMKV(from, keyForLastShowedStatus, new com.tencent.qqnt.aio.k(i3, str, "", r16.f256385c));
                QLog.i(TOFU_FILTER_TAG, 1, "FOR_LAST_STATUS::: filter NewYear QQShow tofu, cur status do not support AvatarView, save and need filter; msgInfo:" + item);
                return true;
            }
            String lastStatusInfo = from.decodeString(getKeyForLastShowedStatus(String.valueOf(ahVar.getMsgRecord().peerUin)), "");
            if (TextUtils.isEmpty(lastStatusInfo)) {
                QLog.i(TOFU_FILTER_TAG, 1, "FOR_LAST_STATUS::: filter NewYear QQShow tofu, last status info is empty, return; msgInfo:" + item);
                return true;
            }
            Intrinsics.checkNotNullExpressionValue(lastStatusInfo, "lastStatusInfo");
            com.tencent.qqnt.aio.k parseOnlineStatus = parseOnlineStatus(lastStatusInfo);
            if (parseOnlineStatus == null) {
                QLog.i(TOFU_FILTER_TAG, 1, "FOR_LAST_STATUS::: filter NewYear QQShow tofu, illegal status info, return; msgInfo:" + item);
                return true;
            }
            if (furtherToCheckFilterPolicy(ahVar, ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getAvatarStatusInfoByKey(parseOnlineStatus.d(), parseOnlineStatus.a()), from, true)) {
                return true;
            }
            newTofuManager.h2(null);
            return false;
        }
        QLog.i(TOFU_FILTER_TAG, 1, "filter NewYear QQShow tofu, message uin is null, need filter; msg = " + item);
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public boolean isTofuExperimentC() {
        return com.tencent.mobileqq.tofumsg.a.d();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void loadDrawableByUrl(ImageView targetView, String url) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Option obtain = Option.obtain();
        obtain.setTargetView(targetView);
        obtain.setUrl(url);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public String parseTofuContent(long busId, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return ((int) busId) != 2 ? text : ((IParseEMCodeApi) QRoute.api(IParseEMCodeApi.class)).parseEMCodeString(text);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void sendLikeStatus(long uin, int clickType, com.tencent.qqnt.aio.api.f cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            cb5.a(false, 0L);
        } else {
            ((IOnlineStatusLikeStatusApi) QRoute.api(IOnlineStatusLikeStatusApi.class)).sendLikeStatusReq((AppInterface) peekAppRuntime, String.valueOf(uin), 1, 1, clickType, cb5, null);
        }
    }

    public final void setMCurFriendUin(String str) {
        this.mCurFriendUin = str;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public void setOnlineStatusTextAndIcon(long uin, TextView tv5, ImageView iv5) {
        Intrinsics.checkNotNullParameter(tv5, "tv");
        Intrinsics.checkNotNullParameter(iv5, "iv");
        ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).setOnlineStatusTextAndIcon(String.valueOf(uin), tv5, iv5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public View updateAvatarStatusView(com.tencent.aio.data.msglist.a item, View curAvatarView, com.tencent.qqnt.aio.k curOnlineStatus, ConstraintLayout tofuWithQQShowContainer, com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb) {
        com.tencent.mobileqq.onlinestatus.view.aj ajVar;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(iNTAvatarStatusViewCb, "iNTAvatarStatusViewCb");
        if (!(item instanceof com.tencent.mobileqq.aio.msg.ah)) {
            return null;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if (curOnlineStatus == null || tofuWithQQShowContainer == null) {
            return null;
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IO\u2026ssConstant.MAIN\n        )");
        boolean isAIODialogNotShowing = ((IOnlineStatusService) runtimeService).isAIODialogNotShowing();
        QLog.d(TAG, 1, "updateAvatarStatusView isAIODialogNotShowing\uff1a" + isAIODialogNotShowing);
        if (curAvatarView == 0) {
            IAvatarStatusViewApi iAvatarStatusViewApi = (IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class);
            Context applicationContext = qQAppInterface.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
            com.tencent.mobileqq.onlinestatus.view.aj createIAvatarStatusView = iAvatarStatusViewApi.createIAvatarStatusView(applicationContext, AvatarStatusViewScene.AIO_MSG_FLOW);
            createIAvatarStatusView.setEventListener(new c(iNTAvatarStatusViewCb));
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
            int id5 = tofuWithQQShowContainer.getId();
            layoutParams.endToEnd = id5;
            layoutParams.topToTop = id5;
            layoutParams.bottomToBottom = id5;
            layoutParams.dimensionRatio = "1:1";
            Intrinsics.checkNotNull(createIAvatarStatusView, "null cannot be cast to non-null type android.view.View");
            tofuWithQQShowContainer.addView((View) createIAvatarStatusView, layoutParams);
            ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).saveAvatarStatusView(qQAppInterface, new com.tencent.mobileqq.beancurd.b(createIAvatarStatusView, String.valueOf(((com.tencent.mobileqq.aio.msg.ah) item).getMsgRecord().peerUin), curOnlineStatus.d(), curOnlineStatus.a(), isAIODialogNotShowing));
            ajVar = createIAvatarStatusView;
        } else {
            ajVar = (com.tencent.mobileqq.onlinestatus.view.aj) curAvatarView;
        }
        if (isAIODialogNotShowing) {
            ajVar.b(String.valueOf(((com.tencent.mobileqq.aio.msg.ah) item).getMsgRecord().peerUin), curOnlineStatus.d(), curOnlineStatus.a(), new aj.LoadOption(null, true, false, 4, null));
        }
        Intrinsics.checkNotNull(ajVar, "null cannot be cast to non-null type android.view.View");
        return (View) ajVar;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTofuApi
    public INTZPlanAvatarView updateZPlanAvatarView(String busiExtra, ConstraintLayout tofuWithZPlanAvatarContainer, com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb) {
        JSONObject b16;
        String string;
        JSONObject tofuJSONFromExtra;
        Intrinsics.checkNotNullParameter(busiExtra, "busiExtra");
        Intrinsics.checkNotNullParameter(iNTAvatarStatusViewCb, "iNTAvatarStatusViewCb");
        if (tofuWithZPlanAvatarContainer == null || (b16 = com.tencent.zplan.common.utils.h.f385294a.b(busiExtra)) == null || (string = b16.getString("character")) == null || (tofuJSONFromExtra = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getTofuJSONFromExtra(string)) == null) {
            return null;
        }
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context = tofuWithZPlanAvatarContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "tofuWithZPlanAvatarContainer.context");
        INTZPlanAvatarView zPlanTofuAvatarView = iZPlanApi.getZPlanTofuAvatarView(context, tofuJSONFromExtra, iNTAvatarStatusViewCb);
        if (zPlanTofuAvatarView == null) {
            return null;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        int id5 = tofuWithZPlanAvatarContainer.getId();
        layoutParams.endToEnd = id5;
        layoutParams.topToTop = id5;
        layoutParams.bottomToBottom = id5;
        layoutParams.dimensionRatio = "1:1";
        tofuWithZPlanAvatarContainer.addView(zPlanTofuAvatarView, layoutParams);
        return zPlanTofuAvatarView;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOTofuApiImpl$b", "Lcom/tencent/mobileqq/transfile/URLDrawableHelper$Adapter;", "Lcom/tencent/image/URLDrawable;", "d", "", "onLoadSuccessed", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends URLDrawableHelper.Adapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f348569d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VasMMKVProxy f348570e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f348571f;

        b(int i3, VasMMKVProxy vasMMKVProxy, String str) {
            this.f348569d = i3;
            this.f348570e = vasMMKVProxy;
            this.f348571f = str;
        }

        @Override // com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter, com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable d16) {
            int i3;
            Drawable currDrawable = d16 != null ? d16.getCurrDrawable() : null;
            if (currDrawable != null && (currDrawable instanceof ApngDrawable)) {
                d.C11578d j3 = new d.b(((ApngDrawable) currDrawable).getImage().getCurrentFrame()).a().b().j();
                if (j3 != null) {
                    i3 = j3.f();
                } else {
                    i3 = this.f348569d;
                }
                this.f348570e.encodeInt(this.f348571f, i3);
            }
        }
    }

    private final void saveStatusToMMKV(MMKVOptionEntity entity, String key, com.tencent.qqnt.aio.k onlineStatus) {
        if (entity != null && key != null && onlineStatus != null) {
            try {
                entity.encodeString(key, new Gson().toJson(onlineStatus));
                return;
            } catch (Exception e16) {
                QLog.i(TOFU_FILTER_TAG, 1, "saveStatusToMMKV exception", e16);
                return;
            }
        }
        QLog.i(TOFU_FILTER_TAG, 1, "saveStatusToMMKV but illegal params, return");
    }

    private final boolean furtherToCheckFilterPolicy(com.tencent.mobileqq.aio.msg.ah tofuItem, com.tencent.mobileqq.onlinestatus.v info, MMKVOptionEntity entity, boolean forLastShowStatus) {
        String str;
        if (forLastShowStatus) {
            str = LOG_LAST_STATUS_PREFIX;
        } else {
            str = "";
        }
        if (info == null) {
            QLog.i(TOFU_FILTER_TAG, 1, str + "filter NewYear QQShow tofu, get AvatarStatusInfo is null, need filter; msg = " + tofuItem);
            return true;
        }
        if (!((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(info.f256383a)) {
            QLog.i(TOFU_FILTER_TAG, 1, str + "filter NewYear QQShow tofu, cur status do not support AvatarView, need filter; statusInfo:" + info + ", msg = " + tofuItem);
            return true;
        }
        if (!tofuItem.r2().e() && !((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isTofuBackgroundImageReady(info.f256383a, info.f256385c)) {
            ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).downloadResource(info.f256383a, info.f256385c);
            QLog.i(TOFU_FILTER_TAG, 1, str + "filter NewYear QQShow tofu, background is not ready, trigger download, need filter; statusInfo:" + info + ", msgInfo:" + tofuItem);
            return true;
        }
        String tofuBackgroundImage = ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).getTofuBackgroundImage(info.f256383a, info.f256385c);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100154", true)) {
            if (!((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isActionResourcesReady(info.f256383a, info.f256385c)) {
                ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).downloadResource(info.f256383a, info.f256385c);
                QLog.i(TOFU_FILTER_TAG, 1, str + "filter NewYear QQShow tofu, avatar action resources is not ready, trigger download, need filter; statusInfo:" + info + ", msgInfo:" + tofuItem);
                return true;
            }
        } else {
            QLog.i(TOFU_FILTER_TAG, 1, str + "filter NewYear QQShow tofu, permit avatar action resources is not ready to show, trigger download, statusInfo:" + info + ", msgInfo:" + tofuItem);
        }
        int i3 = info.f256383a;
        String str2 = info.f256384b;
        Intrinsics.checkNotNullExpressionValue(str2, "info.desc");
        com.tencent.qqnt.aio.k kVar = new com.tencent.qqnt.aio.k(i3, str2, tofuBackgroundImage, info.f256385c);
        tofuItem.C2(kVar);
        saveStatusToMMKV(entity, getKeyForLastShowedStatus(String.valueOf(tofuItem.getMsgRecord().peerUin)), kVar);
        QLog.i(TOFU_FILTER_TAG, 1, str + "filter finish, ready toShow, onlineStatus: " + kVar + ", msgInfo:" + tofuItem);
        return false;
    }
}
