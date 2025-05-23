package com.tencent.mobileqq.guild.discoveryv2.parts.tabs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class TabsViewModel$ensureSubViewModel$subViewModel$1 extends Lambda implements Function0<TabViewModel> {
    final /* synthetic */ int $tabId;
    final /* synthetic */ String $tabName;
    final /* synthetic */ int $tabType;
    final /* synthetic */ TabsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsViewModel$ensureSubViewModel$subViewModel$1(String str, int i3, int i16, TabsViewModel tabsViewModel) {
        super(0);
        this.$tabName = str;
        this.$tabId = i3;
        this.$tabType = i16;
        this.this$0 = tabsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final TabViewModel invoke() {
        MediatorLiveData mediatorLiveData;
        TabViewModel tabViewModel = new TabViewModel(this.$tabName, this.$tabId, this.$tabType);
        final TabsViewModel tabsViewModel = this.this$0;
        final int i3 = this.$tabId;
        final int i16 = this.$tabType;
        mediatorLiveData = tabsViewModel._liveTabList;
        LiveData<List<IGProNavigationTab>> U1 = tabViewModel.U1();
        final Function1<List<? extends IGProNavigationTab>, Unit> function1 = new Function1<List<? extends IGProNavigationTab>, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel$ensureSubViewModel$subViewModel$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends IGProNavigationTab> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends IGProNavigationTab> tabs) {
                MediatorLiveData mediatorLiveData2;
                MediatorLiveData mediatorLiveData3;
                MediatorLiveData mediatorLiveData4;
                if (tabs.isEmpty()) {
                    mediatorLiveData3 = TabsViewModel.this._liveTabList;
                    Collection collection = (Collection) mediatorLiveData3.getValue();
                    if (collection == null || collection.isEmpty()) {
                        Logger logger = Logger.f235387a;
                        int i17 = i3;
                        int i18 = i16;
                        Logger.b bVar = new Logger.b();
                        String str = "loadSubTabData: tabId=" + i17 + ", tabType=" + i18 + ", tabs.isEmpty(), use placeHolderTabs";
                        if (str instanceof String) {
                            bVar.a().add(str);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("SubTabViewModel", 1, (String) it.next(), null);
                        }
                        mediatorLiveData4 = TabsViewModel.this._liveTabList;
                        mediatorLiveData4.setValue(TabViewModel.INSTANCE.a());
                        return;
                    }
                    return;
                }
                TabsViewModel tabsViewModel2 = TabsViewModel.this;
                Intrinsics.checkNotNullExpressionValue(tabs, "tabs");
                tabsViewModel2.X1(tabs);
                mediatorLiveData2 = TabsViewModel.this._liveTabList;
                mediatorLiveData2.setValue(tabs);
            }
        };
        mediatorLiveData.addSource(U1, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabsViewModel$ensureSubViewModel$subViewModel$1.b(Function1.this, obj);
            }
        });
        return tabViewModel;
    }
}
