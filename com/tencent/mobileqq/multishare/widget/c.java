package com.tencent.mobileqq.multishare.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\"B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/multishare/widget/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "", "labelText", "", "r", "Lcom/tencent/mobileqq/multishare/action/b;", "shareAction", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "action", "", "position", DomainData.DOMAIN_NAME, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "label", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "icon", "G", "Lcom/tencent/mobileqq/multishare/action/b;", "shareActionItem", "H", "I", com.tencent.luggage.wxa.c8.c.G, "itemView", "<init>", "(Landroid/view/View;)V", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TextView label;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ImageView icon;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.multishare.action.b shareActionItem;

    /* renamed from: H, reason: from kotlin metadata */
    private int pos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/multishare/widget/c$a;", "", "", "ICON_SIZE", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.widget.c$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43369);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View itemView) {
        super(itemView);
        ViewGroup viewGroup;
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
        this.pos = -1;
        QUICheckBox qUICheckBox = (QUICheckBox) itemView.findViewById(R.id.zil);
        if (qUICheckBox != null) {
            if (itemView instanceof ViewGroup) {
                viewGroup = (ViewGroup) itemView;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(qUICheckBox);
            }
        }
        itemView.setOnClickListener(this);
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        Context context = itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        cVar.i(context, itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(i92.b bVar) {
        bVar.f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(c this$0, i92.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.multishare.action.b bVar = this$0.shareActionItem;
        if (bVar != null) {
            aVar.U2(bVar);
        }
    }

    private final void q(com.tencent.mobileqq.multishare.action.b shareAction) {
        Number number;
        Number number2;
        Drawable drawable = ResourcesCompat.getDrawable(this.itemView.getContext().getResources(), shareAction.getDrawableId(), null);
        if (drawable == null) {
            return;
        }
        int dip2px = ViewUtils.dip2px(52.0f);
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        com.tencent.mobileqq.multishare.util.e eVar = new com.tencent.mobileqq.multishare.util.e(context);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (dip2px > intrinsicWidth) {
            number = Float.valueOf((dip2px - intrinsicWidth) / 2.0f);
        } else {
            number = 0;
        }
        if (dip2px > intrinsicHeight) {
            number2 = Float.valueOf((dip2px - intrinsicHeight) / 2.0f);
        } else {
            number2 = 0;
        }
        Drawable a16 = eVar.a(drawable, number.intValue(), number2.intValue());
        this.icon.setImageDrawable(eVar.c(a16, eVar.b(a16)));
        this.icon.setBackground(null);
    }

    private final void r(String labelText) {
        this.label.setText(labelText);
    }

    public final void n(@NotNull com.tencent.mobileqq.multishare.action.b action, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) action, position);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        this.shareActionItem = action;
        this.pos = position;
        q(action);
        r(action.getLabel());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else if (this.shareActionItem instanceof com.tencent.mobileqq.multishare.item.b) {
            RFWIocAbilityProvider.g().getIoc(i92.b.class).originView(this.itemView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.multishare.widget.a
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    c.o((i92.b) obj);
                }
            }).run();
            QLog.d("MultiShareActionItemVH", 1, "[onClick] send to more friends action action click.");
        } else {
            RFWIocAbilityProvider.g().getIoc(i92.a.class).originView(this.itemView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.multishare.widget.b
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    c.p(c.this, (i92.a) obj);
                }
            }).run();
            QLog.d("MultiShareActionItemVH", 1, "[onClick] action click.");
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
