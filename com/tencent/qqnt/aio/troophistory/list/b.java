package com.tencent.qqnt.aio.troophistory.list;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.mobileqq.aio.msglist.AIOMsgListDataState;
import com.tencent.mobileqq.aio.msglist.BaseMsgListVM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/troophistory/list/b;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgListVM;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, "intent", "o", "implState", "D", "Lcom/tencent/qqnt/aio/troophistory/list/TroopHistoryMsgAIORepo;", "Lcom/tencent/qqnt/aio/troophistory/list/TroopHistoryMsgAIORepo;", "repo", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends BaseMsgListVM<at.b, MsgListUiState> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopHistoryMsgAIORepo repo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/troophistory/list/b$a", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, displayList, lastMsg, firstMsg)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            return true;
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, displayList, lastMsg, firstMsg)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            return false;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @Nullable
    public MsgListUiState D(@NotNull MsgListUiState implState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MsgListUiState) iPatchRedirector.redirect((short) 5, (Object) this, (Object) implState);
        }
        Intrinsics.checkNotNullParameter(implState, "implState");
        TroopHistoryMsgAIORepo troopHistoryMsgAIORepo = null;
        if (!(implState instanceof MsgListState)) {
            return null;
        }
        MsgListState msgListState = (MsgListState) implState;
        long focusIndex = msgListState.getFocusIndex();
        Collection collection = (Collection) implState;
        TroopHistoryMsgAIORepo troopHistoryMsgAIORepo2 = this.repo;
        if (troopHistoryMsgAIORepo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        } else {
            troopHistoryMsgAIORepo = troopHistoryMsgAIORepo2;
        }
        return new AIOMsgListDataState(focusIndex, collection, false, troopHistoryMsgAIORepo.H(), msgListState.getUpdateType(), msgListState.getExtra());
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull at.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        TroopHistoryMsgAIORepo troopHistoryMsgAIORepo = null;
        if (intent instanceof a.b) {
            TroopHistoryMsgAIORepo troopHistoryMsgAIORepo2 = this.repo;
            if (troopHistoryMsgAIORepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                troopHistoryMsgAIORepo = troopHistoryMsgAIORepo2;
            }
            troopHistoryMsgAIORepo.i(((a.b) intent).a());
            return;
        }
        if (intent instanceof a.c) {
            TroopHistoryMsgAIORepo troopHistoryMsgAIORepo3 = this.repo;
            if (troopHistoryMsgAIORepo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                troopHistoryMsgAIORepo = troopHistoryMsgAIORepo3;
            }
            troopHistoryMsgAIORepo.e();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        TroopHistoryMsgAIORepo troopHistoryMsgAIORepo = new TroopHistoryMsgAIORepo(context, vmScope());
        this.repo = troopHistoryMsgAIORepo;
        z(troopHistoryMsgAIORepo);
        super.onCreate(context);
    }
}
