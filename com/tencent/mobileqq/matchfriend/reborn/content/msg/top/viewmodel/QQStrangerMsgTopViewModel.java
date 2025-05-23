package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/viewmodel/QQStrangerMsgTopViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Q1", "", "openId", "trace", "P1", "", "tinyId", "", "emojiId", "R1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "cardListLiveData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "N1", "()Z", "setHasRequest", "(Z)V", "hasRequest", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/repository/QQStrangerMsgTopRepository;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "O1", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/repository/QQStrangerMsgTopRepository;", "repository", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgTopViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy repository;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<Prompt$CardInfo>> cardListLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasRequest;

    public QQStrangerMsgTopViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerMsgTopRepository>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel.QQStrangerMsgTopViewModel$repository$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerMsgTopRepository invoke() {
                return new QQStrangerMsgTopRepository();
            }
        });
        this.repository = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerMsgTopRepository O1() {
        return (QQStrangerMsgTopRepository) this.repository.getValue();
    }

    public final MutableLiveData<List<Prompt$CardInfo>> M1() {
        return this.cardListLiveData;
    }

    /* renamed from: N1, reason: from getter */
    public final boolean getHasRequest() {
        return this.hasRequest;
    }

    public final void P1(String openId, String trace) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(trace, "trace");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerMsgTopViewModel", Boolean.FALSE, null, null, new QQStrangerMsgTopViewModel$reportUser$1(this, openId, trace, null), 12, null);
    }

    public final void R1(long tinyId, int emojiId) {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerMsgTopViewModel", Boolean.FALSE, null, null, new QQStrangerMsgTopViewModel$sendEmojiMsg$1(tinyId, emojiId, null), 12, null);
    }

    public final void Q1() {
        this.hasRequest = true;
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerMsgTopViewModel", Boolean.FALSE, null, null, new QQStrangerMsgTopViewModel$requestCardList$1(this, null), 12, null);
    }
}
