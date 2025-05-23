package f20;

import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements IAEEditorUICallbackListener {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QCircleAEEditorUICallbackListener> f397707a;

    public b(QCircleAEEditorUICallbackListener qCircleAEEditorUICallbackListener) {
        this.f397707a = new WeakReference<>(qCircleAEEditorUICallbackListener);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorUICallbackListener
    public void deleteMedia(int i3) {
        QCircleAEEditorUICallbackListener qCircleAEEditorUICallbackListener = this.f397707a.get();
        if (qCircleAEEditorUICallbackListener != null) {
            qCircleAEEditorUICallbackListener.deleteMedia(i3);
        }
    }
}
