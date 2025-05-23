package com.tencent.mobileqq.troop.homework.clockin.template.vm;

import android.os.Bundle;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.list.event.HWClockInListUpdateEvent;
import com.tencent.mobileqq.troop.homework.clockin.template.model.HWClockInTemplateRepo;
import com.tencent.mobileqq.troop.homework.clockin.template.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.template.vm.b;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0003H\u0017J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0014J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0012H\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020$0\u0012j\b\u0012\u0004\u0012\u00020$`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/template/vm/HWClockInTemplateViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/homework/clockin/template/vm/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/template/vm/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", FeedManager.LOAD_MORE, "", "R1", "hasMore", "S1", "T1", "userIntent", "Q1", "event", "onReceiveEvent", "onCleared", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "P1", "()Ljava/lang/String;", "troopUin", "D", "Lcom/tencent/mobileqq/troop/homework/clockin/template/vm/b;", "O1", "()Lcom/tencent/mobileqq/troop/homework/clockin/template/vm/b;", "mNoneValueIntent", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/HWClockInTemplateRepo;", "E", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/HWClockInTemplateRepo;", "repo", "Lcom/tencent/mobileqq/troop/homework/clockin/template/model/a;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "templateList", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInTemplateViewModel extends BaseViewModel<com.tencent.mobileqq.troop.homework.clockin.template.vm.a, b> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HWClockInTemplateRepo repo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.troop.homework.clockin.template.model.a> templateList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/template/vm/HWClockInTemplateViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44836);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            G = new a(null);
        }
    }

    public HWClockInTemplateViewModel(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWClockInArgKey.TROOP_UIN, \"\")");
        this.troopUin = string;
        this.mNoneValueIntent = b.c.f296590a;
        this.repo = new HWClockInTemplateRepo();
        this.templateList = new ArrayList<>();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @ExperimentalCoroutinesApi
    private final void R1(boolean loadMore) {
        FlowKt.launchIn(FlowKt.m2026catch(FlowKt.onCompletion(FlowKt.onEach(this.repo.h(loadMore), new HWClockInTemplateViewModel$loadData$1(this, loadMore, null)), new HWClockInTemplateViewModel$loadData$2(null)), new HWClockInTemplateViewModel$loadData$3(null)), ViewModelKt.getViewModelScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(boolean hasMore) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.templateList);
        getMUiState().setValue(new a.c(arrayList, hasMore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        getMUiState().setValue(a.b.f296585a);
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @NotNull
    public final String P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @ExperimentalCoroutinesApi
    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (Intrinsics.areEqual(userIntent, b.a.f296588a)) {
            R1(false);
        } else if (Intrinsics.areEqual(userIntent, b.C8723b.f296589a)) {
            R1(true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWClockInListUpdateEvent.ClockInPublished.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        JobKt__JobKt.cancelChildren$default(ViewModelKt.getViewModelScope(this).getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope(this), null, 1, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else if (event instanceof HWClockInListUpdateEvent.ClockInPublished) {
            getMUiState().postValue(a.C8722a.f296584a);
        }
    }
}
