package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.biz.hr.api.IKuiklyImageFetcher;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.base.model.AssetPathModel;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.CustomDownloadRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 Ju\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002Ju\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u0011H\u0002Ju\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u0011H\u0002Ju\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u0011H\u0002J}\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00142Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u0011H\u0002J\u0018\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c*\u00020\u0004H\u0002Ju\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062Q\u0010\u0012\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u0011H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/QQKuiklyImageFetcher;", "Lcom/tencent/ecommerce/biz/hr/api/IKuiklyImageFetcher;", "Landroid/content/Context;", "context", "", "path", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function3;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "errorCode", "errorMsg", "", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "callback", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "assetPath", "e", "j", "d", "isAsset", tl.h.F, "", "k", "fetchDrawable", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyImageFetcher implements IKuiklyImageFetcher {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f262773b = ar.INSTANCE.b("shouyouye", "2024-03-04", "vas_bug_121136491").isEnable(true);

    private final void e(Context context, String assetPath, IECImageLoader.ImageLoaderOption option, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        d(context, assetPath, option, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 tryGetOfflineDrawable, final QQKuiklyImageFetcher this$0, final Context context, final String path, final IECImageLoader.ImageLoaderOption imageLoaderOption, final Function3 callback) {
        Intrinsics.checkNotNullParameter(tryGetOfflineDrawable, "$tryGetOfflineDrawable");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (((Boolean) tryGetOfflineDrawable.invoke()).booleanValue()) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.c
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyImageFetcher.g(QQKuiklyImageFetcher.this, context, path, imageLoaderOption, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QQKuiklyImageFetcher this$0, Context context, String path, IECImageLoader.ImageLoaderOption imageLoaderOption, Function3 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.l(context, path, imageLoaderOption, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function3 callback, Context context, String path, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(path, "$path");
        if (loadState.isFinish()) {
            if (option.getAnimatable() != null) {
                Object animatable = option.getAnimatable();
                callback.invoke(animatable instanceof Drawable ? (Drawable) animatable : null, 0, "");
                return;
            }
            if (option.getResultBitMap() != null) {
                callback.invoke(new BitmapDrawable(context.getResources(), option.getResultBitMap()), 0, "");
                return;
            }
            if (option.getResource() != null) {
                Object obj = option.getResource().get();
                if (obj instanceof Drawable) {
                    callback.invoke(obj, 0, "");
                    return;
                }
                if (obj instanceof Bitmap) {
                    callback.invoke(new BitmapDrawable(context.getResources(), (Bitmap) obj), 0, "");
                    return;
                }
                QLog.e("QQKuiklyImageFetcher", 1, "in resource check failed:" + path + ", state:" + loadState + ", " + obj);
                callback.invoke(null, Integer.valueOf(option.getErrorCode()), "image resource is null");
                return;
            }
            QLog.e("QQKuiklyImageFetcher", 1, "fetchDrawable failed:" + path + ", state:" + loadState);
            callback.invoke(null, Integer.valueOf(option.getErrorCode()), "image drawable is null");
        }
    }

    private final Map<String, String> k(String str) {
        JSONObject jSONObject;
        String obj;
        try {
            jSONObject = new JSONObject(str);
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object next = keys.next();
            String str2 = next instanceof String ? (String) next : null;
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            Object opt = jSONObject.opt(str2);
            if (opt != null && (obj = opt.toString()) != null) {
                str3 = obj;
            }
            linkedHashMap.put(str2, str3);
        }
        return linkedHashMap;
    }

    private final void l(Context context, String path, IECImageLoader.ImageLoaderOption option, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        j(context, path, option, callback);
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IKuiklyImageFetcher
    public void fetchDrawable(final Context context, final String path, final IECImageLoader.ImageLoaderOption option, final Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "assets://", false, 2, null);
        if (startsWith$default) {
            String substring = path.substring(9);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            e(context, substring, option, callback);
            return;
        }
        final Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyImageFetcher$fetchDrawable$tryGetOfflineDrawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String offlineResPath = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getOfflineResPath(path);
                if (!TextUtils.isEmpty(offlineResPath)) {
                    IECImageLoader imageLoader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader();
                    Context context2 = context;
                    Intrinsics.checkNotNull(offlineResPath);
                    IECImageLoader.ImageLoaderOption imageLoaderOption = option;
                    final Function3<Drawable, Integer, String, Unit> function3 = callback;
                    imageLoader.fetchDrawable(context2, offlineResPath, imageLoaderOption, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyImageFetcher$fetchDrawable$tryGetOfflineDrawable$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                            invoke2(drawable);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Drawable drawable) {
                            boolean z16 = drawable != null;
                            function3.invoke(drawable, Integer.valueOf(z16 ? 0 : AppConstants.RichMediaErrorCode.ERROR_NET_CONN_NO_ROUTE), z16 ? "" : "load offline drawable error");
                        }
                    });
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        };
        if (m(path)) {
            if (f262773b) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQKuiklyImageFetcher.f(Function0.this, this, context, path, option, callback);
                    }
                }, 16, null, false);
            } else if (function0.invoke().booleanValue()) {
                return;
            }
        }
        l(context, path, option, callback);
    }

    private final void h(final Context context, final String path, IECImageLoader.ImageLoaderOption option, boolean isAsset, final Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        Option imageOption;
        Map<String, String> emptyMap;
        if (isAsset) {
            imageOption = Option.obtain().setModel(new AssetPathModel(path));
        } else {
            imageOption = Option.obtain().setUrl(path);
        }
        String str = null;
        if (option != null) {
            imageOption.setRequestWidth(option.getWidthPx());
            imageOption.setRequestHeight(option.getHeightPx());
            Map<String, Object> a16 = option.a();
            if (a16 != null) {
                if (a16.containsKey("headers")) {
                    com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
                    Intrinsics.checkNotNullExpressionValue(imageOption, "imageOption");
                    Object obj = a16.get("headers");
                    String str2 = obj instanceof String ? (String) obj : null;
                    if (str2 == null || (emptyMap = k(str2)) == null) {
                        emptyMap = MapsKt__MapsKt.emptyMap();
                    }
                    aVar.n(imageOption, new CustomDownloadRequest(emptyMap));
                }
                if (a16.containsKey("custom_cache_key")) {
                    Object obj2 = a16.get("custom_cache_key");
                    if (obj2 instanceof String) {
                        str = (String) obj2;
                    }
                }
            }
        }
        LifecycleOwner a17 = nf2.b.a(context);
        if (a17 != null) {
            imageOption.setLifecycleOwner(a17);
        }
        QQKuiklyPicLoader qQKuiklyPicLoader = QQKuiklyPicLoader.f262774a;
        Intrinsics.checkNotNullExpressionValue(imageOption, "imageOption");
        qQKuiklyPicLoader.t(imageOption, str, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                QQKuiklyImageFetcher.i(Function3.this, context, path, loadState, option2);
            }
        });
    }

    private final boolean m(String path) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "http", false, 2, null);
        return startsWith$default && !TextUtils.isEmpty(Uri.parse(path).getQueryParameter("_bid"));
    }

    private final void d(Context context, String assetPath, IECImageLoader.ImageLoaderOption option, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        h(context, assetPath, option, true, callback);
    }

    private final void j(Context context, String path, IECImageLoader.ImageLoaderOption option, Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        h(context, path, option, false, callback);
    }
}
