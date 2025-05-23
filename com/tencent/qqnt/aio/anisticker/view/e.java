package com.tencent.qqnt.aio.anisticker.view;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceResImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqnt.aio.anisticker.download.i;
import com.tencent.qqnt.aio.anisticker.download.m;
import com.tencent.qqnt.aio.anisticker.download.n;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import com.tencent.qqnt.aio.anisticker.view.e;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J*\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u001b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0012J(\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\fR\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/view/e;", "", "Lcom/tencent/qqnt/aio/anisticker/view/e$a;", "builder", "", "t", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "lottieView", "", "localId", "", UIJsPlugin.EVENT_SHOW_LOADING, "", "resultId", "u", "k", "f", "l", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "stickerInfo", "o", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "p", "r", "j", "surpriseId", tl.h.F, "b", "I", "i", "()I", "LOTTIE_ANIM_SIZE", "<init>", "()V", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f348849a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int LOTTIE_ANIM_SIZE;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b4\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020\"\u00a2\u0006\u0004\bU\u0010'J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001d\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0000R$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010*\u001a\u0004\b0\u0010,\"\u0004\b:\u0010.R\"\u0010=\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010*\u001a\u0004\b9\u0010,\"\u0004\b<\u0010.R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\b;\u0010A\"\u0004\bE\u0010CR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bF\u0010H\"\u0004\bI\u0010JR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010*\u001a\u0004\bD\u0010,\"\u0004\bL\u0010.R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010?\u001a\u0004\bK\u0010A\"\u0004\bM\u0010CR$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010G\u001a\u0004\bN\u0010H\"\u0004\bO\u0010JR$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010G\u001a\u0004\b>\u0010H\"\u0004\bP\u0010JR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010Q\u001a\u0004\b)\u0010R\"\u0004\bS\u0010T\u00a8\u0006V"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/view/e$a;", "", "", "randomAniSticker", "t", "", "resultId", "w", "", "resultAnimRepeatCount", "v", "randomKey", "u", "showLastFrame", HippyTKDListViewAdapter.X, "surpriseId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/aio/anisticker/view/a;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/data/AniStickerInfo;", "stickerInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "width", "B", "height", "p", "localId", "r", "resDrawable", ReportConstant.COSTREPORT_PREFIX, UIJsPlugin.EVENT_SHOW_LOADING, "y", "a", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "d", "()Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "setLottieView", "(Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;)V", "lottieView", "b", "I", "o", "()I", "setViewWidth", "(I)V", "viewWidth", "c", DomainData.DOMAIN_NAME, "setViewHeight", "viewHeight", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "l", "()Lcom/tencent/mobileqq/data/AniStickerInfo;", "setStickerInfo", "(Lcom/tencent/mobileqq/data/AniStickerInfo;)V", "e", "setLocalId", "f", "setPlaceholderDrawable", "placeholderDrawable", "g", "Z", "k", "()Z", "setShowLoading", "(Z)V", tl.h.F, "setRandomAniSticker", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "setResultId", "(Ljava/lang/String;)V", "j", "setResultAnimRepeatCount", "setShowLastFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setSurpriseId", "setRandomKey", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "()Lcom/tencent/qqnt/aio/anisticker/view/a;", "setListener", "(Lcom/tencent/qqnt/aio/anisticker/view/a;)V", "<init>", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private AniStickerLottieView lottieView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int viewWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int viewHeight;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private AniStickerInfo stickerInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int localId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @DrawableRes
        private int placeholderDrawable;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean showLoading;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean randomAniSticker;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String resultId;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int resultAnimRepeatCount;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private boolean showLastFrame;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String surpriseId;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String randomKey;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.qqnt.aio.anisticker.view.a listener;

        public a(@NotNull AniStickerLottieView lottieView) {
            Intrinsics.checkNotNullParameter(lottieView, "lottieView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lottieView);
                return;
            }
            e eVar = e.f348849a;
            this.viewWidth = eVar.i();
            this.viewHeight = eVar.i();
            this.showLoading = true;
            this.resultAnimRepeatCount = 1;
            this.lottieView = lottieView;
        }

        @NotNull
        public final a A(@Nullable String surpriseId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return (a) iPatchRedirector.redirect((short) 35, (Object) this, (Object) surpriseId);
            }
            this.surpriseId = surpriseId;
            return this;
        }

        @NotNull
        public final a B(int width) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
                return (a) iPatchRedirector.redirect((short) 38, (Object) this, width);
            }
            this.viewWidth = width;
            return this;
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                return (a) iPatchRedirector.redirect((short) 43, (Object) this);
            }
            return this;
        }

        @Nullable
        public final com.tencent.qqnt.aio.anisticker.view.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (com.tencent.qqnt.aio.anisticker.view.a) iPatchRedirector.redirect((short) 28, (Object) this);
            }
            return this.listener;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.localId;
        }

        @Nullable
        public final AniStickerLottieView d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AniStickerLottieView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.lottieView;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.placeholderDrawable;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
            }
            return this.randomAniSticker;
        }

        @Nullable
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (String) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return this.randomKey;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            return this.resultAnimRepeatCount;
        }

        @Nullable
        public final String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.resultId;
        }

        public final boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
            }
            return this.showLastFrame;
        }

        public final boolean k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
            }
            return this.showLoading;
        }

        @Nullable
        public final AniStickerInfo l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (AniStickerInfo) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.stickerInfo;
        }

        @Nullable
        public final String m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (String) iPatchRedirector.redirect((short) 24, (Object) this);
            }
            return this.surpriseId;
        }

        public final int n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.viewHeight;
        }

        public final int o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.viewWidth;
        }

        @NotNull
        public final a p(int height) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                return (a) iPatchRedirector.redirect((short) 39, (Object) this, height);
            }
            this.viewHeight = height;
            return this;
        }

        @NotNull
        public final a q(@Nullable com.tencent.qqnt.aio.anisticker.view.a listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                return (a) iPatchRedirector.redirect((short) 36, (Object) this, (Object) listener);
            }
            this.listener = listener;
            return this;
        }

        @NotNull
        public final a r(int localId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
                return (a) iPatchRedirector.redirect((short) 40, (Object) this, localId);
            }
            this.localId = localId;
            return this;
        }

        @NotNull
        public final a s(@DrawableRes int resDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                return (a) iPatchRedirector.redirect((short) 41, (Object) this, resDrawable);
            }
            this.placeholderDrawable = resDrawable;
            return this;
        }

        @NotNull
        public final a t(boolean randomAniSticker) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (a) iPatchRedirector.redirect((short) 30, (Object) this, randomAniSticker);
            }
            this.randomAniSticker = randomAniSticker;
            return this;
        }

        @NotNull
        public final a u(@Nullable String randomKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return (a) iPatchRedirector.redirect((short) 33, (Object) this, (Object) randomKey);
            }
            this.randomKey = randomKey;
            return this;
        }

        @NotNull
        public final a v(int resultAnimRepeatCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return (a) iPatchRedirector.redirect((short) 32, (Object) this, resultAnimRepeatCount);
            }
            this.resultAnimRepeatCount = resultAnimRepeatCount;
            return this;
        }

        @NotNull
        public final a w(@Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return (a) iPatchRedirector.redirect((short) 31, (Object) this, (Object) resultId);
            }
            this.resultId = resultId;
            return this;
        }

        @NotNull
        public final a x(boolean showLastFrame) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return (a) iPatchRedirector.redirect((short) 34, (Object) this, showLastFrame);
            }
            this.showLastFrame = showLastFrame;
            return this;
        }

        @NotNull
        public final a y(boolean showLoading) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
                return (a) iPatchRedirector.redirect((short) 42, (Object) this, showLoading);
            }
            this.showLoading = showLoading;
            return this;
        }

        @NotNull
        public final a z(@Nullable AniStickerInfo stickerInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                return (a) iPatchRedirector.redirect((short) 37, (Object) this, (Object) stickerInfo);
            }
            this.stickerInfo = stickerInfo;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/anisticker/view/e$b", "Lcom/tencent/qqnt/aio/anisticker/download/m;", "Lcom/tencent/qqnt/aio/anisticker/drawable/f;", "lottieDrawable", "", "a", "", "throwable", "onFail", "", "cacheKey", "onLottieResLoading", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AniStickerLottieView f348865a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AniStickerInfo f348866b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f348867c;

        b(AniStickerLottieView aniStickerLottieView, AniStickerInfo aniStickerInfo, int i3) {
            this.f348865a = aniStickerLottieView;
            this.f348866b = aniStickerInfo;
            this.f348867c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aniStickerLottieView, aniStickerInfo, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.download.m
        public void a(@NotNull com.tencent.qqnt.aio.anisticker.drawable.f lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
                return;
            }
            Intrinsics.checkNotNullParameter(lottieDrawable, "lottieDrawable");
            if (e.f348849a.j(this.f348865a, this.f348866b)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f348865a.M()) {
                lottieDrawable.h(1);
            } else {
                lottieDrawable.h(-1);
                lottieDrawable.c(true);
            }
            this.f348865a.A(lottieDrawable);
            this.f348865a.R(lottieDrawable);
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "lottie view playAnimation. cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.download.m
        public void onFail(@Nullable Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) throwable);
                return;
            }
            QLog.e("AniStickerHelper", 2, throwable, new Object[0]);
            if (e.f348849a.j(this.f348865a, this.f348866b)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AniStickerHelper", 2, " onFail lottieView is used.");
                }
            } else {
                AniStickerLottieView aniStickerLottieView = this.f348865a;
                aniStickerLottieView.setLoadingDrawable(ContextCompat.getDrawable(aniStickerLottieView.getContext(), this.f348867c));
                this.f348865a.invalidate();
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.download.m
        public void onLottieResLoading(@NotNull String cacheKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cacheKey);
                return;
            }
            Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
            if (e.f348849a.j(this.f348865a, this.f348866b)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AniStickerHelper", 4, "onLottieResLoading lottieView is used.");
                    return;
                }
                return;
            }
            this.f348865a.setCacheKey(cacheKey);
            AniStickerLottieView aniStickerLottieView = this.f348865a;
            aniStickerLottieView.C(aniStickerLottieView);
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "lottie res downloading : " + cacheKey);
            }
            if (this.f348865a.N() == null) {
                AniStickerLottieView aniStickerLottieView2 = this.f348865a;
                aniStickerLottieView2.setLoadingDrawable(ContextCompat.getDrawable(aniStickerLottieView2.getContext(), this.f348867c));
            }
            this.f348865a.invalidate();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/anisticker/view/e$c", "Lcom/tencent/qqnt/aio/anisticker/download/m;", "Lcom/tencent/qqnt/aio/anisticker/drawable/f;", "lottieDrawable", "", "a", "", "throwable", "onFail", "", "cacheKey", "onLottieResLoading", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AniStickerLottieView f348868a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AniStickerInfo f348869b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f348870c;

        c(AniStickerLottieView aniStickerLottieView, AniStickerInfo aniStickerInfo, a aVar) {
            this.f348868a = aniStickerLottieView;
            this.f348869b = aniStickerInfo;
            this.f348870c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aniStickerLottieView, aniStickerInfo, aVar);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.download.m
        public void a(@NotNull com.tencent.qqnt.aio.anisticker.drawable.f lottieDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieDrawable);
                return;
            }
            Intrinsics.checkNotNullParameter(lottieDrawable, "lottieDrawable");
            if (e.f348849a.j(this.f348868a, this.f348869b)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AniStickerHelper", 4, "sec onSuccess lottieView is used.");
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f348868a.setSecondLottieDrawable(this.f348869b, lottieDrawable, this.f348870c.h());
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "sec lottie view playAnimation. cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.download.m
        public void onFail(@Nullable Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) throwable);
                return;
            }
            QLog.e("AniStickerHelper", 2, throwable, new Object[0]);
            if (e.f348849a.j(this.f348868a, this.f348869b) && QLog.isColorLevel()) {
                QLog.d("AniStickerHelper", 2, "sec onFail lottieView is used.");
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.download.m
        public void onLottieResLoading(@NotNull String cacheKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cacheKey);
                return;
            }
            Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
            if (e.f348849a.j(this.f348868a, this.f348869b)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AniStickerHelper", 4, "sec onLottieResLoading lottieView is used.");
                }
            } else if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "sec lottie res downloading : " + cacheKey);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f348849a = new e();
            LOTTIE_ANIM_SIZE = Utils.n(171.0f, BaseApplication.getContext().getResources());
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a builder) {
        Intrinsics.checkNotNullParameter(builder, "$builder");
        f348849a.p(builder);
    }

    private final void f(final a builder) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.view.c
            @Override // java.lang.Runnable
            public final void run() {
                e.g(e.a.this);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(a builder) {
        Intrinsics.checkNotNullParameter(builder, "$builder");
        f348849a.l(builder);
    }

    private final void k(a builder) {
        if (!builder.k()) {
            f(builder);
            return;
        }
        AniStickerLottieView d16 = builder.d();
        if (d16 != null) {
            Drawable drawable = ContextCompat.getDrawable(d16.getContext(), builder.e());
            if (!builder.f() || !builder.j()) {
                drawable = QQSysFaceUtil.getAniStickerLoadingDrawable(builder.c(), drawable);
            }
            d16.setLoadingDrawable(drawable);
            d16.invalidate();
        }
        f(builder);
    }

    private final void l(a builder) {
        AniStickerLottieView d16 = builder.d();
        Intrinsics.checkNotNull(d16);
        AniStickerInfo l3 = builder.l();
        int e16 = builder.e();
        i iVar = (i) n.f348828a.a(1);
        if (l3 == null) {
            QLog.e("AniStickerHelper", 2, "stickerInfo is null.");
            return;
        }
        if (j(d16, l3)) {
            return;
        }
        iVar.u(l3);
        if (!h.f348873a.g()) {
            return;
        }
        if (AniStickerLottieView.INSTANCE.b(d16, iVar.g())) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "addPauseCache no load res.");
                return;
            }
            return;
        }
        iVar.n(builder, new b(d16, l3, e16));
    }

    private final void o(a builder, AniStickerInfo stickerInfo) {
        i iVar = (i) n.f348828a.a(1);
        if (stickerInfo == null) {
            QLog.e("AniStickerHelper", 2, "sec stickerInfo is null.");
            return;
        }
        AniStickerLottieView d16 = builder.d();
        if (j(d16, stickerInfo)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "sec load after lottieView is used.");
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(d16);
        d16.setResultId(stickerInfo.resultId);
        d16.setRandomKey(stickerInfo.randomKey);
        iVar.u(stickerInfo);
        if (!h.f348873a.g()) {
            return;
        }
        iVar.n(builder, new c(d16, stickerInfo, builder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(a builder) {
        Intrinsics.checkNotNullParameter(builder, "$builder");
        f348849a.t(builder);
    }

    @MainThread
    private final void t(a builder) {
        AniStickerLottieView d16 = builder.d();
        int c16 = builder.c();
        int e16 = builder.e();
        boolean k3 = builder.k();
        boolean f16 = builder.f();
        String i3 = builder.i();
        boolean j3 = builder.j();
        String m3 = builder.m();
        com.tencent.qqnt.aio.anisticker.view.a b16 = builder.b();
        if (d16 == null) {
            QLog.e("AniStickerHelper", 2, "setAniStickerResource lottieView is null. ");
            return;
        }
        d16.setSecondRandomResultPlayListener(null);
        d16.setDefaultRandomResultPlayListener(b16);
        if ((d16.isAnimating() || d16.getDrawable() != null) && d16.H() == c16 && c16 != -1 && m3 == null && !f16 && d16.J() == null) {
            if (d16.P() && !d16.isAnimating()) {
                d16.reDraw();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "same lottieView is running.");
                return;
            }
            return;
        }
        if (d16.getDrawable() != null && j3 && d16.H() == c16 && i3 != null && Intrinsics.areEqual(i3, d16.K())) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "resultId is same. reuse res. " + c16);
                return;
            }
            return;
        }
        d16.clearLottieDrawable();
        d16.clearSecondLottieDrawable();
        AniStickerInfo l3 = builder.l();
        if (l3 == null) {
            l3 = h(c16, i3, m3);
        }
        if (l3 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AniStickerHelper", 2, "stickerInfo is null, show default loading icon.");
            }
            d16.setLoadingDrawable(ContextCompat.getDrawable(d16.getContext(), e16));
            d16.postInvalidate();
            return;
        }
        d16.setDefaultLoadingRes(e16);
        boolean u16 = u(d16, c16, k3, i3);
        d16.setLocalId(c16);
        d16.setResultId(i3);
        d16.setSurpriseId(m3);
        d16.setShowLastFrame(j3);
        d16.setPlayFrameFinish(false);
        if (f16) {
            d16.setRandomKey(UUID.randomUUID().toString());
        } else {
            d16.setRandomKey(null);
        }
        l3.randomKey = d16.J();
        builder.r(c16).s(e16).z(l3).y(u16);
        k(builder);
    }

    private final boolean u(AniStickerLottieView lottieView, int localId, boolean showLoading, String resultId) {
        if (!showLoading) {
            return false;
        }
        if (lottieView.H() == localId && (resultId == null || Intrinsics.areEqual(resultId, lottieView.K()))) {
            return false;
        }
        return true;
    }

    public final void d(@NotNull final a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) builder);
            return;
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("async_set_random_result_9035_122765599", true)) {
            p(builder);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.view.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.e(e.a.this);
                }
            }, 64, null, false);
        }
    }

    @Nullable
    public final AniStickerInfo h(int localId, @Nullable String resultId, @Nullable String surpriseId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AniStickerInfo) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(localId), resultId, surpriseId);
        }
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        Intrinsics.checkNotNull(resImpl, "null cannot be cast to non-null type com.tencent.mobileqq.emoticon.QQSysFaceResImpl");
        return ((QQSysFaceResImpl) resImpl).getAniStickerInfo(localId, resultId, surpriseId);
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return LOTTIE_ANIM_SIZE;
    }

    public final boolean j(@Nullable AniStickerLottieView lottieView, @NotNull AniStickerInfo stickerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) lottieView, (Object) stickerInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(stickerInfo, "stickerInfo");
        int i3 = stickerInfo.localId;
        Intrinsics.checkNotNull(lottieView);
        if (i3 != lottieView.H()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "localId change. lottieView is used.");
            }
            return true;
        }
        String str = stickerInfo.randomKey;
        if (str != null && !str.equals(lottieView.J())) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AniStickerHelper", 4, "randomKey change. lottieView is used.");
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final String m(@NotNull a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) builder);
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (builder.d() == null) {
            QLog.e("AniStickerHelper", 2, "set AniStickerRandomLastFrameResource lottieView is null. ");
            return null;
        }
        builder.y(true).t(true).x(true);
        r(builder);
        AniStickerLottieView d16 = builder.d();
        Intrinsics.checkNotNull(d16);
        return d16.J();
    }

    @Nullable
    public final String n(@NotNull a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) builder);
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (builder.d() == null) {
            QLog.e("AniStickerHelper", 2, "set AniStickerRandomResource lottieView is null. ");
            return null;
        }
        builder.t(true).w(null).A(null).x(false);
        r(builder);
        AniStickerLottieView d16 = builder.d();
        Intrinsics.checkNotNull(d16);
        return d16.J();
    }

    public final void p(@NotNull a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) builder);
            return;
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        String str = null;
        if (builder.d() != null) {
            AniStickerLottieView d16 = builder.d();
            Intrinsics.checkNotNull(d16);
            if (!TextUtils.isEmpty(d16.J()) && !TextUtils.isEmpty(builder.i())) {
                AniStickerLottieView.Companion companion = AniStickerLottieView.INSTANCE;
                AniStickerLottieView d17 = builder.d();
                String i3 = builder.i();
                Intrinsics.checkNotNull(i3);
                companion.g(d17, i3);
                AniStickerLottieView d18 = builder.d();
                Intrinsics.checkNotNull(d18);
                d18.setSecondRandomResultPlayListener(builder.b());
                AniStickerLottieView d19 = builder.d();
                Intrinsics.checkNotNull(d19);
                a r16 = builder.r(d19.H());
                AniStickerLottieView d26 = builder.d();
                Intrinsics.checkNotNull(d26);
                r16.u(d26.J()).w(builder.i()).a();
                AniStickerInfo h16 = h(builder.c(), builder.i(), null);
                if (h16 == null) {
                    QLog.e("AniStickerHelper", 2, "[setAniStickerRandomResultResource] aniStickerInfo is null. localId=" + builder.c());
                    return;
                }
                h16.randomKey = builder.g();
                o(builder, h16);
                return;
            }
        }
        Object[] objArr = new Object[2];
        objArr[0] = "invalidate randomKey or resultId.";
        AniStickerLottieView d27 = builder.d();
        if (d27 != null) {
            str = d27.J();
        }
        objArr[1] = "randomKey=" + str + ", resultId=" + builder.i();
        QLog.e("AniStickerHelper", 2, objArr);
    }

    public final void q(@NotNull a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) builder);
            return;
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (builder.d() == null) {
            QLog.e("AniStickerHelper", 2, "setAniStickerRandomSurpriseResource lottieView is null. ");
        } else {
            builder.y(false).t(false).w(null).x(false);
            r(builder);
        }
    }

    @MainThread
    public final void r(@NotNull final a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) builder);
            return;
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (QLog.isDevelopLevel()) {
                QLog.w("AniStickerHelper", 4, "[setAniStickerResource] not in ui thread! stack=" + QLog.getStackTraceString(new Throwable()));
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.anisticker.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.s(e.a.this);
                }
            });
            return;
        }
        t(builder);
    }
}
