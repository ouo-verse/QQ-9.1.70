package com.tencent.mobileqq.tvideo.parts;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.tvideo.event.QFSTVideoNetworkChangedEvent;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/tvideo/parts/s;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "", "z9", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/biz/qcircleshadow/lib/HostStaticInvokeHelper$NetworkChangedObserver;", "d", "Lcom/tencent/biz/qcircleshadow/lib/HostStaticInvokeHelper$NetworkChangedObserver;", "networkObserver", "<init>", "()V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class s extends com.tencent.biz.qqcircle.immersive.part.u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HostStaticInvokeHelper.NetworkChangedObserver networkObserver = new HostStaticInvokeHelper.NetworkChangedObserver() { // from class: com.tencent.mobileqq.tvideo.parts.r
        @Override // com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.NetworkChangedObserver
        public final void onNetworkChanged(boolean z16) {
            s.A9(s.this, z16);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(s this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getContext() == null) {
            return;
        }
        this$0.z9();
    }

    private final void B9() {
        try {
            com.tencent.mobileqq.tvideo.viewmodel.j.f304839a = NetworkUtil.isMobileNetWork(getContext());
        } catch (Exception e16) {
            QLog.e("QFSLayerTVideoMobileToastPart", 1, "exception=" + e16);
        }
    }

    private final void z9() {
        B9();
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoNetworkChangedEvent(NetworkUtil.isMobileNetWork(getContext())));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        HostStaticInvokeHelper.addNetworkChangedObserver(this.networkObserver);
        B9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        HostStaticInvokeHelper.removeNetworkChangeObserver(this.networkObserver);
    }
}
