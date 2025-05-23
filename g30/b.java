package g30;

import androidx.annotation.WorkerThread;
import circlesearch.CircleSearchExhibition$StSuggestionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends e30.a<CircleSearchExhibition$StSuggestionInfo> {

    /* renamed from: c, reason: collision with root package name */
    public static List<a> f401190c;

    static {
        ArrayList arrayList = new ArrayList();
        f401190c = arrayList;
        arrayList.add(new a());
    }

    public b(CircleSearchExhibition$StSuggestionInfo circleSearchExhibition$StSuggestionInfo) {
        super(circleSearchExhibition$StSuggestionInfo);
    }

    private void e(b bVar, CircleSearchExhibition$StSuggestionInfo circleSearchExhibition$StSuggestionInfo) {
        if (bVar != null && circleSearchExhibition$StSuggestionInfo != null) {
            Iterator<a> it = f401190c.iterator();
            while (it.hasNext()) {
                it.next().b(bVar);
            }
        }
    }

    @WorkerThread
    public static ArrayList<b> f(List<CircleSearchExhibition$StSuggestionInfo> list) {
        ArrayList<b> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            Iterator<CircleSearchExhibition$StSuggestionInfo> it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new b(it.next()).d());
                } catch (Exception e16) {
                    QLog.w("StSuggestionInfoBlockData", 1, "transForm exception:" + e16.getMessage());
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b d() {
        e(this, (CircleSearchExhibition$StSuggestionInfo) this.f395525b);
        return this;
    }
}
