package com.tencent.biz.qui.quiemptystate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableView;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ud0.b;
import ud0.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0002;<B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\tJ \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J(\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0002J\u001a\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010*\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010+\u001a\u00020'H\u0002J \u0010,\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0016H\u0002J\u0018\u0010.\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010/\u001a\u00020'H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u00103\u001a\u00020#H\u0014J\b\u00104\u001a\u00020#H\u0014J\b\u00105\u001a\u00020#H\u0016J&\u00106\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u00107\u001a\u00020\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u000e\u00108\u001a\u00020#2\u0006\u0010+\u001a\u00020'J\u000e\u00109\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u0010J\u001e\u00109\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0016J\u000e\u0010:\u001a\u00020#2\u0006\u0010/\u001a\u00020'R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "context", "Landroid/content/Context;", "builder", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState$Builder;", "(Landroid/content/Context;Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState$Builder;)V", "button", "Lcom/tencent/biz/qui/quibutton/QUIButton;", ParseCommon.CONTAINER, "descTextView", "Landroid/widget/TextView;", "imageView", "Landroid/widget/ImageView;", "lastMarginTop", "", "mBuilder", "onPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "titleTextView", "adjustFullScreenCenterGravity", "", "getButton", "getDrawable", "Landroid/graphics/drawable/Drawable;", "themeType", "resId", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "getImageResIdByImageType", "getQuiTokenDrawable", "drawableResId", "colorResId", "themeId", "initBgColor", "", "bgColorType", "initBtn", TuxUIConstants.POP_BTN_TEXT, "", "btnOnClickListener", "Landroid/view/View$OnClickListener;", "initDesc", "desc", "initImageView", "halfScreenState", "initTitle", "title", "initViews", "mutateDrawable", "drawable", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onThemeChanged", "setBtnText", "btnStyle", "setDesc", "setImageView", "setTitle", "Builder", "Companion", "QUIEmptyState_debug"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class QUIEmptyState extends LinearLayout implements SkinnableView {
    private static final int FULL_SCREEN_IMAGE_HEIGHT_DP = 100;
    private static final int FULL_SCREEN_IMAGE_WIDTH_DP = 100;
    private static final int HALF_SCREEN_IMAGE_HEIGHT_DP = 80;
    private static final int HALF_SCREEN_IMAGE_WIDTH_DP = 80;
    private static final String TAG = "QUIEmptyState";
    private final QUIButton button;
    private final LinearLayout container;
    private final TextView descTextView;
    private final ImageView imageView;
    private int lastMarginTop;
    private Builder mBuilder;
    private ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    private final TextView titleTextView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\nJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\rJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "autoCenter", "", "bgColorType", "", "btnOnClickListener", "Landroid/view/View$OnClickListener;", "btnStyle", TuxUIConstants.POP_BTN_TEXT, "", "desc", "halfScreenState", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "themeType", "title", "build", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "getAutoCenter", "getBgColorType", "getBtnOnClickListener", "getBtnStyle", "getBtnText", "getDesc", "getHalfScreenState", "getImageType", "getThemeType", "getTitle", "setAutoCenter", "setBackgroundColorType", "setButton", "text", "listener", "setDesc", "setHalfScreenState", "setImageType", "setThemeType", "setTitle", "QUIEmptyState_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class Builder {
        private View.OnClickListener btnOnClickListener;
        private Context context;
        private boolean halfScreenState;
        private int imageType;
        private int themeType;
        private int bgColorType = 1;
        private String title = "";
        private String desc = "";
        private String btnText = "";
        private int btnStyle = 1;
        private boolean autoCenter = true;

        public Builder(@Nullable Context context) {
            if (context == null) {
                if (!b.d()) {
                    Context a16 = b.a();
                    Intrinsics.checkNotNullExpressionValue(a16, "QUIApplication.getApplication()");
                    this.context = a16.getApplicationContext();
                    return;
                }
                throw new IllegalArgumentException("context is null!".toString());
            }
            this.context = context;
        }

        @NotNull
        public final QUIEmptyState build() {
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            return new QUIEmptyState(context, this);
        }

        public final boolean getAutoCenter() {
            return this.autoCenter;
        }

        public final int getBgColorType() {
            return this.bgColorType;
        }

        @Nullable
        public final View.OnClickListener getBtnOnClickListener() {
            return this.btnOnClickListener;
        }

        public final int getBtnStyle() {
            return this.btnStyle;
        }

        @NotNull
        public final String getBtnText() {
            return this.btnText;
        }

        @NotNull
        public final String getDesc() {
            return this.desc;
        }

        public final boolean getHalfScreenState() {
            return this.halfScreenState;
        }

        public final int getImageType() {
            return this.imageType;
        }

        public final int getThemeType() {
            return this.themeType;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final Builder setAutoCenter(boolean autoCenter) {
            this.autoCenter = autoCenter;
            return this;
        }

        @NotNull
        public final Builder setBackgroundColorType(int bgColorType) {
            this.bgColorType = bgColorType;
            return this;
        }

        @NotNull
        public final Builder setButton(@NotNull String text, @Nullable View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.btnText = text;
            this.btnOnClickListener = listener;
            return this;
        }

        @NotNull
        public final Builder setDesc(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.desc = text;
            return this;
        }

        @NotNull
        public final Builder setHalfScreenState(boolean halfScreenState) {
            this.halfScreenState = halfScreenState;
            this.btnStyle = !halfScreenState ? 1 : 0;
            return this;
        }

        @NotNull
        public final Builder setImageType(int imageType) {
            this.imageType = imageType;
            return this;
        }

        @NotNull
        public final Builder setThemeType(int themeType) {
            this.themeType = themeType;
            return this;
        }

        @NotNull
        public final Builder setTitle(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.title = text;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qui/quiemptystate/QUIEmptyState$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "QUIEmptyState_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            boolean z16;
            if (!QUIEmptyState.this.mBuilder.getHalfScreenState() && QUIEmptyState.this.mBuilder.getAutoCenter()) {
                z16 = QUIEmptyState.this.adjustFullScreenCenterGravity();
            } else {
                z16 = false;
            }
            QUIEmptyState.this.getViewTreeObserver().removeOnPreDrawListener(this);
            return !z16;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIEmptyState(@NotNull Context context, @NotNull Builder builder) {
        super(context);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        View inflate = LayoutInflater.from(context).inflate(com.tencent.mobileqq.R.layout.e7_, (ViewGroup) this, false);
        if (inflate != null) {
            LinearLayout linearLayout = (LinearLayout) inflate;
            this.container = linearLayout;
            addView(linearLayout, new ViewGroup.MarginLayoutParams(-2, -2));
            setOrientation(1);
            setGravity(17);
            View findViewById = findViewById(com.tencent.mobileqq.R.id.uuj);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.empty_state_image)");
            this.imageView = (ImageView) findViewById;
            View findViewById2 = findViewById(com.tencent.mobileqq.R.id.uuo);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.empty_state_title)");
            this.titleTextView = (TextView) findViewById2;
            View findViewById3 = findViewById(com.tencent.mobileqq.R.id.uui);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.empty_state_desc)");
            this.descTextView = (TextView) findViewById3;
            if (builder.getBtnStyle() == 0) {
                i3 = com.tencent.mobileqq.R.id.uum;
            } else {
                i3 = com.tencent.mobileqq.R.id.uuk;
            }
            View findViewById4 = findViewById(i3);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(\n          \u2026tate_medium_btn\n        )");
            this.button = (QUIButton) findViewById4;
            initViews(builder);
            this.mBuilder = builder;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean adjustFullScreenCenterGravity() {
        int g16;
        int i3;
        int i16;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int height = this.container.getHeight();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        if (resources.getConfiguration().orientation == 2) {
            g16 = e.i();
            i3 = (g16 - height) - iArr[1];
        } else {
            g16 = e.g();
            i3 = iArr[1];
        }
        if (i3 <= 0 || g16 <= 0 || height <= 0 || this.lastMarginTop == (i16 = (i3 - ((g16 - height) / 2)) / 2)) {
            return false;
        }
        this.lastMarginTop = i16;
        ViewGroup.LayoutParams layoutParams = this.container.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i16;
            this.container.setLayoutParams(marginLayoutParams);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final Drawable getDrawable(int themeType, int resId, int imageType) {
        int i3;
        if (imageType == 15) {
            i3 = com.tencent.mobileqq.R.color.qui_common_fill_standard_primary;
        } else {
            i3 = com.tencent.mobileqq.R.color.qui_common_icon_primary;
        }
        if (themeType == 2) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return getQuiTokenDrawable(context, resId, i3, 1002);
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        return getQuiTokenDrawable(context2, resId, i3, 1000);
    }

    private final int getImageResIdByImageType(int imageType) {
        switch (imageType) {
            case 1:
                return com.tencent.mobileqq.R.drawable.oi5;
            case 2:
                return com.tencent.mobileqq.R.drawable.empty_state_file;
            case 3:
                return com.tencent.mobileqq.R.drawable.oih;
            case 4:
                return com.tencent.mobileqq.R.drawable.oil;
            case 5:
                return com.tencent.mobileqq.R.drawable.oid;
            case 6:
                return com.tencent.mobileqq.R.drawable.oii;
            case 7:
                return com.tencent.mobileqq.R.drawable.oie;
            case 8:
                return com.tencent.mobileqq.R.drawable.oia;
            case 9:
                return com.tencent.mobileqq.R.drawable.oik;
            case 10:
                return com.tencent.mobileqq.R.drawable.oim;
            case 11:
                return com.tencent.mobileqq.R.drawable.oi9;
            case 12:
                return com.tencent.mobileqq.R.drawable.oif;
            case 13:
                return com.tencent.mobileqq.R.drawable.oi8;
            case 14:
                return com.tencent.mobileqq.R.drawable.oij;
            case 15:
                return com.tencent.mobileqq.R.drawable.oi6;
            case 16:
                return com.tencent.mobileqq.R.drawable.oi_;
            case 17:
                return com.tencent.mobileqq.R.drawable.oib;
            case 18:
                return com.tencent.mobileqq.R.drawable.oic;
            case 19:
                return com.tencent.mobileqq.R.drawable.oig;
            case 20:
                return com.tencent.mobileqq.R.drawable.oi7;
            default:
                return 0;
        }
    }

    private final Drawable getQuiTokenDrawable(Context context, int drawableResId, int colorResId, int themeId) {
        int g16 = ie0.a.f().g(context, colorResId, themeId);
        Drawable mutateDrawable = mutateDrawable(context.getDrawable(drawableResId));
        mutateDrawable.setColorFilter(new PorterDuffColorFilter(g16, PorterDuff.Mode.SRC_IN));
        return mutateDrawable;
    }

    private final void initBgColor(int themeType, int bgColorType) {
        int i3;
        if (themeType == 2) {
            i3 = 1002;
        } else {
            i3 = 1000;
        }
        if (bgColorType != 1) {
            if (bgColorType != 2) {
                setBackgroundColor(0);
                return;
            } else {
                setBackgroundColor(ie0.a.f().g(getContext(), com.tencent.mobileqq.R.color.qui_common_bg_bottom_standard, i3));
                return;
            }
        }
        setBackgroundColor(ie0.a.f().g(getContext(), com.tencent.mobileqq.R.color.qui_common_bg_bottom_light, i3));
    }

    private final void initBtn(String btnText, View.OnClickListener btnOnClickListener) {
        if (!TextUtils.isEmpty(btnText)) {
            this.button.setText(btnText);
            this.button.setOnClickListener(btnOnClickListener);
            this.button.setVisibility(0);
        }
    }

    private final void initDesc(int themeType, String desc) {
        int i3;
        if (themeType == 2) {
            i3 = 1002;
        } else {
            i3 = 1000;
        }
        this.descTextView.setTextColor(ie0.a.f().g(getContext(), com.tencent.mobileqq.R.color.qui_common_text_secondary, i3));
        if (!TextUtils.isEmpty(desc)) {
            this.descTextView.setText(desc);
            this.descTextView.setVisibility(0);
        }
    }

    private final void initImageView(int themeType, int imageType, boolean halfScreenState) {
        if (imageType != 0) {
            this.imageView.setImageDrawable(getDrawable(themeType, getImageResIdByImageType(imageType), imageType));
            this.imageView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
            if (layoutParams != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                if (halfScreenState) {
                    float f16 = 80;
                    layoutParams2.height = e.d(getContext(), f16);
                    layoutParams2.width = e.d(getContext(), f16);
                } else {
                    float f17 = 100;
                    layoutParams2.height = e.d(getContext(), f17);
                    layoutParams2.width = e.d(getContext(), f17);
                }
                this.imageView.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }

    private final void initTitle(int themeType, String title) {
        int i3;
        if (themeType == 2) {
            i3 = 1002;
        } else {
            i3 = 1000;
        }
        this.titleTextView.setTextColor(ie0.a.f().g(getContext(), com.tencent.mobileqq.R.color.qui_common_text_primary, i3));
        if (!TextUtils.isEmpty(title)) {
            this.titleTextView.setText(title);
            this.titleTextView.setVisibility(0);
        }
    }

    private final void initViews(Builder builder) {
        initImageView(builder.getThemeType(), builder.getImageType(), builder.getHalfScreenState());
        initBgColor(builder.getThemeType(), builder.getBgColorType());
        initTitle(builder.getThemeType(), builder.getTitle());
        initDesc(builder.getThemeType(), builder.getDesc());
        initBtn(builder.getBtnText(), builder.getBtnOnClickListener());
    }

    private final Drawable mutateDrawable(Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            Drawable mutate2 = ((SkinnableBitmapDrawable) drawable).mutate2();
            Intrinsics.checkNotNullExpressionValue(mutate2, "drawable.mutate2()");
            return mutate2;
        }
        Intrinsics.checkNotNull(drawable);
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "drawable!!.mutate()");
        return mutate;
    }

    public static /* synthetic */ void setBtnText$default(QUIEmptyState qUIEmptyState, String str, int i3, View.OnClickListener onClickListener, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            onClickListener = null;
        }
        qUIEmptyState.setBtnText(str, i3, onClickListener);
    }

    @NotNull
    public final QUIButton getButton() {
        return this.button;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.onPreDrawListener == null) {
            this.onPreDrawListener = new a();
        }
        getViewTreeObserver().addOnPreDrawListener(this.onPreDrawListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getViewTreeObserver().removeOnPreDrawListener(this.onPreDrawListener);
        } catch (IllegalStateException e16) {
            d.b(TAG, d.f438811e, "onDetachedFromWindow:" + e16);
        }
        this.onPreDrawListener = null;
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        initViews(this.mBuilder);
    }

    @JvmOverloads
    public final void setBtnText(@Nullable String str, int i3) {
        setBtnText$default(this, str, i3, null, 4, null);
    }

    public final void setDesc(@NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (!TextUtils.isEmpty(desc)) {
            this.descTextView.setText(desc);
            this.descTextView.setVisibility(0);
        }
    }

    public final void setImageView(int imageType) {
        this.imageView.setImageDrawable(getDrawable(this.mBuilder.getThemeType(), getImageResIdByImageType(imageType), imageType));
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!TextUtils.isEmpty(title)) {
            this.titleTextView.setText(title);
            this.titleTextView.setVisibility(0);
        }
    }

    @JvmOverloads
    public final void setBtnText(@Nullable String btnText, int btnStyle, @Nullable View.OnClickListener btnOnClickListener) {
        View findViewById = findViewById(btnStyle == 0 ? com.tencent.mobileqq.R.id.uum : com.tencent.mobileqq.R.id.uuk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(\n          \u2026tate_medium_btn\n        )");
        QUIButton qUIButton = (QUIButton) findViewById;
        if (!TextUtils.isEmpty(btnText)) {
            qUIButton.setText(btnText);
        }
        if (btnOnClickListener != null) {
            qUIButton.setOnClickListener(btnOnClickListener);
        }
    }

    public final void setImageView(int themeType, int imageType, boolean halfScreenState) {
        initImageView(themeType, imageType, halfScreenState);
    }
}
