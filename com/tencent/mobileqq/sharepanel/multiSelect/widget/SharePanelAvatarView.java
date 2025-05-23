package com.tencent.mobileqq.sharepanel.multiSelect.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\u000bB1\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0003\u0010#\u001a\u00020\u0006\u0012\b\b\u0003\u0010$\u001a\u00020\u0006\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/SharePanelAvatarView;", "Landroid/widget/FrameLayout;", "", "show", "", "c", "", "borderViewSize", NodeProps.BORDER_WIDTH, NodeProps.BORDER_COLOR, "Landroid/graphics/Bitmap;", "a", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "data", "b", "newBorderWidth", "setBorder", "size", "setAvatarSize", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "avatar", "e", "icon", "f", "borderView", h.F, "I", "i", "avatarSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelAvatarView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView avatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView borderView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int borderWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int avatarSize;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/SharePanelAvatarView$a;", "", "", "ICON_OFFSET", UserInfo.SEX_FEMALE, "ICON_SCALE", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.widget.SharePanelAvatarView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40654);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SharePanelAvatarView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final Bitmap a(int borderViewSize, int borderWidth, int borderColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke(borderWidth, borderColor);
        gradientDrawable.setSize(borderViewSize, borderViewSize);
        Bitmap bitmap = Bitmap.createBitmap(borderViewSize, borderViewSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        gradientDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        gradientDrawable.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    private final void c(boolean show) {
        int i3;
        if (show) {
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.drawable.jns;
            } else {
                i3 = R.drawable.jnr;
            }
            this.icon.setImageDrawable(getContext().getResources().getDrawable(i3, null));
            this.icon.setVisibility(0);
            return;
        }
        this.icon.setVisibility(8);
    }

    public static /* synthetic */ void setBorder$default(SharePanelAvatarView sharePanelAvatarView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = -1;
        }
        sharePanelAvatarView.setBorder(i3, i16);
    }

    public final void b(@NotNull SharePanelContactItem data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = this.avatar;
        com.tencent.mobileqq.sharepanel.multiSelect.util.a aVar = com.tencent.mobileqq.sharepanel.multiSelect.util.a.f287480a;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "avatar.context");
        imageView.setImageDrawable(aVar.b(context, data));
        c(data.g());
    }

    public final void setAvatarSize(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, size);
            return;
        }
        this.avatarSize = size;
        ViewGroup.LayoutParams layoutParams = this.avatar.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = this.avatarSize;
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.avatar.setLayoutParams(layoutParams);
        int i16 = this.avatarSize;
        int i17 = (int) (i16 * 0.55f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i17, i17);
        layoutParams2.gravity = 85;
        int i18 = -((int) (i16 * 0.075f));
        layoutParams2.bottomMargin = i18;
        layoutParams2.rightMargin = i18;
        this.icon.setLayoutParams(layoutParams2);
    }

    public final void setBorder(int newBorderWidth, int borderColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(newBorderWidth), Integer.valueOf(borderColor));
            return;
        }
        if (newBorderWidth <= 0) {
            this.borderWidth = 0;
            this.borderView.setVisibility(8);
            return;
        }
        this.borderWidth = newBorderWidth;
        this.borderView.setVisibility(0);
        int i3 = this.avatarSize + (this.borderWidth * 2);
        ViewGroup.LayoutParams layoutParams = this.borderView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.borderView.setLayoutParams(layoutParams);
        this.borderView.setImageBitmap(a(i3, this.borderWidth, borderColor));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SharePanelAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SharePanelAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ SharePanelAvatarView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SharePanelAvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.avatarSize = ViewUtils.dpToPx(20.0f);
        ImageView imageView = new ImageView(context);
        this.avatar = imageView;
        int i17 = this.avatarSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i17, i17);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.borderView = imageView2;
        imageView2.setVisibility(8);
        int i18 = this.avatarSize;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i18, i18);
        layoutParams2.gravity = 17;
        addView(imageView2, layoutParams2);
        ImageView imageView3 = new ImageView(context);
        this.icon = imageView3;
        addView(imageView3);
    }
}
