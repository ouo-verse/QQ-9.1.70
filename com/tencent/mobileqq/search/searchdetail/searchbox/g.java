package com.tencent.mobileqq.search.searchdetail.searchbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartSearchEvent;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent;
import com.tencent.mobileqq.widget.SoftKeyboardStateHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.KeyWordChangeEvent;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u001c\u0010\u001c\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 `!H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/searchbox/g;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "from", "", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onPartPause", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "action", "", "args", "handleBroadcastMessage", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent;", "d", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent;", "voiceSearchComponent", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "e", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "mKeyboardStateHelper", "<init>", "()V", "f", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g extends Part implements SoftKeyboardStateHelper.SoftKeyboardStateListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private VoiceSearchComponent voiceSearchComponent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SoftKeyboardStateHelper mKeyboardStateHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/search/searchdetail/searchbox/g$b", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$c;", "", "textContent", "", "isTextInputMode", "", "b", "", "getPageMode", "a", "", "", "getReportParams", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements VoiceSearchComponent.c {
        b() {
        }

        @Override // com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent.c
        @NotNull
        public String a() {
            return "";
        }

        @Override // com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent.c
        public void b(@NotNull String textContent, boolean isTextInputMode) {
            Intrinsics.checkNotNullParameter(textContent, "textContent");
            g.this.broadcastMessage("MESSAGE_UPDATETEXT", new KeyWordChangeEvent(textContent, 22, null, null, 12, null));
        }

        @Override // com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent.c
        public int getPageMode() {
            Object broadcastGetMessage = g.this.broadcastGetMessage("getPageMode", null);
            if (broadcastGetMessage != null) {
                return ((Integer) broadcastGetMessage).intValue();
            }
            return SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent.c
        @NotNull
        public Map<String, Object> getReportParams() {
            SearchDetailTabListViewModel.TabInfo tabInfo;
            Integer num;
            int i3;
            String str;
            long j3;
            Object obj;
            Object second;
            Pair pair = null;
            Object broadcastGetMessage = g.this.broadcastGetMessage("getTabInfo", null);
            if (broadcastGetMessage instanceof SearchDetailTabListViewModel.TabInfo) {
                tabInfo = (SearchDetailTabListViewModel.TabInfo) broadcastGetMessage;
            } else {
                tabInfo = null;
            }
            String str2 = "";
            Object broadcastGetMessage2 = g.this.broadcastGetMessage("getQuerySource", "");
            if (broadcastGetMessage2 instanceof Integer) {
                num = (Integer) broadcastGetMessage2;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            Object broadcastGetMessage3 = g.this.broadcastGetMessage("getQueryInfo", null);
            if (broadcastGetMessage3 instanceof Pair) {
                pair = (Pair) broadcastGetMessage3;
            }
            HashMap hashMap = new HashMap();
            if (tabInfo == null || (str = tabInfo.getTabName()) == null) {
                str = "";
            }
            hashMap.put("tab_name", str);
            if (tabInfo != null) {
                j3 = tabInfo.getTabMask();
            } else {
                j3 = 0;
            }
            hashMap.put("tab_mask", Long.valueOf(j3));
            hashMap.put("query_source", Integer.valueOf(i3));
            if (pair == null || (obj = pair.getFirst()) == null) {
                obj = "";
            }
            hashMap.put("search_query_text", obj);
            if (pair != null && (second = pair.getSecond()) != 0) {
                str2 = second;
            }
            hashMap.put("search_trace_id", str2);
            return hashMap;
        }
    }

    private final void x9(String from, int querySource) {
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchAudioInputPart", 1, "changeToBigBarOrHide from=" + from + " showInputBar");
        VoiceSearchComponent voiceSearchComponent = this.voiceSearchComponent;
        if (voiceSearchComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceSearchComponent");
            voiceSearchComponent = null;
        }
        voiceSearchComponent.H(querySource);
    }

    static /* synthetic */ void z9(g gVar, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        gVar.x9(str, i3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(StartSearchEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e("QQSearch.NetDetail.SearchAudioInputPart", 1, "rootView is null");
            return;
        }
        View findViewById = rootView.findViewById(R.id.f1201178o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.voice_search_component)");
        VoiceSearchComponent voiceSearchComponent = (VoiceSearchComponent) findViewById;
        this.voiceSearchComponent = voiceSearchComponent;
        VoiceSearchComponent voiceSearchComponent2 = null;
        if (voiceSearchComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceSearchComponent");
            voiceSearchComponent = null;
        }
        voiceSearchComponent.setVisibility(0);
        VoiceSearchComponent voiceSearchComponent3 = this.voiceSearchComponent;
        if (voiceSearchComponent3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceSearchComponent");
            voiceSearchComponent3 = null;
        }
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        voiceSearchComponent3.F(hostFragment);
        VoiceSearchComponent voiceSearchComponent4 = this.voiceSearchComponent;
        if (voiceSearchComponent4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceSearchComponent");
        } else {
            voiceSearchComponent2 = voiceSearchComponent4;
        }
        voiceSearchComponent2.setViewListener(new b());
        if (this.mKeyboardStateHelper == null) {
            SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(rootView);
            softKeyboardStateHelper.addSoftKeyboardStateListener(this);
            this.mKeyboardStateHelper = softKeyboardStateHelper;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        VoiceSearchComponent voiceSearchComponent = this.voiceSearchComponent;
        if (voiceSearchComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceSearchComponent");
            voiceSearchComponent = null;
        }
        voiceSearchComponent.Z();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        SoftKeyboardStateHelper softKeyboardStateHelper = this.mKeyboardStateHelper;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.removeSoftKeyboardStateListener(this);
        }
        VoiceSearchComponent voiceSearchComponent = this.voiceSearchComponent;
        if (voiceSearchComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceSearchComponent");
            voiceSearchComponent = null;
        }
        voiceSearchComponent.a0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        SoftKeyboardStateHelper softKeyboardStateHelper = this.mKeyboardStateHelper;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.addSoftKeyboardStateListener(this);
        }
        VoiceSearchComponent voiceSearchComponent = this.voiceSearchComponent;
        if (voiceSearchComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("voiceSearchComponent");
            voiceSearchComponent = null;
        }
        voiceSearchComponent.b0();
        z9(this, "onPartResume", 0, 2, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof StartSearchEvent) {
            x9("startSearch", ((StartSearchEvent) event).getQuerySource());
        }
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardClosed() {
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchAudioInputPart", 1, "onSoftKeyboardClosed from SearchAudioInputPart");
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        Logger.f235387a.d().i("QQSearch.NetDetail.SearchAudioInputPart", 1, "onSoftKeyboardOpened from SearchAudioInputPart");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
    }
}
