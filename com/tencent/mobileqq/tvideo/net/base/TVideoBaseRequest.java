package com.tencent.mobileqq.tvideo.net.base;

import com.tencent.biz.richframework.network.request.BaseRequest;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.RequestHead;
import tvideo.ResponseHead;
import tvideo.SSORequest;
import tvideo.SSOResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00132\u00020\u0001:\u0002\u0014\u0015B\u0013\b\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J!\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "", "getCallee", "getFunc", "getCmdName", "", "requestBizData", "getFinalRequestData", "wupBuffer", "", "", "parseResponseHeadInfo", "([B)[Ljava/lang/Object;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest$ServicesType;", "servicesType", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest$ServicesType;", "<init>", "(Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest$ServicesType;)V", "Companion", "a", "ServicesType", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class TVideoBaseRequest extends BaseRequest {

    @NotNull
    public static final String TAG = "TVideoBaseRequest";

    @NotNull
    private final ServicesType servicesType;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicInteger f304488d = new AtomicInteger(0);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest$ServicesType;", "", "(Ljava/lang/String;I)V", "TrpPb", "VideopacketJce", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public enum ServicesType {
        TrpPb,
        VideopacketJce
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f304489a;

        static {
            int[] iArr = new int[ServicesType.values().length];
            try {
                iArr[ServicesType.TrpPb.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServicesType.VideopacketJce.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f304489a = iArr;
        }
    }

    @JvmOverloads
    public TVideoBaseRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public abstract String getCallee();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        int i3 = b.f304489a[this.servicesType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return "trpc.access.video_access_matrix.sso_video_packet.SsoVideoPacket";
            }
            throw new NoWhenBranchMatchedException();
        }
        return "trpc.access.video_access_matrix.sso_trpc.SsoTrpc";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    protected byte[] getFinalRequestData(@Nullable byte[] requestBizData) {
        RequestHead.a a16 = a.f304490a.a();
        a16.c(getCallee());
        a16.i(getFunc());
        a16.o(f304488d.getAndIncrement());
        SSORequest.a c16 = new SSORequest.a().c(a16.build());
        if (requestBizData != null) {
            c16.a(ByteString.INSTANCE.of(requestBizData, 0, requestBizData.length));
        }
        return c16.build().encode();
    }

    @NotNull
    public abstract String getFunc();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public Object[] parseResponseHeadInfo(@Nullable byte[] wupBuffer) {
        Object[] b16;
        boolean z16;
        long j3;
        String str;
        byte[] bArr;
        ByteString byteString;
        ResponseHead responseHead;
        ResponseHead responseHead2;
        Object[] objArr = new Object[3];
        if (wupBuffer != null) {
            try {
                byte[] a16 = com.tencent.mobileqq.tvideo.net.utils.a.f304498a.a(wupBuffer);
                if (a16 != null) {
                    if (a16.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        SSOResponse decode = SSOResponse.ADAPTER.decode(a16);
                        if (decode != null && (responseHead2 = decode.header) != null) {
                            j3 = responseHead2.err_code;
                        } else {
                            j3 = 0;
                        }
                        objArr[0] = Long.valueOf(j3);
                        if (decode == null || (responseHead = decode.header) == null || (str = Integer.valueOf(responseHead.err_code).toString()) == null) {
                            str = "";
                        }
                        objArr[1] = str;
                        if (decode == null || (byteString = decode.body) == null || (bArr = byteString.toByteArray()) == null) {
                            bArr = new byte[0];
                        }
                        objArr[2] = bArr;
                        return objArr;
                    }
                }
                b16 = com.tencent.mobileqq.tvideo.net.base.b.f304491a.a();
            } catch (Exception e16) {
                e16.printStackTrace();
                b16 = com.tencent.mobileqq.tvideo.net.base.b.f304491a.b();
            }
            return b16;
        }
        return objArr;
    }

    public /* synthetic */ TVideoBaseRequest(ServicesType servicesType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ServicesType.TrpPb : servicesType);
    }

    @JvmOverloads
    public TVideoBaseRequest(@NotNull ServicesType servicesType) {
        Intrinsics.checkNotNullParameter(servicesType, "servicesType");
        this.servicesType = servicesType;
    }
}
