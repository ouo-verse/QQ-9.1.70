package i6;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.qzone.component.banner.general.builder.GeneralModelBaseCardView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final List<j6.a> f407291a;

    static {
        ArrayList arrayList = new ArrayList();
        f407291a = arrayList;
        arrayList.add(new com.qzone.component.banner.general.builder.bigcard.a());
        arrayList.add(new com.qzone.component.banner.general.builder.bigcard.e());
    }

    public static GeneralModelBaseCardView a(ViewGroup viewGroup, a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.p())) {
            for (j6.a aVar2 : f407291a) {
                if (TextUtils.equals(aVar.p(), aVar2.b())) {
                    GeneralModelBaseCardView a16 = aVar2.a(viewGroup.getContext(), aVar);
                    QLog.d("GeneralModelViewFactory", 1, "generateModelCardView cardBuilder=" + aVar2 + ",cardView=" + a16);
                    viewGroup.addView(a16);
                    return a16;
                }
            }
            QLog.w("GeneralModelViewFactory", 1, "generateModelCardView  not find cardView, modelId = " + aVar.p());
            return null;
        }
        QLog.e("GeneralModelViewFactory", 1, "generateModelCardView  modelId == null");
        return null;
    }
}
