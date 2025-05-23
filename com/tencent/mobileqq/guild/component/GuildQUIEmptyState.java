package com.tencent.mobileqq.guild.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.f;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0002DEB\u0017\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u001a\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0014J\b\u0010\u001f\u001a\u00020\u0005H\u0014J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010'\u001a\u00020&J\u001e\u0010%\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007J\b\u0010(\u001a\u00020\u0005H\u0016R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010)R\u0014\u0010,\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00101R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u00101R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00104R\u0014\u00108\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "Landroid/widget/LinearLayout;", "Lcom/tencent/theme/SkinnableView;", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState$a;", "builder", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "c", "", "themeType", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "halfScreenState", "j", "resId", "Landroid/graphics/drawable/Drawable;", "e", "bgColorType", "g", "", "title", "l", "desc", "i", TuxUIConstants.POP_BTN_TEXT, "Landroid/view/View$OnClickListener;", "btnOnClickListener", h.F, "k", "f", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "setTitle", "colorResId", "themeId", "setTitleColor", "setDesc", "setImageView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "d", "onThemeChanged", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState$a;", "mBuilder", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleTextView", "descTextView", "I", "lastMarginTop", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "button", "D", "secondaryButton", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "E", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDrawListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState$a;)V", UserInfo.SEX_FEMALE, "a", "b", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public final class GuildQUIEmptyState extends LinearLayout implements SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QUIButton button;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final QUIButton secondaryButton;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ViewTreeObserver.OnPreDrawListener onPreDrawListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a mBuilder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView imageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titleTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView descTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastMarginTop;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b1\u00102J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0002J\b\u0010 \u001a\u0004\u0018\u00010\u000eJ\b\u0010!\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\"\u001a\u00020\u0005R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010&R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010&R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010'R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010,R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010,R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010'\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState$a;", "", "", NodeProps.CUSTOM_PROP_IMAGE_TYPE, ReportConstant.COSTREPORT_PREFIX, "", "halfScreenState", "r", "bgColorType", "o", "", "text", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View$OnClickListener;", "listener", "p", "themeType", "t", "autoCenter", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "a", "i", "l", h.F, "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "f", "k", "e", "d", "j", "b", "Landroid/content/Context;", "Landroid/content/Context;", "context", "I", "Z", "Ljava/lang/String;", "title", "desc", TuxUIConstants.POP_BTN_TEXT, "Landroid/view/View$OnClickListener;", "btnOnClickListener", "secondaryBtnText", "secondaryBtnOnClickListener", "btnStyle", "<init>", "(Landroid/content/Context;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Context context;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int imageType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int themeType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean halfScreenState;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View.OnClickListener btnOnClickListener;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View.OnClickListener secondaryBtnOnClickListener;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int bgColorType = 1;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String title = "";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String desc = "";

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String btnText = "";

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String secondaryBtnText = "";

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private int btnStyle = 1;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean autoCenter = true;

        public a(@Nullable Context context) {
            if (context == null) {
                if (!ud0.b.d()) {
                    this.context = ud0.b.a().getApplicationContext();
                    return;
                }
                throw new IllegalArgumentException("context is null!".toString());
            }
            this.context = context;
        }

        @NotNull
        public final GuildQUIEmptyState a() {
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            return new GuildQUIEmptyState(context, this);
        }

        /* renamed from: b, reason: from getter */
        public final boolean getAutoCenter() {
            return this.autoCenter;
        }

        /* renamed from: c, reason: from getter */
        public final int getBgColorType() {
            return this.bgColorType;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final View.OnClickListener getBtnOnClickListener() {
            return this.btnOnClickListener;
        }

        /* renamed from: e, reason: from getter */
        public final int getBtnStyle() {
            return this.btnStyle;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getBtnText() {
            return this.btnText;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getHalfScreenState() {
            return this.halfScreenState;
        }

        /* renamed from: i, reason: from getter */
        public final int getImageType() {
            return this.imageType;
        }

        @Nullable
        /* renamed from: j, reason: from getter */
        public final View.OnClickListener getSecondaryBtnOnClickListener() {
            return this.secondaryBtnOnClickListener;
        }

        @NotNull
        /* renamed from: k, reason: from getter */
        public final String getSecondaryBtnText() {
            return this.secondaryBtnText;
        }

        /* renamed from: l, reason: from getter */
        public final int getThemeType() {
            return this.themeType;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final a n(boolean autoCenter) {
            this.autoCenter = autoCenter;
            return this;
        }

        @NotNull
        public final a o(int bgColorType) {
            this.bgColorType = bgColorType;
            return this;
        }

        @NotNull
        public final a p(@NotNull String text, @Nullable View.OnClickListener listener) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.btnText = text;
            this.btnOnClickListener = listener;
            return this;
        }

        @NotNull
        public final a q(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.desc = text;
            return this;
        }

        @NotNull
        public final a r(boolean halfScreenState) {
            this.halfScreenState = halfScreenState;
            this.btnStyle = !halfScreenState ? 1 : 0;
            return this;
        }

        @NotNull
        public final a s(int imageType) {
            this.imageType = imageType;
            return this;
        }

        @NotNull
        public final a t(int themeType) {
            this.themeType = themeType;
            return this;
        }

        @NotNull
        public final a u(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.title = text;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/component/GuildQUIEmptyState$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            boolean z16;
            if (!GuildQUIEmptyState.this.mBuilder.getHalfScreenState() && GuildQUIEmptyState.this.mBuilder.getAutoCenter()) {
                z16 = GuildQUIEmptyState.this.c();
            } else {
                z16 = false;
            }
            GuildQUIEmptyState.this.getViewTreeObserver().removeOnPreDrawListener(this);
            return !z16;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildQUIEmptyState(@NotNull Context context, @NotNull a builder) {
        super(context);
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        View inflate = LayoutInflater.from(context).inflate(R.layout.emi, (ViewGroup) this, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.container = linearLayout;
        addView(linearLayout, new ViewGroup.MarginLayoutParams(-2, -2));
        setOrientation(1);
        setGravity(17);
        View findViewById = findViewById(R.id.uuj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.empty_state_image)");
        this.imageView = (ImageView) findViewById;
        if (builder.getHalfScreenState()) {
            i3 = R.id.uup;
        } else {
            i3 = R.id.uuo;
        }
        View findViewById2 = findViewById(i3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(\n          \u2026pty_state_title\n        )");
        this.titleTextView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.uui);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.empty_state_desc)");
        this.descTextView = (TextView) findViewById3;
        if (builder.getBtnStyle() == 0) {
            i16 = R.id.uum;
        } else {
            i16 = R.id.uuk;
        }
        View findViewById4 = findViewById(i16);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(\n          \u2026tate_medium_btn\n        )");
        this.button = (QUIButton) findViewById4;
        if (builder.getBtnStyle() == 0) {
            i17 = R.id.uun;
        } else {
            i17 = R.id.uul;
        }
        View findViewById5 = findViewById(i17);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(\n          \u2026m_secondary_btn\n        )");
        this.secondaryButton = (QUIButton) findViewById5;
        this.mBuilder = builder;
        m(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c() {
        int g16;
        int i3;
        int i16;
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int height = this.container.getHeight();
        if (getContext().getResources().getConfiguration().orientation == 2) {
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
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = i16;
        this.container.setLayoutParams(marginLayoutParams);
        return true;
    }

    private final Drawable e(int themeType, int resId) {
        boolean z16;
        Drawable drawable = ContextCompat.getDrawable(getContext(), resId);
        if (themeType != 2 && !f.f433786a.c()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (drawable != null) {
                drawable.setAlpha(230);
            }
        } else if (drawable != null) {
            drawable.setAlpha(255);
        }
        return drawable;
    }

    private final int f(int imageType) {
        switch (imageType) {
            case 1:
                return R.drawable.guild_dissolved;
            case 2:
                return R.drawable.guild_feed_abnormal;
            case 3:
                return R.drawable.guild_general_blank;
            case 4:
                return R.drawable.guild_no_comments;
            case 5:
                return R.drawable.guild_no_permission;
            case 6:
                return R.drawable.guild_no_search_result;
            case 7:
                return R.drawable.guild_subchannel_abnormal;
            case 8:
                return R.drawable.guild_no_feed;
            case 9:
                return R.drawable.guild_member_no_search_result;
            default:
                return 0;
        }
    }

    private final void g(int themeType, int bgColorType) {
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
                setBackgroundColor(ie0.a.f().g(getContext(), R.color.qui_common_bg_bottom_standard, i3));
                return;
            }
        }
        setBackgroundColor(ie0.a.f().g(getContext(), R.color.qui_common_bg_bottom_light, i3));
    }

    private final void h(String btnText, View.OnClickListener btnOnClickListener) {
        if (!TextUtils.isEmpty(btnText)) {
            this.button.setText(btnText);
            this.button.setOnClickListener(btnOnClickListener);
            this.button.setVisibility(0);
        }
    }

    private final void i(int themeType, String desc) {
        int i3;
        if (themeType == 2) {
            i3 = 1002;
        } else {
            i3 = 1000;
        }
        this.descTextView.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_secondary, i3));
        if (!TextUtils.isEmpty(desc)) {
            this.descTextView.setText(desc);
            this.descTextView.setVisibility(0);
        }
    }

    private final void j(int themeType, int imageType, boolean halfScreenState) {
        if (imageType != 0) {
            this.imageView.setImageDrawable(e(themeType, f(imageType)));
            this.imageView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (halfScreenState) {
                layoutParams2.height = e.d(getContext(), 120.0f);
                layoutParams2.width = e.d(getContext(), 120.0f);
            } else {
                layoutParams2.height = e.d(getContext(), 150.0f);
                layoutParams2.width = e.d(getContext(), 150.0f);
            }
            this.imageView.setLayoutParams(layoutParams2);
        }
    }

    private final void k(String btnText, View.OnClickListener btnOnClickListener) {
        if (!TextUtils.isEmpty(btnText)) {
            this.secondaryButton.setText(btnText);
            this.secondaryButton.setOnClickListener(btnOnClickListener);
            this.secondaryButton.setVisibility(0);
        }
    }

    private final void l(int themeType, String title) {
        int i3;
        if (themeType == 2) {
            i3 = 1002;
        } else {
            i3 = 1000;
        }
        this.titleTextView.setTextColor(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, i3));
        if (!TextUtils.isEmpty(title)) {
            this.titleTextView.setText(title);
            this.titleTextView.setVisibility(0);
        }
    }

    private final void m(a builder) {
        boolean z16;
        j(builder.getThemeType(), builder.getImageType(), builder.getHalfScreenState());
        g(builder.getThemeType(), builder.getBgColorType());
        l(builder.getThemeType(), builder.getTitle());
        i(builder.getThemeType(), builder.getDesc());
        h(builder.getBtnText(), builder.getBtnOnClickListener());
        k(builder.getSecondaryBtnText(), builder.getSecondaryBtnOnClickListener());
        boolean z17 = true;
        if (this.button.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.secondaryButton.getVisibility() != 0) {
                z17 = false;
            }
            if (z17) {
                ViewGroup.LayoutParams layoutParams = this.secondaryButton.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
            }
        }
    }

    public static /* synthetic */ void setTitleColor$default(GuildQUIEmptyState guildQUIEmptyState, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 1000;
        }
        guildQUIEmptyState.setTitleColor(i3, i16);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final QUIButton getButton() {
        return this.button;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.onPreDrawListener == null) {
            this.onPreDrawListener = new c();
        }
        getViewTreeObserver().addOnPreDrawListener(this.onPreDrawListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            getViewTreeObserver().removeOnPreDrawListener(this.onPreDrawListener);
        } catch (IllegalStateException e16) {
            QLog.e("GuildQUIEmptyState", 1, "onDetachedFromWindow:" + e16);
        }
        this.onPreDrawListener = null;
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        m(this.mBuilder);
    }

    public final void setDesc(@NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (!TextUtils.isEmpty(desc)) {
            this.descTextView.setText(desc);
            this.descTextView.setVisibility(0);
        }
    }

    public final void setImageView(int imageType) {
        this.imageView.setImageDrawable(e(this.mBuilder.getThemeType(), f(imageType)));
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!TextUtils.isEmpty(title)) {
            this.titleTextView.setText(title);
            this.titleTextView.setVisibility(0);
        }
    }

    public final void setTitleColor(int colorResId, int themeId) {
        this.titleTextView.setTextColor(ie0.a.f().g(getContext(), colorResId, themeId));
    }

    public final void setImageView(int themeType, int imageType, boolean halfScreenState) {
        j(themeType, imageType, halfScreenState);
    }
}
