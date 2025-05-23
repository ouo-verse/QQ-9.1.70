package com.tencent.qqnt.avatar.combine;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sv3.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B\u0011\b\u0002\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R$\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0005\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/avatar/combine/a;", "", "", "b", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "", "I", "getSize", "()I", "setSize", "(I)V", "size", "c", "getGap", "setGap", "gap", "d", "getGapColor", "setGapColor", "gapColor", "Lcom/tencent/qqnt/avatar/combine/b;", "e", "Lcom/tencent/qqnt/avatar/combine/b;", "()Lcom/tencent/qqnt/avatar/combine/b;", "setListener", "(Lcom/tencent/qqnt/avatar/combine/b;)V", "listener", "", "Landroid/graphics/Bitmap;", "f", "[Landroid/graphics/Bitmap;", "getBitmaps", "()[Landroid/graphics/Bitmap;", "setBitmaps", "([Landroid/graphics/Bitmap;)V", "bitmaps", "Lcom/tencent/qqnt/avatar/combine/a$a;", "builder", "<init>", "(Lcom/tencent/qqnt/avatar/combine/a$a;)V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int gap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int gapColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.combine.b listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bitmap[] bitmaps;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b*\u0010+J\u001f\u0010\u0006\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\b\u0004J\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R,\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010%\u001a\u0004\b\u000f\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/avatar/combine/a$a;", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "init", h.F, "Lcom/tencent/qqnt/avatar/combine/a;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "c", "()Landroid/content/Context;", "context", "", "b", "I", "g", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "size", "d", "j", "gap", "e", "k", "gapColor", "Lcom/tencent/qqnt/avatar/combine/b;", "Lcom/tencent/qqnt/avatar/combine/b;", "f", "()Lcom/tencent/qqnt/avatar/combine/b;", "l", "(Lcom/tencent/qqnt/avatar/combine/b;)V", "listener", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "()[Landroid/graphics/Bitmap;", "i", "([Landroid/graphics/Bitmap;)V", "bitmaps", "<init>", "(Landroid/content/Context;)V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.combine.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9506a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int size;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int gap;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int gapColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.qqnt.avatar.combine.b listener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap[] bitmaps;

        @JvmOverloads
        public C9506a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            } else {
                this.context = context;
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (a) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            if (this.bitmaps != null) {
                return new a(this, null);
            }
            throw new IllegalArgumentException("the params argument is null");
        }

        @Nullable
        public final Bitmap[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Bitmap[]) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.bitmaps;
        }

        @NotNull
        public final Context c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.context;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.gap;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.gapColor;
        }

        @Nullable
        public final com.tencent.qqnt.avatar.combine.b f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (com.tencent.qqnt.avatar.combine.b) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.listener;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.size;
        }

        public final void h(@NotNull Function1<? super C9506a, Unit> init) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) init);
            } else {
                Intrinsics.checkNotNullParameter(init, "init");
                init.invoke(this);
            }
        }

        public final void i(@Nullable Bitmap[] bitmapArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) bitmapArr);
            } else {
                this.bitmaps = bitmapArr;
            }
        }

        public final void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.gap = i3;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.gapColor = i3;
            }
        }

        public final void l(@Nullable com.tencent.qqnt.avatar.combine.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            } else {
                this.listener = bVar;
            }
        }

        public final void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.size = i3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/avatar/combine/a$b", "Lsv3/a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements sv3.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // sv3.a
        public void a(@Nullable Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
                return;
            }
            com.tencent.qqnt.avatar.combine.b a16 = a.this.a();
            if (a16 != null) {
                a16.a(bitmap);
            }
        }

        @Override // sv3.a
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                a.C11256a.a(this);
            }
        }
    }

    public /* synthetic */ a(C9506a c9506a, DefaultConstructorMarker defaultConstructorMarker) {
        this(c9506a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) c9506a, (Object) defaultConstructorMarker);
    }

    @Nullable
    public final com.tencent.qqnt.avatar.combine.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.qqnt.avatar.combine.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.listener;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.qqnt.avatar.business.bitmap.a aVar = new com.tencent.qqnt.avatar.business.bitmap.a(this.context);
        aVar.k(this.bitmaps);
        aVar.m(this.gap);
        aVar.n(this.gapColor);
        aVar.r(this.size);
        aVar.o(new com.tencent.qqnt.avatar.combine.layout.a());
        aVar.q(new b());
        aVar.a();
    }

    a(C9506a c9506a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c9506a);
            return;
        }
        this.context = c9506a.c();
        this.size = c9506a.g();
        this.gap = c9506a.d();
        this.gapColor = c9506a.e();
        this.listener = c9506a.f();
        Bitmap[] b16 = c9506a.b();
        Intrinsics.checkNotNull(b16);
        this.bitmaps = b16;
    }
}
