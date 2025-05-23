package com.tencent.mobileqq.nearbypro.qqkuikly.module;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Process;
import android.util.Base64;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.nearbypro.ai.NBPAIHelper;
import com.tencent.mobileqq.nearbypro.aio.processor.NearByProTempProcessor;
import com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper;
import com.tencent.mobileqq.nearbypro.aio.utils.NearbyProAIOUtils;
import com.tencent.mobileqq.nearbypro.api.IAvatarService;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.INearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadMgr;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService;
import com.tencent.mobileqq.nearbypro.forward.api.INearbyProForwardApi;
import com.tencent.mobileqq.nearbypro.map.avatar.MapAvatarUtils;
import com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.NBPKuiklyMapView;
import com.tencent.mobileqq.nearbypro.repository.service.AvatarService;
import com.tencent.mobileqq.nearbypro.utils.api.INearbyProJubaoApi;
import com.tencent.mobileqq.nearbypro.utils.p;
import com.tencent.mobileqq.nearbypro.utils.q;
import com.tencent.mobileqq.nearbypro.utils.r;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.d;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.x;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUnreadInfo;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUserInfo;
import com.tencent.qqperf.collection.FPSCalculator;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.Square;
import com.tencent.state.square.data.SquareDeviceInfo;
import com.tencent.state.square.util.CpuUtil;
import com.tencent.state.square.util.MemoryUtil;
import com.tencent.state.utils.BundleParamsUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalMeta;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import fu4.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jb2.UserProfileData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONObject;
import zb3.FriendsDressUpData;
import zb3.FriendsRespData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0094\u00012\u00020\u00012\u00020\u0002:\u0002\u0095\u0001B\t\u00a2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001JI\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J5\u0010\u001e\u001a\u00020\u000b2+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010 \u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010$\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\u0012\u0010(\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H\u0002J\f\u0010-\u001a\u00020\u0003*\u00020+H\u0002J\b\u0010.\u001a\u00020\u0003H\u0002J\u0012\u0010/\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00100\u001a\u00020\u0003H\u0002J\u0012\u00101\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J?\u00102\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J5\u00103\u001a\u00020\u000b2+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J=\u00106\u001a\u0002052\u0006\u00104\u001a\u00020\u00032+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u00107\u001a\u00020\u0012H\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u00020\u0003H\u0002J\b\u0010;\u001a\u00020\u0005H\u0002J\b\u0010=\u001a\u00020<H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020\u0005H\u0002J\u0012\u0010B\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J?\u0010C\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0014\u0010D\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010E\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010F\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010I\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u0003H\u0002JA\u0010J\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0014\u0010K\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010L\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010M\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010N\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u00020\u0005H\u0002J\b\u0010P\u001a\u00020\u0005H\u0002J\b\u0010Q\u001a\u00020\u0005H\u0002J\b\u0010R\u001a\u00020\u000bH\u0002J5\u0010S\u001a\u00020\u000b2+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J5\u0010T\u001a\u00020\u000b2+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u0010U\u001a\u00020\u000bH\u0002J?\u0010V\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u0010W\u001a\u00020\u0005H\u0002J\u0012\u0010X\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010Y\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J?\u0010Z\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010[\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010\\\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J$\u0010^\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u00122\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0007H\u0002J\u001c\u0010b\u001a\u0004\u0018\u00010\u00052\u0006\u0010_\u001a\u00020<2\b\u0010a\u001a\u0004\u0018\u00010`H\u0002J?\u0010c\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010d\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u0010e\u001a\u00020\u0003H\u0002J\u0012\u0010f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010g\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010h\u001a\u00020\u0005H\u0002J\u0012\u0010i\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010j\u001a\u00020\u000bH\u0002J\u0012\u0010k\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J?\u0010l\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002JD\u0010t\u001a\u00020\u000b2\b\u0010m\u001a\u0004\u0018\u00010\u00032\b\u0010n\u001a\u0004\u0018\u00010\u00032\b\u0010o\u001a\u0004\u0018\u00010\u00032\b\u0010p\u001a\u0004\u0018\u00010\u00032\b\u0010r\u001a\u0004\u0018\u00010q2\b\u0010s\u001a\u0004\u0018\u00010qH\u0002J?\u0010u\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010v\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010w\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010x\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0010\u0010z\u001a\u00020\u00032\u0006\u0010y\u001a\u00020\u0003H\u0002J?\u0010{\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u0010|\u001a\u00020\u000bH\u0002J?\u0010}\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010~\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010\u007f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0013\u0010\u0080\u0001\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002R\u001f\u0010\u0085\u0001\u001a\n\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010\u001dR\u0018\u0010\u0091\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010\u001d\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule;", "Li01/e;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "j1", "m1", "g1", "Z", "o0", "h1", "m0", "n0", "G", "H", "f1", "t0", "D", "O", "H0", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/mobileqq/nearbypro/api/map/SelfUserInfo;", "X", "L0", "Y", "K0", BdhLogUtil.LogTag.Tag_Req, "l0", "c1", "G0", "resultKey", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "W", "i0", "N0", "g0", "a0", "h0", "", "b0", "c0", "", "d0", "e1", "k0", "f0", "s0", "y0", "A0", "originURL", "friendUin", "k1", BdhLogUtil.LogTag.Tag_Conn, "x0", "u0", "w0", "e0", ExifInterface.LATITUDE_SOUTH, "V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, UserInfo.SEX_FEMALE, "q0", "p0", "z0", "l1", "I", "K", "F0", ICustomDataEditor.NUMBER_PARAM_1, "J0", "v0", "saveToAlbum", "J", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "B0", "W0", "U0", "T", "M", "L", "U", "O0", "D0", "I0", "P", "title", "content", "leftText", "rightText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "P0", "R0", "b1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M0", "text", "E0", "i1", "E", "C0", "N", "j0", "d1", "", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProListener;", "d", "Ljava/util/List;", "nearbyProUnreadMsgListeners", "Lcom/tencent/qqperf/collection/FPSCalculator$GetFPSListener;", "e", "Lcom/tencent/qqperf/collection/FPSCalculator$GetFPSListener;", "fpsListener", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "f", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "klSignalInfoListener", tl.h.F, "hadDestroy", "i", "isAppInBackground", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQNearbyModule extends i01.e implements IGuardInterface {

    @NotNull
    private static final byte[] C;

    @Nullable
    private static Object[] D;
    private static int E;

    /* renamed from: m */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private final List<IKernelNearbyProListener> nearbyProUnreadMsgListeners = new ArrayList();

    /* renamed from: e, reason: from kotlin metadata */
    @Nullable
    private FPSCalculator.GetFPSListener fpsListener;

    /* renamed from: f, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.matchfriend.reborn.content.signal.a klSignalInfoListener;

    /* renamed from: h */
    private boolean hadDestroy;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean isAppInBackground;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b1\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010$\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001bR\u0014\u0010%\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u001bR\u0014\u0010'\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u001bR\u0014\u0010(\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u001bR\u0014\u0010)\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u0014\u0010*\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010\u001bR\u0014\u0010+\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR\u0014\u0010,\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010\u001bR\u0014\u0010-\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010\u001bR\u0014\u0010.\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010\u001bR\u0014\u0010/\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\u001bR\u0014\u00100\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010\u001bR\u0014\u00101\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u0010\u001bR\u0014\u00102\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u0010\u001bR\u0014\u00103\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u0010\u001bR\u0014\u00104\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b4\u0010\u001bR\u0014\u00105\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b5\u0010\u001bR\u0014\u00106\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b6\u0010\u001bR\u0014\u00107\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b7\u0010\u001bR\u0014\u00108\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b8\u0010\u001bR\u0014\u00109\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b9\u0010\u001bR\u0014\u0010:\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b:\u0010\u001bR\u0014\u0010;\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b;\u0010\u001bR\u0014\u0010<\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b<\u0010\u001bR\u0014\u0010=\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b=\u0010\u001bR\u0014\u0010>\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b>\u0010\u001bR\u0014\u0010?\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b?\u0010\u001bR\u0014\u0010@\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b@\u0010\u001bR\u0014\u0010A\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bA\u0010\u0018R\u0014\u0010B\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bB\u0010\u0018R\u0014\u0010C\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bC\u0010\u0018R\u0014\u0010D\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bD\u0010\u0018R\u0014\u0010E\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bE\u0010\u0018R\u0014\u0010F\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010\u001bR\u0016\u0010G\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\u0018\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$a;", "", "", "g", tl.h.F, "", "byteArray", "map", "c", "", "f", "BASE64", "[B", "e", "()[B", "", "sharePenetratePageData", "[Ljava/lang/Object;", "getSharePenetratePageData", "()[Ljava/lang/Object;", "i", "([Ljava/lang/Object;)V", "", "FORWARD_SELECT_PAGE_REQUEST_CODE", "I", "", "KEY_ADDRESS", "Ljava/lang/String;", "KEY_AVATAR_DRESS_BORDER_URL", "KEY_AVATAR_URL", "KEY_CITY", "KEY_CITY_CODE", "KEY_DISTRICT", "KEY_GENDER", "KEY_GUIDE_DISPLAY_FLAG", "KEY_LAT02", "KEY_LAT84", "KEY_LAT_LNG", "KEY_LOCATION_ADDRESS", "KEY_LOCATION_CITY", "KEY_LOCATION_COUNTRY", "KEY_LOCATION_DISTRICT", "KEY_LOCATION_NAME", "KEY_LOCATION_PROVINCE", "KEY_LON02", "KEY_LON84", "KEY_NAME", "KEY_NATION", "KEY_NBP_USER_AVATAR", "KEY_NBP_USER_NICK", "KEY_NBP_USER_PEER_UID", "KEY_NICK_NAME", "KEY_PROVINCE", "KEY_STATUS_INFO", "KEY_STREET", "KEY_STREET_NO", "KEY_TID", "KEY_TOWN", "KEY_USER_NICK_NAME", "KEY_VILLAGE", "METHOD_FOLLOW_PUBLIC_ACCOUNT", "METHOD_IS_FOLLOWED_PUBLIC_ACCOUNT", "METHOD_START_QQ_STRANGER_PUBLIC_ACCOUNT_DETAIL", "NBP_REPLY_MSG_DIALOG_BANNER_DARK", "NBP_REPLY_MSG_DIALOG_BANNER_LIGHT", "PERMISSION_DENIED", "PERMISSION_GRANTED", "PERMISSION_JUMP_SETTING", "PERMISSION_NULL", "PERMISSION_UNKNOWN", "TAG", "mainPageLiveCount", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$a */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ byte[] d(Companion companion, byte[] bArr, byte[] bArr2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                bArr2 = companion.e();
            }
            return companion.c(bArr, bArr2);
        }

        public final synchronized void g() {
            INearbyProEntryUnreadMgr iNearbyProEntryUnreadMgr;
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "onMainPageCreated");
            QQNearbyModule.E++;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iNearbyProEntryUnreadMgr = (INearbyProEntryUnreadMgr) peekAppRuntime.getRuntimeService(INearbyProEntryUnreadMgr.class, "")) != null) {
                iNearbyProEntryUnreadMgr.markEntryCountRead();
            }
        }

        public final synchronized void h() {
            INearbyProEntryUnreadMgr iNearbyProEntryUnreadMgr;
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "onMainPageDestroyed");
            QQNearbyModule.E--;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iNearbyProEntryUnreadMgr = (INearbyProEntryUnreadMgr) peekAppRuntime.getRuntimeService(INearbyProEntryUnreadMgr.class, "")) != null) {
                iNearbyProEntryUnreadMgr.markEntryCountRead();
            }
        }

        @NotNull
        public final byte[] c(@NotNull byte[] byteArray, @NotNull byte[] map) {
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            Intrinsics.checkNotNullParameter(map, "map");
            byte[] bArr = new byte[((byteArray.length + 2) / 3) * 4];
            int length = byteArray.length - (byteArray.length % 3);
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                int i17 = i3 + 1;
                byte b16 = byteArray[i3];
                int i18 = i17 + 1;
                byte b17 = byteArray[i17];
                int i19 = i18 + 1;
                byte b18 = byteArray[i18];
                int i26 = i16 + 1;
                bArr[i16] = map[(b16 & 255) >> 2];
                int i27 = i26 + 1;
                bArr[i26] = map[((b16 & 3) << 4) | ((b17 & 255) >> 4)];
                int i28 = i27 + 1;
                bArr[i27] = map[((b17 & RegisterType.DOUBLE_HI) << 2) | ((b18 & 255) >> 6)];
                i16 = i28 + 1;
                bArr[i28] = map[b18 & 63];
                i3 = i19;
            }
            int length2 = byteArray.length - length;
            if (length2 != 1) {
                if (length2 == 2) {
                    int i29 = i3 + 1;
                    byte b19 = byteArray[i3];
                    byte b26 = byteArray[i29];
                    int i36 = i16 + 1;
                    bArr[i16] = map[(b19 & 255) >> 2];
                    int i37 = i36 + 1;
                    bArr[i36] = map[((b19 & 3) << 4) | ((b26 & 255) >> 4)];
                    bArr[i37] = map[(b26 & RegisterType.DOUBLE_HI) << 2];
                    bArr[i37 + 1] = 61;
                }
            } else {
                byte b27 = byteArray[i3];
                int i38 = i16 + 1;
                bArr[i16] = map[(b27 & 255) >> 2];
                int i39 = i38 + 1;
                bArr[i38] = map[(b27 & 3) << 4];
                bArr[i39] = 61;
                bArr[i39 + 1] = 61;
            }
            return bArr;
        }

        @NotNull
        public final byte[] e() {
            return QQNearbyModule.C;
        }

        public final boolean f() {
            if (QQNearbyModule.E > 0) {
                return true;
            }
            return false;
        }

        public final void i(@Nullable Object[] objArr) {
            QQNearbyModule.D = objArr;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "success", IProfileProtocolConst.PARAM_IS_FRIEND, "", "a", "(ZZ)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.mobileqq.matchfriend.api.a {

        /* renamed from: a */
        final /* synthetic */ Function1<Object, Unit> f253767a;

        b(Function1<Object, Unit> function1) {
            this.f253767a = function1;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.a
        public final void a(boolean z16, boolean z17) {
            Map mapOf;
            if (z16) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IProfileProtocolConst.PARAM_IS_FRIEND, Boolean.valueOf(z17)));
                Function1<Object, Unit> function1 = this.f253767a;
                if (function1 != null) {
                    function1.invoke(mapOf);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$c", "Lcom/tencent/biz/pubaccount/api/IPublicAccountObserver$c;", "", "isSuccess", "", "uin", "", "onFollowPublicAccount", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends IPublicAccountObserver.c {

        /* renamed from: a */
        final /* synthetic */ Function1<Object, Unit> f253768a;

        c(Function1<Object, Unit> function1) {
            this.f253768a = function1;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean isSuccess, @Nullable String uin) {
            boolean equals$default;
            equals$default = StringsKt__StringsJVMKt.equals$default(uin, uin, false, 2, null);
            if (!equals$default) {
                return;
            }
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "[followPublicAccount] uin=" + uin + ", success=" + isSuccess);
            Function1<Object, Unit> function1 = this.f253768a;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isFollowed", isSuccess);
                function1.invoke(jSONObject);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\"\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J(\u0010\u0010\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016R\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "deniedPermissions", "", "isShowGuide", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "onDeniedWithoutShowDlg", "a", "Z", "hasClickSetting", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: from kotlin metadata */
        private boolean hasClickSetting;

        /* renamed from: b */
        final /* synthetic */ Function1<Object, Unit> f253770b;

        /* renamed from: c */
        final /* synthetic */ String f253771c;

        /* renamed from: d */
        final /* synthetic */ QQNearbyModule f253772d;

        d(Function1<Object, Unit> function1, String str, QQNearbyModule qQNearbyModule) {
            this.f253770b = function1;
            this.f253771c = str;
            this.f253772d = qQNearbyModule;
        }

        public static final void c(d this$0, QQNearbyModule this$1, Function1 function1, String resultKey, View view) {
            Map mapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(resultKey, "$resultKey");
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "tryToRequestLocationPermission onDialogShow hasClickSetting true");
            this$0.hasClickSetting = true;
            if (this$1.getContext() != null) {
                PermissionUtil.gotoSettingPage(this$1.getContext());
            }
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(resultKey, 3));
                function1.invoke(mapOf);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public static final void d(d this$0, Function1 function1, String resultKey, DialogInterface dialogInterface) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(resultKey, "$resultKey");
            if (!this$0.hasClickSetting) {
                com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "tryToRequestLocationPermission onDialogShow hasClickSetting false. finish");
                if (function1 != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(resultKey, 0));
                    function1.invoke(mapOf);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(@Nullable List<String> deniedPermissions) {
            return false;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            Map mapOf;
            super.onAllGranted();
            Function1<Object, Unit> function1 = this.f253770b;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(this.f253771c, 1));
                function1.invoke(mapOf);
            }
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "tryToRequestLocationPermission onAllGranted");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> r36) {
            Function1<Object, Unit> function1;
            Map mapOf;
            super.onDenied(permissions, r36);
            if (this.f253772d.i0() && (function1 = this.f253770b) != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(this.f253771c, 1));
                function1.invoke(mapOf);
            }
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "tryToRequestLocationPermission onDenied");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> r36) {
            Map mapOf;
            super.onDeniedWithoutShowDlg(permissions, r36);
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "tryToRequestLocationPermission onDeniedWithoutShowDlg. finish");
            Function1<Object, Unit> function1 = this.f253770b;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(this.f253771c, 2));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog permissionRequestDialog, @Nullable List<String> list) {
            Map mapOf;
            super.onDialogShow(permissionRequestDialog, list);
            if (permissionRequestDialog == null) {
                com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "tryToRequestLocationPermission onDialogShow dialog is null. finish");
                Function1<Object, Unit> function1 = this.f253770b;
                if (function1 != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(this.f253771c, 0));
                    function1.invoke(mapOf);
                    return;
                }
                return;
            }
            final QQNearbyModule qQNearbyModule = this.f253772d;
            final Function1<Object, Unit> function12 = this.f253770b;
            final String str = this.f253771c;
            permissionRequestDialog.setOnSettingClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQNearbyModule.d.c(QQNearbyModule.d.this, qQNearbyModule, function12, str, view);
                }
            });
            final Function1<Object, Unit> function13 = this.f253770b;
            final String str2 = this.f253771c;
            permissionRequestDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.l
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    QQNearbyModule.d.d(QQNearbyModule.d.this, function13, str2, dialogInterface);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$e", "Lcom/tencent/mobileqq/nearbypro/aio/request/AIONetworkHelper$a;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements AIONetworkHelper.a {

        /* renamed from: a */
        final /* synthetic */ Function1<Object, Unit> f253773a;

        e(Function1<Object, Unit> function1) {
            this.f253773a = function1;
        }

        @Override // com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper.a
        public void a(int result, @NotNull String errMsg, @NotNull NearbyProUserInfo r65) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(r65, "userInfo");
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "getUserInfoFromNT");
            Function1<Object, Unit> function1 = this.f253773a;
            if (function1 != null) {
                Pair[] pairArr = new Pair[2];
                String str = r65.nick;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("nick", str);
                String str3 = r65.avatarUrl;
                if (str3 != null) {
                    str2 = str3;
                }
                pairArr[1] = TuplesKt.to(PhotoCategorySummaryInfo.AVATAR_URL, str2);
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                function1.invoke(mapOf);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$f", "Lcom/tencent/qqperf/collection/FPSCalculator$GetFPSListener;", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f implements FPSCalculator.GetFPSListener {

        /* renamed from: a */
        final /* synthetic */ Function1<Object, Unit> f253774a;

        f(Function1<Object, Unit> function1) {
            this.f253774a = function1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$g", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "", "justNowPublish", "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class g implements com.tencent.mobileqq.matchfriend.reborn.content.signal.a {

        /* renamed from: a */
        final /* synthetic */ Function1<Object, Unit> f253775a;

        g(Function1<Object, Unit> function1) {
            this.f253775a = function1;
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.a
        public void a(@Nullable SignalPlazaSvrPB$SignalInfo signalInfo, boolean justNowPublish) {
            Function1<Object, Unit> function1;
            byte[] bArr;
            SignalPB$SignalMeta signalPB$SignalMeta;
            if (justNowPublish && (function1 = this.f253775a) != null) {
                if (signalInfo != null && (signalPB$SignalMeta = signalInfo.signal_meta) != null) {
                    bArr = signalPB$SignalMeta.toByteArray();
                } else {
                    bArr = null;
                }
                function1.invoke(bArr);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$h", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelNearbyProListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUnreadInfo;", "unreadCnt", "", "onNearbyAllContactsUnreadCntChanged", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class h implements IKernelNearbyProListener {

        /* renamed from: a */
        final /* synthetic */ Function1<Object, Unit> f253776a;

        h(Function1<Object, Unit> function1) {
            this.f253776a = function1;
        }

        public static final void b(Function1 function1, long j3) {
            Map mapOf;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("count", Integer.valueOf((int) j3)));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelNearbyProListener
        public void onNearbyAllContactsUnreadCntChanged(@Nullable NearbyProUnreadInfo unreadCnt) {
            if (unreadCnt != null) {
                final long j3 = unreadCnt.unreadCnt;
                final Function1<Object, Unit> function1 = this.f253776a;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQNearbyModule.h.b(Function1.this, j3);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$i", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class i implements com.tencent.kuikly.core.render.android.c {

        /* renamed from: e */
        final /* synthetic */ Function1<Object, Unit> f253778e;

        i(Function1<Object, Unit> function1) {
            this.f253778e = function1;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int r36, @Nullable Intent data) {
            c.a.a(this, requestCode, r36, data);
            if (requestCode != 10001) {
                return;
            }
            QQNearbyModule.this.removeKuiklyRenderLifeCycleCallback(this);
            Function1<Object, Unit> function1 = this.f253778e;
            if (function1 != null) {
                function1.invoke(QQNearbyModule.this.B0(r36, data));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$j", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class j extends QCirclePicStateListener {

        /* renamed from: d */
        final /* synthetic */ k f253779d;

        j(k kVar) {
            this.f253779d = kVar;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            super.onStateChange(state, option);
            this.f253779d.onStateChange(state, option);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$k", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class k implements IPicLoadStateListener {

        /* renamed from: e */
        final /* synthetic */ View f253781e;

        /* renamed from: f */
        final /* synthetic */ String f253782f;

        k(View view, String str) {
            this.f253781e = view;
            this.f253782f = str;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Context context;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state.isFinish() && (context = QQNearbyModule.this.getContext()) != null) {
                View view = this.f253781e;
                String feedId = this.f253782f;
                if (!GuildUIUtils.f235378a.C()) {
                    if (!NetworkUtil.isNetworkAvailable()) {
                        BaseApplication baseApplication = BaseApplication.context;
                        QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                        return;
                    }
                    pa2.a aVar = pa2.a.f425847a;
                    Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
                    String localPath = option.getLocalPath();
                    if (localPath == null) {
                        localPath = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath ?: \"\"");
                    }
                    aVar.c(context, view, feedId, localPath, view.getWidth(), view.getHeight());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$l", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class l implements com.tencent.mobileqq.zootopia.d<FriendsRespData> {
        l() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        public void onResultSuccess(@NotNull FriendsRespData result) {
            boolean z16;
            Intrinsics.checkNotNullParameter(result, "result");
            FriendsDressUpData friendsDressUpData = result.a().get(0);
            boolean z17 = true;
            if (friendsDressUpData.getScheme().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQToast.makeText(BaseApplication.context, R.string.f172672r3, 0).show();
                return;
            }
            QQNearbyModule qQNearbyModule = QQNearbyModule.this;
            String scheme = friendsDressUpData.getScheme();
            String longToString = StringUtil.longToString(friendsDressUpData.getUin());
            Intrinsics.checkNotNullExpressionValue(longToString, "longToString(curFriend.uin)");
            String k16 = qQNearbyModule.k1(scheme, longToString);
            if (k16.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iZPlanApi.launchSchemeWithContext(context, k16);
                return;
            }
            QQToast.makeText(BaseApplication.context, R.string.f172672r3, 0).show();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, @Nullable String message) {
            QQToast.makeText(BaseApplication.context, R.string.f172672r3, 0).show();
        }

        @Override // com.tencent.mobileqq.zootopia.d
        public void y() {
            d.a.b(this);
        }

        @Override // com.tencent.mobileqq.zootopia.d
        public void z() {
            d.a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$n", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class n extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a */
        final /* synthetic */ Function1<Object, Unit> f253790a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Function1<Object, Unit> function1) {
            super("NearByPro", true);
            this.f253790a = function1;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, @Nullable SosoLbsInfo info) {
            String str;
            SosoLocation sosoLocation;
            Map mapOf;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("code", Integer.valueOf(errCode));
            ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
            if (info != null) {
                str = ab2.a.f25767a.e(info);
            } else {
                str = null;
            }
            c16.e("QQNearbyModule", "onLocationFinish errCode:" + errCode + " info:" + str);
            if (errCode == 0 && info != null && (sosoLocation = info.mLocation) != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("lat02", Double.valueOf(sosoLocation.mLat02)), TuplesKt.to("lon02", Double.valueOf(sosoLocation.mLon02)), TuplesKt.to("lat84", Double.valueOf(sosoLocation.mLat84)), TuplesKt.to("lon84", Double.valueOf(sosoLocation.mLon84)), TuplesKt.to("name", sosoLocation.name), TuplesKt.to("address", sosoLocation.address), TuplesKt.to("nation", sosoLocation.nation), TuplesKt.to("province", sosoLocation.province), TuplesKt.to("city", sosoLocation.city), TuplesKt.to(b8.a.CITYCODE, sosoLocation.cityCode), TuplesKt.to("district", sosoLocation.district), TuplesKt.to("town", sosoLocation.town), TuplesKt.to("village", sosoLocation.village), TuplesKt.to("street", sosoLocation.street), TuplesKt.to("streetNo", sosoLocation.streetNo));
                linkedHashMap.put("ssoLocation", mapOf);
            }
            Function1<Object, Unit> function1 = this.f253790a;
            if (function1 != null) {
                function1.invoke(linkedHashMap);
            }
        }
    }

    static {
        byte[] byteArray;
        ArrayList arrayList = new ArrayList("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".length());
        for (int i3 = 0; i3 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".length(); i3++) {
            arrayList.add(Byte.valueOf((byte) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i3)));
        }
        byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
        C = byteArray;
    }

    public QQNearbyModule() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this);
        }
        QRoute.api(IVasSquareApi.class);
    }

    private final void A(Object obj, final Function1<Object, Unit> function1) {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) obj);
        String peerUid = jSONObject.optString("peerUid", "");
        String msg2 = jSONObject.optString("msg", "");
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        boolean z17 = false;
        if (peerUid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            if (msg2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(peekAppRuntime, new LocalGrayTip.LocalGrayTipBuilder(peerUid, 119, 1007L, 1, false, false, null, 112, null).g(msg2, 1).m(), new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.g
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                    public final void onResult(int i3, long j3) {
                        QQNearbyModule.B(Function1.this, i3, j3);
                    }
                });
                return;
            }
        }
        if (function1 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errorCode", -1);
            jSONObject2.put("errorMsg", "Invalid parameters");
            function1.invoke(jSONObject2);
        }
    }

    private final Object A0(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        long optLong = new JSONObject((String) params).optLong("tinyId", 0L);
        if (getContext() != null && !GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                return null;
            }
            AvatarService.INSTANCE.getSingleFriendZPlanInfo(optLong, new l());
            return null;
        }
        return null;
    }

    public static final void B(Function1 function1, int i3, long j3) {
        if (function1 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorCode", i3);
            jSONObject.put("errorMsg", j3);
            function1.invoke(jSONObject);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0028, code lost:
    
        if (r8 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object B0(int r75, Intent data) {
        String stringExtra;
        boolean z16;
        Map mapOf;
        if (r75 == -1 && data != null) {
            try {
                int intExtra = data.getIntExtra("uintype", 0);
                String str = "";
                if (intExtra == 1) {
                    stringExtra = data.getStringExtra("uin");
                    if (stringExtra == null) {
                    }
                    str = stringExtra;
                } else {
                    stringExtra = data.getStringExtra("extra_choose_friend_uin");
                }
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return null;
                }
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", str), TuplesKt.to("uinType", Integer.valueOf(intExtra)));
                return mapOf;
            } catch (Throwable th5) {
                com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "parseOpenMiniSelectPageResult: " + th5.getMessage());
            }
        }
        return null;
    }

    private final Object C(Object obj, final Function1<Object, Unit> function1) {
        boolean z16;
        Object orNull;
        Integer num;
        Object orNull2;
        String str;
        AppInterface appInterface;
        String obj2;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
                if (orNull != null && (obj2 = orNull.toString()) != null) {
                    num = StringsKt__StringNumberConversionsKt.toIntOrNull(obj2);
                } else {
                    num = null;
                }
                orNull2 = ArraysKt___ArraysKt.getOrNull(objArr, 1);
                if (orNull2 != null) {
                    str = orNull2.toString();
                } else {
                    str = null;
                }
                if (num == null) {
                    if (function1 != null) {
                        function1.invoke("appId is NULL");
                    }
                    return null;
                }
                if (str == null) {
                    if (function1 != null) {
                        function1.invoke("tid is NULL");
                    }
                    return null;
                }
                if (getContext() != null && !GuildUIUtils.f235378a.C()) {
                    if (!NetworkUtil.isNetworkAvailable()) {
                        BaseApplication baseApplication = BaseApplication.context;
                        QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                    } else if (num.intValue() == 1) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime instanceof AppInterface) {
                            appInterface = (AppInterface) peekAppRuntime;
                        } else {
                            appInterface = null;
                        }
                        if (appInterface != null) {
                            ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).getIsFriend(appInterface, str, new b(function1));
                        }
                    } else {
                        INearbyProPageRouter iNearbyProPageRouter = (INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class);
                        BaseApplication context = BaseApplication.context;
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        iNearbyProPageRouter.isFriend(context, str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$checkIsFriend$1$1$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z17) {
                                Map mapOf;
                                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IProfileProtocolConst.PARAM_IS_FRIEND, Boolean.valueOf(z17)));
                                Function1<Object, Unit> function12 = function1;
                                if (function12 != null) {
                                    function12.invoke(mapOf);
                                }
                            }
                        });
                    }
                }
                return null;
            }
        }
        if (function1 != null) {
            function1.invoke("Invalid params");
        }
        return null;
    }

    private final void C0(Object params, Function1<Object, Unit> callback) {
        if (callback != null) {
            callback.invoke(new JSONObject());
        }
    }

    private final void D() {
        ((IAvatarService) QRoute.api(IAvatarService.class)).cleanup();
    }

    private final void D0() {
        NBPAIHelper.f253088a.m();
    }

    private final void E() {
        aa2.a.f25755a.a();
    }

    public final String E0(String text) {
        int indexOf$default;
        int localIdFromEMCode;
        String replace$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) text, (char) 20, 0, false, 6, (Object) null);
        if (indexOf$default != -1 && text.length() >= 4) {
            String substring = text.substring(indexOf$default + 1, indexOf$default + 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String eMCode = QQSysFaceUtil.getEMCode(substring);
            if (eMCode != null && (localIdFromEMCode = QQSysFaceUtil.getLocalIdFromEMCode(eMCode)) != -1) {
                replace$default = StringsKt__StringsJVMKt.replace$default(text, substring, String.valueOf((char) localIdFromEMCode), false, 4, (Object) null);
                return replace$default;
            }
            return text;
        }
        return text;
    }

    private final void F() {
        INearbyProEntryUnreadService iNearbyProEntryUnreadService;
        INearbyProEntryUnreadMgr iNearbyProEntryUnreadMgr;
        ((INearbyProEntryUnreadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(INearbyProEntryUnreadService.class, "")).clearTianShuRedPoint();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iNearbyProEntryUnreadMgr = (INearbyProEntryUnreadMgr) peekAppRuntime.getRuntimeService(INearbyProEntryUnreadMgr.class, "")) != null) {
            iNearbyProEntryUnreadMgr.clearUnreadInteractCnt();
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 != null && (iNearbyProEntryUnreadService = (INearbyProEntryUnreadService) peekAppRuntime2.getRuntimeService(INearbyProEntryUnreadService.class, "")) != null) {
            iNearbyProEntryUnreadService.clearEntryUnreadInteractCnt();
        }
    }

    private final void F0(Object params) {
        boolean z16;
        if (params instanceof Object[]) {
            Object[] objArr = (Object[]) params;
            if (objArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String valueOf = String.valueOf(objArr[0]);
                String valueOf2 = String.valueOf(objArr[1]);
                String valueOf3 = String.valueOf(objArr[2]);
                Object obj = objArr[3];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                byte[] bArr = (byte[]) obj;
                com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
                bVar.i(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
                bVar.n(valueOf);
                bVar.o(2);
                bVar.j("0");
                bVar.s(0);
                bVar.m("anonymousseq=0");
                bVar.l(valueOf);
                bVar.k(valueOf3);
                bVar.w(valueOf2);
                bVar.v("chatmsg:");
                try {
                    URLEncoder.encode("REPORT_IP=0&EVIL_IP=0", "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                bVar.x("REPORT_IP=0&EVIL_IP=0");
                Bundle bundle = new Bundle();
                bundle.putString("jubao_nearbypro_sig", Base64.encodeToString(bArr, 0));
                bVar.p(bundle);
                ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(getActivity(), bVar);
            }
        }
    }

    private final void G(Object params) {
        boolean z16;
        final Context context = getContext();
        if (context == null) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "doJumpReport ctx is null");
            return;
        }
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        final int optInt = jSONObject.optInt("appId");
        final String tid = jSONObject.optString("tid");
        final String contentId = jSONObject.optString("contentId");
        final String chatType = jSONObject.optString("chatType");
        Intrinsics.checkNotNullExpressionValue(chatType, "chatType");
        if (chatType.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AIONetworkHelper aIONetworkHelper = AIONetworkHelper.f253140a;
            Intrinsics.checkNotNullExpressionValue(tid, "tid");
            aIONetworkHelper.j(tid, new Function1<byte[], Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$doJumpReport$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                    invoke2(bArr);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull byte[] token) {
                    Intrinsics.checkNotNullParameter(token, "token");
                    INearbyProJubaoApi iNearbyProJubaoApi = (INearbyProJubaoApi) QRoute.api(INearbyProJubaoApi.class);
                    Context context2 = context;
                    int i3 = optInt;
                    String tid2 = tid;
                    Intrinsics.checkNotNullExpressionValue(tid2, "tid");
                    String contentId2 = contentId;
                    Intrinsics.checkNotNullExpressionValue(contentId2, "contentId");
                    String chatType2 = chatType;
                    Intrinsics.checkNotNullExpressionValue(chatType2, "chatType");
                    iNearbyProJubaoApi.doJumpReport(context2, i3, tid2, contentId2, chatType2, token);
                }
            });
        } else {
            QRouteApi api = QRoute.api(INearbyProJubaoApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INearbyProJubaoApi::class.java)");
            Intrinsics.checkNotNullExpressionValue(tid, "tid");
            Intrinsics.checkNotNullExpressionValue(contentId, "contentId");
            INearbyProJubaoApi.a.a((INearbyProJubaoApi) api, context, optInt, tid, contentId, chatType, null, 32, null);
        }
    }

    private final void G0(Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
        if (qQPermission == null) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "requestLocationPermission permission is null");
            if (callback != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", 4));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        if (qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "requestLocationPermission");
            qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2, W("result", callback));
            return;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "requestLocationPermission had permission");
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", 1));
            callback.invoke(mapOf);
        }
    }

    private final void H(Object params) {
        Context context = getContext();
        if (context == null) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "doJumpReportV2 ctx is null");
            return;
        }
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        INearbyProJubaoApi iNearbyProJubaoApi = (INearbyProJubaoApi) QRoute.api(INearbyProJubaoApi.class);
        String optString = jSONObject.optString("appId");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"appId\")");
        String optString2 = jSONObject.optString("evilUin");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(\"evilUin\")");
        int optInt = jSONObject.optInt("evilUinType");
        String optString3 = jSONObject.optString("buddyFlag");
        Intrinsics.checkNotNullExpressionValue(optString3, "data.optString(\"buddyFlag\")");
        boolean optBoolean = jSONObject.optBoolean("isAnonymous");
        String optString4 = jSONObject.optString("contentId");
        Intrinsics.checkNotNullExpressionValue(optString4, "data.optString(\"contentId\")");
        iNearbyProJubaoApi.doJumpReport(context, optString, optString2, optInt, optString3, optBoolean, optString4);
    }

    private final void H0(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        SelfUserInfo X = X(new JSONObject((String) params));
        ab2.c.f25771a.c(X);
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null) {
            f16.updateSelfUserInfo();
        }
        aa2.a.f25755a.e(new NearbyProUserInfo(X.getTid(), X.getNickName(), X.getAvatarUrl()));
    }

    private final Object I() {
        return Integer.valueOf(SquareSwitchUtils.INSTANCE.enableFilamentDetail() ? 1 : 0);
    }

    private final void I0(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) params;
        Object obj = objArr[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        Object obj2 = objArr[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray");
        c.a.i(com.tencent.mobileqq.nearbypro.base.j.d(), (String) obj, (byte[]) obj2, null, false, 12, null);
    }

    private final void J(boolean saveToAlbum, final Function1<? super Boolean, Unit> callback) {
        if (!saveToAlbum) {
            callback.invoke(Boolean.TRUE);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SHARE, QQPermissionConstants.Business.SCENE.SAVE_PIC_TO_ALBUM));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            callback.invoke(Boolean.TRUE);
            return;
        }
        final String str = "result";
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$ensureAlbumPermission$requestCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                Unit unit = null;
                if ((obj instanceof Map ? (Map) obj : null) != null) {
                    callback.invoke(Boolean.valueOf(Intrinsics.areEqual(((Map) obj).get(str), (Object) 1)));
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    callback.invoke(Boolean.FALSE);
                }
            }
        };
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "requestLocationPermission");
        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, W("result", function1));
    }

    private final void J0(Object params, final Function1<Object, Unit> callback) {
        boolean z16;
        com.tencent.mobileqq.nearbypro.base.j.c().c("QQNearbyModule", "saveImageFileToAlbum params is " + params);
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String optString = jSONObject.optString("filePath");
        final String optString2 = jSONObject.optString(WadlProxyConsts.PARAM_FILENAME);
        boolean z17 = false;
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (optString2 == null || optString2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                final Bitmap decodeFile = BitmapFactory.decodeFile(optString);
                J(true, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$saveImageFileToAlbum$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z18) {
                        if (!z18) {
                            Function1<Object, Unit> function1 = callback;
                            if (function1 != null) {
                                function1.invoke(null);
                                return;
                            }
                            return;
                        }
                        com.tencent.mobileqq.nearbypro.base.g g16 = com.tencent.mobileqq.nearbypro.base.j.g();
                        final QQNearbyModule qQNearbyModule = this;
                        final Bitmap bitmap = decodeFile;
                        final String str = optString2;
                        final Function1<Object, Unit> function12 = callback;
                        g16.postOnFileThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$saveImageFileToAlbum$1.1
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
                                com.tencent.mobileqq.nearbypro.utils.g gVar = com.tencent.mobileqq.nearbypro.utils.g.f253949a;
                                Activity activity = QQNearbyModule.this.getActivity();
                                Bitmap bitmap2 = bitmap;
                                Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
                                String fileName = str;
                                Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                                final Function1<Object, Unit> function13 = function12;
                                gVar.c(activity, bitmap2, fileName, true, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule.saveImageFileToAlbum.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                        invoke2(str2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@Nullable String str2) {
                                        Map mapOf;
                                        if (str2 == null) {
                                            com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "viewToImage: can not save view image");
                                            Function1<Object, Unit> function14 = function13;
                                            if (function14 != null) {
                                                function14.invoke(null);
                                                return;
                                            }
                                            return;
                                        }
                                        Function1<Object, Unit> function15 = function13;
                                        if (function15 != null) {
                                            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("path", str2));
                                            function15.invoke(mapOf);
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
                return;
            }
        }
        if (callback != null) {
            callback.invoke(null);
        }
    }

    private final void K(Object params) {
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
            JSONObject jSONObject = new JSONObject((String) params);
            String openId = jSONObject.optString("openId", "");
            String nickName = jSONObject.optString("nickName", "");
            NearbyProAIOUtils nearbyProAIOUtils = NearbyProAIOUtils.f253151a;
            Intrinsics.checkNotNullExpressionValue(openId, "openId");
            Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
            nearbyProAIOUtils.b(context, openId, nickName);
        }
    }

    private final void K0(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        byte[] sigArray = Base64.decode(new JSONObject((String) params).optString("sigBase64"), 0);
        Intrinsics.checkNotNullExpressionValue(sigArray, "sigArray");
        com.tencent.mobileqq.nearbypro.request.a.d(sigArray);
    }

    private final void L(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).launchAddFriend(getContext(), jSONObject.optString("openId", ""), jSONObject.optString("nick", ""), jSONObject.optInt("sourceId", 0));
    }

    private final String L0(SelfUserInfo selfUserInfo) {
        double d16;
        String decodeToString;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tid", selfUserInfo.getTid());
        jSONObject.put(PhotoCategorySummaryInfo.AVATAR_URL, selfUserInfo.getAvatarUrl());
        JSONObject jSONObject2 = new JSONObject();
        LatLng latLng = selfUserInfo.getLatLng();
        double d17 = 0.0d;
        if (latLng != null) {
            d16 = latLng.latitude;
        } else {
            d16 = 0.0d;
        }
        jSONObject2.put("lat02", d16);
        LatLng latLng2 = selfUserInfo.getLatLng();
        if (latLng2 != null) {
            d17 = latLng2.longitude;
        }
        jSONObject2.put("lon02", d17);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("latLng", jSONObject2);
        jSONObject.put("gender", selfUserInfo.getGender());
        jSONObject.put("nickName", selfUserInfo.getNickName());
        rp4.g statusInfo = selfUserInfo.getStatusInfo();
        if (statusInfo != null) {
            decodeToString = StringsKt__StringsJVMKt.decodeToString(Companion.d(INSTANCE, com.tencent.mobileqq.nearbypro.request.c.c(statusInfo), null, 2, null));
            jSONObject.put("statusInfo", decodeToString);
        }
        jSONObject.put("locationAddress", selfUserInfo.getLocationAddress());
        jSONObject.put("locationName", selfUserInfo.getLocationName());
        jSONObject.put("locationCountry", selfUserInfo.getLocationCountry());
        jSONObject.put("locationProvince", selfUserInfo.getLocationProvince());
        jSONObject.put("locationCity", selfUserInfo.getLocationCity());
        jSONObject.put("locationDistrict", selfUserInfo.getLocationDistrict());
        jSONObject.put("avatarDressBorderUrl", selfUserInfo.getAvatarDressBorderUrl());
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026l())\n        }.toString()");
        return jSONObject3;
    }

    private final void M(Object params) {
        AppInterface appInterface;
        Context context;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String optString = jSONObject.optString("openId", "");
        String optString2 = jSONObject.optString("traceId", "");
        boolean z16 = false;
        int optInt = jSONObject.optInt("sourceId", 0);
        if (jSONObject.optInt("tacitInvite", 0) == 1) {
            z16 = true;
        }
        String optString3 = jSONObject.optString("feedId", "");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null || (context = getContext()) == null) {
            return;
        }
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        Bundle bundle = new Bundle();
        bundle.putString("recom_trace", optString2);
        bundle.putBoolean("key_from_invite", z16);
        bundle.putString("key_friend_open_id_from_invite", optString);
        bundle.putString("quote_feed_id", optString3);
        Unit unit = Unit.INSTANCE;
        iMatchFriendEntryApi.enterMatchFriendAIO(appInterface, context, optString, optInt, bundle);
    }

    private final void M0(Object params, final Function1<Object, Unit> callback) {
        boolean z16;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        final String tid = jSONObject.optString("tid", "");
        final String text = jSONObject.optString("text", "");
        Intrinsics.checkNotNullExpressionValue(tid, "tid");
        boolean z17 = true;
        if (tid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Intrinsics.checkNotNullExpressionValue(text, "text");
            if (text.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                NearByProTempProcessor.g(NearByProTempProcessor.f253128d, tid, "", false, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$sendAIOMessage$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        String E0;
                        Intrinsics.checkNotNullParameter(it, "it");
                        IMsgSendHelper iMsgSendHelper = (IMsgSendHelper) QRoute.api(IMsgSendHelper.class);
                        String tid2 = tid;
                        Intrinsics.checkNotNullExpressionValue(tid2, "tid");
                        QQNearbyModule qQNearbyModule = this;
                        String text2 = text;
                        Intrinsics.checkNotNullExpressionValue(text2, "text");
                        E0 = qQNearbyModule.E0(text2);
                        iMsgSendHelper.sendText(tid2, 119, E0);
                        Function1<Object, Unit> function1 = callback;
                        if (function1 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("errorCode", 0);
                            jSONObject2.put("errorMsg", "");
                            function1.invoke(jSONObject2);
                        }
                    }
                }, 4, null);
                return;
            }
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "invalid arg tid:" + tid + ", text:" + text);
        if (callback != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errorCode", -1);
            callback.invoke(jSONObject2);
        }
    }

    private final void N(Object params, Function1<Object, Unit> callback) {
        AppInterface appInterface;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (params instanceof String) {
            str = (String) params;
        }
        if (str == null) {
            str = "{}";
        }
        String uin = new JSONObject(str).optString("uin");
        if (appInterface != null) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            if (uin.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QRouteApi api = QRoute.api(IPublicAccountObserver.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IPublicAccountObserver::class.java)");
                IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) api;
                iPublicAccountObserver.setOnCallback(new c(callback));
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(appInterface, getContext(), uin, iPublicAccountObserver);
                return;
            }
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "[followPublicAccount] params invalid app=" + appInterface + ", params=" + params);
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isFollowed", false);
            callback.invoke(jSONObject);
        }
    }

    private final void N0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool("nearby_guide_displayed_flag" + peekAppRuntime.getCurrentAccountUin(), true);
    }

    private final String O() {
        SelfUserInfo selfUserInfo;
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null) {
            return L0(selfUserInfo);
        }
        return "{}";
    }

    private final void O0(Object params) {
        String str;
        if (params instanceof String) {
            str = (String) params;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        ((INearbyDataService) QRoute.api(INearbyDataService.class)).setMatchFriendBaseInfo(ca2.b.INSTANCE.a(str));
    }

    private final void P(Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<*>");
        Object obj = ((Object[]) params)[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        com.tencent.mobileqq.nearbypro.base.c d16 = com.tencent.mobileqq.nearbypro.base.j.d();
        byte[] bytes = "".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] b16 = c.a.b(d16, (String) obj, bytes, null, false, 12, null);
        if (callback != null) {
            callback.invoke(b16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r1 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P0(final String title, final String content, final String leftText, final String rightText, final DialogInterface.OnClickListener onConfirm, final DialogInterface.OnClickListener onCancel) {
        if (getActivity() != null) {
            Activity activity = getActivity();
            boolean z16 = false;
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            }
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "showConfirmDialog, but activity is null or finishing.");
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.h
                @Override // java.lang.Runnable
                public final void run() {
                    QQNearbyModule.Q0(QQNearbyModule.this, title, content, leftText, rightText, onConfirm, onCancel);
                }
            });
        }
    }

    private final Object Q() {
        Map mapOf;
        String decodeToString;
        Map mapOf2;
        np4.c a16 = com.tencent.mobileqq.nearbypro.request.a.a();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(VasUserData.Key.QQ_VER, a16.f420673a.f420670a), TuplesKt.to("device", a16.f420673a.f420671b), TuplesKt.to("platform", Integer.valueOf(a16.f420673a.f420672c)));
        String a17 = com.tencent.mobileqq.nearbypro.base.j.a().a();
        Companion companion = INSTANCE;
        byte[] bArr = a16.f420674b;
        Intrinsics.checkNotNullExpressionValue(bArr, "ext.sig");
        decodeToString = StringsKt__StringsJVMKt.decodeToString(Companion.d(companion, bArr, null, 2, null));
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("clientInfo", mapOf), TuplesKt.to("subVersion", a17), TuplesKt.to(PreloadTRTCPlayerParams.KEY_SIG, decodeToString));
        return mapOf2;
    }

    public static final void Q0(QQNearbyModule this$0, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogUtil.createCustomDialog(this$0.getActivity(), 0, str, str2, str3, str4, onClickListener, onClickListener2).show();
    }

    private final String R() {
        return "0";
    }

    private final void R0(Object params, final Function1<Object, Unit> callback) {
        String str;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNight()) {
            str = "https://downv6.qq.com/extendfriend/qqstranger_lite_action_quick_reply_dialog_banner_dark.png";
        } else {
            str = "https://downv6.qq.com/extendfriend/qqstranger_lite_action_quick_reply_dialog_banner_light.png";
        }
        DialogUtil.createDialogWithBanner(context, 230, str, context.getString(R.string.f169922jn), context.getString(R.string.f169912jm), context.getString(R.string.f170647xd), context.getString(R.string.a1p), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQNearbyModule.S0(Function1.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQNearbyModule.T0(dialogInterface, i3);
            }
        }).show();
    }

    private final Object S() {
        Map mapOf;
        SquareDeviceInfo squareDeviceInfo = Square.INSTANCE.getConfig().getCommonUtils().getSquareDeviceInfo();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DKEngine.GlobalKey.OS_NAME, squareDeviceInfo.getOsName()), TuplesKt.to("systemUiVersion", squareDeviceInfo.getSystemUiVersion()), TuplesKt.to("coreName", squareDeviceInfo.getCpuCore()), TuplesKt.to("cpuName", squareDeviceInfo.getCpuName()), TuplesKt.to("cpuCoreCount", squareDeviceInfo.getCpuCoreCount()), TuplesKt.to("cpuFreq", squareDeviceInfo.getCpuFreq()), TuplesKt.to("gpuName", squareDeviceInfo.getGpuName()), TuplesKt.to("ramSize", squareDeviceInfo.getRamSize()), TuplesKt.to("displayWidth", squareDeviceInfo.getDisplayWidth()), TuplesKt.to("displayHeight", squareDeviceInfo.getDisplayHeight()), TuplesKt.to("displayDensity", squareDeviceInfo.getDisplayDensity()));
        return mapOf;
    }

    public static final void S0(Function1 function1, DialogInterface dialogInterface, int i3) {
        if (function1 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            function1.invoke(jSONObject);
        }
    }

    private final String T() {
        com.tencent.mobileqq.matchfriend.bean.b matchFriendUserSelfData = ((IMatchFriendDataUtilApi) QRoute.api(IMatchFriendDataUtilApi.class)).getMatchFriendUserSelfData();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", matchFriendUserSelfData.f244051a);
        jSONObject.put("userNick", matchFriendUserSelfData.f244052b);
        jSONObject.put("userAvatar", matchFriendUserSelfData.f244053c);
        jSONObject.put("userConstellation", matchFriendUserSelfData.f244054d);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ion)\n        }.toString()");
        return jSONObject2;
    }

    private final Object U() {
        Map mapOf;
        ca2.b matchFriendBaseInfo = ((INearbyDataService) QRoute.api(INearbyDataService.class)).getMatchFriendBaseInfo();
        Pair[] pairArr = new Pair[3];
        String accountId = matchFriendBaseInfo.getAccountId();
        String str = "";
        if (accountId == null) {
            accountId = "";
        }
        pairArr[0] = TuplesKt.to("accountId", accountId);
        String nick = matchFriendBaseInfo.getNick();
        if (nick == null) {
            nick = "";
        }
        pairArr[1] = TuplesKt.to("nick", nick);
        String str2 = matchFriendBaseInfo.getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String();
        if (str2 != null) {
            str = str2;
        }
        pairArr[2] = TuplesKt.to(PhotoCategorySummaryInfo.AVATAR_URL, str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void U0(Object params, final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        int optInt = jSONObject.optInt("year");
        int optInt2 = jSONObject.optInt("month");
        int optInt3 = jSONObject.optInt("day");
        if (jSONObject.optBoolean("shouldLimit")) {
            P0(null, HardCodeUtil.qqStr(R.string.f170222kg), HardCodeUtil.qqStr(R.string.f170022jx), null, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQNearbyModule.V0(Function1.this, dialogInterface, i3);
                }
            });
            return;
        }
        com.tencent.mobileqq.widget.selectorview.a aVar = new com.tencent.mobileqq.widget.selectorview.a(getActivity());
        aVar.E(optInt, optInt2, optInt3);
        aVar.k(HardCodeUtil.qqStr(R.string.f170472l5));
        aVar.l(HardCodeUtil.qqStr(R.string.f170142k9));
        if (aVar.e() == null) {
            aVar.i(new m(optInt, aVar, optInt2, optInt3, this, callback));
        }
        aVar.m();
    }

    private final Object V() {
        Map mapOf;
        float cpuUsage = CpuUtil.INSTANCE.getCpuUsage(Process.myPid()) * 100.0f;
        MemoryUtil memoryUtil = MemoryUtil.INSTANCE;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cpu", Float.valueOf(cpuUsage)), TuplesKt.to("memUsage", Float.valueOf(MemoryUtil.getRoughPssMemoryInfoInner(Process.myPid()).getTotalPss() / 1024.0f)), TuplesKt.to("memLeft", Float.valueOf((float) (memoryUtil.getTotalMem() - memoryUtil.getFreeMem()))));
        return mapOf;
    }

    public static final void V0(Function1 function1, DialogInterface dialogInterface, int i3) {
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    private final QQPermission.BasePermissionsListener W(String resultKey, Function1<Object, Unit> callback) {
        return new d(callback, resultKey, this);
    }

    private final void W0(Object params, final Function1<Object, Unit> callback) {
        boolean z16;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        final int optInt = jSONObject.optInt("gender");
        if (jSONObject.optBoolean("shouldLimit")) {
            P0(null, HardCodeUtil.qqStr(R.string.f170232kh), HardCodeUtil.qqStr(R.string.f170022jx), null, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQNearbyModule.X0(Function1.this, dialogInterface, i3);
                }
            });
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        short s16 = (short) optInt;
        boolean z17 = false;
        if (s16 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        actionSheet.addRadioButton(R.string.c7_, z16);
        actionSheet.setMainTitle(R.string.f170502l8);
        if (s16 == 1) {
            z17 = true;
        }
        actionSheet.addRadioButton(R.string.b5e, z17);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.d
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                QQNearbyModule.Y0(optInt, this, actionSheet, callback, view, i3);
            }
        });
        actionSheet.show();
    }

    private final SelfUserInfo X(JSONObject r202) {
        boolean z16;
        long optLong = r202.optLong("tid");
        String optString = r202.optString(PhotoCategorySummaryInfo.AVATAR_URL);
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(KEY_AVATAR_URL)");
        LatLng latLng = new LatLng();
        JSONObject optJSONObject = r202.optJSONObject("latLng");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        } else {
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(KEY_LAT_LNG) ?: JSONObject()");
        }
        latLng.latitude = optJSONObject.optDouble("lat02");
        latLng.longitude = optJSONObject.optDouble("lon02");
        Unit unit = Unit.INSTANCE;
        int optInt = r202.optInt("gender");
        String optString2 = r202.optString("nickName");
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(KEY_USER_NICK_NAME)");
        String optString3 = r202.optString("locationAddress");
        Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(KEY_LOCATION_ADDRESS)");
        String optString4 = r202.optString("locationName");
        Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(KEY_LOCATION_NAME)");
        String optString5 = r202.optString("locationCountry");
        Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(KEY_LOCATION_COUNTRY)");
        String optString6 = r202.optString("locationProvince");
        Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(KEY_LOCATION_PROVINCE)");
        String optString7 = r202.optString("locationCity");
        Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(KEY_LOCATION_CITY)");
        String optString8 = r202.optString("locationDistrict");
        Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(KEY_LOCATION_DISTRICT)");
        String optString9 = r202.optString("avatarDressBorderUrl");
        Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(KEY_AVATAR_DRESS_BORDER_URL)");
        SelfUserInfo selfUserInfo = new SelfUserInfo(optLong, optString, latLng, optInt, optString2, null, optString3, optString4, optString5, optString6, optString7, optString8, optString9, 32, null);
        String statusInfoStr = r202.optString("statusInfo");
        Intrinsics.checkNotNullExpressionValue(statusInfoStr, "statusInfoStr");
        if (statusInfoStr.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            rp4.g c16 = rp4.g.c(Base64.decode(statusInfoStr, 0));
            Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(Base64.decode(statusInfoStr, 0))");
            selfUserInfo.y(c16);
        }
        return selfUserInfo;
    }

    public static final void X0(Function1 function1, DialogInterface dialogInterface, int i3) {
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    private final String Y() {
        String decodeToString;
        decodeToString = StringsKt__StringsJVMKt.decodeToString(Companion.d(INSTANCE, com.tencent.mobileqq.nearbypro.request.a.b().getSig(), null, 2, null));
        return decodeToString;
    }

    public static final void Y0(int i3, QQNearbyModule this$0, ActionSheet actionSheet, final Function1 function1, View view, final int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        short s16 = 0;
        if (i16 != 0 && i16 == 1) {
            s16 = 1;
        }
        if (s16 != ((short) i3)) {
            this$0.P0(HardCodeUtil.qqStr(R.string.f170492l7), HardCodeUtil.qqStr(R.string.f170482l6), HardCodeUtil.qqStr(R.string.cancel), HardCodeUtil.qqStr(R.string.a8j), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    QQNearbyModule.Z0(Function1.this, i16, dialogInterface, i17);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    QQNearbyModule.a1(Function1.this, dialogInterface, i17);
                }
            });
        }
        actionSheet.dismiss();
    }

    private final String Z(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        String optString = jSONObject.optString("key");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"key\")");
        return iUnitedConfigManager.loadAsString(optString, "");
    }

    public static final void Z0(Function1 function1, int i3, DialogInterface dialogInterface, int i16) {
        Map mapOf;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", Integer.valueOf(i3 + 1)));
            function1.invoke(mapOf);
        }
    }

    private final String a0() {
        String metaKey = Util.getMetaKey(getContext(), "TencentMapSDK");
        Intrinsics.checkNotNullExpressionValue(metaKey, "getMetaKey(context, \"TencentMapSDK\")");
        return metaKey;
    }

    public static final void a1(Function1 function1, DialogInterface dialogInterface, int i3) {
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    private final int b0() {
        String str;
        Card card;
        IProfileDataService iProfileDataService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Integer num = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean z16 = true;
        if (peekAppRuntime != null && (iProfileDataService = (IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "")) != null) {
            card = iProfileDataService.getProfileCard(str, true);
        } else {
            card = null;
        }
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (card != null) {
            z16 = false;
        }
        c16.e("QQNearbyModule", "profile card is null: " + z16);
        if (card != null) {
            num = Integer.valueOf(card.age);
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "user age: " + num);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private final void b1(Object params, final Function1<Object, Unit> callback) {
        Object orNull;
        String str = null;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            }
            if (str == null) {
                str = "";
            }
            NearByProTempProcessor.f253128d.c(str, new Function2<byte[], String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$signatureForNBPAIO$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr, String str2) {
                    invoke2(bArr, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull byte[] sign, @Nullable String str2) {
                    Intrinsics.checkNotNullParameter(sign, "sign");
                    Function1<Object, Unit> function1 = callback;
                    if (function1 != null) {
                        function1.invoke(sign);
                    }
                }
            });
            return;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "signatureForNBPAIO failed, params is not Array");
        if (callback != null) {
            callback.invoke(null);
        }
    }

    private final long c0() {
        String str;
        Card card;
        IProfileDataService iProfileDataService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Long l3 = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean z16 = true;
        if (peekAppRuntime != null && (iProfileDataService = (IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "")) != null) {
            card = iProfileDataService.getProfileCard(str, true);
        } else {
            card = null;
        }
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (card != null) {
            z16 = false;
        }
        c16.e("QQNearbyModule", "profile card is null: " + z16);
        if (card != null) {
            l3 = Long.valueOf(card.lBirthday);
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "user birthday: " + l3);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    private final void c1(Object params, Function1<Object, Unit> callback) {
        String str;
        JSONObject jSONObject;
        Map emptyMap;
        if (params instanceof String) {
            str = (String) params;
        } else {
            str = null;
        }
        if (str == null || (jSONObject = KRCSSViewExtensionKt.k0(str)) == null) {
            jSONObject = new JSONObject();
        }
        boolean z16 = false;
        if (jSONObject.optInt("ignoreAppInBackground", 0) == 1) {
            z16 = true;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "startLocation from: kuikly nearbypro: " + jSONObject + "\uff0c " + z16);
        if (this.isAppInBackground && !z16) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "startLocation but app in bg: " + hashCode());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("code", -10004);
            emptyMap = MapsKt__MapsKt.emptyMap();
            linkedHashMap.put("ssoLocation", emptyMap);
            if (callback != null) {
                callback.invoke(linkedHashMap);
                return;
            }
            return;
        }
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new n(callback));
    }

    private final short d0() {
        String str;
        Card card;
        IProfileDataService iProfileDataService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Short sh5 = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean z16 = true;
        if (peekAppRuntime != null && (iProfileDataService = (IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "")) != null) {
            card = iProfileDataService.getProfileCard(str, true);
        } else {
            card = null;
        }
        ga2.a c16 = com.tencent.mobileqq.nearbypro.base.j.c();
        if (card != null) {
            z16 = false;
        }
        c16.e("QQNearbyModule", "profile card is null: " + z16);
        if (card != null) {
            sh5 = Short.valueOf(card.shGender);
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "user gender: " + sh5);
        if (sh5 == null) {
            return (short) 0;
        }
        return sh5.shortValue();
    }

    private final void d1(Object params) {
        String str;
        Context context = getContext();
        if (context == null) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "[startQQStrangerPublicAccountDetail] ctx is null: " + params);
            return;
        }
        if (params instanceof String) {
            str = (String) params;
        } else {
            str = null;
        }
        String optString = KRCSSViewExtensionKt.k0(str).optString(IPublicAccountBrowser.KEY_PUB_UIN, "-1");
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "[startQQStrangerPublicAccountDetail] puin: " + optString);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", optString);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    private final Object e0() {
        SelfUserInfo selfUserInfo;
        String str;
        double d16;
        double d17;
        String str2;
        String str3;
        Map mapOf;
        String avatarDressBorderUrl;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null) {
            selfUserInfo = f16.getSelfUserInfo();
        } else {
            selfUserInfo = null;
        }
        Pair[] pairArr = new Pair[8];
        String str4 = "";
        if (selfUserInfo == null || (str = Long.valueOf(selfUserInfo.getTid()).toString()) == null) {
            str = "";
        }
        int i3 = 0;
        pairArr[0] = TuplesKt.to("tid", str);
        double d18 = 0.0d;
        if (selfUserInfo != null && (latLng3 = selfUserInfo.getLatLng()) != null) {
            d16 = latLng3.altitude;
        } else {
            d16 = 0.0d;
        }
        pairArr[1] = TuplesKt.to("altitude", Double.valueOf(d16));
        if (selfUserInfo != null && (latLng2 = selfUserInfo.getLatLng()) != null) {
            d17 = latLng2.longitude;
        } else {
            d17 = 0.0d;
        }
        pairArr[2] = TuplesKt.to("longitude", Double.valueOf(d17));
        if (selfUserInfo != null && (latLng = selfUserInfo.getLatLng()) != null) {
            d18 = latLng.latitude;
        }
        pairArr[3] = TuplesKt.to("latitude", Double.valueOf(d18));
        if (selfUserInfo == null || (str2 = selfUserInfo.getNickName()) == null) {
            str2 = "";
        }
        pairArr[4] = TuplesKt.to("nick", str2);
        if (selfUserInfo == null || (str3 = selfUserInfo.getAvatarUrl()) == null) {
            str3 = "";
        }
        pairArr[5] = TuplesKt.to("avatar", str3);
        if (selfUserInfo != null) {
            i3 = selfUserInfo.getGender();
        }
        pairArr[6] = TuplesKt.to("gender", Integer.valueOf(i3));
        if (selfUserInfo != null && (avatarDressBorderUrl = selfUserInfo.getAvatarDressBorderUrl()) != null) {
            str4 = avatarDressBorderUrl;
        }
        pairArr[7] = TuplesKt.to("avatarDressBorderUrl", str4);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final Object e1() {
        return Integer.valueOf(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() ? 1 : 0);
    }

    private final void f0(Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String peerUid = jSONObject.optString("key_peerId");
        boolean z16 = true;
        if (jSONObject.optInt("forceUpdate") != 1) {
            z16 = false;
        }
        AIONetworkHelper aIONetworkHelper = AIONetworkHelper.f253140a;
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        aIONetworkHelper.m(peerUid, z16, new e(callback));
    }

    private final void f1(Object params) {
        Object first;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        first = ArraysKt___ArraysKt.first((Object[]) params);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type kotlin.ByteArray");
        mp4.d c16 = mp4.d.c((byte[]) first);
        if (((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase()) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "needUpdateAvatarHead");
            mp4.f[] fVarArr = c16.f417147c;
            Intrinsics.checkNotNullExpressionValue(fVarArr, "avatarConfig.headConfigs");
            if (fVarArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                mp4.a[] aVarArr = c16.f417148d;
                Intrinsics.checkNotNullExpressionValue(aVarArr, "avatarConfig.backgroundConfigs");
                if (aVarArr.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    mp4.f headConfig = c16.f417147c[0];
                    mp4.a backgroundConfig = c16.f417148d[0];
                    MapAvatarUtils mapAvatarUtils = MapAvatarUtils.f253394a;
                    Intrinsics.checkNotNullExpressionValue(headConfig, "headConfig");
                    Intrinsics.checkNotNullExpressionValue(backgroundConfig, "backgroundConfig");
                    mapAvatarUtils.l(headConfig, backgroundConfig);
                    return;
                }
            }
            com.tencent.mobileqq.nearbypro.base.j.c().d("NBP.LocationPart", "avatarConfig is not valid, headConfigs.size: " + c16.f417147c.length + ", backgroundConfigs.size: " + c16.f417148d.length);
            return;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.LocationPart", "enableZPlanFilamentBase false, do not update avatar head");
    }

    private final Object g0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return Boolean.FALSE;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("nearby_guide_displayed_flag");
        sb5.append(currentAccountUin);
        return Integer.valueOf(from.decodeBool(sb5.toString(), false) ? 1 : 0);
    }

    private final void g1() {
        ab2.a.f25767a.A();
    }

    private final Object h0() {
        boolean z16;
        boolean z17;
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
        int i3 = 1;
        if (qQPermission != null && qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (qQPermission != null && qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                i3 = 0;
            }
        }
        return Integer.valueOf(i3);
    }

    private final void h1(Object params) {
        NBPKuiklyMapView nBPKuiklyMapView;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        Object[] objArr = (Object[]) params;
        Object obj = objArr[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        View viewWithTag = viewWithTag(((Integer) obj).intValue());
        if (viewWithTag instanceof NBPKuiklyMapView) {
            nBPKuiklyMapView = (NBPKuiklyMapView) viewWithTag;
        } else {
            nBPKuiklyMapView = null;
        }
        if (nBPKuiklyMapView != null) {
            nBPKuiklyMapView.C(objArr[1]);
        }
    }

    public final boolean i0() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LOCATION, QQPermissionConstants.Business.SCENE.SHARE_LOCATION));
        if (qQPermission == null || qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return false;
        }
        return true;
    }

    private final void i1(Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String peerUid = jSONObject.optString("key_peerId", "");
        String optString = jSONObject.optString("nickName", "");
        String optString2 = jSONObject.optString(PhotoCategorySummaryInfo.AVATAR_URL, "");
        aa2.a aVar = aa2.a.f25755a;
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        NearbyProUserInfo b16 = aVar.b(Long.parseLong(peerUid));
        if (b16 != null && Intrinsics.areEqual(b16.nick, optString) && Intrinsics.areEqual(b16.avatarUrl, optString2)) {
            return;
        }
        aVar.e(new NearbyProUserInfo(Long.parseLong(peerUid), optString, optString2));
        AIONetworkHelper.h(AIONetworkHelper.f253140a, peerUid, true, null, 4, null);
    }

    private final String j0(Object params) {
        AppInterface appInterface;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (params instanceof String) {
            str = (String) params;
        }
        if (str == null) {
            str = "{}";
        }
        String uin = new JSONObject(str).optString("uin");
        if (appInterface != null) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            if (uin.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                boolean isFollowUin = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin(appInterface, uin);
                com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "[isFollowedPublicAccount] uin=" + uin + ", isFollowed=" + isFollowUin);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isFollowed", isFollowUin);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026wed)\n        }.toString()");
                return jSONObject2;
            }
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "[isFollowedPublicAccount] params invalid app=" + appInterface + ", params=" + params);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("isFollowed", false);
        String jSONObject4 = jSONObject3.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject().apply {\n   \u2026\n            }.toString()");
        return jSONObject4;
    }

    private final void j1() {
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    private final void k0(Object params) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String peerUid = jSONObject.optString("key_peerId");
        String nick = jSONObject.optString("nick");
        String avatarUrl = jSONObject.optString(PhotoCategorySummaryInfo.AVATAR_URL);
        int optInt = jSONObject.optInt("key_from");
        QRouteApi api = QRoute.api(INearbyProPageRouter.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INearbyProPageRouter::class.java)");
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "avatarUrl");
        INearbyProPageRouter.a.a((INearbyProPageRouter) api, context, peerUid, nick, avatarUrl, optInt, 0, 32, null);
    }

    public final String k1(String originURL, String friendUin) {
        boolean z16;
        boolean z17 = true;
        if (originURL.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (friendUin.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                Bundle bundle = new Bundle();
                bundle.putString("friendUin", friendUin);
                return ((IZPlanApi) QRoute.api(IZPlanApi.class)).appendPageDataToScheme(originURL, bundle);
            }
            return originURL;
        }
        return originURL;
    }

    private final void l0(Object params) {
        boolean z16;
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
            String scheme = new JSONObject((String) params).optString(ZPlanPublishSource.FROM_SCHEME);
            Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
            if (scheme.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(context, scheme);
            }
        }
    }

    private final void l1(Object params, Function1<Object, Unit> callback) {
        Object orNull;
        String str;
        if (params instanceof Object[]) {
            orNull = ArraysKt___ArraysKt.getOrNull((Object[]) params, 0);
            if (orNull instanceof String) {
                str = (String) orNull;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (r.a(str)) {
                CorountineFunKt.e(fa2.a.c(), InnerWebView.API_UPLOAD_IMAGE, null, null, null, new QQNearbyModule$uploadImage$1(str, callback, null), 14, null);
                return;
            }
            com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "uploadImage failed, image file is not exist");
            if (callback != null) {
                callback.invoke(null);
                return;
            }
            return;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "uploadImage failed, params is not Array");
        if (callback != null) {
            callback.invoke(null);
        }
    }

    private final void m0(Object params) {
        NBPKuiklyMapView nBPKuiklyMapView;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        Object[] objArr = (Object[]) params;
        Object obj = objArr[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        View viewWithTag = viewWithTag(((Integer) obj).intValue());
        if (viewWithTag instanceof NBPKuiklyMapView) {
            nBPKuiklyMapView = (NBPKuiklyMapView) viewWithTag;
        } else {
            nBPKuiklyMapView = null;
        }
        if (nBPKuiklyMapView != null) {
            Object obj2 = objArr[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj2).intValue();
            Object obj3 = objArr[2];
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.ByteArray");
            nBPKuiklyMapView.Q(intValue, (byte[]) obj3);
        }
    }

    private final void m1() {
        p.f253956a.g();
    }

    private final void n0(Object params) {
        NBPKuiklyMapView nBPKuiklyMapView;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        Object[] objArr = (Object[]) params;
        Object obj = objArr[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        View viewWithTag = viewWithTag(((Integer) obj).intValue());
        if (viewWithTag instanceof NBPKuiklyMapView) {
            nBPKuiklyMapView = (NBPKuiklyMapView) viewWithTag;
        } else {
            nBPKuiklyMapView = null;
        }
        if (nBPKuiklyMapView != null) {
            Object obj2 = objArr[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj2).intValue();
            Object obj3 = objArr[2];
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.ByteArray");
            nBPKuiklyMapView.R(intValue, (byte[]) obj3);
        }
    }

    private final void n1(Object obj, final Function1<Object, Unit> function1) {
        com.tencent.mobileqq.nearbypro.base.j.c().c("QQNearbyModule", "viewToImage params is " + obj);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) obj);
        int optInt = jSONObject.optInt(HippyHeaderListViewController.VIEW_TAG);
        final String optString = jSONObject.optString(WadlProxyConsts.PARAM_FILENAME);
        final boolean optBoolean = jSONObject.optBoolean("saveToAlbum", false);
        View viewWithTag = viewWithTag(optInt);
        if (viewWithTag == null) {
            if (function1 != null) {
                function1.invoke(null);
                return;
            }
            return;
        }
        final Bitmap d16 = ViewExtKt.d(viewWithTag);
        if (d16 == null) {
            if (function1 != null) {
                function1.invoke(null);
                return;
            }
            return;
        }
        J(optBoolean, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$viewToImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (!z16) {
                    Function1<Object, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(null);
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.nearbypro.base.g g16 = com.tencent.mobileqq.nearbypro.base.j.g();
                final QQNearbyModule qQNearbyModule = this;
                final Bitmap bitmap = d16;
                final String str = optString;
                final boolean z17 = optBoolean;
                final Function1<Object, Unit> function13 = function1;
                g16.postOnFileThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$viewToImage$1.1
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
                        com.tencent.mobileqq.nearbypro.utils.g gVar = com.tencent.mobileqq.nearbypro.utils.g.f253949a;
                        Activity activity = QQNearbyModule.this.getActivity();
                        Bitmap bitmap2 = bitmap;
                        String fileName = str;
                        Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                        boolean z18 = z17;
                        final Function1<Object, Unit> function14 = function13;
                        gVar.c(activity, bitmap2, fileName, z18, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule.viewToImage.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                                invoke2(str2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@Nullable String str2) {
                                Map mapOf;
                                if (str2 == null) {
                                    com.tencent.mobileqq.nearbypro.base.j.c().d("QQNearbyModule", "viewToImage: can not save view image");
                                    Function1<Object, Unit> function15 = function14;
                                    if (function15 != null) {
                                        function15.invoke(null);
                                        return;
                                    }
                                    return;
                                }
                                Function1<Object, Unit> function16 = function14;
                                if (function16 != null) {
                                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("path", str2));
                                    function16.invoke(mapOf);
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    private final void o0(Function1<Object, Unit> callback) {
        this.fpsListener = new f(callback);
        FPSCalculator.getInstance().addListener(this.fpsListener);
    }

    private final void p0(Function1<Object, Unit> callback) {
        IQQStrangerSelfSignalInfoService iQQStrangerSelfSignalInfoService;
        g gVar = new g(callback);
        this.klSignalInfoListener = gVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iQQStrangerSelfSignalInfoService = (IQQStrangerSelfSignalInfoService) peekAppRuntime.getRuntimeService(IQQStrangerSelfSignalInfoService.class, "")) != null) {
            iQQStrangerSelfSignalInfoService.addListener(gVar);
        }
    }

    private final void q0(Function1<Object, Unit> callback) {
        AppInterface appInterface;
        x nearbyProService;
        if (this.hadDestroy) {
            com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "had Destroy filter observeMsgUnreadChange");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (nearbyProService = iKernelService.getNearbyProService()) != null) {
            h hVar = new h(callback);
            nearbyProService.addKernelNearbyProListener(hVar);
            this.nearbyProUnreadMsgListeners.add(hVar);
            nearbyProService.Y(new IOperateCallback() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQNearbyModule.r0(i3, str);
                }
            });
        }
    }

    public static final void r0(int i3, String str) {
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "getNearByAllContactsUnreadCnt result = " + i3 + " errMsg = " + str);
    }

    private final Object s0(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String tinyId = jSONObject.optString("tinyId", "");
        String nickName = jSONObject.optString("nickName", "");
        Context context = getContext();
        if (context != null && !GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                return null;
            }
            NearbyProAIOUtils nearbyProAIOUtils = NearbyProAIOUtils.f253151a;
            Intrinsics.checkNotNullExpressionValue(tinyId, "tinyId");
            Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
            nearbyProAIOUtils.a(context, tinyId, nickName, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule$openAddFriendPage$1$1$1
                public final void invoke(boolean z16) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            });
            return null;
        }
        return null;
    }

    private final void t0() {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent();
            intent.putExtra("open_chats_list_source", 0);
            ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchNearbyChatsListFragment(context, intent);
        }
    }

    private final Object u0(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String optString = jSONObject.optString("data");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        op4.i d16 = op4.i.d(Base64.decode(optString, 0));
        if (!GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                return null;
            }
            pa2.a aVar = pa2.a.f425847a;
            String str = d16.f423351a;
            Long valueOf = Long.valueOf(d16.f423352b.f434140a);
            sp4.c cVar = d16.f423352b;
            String str2 = cVar.f434143d;
            String str3 = cVar.f434145f;
            Intrinsics.checkNotNullExpressionValue(cVar, "statusFeed.poster");
            aVar.a(str, valueOf, str2, str3, com.tencent.mobileqq.nearbypro.utils.b.a(cVar), null, 1, optJSONObject);
            return null;
        }
        return null;
    }

    private final void v0(Object params, Function1<Object, Unit> callback) {
        com.tencent.mobileqq.nearbypro.base.j.c().c("QQNearbyModule", "viewToImage params is " + params);
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("troopTitle");
        String optString3 = jSONObject.optString("finishText");
        boolean optBoolean = jSONObject.optBoolean("needTroop", false);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        addKuiklyRenderLifecycleCallback(new i(callback));
        ((INearbyProForwardApi) QRoute.api(INearbyProForwardApi.class)).openForwardSelectPage(activity, 10001, false, optBoolean, optString, optString2, optString3);
    }

    private final Object w0(Object params) {
        boolean startsWith$default;
        v vVar;
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        String src = jSONObject.optString("src", "");
        Intrinsics.checkNotNullExpressionValue(src, "src");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(src, "nearbypro://", false, 2, null);
        if (startsWith$default) {
            String substring = src.substring(12);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            vVar = v.d(Base64.decode(substring, 0));
        } else {
            vVar = null;
        }
        int optInt = jSONObject.optInt("imageTag", 0);
        String optString = jSONObject.optString("feedId", "");
        View viewWithTag = viewWithTag(optInt);
        if (viewWithTag != null) {
            Option imageOption = Option.obtain().setUrl(src);
            imageOption.setRequestWidth(viewWithTag.getWidth());
            imageOption.setRequestHeight(viewWithTag.getHeight());
            k kVar = new k(viewWithTag, optString);
            if (vVar != null) {
                Intrinsics.checkNotNullExpressionValue(imageOption, "imageOption");
                q.c(vVar, imageOption, kVar);
            } else {
                imageOption.disableHardwareDecode();
                QCircleFeedPicLoader.g().loadImage(imageOption, new j(kVar));
            }
        }
        return null;
    }

    private final Object x0(Object params) {
        Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.String");
        JSONObject jSONObject = new JSONObject((String) params);
        long optLong = jSONObject.optLong("tinyId", 0L);
        String optString = jSONObject.optString("nickName", "");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"nickName\", \"\")");
        String optString2 = jSONObject.optString(PhotoCategorySummaryInfo.AVATAR_URL, "");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(\"avatarUrl\", \"\")");
        UserProfileData userProfileData = new UserProfileData(optLong, optString, optString2, null, 8, null);
        int optInt = jSONObject.optInt(AdMetricTag.Report.TYPE);
        int optInt2 = jSONObject.optInt("tacitInvite");
        Context context = getContext();
        if (context != null && !GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                return null;
            }
            INearbyProPageRouter iNearbyProPageRouter = (INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class);
            String longToString = StringUtil.longToString(userProfileData.getTinyId());
            Intrinsics.checkNotNullExpressionValue(longToString, "longToString(userInfo.tinyId)");
            iNearbyProPageRouter.launchNearbyAIOFragment(context, longToString, userProfileData.getNickName(), userProfileData.getAvatarUrl(), optInt, optInt2);
            return null;
        }
        return null;
    }

    private final Object y0(Object params) {
        if (!GuildUIUtils.f235378a.C()) {
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseApplication baseApplication = BaseApplication.context;
                QQToast.makeText(baseApplication, baseApplication.getString(R.string.f171137ci2), 0).show();
                return null;
            }
            IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iZootopiaApi.startPortalActivity(context, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.StatusSquare, SquareReportConst.SubSource.SQUARE_HOST_PURCHASE_SOURCE, null, 4, null), BundleParamsUtils.INSTANCE.getMallBundle());
            return null;
        }
        return null;
    }

    private final void z0() {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent();
            intent.putExtra("open_chats_list_source", 0);
            ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchNearbyChatsListFragment(context, intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2088503429:
                if (method.equals("getByteArray")) {
                    P(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -2022714541:
                if (method.equals("followPublicAccount")) {
                    N(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1927418414:
                if (method.equals("openGreetingPage")) {
                    return x0(params);
                }
                return super.call(method, params, callback);
            case -1835259094:
                if (method.equals("enableFilamentDetail")) {
                    return I();
                }
                return super.call(method, params, callback);
            case -1709920290:
                if (method.equals("getAndroidUserSelfInfo")) {
                    return O();
                }
                return super.call(method, params, callback);
            case -1568183700:
                if (method.equals("cleanAvatarInfoMap")) {
                    D();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1451978342:
                if (method.equals("showKLDatePicker")) {
                    U0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1442396849:
                if (method.equals("hadLocationPermission")) {
                    return h0();
                }
                return super.call(method, params, callback);
            case -1357146135:
                if (method.equals("updateNavColor")) {
                    j1();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1265466853:
                if (method.equals("addLocalJsonGrayTipMsg")) {
                    A(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1249350245:
                if (method.equals("getSig")) {
                    return Y();
                }
                return super.call(method, params, callback);
            case -1233000071:
                if (method.equals("openFeedDetail")) {
                    return u0(params);
                }
                return super.call(method, params, callback);
            case -1225910967:
                if (method.equals("doJumpReportV2")) {
                    H(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1184724677:
                if (method.equals("viewToImage")) {
                    n1(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1155499034:
                if (method.equals("getCurrentAreaRoomId")) {
                    return R();
                }
                return super.call(method, params, callback);
            case -1129140112:
                if (method.equals("openMyDressPage")) {
                    return y0(params);
                }
                return super.call(method, params, callback);
            case -1051116296:
                if (method.equals("popToNBPMainPage")) {
                    C0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -984337213:
                if (method.equals("setHadDisplayGuide")) {
                    N0();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -918032075:
                if (method.equals("moveBoundsInMapRect")) {
                    n0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -895691925:
                if (method.equals("updateCommonInfoToNTNearbyPro")) {
                    g1();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -787512924:
                if (method.equals("observeMsgUnreadChange")) {
                    q0(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -775896176:
                if (method.equals("clearTianShuRedPoint")) {
                    F();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -728692641:
                if (method.equals("getUserInfoFromNT")) {
                    f0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -689691960:
                if (method.equals("getPerformanceInfo")) {
                    return V();
                }
                return super.call(method, params, callback);
            case -598660832:
                if (method.equals("openOtherDressPage")) {
                    return A0(params);
                }
                return super.call(method, params, callback);
            case -562630786:
                if (method.equals("saveCacheImageToAlbum")) {
                    J0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -501728107:
                if (method.equals("launchZPlanScheme")) {
                    l0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -497364499:
                if (method.equals("doJumpReport")) {
                    G(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -463611552:
                if (method.equals("studyModeSwitch")) {
                    return e1();
                }
                return super.call(method, params, callback);
            case -447047515:
                if (method.equals("recycleAIRes")) {
                    D0();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -369496960:
                if (method.equals("openChatList")) {
                    t0();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -276527278:
                if (method.equals("getTencentMapKey")) {
                    return a0();
                }
                return super.call(method, params, callback);
            case -249207483:
                if (method.equals("launchNearbyAIOFragment")) {
                    k0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -246116622:
                if (method.equals("onMainPageDestroyed")) {
                    INSTANCE.h();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -227527772:
                if (method.equals("openAddFriendPage")) {
                    return s0(params);
                }
                return super.call(method, params, callback);
            case -147573472:
                if (method.equals("showInteractiveMsgAlert")) {
                    R0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -96210308:
                if (method.equals("enterMatchFriendAIO")) {
                    M(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -55247650:
                if (method.equals("getStringFromQQCommonConfig")) {
                    return Z(params);
                }
                return super.call(method, params, callback);
            case -6170111:
                if (method.equals("onMainPageCreated")) {
                    INSTANCE.g();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 4021805:
                if (method.equals("observeFps")) {
                    o0(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 13096552:
                if (method.equals("sendAIOMessage")) {
                    M0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 85896448:
                if (method.equals("openGalleryPreview")) {
                    return w0(params);
                }
                return super.call(method, params, callback);
            case 182904407:
                if (method.equals("saveAndroidUserSelfInfo")) {
                    H0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 219693364:
                if (method.equals("saveByteArray")) {
                    I0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 220169676:
                if (method.equals("getMatchFriendBaseInfo")) {
                    return U();
                }
                return super.call(method, params, callback);
            case 414026045:
                if (method.equals("startQQStrangerPublicAccountDetail")) {
                    d1(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 480626744:
                if (method.equals("getSharePenetratePageData")) {
                    return D;
                }
                return super.call(method, params, callback);
            case 483103770:
                if (method.equals("getDeviceInfo")) {
                    return S();
                }
                return super.call(method, params, callback);
            case 542965092:
                if (method.equals("hadDisplayGuideBefore")) {
                    return g0();
                }
                return super.call(method, params, callback);
            case 643580490:
                if (method.equals("isFollowedPublicAccount")) {
                    return j0(params);
                }
                return super.call(method, params, callback);
            case 761637971:
                if (method.equals("requestLocationPermission")) {
                    G0(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 889698558:
                if (method.equals("getUserAge")) {
                    return Integer.valueOf(b0());
                }
                return super.call(method, params, callback);
            case 936853090:
                if (method.equals("getUserGender")) {
                    return Short.valueOf(d0());
                }
                return super.call(method, params, callback);
            case 1024666070:
                if (method.equals("enterAddFriendPage")) {
                    K(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1044464602:
                if (method.equals(InnerWebView.API_UPLOAD_IMAGE)) {
                    l1(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1105738265:
                if (method.equals("vibrator")) {
                    m1();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1135103069:
                if (method.equals("tryUpdateAvatarHead")) {
                    f1(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1165148296:
                if (method.equals("updateNTUserInfo")) {
                    i1(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1212074972:
                if (method.equals("getKLUserSelfInfo")) {
                    return T();
                }
                return super.call(method, params, callback);
            case 1230459580:
                if (method.equals("signatureForNBPAIO")) {
                    b1(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1323918404:
                if (method.equals("setSharePenetratePageData")) {
                    Intrinsics.checkNotNull(params, "null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
                    D = (Object[]) params;
                    return null;
                }
                return super.call(method, params, callback);
            case 1354424614:
                if (method.equals("openForwardSelectPage")) {
                    v0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1377166622:
                if (method.equals("reportSomeone")) {
                    F0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1380737969:
                if (method.equals("moveBoundsInMap")) {
                    m0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1519192874:
                if (method.equals("observeKLSignalMetaChanged")) {
                    p0(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1533297984:
                if (method.equals("setMatchFriendBaseInfo")) {
                    O0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1678518540:
                if (method.equals("clearNTUserInfo")) {
                    E();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1706047346:
                if (method.equals("getCommonExtPB")) {
                    return Q();
                }
                return super.call(method, params, callback);
            case 1811096719:
                if (method.equals("getUserInfo")) {
                    return e0();
                }
                return super.call(method, params, callback);
            case 1822408080:
                if (method.equals("checkIsFriend")) {
                    return C(params, callback);
                }
                return super.call(method, params, callback);
            case 1861910157:
                if (method.equals("updateHeatMapData")) {
                    h1(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1872803348:
                if (method.equals("saveSig")) {
                    K0(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1927956958:
                if (method.equals("getUserBirthday")) {
                    return Long.valueOf(c0());
                }
                return super.call(method, params, callback);
            case 2028160567:
                if (method.equals("startLocation")) {
                    c1(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 2085143277:
                if (method.equals("showKLGenderPicker")) {
                    W0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 2106453001:
                if (method.equals("enterAddMatchFriendPage")) {
                    L(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 2142823610:
                if (method.equals("openNearbyProChatList")) {
                    z0();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        this.isAppInBackground = true;
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "QQNearbyModule: onApplicationBackground: " + hashCode());
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        this.isAppInBackground = false;
        com.tencent.mobileqq.nearbypro.base.j.c().e("QQNearbyModule", "QQNearbyModule: onApplicationForeground: " + hashCode());
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime;
        IQQStrangerSelfSignalInfoService iQQStrangerSelfSignalInfoService;
        super.onDestroy();
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this);
        }
        this.hadDestroy = true;
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        x xVar = null;
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime2;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null) {
            xVar = iKernelService.getNearbyProService();
        }
        for (IKernelNearbyProListener iKernelNearbyProListener : this.nearbyProUnreadMsgListeners) {
            if (xVar != null) {
                xVar.removeKernelNearbyProListener(iKernelNearbyProListener);
            }
        }
        FPSCalculator.GetFPSListener getFPSListener = this.fpsListener;
        if (getFPSListener != null) {
            FPSCalculator.getInstance().removeListener(getFPSListener);
        }
        com.tencent.mobileqq.matchfriend.reborn.content.signal.a aVar = this.klSignalInfoListener;
        if (aVar != null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (iQQStrangerSelfSignalInfoService = (IQQStrangerSelfSignalInfoService) peekAppRuntime.getRuntimeService(IQQStrangerSelfSignalInfoService.class, "")) != null) {
            iQQStrangerSelfSignalInfoService.removeListener(aVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nearbypro/qqkuikly/module/QQNearbyModule$m", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class m implements QActionSheet.f {

        /* renamed from: d */
        final /* synthetic */ int f253784d;

        /* renamed from: e */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.a f253785e;

        /* renamed from: f */
        final /* synthetic */ int f253786f;

        /* renamed from: h */
        final /* synthetic */ int f253787h;

        /* renamed from: i */
        final /* synthetic */ QQNearbyModule f253788i;

        /* renamed from: m */
        final /* synthetic */ Function1<Object, Unit> f253789m;

        m(int i3, com.tencent.mobileqq.widget.selectorview.a aVar, int i16, int i17, QQNearbyModule qQNearbyModule, Function1<Object, Unit> function1) {
            this.f253784d = i3;
            this.f253785e = aVar;
            this.f253786f = i16;
            this.f253787h = i17;
            this.f253788i = qQNearbyModule;
            this.f253789m = function1;
        }

        public static final void c(com.tencent.mobileqq.widget.selectorview.a selectorView, Function1 function1, DialogInterface dialogInterface, int i3) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(selectorView, "$selectorView");
            String t16 = Utils.t(selectorView.B(), selectorView.A());
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("year", Integer.valueOf(selectorView.D())), TuplesKt.to("month", Integer.valueOf(selectorView.B())), TuplesKt.to("day", Integer.valueOf(selectorView.A())), TuplesKt.to(LpReport_UserInfo_dc02148.CONSTELLATION, t16));
                function1.invoke(mapOf);
            }
        }

        public static final void d(Function1 function1, DialogInterface dialogInterface, int i3) {
            if (function1 != null) {
                function1.invoke(null);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            if (this.f253784d != this.f253785e.D() || this.f253786f != this.f253785e.B() || this.f253787h != this.f253785e.A()) {
                QQNearbyModule qQNearbyModule = this.f253788i;
                String qqStr = HardCodeUtil.qqStr(R.string.f170462l4);
                String qqStr2 = HardCodeUtil.qqStr(R.string.f170452l3);
                String qqStr3 = HardCodeUtil.qqStr(R.string.cancel);
                String qqStr4 = HardCodeUtil.qqStr(R.string.a8j);
                final com.tencent.mobileqq.widget.selectorview.a aVar = this.f253785e;
                final Function1<Object, Unit> function1 = this.f253789m;
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.n
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        QQNearbyModule.m.c(com.tencent.mobileqq.widget.selectorview.a.this, function1, dialogInterface, i3);
                    }
                };
                final Function1<Object, Unit> function12 = this.f253789m;
                qQNearbyModule.P0(qqStr, qqStr2, qqStr3, qqStr4, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.module.o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        QQNearbyModule.m.d(Function1.this, dialogInterface, i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
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

    public static final void T0(DialogInterface dialogInterface, int i3) {
    }
}
