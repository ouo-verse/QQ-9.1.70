package hz2;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sz2.g;
import tencent.gdt.qq_ad_get;
import uz2.VasRewardAdReportParams;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J=\u0010\u0011\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002JU\u0010\u0015\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002JI\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001a\u00a8\u0006 "}, d2 = {"Lhz2/a;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "l", "g", "", "code", "i", "remoteCode", "remoteErrMsg", "remoteBusiBuffer", "j", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ltz2/a;", "Ltz2/a;", "mShowRewardVideoCallback", "<init>", "()V", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private tz2.a mShowRewardVideoCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"hz2/a$b", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements bz2.a<vac_adv_get.VacAdvRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f406960b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f406961c;

        b(Function1<Object, Unit> function1, long j3) {
            this.f406960b = function1;
            this.f406961c = j3;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (code == VasAdvServiceCode.REQUEST_RSP_FAIL) {
                a.this.i(this.f406960b, 11);
            } else {
                a.this.i(this.f406960b, 13);
            }
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull vac_adv_get.VacAdvRsp rsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            List<vac_adv_get.VacAdvMetaMsg> list = rsp.vac_adv_msgs.get();
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                a.this.i(this.f406960b, 11);
                return;
            }
            g.f435047a.r(this.f406961c, rsp);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("adSequence", this.f406961c);
            Function1<Object, Unit> function1 = this.f406960b;
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"hz2/a$c", "Lbz2/a;", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "rsp", "", "c", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "code", "", "errMsg", "", "e", "b", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements bz2.a<adv_report.MobileAdvReportRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f406963b;

        c(Function1<Object, Unit> function1) {
            this.f406963b = function1;
        }

        @Override // bz2.a
        public void b(@NotNull VasAdvServiceCode code, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            a.this.j(this.f406963b, 13, -1, errMsg, "");
        }

        @Override // bz2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull adv_report.MobileAdvReportRsp rsp) {
            int i3;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            int i16 = rsp.ret_code.get();
            String errMsg = rsp.error_msg.get();
            byte[] byteArray = rsp.busi_buffer.get().toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "rsp.busi_buffer.get().toByteArray()");
            String str = new String(byteArray, Charsets.UTF_8);
            if (i16 == 0) {
                i3 = 0;
            } else {
                i3 = 11;
            }
            a aVar = a.this;
            Function1<Object, Unit> function1 = this.f406963b;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            aVar.j(function1, i3, i16, errMsg, str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"hz2/a$d", "Ltz2/a;", "", "profitable", "", "elapsedTime", "totalTime", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements tz2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f406964a;

        d(Function1<Object, Unit> function1) {
            this.f406964a = function1;
        }

        @Override // tz2.a
        public void a(boolean profitable, int elapsedTime, int totalTime) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("isEnd", profitable);
            jSONObject.put("elapsedTime", elapsedTime);
            jSONObject.put("totalTime", totalTime);
            Function1<Object, Unit> function1 = this.f406964a;
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
        }
    }

    public a() {
        g.f435047a.f();
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        g gVar = g.f435047a;
        VasRewardAdReqParams l3 = gVar.l(jSONObject);
        if (l3 == null) {
            i(callback, 10);
            return;
        }
        long c16 = gVar.c();
        QLog.d("QQKuiklyRewardVideoModule", 1, "loadRewardVideoAd:", Long.valueOf(c16));
        gVar.p(l3, new b(callback, c16));
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        long optLong = jSONObject.optLong("adSequence");
        String optString = jSONObject.optString("rewardAdResponse");
        if (!jSONObject.optBoolean("isFinished")) {
            i(callback, 10);
            g.f435047a.m(optLong);
            return;
        }
        vac_adv_get.VacAdvRsp h16 = g.f435047a.h(optLong);
        if (!TextUtils.isEmpty(optString)) {
            try {
                h16 = (vac_adv_get.VacAdvRsp) GdtJsonPbUtil.pbFromJson(new vac_adv_get.VacAdvRsp(), new JSONObject(optString));
            } catch (Exception e16) {
                QLog.e("QQKuiklyRewardVideoModule", 1, "reportRewardVideoAd parse adRsp error:", e16);
            }
        }
        if (h16 == null) {
            i(callback, 10);
            return;
        }
        g gVar = g.f435047a;
        VasRewardAdReportParams k3 = gVar.k(jSONObject, h16);
        if (k3 == null) {
            i(callback, 10);
            gVar.m(optLong);
        } else {
            QLog.d("QQKuiklyRewardVideoModule", 1, "reportRewardVideoAd:", Long.valueOf(optLong));
            gVar.n(k3, new c(callback));
            gVar.m(optLong);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Function1<Object, Unit> callback, int code) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Function1<Object, Unit> callback, int code, int remoteCode, String remoteErrMsg, String remoteBusiBuffer) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("remoteCode", remoteCode);
        jSONObject.put("remoteErrMsg", remoteErrMsg);
        jSONObject.put("remoteBusiBuffer", remoteBusiBuffer);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    private final void l(String params, Function1<Object, Unit> callback) {
        boolean z16;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2;
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        long optLong = jSONObject.optLong("adSequence");
        String optString = jSONObject.optString("customRewardText");
        g gVar = g.f435047a;
        vac_adv_get.VacAdvRsp h16 = gVar.h(optLong);
        if (h16 == null) {
            i(callback, 11);
            return;
        }
        List<vac_adv_get.VacAdvMetaMsg> list = h16.vac_adv_msgs.get();
        List<vac_adv_get.VacAdvMetaMsg> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i(callback, 11);
            return;
        }
        vac_adv_get.VacAdvMetaMsg vacAdvMetaMsg = list.get(0);
        if (vacAdvMetaMsg != null && (adInfo2 = vacAdvMetaMsg.adv_rsp) != null) {
            adInfo = adInfo2.get();
        } else {
            adInfo = null;
        }
        if (adInfo == null) {
            i(callback, 11);
            return;
        }
        if (getActivity() == null) {
            i(callback, 12);
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            QLog.d("QQKuiklyRewardVideoModule", 1, "showRewardVideoAd:", Long.valueOf(optLong));
            d dVar = new d(callback);
            this.mShowRewardVideoCallback = dVar;
            gVar.q(activity, adInfo, new WeakReference<>(dVar), optString, "biz_src_kuiklyRewardVideo");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -435650821:
                if (method.equals("reportRewardVideoAd")) {
                    g(params, callback);
                }
                return Unit.INSTANCE;
            case 3237136:
                if (method.equals("init")) {
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 564291538:
                if (method.equals("showRewardVideoAd")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1787076745:
                if (method.equals("loadRewardVideoAd")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                return Unit.INSTANCE;
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        this.mShowRewardVideoCallback = null;
    }
}
