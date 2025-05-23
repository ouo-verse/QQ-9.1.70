package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FasterTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.text.util.TextExtContentViewUtil;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.toggle.IVasToggleExtApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOConfig;
import com.tencent.qqnt.aio.widget.AIOMsgFasterTextView;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.aio.widget.SelectableFasterTextView;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.aio.widget.SelectableTextView;
import com.tencent.qqnt.aio.widget.TextExtLinearLayout;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RichStatus;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010J\u001a\u00020 \u00a2\u0006\u0004\ba\u0010bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u001a\u0010\u0017\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010 0\u001f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010#\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\"\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\u001a\u0010(\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0015J\u001e\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020 2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0006J\u0016\u0010.\u001a\u00020\u00042\u0006\u0010+\u001a\u00020 2\u0006\u0010\r\u001a\u00020\fJ\b\u00100\u001a\u00020/H\u0014J\u0010\u00103\u001a\u0002022\u0006\u00101\u001a\u00020/H\u0014J\u0010\u00104\u001a\u0002022\u0006\u00101\u001a\u00020/H\u0014J\u000e\u00105\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0010\u00106\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J!\u00109\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u000eH\u0014\u00a2\u0006\u0004\b9\u0010:J\u000e\u0010;\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\fJ2\u0010>\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\u001a\u0010?\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\r\u001a\u00020\fH\u0014J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@J\b\u0010C\u001a\u0004\u0018\u00010 R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0017\u0010O\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\"\u00101\u001a\u00020/8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010YR\u0016\u0010[\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010(R\u0018\u0010]\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010^R\u0016\u0010)\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010`\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/TextMsgContent;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "w", "", NodeProps.MAX_WIDTH, BdhLogUtil.LogTag.Tag_Conn, "k", "Landroid/widget/RelativeLayout;", tl.h.F, "Lcom/tencent/mobileqq/aio/msg/ae;", "msgItem", "", "textSize", "", "showText", "fontDrawable", "I", "qqTextSize", "", "K", "E", "o", "Landroid/content/res/ColorStateList;", NodeProps.COLORS, HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "skinBubbleInfo", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Pair;", "Landroid/view/View;", DomainData.DOMAIN_NAME, "isLoading", "t", "e", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "linkInfo", UserInfo.SEX_FEMALE, "isWideScreen", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "view", NodeProps.MIN_WIDTH, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/fastertextview/wrapper/a;", "i", "txtView", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "f", "g", "B", "H", "unit", "size", "y", "(Ljava/lang/Integer;F)V", "J", "backgroundMinWidth", "backgroundMinHeight", "v", "r", "Lcom/tencent/qqnt/aio/widget/i;", "listener", "u", "l", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Landroid/view/View;", "foregroundView", "c", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "j", "()Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "content", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "totalView", "Lcom/tencent/fastertextview/wrapper/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/fastertextview/wrapper/a;", "setTxtView", "(Lcom/tencent/fastertextview/wrapper/a;)V", "Landroid/widget/RelativeLayout;", "extTextView", "boundQQTextSize", "Ljava/lang/CharSequence;", "boundQQText", "Landroid/graphics/drawable/Drawable;", "boundFontDrawable", "Z", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class TextMsgContent {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f190077l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f190078m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Lazy<Integer> f190079n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final Lazy<Float> f190080o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View foregroundView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SelectableLinearLayout content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout totalView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.fastertextview.wrapper.a txtView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout extTextView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float boundQQTextSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence boundQQText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable boundFontDrawable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isWideScreen;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/TextMsgContent$a;", "", "", "TOGGLE_BUG_112323531", "Z", "c", "()Z", "setTOGGLE_BUG_112323531", "(Z)V", "", "MIN_HEIGHT_WITH_TOKEN$delegate", "Lkotlin/Lazy;", "b", "()I", "MIN_HEIGHT_WITH_TOKEN", "", "ALL_EMO_LINE_SPACE_EXTRA$delegate", "a", "()F", "ALL_EMO_LINE_SPACE_EXTRA", "ACCESSIBILITY_ACTION_TAP", "I", "MARGIN_WIDE_SCREEN", UserInfo.SEX_FEMALE, "RICH_TEXT_HORIZONTAL_PADDING", "RICH_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.TextMsgContent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
            }
            return ((Number) TextMsgContent.f190080o.getValue()).floatValue();
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return ((Number) TextMsgContent.f190079n.getValue()).intValue();
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return TextMsgContent.f190077l;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/aio/msg/TextMsgContent$b", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "b", "a", "", "Landroid/text/style/ClickableSpan;", "c", "()[Landroid/text/style/ClickableSpan;", "", "action", "Landroid/os/Bundle;", "args", "", "performAccessibilityAction", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextMsgContent.this);
            }
        }

        public final void a(@NotNull AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            ClickableSpan[] c16 = c();
            View g16 = TextMsgContent.this.m().g();
            Intrinsics.checkNotNull(g16);
            CharSequence text = ((TextView) g16).getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
            Spannable spannable = (Spannable) text;
            int length = c16.length;
            for (int i3 = 0; i3 < length; i3++) {
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(33554432 + i3 + 1, TextMsgContent.this.context.getResources().getString(R.string.f230496za, spannable.subSequence(spannable.getSpanStart(c16[i3]), spannable.getSpanEnd(c16[i3])).toString())));
            }
        }

        public final void b(@NotNull AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            if (TextMsgContent.this.m().g() instanceof SelectableTextView) {
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(33554432, TextMsgContent.this.context.getResources().getString(R.string.f230486z_)));
            }
        }

        @NotNull
        public final ClickableSpan[] c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ClickableSpan[]) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            View g16 = TextMsgContent.this.m().g();
            Intrinsics.checkNotNull(g16);
            CharSequence text = ((TextView) g16).getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
            Spannable spannable = (Spannable) text;
            Object[] spans = spannable.getSpans(0, spannable.length(), ClickableSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(\n         \u2026ss.java\n                )");
            return (ClickableSpan[]) spans;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@Nullable View host, @Nullable AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) host, (Object) info);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (Build.VERSION.SDK_INT >= 24 && info != null) {
                info.setImportantForAccessibility(true);
                b(info);
                a(info);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(@Nullable View host, int action, @Nullable Bundle args) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, this, host, Integer.valueOf(action), args)).booleanValue();
            }
            if (action == 33554432) {
                View g16 = TextMsgContent.this.m().g();
                Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableTextView");
                ((SelectableTextView) g16).z();
                return true;
            }
            if (action > 33554432) {
                int i3 = (action - 33554432) - 1;
                ClickableSpan[] c16 = c();
                if (i3 >= 0 && i3 < c16.length) {
                    ClickableSpan clickableSpan = c16[i3];
                    Intrinsics.checkNotNull(host);
                    clickableSpan.onClick(host);
                    return true;
                }
            }
            return super.performAccessibilityAction(host, action, args);
        }
    }

    static {
        Lazy<Integer> lazy;
        Lazy<Float> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        INSTANCE = new Companion(null);
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        f190077l = ((IAIOConfig) companion.a(IAIOConfig.class)).isFeatureSwitchOn("bug_112323531");
        f190078m = IVasToggleExtApi.a.a((IVasToggleExtApi) companion.a(IVasToggleExtApi.class), "shouyouye", "2025-01-11", "bug_137759157", false, 8, null);
        lazy = LazyKt__LazyJVMKt.lazy(TextMsgContent$Companion$MIN_HEIGHT_WITH_TOKEN$2.INSTANCE);
        f190079n = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TextMsgContent$Companion$ALL_EMO_LINE_SPACE_EXTRA$2.INSTANCE);
        f190080o = lazy2;
    }

    public TextMsgContent(@NotNull Context context, @NotNull View foregroundView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(foregroundView, "foregroundView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) foregroundView);
            return;
        }
        this.context = context;
        this.foregroundView = foregroundView;
        com.tencent.fastertextview.wrapper.a i3 = i();
        this.txtView = i3;
        this.content = f(i3);
    }

    private final void C(int maxWidth) {
        AIOMsgTextView aIOMsgTextView;
        View g16 = this.txtView.g();
        if (g16 instanceof AIOMsgTextView) {
            aIOMsgTextView = (AIOMsgTextView) g16;
        } else {
            aIOMsgTextView = null;
        }
        if (aIOMsgTextView == null || aIOMsgTextView.getMaxWidth() == maxWidth) {
            return;
        }
        aIOMsgTextView.setMaxWidth(maxWidth);
    }

    static /* synthetic */ void D(TextMsgContent textMsgContent, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                i3 = textMsgContent.k();
            }
            textMsgContent.C(i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMaxWidth");
    }

    private final boolean E(ae msgItem, CharSequence showText) {
        if (showText != null && this.boundQQText != showText) {
            this.boundQQText = showText;
            if (AIOBubbleSkinInfo.BackgroundImageInfo.INSTANCE.e()) {
                TextView textView = null;
                if (showText.length() == 1) {
                    View g16 = this.txtView.g();
                    if (g16 instanceof TextView) {
                        textView = (TextView) g16;
                    }
                    if (textView != null) {
                        textView.setGravity(1);
                    }
                } else {
                    View g17 = this.txtView.g();
                    if (g17 instanceof TextView) {
                        textView = (TextView) g17;
                    }
                    if (textView != null) {
                        textView.setGravity(8388611);
                    }
                }
            }
            this.txtView.m(showText, TextView.BufferType.SPANNABLE);
            if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
                this.content.setContentDescription(com.tencent.mobileqq.aio.msglist.holder.component.text.c.f191997a.b(msgItem.p2()));
                o();
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ void G(TextMsgContent textMsgContent, ae aeVar, LinkInfo linkInfo, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                linkInfo = null;
            }
            textMsgContent.F(aeVar, linkInfo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateRichMsg");
    }

    private final void I(ae msgItem, float textSize, CharSequence showText, Drawable fontDrawable) {
        K(textSize);
        E(msgItem, showText);
        B(msgItem);
        J(msgItem);
    }

    private final boolean K(float qqTextSize) {
        boolean z16;
        boolean z17;
        if (qqTextSize == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            y(0, ae.INSTANCE.a());
            return true;
        }
        if (this.boundQQTextSize == qqTextSize) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return false;
        }
        this.boundQQTextSize = qqTextSize;
        y(0, qqTextSize);
        return true;
    }

    private final RelativeLayout h() {
        return TextExtContentViewUtil.f192002a.e(this.context);
    }

    private final int k() {
        if (this.isWideScreen) {
            return com.tencent.mobileqq.aio.utils.e.f194142a.d() - ViewUtils.dpToPx(6.0f);
        }
        return a.C7329a.f192417a.f(true);
    }

    private final Pair<View, View> n(ae msgItem) {
        View g16;
        View view;
        if (com.tencent.mobileqq.aio.utils.d.T(msgItem.getMsgRecord())) {
            g16 = this.totalView;
            view = this.txtView.g();
        } else {
            g16 = this.txtView.g();
            view = this.totalView;
        }
        return TuplesKt.to(g16, view);
    }

    private final void o() {
        this.content.setAccessibilityDelegate(new b());
    }

    private final void s(AIOBubbleSkinInfo skinBubbleInfo, ae msgItem) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.j jVar;
        int b16;
        int a16;
        AIOMsgTextView aIOMsgTextView = null;
        if (skinBubbleInfo != null) {
            aVar = skinBubbleInfo.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) {
            jVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) aVar;
        } else {
            jVar = null;
        }
        if (jVar == null) {
            return;
        }
        if (msgItem.isSelf()) {
            b16 = a.c.f192425a.a();
        } else {
            b16 = a.c.f192425a.b();
        }
        if (msgItem.isSelf()) {
            a16 = a.c.f192425a.b();
        } else {
            a16 = a.c.f192425a.a();
        }
        int c16 = a.c.f192425a.c();
        LinearLayout linearLayout = this.totalView;
        if (linearLayout != null && (linearLayout.getPaddingLeft() != b16 || linearLayout.getPaddingRight() != a16 || linearLayout.getPaddingTop() != jVar.e() || linearLayout.getPaddingBottom() != c16)) {
            linearLayout.setPadding(b16, jVar.e(), a16, c16);
        }
        int dpToPx = ViewUtils.dpToPx(12.0f);
        View g16 = this.txtView.g();
        if (g16 != null) {
            g16.setPadding(dpToPx, 0, dpToPx, 0);
        }
        if (!(this.txtView.g() instanceof LinearLayout)) {
            int f16 = a.C7329a.f192417a.f(true) - (jVar.c() + jVar.d());
            View g17 = this.txtView.g();
            if (g17 instanceof AIOMsgTextView) {
                aIOMsgTextView = (AIOMsgTextView) g17;
            }
            if (aIOMsgTextView != null) {
                aIOMsgTextView.setMaxWidth(f16);
            }
        }
    }

    private final void t(AIOBubbleSkinInfo skinBubbleInfo, boolean isLoading) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.j jVar;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = null;
        if (skinBubbleInfo != null) {
            aVar = skinBubbleInfo.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) {
            jVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) aVar;
        } else {
            jVar = null;
        }
        if (jVar != null) {
            if (isLoading) {
                RelativeLayout relativeLayout = this.extTextView;
                if (relativeLayout != null) {
                    layoutParams2 = relativeLayout.getLayoutParams();
                }
                if (layoutParams2 != null) {
                    layoutParams2.width = -2;
                    return;
                }
                return;
            }
            boolean z16 = true;
            int min = Math.min(com.tencent.qqnt.base.utils.c.f353052a.a(263.0f), (a.C7329a.f192417a.f(true) - jVar.c()) - jVar.d());
            RelativeLayout relativeLayout2 = this.extTextView;
            if (relativeLayout2 == null || (layoutParams = relativeLayout2.getLayoutParams()) == null || layoutParams.width != min) {
                z16 = false;
            }
            if (!z16) {
                RelativeLayout relativeLayout3 = this.extTextView;
                if (relativeLayout3 != null) {
                    layoutParams2 = relativeLayout3.getLayoutParams();
                }
                if (layoutParams2 != null) {
                    layoutParams2.width = min;
                }
            }
        }
    }

    private final void w(Drawable drawable) {
        this.foregroundView.setBackground(drawable);
    }

    private final void x(ColorStateList colors) {
        if (this.txtView.g() instanceof TextView) {
            View g16 = this.txtView.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) g16).setLinkTextColor(colors);
        } else if (this.txtView.g() instanceof FasterTextView) {
            View g17 = this.txtView.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type android.widget.FasterTextView");
            ((FasterTextView) g17).setLinkTextColor(colors);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        if (r0 == true) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(@NotNull View view, @NotNull ae msgItem, int minWidth) {
        LinearLayout linearLayout;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, msgItem, Integer.valueOf(minWidth));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        LinearLayout linearLayout2 = this.totalView;
        if (linearLayout2 != null) {
            if (linearLayout2.indexOfChild(view) != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = false;
        if (!z17 && (linearLayout = this.totalView) != null) {
            linearLayout.addView(view);
        }
        AIOBubbleSkinInfo x06 = msgItem.x0();
        if (x06 == null) {
            return;
        }
        AIOBubbleSkinInfo.BackgroundImageInfo a16 = x06.a();
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.j jVar = null;
        if (a16 != null) {
            LinearLayout linearLayout3 = this.totalView;
            if (linearLayout3 != null) {
                linearLayout3.setBackground(a16.a());
            }
            LinearLayout linearLayout4 = this.totalView;
            if (linearLayout4 != null) {
                linearLayout4.setMinimumWidth(Math.max(a16.g(), minWidth));
            }
            LinearLayout linearLayout5 = this.totalView;
            if (linearLayout5 != null) {
                linearLayout5.setMinimumHeight(a16.f());
            }
            View g16 = this.txtView.g();
            if (g16 != null) {
                g16.setBackground(null);
            }
            View g17 = this.txtView.g();
            if (g17 != null) {
                g17.setMinimumWidth(0);
            }
            View g18 = this.txtView.g();
            if (g18 != null) {
                g18.setMinimumHeight(0);
            }
        }
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = x06.b();
        if (b16 instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) {
            jVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) b16;
        }
        if (jVar != null) {
            int b17 = jVar.b() - a.c.f192425a.e();
            LinearLayout linearLayout6 = this.totalView;
            if (linearLayout6 != null) {
                linearLayout6.setPadding(jVar.c(), jVar.e(), jVar.d(), b17);
            }
            this.txtView.l(0, 0, 0, 0);
            C((k() - jVar.c()) - jVar.d());
        }
    }

    public final void B(@NotNull ae msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.q2() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("TextMsgContent", 4, "[updateLineSpaceForEmo] msgId=" + msgItem.getMsgId() + " fontDrawable Exist, skip");
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            long msgId = msgItem.getMsgId();
            CharSequence o16 = AIOUtil.f194084a.o(msgItem.u2());
            QLog.i("TextMsgContent", 4, "[updateLineSpaceForEmo] msgId=" + msgId + " textSize=" + msgItem + ".textSize text=" + ((Object) o16) + " isAllEmo=" + msgItem.z2());
        }
        if (msgItem.z2()) {
            View g16 = this.txtView.g();
            if (g16 != null) {
                if (g16 instanceof TextView) {
                    ((TextView) g16).setLineSpacing(INSTANCE.a(), 1.0f);
                    return;
                } else {
                    if (g16 instanceof FasterTextView) {
                        ((FasterTextView) g16).setLineSpacing(INSTANCE.a(), 1.0f);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        View g17 = this.txtView.g();
        if (g17 != null) {
            if (g17 instanceof TextView) {
                ((TextView) g17).setLineSpacing(0.0f, 1.0f);
            } else if (g17 instanceof FasterTextView) {
                ((FasterTextView) g17).setLineSpacing(0.0f, 1.0f);
            }
        }
    }

    public final void F(@NotNull ae msgItem, @Nullable LinkInfo linkInfo) {
        String str;
        Integer num;
        RichStatus richStatus;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.j jVar;
        int i3;
        RichStatus richStatus2;
        AIOBubbleSkinInfo.c e16;
        TextElement textElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgItem, (Object) linkInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!com.tencent.mobileqq.aio.utils.d.T(msgItem.getMsgRecord())) {
            RelativeLayout relativeLayout = this.extTextView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        if (this.extTextView == null) {
            RelativeLayout h16 = h();
            this.extTextView = h16;
            LinearLayout linearLayout = this.totalView;
            if (linearLayout != null) {
                linearLayout.addView(h16);
            }
        }
        if (linkInfo == null) {
            linkInfo = com.tencent.mobileqq.aio.utils.d.d(msgItem.getMsgRecord());
        }
        boolean z16 = true;
        MsgElement i16 = MsgExtKt.i(msgItem.getMsgRecord(), 1);
        RichStatus richStatus3 = null;
        if (i16 != null && (textElement = i16.textElement) != null) {
            str = textElement.content;
        } else {
            str = null;
        }
        RelativeLayout relativeLayout2 = this.extTextView;
        if (relativeLayout2 != null) {
            AIOBubbleSkinInfo x06 = msgItem.x0();
            if (x06 != null && (e16 = x06.e()) != null) {
                num = e16.a();
            } else {
                num = null;
            }
            if (TextExtContentViewUtil.f192002a.k(this.context, relativeLayout2, linkInfo, msgItem.isSelf(), str, num, msgItem.p0())) {
                s(msgItem.x0(), msgItem);
            } else {
                if (linkInfo != null) {
                    richStatus = linkInfo.richStatus;
                } else {
                    richStatus = null;
                }
                if (richStatus != RichStatus.KRICHSTART) {
                    if (linkInfo != null) {
                        richStatus2 = linkInfo.richStatus;
                    } else {
                        richStatus2 = null;
                    }
                    if (richStatus2 != RichStatus.KRICHPROGRESS) {
                        r(msgItem.x0(), msgItem);
                    }
                }
                com.tencent.fastertextview.wrapper.a aVar2 = this.txtView;
                aVar2.l(aVar2.d(), aVar2.f(), aVar2.e(), 0);
                LinearLayout linearLayout2 = this.totalView;
                if (linearLayout2 != null) {
                    AIOBubbleSkinInfo x07 = msgItem.x0();
                    if (x07 != null) {
                        aVar = x07.b();
                    } else {
                        aVar = null;
                    }
                    if (aVar instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) {
                        jVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) aVar;
                    } else {
                        jVar = null;
                    }
                    if (jVar != null) {
                        i3 = jVar.b();
                    } else {
                        i3 = 0;
                    }
                    linearLayout2.setPadding(0, 0, 0, i3);
                }
            }
        }
        AIOBubbleSkinInfo x08 = msgItem.x0();
        if (linkInfo != null) {
            richStatus3 = linkInfo.richStatus;
        }
        if (richStatus3 == RichStatus.KRICHCOMPLETE) {
            z16 = false;
        }
        t(x08, z16);
    }

    public void H(@NotNull ae msgItem) {
        Drawable drawable;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        w(null);
        AIOBubbleSkinInfo x06 = msgItem.x0();
        if (x06 == null) {
            QLog.i("TextMsgContent", 1, "[updateSkinBubbleInfo] bubble info is null, msgId=" + msgItem.getMsgId());
            return;
        }
        AIOBubbleSkinInfo.BackgroundImageInfo a16 = x06.a();
        if (a16 != null) {
            Drawable a17 = a16.a();
            if (a17 != null) {
                v(msgItem, a17, a16.g(), a16.f(), x06);
            }
            r(x06, msgItem);
        }
        AIOBubbleSkinInfo.b c16 = x06.c();
        if (c16 != null) {
            drawable = c16.a();
        } else {
            drawable = null;
        }
        w(drawable);
        AIOBubbleSkinInfo.c e16 = x06.e();
        if (e16 != null) {
            Integer a18 = e16.a();
            if (a18 != null) {
                this.txtView.n(a18.intValue());
            }
            ColorStateList b16 = e16.b();
            if (b16 != null) {
                this.txtView.o(b16);
            }
            Integer c17 = e16.c();
            if (c17 != null) {
                this.txtView.i(c17.intValue());
            }
            ColorStateList d16 = e16.d();
            if (d16 != null) {
                x(d16);
                if (msgItem.A2()) {
                    String str = "[" + this.context.getString(R.string.t_) + "]";
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d16.getDefaultColor());
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(msgItem.w2());
                    spannableStringBuilder.setSpan(foregroundColorSpan, 0, str.length(), 33);
                    if (AIOBubbleSkinInfo.BackgroundImageInfo.INSTANCE.e()) {
                        View g16 = this.txtView.g();
                        if (g16 instanceof TextView) {
                            textView = (TextView) g16;
                        } else {
                            textView = null;
                        }
                        if (textView != null) {
                            textView.setGravity(8388611);
                        }
                    }
                    this.txtView.m(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                }
            }
            Float e17 = e16.e();
            if (e17 != null) {
                y(e16.f(), e17.floatValue());
            }
        }
        G(this, msgItem, null, 2, null);
    }

    public final boolean J(@NotNull ae msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Object q26 = msgItem.q2();
        if (this.boundFontDrawable == msgItem.q2()) {
            return false;
        }
        this.boundFontDrawable = msgItem.q2();
        y03.c cVar = null;
        if (this.txtView.g() instanceof AIOMsgTextView) {
            View g16 = this.txtView.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.AIOMsgTextView");
            AIOMsgTextView aIOMsgTextView = (AIOMsgTextView) g16;
            if (q26 instanceof y03.c) {
                cVar = (y03.c) q26;
            }
            aIOMsgTextView.setTextDrawable(cVar, msgItem.u2());
            return true;
        }
        if (this.txtView.g() instanceof AIOMsgFasterTextView) {
            View g17 = this.txtView.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.AIOMsgFasterTextView");
            AIOMsgFasterTextView aIOMsgFasterTextView = (AIOMsgFasterTextView) g17;
            if (q26 instanceof y03.c) {
                cVar = (y03.c) q26;
            }
            aIOMsgFasterTextView.setTextDrawable(cVar);
            return true;
        }
        return true;
    }

    public void e(@NotNull ae msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (QLog.isDevelopLevel()) {
            QLog.i("TextMsgContent", 4, "[onBind] msgId=" + msgItem.getMsgId() + " textSize=" + msgItem + ".textSize text=" + ((Object) AIOUtil.f194084a.o(msgItem.u2())) + " fontDrawable=" + msgItem + ".fontDrawable");
        }
        this.foregroundView.setBackground(null);
        G(this, msgItem, null, 2, null);
        D(this, 0, 1, null);
        H(msgItem);
        if (msgItem.o2()) {
            I(msgItem, msgItem.v2(), msgItem.x2(), msgItem.q2());
        } else {
            I(msgItem, msgItem.v2(), msgItem.w2(), msgItem.q2());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public SelectableLinearLayout f(@NotNull com.tencent.fastertextview.wrapper.a txtView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SelectableLinearLayout) iPatchRedirector.redirect((short) 12, (Object) this, (Object) txtView);
        }
        Intrinsics.checkNotNullParameter(txtView, "txtView");
        if (p()) {
            return g(txtView);
        }
        SelectableLinearLayout selectableLinearLayout = new SelectableLinearLayout(this.context);
        selectableLinearLayout.setOrientation(1);
        selectableLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        selectableLinearLayout.addView(txtView.g());
        if (txtView.g() instanceof SelectableTextView) {
            View g16 = txtView.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableTextView");
            ((SelectableTextView) g16).o(selectableLinearLayout);
        } else if (txtView.g() instanceof SelectableFasterTextView) {
            View g17 = txtView.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableFasterTextView");
            ((SelectableFasterTextView) g17).o(selectableLinearLayout);
        }
        return selectableLinearLayout;
    }

    @NotNull
    protected SelectableLinearLayout g(@NotNull com.tencent.fastertextview.wrapper.a txtView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SelectableLinearLayout) iPatchRedirector.redirect((short) 13, (Object) this, (Object) txtView);
        }
        Intrinsics.checkNotNullParameter(txtView, "txtView");
        TextExtLinearLayout textExtLinearLayout = new TextExtLinearLayout(this.context);
        textExtLinearLayout.setOrientation(1);
        textExtLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textExtLinearLayout.addView(txtView.g());
        this.totalView = textExtLinearLayout;
        SelectableLinearLayout selectableLinearLayout = new SelectableLinearLayout(this.context);
        selectableLinearLayout.setOrientation(1);
        selectableLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        selectableLinearLayout.addView(this.totalView);
        if (txtView.g() instanceof SelectableTextView) {
            View g16 = txtView.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableTextView");
            ((SelectableTextView) g16).o(selectableLinearLayout);
        } else if (txtView.g() instanceof SelectableFasterTextView) {
            View g17 = txtView.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableFasterTextView");
            ((SelectableFasterTextView) g17).o(selectableLinearLayout);
        }
        return selectableLinearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public com.tencent.fastertextview.wrapper.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.fastertextview.wrapper.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        com.tencent.mobileqq.aio.msglist.holder.component.text.util.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a;
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        return aVar.a(context, a.C7329a.f192417a.f(true), null);
    }

    @NotNull
    public final SelectableLinearLayout j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SelectableLinearLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.content;
    }

    @Nullable
    public final View l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (View) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.txtView.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.fastertextview.wrapper.a m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.fastertextview.wrapper.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.txtView;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(@NotNull View view, @NotNull ae msgItem) {
        boolean z16;
        AIOBubbleSkinInfo.BackgroundImageInfo a16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        LinearLayout linearLayout = this.totalView;
        if (linearLayout != null) {
            if (linearLayout.indexOfChild(view) != -1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (!z16) {
                    LinearLayout linearLayout2 = this.totalView;
                    if (linearLayout2 != null) {
                        linearLayout2.removeView(view);
                    }
                    AIOBubbleSkinInfo x06 = msgItem.x0();
                    if (x06 != null && (a16 = x06.a()) != null) {
                        Drawable a17 = a16.a();
                        if (a17 != null) {
                            v(msgItem, a17, a16.g(), a16.f(), x06);
                        }
                        r(x06, msgItem);
                    }
                    D(this, 0, 1, null);
                    G(this, msgItem, null, 2, null);
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    protected void r(@Nullable AIOBubbleSkinInfo skinBubbleInfo, @NotNull ae msgItem) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) skinBubbleInfo, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.j jVar = null;
        if (skinBubbleInfo != null) {
            aVar = skinBubbleInfo.b();
        } else {
            aVar = null;
        }
        if (aVar instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) {
            jVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.j) aVar;
        }
        if (jVar != null && (this.txtView.d() != jVar.c() || this.txtView.e() != jVar.d() || this.txtView.f() != jVar.e() || this.txtView.c() != jVar.b())) {
            this.txtView.l(jVar.c(), jVar.e(), jVar.d(), jVar.b());
        }
        LinearLayout linearLayout = this.totalView;
        if (linearLayout != null) {
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }

    public final void u(@NotNull com.tencent.qqnt.aio.widget.i listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.txtView.g() instanceof SelectableTextView) {
            View g16 = this.txtView.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableTextView");
            ((SelectableTextView) g16).setOnDoubleClickListener(listener);
        } else if (this.txtView.g() instanceof SelectableFasterTextView) {
            View g17 = this.txtView.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableFasterTextView");
            ((SelectableFasterTextView) g17).setOnDoubleClickListener(listener);
        }
    }

    protected void v(@NotNull ae msgItem, @NotNull Drawable drawable, int backgroundMinWidth, int backgroundMinHeight, @Nullable AIOBubbleSkinInfo skinBubbleInfo) {
        boolean z16;
        int minimumWidth;
        int minimumHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, msgItem, drawable, Integer.valueOf(backgroundMinWidth), Integer.valueOf(backgroundMinHeight), skinBubbleInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Pair<View, View> n3 = n(msgItem);
        View component1 = n3.component1();
        View component2 = n3.component2();
        if (component1 != null) {
            Integer valueOf = Integer.valueOf(backgroundMinWidth);
            if (valueOf.intValue() != component1.getMinimumWidth()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!Boolean.valueOf(z16).booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                minimumWidth = valueOf.intValue();
            } else {
                minimumWidth = component1.getMinimumWidth();
            }
            component1.setMinimumWidth(minimumWidth);
            Integer valueOf2 = Integer.valueOf(backgroundMinHeight);
            if (valueOf2.intValue() == component1.getMinimumHeight()) {
                z17 = false;
            }
            if (!Boolean.valueOf(z17).booleanValue()) {
                valueOf2 = null;
            }
            if (valueOf2 != null) {
                minimumHeight = valueOf2.intValue();
            } else {
                minimumHeight = component1.getMinimumHeight();
            }
            component1.setMinimumHeight(minimumHeight);
            component1.setBackground(drawable);
        }
        if (component2 != null) {
            component2.setMinimumWidth(0);
            component2.setMinimumHeight(0);
            component2.setBackground(null);
        }
    }

    protected void y(@Nullable Integer unit, float size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, unit, Float.valueOf(size));
        } else if (unit != null) {
            unit.intValue();
            this.txtView.p(unit.intValue(), size);
        }
    }

    public final void z(boolean isWideScreen) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isWideScreen);
        } else {
            this.isWideScreen = isWideScreen;
        }
    }
}
