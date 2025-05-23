package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import zf2.MessageSettingItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0002H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "N1", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "oldStatus", "newStatus", "R1", "onCleared", "Lag2/b;", "i", "Lag2/b;", "repo", "Landroidx/lifecycle/LiveData;", "", "Lzf2/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", QCircleDaTongConstant.ElementParamValue.SETTINGS, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsViewModel$a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_updateResult", "Lkotlinx/coroutines/flow/SharedFlow;", "D", "Lkotlinx/coroutines/flow/SharedFlow;", "Q1", "()Lkotlinx/coroutines/flow/SharedFlow;", "updateResult", "Lkotlinx/coroutines/CoroutineScope;", "E", "Lkotlin/Lazy;", "O1", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope", "<init>", "(Lag2/b;)V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageTypeSettingsViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableSharedFlow<UpdateItemResult> _updateResult;

    /* renamed from: D, reason: from kotlin metadata */
    private final SharedFlow<UpdateItemResult> updateResult;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy ioScope;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ag2.b repo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<MessageSettingItem>> settings;

    public MessageTypeSettingsViewModel(ag2.b repo) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.repo = repo;
        this.settings = repo.getSettings();
        MutableSharedFlow<UpdateItemResult> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._updateResult = MutableSharedFlow$default;
        this.updateResult = FlowKt.asSharedFlow(MutableSharedFlow$default);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsViewModel$ioScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            }
        });
        this.ioScope = lazy;
    }

    private final CoroutineScope O1() {
        return (CoroutineScope) this.ioScope.getValue();
    }

    public final void N1() {
        BuildersKt__Builders_commonKt.launch$default(O1(), null, null, new MessageTypeSettingsViewModel$fetchSettingsData$1(this, null), 3, null);
    }

    public final LiveData<List<MessageSettingItem>> P1() {
        return this.settings;
    }

    public final SharedFlow<UpdateItemResult> Q1() {
        return this.updateResult;
    }

    public final void R1(MessageType type, e oldStatus, e newStatus) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(oldStatus, "oldStatus");
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        BuildersKt__Builders_commonKt.launch$default(O1(), null, null, new MessageTypeSettingsViewModel$updateTypeStatus$1(this, type, newStatus, oldStatus, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CoroutineScopeKt.cancel$default(O1(), null, 1, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/settings/MessageTypeSettingsViewModel$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSucceed", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "status", "<init>", "(ZLcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsViewModel$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class UpdateItemResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSucceed;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final MessageType type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final e status;

        public UpdateItemResult(boolean z16, MessageType type, e status) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(status, "status");
            this.isSucceed = z16;
            this.type = type;
            this.status = status;
        }

        /* renamed from: a, reason: from getter */
        public final e getStatus() {
            return this.status;
        }

        /* renamed from: b, reason: from getter */
        public final MessageType getType() {
            return this.type;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsSucceed() {
            return this.isSucceed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.isSucceed;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.type.hashCode()) * 31) + this.status.hashCode();
        }

        public String toString() {
            return "UpdateItemResult(isSucceed=" + this.isSucceed + ", type=" + this.type + ", status=" + this.status + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateItemResult)) {
                return false;
            }
            UpdateItemResult updateItemResult = (UpdateItemResult) other;
            return this.isSucceed == updateItemResult.isSucceed && Intrinsics.areEqual(this.type, updateItemResult.type) && Intrinsics.areEqual(this.status, updateItemResult.status);
        }
    }
}
