package com.tencent.mobileqq.zplan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.epicgames.ue4.UE4;
import com.epicgames.ue4.ZPlanVersion;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.filament.zplan.record.FilamentNativeAppRecorder;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.util.log.ILogDelegate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControlV2;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.service.api.IVasZplanAIOSmallHomeService;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.vas.utils.ZplanVasSmallHomeUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideTransitFragment;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.mobileqq.zplan.aio.tofu.TofuAvatarLayout;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.api.IZootopiaPortalFilamentConfigHelper;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils;
import com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment;
import com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageCacheManager;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.mobileqq.zplan.avatar.report.ZPlanAvatarEditDaTongReport;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.couple.manager.ZPlanCoupleBubbleDataManager;
import com.tencent.mobileqq.zplan.couple.processor.ZPlanCoupleProfileDataProcessor;
import com.tencent.mobileqq.zplan.easteregg.EasterEggPagConfigRepo;
import com.tencent.mobileqq.zplan.easteregg.EasterEggPlayerManager;
import com.tencent.mobileqq.zplan.easteregg.manager.EasterEggPortraitResourceManager;
import com.tencent.mobileqq.zplan.easteregg.report.EasterEggDaTongReport;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.recommend.RecommendUtil;
import com.tencent.mobileqq.zplan.emoticon.report.ZPlanEmoticonReport;
import com.tencent.mobileqq.zplan.fragment.NewZplanSettingAvatarShowFragment;
import com.tencent.mobileqq.zplan.fragment.ZplanSettingFragment;
import com.tencent.mobileqq.zplan.fragment.ZplanSettingFragmentV2;
import com.tencent.mobileqq.zplan.fragment.bgedit.ZPlanBgEditFragment;
import com.tencent.mobileqq.zplan.maintenance.ZPlanMaintInfoRepo;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper;
import com.tencent.mobileqq.zplan.meme.frameanim.ZPlanAvatarBannerParams;
import com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanAvatarBannerManager;
import com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewWiringHelper;
import com.tencent.mobileqq.zplan.meme.ipc.ZPlanMemeIPCImpl;
import com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager;
import com.tencent.mobileqq.zplan.message.MessageForZPlan;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.report.trace.ZPlanLogSpanEndProcessor;
import com.tencent.mobileqq.zplan.report.trace.ZPlanReportSpanEndProcessor;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.ad;
import com.tencent.mobileqq.zplan.utils.af;
import com.tencent.mobileqq.zplan.utils.am;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.aio.api.INTZPlanAvatarView;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.recommend.main.tab.network.ZPlanTabServerDataManager;
import com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper;
import com.tencent.sqshow.zootopia.usercenter.account.ZplanAccoutReceiver;
import com.tencent.sqshow.zootopia.utils.ab;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.util.AbiUtil;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.c;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.record.ZPlanRecordResourceCenter;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.ZPlanUserAvatarInfoReq;
import com.tencent.zplan.resource.api.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZPlanConstant;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.view.NormalRenderTextureView;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cy4.ZPlanResourceBusinessData;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import javax.microedition.khronos.egl.EGL10;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONObject;
import wg3.b;

@Metadata(d1 = {"\u0000\u00aa\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\b\u00c3\u0002\u00c6\u0002\u00c9\u0002\u00cc\u0002\u0018\u0000 \u00dd\u00022\u00020\u0001:\u0002\u00de\u0002B\t\u00a2\u0006\u0006\b\u00db\u0002\u0010\u00dc\u0002J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u001aH\u0002J(\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u001aH\u0002J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020 H\u0016J \u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020 2\u0006\u0010&\u001a\u00020%H\u0016J,\u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J \u0010/\u001a\u00020\u00072\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u000200H\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u000200H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u000206H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\u001e\u0010=\u001a\u0004\u0018\u00010<2\b\u00101\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010>\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020?H\u0016J \u0010D\u001a\u00020C2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020 H\u0016J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010F\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010G\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010G\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0016J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0016J\u0010\u0010Q\u001a\u00020 2\u0006\u0010P\u001a\u00020OH\u0016J\b\u0010R\u001a\u00020 H\u0016J\"\u0010V\u001a\u00020\u00072\u0006\u0010S\u001a\u0002002\u0006\u0010T\u001a\u00020O2\b\u0010,\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010X\u001a\u00020\u00072\u0006\u0010T\u001a\u00020O2\b\u0010,\u001a\u0004\u0018\u00010WH\u0016J\u0018\u0010Z\u001a\u00020\u00072\u0006\u0010T\u001a\u00020O2\u0006\u0010,\u001a\u00020YH\u0016J\b\u0010[\u001a\u00020\u0007H\u0016J\b\u0010\\\u001a\u00020\u0007H\u0016J6\u0010d\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010]2\u0006\u0010\u0019\u001a\u00020_2\u0006\u0010a\u001a\u00020`2\b\u0010b\u001a\u0004\u0018\u00010\u00052\b\u0010c\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010e\u001a\u00020\u0007H\u0016J\u0018\u0010h\u001a\u00020\u00072\u0006\u0010g\u001a\u00020f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010l\u001a\u00020k2\u0006\u0010j\u001a\u00020iH\u0016J\u0010\u0010m\u001a\u00020k2\u0006\u0010j\u001a\u00020iH\u0016J\u001a\u0010o\u001a\u00020\u00072\u0006\u0010j\u001a\u00020i2\b\u0010,\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010q\u001a\u0004\u0018\u00010\u00052\u0006\u0010p\u001a\u00020\u0005H\u0016J\u001a\u0010r\u001a\u0004\u0018\u00010\u00052\u0006\u0010p\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0010\u0010s\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\u001a\u0010t\u001a\u0004\u0018\u00010\u00052\u0006\u0010p\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0010\u0010v\u001a\u00020u2\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0018\u0010y\u001a\u00020x2\u0006\u0010w\u001a\u00020%2\u0006\u0010p\u001a\u00020\u0005H\u0016J<\u0010}\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010z\u001a\u00020\u00052\"\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050{j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`|H\u0016J\u0010\u0010~\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J<\u0010\u007f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010z\u001a\u00020\u00052\"\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050{j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`|H\u0016J5\u0010\u0080\u0001\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\"\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050{j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`|H\u0016J5\u0010\u0081\u0001\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\"\u0010I\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050{j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`|H\u0016J\u000b\u0010\u0082\u0001\u001a\u0004\u0018\u000100H\u0016J\u001a\u0010\u0084\u0001\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00122\u0007\u0010\u0083\u0001\u001a\u00020\u0005H\u0016J\u001a\u0010\u0085\u0001\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00122\u0007\u0010\u0083\u0001\u001a\u00020\u0005H\u0016J:\u0010\u008e\u0001\u001a\u00030\u008d\u00012\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0087\u0001\u001a\u00030\u0086\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u00012\b\u0010\u008a\u0001\u001a\u00030\u0086\u00012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020%H\u0016J\u0011\u0010\u0090\u0001\u001a\u00020%2\u0006\u0010P\u001a\u00020\u0005H\u0016J'\u0010\u0095\u0001\u001a\u00020 2\u0007\u0010\u0091\u0001\u001a\u00020%2\u0007\u0010\u0092\u0001\u001a\u00020\u00052\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J'\u0010\u0096\u0001\u001a\u00020\u00072\u0007\u0010\u0091\u0001\u001a\u00020%2\u0007\u0010\u0092\u0001\u001a\u00020\u00052\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0013\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0013\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0013\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u009b\u0001\u001a\u00020\u0005H\u0016J(\u0010\u009f\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00052\u0014\u0010\u009e\u0001\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u009d\u0001H\u0016J(\u0010\u00a0\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00052\u0014\u0010\u009e\u0001\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u009d\u0001H\u0016J\t\u0010\u00a1\u0001\u001a\u00020\u0007H\u0016J\u001a\u0010\u00a3\u0001\u001a\u00020\u00072\u0006\u0010^\u001a\u00020]2\u0007\u0010\u00a2\u0001\u001a\u00020OH\u0016J\u001b\u0010\u00a6\u0001\u001a\u00020\u00072\u0007\u0010\u00a4\u0001\u001a\u00020 2\u0007\u0010,\u001a\u00030\u00a5\u0001H\u0016J\u0011\u0010\u00a7\u0001\u001a\u00020%2\u0006\u0010P\u001a\u00020\u0005H\u0016J\u001a\u0010\u00a9\u0001\u001a\u00020\u00072\u0006\u0010^\u001a\u00020]2\u0007\u0010\u00a8\u0001\u001a\u00020HH\u0016J4\u0010\u00ab\u0001\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u00052\u0019\u0010.\u001a\u0015\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00aa\u0001H\u0016J\u001a\u0010\u00ad\u0001\u001a\u00020\u00072\u0006\u0010^\u001a\u00020]2\u0007\u0010\u00ac\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u00ae\u0001\u001a\u00020\u0007H\u0016J\u0011\u0010\u00af\u0001\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0019\u0010\u00b0\u0001\u001a\u00020\u00072\u0006\u00101\u001a\u0002002\u0006\u0010P\u001a\u00020OH\u0016JN\u0010\u00b6\u0001\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\t\u0010\u00b1\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u00b3\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u001a2\u0007\u0010\u00b4\u0001\u001a\u00020 2\u0007\u0010\u00b5\u0001\u001a\u00020OH\u0016J\u001f\u0010\u00b7\u0001\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u001aJS\u0010\u00c3\u0001\u001a\u00030\u00c2\u0001\"\u000f\b\u0000\u0010\u00ba\u0001*\u00030\u00b8\u0001*\u00030\u00b9\u0001\"\n\b\u0001\u0010\u00bc\u0001*\u00030\u00bb\u00012\b\u0010\u00be\u0001\u001a\u00030\u00bd\u00012\u0007\u0010\u00bf\u0001\u001a\u00028\u00002\u000e\u0010\u00c1\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00c0\u0001H\u0016\u00a2\u0006\u0006\b\u00c3\u0001\u0010\u00c4\u0001J)\u0010\u00c9\u0001\u001a\u00020\u00072\u000e\u0010\u00c6\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u00c5\u00012\u000e\u0010\u00c8\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u00c7\u0001H\u0016J\t\u0010\u00ca\u0001\u001a\u00020%H\u0016J\t\u0010\u00cb\u0001\u001a\u00020 H\u0016J$\u0010\u00cd\u0001\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00052\t\u0010\u00cc\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J+\u0010\u00cf\u0001\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00052\u0007\u0010\u00ce\u0001\u001a\u00020\u00052\u0007\u0010\u00cc\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u00d0\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010\u00d3\u0001\u001a\u00020 2\n\u0010\u00d2\u0001\u001a\u0005\u0018\u00010\u00d1\u0001H\u0016J\u0019\u0010\u00d4\u0001\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u00052\u0006\u0010p\u001a\u00020\u0005H\u0016J\t\u0010\u00d5\u0001\u001a\u00020 H\u0016J\t\u0010\u00d6\u0001\u001a\u00020 H\u0016J\t\u0010\u00d7\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u00d8\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u00d9\u0001\u001a\u00020\u0007H\u0016J\u001c\u0010\u00dc\u0001\u001a\u00020\u00072\b\u0010\u008c\u0001\u001a\u00030\u00da\u00012\u0007\u0010,\u001a\u00030\u00db\u0001H\u0016J\n\u0010\u00de\u0001\u001a\u00030\u00dd\u0001H\u0016J \u0010\u00e2\u0001\u001a\u0005\u0018\u00010\u00e1\u00012\t\u0010\u00df\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u00e0\u0001\u001a\u00020%H\u0016J\u0010\u0010\u00e3\u0001\u001a\t\u0012\u0004\u0012\u00020%0\u00c5\u0001H\u0016J\n\u0010\u00e5\u0001\u001a\u00030\u00e4\u0001H\u0016J\u0010\u0010\u00e6\u0001\u001a\t\u0012\u0004\u0012\u00020%0\u00c5\u0001H\u0016J\t\u0010\u00e7\u0001\u001a\u00020\u0007H\u0016J'\u0010\u00e9\u0001\u001a\u00020\u00072\u0007\u0010\u00e8\u0001\u001a\u00020%2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u009d\u0001H\u0016J\u001c\u0010\u00ec\u0001\u001a\u00020\u00072\u0007\u0010\u00e8\u0001\u001a\u00020%2\b\u0010\u00eb\u0001\u001a\u00030\u00ea\u0001H\u0016J1\u0010\u00f1\u0001\u001a\u00020\u00072&\u0010\u00f0\u0001\u001a!\u0012\u0016\u0012\u00140\u0005\u00a2\u0006\u000f\b\u00ed\u0001\u0012\n\b\u00ee\u0001\u0012\u0005\b\b(\u00ef\u0001\u0012\u0004\u0012\u00020\u00070\u009d\u0001H\u0016J.\u0010\u00f4\u0001\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010<2\u0007\u0010\u00ef\u0001\u001a\u00020\u00052\u0007\u0010\u00f2\u0001\u001a\u00020%2\u0007\u0010\u00f3\u0001\u001a\u00020%H\u0016J\u001d\u0010\u00f7\u0001\u001a\u00020\u00072\u0007\u0010\u00f5\u0001\u001a\u00020\u00052\t\u0010,\u001a\u0005\u0018\u00010\u00f6\u0001H\u0016J\t\u0010\u00f8\u0001\u001a\u00020 H\u0016J\n\u0010\u00fa\u0001\u001a\u00030\u00f9\u0001H\u0016J\u001d\u0010\u00fb\u0001\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010z\u001a\u0004\u0018\u00010\u0005H\u0016J\u0011\u0010\u00fc\u0001\u001a\u00020 2\u0006\u00101\u001a\u00020<H\u0016J\u001a\u0010\u00fe\u0001\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00052\u0007\u0010\u00fd\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010\u00ff\u0001\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0016J\t\u0010\u0080\u0002\u001a\u00020 H\u0016J\u0015\u0010\u0082\u0002\u001a\u00020\u00072\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u00e1\u0001H\u0016J\u001c\u0010\u0085\u0002\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u00020\u00052\b\u0010\u0084\u0002\u001a\u00030\u0083\u0002H\u0016J\u0015\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0087\u00022\u0007\u0010T\u001a\u00030\u0086\u0002H\u0016J\u0012\u0010\u0089\u0002\u001a\u00020 2\u0007\u0010T\u001a\u00030\u0086\u0002H\u0016J\t\u0010\u008a\u0002\u001a\u00020\u0007H\u0016J\u001a\u0010\u008c\u0002\u001a\n\u0012\u0005\u0012\u00030\u008b\u00020\u00c5\u00012\u0007\u0010T\u001a\u00030\u0086\u0002H\u0016J\u0012\u0010\u008d\u0002\u001a\u00020 2\u0007\u0010T\u001a\u00030\u0086\u0002H\u0016J\t\u0010\u008e\u0002\u001a\u00020 H\u0016J\u0012\u0010\u0090\u0002\u001a\u00020\u00072\u0007\u0010\u008f\u0002\u001a\u00020\u0005H\u0016J\f\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u001e\u0010\u0093\u0002\u001a\u00020\u00052\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00052\b\u0010P\u001a\u0004\u0018\u00010\u0005H\u0016J\u0015\u0010\u0094\u0002\u001a\u00020\u00072\n\u0010\u00d2\u0001\u001a\u0005\u0018\u00010\u00d1\u0001H\u0016J\t\u0010\u0094\u0002\u001a\u00020\u0007H\u0016J\u0013\u0010\u0095\u0002\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010\u0005H\u0016J2\u0010\u0099\u0002\u001a\u00020\u00072\u0007\u0010\u0096\u0002\u001a\u00020\u00052\u0007\u0010\u0097\u0002\u001a\u00020\u00052\u0015\u0010I\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0098\u0002H\u0016J\u0012\u0010\u009b\u0002\u001a\u00020 2\u0007\u0010\u009a\u0002\u001a\u00020%H\u0016J\t\u0010\u009c\u0002\u001a\u00020 H\u0016J\t\u0010\u009d\u0002\u001a\u00020\u0007H\u0016J\t\u0010\u009e\u0002\u001a\u00020 H\u0016J(\u0010\u00a3\u0002\u001a\u0005\u0018\u00010\u00a2\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u009f\u0002\u001a\u00030\u0093\u00012\b\u0010\u00a1\u0002\u001a\u00030\u00a0\u0002H\u0016J\u0015\u0010\u00a5\u0002\u001a\u0005\u0018\u00010\u0093\u00012\u0007\u0010\u00a4\u0002\u001a\u00020\u0005H\u0016J\t\u0010\u00a6\u0002\u001a\u00020 H\u0016J\t\u0010\u00a7\u0002\u001a\u00020\u0007H\u0016J;\u0010\u00ac\u0002\u001a\u00020\u00052\u0007\u0010\u00a8\u0002\u001a\u00020\u00052\t\u0010\u00a9\u0002\u001a\u0004\u0018\u00010\u00052\b\u0010P\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u00aa\u0002\u001a\u00020 2\t\u0010\u00ab\u0002\u001a\u0004\u0018\u00010\u0005H\u0016J\u000b\u0010\u00ad\u0002\u001a\u0004\u0018\u00010]H\u0016J\u000b\u0010\u00ae\u0002\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u00b0\u0002\u001a\u000b \u00af\u0002*\u0004\u0018\u00010\u00050\u0005H\u0016J\u0012\u0010\u00b1\u0002\u001a\u00020\u00072\u0007\u0010\u008c\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010\u00b2\u0002\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0013\u0010\u00b3\u0002\u001a\u0004\u0018\u00010]2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0011\u0010\u00b4\u0002\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u00b6\u0002\u001a\u00020\u00072\u0007\u0010\u00b5\u0002\u001a\u00020OH\u0016J\t\u0010\u00b7\u0002\u001a\u00020OH\u0016J\u0011\u0010\u00b8\u0002\u001a\u00020\u00072\u0006\u0010P\u001a\u00020OH\u0016J-\u0010\u00bd\u0002\u001a\u00020\u00072\u0007\u0010\u00b9\u0002\u001a\u00020\u00052\u0007\u0010\u00ba\u0002\u001a\u00020\u00052\u0007\u0010\u00bb\u0002\u001a\u00020\u00052\u0007\u0010,\u001a\u00030\u00bc\u0002H\u0016J\u0012\u0010\u00bf\u0002\u001a\u00020\u00072\u0007\u0010,\u001a\u00030\u00be\u0002H\u0016R\u0019\u0010\u00c0\u0002\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0002\u0010\u00c1\u0002R\u0019\u0010\u00c2\u0002\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c2\u0002\u0010\u00c1\u0002R\u0018\u0010\u00c4\u0002\u001a\u00030\u00c3\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c4\u0002\u0010\u00c5\u0002R\u0018\u0010\u00c7\u0002\u001a\u00030\u00c6\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c7\u0002\u0010\u00c8\u0002R\u0018\u0010\u00ca\u0002\u001a\u00030\u00c9\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ca\u0002\u0010\u00cb\u0002R\u0018\u0010\u00cd\u0002\u001a\u00030\u00cc\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cd\u0002\u0010\u00ce\u0002R\u0019\u0010\u00cf\u0002\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cf\u0002\u0010\u00c1\u0002R!\u0010\u00d5\u0002\u001a\u00030\u00d0\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d1\u0002\u0010\u00d2\u0002\u001a\u0006\b\u00d3\u0002\u0010\u00d4\u0002R!\u0010\u00da\u0002\u001a\u00030\u00d6\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d7\u0002\u0010\u00d2\u0002\u001a\u0006\b\u00d8\u0002\u0010\u00d9\u0002\u00a8\u0006\u00df\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanApi;", "Lmqq/util/WeakReference;", "Lcom/tencent/zplan/engine/c;", "zPlanStartEngineListener", "", "from", "", "startZPlanEngine", "initZPlanMasterSettingConfig", "initFilamentLog", "initZPlanTracing", "initZPlanDeviceLevelConfig", "refreshZPlanDressInfo", "source", "reportPreloadEngine", "prepareSelfZPlanInfo", "observeUserAppearanceKeyChange", "Landroid/content/Context;", "context", "callLuaEngineFinish", "setGraphicsQualityLuaCall", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "checkResidenceAuth", "handleDownloadStatus", "showSmallHomeTransitPanel", "input", "decompressGzip", "", "isEngineHotReady", "stopZPlanEngine", "shouldCheckFloat", "desc", "", "sceneType", "killZPlanProcess", "Ldy4/a;", "zplanRender", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "enterAvatarScene", "callback", "startEngineWhenNotReady", "Lcom/tencent/common/app/AppInterface;", "app", "prepareZPlanEnv", "prepareZPlanConfig", "checkUe4So", "preloadZPlanEngine", "Ljavax/microedition/khronos/egl/EGLContext;", "getUEContext", "Landroid/opengl/EGLContext;", "getUEAndroidContext", "Lmqq/app/MobileQQ;", "procname", "Lmqq/app/AppRuntime;", "createZplanAppInterface", "isEngineReady", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "needTouch", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "Lcom/tencent/zplan/world/view/NormalRenderTextureView;", "getZPlanTextureView", "startSettingActivity", "startSettingV2Activity", "startAvatarSettingActivity", "Landroid/content/Intent;", "params", "startFriendChooseActivity", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "statusUpdateListener", "registerZPlanEngineStatusUpdateListener", "unRegisterZPlanEngineStatusUpdateListener", "", "uin", "isQzoneEntranceEnabled", "isDrawerEntranceSwitchOpen", "appInterface", "scene", "Lji3/k;", "setOnSettingChangeListener", "Lji3/m;", "setOnZPlanSettingChangeListener", "Lji3/j;", "setOnZplanAccessibleWithoutSettingListener", "resumeEngine", "pauseEngine", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/model/e;", "Lcom/tencent/mobileqq/activity/aio/p;", SessionDbHelper.SESSION_ID, "peerUin", "peerNickName", "sendMessage", "reLoginAfterAccountChanged", "", "baseChatPie", "openZPlanEmoticonPanel", "Lcom/tencent/mobileqq/zplan/model/MaintEntryType;", "type", "Lcom/tencent/mobileqq/zplan/model/i;", "getMaintenanceInfo", "refetchMaintenanceInfoSync", "Lcom/tencent/mobileqq/zplan/model/d;", "refetchMaintenanceInfoAsync", "theme", "getZPlanAvatarImagePath", "getZPlanAvatarImagePathWithUin", "getZPlanStaticAvatarKey", "getAvatarLocalUrlWithUin", "", "getAvaterWindowsillLocationWithUin", "gender", "Ljava/net/URL;", "getZPlanDefaultAvatarURL", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "handleZPlanEnterAvatarSceneScheme", "cleanZPlanCache", "handleZPlanOpenPageScheme", "handleToast", "handleZplanThirdScheme", "getAppInterface", "schemeUrl", "launchScheme", "launchSchemeWithContext", "Landroid/widget/FrameLayout;", "zPlanBannerLayout", "Landroid/widget/ImageView;", "avatarIV", "backgroundContainer", "Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", "param", "Lcom/tencent/mobileqq/zplan/meme/frameanim/a;", "createZPlanAvatarBannerManager", "getZPlanGender", "getZPlanGenderWithUin", "portraitId", "selfUin", "Lorg/json/JSONObject;", "emoticonJson", "isEmoticonPicRecorded", "recordEmoticonFromRecommend", "getDynamicAvatarUrl", "getDynamicAvatarProperty", "getDynamicAvatarAppearanceKey", "pausePlaySharpPForReport", "getZPlanVersion", "path", "Lkotlin/Function1;", "onResult", "setAvatarFromPeak", "addPicToCustomEmoticonFromPeak", HippyReporter.RemoveEngineReason.CLEAR_CACHE, DetailMeFragmentConfig.CURRENT_STATUS_ID, "showStatusTip", "isChecked", "Lji3/l;", "updateZPlanSettingQZoneSwitch", "getStatusPortraitIdByUin", "intent", "startZPlanBackgroundEdit", "Lkotlin/Function2;", "update", "imgPath", "setZPlanBackgroundImage", "requestStaticImageUrl", "requestStaticImageUrlWithUin", "preloadZPlanSuitIfNeed", IProfileProtocolConst.PARAM_TARGET_UIN, PanoramaConfig.KEY_CURRENT_UIN, "nickName", "isNeedTransit", "connectedTime", "openSmallHomeGuidePageFromQav", "openSmallHomeGuideTransitPage", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "T", "Landroidx/lifecycle/ViewModel;", "K", "Landroid/view/LayoutInflater;", "inflater", "lifecycleSpan", "Ljava/lang/Class;", "viewModelClass", "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "createAvatarLoadingViewHelper", "(Landroid/view/LayoutInflater;Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Class;)Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lkotlin/Function0;", "onDone", "requireUserZPlanInfo", "getZPlanStartStatus", "isZPlanAvatarSettingEnable", "enableNewTask", "openZPlanAvatarPicEditPage", "backupUrl", "openZPlanAvatarPicEditPageWithWhiteListCheck", "checkZPlanAvatarUpdate", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "isZPlanMessage", "getStaticDefaultUrlFromConfig", "isBigScreen", "showAioZPlanGifLoading", "resetZPlanEnvOnSSOChange", "clearRecordCache", "doOnClearSystemCache", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "Lcom/tencent/mobileqq/zplan/easteregg/t;", "getEasterEggPortraitResource", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "createZPlanAvatarEasterEggManager", "msg", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/mobileqq/zplan/easteregg/a;", "getMatchKeywordEasterEggConfig", "getEasterEggAllConfigPortraitId", "Lcom/tencent/mobileqq/zplan/easteregg/u;", "createEasterEggDaTongReporter", "getEasterEggPreRecordPortraitId", "pauseRecordQueueAfterEnterBackground", "mapId", "isDeviceAdaptiveForMod", "Lgw4/f;", "commonCheckResult", "updateCheckResultCache", "Lkotlin/ParameterName;", "name", "itemId", "callBack", "requestAvatarEditEntranceRedDotData", "actionId", "avatarEntrance", "reportAvatarEditEntranceRedDotData", "fromSource", "Lji3/n;", "checkUEBsResource", "isUEBsResourceReady", "Lcom/tencent/mobileqq/zplan/avatar/b;", "createAvatarEditDaTongReporter", "shouldInterceptWebToNative", "getZPlanEditAvatarFlag", "appearanceKey", "saveAppearanceKeyToMMKV", "getAppearanceKeyFromMMKV", "isFilamentEnabled", DownloadInfo.spKey_Config, "reportEasterEggPlaySuccess", "Landroid/os/Bundle;", "bundle", "appendPageDataToScheme", "Lcom/tencent/mobileqq/zplan/meme/ZPlanRecordScene;", "Lcom/tencent/zplan/meme/EngineType;", "getTargetEngineForRecord", "enableFilamentRecordResultUpload", "clearMMKVCacheWhenLogout", "Lcom/tencent/zplan/record/model/Source;", "getRecordSourceWhenUsingFilament", "enableFilamentRecordCloudCache", "enablePortalPlanarShadow", "updatedStatus", "setZPlanEmoticonGrayTipsMMKV", "getZPlanEmoticonGrayTipsMMKV", "originURL", "updateSchemeURLWithUin", "refreshZPlanEmoticonGrayTipsMMKVIfNeed", "getEmoticonGrayTipsCreateRoleScheme", com.heytap.mcssdk.a.a.f36102l, "eventCode", "", "reportToBeacon", "filamentSceneType", "enableMiniHome", "miniHomeQQMCSwitchOn", "setMiniHomeRewardGiftBubbleMMKV", "getMiniHomeRewardGiftBubbleMMKV", "avatarCharacter", "Lcom/tencent/qqnt/aio/api/d;", "iNTAvatarStatusViewCb", "Lcom/tencent/qqnt/aio/api/INTZPlanAvatarView;", "getZPlanTofuAvatarView", "busiExtra", "getTofuJSONFromExtra", "showAIOZPlanTofu", "jumpToSplash", ISchemeApi.KEY_REFERER, "subReferer", "isFocus", ISchemeApi.KEY_PAGE_DATA, "generateXWConnectScheme", "getTopActivity", "getCurrentUin", "kotlin.jvm.PlatformType", "getSSOServerEnvName", "notifyAppearanceKeyChange", "isNetworkAvailable", "getActivityFromContext", "showOpenVipSuccessDialog", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "saveLastZPlanUsingTimeStamp", "getLastZPlanUsingTimeStamp", "preRequestMiniHomeFlag", "oldFilePath", "diffFilePath", "outFilePath", "Lji3/b;", "hDiffPatch", "Lcom/tencent/mobileqq/zplan/api/IZPlanApi$c;", "preloadHDiffPatchSo", "prepared", "Z", "engineHotReady", "com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$h", "onAppForgroundListener", "Lcom/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$h;", "com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$g", "mZPlanEngineStatusUpdateListener", "Lcom/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$g;", "com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$f", "mAppearanceKeyChangeObserver", "Lcom/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$f;", "com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$j", "preloadStartEngineListener", "Lcom/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$j;", "hasCheckZPlanAvatar", "Lcom/tencent/mobileqq/zplan/report/trace/ZPlanLogSpanEndProcessor;", "logSpanEndProcessor$delegate", "Lkotlin/Lazy;", "getLogSpanEndProcessor", "()Lcom/tencent/mobileqq/zplan/report/trace/ZPlanLogSpanEndProcessor;", "logSpanEndProcessor", "Lcom/tencent/mobileqq/zplan/report/trace/ZPlanReportSpanEndProcessor;", "reportSpanEndProcessor$delegate", "getReportSpanEndProcessor", "()Lcom/tencent/mobileqq/zplan/report/trace/ZPlanReportSpanEndProcessor;", "reportSpanEndProcessor", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanApiImpl implements IZPlanApi {
    public static final a Companion = new a(null);
    public static final String FILAMENT_TAG = "filament";
    public static final String TAG = "[zplan][ZPlanApiImpl]";
    private boolean engineHotReady;
    private boolean hasCheckZPlanAvatar;
    private final Lazy logSpanEndProcessor$delegate;
    private boolean prepared;
    private final Lazy reportSpanEndProcessor$delegate;
    private final h onAppForgroundListener = new h();
    private final g mZPlanEngineStatusUpdateListener = new g();
    private final f mAppearanceKeyChangeObserver = new f();
    private final j preloadStartEngineListener = new j();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$a;", "", "", "FILAMENT_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331342a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f331343b;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f331342a = iArr;
            int[] iArr2 = new int[ZPlanRecordScene.values().length];
            try {
                iArr2[ZPlanRecordScene.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            f331343b = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$c", "Ljj3/a;", "", "result", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements jj3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f331344a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1) {
            this.f331344a = function1;
        }

        @Override // jj3.a
        public void onResult(boolean result) {
            this.f331344a.invoke(Boolean.valueOf(result));
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$d", "Lcom/tencent/filament/zplanservice/util/log/ILogDelegate;", "Lcom/tencent/filament/zplanservice/util/log/ILogDelegate$Level;", "level", "", "tag", "msg", "", "throwable", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements ILogDelegate {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f331345a;

            static {
                int[] iArr = new int[ILogDelegate.Level.values().length];
                try {
                    iArr[ILogDelegate.Level.VERBOSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ILogDelegate.Level.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ILogDelegate.Level.INFO.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ILogDelegate.Level.WARN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f331345a = iArr;
            }
        }

        d() {
        }

        @Override // com.tencent.filament.zplanservice.util.log.ILogDelegate
        public void a(ILogDelegate.Level level, String tag, String msg2, Throwable throwable) {
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            try {
                int i3 = a.f331345a[level.ordinal()];
                if (i3 == 1 || i3 == 2) {
                    QLog.d("filament_" + tag, 1, msg2, throwable);
                } else if (i3 == 3) {
                    QLog.i("filament_" + tag, 1, msg2, throwable);
                } else if (i3 != 4) {
                    QLog.e("filament_" + tag, 1, msg2, throwable);
                } else {
                    QLog.w("filament_" + tag, 1, msg2, throwable);
                }
            } catch (Throwable th5) {
                QLog.e(ZPlanApiImpl.TAG, 1, "FLog printLog error, " + th5);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$e", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$a;", "", "result", "isNotBlack", "", "redirectScheme", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements CheckPhoneManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f331346a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function1<? super Boolean, Unit> function1) {
            this.f331346a = function1;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void a(boolean result, boolean isNotBlack, String redirectScheme) {
            Intrinsics.checkNotNullParameter(redirectScheme, "redirectScheme");
            this.f331346a.invoke(Boolean.valueOf(isNotBlack));
        }

        @Override // com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager.a
        public void b(boolean z16) {
            CheckPhoneManager.a.C9150a.a(this, z16);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$f", "Lcom/tencent/mobileqq/zplan/servlet/m;", "", "success", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f extends com.tencent.mobileqq.zplan.servlet.m {
        f() {
        }

        @Override // com.tencent.mobileqq.zplan.servlet.m
        public void a(boolean success, List<String> uinList) {
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            super.a(success, uinList);
            QLog.i(ZPlanApiImpl.TAG, 1, "onUserAppearanceKeyChange, uinList:" + uinList);
            QRouteApi api = QRoute.api(ICommonApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(ICommonApi::class.java)");
            ICommonApi.a.a((ICommonApi) api, null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$g", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "success", "engineInitFinish", "engineDestroy", "enginePurging", "enginePurged", "engineInversePurged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements ZPlanEngineStatusUpdateListener {
        g() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            QLog.i(ZPlanApiImpl.TAG, 1, "ZPlanApi, startZPlanEngine, engineInitFinish success:" + success);
            ZPlanApiImpl zPlanApiImpl = ZPlanApiImpl.this;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            zPlanApiImpl.callLuaEngineFinish(context);
            boolean M = ZPlanFeatureSwitch.f369852a.M();
            com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
            if (S != null) {
                a.C10063a.b(S, "N2L_SwitchSSO", "{\"EnableSSO\": true, \"UseNativeRecord\": " + M + "}", null, 4, null);
            }
            t74.s.f435588a.b(ZPlanApiImpl.this.onAppForgroundListener);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            QLog.i(ZPlanApiImpl.TAG, 1, "engineInversePurged");
            ZPlanApiImpl.this.engineHotReady = true;
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean connect) {
            QLog.i(ZPlanApiImpl.TAG, 1, "ZPlanApi, startZPlanEngine, serviceConnected:" + connect);
            if (!connect) {
                ZPlanApiImpl.this.engineHotReady = false;
                t74.s.f435588a.c(ZPlanApiImpl.this.onAppForgroundListener);
            }
            PerfReportUtil.o(connect);
            nb4.c.f419781a.b(connect);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            QLog.i(ZPlanApiImpl.TAG, 1, "engineDestroy");
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            QLog.i(ZPlanApiImpl.TAG, 1, "enginePurged");
            ZPlanApiImpl.this.engineHotReady = false;
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            QLog.i(ZPlanApiImpl.TAG, 1, "enginePurging");
            ZPlanApiImpl.this.engineHotReady = false;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$i", "Lwg3/b$a;", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IZPlanApi.c f331348a;

        i(IZPlanApi.c cVar) {
            this.f331348a = cVar;
        }

        @Override // wg3.b.a
        public void a(boolean isSuccess, int errorCode, String errorMessage) {
            QLog.i(ZPlanApiImpl.TAG, 1, "preload diffPatch so, res = " + isSuccess + ", errorCode = " + errorCode + ", errorMessage " + errorMessage);
            IZPlanApi.c cVar = this.f331348a;
            if (cVar != null) {
                cVar.onLoaded(isSuccess, errorCode, errorMessage);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$j", "Lcom/tencent/zplan/engine/c;", "", "success", "", "startEngineState", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class j implements com.tencent.zplan.engine.c {
        j() {
        }

        @Override // com.tencent.zplan.engine.c
        public void a(boolean success, int startEngineState) {
            ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
            boolean O = zPlanFeatureSwitch.O();
            QLog.i(ZPlanApiImpl.TAG, 1, "preloadZPlanEngine onStartEngineResult success: " + success + ", enablePreloadWorld: " + O);
            if (O) {
                ZPlanServiceHelper.I.A0(zPlanFeatureSwitch.G2());
            }
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$k", "Lcom/tencent/zplan/resource/api/a;", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "", "c", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "", "errorMessage", "totalTaskCount", "failedTaskCount", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class k implements com.tencent.zplan.resource.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f331349a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f331350b;

        k(long j3, String str) {
            this.f331349a = j3;
            this.f331350b = str;
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData businessData, cy4.c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            QLog.i(ZPlanApiImpl.TAG, 1, "preloadZPlanSuit download success, costTime= " + (System.currentTimeMillis() - this.f331349a) + " , isZPlanUser = " + businessData.getIsZPlanUser() + ", avatarInfo = " + businessData.a());
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(this.f331350b, "1");
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(errType, "errType");
            QLog.e(ZPlanApiImpl.TAG, 1, "preloadZPlanSuit download error, costTime= " + (System.currentTimeMillis() - this.f331349a) + ", errorCode= " + errorCode + ", errorMessage= " + errorMessage + ", totalTaskCount= " + totalTaskCount + ", failedTaskCount= " + failedTaskCount);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float f16, int i3, int i16) {
            a.C10071a.a(this, f16, i3, i16);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$l", "Ljj3/a;", "", "result", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class l implements jj3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f331351a;

        /* JADX WARN: Multi-variable type inference failed */
        l(Function1<? super Boolean, Unit> function1) {
            this.f331351a = function1;
        }

        @Override // jj3.a
        public void onResult(boolean result) {
            this.f331351a.invoke(Boolean.valueOf(result));
        }
    }

    public ZPlanApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanLogSpanEndProcessor>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$logSpanEndProcessor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanLogSpanEndProcessor invoke() {
                return new ZPlanLogSpanEndProcessor();
            }
        });
        this.logSpanEndProcessor$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanReportSpanEndProcessor>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$reportSpanEndProcessor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanReportSpanEndProcessor invoke() {
                return new ZPlanReportSpanEndProcessor();
            }
        });
        this.reportSpanEndProcessor$delegate = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callLuaEngineFinish(Context context) {
        setGraphicsQualityLuaCall(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkZPlanAvatarUpdate$lambda$14(ZPlanApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "checkZPlanAvatarUpdate Task begin");
        AppInterface appInterface = this$0.getAppInterface();
        Manager manager = appInterface != null ? appInterface.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER) : null;
        ZPlanEditAvatarManager zPlanEditAvatarManager = manager instanceof ZPlanEditAvatarManager ? (ZPlanEditAvatarManager) manager : null;
        if (zPlanEditAvatarManager != null) {
            zPlanEditAvatarManager.J0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCache$lambda$7() {
        FileUtils.deleteDirectory(MessageForZPlan.ZPlanPicDownloadInfo.INSTANCE.c());
    }

    private final String decompressGzip(String input) {
        Base64.Decoder decoder;
        byte[] inputData;
        BufferedReader bufferedReader;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        Charset charset = Charset.forName("UTF-8");
        decoder = Base64.getDecoder();
        inputData = decoder.decode(input);
        Intrinsics.checkNotNullExpressionValue(inputData, "inputData");
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(inputData));
        try {
            Intrinsics.checkNotNullExpressionValue(charset, "charset");
            Reader inputStreamReader = new InputStreamReader(gZIPInputStream, charset);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            }
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                CloseableKt.closeFinally(gZIPInputStream, null);
                return readText;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnClearSystemCache$lambda$16() {
        ArrayList arrayListOf;
        FileDownloadManager fileDownloadManager = FileDownloadManager.f328148a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(am.f335779a.a());
        fileDownloadManager.k(arrayListOf);
    }

    private final ZPlanLogSpanEndProcessor getLogSpanEndProcessor() {
        return (ZPlanLogSpanEndProcessor) this.logSpanEndProcessor$delegate.getValue();
    }

    private final ZPlanReportSpanEndProcessor getReportSpanEndProcessor() {
        return (ZPlanReportSpanEndProcessor) this.reportSpanEndProcessor$delegate.getValue();
    }

    private final void initFilamentLog() {
        d dVar = new d();
        FLog.INSTANCE.init(dVar);
        bl0.a.f28591a.a(dVar);
    }

    private final void initZPlanDeviceLevelConfig() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.initZPlanDeviceLevelConfig$lambda$4();
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initZPlanDeviceLevelConfig$lambda$4() {
        com.tencent.zplan.device.config.a aVar = com.tencent.zplan.device.config.a.f385299b;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        aVar.b(context);
    }

    private final void initZPlanMasterSettingConfig() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.s
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.zplan.setting.c.e();
            }
        }, 64, null, false);
    }

    private final void initZPlanTracing() {
        boolean enableOpenTelemetryReport = ZPlanQQMC.INSTANCE.enableOpenTelemetryReport();
        ZPlanSpanFactory zPlanSpanFactory = ZPlanSpanFactory.INSTANCE;
        zPlanSpanFactory.setSpanEnable(enableOpenTelemetryReport);
        if (enableOpenTelemetryReport) {
            zPlanSpanFactory.registerZPlanSpanEndProcessor(getLogSpanEndProcessor());
            zPlanSpanFactory.registerZPlanSpanEndProcessor(getReportSpanEndProcessor());
        }
    }

    private final void observeUserAppearanceKeyChange() {
        QLog.i(TAG, 1, "observeUserAppearanceKeyChange " + this.mAppearanceKeyChangeObserver);
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.addObserver(this.mAppearanceKeyChangeObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pauseRecordQueueAfterEnterBackground$lambda$19() {
        if (t74.s.f435588a.a()) {
            return;
        }
        QLog.i(TAG, 1, "still running background, toggleQueuePauseState true");
        MemeHelper.INSTANCE.toggleQueuePauseState(true, "QQEnterBackground");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preRequestMiniHomeFlag$lambda$33(long j3) {
        ((IVasZplanAIOSmallHomeService) QRoute.api(IVasZplanAIOSmallHomeService.class)).requestEntranceInfoV2(j3, new Function1<com.tencent.mobileqq.vas.data.h, Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$preRequestMiniHomeFlag$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.vas.data.h hVar) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.vas.data.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadZPlanSuitIfNeed$lambda$10() {
        List<ZPlanUserAvatarInfoReq> list;
        QLog.i(TAG, 1, "preloadZPlanSuitIfNeed, trigger");
        AppRuntime d16 = bb.f335811a.d();
        long longAccountUin = d16 != null ? d16.getLongAccountUin() : 0L;
        if (!uk3.g.f439121a.i()) {
            QLog.e(TAG, 1, "preloadZPlanSuitIfNeed, isZplanEnable=false");
            return;
        }
        String str = longAccountUin + "_zplan_get_suit_flag" + ab.INSTANCE.b();
        if (!TextUtils.isEmpty(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(str, ""))) {
            QLog.i(TAG, 1, "preloadZPlanSuitIfNeed, not first time");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bk3.a aVar = (bk3.a) vb3.a.f441346a.a(bk3.a.class);
        list = ArraysKt___ArraysKt.toList(new ZPlanUserAvatarInfoReq[]{new ZPlanUserAvatarInfoReq(String.valueOf(longAccountUin), null, null, null, 14, null)});
        aVar.l(list, new k(currentTimeMillis, str));
    }

    private final void prepareSelfZPlanInfo() {
        List<String> listOf;
        QQAppInterface l3 = bb.f335811a.l();
        if (l3 != null) {
            String currentUin = l3.getCurrentUin();
            ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(currentUin);
            zPlanEmoticonUtil.X(listOf, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$prepareSelfZPlanInfo$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QLog.i(ZPlanApiImpl.TAG, 1, "prepareSelfZPlanInfo, done");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareZPlanEnv$lambda$2(int i3, LoadExtResult loadExtResult) {
        QLog.i(TAG, 1, "prepare SharpP so, result: " + loadExtResult + ", version: " + loadExtResult.getVer());
    }

    private final void refreshZPlanDressInfo() {
        com.tencent.sqshow.dresskey.b.f369818a.t("login", false);
    }

    private final void reportPreloadEngine(String source) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long lastZPlanUsingTimeStamp = getLastZPlanUsingTimeStamp();
        long currentTimeMillis = lastZPlanUsingTimeStamp > 0 ? System.currentTimeMillis() - lastZPlanUsingTimeStamp : 0L;
        linkedHashMap.put("zplan_preload_from", source);
        linkedHashMap.put("zplan_duration_from_last_use", String.valueOf(currentTimeMillis));
        t74.r.e(null, "zplan_preload", linkedHashMap, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetZPlanEnvOnSSOChange$lambda$15(ZPlanApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearRecordCache();
        FileUtils.deleteDirectory(ZPlanConstant.f386195f.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveLastZPlanUsingTimeStamp$lambda$32(long j3) {
        AppRuntime d16 = bb.f335811a.d();
        String currentUin = d16 != null ? d16.getCurrentUin() : null;
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(currentUin + "_zplan_using_timestamp", j3);
    }

    private final void showSmallHomeTransitPanel(Context context, TransitPageInfo info, ZootopiaSource source) {
        QLog.i(TAG, 1, "showSmallHomeTransitPanel");
        if (!TransitPageInfo.INSTANCE.a(info)) {
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xhl, "invalid pageInfo");
            QLog.e(TAG, 1, "invalid pageInfo");
        } else {
            ZPlanSmallHomeGuideTransitFragment.INSTANCE.a(context, info, null, source);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStatusTip$lambda$9(long j3, final Activity activity) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        String C2 = ZPlanFeatureSwitch.f369852a.C2();
        if (j3 > 0) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) C2, (CharSequence) String.valueOf(j3), false, 2, (Object) null);
            if (!contains$default) {
                AppRuntime d16 = bb.f335811a.d();
                long longAccountUin = d16 != null ? d16.getLongAccountUin() : 0L;
                if (!TextUtils.isEmpty(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(longAccountUin + "_zplan_status_tip", ""))) {
                    QLog.i(TAG, 1, "showStatusTip, has already show");
                    return;
                }
                if (!AbiUtil.isArm64Runtime(BaseApplicationImpl.getApplication())) {
                    QLog.w(TAG, 1, "showStatusTip, not arm64");
                    return;
                }
                af afVar = af.f335758a;
                boolean e16 = afVar.e(Constant.FROM_ID_UNINSTALL_PLUGIN, longAccountUin);
                boolean e17 = afVar.e(1004L, longAccountUin);
                if (!e16 && !e17) {
                    QLog.i(TAG, 1, "showStatusTip, switch off, isQzoneEnable=" + e16 + ", isAvatarEnable=" + e17);
                    return;
                }
                if (activity.isFinishing()) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanApiImpl.showStatusTip$lambda$9$lambda$8(activity);
                    }
                });
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(longAccountUin + "_zplan_status_tip", "1");
                return;
            }
        }
        QLog.w(TAG, 1, "showStatusTip, not support status id=" + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showStatusTip$lambda$9$lambda$8(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        try {
            new hl3.a(activity).show();
            QLog.i(TAG, 1, "showStatusTip, success");
        } catch (Exception e16) {
            QLog.i(TAG, 1, "showStatusTip, error", e16);
        }
    }

    private final void startZPlanEngine(final WeakReference<com.tencent.zplan.engine.c> zPlanStartEngineListener, final String from) {
        com.tencent.zplan.engine.c cVar;
        if (!t74.h.b()) {
            QLog.e(TAG, 1, "startZPlanEngine, is not main process, return.");
            if (zPlanStartEngineListener == null || (cVar = zPlanStartEngineListener.get()) == null) {
                return;
            }
            c.a.a(cVar, false, 0, 2, null);
            return;
        }
        int zPlanStartStatus = getZPlanStartStatus();
        com.tencent.mobileqq.perf.report.a.f258014c = zPlanStartStatus;
        QLog.i(TAG, 1, "startZPlanEngine, status=" + zPlanStartStatus, new StackPrinter(""));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.startZPlanEngine$lambda$1(WeakReference.this, from);
            }
        });
        ad.f335757a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startZPlanEngine$lambda$1(final WeakReference weakReference, final String from) {
        Intrinsics.checkNotNullParameter(from, "$from");
        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.startZPlanEngine$lambda$1$lambda$0(WeakReference.this, from);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startZPlanEngine$lambda$1$lambda$0(WeakReference weakReference, String from) {
        Intrinsics.checkNotNullParameter(from, "$from");
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        zPlanServiceHelper.X0(application, weakReference, from);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void addPicToCustomEmoticonFromPeak(String path, Function1<? super Boolean, Unit> onResult) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ((jj3.b) k74.i.INSTANCE.a(jj3.b.class)).addPicToCustomEmoticon(path, new c(onResult));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String appendPageDataToScheme(String schemeUrl, Bundle bundle) {
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return ((ISchemeApi) QRoute.api(ISchemeApi.class)).appendPageDataToScheme(schemeUrl, bundle);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void checkUEBsResource(String fromSource, ji3.n nVar) {
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        ZPlanSameStyleResHelper.f372974a.k(fromSource, nVar);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void checkUe4So() {
        QLog.i(TAG, 1, "checkUe4So, " + Log.getStackTraceString(new Throwable()));
        ad.f335757a.b();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void cleanZPlanCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return;
        }
        String str = externalFilesDir.getPath() + File.separator + "ZplanDownload";
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "cleanZPlanCache, filePath is null");
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            n0.a.g(file);
        }
        ZPlanAvatarShpImageCacheManager.INSTANCE.a().clearCache();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void clearCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.clearCache$lambda$7();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void clearMMKVCacheWhenLogout() {
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            long longAccountUin = d16.getLongAccountUin();
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove("ZPLAN_CHECK_IN_PACKAGE_" + longAccountUin);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void clearRecordCache() {
        ZPlanRecordResourceCenter.f386003a.a();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public com.tencent.mobileqq.zplan.avatar.b createAvatarEditDaTongReporter() {
        return new ZPlanAvatarEditDaTongReport();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public <T extends ViewModelStoreOwner & LifecycleOwner, K extends ViewModel> com.tencent.mobileqq.zplan.meme.frameanim.e createAvatarLoadingViewHelper(LayoutInflater inflater, T lifecycleSpan, Class<K> viewModelClass) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(lifecycleSpan, "lifecycleSpan");
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        return new ZPlanAvatarOverlayViewWiringHelper(inflater, lifecycleSpan, viewModelClass);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public com.tencent.mobileqq.zplan.easteregg.u createEasterEggDaTongReporter() {
        return new EasterEggDaTongReport();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public com.tencent.mobileqq.zplan.meme.frameanim.a createZPlanAvatarBannerManager(Context context, FrameLayout zPlanBannerLayout, ImageView avatarIV, FrameLayout backgroundContainer, ZPlanAvatarBannerParams param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(zPlanBannerLayout, "zPlanBannerLayout");
        Intrinsics.checkNotNullParameter(avatarIV, "avatarIV");
        Intrinsics.checkNotNullParameter(backgroundContainer, "backgroundContainer");
        Intrinsics.checkNotNullParameter(param, "param");
        return new ZPlanAvatarBannerManager(context, zPlanBannerLayout, avatarIV, backgroundContainer, param);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public com.tencent.mobileqq.zplan.easteregg.w createZPlanAvatarEasterEggManager() {
        return new EasterEggPlayerManager();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public AppRuntime createZplanAppInterface(MobileQQ app, String procname) {
        if (app instanceof BaseApplicationImpl) {
            return new ZPlanAppInterface((BaseApplicationImpl) app, procname);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void doOnClearSystemCache() {
        QLog.i(TAG, 1, "doOnClearSystemCache!!");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.n
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.doOnClearSystemCache$lambda$16();
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean enableFilamentRecordCloudCache(ZPlanRecordScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return ZPlanQQMC.INSTANCE.enableFilamentRecordCloudCache(scene);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean enableFilamentRecordResultUpload(ZPlanRecordScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return ZPlanQQMC.INSTANCE.enableFilamentRecordResultUpload(scene);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean enableMiniHome(int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return peekAppRuntime != null && ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1012L, peekAppRuntime.getLongAccountUin()) && ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(i3) && ZPlanQQMC.INSTANCE.enableMiniHome() && StudyModeManager.t();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean enablePortalPlanarShadow() {
        wk3.i iVar = (wk3.i) ZPlanQQMC.INSTANCE.getConfig("100195", wk3.i.class, "");
        if (iVar == null) {
            iVar = new wk3.i();
        }
        return iVar.getEnableFilamentPortalShadow();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void enterAvatarScene(dy4.a zplanRender, int sceneType, String sceneParams, IZPlanWorldStatusListener listener) {
        Intrinsics.checkNotNullParameter(zplanRender, "zplanRender");
        com.tencent.mobileqq.zootopia.utils.n.INSTANCE.a(zplanRender, sceneType, sceneParams, listener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String generateXWConnectScheme(String referer, String str, String str2, boolean z16, String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(referer, "referer");
        Bundle bundle = new Bundle();
        bundle.putString(ISchemeApi.KEY_REFERER, referer);
        if (str != null) {
            bundle.putString("subReferer", str);
        }
        if (str2 != null) {
            bundle.putString("uin", str2);
        }
        if (z16) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        bundle.putString("mode", str4);
        if (str3 != null) {
            bundle.putString(ISchemeApi.KEY_PAGE_DATA, URLEncoder.encode(str3, "UTF-8"));
        }
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        String str5 = "mqqapi://zplan/openHomeConnected?src_type=app&version=1.0&sceneType=100";
        for (String str6 : keySet) {
            str5 = ((Object) str5) + ContainerUtils.FIELD_DELIMITER + str6 + ContainerUtils.KEY_VALUE_DELIMITER + bundle.get(str6);
        }
        return str5;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public Activity getActivityFromContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return bb.f335811a.b(context);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public AppInterface getAppInterface() {
        return bb.f335811a.c();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getAppearanceKeyFromMMKV(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(uin + "_zplan_user_appearance_key", "");
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getAvatarLocalUrlWithUin(String theme, String uin) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZPlanAvatarImageManager.INSTANCE.a().L(theme, uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public float getAvaterWindowsillLocationWithUin(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZPlanAvatarImageManager.INSTANCE.a().M(uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getCurrentUin() {
        return bb.f335811a.e();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getDynamicAvatarAppearanceKey(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZPlanAvatarImageManager.INSTANCE.a().S(uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getDynamicAvatarProperty(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZPlanAvatarImageManager.INSTANCE.a().T(uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getDynamicAvatarUrl(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZPlanAvatarImageManager.INSTANCE.a().U(uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public List<Integer> getEasterEggAllConfigPortraitId() {
        ArrayList arrayList = new ArrayList();
        Collection<com.tencent.mobileqq.zplan.easteregg.a> values = EasterEggPagConfigRepo.f332820a.o().values();
        Intrinsics.checkNotNullExpressionValue(values, "EasterEggPagConfigRepo.getConfig().values");
        for (com.tencent.mobileqq.zplan.easteregg.a aVar : values) {
            if (!arrayList.contains(Integer.valueOf(aVar.getPortraitID()))) {
                arrayList.add(Integer.valueOf(aVar.getPortraitID()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void getEasterEggPortraitResource(com.tencent.mobileqq.zplan.easteregg.model.d param, com.tencent.mobileqq.zplan.easteregg.t listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        new EasterEggPortraitResourceManager().a(param, listener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public List<Integer> getEasterEggPreRecordPortraitId() {
        ArrayList arrayList = new ArrayList();
        Collection<com.tencent.mobileqq.zplan.easteregg.a> values = EasterEggPagConfigRepo.f332820a.o().values();
        Intrinsics.checkNotNullExpressionValue(values, "EasterEggPagConfigRepo.getConfig().values");
        for (com.tencent.mobileqq.zplan.easteregg.a aVar : values) {
            if (aVar.getEnablePrerecord()) {
                arrayList.add(Integer.valueOf(aVar.getPortraitID()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getEmoticonGrayTipsCreateRoleScheme(String str) {
        return updateSchemeURLWithUin(ZPlanQQMC.INSTANCE.getZPlanEmoticonGrayTipsConfig().getCreateRoleScheme(), str);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public long getLastZPlanUsingTimeStamp() {
        AppRuntime d16 = bb.f335811a.d();
        String currentUin = d16 != null ? d16.getCurrentUin() : null;
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getLong(currentUin + "_zplan_using_timestamp", 0L);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public ZPlanMaintInfo getMaintenanceInfo(MaintEntryType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return ZPlanMaintInfoRepo.f333853a.b(type);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0074 A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.zplan.easteregg.a getMatchKeywordEasterEggConfig(String str, int i3) {
        HashSet<String> r16;
        boolean z16;
        boolean contains;
        boolean z17;
        boolean contains2;
        ConcurrentHashMap<String, com.tencent.mobileqq.zplan.easteregg.a> o16 = EasterEggPagConfigRepo.f332820a.o();
        com.tencent.mobileqq.zplan.easteregg.a aVar = null;
        for (String pagConfigKey : o16.keySet()) {
            com.tencent.mobileqq.zplan.easteregg.a aVar2 = o16.get(pagConfigKey);
            if (aVar2 != null) {
                if (aVar2.getPriority() > (aVar != null ? aVar.getPriority() : 0) && (r16 = aVar2.r()) != null && (!r16.isEmpty() || aVar2.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() != 0)) {
                    if (r16.isEmpty() && aVar2.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() == i3) {
                        Intrinsics.checkNotNullExpressionValue(pagConfigKey, "pagConfigKey");
                        aVar2.H(pagConfigKey);
                        aVar = aVar2;
                    } else if ((!r16.isEmpty()) && aVar2.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() == 0) {
                        Iterator<String> it = r16.iterator();
                        while (it.hasNext()) {
                            String keyword = it.next();
                            if (str != null) {
                                Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                                contains2 = StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) keyword, true);
                                if (contains2) {
                                    z17 = true;
                                    if (!z17) {
                                        Intrinsics.checkNotNullExpressionValue(pagConfigKey, "pagConfigKey");
                                        aVar2.H(pagConfigKey);
                                        aVar = aVar2;
                                    }
                                }
                            }
                            z17 = false;
                            if (!z17) {
                            }
                        }
                    } else if ((!r16.isEmpty()) && aVar2.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() != 0) {
                        Iterator<String> it5 = r16.iterator();
                        while (it5.hasNext()) {
                            String keyword2 = it5.next();
                            if (str != null) {
                                Intrinsics.checkNotNullExpressionValue(keyword2, "keyword");
                                contains = StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) keyword2, true);
                                if (contains) {
                                    z16 = true;
                                    if (z16 && aVar2.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() == i3) {
                                        Intrinsics.checkNotNullExpressionValue(pagConfigKey, "pagConfigKey");
                                        aVar2.H(pagConfigKey);
                                        aVar = aVar2;
                                    }
                                }
                            }
                            z16 = false;
                            if (z16) {
                                Intrinsics.checkNotNullExpressionValue(pagConfigKey, "pagConfigKey");
                                aVar2.H(pagConfigKey);
                                aVar = aVar2;
                            }
                        }
                    }
                }
            }
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean getMiniHomeRewardGiftBubbleMMKV() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("zplan_mini_home_reward_gift_bubble_shown", false);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public List<Source> getRecordSourceWhenUsingFilament(ZPlanRecordScene scene) {
        List<Source> listOf;
        List<Source> listOf2;
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!(getTargetEngineForRecord(scene) instanceof EngineType.Filament) || ZPlanQQMC.INSTANCE.enableFilamentRecordCloudCache(scene)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.CLOUD_CACHE, Source.LOCAL_RECORD});
            return listOf;
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.LOCAL_RECORD});
        return listOf2;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getSSOServerEnvName() {
        return v84.a.a();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getStaticDefaultUrlFromConfig(String gender, String theme) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(theme, "theme");
        return bb.f335811a.m(gender, theme);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public int getStatusPortraitIdByUin(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        bb bbVar = bb.f335811a;
        return bbVar.i(bbVar.g(uin));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public SurfaceTexture getSurfaceTexture() {
        return ZPlanServiceHelper.I.d0();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public EngineType getTargetEngineForRecord(ZPlanRecordScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (ZPlanQQMC.INSTANCE.enableFilamentRecord(scene) && FilamentApiImpl.f369933a.d()) {
            return new EngineType.Filament(FilamentNativeAppRecorder.class);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public JSONObject getTofuJSONFromExtra(String busiExtra) {
        Intrinsics.checkNotNullParameter(busiExtra, "busiExtra");
        return com.tencent.zplan.common.utils.h.f385294a.b(decompressGzip(busiExtra));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public Activity getTopActivity() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            return topActivity;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity instanceof Activity) {
            return qBaseActivity;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public EGLContext getUEAndroidContext() {
        EGLContext currentEglContext = UE4.getCurrentEglContext();
        if (currentEglContext == null) {
            return null;
        }
        return currentEglContext;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public javax.microedition.khronos.egl.EGLContext getUEContext() {
        javax.microedition.khronos.egl.EGLContext currentContext = UE4.getCurrentContext();
        if (currentContext != null) {
            return currentContext;
        }
        javax.microedition.khronos.egl.EGLContext EGL_NO_CONTEXT = EGL10.EGL_NO_CONTEXT;
        Intrinsics.checkNotNullExpressionValue(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        return EGL_NO_CONTEXT;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getZPlanAvatarImagePath(String theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        return ZPlanAvatarImageManager.INSTANCE.a().K(theme);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getZPlanAvatarImagePathWithUin(String theme, String uin) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZPlanAvatarImageManager.INSTANCE.a().X(theme, uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public URL getZPlanDefaultAvatarURL(int i3, String theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        return ZPlanAvatarImageManager.INSTANCE.a().O(i3, theme);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean getZPlanEditAvatarFlag(AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        return ZPlanEditAvatarUtils.f331613a.X(app);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public JSONObject getZPlanEmoticonGrayTipsMMKV() {
        AppRuntime d16 = bb.f335811a.d();
        if (d16 == null) {
            return null;
        }
        long longAccountUin = d16.getLongAccountUin();
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString("zplan_emoticon_gray_tips_" + longAccountUin, "");
        if (string.length() == 0) {
            return new JSONObject();
        }
        try {
            return new JSONObject(string);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public int getZPlanGender() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return bb.f335811a.o(peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public int getZPlanGenderWithUin(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return bb.f335811a.o(uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public int getZPlanStartStatus() {
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        if (zPlanFeatureSwitch.O()) {
            return 2;
        }
        return zPlanFeatureSwitch.f3() ? 1 : 0;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getZPlanStaticAvatarKey(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZPlanAvatarImageManager.INSTANCE.a().Y(uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public NormalRenderTextureView getZPlanTextureView(Context context, boolean needTouch, boolean opaque) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NormalRenderTextureView(context, needTouch, opaque);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public INTZPlanAvatarView getZPlanTofuAvatarView(Context context, JSONObject avatarCharacter, com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        Intrinsics.checkNotNullParameter(iNTAvatarStatusViewCb, "iNTAvatarStatusViewCb");
        return new TofuAvatarLayout(context, avatarCharacter, iNTAvatarStatusViewCb, null, 0, 24, null);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String getZPlanVersion() {
        return ZPlanVersion.ZPlanVersion;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void hDiffPatch(String oldFilePath, String diffFilePath, String outFilePath, final ji3.b listener) {
        Intrinsics.checkNotNullParameter(oldFilePath, "oldFilePath");
        Intrinsics.checkNotNullParameter(diffFilePath, "diffFilePath");
        Intrinsics.checkNotNullParameter(outFilePath, "outFilePath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        wg3.b.f445625a.b(oldFilePath, diffFilePath, outFilePath, new Function2<Boolean, b.C11482b, Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$hDiffPatch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, b.C11482b c11482b) {
                invoke(bool.booleanValue(), c11482b);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, b.C11482b params) {
                Intrinsics.checkNotNullParameter(params, "params");
                if (z16) {
                    ji3.b.this.onSuccess(params.getPatchCostTime());
                } else {
                    ji3.b.this.onFail(params.getErrorCode(), params.getErrorMessage());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void handleToast(Context context, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).handleToastScheme(context, params);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean handleZPlanEnterAvatarSceneScheme(Context context, String url, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "handleZPlanEnterAvatarSceneScheme, url:" + url);
        if (!FilamentApiImpl.f369933a.d()) {
            IZPlanApi.b.c(this, null, ZPlanPublishSource.FROM_SCHEME, 1, null);
        }
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).handleEnterAvatarScheme(context, url, params);
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean handleZPlanOpenPageScheme(Context context, String url, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "handleZPlanOpenPageScheme " + url + ", " + Log.getStackTraceString(new Throwable()));
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).handleOpenPageScheme(context, url, params);
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void handleZplanThirdScheme(Context context, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).handleZplanThirdScheme(context, params);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isBigScreen() {
        return bb.f335811a.p();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void isDeviceAdaptiveForMod(int i3, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CheckPhoneManager.f331491a.h(i3, CheckPhoneManager.EntryType.MOD, new e(callback));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isDrawerEntranceSwitchOpen() {
        if (!com.tencent.mobileqq.zplan.setting.c.e()) {
            QLog.i(TAG, 4, "isDrawerEntranceEnable master false");
            return false;
        }
        if (com.tencent.mobileqq.zplan.setting.c.b()) {
            return true;
        }
        QLog.i(TAG, 4, "isDrawerEntranceEnable drawer false");
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isEmoticonPicRecorded(int i3, String selfUin, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return RecommendUtil.f333314a.e(i3, selfUin, jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isEngineHotReady() {
        return this.engineHotReady;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isEngineReady() {
        return ZPlanServiceHelper.I.l0();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isFilamentEnabled() {
        return ((IZootopiaPortalFilamentConfigHelper) QRoute.api(IZootopiaPortalFilamentConfigHelper.class)).enableFilament();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isNetworkAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.biz.common.util.g.b(context);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isQzoneEntranceEnabled(long uin) {
        boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_UNINSTALL_PLUGIN, uin);
        boolean f16 = QQSettingMeABTestHelper.e().f();
        boolean enableZPlanNativeAppFilament = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(0);
        QLog.i(TAG, 4, "isQzoneEntranceEnabled dynamicSceneEnable: " + isZPlanAccessible + ", isQQSettingMeDisableLebaZPlan: " + f16 + ",mEnableZPlanNativeAppFilament: " + enableZPlanNativeAppFilament);
        return isZPlanAccessible && !f16 && enableZPlanNativeAppFilament;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isUEBsResourceReady() {
        return ZPlanSameStyleResHelper.f372974a.p();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isZPlanAvatarSettingEnable() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return peekAppRuntime != null && com.tencent.relation.common.config.toggle.c.D.g(false) && ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, peekAppRuntime.getLongAccountUin());
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean isZPlanMessage(MessageRecord messageRecord) {
        return messageRecord instanceof MessageForZPlan;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void jumpToSplash() {
        Intent aliasIntent = SplashActivity.getAliasIntent(BaseApplication.getContext());
        aliasIntent.addFlags(335544320);
        BaseApplication.getContext().startActivity(aliasIntent);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void killZPlanProcess(String desc, boolean shouldCheckFloat, int sceneType) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        com.tencent.mobileqq.zootopia.utils.n.INSTANCE.b(desc, shouldCheckFloat, sceneType);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean launchScheme(Context context, String schemeUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        return launchSchemeWithContext(context, schemeUrl);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean launchSchemeWithContext(final Context context, String schemeUrl) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        schemeUrl.length();
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(schemeUrl, "https://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(schemeUrl, "http://", false, 2, null);
            if (!startsWith$default2) {
                return ((com.tencent.mobileqq.zootopia.ipc.ad) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.ad.class)).launchScheme(schemeUrl, context);
            }
        }
        final Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("url", schemeUrl);
        if (com.tencent.mobileqq.zplan.utils.ab.c(schemeUrl) && com.tencent.mobileqq.zplan.utils.ab.d(schemeUrl)) {
            com.tencent.mobileqq.zplan.utils.ab.a(context, com.tencent.mobileqq.zplan.utils.ab.b(schemeUrl), new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$launchSchemeWithContext$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    context.startActivity(intent);
                }
            });
            return false;
        }
        context.startActivity(intent);
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean miniHomeQQMCSwitchOn() {
        return ZPlanQQMC.INSTANCE.enableMiniHome();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void notifyAppearanceKeyChange(String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        ZPlanMemeIPCImpl.INSTANCE.a(param);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void openSmallHomeGuidePageFromQav(Context context, String str, String str2, String str3, ZootopiaSource source, boolean z16, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "openSmallHomeGuidePageFromQav targetUin: " + str + " currentUin: " + str2 + " nickName: " + str3 + " isNeedTransit: " + z16 + " connectedTime: " + j3);
        }
        if (str != null) {
            MasterInfo masterInfo = new MasterInfo();
            masterInfo.setUin(str);
            masterInfo.setNickName(str3);
            VisitorInfo visitorInfo = new VisitorInfo();
            visitorInfo.setUin(str2);
            TransitPageConfig transitPageConfig = new TransitPageConfig();
            transitPageConfig.setSinglePageMode(true);
            transitPageConfig.setNeedTransitPageWhenReady(z16 ? 1 : 0);
            ExtInfo extInfo = new ExtInfo();
            extInfo.setUeExtras(new HashMap<>());
            HashMap<String, Object> ueExtras = extInfo.getUeExtras();
            Intrinsics.checkNotNull(ueExtras);
            ueExtras.put("FromScene", 1);
            Long valueOf = Long.valueOf(j3);
            HashMap<String, Object> ueExtras2 = extInfo.getUeExtras();
            Intrinsics.checkNotNull(ueExtras2);
            ueExtras2.put("conectedTime", valueOf);
            if (context != null) {
                openSmallHomeGuideTransitPage(context, new TransitPageInfo(masterInfo, visitorInfo, transitPageConfig, extInfo), source);
            }
        }
    }

    public final void openSmallHomeGuideTransitPage(final Context context, final TransitPageInfo info, final ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i(TAG, 1, "visitSmallHome");
        IVasZplanApi iVasZplanApi = (IVasZplanApi) QRoute.api(IVasZplanApi.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(200001L);
        iVasZplanApi.addWhiteList(arrayList, "smallHome");
        ZplanVasSmallHomeUtils.f311238a.e(context, info, source, new Function2<Boolean, MapStatus, Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$openSmallHomeGuideTransitPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, MapStatus mapStatus) {
                invoke(bool.booleanValue(), mapStatus);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, MapStatus mapStatus) {
                Intrinsics.checkNotNullParameter(mapStatus, "mapStatus");
                if (z16) {
                    ZPlanApiImpl.this.checkResidenceAuth(context, mapStatus, info, source);
                } else {
                    com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xve, "checkResidenceWhiteList false");
                    QLog.e(ZPlanApiImpl.TAG, 1, "checkResidenceWhiteList result is false");
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void openZPlanAvatarPicEditPage(Context context, String source, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intent intent = new Intent();
        intent.putExtra("intent_source", source);
        if (!(str == null || str.length() == 0) && Intrinsics.areEqual(str, "1")) {
            intent.setFlags(268435456);
        }
        ZPlanAvatarPicEditFragment.Qj(context, intent);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void openZPlanAvatarPicEditPageWithWhiteListCheck(Context context, String source, String backupUrl, String enableNewTask) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(backupUrl, "backupUrl");
        Intrinsics.checkNotNullParameter(enableNewTask, "enableNewTask");
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable()) {
            openZPlanAvatarPicEditPage(context, source, enableNewTask);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", backupUrl);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void openZPlanEmoticonPanel(Object baseChatPie, String from) {
        Intrinsics.checkNotNullParameter(baseChatPie, "baseChatPie");
        Intrinsics.checkNotNullParameter(from, "from");
        if (baseChatPie instanceof a61.c) {
            QLog.w(TAG, 1, "openZPlanEmoticonPanel, from:" + from);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void pauseEngine() {
        ZPlanServiceHelper.I.x0();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void pausePlaySharpPForReport() {
        ZPlanEmoticonReport.f333324a.m();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void preloadHDiffPatchSo(IZPlanApi.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        wg3.b.f445625a.c(new i(listener));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void preloadZPlanEngine(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        boolean g36 = zPlanFeatureSwitch.g3();
        boolean h36 = zPlanFeatureSwitch.h3();
        QLog.i(TAG, 1, "preloadZPlanEngine startZPlanEngine, preloadProcessEnable: " + g36 + ", preloadEnable : " + h36);
        if (g36) {
            startZPlanEngine(new WeakReference<>(this.preloadStartEngineListener), "preload");
        }
        if (h36) {
            startZPlanEngine(new WeakReference<>(this.preloadStartEngineListener), "preload_force");
        }
        if (g36 || h36) {
            reportPreloadEngine(source);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void preloadZPlanSuitIfNeed(AppInterface app, long j3) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (!ZPlanFeatureSwitch.f369852a.k0()) {
            QLog.e(TAG, 1, "preloadZPlanSuitIfNeed, disabled");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanApiImpl.preloadZPlanSuitIfNeed$lambda$10();
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void prepareZPlanConfig(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i(TAG, 1, "prepareZPlanConfig");
        j71.a.b(app);
        j71.a.c(app, false);
        initFilamentLog();
        initZPlanTracing();
        FilamentFeatureUtil filamentFeatureUtil = FilamentFeatureUtil.f106409g;
        prepareSelfZPlanInfo();
        ZplanAccoutReceiver.f373102a.b();
        refreshZPlanDressInfo();
        ZPlanPreRecordManager.f334206e.h();
        ZPlanServiceHelper.I.E0(this.mZPlanEngineStatusUpdateListener);
        ZplanDataRepository.f334898a.u(app);
        QRoute.api(IZPlanCoupleSceneHelper.class);
        ZPlanCoupleProfileDataProcessor.f332677a.c();
        ZPlanCoupleBubbleDataManager.f332649a.k();
        ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).requestAIOWhiteList();
        initZPlanDeviceLevelConfig();
        initZPlanMasterSettingConfig();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void prepareZPlanEnv(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i(TAG, 1, "prepareZPlanEnv, " + Log.getStackTraceString(new Throwable()));
        initFilamentLog();
        initZPlanTracing();
        ZPlanPreRecordManager.f334206e.h();
        ZPlanAppInterface.Companion companion = ZPlanAppInterface.INSTANCE;
        Context applicationContext = app.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
        companion.e(applicationContext);
        ZPlanServiceHelper.I.E0(this.mZPlanEngineStatusUpdateListener);
        ZplanDataRepository.f334898a.u(app);
        if (ZPlanQQMC.INSTANCE.enableRequestPortalBottomTabsWhenEnter()) {
            ZPlanTabServerDataManager.q(ZPlanTabServerDataManager.f372670a, null, 1, null);
        }
        ZPlanTabServerDataManager.f372670a.o();
        observeUserAppearanceKeyChange();
        prepareSelfZPlanInfo();
        SoLoadManager.getInstance().download("SharpPEnc", new OnLoadListener() { // from class: com.tencent.mobileqq.zplan.api.impl.i
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                ZPlanApiImpl.prepareZPlanEnv$lambda$2(i3, loadExtResult);
            }
        });
        preloadZPlanSuitIfNeed(app, app.getLongAccountUin());
        ZplanAccoutReceiver.f373102a.b();
        refreshZPlanDressInfo();
        if (this.prepared) {
            return;
        }
        this.prepared = true;
        preloadZPlanEngine("doAfterLogin");
        ad.f335757a.b();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void reLoginAfterAccountChanged() {
        ZPlanServiceHelper.I.G("N2L_Login", new JSONObject().toString());
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void recordEmoticonFromRecommend(int i3, String selfUin, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        RecommendUtil.f333314a.g(i3, selfUin, jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void refetchMaintenanceInfoAsync(MaintEntryType type, com.tencent.mobileqq.zplan.model.d dVar) {
        Intrinsics.checkNotNullParameter(type, "type");
        ZPlanMaintInfoRepo.f333853a.d(type, dVar);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public ZPlanMaintInfo refetchMaintenanceInfoSync(MaintEntryType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return ZPlanMaintInfoRepo.f333853a.e(type);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void refreshZPlanEmoticonGrayTipsMMKVIfNeed(MessageRecord messageRecord) {
        com.tencent.mobileqq.graytip.g gVar;
        if (messageRecord == null || !(messageRecord instanceof MessageForUniteGrayTip) || (gVar = ((MessageForUniteGrayTip) messageRecord).tipParam) == null) {
            return;
        }
        Bundle bundle = gVar.f213688k;
        if (Intrinsics.areEqual(bundle != null ? bundle.getString(IPublicAccountImageCollectionMainActivity.CLICK_SOURCE, "") : null, "zplan_emoticon_gray_tip")) {
            try {
                JSONObject zPlanEmoticonGrayTipsMMKV = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanEmoticonGrayTipsMMKV();
                if (zPlanEmoticonGrayTipsMMKV != null) {
                    zPlanEmoticonGrayTipsMMKV.put("has_clicked", true);
                    IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                    String jSONObject = zPlanEmoticonGrayTipsMMKV.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "it.toString()");
                    iZPlanApi.setZPlanEmoticonGrayTipsMMKV(jSONObject);
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "resetZPlanEmoticonMMKVIfNeed failed.", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void registerZPlanEngineStatusUpdateListener(ZPlanEngineStatusUpdateListener statusUpdateListener) {
        Intrinsics.checkNotNullParameter(statusUpdateListener, "statusUpdateListener");
        ZPlanServiceHelper.I.E0(statusUpdateListener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void reportAvatarEditEntranceRedDotData(AppRuntime appRuntime, String itemId, int i3, int i16) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        com.tencent.mobileqq.zplan.avatar.edit.i.f331655a.b(appRuntime, itemId, i3, i16);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void reportToBeacon(String appKey, String eventCode, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        t74.r.d(appKey, eventCode, map);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void requestAvatarEditEntranceRedDotData(Function1<? super String, Unit> callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        com.tencent.mobileqq.zplan.avatar.edit.i.f331655a.c(callBack);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void requestStaticImageUrl() {
        ZPlanAvatarImageManager.INSTANCE.a().c0();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void requestStaticImageUrlWithUin(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZPlanAvatarImageManager.INSTANCE.a().f0(uin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void requireUserZPlanInfo(List<String> uinList, Function0<Unit> onDone) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        ZPlanEmoticonUtil.f333176e.X(uinList, onDone);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void resetZPlanEnvOnSSOChange() {
        QLog.i(TAG, 1, "resetZPlanEnvOnSSOChange!!");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.resetZPlanEnvOnSSOChange$lambda$15(ZPlanApiImpl.this);
            }
        }, 96, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void resumeEngine() {
        ZPlanServiceHelper.M0(ZPlanServiceHelper.I, null, 1, null);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void saveAppearanceKeyToMMKV(String uin, String appearanceKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(uin + "_zplan_user_appearance_key", appearanceKey);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void saveLastZPlanUsingTimeStamp(final long j3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.saveLastZPlanUsingTimeStamp$lambda$32(j3);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void setAvatarFromPeak(String path, Function1<? super Boolean, Unit> onResult) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ((jj3.b) k74.i.INSTANCE.a(jj3.b.class)).setAvatarByPicPath(path, new l(onResult));
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void setMiniHomeRewardGiftBubbleMMKV() {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("zplan_mini_home_reward_gift_bubble_shown", true);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void setOnSettingChangeListener(AppInterface appInterface, long scene, ji3.k listener) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        ZplanDataRepository.f334898a.z(appInterface, scene, listener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void setOnZPlanSettingChangeListener(long scene, ji3.m listener) {
        ZplanDataRepository.f334898a.A(scene, listener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void setOnZplanAccessibleWithoutSettingListener(long scene, ji3.j listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZplanDataRepository.f334898a.C(scene, listener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void setZPlanBackgroundImage(Activity activity, String imgPath) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(imgPath, "imgPath");
        ZPlanBgEditFragment.Vh(activity, imgPath);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void setZPlanEmoticonGrayTipsMMKV(String updatedStatus) {
        Intrinsics.checkNotNullParameter(updatedStatus, "updatedStatus");
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            long longAccountUin = d16.getLongAccountUin();
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_emoticon_gray_tips_" + longAccountUin, updatedStatus);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean showAIOZPlanTofu() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1000L, peekAppRuntime.getLongAccountUin()) && com.tencent.mobileqq.zplan.lite.util.e.j(com.tencent.mobileqq.zplan.lite.util.e.f333809a, null, 1, null) && ZPlanQQMC.INSTANCE.enableAIOTofu();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean showAioZPlanGifLoading() {
        return ZPlanFeatureSwitch.f369852a.v3();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void showOpenVipSuccessDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DialogUtil.createCustomDialog(context, 232, (String) null, HardCodeUtil.qqStr(R.string.msk), (String) null, HardCodeUtil.qqStr(R.string.mss), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.api.impl.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void showStatusTip(final Activity activity, final long j3) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (be.b()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.showStatusTip$lambda$9(j3, activity);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void startAvatarSettingActivity(Context context, String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        Intent intent = new Intent();
        intent.putExtra("FROM", from);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, NewZplanSettingAvatarShowFragment.class);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void startEngineWhenNotReady(WeakReference<com.tencent.zplan.engine.c> callback, String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i(TAG, 1, "startEngineWhenNotReady, mStatusUpdateListener\uff1a" + callback + ", from:" + from);
        startZPlanEngine(callback, from);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void startFriendChooseActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        new com.tencent.mobileqq.zplan.proxy.af().a("sameStyle");
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void startSettingActivity(Context context, String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        Intent intent = new Intent();
        intent.putExtra("FROM", from);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, ZplanSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void startSettingV2Activity(Context context, String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        Intent intent = new Intent();
        intent.putExtra("FROM", from);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, ZplanSettingFragmentV2.class);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void startZPlanBackgroundEdit(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ZPlanBgEditFragment.Wh(activity, intent);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void stopZPlanEngine() {
        if (!t74.h.b()) {
            QLog.e(TAG, 1, "stopZPlanEngine, is not main process, return.", new Exception("\u4e0d\u662f\u5f02\u5e38! stopZPlanEngine stack:"));
            return;
        }
        QLog.i(TAG, 1, "stopZPlanEngine", new Exception("\u4e0d\u662f\u5f02\u5e38! stopZPlanEngine stack:"));
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        zPlanServiceHelper.Y0(application);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void unRegisterZPlanEngineStatusUpdateListener(ZPlanEngineStatusUpdateListener statusUpdateListener) {
        Intrinsics.checkNotNullParameter(statusUpdateListener, "statusUpdateListener");
        ZPlanServiceHelper.I.a1(statusUpdateListener);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void update(String uin, String url, Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.c().n(uin, url, callback);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void updateCheckResultCache(int i3, gw4.f commonCheckResult) {
        Intrinsics.checkNotNullParameter(commonCheckResult, "commonCheckResult");
        CheckPhoneManager.f331491a.r(i3, commonCheckResult);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void updateZPlanSettingQZoneSwitch(boolean z16, ji3.l listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.mobileqq.zplan.utils.y.f335851a.i(z16, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkResidenceAuth(final Context context, final MapStatus mapStatus, final TransitPageInfo info, final ZootopiaSource source) {
        QLog.i(TAG, 1, "checkResidenceAuth");
        String uin = info.getMasterInfo().getUin();
        if (uin == null) {
            return;
        }
        ((IZootopiaResidenceAuthApi) QRoute.api(IZootopiaResidenceAuthApi.class)).checkResidenceVisitAuth(uin, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl$checkResidenceAuth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String str) {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                if (z16) {
                    ZPlanApiImpl.this.handleDownloadStatus(context, mapStatus, info, source);
                } else {
                    ZplanVasSmallHomeUtils.f311238a.j(context, info, source);
                    bb.f335811a.t(false, context);
                }
            }
        });
    }

    private final void setGraphicsQualityLuaCall(Context context) {
        try {
            String a16 = com.tencent.mobileqq.zplan.setting.b.a(context, true);
            if (a16 == null) {
                QLog.d(TAG, 1, "Engine start finish setGraphicsQualityLuaCall sendMsg:null");
                return;
            }
            com.tencent.zplan.luabridge.a S = ZPlanServiceHelper.I.S();
            Intrinsics.checkNotNull(S);
            S.callLua("N2L_SetGraphicsQuality", a16, (a.b) null);
            QLog.d(TAG, 4, "Engine start finish setGraphicsQualityLuaCall:" + a16);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void checkZPlanAvatarUpdate() {
        try {
            if (!this.hasCheckZPlanAvatar && isZPlanAvatarSettingEnable()) {
                String d16 = com.tencent.relation.common.config.toggle.c.D.d("enableAvatarCheck", "0");
                Intrinsics.checkNotNullExpressionValue(d16, "ZPLAN_AVATAR_SETTING_SWI\u2026AVATAR_ENABLE_CHECK, \"0\")");
                if (Integer.parseInt(d16) != 1) {
                    return;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanApiImpl.checkZPlanAvatarUpdate$lambda$14(ZPlanApiImpl.this);
                    }
                }, 16, null, true);
                this.hasCheckZPlanAvatar = true;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void pauseRecordQueueAfterEnterBackground() {
        QLog.i(TAG, 1, "pauseRecordQueueAfterEnterBackground");
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        if (zPlanFeatureSwitch.t3()) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.m
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanApiImpl.pauseRecordQueueAfterEnterBackground$lambda$19();
                }
            }, 16, null, true, zPlanFeatureSwitch.E1());
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void reportEasterEggPlaySuccess(com.tencent.mobileqq.zplan.easteregg.a aVar) {
        if (aVar != null && aVar.getEnableReport()) {
            com.tencent.mobileqq.zplan.servlet.i.f335409a.d(aVar.getPortraitName());
            return;
        }
        QLog.e(TAG, 1, "reportEasterEggPlaySuccess failed, config == null: " + (aVar == null));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v2 ??, still in use, count: 1, list:
          (r0v2 ?? I:com.tencent.mobileqq.zplan.model.ZPlanUserInfo) from 0x0029: INVOKE (r0v2 ?? I:com.tencent.mobileqq.zplan.model.ZPlanUserInfo), (r19v0 ?? I:java.lang.String) VIRTUAL call: com.tencent.mobileqq.zplan.model.ZPlanUserInfo.setName(java.lang.String):void A[MD:(java.lang.String):void (m)] (LINE:42)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void sendMessage(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v2 ??, still in use, count: 1, list:
          (r0v2 ?? I:com.tencent.mobileqq.zplan.model.ZPlanUserInfo) from 0x0029: INVOKE (r0v2 ?? I:com.tencent.mobileqq.zplan.model.ZPlanUserInfo), (r19v0 ?? I:java.lang.String) VIRTUAL call: com.tencent.mobileqq.zplan.model.ZPlanUserInfo.setName(java.lang.String):void A[MD:(java.lang.String):void (m)] (LINE:42)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r15v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void stopZPlanEngine(boolean shouldCheckFloat) {
        if (shouldCheckFloat && ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat()) {
            QLog.e(TAG, 1, "do not stopZPlanEngine, shouldCheckFloat true, return");
        } else {
            stopZPlanEngine();
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public String updateSchemeURLWithUin(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                Bundle bundle = new Bundle();
                bundle.putString("friendUin", str2);
                String appendPageDataToScheme = ((IZPlanApi) QRoute.api(IZPlanApi.class)).appendPageDataToScheme(str, bundle);
                QLog.i(TAG, 1, "updateSchemeURLWithUin, friendUin: " + com.tencent.mobileqq.qcall.g.b(str2) + ", result: " + appendPageDataToScheme);
                return appendPageDataToScheme;
            }
        }
        QLog.e(TAG, 1, "updateSchemeURLWithUin failed, scheme or friendUin invalid.");
        return "";
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void preRequestMiniHomeFlag(final long j3) {
        if (j3 < 0 || !VasZplanAIOConfigControlV2.INSTANCE.a().c(j3)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanApiImpl.preRequestMiniHomeFlag$lambda$33(j3);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void startAvatarSettingActivity(Context context, String from, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        if (params != null) {
            params.putExtra("FROM", from);
        }
        if (!(context instanceof Activity) && params != null) {
            params.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, params, NewZplanSettingAvatarShowFragment.class);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public boolean shouldInterceptWebToNative(Activity activity, String str) {
        if (activity == null || str == null) {
            return false;
        }
        return ((ISchemeApi) QRoute.api(ISchemeApi.class)).shouldInterceptWebToNative(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDownloadStatus(Context context, MapStatus mapStatus, TransitPageInfo info, ZootopiaSource source) {
        QLog.i(TAG, 1, "handleDownloadStatus");
        String uin = info.getMasterInfo().getUin();
        if (uin == null) {
            return;
        }
        String groupId = info.getMasterInfo().getGroupId();
        if (groupId != null) {
            Long.parseLong(groupId);
        }
        if (b.f331342a[mapStatus.ordinal()] == 1) {
            if (info.getConfig().getNeedTransitPageWhenReady() == 1) {
                showSmallHomeTransitPanel(context, info, source);
                return;
            }
            if (source.getMainSource() == com.tencent.mobileqq.zootopia.Source.QavEntrance && (Intrinsics.areEqual(source.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) || Intrinsics.areEqual(source.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_GROUP_RIGHT))) {
                ReportController.o(null, "dc00898", "", "", "0X800C25E", "0X800C25E", Intrinsics.areEqual(source.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) ? 1 : 2, 0, "", "", "", "");
            }
            ZplanVasSmallHomeUtils.f311238a.c(context, uin, info, source);
            return;
        }
        showSmallHomeTransitPanel(context, info, source);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanApi
    public void refreshZPlanEmoticonGrayTipsMMKVIfNeed() {
        try {
            JSONObject zPlanEmoticonGrayTipsMMKV = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanEmoticonGrayTipsMMKV();
            if (zPlanEmoticonGrayTipsMMKV != null) {
                zPlanEmoticonGrayTipsMMKV.put("has_clicked", true);
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                String jSONObject = zPlanEmoticonGrayTipsMMKV.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "it.toString()");
                iZPlanApi.setZPlanEmoticonGrayTipsMMKV(jSONObject);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "resetZPlanEmoticonMMKVIfNeed failed.", th5);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/api/impl/ZPlanApiImpl$h", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements IGuardInterface {
        h() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            ZPlanServiceHelper.I.q0();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            ZPlanServiceHelper.I.r0();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
        }
    }
}
