package com.tencent.mobileqq.troop.file.upload.vm;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.data.q;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import cooperation.qzone.QZoneHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0014R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010!\u001a\n \u000f*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010 R#\u0010&\u001a\n \u000f*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010%R\"\u0010+\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010(0(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R%\u00101\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010(0(0,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001c\u00105\u001a\n \u000f*\u0004\u0018\u000102028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/file/upload/vm/TroopFileUploadVM;", "Landroidx/lifecycle/ViewModel;", "Landroid/os/Bundle;", "arguments", "", "init", "Lcom/tencent/mobileqq/troop/data/q;", "observer", "Z1", "X1", "onCleared", "i", "Landroid/os/Bundle;", "args", "", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "U1", "()Ljava/lang/String;", "troopUinStr", "", BdhLogUtil.LogTag.Tag_Conn, "T1", "()J", "troopUinL", "D", "Lcom/tencent/mobileqq/troop/data/q;", "fileObserver", "Lcom/tencent/mobileqq/troop/utils/TroopFileManager;", "E", "R1", "()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;", "fileMgr", "Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;", UserInfo.SEX_FEMALE, "S1", "()Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;", "fileTransMgr", "Landroidx/lifecycle/MutableLiveData;", "", "G", "Landroidx/lifecycle/MutableLiveData;", "_uploadFinishPanelShow", "Landroidx/lifecycle/LiveData;", "H", "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "uploadFinishPanelShow", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Q1", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileUploadVM extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy troopUinL;

    /* renamed from: D, reason: from kotlin metadata */
    private q fileObserver;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy fileMgr;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy fileTransMgr;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _uploadFinishPanelShow;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Boolean> uploadFinishPanelShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Bundle args;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy troopUinStr;

    public TroopFileUploadVM() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.file.upload.vm.TroopFileUploadVM$troopUinStr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle bundle;
                bundle = TroopFileUploadVM.this.args;
                if (bundle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("args");
                    bundle = null;
                }
                return bundle.getString(QZoneHelper.Constants.KEY_QUN_ID, "");
            }
        });
        this.troopUinStr = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.troop.file.upload.vm.TroopFileUploadVM$troopUinL$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                String troopUinStr;
                Long longOrNull;
                troopUinStr = TroopFileUploadVM.this.U1();
                Intrinsics.checkNotNullExpressionValue(troopUinStr, "troopUinStr");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUinStr);
                return Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L);
            }
        });
        this.troopUinL = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileManager>() { // from class: com.tencent.mobileqq.troop.file.upload.vm.TroopFileUploadVM$fileMgr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileManager invoke() {
                QQAppInterface Q1;
                Q1 = TroopFileUploadVM.this.Q1();
                return TroopFileManager.F(Q1, TroopFileUploadVM.this.T1());
            }
        });
        this.fileMgr = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileTransferManager>() { // from class: com.tencent.mobileqq.troop.file.upload.vm.TroopFileUploadVM$fileTransMgr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileTransferManager invoke() {
                QQAppInterface Q1;
                Q1 = TroopFileUploadVM.this.Q1();
                return TroopFileTransferManager.O(Q1, TroopFileUploadVM.this.T1());
            }
        });
        this.fileTransMgr = lazy4;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this._uploadFinishPanelShow = mutableLiveData;
        LiveData<Boolean> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(_uploadFinishPanelShow)");
        this.uploadFinishPanelShow = distinctUntilChanged;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface Q1() {
        return TroopUtils.f();
    }

    private final TroopFileManager R1() {
        return (TroopFileManager) this.fileMgr.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopFileTransferManager S1() {
        return (TroopFileTransferManager) this.fileTransMgr.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String U1() {
        return (String) this.troopUinStr.getValue();
    }

    public final long T1() {
        return ((Number) this.troopUinL.getValue()).longValue();
    }

    public final LiveData<Boolean> W1() {
        return this.uploadFinishPanelShow;
    }

    public final void X1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new TroopFileUploadVM$refreshUploadUI$1(this, null), 2, null);
    }

    public final void Z1(q observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.fileObserver = observer;
        R1().registerObserver(observer);
    }

    public final void init(Bundle arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.args = arguments;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        q qVar = this.fileObserver;
        if (qVar != null) {
            R1().unregisterObserver(qVar);
        }
    }
}
