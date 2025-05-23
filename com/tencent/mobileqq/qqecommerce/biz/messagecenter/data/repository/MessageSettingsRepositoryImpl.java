package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import ag2.b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.e;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import yf2.a;
import zf2.MessageSettingItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001\nB!\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\"\u0010#J\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u001c8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageSettingsRepositoryImpl;", "Lag2/b;", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "messageType", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;", "messageTypeStatus", "", "a", "(Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lyf2/a;", "Lyf2/a;", "localDataSource", "Lyf2/b;", "Lyf2/b;", "remoteDataSource", "Lkotlinx/coroutines/CoroutineDispatcher;", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "remoteOpContext", "Landroidx/lifecycle/MutableLiveData;", "", "Lzf2/c;", "d", "Landroidx/lifecycle/MutableLiveData;", "_settings", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "getSettings", "()Landroidx/lifecycle/LiveData;", QCircleDaTongConstant.ElementParamValue.SETTINGS, "<init>", "(Lyf2/a;Lyf2/b;Lkotlinx/coroutines/CoroutineDispatcher;)V", "f", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageSettingsRepositoryImpl implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a localDataSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final yf2.b remoteDataSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher remoteOpContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<MessageSettingItem>> _settings;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<MessageSettingItem>> settings;

    public MessageSettingsRepositoryImpl(a localDataSource, yf2.b remoteDataSource, CoroutineDispatcher remoteOpContext) {
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(remoteOpContext, "remoteOpContext");
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.remoteOpContext = remoteOpContext;
        MutableLiveData<List<MessageSettingItem>> mutableLiveData = new MutableLiveData<>();
        this._settings = mutableLiveData;
        this.settings = mutableLiveData;
    }

    @Override // ag2.b
    public Object a(MessageType messageType, e eVar, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.remoteOpContext, new MessageSettingsRepositoryImpl$updateMessageTypeStatus$2(this, messageType, eVar, null), continuation);
    }

    @Override // ag2.b
    public Object b(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        List<MessageSettingItem> a16 = this.localDataSource.a();
        if (!a16.isEmpty()) {
            booleanRef.element = true;
            this._settings.postValue(a16);
            QLog.d("ECMsgCenter|MessageSettingsRepositoryImpl", 2, "fetchMessageSettings return local datas. size = " + a16.size());
        }
        Object withContext = BuildersKt.withContext(this.remoteOpContext, new MessageSettingsRepositoryImpl$fetchMessageSettings$2(this, a16, booleanRef, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    @Override // ag2.b
    public LiveData<List<MessageSettingItem>> getSettings() {
        return this.settings;
    }

    public /* synthetic */ MessageSettingsRepositoryImpl(a aVar, yf2.b bVar, CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, bVar, (i3 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
