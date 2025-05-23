package nw;

import android.content.Context;
import android.view.View;
import com.tencent.av.ui.AVActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a extends Part {

    /* renamed from: d, reason: collision with root package name */
    protected String f421444d = "AVPart";

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        this.f421444d = getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AVActivity x9(WeakReference<Context> weakReference) {
        if (weakReference != null && (weakReference.get() instanceof AVActivity)) {
            return (AVActivity) weakReference.get();
        }
        return null;
    }

    public void onDestroy() {
    }

    public void z9(Context context, AppInterface appInterface) {
    }
}
