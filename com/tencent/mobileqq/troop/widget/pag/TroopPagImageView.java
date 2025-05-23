package com.tencent.mobileqq.troop.widget.pag;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.widget.pag.TroopPagImageView;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u00a2\u0006\u0004\b.\u0010/JE\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\u000bH\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/pag/TroopPagImageView;", "Landroid/widget/FrameLayout;", "", Constants.PAG_FILE_PATH, "", "repeatCount", "imageIndex", "Landroid/graphics/Bitmap;", "image", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "listener", "", "e", "(Ljava/lang/String;ILjava/lang/Integer;Landroid/graphics/Bitmap;Lorg/libpag/PAGImageView$PAGImageViewListener;)V", "k", "setPagListener", "pagUrl", "", "enablePlay", tl.h.F, "j", NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setMLocalPagUrl", "(Ljava/lang/String;)V", "mLocalPagUrl", "Lvk3/a;", "Lvk3/a;", "mPagDownloadListener", "f", "Z", "mEnablePlay", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "mListener", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "i", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "vasPagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopPagImageView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mLocalPagUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private vk3.a mPagDownloadListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mEnablePlay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGImageView.PAGImageViewListener mListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasPagImageView vasPagView;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/widget/pag/TroopPagImageView$a", "Lvk3/a;", "", "url", "path", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements vk3.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPagImageView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TroopPagImageView this$0, String path) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(path, "$path");
            TroopPagImageView.f(this$0, path, 0, null, null, null, 30, null);
        }

        @Override // vk3.a
        public void a(@NotNull String url, @NotNull final String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) path);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(path, "path");
            if (Intrinsics.areEqual(url, TroopPagImageView.this.g()) && !TextUtils.isEmpty(path)) {
                QLog.i("TroopPagImageView", 1, "onPagDownloaded url:" + url + ", path:" + path);
                TroopPAGLoader.f302618a.j(this);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final TroopPagImageView troopPagImageView = TroopPagImageView.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopPagImageView.a.c(TroopPagImageView.this, path);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/pag/TroopPagImageView$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.widget.pag.TroopPagImageView$b, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62094);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopPagImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
    }

    private final void e(final String pagFilePath, final int repeatCount, final Integer imageIndex, final Bitmap image, PAGImageView.PAGImageViewListener listener) {
        setPagListener(listener);
        this.vasPagView.api().postAction(new Function1<PAGImageView, Unit>(image, pagFilePath, repeatCount, imageIndex, this) { // from class: com.tencent.mobileqq.troop.widget.pag.TroopPagImageView$doPlay$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bitmap $image;
            final /* synthetic */ Integer $imageIndex;
            final /* synthetic */ String $pagFilePath;
            final /* synthetic */ int $repeatCount;
            final /* synthetic */ TroopPagImageView this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$image = image;
                this.$pagFilePath = pagFilePath;
                this.$repeatCount = repeatCount;
                this.$imageIndex = imageIndex;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, image, pagFilePath, Integer.valueOf(repeatCount), imageIndex, this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                invoke2(pAGImageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PAGImageView pagView) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) pagView);
                    return;
                }
                Intrinsics.checkNotNullParameter(pagView, "pagView");
                if (this.$image == null) {
                    pagView.setComposition(PagViewMonitor.Load(this.$pagFilePath));
                    pagView.setScaleMode(3);
                    pagView.setRepeatCount(this.$repeatCount);
                } else {
                    PAGFile Load = PagViewMonitor.Load(this.$pagFilePath);
                    PAGImage FromBitmap = PAGImage.FromBitmap(this.$image);
                    Integer num = this.$imageIndex;
                    Load.replaceImage(num != null ? num.intValue() : 0, FromBitmap);
                    pagView.setComposition(Load);
                    pagView.setScaleMode(3);
                    pagView.setRepeatCount(this.$repeatCount);
                }
                z16 = this.this$0.mEnablePlay;
                if (z16) {
                    pagView.play();
                }
            }
        });
    }

    static /* synthetic */ void f(TroopPagImageView troopPagImageView, String str, int i3, Integer num, Bitmap bitmap, PAGImageView.PAGImageViewListener pAGImageViewListener, int i16, Object obj) {
        Integer num2;
        Bitmap bitmap2;
        PAGImageView.PAGImageViewListener pAGImageViewListener2;
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i16 & 8) != 0) {
            bitmap2 = null;
        } else {
            bitmap2 = bitmap;
        }
        if ((i16 & 16) != 0) {
            pAGImageViewListener2 = null;
        } else {
            pAGImageViewListener2 = pAGImageViewListener;
        }
        troopPagImageView.e(str, i17, num2, bitmap2, pAGImageViewListener2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TroopPagImageView this$0, String pagFilePath) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pagFilePath, "$pagFilePath");
        f(this$0, pagFilePath, 0, null, null, null, 30, null);
    }

    private final void k() {
        this.vasPagView.api().postAction(TroopPagImageView$stopPag$1.INSTANCE);
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mLocalPagUrl;
    }

    public final void h(@NotNull String pagUrl, boolean enablePlay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, pagUrl, Boolean.valueOf(enablePlay));
            return;
        }
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        QLog.i("TroopPagImageView", 1, "play url:" + pagUrl);
        if (pagUrl.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mEnablePlay = enablePlay;
        this.mLocalPagUrl = pagUrl;
        TroopPAGLoader troopPAGLoader = TroopPAGLoader.f302618a;
        final String g16 = TroopPAGLoader.g(troopPAGLoader, pagUrl, false, 2, null);
        if (g16 == null) {
            g16 = "";
        }
        if (!TextUtils.isEmpty(g16) && new File(g16).exists()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.pag.a
                @Override // java.lang.Runnable
                public final void run() {
                    TroopPagImageView.i(TroopPagImageView.this, g16);
                }
            });
        } else {
            troopPAGLoader.j(this.mPagDownloadListener);
            troopPAGLoader.c(this.mPagDownloadListener);
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mEnablePlay = false;
            k();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDetachedFromWindow();
            TroopPAGLoader.f302618a.j(this.mPagDownloadListener);
        }
    }

    public final void setMLocalPagUrl(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mLocalPagUrl = str;
        }
    }

    public final void setPagListener(@Nullable final PAGImageView.PAGImageViewListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else {
            this.vasPagView.api().postAction(new Function1<PAGImageView, Unit>(listener) { // from class: com.tencent.mobileqq.troop.widget.pag.TroopPagImageView$setPagListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PAGImageView.PAGImageViewListener $listener;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$listener = listener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopPagImageView.this, (Object) listener);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGImageView pAGImageView) {
                    invoke2(pAGImageView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PAGImageView pagView) {
                    PAGImageView.PAGImageViewListener pAGImageViewListener;
                    PAGImageView.PAGImageViewListener pAGImageViewListener2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pagView);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(pagView, "pagView");
                    pAGImageViewListener = TroopPagImageView.this.mListener;
                    if (pAGImageViewListener != null) {
                        pAGImageViewListener2 = TroopPagImageView.this.mListener;
                        pagView.removeListener(pAGImageViewListener2);
                    }
                    TroopPagImageView.this.mListener = this.$listener;
                    PAGImageView.PAGImageViewListener pAGImageViewListener3 = this.$listener;
                    if (pAGImageViewListener3 != null) {
                        pagView.addListener(pAGImageViewListener3);
                    }
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopPagImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopPagImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopPagImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mEnablePlay = true;
        View findViewById = LayoutInflater.from(context).inflate(R.layout.g1e, (ViewGroup) this, true).findViewById(R.id.f116426yp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.vas_pag_view)");
        VasPagImageView vasPagImageView = (VasPagImageView) findViewById;
        this.vasPagView = vasPagImageView;
        vasPagImageView.api().build();
        this.mPagDownloadListener = new a();
    }
}
