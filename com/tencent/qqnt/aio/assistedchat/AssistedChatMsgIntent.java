package com.tencent.qqnt.aio.assistedchat;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "GetAndRemoveShowPanelParamIntent", "GetCanShowPrologueMsgIntent", "GetPrologueStatusIntent", "HideReplySuggestionSwitchTailIntent", "OnAutoPolishTriggerUpperLimit", "OnLoadFirstScreenMsg", "OnPanelRecommendItemClick", "OnRecommendMsgChangeForC2CIntent", "OnReplySuggestionTailClick", "OnReplySuggestionTailShow", "OnSettingSwitchChanged", "PrologueMsgVisibilityChange", "PrologueStatusChange", "ShowAssistedChatPanelIntent", "ShowReplySuggestionSwitchTailIntent", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$GetAndRemoveShowPanelParamIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$GetCanShowPrologueMsgIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$GetPrologueStatusIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$HideReplySuggestionSwitchTailIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnAutoPolishTriggerUpperLimit;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnLoadFirstScreenMsg;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnPanelRecommendItemClick;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnRecommendMsgChangeForC2CIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnReplySuggestionTailClick;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnReplySuggestionTailShow;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnSettingSwitchChanged;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$PrologueMsgVisibilityChange;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$PrologueStatusChange;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$ShowAssistedChatPanelIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$ShowReplySuggestionSwitchTailIntent;", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class AssistedChatMsgIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$GetAndRemoveShowPanelParamIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class GetAndRemoveShowPanelParamIntent extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetAndRemoveShowPanelParamIntent f348979d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50859);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348979d = new GetAndRemoveShowPanelParamIntent();
            }
        }

        GetAndRemoveShowPanelParamIntent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.GetAndRemoveShowPanelParamIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$GetCanShowPrologueMsgIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class GetCanShowPrologueMsgIntent extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetCanShowPrologueMsgIntent f348980d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50862);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348980d = new GetCanShowPrologueMsgIntent();
            }
        }

        GetCanShowPrologueMsgIntent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.GetCanShowPrologueMsgIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$GetPrologueStatusIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class GetPrologueStatusIntent extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetPrologueStatusIntent f348981d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50875);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348981d = new GetPrologueStatusIntent();
            }
        }

        GetPrologueStatusIntent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.GetPrologueStatusIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$HideReplySuggestionSwitchTailIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class HideReplySuggestionSwitchTailIntent extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final HideReplySuggestionSwitchTailIntent f348982d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50890);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348982d = new HideReplySuggestionSwitchTailIntent();
            }
        }

        HideReplySuggestionSwitchTailIntent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.HideReplySuggestionSwitchTailIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnAutoPolishTriggerUpperLimit;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class OnAutoPolishTriggerUpperLimit extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnAutoPolishTriggerUpperLimit f348983d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50891);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348983d = new OnAutoPolishTriggerUpperLimit();
            }
        }

        OnAutoPolishTriggerUpperLimit() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnAutoPolishTriggerUpperLimit";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnLoadFirstScreenMsg;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class OnLoadFirstScreenMsg extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnLoadFirstScreenMsg f348984d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50894);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348984d = new OnLoadFirstScreenMsg();
            }
        }

        OnLoadFirstScreenMsg() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnLoadFirstScreenMsg";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnPanelRecommendItemClick;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "", "d", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class OnPanelRecommendItemClick extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPanelRecommendItemClick(@NotNull String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) text);
            } else {
                this.text = text;
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnPanelRecommendItemClick";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnRecommendMsgChangeForC2CIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "", "d", "Z", "getHasRecommendMsg", "()Z", "hasRecommendMsg", "<init>", "(Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class OnRecommendMsgChangeForC2CIntent extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean hasRecommendMsg;

        public OnRecommendMsgChangeForC2CIntent(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.hasRecommendMsg = z16;
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnRecommendMsgChangeForC2CIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnReplySuggestionTailClick;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class OnReplySuggestionTailClick extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnReplySuggestionTailClick f348987d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50899);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348987d = new OnReplySuggestionTailClick();
            }
        }

        OnReplySuggestionTailClick() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnReplySuggestionTailClick";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnReplySuggestionTailShow;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "Landroid/view/View;", "d", "Landroid/view/View;", "a", "()Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class OnReplySuggestionTailShow extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View itemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnReplySuggestionTailShow(@NotNull View itemView) {
            super(null);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            } else {
                this.itemView = itemView;
            }
        }

        @NotNull
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.itemView;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnReplySuggestionTailShow";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnSettingSwitchChanged;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "d", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "b", "()Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "", "e", "Z", "a", "()Z", "switchOn", "<init>", "(Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class OnSettingSwitchChanged extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AssistedChatSwitchType switchType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean switchOn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSettingSwitchChanged(@NotNull AssistedChatSwitchType switchType, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(switchType, "switchType");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, switchType, Boolean.valueOf(z16));
            } else {
                this.switchType = switchType;
                this.switchOn = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.switchOn;
        }

        @NotNull
        public final AssistedChatSwitchType b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AssistedChatSwitchType) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.switchType;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnSettingSwitchChanged";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$PrologueMsgVisibilityChange;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "", "d", "Z", "a", "()Z", "isVisible", "<init>", "(Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class PrologueMsgVisibilityChange extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isVisible;

        public PrologueMsgVisibilityChange(boolean z16) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.isVisible = z16;
            }
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isVisible;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.PrologueMsgVisibilityChange";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$PrologueStatusChange;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "", "d", "Z", "b", "()Z", "isPrologue", "", "e", "I", "a", "()I", "emojiId", "<init>", "(ZI)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class PrologueStatusChange extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isPrologue;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int emojiId;

        public PrologueStatusChange(boolean z16, int i3) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else {
                this.isPrologue = z16;
                this.emojiId = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.emojiId;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isPrologue;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.PrologueStatusChange";
        }

        public /* synthetic */ PrologueStatusChange(boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i16 & 2) != 0 ? -1 : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$ShowAssistedChatPanelIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "source", "", "e", "I", "b", "()I", "subPanelId", "<init>", "(Ljava/lang/String;I)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class ShowAssistedChatPanelIntent extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int subPanelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowAssistedChatPanelIntent(@NotNull String source, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) source, i3);
            } else {
                this.source = source;
                this.subPanelId = i3;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.source;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.subPanelId;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.ShowAssistedChatPanelIntent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$ShowReplySuggestionSwitchTailIntent;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class ShowReplySuggestionSwitchTailIntent extends AssistedChatMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowReplySuggestionSwitchTailIntent f348996d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50912);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348996d = new ShowReplySuggestionSwitchTailIntent();
            }
        }

        ShowReplySuggestionSwitchTailIntent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.ShowReplySuggestionSwitchTailIntent";
        }
    }

    public /* synthetic */ AssistedChatMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    AssistedChatMsgIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
