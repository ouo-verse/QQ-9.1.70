package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ui.api.IECSkinApi;
import com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinManager;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 12\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JC\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u001aj\u0002`\u001eH\u0016Jm\u0010$\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182Q\u0010\u001f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\r0 j\u0002`#H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010&\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'J\u0013\u0010(\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010'R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00103\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u00102R\u001b\u00106\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010,\u001a\u0004\b5\u00102R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010,\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006A"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECEnableSkinManager;", "Lcom/tencent/ecommerce/base/ui/api/IECSkinApi;", "Lcom/tencent/ecommerce/base/ui/SkinIniFile;", "iniFile", "", "token", "l", "url", "g", "", "o", "Landroid/content/Context;", "context", "", "init", "loadResource", "Landroid/view/LayoutInflater$Factory2;", "getSkinFactory2", "", "resId", "getColor", "(Ljava/lang/String;)Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "drawable", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "Lkotlin/Function3;", "errorCode", "errorMsg", "Lcom/tencent/kuikly/core/render/android/expand/component/image/FetchImageCallback;", "getDrawableWithFetchCallback", "getUrl", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", tl.h.F, "a", "Landroid/content/Context;", "b", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/ecommerce/base/ui/SkinIniFile;", "urlIniFile", "c", "j", "()Ljava/lang/String;", "skinLocalPath", "d", "k", "skinVersionLocalPath", "Lkotlinx/coroutines/CoroutineScope;", "e", "i", "()Lkotlinx/coroutines/CoroutineScope;", "mainScope", DomainData.DOMAIN_NAME, "()Z", MiniGamePAHippyBaseFragment.KEY_THEME, "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECEnableSkinManager implements IECSkinApi {

    /* renamed from: f, reason: collision with root package name */
    private static final List<String> f101030f;

    /* renamed from: g, reason: collision with root package name */
    private static final String f101031g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f101032h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f101033i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context = wg0.a.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy urlIniFile;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy skinLocalPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy skinVersionLocalPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy mainScope;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(QCircleSkinHelper.QECOMMERCE_SKIN_PREFIX);
        f101030f = listOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(SkinResFactory.SKIN_THEME_APK_SAVE_DIR);
        String str = File.separator;
        sb5.append(str);
        sb5.append(QCircleSkinHelper.SKIN_ASSERT_PACKAGE_NAME);
        f101031g = sb5.toString();
        f101032h = SkinResFactory.SKIN_THEME_APK_SAVE_DIR + str + "version.conf";
        f101033i = SkinResFactory.SKIN_THEME_APK_SAVE_DIR + str + "qecommerce_skinurl.ini";
    }

    public ECEnableSkinManager() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SkinIniFile>() { // from class: com.tencent.ecommerce.base.ui.ECEnableSkinManager$urlIniFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SkinIniFile invoke() {
                Context context;
                context = ECEnableSkinManager.this.context;
                return new SkinIniFile(context);
            }
        });
        this.urlIniFile = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.ecommerce.base.ui.ECEnableSkinManager$skinLocalPath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Context context;
                StringBuilder sb5 = new StringBuilder();
                context = ECEnableSkinManager.this.context;
                sb5.append(context.getFilesDir());
                sb5.append(File.separator);
                sb5.append(QCircleSkinHelper.SKIN_ASSERT_PACKAGE_NAME);
                return sb5.toString();
            }
        });
        this.skinLocalPath = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.ecommerce.base.ui.ECEnableSkinManager$skinVersionLocalPath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Context context;
                StringBuilder sb5 = new StringBuilder();
                context = ECEnableSkinManager.this.context;
                sb5.append(context.getFilesDir());
                sb5.append(File.separator);
                sb5.append("version.conf");
                return sb5.toString();
            }
        });
        this.skinVersionLocalPath = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.base.ui.ECEnableSkinManager$mainScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.mainScope = lazy4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String g(String url) {
        boolean contains$default;
        int lastIndexOf$default;
        String replace$default;
        boolean contains$default2;
        boolean z16 = true;
        if (url.length() == 0) {
            return "";
        }
        if (n()) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QCircleSkinHelper.SKIN, false, 2, (Object) null);
        }
        z16 = false;
        if (!z16) {
            return url;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QCircleSkinHelper.SKIN_DEFAULT_MODE_TAG, false, 2, (Object) null);
        if (!contains$default) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, '.', 0, false, 6, (Object) null);
            if (lastIndexOf$default == -1) {
                return url;
            }
            StringBuilder sb5 = new StringBuilder();
            if (url != null) {
                String substring = url.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                sb5.append("_dark");
                String substring2 = url.substring(lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                sb5.append(substring2);
                return sb5.toString();
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(url, QCircleSkinHelper.SKIN_DEFAULT_MODE_TAG, QCircleSkinHelper.SKIN_DARK_MODE_TAG, false, 4, (Object) null);
        return replace$default;
    }

    private final CoroutineScope i() {
        return (CoroutineScope) this.mainScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        return (String) this.skinLocalPath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k() {
        return (String) this.skinVersionLocalPath.getValue();
    }

    private final String l(SkinIniFile iniFile, String token) {
        if (token.length() == 0) {
            return "";
        }
        String d16 = SkinIniFile.d(iniFile, QCircleSkinHelper.SKIN_IMAGE_URL_SECTION, token, null, 4, null);
        return d16 instanceof String ? d16 : "";
    }

    private final SkinIniFile m() {
        return (SkinIniFile) this.urlIniFile.getValue();
    }

    private final boolean n() {
        return QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNightManager().isNightMode();
    }

    private final boolean o() {
        if (!new File(j()).exists()) {
            return false;
        }
        SkinManager.g("com.tencent.ecommerce").loadSkinResource(j(), !QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getNightManager().isNightMode(), f101030f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object f(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ECEnableSkinManager$checkNeedUpdateSkinFile$2(this, null), continuation);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public int getColor(int resId) {
        if (n()) {
            return SkinManager.g("com.tencent.ecommerce").getColor(this.context, resId, ECResourcesTransformHelper.g().getStrResIdToTokenMap().get(String.valueOf(resId)));
        }
        return ResourcesCompat.getColor(this.context.getResources(), resId, null);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public Drawable getDrawable(int resId) {
        if (n()) {
            return SkinManager.g("com.tencent.ecommerce").getDrawable(this.context, resId, ECResourcesTransformHelper.g().getStrResIdToTokenMap().get(String.valueOf(resId)));
        }
        return ResourcesCompat.getDrawable(this.context.getResources(), resId, null);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public void getDrawableWithFetchCallback(String token, IECImageLoader.ImageLoaderOption option, final Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        getDrawable(token, option, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.base.ui.ECEnableSkinManager$getDrawableWithFetchCallback$1
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
        return new RFWSkinFactory2("com.tencent.ecommerce");
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECCoreSkinApi
    public String getUrl(String token) {
        return g(l(m(), token));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object h(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        cg0.a.b("ECSkin.ECEnableSkinManager", "copyAssetsToLocalFile");
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ECEnableSkinManager$copyAssetsToLocalFile$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public void init(Context context) {
        cg0.a.b("ECSkin.ECEnableSkinManager", "init");
        SkinManager.setContext(context);
        SkinManager.g("com.tencent.ecommerce").setResourceIdMap(ECResourcesTransformHelper.g().getStrResIdToIntResIdMap());
        SkinManager.g("com.tencent.ecommerce").setResourceIdAndNameMap(ECResourcesTransformHelper.g().getStrResIdToTokenMap());
        SkinIniFile.f(m(), f101033i, null, 2, null);
        BuildersKt__Builders_commonKt.launch$default(i(), null, null, new ECEnableSkinManager$init$1(this, null), 3, null);
    }

    @Override // com.tencent.ecommerce.base.ui.api.IECSkinApi
    public void loadResource() {
        cg0.a.b("ECSkin.ECEnableSkinManager", "loadResource, load skin = " + o());
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
        ECSkin eCSkin = ECSkin.INSTANCE;
        String url = eCSkin.getUrl(token);
        if (!(url == null || url.length() == 0)) {
            cg0.a.b("ECSkin.ECEnableSkinManager", "token=" + token + " is remote url: " + url);
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getImageLoader().fetchDrawable(this.context, url, option, callback);
            return;
        }
        cg0.a.b("ECSkin.ECEnableSkinManager", "token=" + token + " is local resource");
        callback.invoke(eCSkin.getDrawable(token));
    }
}
