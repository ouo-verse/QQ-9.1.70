package com.tencent.qqnt.avatar.meta;

import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0002\u001b\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/b;", "Lcom/tencent/qqnt/avatar/meta/a;", "", "d", "", h.F, "Z", "needRequestUri", "Landroid/net/Uri;", "i", "Landroid/net/Uri;", "l", "()Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "j", "Lcom/tencent/qqnt/avatar/meta/b;", "downgradeBean", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "useHighPriority", DomainData.DOMAIN_NAME, RedTouchConst.PicDownload.ISCIRCLE, "Lcom/tencent/qqnt/avatar/meta/b$a;", "builder", "<init>", "(Lcom/tencent/qqnt/avatar/meta/b$a;)V", "a", "b", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends com.tencent.qqnt.avatar.meta.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean needRequestUri;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Uri uri;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b downgradeBean;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean useHighPriority;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final boolean isCircle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/b$b;", "", "", "KEY_BEAN_KEY_SUFFIX", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.meta.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39616);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ b(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar, (Object) defaultConstructorMarker);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    @Override // com.tencent.qqnt.avatar.meta.a, com.tencent.qqnt.avatar.bean.a
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() {
        boolean z16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String j3 = j("KEY_BEAN_KEY_SUFFIX");
        boolean z17 = false;
        if (j3 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(j3);
            if (!isBlank) {
                z16 = false;
                if (!z16 && this.isCircle) {
                    return super.d();
                }
                StringBuilder sb5 = new StringBuilder(super.d());
                if (!this.isCircle) {
                    sb5.append("_no_circle");
                }
                if (j3 != null || j3.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    sb5.append("_");
                    sb5.append(j3);
                }
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
                return sb6;
            }
        }
        z16 = true;
        if (!z16) {
        }
        StringBuilder sb52 = new StringBuilder(super.d());
        if (!this.isCircle) {
        }
        if (j3 != null) {
        }
        z17 = true;
        if (!z17) {
        }
        String sb62 = sb52.toString();
        Intrinsics.checkNotNullExpressionValue(sb62, "builder.toString()");
        return sb62;
    }

    @Nullable
    public final Uri l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Uri) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.uri;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.useHighPriority;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isCircle;
    }

    b(a aVar) {
        super(aVar.i(), aVar.c(), aVar.g(), aVar.j());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.uri = aVar.k();
        this.needRequestUri = aVar.h();
        k(new HashMap(aVar.e()));
        this.downgradeBean = aVar.d();
        this.useHighPriority = aVar.f();
        this.isCircle = aVar.l();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\f\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u00a2\u0006\u0004\b1\u00102B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u00a2\u0006\u0004\b1\u00103J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010 \u001a\u0004\b$\u0010\"\"\u0004\b%\u0010&R\u0017\u0010'\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b\u001f\u0010\"R#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010(8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b\u001a\u0010*R$\u00100\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010,\u001a\u0004\b\u0016\u0010-\"\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/b$a;", "", "", "key", "value", "a", "", RedTouchConst.PicDownload.ISCIRCLE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/avatar/meta/b;", "b", "", "I", "i", "()I", "resourceType", "c", "avatarType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "id", "d", "j", "size", "Landroid/net/Uri;", "e", "Landroid/net/Uri;", "k", "()Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "f", "Z", h.F, "()Z", "needRequestUri", "l", "setCircle", "(Z)V", "highPriority", "", "Ljava/util/Map;", "()Ljava/util/Map;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/qqnt/avatar/meta/b;", "()Lcom/tencent/qqnt/avatar/meta/b;", "setDowngradeBeanPri", "(Lcom/tencent/qqnt/avatar/meta/b;)V", "downgradeBeanPri", "<init>", "(ILjava/lang/String;IZ)V", "(Landroid/net/Uri;Z)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int resourceType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int avatarType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String id;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int size;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Uri uri;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean needRequestUri;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean isCircle;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean highPriority;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, Object> extraParams;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private b downgradeBeanPri;

        public a(int i3, @NotNull String id5, int i16, boolean z16) {
            Intrinsics.checkNotNullParameter(id5, "id");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), id5, Integer.valueOf(i16), Boolean.valueOf(z16));
                return;
            }
            this.isCircle = true;
            this.extraParams = new LinkedHashMap();
            this.avatarType = i3;
            this.id = id5;
            this.uri = null;
            this.size = i16;
            this.needRequestUri = true;
            this.highPriority = z16;
        }

        @NotNull
        public final a a(@NotNull String key, @NotNull Object value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (a) iPatchRedirector.redirect((short) 21, (Object) this, (Object) key, value);
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.extraParams.put(key, value);
            return this;
        }

        @NotNull
        public final b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (b) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return new b(this, null);
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.avatarType;
        }

        @Nullable
        public final b d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (b) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return this.downgradeBeanPri;
        }

        @NotNull
        public final Map<String, Object> e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Map) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.extraParams;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return this.highPriority;
        }

        @NotNull
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.id;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.needRequestUri;
        }

        public final int i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.resourceType;
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.size;
        }

        @Nullable
        public final Uri k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Uri) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.uri;
        }

        public final boolean l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isCircle;
        }

        @NotNull
        public final a m(boolean isCircle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (a) iPatchRedirector.redirect((short) 24, (Object) this, isCircle);
            }
            this.isCircle = isCircle;
            return this;
        }

        public /* synthetic */ a(int i3, String str, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, i16, (i17 & 8) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
                return;
            }
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
        }

        public a(@NotNull Uri uri, boolean z16) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, uri, Boolean.valueOf(z16));
                return;
            }
            this.isCircle = true;
            this.extraParams = new LinkedHashMap();
            this.uri = uri;
            this.avatarType = 0;
            this.id = "";
            this.size = 0;
            this.needRequestUri = false;
            this.highPriority = z16;
        }

        public /* synthetic */ a(Uri uri, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(uri, (i3 & 2) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                return;
            }
            iPatchRedirector.redirect((short) 20, this, uri, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }
}
