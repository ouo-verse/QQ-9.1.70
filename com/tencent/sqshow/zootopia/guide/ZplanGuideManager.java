package com.tencent.sqshow.zootopia.guide;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.guide.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qv4.bo;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 72\u00020\u0001:\u0001\u0019B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u001bH\u0016J(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\nH\u0016R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00104\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/ZplanGuideManager;", "Lcom/tencent/sqshow/zootopia/guide/i;", "", "sourceId", "", "Lpv4/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "groupId", "l", "data", "", "o", "Landroidx/lifecycle/Lifecycle;", "lifeCycle", "Lcom/tencent/sqshow/zootopia/guide/i$b;", "listener", "", "p", "lifecycle", "Lcom/tencent/sqshow/zootopia/guide/h;", "guideTask", DomainData.DOMAIN_NAME, tl.h.F, "step", "b", "a", "i", "", "j", "skipAll", "c", "", "Ljava/util/Map;", "showRunnableList", "Lyb4/h;", "Lkotlin/Lazy;", "k", "()Lyb4/h;", "guideRepository", "", "Ljava/util/List;", "finishedTaskGroupId", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "needSkipRequestMap", "e", "Z", "getSkiAllGuideTask", "()Z", "setSkiAllGuideTask", "(Z)V", "skiAllGuideTask", "<init>", "()V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanGuideManager implements i {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Lazy<ZplanGuideManager> f370672g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, h> showRunnableList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy guideRepository;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<Integer> finishedTaskGroupId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<Integer, Boolean> needSkipRequestMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean skiAllGuideTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/ZplanGuideManager$a;", "", "Lcom/tencent/sqshow/zootopia/guide/ZplanGuideManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/sqshow/zootopia/guide/ZplanGuideManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.guide.ZplanGuideManager$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZplanGuideManager a() {
            return (ZplanGuideManager) ZplanGuideManager.f370672g.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/guide/ZplanGuideManager$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f370678d;

        b(int i3) {
            this.f370678d = i3;
        }

        public void a(boolean result) {
            QLog.d("ZplanGuideManager", 1, "report success " + this.f370678d);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZplanGuideManager", 1, "report close guide task failed " + error + " " + message + " " + this.f370678d);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/guide/ZplanGuideManager$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "Lpv4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<List<? extends pv4.f>> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f370680e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i.b f370681f;

        c(int i3, i.b bVar) {
            this.f370680e = i3;
            this.f370681f = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(List<pv4.f> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            boolean o16 = ZplanGuideManager.this.o(result);
            ZplanGuideManager.this.needSkipRequestMap.put(Integer.valueOf(this.f370680e), Boolean.valueOf(o16));
            QLog.d("ZplanGuideManager", 1, "get guide status success " + this.f370680e + " " + o16 + " " + result);
            this.f370681f.a(o16, result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZplanGuideManager", 1, "get Guide failed " + this.f370680e + " " + error + " " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/guide/ZplanGuideManager$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bo;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<bo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f370682d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f370683e;

        d(int i3, int i16) {
            this.f370682d = i3;
            this.f370683e = i16;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bo result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZplanGuideManager", 1, "report success " + result + " " + this.f370682d);
            SimpleEventBus.getInstance().dispatchEvent(new ZplanGuideTriggerEvent(this.f370683e));
            if (TextUtils.isEmpty(result.f430092b)) {
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), result.f430092b, 0).show();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZplanGuideManager", 1, "report skip guide task failed " + this.f370682d + " " + error + " " + message);
        }
    }

    static {
        Lazy<ZplanGuideManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ZplanGuideManager>() { // from class: com.tencent.sqshow.zootopia.guide.ZplanGuideManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanGuideManager invoke() {
                return new ZplanGuideManager(null);
            }
        });
        f370672g = lazy;
    }

    public /* synthetic */ ZplanGuideManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final yb4.h k() {
        return (yb4.h) this.guideRepository.getValue();
    }

    private final pv4.f l(int groupId) {
        pv4.f fVar = new pv4.f();
        fVar.f427598b = groupId;
        fVar.f427599c = 0;
        return fVar;
    }

    private final List<pv4.f> m(int sourceId) {
        ArrayList arrayList = new ArrayList();
        if (sourceId == 6) {
            pv4.f l3 = l(1);
            pv4.g gVar = new pv4.g();
            l3.f427601e = gVar;
            pu4.g gVar2 = new pu4.g();
            gVar2.f427435b = "png";
            gVar2.f427434a = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/tmp/test_guide_1.png";
            Unit unit = Unit.INSTANCE;
            pu4.g gVar3 = new pu4.g();
            gVar3.f427435b = "png";
            gVar3.f427434a = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/tmp/test_guide_2.png";
            gVar.f427602a = new pu4.g[]{gVar2, gVar3};
            arrayList.add(l3);
            arrayList.add(l(8));
            arrayList.add(l(11));
            arrayList.add(l(13));
        } else if (sourceId == 7) {
            arrayList.add(l(10));
        } else if (sourceId == 8) {
            arrayList.add(l(9));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(List<pv4.f> data) {
        if (data.isEmpty()) {
            return false;
        }
        for (pv4.f fVar : data) {
            if (fVar.f427599c == 0 && !this.finishedTaskGroupId.contains(Integer.valueOf(fVar.f427598b))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.guide.i
    public boolean a(int sourceId, int groupId, int step) {
        if (this.showRunnableList.containsKey(Integer.valueOf(groupId))) {
            h hVar = this.showRunnableList.get(Integer.valueOf(groupId));
            if (hVar != null) {
                hVar.dismiss();
            }
            this.showRunnableList.remove(Integer.valueOf(groupId));
            QLog.d("ZplanGuideManager", 1, "finish guide Task " + groupId);
            k().c(sourceId, groupId, step, new b(groupId));
            return true;
        }
        QLog.d("ZplanGuideManager", 1, "not show guide task");
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.guide.i
    public void b(int sourceId, int groupId, int step) {
        if (a(sourceId, groupId, step)) {
            if (!this.finishedTaskGroupId.contains(Integer.valueOf(groupId))) {
                this.finishedTaskGroupId.add(Integer.valueOf(groupId));
            }
            QLog.d("ZplanGuideManager", 1, "finish guide Task " + groupId);
        }
    }

    public boolean h(int groupId) {
        if (this.skiAllGuideTask) {
            QLog.d("ZplanGuideManager", 1, "skip task as the task had finished");
            return false;
        }
        if (this.showRunnableList.containsKey(Integer.valueOf(groupId))) {
            if (groupId != 1 && groupId != 8 && groupId != 11) {
                QLog.d("ZplanGuideManager", 1, "add guide task before , " + groupId);
            } else {
                QLog.d("ZplanGuideManager", 1, "add guide task before and skip show guide, " + groupId);
                return false;
            }
        }
        if (this.finishedTaskGroupId.contains(Integer.valueOf(groupId))) {
            QLog.d("ZplanGuideManager", 1, "skip task as the task had finished " + groupId);
            return false;
        }
        QLog.d("ZplanGuideManager", 1, "can show guide view: " + groupId);
        return true;
    }

    public void i(int groupId) {
        if (this.showRunnableList.containsKey(Integer.valueOf(groupId))) {
            h hVar = this.showRunnableList.get(Integer.valueOf(groupId));
            if (hVar != null) {
                hVar.dismiss();
            }
            this.showRunnableList.remove(Integer.valueOf(groupId));
            QLog.d("ZplanGuideManager", 1, "finish guide Task " + groupId);
            return;
        }
        QLog.d("ZplanGuideManager", 1, "not need close guide temp " + groupId);
    }

    public Map<Integer, h> j() {
        return this.showRunnableList;
    }

    public void n(final Lifecycle lifecycle, h guideTask) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(guideTask, "guideTask");
        final int id5 = guideTask.getId();
        if (h(guideTask.getId()) && !this.showRunnableList.containsKey(1)) {
            if (this.showRunnableList.containsKey(10) && guideTask.getId() == 8) {
                QLog.d("ZplanGuideManager", 1, "skip show guide detial guide showing");
                return;
            }
            if (guideTask.show()) {
                this.showRunnableList.put(Integer.valueOf(guideTask.getId()), guideTask);
            }
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.tencent.sqshow.zootopia.guide.ZplanGuideManager$handleShowGuide$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                    Map map;
                    Map map2;
                    Map map3;
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    QLog.d("ZplanGuideManager", 1, "state changed in Manager showGuide " + event);
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        map = ZplanGuideManager.this.showRunnableList;
                        if (map.containsKey(Integer.valueOf(id5))) {
                            map2 = ZplanGuideManager.this.showRunnableList;
                            h hVar = (h) map2.get(Integer.valueOf(id5));
                            if (hVar != null) {
                                hVar.dismiss();
                            }
                            map3 = ZplanGuideManager.this.showRunnableList;
                            map3.remove(Integer.valueOf(id5));
                        }
                        lifecycle.removeObserver(this);
                    }
                }
            });
        }
    }

    public void p(final Lifecycle lifeCycle, int sourceId, final i.b listener) {
        List<pv4.f> emptyList;
        Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.needSkipRequestMap.contains(Integer.valueOf(sourceId)) && Intrinsics.areEqual(this.needSkipRequestMap.get(Integer.valueOf(sourceId)), Boolean.FALSE)) {
            QLog.d("ZplanGuideManager", 1, "skip request" + sourceId + " ");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            listener.a(false, emptyList);
            return;
        }
        if (com.tencent.mobileqq.zootopia.g.f328305a.d()) {
            listener.a(true, m(sourceId));
        } else {
            k().b(sourceId, new c(sourceId, listener), null);
            lifeCycle.addObserver(new LifecycleEventObserver() { // from class: com.tencent.sqshow.zootopia.guide.ZplanGuideManager$requestGuideStatus$2
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                    List<pv4.f> emptyList2;
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    QLog.d("ZplanGuideManager", 1, "state changed in Manager request " + event);
                    if (event == Lifecycle.Event.ON_STOP) {
                        i.b bVar = i.b.this;
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                        bVar.a(false, emptyList2);
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifeCycle.removeObserver(this);
                    }
                }
            });
        }
    }

    ZplanGuideManager() {
        Lazy lazy;
        this.showRunnableList = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<yb4.h>() { // from class: com.tencent.sqshow.zootopia.guide.ZplanGuideManager$guideRepository$2
            @Override // kotlin.jvm.functions.Function0
            public final yb4.h invoke() {
                return new yb4.h();
            }
        });
        this.guideRepository = lazy;
        this.finishedTaskGroupId = new ArrayList();
        this.needSkipRequestMap = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.sqshow.zootopia.guide.i
    public void c(int sourceId, int groupId, int step, boolean skipAll) {
        if (skipAll) {
            this.skiAllGuideTask = true;
        }
        b(sourceId, groupId, step);
        k().d(new int[]{groupId}, skipAll, new d(groupId, sourceId));
    }
}
