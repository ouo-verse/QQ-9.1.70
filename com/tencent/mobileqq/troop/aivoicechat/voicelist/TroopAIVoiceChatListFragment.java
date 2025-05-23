package com.tencent.mobileqq.troop.aivoicechat.voicelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.config.TroopAIVoiceChatListConfig;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.event.TroopAIVoiceChatListRefreshSelectVoice;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.event.TroopAIVoiceChatListSelectVoice;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R,\u00108\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u0003040\u0019j\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304`58\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/TroopAIVoiceChatListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/event/TroopAIVoiceChatListRefreshSelectVoice;", "", "uh", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", DownloadInfo.spKey_Config, "", "isSelected", "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "sh", "()Ljava/lang/String;", "tabName", "Ljava/io/Serializable;", "D", "th", "()Ljava/io/Serializable;", "voiceList", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "E", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "selectedVoice", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "configList", "<init>", "()V", "I", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatListFragment extends QPublicBaseFragment implements SimpleEventReceiver<TroopAIVoiceChatListRefreshSelectVoice> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy tabName;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy voiceList;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISettingsRecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: G, reason: from kotlin metadata */
    private VoiceItem selectedVoice;

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    public TroopAIVoiceChatListFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.TroopAIVoiceChatListFragment$tabName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = TroopAIVoiceChatListFragment.this.requireArguments().getString("tabName");
                return string == null ? "" : string;
            }
        });
        this.tabName = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Serializable>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.TroopAIVoiceChatListFragment$voiceList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Serializable invoke() {
                Serializable serializable = TroopAIVoiceChatListFragment.this.requireArguments().getSerializable("voiceList");
                return serializable == null ? new ArrayList() : serializable;
            }
        });
        this.voiceList = lazy2;
        this.configList = new ArrayList<>();
    }

    private final String sh() {
        return (String) this.tabName.getValue();
    }

    private final Serializable th() {
        return (Serializable) this.voiceList.getValue();
    }

    private final void uh() {
        String str;
        Serializable th5 = th();
        Intrinsics.checkNotNull(th5, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
        if (((ArrayList) th5).isEmpty()) {
            QLog.e("TroopAIVoiceChatListFragment", 1, "no voiceInfo");
            return;
        }
        Serializable th6 = th();
        Intrinsics.checkNotNull(th6, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
        for (Object obj : (ArrayList) th6) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.VoiceItem");
            VoiceItem voiceItem = (VoiceItem) obj;
            VoiceItem voiceItem2 = this.selectedVoice;
            if (voiceItem2 != null) {
                Intrinsics.checkNotNull(voiceItem2);
                str = voiceItem2.voiceId;
            } else {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (selectedVoice != nul\u2026edVoice!!.voiceId else \"\"");
            final TroopAIVoiceChatListConfig troopAIVoiceChatListConfig = new TroopAIVoiceChatListConfig(voiceItem, str);
            troopAIVoiceChatListConfig.O().e(new h() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.d
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    TroopAIVoiceChatListFragment.vh(TroopAIVoiceChatListFragment.this, troopAIVoiceChatListConfig, view, z16);
                }
            });
            this.configList.add(troopAIVoiceChatListConfig);
        }
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter = null;
        }
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        qUIListItemAdapter.t0(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(TroopAIVoiceChatListFragment this$0, TroopAIVoiceChatListConfig config, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.xh(config, z16);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        VoiceItem voiceItem = this$0.selectedVoice;
        Intrinsics.checkNotNull(voiceItem);
        String str = voiceItem.voiceId;
        Intrinsics.checkNotNullExpressionValue(str, "selectedVoice!!.voiceId");
        linkedHashMap.put("timbre_id", str);
        if (!Intrinsics.areEqual(this$0.sh(), "")) {
            String tabName = this$0.sh();
            Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
            linkedHashMap.put("tab_name", tabName);
        }
        VideoReport.setElementId(view, "em_group_voice_unit");
        VideoReport.setElementParams(view, linkedHashMap);
        VideoReport.reportEvent("clck", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(TroopAIVoiceChatListFragment this$0, SimpleBaseEvent simpleBaseEvent, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.xh(((TroopAIVoiceChatListRefreshSelectVoice) simpleBaseEvent).getOldConfig(), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(TroopAIVoiceChatListFragment this$0, TroopAIVoiceChatListConfig config, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        this$0.xh(config, z16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f127091, container, false);
        View findViewById = inflate.findViewById(R.id.f17329);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) findViewById;
        qUISettingsRecyclerView.setLayoutManager(new LinearLayoutManager(qUISettingsRecyclerView.getContext()));
        qUISettingsRecyclerView.setOverScrollMode(2);
        QUIListItemAdapter qUIListItemAdapter = null;
        qUISettingsRecyclerView.setItemAnimator(null);
        qUISettingsRecyclerView.setDividerStyle(QUISettingsRecyclerView.DividerStyle.Hidden);
        qUISettingsRecyclerView.setHasTopSpace(false);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<QUISet\u2026TopSpace(false)\n        }");
        this.recyclerView = qUISettingsRecyclerView;
        this.adapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth, false, false, 6, null);
        QUISettingsRecyclerView qUISettingsRecyclerView2 = this.recyclerView;
        if (qUISettingsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            qUISettingsRecyclerView2 = null;
        }
        QUIListItemAdapter qUIListItemAdapter2 = this.adapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter2;
        }
        qUISettingsRecyclerView2.setAdapter(qUIListItemAdapter);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof TroopAIVoiceChatListRefreshSelectVoice) {
            TroopAIVoiceChatListRefreshSelectVoice troopAIVoiceChatListRefreshSelectVoice = (TroopAIVoiceChatListRefreshSelectVoice) event;
            troopAIVoiceChatListRefreshSelectVoice.getOldConfig().O().e(new h() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.c
                @Override // com.tencent.mobileqq.widget.listitem.h
                public final void a(View view, boolean z16) {
                    TroopAIVoiceChatListFragment.wh(TroopAIVoiceChatListFragment.this, event, view, z16);
                }
            });
            QUIListItemAdapter qUIListItemAdapter = this.adapter;
            if (qUIListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                qUIListItemAdapter = null;
            }
            qUIListItemAdapter.l0(troopAIVoiceChatListRefreshSelectVoice.getOldConfig());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        uh();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<TroopAIVoiceChatListRefreshSelectVoice>> getEventClass() {
        ArrayList<Class<TroopAIVoiceChatListRefreshSelectVoice>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopAIVoiceChatListRefreshSelectVoice.class);
        return arrayListOf;
    }

    private final void xh(final TroopAIVoiceChatListConfig config, boolean isSelected) {
        if (isSelected) {
            config.b0(getContext());
            this.selectedVoice = config.getVoiceItemInfo();
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String tabName = sh();
            Intrinsics.checkNotNullExpressionValue(tabName, "tabName");
            simpleEventBus.dispatchEvent(new TroopAIVoiceChatListSelectVoice(tabName, config.getVoiceItemInfo(), config));
            return;
        }
        config.b0(getContext());
        QUIListItemAdapter qUIListItemAdapter = null;
        config.O().e(null);
        config.O().f(true);
        config.O().e(new h() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.e
            @Override // com.tencent.mobileqq.widget.listitem.h
            public final void a(View view, boolean z16) {
                TroopAIVoiceChatListFragment.yh(TroopAIVoiceChatListFragment.this, config, view, z16);
            }
        });
        QUIListItemAdapter qUIListItemAdapter2 = this.adapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter2;
        }
        qUIListItemAdapter.l0(config);
    }
}
