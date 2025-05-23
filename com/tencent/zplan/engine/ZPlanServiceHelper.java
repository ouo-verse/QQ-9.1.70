package com.tencent.zplan.engine;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.SurfaceTexture;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.IZPlanEngineStatusCallback;
import com.tencent.zplan.IZPlanEnterSceneCallback;
import com.tencent.zplan.IZPlanRecordCallback;
import com.tencent.zplan.IZPlanWorldCallback;
import com.tencent.zplan.common.utils.g;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.c;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import com.tencent.zplan.engine.service.ReporterEventRecordTime;
import com.tencent.zplan.engine.service.ZPlanEngineService;
import com.tencent.zplan.h;
import com.tencent.zplan.hotpatch.ZPlanHotPatchNotifyHelper;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.model.ZPlanHitScene;
import com.tencent.zplan.resource.ZPlanResourceLoadHelper;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.a;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.utils.ZPlanConstant;
import com.tencent.zplan.world.model.ZPlanWorld;
import cy4.ZPlanResourceBusinessData;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lx4.b;
import lx4.f;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zx4.i;
import zx4.s;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0004\u00d6\u0001\u00de\u0001\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u007fB\n\b\u0002\u00a2\u0006\u0005\b\u00e4\u0001\u0010hJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J1\u0010!\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0016\u0010 \u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001f\"\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020\u0004J*\u0010&\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001bJ\u000e\u0010*\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001bJ\u0016\u0010/\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-J\u0014\u00102\u001a\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001000J\u000e\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000eJ\u000e\u00105\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000eJ\u0010\u00106\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u000eJ(\u0010;\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\b\u00103\u001a\u0004\u0018\u00010\u000e2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014J(\u0010<\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\b\u00103\u001a\u0004\u0018\u00010\u000e2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014J\u000e\u0010=\u001a\u00020\u00022\u0006\u00108\u001a\u000207J\"\u0010B\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u00102\b\u0010A\u001a\u0004\u0018\u00010@J7\u0010F\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u00142\u0006\u0010E\u001a\u00020DH\u0000\u00a2\u0006\u0004\bF\u0010GJ'\u0010I\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014H\u0000\u00a2\u0006\u0004\bI\u0010JJ(\u0010K\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u00102\u0006\u0010.\u001a\u00020@J(\u0010L\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010M\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u0014J\u000e\u0010N\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u0014J\u0016\u0010O\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\u0014J\u001e\u0010Q\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u0004J\u0018\u0010T\u001a\u00020\u00022\u0006\u0010R\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010SJ\u0006\u0010U\u001a\u00020\u0002J\u0012\u0010X\u001a\u00020\u00022\n\b\u0002\u0010W\u001a\u0004\u0018\u00010VJ\u001c\u0010Y\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010VJ\u0006\u0010Z\u001a\u00020\u0004J\u0006\u0010[\u001a\u00020\u0004J\u0006\u0010\\\u001a\u00020\u0002J\u0006\u0010]\u001a\u00020\u0002J\u0016\u0010a\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u00142\u0006\u0010`\u001a\u00020_J\u000e\u0010c\u001a\u00020\u00022\u0006\u0010`\u001a\u00020bJ\u000e\u0010e\u001a\u00020\u00022\u0006\u0010W\u001a\u00020dJ\u000e\u0010f\u001a\u00020\u00022\u0006\u0010W\u001a\u00020dJ\u000f\u0010g\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\bg\u0010hJ\u0010\u0010j\u001a\u00020\u00022\b\u0010i\u001a\u0004\u0018\u00010\u0010J\u0006\u0010k\u001a\u00020\u0002J\u0006\u0010l\u001a\u00020\u0004J\u000e\u0010n\u001a\u00020\u00022\u0006\u0010m\u001a\u00020\u0004J\u001e\u0010o\u001a\u00020\u00022\u0006\u0010m\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u0014J\u001a\u0010p\u001a\u00020\u00022\u0006\u0010R\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010r\u001a\u0004\u0018\u00010qJ\u0016\u0010u\u001a\u00020\u00022\u0006\u0010s\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u0010J\u0006\u0010v\u001a\u00020\u0004J\u000e\u0010x\u001a\u00020\u00022\u0006\u0010w\u001a\u00020\u0004J\u0006\u0010y\u001a\u00020\u0004J\u0006\u0010z\u001a\u00020\u0014J\u000e\u0010{\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u0004J\u0006\u0010|\u001a\u00020\u0002J\u0006\u0010}\u001a\u00020\u0014R\u001f\u0010\u0083\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001f\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008a\u0001R!\u0010\u0091\u0001\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u00103\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001b\u0010\u00a0\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010\u00a3\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u0019\u0010\u00a5\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a2\u0001R\u0019\u0010\u00a7\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a2\u0001R\u0019\u0010\u00a9\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a2\u0001R\u0019\u0010\u00ab\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00a2\u0001R\u001b\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u0019\u0010\u00b0\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00a2\u0001R\u001b\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00ad\u0001R\u0018\u0010\u00b4\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b3\u0001\u00106R\u001b\u0010\u00b6\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u0093\u0001R\u001b\u0010\u00b9\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\"\u0010\u00bd\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ba\u0001\u0010\u0080\u0001\u001a\u0006\b\u00bb\u0001\u0010\u00bc\u0001R\"\u0010\u00c0\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00be\u0001\u0010\u0080\u0001\u001a\u0006\b\u00bf\u0001\u0010\u00bc\u0001R\"\u0010\u00c3\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c1\u0001\u0010\u0080\u0001\u001a\u0006\b\u00c2\u0001\u0010\u00bc\u0001R\"\u0010\u00c6\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c4\u0001\u0010\u0080\u0001\u001a\u0006\b\u00c5\u0001\u0010\u00bc\u0001R\"\u0010\u00c9\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c7\u0001\u0010\u0080\u0001\u001a\u0006\b\u00c8\u0001\u0010\u00bc\u0001R\"\u0010\u00cc\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ca\u0001\u0010\u0080\u0001\u001a\u0006\b\u00cb\u0001\u0010\u00bc\u0001R\"\u0010\u00cf\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00cd\u0001\u0010\u0080\u0001\u001a\u0006\b\u00ce\u0001\u0010\u00bc\u0001R\"\u0010\u00d1\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00d0\u0001\u0010\u0080\u0001\u001a\u0006\b\u00a2\u0001\u0010\u00bc\u0001R)\u0010\u00d5\u0001\u001a\u0004\u0018\u00010\u001d8BX\u0083\u0084\u0002\u00a2\u0006\u0017\n\u0006\b\u00d2\u0001\u0010\u0080\u0001\u0012\u0005\b\u00d4\u0001\u0010h\u001a\u0006\b\u00d3\u0001\u0010\u00bc\u0001R\u0018\u0010\u00d9\u0001\u001a\u00030\u00d6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u0018\u0010\u00dd\u0001\u001a\u00030\u00da\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00db\u0001\u0010\u00dc\u0001R\u0017\u0010\u00e0\u0001\u001a\u00030\u00de\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bp\u0010\u00df\u0001R\u0017\u0010\u00e3\u0001\u001a\u00030\u00e1\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bu\u0010\u00e2\u0001\u00a8\u0006\u00e5\u0001"}, d2 = {"Lcom/tencent/zplan/engine/ZPlanServiceHelper;", "", "", "g0", "", "success", "h0", "B0", "Landroid/os/IBinder;", "service", "j0", "Landroid/content/Context;", "context", "W0", "Landroid/view/Surface;", "c0", "", "from", "isEngineReady", "F0", "", "startEngineState", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/engine/c;", "zPlanStartEngineListener", "O0", "", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "e0", "Ljava/lang/reflect/Method;", "method", "", "args", "i0", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "Landroid/graphics/SurfaceTexture;", "d0", "l0", "X0", "Y0", "statusUpdateListener", "E0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "params", "Lcom/tencent/zplan/IZPlanRecordCallback;", "callback", "C0", "", "uinSet", "o0", "surface", "U0", "H0", "I", "", "nativeHandle", "width", "height", "u0", "t0", "v0", "sceneType", "sceneParams", "Lcom/tencent/zplan/IZPlanEnterSceneCallback;", "enterSceneCallback", "K", "renderHashcode", "Lcom/tencent/zplan/IZPlanWorldCallback;", "zplanWorldCallback", "f0", "(IIIILcom/tencent/zplan/IZPlanWorldCallback;)V", "worldID", "I0", "(III)V", "L", "M", "y0", "N0", "J", "bSync", "G0", AdMetricTag.EVENT_NAME, "Lcom/tencent/zplan/c;", "p0", "x0", "Lcom/tencent/zplan/d;", "listener", "K0", "J0", "k0", "m0", "q0", "r0", "keyCode", "Landroid/view/KeyEvent;", "event", "s0", "Landroid/view/MotionEvent;", "w0", "Ltx4/a;", "D0", "Z0", "z0", "()V", ISchemeApi.KEY_SCENE_DATA, "A0", "P0", "n0", "isPortrait", "S0", "T0", "G", "Lcom/tencent/zplan/luabridge/a;", ExifInterface.LATITUDE_SOUTH, "callbackId", "result", "H", BdhLogUtil.LogTag.Tag_Req, "using", "R0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "O", "Q0", "V0", "P", "Lzx4/s;", "a", "Lkotlin/Lazy;", "N", "()Lzx4/s;", "commonProxy", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", "zPlanEngineStatusLock", "", "c", "Ljava/util/List;", "zPlanEngineStatusUpdateListenerList", "Lcom/tencent/zplan/engine/ZPlanServiceHelper$a;", "d", "zPlanStartEngineListenerList", "e", "Ljava/lang/ref/WeakReference;", "refContext", "f", "Ljava/lang/String;", "startFrom", "g", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", h.F, "Landroid/view/Surface;", "Lcom/tencent/zplan/h;", "i", "Lcom/tencent/zplan/h;", "zPlanServiceInterface", "j", "Lcom/tencent/zplan/luabridge/a;", "remoteLuaCaller", "k", "Z", "isServiceConnected", "l", "isEngineInitFinish", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isPreload", DomainData.DOMAIN_NAME, "isServiceBind", "o", "isServiceBinding", "p", "Ljava/lang/Boolean;", "serviceBindResult", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isHotPatchDownloading", "r", "hotPatchDownloadResult", ReportConstant.COSTREPORT_PREFIX, "hotPatchErrorCode", "t", "hotPatchErrorMessage", "u", "Landroid/os/IBinder;", "currentService", "v", "b0", "()Ljava/lang/reflect/Method;", "METHOD_SERVICE_CONNECTED", "w", "a0", "METHOD_HOT_PATCH_DOWNLOAD_FAILED", HippyTKDListViewAdapter.X, "V", "METHOD_ENGINE_INIT_FINISH", "y", "T", "METHOD_ENGINE_DESTROY", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Y", "METHOD_ENGINE_PURGING", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "X", "METHOD_ENGINE_PURGED", "B", "W", "METHOD_ENGINE_INVERSE_PURGED", BdhLogUtil.LogTag.Tag_Conn, "METHOD_ENGINE_SUSPENDED", "D", "U", "getMETHOD_ENGINE_FIRST_FRAME$annotations", "METHOD_ENGINE_FIRST_FRAME", "com/tencent/zplan/engine/ZPlanServiceHelper$b", "E", "Lcom/tencent/zplan/engine/ZPlanServiceHelper$b;", "hotPatchDownloadCallback", "Landroid/content/ServiceConnection;", UserInfo.SEX_FEMALE, "Landroid/content/ServiceConnection;", "serviceConnection", "com/tencent/zplan/engine/ZPlanServiceHelper$d", "Lcom/tencent/zplan/engine/ZPlanServiceHelper$d;", "innerEngineStatusUpdateListener", "Lcom/tencent/zplan/IZPlanEngineStatusCallback;", "Lcom/tencent/zplan/IZPlanEngineStatusCallback;", "zPlanEngineStatusCallback", "<init>", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanServiceHelper {

    /* renamed from: A, reason: from kotlin metadata */
    private static final Lazy METHOD_ENGINE_PURGED;

    /* renamed from: B, reason: from kotlin metadata */
    private static final Lazy METHOD_ENGINE_INVERSE_PURGED;

    /* renamed from: C, reason: from kotlin metadata */
    private static final Lazy METHOD_ENGINE_SUSPENDED;

    /* renamed from: D, reason: from kotlin metadata */
    private static final Lazy METHOD_ENGINE_FIRST_FRAME;

    /* renamed from: E, reason: from kotlin metadata */
    private static final b hotPatchDownloadCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private static final ServiceConnection serviceConnection;

    /* renamed from: G, reason: from kotlin metadata */
    private static final d innerEngineStatusUpdateListener;

    /* renamed from: H, reason: from kotlin metadata */
    private static final IZPlanEngineStatusCallback zPlanEngineStatusCallback;

    @NotNull
    public static final ZPlanServiceHelper I;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy commonProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock zPlanEngineStatusLock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<ZPlanEngineStatusUpdateListener> zPlanEngineStatusUpdateListenerList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<a> zPlanStartEngineListenerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Context> refContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String startFrom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static SurfaceTexture surfaceTexture;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Surface surface;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.zplan.h zPlanServiceInterface;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.zplan.luabridge.a remoteLuaCaller;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isServiceConnected;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static boolean isEngineInitFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean isPreload;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static boolean isServiceBind;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static boolean isServiceBinding;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static Boolean serviceBindResult;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static boolean isHotPatchDownloading;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static Boolean hotPatchDownloadResult;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static int hotPatchErrorCode;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static String hotPatchErrorMessage;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private static IBinder currentService;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private static final Lazy METHOD_SERVICE_CONNECTED;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private static final Lazy METHOD_HOT_PATCH_DOWNLOAD_FAILED;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private static final Lazy METHOD_ENGINE_INIT_FINISH;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private static final Lazy METHOD_ENGINE_DESTROY;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private static final Lazy METHOD_ENGINE_PURGING;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/engine/ZPlanServiceHelper$a;", "", "", "a", "I", "()I", "startEngineState", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/zplan/engine/c;", "b", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "zPlanStartEngineListener", "<init>", "(ILjava/lang/ref/WeakReference;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int startEngineState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<com.tencent.zplan.engine.c> zPlanStartEngineListener;

        public a(int i3, @Nullable WeakReference<com.tencent.zplan.engine.c> weakReference) {
            this.startEngineState = i3;
            this.zPlanStartEngineListener = weakReference;
        }

        /* renamed from: a, reason: from getter */
        public final int getStartEngineState() {
            return this.startEngineState;
        }

        @Nullable
        public final WeakReference<com.tencent.zplan.engine.c> b() {
            return this.zPlanStartEngineListener;
        }
    }

    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/zplan/engine/ZPlanServiceHelper$b", "Lcom/tencent/zplan/resource/api/a;", "", "progress", "", "totalTaskCount", "completedTaskCount", "", "f", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "c", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "", "errorMessage", "failedTaskCount", "d", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements com.tencent.zplan.resource.api.a {
        b() {
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(@NotNull ZPlanResourceBusinessData businessData, @Nullable cy4.c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "hotPatchDownloadCallback - onDownloadSuccess");
            ZPlanHotPatchNotifyHelper.f385645a.e(businessData);
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            synchronized (zPlanServiceHelper) {
                ZPlanServiceHelper.isHotPatchDownloading = false;
                ZPlanServiceHelper.hotPatchDownloadResult = Boolean.TRUE;
                ZPlanServiceHelper.hotPatchErrorCode = 0;
                ZPlanServiceHelper.hotPatchErrorMessage = null;
                EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine", "onHotPatchLoaded", null, 4, null);
                zPlanServiceHelper.g0();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(@NotNull ZPlanSceneResourceErrType errType, int errorCode, @Nullable String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(errType, "errType");
            ZLog.f386189b.f("[zplan]_ZPlanServiceHelper", "hotPatchDownloadCallback - onDownloadError, errType: " + errType + ", errorCode: " + errorCode + ", errorMessage: " + errorMessage + ", totalTaskCount: " + totalTaskCount + ", failedTaskCount: " + failedTaskCount);
            ZPlanHotPatchNotifyHelper.f385645a.b(errType, errorCode, errorMessage, totalTaskCount, failedTaskCount);
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            synchronized (zPlanServiceHelper) {
                ZPlanServiceHelper.isHotPatchDownloading = false;
                ZPlanServiceHelper.hotPatchDownloadResult = Boolean.FALSE;
                ZPlanServiceHelper.hotPatchErrorCode = errorCode;
                ZPlanServiceHelper.hotPatchErrorMessage = errorMessage;
                zPlanServiceHelper.g0();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float progress, int totalTaskCount, int completedTaskCount) {
            a.C10071a.a(this, progress, totalTaskCount, completedTaskCount);
            ZPlanHotPatchNotifyHelper.f385645a.c(progress, totalTaskCount, completedTaskCount);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/zplan/engine/ZPlanServiceHelper$c", "Landroid/os/IBinder$DeathRecipient;", "", "binderDied", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements IBinder.DeathRecipient {
        c() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            synchronized (zPlanServiceHelper) {
                ZLog zLog = ZLog.f386189b;
                zLog.f("[zplan]_ZPlanServiceHelper", "zplan service dead begin");
                ZPlanServiceHelper.zPlanServiceInterface = null;
                ZPlanServiceHelper.isPreload = false;
                ZPlanServiceHelper.isEngineInitFinish = false;
                ZPlanServiceHelper.isServiceBind = false;
                ZPlanServiceHelper.currentService = null;
                ZPlanServiceHelper.isServiceBinding = false;
                if (ZPlanServiceHelper.r(zPlanServiceHelper)) {
                    ZPlanServiceHelper.isServiceConnected = false;
                    zPlanServiceHelper.i0(zPlanServiceHelper.b0(), Boolean.FALSE);
                }
                zLog.f("[zplan]_ZPlanServiceHelper", "zplan service dead end");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/zplan/engine/ZPlanServiceHelper$d", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "success", "engineInitFinish", "engineFirstFrame", "engineDestroy", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class d implements ZPlanEngineStatusUpdateListener {
        d() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "InnerEngineStatusUpdateListener, engineDestroy");
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "InnerEngineStatusUpdateListener, engineFirstFrame");
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            List<ReporterEventRecordTime> list;
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            synchronized (zPlanServiceHelper) {
                ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "InnerEngineStatusUpdateListener, startZPlanEngine, engineInitFinish success:" + success);
                EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine", "engineInitFinish", null, 4, null);
                com.tencent.zplan.h k3 = ZPlanServiceHelper.k(zPlanServiceHelper);
                if (k3 != null) {
                    list = k3.s0("zplan_start_engine_zplan_process");
                } else {
                    list = null;
                }
                if (list != null) {
                    for (ReporterEventRecordTime it : list) {
                        EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        engineLifeCycleReporter.i("zplan_start_engine", it);
                    }
                }
                EngineLifeCycleReporter.f385573f.s("zplan_start_engine", true);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ZPlanEngineStatusUpdateListener.a.h(this, i3, errorMessage);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean connect) {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            synchronized (zPlanServiceHelper) {
                ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "InnerEngineStatusUpdateListener, startZPlanEngine, serviceConnected:" + connect + ", hasPreload: " + ZPlanServiceHelper.q(zPlanServiceHelper));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/zplan/engine/ZPlanServiceHelper$e", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "", "onServiceConnected", "onServiceDisconnected", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@Nullable ComponentName name, @Nullable IBinder service) {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            synchronized (zPlanServiceHelper) {
                ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "onServiceConnected name : " + name + ", isEngineInitFinish=" + ZPlanServiceHelper.p(zPlanServiceHelper));
                ZPlanServiceHelper.serviceBindResult = Boolean.TRUE;
                ZPlanServiceHelper.isServiceBind = true;
                EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine", "onServiceConnected", null, 4, null);
                ZPlanServiceHelper.currentService = service;
                try {
                    zPlanServiceHelper.j0(service);
                } catch (Exception e16) {
                    ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "initLinkToDeath exception", e16);
                }
                ZPlanServiceHelper.I.g0();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@Nullable ComponentName name) {
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            synchronized (zPlanServiceHelper) {
                ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "onServiceDisconnected name : " + name);
                Boolean bool = Boolean.FALSE;
                ZPlanServiceHelper.serviceBindResult = bool;
                ZPlanServiceHelper.isServiceBind = false;
                ZPlanServiceHelper.isServiceBinding = false;
                ZPlanServiceHelper.remoteLuaCaller = null;
                ZPlanServiceHelper.zPlanServiceInterface = null;
                ZPlanServiceHelper.isPreload = false;
                ZPlanServiceHelper.isEngineInitFinish = false;
                ZPlanServiceHelper.startFrom = null;
                if (ZPlanServiceHelper.r(zPlanServiceHelper)) {
                    ZPlanServiceHelper.isServiceConnected = false;
                    zPlanServiceHelper.i0(zPlanServiceHelper.b0(), bool);
                }
                zPlanServiceHelper.N().c();
                i iVar = (i) mx4.a.f417748a.a(i.class);
                if (iVar != null) {
                    iVar.end();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    static {
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
        ZPlanServiceHelper zPlanServiceHelper = new ZPlanServiceHelper();
        I = zPlanServiceHelper;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<s>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$commonProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final s invoke() {
                Object a16 = mx4.a.f417748a.a(s.class);
                Intrinsics.checkNotNull(a16);
                return (s) a16;
            }
        });
        commonProxy = lazy;
        zPlanEngineStatusLock = new ReentrantLock();
        zPlanEngineStatusUpdateListenerList = new ArrayList();
        zPlanStartEngineListenerList = new ArrayList();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_SERVICE_CONNECTED$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "serviceConnected", Boolean.TYPE);
            }
        });
        METHOD_SERVICE_CONNECTED = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_HOT_PATCH_DOWNLOAD_FAILED$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "hotPatchDownloadFailed", Integer.TYPE, String.class);
            }
        });
        METHOD_HOT_PATCH_DOWNLOAD_FAILED = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_ENGINE_INIT_FINISH$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "engineInitFinish", Boolean.TYPE);
            }
        });
        METHOD_ENGINE_INIT_FINISH = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_ENGINE_DESTROY$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "engineDestroy", new Class[0]);
            }
        });
        METHOD_ENGINE_DESTROY = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_ENGINE_PURGING$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "enginePurging", new Class[0]);
            }
        });
        METHOD_ENGINE_PURGING = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_ENGINE_PURGED$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "enginePurged", new Class[0]);
            }
        });
        METHOD_ENGINE_PURGED = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_ENGINE_INVERSE_PURGED$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "engineInversePurged", new Class[0]);
            }
        });
        METHOD_ENGINE_INVERSE_PURGED = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_ENGINE_SUSPENDED$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "engineSuspended", new Class[0]);
            }
        });
        METHOD_ENGINE_SUSPENDED = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<Method>() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$METHOD_ENGINE_FIRST_FRAME$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Method invoke() {
                return g.f385293a.a(ZPlanEngineStatusUpdateListener.class, "engineFirstFrame", new Class[0]);
            }
        });
        METHOD_ENGINE_FIRST_FRAME = lazy10;
        hotPatchDownloadCallback = new b();
        serviceConnection = new e();
        d dVar = new d();
        innerEngineStatusUpdateListener = dVar;
        zPlanEngineStatusCallback = new IZPlanEngineStatusCallback.Stub() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$zPlanEngineStatusCallback$1
            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineDestroyed() {
                Method T;
                ZPlanServiceHelper zPlanServiceHelper2 = ZPlanServiceHelper.I;
                synchronized (zPlanServiceHelper2) {
                    ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "onEngineDestroyed");
                    ZPlanServiceHelper.isEngineInitFinish = false;
                    ZPlanServiceHelper.isServiceConnected = false;
                    ZPlanServiceHelper.zPlanServiceInterface = null;
                    ZPlanServiceHelper.isPreload = false;
                    T = zPlanServiceHelper2.T();
                    zPlanServiceHelper2.i0(T, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineFirstFrame() {
                Method U;
                ZPlanServiceHelper zPlanServiceHelper2 = ZPlanServiceHelper.I;
                synchronized (zPlanServiceHelper2) {
                    ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "onEngineFirstFrame");
                    U = zPlanServiceHelper2.U();
                    zPlanServiceHelper2.i0(U, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineInitFinish(boolean success) {
                Method V;
                ZPlanServiceHelper zPlanServiceHelper2 = ZPlanServiceHelper.I;
                synchronized (zPlanServiceHelper2) {
                    ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "onEngineInitFinish success : " + success);
                    ZPlanServiceHelper.isEngineInitFinish = success;
                    zPlanServiceHelper2.h0(success);
                    V = zPlanServiceHelper2.V();
                    zPlanServiceHelper2.i0(V, Boolean.valueOf(success));
                    com.tencent.zplan.luabridge.plugins.c.INSTANCE.c();
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineInversePurged() {
                Method W;
                ZPlanServiceHelper zPlanServiceHelper2 = ZPlanServiceHelper.I;
                synchronized (zPlanServiceHelper2) {
                    W = zPlanServiceHelper2.W();
                    zPlanServiceHelper2.i0(W, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEnginePurged() {
                Method X;
                ZPlanServiceHelper zPlanServiceHelper2 = ZPlanServiceHelper.I;
                synchronized (zPlanServiceHelper2) {
                    X = zPlanServiceHelper2.X();
                    zPlanServiceHelper2.i0(X, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEnginePurging() {
                Method Y;
                ZPlanServiceHelper zPlanServiceHelper2 = ZPlanServiceHelper.I;
                synchronized (zPlanServiceHelper2) {
                    Y = zPlanServiceHelper2.Y();
                    zPlanServiceHelper2.i0(Y, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // com.tencent.zplan.IZPlanEngineStatusCallback
            public void onEngineSuspended() {
                Method Z;
                ZPlanServiceHelper zPlanServiceHelper2 = ZPlanServiceHelper.I;
                synchronized (zPlanServiceHelper2) {
                    Z = zPlanServiceHelper2.Z();
                    zPlanServiceHelper2.i0(Z, new Object[0]);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
        zPlanServiceHelper.E0(dVar);
    }

    ZPlanServiceHelper() {
    }

    private final void B0() {
        ZLog zLog = ZLog.f386189b;
        zLog.k("[zplan]_ZPlanServiceHelper", "realInitEngine , startFrom: " + startFrom);
        if ("preload".equals(startFrom)) {
            zLog.k("[zplan]_ZPlanServiceHelper", "realInitEngine, from preload , return");
            return;
        }
        if (isEngineInitFinish) {
            zLog.k("[zplan]_ZPlanServiceHelper", "realInitEngine, isEngineInitFinish: " + isEngineInitFinish + ", return");
            return;
        }
        try {
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine", "initEngine", null, 4, null);
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.x0(c0());
            }
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine", "initEngine_end", null, 4, null);
            com.tencent.zplan.h hVar2 = zPlanServiceInterface;
            if (hVar2 != null) {
                hVar2.c3(zPlanEngineStatusCallback);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "realInitEngine", e16);
        }
    }

    private final void F0(String from, boolean isEngineReady) {
        boolean z16;
        Map mapOf;
        mx4.a aVar = mx4.a.f417748a;
        zx4.d dVar = (zx4.d) aVar.a(zx4.d.class);
        if (dVar != null) {
            z16 = dVar.c();
        } else {
            z16 = false;
        }
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "reportStartZPlanEngine, isEngineReady:" + isEngineReady + ", from:" + from + ", enableCloudRecordOnAIOTab:" + z16);
        b.Companion companion = lx4.b.INSTANCE;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("from", from), TuplesKt.to("zplan_hot_start_engine", companion.a(isEngineReady)), TuplesKt.to("enable_cloud_record_on_aio_tab", companion.a(z16)));
        lx4.b bVar = (lx4.b) aVar.a(lx4.b.class);
        if (bVar != null) {
            b.C10752b.a(bVar, null, "zplan_start_engine_main_process", mapOf, 1, null);
        }
    }

    public static /* synthetic */ void L0(ZPlanServiceHelper zPlanServiceHelper, Surface surface2, com.tencent.zplan.d dVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            dVar = null;
        }
        zPlanServiceHelper.J0(surface2, dVar);
    }

    public static /* synthetic */ void M0(ZPlanServiceHelper zPlanServiceHelper, com.tencent.zplan.d dVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            dVar = null;
        }
        zPlanServiceHelper.K0(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s N() {
        return (s) commonProxy.getValue();
    }

    private final void O0(int startEngineState, WeakReference<com.tencent.zplan.engine.c> zPlanStartEngineListener) {
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "saveZPlanStartEngineListener, startEngineState: " + startEngineState + ", zPlanStartEngineListener:" + zPlanStartEngineListener);
        if (zPlanStartEngineListener != null) {
            List<a> list = zPlanStartEngineListenerList;
            synchronized (list) {
                list.add(new a(startEngineState, zPlanStartEngineListener));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method T() {
        return (Method) METHOD_ENGINE_DESTROY.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method U() {
        return (Method) METHOD_ENGINE_FIRST_FRAME.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method V() {
        return (Method) METHOD_ENGINE_INIT_FINISH.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method W() {
        return (Method) METHOD_ENGINE_INVERSE_PURGED.getValue();
    }

    private final synchronized void W0(Context context) {
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "startServiceAndEngine, mServiceHasBind : " + isServiceBind + ", isServiceBinding: " + isServiceBinding + ", context : " + context);
        if (!isServiceBind && !isServiceBinding) {
            EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine", "startServiceAndEngine", null, 4, null);
            isServiceBinding = true;
            Intent intent = new Intent(context, (Class<?>) ZPlanEngineService.class);
            refContext = new WeakReference<>(context);
            serviceBindResult = null;
            isServiceBind = context.bindService(intent, serviceConnection, 65);
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine", "startServiceAndEngine_end", null, 4, null);
            isHotPatchDownloading = true;
            hotPatchDownloadResult = null;
            hotPatchErrorCode = 0;
            hotPatchErrorMessage = null;
            EngineLifeCycleReporter.k(engineLifeCycleReporter, "zplan_start_engine", "startLoadHotPatch", null, 4, null);
            ZPlanHotPatchNotifyHelper.f385645a.d("");
            ZPlanResourceLoadHelper.f386183a.b(hotPatchDownloadCallback);
            if (!isServiceBind) {
                com.tencent.zplan.utils.e.f386205a.a("[zplan][error]", -1001, ZPlanConstant.a.INSTANCE.a().get(-1001));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method X() {
        return (Method) METHOD_ENGINE_PURGED.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method Y() {
        return (Method) METHOD_ENGINE_PURGING.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method Z() {
        return (Method) METHOD_ENGINE_SUSPENDED.getValue();
    }

    private final Method a0() {
        return (Method) METHOD_HOT_PATCH_DOWNLOAD_FAILED.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Method b0() {
        return (Method) METHOD_SERVICE_CONNECTED.getValue();
    }

    private final synchronized Surface c0() {
        Surface surface2;
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "getSurface " + surface);
        if (surface == null) {
            surface = new Surface(d0());
        }
        surface2 = surface;
        Intrinsics.checkNotNull(surface2);
        return surface2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ZPlanEngineStatusUpdateListener> e0() {
        List<ZPlanEngineStatusUpdateListener> list;
        ReentrantLock reentrantLock = zPlanEngineStatusLock;
        reentrantLock.lock();
        try {
            list = CollectionsKt___CollectionsKt.toList(zPlanEngineStatusUpdateListenerList);
            return list;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        Boolean bool;
        Context context;
        com.tencent.zplan.luabridge.c cVar;
        IBinder iBinder = currentService;
        ZLog zLog = ZLog.f386189b;
        zLog.k("[zplan]_ZPlanServiceHelper", "handleBindServiceAndHotPatchResult, serviceBindResult: " + serviceBindResult + ", hotPatchDownloadResult: " + hotPatchDownloadResult + ", isServiceBinding: " + isServiceBinding + ", isServiceConnected: " + isServiceConnected + ", isHotPatchDownloading: " + isHotPatchDownloading + ", service:" + iBinder);
        if (iBinder != null && (bool = serviceBindResult) != null && hotPatchDownloadResult != null) {
            Object obj = Boolean.TRUE;
            if (Intrinsics.areEqual(bool, obj) && Intrinsics.areEqual(hotPatchDownloadResult, obj)) {
                zLog.k("[zplan]_ZPlanServiceHelper", "handleBindServiceAndHotPatchResult final SUCCESS");
                isServiceBinding = false;
                isServiceConnected = true;
                com.tencent.zplan.h j3 = h.a.j(iBinder);
                zPlanServiceInterface = j3;
                if (j3 != null) {
                    cVar = new com.tencent.zplan.luabridge.c(j3);
                } else {
                    cVar = null;
                }
                remoteLuaCaller = cVar;
                try {
                    B0();
                    if (!isPreload) {
                        isPreload = true;
                        z0();
                    }
                    if (!isEngineInitFinish) {
                        i0(b0(), obj);
                        N().b();
                        return;
                    } else {
                        h0(true);
                        return;
                    }
                } catch (Exception e16) {
                    zPlanServiceInterface = null;
                    isPreload = false;
                    isEngineInitFinish = false;
                    isServiceConnected = false;
                    ZLog.f386189b.l("[zplan]_ZPlanServiceHelper", "handleBindServiceAndHotPatchResult linkToDeath", e16);
                    return;
                }
            }
            WeakReference<Context> weakReference = refContext;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            zLog.f("[zplan]_ZPlanServiceHelper", "handleBindServiceAndHotPatchResult, final ERROR, context : " + context);
            if (Intrinsics.areEqual(serviceBindResult, obj) && context != null) {
                zLog.f("[zplan]_ZPlanServiceHelper", "handleBindServiceAndHotPatchResult error, notifyHotPatchDownloadFailed - " + hotPatchErrorCode + " - " + hotPatchErrorMessage);
                try {
                    context.unbindService(serviceConnection);
                } catch (Exception e17) {
                    ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "unbindService exception", e17);
                }
                Method a06 = a0();
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(hotPatchErrorCode);
                Object obj2 = hotPatchErrorMessage;
                if (obj2 == null) {
                    obj2 = "";
                }
                objArr[1] = obj2;
                i0(a06, objArr);
            } else {
                zLog.f("[zplan]_ZPlanServiceHelper", "handleBindServiceAndHotPatchResult error, notifyServiceConnected false");
                Boolean bool2 = Boolean.FALSE;
                serviceBindResult = bool2;
                isServiceBinding = false;
                isServiceConnected = false;
                remoteLuaCaller = null;
                zPlanServiceInterface = null;
                isPreload = false;
                isEngineInitFinish = false;
                i0(b0(), bool2);
            }
            h0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(boolean success) {
        List<a> list;
        com.tencent.zplan.engine.c cVar;
        com.tencent.zplan.engine.c cVar2;
        List<a> list2 = zPlanStartEngineListenerList;
        if (!list2.isEmpty()) {
            synchronized (list2) {
                list = CollectionsKt___CollectionsKt.toList(list2);
                list2.clear();
            }
            for (a aVar : list) {
                ZLog zLog = ZLog.f386189b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleStartEngineListener, listener: ");
                sb5.append(aVar.getStartEngineState());
                sb5.append(" , ");
                WeakReference<com.tencent.zplan.engine.c> b16 = aVar.b();
                if (b16 != null) {
                    cVar = b16.get();
                } else {
                    cVar = null;
                }
                sb5.append(cVar);
                zLog.k("[zplan]_ZPlanServiceHelper", sb5.toString());
                WeakReference<com.tencent.zplan.engine.c> b17 = aVar.b();
                if (b17 != null && (cVar2 = b17.get()) != null) {
                    cVar2.a(success, aVar.getStartEngineState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(final Method method, final Object... args) {
        f fVar = (f) mx4.a.f417748a.a(f.class);
        if (fVar != null) {
            f.a.a(fVar, new Runnable() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$handleZPlanEngineStatusUpdate$1
                @Override // java.lang.Runnable
                public final void run() {
                    List<ZPlanEngineStatusUpdateListener> e06;
                    long currentTimeMillis = System.currentTimeMillis();
                    e06 = ZPlanServiceHelper.I.e0();
                    for (ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener : e06) {
                        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "handleZPlanEngineStatusUpdate " + method + ", " + zPlanEngineStatusUpdateListener);
                        try {
                            Method method2 = method;
                            if (method2 != null) {
                                Object[] objArr = args;
                                method2.invoke(zPlanEngineStatusUpdateListener, Arrays.copyOf(objArr, objArr.length));
                            }
                        } catch (IllegalAccessException e16) {
                            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "handleZPlanEngineStatusUpdate, " + e16);
                        } catch (IllegalArgumentException e17) {
                            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "handleZPlanEngineStatusUpdate, " + e17);
                        } catch (InvocationTargetException e18) {
                            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "handleZPlanEngineStatusUpdate, " + e18);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    Object[] objArr2 = args;
                    ArrayList arrayList = new ArrayList(objArr2.length);
                    for (Object obj : objArr2) {
                        arrayList.add(String.valueOf(obj));
                    }
                    ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "handleZPlanEngineStatusUpdate method:" + method + ", args:" + arrayList + ", listener size:" + e06.size() + ", cost:" + currentTimeMillis2);
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(IBinder service) {
        if (service != null) {
            service.linkToDeath(new c(), 0);
        }
    }

    public static final /* synthetic */ com.tencent.zplan.h k(ZPlanServiceHelper zPlanServiceHelper) {
        return zPlanServiceInterface;
    }

    public static final /* synthetic */ boolean p(ZPlanServiceHelper zPlanServiceHelper) {
        return isEngineInitFinish;
    }

    public static final /* synthetic */ boolean q(ZPlanServiceHelper zPlanServiceHelper) {
        return isPreload;
    }

    public static final /* synthetic */ boolean r(ZPlanServiceHelper zPlanServiceHelper) {
        return isServiceConnected;
    }

    public final void A0(@Nullable String sceneData) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.h0(sceneData);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "setContext", e16);
        }
    }

    public final void C0(@NotNull MemeRecordParams params, @NotNull IZPlanRecordCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.v1(params, callback);
            }
            i iVar = (i) mx4.a.f417748a.a(i.class);
            if (iVar != null) {
                iVar.a(ZPlanHitScene.RECORD);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "recordAvatarPortrait", e16);
        }
    }

    public final void D0(@NotNull tx4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.zplan.engine.service.a.f385627c.c(listener);
    }

    public final synchronized void E0(@NotNull ZPlanEngineStatusUpdateListener statusUpdateListener) {
        Intrinsics.checkNotNullParameter(statusUpdateListener, "statusUpdateListener");
        ReentrantLock reentrantLock = zPlanEngineStatusLock;
        reentrantLock.lock();
        try {
            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "registerZPlanEngineStatusUpdateListener " + statusUpdateListener);
            List<ZPlanEngineStatusUpdateListener> list = zPlanEngineStatusUpdateListenerList;
            if (!list.contains(statusUpdateListener)) {
                list.add(statusUpdateListener);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (isServiceConnected) {
                statusUpdateListener.serviceConnected(true);
            }
            if (isEngineInitFinish) {
                statusUpdateListener.engineInitFinish(true);
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @Deprecated(message = "\u91cd\u6784callLua\u4e2d, \u8be5\u63a5\u53e3\u5c06\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "\u8bf7\u7528getLuaCaller()?.callLua\u4ee3\u66ff", imports = {}))
    public final void G(@NotNull String eventName, @Nullable String params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.s4(eventName, params, null, true);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "callLua", e16);
        }
    }

    public final void G0(int width, int height, boolean bSync) {
        boolean z16;
        zx4.d dVar = (zx4.d) mx4.a.f417748a.a(zx4.d.class);
        if (dVar != null) {
            z16 = dVar.o();
        } else {
            z16 = false;
        }
        if (z16) {
            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "resizeBackbuffer return, enableParallelWorld : " + z16);
            return;
        }
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.o4(width, height, bSync);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "resizeBackbuffer", e16);
        }
    }

    public final void H(int callbackId, @NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.w1(callbackId, result);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "callbackLua", e16);
        }
    }

    public final void H0(@NotNull Surface surface2) {
        Intrinsics.checkNotNullParameter(surface2, "surface");
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "resizeSurface : " + surface2 + ", mIZPlanServiceInterface : " + zPlanServiceInterface + TokenParser.SP);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.G1(surface2);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "resizeSurface", e16);
        }
    }

    public final void I(@Nullable Surface surface2) {
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "destroySurface : " + surface2 + ", mIZPlanServiceInterface : " + zPlanServiceInterface + TokenParser.SP);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.Z1(surface2);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "destroySurface", e16);
        }
    }

    public final void I0(int worldID, int width, int height) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.r2(worldID, width, height);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "resizeZPlanWorld", e16);
        }
    }

    public final void J(int renderHashcode, int worldID) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.Y4(renderHashcode, worldID);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "destroyWorld", e16);
        }
    }

    public final void J0(@Nullable Surface surface2, @Nullable com.tencent.zplan.d listener) {
        ZLog.f386189b.l("[zplan]_ZPlanServiceHelper", "resumeEngine,", new StackPrinter("resumeEngine"));
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.V0(surface2, listener);
            }
        } catch (Exception e16) {
            if (listener != null) {
                listener.S0(false);
            }
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "resumeEngine", e16);
        }
    }

    public final void K(int sceneType, @Nullable String sceneParams, @Nullable IZPlanEnterSceneCallback enterSceneCallback) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.G3(sceneType, sceneParams, enterSceneCallback);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "enterAvatarScene", e16);
        }
    }

    public final void K0(@Nullable com.tencent.zplan.d listener) {
        J0(null, listener);
    }

    public final void L(int worldID, int sceneType, @Nullable String sceneParams, @NotNull IZPlanEnterSceneCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.l4(worldID, sceneType, sceneParams, callback);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "enterWorldAvatarScene", e16);
        }
    }

    public final void M(int worldID, int width, int height, @Nullable Surface surface2) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.Y3(worldID, width, height, surface2);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "focusWorld", e16);
        }
    }

    public final void N0(int worldID) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.m4(worldID);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "resumeWorld", e16);
        }
    }

    public final int O() {
        Integer num;
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                num = Integer.valueOf(hVar.W0());
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            return num.intValue();
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "getEngineStatus", e16);
            return 0;
        }
    }

    public final int P() {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar == null) {
                return -1;
            }
            return hVar.y4();
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "initEngineInitListener", e16);
            return -1;
        }
    }

    public final void P0() {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.I2();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "setContext", e16);
        }
    }

    public final boolean Q() {
        boolean z16 = false;
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                z16 = hVar.H2();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "getIsUsing", e16);
        }
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "getIsUsing isUsing: " + z16);
        return z16;
    }

    public final boolean Q0(boolean using) {
        String str;
        Object a16 = mx4.a.f417748a.a(lx4.a.class);
        Intrinsics.checkNotNull(a16);
        Context context = ((lx4.a) a16).getContext();
        if (context != null) {
            str = context.getPackageName();
        } else {
            str = null;
        }
        ZLog.f386189b.l("[zplan]_ZPlanServiceHelper", "setIsUsing processName: " + str + ", using: " + using + ", ", new StackPrinter("setIsUsing"));
        com.tencent.zplan.h hVar = zPlanServiceInterface;
        if (hVar != null) {
            try {
                hVar.g3(str, using);
                return true;
            } catch (Exception e16) {
                ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "getIsUsing", e16);
                return false;
            }
        }
        return false;
    }

    public final boolean R() {
        return ZPlanEngineService.INSTANCE.k();
    }

    public final void R0(boolean using) {
        String str;
        ZLog.f386189b.l("[zplan]_ZPlanServiceHelper", "setIsUsingInZPlanProcess using: " + using + ", ", new StackPrinter("setIsUsingInZPlanProcess"));
        StringBuilder sb5 = new StringBuilder();
        Object a16 = mx4.a.f417748a.a(lx4.a.class);
        Intrinsics.checkNotNull(a16);
        Context context = ((lx4.a) a16).getContext();
        if (context != null) {
            str = context.getPackageName();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(":zplan");
        ZPlanEngineService.INSTANCE.w(sb5.toString(), using);
    }

    @Nullable
    public final com.tencent.zplan.luabridge.a S() {
        return remoteLuaCaller;
    }

    public final void S0(boolean isPortrait) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.V1(isPortrait);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "setPortraitOrientation", e16);
        }
    }

    public final void T0(boolean isPortrait, int width, int height) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.a4(isPortrait, width, height);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "setPortraitOrientation", e16);
        }
    }

    public final void U0(@NotNull Surface surface2) {
        Intrinsics.checkNotNullParameter(surface2, "surface");
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "setSurface : " + surface2 + ", mIZPlanServiceInterface : " + zPlanServiceInterface + TokenParser.SP);
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.setSurface(surface2);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, e16);
        }
    }

    public final void V0() {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.H();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "setViewportFull", e16);
        }
    }

    public final synchronized void X0(@NotNull Context context, @Nullable WeakReference<com.tencent.zplan.engine.c> zPlanStartEngineListener, @NotNull String from) {
        com.tencent.zplan.engine.c cVar;
        com.tencent.zplan.engine.c cVar2;
        com.tencent.zplan.engine.c cVar3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        startFrom = from;
        boolean l06 = l0();
        F0(from, l06);
        if (l06) {
            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "startZPlanEngine, engine ready, do nothing.");
            if (zPlanStartEngineListener != null && (cVar3 = zPlanStartEngineListener.get()) != null) {
                c.a.a(cVar3, true, 0, 2, null);
            }
            return;
        }
        boolean isZPlanEnable = N().isZPlanEnable();
        ZLog zLog = ZLog.f386189b;
        zLog.l("[zplan]_ZPlanServiceHelper", "startZPlanEngine, isZPlanEnable:" + isZPlanEnable + ", isServiceConnected:" + isServiceConnected, new StackPrinter("startZPlanEngine"));
        if (!isZPlanEnable) {
            zLog.f("[zplan]_ZPlanServiceHelper", "startZPlanEngine, zplan not enable, return.");
            if (zPlanStartEngineListener != null && (cVar2 = zPlanStartEngineListener.get()) != null) {
                c.a.a(cVar2, false, 0, 2, null);
            }
            return;
        }
        if (!isServiceBinding) {
            EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine", "startZPlanEngine", null, 4, null);
        }
        if (isServiceBind && isServiceConnected) {
            if (!isEngineInitFinish) {
                O0(2, zPlanStartEngineListener);
                B0();
                return;
            } else {
                if (zPlanStartEngineListener != null && (cVar = zPlanStartEngineListener.get()) != null) {
                    cVar.a(true, 3);
                }
                return;
            }
        }
        O0(1, zPlanStartEngineListener);
        i iVar = (i) mx4.a.f417748a.a(i.class);
        if (iVar != null) {
            iVar.begin();
        }
        W0(context);
    }

    public final synchronized void Y0(@NotNull Context context) {
        boolean z16;
        boolean z17;
        Context context2;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean Q = Q();
        ZLog zLog = ZLog.f386189b;
        zLog.k("[zplan]_ZPlanServiceHelper", "stopZPlanEngine, isUsing: " + Q + ", mServiceHasBind:" + isServiceBind + ", context : " + context);
        if (Q) {
            return;
        }
        mx4.a aVar = mx4.a.f417748a;
        zx4.d dVar = (zx4.d) aVar.a(zx4.d.class);
        if (dVar != null) {
            z16 = dVar.isPreloadEnable();
        } else {
            z16 = false;
        }
        zx4.d dVar2 = (zx4.d) aVar.a(zx4.d.class);
        if (dVar2 != null) {
            z17 = dVar2.h();
        } else {
            z17 = false;
        }
        zLog.k("[zplan]_ZPlanServiceHelper", "stopZPlanEngine, preloadEnable=" + z16 + ", killWhenPreload=" + z17);
        if (!z16 && isServiceBind) {
            WeakReference<Context> weakReference = refContext;
            if (weakReference != null && (context2 = weakReference.get()) != null) {
                context = context2;
            }
            Intrinsics.checkNotNullExpressionValue(context, "refContext?.get() ?: context");
            zLog.k("[zplan]_ZPlanServiceHelper", "stopZPlanEngine, unbindService context : " + context);
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException e16) {
                ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "stopZPlanEngine, unbindService IllegalArgumentException", e16);
            }
            isServiceBind = false;
            isServiceBinding = false;
            N().d();
        }
    }

    public final void Z0(@NotNull tx4.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        com.tencent.zplan.engine.service.a.f385627c.d(listener);
    }

    public final synchronized void a1(@NotNull ZPlanEngineStatusUpdateListener statusUpdateListener) {
        Intrinsics.checkNotNullParameter(statusUpdateListener, "statusUpdateListener");
        ReentrantLock reentrantLock = zPlanEngineStatusLock;
        reentrantLock.lock();
        try {
            ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "unRegisterZPlanEngineStatusUpdateListener " + statusUpdateListener);
            zPlanEngineStatusUpdateListenerList.remove(statusUpdateListener);
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public final synchronized SurfaceTexture d0() {
        SurfaceTexture surfaceTexture2;
        ZLog zLog = ZLog.f386189b;
        zLog.k("[zplan]_ZPlanServiceHelper", "getSurfaceTexture ");
        if (surfaceTexture == null) {
            SurfaceTexture surfaceTexture3 = new SurfaceTexture(0);
            surfaceTexture = surfaceTexture3;
            Intrinsics.checkNotNull(surfaceTexture3);
            surfaceTexture3.detachFromGLContext();
        }
        zLog.k("[zplan]_ZPlanServiceHelper", "getSurfaceTexture : " + surfaceTexture);
        surfaceTexture2 = surfaceTexture;
        Intrinsics.checkNotNull(surfaceTexture2);
        return surfaceTexture2;
    }

    public final void f0(int renderHashcode, int sceneType, int width, int height, @NotNull final IZPlanWorldCallback zplanWorldCallback) {
        Intrinsics.checkNotNullParameter(zplanWorldCallback, "zplanWorldCallback");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.l3(renderHashcode, sceneType, width, height, new IZPlanWorldCallback.Stub() { // from class: com.tencent.zplan.engine.ZPlanServiceHelper$getZPlanWorld$1
                    @Override // com.tencent.zplan.IZPlanWorldCallback
                    public void onGetZPlanWorld(@Nullable ZPlanWorld zplanWorld) {
                        IZPlanWorldCallback.this.onGetZPlanWorld(zplanWorld);
                    }
                });
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "getZPlanWorld", e16);
        }
    }

    public final boolean k0() {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                return hVar.Z4();
            }
            return true;
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "isEnginePaused", e16);
            return false;
        }
    }

    public final synchronized boolean l0() {
        boolean z16;
        if (isServiceBind && isServiceConnected) {
            if (isEngineInitFinish) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    public final boolean m0() {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar == null) {
                return false;
            }
            return hVar.e1();
        } catch (Throwable th5) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "isEngineWindowInitDone", th5);
            return false;
        }
    }

    public final boolean n0() {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar == null) {
                return false;
            }
            return hVar.w0();
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "isPortraitOrientation", e16);
            return false;
        }
    }

    public final void o0(@NotNull Set<String> uinSet) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(uinSet, "uinSet");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(uinSet, ",", null, null, 0, null, null, 62, null);
                hVar.notifyAppearanceKeyChange(joinToString$default);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "notifyAppearanceKeyChange", e16);
        }
    }

    public final void p0(@NotNull String eventName, @Nullable com.tencent.zplan.c callback) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.d1(eventName, callback);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "observeLuaEvent", e16);
        }
    }

    public final void q0() {
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "onAppBackGround");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.onAppBackground();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "onAppBackGround", e16);
        }
    }

    public final void r0() {
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "onAppForeground");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.onAppForeground();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "onAppForeground", e16);
        }
    }

    public final void s0(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.T(keyCode, event);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "onKeyEvent", e16);
        }
    }

    public final void t0(long nativeHandle, @Nullable Surface surface2, int width, int height) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.R0(nativeHandle, surface2, width, height);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "onOffscreenWorldSurfaceChanged", e16);
        }
    }

    public final void u0(long nativeHandle, @Nullable Surface surface2, int width, int height) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.O4(nativeHandle, surface2, width, height);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "onOffscreenWorldSurfaceCreated", e16);
        }
    }

    public final void v0(long nativeHandle) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.y1(nativeHandle);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "onOffscreenWorldSurfaceDestroyed", e16);
        }
    }

    public final void w0(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.onTouchEvent(event);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "onTouchEvent", e16);
        }
    }

    public final void x0() {
        ZLog.f386189b.l("[zplan]_ZPlanServiceHelper", "pauseEngine, ", new StackPrinter("pauseEngine"));
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.pauseEngine();
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "pauseEngine", e16);
        }
    }

    public final void y0(int worldID) {
        try {
            com.tencent.zplan.h hVar = zPlanServiceInterface;
            if (hVar != null) {
                hVar.y3(worldID);
            }
        } catch (Exception e16) {
            ZLog.f386189b.g("[zplan]_ZPlanServiceHelper", "pauseWorld", e16);
        }
    }

    public final void z0() {
        ZLog.f386189b.k("[zplan]_ZPlanServiceHelper", "preInitWindow, thread : " + Thread.currentThread());
    }
}
