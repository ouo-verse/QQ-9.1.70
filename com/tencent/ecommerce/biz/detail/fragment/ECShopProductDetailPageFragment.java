package com.tencent.ecommerce.biz.detail.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ECSchemeExtUserDataMap;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.share.api.ECActionItemClickListener;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.tabbar.ECTabCoverInfo;
import com.tencent.ecommerce.base.ui.tabbar.ECTabLayout;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.ui.ECShopDetailItemDecoration;
import com.tencent.ecommerce.biz.detail.ui.GetCurrentFloatMode;
import com.tencent.ecommerce.biz.detail.ui.ReportCallback;
import com.tencent.ecommerce.biz.detail.ui.a;
import com.tencent.ecommerce.biz.detail.ui.view.ECProductDetailLiveEntryView;
import com.tencent.ecommerce.biz.detail.utils.ECDetailPageDuration;
import com.tencent.ecommerce.biz.detail.utils.ECSourceFrom;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.detail.utils.f;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailCustomViewModel;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.broadcast.ECShopProductCountdownBroadcast;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.broadcast.ECShopProductCountdownStatus;
import com.tencent.ecommerce.biz.retain.ECRetainViewOption;
import com.tencent.ecommerce.biz.shophome.repo.ECShareActionInfo;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportCouponParams;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSRootNode;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import zi0.ECForegroundEvent;

@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0002\u00e8\u0001\u0018\u0000 \u00ee\u00012\u00020\u0001:\u0002\u00ef\u0001B\t\u00a2\u0006\u0006\b\u00ec\u0001\u0010\u00ed\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J.\u0010$\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 2\b\b\u0002\u0010#\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u0004H\u0003J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u000eH\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\u0018\u00107\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u0010H\u0002J\b\u00108\u001a\u00020\fH\u0002J\b\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\nH\u0002R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010AR\u0016\u0010j\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010AR\u0016\u0010l\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010aR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010uR\u0016\u0010\u007f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u0018\u0010\u0083\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010~R\u0018\u0010\u0085\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010~R\u0018\u0010\u0087\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010~R\u0018\u0010\u0089\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010~R\u0018\u0010\u008b\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010~R\u0018\u0010\u008d\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010~R\u0018\u0010\u008f\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010~R\u0018\u0010\u0091\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010~R\u0018\u0010\u0093\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010~R\u0018\u0010\u0095\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0094\u0001\u0010~R\u0018\u0010\u0097\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0096\u0001\u0010`R\u0018\u0010\u0099\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0098\u0001\u0010~R\u0018\u0010\u009b\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009a\u0001\u0010~R\u0018\u0010\u009d\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010~R\u0018\u0010\u009f\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009e\u0001\u0010~R\u0018\u0010\u00a1\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010~R\u0018\u0010\u00a3\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a2\u0001\u0010~R\u0018\u0010\u00a5\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a4\u0001\u0010~R\u0018\u0010\u00a7\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a6\u0001\u0010uR\u0018\u0010\u00a9\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a8\u0001\u0010uR\u0018\u0010\u00ab\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00aa\u0001\u0010~R\u0018\u0010\u00ad\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ac\u0001\u0010`R\u001c\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R!\u0010\u00b7\u0001\u001a\u00030\u00b2\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001\u001a\u0006\b\u00b5\u0001\u0010\u00b6\u0001R\u001c\u0010\u00bb\u0001\u001a\u0005\u0018\u00010\u00b8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u001c\u0010\u00bf\u0001\u001a\u0005\u0018\u00010\u00bc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u001a\u0010\u00c3\u0001\u001a\u00030\u00c0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c2\u0001R\u0018\u0010\u00c5\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c4\u0001\u0010`R\u0018\u0010\u00c7\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c6\u0001\u0010`R\u0018\u0010\u00c9\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c8\u0001\u0010`R\u0018\u0010\u00cb\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ca\u0001\u0010uR\u0018\u0010\u00cd\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00cc\u0001\u0010`R\u0018\u0010\u00cf\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ce\u0001\u0010uR\u0018\u0010\u00d1\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00d0\u0001\u0010AR$\u0010\u00d5\u0001\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00d2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d3\u0001\u0010\u00d4\u0001R\u0018\u0010\u00d7\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d6\u0001\u0010uR\u0018\u0010\u00d9\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d8\u0001\u0010uR\u0018\u0010\u00db\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00da\u0001\u0010uR\u0018\u0010\u00dd\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00dc\u0001\u0010uR\u0018\u0010\u00df\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00de\u0001\u0010`R\u001a\u0010\u00e3\u0001\u001a\u00030\u00e0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u00e2\u0001R\u001c\u0010\u00e7\u0001\u001a\u0005\u0018\u00010\u00e4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u00e6\u0001R\u0018\u0010\u00eb\u0001\u001a\u00030\u00e8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e9\u0001\u0010\u00ea\u0001\u00a8\u0006\u00f0\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "initViewModel", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Vi", "bj", "aj", "initArguments", "key", "", "", "map", RemoteHandleConst.PARAM_DEFAULT_VALUE, "Si", "Zi", "ej", "cj", "fj", "Ui", "Xi", "targetPosition", "hj", "isLoading", "jj", "Yi", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "shopDetailInfo", "Pi", "Oi", "Wi", "isVisible", "targetView", "ij", "Ri", "gj", "shareAction", "dj", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailCustomViewModel;", "P", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailCustomViewModel;", "viewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "titleBarParent", BdhLogUtil.LogTag.Tag_Req, "titleBar", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "detailPageRecyclerView", "Lcom/tencent/ecommerce/biz/detail/ui/d;", "T", "Lcom/tencent/ecommerce/biz/detail/ui/d;", "ecBaseRecyclerViewAdapter", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "blackBackButton", "V", "shareImageBtn", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "W", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "tabLayout", "Lcom/tencent/ecommerce/biz/detail/ui/a;", "X", "Lcom/tencent/ecommerce/biz/detail/ui/a;", "tabLayoutController", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "Y", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "shopBottomBar", "Landroid/view/ViewGroup;", "Z", "Landroid/view/ViewGroup;", "shopBottomBarContainer", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "a0", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "shopBottomBarController", "b0", "shopNetworkErrorContainer", "c0", "shopNetworkErrorRetryBtn", "d0", "loadingViewContainer", "Lcom/tencent/ecommerce/biz/detail/ui/view/ECProductDetailLiveEntryView;", "e0", "Lcom/tencent/ecommerce/biz/detail/ui/view/ECProductDetailLiveEntryView;", "liveEntryView", "f0", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "productDetailInfo", "g0", "I", "scrollY", "Lcom/tencent/ecommerce/base/ktx/ECSchemeExtUserDataMap;", "h0", "Lcom/tencent/ecommerce/base/ktx/ECSchemeExtUserDataMap;", "serializableMap", "i0", WadlProxyConsts.CHANNEL, "j0", "Ljava/lang/String;", "saasType", "k0", "saasProductId", "l0", "sellerId", "m0", "sellerMediaId", "n0", "mediaProductID", "o0", "categoryName", "p0", "goodsType", "q0", "categoryId", "r0", "sealTransfer", "s0", GetAdInfoRequest.SOURCE_FROM, "t0", "roomId", "u0", "programId", "v0", "hideLiveIcon", "w0", "adClickId", "x0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "y0", "bizType", "z0", "shopId", "A0", "spuId", "B0", "littleWorldFeedId", "C0", "activeId", "D0", "activeType", "E0", "role", "F0", "buyNow", "G0", "isSelect", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "H0", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "addProductCallback", "Lkotlinx/coroutines/CoroutineScope;", "I0", "Lkotlin/Lazy;", "Qi", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "J0", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "detailPageDurationReport", "Landroid/animation/ObjectAnimator;", "K0", "Landroid/animation/ObjectAnimator;", "animatorForAlpha", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "L0", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "M0", "isFloatMode", "N0", "currentIsFloatMode", "O0", "isFromLive", "P0", "floatMarginTop", "Q0", "isCloseButtonVisible", "R0", "scrollerState", "S0", "floatCloseButton", "", "T0", "Ljava/util/Map;", "itemHeightMap", "U0", "titleBarOffset", "V0", "tabOffsetYForComment", "W0", "tabOffsetYForDetail", "X0", "tabOffsetYForRecommend", "Y0", "isScrollingByTabClick", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownBroadcast;", "Z0", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/broadcast/ECShopProductCountdownBroadcast;", "countdownBroadcast", "Lcom/tencent/ecommerce/biz/detail/utils/c;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/ecommerce/biz/detail/utils/c;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$n", "b1", "Lcom/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$n;", "observer", "<init>", "()V", "c1", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailPageFragment extends ECBaseFragment {

    /* renamed from: D0, reason: from kotlin metadata */
    private int activeType;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean isSelect;

    /* renamed from: H0, reason: from kotlin metadata */
    private IECSchemeCallback addProductCallback;

    /* renamed from: I0, reason: from kotlin metadata */
    private final Lazy lifecycleScope;

    /* renamed from: J0, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.b detailPageDurationReport;

    /* renamed from: K0, reason: from kotlin metadata */
    private ObjectAnimator animatorForAlpha;

    /* renamed from: L0, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: M0, reason: from kotlin metadata */
    private boolean isFloatMode;

    /* renamed from: N0, reason: from kotlin metadata */
    private boolean currentIsFloatMode;

    /* renamed from: O0, reason: from kotlin metadata */
    private boolean isFromLive;

    /* renamed from: P, reason: from kotlin metadata */
    private ECShopProductDetailCustomViewModel viewModel;

    /* renamed from: P0, reason: from kotlin metadata */
    private int floatMarginTop;

    /* renamed from: Q, reason: from kotlin metadata */
    private View titleBarParent;

    /* renamed from: Q0, reason: from kotlin metadata */
    private boolean isCloseButtonVisible;

    /* renamed from: R, reason: from kotlin metadata */
    private View titleBar;

    /* renamed from: R0, reason: from kotlin metadata */
    private int scrollerState;

    /* renamed from: S, reason: from kotlin metadata */
    private ECBaseRecyclerView detailPageRecyclerView;

    /* renamed from: S0, reason: from kotlin metadata */
    private View floatCloseButton;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.ui.d ecBaseRecyclerViewAdapter;

    /* renamed from: T0, reason: from kotlin metadata */
    private final Map<Integer, Integer> itemHeightMap;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView blackBackButton;

    /* renamed from: U0, reason: from kotlin metadata */
    private int titleBarOffset;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView shareImageBtn;

    /* renamed from: V0, reason: from kotlin metadata */
    private int tabOffsetYForComment;

    /* renamed from: W, reason: from kotlin metadata */
    private ECTabLayout tabLayout;

    /* renamed from: W0, reason: from kotlin metadata */
    private int tabOffsetYForDetail;

    /* renamed from: X, reason: from kotlin metadata */
    private a tabLayoutController;

    /* renamed from: X0, reason: from kotlin metadata */
    private int tabOffsetYForRecommend;

    /* renamed from: Y, reason: from kotlin metadata */
    private ECBasePtsView shopBottomBar;

    /* renamed from: Y0, reason: from kotlin metadata */
    private boolean isScrollingByTabClick;

    /* renamed from: Z, reason: from kotlin metadata */
    private ViewGroup shopBottomBarContainer;

    /* renamed from: Z0, reason: from kotlin metadata */
    private ECShopProductCountdownBroadcast countdownBroadcast;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ECBaseViewController shopBottomBarController;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.c reportParams;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View shopNetworkErrorContainer;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private final n observer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View shopNetworkErrorRetryBtn;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup loadingViewContainer;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ECProductDetailLiveEntryView liveEntryView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ECShopProductDetailInfo productDetailInfo;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int scrollY;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private boolean hideLiveIcon;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private ECSchemeExtUserDataMap serializableMap = new ECSchemeExtUserDataMap(null, 1, null);

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private String saasType = "";

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private String saasProductId = "";

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private String sellerId = "";

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private String sellerMediaId = "";

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private String mediaProductID = "";

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private String categoryName = "";

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private String goodsType = "";

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private String categoryId = "";

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private String sealTransfer = "";

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private String sourceFrom = String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal());

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private String roomId = "";

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private String programId = "";

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private String adClickId = "";

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private String requestId = "";

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private String bizType = "";

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private String shopId = "";

    /* renamed from: A0, reason: from kotlin metadata */
    private String spuId = "";

    /* renamed from: B0, reason: from kotlin metadata */
    private String littleWorldFeedId = "";

    /* renamed from: C0, reason: from kotlin metadata */
    private String activeId = "";

    /* renamed from: E0, reason: from kotlin metadata */
    private int role = 1;

    /* renamed from: F0, reason: from kotlin metadata */
    private String buyNow = "0";

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$c", "Lcom/tencent/ecommerce/biz/detail/ui/GetCurrentFloatMode;", "", "isFloatMode", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements GetCurrentFloatMode {
        c() {
        }

        @Override // com.tencent.ecommerce.biz.detail.ui.GetCurrentFloatMode
        public boolean isFloatMode() {
            return ECShopProductDetailPageFragment.this.currentIsFloatMode;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$d", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "state", "onStateChange", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends com.tencent.ecommerce.base.ui.c {
        d() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECShopProductDetailPageFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onStateChange(int state) {
            IECVideoControlDelegate videoControl;
            IECVideoControlDelegate videoControl2;
            if (state == 6) {
                ECShopProductDetailPageFragment eCShopProductDetailPageFragment = ECShopProductDetailPageFragment.this;
                eCShopProductDetailPageFragment.ij(false, ECShopProductDetailPageFragment.Wh(eCShopProductDetailPageFragment));
                if (!TextUtils.isEmpty(ECShopProductDetailPageFragment.this.littleWorldFeedId) && (videoControl2 = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) != null) {
                    videoControl2.sendVideoControlEvent(ECShopProductDetailPageFragment.this.littleWorldFeedId, true);
                }
                ECShopProductDetailPageFragment.this.currentIsFloatMode = false;
                cg0.a.b("ECShopProductDetailPageFragment", "floatGestureLayout onStateChange GESTURE_STATE_DOING_AUTO_TOP");
                return;
            }
            if (state == 7) {
                ECShopProductDetailPageFragment eCShopProductDetailPageFragment2 = ECShopProductDetailPageFragment.this;
                eCShopProductDetailPageFragment2.ij(true, ECShopProductDetailPageFragment.Wh(eCShopProductDetailPageFragment2));
                if (!TextUtils.isEmpty(ECShopProductDetailPageFragment.this.littleWorldFeedId) && (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) != null) {
                    videoControl.sendVideoControlEvent(ECShopProductDetailPageFragment.this.littleWorldFeedId, false);
                }
                ECShopProductDetailPageFragment.this.currentIsFloatMode = true;
                cg0.a.b("ECShopProductDetailPageFragment", "floatGestureLayout onStateChange GESTURE_STATE_DOING_AUTO_SUS");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$e", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements ECFloatGestureLayout.ContentScrollListener {
        e() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return ECShopProductDetailPageFragment.this.scrollerState;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECShopProductDetailPageFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$g", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "data", "", "position", "", "onTabClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements ECTabLayout.OnTabClickListener {
        g() {
        }

        @Override // com.tencent.ecommerce.base.ui.tabbar.ECTabLayout.OnTabClickListener
        public void onTabClick(ECTabCoverInfo data, int position) {
            if (ECShopProductDetailPageFragment.Uh(ECShopProductDetailPageFragment.this).getChildCount() > 0 && ECShopProductDetailPageFragment.oi(ECShopProductDetailPageFragment.this).getAlpha() != 0.0f) {
                if (position != ECShopProductDetailPageFragment.oi(ECShopProductDetailPageFragment.this).getSelectedIndex()) {
                    ECShopProductDetailPageFragment.this.isScrollingByTabClick = true;
                }
                ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(position);
                String str = data.tabIdentifier;
                if (str != null) {
                    ECShopProductDetailPageFragment.this.hj(ECShopProductDetailPageFragment.Vh(ECShopProductDetailPageFragment.this).j0(str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShopProductDetailPageFragment.this.ej();
            ECShopProductDetailPageFragment.this.jj(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShopProductDetailPageFragment.Xh(ECShopProductDetailPageFragment.this).E();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$k", "Lcom/tencent/ecommerce/biz/detail/ui/GetCurrentFloatMode;", "", "isFloatMode", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k implements GetCurrentFloatMode {
        k() {
        }

        @Override // com.tencent.ecommerce.biz.detail.ui.GetCurrentFloatMode
        public boolean isFloatMode() {
            return ECShopProductDetailPageFragment.this.currentIsFloatMode;
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$l", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l extends com.tencent.ecommerce.base.ui.e {
        l() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            ECShopProductDetailInfo eCShopProductDetailInfo = ECShopProductDetailPageFragment.this.productDetailInfo;
            if (eCShopProductDetailInfo != null) {
                com.tencent.ecommerce.base.ui.i.f101155b.d(ECShopProductDetailPageFragment.this.requireContext().getResources().getString(R.string.wf6), ECToastIcon.ICON_SUCCESS, 0);
                cg0.a.b("ECShopProductDetailPageFragment", "[handleAddBtnClick] id = " + ECShopProductDetailPageFragment.this.getId() + ", saasProductId = " + eCShopProductDetailInfo.productID);
                JSONObject optJSONObject = eCShopProductDetailInfo.infoData.optJSONObject("product");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                IECSchemeCallback iECSchemeCallback = ECShopProductDetailPageFragment.this.addProductCallback;
                if (iECSchemeCallback != null) {
                    iECSchemeCallback.onCallbackFinished(optJSONObject);
                }
                if (ECShopProductDetailPageFragment.this.requireContext() instanceof Activity) {
                    Context requireContext = ECShopProductDetailPageFragment.this.requireContext();
                    if (requireContext != null) {
                        ((Activity) requireContext).finish();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                }
            }
            com.tencent.ecommerce.biz.detail.utils.d.f102466a.c("", ECShopProductDetailPageFragment.this.shopId, ECShopProductDetailPageFragment.this.spuId, ECShopProductDetailPageFragment.this.role, ECShopProductDetailPageFragment.this.activeId, ECShopProductDetailPageFragment.this.activeType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShopProductDetailPageFragment.this.gj();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$n", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lzi0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class n implements EventObserver<ECForegroundEvent> {
        n() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECForegroundEvent event) {
            boolean z16 = event.isForeground;
            if (z16) {
                ECShopProductDetailPageFragment eCShopProductDetailPageFragment = ECShopProductDetailPageFragment.this;
                eCShopProductDetailPageFragment.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(eCShopProductDetailPageFragment.sourceFrom);
                com.tencent.ecommerce.biz.detail.utils.b bVar = ECShopProductDetailPageFragment.this.detailPageDurationReport;
                if (bVar != null) {
                    bVar.d();
                }
                ECShopProductDetailPageFragment.this.fj();
                return;
            }
            if (z16) {
                return;
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar2 = ECShopProductDetailPageFragment.this.detailPageDurationReport;
            if (bVar2 != null) {
                com.tencent.ecommerce.biz.detail.utils.b.c(bVar2, null, 1, null);
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar3 = ECShopProductDetailPageFragment.this.detailPageDurationReport;
            if (bVar3 != null) {
                bVar3.f();
            }
            ECShopProductDetailPageFragment.this.detailPageDurationReport = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$o", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/e;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class o implements EventObserver<com.tencent.ecommerce.biz.detail.repo.shop.data.e> {
        o() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(com.tencent.ecommerce.biz.detail.repo.shop.data.e event) {
            if (!Intrinsics.areEqual(ECShopProductDetailPageFragment.this.shopId, event.shopId)) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("OnEventBus live status change:");
            sb5.append("[shop:");
            sb5.append(ECShopProductDetailPageFragment.this.shopId);
            sb5.append(" spuId:");
            sb5.append(ECShopProductDetailPageFragment.this.spuId);
            sb5.append(" roomID:");
            com.tencent.ecommerce.biz.detail.repo.shop.data.f info = event.getInfo();
            sb5.append(info != null ? Long.valueOf(info.roomId) : null);
            sb5.append(", status:");
            com.tencent.ecommerce.biz.detail.repo.shop.data.f info2 = event.getInfo();
            sb5.append(info2 != null ? Integer.valueOf(info2.status) : null);
            sb5.append(']');
            cg0.a.b("ECShopProductDetailPageFragment", sb5.toString());
            com.tencent.ecommerce.biz.detail.repo.shop.data.f info3 = event.getInfo();
            if (info3 != null) {
                ECShopProductDetailPageFragment.ci(ECShopProductDetailPageFragment.this).setLiveStatusInfo(info3);
                com.tencent.ecommerce.biz.detail.utils.c cVar = ECShopProductDetailPageFragment.this.reportParams;
                if (cVar != null) {
                    cVar.j(info3.status);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/Map;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class q<T> implements Observer<Map<String, ? extends String>> {
        q() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Map<String, String> map) {
            String str = map.get("QSTORE_PRD_DETAIL_EVENT_CODE");
            if (str != null) {
                if (Intrinsics.areEqual(str, "qstore_prd_detail_price_reduce_clk")) {
                    com.tencent.ecommerce.biz.detail.utils.d.f102466a.m(ECShopProductDetailPageFragment.this.currentIsFloatMode, ECShopProductDetailPageFragment.this.sellerId, ECShopProductDetailPageFragment.this.shopId, ECShopProductDetailPageFragment.this.spuId, String.valueOf(ECShopProductDetailPageFragment.this.role));
                } else {
                    com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailPageFragment.this.reportParams, null, str);
                }
            }
            cg0.a.b("ECShopProductDetailPageFragment", "viewModel productDetailLiveData eventName: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/Map;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class r<T> implements Observer<Map<String, ? extends String>> {
        r() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Map<String, String> map) {
            com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailPageFragment.this.reportParams, map, "qstore_prd_detail_pg_recommend_ck");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/repo/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/shophome/repo/a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class s<T> implements Observer<ECShareActionInfo> {
        s() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECShareActionInfo eCShareActionInfo) {
            if (eCShareActionInfo.shareInfo == null) {
                com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wvp, null, 0, 6, null);
                return;
            }
            int i3 = eCShareActionInfo.shareAction;
            if (i3 != 2) {
                if (i3 == 3) {
                    aj0.a.f26146a.d(ECShopProductDetailPageFragment.this.requireActivity(), 1002, eCShareActionInfo.shareInfo);
                    return;
                }
                if (i3 == 9) {
                    aj0.a.f26146a.e(ECShopProductDetailPageFragment.this.requireActivity(), eCShareActionInfo.shareInfo, false);
                    ECShopProductDetailPageFragment.this.dj(9);
                    return;
                } else if (i3 == 10) {
                    aj0.a.f26146a.e(ECShopProductDetailPageFragment.this.requireActivity(), eCShareActionInfo.shareInfo, true);
                    ECShopProductDetailPageFragment.this.dj(10);
                    return;
                } else if (i3 != 72 && i3 != 73) {
                    cg0.a.a("ECShopProductDetailPageFragment", "registerLivedataObserver", "can not deal share action:" + eCShareActionInfo.shareAction);
                    return;
                }
            }
            aj0.a.f26146a.c(ECShopProductDetailPageFragment.this.requireActivity(), 1001, eCShareActionInfo);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$t", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "", "action", "Lcom/tencent/ecommerce/base/share/api/b;", "data", "", "onItemClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class t implements ECActionItemClickListener {
        t() {
        }

        @Override // com.tencent.ecommerce.base.share.api.ECActionItemClickListener
        public void onItemClick(int action, ECActionItemData data) {
            ECShopProductDetailPageFragment.ui(ECShopProductDetailPageFragment.this).s2(ECShopProductDetailPageFragment.this.spuId, action, data);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$u", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationStart", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class u extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f102228d;

        u(View view) {
            this.f102228d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            this.f102228d.setLayerType(0, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
        }
    }

    public ECShopProductDetailPageFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$lifecycleScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.lifecycleScope = lazy;
        this.currentIsFloatMode = this.isFloatMode;
        this.isCloseButtonVisible = true;
        this.itemHeightMap = new ConcurrentHashMap();
        this.tabOffsetYForRecommend = Integer.MAX_VALUE;
        this.observer = new n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oi(ECShopProductDetailInfo shopDetailInfo) {
        int i3 = shopDetailInfo.status;
        cg0.a.b("ECShopProductDetailPageFragment", "configBuyNow buyNow=" + this.buyNow + " shopDetailInfo.status=" + i3);
        if (this.isSelect || i3 == 4 || !Intrinsics.areEqual(this.buyNow, "1")) {
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        com.tencent.ecommerce.biz.detail.ui.c cVar = new com.tencent.ecommerce.biz.detail.ui.c(arguments, new b(), new c());
        JSONObject optJSONObject = shopDetailInfo.infoData.optJSONObject("button");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("button_item");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        if (optJSONArray.length() >= 2) {
            cVar.a(optJSONArray.optJSONObject(2).optString("jump_url"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pi(ECShopProductDetailInfo shopDetailInfo) {
        String str;
        ViewGroup viewGroup = this.shopBottomBarContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarContainer");
        }
        viewGroup.setVisibility(0);
        ViewGroup viewGroup2 = this.shopBottomBarContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarContainer");
        }
        viewGroup2.setClickable(true);
        if (this.isSelect) {
            JSONObject jSONObject = new JSONObject(shopDetailInfo.infoData.toString());
            ECBaseViewController eCBaseViewController = this.shopBottomBarController;
            if (eCBaseViewController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarController");
            }
            eCBaseViewController.h(requireContext(), new ECBasePtsViewData(null, "qshop_detail_bottom_bar_host", jSONObject.toString(), null, 9, null));
            return;
        }
        if (shopDetailInfo.status == 4) {
            ViewGroup viewGroup3 = this.shopBottomBarContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarContainer");
            }
            viewGroup3.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f62512));
            str = "qshop_detail_suspension_business";
        } else {
            str = "qshop_detail_bottom_bar";
        }
        String str2 = str;
        JSONObject jSONObject2 = shopDetailInfo.infoData;
        ECBaseViewController eCBaseViewController2 = this.shopBottomBarController;
        if (eCBaseViewController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBottomBarController");
        }
        eCBaseViewController2.h(requireContext(), new ECBasePtsViewData(null, str2, jSONObject2.toString(), null, 9, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope Qi() {
        return (CoroutineScope) this.lifecycleScope.getValue();
    }

    public static final /* synthetic */ ECShopProductCountdownBroadcast Rh(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        ECShopProductCountdownBroadcast eCShopProductCountdownBroadcast = eCShopProductDetailPageFragment.countdownBroadcast;
        if (eCShopProductCountdownBroadcast == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownBroadcast");
        }
        return eCShopProductCountdownBroadcast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Ri() {
        if (this.scrollerState == 2) {
            return "5";
        }
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return String.valueOf(eCTabLayout.getSelectedIndex() + 1);
    }

    private final String Si(String key, Map<Object, ? extends Object> map, String defaultValue) {
        Intent intent;
        FragmentActivity activity = getActivity();
        String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra(key);
        if (stringExtra != null) {
            return stringExtra;
        }
        if (!map.containsKey(key) || !(map.get(key) instanceof String)) {
            return defaultValue;
        }
        Object obj = map.get(key);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public static final /* synthetic */ ECBaseRecyclerView Uh(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCShopProductDetailPageFragment.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        return eCBaseRecyclerView;
    }

    private final void Ui() {
        IECVideoControlDelegate videoControl;
        if (this.isFloatMode) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("status_immersive", true);
            if (this.isFromLive) {
                bundle.putInt("scroll_margin_top", (this.floatMarginTop - 44) - ((int) ECDeviceUtils.f104857e.i(com.tencent.ecommerce.biz.util.r.f104881b.a(getActivity()))));
                bundle.putBoolean("mask_view_trans", true);
                bundle.putBoolean("margin_top_ignore_bottom_bar", true);
            } else {
                bundle.putInt("scroll_margin_top", com.tencent.ecommerce.biz.util.e.c(90.0f) - com.tencent.ecommerce.biz.util.r.f104881b.a(getActivity()));
            }
            bundle.putInt(LayoutAttrDefine.MARGIN_TOP, com.tencent.ecommerce.biz.util.e.c(44.0f) + com.tencent.ecommerce.biz.util.r.f104881b.a(getActivity()));
            bundle.putBoolean("need_reset_view_config", true);
            ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
            this.floatGestureLayout = eCFloatGestureLayout;
            eCFloatGestureLayout.setFloatEventListener(new d());
            ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
            if (eCFloatGestureLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
            }
            eCFloatGestureLayout2.setContentScrollListener(new e());
            ECFloatGestureLayout eCFloatGestureLayout3 = this.floatGestureLayout;
            if (eCFloatGestureLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
            }
            eCFloatGestureLayout3.C(this, -1, R.id.nwv);
            ECFloatGestureLayout eCFloatGestureLayout4 = this.floatGestureLayout;
            if (eCFloatGestureLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
            }
            View view = this.titleBarParent;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBarParent");
            }
            eCFloatGestureLayout4.z(view, com.tencent.ecommerce.biz.util.e.c(44.0f));
            if (TextUtils.isEmpty(this.littleWorldFeedId) || (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) == null) {
                return;
            }
            videoControl.sendVideoControlEvent(this.littleWorldFeedId, false);
        }
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.detail.ui.d Vh(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        com.tencent.ecommerce.biz.detail.ui.d dVar = eCShopProductDetailPageFragment.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        return dVar;
    }

    private final void Vi() {
        ImageView imageView = this.blackBackButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blackBackButton");
        }
        imageView.setOnClickListener(new f());
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.addOnScrollListener(new ECShopProductDetailPageFragment$initListeners$2(this));
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        eCTabLayout.setOnTabClickListener(new g());
        View view = this.shopNetworkErrorRetryBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopNetworkErrorRetryBtn");
        }
        view.setOnClickListener(new h());
        View view2 = this.floatCloseButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatCloseButton");
        }
        view2.setOnClickListener(new i());
        bj();
        aj();
    }

    public static final /* synthetic */ View Wh(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        View view = eCShopProductDetailPageFragment.floatCloseButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatCloseButton");
        }
        return view;
    }

    private final void Wi() {
        ECBasePtsView eCBasePtsView = new ECBasePtsView(requireContext());
        ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext(), eCBasePtsView);
        Context requireContext = requireContext();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("show_head", true);
        Unit unit = Unit.INSTANCE;
        eCBaseViewController.h(requireContext, new ECBasePtsViewData(null, "qshop_detail_loading", jSONObject.toString(), null, 9, null));
        ViewGroup viewGroup = this.loadingViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        viewGroup.addView(eCBasePtsView);
    }

    public static final /* synthetic */ ECFloatGestureLayout Xh(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCShopProductDetailPageFragment.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        return eCFloatGestureLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xi() {
        ECShopReportCouponParams eCShopReportCouponParams;
        ECShopProductDetailInfo eCShopProductDetailInfo = this.productDetailInfo;
        if (eCShopProductDetailInfo != null) {
            JSONObject optJSONObject = eCShopProductDetailInfo.infoData.optJSONObject("user_right");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.role = optJSONObject.optInt("role_id", 1);
            if (!TextUtils.isEmpty(eCShopProductDetailInfo.infoData.optString("spu_id"))) {
                this.spuId = eCShopProductDetailInfo.infoData.optString("spu_id");
            }
            JSONObject optJSONObject2 = eCShopProductDetailInfo.infoData.optJSONObject("shop");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            if (!TextUtils.isEmpty(optJSONObject2.optString("id"))) {
                this.shopId = optJSONObject2.optString("id");
            }
            JSONObject optJSONObject3 = eCShopProductDetailInfo.infoData.optJSONObject("product");
            if (optJSONObject3 == null) {
                optJSONObject3 = new JSONObject();
            }
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("category");
            if (optJSONObject4 == null) {
                optJSONObject4 = new JSONObject();
            }
            if (!TextUtils.isEmpty(optJSONObject4.optString("first_cat_id"))) {
                String optString = optJSONObject4.optString("first_cat_id");
                if (optString == null) {
                    optString = this.categoryId;
                }
                this.categoryId = optString;
            }
            JSONObject optJSONObject5 = eCShopProductDetailInfo.infoData.optJSONObject("active_info");
            if (optJSONObject5 == null) {
                optJSONObject5 = new JSONObject();
            }
            this.activeId = optJSONObject5.optString("active_id", "");
            this.activeType = optJSONObject5.optInt("active_type", 0);
            eCShopReportCouponParams = com.tencent.ecommerce.biz.shophome.util.a.f104379a.b(optJSONObject3);
        } else {
            eCShopReportCouponParams = null;
        }
        fj();
        com.tencent.ecommerce.biz.detail.utils.c cVar = new com.tencent.ecommerce.biz.detail.utils.c();
        cVar.g(this.isFloatMode ? 1 : 2);
        cVar.q(this.sellerId);
        cVar.r(this.shopId);
        cVar.i(this.spuId);
        cVar.t(this.spuId);
        cVar.m(this.role);
        cVar.h(this.categoryId);
        cVar.s(this.sourceFrom);
        cVar.n(this.roomId);
        cVar.o(this.saasType);
        cVar.d(this.littleWorldFeedId);
        cVar.f(this.isSelect ? 2 : 1);
        cVar.a(this.activeId);
        cVar.k(this.programId);
        cVar.b(this.activeType);
        cVar.l(this.requestId);
        cVar.p(this.sealTransfer);
        cVar.e(eCShopReportCouponParams);
        cVar.c(this.adClickId);
        Unit unit = Unit.INSTANCE;
        this.reportParams = cVar;
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        dVar.y0(this.reportParams);
    }

    private final void Yi() {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        Context requireContext = requireContext();
        ECBasePtsView eCBasePtsView = this.shopBottomBar;
        if (eCBasePtsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBottomBar");
        }
        ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext, eCBasePtsView);
        this.shopBottomBarController = eCBaseViewController;
        Pair[] pairArr = new Pair[2];
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        pairArr[0] = TuplesKt.to("allInOneJump", new com.tencent.ecommerce.biz.detail.ui.c(arguments, new j(), new k()));
        pairArr[1] = TuplesKt.to("shopAddAction", new l());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        eCBaseViewController.i(mapOf);
    }

    private final void Zi() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(this.spuId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("spu_id", this.spuId);
        jSONObject.put("shop_id", this.shopId);
        jSONObject.put("spu_ids", jSONArray);
        jSONObject.put("active_id", this.activeId);
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel = this.viewModel;
        if (eCShopProductDetailCustomViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailCustomViewModel.x2(this.spuId, jSONObject);
    }

    private final void aj() {
        this.countdownBroadcast = new ECShopProductCountdownBroadcast(new Function2<Context, ECShopProductCountdownStatus, Unit>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLiveCountdownEventObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Context context, ECShopProductCountdownStatus eCShopProductCountdownStatus) {
                invoke2(context, eCShopProductCountdownStatus);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Context context, ECShopProductCountdownStatus eCShopProductCountdownStatus) {
                JSONObject jSONObject;
                if (eCShopProductCountdownStatus == ECShopProductCountdownStatus.END) {
                    ECShopProductDetailPageFragment.this.ej();
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLiveCountdownEventObserver$1.1
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
                            ECShopProductDetailPageFragment.Rh(ECShopProductDetailPageFragment.this).c(ECShopProductDetailPageFragment.this.requireContext());
                        }
                    });
                    ECShopProductDetailInfo eCShopProductDetailInfo = ECShopProductDetailPageFragment.this.productDetailInfo;
                    if (eCShopProductDetailInfo == null || (jSONObject = eCShopProductDetailInfo.infoData) == null || !f.b(jSONObject)) {
                        return;
                    }
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLiveCountdownEventObserver$1.2
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            i.f101155b.c(R.string.wtb, ECToastIcon.ICON_DEFAULT, 0);
                        }
                    });
                }
            }
        }).b(requireContext());
    }

    private final void bj() {
        LifecycleEventBus.f100688b.c(ThreadMode.MAIN, this, com.tencent.ecommerce.biz.detail.repo.shop.data.e.class, new o());
    }

    public static final /* synthetic */ ECProductDetailLiveEntryView ci(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        ECProductDetailLiveEntryView eCProductDetailLiveEntryView = eCShopProductDetailPageFragment.liveEntryView;
        if (eCProductDetailLiveEntryView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveEntryView");
        }
        return eCProductDetailLiveEntryView;
    }

    private final void cj() {
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel = this.viewModel;
        if (eCShopProductDetailCustomViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailCustomViewModel.a2().observe(getViewLifecycleOwner(), new Observer<List<? extends ECBasePtsViewData>>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(final List<ECBasePtsViewData> list) {
                ECShopProductDetailPageFragment.this.jj(false);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                if (ECShopProductDetailPageFragment.ui(ECShopProductDetailPageFragment.this).l2(arrayList)) {
                    ECShopProductDetailPageFragment.Vh(ECShopProductDetailPageFragment.this).addData(arrayList);
                } else {
                    ECShopProductDetailPageFragment.Vh(ECShopProductDetailPageFragment.this).setData(arrayList);
                }
                ECShopProductDetailPageFragment.Uh(ECShopProductDetailPageFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3;
                        int i16;
                        Map map;
                        Map map2;
                        Map map3;
                        int i17;
                        PTSAppInstance ptsAppInstance;
                        PTSRootNode rootNode;
                        PTSNodeInfo rootNodeInfo;
                        PTSNodeStyle style;
                        int size = list.size();
                        int i18 = 0;
                        boolean z16 = false;
                        for (int i19 = 0; i19 < size; i19++) {
                            PTSComposer ptsComposer = ((ECBasePtsViewData) list.get(i19)).getPtsComposer();
                            if (i19 == 0) {
                                z16 = !Intrinsics.areEqual("product_detail_mainpic", ptsComposer != null ? ptsComposer.getPageName() : null);
                            }
                            Integer valueOf = (ptsComposer == null || (ptsAppInstance = ptsComposer.getPtsAppInstance()) == null || (rootNode = ptsAppInstance.getRootNode()) == null || (rootNodeInfo = rootNode.getRootNodeInfo()) == null || (style = rootNodeInfo.getStyle()) == null) ? null : Integer.valueOf(style.getHeight());
                            if (Intrinsics.areEqual("qshop_detail_comment", ptsComposer != null ? ptsComposer.getPageName() : null)) {
                                ECShopProductDetailPageFragment eCShopProductDetailPageFragment = ECShopProductDetailPageFragment.this;
                                i17 = eCShopProductDetailPageFragment.titleBarOffset;
                                eCShopProductDetailPageFragment.tabOffsetYForComment = i18 - i17;
                            } else if (Intrinsics.areEqual("qshop_product_detail_table_title", ptsComposer != null ? ptsComposer.getPageName() : null)) {
                                ECShopProductDetailPageFragment eCShopProductDetailPageFragment2 = ECShopProductDetailPageFragment.this;
                                i16 = eCShopProductDetailPageFragment2.titleBarOffset;
                                eCShopProductDetailPageFragment2.tabOffsetYForDetail = i18 - i16;
                            } else if (Intrinsics.areEqual("qshop_detail_recommen_title_new", ptsComposer != null ? ptsComposer.getPageName() : null)) {
                                ECShopProductDetailPageFragment eCShopProductDetailPageFragment3 = ECShopProductDetailPageFragment.this;
                                i3 = eCShopProductDetailPageFragment3.titleBarOffset;
                                eCShopProductDetailPageFragment3.tabOffsetYForRecommend = i18 - i3;
                            }
                            if (valueOf != null) {
                                i18 += valueOf.intValue();
                                if (z16) {
                                    map2 = ECShopProductDetailPageFragment.this.itemHeightMap;
                                    map3 = ECShopProductDetailPageFragment.this.itemHeightMap;
                                    map2.put(Integer.valueOf(map3.size()), valueOf);
                                } else {
                                    map = ECShopProductDetailPageFragment.this.itemHeightMap;
                                    map.put(Integer.valueOf(i19), valueOf);
                                }
                            }
                        }
                    }
                });
            }
        });
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel2 = this.viewModel;
        if (eCShopProductDetailCustomViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailCustomViewModel2.i2().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$2$1", f = "ECShopProductDetailPageFragment.kt", i = {}, l = {608}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$2$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ JSONArray $spuIdList;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(JSONArray jSONArray, Continuation continuation) {
                    super(2, continuation);
                    this.$spuIdList = jSONArray;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$spuIdList, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ECShopProductDetailCustomViewModel ui5 = ECShopProductDetailPageFragment.ui(ECShopProductDetailPageFragment.this);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("spu_id", ECShopProductDetailPageFragment.this.spuId);
                        jSONObject.put("spu_ids", this.$spuIdList);
                        jSONObject.put("is_first_screen_recommend", false);
                        Unit unit = Unit.INSTANCE;
                        this.label = 1;
                        if (ui5.A2(jSONObject, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Integer num) {
                int i3;
                boolean z16;
                boolean z17;
                boolean z18;
                int i16;
                int i17;
                int i18;
                int i19;
                int i26;
                CoroutineScope Qi;
                if (num.intValue() > 530) {
                    ECShopProductDetailPageFragment.oi(ECShopProductDetailPageFragment.this).setAlpha(1.0f);
                } else {
                    float intValue = num.intValue() / 530;
                    ECShopProductDetailPageFragment.oi(ECShopProductDetailPageFragment.this).setAlpha(intValue);
                    if (intValue > 1.0E-4d) {
                        ECShopProductDetailPageFragment eCShopProductDetailPageFragment = ECShopProductDetailPageFragment.this;
                        eCShopProductDetailPageFragment.ij(false, ECShopProductDetailPageFragment.Wh(eCShopProductDetailPageFragment));
                    }
                }
                ECShopProductDetailPageFragment eCShopProductDetailPageFragment2 = ECShopProductDetailPageFragment.this;
                if (num.intValue() == 0) {
                    i3 = 1;
                } else {
                    i3 = !ECShopProductDetailPageFragment.Uh(ECShopProductDetailPageFragment.this).canScrollVertically(1) ? 2 : 0;
                }
                eCShopProductDetailPageFragment2.scrollerState = i3;
                z16 = ECShopProductDetailPageFragment.this.isSelect;
                if (!z16 && ECShopProductDetailPageFragment.this.scrollerState == 2) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(ECShopProductDetailPageFragment.this.spuId);
                    Qi = ECShopProductDetailPageFragment.this.Qi();
                    BuildersKt__Builders_commonKt.launch$default(Qi, null, null, new AnonymousClass1(jSONArray, null), 3, null);
                }
                z17 = ECShopProductDetailPageFragment.this.isScrollingByTabClick;
                if (z17) {
                    return;
                }
                z18 = ECShopProductDetailPageFragment.this.isSelect;
                if (z18) {
                    int intValue2 = num.intValue();
                    i19 = ECShopProductDetailPageFragment.this.tabOffsetYForDetail;
                    if (intValue2 < i19 && ECShopProductDetailPageFragment.this.scrollerState != 2) {
                        int intValue3 = num.intValue();
                        i26 = ECShopProductDetailPageFragment.this.tabOffsetYForComment;
                        if (intValue3 >= i26) {
                            ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(1);
                            return;
                        } else {
                            ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(0);
                            return;
                        }
                    }
                    ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(2);
                    return;
                }
                int intValue4 = num.intValue();
                i16 = ECShopProductDetailPageFragment.this.tabOffsetYForRecommend;
                if (intValue4 < i16 && ECShopProductDetailPageFragment.this.scrollerState != 2) {
                    int intValue5 = num.intValue();
                    i17 = ECShopProductDetailPageFragment.this.tabOffsetYForDetail;
                    if (intValue5 >= i17) {
                        ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(2);
                        return;
                    }
                    int intValue6 = num.intValue();
                    i18 = ECShopProductDetailPageFragment.this.tabOffsetYForComment;
                    if (intValue6 >= i18) {
                        ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(1);
                        return;
                    } else {
                        ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(0);
                        return;
                    }
                }
                ECShopProductDetailPageFragment.pi(ECShopProductDetailPageFragment.this).a(3);
            }
        });
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel3 = this.viewModel;
        if (eCShopProductDetailCustomViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailCustomViewModel3.e2().observe(getViewLifecycleOwner(), new Observer<ECShopProductDetailInfo>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$3

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$3$1", f = "ECShopProductDetailPageFragment.kt", i = {}, l = {655}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$registerLivedataObserver$3$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ECShopProductDetailInfo $respProductDetailInfo;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ECShopProductDetailInfo eCShopProductDetailInfo, Continuation continuation) {
                    super(2, continuation);
                    this.$respProductDetailInfo = eCShopProductDetailInfo;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$respProductDetailInfo, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    String optString;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        JSONObject optJSONObject = this.$respProductDetailInfo.infoData.optJSONObject("shop");
                        String str = "";
                        if (optJSONObject != null && (optString = optJSONObject.optString("id", "")) != null) {
                            str = optString;
                        }
                        ECShopProductDetailCustomViewModel ui5 = ECShopProductDetailPageFragment.ui(ECShopProductDetailPageFragment.this);
                        String str2 = this.$respProductDetailInfo.productID;
                        this.label = 1;
                        if (ui5.z2(str, str2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(ECShopProductDetailInfo eCShopProductDetailInfo) {
                boolean z16;
                String str;
                CoroutineScope Qi;
                ECShopProductDetailPageFragment.this.productDetailInfo = eCShopProductDetailInfo;
                ECShopProductDetailPageFragment.this.Pi(eCShopProductDetailInfo);
                ECShopProductDetailPageFragment.this.Oi(eCShopProductDetailInfo);
                if (f.e(eCShopProductDetailInfo.infoData)) {
                    i.e(i.f101155b, R.string.wte, null, 0, 6, null);
                }
                z16 = ECShopProductDetailPageFragment.this.hideLiveIcon;
                if (!z16) {
                    Qi = ECShopProductDetailPageFragment.this.Qi();
                    BuildersKt__Builders_commonKt.launch$default(Qi, null, null, new AnonymousClass1(eCShopProductDetailInfo, null), 3, null);
                }
                ECShopProductDetailPageFragment.this.Xi();
                d.f102466a.f(ECShopProductDetailPageFragment.this.reportParams, null, "qstore_prd_detail_pg_exp");
                ECAdAttributionReporter eCAdAttributionReporter = ECAdAttributionReporter.f101288c;
                str = ECShopProductDetailPageFragment.this.adClickId;
                eCAdAttributionReporter.k(str);
            }
        });
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel4 = this.viewModel;
        if (eCShopProductDetailCustomViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailCustomViewModel4.d2().observe(getViewLifecycleOwner(), new p());
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel5 = this.viewModel;
        if (eCShopProductDetailCustomViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailCustomViewModel5.h2().observe(getViewLifecycleOwner(), new q());
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        dVar.u0().observe(getViewLifecycleOwner(), new r());
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel6 = this.viewModel;
        if (eCShopProductDetailCustomViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailCustomViewModel6.u2().observe(getViewLifecycleOwner(), new s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dj(int shareAction) {
        com.tencent.ecommerce.biz.detail.utils.d.f102466a.n(this.sellerId, this.shopId, this.spuId, this.categoryId, this.sourceFrom, this.littleWorldFeedId, this.roomId, shareAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ej() {
        BuildersKt__Builders_commonKt.launch$default(Qi(), null, null, new ECShopProductDetailPageFragment$requestData$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gj() {
        List<Integer> emptyList;
        List<Integer> b16 = aj0.a.f26146a.b();
        IECShareProxy shareProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy();
        t tVar = new t();
        FragmentActivity requireActivity = requireActivity();
        String string = getResources().getString(R.string.wvo);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        shareProxy.showShareActionSheet(requireActivity, string, b16, emptyList, tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ij(boolean isVisible, View targetView) {
        ObjectAnimator ofFloat;
        if (this.isCloseButtonVisible == isVisible) {
            return;
        }
        targetView.setClickable(isVisible);
        this.isCloseButtonVisible = isVisible;
        targetView.setLayerType(2, null);
        if (isVisible) {
            ofFloat = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        this.animatorForAlpha = ofFloat;
        if (ofFloat != null) {
            ofFloat.addListener(new u(targetView));
        }
        ObjectAnimator objectAnimator = this.animatorForAlpha;
        if (objectAnimator != null) {
            objectAnimator.setDuration(250L);
        }
        ObjectAnimator objectAnimator2 = this.animatorForAlpha;
        if (objectAnimator2 != null) {
            objectAnimator2.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.animatorForAlpha;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
    }

    private final void initArguments() {
        String str;
        Intent intent;
        String stringExtra;
        Intent intent2;
        ECSchemeExtUserDataMap a16 = com.tencent.ecommerce.base.ktx.a.a(requireArguments(), "ext_userdata");
        this.serializableMap = a16;
        Map<Object, Object> extUserDataMap = a16.getExtUserDataMap();
        this.channel = Integer.parseInt(Si(WadlProxyConsts.CHANNEL, extUserDataMap, String.valueOf(QQECChannel.CHANNEL_UNKNOWN.ordinal())));
        this.saasType = Ti(this, "product_type", extUserDataMap, null, 4, null);
        this.saasProductId = Ti(this, "saas_product_id", extUserDataMap, null, 4, null);
        this.sellerId = Ti(this, "seller_id", extUserDataMap, null, 4, null);
        this.sellerMediaId = Ti(this, "seller_media_id", extUserDataMap, null, 4, null);
        this.mediaProductID = Ti(this, "media_product_id", extUserDataMap, null, 4, null);
        this.categoryName = Ti(this, "category_name", extUserDataMap, null, 4, null);
        this.goodsType = Ti(this, "goods_type", extUserDataMap, null, 4, null);
        this.categoryId = Ti(this, PictureConst.KEY_CATEGORY_ID, extUserDataMap, null, 4, null);
        this.sealTransfer = Ti(this, QCircleLpReportDc05507.KEY_SEAL_TRANSFER, extUserDataMap, null, 4, null);
        this.sourceFrom = Si("source_from", extUserDataMap, String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal()));
        this.requestId = Ti(this, "request_id", extUserDataMap, null, 4, null);
        this.bizType = Ti(this, "biz_type", extUserDataMap, null, 4, null);
        this.shopId = Ti(this, "shop_id", extUserDataMap, null, 4, null);
        this.spuId = Ti(this, "spu_id", extUserDataMap, null, 4, null);
        ug0.b bVar = ug0.b.f438933d;
        String str2 = "";
        this.roomId = bVar.f().optString("qqlive_room_id", "");
        this.programId = bVar.f().optString("qqlive_session_id", "");
        this.hideLiveIcon = Intrinsics.areEqual(Si("hide_icon", extUserDataMap, "0"), "1");
        boolean areEqual = Intrinsics.areEqual(Ti(this, "half", extUserDataMap, null, 4, null), "1");
        this.isFloatMode = areEqual;
        this.currentIsFloatMode = areEqual;
        this.isFromLive = Intrinsics.areEqual(Ti(this, "is_from_live", extUserDataMap, null, 4, null), "1");
        this.titleBarOffset = com.tencent.ecommerce.biz.util.r.f104881b.a(getActivity());
        this.isSelect = Intrinsics.areEqual(Si("is_select", extUserDataMap, "0"), "1");
        this.littleWorldFeedId = Ti(this, "little_world_feed_id", extUserDataMap, null, 4, null);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent2 = activity.getIntent()) == null || (str = intent2.getStringExtra("active_id")) == null) {
            str = "";
        }
        this.activeId = str;
        this.buyNow = Si("buy_now", extUserDataMap, "0");
        this.adClickId = Si("qz_gdt", extUserDataMap, "");
        boolean areEqual2 = Intrinsics.areEqual(Si("is_from_ec_goods", extUserDataMap, "0"), "1");
        if (areEqual2) {
            this.sourceFrom = "1";
        }
        if (this.isSelect) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null && (stringExtra = intent.getStringExtra("scheme_callback_id")) != null) {
                str2 = stringExtra;
            }
            this.addProductCallback = ug0.a.b(str2);
        }
        String valueOf = String.valueOf(extUserDataMap.get(LayoutAttrDefine.MARGIN_TOP));
        try {
            this.floatMarginTop = Integer.parseInt(valueOf);
        } catch (Exception e16) {
            cg0.a.a("ECShopProductDetailPageFragment", "initArguments", "parse floatMarginTop error, floatMarginTopString = " + valueOf + ", error = " + e16);
        }
        cg0.a.b("ECShopProductDetailPageFragment", "[initArguments] channel = " + this.channel + ", sellerId = " + this.sellerId + ", sellerMediaId = " + this.sellerMediaId + " mediaProductID = " + this.mediaProductID + ", sourceFrom = " + this.sourceFrom + ", requestId = " + this.requestId + ", bizType = " + this.bizType + ", shopId = " + this.shopId + ",spuId = " + this.spuId + ", titleBarOffset = " + this.titleBarOffset + ", littleWorldFeedId = " + this.littleWorldFeedId + ", isFromGoods = " + areEqual2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jj(boolean isLoading) {
        if (isLoading) {
            ViewGroup viewGroup = this.loadingViewContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
            }
            viewGroup.setVisibility(0);
            return;
        }
        ViewGroup viewGroup2 = this.loadingViewContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingViewContainer");
        }
        viewGroup2.setVisibility(8);
    }

    public static final /* synthetic */ View li(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        View view = eCShopProductDetailPageFragment.shopNetworkErrorContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopNetworkErrorContainer");
        }
        return view;
    }

    public static final /* synthetic */ ECTabLayout oi(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        ECTabLayout eCTabLayout = eCShopProductDetailPageFragment.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return eCTabLayout;
    }

    public static final /* synthetic */ a pi(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        a aVar = eCShopProductDetailPageFragment.tabLayoutController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutController");
        }
        return aVar;
    }

    public static final /* synthetic */ ECShopProductDetailCustomViewModel ui(ECShopProductDetailPageFragment eCShopProductDetailPageFragment) {
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel = eCShopProductDetailPageFragment.viewModel;
        if (eCShopProductDetailCustomViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCShopProductDetailCustomViewModel;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopProductDetailPageFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cue;
    }

    public final void initViewModel() {
        String str;
        if (this.sellerId.length() == 0) {
            str = this.sellerMediaId;
        } else {
            str = this.sellerId;
        }
        this.viewModel = new ECShopProductDetailCustomViewModel(this.bizType, this.isSelect, getChildFragmentManager(), str, this.adClickId);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1001 || requestCode == 1002) && resultCode == -1) {
            dj(requestCode == 1001 ? 2 : 3);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        Map<Object, Object> emptyMap;
        com.tencent.ecommerce.biz.common.e u16;
        if (this.isFloatMode && this.scrollerState != 0) {
            ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
            if (eCFloatGestureLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
            }
            eCFloatGestureLayout.E();
            return true;
        }
        final WeakReference weakReference = new WeakReference(getActivity());
        com.tencent.ecommerce.biz.retain.a aVar = com.tencent.ecommerce.biz.retain.a.f104118a;
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel = this.viewModel;
        if (eCShopProductDetailCustomViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String retainId = eCShopProductDetailCustomViewModel.getRetainId();
        String str = this.spuId;
        com.tencent.ecommerce.biz.detail.utils.c cVar = this.reportParams;
        if (cVar == null || (u16 = cVar.u()) == null || (emptyMap = u16.f()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        return aVar.b(retainId, str, emptyMap, new Function1<ECRetainViewOption, Unit>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$onBackPressed$canShow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECRetainViewOption eCRetainViewOption) {
                invoke2(eCRetainViewOption);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECRetainViewOption eCRetainViewOption) {
                Activity activity;
                if (eCRetainViewOption != ECRetainViewOption.EXIT || (activity = (Activity) weakReference.get()) == null) {
                    return;
                }
                activity.onBackPressed();
            }
        });
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        IECVideoControlDelegate videoControl;
        super.onCreate(savedInstanceState);
        initArguments();
        initViewModel();
        this.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(this.sourceFrom);
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECForegroundEvent.class, this.observer);
        if (!this.isFloatMode || (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) == null) {
            return;
        }
        videoControl.sendQCirclePanelStateEvent(this.littleWorldFeedId, true);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IECVideoControlDelegate videoControl;
        super.onDestroy();
        CoroutineScopeKt.cancel$default(Qi(), null, 1, null);
        LifecycleEventBus.f100688b.e(this.observer);
        ECShopProductCountdownBroadcast eCShopProductCountdownBroadcast = this.countdownBroadcast;
        if (eCShopProductCountdownBroadcast == null) {
            Intrinsics.throwUninitializedPropertyAccessException("countdownBroadcast");
        }
        eCShopProductCountdownBroadcast.c(requireContext());
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            bVar.b("qstore_prd_detail_pg_duration");
        }
        com.tencent.ecommerce.biz.retain.a aVar = com.tencent.ecommerce.biz.retain.a.f104118a;
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel = this.viewModel;
        if (eCShopProductDetailCustomViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.a(eCShopProductDetailCustomViewModel.getRetainId());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("depth", Ri());
        com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(this.reportParams, linkedHashMap, "qstore_prd_detail_pg_browse_depth");
        if (!this.isFloatMode || (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) == null) {
            return;
        }
        videoControl.sendQCirclePanelStateEvent(this.littleWorldFeedId, false);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("STATE_SHOP_DETAIL_PAGE_GUEST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("STATE_SHOP_DETAIL_PAGE_GUEST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Ui();
        Vi();
        ej();
        Zi();
        cj();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$j", "Lcom/tencent/ecommerce/biz/detail/ui/ReportCallback;", "", IECDtReport.ACTION_IDENTIFIER, "", "doReport", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j implements ReportCallback {
        j() {
        }

        @Override // com.tencent.ecommerce.biz.detail.ui.ReportCallback
        public void doReport(String identifier) {
            if (identifier != null) {
                int hashCode = identifier.hashCode();
                if (hashCode != -1237425441) {
                    if (hashCode == -345646859 && identifier.equals("shopHome")) {
                        com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailPageFragment.this.reportParams, null, "qstore_prd_detail_pg_enter_store_ck");
                        return;
                    }
                } else if (identifier.equals("shopService")) {
                    com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailPageFragment.this.reportParams, null, "qstore_prd_detail_pg_contact_ck");
                    return;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("depth", ECShopProductDetailPageFragment.this.Ri());
                com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailPageFragment.this.reportParams, linkedHashMap, "qstore_prd_detail_pg_go_purchase_ck");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fj() {
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            bVar.e(new ECDetailPageDuration(this.isFloatMode ? 1 : 2, this.shopId, this.spuId, this.roomId, String.valueOf(ug0.b.f438933d.e()), QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount(), this.sellerId, "", "0", this.saasType, this.saasProductId, "", this.categoryId, 0L, 0L, this.sourceFrom, this.littleWorldFeedId, this.sealTransfer, this.requestId, this.role));
        }
    }

    private final void initUI(View rootView) {
        this.titleBarParent = rootView.findViewById(R.id.nzm);
        this.titleBar = rootView.findViewById(R.id.nzl);
        this.blackBackButton = (ImageView) rootView.findViewById(R.id.nwm);
        this.detailPageRecyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nve);
        this.tabLayout = (ECTabLayout) rootView.findViewById(R.id.nwt);
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        this.tabLayoutController = new a(eCTabLayout, !this.isSelect);
        this.shopBottomBar = (ECBasePtsView) rootView.findViewById(R.id.nwu);
        this.shopBottomBarContainer = (ViewGroup) rootView.findViewById(R.id.nwv);
        this.floatCloseButton = rootView.findViewById(R.id.nwo);
        this.shopNetworkErrorContainer = rootView.findViewById(R.id.f163071o51);
        this.shopNetworkErrorRetryBtn = rootView.findViewById(R.id.f163072o52);
        this.loadingViewContainer = (ViewGroup) rootView.findViewById(R.id.nww);
        this.liveEntryView = (ECProductDetailLiveEntryView) rootView.findViewById(R.id.nwq);
        ECShopProductDetailCustomViewModel eCShopProductDetailCustomViewModel = this.viewModel;
        if (eCShopProductDetailCustomViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.ecBaseRecyclerViewAdapter = new com.tencent.ecommerce.biz.detail.ui.d(requireContext(), eCShopProductDetailCustomViewModel);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.o_x);
        this.shareImageBtn = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareImageBtn");
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this.shareImageBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareImageBtn");
        }
        imageView2.setOnClickListener(new m());
        ECTabLayout eCTabLayout2 = this.tabLayout;
        if (eCTabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        eCTabLayout2.setVisibility(0);
        a aVar = this.tabLayoutController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutController");
        }
        aVar.b();
        Yi();
        Wi();
        jj(true);
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.setItemAnimator(null);
        eCBaseRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(dVar);
        ECBaseRecyclerView eCBaseRecyclerView2 = this.detailPageRecyclerView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        int c16 = com.tencent.ecommerce.biz.util.e.c(12.0f);
        int c17 = com.tencent.ecommerce.biz.util.e.c(16.0f);
        int c18 = com.tencent.ecommerce.biz.util.e.c(11.0f);
        com.tencent.ecommerce.biz.detail.ui.d dVar2 = this.ecBaseRecyclerViewAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView2.addItemDecoration(new ECShopDetailItemDecoration(c16, c17, c18, 2, dVar2));
        if (this.isFloatMode) {
            ((RelativeLayout) rootView.findViewById(R.id.nvf)).setFitsSystemWindows(false);
            ImageView imageView3 = this.blackBackButton;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blackBackButton");
            }
            imageView3.setImageDrawable(ECSkin.INSTANCE.getDrawable(R.drawable.erw));
            View view = this.floatCloseButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatCloseButton");
            }
            view.setVisibility(0);
            ECBaseRecyclerView eCBaseRecyclerView3 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            ECBaseRecyclerView eCBaseRecyclerView4 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            int paddingLeft = eCBaseRecyclerView4.getPaddingLeft();
            ECBaseRecyclerView eCBaseRecyclerView5 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            int paddingTop = eCBaseRecyclerView5.getPaddingTop();
            ECBaseRecyclerView eCBaseRecyclerView6 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            eCBaseRecyclerView3.setPadding(paddingLeft, paddingTop, eCBaseRecyclerView6.getPaddingRight(), com.tencent.ecommerce.biz.util.e.c(60.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class p<T> implements Observer<Integer> {
        p() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num != null && num.intValue() == 1) {
                ECShopProductDetailPageFragment.oi(ECShopProductDetailPageFragment.this).setVisibility(8);
                return;
            }
            if (num != null && num.intValue() == 2) {
                ECShopProductDetailPageFragment.li(ECShopProductDetailPageFragment.this).setVisibility(0);
                ECShopProductDetailPageFragment.this.jj(false);
            } else if (num != null && num.intValue() == 3) {
                ECShopProductDetailPageFragment.li(ECShopProductDetailPageFragment.this).setVisibility(8);
            }
        }
    }

    static /* synthetic */ String Ti(ECShopProductDetailPageFragment eCShopProductDetailPageFragment, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return eCShopProductDetailPageFragment.Si(str, map, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hj(int targetPosition) {
        int i3 = 0;
        for (int i16 = 0; i16 < targetPosition; i16++) {
            Integer num = this.itemHeightMap.get(Integer.valueOf(i16));
            i3 += num != null ? num.intValue() : 0;
        }
        int i17 = (i3 - this.scrollY) - this.titleBarOffset;
        if (Math.abs(i17) >= 1000) {
            ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
            if (eCBaseRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            eCBaseRecyclerView.smoothScrollBy(0, i17, new AccelerateDecelerateInterpolator(), 300);
            return;
        }
        ECBaseRecyclerView eCBaseRecyclerView2 = this.detailPageRecyclerView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView2.smoothScrollBy(0, i17);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailPageFragment$b", "Lcom/tencent/ecommerce/biz/detail/ui/ReportCallback;", "", IECDtReport.ACTION_IDENTIFIER, "", "doReport", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ReportCallback {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.detail.ui.ReportCallback
        public void doReport(String identifier) {
        }
    }
}
