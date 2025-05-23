package com.tencent.mobileqq.troop.file.main.vm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.file.main.repo.TroopFileMainRepo;
import com.tencent.mobileqq.troop.file.main.vm.a;
import com.tencent.mobileqq.troop.file.main.vm.b;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001CB\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u00a2\u0006\u0004\b@\u0010AJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u001a\u0010\"\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R0\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020201j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000202`38\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010;\u001a\n 8*\u0004\u0018\u000107078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:R\u0011\u0010?\u001a\u00020<8F\u00a2\u0006\u0006\u001a\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/file/main/vm/a;", "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "", "folderId", "name", "", "e2", "Q1", "Lcom/tencent/mobileqq/troop/data/n;", "fileInfo", "R1", "Lcom/tencent/mobileqq/troop/file/main/vm/b$i;", "intent", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/troop/file/main/vm/b$c;", "userIntent", "Z1", "Lcom/tencent/mobileqq/troop/file/main/vm/b$g;", "d2", "b2", "c2", "state", "g2", "Landroid/os/Bundle;", "arguments", "init", "onResume", "X1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/file/main/vm/b;", "U1", "()Lcom/tencent/mobileqq/troop/file/main/vm/b;", "mNoneValueIntent", "Lks2/b;", "D", "Lks2/b;", "T1", "()Lks2/b;", "f2", "(Lks2/b;)V", "args", "Lcom/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo;", "E", "Lkotlin/Lazy;", "W1", "()Lcom/tencent/mobileqq/troop/file/main/repo/TroopFileMainRepo;", "repo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "reqLimit", "Lcom/tencent/mobileqq/app/QQAppInterface;", "kotlin.jvm.PlatformType", "S1", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Z", "isOverSpace", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/b;)V", "G", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainVM extends BaseViewModel<a, b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final b mNoneValueIntent;

    /* renamed from: D, reason: from kotlin metadata */
    public ks2.b args;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy repo;

    /* renamed from: F, reason: from kotlin metadata */
    private final HashMap<String, Long> reqLimit;

    public TroopFileMainVM() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void Q1(String name) {
        W1().e(name, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$createFolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
                invoke(bool.booleanValue(), num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, String fileId) {
                Intrinsics.checkNotNullParameter(fileId, "fileId");
                TroopFileMainVM.this.g2(new a.C8684a(z16, i3, fileId));
            }
        });
    }

    private final void R1(n fileInfo) {
        W1().f(fileInfo, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$deleteFolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
                invoke(bool.booleanValue(), num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, String fileId) {
                Intrinsics.checkNotNullParameter(fileId, "fileId");
                TroopFileMainVM.this.g2(new a.b(z16, i3, fileId));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface S1() {
        return TroopUtils.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopFileMainRepo W1() {
        return (TroopFileMainRepo) this.repo.getValue();
    }

    private final void Z1(b.c userIntent) {
        String stringExtra;
        String stringExtra2;
        Intent data = userIntent.getData();
        if (data == null || (stringExtra = data.getStringExtra("fileId")) == null || (stringExtra2 = data.getStringExtra("folderId")) == null) {
            return;
        }
        W1().m(stringExtra, stringExtra2);
    }

    private final void b2() {
        long currentTimeMillis = System.currentTimeMillis();
        Long l3 = this.reqLimit.get("req_file_used_space");
        if (l3 == null) {
            l3 = 0L;
        }
        if (currentTimeMillis - l3.longValue() < 1000) {
            return;
        }
        this.reqLimit.put("req_file_used_space", Long.valueOf(currentTimeMillis));
        W1().p(new Function1<ks2.c, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$refreshTroopFileUsedSpace$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ks2.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ks2.c it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TroopFileMainVM.this.g2(new a.c(it));
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$refreshTroopFileUsedSpace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TroopFileMainVM.this.g2(a.f.f295643a);
            }
        });
    }

    private final void c2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new TroopFileMainVM$refreshUploadCount$1(this, null), 2, null);
    }

    private final void d2(b.g userIntent) {
        userIntent.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$registerFileObserver$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                TroopFileMainRepo W1;
                W1 = TroopFileMainVM.this.W1();
                W1.g();
            }
        });
        W1().q(userIntent.getObserver());
    }

    private final void e2(final String folderId, String name) {
        W1().r(folderId, name, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$renameFolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                invoke(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3) {
                TroopFileMainVM.this.g2(new a.e(z16, i3, folderId));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(a state) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopFileMainVM$updateState$1(this, state, null), 3, null);
    }

    private final void h2(final b.i intent) {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$uploadFileList$uploadTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TroopFileMainRepo W1;
                QQAppInterface S1;
                QQAppInterface S12;
                W1 = TroopFileMainVM.this.W1();
                W1.t(intent.b());
                S1 = TroopFileMainVM.this.S1();
                ReportController.o(S1, "CliOper", "", "", "Grp", "Clk_fileslist_send", 0, 0, "", TroopFileMainVM.this.T1().troopUinStr, "", String.valueOf(intent.b().size()));
                boolean areEqual = Intrinsics.areEqual("/", TroopFileMainVM.this.T1().folderId);
                S12 = TroopFileMainVM.this.S1();
                ReportController.o(S12, "P_CliOper", "Grp_files", "", "oper", "Clk_up", 0, 0, TroopFileMainVM.this.T1().troopUinStr, String.valueOf(!areEqual ? 1 : 0), "", "");
            }
        };
        if (1 == TroopFileUtils.c(intent.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String())) {
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.vm.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopFileMainVM.i2(Function0.this, dialogInterface, i3);
                }
            };
            DialogUtil.createCustomDialog(intent.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), 230, intent.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getString(R.string.erp), intent.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getString(R.string.emi), R.string.cancel, R.string.ewn, onClickListener, onClickListener).show();
        } else {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(Function0 uploadTask, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(uploadTask, "$uploadTask");
        if (i3 == 1) {
            uploadTask.invoke();
        }
        dialogInterface.dismiss();
    }

    public final ks2.b T1() {
        ks2.b bVar = this.args;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("args");
        return null;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: U1, reason: from getter */
    public b getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.g) {
            d2((b.g) userIntent);
            return;
        }
        if (userIntent instanceof b.f) {
            c2();
            return;
        }
        if (userIntent instanceof b.e) {
            b2();
            return;
        }
        if (userIntent instanceof b.c) {
            Z1((b.c) userIntent);
            return;
        }
        if (userIntent instanceof b.i) {
            h2((b.i) userIntent);
            return;
        }
        if (userIntent instanceof b.C8685b) {
            R1(((b.C8685b) userIntent).getFileInfo());
            return;
        }
        if (userIntent instanceof b.a) {
            Q1(((b.a) userIntent).getName());
        } else if (userIntent instanceof b.h) {
            b.h hVar = (b.h) userIntent;
            e2(hVar.getFolderId(), hVar.getName());
        }
    }

    public final boolean a2() {
        return W1().o();
    }

    public final void f2(ks2.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.args = bVar;
    }

    public final void init(Bundle arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        f2(new ks2.b(arguments));
        QLog.i("TroopFile.Main.TroopFileMainVM", 1, "init, " + T1());
        W1().n();
        ks2.c i3 = W1().i();
        Intrinsics.checkNotNullExpressionValue(i3, "repo.fileUsedSpaceModel");
        g2(new a.c(i3));
        if (QLog.isDebugVersion()) {
            QLog.d("TroopFile.Main.TroopFileMainVM", 4, "init finish.");
        }
    }

    public final void onResume() {
        W1().s();
        b2();
    }

    public /* synthetic */ TroopFileMainVM(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? b.d.f295647a : bVar);
    }

    public TroopFileMainVM(b mNoneValueIntent) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mNoneValueIntent, "mNoneValueIntent");
        this.mNoneValueIntent = mNoneValueIntent;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileMainRepo>() { // from class: com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM$repo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileMainRepo invoke() {
                return new TroopFileMainRepo(TroopFileMainVM.this.T1());
            }
        });
        this.repo = lazy;
        this.reqLimit = new HashMap<>();
    }
}
