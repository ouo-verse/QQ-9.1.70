package com.tencent.mobileqq.wink.request.material;

import android.net.Uri;
import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.smtt.utils.Md5Utils;
import common.config.service.QzoneConfig;
import ga3.l;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QShadowMaterialDistribution$CategoryMaterialsMapping;
import qshadow.QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq;
import qshadow.QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp;
import w53.b;
import w93.e;
import y53.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\u001f\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0006\u0010\u0017\u001a\u00020\tJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/request/material/WinkEditorMaterialReq;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "", "c", "", "d", "Lqshadow/QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp;", "ssoPbRsp", "e", "", "url", "downloadPath", "ssoPkey", "b", "", "byteArray", "a", "getRequestByteData", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "getCmdName", "getServiceId", "", "netPbRsp", "Lcamera/SHADOW_BACKEND_INTERFACE/GetCatMatTreeRsp;", "getCatMatTreeRepFromPB", "serviceId", "Ljava/lang/String;", "Lqshadow/QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq;", "req$delegate", "Lkotlin/Lazy;", "getReq", "()Lqshadow/QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq;", "req", "<init>", "(Ljava/lang/String;)V", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorMaterialReq extends QCircleBaseRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: req$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy req;

    @NotNull
    private final String serviceId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/request/material/WinkEditorMaterialReq$a;", "", "", "serviceId", "a", "b", "MATERIAL_CDN_PKEY", "Ljava/lang/String;", "", "SORT_TYPE_NORMAL", "I", "SORT_TYPE_REVERSE", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.request.material.WinkEditorMaterialReq$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(@NotNull String serviceId) {
            Intrinsics.checkNotNullParameter(serviceId, "serviceId");
            a aVar = a.f326269a;
            if (!aVar.b() && !aVar.c()) {
                return w93.b.f445085a.b(b(serviceId));
            }
            w93.b.f445085a.f(b(serviceId));
            return "";
        }

        @NotNull
        public final String b(@NotNull String serviceId) {
            Intrinsics.checkNotNullParameter(serviceId, "serviceId");
            return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_circle_material_lite." + serviceId;
        }

        Companion() {
        }
    }

    public WinkEditorMaterialReq(@NotNull String serviceId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        this.serviceId = serviceId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq>() { // from class: com.tencent.mobileqq.wink.request.material.WinkEditorMaterialReq$req$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq invoke() {
                boolean c16;
                int d16;
                QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq = new QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq();
                WinkEditorMaterialReq winkEditorMaterialReq = WinkEditorMaterialReq.this;
                String serviceId2 = winkEditorMaterialReq.getServiceId();
                String a16 = WinkEditorMaterialReq.INSTANCE.a(serviceId2);
                c16 = winkEditorMaterialReq.c();
                qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq.serviceID.set(serviceId2);
                qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq.etag.set(a16);
                qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq.groupID.set(a.f326269a.a());
                qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq.sdkVersion.set(e.f445096a.d());
                qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq.enableCDN.set(c16);
                PBInt32Field pBInt32Field = qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq.sortType;
                d16 = winkEditorMaterialReq.d();
                pBInt32Field.set(d16);
                b.a("WinkEditorMaterialReq", "request serviceId " + serviceId2 + ", etag " + a16 + " , enableCdn:" + c16 + ", thread:" + Thread.currentThread().getName());
                return qShadowMaterialDistribution$GetCircleCatMatTreeLiteReq;
            }
        });
        this.req = lazy;
    }

    private final QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp a(byte[] byteArray) {
        boolean z16;
        boolean z17 = false;
        if (byteArray != null) {
            if (byteArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        if (z17) {
            try {
                QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp = new QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp();
                MessageMicro.mergeFrom(qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp, byteArray);
                w53.b.a("WinkEditorMaterialReq", "bytesToPb success");
                return qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp;
            } catch (Exception e16) {
                w53.b.d("WinkEditorMaterialReq", "bytesToPb failed", e16);
                return null;
            }
        }
        w53.b.c("WinkEditorMaterialReq", "byteArray empty");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004f, code lost:
    
        if (r9 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b(String url, String downloadPath, String ssoPkey) {
        String removeSuffix;
        String str;
        String valueOf = String.valueOf(Uri.parse(url).getPath());
        removeSuffix = StringsKt__StringsKt.removeSuffix(url, (CharSequence) valueOf);
        String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
        if (TextUtils.isEmpty(ssoPkey)) {
            ssoPkey = "dbym7iw94t2yTUIUKrXa";
        }
        String md5 = Md5Utils.getMD5(ssoPkey + valueOf + hexString);
        if (md5 != null) {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            str = md5.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
        }
        str = "";
        String str2 = removeSuffix + "/" + str + "/" + hexString + valueOf;
        w53.b.a("WinkEditorMaterialReq", "downloadPbFromCdn originUrl:" + url + ", host:" + removeSuffix + ", fileName:" + valueOf + ", typc url: " + str2);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        y53.a.c().a(str2, downloadPath, new b(booleanRef, countDownLatch));
        countDownLatch.await();
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c() {
        return QzoneConfig.checkWinkEditOptimizeOpenByUid(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), QzoneConfig.SECONDARY_KEY_WINK_MATERIAL_CDN_CONFIG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d() {
        return 0;
    }

    private final QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp e(QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp ssoPbRsp) {
        boolean z16;
        QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp a16;
        PBRepeatMessageField<QShadowMaterialDistribution$CategoryMaterialsMapping> pBRepeatMessageField;
        boolean z17 = true;
        if (ssoPbRsp != null && (pBRepeatMessageField = ssoPbRsp.categoryMaterialsMappings) != null && pBRepeatMessageField.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String cdnOriginUrl = ssoPbRsp.materialListURL.get();
            Intrinsics.checkNotNullExpressionValue(cdnOriginUrl, "cdnOriginUrl");
            if (cdnOriginUrl.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                w53.b.a("WinkEditorMaterialReq", " cdnOriginUrl is " + cdnOriginUrl);
                File file = new File(u53.e.f438387d, Md5Utils.getMD5(cdnOriginUrl));
                if (!file.exists()) {
                    String path = file.getPath();
                    Intrinsics.checkNotNullExpressionValue(path, "downloadFile.path");
                    String str = ssoPbRsp.pkey.get();
                    Intrinsics.checkNotNullExpressionValue(str, "ssoPbRsp.pkey.get()");
                    b(cdnOriginUrl, path, str);
                } else {
                    w53.b.a("WinkEditorMaterialReq", "load cdn from cache");
                }
                if (file.exists() && (a16 = a(l.e(file))) != null) {
                    return a16;
                }
            }
        }
        return ssoPbRsp;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qshadow.QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Nullable
    public final GetCatMatTreeRsp getCatMatTreeRepFromPB(@Nullable Object netPbRsp) {
        String str;
        PBStringField pBStringField;
        QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp = (QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp) netPbRsp;
        if (qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp != null && (pBStringField = qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.materialListURL) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        w53.b.a("WinkEditorMaterialReq", " sso response cdnOriginUrl is " + str);
        if (qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp != null) {
            String b16 = INSTANCE.b(this.serviceId);
            String str2 = getReq().etag.get();
            String str3 = qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp.etag.get();
            w53.b.a("WinkEditorMaterialReq", "req eTag:" + str2 + ", rsp eTag:" + str3);
            if (!TextUtils.isEmpty(str2) && Intrinsics.areEqual(str2, str3)) {
                w93.b bVar = w93.b.f445085a;
                QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp a16 = a(bVar.d(b16));
                if (a16 == null) {
                    bVar.f(b16);
                } else {
                    qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp = a16;
                }
            } else if (!TextUtils.isEmpty(str3)) {
                w93.b.f445085a.g(b16, str3, qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp);
                w53.b.a("WinkEditorMaterialReq", "save  " + this.serviceId + " eTag");
            } else {
                w93.b.f445085a.f(b16);
            }
        } else {
            w53.b.c("WinkEditorMaterialReq", "pbRsp is null");
        }
        QShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp e16 = e(qShadowMaterialDistribution$GetCircleCatMatTreeLiteRsp);
        if (e16 == null) {
            return null;
        }
        return v53.a.a(e16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_get_circle_material_lite";
    }

    @NotNull
    public final QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq getReq() {
        return (QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq) this.req.getValue();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = getReq().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    @NotNull
    public final String getServiceId() {
        if (a.f326269a.b()) {
            return "MqKuaishanTemplateTest";
        }
        return this.serviceId;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/request/material/WinkEditorMaterialReq$b", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f326267a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f326268b;

        b(Ref.BooleanRef booleanRef, CountDownLatch countDownLatch) {
            this.f326267a = booleanRef;
            this.f326268b = countDownLatch;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
            Ref.BooleanRef booleanRef = this.f326267a;
            boolean z16 = false;
            if (resp != null && resp.mResult == 0) {
                z16 = true;
            }
            booleanRef.element = z16;
            w53.b.a("WinkEditorMaterialReq", "download success " + z16);
            this.f326268b.countDown();
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
        }
    }
}
