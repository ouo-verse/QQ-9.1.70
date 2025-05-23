package com.tencent.ams.mosaic.jsengine.component;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.layer.ImageLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.ShapeLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.TextLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.container.FrameLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.container.LinearLayer;
import com.tencent.ams.mosaic.jsengine.component.banner.BannerComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.button.ButtonComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.circleprogressbar.CircularProgressBarComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.clickshake.ClickShakeComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.clickshakebanner.ClickSlideShakeComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.container.FlexContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.container.FrameContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.container.LinearContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.container.pager.PagerContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.container.scrollview.HorizontalScrollContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.container.scrollview.ScrollContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.image.ImageComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.lottie.LottieComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.scroll.ScrollBannerComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.simpleFlip.SimpleFlipComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.slide.SlideComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.slideguide.SlideGuideComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.surface.SurfaceComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.twist.TwistComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.video.TransparentVideoImpl;
import com.tencent.ams.mosaic.jsengine.component.video.VideoComponentImpl;
import com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ComponentFactory implements IComponentFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Class<? extends Component>> f70940c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Class<? extends Component>> f70941d;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Context f70942a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final com.tencent.ams.mosaic.jsengine.a f70943b;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ComponentType {
        public static final String BANNER = "Banner";
        public static final String BUTTON = "Button";
        public static final String CIRCULAR_PROGRESS_BAR = "CircularProgressBar";
        public static final String CLICK_SHAKE = "ClickShake";
        public static final String CLICK_SLIDE_SCROLL = "ClickSlideScroll";
        public static final String CLICK_SLIDE_SHAKE = "ClickSlideShake";
        public static final String FLEX_CONTAINER = "FlexContainer";
        public static final String FLIPPED = "Flipped";
        public static final String FRAME_CONTAINER = "FrameContainer";
        public static final String GESTURE = "Gesture";
        public static final String HALF_ARC_SLOPE = "HalfArcSlope";
        public static final String HORIZONTAL_SCROLL_CONTAINER = "HorizontalScrollContainer";
        public static final String IMAGE = "Image";
        public static final String IMAGE_GALLERY = "ImageGallery";
        public static final String LINEAR_CONTAINER = "LinearContainer";
        public static final String Lottie = "Lottie";
        public static final String PAG = "PAG";
        public static final String PAGER_CONTAINER = "PagerContainer";
        public static final String SCRATCH_CARD = "ScratchCard";
        public static final String SCROLL_BANNER = "ScrollBanner";
        public static final String SCROLL_CONTAINER = "ScrollContainer";
        public static final String SHAPE = "Shape";
        public static final String SLIDE_GUIDE = "SlideGuide";
        public static final String SLIDE_PLUS = "SlidePlus";
        public static final String SLOPE_SLIDE = "SlopeSlide";
        public static final String SURFACE = "Surface";
        public static final String TEXT = "Text";
        public static final String TRANSPARENT_VIDEO = "TransparentVideo";
        public static final String TWIST = "Twist";
        public static final String VIDEO = "Video";
        public static final String WEBVIEW = "WebView";
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f70940c = new HashMap();
        f70941d = new HashMap();
        a("Text", TextComponentImpl.class);
        a("Image", ImageComponentImpl.class);
        a(ComponentType.VIDEO, VideoComponentImpl.class);
        a(ComponentType.FRAME_CONTAINER, FrameContainerImpl.class);
        a(ComponentType.LINEAR_CONTAINER, LinearContainerImpl.class);
        a(ComponentType.SCROLL_CONTAINER, ScrollContainerImpl.class);
        a(ComponentType.HORIZONTAL_SCROLL_CONTAINER, HorizontalScrollContainerImpl.class);
        if (MosaicUtils.D()) {
            a(ComponentType.FLEX_CONTAINER, FlexContainerImpl.class);
        }
        if (MosaicUtils.z()) {
            a(ComponentType.SURFACE, SurfaceComponentImpl.class);
            a(ComponentType.BANNER, BannerComponentImpl.class);
            a(ComponentType.GESTURE, GestureComponentImpl.class);
            a(ComponentType.SLIDE_GUIDE, SlideGuideComponentImpl.class);
            a(ComponentType.CLICK_SLIDE_SHAKE, ClickSlideShakeComponentImpl.class);
            a(ComponentType.CLICK_SHAKE, ClickShakeComponentImpl.class);
            a(ComponentType.SLOPE_SLIDE, SlopeSlideComponentImpl.class);
            a(ComponentType.TWIST, TwistComponentImpl.class);
            a(ComponentType.FLIPPED, SimpleFlipComponentImpl.class);
            a(ComponentType.HALF_ARC_SLOPE, HalfArcSlopeComponentImpl.class);
            if (MosaicUtils.C()) {
                a(ComponentType.CLICK_SLIDE_SCROLL, ClickSlideScrollComponentImpl.class);
                a(ComponentType.SCROLL_BANNER, ScrollBannerComponentImpl.class);
            }
            a(ComponentType.SLIDE_PLUS, SlideComponentImpl.class);
            a(ComponentType.TRANSPARENT_VIDEO, TransparentVideoImpl.class);
            if (MosaicUtils.B()) {
                a(ComponentType.SCRATCH_CARD, com.tencent.ams.mosaic.jsengine.component.scratch.a.class);
            }
        }
        if (com.tencent.ams.mosaic.utils.i.b()) {
            a(ComponentType.PAG, com.tencent.ams.mosaic.utils.i.a());
        }
        if (MosaicUtils.y("androidx.viewpager.widget.ViewPager")) {
            a(ComponentType.IMAGE_GALLERY, ImageGalleryComponentImpl.class);
            a(ComponentType.PAGER_CONTAINER, PagerContainerImpl.class);
        }
        a(ComponentType.BUTTON, ButtonComponentImpl.class);
        if (MosaicUtils.A()) {
            a(ComponentType.Lottie, LottieComponentImpl.class);
        }
        a("WebView", WebViewComponentImpl.class);
        a(ComponentType.CIRCULAR_PROGRESS_BAR, CircularProgressBarComponentImpl.class);
        if (MosaicUtils.z()) {
            b(ComponentType.FRAME_CONTAINER, FrameLayer.class);
            b(ComponentType.LINEAR_CONTAINER, LinearLayer.class);
            b("Image", ImageLayer.class);
            b("Text", TextLayer.class);
            b(ComponentType.SHAPE, ShapeLayer.class);
        }
    }

    public ComponentFactory(Context context, com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f70942a = context;
            this.f70943b = aVar;
        }
    }

    public static void a(String str, Class<? extends Component> cls) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            f70940c.put(str, cls);
        }
    }

    public static void b(String str, Class<? extends Component> cls) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            f70941d.put(str, cls);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.IComponentFactory
    public Component createComponent(String str, String str2, float f16, float f17) {
        Class<? extends Component> f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Component) iPatchRedirector.redirect((short) 2, this, str, str2, Float.valueOf(f16), Float.valueOf(f17));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.tencent.ams.mosaic.utils.f.e("ComponentFactory", "createComponent:" + str + ", id=" + str2 + ", width=" + f16 + ", height=" + f17);
        try {
            f18 = this.f70943b.f(str);
            if (f18 == null) {
                f18 = f70940c.get(str);
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("ComponentFactory", "create component failed: " + str, th5);
        }
        if (f18 != null) {
            Class<?> cls = Float.TYPE;
            Component newInstance = f18.getConstructor(Context.class, String.class, cls, cls).newInstance(this.f70942a, str2, Float.valueOf(f16), Float.valueOf(f17));
            newInstance.setJSEngine(this.f70943b);
            return newInstance;
        }
        com.tencent.ams.mosaic.utils.f.b("ComponentFactory", "component type not support: " + str);
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.IComponentFactory
    public Component createLayer(String str, String str2, float f16, float f17) {
        Class<? extends Component> t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Component) iPatchRedirector.redirect((short) 3, this, str, str2, Float.valueOf(f16), Float.valueOf(f17));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.tencent.ams.mosaic.utils.f.e("ComponentFactory", "createLayer:" + str + ", id=" + str2 + ", width=" + f16 + ", height=" + f17);
        try {
            t16 = this.f70943b.t(str);
            if (t16 == null) {
                t16 = f70941d.get(str);
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("ComponentFactory", "createLayer failed: " + str, th5);
        }
        if (t16 != null) {
            Class<?> cls = Float.TYPE;
            Component newInstance = t16.getConstructor(Context.class, String.class, cls, cls).newInstance(this.f70942a, str2, Float.valueOf(f16), Float.valueOf(f17));
            newInstance.setJSEngine(this.f70943b);
            return newInstance;
        }
        com.tencent.ams.mosaic.utils.f.b("ComponentFactory", "createLayer type not support: " + str);
        return null;
    }
}
