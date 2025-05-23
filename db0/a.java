package db0;

import android.view.View;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a<T> implements ReqInterceptor<T, BaseSenderChain> {

    /* renamed from: a, reason: collision with root package name */
    private QCircleLpReportDc05501.DataBuilder f393485a;

    /* renamed from: b, reason: collision with root package name */
    private QCircleLpReportDc05507.DataBuilder f393486b;

    /* renamed from: c, reason: collision with root package name */
    protected String f393487c;

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<View> f393488d;

    /* renamed from: e, reason: collision with root package name */
    protected Map<String, Object> f393489e;

    public QCircleLpReportDc05501.DataBuilder a() {
        return this.f393485a;
    }

    public QCircleLpReportDc05507.DataBuilder b() {
        return this.f393486b;
    }

    public void c(QCircleLpReportDc05507.DataBuilder dataBuilder) {
        this.f393486b = dataBuilder;
    }

    public void d(String str, View view, Map<String, Object> map) {
        this.f393487c = str;
        this.f393488d = new WeakReference<>(view);
        this.f393489e = map;
    }
}
