package com.tencent.mobileqq.multishare.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.multishare.p007const.MultiShareSelectStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010)\u001a\u00020\u0011\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/multishare/widget/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/multishare/action/c;", "userItem", "", "r", "", "uinType", "", "labelText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "shareItem", "o", "p", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "label", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "icon", "G", "badgeIcon", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "H", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "I", "Lcom/tencent/mobileqq/multishare/action/c;", "J", "", "K", "Z", "isSelected", "itemView", "<init>", "(Landroid/view/View;)V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e extends RecyclerView.ViewHolder implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView label;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ImageView icon;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ImageView badgeIcon;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private QUICheckBox checkbox;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.multishare.action.c userItem;

    /* renamed from: J, reason: from kotlin metadata */
    private int pos;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isSelected;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f251820a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43378);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MultiShareSelectStatus.values().length];
            try {
                iArr[MultiShareSelectStatus.UNSELECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MultiShareSelectStatus.SELECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MultiShareSelectStatus.SELECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f251820a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.zio);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026i_share_action_item_text)");
        this.label = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.zim);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026i_share_action_item_icon)");
        this.icon = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f84184lk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026e_action_item_icon_badge)");
        this.badgeIcon = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.zil);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026are_action_item_checkbox)");
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById4;
        this.checkbox = qUICheckBox;
        this.pos = -1;
        qUICheckBox.setType(3);
        this.checkbox.setVisibility(8);
        this.isSelected = false;
        this.checkbox.setChecked(false);
        itemView.setOnClickListener(this);
        this.checkbox.setClickable(false);
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        cVar.i(context, itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(com.tencent.mobileqq.multishare.action.c user, e this$0, i92.b bVar) {
        Intrinsics.checkNotNullParameter(user, "$user");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bVar.o4(user, this$0.pos, this$0.isSelected);
    }

    private final void p(com.tencent.mobileqq.multishare.action.c shareItem) {
        int i3;
        com.tencent.mobileqq.multishare.util.d dVar = com.tencent.mobileqq.multishare.util.d.f251801a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        dVar.c(context, shareItem.f(), shareItem.g(), shareItem.d(), this.icon, "LOAD_SOURCE_RECENT_FRIENDS");
        if (shareItem.g() == 10027) {
            this.badgeIcon.setVisibility(0);
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.drawable.jns;
            } else {
                i3 = R.drawable.jnr;
            }
            this.badgeIcon.setImageResource(i3);
            return;
        }
        this.badgeIcon.setVisibility(8);
    }

    private final void q(int uinType, String labelText) {
        Resources resources = this.itemView.getContext().getResources();
        if (uinType == 10008) {
            String qqStr = HardCodeUtil.qqStr(R.string.o29);
            SpannableString spannableString = new SpannableString(qqStr + labelText);
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.f157374c73, null)), 0, qqStr.length(), 33);
            this.label.setText(spannableString);
            return;
        }
        this.label.setText(labelText);
    }

    private final void r(com.tencent.mobileqq.multishare.action.c userItem) {
        if (userItem instanceof com.tencent.mobileqq.multishare.item.a) {
            int i3 = a.f251820a[((com.tencent.mobileqq.multishare.item.a) userItem).i().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.checkbox.setVisibility(0);
                        this.isSelected = true;
                    }
                } else {
                    this.checkbox.setVisibility(0);
                    this.isSelected = false;
                }
            } else {
                this.checkbox.setVisibility(8);
                this.isSelected = false;
            }
            this.checkbox.setChecked(this.isSelected);
            return;
        }
        this.checkbox.setVisibility(8);
    }

    public final void m(@NotNull com.tencent.mobileqq.multishare.action.c userItem, int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) userItem, pos);
            return;
        }
        Intrinsics.checkNotNullParameter(userItem, "userItem");
        this.userItem = userItem;
        this.pos = pos;
        q(userItem.g(), userItem.e());
        if (userItem.c()) {
            o(userItem);
        } else {
            p(userItem);
        }
        r(userItem);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else if (v3 != null) {
            if (this.userItem instanceof com.tencent.mobileqq.multishare.item.a) {
                boolean z16 = !this.isSelected;
                this.isSelected = z16;
                this.checkbox.setChecked(z16);
                QUICheckBox qUICheckBox = this.checkbox;
                if (this.isSelected) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                qUICheckBox.setVisibility(i3);
            }
            final com.tencent.mobileqq.multishare.action.c cVar = this.userItem;
            if (cVar != null) {
                RFWIocAbilityProvider.g().getIoc(i92.b.class).originView(this.itemView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.multishare.widget.d
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj) {
                        e.n(com.tencent.mobileqq.multishare.action.c.this, this, (i92.b) obj);
                    }
                }).run();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final void o(com.tencent.mobileqq.multishare.action.c shareItem) {
    }
}
