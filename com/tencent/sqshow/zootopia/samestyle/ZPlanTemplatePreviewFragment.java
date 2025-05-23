package com.tencent.sqshow.zootopia.samestyle;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.epicgames.ue4.GameActivityThunk;
import com.epicgames.ue4.UE4;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.z1.lua.c;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanDebugHelper;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.fragment.ZPlanPublicBaseFragment;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.i;
import com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment;
import com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar;
import com.tencent.sqshow.zootopia.samestyle.data.MaterialWrapper;
import com.tencent.sqshow.zootopia.samestyle.data.ZPlanTemplateFixedRoleConfig;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.c;
import com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.RemoteRegisterHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import dy4.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00b0\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\f*\b\u00dc\u0001\u00e0\u0001\u00ee\u0001\u00f2\u0001\u0018\u0000 \u00f8\u00012\u00020\u00012\u00020\u0002:\b\u00f9\u0001\u00fa\u0001\u00fb\u0001\u00fc\u0001B\t\u00a2\u0006\u0006\b\u00f6\u0001\u0010\u00f7\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0015\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u001a\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0014J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000eH\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000eH\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0018H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002J\u0010\u00109\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002J\u0019\u0010>\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0018H\u0002\u00a2\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u00020\u0007H\u0002J\u0012\u0010C\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020DH\u0002J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020DH\u0002J\b\u0010I\u001a\u00020\u0007H\u0002J\b\u0010J\u001a\u00020\u0007H\u0002J\b\u0010K\u001a\u00020\u0007H\u0002J\b\u0010L\u001a\u00020\u0007H\u0002J\u0012\u0010M\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\u0018H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020\u0007H\u0002J\u0010\u0010P\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002J\b\u0010Q\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020\u0007H\u0002J\b\u0010S\u001a\u00020\u0007H\u0002J\b\u0010T\u001a\u00020\u0007H\u0002J\b\u0010U\u001a\u00020\u0007H\u0002J\b\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010W\u001a\u00020\u00032\u0006\u0010B\u001a\u00020AH\u0002J\u0010\u0010X\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010Y\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002J\b\u0010Z\u001a\u00020\u0007H\u0002J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0018H\u0002R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010c\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010bR\u0016\u0010h\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010gR\u0016\u0010k\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010gR\u0016\u0010m\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010gR\u0016\u0010o\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010fR\u0018\u0010r\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00020s8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010uR\u0018\u0010\u008b\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010xR\u0018\u0010\u008d\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010xR\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bg\u0010\u0093\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010xR\u001c\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u001c\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0018\u0010\u00a8\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a7\u0001\u0010bR\u001c\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u00a9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u0018\u0010\u00ae\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ad\u0001\u0010gR\u001a\u0010\u00b2\u0001\u001a\u00030\u00af\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u001a\u0010\u00b6\u0001\u001a\u00030\u00b3\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u00b5\u0001R\u0018\u0010\u00b8\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b7\u0001\u0010bR\u001a\u0010\u00bc\u0001\u001a\u00030\u00b9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u0018\u0010\u00be\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00bd\u0001\u0010gR\u001a\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u001a\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u00c0\u0001R\u0018\u0010\u00c3\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00c2\u0001\u0010gR\u0016\u0010\u00c5\u0001\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00c4\u0001\u0010fR\u0017\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00c6\u0001\u0010xR\u0018\u0010\u00ca\u0001\u001a\u00030\u00c7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c8\u0001\u0010\u00c9\u0001R\u0018\u0010\u00cc\u0001\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00cb\u0001\u0010qR\u0018\u0010\u00ce\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00cd\u0001\u0010gR!\u0010\u00d4\u0001\u001a\u00030\u00cf\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d0\u0001\u0010\u00d1\u0001\u001a\u0006\b\u00d2\u0001\u0010\u00d3\u0001R\u001b\u0010\u00d7\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001R\u0018\u0010\u00db\u0001\u001a\u00030\u00d8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d9\u0001\u0010\u00da\u0001R\u0018\u0010\u00df\u0001\u001a\u00030\u00dc\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00dd\u0001\u0010\u00de\u0001R\u0018\u0010\u00e3\u0001\u001a\u00030\u00e0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u00e2\u0001R\u0018\u0010\u00e7\u0001\u001a\u00030\u00e4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u00e6\u0001R\u0018\u0010\u00e9\u0001\u001a\u00030\u00e4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00e6\u0001R\u0018\u0010\u00ed\u0001\u001a\u00030\u00ea\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00eb\u0001\u0010\u00ec\u0001R\u0018\u0010\u00f1\u0001\u001a\u00030\u00ee\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ef\u0001\u0010\u00f0\u0001R\u0018\u0010\u00f5\u0001\u001a\u00030\u00f2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f3\u0001\u0010\u00f4\u0001\u00a8\u0006\u00fd\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment;", "Lcom/tencent/sqshow/fragment/ZPlanPublicBaseFragment;", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "needImmersive", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lpv4/f;", "result", "qi", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "keyCode", "Landroid/view/KeyEvent;", "event", "doOnKeyDown", "onDestroyView", "rh", DKHippyEvent.EVENT_STOP, "success", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "onFirstFrame", "Vi", "Ni", "cj", "Oi", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Mi", "Ai", "Pi", "isDirectArTemplate", "ai", "Qi", "zi", "Ii", "", "totalTime", "dj", "time", "hi", "Landroid/content/Context;", "context", "Fi", WidgetCacheLunarData.YI, "wi", "initViewModel", "Ei", "progress", "ti", "(Ljava/lang/Integer;)V", "ki", "", "path", "li", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$c;", "pakCheckResult", "vi", "bsResCheckResult", SensorJsPlugin.SENSOR_INTERVAL_UI, "ei", "bi", "di", "ci", "Zi", "gi", "oi", "Zh", "Wi", "Li", "fi", "Xi", "Ui", "si", WidgetCacheLunarData.JI, "Yi", "ii", "bj", "pageId", "Ti", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "template", "G", "J", "startTime", "H", "templateTabId", "I", "Z", "isAutoPublish", "mIsEngineInited", "K", "mUEResumed", "L", "mIsFileExist", "M", "mProgress", "N", "Ljava/lang/String;", "mPendingEnterAvatarScenePath", "Landroid/widget/FrameLayout;", "P", "Landroid/widget/FrameLayout;", "engineScenePage", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "mTextureView", "Ldy4/a;", BdhLogUtil.LogTag.Tag_Req, "Ldy4/a;", "mZPlanRender", "Landroid/widget/RelativeLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/RelativeLayout;", "templatePreviewPage", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "templateInfoText", "U", "templateTitle", "V", "templatePreviewContainer", "W", "backButton", "X", "sameStyleButton", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar;", "Y", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar;", "videoProgressBar", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "previewImageView", "Lcom/tencent/mobileqq/videoplatform/api/IBaseVideoView;", "a0", "Lcom/tencent/mobileqq/videoplatform/api/IBaseVideoView;", "videoPlayView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "b0", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "c0", "videoPlayButton", "Landroid/widget/ProgressBar;", "d0", "Landroid/widget/ProgressBar;", "videoBufferView", "Landroid/app/Dialog;", "e0", "Landroid/app/Dialog;", "sceneLoadingDialog", "f0", "sceneLoadingId", "Landroid/os/Handler;", "g0", "Landroid/os/Handler;", "sceneLoadingHandler", "h0", "needResumePlayer", "Landroid/content/SharedPreferences;", "i0", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "j0", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "viewModel", "k0", "playTotalDuration", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "l0", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "m0", "isOnStopByClick", "n0", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$c;", "o0", "p0", "hadClickButton", "q0", "CATEGORY_SAME_STYLE_PAK", "r0", "Lid3/d;", "s0", "Lid3/d;", "reporter", "t0", "curReportPageId", "u0", "isPeakReady", "Lcom/tencent/mobileqq/z1/lua/c;", "v0", "Lkotlin/Lazy;", "ni", "()Lcom/tencent/mobileqq/z1/lua/c;", "leaveAvatarScenePlugin", "w0", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "worldStatusListener", "Lcom/tencent/sqshow/zootopia/samestyle/JumpToLittleWorldBroadcastReceiver;", "x0", "Lcom/tencent/sqshow/zootopia/samestyle/JumpToLittleWorldBroadcastReceiver;", "mJumpToLittleWorldBroadcastReceiver", "com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$i", "y0", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$i;", "videoPlayCallback", "com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$h", "z0", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$h;", "ueResListener", "Ljava/lang/Runnable;", "A0", "Ljava/lang/Runnable;", "mSlowProgressRunnable", "B0", "mQuickProgressRunnable", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "C0", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "mEngineInitListener", "com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$g", "D0", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$g;", "mTextureViewListener", "com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$leaveAvatarSceneReceiver$1", "E0", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$leaveAvatarSceneReceiver$1;", "leaveAvatarSceneReceiver", "<init>", "()V", "F0", "a", "b", "c", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTemplatePreviewFragment extends ZPlanPublicBaseFragment implements IZPlanWorldStatusListener {
    private static int G0;

    /* renamed from: A0, reason: from kotlin metadata */
    private final Runnable mSlowProgressRunnable;

    /* renamed from: B0, reason: from kotlin metadata */
    private final Runnable mQuickProgressRunnable;

    /* renamed from: C0, reason: from kotlin metadata */
    private final GameActivityThunk.CMShowEngineInitFinishListener mEngineInitListener;

    /* renamed from: D0, reason: from kotlin metadata */
    private final g mTextureViewListener;

    /* renamed from: E0, reason: from kotlin metadata */
    private final ZPlanTemplatePreviewFragment$leaveAvatarSceneReceiver$1 leaveAvatarSceneReceiver;

    /* renamed from: F, reason: from kotlin metadata */
    private ZPlanTemplate template;

    /* renamed from: G, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: H, reason: from kotlin metadata */
    private long templateTabId;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isAutoPublish;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsEngineInited;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mUEResumed;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsFileExist;

    /* renamed from: M, reason: from kotlin metadata */
    private int mProgress;

    /* renamed from: N, reason: from kotlin metadata */
    private String mPendingEnterAvatarScenePath;

    /* renamed from: P, reason: from kotlin metadata */
    private FrameLayout engineScenePage;

    /* renamed from: Q, reason: from kotlin metadata */
    private View mTextureView;

    /* renamed from: R, reason: from kotlin metadata */
    private dy4.a mZPlanRender;

    /* renamed from: S, reason: from kotlin metadata */
    private RelativeLayout templatePreviewPage;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView templateInfoText;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView templateTitle;

    /* renamed from: V, reason: from kotlin metadata */
    private FrameLayout templatePreviewContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private View backButton;

    /* renamed from: X, reason: from kotlin metadata */
    private View sameStyleButton;

    /* renamed from: Y, reason: from kotlin metadata */
    private ZPlanVideoProgressBar videoProgressBar;

    /* renamed from: Z, reason: from kotlin metadata */
    private URLImageView previewImageView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private IBaseVideoView videoPlayView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ISuperPlayer superPlayer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View videoPlayButton;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ProgressBar videoBufferView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private Dialog sceneLoadingDialog;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private Handler sceneLoadingHandler;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean needResumePlayer;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private SharedPreferences sharedPreferences;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private TemplatePreviewViewModel viewModel;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private long playTotalDuration;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean isOnStopByClick;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private ResCheckResult pakCheckResult;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private ResCheckResult bsResCheckResult;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean hadClickButton;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isPeakReady;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private final Lazy leaveAvatarScenePlugin;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private IZPlanWorldStatusListener worldStatusListener;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private final JumpToLittleWorldBroadcastReceiver mJumpToLittleWorldBroadcastReceiver;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private final i videoPlayCallback;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private final h ueResListener;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private long sceneLoadingId = -1;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource source = ZootopiaSource.INSTANCE.a(Source.UnSet);

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private final int CATEGORY_SAME_STYLE_PAK = ZPlanFileCategory.SAME_STYLE_PAK.getValue();

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private final id3.d reporter = new id3.d(null, 1, null);

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private String curReportPageId = "";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$b;", "Lcom/tencent/sqshow/zootopia/guide/i$b;", "", "needGuide", "", "Lpv4/f;", "result", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "getContextRefer", "()Lmqq/util/WeakReference;", "contextRefer", "context", "<init>", "(Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements i.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZPlanTemplatePreviewFragment> contextRefer;

        public b(ZPlanTemplatePreviewFragment context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.contextRefer = new WeakReference<>(context);
        }

        @Override // com.tencent.sqshow.zootopia.guide.i.b
        public void a(boolean needGuide, List<pv4.f> result) {
            ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment;
            Intrinsics.checkNotNullParameter(result, "result");
            if (!needGuide || (zPlanTemplatePreviewFragment = this.contextRefer.get()) == null) {
                return;
            }
            zPlanTemplatePreviewFragment.qi(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$d;", "Landroid/os/Handler$Callback;", "Landroid/os/Message;", "msg", "", "handleMessage", "", "d", "J", "getId", "()J", "id", "<init>", "(Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment;J)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class d implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long id;

        public d(long j3) {
            this.id = j3;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (this.id != ZPlanTemplatePreviewFragment.this.sceneLoadingId) {
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "scene loading progress[" + this.id + "] cancelled");
                return false;
            }
            switch (msg2.what) {
                case 100:
                    ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment = ZPlanTemplatePreviewFragment.this;
                    Object obj = msg2.obj;
                    zPlanTemplatePreviewFragment.ti(obj instanceof Integer ? (Integer) obj : null);
                    break;
                case 101:
                    ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment2 = ZPlanTemplatePreviewFragment.this;
                    Object obj2 = msg2.obj;
                    zPlanTemplatePreviewFragment2.vi(new ResCheckResult(true, 0, "", obj2 instanceof String ? (String) obj2 : null));
                    break;
                case 102:
                    ZPlanTemplatePreviewFragment.this.vi(new ResCheckResult(false, -1, "pak download fail", null));
                    break;
            }
            return true;
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$e", "Lgc3/c;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "errorCode", "", "onFinalCallback", "", "progress", "", "receivedBytes", "totalBytes", "onProgress", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements gc3.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f372869b;

        e(File file) {
            this.f372869b = file;
        }

        @Override // gc3.c
        public void onFinalCallback(String taskId, int downloadStatus, int errorCode) {
            Message obtainMessage;
            Handler handler;
            Message obtainMessage2;
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "downloadPakResource onFinalCallback -- downloadStatus = " + downloadStatus + " , errorCode = " + errorCode);
            if (downloadStatus != 5) {
                if (downloadStatus != 6 || (handler = ZPlanTemplatePreviewFragment.this.sceneLoadingHandler) == null || (obtainMessage2 = handler.obtainMessage(102)) == null) {
                    return;
                }
                obtainMessage2.sendToTarget();
                return;
            }
            Handler handler2 = ZPlanTemplatePreviewFragment.this.sceneLoadingHandler;
            if (handler2 == null || (obtainMessage = handler2.obtainMessage(101, this.f372869b.getAbsolutePath())) == null) {
                return;
            }
            obtainMessage.sendToTarget();
        }

        @Override // gc3.c
        public void onProgress(String taskId, float progress, long receivedBytes, long totalBytes) {
            Message obtainMessage;
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Handler handler = ZPlanTemplatePreviewFragment.this.sceneLoadingHandler;
            if (handler == null || (obtainMessage = handler.obtainMessage(100, Integer.valueOf((int) (progress * 100.0d)))) == null) {
                return;
            }
            obtainMessage.sendToTarget();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$f", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar$b;", "", "time", "", "c", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements ZPlanVideoProgressBar.b {
        f() {
        }

        @Override // com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar.b
        public void a(long time) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 4, "seek time to " + time);
            TemplatePreviewViewModel templatePreviewViewModel = ZPlanTemplatePreviewFragment.this.viewModel;
            if (templatePreviewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                templatePreviewViewModel = null;
            }
            templatePreviewViewModel.R1(time);
            ZPlanTemplatePreviewFragment.this.hi((int) time);
        }

        @Override // com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar.b
        public void b(long time) {
            TemplatePreviewViewModel templatePreviewViewModel = ZPlanTemplatePreviewFragment.this.viewModel;
            if (templatePreviewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                templatePreviewViewModel = null;
            }
            templatePreviewViewModel.R1(time);
        }

        @Override // com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar.b
        public void c(long time) {
            TemplatePreviewViewModel templatePreviewViewModel = ZPlanTemplatePreviewFragment.this.viewModel;
            if (templatePreviewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                templatePreviewViewModel = null;
            }
            templatePreviewViewModel.S1(time, false);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$g", "Lcom/tencent/zplan/world/view/d;", "Landroid/view/Surface;", "surface", "", "width", "height", "", "b", "a", "onSurfaceDestroyed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements com.tencent.zplan.world.view.d {
        g() {
        }

        @Override // com.tencent.zplan.world.view.d
        public void a(Surface surface, int width, int height) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "onSurfaceChanged, width = " + width + ", height = " + height);
        }

        @Override // com.tencent.zplan.world.view.d
        public void b(Surface surface, int width, int height) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "onSurfaceCreate, width = " + width + ", height = " + height);
        }

        @Override // com.tencent.zplan.world.view.d
        public void onSurfaceDestroyed(Surface surface) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "surfaceTextureDestroyed");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$h", "Lji3/n;", "", "a", "", "errorCode", "onDownloadFail", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements ji3.n {
        h() {
        }

        @Override // ji3.n
        public void a() {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "checkSameStyleRes onAllReady");
            ZPlanTemplatePreviewFragment.this.ui(new ResCheckResult(true, 0, "", null));
        }

        @Override // ji3.n
        public void onDownloadFail(int errorCode) {
            QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, "checkSameStyleRes onDownloadFail - " + errorCode);
            ZPlanTemplatePreviewFragment.this.ui(new ResCheckResult(false, errorCode, "download res fail", null));
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J0\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J0\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016\u00a8\u0006\u001d"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$i", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayerCallback;", "", "id", "", "state", "", "onStateChange", "onDownloadComplete", "downSize", "onDownloadProgress", "positionMs", "onPlayProgress", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "exInfo", "onPlayError", "", "isSuccess", "width", "height", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onCapFrame", "onFirstFrameRendered", "position", "onLoopBack", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i implements VideoPlayerCallback {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ZPlanTemplatePreviewFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            IBaseVideoView iBaseVideoView = this$0.videoPlayView;
            long videoDurationMs = iBaseVideoView != null ? iBaseVideoView.getVideoDurationMs() : 0L;
            if (videoDurationMs <= 0) {
                ZPlanTemplate zPlanTemplate = this$0.template;
                if (zPlanTemplate == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                    zPlanTemplate = null;
                }
                videoDurationMs = zPlanTemplate.getLength();
            }
            this$0.dj(videoDurationMs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e() {
            QQToast.makeText(BaseApplication.getContext(), 1, "\u89c6\u9891\u64ad\u653e\u5931\u8d25", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ZPlanTemplatePreviewFragment this$0, int i3) {
            boolean contains;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ProgressBar progressBar = this$0.videoBufferView;
            if (progressBar == null) {
                return;
            }
            contains = ArraysKt___ArraysKt.contains(new Integer[]{5}, Integer.valueOf(i3));
            progressBar.setVisibility(contains ? 0 : 8);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long id5, boolean isSuccess, int width, int height, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long id5) {
            IBaseVideoView iBaseVideoView = ZPlanTemplatePreviewFragment.this.videoPlayView;
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "onVideoFirstFrame, video duration = " + (iBaseVideoView != null ? Long.valueOf(iBaseVideoView.getVideoDurationMs()) : null));
            FragmentActivity activity = ZPlanTemplatePreviewFragment.this.getActivity();
            if (activity != null) {
                final ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment = ZPlanTemplatePreviewFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.ah
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanTemplatePreviewFragment.i.d(ZPlanTemplatePreviewFragment.this);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long id5, long position) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 4, "on loopback, position = " + position);
            TemplatePreviewViewModel templatePreviewViewModel = ZPlanTemplatePreviewFragment.this.viewModel;
            if (templatePreviewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                templatePreviewViewModel = null;
            }
            templatePreviewViewModel.R1(position);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long id5, int module, int errorType, int errorCode, String exInfo) {
            Intrinsics.checkNotNullParameter(exInfo, "exInfo");
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "playError " + id5 + " ,module == " + module + ", errorType=" + errorType + " , errorCode=" + errorCode + ", and exInfo=" + exInfo);
            FragmentActivity activity = ZPlanTemplatePreviewFragment.this.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanTemplatePreviewFragment.i.e();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long id5, long positionMs) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 4, "onPlayProgress, postionMs = " + positionMs);
            TemplatePreviewViewModel templatePreviewViewModel = ZPlanTemplatePreviewFragment.this.viewModel;
            if (templatePreviewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                templatePreviewViewModel = null;
            }
            templatePreviewViewModel.R1(positionMs);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long id5, final int state) {
            Context context;
            Context context2;
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "player state change to " + state);
            if (state == 4 && (context2 = ZPlanTemplatePreviewFragment.this.getContext()) != null) {
                com.tencent.sqshow.zootopia.utils.b.f373264a.b(context2);
            }
            if ((state == 6 || state == 9) && (context = ZPlanTemplatePreviewFragment.this.getContext()) != null) {
                com.tencent.sqshow.zootopia.utils.b.f373264a.a(context);
            }
            if (state == 8) {
                TemplatePreviewViewModel templatePreviewViewModel = ZPlanTemplatePreviewFragment.this.viewModel;
                if (templatePreviewViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    templatePreviewViewModel = null;
                }
                templatePreviewViewModel.S1(ZPlanTemplatePreviewFragment.this.playTotalDuration, false);
            }
            FragmentActivity activity = ZPlanTemplatePreviewFragment.this.getActivity();
            if (activity != null) {
                final ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment = ZPlanTemplatePreviewFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.af
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanTemplatePreviewFragment.i.f(ZPlanTemplatePreviewFragment.this, state);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long id5) {
            QLog.d("ZPlanSameStyle_TemplatePreviewFragment", 1, "videoPlayCallback onDownloadComplete");
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long id5, long downSize) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment$leaveAvatarSceneReceiver$1] */
    public ZPlanTemplatePreviewFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.z1.lua.c>() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment$leaveAvatarScenePlugin$2

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$leaveAvatarScenePlugin$2$a", "Lcom/tencent/mobileqq/z1/lua/c$b;", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements c.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ZPlanTemplatePreviewFragment f372873a;

                a(ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment) {
                    this.f372873a = zPlanTemplatePreviewFragment;
                }

                @Override // com.tencent.mobileqq.z1.lua.c.b
                public boolean a() {
                    QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, this + ", ZootopiaLeaveAvatarScenePlugin leaveAvatarScene");
                    TemplatePreviewViewModel templatePreviewViewModel = this.f372873a.viewModel;
                    if (templatePreviewViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        templatePreviewViewModel = null;
                    }
                    templatePreviewViewModel.Q1(0);
                    return true;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.z1.lua.c invoke() {
                return new com.tencent.mobileqq.z1.lua.c(new a(ZPlanTemplatePreviewFragment.this));
            }
        });
        this.leaveAvatarScenePlugin = lazy;
        this.worldStatusListener = this;
        this.mJumpToLittleWorldBroadcastReceiver = new JumpToLittleWorldBroadcastReceiver(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment$mJumpToLittleWorldBroadcastReceiver$1
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
                boolean z16;
                z16 = ZPlanTemplatePreviewFragment.this.isOnStopByClick;
                if (z16) {
                    ZPlanTemplatePreviewFragment.this.isOnStopByClick = false;
                    ZPlanTemplatePreviewFragment.this.gi();
                }
            }
        });
        this.videoPlayCallback = new i();
        this.ueResListener = new h();
        this.mSlowProgressRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment$mSlowProgressRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                int i17;
                ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment = ZPlanTemplatePreviewFragment.this;
                i3 = zPlanTemplatePreviewFragment.mProgress;
                zPlanTemplatePreviewFragment.mProgress = i3 + 1;
                i16 = ZPlanTemplatePreviewFragment.this.mProgress;
                if (i16 > 99) {
                    return;
                }
                ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment2 = ZPlanTemplatePreviewFragment.this;
                i17 = zPlanTemplatePreviewFragment2.mProgress;
                zPlanTemplatePreviewFragment2.Zi(i17);
                Handler handler = ZPlanTemplatePreviewFragment.this.sceneLoadingHandler;
                if (handler != null) {
                    handler.postDelayed(this, 800L);
                }
            }
        };
        this.mQuickProgressRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment$mQuickProgressRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                int i16;
                int i17;
                ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment = ZPlanTemplatePreviewFragment.this;
                i3 = zPlanTemplatePreviewFragment.mProgress;
                zPlanTemplatePreviewFragment.mProgress = i3 + 1;
                i16 = ZPlanTemplatePreviewFragment.this.mProgress;
                if (i16 >= 100) {
                    ZPlanTemplatePreviewFragment.this.si();
                    return;
                }
                ZPlanTemplatePreviewFragment zPlanTemplatePreviewFragment2 = ZPlanTemplatePreviewFragment.this;
                i17 = zPlanTemplatePreviewFragment2.mProgress;
                zPlanTemplatePreviewFragment2.Zi(i17);
                Handler handler = ZPlanTemplatePreviewFragment.this.sceneLoadingHandler;
                if (handler != null) {
                    handler.postDelayed(this, 10L);
                }
            }
        };
        this.mEngineInitListener = new GameActivityThunk.CMShowEngineInitFinishListener() { // from class: com.tencent.sqshow.zootopia.samestyle.ab
            @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
            public final void onEngineInitFinish(boolean z16) {
                ZPlanTemplatePreviewFragment.Ri(ZPlanTemplatePreviewFragment.this, z16);
            }
        };
        this.mTextureViewListener = new g();
        this.leaveAvatarSceneReceiver = new BroadcastReceiver() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment$leaveAvatarSceneReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                TemplatePreviewViewModel templatePreviewViewModel = null;
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "leaveAvatarSceneReceiver active, action = " + (intent != null ? intent.getAction() : null));
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "L2N_LeaveAvatarScene")) {
                    TemplatePreviewViewModel templatePreviewViewModel2 = ZPlanTemplatePreviewFragment.this.viewModel;
                    if (templatePreviewViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        templatePreviewViewModel = templatePreviewViewModel2;
                    }
                    templatePreviewViewModel.Q1(0);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(ZPlanTemplatePreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "click back Button");
        this$0.bj();
        this$0.requireActivity().onBackPressed();
        id3.d dVar = this$0.reporter;
        View view2 = this$0.backButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            view2 = null;
        }
        dVar.c("dt_clck", view2, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(ZPlanTemplatePreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "click to start");
        ZPlanTemplate zPlanTemplate = this$0.template;
        View view2 = null;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        if (zPlanTemplate.isAR()) {
            TemplatePreviewViewModel templatePreviewViewModel = this$0.viewModel;
            if (templatePreviewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                templatePreviewViewModel = null;
            }
            templatePreviewViewModel.O1();
            if (!this$0.Pi()) {
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "not In Zplan AR White List");
                QQToast.makeText(BaseApplication.getContext(), R.string.xhq, 0).show();
                return;
            }
            this$0.ai(true);
        } else {
            this$0.sceneLoadingId = System.currentTimeMillis();
            Handler handler = this$0.sceneLoadingHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this$0.sceneLoadingHandler = new Handler(Looper.getMainLooper(), new d(this$0.sceneLoadingId));
            this$0.ei();
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            this$0.ii(requireContext);
            this$0.di();
            ZPlanTemplate.Companion companion = ZPlanTemplate.INSTANCE;
            ZPlanTemplate zPlanTemplate2 = this$0.template;
            if (zPlanTemplate2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate2 = null;
            }
            companion.b(zPlanTemplate2);
        }
        id3.d dVar = this$0.reporter;
        View view3 = this$0.sameStyleButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
        } else {
            view2 = view3;
        }
        dVar.c("dt_clck", view2, new LinkedHashMap());
        this$0.hadClickButton = true;
        i.a.a(ZplanGuideManager.INSTANCE.a(), 8, 9, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(ZPlanTemplatePreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IBaseVideoView iBaseVideoView = this$0.videoPlayView;
        Intrinsics.checkNotNull(iBaseVideoView);
        TemplatePreviewViewModel templatePreviewViewModel = null;
        if (iBaseVideoView.isPlaying()) {
            TemplatePreviewViewModel templatePreviewViewModel2 = this$0.viewModel;
            if (templatePreviewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                templatePreviewViewModel = templatePreviewViewModel2;
            }
            templatePreviewViewModel.O1();
            return;
        }
        TemplatePreviewViewModel templatePreviewViewModel3 = this$0.viewModel;
        if (templatePreviewViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            templatePreviewViewModel = templatePreviewViewModel3;
        }
        templatePreviewViewModel.P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(ZPlanTemplatePreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplatePreviewViewModel templatePreviewViewModel = this$0.viewModel;
        if (templatePreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templatePreviewViewModel = null;
        }
        templatePreviewViewModel.P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(ZPlanTemplatePreviewFragment this$0, Integer page) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplatePreviewViewModel templatePreviewViewModel = null;
        if (page != null && page.intValue() == 0) {
            RelativeLayout relativeLayout = this$0.templatePreviewPage;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatePreviewPage");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
            this$0.Ui();
        } else if (page != null && page.intValue() == 1) {
            this$0.Xi();
            RelativeLayout relativeLayout2 = this$0.templatePreviewPage;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatePreviewPage");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
        }
        if (page != null && page.intValue() == 1) {
            TemplatePreviewViewModel templatePreviewViewModel2 = this$0.viewModel;
            if (templatePreviewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                templatePreviewViewModel = templatePreviewViewModel2;
            }
            templatePreviewViewModel.O1();
        }
        Intrinsics.checkNotNullExpressionValue(page, "page");
        this$0.Ti(page.intValue());
        G0 = page.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(ZPlanTemplatePreviewFragment this$0, TemplatePreviewViewModel.VideoPlayState videoPlayState) {
        IBaseVideoView iBaseVideoView;
        IBaseVideoView iBaseVideoView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanVideoProgressBar zPlanVideoProgressBar = this$0.videoProgressBar;
        ZPlanVideoProgressBar zPlanVideoProgressBar2 = null;
        if (zPlanVideoProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoProgressBar");
            zPlanVideoProgressBar = null;
        }
        zPlanVideoProgressBar.setPlayPosition(videoPlayState.getPlayPositionMs());
        if (videoPlayState.getIsPlay()) {
            View view = this$0.videoPlayButton;
            if (view != null) {
                view.setVisibility(8);
            }
            ZPlanVideoProgressBar zPlanVideoProgressBar3 = this$0.videoProgressBar;
            if (zPlanVideoProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoProgressBar");
            } else {
                zPlanVideoProgressBar2 = zPlanVideoProgressBar3;
            }
            zPlanVideoProgressBar2.g();
            IBaseVideoView iBaseVideoView3 = this$0.videoPlayView;
            if (!((iBaseVideoView3 == null || iBaseVideoView3.isPlaying()) ? false : true) || (iBaseVideoView2 = this$0.videoPlayView) == null) {
                return;
            }
            iBaseVideoView2.play();
            return;
        }
        View view2 = this$0.videoPlayButton;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ZPlanVideoProgressBar zPlanVideoProgressBar4 = this$0.videoProgressBar;
        if (zPlanVideoProgressBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoProgressBar");
        } else {
            zPlanVideoProgressBar2 = zPlanVideoProgressBar4;
        }
        zPlanVideoProgressBar2.f();
        IBaseVideoView iBaseVideoView4 = this$0.videoPlayView;
        if (!(iBaseVideoView4 != null && iBaseVideoView4.isPlaying()) || (iBaseVideoView = this$0.videoPlayView) == null) {
            return;
        }
        iBaseVideoView.pause();
    }

    private final boolean Ni() {
        View view = this.sameStyleButton;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            view = null;
        }
        if (!view.isAttachedToWindow()) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "button is disAttached");
            return false;
        }
        View view3 = this.sameStyleButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            view3 = null;
        }
        if (view3.getVisibility() != 0) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "button is invisible");
            return false;
        }
        Rect rect = new Rect();
        View view4 = this.sameStyleButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            view4 = null;
        }
        if (!view4.getLocalVisibleRect(rect)) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "button is invisible");
            return false;
        }
        int height = rect.height();
        View view5 = this.sameStyleButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            view5 = null;
        }
        if (height < view5.getHeight()) {
            int height2 = rect.height();
            View view6 = this.sameStyleButton;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            } else {
                view2 = view6;
            }
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "expose area is not enough " + height2 + " " + view2.getHeight());
            return false;
        }
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "isButton visible");
        return true;
    }

    private final boolean Oi() {
        TemplatePreviewViewModel templatePreviewViewModel = this.viewModel;
        if (templatePreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templatePreviewViewModel = null;
        }
        Integer value = templatePreviewViewModel.M1().getValue();
        return value != null && value.intValue() == 1;
    }

    private final boolean Pi() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(210001L, peekAppRuntime.getLongAccountUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(final ZPlanTemplatePreviewFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "zplan engine init finish success = " + z16);
        this$0.mIsEngineInited = z16;
        final FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.s
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTemplatePreviewFragment.Si(ZPlanTemplatePreviewFragment.this, activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(ZPlanTemplatePreviewFragment this$0, FragmentActivity this_apply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (this$0.getActivity() == null || this$0.isDetached()) {
            return;
        }
        this$0.Zh(this_apply);
        if (this$0.Oi()) {
            this$0.Xi();
        }
    }

    private final void Ui() {
        if (this.mUEResumed) {
            this.mUEResumed = false;
            dy4.a aVar = this.mZPlanRender;
            if (aVar != null) {
                aVar.a(false);
            }
            dy4.a aVar2 = this.mZPlanRender;
            if (aVar2 != null) {
                aVar2.pause();
            }
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "ue paused");
        }
    }

    private final void Vi() {
        ZPlanLuaBridge.INSTANCE.registerPlugin(ni());
    }

    private final void Wi() {
        dy4.a aVar = this.mZPlanRender;
        if (aVar != null) {
            aVar.destroy();
        }
        if (this.mTextureView != null) {
            FrameLayout frameLayout = this.engineScenePage;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("engineScenePage");
                frameLayout = null;
            }
            View view = this.mTextureView;
            Intrinsics.checkNotNull(view);
            frameLayout.removeView(view);
            this.mTextureView = null;
        }
    }

    private final void Xi() {
        boolean z16 = true;
        if (this.mTextureView != null && !this.mUEResumed) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "ue resumed");
            this.mUEResumed = true;
            dy4.a aVar = this.mZPlanRender;
            if (aVar != null) {
                aVar.resume();
            }
            dy4.a aVar2 = this.mZPlanRender;
            if (aVar2 != null) {
                aVar2.H();
            }
            dy4.a aVar3 = this.mZPlanRender;
            if (aVar3 != null) {
                aVar3.a(true);
            }
        }
        if (this.mUEResumed) {
            String str = this.mPendingEnterAvatarScenePath;
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            String str2 = this.mPendingEnterAvatarScenePath;
            Intrinsics.checkNotNull(str2);
            ji(str2);
            this.mPendingEnterAvatarScenePath = null;
        }
    }

    private final void Yi(Context context) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            QQToast.makeText(context, 1, "\u7f51\u7edc\u65e0\u6cd5\u8fde\u63a5", 0).show();
            return;
        }
        if (NetworkUtil.getNetworkType(context) == 1) {
            return;
        }
        SharedPreferences sharedPreferences = this.sharedPreferences;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        if (System.currentTimeMillis() - sharedPreferences.getLong("last_network_volume_warning_time", 0L) < 86400000) {
            return;
        }
        QQToast.makeText(context, 0, R.string.f169823xt0, 0).show();
        SharedPreferences sharedPreferences3 = this.sharedPreferences;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        sharedPreferences2.edit().putLong("last_network_volume_warning_time", System.currentTimeMillis()).apply();
    }

    private final void Zh(Context context) {
        if (this.mIsEngineInited && this.mTextureView == null) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "real add texture view");
            RelativeLayout relativeLayout = null;
            dy4.a d16 = com.tencent.zplan.world.manager.b.d(com.tencent.zplan.world.manager.b.f386323a, context, false, 2, null);
            this.mZPlanRender = d16;
            this.mTextureView = d16 != null ? a.C10207a.a(d16, requireActivity(), context, true, false, false, 24, null) : null;
            dy4.a aVar = this.mZPlanRender;
            if (aVar != null) {
                aVar.setRenderListener(this.mTextureViewListener);
            }
            FrameLayout frameLayout = this.engineScenePage;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("engineScenePage");
                frameLayout = null;
            }
            frameLayout.addView(this.mTextureView, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout relativeLayout2 = this.templatePreviewPage;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatePreviewPage");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zi(int progress) {
        WindowManager.LayoutParams layoutParams;
        Dialog dialog;
        Window window;
        WindowManager windowManager;
        Display defaultDisplay;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.sceneLoadingDialog == null) {
            Dialog dialog2 = new Dialog(context, R.style.qZoneInputDialog);
            dialog2.setCanceledOnTouchOutside(false);
            dialog2.setContentView(R.layout.f167676dz);
            View findViewById = dialog2.findViewById(R.id.jg_);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            dialog2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.sqshow.zootopia.samestyle.aa
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    ZPlanTemplatePreviewFragment.aj(ZPlanTemplatePreviewFragment.this, dialogInterface);
                }
            });
            this.sceneLoadingDialog = dialog2;
        }
        Dialog dialog3 = this.sceneLoadingDialog;
        if (dialog3 == null || (window = dialog3.getWindow()) == null || (layoutParams = window.getAttributes()) == null) {
            layoutParams = null;
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                Intrinsics.checkNotNullExpressionValue(defaultDisplay, "defaultDisplay");
                layoutParams.width = defaultDisplay.getWidth();
                layoutParams.height = defaultDisplay.getHeight();
            }
        }
        Dialog dialog4 = this.sceneLoadingDialog;
        Window window2 = dialog4 != null ? dialog4.getWindow() : null;
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        if (progress <= 0 && (dialog = this.sceneLoadingDialog) != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog5 = this.sceneLoadingDialog;
        TextView textView = dialog5 != null ? (TextView) dialog5.findViewById(R.id.photo_prievew_progress_dialog_text) : null;
        if (progress >= 0) {
            if (textView != null) {
                textView.setText("\u6b63\u5728\u52a0\u8f7d " + progress + "%");
            }
        } else if (textView != null) {
            textView.setText("\u6b63\u5728\u52a0\u8f7d");
        }
        Dialog dialog6 = this.sceneLoadingDialog;
        if (dialog6 != null) {
            dialog6.show();
        }
    }

    private final void ai(boolean isDirectArTemplate) {
        if (!NetworkUtil.isNetworkAvailable(getContext())) {
            QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, "applyARTemplate, but network not available");
            QQToast.makeText(getContext(), 1, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, 0).show();
        } else {
            ci();
            Qi(isDirectArTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aj(ZPlanTemplatePreviewFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sceneLoadingId = -1L;
        Handler handler = this$0.sceneLoadingHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this$0.sceneLoadingHandler = null;
        this$0.Ui();
    }

    private final void bi() {
        ResCheckResult resCheckResult = this.pakCheckResult;
        boolean z16 = false;
        if (resCheckResult != null && resCheckResult.getIsSuccess()) {
            ResCheckResult resCheckResult2 = this.bsResCheckResult;
            if (resCheckResult2 != null && resCheckResult2.getIsSuccess()) {
                z16 = true;
            }
            if (z16) {
                ResCheckResult resCheckResult3 = this.pakCheckResult;
                Object successData = resCheckResult3 != null ? resCheckResult3.getSuccessData() : null;
                li(successData instanceof String ? (String) successData : null);
                return;
            }
        }
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "checkAllResResult has not ready");
    }

    private final void bj() {
        IBaseVideoView iBaseVideoView = this.videoPlayView;
        if (iBaseVideoView == null || !iBaseVideoView.isPlaying() || Oi()) {
            return;
        }
        IBaseVideoView iBaseVideoView2 = this.videoPlayView;
        if (iBaseVideoView2 != null) {
            iBaseVideoView2.pause();
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
    }

    private final void ci() {
        if (((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(BaseApplication.getContext())) {
            this.isPeakReady = true;
        } else {
            ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplication.getContext());
        }
    }

    private final void cj() {
        ZPlanLuaBridge.INSTANCE.removePlugin(ni());
    }

    private final void di() {
        ZPlanSameStyleResHelper.f372974a.k("ZPlanSameStyle_TemplatePreviewFragment", this.ueResListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dj(long totalTime) {
        Long[] lArr;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        this.playTotalDuration = totalTime;
        ZPlanTemplate zPlanTemplate = this.template;
        ZPlanVideoProgressBar zPlanVideoProgressBar = null;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        if (!zPlanTemplate.getVideoClips().isEmpty()) {
            ZPlanTemplate zPlanTemplate2 = this.template;
            if (zPlanTemplate2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate2 = null;
            }
            if (zPlanTemplate2.getVideoClips().get(0).getStartTime() == 0) {
                ZPlanTemplate zPlanTemplate3 = this.template;
                if (zPlanTemplate3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                    zPlanTemplate3 = null;
                }
                List<ZPlanVideoClipInfo> videoClips = zPlanTemplate3.getVideoClips();
                ZPlanTemplate zPlanTemplate4 = this.template;
                if (zPlanTemplate4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                    zPlanTemplate4 = null;
                }
                List<ZPlanVideoClipInfo> subList = videoClips.subList(1, zPlanTemplate4.getClipCount());
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it = subList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(Math.min(((ZPlanVideoClipInfo) it.next()).getStartTime(), totalTime)));
                }
                Object[] array = arrayList.toArray(new Long[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                lArr = (Long[]) array;
            } else {
                ZPlanTemplate zPlanTemplate5 = this.template;
                if (zPlanTemplate5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                    zPlanTemplate5 = null;
                }
                List<ZPlanVideoClipInfo> videoClips2 = zPlanTemplate5.getVideoClips();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(videoClips2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = videoClips2.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(Long.valueOf(Math.min(((ZPlanVideoClipInfo) it5.next()).getStartTime(), totalTime)));
                }
                Object[] array2 = arrayList2.toArray(new Long[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                lArr = (Long[]) array2;
            }
        } else {
            lArr = new Long[0];
        }
        ZPlanVideoProgressBar zPlanVideoProgressBar2 = this.videoProgressBar;
        if (zPlanVideoProgressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoProgressBar");
        } else {
            zPlanVideoProgressBar = zPlanVideoProgressBar2;
        }
        zPlanVideoProgressBar.setVideoLengthInfo(totalTime, lArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        Dialog dialog = this.sceneLoadingDialog;
        boolean z16 = false;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        }
        if (z16) {
            try {
                Dialog dialog2 = this.sceneLoadingDialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:7:0x0008, B:11:0x001a, B:17:0x002d, B:19:0x0038, B:21:0x003e, B:23:0x004c, B:29:0x0061, B:31:0x006c, B:25:0x005b, B:13:0x0027), top: B:6:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void hi(int time) {
        ISuperPlayer iSuperPlayer;
        TemplatePreviewViewModel templatePreviewViewModel;
        Field field;
        VideoPlayerProxy videoPlayerProxy;
        Field field2;
        IBaseVideoView iBaseVideoView = this.videoPlayView;
        if (iBaseVideoView == null) {
            return;
        }
        TemplatePreviewViewModel templatePreviewViewModel2 = null;
        try {
            Field[] declaredFields = BaseVideoView.class.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "BaseVideoView::class.java.declaredFields");
            int length = declaredFields.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i3];
                if (Intrinsics.areEqual(field.getType(), VideoPlayerProxy.class)) {
                    break;
                } else {
                    i3++;
                }
            }
        } catch (Exception e16) {
            QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, e16, "obtain SuperPlayer failed");
        }
        if (field != null) {
            field.setAccessible(true);
            Object obj = field.get(iBaseVideoView);
            if (obj instanceof VideoPlayerProxy) {
                videoPlayerProxy = (VideoPlayerProxy) obj;
                if (videoPlayerProxy != null) {
                    Field[] declaredFields2 = VideoPlayerProxy.class.getDeclaredFields();
                    Intrinsics.checkNotNullExpressionValue(declaredFields2, "VideoPlayerProxy::class.java.declaredFields");
                    int length2 = declaredFields2.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            field2 = null;
                            break;
                        }
                        field2 = declaredFields2[i16];
                        if (Intrinsics.areEqual(field2.getType(), ISuperPlayer.class)) {
                            break;
                        } else {
                            i16++;
                        }
                    }
                    if (field2 != null) {
                        field2.setAccessible(true);
                        Object obj2 = field2.get(videoPlayerProxy);
                        if (obj2 instanceof ISuperPlayer) {
                            iSuperPlayer = (ISuperPlayer) obj2;
                            if (iSuperPlayer != null) {
                                iSuperPlayer.seekTo(time, 3);
                            } else {
                                IBaseVideoView iBaseVideoView2 = this.videoPlayView;
                                if (iBaseVideoView2 != null) {
                                    iBaseVideoView2.seekTo(time);
                                }
                            }
                            templatePreviewViewModel = this.viewModel;
                            if (templatePreviewViewModel == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                templatePreviewViewModel2 = templatePreviewViewModel;
                            }
                            templatePreviewViewModel2.P1();
                        }
                    }
                }
                iSuperPlayer = null;
                if (iSuperPlayer != null) {
                }
                templatePreviewViewModel = this.viewModel;
                if (templatePreviewViewModel == null) {
                }
                templatePreviewViewModel2.P1();
            }
        }
        videoPlayerProxy = null;
        if (videoPlayerProxy != null) {
        }
        iSuperPlayer = null;
        if (iSuperPlayer != null) {
        }
        templatePreviewViewModel = this.viewModel;
        if (templatePreviewViewModel == null) {
        }
        templatePreviewViewModel2.P1();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006f A[Catch: Exception -> 0x019b, TryCatch #0 {Exception -> 0x019b, blocks: (B:3:0x0004, B:6:0x0012, B:7:0x0016, B:11:0x0026, B:14:0x002d, B:16:0x0037, B:18:0x003d, B:20:0x0043, B:21:0x004c, B:23:0x0063, B:28:0x006f, B:31:0x007e, B:33:0x0098, B:34:0x009c, B:36:0x00dc, B:37:0x00df, B:39:0x00e3, B:40:0x00e8, B:42:0x012a, B:44:0x0138, B:46:0x0144, B:47:0x0147, B:49:0x014a, B:51:0x0150, B:53:0x015a, B:55:0x0162, B:59:0x0166), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ii(Context context) {
        boolean startsWith$default;
        Message obtainMessage;
        Message obtainMessage2;
        boolean z16;
        Intent intent;
        try {
            this.startTime = System.currentTimeMillis();
            ZPlanTemplate zPlanTemplate = this.template;
            ZPlanTemplate zPlanTemplate2 = null;
            if (zPlanTemplate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate = null;
            }
            String downloadUrl = zPlanTemplate.getDownloadUrl();
            if (!(downloadUrl.length() == 0)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(downloadUrl, "http", false, 2, null);
                if (!startsWith$default) {
                    FragmentActivity activity = getActivity();
                    String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("pak_download_url_prefix");
                    QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "download prefix = " + stringExtra);
                    if (stringExtra != null && stringExtra.length() != 0) {
                        z16 = false;
                        if (!z16) {
                            downloadUrl = stringExtra + downloadUrl;
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
                String str = downloadUrl;
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "start download pak file, raw url = " + str);
                ZPlanTemplate zPlanTemplate3 = this.template;
                if (zPlanTemplate3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                    zPlanTemplate3 = null;
                }
                byte[] bytes = zPlanTemplate3.getDownloadUrl().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                String fileMd5 = SecUtil.getFileMd5(new ByteArrayInputStream(bytes));
                File file = new File(context.getCacheDir(), "cmshow/samestyle/asset/" + fileMd5 + "/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                ZPlanTemplate zPlanTemplate4 = this.template;
                if (zPlanTemplate4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                } else {
                    zPlanTemplate2 = zPlanTemplate4;
                }
                String str2 = "template_" + zPlanTemplate2.getTimestamp() + ".pak";
                File file2 = new File(file, str2);
                this.mIsFileExist = false;
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "template pak save name = " + file2.getAbsolutePath());
                if (file2.exists()) {
                    QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "cache pak exist, use it directly");
                    Zi(-1);
                    Handler handler = this.sceneLoadingHandler;
                    if (handler != null && (obtainMessage2 = handler.obtainMessage(101, file2.getAbsolutePath())) != null) {
                        obtainMessage2.sendToTarget();
                    }
                    this.mIsFileExist = true;
                    return;
                }
                if (!NetworkUtil.isNetworkAvailable(context)) {
                    QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, "start download pak file, but network not available");
                    Handler handler2 = this.sceneLoadingHandler;
                    if (handler2 == null || (obtainMessage = handler2.obtainMessage(102)) == null) {
                        return;
                    }
                    obtainMessage.sendToTarget();
                    return;
                }
                Zi(0);
                String absolutePath = file.getAbsolutePath();
                FileUtils.deleteFilesInDirectory(absolutePath);
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "downloadPakResource BEGIN  delete old pak");
                int i3 = this.CATEGORY_SAME_STYLE_PAK;
                QRouteApi api = QRoute.api(IZPlanIPCHelper.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanIPCHelper::class.java)");
                IZPlanIPCHelper iZPlanIPCHelper = (IZPlanIPCHelper) api;
                iZPlanIPCHelper.downloadRemoteManagerStartFileDownload(i3, str, absolutePath, str2, "");
                iZPlanIPCHelper.downloadProgressHelperBindFileDownloadProgress(i3, str, true, new e(file2));
                return;
            }
            QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, "url is empty");
        } catch (Exception e16) {
            QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, "downloadPakResource error", e16);
        }
    }

    private final void initViewModel() {
        TemplatePreviewViewModel templatePreviewViewModel = this.viewModel;
        TemplatePreviewViewModel templatePreviewViewModel2 = null;
        if (templatePreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templatePreviewViewModel = null;
        }
        templatePreviewViewModel.M1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.samestyle.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanTemplatePreviewFragment.Ji(ZPlanTemplatePreviewFragment.this, (Integer) obj);
            }
        });
        TemplatePreviewViewModel templatePreviewViewModel3 = this.viewModel;
        if (templatePreviewViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            templatePreviewViewModel2 = templatePreviewViewModel3;
        }
        templatePreviewViewModel2.N1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.samestyle.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanTemplatePreviewFragment.Ki(ZPlanTemplatePreviewFragment.this, (TemplatePreviewViewModel.VideoPlayState) obj);
            }
        });
    }

    private final boolean ji(String path) {
        int i3;
        try {
            if (this.source.getMainSource() == Source.Emoticon) {
                ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplication.getContext());
                i3 = 1;
            } else {
                i3 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ViewType", 20);
            ZPlanTemplate zPlanTemplate = this.template;
            ZPlanTemplate zPlanTemplate2 = null;
            if (zPlanTemplate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate = null;
            }
            jSONObject.put("SameStyleID", zPlanTemplate.getId());
            jSONObject.put("TemplateTab", this.templateTabId);
            ZPlanTemplate zPlanTemplate3 = this.template;
            if (zPlanTemplate3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate3 = null;
            }
            jSONObject.put("SameStyleName", zPlanTemplate3.getName());
            ZPlanTemplate zPlanTemplate4 = this.template;
            if (zPlanTemplate4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate4 = null;
            }
            jSONObject.put("ContentType", zPlanTemplate4.getShowVideo() ? 1 : 0);
            jSONObject.put("SameStylePath", path);
            jSONObject.put("Source", com.tencent.sqshow.zootopia.utils.ah.b(this.source));
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("extra_fixed_role") : null;
            ZPlanTemplateFixedRoleConfig zPlanTemplateFixedRoleConfig = serializable instanceof ZPlanTemplateFixedRoleConfig ? (ZPlanTemplateFixedRoleConfig) serializable : null;
            if (zPlanTemplateFixedRoleConfig != null) {
                jSONObject.put("FixedRole", zPlanTemplateFixedRoleConfig.getFixedFlag());
                jSONObject.put("MasterUin", zPlanTemplateFixedRoleConfig.getMasterUin());
                jSONObject.put("GuestUin", zPlanTemplateFixedRoleConfig.getGuestUin());
                jSONObject.put("MasterNickname", zPlanTemplateFixedRoleConfig.getMasterNickName());
                jSONObject.put("GuestNickname", com.tencent.sqshow.zootopia.utils.w.f373306a.a());
            }
            jSONObject.put("SameStyleMode", i3);
            ZPlanTemplate zPlanTemplate5 = this.template;
            if (zPlanTemplate5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate5 = null;
            }
            jSONObject.put("SetDeviceProfile", zPlanTemplate5.isDowngrade());
            ZPlanTemplate zPlanTemplate6 = this.template;
            if (zPlanTemplate6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
            } else {
                zPlanTemplate2 = zPlanTemplate6;
            }
            jSONObject.put("ShowSticker", zPlanTemplate2.isWatermark());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026\n            }.toString()");
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "enterAvatarScene with params: " + jSONObject2);
            dy4.a aVar = this.mZPlanRender;
            if (aVar != null) {
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).enterAvatarScene(aVar, 20, jSONObject2, this.worldStatusListener);
            }
            return true;
        } catch (Exception e16) {
            QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, e16, new Object[0]);
            return false;
        }
    }

    private final void ki() {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "finalHandleResDownloadFail");
        gi();
        QQToast.makeText(getContext(), 1, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(long j3, ZPlanTemplatePreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 == this$0.sceneLoadingId) {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "waiting too long, make scene loading dialog cancelable");
            Dialog dialog = this$0.sceneLoadingDialog;
            if (dialog != null) {
                dialog.setCancelable(true);
            }
        }
    }

    private final com.tencent.mobileqq.z1.lua.c ni() {
        return (com.tencent.mobileqq.z1.lua.c) this.leaveAvatarScenePlugin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(ZPlanTemplatePreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDetached()) {
            return;
        }
        if (this$0.sceneLoadingId <= 0) {
            this$0.Ui();
            return;
        }
        if (this$0.mProgress < 99 && !this$0.mIsFileExist) {
            Handler handler = this$0.sceneLoadingHandler;
            if (handler != null) {
                handler.removeCallbacks(this$0.mSlowProgressRunnable);
            }
            Handler handler2 = this$0.sceneLoadingHandler;
            if (handler2 != null) {
                handler2.post(this$0.mQuickProgressRunnable);
                return;
            }
            return;
        }
        this$0.si();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(ZPlanTemplatePreviewFragment this$0, pv4.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.hadClickButton || !this$0.Ni()) {
            return;
        }
        com.tencent.sqshow.zootopia.guide.q qVar = com.tencent.sqshow.zootopia.guide.q.f370741a;
        View view = this$0.sameStyleButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            view = null;
        }
        com.tencent.sqshow.zootopia.guide.h j3 = qVar.j(view, fVar);
        ZplanGuideManager a16 = ZplanGuideManager.INSTANCE.a();
        Lifecycle lifecycle = this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        a16.n(lifecycle, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si() {
        gi();
        TemplatePreviewViewModel templatePreviewViewModel = this.viewModel;
        if (templatePreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templatePreviewViewModel = null;
        }
        templatePreviewViewModel.Q1(1);
        this.sceneLoadingId = -1L;
        Handler handler = this.sceneLoadingHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.sceneLoadingHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ui(ResCheckResult bsResCheckResult) {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "handleTmpResultForBsRes - " + bsResCheckResult.getIsSuccess());
        this.bsResCheckResult = bsResCheckResult;
        if (bsResCheckResult.getIsSuccess()) {
            bi();
            return;
        }
        ResCheckResult resCheckResult = this.pakCheckResult;
        if ((resCheckResult == null || resCheckResult.getIsSuccess()) ? false : true) {
            return;
        }
        ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vi(ResCheckResult pakCheckResult) {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "handleTmpResultForPak - " + pakCheckResult.getIsSuccess());
        this.pakCheckResult = pakCheckResult;
        if (pakCheckResult.getIsSuccess()) {
            bi();
            return;
        }
        ResCheckResult resCheckResult = this.bsResCheckResult;
        if ((resCheckResult == null || resCheckResult.getIsSuccess()) ? false : true) {
            return;
        }
        ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(ZPlanTemplatePreviewFragment this$0, View entranceContainer, String str, View rootView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        id3.d dVar = this$0.reporter;
        Intrinsics.checkNotNullExpressionValue(entranceContainer, "entranceContainer");
        dVar.c("dt_clck", entranceContainer, new LinkedHashMap());
        TemplatePreviewViewModel templatePreviewViewModel = this$0.viewModel;
        if (templatePreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templatePreviewViewModel = null;
        }
        templatePreviewViewModel.O1();
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "click to arButton");
        if (TextUtils.isEmpty(str)) {
            if (!this$0.Pi()) {
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "not In Zplan AR White List");
                QQToast.makeText(BaseApplication.getContext(), R.string.xhq, 0).show();
                return;
            } else {
                this$0.ai(false);
                return;
            }
        }
        if (str != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            iSchemeApi.launchScheme(context, str);
        }
    }

    private final void yi(Context context) {
        URLImageView uRLImageView = new URLImageView(context);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        ZPlanTemplate zPlanTemplate = this.template;
        ZPlanTemplate zPlanTemplate2 = null;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        uRLImageView.setImageDrawable(URLDrawable.getDrawable(zPlanTemplate.getPreviewUrl(), obtain));
        uRLImageView.setAdjustViewBounds(true);
        this.previewImageView = uRLImageView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        URLImageView uRLImageView2 = this.previewImageView;
        if (uRLImageView2 != null) {
            FrameLayout frameLayout = this.templatePreviewContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatePreviewContainer");
                frameLayout = null;
            }
            frameLayout.addView(uRLImageView2, layoutParams);
        }
        URLImageView uRLImageView3 = this.previewImageView;
        if (uRLImageView3 != null) {
            id3.d dVar = this.reporter;
            Intrinsics.checkNotNull(uRLImageView3);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ZPlanTemplate zPlanTemplate3 = this.template;
            if (zPlanTemplate3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
            } else {
                zPlanTemplate2 = zPlanTemplate3;
            }
            linkedHashMap.put(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate2.getId()));
            Unit unit = Unit.INSTANCE;
            id3.d.h(dVar, uRLImageView3, "em_zplan_samestyle_preview_content", linkedHashMap, false, false, null, 56, null);
        }
    }

    private final void zi(View rootView) {
        ZPlanTemplate zPlanTemplate = this.template;
        TextView textView = null;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "template length = " + zPlanTemplate.getLength());
        View findViewById = rootView.findViewById(R.id.qt5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tvTemplateInfo)");
        this.templateInfoText = (TextView) findViewById;
        ZPlanTemplate zPlanTemplate2 = this.template;
        if (zPlanTemplate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate2 = null;
        }
        if (zPlanTemplate2.isAR()) {
            TextView textView2 = this.templateInfoText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templateInfoText");
                textView2 = null;
            }
            textView2.setVisibility(8);
        } else {
            TextView textView3 = this.templateInfoText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templateInfoText");
                textView3 = null;
            }
            textView3.setVisibility(0);
            TextView textView4 = this.templateInfoText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templateInfoText");
                textView4 = null;
            }
            ZPlanTemplate zPlanTemplate3 = this.template;
            if (zPlanTemplate3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate3 = null;
            }
            textView4.setText(zPlanTemplate3.getDesc());
        }
        View findViewById2 = rootView.findViewById(R.id.qt6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tvTitle)");
        TextView textView5 = (TextView) findViewById2;
        this.templateTitle = textView5;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateTitle");
            textView5 = null;
        }
        ZPlanTemplate zPlanTemplate4 = this.template;
        if (zPlanTemplate4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate4 = null;
        }
        textView5.setText(zPlanTemplate4.getDisplayName());
        IZPlanDebugHelper iZPlanDebugHelper = (IZPlanDebugHelper) QRoute.api(IZPlanDebugHelper.class);
        TextView textView6 = this.templateTitle;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateTitle");
        } else {
            textView = textView6;
        }
        iZPlanDebugHelper.tryShowLongTextForTemplate(textView);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int keyCode, KeyEvent event) {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "doOnKeyDown keyCode:" + keyCode + ", event:" + event);
        if (event == null) {
            return super.doOnKeyDown(keyCode, event);
        }
        if (keyCode == 4) {
            if (Oi()) {
                if (t74.h.e()) {
                    QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "doOnKeyDown KEYCODE_BACK notify engine by UE4.inputEvent");
                    UE4.inputEvent(event);
                } else {
                    QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "doOnKeyDown [zpaln] KEYCODE_BACK notify engine by ZPlanServiceHelper.onKeyEvent");
                    ZPlanServiceHelper.I.s0(keyCode, event);
                }
                return true;
            }
            bj();
        }
        return super.doOnKeyDown(keyCode, event);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Window window;
        super.onCreate(savedInstanceState);
        Intent intent = requireActivity().getIntent();
        Serializable serializableExtra = intent.getSerializableExtra("template");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate");
        this.template = (ZPlanTemplate) serializableExtra;
        this.templateTabId = intent.getLongExtra("templateTab", 0L);
        this.isAutoPublish = intent.getBooleanExtra("zplan_auto_publish", false);
        IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
        ZPlanTemplate zPlanTemplate = this.template;
        ZPlanTemplate zPlanTemplate2 = null;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        iZPlanShareApi.setReportExtraInfo(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, String.valueOf(zPlanTemplate.getId()));
        SharedPreferences sharedPreferences = requireActivity().getApplicationContext().getSharedPreferences("com_tencent_mobileqq_zplan_samestyle_preview", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "requireActivity().applic\u2026ME, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(TemplatePreviewViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026iewViewModel::class.java]");
        this.viewModel = (TemplatePreviewViewModel) viewModel;
        boolean z16 = this.isAutoPublish;
        ZPlanTemplate zPlanTemplate3 = this.template;
        if (zPlanTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
        } else {
            zPlanTemplate2 = zPlanTemplate3;
        }
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "isAutoPublish = " + z16 + ", template info is : [" + zPlanTemplate2 + "]");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            JumpToLittleWorldBroadcastReceiver jumpToLittleWorldBroadcastReceiver = this.mJumpToLittleWorldBroadcastReceiver;
            activity.registerReceiver(jumpToLittleWorldBroadcastReceiver, jumpToLittleWorldBroadcastReceiver.a());
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (window = activity2.getWindow()) == null) {
            return;
        }
        window.addFlags(1024);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.f167397d34, container, false);
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.mJumpToLittleWorldBroadcastReceiver);
        }
        this.worldStatusListener = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        fi();
        ZPlanSameStyleResHelper.f372974a.u(this.ueResListener);
        IBaseVideoView iBaseVideoView = this.videoPlayView;
        if (iBaseVideoView != null) {
            iBaseVideoView.releasePlayer(false);
        }
        this.superPlayer = null;
    }

    @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onEnterSceneResult(boolean success) {
        IZPlanWorldStatusListener.a.a(this, success);
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "enterAvatarScene onEnterSceneResult " + success);
    }

    @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        IZPlanWorldStatusListener.a.b(this, result);
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "enterAvatarScene onFirstFrame, curType: " + result.getCurType());
        if (result.getCurType() == 20) {
            oi();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "onPause called");
        cj();
        if (Oi()) {
            Ui();
            return;
        }
        IBaseVideoView iBaseVideoView = this.videoPlayView;
        this.needResumePlayer = iBaseVideoView != null && iBaseVideoView.isPlaying();
        IBaseVideoView iBaseVideoView2 = this.videoPlayView;
        if (iBaseVideoView2 != null) {
            iBaseVideoView2.pause();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "onResume called");
        Vi();
        TemplatePreviewViewModel templatePreviewViewModel = this.viewModel;
        TemplatePreviewViewModel templatePreviewViewModel2 = null;
        if (templatePreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templatePreviewViewModel = null;
        }
        Integer value = templatePreviewViewModel.M1().getValue();
        int i3 = G0;
        if (value == null || value.intValue() != i3) {
            TemplatePreviewViewModel templatePreviewViewModel3 = this.viewModel;
            if (templatePreviewViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                templatePreviewViewModel3 = null;
            }
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "onResume currentPage state is dirty, currentPage=" + templatePreviewViewModel3.M1().getValue() + ", currentGlobalState=" + G0);
            TemplatePreviewViewModel templatePreviewViewModel4 = this.viewModel;
            if (templatePreviewViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                templatePreviewViewModel2 = templatePreviewViewModel4;
            }
            templatePreviewViewModel2.Q1(G0);
        } else if (Oi()) {
            Xi();
        } else if (this.needResumePlayer) {
            IBaseVideoView iBaseVideoView = this.videoPlayView;
            if (iBaseVideoView != null) {
                iBaseVideoView.resume();
            }
            this.needResumePlayer = false;
        }
        boolean z16 = this.hadClickButton;
        if (z16) {
            QLog.d("ZPlanSameStyle_TemplatePreviewFragment", 1, "hadClickButton " + z16);
            return;
        }
        ZplanGuideManager a16 = ZplanGuideManager.INSTANCE.a();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        a16.p(lifecycle, 8, new b(this));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.isOnStopByClick) {
            this.isOnStopByClick = false;
            gi();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.rootView = view;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(view.getContext());
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        view2.setPadding(0, statusBarHeight, 0, 0);
        Ai(view);
        Mi(view);
        Li();
        initViewModel();
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE) : null;
        ZootopiaSource zootopiaSource = serializable instanceof ZootopiaSource ? (ZootopiaSource) serializable : null;
        if (zootopiaSource != null) {
            this.source = zootopiaSource;
        }
        Ti(0);
    }

    public final void qi(List<pv4.f> result) {
        View view;
        Object obj;
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.hadClickButton) {
            return;
        }
        Iterator<T> it = result.iterator();
        while (true) {
            view = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            pv4.f fVar = (pv4.f) obj;
            if (com.tencent.sqshow.zootopia.guide.j.a(fVar) && ZplanGuideManager.INSTANCE.a().h(fVar.f427598b) && fVar.f427598b == 9) {
                break;
            }
        }
        final pv4.f fVar2 = (pv4.f) obj;
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "show guide view find data " + fVar2);
        if (fVar2 != null) {
            View view2 = this.sameStyleButton;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            } else {
                view = view2;
            }
            view.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTemplatePreviewFragment.ri(ZPlanTemplatePreviewFragment.this, fVar2);
                }
            });
        }
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment
    protected boolean rh() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(View view) {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "empty click, mask engine page event");
    }

    private final void Li() {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "init zplan engine");
        com.tencent.zplan.engine.service.c.INSTANCE.a(this.mEngineInitListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean Qi(boolean isDirectArTemplate) {
        String downloadUrl;
        String str;
        ZPlanTemplate zPlanTemplate;
        ZPlanTemplate zPlanTemplate2;
        FragmentActivity activity;
        this.isOnStopByClick = true;
        ZPlanTemplate zPlanTemplate3 = this.template;
        if (zPlanTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate3 = null;
        }
        if (zPlanTemplate3.isMixAR()) {
            ZPlanTemplate zPlanTemplate4 = this.template;
            if (zPlanTemplate4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate4 = null;
            }
            ZplanEntranceInfo entranceInfo = zPlanTemplate4.getEntranceInfo();
            if (entranceInfo != null) {
                downloadUrl = entranceInfo.getSdkUrl();
            } else {
                str = null;
                int i3 = !isDirectArTemplate ? 1 : 2;
                c.Companion companion = com.tencent.sqshow.zootopia.samestyle.mix.helper.c.INSTANCE;
                FragmentActivity activity2 = getActivity();
                zPlanTemplate = this.template;
                if (zPlanTemplate != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("template");
                    zPlanTemplate2 = null;
                } else {
                    zPlanTemplate2 = zPlanTemplate;
                }
                String d16 = companion.d(str, activity2, zPlanTemplate2, this.source, i3);
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "toLittleWorld " + isDirectArTemplate + ", schemeUrl:" + d16);
                Intent intent = new Intent(getContext(), (Class<?>) JumpActivity.class);
                intent.setData(Uri.parse(d16));
                activity = getActivity();
                if (activity != null) {
                    activity.startActivity(intent);
                }
                return true;
            }
        } else {
            ZPlanTemplate zPlanTemplate5 = this.template;
            if (zPlanTemplate5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate5 = null;
            }
            downloadUrl = zPlanTemplate5.getDownloadUrl();
        }
        str = downloadUrl;
        if (!isDirectArTemplate) {
        }
        c.Companion companion2 = com.tencent.sqshow.zootopia.samestyle.mix.helper.c.INSTANCE;
        FragmentActivity activity22 = getActivity();
        zPlanTemplate = this.template;
        if (zPlanTemplate != null) {
        }
        String d162 = companion2.d(str, activity22, zPlanTemplate2, this.source, i3);
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "toLittleWorld " + isDirectArTemplate + ", schemeUrl:" + d162);
        Intent intent2 = new Intent(getContext(), (Class<?>) JumpActivity.class);
        intent2.setData(Uri.parse(d162));
        activity = getActivity();
        if (activity != null) {
        }
        return true;
    }

    private final void ei() {
        this.bsResCheckResult = null;
        this.pakCheckResult = null;
    }

    private final void fi() {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "zplan engine destroy");
        Wi();
        com.tencent.zplan.engine.service.c.INSTANCE.b(this.mEngineInitListener);
        RemoteRegisterHelper.INSTANCE.a().d("L2N_LeaveAvatarScene", null);
    }

    private final void li(String path) {
        if (path == null) {
            QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, "finalHandleResDownloadSuccess, but path is null");
            gi();
            return;
        }
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "finalHandleResDownloadSuccess, path = " + path);
        ZPlanTemplate zPlanTemplate = null;
        if (this.mUEResumed) {
            this.mPendingEnterAvatarScenePath = null;
            if (ji(path)) {
                QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "enter avatar scene, wait for first frame...");
            } else {
                QLog.e("ZPlanSameStyle_TemplatePreviewFragment", 1, "enter avatar scene error, need retry...");
                gi();
            }
        } else {
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "try enter edit scene, but engine is not ready, wait...");
            this.mPendingEnterAvatarScenePath = path;
            Xi();
            if (!this.mIsFileExist) {
                this.mProgress = 75;
                Handler handler = this.sceneLoadingHandler;
                if (handler != null) {
                    handler.post(this.mSlowProgressRunnable);
                }
            }
        }
        final long j3 = this.sceneLoadingId;
        Handler handler2 = this.sceneLoadingHandler;
        if (handler2 != null) {
            handler2.postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.v
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTemplatePreviewFragment.mi(j3, this);
                }
            }, 15000L);
        }
        id3.d dVar = this.reporter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, com.tencent.sqshow.zootopia.utils.ah.b(this.source));
        ZPlanTemplate zPlanTemplate2 = this.template;
        if (zPlanTemplate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate2 = null;
        }
        linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate2.getId()));
        ZPlanTemplate zPlanTemplate3 = this.template;
        if (zPlanTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
        } else {
            zPlanTemplate = zPlanTemplate3;
        }
        linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(zPlanTemplate.getContentType()));
        linkedHashMap.put("zplan_loading_lvtm", Long.valueOf(System.currentTimeMillis() - this.startTime));
        Unit unit = Unit.INSTANCE;
        dVar.d("ev_zplan_samestyle_loading_success", linkedHashMap);
    }

    private final void oi() {
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "zplan engine first frame called");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanTemplatePreviewFragment.pi(ZPlanTemplatePreviewFragment.this);
                }
            });
        }
    }

    private final void Ti(int pageId) {
        String str;
        Map<String, Object> mutableMapOf;
        Object obj;
        String str2;
        if (pageId == 0) {
            str = "pg_zplan_samestyle_preview";
        } else {
            str = "pg_zplan_samestyle_edit";
        }
        QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, this + " notifySwitchToPage curPgId: " + this.curReportPageId + ", newPgId: " + str);
        if (Intrinsics.areEqual(str, this.curReportPageId)) {
            return;
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, com.tencent.sqshow.zootopia.utils.ah.b(this.source));
        ZPlanTemplate zPlanTemplate = this.template;
        Object obj2 = null;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        pairArr[1] = new Pair(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate.getId()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        this.curReportPageId = str;
        id3.d dVar = this.reporter;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (pageId == 0) {
            obj = this.templatePreviewPage;
            if (obj == null) {
                str2 = "templatePreviewPage";
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            }
            obj2 = obj;
        } else {
            obj = this.engineScenePage;
            if (obj == null) {
                str2 = "engineScenePage";
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            }
            obj2 = obj;
        }
        dVar.j(requireActivity, obj2, this.curReportPageId, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti(Integer progress) {
        if (progress != null) {
            progress.intValue();
            QLog.i("ZPlanSameStyle_TemplatePreviewFragment", 1, "download pak file progress: " + progress);
            Zi(Math.min(75, (progress.intValue() * 3) / 4));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\t\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplatePreviewFragment$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "I", "getErrorCode", "()I", "errorCode", "c", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorMsg", "d", "Ljava/lang/Object;", "()Ljava/lang/Object;", "successData", "<init>", "(ZILjava/lang/String;Ljava/lang/Object;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplatePreviewFragment$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class ResCheckResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String errorMsg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final Object successData;

        public ResCheckResult(boolean z16, int i3, String str, Object obj) {
            this.isSuccess = z16;
            this.errorCode = i3;
            this.errorMsg = str;
            this.successData = obj;
        }

        /* renamed from: a, reason: from getter */
        public final Object getSuccessData() {
            return this.successData;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = ((r06 * 31) + this.errorCode) * 31;
            String str = this.errorMsg;
            int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
            Object obj = this.successData;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }

        public String toString() {
            return "ResCheckResult(isSuccess=" + this.isSuccess + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", successData=" + this.successData + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResCheckResult)) {
                return false;
            }
            ResCheckResult resCheckResult = (ResCheckResult) other;
            return this.isSuccess == resCheckResult.isSuccess && this.errorCode == resCheckResult.errorCode && Intrinsics.areEqual(this.errorMsg, resCheckResult.errorMsg) && Intrinsics.areEqual(this.successData, resCheckResult.successData);
        }
    }

    private final void Ei(Context context) {
        IBaseVideoView createBaseVideoView = QQVideoViewFactory.createBaseVideoView(context, 126L, null, null);
        Intrinsics.checkNotNull(createBaseVideoView, "null cannot be cast to non-null type com.tencent.mobileqq.videoplatform.view.BaseVideoView");
        this.videoPlayView = (BaseVideoView) createBaseVideoView;
    }

    private final void Ii(View rootView) {
        View findViewById = rootView.findViewById(R.id.qy9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.videoProgressBar)");
        ZPlanVideoProgressBar zPlanVideoProgressBar = (ZPlanVideoProgressBar) findViewById;
        this.videoProgressBar = zPlanVideoProgressBar;
        ZPlanVideoProgressBar zPlanVideoProgressBar2 = null;
        if (zPlanVideoProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoProgressBar");
            zPlanVideoProgressBar = null;
        }
        ZPlanTemplate zPlanTemplate = this.template;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        zPlanVideoProgressBar.setVisibility(zPlanTemplate.getShowVideo() ? 0 : 8);
        ZPlanVideoProgressBar zPlanVideoProgressBar3 = this.videoProgressBar;
        if (zPlanVideoProgressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoProgressBar");
        } else {
            zPlanVideoProgressBar2 = zPlanVideoProgressBar3;
        }
        zPlanVideoProgressBar2.setSeekListener(new f());
    }

    private final void Mi(View rootView) {
        View findViewById = rootView.findViewById(R.id.qj_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.sceneContainer)");
        this.engineScenePage = (FrameLayout) findViewById;
    }

    private final void Fi(Context context) {
        FrameLayout frameLayout;
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mIsLoop = true;
        videoPlayParam.mIsLocal = false;
        videoPlayParam.mIsMute = false;
        videoPlayParam.mVideoFormat = 101;
        videoPlayParam.mNeedPlayProgress = true;
        TemplatePreviewViewModel templatePreviewViewModel = this.viewModel;
        ZPlanTemplate zPlanTemplate = null;
        if (templatePreviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templatePreviewViewModel = null;
        }
        TemplatePreviewViewModel.VideoPlayState value = templatePreviewViewModel.N1().getValue();
        videoPlayParam.mStartPlayPosMs = value != null ? value.getPlayPositionMs() : 0L;
        videoPlayParam.mSceneId = 126;
        String[] strArr = new String[1];
        ZPlanTemplate zPlanTemplate2 = this.template;
        if (zPlanTemplate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate2 = null;
        }
        strArr[0] = zPlanTemplate2.getPreviewUrl();
        videoPlayParam.mUrls = strArr;
        videoPlayParam.mCallback = this.videoPlayCallback;
        Ei(context);
        IBaseVideoView iBaseVideoView = this.videoPlayView;
        if (iBaseVideoView != null) {
            iBaseVideoView.setVideoParam(videoPlayParam);
        }
        Object obj = this.videoPlayView;
        if (obj instanceof View) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            ((View) obj).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanTemplatePreviewFragment.Gi(ZPlanTemplatePreviewFragment.this, view);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            FrameLayout frameLayout2 = this.templatePreviewContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templatePreviewContainer");
                frameLayout2 = null;
            }
            Object obj2 = this.videoPlayView;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
            frameLayout2.addView((View) obj2, layoutParams);
        }
        int applyDimension = (int) TypedValue.applyDimension(1, 60.0f, getResources().getDisplayMetrics());
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.iji);
        this.videoPlayButton = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTemplatePreviewFragment.Hi(ZPlanTemplatePreviewFragment.this, view);
            }
        });
        FrameLayout frameLayout3 = this.templatePreviewContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatePreviewContainer");
            frameLayout3 = null;
        }
        View view = this.videoPlayButton;
        Intrinsics.checkNotNull(view);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension);
        layoutParams2.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout3.addView(view, layoutParams2);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.b(17), com.tencent.sqshow.zootopia.utils.i.b(17)));
        progressBar.setIndeterminateDrawable(ContextCompat.getDrawable(context, R.drawable.f160873o6));
        this.videoBufferView = progressBar;
        progressBar.setVisibility(8);
        FrameLayout frameLayout4 = this.templatePreviewContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatePreviewContainer");
            frameLayout4 = null;
        }
        ProgressBar progressBar2 = this.videoBufferView;
        Intrinsics.checkNotNull(progressBar2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(applyDimension2, applyDimension2);
        layoutParams3.gravity = 17;
        frameLayout4.addView(progressBar2, layoutParams3);
        Yi(context);
        id3.d dVar = this.reporter;
        FrameLayout frameLayout5 = this.templatePreviewContainer;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatePreviewContainer");
            frameLayout = null;
        } else {
            frameLayout = frameLayout5;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ZPlanTemplate zPlanTemplate3 = this.template;
        if (zPlanTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
        } else {
            zPlanTemplate = zPlanTemplate3;
        }
        linkedHashMap.put(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate.getId()));
        id3.d.h(dVar, frameLayout, "em_zplan_samestyle_preview_content", linkedHashMap, false, false, null, 56, null);
    }

    private final void Ai(View rootView) {
        View view;
        View view2;
        View findViewById = rootView.findViewById(R.id.qdj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.previewContainer)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.templatePreviewPage = relativeLayout;
        ZPlanTemplate zPlanTemplate = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatePreviewPage");
            relativeLayout = null;
        }
        relativeLayout.bringToFront();
        RelativeLayout relativeLayout2 = this.templatePreviewPage;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templatePreviewPage");
            relativeLayout2 = null;
        }
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ZPlanTemplatePreviewFragment.Bi(view3);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.pfa);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.btn_back)");
        this.backButton = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            findViewById2 = null;
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ZPlanTemplatePreviewFragment.Ci(ZPlanTemplatePreviewFragment.this, view3);
            }
        });
        id3.d dVar = this.reporter;
        View view3 = this.backButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            view = null;
        } else {
            view = view3;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ZPlanTemplate zPlanTemplate2 = this.template;
        if (zPlanTemplate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate2 = null;
        }
        linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate2.getId()));
        ZPlanTemplate zPlanTemplate3 = this.template;
        if (zPlanTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate3 = null;
        }
        linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(zPlanTemplate3.getContentType()));
        Unit unit = Unit.INSTANCE;
        id3.d.h(dVar, view, "em_zplan_back_btn", linkedHashMap, false, true, null, 40, null);
        View findViewById3 = rootView.findViewById(R.id.qsz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tvContinueBtn)");
        this.sameStyleButton = findViewById3;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            findViewById3 = null;
        }
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ZPlanTemplatePreviewFragment.Di(ZPlanTemplatePreviewFragment.this, view4);
            }
        });
        id3.d dVar2 = this.reporter;
        View view4 = this.sameStyleButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sameStyleButton");
            view2 = null;
        } else {
            view2 = view4;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ZPlanTemplate zPlanTemplate4 = this.template;
        if (zPlanTemplate4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate4 = null;
        }
        linkedHashMap2.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate4.getId()));
        ZPlanTemplate zPlanTemplate5 = this.template;
        if (zPlanTemplate5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate5 = null;
        }
        linkedHashMap2.put("zplan_samestyle_type", Integer.valueOf(zPlanTemplate5.getContentType()));
        id3.d.h(dVar2, view2, "em_zplan_samestyle_create", linkedHashMap2, false, true, null, 40, null);
        zi(rootView);
        Ii(rootView);
        View findViewById4 = rootView.findViewById(R.id.puf);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.flPreviewContent)");
        this.templatePreviewContainer = (FrameLayout) findViewById4;
        ZPlanTemplate zPlanTemplate6 = this.template;
        if (zPlanTemplate6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
        } else {
            zPlanTemplate = zPlanTemplate6;
        }
        if (zPlanTemplate.getShowVideo()) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Fi(requireContext);
        } else {
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            yi(requireContext2);
        }
        wi(rootView);
    }

    private final void wi(final View rootView) {
        final View entranceContainer = rootView.findViewById(R.id.psc);
        ZPlanTemplate zPlanTemplate = this.template;
        ZPlanTemplate zPlanTemplate2 = null;
        if (zPlanTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("template");
            zPlanTemplate = null;
        }
        if (zPlanTemplate.isMixAR()) {
            entranceContainer.setVisibility(0);
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) entranceContainer.findViewById(R.id.psd);
            TextView textView = (TextView) entranceContainer.findViewById(R.id.psg);
            TextView textView2 = (TextView) entranceContainer.findViewById(R.id.psf);
            ZPlanTemplate zPlanTemplate3 = this.template;
            if (zPlanTemplate3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate3 = null;
            }
            ZplanEntranceInfo entranceInfo = zPlanTemplate3.getEntranceInfo();
            if (entranceInfo != null) {
                zPlanMediaView.e(MaterialWrapper.INSTANCE.a(entranceInfo.getIconMaterial()));
                String title = entranceInfo.getTitle();
                List split$default = title != null ? StringsKt__StringsKt.split$default((CharSequence) title, new String[]{"\n"}, false, 0, 6, (Object) null) : null;
                if (split$default != null && (split$default.isEmpty() ^ true)) {
                    textView.setText((CharSequence) split$default.get(0));
                    if (split$default.size() > 1) {
                        textView2.setText((CharSequence) split$default.get(1));
                    } else {
                        textView2.setVisibility(8);
                    }
                }
                final String schema = entranceInfo.getSchema();
                Intrinsics.checkNotNullExpressionValue(entranceContainer, "entranceContainer");
                com.tencent.sqshow.zootopia.utils.aa.d(entranceContainer, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.ae
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZPlanTemplatePreviewFragment.xi(ZPlanTemplatePreviewFragment.this, entranceContainer, schema, rootView, view);
                    }
                });
            }
            id3.d dVar = this.reporter;
            Intrinsics.checkNotNullExpressionValue(entranceContainer, "entranceContainer");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ZPlanTemplate zPlanTemplate4 = this.template;
            if (zPlanTemplate4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
                zPlanTemplate4 = null;
            }
            linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate4.getId()));
            ZPlanTemplate zPlanTemplate5 = this.template;
            if (zPlanTemplate5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("template");
            } else {
                zPlanTemplate2 = zPlanTemplate5;
            }
            linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(zPlanTemplate2.getContentType()));
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, com.tencent.sqshow.zootopia.utils.ah.b(this.source));
            Unit unit = Unit.INSTANCE;
            id3.d.h(dVar, entranceContainer, "em_zplan_ar_samestyle_entrance", linkedHashMap, false, true, null, 40, null);
            return;
        }
        entranceContainer.setVisibility(8);
    }
}
