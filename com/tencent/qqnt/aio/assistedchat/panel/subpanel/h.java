package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.u;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/h;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/f;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "l", "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lkotlin/Function0;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "r", "(Lkotlin/jvm/functions/Function0;)V", "clickListener", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class h extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> clickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context context) {
        super(new FrameLayout(context));
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) view).setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h this$0, a aVar, View view) {
        Map<String, String> mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u.a().b()) {
            Function0<Unit> function0 = this$0.clickListener;
            if (function0 != null) {
                function0.invoke();
            }
            String d16 = aVar.d();
            if (d16 != null) {
                AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
                View itemView = this$0.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("null_type", d16));
                assistedChatPanelDtReporter.a("em_kl_auxiliary_chat_panel_empty", itemView, mapOf);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.f
    public void l(@NotNull e item, int position) {
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item, position);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        final a a16 = item.a();
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.removeAllViews();
        if (a16 == null) {
            return;
        }
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(this.context);
        builder.setImageType(a16.b());
        boolean z16 = false;
        builder.setBackgroundColorType(0);
        builder.setHalfScreenState(true);
        builder.setTitle(a16.c());
        String a17 = a16.a();
        if (a17.length() > 0) {
            z16 = true;
        }
        if (z16) {
            builder.setButton(a17, new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.q(h.this, a16, view2);
                }
            });
        }
        frameLayout.addView(builder.build(), new FrameLayout.LayoutParams(-1, -1));
        String d16 = a16.d();
        if (d16 != null) {
            AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("null_type", d16));
            assistedChatPanelDtReporter.c("em_kl_auxiliary_chat_panel_empty", itemView, mapOf);
        }
    }

    public final void r(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function0);
        } else {
            this.clickListener = function0;
        }
    }
}
