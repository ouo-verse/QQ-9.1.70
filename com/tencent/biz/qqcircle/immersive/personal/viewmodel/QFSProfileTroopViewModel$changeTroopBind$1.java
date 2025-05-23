package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.data.TroopItemType;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSProfileTroopViewModel$changeTroopBind$1", f = "QFSProfileTroopViewModel.kt", i = {0}, l = {95, 103, 104}, m = "invokeSuspend", n = {"scene"}, s = {"I$0"})
/* loaded from: classes4.dex */
public final class QFSProfileTroopViewModel$changeTroopBind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedCloudMeta$StFeed $feed;
    final /* synthetic */ QFSTroopItemInfo $troop;
    final /* synthetic */ TroopRequestType $type;
    int I$0;
    int label;
    final /* synthetic */ QFSProfileTroopViewModel this$0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f89131a;

        static {
            int[] iArr = new int[TroopRequestType.values().length];
            try {
                iArr[TroopRequestType.PROFILE_HOST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopRequestType.TYPE_FEED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f89131a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSProfileTroopViewModel$changeTroopBind$1(TroopRequestType troopRequestType, QFSTroopItemInfo qFSTroopItemInfo, QFSProfileTroopViewModel qFSProfileTroopViewModel, FeedCloudMeta$StFeed feedCloudMeta$StFeed, Continuation<? super QFSProfileTroopViewModel$changeTroopBind$1> continuation) {
        super(2, continuation);
        this.$type = troopRequestType;
        this.$troop = qFSTroopItemInfo;
        this.this$0 = qFSProfileTroopViewModel;
        this.$feed = feedCloudMeta$StFeed;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QFSProfileTroopViewModel$changeTroopBind$1(this.$type, this.$troop, this.this$0, this.$feed, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        String a16;
        boolean isBlank;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ResultKt.throwOnFailure(obj);
                        a16 = (String) obj;
                        mutableLiveData2 = this.this$0._changeTroopBindLiveData;
                        mutableLiveData2.postValue(new Pair(a16, this.$troop));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                a16 = (String) obj;
                mutableLiveData2 = this.this$0._changeTroopBindLiveData;
                mutableLiveData2.postValue(new Pair(a16, this.$troop));
                return Unit.INSTANCE;
            }
            i3 = this.I$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            int i17 = a.f89131a[this.$type.ordinal()];
            if (i17 != 1) {
                if (i17 != 2) {
                    i3 = 0;
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 1;
            }
            if (this.$troop.getType() == TroopItemType.DATA && this.$troop.getIsBound()) {
                QFSProfileTroopViewModel qFSProfileTroopViewModel = this.this$0;
                QFSTroopItemInfo qFSTroopItemInfo = this.$troop;
                this.I$0 = i3;
                this.label = 1;
                obj = qFSProfileTroopViewModel.b2(qFSTroopItemInfo, i3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1929748y);
            if (i3 == 1) {
                if (i3 != 2) {
                    QLog.w("QFSProfileTroopViewModel", 1, "[changeTroopBind] invalid scene: " + i3);
                    mutableLiveData2 = this.this$0._changeTroopBindLiveData;
                    mutableLiveData2.postValue(new Pair(a16, this.$troop));
                    return Unit.INSTANCE;
                }
                QFSProfileTroopViewModel qFSProfileTroopViewModel2 = this.this$0;
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.$feed;
                this.label = 3;
                obj = qFSProfileTroopViewModel2.W1(feedCloudMeta$StFeed, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                a16 = (String) obj;
                mutableLiveData2 = this.this$0._changeTroopBindLiveData;
                mutableLiveData2.postValue(new Pair(a16, this.$troop));
                return Unit.INSTANCE;
            }
            QFSProfileTroopViewModel qFSProfileTroopViewModel3 = this.this$0;
            this.label = 2;
            obj = qFSProfileTroopViewModel3.X1(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            a16 = (String) obj;
            mutableLiveData2 = this.this$0._changeTroopBindLiveData;
            mutableLiveData2.postValue(new Pair(a16, this.$troop));
            return Unit.INSTANCE;
        }
        String str = (String) obj;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            mutableLiveData = this.this$0._changeTroopBindLiveData;
            mutableLiveData.postValue(new Pair(str, this.$troop));
            return Unit.INSTANCE;
        }
        a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1929748y);
        if (i3 == 1) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QFSProfileTroopViewModel$changeTroopBind$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
