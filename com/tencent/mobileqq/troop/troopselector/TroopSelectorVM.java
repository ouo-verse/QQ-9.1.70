package com.tencent.mobileqq.troop.troopselector;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002J\u0014\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bR \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R-\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u001bj\b\u0012\u0004\u0012\u00020\b`\u001c0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0013R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\"\u0010*\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0013R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020'0\u00158\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R\"\u0010/\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010\u0013R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020'0\u00158\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0017\u001a\u0004\b1\u0010\u0019R\"\u00104\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010\u0013R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020'0\u00158\u0006\u00a2\u0006\f\n\u0004\b5\u0010\u0017\u001a\u0004\b6\u0010\u0019R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010\u0013R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0006\u00a2\u0006\f\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "O1", "", "getLogTag", "init", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "selectedNodeList", ICustomDataEditor.STRING_ARRAY_PARAM_2, "selectedTroopUin", "b2", "N1", "node", "Z1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "i", "Landroidx/lifecycle/MutableLiveData;", "_allTroopsList", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "allTroopsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "_selectedTroopList", "D", "S1", "selectedTroopList", "E", "_selectedTroop", UserInfo.SEX_FEMALE, "R1", "selectedTroop", "", "kotlin.jvm.PlatformType", "G", "_isFinishMultiMode", "H", "W1", "isFinishMultiMode", "I", "_isFinishSingleMode", "J", "X1", "isFinishSingleMode", "K", "_showLimitDialog", "L", "T1", "showLimitDialog", "M", "_selectedSingleNode", "N", "Q1", "selectedSingleNode", "<init>", "()V", "P", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSelectorVM extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<ArrayList<SharedNode>> _selectedTroopList;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<ArrayList<SharedNode>> selectedTroopList;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<SharedNode> _selectedTroop;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<SharedNode> selectedTroop;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isFinishMultiMode;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Boolean> isFinishMultiMode;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isFinishSingleMode;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<Boolean> isFinishSingleMode;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _showLimitDialog;

    /* renamed from: L, reason: from kotlin metadata */
    private final LiveData<Boolean> showLimitDialog;

    /* renamed from: M, reason: from kotlin metadata */
    private final MutableLiveData<SharedNode> _selectedSingleNode;

    /* renamed from: N, reason: from kotlin metadata */
    private final LiveData<SharedNode> selectedSingleNode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<TroopInfo>> _allTroopsList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<TroopInfo>> allTroopsList;

    public TroopSelectorVM() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableLiveData<List<TroopInfo>> mutableLiveData = new MutableLiveData<>(emptyList);
        this._allTroopsList = mutableLiveData;
        this.allTroopsList = mutableLiveData;
        MutableLiveData<ArrayList<SharedNode>> mutableLiveData2 = new MutableLiveData<>(new ArrayList());
        this._selectedTroopList = mutableLiveData2;
        this.selectedTroopList = mutableLiveData2;
        MutableLiveData<SharedNode> mutableLiveData3 = new MutableLiveData<>();
        this._selectedTroop = mutableLiveData3;
        this.selectedTroop = mutableLiveData3;
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(bool);
        this._isFinishMultiMode = mutableLiveData4;
        this.isFinishMultiMode = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(bool);
        this._isFinishSingleMode = mutableLiveData5;
        this.isFinishSingleMode = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(bool);
        this._showLimitDialog = mutableLiveData6;
        this.showLimitDialog = mutableLiveData6;
        MutableLiveData<SharedNode> mutableLiveData7 = new MutableLiveData<>();
        this._selectedSingleNode = mutableLiveData7;
        this.selectedSingleNode = mutableLiveData7;
    }

    private final void O1() {
        this._isFinishSingleMode.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(TroopSelectorVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        st2.b.f434715a.d(new TroopSelectorVM$init$1$1(this$0));
    }

    public final void N1() {
        this._isFinishMultiMode.postValue(Boolean.TRUE);
    }

    public final LiveData<List<TroopInfo>> P1() {
        return this.allTroopsList;
    }

    public final LiveData<SharedNode> Q1() {
        return this.selectedSingleNode;
    }

    public final LiveData<SharedNode> R1() {
        return this.selectedTroop;
    }

    public final LiveData<ArrayList<SharedNode>> S1() {
        return this.selectedTroopList;
    }

    public final LiveData<Boolean> T1() {
        return this.showLimitDialog;
    }

    public final LiveData<Boolean> W1() {
        return this.isFinishMultiMode;
    }

    public final LiveData<Boolean> X1() {
        return this.isFinishSingleMode;
    }

    public final void Z1(SharedNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this._showLimitDialog.postValue(Boolean.TRUE);
        this._selectedSingleNode.postValue(node);
    }

    public final void a2(List<SharedNode> selectedNodeList) {
        Intrinsics.checkNotNullParameter(selectedNodeList, "selectedNodeList");
        this._selectedTroopList.postValue(bg.f302144a.n(selectedNodeList));
    }

    public final void b2(SharedNode selectedTroopUin) {
        Intrinsics.checkNotNullParameter(selectedTroopUin, "selectedTroopUin");
        this._selectedTroop.postValue(selectedTroopUin);
        O1();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "TroopSelectorVM";
    }

    public final void init() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopselector.j
            @Override // java.lang.Runnable
            public final void run() {
                TroopSelectorVM.U1(TroopSelectorVM.this);
            }
        }, 16, null, false);
    }
}
