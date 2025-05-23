package com.tencent.qqnt.aio.assistedchat.panel.setting;

import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "()V", "OnSetSettingSwitchSuccess", "ShowSwitchConfirmDialog", "UpdateItemUI", "UpdateSettingListUI", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$OnSetSettingSwitchSuccess;", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$ShowSwitchConfirmDialog;", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$UpdateItemUI;", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$UpdateSettingListUI;", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public abstract class AssistedChatPanelSettingUIState implements PanelUIState {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$OnSetSettingSwitchSuccess;", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "d", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "b", "()Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "", "e", "Z", "a", "()Z", "switchOn", "<init>", "(Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class OnSetSettingSwitchSuccess extends AssistedChatPanelSettingUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AssistedChatSwitchType switchType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean switchOn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSetSettingSwitchSuccess(@NotNull AssistedChatSwitchType switchType, boolean z16) {
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
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$ShowSwitchConfirmDialog;", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "d", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "b", "()Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "", "e", "Z", "a", "()Z", "switchOn", "<init>", "(Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class ShowSwitchConfirmDialog extends AssistedChatPanelSettingUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AssistedChatSwitchType switchType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean switchOn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSwitchConfirmDialog(@NotNull AssistedChatSwitchType switchType, boolean z16) {
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
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$UpdateItemUI;", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState;", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "d", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "b", "()Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "", "e", "Z", "a", "()Z", "switchOn", "<init>", "(Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;Z)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class UpdateItemUI extends AssistedChatPanelSettingUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AssistedChatSwitchType switchType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean switchOn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateItemUI(@NotNull AssistedChatSwitchType switchType, boolean z16) {
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
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState$UpdateSettingListUI;", "Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingUIState;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "<init>", "(Ljava/util/List;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class UpdateSettingListUI extends AssistedChatPanelSettingUIState {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.qqnt.aio.assistedchat.model.d> itemList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateSettingListUI(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.d> itemList) {
            super(null);
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemList);
            } else {
                this.itemList = itemList;
            }
        }

        @NotNull
        public final List<com.tencent.qqnt.aio.assistedchat.model.d> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.itemList;
        }
    }

    public /* synthetic */ AssistedChatPanelSettingUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    AssistedChatPanelSettingUIState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
