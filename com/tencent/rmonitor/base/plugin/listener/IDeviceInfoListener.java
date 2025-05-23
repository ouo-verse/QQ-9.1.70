package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.rmonitor.base.meta.DeviceMeta;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/rmonitor/base/plugin/listener/IDeviceInfoListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "onBeforeReport", "", PublicAccountMessageUtilImpl.META_NAME, "Lcom/tencent/rmonitor/base/meta/DeviceMeta;", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public interface IDeviceInfoListener extends IBaseListener {
    void onBeforeReport(@Nullable DeviceMeta meta);
}
