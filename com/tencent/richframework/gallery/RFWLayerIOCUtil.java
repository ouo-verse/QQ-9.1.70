package com.tencent.richframework.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.libra.IPicLoader;
import com.tencent.richframework.gallery.delegate.inner.IGalleryPageProvider;
import com.tencent.richframework.gallery.delegate.inner.INavigationBarImmersiveStrategy;
import com.tencent.richframework.gallery.delegate.inner.IVideoControlSection;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.delegate.inner.IVideoUIProvider;
import com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationInterceptor;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.IVideoControlLayoutChangeListener;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import com.tencent.richframework.video.IPlayerManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\tH\u0007J\u0018\u0010'\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000bH\u0007J\u0018\u0010)\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\rH\u0007J\u0018\u0010+\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fH\u0007J\u0018\u0010,\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0011H\u0007J\u0018\u0010.\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0013H\u0007J\u0018\u00100\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0015H\u0007J\u0018\u00102\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0017H\u0007J\u0018\u00104\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u001bH\u0007J\u0018\u00105\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u001dH\u0007J\u0018\u00107\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u001fH\u0007J\u0018\u00109\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010:\u001a\u00020!H\u0007J\u0018\u0010;\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0019H\u0007J\u0018\u0010<\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010=\u001a\u00020#H\u0007\u00a8\u0006>"}, d2 = {"Lcom/tencent/richframework/gallery/RFWLayerIOCUtil;", "", "()V", "getActivityContext", "Landroid/content/Context;", "context", "view", "Landroid/view/View;", "getControlVisibleChangeListener", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoControlLayoutChangeListener;", "getGalleryPageProvider", "Lcom/tencent/richframework/gallery/delegate/inner/IGalleryPageProvider;", "getLayerOperationInterceptor", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationInterceptor;", "getLayerOperationListener", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "getMediaProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "getNavigationBarImmersiveStrategy", "Lcom/tencent/richframework/gallery/delegate/inner/INavigationBarImmersiveStrategy;", "getPicLoaderFromView", "Lcom/tencent/libra/IPicLoader;", "getPicShowStrategy", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "getPlayStrategyProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "getPlayerManager", "Lcom/tencent/richframework/video/IPlayerManager;", "getSectionProvider", "Lcom/tencent/richframework/gallery/delegate/outer/IDelegateAndSectionProvider;", "getVideoControlProvider", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "getVideoControlSection", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoControlSection;", "getVideoUIProvider", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoUIProvider;", "registerControlVisibleChangeListener", "", "listener", "registerGalleryPageProvider", "galleryPageProvider", "registerLayerOperationInterceptor", "operationListener", "registerLayerOperationListener", "registerMediaProvider", "mediaProvider", "registerNavigationBarImmersiveStrategy", "navigationBarImmersive", "registerPicLoader", "picLoader", "registerPicShowStrategyProvider", "provider", "registerPlayerManager", "registerSectionProvider", "sectionProvider", "registerVideoControlProvider", "videoPlayerProvider", "registerVideoControlSection", "sectionViewProvider", "registerVideoPlayStrategyProvider", "registerVideoUIProvider", "uiProvider", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerIOCUtil {

    @NotNull
    public static final RFWLayerIOCUtil INSTANCE = new RFWLayerIOCUtil();

    RFWLayerIOCUtil() {
    }

    @JvmStatic
    @Nullable
    public static final IVideoControlLayoutChangeListener getControlVisibleChangeListener(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IVideoControlLayoutChangeListener) RFWIocAbilityProvider.g().getIocInterface(IVideoControlLayoutChangeListener.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IGalleryPageProvider getGalleryPageProvider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IGalleryPageProvider) RFWIocAbilityProvider.g().getIocInterface(IGalleryPageProvider.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final ILayerOperationInterceptor getLayerOperationInterceptor(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (ILayerOperationInterceptor) RFWIocAbilityProvider.g().getIocInterface(ILayerOperationInterceptor.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final ILayerOperationListener getLayerOperationListener(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (ILayerOperationListener) RFWIocAbilityProvider.g().getIocInterface(ILayerOperationListener.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IMediaProvider getMediaProvider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IMediaProvider) RFWIocAbilityProvider.g().getIocInterface(IMediaProvider.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final INavigationBarImmersiveStrategy getNavigationBarImmersiveStrategy(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (INavigationBarImmersiveStrategy) RFWIocAbilityProvider.g().getIocInterface(INavigationBarImmersiveStrategy.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IPicLoader getPicLoaderFromView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IPicLoader) RFWIocAbilityProvider.g().getIocInterface(IPicLoader.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IMediaShowStrategyProvider getPicShowStrategy(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IMediaShowStrategyProvider) RFWIocAbilityProvider.g().getIocInterface(IMediaShowStrategyProvider.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IVideoPlayStrategyProvider getPlayStrategyProvider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IVideoPlayStrategyProvider) RFWIocAbilityProvider.g().getIocInterface(IVideoPlayStrategyProvider.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IPlayerManager getPlayerManager(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IPlayerManager) RFWIocAbilityProvider.g().getIocInterface(IPlayerManager.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IDelegateAndSectionProvider getSectionProvider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IDelegateAndSectionProvider) RFWIocAbilityProvider.g().getIocInterface(IDelegateAndSectionProvider.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IVideoPlayerProvider getVideoControlProvider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IVideoPlayerProvider) RFWIocAbilityProvider.g().getIocInterface(IVideoPlayerProvider.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IVideoControlSection getVideoControlSection(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IVideoControlSection) RFWIocAbilityProvider.g().getIocInterface(IVideoControlSection.class, view, null);
    }

    @JvmStatic
    @Nullable
    public static final IVideoUIProvider getVideoUIProvider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (IVideoUIProvider) RFWIocAbilityProvider.g().getIocInterface(IVideoUIProvider.class, view, null);
    }

    @JvmStatic
    public static final void registerControlVisibleChangeListener(@NotNull View view, @NotNull IVideoControlLayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), listener, IVideoControlLayoutChangeListener.class);
    }

    @JvmStatic
    public static final void registerGalleryPageProvider(@NotNull View view, @NotNull IGalleryPageProvider galleryPageProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(galleryPageProvider, "galleryPageProvider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), galleryPageProvider, IGalleryPageProvider.class);
    }

    @JvmStatic
    public static final void registerLayerOperationInterceptor(@NotNull View view, @NotNull ILayerOperationInterceptor operationListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(operationListener, "operationListener");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), operationListener, ILayerOperationInterceptor.class);
    }

    @JvmStatic
    public static final void registerLayerOperationListener(@NotNull View view, @NotNull ILayerOperationListener operationListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(operationListener, "operationListener");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), operationListener, ILayerOperationListener.class);
    }

    @JvmStatic
    public static final void registerMediaProvider(@NotNull View view, @NotNull IMediaProvider mediaProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaProvider, "mediaProvider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), mediaProvider, IMediaProvider.class);
    }

    @JvmStatic
    public static final void registerNavigationBarImmersiveStrategy(@NotNull View view, @NotNull INavigationBarImmersiveStrategy navigationBarImmersive) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(navigationBarImmersive, "navigationBarImmersive");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), navigationBarImmersive, INavigationBarImmersiveStrategy.class);
    }

    @JvmStatic
    public static final void registerPicLoader(@NotNull View view, @NotNull IPicLoader picLoader) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(picLoader, "picLoader");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), picLoader, IPicLoader.class);
    }

    @JvmStatic
    public static final void registerPicShowStrategyProvider(@NotNull View view, @NotNull IMediaShowStrategyProvider provider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(provider, "provider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), provider, IMediaShowStrategyProvider.class);
    }

    @JvmStatic
    public static final void registerPlayerManager(@NotNull View view, @NotNull IPlayerManager provider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(provider, "provider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), provider, IPlayerManager.class);
    }

    @JvmStatic
    public static final void registerSectionProvider(@NotNull View view, @NotNull IDelegateAndSectionProvider sectionProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sectionProvider, "sectionProvider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), sectionProvider, IDelegateAndSectionProvider.class);
    }

    @JvmStatic
    public static final void registerVideoControlProvider(@NotNull View view, @NotNull IVideoPlayerProvider videoPlayerProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(videoPlayerProvider, "videoPlayerProvider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), videoPlayerProvider, IVideoPlayerProvider.class);
    }

    @JvmStatic
    public static final void registerVideoControlSection(@NotNull View view, @NotNull IVideoControlSection sectionViewProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sectionViewProvider, "sectionViewProvider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), sectionViewProvider, IVideoControlSection.class);
    }

    @JvmStatic
    public static final void registerVideoPlayStrategyProvider(@NotNull View view, @NotNull IVideoPlayStrategyProvider provider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(provider, "provider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), provider, IVideoPlayStrategyProvider.class);
    }

    @JvmStatic
    public static final void registerVideoUIProvider(@NotNull View view, @NotNull IVideoUIProvider uiProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uiProvider, "uiProvider");
        RFWIocAbilityProvider.g().registerGlobalIoc(INSTANCE.getActivityContext(view), uiProvider, IVideoUIProvider.class);
    }

    @NotNull
    public final Context getActivityContext(@NotNull View view) {
        View childAt;
        Context context;
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(view.getClass().getName(), "com.android.internal.policy.DecorView")) {
            ViewGroup viewGroup = (ViewGroup) (!(view instanceof ViewGroup) ? null : view);
            if (viewGroup != null && (childAt = viewGroup.getChildAt(0)) != null && (context = childAt.getContext()) != null) {
                return context;
            }
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            return context2;
        }
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        return context3;
    }

    @NotNull
    public final Context getActivityContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof ContextWrapper) || (context instanceof Activity)) {
            return context;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "context.baseContext");
        return baseContext;
    }
}
