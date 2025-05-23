package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000 >2\u00020\u0001:\u0002\u0003\u000bB\u0007\u00a2\u0006\u0004\bU\u0010VR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u0004\u0010\u000fR\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u000fR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0011\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\u0019\u0010*\"\u0004\b+\u0010,R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b.\u0010\bR\"\u00102\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u000fR\"\u00109\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010<\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00104\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\"\u0010?\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\f\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u000fR\"\u0010C\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u000fR\"\u0010E\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\bD\u0010\u000fR\"\u0010J\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010G\u001a\u0004\b@\u0010H\"\u0004\b4\u0010IR\"\u0010L\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010G\u001a\u0004\b\u0003\u0010H\"\u0004\bK\u0010IR$\u0010R\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010N\u001a\u0004\b!\u0010O\"\u0004\bP\u0010QR$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010N\u001a\u0004\b(\u0010O\"\u0004\bS\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "", "", "a", "I", "f", "()I", "y", "(I)V", "loop", "", "b", "Z", "p", "()Z", "(Z)V", "useStateCache", "c", "o", "H", "useFrameFileCache", "d", "k", BdhLogUtil.LogTag.Tag_Conn, "requestWidth", "e", "i", "B", "requestHeight", "j", "setRequestLayoutAfterDrawableChange", "requestLayoutAfterDrawableChange", "Lcom/tencent/cachedrawable/dynamicdrawable/c;", "g", "Lcom/tencent/cachedrawable/dynamicdrawable/c;", "()Lcom/tencent/cachedrawable/dynamicdrawable/c;", "v", "(Lcom/tencent/cachedrawable/dynamicdrawable/c;)V", "downloaderFactory", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", HippyTKDListViewAdapter.X, "(Landroid/graphics/drawable/Drawable;)V", "loadingDrawable", "w", "fitStyle", "r", "setMirror", "isMirror", "", UserInfo.SEX_FEMALE, "l", "()F", "D", "(F)V", "rx", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "ry", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", RedTouchConst.PicDownload.ISCIRCLE, DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "G", "isUse2BitmapMode", "u", "disableHardWare", "", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "sceneTag", "setBusinessTag", "businessTag", "", "[I", "()[I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "([I)V", "ninePatchXRegions", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "ninePatchYRegions", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private static final b f98975u;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int loop;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean useStateCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean useFrameFileCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int requestWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int requestHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean requestLayoutAfterDrawableChange;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.cachedrawable.dynamicdrawable.c downloaderFactory;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable loadingDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int fitStyle;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isMirror;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float rx;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float ry;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isCircle;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isUse2BitmapMode;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean disableHardWare;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sceneTag;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String businessTag;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] ninePatchXRegions;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] ninePatchYRegions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k$a;", "", "", "scene", "business", "a", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k$b;", "EMPTY_DRAWABLE", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k$b;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
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

        @NotNull
        public final String a(@NotNull String scene, @NotNull String business) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) scene, (Object) business);
            }
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(business, "business");
            return scene + util.base64_pad_url + business;
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k$b;", "Landroid/graphics/drawable/ColorDrawable;", "", "getIntrinsicHeight", "getIntrinsicWidth", "a", "I", "getW", "()I", "w", "b", "getH", tl.h.F, "<init>", "(II)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class b extends ColorDrawable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int w;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int h;

        public b(int i3, int i16) {
            super(0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.w = i3;
                this.h = i16;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.h;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.w;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            INSTANCE = new Companion(null);
            f98975u = new b(1, 1);
        }
    }

    public k() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.loop = -1;
        this.useStateCache = true;
        if (Build.VERSION.SDK_INT >= 26) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.useFrameFileCache = z16;
        this.requestLayoutAfterDrawableChange = true;
        this.downloaderFactory = com.tencent.cachedrawable.dynamicdrawable.business.download.b.f98861a;
        this.loadingDrawable = f98975u;
        this.sceneTag = "default";
        this.businessTag = "";
    }

    public final void A(@Nullable int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) iArr);
        } else {
            this.ninePatchYRegions = iArr;
        }
    }

    public final void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.requestHeight = i3;
        }
    }

    public final void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.requestWidth = i3;
        }
    }

    public final void D(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
        } else {
            this.rx = f16;
        }
    }

    public final void E(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Float.valueOf(f16));
        } else {
            this.ry = f16;
        }
    }

    public final void F(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sceneTag = str;
        }
    }

    public final void G(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.isUse2BitmapMode = z16;
        }
    }

    public final void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.useFrameFileCache = z16;
        }
    }

    public final void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.useStateCache = z16;
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.businessTag;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.disableHardWare;
    }

    @NotNull
    public final com.tencent.cachedrawable.dynamicdrawable.c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.cachedrawable.dynamicdrawable.c) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.downloaderFactory;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.fitStyle;
    }

    @Nullable
    public final Drawable e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Drawable) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.loadingDrawable;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.loop;
    }

    @Nullable
    public final int[] g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (int[]) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.ninePatchXRegions;
    }

    @Nullable
    public final int[] h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (int[]) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.ninePatchYRegions;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.requestHeight;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.requestLayoutAfterDrawableChange;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.requestWidth;
    }

    public final float l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Float) iPatchRedirector.redirect((short) 22, (Object) this)).floatValue();
        }
        return this.rx;
    }

    public final float m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Float) iPatchRedirector.redirect((short) 24, (Object) this)).floatValue();
        }
        return this.ry;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.sceneTag;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.useFrameFileCache;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.useStateCache;
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.isCircle;
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.isMirror;
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.isUse2BitmapMode;
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.isCircle = z16;
        }
    }

    public final void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.disableHardWare = z16;
        }
    }

    public final void v(@NotNull com.tencent.cachedrawable.dynamicdrawable.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.downloaderFactory = cVar;
        }
    }

    public final void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.fitStyle = i3;
        }
    }

    public final void x(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) drawable);
        } else {
            this.loadingDrawable = drawable;
        }
    }

    public final void y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.loop = i3;
        }
    }

    public final void z(@Nullable int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) iArr);
        } else {
            this.ninePatchXRegions = iArr;
        }
    }
}
