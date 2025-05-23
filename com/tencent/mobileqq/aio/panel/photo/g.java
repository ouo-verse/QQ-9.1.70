package com.tencent.mobileqq.aio.panel.photo;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g;", "Lat/c;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "Lcom/tencent/mobileqq/aio/panel/photo/g$a;", "Lcom/tencent/mobileqq/aio/panel/photo/g$b;", "Lcom/tencent/mobileqq/aio/panel/photo/g$c;", "Lcom/tencent/mobileqq/aio/panel/photo/g$d;", "Lcom/tencent/mobileqq/aio/panel/photo/g$e;", "Lcom/tencent/mobileqq/aio/panel/photo/g$f;", "Lcom/tencent/mobileqq/aio/panel/photo/g$g;", "Lcom/tencent/mobileqq/aio/panel/photo/g$h;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class g implements at.c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$a;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LocalMediaInfo info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull LocalMediaInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
            } else {
                this.info = info;
            }
        }

        @NotNull
        public final LocalMediaInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$b;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f193095d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64492);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f193095d = new b();
            }
        }

        b() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$c;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "", "d", "Z", "b", "()Z", "show", "", "e", UserInfo.SEX_FEMALE, "a", "()F", "ratio", "<init>", "(ZF)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float ratio;

        public c(boolean z16, float f16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Float.valueOf(f16));
            } else {
                this.show = z16;
                this.ratio = f16;
            }
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
            }
            return this.ratio;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.show;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$d;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "", "e", "I", "a", "()I", "b", "(I)V", "height", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final d f193098d;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static int height;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64494);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f193098d = new d();
            }
        }

        d() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return height;
        }

        public final void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                height = i3;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$e;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LocalMediaInfo info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull LocalMediaInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
            } else {
                this.info = info;
            }
        }

        @NotNull
        public final LocalMediaInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$f;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LocalMediaInfo info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull LocalMediaInfo info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
            } else {
                this.info = info;
            }
        }

        @NotNull
        public final LocalMediaInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$g;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "", "d", "Z", "a", "()Z", CustomImageProps.QUALITY, "<init>", "(Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.photo.g$g, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7339g extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        public C7339g(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.quality = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.quality;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/g$h;", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "d", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "e", "Z", "b", "()Z", CustomImageProps.QUALITY, "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class h extends g {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LocalMediaInfo info;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull LocalMediaInfo info, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, info, Boolean.valueOf(z16));
            } else {
                this.info = info;
                this.quality = z16;
            }
        }

        @NotNull
        public final LocalMediaInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.info;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.quality;
        }

        public /* synthetic */ h(LocalMediaInfo localMediaInfo, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(localMediaInfo, (i3 & 2) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, localMediaInfo, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
