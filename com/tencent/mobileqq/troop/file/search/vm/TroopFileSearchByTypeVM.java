package com.tencent.mobileqq.troop.file.search.vm;

import android.os.Bundle;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troop.data.s;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.search.model.TroopFileSearchByTypeArgsModel;
import com.tencent.mobileqq.troop.file.search.repo.TroopFileSearchByTypeRepo;
import com.tencent.mobileqq.troop.file.search.vm.a;
import com.tencent.mobileqq.troop.file.search.vm.b;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001#\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0014R\u001a\u0010\u0017\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010+\u001a\n (*\u0004\u0018\u00010'0'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/TroopFileSearchByTypeVM;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "Lcom/tencent/mobileqq/troop/file/search/vm/b;", "", "data", "", "T1", "Lcom/tencent/mobileqq/troop/file/search/vm/b$a;", "intent", "O1", "state", "U1", "Landroid/os/Bundle;", "arguments", "init", "userIntent", "S1", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/file/search/vm/b;", "R1", "()Lcom/tencent/mobileqq/troop/file/search/vm/b;", "mNoneValueIntent", "Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;", "<set-?>", "D", "Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;", "Q1", "()Lcom/tencent/mobileqq/troop/file/search/model/TroopFileSearchByTypeArgsModel;", "args", "Lcom/tencent/mobileqq/troop/file/search/repo/TroopFileSearchByTypeRepo;", "E", "Lcom/tencent/mobileqq/troop/file/search/repo/TroopFileSearchByTypeRepo;", "repo", "com/tencent/mobileqq/troop/file/search/vm/TroopFileSearchByTypeVM$a", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/file/search/vm/TroopFileSearchByTypeVM$a;", "fileObserver", "Lcom/tencent/mobileqq/app/QQAppInterface;", "kotlin.jvm.PlatformType", "P1", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "(Lcom/tencent/mobileqq/troop/file/search/vm/b;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileSearchByTypeVM extends BaseViewModel<com.tencent.mobileqq.troop.file.search.vm.a, b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final b mNoneValueIntent;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopFileSearchByTypeArgsModel args;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopFileSearchByTypeRepo repo;

    /* renamed from: F, reason: from kotlin metadata */
    private final a fileObserver;

    public TroopFileSearchByTypeVM() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void O1(b.a intent) {
        TroopFileSearchByTypeRepo troopFileSearchByTypeRepo = this.repo;
        if (troopFileSearchByTypeRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
            troopFileSearchByTypeRepo = null;
        }
        troopFileSearchByTypeRepo.e(intent.getFileId(), intent.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.PARAM_FILENAME java.lang.String(), intent.getBusId(), intent.getThumbnailSizeSmall());
    }

    private final QQAppInterface P1() {
        return TroopUtils.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(Object data) {
        String str;
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.mobileqq.troop.data.TroopFileStatusInfo");
        t tVar = (t) data;
        TroopFileSearchByTypeRepo troopFileSearchByTypeRepo = this.repo;
        if (troopFileSearchByTypeRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
            troopFileSearchByTypeRepo = null;
        }
        String str2 = tVar.f294985s;
        Intrinsics.checkNotNullExpressionValue(str2, "info.FilePath");
        s i3 = troopFileSearchByTypeRepo.i(str2);
        if (i3 == null || (str = tVar.f294979m) == null) {
            return;
        }
        i3.f294966i.f294937w = str;
        U1(new a.e(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(com.tencent.mobileqq.troop.file.search.vm.a state) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopFileSearchByTypeVM$updateState$1(this, state, null), 3, null);
    }

    public final TroopFileSearchByTypeArgsModel Q1() {
        TroopFileSearchByTypeArgsModel troopFileSearchByTypeArgsModel = this.args;
        if (troopFileSearchByTypeArgsModel != null) {
            return troopFileSearchByTypeArgsModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("args");
        return null;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: R1, reason: from getter */
    public b getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        TroopFileSearchByTypeRepo troopFileSearchByTypeRepo = null;
        if (userIntent instanceof b.C8687b) {
            TroopFileSearchByTypeRepo troopFileSearchByTypeRepo2 = this.repo;
            if (troopFileSearchByTypeRepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                troopFileSearchByTypeRepo = troopFileSearchByTypeRepo2;
            }
            troopFileSearchByTypeRepo.l();
            return;
        }
        if (userIntent instanceof b.a) {
            O1((b.a) userIntent);
            return;
        }
        if (userIntent instanceof b.d) {
            TroopFileSearchByTypeRepo troopFileSearchByTypeRepo3 = this.repo;
            if (troopFileSearchByTypeRepo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                troopFileSearchByTypeRepo = troopFileSearchByTypeRepo3;
            }
            troopFileSearchByTypeRepo.d(((b.d) userIntent).getFrom());
            return;
        }
        if (userIntent instanceof b.e) {
            TroopFileSearchByTypeRepo troopFileSearchByTypeRepo4 = this.repo;
            if (troopFileSearchByTypeRepo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                troopFileSearchByTypeRepo = troopFileSearchByTypeRepo4;
            }
            troopFileSearchByTypeRepo.q();
        }
    }

    public final void init(Bundle arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.args = new TroopFileSearchByTypeArgsModel(arguments);
        this.repo = new TroopFileSearchByTypeRepo(Q1(), new Function1<com.tencent.mobileqq.troop.file.search.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.file.search.vm.TroopFileSearchByTypeVM$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TroopFileSearchByTypeVM.this.U1(it);
            }
        });
        P1().addObserver(this.fileObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        P1().removeObserver(this.fileObserver);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/file/search/vm/TroopFileSearchByTypeVM$a", "Lcom/tencent/mobileqq/app/c;", "", "data", "", "g", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends c {
        a() {
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object data) {
            if (data != null) {
                TroopFileSearchByTypeVM.this.T1(data);
            }
        }
    }

    public /* synthetic */ TroopFileSearchByTypeVM(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? b.c.f295684a : bVar);
    }

    public TroopFileSearchByTypeVM(b mNoneValueIntent) {
        Intrinsics.checkNotNullParameter(mNoneValueIntent, "mNoneValueIntent");
        this.mNoneValueIntent = mNoneValueIntent;
        this.fileObserver = new a();
    }
}
