package com.tencent.qqnt.qbasealbum.urldrawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.utils.URLDrawableHelper;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/FlowThumbDecoder;", "Lcom/tencent/qqnt/qbasealbum/urldrawable/c;", "Ljava/net/URL;", "url", "Landroid/graphics/Bitmap;", "getBitmap", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "c", "Companion", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class FlowThumbDecoder implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    private static float f361590d;

    /* renamed from: e, reason: collision with root package name */
    private static float f361591e;

    /* renamed from: f, reason: collision with root package name */
    private static float f361592f;

    /* renamed from: g, reason: collision with root package name */
    private static float f361593g;

    /* renamed from: h, reason: collision with root package name */
    private static float f361594h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo info;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002J2\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ \u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010(\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u0014\u0010+\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/FlowThumbDecoder$Companion;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "Landroid/graphics/BitmapFactory$Options;", "opts", "Landroid/graphics/Bitmap;", "k", "", "outSize", "reqSize", "b", "originW", "originH", "i", HippyQQPagViewController.PropertyName.SCALE_MODE, "l", "bw", "bh", "orientation", "Landroid/graphics/Rect;", "d", "", "c", "j", "", "sFlowItemMaxWidth", UserInfo.SEX_FEMALE, "e", "()F", "setSFlowItemMaxWidth", "(F)V", "sFlowItemMinWidth", "f", "setSFlowItemMinWidth", "sRatioMax", "g", "setSRatioMax", "sRatioMin", tl.h.F, "setSRatioMin", "SCALE_MODE_ERROR", "I", "SCALE_MODE_MAX_WIDTH", "SCALE_MODE_MIN_WIDTH", "SCALE_MODE_NORMAL", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return;
            }
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) defaultConstructorMarker);
        }

        private final int b(int outSize, int reqSize) {
            int i3 = 1;
            while (outSize > 1.2f * reqSize) {
                i3 *= 2;
                outSize /= 2;
            }
            return i3;
        }

        private final Rect d(LocalMediaInfo info, int scaleMode, int bw5, int bh5, int orientation) {
            if (scaleMode != 1) {
                if (scaleMode != 2) {
                    return null;
                }
                if (orientation != 90 && orientation != 270) {
                    int thumbWidth = (info.getThumbWidth() * bh5) / info.getThumbHeight();
                    int i3 = (bw5 - thumbWidth) / 2;
                    return new Rect(i3, 0, thumbWidth + i3, bh5);
                }
                int thumbHeight = (info.getThumbHeight() * bw5) / info.getThumbWidth();
                int i16 = (bh5 - thumbHeight) / 2;
                return new Rect(0, i16, bw5, thumbHeight + i16);
            }
            if (orientation != 90 && orientation != 270) {
                int thumbHeight2 = (info.getThumbHeight() * bw5) / info.getThumbWidth();
                int i17 = (bh5 - thumbHeight2) / 2;
                return new Rect(0, i17, bw5, thumbHeight2 + i17);
            }
            int thumbWidth2 = (info.getThumbWidth() * bh5) / info.getThumbHeight();
            int i18 = (bw5 - thumbWidth2) / 2;
            return new Rect(i18, 0, thumbWidth2 + i18, bh5);
        }

        private final int i(LocalMediaInfo info, int originW, int originH) {
            float f16;
            float f17;
            boolean z16;
            if (originW != 0 && originH != 0) {
                if (info.getOrientation() != 90 && info.getOrientation() != 270) {
                    f16 = originW;
                    f17 = originH;
                } else {
                    f16 = originH;
                    f17 = originW;
                }
                float f18 = f16 / f17;
                float h16 = h();
                if (f18 <= g() && h16 <= f18) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return 0;
                }
                if (f18 < h()) {
                    return 1;
                }
                return 2;
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bitmap k(Context context, LocalMediaInfo info, BitmapFactory.Options opts) {
            Bitmap bitmap;
            if (com.tencent.qqnt.qbasealbum.ktx.b.n(info)) {
                return DecoderUtil.c(info, opts, "QBaseAlbum.Decoder");
            }
            if (!com.tencent.qqnt.qbasealbum.ktx.b.o(info)) {
                return null;
            }
            String path = info.getPath();
            if (path != null) {
                bitmap = f11.c.m(path);
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                opts.outHeight = bitmap.getHeight();
                opts.outWidth = bitmap.getWidth();
                return bitmap;
            }
            return bitmap;
        }

        private final Bitmap l(LocalMediaInfo info, int scaleMode, Bitmap b16) {
            int width = b16.getWidth();
            int height = b16.getHeight();
            int orientation = info.getOrientation();
            if (scaleMode == 0 && DecoderUtil.b(info, b16, orientation)) {
                return b16;
            }
            final Rect d16 = d(info, scaleMode, width, height, orientation);
            final Rect rect = new Rect(0, 0, info.getThumbWidth(), info.getThumbHeight());
            Bitmap createBitmap = Bitmap.createBitmap(info.getThumbWidth(), info.getThumbHeight(), Bitmap.Config.RGB_565);
            if (createBitmap != null) {
                new Canvas(createBitmap).drawBitmap(b16, d16, rect, new Paint(6));
                b16.recycle();
                if (orientation != 0) {
                    createBitmap = DecoderUtil.d(createBitmap, orientation);
                }
                ox3.a.g("QBaseAlbum.Decoder", new Function0<String>(d16, rect) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.FlowThumbDecoder$Companion$scaleBitmap$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Rect $dst;
                    final /* synthetic */ Rect $src;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$src = d16;
                        this.$dst = rect;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) d16, (Object) rect);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "FlowThumbDecoder src " + this.$src + ", dst " + this.$dst;
                    }
                });
                return createBitmap;
            }
            return null;
        }

        public final void c(@NotNull LocalMediaInfo info, int originW, int originH) {
            float f16;
            float f17;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, info, Integer.valueOf(originW), Integer.valueOf(originH));
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            int i16 = i(info, originW, originH);
            if (info.getThumbWidth() <= 0) {
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            f17 = e();
                        }
                    } else {
                        f17 = f();
                    }
                    i3 = (int) f17;
                } else {
                    i3 = (info.getThumbHeight() * originW) / originH;
                }
                info.setThumbWidth(i3);
                return;
            }
            if (info.getThumbHeight() <= 0) {
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            f16 = e();
                        }
                    } else {
                        f16 = f();
                    }
                    i3 = (int) f16;
                } else {
                    i3 = (info.getThumbWidth() * originH) / originW;
                }
                info.setThumbHeight(i3);
            }
        }

        public final float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return FlowThumbDecoder.f361591e;
            }
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }

        public final float f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return FlowThumbDecoder.f361592f;
            }
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }

        public final float g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return FlowThumbDecoder.f361593g;
            }
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }

        public final float h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return FlowThumbDecoder.f361594h;
            }
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }

        @Nullable
        public final Bitmap j(@NotNull Context context, @NotNull final LocalMediaInfo info, @NotNull BitmapFactory.Options opts) {
            int b16;
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Bitmap) iPatchRedirector.redirect((short) 13, this, context, info, opts);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(opts, "opts");
            int i3 = i(info, opts.outWidth, opts.outHeight);
            if (i3 != 1) {
                if (i3 != 2) {
                    b16 = b(opts.outWidth, info.getThumbWidth());
                } else {
                    b16 = b(opts.outHeight, info.getThumbHeight());
                }
            } else {
                b16 = b(opts.outWidth, info.getThumbWidth());
            }
            opts.inSampleSize = b16;
            try {
                bitmap = k(context, info, opts);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                bitmap = null;
            }
            if (bitmap == null) {
                ox3.a.c("QBaseAlbum.Decoder", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.urldrawable.FlowThumbDecoder$Companion$getScaledBitmap$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        String path = LocalMediaInfo.this.getPath();
                        String path2 = LocalMediaInfo.this.getPath();
                        return "FlowThumbDecoder bitmap is null, path: " + path + ", isExist: " + (path2 != null ? Boolean.valueOf(new File(path2).exists()) : null);
                    }
                });
                ox3.a.d("QBaseAlbum.Decoder", FlowThumbDecoder$Companion$getScaledBitmap$2.INSTANCE);
                return null;
            }
            return l(info, i3, bitmap);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlowThumbDecoder(@NotNull Context context, @NotNull LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) info);
            return;
        }
        this.context = context;
        this.info = info;
        f361590d = context.getResources().getDimension(R.dimen.cym);
        f361591e = context.getResources().getDimension(R.dimen.cyk);
        float dimension = context.getResources().getDimension(R.dimen.cyl);
        f361592f = dimension;
        float f16 = f361591e;
        float f17 = f361590d;
        f361593g = f16 / f17;
        f361594h = dimension / f17;
        if (!(f17 == 0.0f)) {
        } else {
            throw new RuntimeException("Not init item size...");
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.urldrawable.c
    @Nullable
    public Bitmap getBitmap(@NotNull URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        final int b16 = URLDrawableHelper.f361631a.b(this.info.getPath());
        if (b16 != 0 && b16 != this.info.getOrientation()) {
            ox3.a.f("QBaseAlbum.Decoder", new Function0<String>(b16, this) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.FlowThumbDecoder$getBitmap$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $orientation;
                final /* synthetic */ FlowThumbDecoder this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$orientation = b16;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, b16, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    LocalMediaInfo localMediaInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    int i3 = this.$orientation;
                    localMediaInfo = this.this$0.info;
                    return "FlowThumbDecoder, orientation:" + i3 + " info orientation:" + localMediaInfo.getOrientation();
                }
            });
            this.info.setOrientation(b16);
        }
        if (b16 != 90 && b16 != 270) {
            this.info.setThumbWidth(0);
            this.info.setThumbHeight((int) f361590d);
        } else {
            this.info.setThumbWidth((int) f361590d);
            this.info.setThumbHeight(0);
        }
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Companion companion = INSTANCE;
        companion.k(this.context, this.info, options);
        if (options.outWidth != 0 && options.outHeight != 0) {
            ox3.a.g("QBaseAlbum.Decoder", new Function0<String>(options) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.FlowThumbDecoder$getBitmap$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ BitmapFactory.Options $opts;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$opts = options;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) options);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    BitmapFactory.Options options2 = this.$opts;
                    return "FlowThumbDecoder origin w " + options2.outWidth + " h " + options2.outHeight;
                }
            });
            options.inJustDecodeBounds = false;
            if (this.info.getThumbWidth() <= 0 || this.info.getThumbHeight() <= 0) {
                companion.c(this.info, options.outWidth, options.outHeight);
            }
            Bitmap j3 = companion.j(this.context, this.info, options);
            Intrinsics.checkNotNull(j3);
            return j3;
        }
        return null;
    }
}
