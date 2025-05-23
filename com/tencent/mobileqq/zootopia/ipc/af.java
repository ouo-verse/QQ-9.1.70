package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/af;", "", "Lorg/json/JSONObject;", "value", "", "onQzonePicSelectedOnMain", "onGetValidUrlOnMain", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZootopiaQzoneIPCImpl.class)
/* loaded from: classes35.dex */
public interface af {
    void onGetValidUrlOnMain(JSONObject value);

    void onQzonePicSelectedOnMain(JSONObject value);
}
