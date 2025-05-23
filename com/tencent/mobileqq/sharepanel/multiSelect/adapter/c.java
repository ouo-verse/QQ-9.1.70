package com.tencent.mobileqq.sharepanel.multiSelect.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "data", "", "r", "o", "p", DomainData.DOMAIN_NAME, "", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lwq2/b;", "E", "Lwq2/b;", "binding", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "itemData", "<init>", "(Lwq2/b;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends RecyclerView.ViewHolder implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final wq2.b binding;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private SharePanelContactItem itemData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull wq2.b binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding);
            return;
        }
        this.binding = binding;
        binding.f446060c.setType(3);
        binding.f446060c.setSizeType(1);
        binding.f446060c.setVisibility(8);
        binding.f446060c.setChecked(false);
        binding.f446060c.setClickable(false);
        this.itemView.setOnClickListener(this);
    }

    private final void n(SharePanelContactItem data) {
        this.binding.f446059b.setAvatarSize(ViewUtils.dpToPx(52.0f));
        this.binding.f446059b.b(data);
    }

    private final void o(SharePanelContactItem data) {
        int i3;
        QUICheckBox qUICheckBox = this.binding.f446060c;
        if (data.c()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qUICheckBox.setVisibility(i3);
        this.binding.f446060c.setChecked(data.j());
    }

    private final void p(SharePanelContactItem data) {
        this.binding.f446061d.setText(data.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(SharePanelContactItem data, com.tencent.mobileqq.sharepanel.ioc.a aVar) {
        Intrinsics.checkNotNullParameter(data, "$data");
        aVar.Z(data);
    }

    private final void r(SharePanelContactItem data) {
        SharePanelContactItem sharePanelContactItem;
        Object tag = this.itemView.getTag();
        if (tag instanceof SharePanelContactItem) {
            sharePanelContactItem = (SharePanelContactItem) tag;
        } else {
            sharePanelContactItem = null;
        }
        if (sharePanelContactItem == null || !Intrinsics.areEqual(sharePanelContactItem, data)) {
            com.tencent.mobileqq.sharepanel.ioc.f.f287347a.g(this.itemView, "em_share_object", com.tencent.mobileqq.sharepanel.report.a.b(data));
            this.itemView.setTag(data);
        }
    }

    public final void m(@NotNull SharePanelContactItem data, int pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, pos);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.itemData = data;
        n(data);
        p(data);
        o(data);
        r(data);
        this.binding.getRoot().setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            final SharePanelContactItem sharePanelContactItem = this.itemData;
            if (sharePanelContactItem != null) {
                RFWIocAbilityProvider.g().getIoc(com.tencent.mobileqq.sharepanel.ioc.a.class).originView(this.itemView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.adapter.b
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj) {
                        c.q(SharePanelContactItem.this, (com.tencent.mobileqq.sharepanel.ioc.a) obj);
                    }
                }).run();
                com.tencent.mobileqq.sharepanel.ioc.f.f287347a.d(this.itemView, "em_share_object", com.tencent.mobileqq.sharepanel.report.a.b(sharePanelContactItem));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
