package com.tencent.mobileqq.guild.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u00105\u001a\u00020\u000f\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u00020\u0002H\u0014R\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\rR\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildJoinWidgetTextView;", "Landroid/widget/FrameLayout;", "", "e", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "d", "f", "b", "", "value", "setNeedLeadJoinAnim", NodeProps.ON_DETACHED_FROM_WINDOW, "Z", "needLeadJoinAnim", "", "I", "leadJoinViewTextColor", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "leadJoinViewBg", "", tl.h.F, "Ljava/lang/String;", "leadJoinViewText", "", "i", UserInfo.SEX_FEMALE, "scanDuration", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "joinView", BdhLogUtil.LogTag.Tag_Conn, "leadJoinAnimView", "Landroid/animation/AnimatorSet;", "D", "Landroid/animation/AnimatorSet;", "animSet", "E", "isLeadJoinAnimShowed", "", "Lkotlin/Lazy;", "getScanColorArray", "()[I", "scanColorArray", "Landroid/os/Handler;", "G", "c", "()Landroid/os/Handler;", "uiHandler", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildJoinWidgetTextView extends FrameLayout {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<String> I;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TextView leadJoinAnimView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet animSet;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isLeadJoinAnimShowed;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy scanColorArray;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needLeadJoinAnim;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int leadJoinViewTextColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable leadJoinViewBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String leadJoinViewText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float scanDuration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView joinView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildJoinWidgetTextView$a;", "", "", "kotlin.jvm.PlatformType", "DEFAULT_LEAD_JOIN_TEXT$delegate", "Lkotlin/Lazy;", "b", "()Ljava/lang/String;", "DEFAULT_LEAD_JOIN_TEXT", "", "ALPHA_DURATION", "J", "ATTR_ALPHA", "Ljava/lang/String;", "ATTR_SCALE_X", "ATTR_SCALE_Y", "", "DEFAULT_SCAN_DURATION", UserInfo.SEX_FEMALE, "FOCUS_HOLD_DURATION", "LEAD_JOIN_RUNNABLE_DELAY", "SCALE_DURATION", "SCALE_END", "SCALE_MID", "SCALE_START", "SCAN_DELAY", "TAG", "", "ratio", "I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.GuildJoinWidgetTextView$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b() {
            return (String) GuildJoinWidgetTextView.I.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.widget.GuildJoinWidgetTextView$Companion$DEFAULT_LEAD_JOIN_TEXT$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return HardCodeUtil.qqStr(R.string.f155561hu);
            }
        });
        I = lazy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildJoinWidgetTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Handler c() {
        return (Handler) this.uiHandler.getValue();
    }

    private final void d(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, up1.a.f439433b4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026.GuildJoinWidgetTextView)");
        this.needLeadJoinAnim = obtainStyledAttributes.getBoolean(up1.a.f439489f4, false);
        this.leadJoinViewTextColor = obtainStyledAttributes.getColor(up1.a.f439475e4, -1);
        this.leadJoinViewBg = obtainStyledAttributes.getDrawable(up1.a.f439447c4);
        this.scanDuration = obtainStyledAttributes.getFloat(up1.a.f439503g4, 500.0f);
        String DEFAULT_LEAD_JOIN_TEXT = obtainStyledAttributes.getString(up1.a.f439461d4);
        if (DEFAULT_LEAD_JOIN_TEXT == null) {
            DEFAULT_LEAD_JOIN_TEXT = INSTANCE.b();
            Intrinsics.checkNotNullExpressionValue(DEFAULT_LEAD_JOIN_TEXT, "DEFAULT_LEAD_JOIN_TEXT");
        }
        this.leadJoinViewText = DEFAULT_LEAD_JOIN_TEXT;
        obtainStyledAttributes.recycle();
    }

    private final void e() {
        this.isLeadJoinAnimShowed = false;
        b();
        AnimatorSet animatorSet = this.animSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    private final void f() {
        if (this.leadJoinAnimView.getParent() != null) {
            return;
        }
        addView(this.leadJoinAnimView);
    }

    public final void b() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildJoinWidgetView", 2, "[clearLeadJoinRunnable] " + hashCode());
        }
        c().removeCallbacksAndMessages(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public final void setNeedLeadJoinAnim(boolean value) {
        this.needLeadJoinAnim = value;
        if (value) {
            f();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildJoinWidgetTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildJoinWidgetTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildJoinWidgetTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        String DEFAULT_LEAD_JOIN_TEXT = INSTANCE.b();
        Intrinsics.checkNotNullExpressionValue(DEFAULT_LEAD_JOIN_TEXT, "DEFAULT_LEAD_JOIN_TEXT");
        this.leadJoinViewText = DEFAULT_LEAD_JOIN_TEXT;
        this.scanDuration = 500.0f;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<int[]>() { // from class: com.tencent.mobileqq.guild.widget.GuildJoinWidgetTextView$scanColorArray$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final int[] invoke() {
                return new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#73FFFFFF"), Color.parseColor("#00FFFFFF")};
            }
        });
        this.scanColorArray = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.guild.widget.GuildJoinWidgetTextView$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.uiHandler = lazy2;
        d(attributeSet);
        TextView textView = new TextView(context, attributeSet);
        textView.setId(-1);
        this.joinView = textView;
        addView(textView);
        TextView textView2 = new TextView(context, attributeSet);
        textView2.setTextColor(this.leadJoinViewTextColor);
        textView2.setBackground(this.leadJoinViewBg);
        textView2.setText(this.leadJoinViewText);
        textView2.setGravity(17);
        textView2.setVisibility(8);
        textView2.setId(-1);
        this.leadJoinAnimView = textView2;
        if (this.needLeadJoinAnim) {
            f();
        }
        setBackground(null);
        setPadding(0, 0, 0, 0);
    }
}
