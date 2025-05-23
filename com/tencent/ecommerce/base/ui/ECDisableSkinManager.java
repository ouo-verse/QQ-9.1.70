package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ui.api.IECSkinApi;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JC\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142'\u0010\u001b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t0\u0016j\u0002`\u001aH\u0016Jm\u0010 \u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142Q\u0010\u001b\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\t0\u001cj\u0002`\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECDisableSkinManager;", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "Lcom/tencent/ecommerce/base/ui/SkinIniFile;", "iniFile", "", "token", "b", "Landroid/content/Context;", "context", "", "init", "loadResource", "Landroid/view/LayoutInflater$Factory2;", "getSkinFactory2", "", "resId", "getColor", "(Ljava/lang/String;)Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "drawable", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "Lkotlin/Function3;", "errorCode", "errorMsg", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "getDrawableWithFetchCallback", "getUrl", "a", "Landroid/content/Context;", "Lkotlin/Lazy;", "c", "()Lcom/tencent/ecommerce/base/ui/SkinIniFile;", "urlIniFile", "<init>", "()V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECDisableSkinManager implements IECSkinApi {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context = wg0.a.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy urlIniFile;

    /* renamed from: c, reason: collision with root package name */
    private static final String f101026c = SkinResFactory.SKIN_THEME_APK_SAVE_DIR + File.separator + "qecommerce_skinurl.ini";

    public ECDisableSkinManager() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SkinIniFile>() { // from class: com.tencent.ecommerce.base.ui.ECDisableSkinManager$urlIniFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SkinIniFile invoke() {
                Context context;
                context = ECDisableSkinManager.this.context;
                return new SkinIniFile(context);
            }
        });
        this.urlIniFile = lazy;
    }

    private final String b(SkinIniFile iniFile, String token) {
        if (token.length() == 0) {
            return "";
        }
        String d16 = SkinIniFile.d(iniFile, QCircleSkinHelper.SKIN_IMAGE_URL_SECTION, token, null, 4, null);
        return d16 instanceof String ? d16 : "";
    }

    private final SkinIniFile c() {
        return (SkinIniFile) this.urlIniFile.getValue();
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public int getColor(int resId) {
        return ResourcesCompat.getColor(this.context.getResources(), resId, null);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public Drawable getDrawable(int resId) {
        return ResourcesCompat.getDrawable(this.context.getResources(), resId, null);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public void getDrawableWithFetchCallback(String token, IECImageLoader.ImageLoaderOption option, final Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        getDrawable(token, option, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.base.ui.ECDisableSkinManager$getDrawableWithFetchCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function3.this.invoke(drawable, 0, "");
            }
        });
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public LayoutInflater.Factory2 getSkinFactory2() {
        return null;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public String getUrl(String token) {
        return b(c(), token);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public void init(Context context) {
        cg0.a.b("ECSkin.ECDisableSkinManager", "init");
        SkinIniFile.f(c(), f101026c, null, 2, null);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public Integer getColor(String token) {
        Integer num = ECResourcesTransformHelper.g().getTokenToResIdMap().get(token);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue == 0) {
            return null;
        }
        return Integer.valueOf(getColor(intValue));
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public Drawable getDrawable(String token) {
        Integer num = ECResourcesTransformHelper.g().getTokenToResIdMap().get(token);
        int intValue = num != null ? num.intValue() : 0;
        if (intValue == 0) {
            return null;
        }
        return getDrawable(intValue);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public void getDrawable(String token, IECImageLoader.ImageLoaderOption option, Function1<? super Drawable, Unit> callback) {
        String url = getUrl(token);
        if (!(url == null || url.length() == 0)) {
            cg0.a.b("ECSkin.ECDisableSkinManager", "token=" + token + " is remote url: " + url);
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().fetchDrawable(this.context, url, option, callback);
            return;
        }
        cg0.a.b("ECSkin.ECDisableSkinManager", "token=" + token + " is local resource");
        callback.invoke(getDrawable(token));
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public void loadResource() {
    }
}
