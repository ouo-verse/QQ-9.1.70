package com.tencent.mobileqq.ai;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0001(B\u001d\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0014R\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001b\u0010&\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0010R\u001b\u0010)\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010\u0010\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/ai/AIAvatarCapsuleTabBar;", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "Landroid/widget/TextView;", "tab", "", "position", "", "c", "", "title", "addTab", "currentPos", "updateTextColor", "d", "I", "getTabMarginPx", "()I", "setTabMarginPx", "(I)V", "tabMarginPx", "e", "getLeftMarginPx", "setLeftMarginPx", "leftMarginPx", "f", "getTabHeight", "tabHeight", tl.h.F, "getCheckedBg", "setCheckedBg", "checkedBg", "i", "getUncheckedBg", "setUncheckedBg", "uncheckedBg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "b", "tabVerticalPadding", BdhLogUtil.LogTag.Tag_Conn, "a", "tabHorizontalPadding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIAvatarCapsuleTabBar extends QUIPageTabBar {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabHorizontalPadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int tabMarginPx;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int leftMarginPx;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int tabHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int checkedBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int uncheckedBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tabVerticalPadding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/ai/AIAvatarCapsuleTabBar$a;", "", "", "DEFAULT_LEFT_MARGIN", UserInfo.SEX_FEMALE, "DEFAULT_TAB_HEIGHT", "DEFAULT_TAB_HORIZONTAL_PADDING", "DEFAULT_TAB_MARGIN", "DEFAULT_TAB_VERTICAL_PADDING", "DEFAULT_TEXT_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.AIAvatarCapsuleTabBar$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIAvatarCapsuleTabBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
    }

    private final int a() {
        return ((Number) this.tabHorizontalPadding.getValue()).intValue();
    }

    private final int b() {
        return ((Number) this.tabVerticalPadding.getValue()).intValue();
    }

    private final void c(TextView tab, int position) {
        if (position == getCurrentPosition()) {
            tab.setTextColor(this.mCheckedTextColor);
            tab.setBackgroundResource(this.checkedBg);
            tab.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            tab.setTextColor(this.mUncheckedTextColor);
            tab.setBackgroundResource(this.uncheckedBg);
            tab.setTypeface(Typeface.DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void addTab(int position, @Nullable String title) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, position, (Object) title);
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(title);
        textView.setTextSize(this.mTabTextSize);
        textView.setGravity(17);
        textView.setPadding(a(), b(), a(), b());
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        setAccessibilityDelegate(textView);
        setTabClickListener(position, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.tabHeight);
        layoutParams.gravity = 16;
        if (position == 0) {
            layoutParams.leftMargin = this.leftMarginPx;
        }
        layoutParams.rightMargin = this.tabMarginPx;
        this.mTabContainer.addView(textView, position, layoutParams);
        c(textView, position);
    }

    public final void setCheckedBg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.checkedBg = i3;
        }
    }

    public final void setLeftMarginPx(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.leftMarginPx = i3;
        }
    }

    public final void setTabMarginPx(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.tabMarginPx = i3;
        }
    }

    public final void setUncheckedBg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.uncheckedBg = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar
    public void updateTextColor(int currentPos) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, currentPos);
            return;
        }
        int childCount = this.mTabContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.mTabContainer.getChildAt(i3);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                textView = null;
            }
            if (textView == null) {
                QLog.e("AIAvatarCapsuleTabBar", 1, "updateTextColor, but textview is null.");
                return;
            }
            c(textView, i3);
        }
    }

    public /* synthetic */ AIAvatarCapsuleTabBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIAvatarCapsuleTabBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.tabMarginPx = ViewUtils.dip2px(8.0f);
        this.leftMarginPx = ViewUtils.dip2px(18.0f);
        this.tabHeight = ViewUtils.dip2px(26.0f);
        this.checkedBg = R.drawable.l9y;
        this.uncheckedBg = R.drawable.l9z;
        lazy = LazyKt__LazyJVMKt.lazy(AIAvatarCapsuleTabBar$tabVerticalPadding$2.INSTANCE);
        this.tabVerticalPadding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIAvatarCapsuleTabBar$tabHorizontalPadding$2.INSTANCE);
        this.tabHorizontalPadding = lazy2;
        this.mCheckedTextColor = context.getColorStateList(R.color.qui_common_text_primary);
        this.mUncheckedTextColor = context.getColorStateList(R.color.qui_common_text_primary);
        setTabTextSize(13.0f);
        setIsShowLine(false);
    }
}
