package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import androidx.core.util.Consumer;
import com.google.gson.Gson;
import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.api.h;
import com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import pm1.b;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\n*\u00012\u0018\u0000 \u00112\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b9\u0010:J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J$\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tj\u0002`\n0\u0007j\u0002`\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tj\u0002`\n0\u0007j\u0002`\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tj\u0002`\n0\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u000f2\u000e\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010,\u001a\u00020'8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010*\"\u0004\b(\u0010+R\u001a\u00101\u001a\u00020-8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b \u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/PostFeedMainTaskFacadeImpl;", "Lin1/d;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "feedJsonObject", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/publish/api/QQAlbumMediumModel;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediaSelected;", "o", DomainData.DOMAIN_NAME, "localMediaList", "", tl.h.F, "f", "Landroidx/core/util/Consumer;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "callback", "j", ark.ARKMETADATA_JSON, "k", "", "isSuccess", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "l", "Lcom/tencent/mobileqq/guild/feed/publish/GuildSingleMainTask;", "a", "Lcom/tencent/mobileqq/guild/feed/publish/GuildSingleMainTask;", "mainTask", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "c", "I", "()I", "(I)V", "stage", "Lin1/c;", "d", "Lin1/c;", "()Lin1/c;", "uploadTaskApi", "com/tencent/mobileqq/guild/feed/publish/publishV2/taskx/PostFeedMainTaskFacadeImpl$taskListener$1", "e", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/PostFeedMainTaskFacadeImpl$taskListener$1;", "taskListener", "i", "()Ljava/lang/String;", "mainTaskId", "<init>", "(Lcom/tencent/mobileqq/guild/feed/publish/GuildSingleMainTask;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PostFeedMainTaskFacadeImpl implements in1.d {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f223114f = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSingleMainTask mainTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int stage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final in1.c uploadTaskApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PostFeedMainTaskFacadeImpl$taskListener$1 taskListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/PostFeedMainTaskFacadeImpl$a;", "", "", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl$taskListener$1, com.tencent.mobileqq.guild.feed.api.h] */
    public PostFeedMainTaskFacadeImpl(@NotNull GuildSingleMainTask mainTask) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(mainTask, "mainTask");
        this.mainTask = mainTask;
        CoroutineDispatcher c16 = ae.a().c();
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.scope = CoroutineScopeKt.CoroutineScope(c16.plus(Job$default));
        this.uploadTaskApi = new FeedMediaUploadTask("PostFeedTask.Facade", new ParentTaskContext(i(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl$uploadTaskApi$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(PostFeedMainTaskFacadeImpl.this.getStage() == 1);
            }
        }), true);
        ?? r56 = new com.tencent.mobileqq.guild.feed.api.h() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.PostFeedMainTaskFacadeImpl$taskListener$1
            @Override // com.tencent.mobileqq.guild.feed.api.h, com.tencent.mobileqq.guild.feed.api.f
            public void a(@NotNull o info) {
                CoroutineScope coroutineScope;
                Intrinsics.checkNotNullParameter(info, "info");
                coroutineScope = PostFeedMainTaskFacadeImpl.this.scope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PostFeedMainTaskFacadeImpl$taskListener$1$onTaskChange$1(info, null), 3, null);
            }

            @Override // com.tencent.mobileqq.guild.feed.api.h
            public void b(@NotNull String str, @NotNull o oVar) {
                h.a.b(this, str, oVar);
            }

            @Override // com.tencent.mobileqq.guild.feed.api.h
            public void c(@NotNull String str, long j3, long j16, @NotNull o oVar) {
                h.a.c(this, str, j3, j16, oVar);
            }

            @Override // com.tencent.mobileqq.guild.feed.api.h
            public void d(@NotNull String str, @NotNull o oVar) {
                h.a.d(this, str, oVar);
            }

            @Override // com.tencent.mobileqq.guild.feed.api.h
            public void e(@NotNull String str, @NotNull o oVar) {
                h.a.e(this, str, oVar);
            }

            @Override // com.tencent.mobileqq.guild.feed.api.h
            public void f(@NotNull String str, @NotNull o oVar) {
                h.a.f(this, str, oVar);
            }

            @Override // com.tencent.mobileqq.guild.feed.api.h
            public void g(@NotNull String str, @NotNull o oVar) {
                h.a.a(this, str, oVar);
            }

            @Override // com.tencent.mobileqq.guild.feed.api.h
            public void h(@NotNull String mediumId, @Nullable o info) {
                CoroutineScope coroutineScope;
                Intrinsics.checkNotNullParameter(mediumId, "mediumId");
                coroutineScope = PostFeedMainTaskFacadeImpl.this.scope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PostFeedMainTaskFacadeImpl$taskListener$1$onCancel$1(mediumId, null), 3, null);
            }
        };
        this.taskListener = r56;
        getUploadTaskApi().b(r56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Continuation<? super IPerformanceReportTask> continuation) {
        PostFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1 postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1;
        Object coroutine_suspended;
        int i3;
        PostFeedMainTaskFacadeImpl postFeedMainTaskFacadeImpl;
        Map<String, ? extends o> map;
        if (continuation instanceof PostFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1) {
            postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1 = (PostFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1) continuation;
            int i16 = postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.label = i16 - Integer.MIN_VALUE;
                Object obj = postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        postFeedMainTaskFacadeImpl = (PostFeedMainTaskFacadeImpl) postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    in1.c uploadTaskApi = getUploadTaskApi();
                    postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.L$0 = this;
                    postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.label = 1;
                    obj = uploadTaskApi.d(postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    postFeedMainTaskFacadeImpl = this;
                }
                map = MapsKt__MapsKt.toMap((Map) obj);
                if (!map.isEmpty()) {
                    return null;
                }
                return d.f223127a.a(postFeedMainTaskFacadeImpl.mainTask, map);
            }
        }
        postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1 = new PostFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1(this, continuation);
        Object obj2 = postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = postFeedMainTaskFacadeImpl$callReportMediaGroupUploadBegin$1.label;
        if (i3 == 0) {
        }
        map = MapsKt__MapsKt.toMap((Map) obj2);
        if (!map.isEmpty()) {
        }
    }

    private final void h(Map<String, ? extends LocalMediaInfo> localMediaList) {
        int size = getUploadTaskApi().c().size();
        if (size == localMediaList.size()) {
            return;
        }
        QLog.w("PostFeedTask.Facade", 1, "[compareAndUpdateSelectedMediaInUploadTask]: inconsistency detected!!! sizeOfTaskInfoMap=" + size + ", localMediaList.size=" + localMediaList.size());
        if (size < localMediaList.size()) {
            getUploadTaskApi().h("compareAndUpdate", localMediaList);
        }
    }

    private final Map<String, LocalMediaInfo> n(JSONObject feedJsonObject) {
        Object m476constructorimpl;
        Map<String, LocalMediaInfo> emptyMap;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(g.f223138a.b(new JSONArray(feedJsonObject.optString("patternInfo"))));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("PostFeedTask.Facade", 1, "[ValidateConsistency]: restore exception: ", m479exceptionOrNullimpl);
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        Map<String, LocalMediaInfo> map = (Map) m476constructorimpl;
        if (map == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return map;
    }

    private final Map<String, LocalMediaInfo> o(JSONObject feedJsonObject) {
        Object m476constructorimpl;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        rm1.b bVar = new rm1.b();
        om1.b bVar2 = new om1.b();
        try {
            Result.Companion companion = Result.INSTANCE;
            b.a.a(bVar, feedJsonObject, bVar2, null, 4, null);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("PostFeedTask.Facade", 1, "[ValidateConsistency]: restore exception: ", m479exceptionOrNullimpl);
        }
        List<fm1.i> b16 = bVar2.b();
        ArrayList<fm1.c> arrayList = new ArrayList();
        for (Object obj : b16) {
            if (obj instanceof fm1.c) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (fm1.c cVar : arrayList) {
            Pair pair = TuplesKt.to(cVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String(), cVar.j());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @Override // in1.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public in1.c getUploadTaskApi() {
        return this.uploadTaskApi;
    }

    @Override // in1.d
    /* renamed from: b, reason: from getter */
    public int getStage() {
        return this.stage;
    }

    @Override // in1.d
    public void c(int i3) {
        this.stage = i3;
    }

    public void f() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PostFeedMainTaskFacadeImpl$bindMediaProgressStates$1(this, null), 3, null);
    }

    @NotNull
    public String i() {
        String b16 = this.mainTask.b();
        if (b16 == null) {
            return "";
        }
        return b16;
    }

    public void j(@NotNull Consumer<h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PostFeedMainTaskFacadeImpl$javaCallUploadTaskAwait$1(this, callback, null), 3, null);
    }

    public final void k(@Nullable String json) {
        boolean z16;
        Map<String, LocalMediaInfo> n3;
        String str;
        boolean z17 = false;
        if (json != null && json.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jn1.b bVar = (jn1.b) new Gson().fromJson(json, jn1.b.class);
            if (bVar != null) {
                str = bVar.jsonFeed;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (str.length() > 0) {
                z17 = true;
            }
            if (z17) {
                jSONObject = new JSONObject(str);
            }
        } catch (Exception e16) {
            QLog.e("PostFeedTask.Facade", 1, "[ValidateConsistency]: mainTaskId=" + i(), e16);
        }
        if (jSONObject == null) {
            QLog.e("PostFeedTask.Facade", 1, "[ValidateConsistency]: mainTaskId=" + i() + ", parse json failed");
            return;
        }
        if (jSONObject.optInt(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, 1) == 1) {
            n3 = o(jSONObject);
        } else {
            n3 = n(jSONObject);
        }
        h(n3);
    }

    public void l(@Nullable CancellationException cause) {
        CoroutineScopeKt.cancel(this.scope, cause);
        getUploadTaskApi().cancel(cause);
    }

    public void m(boolean isSuccess) {
        if (isSuccess) {
            getUploadTaskApi().release();
        }
    }
}
