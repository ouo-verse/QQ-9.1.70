package com.tencent.mobileqq.wink.picker.core.repository;

import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.WinkPhotoListServiceHandler;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.picker.core.repository.WinkOnlineAssetMediaRepository;
import com.tencent.mobileqq.wink.picker.utils.p;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J=\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0006J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0018\u001a\u0004\u0018\u00010\tR&\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/WinkOnlineAssetMediaRepository;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "e", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", tl.h.F, "Lcamera/SHADOW_BACKEND_INTERFACE/CircleTemplateInfo;", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "k", "(Lcamera/SHADOW_BACKEND_INTERFACE/CircleTemplateInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoUrl", "f", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "path", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "d", "g", "isBlockingUI", "l", "j", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/picker/core/repository/WinkOnlineAssetMediaRepository$a;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "listenerMap", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "exportTasks", "Lcom/tencent/mobileqq/wink/edit/manager/WinkPhotoListServiceHandler;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/wink/edit/manager/WinkPhotoListServiceHandler;", "serviceHandler", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkOnlineAssetMediaRepository {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkOnlineAssetMediaRepository f324625a = new WinkOnlineAssetMediaRepository();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<a>> listenerMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> exportTasks = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy serviceHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/WinkOnlineAssetMediaRepository$a;", "", "", "progress", "", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void onProgressUpdate(int progress);
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkPhotoListServiceHandler>() { // from class: com.tencent.mobileqq.wink.picker.core.repository.WinkOnlineAssetMediaRepository$serviceHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkPhotoListServiceHandler invoke() {
                BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkPhotoListServiceHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.edit.manager.WinkPhotoListServiceHandler");
                return (WinkPhotoListServiceHandler) businessHandler;
            }
        });
        serviceHandler = lazy;
    }

    WinkOnlineAssetMediaRepository() {
    }

    private final LocalMediaInfo d(String path) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) path, (CharSequence) ".mp4", false, 2, (Object) null);
        if (contains$default) {
            LocalMediaInfo d16 = ba3.a.d(path);
            Intrinsics.checkNotNullExpressionValue(d16, "{\n            LocalMedia\u2026sForVideo(path)\n        }");
            return d16;
        }
        LocalMediaInfo c16 = ba3.a.c(path);
        Intrinsics.checkNotNullExpressionValue(c16, "{\n            LocalMedia\u2026fosForPic(path)\n        }");
        return c16;
    }

    private final Object e(MetaMaterial metaMaterial, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (!WinkEditorResourceManager.a1().o2(metaMaterial)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            WinkEditorResourceManager.a1().h0(metaMaterial, new b(metaMaterial, safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return Boxing.boxBoolean(true);
    }

    private final Object f(String str, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (str != null) {
            String str2 = u53.b.f438371b + File.separator + com.tencent.mobileqq.wink.b.a().getAccount() + "_template_user_avatar";
            w53.b.a("WinkOnlineAssetMediaRepository", "downloadQQLogo path is " + str2);
            com.tencent.mobileqq.wink.downloader.b.f318210a.b(str, str2, new c(safeContinuation, str2));
        } else {
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final String h(MetaMaterial material) {
        String str = u53.a.f438367h;
        String str2 = File.separator;
        String str3 = str + str2 + material.f30533id + str2 + material.packageMd5;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str3 + str2 + material.packageMd5 + "_online_asset_output.mp4";
    }

    private final WinkPhotoListServiceHandler i() {
        return (WinkPhotoListServiceHandler) serviceHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x010c, code lost:
    
        if (r1 == true) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.util.HashMap, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(CircleTemplateInfo circleTemplateInfo, Continuation<? super HashMap<String, String>> continuation) {
        WinkOnlineAssetMediaRepository$handleTemplateUserInfo$1 winkOnlineAssetMediaRepository$handleTemplateUserInfo$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        String str;
        boolean z17;
        if (continuation instanceof WinkOnlineAssetMediaRepository$handleTemplateUserInfo$1) {
            winkOnlineAssetMediaRepository$handleTemplateUserInfo$1 = (WinkOnlineAssetMediaRepository$handleTemplateUserInfo$1) continuation;
            int i16 = winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.label;
                z16 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef2 = (Ref.ObjectRef) winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    if (circleTemplateInfo != null) {
                        ?? hashMap = new HashMap();
                        objectRef.element = hashMap;
                        Intrinsics.checkNotNull(hashMap);
                        Map map = (Map) hashMap;
                        String str2 = circleTemplateInfo.NickWord;
                        String str3 = "";
                        if (str2 == null) {
                            str2 = "";
                        }
                        map.put("nickName", str2);
                        T t16 = objectRef.element;
                        Intrinsics.checkNotNull(t16);
                        Map map2 = (Map) t16;
                        String str4 = circleTemplateInfo.TimeMapWord;
                        if (str4 == null) {
                            str4 = "";
                        }
                        map2.put("settlementTimeLabel", str4);
                        T t17 = objectRef.element;
                        Intrinsics.checkNotNull(t17);
                        Map map3 = (Map) t17;
                        String str5 = circleTemplateInfo.GenderMapWord;
                        if (str5 == null) {
                            str5 = "";
                        }
                        map3.put("gender", str5);
                        T t18 = objectRef.element;
                        Intrinsics.checkNotNull(t18);
                        Map map4 = (Map) t18;
                        String str6 = circleTemplateInfo.LocationMapWord;
                        if (str6 == null) {
                            str6 = "";
                        }
                        map4.put("locationLabel", str6);
                        T t19 = objectRef.element;
                        Intrinsics.checkNotNull(t19);
                        Map map5 = (Map) t19;
                        String str7 = circleTemplateInfo.DescMapWord;
                        if (str7 == null) {
                            str7 = "";
                        }
                        map5.put("describeLabel", str7);
                        T t26 = objectRef.element;
                        Intrinsics.checkNotNull(t26);
                        Map map6 = (Map) t26;
                        String str8 = circleTemplateInfo.MonthLabelWord;
                        if (str8 == null) {
                            str8 = "";
                        }
                        map6.put("monthLabel", str8);
                        T t27 = objectRef.element;
                        Intrinsics.checkNotNull(t27);
                        Map map7 = (Map) t27;
                        String str9 = circleTemplateInfo.DayLabelWord;
                        if (str9 == null) {
                            str9 = "";
                        }
                        map7.put("dayLabel", str9);
                        T t28 = objectRef.element;
                        Intrinsics.checkNotNull(t28);
                        Map map8 = (Map) t28;
                        String str10 = circleTemplateInfo.AgeMapWord;
                        if (str10 == null) {
                            str10 = "";
                        }
                        map8.put("ageLabel", str10);
                        T t29 = objectRef.element;
                        Intrinsics.checkNotNull(t29);
                        Map map9 = (Map) t29;
                        String str11 = circleTemplateInfo.StarMapWord;
                        if (str11 != null) {
                            str3 = str11;
                        }
                        map9.put("constellationLabel", str3);
                        WinkOnlineAssetMediaRepository winkOnlineAssetMediaRepository = f324625a;
                        String str12 = circleTemplateInfo.QqLogo;
                        winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.L$0 = objectRef;
                        winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.label = 1;
                        Object f16 = winkOnlineAssetMediaRepository.f(str12, winkOnlineAssetMediaRepository$handleTemplateUserInfo$1);
                        if (f16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = f16;
                        objectRef2 = objectRef;
                    }
                    return objectRef.element;
                }
                str = (String) obj;
                if (str != null) {
                    if (str.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                z16 = false;
                if (!z16) {
                    T t36 = objectRef2.element;
                    Intrinsics.checkNotNull(t36);
                    ((Map) t36).put("QQLogo", str);
                    w53.b.a("WinkOnlineAssetMediaRepository", "logoPath:" + str);
                    objectRef = objectRef2;
                    return objectRef.element;
                }
                return null;
            }
        }
        winkOnlineAssetMediaRepository$handleTemplateUserInfo$1 = new WinkOnlineAssetMediaRepository$handleTemplateUserInfo$1(this, continuation);
        Object obj2 = winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkOnlineAssetMediaRepository$handleTemplateUserInfo$1.label;
        z16 = true;
        if (i3 == 0) {
        }
        str = (String) obj2;
        if (str != null) {
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        f324625a.i().requestTemplateUserInfo();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01a4 A[PHI: r0
  0x01a4: PHI (r0v27 java.lang.Object) = (r0v22 java.lang.Object), (r0v1 java.lang.Object) binds: [B:44:0x01a1, B:11:0x0031] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(@NotNull MetaMaterial metaMaterial, @NotNull Continuation<? super String> continuation) {
        WinkOnlineAssetMediaRepository$exportLightSdkVideo$1 winkOnlineAssetMediaRepository$exportLightSdkVideo$1;
        Object coroutine_suspended;
        int i3;
        MetaMaterial metaMaterial2;
        WinkOnlineAssetMediaRepository winkOnlineAssetMediaRepository;
        HashMap hashMap;
        boolean z16;
        final MetaMaterial metaMaterial3;
        HashMap hashMap2;
        Continuation intercepted;
        String str;
        String str2;
        String str3;
        boolean z17;
        Object coroutine_suspended2;
        List<? extends LocalMediaInfo> mutableListOf;
        if (continuation instanceof WinkOnlineAssetMediaRepository$exportLightSdkVideo$1) {
            winkOnlineAssetMediaRepository$exportLightSdkVideo$1 = (WinkOnlineAssetMediaRepository$exportLightSdkVideo$1) continuation;
            int i16 = winkOnlineAssetMediaRepository$exportLightSdkVideo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkOnlineAssetMediaRepository$exportLightSdkVideo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkOnlineAssetMediaRepository$exportLightSdkVideo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkOnlineAssetMediaRepository$exportLightSdkVideo$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        hashMap2 = (HashMap) winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$1;
                        MetaMaterial metaMaterial4 = (MetaMaterial) winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        metaMaterial3 = metaMaterial4;
                        String str4 = "";
                        if (((Boolean) obj).booleanValue()) {
                            return "";
                        }
                        winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$0 = metaMaterial3;
                        winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$1 = hashMap2;
                        winkOnlineAssetMediaRepository$exportLightSdkVideo$1.label = 3;
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkOnlineAssetMediaRepository$exportLightSdkVideo$1);
                        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry entry : hashMap2.entrySet()) {
                            jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                        }
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                        w53.b.a("WinkOnlineAssetMediaRepository", jSONObject2);
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put(LightConstants.EventKey.EVENT_SCRIPT_PARAMS, jSONObject2);
                        String uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                        exportTasks.add(uuid);
                        try {
                            p pVar = p.f325325a;
                            LocalMediaInfo[] localMediaInfoArr = new LocalMediaInfo[1];
                            WinkOnlineAssetMediaRepository winkOnlineAssetMediaRepository2 = f324625a;
                            String str5 = (String) hashMap2.remove("QQLogo");
                            if (str5 != null) {
                                str4 = str5;
                            }
                            Intrinsics.checkNotNullExpressionValue(str4, "userData.remove(\"QQLogo\") ?: \"\"");
                            localMediaInfoArr[0] = winkOnlineAssetMediaRepository2.d(str4);
                            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(localMediaInfoArr);
                            str = uuid;
                            str2 = "WinkOnlineAssetMediaRepository";
                            try {
                                str3 = pVar.b(null, uuid, metaMaterial3, mutableListOf, winkOnlineAssetMediaRepository2.h(metaMaterial3), 720, 1080, hashMap3, new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.repository.WinkOnlineAssetMediaRepository$exportLightSdkVideo$2$outputPath$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                                        invoke(f16.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f16) {
                                        ConcurrentHashMap concurrentHashMap;
                                        concurrentHashMap = WinkOnlineAssetMediaRepository.listenerMap;
                                        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) concurrentHashMap.get(MetaMaterial.this.packageMd5);
                                        if (copyOnWriteArrayList != null) {
                                            Iterator it = copyOnWriteArrayList.iterator();
                                            while (it.hasNext()) {
                                                ((WinkOnlineAssetMediaRepository.a) it.next()).onProgressUpdate((((int) (100 * f16)) / 2) + 50);
                                            }
                                        }
                                    }
                                });
                            } catch (Exception e16) {
                                e = e16;
                                w53.b.d(str2, "exportVideoByMaterial fail", e);
                                p.f325325a.a(str);
                                str3 = null;
                                exportTasks.remove(str);
                                if (str3 == null) {
                                }
                                z17 = true;
                                if (!z17) {
                                }
                                w53.b.a(str2, "outputPath:" + str3);
                                obj = safeContinuation.getOrThrow();
                                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (obj == coroutine_suspended2) {
                                }
                                if (obj != coroutine_suspended) {
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                            str = uuid;
                            str2 = "WinkOnlineAssetMediaRepository";
                        }
                        exportTasks.remove(str);
                        if (str3 == null && str3.length() != 0) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (!z17) {
                            safeContinuation.resumeWith(Result.m476constructorimpl(null));
                        } else {
                            safeContinuation.resumeWith(Result.m476constructorimpl(str3));
                        }
                        w53.b.a(str2, "outputPath:" + str3);
                        obj = safeContinuation.getOrThrow();
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(winkOnlineAssetMediaRepository$exportLightSdkVideo$1);
                        }
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj;
                    }
                    metaMaterial2 = (MetaMaterial) winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$1;
                    winkOnlineAssetMediaRepository = (WinkOnlineAssetMediaRepository) winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    CircleTemplateInfo j3 = j();
                    winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$0 = this;
                    metaMaterial2 = metaMaterial;
                    winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$1 = metaMaterial2;
                    winkOnlineAssetMediaRepository$exportLightSdkVideo$1.label = 1;
                    obj = k(j3, winkOnlineAssetMediaRepository$exportLightSdkVideo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkOnlineAssetMediaRepository = this;
                }
                hashMap = (HashMap) obj;
                if (hashMap == null && !hashMap.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return null;
                }
                winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$0 = metaMaterial2;
                winkOnlineAssetMediaRepository$exportLightSdkVideo$1.L$1 = hashMap;
                winkOnlineAssetMediaRepository$exportLightSdkVideo$1.label = 2;
                Object e18 = winkOnlineAssetMediaRepository.e(metaMaterial2, winkOnlineAssetMediaRepository$exportLightSdkVideo$1);
                if (e18 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                metaMaterial3 = metaMaterial2;
                hashMap2 = hashMap;
                obj = e18;
                String str42 = "";
                if (((Boolean) obj).booleanValue()) {
                }
            }
        }
        winkOnlineAssetMediaRepository$exportLightSdkVideo$1 = new WinkOnlineAssetMediaRepository$exportLightSdkVideo$1(this, continuation);
        Object obj2 = winkOnlineAssetMediaRepository$exportLightSdkVideo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkOnlineAssetMediaRepository$exportLightSdkVideo$1.label;
        if (i3 == 0) {
        }
        hashMap = (HashMap) obj2;
        if (hashMap == null) {
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Nullable
    public final CircleTemplateInfo j() {
        CircleTemplateInfo value = WinkEditorResourceManager.a1().M1().getValue();
        if (value == null) {
            return l(true);
        }
        return value;
    }

    @Nullable
    public final CircleTemplateInfo l(boolean isBlockingUI) {
        if (isBlockingUI) {
            i().D3();
            return i().C3();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.repository.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkOnlineAssetMediaRepository.m();
            }
        }, 128, null, false);
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/core/repository/WinkOnlineAssetMediaRepository$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f324629a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f324630b;

        /* JADX WARN: Multi-variable type inference failed */
        b(MetaMaterial metaMaterial, Continuation<? super Boolean> continuation) {
            this.f324629a = metaMaterial;
            this.f324630b = continuation;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                WinkEditorResourceManager.a1().i0(this.f324629a);
                Continuation<Boolean> continuation = this.f324630b;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            Continuation<Boolean> continuation2 = this.f324630b;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/core/repository/WinkOnlineAssetMediaRepository$c", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f324631a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f324632b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super String> continuation, String str) {
            this.f324631a = continuation;
            this.f324632b = str;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                Continuation<String> continuation = this.f324631a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(this.f324632b));
                return;
            }
            this.f324631a.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}
