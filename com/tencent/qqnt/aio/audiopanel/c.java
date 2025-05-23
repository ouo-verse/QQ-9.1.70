package com.tencent.qqnt.aio.audiopanel;

import android.os.Build;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.guild.nt.misc.api.IPhoneStateMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0002\f\u0010B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R*\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/c;", "", "", "isCalling", "", "c", "d", "Lcom/tencent/qqnt/aio/audiopanel/c$b;", "listener", "g", "f", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi$a;", "a", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi$a;", "mPhoneStatusMonitor", "Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor;", "b", "Lcom/tencent/qav/monitor/PhoneStatusAudioModeMonitor;", "mPhoneStatusAudioModeMonitor", "Lcom/tencent/av/utils/PhoneStatusMonitor$a;", "Lcom/tencent/av/utils/PhoneStatusMonitor$a;", "mPhoneStatusListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "callbackList", "<init>", "()V", "e", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IPhoneStateMonitorApi.a mPhoneStatusMonitor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private PhoneStatusAudioModeMonitor mPhoneStatusAudioModeMonitor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final PhoneStatusMonitor.a mPhoneStatusListener = new PhoneStatusMonitor.a() { // from class: com.tencent.qqnt.aio.audiopanel.b
        @Override // com.tencent.av.utils.PhoneStatusMonitor.a
        public final void a(boolean z16) {
            c.e(c.this, z16);
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<b> callbackList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/c$b;", "", "", "isCalling", "", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(boolean isCalling);
    }

    private final void c(boolean isCalling) {
        ArrayList<b> arrayList;
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.i("AudioPanelPhoneStatusHelper", 1, "[handleIsCalling] isCalling = " + isCalling);
        }
        ArrayList<b> arrayList2 = this.callbackList;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z16 = false;
        }
        if (z16 || (arrayList = this.callbackList) == null) {
            return;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(isCalling);
        }
    }

    private final boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_panel_stop_while_calling_9020_117814097", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("AudioPanelPhoneStatusHelper", 1, "PhoneStatusListener onCallStateChanged " + z16);
        }
        this$0.c(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i("AudioPanelPhoneStatusHelper", 1, "onCallStateChanged " + z16);
        }
        this$0.c(z16);
    }

    public final void f() {
        if (!d()) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanelPhoneStatusHelper", 2, "release return, switch is off");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioPanelPhoneStatusHelper", 1, "[release]");
        }
        PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = this.mPhoneStatusAudioModeMonitor;
        if (phoneStatusAudioModeMonitor != null) {
            phoneStatusAudioModeMonitor.n(this.mPhoneStatusListener);
        }
        PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor2 = this.mPhoneStatusAudioModeMonitor;
        if (phoneStatusAudioModeMonitor2 != null) {
            phoneStatusAudioModeMonitor2.o(BaseApplication.context);
        }
        IPhoneStateMonitorApi.a aVar = this.mPhoneStatusMonitor;
        if (aVar != null) {
            aVar.release();
        }
        ArrayList<b> arrayList = this.callbackList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mPhoneStatusMonitor = null;
    }

    public final void g(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!d()) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanelPhoneStatusHelper", 2, "setPhoneCallMonitor return, switch is off");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioPanelPhoneStatusHelper", 1, "setPhoneCallMonitor start listener = " + listener);
        }
        if (this.mPhoneStatusMonitor == null) {
            this.mPhoneStatusMonitor = ((IPhoneStateMonitorApi) QRoute.api(IPhoneStateMonitorApi.class)).newPhoneStateMonitor(BaseApplication.getContext(), new IPhoneStateMonitorApi.b() { // from class: com.tencent.qqnt.aio.audiopanel.a
                @Override // com.tencent.mobileqq.guild.nt.misc.api.IPhoneStateMonitorApi.b
                public final void a(boolean z16) {
                    c.h(c.this, z16);
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 31) {
            PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = new PhoneStatusAudioModeMonitor();
            this.mPhoneStatusAudioModeMonitor = phoneStatusAudioModeMonitor;
            phoneStatusAudioModeMonitor.i(this.mPhoneStatusListener);
            phoneStatusAudioModeMonitor.j(BaseApplication.context);
        }
        ArrayList<b> arrayList = this.callbackList;
        if (arrayList != null) {
            arrayList.add(listener);
        }
    }
}
