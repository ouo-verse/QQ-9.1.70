package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.ParentTaskContext;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import ij1.GuildMediaUploadTaskInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\u0004\bC\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0007J?\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0002R\u001a\u0010\u0018\u001a\u00020\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001bR\"\u0010'\u001a\u00020 8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R2\u00103\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\"\u00109\u001a\u0002048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b)\u00105\u001a\u0004\b!\u00106\"\u0004\b7\u00108R.\u0010=\u001a\u001a\u0012\u0014\u0012\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u0002`;\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010?\u001a\u0004\b@\u0010A\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "i", "", "k", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "localMediaInfo", "originalPic", "Lcom/tencent/qqnt/msg/api/c;", "", "Lij1/m;", "t", "(Ljava/util/ArrayList;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "logTag", "c", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "commentTxt", "getTaskID", ReportConstant.COSTREPORT_PREFIX, com.heytap.mcssdk.a.a.f36094d, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/STATE;", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/STATE;", tl.h.F, "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/STATE;", "r", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/STATE;)V", "state", "Z", "g", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "mediaOriginal", "f", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "p", "(Ljava/util/ArrayList;)V", "mediaInfo", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "o", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", "lifecycleScope", "Lkotlinx/coroutines/Deferred;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/UploadResult;", "Lkotlinx/coroutines/Deferred;", "uploadJob", "Lin1/c;", "Lkotlin/Lazy;", "j", "()Lin1/c;", "uploadTaskApi", "<init>", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class ICommentTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String commentTxt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String taskID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private STATE state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mediaOriginal;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<LocalMediaInfo> mediaInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public LifecycleCoroutineScope lifecycleScope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Deferred<com.tencent.qqnt.msg.api.c<Collection<GuildMediaUploadTaskInfo>>> uploadJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uploadTaskApi;

    public ICommentTask(@NotNull String logTag) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.logTag = logTag;
        this.commentTxt = "";
        this.taskID = "";
        this.state = STATE.INITIAL;
        this.mediaInfo = new ArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<FeedMediaUploadTask>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask$uploadTaskApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedMediaUploadTask invoke() {
                return new FeedMediaUploadTask(ICommentTask.this.getLogTag(), new ParentTaskContext(ICommentTask.this.getTaskID(), null, 2, null), false);
            }
        });
        this.uploadTaskApi = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final in1.c j() {
        return (in1.c) this.uploadTaskApi.getValue();
    }

    public final void b() {
        Deferred<com.tencent.qqnt.msg.api.c<Collection<GuildMediaUploadTaskInfo>>> deferred = this.uploadJob;
        if (deferred != null) {
            Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        }
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCommentTxt() {
        return this.commentTxt;
    }

    @NotNull
    public final LifecycleCoroutineScope d() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.lifecycleScope;
        if (lifecycleCoroutineScope != null) {
            return lifecycleCoroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleScope");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getLogTag() {
        return this.logTag;
    }

    @NotNull
    public final ArrayList<LocalMediaInfo> f() {
        return this.mediaInfo;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getMediaOriginal() {
        return this.mediaOriginal;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: h, reason: from getter */
    public final STATE getState() {
        return this.state;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public String getTaskID() {
        return this.taskID;
    }

    public final boolean k() {
        if (this.lifecycleScope != null) {
            return true;
        }
        return false;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commentTxt = str;
    }

    public final void o(@NotNull LifecycleCoroutineScope lifecycleCoroutineScope) {
        Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "<set-?>");
        this.lifecycleScope = lifecycleCoroutineScope;
    }

    public final void p(@NotNull ArrayList<LocalMediaInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mediaInfo = arrayList;
    }

    public final void q(boolean z16) {
        this.mediaOriginal = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(@NotNull STATE state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskID = str;
    }

    @Nullable
    public final Object t(@NotNull ArrayList<LocalMediaInfo> arrayList, boolean z16, @NotNull Continuation<? super com.tencent.qqnt.msg.api.c<Collection<GuildMediaUploadTaskInfo>>> continuation) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Deferred<com.tencent.qqnt.msg.api.c<Collection<GuildMediaUploadTaskInfo>>> async$default;
        boolean z17;
        Deferred<com.tencent.qqnt.msg.api.c<Collection<GuildMediaUploadTaskInfo>>> deferred = this.uploadJob;
        if (deferred != null) {
            QLog.i(this.logTag, 1, "[uploadPic]: previous task is scrapped, hash=" + deferred.hashCode());
            Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        }
        this.uploadJob = null;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((LocalMediaInfo) obj).mMediaType == com.tencent.guild.api.media.album.c.a()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((LocalMediaInfo) it.next()).isRwa = z16;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b(), obj2);
        }
        j().h(this.logTag, linkedHashMap);
        async$default = BuildersKt__Builders_commonKt.async$default(d(), null, null, new ICommentTask$uploadPic$job$1(this, null), 3, null);
        async$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask$uploadPic$job$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                in1.c j3;
                in1.c j16;
                if (th5 == null) {
                    j3 = ICommentTask.this.j();
                    j3.release();
                    return;
                }
                QLog.e(ICommentTask.this.getLogTag(), 1, "[uploadPic]: upload pic operation cancelled", th5);
                j16 = ICommentTask.this.j();
                CancellationException cancellationException = th5 instanceof CancellationException ? (CancellationException) th5 : null;
                if (cancellationException == null) {
                    cancellationException = new CancellationException(th5.toString());
                    cancellationException.initCause(th5);
                }
                j16.cancel(cancellationException);
            }
        });
        this.uploadJob = async$default;
        return async$default.await(continuation);
    }

    public void l() {
    }

    public void m() {
    }
}
