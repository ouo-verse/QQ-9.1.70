package com.tencent.sqshow.zootopia.avatar.filament.anim;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.FilamentAnimationHelper;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u008a\u00022\u00020\u0001:\u0002\u0085\u0001B\t\u00a2\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J-\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J(\u0010\u001c\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0014\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010 \u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J=\u0010,\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002\u00a2\u0006\u0004\b,\u0010-J1\u0010.\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002\u00a2\u0006\u0004\b.\u0010/J9\u00100\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002\u00a2\u0006\u0004\b0\u0010-J$\u00101\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002J#\u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J%\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u0001042\u0006\u0010'\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J'\u00109\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J1\u0010;\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002\u00a2\u0006\u0004\b;\u0010/J'\u0010<\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010:J/\u0010=\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010>J1\u0010?\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002\u00a2\u0006\u0004\b?\u0010/J/\u0010@\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010>J\b\u0010A\u001a\u00020\u0006H\u0002J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020BH\u0002J'\u0010E\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bE\u0010:J1\u0010F\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002\u00a2\u0006\u0004\bF\u0010/J/\u0010G\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010>J1\u0010H\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0002\u00a2\u0006\u0004\bH\u0010/J'\u0010I\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010:J/\u0010J\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010>J\u0012\u0010L\u001a\u0004\u0018\u00010K2\u0006\u0010'\u001a\u00020&H\u0002J(\u0010O\u001a\u00020\u00122\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001042\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u000104H\u0002J$\u0010S\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001042\b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010R\u001a\u0004\u0018\u00010PH\u0002J\u001a\u0010V\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020&0T2\u0006\u0010U\u001a\u00020PH\u0002J\u0018\u0010X\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u0012H\u0002J\b\u0010Y\u001a\u00020\nH\u0016J\u000e\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020&J\u000e\u0010^\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\\J\u000e\u0010a\u001a\u00020\u00062\u0006\u0010`\u001a\u00020_J\u000e\u0010b\u001a\u00020\u00062\u0006\u0010`\u001a\u00020_J\u0006\u0010c\u001a\u00020\u0012J7\u0010d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\bd\u0010-J\u000e\u0010e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ&\u0010g\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010f\u001a\u00020\u0012J(\u0010h\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\b\u0010i\u001a\u0004\u0018\u00010\u0016J\u0006\u0010j\u001a\u00020\u0006J\u0006\u0010k\u001a\u00020\u0006J\u0006\u0010l\u001a\u00020\u0006J\u0013\u0010m\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u00108J=\u0010s\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u000b\u001a\u00020n2\u0006\u0010o\u001a\u00020B2\u0006\u0010p\u001a\u00020B2\u0006\u0010r\u001a\u00020qH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010tJ\"\u0010u\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*J\u0010\u0010w\u001a\u0004\u0018\u00010\u00162\u0006\u0010v\u001a\u00020\u0012J\u0010\u0010x\u001a\u0004\u0018\u00010\u00162\u0006\u0010v\u001a\u00020\u0012J\u0006\u0010y\u001a\u00020\u0006J\u000e\u0010{\u001a\u00020\u00062\u0006\u0010z\u001a\u00020BJ\u000e\u0010|\u001a\u00020\u00062\u0006\u0010z\u001a\u00020BJ\u001a\u0010}\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*J\n\u0010~\u001a\u00020B*\u00020BJ4\u0010\u0080\u0001\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00100(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0016\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J)\u0010\u0083\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0082\u0001\u0018\u00010(2\u0006\u0010\u000b\u001a\u00020n2\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010jR!\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R!\u0010\u0092\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u008f\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0094\u0001R\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0094\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u0094\u0001R+\u0010\u00a0\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00160\u009c\u0001j\t\u0012\u0004\u0012\u00020\u0016`\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001b\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u0094\u0001R*\u0010\u00a3\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00160\u009c\u0001j\t\u0012\u0004\u0012\u00020\u0016`\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b`\u0010\u009f\u0001R\u001b\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u0094\u0001R \u0010\u00a9\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u00a6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001b\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u0094\u0001R \u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u00a6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00a8\u0001R\u001b\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u0094\u0001R/\u0010\u00b1\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u009c\u0001j\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u009f\u0001R\u0018\u0010\u00b5\u0001\u001a\u00030\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R)\u0010\u00ba\u0001\u001a\u0014\u0012\u0004\u0012\u00020_0\u00b6\u0001j\t\u0012\u0004\u0012\u00020_`\u00b7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u0019\u0010\u00bd\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001R\u0019\u0010\u00bf\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u00bc\u0001R\u001b\u0010\u00c2\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u00c1\u0001R\u001b\u0010\u00c5\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u001b\u0010\u00c7\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u0094\u0001R$\u0010\u00cb\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00c8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c9\u0001\u0010\u00ca\u0001R+\u0010\u00d2\u0001\u001a\u0004\u0018\u00010\\8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001\u001a\u0006\b\u00ce\u0001\u0010\u00cf\u0001\"\u0006\b\u00d0\u0001\u0010\u00d1\u0001R\u0018\u0010\u00d4\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d3\u0001\u0010jR\u0018\u0010\u00d6\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d5\u0001\u0010jR(\u0010\u00db\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00bc\u0001\u0010j\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001\"\u0006\b\u00d9\u0001\u0010\u00da\u0001R\u0017\u0010v\u001a\u00030\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00b4\u0001R\u0016\u0010\u00de\u0001\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u00dd\u0001\u0010jR\u001b\u0010\u00e1\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00df\u0001\u0010\u00e0\u0001R(\u0010r\u001a\u00020q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e2\u0001\u0010\u00e3\u0001\u001a\u0006\b\u00e4\u0001\u0010\u00e5\u0001\"\u0006\b\u00e6\u0001\u0010\u00e7\u0001R,\u0010\u00ef\u0001\u001a\u0005\u0018\u00010\u00e8\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e9\u0001\u0010\u00ea\u0001\u001a\u0006\b\u00eb\u0001\u0010\u00ec\u0001\"\u0006\b\u00ed\u0001\u0010\u00ee\u0001R\u0018\u0010\u00f3\u0001\u001a\u00030\u00f0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u00f2\u0001R \u0010\u00f9\u0001\u001a\u00030\u00f4\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00f5\u0001\u0010\u00f6\u0001\u001a\u0006\b\u00f7\u0001\u0010\u00f8\u0001R\u001b\u0010\u00fc\u0001\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fa\u0001\u0010\u00fb\u0001R\u001b\u0010\u00fe\u0001\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fd\u0001\u0010\u00fb\u0001R\u0019\u0010\u0080\u0002\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ff\u0001\u0010\u00bc\u0001R'\u0010\u0087\u0002\u001a\r \u0082\u0002*\u0005\u0018\u00010\u0081\u00020\u0081\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u0083\u0002\u0010\u0084\u0002\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008b\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "c0", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimType;", "type", "", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", "path", "y0", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "animAction", "", "isLoop", "x0", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lcom/tencent/filament/zplan/animation/ZPlanAction;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/filament/zplan/animation/b;", "animData", "q0", "", "now", "animInterval", "V0", "c1", "Z0", "b1", "X0", "Y0", "d1", "W0", "S0", "T0", "Lorg/json/JSONObject;", "avatarPbJson", "", "actionArray", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "v0", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lorg/json/JSONObject;[Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "D0", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;[Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)V", "E0", "K0", "J0", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "g0", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "F0", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lcom/tencent/zplan/zplantracing/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "O0", "H0", "G0", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;Lorg/json/JSONObject;Lcom/tencent/zplan/zplantracing/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P0", "I0", "U", "", "errorMsg", "Q0", "z0", "M0", "A0", "N0", "B0", "C0", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/b;", "f0", "randomAnimPathMale", "randomAnimPathFemale", "W", "Lorg/json/JSONArray;", "headJSONArray", "bodyJSONArray", "Y", "", HippyControllerProps.ARRAY, "X", "preIsFemale", "r0", "h0", "avatarInfo", "g1", "Lcom/tencent/sqshow/zootopia/avatar/filament/i;", "executor", "T", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/f;", "l", ExifInterface.LATITUDE_SOUTH, "f1", "l0", "u0", "e1", "isHandHeldItem", "t0", "s0", "i0", "Z", ICustomDataEditor.NUMBER_PARAM_1, "o1", "U0", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "facePath", "bodyPath", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "d0", "(Lcom/tencent/zplan/zplantracing/c;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b0", "isFemale", "n0", "k0", "j1", "camera", "i1", "h1", "L0", "p1", "animations", "q1", "(Lcom/tencent/filament/zplan/engine/FilamentViewerV2;[Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/zplan/zplantracing/c;)Lcom/tencent/filament/zplan/animation/b;", "Lcom/tencent/filament/zplan/data/FetchActionData;", "j0", "(Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Lorg/json/JSONObject;)[Lcom/tencent/filament/zplan/data/FetchActionData;", "a", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimType;", "mAnimType", "Lcom/tencent/zplan/zplantracing/b;", "b", "Lcom/tencent/zplan/zplantracing/b;", "drawSpan", "c", "hasPlayAnimationWithTrackGroup", "d", "Ljava/util/List;", "mRandomHandHeldAnimPathMale", "e", "mRandomHandHeldAnimPathFemale", "f", "Lcom/tencent/filament/zplan/animation/b;", "mInitAnimMale", "g", "mInitAnimFemale", h.F, "mInitHandHeldAnimMale", "i", "mInitHandHeldAnimFemale", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "Ljava/util/ArrayList;", "mDefaultRandomAnimMaleList", "k", "mDefaultRandomAnimMale", "mDefaultRandomAnimFemaleList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mDefaultRandomAnimFemale", "Ljava/util/concurrent/CopyOnWriteArrayList;", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/CopyOnWriteArrayList;", "mRandomHandHeldAnimMaleList", "o", "mRandomHandHeldAnimMale", "p", "mRandomHandHeldAnimFemaleList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mRandomHandHeldAnimFemale", "r", "mMeshAnimList", "Ljava/util/concurrent/atomic/AtomicBoolean;", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/concurrent/atomic/AtomicBoolean;", "mInitAnimLoadSucceed", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "t", "Ljava/util/HashSet;", "mListener", "u", "D", "mAnimBeginTime", "v", "mMeshAnimBeginTime", "w", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", "mDressAnimPath", HippyTKDListViewAdapter.X, "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "mDressAnimAction", "y", "mDressAnim", "Lkotlinx/coroutines/Deferred;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lkotlinx/coroutines/Deferred;", "mDressAnimResJob", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/sqshow/zootopia/avatar/filament/i;", "m0", "()Lcom/tencent/sqshow/zootopia/avatar/filament/i;", "setMTaskExecutor", "(Lcom/tencent/sqshow/zootopia/avatar/filament/i;)V", "mTaskExecutor", "B", "mHasHandHeldItem", BdhLogUtil.LogTag.Tag_Conn, "mHasHandHeldRandomAnim", "getShowHandHeldItem", "()Z", "l1", "(Z)V", "showHandHeldItem", "E", UserInfo.SEX_FEMALE, "doNotResetAfterDress", "G", "Lorg/json/JSONObject;", "avatarInfoJson", "H", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "p0", "()Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "m1", "(Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;)V", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "I", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "getService", "()Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "k1", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;)V", "service", "Lkotlinx/coroutines/CompletableJob;", "J", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CoroutineScope;", "K", "Lkotlinx/coroutines/CoroutineScope;", "o0", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "L", "Ljava/lang/String;", "lastCamera", "M", "currentCamera", "N", "cameraAnimationStartTime", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "O", "Ljava/util/regex/Pattern;", "getCLASS_PATTERN", "()Ljava/util/regex/Pattern;", "CLASS_PATTERN", "<init>", "()V", "P", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class PortalAnimHelper {

    /* renamed from: A, reason: from kotlin metadata */
    private i mTaskExecutor;

    /* renamed from: B, reason: from kotlin metadata */
    private boolean mHasHandHeldItem;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mHasHandHeldRandomAnim;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean doNotResetAfterDress;

    /* renamed from: G, reason: from kotlin metadata */
    private JSONObject avatarInfoJson;

    /* renamed from: I, reason: from kotlin metadata */
    private ZPlanAvatarService service;

    /* renamed from: J, reason: from kotlin metadata */
    private final CompletableJob job;

    /* renamed from: K, reason: from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: L, reason: from kotlin metadata */
    private String lastCamera;

    /* renamed from: M, reason: from kotlin metadata */
    private String currentCamera;

    /* renamed from: N, reason: from kotlin metadata */
    private double cameraAnimationStartTime;

    /* renamed from: O, reason: from kotlin metadata */
    private final Pattern CLASS_PATTERN;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.zplan.zplantracing.b drawSpan;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasPlayAnimationWithTrackGroup;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<AnimPath> mRandomHandHeldAnimPathMale;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<AnimPath> mRandomHandHeldAnimPathFemale;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mInitAnimMale;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mInitAnimFemale;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mInitHandHeldAnimMale;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mInitHandHeldAnimFemale;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mDefaultRandomAnimMale;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mDefaultRandomAnimFemale;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mRandomHandHeldAnimMale;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mRandomHandHeldAnimFemale;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.filament.zplan.animation.b> mMeshAnimList;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private double mAnimBeginTime;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private double mMeshAnimBeginTime;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private AnimPath mDressAnimPath;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private ZPlanAction mDressAnimAction;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mDressAnim;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private Deferred<ZPlanAction> mDressAnimResJob;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PortalAnimType mAnimType = PortalAnimType.NONE;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.filament.zplan.animation.b> mDefaultRandomAnimMaleList = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ArrayList<com.tencent.filament.zplan.animation.b> mDefaultRandomAnimFemaleList = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<com.tencent.filament.zplan.animation.b> mRandomHandHeldAnimMaleList = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<com.tencent.filament.zplan.animation.b> mRandomHandHeldAnimFemaleList = new CopyOnWriteArrayList<>();

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mInitAnimLoadSucceed = new AtomicBoolean(false);

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final HashSet<f> mListener = new HashSet<>();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean showHandHeldItem = true;

    /* renamed from: E, reason: from kotlin metadata */
    private final AtomicBoolean isFemale = new AtomicBoolean(false);

    /* renamed from: H, reason: from kotlin metadata */
    private FilamentUrlTemplate urlTemplate = FilamentFeatureUtil.f106409g.F();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f369992a;

        static {
            int[] iArr = new int[PortalAnimType.values().length];
            try {
                iArr[PortalAnimType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PortalAnimType.INIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PortalAnimType.INIT_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PortalAnimType.RANDOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PortalAnimType.DRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PortalAnimType.DRESS_ONLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f369992a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            QLog.i("PortalAnimHelper_", 1, "there is an error in coroutine.", exception);
        }
    }

    public PortalAnimHelper() {
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(Dispatchers.getIO()).plus(new c(CoroutineExceptionHandler.INSTANCE)));
        IFeatureRuntimeService c06 = c0();
        JSONObject jSONObject = c06 != null ? c06.getJSONObject("zplan_filament_portal_scene_config", "") : null;
        this.doNotResetAfterDress = (jSONObject != null ? jSONObject.optInt("doNotResetAfterDress", 0) : 0) != 0;
        this.CLASS_PATTERN = Pattern.compile("Class'(.*)\\.(.*)'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A0(FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadFemaleInitHandHeldAnim$2(this, jSONObject, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object B0(FilamentViewerV2 filamentViewerV2, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadFemaleRandomAnim$2(this, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object C0(FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadFemaleRandomHandHeldAnim$2(this, jSONObject, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    private final void D0(FilamentViewerV2 viewer, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        if (actionArray.length == 0) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PortalAnimHelper$loadInitAnim$1(this, viewer, zplanSpanContext, null), 3, null);
        } else if (getUeGender() == UEAvatarGender.FEMALE) {
            M0(viewer, actionArray, zplanSpanContext);
        } else {
            O0(viewer, actionArray, zplanSpanContext);
        }
    }

    private final void E0(FilamentViewerV2 viewer, JSONObject avatarPbJson, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        if (actionArray.length == 0) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PortalAnimHelper$loadInitHandHeldAnim$1(this, viewer, avatarPbJson, zplanSpanContext, null), 3, null);
        } else if (getUeGender() == UEAvatarGender.FEMALE) {
            N0(viewer, actionArray, zplanSpanContext);
        } else {
            P0(viewer, actionArray, zplanSpanContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object F0(FilamentViewerV2 filamentViewerV2, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadMaleInitAnim$2(this, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object G0(FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadMaleInitHandHeldAnim$2(this, jSONObject, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H0(FilamentViewerV2 filamentViewerV2, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadMaleRandomAnim$2(this, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I0(FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadMaleRandomHandHeldAnim$2(this, jSONObject, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J0(FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadMeshAnim$2(this, jSONObject, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    private final void K0(FilamentViewerV2 viewer, JSONObject avatarPbJson, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PortalAnimHelper$loadOthersAnim$1(this, viewer, avatarPbJson, zplanSpanContext, null), 3, null);
    }

    private final void M0(FilamentViewerV2 viewer, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        if (this.mInitAnimFemale != null) {
            QLog.w("PortalAnimHelper_", 1, "mInitAnimFemale already load succeed. sync");
            return;
        }
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadFemaleInitAnimSpan", zplanSpanContext);
        QLog.i("PortalAnimHelper_", 1, "loadSyncFemaleInitAnim start sync");
        this.mInitAnimFemale = q1(viewer, actionArray, startSpan != null ? startSpan.c() : null);
        QLog.i("PortalAnimHelper_", 1, "loadSyncFemaleInitAnim end sync");
        if (startSpan != null) {
            startSpan.b();
        }
        U();
    }

    private final void N0(FilamentViewerV2 viewer, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadFemaleInitHandHeldAnim", zplanSpanContext);
        QLog.i("PortalAnimHelper_", 1, "loadSyncFemaleInitHandHeldAnim start");
        this.mInitHandHeldAnimFemale = q1(viewer, actionArray, startSpan != null ? startSpan.c() : null);
        if (startSpan != null) {
            startSpan.b();
        }
        QLog.i("PortalAnimHelper_", 1, "loadSyncFemaleInitHandHeldAnim end");
        U();
    }

    private final void O0(FilamentViewerV2 viewer, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        if (this.mInitAnimMale != null) {
            QLog.w("PortalAnimHelper_", 1, "mInitAnimMale already load succeed. sync");
            return;
        }
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadMaleInitAnimSpan", zplanSpanContext);
        QLog.i("PortalAnimHelper_", 1, "loadSyncMaleInitAnim start sync");
        this.mInitAnimMale = q1(viewer, actionArray, startSpan != null ? startSpan.c() : null);
        QLog.i("PortalAnimHelper_", 1, "loadSyncMaleInitAnim end sync");
        if (startSpan != null) {
            startSpan.b();
        }
        U();
    }

    private final void P0(FilamentViewerV2 viewer, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("loadSyncMaleInitHandHeldAnim", zplanSpanContext);
        QLog.i("PortalAnimHelper_", 1, "loadSyncMaleInitHandHeldAnim start");
        this.mInitHandHeldAnimMale = q1(viewer, actionArray, startSpan != null ? startSpan.c() : null);
        if (startSpan != null) {
            startSpan.b();
        }
        QLog.i("PortalAnimHelper_", 1, "loadSyncMaleInitHandHeldAnim end");
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(final String errorMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.d
            @Override // java.lang.Runnable
            public final void run() {
                PortalAnimHelper.R0(PortalAnimHelper.this, errorMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(PortalAnimHelper this$0, String errorMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        Iterator<T> it = this$0.mListener.iterator();
        while (it.hasNext()) {
            ((f) it.next()).e(errorMsg);
        }
    }

    private final void S0() {
        this.lastCamera = this.currentCamera;
        this.currentCamera = null;
        this.cameraAnimationStartTime = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002b, code lost:
    
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U() {
        boolean z16 = false;
        if (getUeGender() == UEAvatarGender.FEMALE) {
            if (this.mHasHandHeldItem) {
                this.mInitAnimLoadSucceed.set(z16);
            } else {
                this.mInitAnimLoadSucceed.set(z16);
            }
        } else if (this.mHasHandHeldItem) {
            this.mInitAnimLoadSucceed.set(z16);
        } else {
            this.mInitAnimLoadSucceed.set(z16);
        }
        if (this.mInitAnimLoadSucceed.get()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.c
                @Override // java.lang.Runnable
                public final void run() {
                    PortalAnimHelper.V(PortalAnimHelper.this);
                }
            });
        }
        QLog.i("PortalAnimHelper_", 1, "checkInitAnimState " + this.mInitAnimLoadSucceed.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(PortalAnimHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.mListener.iterator();
        while (it.hasNext()) {
            ((f) it.next()).c();
        }
    }

    private final boolean W(List<AnimPath> randomAnimPathMale, List<AnimPath> randomAnimPathFemale) {
        if (randomAnimPathMale != null && randomAnimPathFemale != null) {
            for (AnimPath animPath : randomAnimPathMale) {
                String body = animPath.getBody();
                if (!(body == null || body.length() == 0)) {
                    String head = animPath.getHead();
                    if (head == null || head.length() == 0) {
                    }
                }
                QLog.w("PortalAnimHelper_", 1, "checkRandomAnimPathValid randomAnimPathMale path value null");
                return false;
            }
            for (AnimPath animPath2 : randomAnimPathFemale) {
                String body2 = animPath2.getBody();
                if (!(body2 == null || body2.length() == 0)) {
                    String head2 = animPath2.getHead();
                    if (head2 == null || head2.length() == 0) {
                    }
                }
                QLog.w("PortalAnimHelper_", 1, "checkRandomAnimPathValid randomAnimPathFemale path value null");
                return false;
            }
            return true;
        }
        QLog.e("PortalAnimHelper_", 1, "checkRandomAnimPathValid path null");
        return false;
    }

    private final void W0(FilamentViewerV2 viewer, double now) {
        Unit unit;
        double d16;
        String str = this.currentCamera;
        if (str == null) {
            return;
        }
        if (this.cameraAnimationStartTime == 0.0d) {
            this.cameraAnimationStartTime = now;
        }
        String str2 = this.lastCamera;
        if (str2 != null) {
            double d17 = now - this.cameraAnimationStartTime;
            if (d17 >= 0.2d) {
                S0();
                d16 = 0.2d;
            } else {
                d16 = d17;
            }
            QLog.i("PortalAnimHelper_", 1, "playCameraAnimation  process:" + d16);
            viewer.playCameraAnimation(str2, str, 0.2d, d16);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            viewer.setCamera(str);
            this.lastCamera = str;
            S0();
        }
    }

    private final void X(List<JSONObject> list, JSONArray jSONArray) {
        int length = jSONArray.length();
        if (length <= 0) {
            return;
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "array.optJSONObject(i)");
            list.add(optJSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a0(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$downloadInitAnimRes$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    private final IFeatureRuntimeService c0() {
        AppInterface appInterface = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getAppInterface();
        if (appInterface != null) {
            return (IFeatureRuntimeService) appInterface.getRuntimeService(IFeatureRuntimeService.class, "all");
        }
        return null;
    }

    private final void c1(FilamentViewerV2 viewer, double now) {
        ArrayList<com.tencent.filament.zplan.animation.b> arrayList = this.mMeshAnimList;
        if (!(arrayList == null || arrayList.isEmpty())) {
            if (this.mMeshAnimBeginTime == 0.0d) {
                this.mMeshAnimBeginTime = now;
            }
            double d16 = now - this.mMeshAnimBeginTime;
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                viewer.playAnimationWithTrackGroup((com.tencent.filament.zplan.animation.b) it.next(), d16);
            }
            return;
        }
        this.mMeshAnimBeginTime = 0.0d;
    }

    static /* synthetic */ Object e0(PortalAnimHelper portalAnimHelper, com.tencent.zplan.zplantracing.c cVar, EnumUserGender enumUserGender, String str, String str2, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super ZPlanAction> continuation) {
        ZPlanAvatarService zPlanAvatarService = portalAnimHelper.service;
        if (zPlanAvatarService == null) {
            return ZPlanAvatarResourceHelper.f105660o.B(cVar, enumUserGender, str, str2, filamentUrlTemplate, continuation);
        }
        return FilamentAnimationHelper.f105573a.b(zPlanAvatarService, str, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandHeldItem f0(JSONObject avatarPbJson) {
        JSONObject optJSONObject;
        ArrayList<JSONObject> arrayList = new ArrayList();
        JSONObject optJSONObject2 = avatarPbJson.optJSONObject("avatar_info");
        JSONArray optJSONArray = optJSONObject2 != null ? optJSONObject2.optJSONArray("slot_arr") : null;
        if (optJSONArray == null) {
            this.mHasHandHeldItem = false;
            this.mHasHandHeldRandomAnim = false;
            return null;
        }
        X(arrayList, optJSONArray);
        for (JSONObject jSONObject : arrayList) {
            if (jSONObject.optInt(MiniAppReportManager2.KEY_SLOT_ID) == 201 && (optJSONObject = jSONObject.optJSONObject("item_data")) != null) {
                String idleHeadMale = optJSONObject.optString("idle_head_nan");
                String idleBodyMale = optJSONObject.optString("idle_body_nan");
                String idleHeadFemale = optJSONObject.optString("idle_head_nv");
                String idleBodyFemale = optJSONObject.optString("idle_body_nv");
                boolean z16 = getUeGender() != UEAvatarGender.FEMALE ? !(TextUtils.isEmpty(idleHeadMale) || TextUtils.isEmpty(idleBodyMale)) : !(TextUtils.isEmpty(idleHeadFemale) || TextUtils.isEmpty(idleBodyFemale));
                this.mHasHandHeldItem = z16;
                if (!z16) {
                    this.mHasHandHeldRandomAnim = false;
                    QLog.e("PortalAnimHelper_", 1, "getAvatarHandHeldItem invalid anim path");
                    return null;
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("relax_head_nan");
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("relax_body_nan");
                JSONArray optJSONArray4 = optJSONObject.optJSONArray("relax_head_nv");
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("relax_body_nv");
                List<AnimPath> Y = Y(optJSONArray2, optJSONArray3);
                List<AnimPath> Y2 = Y(optJSONArray4, optJSONArray5);
                this.mHasHandHeldRandomAnim = W(Y, Y2);
                Intrinsics.checkNotNullExpressionValue(idleHeadMale, "idleHeadMale");
                Intrinsics.checkNotNullExpressionValue(idleBodyMale, "idleBodyMale");
                Intrinsics.checkNotNullExpressionValue(idleHeadFemale, "idleHeadFemale");
                Intrinsics.checkNotNullExpressionValue(idleBodyFemale, "idleBodyFemale");
                Intrinsics.checkNotNull(Y);
                Intrinsics.checkNotNull(Y2);
                return new HandHeldItem(idleHeadMale, idleBodyMale, idleHeadFemale, idleBodyFemale, Y, Y2);
            }
        }
        this.mHasHandHeldItem = false;
        this.mHasHandHeldRandomAnim = false;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g0(JSONObject jSONObject, Continuation<? super List<ZPlanAction>> continuation) {
        return CoroutineScopeKt.coroutineScope(new PortalAnimHelper$getAvatarMeshAnim$2(jSONObject, this, null), continuation);
    }

    private final boolean q0(FilamentViewerV2 viewer, com.tencent.filament.zplan.animation.b animData) {
        QLog.i("PortalAnimHelper_", 1, this.mAnimType + " anim End. animDuration:" + animData.b());
        int i3 = b.f369992a[this.mAnimType.ordinal()];
        if (i3 == 2) {
            d1();
            return false;
        }
        if (i3 == 3) {
            b1(viewer);
            return false;
        }
        if (i3 == 4) {
            T0();
            return false;
        }
        if (i3 == 5) {
            Z0(viewer);
            return false;
        }
        if (i3 != 6) {
            return false;
        }
        Y0(viewer);
        return false;
    }

    private final void r0(FilamentViewerV2 viewer, boolean preIsFemale) {
        if (preIsFemale == this.isFemale.get() || this.mAnimType != PortalAnimType.DRESS) {
            return;
        }
        Z0(viewer);
    }

    private final void s1(PortalAnimType type) {
        this.mAnimType = type;
        QLog.i("PortalAnimHelper_", 1, "updateAnimType " + type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object x0(FilamentViewerV2 filamentViewerV2, ZPlanAction zPlanAction, boolean z16, Continuation<? super Unit> continuation) {
        return CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadDressAnim$4(this, zPlanAction, filamentViewerV2, z16, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y0(FilamentViewerV2 filamentViewerV2, UEAvatarGender uEAvatarGender, AnimPath animPath, Continuation<? super Unit> continuation) {
        return CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadDressAnim$2(this, animPath, uEAvatarGender, filamentViewerV2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z0(FilamentViewerV2 filamentViewerV2, com.tencent.zplan.zplantracing.c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PortalAnimHelper$loadFemaleInitAnim$2(this, cVar, filamentViewerV2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutineScope == coroutine_suspended ? coroutineScope : Unit.INSTANCE;
    }

    public final void L0(FilamentViewerV2 viewer, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PortalAnimHelper$loadRandomAnim$1(this, viewer, zplanSpanContext, null), 3, null);
    }

    public final void S(f l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListener.add(l3);
    }

    public final void T(i executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.mTaskExecutor = executor;
    }

    public final Object U0(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (this.service != null) {
            Object cancelAndJoin = JobKt.cancelAndJoin(this.job, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return cancelAndJoin == coroutine_suspended ? cancelAndJoin : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void Z() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PortalAnimHelper$downloadInitAnim$1(this, null), 3, null);
    }

    public final boolean b0(FilamentViewerV2 viewer, double now, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        com.tencent.filament.zplan.animation.b k06;
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        if (!this.hasPlayAnimationWithTrackGroup) {
            this.drawSpan = ZPlanSpanFactory.INSTANCE.startSpan("applyInitAnim", zplanSpanContext);
        }
        boolean z16 = this.isFemale.get();
        switch (b.f369992a[this.mAnimType.ordinal()]) {
            case 1:
                k06 = k0(z16);
                break;
            case 2:
            case 3:
                k06 = k0(z16);
                break;
            case 4:
                k06 = n0(z16);
                break;
            case 5:
            case 6:
                k06 = this.mDressAnim;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        com.tencent.filament.zplan.animation.b bVar = k06;
        if (bVar == null) {
            Z0(viewer);
            return false;
        }
        if (this.mAnimBeginTime == 0.0d) {
            this.mAnimBeginTime = now;
        }
        double d16 = now - this.mAnimBeginTime;
        double b16 = bVar.b();
        W0(viewer, now);
        if (d16 > b16) {
            return q0(viewer, bVar);
        }
        return V0(viewer, now, d16, bVar);
    }

    public Object d0(com.tencent.zplan.zplantracing.c cVar, EnumUserGender enumUserGender, String str, String str2, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super ZPlanAction> continuation) {
        return e0(this, cVar, enumUserGender, str, str2, filamentUrlTemplate, continuation);
    }

    public final void e1(FilamentViewerV2 viewer) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        QLog.i("PortalAnimHelper_", 1, "reloadInitAnim");
        w0(this, viewer, null, new ZPlanAction[0], null, 10, null);
    }

    public final void f1(f l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListener.remove(l3);
    }

    public final void g1(JSONObject avatarInfo) {
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        this.avatarInfoJson = avatarInfo;
    }

    /* renamed from: h0 */
    public UEAvatarGender getUeGender() {
        EnumUserGender enumUserGender;
        m94.a b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b();
        if (b16.d()) {
            return b16.getGender();
        }
        JSONObject jSONObject = this.avatarInfoJson;
        if (jSONObject != null) {
            enumUserGender = EnumUserGender.INSTANCE.a(jSONObject.optInt("gender", 0));
        } else {
            enumUserGender = null;
        }
        if (enumUserGender == EnumUserGender.GENDER_FEMALE) {
            return UEAvatarGender.FEMALE;
        }
        return UEAvatarGender.MALE;
    }

    public final void h1(String camera2) {
        Intrinsics.checkNotNullParameter(camera2, "camera");
        this.lastCamera = camera2;
    }

    /* renamed from: i0, reason: from getter */
    public final com.tencent.filament.zplan.animation.b getMDressAnim() {
        return this.mDressAnim;
    }

    public final void i1(String camera2) {
        Intrinsics.checkNotNullParameter(camera2, "camera");
        this.currentCamera = camera2;
    }

    public final FetchActionData[] j0(EnumUserGender gender, JSONObject avatarPbJson) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(avatarPbJson, "avatarPbJson");
        HandHeldItem f06 = f0(avatarPbJson);
        if (f06 != null) {
            QLog.i("PortalAnimHelper_", 1, "getFetchActionData handHeldItem=" + f06);
            if (gender == EnumUserGender.GENDER_FEMALE) {
                return new FetchActionData[]{new FetchActionData(0, f06.getIdleHeadAnimPathFemale(), f06.getIdleBodyAnimPathFemale(), 1, null)};
            }
            return new FetchActionData[]{new FetchActionData(0, f06.getIdleHeadAnimPathMale(), f06.getIdleBodyAnimPathMale(), 1, null)};
        }
        if (gender == EnumUserGender.GENDER_FEMALE) {
            g gVar = g.f370004a;
            return new FetchActionData[]{new FetchActionData(0, gVar.a().getHead(), gVar.a().getBody(), 1, null)};
        }
        g gVar2 = g.f370004a;
        return new FetchActionData[]{new FetchActionData(0, gVar2.b().getHead(), gVar2.b().getBody(), 1, null)};
    }

    public final void j1() {
        int size = this.mDefaultRandomAnimMaleList.size();
        this.mDefaultRandomAnimMale = null;
        if (size > 0) {
            int nextInt = RandomKt.Random(System.currentTimeMillis()).nextInt(size);
            this.mDefaultRandomAnimMale = this.mDefaultRandomAnimMaleList.get(nextInt);
            QLog.i("PortalAnimHelper_", 1, "setRandomAnim Male selected:" + nextInt);
        } else {
            QLog.w("PortalAnimHelper_", 1, "setRandomAnim Male size is 0");
        }
        int size2 = this.mDefaultRandomAnimFemaleList.size();
        this.mDefaultRandomAnimFemale = null;
        if (size2 > 0) {
            int nextInt2 = RandomKt.Random(System.currentTimeMillis()).nextInt(size2);
            this.mDefaultRandomAnimFemale = this.mDefaultRandomAnimFemaleList.get(nextInt2);
            QLog.i("PortalAnimHelper_", 1, "setRandomAnim Female selected:" + nextInt2);
        } else {
            QLog.w("PortalAnimHelper_", 1, "setRandomAnim Female size is 0");
        }
        int size3 = this.mRandomHandHeldAnimMaleList.size();
        this.mRandomHandHeldAnimMale = null;
        if (size3 > 0) {
            int nextInt3 = RandomKt.Random(System.currentTimeMillis()).nextInt(size3);
            this.mRandomHandHeldAnimMale = this.mRandomHandHeldAnimMaleList.get(nextInt3);
            QLog.i("PortalAnimHelper_", 1, "setRandomAnim HandHeld Male selected:" + nextInt3);
        } else {
            QLog.w("PortalAnimHelper_", 1, "setRandomAnim HandHeld Male size is 0");
        }
        int size4 = this.mRandomHandHeldAnimFemaleList.size();
        this.mRandomHandHeldAnimFemale = null;
        if (size4 > 0) {
            int nextInt4 = RandomKt.Random(System.currentTimeMillis()).nextInt(size4);
            this.mRandomHandHeldAnimFemale = this.mRandomHandHeldAnimFemaleList.get(nextInt4);
            QLog.i("PortalAnimHelper_", 1, "setRandomAnim HandHeld Female selected:" + nextInt4);
            return;
        }
        QLog.w("PortalAnimHelper_", 1, "setRandomAnim HandHeld Female size is 0");
    }

    public final void k1(ZPlanAvatarService zPlanAvatarService) {
        this.service = zPlanAvatarService;
    }

    public final boolean l0() {
        return this.mInitAnimLoadSucceed.get();
    }

    public final void l1(boolean z16) {
        this.showHandHeldItem = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m0, reason: from getter */
    public final i getMTaskExecutor() {
        return this.mTaskExecutor;
    }

    public final void m1(FilamentUrlTemplate filamentUrlTemplate) {
        Intrinsics.checkNotNullParameter(filamentUrlTemplate, "<set-?>");
        this.urlTemplate = filamentUrlTemplate;
    }

    public final void n1() {
        if (this.mAnimType == PortalAnimType.NONE) {
            a1(this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o0, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void o1() {
        s1(PortalAnimType.INIT_ONLY);
    }

    /* renamed from: p0, reason: from getter */
    public final FilamentUrlTemplate getUrlTemplate() {
        return this.urlTemplate;
    }

    public final String p1(String str) {
        boolean startsWith$default;
        String result = "";
        Intrinsics.checkNotNullParameter(str, "<this>");
        Matcher matcher = this.CLASS_PATTERN.matcher(str);
        try {
            if (matcher.find()) {
                result = matcher.group(1);
            }
        } catch (Exception unused) {
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(result, "/Game/", false, 2, null);
        if (startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            result = result.substring(6);
            Intrinsics.checkNotNullExpressionValue(result, "this as java.lang.String).substring(startIndex)");
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    public final void s0(FilamentViewerV2 viewer, ZPlanAction animAction, boolean isHandHeldItem, boolean isLoop) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(animAction, "animAction");
        if (this.doNotResetAfterDress && this.mAnimType == PortalAnimType.DRESS) {
            if (!isHandHeldItem) {
                return;
            }
            ZPlanAction zPlanAction = this.mDressAnimAction;
            if (Intrinsics.areEqual(zPlanAction != null ? zPlanAction.getBodyAnimationGltfPath() : null, animAction.getBodyAnimationGltfPath())) {
                ZPlanAction zPlanAction2 = this.mDressAnimAction;
                if (Intrinsics.areEqual(zPlanAction2 != null ? zPlanAction2.getFaceAnimationGltfPath() : null, animAction.getFaceAnimationGltfPath())) {
                    return;
                }
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PortalAnimHelper$loadAndPlayDressAnim$2(this, viewer, animAction, isLoop, null), 3, null);
    }

    public final void t0(FilamentViewerV2 viewer, UEAvatarGender gender, AnimPath path, boolean isHandHeldItem) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(path, "path");
        if (this.doNotResetAfterDress && this.mAnimType == PortalAnimType.DRESS) {
            if (!isHandHeldItem) {
                return;
            }
            AnimPath animPath = this.mDressAnimPath;
            boolean z16 = false;
            if (animPath != null && animPath.c(path)) {
                z16 = true;
            }
            if (z16) {
                return;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PortalAnimHelper$loadAndPlayDressAnim$1(this, viewer, gender, path, null), 3, null);
    }

    public final void u0(FilamentViewerV2 viewer, JSONObject avatarPbJson, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(avatarPbJson, "avatarPbJson");
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        v0(viewer, avatarPbJson, actionArray, zplanSpanContext);
        UEAvatarGender ueGender = getUeGender();
        boolean z16 = this.isFemale.get();
        this.isFemale.set(ueGender == UEAvatarGender.FEMALE);
        r0(viewer, z16);
    }

    private final void T0() {
        this.mAnimBeginTime = 0.0d;
        s1(PortalAnimType.INIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(FilamentViewerV2 viewer) {
        this.mAnimBeginTime = 0.0d;
        s1(PortalAnimType.DRESS);
        if (viewer != null) {
            viewer.setHandHeldShow(this.showHandHeldItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(FilamentViewerV2 viewer) {
        this.mAnimBeginTime = 0.0d;
        s1(PortalAnimType.DRESS_ONLY);
        if (viewer != null) {
            viewer.setHandHeldShow(this.showHandHeldItem);
        }
    }

    private final void Z0(FilamentViewerV2 viewer) {
        this.mAnimBeginTime = 0.0d;
        s1(PortalAnimType.INIT);
        this.showHandHeldItem = true;
        if (viewer != null) {
            viewer.setHandHeldShow(true);
        }
    }

    private final void b1(FilamentViewerV2 viewer) {
        this.mAnimBeginTime = 0.0d;
        s1(PortalAnimType.INIT_ONLY);
        this.showHandHeldItem = true;
        if (viewer != null) {
            viewer.setHandHeldShow(true);
        }
    }

    private final void d1() {
        this.mAnimBeginTime = 0.0d;
        j1();
        boolean z16 = (this.mDefaultRandomAnimMale == null || this.mDefaultRandomAnimFemale == null) ? false : true;
        int nextInt = RandomKt.Random(System.currentTimeMillis()).nextInt(100);
        QLog.i("PortalAnimHelper_", 1, "onInitAnimEnd  randomValue:" + nextInt);
        if (nextInt > 40 && z16) {
            s1(PortalAnimType.RANDOM);
        } else {
            s1(PortalAnimType.INIT);
        }
    }

    private final void v0(FilamentViewerV2 viewer, JSONObject avatarPbJson, ZPlanAction[] actionArray, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        if (avatarPbJson != null) {
            f0(avatarPbJson);
        }
        if (!this.mHasHandHeldItem) {
            D0(viewer, actionArray, zplanSpanContext);
        } else if (avatarPbJson != null) {
            E0(viewer, avatarPbJson, actionArray, zplanSpanContext);
        }
        L0(viewer, zplanSpanContext);
        if (avatarPbJson != null) {
            K0(viewer, avatarPbJson, zplanSpanContext);
        }
        viewer.setHandHeldShow(this.showHandHeldItem);
    }

    public final com.tencent.filament.zplan.animation.b k0(boolean isFemale) {
        if (isFemale) {
            if (this.mHasHandHeldItem) {
                return this.mInitHandHeldAnimFemale;
            }
            return this.mInitAnimFemale;
        }
        if (this.mHasHandHeldItem) {
            return this.mInitHandHeldAnimMale;
        }
        return this.mInitAnimMale;
    }

    public final com.tencent.filament.zplan.animation.b n0(boolean isFemale) {
        if (isFemale) {
            if (this.mHasHandHeldItem) {
                if (this.mHasHandHeldRandomAnim) {
                    return this.mRandomHandHeldAnimFemale;
                }
                return null;
            }
            return this.mDefaultRandomAnimFemale;
        }
        if (this.mHasHandHeldItem) {
            if (this.mHasHandHeldRandomAnim) {
                return this.mRandomHandHeldAnimMale;
            }
            return null;
        }
        return this.mDefaultRandomAnimMale;
    }

    private final List<AnimPath> Y(JSONArray headJSONArray, JSONArray bodyJSONArray) {
        if (headJSONArray == null || bodyJSONArray == null || headJSONArray.length() != bodyJSONArray.length()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = headJSONArray.length();
        if (length < 1) {
            return null;
        }
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = headJSONArray.get(i3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = bodyJSONArray.get(i3);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add(new AnimPath((String) obj, (String) obj2));
        }
        return arrayList;
    }

    public com.tencent.filament.zplan.animation.b q1(FilamentViewerV2 viewer, ZPlanAction[] animations, com.tencent.zplan.zplantracing.c zplanSpanContext) {
        List list;
        Object first;
        Object first2;
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(animations, "animations");
        list = ArraysKt___ArraysKt.toList(animations);
        QLog.i("PortalAnimHelper_", 1, "trackGroupWithAnimations animations:" + list);
        com.tencent.filament.zplan.animation.b bVar = new com.tencent.filament.zplan.animation.b();
        com.tencent.filament.zplan.animation.a aVar = new com.tencent.filament.zplan.animation.a();
        com.tencent.filament.zplan.animation.a aVar2 = new com.tencent.filament.zplan.animation.a();
        for (ZPlanAction zPlanAction : animations) {
            FilamentAnimation[] loadAnimation = viewer.loadAnimation(zPlanAction.getFaceAnimationGltfPath(), zplanSpanContext);
            if (!(loadAnimation.length == 0)) {
                first2 = ArraysKt___ArraysKt.first(loadAnimation);
                FilamentAnimation filamentAnimation = (FilamentAnimation) first2;
                QLog.i("PortalAnimHelper_", 1, "trackGroupWithAnimations faceAnimation:" + e.a(filamentAnimation));
                aVar.a(filamentAnimation);
            } else {
                QLog.e("PortalAnimHelper_", 1, "trackGroupWithAnimations faceAnimation is Empty");
            }
            FilamentAnimation[] loadAnimation2 = viewer.loadAnimation(zPlanAction.getBodyAnimationGltfPath(), zplanSpanContext);
            if (!(loadAnimation2.length == 0)) {
                first = ArraysKt___ArraysKt.first(loadAnimation2);
                FilamentAnimation filamentAnimation2 = (FilamentAnimation) first;
                QLog.i("PortalAnimHelper_", 1, "trackGroupWithAnimations bodyAnimation:" + e.a(filamentAnimation2));
                aVar2.a(filamentAnimation2);
            } else {
                QLog.e("PortalAnimHelper_", 1, "trackGroupWithAnimations bodyAnimation is Empty");
            }
        }
        bVar.a(aVar);
        bVar.a(aVar2);
        return bVar;
    }

    static /* synthetic */ void a1(PortalAnimHelper portalAnimHelper, FilamentViewerV2 filamentViewerV2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                filamentViewerV2 = null;
            }
            portalAnimHelper.Z0(filamentViewerV2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playInitAnim");
    }

    public static /* synthetic */ com.tencent.filament.zplan.animation.b r1(PortalAnimHelper portalAnimHelper, FilamentViewerV2 filamentViewerV2, ZPlanAction[] zPlanActionArr, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                cVar = null;
            }
            return portalAnimHelper.q1(filamentViewerV2, zPlanActionArr, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackGroupWithAnimations");
    }

    private final boolean V0(FilamentViewerV2 viewer, double now, double animInterval, com.tencent.filament.zplan.animation.b animData) {
        if (animInterval == 0.0d) {
            QLog.i("PortalAnimHelper_", 1, this.mAnimType + " anim Start.");
        }
        c1(viewer, now);
        viewer.playAnimationWithTrackGroup(animData, animInterval);
        com.tencent.zplan.zplantracing.b bVar = this.drawSpan;
        if (bVar != null) {
            bVar.b();
        }
        this.drawSpan = null;
        this.hasPlayAnimationWithTrackGroup = true;
        return true;
    }

    static /* synthetic */ void w0(PortalAnimHelper portalAnimHelper, FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, ZPlanAction[] zPlanActionArr, com.tencent.zplan.zplantracing.c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                jSONObject = null;
            }
            if ((i3 & 8) != 0) {
                cVar = null;
            }
            portalAnimHelper.v0(filamentViewerV2, jSONObject, zPlanActionArr, cVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAnimRes");
    }
}
