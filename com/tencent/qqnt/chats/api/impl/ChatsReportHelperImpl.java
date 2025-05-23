package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsReportHelperImpl;", "Lcom/tencent/qqnt/chats/api/IChatsReportHelper;", "", "pgType", "Lcom/tencent/qqnt/chats/api/b;", "report", "", "updateChatsListReport", "getChatsListReport", "", "reportCacheMap", "Ljava/util/Map;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsReportHelperImpl implements IChatsReportHelper {
    static IPatchRedirector $redirector_;

    @NotNull
    private final Map<Integer, com.tencent.qqnt.chats.api.b> reportCacheMap;

    public ChatsReportHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.reportCacheMap = new LinkedHashMap();
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsReportHelper
    @Nullable
    public com.tencent.qqnt.chats.api.b getChatsListReport(int pgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.api.b) iPatchRedirector.redirect((short) 3, (Object) this, pgType);
        }
        return this.reportCacheMap.get(Integer.valueOf(pgType));
    }

    @Override // com.tencent.qqnt.chats.api.IChatsReportHelper
    public void updateChatsListReport(int pgType, @Nullable com.tencent.qqnt.chats.api.b report) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, pgType, (Object) report);
        } else if (report == null) {
            this.reportCacheMap.remove(Integer.valueOf(pgType));
        } else {
            this.reportCacheMap.put(Integer.valueOf(pgType), report);
        }
    }
}
