package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b0\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001b\u0010\u0019\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001b\u0010\u001b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u001c\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u001e\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001b\u0010 \u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001b\u0010!\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001b\u0010\"\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001b\u0010#\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010$\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001b\u0010&\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001b\u0010(\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001b\u0010*\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001b\u0010,\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001b\u0010-\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u001b\u0010/\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/emoticon/QQSysFaceSwitcher;", "", "", "b", "Lkotlin/Lazy;", "p", "()Z", "needSysFaceOptimize", "c", "u", "isSysFaceLibraUseLifeCycle", "d", DomainData.DOMAIN_NAME, "needDownloadSysFace", "e", "o", "needResetTextInVas", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "loadPicInMainThread", "g", "a", "convertEmojiServerIdFilterConfig", tl.h.F, "j", "enableInitSysEmojisConfigRetry", "i", "enableAppleEmojiRes", "enableAppleEmojiLocalIdToUnicode", "k", "enableProcessColorNickConflict", "l", "enableAddSingleDownloadSysFaceToCache", "enableSingleDownloadWhenAniStickerBroken", "enableAniStickerUseStaticLoadingDrawable", "enableAniStickerViewCanvasDensityFix", "enableAniStickerLifecycle", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "enableGetResPathFromCache", "r", "parseEmojiSpanWithCharCount", ReportConstant.COSTREPORT_PREFIX, "parseEmojiFilterInvalidateEmoHeader", "t", "qzoneEmCodeUseLocalDefault", "isLibApngInPicLoader", "v", "emoticonDebugLog", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQSysFaceSwitcher {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQSysFaceSwitcher f204652a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy needSysFaceOptimize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isSysFaceLibraUseLifeCycle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy needDownloadSysFace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy needResetTextInVas;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy loadPicInMainThread;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy convertEmojiServerIdFilterConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableInitSysEmojisConfigRetry;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAppleEmojiRes;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAppleEmojiLocalIdToUnicode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableProcessColorNickConflict;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAddSingleDownloadSysFaceToCache;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableSingleDownloadWhenAniStickerBroken;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAniStickerUseStaticLoadingDrawable;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAniStickerViewCanvasDensityFix;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableAniStickerLifecycle;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableGetResPathFromCache;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy parseEmojiSpanWithCharCount;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy parseEmojiFilterInvalidateEmoHeader;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy qzoneEmCodeUseLocalDefault;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isLibApngInPicLoader;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy emoticonDebugLog;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        Lazy lazy16;
        Lazy lazy17;
        Lazy lazy18;
        Lazy lazy19;
        Lazy lazy20;
        Lazy lazy21;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31423);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        f204652a = new QQSysFaceSwitcher();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.emoticon.QQSysFaceSwitcher$needSysFaceOptimize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emoticon_sys_face_optimize_115851637", true);
                QLog.i("QQSysFaceSwitcher", 1, "emoticon_sys_face_optimize_115851637:" + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        needSysFaceOptimize = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$isSysFaceLibraUseLifeCycle$2.INSTANCE);
        isSysFaceLibraUseLifeCycle = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$needDownloadSysFace$2.INSTANCE);
        needDownloadSysFace = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$needResetTextInVas$2.INSTANCE);
        needResetTextInVas = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$loadPicInMainThread$2.INSTANCE);
        loadPicInMainThread = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$convertEmojiServerIdFilterConfig$2.INSTANCE);
        convertEmojiServerIdFilterConfig = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableInitSysEmojisConfigRetry$2.INSTANCE);
        enableInitSysEmojisConfigRetry = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableAppleEmojiRes$2.INSTANCE);
        enableAppleEmojiRes = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableAppleEmojiLocalIdToUnicode$2.INSTANCE);
        enableAppleEmojiLocalIdToUnicode = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableProcessColorNickConflict$2.INSTANCE);
        enableProcessColorNickConflict = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableAddSingleDownloadSysFaceToCache$2.INSTANCE);
        enableAddSingleDownloadSysFaceToCache = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableSingleDownloadWhenAniStickerBroken$2.INSTANCE);
        enableSingleDownloadWhenAniStickerBroken = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableAniStickerUseStaticLoadingDrawable$2.INSTANCE);
        enableAniStickerUseStaticLoadingDrawable = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.emoticon.QQSysFaceSwitcher$enableAniStickerViewCanvasDensityFix$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emoticon_ani_sticker_canvas_density_fix_134163419", true));
            }
        });
        enableAniStickerViewCanvasDensityFix = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableAniStickerLifecycle$2.INSTANCE);
        enableAniStickerLifecycle = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$enableGetResPathFromCache$2.INSTANCE);
        enableGetResPathFromCache = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$parseEmojiSpanWithCharCount$2.INSTANCE);
        parseEmojiSpanWithCharCount = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$parseEmojiFilterInvalidateEmoHeader$2.INSTANCE);
        parseEmojiFilterInvalidateEmoHeader = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$qzoneEmCodeUseLocalDefault$2.INSTANCE);
        qzoneEmCodeUseLocalDefault = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$isLibApngInPicLoader$2.INSTANCE);
        isLibApngInPicLoader = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(QQSysFaceSwitcher$emoticonDebugLog$2.INSTANCE);
        emoticonDebugLog = lazy21;
    }

    QQSysFaceSwitcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return ((Boolean) convertEmojiServerIdFilterConfig.getValue()).booleanValue();
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return ((Boolean) emoticonDebugLog.getValue()).booleanValue();
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAddSingleDownloadSysFaceToCache.getValue()).booleanValue();
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAniStickerLifecycle.getValue()).booleanValue();
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAniStickerUseStaticLoadingDrawable.getValue()).booleanValue();
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAniStickerViewCanvasDensityFix.getValue()).booleanValue();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAppleEmojiLocalIdToUnicode.getValue()).booleanValue();
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ((Boolean) enableAppleEmojiRes.getValue()).booleanValue();
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return ((Boolean) enableGetResPathFromCache.getValue()).booleanValue();
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return ((Boolean) enableInitSysEmojisConfigRetry.getValue()).booleanValue();
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ((Boolean) enableProcessColorNickConflict.getValue()).booleanValue();
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return ((Boolean) enableSingleDownloadWhenAniStickerBroken.getValue()).booleanValue();
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return ((Boolean) loadPicInMainThread.getValue()).booleanValue();
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((Boolean) needDownloadSysFace.getValue()).booleanValue();
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return ((Boolean) needResetTextInVas.getValue()).booleanValue();
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) needSysFaceOptimize.getValue()).booleanValue();
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return ((Boolean) parseEmojiFilterInvalidateEmoHeader.getValue()).booleanValue();
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return ((Boolean) parseEmojiSpanWithCharCount.getValue()).booleanValue();
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return ((Boolean) qzoneEmCodeUseLocalDefault.getValue()).booleanValue();
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return ((Boolean) isLibApngInPicLoader.getValue()).booleanValue();
    }

    public final boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ((Boolean) isSysFaceLibraUseLifeCycle.getValue()).booleanValue();
    }
}
