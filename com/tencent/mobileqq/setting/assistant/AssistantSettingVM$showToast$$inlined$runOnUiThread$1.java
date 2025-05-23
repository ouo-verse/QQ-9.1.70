package com.tencent.mobileqq.setting.assistant;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/setting/processor/SettingProcessorKt$runOnUiThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class AssistantSettingVM$showToast$$inlined$runOnUiThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f286495d;

    @Override // java.lang.Runnable
    public final void run() {
        QQToast.makeText(BaseApplication.getContext(), 1, this.f286495d, 0).show();
    }
}
