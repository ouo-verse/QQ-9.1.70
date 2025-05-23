package ha0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase$StPolyLike;
import uq3.q;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static String f404605c = "QCirclePolyLikeInfoManger";

    /* renamed from: d, reason: collision with root package name */
    private static a f404606d;

    /* renamed from: a, reason: collision with root package name */
    private List<QQCircleFeedBase$StPolyLike> f404607a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private float f404608b = 0.0f;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f404606d == null) {
                f404606d = new a();
            }
            aVar = f404606d;
        }
        return aVar;
    }

    public void b() {
        this.f404607a.clear();
        this.f404608b = 0.0f;
    }

    public void c(List<QQCircleFeedBase$StPolyLike> list) {
        this.f404607a.clear();
        StringBuilder sb5 = new StringBuilder();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike = list.get(i3);
                this.f404607a.add(QCirclePluginUtil.deepCopyPolyLike(qQCircleFeedBase$StPolyLike));
                sb5.append(new String(qQCircleFeedBase$StPolyLike.toByteArray()));
                sb5.append("#");
            }
            if (!TextUtils.isEmpty(sb5.toString())) {
                QLog.d(f404605c, 4, "set poly success:" + this.f404607a.size());
                q.c(QCircleApplication.APP, "qcircle_stpoly_key", sb5.toString());
            }
        }
    }

    public void d(float f16) {
        if (f16 < 0.0f) {
            this.f404608b = 0.0f;
        } else {
            this.f404608b = f16;
        }
        QLog.d(f404605c, 1, "updateCurrentMoney result: " + this.f404608b);
    }
}
