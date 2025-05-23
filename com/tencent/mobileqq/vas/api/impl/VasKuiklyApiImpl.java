package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.kuikly.VasActionSheetView;
import com.tencent.mobileqq.vas.kuikly.VasBottomSheetView;
import com.tencent.mobileqq.vas.kuikly.VasDynamicView;
import com.tencent.mobileqq.vas.kuikly.VasInterceptTouchView;
import com.tencent.mobileqq.vas.kuikly.VasKuiklyModule;
import com.tencent.mobileqq.vas.kuikly.VasLottieAnimationView;
import com.tencent.mobileqq.vas.kuikly.VasLottieView;
import com.tencent.mobileqq.vas.kuikly.VasNativePagView;
import com.tencent.mobileqq.vas.kuikly.VasNavBarView;
import com.tencent.mobileqq.vas.kuikly.VasPAPageContentView;
import com.tencent.mobileqq.vas.kuikly.VasQQAvatarView;
import com.tencent.mobileqq.vas.kuikly.reader.VASReaderLineView;
import com.tencent.mobileqq.vas.kuikly.reader.VasBookTransitionView;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JJ\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J8\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0010H\u0002JJ\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016JJ\u0010#\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u0016JR\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000228\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0016J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020\fH\u0016J.\u0010+\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010)H\u0016J\u0018\u0010/\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H\u0016J\u0012\u00100\u001a\u0004\u0018\u00010-2\u0006\u0010,\u001a\u00020\u0002H\u0016J\u0010\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0002H\u0016J\u0010\u00103\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0002H\u0016R7\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-04j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-`58BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasKuiklyApi;", "", "bundleName", "", "hasLocalRes", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "", "callback", "forcePreloadKuiklyRes", "innerStartPreload", "", "getPreloadInterval", "Lorg/json/JSONObject;", "materialItem", "version", "startLoadMaterialData", "flag", "errMsg", "bid", "errCode", "cacheTime", "reportDownloadResult", "Lcom/tencent/mobileqq/vas/VasCommonReportProxy;", "report", "isSimple", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "registerExternalRenderView", "registerExternalModule", "preloadKuiklyResByRule", "newTag", "preloadKuiklyResByTag", "pageName", "isDexPageExist", "startPreload", "", "params", "buildVasKuiklySchema", "key", "", "data", "setMqqToKuiklyData", "getMqqData", "param", "invokeArkViewReport", IH5DataCacheApi.METHOD_WRITE_H5_DATA, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mqqToKuiklyData$delegate", "Lkotlin/Lazy;", "getMqqToKuiklyData", "()Ljava/util/HashMap;", "mqqToKuiklyData", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasKuiklyApiImpl implements IVasKuiklyApi {

    @NotNull
    private static final String KEY_PRE_PRELOAD_TIME = "key_pre_preload_time";

    @NotNull
    private static final String TAG = "VasKuiklyApiImpl";
    private static volatile boolean isLoaded;

    /* renamed from: mqqToKuiklyData$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mqqToKuiklyData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasKuiklyApiImpl$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadFail", "onLoadSuccess", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f308501b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f308502c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f308503d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f308504e;

        b(String str, String str2, int i3, long j3) {
            this.f308501b = str;
            this.f308502c = str2;
            this.f308503d = i3;
            this.f308504e = j3;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            VasKuiklyApiImpl vasKuiklyApiImpl = VasKuiklyApiImpl.this;
            String scidAnd = this.f308501b;
            Intrinsics.checkNotNullExpressionValue(scidAnd, "scidAnd");
            String str = this.f308502c;
            String str2 = params.mErrorMessage;
            Intrinsics.checkNotNullExpressionValue(str2, "params.mErrorMessage");
            vasKuiklyApiImpl.reportDownloadResult(scidAnd, str, str2, this.f308503d, params.mErrorCode, this.f308504e);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            VasKuiklyApiImpl vasKuiklyApiImpl = VasKuiklyApiImpl.this;
            String scidAnd = this.f308501b;
            Intrinsics.checkNotNullExpressionValue(scidAnd, "scidAnd");
            vasKuiklyApiImpl.reportDownloadResult(scidAnd, this.f308502c, "", this.f308503d, 0, this.f308504e);
        }
    }

    public VasKuiklyApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, Object>>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$mqqToKuiklyData$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, Object> invoke() {
                return new HashMap<>();
            }
        });
        this.mqqToKuiklyData = lazy;
    }

    private final void forcePreloadKuiklyRes(String bundleName, final Function2<? super Integer, ? super String, Unit> callback) {
        ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(bundleName, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$forcePreloadKuiklyRes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                invoke2(resError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ResError resError) {
                Intrinsics.checkNotNullParameter(resError, "resError");
                QLog.i("VasKuiklyApiImpl", 1, "error: " + resError.getCode() + " " + resError.getMessage());
                callback.invoke(Integer.valueOf(resError.getCode()), resError.getMessage());
            }
        });
    }

    private final HashMap<String, Object> getMqqToKuiklyData() {
        return (HashMap) this.mqqToKuiklyData.getValue();
    }

    private final long getPreloadInterval() {
        return VasLongToggle.VAS_PRELOAD_RES_CONFIG.getJson().optLong("preload_interval", 86400000L);
    }

    private final boolean hasLocalRes(String bundleName) {
        long j3;
        DexConfig config = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getDexResInfo(bundleName).getConfig();
        if (config != null) {
            j3 = config.getTag();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return true;
        }
        return false;
    }

    private final void innerStartPreload() {
        String str;
        String str2;
        long j3;
        String str3;
        boolean z16;
        boolean startsWith$default;
        int i3;
        String str4;
        JSONArray jSONArray;
        long j16;
        int i16;
        String str5;
        String str6;
        IConfigProxy iConfigProxy = VasLongToggle.VAS_PRELOAD_RES_CONFIG;
        if (!iConfigProxy.isEnable(true) || isLoaded) {
            return;
        }
        VasMMKVProxy preloadCenter = VipMMKV.INSTANCE.getPreloadCenter();
        String str7 = KEY_PRE_PRELOAD_TIME;
        long decodeLong = preloadCenter.decodeLong(KEY_PRE_PRELOAD_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - decodeLong < getPreloadInterval()) {
            QLog.i(TAG, 1, "24\u5c0f\u65f6\u5185,\u4e0d\u8fdb\u884c\u9884\u4e0b\u8f7d");
            return;
        }
        JSONObject json = iConfigProxy.getJson();
        QLog.i(TAG, 1, "\u5f00\u59cb\u9884\u4e0b\u8f7d,\u914d\u7f6e:" + json);
        String optString = json.optString("version");
        JSONArray optJSONArray = json.optJSONArray("kuikly");
        String str8 = "k";
        boolean z17 = false;
        if (optJSONArray != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"kuikly\")");
            int length = optJSONArray.length();
            int i17 = 0;
            boolean z18 = false;
            while (i17 < length) {
                String string = optJSONArray.getString(i17);
                Intrinsics.checkNotNullExpressionValue(string, str8);
                int i18 = i17;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "vas_kuikly_preload_", z17, 2, null);
                if (startsWith$default) {
                    UnitedProxy unitedProxy = new UnitedProxy(string);
                    if (unitedProxy.isEnable(z17)) {
                        final long currentTimeMillis2 = System.currentTimeMillis();
                        final String substring = string.substring(19, string.length());
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        j16 = currentTimeMillis;
                        i16 = i18;
                        i3 = length;
                        str5 = str7;
                        str6 = str8;
                        final String str9 = optString;
                        str4 = optString;
                        jSONArray = optJSONArray;
                        preloadKuiklyResByTag(unitedProxy.getJson().optLong("timestamp", 0L), substring, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$innerStartPreload$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str10) {
                                invoke(num.intValue(), str10);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i19, @Nullable String str10) {
                                VasKuiklyApiImpl vasKuiklyApiImpl = VasKuiklyApiImpl.this;
                                String str11 = substring;
                                String mainVersion = str9;
                                Intrinsics.checkNotNullExpressionValue(mainVersion, "mainVersion");
                                if (str10 == null) {
                                    str10 = "";
                                }
                                vasKuiklyApiImpl.reportDownloadResult(str11, mainVersion, str10, 0, i19, currentTimeMillis2);
                            }
                        });
                        z18 = true;
                    } else {
                        i3 = length;
                        str4 = optString;
                        jSONArray = optJSONArray;
                        j16 = currentTimeMillis;
                        i16 = i18;
                        str5 = str7;
                        str6 = str8;
                    }
                } else {
                    i3 = length;
                    str4 = optString;
                    jSONArray = optJSONArray;
                    j16 = currentTimeMillis;
                    i16 = i18;
                    str5 = str7;
                    str6 = str8;
                    QLog.e(TAG, 1, "\u914d\u7f6e\u9519\u8bef,\u8bf7\u4ee5'vas_kuikly_preload_'\u5f00\u5934");
                }
                i17 = i16 + 1;
                str8 = str6;
                length = i3;
                str7 = str5;
                optJSONArray = jSONArray;
                currentTimeMillis = j16;
                optString = str4;
                z17 = false;
            }
            str = optString;
            str2 = str7;
            j3 = currentTimeMillis;
            str3 = str8;
            z16 = z18;
        } else {
            str = optString;
            str2 = KEY_PRE_PRELOAD_TIME;
            j3 = currentTimeMillis;
            str3 = "k";
            z16 = false;
        }
        JSONArray optJSONArray2 = json.optJSONArray(WadlProxyConsts.KEY_MATERIAL);
        if (optJSONArray2 != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(\"material\")");
            int length2 = optJSONArray2.length();
            int i19 = 0;
            while (i19 < length2) {
                String string2 = optJSONArray2.getString(i19);
                Intrinsics.checkNotNullExpressionValue(string2, str3);
                UnitedProxy unitedProxy2 = new UnitedProxy(string2);
                if (unitedProxy2.isEnable(false)) {
                    JSONObject json2 = unitedProxy2.getJson();
                    json2.optString("version");
                    JSONArray optJSONArray3 = json2.optJSONArray("res");
                    if (optJSONArray3 != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONArray3, "optJSONArray(\"res\")");
                        int length3 = optJSONArray3.length();
                        int i26 = 0;
                        while (i26 < length3) {
                            JSONObject jSONObject = optJSONArray3.getJSONObject(i26);
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonArr.getJSONObject(index)");
                            String mainVersion = str;
                            Intrinsics.checkNotNullExpressionValue(mainVersion, "mainVersion");
                            startLoadMaterialData(jSONObject, mainVersion);
                            i26++;
                            z16 = true;
                        }
                    }
                }
                i19++;
                str = str;
            }
        }
        if (z16) {
            isLoaded = true;
            VipMMKV.INSTANCE.getPreloadCenter().encodeLong(str2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadKuiklyResByRule$lambda$2(String bundleName, VasKuiklyApiImpl this$0, final Function2 function2) {
        Intrinsics.checkNotNullParameter(bundleName, "$bundleName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            UnitedProxy unitedProxy = new UnitedProxy("vas_kuikly_preload_" + bundleName);
            if (unitedProxy.isEnable(false)) {
                QLog.i(TAG, 1, "preload res from switch name: " + bundleName);
                this$0.preloadKuiklyResByTag(unitedProxy.getJson().optLong("timestamp", 0L), bundleName, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$preloadKuiklyResByRule$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                        invoke(num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, @Nullable String str) {
                        Function2<Integer, String, Unit> function22 = function2;
                        if (function22 != null) {
                            Integer valueOf = Integer.valueOf(i3);
                            if (str == null) {
                                str = "";
                            }
                            function22.invoke(valueOf, str);
                        }
                    }
                });
                return;
            }
            if (this$0.hasLocalRes(bundleName)) {
                QLog.i(TAG, 1, "local has,resId: " + bundleName);
                if (function2 != null) {
                    function2.invoke(-1, "local has");
                    return;
                }
                return;
            }
            QLog.i(TAG, 1, "start force kuiklyPreLoad resId:" + bundleName);
            this$0.forcePreloadKuiklyRes(bundleName, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$preloadKuiklyResByRule$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @Nullable String str) {
                    Function2<Integer, String, Unit> function22 = function2;
                    if (function22 != null) {
                        Integer valueOf = Integer.valueOf(i3);
                        if (str == null) {
                            str = "";
                        }
                        function22.invoke(valueOf, str);
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e(TAG, 1, "kuiklyPreLoad exception:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDownloadResult(String flag, String version, String errMsg, int bid, int errCode, long cacheTime) {
        reportDownloadResult(VasCommonReporter.getVasPreload(), flag, version, errMsg, bid, errCode, cacheTime, true);
    }

    static /* synthetic */ void reportDownloadResult$default(VasKuiklyApiImpl vasKuiklyApiImpl, ReportInfo reportInfo, String str, String str2, String str3, int i3, int i16, long j3, boolean z16, int i17, Object obj) {
        boolean z17;
        if ((i17 & 128) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        vasKuiklyApiImpl.reportDownloadResult(reportInfo, str, str2, str3, i3, i16, j3, z17);
    }

    private final void startLoadMaterialData(JSONObject materialItem, String version) {
        QQVasUpdateBusiness business;
        int optInt = materialItem.optInt("bid");
        String optString = materialItem.optString("scid_and");
        QLog.i(TAG, 1, "preload material bid:" + optInt + " scid:" + optString);
        if (!TextUtils.isEmpty(optString) && (business = QQVasUpdateBusiness.getBusiness(optInt)) != null) {
            if (business.isFileExist(optString)) {
                QLog.i(TAG, 1, "preload material scid:" + optString + " is exists");
                return;
            }
            business.addDownLoadListener(optString, new b(optString, version, optInt, System.currentTimeMillis()));
            business.startDownload(optString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPreload$lambda$8(VasKuiklyApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.innerStartPreload();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    @NotNull
    public String buildVasKuiklySchema(@NotNull String pageName, @NotNull String bundleName, @Nullable Map<String, String> params) {
        Set<Map.Entry<String, String>> entrySet;
        boolean z16;
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        StringBuilder sb5 = new StringBuilder("mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=" + pageName + "&bundle_name=" + bundleName);
        if (params != null && (entrySet = params.entrySet()) != null) {
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                boolean z17 = true;
                if (((CharSequence) entry.getKey()).length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (((CharSequence) entry.getValue()).length() != 0) {
                        z17 = false;
                    }
                    if (!z17) {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append((String) entry.getKey());
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append((String) entry.getValue());
                    }
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    @Nullable
    public Object getMqqData(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = getMqqToKuiklyData().get(key);
        if (obj == null) {
            return "";
        }
        return obj;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void invokeArkViewReport(@NotNull String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        VasPAPageContentView.INSTANCE.a(param);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public boolean isDexPageExist(@NotNull String bundleName, @NotNull String pageName) {
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).isDexPageExist(bundleName, pageName);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void preloadKuiklyResByRule(@NotNull final String bundleName, @Nullable final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.ai
            @Override // java.lang.Runnable
            public final void run() {
                VasKuiklyApiImpl.preloadKuiklyResByRule$lambda$2(bundleName, this, callback);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void preloadKuiklyResByTag(long newTag, @NotNull String bundleName, @NotNull Function2<? super Integer, ? super String, Unit> callback) {
        long j3;
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DexConfig config = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getDexResInfo(bundleName).getConfig();
        if (config != null) {
            j3 = config.getTag();
        } else {
            j3 = 0;
        }
        if (newTag <= 0 || j3 < newTag) {
            forcePreloadKuiklyRes(bundleName, callback);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("VasKuiklyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new VasKuiklyModule();
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void registerExternalRenderView(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        b.a.a(renderExport, "VasDynamicView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasDynamicView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasNavBarView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasNavBarView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasLottieView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasLottieView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasQQAvatarView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasQQAvatarView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasPAPageContentView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$5
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasPAPageContentView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasLottieAnimationView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$6
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasLottieAnimationView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasBottomSheetView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$7
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasBottomSheetView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasActionSheetView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$8
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasActionSheetView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VASReaderLineView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$9
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VASReaderLineView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "QQBookTransitionView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$10
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasBookTransitionView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasInterceptTouchView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$11
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasInterceptTouchView(it);
            }
        }, null, 4, null);
        b.a.a(renderExport, "VasNativePagView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyApiImpl$registerExternalRenderView$1$12
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new VasNativePagView(it);
            }
        }, null, 4, null);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void setMqqToKuiklyData(@NotNull String key, @NotNull Object data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        getMqqToKuiklyData().put(key, data);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void startPreload() {
        new VasKuiklyDownloadHelper().t();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.aj
            @Override // java.lang.Runnable
            public final void run() {
                VasKuiklyApiImpl.startPreload$lambda$8(VasKuiklyApiImpl.this);
            }
        }, 16, null, false, 5000L);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasKuiklyApi
    public void writeH5Data(@NotNull String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        new com.tencent.mobileqq.vas.kuikly.moduleimpl.as().r(param, null);
    }

    private final void reportDownloadResult(ReportInfo report, String flag, String version, String errMsg, int bid, int errCode, long cacheTime, boolean isSimple) {
        report.setValue1(flag).setValue2(version).setValue3(errMsg).setNum1(bid).setNum2(errCode).setNum3(System.currentTimeMillis() - cacheTime).report(isSimple);
    }
}
