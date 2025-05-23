package com.tencent.qqnt.aio.assistedchat.setting;

import android.os.Bundle;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/setting/f;", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", VideoTemplateParser.ITEM_LIST, "a", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class f implements BusinessObserver {
    public void a(boolean isSuccess, List<com.tencent.qqnt.aio.assistedchat.model.d> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
    }

    public void b(boolean isSuccess) {
    }

    @Override // mqq.observer.BusinessObserver
    public final void onReceive(int type, boolean isSuccess, Bundle bundle) {
    }
}
