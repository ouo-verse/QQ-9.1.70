package com.tencent.mobileqq.widget.listitem;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.widget.Switch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u0005*\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u0005*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R.\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b0\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b\u001d\u0010\u0019R4\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R4\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R4\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R.\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b,\u0010\u0019R4\u00100\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010 \u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/CapabilityInjector;", "", "Landroid/widget/ImageView;", "", "url", "", "f", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "d", "", "drawableId", "e", "(Landroid/widget/ImageView;I)V", "Landroid/view/View;", "path", "g", "(Landroid/view/View;Ljava/lang/String;)V", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/widget/Button;", "b", "Lkotlin/jvm/functions/Function1;", "a", "()Lkotlin/jvm/functions/Function1;", tl.h.F, "(Lkotlin/jvm/functions/Function1;)V", "createRightButton", "Landroid/widget/CompoundButton;", "c", "i", "createSwitchButton", "Lkotlin/Function2;", "Lkotlin/jvm/functions/Function2;", "getLoadImage", "()Lkotlin/jvm/functions/Function2;", "l", "(Lkotlin/jvm/functions/Function2;)V", "loadImage", "getLoadAvatar", "k", "loadAvatar", "getLoadIcon", "setLoadIcon", "loadIcon", "j", "createTianshuRedPointView", "getLoadTianshuRedPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "loadTianshuRedPath", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class CapabilityInjector {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CapabilityInjector f316927a = new CapabilityInjector();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Function1<? super Context, ? extends Button> createRightButton = new Function1<Context, Button>() { // from class: com.tencent.mobileqq.widget.listitem.CapabilityInjector$createRightButton$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Button invoke(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            QUIButton qUIButton = new QUIButton(context);
            qUIButton.setType(1);
            qUIButton.setSizeType(2);
            return qUIButton;
        }
    };

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Function1<? super Context, ? extends CompoundButton> createSwitchButton = new Function1<Context, CompoundButton>() { // from class: com.tencent.mobileqq.widget.listitem.CapabilityInjector$createSwitchButton$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final CompoundButton invoke(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Switch r06 = new Switch(context);
            r06.setThumbResource(R.drawable.b57);
            r06.setTrackResource(R.drawable.b58);
            return r06;
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Function2<? super ImageView, ? super String, Unit> loadImage = new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.CapabilityInjector$loadImage$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ImageView imageView, @NotNull String url) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
            invoke2(imageView, str);
            return Unit.INSTANCE;
        }
    };

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Function2<? super ImageView, ? super String, Unit> loadAvatar = new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.CapabilityInjector$loadAvatar$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull ImageView imageView, @NotNull String url) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
            invoke2(imageView, str);
            return Unit.INSTANCE;
        }
    };

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Function2<? super ImageView, ? super Integer, Unit> loadIcon = new Function2<ImageView, Integer, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.CapabilityInjector$loadIcon$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, Integer num) {
            invoke(imageView, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull ImageView imageView, @DrawableRes int i3) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            imageView.setImageResource(i3);
        }
    };

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Function1<? super Context, ? extends View> createTianshuRedPointView = new Function1<Context, View>() { // from class: com.tencent.mobileqq.widget.listitem.CapabilityInjector$createTianshuRedPointView$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final View invoke(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new View(context);
        }
    };

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Function2<? super View, ? super String, Unit> loadTianshuRedPath = new Function2<View, String, Unit>() { // from class: com.tencent.mobileqq.widget.listitem.CapabilityInjector$loadTianshuRedPath$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull View view, @NotNull String path) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(path, "path");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
            invoke2(view, str);
            return Unit.INSTANCE;
        }
    };

    CapabilityInjector() {
    }

    @NotNull
    public final Function1<Context, Button> a() {
        return createRightButton;
    }

    @NotNull
    public final Function1<Context, CompoundButton> b() {
        return createSwitchButton;
    }

    @NotNull
    public final Function1<Context, View> c() {
        return createTianshuRedPointView;
    }

    public final void d(@NotNull ImageView imageView, @NotNull String url) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        loadImage.invoke(imageView, url);
    }

    public final void e(@NotNull ImageView imageView, @DrawableRes int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        loadIcon.invoke(imageView, Integer.valueOf(i3));
    }

    public final void f(@NotNull ImageView imageView, @NotNull String url) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        loadImage.invoke(imageView, url);
    }

    public final void g(@NotNull View view, @NotNull String path) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        loadTianshuRedPath.invoke(view, path);
    }

    public final void h(@NotNull Function1<? super Context, ? extends Button> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        createRightButton = function1;
    }

    public final void i(@NotNull Function1<? super Context, ? extends CompoundButton> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        createSwitchButton = function1;
    }

    public final void j(@NotNull Function1<? super Context, ? extends View> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        createTianshuRedPointView = function1;
    }

    public final void k(@NotNull Function2<? super ImageView, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        loadAvatar = function2;
    }

    public final void l(@NotNull Function2<? super ImageView, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        loadImage = function2;
    }

    public final void m(@NotNull Function2<? super View, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        loadTianshuRedPath = function2;
    }
}
