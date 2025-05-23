package com.tencent.qqnt.aio.assistedchat.panel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetCurrentSubPanelIdMsgIntent", "GetShowPanelParamMsgIntent", "HideSettingPanel", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent$GetCurrentSubPanelIdMsgIntent;", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent$GetShowPanelParamMsgIntent;", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent$HideSettingPanel;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public abstract class AssistedChatPanelContainerMsgIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent$GetCurrentSubPanelIdMsgIntent;", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent;", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class GetCurrentSubPanelIdMsgIntent extends AssistedChatPanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetCurrentSubPanelIdMsgIntent f349125d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58773);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349125d = new GetCurrentSubPanelIdMsgIntent();
            }
        }

        GetCurrentSubPanelIdMsgIntent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent$GetShowPanelParamMsgIntent;", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent;", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class GetShowPanelParamMsgIntent extends AssistedChatPanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetShowPanelParamMsgIntent f349126d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58782);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349126d = new GetShowPanelParamMsgIntent();
            }
        }

        GetShowPanelParamMsgIntent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent$HideSettingPanel;", "Lcom/tencent/qqnt/aio/assistedchat/panel/AssistedChatPanelContainerMsgIntent;", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class HideSettingPanel extends AssistedChatPanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideSettingPanel f349127d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58789);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f349127d = new HideSettingPanel();
            }
        }

        HideSettingPanel() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public /* synthetic */ AssistedChatPanelContainerMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    AssistedChatPanelContainerMsgIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
