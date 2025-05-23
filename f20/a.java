package f20;

import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements IAEEditorGenerateResultListener {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QCircleAEEditorGenerateResultListener> f397706a;

    public a(QCircleAEEditorGenerateResultListener qCircleAEEditorGenerateResultListener) {
        this.f397706a = new WeakReference<>(qCircleAEEditorGenerateResultListener);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorGenerateResultListener
    public void onAETavSessionExportCompleted(String str, LocalMediaInfo localMediaInfo) {
        QCircleAEEditorGenerateResultListener qCircleAEEditorGenerateResultListener = this.f397706a.get();
        if (qCircleAEEditorGenerateResultListener != null) {
            qCircleAEEditorGenerateResultListener.onAETavSessionExportCompleted(str, localMediaInfo);
        }
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorGenerateResultListener
    public void onAETavSessionExportError(String str, long j3, String str2) {
        QCircleAEEditorGenerateResultListener qCircleAEEditorGenerateResultListener = this.f397706a.get();
        if (qCircleAEEditorGenerateResultListener != null) {
            qCircleAEEditorGenerateResultListener.onAETavSessionExportError(str, j3, str2);
        }
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorGenerateResultListener
    public void onAETavSessionExporting(String str, float f16, LocalMediaInfo localMediaInfo, float f17) {
        QCircleAEEditorGenerateResultListener qCircleAEEditorGenerateResultListener = this.f397706a.get();
        if (qCircleAEEditorGenerateResultListener != null) {
            qCircleAEEditorGenerateResultListener.onAETavSessionExporting(str, f16);
        }
    }
}
