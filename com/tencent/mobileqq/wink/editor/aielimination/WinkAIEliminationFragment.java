package com.tencent.mobileqq.wink.editor.aielimination;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment;
import com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleColor;
import com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodlePen;
import com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleShape;
import com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleView;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationButtonStatus;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationScene;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationTabName;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import com.tencent.mobileqq.wink.view.ag;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$UsageInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00d8\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00d9\u0001B\t\u00a2\u0006\u0006\b\u00d6\u0001\u0010\u00d7\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002Jv\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2d\u0010\u001a\u001a`\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0005H\u0002J\u001a\u0010*\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020(H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020(H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u00100\u001a\u00020(H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u00100\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00100\u001a\u00020(H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u00020\u0007H\u0002J>\u0010D\u001a\u00020C2\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00070?2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010AH\u0002J\u0012\u0010F\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010H\u001a\u00020\u00072\b\u0010G\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010I\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010J\u001a\u00020\u0007H\u0016J\u0006\u0010K\u001a\u00020\u0012J\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020M0LJ.\u0010R\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00122\u0016\b\u0002\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020M\u0018\u00010PJ\u0018\u0010U\u001a\u00020\u00072\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010SJ\b\u0010V\u001a\u00020\u0007H\u0016J\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0WH\u0016J\u001a\u0010Z\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010[\u001a\u00020;H\u0014J\b\u0010\\\u001a\u00020;H\u0014J\u0012\u0010^\u001a\u00020\u00072\b\u0010]\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010`\u001a\u00020\u00072\u0006\u0010_\u001a\u00020;J\u0006\u0010a\u001a\u00020\u0007J\u0006\u0010b\u001a\u00020\u0007J\u0006\u0010c\u001a\u00020(J\u001c\u0010f\u001a\u00020(2\b\u0010]\u001a\u0004\u0018\u00010\u00052\b\u0010e\u001a\u0004\u0018\u00010dH\u0016J\"\u0010k\u001a\u00020\u00072\u0006\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020;2\b\u0010j\u001a\u0004\u0018\u00010iH\u0016J\u0006\u0010l\u001a\u00020\u0007J\u001a\u0010p\u001a\u00020\u00072\b\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010o\u001a\u00020;H\u0016J\u0012\u0010r\u001a\u00020\u00072\b\u0010q\u001a\u0004\u0018\u00010mH\u0016J\u0012\u0010s\u001a\u00020\u00072\b\u0010q\u001a\u0004\u0018\u00010mH\u0016R\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010vR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010|R\u0018\u0010\u0081\u0001\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010|R\u0018\u0010\u0083\u0001\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010|R\u0018\u0010\u0085\u0001\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010|R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008b\u0001R\u0018\u0010\u0090\u0001\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010|R\u001a\u0010\u0092\u0001\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010|R\u001a\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0098\u0001\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010|R\u001a\u0010\u009a\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0095\u0001R\u001d\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020X0W8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R$\u0010\u00a0\u0001\u001a\u000f\u0012\u0004\u0012\u00020-\u0012\u0005\u0012\u00030\u0093\u00010L8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R#\u0010\u00a3\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001a\u0010\u00a7\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u001a\u0010\u00ab\u0001\u001a\u00030\u00a8\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u001a\u0010\u00af\u0001\u001a\u00030\u00ac\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u0017\u0010\u00b1\u0001\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u0084\u0001R\u0017\u0010\u00b3\u0001\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u0084\u0001R\u0017\u0010\u00b5\u0001\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u0084\u0001R\u0017\u0010\u00b7\u0001\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u0084\u0001R\u001a\u0010\u00bb\u0001\u001a\u00030\u00b8\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u001a\u0010\u00bd\u0001\u001a\u00030\u00b8\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00ba\u0001R\u001a\u0010\u00c1\u0001\u001a\u00030\u00be\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R \u0010\u00c5\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00c2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R%\u0010\u00cb\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00c6\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u0017\u0010\u00ce\u0001\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001R+\u0010\u00d5\u0001\u001a\r \u00d0\u0001*\u0005\u0018\u00010\u00cf\u00010\u00cf\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d1\u0001\u0010\u00d2\u0001\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\u00a8\u0006\u00da\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAIEliminationFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$a;", "Landroid/view/View;", "view", "", "initViews", "Landroid/os/Bundle;", "bundle", "fi", "vi", "xi", "Ji", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/b;", "itemData", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "code", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "errorMsg", "callback", "Ki", WidgetCacheLunarData.YI, "Lcom/tencent/mobileqq/wink/editor/aielimination/model/c;", "info", "qi", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationButtonStatus;", "buttonStatus", "Li", "Hi", "Wi", "contentView", "registerDaTongReportPageId", "path", "", "isInit", "Ui", "isAll", "Ti", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;", "tabName", "Oi", "isCancel", "ni", "mi", "Yh", "Gi", "ki", WidgetCacheLunarData.JI, "si", "Pi", "ri", "Vi", "", "max", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "Lkotlin/Function0;", "onFinish", "Lkotlinx/coroutines/Job;", "ai", "state", "Ii", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "getPageId", "", "", "ii", "elementId", "", QQBrowserActivity.APP_PARAM, "di", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/wink/editor/aielimination/IEditPicEliminateOpCallback;", "Mi", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onViewCreatedAfterPartInit", "getContentLayoutId", "getStatusBarColor", "v", NodeProps.ON_CLICK, "paySource", "pi", "Ni", "oi", "Qi", "Landroid/view/MotionEvent;", "event", "onTouch", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "ci", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "bar", "value", "wd", "seekbar", "uc", "Fd", "Landroidx/constraintlayout/widget/ConstraintLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/constraintlayout/widget/ConstraintLayout;", "eliminationPanel", "D", "eliminationActionLayout", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "ivConfirm", UserInfo.SEX_FEMALE, "ivCancel", "G", "ivUndo", "H", "ivRestore", "I", "compareView", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "compareViewAfterDone", "K", "Landroid/view/View;", "compareImageAfterDone", "L", "compareTextAfterDone", "M", "shareLayout", "N", "backImageView", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "payGuideYellowText", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "yellowDiamondIcon", BdhLogUtil.LogTag.Tag_Req, "eliminateTimesText", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "mParts", "T", "Ljava/util/Map;", "mTabViews", "U", "Lmqq/util/WeakReference;", "opCallback", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;", "V", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleView;", "doodleView", "Landroid/widget/FrameLayout;", "W", "Landroid/widget/FrameLayout;", "doodleViewWrapper", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/b;", "X", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/b;", "mDoodleTouchDetector", "Y", "MIN_PEN", "Z", "MAX_PEN", "a0", "MIN_PEN_WIDTH", "b0", "MAX_PEN_WIDTH", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "c0", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "progressDialog", "d0", "shareDialog", "Lcom/tencent/mobileqq/wink/view/ag;", "e0", "Lcom/tencent/mobileqq/wink/view/ag;", "loadErrorDialog", "Lkotlinx/coroutines/flow/MutableStateFlow;", "f0", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_countInfo", "Lkotlinx/coroutines/flow/StateFlow;", "g0", "Lkotlinx/coroutines/flow/StateFlow;", "gi", "()Lkotlinx/coroutines/flow/StateFlow;", "countInfo", "h0", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "kotlin.jvm.PlatformType", "i0", "Lkotlin/Lazy;", "hi", "()Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAiEliminationViewModel;", "eliminationViewModel", "<init>", "()V", "k0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIEliminationFragment extends ImmersivePartFragment implements View.OnClickListener, View.OnTouchListener, StartPointSeekBar.a {

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private ConstraintLayout eliminationPanel;

    /* renamed from: D, reason: from kotlin metadata */
    private ConstraintLayout eliminationActionLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView ivConfirm;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView ivCancel;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView ivUndo;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView ivRestore;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView compareView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private LinearLayout compareViewAfterDone;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View compareImageAfterDone;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View compareTextAfterDone;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView shareLayout;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ImageView backImageView;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView payGuideYellowText;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView yellowDiamondIcon;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView eliminateTimesText;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private WeakReference<IEditPicEliminateOpCallback> opCallback;

    /* renamed from: V, reason: from kotlin metadata */
    private DoodleView doodleView;

    /* renamed from: W, reason: from kotlin metadata */
    private FrameLayout doodleViewWrapper;

    /* renamed from: X, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b mDoodleTouchDetector;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private QCircleCommonLoadingDialog progressDialog;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private QCircleCommonLoadingDialog shareDialog;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ag loadErrorDialog;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> _countInfo;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> countInfo;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy eliminationViewModel;

    /* renamed from: j0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f318768j0 = new LinkedHashMap();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final List<Part> mParts = new ArrayList();

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Map<AIEliminationTabName, TextView> mTabViews = new LinkedHashMap();

    /* renamed from: Y, reason: from kotlin metadata */
    private final int MIN_PEN = ViewUtils.dip2px(20.0f);

    /* renamed from: Z, reason: from kotlin metadata */
    private final int MAX_PEN = ViewUtils.dip2px(80.0f);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int MIN_PEN_WIDTH = ViewUtils.dip2px(1.0f);

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int MAX_PEN_WIDTH = ViewUtils.dip2px(6.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J>\u0010\r\u001a\u00020\f2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0015\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAIEliminationFragment$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/videocut/model/MediaClip;", "Lkotlin/collections/ArrayList;", "mediaClips", "", "selectIndex", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationScene;", "scene", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkAIEliminationFragment;", "a", "DEFAULT_DEAL_TIME", "I", "", "DELAY_UPDATE_BITMAP_TIME", "J", "", "ELIMINATE_LAYOUT_TAG", "Ljava/lang/String;", "ELIMINATION_TAG", "KEY_IMAGE_PATH", "KEY_IS_APPLY_ELIMINATE", "KEY_MEDIA_CLIP", "KEY_MEDIA_ELIMINATION_MEDIA_CLIP", "KEY_SCENE", "KEY_SELECT_INDEX", "", "MAX_SCALE", UserInfo.SEX_FEMALE, "MIN_SCALE", "SHARE_TAG", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ WinkAIEliminationFragment b(Companion companion, ArrayList arrayList, int i3, AIEliminationScene aIEliminationScene, Bundle bundle, int i16, Object obj) {
            if ((i16 & 8) != 0) {
                bundle = null;
            }
            return companion.a(arrayList, i3, aIEliminationScene, bundle);
        }

        @NotNull
        public final WinkAIEliminationFragment a(@Nullable ArrayList<MediaClip> mediaClips, int selectIndex, @NotNull AIEliminationScene scene, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            WinkAIEliminationFragment winkAIEliminationFragment = new WinkAIEliminationFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList("KEY_MEDIA_CLIP", mediaClips);
            bundle2.putInt("KEY_SELECT_INDEX", selectIndex);
            bundle2.putInt("KEY_SCENE", scene.getScene());
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            winkAIEliminationFragment.setArguments(bundle2);
            return winkAIEliminationFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f318769a;

        static {
            int[] iArr = new int[AIEliminationScene.values().length];
            try {
                iArr[AIEliminationScene.QZONE_HOME_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIEliminationScene.AIO_EDITOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f318769a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/aielimination/WinkAIEliminationFragment$c", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IVasYellowDiamondPay.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f318771b;

        c(int i3) {
            this.f318771b = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkAIEliminationFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Hi();
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("WinkAIEliminationFragment", 1, "onResult  isSuccess=" + isSuccess + ", code=" + code + ", msg=" + msg2);
            if (isSuccess) {
                Handler mainHandler = WinkAIEliminationFragment.this.getMainHandler();
                final WinkAIEliminationFragment winkAIEliminationFragment = WinkAIEliminationFragment.this;
                mainHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkAIEliminationFragment.c.b(WinkAIEliminationFragment.this);
                    }
                }, 2000L);
            }
            WinkAIEliminationFragment.this.hi().U1(this.f318771b, isSuccess ? 1 : 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/aielimination/WinkAIEliminationFragment$d", "Lz53/d;", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/c;", "doodle", "Landroid/graphics/Bitmap;", "maskBitmap", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "callback", "", "c", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements z53.d {
        d() {
        }

        @Override // z53.d
        public void a() {
            WinkAIEliminationFragment.this.Wi();
        }

        @Override // z53.d
        public void b(@Nullable com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c doodle) {
            DoodleView doodleView = WinkAIEliminationFragment.this.doodleView;
            com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b bVar = null;
            if (doodleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                doodleView = null;
            }
            doodleView.setSize((((float) (WinkAIEliminationFragment.this.hi().getCurrentSeekBarValue() / 100)) * (WinkAIEliminationFragment.this.MAX_PEN - WinkAIEliminationFragment.this.MIN_PEN)) + WinkAIEliminationFragment.this.MIN_PEN);
            DoodleView doodleView2 = WinkAIEliminationFragment.this.doodleView;
            if (doodleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                doodleView2 = null;
            }
            doodleView2.setPen(DoodlePen.BRUSH);
            DoodleView doodleView3 = WinkAIEliminationFragment.this.doodleView;
            if (doodleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                doodleView3 = null;
            }
            doodleView3.setShape(DoodleShape.HAND_WRITE);
            DoodleView doodleView4 = WinkAIEliminationFragment.this.doodleView;
            if (doodleView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                doodleView4 = null;
            }
            doodleView4.setColor(new DoodleColor(WinkAIEliminationFragment.this.requireContext().getColor(R.color.f158026d03)));
            com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b bVar2 = WinkAIEliminationFragment.this.mDoodleTouchDetector;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDoodleTouchDetector");
            } else {
                bVar = bVar2;
            }
            z53.c mOnTouchGestureListener = bVar.getMOnTouchGestureListener();
            if (mOnTouchGestureListener != null) {
                mOnTouchGestureListener.n(true);
            }
        }

        @Override // z53.d
        public void c(@Nullable com.tencent.mobileqq.wink.editor.aielimination.doodle.view.c doodle, @Nullable Bitmap maskBitmap, @Nullable Runnable callback) {
            if (maskBitmap != null) {
                WinkAIEliminationFragment winkAIEliminationFragment = WinkAIEliminationFragment.this;
                winkAIEliminationFragment.hi().Y2(maskBitmap);
                winkAIEliminationFragment.Ji();
            }
        }
    }

    public WinkAIEliminationFragment() {
        Lazy lazy;
        MutableStateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._countInfo = MutableStateFlow;
        this.countInfo = MutableStateFlow;
        this.viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAiEliminationViewModel>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$eliminationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAiEliminationViewModel invoke() {
                return (WinkAiEliminationViewModel) WinkAIEliminationFragment.this.getViewModel(WinkAiEliminationViewModel.class);
            }
        });
        this.eliminationViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(final WinkAIEliminationFragment this$0, final RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkEliminationUploadPart", "saveMediaToSystem result " + rFWSaveMediaResultBean.isSuccess);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.m
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIEliminationFragment.Fi(WinkAIEliminationFragment.this, rFWSaveMediaResultBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(WinkAIEliminationFragment this$0, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        boolean z16;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        boolean z17 = true;
        if (rFWSaveMediaResultBean != null && rFWSaveMediaResultBean.isSuccess) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 5;
        } else {
            i3 = 1;
        }
        if (rFWSaveMediaResultBean == null || !rFWSaveMediaResultBean.isSuccess) {
            z17 = false;
        }
        if (z17) {
            i16 = R.string.f240737pz;
        } else {
            i16 = R.string.f240727py;
        }
        QQToast.makeText(context, i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gi() {
        com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b bVar = this.mDoodleTouchDetector;
        ImageView imageView = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoodleTouchDetector");
            bVar = null;
        }
        z53.c mOnTouchGestureListener = bVar.getMOnTouchGestureListener();
        if (mOnTouchGestureListener != null) {
            mOnTouchGestureListener.m(true);
        }
        ConstraintLayout constraintLayout = this.eliminationPanel;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eliminationPanel");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        LinearLayout linearLayout = this.compareViewAfterDone;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = (LinearLayout) Dh(R.id.urv);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        View Dh = Dh(R.id.ury);
        if (Dh != null) {
            Dh.setVisibility(8);
        }
        ConstraintLayout constraintLayout2 = this.eliminationActionLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eliminationActionLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(0);
        ((ImageView) Dh(R.id.f793849m)).setVisibility(4);
        ImageView imageView2 = this.shareLayout;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(4);
        hi().T1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi() {
        w53.b.a("WinkAIEliminationFragment", "refreshEliminateTimes");
        BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new WinkAIEliminationFragment$refreshEliminateTimes$1(this, null), 3, null);
    }

    private final void Ii(String state) {
        ImageView imageView = this.compareView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compareView");
            imageView = null;
        }
        VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_COMPARE);
        Map<String, Object> extParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(extParams, "extParams");
        extParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_AI_ELIMINATION_FUNCTION_PAGE);
        extParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_COMPARE);
        extParams.put(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, state);
        ImageView imageView3 = this.compareView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compareView");
        } else {
            imageView2 = imageView3;
        }
        VideoReport.reportEvent("dt_clck", imageView2, extParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ji() {
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST);
        com.tencent.mobileqq.wink.editor.aielimination.model.b f26 = hi().f2();
        if (f26 == null) {
            return;
        }
        Ki(f26, new WinkAIEliminationFragment$requestAIElimination$1(this));
    }

    private final void Ki(com.tencent.mobileqq.wink.editor.aielimination.model.b itemData, Function4<? super String, ? super Long, ? super com.tencent.mobileqq.wink.editor.aielimination.model.b, ? super String, Unit> callback) {
        AIEliminationTabName aIEliminationTabName;
        WinkEliminateOperatorPart selectedPart = hi().getSelectedPart();
        if (selectedPart != null) {
            aIEliminationTabName = selectedPart.x9();
        } else {
            aIEliminationTabName = null;
        }
        if (aIEliminationTabName == AIEliminationTabName.REMOVE_WATERMARK || hi().getMCurrentMaskPath() != null) {
            hi().U2("request_" + System.currentTimeMillis(), itemData, hi().getMCurrentMaskPath(), callback);
        }
    }

    private final void Li(AIEliminationButtonStatus buttonStatus) {
        hi().d3(buttonStatus);
        WinkEliminateOperatorPart selectedPart = hi().getSelectedPart();
        if (selectedPart != null) {
            selectedPart.I9(buttonStatus);
        }
    }

    private final void Oi(AIEliminationTabName tabName) {
        boolean z16;
        WinkEliminateOperatorPart winkEliminateOperatorPart;
        View view;
        WinkEliminateOperatorPart winkEliminateOperatorPart2;
        AIEliminationTabName aIEliminationTabName;
        float f16;
        for (AIEliminationTabName aIEliminationTabName2 : this.mTabViews.keySet()) {
            TextView textView = this.mTabViews.get(aIEliminationTabName2);
            if (textView != null) {
                if (aIEliminationTabName2 == tabName) {
                    f16 = 1.0f;
                } else {
                    f16 = 0.5f;
                }
                textView.setAlpha(f16);
            }
        }
        View view2 = null;
        WinkEliminateOperatorPart winkEliminateOperatorPart3 = null;
        for (Part part : this.mParts) {
            boolean z17 = part instanceof WinkEliminateOperatorPart;
            if (z17) {
                winkEliminateOperatorPart = (WinkEliminateOperatorPart) part;
            } else {
                winkEliminateOperatorPart = null;
            }
            if (winkEliminateOperatorPart != null) {
                view = winkEliminateOperatorPart.C9();
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            if (z17) {
                winkEliminateOperatorPart2 = (WinkEliminateOperatorPart) part;
            } else {
                winkEliminateOperatorPart2 = null;
            }
            if (winkEliminateOperatorPart2 != null) {
                aIEliminationTabName = winkEliminateOperatorPart2.x9();
            } else {
                aIEliminationTabName = null;
            }
            if (aIEliminationTabName == tabName) {
                winkEliminateOperatorPart3 = (WinkEliminateOperatorPart) part;
            }
        }
        hi().e3(tabName);
        hi().f3(winkEliminateOperatorPart3);
        com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b bVar = this.mDoodleTouchDetector;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoodleTouchDetector");
            bVar = null;
        }
        z53.c mOnTouchGestureListener = bVar.getMOnTouchGestureListener();
        boolean z18 = true;
        if (mOnTouchGestureListener != null) {
            if (tabName != AIEliminationTabName.REMOVE_WATERMARK) {
                z16 = true;
            } else {
                z16 = false;
            }
            mOnTouchGestureListener.m(z16);
        }
        DoodleView doodleView = this.doodleView;
        if (doodleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView = null;
        }
        if (tabName == AIEliminationTabName.REMOVE_WATERMARK) {
            z18 = false;
        }
        doodleView.P(z18);
        if (winkEliminateOperatorPart3 != null) {
            winkEliminateOperatorPart3.I9(hi().getMButtonStatus());
        }
        if (winkEliminateOperatorPart3 != null) {
            view2 = winkEliminateOperatorPart3.C9();
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private final void Pi() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.progressDialog;
        if (qCircleCommonLoadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            qCircleCommonLoadingDialog = null;
        }
        qCircleCommonLoadingDialog.show();
        Vi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(WinkAIEliminationFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AECameraPrefsUtil.c().h(AECameraPrefsUtil.G, true, 0);
        this$0.oi();
    }

    private final void Ti(boolean isAll) {
        com.tencent.mobileqq.wink.editor.aielimination.model.b g36;
        if (isAll) {
            g36 = hi().h3();
        } else {
            g36 = hi().g3();
        }
        hi().k3();
        if (g36 != null) {
            DoodleView doodleView = this.doodleView;
            if (doodleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                doodleView = null;
            }
            doodleView.n();
            Ui(g36.getDstMediaPath(), false);
        }
        Wi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ui(String path, boolean isInit) {
        boolean z16;
        Bitmap bitmap;
        IEditPicEliminateOpCallback iEditPicEliminateOpCallback;
        DoodleView doodleView = null;
        if (isInit && hi().getMScene() == AIEliminationScene.AIO_EDITOR) {
            if (path != null && path.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                WeakReference<IEditPicEliminateOpCallback> weakReference = this.opCallback;
                if (weakReference != null && (iEditPicEliminateOpCallback = weakReference.get()) != null) {
                    bitmap = iEditPicEliminateOpCallback.getOriginBitmap();
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    w53.b.c("WinkAIEliminationFragment", "updateBitmap originBitmap is " + bitmap);
                    Bundle arguments = getArguments();
                    if (arguments != null) {
                        arguments.putString("KEY_IMAGE_PATH", hi().a3(bitmap));
                    }
                    DoodleView doodleView2 = this.doodleView;
                    if (doodleView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                    } else {
                        doodleView = doodleView2;
                    }
                    doodleView.setOriginBitmap(bitmap, true);
                    return;
                }
                w53.b.c("WinkAIEliminationFragment", "originBitmap is empty!!!");
                return;
            }
        }
        try {
            Bitmap decodeFile = SafeBitmapFactory.decodeFile(path);
            w53.b.f("WinkAIEliminationFragment", "path: " + path + ", updateBitmap: " + decodeFile + ", isInit: " + isInit);
            DoodleView doodleView3 = this.doodleView;
            if (doodleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            } else {
                doodleView = doodleView3;
            }
            doodleView.setOriginBitmap(decodeFile, isInit);
        } catch (Exception e16) {
            w53.b.c("WinkAIEliminationFragment", e16.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, kotlinx.coroutines.Job] */
    private final void Vi() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        objectRef.element = bi(this, 100, LifecycleOwnerKt.getLifecycleScope(requireActivity), new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$updateProcessValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
                Job job;
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog2;
                int i16 = i3 == 0 ? 99 : 100 - i3;
                qCircleCommonLoadingDialog = WinkAIEliminationFragment.this.progressDialog;
                if (qCircleCommonLoadingDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
                    qCircleCommonLoadingDialog = null;
                }
                if (qCircleCommonLoadingDialog.isShowing()) {
                    qCircleCommonLoadingDialog2 = WinkAIEliminationFragment.this.progressDialog;
                    if (qCircleCommonLoadingDialog2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
                        qCircleCommonLoadingDialog2 = null;
                    }
                    qCircleCommonLoadingDialog2.setProgress(i16);
                } else {
                    Job job2 = objectRef.element;
                    if (job2 != null) {
                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                    }
                }
                if (i3 != 0 || (job = objectRef.element) == null) {
                    return;
                }
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wi() {
        WinkEliminateOperatorPart winkEliminateOperatorPart;
        boolean z16 = false;
        if (hi().N2()) {
            ImageView imageView = this.compareView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compareView");
                imageView = null;
            }
            imageView.setAlpha(0.5f);
            ImageView imageView2 = this.compareView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compareView");
                imageView2 = null;
            }
            imageView2.setClickable(false);
            View view = this.compareImageAfterDone;
            if (view != null) {
                view.setAlpha(0.5f);
            }
            View view2 = this.compareTextAfterDone;
            if (view2 != null) {
                view2.setAlpha(0.5f);
            }
            LinearLayout linearLayout = this.compareViewAfterDone;
            if (linearLayout != null) {
                linearLayout.setClickable(false);
            }
        } else {
            ImageView imageView3 = this.compareView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compareView");
                imageView3 = null;
            }
            imageView3.setAlpha(1.0f);
            ImageView imageView4 = this.compareView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compareView");
                imageView4 = null;
            }
            imageView4.setClickable(true);
            View view3 = this.compareImageAfterDone;
            if (view3 != null) {
                view3.setAlpha(1.0f);
            }
            View view4 = this.compareTextAfterDone;
            if (view4 != null) {
                view4.setAlpha(1.0f);
            }
            LinearLayout linearLayout2 = this.compareViewAfterDone;
            if (linearLayout2 != null) {
                linearLayout2.setClickable(true);
            }
        }
        if (hi().getMButtonStatus() == AIEliminationButtonStatus.NORMAL) {
            DoodleView doodleView = this.doodleView;
            if (doodleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                doodleView = null;
            }
            if (doodleView.r().isEmpty()) {
                z16 = true;
            }
        }
        for (Part part : this.mParts) {
            if (part instanceof WinkEliminateOperatorPart) {
                winkEliminateOperatorPart = (WinkEliminateOperatorPart) part;
            } else {
                winkEliminateOperatorPart = null;
            }
            if (winkEliminateOperatorPart != null) {
                winkEliminateOperatorPart.M9(!z16);
            }
        }
    }

    private final void Yh(boolean isCancel) {
        DoodleView doodleView = this.doodleView;
        ImageView imageView = null;
        if (doodleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView = null;
        }
        doodleView.n();
        com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b bVar = this.mDoodleTouchDetector;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoodleTouchDetector");
            bVar = null;
        }
        z53.c mOnTouchGestureListener = bVar.getMOnTouchGestureListener();
        if (mOnTouchGestureListener != null) {
            mOnTouchGestureListener.m(false);
        }
        if (isCancel) {
            Ti(true);
        }
        ConstraintLayout constraintLayout = this.eliminationPanel;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eliminationPanel");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = this.eliminationActionLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eliminationActionLayout");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(8);
        View Dh = Dh(R.id.ury);
        if (Dh != null) {
            Dh.setVisibility(0);
        }
        LinearLayout linearLayout = this.compareViewAfterDone;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = (LinearLayout) Dh(R.id.urv);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        ((ImageView) Dh(R.id.f793849m)).setVisibility(0);
        ImageView imageView2 = this.shareLayout;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(0);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.p
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIEliminationFragment.Zh();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh() {
        VideoReport.traverseExposure();
    }

    private final Job ai(int max, CoroutineScope scope, Function1<? super Integer, Unit> onTick, Function0<Unit> onFinish) {
        return FlowKt.launchIn(FlowKt.onCompletion(FlowKt.onEach(FlowKt.flowOn(FlowKt.flow(new WinkAIEliminationFragment$countDownByFlow$1(max, null)), Dispatchers.getMain()), new WinkAIEliminationFragment$countDownByFlow$2(onTick, null)), new WinkAIEliminationFragment$countDownByFlow$3(onFinish, null)), scope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Job bi(WinkAIEliminationFragment winkAIEliminationFragment, int i3, CoroutineScope coroutineScope, Function1 function1, Function0 function0, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            function0 = null;
        }
        return winkAIEliminationFragment.ai(i3, coroutineScope, function1, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ei(WinkAIEliminationFragment winkAIEliminationFragment, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        winkAIEliminationFragment.di(view, str, map);
    }

    private final void fi(Bundle bundle) {
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (companion.l()) {
            return;
        }
        WinkContext b16 = companion.b(bundle);
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, b16.getTraceId());
        companion.o(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAiEliminationViewModel hi() {
        return (WinkAiEliminationViewModel) this.eliminationViewModel.getValue();
    }

    private final void initViews(View view) {
        String h26;
        View findViewById = view.findViewById(R.id.f165063us0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<FrameL\u2026elimination_content_view)");
        this.doodleViewWrapper = (FrameLayout) findViewById;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DoodleView doodleView = null;
        this.doodleView = new DoodleView(requireContext, null, new d());
        FrameLayout frameLayout = this.doodleViewWrapper;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleViewWrapper");
            frameLayout = null;
        }
        DoodleView doodleView2 = this.doodleView;
        if (doodleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView2 = null;
        }
        frameLayout.addView(doodleView2, -1, -1);
        Ui(hi().h2(), true);
        if (hi().e2().c().isEmpty()) {
            WinkAiEliminationViewModel hi5 = hi();
            if (hi5 != null && (h26 = hi5.h2()) != null) {
                hi().L2(h26, null, h26);
            }
        } else if (!Intrinsics.areEqual(hi().h2(), hi().p2())) {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.e
                @Override // java.lang.Runnable
                public final void run() {
                    WinkAIEliminationFragment.wi(WinkAIEliminationFragment.this);
                }
            }, 500L);
        }
        DoodleView doodleView3 = this.doodleView;
        if (doodleView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView3 = null;
        }
        z53.c cVar = new z53.c(doodleView3);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        this.mDoodleTouchDetector = new com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b(requireContext2, cVar);
        DoodleView doodleView4 = this.doodleView;
        if (doodleView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView4 = null;
        }
        com.tencent.mobileqq.wink.editor.aielimination.doodle.view.b bVar = this.mDoodleTouchDetector;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDoodleTouchDetector");
            bVar = null;
        }
        doodleView4.setDefaultTouchDetector(bVar);
        DoodleView doodleView5 = this.doodleView;
        if (doodleView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView5 = null;
        }
        doodleView5.setIsDrawableOutside(false);
        DoodleView doodleView6 = this.doodleView;
        if (doodleView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView6 = null;
        }
        doodleView6.setDoodleMinScale(1.0f);
        DoodleView doodleView7 = this.doodleView;
        if (doodleView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
        } else {
            doodleView = doodleView7;
        }
        doodleView.setDoodleMaxScale(3.0f);
        vi();
        xi(view);
        si();
        yi();
        Wi();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ji(boolean isCancel) {
        boolean z16;
        WeakReference<IEditPicEliminateOpCallback> weakReference;
        Activity hostActivity;
        FragmentActivity fragmentActivity;
        FragmentManager fragmentManager;
        int i3;
        String str;
        FragmentManager.BackStackEntry backStackEntryAt;
        IEditPicEliminateOpCallback iEditPicEliminateOpCallback;
        Bitmap bitmap;
        Bitmap.Config config;
        String str2;
        String str3;
        if (!isCancel) {
            com.tencent.mobileqq.wink.editor.aielimination.model.b f26 = hi().f2();
            if (f26 != null) {
                str2 = f26.getDstMediaPath();
            } else {
                str2 = null;
            }
            com.tencent.mobileqq.wink.editor.aielimination.model.b f27 = hi().f2();
            if (f27 != null) {
                str3 = f27.getOriMediaPath();
            } else {
                str3 = null;
            }
            if (!Intrinsics.areEqual(str2, str3)) {
                z16 = true;
                w53.b.f("WinkAIEliminationFragment", "goBackToAIOFragment isApply: " + z16);
                weakReference = this.opCallback;
                if (weakReference != null && (iEditPicEliminateOpCallback = weakReference.get()) != null) {
                    if (z16) {
                        DoodleView doodleView = this.doodleView;
                        if (doodleView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                            doodleView = null;
                        }
                        Bitmap mBitmap = doodleView.getMBitmap();
                        if (mBitmap != null) {
                            DoodleView doodleView2 = this.doodleView;
                            if (doodleView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                                doodleView2 = null;
                            }
                            Bitmap mBitmap2 = doodleView2.getMBitmap();
                            if (mBitmap2 != null) {
                                config = mBitmap2.getConfig();
                            } else {
                                config = null;
                            }
                            bitmap = mBitmap.copy(config, true);
                            iEditPicEliminateOpCallback.onEliminateResult(z16, bitmap);
                        }
                    }
                    bitmap = null;
                    iEditPicEliminateOpCallback.onEliminateResult(z16, bitmap);
                }
                hostActivity = getHostActivity();
                if (!(hostActivity instanceof FragmentActivity)) {
                    fragmentActivity = (FragmentActivity) hostActivity;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity == null) {
                    fragmentManager = fragmentActivity.getSupportFragmentManager();
                } else {
                    fragmentManager = null;
                }
                if (fragmentManager == null) {
                    i3 = fragmentManager.getBackStackEntryCount();
                } else {
                    i3 = 0;
                }
                for (int i16 = 0; i16 < i3; i16++) {
                    if (fragmentManager != null && (backStackEntryAt = fragmentManager.getBackStackEntryAt(i16)) != null) {
                        str = backStackEntryAt.getName();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, "ELIMINATION_TAG") || Intrinsics.areEqual(str, "ELIMINATE_LAYOUT_TAG")) {
                        fragmentManager.popBackStack();
                    }
                }
            }
        }
        z16 = false;
        w53.b.f("WinkAIEliminationFragment", "goBackToAIOFragment isApply: " + z16);
        weakReference = this.opCallback;
        if (weakReference != null) {
            if (z16) {
            }
            bitmap = null;
            iEditPicEliminateOpCallback.onEliminateResult(z16, bitmap);
        }
        hostActivity = getHostActivity();
        if (!(hostActivity instanceof FragmentActivity)) {
        }
        if (fragmentActivity == null) {
        }
        if (fragmentManager == null) {
        }
        while (i16 < i3) {
        }
    }

    private final void ki(boolean isCancel) {
        MediaClip mediaClip;
        String str;
        String str2;
        ResourceModel resourceModel;
        String str3;
        w53.b.a("WinkAIEliminationFragment", "goBackToWinkEditorFragment isCancel:" + isCancel);
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQWinkConstants.IS_FROM_ELIMINATION, true);
        com.tencent.mobileqq.wink.editor.a aVar = null;
        if (!isCancel) {
            MediaClip d26 = hi().d2();
            if (d26 != null) {
                ResourceModel resourceModel2 = d26.resource;
                if (resourceModel2 != null) {
                    com.tencent.mobileqq.wink.editor.aielimination.model.b f26 = hi().f2();
                    if (f26 != null) {
                        str3 = f26.getDstMediaPath();
                    } else {
                        str3 = null;
                    }
                    resourceModel = ResourceModel.copy$default(resourceModel2, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131069, null);
                } else {
                    resourceModel = null;
                }
                mediaClip = MediaClip.copy$default(d26, resourceModel, null, null, null, null, null, null, 126, null);
            } else {
                mediaClip = null;
            }
            bundle.putSerializable("KEY_MEDIA_ELIMINATION_RESULT", hi().i3(mediaClip));
            bundle.putInt("KEY_SELECT_INDEX", 0);
            com.tencent.mobileqq.wink.editor.aielimination.model.b f27 = hi().f2();
            if (f27 != null) {
                str = f27.getDstMediaPath();
            } else {
                str = null;
            }
            com.tencent.mobileqq.wink.editor.aielimination.model.b f28 = hi().f2();
            if (f28 != null) {
                str2 = f28.getOriMediaPath();
            } else {
                str2 = null;
            }
            bundle.putBoolean("KEY_IS_APPLY_ELIMINATE", !Intrinsics.areEqual(str, str2));
        }
        ActivityResultCaller parentFragment = getParentFragment();
        if (parentFragment instanceof WinkEditorFragment) {
            WinkEditorFragment winkEditorFragment = (WinkEditorFragment) parentFragment;
            if (winkEditorFragment.getArguments() == null) {
                winkEditorFragment.setArguments(new Bundle());
            }
            Bundle arguments = winkEditorFragment.getArguments();
            if (arguments != null) {
                arguments.putAll(bundle);
            }
            if (parentFragment instanceof com.tencent.mobileqq.wink.editor.a) {
                aVar = (com.tencent.mobileqq.wink.editor.a) parentFragment;
            }
            if (aVar != null) {
                aVar.g1(false);
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.i
                @Override // java.lang.Runnable
                public final void run() {
                    WinkAIEliminationFragment.li(WinkAIEliminationFragment.this);
                }
            }, 100L);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(WinkAIEliminationFragment this$0) {
        FragmentManager childFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment != null && (childFragmentManager = parentFragment.getChildFragmentManager()) != null && (beginTransaction = childFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(this$0)) != null) {
            remove.commit();
        }
    }

    private final void mi() {
        int i3 = b.f318769a[hi().getMScene().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                onBackEvent();
                return;
            } else {
                onBackEvent();
                return;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void ni(boolean isCancel) {
        int i3 = b.f318769a[hi().getMScene().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                ki(isCancel);
                return;
            } else {
                ji(isCancel);
                return;
            }
        }
        Yh(isCancel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(com.tencent.mobileqq.wink.editor.aielimination.model.c info) {
        int i3;
        int i16;
        String format;
        boolean z16;
        AIEliminationButtonStatus aIEliminationButtonStatus;
        PBInt32Field pBInt32Field;
        PBInt32Field pBInt32Field2;
        w53.b.a("WinkAIEliminationFragment", "handleUsageInfo: " + info.getPayInfo().text.get() + ", " + info.getPayInfo().desc.get());
        ShadowAIGCStatus$UsageInfo shadowAIGCStatus$UsageInfo = info.b().get(1);
        if (shadowAIGCStatus$UsageInfo != null && (pBInt32Field2 = shadowAIGCStatus$UsageInfo.available) != null) {
            i3 = pBInt32Field2.get();
        } else {
            i3 = 0;
        }
        ShadowAIGCStatus$UsageInfo shadowAIGCStatus$UsageInfo2 = info.b().get(2);
        if (shadowAIGCStatus$UsageInfo2 != null && (pBInt32Field = shadowAIGCStatus$UsageInfo2.available) != null) {
            i16 = pBInt32Field.get();
        } else {
            i16 = 0;
        }
        TextView textView = this.eliminateTimesText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eliminateTimesText");
            textView = null;
        }
        int i17 = i3 + i16;
        if (i17 <= 0) {
            format = getResources().getString(R.string.f240607pm);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.f240597pl);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026i_elimination_count_text)");
            format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i17)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        textView.setText(format);
        if (!hi().O2() && hi().q2() + hi().A2() <= 0) {
            if (hi().D2() > 0) {
                Li(AIEliminationButtonStatus.SHARE);
            } else {
                if (hi().getMScene() != AIEliminationScene.AIO_EDITOR) {
                    aIEliminationButtonStatus = AIEliminationButtonStatus.OPEN_YELLOW_DIAMOND;
                } else {
                    aIEliminationButtonStatus = AIEliminationButtonStatus.NORMAL;
                }
                Li(aIEliminationButtonStatus);
            }
        } else {
            Li(AIEliminationButtonStatus.NORMAL);
        }
        if (hi().getMScene() != AIEliminationScene.AIO_EDITOR) {
            String str = info.getPayInfo().text.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                ImageView imageView = this.yellowDiamondIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
                    imageView = null;
                }
                imageView.setVisibility(8);
                TextView textView3 = this.payGuideYellowText;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                    textView3 = null;
                }
                textView3.setVisibility(8);
            } else {
                ImageView imageView2 = this.yellowDiamondIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
                    imageView2 = null;
                }
                imageView2.setVisibility(0);
                TextView textView4 = this.payGuideYellowText;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                    textView4 = null;
                }
                textView4.setVisibility(0);
                TextView textView5 = this.payGuideYellowText;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                    textView5 = null;
                }
                textView5.setText(info.getPayInfo().text.get());
            }
            ((TextView) Dh(R.id.f228104q)).setText(info.getPayInfo().desc.get());
            if (info.getPayInfo().type.get() == 1) {
                TextView textView6 = this.eliminateTimesText;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eliminateTimesText");
                } else {
                    textView2 = textView6;
                }
                textView2.setVisibility(0);
            } else {
                TextView textView7 = this.eliminateTimesText;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eliminateTimesText");
                } else {
                    textView2 = textView7;
                }
                textView2.setVisibility(8);
            }
        } else {
            TextView textView8 = this.eliminateTimesText;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eliminateTimesText");
            } else {
                textView2 = textView8;
            }
            textView2.setVisibility(0);
        }
        Wi();
    }

    private final void registerDaTongReportPageId(View contentView) {
        Map<String, Object> ii5 = ii();
        w53.b.a("WinkAIEliminationFragment", "registerDaTongReportPageId: " + ii5);
        WinkHomeReportHelper.f326257a.c(getActivity(), contentView, getPageId(), ii5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.progressDialog;
        if (qCircleCommonLoadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            qCircleCommonLoadingDialog = null;
        }
        qCircleCommonLoadingDialog.dismiss();
    }

    private final void si() {
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(getContext()).n(true).p("\u52aa\u529b\u6d88\u9664\u4e2d").j("wink_ai_elimination").a();
        Intrinsics.checkNotNullExpressionValue(a16, "Builder(context)\n       \u2026on\")\n            .build()");
        this.progressDialog = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            a16 = null;
        }
        a16.z0(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aielimination.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkAIEliminationFragment.ti(WinkAIEliminationFragment.this, view);
            }
        });
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.loadErrorDialog = new ab(requireContext, new ag.a() { // from class: com.tencent.mobileqq.wink.editor.aielimination.o
            @Override // com.tencent.mobileqq.wink.view.ag.a
            public final void onRetryClick() {
                WinkAIEliminationFragment.ui(WinkAIEliminationFragment.this);
            }
        });
        QCircleCommonLoadingDialog a17 = new QCircleCommonLoadingDialog.c(getContext()).p("\u52a0\u8f7d\u4e2d").n(false).j("wink_ai_elimination_share").b().a();
        Intrinsics.checkNotNullExpressionValue(a17, "Builder(context)\n       \u2026tn()\n            .build()");
        this.shareDialog = a17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(WinkAIEliminationFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hi().S1();
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST);
        this$0.hi().T2(false, true, -1004);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(WinkAIEliminationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ag agVar = this$0.loadErrorDialog;
        if (agVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadErrorDialog");
            agVar = null;
        }
        agVar.dismiss();
        this$0.Pi();
        this$0.Ji();
    }

    private final void vi() {
        Map<AIEliminationTabName, TextView> map = this.mTabViews;
        AIEliminationTabName aIEliminationTabName = AIEliminationTabName.AI_ELIMINATE;
        TextView elimination_text = (TextView) Dh(R.id.f165066us3);
        Intrinsics.checkNotNullExpressionValue(elimination_text, "elimination_text");
        map.put(aIEliminationTabName, elimination_text);
        if (hi().M2()) {
            ((TextView) Dh(R.id.f72933s7)).setVisibility(0);
            ((TextView) Dh(R.id.f72923s6)).setVisibility(0);
            Map<AIEliminationTabName, TextView> map2 = this.mTabViews;
            AIEliminationTabName aIEliminationTabName2 = AIEliminationTabName.REMOVE_WATERMARK;
            TextView remove_watermark = (TextView) Dh(R.id.f72933s7);
            Intrinsics.checkNotNullExpressionValue(remove_watermark, "remove_watermark");
            map2.put(aIEliminationTabName2, remove_watermark);
            Map<AIEliminationTabName, TextView> map3 = this.mTabViews;
            AIEliminationTabName aIEliminationTabName3 = AIEliminationTabName.REMOVE_TEXT;
            TextView remove_text = (TextView) Dh(R.id.f72923s6);
            Intrinsics.checkNotNullExpressionValue(remove_text, "remove_text");
            map3.put(aIEliminationTabName3, remove_text);
            TextView textView = (TextView) Dh(R.id.f165066us3);
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = (TextView) Dh(R.id.f72933s7);
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            TextView textView3 = (TextView) Dh(R.id.f72923s6);
            if (textView3 != null) {
                textView3.setOnClickListener(this);
            }
        } else {
            ((TextView) Dh(R.id.f72933s7)).setVisibility(8);
            ((TextView) Dh(R.id.f72923s6)).setVisibility(8);
        }
        TextView elimination_text2 = (TextView) Dh(R.id.f165066us3);
        Intrinsics.checkNotNullExpressionValue(elimination_text2, "elimination_text");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tab_name", Integer.valueOf(aIEliminationTabName.getTabName()));
        Unit unit = Unit.INSTANCE;
        di(elimination_text2, WinkDaTongReportConstant.ElementId.EM_BAS_SMUDGE_ERASE_TAB, linkedHashMap);
        TextView remove_watermark2 = (TextView) Dh(R.id.f72933s7);
        Intrinsics.checkNotNullExpressionValue(remove_watermark2, "remove_watermark");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("tab_name", Integer.valueOf(AIEliminationTabName.REMOVE_WATERMARK.getTabName()));
        di(remove_watermark2, WinkDaTongReportConstant.ElementId.EM_BAS_SMUDGE_ERASE_TAB, linkedHashMap2);
        TextView remove_text2 = (TextView) Dh(R.id.f72923s6);
        Intrinsics.checkNotNullExpressionValue(remove_text2, "remove_text");
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("tab_name", Integer.valueOf(AIEliminationTabName.REMOVE_TEXT.getTabName()));
        di(remove_text2, WinkDaTongReportConstant.ElementId.EM_BAS_SMUDGE_ERASE_TAB, linkedHashMap3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(WinkAIEliminationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ui(this$0.hi().p2(), false);
    }

    private final void xi(View view) {
        String str;
        View findViewById = view.findViewById(R.id.f165064us1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.e\u2026ation_navigate_container)");
        this.eliminationPanel = (ConstraintLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.urz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.e\u2026ination_action_container)");
        this.eliminationActionLayout = (ConstraintLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.xyk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ivConfirm)");
        this.ivConfirm = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.xyi);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.ivCancel)");
        this.ivCancel = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R.id.xzj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.ivUndo)");
        this.ivUndo = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.xyx);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.ivRestore)");
        this.ivRestore = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.xyj);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.ivCompare)");
        this.compareView = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.ir5);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.share_icon)");
        this.shareLayout = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.f228204r);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.pay_guide_yellow)");
        this.payGuideYellowText = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.f125827n4);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.yellow_diamond_icon)");
        this.yellowDiamondIcon = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.urw);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.eliminate_times)");
        this.eliminateTimesText = (TextView) findViewById11;
        TextView textView = (TextView) Dh(R.id.f165066us3);
        if (textView != null) {
            if (hi().getMScene() == AIEliminationScene.AIO_EDITOR && !hi().M2()) {
                str = "AI\u6d88\u9664";
            } else {
                str = "\u6d82\u62b9\u6d88\u9664";
            }
            textView.setText(str);
        }
        ImageView imageView = this.ivConfirm;
        TextView textView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivConfirm");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.ivCancel;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCancel");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.ivUndo;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
            imageView3 = null;
        }
        imageView3.setOnClickListener(this);
        ImageView imageView4 = this.compareView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compareView");
            imageView4 = null;
        }
        imageView4.setOnTouchListener(this);
        ImageView imageView5 = this.ivRestore;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
            imageView5 = null;
        }
        imageView5.setOnClickListener(this);
        ImageView imageView6 = this.shareLayout;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            imageView6 = null;
        }
        imageView6.setOnClickListener(this);
        TextView textView3 = this.payGuideYellowText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        ImageView imageView7 = this.yellowDiamondIcon;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
            imageView7 = null;
        }
        imageView7.setOnClickListener(this);
        ((ImageView) Dh(R.id.f793849m)).setOnClickListener(this);
        ((LinearLayout) Dh(R.id.urv)).setOnClickListener(this);
        if (hi().getMScene() == AIEliminationScene.QZONE_HOME_PAGE) {
            this.compareViewAfterDone = (LinearLayout) view.findViewById(R.id.u2q);
            this.compareImageAfterDone = view.findViewById(R.id.u2p);
            this.compareTextAfterDone = view.findViewById(R.id.u2r);
            LinearLayout linearLayout = this.compareViewAfterDone;
            if (linearLayout != null) {
                linearLayout.setOnTouchListener(this);
            }
            ImageView imageView8 = (ImageView) view.findViewById(R.id.t2q);
            this.backImageView = imageView8;
            if (imageView8 != null) {
                imageView8.setOnClickListener(this);
            }
            ImageView imageView9 = this.backImageView;
            if (imageView9 != null) {
                imageView9.setVisibility(0);
            }
        }
        if (hi().getMScene() == AIEliminationScene.AIO_EDITOR) {
            TextView textView4 = this.payGuideYellowText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payGuideYellowText");
                textView4 = null;
            }
            textView4.setVisibility(8);
            ((TextView) Dh(R.id.f228104q)).setVisibility(8);
            ImageView imageView10 = this.yellowDiamondIcon;
            if (imageView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yellowDiamondIcon");
                imageView10 = null;
            }
            imageView10.setVisibility(8);
            ImageView imageView11 = this.shareLayout;
            if (imageView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
                imageView11 = null;
            }
            imageView11.setVisibility(8);
            TextView textView5 = this.eliminateTimesText;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eliminateTimesText");
            } else {
                textView2 = textView5;
            }
            textView2.setVisibility(0);
        }
        Gi();
    }

    private final void yi() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new WinkAIEliminationFragment$observerLiveData$1(this, null));
        LiveData<Boolean> G2 = hi().G2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$observerLiveData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                ImageView imageView4;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ImageView imageView5 = null;
                if (it.booleanValue()) {
                    imageView3 = WinkAIEliminationFragment.this.ivUndo;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                        imageView3 = null;
                    }
                    imageView3.setAlpha(1.0f);
                    imageView4 = WinkAIEliminationFragment.this.ivUndo;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                    } else {
                        imageView5 = imageView4;
                    }
                    imageView5.setClickable(true);
                    return;
                }
                imageView = WinkAIEliminationFragment.this.ivUndo;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                    imageView = null;
                }
                imageView.setAlpha(0.5f);
                imageView2 = WinkAIEliminationFragment.this.ivUndo;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
                } else {
                    imageView5 = imageView2;
                }
                imageView5.setClickable(false);
            }
        };
        G2.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.aielimination.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIEliminationFragment.Di(Function1.this, obj);
            }
        });
        LiveData<Boolean> F2 = hi().F2();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$observerLiveData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                ImageView imageView4;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ImageView imageView5 = null;
                if (it.booleanValue()) {
                    imageView3 = WinkAIEliminationFragment.this.ivRestore;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                        imageView3 = null;
                    }
                    imageView3.setAlpha(1.0f);
                    imageView4 = WinkAIEliminationFragment.this.ivRestore;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                    } else {
                        imageView5 = imageView4;
                    }
                    imageView5.setClickable(true);
                    return;
                }
                imageView = WinkAIEliminationFragment.this.ivRestore;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                    imageView = null;
                }
                imageView.setAlpha(0.5f);
                imageView2 = WinkAIEliminationFragment.this.ivRestore;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
                } else {
                    imageView5 = imageView2;
                }
                imageView5.setClickable(false);
            }
        };
        F2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.aielimination.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIEliminationFragment.zi(Function1.this, obj);
            }
        });
        LiveData<Boolean> E2 = hi().E2();
        LifecycleOwner lifecycleOwner3 = getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$observerLiveData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    WinkAIEliminationFragment.this.Gi();
                }
            }
        };
        E2.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.editor.aielimination.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIEliminationFragment.Ai(Function1.this, obj);
            }
        });
        LiveData<Long> B2 = hi().B2();
        LifecycleOwner lifecycleOwner4 = getLifecycleOwner();
        final Function1<Long, Unit> function14 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$observerLiveData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                if ((l3 != null && l3.longValue() == 7003) || (l3 != null && l3.longValue() == 0)) {
                    QQToast.makeText(WinkAIEliminationFragment.this.getContext(), 5, (l3 != null && l3.longValue() == 7003) ? R.string.f240767q2 : R.string.f240777q3, 0).show();
                }
                WinkAIEliminationFragment.this.Hi();
            }
        };
        B2.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.wink.editor.aielimination.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIEliminationFragment.Bi(Function1.this, obj);
            }
        });
        LiveData<Long> l26 = hi().l2();
        LifecycleOwner lifecycleOwner5 = getLifecycleOwner();
        final Function1<Long, Unit> function15 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$observerLiveData$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                if (l3 != null && l3.longValue() == 0) {
                    WinkAIEliminationFragment.this.Hi();
                }
            }
        };
        l26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.wink.editor.aielimination.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIEliminationFragment.Ci(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Nullable
    public View Dh(int i3) {
        View findViewById;
        Map<Integer, View> map = this.f318768j0;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View view2 = getView();
            if (view2 != null && (findViewById = view2.findViewById(i3)) != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
    public void Fd(@Nullable StartPointSeekBar seekbar) {
        double d16;
        DoodleView doodleView = this.doodleView;
        if (doodleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView = null;
        }
        doodleView.Q();
        WinkAiEliminationViewModel hi5 = hi();
        if (seekbar != null) {
            d16 = seekbar.h();
        } else {
            d16 = 25.0d;
        }
        hi5.c3(d16);
    }

    public final void Mi(@Nullable WeakReference<IEditPicEliminateOpCallback> callback) {
        w53.b.f("WinkAIEliminationFragment", "setCallback...");
        this.opCallback = callback;
    }

    public final void Ni() {
        boolean z16;
        Map<String, String> d16;
        if (FastClickUtils.isFastDoubleClick("WinkAIEliminationFragment_Share")) {
            return;
        }
        ConstraintLayout constraintLayout = this.eliminationPanel;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eliminationPanel");
            constraintLayout = null;
        }
        boolean z17 = true;
        if (constraintLayout.getVisibility() != 0) {
            com.tencent.mobileqq.wink.editor.aielimination.model.b f26 = hi().f2();
            if (f26 != null && (d16 = f26.d()) != null && (!d16.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = false;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new WinkAIEliminationFragment$shareEvent$1$1(z17, this, activity, null), 3, null);
        }
    }

    public final boolean Qi() {
        if (AECameraPrefsUtil.c().b(AECameraPrefsUtil.G, false, 0)) {
            return true;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(getString(R.string.f240717px));
        createCustomDialog.setMessage(getString(R.string.f240707pw));
        createCustomDialog.setPositiveButton(getString(R.string.f240697pv), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aielimination.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkAIEliminationFragment.Ri(WinkAIEliminationFragment.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(getString(R.string.f239057lf), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aielimination.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkAIEliminationFragment.Si(dialogInterface, i3);
            }
        });
        try {
            if (!createCustomDialog.isShowing()) {
                createCustomDialog.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return false;
    }

    public void _$_clearFindViewByIdCache() {
        this.f318768j0.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        this.mParts.add(new WinkEliminationUploadPart());
        this.mParts.add(new com.tencent.mobileqq.wink.editor.aielimination.b());
        if (hi().M2()) {
            this.mParts.add(new com.tencent.mobileqq.wink.editor.aielimination.d());
            this.mParts.add(new com.tencent.mobileqq.wink.editor.aielimination.c());
        }
        return this.mParts;
    }

    public final void ci() {
        hi().V2();
    }

    public final void di(@NotNull View view, @NotNull String elementId, @Nullable Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (extraParams != null) {
            buildElementParams.putAll(extraParams);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hcp;
    }

    @NotNull
    public final String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_AI_ELIMINATION_FUNCTION_PAGE;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @NotNull
    public final StateFlow<com.tencent.mobileqq.wink.editor.aielimination.model.c> gi() {
        return this.countInfo;
    }

    @NotNull
    public final Map<String, Object> ii() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(hi().getMScene().getScene()));
        Integer prePageSource = hi().getPrePageSource();
        if (prePageSource != null) {
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.SUB_SOURCE_ID, Integer.valueOf(prePageSource.intValue()));
        }
        linkedHashMap.put("pgid", getPageId());
        linkedHashMap.put("qq_pgid", getPageId());
        return linkedHashMap;
    }

    public final void oi() {
        AIEliminationTabName aIEliminationTabName;
        boolean z16;
        WinkEliminateOperatorPart selectedPart = hi().getSelectedPart();
        DoodleView doodleView = null;
        if (selectedPart != null) {
            aIEliminationTabName = selectedPart.x9();
        } else {
            aIEliminationTabName = null;
        }
        if (aIEliminationTabName == AIEliminationTabName.REMOVE_WATERMARK) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            DoodleView doodleView2 = this.doodleView;
            if (doodleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                doodleView2 = null;
            }
            if (doodleView2.r().isEmpty()) {
                QCircleToast.k(QCircleToast.f91644d, getString(R.string.f240577pj), 0, true);
                return;
            }
        }
        if (Qi()) {
            if (hi().getMScene() == AIEliminationScene.AIO_EDITOR && hi().A2() + hi().q2() <= 0) {
                QQToast.makeText(getContext(), R.string.f240807q6, 0).show();
                return;
            }
            Pi();
            if (z16) {
                Ji();
                return;
            }
            DoodleView doodleView3 = this.doodleView;
            if (doodleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            } else {
                doodleView = doodleView3;
            }
            doodleView.N();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        w53.b.f("WinkAIEliminationFragment", "onActivityResult: requestCode: " + requestCode + ", resultCode: " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 52133:
                case 52135:
                    ci();
                    return;
                case 52134:
                    boolean z16 = false;
                    if (data != null && data.getIntExtra("PUBLISH_RESULT_CODE", 0) == 1) {
                        z16 = true;
                    }
                    if (z16) {
                        ci();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        DoodleView doodleView = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        boolean z16 = false;
        if (num != null && num.intValue() == R.id.xyk) {
            ni(false);
        } else if (num != null && num.intValue() == R.id.xyi) {
            ni(true);
        } else if (num != null && num.intValue() == R.id.xzj) {
            Ti(false);
        } else if (num != null && num.intValue() == R.id.xyx) {
            com.tencent.mobileqq.wink.editor.aielimination.model.b S2 = hi().S2();
            hi().k3();
            if (S2 != null) {
                DoodleView doodleView2 = this.doodleView;
                if (doodleView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("doodleView");
                } else {
                    doodleView = doodleView2;
                }
                doodleView.n();
                Ui(S2.getDstMediaPath(), false);
            }
            Wi();
        } else if (num != null && num.intValue() == R.id.ir5) {
            Ni();
        } else if (num != null && num.intValue() == R.id.t2q) {
            mi();
        } else {
            if ((num != null && num.intValue() == R.id.f125827n4) || (num != null && num.intValue() == R.id.f228204r)) {
                z16 = true;
            }
            if (z16) {
                pi(4);
            } else if (num != null && num.intValue() == R.id.urv) {
                hi().I2();
            } else if (num != null && num.intValue() == R.id.f793849m) {
                try {
                    RFWSaveUtil.insertMedia(BaseApplication.context, hi().p2(), new Consumer() { // from class: com.tencent.mobileqq.wink.editor.aielimination.l
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            WinkAIEliminationFragment.Ei(WinkAIEliminationFragment.this, (RFWSaveMediaResultBean) obj);
                        }
                    });
                } catch (Exception e16) {
                    w53.b.d("WinkEliminationUploadPart", "downloadUrlAndSaveToSystem save failed", e16);
                }
            } else if (num != null && num.intValue() == R.id.f165066us3) {
                Oi(AIEliminationTabName.AI_ELIMINATE);
            } else if (num != null && num.intValue() == R.id.f72933s7) {
                Oi(AIEliminationTabName.REMOVE_WATERMARK);
            } else if (num != null && num.intValue() == R.id.f72923s6) {
                Oi(AIEliminationTabName.REMOVE_TEXT);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        w53.b.a("WinkAIEliminationFragment", "arguments: " + getArguments());
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        Bundle extras = getHostActivity().getIntent().getExtras();
        if (extras != null) {
            arguments.putAll(extras);
        }
        fi(arguments);
        hi().K2(getArguments());
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        w53.b.a("WinkAIEliminationFragment", "onDestroy...");
        super.onDestroy();
        this.opCallback = null;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        w53.b.a("WinkAIEliminationFragment", "currentTraceId: " + hi().getCurrentTraceId());
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext h16 = companion.h(hi().getCurrentTraceId());
        if (h16 != null) {
            companion.o(h16);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        Integer num;
        String str;
        Integer num2;
        boolean z16;
        DoodleView doodleView = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.u2q) {
            LinearLayout linearLayout = this.compareViewAfterDone;
            if (linearLayout != null && !linearLayout.isClickable()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return false;
            }
            str = "2";
        } else {
            if (num == null || num.intValue() != R.id.xyj) {
                return false;
            }
            ImageView imageView = this.compareView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compareView");
                imageView = null;
            }
            if (!imageView.isClickable()) {
                return false;
            }
            str = "1";
        }
        if (event != null) {
            num2 = Integer.valueOf(event.getAction());
        } else {
            num2 = null;
        }
        if (num2 != null && num2.intValue() == 0) {
            Ii(str);
            DoodleView doodleView2 = this.doodleView;
            if (doodleView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            } else {
                doodleView = doodleView2;
            }
            doodleView.E(true);
        } else if (num2 != null && num2.intValue() == 1) {
            DoodleView doodleView3 = this.doodleView;
            if (doodleView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            } else {
                doodleView = doodleView3;
            }
            doodleView.E(false);
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        Intrinsics.checkNotNullParameter(view, "view");
        initViews(view);
        registerDaTongReportPageId(view);
        ImageView imageView6 = this.ivConfirm;
        ImageView imageView7 = null;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivConfirm");
            imageView = null;
        } else {
            imageView = imageView6;
        }
        ei(this, imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_COMPLETE, null, 4, null);
        ImageView imageView8 = this.ivCancel;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCancel");
            imageView2 = null;
        } else {
            imageView2 = imageView8;
        }
        ei(this, imageView2, WinkDaTongReportConstant.ElementId.EM_XSJ_CLOSE, null, 4, null);
        ImageView imageView9 = this.ivUndo;
        if (imageView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivUndo");
            imageView3 = null;
        } else {
            imageView3 = imageView9;
        }
        ei(this, imageView3, WinkDaTongReportConstant.ElementId.EM_XSJ_RETURN_BACK, null, 4, null);
        ImageView imageView10 = this.ivRestore;
        if (imageView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRestore");
            imageView4 = null;
        } else {
            imageView4 = imageView10;
        }
        ei(this, imageView4, WinkDaTongReportConstant.ElementId.EM_XSJ_RETURN_NEXT, null, 4, null);
        ImageView imageView11 = this.shareLayout;
        if (imageView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            imageView5 = null;
        } else {
            imageView5 = imageView11;
        }
        ei(this, imageView5, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE_BTN, null, 4, null);
        ImageView save_icon = (ImageView) Dh(R.id.f793849m);
        Intrinsics.checkNotNullExpressionValue(save_icon, "save_icon");
        ei(this, save_icon, WinkDaTongReportConstant.ElementId.EM_XSJ_SAVE, null, 4, null);
        LinearLayout eliminate_continue = (LinearLayout) Dh(R.id.urv);
        Intrinsics.checkNotNullExpressionValue(eliminate_continue, "eliminate_continue");
        ei(this, eliminate_continue, WinkDaTongReportConstant.ElementId.EM_XSJ_CONTINUE_SMEAR, null, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, "1");
        ImageView imageView12 = this.compareView;
        if (imageView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compareView");
        } else {
            imageView7 = imageView12;
        }
        di(imageView7, WinkDaTongReportConstant.ElementId.EM_XSJ_COMPARE, linkedHashMap);
        LinearLayout linearLayout = this.compareViewAfterDone;
        if (linearLayout != null) {
            new LinkedHashMap().put(WinkDaTongReportConstant.ElementParamKey.BUTTON_STATE, "2");
            ei(this, linearLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_COMPARE, null, 4, null);
        }
        Hi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        Oi(hi().getSelectTabName());
    }

    public final void pi(int paySource) {
        WinkAiEliminationViewModel hi5 = hi();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        hi5.R2(hostActivity, new c(paySource));
    }

    @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
    public void wd(@Nullable StartPointSeekBar bar, int value) {
        float f16 = value / 100.0f;
        int i3 = this.MAX_PEN;
        float f17 = ((i3 - r0) * f16) + this.MIN_PEN;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f17);
        w53.b.a("WinkAIEliminationFragment", sb5.toString());
        DoodleView doodleView = this.doodleView;
        DoodleView doodleView2 = null;
        if (doodleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
            doodleView = null;
        }
        doodleView.setSize(f17);
        float f18 = f16 * (this.MAX_PEN_WIDTH - this.MIN_PEN_WIDTH);
        DoodleView doodleView3 = this.doodleView;
        if (doodleView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doodleView");
        } else {
            doodleView2 = doodleView3;
        }
        doodleView2.p(f17 / 2, f18);
    }

    @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
    public void uc(@Nullable StartPointSeekBar seekbar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(DialogInterface dialogInterface, int i3) {
    }
}
