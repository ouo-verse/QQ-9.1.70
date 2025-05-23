package com.tencent.qqnt.emotion.stickerrecommended.config;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 (2\u00020\u0001:\u0001\u0007B\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R(\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/a;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/qqnt/emotion/stickerrecommended/o;", "stickerRecData", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "b", "", "a", "Lkotlin/Function2;", "", "onFinished", "c", "Lcom/tencent/image/URLDrawable;", "drawable", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "progress", "onLoadProgressed", "", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/e;", "d", "Ljava/util/List;", "downloadDrawableStickerRecEmojis", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "downloaderDrawables", "f", "I", "emotionRoundCorner", tl.h.F, "successCount", "i", "Lkotlin/jvm/functions/Function2;", "<init>", "(Ljava/util/List;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements URLDrawable.URLDrawableListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> downloadDrawableStickerRecEmojis;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<URLDrawable> downloaderDrawables;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int emotionRoundCorner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int successCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function2<? super Integer, ? super Integer, Unit> onFinished;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.stickerrecommended.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull List<e> downloadDrawableStickerRecEmojis) {
        Intrinsics.checkNotNullParameter(downloadDrawableStickerRecEmojis, "downloadDrawableStickerRecEmojis");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) downloadDrawableStickerRecEmojis);
            return;
        }
        this.downloadDrawableStickerRecEmojis = downloadDrawableStickerRecEmojis;
        this.downloaderDrawables = new ArrayList<>();
        this.emotionRoundCorner = (int) (BaseApplication.getContext().getResources().getDisplayMetrics().density * 6);
    }

    private final void a() {
        int size = this.downloadDrawableStickerRecEmojis.size();
        if (this.downloaderDrawables.isEmpty()) {
            Function2<? super Integer, ? super Integer, Unit> function2 = this.onFinished;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onFinished");
                function2 = null;
            }
            function2.invoke(Integer.valueOf(this.successCount), Integer.valueOf(size - this.successCount));
        }
    }

    private final URLDrawable.URLDrawableOptions b(o stickerRecData) {
        URLDrawable.URLDrawableOptions options = stickerRecData.getURLDrawableOptions();
        if (options == null) {
            options = URLDrawable.URLDrawableOptions.obtain();
        }
        options.mPlayGifImage = true;
        options.mGifRoundCorner = this.emotionRoundCorner;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    public final void c(@NotNull Function2<? super Integer, ? super Integer, Unit> onFinished) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onFinished);
            return;
        }
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        this.onFinished = onFinished;
        this.successCount = 0;
        this.downloaderDrawables.clear();
        Iterator<T> it = this.downloadDrawableStickerRecEmojis.iterator();
        while (it.hasNext()) {
            o b16 = g.b((e) it.next(), 0, 1, null);
            URLDrawable uRLDrawable = b16.getURLDrawable(b16.getProtocolURL(), b(b16));
            if (uRLDrawable != null) {
                Intrinsics.checkNotNullExpressionValue(uRLDrawable, "getURLDrawable(stickerRe\u2026eOptions(stickerRecData))");
                uRLDrawable.setURLDrawableListener(this);
                if (uRLDrawable.getStatus() != 1) {
                    this.downloaderDrawables.add(uRLDrawable);
                    uRLDrawable.addHeader("my_uin", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
                    uRLDrawable.addHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_NEED_BIG, "true");
                    uRLDrawable.startDownload();
                } else {
                    this.successCount++;
                }
            }
        }
        int size = this.downloadDrawableStickerRecEmojis.size();
        int i3 = this.successCount;
        if (i3 == size) {
            onFinished.invoke(Integer.valueOf(i3), Integer.valueOf(size - this.successCount));
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(@NotNull URLDrawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        } else {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(@NotNull URLDrawable drawable, @NotNull Throwable cause) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, (Object) cause);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(cause, "cause");
        if (QLog.isColorLevel()) {
            QLog.i("ConfigStickerDrawableDownloader", 2, "onLoadFialed url:" + drawable.getURL() + ", cause: " + cause.getMessage());
        }
        this.downloaderDrawables.remove(drawable);
        a();
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(@NotNull URLDrawable drawable, int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable, progress);
        } else {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(@NotNull URLDrawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (QLog.isColorLevel()) {
            QLog.i("ConfigStickerDrawableDownloader", 2, "onLoadSuccessed url:" + drawable.getURL());
        }
        this.downloaderDrawables.remove(drawable);
        this.successCount++;
        a();
    }
}
