package com.tencent.state.publicchat.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.event.Event;
import com.tencent.state.publicchat.IPublicChatUIOwner;
import com.tencent.state.publicchat.PublicChatViewSlots;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.SendTextMsgAction;
import com.tencent.state.publicchat.action.SendTextMsgSuccessAction;
import com.tencent.state.publicchat.action.ShowMsgPanelAction;
import com.tencent.state.publicchat.action.ShowUserPanelAction;
import com.tencent.state.publicchat.activity.MsgChangeEventData;
import com.tencent.state.publicchat.activity.PublicChatViewModel;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.service.SendMsgReq;
import com.tencent.state.publicchat.view.IMessageItemViewFactory;
import com.tencent.state.publicchat.view.MessageItemView;
import com.tencent.state.publicchat.view.MessageListView;
import com.tencent.state.publicchat.view.MessageNewButtonView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/publicchat/component/PublicChatUIComponent;", "Lcom/tencent/state/publicchat/component/PublicChatBaseComponent;", "owner", "Lcom/tencent/state/publicchat/IPublicChatUIOwner;", "(Lcom/tencent/state/publicchat/IPublicChatUIOwner;)V", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "msgListView", "Lcom/tencent/state/publicchat/view/MessageListView;", "msgNewBtnView", "Lcom/tencent/state/publicchat/view/MessageNewButtonView;", "pendingTask", "Lcom/tencent/state/publicchat/view/MessageListView$BroadcastTask;", "bind", "", "context", "Landroid/content/Context;", "fragment", "Lcom/tencent/state/VasBaseFragment;", "vm", "Lcom/tencent/state/publicchat/activity/PublicChatViewModel;", "binding", "Lcom/tencent/state/publicchat/PublicChatViewSlots;", "hideMsgListPanel", "markBroadcastAnimation", "pagUrl", "", "nickname", "onConfigLoaded", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "refreshThemeData", "setVisibility", "visibility", "", "showBroadcastAnimation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PublicChatUIComponent extends PublicChatBaseComponent {
    private static final String TAG = "PublicChatUIComponent";
    private PublicChatConfInfo conf;
    private MessageListView msgListView;
    private MessageNewButtonView msgNewBtnView;
    private final IPublicChatUIOwner owner;
    private MessageListView.BroadcastTask pendingTask;

    public PublicChatUIComponent(IPublicChatUIOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        Iterator<T> it = owner.getMsgItemViewFactories().iterator();
        while (it.hasNext()) {
            MessageItemView.INSTANCE.registerFactory((IMessageItemViewFactory) it.next());
        }
    }

    private final void markBroadcastAnimation(String pagUrl, String nickname) {
        this.pendingTask = new MessageListView.BroadcastTask(pagUrl, nickname);
    }

    public final void bind(Context context, VasBaseFragment fragment, PublicChatConfInfo conf, PublicChatViewModel vm5, final PublicChatViewSlots binding) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(binding, "binding");
        SquareBaseKt.getSquareLog().d(TAG, "bind isTopFragment=" + fragment.isTopFragment());
        setVisibility(fragment.isTopFragment());
        if (this.msgListView == null) {
            binding.getMsgListSlot().removeAllViews();
            final MessageListView messageListView = new MessageListView(context, this.owner, conf, new Function1<MsgAction, Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$bind$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MsgAction msgAction) {
                    invoke2(msgAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final MsgAction action) {
                    IPublicChatUIOwner iPublicChatUIOwner;
                    Intrinsics.checkNotNullParameter(action, "action");
                    PublicChatUIComponent publicChatUIComponent = PublicChatUIComponent.this;
                    Function1<IPublicChatEventListener, Unit> function1 = new Function1<IPublicChatEventListener, Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$bind$1.1
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
                            it.onMsgAction(MsgAction.this);
                        }
                    };
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) publicChatUIComponent).fragment;
                    if (vasBaseFragment != null) {
                        WeakReference<VasBaseFragmentComponentGroup> parent = publicChatUIComponent.getParent();
                        vasBaseFragment.forEachComponent(IPublicChatEventListener.class, parent != null ? parent.get() : null, null, function1);
                    }
                    iPublicChatUIOwner = PublicChatUIComponent.this.owner;
                    iPublicChatUIOwner.onMsgAction(action);
                }
            });
            this.msgListView = messageListView;
            binding.getMsgListSlot().addView(messageListView);
            ViewExtensionsKt.updateLayoutParams(messageListView, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$bind$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.gravity = 80;
                }
            });
            vm5.getMsgChangeEventBus().observe(fragment, new Observer<Event<MsgChangeEventData>>() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$bind$2$2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Event<MsgChangeEventData> event) {
                    MsgChangeEventData content = event.getContent();
                    if (content != null) {
                        SquareBaseKt.getSquareLog().d("PublicChatUIComponent", "\u6d88\u606f\u5217\u8868\u66f4\u65b0 " + content);
                        MessageListView.this.notifyItemsChanged(content);
                    }
                }
            });
            vm5.getUnReadMsgCount().observe(fragment, new Observer<Integer>() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$bind$2$3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Integer newMsgCount) {
                    SquareBaseKt.getSquareLog().d("PublicChatUIComponent", "\u672a\u8bfb\u6d88\u606f\u6570\u91cf " + newMsgCount);
                    if (newMsgCount.intValue() > 0) {
                        MessageListView messageListView2 = MessageListView.this;
                        Intrinsics.checkNotNullExpressionValue(newMsgCount, "newMsgCount");
                        messageListView2.showUnreadNumBtn(newMsgCount.intValue());
                        return;
                    }
                    MessageListView.this.hideUnreadNumBtn();
                }
            });
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$bind$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MessageListView.BroadcastTask broadcastTask;
                    broadcastTask = PublicChatUIComponent.this.pendingTask;
                    if (broadcastTask != null) {
                        PublicChatUIComponent.this.showBroadcastAnimation(broadcastTask.getPagUrl(), broadcastTask.getContent());
                    }
                    PublicChatUIComponent.this.pendingTask = null;
                }
            });
        }
        if (this.msgNewBtnView == null) {
            binding.getMsgNewBtnSlot().removeAllViews();
            final MessageNewButtonView messageNewButtonView = new MessageNewButtonView(context, binding.getMsgNewBtnConfig());
            this.msgNewBtnView = messageNewButtonView;
            messageNewButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$bind$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageListView messageListView2;
                    messageListView2 = this.msgListView;
                    if (messageListView2 != null) {
                        messageListView2.showMsgInputBox();
                    }
                    SquareBaseKt.getSquareReporter().reportEvent("clck", MessageNewButtonView.this, new LinkedHashMap());
                }
            });
            binding.getMsgNewBtnSlot().addView(messageNewButtonView);
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(this.owner.getAppId())));
            squareReporter.setElementInfo(messageNewButtonView, SquareReportConst.ElementId.ELEMENT_ID_CHAT_NEW_MSG_BTN, mutableMapOf, false, false);
            SquareBaseKt.getSquareReporter().reportEvent("imp", messageNewButtonView, new LinkedHashMap());
        }
    }

    public final void hideMsgListPanel() {
        MessageListView messageListView = this.msgListView;
        if (messageListView != null) {
            messageListView.hideMsgPanel();
        }
    }

    @Override // com.tencent.state.publicchat.component.PublicChatBaseComponent, com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onConfigLoaded(PublicChatConfInfo conf) {
        PublicChatViewSlots publicChatViewSlots;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        PublicChatViewModel vm5;
        Intrinsics.checkNotNullParameter(conf, "conf");
        this.conf = conf;
        if (!conf.getShow()) {
            setVisibility(false);
            return;
        }
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (publicChatViewSlots = this.owner.getPublicChatViewSlots()) == null) {
            return;
        }
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "f.requireContext()");
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PublicChatCommonComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(PublicChatCommonComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, PublicChatCommonComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, PublicChatCommonComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        PublicChatCommonComponent publicChatCommonComponent = (PublicChatCommonComponent) fragmentComponent;
        if (publicChatCommonComponent == null || (vm5 = publicChatCommonComponent.getVm()) == null) {
            return;
        }
        bind(requireContext, fragment, conf, vm5, publicChatViewSlots);
        MessageListView messageListView = this.msgListView;
        if (messageListView != null) {
            messageListView.expandMsgList();
        }
    }

    @Override // com.tencent.state.publicchat.component.PublicChatBaseComponent, com.tencent.state.publicchat.component.IPublicChatEventListener
    public void onMsgAction(final MsgAction action) {
        MessageListView messageListView;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        PublicChatViewModel vm5;
        SendMsgReq createTextMsg;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        Intrinsics.checkNotNullParameter(action, "action");
        SquareBaseKt.getSquareLog().d(TAG, "\u6536\u5230 MsgAction " + action.getClass().getSimpleName());
        if (action instanceof SendTextMsgAction) {
            boolean z16 = this instanceof VasBaseFragmentComponentGroup;
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(PublicChatCommonComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(PublicChatCommonComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, PublicChatCommonComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, PublicChatCommonComponent.class, null, null, 6, null) : null;
            }
            PublicChatCommonComponent publicChatCommonComponent = (PublicChatCommonComponent) component$default;
            if (publicChatCommonComponent == null || (vm5 = publicChatCommonComponent.getVm()) == null) {
                return;
            }
            IPublicChatUIOwner iPublicChatUIOwner = this.owner;
            Long l3 = vm5.get_channelId();
            if (l3 == null || (createTextMsg = iPublicChatUIOwner.createTextMsg(l3.longValue(), ((SendTextMsgAction) action).getMsgTxt())) == null) {
                return;
            }
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent = vasBaseFragmentComponentGroup4.getComponent(PublicChatMsgComponent.class, null)) == null) && ((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PublicChatMsgComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, PublicChatMsgComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment4 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, PublicChatMsgComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default2;
                }
                fragmentComponent = fragmentComponent2;
            }
            PublicChatMsgComponent publicChatMsgComponent = (PublicChatMsgComponent) fragmentComponent;
            if (publicChatMsgComponent != null) {
                publicChatMsgComponent.sendMsg(createTextMsg, new Function0<Unit>() { // from class: com.tencent.state.publicchat.component.PublicChatUIComponent$onMsgAction$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MessageListView messageListView2;
                        MessageListView messageListView3;
                        IPublicChatUIOwner iPublicChatUIOwner2;
                        messageListView2 = PublicChatUIComponent.this.msgListView;
                        if (messageListView2 != null) {
                            messageListView2.cleanMsgInputBox();
                        }
                        messageListView3 = PublicChatUIComponent.this.msgListView;
                        if (messageListView3 != null) {
                            messageListView3.enableAutoScroll(true);
                        }
                        iPublicChatUIOwner2 = PublicChatUIComponent.this.owner;
                        iPublicChatUIOwner2.onMsgAction(new SendTextMsgSuccessAction(((SendTextMsgAction) action).getMsgTxt()));
                    }
                });
                return;
            }
            return;
        }
        if (action instanceof ShowMsgPanelAction) {
            MessageListView messageListView2 = this.msgListView;
            if (messageListView2 != null) {
                ShowMsgPanelAction showMsgPanelAction = (ShowMsgPanelAction) action;
                messageListView2.showMsgPanel(showMsgPanelAction.getX(), showMsgPanelAction.getY(), showMsgPanelAction.getMsg(), this.owner.getAppId());
                return;
            }
            return;
        }
        if (!(action instanceof ShowUserPanelAction) || (messageListView = this.msgListView) == null) {
            return;
        }
        ShowUserPanelAction showUserPanelAction = (ShowUserPanelAction) action;
        messageListView.showUserPanel(showUserPanelAction.getX(), showUserPanelAction.getY(), showUserPanelAction.getMsg(), showUserPanelAction.getUser(), this.owner.getAppId());
    }

    public final void refreshThemeData() {
        MessageListView messageListView = this.msgListView;
        if (messageListView != null) {
            messageListView.refreshThemeData();
        }
    }

    public final void setVisibility(boolean visibility) {
        PublicChatConfInfo publicChatConfInfo = this.conf;
        if (publicChatConfInfo == null || !publicChatConfInfo.getShow()) {
            visibility = false;
        }
        PublicChatViewSlots publicChatViewSlots = this.owner.getPublicChatViewSlots();
        if (publicChatViewSlots != null) {
            ViewExtensionsKt.setVisibility(publicChatViewSlots.getMsgListSlot(), visibility);
            ViewExtensionsKt.setVisibility(publicChatViewSlots.getMsgNewBtnSlot(), visibility);
        }
    }

    public final void showBroadcastAnimation(String pagUrl, String nickname) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return;
        }
        if (pagUrl.length() == 0) {
            return;
        }
        if (this.msgListView == null) {
            markBroadcastAnimation(pagUrl, nickname);
            return;
        }
        String str = nickname + " \u8fdb\u5165\u5730\u5757";
        if (nickname.length() > 5) {
            StringBuilder sb5 = new StringBuilder();
            String substring = nickname.substring(0, 5);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            sb5.append("...\u8fdb\u5165\u5730\u5757");
            str = sb5.toString();
        }
        MessageListView messageListView = this.msgListView;
        if (messageListView != null) {
            messageListView.appendBroadcastPAGTask(pagUrl, str);
        }
    }
}
