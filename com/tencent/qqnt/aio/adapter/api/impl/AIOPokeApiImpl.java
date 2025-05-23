package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.poke.IPokeSendHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import com.tencent.qqnt.aio.adapter.api.impl.AIOPokeApiImpl;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0003-./B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J2\u0010\u0016\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00122\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001fR,\u0010!\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOPokeApi;", "", "initVasPokeCfg", "", "imagePath", "Landroid/graphics/Bitmap;", "getBitmap", "", "isBigResReady", "Lmqq/app/AppRuntime;", "appRuntime", "considerGetPokeBigRes", "isVasPokeShockSupport", "res", "", "resId", "vasPokeResExist", "", "pokeSvipMap", "Lkotlin/Function1;", "vasResourceCallback", "init", "vasPokeId", "downloadVasItem", "destroy", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "sendPokeMsg", "Ljava/util/Map;", "Lmqq/util/WeakReference;", "vasResourceCallbackRef", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;", "initVasCfgCallback", "Lcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;", "vasPokeCallback", "Lcom/tencent/mobileqq/app/BusinessObserver;", "cacheObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "<init>", "()V", "Companion", "a", "b", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOPokeApiImpl implements IAIOPokeApi {
    private static final String TAG = "AIOPokeApiImpl";
    private static final String VAS_DOWNLOAD_ITEM_FROM = "getbubbleview";
    private BusinessObserver cacheObserver;
    private CallBacker initVasCfgCallback;
    private Map<Integer, Integer> pokeSvipMap;
    private CallBacker vasPokeCallback;
    private WeakReference<Function1<String, Unit>> vasResourceCallbackRef;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiImpl$b;", "Lcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;", "", "bid", "", "scid", "cfgScid", "from", "", "errorCode", "httpCode", "", "callback", "<init>", "(Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiImpl;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private final class b extends CallBacker {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(AIOPokeApiImpl this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.initVasPokeCfg();
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long bid, String scid, String cfgScid, String from, int errorCode, int httpCode) {
            Intrinsics.checkNotNullParameter(scid, "scid");
            Intrinsics.checkNotNullParameter(cfgScid, "cfgScid");
            Intrinsics.checkNotNullParameter(from, "from");
            if (Intrinsics.areEqual(scid, VasUpdateConstants.SCID_POKE_EFFECT_LIST) && errorCode == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(AIOPokeApiImpl.TAG, 2, "download vas poke list, update pokeSvipMap now.");
                }
                final AIOPokeApiImpl aIOPokeApiImpl = AIOPokeApiImpl.this;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOPokeApiImpl.b.b(AIOPokeApiImpl.this);
                    }
                }, 64, null, false);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiImpl$d", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadFail", "onLoadSuccess", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f348556a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOPokeApiImpl f348557b;

        d(String str, AIOPokeApiImpl aIOPokeApiImpl) {
            this.f348556a = str;
            this.f348557b = aIOPokeApiImpl;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(UpdateListenerParams params) {
            CallBacker callBacker;
            Intrinsics.checkNotNullParameter(params, "params");
            BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
            if (!TextUtils.equals(businessUpdateParams.mScid, this.f348556a) || (callBacker = this.f348557b.vasPokeCallback) == null) {
                return;
            }
            callBacker.callback(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, params.mErrorCode, params.mHttpCode);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(UpdateListenerParams params) {
            CallBacker callBacker;
            Intrinsics.checkNotNullParameter(params, "params");
            BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
            if (!TextUtils.equals(businessUpdateParams.mScid, this.f348556a) || (callBacker = this.f348557b.vasPokeCallback) == null) {
                return;
            }
            callBacker.callback(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, params.mErrorCode, params.mHttpCode);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiImpl$e", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadFail", "onLoadSuccess", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f348558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOPokeApiImpl f348559b;

        e(String str, AIOPokeApiImpl aIOPokeApiImpl) {
            this.f348558a = str;
            this.f348559b = aIOPokeApiImpl;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(UpdateListenerParams params) {
            CallBacker callBacker;
            Intrinsics.checkNotNullParameter(params, "params");
            BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
            if (!TextUtils.equals(businessUpdateParams.mScid, this.f348558a) || (callBacker = this.f348559b.vasPokeCallback) == null) {
                return;
            }
            callBacker.callback(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, params.mErrorCode, params.mHttpCode);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(UpdateListenerParams params) {
            CallBacker callBacker;
            Intrinsics.checkNotNullParameter(params, "params");
            BusinessUpdateParams businessUpdateParams = params.mBusinessUpdateParams;
            if (!TextUtils.equals(businessUpdateParams.mScid, this.f348558a) || (callBacker = this.f348559b.vasPokeCallback) == null) {
                return;
            }
            callBacker.callback(businessUpdateParams.mBid, businessUpdateParams.mScid, "", businessUpdateParams.mFrom, params.mErrorCode, params.mHttpCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initVasPokeCfg() {
        final Map<Integer, Integer> map = this.pokeSvipMap;
        if (map != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.v
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPokeApiImpl.initVasPokeCfg$lambda$3$lambda$2(AIOPokeApiImpl.this, map);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initVasPokeCfg$lambda$3$lambda$2(AIOPokeApiImpl this$0, Map it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        ArrayList<com.tencent.mobileqq.activity.aio.ao> t16 = com.tencent.mobileqq.activity.aio.item.l.t(MobileQQ.sMobileQQ.waitAppRuntime(null), this$0.initVasCfgCallback);
        if (t16.size() > 0) {
            Iterator<com.tencent.mobileqq.activity.aio.ao> it5 = t16.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.activity.aio.ao next = it5.next();
                it.put(Integer.valueOf(next.f178218c), Integer.valueOf(next.f178221f));
            }
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void considerGetPokeBigRes(AppRuntime appRuntime) {
        if (appRuntime instanceof AppInterface) {
            BusinessHandler businessHandler = ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.utils.PokeBigResHandler");
            ((PokeBigResHandler) businessHandler).Q2(true);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void destroy() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) runtimeService;
        iVasQuickUpdateService.removeCallBacker(this.vasPokeCallback);
        iVasQuickUpdateService.removeCallBacker(this.initVasCfgCallback);
        this.pokeSvipMap = null;
        this.vasResourceCallbackRef = null;
        this.initVasCfgCallback = null;
        this.vasPokeCallback = null;
        if (this.cacheObserver != null) {
            Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ((AppInterface) waitAppRuntime).removeObserver(this.cacheObserver);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public Bitmap getBitmap(String imagePath) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        return LottieHelper.a(imagePath);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void init(Map<Integer, Integer> pokeSvipMap, Function1<? super String, Unit> vasResourceCallback) {
        Intrinsics.checkNotNullParameter(pokeSvipMap, "pokeSvipMap");
        this.pokeSvipMap = pokeSvipMap;
        this.vasResourceCallbackRef = new WeakReference<>(vasResourceCallback);
        this.initVasCfgCallback = new b();
        this.vasPokeCallback = new c();
        initVasPokeCfg();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public boolean isBigResReady() {
        return PokeBigResHandler.C;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public boolean isVasPokeShockSupport() {
        return com.tencent.mobileqq.activity.aio.item.l.n();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void sendPokeMsg(final com.tencent.aio.api.runtime.a aioContext, final AIOElementType.b item) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.p() == 126) {
            IPokeSendHelper iPokeSendHelper = (IPokeSendHelper) QRoute.api(IPokeSendHelper.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.cacheObserver = iPokeSendHelper.vasPokeAuth(context, aioContext, item, new Function0<Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOPokeApiImpl$sendPokeMsg$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AIOPokeApiImpl.this.cacheObserver = null;
                }
            }, new Function3<Integer, String, String, Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOPokeApiImpl$sendPokeMsg$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                    invoke(num.intValue(), str, str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String name, String minVersion) {
                    Intrinsics.checkNotNullParameter(name, "name");
                    Intrinsics.checkNotNullParameter(minVersion, "minVersion");
                    if (TextUtils.equals(AIOElementType.b.this.y(), name) && i3 == AIOElementType.b.this.w() && Intrinsics.areEqual(minVersion, AIOElementType.b.this.x())) {
                        ((IPokeSendHelper) QRoute.api(IPokeSendHelper.class)).sendPokeMsg(aioContext, AIOElementType.b.this);
                    }
                }
            });
            return;
        }
        ((IPokeSendHelper) QRoute.api(IPokeSendHelper.class)).sendPokeMsg(aioContext, item);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public boolean vasPokeResExist(String res, int resId) {
        Intrinsics.checkNotNullParameter(res, "res");
        return com.tencent.mobileqq.activity.aio.item.l.B(res, resId);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPokeApi
    public void downloadVasItem(int vasPokeId) {
        QQVasUpdateBusiness f16 = com.tencent.mobileqq.activity.aio.item.l.f();
        if (f16 != null) {
            String str = VasUpdateConstants.SCID_POKE_PANEL_PREFIX + vasPokeId;
            String str2 = VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + vasPokeId;
            if (f16.isFileExist(str)) {
                CallBacker callBacker = this.vasPokeCallback;
                if (callBacker != null) {
                    callBacker.callback(21L, str, "", "", 0, 0);
                }
            } else {
                f16.addDownLoadListener(str, new d(str, this));
                f16.startDownload(str);
            }
            if (f16.isFileExist(str2)) {
                CallBacker callBacker2 = this.vasPokeCallback;
                if (callBacker2 != null) {
                    callBacker2.callback(21L, str2, "", "", 0, 0);
                    return;
                }
                return;
            }
            f16.addDownLoadListener(str2, new e(str2, this));
            f16.startDownload(str2);
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasQuickUpdateService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) runtimeService;
        iVasQuickUpdateService.downloadItem(21L, VasUpdateConstants.SCID_POKE_PANEL_PREFIX + vasPokeId, VAS_DOWNLOAD_ITEM_FROM);
        iVasQuickUpdateService.downloadItem(21L, VasUpdateConstants.SCID_POKE_EFFECT_PREFIX + vasPokeId, VAS_DOWNLOAD_ITEM_FROM);
        iVasQuickUpdateService.addCallBacker(this.vasPokeCallback);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiImpl$c;", "Lcom/tencent/mobileqq/vas/updatesystem/callback/CallBacker;", "", "bid", "", "scid", "cfgScid", "from", "", "errorCode", "httpCode", "", "callback", "<init>", "(Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPokeApiImpl;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private final class c extends CallBacker {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void callback(long bid, String scid, String cfgScid, String from, int errorCode, int httpCode) {
            boolean startsWith$default;
            boolean startsWith$default2;
            int i3;
            String str;
            IAIOPokeApi.Companion companion;
            boolean z16;
            WeakReference weakReference;
            Function1 function1;
            if (bid != 21) {
                return;
            }
            Intrinsics.checkNotNull(scid);
            boolean z17 = false;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(scid, VasUpdateConstants.SCID_POKE_PANEL_PREFIX, false, 2, null);
            String str2 = "";
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(scid, VasUpdateConstants.SCID_POKE_EFFECT_PREFIX, false, 2, null);
                if (!startsWith$default2) {
                    i3 = 0;
                    str = "";
                } else {
                    str = scid.substring(14, scid.length());
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    Integer valueOf = Integer.valueOf(str);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(resId)");
                    i3 = valueOf.intValue();
                    IAIOPokeApi.Companion companion2 = IAIOPokeApi.INSTANCE;
                    if (companion2.c().contains(Integer.valueOf(i3))) {
                        companion2.c().remove(Integer.valueOf(i3));
                        z17 = true;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    companion = IAIOPokeApi.INSTANCE;
                    if (!companion.d().contains(Integer.valueOf(i3))) {
                        z16 = !com.tencent.mobileqq.activity.aio.item.l.B("bubble", i3);
                        boolean z18 = !com.tencent.mobileqq.activity.aio.item.l.B(IAIOPokeApi.VAS_POKE_RES_NORMAL, i3);
                        boolean contains = companion.b().contains(Integer.valueOf(i3));
                        weakReference = AIOPokeApiImpl.this.vasResourceCallbackRef;
                        if (weakReference != null) {
                            if (z16) {
                                str2 = HardCodeUtil.qqStr(R.string.n37);
                            }
                            Intrinsics.checkNotNullExpressionValue(str2, "if (effectNoExist && pan\u2026ivinghe_f4460402) else \"\"");
                            function1.invoke(str2);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                }
            } else {
                str = scid.substring(17, scid.length());
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                Integer valueOf2 = Integer.valueOf(str);
                Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(resId)");
                i3 = valueOf2.intValue();
                IAIOPokeApi.Companion companion3 = IAIOPokeApi.INSTANCE;
                if (companion3.d().contains(Integer.valueOf(i3))) {
                    companion3.d().remove(Integer.valueOf(i3));
                    z17 = true;
                }
                if (!TextUtils.isEmpty(str) && z17) {
                    companion = IAIOPokeApi.INSTANCE;
                    if (!companion.d().contains(Integer.valueOf(i3)) && !companion.d().contains(Integer.valueOf(i3))) {
                        z16 = !com.tencent.mobileqq.activity.aio.item.l.B("bubble", i3);
                        boolean z182 = !com.tencent.mobileqq.activity.aio.item.l.B(IAIOPokeApi.VAS_POKE_RES_NORMAL, i3);
                        boolean contains2 = companion.b().contains(Integer.valueOf(i3));
                        weakReference = AIOPokeApiImpl.this.vasResourceCallbackRef;
                        if (weakReference != null && (function1 = (Function1) weakReference.get()) != null) {
                            if (z16 && z182 && contains2) {
                                str2 = HardCodeUtil.qqStr(R.string.n37);
                            }
                            Intrinsics.checkNotNullExpressionValue(str2, "if (effectNoExist && pan\u2026ivinghe_f4460402) else \"\"");
                            function1.invoke(str2);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    return;
                }
                QLog.d(AIOPokeApiImpl.TAG, 2, "vas poke download id: " + scid + " , errorCode: " + errorCode);
            }
        }
    }
}
