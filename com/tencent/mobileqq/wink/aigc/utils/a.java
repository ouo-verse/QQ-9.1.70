package com.tencent.mobileqq.wink.aigc.utils;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.request.QQWinkAIGCRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.AIGCRequest;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaScene;
import org.light.aigc.bean.MediaType;
import org.light.aigc.net.IGenerateCallback;
import org.light.aigc.net.ISSOPBTransformer;
import org.light.aigc.net.ISSOProvider;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;
import qshadow.ShadowAIGCGenerate$Media;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R4\u0010\u0019\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/utils/a;", "Lorg/light/aigc/net/ISSOProvider;", "", "a", "Lorg/light/aigc/bean/AIGCRequest;", Const.BUNDLE_KEY_REQUEST, "Lorg/light/aigc/net/IGenerateCallback;", "callback", "sendRequest", "", "value", "Lorg/light/aigc/bean/MediaScene;", "b", "(Ljava/lang/Integer;)Lorg/light/aigc/bean/MediaScene;", "Lorg/light/aigc/bean/MediaType;", "c", "(Ljava/lang/Integer;)Lorg/light/aigc/bean/MediaType;", "Lorg/light/aigc/net/ISSOPBTransformer;", "Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "Lorg/light/aigc/net/ISSOPBTransformer;", "getSsoPBTransformer", "()Lorg/light/aigc/net/ISSOPBTransformer;", "setSsoPBTransformer", "(Lorg/light/aigc/net/ISSOPBTransformer;)V", "ssoPBTransformer", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements ISSOProvider {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f317937a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ISSOPBTransformer<ShadowAIGCGenerate$GenerateRequest, ShadowAIGCGenerate$GenerateReply> ssoPBTransformer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/aigc/utils/a$a", "Lorg/light/aigc/net/ISSOPBTransformer;", "Lqshadow/ShadowAIGCGenerate$GenerateRequest;", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "Lorg/light/aigc/bean/AIGCRequest;", Const.BUNDLE_KEY_REQUEST, "a", "responsePb", "Lorg/light/aigc/bean/AIGCContentOutput;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aigc.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9009a implements ISSOPBTransformer<ShadowAIGCGenerate$GenerateRequest, ShadowAIGCGenerate$GenerateReply> {
        C9009a() {
        }

        @Override // org.light.aigc.net.ISSOPBTransformer
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShadowAIGCGenerate$GenerateRequest transToRequestPb(@NotNull AIGCRequest request) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(request, "request");
            w53.b.f("AIGCSDKHelper", "setSsoPBProvider transToRequestPb");
            ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest = new ShadowAIGCGenerate$GenerateRequest();
            shadowAIGCGenerate$GenerateRequest.busi_id.set(request.bussId);
            shadowAIGCGenerate$GenerateRequest.extra.set(request.extra);
            PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField = shadowAIGCGenerate$GenerateRequest.medias;
            List<ContentInfo> list = request.contentInfos;
            Intrinsics.checkNotNullExpressionValue(list, "request.contentInfos");
            List<ContentInfo> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (ContentInfo contentInfo : list2) {
                ShadowAIGCGenerate$Media shadowAIGCGenerate$Media = new ShadowAIGCGenerate$Media();
                shadowAIGCGenerate$Media.type.set(contentInfo.type.value);
                shadowAIGCGenerate$Media.byte_data.set(ByteStringMicro.copyFrom(contentInfo.byteData));
                shadowAIGCGenerate$Media.string_data.set(contentInfo.stringData);
                shadowAIGCGenerate$Media.scene.set(contentInfo.scene.value);
                shadowAIGCGenerate$Media.extra.set(contentInfo.extra);
                arrayList.add(shadowAIGCGenerate$Media);
            }
            pBRepeatMessageField.set(arrayList);
            shadowAIGCGenerate$GenerateRequest.func_id.set(request.functionId);
            return shadowAIGCGenerate$GenerateRequest;
        }

        @Override // org.light.aigc.net.ISSOPBTransformer
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AIGCContentOutput transToResponsePb(@Nullable ShadowAIGCGenerate$GenerateReply responsePb) {
            String str;
            List<ShadowAIGCGenerate$Media> list;
            int collectionSizeOrDefault;
            Integer num;
            byte[] bArr;
            String str2;
            Integer num2;
            String str3;
            ByteStringMicro byteStringMicro;
            w53.b.f("AIGCSDKHelper", "setSsoPBProvider transToResponsePb");
            AIGCContentOutput aIGCContentOutput = new AIGCContentOutput();
            if (responsePb != null) {
                PBRepeatMessageField<ShadowAIGCGenerate$Media> pBRepeatMessageField = responsePb.medias;
                String str4 = "";
                ArrayList arrayList = null;
                if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                    Intrinsics.checkNotNullExpressionValue(list, "get()");
                    List<ShadowAIGCGenerate$Media> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    for (ShadowAIGCGenerate$Media shadowAIGCGenerate$Media : list2) {
                        ContentInfo contentInfo = new ContentInfo();
                        a aVar = a.f317937a;
                        PBEnumField pBEnumField = shadowAIGCGenerate$Media.type;
                        if (pBEnumField != null) {
                            num = Integer.valueOf(pBEnumField.get());
                        } else {
                            num = null;
                        }
                        contentInfo.type = aVar.c(num);
                        PBBytesField pBBytesField = shadowAIGCGenerate$Media.byte_data;
                        if (pBBytesField == null || (byteStringMicro = pBBytesField.get()) == null || (bArr = byteStringMicro.toByteArray()) == null) {
                            bArr = new byte[0];
                        }
                        contentInfo.byteData = bArr;
                        PBStringField pBStringField = shadowAIGCGenerate$Media.string_data;
                        if (pBStringField == null || (str2 = pBStringField.get()) == null) {
                            str2 = "";
                        }
                        contentInfo.stringData = str2;
                        PBEnumField pBEnumField2 = shadowAIGCGenerate$Media.scene;
                        if (pBEnumField2 != null) {
                            num2 = Integer.valueOf(pBEnumField2.get());
                        } else {
                            num2 = null;
                        }
                        contentInfo.scene = aVar.b(num2);
                        PBStringField pBStringField2 = shadowAIGCGenerate$Media.extra;
                        if (pBStringField2 == null || (str3 = pBStringField2.get()) == null) {
                            str3 = "";
                        }
                        contentInfo.extra = str3;
                        arrayList2.add(contentInfo);
                    }
                    arrayList = arrayList2;
                }
                aIGCContentOutput.contentInfos = arrayList;
                PBStringField pBStringField3 = responsePb.extra;
                if (pBStringField3 != null && (str = pBStringField3.get()) != null) {
                    str4 = str;
                }
                aIGCContentOutput.extra = str4;
            }
            return aIGCContentOutput;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/aigc/utils/a$b", "Lw93/a;", "Lqshadow/ShadowAIGCGenerate$GenerateReply;", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements w93.a<ShadowAIGCGenerate$GenerateReply> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ISSOPBTransformer<ShadowAIGCGenerate$GenerateRequest, ShadowAIGCGenerate$GenerateReply> f317939a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGenerateCallback f317940b;

        b(ISSOPBTransformer<ShadowAIGCGenerate$GenerateRequest, ShadowAIGCGenerate$GenerateReply> iSSOPBTransformer, IGenerateCallback iGenerateCallback) {
            this.f317939a = iSSOPBTransformer;
            this.f317940b = iGenerateCallback;
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
            w53.b.f("AIGCSDKHelper", "requestaigc onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | msg:" + msg2 + " | SeqId:" + num);
            if (isSuccess && retCode == 0) {
                AIGCContentOutput transToResponsePb = this.f317939a.transToResponsePb(pbResponse);
                w53.b.f("AIGCSDKHelper", "callback?.onSuccess(output) = " + transToResponsePb);
                IGenerateCallback iGenerateCallback = this.f317940b;
                if (iGenerateCallback != null) {
                    iGenerateCallback.onSuccess(transToResponsePb);
                    return;
                }
                return;
            }
            IGenerateCallback iGenerateCallback2 = this.f317940b;
            if (iGenerateCallback2 != null) {
                iGenerateCallback2.onError(retCode, msg2);
            }
        }
    }

    a() {
    }

    private final void a() {
        if (ssoPBTransformer != null) {
            return;
        }
        ssoPBTransformer = new C9009a();
    }

    @NotNull
    public final MediaScene b(@Nullable Integer value) {
        if (value != null && value.intValue() == 1) {
            return MediaScene.SceneCropped;
        }
        if (value != null && value.intValue() == 2) {
            return MediaScene.SceneResult;
        }
        if (value != null && value.intValue() == 3) {
            return MediaScene.SceneResultWithQrCode;
        }
        return MediaScene.SceneEmpty;
    }

    @NotNull
    public final MediaType c(@Nullable Integer value) {
        if (value != null && value.intValue() == 1) {
            return MediaType.TypeImage;
        }
        if (value != null && value.intValue() == 2) {
            return MediaType.TypeVideo;
        }
        if (value != null && value.intValue() == 3) {
            return MediaType.TypeAudio;
        }
        if (value != null && value.intValue() == 4) {
            return MediaType.TypeText;
        }
        if (value != null && value.intValue() == 5) {
            return MediaType.TypeGIF;
        }
        return MediaType.TypeEmpty;
    }

    @Override // org.light.aigc.net.ISSOProvider
    public void sendRequest(@Nullable AIGCRequest request, @Nullable IGenerateCallback callback) {
        a();
        w53.b.f("AIGCSDKHelper", "start ssoProvider request: " + request);
        ISSOPBTransformer<ShadowAIGCGenerate$GenerateRequest, ShadowAIGCGenerate$GenerateReply> iSSOPBTransformer = ssoPBTransformer;
        if (iSSOPBTransformer != null) {
            ShadowAIGCGenerate$GenerateRequest transToRequestPb = iSSOPBTransformer.transToRequestPb(request);
            Intrinsics.checkNotNull(transToRequestPb, "null cannot be cast to non-null type qshadow.ShadowAIGCGenerate.GenerateRequest");
            e.f445096a.f(new QQWinkAIGCRequest(transToRequestPb), new b(iSSOPBTransformer, callback));
        }
    }
}
