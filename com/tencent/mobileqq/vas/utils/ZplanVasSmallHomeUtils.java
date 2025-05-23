package com.tencent.mobileqq.vas.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.data.SmallHomeStatus;
import com.tencent.mobileqq.vas.transit.RequestPermissionFragment;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.mapstatus.ZootopiaMapStatusService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J,\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J8\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u0011J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ(\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ(\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/utils/ZplanVasSmallHomeUtils;", "", "Landroid/content/Context;", "context", "", IProfileProtocolConst.PARAM_TARGET_UIN, "Lkotlin/Function1;", "", "", "callback", "d", "k", h.F, "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lkotlin/Function2;", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "e", "f", "j", "c", "g", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanVasSmallHomeUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ZplanVasSmallHomeUtils f311238a = new ZplanVasSmallHomeUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/utils/ZplanVasSmallHomeUtils$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/vas/data/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements e<SmallHomeStatus> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f311239d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f311240e;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1, Context context) {
            this.f311239d = function1;
            this.f311240e = context;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(SmallHomeStatus result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f311239d.invoke(Boolean.valueOf(result.getIsFull()));
            if (result.getIsFull()) {
                ZplanVasSmallHomeUtils.f311238a.k(this.f311240e);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZplanVasResidenceUtils", 1, "checkResidenceIsFull fail " + error + " " + message);
            ZplanVasSmallHomeUtils.f311238a.h(this.f311240e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/utils/ZplanVasSmallHomeUtils$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService$b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<ZootopiaMapStatusService.MapStatusInfoResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, MapStatus, Unit> f311241d;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f311242a;

            static {
                int[] iArr = new int[MapStatus.values().length];
                try {
                    iArr[MapStatus.MAP_STATUS_PHONE_MODEL_INVALID.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MapStatus.MAP_STATUS_OFF_SHELF.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MapStatus.MAP_STATUS_CAN_APPOINTMENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MapStatus.MAP_STATUS_APPOINTED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[MapStatus.MAP_STATUS_ONLY_DOWNLOAD.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f311242a = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super MapStatus, Unit> function2) {
            this.f311241d = function2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaMapStatusService.MapStatusInfoResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = a.f311242a[result.getMapStatus().ordinal()];
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
                this.f311241d.invoke(Boolean.TRUE, result.getMapStatus());
            } else {
                this.f311241d.invoke(Boolean.FALSE, result.getMapStatus());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZplanVasResidenceUtils", 1, "checkMapStatusFromServer fail " + error + ", " + message);
            this.f311241d.invoke(Boolean.FALSE, MapStatus.MAP_STATUS_INIT);
        }
    }

    ZplanVasSmallHomeUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AppInterface appInterface, Resources resources) {
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        QQToast.makeText(appInterface.getApp(), 1, resources.getString(R.string.xjj), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AppInterface appInterface, Resources resources) {
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        QQToast.makeText(appInterface.getApp(), 1, resources.getString(R.string.xpm), 0).show();
    }

    public final void c(final Context context, final String targetUin, final TransitPageInfo info, final ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        d(context, targetUin, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.utils.ZplanVasSmallHomeUtils$checkResidenceIsFull$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (!z16) {
                    ZplanVasSmallHomeUtils.f311238a.g(context, targetUin, info, source);
                } else {
                    QLog.e("ZplanVasResidenceUtils", 1, "checkResidenceIsFull result is false");
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        r11 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(Context context, String targetUin, Function1<? super Boolean, Unit> callback) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (targetUin == null || longOrNull == null) {
            return;
        }
        long longValue = longOrNull.longValue();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        if (longValue == appInterface.getLongAccountUin()) {
            callback.invoke(Boolean.FALSE);
        } else {
            z23.e.f(new z23.e(), appInterface, longValue, false, 0, new a(callback, context), 8, null);
        }
    }

    public final void e(Context context, TransitPageInfo info, ZootopiaSource source, Function2<? super Boolean, ? super MapStatus, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZplanVasResidenceUtils", 1, "checkResidenceWhiteList");
        new ZootopiaMapStatusService().a(AdMetricID.Click.SUCCESS, new b(callback));
    }

    public final void f(Context context, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        QRouteApi api = QRoute.api(IZootopiaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaApi::class.java)");
        IZootopiaApi.a.a((IZootopiaApi) api, context, AdMetricID.Click.SUCCESS, source, false, null, 24, null);
    }

    public final void g(Context context, String targetUin, TransitPageInfo info, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        QRouteApi api = QRoute.api(IEntryApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IEntryApi::class.java)");
        IEntryApi.a.b((IEntryApi) api, context, AdMetricID.Click.SUCCESS, source, k33.a.f411513a.a(info.getExtInfo().getUeExtras(), targetUin), null, 16, null);
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        final Resources resources = context.getResources();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                ZplanVasSmallHomeUtils.i(AppInterface.this, resources);
            }
        });
    }

    public final void j(Context context, TransitPageInfo info, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("ZplanVasResidenceUtils", 1, "showResidenceAuthTip");
        if (info.getConfig().getSinglePageMode()) {
            RequestPermissionFragment.INSTANCE.a(context, info, null, source);
            return;
        }
        if (context instanceof Activity) {
            View decorView = ((Activity) context).getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            bd3.b createProfileCommonTips = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).createProfileCommonTips(0, (ViewGroup) decorView, info, new bd3.a());
            if (createProfileCommonTips != null) {
                createProfileCommonTips.show();
            }
        }
    }

    public final void k(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        final Resources resources = context.getResources();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                ZplanVasSmallHomeUtils.l(AppInterface.this, resources);
            }
        });
    }
}
