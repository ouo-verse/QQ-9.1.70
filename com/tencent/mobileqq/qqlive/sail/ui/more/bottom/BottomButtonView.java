package com.tencent.mobileqq.qqlive.sail.ui.more.bottom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq4.e;
import wi2.c;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u001d\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tR\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Luq4/e;", DownloadInfo.spKey_Config, "Landroid/graphics/drawable/Drawable;", "p", "", "index", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "l", "iconUrl", "r", "t", "stop", "I", "buttonPosition", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", "iconDrawable", "D", "Luq4/e;", "buttonConfig", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class BottomButtonView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Drawable iconDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private e buttonConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int buttonPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView$a;", "", "", "APNG_MARGIN", "I", "ICON_MARGIN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.bottom.BottomButtonView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52618);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BottomButtonView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    private final Drawable p(final e config) {
        boolean isBlank;
        boolean isBlank2;
        if (config == null) {
            this.iconDrawable = null;
            return null;
        }
        String str = config.f439838c;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = config.f439837b;
        if (str3 != null) {
            str2 = str3;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!(!isBlank)) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                AegisLogger.INSTANCE.i("Bottom_Bar|BottomButtonView", "getOperateDrawable", "iconUrl=" + str);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = c.b(40);
                obtain.mRequestHeight = c.b(40);
                this.iconDrawable = URLDrawable.getDrawable(str2, obtain);
            } else {
                AegisLogger.INSTANCE.i("Bottom_Bar|BottomButtonView", "getOperateDrawable", "no url");
                this.iconDrawable = null;
            }
        } else {
            AegisLogger.INSTANCE.i("Bottom_Bar|BottomButtonView", "getOperateDrawable", "apngUrl=" + str);
            final APNGDrawable aPNGDrawable = new APNGDrawable("BottomButtonView", str);
            aPNGDrawable.setLoadedListener(new Function1<IDynamicDrawable, Unit>(config) { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.bottom.BottomButtonView$getOperateDrawable$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ e $config;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$config = config;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) APNGDrawable.this, (Object) config);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IDynamicDrawable iDynamicDrawable) {
                    invoke2(iDynamicDrawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IDynamicDrawable it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    Drawable currentDrawable = APNGDrawable.this.getCurrentDrawable();
                    URLDrawable uRLDrawable = currentDrawable instanceof URLDrawable ? (URLDrawable) currentDrawable : null;
                    Drawable currDrawable = uRLDrawable != null ? uRLDrawable.getCurrDrawable() : null;
                    ApngDrawable apngDrawable = currDrawable instanceof ApngDrawable ? (ApngDrawable) currDrawable : null;
                    ApngImage image = apngDrawable != null ? apngDrawable.getImage() : null;
                    if (image == null) {
                        return;
                    }
                    image.apngLoop = this.$config.f439840e;
                }
            });
            aPNGDrawable.start();
            this.iconDrawable = aPNGDrawable;
        }
        return this.iconDrawable;
    }

    private final void q(int index, e data) {
        AegisLogger.INSTANCE.i("Bottom_Bar|BottomButtonView", "buttonData index:" + index + ", buttonId:" + data.f439836a + ", disableLand: " + data.f439843h + "\n apngUrl:" + data.f439838c + ", \n iconUrl:" + data.f439837b + ", \n jumpUrl:" + data.f439839d + ", \n platCount:" + data.f439840e + ", webRatio:" + data.f439841f + ", webTrans:" + data.f439842g + "\n extData:" + data.f439844i);
    }

    public final void l(int index, @NotNull e data) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, index, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        q(index, data);
        this.buttonPosition = index + 1;
        this.buttonConfig = data;
        Drawable p16 = p(data);
        if (p16 != null) {
            setImageDrawable(p16);
            setVisibility(0);
        }
        String str = data.f439838c;
        Intrinsics.checkNotNullExpressionValue(str, "data.apngUrl");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            wi2.b.c(this, c.b(0));
        } else {
            wi2.b.c(this, c.b(8));
        }
    }

    @NotNull
    public final String m() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        e eVar = this.buttonConfig;
        if (eVar != null) {
            str = eVar.f439836a;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.buttonPosition;
    }

    public final void r(@NotNull String iconUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iconUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        if (TextUtils.isEmpty(iconUrl)) {
            return;
        }
        AegisLogger.INSTANCE.i("Bottom_Bar|BottomButtonView", "refreshUrl", "iconUrl=" + iconUrl);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = c.b(40);
        obtain.mRequestHeight = c.b(40);
        URLDrawable drawable = URLDrawable.getDrawable(iconUrl, obtain);
        this.iconDrawable = drawable;
        if (drawable != null) {
            setImageDrawable(drawable);
            setVisibility(0);
        }
        wi2.b.c(this, c.b(8));
    }

    public final void stop() {
        APNGDrawable aPNGDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Drawable drawable = this.iconDrawable;
        if (drawable instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) drawable;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.pauseApng();
        }
    }

    public final void t() {
        APNGDrawable aPNGDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Drawable drawable = this.iconDrawable;
        if (drawable instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) drawable;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.resumeApng();
        }
    }

    public /* synthetic */ BottomButtonView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BottomButtonView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            setVisibility(8);
            setBackgroundResource(R.drawable.l1x);
        }
    }
}
