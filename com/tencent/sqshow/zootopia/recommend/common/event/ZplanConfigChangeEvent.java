package com.tencent.sqshow.zootopia.recommend.common.event;

import android.content.res.Configuration;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/common/event/ZplanConfigChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "configuration", "Landroid/content/res/Configuration;", "(Landroid/content/res/Configuration;)V", "getConfiguration", "()Landroid/content/res/Configuration;", "setConfiguration", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanConfigChangeEvent extends SimpleBaseEvent {
    private Configuration configuration;

    public ZplanConfigChangeEvent(Configuration configuration) {
        this.configuration = configuration;
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
