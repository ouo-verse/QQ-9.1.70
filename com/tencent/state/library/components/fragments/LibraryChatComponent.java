package com.tencent.state.library.components.fragments;

import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.components.BasicServiceComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryChatComponent;", "Lcom/tencent/state/library/components/fragments/LibraryBaseComponent;", "()V", "getServiceProvider", "Lcom/tencent/state/IVasBaseServiceProvider;", "openAioChat", "", "uin", "", "nick", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryChatComponent extends LibraryBaseComponent {
    private static final String TAG = "LibraryChatComponent";

    private final IVasBaseServiceProvider getServiceProvider() {
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            return (BasicServiceComponent) fragment.getComponent(BasicServiceComponent.class, null, null);
        }
        return null;
    }

    public final void openAioChat(String uin, String nick) {
        MessageRecordType messageRecordType;
        Intrinsics.checkNotNullParameter(uin, "uin");
        IVasBaseServiceProvider serviceProvider = getServiceProvider();
        ISquareBaseMessageService messageService = serviceProvider != null ? serviceProvider.getMessageService() : null;
        boolean isFriend = messageService != null ? messageService.isFriend(uin) : false;
        if (getActivity() == null || messageService == null) {
            return;
        }
        VasBaseFragment fragment = getFragment();
        if (isFriend) {
            messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
        } else {
            messageRecordType = MessageRecordType.RECORD_TYPE_SQUARE_TEMP;
        }
        ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService, fragment, 1, uin, messageRecordType, false, false, null, nick, null, 320, null);
    }

    public static /* synthetic */ void openAioChat$default(LibraryChatComponent libraryChatComponent, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        libraryChatComponent.openAioChat(str, str2);
    }
}
