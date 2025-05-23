package com.tencent.mobileqq.troop.teamup.member.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/adapter/m;", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/h;", "Lcom/tencent/mobileqq/troop/teamup/member/data/b;", "data", "", "l", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;", "E", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;", "eventHandler", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "typeName", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "typeIcon", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class m extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final a eventHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView typeName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView typeIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull View itemView, @NotNull a eventHandler) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) eventHandler);
            return;
        }
        this.eventHandler = eventHandler;
        View findViewById = itemView.findViewById(R.id.z29);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.member_type_item_name)");
        this.typeName = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.z28);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.member_type_item_icon)");
        this.typeIcon = (ImageView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(m this$0, com.tencent.mobileqq.troop.teamup.member.data.b data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Function2<View, com.tencent.mobileqq.troop.teamup.member.data.e, Unit> e16 = this$0.eventHandler.e();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        e16.invoke(it, data);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.mobileqq.troop.teamup.member.adapter.h
    public void l(@NotNull final com.tencent.mobileqq.troop.teamup.member.data.b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof com.tencent.mobileqq.troop.teamup.member.data.e)) {
            return;
        }
        ImageView imageView = this.typeIcon;
        com.tencent.mobileqq.troop.teamup.member.data.e eVar = (com.tencent.mobileqq.troop.teamup.member.data.e) data;
        Boolean valueOf = Boolean.valueOf(eVar.c());
        imageView.setVisibility(8);
        if (((View) au.a(valueOf, imageView)) == null) {
            imageView.setVisibility(0);
        }
        TriggerRunnerKt.c(this.typeIcon, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.adapter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.n(m.this, data, view);
            }
        }, 1, null);
        this.typeName.setText(eVar.b());
    }
}
