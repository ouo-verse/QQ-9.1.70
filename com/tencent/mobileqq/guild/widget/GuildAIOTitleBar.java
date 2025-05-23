package com.tencent.mobileqq.guild.widget;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0096\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001\u00a2\u0006\u0006\b\u008c\u0001\u0010\u0090\u0001B(\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001\u0012\u0007\u0010\u0091\u0001\u001a\u000209\u00a2\u0006\u0006\b\u008c\u0001\u0010\u0092\u0001B1\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001\u0012\u0007\u0010\u0091\u0001\u001a\u000209\u0012\u0007\u0010\u0093\u0001\u001a\u000209\u00a2\u0006\u0006\b\u008c\u0001\u0010\u0094\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#J\u0014\u0010(\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190&J\u0010\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010/\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200J\u000e\u00103\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000200J\u000e\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206J\u0016\u0010<\u001a\u00020\u00062\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u000209J\u000e\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u000200J\u000e\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u000209J\u000e\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020AR\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010ER\"\u0010V\u001a\u00020G8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bQ\u0010I\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010MR\u0016\u0010Z\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010MR\u0016\u0010\\\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010IR\u0016\u0010^\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010ER\u0016\u0010`\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010MR\u0016\u0010b\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010IR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\"\u0010l\u001a\u00020K8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bg\u0010M\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010p\u001a\u00020G8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bm\u0010I\u001a\u0004\bn\u0010S\"\u0004\bo\u0010UR\u0016\u0010r\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010MR$\u0010z\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001d\u0010'\u001a\t\u0012\u0004\u0012\u00020\u00190\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001e\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u0089\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/theme/SkinnableView;", "Landroid/content/Context;", "context", "", "F0", "O0", "L0", "P0", "M0", "N0", "I0", "J0", "K0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "onThemeChanged", "Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "titleBarTheme", "setTheme", "Lcom/tencent/mobileqq/guild/widget/IconType;", "leftIcon", "setLeftIconType", "", NodeProps.VISIBLE, "setChannelLabelVisibility", "needTitleMarquee", "setNeedTitleMarquee", "G0", "H0", "Landroid/graphics/drawable/Drawable;", "guildAvatarDrawable", "setGuildAvatarDrawable", "", "rightIconTypes", "setRightIcons", "iconType", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "E0", "setGuildNavigateVisibility", "setRightIconContainerVisibility", "setJoinButtonVisibility", "setRightButtonVisibility", "", "text", "setRightTextButtonText", "setNotDisturbVisibility", "titleName", "setChannelName", "Landroid/graphics/Typeface;", "typeFace", "setChannelNameTypeFace", "", "memberCount", "threshold", "setMemberCount", "guildName", "setGuildName", "unreadCount", "setUnreadCount", "Lcom/tencent/mobileqq/guild/widget/GuildStateType;", "guildStateType", "setGuildStateType", "d", "Landroid/view/View;", "leftContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "leftButton", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "leftUnreadCount", tl.h.F, "showGuildDialogContainer", "i", "C0", "()Landroid/widget/ImageView;", "setGuildAvatar", "(Landroid/widget/ImageView;)V", "guildAvatar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "channelNameView", BdhLogUtil.LogTag.Tag_Conn, "memberCountView", "D", "disturbIcon", "E", "guildNameContainer", UserInfo.SEX_FEMALE, "guildNameView", "G", "guildStateIconView", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "rightIconContainer", "I", "D0", "()Landroid/widget/TextView;", "setJoinButton", "(Landroid/widget/TextView;)V", "joinButton", "J", "B0", "setChannelLabel", "channelLabel", "K", "rightTextButton", "Lcom/tencent/mobileqq/guild/widget/ah;", "L", "Lcom/tencent/mobileqq/guild/widget/ah;", "getTitleBarClickListener", "()Lcom/tencent/mobileqq/guild/widget/ah;", "setTitleBarClickListener", "(Lcom/tencent/mobileqq/guild/widget/ah;)V", "titleBarClickListener", "M", "Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "N", "Lcom/tencent/mobileqq/guild/widget/IconType;", "leftIconType", "P", "Lcom/tencent/mobileqq/guild/widget/GuildStateType;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "currentThemeId", "", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "T", "rightIconLayouts", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "U", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAIOTitleBar extends ConstraintLayout implements View.OnClickListener, SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView memberCountView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView disturbIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private View guildNameContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView guildNameView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView guildStateIconView;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout rightIconContainer;

    /* renamed from: I, reason: from kotlin metadata */
    public TextView joinButton;

    /* renamed from: J, reason: from kotlin metadata */
    public ImageView channelLabel;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView rightTextButton;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ah titleBarClickListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private TitleBarTheme titleBarTheme;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private IconType leftIconType;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private GuildStateType guildStateType;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean needTitleMarquee;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String currentThemeId;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final List<IconType> rightIconTypes;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final List<GuildRightIconLayout> rightIconLayouts;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View leftContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView leftButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView leftUnreadCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View showGuildDialogContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ImageView guildAvatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView channelNameView;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235814a;

        static {
            int[] iArr = new int[GuildStateType.values().length];
            try {
                iArr[GuildStateType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f235814a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildAIOTitleBar(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void F0(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ef8, this);
        View findViewById = findViewById(R.id.f166040yh2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.left_container)");
        this.leftContainer = findViewById;
        View findViewById2 = findViewById(R.id.e7d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.left_btn)");
        this.leftButton = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.kik);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.unread_count)");
        this.leftUnreadCount = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f85074nz);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.show_guild_dialog_container)");
        this.showGuildDialogContainer = findViewById4;
        View findViewById5 = findViewById(R.id.vzu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.guild_avatar)");
        setGuildAvatar((ImageView) findViewById5);
        View findViewById6 = findViewById(R.id.ato);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.channel_name)");
        this.channelNameView = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.eom);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.member_count)");
        this.memberCountView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.uj7);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.disturb_icon)");
        this.disturbIcon = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.wry);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.guild_name_container)");
        this.guildNameContainer = findViewById9;
        View findViewById10 = findViewById(R.id.wrw);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.guild_name)");
        this.guildNameView = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.f88084w4);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.state_icon)");
        this.guildStateIconView = (ImageView) findViewById11;
        View findViewById12 = findViewById(R.id.f166794ia3);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.right_icon_container)");
        this.rightIconContainer = (LinearLayout) findViewById12;
        View findViewById13 = findViewById(R.id.f165979ya4);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.join_button)");
        setJoinButton((TextView) findViewById13);
        View findViewById14 = findViewById(R.id.f164771ts4);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.channel_label)");
        setChannelLabel((ImageView) findViewById14);
        View findViewById15 = findViewById(R.id.f74853xd);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.right_text_button)");
        this.rightTextButton = (TextView) findViewById15;
        View view = null;
        if (Build.VERSION.SDK_INT >= 26) {
            View view2 = this.leftContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftContainer");
                view2 = null;
            }
            view2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
            D0().setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
            TextView textView = this.rightTextButton;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightTextButton");
                textView = null;
            }
            textView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, R.animator.f155134n));
        }
        View view3 = this.leftContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftContainer");
        } else {
            view = view3;
        }
        view.setTag(R.id.x2g, ClickType.BACK);
        view.setOnClickListener(this);
        setNeedTitleMarquee(this.needTitleMarquee);
        this.currentThemeId = QQTheme.getCurrentThemeId();
        O0();
    }

    private final void I0() {
        TextView textView = this.guildNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildNameView");
            textView = null;
        }
        TitleBarTheme titleBarTheme = this.titleBarTheme;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(titleBarTheme.getBottomTextColor(context));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        TitleBarTheme titleBarTheme2 = this.titleBarTheme;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        Drawable y16 = GuildUIUtils.y(context2, R.drawable.guild_navigate_title_logo_blue, titleBarTheme2.getBottomTextColor(context3));
        TextView textView2 = this.guildNameView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildNameView");
            textView2 = null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(y16, (Drawable) null, (Drawable) null, (Drawable) null);
        setGuildStateType(this.guildStateType);
    }

    private final void J0() {
        TextView textView = this.channelNameView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        TitleBarTheme titleBarTheme = this.titleBarTheme;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(titleBarTheme.getTopTextColor(context));
        TextView textView3 = this.memberCountView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberCountView");
            textView3 = null;
        }
        TitleBarTheme titleBarTheme2 = this.titleBarTheme;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView3.setTextColor(titleBarTheme2.getTopTextColor(context2));
        TextView textView4 = this.rightTextButton;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightTextButton");
        } else {
            textView2 = textView4;
        }
        TitleBarTheme titleBarTheme3 = this.titleBarTheme;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        textView2.setTextColor(titleBarTheme3.getTopTextColor(context3));
    }

    private final void K0() {
        this.titleBarTheme.setJoinButtonColor(D0());
    }

    private final void L0() {
        ImageView imageView = this.leftButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            imageView = null;
        }
        h.a(imageView, this.titleBarTheme, this.leftIconType);
    }

    private final void M0() {
        ImageView imageView = this.disturbIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disturbIcon");
            imageView = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TitleBarTheme titleBarTheme = this.titleBarTheme;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        imageView.setImageDrawable(GuildUIUtils.y(context, R.drawable.guild_no_disturb_normal, titleBarTheme.getDisturbColor(context2)));
    }

    private final void N0() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.rightIconTypes.size(), this.rightIconLayouts.size());
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            this.rightIconLayouts.get(i3).e(this.titleBarTheme);
        }
    }

    private final void O0() {
        this.titleBarTheme.setBackground(this);
        L0();
        P0();
        M0();
        N0();
        J0();
        K0();
        I0();
    }

    private final void P0() {
        TextView textView = this.leftUnreadCount;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUnreadCount");
            textView = null;
        }
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        TitleBarTheme titleBarTheme = this.titleBarTheme;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setBackground(guildUIUtils.h(titleBarTheme.getUnreadBackgroundColor(context), 8.0f));
        TextView textView3 = this.leftUnreadCount;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUnreadCount");
        } else {
            textView2 = textView3;
        }
        TitleBarTheme titleBarTheme2 = this.titleBarTheme;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView2.setTextColor(titleBarTheme2.getTopTextColor(context2));
    }

    @NotNull
    public final ImageView B0() {
        ImageView imageView = this.channelLabel;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channelLabel");
        return null;
    }

    @NotNull
    public final ImageView C0() {
        ImageView imageView = this.guildAvatar;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildAvatar");
        return null;
    }

    @NotNull
    public final TextView D0() {
        TextView textView = this.joinButton;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("joinButton");
        return null;
    }

    @Nullable
    public final GuildRightIconLayout E0(@NotNull IconType iconType) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        Iterator<T> it = this.rightIconLayouts.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((GuildRightIconLayout) obj).getIconType() == iconType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (GuildRightIconLayout) obj;
    }

    public final void G0() {
        TextView textView = this.channelNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        textView.setSelected(true);
    }

    public final void H0() {
        TextView textView = this.channelNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        textView.setSelected(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Logger.a d16 = Logger.f235387a.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onAttachedToWindow: ");
        TextView textView = this.channelNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        sb5.append((Object) textView.getText());
        sb5.append(" - ");
        sb5.append(QQTheme.getCurrentThemeId());
        sb5.append(" - ");
        sb5.append(this.titleBarTheme);
        sb5.append(" - hashcode=");
        sb5.append(hashCode());
        d16.d("Guild.comm.GuildTitleBar", 1, sb5.toString());
        super.onAttachedToWindow();
        if (!Intrinsics.areEqual(this.currentThemeId, QQTheme.getCurrentThemeId())) {
            this.currentThemeId = QQTheme.getCurrentThemeId();
            O0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        ah ahVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!GuildUIUtils.f235378a.C()) {
            Object tag = v3.getTag(R.id.x2g);
            Logger.f235387a.d().i("Guild.comm.GuildTitleBar", 1, "onClick: " + tag);
            if ((tag instanceof ClickType) && (ahVar = this.titleBarClickListener) != null) {
                ahVar.u2((ClickType) tag, v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Logger.a d16 = Logger.f235387a.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onDetachedFromWindow: ");
        TextView textView = this.channelNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        sb5.append((Object) textView.getText());
        sb5.append(" - ");
        sb5.append(QQTheme.getCurrentThemeId());
        sb5.append(" - ");
        sb5.append(this.titleBarTheme);
        sb5.append(" - hashcode=");
        sb5.append(hashCode());
        d16.d("Guild.comm.GuildTitleBar", 1, sb5.toString());
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        Logger.a d16 = Logger.f235387a.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onThemeChanged: ");
        TextView textView = this.channelNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        sb5.append((Object) textView.getText());
        sb5.append(" - ");
        sb5.append(QQTheme.getCurrentThemeId());
        sb5.append(" - ");
        sb5.append(this.titleBarTheme);
        sb5.append(" - hashcode=");
        sb5.append(hashCode());
        d16.d("Guild.comm.GuildTitleBar", 1, sb5.toString());
        this.currentThemeId = QQTheme.getCurrentThemeId();
        O0();
    }

    public final void setChannelLabel(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.channelLabel = imageView;
    }

    public final void setChannelLabelVisibility(boolean visible) {
        if (visible) {
            B0().setVisibility(0);
            B0().setTag(R.id.x2g, ClickType.LABEL);
            B0().setOnClickListener(this);
            return;
        }
        B0().setVisibility(8);
    }

    public final void setChannelName(@NotNull String titleName) {
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        TextView textView = this.channelNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        textView.setText(titleName);
    }

    public final void setChannelNameTypeFace(@NotNull Typeface typeFace) {
        Intrinsics.checkNotNullParameter(typeFace, "typeFace");
        TextView textView = this.channelNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView = null;
        }
        textView.setTypeface(typeFace);
    }

    public final void setGuildAvatar(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.guildAvatar = imageView;
    }

    public final void setGuildAvatarDrawable(@NotNull Drawable guildAvatarDrawable) {
        Intrinsics.checkNotNullParameter(guildAvatarDrawable, "guildAvatarDrawable");
        C0().setImageDrawable(guildAvatarDrawable);
    }

    public final void setGuildName(@NotNull String guildName) {
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        TextView textView = this.guildNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildNameView");
            textView = null;
        }
        textView.setText(guildName);
    }

    public final void setGuildNavigateVisibility(boolean visible) {
        TextView textView = null;
        if (visible) {
            View view = this.guildNameContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildNameContainer");
                view = null;
            }
            view.setVisibility(0);
            View view2 = this.showGuildDialogContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showGuildDialogContainer");
                view2 = null;
            }
            view2.setTag(R.id.x2g, ClickType.SHOW_GUILD_DIALOG);
            view2.setOnClickListener(this);
            TextView textView2 = this.channelNameView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
                textView2 = null;
            }
            textView2.setTextSize(0, bi.b(15));
            TextView textView3 = this.memberCountView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberCountView");
            } else {
                textView = textView3;
            }
            textView.setTextSize(0, bi.b(15));
            return;
        }
        View view3 = this.guildNameContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildNameContainer");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.showGuildDialogContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showGuildDialogContainer");
            view4 = null;
        }
        view4.setOnClickListener(null);
        TextView textView4 = this.channelNameView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            textView4 = null;
        }
        textView4.setTextSize(0, bi.b(18));
        TextView textView5 = this.memberCountView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberCountView");
        } else {
            textView = textView5;
        }
        textView.setTextSize(0, bi.b(18));
    }

    public final void setGuildStateType(@NotNull GuildStateType guildStateType) {
        Intrinsics.checkNotNullParameter(guildStateType, "guildStateType");
        this.guildStateType = guildStateType;
        ImageView imageView = null;
        if (b.f235814a[guildStateType.ordinal()] == 1) {
            ImageView imageView2 = this.guildStateIconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildStateIconView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.guildStateIconView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStateIconView");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.guildStateIconView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStateIconView");
        } else {
            imageView = imageView4;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int iconRes = guildStateType.getIconRes();
        TitleBarTheme titleBarTheme = this.titleBarTheme;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        imageView.setImageDrawable(GuildUIUtils.y(context, iconRes, titleBarTheme.getBottomTextColor(context2)));
    }

    public final void setJoinButton(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.joinButton = textView;
    }

    public final void setJoinButtonVisibility(boolean visible) {
        if (visible) {
            D0().setVisibility(0);
            D0().setTag(R.id.x2g, ClickType.JOIN);
            D0().setOnClickListener(this);
            return;
        }
        D0().setVisibility(8);
    }

    public final void setLeftIconType(@NotNull IconType leftIcon) {
        Set of5;
        int b16;
        Intrinsics.checkNotNullParameter(leftIcon, "leftIcon");
        IconType iconType = IconType.BACK;
        of5 = SetsKt__SetsKt.setOf((Object[]) new IconType[]{iconType, IconType.SCALE});
        if (!of5.contains(leftIcon)) {
            com.tencent.mobileqq.guild.util.s.f("Guild.comm.GuildTitleBar", "setLeftIconType invalid " + leftIcon, new IllegalStateException());
            return;
        }
        this.leftIconType = leftIcon;
        ImageView imageView = this.leftButton;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftButton");
            imageView = null;
        }
        h.a(imageView, this.titleBarTheme, this.leftIconType);
        View view = this.leftContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftContainer");
            view = null;
        }
        view.setTag(R.id.x2g, this.leftIconType.getClickType());
        if (this.leftIconType == iconType) {
            b16 = bi.b(26);
        } else {
            b16 = bi.b(32);
        }
        TextView textView2 = this.leftUnreadCount;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUnreadCount");
            textView2 = null;
        }
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(b16, 0, 0, 0);
        TextView textView3 = this.leftUnreadCount;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUnreadCount");
        } else {
            textView = textView3;
        }
        textView.setLayoutParams(marginLayoutParams);
    }

    public final void setMemberCount(int memberCount, int threshold) {
        String sb5;
        TextView textView = null;
        if (memberCount <= 0) {
            TextView textView2 = this.memberCountView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberCountView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.memberCountView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberCountView");
        } else {
            textView = textView3;
        }
        textView.setVisibility(0);
        if (memberCount > threshold) {
            sb5 = '(' + threshold + "+)";
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append('(');
            sb6.append(memberCount);
            sb6.append(')');
            sb5 = sb6.toString();
        }
        textView.setText(sb5);
    }

    public final void setNeedTitleMarquee(boolean needTitleMarquee) {
        this.needTitleMarquee = needTitleMarquee;
        TextView textView = null;
        if (needTitleMarquee) {
            TextView textView2 = this.channelNameView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
                textView2 = null;
            }
            textView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            TextView textView3 = this.channelNameView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
            } else {
                textView = textView3;
            }
            textView.setMarqueeRepeatLimit(-1);
            return;
        }
        TextView textView4 = this.channelNameView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNameView");
        } else {
            textView = textView4;
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void setNotDisturbVisibility(boolean visible) {
        ImageView imageView = this.disturbIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disturbIcon");
            imageView = null;
        }
        imageView.setVisibility(8);
    }

    public final void setRightButtonVisibility(boolean visible) {
        TextView textView = null;
        if (visible) {
            TextView textView2 = this.rightTextButton;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightTextButton");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.rightTextButton;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightTextButton");
                textView3 = null;
            }
            textView3.setTag(R.id.x2g, ClickType.RIGHT_TEXT_BUTTON);
            TextView textView4 = this.rightTextButton;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightTextButton");
            } else {
                textView = textView4;
            }
            textView.setOnClickListener(this);
            return;
        }
        TextView textView5 = this.rightTextButton;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightTextButton");
        } else {
            textView = textView5;
        }
        textView.setVisibility(8);
    }

    public final void setRightIconContainerVisibility(boolean visible) {
        LinearLayout linearLayout = null;
        if (visible) {
            LinearLayout linearLayout2 = this.rightIconContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightIconContainer");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout3 = this.rightIconContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightIconContainer");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(8);
    }

    public final void setRightIcons(@NotNull List<? extends IconType> rightIconTypes) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(rightIconTypes, "rightIconTypes");
        this.rightIconTypes.clear();
        this.rightIconTypes.addAll(rightIconTypes);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(rightIconTypes.size(), this.rightIconLayouts.size());
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            GuildRightIconLayout guildRightIconLayout = this.rightIconLayouts.get(i3);
            guildRightIconLayout.setIconRes(this.titleBarTheme, rightIconTypes.get(i3));
            guildRightIconLayout.setVisibility(0);
            guildRightIconLayout.setOnClickListener(this);
        }
        if (this.rightIconLayouts.size() < rightIconTypes.size()) {
            int size = rightIconTypes.size();
            for (int size2 = this.rightIconLayouts.size(); size2 < size; size2++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildRightIconLayout guildRightIconLayout2 = new GuildRightIconLayout(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(bi.b(29), bi.b(29));
                layoutParams.setMargins(0, 0, bi.b(14), 0);
                guildRightIconLayout2.setLayoutParams(layoutParams);
                guildRightIconLayout2.setIconRes(this.titleBarTheme, rightIconTypes.get(size2));
                guildRightIconLayout2.setOnClickListener(this);
                LinearLayout linearLayout = this.rightIconContainer;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightIconContainer");
                    linearLayout = null;
                }
                linearLayout.addView(guildRightIconLayout2);
                this.rightIconLayouts.add(guildRightIconLayout2);
            }
            return;
        }
        if (this.rightIconLayouts.size() > rightIconTypes.size()) {
            int size3 = this.rightIconLayouts.size();
            for (int size4 = rightIconTypes.size(); size4 < size3; size4++) {
                this.rightIconLayouts.get(size4).setVisibility(8);
            }
        }
    }

    public final void setRightTextButtonText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.rightTextButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightTextButton");
            textView = null;
        }
        textView.setText(text);
    }

    public final void setTheme(@NotNull TitleBarTheme titleBarTheme) {
        Intrinsics.checkNotNullParameter(titleBarTheme, "titleBarTheme");
        if (titleBarTheme == this.titleBarTheme) {
            return;
        }
        this.titleBarTheme = titleBarTheme;
        O0();
    }

    public final void setTitleBarClickListener(@Nullable ah ahVar) {
        this.titleBarClickListener = ahVar;
    }

    public final void setUnreadCount(int unreadCount) {
        String valueOf;
        TextView textView = null;
        if (unreadCount <= 0) {
            TextView textView2 = this.leftUnreadCount;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftUnreadCount");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.leftUnreadCount;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUnreadCount");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.leftUnreadCount;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftUnreadCount");
        } else {
            textView = textView4;
        }
        if (unreadCount > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(unreadCount);
        }
        textView.setText(valueOf);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildAIOTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildAIOTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAIOTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        TitleBarTheme titleBarTheme = TitleBarTheme.TITLE_BAR_STYLE_01;
        this.titleBarTheme = titleBarTheme;
        this.leftIconType = IconType.BACK;
        this.guildStateType = GuildStateType.NONE;
        this.rightIconTypes = new ArrayList();
        this.rightIconLayouts = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.api.j.f214593s1);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026yleable.GuildAIOTitleBar)");
        this.titleBarTheme = TitleBarTheme.values()[obtainStyledAttributes.getInteger(com.tencent.mobileqq.guild.api.j.f214607u1, titleBarTheme.ordinal())];
        this.needTitleMarquee = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.api.j.f214600t1, false);
        obtainStyledAttributes.recycle();
        F0(context);
    }
}
