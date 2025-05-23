package com.tencent.mobileqq.proavatar;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0002\u0004\u0002B\u0083\u0001\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\t\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010,\u001a\u00020(\u0012\u0006\u0010-\u001a\u00020\u0003\u00a2\u0006\u0004\b.\u0010/J\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u0017\u0010\u001b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0017\u0010#\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR\u0017\u0010%\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010'\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b&\u0010\u0007R\u0017\u0010+\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b$\u0010*R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b!\u0010*R\u0017\u0010-\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/proavatar/e;", "", "b", "", "a", "I", "l", "()I", "size", "", "Z", tl.h.F, "()Z", "enableZplanOutbound", "c", "d", "enableDynamicAvatar", "f", "enableVasPendant", "e", "o", "vasPendantTarget", "enableVasAvatar", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "vasAvatarShopSource", DomainData.DOMAIN_NAME, "vasAvatarUseSource", "Landroid/graphics/drawable/Drawable;", "i", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", "j", "getHighPriority", "highPriority", "k", "enableVideoAvatar", "p", "videoAvatarSource", "", "Ljava/lang/String;", "()Ljava/lang/String;", "peerUin", "peerUid", "avatarAperture", "<init>", "(IZZZIZIILandroid/graphics/drawable/Drawable;ZZILjava/lang/String;Ljava/lang/String;I)V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int size;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean enableZplanOutbound;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean enableDynamicAvatar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVasPendant;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int vasPendantTarget;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVasAvatar;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int vasAvatarShopSource;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int vasAvatarUseSource;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable loadingDrawable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean highPriority;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean enableVideoAvatar;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int videoAvatarSource;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int avatarAperture;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u00107\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\b\b\u0002\u0010?\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010I\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\bU\u0010VJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010,\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\"\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010'\u001a\u0004\b5\u0010)\"\u0004\b6\u0010+R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010'\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010'\u001a\u0004\b=\u0010)\"\u0004\b>\u0010+R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010,\u001a\u0004\bE\u0010.\"\u0004\bF\u00100R\"\u0010I\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010,\u001a\u0004\bG\u0010.\"\u0004\bH\u00100R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010'\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010+R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010 \u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010L\u001a\u0004\bQ\u0010N\"\u0004\bR\u0010PR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010'\u001a\u0004\bS\u0010)\"\u0004\bT\u0010+\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/proavatar/e$a;", "", "", "size", "g", "", "enableZplanOutbound", "e", "enableDynamicAvatar", "b", "enableVasPendant", "d", "enableVasAvatar", "c", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "f", "target", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "useSource", "o", "shopSource", DomainData.DOMAIN_NAME, "highPriority", tl.h.F, "enable", "j", "videoAvatarSource", "p", "", "peerUin", "l", "peerUid", "k", "avatarAperture", "", "i", "Lcom/tencent/mobileqq/proavatar/e;", "a", "I", "getSize", "()I", "setSize", "(I)V", "Z", "getEnableZplanOutbound", "()Z", "setEnableZplanOutbound", "(Z)V", "getEnableDynamicAvatar", "setEnableDynamicAvatar", "getEnableVasPendant", "setEnableVasPendant", "getVasPendantTarget", "setVasPendantTarget", "vasPendantTarget", "getEnableVasAvatar", "setEnableVasAvatar", "getVasAvatarShopSource", "setVasAvatarShopSource", "vasAvatarShopSource", "getVasAvatarUseSource", "setVasAvatarUseSource", "vasAvatarUseSource", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "setLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getHighPriority", "setHighPriority", "getEnableVideoAvatar", "setEnableVideoAvatar", "enableVideoAvatar", "getVideoAvatarSource", "setVideoAvatarSource", "Ljava/lang/String;", "getPeerUin", "()Ljava/lang/String;", "setPeerUin", "(Ljava/lang/String;)V", "getPeerUid", "setPeerUid", "getAvatarAperture", "setAvatarAperture", "<init>", "(IZZZIZIILandroid/graphics/drawable/Drawable;ZZILjava/lang/String;Ljava/lang/String;I)V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int size;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean enableZplanOutbound;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean enableDynamicAvatar;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean enableVasPendant;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int vasPendantTarget;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean enableVasAvatar;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int vasAvatarShopSource;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int vasAvatarUseSource;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable loadingDrawable;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean highPriority;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private boolean enableVideoAvatar;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int videoAvatarSource;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String peerUin;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String peerUid;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int avatarAperture;

        public a() {
            this(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) {
                return;
            }
            iPatchRedirector.redirect((short) 49, (Object) this);
        }

        @NotNull
        public final e a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
                return (e) iPatchRedirector.redirect((short) 48, (Object) this);
            }
            return new e(this.size, this.enableZplanOutbound, this.enableDynamicAvatar, this.enableVasPendant, this.vasPendantTarget, this.enableVasAvatar, this.vasAvatarShopSource, this.vasAvatarUseSource, this.loadingDrawable, this.highPriority, this.enableVideoAvatar, this.videoAvatarSource, this.peerUin, this.peerUid, this.avatarAperture, null);
        }

        @NotNull
        public final a b(boolean enableDynamicAvatar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return (a) iPatchRedirector.redirect((short) 35, (Object) this, enableDynamicAvatar);
            }
            this.enableDynamicAvatar = enableDynamicAvatar;
            return this;
        }

        @NotNull
        public final a c(boolean enableVasAvatar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                return (a) iPatchRedirector.redirect((short) 37, (Object) this, enableVasAvatar);
            }
            this.enableVasAvatar = enableVasAvatar;
            return this;
        }

        @NotNull
        public final a d(boolean enableVasPendant) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                return (a) iPatchRedirector.redirect((short) 36, (Object) this, enableVasPendant);
            }
            this.enableVasPendant = enableVasPendant;
            return this;
        }

        @NotNull
        public final a e(boolean enableZplanOutbound) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return (a) iPatchRedirector.redirect((short) 34, (Object) this, enableZplanOutbound);
            }
            this.enableZplanOutbound = enableZplanOutbound;
            return this;
        }

        @NotNull
        public final a f(@Nullable Drawable loadingDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
                return (a) iPatchRedirector.redirect((short) 38, (Object) this, (Object) loadingDrawable);
            }
            this.loadingDrawable = loadingDrawable;
            return this;
        }

        @NotNull
        public final a g(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return (a) iPatchRedirector.redirect((short) 33, (Object) this, size);
            }
            this.size = size;
            return this;
        }

        @NotNull
        public final a h(boolean highPriority) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
                return (a) iPatchRedirector.redirect((short) 42, (Object) this, highPriority);
            }
            this.highPriority = highPriority;
            return this;
        }

        public final void i(int avatarAperture) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
                iPatchRedirector.redirect((short) 47, (Object) this, avatarAperture);
            } else {
                this.avatarAperture = avatarAperture;
            }
        }

        @NotNull
        public final a j(boolean enable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                return (a) iPatchRedirector.redirect((short) 43, (Object) this, enable);
            }
            this.enableVideoAvatar = enable;
            return this;
        }

        @NotNull
        public final a k(@NotNull String peerUid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
                return (a) iPatchRedirector.redirect((short) 46, (Object) this, (Object) peerUid);
            }
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            this.peerUid = peerUid;
            return this;
        }

        @NotNull
        public final a l(@NotNull String peerUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
                return (a) iPatchRedirector.redirect((short) 45, (Object) this, (Object) peerUin);
            }
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            this.peerUin = peerUin;
            return this;
        }

        @NotNull
        public final a m(int target) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                return (a) iPatchRedirector.redirect((short) 39, (Object) this, target);
            }
            this.vasPendantTarget = target;
            return this;
        }

        @NotNull
        public final a n(int shopSource) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                return (a) iPatchRedirector.redirect((short) 41, (Object) this, shopSource);
            }
            this.vasAvatarShopSource = shopSource;
            return this;
        }

        @NotNull
        public final a o(int useSource) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
                return (a) iPatchRedirector.redirect((short) 40, (Object) this, useSource);
            }
            this.vasAvatarUseSource = useSource;
            return this;
        }

        @NotNull
        public final a p(int videoAvatarSource) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
                return (a) iPatchRedirector.redirect((short) 44, (Object) this, videoAvatarSource);
            }
            this.videoAvatarSource = videoAvatarSource;
            return this;
        }

        public a(int i3, boolean z16, boolean z17, boolean z18, int i16, boolean z19, int i17, int i18, @Nullable Drawable drawable, boolean z26, boolean z27, int i19, @NotNull String peerUin, @NotNull String peerUid, int i26) {
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            Intrinsics.checkNotNullParameter(peerUid, "peerUid");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Boolean.valueOf(z19), Integer.valueOf(i17), Integer.valueOf(i18), drawable, Boolean.valueOf(z26), Boolean.valueOf(z27), Integer.valueOf(i19), peerUin, peerUid, Integer.valueOf(i26));
                return;
            }
            this.size = i3;
            this.enableZplanOutbound = z16;
            this.enableDynamicAvatar = z17;
            this.enableVasPendant = z18;
            this.vasPendantTarget = i16;
            this.enableVasAvatar = z19;
            this.vasAvatarShopSource = i17;
            this.vasAvatarUseSource = i18;
            this.loadingDrawable = drawable;
            this.highPriority = z26;
            this.enableVideoAvatar = z27;
            this.videoAvatarSource = i19;
            this.peerUin = peerUin;
            this.peerUid = peerUid;
            this.avatarAperture = i26;
        }

        public /* synthetic */ a(int i3, boolean z16, boolean z17, boolean z18, int i16, boolean z19, int i17, int i18, Drawable drawable, boolean z26, boolean z27, int i19, String str, String str2, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
            this((i27 & 1) != 0 ? 140 : i3, (i27 & 2) != 0 ? false : z16, (i27 & 4) != 0 ? false : z17, (i27 & 8) != 0 ? false : z18, (i27 & 16) != 0 ? 5 : i16, (i27 & 32) != 0 ? false : z19, (i27 & 64) != 0 ? 0 : i17, (i27 & 128) != 0 ? -1 : i18, (i27 & 256) != 0 ? BaseImageUtil.getDefaultFaceDrawable() : drawable, (i27 & 512) != 0 ? false : z26, (i27 & 1024) != 0 ? false : z27, (i27 & 2048) != 0 ? 0 : i19, (i27 & 4096) != 0 ? "" : str, (i27 & 8192) != 0 ? "" : str2, (i27 & 16384) != 0 ? 0 : i26);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Boolean.valueOf(z19), Integer.valueOf(i17), Integer.valueOf(i18), drawable, Boolean.valueOf(z26), Boolean.valueOf(z27), Integer.valueOf(i19), str, str2, Integer.valueOf(i26), Integer.valueOf(i27), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/proavatar/e$b;", "", "", "headType", "", "uin", "Lcom/tencent/mobileqq/proavatar/e;", "a", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.e$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        @JvmStatic
        @Nullable
        public final e a(int headType, @Nullable String uin) {
            String str = uin;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, (Object) this, headType, (Object) str);
            }
            if (headType == 1) {
                a aVar = new a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null);
                ISpecialShapeAvatarMaskLayer iSpecialShapeAvatarMaskLayer = (ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class);
                if (str == null) {
                    str = "";
                }
                return aVar.e(!iSpecialShapeAvatarMaskLayer.isSpecialShapeAvatar(str)).a();
            }
            return null;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29961);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ e(int i3, boolean z16, boolean z17, boolean z18, int i16, boolean z19, int i17, int i18, Drawable drawable, boolean z26, boolean z27, int i19, String str, String str2, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, z16, z17, z18, i16, z19, i17, i18, drawable, z26, z27, i19, str, str2, i26);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Boolean.valueOf(z19), Integer.valueOf(i17), Integer.valueOf(i18), drawable, Boolean.valueOf(z26), Boolean.valueOf(z27), Integer.valueOf(i19), str, str2, Integer.valueOf(i26), defaultConstructorMarker);
    }

    @JvmStatic
    @Nullable
    public static final e a(int i3, @Nullable String str) {
        return INSTANCE.a(i3, str);
    }

    @NotNull
    public final e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (e) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return new e(this.size, this.enableZplanOutbound, this.enableDynamicAvatar, this.enableVasPendant, this.vasPendantTarget, this.enableVasAvatar, this.vasAvatarShopSource, this.vasAvatarUseSource, this.loadingDrawable, this.highPriority, this.enableVideoAvatar, this.videoAvatarSource, this.peerUin, this.peerUid, this.avatarAperture);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.avatarAperture;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.enableDynamicAvatar;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.enableVasAvatar;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.enableVasPendant;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.enableVideoAvatar;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.enableZplanOutbound;
    }

    @Nullable
    public final Drawable i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.loadingDrawable;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.peerUin;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.size;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.vasAvatarShopSource;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.vasAvatarUseSource;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.vasPendantTarget;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.videoAvatarSource;
    }

    e(int i3, boolean z16, boolean z17, boolean z18, int i16, boolean z19, int i17, int i18, Drawable drawable, boolean z26, boolean z27, int i19, String str, String str2, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Boolean.valueOf(z19), Integer.valueOf(i17), Integer.valueOf(i18), drawable, Boolean.valueOf(z26), Boolean.valueOf(z27), Integer.valueOf(i19), str, str2, Integer.valueOf(i26));
            return;
        }
        this.size = i3;
        this.enableZplanOutbound = z16;
        this.enableDynamicAvatar = z17;
        this.enableVasPendant = z18;
        this.vasPendantTarget = i16;
        this.enableVasAvatar = z19;
        this.vasAvatarShopSource = i17;
        this.vasAvatarUseSource = i18;
        this.loadingDrawable = drawable;
        this.highPriority = z26;
        this.enableVideoAvatar = z27;
        this.videoAvatarSource = i19;
        this.peerUin = str;
        this.peerUid = str2;
        this.avatarAperture = i26;
    }
}
