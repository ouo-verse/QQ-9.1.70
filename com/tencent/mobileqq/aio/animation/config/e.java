package com.tencent.mobileqq.aio.animation.config;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.L;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.j;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b:\u0010;R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010(\u001a\u0004\b\u0011\u0010)\"\u0004\b*\u0010+R\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100R6\u00109\u001a\u0016\u0012\u0004\u0012\u000203\u0018\u000102j\n\u0012\u0004\u0012\u000203\u0018\u0001`48\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u00105\u001a\u0004\b \u00106\"\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/config/e;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "frequent", "b", "j", "t", "position", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "background", "d", "e", "o", "duration", "", "I", h.F, "()I", "r", "(I)V", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "k", "u", "value", "", "g", "Z", "l", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "isLarge", "", "J", "()J", DomainData.DOMAIN_NAME, "(J)V", "disappearTime", "Lcom/tencent/mobileqq/aio/animation/config/g;", "i", "Lcom/tencent/mobileqq/aio/animation/config/g;", "()Lcom/tencent/mobileqq/aio/animation/config/g;", "particleProperties", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/animation/config/f;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/util/ArrayList;)V", "imageInfos", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name */
    private static final int f188002l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f188003m;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String frequent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String position;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String background;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String duration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int imageType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String value;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isLarge;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long disappearTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g particleProperties;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<f> imageInfos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/config/e$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/animation/config/e;", "image", "Landroid/graphics/drawable/Drawable;", "a", "img", "b", "g", "e", "c", "", "str", "d", "", "f", "APNG", "Ljava/lang/String;", "EMOJI", "FACE", "GIF", "IMAGE", L.TAG, "PIC", "SIZE", "I", "SIZE_LARGE", "TYPE_APNG", "TYPE_EMOJI", "TYPE_FACE", "TYPE_GIF", "TYPE_IMAGE", "TYPE_LOTTIE", "TYPE_PIC", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.config.e$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        private final Drawable a(Context context, e image) {
            String str = com.tencent.mobileqq.aio.animation.util.b.f188159a.c() + image.k();
            try {
                return new ApngDrawable(new File(str), context.getResources());
            } catch (Exception e16) {
                QLog.e("AioAnimationRule", 1, "[getApngDrawable] get apng drawable error", e16);
                return null;
            } catch (OutOfMemoryError e17) {
                QLog.e("AioAnimationRule", 1, "[getApngDrawable] out of memory, exc=" + e17 + " path=" + str);
                return null;
            }
        }

        private final Drawable b(Context context, e img) {
            String str = com.tencent.mobileqq.aio.animation.util.b.f188159a.c() + img.k();
            String str2 = "JumpImage:" + str;
            ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
            Bitmap f16 = imageCacheHelper.f(str2);
            if (f16 == null) {
                f16 = j.c(str);
                if (f16 != null) {
                    imageCacheHelper.i(str2, f16, Business.AIO);
                } else if (QLog.isColorLevel()) {
                    QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + img.k());
                }
            }
            return new BitmapDrawable(context.getResources(), f16);
        }

        private final Drawable e(Context context, e img) {
            String str = com.tencent.mobileqq.aio.animation.util.b.f188159a.c() + img.k();
            try {
                return new GifDrawable(new File(str), context.getResources());
            } catch (Exception e16) {
                QLog.e("AioAnimationRule", 1, "[getGifDrawable] get gif drawable error", e16);
                return null;
            } catch (OutOfMemoryError e17) {
                QLog.e("AioAnimationRule", 1, "[getGifDrawable] out of memory, exc=" + e17 + " path=" + str);
                return null;
            }
        }

        private final Drawable g(Context context, e img) {
            Drawable b16 = b(context, img);
            float f16 = context.getResources().getDisplayMetrics().density;
            b16.setBounds(new Rect(0, 0, (int) (b16.getIntrinsicWidth() * f16), (int) (b16.getIntrinsicHeight() * f16)));
            return b16;
        }

        @Nullable
        public final Drawable c(@NotNull Context context, @NotNull e img) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) img);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(img, "img");
            int i3 = img.l() ? e.f188003m : e.f188002l;
            int h16 = img.h();
            if (h16 != 0) {
                if (h16 != 1) {
                    if (h16 != 2) {
                        if (h16 != 4) {
                            if (h16 != 5) {
                                if (h16 != 6) {
                                    return null;
                                }
                                return a(context, img);
                            }
                            return g(context, img);
                        }
                        return e(context, img);
                    }
                    String str = com.tencent.mobileqq.aio.animation.util.b.f188159a.c() + img.k();
                    String str2 = "JumpImage:" + str;
                    ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                    Bitmap f16 = imageCacheHelper.f(str2);
                    if (f16 == null) {
                        f16 = j.c(str);
                        if (f16 != null) {
                            imageCacheHelper.i(str2, f16, Business.AIO);
                        } else if (QLog.isColorLevel()) {
                            QLog.e("AioAnimationRule", 2, "decodeFile error, fileName: " + img.k());
                        }
                    }
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), f16);
                    bitmapDrawable.setBounds(new Rect(0, 0, i3, i3));
                    return bitmapDrawable;
                }
                Drawable d16 = d(img.k());
                if (d16 != null) {
                    d16.setBounds(new Rect(0, 0, i3, i3));
                    return d16;
                }
                return d16;
            }
            Integer index = Integer.valueOf(img.k());
            Intrinsics.checkNotNullExpressionValue(index, "index");
            if (index.intValue() < 0) {
                return null;
            }
            Drawable emojiDrawable = QQEmojiUtil.getEmojiDrawable(index.intValue());
            if (emojiDrawable != null) {
                emojiDrawable.setBounds(new Rect(0, 0, i3, i3));
                return emojiDrawable;
            }
            return emojiDrawable;
        }

        @Nullable
        public final Drawable d(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            int length = com.tencent.qqnt.emoji.a.SYS_EMOTICON_SYMBOL.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (Intrinsics.areEqual(str, com.tencent.qqnt.emoji.a.SYS_EMOTICON_SYMBOL[i3])) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AioAnimationRule", 2, "find str = " + str + ", index = " + i3);
                        }
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 < 0) {
                return null;
            }
            return com.tencent.qqnt.emotion.text.c.b(i3, false);
        }

        public final int f(@NotNull String str) {
            boolean equals;
            boolean equals2;
            boolean equals3;
            boolean equals4;
            boolean equals5;
            boolean equals6;
            boolean equals7;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
            }
            Intrinsics.checkNotNullParameter(str, "str");
            equals = StringsKt__StringsJVMKt.equals(str, "Emoji", true);
            if (!equals) {
                equals2 = StringsKt__StringsJVMKt.equals(str, "Face", true);
                if (!equals2) {
                    equals3 = StringsKt__StringsJVMKt.equals(str, "Apng", true);
                    if (!equals3) {
                        equals4 = StringsKt__StringsJVMKt.equals(str, "Image", true);
                        if (!equals4) {
                            equals5 = StringsKt__StringsJVMKt.equals(str, ComponentFactory.ComponentType.Lottie, true);
                            if (!equals5) {
                                equals6 = StringsKt__StringsJVMKt.equals(str, "Gif", true);
                                if (!equals6) {
                                    equals7 = StringsKt__StringsJVMKt.equals(str, "Pic", true);
                                    if (equals7) {
                                        return 5;
                                    }
                                    return -1;
                                }
                                return 4;
                            }
                            return 3;
                        }
                        return 2;
                    }
                    return 6;
                }
                return 1;
            }
            return 0;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        INSTANCE = new Companion(null);
        f188002l = l.b(32);
        f188003m = l.b(44);
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.particleProperties = new g();
        }
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.background;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.disappearTime;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.duration;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.frequent;
    }

    @Nullable
    public final ArrayList<f> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ArrayList) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.imageInfos;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.imageType;
    }

    @NotNull
    public final g i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (g) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.particleProperties;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.position;
    }

    @Nullable
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.value;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.isLarge;
    }

    public final void m(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.background = str;
        }
    }

    public final void n(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.disappearTime = j3;
        }
    }

    public final void o(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.duration = str;
        }
    }

    public final void p(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.frequent = str;
        }
    }

    public final void q(@Nullable ArrayList<f> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) arrayList);
        } else {
            this.imageInfos = arrayList;
        }
    }

    public final void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.imageType = i3;
        }
    }

    public final void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isLarge = z16;
        }
    }

    public final void t(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.position = str;
        }
    }

    public final void u(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.value = str;
        }
    }
}
