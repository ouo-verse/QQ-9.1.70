package i70;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import java.lang.ref.WeakReference;
import m70.c;
import uz3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends k {

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f407328c;

    public a(Context context) {
        this.f407328c = null;
        this.f407328c = new WeakReference<>(context);
    }

    @Override // uz3.f
    public boolean a(com.tencent.rfw.barrage.data.a aVar) {
        return aVar instanceof com.tencent.rfw.barrage.data.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // uz3.k
    public void j(int i3, k.a aVar, RFWViewBarrage rFWViewBarrage) {
        if (!(aVar instanceof m70.b)) {
            QLog.d("QDM-QFSBarrageHolderAdapter", 1, "[onBindViewHolder] current view holder not is FSBaseBarrageHolder type.");
            return;
        }
        if (rFWViewBarrage == null) {
            QLog.d("QDM-QFSBarrageHolderAdapter", 1, "[onBindViewHolder] danmaku should not be null.");
            return;
        }
        m70.a aVar2 = (m70.a) rFWViewBarrage.l();
        if (aVar2 == null) {
            QLog.d("QDM-QFSBarrageHolderAdapter", 1, "[onBindViewHolder] param should not be null.");
        } else {
            ((m70.b) aVar).k(aVar2);
        }
    }

    public k.a n(@NonNull Context context) {
        try {
            return new c(context);
        } catch (Throwable th5) {
            QLog.e("QDM-QFSBarrageHolderAdapter", 1, "[createNormalBarrageHolder] error: ", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context o() {
        WeakReference<Context> weakReference = this.f407328c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
