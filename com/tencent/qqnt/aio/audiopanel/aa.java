package com.tencent.qqnt.aio.audiopanel;

import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001\u0004B\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J>\u0010\u0016\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0017\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u001c\u0010\u0019\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u001b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J&\u0010\u001d\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/aa;", "Lcom/tencent/mobileqq/ptt/d$a;", "recordPanel", "", "a", "onInitSuccess", "", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "param", "onInitFailed", "onRecorderAbnormal", "", "state", "onRecorderVolumeStateChanged", "", "sliceData", "size", "maxAmplitude", "", "time", "p", "onRecorderSilceEnd", "onRecorderPrepare", "onRecorderStart", "onBeginReceiveData", "totalTime", "onRecorderEnd", "e", "onRecorderError", "Lcom/tencent/qqnt/aio/audiopanel/ac;", "d", "Lcom/tencent/qqnt/aio/audiopanel/ac;", "mRecordChangeListener", "Lcom/tencent/mobileqq/ptt/d$a;", "<init>", "(Lcom/tencent/qqnt/aio/audiopanel/ac;)V", "f", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aa implements d.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ac mRecordChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private d.a recordPanel;

    public aa(ac acVar) {
        this.mRecordChangeListener = acVar;
    }

    public final void a(d.a recordPanel) {
        Intrinsics.checkNotNullParameter(recordPanel, "recordPanel");
        this.recordPanel = recordPanel;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String path, RecordParams.RecorderParam p16) {
        return k.b();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String path, RecordParams.RecorderParam param) {
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onInitFailed(path, param);
        }
        QLog.e("PttRecordCallback", 1, "onInitFailed");
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onInitSuccess();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onInitSuccess");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String path, RecordParams.RecorderParam param) {
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onRecorderAbnormal(path, param);
        }
        QLog.e("PttRecordCallback", 1, "onRecorderAbnormal");
        if (path != null) {
            new File(path).delete();
        }
        ac acVar = this.mRecordChangeListener;
        if (acVar != null) {
            acVar.a();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String path, RecordParams.RecorderParam param, String e16) {
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onRecorderError(path, param, e16);
        }
        QLog.e("PttRecordCallback", 1, "onRecorderError", e16);
        if (path != null) {
            new File(path).delete();
        }
        ac acVar = this.mRecordChangeListener;
        if (acVar != null) {
            acVar.a();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onRecorderStart();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderStart");
        }
        ac acVar = this.mRecordChangeListener;
        if (acVar == null) {
            return 0;
        }
        acVar.b();
        return 0;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int state) {
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onRecorderVolumeStateChanged(state);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderVolumeStateChanged, " + state);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(String path, RecordParams.RecorderParam param) {
        if (param != null) {
            Intrinsics.checkNotNull(path);
            k.d(path, param);
        }
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onRecorderPrepare(path, param);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderPrepare");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String path, byte[] sliceData, int size, int maxAmplitude, double time, RecordParams.RecorderParam p16) {
        Intrinsics.checkNotNull(p16);
        if (!(p16.f307260m == null)) {
            com.tencent.mobileqq.streamtransfile.b.e(path, sliceData, size, (short) 0);
        } else {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(path, sliceData, size);
        }
        d.a aVar = this.recordPanel;
        if (aVar != null) {
            aVar.onRecorderSilceEnd(path, sliceData, size, maxAmplitude, time, p16);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(String path, RecordParams.RecorderParam p16, double totalTime) {
        if (path != null && p16 != null) {
            k.a(path, false, p16);
        }
        if (path != null && new File(path).length() > 0) {
            d.a aVar = this.recordPanel;
            if (aVar != null) {
                aVar.onRecorderEnd(path, p16, totalTime);
            }
        } else {
            QLog.e("PttRecordCallback", 1, "onRecorderEnd but file length is 0, path=" + path);
            d.a aVar2 = this.recordPanel;
            if (aVar2 != null) {
                aVar2.onRecorderAbnormal(path, p16);
            }
            if (path != null) {
                new File(path).delete();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderEnd " + (p16 != null ? p16.D : null));
        }
        ac acVar = this.mRecordChangeListener;
        if (acVar != null) {
            acVar.a();
        }
    }
}
