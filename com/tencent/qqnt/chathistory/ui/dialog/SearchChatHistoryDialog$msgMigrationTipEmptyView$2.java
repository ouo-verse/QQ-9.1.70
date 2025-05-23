package com.tencent.qqnt.chathistory.ui.dialog;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.chathistory.api.IMsgMigrationApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class SearchChatHistoryDialog$msgMigrationTipEmptyView$2 extends Lambda implements Function0<QUIEmptyState> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ SearchChatHistoryDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchChatHistoryDialog$msgMigrationTipEmptyView$2(SearchChatHistoryDialog searchChatHistoryDialog) {
        super(0);
        this.this$0 = searchChatHistoryDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) searchChatHistoryDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SearchChatHistoryDialog this$0, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ((IMsgMigrationApi) companion.a(IMsgMigrationApi.class)).triggerToMigration(this$0.getContext());
        IMsgMigrationApi iMsgMigrationApi = (IMsgMigrationApi) companion.a(IMsgMigrationApi.class);
        i3 = this$0.com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin.USERTYPE java.lang.String;
        IMsgMigrationApi.a.a(iMsgMigrationApi, "0X800C4DF", i3, 0, null, null, null, null, 124, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUIEmptyState invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIEmptyState) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(this.this$0.getContext()).setImageType(9).setBackgroundColorType(0);
        String qqStr = HardCodeUtil.qqStr(R.string.f168372fg);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.msg_migration_blank_view_title)");
        QUIEmptyState.Builder title = backgroundColorType.setTitle(qqStr);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f168362ff);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.msg_migration_blank_view_desc)");
        QUIEmptyState.Builder desc = title.setDesc(qqStr2);
        String qqStr3 = HardCodeUtil.qqStr(R.string.f168392fi);
        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.msg_migration_tips_jump)");
        final SearchChatHistoryDialog searchChatHistoryDialog = this.this$0;
        QUIEmptyState build = desc.setButton(qqStr3, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchChatHistoryDialog$msgMigrationTipEmptyView$2.b(SearchChatHistoryDialog.this, view);
            }
        }).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        build.setVisibility(0);
        return build;
    }
}
