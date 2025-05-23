package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.base.meta.DBMeta;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/plugin/listener/IDBTracerListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "onDBInfoPublish", "", "metas", "", "Lcom/tencent/rmonitor/base/meta/DBMeta;", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public interface IDBTracerListener extends IBaseListener {
    void onDBInfoPublish(@NotNull List<DBMeta> metas);
}
