package com.tencent.qqnt.chathistory.ui.troopMember.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.troopMember.data.a;
import com.tencent.qqnt.chathistory.ui.troopMember.data.b;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0014R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/viewmodel/ChatHistoryTroopMemberViewModel;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/data/a;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/data/b;", "", "X1", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "map", "T1", "userIntent", "Z1", "onCleared", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "W1", "()Ljava/lang/String;", WadlProxyConsts.SCENE_ID, "U1", "()Lcom/tencent/qqnt/chathistory/ui/troopMember/data/b;", "mNoneValueIntent", "<init>", "()V", "G", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryTroopMemberViewModel extends BaseHistoryViewModel<com.tencent.qqnt.chathistory.ui.troopMember.data.a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy sceneId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/viewmodel/ChatHistoryTroopMemberViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.troopMember.viewmodel.ChatHistoryTroopMemberViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51605);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatHistoryTroopMemberViewModel() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.viewmodel.ChatHistoryTroopMemberViewModel$sceneId$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryTroopMemberViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    s c16 = f.c();
                    if (c16 != null) {
                        return c16.createMemberListScene(Long.parseLong(ChatHistoryTroopMemberViewModel.this.N1()), "aio");
                    }
                    return null;
                }
            });
            this.sceneId = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(HashMap<String, MemberInfo> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, MemberInfo> entry : map.entrySet()) {
            String str = entry.getValue().uid;
            Intrinsics.checkNotNullExpressionValue(str, "it.value.uid");
            String str2 = entry.getValue().nick;
            Intrinsics.checkNotNullExpressionValue(str2, "it.value.nick");
            arrayList.add(new com.tencent.qqnt.chathistory.ui.troopMember.data.model.a(str, str2));
        }
        obtainUiState().setValue(new a.C9555a(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String W1() {
        return (String) this.sceneId.getValue();
    }

    private final void X1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ChatHistoryTroopMemberViewModel$getTroopMembers$1(this, null), 3, null);
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.C9556b.f353942a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            X1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        s c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onCleared();
        String W1 = W1();
        if (W1 != null && (c16 = f.c()) != null) {
            c16.destroyMemberListScene(W1);
        }
    }
}
