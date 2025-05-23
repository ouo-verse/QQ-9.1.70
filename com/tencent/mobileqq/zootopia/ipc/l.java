package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/l;", "", "", "type", "Lcom/tencent/mobileqq/zootopia/ipc/k;", "callback", "", "isSwitchOn", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZootopiaDevSettingRemoteManagerImpl.class)
/* loaded from: classes35.dex */
public interface l {
    void isSwitchOn(int type, k callback);
}
