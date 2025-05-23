package com.tencent.qqnt.aio.assistedchat.panel.setting;

import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelContainerMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingUIState;
import com.tencent.qqnt.aio.assistedchat.panel.setting.b;
import com.tencent.qqnt.aio.assistedchat.reply_suggestion.ReplySuggestionFrequencyHelper;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "", "r", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", VideoTemplateParser.ITEM_LIST, DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitchType;", "switchType", "", "switchOn", "u", "t", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "o", "()I", "chatType", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatSwitchAdapterApi;", "p", "()Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatSwitchAdapterApi;", "switchAdapterApi", "<init>", "()V", "e", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPanelSettingVM extends com.tencent.qqnt.aio.baseVM.a<at.c, PanelUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingVM$a;", "", "", "KEY_NEED_SHOW_CONFIRM_DIALOG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingVM$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59517);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatPanelSettingVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(List<com.tencent.qqnt.aio.assistedchat.model.d> itemList) {
        if (p().isSwitchOn(new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, 0))) {
            return;
        }
        for (com.tencent.qqnt.aio.assistedchat.model.d dVar : itemList) {
            if (dVar.a().b() == AssistedChatSwitchType.REPLY_SUGGESTION) {
                dVar.d(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int o() {
        AIOSession r16;
        AIOContact c16;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            return c16.e();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAssistedChatSwitchAdapterApi p() {
        return (IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AssistedChatPanelContainerMsgIntent.HideSettingPanel.f349127d);
    }

    private final void s() {
        List<AssistedChatSwitch> mutableListOf;
        int collectionSizeOrDefault;
        String str;
        boolean z16;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new AssistedChatSwitch(AssistedChatSwitchType.AUTO_POLISH, o()), new AssistedChatSwitch(AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND, o()));
        if (((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isReplySuggestionExperiment(o())) {
            mutableListOf.add(new AssistedChatSwitch(AssistedChatSwitchType.REPLY_SUGGESTION, o()));
        }
        List<AssistedChatSwitch> list = mutableListOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (AssistedChatSwitch assistedChatSwitch : list) {
            int switchValue = p().getSwitchValue(assistedChatSwitch);
            if (switchValue != 1 && (switchValue != 0 || !assistedChatSwitch.b().getDefValue())) {
                z16 = false;
            } else {
                z16 = true;
            }
            arrayList.add(new com.tencent.qqnt.aio.assistedchat.model.d(assistedChatSwitch, z16, switchValue));
        }
        n(arrayList);
        updateUI(new AssistedChatPanelSettingUIState.UpdateSettingListUI(arrayList));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        p().reqGetSwitch(str, mutableListOf, new Function1<List<? extends com.tencent.qqnt.aio.assistedchat.model.d>, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingVM$loadSettingSwitch$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatPanelSettingVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.qqnt.aio.assistedchat.model.d> list2) {
                invoke2((List<com.tencent.qqnt.aio.assistedchat.model.d>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.d> itemList) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemList);
                    return;
                }
                Intrinsics.checkNotNullParameter(itemList, "itemList");
                if (itemList.isEmpty()) {
                    return;
                }
                AssistedChatPanelSettingVM.this.n(itemList);
                AssistedChatPanelSettingVM assistedChatPanelSettingVM = AssistedChatPanelSettingVM.this;
                for (com.tencent.qqnt.aio.assistedchat.model.d dVar : itemList) {
                    assistedChatPanelSettingVM.updateUI(new AssistedChatPanelSettingUIState.UpdateItemUI(dVar.a().b(), dVar.b()));
                }
            }
        });
    }

    private final void t() {
        new ReplySuggestionFrequencyHelper(o(), "", com.tencent.qqnt.aio.assistedchat.config.a.INSTANCE.a().f()).l();
    }

    private final void u(final AssistedChatSwitchType switchType, boolean switchOn) {
        int i3;
        List<AssistedChatSwitch> listOf;
        String str;
        List listOf2;
        final AssistedChatSwitch assistedChatSwitch = new AssistedChatSwitch(switchType, o());
        if (switchOn) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (switchType == AssistedChatSwitchType.AI_SERVICE) {
            IAssistedChatSwitchAdapterApi p16 = p();
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(assistedChatSwitch);
            IAssistedChatSwitchAdapterApi.a.a(p16, listOf2, i3, null, 4, null);
            return;
        }
        if (!switchOn) {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String str2 = "assisted_chat_need_show_confirm_dialog_" + str + "_" + o() + "_" + switchType.name();
            if (fromV2.getBoolean(str2, true)) {
                updateUI(new AssistedChatPanelSettingUIState.UpdateItemUI(switchType, true));
                updateUI(new AssistedChatPanelSettingUIState.ShowSwitchConfirmDialog(switchType, false));
                fromV2.putBoolean(str2, false);
                return;
            }
            t();
        }
        IAssistedChatSwitchAdapterApi p17 = p();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(assistedChatSwitch);
        p17.reqSetSwitch(listOf, i3, new Function1<Boolean, Unit>(assistedChatSwitch, switchType) { // from class: com.tencent.qqnt.aio.assistedchat.panel.setting.AssistedChatPanelSettingVM$setSettingSwitch$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AssistedChatSwitch $switch;
            final /* synthetic */ AssistedChatSwitchType $switchType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$switch = assistedChatSwitch;
                this.$switchType = switchType;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AssistedChatPanelSettingVM.this, assistedChatSwitch, switchType);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IAssistedChatSwitchAdapterApi p18;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                } else {
                    if (z16) {
                        return;
                    }
                    p18 = AssistedChatPanelSettingVM.this.p();
                    AssistedChatPanelSettingVM.this.updateUI(new AssistedChatPanelSettingUIState.UpdateItemUI(this.$switchType, p18.isSwitchOn(this.$switch)));
                }
            }
        });
        updateUI(new AssistedChatPanelSettingUIState.OnSetSettingSwitchSuccess(switchType, switchOn));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull at.c intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            r();
            return;
        }
        if (intent instanceof b.C9457b) {
            s();
        } else if (intent instanceof b.c) {
            b.c cVar = (b.c) intent;
            u(cVar.b(), cVar.a());
        }
    }
}
