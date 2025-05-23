package com.tencent.mobileqq.activity;

import QC.UniBusinessItem;
import QC.UniGetReq;
import QC.UniGetRsp;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JoinTroopVerifyFragment;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.item.h;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopVerifyApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.protofile.groupMngTransInfo$ChannelInfo;
import com.tencent.protofile.groupMngTransInfo$JoinGroupTransInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00c4\u00012\u00020\u0001:\f\u00c5\u0001\u00c6\u0001\u00c7\u0001\u00c8\u0001\u00c9\u0001\u00ca\u0001B\t\u00a2\u0006\u0006\b\u00c2\u0001\u0010\u00c3\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002J \u0010+\u001a\u00020\n2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002J \u0010,\u001a\u00020\n2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002J(\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0002J\u0018\u0010/\u001a\u00020\n2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0002J\u0018\u00102\u001a\u00020\n2\u0006\u00101\u001a\u0002002\u0006\u0010*\u001a\u00020)H\u0002J\b\u00104\u001a\u000203H\u0002J<\u0010<\u001a\u00020\n2\u0006\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:H\u0002JD\u0010=\u001a\u00020\n2\u0006\u0010*\u001a\u00020)2\u0006\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:H\u0002J\u001a\u0010@\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010A\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u0002H\u0002J\b\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020\nH\u0002J\b\u0010D\u001a\u00020\nH\u0002J\u0010\u0010E\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0002H\u0002J;\u0010J\u001a\u00020\n2\u0006\u0010&\u001a\u00020F2\u0006\u00109\u001a\u00020\u00022!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110 \u00a2\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\n0GH\u0002J\u0010\u0010K\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0002H\u0002J0\u0010O\u001a\u00020\n2\u0006\u0010&\u001a\u00020F2\u0006\u0010L\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010N\u001a\u00020M2\u0006\u00109\u001a\u00020\u0002H\u0002J\b\u0010P\u001a\u00020\nH\u0002J\u001a\u0010S\u001a\u00020\n2\u0006\u0010Q\u001a\u00020 2\b\u0010R\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010U\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u001bH\u0002R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010\\R\u0016\u0010l\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bm\u0010\\R\u0016\u0010p\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010\\R\u0016\u0010r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010kR\u0016\u0010t\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010kR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010z\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\by\u0010kR\u0016\u0010|\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010jR\u0016\u0010~\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010jR\u0017\u0010\u0080\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010jR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008a\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010jR\u0018\u0010\u008c\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010jR\u0019\u0010\u008f\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010mR\u0019\u0010\u0092\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0093\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0093\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0093\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0093\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u0093\u0001R\u001a\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u0019\u0010\u00a4\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010mR\u001b\u0010\u00a7\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0018\u0010\u00ab\u0001\u001a\u00030\u00a8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001R+\u0010\u00b2\u0001\u001a\r \u00ad\u0001*\u0005\u0018\u00010\u00ac\u00010\u00ac\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ae\u0001\u0010\u00af\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u0018\u0010\u00b6\u0001\u001a\u00030\u00b3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u00b5\u0001R\u001c\u0010\u00ba\u0001\u001a\u0005\u0018\u00010\u00b7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u0018\u0010\u00be\u0001\u001a\u00030\u00bb\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u0017\u0010\u00c1\u0001\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001\u00a8\u0006\u00cb\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "onResume", "onFinish", "initView", "wi", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "ai", "Ai", "zi", "troopOption", "ei", "rightHighlightButton", "", "groupUin", SensorJsPlugin.SENSOR_INTERVAL_UI, "ti", "initData", "", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troop", "mi", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Yh", "Ci", "troopQuestion", "Wh", "Ph", "Lcom/tencent/mobileqq/text/QQText;", "troopCheckQu", "si", "", "Qh", "groupCode", "reason", "brief", "statOption", "templateId", "Lcom/tencent/qqnt/troop/d;", "callback", "Rh", "ii", "result", "troopUin", "ri", "qi", "Th", "ki", "fi", "ni", "Landroid/app/Activity;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Uh", "xi", "type", "", "data", "pi", "Bi", "isSuc", "info", "li", "introduction", "vi", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "templateRecyclerView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "reasonTitleView", "Landroid/widget/EditText;", "E", "Landroid/widget/EditText;", "reasonInputView", UserInfo.SEX_FEMALE, "briefInputView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "vipHeadView", "H", "briefWordCountView", "I", "Landroid/view/View;", "briefContentLayout", "J", "briefTemplateTipView", "K", "reasonCountView", "L", "securityTipLayout", "M", "securityTipCloseView", "Lcom/tencent/mobileqq/widget/RoundCorneredRelativeLayout;", "N", "Lcom/tencent/mobileqq/widget/RoundCorneredRelativeLayout;", "briefInputBorderLayout", "P", "briefInputLayout", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mTroopOption", BdhLogUtil.LogTag.Tag_Req, "mHighRiskTroop", ExifInterface.LATITUDE_SOUTH, "mEntrance", "Landroid/view/inputmethod/InputMethodManager;", "T", "Landroid/view/inputmethod/InputMethodManager;", "imm", "Lcom/tencent/mobileqq/activity/aio/item/h;", "U", "Lcom/tencent/mobileqq/activity/aio/item/h;", "templateAdapter", "V", "serverTemplateId", "W", "mJoinTroopStatus", "", "X", "mLastReqJoinTroopTimestamp", "Y", "Z", "mHasReqJoinTroopWebInfo", "Ljava/lang/String;", "mTroopUin", "a0", "mTroopCode", "b0", "authKey", "c0", "authSig", "d0", "mHomeworkIntroStr", "e0", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "f0", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mDlgProgress", "g0", "lastJoinTroopRequestTimestamp", "h0", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "Lcom/tencent/mobileqq/activity/aio/item/h$c;", "i0", "Lcom/tencent/mobileqq/activity/aio/item/h$c;", "templateSelectCallback", "Lcom/tencent/mobileqq/vas/updatesystem/business/f;", "kotlin.jvm.PlatformType", "j0", "Lkotlin/Lazy;", "bi", "()Lcom/tencent/mobileqq/vas/updatesystem/business/f;", "business", "Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$VipEnterTroopEffectLogic;", "k0", "Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$VipEnterTroopEffectLogic;", "vipEnterTroopEffectLogic", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "l0", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "joinBtn", "Lcom/tencent/mobileqq/troop/api/observer/b;", "m0", "Lcom/tencent/mobileqq/troop/api/observer/b;", "mTroopMngObserver", "ci", "()I", "reasonMaxCount", "<init>", "()V", "n0", "a", "b", "StartRecommendPageTask", "c", "VipEnterTroopEffectLogic", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class JoinTroopVerifyFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView templateRecyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView reasonTitleView;

    /* renamed from: E, reason: from kotlin metadata */
    private EditText reasonInputView;

    /* renamed from: F, reason: from kotlin metadata */
    private EditText briefInputView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView vipHeadView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView briefWordCountView;

    /* renamed from: I, reason: from kotlin metadata */
    private View briefContentLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView briefTemplateTipView;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView reasonCountView;

    /* renamed from: L, reason: from kotlin metadata */
    private View securityTipLayout;

    /* renamed from: M, reason: from kotlin metadata */
    private View securityTipCloseView;

    /* renamed from: N, reason: from kotlin metadata */
    private RoundCorneredRelativeLayout briefInputBorderLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private View briefInputLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mTroopOption;

    /* renamed from: R, reason: from kotlin metadata */
    private int mHighRiskTroop;

    /* renamed from: S, reason: from kotlin metadata */
    private int mEntrance;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private InputMethodManager imm;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.activity.aio.item.h templateAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private int serverTemplateId;

    /* renamed from: W, reason: from kotlin metadata */
    private int mJoinTroopStatus;

    /* renamed from: X, reason: from kotlin metadata */
    private long mLastReqJoinTroopTimestamp;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean mHasReqJoinTroopWebInfo;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private String mTroopUin;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTroopCode;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String authKey;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String authSig;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mHomeworkIntroStr;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQAppInterface app;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProgressDialog mDlgProgress;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private long lastJoinTroopRequestTimestamp;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TopGestureLayout topGestureLayout;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h.c templateSelectCallback;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy business;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VipEnterTroopEffectLogic vipEnterTroopEffectLogic;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton joinBtn;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.api.observer.b mTroopMngObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$StartRecommendPageTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "Ljava/lang/String;", "mUrl", "", "e", "J", "mStartTime", "url", "<init>", "(Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public final class StartRecommendPageTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long mStartTime;

        public StartRecommendPageTask(@Nullable String str) {
            int i3;
            Intent intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinTroopVerifyFragment.this, (Object) str);
                return;
            }
            this.mStartTime = System.currentTimeMillis();
            FragmentActivity activity = JoinTroopVerifyFragment.this.getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                i3 = intent.getIntExtra("friend_setting", 0);
            } else {
                i3 = 0;
            }
            int i16 = i3 == 0 ? 0 : 1;
            this.mUrl = str + "?_wv=1031&troopUin=" + JoinTroopVerifyFragment.this.mTroopUin + "&isVerify=" + i16;
            JSONObject j3 = com.tencent.mobileqq.troop.opensdkhandler.d.f298075a.j();
            if (j3 != null) {
                this.mUrl = this.mUrl + "&entry_from=2&guildId=" + j3.optString("guildId") + "&appId=" + j3.optString("appId");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            FragmentActivity activity = JoinTroopVerifyFragment.this.getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity == null) {
                QLog.e("JoinTroopVerifyFragment", 1, "onTroopManagerFailed, activity = null");
                return;
            }
            if (!TextUtils.isEmpty(JoinTroopVerifyFragment.this.mHomeworkIntroStr)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add("admin.qun.qq.com");
                com.tencent.mobileqq.jsp.h.w("closeJoinWebView", null, arrayList, null);
            }
            Intent intent = new Intent();
            intent.setAction("start_recomend_page");
            qBaseActivity.sendBroadcast(intent);
            Intent intent2 = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
            intent2.putExtra("url", this.mUrl);
            intent2.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            intent2.putExtra("show_right_close_button", true);
            intent2.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            JoinTroopVerifyFragment.this.startActivity(intent2);
            com.tencent.mobileqq.utils.eu.f(JoinTroopVerifyFragment.this.mTroopUin, 2, 1, intent2.getIntExtra(ProfileContants.CMD_PARAM_STAT_OPTION, 0));
            qBaseActivity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
            JoinTroopVerifyFragment.this.mHasReqJoinTroopWebInfo = false;
            qBaseActivity.finish();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$VipEnterTroopEffectLogic;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Landroid/view/ViewGroup;", AIInput.KEY_FRAME, "", "troopUin", "", "d", "g", "Landroid/view/View;", "v", "e", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Landroid/view/ViewGroup;", "frameView", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "renderLogicView", "com/tencent/mobileqq/activity/JoinTroopVerifyFragment$VipEnterTroopEffectLogic$kuiklyReceiver$1", "f", "Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$VipEnterTroopEffectLogic$kuiklyReceiver$1;", "kuiklyReceiver", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class VipEnterTroopEffectLogic implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ViewGroup frameView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g renderLogicView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final JoinTroopVerifyFragment$VipEnterTroopEffectLogic$kuiklyReceiver$1 kuiklyReceiver;

        /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.activity.JoinTroopVerifyFragment$VipEnterTroopEffectLogic$kuiklyReceiver$1] */
        public VipEnterTroopEffectLogic() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.kuiklyReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.activity.JoinTroopVerifyFragment$VipEnterTroopEffectLogic$kuiklyReceiver$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                        Object obj;
                        ViewGroup viewGroup;
                        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar;
                        l01.a a16;
                        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar2;
                        int i3;
                        l01.a a17;
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        String a18 = com.tencent.kuikly.core.render.android.expand.module.l.a(intent);
                        JSONObject b16 = com.tencent.kuikly.core.render.android.expand.module.l.b(intent);
                        QLog.i("EnterTroopEffectLogic", 1, a18 + " " + b16);
                        if (Intrinsics.areEqual(a18, "update_effect_list_size")) {
                            int optDouble = ((int) b16.optDouble("view_size")) + 14;
                            if (optDouble > 0.0d) {
                                obj = JoinTroopVerifyFragment.VipEnterTroopEffectLogic.this.renderLogicView;
                                View view = (View) obj;
                                int i16 = 0;
                                if (view != null) {
                                    JoinTroopVerifyFragment.VipEnterTroopEffectLogic vipEnterTroopEffectLogic = JoinTroopVerifyFragment.VipEnterTroopEffectLogic.this;
                                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                    if (layoutParams != null) {
                                        gVar2 = vipEnterTroopEffectLogic.renderLogicView;
                                        if (gVar2 != null && (a17 = gVar2.a()) != null) {
                                            i3 = (int) a17.b(optDouble);
                                        } else {
                                            i3 = 0;
                                        }
                                        layoutParams.height = i3;
                                    }
                                    view.requestLayout();
                                }
                                viewGroup = JoinTroopVerifyFragment.VipEnterTroopEffectLogic.this.frameView;
                                if (viewGroup != null) {
                                    JoinTroopVerifyFragment.VipEnterTroopEffectLogic vipEnterTroopEffectLogic2 = JoinTroopVerifyFragment.VipEnterTroopEffectLogic.this;
                                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                                    if (layoutParams2 != null) {
                                        gVar = vipEnterTroopEffectLogic2.renderLogicView;
                                        if (gVar != null && (a16 = gVar.a()) != null) {
                                            i16 = (int) a16.b(optDouble);
                                        }
                                        layoutParams2.height = i16;
                                    }
                                    viewGroup.requestLayout();
                                }
                            }
                        }
                    }
                };
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(View view) {
            Map<String, String> mapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
            Context context = view.getContext();
            IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(KuiklyLaunchParams.PARAM_MODAL_MODE, "1"), TuplesKt.to("scene", "1"));
            iVasHybridRoute.openSchema(context, iVasKuiklyApi.buildVasKuiklySchema("vas_effect_preview", "vas_qqvip_entergroupeffect", mapOf));
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void d(@Nullable ViewGroup frame, @NotNull String troopUin) {
            boolean z16;
            Map<String, String> mapOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) frame, (Object) troopUin);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            if (frame == null) {
                QLog.e("EnterTroopEffectLogic", 1, "frame null");
                return;
            }
            if (troopUin.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.e("EnterTroopEffectLogic", 1, "troopUin null");
                frame.setVisibility(8);
                return;
            }
            this.frameView = frame;
            if (this.renderLogicView == null) {
                IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
                this.renderLogicView = createKuiklyRenderView;
                if (createKuiklyRenderView != null) {
                    IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("group_code", troopUin), TuplesKt.to(KuiklyLaunchParams.PARAM_MODAL_MODE, "1"));
                    g.a.a(createKuiklyRenderView, iVasKuiklyApi.buildVasKuiklySchema("vas_enter_group_effect", "vas_qqvip_entergroupeffect", mapOf), null, 2, null);
                }
                Object obj = this.renderLogicView;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                frame.addView((View) obj, -1, -1);
                BaseApplication context2 = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                com.tencent.kuikly.core.render.android.expand.module.l.c(context2, this.kuiklyReceiver);
            }
        }

        public final void e(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
            } else {
                if (v3 == null) {
                    return;
                }
                v3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.dy
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        JoinTroopVerifyFragment.VipEnterTroopEffectLogic.f(view);
                    }
                });
            }
        }

        public final void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.onDetach();
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.kuikly.core.render.android.expand.module.l.f(context, this.kuiklyReceiver);
            }
            this.renderLogicView = null;
            this.frameView = null;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideErrorView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                h.a.a(this);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void hideLoadingView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                h.a.b(this);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isSucceed), errorReason, executeMode);
            } else {
                Intrinsics.checkNotNullParameter(executeMode, "executeMode");
                QLog.i("EnterTroopEffectLogic", 1, "onPageLoadComplete");
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showErrorView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                h.a.c(this);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
        public void showLoadingView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                h.a.d(this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$a;", "", "", "BRIEF_SWITCH_CLOSE", "I", "BRIEF_SWITCH_OPEN", "JOIN_TROOP_REQUEST_TRIGGER", "REASON_DEFAULT_ANSWER_WORD_COUNT", "REASON_DEFAULT_WORD_COUNT", "", "TAG", "Ljava/lang/String;", "", "TEMPLATE_ITEM_SPACE", UserInfo.SEX_FEMALE, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.JoinTroopVerifyFragment$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$b;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment;", "d", "Ljava/lang/ref/WeakReference;", "weakReferenceInstance", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "(Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<JoinTroopVerifyFragment> weakReferenceInstance;

        public b(@NotNull JoinTroopVerifyFragment instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) instance);
            } else {
                this.weakReferenceInstance = new WeakReference<>(instance);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @NotNull Object data) {
            FragmentActivity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            JoinTroopVerifyFragment joinTroopVerifyFragment = this.weakReferenceInstance.get();
            if (joinTroopVerifyFragment != null && (activity = joinTroopVerifyFragment.getActivity()) != null && !activity.isFinishing()) {
                joinTroopVerifyFragment.pi(activity, type, isSuccess, data, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "horizontalSpacePx", "<init>", "(I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int horizontalSpacePx;

        public c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.horizontalSpacePx = i3;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition != 0) {
                if (childAdapterPosition != 1) {
                    if (childAdapterPosition != 2) {
                        outRect.left = (this.horizontalSpacePx * 3) / 4;
                        outRect.right = 0;
                        return;
                    } else {
                        int i3 = this.horizontalSpacePx;
                        outRect.left = i3 / 2;
                        outRect.right = i3 / 4;
                        return;
                    }
                }
                int i16 = this.horizontalSpacePx;
                outRect.left = i16 / 4;
                outRect.right = i16 / 2;
                return;
            }
            outRect.left = 0;
            outRect.right = (this.horizontalSpacePx * 3) / 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment$d;", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadFail", "onLoadSuccess", "", "a", "I", "templateId", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/activity/JoinTroopVerifyFragment;", "kotlin.jvm.PlatformType", "b", "Ljava/lang/ref/WeakReference;", "fragmentRef", "fragment", "<init>", "(ILcom/tencent/mobileqq/activity/JoinTroopVerifyFragment;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class d implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int templateId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<JoinTroopVerifyFragment> fragmentRef;

        public d(int i3, @NotNull JoinTroopVerifyFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) fragment);
            } else {
                this.templateId = i3;
                this.fragmentRef = new WeakReference<>(fragment);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
            } else {
                Intrinsics.checkNotNullParameter(params, "params");
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(params, "params");
            JoinTroopVerifyFragment joinTroopVerifyFragment = this.fragmentRef.get();
            if (joinTroopVerifyFragment != null) {
                joinTroopVerifyFragment.xi(this.templateId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/activity/JoinTroopVerifyFragment$e", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class e implements TextWatcher {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinTroopVerifyFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                JoinTroopVerifyFragment.this.Ai();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/activity/JoinTroopVerifyFragment$f", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class f implements TextWatcher {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinTroopVerifyFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                JoinTroopVerifyFragment.this.zi();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/activity/JoinTroopVerifyFragment$g", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "isSuccess", "", "troopUin", "", "highRiskTroop", "", "g", "url", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class g extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinTroopVerifyFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void c(@Nullable String url) {
            QBaseActivity qBaseActivity;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
                return;
            }
            FragmentActivity activity = JoinTroopVerifyFragment.this.getActivity();
            EditText editText = null;
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity == null) {
                QLog.e("JoinTroopVerifyFragment", 1, "onGetAddTroopWebInfo, activity = null");
                return;
            }
            if (url != null && url.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QQToast.makeText(qBaseActivity, 2, R.string.f173066h23, 1).show(qBaseActivity.getTitleBarHeight());
                qBaseActivity.setResult(-1);
                qBaseActivity.getWindow().setSoftInputMode(2);
                InputMethodManager inputMethodManager = JoinTroopVerifyFragment.this.imm;
                if (inputMethodManager != null) {
                    EditText editText2 = JoinTroopVerifyFragment.this.reasonInputView;
                    if (editText2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                        editText2 = null;
                    }
                    inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
                }
                EditText editText3 = JoinTroopVerifyFragment.this.reasonInputView;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                } else {
                    editText = editText3;
                }
                editText.clearFocus();
                JoinTroopVerifyFragment.this.mHasReqJoinTroopWebInfo = false;
                qBaseActivity.finish();
            } else {
                qBaseActivity.runOnUiThread(new StartRecommendPageTask(url));
            }
            JoinTroopVerifyFragment.this.mJoinTroopStatus = 1004;
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void g(boolean isSuccess, @Nullable String troopUin, int highRiskTroop) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, Integer.valueOf(highRiskTroop));
                return;
            }
            if (!Intrinsics.areEqual(JoinTroopVerifyFragment.this.mTroopUin, troopUin)) {
                return;
            }
            View view = null;
            if (!isSuccess) {
                View view2 = JoinTroopVerifyFragment.this.securityTipLayout;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("securityTipLayout");
                } else {
                    view = view2;
                }
                view.setVisibility(8);
                return;
            }
            JoinTroopVerifyFragment.this.mHighRiskTroop = highRiskTroop;
            if (highRiskTroop != 0) {
                int i3 = JoinTroopVerifyFragment.this.mTroopOption;
                if (i3 == 1 || i3 == 2) {
                    View view3 = JoinTroopVerifyFragment.this.securityTipLayout;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("securityTipLayout");
                    } else {
                        view = view3;
                    }
                    view.setVisibility(0);
                    ReportController.o(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
                    return;
                }
                if (i3 == 4 || i3 == 5) {
                    View view4 = JoinTroopVerifyFragment.this.securityTipLayout;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("securityTipLayout");
                    } else {
                        view = view4;
                    }
                    view.setVisibility(0);
                    ReportController.o(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            View view5 = JoinTroopVerifyFragment.this.securityTipLayout;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("securityTipLayout");
            } else {
                view = view5;
            }
            view.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/JoinTroopVerifyFragment$h", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout$InterceptTouchEventListener;", "Landroid/view/MotionEvent;", "ev", "", "OnDispatchTouchEvent", "event", "", "OnInterceptTouchEvent", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class h implements TopGestureLayout.InterceptTouchEventListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public void OnDispatchTouchEvent(@Nullable MotionEvent ev5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ev5);
            }
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener
        public boolean OnInterceptTouchEvent(@Nullable MotionEvent event) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) event)).booleanValue();
            }
            float screenWidth = ViewUtils.getScreenWidth() / 4;
            if (screenWidth < 0.0f) {
                return false;
            }
            if (event != null && event.getAction() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && event.getX() > screenWidth) {
                return false;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public JoinTroopVerifyFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mEntrance = -1;
        this.serverTemplateId = 2000;
        this.mJoinTroopStatus = 1000;
        this.mTroopUin = "";
        this.mTroopCode = "";
        this.authKey = "";
        this.authSig = "";
        this.mHomeworkIntroStr = "";
        this.templateSelectCallback = new h.c() { // from class: com.tencent.mobileqq.activity.dr
            @Override // com.tencent.mobileqq.activity.aio.item.h.c
            public final void a(int i3) {
                JoinTroopVerifyFragment.yi(JoinTroopVerifyFragment.this, i3);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(JoinTroopVerifyFragment$business$2.INSTANCE);
        this.business = lazy;
        this.vipEnterTroopEffectLogic = new VipEnterTroopEffectLogic();
        this.mTroopMngObserver = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ai() {
        EditText editText = this.reasonInputView;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            editText = null;
        }
        int length = editText.getText().length();
        if (length == 0) {
            TextView textView2 = this.reasonCountView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonCountView");
            } else {
                textView = textView2;
            }
            textView.setText(ci() + "\u5b57");
            return;
        }
        if (length > ci()) {
            length = ci();
        }
        TextView textView3 = this.reasonCountView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonCountView");
        } else {
            textView = textView3;
        }
        textView.setText(length + "/" + ci() + "\u5b57");
    }

    private final void Bi() {
        com.tencent.mobileqq.activity.aio.item.h hVar;
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IVasInfoService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasInfoService::class.java)");
        String currentUid = qQAppInterface.getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(currentUid, "app.currentUid");
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) api).getVasSimpleInfoWithUid(currentUid, "JoinTroopVerifyFragment");
        if (vasSimpleInfoWithUid == null) {
            return;
        }
        com.tencent.mobileqq.vip.api.f highestVipType = IVipInfoUtils.INSTANCE.a().getHighestVipType(new VipTypeParam(vasSimpleInfoWithUid.qqVipInfo, vasSimpleInfoWithUid.superQqInfo, vasSimpleInfoWithUid.superVipInfo, vasSimpleInfoWithUid.bigClubInfo));
        if (highestVipType.c()) {
            com.tencent.mobileqq.activity.aio.item.h hVar2 = this.templateAdapter;
            if (hVar2 != null) {
                hVar2.t0(2003);
                return;
            }
            return;
        }
        if (highestVipType.d()) {
            com.tencent.mobileqq.activity.aio.item.h hVar3 = this.templateAdapter;
            if (hVar3 != null) {
                hVar3.t0(2001);
                return;
            }
            return;
        }
        if (highestVipType.e() && (hVar = this.templateAdapter) != null) {
            hVar.t0(2002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ci(QBaseActivity activity, Intent intent, QQAppInterface app) {
        int i3;
        EditText editText = this.reasonInputView;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            editText = null;
        }
        if (editText.getText().toString().length() > ci()) {
            ReportDialog reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
            reportDialog.setContentView(R.layout.bwu);
            View findViewById = reportDialog.findViewById(R.id.dialogText);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(getString(R.string.a_d));
            View findViewById2 = reportDialog.findViewById(R.id.cib);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
            ((ProgressBar) findViewById2).setVisibility(8);
            View findViewById3 = reportDialog.findViewById(R.id.kja);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) findViewById3).setImageResource(R.drawable.f160605la);
            reportDialog.show();
            return;
        }
        if (NetworkUtil.isNetSupport(activity)) {
            com.tencent.mobileqq.activity.aio.item.h hVar = this.templateAdapter;
            if (hVar != null) {
                i3 = hVar.m0();
            } else {
                i3 = 2000;
            }
            int i16 = i3;
            QLog.e("AddFriendVerifyActivity", 1, "joinTroop templateId: " + i16);
            String str = this.mTroopUin;
            EditText editText3 = this.reasonInputView;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                editText3 = null;
            }
            String obj = editText3.getText().toString();
            EditText editText4 = this.briefInputView;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
            } else {
                editText2 = editText4;
            }
            Sh(this, str, obj, editText2.getText().toString(), intent.getIntExtra(ProfileContants.CMD_PARAM_STAT_OPTION, 0), i16, null, 32, null);
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A62B", com.tencent.mobileqq.activity.aio.item.j.a(i16), 0, "", "", "", "");
            if (Intrinsics.areEqual("d2g", intent.getStringExtra("jump_from"))) {
                ReportController.o(app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, this.mTroopUin, "", "", "");
                return;
            }
            return;
        }
        QQToast.makeText(activity, 1, R.string.f171139ci4, 0).show(activity.getTitleBarHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(QBaseActivity activity, Intent intent) {
        CharSequence trim;
        boolean z16;
        int i3;
        EditText editText = this.reasonInputView;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            editText = null;
        }
        trim = StringsKt__StringsKt.trim((CharSequence) editText.getText().toString());
        String obj = trim.toString();
        if (obj.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.f171555j41), 0).show(activity.getTitleBarHeight());
            return;
        }
        if (obj.length() > ci()) {
            ReportDialog reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
            reportDialog.setContentView(R.layout.bwu);
            View findViewById = reportDialog.findViewById(R.id.dialogText);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(getString(R.string.a_d));
            View findViewById2 = reportDialog.findViewById(R.id.cib);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
            ((ProgressBar) findViewById2).setVisibility(8);
            View findViewById3 = reportDialog.findViewById(R.id.kja);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) findViewById3).setImageResource(R.drawable.f160605la);
            reportDialog.show();
            return;
        }
        if (NetworkUtil.isNetSupport(activity)) {
            com.tencent.mobileqq.activity.aio.item.h hVar = this.templateAdapter;
            if (hVar != null) {
                i3 = hVar.m0();
            } else {
                i3 = 2000;
            }
            int i16 = i3;
            QLog.i("JoinTroopVerifyFragment", 1, "click send,templateId=" + i16);
            String str = this.mTroopUin;
            EditText editText3 = this.reasonInputView;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                editText3 = null;
            }
            String obj2 = editText3.getText().toString();
            EditText editText4 = this.briefInputView;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
            } else {
                editText2 = editText4;
            }
            Sh(this, str, obj2, editText2.getText().toString(), intent.getIntExtra(ProfileContants.CMD_PARAM_STAT_OPTION, 0), i16, null, 32, null);
            return;
        }
        QQToast.makeText(activity, 1, R.string.f171139ci4, 0).show(activity.getTitleBarHeight());
    }

    private final byte[] Qh() {
        Intent intent;
        String stringExtra;
        Long longOrNull;
        QLog.i("JoinTroopVerifyFragment", 1, "buildJoinGroupTransInfo, switchCode=2");
        groupMngTransInfo$JoinGroupTransInfo groupmngtransinfo_joingrouptransinfo = new groupMngTransInfo$JoinGroupTransInfo();
        groupmngtransinfo_joingrouptransinfo.self_introduction_switch.set(2);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("param_scene_target_id")) != null) {
            Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(TroopInfo\u2026il.PARAM_SCENE_TARGET_ID)");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(stringExtra);
            if (longOrNull != null) {
                long longValue = longOrNull.longValue();
                groupMngTransInfo$ChannelInfo groupmngtransinfo_channelinfo = new groupMngTransInfo$ChannelInfo();
                groupmngtransinfo_channelinfo.channel_id.set(longValue);
                groupmngtransinfo_joingrouptransinfo.channel_info.set(groupmngtransinfo_channelinfo);
            }
        }
        byte[] byteArray = groupmngtransinfo_joingrouptransinfo.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "transInfo.toByteArray()");
        return byteArray;
    }

    private final void Rh(String groupCode, String reason, String brief, int statOption, int templateId, com.tencent.qqnt.troop.d callback) {
        if (SystemClock.uptimeMillis() - this.lastJoinTroopRequestTimestamp < 500) {
            QLog.i("JoinTroopVerifyFragment", 1, "checkAndJoinTroop, return, click too fast");
            return;
        }
        this.lastJoinTroopRequestTimestamp = SystemClock.uptimeMillis();
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            return;
        }
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.setMessage(R.string.hex);
            qQProgressDialog.show();
        }
        ii(qQAppInterface, groupCode, reason, brief, statOption, templateId, callback);
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_join", "", "person_data", "Clk_joingrp", 0, 0, groupCode, "0", "", "");
        com.tencent.mobileqq.utils.eu.i(this.mTroopUin, 1, 0, statOption);
        com.tencent.mobileqq.utils.eu.f(this.mTroopUin, 1, 0, statOption);
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, groupCode, "", "", "");
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddGroupClick(statOption);
    }

    static /* synthetic */ void Sh(JoinTroopVerifyFragment joinTroopVerifyFragment, String str, String str2, String str3, int i3, int i16, com.tencent.qqnt.troop.d dVar, int i17, Object obj) {
        if ((i17 & 32) != 0) {
            dVar = null;
        }
        joinTroopVerifyFragment.Rh(str, str2, str3, i3, i16, dVar);
    }

    private final boolean Th() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.mLastReqJoinTroopTimestamp;
        this.mLastReqJoinTroopTimestamp = currentTimeMillis;
        if (j3 > 1000 && this.mJoinTroopStatus != 1001 && !this.mHasReqJoinTroopWebInfo) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("checkSendJoinTroop interval=%s mJoinTroopStatus=%s mHasReqJoinTroopWebInfo=%s result=%s", Arrays.copyOf(new Object[]{Long.valueOf(j3), Integer.valueOf(this.mJoinTroopStatus), Boolean.valueOf(this.mHasReqJoinTroopWebInfo), Boolean.valueOf(z16)}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.i("JoinTroopVerifyFragment", 1, format);
        return z16;
    }

    private final void Uh(final Activity activity, int templateId, final Function1<? super Boolean, Unit> callback) {
        BusinessHandler businessHandler;
        QQAppInterface qQAppInterface = this.app;
        VipInfoHandler vipInfoHandler = null;
        if (qQAppInterface != null) {
            businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof VipInfoHandler) {
            vipInfoHandler = (VipInfoHandler) businessHandler;
        }
        if (vipInfoHandler == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        UniSetReq uniSetReq = new UniSetReq();
        uniSetReq.stUniBusinessItem = new UniBusinessItem(40, templateId, "");
        vipInfoHandler.a3(uniSetReq, new BusinessObserver() { // from class: com.tencent.mobileqq.activity.dw
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                JoinTroopVerifyFragment.Vh(activity, callback, i3, z16, obj);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(Activity activity, Function1 callback, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (activity.isFinishing()) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        QLog.e("JoinTroopVerifyFragment", 1, "TYPE_UNI_SET_RSP: " + z16 + " data=" + obj);
        if (z16 && (obj instanceof UniSetRsp)) {
            UniSetRsp uniSetRsp = (UniSetRsp) obj;
            QLog.e("JoinTroopVerifyFragment", 1, "TYPE_UNI_SET_RSP: " + uniSetRsp.ret + " msg:" + uniSetRsp.errmsg);
            int i16 = uniSetRsp.ret;
            if (i16 == 0) {
                callback.invoke(Boolean.TRUE);
                return;
            } else {
                a.f(activity, i16, true);
                callback.invoke(Boolean.FALSE);
                return;
            }
        }
        callback.invoke(Boolean.FALSE);
    }

    private final void Wh(String troopQuestion, final QBaseActivity activity, final Intent intent, QQAppInterface app) {
        QQText qQText = new QQText(getString(R.string.g3d) + ":" + troopQuestion, 45);
        TextView textView = this.reasonTitleView;
        EditText editText = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonTitleView");
            textView = null;
        }
        textView.setText(qQText);
        TextView textView2 = this.reasonTitleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonTitleView");
            textView2 = null;
        }
        textView2.setTag(this.mTroopUin);
        TextView textView3 = this.reasonTitleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonTitleView");
            textView3 = null;
        }
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        EditText editText2 = this.reasonInputView;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            editText2 = null;
        }
        editText2.setFocusable(true);
        EditText editText3 = this.reasonInputView;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            editText3 = null;
        }
        editText3.setFocusableInTouchMode(true);
        if (this.mTroopOption == 4) {
            EditText editText4 = this.reasonInputView;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                editText4 = null;
            }
            editText4.setHint(getString(R.string.f2066158s));
        } else {
            EditText editText5 = this.reasonInputView;
            if (editText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                editText5 = null;
            }
            editText5.setHint(getString(R.string.f2066058r));
        }
        if (AddFriendVerifyActivity.V0) {
            EditText editText6 = this.reasonInputView;
            if (editText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            } else {
                editText = editText6;
            }
            editText.setContentDescription(getString(R.string.axx));
        }
        QUIButton qUIButton = this.joinBtn;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.ds
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JoinTroopVerifyFragment.Xh(JoinTroopVerifyFragment.this, activity, intent, view);
                }
            });
        }
        ReportController.o(app, "P_CliOper", "Grp_join", "", "send", "exp_verify", 0, 0, this.mTroopUin, "", "", "");
        si(qQText, app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(final JoinTroopVerifyFragment this$0, final QBaseActivity activity, final Intent intent, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        TextView rightViewText = this$0.rightViewText;
        if (rightViewText != null) {
            Intrinsics.checkNotNullExpressionValue(rightViewText, "rightViewText");
            this$0.ti(rightViewText);
        }
        if (this$0.imm != null) {
            activity.getWindow().setSoftInputMode(2);
            InputMethodManager inputMethodManager = this$0.imm;
            EditText editText = null;
            if (inputMethodManager != null) {
                EditText editText2 = this$0.reasonInputView;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                    editText2 = null;
                }
                inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
            }
            EditText editText3 = this$0.reasonInputView;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            } else {
                editText = editText3;
            }
            editText.clearFocus();
        }
        if (this$0.mHighRiskTroop != 0) {
            ReportController.o(null, "dc00898", "", "", "0X800B5B3", "0X800B5B3", 0, 0, "", "", "", "");
        }
        if (NetworkUtil.isNetSupport(activity)) {
            com.tencent.mobileqq.activity.aio.item.h hVar = this$0.templateAdapter;
            if (hVar != null) {
                i3 = hVar.m0();
            } else {
                i3 = 2000;
            }
            if (i3 != 2000) {
                this$0.Uh(activity, i3, new Function1<Boolean, Unit>(activity, intent) { // from class: com.tencent.mobileqq.activity.JoinTroopVerifyFragment$dealWithAnswerOption$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ QBaseActivity $activity;
                    final /* synthetic */ Intent $intent;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$activity = activity;
                        this.$intent = intent;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, JoinTroopVerifyFragment.this, activity, intent);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, z16);
                        } else if (z16) {
                            JoinTroopVerifyFragment.this.Ph(this.$activity, this.$intent);
                        }
                    }
                });
            } else {
                this$0.Ph(activity, intent);
            }
        } else {
            QQToast.makeText(activity, 1, R.string.f171139ci4, 0).show(activity.getTitleBarHeight());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Yh(final QBaseActivity activity, final Intent intent, final QQAppInterface app) {
        QUIButton qUIButton = this.joinBtn;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.du
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JoinTroopVerifyFragment.Zh(JoinTroopVerifyFragment.this, activity, intent, app, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(final JoinTroopVerifyFragment this$0, final QBaseActivity activity, final Intent intent, final QQAppInterface app, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(app, "$app");
        if (this$0.rightViewText != null) {
            View rightTextView = this$0.getRightTextView();
            Intrinsics.checkNotNullExpressionValue(rightTextView, "rightTextView");
            this$0.ti(rightTextView);
        }
        if (this$0.Th()) {
            if (this$0.mHighRiskTroop != 0) {
                ReportController.o(null, "dc00898", "", "", "0X800B5B3", "0X800B5B3", 0, 0, "", "", "", "");
            }
            if (this$0.imm != null) {
                Window window = activity.getWindow();
                if (window != null) {
                    window.setSoftInputMode(2);
                }
                InputMethodManager inputMethodManager = this$0.imm;
                EditText editText = null;
                if (inputMethodManager != null) {
                    EditText editText2 = this$0.reasonInputView;
                    if (editText2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                        editText2 = null;
                    }
                    inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
                }
                EditText editText3 = this$0.reasonInputView;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                } else {
                    editText = editText3;
                }
                editText.clearFocus();
            }
            if (NetworkUtil.isNetSupport(activity)) {
                com.tencent.mobileqq.activity.aio.item.h hVar = this$0.templateAdapter;
                if (hVar != null) {
                    i3 = hVar.m0();
                } else {
                    i3 = 2000;
                }
                if (i3 != 2000) {
                    this$0.Uh(activity, i3, new Function1<Boolean, Unit>(activity, intent, app) { // from class: com.tencent.mobileqq.activity.JoinTroopVerifyFragment$dealWithVerifyOption$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ QBaseActivity $activity;
                        final /* synthetic */ QQAppInterface $app;
                        final /* synthetic */ Intent $intent;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$activity = activity;
                            this.$intent = intent;
                            this.$app = app;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, JoinTroopVerifyFragment.this, activity, intent, app);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                            } else if (z16) {
                                JoinTroopVerifyFragment.this.Ci(this.$activity, this.$intent, this.$app);
                            }
                        }
                    });
                } else {
                    this$0.Ci(activity, intent, app);
                }
            } else {
                QQToast.makeText(activity, 1, R.string.f171139ci4, 0).show(activity.getTitleBarHeight());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final TopGestureLayout ai() {
        Window window;
        View decorView;
        DragFrameLayout dragFrameLayout;
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null && (decorView instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                boolean z16 = childAt instanceof DragFrameLayout;
                if (z16) {
                    if (z16) {
                        dragFrameLayout = (DragFrameLayout) childAt;
                    } else {
                        dragFrameLayout = null;
                    }
                    if (dragFrameLayout != null) {
                        childAt = dragFrameLayout.getChildAt(0);
                    } else {
                        childAt = null;
                    }
                }
                if (childAt instanceof TopGestureLayout) {
                    TopGestureLayout topGestureLayout2 = (TopGestureLayout) childAt;
                    this.topGestureLayout = topGestureLayout2;
                    return topGestureLayout2;
                }
            }
        }
        return null;
    }

    private final com.tencent.mobileqq.vas.updatesystem.business.f bi() {
        return (com.tencent.mobileqq.vas.updatesystem.business.f) this.business.getValue();
    }

    private final int ci() {
        int i3 = this.mTroopOption;
        if (i3 != 4 && i3 != 5) {
            return ((ITroopVerifyApi) QRoute.api(ITroopVerifyApi.class)).getPageSwitch().b();
        }
        return ((ITroopVerifyApi) QRoute.api(ITroopVerifyApi.class)).getPageSwitch().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(QBaseActivity activity, JoinTroopVerifyFragment this$0, boolean z16, int i3, String errMsg, com.tencent.qqnt.bean.c hint) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(hint, "hint");
        activity.finish();
        if (!z16) {
            QLog.w("JoinTroopVerifyFragment", 1, "[initData] checkAndJoinTroop failed. quit jump2AIO");
        } else {
            com.tencent.mobileqq.troop.troopcreate.a.i(activity, this$0.mTroopUin, null);
        }
    }

    private final void ei(int troopOption) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(activity);
        View findViewById = activity.findViewById(android.R.id.content);
        VideoReport.setPageId(findViewById, "pg_group_apply");
        int i3 = 2;
        if (troopOption != 2) {
            if (troopOption != 4) {
                if (troopOption != 5) {
                    i3 = -1;
                } else {
                    i3 = 1;
                }
            }
        } else {
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", this.mTroopUin);
        hashMap.put("apply_type", String.valueOf(i3));
        VideoReport.setPageParams(findViewById, new PageParams(hashMap));
        VideoReport.setPageReportPolicy(findViewById, PageReportPolicy.REPORT_ALL);
    }

    private final void fi() {
        BaseBusinessHandler baseBusinessHandler;
        if (VasNtToggle.INSTANCE.getTROOP_ICE_BREAK_ENABLE().isEnable(true)) {
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A4F8", 0, 0, "", "", "", "");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 0, false);
            this.templateAdapter = new com.tencent.mobileqq.activity.aio.item.h(this.templateSelectCallback);
            RecyclerView recyclerView = this.templateRecyclerView;
            VipInfoHandler vipInfoHandler = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templateRecyclerView");
                recyclerView = null;
            }
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.templateAdapter);
            recyclerView.setVisibility(0);
            recyclerView.addItemDecoration(new c(13));
            QQAppInterface qQAppInterface = this.app;
            if (qQAppInterface != null) {
                baseBusinessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
            } else {
                baseBusinessHandler = null;
            }
            if (baseBusinessHandler instanceof VipInfoHandler) {
                vipInfoHandler = (VipInfoHandler) baseBusinessHandler;
            }
            if (vipInfoHandler != null) {
                UniGetReq uniGetReq = new UniGetReq();
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(40);
                uniGetReq.appidList = arrayList;
                if (com.tencent.mobileqq.vas.ar.INSTANCE.b("kenaiyu", "2024-04-03", "vas_bug_122335891").isEnable(true)) {
                    vipInfoHandler.Z2(uniGetReq, new b(this), false);
                    return;
                } else {
                    vipInfoHandler.Z2(uniGetReq, new BusinessObserver() { // from class: com.tencent.mobileqq.activity.dv
                        @Override // com.tencent.mobileqq.app.BusinessObserver
                        public final void onUpdate(int i3, boolean z16, Object obj) {
                            JoinTroopVerifyFragment.gi(JoinTroopVerifyFragment.this, i3, z16, obj);
                        }
                    }, false);
                    return;
                }
            }
            QLog.e("AddFriendVerifyActivity", 1, "get fail, VipInfoHandler is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(JoinTroopVerifyFragment this$0, int i3, boolean z16, Object data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && !activity.isFinishing()) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            this$0.pi(activity, i3, z16, data, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(JoinTroopVerifyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.securityTipLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("securityTipLayout");
            view2 = null;
        }
        view2.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ii(final QQAppInterface app, final String groupCode, String reason, String brief, int statOption, int templateId, final com.tencent.qqnt.troop.d callback) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        QLog.i("JoinTroopVerifyFragment", 1, "[joinTroop] groupCode:" + groupCode + ",reason:" + reason + ",brief:" + brief + ",option:" + statOption + ",tId:" + templateId);
        String currentAccountUin = app.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(currentAccountUin);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(groupCode);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        JoinTroopParam joinTroopParam = new JoinTroopParam(groupCode, statOption, this.authKey, this.authSig);
        joinTroopParam.k(reason);
        joinTroopParam.j(a.b(0, "", brief, j3, j16, templateId));
        joinTroopParam.g(Qh());
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).joinGroup(joinTroopParam, this, "JoinTroopVerifyFragment", new com.tencent.qqnt.troop.d() { // from class: com.tencent.mobileqq.activity.dt
            @Override // com.tencent.qqnt.troop.d
            public final void a(boolean z16, int i3, String str, com.tencent.qqnt.bean.c cVar) {
                JoinTroopVerifyFragment.ji(JoinTroopVerifyFragment.this, groupCode, callback, app, z16, i3, str, cVar);
            }
        });
        this.mJoinTroopStatus = 1001;
        Manager manager = app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.MayknowRecommendManager");
        ((MayknowRecommendManager) manager).p(this.mTroopUin);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initData() {
        final QBaseActivity qBaseActivity;
        Intent intent;
        QQAppInterface qQAppInterface;
        String str;
        Long longOrNull;
        Long longOrNull2;
        InputMethodManager inputMethodManager;
        short s16;
        String str2;
        short s17;
        FragmentActivity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null || (intent = qBaseActivity.getIntent()) == null || (qQAppInterface = this.app) == null) {
            return;
        }
        qBaseActivity.addObserver(this.mTroopMngObserver);
        this.mDlgProgress = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
        String stringExtra = intent.getStringExtra("authKey");
        String str3 = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.authKey = stringExtra;
        String stringExtra2 = intent.getStringExtra("authSig");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.authSig = stringExtra2;
        this.mEntrance = intent.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, -1);
        String stringExtra3 = intent.getStringExtra("uin");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.mTroopUin = stringExtra3;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString(AppConstants.Key.TROOP_CODE);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.mTroopCode = str;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.mTroopUin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            String currentUin = qQAppInterface.getCurrentUin();
            if (currentUin != null && longOrNull2 != null) {
                long longValue2 = longOrNull2.longValue();
                Object systemService = qBaseActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (systemService instanceof InputMethodManager) {
                    inputMethodManager = (InputMethodManager) systemService;
                } else {
                    inputMethodManager = null;
                }
                this.imm = inputMethodManager;
                Object businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.api.handler.ITroopMngHandler");
                com.tencent.mobileqq.troop.api.handler.h hVar = (com.tencent.mobileqq.troop.api.handler.h) businessHandler;
                ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopClassTypeForGuest(this.mTroopUin, "JoinTroopVerifyFragment", this, new Function2<Boolean, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.activity.JoinTroopVerifyFragment$initData$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinTroopVerifyFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                        invoke(bool.booleanValue(), troopInfo);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull TroopInfo data) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), data);
                        } else {
                            Intrinsics.checkNotNullParameter(data, "data");
                            JoinTroopVerifyFragment.this.mi(z16, data);
                        }
                    }
                });
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    s16 = extras2.getShort("group_option", (short) 2);
                } else {
                    s16 = 2;
                }
                this.mTroopOption = s16;
                Bundle extras3 = intent.getExtras();
                if (extras3 != null) {
                    str2 = extras3.getString("troop_question");
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    str3 = str2;
                }
                int intExtra = intent.getIntExtra(ProfileContants.CMD_PARAM_STAT_OPTION, 0);
                com.tencent.mobileqq.utils.eu.i(this.mTroopUin, 1, 1, intExtra);
                com.tencent.mobileqq.utils.eu.f(this.mTroopUin, 1, 1, intExtra);
                hVar.v0(longValue, longValue2, null);
                vi(this.mHomeworkIntroStr);
                EditText editText = this.reasonInputView;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                    editText = null;
                }
                editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(ci())});
                EditText editText2 = this.reasonInputView;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                    editText2 = null;
                }
                editText2.addTextChangedListener(new e());
                Ai();
                if (s16 != 1 && s16 != 2) {
                    if (s16 == 4 || s16 == 5) {
                        Wh(str3, qBaseActivity, intent, qQAppInterface);
                    }
                } else {
                    if (s16 == 1 && intExtra == 1016) {
                        if (Th()) {
                            s17 = s16;
                            Rh(this.mTroopUin, "", "", intExtra, 2000, new com.tencent.qqnt.troop.d() { // from class: com.tencent.mobileqq.activity.dp
                                @Override // com.tencent.qqnt.troop.d
                                public final void a(boolean z16, int i3, String str4, com.tencent.qqnt.bean.c cVar) {
                                    JoinTroopVerifyFragment.di(QBaseActivity.this, this, z16, i3, str4, cVar);
                                }
                            });
                        }
                    } else {
                        s17 = s16;
                        Yh(qBaseActivity, intent, qQAppInterface);
                    }
                    qBaseActivity.getWindow().setSoftInputMode(37);
                    ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddGroupExposure(this.mEntrance);
                    enableRightHighlight(true);
                    updateRightTvTextColor();
                    ei(s17);
                    ui(this.rightViewText, this.mTroopUin);
                    return;
                }
                s17 = s16;
                qBaseActivity.getWindow().setSoftInputMode(37);
                ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).reportAddGroupExposure(this.mEntrance);
                enableRightHighlight(true);
                updateRightTvTextColor();
                ei(s17);
                ui(this.rightViewText, this.mTroopUin);
                return;
            }
            QLog.e("JoinTroopVerifyFragment", 1, "initData invalid currentUin");
            return;
        }
        QLog.e("JoinTroopVerifyFragment", 1, "initData invalid troopUin, troopUin=" + this.mTroopUin);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f93975b1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.template_recyclerView)");
        this.templateRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.f108886eb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_join_reason_title)");
        this.reasonTitleView = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.uxa);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.et_join_reason)");
        this.reasonInputView = (EditText) findViewById3;
        View findViewById4 = view.findViewById(R.id.tbk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.brief_input_border_layout)");
        this.briefInputBorderLayout = (RoundCorneredRelativeLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.tbl);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.brief_input_layout)");
        this.briefInputLayout = findViewById5;
        View findViewById6 = view.findViewById(R.id.f165111ux4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.et_brief_input_view)");
        EditText editText = (EditText) findViewById6;
        this.briefInputView = editText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
            editText = null;
        }
        editText.setHint(getString(R.string.f2066358u));
        View findViewById7 = view.findViewById(R.id.mev);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.verify_troop_qa_vip_head)");
        this.vipHeadView = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.f1063568h);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.tv_brief_word_count)");
        this.briefWordCountView = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.f110456ik);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.tv_reason_word_count)");
        this.reasonCountView = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.tbj);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.brief_content_layout)");
        this.briefContentLayout = findViewById10;
        View findViewById11 = view.findViewById(R.id.tbn);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.brief_template_tip)");
        TextView textView = (TextView) findViewById11;
        this.briefTemplateTipView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefTemplateTipView");
            textView = null;
        }
        textView.setText(getString(R.string.f2066458v));
        View findViewById12 = view.findViewById(R.id.f81784f4);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.security_tip_layout)");
        this.securityTipLayout = findViewById12;
        View findViewById13 = view.findViewById(R.id.f81764f2);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.security_tip_close_view)");
        this.securityTipCloseView = findViewById13;
        if (findViewById13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("securityTipCloseView");
            findViewById13 = null;
        }
        findViewById13.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.dq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                JoinTroopVerifyFragment.hi(JoinTroopVerifyFragment.this, view2);
            }
        });
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = this.briefInputBorderLayout;
        if (roundCorneredRelativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputBorderLayout");
            roundCorneredRelativeLayout = null;
        }
        roundCorneredRelativeLayout.setRadius(LayoutAttrsKt.getDp(Float.valueOf(8.0f)), LayoutAttrsKt.getDp(Float.valueOf(8.0f)), LayoutAttrsKt.getDp(Float.valueOf(8.0f)), LayoutAttrsKt.getDp(Float.valueOf(8.0f)));
        fi();
        EditText editText3 = this.briefInputView;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
            editText3 = null;
        }
        editText3.addTextChangedListener(new f());
        EditText editText4 = this.briefInputView;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
        } else {
            editText2 = editText4;
        }
        editText2.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(((ITroopVerifyApi) QRoute.api(ITroopVerifyApi.class)).getPageSwitch().d())});
        zi();
        this.joinBtn = (QUIButton) view.findViewById(R.id.f102315xk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(JoinTroopVerifyFragment this$0, String groupCode, com.tencent.qqnt.troop.d dVar, QQAppInterface app, boolean z16, int i3, String errMsg, com.tencent.qqnt.bean.c hint) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupCode, "$groupCode");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (z16) {
            this$0.ri(i3, groupCode);
        } else {
            this$0.qi(i3);
        }
        com.tencent.qqnt.bean.e b16 = hint.b();
        if (b16 != null && b16.c()) {
            com.tencent.mobileqq.troop.jointroopsecuritytips.b.a(app, b16.a(), b16.b(), this$0.getActivity());
        }
        com.tencent.qqnt.bean.d a16 = hint.a();
        if (a16 != null) {
            QQProgressDialog qQProgressDialog = this$0.mDlgProgress;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            com.tencent.mobileqq.troop.temporaryban.c.e().g(app, this$0.getActivity(), a16.a(), groupCode);
        }
        if (dVar != null) {
            dVar.a(z16, i3, errMsg, hint);
        }
    }

    private final void ki() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra(ProfileContants.CMD_PARAM_STAT_OPTION, 0);
        }
        if (TextUtils.isEmpty(this.authSig)) {
            QLog.w("JoinTroopVerifyFragment", 4, "authSig | missing 'authSig' when join group");
        } else {
            QLog.i("JoinTroopVerifyFragment", 4, "authSig | authSig is not null");
        }
        QLog.i("JoinTroopVerifyFragment", 4, "authSig | statOption = " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(boolean isSuc, TroopInfo info) {
        Bundle extras;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.e("JoinTroopVerifyFragment", 1, "onGetSimpleTroopInfoResult, activity = null");
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            QLog.e("JoinTroopVerifyFragment", 1, "onGetSimpleTroopInfoResult, app = null");
            return;
        }
        short s16 = 2;
        EditText editText = null;
        if (isSuc) {
            Intent intent = activity.getIntent();
            if (intent != null && (extras = intent.getExtras()) != null) {
                s16 = extras.getShort("group_option", (short) 2);
            }
            if (s16 == 4) {
                if (info != null) {
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), null);
                    m3.putExtra("uin", info.troopuin);
                    m3.putExtra("uintype", 1);
                    m3.putExtra("key_from", com.tencent.mobileqq.utils.es.f307750a.a(activity.getIntent().getIntExtra(ProfileContants.CMD_PARAM_STAT_OPTION, 0)));
                    m3.putExtra("uinname", info.getTroopDisplayName());
                    startActivity(m3);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(this.mTroopUin) && !TextUtils.isEmpty(qQAppInterface.getAccount()) && s16 == 1) {
                if (info != null) {
                    ProxyManager proxyManager = qQAppInterface.getProxyManager();
                    RecentUser findRecentUserByUin = proxyManager.m().findRecentUserByUin(info.troopuin, 1);
                    if (findRecentUserByUin != null) {
                        findRecentUserByUin.displayName = info.troopname;
                        findRecentUserByUin.msgData = null;
                        findRecentUserByUin.f203116msg = null;
                        findRecentUserByUin.msgType = 0;
                        long serverTime = NetConnInfoCenter.getServerTime();
                        if (findRecentUserByUin.lastmsgtime < serverTime) {
                            findRecentUserByUin.lastmsgtime = serverTime;
                        }
                        proxyManager.m().saveRecentUser(findRecentUserByUin);
                    }
                    activity.setResult(-1);
                }
                activity.finish();
                return;
            }
            return;
        }
        activity.setResult(-1);
        Window window = activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(2);
        }
        InputMethodManager inputMethodManager = this.imm;
        if (inputMethodManager != null) {
            EditText editText2 = this.reasonInputView;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
                editText2 = null;
            }
            inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        }
        EditText editText3 = this.reasonInputView;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
        } else {
            editText = editText3;
        }
        editText.clearFocus();
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(boolean isSuccess, TroopInfo troop) {
        String replace$default;
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            QLog.e("JoinTroopVerifyFragment", 1, "[onHandleTroopInfoForGuest] app = null");
            return;
        }
        if (isSuccess) {
            long j3 = troop.dwGroupClassExt;
            QLog.i("JoinTroopVerifyFragment", 1, "[onHandleTroopInfoForGuest] isSuccess:" + isSuccess + ", troopInfo:" + troop + ", dwGroupClassExt:" + j3);
            if (j3 != 10009 && j3 != 10010 && j3 != 10011 && j3 != 10012 && !troop.isHomeworkTroop()) {
                String c16 = ((ITroopVerifyApi) QRoute.api(ITroopVerifyApi.class)).getPageSwitch().c();
                String B = com.tencent.mobileqq.utils.ac.B(qQAppInterface, qQAppInterface.getAccount());
                Intrinsics.checkNotNullExpressionValue(B, "getFriendName(app, app.account)");
                replace$default = StringsKt__StringsJVMKt.replace$default(c16, "#{nickname}", B, false, 4, (Object) null);
                vi(replace$default);
                return;
            }
            QLog.i("JoinTroopVerifyFragment", 1, "[onHandleTroopInfoForGuest] \u4e0d\u9700\u8981\u663e\u793a\u57ce\u5e02\u3001\u661f\u5ea7\u3001\u6027\u522b\u8fd9\u4e00\u4ea4\u53cb\u4fe1\u606f~");
            return;
        }
        QLog.i("JoinTroopVerifyFragment", 1, "[onHandleTroopInfoForGuest] isSuccess:" + isSuccess + ", troopuin:" + this.mTroopUin);
    }

    private final void ni(int templateId) {
        int i3;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (templateId != 2000) {
            Uh(activity, templateId, JoinTroopVerifyFragment$onSelectTemplate$1.INSTANCE);
        }
        RecyclerView recyclerView = null;
        if (templateId == 2000) {
            EditText editText = this.briefInputView;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
                editText = null;
            }
            editText.setTextColor(activity.getColor(R.color.qui_common_text_primary));
            ImageView imageView = this.vipHeadView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vipHeadView");
                imageView = null;
            }
            imageView.setVisibility(8);
            View view = this.briefInputLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("briefInputLayout");
                view = null;
            }
            view.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg);
            EditText editText2 = this.briefInputView;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
                editText2 = null;
            }
            editText2.setTextColor(activity.getColor(R.color.qui_common_text_primary));
            TextView textView = this.briefWordCountView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("briefWordCountView");
                textView = null;
            }
            textView.setTextColor(activity.getColor(R.color.qui_common_text_secondary));
        } else {
            if (bi().isFileExists(templateId)) {
                xi(templateId);
            } else {
                bi().addDownLoadListener(templateId, new d(templateId, this));
                bi().startDownload(templateId);
            }
            if (SimpleUIUtil.getSimpleUISwitch()) {
                DialogUtil.createCustomDialog(activity, 0, HardCodeUtil.qqStr(R.string.j4h), HardCodeUtil.qqStr(R.string.j4b), (String) null, HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.dx
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        JoinTroopVerifyFragment.oi(dialogInterface, i16);
                    }
                }, (DialogInterface.OnClickListener) null).show();
            }
        }
        QLog.i("JoinTroopVerifyFragment", 1, "select: " + templateId);
        RecyclerView recyclerView2 = this.templateRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        com.tencent.mobileqq.activity.aio.item.h hVar = this.templateAdapter;
        if (hVar != null) {
            i3 = hVar.l0(templateId);
        } else {
            i3 = 0;
        }
        recyclerView.scrollToPosition(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(Activity activity, int type, boolean isSuccess, Object data, int templateId) {
        if (type != 2) {
            if (type == 3) {
                if (isSuccess && (data instanceof UniGetRsp)) {
                    Iterator<UniBusinessItem> it = ((UniGetRsp) data).uniBusinessItemList.iterator();
                    while (it.hasNext()) {
                        UniBusinessItem next = it.next();
                        if (next.appid == 40) {
                            if (next.itemid == 2004 && !com.tencent.mobileqq.vas.ar.INSTANCE.b("kenaiyu", "2024-12-05", "vas_bug_134114859").isEnable(true)) {
                                com.tencent.mobileqq.activity.aio.item.h hVar = this.templateAdapter;
                                if (hVar != null) {
                                    hVar.t0(2003);
                                }
                            } else {
                                com.tencent.mobileqq.activity.aio.item.h hVar2 = this.templateAdapter;
                                if (hVar2 != null) {
                                    hVar2.t0(next.itemid);
                                }
                            }
                            QLog.e("JoinTroopVerifyFragment", 1, "TYPE_UNI_GET_RSP: " + next.itemid);
                            return;
                        }
                    }
                    Bi();
                    QLog.e("JoinTroopVerifyFragment", 1, "TYPE_UNI_GET_RSP nothing: " + this.serverTemplateId);
                    return;
                }
                QLog.e("AddFriendVerifyActivity", 1, "TYPE_UNI_GET_RSP: " + isSuccess + " data=" + data);
                return;
            }
            return;
        }
        if (isSuccess && (data instanceof UniSetRsp)) {
            UniSetRsp uniSetRsp = (UniSetRsp) data;
            int i3 = uniSetRsp.ret;
            if (i3 == 0) {
                this.serverTemplateId = templateId;
                QLog.e("JoinTroopVerifyFragment", 1, "TYPE_UNI_SET_RSP success: " + templateId);
                return;
            }
            QLog.e("JoinTroopVerifyFragment", 1, "TYPE_UNI_SET_RSP: " + i3 + " msg:" + uniSetRsp.errmsg);
            a.f(activity, uniSetRsp.ret, true);
            com.tencent.mobileqq.activity.aio.item.h hVar3 = this.templateAdapter;
            if (hVar3 != null) {
                hVar3.t0(this.serverTemplateId);
                return;
            }
            return;
        }
        QLog.e("JoinTroopVerifyFragment", 1, "TYPE_UNI_SET_RSP: " + isSuccess + " data=" + data);
    }

    private final void qi(int result) {
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed(BaseApplication.getContext(), result);
        this.mJoinTroopStatus = 1002;
    }

    private final void ri(int result, String troopUin) {
        QBaseActivity qBaseActivity;
        Bundle bundle;
        Long longOrNull;
        long j3;
        Long longOrNull2;
        long j16;
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        Long longOrNull3;
        long j17;
        Long longOrNull4;
        long j18;
        Bundle extras;
        FragmentActivity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            QLog.e("JoinTroopVerifyFragment", 1, "onTroopManagerSuccess, activity = null");
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            QLog.e("JoinTroopVerifyFragment", 1, "onTroopManagerSuccess, app = null");
            return;
        }
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        QLog.i("JoinTroopVerifyFragment", 1, "[onTroopManagerSuccess] troopUin:" + troopUin + ", result:" + result);
        short s16 = 0;
        if (result != -2) {
            if (result != 0 && result != 1) {
                if (result != 2) {
                    this.mJoinTroopStatus = 1002;
                    QQToast.makeText(qBaseActivity, 1, R.string.f173065h22, 1).show(qBaseActivity.getTitleBarHeight());
                    return;
                } else {
                    this.mJoinTroopStatus = 1002;
                    QQToast.makeText(qBaseActivity, 1, R.string.i7i, 1).show(qBaseActivity.getTitleBarHeight());
                    return;
                }
            }
            Intent intent = qBaseActivity.getIntent();
            if (intent != null) {
                str = intent.getStringExtra("param_return_addr");
            } else {
                str = null;
            }
            this.mJoinTroopStatus = 1003;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QQToast.makeText(qBaseActivity, 2, R.string.f173066h23, 1).show(qBaseActivity.getTitleBarHeight());
                try {
                    Class<?> cls = Class.forName(str);
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(MainService.QQPROCESSNAME, cls.getName()));
                    intent2.setFlags(67108864);
                    startActivity(intent2);
                } catch (ClassNotFoundException e16) {
                    e16.printStackTrace();
                    qBaseActivity.setResult(-1);
                    qBaseActivity.finish();
                }
            } else {
                Intent intent3 = qBaseActivity.getIntent();
                if (intent3 != null && intent3.getBooleanExtra("from_newer_guide", false)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("has_operation", true);
                    intent4.putExtra("uin", troopUin);
                    qBaseActivity.setResult(-1, intent4);
                    qBaseActivity.finish();
                } else {
                    Intent intent5 = qBaseActivity.getIntent();
                    if (intent5 != null && intent5.getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false)) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        Intent intent6 = new Intent();
                        intent6.putExtra("has_operation", true);
                        intent6.putExtra("uin", troopUin);
                        qBaseActivity.setResult(-1, intent6);
                        qBaseActivity.finish();
                    } else {
                        Intent intent7 = qBaseActivity.getIntent();
                        if (intent7 != null && (extras = intent7.getExtras()) != null) {
                            s16 = extras.getShort("group_option", (short) 2);
                        }
                        Object businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
                        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.api.handler.ITroopMngHandler");
                        com.tencent.mobileqq.troop.api.handler.h hVar = (com.tencent.mobileqq.troop.api.handler.h) businessHandler;
                        if (s16 != 1 && s16 != 4) {
                            longOrNull3 = StringsKt__StringNumberConversionsKt.toLongOrNull(this.mTroopUin);
                            if (longOrNull3 != null) {
                                j17 = longOrNull3.longValue();
                            } else {
                                j17 = 0;
                            }
                            String account = qQAppInterface.getAccount();
                            Intrinsics.checkNotNullExpressionValue(account, "app.account");
                            longOrNull4 = StringsKt__StringNumberConversionsKt.toLongOrNull(account);
                            if (longOrNull4 != null) {
                                j18 = longOrNull4.longValue();
                            } else {
                                j18 = 0;
                            }
                            hVar.v(j17, j18);
                        } else {
                            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(this.mTroopUin, "JoinTroopVerifyFragment", this, new Function2<Boolean, TroopInfo, Unit>() { // from class: com.tencent.mobileqq.activity.JoinTroopVerifyFragment$onTroopManagerSuccess$1
                                static IPatchRedirector $redirector_;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(2);
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) JoinTroopVerifyFragment.this);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
                                    invoke(bool.booleanValue(), troopInfo);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z19, @NotNull TroopInfo data) {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z19), data);
                                    } else {
                                        Intrinsics.checkNotNullParameter(data, "data");
                                        JoinTroopVerifyFragment.this.li(z19, data);
                                    }
                                }
                            });
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(this.mHomeworkIntroStr)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add("admin.qun.qq.com");
                com.tencent.mobileqq.jsp.h.w("closeJoinWebView", null, arrayList, null);
                return;
            }
            return;
        }
        this.mJoinTroopStatus = 1004;
        Intent intent8 = qBaseActivity.getIntent();
        if (intent8 != null) {
            bundle = intent8.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            if (bundle.getShort("group_option", (short) 2) == 4) {
                String string = qBaseActivity.getResources().getString(R.string.f179843_g);
                Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ng.qb_troop_answer_error)");
                QQToast.makeText(qBaseActivity, 1, string, 0).show(qBaseActivity.getTitleBarHeight());
                this.mJoinTroopStatus = 1002;
                return;
            }
            Object businessHandler2 = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
            Intrinsics.checkNotNull(businessHandler2, "null cannot be cast to non-null type com.tencent.mobileqq.troop.api.handler.ITroopMngHandler");
            com.tencent.mobileqq.troop.api.handler.h hVar2 = (com.tencent.mobileqq.troop.api.handler.h) businessHandler2;
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.mTroopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            String account2 = qQAppInterface.getAccount();
            Intrinsics.checkNotNullExpressionValue(account2, "app.account");
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(account2);
            if (longOrNull2 != null) {
                j16 = longOrNull2.longValue();
            } else {
                j16 = 0;
            }
            hVar2.v(j3, j16);
            this.mHasReqJoinTroopWebInfo = true;
        }
    }

    private final void si(QQText troopCheckQu, QQAppInterface app) {
        Object[] objArr;
        LinkSpan linkSpan;
        int i3;
        if (troopCheckQu.mSpanCount <= 0 || (objArr = troopCheckQu.mSpans) == null) {
            return;
        }
        for (Object obj : objArr) {
            if (obj instanceof LinkSpan) {
                String str = null;
                if (obj instanceof LinkSpan) {
                    linkSpan = (LinkSpan) obj;
                } else {
                    linkSpan = null;
                }
                if (linkSpan != null) {
                    str = linkSpan.f292710d;
                }
                if (str == null) {
                    str = "";
                }
                if (com.tencent.mobileqq.utils.cg.f307525d.matcher(str).find()) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                if (com.tencent.mobileqq.text.n.f292694c.matcher(str).find()) {
                    i3 = 1;
                }
                if (com.tencent.mobileqq.text.n.f292697f.matcher(str).find()) {
                    i3 = 2;
                }
                String str2 = this.mTroopUin;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                ReportController.o(app, "P_CliOper", "Grp_join", "", "send", "exp_url", 0, 0, str2, sb5.toString(), "", "");
            }
        }
    }

    private final void ti(View rightHighlightButton) {
        int i3;
        int i16;
        HashMap hashMapOf;
        EditText editText = this.reasonInputView;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonInputView");
            editText = null;
        }
        String obj = editText.getText().toString();
        EditText editText3 = this.briefInputView;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
        } else {
            editText2 = editText3;
        }
        String obj2 = editText2.getText().toString();
        com.tencent.mobileqq.activity.aio.item.h hVar = this.templateAdapter;
        if (hVar != null) {
            i3 = hVar.m0();
        } else {
            i3 = 2000;
        }
        switch (i3) {
            case 2001:
                i16 = 1;
                break;
            case 2002:
                i16 = 2;
                break;
            case 2003:
                i16 = 3;
                break;
            default:
                i16 = 0;
                break;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("verify_content", obj), TuplesKt.to("self_introduction_content", obj2), TuplesKt.to("self_introduction_switch", 1), TuplesKt.to("value_add_module", Integer.valueOf(i16)));
        VideoReport.reportEvent("dt_clck", rightHighlightButton, hashMapOf);
    }

    private final void ui(View rightHighlightButton, String groupUin) {
        HashMap hashMapOf;
        if (rightHighlightButton != null) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("self_introduction_switch", 1));
            VideoReport.setElementClickPolicy(rightHighlightButton, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(rightHighlightButton, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementId(rightHighlightButton, "em_group_apply_send");
            VideoReport.reportEvent("dt_imp", rightHighlightButton, hashMapOf);
        }
    }

    private final void vi(String introduction) {
        int i3;
        int coerceAtMost;
        try {
            Charset forName = Charset.forName("utf-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = introduction.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            i3 = bytes.length;
        } catch (Exception e16) {
            QLog.e("JoinTroopVerifyFragment", 1, "get intro length failed!", e16);
            i3 = 0;
        }
        TextView textView = this.briefWordCountView;
        EditText editText = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefWordCountView");
            textView = null;
        }
        textView.setText(String.valueOf(((ITroopVerifyApi) QRoute.api(ITroopVerifyApi.class)).getPageSwitch().d() - i3));
        EditText editText2 = this.briefInputView;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
            editText2 = null;
        }
        editText2.setText(introduction);
        int length = introduction.length();
        TextView textView2 = this.briefWordCountView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefWordCountView");
            textView2 = null;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(length, textView2.getText().length());
        EditText editText3 = this.briefInputView;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
        } else {
            editText = editText3;
        }
        editText.setSelection(coerceAtMost);
    }

    private final void wi() {
        TopGestureLayout ai5 = ai();
        if (ai5 != null) {
            ai5.setInterceptTouchEventListener(new h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(JoinTroopVerifyFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ni(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi() {
        EditText editText = this.briefInputView;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefInputView");
            editText = null;
        }
        int length = editText.getText().length();
        int d16 = ((ITroopVerifyApi) QRoute.api(ITroopVerifyApi.class)).getPageSwitch().d();
        if (length == 0) {
            TextView textView2 = this.briefWordCountView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("briefWordCountView");
            } else {
                textView = textView2;
            }
            textView.setText(d16 + "\u5b57");
            return;
        }
        if (length > d16) {
            length = d16;
        }
        TextView textView3 = this.briefWordCountView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("briefWordCountView");
        } else {
            textView = textView3;
        }
        textView.setText(length + "/" + d16 + "\u5b57");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        QBaseActivity qBaseActivity;
        Object obj;
        String str;
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        FragmentActivity activity = getActivity();
        QQAppInterface qQAppInterface = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            obj = qBaseActivity.getAppRuntime();
        } else {
            obj = null;
        }
        if (obj instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) obj;
        }
        this.app = qQAppInterface;
        if (qQAppInterface == null) {
            QLog.e("JoinTroopVerifyFragment", 1, "doOnCreateView, app == null");
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (resources = activity2.getResources()) == null || (str = resources.getString(R.string.f234637_h)) == null) {
            str = "";
        }
        setTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h6_;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return;
        }
        qBaseActivity.removeObserver(this.mTroopMngObserver);
        this.vipEnterTroopEffectLogic.g();
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onFinish();
        Intent intent = new Intent("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION");
        intent.setPackage(MobileQQ.PACKAGE_NAME);
        intent.putExtra("ret_action", this.mJoinTroopStatus);
        BaseApplication.context.sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColorNew(!QQTheme.isNowThemeIsNight(), getHostActivity().getWindow());
        }
        wi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        ki();
        this.vipEnterTroopEffectLogic.d((ViewGroup) view.findViewById(R.id.f116396ym), this.mTroopUin);
        this.vipEnterTroopEffectLogic.e(view.findViewById(R.id.f27080f_));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xi(int templateId) {
    }
}
