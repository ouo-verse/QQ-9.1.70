package com.tencent.mobileqq.zplan.minihome;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.minihome.data.DecorateIdentifies;
import com.tencent.mobileqq.zplan.minihome.data.DecorateMode;
import com.tencent.mobileqq.zplan.minihome.data.RoomInstDiff;
import com.tencent.mobileqq.zplan.minihome.data.ServerFurnitureDesc;
import com.tencent.mobileqq.zplan.minihome.repository.MiniHomeViewModel;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeActionBtnComponent;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditBuyAndSaveButton;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeEditGuideComponent;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeSampleOutlineView;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeSampleType;
import com.tencent.mobileqq.zplan.utils.PayUtil;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.common.utils.GsonUtil;
import fi3.ay;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import yk0.DecorateInfo;
import yk0.DecorateScreenPosition;
import yk0.FurnitureDesc;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\u00b4\u0001\u0018\u0000 \u00c3\u00012\u00020\u0001:\u0006\u00c4\u0001\u00c5\u0001\u00c6\u0001B\t\u00a2\u0006\u0006\b\u00c1\u0001\u0010\u00c2\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0017J\b\u0010\u0016\u001a\u00020\tH\u0016J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0014\u0010\"\u001a\u00020\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u001c\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%2\u0006\u0010$\u001a\u00020#H\u0002J2\u00100\u001a\u00020\t2\u0006\u0010$\u001a\u00020)2 \u0010/\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020,\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0+\u0018\u00010*H\u0002J\u001a\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020'2\b\b\u0002\u0010\u0019\u001a\u00020\u0002H\u0002J\u0010\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020.H\u0002J\b\u00105\u001a\u00020\tH\u0002J\b\u00106\u001a\u00020\tH\u0002J\u001a\u00108\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u00010.H\u0002J \u0010<\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0002J \u0010>\u001a\u00020\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00103\u001a\u0004\u0018\u00010=H\u0003J\b\u0010?\u001a\u00020\tH\u0002J\b\u0010@\u001a\u00020\tH\u0002J\u001a\u0010C\u001a\u00020\t2\b\u0010A\u001a\u0004\u0018\u00010\u00172\u0006\u0010B\u001a\u00020,H\u0002J\u0012\u0010D\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010E\u001a\u00020\tH\u0002J\u0014\u0010F\u001a\u00020\t2\n\b\u0002\u00103\u001a\u0004\u0018\u00010=H\u0002J\b\u0010G\u001a\u00020\tH\u0002J\u0018\u0010J\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00172\u0006\u0010I\u001a\u00020HH\u0002J\b\u0010K\u001a\u00020\tH\u0002J\b\u0010L\u001a\u00020\tH\u0002J\b\u0010M\u001a\u00020\tH\u0002J\u0012\u0010O\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\u0002H\u0002J\b\u0010P\u001a\u00020\tH\u0002J\u001e\u0010U\u001a\u0004\u0018\u00010T2\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010S\u001a\u0004\u0018\u00010QH\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010V\u001a\u00020\u0017H\u0002J\b\u0010Y\u001a\u00020\u0002H\u0002J\u0018\u0010[\u001a\u00020\t2\u0006\u0010Z\u001a\u00020W2\u0006\u0010N\u001a\u00020\u0002H\u0002J\u0018\u0010]\u001a\u00020\t2\u0006\u0010\\\u001a\u00020 2\u0006\u0010N\u001a\u00020\u0002H\u0002J\b\u0010^\u001a\u00020\tH\u0002J\b\u0010_\u001a\u00020\tH\u0002J\b\u0010`\u001a\u00020\tH\u0002J$\u0010c\u001a\u00020\t2\u0006\u0010a\u001a\u00020\u00172\b\b\u0002\u0010b\u001a\u00020\u00172\b\b\u0002\u0010N\u001a\u00020\u0002H\u0002J\u0010\u0010e\u001a\u00020\t2\u0006\u0010d\u001a\u00020\u0017H\u0002J\u0018\u0010i\u001a\u00020\t2\u0006\u0010g\u001a\u00020f2\u0006\u0010h\u001a\u00020fH\u0002J\u0010\u0010k\u001a\u00020\t2\u0006\u0010j\u001a\u00020\u000fH\u0002J\b\u0010l\u001a\u00020\u0017H\u0002R\u001b\u0010r\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u001b\u0010w\u001a\u00020s8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010o\u001a\u0004\bu\u0010vR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010h\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001f\u0010\u0085\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0%8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001f\u0010\u0087\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0%8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0084\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010\u008e\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R&\u0010\u0092\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010=0\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R%\u0010\u0095\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0005\u0012\u00030\u0093\u00010\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0091\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R(\u0010\u009e\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010.0\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u0091\u0001R\u0019\u0010\u00a0\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0083\u0001R\u0019\u0010\u00a2\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u0083\u0001R\u0019\u0010\u00a5\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u0019\u0010\u00a8\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R \u0010\u00ad\u0001\u001a\u00030\u00a9\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00aa\u0001\u0010o\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001c\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R'\u0010\u00b3\u0001\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u0084\u0001R\u0018\u0010\u00b7\u0001\u001a\u00030\u00b4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001R \u0010\u00bc\u0001\u001a\u00030\u00b8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b9\u0001\u0010o\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u001a\u0010\u00c0\u0001\u001a\u00030\u00bd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u00bf\u0001\u00a8\u0006\u00c7\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "needStatusTrans", "needImmersive", "isWrapContent", "onBackEvent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "dataJson", "showGuide", "zi", "Ri", "wj", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "vj", "Lcom/tencent/mobileqq/zplan/minihome/ao;", "desc", "xj", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lr55/b;", "Fi", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Pair;", "", "", "Ln55/a;", "source", "zj", "sampleRoomDesc", "Bi", "furniture", WidgetCacheLunarData.YI, "kj", SensorJsPlugin.SENSOR_INTERVAL_UI, "slot", "ti", "success", "Lcom/tencent/mobileqq/zplan/minihome/data/c;", "serverFurnitureDesc", "gj", "Lyk0/c;", "dj", "Si", "Ti", "filterExpression", "pageIndex", "fj", "bj", "Hi", "sj", "uj", "Lcom/tencent/filament/zplan/scene/minihome/a;", "callback", "nj", "pj", "aj", "oj", "isBuy", "lj", "xi", "Lorg/json/JSONArray;", "oldInst", "newInst", "Lcom/tencent/mobileqq/zplan/minihome/data/b;", "vi", "jsonString", "", "Ni", "Ui", "output", "Di", "roomDesc", "Ei", "ij", "jj", "Qi", "eventKey", "reportJsonString", "hj", "text", "Aj", "Landroid/widget/ImageView;", "editFloorImage", "editWallImage", "Oi", "image", "Pi", "Mi", "Lcom/tencent/mobileqq/zplan/minihome/y;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Ji", "()Lcom/tencent/mobileqq/zplan/minihome/y;", "miniHomeController", "Lfi3/ay;", "D", "Gi", "()Lfi3/ay;", "binding", "E", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeActionBtnComponent;", "G", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeActionBtnComponent;", "actionBtnComponent", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeEditDecorateListViewModel;", "H", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeEditDecorateListViewModel;", "viewModel", "I", "Lkotlinx/coroutines/flow/MutableStateFlow;", "furnitureChoosing", "J", "sampleRoomChoosing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "K", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasEdited", "L", "Ljava/lang/String;", "selectedSlot", "Ljava/util/concurrent/ConcurrentHashMap;", "M", "Ljava/util/concurrent/ConcurrentHashMap;", "furnitureDescMapOnScreen", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeEditGuideComponent;", "N", "editGuideOnScreen", "P", "Landroid/view/View;", "textureView", "Lcom/tencent/mobileqq/zplan/minihome/data/DecorateMode;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zplan/minihome/data/DecorateMode;", "decorateMode", BdhLogUtil.LogTag.Tag_Req, "curSelectedFurnitureMap", ExifInterface.LATITUDE_SOUTH, "curTotalPrice", "T", "curTotalNum", "U", "Lr55/b;", "curRoomDesc", "V", "Lcom/tencent/sqshow/zootopia/data/f;", "currencyData", "Lcom/tencent/mobileqq/zplan/minihome/aa;", "W", "Li", "()Lcom/tencent/mobileqq/zplan/minihome/aa;", "miniHomeReporter", "Landroid/app/Dialog;", "X", "Landroid/app/Dialog;", "loadingDialog", "Y", "sampleRoomSource", "com/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$c", "Z", "Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$c;", "updateCurrencyDataCallback", "Lcom/tencent/mobileqq/zplan/minihome/repository/MiniHomeViewModel;", "a0", "Ki", "()Lcom/tencent/mobileqq/zplan/minihome/repository/MiniHomeViewModel;", "miniHomeInfoViewModel", "Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeSource;", "b0", "Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeSource;", "editHomeSource", "<init>", "()V", "c0", "a", "LoadRoomCallback", "LoadSampleRoomCallback", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class EditMiniHomeFragment extends QPublicBaseFragment {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy miniHomeController;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy binding;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView editFloorImage;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView editWallImage;

    /* renamed from: G, reason: from kotlin metadata */
    private MiniHomeActionBtnComponent actionBtnComponent;

    /* renamed from: H, reason: from kotlin metadata */
    private MiniHomeEditDecorateListViewModel viewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableStateFlow<n55.a> furnitureChoosing;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableStateFlow<r55.b> sampleRoomChoosing;

    /* renamed from: K, reason: from kotlin metadata */
    private final AtomicBoolean hasEdited;

    /* renamed from: L, reason: from kotlin metadata */
    private String selectedSlot;

    /* renamed from: M, reason: from kotlin metadata */
    private final ConcurrentHashMap<String, FurnitureDesc> furnitureDescMapOnScreen;

    /* renamed from: N, reason: from kotlin metadata */
    private final ConcurrentHashMap<String, MiniHomeEditGuideComponent> editGuideOnScreen;

    /* renamed from: P, reason: from kotlin metadata */
    private View textureView;

    /* renamed from: Q, reason: from kotlin metadata */
    private DecorateMode decorateMode;

    /* renamed from: R, reason: from kotlin metadata */
    private ConcurrentHashMap<String, n55.a> curSelectedFurnitureMap;

    /* renamed from: S, reason: from kotlin metadata */
    private int curTotalPrice;

    /* renamed from: T, reason: from kotlin metadata */
    private int curTotalNum;

    /* renamed from: U, reason: from kotlin metadata */
    private r55.b curRoomDesc;

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.data.f currencyData;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy miniHomeReporter;

    /* renamed from: X, reason: from kotlin metadata */
    private Dialog loadingDialog;

    /* renamed from: Y, reason: from kotlin metadata */
    private MutableStateFlow<r55.b[]> sampleRoomSource;

    /* renamed from: Z, reason: from kotlin metadata */
    private final c updateCurrencyDataCallback;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Lazy miniHomeInfoViewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private EditMiniHomeSource editHomeSource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$1", f = "EditMiniHomeFragment.kt", i = {}, l = {1936}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$1$a */
        /* loaded from: classes34.dex */
        public static final class a implements FlowCollector<n55.a> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ EditMiniHomeFragment f334251d;

            public a(EditMiniHomeFragment editMiniHomeFragment) {
                this.f334251d = editMiniHomeFragment;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(n55.a aVar, Continuation<? super Unit> continuation) {
                this.f334251d.yi(aVar);
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow filterNotNull = FlowKt.filterNotNull(EditMiniHomeFragment.this.furnitureChoosing);
                a aVar = new a(EditMiniHomeFragment.this);
                this.label = 1;
                if (filterNotNull.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$2", f = "EditMiniHomeFragment.kt", i = {}, l = {1936}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$2$a */
        /* loaded from: classes34.dex */
        public static final class a implements FlowCollector<r55.b> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ EditMiniHomeFragment f334252d;

            public a(EditMiniHomeFragment editMiniHomeFragment) {
                this.f334252d = editMiniHomeFragment;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(r55.b bVar, Continuation<? super Unit> continuation) {
                EditMiniHomeFragment.Ci(this.f334252d, bVar, false, 2, null);
                return Unit.INSTANCE;
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow filterNotNull = FlowKt.filterNotNull(EditMiniHomeFragment.this.sampleRoomChoosing);
                a aVar = new a(EditMiniHomeFragment.this);
                this.label = 1;
                if (filterNotNull.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$LoadRoomCallback;", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeLoadCallback;", "fragment", "Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;", "roomJson", "", "(Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;Ljava/lang/String;)V", "getFragment", "()Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;", "getRoomJson", "()Ljava/lang/String;", "onMiniHomeLoadResult", "", "success", "", "dataJson", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class LoadRoomCallback implements IMiniHomeLoadCallback {
        private final EditMiniHomeFragment fragment;
        private final String roomJson;

        public LoadRoomCallback(EditMiniHomeFragment fragment, String str) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
            this.roomJson = str;
        }

        public final EditMiniHomeFragment getFragment() {
            return this.fragment;
        }

        public final String getRoomJson() {
            return this.roomJson;
        }

        @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback
        public void onMiniHomeLoadResult(boolean success, String dataJson) {
            QLog.i("EditMiniHomeFragment", 1, "onMiniHomeLoadResult success:" + success + ", data:" + dataJson);
            if (!success) {
                QLog.e("EditMiniHomeFragment", 1, "loadRoom json error. " + this.roomJson);
                return;
            }
            EditMiniHomeFragment.Ai(this.fragment, dataJson, false, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$LoadSampleRoomCallback;", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeLoadCallback;", "fragment", "Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;", "roomJson", "", "showGuide", "", "(Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;Ljava/lang/String;Z)V", "getFragment", "()Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment;", "getRoomJson", "()Ljava/lang/String;", "getShowGuide", "()Z", "onMiniHomeLoadResult", "", "success", "dataJson", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class LoadSampleRoomCallback implements IMiniHomeLoadCallback {
        private final EditMiniHomeFragment fragment;
        private final String roomJson;
        private final boolean showGuide;

        public LoadSampleRoomCallback(EditMiniHomeFragment fragment, String roomJson, boolean z16) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(roomJson, "roomJson");
            this.fragment = fragment;
            this.roomJson = roomJson;
            this.showGuide = z16;
        }

        public final EditMiniHomeFragment getFragment() {
            return this.fragment;
        }

        public final String getRoomJson() {
            return this.roomJson;
        }

        public final boolean getShowGuide() {
            return this.showGuide;
        }

        @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback
        public void onMiniHomeLoadResult(boolean success, final String dataJson) {
            QLog.i("EditMiniHomeFragment", 1, "loadRoom onMiniHomeLoadResult " + success);
            System.currentTimeMillis();
            if (!success) {
                QLog.e("EditMiniHomeFragment", 1, "loadRoom json error. " + this.roomJson);
                return;
            }
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$LoadSampleRoomCallback$onMiniHomeLoadResult$1
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
                    ConcurrentHashMap concurrentHashMap;
                    r55.b bVar;
                    concurrentHashMap = EditMiniHomeFragment.LoadSampleRoomCallback.this.getFragment().editGuideOnScreen;
                    Iterator it = concurrentHashMap.values().iterator();
                    while (it.hasNext()) {
                        ((MiniHomeEditGuideComponent) it.next()).e();
                    }
                    EditMiniHomeFragment fragment = EditMiniHomeFragment.LoadSampleRoomCallback.this.getFragment();
                    String str = dataJson;
                    bVar = EditMiniHomeFragment.LoadSampleRoomCallback.this.getFragment().curRoomDesc;
                    fragment.zi(str, bVar.f430787j && EditMiniHomeFragment.LoadSampleRoomCallback.this.getShowGuide());
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002H\u0002J4\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$a;", "", "", "f", "", "Ln55/a;", "", "Lyk0/c;", "decorateItems", "currentSelectedDecorateItem", "c", "", "e", "", "BUTTON_RATE", UserInfo.SEX_FEMALE, "GRADIENT_BAR_RATE", "GRADIENT_BAR_TOP_RATE", "", "ONE_CELL_SIZE", "I", "RECYCLER_VIEW_RATE", "REPLACE_IMAGE_SIZE", "SLOT_FLOOR", "Ljava/lang/String;", "SLOT_MAIN", "SLOT_WALL", "TAG", "TEXTURE_VIEW_RATE", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<n55.a> c(List<n55.a> list, Collection<FurnitureDesc> collection, FurnitureDesc furnitureDesc) {
            boolean z16;
            if (collection.isEmpty()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                ServerFurnitureDesc a16 = ServerFurnitureDesc.INSTANCE.a(((n55.a) obj).f418399h);
                boolean z17 = true;
                if (a16 != null && !d(furnitureDesc, a16)) {
                    Collection<FurnitureDesc> collection2 = collection;
                    if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                        for (FurnitureDesc furnitureDesc2 : collection2) {
                            if ((furnitureDesc2 != null && (furnitureDesc2.getId() > a16.getId() ? 1 : (furnitureDesc2.getId() == a16.getId() ? 0 : -1)) == 0) && furnitureDesc2.getSubState() == a16.getSubState() && !furnitureDesc2.getDeleted()) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                        z17 = false;
                    }
                }
                if (z17) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public final boolean e() {
            return false;
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(String str) {
            String group;
            String group2;
            if (str == null || str.length() == 0) {
                return null;
            }
            Matcher matcher = Pattern.compile("sizeX<=(\\d+)&sizeZ<=(\\d+)").matcher(str);
            try {
                if (!matcher.find() || (group = matcher.group(1)) == null || (group2 = matcher.group(2)) == null) {
                    return null;
                }
                return "\uff08" + (Integer.parseInt(group) / 50) + "X" + (Integer.parseInt(group2) / 50) + "\u683c\uff09";
            } catch (Throwable th5) {
                QLog.e("MiniHome-FurnitureDesc", 1, "displaySize exception", th5);
                return null;
            }
        }

        private static final boolean d(FurnitureDesc furnitureDesc, ServerFurnitureDesc serverFurnitureDesc) {
            return furnitureDesc != null && furnitureDesc.getId() == serverFurnitureDesc.getId() && furnitureDesc.getSubState() == serverFurnitureDesc.getSubState() && !furnitureDesc.getDeleted();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/tencent/mobileqq/zplan/minihome/data/a;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends TypeToken<List<? extends DecorateIdentifies>> {
        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/minihome/EditMiniHomeFragment$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(com.tencent.sqshow.zootopia.data.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            EditMiniHomeFragment.this.vj(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("EditMiniHomeFragment", 1, "updateCurrencyView failed error:" + error + " message:" + message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aj(String text) {
        hj("imp", "", this.curTotalPrice > 0);
        Gi().f398988n.u(this.curTotalPrice, this.curTotalNum, text);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Bi(r55.b sampleRoomDesc, boolean showGuide) {
        boolean z16;
        r55.a aVar;
        byte[] bArr;
        boolean isBlank;
        Drawable drawable = AppCompatResources.getDrawable(Gi().getRoot().getContext(), R.drawable.f159884il3);
        ImageView imageView = Gi().f398983i;
        String str = sampleRoomDesc.f430784g;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    String str2 = sampleRoomDesc.f430784g;
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    Unit unit = Unit.INSTANCE;
                    drawable = URLDrawable.getDrawable(str2, obtain);
                }
                imageView.setImageDrawable(drawable);
                aVar = sampleRoomDesc.f430785h;
                if (aVar != null || (bArr = aVar.f430776d) == null) {
                }
                this.curRoomDesc = sampleRoomDesc;
                Intrinsics.checkNotNullExpressionValue(bArr, "sampleRoomDesc.roomDesc.roomDescJson");
                String str3 = new String(bArr, Charsets.UTF_8);
                QLog.i("EditMiniHomeFragment", 1, "roomJson: " + str3);
                Ji().l();
                Ji().o(MiniHomeScene.Companion.CAMERAMODE.NORMAL);
                Ji().c(str3, new LoadSampleRoomCallback(this, str3, showGuide));
                ui();
                Aj("\u5b8c\u6210");
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
        imageView.setImageDrawable(drawable);
        aVar = sampleRoomDesc.f430785h;
        if (aVar != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Di(byte[] output, boolean isBuy) {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this), "zplan_EditMiniHomeFragment_requestUpdateMinihomeReq", null, null, null, new EditMiniHomeFragment$doRequestSaveRoom$1(this, output, isBuy, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ei(ao roomDesc, boolean isBuy) {
        try {
            ao saveRoomDesc = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getSaveRoomDesc(String.valueOf(bb.f335811a.e()));
            if (saveRoomDesc != null) {
                com.tencent.zplan.common.utils.h hVar = com.tencent.zplan.common.utils.h.f385294a;
                JSONObject b16 = hVar.b(saveRoomDesc.getRoomDescJson());
                JSONArray jSONArray = b16 != null ? b16.getJSONArray("inst") : null;
                JSONObject b17 = hVar.b(roomDesc.getRoomDescJson());
                RoomInstDiff vi5 = vi(jSONArray, b17 != null ? b17.getJSONArray("inst") : null);
                if (vi5 != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONArray jSONArray3 = new JSONArray();
                    if (!vi5.a().isEmpty()) {
                        for (DecorateIdentifies decorateIdentifies : vi5.a()) {
                            jSONArray2.mo162put(decorateIdentifies.getId() + "_" + decorateIdentifies.getSubState());
                        }
                    }
                    if (!vi5.b().isEmpty()) {
                        for (DecorateIdentifies decorateIdentifies2 : vi5.b()) {
                            jSONArray3.mo162put(decorateIdentifies2.getId() + "_" + decorateIdentifies2.getSubState());
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("add", jSONArray2);
                    jSONObject.put("del", jSONArray3);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
                    QLog.i("EditMiniHomeFragment", 1, "finishButton report " + jSONObject2);
                    hj("clck", jSONObject2, isBuy);
                }
            }
        } catch (Throwable th5) {
            QLog.e("EditMiniHomeFragment", 1, "finishButton report error, " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ay Gi() {
        return (ay) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi() {
        Ji().b(new com.tencent.filament.zplan.scene.minihome.b() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$getDecoratePositionAndShowOnScreen$1
            @Override // com.tencent.filament.zplan.scene.minihome.b
            public void onGetDecorateScreenPosition(List<DecorateScreenPosition> decorateScreenPositionList) {
                ConcurrentHashMap concurrentHashMap;
                if (decorateScreenPositionList != null) {
                    EditMiniHomeFragment editMiniHomeFragment = EditMiniHomeFragment.this;
                    ArrayList arrayList = new ArrayList();
                    for (DecorateScreenPosition decorateScreenPosition : decorateScreenPositionList) {
                        FurnitureDesc furnitureDesc = new FurnitureDesc(decorateScreenPosition.getId(), decorateScreenPosition.getSubState(), decorateScreenPosition.getSlot(), null, 0, decorateScreenPosition.getDeleted(), decorateScreenPosition.getX(), decorateScreenPosition.getY(), decorateScreenPosition.getCtrlX(), decorateScreenPosition.getCtrlY(), 24, null);
                        arrayList.add(furnitureDesc);
                        String slot = decorateScreenPosition.getSlot();
                        if (slot != null) {
                            concurrentHashMap = editMiniHomeFragment.furnitureDescMapOnScreen;
                            concurrentHashMap.put(slot, furnitureDesc);
                        }
                    }
                    EditMiniHomeFragment.Ii(arrayList, editMiniHomeFragment);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(final List<FurnitureDesc> list, final EditMiniHomeFragment editMiniHomeFragment) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$getDecoratePositionAndShowOnScreen$showOnScreen$1
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

            /* JADX WARN: Type inference failed for: r4v0, types: [com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$getDecoratePositionAndShowOnScreen$showOnScreen$1$1$selectDecorateCallback$1] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int collectionSizeOrDefault;
                ay Gi;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                List<FurnitureDesc> list2 = list;
                final EditMiniHomeFragment editMiniHomeFragment2 = editMiniHomeFragment;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList<MiniHomeEditGuideComponent> arrayList = new ArrayList(collectionSizeOrDefault);
                for (final FurnitureDesc furnitureDesc : list2) {
                    final ?? r46 = new com.tencent.filament.zplan.scene.minihome.a() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$getDecoratePositionAndShowOnScreen$showOnScreen$1$1$selectDecorateCallback$1
                        @Override // com.tencent.filament.zplan.scene.minihome.a
                        public void onDecorateInfoCallback(DecorateInfo decorateInfo) {
                            FurnitureDesc furniture;
                            MiniHomeActionBtnComponent miniHomeActionBtnComponent;
                            MiniHomeActionBtnComponent miniHomeActionBtnComponent2;
                            QLog.i("EditMiniHomeFragment", 1, "selectDecorate " + FurnitureDesc.this.getSlot() + ", onDecorateInfoCallback: " + decorateInfo);
                            if (decorateInfo != null) {
                                FurnitureDesc furnitureDesc2 = FurnitureDesc.this;
                                EditMiniHomeFragment editMiniHomeFragment3 = editMiniHomeFragment2;
                                if (decorateInfo.getSuccess() && (furniture = decorateInfo.getFurniture()) != null) {
                                    if (furniture.getError() != 0) {
                                        QLog.e("EditMiniHomeFragment", 1, "selectDecorate " + furnitureDesc2.getSlot() + " error.");
                                    }
                                    if (furniture.getDeleted()) {
                                        miniHomeActionBtnComponent2 = editMiniHomeFragment3.actionBtnComponent;
                                        if (miniHomeActionBtnComponent2 != null) {
                                            miniHomeActionBtnComponent2.i();
                                        }
                                    } else {
                                        miniHomeActionBtnComponent = editMiniHomeFragment3.actionBtnComponent;
                                        if (miniHomeActionBtnComponent != null) {
                                            miniHomeActionBtnComponent.j(furniture);
                                        }
                                    }
                                    editMiniHomeFragment3.dj(furnitureDesc2.getSlot(), furniture);
                                    editMiniHomeFragment3.fj(furniture.getCondition(), 0);
                                }
                            }
                        }
                    };
                    Gi = editMiniHomeFragment2.Gi();
                    RelativeLayout relativeLayout = Gi.f398993s;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.previewLayout");
                    MiniHomeEditGuideComponent miniHomeEditGuideComponent = new MiniHomeEditGuideComponent(relativeLayout, furnitureDesc, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$getDecoratePositionAndShowOnScreen$showOnScreen$1$1$editGuideComponent$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(View image) {
                            ImageView imageView;
                            ImageView imageView2;
                            ConcurrentHashMap concurrentHashMap4;
                            Intrinsics.checkNotNullParameter(image, "image");
                            QLog.i("EditMiniHomeFragment", 1, "selectDecorate " + FurnitureDesc.this);
                            imageView = editMiniHomeFragment2.editFloorImage;
                            if (imageView != null) {
                                imageView.setSelected(false);
                            }
                            imageView2 = editMiniHomeFragment2.editWallImage;
                            if (imageView2 != null) {
                                imageView2.setSelected(false);
                            }
                            String slot = FurnitureDesc.this.getSlot();
                            if (slot != null) {
                                editMiniHomeFragment2.nj(slot, r46);
                            }
                            VideoReport.reportEvent("clck", image, null);
                            EditMiniHomeFragment editMiniHomeFragment3 = editMiniHomeFragment2;
                            concurrentHashMap4 = editMiniHomeFragment3.furnitureDescMapOnScreen;
                            editMiniHomeFragment3.sj((FurnitureDesc) concurrentHashMap4.get(FurnitureDesc.this.getSlot()));
                        }
                    });
                    String slot = furnitureDesc.getSlot();
                    if (slot != null) {
                        concurrentHashMap = editMiniHomeFragment2.editGuideOnScreen;
                        synchronized (concurrentHashMap) {
                            concurrentHashMap2 = editMiniHomeFragment2.editGuideOnScreen;
                            MiniHomeEditGuideComponent miniHomeEditGuideComponent2 = (MiniHomeEditGuideComponent) concurrentHashMap2.get(slot);
                            if (miniHomeEditGuideComponent2 != null) {
                                miniHomeEditGuideComponent2.e();
                            }
                            concurrentHashMap3 = editMiniHomeFragment2.editGuideOnScreen;
                            concurrentHashMap3.put(slot, miniHomeEditGuideComponent);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    arrayList.add(miniHomeEditGuideComponent);
                }
                EditMiniHomeFragment editMiniHomeFragment3 = editMiniHomeFragment;
                for (MiniHomeEditGuideComponent miniHomeEditGuideComponent3 : arrayList) {
                    miniHomeEditGuideComponent3.j();
                    editMiniHomeFragment3.Pi(miniHomeEditGuideComponent3.h());
                }
                ApngImage.playByTag(1010261);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y Ji() {
        return (y) this.miniHomeController.getValue();
    }

    private final MiniHomeViewModel Ki() {
        return (MiniHomeViewModel) this.miniHomeInfoViewModel.getValue();
    }

    private final aa Li() {
        return (aa) this.miniHomeReporter.getValue();
    }

    private final String Mi() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).generateXWConnectScheme("edit_mini_home", null, bb.f335811a.e(), true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] Ni(String jsonString) {
        Charset charset = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charset, "charset");
        byte[] bytes = jsonString.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                try {
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray;
                } finally {
                }
            } catch (Throwable unused) {
                QLog.e("EditMiniHomeFragment", 1, "gzipRoomJSONString failed.");
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(gZIPOutputStream, null);
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                return null;
            }
        } finally {
        }
    }

    private final void Oi(ImageView editFloorImage, ImageView editWallImage) {
        VideoReport.setElementId(editFloorImage, "em_zplan_floor_btn");
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(editFloorImage, exposurePolicy);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(editFloorImage, clickPolicy);
        VideoReport.setElementId(editWallImage, "em_zplan_wallpaper_btn");
        VideoReport.setElementExposePolicy(editWallImage, exposurePolicy);
        VideoReport.setElementClickPolicy(editWallImage, clickPolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pi(View image) {
        VideoReport.setElementId(image, "em_zplan_hand_btn");
        VideoReport.setElementExposePolicy(image, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(image, ClickPolicy.REPORT_NONE);
    }

    private final void Qi() {
        VideoReport.setElementId(Gi().f398977c, "em_zplan_back_btn");
        VideoReport.setElementExposePolicy(Gi().f398977c, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(Gi().f398977c, ClickPolicy.REPORT_NONE);
    }

    private final void Ri() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, getResources().getColor(R.color.qui_common_bg_middle_light)});
        View view = Gi().f398992r;
        view.setBackground(gradientDrawable);
        view.setVisibility(0);
        View view2 = Gi().f398996v.f399001b;
        view2.setBackground(gradientDrawable);
        view2.setVisibility(0);
    }

    private final void Si() {
        ConstraintLayout root = Gi().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        MiniHomeActionBtnComponent miniHomeActionBtnComponent = new MiniHomeActionBtnComponent(root, new Function3<View, MiniHomeActionBtnComponent.Companion.ACTION, FurnitureDesc, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$initMiniHomeActionImage$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes34.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f334255a;

                static {
                    int[] iArr = new int[MiniHomeActionBtnComponent.Companion.ACTION.values().length];
                    try {
                        iArr[MiniHomeActionBtnComponent.Companion.ACTION.DELETE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MiniHomeActionBtnComponent.Companion.ACTION.ROTATE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f334255a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, MiniHomeActionBtnComponent.Companion.ACTION action, FurnitureDesc furnitureDesc) {
                invoke2(view, action, furnitureDesc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View image, MiniHomeActionBtnComponent.Companion.ACTION action, final FurnitureDesc furnitureDesc) {
                y Ji;
                AtomicBoolean atomicBoolean;
                y Ji2;
                Intrinsics.checkNotNullParameter(image, "image");
                Intrinsics.checkNotNullParameter(action, "action");
                final EditMiniHomeFragment editMiniHomeFragment = EditMiniHomeFragment.this;
                QLog.i("EditMiniHomeFragment", 1, action + " click, " + furnitureDesc);
                if (furnitureDesc != null) {
                    String slot = furnitureDesc.getSlot();
                    if (slot == null || slot.length() == 0) {
                        return;
                    }
                    int i3 = a.f334255a[action.ordinal()];
                    if (i3 == 1) {
                        Ji = editMiniHomeFragment.Ji();
                        String slot2 = furnitureDesc.getSlot();
                        Intrinsics.checkNotNull(slot2);
                        Ji.d(slot2, new com.tencent.filament.zplan.scene.minihome.a() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$initMiniHomeActionImage$1$1$1
                            @Override // com.tencent.filament.zplan.scene.minihome.a
                            public void onDecorateInfoCallback(DecorateInfo decorateInfo) {
                                final FurnitureDesc furniture;
                                MiniHomeActionBtnComponent miniHomeActionBtnComponent2;
                                ConcurrentHashMap concurrentHashMap;
                                ConcurrentHashMap concurrentHashMap2;
                                MiniHomeEditGuideComponent miniHomeEditGuideComponent;
                                QLog.i("EditMiniHomeFragment", 1, "deleteDecorate " + FurnitureDesc.this.getSlot() + ", onDecorateInfoCallback " + decorateInfo);
                                if (decorateInfo != null) {
                                    final EditMiniHomeFragment editMiniHomeFragment2 = editMiniHomeFragment;
                                    final FurnitureDesc furnitureDesc2 = FurnitureDesc.this;
                                    if (decorateInfo.getSuccess() && (furniture = decorateInfo.getFurniture()) != null) {
                                        if (furniture.getError() == 0) {
                                            miniHomeActionBtnComponent2 = editMiniHomeFragment2.actionBtnComponent;
                                            if (miniHomeActionBtnComponent2 != null) {
                                                miniHomeActionBtnComponent2.i();
                                            }
                                            String slot3 = furnitureDesc2.getSlot();
                                            Intrinsics.checkNotNull(slot3);
                                            editMiniHomeFragment2.ti(slot3, null);
                                            concurrentHashMap = editMiniHomeFragment2.editGuideOnScreen;
                                            synchronized (concurrentHashMap) {
                                                concurrentHashMap2 = editMiniHomeFragment2.editGuideOnScreen;
                                                String slot4 = furnitureDesc2.getSlot();
                                                Intrinsics.checkNotNull(slot4);
                                                miniHomeEditGuideComponent = (MiniHomeEditGuideComponent) concurrentHashMap2.get(slot4);
                                            }
                                            if (miniHomeEditGuideComponent != null) {
                                                miniHomeEditGuideComponent.i();
                                            }
                                            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$initMiniHomeActionImage$1$1$1$onDecorateInfoCallback$1$3
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
                                                    ConcurrentHashMap concurrentHashMap3;
                                                    MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel;
                                                    MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel2;
                                                    ay Gi;
                                                    n55.a aVar = (n55.a) EditMiniHomeFragment.this.furnitureChoosing.getValue();
                                                    boolean z16 = false;
                                                    if (aVar != null && aVar.f418392a == furnitureDesc2.getId()) {
                                                        z16 = true;
                                                    }
                                                    if (z16) {
                                                        EditMiniHomeFragment.this.furnitureChoosing.setValue(null);
                                                    }
                                                    EditMiniHomeFragment.this.Aj("\u4fdd\u5b58");
                                                    concurrentHashMap3 = EditMiniHomeFragment.this.furnitureDescMapOnScreen;
                                                    String slot5 = furnitureDesc2.getSlot();
                                                    Intrinsics.checkNotNull(slot5);
                                                    concurrentHashMap3.put(slot5, furniture);
                                                    miniHomeEditDecorateListViewModel = EditMiniHomeFragment.this.viewModel;
                                                    if (miniHomeEditDecorateListViewModel != null) {
                                                        miniHomeEditDecorateListViewModel.L1();
                                                    }
                                                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(EditMiniHomeFragment.this);
                                                    EditMiniHomeFragment editMiniHomeFragment3 = EditMiniHomeFragment.this;
                                                    miniHomeEditDecorateListViewModel2 = editMiniHomeFragment3.viewModel;
                                                    editMiniHomeFragment3.zj(lifecycleScope, miniHomeEditDecorateListViewModel2 != null ? miniHomeEditDecorateListViewModel2.M1() : null);
                                                    Gi = EditMiniHomeFragment.this.Gi();
                                                    RecyclerView.Adapter adapter = Gi.f398994t.getAdapter();
                                                    if (adapter != null) {
                                                        adapter.notifyDataSetChanged();
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                        QLog.e("EditMiniHomeFragment", 1, "deleteDecorate error");
                                    }
                                }
                            }
                        });
                    } else if (i3 == 2) {
                        Ji2 = editMiniHomeFragment.Ji();
                        String slot3 = furnitureDesc.getSlot();
                        Intrinsics.checkNotNull(slot3);
                        Ji2.j(slot3, new IMiniHomeMessageCallback() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$initMiniHomeActionImage$1$1$2
                            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
                            public void onMiniHomeMessage(String dataJson) {
                                QLog.i("EditMiniHomeFragment", 1, "rotateDecorate " + FurnitureDesc.this + ".slot, onMiniHomeMessage " + dataJson);
                            }
                        });
                    }
                    atomicBoolean = editMiniHomeFragment.hasEdited;
                    atomicBoolean.set(true);
                }
            }
        });
        this.actionBtnComponent = miniHomeActionBtnComponent;
        miniHomeActionBtnComponent.i();
    }

    private final void Ti() {
        ImageView imageView = new ImageView(getContext());
        imageView.setVisibility(8);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setBackgroundResource(R.drawable.i4d);
        imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.i46));
        int b16 = com.tencent.sqshow.zootopia.utils.i.b(5);
        imageView.setPadding(0, b16, 0, b16);
        imageView.setOnClickListener(new EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener(this, "floor", new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$initMiniHomeEditImage$1$1
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
                ImageView imageView2;
                ImageView imageView3;
                EditMiniHomeFragment.tj(EditMiniHomeFragment.this, null, 1, null);
                imageView2 = EditMiniHomeFragment.this.editWallImage;
                if (imageView2 != null) {
                    imageView2.setSelected(false);
                }
                imageView3 = EditMiniHomeFragment.this.editFloorImage;
                VideoReport.reportEvent("clck", imageView3, null);
            }
        }));
        imageView.setId(View.generateViewId());
        this.editFloorImage = imageView;
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setVisibility(8);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setBackgroundResource(R.drawable.i4d);
        imageView2.setImageDrawable(imageView2.getResources().getDrawable(R.drawable.i47));
        int b17 = com.tencent.sqshow.zootopia.utils.i.b(5);
        imageView2.setPadding(0, b17, 0, b17);
        imageView2.setOnClickListener(new EditMiniHomeFragment$initMiniHomeEditImage$EditButtonClickListener(this, "wall", new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$initMiniHomeEditImage$2$1
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
                ImageView imageView3;
                ImageView imageView4;
                EditMiniHomeFragment.tj(EditMiniHomeFragment.this, null, 1, null);
                imageView3 = EditMiniHomeFragment.this.editFloorImage;
                if (imageView3 != null) {
                    imageView3.setSelected(false);
                }
                imageView4 = EditMiniHomeFragment.this.editWallImage;
                VideoReport.reportEvent("clck", imageView4, null);
            }
        }));
        imageView2.setId(View.generateViewId());
        this.editWallImage = imageView2;
        Gi().getRoot().addView(this.editWallImage);
        Gi().getRoot().addView(this.editFloorImage);
        ImageView imageView3 = this.editFloorImage;
        Intrinsics.checkNotNull(imageView3);
        ImageView imageView4 = this.editWallImage;
        Intrinsics.checkNotNull(imageView4);
        Oi(imageView3, imageView4);
        VideoReport.reportEvent("imp", this.editFloorImage, null);
        VideoReport.reportEvent("imp", this.editWallImage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ui() {
        QLog.i("EditMiniHomeFragment", 1, "onNetCheck");
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(EditMiniHomeFragment this$0, MiniHomeInfo miniHomeInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (miniHomeInfo == null) {
            return;
        }
        String roomDescJson = miniHomeInfo.getRoomDesc().getRoomDescJson();
        yj(this$0, null, 1, null);
        QLog.i("EditMiniHomeFragment", 1, "onCreate, roomJSON: " + roomDescJson);
        this$0.Ji().c(roomDescJson, new LoadRoomCallback(this$0, roomDescJson));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(EditMiniHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(EditMiniHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Yi(final EditMiniHomeFragment this$0, View it, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this$0.Ji().g((int) motionEvent.getX(), it.getHeight() - ((int) motionEvent.getY()), new IMiniHomeMessageCallback() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$9$1$1$1
            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
            public void onMiniHomeMessage(String dataJson) {
                DecorateMode decorateMode;
                r55.b bVar;
                if (dataJson == null || dataJson.length() == 0) {
                    return;
                }
                final String slot = new JSONObject(dataJson).optString("slot", "");
                Intrinsics.checkNotNullExpressionValue(slot, "slot");
                if (slot.length() == 0) {
                    QLog.i("EditMiniHomeFragment", 1, "select slot empty, return");
                    return;
                }
                if (Intrinsics.areEqual("MainAvatar", slot)) {
                    QLog.i("EditMiniHomeFragment", 1, "select avater, return");
                    return;
                }
                final EditMiniHomeFragment editMiniHomeFragment = EditMiniHomeFragment.this;
                com.tencent.filament.zplan.scene.minihome.a aVar = new com.tencent.filament.zplan.scene.minihome.a() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$9$1$1$1$onMiniHomeMessage$selectDecorateCallback$1
                    @Override // com.tencent.filament.zplan.scene.minihome.a
                    public void onDecorateInfoCallback(DecorateInfo decorateInfo) {
                        FurnitureDesc furniture;
                        DecorateMode decorateMode2;
                        MiniHomeActionBtnComponent miniHomeActionBtnComponent;
                        QLog.i("EditMiniHomeFragment", 1, "selectDecorate " + slot + ", onDecorateInfoCallback:" + decorateInfo);
                        if (decorateInfo != null) {
                            String str = slot;
                            final EditMiniHomeFragment editMiniHomeFragment2 = editMiniHomeFragment;
                            if (decorateInfo.getSuccess() && (furniture = decorateInfo.getFurniture()) != null) {
                                if (furniture.getError() != 0) {
                                    QLog.e("EditMiniHomeFragment", 1, "selectDecorate " + str + " error.");
                                }
                                decorateMode2 = editMiniHomeFragment2.decorateMode;
                                if (decorateMode2 == DecorateMode.SAMPLE_ROOM) {
                                    editMiniHomeFragment2.sj(furniture);
                                } else {
                                    miniHomeActionBtnComponent = editMiniHomeFragment2.actionBtnComponent;
                                    if (miniHomeActionBtnComponent != null) {
                                        miniHomeActionBtnComponent.j(furniture);
                                    }
                                }
                                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$9$1$1$1$onMiniHomeMessage$selectDecorateCallback$1$onDecorateInfoCallback$1$1
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
                                        ImageView imageView;
                                        ImageView imageView2;
                                        imageView = EditMiniHomeFragment.this.editFloorImage;
                                        if (imageView != null) {
                                            imageView.setSelected(false);
                                        }
                                        imageView2 = EditMiniHomeFragment.this.editWallImage;
                                        if (imageView2 == null) {
                                            return;
                                        }
                                        imageView2.setSelected(false);
                                    }
                                });
                                editMiniHomeFragment2.fj(furniture.getCondition(), 0);
                            }
                        }
                    }
                };
                decorateMode = EditMiniHomeFragment.this.decorateMode;
                if (decorateMode == DecorateMode.SAMPLE_ROOM) {
                    bVar = EditMiniHomeFragment.this.curRoomDesc;
                    if (!bVar.f430787j) {
                        return;
                    }
                }
                EditMiniHomeFragment.this.nj(slot, aVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zi(EditMiniHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.xi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aj() {
        Map mapOf;
        int goldCoin = this.currencyData.getGoldCoin();
        int i3 = this.curTotalPrice;
        if (goldCoin >= i3) {
            oj();
            return;
        }
        final int goldCoin2 = i3 - this.currencyData.getGoldCoin();
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY));
        VideoReport.reportEvent("ev_zplan_recharge_remind_pop_imp", mapOf);
        PayUtil payUtil = PayUtil.f335729a;
        Context context = Gi().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        payUtil.a(context, this.currencyData.getGoldCoin(), goldCoin2, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$processItemPay$1
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
                Map mapOf2;
                int i16;
                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_btn_type", Integer.valueOf(z16 ? 1 : 0)));
                VideoReport.reportEvent("ev_zplan_recharge_remind_pop_clck", mapOf2);
                if (z16) {
                    AvatarCommonOperateHelper avatarCommonOperateHelper = AvatarCommonOperateHelper.f371049a;
                    int i17 = goldCoin2;
                    final EditMiniHomeFragment editMiniHomeFragment = this;
                    avatarCommonOperateHelper.n(i17, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$processItemPay$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17) {
                            int i18;
                            if (z17) {
                                EditMiniHomeFragment.this.oj();
                                return;
                            }
                            QLog.i("EditMiniHomeFragment", 1, "cancel pay");
                            EditMiniHomeFragment editMiniHomeFragment2 = EditMiniHomeFragment.this;
                            i18 = editMiniHomeFragment2.curTotalPrice;
                            editMiniHomeFragment2.hj("clck", "", i18 > 0);
                        }
                    });
                    return;
                }
                QLog.i("EditMiniHomeFragment", 1, "choose not to pay");
                EditMiniHomeFragment editMiniHomeFragment2 = this;
                i16 = editMiniHomeFragment2.curTotalPrice;
                editMiniHomeFragment2.hj("clck", "", i16 > 0);
            }
        });
    }

    private final void bj(final String desc) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.minihome.n
            @Override // java.lang.Runnable
            public final void run() {
                EditMiniHomeFragment.cj(desc, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cj(String str, EditMiniHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("EditMiniHomeFragment", 1, "refreshCellSizeDesc:" + str);
        this$0.Gi().f398980f.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dj(final String slot, final FurnitureDesc furniture) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.minihome.m
            @Override // java.lang.Runnable
            public final void run() {
                EditMiniHomeFragment.ej(EditMiniHomeFragment.this, slot, furniture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ej(EditMiniHomeFragment this$0, String str, FurnitureDesc furnitureDesc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = (TextView) this$0.Gi().f398993s.findViewWithTag("debug_view");
        if (textView != null) {
            if (!INSTANCE.e()) {
                textView.setVisibility(4);
                return;
            }
            textView.setText("selectDecorateInfo: \nslot: " + str + ", \nID: " + (furnitureDesc != null ? Long.valueOf(furnitureDesc.getId()) : null) + ", \nsubState: " + (furnitureDesc != null ? Integer.valueOf(furnitureDesc.getSubState()) : null) + ", \ncondition: " + (furnitureDesc != null ? furnitureDesc.getCondition() : null));
            textView.setTextColor(Color.parseColor("#000080"));
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gj(String slot, boolean success, ServerFurnitureDesc serverFurnitureDesc) {
        MiniHomeReplaceEvent miniHomeReplaceEvent;
        HashMap<String, String> hashMapOf;
        if (Intrinsics.areEqual(slot, "floor")) {
            miniHomeReplaceEvent = MiniHomeReplaceEvent.REPLACE_FLOOR;
        } else if (Intrinsics.areEqual(slot, "wall")) {
            miniHomeReplaceEvent = MiniHomeReplaceEvent.REPLACE_WALL;
        } else {
            miniHomeReplaceEvent = MiniHomeReplaceEvent.REPLACE_DECORATE;
        }
        aa Li = Li();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("id", String.valueOf(serverFurnitureDesc.getId())), TuplesKt.to("subState", String.valueOf(serverFurnitureDesc.getSubState())));
        Li.e(miniHomeReplaceEvent, success, hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hj(String eventKey, String reportJsonString, boolean isBuy) {
        HashMap hashMapOf;
        if (Intrinsics.areEqual(reportJsonString, "")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("add", new JSONObject());
            jSONObject.put("del", new JSONObject());
            reportJsonString = jSONObject.toString();
        }
        Intrinsics.checkNotNullExpressionValue(reportJsonString, "if (reportJsonString == \u2026eportJsonString\n        }");
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("zplan_furniture_delta", reportJsonString);
        pairArr[1] = TuplesKt.to("zplan_item_price", Integer.valueOf(this.curTotalPrice));
        pairArr[2] = TuplesKt.to("zplan_need_buy", Integer.valueOf(isBuy ? 1 : 0));
        r55.a aVar = this.curRoomDesc.f430785h;
        String str = aVar != null ? aVar.f430773a : null;
        pairArr[3] = TuplesKt.to("zplan_model_room_id", str != null ? str : "");
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (this.decorateMode == DecorateMode.FURNITURE) {
            VideoReport.setElementId(Gi().f398988n, "em_zplan_complete_btn");
        } else {
            VideoReport.setElementId(Gi().f398988n, "em_zplan_model_room_complete");
        }
        VideoReport.setElementExposePolicy(Gi().f398988n, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(Gi().f398988n, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(eventKey, Gi().f398988n, hashMapOf);
    }

    private final void ij() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(Gi().getRoot(), "pg_zplan_mini_xiaowo_edit");
        VideoReport.setPageParams(Gi().getRoot(), new PageParams(hashMap));
        VideoReport.setPageReportPolicy(Gi().getRoot(), PageReportPolicy.REPORT_ALL);
        VideoReport.reportEvent("pgin", Gi().getRoot(), null);
    }

    private final void jj() {
        VideoReport.reportEvent("pgout", Gi().getRoot(), null);
    }

    private final void kj() {
        Ci(this, this.curRoomDesc, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lj(final boolean isBuy) {
        Ji().n(false, new IMiniHomeMessageCallback() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$saveRoom$1
            /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
            
                r4 = r3.this$0.Ni(r4);
             */
            @Override // com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMiniHomeMessage(String dataJson) {
                byte[] Ni;
                QLog.i("EditMiniHomeFragment", 1, "getRoomConfig diff, onMiniHomeLoadResult " + dataJson);
                if (dataJson == null || Ni == null) {
                    return;
                }
                EditMiniHomeFragment.this.Di(Ni, isBuy);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void nj(String slot, com.tencent.filament.zplan.scene.minihome.a callback) {
        if (Intrinsics.areEqual(this.selectedSlot, slot)) {
            QLog.i("EditMiniHomeFragment", 1, "selectDecorateAndRefreshView already selectedSlot:" + this.selectedSlot + ", skip!!");
            return;
        }
        this.selectedSlot = slot;
        Ji().m();
        Ji().k(slot, callback);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$selectDecorateAndRefreshView$1
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
                MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel;
                ay Gi;
                miniHomeEditDecorateListViewModel = EditMiniHomeFragment.this.viewModel;
                if (miniHomeEditDecorateListViewModel != null) {
                    miniHomeEditDecorateListViewModel.Q1();
                }
                Gi = EditMiniHomeFragment.this.Gi();
                RecyclerView.Adapter adapter = Gi.f398994t.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oj() {
        List asList;
        List list;
        if (this.decorateMode == DecorateMode.FURNITURE) {
            list = this.curSelectedFurnitureMap.values();
            Intrinsics.checkNotNullExpressionValue(list, "{\n            curSelecte\u2026itureMap.values\n        }");
        } else {
            n55.a[] aVarArr = this.curRoomDesc.f430794q;
            Intrinsics.checkNotNullExpressionValue(aVarArr, "curRoomDesc.furnitures");
            asList = ArraysKt___ArraysJvmKt.asList(aVarArr);
            list = asList;
        }
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n55.a aVar : list) {
            if (aVar != null && !aVar.f418398g) {
                arrayList.add(aVar.f418392a + "_" + aVar.f418401j);
            }
        }
        bw4.a aVar2 = new bw4.a();
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar2.f29337c = (String[]) array;
        aVar2.f29336b = "3";
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$sendBuyReqToServer$1
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
                Dialog dialog;
                dialog = EditMiniHomeFragment.this.loadingDialog;
                if (dialog != null) {
                    dialog.show();
                }
            }
        });
        va4.a.d(va4.a.f441274a, aVar2, new com.tencent.mobileqq.zootopia.api.e<bw4.c>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$sendBuyReqToServer$2
            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(bw4.c result) {
                DecorateMode decorateMode;
                HashMap hashMapOf;
                Intrinsics.checkNotNullParameter(result, "result");
                final EditMiniHomeFragment editMiniHomeFragment = EditMiniHomeFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$sendBuyReqToServer$2$onResultSuccess$1
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
                        Dialog dialog;
                        dialog = EditMiniHomeFragment.this.loadingDialog;
                        if (dialog != null) {
                            dialog.hide();
                        }
                    }
                });
                bw4.b[] bVarArr = result.f29343b;
                Intrinsics.checkNotNullExpressionValue(bVarArr, "result.buyRets");
                for (bw4.b bVar : bVarArr) {
                    if (bVar.f29340b != 0) {
                        QQToastUtil.showQQToastInUiThread(1, "\u672a\u8d2d\u4e70\u5b8c\u6210\uff0c\u8bf7\u7ee7\u7eed\u8d2d\u4e70");
                        QLog.e("EditMiniHomeFragment", 1, "\u90e8\u5206\u8d2d\u4e70\u5931\u8d25 " + bVar.f29339a + " " + bVar.f29340b + " " + bVar.f29341c);
                        return;
                    }
                }
                Pair[] pairArr = new Pair[2];
                decorateMode = EditMiniHomeFragment.this.decorateMode;
                pairArr[0] = TuplesKt.to("zplan_buy_type", Integer.valueOf(decorateMode == DecorateMode.SAMPLE_ROOM ? 1 : 2));
                pairArr[1] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
                VideoReport.reportEvent("ev_zplan_model_room_buy_suc", hashMapOf);
                QQToastUtil.showQQToastInUiThread(2, "\u8d2d\u4e70\u6210\u529f");
                EditMiniHomeFragment.this.lj(true);
                EditMiniHomeFragment.this.wj();
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                int i3;
                final EditMiniHomeFragment editMiniHomeFragment = EditMiniHomeFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$sendBuyReqToServer$2$onResultFailure$1
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
                        Dialog dialog;
                        dialog = EditMiniHomeFragment.this.loadingDialog;
                        if (dialog != null) {
                            dialog.hide();
                        }
                        QQToastUtil.showQQToastInUiThread(1, "\u8d2d\u4e70\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
                    }
                });
                EditMiniHomeFragment editMiniHomeFragment2 = EditMiniHomeFragment.this;
                i3 = editMiniHomeFragment2.curTotalPrice;
                editMiniHomeFragment2.hj("clck", "", i3 > 0);
                QLog.e("EditMiniHomeFragment", 1, "sendBuyReqToServer failed errorCode:" + error + " message:" + message);
            }
        }, 0, 4, null);
    }

    private final void pj() {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u88c5\u4fee\u5c1a\u672a\u4fdd\u5b58\uff0c\u662f\u5426\u79bb\u5f00\uff1f", "\u7ee7\u7eed\u88c5\u4fee", "\u79bb\u5f00", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                EditMiniHomeFragment.qj(EditMiniHomeFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                EditMiniHomeFragment.rj(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qj(EditMiniHomeFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        if (i3 != 0) {
            this$0.hasEdited.set(false);
            this$0.kj();
            this$0.uj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rj(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sj(final FurnitureDesc furniture) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$switchToFurnitureMode$1
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
                DecorateMode decorateMode;
                MiniHomeActionBtnComponent miniHomeActionBtnComponent;
                ay Gi;
                ay Gi2;
                ay Gi3;
                ImageView imageView;
                ImageView imageView2;
                ay Gi4;
                ay Gi5;
                ConcurrentHashMap concurrentHashMap;
                y Ji;
                decorateMode = EditMiniHomeFragment.this.decorateMode;
                if (decorateMode == DecorateMode.SAMPLE_ROOM) {
                    concurrentHashMap = EditMiniHomeFragment.this.editGuideOnScreen;
                    Iterator it = concurrentHashMap.values().iterator();
                    while (it.hasNext()) {
                        ((MiniHomeEditGuideComponent) it.next()).e();
                    }
                    Ji = EditMiniHomeFragment.this.Ji();
                    Ji.o(MiniHomeScene.Companion.CAMERAMODE.EDIT);
                    final EditMiniHomeFragment editMiniHomeFragment = EditMiniHomeFragment.this;
                    CommonExKt.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$switchToFurnitureMode$1.1
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
                            EditMiniHomeFragment.this.Hi();
                        }
                    }, 500L);
                    EditMiniHomeFragment.this.decorateMode = DecorateMode.FURNITURE;
                    EditMiniHomeFragment.this.curTotalNum = 0;
                    EditMiniHomeFragment.this.curTotalPrice = 0;
                    EditMiniHomeFragment.this.Aj("\u4fdd\u5b58");
                }
                EditMiniHomeFragment.this.decorateMode = DecorateMode.FURNITURE;
                miniHomeActionBtnComponent = EditMiniHomeFragment.this.actionBtnComponent;
                if (miniHomeActionBtnComponent != null) {
                    miniHomeActionBtnComponent.j(furniture);
                }
                Gi = EditMiniHomeFragment.this.Gi();
                Gi.f398989o.setVisibility(0);
                Gi2 = EditMiniHomeFragment.this.Gi();
                Gi2.f398996v.f399003d.setVisibility(8);
                Gi3 = EditMiniHomeFragment.this.Gi();
                Gi3.f398999y.setText("\u624b\u52a8\u88c5\u4fee");
                imageView = EditMiniHomeFragment.this.editFloorImage;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                imageView2 = EditMiniHomeFragment.this.editWallImage;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                Gi4 = EditMiniHomeFragment.this.Gi();
                Gi4.f398977c.setVisibility(8);
                Gi5 = EditMiniHomeFragment.this.Gi();
                Gi5.f398978d.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uj() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$switchToSampleRoomMode$1
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
                DecorateMode decorateMode;
                MiniHomeActionBtnComponent miniHomeActionBtnComponent;
                ay Gi;
                ay Gi2;
                ay Gi3;
                ay Gi4;
                ay Gi5;
                ay Gi6;
                ay Gi7;
                ay Gi8;
                ImageView imageView;
                ImageView imageView2;
                ConcurrentHashMap concurrentHashMap;
                y Ji;
                y Ji2;
                ConcurrentHashMap concurrentHashMap2;
                decorateMode = EditMiniHomeFragment.this.decorateMode;
                if (decorateMode == DecorateMode.FURNITURE) {
                    concurrentHashMap = EditMiniHomeFragment.this.editGuideOnScreen;
                    Iterator it = concurrentHashMap.values().iterator();
                    while (it.hasNext()) {
                        ((MiniHomeEditGuideComponent) it.next()).e();
                    }
                    EditMiniHomeFragment.this.selectedSlot = "";
                    Ji = EditMiniHomeFragment.this.Ji();
                    Ji.m();
                    Ji2 = EditMiniHomeFragment.this.Ji();
                    Ji2.o(MiniHomeScene.Companion.CAMERAMODE.NORMAL);
                    concurrentHashMap2 = EditMiniHomeFragment.this.curSelectedFurnitureMap;
                    concurrentHashMap2.clear();
                    EditMiniHomeFragment.this.curTotalNum = 0;
                    EditMiniHomeFragment.this.curTotalPrice = 0;
                    final EditMiniHomeFragment editMiniHomeFragment = EditMiniHomeFragment.this;
                    CommonExKt.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$switchToSampleRoomMode$1.1
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
                            EditMiniHomeFragment.this.Hi();
                        }
                    }, 500L);
                    EditMiniHomeFragment.this.decorateMode = DecorateMode.SAMPLE_ROOM;
                    EditMiniHomeFragment.this.Aj("\u5b8c\u6210");
                }
                EditMiniHomeFragment.this.decorateMode = DecorateMode.SAMPLE_ROOM;
                miniHomeActionBtnComponent = EditMiniHomeFragment.this.actionBtnComponent;
                if (miniHomeActionBtnComponent != null) {
                    miniHomeActionBtnComponent.i();
                }
                Gi = EditMiniHomeFragment.this.Gi();
                Gi.f398989o.setVisibility(8);
                Gi2 = EditMiniHomeFragment.this.Gi();
                Gi2.f398996v.f399003d.setVisibility(0);
                Gi3 = EditMiniHomeFragment.this.Gi();
                Gi3.f398996v.f399004e.setText("\u9009\u62e9\u8ff7\u4f60\u7a9d");
                Gi4 = EditMiniHomeFragment.this.Gi();
                Gi4.f398996v.f399004e.setGravity(19);
                Gi5 = EditMiniHomeFragment.this.Gi();
                Gi5.f398999y.setText("\u88c5\u4fee\u8ff7\u4f60\u7a9d");
                Gi6 = EditMiniHomeFragment.this.Gi();
                Gi6.f398976b.setVisibility(8);
                Gi7 = EditMiniHomeFragment.this.Gi();
                Gi7.f398978d.setVisibility(8);
                Gi8 = EditMiniHomeFragment.this.Gi();
                Gi8.f398977c.setVisibility(0);
                imageView = EditMiniHomeFragment.this.editFloorImage;
                if (imageView != null) {
                    imageView.setSelected(false);
                }
                imageView2 = EditMiniHomeFragment.this.editWallImage;
                if (imageView2 == null) {
                    return;
                }
                imageView2.setSelected(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vj(com.tencent.sqshow.zootopia.data.f result) {
        this.currencyData = result;
        Gi().f398982h.h(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wj() {
        yb4.e.h(yb4.e.f450058a, "request_immediately", this.updateCurrencyDataCallback, 0, 4, null);
    }

    private final void xi() {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this), "zplan_EditMiniHomeFragment_saveEditedRoom", null, null, null, new EditMiniHomeFragment$doOnFinish$1(this, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xj(ao desc) {
        Pair pair;
        String str;
        String hash;
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            return;
        }
        if (desc == null) {
            ao saveRoomDesc = ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getSaveRoomDesc(e16);
            String str2 = "";
            if (saveRoomDesc == null || (str = saveRoomDesc.getRoomDescJson()) == null) {
                str = "";
            }
            if (saveRoomDesc != null && (hash = saveRoomDesc.getHash()) != null) {
                str2 = hash;
            }
            pair = new Pair(str, str2);
        } else {
            pair = new Pair(desc.getRoomDescJson(), desc.getHash());
        }
        String str3 = (String) pair.component1();
        String str4 = (String) pair.component2();
        r55.b bVar = new r55.b();
        r55.a aVar = new r55.a();
        byte[] bytes = str3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        aVar.f430776d = bytes;
        aVar.f430773a = str4;
        bVar.f430787j = true;
        bVar.f430785h = aVar;
        this.curRoomDesc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yi(final n55.a furniture) {
        final ServerFurnitureDesc a16 = ServerFurnitureDesc.INSTANCE.a(furniture.f418399h);
        if (a16 == null) {
            return;
        }
        QLog.i("EditMiniHomeFragment", 1, "choosing " + a16);
        ti(this.selectedSlot, furniture);
        this.hasEdited.set(true);
        Aj("\u4fdd\u5b58");
        Gi().f398976b.setVisibility(furniture.f418400i == 2 ? 0 : 8);
        final String str = this.selectedSlot;
        com.tencent.filament.zplan.scene.minihome.a aVar = new com.tencent.filament.zplan.scene.minihome.a() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doOnFurnitureSelected$callback$1
            @Override // com.tencent.filament.zplan.scene.minihome.a
            public void onDecorateInfoCallback(DecorateInfo decorateInfo) {
                FurnitureDesc furniture2;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                MiniHomeEditGuideComponent miniHomeEditGuideComponent;
                MiniHomeActionBtnComponent miniHomeActionBtnComponent;
                QLog.i("EditMiniHomeFragment", 1, "replaceDecorate " + ServerFurnitureDesc.this + ", callback: " + decorateInfo);
                if (decorateInfo != null) {
                    EditMiniHomeFragment editMiniHomeFragment = this;
                    String str2 = str;
                    ServerFurnitureDesc serverFurnitureDesc = ServerFurnitureDesc.this;
                    n55.a aVar2 = furniture;
                    editMiniHomeFragment.gj(str2, decorateInfo.getSuccess(), serverFurnitureDesc);
                    if (!decorateInfo.getSuccess() || (furniture2 = decorateInfo.getFurniture()) == null) {
                        return;
                    }
                    concurrentHashMap = editMiniHomeFragment.furnitureDescMapOnScreen;
                    concurrentHashMap.put(str2, furniture2);
                    concurrentHashMap2 = editMiniHomeFragment.editGuideOnScreen;
                    synchronized (concurrentHashMap2) {
                        concurrentHashMap3 = editMiniHomeFragment.editGuideOnScreen;
                        miniHomeEditGuideComponent = (MiniHomeEditGuideComponent) concurrentHashMap3.get(str2);
                    }
                    if (miniHomeEditGuideComponent != null) {
                        miniHomeEditGuideComponent.k(furniture2.getX(), furniture2.getY());
                        miniHomeEditGuideComponent.l(aVar2.f418398g, aVar2.f418396e, aVar2.f418397f);
                    }
                    miniHomeActionBtnComponent = editMiniHomeFragment.actionBtnComponent;
                    if (miniHomeActionBtnComponent != null) {
                        miniHomeActionBtnComponent.j(furniture2);
                    }
                }
            }
        };
        y Ji = Ji();
        String str2 = furniture.f418399h;
        Intrinsics.checkNotNullExpressionValue(str2, "furniture.furnitureJson");
        Ji.i(str, str2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zj(LifecycleCoroutineScope scope, StateFlow<? extends Pair<Integer, ? extends List<n55.a>>> source) {
        CorountineFunKt.e(scope, "ZPlan_EditMiniHomeFragment_collect", null, null, null, new EditMiniHomeFragment$updateFurnitureTab$1(source, this, null), 14, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        VideoReport.reportEvent("clck", Gi().f398977c, null);
        if (this.decorateMode == DecorateMode.SAMPLE_ROOM) {
            if (this.editHomeSource == EditMiniHomeSource.MINI_CONNECT && ZPlanQQMC.INSTANCE.destroyMiniConnectWhenJumpOut()) {
                String Mi = Mi();
                if (Mi.length() > 0) {
                    IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    iZPlanApi.launchScheme(requireContext, Mi);
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return false;
        }
        if (this.hasEdited.get()) {
            pj();
        } else {
            uj();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        EditMiniHomeSource editMiniHomeSource;
        String name;
        Intent intent;
        Bundle extras;
        super.onCreate(savedInstanceState);
        try {
            FragmentActivity activity = getActivity();
            if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null || (name = extras.getString("source")) == null) {
                name = EditMiniHomeSource.UNKNOWN.name();
            }
            Intrinsics.checkNotNullExpressionValue(name, "activity?.intent?.extras\u2026niHomeSource.UNKNOWN.name");
            editMiniHomeSource = EditMiniHomeSource.valueOf(name);
        } catch (Exception unused) {
            editMiniHomeSource = EditMiniHomeSource.UNKNOWN;
        }
        this.editHomeSource = editMiniHomeSource;
        Ki().O1().observe(this, new Observer() { // from class: com.tencent.mobileqq.zplan.minihome.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditMiniHomeFragment.Vi(EditMiniHomeFragment.this, (MiniHomeInfo) obj);
            }
        });
        Ji().create();
        Ji().createView();
        Ji().f();
        Ji().l();
        String e16 = bb.f335811a.e();
        if (e16 != null) {
            MiniHomeViewModel.N1(Ki(), e16, LifecycleOwnerKt.getLifecycleScope(this), null, 4, null);
        }
        ij();
        Qi();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.e("EditMiniHomeFragment", 1, "onCreateView");
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel = (MiniHomeEditDecorateListViewModel) new ViewModelProvider(this).get(MiniHomeEditDecorateListViewModel.class);
        miniHomeEditDecorateListViewModel.S1(new Function1<List<? extends n55.a>, List<? extends n55.a>>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<? extends n55.a> invoke(List<? extends n55.a> list) {
                return invoke2((List<n55.a>) list);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<n55.a> invoke2(List<n55.a> origin) {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                String str;
                List<n55.a> c16;
                Intrinsics.checkNotNullParameter(origin, "origin");
                concurrentHashMap = EditMiniHomeFragment.this.furnitureDescMapOnScreen;
                Collection values = concurrentHashMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "furnitureDescMapOnScreen.values");
                concurrentHashMap2 = EditMiniHomeFragment.this.furnitureDescMapOnScreen;
                str = EditMiniHomeFragment.this.selectedSlot;
                c16 = EditMiniHomeFragment.INSTANCE.c(origin, values, (FurnitureDesc) concurrentHashMap2.get(str));
                return c16;
            }
        });
        StateFlow<? extends Pair<Integer, ? extends List<n55.a>>> M1 = miniHomeEditDecorateListViewModel.M1();
        miniHomeEditDecorateListViewModel.Q1();
        this.viewModel = miniHomeEditDecorateListViewModel;
        LinearLayout linearLayout = Gi().f398987m;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(linearLayout.getContext());
        builder.setImageType(16);
        builder.setTitle("\u66f4\u591a\u5bb6\u5177\u5373\u5c06\u4e0a\u7ebf");
        builder.setHalfScreenState(true);
        linearLayout.addView(builder.build(), layoutParams);
        Gi().f398996v.f399002c.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        MutableStateFlow<r55.b[]> Fi = Fi(lifecycleScope);
        MiniHomeSceneEnum miniHomeSceneEnum = MiniHomeSceneEnum.SCENE_EDIT;
        Context context = Gi().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        com.tencent.mobileqq.zplan.minihome.view.h hVar = new com.tencent.mobileqq.zplan.minihome.view.h(miniHomeSceneEnum, Fi, new MiniHomeSampleOutlineView(context, null, 0, 6, null), com.tencent.sqshow.zootopia.utils.i.b(83), com.tencent.sqshow.zootopia.utils.i.b(95), MiniHomeSampleType.BUY, new Function1<r55.b, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$sampleRoomAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(r55.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(r55.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                EditMiniHomeFragment.this.sampleRoomChoosing.tryEmit(it);
            }
        });
        Gi().f398996v.f399002c.setAdapter(hVar);
        CorountineFunKt.e(lifecycleScope, "zplan_EditMiniHomeFragment_\u66f4\u65b0\u6837\u677f\u95f4\u9762\u677f", null, null, null, new EditMiniHomeFragment$onCreateView$3(Fi, hVar, null), 14, null);
        this.sampleRoomSource = Fi;
        RecyclerView recyclerView = Gi().f398994t;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3, 1, false));
        recyclerView.setItemAnimator(new com.tencent.mobileqq.zplan.minihome.view.j());
        recyclerView.setAdapter(new af(lifecycleScope, new Function1<n55.a, Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(n55.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(n55.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                EditMiniHomeFragment.this.furnitureChoosing.tryEmit(it);
            }
        }));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$onCreateView$4$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                ay Gi;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (newState == 0) {
                    Gi = EditMiniHomeFragment.this.Gi();
                    if (Gi.f398994t.canScrollVertically(1)) {
                        return;
                    }
                    QLog.i("EditMiniHomeFragment", 1, "onScrollStateChanged try requestNextPage");
                    CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(EditMiniHomeFragment.this), "EditMiniHomeFragment_requestNextPage", null, null, null, new EditMiniHomeFragment$onCreateView$4$2$onScrollStateChanged$1(EditMiniHomeFragment.this, null), 14, null);
                }
            }
        });
        MiniHomeEditBuyAndSaveButton miniHomeEditBuyAndSaveButton = Gi().f398988n;
        miniHomeEditBuyAndSaveButton.setOutlineProvider(new ap(com.tencent.sqshow.zootopia.utils.i.e(4)));
        miniHomeEditBuyAndSaveButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditMiniHomeFragment.Zi(EditMiniHomeFragment.this, view);
            }
        });
        ImageView imageView = Gi().f398977c;
        imageView.setBackground(AppCompatResources.getDrawable(Gi().getRoot().getContext(), R.drawable.qui_chevron_left_icon_white));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditMiniHomeFragment.Wi(EditMiniHomeFragment.this, view);
            }
        });
        Gi().f398978d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditMiniHomeFragment.Xi(EditMiniHomeFragment.this, view);
            }
        });
        Gi().f398997w.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext());
        View view = Gi().f398991q;
        view.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, view.getResources().getColor(R.color.qui_common_bg_bottom_standard)}));
        view.getLayoutParams().height = (int) (view.getContext().getResources().getDisplayMetrics().heightPixels * 0.1005f);
        view.setY(view.getContext().getResources().getDisplayMetrics().heightPixels * 0.4f);
        view.setFocusable(false);
        view.setClickable(false);
        view.setVisibility(0);
        Ri();
        RelativeLayout relativeLayout = Gi().f398993s;
        relativeLayout.getLayoutParams().height = (int) (relativeLayout.getContext().getResources().getDisplayMetrics().heightPixels * 0.5f);
        QLog.e("EditMiniHomeFragment", 1, "before addView");
        final View view2 = Ji().getView();
        this.textureView = view2;
        if (view2 != null) {
            relativeLayout.addView(view2, new RelativeLayout.LayoutParams(-1, -1));
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.zplan.minihome.j
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean Yi;
                    Yi = EditMiniHomeFragment.Yi(EditMiniHomeFragment.this, view2, view3, motionEvent);
                    return Yi;
                }
            });
        }
        QLog.e("EditMiniHomeFragment", 1, "after addview");
        Ti();
        Si();
        zj(lifecycleScope, M1);
        if (this.decorateMode == DecorateMode.FURNITURE) {
            Gi().f398996v.f399003d.setVisibility(8);
        } else {
            Gi().f398989o.setVisibility(8);
            MiniHomeActionBtnComponent miniHomeActionBtnComponent = this.actionBtnComponent;
            if (miniHomeActionBtnComponent != null) {
                miniHomeActionBtnComponent.i();
            }
        }
        ViewGroup.LayoutParams layoutParams2 = Gi().f398979e.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams2)).topMargin = (int) (Gi().getRoot().getContext().getResources().getDisplayMetrics().heightPixels * 0.47f);
        wj();
        Gi().f398982h.setPaySuccessCallback(this.updateCurrencyDataCallback);
        this.loadingDialog = LoadingUtil.showOnlyLoadingImageDialog(getContext(), 1, false);
        uj();
        VideoReport.reportEvent("imp", Gi().f398977c, null);
        ConstraintLayout root = Gi().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MiniHomeActionBtnComponent miniHomeActionBtnComponent = this.actionBtnComponent;
        if (miniHomeActionBtnComponent != null) {
            miniHomeActionBtnComponent.i();
        }
        this.actionBtnComponent = null;
        Ji().destroy();
        ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).releaseMiniHomeController();
        jj();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Ji().q();
        View view = this.textureView;
        if (view != null) {
            view.setOnTouchListener(null);
        }
        this.textureView = null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Ji().pause();
        ApngImage.pauseByTag(1010261);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Ji().resume();
        wj();
        ApngImage.playByTag(1010261);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        MiniHomeActionBtnComponent miniHomeActionBtnComponent;
        View h16;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int i3 = (int) (Gi().getRoot().getContext().getResources().getDisplayMetrics().heightPixels * 0.42f);
        int a16 = com.tencent.sqshow.zootopia.utils.i.a(44.0f);
        ConstraintSet constraintSet = new ConstraintSet();
        MiniHomeActionBtnComponent miniHomeActionBtnComponent2 = this.actionBtnComponent;
        if (miniHomeActionBtnComponent2 != null && (h16 = miniHomeActionBtnComponent2.h()) != null) {
            constraintSet.constrainWidth(h16.getId(), com.tencent.sqshow.zootopia.utils.i.a(98.0f));
            constraintSet.constrainHeight(h16.getId(), com.tencent.sqshow.zootopia.utils.i.a(44.0f));
            constraintSet.connect(h16.getId(), 2, 0, 2, com.tencent.sqshow.zootopia.utils.i.b(16));
            constraintSet.connect(h16.getId(), 3, 0, 3, i3);
        }
        ImageView imageView = this.editWallImage;
        if (imageView != null) {
            constraintSet.constrainWidth(imageView.getId(), a16);
            constraintSet.constrainHeight(imageView.getId(), a16);
            constraintSet.connect(imageView.getId(), 1, 0, 1, com.tencent.sqshow.zootopia.utils.i.b(16));
            constraintSet.connect(imageView.getId(), 3, 0, 3, i3);
        }
        ImageView imageView2 = this.editFloorImage;
        if (imageView2 != null) {
            constraintSet.constrainWidth(imageView2.getId(), a16);
            constraintSet.constrainHeight(imageView2.getId(), a16);
            int id5 = imageView2.getId();
            ImageView imageView3 = this.editWallImage;
            Intrinsics.checkNotNull(imageView3);
            constraintSet.connect(id5, 1, imageView3.getId(), 2, com.tencent.sqshow.zootopia.utils.i.b(12));
            constraintSet.connect(imageView2.getId(), 3, 0, 3, i3);
        }
        constraintSet.applyTo(Gi().getRoot());
        if (this.decorateMode != DecorateMode.SAMPLE_ROOM || (miniHomeActionBtnComponent = this.actionBtnComponent) == null) {
            return;
        }
        miniHomeActionBtnComponent.i();
    }

    public final void zi(String dataJson, boolean showGuide) {
        QLog.i("EditMiniHomeFragment", 1, "doOnRoomLoaded, dataJson: " + dataJson);
        this.curSelectedFurnitureMap.clear();
        if (showGuide) {
            Hi();
        }
        final int i3 = showGuide ? 0 : 8;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$doOnRoomLoaded$1
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
                ImageView imageView;
                ImageView imageView2;
                imageView = EditMiniHomeFragment.this.editFloorImage;
                if (imageView != null) {
                    imageView.setVisibility(i3);
                }
                imageView2 = EditMiniHomeFragment.this.editWallImage;
                if (imageView2 == null) {
                    return;
                }
                imageView2.setVisibility(i3);
            }
        });
    }

    private final MutableStateFlow<r55.b[]> Fi(CoroutineScope scope) {
        r55.b bVar = new r55.b();
        bVar.f430778a = "\u52a0\u8f7d\u4e2d";
        bVar.f430783f = "#EAEAEA";
        bVar.f430796s = true;
        bVar.f430787j = true;
        bVar.f430795r = false;
        Unit unit = Unit.INSTANCE;
        MutableStateFlow<r55.b[]> MutableStateFlow = StateFlowKt.MutableStateFlow(new r55.b[]{bVar});
        CorountineFunKt.e(scope, "zplan_CreateMiniHomeFragment_\u62c9\u53d6\u521b\u7a9d", null, null, null, new EditMiniHomeFragment$generateSource$1(MutableStateFlow, null), 14, null);
        return MutableStateFlow;
    }

    private final void ui() {
        Pair pair;
        this.curTotalPrice = 0;
        this.curTotalNum = 0;
        n55.a[] aVarArr = this.curRoomDesc.f430794q;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "curRoomDesc.furnitures");
        for (n55.a aVar : aVarArr) {
            if (aVar != null && !aVar.f418398g) {
                pair = new Pair(Integer.valueOf(aVar.f418396e), 1);
            } else {
                pair = new Pair(0, 0);
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            this.curTotalPrice += intValue;
            this.curTotalNum += intValue2;
        }
    }

    public EditMiniHomeFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<y>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$miniHomeController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
            
                if (r0 == null) goto L13;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
            
                if (r2 == null) goto L27;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
            
                r1 = r2;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
            
                r2 = (com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper.class);
                r3 = com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum.SCENE_EDIT;
                r0 = r2.getMiniHomeController(r1, r0, r3);
                r0.h(r3);
                r0.e(com.tencent.mobileqq.utils.QQTheme.isNowThemeIsNight());
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
            
                return r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
            
                if (r2 == null) goto L31;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final y invoke() {
                String e16;
                String e17;
                Intent intent;
                Bundle extras;
                Intent intent2;
                Bundle extras2;
                FragmentActivity activity = EditMiniHomeFragment.this.getActivity();
                String str = "";
                if (activity != null && (intent2 = activity.getIntent()) != null && (extras2 = intent2.getExtras()) != null) {
                    String e18 = bb.f335811a.e();
                    if (e18 == null) {
                        e18 = "";
                    }
                    e16 = extras2.getString("uniqueKey", e18);
                }
                e16 = bb.f335811a.e();
                if (e16 == null) {
                    e16 = "";
                }
                FragmentActivity activity2 = EditMiniHomeFragment.this.getActivity();
                if (activity2 != null && (intent = activity2.getIntent()) != null && (extras = intent.getExtras()) != null) {
                    String e19 = bb.f335811a.e();
                    if (e19 == null) {
                        e19 = "";
                    }
                    e17 = extras.getString("uin", e19);
                }
                e17 = bb.f335811a.e();
            }
        });
        this.miniHomeController = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ay>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ay invoke() {
                return ay.g(LayoutInflater.from(EditMiniHomeFragment.this.getContext()));
            }
        });
        this.binding = lazy2;
        this.furnitureChoosing = StateFlowKt.MutableStateFlow(null);
        this.sampleRoomChoosing = StateFlowKt.MutableStateFlow(null);
        this.hasEdited = new AtomicBoolean(false);
        this.selectedSlot = "";
        this.furnitureDescMapOnScreen = new ConcurrentHashMap<>();
        this.editGuideOnScreen = new ConcurrentHashMap<>();
        this.decorateMode = DecorateMode.SAMPLE_ROOM;
        this.curSelectedFurnitureMap = new ConcurrentHashMap<>();
        this.curRoomDesc = new r55.b();
        this.currencyData = new com.tencent.sqshow.zootopia.data.f(0, 0, 0, 0);
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<aa>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$miniHomeReporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final aa invoke() {
                return ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).createMiniHomeReporter();
            }
        });
        this.miniHomeReporter = lazy3;
        this.updateCurrencyDataCallback = new c();
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this), "zplan_EditMiniHomeFragment_chooseFurniture", null, null, null, new AnonymousClass1(null), 14, null);
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this), "zplan_EditMiniHomeFragment_chooseSampleRoom", null, null, null, new AnonymousClass2(null), 14, null);
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeViewModel>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$miniHomeInfoViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(EditMiniHomeFragment.this).get(MiniHomeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026omeViewModel::class.java)");
                return (MiniHomeViewModel) viewModel;
            }
        });
        this.miniHomeInfoViewModel = lazy4;
        this.editHomeSource = EditMiniHomeSource.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti(String slot, n55.a furniture) {
        Pair pair;
        if (furniture == null) {
            this.curSelectedFurnitureMap.remove(slot);
        } else {
            this.curSelectedFurnitureMap.put(slot, furniture);
        }
        this.curTotalPrice = 0;
        this.curTotalNum = 0;
        for (n55.a aVar : this.curSelectedFurnitureMap.values()) {
            if (aVar != null && !aVar.f418398g) {
                pair = new Pair(Integer.valueOf(aVar.f418396e), 1);
            } else {
                pair = new Pair(0, 0);
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            this.curTotalPrice += intValue;
            this.curTotalNum += intValue2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fj(String filterExpression, int pageIndex) {
        if (filterExpression == null) {
            return;
        }
        QLog.i("EditMiniHomeFragment", 1, "refreshDecorateListWithNewData, condition: " + filterExpression + ", pageIndex: " + pageIndex);
        bj(INSTANCE.f(filterExpression));
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this), "ZPlan_EditMiniHomeFragment_requestDecorateList", null, null, null, new EditMiniHomeFragment$refreshDecorateListWithNewData$1(this, filterExpression, null), 14, null);
    }

    private static final List<DecorateIdentifies> wi(String str) {
        if (str == null) {
            return null;
        }
        try {
            return (List) GsonUtil.f385283b.a().fromJson(str, new b().getType());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void Ai(EditMiniHomeFragment editMiniHomeFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        editMiniHomeFragment.zi(str, z16);
    }

    static /* synthetic */ void Ci(EditMiniHomeFragment editMiniHomeFragment, r55.b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        editMiniHomeFragment.Bi(bVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void mj(EditMiniHomeFragment editMiniHomeFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        editMiniHomeFragment.lj(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void tj(EditMiniHomeFragment editMiniHomeFragment, FurnitureDesc furnitureDesc, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            furnitureDesc = null;
        }
        editMiniHomeFragment.sj(furnitureDesc);
    }

    static /* synthetic */ void yj(EditMiniHomeFragment editMiniHomeFragment, ao aoVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aoVar = null;
        }
        editMiniHomeFragment.xj(aoVar);
    }

    private final RoomInstDiff vi(JSONArray oldInst, JSONArray newInst) {
        List minus;
        List minus2;
        if (oldInst == null || newInst == null) {
            return null;
        }
        List<DecorateIdentifies> wi5 = wi(oldInst.toString());
        List<DecorateIdentifies> wi6 = wi(newInst.toString());
        if (wi5 == null || wi6 == null) {
            return null;
        }
        List<DecorateIdentifies> list = wi6;
        List<DecorateIdentifies> list2 = wi5;
        minus = CollectionsKt___CollectionsKt.minus((Iterable) list, (Iterable) list2);
        minus2 = CollectionsKt___CollectionsKt.minus((Iterable) list2, (Iterable) list);
        RoomInstDiff roomInstDiff = new RoomInstDiff(minus, minus2);
        QLog.i("EditMiniHomeFragment", 1, "compareRoomInst roomInstDiff: " + roomInstDiff);
        return roomInstDiff;
    }
}
