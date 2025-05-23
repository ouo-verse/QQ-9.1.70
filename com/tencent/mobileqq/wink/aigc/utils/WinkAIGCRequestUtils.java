package com.tencent.mobileqq.wink.aigc.utils;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.aigc.utils.WinkMakeAIImageResponse;
import com.tencent.mobileqq.wink.request.QQWinkAIGCDoActionReq;
import com.tencent.mobileqq.wink.request.QQWinkAIGCGetStatusReq;
import com.tencent.mobileqq.wink.request.QQWinkAIGCRequest;
import com.tencent.mobileqq.wink.request.QQWinkAIGCSafeCheckRequest;
import com.tencent.mobileqq.wink.utils.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.utils.GsonUtils;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;
import qshadow.ShadowAIGCGenerate$Media;
import qshadow.ShadowAIGCSafe$Media;
import qshadow.ShadowAIGCSafe$SafeCheckReply;
import qshadow.ShadowAIGCSafe$SafeCheckRequest;
import qshadow.ShadowAIGCStatus$DoActionReply;
import qshadow.ShadowAIGCStatus$DoActionRequest;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import qshadow.ShadowAIGCStatus$GetStatusRequest;
import tl.h;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J>\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u001e\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0004\u0012\u00020\u00140\u0012J7\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J*\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0012J#\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ,\u0010!\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00192\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00140\u0012J%\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u001eJ\\\u0010'\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00062\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00130#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0012JU\u0010(\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00130#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/utils/WinkAIGCRequestUtils;", "", "", "isSuccess", "", "retCode", "", "msg", "isRetry", "styleID", "materialID", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "pbResponse", "Lcom/tencent/mobileqq/wink/aigc/utils/c;", "b", PreDownloadConstants.RPORT_KEY_BUSINESS_ID, "imageUrl", "isSync", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "responseCallback", "j", "i", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "action", "respCallback", "c", "d", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sceneID", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "e", "f", "", "imageUrls", "isRegenerate", "isCouple", "g", h.F, "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIGCRequestUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkAIGCRequestUtils f317926a = new WinkAIGCRequestUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/aigc/utils/WinkAIGCRequestUtils$a", "Lw93/a;", "Lqshadow/ShadowAIGCStatus$DoActionReply;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements w93.a<ShadowAIGCStatus$DoActionReply> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f317927a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            this.f317927a = function1;
        }

        @Override // w93.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable ShadowAIGCStatus$DoActionReply pbResponse) {
            Integer num;
            boolean z16;
            if (pbRequest != null) {
                num = Integer.valueOf(pbRequest.getCurrentSeq());
            } else {
                num = null;
            }
            w53.b.f("WinkAIGCRequestUtils", "requestDoAction onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | msg:" + msg2 + " | SeqId:" + num);
            Function1<Boolean, Unit> function1 = this.f317927a;
            if (retCode == 0 && isSuccess) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/aigc/utils/WinkAIGCRequestUtils$b", "Lw93/a;", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements w93.a<ShadowAIGCStatus$GetStatusReply> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<ShadowAIGCStatus$GetStatusReply, Unit> f317928a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super ShadowAIGCStatus$GetStatusReply, Unit> function1) {
            this.f317928a = function1;
        }

        @Override // w93.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable ShadowAIGCStatus$GetStatusReply pbResponse) {
            Integer num;
            if (pbRequest != null) {
                num = Integer.valueOf(pbRequest.getCurrentSeq());
            } else {
                num = null;
            }
            w53.b.f("WinkAIGCRequestUtils", "requestGetStatus onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | msg:" + msg2 + " | SeqId:" + num);
            this.f317928a.invoke(pbResponse);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/aigc/utils/WinkAIGCRequestUtils$c", "Lw93/a;", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements w93.a<ShadowAIGCGenerate$GenerateReply> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f317929a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f317930b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f317931c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<WinkMakeAIImageResponse, Unit> f317932d;

        /* JADX WARN: Multi-variable type inference failed */
        c(boolean z16, String str, String str2, Function1<? super WinkMakeAIImageResponse, Unit> function1) {
            this.f317929a = z16;
            this.f317930b = str;
            this.f317931c = str2;
            this.f317932d = function1;
        }

        @Override // w93.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable ShadowAIGCGenerate$GenerateReply pbResponse) {
            Integer num;
            if (pbRequest != null) {
                num = Integer.valueOf(pbRequest.getCurrentSeq());
            } else {
                num = null;
            }
            w53.b.f("WinkAIGCRequestUtils", "requestMakeImage onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | msg:" + msg2 + " | SeqId:" + num);
            this.f317932d.invoke(WinkAIGCRequestUtils.f317926a.b(isSuccess, retCode, msg2, this.f317929a, this.f317930b, this.f317931c, pbResponse));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/aigc/utils/WinkAIGCRequestUtils$d", "Lw93/a;", "Lqshadow/ShadowAIGCSafe$SafeCheckReply;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements w93.a<ShadowAIGCSafe$SafeCheckReply> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Pair<Boolean, String>, Unit> f317933a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Pair<Boolean, String>, Unit> function1) {
            this.f317933a = function1;
        }

        @Override // w93.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable ShadowAIGCSafe$SafeCheckReply pbResponse) {
            Integer num;
            boolean z16;
            PBStringField pBStringField;
            PBBoolField pBBoolField;
            String str = null;
            if (pbRequest != null) {
                num = Integer.valueOf(pbRequest.getCurrentSeq());
            } else {
                num = null;
            }
            w53.b.f("WinkAIGCRequestUtils", "triggerImageSafeCheck onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | msg:" + msg2 + " | SeqId:" + num);
            if (pbResponse != null && (pBBoolField = pbResponse.is_legal) != null) {
                z16 = pBBoolField.get();
            } else {
                z16 = false;
            }
            if (pbResponse != null && (pBStringField = pbResponse.msg_id) != null) {
                str = pBStringField.get();
            }
            if (str == null) {
                str = "";
            }
            this.f317933a.invoke(TuplesKt.to(Boolean.valueOf(z16), str));
        }
    }

    WinkAIGCRequestUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMakeAIImageResponse b(boolean isSuccess, long retCode, String msg2, boolean isRetry, String styleID, String materialID, ShadowAIGCGenerate$GenerateReply pbResponse) {
        String str;
        Object orNull;
        Object orNull2;
        List<ShadowAIGCGenerate$Media> list;
        String str2;
        ArrayList arrayList = new ArrayList();
        if (pbResponse == null) {
            return new WinkMakeAIImageResponse(isSuccess, retCode, msg2, isRetry, styleID, materialID, arrayList, "");
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField = pbResponse.medias;
        if (pBRepeatMessageField == null || (list = pBRepeatMessageField.get()) == null) {
            str = "";
        } else {
            String str3 = "";
            for (ShadowAIGCGenerate$Media shadowAIGCGenerate$Media : list) {
                String url = shadowAIGCGenerate$Media.string_data.get();
                int i3 = shadowAIGCGenerate$Media.scene.get();
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            Intrinsics.checkNotNullExpressionValue(url, "url");
                            str3 = url;
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        arrayList3.add(url);
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    arrayList2.add(url);
                    ao aoVar = ao.f326683a;
                    String str4 = shadowAIGCGenerate$Media.extra.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "media.extra.get()");
                    Map<String, String> a16 = aoVar.a(str4);
                    if (a16 == null || (str2 = a16.get("gender")) == null) {
                        str2 = "";
                    }
                    arrayList4.add(str2);
                }
            }
            str = str3;
        }
        int i16 = 0;
        for (Object obj : arrayList2) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str5 = (String) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList3, i16);
            String str6 = (String) orNull;
            if (str6 == null) {
                str6 = "";
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(arrayList4, i16);
            String str7 = (String) orNull2;
            if (str7 == null) {
                str7 = "";
            }
            arrayList.add(new WinkMakeAIImageResponse.Media(str5, str6, str7));
            i16 = i17;
        }
        return new WinkMakeAIImageResponse(isSuccess, retCode, msg2, isRetry, styleID, materialID, arrayList, str);
    }

    public final void c(@NotNull String businessID, int action, @NotNull Function1<? super Boolean, Unit> respCallback) {
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        Intrinsics.checkNotNullParameter(respCallback, "respCallback");
        ShadowAIGCStatus$DoActionRequest shadowAIGCStatus$DoActionRequest = new ShadowAIGCStatus$DoActionRequest();
        shadowAIGCStatus$DoActionRequest.busi_id.set(businessID);
        shadowAIGCStatus$DoActionRequest.action.set(action);
        e.f445096a.f(new QQWinkAIGCDoActionReq(shadowAIGCStatus$DoActionRequest), new a(respCallback));
    }

    @Nullable
    public final Object d(@NotNull String str, int i3, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f317926a.c(str, i3, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils$requestDoActionSuspend$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void e(@NotNull String businessID, int sceneID, @NotNull Function1<? super ShadowAIGCStatus$GetStatusReply, Unit> respCallback) {
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        Intrinsics.checkNotNullParameter(respCallback, "respCallback");
        ShadowAIGCStatus$GetStatusRequest shadowAIGCStatus$GetStatusRequest = new ShadowAIGCStatus$GetStatusRequest();
        shadowAIGCStatus$GetStatusRequest.busi_id.set(businessID);
        shadowAIGCStatus$GetStatusRequest.scene.set(sceneID);
        e.f445096a.f(new QQWinkAIGCGetStatusReq(shadowAIGCStatus$GetStatusRequest), new b(respCallback));
    }

    @Nullable
    public final Object f(@NotNull String str, int i3, @NotNull Continuation<? super ShadowAIGCStatus$GetStatusReply> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f317926a.e(str, i3, new Function1<ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils$requestGetStatusSuspend$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke2(shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(shadowAIGCStatus$GetStatusReply));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void g(@NotNull String businessID, @NotNull List<Pair<String, String>> imageUrls, boolean isRegenerate, @NotNull String styleID, boolean isCouple, @NotNull String materialID, @NotNull Function1<? super WinkMakeAIImageResponse, Unit> responseCallback) {
        int collectionSizeOrDefault;
        Map mutableMapOf;
        Map mutableMapOf2;
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
        Intrinsics.checkNotNullParameter(styleID, "styleID");
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        List<Pair<String, String>> list = imageUrls;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ShadowAIGCGenerate$Media shadowAIGCGenerate$Media = new ShadowAIGCGenerate$Media();
            shadowAIGCGenerate$Media.type.set(1);
            shadowAIGCGenerate$Media.string_data.set((String) pair.getFirst());
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("msg_id", pair.getSecond()));
            shadowAIGCGenerate$Media.extra.set(GsonUtils.obj2Json(mutableMapOf2));
            arrayList.add(shadowAIGCGenerate$Media);
        }
        ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest = new ShadowAIGCGenerate$GenerateRequest();
        shadowAIGCGenerate$GenerateRequest.busi_id.set(businessID);
        shadowAIGCGenerate$GenerateRequest.medias.set(arrayList);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("is_retry", Boolean.valueOf(isRegenerate)), TuplesKt.to("style", styleID), TuplesKt.to("is_couple", Boolean.valueOf(isCouple)));
        shadowAIGCGenerate$GenerateRequest.extra.set(GsonUtils.obj2Json(mutableMapOf));
        e.f445096a.f(new QQWinkAIGCRequest(shadowAIGCGenerate$GenerateRequest), new c(isRegenerate, styleID, materialID, responseCallback));
    }

    @Nullable
    public final Object h(@NotNull String str, @NotNull List<Pair<String, String>> list, boolean z16, @NotNull String str2, boolean z17, @NotNull String str3, @NotNull Continuation<? super WinkMakeAIImageResponse> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f317926a.g(str, list, z16, str2, z17, str3, new Function1<WinkMakeAIImageResponse, Unit>() { // from class: com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils$requestMakeImageSuspend$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkMakeAIImageResponse winkMakeAIImageResponse) {
                invoke2(winkMakeAIImageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkMakeAIImageResponse ret) {
                Intrinsics.checkNotNullParameter(ret, "ret");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ret));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public final Object i(@NotNull String str, @NotNull String str2, boolean z16, @NotNull Continuation<? super Pair<Boolean, String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f317926a.j(str, str2, z16, new Function1<Pair<? extends Boolean, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.wink.aigc.utils.WinkAIGCRequestUtils$triggerImageCheckSuspend$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, String> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(response));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void j(@NotNull String businessID, @NotNull String imageUrl, boolean isSync, @NotNull Function1<? super Pair<Boolean, String>, Unit> responseCallback) {
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        ArrayList arrayList = new ArrayList();
        ShadowAIGCSafe$Media shadowAIGCSafe$Media = new ShadowAIGCSafe$Media();
        shadowAIGCSafe$Media.type.set(1);
        shadowAIGCSafe$Media.string_data.set(imageUrl);
        arrayList.add(shadowAIGCSafe$Media);
        ShadowAIGCSafe$SafeCheckRequest shadowAIGCSafe$SafeCheckRequest = new ShadowAIGCSafe$SafeCheckRequest();
        shadowAIGCSafe$SafeCheckRequest.busi_id.set(businessID);
        shadowAIGCSafe$SafeCheckRequest.medias.set(arrayList);
        shadowAIGCSafe$SafeCheckRequest.is_sync.set(isSync);
        e.f445096a.f(new QQWinkAIGCSafeCheckRequest(shadowAIGCSafe$SafeCheckRequest), new d(responseCallback));
    }
}
