package com.tencent.mobileqq.newfriend.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u000eJ\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010(\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001eR\u0018\u0010,\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/newfriend/ui/view/PYMKItemView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "recFriendData", "", "e", "f", "g", "recommendData", "", "c", "d", "a", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "b", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "Landroid/view/View;", "contentLayout", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "textContentContainer", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "nickText", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "i", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "troopLabelLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reasonText", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "addBtn", "D", "addStatusText", "E", "mediaLayout", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes15.dex */
public final class PYMKItemView extends LinearLayout implements View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QUIButton addBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView addStatusText;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mediaLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MayKnowRecommend recFriendData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View contentLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQProAvatarView avatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View textContentContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView nickText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopLabelLayout troopLabelLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView reasonText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PYMKItemView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    private final String c(MayKnowRecommend recommendData) {
        String displayName = recommendData.getDisplayName();
        Intrinsics.checkNotNullExpressionValue(displayName, "recommendData.displayName");
        return displayName;
    }

    private final void e(MayKnowRecommend recFriendData) {
        boolean z16;
        List<MayKnowRecommend.MayKnowRecommendLabel> list = recFriendData.msgLabel;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.troopLabelLayout.setVisibility(8);
        } else {
            this.troopLabelLayout.setVisibility(0);
            this.troopLabelLayout.k(RecommendLabel.convertToRecommendLabel(recFriendData.msgLabel), recFriendData.gender, recFriendData.age, true);
        }
    }

    private final void f(MayKnowRecommend recFriendData) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(recFriendData.category)) {
            sb5.append(recFriendData.category);
            sb5.append(" ");
        }
        if (!TextUtils.isEmpty(recFriendData.recommendReason)) {
            sb5.append(recFriendData.recommendReason);
        }
        if (TextUtils.isEmpty(sb5.toString())) {
            this.reasonText.setVisibility(8);
            return;
        }
        boolean z16 = false;
        this.reasonText.setVisibility(0);
        this.reasonText.setText(sb5.toString());
        List<MayKnowRecommend.MayKnowRecommendLabel> list = recFriendData.msgLabel;
        if (list == null || list.isEmpty()) {
            z16 = true;
        }
        boolean z17 = !z16;
        TextView textView = this.reasonText;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(18, R.id.f95205ec);
        layoutParams.addRule(3, R.id.f95205ec);
        if (!z17) {
            layoutParams.addRule(16, R.id.f759340a);
        }
        layoutParams.topMargin = e.c(4.0f);
        textView.setLayoutParams(layoutParams);
    }

    private final void g(MayKnowRecommend recFriendData) {
        int i3 = recFriendData.friendStatus;
        if (i3 != 0) {
            if (i3 != 1) {
                this.addBtn.setVisibility(8);
                this.addStatusText.setVisibility(0);
                this.addStatusText.setText(R.string.f170322m9);
                return;
            } else {
                this.addBtn.setVisibility(8);
                this.addStatusText.setVisibility(0);
                this.addStatusText.setText(R.string.f173067h24);
                return;
            }
        }
        this.addBtn.setVisibility(0);
        this.addBtn.setText(HardCodeUtil.qqStr(R.string.f170028dd));
        this.addStatusText.setVisibility(8);
    }

    public final void a(@NotNull MayKnowRecommend recFriendData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) recFriendData);
            return;
        }
        Intrinsics.checkNotNullParameter(recFriendData, "recFriendData");
        this.recFriendData = recFriendData;
        this.avatar.w(1, recFriendData.uin);
        this.nickText.setText(c(recFriendData));
        e(recFriendData);
        f(recFriendData);
        g(recFriendData);
        ViewGroup.LayoutParams layoutParams = this.textContentContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (this.troopLabelLayout.getVisibility() == 0 && this.reasonText.getVisibility() == 0) {
            layoutParams2.topMargin = 0;
        } else {
            layoutParams2.topMargin = e.c(3.0f);
        }
        this.textContentContainer.setLayoutParams(layoutParams2);
    }

    @NotNull
    public final QUIButton b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUIButton) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.addBtn;
    }

    public final void d() {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.mediaLayout == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.h1b, (ViewGroup) this, true);
            this.mediaLayout = inflate;
            if (inflate != null && (findViewById = inflate.findViewById(R.id.yzz)) != null) {
                findViewById.setOnTouchListener(this);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        if (v3 != null && v3.getId() == R.id.yzz) {
            Intrinsics.checkNotNull(event);
            if (event.getAction() == 0) {
                v3.setAlpha(0.5f);
                v3.invalidate();
            } else if (event.getAction() == 1 || event.getAction() == 3) {
                v3.setAlpha(1.0f);
                v3.invalidate();
            }
        }
        return false;
    }

    public /* synthetic */ PYMKItemView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PYMKItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.h1a, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026mk_main_item, this, true)");
        this.contentLayout = inflate;
        View findViewById = inflate.findViewById(R.id.a2o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentLayout.findViewById(R.id.avatar)");
        this.avatar = (QQProAvatarView) findViewById;
        View findViewById2 = this.contentLayout.findViewById(R.id.f95205ec);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentLayout.findViewBy\u2026d.text_content_container)");
        this.textContentContainer = findViewById2;
        View findViewById3 = this.contentLayout.findViewById(R.id.nickname);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentLayout.findViewById(R.id.nickname)");
        this.nickText = (TextView) findViewById3;
        View findViewById4 = this.contentLayout.findViewById(R.id.jzj);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentLayout.findViewBy\u2026(R.id.troop_label_layout)");
        this.troopLabelLayout = (TroopLabelLayout) findViewById4;
        View findViewById5 = this.contentLayout.findViewById(R.id.f166195ls0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentLayout.findViewById(R.id.maybe_base_reason)");
        this.reasonText = (TextView) findViewById5;
        View findViewById6 = this.contentLayout.findViewById(R.id.i8s);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentLayout.findViewById(R.id.result_btn)");
        this.addBtn = (QUIButton) findViewById6;
        View findViewById7 = this.contentLayout.findViewById(R.id.f166787i92);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentLayout.findViewById(R.id.result_show)");
        this.addStatusText = (TextView) findViewById7;
        setOrientation(1);
        int c16 = e.c(16.0f);
        int c17 = e.c(8.0f);
        setPadding(c16, c17, c16, c17);
        setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        setId(R.id.ibi);
    }
}
