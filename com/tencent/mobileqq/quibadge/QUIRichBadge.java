package com.tencent.mobileqq.quibadge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.quibadge.c;
import com.tencent.mobileqq.quibadge.helper.AvatarCarouselViewHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.state.data.SquareJSConst;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td0.m;
import ud0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u00a2\u0006\u0004\b=\u0010>B\u001b\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u00a2\u0006\u0004\b=\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J0\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J*\u0010\u0016\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007H\u0002J\u0016\u0010\u0017\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0012\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u001cH\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\"\u0010)\u001a\u00020(2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\f2\u0006\u0010+\u001a\u00020.H\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010+\u001a\u000200H\u0016J\u001c\u00102\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u00104\u001a\u00020\f2\u0006\u0010+\u001a\u000203H\u0016R\u0016\u00106\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/quibadge/QUIRichBadge;", "Landroid/widget/FrameLayout;", "", "", DomainData.DOMAIN_NAME, "", "url", "", "isAddRedPoint", "", "width", "height", "Landroid/view/View;", "g", "b", "Landroid/graphics/drawable/Drawable;", "drawable", "w", "", SquareJSConst.Params.PARAMS_UIN_LIST, "showAnim", "showRedDot", "d", "a", "Landroid/widget/FrameLayout$LayoutParams;", "f", "k", "dip", "", "c", "imageView", HippyTKDListViewAdapter.X, "p", "i", "text", "Landroid/widget/TextView;", "l", "textView", "Landroid/view/ViewGroup;", "o", "Lcom/tencent/image/URLDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/quibadge/c;", "model", "r", "v", "Lcom/tencent/mobileqq/quibadge/c$c;", "u", "Lcom/tencent/mobileqq/quibadge/c$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "Lcom/tencent/mobileqq/quibadge/c$b;", ReportConstant.COSTREPORT_PREFIX, "I", "mViewType", "Ltd0/m;", "e", "Ltd0/m;", "urlDrawableDelegate", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class QUIRichBadge extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mViewType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private m urlDrawableDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/quibadge/QUIRichBadge$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.quibadge.QUIRichBadge$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/quibadge/QUIRichBadge$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes17.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f276967d;

        b(String str) {
            this.f276967d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            Drawable.Callback callback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
                return;
            }
            d.g("QUIBadge_Rich", d.f438809c, "[onLoadCanceled]: " + this.f276967d);
            if (drawable != null) {
                callback = drawable.getCallback();
            } else {
                callback = null;
            }
            if (!(callback instanceof View)) {
                callback = null;
            }
            View view = (View) callback;
            if (view != null) {
                view.requestLayout();
            }
            if (drawable != null) {
                drawable.setURLDrawableListener(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            Drawable.Callback callback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable, (Object) cause);
                return;
            }
            d.g("QUIBadge_Rich", d.f438809c, "[onLoadFailed]: " + this.f276967d);
            if (drawable != null) {
                callback = drawable.getCallback();
            } else {
                callback = null;
            }
            if (!(callback instanceof View)) {
                callback = null;
            }
            View view = (View) callback;
            if (view != null) {
                view.requestLayout();
            }
            if (drawable != null) {
                drawable.setURLDrawableListener(null);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, progress);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            Drawable.Callback callback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
                return;
            }
            d.g("QUIBadge_Rich", d.f438809c, "[onLoadSucceed]: " + this.f276967d);
            if (drawable != null) {
                callback = drawable.getCallback();
            } else {
                callback = null;
            }
            if (!(callback instanceof View)) {
                callback = null;
            }
            View view = (View) callback;
            if (view != null) {
                view.requestLayout();
            }
            if (drawable != null) {
                drawable.setURLDrawableListener(null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QUIRichBadge(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final boolean a(List<String> uinList) {
        boolean z16;
        Iterator<String> it = uinList.iterator();
        do {
            z16 = false;
            if (!it.hasNext()) {
                return false;
            }
            if (it.next().length() > 0) {
                z16 = true;
            }
        } while (!z16);
        return true;
    }

    private final boolean b(String url) {
        try {
            new URL(url);
            return true;
        } catch (FileNotFoundException e16) {
            d.a("QUIBadge_Rich", d.f438811e, "File not found: " + e16.getMessage() + ", url: " + url + '.');
            return false;
        } catch (IOException e17) {
            d.a("QUIBadge_Rich", d.f438811e, "IO error: " + e17.getMessage() + ", url: " + url + '.');
            return false;
        }
    }

    private final int c(float dip) {
        return e.a(dip);
    }

    private final View d(List<String> uinList, boolean showAnim, boolean showRedDot) {
        if (!a(uinList)) {
            d.k("QUIBadge_Rich", d.f438811e, "[getAvatarRedPoint] checkUinListLegal fail: " + uinList + ", showRedDot:" + showRedDot);
            if (showRedDot) {
                return j(this, 0, 1, null);
            }
            return new ImageView(getContext());
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FrameLayout x16 = x(new AvatarCarouselViewHelper(context).k(uinList, showAnim));
        if (showRedDot) {
            return p(x16);
        }
        return x16;
    }

    static /* synthetic */ View e(QUIRichBadge qUIRichBadge, List list, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return qUIRichBadge.d(list, z16, z17);
    }

    private final FrameLayout.LayoutParams f() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    private final View g(String url, boolean isAddRedPoint, float width, float height) {
        Drawable drawable = null;
        if (!b(url)) {
            d.k("QUIBadge_Rich", d.f438811e, "[getImageRedPoint] checkUrlLegal fail: " + url + "\uff0cisAddRedPoint\uff1a" + isAddRedPoint);
            if (isAddRedPoint) {
                return j(this, 0, 1, null);
            }
            return new ImageView(getContext());
        }
        m mVar = this.urlDrawableDelegate;
        if (mVar != null) {
            Intrinsics.checkNotNull(mVar);
            drawable = mVar.b(getContext(), url);
        }
        if (drawable == null) {
            d.c("QUIBadge_Rich", "[getImageRedPoint] \u5c55\u793a\u9759\u6001\u56fe");
            drawable = m(url, width, height);
        }
        w(drawable, url);
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        FrameLayout.LayoutParams f16 = f();
        f16.height = c(height);
        imageView.setLayoutParams(f16);
        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxWidth(c(width));
        FrameLayout x16 = x(imageView);
        if (!isAddRedPoint) {
            return x16;
        }
        return p(x16);
    }

    static /* synthetic */ View h(QUIRichBadge qUIRichBadge, String str, boolean z16, float f16, float f17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            f16 = 32.0f;
        }
        if ((i3 & 8) != 0) {
            f17 = 32.0f;
        }
        return qUIRichBadge.g(str, z16, f16, f17);
    }

    private final FrameLayout i(int height) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        View k3 = k();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, height);
        layoutParams.gravity = 21;
        k3.setLayoutParams(layoutParams);
        frameLayout.addView(k3);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, height);
        layoutParams2.gravity = 16;
        frameLayout.setLayoutParams(layoutParams2);
        return frameLayout;
    }

    static /* synthetic */ FrameLayout j(QUIRichBadge qUIRichBadge, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = -2;
        }
        return qUIRichBadge.i(i3);
    }

    private final View k() {
        QUIBadge qUIBadge = new QUIBadge(getContext());
        qUIBadge.setRedDot();
        return qUIBadge;
    }

    private final TextView l(String text) {
        boolean z16;
        TextView textView = new TextView(getContext());
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int k3 = com.tencent.mobileqq.quibadge.helper.a.k(context);
        textView.setText(com.tencent.mobileqq.quibadge.helper.a.p(text, 8, 8, true));
        textView.setTextColor(k3);
        textView.setTextSize(2, com.tencent.mobileqq.quibadge.helper.a.l());
        textView.setSingleLine(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        textView.setPadding(0, 0, c(4.0f), 0);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private final URLDrawable m(String url, float width, float height) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "URLDrawableOptions.obtain()");
        obtain.mLoadingDrawable = null;
        obtain.mFailedDrawable = null;
        obtain.mRequestWidth = c(width);
        obtain.mRequestHeight = c(height);
        obtain.mUseApngImage = true;
        obtain.mPlayGifImage = true;
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 0);
        Unit unit = Unit.INSTANCE;
        obtain.mExtraInfo = bundle;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "URLDrawable.getDrawable(url, options)");
        return drawable;
    }

    private final void n() {
        removeAllViews();
    }

    private final ViewGroup o(TextView textView, View imageView) {
        FlexboxLayout flexboxLayout = new FlexboxLayout(getContext());
        flexboxLayout.setFlexDirection(0);
        flexboxLayout.setAlignItems(2);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        layoutParams.b(0.0f);
        Unit unit = Unit.INSTANCE;
        imageView.setLayoutParams(layoutParams);
        if (textView != null) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
            flexboxLayout.addView(textView);
        }
        flexboxLayout.addView(imageView);
        return flexboxLayout;
    }

    private final FrameLayout p(View imageView) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(imageView);
        View k3 = k();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        k3.setLayoutParams(layoutParams);
        frameLayout.addView(k3);
        frameLayout.setLayoutParams(f());
        return frameLayout;
    }

    private final boolean w(Drawable drawable, String url) {
        if (drawable != null && (drawable instanceof URLDrawable)) {
            ((URLDrawable) drawable).setURLDrawableListener(new b(url));
            return true;
        }
        return false;
    }

    private final FrameLayout x(View imageView) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        int c16 = c(4.0f);
        frameLayout.setLayoutParams(f());
        frameLayout.setPadding(c16, c16, c16, c16);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 17;
            imageView.setLayoutParams(layoutParams2);
        }
        frameLayout.addView(imageView);
        return frameLayout;
    }

    @NotNull
    public View q(@NotNull c.a model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        List<String> c16 = model.c();
        String b16 = model.b();
        boolean a16 = model.a();
        d.g("QUIBadge_Rich", d.f438811e, "[setRichAvatarDot] uinList:" + c16 + ", text:" + b16);
        n();
        this.mViewType = 102;
        addView(o(l(b16), e(this, c16, a16, false, 4, null)));
        return this;
    }

    @NotNull
    public View r(@NotNull c model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        if (model instanceof c.C8449c) {
            return u((c.C8449c) model);
        }
        if (model instanceof c.a) {
            return q((c.a) model);
        }
        if (model instanceof c.b) {
            return s((c.b) model);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public View s(@NotNull c.b model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return t(model.a(), model.b());
    }

    @NotNull
    public View t(@Nullable String text, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) text, (Object) url);
        }
        d.g("QUIBadge_Rich", d.f438811e, "[setRichIconDot] text:" + text + ", url:" + url);
        n();
        this.mViewType = 101;
        addView(o(l(text), h(this, url, false, 0.0f, 0.0f, 14, null)));
        return this;
    }

    @NotNull
    public View u(@NotNull c.C8449c model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return v(model.a());
    }

    @NotNull
    public View v(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        d.g("QUIBadge_Rich", d.f438811e, "[setRichImageDot] url:" + url);
        n();
        this.mViewType = 103;
        addView(h(this, url, true, 136.0f, 0.0f, 8, null));
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIRichBadge(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.urlDrawableDelegate = (m) ud0.c.a(m.class);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
