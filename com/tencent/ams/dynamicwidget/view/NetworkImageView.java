package com.tencent.ams.dynamicwidget.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import com.tencent.ams.dynamicwidget.utils.b;
import com.tencent.ams.dynamicwidget.view.NetworkImageView;
import com.tencent.ams.fusion.widget.base.CustomImageView;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 !2\u00020\u0001:\u0002\"\u0018B\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R.\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/ams/dynamicwidget/view/NetworkImageView;", "Lcom/tencent/ams/fusion/widget/base/CustomImageView;", "", "src", "", "d", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "e", "value", "Ljava/lang/String;", "getSrc", "()Ljava/lang/String;", "setSrc", "(Ljava/lang/String;)V", "Lcom/tencent/ams/dynamicwidget/view/NetworkImageView$b;", "Lcom/tencent/ams/dynamicwidget/view/NetworkImageView$b;", "c", "()Lcom/tencent/ams/dynamicwidget/view/NetworkImageView$b;", "setLoadListener", "(Lcom/tencent/ams/dynamicwidget/view/NetworkImageView$b;)V", "loadListener", "f", "Landroid/graphics/Bitmap;", "b", "()Landroid/graphics/Bitmap;", "setErrorBitmap", "(Landroid/graphics/Bitmap;)V", "errorBitmap", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "a", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public class NetworkImageView extends CustomImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String src;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b loadListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap errorBitmap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ams/dynamicwidget/view/NetworkImageView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.view.NetworkImageView$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ams/dynamicwidget/view/NetworkImageView$b;", "", "", "src", "", HippyQQPagView.EventName.ON_LOAD_START, "onLoadFinish", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public interface b {
        void onLoadFinish(@Nullable String src);

        void onLoadStart(@Nullable String src);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NetworkImageView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
    }

    private final void d(final String src) {
        com.tencent.ams.dynamicwidget.utils.b.f70218a.a("NetworkImageView", "loadImage with src: " + src);
        Utils.runOnAsyncThread(new Runnable(src) { // from class: com.tencent.ams.dynamicwidget.view.NetworkImageView$loadImage$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f70226d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f70226d = src;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) NetworkImageView.this, (Object) src);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean startsWith$default;
                Bitmap bitmapFromFile;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                NetworkImageView.b c16 = NetworkImageView.this.c();
                if (c16 != null) {
                    c16.onLoadStart(this.f70226d);
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.f70226d, "http", false, 2, null);
                if (startsWith$default) {
                    bitmapFromFile = Utils.bitmapFromNet(this.f70226d);
                } else {
                    bitmapFromFile = Utils.bitmapFromFile(NetworkImageView.this.getContext(), this.f70226d);
                }
                if (bitmapFromFile != null) {
                    NetworkImageView.this.e(bitmapFromFile);
                } else if (NetworkImageView.this.b() != null) {
                    NetworkImageView networkImageView = NetworkImageView.this;
                    networkImageView.e(networkImageView.b());
                }
                NetworkImageView.b c17 = NetworkImageView.this.c();
                if (c17 != null) {
                    c17.onLoadFinish(this.f70226d);
                }
                b bVar = b.f70218a;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Locale locale = Locale.CHINA;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.CHINA");
                String format = String.format(locale, "loadImage finish cost: %dms, src: %s", Arrays.copyOf(new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), this.f70226d}, 2));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
                bVar.a("NetworkImageView", format);
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(final Bitmap bitmap) {
        if (bitmap != null) {
            Utils.runOnUiThread(new Runnable(bitmap, this) { // from class: com.tencent.ams.dynamicwidget.view.NetworkImageView$setBitmap$$inlined$let$lambda$1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f70225d;
                final /* synthetic */ NetworkImageView this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f70225d = bitmap;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.this$0.setImageBitmap(this.f70225d);
                    }
                }
            });
        }
    }

    @Nullable
    public final Bitmap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.errorBitmap;
    }

    @Nullable
    public final b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.loadListener;
    }

    public final void setErrorBitmap(@Nullable Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmap);
        } else {
            this.errorBitmap = bitmap;
        }
    }

    public final void setLoadListener(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.loadListener = bVar;
        }
    }

    public final void setSrc(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else if (str != null && (!Intrinsics.areEqual(this.src, str))) {
            this.src = str;
            d(str);
        }
    }
}
