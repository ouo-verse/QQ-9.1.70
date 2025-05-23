package com.tencent.qqnt.chathistory.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.chathistory.ui.activity.SearchFacadeFragment;
import com.tencent.qqnt.chathistory.ui.category.ChatHistoryCategoryFragment;
import com.tencent.qqnt.chathistory.ui.tabcontainer.TabContainerFragment;
import com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J*\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/impl/ChatHistoryApiImpl;", "Lcom/tencent/qqnt/chathistory/api/IChatHistoryApi;", "", "getTroopMemberHistoryFragmentClassName", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chathistory/api/a;", SessionDbHelper.SESSION_ID, "", "jumpChatHistoryActivity", "jumpChatHistoryCategoryActivity", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "chatType", "peerId", "showSearchDialogFragment", "Landroid/os/Bundle;", "bundle", "", "checkFromChatHistory", "clearChatHistoryBundle", "tabCategory", "jumpHistoryTab", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryApiImpl implements IChatHistoryApi {
    static IPatchRedirector $redirector_;

    public ChatHistoryApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryApi
    public boolean checkFromChatHistory(@NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return TextUtils.equals(bundle.getString("Key_Browser_Bundle"), "AIOService");
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryApi
    public void clearChatHistoryBundle(@NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        } else {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.remove("Key_Browser_Bundle");
        }
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryApi
    @NotNull
    public String getTroopMemberHistoryFragmentClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String name = TroopMemberHistoryFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "TroopMemberHistoryFragment::class.java.name");
        return name;
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryApi
    public void jumpChatHistoryActivity(@NotNull Context context, @NotNull com.tencent.qqnt.chathistory.api.a session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) session);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        QRoute.createNavigator(context, "/base/chathistory/main").withInt("nt_chat_history_chatType", session.a()).withString("nt_chat_history_peerId", session.b()).withString("nt_chat_history_session_name", session.c()).request();
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryApi
    public void jumpChatHistoryCategoryActivity(@NotNull Context context, @NotNull com.tencent.qqnt.chathistory.api.a session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) session);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        QRoute.createNavigator(context, "/base/chathistory/main").withInt("nt_chat_history_chatType", session.a()).withString("nt_chat_history_peerId", session.b()).withString("nt_chat_history_session_name", session.c()).withString("frameKey", ChatHistoryCategoryFragment.class.getName()).withInt("categorySelectKey", 0).withInt("key_source", session.d()).request();
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryApi, com.tencent.qqnt.chathistory.api.IHistoryForwardApi
    public void jumpHistoryTab(@NotNull Context context, @NotNull com.tencent.qqnt.chathistory.api.a session, int tabCategory, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, session, Integer.valueOf(tabCategory), bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        QRoute.createNavigator(context, "/base/chathistory/main").withInt("nt_chat_history_chatType", session.a()).withString("nt_chat_history_peerId", session.b()).withString("frameKey", TabContainerFragment.class.getName()).withInt("key_tab_container", tabCategory).withBundle("Key_tab_business_param", bundle).request();
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryApi
    public void showSearchDialogFragment(@NotNull Activity activity, int requestCode, int chatType, @NotNull String peerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, Integer.valueOf(requestCode), Integer.valueOf(chatType), peerId);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Navigator createNavigator = QRoute.createNavigator(activity, "/base/chathistory/main");
        if (chatType == 1) {
            i3 = 1;
        }
        Navigator.withRequestCode$default(createNavigator.withInt("nt_chat_history_chatType", i3).withString("nt_chat_history_peerId", peerId).withString("frameKey", SearchFacadeFragment.class.getName()), activity, requestCode, (Bundle) null, 4, (Object) null).request();
    }
}
