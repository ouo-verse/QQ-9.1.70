package com.tencent.mobileqq.wink.ai.imagetext;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.ai.imagetext.model.WinkAIImageTextRequest;
import com.tencent.mobileqq.wink.ai.imagetext.model.WinkAiImageTextConfig;
import com.tencent.mobileqq.wink.api.e;
import com.tencent.mobileqq.wink.utils.al;
import com.tencent.mobileqq.wink.utils.an;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QZoneAutoTexting$ImageTextingRsp;
import qshadow.QZoneAutoTexting$QueryTextingResultRsp;
import qshadow.QZoneAutoTexting$TextInfo;
import tl.h;
import v93.WinkResponseData;
import w53.b;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J[\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0018\u001a\u00020\u0013R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/ai/imagetext/WinkAIImageTextAPIHelper;", "", "", "imagePath", "", "Lqshadow/QZoneAutoTexting$TextInfo;", "i", "originText", "", "isStream", "useImageCache", "Lcom/tencent/mobileqq/wink/api/e;", "callback", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, h.F, "(Ljava/lang/String;Ljava/lang/String;ZZLcom/tencent/mobileqq/wink/api/e;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "textInfos", "", "j", "useCache", "k", "g", "f", "b", "Ljava/util/Map;", "IMAGE_TEXT_CACHE", "c", "IMAGE_URL_CACHE", "Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAiImageTextConfig;", "d", "Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAiImageTextConfig;", "imageTextConfig", "e", "Z", "hasFetchedImageTextConfig", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "currentImageTextingJob", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIImageTextAPIHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkAIImageTextAPIHelper f317663a = new WinkAIImageTextAPIHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, List<QZoneAutoTexting$TextInfo>> IMAGE_TEXT_CACHE = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> IMAGE_URL_CACHE = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WinkAiImageTextConfig imageTextConfig = WinkAiImageTextConfig.INSTANCE.a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean hasFetchedImageTextConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Job currentImageTextingJob;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f317669d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f317670e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineExceptionHandler.Companion companion, Ref.ObjectRef objectRef, e eVar) {
            super(companion);
            this.f317669d = objectRef;
            this.f317670e = eVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            List<QZoneAutoTexting$TextInfo> emptyList;
            ((Map) this.f317669d.element).put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED);
            com.tencent.mobileqq.wink.ai.imagetext.a.f317671a.b((Map) this.f317669d.element);
            b.d("WinkAIImageTextAPIHelper", "requestImageTexting error " + this.f317669d.element, exception);
            e eVar = this.f317670e;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            eVar.b(false, -1L, null, emptyList);
        }
    }

    WinkAIImageTextAPIHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0496 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /* JADX WARN: Type inference failed for: r8v45, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v47, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0497 -> B:13:0x04a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(String str, String str2, boolean z16, boolean z17, e eVar, Map<String, String> map, Continuation<? super List<QZoneAutoTexting$TextInfo>> continuation) {
        WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1 winkAIImageTextAPIHelper$getImageTextInfosFromApi$1;
        Object coroutine_suspended;
        int i3;
        List emptyList;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        long j3;
        e eVar2;
        Map<String, String> map2;
        LinkedHashMap linkedHashMap;
        long j16;
        boolean z18;
        String str8;
        WinkAIImageTextAPIHelper winkAIImageTextAPIHelper;
        String str9;
        long j17;
        List list;
        LinkedHashMap linkedHashMap2;
        Object obj;
        String str10;
        String str11;
        String str12;
        Object k3;
        long j18;
        WinkResponseData winkResponseData;
        long j19;
        long retCode;
        String str13;
        String str14;
        String str15;
        long j26;
        ArrayList arrayList;
        Ref.LongRef longRef;
        long j27;
        int i16;
        int i17;
        PBRepeatMessageField<QZoneAutoTexting$TextInfo> pBRepeatMessageField;
        ArrayList arrayList2;
        Object firstOrNull;
        String str16;
        String str17;
        int i18;
        ArrayList arrayList3;
        long j28;
        Ref.LongRef longRef2;
        int i19;
        WinkAIImageTextAPIHelper winkAIImageTextAPIHelper2;
        String str18;
        String str19;
        Object k16;
        Object obj2;
        String str20;
        PBRepeatMessageField<QZoneAutoTexting$TextInfo> pBRepeatMessageField2;
        if (continuation instanceof WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1) {
            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1 = (WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1) continuation;
            int i26 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label = i26 - Integer.MIN_VALUE;
                Object obj3 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label;
                String str21 = "textInfo";
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    b.f("WinkAIImageTextAPIHelper", "getImageTextInfosFromApi begin");
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    String str22 = z17 ? IMAGE_URL_CACHE.get(str) : null;
                    if (TextUtils.isEmpty(str22)) {
                        String d16 = an.f326680a.d(str, imageTextConfig.getMaxLongSide(), 90, true);
                        b.f("WinkAIImageTextAPIHelper", "step1 compressedImagePath:" + d16);
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        map.put("compressTime", String.valueOf(elapsedRealtime2 - elapsedRealtime));
                        if (!TextUtils.isEmpty(d16) && !Intrinsics.areEqual(d16, str)) {
                            al alVar = al.f326675a;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0 = this;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1 = str;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2 = str2;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3 = eVar;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4 = map;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5 = linkedHashMap3;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6 = emptyList;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.Z$0 = z16;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0 = elapsedRealtime;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$1 = elapsedRealtime2;
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label = 1;
                            j17 = elapsedRealtime2;
                            str4 = "textInfoMap.values";
                            str3 = "textInfo.id.get()";
                            str9 = "WinkAIImageTextAPIHelper";
                            list = emptyList;
                            Object b16 = al.b(alVar, d16, false, winkAIImageTextAPIHelper$getImageTextInfosFromApi$1, 2, null);
                            if (b16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z18 = z16;
                            linkedHashMap2 = linkedHashMap3;
                            obj = b16;
                            j3 = elapsedRealtime;
                            winkAIImageTextAPIHelper = this;
                            str10 = str2;
                            eVar2 = eVar;
                            map2 = map;
                            str11 = str;
                        } else {
                            str9 = "WinkAIImageTextAPIHelper";
                            b.c(str9, "compress image failed compressedImagePath:" + d16);
                            map.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "1000");
                            j3 = elapsedRealtime;
                            emptyList = emptyList;
                            map2 = map;
                            b.f(str9, "getImageTextInfosFromApi end");
                            map2.put("totalTime", String.valueOf(SystemClock.elapsedRealtime() - j3));
                            return emptyList;
                        }
                    } else {
                        str3 = "textInfo.id.get()";
                        str4 = "textInfoMap.values";
                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                        b.f("WinkAIImageTextAPIHelper", "step2 useImageCache uploadImageUrl:" + str22);
                        str5 = str2;
                        str6 = "WinkAIImageTextAPIHelper";
                        str7 = HiAnalyticsConstant.HaKey.BI_KEY_RESULT;
                        j3 = elapsedRealtime;
                        eVar2 = eVar;
                        map2 = map;
                        linkedHashMap = linkedHashMap3;
                        j16 = elapsedRealtime3;
                        z18 = z16;
                        str8 = str22;
                        winkAIImageTextAPIHelper = this;
                        w93.e eVar3 = w93.e.f445096a;
                        str12 = "textInfo";
                        Intrinsics.checkNotNull(str8);
                        WinkAIImageTextRequest winkAIImageTextRequest = new WinkAIImageTextRequest(str8, str5, z18);
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0 = winkAIImageTextAPIHelper;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1 = eVar2;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2 = map2;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3 = linkedHashMap;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4 = emptyList;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5 = str8;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6 = null;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.Z$0 = z18;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0 = j3;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$1 = j16;
                        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label = 2;
                        k3 = eVar3.k(winkAIImageTextRequest, winkAIImageTextAPIHelper$getImageTextInfosFromApi$1);
                        if (k3 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j18 = j16;
                        obj3 = k3;
                        winkResponseData = (WinkResponseData) obj3;
                        j19 = j3;
                        retCode = winkResponseData.getRetCode();
                        if (!winkResponseData.getIsSuccess()) {
                        }
                        str9 = str6;
                        b.c(str9, "requestImageTextingAPi failed, retCode:" + retCode + " errorMsg:" + winkResponseData.getMsg());
                        map2.put(str7, String.valueOf(retCode));
                        j3 = j19;
                        b.f(str9, "getImageTextInfosFromApi end");
                        map2.put("totalTime", String.valueOf(SystemClock.elapsedRealtime() - j3));
                        return emptyList;
                    }
                } else if (i3 == 1) {
                    long j29 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$1;
                    long j36 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0;
                    z18 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.Z$0;
                    List list2 = (List) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6;
                    linkedHashMap2 = (LinkedHashMap) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5;
                    map2 = (Map) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4;
                    eVar2 = (e) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3;
                    String str23 = (String) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2;
                    str11 = (String) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1;
                    WinkAIImageTextAPIHelper winkAIImageTextAPIHelper3 = (WinkAIImageTextAPIHelper) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    str3 = "textInfo.id.get()";
                    list = list2;
                    str9 = "WinkAIImageTextAPIHelper";
                    str4 = "textInfoMap.values";
                    j17 = j29;
                    j3 = j36;
                    winkAIImageTextAPIHelper = winkAIImageTextAPIHelper3;
                    obj = obj3;
                    str10 = str23;
                } else {
                    if (i3 == 2) {
                        long j37 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$1;
                        long j38 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0;
                        z18 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.Z$0;
                        String str24 = (String) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5;
                        emptyList = (List) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4;
                        LinkedHashMap linkedHashMap4 = (LinkedHashMap) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3;
                        Map<String, String> map3 = (Map) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2;
                        e eVar4 = (e) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1;
                        WinkAIImageTextAPIHelper winkAIImageTextAPIHelper4 = (WinkAIImageTextAPIHelper) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        str3 = "textInfo.id.get()";
                        str12 = "textInfo";
                        str7 = HiAnalyticsConstant.HaKey.BI_KEY_RESULT;
                        linkedHashMap = linkedHashMap4;
                        map2 = map3;
                        str4 = "textInfoMap.values";
                        eVar2 = eVar4;
                        str6 = "WinkAIImageTextAPIHelper";
                        winkAIImageTextAPIHelper = winkAIImageTextAPIHelper4;
                        j18 = j37;
                        str8 = str24;
                        j3 = j38;
                        winkResponseData = (WinkResponseData) obj3;
                        j19 = j3;
                        retCode = winkResponseData.getRetCode();
                        if (!winkResponseData.getIsSuccess() && retCode == 0) {
                            QZoneAutoTexting$ImageTextingRsp qZoneAutoTexting$ImageTextingRsp = (QZoneAutoTexting$ImageTextingRsp) winkResponseData.b();
                            List<QZoneAutoTexting$TextInfo> list3 = (qZoneAutoTexting$ImageTextingRsp == null || (pBRepeatMessageField = qZoneAutoTexting$ImageTextingRsp.textInfos) == null) ? null : pBRepeatMessageField.get();
                            if (list3 != null) {
                                for (QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo : list3) {
                                    String str25 = qZoneAutoTexting$TextInfo.f429485id.get();
                                    Intrinsics.checkNotNullExpressionValue(str25, str3);
                                    Intrinsics.checkNotNullExpressionValue(qZoneAutoTexting$TextInfo, str12);
                                    linkedHashMap.put(str25, qZoneAutoTexting$TextInfo);
                                }
                            }
                            str21 = str12;
                            str13 = str3;
                            str14 = str6;
                            b.f(str14, "step3 sso_auto_texting imageTextApiResult:" + (list3 != null ? Boxing.boxInt(list3.size()) : null));
                            map2.put("firstTokenTime", String.valueOf(SystemClock.elapsedRealtime() - j18));
                            map2.put("textCount", String.valueOf(linkedHashMap.size()));
                            if (z18) {
                                Collection<QZoneAutoTexting$TextInfo> values = linkedHashMap.values();
                                str15 = str4;
                                Intrinsics.checkNotNullExpressionValue(values, str15);
                                winkAIImageTextAPIHelper.j(values, eVar2);
                                arrayList = new ArrayList();
                                longRef = new Ref.LongRef();
                                Collection<QZoneAutoTexting$TextInfo> values2 = linkedHashMap.values();
                                Intrinsics.checkNotNullExpressionValue(values2, str15);
                                for (QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo2 : values2) {
                                    WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1 winkAIImageTextAPIHelper$getImageTextInfosFromApi$12 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1;
                                    if (qZoneAutoTexting$TextInfo2.status.get() == 1) {
                                        String str26 = qZoneAutoTexting$TextInfo2.f429485id.get();
                                        Intrinsics.checkNotNullExpressionValue(str26, str13);
                                        arrayList.add(str26);
                                        longRef.element = qZoneAutoTexting$TextInfo2.delay_time.get();
                                    }
                                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$12;
                                }
                                j27 = j19;
                                i16 = 0;
                                i17 = 0;
                                if (!arrayList.isEmpty()) {
                                }
                                Collection values3 = linkedHashMap.values();
                                Intrinsics.checkNotNullExpressionValue(values3, str15);
                                arrayList2 = new ArrayList();
                                while (r0.hasNext()) {
                                }
                                if (!arrayList2.isEmpty()) {
                                }
                                str9 = str14;
                                j3 = j26;
                                emptyList = arrayList2;
                                b.f(str9, "getImageTextInfosFromApi end");
                                map2.put("totalTime", String.valueOf(SystemClock.elapsedRealtime() - j3));
                                return emptyList;
                            }
                            str15 = str4;
                            j26 = j19;
                            Collection values32 = linkedHashMap.values();
                            Intrinsics.checkNotNullExpressionValue(values32, str15);
                            arrayList2 = new ArrayList();
                            while (r0.hasNext()) {
                            }
                            if (!arrayList2.isEmpty()) {
                            }
                            str9 = str14;
                            j3 = j26;
                            emptyList = arrayList2;
                            b.f(str9, "getImageTextInfosFromApi end");
                            map2.put("totalTime", String.valueOf(SystemClock.elapsedRealtime() - j3));
                            return emptyList;
                        }
                        str9 = str6;
                        b.c(str9, "requestImageTextingAPi failed, retCode:" + retCode + " errorMsg:" + winkResponseData.getMsg());
                        map2.put(str7, String.valueOf(retCode));
                        j3 = j19;
                        b.f(str9, "getImageTextInfosFromApi end");
                        map2.put("totalTime", String.valueOf(SystemClock.elapsedRealtime() - j3));
                        return emptyList;
                    }
                    if (i3 != 3) {
                        if (i3 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i27 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$1;
                        int i28 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$0;
                        long j39 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0;
                        Ref.LongRef longRef3 = (Ref.LongRef) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6;
                        ?? r85 = (List) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5;
                        String str27 = (String) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4;
                        LinkedHashMap linkedHashMap5 = (LinkedHashMap) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3;
                        map2 = (Map) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2;
                        e eVar5 = (e) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1;
                        WinkAIImageTextAPIHelper winkAIImageTextAPIHelper5 = (WinkAIImageTextAPIHelper) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        str16 = "textInfo.id.get()";
                        str19 = "textInfo";
                        str7 = HiAnalyticsConstant.HaKey.BI_KEY_RESULT;
                        linkedHashMap = linkedHashMap5;
                        str17 = "textInfoMap.values";
                        i17 = i27;
                        eVar2 = eVar5;
                        winkAIImageTextAPIHelper = winkAIImageTextAPIHelper5;
                        Object obj4 = coroutine_suspended;
                        i16 = i28;
                        longRef = longRef3;
                        str8 = str27;
                        long j46 = j39;
                        k16 = obj3;
                        str14 = "WinkAIImageTextAPIHelper";
                        ArrayList arrayList4 = r85;
                        WinkResponseData winkResponseData2 = (WinkResponseData) k16;
                        if (!winkResponseData2.getIsSuccess()) {
                            arrayList4.clear();
                            QZoneAutoTexting$QueryTextingResultRsp qZoneAutoTexting$QueryTextingResultRsp = (QZoneAutoTexting$QueryTextingResultRsp) winkResponseData2.b();
                            List<QZoneAutoTexting$TextInfo> list4 = (qZoneAutoTexting$QueryTextingResultRsp == null || (pBRepeatMessageField2 = qZoneAutoTexting$QueryTextingResultRsp.textInfos) == null) ? null : pBRepeatMessageField2.get();
                            Integer boxInt = list4 != null ? Boxing.boxInt(list4.size()) : null;
                            StringBuilder sb5 = new StringBuilder();
                            obj2 = obj4;
                            sb5.append("step4 sso_query_texting_result end queryImageTextApiTextInfos:");
                            sb5.append(boxInt);
                            b.f(str14, sb5.toString());
                            if (list4 != null) {
                                Iterator it = list4.iterator();
                                while (it.hasNext()) {
                                    QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo3 = (QZoneAutoTexting$TextInfo) it.next();
                                    String str28 = qZoneAutoTexting$TextInfo3.f429485id.get();
                                    String str29 = str16;
                                    Intrinsics.checkNotNullExpressionValue(str28, str29);
                                    Iterator it5 = it;
                                    Intrinsics.checkNotNullExpressionValue(qZoneAutoTexting$TextInfo3, str19);
                                    linkedHashMap.put(str28, qZoneAutoTexting$TextInfo3);
                                    if (qZoneAutoTexting$TextInfo3.status.get() == 1) {
                                        String str30 = qZoneAutoTexting$TextInfo3.f429485id.get();
                                        Intrinsics.checkNotNullExpressionValue(str30, str29);
                                        arrayList4.add(str30);
                                        longRef.element = qZoneAutoTexting$TextInfo3.delay_time.get();
                                    }
                                    it = it5;
                                    str16 = str29;
                                }
                            }
                            str20 = str16;
                            Collection<QZoneAutoTexting$TextInfo> values4 = linkedHashMap.values();
                            str15 = str17;
                            Intrinsics.checkNotNullExpressionValue(values4, str15);
                            winkAIImageTextAPIHelper.j(values4, eVar2);
                        } else {
                            obj2 = obj4;
                            str15 = str17;
                            str20 = str16;
                            i16++;
                            longRef.element = 0L;
                            b.f(str14, "step4 sso_query_texting_result end networkError, retryCount:" + i16 + " }");
                            winkAIImageTextAPIHelper$getImageTextInfosFromApi$1 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1;
                            winkAIImageTextAPIHelper = winkAIImageTextAPIHelper;
                        }
                        arrayList = arrayList4;
                        j27 = j46;
                        str13 = str20;
                        str21 = str19;
                        coroutine_suspended = obj2;
                        if (!arrayList.isEmpty()) {
                            str17 = str15;
                            if (i16 < 3) {
                                str16 = str13;
                                long j47 = j27;
                                long max = Math.max(100L, longRef.element);
                                longRef.element = max;
                                i18 = i17 + 1;
                                b.f(str14, "step4 sso_query_texting_result begin requestTextIds:" + arrayList + ", delay " + max + " ms, retryCount:" + i16 + ", loopCount " + i18);
                                long j48 = longRef.element;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0 = winkAIImageTextAPIHelper;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1 = eVar2;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2 = map2;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3 = linkedHashMap;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4 = str8;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5 = arrayList;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6 = longRef;
                                ArrayList arrayList5 = arrayList;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0 = j47;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$0 = i16;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$1 = i18;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label = 3;
                                coroutine_suspended = coroutine_suspended;
                                if (DelayKt.delay(j48, winkAIImageTextAPIHelper$getImageTextInfosFromApi$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                arrayList3 = arrayList5;
                                WinkAIImageTextAPIHelper winkAIImageTextAPIHelper6 = winkAIImageTextAPIHelper;
                                longRef2 = longRef;
                                i19 = i16;
                                winkAIImageTextAPIHelper2 = winkAIImageTextAPIHelper6;
                                str18 = str8;
                                j28 = j47;
                                w93.e eVar6 = w93.e.f445096a;
                                str19 = str21;
                                WinkAIQueryImageTextResultRequest winkAIQueryImageTextResultRequest = new WinkAIQueryImageTextResultRequest(arrayList3);
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0 = winkAIImageTextAPIHelper2;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1 = eVar2;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2 = map2;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3 = linkedHashMap;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4 = str18;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5 = arrayList3;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6 = longRef2;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0 = j28;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$0 = i19;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$1 = i18;
                                String str31 = str18;
                                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label = 4;
                                k16 = eVar6.k(winkAIQueryImageTextResultRequest, winkAIImageTextAPIHelper$getImageTextInfosFromApi$1);
                                if (k16 != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Ref.LongRef longRef4 = longRef2;
                                winkAIImageTextAPIHelper = winkAIImageTextAPIHelper2;
                                obj4 = coroutine_suspended;
                                long j49 = j28;
                                i16 = i19;
                                longRef = longRef4;
                                str8 = str31;
                                i17 = i18;
                                j46 = j49;
                                arrayList4 = arrayList3;
                                WinkResponseData winkResponseData22 = (WinkResponseData) k16;
                                if (!winkResponseData22.getIsSuccess()) {
                                }
                                arrayList = arrayList4;
                                j27 = j46;
                                str13 = str20;
                                str21 = str19;
                                coroutine_suspended = obj2;
                                if (!arrayList.isEmpty()) {
                                    j26 = j27;
                                }
                            } else {
                                j26 = j27;
                                str15 = str17;
                            }
                        }
                        Collection values322 = linkedHashMap.values();
                        Intrinsics.checkNotNullExpressionValue(values322, str15);
                        arrayList2 = new ArrayList();
                        for (Object obj5 : values322) {
                            if (((QZoneAutoTexting$TextInfo) obj5).status.get() == 2) {
                                arrayList2.add(obj5);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            IMAGE_TEXT_CACHE.put(str8, arrayList2);
                            map2.put(str7, "0");
                        } else {
                            String str32 = str7;
                            Collection values5 = linkedHashMap.values();
                            Intrinsics.checkNotNullExpressionValue(values5, str15);
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(values5);
                            QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo4 = (QZoneAutoTexting$TextInfo) firstOrNull;
                            if (qZoneAutoTexting$TextInfo4 != null) {
                                int i29 = qZoneAutoTexting$TextInfo4.status.get();
                                if (i29 == 0) {
                                    map2.put(str32, "1002");
                                } else if (i29 != 3) {
                                    map2.put(str32, QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED);
                                } else {
                                    map2.put(str32, "1003");
                                }
                            }
                        }
                        str9 = str14;
                        j3 = j26;
                        emptyList = arrayList2;
                        b.f(str9, "getImageTextInfosFromApi end");
                        map2.put("totalTime", String.valueOf(SystemClock.elapsedRealtime() - j3));
                        return emptyList;
                    }
                    int i36 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$1;
                    i19 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$0;
                    long j56 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0;
                    Ref.LongRef longRef5 = (Ref.LongRef) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6;
                    ?? r86 = (List) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5;
                    String str33 = (String) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4;
                    LinkedHashMap linkedHashMap6 = (LinkedHashMap) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3;
                    Map<String, String> map4 = (Map) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2;
                    e eVar7 = (e) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1;
                    winkAIImageTextAPIHelper2 = (WinkAIImageTextAPIHelper) winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    str16 = "textInfo.id.get()";
                    str14 = "WinkAIImageTextAPIHelper";
                    str18 = str33;
                    str7 = HiAnalyticsConstant.HaKey.BI_KEY_RESULT;
                    linkedHashMap = linkedHashMap6;
                    map2 = map4;
                    str17 = "textInfoMap.values";
                    i18 = i36;
                    eVar2 = eVar7;
                    longRef2 = longRef5;
                    j28 = j56;
                    arrayList3 = r86;
                    w93.e eVar62 = w93.e.f445096a;
                    str19 = str21;
                    WinkAIQueryImageTextResultRequest winkAIQueryImageTextResultRequest2 = new WinkAIQueryImageTextResultRequest(arrayList3);
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0 = winkAIImageTextAPIHelper2;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1 = eVar2;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2 = map2;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3 = linkedHashMap;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4 = str18;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5 = arrayList3;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6 = longRef2;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0 = j28;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$0 = i19;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.I$1 = i18;
                    String str312 = str18;
                    winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label = 4;
                    k16 = eVar62.k(winkAIQueryImageTextResultRequest2, winkAIImageTextAPIHelper$getImageTextInfosFromApi$1);
                    if (k16 != coroutine_suspended) {
                    }
                }
                str8 = (String) obj;
                StringBuilder sb6 = new StringBuilder();
                String str34 = str10;
                sb6.append("step2 uploadImageUrl:");
                sb6.append(str8);
                b.f(str9, sb6.toString());
                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                map2.put(PhotoCategorySinglePicInfo.UPLOAD_TIME, String.valueOf(elapsedRealtime4 - j17));
                if (!TextUtils.isEmpty(str8)) {
                    b.c(str9, "upload image failed uploadImageUrl:" + str8);
                    map2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "1001");
                    emptyList = list;
                    b.f(str9, "getImageTextInfosFromApi end");
                    map2.put("totalTime", String.valueOf(SystemClock.elapsedRealtime() - j3));
                    return emptyList;
                }
                IMAGE_URL_CACHE.put(str11, str8);
                str5 = str34;
                str6 = str9;
                str7 = HiAnalyticsConstant.HaKey.BI_KEY_RESULT;
                j16 = elapsedRealtime4;
                linkedHashMap = linkedHashMap2;
                emptyList = list;
                w93.e eVar32 = w93.e.f445096a;
                str12 = "textInfo";
                Intrinsics.checkNotNull(str8);
                WinkAIImageTextRequest winkAIImageTextRequest2 = new WinkAIImageTextRequest(str8, str5, z18);
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$0 = winkAIImageTextAPIHelper;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$1 = eVar2;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$2 = map2;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$3 = linkedHashMap;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$4 = emptyList;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$5 = str8;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.L$6 = null;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.Z$0 = z18;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$0 = j3;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.J$1 = j16;
                winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label = 2;
                k3 = eVar32.k(winkAIImageTextRequest2, winkAIImageTextAPIHelper$getImageTextInfosFromApi$1);
                if (k3 != coroutine_suspended) {
                }
            }
        }
        winkAIImageTextAPIHelper$getImageTextInfosFromApi$1 = new WinkAIImageTextAPIHelper$getImageTextInfosFromApi$1(this, continuation);
        Object obj32 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkAIImageTextAPIHelper$getImageTextInfosFromApi$1.label;
        String str212 = "textInfo";
        if (i3 != 0) {
        }
        str8 = (String) obj;
        StringBuilder sb62 = new StringBuilder();
        String str342 = str10;
        sb62.append("step2 uploadImageUrl:");
        sb62.append(str8);
        b.f(str9, sb62.toString());
        long elapsedRealtime42 = SystemClock.elapsedRealtime();
        map2.put(PhotoCategorySinglePicInfo.UPLOAD_TIME, String.valueOf(elapsedRealtime42 - j17));
        if (!TextUtils.isEmpty(str8)) {
        }
    }

    private final List<QZoneAutoTexting$TextInfo> i(String imagePath) {
        String str = IMAGE_URL_CACHE.get(imagePath);
        if (str != null) {
            return IMAGE_TEXT_CACHE.get(str);
        }
        return null;
    }

    private final void j(Collection<QZoneAutoTexting$TextInfo> textInfos, e callback) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : textInfos) {
            QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo = (QZoneAutoTexting$TextInfo) obj;
            boolean z16 = true;
            if (qZoneAutoTexting$TextInfo.status.get() != 2 && qZoneAutoTexting$TextInfo.status.get() != 1) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        callback.a(arrayList);
    }

    public final void f() {
        b.f("WinkAIImageTextAPIHelper", "cancel request");
        Job job = currentImageTextingJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
        currentImageTextingJob = null;
    }

    public final void g(@Nullable String imagePath) {
        b.f("WinkAIImageTextAPIHelper", "clear cache " + imagePath);
        if (imagePath != null) {
            Map<String, String> map = IMAGE_URL_CACHE;
            String str = map.get(imagePath);
            if (str != null) {
                map.remove(imagePath);
                IMAGE_TEXT_CACHE.remove(str);
                return;
            }
            return;
        }
        IMAGE_TEXT_CACHE.clear();
    }

    /* JADX WARN: Type inference failed for: r14v3, types: [T, java.util.Map] */
    public final void k(@NotNull String imagePath, @Nullable String originText, boolean useCache, @NotNull e callback) {
        Job launch$default;
        boolean z16;
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        b.f("WinkAIImageTextAPIHelper", "requestImageTexting begin\uff0c imagePath:" + imagePath + ", originText:" + originText + ", useCache:" + useCache);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (useCache) {
            List<QZoneAutoTexting$TextInfo> i3 = i(imagePath);
            List<QZoneAutoTexting$TextInfo> list = i3;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                callback.b(true, 0L, null, i3);
                b.f("WinkAIImageTextAPIHelper", "return from cache");
                return;
            }
        }
        Job job = currentImageTextingJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
        currentImageTextingJob = null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = com.tencent.mobileqq.wink.ai.imagetext.a.f317671a.a();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(WinkCoroutineScopes.f317652a.c())), new a(CoroutineExceptionHandler.INSTANCE, objectRef2, callback), null, new WinkAIImageTextAPIHelper$requestImageTexting$1(objectRef2, objectRef, callback, imagePath, originText, null), 2, null);
        launch$default.start();
        currentImageTextingJob = launch$default;
    }
}
