package com.tencent.qqnt.chathistory.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog;
import com.tencent.qqnt.chathistory.ui.menu.viewmodel.ChatHistorySearchViewModel;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/activity/SearchFacadeFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/menu/viewmodel/ChatHistorySearchViewModel;", "Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog$b;", "", "Bh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "onBackPressed", "onDismiss", "", "chatType", "", "peerId", "", "msgId", "msgSeq", ICustomDataEditor.NUMBER_PARAM_9, "Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog;", "E", "Lkotlin/Lazy;", "Ah", "()Lcom/tencent/qqnt/chathistory/ui/dialog/SearchChatHistoryDialog;", "searchDialog", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, OcrConfig.CHINESE, "()Landroid/widget/LinearLayout;", "contentView", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class SearchFacadeFragment extends BaseHistoryFragment<ChatHistorySearchViewModel> implements SearchChatHistoryDialog.b {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchDialog;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public SearchFacadeFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SearchChatHistoryDialog>() { // from class: com.tencent.qqnt.chathistory.ui.activity.SearchFacadeFragment$searchDialog$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchFacadeFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SearchChatHistoryDialog invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new SearchChatHistoryDialog(SearchFacadeFragment.this.rh()) : (SearchChatHistoryDialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.searchDialog = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.qqnt.chathistory.ui.activity.SearchFacadeFragment$contentView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchFacadeFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(SearchFacadeFragment.this.getContext());
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    linearLayout.setOrientation(1);
                    return linearLayout;
                }
            });
            this.contentView = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final SearchChatHistoryDialog Ah() {
        return (SearchChatHistoryDialog) this.searchDialog.getValue();
    }

    private final void Bh() {
        Dialog dialog = Ah().getDialog();
        boolean z16 = false;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Ah().Vh(this);
        Ah().show(getChildFragmentManager(), "searchDialog");
    }

    private final LinearLayout zh() {
        return (LinearLayout) this.contentView.getValue();
    }

    @Override // com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog.b
    public void n9(int chatType, @NotNull String peerId, long msgId, long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(chatType), peerId, Long.valueOf(msgId), Long.valueOf(msgSeq));
            return;
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        QLog.d("SearchFacade", 2, "onClickItem3");
        Intent intent = new Intent();
        intent.putExtra("key_navigate_msgid", msgId);
        intent.putExtra("key_navigate_msgseq", msgSeq);
        requireActivity().setResult(-1, intent);
        requireActivity().finish();
    }

    @Override // com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog.b
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            requireActivity().finish();
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.dialog.SearchChatHistoryDialog.b
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            requireActivity().finish();
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bh();
        return zh();
    }
}
