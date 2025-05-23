package com.qzone.reborn.groupalbum.selectmedia.viewmodel;

import aj.a;
import aj.b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cj.b;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.selectmedia.data.datasource.PlatformSearchMediaSource;
import com.qzone.reborn.groupalbum.selectmedia.util.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.base.mvi.a;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u000fH\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020'0+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00180&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00180+8\u0006\u00a2\u0006\f\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010C\u001a\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/viewmodel/ChatHistoryMediaViewModel;", "Lcom/qzone/reborn/base/n;", "", "pageCount", "", "X1", "", "msgId", "msgTime", "msgSeq", "requestCount", "Z1", "Laj/b$a;", "intent", "N1", "", "groupId", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", IProfileCardConst.KEY_FROM_TYPE, "W1", "Laj/b;", "userIntent", "U1", "", "state", "b2", "getLogTag", "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "R1", "()Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/base/mvi/a;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_mUiState", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "mUiState", "E", "_selectBtnState", UserInfo.SEX_FEMALE, "T1", "selectBtnState", "G", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "O1", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "H", "I", "Q1", "()I", "setFromType", "(I)V", "Lcom/qzone/reborn/groupalbum/selectmedia/data/datasource/PlatformSearchMediaSource;", "Lkotlin/Lazy;", "P1", "()Lcom/qzone/reborn/groupalbum/selectmedia/data/datasource/PlatformSearchMediaSource;", "dataSource", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ChatHistoryMediaViewModel extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<a> _mUiState;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<a> mUiState;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _selectBtnState;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> selectBtnState;

    /* renamed from: G, reason: from kotlin metadata */
    private CommonAlbumInfo albumInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private int fromType;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy dataSource;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope viewModelScope;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public String groupId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.qzone.reborn.groupalbum.selectmedia.viewmodel.ChatHistoryMediaViewModel$1", f = "ChatHistoryMediaViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qzone.reborn.groupalbum.selectmedia.viewmodel.ChatHistoryMediaViewModel$1, reason: invalid class name */
    /* loaded from: classes37.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FileTransNotifyInfo, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FileTransNotifyInfo fileTransNotifyInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(fileTransNotifyInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileTransNotifyInfo fileTransNotifyInfo = (FileTransNotifyInfo) this.L$0;
                c.f56957a.a("ChatHistoryMediaViewModel", " downLoad complete " + fileTransNotifyInfo);
                ChatHistoryMediaViewModel.this._mUiState.setValue(new a.DowLoadMediaCompleted(fileTransNotifyInfo));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatHistoryMediaViewModel() {
        Lazy lazy;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.viewModelScope = CoroutineScope;
        MutableLiveData<com.tencent.qqnt.base.mvi.a> mutableLiveData = new MutableLiveData<>();
        this._mUiState = mutableLiveData;
        this.mUiState = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._selectBtnState = mutableLiveData2;
        this.selectBtnState = mutableLiveData2;
        FlowKt.launchIn(FlowKt.onEach(b.b(), new AnonymousClass1(null)), CoroutineScope);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PlatformSearchMediaSource>() { // from class: com.qzone.reborn.groupalbum.selectmedia.viewmodel.ChatHistoryMediaViewModel$dataSource$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PlatformSearchMediaSource invoke() {
                return new PlatformSearchMediaSource();
            }
        });
        this.dataSource = lazy;
    }

    private final void N1(b.a intent) {
        c.f56957a.a("ChatHistoryMediaViewModel", " dowLoadMedia " + intent.getParam() + "  peerId " + R1() + "  chatType 2");
        RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
        richMediaElementGetReq.msgId = intent.getParam().getMsgId();
        richMediaElementGetReq.peerUid = R1();
        richMediaElementGetReq.chatType = 2;
        richMediaElementGetReq.elementId = intent.getParam().getElementId();
        richMediaElementGetReq.downloadType = intent.getParam().getReq().getDownloadType();
        richMediaElementGetReq.thumbSize = intent.getParam().getReq().getThumbLevel();
        richMediaElementGetReq.downSourceType = 3;
        richMediaElementGetReq.triggerType = 1;
        cj.b.a(richMediaElementGetReq);
    }

    private final PlatformSearchMediaSource P1() {
        return (PlatformSearchMediaSource) this.dataSource.getValue();
    }

    private final void X1(int pageCount) {
        FlowKt.launchIn(FlowKt.onEach(P1().b(2, R1(), pageCount), new ChatHistoryMediaViewModel$loadFirstPageMedia$1(this, pageCount, null)), this.viewModelScope);
    }

    /* renamed from: O1, reason: from getter */
    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* renamed from: Q1, reason: from getter */
    public final int getFromType() {
        return this.fromType;
    }

    public final String R1() {
        String str = this.groupId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("groupId");
        return null;
    }

    public final LiveData<com.tencent.qqnt.base.mvi.a> S1() {
        return this.mUiState;
    }

    public final LiveData<Boolean> T1() {
        return this.selectBtnState;
    }

    public final void U1(aj.b userIntent) {
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.GetMediaList) {
            X1(((b.GetMediaList) userIntent).getRequestCount());
        }
        if (userIntent instanceof b.a) {
            N1((b.a) userIntent);
        }
        if (userIntent instanceof b.GetMoreMediaList) {
            b.GetMoreMediaList getMoreMediaList = (b.GetMoreMediaList) userIntent;
            Z1(getMoreMediaList.getMsgId(), getMoreMediaList.getMsgTime(), getMoreMediaList.getMsgSeq(), getMoreMediaList.getRequestCount());
        }
    }

    public final void W1(String groupId, CommonAlbumInfo albumInfo, int fromType) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        a2(groupId);
        this.albumInfo = albumInfo;
        this.fromType = fromType;
    }

    public final void a2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void b2(boolean state) {
        if (Intrinsics.areEqual(Boolean.valueOf(state), this._selectBtnState.getValue())) {
            return;
        }
        this._selectBtnState.setValue(Boolean.valueOf(state));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "ChatHistoryMediaViewModel";
    }

    private final void Z1(long msgId, long msgTime, long msgSeq, int requestCount) {
        FlowKt.launchIn(FlowKt.onEach(P1().c(2, R1(), msgId, msgTime, msgSeq, requestCount), new ChatHistoryMediaViewModel$loadMoreMedia$1(this, requestCount, null)), this.viewModelScope);
    }
}
