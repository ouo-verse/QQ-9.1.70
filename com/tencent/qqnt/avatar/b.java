package com.tencent.qqnt.avatar;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u0002\u0005\u000bB]\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u000b\u0010\u001fR\u0019\u0010$\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b\u0016\u0010#R\u0019\u0010)\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u001d\u0010(R\u0019\u0010.\u001a\u0004\u0018\u00010*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\u0005\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/avatar/b;", "", "", "toString", "", "a", "I", "getShape", "()I", "shape", "Lcom/tencent/qqnt/avatar/AvatarSizeType;", "b", "Lcom/tencent/qqnt/avatar/AvatarSizeType;", "getSize", "()Lcom/tencent/qqnt/avatar/AvatarSizeType;", "size", "c", "Ljava/lang/Integer;", "getDefaultIcon", "()Ljava/lang/Integer;", "defaultIcon", "Lcom/tencent/qqnt/avatar/d;", "d", "Lcom/tencent/qqnt/avatar/d;", "()Lcom/tencent/qqnt/avatar/d;", "f", "(Lcom/tencent/qqnt/avatar/d;)V", "progressListener", "Lcom/tencent/qqnt/avatar/c;", "e", "Lcom/tencent/qqnt/avatar/c;", "()Lcom/tencent/qqnt/avatar/c;", "outBoundInfo", "Lcom/tencent/qqnt/avatar/i;", "Lcom/tencent/qqnt/avatar/i;", "()Lcom/tencent/qqnt/avatar/i;", "vasAvatarData", "Lcom/tencent/qqnt/avatar/j;", "g", "Lcom/tencent/qqnt/avatar/j;", "()Lcom/tencent/qqnt/avatar/j;", "vasPendantData", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "oldDrawable", "<init>", "(ILcom/tencent/qqnt/avatar/AvatarSizeType;Ljava/lang/Integer;Lcom/tencent/qqnt/avatar/d;Lcom/tencent/qqnt/avatar/c;Lcom/tencent/qqnt/avatar/i;Lcom/tencent/qqnt/avatar/j;Landroid/graphics/drawable/Drawable;)V", "i", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int shape;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AvatarSizeType size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer defaultIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d progressListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c outBoundInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final i vasAvatarData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final j vasPendantData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable oldDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\f\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b\u001a\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010:\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u00106\u001a\u0004\b7\u00108\"\u0004\b\u0013\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/avatar/b$a;", "", "Lcom/tencent/qqnt/avatar/b;", "a", "", "I", "getShape", "()I", "f", "(I)V", "shape", "Lcom/tencent/qqnt/avatar/AvatarSizeType;", "b", "Lcom/tencent/qqnt/avatar/AvatarSizeType;", "getSize", "()Lcom/tencent/qqnt/avatar/AvatarSizeType;", "g", "(Lcom/tencent/qqnt/avatar/AvatarSizeType;)V", "size", "c", "Ljava/lang/Integer;", "getDefaultIcon", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "defaultIcon", "Lcom/tencent/qqnt/avatar/d;", "d", "Lcom/tencent/qqnt/avatar/d;", "getProgressListener", "()Lcom/tencent/qqnt/avatar/d;", "e", "(Lcom/tencent/qqnt/avatar/d;)V", "progressListener", "Lcom/tencent/qqnt/avatar/c;", "Lcom/tencent/qqnt/avatar/c;", "getOutBoundInfo", "()Lcom/tencent/qqnt/avatar/c;", "(Lcom/tencent/qqnt/avatar/c;)V", "outBoundInfo", "Lcom/tencent/qqnt/avatar/i;", "Lcom/tencent/qqnt/avatar/i;", "getVasAvatarData", "()Lcom/tencent/qqnt/avatar/i;", tl.h.F, "(Lcom/tencent/qqnt/avatar/i;)V", "vasAvatarData", "Lcom/tencent/qqnt/avatar/j;", "Lcom/tencent/qqnt/avatar/j;", "getVasPendantData", "()Lcom/tencent/qqnt/avatar/j;", "i", "(Lcom/tencent/qqnt/avatar/j;)V", "vasPendantData", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "getOldDrawable", "()Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "oldDrawable", "<init>", "()V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int shape;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AvatarSizeType size;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer defaultIcon;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private d progressListener;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private c outBoundInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private i vasAvatarData;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private j vasPendantData;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable oldDrawable;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.shape = 1;
                this.size = AvatarSizeType.SMALL;
            }
        }

        @NotNull
        public final b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (b) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return new b(this.shape, this.size, this.defaultIcon, this.progressListener, this.outBoundInfo, this.vasAvatarData, this.vasPendantData, this.oldDrawable);
        }

        public final void b(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) num);
            } else {
                this.defaultIcon = num;
            }
        }

        public final void c(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) drawable);
            } else {
                this.oldDrawable = drawable;
            }
        }

        public final void d(@Nullable c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) cVar);
            } else {
                this.outBoundInfo = cVar;
            }
        }

        public final void e(@Nullable d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
            } else {
                this.progressListener = dVar;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.shape = i3;
            }
        }

        public final void g(@NotNull AvatarSizeType avatarSizeType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) avatarSizeType);
            } else {
                Intrinsics.checkNotNullParameter(avatarSizeType, "<set-?>");
                this.size = avatarSizeType;
            }
        }

        public final void h(@Nullable i iVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) iVar);
            } else {
                this.vasAvatarData = iVar;
            }
        }

        public final void i(@Nullable j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) jVar);
            } else {
                this.vasPendantData = jVar;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/avatar/b$b;", "", "<init>", "()V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38780);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(int i3, @NotNull AvatarSizeType size, @Nullable Integer num, @Nullable d dVar, @Nullable c cVar, @Nullable i iVar, @Nullable j jVar, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(size, "size");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), size, num, dVar, cVar, iVar, jVar, drawable);
            return;
        }
        this.shape = i3;
        this.size = size;
        this.defaultIcon = num;
        this.progressListener = dVar;
        this.outBoundInfo = cVar;
        this.vasAvatarData = iVar;
        this.vasPendantData = jVar;
        this.oldDrawable = drawable;
    }

    @Nullable
    public final Drawable a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.oldDrawable;
    }

    @Nullable
    public final c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.outBoundInfo;
    }

    @Nullable
    public final d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.progressListener;
    }

    @Nullable
    public final i d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (i) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.vasAvatarData;
    }

    @Nullable
    public final j e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (j) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.vasPendantData;
    }

    public final void f(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
        } else {
            this.progressListener = dVar;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "AvatarOption(shape=" + this.shape + ", size=" + this.size + ",defaultIcon=" + this.defaultIcon + ")";
    }
}
