package fs;

import android.view.View;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.tribe.data.TribeVideoPublishParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final EditVideoParams f400384a;

    /* renamed from: b, reason: collision with root package name */
    public final int f400385b;

    /* renamed from: c, reason: collision with root package name */
    public final EditVideoParams.EditSource f400386c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f400389f;

    /* renamed from: i, reason: collision with root package name */
    public i f400392i;

    /* renamed from: j, reason: collision with root package name */
    public String f400393j;

    /* renamed from: k, reason: collision with root package name */
    public WeakReference<View> f400394k;

    /* renamed from: l, reason: collision with root package name */
    public g f400395l;

    /* renamed from: m, reason: collision with root package name */
    public PublishParam f400396m;

    /* renamed from: p, reason: collision with root package name */
    public String f400399p;

    /* renamed from: r, reason: collision with root package name */
    public HashMap<String, String> f400401r;

    /* renamed from: d, reason: collision with root package name */
    public final PublishVideoEntry f400387d = new PublishVideoEntry();

    /* renamed from: e, reason: collision with root package name */
    public int f400388e = 1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f400390g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f400391h = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f400397n = false;

    /* renamed from: o, reason: collision with root package name */
    public LpReportInfo_pf00064 f400398o = new LpReportInfo_pf00064();

    /* renamed from: s, reason: collision with root package name */
    public TribeVideoPublishParams f400402s = new TribeVideoPublishParams();

    /* renamed from: q, reason: collision with root package name */
    public long f400400q = System.currentTimeMillis();

    public b(EditVideoParams editVideoParams) {
        this.f400384a = editVideoParams;
        this.f400385b = editVideoParams.f204055d;
        this.f400386c = editVideoParams.f204059i;
    }

    public View a() {
        WeakReference<View> weakReference = this.f400394k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean b() {
        return this.f400389f || this.f400395l.f400420f > 0;
    }

    public String toString() {
        return "GenerateContext{, businessId='" + this.f400385b + "'}";
    }

    public void c(View view) {
        if (view == null) {
            this.f400394k = null;
        } else {
            this.f400394k = new WeakReference<>(view);
        }
    }
}
