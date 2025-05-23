package com.tencent.mobileqq.troop.homework.file.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.q;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import rs2.a;
import rs2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016JN\u0010\u0014\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\u0017\u001a\u00020\u0006J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010)\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R4\u0010-\u001a\"\u0012\f\u0012\n **\u0004\u0018\u00010\u000f0\u000f0\u0011j\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u000f0\u000f`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u001a\u0010>\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/file/vm/TroopTeacherFileVM;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lrs2/a;", "Lrs2/b;", "Lcom/tencent/mobileqq/troop/data/q;", "userIntent", "", "T1", "", "Lcom/tencent/mobileqq/troop/data/n;", "files", "", "isEnd", "", "parentId", "", "uinFilter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uinFilterList", "N0", "fileInfo", "I0", "Q1", "p1", "B1", "", "sum", "m0", "targetParentId", "x0", Constants.BASE_IN_PLUGIN_ID, "X0", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "bundle", "D", "Ljava/lang/String;", "S1", "()Ljava/lang/String;", "troopUin", "kotlin.jvm.PlatformType", "E", "Ljava/util/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/mobileqq/troop/utils/TroopFileManager;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/utils/TroopFileManager;", "troopFileManager", "G", "Ljava/util/List;", "fileList", "H", "Z", "isListEnd", "I", "isFetchingList", "J", "Lrs2/b;", "R1", "()Lrs2/b;", "mNoneValueIntent", "<init>", "(Landroid/os/Bundle;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopTeacherFileVM extends BaseViewModel<a, b> implements q {

    /* renamed from: C, reason: from kotlin metadata */
    private final Bundle bundle;

    /* renamed from: D, reason: from kotlin metadata */
    private final String troopUin;

    /* renamed from: E, reason: from kotlin metadata */
    private final ArrayList<Long> uinList;

    /* renamed from: F, reason: from kotlin metadata */
    private final TroopFileManager troopFileManager;

    /* renamed from: G, reason: from kotlin metadata */
    private final List<n> fileList;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isListEnd;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFetchingList;

    /* renamed from: J, reason: from kotlin metadata */
    private final b mNoneValueIntent;

    public TroopTeacherFileVM(Bundle bundle) {
        List emptyList;
        List list;
        int collectionSizeOrDefault;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.bundle = bundle;
        String string = bundle.getString("troopUin", "0");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(ArgKey.KEY_TROOP_UIN, \"0\")");
        this.troopUin = string;
        ArrayList<String> stringArrayList = bundle.getStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
        if (stringArrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(stringArrayList, 10);
            list = new ArrayList(collectionSizeOrDefault);
            for (String it : stringArrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(it);
                list.add(Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        }
        this.uinList = new ArrayList<>(list);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        TroopFileManager F = TroopFileManager.F((QQAppInterface) peekAppRuntime, Long.parseLong(this.troopUin));
        Intrinsics.checkNotNullExpressionValue(F, "getMgrByTroopUin(\n      \u2026rface, troopUin.toLong())");
        this.troopFileManager = F;
        this.fileList = new ArrayList();
        F.registerObserver(this);
        this.mNoneValueIntent = b.c.f432149a;
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void N0(final List<n> files, final boolean isEnd, String parentId, long uinFilter, final ArrayList<Long> uinFilterList) {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.homework.file.vm.TroopTeacherFileVM$onFilesFinish$1
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

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
            
                r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                List<n> arrayList;
                List list;
                MutableLiveData mUiState;
                List list2;
                boolean z16;
                List list3;
                List<n> list4 = files;
                if (list4 == null || arrayList == null) {
                    arrayList = new ArrayList();
                }
                list = this.fileList;
                list.clear();
                for (n nVar : arrayList) {
                    list3 = this.fileList;
                    list3.add(new n(nVar));
                }
                if (uinFilterList == null) {
                    return;
                }
                this.isListEnd = isEnd;
                mUiState = this.getMUiState();
                list2 = this.fileList;
                z16 = this.isListEnd;
                mUiState.setValue(new a.FileListUpdate(list2, z16));
                this.isFetchingList = false;
            }
        });
    }

    public final void Q1() {
        if (this.troopFileManager.q(this)) {
            this.troopFileManager.unregisterObserver(this);
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: R1, reason: from getter */
    public b getMNoneValueIntent() {
        return this.mNoneValueIntent;
    }

    /* renamed from: S1, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            this.troopFileManager.P(0, "", 0L, this.uinList);
        } else {
            if (!(userIntent instanceof b.C11158b) || this.isFetchingList) {
                return;
            }
            this.isFetchingList = true;
            this.troopFileManager.J("", 0L, this.uinList);
        }
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void I0(n fileInfo) {
        int indexOf;
        if (fileInfo == null || (indexOf = this.fileList.indexOf(fileInfo)) == -1) {
            return;
        }
        this.fileList.set(indexOf, new n(fileInfo));
        getMUiState().setValue(new a.FileListUpdate(this.fileList, this.isListEnd));
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void B1(n fileInfo) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void D1(n fileInfo) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void X0(n fileInfo) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void m0(int sum) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void p1(n fileInfo) {
    }

    @Override // com.tencent.mobileqq.troop.data.q
    public void x0(n fileInfo, String targetParentId) {
    }
}
