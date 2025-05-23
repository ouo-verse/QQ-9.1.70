package com.tencent.zplan.record.provider.helper;

import android.webkit.URLUtil;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.record.manager.ZPlanResourceManager;
import com.tencent.zplan.record.manager.ZPlanResourceUploader;
import com.tencent.zplan.record.model.AbsRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import com.tencent.zplan.record.provider.CloudCacheProvider;
import com.tencent.zplan.record.provider.LocalRecordProvider;
import com.tencent.zplan.record.provider.helper.a;
import fv4.d;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx4.c;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001e\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J#\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/zplan/record/provider/helper/SPQSResourceUploader;", "Lcom/tencent/zplan/record/provider/helper/a;", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "", "c", "d", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "Lcom/tencent/zplan/meme/model/MemeResult;", "memeResult", "", "a", "Lfv4/d;", "waitUploadRecord", "g", "(Lcom/tencent/zplan/record/model/ZPlanRecordResource;Lfv4/d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Ljava/lang/String;", "appearanceKey", "b", "logInfo", "Llx4/a;", "Lkotlin/Lazy;", "e", "()Llx4/a;", "commonProxy", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "params", "", "Ljava/util/List;", "waitUploadList", "<init>", "(Lcom/tencent/zplan/record/model/AbsRecordRequestParams;Ljava/util/List;)V", "i", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class SPQSResourceUploader implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String appearanceKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String logInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy commonProxy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AbsRecordRequestParams params;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<d> waitUploadList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Set<String> f386129f = new LinkedHashSet();

    /* renamed from: g, reason: collision with root package name */
    private static final long f386130g = -2;

    /* renamed from: h, reason: collision with root package name */
    private static final long f386131h = -3;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/record/provider/helper/SPQSResourceUploader$a;", "", "Lcom/tencent/zplan/record/model/AbsRecordRequestParams;", "", "Lfv4/d;", "waitUploadRecordList", "Lcom/tencent/zplan/record/provider/helper/a;", "a", "", "SET_UPLOAD_RESULT_SKIP_ERROR_CODE", "J", "SET_UPLOAD_RESULT_UPLOAD_FAIL", "", "TAG", "Ljava/lang/String;", "", "hasUploadAndSetUploadResultBackendSet", "Ljava/util/Set;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.record.provider.helper.SPQSResourceUploader$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final a a(@NotNull AbsRecordRequestParams qqUploader, @NotNull List<d> waitUploadRecordList) {
            Intrinsics.checkNotNullParameter(qqUploader, "$this$qqUploader");
            Intrinsics.checkNotNullParameter(waitUploadRecordList, "waitUploadRecordList");
            if (!qqUploader.getUploadConfig().getNeedUpload() || waitUploadRecordList.isEmpty()) {
                return null;
            }
            if (qqUploader.getUploadConfig().getNeedCheckUploadConfigRequirement()) {
                CloudCacheProvider.Companion companion = CloudCacheProvider.INSTANCE;
                c.LocalResourceUploadConfig localResourceUploadConfig = companion.c().getLocalResourceUploadConfig();
                if (!companion.d().o(localResourceUploadConfig)) {
                    lx4.d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.d(a16, "[ZPlanRRC]_SPQSResourceUploader", 1, "create qqUploader failed for missed requirement:" + localResourceUploadConfig + " for params:" + qqUploader, null, 8, null);
                    }
                    return null;
                }
            }
            return new SPQSResourceUploader(qqUploader, waitUploadRecordList);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SPQSResourceUploader(@NotNull AbsRecordRequestParams params, @NotNull List<fv4.d> waitUploadList) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(waitUploadList, "waitUploadList");
        this.params = params;
        this.waitUploadList = waitUploadList;
        String d16 = params.a().getSenderInfo().d();
        this.appearanceKey = d16;
        this.logInfo = "appearanceKey:" + d16 + ", action:" + params.a().getDesc();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<lx4.a>() { // from class: com.tencent.zplan.record.provider.helper.SPQSResourceUploader$commonProxy$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final lx4.a invoke() {
                return (lx4.a) mx4.a.f417748a.a(lx4.a.class);
            }
        });
        this.commonProxy = lazy;
    }

    private final boolean c(MemeZPlanBaseAction action) {
        return LocalRecordProvider.INSTANCE.e(action.getSenderInfo().d(), this.appearanceKey);
    }

    private final boolean d() {
        String str;
        boolean z16;
        boolean z17;
        String sender = this.params.getSender();
        lx4.a e16 = e();
        if (e16 != null) {
            str = e16.getCurrentUin();
        } else {
            str = null;
        }
        if (sender.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17 && Intrinsics.areEqual(sender, str)) {
                return true;
            }
        }
        return false;
    }

    private final lx4.a e() {
        return (lx4.a) this.commonProxy.getValue();
    }

    @Override // com.tencent.zplan.record.provider.helper.a
    public void a(@NotNull ZPlanRecordResource resource, @NotNull MemeResult memeResult) {
        boolean z16;
        Object obj;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(memeResult, "memeResult");
        if (!resource.o()) {
            return;
        }
        boolean checkAppearanceKey = this.params.getUploadConfig().getCheckAppearanceKey();
        MemeAction action = memeResult.getAction();
        if (checkAppearanceKey && (action instanceof MemeZPlanBaseAction) && !c((MemeZPlanBaseAction) action)) {
            lx4.d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[ZPlanRRC]_SPQSResourceUploader", 1, "uploadResource, checkAppearanceKey fail, skip! path:" + resource.getLocalPath() + ", " + this.logInfo, null, 8, null);
                return;
            }
            return;
        }
        if (!d()) {
            lx4.d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                d.a.c(a17, "[ZPlanRRC]_SPQSResourceUploader", 1, "uploadResource, checkUin fail, skip! path:" + resource.getLocalPath() + ", " + this.logInfo, null, 8, null);
                return;
            }
            return;
        }
        Iterator<T> it = this.waitUploadList.iterator();
        while (true) {
            z16 = true;
            if (it.hasNext()) {
                obj = it.next();
                if (((fv4.d) obj).f400867a == action.getActionId()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        fv4.d dVar = (fv4.d) obj;
        if (dVar != null) {
            if (dVar.f400868b == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                String str = dVar.f400870d;
                if (str != null && str.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    String valueOf = String.valueOf(resource.getLocalPath());
                    Set<String> set = f386129f;
                    synchronized (set) {
                        if (set.contains(valueOf)) {
                            lx4.d a18 = LogUtil.f385285b.a();
                            if (a18 != null) {
                                d.a.c(a18, "[ZPlanRRC]_SPQSResourceUploader", 1, this.logInfo + ", uploadResource for " + resource.getLocalPath() + " to uploadDir:" + dVar.f400870d + ", but already startup, skip!!", null, 8, null);
                            }
                            return;
                        }
                        set.add(valueOf);
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SPQSResourceUploader$upload$2(this, resource, dVar, valueOf, null), 3, null);
                        return;
                    }
                }
            }
            lx4.d a19 = LogUtil.f385285b.a();
            if (a19 != null) {
                d.a.c(a19, "[ZPlanRRC]_SPQSResourceUploader", 1, this.logInfo + ", uploadResource for " + resource.getLocalPath() + " but do not needUpload or uploadDir:" + dVar.f400870d + " invalid, skip!!", null, 8, null);
            }
        }
    }

    public void f(@NotNull String senderUin, long j3, int i3, @NotNull String target, boolean z16, @Nullable String str, boolean z17, @Nullable String str2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(target, "target");
        a.C10070a.b(this, senderUin, j3, i3, target, z16, str, z17, str2, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object g(ZPlanRecordResource zPlanRecordResource, fv4.d dVar, Continuation<? super Unit> continuation) {
        SPQSResourceUploader$uploadResource$1 sPQSResourceUploader$uploadResource$1;
        Object coroutine_suspended;
        int i3;
        EngineType engineType;
        boolean endsWith$default;
        String sender;
        String str;
        SPQSResourceUploader sPQSResourceUploader;
        String str2;
        boolean isValidUrl;
        lx4.d a16;
        String str3;
        Pair pair;
        ZPlanRecordResource zPlanRecordResource2;
        boolean z16;
        String str4;
        fv4.d dVar2;
        String str5;
        String str6;
        List<fv4.d> listOf;
        fv4.d dVar3;
        SPQSResourceUploader sPQSResourceUploader2;
        Long l3;
        Map<String, String> mapOf;
        ZPlanRecordResource zPlanRecordResource3 = zPlanRecordResource;
        fv4.d dVar4 = dVar;
        if (continuation instanceof SPQSResourceUploader$uploadResource$1) {
            sPQSResourceUploader$uploadResource$1 = (SPQSResourceUploader$uploadResource$1) continuation;
            int i16 = sPQSResourceUploader$uploadResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                sPQSResourceUploader$uploadResource$1.label = i16 - Integer.MIN_VALUE;
                Object obj = sPQSResourceUploader$uploadResource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = sPQSResourceUploader$uploadResource$1.label;
                String str7 = null;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                z16 = sPQSResourceUploader$uploadResource$1.Z$0;
                                str5 = (String) sPQSResourceUploader$uploadResource$1.L$3;
                                dVar3 = (fv4.d) sPQSResourceUploader$uploadResource$1.L$2;
                                zPlanRecordResource2 = (ZPlanRecordResource) sPQSResourceUploader$uploadResource$1.L$1;
                                sPQSResourceUploader2 = (SPQSResourceUploader) sPQSResourceUploader$uploadResource$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                pair = (Pair) obj;
                                isValidUrl = z16;
                                sPQSResourceUploader = sPQSResourceUploader2;
                                zPlanRecordResource3 = zPlanRecordResource2;
                                str6 = str5;
                                dVar4 = dVar3;
                                str3 = str6;
                                boolean z17 = isValidUrl;
                                String sender2 = sPQSResourceUploader.params.getSender();
                                long j3 = dVar4.f400867a;
                                int scene = sPQSResourceUploader.params.getScene();
                                String name = sPQSResourceUploader.params.getUploadConfig().getTarget().name();
                                String dressKey = zPlanRecordResource3.getDressKey();
                                Pair[] pairArr = new Pair[3];
                                pairArr[0] = TuplesKt.to("uploadPath", dVar4.f400870d);
                                if (pair == null) {
                                    l3 = (Long) pair.getFirst();
                                } else {
                                    l3 = null;
                                }
                                pairArr[1] = TuplesKt.to("setUploadErrorCode", String.valueOf(l3.longValue()));
                                if (pair != null) {
                                    str7 = (String) pair.getSecond();
                                }
                                pairArr[2] = TuplesKt.to("setUploadErrorMsg", String.valueOf(str7));
                                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                                sPQSResourceUploader.f(sender2, j3, scene, name, z17, str3, true, dressKey, mapOf);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z16 = sPQSResourceUploader$uploadResource$1.Z$0;
                        str5 = (String) sPQSResourceUploader$uploadResource$1.L$4;
                        String str8 = (String) sPQSResourceUploader$uploadResource$1.L$3;
                        fv4.d dVar5 = (fv4.d) sPQSResourceUploader$uploadResource$1.L$2;
                        ZPlanRecordResource zPlanRecordResource4 = (ZPlanRecordResource) sPQSResourceUploader$uploadResource$1.L$1;
                        SPQSResourceUploader sPQSResourceUploader3 = (SPQSResourceUploader) sPQSResourceUploader$uploadResource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str4 = str8;
                        dVar2 = dVar5;
                        zPlanRecordResource2 = zPlanRecordResource4;
                        sPQSResourceUploader = sPQSResourceUploader3;
                        if (!sPQSResourceUploader.d()) {
                            SPQSCloudCacheHelper sPQSCloudCacheHelper = SPQSCloudCacheHelper.f386123d;
                            AbsRecordRequestParams absRecordRequestParams = sPQSResourceUploader.params;
                            listOf = CollectionsKt__CollectionsJVMKt.listOf(dVar2);
                            sPQSResourceUploader$uploadResource$1.L$0 = sPQSResourceUploader;
                            sPQSResourceUploader$uploadResource$1.L$1 = zPlanRecordResource2;
                            sPQSResourceUploader$uploadResource$1.L$2 = dVar2;
                            sPQSResourceUploader$uploadResource$1.L$3 = str5;
                            sPQSResourceUploader$uploadResource$1.L$4 = null;
                            sPQSResourceUploader$uploadResource$1.Z$0 = z16;
                            sPQSResourceUploader$uploadResource$1.label = 3;
                            Object i17 = sPQSCloudCacheHelper.i(absRecordRequestParams, listOf, sPQSResourceUploader$uploadResource$1);
                            if (i17 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            dVar3 = dVar2;
                            obj = i17;
                            sPQSResourceUploader2 = sPQSResourceUploader;
                            pair = (Pair) obj;
                            isValidUrl = z16;
                            sPQSResourceUploader = sPQSResourceUploader2;
                            zPlanRecordResource3 = zPlanRecordResource2;
                            str6 = str5;
                            dVar4 = dVar3;
                            str3 = str6;
                            boolean z172 = isValidUrl;
                            String sender22 = sPQSResourceUploader.params.getSender();
                            long j36 = dVar4.f400867a;
                            int scene2 = sPQSResourceUploader.params.getScene();
                            String name2 = sPQSResourceUploader.params.getUploadConfig().getTarget().name();
                            String dressKey2 = zPlanRecordResource3.getDressKey();
                            Pair[] pairArr2 = new Pair[3];
                            pairArr2[0] = TuplesKt.to("uploadPath", dVar4.f400870d);
                            if (pair == null) {
                            }
                            pairArr2[1] = TuplesKt.to("setUploadErrorCode", String.valueOf(l3.longValue()));
                            if (pair != null) {
                            }
                            pairArr2[2] = TuplesKt.to("setUploadErrorMsg", String.valueOf(str7));
                            mapOf = MapsKt__MapsKt.mapOf(pairArr2);
                            sPQSResourceUploader.f(sender22, j36, scene2, name2, z172, str3, true, dressKey2, mapOf);
                            return Unit.INSTANCE;
                        }
                        lx4.d a17 = LogUtil.f385285b.a();
                        if (a17 != null) {
                            d.a.d(a17, "[ZPlanRRC]_SPQSResourceUploader", 1, str4 + ", skip set back to server, checkUin fail", null, 8, null);
                        }
                        isValidUrl = z16;
                        zPlanRecordResource3 = zPlanRecordResource2;
                        str6 = str5;
                        dVar4 = dVar2;
                        pair = new Pair(Boxing.boxLong(f386130g), "checkUin fail, skip");
                        str3 = str6;
                        boolean z1722 = isValidUrl;
                        String sender222 = sPQSResourceUploader.params.getSender();
                        long j362 = dVar4.f400867a;
                        int scene22 = sPQSResourceUploader.params.getScene();
                        String name22 = sPQSResourceUploader.params.getUploadConfig().getTarget().name();
                        String dressKey22 = zPlanRecordResource3.getDressKey();
                        Pair[] pairArr22 = new Pair[3];
                        pairArr22[0] = TuplesKt.to("uploadPath", dVar4.f400870d);
                        if (pair == null) {
                        }
                        pairArr22[1] = TuplesKt.to("setUploadErrorCode", String.valueOf(l3.longValue()));
                        if (pair != null) {
                        }
                        pairArr22[2] = TuplesKt.to("setUploadErrorMsg", String.valueOf(str7));
                        mapOf = MapsKt__MapsKt.mapOf(pairArr22);
                        sPQSResourceUploader.f(sender222, j362, scene22, name22, z1722, str3, true, dressKey22, mapOf);
                        return Unit.INSTANCE;
                    }
                    String str9 = (String) sPQSResourceUploader$uploadResource$1.L$3;
                    dVar4 = (fv4.d) sPQSResourceUploader$uploadResource$1.L$2;
                    ZPlanRecordResource zPlanRecordResource5 = (ZPlanRecordResource) sPQSResourceUploader$uploadResource$1.L$1;
                    sPQSResourceUploader = (SPQSResourceUploader) sPQSResourceUploader$uploadResource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str9;
                    zPlanRecordResource3 = zPlanRecordResource5;
                } else {
                    ResultKt.throwOnFailure(obj);
                    String str10 = "uploadResource for id:" + dVar4.f400867a + ", path:" + zPlanRecordResource.getLocalPath() + " to uploadDir:" + dVar4.f400870d;
                    BusinessConfig businessConfig = this.params.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                    if (businessConfig != null) {
                        engineType = businessConfig.getTargetEngine();
                    } else {
                        engineType = null;
                    }
                    boolean z18 = engineType instanceof EngineType.Filament;
                    UploadConfig.UploadTarget target = this.params.getUploadConfig().getTarget();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(dVar4.f400870d);
                    String str11 = dVar4.f400870d;
                    Intrinsics.checkNotNullExpressionValue(str11, "waitUploadRecord.uploadDir");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str11, "/", false, 2, null);
                    if (!endsWith$default) {
                        sb5.append("/");
                    }
                    AvatarCharacterInfo senderAvatarCharacterInfo = this.params.getSenderAvatarCharacterInfo();
                    if (senderAvatarCharacterInfo == null || (sender = senderAvatarCharacterInfo.getDressKey()) == null) {
                        sender = this.params.getSender();
                    }
                    sb5.append(sender);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(util.base64_pad_url);
                    sb6.append(System.currentTimeMillis());
                    sb5.append(sb6.toString());
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("_and");
                    if (z18) {
                        str = "_fila";
                    } else {
                        str = "";
                    }
                    sb7.append(str);
                    sb5.append(sb7.toString());
                    String sb8 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb8, "StringBuilder().apply(builderAction).toString()");
                    ZPlanResourceUploader zPlanResourceUploader = ZPlanResourceUploader.f386016c;
                    sPQSResourceUploader$uploadResource$1.L$0 = this;
                    sPQSResourceUploader$uploadResource$1.L$1 = zPlanRecordResource3;
                    sPQSResourceUploader$uploadResource$1.L$2 = dVar4;
                    sPQSResourceUploader$uploadResource$1.L$3 = str10;
                    sPQSResourceUploader$uploadResource$1.label = 1;
                    Object f16 = zPlanResourceUploader.f(zPlanRecordResource3, sb8, target, sPQSResourceUploader$uploadResource$1);
                    if (f16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sPQSResourceUploader = this;
                    str2 = str10;
                    obj = f16;
                }
                String str12 = (String) obj;
                isValidUrl = URLUtil.isValidUrl(str12);
                a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "[ZPlanRRC]_SPQSResourceUploader", 1, str2 + " uploadUrl:" + str12 + ", result:" + isValidUrl, null, 8, null);
                }
                if (!isValidUrl) {
                    zPlanRecordResource3.r(str12);
                    dVar4.f400869c = str12;
                    ZPlanResourceManager zPlanResourceManager = ZPlanResourceManager.f386013d;
                    String key = zPlanRecordResource3.getKey();
                    sPQSResourceUploader$uploadResource$1.L$0 = sPQSResourceUploader;
                    sPQSResourceUploader$uploadResource$1.L$1 = zPlanRecordResource3;
                    sPQSResourceUploader$uploadResource$1.L$2 = dVar4;
                    sPQSResourceUploader$uploadResource$1.L$3 = str2;
                    sPQSResourceUploader$uploadResource$1.L$4 = str12;
                    sPQSResourceUploader$uploadResource$1.Z$0 = isValidUrl;
                    sPQSResourceUploader$uploadResource$1.label = 2;
                    if (zPlanResourceManager.b(key, zPlanRecordResource3, false, sPQSResourceUploader$uploadResource$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str13 = str2;
                    zPlanRecordResource2 = zPlanRecordResource3;
                    z16 = isValidUrl;
                    str4 = str13;
                    dVar2 = dVar4;
                    str5 = str12;
                    if (!sPQSResourceUploader.d()) {
                    }
                } else {
                    str3 = str12;
                    pair = new Pair(Boxing.boxLong(f386131h), "upload fail");
                    boolean z17222 = isValidUrl;
                    String sender2222 = sPQSResourceUploader.params.getSender();
                    long j3622 = dVar4.f400867a;
                    int scene222 = sPQSResourceUploader.params.getScene();
                    String name222 = sPQSResourceUploader.params.getUploadConfig().getTarget().name();
                    String dressKey222 = zPlanRecordResource3.getDressKey();
                    Pair[] pairArr222 = new Pair[3];
                    pairArr222[0] = TuplesKt.to("uploadPath", dVar4.f400870d);
                    if (pair == null) {
                    }
                    pairArr222[1] = TuplesKt.to("setUploadErrorCode", String.valueOf(l3.longValue()));
                    if (pair != null) {
                    }
                    pairArr222[2] = TuplesKt.to("setUploadErrorMsg", String.valueOf(str7));
                    mapOf = MapsKt__MapsKt.mapOf(pairArr222);
                    sPQSResourceUploader.f(sender2222, j3622, scene222, name222, z17222, str3, true, dressKey222, mapOf);
                    return Unit.INSTANCE;
                }
            }
        }
        sPQSResourceUploader$uploadResource$1 = new SPQSResourceUploader$uploadResource$1(this, continuation);
        Object obj2 = sPQSResourceUploader$uploadResource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = sPQSResourceUploader$uploadResource$1.label;
        String str72 = null;
        if (i3 == 0) {
        }
        String str122 = (String) obj2;
        isValidUrl = URLUtil.isValidUrl(str122);
        a16 = LogUtil.f385285b.a();
        if (a16 != null) {
        }
        if (!isValidUrl) {
        }
    }
}
