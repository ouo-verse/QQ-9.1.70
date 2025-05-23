package com.tencent.zplan.meme;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.zplan.common.utils.FileCache;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.meme.model.MemeFrame;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.meme.recorder.MemeRecordQueue;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yx4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004>D^_B\t\b\u0002\u00a2\u0006\u0004\b\\\u0010]J!\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J7\u0010\u0011\u001a\u00020\u0010\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u0013H\u0002J7\u0010\u0019\u001a\u00020\u0010\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u001b\u001a\u00020\u0010\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u0010\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 J \u0010$\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010\t\u001a\u00020\bJ\u001e\u0010'\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"J\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\"J\u000e\u0010*\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"J\u000e\u0010+\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"J\u0010\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010(\u001a\u00020\"J\u0010\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010(\u001a\u00020\"J\u0018\u00102\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\"2\u0006\u00101\u001a\u00020\"J\u0016\u00104\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0006\u0010\t\u001a\u000203J\u000e\u00105\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"J\u0014\u00107\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001006J\u001c\u0010:\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u0010062\u0006\u00109\u001a\u000208J\u0006\u0010;\u001a\u00020\u0010J\u0006\u0010<\u001a\u000208R\u001b\u0010B\u001a\u00020=8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010?\u001a\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR \u0010T\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010?\u001a\u0004\bY\u0010Z\u00a8\u0006`"}, d2 = {"Lcom/tencent/zplan/meme/Meme;", "", "Lcom/tencent/zplan/meme/action/MemeAction;", "T", "action", "Lcom/tencent/zplan/meme/recorder/MemeRecordQueue;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/zplan/meme/action/MemeAction;)Lcom/tencent/zplan/meme/recorder/MemeRecordQueue;", "Lcom/tencent/zplan/meme/Meme$Type;", "type", "r", "Lcom/tencent/zplan/meme/Meme$a;", "Lcom/tencent/zplan/meme/a;", "listener", "Lcom/tencent/zplan/meme/Priority;", "priority", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/Meme$a;Lcom/tencent/zplan/meme/Priority;)V", "Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "E", "", "highPriority", HippyTKDListViewAdapter.X, "(Lcom/tencent/zplan/meme/action/MemeAction;ZLcom/tencent/zplan/meme/a;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/meme/a;)V", "g", "(Lcom/tencent/zplan/meme/action/MemeAction;)V", UserInfo.SEX_FEMALE, "(Lcom/tencent/zplan/meme/action/MemeAction;Lcom/tencent/zplan/meme/Priority;)V", "pause", "", "refer", "G", "uin", "appearanceKey", "w", "recordKey", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/zplan/meme/model/MemeResult$b;", "t", "Ljava/io/File;", "o", "path", "key", "D", "Lcom/tencent/zplan/meme/action/MODE;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function0;", "B", "", "delay", BdhLogUtil.LogTag.Tag_Conn, h.F, "i", "Lyx4/c;", "a", "Lkotlin/Lazy;", "p", "()Lyx4/c;", "memeProxy", "Lyx4/c$c;", "b", "k", "()Lyx4/c$c;", SkinConstants.TintConstant.KEY_COMMON_CONFIG, "Landroid/os/Handler;", "c", "j", "()Landroid/os/Handler;", "asyncHandler", "Ljava/util/concurrent/locks/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "companionLock", "", "e", "Ljava/util/Map;", "recordQueue", "f", "J", "DISK_CACHE_MAX_SIZE", "Lcom/tencent/zplan/common/utils/FileCache;", DomainData.DOMAIN_NAME, "()Lcom/tencent/zplan/common/utils/FileCache;", "fileCache", "<init>", "()V", "TF", "Type", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class Meme {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy memeProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy commonConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy asyncHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock companionLock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Map<Type, MemeRecordQueue> recordQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final long DISK_CACHE_MAX_SIZE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Lazy fileCache;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Meme f385754h;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/meme/Meme$TF;", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Thread;", "newThread", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "id", "", "e", "Ljava/lang/String;", "name", "", "f", "I", "priority", "<init>", "(Ljava/lang/String;I)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class TF implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final AtomicInteger id;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final String name;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int priority;

        public TF(@NotNull String name, int i3) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.priority = i3;
            this.id = new AtomicInteger();
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull final Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            return new BaseThread(new Runnable() { // from class: com.tencent.zplan.meme.Meme$TF$newThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i3;
                    i3 = Meme.TF.this.priority;
                    Process.setThreadPriority(i3);
                    runnable.run();
                }
            }, this.name + '-' + this.id.getAndIncrement());
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/zplan/meme/Meme$Type;", "", "(Ljava/lang/String;I)V", "CMShow", "ZPlan", "Filament", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public enum Type {
        CMShow,
        ZPlan,
        Filament
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0012\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/zplan/meme/Meme$a;", "Lcom/tencent/zplan/meme/a;", "T", "Lcom/tencent/zplan/meme/b;", "Lcom/tencent/zplan/meme/model/c;", AIInput.KEY_FRAME, "", "Z1", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "cover", "ad", "result", "l9", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "currProgress", "d3", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "callbackRef", "", "e", "J", "timeStart", "listener", "<init>", "(Lcom/tencent/zplan/meme/a;J)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class a<T extends com.tencent.zplan.meme.a> implements com.tencent.zplan.meme.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<T> callbackRef;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long timeStart;

        public a(@Nullable T t16, long j3) {
            this.timeStart = j3;
            this.callbackRef = new WeakReference<>(t16);
        }

        @Override // com.tencent.zplan.meme.b
        public void Z1(@NotNull MemeFrame frame) {
            Intrinsics.checkNotNullParameter(frame, "frame");
            T t16 = this.callbackRef.get();
            if (t16 != null && (t16 instanceof com.tencent.zplan.meme.b)) {
                ((com.tencent.zplan.meme.b) t16).Z1(frame);
            }
        }

        @Override // com.tencent.zplan.meme.b
        public void ad(boolean success, @NotNull MemeResult cover) {
            Intrinsics.checkNotNullParameter(cover, "cover");
            T t16 = this.callbackRef.get();
            if (t16 != null && (t16 instanceof com.tencent.zplan.meme.b)) {
                ((com.tencent.zplan.meme.b) t16).ad(success, cover);
            }
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(@NotNull MemeAction action, float currProgress) {
            Intrinsics.checkNotNullParameter(action, "action");
            T t16 = this.callbackRef.get();
            if (t16 != null) {
                t16.d3(action, currProgress);
                return;
            }
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "[zplan][MemePlayer-SDK]", 1, "updateProgress error, caller is null or has been garbage collected. " + action.getDesc(), null, 8, null);
            }
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean success, @NotNull MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            long i3 = Meme.f385754h.i();
            wx4.d i16 = result.i();
            if (i16 != null) {
                i16.v(this.timeStart);
            }
            if (i16 != null) {
                i16.u(i3);
            }
            MemeAction action = result.getAction();
            String recordPath = result.getRecordPath();
            long i17 = com.tencent.zplan.common.utils.c.f385288a.i(recordPath);
            T t16 = this.callbackRef.get();
            String str = action.getDesc() + ", success:" + success + ", status:" + action.getActionStatus() + ", recordPath:" + recordPath + ", fileSize:" + i17 + ", statistic:" + i16;
            if (t16 != null) {
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.b(a16, "[zplan][MemePlayer-SDK]", 1, "recordAction result, " + str + ", caller:" + t16, null, 8, null);
                }
                t16.l9(success, result);
                return;
            }
            lx4.d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.b(a17, "[zplan][MemePlayer-SDK]", 1, "recordAction result, caller is null or has been garbage collected. " + str, null, 8, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/meme/Meme$b;", "Lcom/tencent/zplan/meme/a;", "T", "Lcom/tencent/zplan/meme/Meme$a;", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "", "l9", "listener", "", "timeStart", "<init>", "(Lcom/tencent/zplan/meme/a;J)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b<T extends com.tencent.zplan.meme.a> extends a<T> {
        public b(@Nullable T t16, long j3) {
            super(t16, j3);
        }

        @Override // com.tencent.zplan.meme.Meme.a, com.tencent.zplan.meme.a
        public void l9(boolean success, @NotNull MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            result.n(new MemeResult.Sub(result.getAction().getActionId(), result.getRecordKey()));
            super.l9(success, result);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Meme meme = new Meme();
        f385754h = meme;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<yx4.c>() { // from class: com.tencent.zplan.meme.Meme$memeProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final yx4.c invoke() {
                Object a16 = mx4.a.f417748a.a(yx4.c.class);
                Intrinsics.checkNotNull(a16);
                return (yx4.c) a16;
            }
        });
        memeProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c.Config>() { // from class: com.tencent.zplan.meme.Meme$commonConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c.Config invoke() {
                return Meme.f385754h.p().getConfig();
            }
        });
        commonConfig = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.zplan.meme.Meme$asyncHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Meme_SDK_AsyncHandler");
                baseHandlerThread.start();
                return new Handler(baseHandlerThread.getLooper());
            }
        });
        asyncHandler = lazy3;
        companionLock = new ReentrantLock();
        recordQueue = new LinkedHashMap();
        DISK_CACHE_MAX_SIZE = meme.k().getCacheSize();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<FileCache>() { // from class: com.tencent.zplan.meme.Meme$fileCache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FileCache invoke() {
                long j3;
                String a16 = Constant.f385743c.a();
                Meme meme2 = Meme.f385754h;
                j3 = Meme.DISK_CACHE_MAX_SIZE;
                return new FileCache(a16, j3);
            }
        });
        fileCache = lazy4;
    }

    Meme() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MemeZPlanAction> E(MemeZPlanBatchAction memeZPlanBatchAction) {
        int collectionSizeOrDefault;
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK]", 1, "separate " + memeZPlanBatchAction.getDesc() + " to single", null, 8, null);
        }
        List<Integer> portraitIds$record_debug = memeZPlanBatchAction.getPortraitIds$record_debug();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(portraitIds$record_debug, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = portraitIds$record_debug.iterator();
        while (it.hasNext()) {
            MemeZPlanAction memeZPlanAction = new MemeZPlanAction(((Number) it.next()).intValue(), memeZPlanBatchAction.getMode().toFrameCount(), memeZPlanBatchAction.getWidth(), memeZPlanBatchAction.getHeight(), memeZPlanBatchAction.getMode(), memeZPlanBatchAction.getUin(), null, memeZPlanBatchAction.getName(), memeZPlanBatchAction.getTheme(), null, null, memeZPlanBatchAction.getSenderAvatarCharacterInfo(), memeZPlanBatchAction.getReceiverAvatarCharacterInfo(), null, 9728, null);
            memeZPlanAction.setConfig(memeZPlanBatchAction.getConfig());
            arrayList.add(memeZPlanAction);
        }
        return arrayList;
    }

    public static /* synthetic */ void H(Meme meme, boolean z16, String str, Type type, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            type = Type.ZPlan;
        }
        meme.G(z16, str, type);
    }

    private final Handler j() {
        return (Handler) asyncHandler.getValue();
    }

    private final FileCache n() {
        return (FileCache) fileCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MemeRecordQueue r(Type type) {
        ReentrantLock reentrantLock = companionLock;
        reentrantLock.lock();
        try {
            return recordQueue.get(type);
        } finally {
            reentrantLock.unlock();
        }
    }

    private final <T extends MemeAction> MemeRecordQueue s(T action) {
        Type type = action.getType();
        ReentrantLock reentrantLock = companionLock;
        reentrantLock.lock();
        try {
            Map<Type, MemeRecordQueue> map = recordQueue;
            MemeRecordQueue memeRecordQueue = map.get(type);
            if (memeRecordQueue == null) {
                memeRecordQueue = new MemeRecordQueue(type);
                map.put(type, memeRecordQueue);
            }
            return memeRecordQueue;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void y(Meme meme, MemeAction memeAction, boolean z16, com.tencent.zplan.meme.a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        meme.x(memeAction, z16, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends MemeAction> void z(T action, a<com.tencent.zplan.meme.a> listener, Priority priority) {
        action.getKey();
        s(action).G(action, priority, listener);
    }

    public final <T extends MemeAction> void A(@NotNull final T action, @NotNull final Priority priority, @Nullable final com.tencent.zplan.meme.a listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.Meme$recordActionWithPriority$1
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
                List<MemeZPlanAction> E;
                if (MemeAction.this.isBatch()) {
                    MemeAction memeAction = MemeAction.this;
                    if ((memeAction instanceof MemeZPlanBatchAction) && ((MemeZPlanBatchAction) memeAction).getSeparateSingle()) {
                        E = Meme.f385754h.E((MemeZPlanBatchAction) MemeAction.this);
                        for (MemeZPlanAction memeZPlanAction : E) {
                            Meme meme = Meme.f385754h;
                            meme.z(memeZPlanAction, new Meme.b(listener, meme.i()), priority);
                        }
                        return;
                    }
                }
                Meme meme2 = Meme.f385754h;
                meme2.z(MemeAction.this, new Meme.a(listener, meme2.i()), priority);
            }
        });
    }

    public final void B(@NotNull final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        j().post(new Runnable() { // from class: com.tencent.zplan.meme.Meme$runOnAsyncHandler$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        });
    }

    public final void C(@NotNull final Function0<Unit> action, long delay) {
        Intrinsics.checkNotNullParameter(action, "action");
        j().postDelayed(new Runnable() { // from class: com.tencent.zplan.meme.Meme$runOnAsyncHandlerDelay$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        }, delay);
    }

    public final boolean D(@Nullable String path, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return n().g(path, key);
    }

    public final <T extends MemeAction> void F(@NotNull final T action, @NotNull final Priority priority) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(priority, "priority");
        B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.Meme$setPriority$1
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
                MemeRecordQueue r16;
                r16 = Meme.f385754h.r(MemeAction.this.getType());
                if (r16 != null) {
                    r16.O(MemeAction.this, priority);
                }
            }
        });
    }

    public final void G(final boolean pause, @NotNull String refer, @NotNull final Type type) {
        Intrinsics.checkNotNullParameter(refer, "refer");
        Intrinsics.checkNotNullParameter(type, "type");
        boolean enableRecordQueuePause = k().getEnableRecordQueuePause();
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK]", 1, "toggleQueuePauseState pause:" + pause + ", refer:" + refer + ", type:" + type + ", enable:" + enableRecordQueuePause, null, 8, null);
        }
        if (!enableRecordQueuePause) {
            return;
        }
        B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.Meme$toggleQueuePauseState$1
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
                MemeRecordQueue r16;
                r16 = Meme.f385754h.r(type);
                if (r16 != null) {
                    r16.N(pause);
                }
            }
        });
    }

    public final <T extends MemeAction> void g(@NotNull final T action) {
        Intrinsics.checkNotNullParameter(action, "action");
        B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.Meme$cancelAction$1
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
                MemeRecordQueue r16;
                r16 = Meme.f385754h.r(MemeAction.this.getType());
                if (r16 != null) {
                    r16.s(MemeAction.this);
                }
            }
        });
    }

    public final void h() {
        B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.Meme$clear$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReentrantLock reentrantLock;
                Map map;
                lx4.d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.d(a16, "[zplan][MemePlayer-SDK]", 1, "clear!!", null, 8, null);
                }
                Meme meme = Meme.f385754h;
                reentrantLock = Meme.companionLock;
                reentrantLock.lock();
                try {
                    map = Meme.recordQueue;
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        ((MemeRecordQueue) ((Map.Entry) it.next()).getValue()).w();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
    }

    public final long i() {
        return System.currentTimeMillis();
    }

    @NotNull
    public final c.Config k() {
        return (c.Config) commonConfig.getValue();
    }

    @NotNull
    public final String l(@NotNull String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        return Constant.f385743c.a() + '/' + m(recordKey);
    }

    @NotNull
    public final String m(@NotNull String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        return "cover_" + recordKey;
    }

    @Nullable
    public final File o(@NotNull String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        return n().c(recordKey);
    }

    @NotNull
    public final yx4.c p() {
        return (yx4.c) memeProxy.getValue();
    }

    @NotNull
    public final String q(@NotNull String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        return Constant.f385743c.a() + '/' + recordKey;
    }

    @Nullable
    public final MemeResult.Cover t(@NotNull String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        File c16 = n().c(m(recordKey));
        if (c16 != null && c16.exists()) {
            return new MemeResult.Cover(c16.getAbsolutePath(), m(recordKey));
        }
        return null;
    }

    @Nullable
    public final List<String> u(@NotNull MemeAction action, @NotNull String recordKey) {
        File[] listFiles;
        boolean z16;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        File file = new File(v(recordKey, action.getMode()));
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ArrayList arrayList = new ArrayList();
                for (File f16 : listFiles) {
                    Intrinsics.checkNotNullExpressionValue(f16, "f");
                    if (f16.isFile()) {
                        String absolutePath = f16.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "f.absolutePath");
                        arrayList.add(absolutePath);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    @NotNull
    public final String v(@NotNull String recordKey, @NotNull MODE type) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = e.f385769a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            return Constant.f385743c.a() + "/mp4Temp/" + recordKey;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return Constant.f385743c.a() + "/shpTemp/" + recordKey;
                }
                return Constant.f385743c.a() + "/frameTemp/" + recordKey;
            }
            return Constant.f385743c.a() + "/gifTemp/" + recordKey;
        }
        return Constant.f385743c.a() + "/apngTemp/" + recordKey;
    }

    public final void w(@NotNull final Type type, @NotNull final String uin, @NotNull final String appearanceKey) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.Meme$notifyAppearanceKeyChange$1
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
                MemeRecordQueue r16;
                r16 = Meme.f385754h.r(Meme.Type.this);
                if (r16 != null) {
                    r16.F(uin, appearanceKey);
                }
            }
        });
    }

    @Deprecated(message = "\u5f03\u7528", replaceWith = @ReplaceWith(expression = "recordActionWithPriority(action: T, priority: Priority, listener: IMemeBaseListener?)", imports = {}))
    public final <T extends MemeAction> void x(@NotNull T action, boolean highPriority, @Nullable com.tencent.zplan.meme.a listener) {
        Priority priority;
        Intrinsics.checkNotNullParameter(action, "action");
        if (highPriority) {
            priority = Priority.MIDDLE;
        } else {
            priority = Priority.LOW;
        }
        A(action, priority, listener);
    }
}
