package com.tencent.mobileqq.guild.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IGuildTransaction;
import com.tencent.mobileqq.guild.api.IGuildTransactionManageService;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildTransactionManageServiceImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildTransactionManageService;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", "Lcom/tencent/mobileqq/guild/api/IGuildTransaction;", "transaction", "addTransaction", "", "id", "removeTransaction", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "transactionMap", "Ljava/util/LinkedHashMap;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildTransactionManageServiceImpl implements IGuildTransactionManageService {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String TAG = "GuildTransactionManageServiceImpl";

    @NotNull
    private final LinkedHashMap<Integer, IGuildTransaction> transactionMap = new LinkedHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildTransactionManageServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTransactionManageService
    public void addTransaction(@NotNull IGuildTransaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[addTransaction]: id=" + transaction.getId() + ", transaction.class=" + transaction.getClass().getName());
        }
        this.transactionMap.put(Integer.valueOf(transaction.getId()), transaction);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        List reversed;
        if (this.transactionMap.isEmpty()) {
            return;
        }
        Collection<IGuildTransaction> values = this.transactionMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "transactionMap.values");
        reversed = CollectionsKt___CollectionsKt.reversed(values);
        Iterator it = reversed.iterator();
        while (it.hasNext()) {
            removeTransaction(((IGuildTransaction) it.next()).getId());
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTransactionManageService
    public void removeTransaction(int id5) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[removeTransaction]: id=" + id5);
        }
        IGuildTransaction remove = this.transactionMap.remove(Integer.valueOf(id5));
        if (remove != null) {
            remove.onRemoved();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
