package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.g;
import com.tencent.mobileqq.activity.contact.addcontact.gridentrance.h;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b>\u0010?J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rR0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020#0'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020#0'8\u0006\u00a2\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R\u0017\u00107\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010=\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactViewModelV2;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "Z1", "Q1", "", "id", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "", "needRequest", "O1", "", "<set-?>", "i", "Ljava/util/List;", "R1", "()Ljava/util/List;", "entranceList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_uiState", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "uiState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/c;", "D", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_groupJoinedEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "E", "Lkotlinx/coroutines/flow/SharedFlow;", "S1", "()Lkotlinx/coroutines/flow/SharedFlow;", "groupJoinedEvent", UserInfo.SEX_FEMALE, "_guildJoinedEvent", "G", "U1", "guildJoinedEvent", "Lcom/tencent/mobileqq/troop/api/observer/b;", "H", "Lcom/tencent/mobileqq/troop/api/observer/b;", "W1", "()Lcom/tencent/mobileqq/troop/api/observer/b;", "troopMngObserver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "I", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "T1", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "guildDataObserver", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactViewModelV2 extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> uiState;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<c> _groupJoinedEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<c> groupJoinedEvent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableSharedFlow<c> _guildJoinedEvent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<c> guildJoinedEvent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.api.observer.b troopMngObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver guildDataObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> entranceList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _uiState;

    public AddContactViewModelV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.entranceList = h.f181167a.b();
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>();
        this._uiState = mutableLiveData;
        this.uiState = mutableLiveData;
        MutableSharedFlow<c> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._groupJoinedEvent = MutableSharedFlow$default;
        this.groupJoinedEvent = MutableSharedFlow$default;
        MutableSharedFlow<c> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._guildJoinedEvent = MutableSharedFlow$default2;
        this.guildJoinedEvent = MutableSharedFlow$default2;
        this.troopMngObserver = new com.tencent.mobileqq.troop.api.observer.b() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2$troopMngObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactViewModelV2.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.troop.api.observer.b
            public void l(int reqtype, int result, @NotNull String troopUin) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(reqtype), Integer.valueOf(result), troopUin);
                    return;
                }
                Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                if (1 == reqtype) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(AddContactViewModelV2.this), null, null, new AddContactViewModelV2$troopMngObserver$1$onTroopManagerSuccess$1(result, AddContactViewModelV2.this, troopUin, null), 3, null);
                }
            }
        };
        this.guildDataObserver = new GPServiceObserver() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2$guildDataObserver$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
            public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
                if (info != null && info.getUserType() == 0) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(AddContactViewModelV2.this), null, null, new AddContactViewModelV2$guildDataObserver$1$onAddGuildWithInfo$1(AddContactViewModelV2.this, info, null), 3, null);
                }
            }
        };
    }

    public static /* synthetic */ void P1(AddContactViewModelV2 addContactViewModelV2, String str, AddContactDataType addContactDataType, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        addContactViewModelV2.O1(str, addContactDataType, z16);
    }

    public final void O1(@NotNull String id5, @NotNull AddContactDataType type, boolean needRequest) {
        List<g> c16;
        List mutableList;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, id5, type, Boolean.valueOf(needRequest));
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        b value = this._uiState.getValue();
        if (value != null && (c16 = value.c()) != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) c16);
            int size = mutableList.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = c16.get(i3);
                if (gVar.d().b() == type) {
                    mutableList.set(i3, g.b(gVar, null, AddContactModelHelper.f180979a.a(gVar.c(), id5, type), null, 5, null));
                }
            }
            MutableLiveData<b> mutableLiveData = this._uiState;
            b value2 = mutableLiveData.getValue();
            if (value2 != null) {
                bVar = b.b(value2, false, mutableList, 0, null, false, 29, null);
            } else {
                bVar = null;
            }
            mutableLiveData.setValue(bVar);
            if (needRequest) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.b.f180893a.d(id5, com.tencent.mobileqq.troop.addcontact.model.a.a(type));
            }
        }
    }

    public final void Q1() {
        List emptyList;
        List emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            MutableLiveData<b> mutableLiveData = this._uiState;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData.postValue(new b(false, emptyList2, -1, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK, false, 16, null));
            return;
        }
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.b bVar = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.b.f180893a;
        if (bVar.n()) {
            MutableLiveData<b> mutableLiveData2 = this._uiState;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData2.postValue(new b(true, emptyList, 0, null, false, 12, null));
            return;
        }
        bVar.i(new Function1<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h, Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2$fetchContentList$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactViewModelV2.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.h it) {
                MutableLiveData mutableLiveData3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                mutableLiveData3 = AddContactViewModelV2.this._uiState;
                mutableLiveData3.postValue(new b(true, it.a(), 0, null, false, 28, null));
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2$fetchContentList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactViewModelV2.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg) {
                MutableLiveData mutableLiveData3;
                List emptyList3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) errMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                mutableLiveData3 = AddContactViewModelV2.this._uiState;
                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                mutableLiveData3.postValue(new b(false, emptyList3, i3, errMsg, false, 16, null));
            }
        });
    }

    @NotNull
    public final List<String> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.entranceList;
    }

    @NotNull
    public final SharedFlow<c> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.groupJoinedEvent;
    }

    @NotNull
    public final GPServiceObserver T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (GPServiceObserver) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.guildDataObserver;
    }

    @NotNull
    public final SharedFlow<c> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.guildJoinedEvent;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.api.observer.b W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.api.observer.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.troopMngObserver;
    }

    @NotNull
    public final LiveData<b> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uiState;
    }

    public final void Z1(@NotNull Context context, @NotNull QQAppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        this.entranceList = com.tencent.mobileqq.activity.contact.addcontact.gridentrance.c.b(context, app);
    }
}
