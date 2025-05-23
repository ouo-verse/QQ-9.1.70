package com.tencent.guild.aio.panel.photo;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", tl.h.F, "i", "Lcom/tencent/guild/aio/panel/photo/c$a;", "Lcom/tencent/guild/aio/panel/photo/c$b;", "Lcom/tencent/guild/aio/panel/photo/c$c;", "Lcom/tencent/guild/aio/panel/photo/c$d;", "Lcom/tencent/guild/aio/panel/photo/c$e;", "Lcom/tencent/guild/aio/panel/photo/c$f;", "Lcom/tencent/guild/aio/panel/photo/c$g;", "Lcom/tencent/guild/aio/panel/photo/c$h;", "Lcom/tencent/guild/aio/panel/photo/c$i;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class c implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$a;", "Lcom/tencent/guild/aio/panel/photo/c;", "Lcom/tencent/guild/api/media/album/e;", "d", "Lcom/tencent/guild/api/media/album/e;", "a", "()Lcom/tencent/guild/api/media/album/e;", "info", "<init>", "(Lcom/tencent/guild/api/media/album/e;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.guild.api.media.album.e info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull com.tencent.guild.api.media.album.e info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.guild.api.media.album.e getInfo() {
            return this.info;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$b;", "Lcom/tencent/guild/aio/panel/photo/c;", "", "d", "Z", "b", "()Z", "show", "", "e", UserInfo.SEX_FEMALE, "a", "()F", "ratio", "<init>", "(ZF)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean show;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float ratio;

        public b(boolean z16, float f16) {
            super(null);
            this.show = z16;
            this.ratio = f16;
        }

        /* renamed from: a, reason: from getter */
        public final float getRatio() {
            return this.ratio;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$c;", "Lcom/tencent/guild/aio/panel/photo/c;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.panel.photo.c$c, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1208c extends c {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final C1208c f112082d = new C1208c();

        C1208c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$d;", "Lcom/tencent/guild/aio/panel/photo/c;", "Lcom/tencent/guild/api/media/album/e;", "d", "Lcom/tencent/guild/api/media/album/e;", "a", "()Lcom/tencent/guild/api/media/album/e;", "info", "<init>", "(Lcom/tencent/guild/api/media/album/e;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.guild.api.media.album.e info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull com.tencent.guild.api.media.album.e info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.guild.api.media.album.e getInfo() {
            return this.info;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$e;", "Lcom/tencent/guild/aio/panel/photo/c;", "", "d", "Z", "a", "()Z", CustomImageProps.QUALITY, "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        public e(boolean z16) {
            super(null);
            this.quality = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getQuality() {
            return this.quality;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$f;", "Lcom/tencent/guild/aio/panel/photo/c;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f extends c {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final f f112085d = new f();

        f() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$g;", "Lcom/tencent/guild/aio/panel/photo/c;", "Lcom/tencent/guild/api/media/album/e;", "d", "Lcom/tencent/guild/api/media/album/e;", "a", "()Lcom/tencent/guild/api/media/album/e;", "info", "<init>", "(Lcom/tencent/guild/api/media/album/e;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.guild.api.media.album.e info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@NotNull com.tencent.guild.api.media.album.e info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.guild.api.media.album.e getInfo() {
            return this.info;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$h;", "Lcom/tencent/guild/aio/panel/photo/c;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class h extends c {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final h f112087d = new h();

        h() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/c$i;", "Lcom/tencent/guild/aio/panel/photo/c;", "Lcom/tencent/guild/api/media/album/e;", "d", "Lcom/tencent/guild/api/media/album/e;", "a", "()Lcom/tencent/guild/api/media/album/e;", "info", "<init>", "(Lcom/tencent/guild/api/media/album/e;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class i extends c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.guild.api.media.album.e info;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NotNull com.tencent.guild.api.media.album.e info) {
            super(null);
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.guild.api.media.album.e getInfo() {
            return this.info;
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}
