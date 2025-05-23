package com.tencent.sqshow.zootopia.avatar.loading.recorder;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.zplan.meme.a;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010(J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0014\u001a\u00020\u0002H&J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\tR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u001fj\b\u0012\u0004\u0012\u00020\u0015` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010!R0\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0#j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/BaseLoadingAvatarRecorder;", "Lcom/tencent/zplan/meme/a;", "", "from", "", "reqFrom", "", "Lcom/tencent/zplan/record/model/Source;", "sources", "", "f", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "params", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "res", "", "startTime", h.F, "k", "i", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/d;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "d", "e", "I", "getMType", "()I", HttpMsg.MTYPE, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mListenerPool", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mResourcePool", "<init>", "(I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseLoadingAvatarRecorder implements com.tencent.zplan.meme.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final HashSet<d> mListenerPool = new HashSet<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, ZPlanRecordResource> mResourcePool = new HashMap<>();

    public BaseLoadingAvatarRecorder(@AvatarRecordType int i3) {
        this.mType = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(SingleRecordRequestParams params, ZPlanRecordResource res, long startTime) {
        long currentTimeMillis = System.currentTimeMillis() - startTime;
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_loading_lvtm", Long.valueOf(currentTimeMillis));
        hashMap.put("zplan_record_param", params.toString());
        if (res == null) {
            VideoReport.reportEvent("ev_zplan_cloud_recording_fail", hashMap);
        } else if (!res.o() && !res.p()) {
            VideoReport.reportEvent("ev_zplan_cloud_recording_fail", hashMap);
        } else {
            VideoReport.reportEvent("ev_zplan_cloud_recording_success", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(ZPlanRecordResource res) {
        Iterator<T> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this.mType, res);
        }
    }

    public final void d(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        g(this, from, 0, null, 6, null);
    }

    @Override // com.tencent.zplan.meme.a
    public void d3(MemeAction memeAction, float f16) {
        a.C10066a.a(this, memeAction, f16);
    }

    public final void e(String from) {
        List listOf;
        Intrinsics.checkNotNullParameter(from, "from");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.CLOUD_CACHE});
        g(this, from, 0, listOf, 2, null);
    }

    public abstract SingleRecordRequestParams i(int reqFrom);

    public final void l() {
        if (!c84.e.f30458a.b()) {
            QLog.w(n(), 1, "preloadCache give up. can't show record avatar!");
            return;
        }
        if (FilamentApiImpl.f369933a.d()) {
            QLog.w(n(), 1, "preloadCache give up. isFilamentEngine");
            return;
        }
        SingleRecordRequestParams j3 = j(this, 0, 1, null);
        QLog.i(n(), 1, "preloadCache params:" + j3);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseLoadingAvatarRecorder$preloadCache$1(j3, this, null), 3, null);
    }

    @Override // com.tencent.zplan.meme.a
    public void l9(boolean z16, MemeResult memeResult) {
        a.C10066a.b(this, z16, memeResult);
    }

    public final void m(d l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.add(l3);
    }

    public abstract String n();

    public final void o(d l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.remove(l3);
    }

    private final void f(String from, int reqFrom, List<? extends Source> sources) {
        if (!c84.e.f30458a.b()) {
            QLog.w(n(), 1, "doRecord , from:" + from + ", give up. can't show record avatar!");
            return;
        }
        if (FilamentApiImpl.f369933a.d()) {
            QLog.w(n(), 1, "doRecord , from:" + from + ", give up. isFilamentEngine");
            return;
        }
        boolean contains = sources.contains(Source.LOCAL_RECORD);
        String b16 = w.f373306a.b();
        SingleRecordRequestParams i3 = i(reqFrom);
        QLog.i(n(), 1, "doRecord begin, from:" + from + ". params:" + i3 + ", sources:" + sources);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaseLoadingAvatarRecorder$doRecord$1(i3, sources, this, contains, System.currentTimeMillis(), b16, null), 3, null);
    }

    public static /* synthetic */ SingleRecordRequestParams j(BaseLoadingAvatarRecorder baseLoadingAvatarRecorder, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = 0;
            }
            return baseLoadingAvatarRecorder.i(i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecordParam");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void g(BaseLoadingAvatarRecorder baseLoadingAvatarRecorder, String str, int i3, List list, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            if ((i16 & 4) != 0) {
                list = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.CLOUD_CACHE, Source.LOCAL_RECORD});
            }
            baseLoadingAvatarRecorder.f(str, i3, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doRecord");
    }
}
