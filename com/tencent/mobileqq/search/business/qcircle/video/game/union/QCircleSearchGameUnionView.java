package com.tencent.mobileqq.search.business.qcircle.video.game.union;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;
import java.util.HashMap;
import java.util.Iterator;
import lo2.h;
import org.json.JSONException;
import org.json.JSONObject;
import ro2.c;
import ro2.d;
import ro2.e;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QCircleSearchGameUnionView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private final b f283079d;

    /* renamed from: e, reason: collision with root package name */
    private h f283080e;

    /* renamed from: f, reason: collision with root package name */
    private String f283081f;

    public QCircleSearchGameUnionView(Context context) {
        super(context);
        this.f283079d = new b();
    }

    public void a(h hVar, final int i3) {
        if (this.f283080e == hVar) {
            return;
        }
        this.f283080e = hVar;
        final HeadTemplatePB$SearchTemplateResp W = hVar.W();
        this.f283079d.b(W, 0, i3);
        this.f283081f = W.report_info.get().eid.get();
        String str = W.report_info.get().report_info.get();
        if (str.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                String optString = jSONObject.optString(str2);
                if (TextUtils.isEmpty(optString)) {
                    QLog.d("QCircleSearchGameUnionView", 1, "#report: key=" + str2 + ", value is empty");
                } else {
                    hashMap.put(str2, optString);
                }
            }
            post(new Runnable() { // from class: com.tencent.mobileqq.search.business.qcircle.video.game.union.QCircleSearchGameUnionView.1
                @Override // java.lang.Runnable
                public void run() {
                    so2.a.b(QCircleSearchGameUnionView.this, W.report_info.get(), i3, false);
                    VideoReport.reportEvent("imp", QCircleSearchGameUnionView.this, hashMap);
                }
            });
        } catch (JSONException e16) {
            QLog.e("QCircleSearchGameUnionView", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, int i3) {
        this.f283079d.a(new ro2.a());
        this.f283079d.a(new d());
        this.f283079d.a(new e());
        this.f283079d.c(this);
        c cVar = new c();
        cVar.e(findViewById(R.id.f53112bm));
        this.f283079d.a(cVar);
        findViewById(R.id.bnd).setVisibility(0);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public QCircleSearchGameUnionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f283079d = new b();
    }

    public QCircleSearchGameUnionView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f283079d = new b();
    }
}
