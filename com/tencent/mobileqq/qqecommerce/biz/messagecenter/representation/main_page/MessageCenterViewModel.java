package com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import zf2.MessageSettingItem;
import zf2.PromotionPanelItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001EB\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R9\u0010)\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0%j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n`&0\u001d8\u0006\u00a2\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u000202068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/MessageCenterViewModel;", "Landroidx/lifecycle/ViewModel;", "", "R1", "d2", "", "messageId", "Q1", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "messageType", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "newStatus", "e2", "T1", "U1", "S1", "onCleared", "Lag2/c;", "i", "Lag2/c;", "promotionRepo", "Lag2/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lag2/b;", "messageTypeRepo", "Lag2/a;", BdhLogUtil.LogTag.Tag_Conn, "Lag2/a;", "messageRepo", "Landroidx/lifecycle/LiveData;", "", "Lzf2/d;", "D", "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "promotionItemList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "X1", "messageTypeToStatus", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl$b;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/StateFlow;", "Z1", "()Lkotlinx/coroutines/flow/StateFlow;", "messageUIState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/representation/main_page/r;", "G", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_operationFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "H", "Lkotlinx/coroutines/flow/SharedFlow;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lkotlinx/coroutines/flow/SharedFlow;", "operationFlow", "Lkotlinx/coroutines/CoroutineScope;", "I", "Lkotlin/Lazy;", "W1", "()Lkotlinx/coroutines/CoroutineScope;", "ioScope", "<init>", "(Lag2/c;Lag2/b;Lag2/a;)V", "J", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageCenterViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final ag2.a messageRepo;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<PromotionPanelItem>> promotionItemList;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e>> messageTypeToStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private final StateFlow<MessageRepositoryImpl.b> messageUIState;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableSharedFlow<r> _operationFlow;

    /* renamed from: H, reason: from kotlin metadata */
    private final SharedFlow<r> operationFlow;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy ioScope;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ag2.c promotionRepo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ag2.b messageTypeRepo;

    public MessageCenterViewModel(ag2.c promotionRepo, ag2.b messageTypeRepo, ag2.a messageRepo) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(promotionRepo, "promotionRepo");
        Intrinsics.checkNotNullParameter(messageTypeRepo, "messageTypeRepo");
        Intrinsics.checkNotNullParameter(messageRepo, "messageRepo");
        this.promotionRepo = promotionRepo;
        this.messageTypeRepo = messageTypeRepo;
        this.messageRepo = messageRepo;
        this.promotionItemList = promotionRepo.a();
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        LiveData<List<MessageSettingItem>> settings = messageTypeRepo.getSettings();
        final Function1<List<? extends MessageSettingItem>, Unit> function1 = new Function1<List<? extends MessageSettingItem>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterViewModel$messageTypeToStatus$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MessageSettingItem> list) {
                invoke2((List<MessageSettingItem>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MessageSettingItem> data) {
                HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e> b16;
                MediatorLiveData<HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e>> mediatorLiveData2 = mediatorLiveData;
                Intrinsics.checkNotNullExpressionValue(data, "data");
                b16 = q.b(data);
                mediatorLiveData2.postValue(b16);
            }
        };
        mediatorLiveData.addSource(settings, new Observer() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageCenterViewModel.c2(Function1.this, obj);
            }
        });
        this.messageTypeToStatus = mediatorLiveData;
        this.messageUIState = messageRepo.b();
        MutableSharedFlow<r> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._operationFlow = MutableSharedFlow$default;
        this.operationFlow = FlowKt.asSharedFlow(MutableSharedFlow$default);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterViewModel$ioScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            }
        });
        this.ioScope = lazy;
        T1();
        R1();
        U1();
        d2();
    }

    private final void R1() {
        BuildersKt__Builders_commonKt.launch$default(W1(), null, null, new MessageCenterViewModel$fetchMessageSettings$1(this, null), 3, null);
    }

    private final CoroutineScope W1() {
        return (CoroutineScope) this.ioScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void d2() {
        BuildersKt__Builders_commonKt.launch$default(W1(), null, null, new MessageCenterViewModel$updateAIOContentWhenMessagesUpdated$1(this, null), 3, null);
    }

    public final void Q1(String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        BuildersKt__Builders_commonKt.launch$default(W1(), null, null, new MessageCenterViewModel$deleteMessage$1(this, messageId, null), 3, null);
    }

    public final void S1() {
        BuildersKt__Builders_commonKt.launch$default(W1(), null, null, new MessageCenterViewModel$fetchMoreMessages$1(this, null), 3, null);
    }

    public final void T1() {
        BuildersKt__Builders_commonKt.launch$default(W1(), null, null, new MessageCenterViewModel$fetchPromotionItemList$1(this, null), 3, null);
    }

    public final void U1() {
        BuildersKt__Builders_commonKt.launch$default(W1(), null, null, new MessageCenterViewModel$firstFetchMessages$1(this, null), 3, null);
    }

    public final LiveData<HashMap<MessageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e>> X1() {
        return this.messageTypeToStatus;
    }

    public final StateFlow<MessageRepositoryImpl.b> Z1() {
        return this.messageUIState;
    }

    public final SharedFlow<r> a2() {
        return this.operationFlow;
    }

    public final LiveData<List<PromotionPanelItem>> b2() {
        return this.promotionItemList;
    }

    public final void e2(MessageType messageType, com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e newStatus) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        BuildersKt__Builders_commonKt.launch$default(W1(), null, null, new MessageCenterViewModel$updateMessageStatus$1(this, messageType, newStatus, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CoroutineScopeKt.cancel$default(W1(), null, 1, null);
    }
}
