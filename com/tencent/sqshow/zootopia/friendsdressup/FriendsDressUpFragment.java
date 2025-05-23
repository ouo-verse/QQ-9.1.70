package com.tencent.sqshow.zootopia.friendsdressup;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.vas.service.api.IVasZplanAIOSmallHomeService;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mobileqq.zootopia.d;
import com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.minixwconnected.api.IMiniHomeConnectedApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.UEDownloadSource;
import com.tencent.mobileqq.zplan.utils.ab;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.c2c.photograph.ZootopiaPhotographFragment;
import com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment;
import com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource;
import com.tencent.sqshow.zootopia.friendsdressup.filament.FilamentNativeAppHelper;
import com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpAvatarHelper;
import com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpBusinessScene;
import com.tencent.sqshow.zootopia.friendsdressup.logic.FriendsDressLikeManager;
import com.tencent.sqshow.zootopia.friendsdressup.widget.OverBoundLayout;
import com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup;
import com.tencent.sqshow.zootopia.samestyle.data.ZPlanTemplateFixedRoleConfig;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import zb3.FriendsDressUpData;
import zb3.FriendsRespData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u00a6\u0001\u0018\u0000 \u00b1\u00012\u00020\u0001:\u0002\u00b2\u0001B\t\u00a2\u0006\u0006\b\u00af\u0001\u0010\u00b0\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\u0011\u0010/\u001a\u0004\u0018\u00010.H\u0002\u00a2\u0006\u0004\b/\u00100J\b\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\u0016\u0010:\u001a\u00020\u000b2\f\u00109\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\u0010\u0010;\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0018H\u0002J\u0010\u0010<\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0018H\u0002J \u0010?\u001a\u00020\u000b2\u0006\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\b2\u0006\u0010'\u001a\u00020 H\u0002J\b\u0010@\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020 H\u0002J\b\u0010B\u001a\u00020\u000bH\u0003J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020 H\u0002J\u000e\u0010D\u001a\u0004\u0018\u00010\b*\u00020\bH\u0002J\b\u0010F\u001a\u00020EH\u0002J\b\u0010G\u001a\u00020\u000bH\u0002J\b\u0010H\u001a\u00020\u000bH\u0002J\b\u0010I\u001a\u00020\rH\u0002J\u0018\u0010L\u001a\u00020\r2\u0006\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\rH\u0002R\u0016\u0010O\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020T0S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010QR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010QR\u0016\u0010o\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010QR\u0016\u0010q\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010QR\u0016\u0010s\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010QR\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u001b\u0010}\u001a\u00020x8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R+\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u007f0~8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0080\u0001\u0010z\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R+\u0010\u0086\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u007f0~8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0084\u0001\u0010z\u001a\u0006\b\u0085\u0001\u0010\u0082\u0001R*\u0010\u008c\u0001\u001a\r \u0088\u0001*\u0005\u0018\u00010\u0087\u00010\u0087\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0089\u0001\u0010z\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008e\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010NR \u0010\u0093\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0090\u0001\u0010z\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R \u0010\u0096\u0001\u001a\u00030\u008f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0094\u0001\u0010z\u001a\u0006\b\u0095\u0001\u0010\u0092\u0001R\u001f\u0010\u009a\u0001\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0097\u0001\u0010z\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001f\u0010\u009e\u0001\u001a\u00030\u009b\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\bQ\u0010z\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001a\u0010\u00a2\u0001\u001a\u00030\u009f\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R \u0010\u00a5\u0001\u001a\u00030\u009b\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a3\u0001\u0010z\u001a\u0006\b\u00a4\u0001\u0010\u009d\u0001R\u0018\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R \u0010\u00ae\u0001\u001a\u00030\u00aa\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ab\u0001\u0010z\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001\u00a8\u0006\u00b3\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getSubSource", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "Di", "Lcom/tencent/mobileqq/zootopia/Source;", WidgetCacheLunarData.YI, "", "Ri", "hi", "uin", "jj", "Ci", "initDtReport", "Ki", "", "drawableId", "Landroid/widget/ImageView;", "imageView", "aj", "Lcom/tencent/sqshow/zootopia/friendsdressup/t;", "ni", "position", "li", "Ui", "dx", "oi", "Qi", "mi", "", "Fi", "()Ljava/lang/Long;", "qi", "hj", "pi", "show", "fj", "ri", "", "Lzb3/a;", "fiendZPlanInfoList", "cj", "gj", "ej", "data", "itemView", "Si", "Li", "ti", "Ni", "bj", "si", "", "Ji", "ii", WidgetCacheLunarData.JI, "Ei", "originURL", "friendUin", "ij", BdhLogUtil.LogTag.Tag_Conn, "I", "curPosition", "D", "Z", "enableSameStyle", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FilamentNativeAppHelper;", "E", "Ljava/lang/ref/WeakReference;", "filamentRef", "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpAvatarHelper;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/friendsdressup/filament/FriendsDressUpAvatarHelper;", "avatarHelper", "G", "isClick", "Ln74/a;", "H", "Ln74/a;", "binding", "Lx84/e;", "Lx84/e;", "avatarAdapter", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup$a;", "J", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup$a;", "rollingAdapter", "K", "Lcom/tencent/sqshow/zootopia/friendsdressup/t;", "commonData", "L", "isVisitAuth", "M", "isOpenedSmallHome", "N", "isSmallHomeImpReported", "P", "isShowSmallHome", "Lid3/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lid3/d;", "dtReporter", "Lcom/tencent/sqshow/zootopia/friendsdressup/datasrouce/DataSource;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Lazy;", "zi", "()Lcom/tencent/sqshow/zootopia/friendsdressup/datasrouce/DataSource;", "dataSource", "", "", ExifInterface.LATITUDE_SOUTH, "xi", "()Ljava/util/Map;", "avatarReportParamSlide", "T", "wi", "avatarReportParamNotSlide", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", "U", "Gi", "()Landroid/app/Dialog;", "showLoadingDialog", "V", "oldScreenDpSize", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "W", "Ii", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, "X", "Hi", "sourceCurrent", "Y", "Pi", "()Z", "isGuestFriendDressUp", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "Bi", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "errorView", "Lcom/tencent/sqshow/zootopia/friendsdressup/logic/FriendsDressLikeManager;", "a0", "Lcom/tencent/sqshow/zootopia/friendsdressup/logic/FriendsDressLikeManager;", "friendsLikeManager", "b0", "Ai", "emptyView", "com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$d", "c0", "Lcom/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$d;", "clickAvatarListener", "Landroid/view/animation/AlphaAnimation;", "d0", "vi", "()Landroid/view/animation/AlphaAnimation;", "alphaAnim", "<init>", "()V", "e0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendsDressUpFragment extends QPublicBaseFragment {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f0, reason: collision with root package name */
    private static boolean f370482f0;

    /* renamed from: g0, reason: collision with root package name */
    private static int f370483g0;

    /* renamed from: C, reason: from kotlin metadata */
    private int curPosition;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean enableSameStyle = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableSameStyle();

    /* renamed from: E, reason: from kotlin metadata */
    private WeakReference<FilamentNativeAppHelper> filamentRef;

    /* renamed from: F, reason: from kotlin metadata */
    private FriendsDressUpAvatarHelper avatarHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isClick;

    /* renamed from: H, reason: from kotlin metadata */
    private n74.a binding;

    /* renamed from: I, reason: from kotlin metadata */
    private x84.e avatarAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private RollingFrameViewGroup.a rollingAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    private t commonData;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isVisitAuth;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isOpenedSmallHome;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isSmallHomeImpReported;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isShowSmallHome;

    /* renamed from: Q, reason: from kotlin metadata */
    private final id3.d dtReporter;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy dataSource;

    /* renamed from: S, reason: from kotlin metadata */
    private final Lazy avatarReportParamSlide;

    /* renamed from: T, reason: from kotlin metadata */
    private final Lazy avatarReportParamNotSlide;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy showLoadingDialog;

    /* renamed from: V, reason: from kotlin metadata */
    private int oldScreenDpSize;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy sourceFrom;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy sourceCurrent;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy isGuestFriendDressUp;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Lazy errorView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FriendsDressLikeManager friendsLikeManager;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Lazy emptyView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final d clickAvatarListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Lazy alphaAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R(\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0007\u0010\u0013\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$a;", "", "Landroid/content/Context;", "context", "", "friendUin", "", "pageSource", "", "b", "", "useFilament", "Z", "a", "()Z", "d", "(Z)V", "getUseFilament$annotations", "()V", "I", "getPageSource", "()I", "c", "(I)V", "getPageSource$annotations", "", "FILAMENT_SWITCH_KEY", "Ljava/lang/String;", "FRIEND_UIN", "", "ScanMultiple", UserInfo.SEX_FEMALE, "TAG", "<init>", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return FriendsDressUpFragment.f370482f0;
        }

        public final void b(Context context, long friendUin, int pageSource) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (friendUin <= 0) {
                return;
            }
            c(pageSource);
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(context, "mqqapi://zplan/openPage?src_type=app&version=1.0&referer=3010&pageID=16&friend_uin=" + friendUin);
        }

        public final void c(int i3) {
            FriendsDressUpFragment.f370483g0 = i3;
        }

        public final void d(boolean z16) {
            FriendsDressUpFragment.f370482f0 = z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$c", "Lad3/a;", "", "result", "", "onResult", "", "errCode", "", "msg", "onError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ad3.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(FriendsDressUpFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isVisitAuth = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(FriendsDressUpFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.isVisitAuth = true;
            this$0.hj();
        }

        @Override // ad3.a
        public void onError(int errCode, String msg2) {
            FragmentActivity activity = FriendsDressUpFragment.this.getActivity();
            if (activity != null) {
                final FriendsDressUpFragment friendsDressUpFragment = FriendsDressUpFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        FriendsDressUpFragment.c.c(FriendsDressUpFragment.this);
                    }
                });
            }
        }

        @Override // ad3.a
        public void onResult(boolean result) {
            FragmentActivity activity = FriendsDressUpFragment.this.getActivity();
            if (activity != null) {
                final FriendsDressUpFragment friendsDressUpFragment = FriendsDressUpFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        FriendsDressUpFragment.c.d(FriendsDressUpFragment.this);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$d", "Lx84/g;", "", "position", "Lzb3/a;", "data", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements x84.g {
        d() {
        }

        @Override // x84.g
        public void a(int position, FriendsDressUpData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            n74.a aVar = FriendsDressUpFragment.this.binding;
            x84.e eVar = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            RecyclerView recyclerView = aVar.f418581z;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.ryAvatar");
            Integer c16 = a.c(recyclerView);
            FriendsDressUpFragment.this.isClick = true;
            if ((c16 != null && c16.intValue() == position) || c16 == null) {
                return;
            }
            FriendsDressUpFragment friendsDressUpFragment = FriendsDressUpFragment.this;
            int intValue = position - c16.intValue();
            n74.a aVar2 = friendsDressUpFragment.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            RecyclerView recyclerView2 = aVar2.f418581z;
            x84.e eVar2 = friendsDressUpFragment.avatarAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            } else {
                eVar = eVar2;
            }
            recyclerView2.smoothScrollBy(intValue * eVar.l0(), 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$e", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.d<FriendsRespData> {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(FriendsRespData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            FriendsDressUpFragment.this.gj(false);
            if (result.a().isEmpty()) {
                FriendsDressUpFragment.this.ej(true);
                return;
            }
            FriendsDressUpFragment.this.cj(result.a());
            FriendsDressLikeManager friendsDressLikeManager = FriendsDressUpFragment.this.friendsLikeManager;
            if (friendsDressLikeManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendsLikeManager");
                friendsDressLikeManager = null;
            }
            friendsDressLikeManager.H(result.a(), result.getVipMaxVote(), result.getVipFriendsMaxVotesNotice());
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            FriendsDressUpFragment.this.gj(false);
            a.b("FriendsDressUpFragmentDebug", "getFirstPage fail");
            FriendsDressUpFragment.this.fj(true);
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
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$h", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup$a;", "", "b", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/View;", "f", "view", "position", "", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h extends RollingFrameViewGroup.a {
        h() {
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup.a
        public int b() {
            x84.e eVar = FriendsDressUpFragment.this.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            return eVar.getNUM_BACKGOURND_ICON() - 2;
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup.a
        public void e(View view, int position) {
            Intrinsics.checkNotNullParameter(view, "view");
            x84.e eVar = FriendsDressUpFragment.this.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            FriendsDressUpData m06 = eVar.m0(position);
            if (m06 != null) {
                FriendsDressUpFragment.this.Si(m06, view, position);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup.a
        public View f(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.d2i, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context)\n\u2026ontent, viewGroup, false)");
            return inflate;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$i", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/c;", "", "totalScroll", "detailDx", "percent", "", "b", "", "position", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i implements com.tencent.sqshow.zootopia.friendsdressup.widget.c {
        i() {
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.c
        public void a(int position) {
            a.a("FriendsDressUpFragmentDebug", "people onScrollComplete " + position);
            FriendsDressUpFragment.this.ti(position);
            FriendsDressLikeManager friendsDressLikeManager = FriendsDressUpFragment.this.friendsLikeManager;
            if (friendsDressLikeManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendsLikeManager");
                friendsDressLikeManager = null;
            }
            friendsDressLikeManager.M(position);
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.c
        public void b(float totalScroll, float detailDx, float percent) {
            int roundToInt;
            x84.e eVar = FriendsDressUpFragment.this.avatarAdapter;
            n74.a aVar = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(eVar.l0() * percent);
            int i3 = -roundToInt;
            a.a("FriendsDressUpFragmentDebug", "people onScroll  " + percent + "  needScroll " + i3);
            n74.a aVar2 = FriendsDressUpFragment.this.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar2;
            }
            aVar.f418581z.scrollBy(i3, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$j", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/g;", "", "centerPosition", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class j implements com.tencent.sqshow.zootopia.friendsdressup.widget.g {
        j() {
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.g
        public void b(int centerPosition) {
            a.b("FriendsDressUpFragmentDebug", "snap find " + centerPosition);
            FriendsDressUpFragment.this.li(centerPosition + (-1));
            Map<String, Object> wi5 = FriendsDressUpFragment.this.isClick ? FriendsDressUpFragment.this.wi() : FriendsDressUpFragment.this.xi();
            id3.d dVar = FriendsDressUpFragment.this.dtReporter;
            n74.a aVar = FriendsDressUpFragment.this.binding;
            n74.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            RecyclerView recyclerView = aVar.f418581z;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.ryAvatar");
            dVar.c("clck", recyclerView, wi5);
            id3.d dVar2 = FriendsDressUpFragment.this.dtReporter;
            n74.a aVar3 = FriendsDressUpFragment.this.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            RollingFrameViewGroup rollingFrameViewGroup = aVar3.f418579x;
            Intrinsics.checkNotNullExpressionValue(rollingFrameViewGroup, "binding.rollFrameViewGroup");
            dVar2.c("imp_end", rollingFrameViewGroup, new LinkedHashMap());
            id3.d dVar3 = FriendsDressUpFragment.this.dtReporter;
            n74.a aVar4 = FriendsDressUpFragment.this.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar4;
            }
            RollingFrameViewGroup rollingFrameViewGroup2 = aVar2.f418579x;
            Intrinsics.checkNotNullExpressionValue(rollingFrameViewGroup2, "binding.rollFrameViewGroup");
            dVar3.c("imp", rollingFrameViewGroup2, new LinkedHashMap());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$k", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/e;", "", "position", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class k implements com.tencent.sqshow.zootopia.friendsdressup.widget.e {
        k() {
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.e
        public void a(int position) {
            id3.d dVar = FriendsDressUpFragment.this.dtReporter;
            n74.a aVar = FriendsDressUpFragment.this.binding;
            n74.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            RollingFrameViewGroup rollingFrameViewGroup = aVar.f418579x;
            Intrinsics.checkNotNullExpressionValue(rollingFrameViewGroup, "binding.rollFrameViewGroup");
            dVar.c("clck", rollingFrameViewGroup, FriendsDressUpFragment.this.xi());
            id3.d dVar2 = FriendsDressUpFragment.this.dtReporter;
            n74.a aVar3 = FriendsDressUpFragment.this.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            RollingFrameViewGroup rollingFrameViewGroup2 = aVar3.f418579x;
            Intrinsics.checkNotNullExpressionValue(rollingFrameViewGroup2, "binding.rollFrameViewGroup");
            dVar2.c("imp_end", rollingFrameViewGroup2, new LinkedHashMap());
            id3.d dVar3 = FriendsDressUpFragment.this.dtReporter;
            n74.a aVar4 = FriendsDressUpFragment.this.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar4;
            }
            RollingFrameViewGroup rollingFrameViewGroup3 = aVar2.f418579x;
            Intrinsics.checkNotNullExpressionValue(rollingFrameViewGroup3, "binding.rollFrameViewGroup");
            dVar3.c("imp", rollingFrameViewGroup3, new LinkedHashMap());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$l", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class l extends RecyclerView.OnScrollListener {
        l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            n74.a aVar = FriendsDressUpFragment.this.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            aVar.f418579x.setIgnoreTouch(newState != 0);
            if (newState == 0) {
                a.a("FriendsDressUpFragmentDebug", HippyPagerPageChangeListener.IDLE);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            FriendsDressUpFragment.this.oi(dx5);
            if (dx5 > 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                x84.e eVar = FriendsDressUpFragment.this.avatarAdapter;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar = null;
                }
                if (eVar.getNUM_BACKGOURND_ICON() - findLastVisibleItemPosition < 5) {
                    FriendsDressUpFragment.this.ri();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$n", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/OverBoundLayout$b;", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class n implements OverBoundLayout.b {
        n() {
        }

        @Override // com.tencent.sqshow.zootopia.friendsdressup.widget.OverBoundLayout.b
        public void a() {
            a.a("FriendsDressUpFragmentDebug", "onScrollLeft");
            FriendsDressUpFragment.this.ri();
        }
    }

    public FriendsDressUpFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("zplan_friends_dress_up_filament_switch", false);
        a.b("FriendsDressUpFragmentDebug", "filament switch = " + isSwitchOn);
        f370482f0 = isSwitchOn;
        this.filamentRef = new WeakReference<>(null);
        this.dtReporter = new id3.d(null, 1, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DataSource>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$dataSource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DataSource invoke() {
                return new DataSource(LifecycleOwnerKt.getLifecycleScope(FriendsDressUpFragment.this));
            }
        });
        this.dataSource = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, Object>>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$avatarReportParamSlide$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, Object> invoke() {
                Map<String, Object> mutableMapOf;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_slide", 1));
                return mutableMapOf;
            }
        });
        this.avatarReportParamSlide = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, Object>>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$avatarReportParamNotSlide$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, Object> invoke() {
                Map<String, Object> mutableMapOf;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_slide", 0));
                return mutableMapOf;
            }
        });
        this.avatarReportParamNotSlide = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$showLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dialog invoke() {
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(FriendsDressUpFragment.this.getContext(), "\u52a0\u8f7d\u4e2d", true);
                showLoadingDialog.setCanceledOnTouchOutside(false);
                return showLoadingDialog;
            }
        });
        this.showLoadingDialog = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource Di;
                ZootopiaSource from;
                Di = FriendsDressUpFragment.this.Di();
                return (Di == null || (from = Di.getFrom()) == null) ? ZootopiaSource.INSTANCE.i() : from;
            }
        });
        this.sourceFrom = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$sourceCurrent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                Source yi5;
                ZootopiaSource Ii;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                yi5 = FriendsDressUpFragment.this.yi();
                String subSource = FriendsDressUpFragment.this.getSubSource();
                Ii = FriendsDressUpFragment.this.Ii();
                return companion.c(yi5, subSource, Ii);
            }
        });
        this.sourceCurrent = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$isGuestFriendDressUp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z16;
                ZootopiaSource from;
                Intent intent;
                Intent intent2;
                FragmentActivity activity = FriendsDressUpFragment.this.getActivity();
                Source source = null;
                Serializable serializableExtra = (activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getSerializableExtra(ZootopiaSource.KEY_FRAGMENT_SOURCE);
                FragmentSource fragmentSource = serializableExtra instanceof FragmentSource ? (FragmentSource) serializableExtra : null;
                FragmentActivity activity2 = FriendsDressUpFragment.this.getActivity();
                Long valueOf = (activity2 == null || (intent = activity2.getIntent()) == null) ? null : Long.valueOf(intent.getLongExtra("friend_uin", 0L));
                if (valueOf != null && valueOf.longValue() == 0) {
                    z16 = FriendsDressUpFragment.this.Ri();
                } else {
                    if (fragmentSource != null && (from = fragmentSource.getFrom()) != null) {
                        source = from.getMainSource();
                    }
                    z16 = source == Source.AvatarSuperQQShow;
                }
                return Boolean.valueOf(z16);
            }
        });
        this.isGuestFriendDressUp = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new FriendsDressUpFragment$errorView$2(this));
        this.errorView = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$emptyView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIEmptyState invoke() {
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(FriendsDressUpFragment.this.getContext()).setImageType(8);
                String qqStr = HardCodeUtil.qqStr(R.string.xp9);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.zplan_friends_dress_no_friends)");
                QUIEmptyState build = imageType.setTitle(qqStr).setBackgroundColorType(0).build();
                build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                build.setVisibility(0);
                return build;
            }
        });
        this.emptyView = lazy9;
        this.clickAvatarListener = new d();
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<AlphaAnimation>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$alphaAnim$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AlphaAnimation invoke() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                return alphaAnimation;
            }
        });
        this.alphaAnim = lazy10;
    }

    private final QUIEmptyState Ai() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    private final QUIEmptyState Bi() {
        return (QUIEmptyState) this.errorView.getValue();
    }

    private final String Ci() {
        ZootopiaSource from;
        Intent intent;
        String b16 = ah.b(Hi());
        FragmentActivity activity = getActivity();
        Source source = null;
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra(ZootopiaSource.KEY_FRAGMENT_SOURCE);
        FragmentSource fragmentSource = serializableExtra instanceof FragmentSource ? (FragmentSource) serializableExtra : null;
        if (fragmentSource != null && (from = fragmentSource.getFrom()) != null) {
            source = from.getMainSource();
        }
        return source == Source.AvatarSuperQQShow ? "em_zplan_portal_entrance_aio_longpress_image" : b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource Di() {
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (f16 != null) {
            return f16;
        }
        FragmentActivity activity = getActivity();
        return companion.f((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
    }

    private final String Ei() {
        String str;
        x84.e eVar = this.avatarAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar = null;
        }
        FriendsDressUpData m06 = eVar.m0(this.curPosition);
        if (m06 == null) {
            QLog.e("FriendsDressUpFragmentDebug", 1, "getFriendOpenScheme, currFriendInfo null, currPosition: " + this.curPosition);
            return "";
        }
        try {
            str = String.valueOf(m06.getUin());
        } catch (Throwable unused) {
            str = "";
        }
        String scheme = m06.getScheme();
        if (scheme.length() == 0) {
            QLog.e("FriendsDressUpFragmentDebug", 1, "getFriendOpenScheme, friendScheme empty.");
            return "";
        }
        if (!ZPlanQQMC.INSTANCE.enableZPlanFriendDressBuyUinReport()) {
            QLog.i("FriendsDressUpFragmentDebug", 1, "getFriendOpenScheme, enableZPlanFriendDressBuyUinReport false.");
            return scheme;
        }
        String ij5 = ij(scheme, str);
        QLog.i("FriendsDressUpFragmentDebug", 1, "getFriendOpenScheme, originScheme: " + scheme + ", newScheme: " + ij5);
        return ij5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Long Fi() {
        Intent intent;
        Long longOrNull;
        long j3 = 0;
        if (Ri()) {
            t tVar = this.commonData;
            if (tVar != null && (r0 = tVar.getMasterUin()) != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            }
            return Long.valueOf(j3);
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return null;
        }
        return Long.valueOf(intent.getLongExtra("friend_uin", 0L));
    }

    private final Dialog Gi() {
        return (Dialog) this.showLoadingDialog.getValue();
    }

    private final ZootopiaSource Hi() {
        return (ZootopiaSource) this.sourceCurrent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaSource Ii() {
        return (ZootopiaSource) this.sourceFrom.getValue();
    }

    private final void Ki() {
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        ImageView imageView = aVar.B;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.smallHomeIcon");
        aj(R.drawable.qui_fun_neighbors, imageView);
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        ImageView imageView2 = aVar3.f418571p;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.messageIcon");
        aj(R.drawable.qui_message, imageView2);
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar4;
        }
        ImageView imageView3 = aVar2.A;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.sameStyleIcon");
        aj(R.drawable.qui_camera, imageView3);
    }

    private final void Li() {
        this.rollingAdapter = new h();
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        RollingFrameViewGroup rollingFrameViewGroup = aVar.f418579x;
        RollingFrameViewGroup.a aVar3 = this.rollingAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rollingAdapter");
            aVar3 = null;
        }
        rollingFrameViewGroup.setAdapter(aVar3, new i());
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar4;
        }
        aVar2.f418579x.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Mi;
                Mi = FriendsDressUpFragment.Mi(FriendsDressUpFragment.this, view, motionEvent);
                return Mi;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Mi(FriendsDressUpFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        a.b("FriendsDressUpFragmentDebug", "touch rollGroup  ");
        n74.a aVar = this$0.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f418581z.stopScroll();
        return false;
    }

    private final void Ni() {
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        RecyclerView recyclerView = aVar.f418581z;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        RecyclerView recyclerView2 = aVar3.f418581z;
        x84.e eVar = this.avatarAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar = null;
        }
        recyclerView2.setAdapter(eVar);
        x84.e eVar2 = this.avatarAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar2 = null;
        }
        eVar2.r0(this.clickAvatarListener);
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar4 = null;
        }
        aVar4.f418581z.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Oi;
                Oi = FriendsDressUpFragment.Oi(FriendsDressUpFragment.this, view, motionEvent);
                return Oi;
            }
        });
        if (Pi()) {
            return;
        }
        com.tencent.sqshow.zootopia.friendsdressup.widget.b bVar = new com.tencent.sqshow.zootopia.friendsdressup.widget.b(17);
        bVar.l(3.0f);
        bVar.m(new j());
        n74.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar5 = null;
        }
        bVar.attachToRecyclerView(aVar5.f418581z);
        n74.a aVar6 = this.binding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar6 = null;
        }
        aVar6.f418579x.setRollingFrameScrollListener(new k());
        n74.a aVar7 = this.binding;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar7;
        }
        aVar2.f418581z.addOnScrollListener(new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Oi(FriendsDressUpFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            this$0.isClick = false;
        }
        n74.a aVar = this$0.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        ValueAnimator moveAnimator = aVar.f418579x.getMoveAnimator();
        return moveAnimator != null && moveAnimator.isRunning();
    }

    private final boolean Pi() {
        return ((Boolean) this.isGuestFriendDressUp.getValue()).booleanValue();
    }

    private final boolean Qi() {
        return !w84.a.f445029a.b() && this.isVisitAuth && this.isOpenedSmallHome && this.isShowSmallHome;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ri() {
        ZootopiaSource from;
        Intent intent;
        FragmentActivity activity = getActivity();
        Source source = null;
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra(ZootopiaSource.KEY_FRAGMENT_SOURCE);
        FragmentSource fragmentSource = serializableExtra instanceof FragmentSource ? (FragmentSource) serializableExtra : null;
        if (fragmentSource != null && (from = fragmentSource.getFrom()) != null) {
            source = from.getMainSource();
        }
        return source == Source.ProfileEntry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(FriendsDressUpFragment this$0, FriendsDressUpData data, View itemView, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        this$0.Si(data, itemView, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ui(final int position) {
        x84.e eVar = this.avatarAdapter;
        FriendsDressUpAvatarHelper friendsDressUpAvatarHelper = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar = null;
        }
        FriendsDressUpData m06 = eVar.m0(position);
        if (m06 == null) {
            return;
        }
        if (this.filamentRef.get() == null) {
            if (getContext() == null) {
                return;
            }
            n74.a aVar = this.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            int width = aVar.f418563h.getWidth();
            int screenHeight = ScreenUtils.getScreenHeight(requireContext());
            n74.a aVar2 = this.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            FilamentNativeAppHelper filamentNativeAppHelper = new FilamentNativeAppHelper(width, screenHeight, new WeakReference(aVar2.f418563h), String.valueOf(m06.getUin()), m06.getHeadMontagePath(), m06.getBodyMontagePath());
            filamentNativeAppHelper.s();
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            wk0.a filamentNativeApp = filamentNativeAppHelper.getFilamentNativeApp();
            Intrinsics.checkNotNull(filamentNativeApp);
            FriendsDressUpBusinessScene scene = filamentNativeAppHelper.getScene();
            Intrinsics.checkNotNull(scene);
            FriendsDressUpAvatarHelper friendsDressUpAvatarHelper2 = new FriendsDressUpAvatarHelper(lifecycleScope, filamentNativeApp, scene);
            this.avatarHelper = friendsDressUpAvatarHelper2;
            x84.e eVar2 = this.avatarAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar2 = null;
            }
            FriendsDressUpData m07 = eVar2.m0(position + 1);
            friendsDressUpAvatarHelper2.i(m07 != null ? Long.valueOf(m07.getUin()) : null);
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new FriendsDressUpFragment$loadFilament$1(filamentNativeAppHelper, this, position, null), 3, null);
            this.filamentRef = new WeakReference<>(filamentNativeAppHelper);
            filamentNativeAppHelper.u(Ji());
            return;
        }
        final FilamentNativeAppHelper filamentNativeAppHelper2 = this.filamentRef.get();
        Intrinsics.checkNotNull(filamentNativeAppHelper2);
        filamentNativeAppHelper2.x(String.valueOf(m06.getUin()), m06.getHeadMontagePath(), m06.getBodyMontagePath());
        FriendsDressUpAvatarHelper friendsDressUpAvatarHelper3 = this.avatarHelper;
        if (friendsDressUpAvatarHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarHelper");
        } else {
            friendsDressUpAvatarHelper = friendsDressUpAvatarHelper3;
        }
        friendsDressUpAvatarHelper.g(m06.getUin(), new com.tencent.sqshow.zootopia.friendsdressup.filament.a() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$loadFilament$2
            @Override // com.tencent.sqshow.zootopia.friendsdressup.filament.a
            public void a() {
                FilamentNativeAppHelper.this.A(false);
            }

            @Override // com.tencent.sqshow.zootopia.friendsdressup.filament.a
            public void b() {
                FilamentNativeAppHelper.this.A(true);
            }

            @Override // com.tencent.sqshow.zootopia.friendsdressup.filament.a
            public void preloadRes() {
                FriendsDressUpAvatarHelper friendsDressUpAvatarHelper4;
                FriendsDressUpAvatarHelper friendsDressUpAvatarHelper5;
                x84.e eVar3 = this.avatarAdapter;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar3 = null;
                }
                FriendsDressUpData m08 = eVar3.m0(position - 1);
                if (m08 != null) {
                    long uin = m08.getUin();
                    friendsDressUpAvatarHelper5 = this.avatarHelper;
                    if (friendsDressUpAvatarHelper5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("avatarHelper");
                        friendsDressUpAvatarHelper5 = null;
                    }
                    friendsDressUpAvatarHelper5.i(Long.valueOf(uin));
                }
                x84.e eVar4 = this.avatarAdapter;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar4 = null;
                }
                FriendsDressUpData m09 = eVar4.m0(position - 1);
                if (m09 != null) {
                    long uin2 = m09.getUin();
                    friendsDressUpAvatarHelper4 = this.avatarHelper;
                    if (friendsDressUpAvatarHelper4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("avatarHelper");
                        friendsDressUpAvatarHelper4 = null;
                    }
                    friendsDressUpAvatarHelper4.i(Long.valueOf(uin2));
                }
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new FriendsDressUpFragment$loadFilament$2$preloadRes$3(FilamentNativeAppHelper.this, this, position, null), 3, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(FriendsDressUpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        id3.d dVar = this$0.dtReporter;
        n74.a aVar = this$0.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        ImageView imageView = aVar.f418561f;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backIgv");
        dVar.c("clck", imageView, new LinkedHashMap());
        this$0.requireActivity().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(FriendsDressUpFragment this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        id3.d dVar = this$0.dtReporter;
        n74.a aVar = this$0.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        RelativeLayout relativeLayout = aVar.f418573r;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlBuy");
        dVar.c("clck", relativeLayout, new LinkedHashMap());
        try {
            str = this$0.Ei();
        } catch (Throwable th5) {
            QLog.e("FriendsDressUpFragmentDebug", 1, "onClick rlBuy", th5);
            str = "";
        }
        if (str.length() > 0) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            iSchemeApi.launchScheme(requireContext, str);
            return;
        }
        QLog.e("FriendsDressUpFragmentDebug", 1, "click jump buy failed, scheme invalid.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:
    
        if (r1 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Xi(FriendsDressUpFragment this$0, View view) {
        String valueOf;
        Map<String, Object> mutableMapOf;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        n74.a aVar = null;
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            final FragmentManager supportFragmentManager = this$0.requireActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
            x84.e eVar = this$0.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            FriendsDressUpData m06 = eVar.m0(this$0.curPosition);
            String masterUin = MobileQQ.sMobileQQ.getLastLoginUin();
            if ((m06 != null ? Long.valueOf(m06.getUin()) : null) == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(m06.getUin());
            }
            id3.d dVar = this$0.dtReporter;
            n74.a aVar2 = this$0.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar2;
            }
            RelativeLayout relativeLayout = aVar.f418577v;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlSamestyle");
            boolean z16 = false;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", this$0.jj(valueOf)));
            dVar.c("clck", relativeLayout, mutableMapOf);
            String masterNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getFriendNickName(appInterface, valueOf);
            if (masterUin != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(masterUin);
            }
            z16 = true;
            if (!z16) {
                isBlank = StringsKt__StringsJVMKt.isBlank(valueOf);
                if (!isBlank) {
                    ZootopiaPhotographFragment.Companion companion = ZootopiaPhotographFragment.INSTANCE;
                    FragmentSource e16 = ZootopiaSource.INSTANCE.e(this$0.Hi());
                    Bundle bundle = new Bundle();
                    Intrinsics.checkNotNullExpressionValue(masterUin, "masterUin");
                    Intrinsics.checkNotNullExpressionValue(masterNickName, "masterNickName");
                    bundle.putSerializable("extra_fixed_role", new ZPlanTemplateFixedRoleConfig(1, masterUin, valueOf, masterNickName));
                    bundle.putBoolean("extra_close_when_jump_to_preview", true);
                    Unit unit = Unit.INSTANCE;
                    final ZootopiaPhotographFragment a16 = companion.a(e16, bundle);
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    ab.a(requireContext, UEDownloadSource.SameStyle, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$onViewCreated$4$1$1
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
                            QRouteApi api = QRoute.api(IZootopiaC2CApi.class);
                            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaC2CApi::class.java)");
                            IZootopiaC2CApi.a.a((IZootopiaC2CApi) api, FragmentManager.this, com.tencent.sqshow.zootopia.utils.i.b(300), a16, false, 8, null);
                        }
                    });
                    return;
                }
            }
            QLog.e("FriendsDressUpFragmentDebug", 1, "master:" + masterUin + ", guest:" + valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yi(FriendsDressUpFragment this$0, View view) {
        String str;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x84.e eVar = this$0.avatarAdapter;
        n74.a aVar = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar = null;
        }
        FriendsDressUpData m06 = eVar.m0(this$0.curPosition);
        if (m06 == null || (str = Long.valueOf(m06.getUin()).toString()) == null) {
            str = "";
        }
        String str2 = str;
        id3.d dVar = this$0.dtReporter;
        n74.a aVar2 = this$0.binding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar = aVar2;
        }
        RelativeLayout relativeLayout = aVar.f418576u;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlMiniaio");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", this$0.jj(str2)));
        dVar.c("clck", relativeLayout, mutableMapOf);
        QLog.i("FriendsDressUpFragmentDebug", 1, "miniAio onClicked, currPosition: " + this$0.curPosition + ", guestUin: " + com.tencent.zplan.common.utils.i.a(str2));
        QRouteApi api = QRoute.api(IZPlanAIOHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAIOHelper::class.java)");
        IZPlanAIOHelper.a.a((IZPlanAIOHelper) api, this$0, str2, 27, 0, 5, null, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zi(FriendsDressUpFragment this$0, View view) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Long Fi = this$0.Fi();
        if (Fi != null) {
            long longValue = Fi.longValue();
            FragmentActivity activity = this$0.getActivity();
            if (activity == null) {
                return;
            }
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchSchemeWithContext(activity, ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("friend_decorate", null, String.valueOf(longValue), false, null));
            id3.d dVar = this$0.dtReporter;
            n74.a aVar = this$0.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            RelativeLayout relativeLayout = aVar.f418578w;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlSmallhome");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", this$0.jj("")));
            dVar.c("clck", relativeLayout, mutableMapOf);
        }
    }

    private final void aj(int drawableId, ImageView imageView) {
        try {
            imageView.setImageDrawable(ie0.a.f().o(getContext(), drawableId, R.color.qui_common_icon_primary, 1001));
        } catch (Exception e16) {
            QLog.i("FriendsDressUpFragmentDebug", 1, "setDayDrawable error " + e16);
        }
    }

    private final void bj(int position) {
        String friendNickName;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        n74.a aVar = null;
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            x84.e eVar = this.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            FriendsDressUpData m06 = eVar.m0(position);
            if (m06 == null || (friendNickName = ((IContactUtils) QRoute.api(IContactUtils.class)).getFriendNickName(appInterface, String.valueOf(m06.getUin()))) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(friendNickName, "getFriendNickName(it, info.uin.toString())");
            n74.a aVar2 = this.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar2;
            }
            aVar.G.setText(friendNickName);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cj(List<FriendsDressUpData> fiendZPlanInfoList) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Map<String, Object> mutableMapOf3;
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f418573r.setVisibility(0);
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        aVar3.f418577v.setVisibility(this.enableSameStyle ? 0 : 8);
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar4 = null;
        }
        aVar4.f418572q.setVisibility(0);
        n74.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar5 = null;
        }
        aVar5.f418574s.setVisibility(0);
        n74.a aVar6 = this.binding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar6 = null;
        }
        aVar6.f418575t.setVisibility(0);
        x84.e eVar = this.avatarAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar = null;
        }
        eVar.s0(fiendZPlanInfoList);
        if (!hi()) {
            RollingFrameViewGroup.a aVar7 = this.rollingAdapter;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rollingAdapter");
                aVar7 = null;
            }
            aVar7.d();
        }
        bj(0);
        this.curPosition = 0;
        id3.d dVar = this.dtReporter;
        n74.a aVar8 = this.binding;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar8 = null;
        }
        RollingFrameViewGroup rollingFrameViewGroup = aVar8.f418579x;
        Intrinsics.checkNotNullExpressionValue(rollingFrameViewGroup, "binding.rollFrameViewGroup");
        dVar.c("imp", rollingFrameViewGroup, new LinkedHashMap());
        id3.d dVar2 = this.dtReporter;
        n74.a aVar9 = this.binding;
        if (aVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar9 = null;
        }
        RelativeLayout relativeLayout = aVar9.f418577v;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlSamestyle");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", jj("")));
        dVar2.c("imp", relativeLayout, mutableMapOf);
        id3.d dVar3 = this.dtReporter;
        n74.a aVar10 = this.binding;
        if (aVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar10 = null;
        }
        RelativeLayout relativeLayout2 = aVar10.f418576u;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.rlMiniaio");
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", jj("")));
        dVar3.c("imp", relativeLayout2, mutableMapOf2);
        id3.d dVar4 = this.dtReporter;
        n74.a aVar11 = this.binding;
        if (aVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar11 = null;
        }
        RelativeLayout relativeLayout3 = aVar11.f418575t;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.rlLike");
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", jj("")));
        dVar4.c("imp", relativeLayout3, mutableMapOf3);
        n74.a aVar12 = this.binding;
        if (aVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar12;
        }
        aVar2.f418581z.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.j
            @Override // java.lang.Runnable
            public final void run() {
                FriendsDressUpFragment.dj(FriendsDressUpFragment.this);
            }
        });
        hj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dj(FriendsDressUpFragment this$0) {
        View findViewByPosition;
        View si5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n74.a aVar = this$0.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        RecyclerView.LayoutManager layoutManager = aVar.f418581z.getLayoutManager();
        if (layoutManager != null && (findViewByPosition = layoutManager.findViewByPosition(1)) != null && (si5 = this$0.si(findViewByPosition)) != null) {
            a.f(si5, 0.45614034f, 0.0f, 2, null);
        }
        if (this$0.hi()) {
            QLog.i("Profile to Filament time: ", 1, "start Load Filament");
            this$0.Ui(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ej(boolean show) {
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        FrameLayout frameLayout = aVar.f418564i;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.flNoFriends");
        a.b("FriendsDressUpFragmentDebug", "showOrHideEmptyView, " + show + ", " + frameLayout + ", " + frameLayout.getChildCount() + ", " + Thread.currentThread().getName());
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        aVar3.f418564i.removeAllViews();
        if (show) {
            n74.a aVar4 = this.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar4;
            }
            aVar2.f418564i.addView(Ai());
            return;
        }
        ViewParent parent = Ai().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(Ai());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fj(boolean show) {
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        a.b("FriendsDressUpFragmentDebug", "showErrorView " + show + "  " + aVar.f418564i.getChildCount() + "  thread " + Thread.currentThread().getName());
        if (getContext() == null) {
            return;
        }
        if (show) {
            n74.a aVar3 = this.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            aVar3.f418564i.removeAllViews();
            n74.a aVar4 = this.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar4;
            }
            aVar2.f418564i.addView(Bi());
            return;
        }
        ViewParent parent = Bi().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(Bi());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gj(boolean show) {
        a.b("FriendsDressUpFragmentDebug", "showOrHideLoading " + show + " ");
        if (show) {
            Gi().show();
        } else {
            Gi().dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hi() {
        boolean d16 = FilamentApiImpl.f369933a.d();
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase();
        a.b("FriendsDressUpFragmentDebug", "canUseFilament, filamentEnable=" + d16 + ", zplanEnable=" + enableZPlanFilamentBase + ", useFilament=" + f370482f0);
        return d16 && enableZPlanFilamentBase && f370482f0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hj() {
        Map<String, Object> mutableMapOf;
        n74.a aVar = null;
        if (Pi()) {
            n74.a aVar2 = this.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            aVar2.f418578w.setVisibility(0);
            if (!Qi()) {
                n74.a aVar3 = this.binding;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar3 = null;
                }
                aVar3.f418578w.setVisibility(8);
            }
            n74.a aVar4 = this.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar4 = null;
            }
            aVar4.f418576u.setVisibility(8);
            n74.a aVar5 = this.binding;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar5 = null;
            }
            if (aVar5.f418578w.getVisibility() != 0 || this.isSmallHomeImpReported) {
                return;
            }
            this.isSmallHomeImpReported = true;
            id3.d dVar = this.dtReporter;
            n74.a aVar6 = this.binding;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar6;
            }
            RelativeLayout relativeLayout = aVar.f418578w;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlSmallhome");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", jj("")));
            dVar.c("imp", relativeLayout, mutableMapOf);
            return;
        }
        n74.a aVar7 = this.binding;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar7 = null;
        }
        aVar7.f418578w.setVisibility(8);
        n74.a aVar8 = this.binding;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar8 = null;
        }
        aVar8.f418576u.setVisibility(8);
        if (ZPlanQQMC.INSTANCE.enableFriendsDressUpMiniAio()) {
            n74.a aVar9 = this.binding;
            if (aVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar9;
            }
            aVar.f418576u.setVisibility(0);
        }
    }

    private final void ii() {
        FilamentNativeAppHelper filamentNativeAppHelper;
        if (getContext() == null || PadUtil.a(requireContext()) != DeviceType.TABLET || (filamentNativeAppHelper = this.filamentRef.get()) == null) {
            return;
        }
        n74.a aVar = this.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        filamentNativeAppHelper.y(aVar.f418563h.getWidth(), ScreenUtils.getScreenHeight(requireContext()), Ji());
    }

    private final String ij(String originURL, String friendUin) {
        if (!(originURL.length() == 0)) {
            if (!(friendUin.length() == 0)) {
                Bundle bundle = new Bundle();
                bundle.putString("friendUin", friendUin);
                return ((IZPlanApi) QRoute.api(IZPlanApi.class)).appendPageDataToScheme(originURL, bundle);
            }
        }
        QLog.e("FriendsDressUpFragmentDebug", 1, "updateSchemeURLWithUin failed, scheme or friendUin invalid.");
        return originURL;
    }

    private final void ji() {
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f418581z.setAdapter(null);
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        aVar3.f418581z.removeAllViews();
        x84.e eVar = this.avatarAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar = null;
        }
        this.avatarAdapter = eVar.k0();
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar4 = null;
        }
        RecyclerView recyclerView = aVar4.f418581z;
        x84.e eVar2 = this.avatarAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar2 = null;
        }
        recyclerView.setAdapter(eVar2);
        n74.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar5;
        }
        aVar2.f418581z.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.i
            @Override // java.lang.Runnable
            public final void run() {
                FriendsDressUpFragment.ki(FriendsDressUpFragment.this);
            }
        });
    }

    private final String jj(String uin) {
        String l3;
        if (!(uin.length() == 0)) {
            return uin;
        }
        Long Fi = Fi();
        return (Fi == null || (l3 = Fi.toString()) == null) ? "" : l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(FriendsDressUpFragment this$0) {
        View findViewByPosition;
        View si5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = this$0.curPosition + 1;
        n74.a aVar = this$0.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        RecyclerView recyclerView = aVar.f418581z;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.ryAvatar");
        Integer c16 = a.c(recyclerView);
        if (c16 != null) {
            int intValue = i3 - c16.intValue();
            n74.a aVar2 = this$0.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            RecyclerView recyclerView2 = aVar2.f418581z;
            x84.e eVar = this$0.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            recyclerView2.smoothScrollBy(eVar.l0() * intValue, 0);
            if (intValue == 0) {
                n74.a aVar3 = this$0.binding;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    aVar3 = null;
                }
                RecyclerView.LayoutManager layoutManager = aVar3.f418581z.getLayoutManager();
                if (layoutManager != null && (findViewByPosition = layoutManager.findViewByPosition(i3)) != null && (si5 = this$0.si(findViewByPosition)) != null) {
                    a.h(si5, 1.4561403f, 0.0f, 2, null);
                }
            }
        }
        this$0.ii();
    }

    private final void mi() {
        Long Fi;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || (Fi = Fi()) == null) {
            return;
        }
        long longValue = Fi.longValue();
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).checkSmallHomeVisitPermission(appInterface, String.valueOf(longValue), 3, new c());
        ((IVasZplanAIOSmallHomeService) QRoute.api(IVasZplanAIOSmallHomeService.class)).requestEntranceInfoV2(longValue, new FriendsDressUpFragment$checkVisitAuth$2(this));
        ((IMiniHomeConnectedApi) QRoute.api(IMiniHomeConnectedApi.class)).showEntrance(longValue, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.FriendsDressUpFragment$checkVisitAuth$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                FriendsDressUpFragment.this.isShowSmallHome = z16;
                FriendsDressUpFragment.this.hj();
            }
        });
    }

    private final t ni() {
        String str;
        String str2;
        int i3;
        AppRuntime peekAppRuntime;
        String currentUin;
        t tVar = new t();
        Bundle arguments = getArguments();
        String str3 = "";
        if (arguments == null || (str = arguments.getString("uin", "")) == null) {
            str = "";
        }
        tVar.e(str);
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("nick", "")) == null) {
            str2 = "";
        }
        tVar.c(str2);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i3 = Integer.valueOf(arguments3.getInt("sex", 2));
        } else {
            i3 = 2;
        }
        tVar.d(i3);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (currentUin = peekAppRuntime.getCurrentUin()) != null) {
            str3 = currentUin;
        }
        tVar.b(str3);
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi() {
        if (Pi()) {
            qi();
            return;
        }
        a.b("FriendsDressUpFragmentDebug", "fetchFirstPageData");
        gj(true);
        zi().r(new e());
    }

    private final void qi() {
        a.b("FriendsDressUpFragmentDebug", "isGuestFriendDressUp");
        mi();
        Long Fi = Fi();
        if (Fi != null) {
            long longValue = Fi.longValue();
            gj(true);
            zi().s(longValue, new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        zi().t(new g());
    }

    private final View si(View view) {
        x84.e eVar = this.avatarAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
            eVar = null;
        }
        return view.findViewById(eVar.getScaleViewId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti(int position) {
        n74.a aVar = this.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f418581z.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.c
            @Override // java.lang.Runnable
            public final void run() {
                FriendsDressUpFragment.ui(FriendsDressUpFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(FriendsDressUpFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        n74.a aVar = this$0.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        RecyclerView recyclerView = aVar.f418581z;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.ryAvatar");
        View d16 = a.d(recyclerView);
        if (d16 != null) {
            int left = d16.getLeft() + (d16.getWidth() / 2);
            n74.a aVar3 = this$0.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            int width = aVar3.f418581z.getWidth() / 2;
            int i3 = left - width;
            a.a("FriendsDressUpFragmentDebug", " childCenterX " + left + "  standerX " + width + ",   detailX " + i3);
            if (i3 != 0) {
                n74.a aVar4 = this$0.binding;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    aVar2 = aVar4;
                }
                aVar2.f418581z.scrollBy(i3, 0);
            }
        }
    }

    private final AlphaAnimation vi() {
        return (AlphaAnimation) this.alphaAnim.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> wi() {
        return (Map) this.avatarReportParamNotSlide.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> xi() {
        return (Map) this.avatarReportParamSlide.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source yi() {
        Source current;
        FragmentSource Di = Di();
        return (Di == null || (current = Di.getCurrent()) == null) ? Source.UnSet : current;
    }

    private final DataSource zi() {
        return (DataSource) this.dataSource.getValue();
    }

    public final String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_FRIENDS_DRESS_UP;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i3 = this.oldScreenDpSize;
        int i16 = newConfig.screenWidthDp;
        if (i3 != i16) {
            a.b("FriendsDressUpFragmentDebug", "onConfigurationChanged, newWidth=" + i16 + ", oldWidth=" + i3);
            ji();
            this.oldScreenDpSize = newConfig.screenWidthDp;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        n74.a g16 = n74.a.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        FragmentActivity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            com.tencent.sqshow.zootopia.utils.a.a(qBaseActivity);
            com.tencent.sqshow.zootopia.utils.r.c(qBaseActivity.getWindow());
        }
        this.binding = g16;
        ConstraintLayout mRv = g16.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        return mRv;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        Map<String, Object> mutableMapOf3;
        super.onDestroy();
        zi().x();
        FilamentNativeAppHelper filamentNativeAppHelper = this.filamentRef.get();
        if (filamentNativeAppHelper != null) {
            filamentNativeAppHelper.r();
        }
        FriendsDressLikeManager friendsDressLikeManager = this.friendsLikeManager;
        n74.a aVar = null;
        if (friendsDressLikeManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsLikeManager");
            friendsDressLikeManager = null;
        }
        friendsDressLikeManager.E();
        id3.d dVar = this.dtReporter;
        n74.a aVar2 = this.binding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar2 = null;
        }
        RelativeLayout relativeLayout = aVar2.f418577v;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlSamestyle");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", jj("")));
        dVar.c("imp_end", relativeLayout, mutableMapOf);
        id3.d dVar2 = this.dtReporter;
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        RelativeLayout relativeLayout2 = aVar3.f418576u;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.rlMiniaio");
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", jj("")));
        dVar2.c("imp_end", relativeLayout2, mutableMapOf2);
        id3.d dVar3 = this.dtReporter;
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar = aVar4;
        }
        RelativeLayout relativeLayout3 = aVar.f418578w;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.rlSmallhome");
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_to_uin", jj("")));
        dVar3.c("imp_end", relativeLayout3, mutableMapOf3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Gi().dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(requireContext());
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        ViewGroup.LayoutParams layoutParams = aVar.C.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = statusBarHeight;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.avatarAdapter = new x84.e(requireContext);
        if (!hi()) {
            n74.a aVar3 = this.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            aVar3.f418579x.setVisibility(0);
            n74.a aVar4 = this.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar4 = null;
            }
            aVar4.f418563h.setVisibility(8);
            Li();
        }
        Ni();
        this.oldScreenDpSize = requireContext().getResources().getConfiguration().screenWidthDp;
        n74.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar5 = null;
        }
        aVar5.f418561f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FriendsDressUpFragment.Vi(FriendsDressUpFragment.this, view2);
            }
        });
        n74.a aVar6 = this.binding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar6 = null;
        }
        aVar6.f418573r.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FriendsDressUpFragment.Wi(FriendsDressUpFragment.this, view2);
            }
        });
        n74.a aVar7 = this.binding;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar7 = null;
        }
        aVar7.f418577v.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FriendsDressUpFragment.Xi(FriendsDressUpFragment.this, view2);
            }
        });
        n74.a aVar8 = this.binding;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar8 = null;
        }
        aVar8.f418576u.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FriendsDressUpFragment.Yi(FriendsDressUpFragment.this, view2);
            }
        });
        n74.a aVar9 = this.binding;
        if (aVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar9 = null;
        }
        aVar9.f418560e.setListener(new n());
        n74.a aVar10 = this.binding;
        if (aVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar10 = null;
        }
        aVar10.f418578w.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FriendsDressUpFragment.Zi(FriendsDressUpFragment.this, view2);
            }
        });
        n74.a aVar11 = this.binding;
        if (aVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar11;
        }
        RelativeLayout relativeLayout = aVar2.f418575t;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlLike");
        this.friendsLikeManager = new FriendsDressLikeManager(relativeLayout, this);
        this.commonData = ni();
        initDtReport();
        pi();
        Ki();
    }

    private final float Ji() {
        int[] iArr = new int[2];
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.f418563h.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        aVar3.f418581z.getLocationOnScreen(iArr2);
        int i16 = iArr2[1];
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar4;
        }
        return ((i16 + (aVar2.f418581z.getHeight() / 3)) - i3) / ScreenUtils.getScreenHeight(requireContext());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$g", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "result", "e", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements com.tencent.mobileqq.zootopia.d<FriendsRespData> {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(FriendsDressUpFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            x84.e eVar = this$0.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            eVar.p0(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(FriendsDressUpFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            x84.e eVar = this$0.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            eVar.p0(false);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(FriendsRespData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!result.a().isEmpty()) {
                x84.e eVar = FriendsDressUpFragment.this.avatarAdapter;
                RollingFrameViewGroup.a aVar = null;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar = null;
                }
                eVar.j0(result.a());
                FriendsDressLikeManager friendsDressLikeManager = FriendsDressUpFragment.this.friendsLikeManager;
                if (friendsDressLikeManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendsLikeManager");
                    friendsDressLikeManager = null;
                }
                friendsDressLikeManager.z(result.a());
                if (FriendsDressUpFragment.this.hi()) {
                    return;
                }
                RollingFrameViewGroup.a aVar2 = FriendsDressUpFragment.this.rollingAdapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rollingAdapter");
                } else {
                    aVar = aVar2;
                }
                aVar.c();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.d
        public void y() {
            n74.a aVar = FriendsDressUpFragment.this.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            RecyclerView recyclerView = aVar.f418581z;
            final FriendsDressUpFragment friendsDressUpFragment = FriendsDressUpFragment.this;
            recyclerView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.s
                @Override // java.lang.Runnable
                public final void run() {
                    FriendsDressUpFragment.g.d(FriendsDressUpFragment.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.d
        public void z() {
            a.b("FriendsDressUpFragmentDebug", " beforeRequest");
            n74.a aVar = FriendsDressUpFragment.this.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            RecyclerView recyclerView = aVar.f418581z;
            final FriendsDressUpFragment friendsDressUpFragment = FriendsDressUpFragment.this;
            recyclerView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.r
                @Override // java.lang.Runnable
                public final void run() {
                    FriendsDressUpFragment.g.c(FriendsDressUpFragment.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToastUtil.showQQToast(R.string.xp6);
        }
    }

    private final void initDtReport() {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, Ci()), TuplesKt.to("zplan_to_uin", jj("")), TuplesKt.to("zplan_page_source", Integer.valueOf(f370483g0)));
        id3.d dVar = this.dtReporter;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        ConstraintLayout mRv = aVar.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        dVar.j(requireActivity, mRv, "pg_zplan_friend_dressup", hashMapOf);
        id3.d dVar2 = this.dtReporter;
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        RelativeLayout relativeLayout = aVar3.f418573r;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlBuy");
        id3.d.i(dVar2, relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_SMAE_STYLE, new LinkedHashMap(), false, true, null, false, false, 224, null);
        id3.d dVar3 = this.dtReporter;
        n74.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar4 = null;
        }
        RelativeLayout relativeLayout2 = aVar4.f418577v;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.rlSamestyle");
        id3.d.i(dVar3, relativeLayout2, "em_zplan_avatar_photo", new LinkedHashMap(), false, true, null, false, false, 224, null);
        id3.d dVar4 = this.dtReporter;
        n74.a aVar5 = this.binding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar5 = null;
        }
        RelativeLayout relativeLayout3 = aVar5.f418576u;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.rlMiniaio");
        id3.d.i(dVar4, relativeLayout3, "em_zplan_chat_entrance", new LinkedHashMap(), false, true, null, false, false, 224, null);
        id3.d dVar5 = this.dtReporter;
        n74.a aVar6 = this.binding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar6 = null;
        }
        ImageView imageView = aVar6.f418561f;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backIgv");
        id3.d.i(dVar5, imageView, "em_zplan_back_btn", new LinkedHashMap(), false, true, null, false, false, 224, null);
        id3.d dVar6 = this.dtReporter;
        n74.a aVar7 = this.binding;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar7 = null;
        }
        RollingFrameViewGroup rollingFrameViewGroup = aVar7.f418579x;
        Intrinsics.checkNotNullExpressionValue(rollingFrameViewGroup, "binding.rollFrameViewGroup");
        id3.d.i(dVar6, rollingFrameViewGroup, "em_zplan_avatar_dressup", new LinkedHashMap(), false, false, null, false, false, 224, null);
        id3.d dVar7 = this.dtReporter;
        n74.a aVar8 = this.binding;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar8 = null;
        }
        RecyclerView recyclerView = aVar8.f418581z;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.ryAvatar");
        id3.d.i(dVar7, recyclerView, "em_zplan_avatar_dressup", new LinkedHashMap(), false, false, null, false, false, 224, null);
        id3.d dVar8 = this.dtReporter;
        n74.a aVar9 = this.binding;
        if (aVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar9 = null;
        }
        RelativeLayout relativeLayout4 = aVar9.f418578w;
        Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.rlSmallhome");
        id3.d.i(dVar8, relativeLayout4, "em_zplan_go_xiaowo", new LinkedHashMap(), false, false, null, false, false, 224, null);
        id3.d dVar9 = this.dtReporter;
        n74.a aVar10 = this.binding;
        if (aVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar10;
        }
        RelativeLayout relativeLayout5 = aVar2.f418575t;
        Intrinsics.checkNotNullExpressionValue(relativeLayout5, "binding.rlLike");
        id3.d.i(dVar9, relativeLayout5, "em_zplan_thumbs", new LinkedHashMap(), false, false, null, false, false, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(int position) {
        if (position == -1) {
            return;
        }
        a.b("FriendsDressUpFragmentDebug", " changeVp " + position);
        this.curPosition = position;
        FriendsDressLikeManager friendsDressLikeManager = this.friendsLikeManager;
        n74.a aVar = null;
        if (friendsDressLikeManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendsLikeManager");
            friendsDressLikeManager = null;
        }
        friendsDressLikeManager.M(position);
        if (!hi()) {
            n74.a aVar2 = this.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar2;
            }
            aVar.f418579x.A(position);
            return;
        }
        vi().setAnimationListener(new b(position));
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar = aVar3;
        }
        aVar.f418563h.startAnimation(vi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(int dx5) {
        View findViewByPosition;
        View si5;
        View si6;
        int i3;
        int i16;
        View findViewByPosition2;
        View si7;
        View si8;
        n74.a aVar = this.binding;
        n74.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        float width = aVar.f418581z.getWidth() / 2.0f;
        n74.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar3 = null;
        }
        float height = aVar3.f418581z.getHeight() / 2.0f;
        a.a("FriendsDressUpFragmentDebug", " ryAvatar scroll " + dx5);
        if (dx5 > 0) {
            x84.e eVar = this.avatarAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar = null;
            }
            float l06 = width - (eVar.l0() / 2);
            n74.a aVar4 = this.binding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar4 = null;
            }
            View findChildViewUnder = aVar4.f418581z.findChildViewUnder(l06, height);
            if (findChildViewUnder == null) {
                return;
            }
            n74.a aVar5 = this.binding;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar5 = null;
            }
            RecyclerView.LayoutManager layoutManager = aVar5.f418581z.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager);
            int position = layoutManager.getPosition(findChildViewUnder);
            View si9 = si(findChildViewUnder);
            if (si9 != null) {
                float left = l06 - findChildViewUnder.getLeft();
                x84.e eVar2 = this.avatarAdapter;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar2 = null;
                }
                float l07 = 1.4561403f - ((left / eVar2.l0()) * 0.45614034f);
                a.a("FriendsDressUpFragmentDebug", " " + position + " needScale " + l07);
                a.h(si9, l07, 0.0f, 2, null);
            }
            n74.a aVar6 = this.binding;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar6 = null;
            }
            RecyclerView.LayoutManager layoutManager2 = aVar6.f418581z.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2);
            int i17 = position + 1;
            View findViewByPosition3 = layoutManager2.findViewByPosition(i17);
            if (findViewByPosition3 != null && (si8 = si(findViewByPosition3)) != null) {
                x84.e eVar3 = this.avatarAdapter;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar3 = null;
                }
                float l08 = (width + (eVar3.l0() / 2)) - findViewByPosition3.getLeft();
                x84.e eVar4 = this.avatarAdapter;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar4 = null;
                }
                float l09 = ((l08 / eVar4.l0()) * 0.45614034f) + 1;
                a.a("FriendsDressUpFragmentDebug", i17 + " needScale " + l09);
                a.h(si8, l09, 0.0f, 2, null);
            }
            n74.a aVar7 = this.binding;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar7 = null;
            }
            RecyclerView.LayoutManager layoutManager3 = aVar7.f418581z.getLayoutManager();
            if (layoutManager3 != null && (findViewByPosition2 = layoutManager3.findViewByPosition(position - 1)) != null && (si7 = si(findViewByPosition2)) != null) {
                si7.setScaleX(1.0f);
                si7.setScaleY(1.0f);
            }
        } else if (dx5 < 0) {
            x84.e eVar5 = this.avatarAdapter;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                eVar5 = null;
            }
            float l010 = (eVar5.l0() / 2) + width;
            n74.a aVar8 = this.binding;
            if (aVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar8 = null;
            }
            View findChildViewUnder2 = aVar8.f418581z.findChildViewUnder(l010, height);
            if (findChildViewUnder2 == null) {
                return;
            }
            n74.a aVar9 = this.binding;
            if (aVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar9 = null;
            }
            RecyclerView.LayoutManager layoutManager4 = aVar9.f418581z.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager4);
            int position2 = layoutManager4.getPosition(findChildViewUnder2);
            View si10 = si(findChildViewUnder2);
            if (si10 != null) {
                x84.e eVar6 = this.avatarAdapter;
                if (eVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar6 = null;
                }
                float left2 = findChildViewUnder2.getLeft() - (width - (eVar6.l0() / 2));
                x84.e eVar7 = this.avatarAdapter;
                if (eVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar7 = null;
                }
                float l011 = 1.4561403f - ((left2 / eVar7.l0()) * 0.45614034f);
                a.a("FriendsDressUpFragmentDebug", position2 + " needScale " + l011);
                a.h(si10, l011, 0.0f, 2, null);
            }
            n74.a aVar10 = this.binding;
            if (aVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar10 = null;
            }
            RecyclerView.LayoutManager layoutManager5 = aVar10.f418581z.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager5);
            int i18 = position2 - 1;
            View findViewByPosition4 = layoutManager5.findViewByPosition(i18);
            if (findViewByPosition4 != null && (si6 = si(findViewByPosition4)) != null) {
                x84.e eVar8 = this.avatarAdapter;
                if (eVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar8 = null;
                }
                float left3 = (findViewByPosition4.getLeft() + findViewByPosition4.getWidth()) - (width - (eVar8.l0() / 2));
                x84.e eVar9 = this.avatarAdapter;
                if (eVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("avatarAdapter");
                    eVar9 = null;
                }
                float l012 = ((left3 / eVar9.l0()) * 0.45614034f) + 1;
                a.a("FriendsDressUpFragmentDebug", i18 + " needScale " + l012);
                a.h(si6, l012, 0.0f, 2, null);
            }
            n74.a aVar11 = this.binding;
            if (aVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar11 = null;
            }
            RecyclerView.LayoutManager layoutManager6 = aVar11.f418581z.getLayoutManager();
            if (layoutManager6 != null && (findViewByPosition = layoutManager6.findViewByPosition(position2 + 1)) != null && (si5 = si(findViewByPosition)) != null) {
                si5.setScaleX(1.0f);
                si5.setScaleY(1.0f);
            }
        }
        if (dx5 != 0) {
            n74.a aVar12 = this.binding;
            if (aVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar12;
            }
            RecyclerView recyclerView = aVar2.f418581z;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.ryAvatar");
            Integer c16 = a.c(recyclerView);
            if (c16 != null) {
                i16 = c16.intValue();
                i3 = 1;
            } else {
                i3 = 1;
                i16 = 1;
            }
            bj(i16 - i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Si(final FriendsDressUpData data, final View itemView, final int position) {
        itemView.setTag(Integer.valueOf(position));
        RelativeLayout relativeLayout = (RelativeLayout) itemView.findViewById(R.id.pb5);
        relativeLayout.setVisibility(8);
        ((TextView) relativeLayout.findViewById(R.id.pso)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendsDressUpFragment.Ti(FriendsDressUpFragment.this, data, itemView, position, view);
            }
        });
        ImageView imageView = (ImageView) itemView.findViewById(R.id.q6e);
        imageView.setVisibility(8);
        imageView.clearAnimation();
        ImageView imageView2 = (ImageView) itemView.findViewById(R.id.q3u);
        URLDrawable uRLDrawable = null;
        imageView2.setImageDrawable(null);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        try {
            uRLDrawable = URLDrawable.getDrawable(new URL(data.getMaterialUrl()), obtain);
        } catch (Exception unused) {
            QLog.e("FriendsDressUpFragmentDebug", 1, "data materialUrl Exception " + data);
        }
        if (uRLDrawable == null) {
            return;
        }
        int status = uRLDrawable.getStatus();
        if (status == 1) {
            imageView2.setImageDrawable(uRLDrawable);
            return;
        }
        imageView.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(-1);
        imageView.startAnimation(rotateAnimation);
        imageView2.setImageDrawable(uRLDrawable);
        uRLDrawable.setURLDrawableListener(new m(itemView, position, relativeLayout, imageView));
        if (status == 2) {
            uRLDrawable.restartDownload();
        } else {
            uRLDrawable.startDownload();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$f", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "result", "", "b", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements com.tencent.mobileqq.zootopia.d<FriendsRespData> {
        f() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(FriendsRespData result) {
            Intrinsics.checkNotNullParameter(result, "result");
            FriendsDressUpFragment.this.gj(false);
            if (result.a().isEmpty()) {
                FriendsDressUpFragment.this.ej(true);
                return;
            }
            FriendsDressUpFragment.this.cj(result.a());
            n74.a aVar = FriendsDressUpFragment.this.binding;
            FriendsDressLikeManager friendsDressLikeManager = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            aVar.f418581z.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.q
                @Override // java.lang.Runnable
                public final void run() {
                    FriendsDressUpFragment.f.c();
                }
            });
            FriendsDressLikeManager friendsDressLikeManager2 = FriendsDressUpFragment.this.friendsLikeManager;
            if (friendsDressLikeManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendsLikeManager");
            } else {
                friendsDressLikeManager = friendsDressLikeManager2;
            }
            friendsDressLikeManager.H(result.a(), result.getVipMaxVote(), result.getVipFriendsMaxVotesNotice());
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            FriendsDressUpFragment.this.gj(false);
            a.b("FriendsDressUpFragmentDebug", "getFirstPage fail");
            FriendsDressUpFragment.this.fj(true);
        }

        @Override // com.tencent.mobileqq.zootopia.d
        public void y() {
            d.a.b(this);
        }

        @Override // com.tencent.mobileqq.zootopia.d
        public void z() {
            d.a.a(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f370489e;

        b(int i3) {
            this.f370489e = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FriendsDressUpFragment.this.Ui(this.f370489e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/FriendsDressUpFragment$m", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class m implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f370503d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f370504e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f370505f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ImageView f370506h;

        m(View view, int i3, RelativeLayout relativeLayout, ImageView imageView) {
            this.f370503d = view;
            this.f370504e = i3;
            this.f370505f = relativeLayout;
            this.f370506h = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            if (!Intrinsics.areEqual(this.f370503d.getTag(), Integer.valueOf(this.f370504e))) {
                a.b("FriendsDressUpFragmentDebug", "loadAvatar, onLoadFialed, newestPos=" + this.f370503d.getTag() + ", curReqPos=" + this.f370504e);
                return;
            }
            this.f370505f.setVisibility(0);
            this.f370506h.clearAnimation();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            if (!Intrinsics.areEqual(this.f370503d.getTag(), Integer.valueOf(this.f370504e))) {
                a.b("FriendsDressUpFragmentDebug", "loadAvatar, onLoadSuccessed, newestPos=" + this.f370503d.getTag() + ", curReqPos=" + this.f370504e);
                return;
            }
            this.f370505f.setVisibility(8);
            this.f370506h.setVisibility(8);
            this.f370506h.clearAnimation();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }
}
