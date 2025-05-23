package com.tencent.android.gldrawable.api;

import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.base.AsyncDrawable;
import com.tencent.android.gldrawable.api.base.InternalApiImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0010H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/android/gldrawable/api/GLDrawableApi;", "Lcom/tencent/android/gldrawable/api/base/InternalApiImpl;", "()V", "state", "Lcom/tencent/android/gldrawable/api/GLDrawableApi$State;", "getState", "()Lcom/tencent/android/gldrawable/api/GLDrawableApi$State;", "state$delegate", "Lkotlin/Lazy;", "asyncFactory", "Lcom/tencent/android/gldrawable/api/base/AsyncDrawable;", "failedBlock", "Lkotlin/Function0;", "Landroid/graphics/drawable/Drawable;", "sucessBlock", "Lkotlin/Function1;", "Lcom/tencent/android/gldrawable/api/IFactoryStub;", DownloadInfo.spKey_Config, "Lcom/tencent/android/gldrawable/api/IConfigStub;", "factory", "State", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class GLDrawableApi extends InternalApiImpl {

    @NotNull
    public static final GLDrawableApi INSTANCE = new GLDrawableApi();

    /* renamed from: state$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy state;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/android/gldrawable/api/GLDrawableApi$State;", "", "()V", "isDynamicReady", "", "()Z", "isStaticModel", "testApk", "Ljava/io/File;", "getTestApk", "()Ljava/io/File;", "api_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class State {
        @NotNull
        public final File getTestApk() {
            return GLDrawableApi.INSTANCE.getLoader().getLoaderUtils().getTestApkFile();
        }

        public final boolean isDynamicReady() {
            return GLDrawableApi.INSTANCE.isDynamicReady();
        }

        public final boolean isStaticModel() {
            return GLDrawableApi.INSTANCE.getLoader().getIsStatic();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<State>() { // from class: com.tencent.android.gldrawable.api.GLDrawableApi$state$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GLDrawableApi.State invoke() {
                return new GLDrawableApi.State();
            }
        });
        state = lazy;
    }

    GLDrawableApi() {
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final AsyncDrawable asyncFactory(@NotNull Function1<? super IFactoryStub, ? extends Drawable> function1) {
        return asyncFactory$default(null, function1, 1, null);
    }

    public static /* synthetic */ AsyncDrawable asyncFactory$default(Function0 function0, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = new Function0() { // from class: com.tencent.android.gldrawable.api.GLDrawableApi$asyncFactory$1
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Void invoke() {
                    return null;
                }
            };
        }
        return asyncFactory(function0, function1);
    }

    @JvmStatic
    @NotNull
    public static final IConfigStub config() {
        IConfigStub iConfigStub;
        GLDrawableApi gLDrawableApi = INSTANCE;
        gLDrawableApi.loadDynamicSync$api_release();
        if (gLDrawableApi.isDynamicReady()) {
            iConfigStub = gLDrawableApi.createDynamicConfig();
        } else {
            iConfigStub = null;
        }
        if (iConfigStub == null) {
            return gLDrawableApi.createStaticConfig();
        }
        return iConfigStub;
    }

    @JvmStatic
    @NotNull
    public static final IFactoryStub factory() {
        IFactoryStub iFactoryStub;
        GLDrawableApi gLDrawableApi = INSTANCE;
        gLDrawableApi.loadDynamicSync$api_release();
        if (gLDrawableApi.isDynamicReady()) {
            iFactoryStub = gLDrawableApi.createDynamicFactory();
        } else {
            iFactoryStub = null;
        }
        if (iFactoryStub == null) {
            return gLDrawableApi.createStaticFactory();
        }
        return iFactoryStub;
    }

    @NotNull
    public final State getState() {
        return (State) state.getValue();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final AsyncDrawable asyncFactory(@NotNull Function0<? extends Drawable> failedBlock, @NotNull final Function1<? super IFactoryStub, ? extends Drawable> sucessBlock) {
        Intrinsics.checkNotNullParameter(failedBlock, "failedBlock");
        Intrinsics.checkNotNullParameter(sucessBlock, "sucessBlock");
        AsyncDrawable asyncDrawable = new AsyncDrawable();
        asyncDrawable.setFailedDrawableBuild$api_release(failedBlock);
        asyncDrawable.setTargetDrawableBuild$api_release(new Function0<Drawable>() { // from class: com.tencent.android.gldrawable.api.GLDrawableApi$asyncFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                return (Drawable) Function1.this.invoke(GLDrawableApi.factory());
            }
        });
        asyncDrawable.build$api_release();
        return asyncDrawable;
    }
}
