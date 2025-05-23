package com.tencent.mobileqq.qwallet.pay;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import tencent.gdt.qq_ad_get;
import tencent.im.qqwallet.PaySuccessAd$GetAdReq;
import tencent.im.qqwallet.PaySuccessAd$GetAdRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018JA\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005H\u0007J\b\u0010\u000e\u001a\u00020\rH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J*\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/h;", "", "", "merChatId", "offerId", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "", "callback", "e", "Ltencent/gdt/qq_ad_get$QQAdGet;", "a", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "c", "Lkotlin/Pair;", "Ltencent/im/qqwallet/PaySuccessAd$GetAdRsp;", "newValue", "b", "Lkotlin/Pair;", "adRspCache", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f278657a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Pair<String, PaySuccessAd$GetAdRsp> adRspCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/pay/h$a", "Lpl2/o;", "Ltencent/im/qqwallet/PaySuccessAd$GetAdRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements o<PaySuccessAd$GetAdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f278659a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f278660b;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.qwallet.pay.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public /* synthetic */ class C8477a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f278661a;

            static {
                int[] iArr = new int[EnumAdType.values().length];
                try {
                    iArr[EnumAdType.AMS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumAdType.FINANCE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f278661a = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Function1<? super Integer, Unit> function1) {
            this.f278659a = str;
            this.f278660b = function1;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PaySuccessAd$GetAdRsp rsp) {
            Long l3;
            String str;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            h.f278657a.b(new Pair<>(this.f278659a, rsp));
            int i3 = C8477a.f278661a[EnumAdType.INSTANCE.a(rsp.ad_type.get()).ordinal()];
            String str2 = null;
            if (i3 != 1) {
                if (i3 == 2) {
                    FinanceAdInfo a16 = com.tencent.mobileqq.qwallet.pay.a.a(rsp);
                    if (a16 != null) {
                        str = a16.getId();
                    } else {
                        str = null;
                    }
                    if (a16 != null) {
                        str2 = a16.getSubTitle();
                    }
                    com.tencent.mobileqq.qwallet.c.d("", "qqpay.success.preloading", QCircleDaTongConstant.ElementParamValue.WALLET, 2, 0, "", "", str, str2);
                }
            } else {
                GdtAd b16 = com.tencent.mobileqq.qwallet.pay.a.b(rsp);
                if (b16 != null) {
                    l3 = Long.valueOf(b16.getAId());
                } else {
                    l3 = null;
                }
                String valueOf = String.valueOf(l3);
                if (b16 != null) {
                    str2 = b16.getText();
                }
                com.tencent.mobileqq.qwallet.c.d("", "qqpay.success.preloading", QCircleDaTongConstant.ElementParamValue.WALLET, 1, 0, "", "", valueOf, str2);
            }
            Function1<Integer, Unit> function1 = this.f278660b;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(rsp.ad_type.get()));
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Function1<Integer, Unit> function1 = this.f278660b;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(EnumAdType.NONE.ordinal()));
            }
        }
    }

    h() {
    }

    private final qq_ad_get.QQAdGet a() {
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
            positionInfo.pos_id.set("1041411978846102");
            qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
            positionInfo.ad_count.set(1);
            positionExt.deep_link_version.set(1);
            positionInfo.pos_ext.set(positionExt);
            qQAdGet.position_info.add(positionInfo);
            qq_ad_get.QQAdGet.DeviceInfo c16 = c();
            if (c16 != null) {
                qQAdGet.device_info.set(c16);
            }
            qQAdGet.user_info.set(new qq_ad_get.QQAdGet.UserInfo());
        } catch (Throwable th5) {
            QLog.e("PaySuccessAdvService", 1, "create ad req failed " + th5);
        }
        return qQAdGet;
    }

    private final qq_ad_get.QQAdGet.DeviceInfo c() {
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(MobileQQ.sMobileQQ, new GdtDeviceInfoHelper.Params());
            if (create != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PaySuccessAdvService", 2, "gdt device info init success");
                }
                return create.deviceInfo;
            }
            return null;
        } catch (Exception e16) {
            QLog.e("PaySuccessAdvService", 1, "Error when get gdt device info", e16);
            return null;
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull String merChatId, @Nullable String str) {
        Intrinsics.checkNotNullParameter(merChatId, "merChatId");
        f(merChatId, str, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull String merChatId, @Nullable String offerId, @Nullable Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(merChatId, "merChatId");
        QLog.i("PaySuccessAdvService", 1, "request ad: merChatId=" + merChatId + ", offerId=" + offerId);
        PaySuccessAd$GetAdReq paySuccessAd$GetAdReq = new PaySuccessAd$GetAdReq();
        paySuccessAd$GetAdReq.busi_type.set(15);
        paySuccessAd$GetAdReq.qq_ad_get.set(f278657a.a());
        paySuccessAd$GetAdReq.merchant_id.set(merChatId);
        paySuccessAd$GetAdReq.offer_id.set(offerId);
        a aVar = new a(merChatId, callback);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = PaySuccessAd$GetAdRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qpay.ad.Ad", "PaySucc", paySuccessAd$GetAdReq, (MessageMicro) newInstance, false, true, false, null, aVar);
    }

    public static /* synthetic */ void f(String str, String str2, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        e(str, str2, function1);
    }

    @Nullable
    public final synchronized Pair<String, PaySuccessAd$GetAdRsp> b(@Nullable Pair<String, PaySuccessAd$GetAdRsp> newValue) {
        Pair<String, PaySuccessAd$GetAdRsp> pair;
        pair = adRspCache;
        adRspCache = newValue;
        return pair;
    }
}
