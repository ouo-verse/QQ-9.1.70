package gh1;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.ak;
import com.tencent.mobileqq.qqguildsdk.data.genc.al;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00078\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0011028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00106\u00a8\u0006:"}, d2 = {"Lgh1/b;", "", "", "l", "", "Lgh1/c;", "currentList", "", "reportOnce", "d", "", "nextExposeInterval", h.F, "exposeModel", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "a", "Ljava/lang/String;", "getStage", "()Ljava/lang/String;", "stage", "b", "f", "logTag", "", "c", "I", "g", "()I", "setRunningUpdateCount", "(I)V", "isRunningUpdateCount", "J", "getLastReportTime", "()J", "setLastReportTime", "(J)V", "lastReportTime", "value", "e", "Z", "isRunning", "()Z", "j", "(Z)V", "", "Ljava/util/List;", "exposeModelList", "", "Ljava/util/Set;", "exposedItemIDSet", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "exposeRunnable", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String stage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int isRunningUpdateCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastReportTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ExposeModel> exposeModelList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> exposedItemIDSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable exposeRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"gh1/b$b", "Lwh2/em;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gh1.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C10377b implements em {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f402054a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f402055b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f402056c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<ExposeModel> f402057d;

        C10377b(boolean z16, int i3, b bVar, List<ExposeModel> list) {
            this.f402054a = z16;
            this.f402055b = i3;
            this.f402056c = bVar;
            this.f402057d = list;
        }

        @Override // wh2.em
        public void onResult(int result, @Nullable String errMsg) {
            if (!this.f402054a && this.f402055b == this.f402056c.getIsRunningUpdateCount()) {
                if (result != 0) {
                    Logger logger = Logger.f235387a;
                    String logTag = this.f402056c.getLogTag();
                    Logger.b bVar = new Logger.b();
                    String str = "exposeRecommends result: " + result + ", errMsg:" + errMsg;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e(logTag, 1, (String) it.next(), null);
                    }
                    this.f402056c.h(30000L);
                    return;
                }
                Logger logger2 = Logger.f235387a;
                String logTag2 = this.f402056c.getLogTag();
                List<ExposeModel> list = this.f402057d;
                if (QLog.isColorLevel()) {
                    logger2.d().d(logTag2, 2, "exposeRecommends success list:" + list);
                }
                this.f402056c.exposeModelList.removeAll(this.f402057d);
                this.f402056c.h(5000L);
                return;
            }
            if (result != 0) {
                Logger logger3 = Logger.f235387a;
                String logTag3 = this.f402056c.getLogTag();
                Logger.b bVar2 = new Logger.b();
                String str2 = "exposeRecommends reportOnce error result: " + result + ", errMsg:" + errMsg;
                if (str2 instanceof String) {
                    bVar2.a().add(str2);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e(logTag3, 1, (String) it5.next(), null);
                }
                return;
            }
            Logger logger4 = Logger.f235387a;
            String logTag4 = this.f402056c.getLogTag();
            if (QLog.isColorLevel()) {
                logger4.d().d(logTag4, 2, "exposeRecommends reportOnce success");
            }
            this.f402056c.exposeModelList.removeAll(this.f402057d);
        }
    }

    public b(@NotNull String stage) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        this.stage = stage;
        this.logTag = "Guild.discovery.mine.ExposeHelper" + stage;
        this.exposeModelList = new ArrayList();
        this.exposedItemIDSet = new LinkedHashSet();
        this.exposeRunnable = new Runnable() { // from class: gh1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(b.this);
            }
        };
    }

    private final void d(List<ExposeModel> currentList, boolean reportOnce) {
        if (currentList.isEmpty()) {
            Logger logger = Logger.f235387a;
            String str = this.logTag;
            if (QLog.isColorLevel()) {
                logger.d().d(str, 2, "[exposeInternal] currentList is empty ");
                return;
            }
            return;
        }
        this.lastReportTime = System.currentTimeMillis();
        int i3 = this.isRunningUpdateCount;
        al alVar = new al();
        ArrayList<ak> arrayList = new ArrayList<>();
        Logger logger2 = Logger.f235387a;
        String str2 = this.logTag;
        if (QLog.isColorLevel()) {
            logger2.d().d(str2, 2, "[exposeInternal] size:" + currentList.size());
        }
        Iterator<T> it = currentList.iterator();
        while (it.hasNext()) {
            arrayList.add(((ExposeModel) it.next()).b());
        }
        alVar.e(arrayList);
        alVar.f(this.stage);
        ((IGPSService) ch.R0(IGPSService.class)).exposeRecommends(alVar, new C10377b(reportOnce, i3, this, currentList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b this$0) {
        int coerceAtMost;
        List<ExposeModel> take;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<ExposeModel> list = this$0.exposeModelList;
        List<ExposeModel> list2 = list;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(list.size(), 50);
        take = CollectionsKt___CollectionsKt.take(list2, coerceAtMost);
        this$0.d(take, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(long nextExposeInterval) {
        Logger logger = Logger.f235387a;
        String str = this.logTag;
        logger.d().d(str, 1, "postDelay nextExposeInterval:" + nextExposeInterval);
        UiThreadUtil.runOnUiThread(this.exposeRunnable, nextExposeInterval);
    }

    private final void l() {
        Logger logger = Logger.f235387a;
        String str = this.logTag;
        if (QLog.isColorLevel()) {
            logger.d().d(str, 2, "stopExpose");
        }
        if (this.isRunning) {
            String str2 = this.logTag;
            if (QLog.isColorLevel()) {
                logger.d().d(str2, 2, "real stopExpose");
            }
            j(false);
            UiThreadUtil.remove(this.exposeRunnable);
        }
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getLogTag() {
        return this.logTag;
    }

    /* renamed from: g, reason: from getter */
    public final int getIsRunningUpdateCount() {
        return this.isRunningUpdateCount;
    }

    public final void i(@NotNull ExposeModel exposeModel) {
        int coerceAtMost;
        List<ExposeModel> take;
        Intrinsics.checkNotNullParameter(exposeModel, "exposeModel");
        Logger logger = Logger.f235387a;
        String str = this.logTag;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "putExposeModelList model:" + exposeModel);
        }
        if (!this.exposedItemIDSet.contains(exposeModel.getId())) {
            this.exposeModelList.add(exposeModel);
            this.exposedItemIDSet.add(exposeModel.getId());
            long currentTimeMillis = System.currentTimeMillis() - this.lastReportTime;
            Logger logger2 = Logger.f235387a;
            String str2 = this.logTag;
            if (QLog.isColorLevel()) {
                logger2.d().d(str2, 2, "ensure putExposeModelList lastReportTime=" + currentTimeMillis + " ms ago. model:" + exposeModel);
            }
            if (currentTimeMillis >= 5000) {
                UiThreadUtil.remove(this.exposeRunnable);
                List<ExposeModel> list = this.exposeModelList;
                List<ExposeModel> list2 = list;
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(list.size(), 50);
                take = CollectionsKt___CollectionsKt.take(list2, coerceAtMost);
                d(take, false);
            }
        }
    }

    public final void j(boolean z16) {
        this.isRunning = z16;
        this.isRunningUpdateCount++;
    }

    public final void k() {
        if (!this.isRunning) {
            this.lastReportTime = System.currentTimeMillis();
            Logger logger = Logger.f235387a;
            String str = this.logTag;
            if (QLog.isColorLevel()) {
                logger.d().d(str, 2, "startTask");
            }
            j(true);
            h(5000L);
        }
    }

    public final void m() {
        int coerceAtMost;
        List<ExposeModel> take;
        l();
        List<ExposeModel> list = this.exposeModelList;
        List<ExposeModel> list2 = list;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(list.size(), 50);
        take = CollectionsKt___CollectionsKt.take(list2, coerceAtMost);
        d(take, true);
    }
}
