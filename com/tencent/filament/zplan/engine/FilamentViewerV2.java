package com.tencent.filament.zplan.engine;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.animation.b;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.bgplane.Backdrop;
import com.tencent.filament.zplan.d;
import com.tencent.filament.zplan.record.callback.RecordCallback;
import com.tencent.filament.zplan.view.event.RotateParam;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import com.tencent.zplan.zplantracing.c;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import dl0.a;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u00e7\u00012\u00020\u0001:\u0002\u00e8\u0001B\u001e\u0012\u0007\u0010\u00de\u0001\u001a\u00020\r\u0012\n\b\u0002\u0010\u00e4\u0001\u001a\u00030\u00e0\u0001\u00a2\u0006\u0006\b\u00e5\u0001\u0010\u00e6\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0011\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0082 J\u0011\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0082 J9\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000bH\u0082 J!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0082 Jc\u0010%\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0082 J\u0019\u0010'\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001aH\u0082 J\u0019\u0010)\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001aH\u0082 J#\u0010,\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010\u001aH\u0082 J3\u0010/\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010\u001a2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aH\u0082 J)\u00101\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0082 J&\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002032\u0006\u0010\u000f\u001a\u00020\r2\u0006\u00102\u001a\u00020\u001aH\u0082 \u00a2\u0006\u0004\b4\u00105J6\u00106\u001a\b\u0012\u0004\u0012\u00020\u0002032\u0006\u0010\u000f\u001a\u00020\r2\u0006\u00102\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aH\u0082 \u00a2\u0006\u0004\b6\u00107J!\u00108\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 J1\u0010<\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 J\u0019\u0010?\u001a\u00020>2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u001aH\u0082 J\u0019\u0010A\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u000bH\u0082 J)\u0010B\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aH\u0082 J\u0019\u0010D\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u001aH\u0082 J\u0019\u0010E\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u001aH\u0082 J1\u0010K\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020FH\u0082 J\u0011\u0010L\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0082 J)\u0010P\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020FH\u0082 J\u0011\u0010Q\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0082 J\u0019\u0010R\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 J\u001b\u0010U\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\b\u0010T\u001a\u0004\u0018\u00010SH\u0082 J\u001f\u0010X\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001a0VH\u0082 J\u0019\u0010Z\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\u000bH\u0082 J\u0011\u0010[\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0082 J\u0011\u0010\\\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rH\u0082 JA\u0010d\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00042\u0006\u0010c\u001a\u00020bH\u0082 J\u0019\u0010f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u000bH\u0082 J\u0019\u0010h\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010g\u001a\u00020\u001aH\u0082 J\u0019\u0010j\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010i\u001a\u00020\u001aH\u0082 J\u0019\u0010l\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010k\u001a\u00020\u001aH\u0082 J\u0019\u0010n\u001a\u00020F2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010m\u001a\u00020\u000bH\u0082 J\u0019\u0010p\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010o\u001a\u00020\u001aH\u0082 J\u0019\u0010r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010q\u001a\u00020\u001aH\u0082 J\u0019\u0010s\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 J\u0019\u0010u\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010t\u001a\u00020\u0004H\u0082 J1\u0010y\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010v\u001a\u00020\u000b2\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020FH\u0082 J&\u0010}\u001a\u00020\u00062\u0006\u0010{\u001a\u00020z2\u0006\u0010\u0013\u001a\u00020|2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J\u0016\u0010~\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014J&\u0010\u007f\u001a\u00020\u00062\u0006\u0010v\u001a\u00020\u000b2\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020FJK\u0010\u0082\u0001\u001a\u00020\u000b2\b\u0010\u0081\u0001\u001a\u00030\u0080\u00012\u0006\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000bJ\u000f\u0010\u0082\u0001\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001aJ\u001b\u0010\u0085\u0001\u001a\u00020\u00062\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0006\u00100\u001a\u00020\u001aJ*\u0010\u0085\u0001\u001a\u00020\u00062\b\u0010\u0087\u0001\u001a\u00030\u0086\u00012\t\u0010+\u001a\u0005\u0018\u00010\u0086\u00012\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\u0010\u0010\u0089\u0001\u001a\u00020\u00062\u0007\u0010(\u001a\u00030\u0088\u0001J\u0010\u0010\u008a\u0001\u001a\u00020\u00062\u0007\u0010(\u001a\u00030\u0088\u0001J\u0007\u0010\u008b\u0001\u001a\u00020\u0006J\u001f\u0010\u008c\u0001\u001a\u00020\u000b2\b\b\u0002\u0010@\u001a\u00020\u000b2\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\u000f\u0010\u008d\u0001\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u001aJ\u0011\u0010\u008d\u0001\u001a\u00020\u00062\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001J\u0013\u0010\u0092\u0001\u001a\u00020\u00062\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001J,\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u0002032\u0006\u00102\u001a\u00020\u001a2\f\b\u0002\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J%\u0010\u0097\u0001\u001a\u00020\u00062\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00012\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J\u0011\u0010\u009a\u0001\u001a\u00020\u00062\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001J'\u0010\u009b\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0006\u0010=\u001a\u00020\u001aJ\u0019\u0010\u00a0\u0001\u001a\u00020\u00062\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u00a1\u0001\u001a\u00020\u0006H\u0004J\u0011\u0010\u00a4\u0001\u001a\u00020\u00062\b\u0010\u00a3\u0001\u001a\u00030\u00a2\u0001J\u0007\u0010\u00a5\u0001\u001a\u00020\u0006J\u001f\u0010\u00a6\u0001\u001a\u00020\u00062\u0006\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020FJ\u0007\u0010\u00a7\u0001\u001a\u00020\u0006J\u000f\u0010\u00a8\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0011\u0010\u00a9\u0001\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010SJ\u0015\u0010\u00aa\u0001\u001a\u00020\u00062\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001a0VJ\u000f\u0010\u00ab\u0001\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u000bJ9\u0010\u00ac\u0001\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00142\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00042\u0006\u0010c\u001a\u00020bJ\u0007\u0010\u00ad\u0001\u001a\u00020\u0006J\u0007\u0010\u00ae\u0001\u001a\u00020\u0006J\u0010\u0010\u00b0\u0001\u001a\u00020\u00062\u0007\u0010\u00af\u0001\u001a\u00020\u000bJ\u000f\u0010\u00b1\u0001\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u001aJ\u000f\u0010\u00b2\u0001\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u001aJ\u000f\u0010\u00b3\u0001\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u001aJ.\u0010\u00b7\u0001\u001a\u00020\u00062%\u0010\u00b6\u0001\u001a \u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00b4\u0001j\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`\u00b5\u0001J\u000f\u0010\u00b8\u0001\u001a\u00020F2\u0006\u0010m\u001a\u00020\u000bJ\u0010\u0010\u00ba\u0001\u001a\u00020\u00062\u0007\u0010\u00b9\u0001\u001a\u00020\u001aJ\u000f\u0010\u00bb\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u00bd\u0001\u001a\u00020\u00062\u0007\u0010\u00bc\u0001\u001a\u00020\u0004R)\u0010\u00be\u0001\u001a\u00020\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00be\u0001\u0010\u00bf\u0001\u001a\u0006\b\u00c0\u0001\u0010\u00c1\u0001\"\u0006\b\u00c2\u0001\u0010\u00c3\u0001R#\u0010\u00c5\u0001\u001a\f\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u00c4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u00c6\u0001R \u0010\u00c8\u0001\u001a\u00030\u00c7\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00c8\u0001\u0010\u00c9\u0001\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001R\u001c\u0010\u00cc\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001R%\u0010\u00d0\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00060\u00cf\u00010\u00ce\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u00d1\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u00d2\u0001R\u001a\u0010+\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b+\u0010\u00d2\u0001R\u0017\u0010\u00d3\u0001\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d3\u0001\u0010\u00d4\u0001R)\u0010\u00d5\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001\"\u0006\b\u00d9\u0001\u0010\u00da\u0001R)\u0010\u00db\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00db\u0001\u0010\u00d6\u0001\u001a\u0006\b\u00dc\u0001\u0010\u00d8\u0001\"\u0006\b\u00dd\u0001\u0010\u00da\u0001R\u001f\u0010\u00de\u0001\u001a\u00020\r8\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00de\u0001\u0010\u00bf\u0001\u001a\u0006\b\u00df\u0001\u0010\u00c1\u0001R\u0018\u0010\u00e3\u0001\u001a\u00030\u00e0\u00018\u0016X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00e1\u0001\u0010\u00e2\u0001\u00a8\u0006\u00e9\u0001"}, d2 = {"Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "animation", "", "now", "", QZoneJsConstants.METHOD_PLAY, "Lcom/tencent/filament/zplan/animation/a;", "track", "playAnimationWithTrack", "", "disableSpan", "", "nCreateViewer", "nativeViewer", "nDestroyViewer", "", "nativeWindow", "surfaceTexture", "", "width", "height", "cppShouldRetain", "nCreateSwapChain", "nSetViewport", "", "shaderDir", "kawaiiPath", "sceneConfig", "lutTexturePath", "enablePlanarReflection", "enablePlanarShadow", "enablePelvisOffset", "useZPlanMaterial", "enableOpenGLLocalShaderBinary", "enableBloom", "nBoot", "bootResourceString", "nBootWithString", "colorInfo", "nUpdateColorInfo", "avatarContent", "avatarMask", "nReloadAvatar", "traceId", TPReportKeys.LiveExKeys.LIVE_FX_SPANID, "nReloadAvatarWithSpan", "avatarString", "nReloadAvatarWithString", "animationGltfPath", "", "nLoadAnimation", "(JLjava/lang/String;)[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "nLoadAnimationWithSpan", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "nPlayAnimation", "start", "end", "duration", "nPlayCameraAnimation", "nodeName", "", "nGetNodeCoordinate", "needRecord", "nRender", "nRenderWithSpan", "jsonString", "nSetCamera", "nSetLights", "", "axisX", "axisY", "axisZ", "angle", "nRotateAvatar", "nResetRotation", "centerLocationX", "centerLocationY", "scrollDelta", "nScrollCameraManipulator", "nResetCameraManipulator", "nkawaiiPhysicsUpdate", "Lcom/tencent/filament/zplan/bgplane/Backdrop;", "backdrop", "nSetBackdrop", "", "paths", "nPreCompiledShader", "canShowHandHeld", "nSetHandHeldShow", "nFlushAndWait", "nDestroySwapChain", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "trackGroupString", "beginTime", "endTime", "frameInterval", "Lcom/tencent/filament/zplan/record/callback/RecordCallback;", "callback", "nRecord", "enableFrustumCulling", "nSetEnableFrustumCulling", "attachments", "nSetAttachments", "boneFix", "nSetAnimationBoneFix", "params", "nSetGlobalMaterialParams", "isAverage", "nGetFps", "ugc_res_path_json_string", "nUpdateAvatarUgc", "avatar_slot_primitive_mask", "nShowSlotPrimitivesByMask", "nUpdateParticleSystem", "delta_time", "nUpdateParticleSystemWithDeltaTime", "enableShadow", "enableFxaa", "renderTargetScale", "nSetOptimizeOptions", "Landroid/view/Surface;", "surface", "Landroid/graphics/SurfaceTexture;", "attach", "setViewPort", "setOptimizeOptions", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "resource", "boot", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "reloadAvatar", "Lorg/json/JSONObject;", "avatar", "Lcom/tencent/filament/zplan/avatar/model/a;", "updateColorInfoWithCpp", "updateColorInfo", "destroy", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "setCamera", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "cameraParams", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "lights", "setLights", "loadAnimation", "(Ljava/lang/String;Lcom/tencent/zplan/zplantracing/c;)[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "", "pixels", "onRecordFrame", "Lcom/tencent/filament/zplan/d;", "listener", "recordFrame", "playCameraAnimation", "Landroid/graphics/Point;", "getNodePoint", "Lcom/tencent/filament/zplan/animation/b;", "trackGroup", "playAnimationWithTrackGroup", "checkAndLogRunningThread", "Lcom/tencent/filament/zplan/view/event/a;", "rotateParam", "rotateAvatar", "resetRotation", "scrollCameraManipulator", "resetCameraManipulator", "kawaiiPhysicsUpdate", "setBackdrop", "preCompiledShader", "setHandHeldShow", QQPermissionConstants.Permission.AUIDO_GROUP, "flushAndWait", "destroySwapChain", "enable", "setEnableFrustumCulling", "setAttachments", "setAnimationBoneFix", "setGlobalMaterialParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ugcResMap", "updateAvatarUgc", "getFps", "avatarSlotPrimitiveMask", "showSlotPrimitivesByMask", "updateParticleSystem", "deltaTime", "updateParticleSystemWithDeltaTime", "nativeObject", "J", "getNativeObject", "()J", "setNativeObject", "(J)V", "Ljava/lang/ref/WeakReference;", "recordFrameListener", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "booted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getBooted", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "bootResource", "Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "bootingOperations", "Lkotlinx/coroutines/channels/Channel;", "Lorg/json/JSONObject;", "isPublicVersion", "Z", "viewportWidth", "I", "getViewportWidth", "()I", "setViewportWidth", "(I)V", "viewportHeight", "getViewportHeight", "setViewportHeight", "viewerThreadId", "getViewerThreadId", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "context", "<init>", "(JLkotlin/coroutines/CoroutineContext;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class FilamentViewerV2 implements CoroutineScope {
    private static final String TAG = "FilamentViewerV2";
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private JSONObject avatar;
    private JSONObject avatarMask;
    private BootResourceModel bootResource;

    @NotNull
    private final AtomicBoolean booted;
    private final Channel<Function0<Unit>> bootingOperations;
    private final boolean isPublicVersion;
    private long nativeObject;
    private WeakReference<d> recordFrameListener;
    private final long viewerThreadId;
    private volatile int viewportHeight;
    private volatile int viewportWidth;

    public FilamentViewerV2(long j3, @NotNull CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = CoroutineScopeKt.CoroutineScope(context);
        this.viewerThreadId = j3;
        this.booted = new AtomicBoolean(false);
        this.bootingOperations = ChannelKt.Channel$default(0, null, null, 7, null);
        a aVar = (a) fl0.a.f399763a.a(a.class);
        this.isPublicVersion = aVar != null ? aVar.isPublicVersion() : true;
        this.nativeObject = nCreateViewer(FilamentFeatureUtil.f106409g.b());
    }

    public static /* synthetic */ boolean boot$default(FilamentViewerV2 filamentViewerV2, BootResourceModel bootResourceModel, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, Object obj) {
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z27 = false;
            } else {
                z27 = z16;
            }
            if ((i3 & 8) != 0) {
                z28 = false;
            } else {
                z28 = z17;
            }
            if ((i3 & 16) != 0) {
                z29 = false;
            } else {
                z29 = z18;
            }
            if ((i3 & 32) != 0) {
                z36 = true;
            } else {
                z36 = z19;
            }
            if ((i3 & 64) != 0) {
                z37 = false;
            } else {
                z37 = z26;
            }
            return filamentViewerV2.boot(bootResourceModel, str, z27, z28, z29, z36, z37);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: boot");
    }

    public static /* synthetic */ FilamentAnimation[] loadAnimation$default(FilamentViewerV2 filamentViewerV2, String str, c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                cVar = null;
            }
            return filamentViewerV2.loadAnimation(str, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAnimation");
    }

    private final native boolean nBoot(long nativeViewer, String shaderDir, String kawaiiPath, String sceneConfig, String lutTexturePath, boolean enablePlanarReflection, boolean enablePlanarShadow, boolean enablePelvisOffset, boolean useZPlanMaterial, boolean enableOpenGLLocalShaderBinary, boolean enableBloom);

    private final native boolean nBootWithString(long nativeViewer, String bootResourceString);

    private final native void nCreateSwapChain(long nativeViewer, Object nativeWindow, Object surfaceTexture, int width, int height, boolean cppShouldRetain);

    private final native long nCreateViewer(boolean disableSpan);

    private final native void nDestroySwapChain(long nativeViewer);

    private final native void nDestroyViewer(long nativeViewer);

    private final native void nFlushAndWait(long nativeViewer);

    private final native float nGetFps(long nativeViewer, boolean isAverage);

    private final native int[] nGetNodeCoordinate(long nativeViewer, String nodeName);

    private final native FilamentAnimation[] nLoadAnimation(long nativeViewer, String animationGltfPath);

    private final native FilamentAnimation[] nLoadAnimationWithSpan(long nativeViewer, String animationGltfPath, String traceId, String spanId);

    private final native void nPlayAnimation(long nativeViewer, FilamentAnimation animation, double now);

    private final native void nPlayCameraAnimation(long nativeViewer, String start, String end, double duration, double now);

    private final native void nPreCompiledShader(long nativeViewer, Iterable<String> paths);

    private final native void nRecord(long nativeViewer, int taskId, String trackGroupString, double beginTime, double endTime, double frameInterval, RecordCallback callback);

    private final native void nReloadAvatar(long nativeViewer, String avatarContent, String avatarMask);

    private final native void nReloadAvatarWithSpan(long nativeViewer, String avatarContent, String avatarMask, String traceId, String spanId);

    private final native void nReloadAvatarWithString(long nativeViewer, String traceId, String spanId, String avatarString);

    private final native boolean nRender(long nativeViewer, boolean needRecord);

    private final native boolean nRenderWithSpan(long nativeViewer, boolean needRecord, String traceId, String spanId);

    private final native void nResetCameraManipulator(long nativeViewer);

    private final native void nResetRotation(long nativeViewer);

    private final native void nRotateAvatar(long nativeViewer, float axisX, float axisY, float axisZ, float angle);

    private final native void nScrollCameraManipulator(long nativeViewer, float centerLocationX, float centerLocationY, float scrollDelta);

    private final native void nSetAnimationBoneFix(long nativeViewer, String boneFix);

    private final native void nSetAttachments(long nativeViewer, String attachments);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nSetBackdrop(long nativeViewer, Backdrop backdrop);

    private final native void nSetCamera(long nativeViewer, String jsonString);

    private final native void nSetEnableFrustumCulling(long nativeViewer, boolean enableFrustumCulling);

    private final native void nSetGlobalMaterialParams(long nativeViewer, String params);

    private final native void nSetHandHeldShow(long nativeViewer, boolean canShowHandHeld);

    private final native void nSetLights(long nativeViewer, String jsonString);

    private final native void nSetOptimizeOptions(long nativeViewer, boolean enableShadow, boolean enableFxaa, boolean enableBloom, float renderTargetScale);

    private final native void nSetViewport(long nativeViewer, int width, int height);

    private final native void nShowSlotPrimitivesByMask(long nativeViewer, String avatar_slot_primitive_mask);

    private final native void nUpdateAvatarUgc(long nativeViewer, String ugc_res_path_json_string);

    private final native void nUpdateColorInfo(long nativeViewer, String colorInfo);

    private final native void nUpdateParticleSystem(long nativeViewer, double now);

    private final native void nUpdateParticleSystemWithDeltaTime(long nativeViewer, double delta_time);

    private final native void nkawaiiPhysicsUpdate(long nativeViewer, double now);

    private final void playAnimation(FilamentAnimation animation, double now) {
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            nPlayAnimation(this.nativeObject, animation, now);
        }
    }

    private final void playAnimationWithTrack(com.tencent.filament.zplan.animation.a track, double now) {
        Pair<FilamentAnimation, Double> b16 = track.b(now);
        FilamentAnimation first = b16.getFirst();
        double doubleValue = b16.getSecond().doubleValue();
        if (first != null) {
            playAnimation(first, doubleValue);
        }
    }

    public static /* synthetic */ void reloadAvatar$default(FilamentViewerV2 filamentViewerV2, JSONObject jSONObject, JSONObject jSONObject2, c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                cVar = null;
            }
            filamentViewerV2.reloadAvatar(jSONObject, jSONObject2, cVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadAvatar");
    }

    public static /* synthetic */ boolean render$default(FilamentViewerV2 filamentViewerV2, boolean z16, c cVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                cVar = null;
            }
            return filamentViewerV2.render(z16, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: render");
    }

    public final void attach(@NotNull Surface surface, @NotNull SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nCreateSwapChain");
        this.viewportWidth = width;
        this.viewportHeight = height;
        nCreateSwapChain(this.nativeObject, surface, surfaceTexture, width, height, false);
    }

    public final boolean boot(@NotNull BootResourceModel resource, @NotNull String sceneConfig, boolean enablePlanarReflection, boolean enablePlanarShadow, boolean enablePelvisOffset, boolean useZPlanMaterial, boolean enableOpenGLLocalShaderBinary) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(sceneConfig, "sceneConfig");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return false;
        }
        FLog fLog = FLog.INSTANCE;
        fLog.i(TAG, "nBoot");
        if (!nBoot(this.nativeObject, String.valueOf(resource.getShaderDir()), resource.getKawaiiPath(), sceneConfig, resource.getLutTexturePath(), enablePlanarReflection, enablePlanarShadow, enablePelvisOffset, useZPlanMaterial, enableOpenGLLocalShaderBinary, FilamentFeatureUtil.f106409g.d())) {
            fLog.e(TAG, "boot fail");
            return false;
        }
        this.booted.set(true);
        this.bootResource = resource;
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new FilamentViewerV2$boot$1(this, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkAndLogRunningThread() {
        boolean z16;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        if (currentThread.getId() == this.viewerThreadId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Exception exc = new Exception("[\u4e0d\u662f\u5f02\u5e38!!] Warning, must invoke FilamentViewerV2 method within Viewer Thread!");
            FLog.INSTANCE.e(TAG, "[\u4e0d\u662f\u5f02\u5e38!!] Warning, must invoke FilamentViewerV2 method within Viewer Thread!", exc);
            if (!this.isPublicVersion) {
                throw exc;
            }
        }
    }

    public final void destroy() {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nDestroyViewer");
        nDestroyViewer(this.nativeObject);
        this.nativeObject = 0L;
        SendChannel.DefaultImpls.close$default(this.bootingOperations, null, 1, null);
        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) this.bootingOperations, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(this, "destroy", null, 2, null);
    }

    public final void destroySwapChain() {
        if (this.nativeObject != 0 && this.booted.get()) {
            nDestroySwapChain(this.nativeObject);
        }
    }

    public final void flushAndWait() {
        if (this.nativeObject != 0 && this.booted.get()) {
            nFlushAndWait(this.nativeObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AtomicBoolean getBooted() {
        return this.booted;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public final float getFps(boolean isAverage) {
        if (this.nativeObject != 0 && this.booted.get()) {
            return nGetFps(this.nativeObject, isAverage);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getNativeObject() {
        return this.nativeObject;
    }

    @Nullable
    public final Point getNodePoint(@NotNull String nodeName) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        if (this.nativeObject == 0 || !this.booted.get()) {
            return null;
        }
        int[] nGetNodeCoordinate = nGetNodeCoordinate(this.nativeObject, nodeName);
        if (nGetNodeCoordinate.length != 2) {
            return null;
        }
        return new Point(nGetNodeCoordinate[0], nGetNodeCoordinate[1]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getViewerThreadId() {
        return this.viewerThreadId;
    }

    public final int getViewportHeight() {
        return this.viewportHeight;
    }

    public final int getViewportWidth() {
        return this.viewportWidth;
    }

    public final void kawaiiPhysicsUpdate(double now) {
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nkawaiiPhysicsUpdate(j3, now);
    }

    @NotNull
    public final FilamentAnimation[] loadAnimation(@NotNull String animationGltfPath, @Nullable c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(animationGltfPath, "animationGltfPath");
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            if (zplanSpanContext != null) {
                return nLoadAnimationWithSpan(this.nativeObject, animationGltfPath, zplanSpanContext.getTraceId(), zplanSpanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String());
            }
            return nLoadAnimation(this.nativeObject, animationGltfPath);
        }
        return new FilamentAnimation[0];
    }

    @NativeMethodProxy
    public final void onRecordFrame(@Nullable byte[] pixels, int width, int height) {
        Integer num;
        d dVar;
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordFrame, pixels: ");
        if (pixels != null) {
            num = Integer.valueOf(pixels.length);
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", ");
        sb5.append(width);
        sb5.append(", ");
        sb5.append(height);
        fLog.i(TAG, sb5.toString());
        WeakReference<d> weakReference = this.recordFrameListener;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            dVar.a(pixels, width, height);
        }
    }

    public final void playAnimationWithTrackGroup(@NotNull b trackGroup, double now) {
        Intrinsics.checkNotNullParameter(trackGroup, "trackGroup");
        checkAndLogRunningThread();
        for (com.tencent.filament.zplan.animation.a aVar : trackGroup.c()) {
            playAnimationWithTrack(aVar, now);
        }
    }

    public final void playCameraAnimation(@NotNull String start, @NotNull String end, double duration, double now) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            nPlayCameraAnimation(this.nativeObject, start, end, duration, now);
        }
    }

    public final void preCompiledShader(@NotNull Iterable<String> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        if (this.nativeObject != 0 && this.booted.get()) {
            nPreCompiledShader(this.nativeObject, paths);
        }
    }

    public final void record(int taskId, @NotNull b trackGroup, double beginTime, double endTime, double frameInterval, @NotNull RecordCallback callback) {
        Intrinsics.checkNotNullParameter(trackGroup, "trackGroup");
        Intrinsics.checkNotNullParameter(callback, "callback");
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            long j3 = this.nativeObject;
            String jSONObject = trackGroup.d().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "trackGroup.toJSON().toString()");
            nRecord(j3, taskId, jSONObject, beginTime, endTime, frameInterval, callback);
        }
    }

    public final void recordFrame(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        checkAndLogRunningThread();
        this.recordFrameListener = new WeakReference<>(listener);
    }

    public final void reloadAvatar(@Nullable c zplanSpanContext, @NotNull String avatarString) {
        String str;
        String traceId;
        Intrinsics.checkNotNullParameter(avatarString, "avatarString");
        checkAndLogRunningThread();
        if (this.nativeObject == 0 || !this.booted.get()) {
            return;
        }
        nReloadAvatarWithString(this.nativeObject, (zplanSpanContext == null || (traceId = zplanSpanContext.getTraceId()) == null) ? "" : traceId, (zplanSpanContext == null || (str = zplanSpanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String()) == null) ? "" : str, avatarString);
    }

    public final boolean render(boolean needRecord, @Nullable c zplanSpanContext) {
        if (!this.booted.get()) {
            return false;
        }
        checkAndLogRunningThread();
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return false;
        }
        if (zplanSpanContext != null) {
            return nRenderWithSpan(j3, needRecord, zplanSpanContext.getTraceId(), zplanSpanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String());
        }
        return nRender(j3, needRecord);
    }

    public final void resetCameraManipulator() {
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            FLog.INSTANCE.i(TAG, "nResetCameraManipulator");
            nResetCameraManipulator(this.nativeObject);
        }
    }

    public final void resetRotation() {
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            FLog.INSTANCE.i(TAG, "nResetRotation");
            nResetRotation(this.nativeObject);
        }
    }

    public final void rotateAvatar(@NotNull RotateParam rotateParam) {
        Intrinsics.checkNotNullParameter(rotateParam, "rotateParam");
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            FLog.INSTANCE.i(TAG, "rotateAvatar");
            nRotateAvatar(this.nativeObject, rotateParam.getAxisX(), rotateParam.getAxisY(), rotateParam.getAxisZ(), rotateParam.getAngle());
        }
    }

    public final void scrollCameraManipulator(float centerLocationX, float centerLocationY, float scrollDelta) {
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            FLog.INSTANCE.i(TAG, "nScrollCameraManipulator");
            nScrollCameraManipulator(this.nativeObject, centerLocationX, centerLocationY, scrollDelta);
        }
    }

    public final void setAnimationBoneFix(@NotNull String boneFix) {
        Intrinsics.checkNotNullParameter(boneFix, "boneFix");
        if (this.nativeObject != 0 && this.booted.get()) {
            nSetAnimationBoneFix(this.nativeObject, boneFix);
        }
    }

    public final void setAttachments(@NotNull String attachments) {
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        if (this.nativeObject != 0 && this.booted.get()) {
            nSetAttachments(this.nativeObject, attachments);
        }
    }

    public final void setBackdrop(@Nullable final Backdrop backdrop) {
        try {
            ChannelsKt.sendBlocking(this.bootingOperations, new Function0<Unit>() { // from class: com.tencent.filament.zplan.engine.FilamentViewerV2$setBackdrop$1
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
                    if (FilamentViewerV2.this.getNativeObject() == 0 || !FilamentViewerV2.this.getBooted().get()) {
                        return;
                    }
                    FilamentViewerV2 filamentViewerV2 = FilamentViewerV2.this;
                    filamentViewerV2.nSetBackdrop(filamentViewerV2.getNativeObject(), backdrop);
                }
            });
        } catch (ClosedSendChannelException e16) {
            FLog.INSTANCE.e(TAG, "setBackdrop: ", e16);
        }
    }

    public final void setCamera(@NotNull String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        checkAndLogRunningThread();
        if (this.nativeObject == 0 || !this.booted.get()) {
            return;
        }
        FLog.INSTANCE.i(TAG, "nSetCamera:" + jsonString);
        nSetCamera(this.nativeObject, jsonString);
    }

    public final void setEnableFrustumCulling(boolean enable) {
        if (this.nativeObject != 0 && this.booted.get()) {
            nSetEnableFrustumCulling(this.nativeObject, enable);
        }
    }

    public final void setGlobalMaterialParams(@NotNull String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.nativeObject != 0 && this.booted.get()) {
            nSetGlobalMaterialParams(this.nativeObject, params);
        }
    }

    public final void setHandHeldShow(boolean canShowHandHeld) {
        if (this.nativeObject != 0 && this.booted.get()) {
            nSetHandHeldShow(this.nativeObject, canShowHandHeld);
        }
    }

    public final void setLights(@Nullable LightsParams lights) {
        IndirectLight indirectLight;
        boolean z16;
        String str;
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            if (Build.VERSION.SDK_INT < 28 && lights != null) {
                lights.setSpotLights(new ArrayList());
            }
            if (lights != null) {
                indirectLight = lights.getIndirectLight();
            } else {
                indirectLight = null;
            }
            if (indirectLight != null) {
                if (indirectLight.getPath().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    BootResourceModel bootResourceModel = this.bootResource;
                    if (bootResourceModel == null || (str = bootResourceModel.getIndirectLightPath()) == null) {
                        str = "";
                    }
                    indirectLight.setPath(str);
                }
            }
            try {
                String jsonString = new Gson().toJson(lights);
                FLog.INSTANCE.i(TAG, "setLights");
                long j3 = this.nativeObject;
                Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
                nSetLights(j3, jsonString);
            } catch (Throwable th5) {
                FLog.INSTANCE.e(TAG, "setLights toJson failed", th5);
            }
        }
    }

    protected final void setNativeObject(long j3) {
        this.nativeObject = j3;
    }

    public final void setOptimizeOptions(boolean enableShadow, boolean enableFxaa, boolean enableBloom, float renderTargetScale) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setOptimizeOptions, " + enableShadow + " , " + enableFxaa + " ," + enableBloom + " , " + renderTargetScale);
        nSetOptimizeOptions(this.nativeObject, enableShadow, enableFxaa, enableBloom, renderTargetScale);
    }

    public final void setViewPort(int width, int height) {
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return;
        }
        FLog.INSTANCE.i(TAG, "setViewPort, " + width + " * " + height);
        this.viewportWidth = width;
        this.viewportHeight = height;
        nSetViewport(this.nativeObject, width, height);
    }

    public final void setViewportHeight(int i3) {
        this.viewportHeight = i3;
    }

    public final void setViewportWidth(int i3) {
        this.viewportWidth = i3;
    }

    public final void showSlotPrimitivesByMask(@NotNull String avatarSlotPrimitiveMask) {
        Intrinsics.checkNotNullParameter(avatarSlotPrimitiveMask, "avatarSlotPrimitiveMask");
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            nShowSlotPrimitivesByMask(this.nativeObject, avatarSlotPrimitiveMask);
        }
    }

    public final void updateAvatarUgc(@NotNull HashMap<String, String> ugcResMap) {
        Intrinsics.checkNotNullParameter(ugcResMap, "ugcResMap");
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, String> entry : ugcResMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("slotId", key);
                jSONObject2.put("ugcPath", value);
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("ugcResourceMap", jSONArray);
            long j3 = this.nativeObject;
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "ugcResMapOjb.toString()");
            nUpdateAvatarUgc(j3, jSONObject3);
        }
    }

    public final void updateColorInfo(@NotNull com.tencent.filament.zplan.avatar.model.a colorInfo) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        checkAndLogRunningThread();
        JSONObject jSONObject = this.avatar;
        if (jSONObject == null) {
            FLog.INSTANCE.e(TAG, "updateColorInfo fail. avatar is null");
            return;
        }
        if (jSONObject != null) {
            colorInfo.a(jSONObject);
        }
        if (this.nativeObject != 0 && this.booted.get()) {
            FLog.INSTANCE.i(TAG, "updateColorInfo");
            long j3 = this.nativeObject;
            JSONObject jSONObject2 = this.avatar;
            if (jSONObject2 == null || (str = jSONObject2.toString()) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "avatar?.toString() ?: \"\"");
            JSONObject jSONObject3 = this.avatarMask;
            if (jSONObject3 != null) {
                str2 = jSONObject3.toString();
            } else {
                str2 = null;
            }
            nReloadAvatar(j3, str, str2);
        }
    }

    public final void updateColorInfoWithCpp(@NotNull com.tencent.filament.zplan.avatar.model.a colorInfo) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        checkAndLogRunningThread();
        if (this.nativeObject != 0 && this.booted.get()) {
            FLog.INSTANCE.i(TAG, "updateColorInfo");
            nUpdateColorInfo(this.nativeObject, colorInfo.f());
        }
    }

    public final void updateParticleSystem(double now) {
        if (this.nativeObject != 0 && this.booted.get()) {
            nUpdateParticleSystem(this.nativeObject, now);
        }
    }

    public final void updateParticleSystemWithDeltaTime(double deltaTime) {
        if (this.nativeObject != 0 && this.booted.get()) {
            nUpdateParticleSystemWithDeltaTime(this.nativeObject, deltaTime);
        }
    }

    public final void setCamera(@NotNull CameraParams cameraParams) {
        Intrinsics.checkNotNullParameter(cameraParams, "cameraParams");
        checkAndLogRunningThread();
        if (this.nativeObject == 0 || !this.booted.get()) {
            return;
        }
        try {
            String jsonString = new Gson().toJson(cameraParams);
            FLog.INSTANCE.i(TAG, "setCamera");
            long j3 = this.nativeObject;
            Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
            nSetCamera(j3, jsonString);
        } catch (Throwable th5) {
            FLog.INSTANCE.e(TAG, "setCamera toJson failed", th5);
        }
    }

    public /* synthetic */ FilamentViewerV2(long j3, CoroutineContext coroutineContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? Dispatchers.getDefault() : coroutineContext);
    }

    public final void reloadAvatar(@NotNull JSONObject avatar, @Nullable JSONObject avatarMask, @Nullable c zplanSpanContext) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        checkAndLogRunningThread();
        if (this.nativeObject == 0 || !this.booted.get()) {
            return;
        }
        FLog.INSTANCE.i(TAG, "reloadAvatar");
        this.avatar = avatar;
        this.avatarMask = avatarMask;
        if (zplanSpanContext == null) {
            long j3 = this.nativeObject;
            String jSONObject = avatar.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "avatar.toString()");
            nReloadAvatar(j3, jSONObject, avatarMask != null ? avatarMask.toString() : null);
            return;
        }
        long j16 = this.nativeObject;
        String jSONObject2 = avatar.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "avatar.toString()");
        nReloadAvatarWithSpan(j16, jSONObject2, avatarMask != null ? avatarMask.toString() : null, zplanSpanContext.getTraceId(), zplanSpanContext.getCom.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_FX_SPANID java.lang.String());
    }

    public final boolean boot(@NotNull String bootResourceString) {
        Intrinsics.checkNotNullParameter(bootResourceString, "bootResourceString");
        checkAndLogRunningThread();
        if (this.nativeObject == 0) {
            return false;
        }
        FLog fLog = FLog.INSTANCE;
        fLog.i(TAG, "nBoot");
        if (!nBootWithString(this.nativeObject, bootResourceString)) {
            fLog.e(TAG, "boot fail");
            return false;
        }
        this.booted.set(true);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new FilamentViewerV2$boot$2(this, null), 3, null);
        return true;
    }
}
