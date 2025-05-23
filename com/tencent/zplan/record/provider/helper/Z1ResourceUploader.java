package com.tencent.zplan.record.provider.helper;

import by4.ZPlanRecordResourceStatistic;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.model.AbsRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import com.tencent.zplan.record.provider.CloudCacheProvider;
import com.tencent.zplan.record.provider.LocalRecordProvider;
import com.tencent.zplan.record.provider.helper.a;
import dx4.d;
import dx4.e;
import ex4.LocalRecordDoneResult;
import ex4.LocalRecordFailedResult;
import ex4.LocalRecordStartResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import lx4.d;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yx4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010#\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020$\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\f\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0017\u0010#\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/zplan/record/provider/helper/Z1ResourceUploader;", "Lcom/tencent/zplan/record/provider/helper/a;", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "", "g", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "Lcom/tencent/zplan/meme/model/MemeResult;", "memeResult", "", "a", "k", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Ljava/lang/String;", "logInfo", "Ljava/util/concurrent/locks/ReentrantLock;", "b", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ldx4/e;", "c", "Ldx4/e;", "uploadCallback", "", "d", "Ljava/util/List;", "localRecordDoneResources", "Lex4/d;", "e", "needUploadTasks", "f", "getAppearanceKey", "()Ljava/lang/String;", "appearanceKey", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", h.F, "()Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "params", "<init>", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/AbsRecordRequestParams;)V", "j", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class Z1ResourceUploader implements a {

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f386148h;

    /* renamed from: i, reason: collision with root package name */
    private static final Set<String> f386149i;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String logInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private e uploadCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<ZPlanRecordResource> localRecordDoneResources;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<LocalRecordStartResult> needUploadTasks;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appearanceKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AbsRecordRequestParams params;

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016J&\u0010\u0010\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/zplan/record/provider/helper/Z1ResourceUploader$1", "Ldx4/d;", "", "Lex4/d;", "taskList", "Ldx4/e;", "callback", "", "c", "Lex4/b;", "b", "Lex4/c;", "", "errorCode", "", "errorMessage", "a", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.provider.helper.Z1ResourceUploader$1, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static final class AnonymousClass1 implements d {
        AnonymousClass1() {
        }

        @Override // dx4.d
        public void a(@NotNull List<LocalRecordFailedResult> taskList, int errorCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(taskList, "taskList");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_Z1ResourceUploader", 1, Z1ResourceUploader.this.logInfo + ", createLocalTask onTaskError:" + taskList + ", errorCode:" + errorCode + ", errorMessage:" + errorMessage, null, 8, null);
            }
        }

        @Override // dx4.d
        public void b(@NotNull List<LocalRecordDoneResult> taskList) {
            Intrinsics.checkNotNullParameter(taskList, "taskList");
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_Z1ResourceUploader", 1, Z1ResourceUploader.this.logInfo + ", createLocalTask onTaskDone:" + taskList, null, 8, null);
            }
        }

        @Override // dx4.d
        public void c(@NotNull List<LocalRecordStartResult> taskList, @NotNull e callback) {
            Intrinsics.checkNotNullParameter(taskList, "taskList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_Z1ResourceUploader", 1, Z1ResourceUploader.this.logInfo + ", createLocalTask recordAndUpload:" + taskList + ", callback:" + callback, null, 8, null);
            }
            ReentrantLock reentrantLock = Z1ResourceUploader.this.lock;
            reentrantLock.lock();
            try {
                Z1ResourceUploader.this.uploadCallback = callback;
                Z1ResourceUploader.this.needUploadTasks.addAll(taskList);
                reentrantLock.unlock();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Z1ResourceUploader$1$recordAndUpload$2(this, null), 3, null);
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/record/provider/helper/Z1ResourceUploader$a;", "", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "Lcom/tencent/zplan/record/provider/helper/a;", "c", "Lcom/tencent/zplan/cloud/impl/b;", "cloudRecordTaskCreator$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/zplan/cloud/impl/b;", "cloudRecordTaskCreator", "", "TAG", "Ljava/lang/String;", "", "hasCallbackUploadSuccessSet", "Ljava/util/Set;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.provider.helper.Z1ResourceUploader$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final com.tencent.zplan.cloud.impl.b b() {
            return (com.tencent.zplan.cloud.impl.b) Z1ResourceUploader.f386148h.getValue();
        }

        @Nullable
        public final a c(@NotNull AbsRecordRequestParams z1Uploader) {
            Intrinsics.checkNotNullParameter(z1Uploader, "$this$z1Uploader");
            if (!z1Uploader.getUploadConfig().getNeedUpload()) {
                return null;
            }
            if (z1Uploader.getUploadConfig().getNeedCheckUploadConfigRequirement()) {
                CloudCacheProvider.Companion companion = CloudCacheProvider.INSTANCE;
                c.LocalResourceUploadConfig localResourceUploadConfig = companion.c().getLocalResourceUploadConfig();
                if (!companion.d().o(localResourceUploadConfig)) {
                    lx4.d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.d(a16, "[ZPlanRRC]_Z1ResourceUploader", 1, "create z1Uploader failed for missed requirement:" + localResourceUploadConfig + " for params:" + z1Uploader, null, 8, null);
                    }
                    return null;
                }
            }
            String d16 = z1Uploader.a().getSenderInfo().d();
            if (d16 == null) {
                d16 = "";
            }
            return new Z1ResourceUploader(d16, z1Uploader);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.zplan.cloud.impl.b>() { // from class: com.tencent.zplan.record.provider.helper.Z1ResourceUploader$Companion$cloudRecordTaskCreator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.zplan.cloud.impl.b invoke() {
                return new com.tencent.zplan.cloud.impl.b();
            }
        });
        f386148h = lazy;
        f386149i = new LinkedHashSet();
    }

    public Z1ResourceUploader(@NotNull String appearanceKey, @NotNull AbsRecordRequestParams params) {
        gx4.a aVar;
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        Intrinsics.checkNotNullParameter(params, "params");
        this.appearanceKey = appearanceKey;
        this.params = params;
        this.logInfo = "appearanceKey:" + appearanceKey + ", action:" + params.a().getDesc();
        this.lock = new ReentrantLock();
        this.localRecordDoneResources = new ArrayList();
        this.needUploadTasks = new ArrayList();
        com.tencent.zplan.cloud.impl.b b16 = INSTANCE.b();
        AvatarCharacterInfo senderAvatarCharacterInfo = params.getSenderAvatarCharacterInfo();
        if (senderAvatarCharacterInfo != null) {
            aVar = senderAvatarCharacterInfo.getCharacter();
        } else {
            aVar = null;
        }
        b16.c(appearanceKey, aVar, params.getScene(), params.a(), new AnonymousClass1());
    }

    private final boolean g(MemeZPlanBaseAction action) {
        return LocalRecordProvider.INSTANCE.e(action.getSenderInfo().d(), this.appearanceKey);
    }

    @Override // com.tencent.zplan.record.provider.helper.a
    public void a(@NotNull ZPlanRecordResource resource, @NotNull MemeResult memeResult) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(memeResult, "memeResult");
        if (!resource.o()) {
            return;
        }
        boolean checkAppearanceKey = this.params.getUploadConfig().getCheckAppearanceKey();
        MemeAction action = memeResult.getAction();
        if (checkAppearanceKey && (action instanceof MemeZPlanBaseAction) && !g((MemeZPlanBaseAction) action)) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_Z1ResourceUploader", 1, this.logInfo + ", tryUploadOnResourceReady, checkAppearanceKey fail, skip!", null, 8, null);
                return;
            }
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.localRecordDoneResources.add(resource);
            reentrantLock.unlock();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Z1ResourceUploader$upload$2(this, null), 3, null);
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final AbsRecordRequestParams getParams() {
        return this.params;
    }

    @NotNull
    public String i(@NotNull String removeUrlHost) {
        Intrinsics.checkNotNullParameter(removeUrlHost, "$this$removeUrlHost");
        return a.C10070a.a(this, removeUrlHost);
    }

    public void j(@NotNull String senderUin, long j3, int i3, @NotNull String target, boolean z16, @Nullable String str, boolean z17, @Nullable String str2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(target, "target");
        a.C10070a.b(this, senderUin, j3, i3, target, z16, str, z17, str2, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object k(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object obj;
        boolean z16;
        e eVar = this.uploadCallback;
        if (eVar == null) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (eVar == coroutine_suspended) {
                return eVar;
            }
            return Unit.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (ZPlanRecordResource zPlanRecordResource : this.localRecordDoneResources) {
                Iterator<T> it = this.needUploadTasks.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        int portraitId = ((LocalRecordStartResult) obj).getCommonAction().getPortraitId();
                        ZPlanRecordResourceStatistic statistic = zPlanRecordResource.getStatistic();
                        if (statistic != null && portraitId == statistic.getResId()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (Boxing.boxBoolean(z16).booleanValue()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                LocalRecordStartResult localRecordStartResult = (LocalRecordStartResult) obj;
                if (localRecordStartResult != null) {
                    this.needUploadTasks.remove(localRecordStartResult);
                    Set<String> set = f386149i;
                    if (!set.contains(localRecordStartResult.getTaskId())) {
                        linkedHashMap.put(zPlanRecordResource, localRecordStartResult);
                        set.add(localRecordStartResult.getTaskId());
                    }
                }
            }
            Boxing.boxBoolean(this.localRecordDoneResources.removeAll(linkedHashMap.keySet()));
            reentrantLock.unlock();
            if (linkedHashMap.isEmpty()) {
                return Unit.INSTANCE;
            }
            String str = "try upload on cloud and local record finish, " + this.logInfo;
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_Z1ResourceUploader", 1, str + ", size:" + linkedHashMap.size(), null, 8, null);
            }
            Iterator it5 = linkedHashMap.entrySet().iterator();
            while (it5.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Z1ResourceUploader$tryUploadOnCloudResponse$$inlined$forEach$lambda$1((Map.Entry) it5.next(), null, this, str, eVar), 3, null);
            }
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }
}
