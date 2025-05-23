package com.tencent.mobileqq.qwallet.pay.recommend;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pay.AdPositionEnum;
import com.tencent.mobileqq.qwallet.pay.recommend.b;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 =*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001>B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b<\u00102J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\r\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00138\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\"\u0010*\u001a\u00020\u00138\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\"\u0010.\u001a\u00020\u00138\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\"\u00103\u001a\u00020\u000e8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b/\u0010\u000f\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/d;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "topOffset", "bottomOffset", "radius", "", "w", "data", "D", "(Lcom/tencent/mobileqq/qwallet/pay/recommend/b;)V", "E", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "t", "()Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "(Landroid/widget/TextView;)V", "topTitle", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "r", "()Landroid/widget/ImageView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/widget/ImageView;)V", "logoView", "H", ReportConstant.COSTREPORT_PREFIX, "B", "titleView", "I", "p", "y", "descView", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "jumpBtn", "K", "o", "v", "(Landroid/view/View;)V", "bottomLine", "Landroid/view/ViewGroup;", "L", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/ViewGroup;", "u", "(Landroid/view/ViewGroup;)V", "adItemContainer", "<init>", "M", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class d<T extends com.tencent.mobileqq.qwallet.pay.recommend.b> extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: F, reason: from kotlin metadata */
    public TextView topTitle;

    /* renamed from: G, reason: from kotlin metadata */
    public ImageView logoView;

    /* renamed from: H, reason: from kotlin metadata */
    public TextView titleView;

    /* renamed from: I, reason: from kotlin metadata */
    public TextView descView;

    /* renamed from: J, reason: from kotlin metadata */
    public TextView jumpBtn;

    /* renamed from: K, reason: from kotlin metadata */
    public View bottomLine;

    /* renamed from: L, reason: from kotlin metadata */
    public ViewGroup adItemContainer;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f278688a;

        static {
            int[] iArr = new int[AdPositionEnum.values().length];
            try {
                iArr[AdPositionEnum.Top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdPositionEnum.Middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdPositionEnum.Bottom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdPositionEnum.Single.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f278688a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/pay/recommend/d$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f278689a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d<T> f278690b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f278691c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f278692d;

        c(int i3, d<T> dVar, int i16, int i17) {
            this.f278689a = i3;
            this.f278690b = dVar;
            this.f278691c = i16;
            this.f278692d = i17;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (view != null && outline != null) {
                outline.setRoundRect(0, this.f278689a, this.f278690b.m().getWidth(), this.f278690b.m().getHeight() + this.f278691c, this.f278692d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    private final void w(final int topOffset, final int bottomOffset, final int radius) {
        m().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pay.recommend.c
            @Override // java.lang.Runnable
            public final void run() {
                d.x(d.this, topOffset, bottomOffset, radius);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(d this$0, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m().setOutlineProvider(new c(i3, this$0, i16, i17));
        this$0.m().setClipToOutline(true);
    }

    public final void A(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.logoView = imageView;
    }

    public final void B(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleView = textView;
    }

    public final void C(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.topTitle = textView;
    }

    public final void D(@NotNull com.tencent.mobileqq.qwallet.pay.recommend.b data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        TextView t16 = t();
        String title = data.getTitle();
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            t16.setVisibility(8);
        } else {
            t16.setVisibility(0);
            t16.setText(data.getTitle());
        }
    }

    public final void E(@NotNull com.tencent.mobileqq.qwallet.pay.recommend.b data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i3 = b.f278688a[data.getPositionEnum().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        o().setVisibility(8);
                        w(0, 0, 25);
                        return;
                    }
                    return;
                }
                o().setVisibility(8);
                w(-25, 0, 25);
                return;
            }
            o().setVisibility(0);
            w(0, 0, 0);
            return;
        }
        o().setVisibility(0);
        w(0, 25, 25);
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @NotNull
    public final ViewGroup m() {
        ViewGroup viewGroup = this.adItemContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adItemContainer");
        return null;
    }

    @NotNull
    public final View o() {
        View view = this.bottomLine;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
        return null;
    }

    @NotNull
    public final TextView p() {
        TextView textView = this.descView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("descView");
        return null;
    }

    @NotNull
    public final TextView q() {
        TextView textView = this.jumpBtn;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jumpBtn");
        return null;
    }

    @NotNull
    public final ImageView r() {
        ImageView imageView = this.logoView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logoView");
        return null;
    }

    @NotNull
    public final TextView s() {
        TextView textView = this.titleView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    @NotNull
    public final TextView t() {
        TextView textView = this.topTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topTitle");
        return null;
    }

    public final void u(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.adItemContainer = viewGroup;
    }

    public final void v(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.bottomLine = view;
    }

    public final void y(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.descView = textView;
    }

    public final void z(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.jumpBtn = textView;
    }
}
