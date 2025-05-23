package com.tencent.mobileqq.guild.home.views.ban;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.safety.ExitGuildUtilKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0002_`B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020\u0003\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\nH\u0002J(\u0010$\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0002J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0007J*\u0010.\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u00142\b\b\u0002\u0010-\u001a\u00020\u0003J\u0016\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u00052\u0006\u0010\r\u001a\u000202J\b\u00104\u001a\u00020\u0005H\u0016R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010D\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010FR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010FR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010MR\u0014\u0010O\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00107R\u0016\u0010Q\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010PR\u0016\u0010S\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010UR\u0018\u0010X\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010W\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/theme/SkinnableView;", "", "drawableRes", "", "t", "J", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/safety/a;", "banInfo", "w", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "cacheBanInfo", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "G", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", ReportConstant.COSTREPORT_PREFIX, "E", UserInfo.SEX_FEMALE, "I", "p", "", "clickStr", "showText", "h5Url", "", "textSize", "Landroid/text/SpannableString;", "k", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout$b;", "callback", "setGuildMainViewContext", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "isShowTitle", "banType", DomainData.DOMAIN_NAME, "mainSource", "subSource", "setSource", "Landroid/view/View$OnClickListener;", "setOnGoHomeBtnClickListener", "onThemeChanged", "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mGuildBanTitle", "f", "mGuildBanContentTitle", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", "mGuildBanTitleLayout", "i", "mGuildBanContent", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mGuildBanMainBtn", "mGuildBanSubBtn", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "mGuildBanIcon", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "mCoverBack", "Ljava/lang/String;", "mMainSource", "H", "mSubSource", "Lvp1/bv;", "Lvp1/bv;", "errorViewBinding", "Landroid/view/View$OnClickListener;", "mOnGoGuildHomeClickListener", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeBanLayout extends RelativeLayout implements SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QUIButton mGuildBanSubBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ImageView mGuildBanIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo mGuildInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View mCoverBack;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mMainSource;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mSubSource;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final bv errorViewBinding;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener mOnGoGuildHomeClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mGuildBanTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mGuildBanContentTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mGuildBanTitleLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mGuildBanContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIButton mGuildBanMainBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout$b;", "", "", "onFinish", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void onFinish();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/home/views/ban/GuildHomeBanLayout$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f225536e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f225537f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f225538h;

        c(String str, int i3, float f16) {
            this.f225536e = str;
            this.f225537f = i3;
            this.f225538h = f16;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            cx.a(GuildHomeBanLayout.this.getContext(), URLUtil.guessUrl(this.f225536e));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(this.f225537f);
            ds5.setUnderlineText(false);
            ds5.setTextSize(this.f225538h);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeBanLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(final Context context) {
        this.mGuildBanMainBtn.setVisibility(0);
        this.mGuildBanMainBtn.setText("\u53d1\u73b0\u66f4\u591a\u9891\u9053");
        this.mGuildBanMainBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.ban.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeBanLayout.B(GuildHomeBanLayout.this, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GuildHomeBanLayout this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.m(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C(final Context context) {
        this.mGuildBanSubBtn.setVisibility(0);
        this.mGuildBanSubBtn.setText(getResources().getString(R.string.f156041j5));
        this.mGuildBanSubBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.ban.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeBanLayout.D(GuildHomeBanLayout.this, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GuildHomeBanLayout this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.l(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E(com.tencent.mobileqq.guild.safety.a cacheBanInfo) {
        if (p(cacheBanInfo)) {
            F();
        } else {
            I(cacheBanInfo);
        }
    }

    private final void F() {
        String protocolText = HardCodeUtil.qqStr(R.string.f140580ec);
        TextView textView = this.mGuildBanContent;
        Intrinsics.checkNotNullExpressionValue(protocolText, "protocolText");
        textView.setText(k(protocolText, "\u8be5\u9891\u9053\u6d89\u53ca\u76f8\u5173\u8fdd\u89c4\u6761\u4f8b\uff0c\u5df2\u88ab\u5c01\u7981\u3002\n\u8be6\u60c5\u53ef\u89c1" + protocolText, "https://rule.tencent.com/rule/202310100001", getResources().getDimension(R.dimen.cde)));
        this.mGuildBanContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void G(final Context context) {
        this.mGuildBanMainBtn.setVisibility(0);
        this.mGuildBanMainBtn.setText(getResources().getString(R.string.f140570eb));
        this.mGuildBanMainBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.ban.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeBanLayout.H(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        SecurityTipHelperKt.m(context, "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fsubmit%2Fstep2%2Fstep2&_vt=3&via=tencent_csd&_sig=1454231204&_nq=billid%3D211023selfqa61f08c16");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I(com.tencent.mobileqq.guild.safety.a cacheBanInfo) {
        TextView textView = this.mGuildBanContent;
        String qqStr = HardCodeUtil.qqStr(R.string.f140580ec);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_ban_protocol)");
        String qqStr2 = HardCodeUtil.qqStr(R.string.f142810kd);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_con\u2026_temp_ban_protocol_owner)");
        String format = String.format(qqStr2, Arrays.copyOf(new Object[]{new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.CHINA).format(new Date(cacheBanInfo.b()))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        textView.setText(k(qqStr, format, "https://rule.tencent.com/rule/202310100001", getResources().getDimension(R.dimen.cde)));
        this.mGuildBanContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void J() {
        t(R.drawable.guild_dissolved);
    }

    private final SpannableString k(String clickStr, String showText, String h5Url, float textSize) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) showText, clickStr, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(showText);
        spannableString.setSpan(new c(h5Url, getResources().getColor(R.color.qui_common_text_link), textSize), indexOf$default, clickStr.length() + indexOf$default, 33);
        return spannableString;
    }

    private final void l(final Context context) {
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo == null) {
            return;
        }
        ExitGuildUtilKt.m(iGProGuildInfo, context, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout$handleExit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context context2 = context;
                Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                if (activity != null) {
                    activity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Context context) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        GuildJumpUtil.w(activity, "mqqguild://guild/jumpToRecommendPage?mainSourceId=" + this.mMainSource + "&subSourceId=" + this.mSubSource + "&categoryConfId=0");
    }

    public static /* synthetic */ void o(GuildHomeBanLayout guildHomeBanLayout, Context context, IGProGuildInfo iGProGuildInfo, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        guildHomeBanLayout.n(context, iGProGuildInfo, z16, i3);
    }

    private final boolean p(com.tencent.mobileqq.guild.safety.a cacheBanInfo) {
        if (cacheBanInfo.b() == 0) {
            return true;
        }
        return false;
    }

    private final boolean q() {
        boolean z16;
        boolean z17;
        boolean z18;
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo != null && 3 == iGProGuildInfo.getMemberCode()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        IGProGuildInfo iGProGuildInfo2 = this.mGuildInfo;
        if (iGProGuildInfo2 != null && 2 == iGProGuildInfo2.getMemberCode()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        IGProGuildInfo iGProGuildInfo3 = this.mGuildInfo;
        if (iGProGuildInfo3 != null && 1 == iGProGuildInfo3.getMemberCode()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return true;
        }
        return false;
    }

    private final boolean r() {
        if (q()) {
            IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
            if (iGProGuildInfo != null && 3 == iGProGuildInfo.getMemberCode()) {
                return true;
            }
            return false;
        }
        IGProGuildInfo iGProGuildInfo2 = this.mGuildInfo;
        if (iGProGuildInfo2 != null && 2 == iGProGuildInfo2.getUserType()) {
            return true;
        }
        return false;
    }

    private final void s(com.tencent.mobileqq.guild.safety.a cacheBanInfo) {
        boolean z16;
        boolean z17;
        if (cacheBanInfo == null) {
            this.mGuildBanContent.setText("\u8be5\u9891\u9053\u6d89\u53ca\u76f8\u5173\u8fdd\u89c4\u6761\u4f8b\uff0c\u5df2\u88ab\u5c01\u7981\u3002");
            return;
        }
        if (q()) {
            IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
            if (iGProGuildInfo != null && 3 == iGProGuildInfo.getMemberCode()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                E(cacheBanInfo);
                return;
            }
        }
        IGProGuildInfo iGProGuildInfo2 = this.mGuildInfo;
        if (iGProGuildInfo2 != null && 2 == iGProGuildInfo2.getUserType()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            E(cacheBanInfo);
            return;
        }
        if (p(cacheBanInfo)) {
            this.mGuildBanContent.setText("\u8be5\u9891\u9053\u6d89\u53ca\u76f8\u5173\u8fdd\u89c4\u6761\u4f8b\uff0c\u5df2\u88ab\u5c01\u7981\u3002");
            return;
        }
        TextView textView = this.mGuildBanContent;
        String string = getResources().getString(R.string.f142800kc);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026_content_temp_ban_member)");
        String format = String.format(string, Arrays.copyOf(new Object[]{new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.CHINA).format(new Date(cacheBanInfo.b()))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        textView.setText(format);
    }

    private final void t(int drawableRes) {
        this.mGuildBanIcon.setImageResource(drawableRes);
        if (QQTheme.isNowThemeIsNight()) {
            this.mGuildBanIcon.setImageAlpha(242);
        } else {
            this.mGuildBanIcon.setImageAlpha(255);
        }
    }

    private final void u(final Context context, com.tencent.mobileqq.guild.safety.a cacheBanInfo) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (cacheBanInfo != null) {
            if (q()) {
                IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
                if (iGProGuildInfo != null && 3 == iGProGuildInfo.getMemberCode()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    G(context);
                    return;
                }
            }
            IGProGuildInfo iGProGuildInfo2 = this.mGuildInfo;
            if (iGProGuildInfo2 != null && iGProGuildInfo2.isMember()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                IGProGuildInfo iGProGuildInfo3 = this.mGuildInfo;
                if (iGProGuildInfo3 != null && 2 == iGProGuildInfo3.getUserType()) {
                    z18 = true;
                }
                if (z18) {
                    G(context);
                    return;
                } else if (!p(cacheBanInfo)) {
                    A(context);
                    return;
                } else {
                    this.mGuildBanMainBtn.setVisibility(8);
                    return;
                }
            }
        }
        this.mGuildBanMainBtn.setVisibility(0);
        this.mGuildBanMainBtn.setText("\u53d1\u73b0\u66f4\u591a\u9891\u9053");
        this.mGuildBanMainBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.ban.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeBanLayout.v(GuildHomeBanLayout.this, context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GuildHomeBanLayout this$0, Context context, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!o.c("fastClickGuard")) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            GuildJumpUtil.w(activity, "mqqguild://guild/jumpToRecommendPage?mainSourceId=" + this$0.mMainSource + "&subSourceId=" + this$0.mSubSource + "&categoryConfId=0");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(final Context context, com.tencent.mobileqq.guild.safety.a banInfo) {
        boolean z16;
        boolean z17 = false;
        if (banInfo != null && r() && p(banInfo)) {
            this.mGuildBanSubBtn.setVisibility(0);
            this.mGuildBanSubBtn.setText(getResources().getString(R.string.f156031j4));
            this.mGuildBanSubBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.ban.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildHomeBanLayout.x(GuildHomeBanLayout.this, context, view);
                }
            });
            QUIButton qUIButton = this.mGuildBanMainBtn;
            ViewGroup.LayoutParams layoutParams = qUIButton.getLayoutParams();
            layoutParams.width = ViewUtils.dpToPx(144.0f);
            qUIButton.setLayoutParams(layoutParams);
            return;
        }
        if (banInfo != null) {
            IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
            if (iGProGuildInfo != null && iGProGuildInfo.isMember()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                IGProGuildInfo iGProGuildInfo2 = this.mGuildInfo;
                if (iGProGuildInfo2 != null && 2 == iGProGuildInfo2.getUserType()) {
                    z17 = true;
                }
                if (!z17) {
                    if (p(banInfo)) {
                        C(context);
                        return;
                    }
                    this.mGuildBanSubBtn.setVisibility(8);
                    QUIButton qUIButton2 = this.mGuildBanMainBtn;
                    ViewGroup.LayoutParams layoutParams2 = qUIButton2.getLayoutParams();
                    layoutParams2.width = ViewUtils.dpToPx(168.0f);
                    qUIButton2.setLayoutParams(layoutParams2);
                    return;
                }
            }
        }
        this.mGuildBanSubBtn.setVisibility(8);
        QUIButton qUIButton3 = this.mGuildBanMainBtn;
        ViewGroup.LayoutParams layoutParams3 = qUIButton3.getLayoutParams();
        layoutParams3.width = ViewUtils.dpToPx(168.0f);
        qUIButton3.setLayoutParams(layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GuildHomeBanLayout this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.l(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y(com.tencent.mobileqq.guild.safety.a cacheBanInfo) {
        if (cacheBanInfo != null) {
            if (p(cacheBanInfo)) {
                this.mGuildBanContentTitle.setText("\u9891\u9053\u88ab\u5c01\u7981");
                return;
            } else {
                this.mGuildBanContentTitle.setText(getResources().getString(R.string.f140610ef));
                return;
            }
        }
        this.mGuildBanContentTitle.setText("\u9891\u9053\u88ab\u5c01\u7981");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(b callback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onFinish();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void n(@NotNull final Context context, @Nullable IGProGuildInfo guildInfo, boolean isShowTitle, int banType) {
        Integer num;
        Boolean bool;
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGuildInfo = guildInfo;
        Logger.a d16 = Logger.f235387a.d();
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        Integer num2 = null;
        if (iGProGuildInfo != null) {
            num = Integer.valueOf(iGProGuildInfo.getMemberCode());
        } else {
            num = null;
        }
        IGProGuildInfo iGProGuildInfo2 = this.mGuildInfo;
        if (iGProGuildInfo2 != null) {
            bool = Boolean.valueOf(iGProGuildInfo2.isMember());
        } else {
            bool = null;
        }
        IGProGuildInfo iGProGuildInfo3 = this.mGuildInfo;
        if (iGProGuildInfo3 != null) {
            num2 = Integer.valueOf(iGProGuildInfo3.getUserType());
        }
        d16.d("Guild.NewHome.GuildHomeBanLayout", 1, "[setBanSubBtn] memberCode:" + num + ", isMember:" + bool + ", userType:" + num2 + " ban type:" + banType);
        ViewGroup viewGroup = this.mGuildBanTitleLayout;
        if (isShowTitle) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        if (banType != 1) {
            if (banType != 2) {
                if (banType != 3) {
                    if (banType != 4) {
                        TextView textView = this.mGuildBanTitle;
                        if (guildInfo == null || (str = guildInfo.getGuildName()) == null) {
                            str = "\u817e\u8baf\u9891\u9053";
                        }
                        textView.setText(str);
                        this.mGuildBanContent.setHighlightColor(0);
                        J();
                        com.tencent.mobileqq.guild.safety.a a16 = com.tencent.mobileqq.guild.safety.a.a(guildInfo);
                        y(a16);
                        s(a16);
                        u(context, a16);
                        w(context, a16);
                        return;
                    }
                    g.a(this.errorViewBinding, R.drawable.guild_dissolved, "\u9891\u9053\u5df2\u89e3\u6563", "", "\u53d1\u73b0\u66f4\u591a\u9891\u9053", "", new Function1<BtnType, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout$init$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(BtnType btnType) {
                            invoke2(btnType);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull BtnType it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            GuildHomeBanLayout.this.m(context);
                        }
                    });
                    return;
                }
                g.a(this.errorViewBinding, R.drawable.guild_subchannel_abnormal, "\u9891\u9053\u5e94\u7528\u4e0d\u5b58\u5728", "", "\u53bb\u9891\u9053", "", new Function1<BtnType, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout$init$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BtnType btnType) {
                        invoke2(btnType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull BtnType it) {
                        View.OnClickListener onClickListener;
                        bv bvVar;
                        Intrinsics.checkNotNullParameter(it, "it");
                        onClickListener = GuildHomeBanLayout.this.mOnGoGuildHomeClickListener;
                        if (onClickListener != null) {
                            bvVar = GuildHomeBanLayout.this.errorViewBinding;
                            onClickListener.onClick(bvVar.f442600c);
                        }
                    }
                });
                return;
            }
            g.a(this.errorViewBinding, R.drawable.guild_no_permission, "\u65e0\u7248\u5757\u6743\u9650", "", "\u53bb\u9891\u9053", "", new Function1<BtnType, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout$init$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BtnType btnType) {
                    invoke2(btnType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull BtnType it) {
                    View.OnClickListener onClickListener;
                    bv bvVar;
                    Intrinsics.checkNotNullParameter(it, "it");
                    onClickListener = GuildHomeBanLayout.this.mOnGoGuildHomeClickListener;
                    if (onClickListener != null) {
                        bvVar = GuildHomeBanLayout.this.errorViewBinding;
                        onClickListener.onClick(bvVar.f442600c);
                    }
                }
            });
            return;
        }
        g.a(this.errorViewBinding, R.drawable.guild_dissolved, "\u6682\u65f6\u65e0\u6cd5\u52a0\u5165", "", "\u53d1\u73b0\u66f4\u591a\u9891\u9053", "", new Function1<BtnType, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout$init$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BtnType btnType) {
                invoke2(btnType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull BtnType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildHomeBanLayout.this.m(context);
            }
        });
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        if (QQTheme.isNowThemeIsNight()) {
            this.mGuildBanIcon.setImageAlpha(242);
        } else {
            this.mGuildBanIcon.setImageAlpha(255);
        }
    }

    @Deprecated(message = "\u8001\u9875\u9762\u4f7f\u7528")
    public final void setGuildMainViewContext(@NotNull GuildFacadeType guildFacadeType, @NotNull final b callback) {
        Intrinsics.checkNotNullParameter(guildFacadeType, "guildFacadeType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCoverBack.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.views.ban.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeBanLayout.z(GuildHomeBanLayout.b.this, view);
            }
        });
        if (ImmersiveUtils.isSupportImmersive()) {
            this.mRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
    }

    public final void setOnGoHomeBtnClickListener(@NotNull View.OnClickListener l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mOnGoGuildHomeClickListener = l3;
    }

    public final void setSource(@NotNull String mainSource, @NotNull String subSource) {
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        this.mMainSource = mainSource;
        this.mSubSource = subSource;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeBanLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeBanLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeBanLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.exj, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ain_frame_ban_view, this)");
        this.mRootView = inflate;
        this.mMainSource = "";
        this.mSubSource = "";
        bv e16 = bv.e(inflate.findViewById(R.id.wp9));
        Intrinsics.checkNotNullExpressionValue(e16, "bind(mRootView.findViewB\u2026d_main_frame_error_view))");
        this.errorViewBinding = e16;
        ImageView imageView = e16.f442603f;
        Intrinsics.checkNotNullExpressionValue(imageView, "errorViewBinding.warnIcon");
        this.mGuildBanIcon = imageView;
        View findViewById = inflate.findViewById(R.id.f165583ws3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.guild_name_tv)");
        this.mGuildBanTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.title)");
        this.mGuildBanTitleLayout = (ViewGroup) findViewById2;
        TextView textView = e16.f442602e;
        Intrinsics.checkNotNullExpressionValue(textView, "errorViewBinding.guildBanContentTitle");
        this.mGuildBanContentTitle = textView;
        TextView textView2 = e16.f442599b;
        Intrinsics.checkNotNullExpressionValue(textView2, "errorViewBinding.banContentTv");
        this.mGuildBanContent = textView2;
        QUIButton qUIButton = e16.f442600c;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "errorViewBinding.guildBanContentMainBtn");
        this.mGuildBanMainBtn = qUIButton;
        QUIButton qUIButton2 = e16.f442601d;
        Intrinsics.checkNotNullExpressionValue(qUIButton2, "errorViewBinding.guildBanContentSubBtn");
        this.mGuildBanSubBtn = qUIButton2;
        View findViewById3 = inflate.findViewById(R.id.u_q);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.cover_back)");
        this.mCoverBack = findViewById3;
    }
}
