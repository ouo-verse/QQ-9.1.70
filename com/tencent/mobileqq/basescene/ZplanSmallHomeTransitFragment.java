package com.tencent.mobileqq.basescene;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.basescene.ZplanBaseSceneDownloadButtonListener;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.data.SmallHomeInfo;
import com.tencent.mobileqq.vas.group.t;
import com.tencent.mobileqq.vas.group.u;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.detail.ah;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import fi3.ao;
import fi3.ap;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0001s\u0018\u0000 x2\u00020\u0001:\u0001yB\u0007\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J&\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\b\u0010$\u001a\u00020\u0002H\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u0002H\u0002J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u00103\u001a\u0002022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00101\u001a\u000200H\u0002J\b\u00104\u001a\u00020\u0002H\u0002J&\u0010<\u001a\u0004\u0018\u00010;2\u0006\u00106\u001a\u0002052\b\u00108\u001a\u0004\u0018\u0001072\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010=\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020;2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\b\u0010>\u001a\u00020\u0002H\u0016J\b\u0010?\u001a\u00020)H\u0016J\b\u0010@\u001a\u00020\bH\u0014J\b\u0010A\u001a\u00020)H\u0016R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010d\u001a\u0004\bj\u0010kR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00050m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001d0m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010oR\u0014\u0010!\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010u\u00a8\u0006z"}, d2 = {"Lcom/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "", "Fi", "initViews", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "status", "Yi", "", "Di", "Ni", "zi", WidgetCacheLunarData.YI, "", "uin", "ri", "oi", "Landroid/widget/ImageView;", "view", "url", "", "defaultRes", "Oi", SensorJsPlugin.SENSOR_INTERVAL_UI, "wi", "Lcom/tencent/mobileqq/vas/data/e;", "pageInfo", "Ri", "Si", "", "from", "to", "Lkotlin/Function0;", "callback", "Ti", "Li", "Ji", "Vi", "Lcom/tencent/mobileqq/vas/data/d;", "homeInfo", "Qi", "", "Ii", "ki", "initReport", NodeProps.VISIBLE, "Pi", "mi", "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Lcom/tencent/mobileqq/basescene/ZplanBaseSceneDownloadButtonListener;", "Ai", "finishActivity", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onBackEvent", "getSubSource", "onBackPressedEvent", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "N", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "transitPageInfo", "Lfi3/ap;", "P", "Lfi3/ap;", "containerBinding", "Lfi3/ao;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfi3/ao;", "binding", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mDecoder", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "T", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "U", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "apngLis", "Lid3/d;", "V", "Lid3/d;", "reportHelper", "Lcom/tencent/mobileqq/vas/group/u;", "W", "Lkotlin/Lazy;", "Ci", "()Lcom/tencent/mobileqq/vas/group/u;", "vm", "Loa4/a;", "X", "Bi", "()Loa4/a;", "mapResVm", "Landroidx/lifecycle/Observer;", "Y", "Landroidx/lifecycle/Observer;", "statusObserver", "Z", "progressObserver", "com/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$c", "a0", "Lcom/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$c;", "<init>", "()V", "b0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ZplanSmallHomeTransitFragment extends ZootopiaBaseFragment {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c0, reason: collision with root package name */
    private static ButtonStatus f200300c0 = ButtonStatus.INIT;

    /* renamed from: d0, reason: collision with root package name */
    private static float f200301d0;

    /* renamed from: e0, reason: collision with root package name */
    private static q03.f f200302e0;

    /* renamed from: N, reason: from kotlin metadata */
    private TransitPageInfo transitPageInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private ap containerBinding;

    /* renamed from: Q, reason: from kotlin metadata */
    private ao binding;

    /* renamed from: R, reason: from kotlin metadata */
    private IFaceDecoder mDecoder;

    /* renamed from: S, reason: from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: T, reason: from kotlin metadata */
    private final MMKVOptionEntity entity;

    /* renamed from: U, reason: from kotlin metadata */
    private final ApngDrawable.OnPlayRepeatListener apngLis;

    /* renamed from: V, reason: from kotlin metadata */
    private final id3.d reportHelper;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy mapResVm;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Observer<Float> progressObserver;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final c callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "pageInfo", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "a", "", "BG_PADDING", UserInfo.SEX_FEMALE, "", "DURATION", "J", "FIRST_END_ANGLE", "FIRST_START_ANGLE", "", "MAP_ID", "I", "RADIO", "SECOND_START_ANGLE", "", "SMALL_HOME_NAME", "Ljava/lang/String;", "SOURCE", "TAG", "TRANSIT_PAGE_INFO", "UPDATE_ANIM_URL", "VISITOR_URL", "Lq03/f;", DownloadInfo.spKey_Config, "Lq03/f;", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "process", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, TransitPageInfo pageInfo, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
            Intrinsics.checkNotNullParameter(source, "source");
            if (!TransitPageInfo.INSTANCE.a(pageInfo)) {
                v.f373305a.c(R.string.xhl, "invalid pageInfo");
                QLog.e("ZplanSmallHomeTransitFragment", 1, "invalid pageInfo");
                return;
            }
            QLog.i("ZplanSmallHomeTransitFragment", 1, "goto ZplanSmallHomeTransitFragment");
            Intent intent = new Intent();
            intent.putExtra("tansit_page_info", pageInfo);
            intent.putExtra("source", source);
            intent.putExtra("public_fragment_window_feature", 1);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ZplanSmallHomeTransitFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f200304a;

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
            f200304a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$c", "Lcom/tencent/mobileqq/basescene/ZplanBaseSceneDownloadButtonListener$b;", "", "callback", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements ZplanBaseSceneDownloadButtonListener.b {
        c() {
        }

        @Override // com.tencent.mobileqq.basescene.ZplanBaseSceneDownloadButtonListener.b
        public void callback() {
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView;
            ap apVar = ZplanSmallHomeTransitFragment.this.containerBinding;
            if (apVar == null || (qUSHalfScreenFloatingView = apVar.f398884b) == null) {
                return;
            }
            qUSHalfScreenFloatingView.t();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$d", "Lcom/tencent/mobileqq/widget/qus/e;", "", "showMode", "Landroid/view/View;", "createContentView", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ao f200306d;

        d(ao aoVar) {
            this.f200306d = aoVar;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            ScrollView root = this.f200306d.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public ZplanSmallHomeTransitFragment() {
        Lazy lazy;
        Lazy lazy2;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        this.entity = from;
        this.apngLis = new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.basescene.j
            @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
            public final void onPlayRepeat(int i3) {
                ZplanSmallHomeTransitFragment.li(ZplanSmallHomeTransitFragment.this, i3);
            }
        };
        this.reportHelper = new id3.d(null, 1, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<u>() { // from class: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$vm$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$vm$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes33.dex */
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
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(ZplanSmallHomeTransitFragment.this, new a()).get(u.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026oupViewModel::class.java)");
                return (u) viewModel;
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$mapResVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(ZplanSmallHomeTransitFragment.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResVm = lazy2;
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.basescene.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanSmallHomeTransitFragment.Xi(ZplanSmallHomeTransitFragment.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.basescene.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanSmallHomeTransitFragment.Mi(ZplanSmallHomeTransitFragment.this, (Float) obj);
            }
        };
        this.callback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZplanBaseSceneDownloadButtonListener Ai(long uin, ZootopiaMapDetail detail) {
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
        return new ZplanBaseSceneDownloadButtonListener(requireContext, uin, detail, Bi, zootopiaSource2, aVar.a((transitPageInfo == null || (extInfo = transitPageInfo.getExtInfo()) == null) ? null : extInfo.getUeExtras(), String.valueOf(uin)), this.callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final oa4.a Bi() {
        return (oa4.a) this.mapResVm.getValue();
    }

    private final u Ci() {
        return (u) this.vm.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String Di() {
        MasterInfo masterInfo;
        Long longOrNull;
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        long longValue = (transitPageInfo == null || (masterInfo = transitPageInfo.getMasterInfo()) == null || (r0 = masterInfo.getUin()) == null || longOrNull == null) ? 0L : longOrNull.longValue();
        if (longValue <= 0) {
            return "uin";
        }
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("source") : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.ZootopiaSource");
        this.source = (ZootopiaSource) serializable;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return "app";
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        Intrinsics.checkNotNullExpressionValue(iQQAvatarService, "app.getRuntimeService(IQ\u2026        .getInstance(app)");
        this.mDecoder = iQQAvatarService;
        Ci().Q1(longValue);
        Ci().O1(longValue);
        Ci().P1();
        Ni();
        ui();
        wi();
        zi();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(ZplanSmallHomeTransitFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finishActivity();
    }

    private final void Fi() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.basescene.o
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomeTransitFragment.Gi(ZplanSmallHomeTransitFragment.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(final ZplanSmallHomeTransitFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f200302e0 = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getWoTransitPageConfig();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.basescene.c
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomeTransitFragment.Hi(ZplanSmallHomeTransitFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(ZplanSmallHomeTransitFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ao aoVar = this$0.binding;
        TextView textView = aoVar != null ? aoVar.f398876k : null;
        if (textView != null) {
            q03.f fVar = f200302e0;
            textView.setText(fVar != null ? fVar.h() : null);
        }
        this$0.Yi(f200300c0);
    }

    private final boolean Ii(com.tencent.mobileqq.vas.data.e pageInfo) {
        for (com.tencent.mobileqq.vas.data.c cVar : pageInfo.c()) {
            if (cVar.getChangeType() != 0 && cVar.getOldData() != cVar.getNewData()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ji() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.basescene.e
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomeTransitFragment.Ki(ZplanSmallHomeTransitFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(final ZplanSmallHomeTransitFragment this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ao aoVar = this$0.binding;
        if (aoVar != null && (imageView = aoVar.f398867b) != null) {
            imageView.setImageDrawable(null);
        }
        this$0.Ti(90.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$onApngFinish$1$1
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
                ZplanSmallHomeTransitFragment.this.Vi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Li() {
        ao aoVar;
        ImageView imageView;
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setLoadListener(new e());
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("ZplanSmallHomeTransitFragment", "https://img.meta.qq.com/smallHomeExtension.png", apngOptions);
        if (apngURLDrawable == null || (aoVar = this.binding) == null || (imageView = aoVar.f398867b) == null) {
            return;
        }
        imageView.setImageDrawable(apngURLDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(ZplanSmallHomeTransitFragment this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ao aoVar = this$0.binding;
        if (aoVar == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        f200301d0 = it.floatValue();
        aoVar.f398868c.setProcess(it.floatValue());
    }

    private final void Ni() {
        RoundRelativeLayout roundRelativeLayout;
        ao aoVar = this.binding;
        if (aoVar == null || (roundRelativeLayout = aoVar.f398879n) == null) {
            return;
        }
        roundRelativeLayout.getLayoutParams().height = (int) ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(32.0f)) * 0.42f);
    }

    private final void Oi(ImageView view, String url, int defaultRes) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (defaultRes != -1) {
                obtain.mFailedDrawable = q.b(defaultRes);
                obtain.mLoadingDrawable = q.b(defaultRes);
            }
            view.setImageDrawable(URLDrawable.getDrawable(url, obtain));
        } catch (Throwable th5) {
            QLog.e("ZplanSmallHomeTransitFragment", 1, th5, new Object[0]);
        }
    }

    private final void Pi(int visible) {
        ao aoVar = this.binding;
        if (aoVar == null) {
            return;
        }
        aoVar.f398878m.setVisibility(visible);
        aoVar.f398875j.setVisibility(visible);
        aoVar.f398874i.setVisibility(visible);
        aoVar.f398877l.setVisibility(visible);
        aoVar.f398870e.setVisibility(visible);
        aoVar.f398873h.setVisibility(visible);
    }

    private final void Qi(SmallHomeInfo homeInfo, com.tencent.mobileqq.vas.data.e pageInfo) {
        ao aoVar;
        ImageView imageView;
        if (homeInfo.getVisitors() > 1) {
            ao aoVar2 = this.binding;
            LinearLayout linearLayout = aoVar2 != null ? aoVar2.f398872g : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            String str = homeInfo.getVisitors() + "/" + pageInfo.getMaxVisitorNum();
            ao aoVar3 = this.binding;
            TextView textView = aoVar3 != null ? aoVar3.f398870e : null;
            if (textView != null) {
                textView.setText(str);
            }
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoop(1);
            URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("ZplanSmallHomeTransitFragment", "http://imgcache.gtimg.cn/mie/act/img/public/202204/m1650879146_maopao@2x.png", apngOptions);
            if (apngURLDrawable == null || (aoVar = this.binding) == null || (imageView = aoVar.f398871f) == null) {
                return;
            }
            imageView.setImageDrawable(apngURLDrawable);
            return;
        }
        ao aoVar4 = this.binding;
        LinearLayout linearLayout2 = aoVar4 != null ? aoVar4.f398872g : null;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri(com.tencent.mobileqq.vas.data.e pageInfo) {
        ImageView imageView;
        ao aoVar = this.binding;
        if (aoVar == null || (imageView = aoVar.f398881p) == null) {
            return;
        }
        Oi(imageView, pageInfo.getDefaultBgUrl(), R.drawable.i86);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Si() {
        SmallHomeInfo value;
        com.tencent.mobileqq.vas.data.e value2;
        Object obj;
        Object obj2;
        Number valueOf;
        Number valueOf2;
        ao aoVar = this.binding;
        if (aoVar == null || (value = Ci().M1().getValue()) == null || (value2 = Ci().N1().getValue()) == null || value.getSquareCnt() <= 0) {
            return;
        }
        Pi(0);
        Qi(value, value2);
        aoVar.f398877l.setText(String.valueOf(value.getFurnitureCnt()));
        if (Ii(value2) && ki()) {
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
            String string = getResources().getString(R.string.xl8, Integer.valueOf(valueOf.intValue()), Integer.valueOf(valueOf2.intValue()));
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026    oldRoomCount.toInt())");
            aoVar.f398874i.setText(string);
            Ti(360.0f, 270.0f, new Function0<Unit>() { // from class: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$showSmallHomeNumInfo$1
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
                    ZplanSmallHomeTransitFragment.this.Li();
                }
            });
            return;
        }
        String string2 = getResources().getString(R.string.xl8, Integer.valueOf(value.getSquareCnt()), Integer.valueOf(value.getRoomCnt()));
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026areCnt, homeInfo.roomCnt)");
        aoVar.f398874i.setText(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(ZplanSmallHomeTransitFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        ao aoVar = this$0.binding;
        LinearLayout linearLayout = aoVar != null ? aoVar.f398869d : null;
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
        com.tencent.mobileqq.vas.data.e value2 = Ci().N1().getValue();
        if (value2 == null || (value = Ci().M1().getValue()) == null) {
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
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.basescene.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZplanSmallHomeTransitFragment.Wi(i3, squareCnt2, i16, roomCnt2, this, valueAnimator);
            }
        });
        ofFloat.addListener(new g(value, this));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(int i3, long j3, int i16, int i17, ZplanSmallHomeTransitFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        String str = ((int) (i3 + (((float) j3) * floatValue))) + "\u5e73\u7c73 " + ((int) (i16 + (i17 * floatValue))) + "\u623f";
        ao aoVar = this$0.binding;
        TextView textView = aoVar != null ? aoVar.f398874i : null;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(ZplanSmallHomeTransitFragment this$0, ButtonStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        f200300c0 = it;
        this$0.Yi(it);
    }

    private final void Yi(ButtonStatus status) {
        ao aoVar = this.binding;
        if (aoVar == null) {
            return;
        }
        aoVar.f398868c.setStatus(status);
        q03.f fVar = f200302e0;
        if (fVar == null) {
            return;
        }
        int i3 = b.f200304a[status.ordinal()];
        if (i3 == 1) {
            aoVar.f398876k.setText(fVar.h());
            return;
        }
        if (i3 == 2) {
            aoVar.f398876k.setText(fVar.e());
        } else {
            if (i3 != 3) {
                return;
            }
            aoVar.f398876k.setText(fVar.a());
            f200300c0 = ButtonStatus.INIT;
            initReport();
        }
    }

    private final void finishActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void initReport() {
        LiveData<ButtonStatus> P1;
        Context context;
        MasterInfo masterInfo;
        Long longOrNull;
        SmallHomeInfo value = Ci().M1().getValue();
        if (value == null || (P1 = Bi().P1("200001")) == null || P1.getValue() == null || (context = getContext()) == null) {
            return;
        }
        ah ahVar = new ah(context);
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        long longValue = (transitPageInfo == null || (masterInfo = transitPageInfo.getMasterInfo()) == null || (r1 = masterInfo.getUin()) == null || longOrNull == null) ? -1L : longOrNull.longValue();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i3 = longValue == (peekAppRuntime != null ? peekAppRuntime.getLongAccountUin() : 0L) ? 0 : 1;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_realtime_playercount", Integer.valueOf(value.getVisitors()));
        linkedHashMap.put("zplan_xiaowo_update_notice", 0);
        linkedHashMap.put("zplan_xiaowo_cover_type", 0);
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_HOST_GUEST_TYPE, Integer.valueOf(i3));
        ahVar.e(getView(), AdMetricID.Click.SUCCESS, "QQ\u5c0f\u7a9d", this.source, linkedHashMap);
        ao aoVar = this.binding;
        ahVar.b(aoVar != null ? aoVar.f398868c : null, true, true);
        View it = getView();
        if (it != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("dt_pgid", "pg_zplan_playground_detail");
            id3.d dVar = this.reportHelper;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dVar.c("pgin", it, linkedHashMap2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initViews() {
        Long longOrNull;
        ao aoVar = this.binding;
        if (aoVar == null) {
            return;
        }
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("tansit_page_info") : null;
        TransitPageInfo transitPageInfo = serializable instanceof TransitPageInfo ? (TransitPageInfo) serializable : null;
        if (transitPageInfo == null) {
            return;
        }
        this.transitPageInfo = transitPageInfo;
        MasterInfo masterInfo = transitPageInfo.getMasterInfo();
        long longValue = (masterInfo == null || (r1 = masterInfo.getUin()) == null || longOrNull == null) ? 0L : longOrNull.longValue();
        if (longValue <= 0) {
            QLog.e("ZplanSmallHomeTransitFragment", 1, "uin is null");
            return;
        }
        mi(longValue);
        ap apVar = this.containerBinding;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = apVar != null ? apVar.f398884b : null;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setQUSDragFloatController(new d(aoVar));
        }
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.basescene.n
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    ZplanSmallHomeTransitFragment.Ei(ZplanSmallHomeTransitFragment.this);
                }
            });
        }
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        }
        if (getActivity() != null) {
            LiuHaiUtils.enableNotch(getActivity());
        }
        View view = getView();
        if (view != null) {
            view.setFitsSystemWindows(true);
        }
        RoundRelativeLayout roundRelativeLayout = aoVar.f398879n;
        roundRelativeLayout.f316197h = 15;
        roundRelativeLayout.f316195e = ViewUtils.dpToPx(4.0f);
        Yi(f200300c0);
        if (f200300c0 != ButtonStatus.INIT) {
            aoVar.f398868c.setProcess(f200301d0);
        }
    }

    private final boolean ki() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(ZplanSmallHomeTransitFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ji();
    }

    private final void mi(final long uin) {
        final ao aoVar = this.binding;
        if (aoVar == null) {
            return;
        }
        aoVar.f398868c.setButtonType(ZootopiaDownloadBarType.SMALL_HOME_TRANSIT_PAGE_BAR);
        MutableLiveData<ZootopiaMapDetail> L1 = Ci().L1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ZootopiaMapDetail, Unit> function1 = new Function1<ZootopiaMapDetail, Unit>() { // from class: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$bindDownloadButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaMapDetail zootopiaMapDetail) {
                invoke2(zootopiaMapDetail);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaMapDetail zootopiaMapDetail) {
                ZplanBaseSceneDownloadButtonListener Ai;
                oa4.a Bi;
                oa4.a Bi2;
                oa4.a Bi3;
                Observer<? super Float> observer;
                Observer<? super Float> observer2;
                Observer<? super ButtonStatus> observer3;
                Observer<? super ButtonStatus> observer4;
                if (zootopiaMapDetail != null) {
                    ZootopiaDownloadButton zootopiaDownloadButton = ao.this.f398868c;
                    Ai = this.Ai(uin, zootopiaMapDetail);
                    zootopiaDownloadButton.setButtonStatusListener(Ai);
                    zootopiaDownloadButton.setDownloadSize(zootopiaMapDetail);
                    zootopiaDownloadButton.setStatusText(ButtonStatus.LOADED, zootopiaMapDetail.getButtonText());
                    Bi = this.Bi();
                    Bi.M1("200001");
                    Bi2 = this.Bi();
                    LiveData<ButtonStatus> P1 = Bi2.P1("200001");
                    if (P1 != null) {
                        ZplanSmallHomeTransitFragment zplanSmallHomeTransitFragment = this;
                        observer3 = zplanSmallHomeTransitFragment.statusObserver;
                        P1.removeObserver(observer3);
                        LifecycleOwner viewLifecycleOwner2 = zplanSmallHomeTransitFragment.getViewLifecycleOwner();
                        observer4 = zplanSmallHomeTransitFragment.statusObserver;
                        P1.observe(viewLifecycleOwner2, observer4);
                    }
                    Bi3 = this.Bi();
                    LiveData<Float> O1 = Bi3.O1("200001");
                    if (O1 != null) {
                        ZplanSmallHomeTransitFragment zplanSmallHomeTransitFragment2 = this;
                        observer = zplanSmallHomeTransitFragment2.progressObserver;
                        O1.removeObserver(observer);
                        LifecycleOwner viewLifecycleOwner3 = zplanSmallHomeTransitFragment2.getViewLifecycleOwner();
                        observer2 = zplanSmallHomeTransitFragment2.progressObserver;
                        O1.observe(viewLifecycleOwner3, observer2);
                    }
                }
            }
        };
        L1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.basescene.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanSmallHomeTransitFragment.ni(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void oi(long uin) {
        IFaceDecoder iFaceDecoder;
        final ao aoVar = this.binding;
        if (aoVar == null) {
            return;
        }
        aoVar.f398880o.setVisibility(8);
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
            aoVar.f398880o.setVisibility(0);
            aoVar.f398880o.setImageDrawable(new BitmapDrawable(getResources(), bitmapFromCache));
            return;
        }
        IFaceDecoder iFaceDecoder5 = this.mDecoder;
        if (iFaceDecoder5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDecoder");
            iFaceDecoder5 = null;
        }
        iFaceDecoder5.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: com.tencent.mobileqq.basescene.i
            @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
            public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                ZplanSmallHomeTransitFragment.pi(ZplanSmallHomeTransitFragment.this, aoVar, i3, i16, str, bitmap);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(ZplanSmallHomeTransitFragment this$0, final ao binding, int i3, int i16, String str, final Bitmap bitmap) {
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
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.basescene.p
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomeTransitFragment.qi(ao.this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(ao binding, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        binding.f398880o.setVisibility(0);
        if (bitmap.isRecycled()) {
            return;
        }
        binding.f398880o.setImageBitmap(bitmap);
    }

    private final void ri(final long uin) {
        final ao aoVar = this.binding;
        if (aoVar == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IFriendNameService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        final IFriendNameService iFriendNameService = (IFriendNameService) runtimeService;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.basescene.a
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomeTransitFragment.si(IFriendNameService.this, uin, aoVar);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(IFriendNameService friendService, long j3, final ao binding) {
        Intrinsics.checkNotNullParameter(friendService, "$friendService");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        final String friendName = friendService.getFriendName(String.valueOf(j3), false);
        if (QLog.isColorLevel()) {
            QLog.i("ZplanSmallHomeTransitFragment", 2, "uin: " + j3 + " name is " + friendName);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.basescene.f
            @Override // java.lang.Runnable
            public final void run() {
                ZplanSmallHomeTransitFragment.ti(friendName, binding);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(String str, ao binding) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        if (str == null || str.length() == 0) {
            binding.f398882q.setVisibility(8);
        } else {
            binding.f398882q.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wi() {
        MutableLiveData<com.tencent.mobileqq.vas.data.e> N1 = Ci().N1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.vas.data.e, Unit> function1 = new Function1<com.tencent.mobileqq.vas.data.e, Unit>() { // from class: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$bindSmallHomePageInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.vas.data.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.vas.data.e it) {
                ZplanSmallHomeTransitFragment.this.Si();
                ZplanSmallHomeTransitFragment zplanSmallHomeTransitFragment = ZplanSmallHomeTransitFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                zplanSmallHomeTransitFragment.Ri(it);
                ZplanSmallHomeTransitFragment.this.initReport();
            }
        };
        N1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.basescene.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanSmallHomeTransitFragment.xi(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void zi() {
        yi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_GROUP_TRANSIT;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView;
        ap apVar = this.containerBinding;
        if (apVar == null || (qUSHalfScreenFloatingView = apVar.f398884b) == null) {
            return true;
        }
        qUSHalfScreenFloatingView.t();
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.containerBinding = ap.g(inflater, container, false);
        this.binding = ao.g(inflater, null, false);
        Fi();
        initViews();
        ap apVar = this.containerBinding;
        if (apVar != null) {
            return apVar.getRoot();
        }
        return null;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(activity instanceof QBaseActivity ? (QBaseActivity) activity : null);
        if (systemBarComp != null) {
            systemBarComp.setStatusBarColor(0);
        }
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String Di = Di();
        if (Di != null) {
            v.f373305a.c(R.string.xhl, Di);
            finishActivity();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$e", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e implements URLDrawable.URLDrawableListener {
        e() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            ZplanSmallHomeTransitFragment.this.Ji();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            Drawable currDrawable = p06 != null ? p06.getCurrDrawable() : null;
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).setOnPlayRepeatListener(ZplanSmallHomeTransitFragment.this.apngLis);
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
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.basescene.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZplanSmallHomeTransitFragment.Ui(ZplanSmallHomeTransitFragment.this, valueAnimator);
            }
        });
        ofFloat.addListener(new f(callback));
        ofFloat.start();
    }

    private final void ui() {
        Pi(4);
        MutableLiveData<SmallHomeInfo> M1 = Ci().M1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<SmallHomeInfo, Unit> function1 = new Function1<SmallHomeInfo, Unit>() { // from class: com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment$bindResidenceInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SmallHomeInfo smallHomeInfo) {
                invoke2(smallHomeInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SmallHomeInfo smallHomeInfo) {
                ZplanSmallHomeTransitFragment.this.Si();
                ZplanSmallHomeTransitFragment.this.initReport();
            }
        };
        M1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.basescene.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZplanSmallHomeTransitFragment.vi(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void yi() {
        MasterInfo masterInfo;
        Long longOrNull;
        QLog.d("ZplanSmallHomeTransitFragment", 1, "bindUserInfo");
        TransitPageInfo transitPageInfo = this.transitPageInfo;
        long longValue = (transitPageInfo == null || (masterInfo = transitPageInfo.getMasterInfo()) == null || (r0 = masterInfo.getUin()) == null || longOrNull == null) ? 0L : longOrNull.longValue();
        if (longValue <= 0) {
            return;
        }
        oi(longValue);
        ri(longValue);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f200308d;

        f(Function0<Unit> function0) {
            this.f200308d = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f200308d.invoke();
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/basescene/ZplanSmallHomeTransitFragment$g", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class g implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SmallHomeInfo f200309d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZplanSmallHomeTransitFragment f200310e;

        g(SmallHomeInfo smallHomeInfo, ZplanSmallHomeTransitFragment zplanSmallHomeTransitFragment) {
            this.f200309d = smallHomeInfo;
            this.f200310e = zplanSmallHomeTransitFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            String str = this.f200309d.getSquareCnt() + "\u5e73\u7c73 " + this.f200309d.getRoomCnt() + "\u623f";
            ao aoVar = this.f200310e.binding;
            TextView textView = aoVar != null ? aoVar.f398874i : null;
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
