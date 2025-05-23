package com.tencent.state.publicchat.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.OpenExtraMenuAction;
import com.tencent.state.publicchat.action.ReportMsgAction;
import com.tencent.state.publicchat.component.PublicChatExtraActionMenuComponent;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.view.BottomActionSheet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0005\u001e\u001f !\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent;", "Lcom/tencent/state/publicchat/component/PublicChatBaseComponent;", "()V", "aioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "onConfigLoaded", "", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "openExtraMenu", "uin", "", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "showMenu", "context", "Landroid/content/Context;", "actions", "", "Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionItem;", "ActionItem", "ActionType", "Companion", "ReportMsgActionItem", "ShieldUserActionItem", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PublicChatExtraActionMenuComponent extends PublicChatBaseComponent {
    private static final String TAG = "PublicChatExtraActionMenuComponent";
    private ISquareBaseMessageService aioService;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionItem;", "", "type", "Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionType;", "(Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionType;)V", "getType", "()Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionType;", "getTitle", "", "aioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static abstract class ActionItem {
        private final ActionType type;

        public ActionItem(ActionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public abstract String getTitle(ISquareBaseMessageService aioService);

        public final ActionType getType() {
            return this.type;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionType;", "", "(Ljava/lang/String;I)V", "REPORT_MSG", "SHIELD_USER", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public enum ActionType {
        REPORT_MSG,
        SHIELD_USER
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ReportMsgActionItem;", "Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionItem;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "(Lcom/tencent/state/publicchat/data/MsgInfo;)V", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "getTitle", "", "aioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class ReportMsgActionItem extends ActionItem {
        private final MsgInfo msg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReportMsgActionItem(MsgInfo msg2) {
            super(ActionType.REPORT_MSG);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
        }

        public final MsgInfo getMsg() {
            return this.msg;
        }

        @Override // com.tencent.state.publicchat.component.PublicChatExtraActionMenuComponent.ActionItem
        public String getTitle(ISquareBaseMessageService aioService) {
            return "\u4e3e\u62a5";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ShieldUserActionItem;", "Lcom/tencent/state/publicchat/component/PublicChatExtraActionMenuComponent$ActionItem;", "uin", "", "(Ljava/lang/String;)V", "getUin", "()Ljava/lang/String;", "getTitle", "aioService", "Lcom/tencent/state/square/api/ISquareBaseMessageService;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class ShieldUserActionItem extends ActionItem {
        private final String uin;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShieldUserActionItem(String uin) {
            super(ActionType.SHIELD_USER);
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.uin = uin;
        }

        @Override // com.tencent.state.publicchat.component.PublicChatExtraActionMenuComponent.ActionItem
        public String getTitle(ISquareBaseMessageService aioService) {
            return "\u5c4f\u853d";
        }

        public final String getUin() {
            return this.uin;
        }
    }

    private final void openExtraMenu(String uin, MsgInfo msg2) {
        Context context;
        ArrayList arrayList = new ArrayList();
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        if (msg2 != null) {
            arrayList.add(new ReportMsgActionItem(msg2));
        }
        ISquareBaseMessageService iSquareBaseMessageService = this.aioService;
        if (iSquareBaseMessageService == null || !iSquareBaseMessageService.isFriend(uin)) {
            arrayList.add(new ShieldUserActionItem(uin));
        }
        showMenu(context, arrayList);
    }

    private final void showMenu(Context context, final List<? extends ActionItem> actions) {
        final BottomActionSheet bottomActionSheet = new BottomActionSheet(context);
        int i3 = 0;
        for (Object obj : actions) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            bottomActionSheet.addActionSheet(i3, ((ActionItem) obj).getTitle(this.aioService));
            i3 = i16;
        }
        bottomActionSheet.setItemClickListener(new Function2<Integer, View, Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatExtraActionMenuComponent$showMenu$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
            
                r5 = r3.this$0.aioService;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(int i17, View view) {
                Object orNull;
                ISquareBaseMessageService iSquareBaseMessageService;
                VasBaseFragment fragment;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
                orNull = CollectionsKt___CollectionsKt.getOrNull(actions, i17);
                final PublicChatExtraActionMenuComponent.ActionItem actionItem = (PublicChatExtraActionMenuComponent.ActionItem) orNull;
                SquareBaseKt.getSquareLog().d("PublicChatExtraActionMenuComponent", "click " + actionItem);
                if (actionItem instanceof PublicChatExtraActionMenuComponent.ReportMsgActionItem) {
                    PublicChatExtraActionMenuComponent publicChatExtraActionMenuComponent = PublicChatExtraActionMenuComponent.this;
                    Function1<IPublicChatEventListener, Unit> function1 = new Function1<IPublicChatEventListener, Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatExtraActionMenuComponent$showMenu$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IPublicChatEventListener iPublicChatEventListener) {
                            invoke2(iPublicChatEventListener);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IPublicChatEventListener it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.onMsgAction(new ReportMsgAction(((PublicChatExtraActionMenuComponent.ReportMsgActionItem) PublicChatExtraActionMenuComponent.ActionItem.this).getMsg()));
                        }
                    };
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) publicChatExtraActionMenuComponent).fragment;
                    if (vasBaseFragment != null) {
                        WeakReference<VasBaseFragmentComponentGroup> parent = publicChatExtraActionMenuComponent.getParent();
                        vasBaseFragment.forEachComponent(IPublicChatEventListener.class, parent != null ? parent.get() : null, null, function1);
                    }
                } else if ((actionItem instanceof PublicChatExtraActionMenuComponent.ShieldUserActionItem) && iSquareBaseMessageService != null) {
                    fragment = PublicChatExtraActionMenuComponent.this.getFragment();
                    iSquareBaseMessageService.openSettingsPage(fragment, 0, ((PublicChatExtraActionMenuComponent.ShieldUserActionItem) actionItem).getUin(), MessageRecordType.RECORD_TYPE_SQUARE_TEMP);
                }
                bottomActionSheet.dismiss();
            }
        });
        bottomActionSheet.show();
    }

    @Override // com.tencent.state.publicchat.component.PublicChatBaseComponent, com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(f16, "f");
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(BasicServiceComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(BasicServiceComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, BasicServiceComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, BasicServiceComponent.class, null, null, 6, null) : null;
        }
        BasicServiceComponent basicServiceComponent = (BasicServiceComponent) component$default;
        this.aioService = basicServiceComponent != null ? basicServiceComponent.getMessageService() : null;
    }

    @Override // com.tencent.state.publicchat.component.PublicChatBaseComponent, com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onMsgAction(MsgAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof OpenExtraMenuAction) {
            OpenExtraMenuAction openExtraMenuAction = (OpenExtraMenuAction) action;
            openExtraMenu(openExtraMenuAction.getUin(), openExtraMenuAction.getMsg());
        }
    }
}
