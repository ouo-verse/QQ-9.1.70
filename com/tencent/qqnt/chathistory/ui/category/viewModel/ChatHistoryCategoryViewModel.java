package com.tencent.qqnt.chathistory.ui.category.viewModel;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.category.data.a;
import com.tencent.qqnt.chathistory.ui.category.data.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u001a\u0010\u000f\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/category/viewModel/ChatHistoryCategoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/data/a;", "Lcom/tencent/qqnt/chathistory/ui/category/data/b;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "Landroidx/viewpager/widget/PagerAdapter;", "S1", "userIntent", "", "T1", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/chathistory/ui/category/data/b;", "R1", "()Lcom/tencent/qqnt/chathistory/ui/category/data/b;", "mNoneValueIntent", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryCategoryViewModel extends BaseHistoryViewModel<a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    public ChatHistoryCategoryViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mNoneValueIntent = b.a.f353384a;
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @NotNull
    public final PagerAdapter S1(@NotNull FragmentManager childFragmentManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PagerAdapter) iPatchRedirector.redirect((short) 3, (Object) this, (Object) childFragmentManager);
        }
        Intrinsics.checkNotNullParameter(childFragmentManager, "childFragmentManager");
        return new com.tencent.qqnt.chathistory.ui.category.b(L1().Q1(), childFragmentManager, new Function1<Integer, BaseHistoryFragment<?>>() { // from class: com.tencent.qqnt.chathistory.ui.category.viewModel.ChatHistoryCategoryViewModel$getVpAdapter$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryCategoryViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ BaseHistoryFragment<?> invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final BaseHistoryFragment<?> invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? ChatHistoryCategoryViewModel.this.L1().M1(i3) : (BaseHistoryFragment) iPatchRedirector2.redirect((short) 2, (Object) this, i3);
            }
        });
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userIntent);
        } else {
            Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        }
    }
}
