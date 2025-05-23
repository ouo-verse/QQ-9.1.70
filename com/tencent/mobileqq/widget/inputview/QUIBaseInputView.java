package com.tencent.mobileqq.widget.inputview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.l;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.util.InputMethodUtil;
import h53.QUIInputCountCalculateStrategy;
import h53.j;
import ie0.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B.\b\u0007\u0012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001\u0012\f\b\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001\u0012\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0005\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0014J\b\u0010\u001f\u001a\u00020\u0003H\u0004J\u0012\u0010!\u001a\u00020\u00052\b\b\u0001\u0010 \u001a\u00020\u0005H\u0004J\u001c\u0010$\u001a\u00020#2\b\b\u0001\u0010\"\u001a\u00020\u00052\b\b\u0001\u0010 \u001a\u00020\u0005H\u0004J\u001a\u0010&\u001a\u00020#2\b\b\u0001\u0010 \u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0004R\"\u0010.\u001a\u00020'8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010=\u001a\u0002078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b$\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u0002078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R*\u0010I\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010L\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010D\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR.\u0010S\u001a\u0004\u0018\u00010\u001a2\b\u0010B\u001a\u0004\u0018\u00010\u001a8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR*\u0010Z\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR*\u0010^\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010U\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR*\u0010b\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010D\u001a\u0004\b`\u0010F\"\u0004\ba\u0010HR*\u0010f\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010D\u001a\u0004\bd\u0010F\"\u0004\be\u0010HR$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bC\u0010j\"\u0004\bk\u0010lR(\u0010r\u001a\u0004\u0018\u00010m2\b\u0010B\u001a\u0004\u0018\u00010m8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR(\u0010w\u001a\u0004\u0018\u00010s2\b\u0010B\u001a\u0004\u0018\u00010s8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010t\"\u0004\bu\u0010vR$\u0010y\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010F\"\u0004\bx\u0010HR\u0011\u0010z\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b0\u0010FR(\u0010}\u001a\u0004\u0018\u00010\u001a2\b\u0010B\u001a\u0004\u0018\u00010\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b{\u0010P\"\u0004\b|\u0010RR%\u0010\u0080\u0001\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b~\u0010F\"\u0004\b\u007f\u0010HR9\u0010\u0087\u0001\u001a\n\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u00012\u000e\u0010B\u001a\n\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u00018F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0014\u0010\u008a\u0001\u001a\u00030\u0088\u00018F\u00a2\u0006\u0007\u001a\u0005\b>\u0010\u0089\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/mobileqq/widget/inputview/QUIBaseInputView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/widget/listitem/l;", "", "t", "", "index", "setTextSelection", "", NodeProps.FOCUSABLE, "setTextFocusable", "focusableInTouchMode", "setTextFocusableInTouchMode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", "Lh53/e;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "setCalculateStrategy", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "type", "setBackgroundType", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "", "errorTips", "y", ReportConstant.COSTREPORT_PREFIX, "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tokenResId", "c", "drawableResId", "Landroid/graphics/drawable/Drawable;", "f", "radius", "b", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "d", "Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "g", "()Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;", "u", "(Lcom/tencent/mobileqq/widget/inputview/CharacterCountEditText;)V", "editText", "Landroid/view/View;", "e", "Landroid/view/View;", "j", "()Landroid/view/View;", "v", "(Landroid/view/View;)V", "inputContent", "Landroid/widget/TextView;", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", HippyTKDListViewAdapter.X, "(Landroid/widget/TextView;)V", "promptTextView", h.F, "k", "w", "maxCountTextView", "value", "i", "I", "o", "()I", "setThemeId", "(I)V", "themeId", "getStyle", "setStyle", "style", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getPromptText", "()Ljava/lang/String;", "setPromptText", "(Ljava/lang/String;)V", QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, "D", "Z", DomainData.DOMAIN_NAME, "()Z", "setShowWordCount", "(Z)V", "showWordCount", "E", "getShowPromptText", "setShowPromptText", "showPromptText", UserInfo.SEX_FEMALE, "getColorMode", "setColorMode", "colorMode", "G", "getPaddingHorizontal", "setPaddingHorizontal", NodeProps.PADDING_HORIZONTAL, "Lh53/j;", "editorActionListener", "Lh53/j;", "()Lh53/j;", "setEditorActionListener", "(Lh53/j;)V", "Lh53/l;", "getInputViewWordCountCalculator", "()Lh53/l;", "setInputViewWordCountCalculator", "(Lh53/l;)V", "inputViewWordCountCalculator", "", "()Ljava/lang/CharSequence;", "setContentText", "(Ljava/lang/CharSequence;)V", "contentText", "setMaxWordCount", "maxWordCount", "currentWordCount", "getHint", IECSearchBar.METHOD_SET_HINT, "hint", "getImeOptions", "setImeOptions", "imeOptions", "", "Landroid/text/InputFilter;", "getFilters", "()[Landroid/text/InputFilter;", "setFilters", "([Landroid/text/InputFilter;)V", "filters", "Landroid/widget/EditText;", "()Landroid/widget/EditText;", "editTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class QUIBaseInputView extends FrameLayout implements l {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String promptText;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean showWordCount;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showPromptText;

    /* renamed from: F, reason: from kotlin metadata */
    private int colorMode;

    /* renamed from: G, reason: from kotlin metadata */
    private int paddingHorizontal;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected CharacterCountEditText editText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected View inputContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected TextView promptTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected TextView maxCountTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int themeId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int style;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIBaseInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void t() {
        int i3;
        if (this.colorMode == 1) {
            i3 = R.color.qui_common_fill_standard_primary;
        } else {
            i3 = R.color.qui_common_fill_light_secondary;
        }
        int i16 = this.style;
        if (i16 == 1) {
            j().setBackground(b(i3, ViewUtils.dip2px(8.0f)));
        } else if (i16 == 2) {
            j().setBackground(null);
        } else {
            j().setBackground(b(i3, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A() {
        String sb5;
        if (g().getCharacterLimitCount() > 0) {
            if (g().getCurrentCount() > 0) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(g().getCurrentCount());
                sb6.append('/');
                sb6.append(g().getCharacterLimitCount());
                sb6.append('\u5b57');
                sb5 = sb6.toString();
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(g().getCharacterLimitCount());
                sb7.append('\u5b57');
                sb5 = sb7.toString();
            }
            k().setText(sb5);
            if (g().getCurrentCount() >= g().getCharacterLimitCount()) {
                k().setTextColor(c(R.color.qui_common_feedback_error));
            } else {
                k().setTextColor(c(R.color.qui_common_text_secondary));
            }
        }
    }

    public final void a() {
        g().clearFocus();
    }

    @NotNull
    protected final Drawable b(@ColorRes int tokenResId, int radius) {
        Drawable k3 = a.f().k(getContext(), tokenResId, radius, this.themeId);
        Intrinsics.checkNotNullExpressionValue(k3, "getInstances().getQuiTok\u2026adius.toFloat(), themeId)");
        return k3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c(@ColorRes int tokenResId) {
        return a.f().g(getContext(), tokenResId, this.themeId);
    }

    @Nullable
    public final CharSequence d() {
        return g().getText();
    }

    public final int e() {
        return g().getCurrentCount();
    }

    @NotNull
    protected final Drawable f(@DrawableRes int drawableResId, @ColorRes int tokenResId) {
        Drawable o16 = a.f().o(getContext(), drawableResId, tokenResId, this.themeId);
        Intrinsics.checkNotNullExpressionValue(o16, "getInstances().getQuiTok\u2026sId, tokenResId, themeId)");
        return o16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final CharacterCountEditText g() {
        CharacterCountEditText characterCountEditText = this.editText;
        if (characterCountEditText != null) {
            return characterCountEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("editText");
        return null;
    }

    @NotNull
    public final EditText h() {
        return g();
    }

    @Nullable
    public final j i() {
        return null;
    }

    @NotNull
    protected final View j() {
        View view = this.inputContent;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputContent");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView k() {
        TextView textView = this.maxCountTextView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("maxCountTextView");
        return null;
    }

    public final int l() {
        return g().getCharacterLimitCount();
    }

    @NotNull
    protected final TextView m() {
        TextView textView = this.promptTextView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("promptTextView");
        return null;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getShowWordCount() {
        return this.showWordCount;
    }

    /* renamed from: o, reason: from getter */
    public final int getThemeId() {
        return this.themeId;
    }

    public void p() {
        InputMethodUtil.hide(g());
    }

    public final void q() {
        g().requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        g().setTextColor(c(R.color.qui_common_text_primary));
        g().setHintTextColor(c(R.color.qui_common_text_tertiary));
        if (Build.VERSION.SDK_INT >= 29) {
            g().setTextCursorDrawable(f(R.drawable.qui_input_cursor, R.color.qui_common_brand_standard));
        }
        m().setTextColor(c(R.color.qui_common_text_secondary));
        if (g().getCurrentCount() >= g().getCharacterLimitCount()) {
            k().setTextColor(c(R.color.qui_common_feedback_error));
        } else {
            k().setTextColor(c(R.color.qui_common_text_secondary));
        }
        t();
    }

    public void s() {
        g().setTextColor(c(R.color.qui_common_text_primary));
        m().setTextColor(c(R.color.qui_common_text_secondary));
        setPromptText(this.promptText);
    }

    @Override // com.tencent.mobileqq.widget.listitem.l
    public void setBackgroundType(@NotNull QUIListItemBackgroundType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        setStyle(2);
        View j3 = j();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        j3.setBackground(type.getBackground(context, this.themeId));
    }

    public final void setCalculateStrategy(@NotNull QUIInputCountCalculateStrategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        g().setCalculateStrategy(strategy);
    }

    public final void setColorMode(int i3) {
        this.colorMode = i3;
        t();
    }

    public final void setContentText(@Nullable CharSequence charSequence) {
        g().setText(charSequence);
    }

    public final void setFilters(@NotNull InputFilter[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        g().setFilters(value);
    }

    public final void setHint(@Nullable String str) {
        g().setHint(str);
    }

    public final void setImeOptions(int i3) {
        g().setImeOptions(i3);
    }

    public final void setInputViewWordCountCalculator(@Nullable h53.l lVar) {
        if (lVar != null) {
            g().setInputViewWordCountCalculator(lVar);
        }
    }

    public final void setMaxWordCount(int i3) {
        int i16 = 8;
        if (i3 > 0) {
            TextView k3 = k();
            if (this.showWordCount) {
                i16 = 0;
            }
            k3.setVisibility(i16);
            g().setLimitCount(i3);
            A();
            return;
        }
        k().setVisibility(8);
    }

    public final void setPaddingHorizontal(int i3) {
        j().setPadding(i3, j().getPaddingTop(), i3, j().getPaddingBottom());
    }

    public final void setPromptText(@Nullable String str) {
        boolean z16;
        this.promptText = str;
        m().setTextColor(c(R.color.qui_common_text_secondary));
        String str2 = this.promptText;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            m().setVisibility(8);
        } else {
            m().setVisibility(0);
            m().setText(this.promptText);
        }
    }

    public final void setShowPromptText(boolean z16) {
        int i3;
        this.showPromptText = z16;
        TextView m3 = m();
        if (this.showPromptText) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        m3.setVisibility(i3);
    }

    public final void setShowWordCount(boolean z16) {
        int i3;
        this.showWordCount = z16;
        TextView k3 = k();
        if (this.showWordCount) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        k3.setVisibility(i3);
    }

    public final void setStyle(int i3) {
        this.style = i3;
        t();
    }

    public final void setTextFocusable(boolean focusable) {
        g().setFocusable(focusable);
    }

    public final void setTextFocusableInTouchMode(boolean focusableInTouchMode) {
        g().setFocusableInTouchMode(focusableInTouchMode);
    }

    public final void setTextSelection(int index) {
        g().setSelection(index);
    }

    public final void setThemeId(int i3) {
        if (this.themeId != i3) {
            this.themeId = i3;
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(@NotNull CharacterCountEditText characterCountEditText) {
        Intrinsics.checkNotNullParameter(characterCountEditText, "<set-?>");
        this.editText = characterCountEditText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.inputContent = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.maxCountTextView = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.promptTextView = textView;
    }

    public void y(@NotNull String errorTips) {
        Intrinsics.checkNotNullParameter(errorTips, "errorTips");
        s();
        m().setVisibility(0);
        m().setText(errorTips);
        m().setTextColor(c(R.color.qui_common_feedback_error));
    }

    public void z() {
        InputMethodUtil.show(g());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIBaseInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QUIBaseInputView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIBaseInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.themeId = 1000;
        this.showWordCount = true;
        this.showPromptText = true;
        this.paddingHorizontal = ViewUtils.dip2px(16.0f);
    }

    public final void setEditorActionListener(@Nullable j jVar) {
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener l3) {
    }
}
