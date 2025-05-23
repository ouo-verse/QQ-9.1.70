package com.tencent.mobileqq.aio.msglist.holder.skin;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0004-\u0003\u0005\u0011B\u0007\u00a2\u0006\u0004\b+\u0010,R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010 \u001a\u0004\b\u0017\u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010&\u001a\u0004\b\u001b\u0010'\"\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "b", "()Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "i", "(Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;)V", "bubblePaddingInfo", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$BackgroundImageInfo;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$BackgroundImageInfo;", "()Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$BackgroundImageInfo;", h.F, "(Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$BackgroundImageInfo;)V", "background", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$b;", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$b;", "()Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$b;", "j", "(Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$b;)V", com.tencent.mobileqq.msf.core.net.r.a.f248963o, "d", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "voiceForeground", "e", "g", DomainData.DOMAIN_NAME, "voicePrintDrawable", "", "I", "()I", "k", "(I)V", "priority", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$c;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$c;", "()Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$c;", "l", "(Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$c;)V", "textInfo", "<init>", "()V", "BackgroundImageInfo", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOBubbleSkinInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.skin.padding.a bubblePaddingInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BackgroundImageInfo background;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b foreground;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b voiceForeground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b voicePrintDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int priority;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c textInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$BackgroundImageInfo;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$b;", "", "b", "I", "g", "()I", "i", "(I)V", "backgroundMinWidth", "c", "f", h.F, "backgroundMinHeight", "<init>", "()V", "d", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class BackgroundImageInfo extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private static final Lazy<Integer> f192403e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private static final Lazy<Integer> f192404f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        private static final Lazy<Boolean> f192405g;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int backgroundMinWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int backgroundMinHeight;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$BackgroundImageInfo$a;", "", "", "d", "MIN_WIDTH_WITH_TOKEN$delegate", "Lkotlin/Lazy;", "c", "()I", "MIN_WIDTH_WITH_TOKEN", "MIN_HEIGHT_WITH_TOKEN$delegate", "b", "MIN_HEIGHT_WITH_TOKEN", "", "minWidthSwitch$delegate", "e", "()Z", "minWidthSwitch", "MIN_HEIGHT_NOT_TOKEN", "I", "MIN_WIDTH_NOT_TOKEN", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo$BackgroundImageInfo$a, reason: from kotlin metadata */
        /* loaded from: classes11.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                    return;
                }
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int d() {
                if (e()) {
                    return ViewUtils.dip2px(62.0f);
                }
                return ViewUtils.dip2px(53.0f);
            }

            public final int b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return ((Number) BackgroundImageInfo.f192404f.getValue()).intValue();
            }

            public final int c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return ((Number) BackgroundImageInfo.f192403e.getValue()).intValue();
            }

            public final boolean e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
                }
                return ((Boolean) BackgroundImageInfo.f192405g.getValue()).booleanValue();
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            Lazy<Integer> lazy;
            Lazy<Integer> lazy2;
            Lazy<Boolean> lazy3;
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48947);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
                return;
            }
            INSTANCE = new Companion(null);
            lazy = LazyKt__LazyJVMKt.lazy(AIOBubbleSkinInfo$BackgroundImageInfo$Companion$MIN_WIDTH_WITH_TOKEN$2.INSTANCE);
            f192403e = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(AIOBubbleSkinInfo$BackgroundImageInfo$Companion$MIN_HEIGHT_WITH_TOKEN$2.INSTANCE);
            f192404f = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(AIOBubbleSkinInfo$BackgroundImageInfo$Companion$minWidthSwitch$2.INSTANCE);
            f192405g = lazy3;
        }

        public BackgroundImageInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.backgroundMinHeight;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.backgroundMinWidth;
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.backgroundMinHeight = i3;
            }
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.backgroundMinWidth = i3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$a;", "", "", "PRIORITY_DEFAULT", "I", "PRIORITY_VAS", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$b;", "", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "b", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable drawable;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final Drawable a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.drawable;
        }

        public final void b(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            } else {
                this.drawable = drawable;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u0012\u0010\u0007R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u001c\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u001e\u0010\u000e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo$c;", "", "", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "g", "(Ljava/lang/Integer;)V", "color", "Landroid/content/res/ColorStateList;", "b", "Landroid/content/res/ColorStateList;", "()Landroid/content/res/ColorStateList;", h.F, "(Landroid/content/res/ColorStateList;)V", NodeProps.COLORS, "c", "f", "l", "unit", "", "d", "Ljava/lang/Float;", "e", "()Ljava/lang/Float;", "k", "(Ljava/lang/Float;)V", "size", "i", "highlightColor", "j", "linkColor", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer color;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ColorStateList colors;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer unit;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Float size;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer highlightColor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ColorStateList linkColor;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final Integer a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.color;
        }

        @Nullable
        public final ColorStateList b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ColorStateList) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.colors;
        }

        @Nullable
        public final Integer c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Integer) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.highlightColor;
        }

        @Nullable
        public final ColorStateList d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (ColorStateList) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.linkColor;
        }

        @Nullable
        public final Float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Float) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.size;
        }

        @Nullable
        public final Integer f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Integer) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.unit;
        }

        public final void g(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
            } else {
                this.color = num;
            }
        }

        public final void h(@Nullable ColorStateList colorStateList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorStateList);
            } else {
                this.colors = colorStateList;
            }
        }

        public final void i(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) num);
            } else {
                this.highlightColor = num;
            }
        }

        public final void j(@Nullable ColorStateList colorStateList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) colorStateList);
            } else {
                this.linkColor = colorStateList;
            }
        }

        public final void k(@Nullable Float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) f16);
            } else {
                this.size = f16;
            }
        }

        public final void l(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) num);
            } else {
                this.unit = num;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48955);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOBubbleSkinInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final BackgroundImageInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BackgroundImageInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.background;
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.skin.padding.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bubblePaddingInfo;
    }

    @Nullable
    public final b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.foreground;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.priority;
    }

    @Nullable
    public final c e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (c) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.textInfo;
    }

    @Nullable
    public final b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.voiceForeground;
    }

    @Nullable
    public final b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.voicePrintDrawable;
    }

    public final void h(@Nullable BackgroundImageInfo backgroundImageInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) backgroundImageInfo);
        } else {
            this.background = backgroundImageInfo;
        }
    }

    public final void i(@Nullable com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.bubblePaddingInfo = aVar;
        }
    }

    public final void j(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.foreground = bVar;
        }
    }

    public final void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.priority = i3;
        }
    }

    public final void l(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) cVar);
        } else {
            this.textInfo = cVar;
        }
    }

    public final void m(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        } else {
            this.voiceForeground = bVar;
        }
    }

    public final void n(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            this.voicePrintDrawable = bVar;
        }
    }
}
