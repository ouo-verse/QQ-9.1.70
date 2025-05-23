package com.tencent.storage.view.card;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.storage.view.rtv.RollingTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001AB1\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010<\u001a\u00020\u000f\u0012\b\b\u0002\u0010=\u001a\u00020\u000f\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010\"\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\"\u0010'\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006B"}, d2 = {"Lcom/tencent/storage/view/card/StorageCardView;", "Landroidx/cardview/widget/CardView;", "Landroid/content/res/TypedArray;", "arr", "", "l", "", "size", "unit", "", "animate", "setStorageSize", "Landroid/view/View$OnClickListener;", "listener", "setOperateAction", "", "resId", "setOperateBg", h.F, "i", "j", "setClearCardBtnShow", "k", "setloadingGone", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvTitle", "Lcom/tencent/storage/view/rtv/RollingTextView;", "e", "Lcom/tencent/storage/view/rtv/RollingTextView;", "tvSize", "f", "tvUnit", "tvDesc", DomainData.DOMAIN_NAME, "()Landroid/widget/TextView;", "setTvOperate$storage_view_kit_release", "(Landroid/widget/TextView;)V", "tvOperate", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "setOperateContainer$storage_view_kit_release", "(Landroid/view/ViewGroup;)V", "operateContainer", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "rtvContainer", "D", "loadingContainer", "E", "Z", "isOptimizeStorageUI", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", UserInfo.SEX_FEMALE, "a", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class StorageCardView extends CardView {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private View rtvContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private View loadingContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isOptimizeStorageUI;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView tvTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RollingTextView tvSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RollingTextView tvUnit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView tvDesc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView tvOperate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewGroup operateContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/storage/view/card/StorageCardView$a;", "", "", "APPEAR_ANIMATION_DURATION", "J", "", "STORAGE_SIZE_FONT_SIZE", UserInfo.SEX_FEMALE, "STORAGE_UNIT_FONT_SIZE", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.storage.view.card.StorageCardView$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35464);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StorageCardView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
    }

    private final void l(TypedArray arr) {
        String str;
        String str2;
        String string = arr.getString(com.tencent.storage.view.b.L3);
        String str3 = "";
        if (string == null) {
            string = "";
        }
        String string2 = arr.getString(com.tencent.storage.view.b.K3);
        if (string2 == null) {
            str = "";
        } else {
            str = string2;
        }
        String string3 = arr.getString(com.tencent.storage.view.b.M3);
        if (string3 == null) {
            string3 = "MB";
        }
        String string4 = arr.getString(com.tencent.storage.view.b.F3);
        if (string4 == null) {
            str2 = "";
        } else {
            str2 = string4;
        }
        ColorStateList colorStateList = arr.getColorStateList(com.tencent.storage.view.b.G3);
        int resourceId = arr.getResourceId(com.tencent.storage.view.b.H3, 0);
        String string5 = arr.getString(com.tencent.storage.view.b.I3);
        if (string5 != null) {
            str3 = string5;
        }
        ColorStateList colorStateList2 = arr.getColorStateList(com.tencent.storage.view.b.J3);
        this.tvTitle.setText(string);
        this.tvSize.setTextSize(1, 39.0f);
        this.tvSize.setTextColorStateList(R.color.qui_common_text_primary);
        RollingTextView.setText$default(this.tvSize, str, false, false, 4, null);
        this.tvSize.setTextFont(PTSNodeTextBase.FONT_FAMILY_SANS_SERIF_MEDIUM);
        this.tvUnit.setTextSize(1, 16.0f);
        this.tvUnit.setTextColorStateList(R.color.qui_common_text_primary);
        RollingTextView.setText$default(this.tvUnit, string3, false, false, 4, null);
        this.tvUnit.setTextFont(PTSNodeTextBase.FONT_FAMILY_SANS_SERIF_MEDIUM);
        this.tvDesc.setText(str2);
        this.tvDesc.setTextColor(colorStateList);
        this.operateContainer.setBackgroundResource(resourceId);
        this.tvOperate.setText(str3);
        this.tvOperate.setTextColor(colorStateList2);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101382", false);
        this.isOptimizeStorageUI = isSwitchOn;
        if (isSwitchOn) {
            this.operateContainer.setVisibility(0);
            this.operateContainer.setAlpha(0.3f);
        } else {
            this.loadingContainer.setVisibility(8);
            this.rtvContainer.setAlpha(1.0f);
        }
        float f16 = this.tvSize.g().getFontMetrics().bottom - this.tvUnit.g().getFontMetrics().bottom;
        ViewGroup.LayoutParams layoutParams = this.tvUnit.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = (int) f16;
        this.tvUnit.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(View.OnClickListener listener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void setStorageSize$default(StorageCardView storageCardView, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        storageCardView.setStorageSize(str, str2, z16);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L), ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_X, 0.5f, 1.0f).setDuration(300L), ObjectAnimator.ofFloat(this, BasicAnimation.KeyPath.SCALE_Y, 0.5f, 1.0f).setDuration(300L));
        animatorSet.start();
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.operateContainer.setVisibility(0);
            ObjectAnimator.ofFloat(this.operateContainer, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            ObjectAnimator.ofFloat(this.operateContainer, com.tencent.luggage.wxa.c8.c.f123400v, 0.3f, 1.0f).setDuration(300L).start();
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            ObjectAnimator.ofFloat(this.rtvContainer, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
        }
    }

    @NotNull
    public final ViewGroup m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.operateContainer;
    }

    @NotNull
    public final TextView n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.tvOperate;
    }

    public final void setClearCardBtnShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.operateContainer.setAlpha(1.0f);
            this.operateContainer.setVisibility(0);
        }
    }

    public final void setOperateAction(@NotNull final View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.operateContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.storage.view.card.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StorageCardView.o(listener, view);
                }
            });
        }
    }

    public final void setOperateBg(int resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, resId);
        } else {
            this.operateContainer.setBackgroundResource(resId);
        }
    }

    public final void setOperateContainer$storage_view_kit_release(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup);
        } else {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.operateContainer = viewGroup;
        }
    }

    public final void setStorageSize(@NotNull String size, @NotNull String unit, boolean animate) {
        CharSequence trim;
        CharSequence trim2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, size, unit, Boolean.valueOf(animate));
            return;
        }
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.rtvContainer.setContentDescription(size + TokenParser.SP + unit);
        RollingTextView rollingTextView = this.tvSize;
        trim = StringsKt__StringsKt.trim((CharSequence) size);
        RollingTextView.setText$default(rollingTextView, trim.toString(), animate, false, 4, null);
        RollingTextView rollingTextView2 = this.tvUnit;
        trim2 = StringsKt__StringsKt.trim((CharSequence) unit);
        RollingTextView.setText$default(rollingTextView2, trim2.toString(), animate, false, 4, null);
    }

    public final void setTvOperate$storage_view_kit_release(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvOperate = textView;
        }
    }

    public final void setloadingGone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.loadingContainer.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StorageCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StorageCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ StorageCardView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StorageCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.hqx, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.kaq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_size)");
        this.tvSize = (RollingTextView) findViewById2;
        View findViewById3 = findViewById(R.id.f112196n_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_unit)");
        this.tvUnit = (RollingTextView) findViewById3;
        View findViewById4 = findViewById(R.id.f167042k73);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_desc)");
        this.tvDesc = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f109776gq);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_operate)");
        this.tvOperate = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.agk);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.btn_container)");
        this.operateContainer = (ViewGroup) findViewById6;
        View findViewById7 = findViewById(R.id.f785847g);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.rtv_container)");
        this.rtvContainer = findViewById7;
        View findViewById8 = findViewById(R.id.ef_);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.loading_container)");
        this.loadingContainer = findViewById8;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.storage.view.b.E3, i3, i16);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026tr, defStyleRes\n        )");
        l(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
