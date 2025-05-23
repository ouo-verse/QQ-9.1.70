package com.tencent.mobileqq.vas.group;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.data.SmallHomeInfo;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.portal.detail.ah;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.state.report.SquareReportConst;
import fi3.bb;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001f\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0082\u0001B\b\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J>\u0010+\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020%2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/H\u0002J\b\u00102\u001a\u00020\u000bH\u0002J&\u00108\u001a\u00020\u000b2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b06H\u0002J\b\u00109\u001a\u00020\u000bH\u0002J\b\u0010:\u001a\u00020\u000bH\u0002J\b\u0010;\u001a\u00020\u000bH\u0002J\u0018\u0010>\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u0010?\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/H\u0002J\b\u0010@\u001a\u00020\u000fH\u0002J\b\u0010A\u001a\u00020\u000bH\u0002J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u0014H\u0002J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001dH\u0002J\b\u0010E\u001a\u00020\u000bH\u0002J\u0018\u0010I\u001a\u00020H2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020FH\u0002J\b\u0010J\u001a\u00020\u000bH\u0002R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001b\u0010s\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u001b\u0010x\u001a\u00020t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bu\u0010p\u001a\u0004\bv\u0010wR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020z0y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010{R\u001a\u0010~\u001a\b\u0012\u0004\u0012\u0002030y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010{\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getSubSource", "", "onBackPressedEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "zi", "Ri", "", WidgetCacheConstellationData.INTERVAL, "Gi", "Ei", "Li", WidgetCacheLunarData.YI, "xi", "hi", "ranking", "", "troopUin", "li", "Ci", "uin", "ni", "ii", "qi", "Landroid/widget/ImageView;", "url", "defaultRes", "width", "height", "clipCircle", "Mi", "wi", "si", SensorJsPlugin.SENSOR_INTERVAL_UI, "Lcom/tencent/mobileqq/vas/data/e;", "pageInfo", "Qi", "Si", "", "from", "to", "Lkotlin/Function0;", "callback", "Ti", "Ji", "Hi", "Vi", "Lcom/tencent/mobileqq/vas/data/d;", "homeInfo", "Pi", "Fi", "ci", "initReport", NodeProps.VISIBLE, "Oi", "fi", "di", "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Lcom/tencent/mobileqq/vas/group/ZplanVasDownloadButtonListener;", "Ai", "finishActivity", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "N", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "transitPageInfo", "Lfi3/bb;", "P", "Lfi3/bb;", "binding", "Lq03/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lq03/f;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mDecoder", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "T", "Z", "fullScreenMode", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "U", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "com/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$c", "V", "Lcom/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$c;", "apngLis", "Lid3/d;", "W", "Lid3/d;", "reportHelper", "Lcom/tencent/mobileqq/vas/group/u;", "X", "Lkotlin/Lazy;", "Di", "()Lcom/tencent/mobileqq/vas/group/u;", "vm", "Loa4/a;", "Y", "Bi", "()Loa4/a;", "mapResVm", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "Landroidx/lifecycle/Observer;", "statusObserver", "a0", "progressObserver", "<init>", "()V", "b0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanVasSmallHomeGroupFragment extends ZootopiaBaseFragment {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: N, reason: from kotlin metadata */
    private TransitPageInfo transitPageInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private bb binding;

    /* renamed from: Q, reason: from kotlin metadata */
    private q03.f config;

    /* renamed from: R, reason: from kotlin metadata */
    private IFaceDecoder mDecoder;

    /* renamed from: S, reason: from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean fullScreenMode;

    /* renamed from: U, reason: from kotlin metadata */
    private final MMKVOptionEntity entity;

    /* renamed from: V, reason: from kotlin metadata */
    private final c apngLis;

    /* renamed from: W, reason: from kotlin metadata */
    private final id3.d reportHelper;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy mapResVm;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Observer<Float> progressObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0014\u0010 \u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010#\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0016R\u0014\u0010$\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0014\u0010%\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$a;", "", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment;", "a", "Landroid/content/Context;", "context", "", "b", "", "BG_PADDING", UserInfo.SEX_FEMALE, "", "DURATION", "J", "FIRST_END_ANGLE", "FIRST_START_ANGLE", "", "IS_CLICK_EDIT_COVER", "Ljava/lang/String;", "LAST_TIPS_SHOW_TIME", "", "MAP_ID", "I", "ONE_DAY", "RADIO", "RANK_HIPPY_URL_PREFIX", "RANK_URL_PREFIX", "SECOND_START_ANGLE", "SMALL_HOME_NAME", "SOURCE", "TAG", "TRANSIT_PAGE_INFO", "UPDATE_ANIM_URL", "VISITOR_URL", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ZplanVasSmallHomeGroupFragment a(TransitPageInfo info, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(source, "source");
            ZplanVasSmallHomeGroupFragment zplanVasSmallHomeGroupFragment = new ZplanVasSmallHomeGroupFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tansit_page_info", info);
            bundle.putSerializable("source", source);
            zplanVasSmallHomeGroupFragment.setArguments(bundle);
            return zplanVasSmallHomeGroupFragment;
        }

        public final void b(Context context, TransitPageInfo info, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(source, "source");
            if (!TransitPageInfo.INSTANCE.a(info)) {
                v.f373305a.c(R.string.xhl, "invalid pageInfo");
                QLog.e("ZplanVasWoGroupFragment", 1, "invalid pageInfo");
            } else {
                Intent intent = new Intent();
                intent.putExtra("tansit_page_info", info);
                intent.putExtra("source", source);
                QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ZplanVasSmallHomeGroupFragment.class);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309327a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ButtonStatus.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f309327a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$c", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "", "p0", "", HippyQQPagView.EventName.ON_PLAY_REPEAT, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ApngDrawable.OnPlayRepeatListener {
        c() {
        }

        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int p06) {
            ZplanVasSmallHomeGroupFragment.this.Hi();
        }
    }

    public ZplanVasSmallHomeGroupFragment() {
        Lazy lazy;
        Lazy lazy2;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        this.entity = from;
        this.apngLis = new c();
        this.reportHelper = new id3.d(null, 1, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<u>() { // from class: com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment$vm$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$vm$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements ViewModelProvider.Factory {
                a() {
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(Class<T> modelClass) {
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    return new u(new t());
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final u invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(ZplanVasSmallHomeGroupFragment.this, new a()).get(u.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026oupViewModel::class.java)");
                return (u) viewModel;
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment$mapResVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(ZplanVasSmallHomeGroupFragment.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResVm = lazy2;
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.vas.group.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanVasSmallHomeGroupFragment.Xi(ZplanVasSmallHomeGroupFragment.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.vas.group.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanVasSmallHomeGroupFragment.Ki(ZplanVasSmallHomeGroupFragment.this, (Float) obj);
            }
        };
    }

    private final ZplanVasDownloadButtonListener Ai(long uin, ZootopiaMapDetail detail) {
        ExtInfo extInfo;
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.None, ZootopiaSource.SUB_SOURCE_GROUP_TRANSIT, null, 4, null);
        }
        ZootopiaSource zootopiaSource2 = zootopiaSource;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        oa4.a Bi = Bi();
        k33.a aVar = k33.a.f411513a;
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        return new ZplanVasDownloadButtonListener(requireContext, uin, detail, Bi, zootopiaSource2, aVar.a((transitPageInfo == null || (extInfo = transitPageInfo.getExtInfo()) == null) ? null : extInfo.getUeExtras(), String.valueOf(uin)));
    }

    private final oa4.a Bi() {
        return (oa4.a) this.mapResVm.getValue();
    }

    private final String Ci(long troopUin) {
        String encode = URLEncoder.encode("/rank-list?source=1&groupId=" + troopUin + "&entrance=group_xiaowo_top3&source=1&tab=2", "utf-8");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tqmeta.vip.qq.com/index.bundle?hippyurl=");
        sb5.append(encode);
        return "mqqapi://hippy/open?" + URLEncoder.encode("bundleName=QQSmallHousePortal&domain=vip.qq.com&isAnimated=true&url=" + URLEncoder.encode(sb5.toString(), "utf-8"), "utf-8");
    }

    private final u Di() {
        return (u) this.vm.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String Ei(View view) {
        MasterInfo masterInfo;
        Long longOrNull;
        MasterInfo masterInfo2;
        Long longOrNull2;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("tansit_page_info") : null;
        TransitPageInfo transitPageInfo = serializable instanceof TransitPageInfo ? (TransitPageInfo) serializable : null;
        if (transitPageInfo == null) {
            return "transitPageInfo";
        }
        this.transitPageInfo = transitPageInfo;
        TransitPageConfig config = transitPageInfo.getConfig();
        boolean z16 = false;
        if (config != null && config.getUiStyle() == 1) {
            z16 = true;
        }
        this.fullScreenMode = z16;
        TransitPageInfo transitPageInfo2 = this.transitPageInfo;
        long longValue = (transitPageInfo2 == null || (masterInfo2 = transitPageInfo2.getMasterInfo()) == null || (r6 = masterInfo2.getUin()) == null || longOrNull2 == null) ? 0L : longOrNull2.longValue();
        if (longValue <= 0) {
            return "uin";
        }
        TransitPageInfo transitPageInfo3 = this.transitPageInfo;
        if (transitPageInfo3 != null && (masterInfo = transitPageInfo3.getMasterInfo()) != null && (r6 = masterInfo.getGroupId()) != null && longOrNull != null) {
            longOrNull.longValue();
        }
        Bundle arguments2 = getArguments();
        Serializable serializable2 = arguments2 != null ? arguments2.getSerializable("source") : null;
        Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.ZootopiaSource");
        this.source = (ZootopiaSource) serializable2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return "app";
        }
        this.config = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getWoTransitPageConfig();
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        Intrinsics.checkNotNullExpressionValue(iQQAvatarService, "app.getRuntimeService(IQ\u2026        .getInstance(app)");
        this.mDecoder = iQQAvatarService;
        Di().Q1(longValue);
        Di().O1(longValue);
        Di().P1();
        Li();
        si();
        ui();
        fi(longValue);
        qi();
        di();
        wi();
        yi();
        return null;
    }

    private final boolean Fi(com.tencent.mobileqq.vas.data.e pageInfo) {
        for (com.tencent.mobileqq.vas.data.c cVar : pageInfo.c()) {
            if (cVar.getChangeType() != 0 && cVar.getOldData() != cVar.getNewData()) {
                return true;
            }
        }
        return false;
    }

    private final boolean Gi(int interval) {
        if (this.entity.decodeBool("isClickEditCoverKey", false)) {
            return false;
        }
        return System.currentTimeMillis() - this.entity.decodeLong("lastTipsShowTime", 0L) > ((long) (interval * 86400000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.group.h
            @Override // java.lang.Runnable
            public final void run() {
                ZplanVasSmallHomeGroupFragment.Ii(ZplanVasSmallHomeGroupFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(final ZplanVasSmallHomeGroupFragment this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bb bbVar = this$0.binding;
        if (bbVar != null && (imageView = bbVar.f399030b) != null) {
            imageView.setImageDrawable(null);
        }
        this$0.Ti(90.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment$onApngFinish$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ZplanVasSmallHomeGroupFragment.this.Vi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ji() {
        bb bbVar;
        ImageView imageView;
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setLoadListener(new e());
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("ZplanVasWoGroupFragment", "https://img.meta.qq.com/smallHomeExtension.png", apngOptions);
        if (apngURLDrawable == null || (bbVar = this.binding) == null || (imageView = bbVar.f399030b) == null) {
            return;
        }
        imageView.setImageDrawable(apngURLDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(ZplanVasSmallHomeGroupFragment this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bb bbVar = this$0.binding;
        if (bbVar == null) {
            return;
        }
        ZootopiaDownloadButton zootopiaDownloadButton = bbVar.f399031c;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zootopiaDownloadButton.setProcess(it.floatValue());
    }

    private final void Li() {
        RoundRelativeLayout roundRelativeLayout;
        bb bbVar = this.binding;
        if (bbVar == null || (roundRelativeLayout = bbVar.f399043o) == null) {
            return;
        }
        roundRelativeLayout.getLayoutParams().height = (int) ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(32.0f)) * 0.42f);
    }

    private final void Mi(ImageView view, String url, int defaultRes, int width, int height, boolean clipCircle) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (width > 0 && height > 0) {
                obtain.mRequestWidth = view.getWidth();
                obtain.mRequestHeight = view.getHeight();
            }
            if (defaultRes != -1) {
                obtain.mFailedDrawable = com.tencent.sqshow.zootopia.utils.q.b(defaultRes);
                obtain.mLoadingDrawable = com.tencent.sqshow.zootopia.utils.q.b(defaultRes);
            }
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (clipCircle && width > 0 && height > 0) {
                drawable.setTag(com.tencent.mobileqq.urldrawable.a.d(width, height));
                drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306335o);
            }
            view.setImageDrawable(drawable);
        } catch (Throwable th5) {
            QLog.e("ZplanVasWoGroupFragment", 1, th5, new Object[0]);
        }
    }

    private final void Oi(int visible) {
        bb bbVar = this.binding;
        if (bbVar == null) {
            return;
        }
        bbVar.f399042n.setVisibility(visible);
        bbVar.f399041m.setVisibility(visible);
        bbVar.f399040l.setVisibility(visible);
        bbVar.f399051w.setVisibility(visible);
        bbVar.A.setVisibility(visible);
        bbVar.f399054z.setVisibility(visible);
        bbVar.f399036h.setVisibility(visible);
        bbVar.f399039k.setVisibility(visible);
    }

    private final void Pi(SmallHomeInfo homeInfo, com.tencent.mobileqq.vas.data.e pageInfo) {
        bb bbVar;
        ImageView imageView;
        if (homeInfo.getVisitors() > 1) {
            bb bbVar2 = this.binding;
            LinearLayout linearLayout = bbVar2 != null ? bbVar2.f399038j : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            String str = homeInfo.getVisitors() + "/" + pageInfo.getMaxVisitorNum();
            bb bbVar3 = this.binding;
            TextView textView = bbVar3 != null ? bbVar3.f399036h : null;
            if (textView != null) {
                textView.setText(str);
            }
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoop(1);
            URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("ZplanVasWoGroupFragment", "http://imgcache.gtimg.cn/mie/act/img/public/202204/m1650879146_maopao@2x.png", apngOptions);
            if (apngURLDrawable == null || (bbVar = this.binding) == null || (imageView = bbVar.f399037i) == null) {
                return;
            }
            imageView.setImageDrawable(apngURLDrawable);
            return;
        }
        bb bbVar4 = this.binding;
        LinearLayout linearLayout2 = bbVar4 != null ? bbVar4.f399038j : null;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(4);
    }

    private final void Qi(com.tencent.mobileqq.vas.data.e pageInfo) {
        ImageView imageView;
        String bgUrl;
        bb bbVar = this.binding;
        if (bbVar == null || (imageView = bbVar.f399045q) == null) {
            return;
        }
        if (TextUtils.isEmpty(pageInfo.getBgUrl())) {
            bgUrl = pageInfo.getDefaultBgUrl();
        } else {
            bgUrl = pageInfo.getBgUrl();
        }
        Ni(this, imageView, bgUrl, R.drawable.i86, 0, 0, false, 56, null);
    }

    private final void Ri() {
        com.tencent.mobileqq.vas.data.e value;
        LiveData<ButtonStatus> P1 = Bi().P1("200001");
        if ((P1 != null ? P1.getValue() : null) == ButtonStatus.LOADED && (value = Di().N1().getValue()) != null && Gi(value.getBubbleInterval())) {
            this.entity.encodeLong("lastTipsShowTime", System.currentTimeMillis());
        }
    }

    private final void Si() {
        SmallHomeInfo value;
        com.tencent.mobileqq.vas.data.e value2;
        Object obj;
        Object obj2;
        Object valueOf;
        Object valueOf2;
        bb bbVar = this.binding;
        if (bbVar == null || (value = Di().M1().getValue()) == null || (value2 = Di().N1().getValue()) == null || value.getSquareCnt() <= 0) {
            return;
        }
        Oi(0);
        Pi(value, value2);
        bbVar.A.setText(String.valueOf(value.getLikeCnt()));
        bbVar.f399054z.setText(String.valueOf(value.getFurnitureCnt()));
        if (Fi(value2) && ci()) {
            Iterator<T> it = value2.c().iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (((com.tencent.mobileqq.vas.data.c) obj2).getChangeType() == 2) {
                        break;
                    }
                }
            }
            com.tencent.mobileqq.vas.data.c cVar = (com.tencent.mobileqq.vas.data.c) obj2;
            if (cVar != null) {
                valueOf = Long.valueOf(cVar.getOldData());
            } else {
                valueOf = Integer.valueOf(value.getSquareCnt());
            }
            Iterator<T> it5 = value2.c().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((com.tencent.mobileqq.vas.data.c) next).getChangeType() == 1) {
                    obj = next;
                    break;
                }
            }
            com.tencent.mobileqq.vas.data.c cVar2 = (com.tencent.mobileqq.vas.data.c) obj;
            if (cVar2 != null) {
                valueOf2 = Long.valueOf(cVar2.getOldData());
            } else {
                valueOf2 = Integer.valueOf(value.getRoomCnt());
            }
            bbVar.f399051w.setText(valueOf + "\u5e73\u7c73 " + valueOf2 + "\u623f");
            Ti(360.0f, 270.0f, new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment$showSmallHomeNumInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    ZplanVasSmallHomeGroupFragment.this.Ji();
                }
            });
            return;
        }
        bbVar.f399051w.setText(value.getSquareCnt() + "\u5e73\u7c73 " + value.getRoomCnt() + "\u623f");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(ZplanVasSmallHomeGroupFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        bb bbVar = this$0.binding;
        LinearLayout linearLayout = bbVar != null ? bbVar.f399035g : null;
        if (linearLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        linearLayout.setRotationX(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vi() {
        SmallHomeInfo value;
        Object obj;
        Object obj2;
        int squareCnt;
        int roomCnt;
        com.tencent.mobileqq.vas.data.e value2 = Di().N1().getValue();
        if (value2 == null || (value = Di().M1().getValue()) == null) {
            return;
        }
        Iterator<T> it = value2.c().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (((com.tencent.mobileqq.vas.data.c) obj2).getChangeType() == 2) {
                    break;
                }
            }
        }
        com.tencent.mobileqq.vas.data.c cVar = (com.tencent.mobileqq.vas.data.c) obj2;
        if (cVar != null) {
            squareCnt = (int) cVar.getOldData();
        } else {
            squareCnt = value.getSquareCnt();
        }
        final int i3 = squareCnt;
        Iterator<T> it5 = value2.c().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((com.tencent.mobileqq.vas.data.c) next).getChangeType() == 1) {
                obj = next;
                break;
            }
        }
        com.tencent.mobileqq.vas.data.c cVar2 = (com.tencent.mobileqq.vas.data.c) obj;
        if (cVar2 != null) {
            roomCnt = (int) cVar2.getOldData();
        } else {
            roomCnt = value.getRoomCnt();
        }
        final int i16 = roomCnt;
        final long squareCnt2 = value.getSquareCnt() - i3;
        final int roomCnt2 = value.getRoomCnt() - i16;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.vas.group.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZplanVasSmallHomeGroupFragment.Wi(i3, squareCnt2, i16, roomCnt2, this, valueAnimator);
            }
        });
        ofFloat.addListener(new g(value, this));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(int i3, long j3, int i16, int i17, ZplanVasSmallHomeGroupFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        String str = ((int) (i3 + (((float) j3) * floatValue))) + "\u5e73\u7c73 " + ((int) (i16 + (i17 * floatValue))) + "\u623f";
        bb bbVar = this$0.binding;
        TextView textView = bbVar != null ? bbVar.f399051w : null;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(ZplanVasSmallHomeGroupFragment this$0, ButtonStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bb bbVar = this$0.binding;
        if (bbVar == null) {
            return;
        }
        ZootopiaDownloadButton zootopiaDownloadButton = bbVar.f399031c;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zootopiaDownloadButton.setStatus(it);
        int i3 = b.f309327a[it.ordinal()];
        q03.f fVar = null;
        if (i3 == 1) {
            TextView textView = bbVar.f399052x;
            q03.f fVar2 = this$0.config;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            } else {
                fVar = fVar2;
            }
            textView.setText(fVar.h());
            return;
        }
        if (i3 == 2) {
            TextView textView2 = bbVar.f399052x;
            q03.f fVar3 = this$0.config;
            if (fVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            } else {
                fVar = fVar3;
            }
            textView2.setText(fVar.e());
            bbVar.B.setVisibility(8);
            return;
        }
        if (i3 == 3) {
            TextView textView3 = bbVar.f399052x;
            q03.f fVar4 = this$0.config;
            if (fVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            } else {
                fVar = fVar4;
            }
            textView3.setText(fVar.a());
            bbVar.B.setVisibility(8);
            this$0.Ri();
            this$0.initReport();
            return;
        }
        if (i3 != 4 && i3 != 5) {
            TextView textView4 = bbVar.D;
            q03.f fVar5 = this$0.config;
            if (fVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            } else {
                fVar = fVar5;
            }
            textView4.setText(fVar.d());
            bbVar.C.setVisibility(0);
            return;
        }
        TextView textView5 = bbVar.D;
        q03.f fVar6 = this$0.config;
        if (fVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        } else {
            fVar = fVar6;
        }
        textView5.setText(fVar.g());
        bbVar.C.setVisibility(8);
    }

    private final boolean ci() {
        return true;
    }

    private final void di() {
        bb bbVar = this.binding;
        if (bbVar == null) {
            return;
        }
        bbVar.f399053y.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanVasSmallHomeGroupFragment.ei(ZplanVasSmallHomeGroupFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(ZplanVasSmallHomeGroupFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaSource zootopiaSource = this$0.source;
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.None, ZootopiaSource.SUB_SOURCE_GROUP_TRANSIT, null, 4, null);
        }
        ZootopiaSource zootopiaSource2 = zootopiaSource;
        QRouteApi api = QRoute.api(IZootopiaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaApi::class.java)");
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        IZootopiaApi.a.a((IZootopiaApi) api, requireContext, AdMetricID.Click.SUCCESS, zootopiaSource2, false, null, 24, null);
    }

    private final void fi(final long uin) {
        final bb bbVar = this.binding;
        if (bbVar == null) {
            return;
        }
        bbVar.f399031c.setButtonType(ZootopiaDownloadBarType.SMALL_HOME_TRANSIT_PAGE_BAR);
        Di().L1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.vas.group.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanVasSmallHomeGroupFragment.gi(bb.this, this, uin, (ZootopiaMapDetail) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(bb binding, ZplanVasSmallHomeGroupFragment this$0, long j3, ZootopiaMapDetail zootopiaMapDetail) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (zootopiaMapDetail != null) {
            ZootopiaDownloadButton zootopiaDownloadButton = binding.f399031c;
            zootopiaDownloadButton.setButtonStatusListener(this$0.Ai(j3, zootopiaMapDetail));
            zootopiaDownloadButton.setDownloadSize(zootopiaMapDetail);
            zootopiaDownloadButton.setStatusText(ButtonStatus.LOADED, zootopiaMapDetail.getButtonText());
            this$0.Bi().M1("200001");
            LiveData<ButtonStatus> P1 = this$0.Bi().P1("200001");
            if (P1 != null) {
                P1.removeObserver(this$0.statusObserver);
                P1.observe(this$0.getViewLifecycleOwner(), this$0.statusObserver);
            }
            LiveData<Float> O1 = this$0.Bi().O1("200001");
            if (O1 != null) {
                O1.removeObserver(this$0.progressObserver);
                O1.observe(this$0.getViewLifecycleOwner(), this$0.progressObserver);
            }
        }
    }

    private final void ii(long uin) {
        IFaceDecoder iFaceDecoder;
        final bb bbVar = this.binding;
        if (bbVar == null) {
            return;
        }
        bbVar.f399044p.setVisibility(8);
        IFaceDecoder iFaceDecoder2 = this.mDecoder;
        IFaceDecoder iFaceDecoder3 = null;
        if (iFaceDecoder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDecoder");
            iFaceDecoder2 = null;
        }
        Bitmap bitmapFromCache = iFaceDecoder2.getBitmapFromCache(1, String.valueOf(uin), 0, (byte) 3);
        if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
            IFaceDecoder iFaceDecoder4 = this.mDecoder;
            if (iFaceDecoder4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDecoder");
            } else {
                iFaceDecoder3 = iFaceDecoder4;
            }
            iFaceDecoder3.destory();
            bbVar.f399044p.setVisibility(0);
            bbVar.f399044p.setImageDrawable(new BitmapDrawable(getResources(), bitmapFromCache));
            return;
        }
        IFaceDecoder iFaceDecoder5 = this.mDecoder;
        if (iFaceDecoder5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDecoder");
            iFaceDecoder5 = null;
        }
        iFaceDecoder5.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: com.tencent.mobileqq.vas.group.n
            @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
            public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                ZplanVasSmallHomeGroupFragment.ji(ZplanVasSmallHomeGroupFragment.this, bbVar, i3, i16, str, bitmap);
            }
        });
        IFaceDecoder iFaceDecoder6 = this.mDecoder;
        if (iFaceDecoder6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDecoder");
            iFaceDecoder = null;
        } else {
            iFaceDecoder = iFaceDecoder6;
        }
        iFaceDecoder.requestDecodeFace(String.valueOf(uin), 200, false, 1, true, (byte) 0, 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initReport() {
        com.tencent.mobileqq.vas.data.e value;
        LiveData<ButtonStatus> P1;
        Context context;
        MasterInfo masterInfo;
        Long longOrNull;
        LinearLayout linearLayout;
        SmallHomeInfo value2 = Di().M1().getValue();
        if (value2 == null || (value = Di().N1().getValue()) == null || (P1 = Bi().P1("200001")) == null || P1.getValue() == null || (context = getContext()) == null) {
            return;
        }
        ah ahVar = new ah(context);
        bb bbVar = this.binding;
        int i3 = (bbVar == null || (linearLayout = bbVar.f399049u) == null || linearLayout.getVisibility() != 0) ? 0 : 1;
        int i16 = !TextUtils.isEmpty(value.getBgUrl()) ? 1 : 0;
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        long longValue = (transitPageInfo == null || (masterInfo = transitPageInfo.getMasterInfo()) == null || (r3 = masterInfo.getUin()) == null || longOrNull == null) ? -1L : longOrNull.longValue();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i17 = longValue == (peekAppRuntime != null ? peekAppRuntime.getLongAccountUin() : 0L) ? 0 : 1;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_realtime_playercount", Integer.valueOf(value2.getVisitors()));
        linkedHashMap.put("zplan_xiaowo_update_notice", Integer.valueOf(i3));
        linkedHashMap.put("zplan_xiaowo_cover_type", Integer.valueOf(i16));
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_HOST_GUEST_TYPE, Integer.valueOf(i17));
        ahVar.e(getView(), AdMetricID.Click.SUCCESS, "QQ\u5c0f\u7a9d", this.source, linkedHashMap);
        bb bbVar2 = this.binding;
        ahVar.b(bbVar2 != null ? bbVar2.f399031c : null, true, true);
        bb bbVar3 = this.binding;
        ahVar.b(bbVar3 != null ? bbVar3.f399032d : null, false, false);
        bb bbVar4 = this.binding;
        ahVar.b(bbVar4 != null ? bbVar4.f399049u : null, false, false);
        if (i17 == 0) {
            bb bbVar5 = this.binding;
            ah.i(ahVar, bbVar5 != null ? bbVar5.f399032d : null, null, null, 4, null);
        }
        View it = getView();
        if (it != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("dt_pgid", "pg_zplan_playground_detail");
            id3.d dVar = this.reportHelper;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dVar.c("pgin", it, linkedHashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(ZplanVasSmallHomeGroupFragment this$0, final bb binding, int i3, int i16, String str, final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        IFaceDecoder iFaceDecoder = this$0.mDecoder;
        if (iFaceDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDecoder");
            iFaceDecoder = null;
        }
        iFaceDecoder.destory();
        if (TextUtils.isEmpty(str) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.group.f
            @Override // java.lang.Runnable
            public final void run() {
                ZplanVasSmallHomeGroupFragment.ki(bb.this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(bb binding, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        binding.f399044p.setVisibility(0);
        if (bitmap.isRecycled()) {
            return;
        }
        binding.f399044p.setImageBitmap(bitmap);
    }

    private final void li(int ranking, final long troopUin) {
        Map<String, Object> mutableMapOf;
        final bb bbVar = this.binding;
        if (bbVar == null) {
            return;
        }
        final id3.d dVar = new id3.d(null, 1, null);
        View view = getView();
        if (view != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_map_id", Integer.valueOf(AdMetricID.Click.SUCCESS)));
            dVar.j(this, view, "pg_zplan_playground_detail", mutableMapOf);
            LinearLayout linearLayout = bbVar.f399033e;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.groupRanking");
            dVar.e(linearLayout, "em_zplan_top3_label");
        }
        LinearLayout linearLayout2 = bbVar.f399033e;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.groupRanking");
        dVar.c("dt_imp", linearLayout2, new LinkedHashMap());
        bbVar.f399033e.setVisibility(0);
        bbVar.f399034f.setText(getResources().getString(R.string.xdr, Integer.valueOf(ranking)));
        bbVar.f399033e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.group.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZplanVasSmallHomeGroupFragment.mi(id3.d.this, bbVar, this, troopUin, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(id3.d dtReport, bb binding, ZplanVasSmallHomeGroupFragment this$0, long j3, View view) {
        Intrinsics.checkNotNullParameter(dtReport, "$dtReport");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = binding.f399033e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.groupRanking");
        dtReport.c("dt_clck", linearLayout, new LinkedHashMap());
        String Ci = this$0.Ci(j3);
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        iZPlanApi.launchScheme(context, Ci);
    }

    private final void ni(final long uin, final long troopUin) {
        final bb bbVar = this.binding;
        if (bbVar == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        if (troopUin != 0) {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(String.valueOf(troopUin), String.valueOf(uin), "ZplanVasWoGroupFragment", new Function1<TroopMemberNickInfo, Unit>() { // from class: com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment$bindNickName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                    invoke2(troopMemberNickInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TroopMemberNickInfo troopMemberNickInfo) {
                    String valueOf;
                    if (QLog.isColorLevel()) {
                        QLog.i("ZplanVasWoGroupFragment", 2, "troop: " + troopUin + " uin: " + uin + " name is " + (troopMemberNickInfo != null ? troopMemberNickInfo.getShowName() : null));
                    }
                    TextView textView = bbVar.f399047s;
                    if (troopMemberNickInfo == null || (valueOf = troopMemberNickInfo.getShowName()) == null) {
                        valueOf = String.valueOf(uin);
                    }
                    textView.setText(valueOf);
                }
            });
            return;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IFriendNameService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        final IFriendNameService iFriendNameService = (IFriendNameService) runtimeService;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.group.q
            @Override // java.lang.Runnable
            public final void run() {
                ZplanVasSmallHomeGroupFragment.oi(IFriendNameService.this, uin, troopUin, bbVar);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(IFriendNameService friendService, long j3, long j16, final bb binding) {
        Intrinsics.checkNotNullParameter(friendService, "$friendService");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        final String friendName = friendService.getFriendName(String.valueOf(j3), false);
        if (QLog.isColorLevel()) {
            QLog.i("ZplanVasWoGroupFragment", 2, "troop: " + j16 + " uin: " + j3 + " name is " + friendName);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.group.g
            @Override // java.lang.Runnable
            public final void run() {
                ZplanVasSmallHomeGroupFragment.pi(friendName, binding);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(String str, bb binding) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        if (str == null || str.length() == 0) {
            binding.f399047s.setVisibility(8);
        } else {
            binding.f399047s.setText(str);
        }
    }

    private final void qi() {
        boolean z16 = this.binding == null;
        q03.f fVar = this.config;
        q03.f fVar2 = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            fVar = null;
        }
        QLog.d("ZplanVasWoGroupFragment", 1, "bindPageConfig, binding:" + z16 + ", config:" + fVar.b());
        final bb bbVar = this.binding;
        if (bbVar == null) {
            return;
        }
        TextView textView = bbVar.f399052x;
        q03.f fVar3 = this.config;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            fVar3 = null;
        }
        textView.setText(fVar3.h());
        RoundRelativeLayout roundRelativeLayout = bbVar.f399043o;
        roundRelativeLayout.f316197h = 15;
        roundRelativeLayout.f316195e = ViewUtils.dpToPx(4.0f);
        LinearLayout linearLayout = bbVar.B;
        q03.f fVar4 = this.config;
        if (fVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            fVar4 = null;
        }
        linearLayout.setVisibility(fVar4.f() ? 0 : 8);
        q03.f fVar5 = this.config;
        if (fVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            fVar5 = null;
        }
        if (fVar5.f()) {
            TextView textView2 = bbVar.D;
            q03.f fVar6 = this.config;
            if (fVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            } else {
                fVar2 = fVar6;
            }
            textView2.setText(fVar2.d());
            bbVar.C.post(new Runnable() { // from class: com.tencent.mobileqq.vas.group.k
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanVasSmallHomeGroupFragment.ri(ZplanVasSmallHomeGroupFragment.this, bbVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(ZplanVasSmallHomeGroupFragment this$0, bb binding) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        ImageView imageView = binding.C;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.zplanVasGroupTipsIcon");
        q03.f fVar = this$0.config;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            fVar = null;
        }
        Ni(this$0, imageView, fVar.c(), R.drawable.f159939i73, 0, 0, false, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(ZplanVasSmallHomeGroupFragment this$0, SmallHomeInfo smallHomeInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Si();
        this$0.initReport();
    }

    private final void ui() {
        Di().N1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.vas.group.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanVasSmallHomeGroupFragment.vi(ZplanVasSmallHomeGroupFragment.this, (com.tencent.mobileqq.vas.data.e) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(ZplanVasSmallHomeGroupFragment this$0, com.tencent.mobileqq.vas.data.e it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Si();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Qi(it);
        this$0.Ri();
        this$0.initReport();
    }

    private final void wi() {
        NavBarCommon navBarCommon;
        bb bbVar = this.binding;
        if (bbVar == null || this.transitPageInfo == null || (navBarCommon = bbVar.f399046r) == null) {
            return;
        }
        if (this.fullScreenMode) {
            navBarCommon.setVisibility(0);
            navBarCommon.setTitle(getString(R.string.f169750xe2));
            navBarCommon.setLeftBackVisible(0);
            navBarCommon.setOnItemSelectListener(new d());
            return;
        }
        navBarCommon.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void xi() {
        MasterInfo masterInfo;
        TransitPageConfig config;
        MasterInfo masterInfo2;
        Long longOrNull;
        MasterInfo masterInfo3;
        Long longOrNull2;
        QLog.d("ZplanVasWoGroupFragment", 1, "bindUserInfo");
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        long longValue = (transitPageInfo == null || (masterInfo3 = transitPageInfo.getMasterInfo()) == null || (r0 = masterInfo3.getUin()) == null || longOrNull2 == null) ? 0L : longOrNull2.longValue();
        TransitPageInfo transitPageInfo2 = this.transitPageInfo;
        long longValue2 = (transitPageInfo2 == null || (masterInfo2 = transitPageInfo2.getMasterInfo()) == null || (r5 = masterInfo2.getGroupId()) == null || longOrNull == null) ? 0L : longOrNull.longValue();
        if (longValue <= 0) {
            return;
        }
        TransitPageInfo transitPageInfo3 = this.transitPageInfo;
        int i3 = 0;
        if ((transitPageInfo3 == null || (config = transitPageInfo3.getConfig()) == null || !config.getShowGoldEntry()) ? false : true) {
            TransitPageInfo transitPageInfo4 = this.transitPageInfo;
            if (transitPageInfo4 != null && (masterInfo = transitPageInfo4.getMasterInfo()) != null) {
                i3 = masterInfo.getRanking();
            }
            li(i3, longValue2);
            return;
        }
        ii(longValue);
        ni(longValue, longValue2);
    }

    private final void yi() {
        TransitPageConfig config;
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        boolean z16 = false;
        if (transitPageInfo != null && (config = transitPageInfo.getConfig()) != null && config.getTransitType() == 1) {
            z16 = true;
        }
        if (z16) {
            hi();
        } else {
            xi();
        }
    }

    private final void zi() {
        try {
            Fragment parentFragment = getParentFragment();
            DialogFragment dialogFragment = parentFragment instanceof DialogFragment ? (DialogFragment) parentFragment : null;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            } else {
                getParentFragmentManager().beginTransaction().remove(this).commit();
            }
        } catch (Throwable th5) {
            QLog.e("ZplanVasWoGroupFragment", 1, "finishSelf err.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_GROUP_TRANSIT;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        bb g16 = bb.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        TransitPageConfig config;
        super.onDestroy();
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        boolean z16 = false;
        if (transitPageInfo != null && (config = transitPageInfo.getConfig()) != null && config.getSinglePageMode()) {
            z16 = true;
        }
        if (z16) {
            finishActivity();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String Ei = Ei(view);
        if (Ei != null) {
            v.f373305a.c(R.string.xhl, Ei);
            zi();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$e", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements URLDrawable.URLDrawableListener {
        e() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            ZplanVasSmallHomeGroupFragment.this.Hi();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            Drawable currDrawable = p06 != null ? p06.getCurrDrawable() : null;
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).setOnPlayRepeatListener(ZplanVasSmallHomeGroupFragment.this.apngLis);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }

    private final void Ti(float from, float to5, Function0<Unit> callback) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(from, to5);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.vas.group.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZplanVasSmallHomeGroupFragment.Ui(ZplanVasSmallHomeGroupFragment.this, valueAnimator);
            }
        });
        ofFloat.addListener(new f(callback));
        ofFloat.start();
    }

    private final void hi() {
        ImageView imageView;
        MasterInfo masterInfo;
        String tinyAvatar;
        TextView textView;
        String str;
        MasterInfo masterInfo2;
        QLog.d("ZplanVasWoGroupFragment", 1, "bindUserInfo");
        bb bbVar = this.binding;
        if (bbVar != null && (textView = bbVar.f399047s) != null) {
            textView.setVisibility(0);
            TransitPageInfo transitPageInfo = this.transitPageInfo;
            if (transitPageInfo == null || (masterInfo2 = transitPageInfo.getMasterInfo()) == null || (str = masterInfo2.getTinyNick()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        bb bbVar2 = this.binding;
        if (bbVar2 == null || (imageView = bbVar2.f399044p) == null) {
            return;
        }
        imageView.setVisibility(0);
        TransitPageInfo transitPageInfo2 = this.transitPageInfo;
        Mi(imageView, (transitPageInfo2 == null || (masterInfo = transitPageInfo2.getMasterInfo()) == null || (tinyAvatar = masterInfo.getTinyAvatar()) == null) ? "" : tinyAvatar, -1, com.tencent.sqshow.zootopia.utils.i.b(20), com.tencent.sqshow.zootopia.utils.i.b(20), true);
    }

    private final void si() {
        Oi(4);
        Di().M1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.vas.group.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanVasSmallHomeGroupFragment.ti(ZplanVasSmallHomeGroupFragment.this, (SmallHomeInfo) obj);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$d", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.widget.navbar.a {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View v3, int item) {
            if (item == 1) {
                ZplanVasSmallHomeGroupFragment.this.finishActivity();
            }
        }
    }

    static /* synthetic */ void Ni(ZplanVasSmallHomeGroupFragment zplanVasSmallHomeGroupFragment, ImageView imageView, String str, int i3, int i16, int i17, boolean z16, int i18, Object obj) {
        zplanVasSmallHomeGroupFragment.Mi(imageView, str, i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? 0 : i17, (i18 & 32) != 0 ? false : z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f309331d;

        f(Function0<Unit> function0) {
            this.f309331d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f309331d.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/group/ZplanVasSmallHomeGroupFragment$g", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SmallHomeInfo f309332d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZplanVasSmallHomeGroupFragment f309333e;

        g(SmallHomeInfo smallHomeInfo, ZplanVasSmallHomeGroupFragment zplanVasSmallHomeGroupFragment) {
            this.f309332d = smallHomeInfo;
            this.f309333e = zplanVasSmallHomeGroupFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            String str = this.f309332d.getSquareCnt() + "\u5e73\u7c73 " + this.f309332d.getRoomCnt() + "\u623f";
            bb bbVar = this.f309333e.binding;
            TextView textView = bbVar != null ? bbVar.f399051w : null;
            if (textView == null) {
                return;
            }
            textView.setText(str);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
