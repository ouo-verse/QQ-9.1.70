package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildTransactionManageService;", "Lmqq/app/api/IRuntimeService;", "addTransaction", "", "transaction", "Lcom/tencent/mobileqq/guild/api/IGuildTransaction;", "removeTransaction", "id", "", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public interface IGuildTransactionManageService extends IRuntimeService {
    void addTransaction(@NotNull IGuildTransaction transaction);

    void removeTransaction(int id5);
}
