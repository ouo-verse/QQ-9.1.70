package com.qzone.publish.ui.state;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.reborn.util.l;
import com.qzone.util.SystemTools;
import com.qzone.widget.ExtendEditText;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends a {

    /* renamed from: j, reason: collision with root package name */
    private String f52078j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<String> f52079k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        super(qZonePublishMoodBaseActivity);
    }

    private boolean s() {
        ExtendEditText extendEditText;
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity != null && (extendEditText = qZonePublishMoodBaseActivity.f45104j0) != null) {
            String obj = extendEditText.getText().toString();
            String str = this.f52078j;
            if (str != null && obj != null && !obj.equals(str)) {
                return true;
            }
            ArrayList<String> oj5 = qZonePublishMoodBaseActivity.oj();
            ArrayList<String> arrayList = this.f52079k;
            if (arrayList != null) {
                if (arrayList.size() != oj5.size()) {
                    return true;
                }
                for (int i3 = 0; i3 < this.f52079k.size(); i3++) {
                    if (!this.f52079k.get(i3).equals(oj5.get(i3))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.qzone.publish.ui.state.a
    public void c() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null || qZonePublishMoodBaseActivity.oj() == null) {
            return;
        }
        Iterator<String> it = qZonePublishMoodBaseActivity.oj().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            ImageLoader.getInstance().clear(it.next());
            z16 = true;
        }
        if (z16) {
            SystemTools.d();
        }
    }

    @Override // com.qzone.publish.ui.state.a
    public int h() {
        return 1;
    }

    @Override // com.qzone.publish.ui.state.a
    public void i(Intent intent) {
        super.i(intent);
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null || intent == null) {
            return;
        }
        l lVar = l.f59550a;
        String l3 = lVar.l(qZonePublishMoodBaseActivity.bj(), intent);
        if (!TextUtils.isEmpty(l3)) {
            if (qZonePublishMoodBaseActivity.oj() == null) {
                qZonePublishMoodBaseActivity.dm(new ArrayList<>());
            }
            if (!qZonePublishMoodBaseActivity.oj().contains(l3)) {
                qZonePublishMoodBaseActivity.oj().add(l3);
                qZonePublishMoodBaseActivity.gi(l3);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            this.f52079k = arrayList;
            arrayList.addAll(qZonePublishMoodBaseActivity.oj());
            qZonePublishMoodBaseActivity.Dm();
        }
        String G = lVar.G(qZonePublishMoodBaseActivity.bj(), intent);
        if (!TextUtils.isEmpty(G)) {
            qZonePublishMoodBaseActivity.setTitle(G);
        } else {
            qZonePublishMoodBaseActivity.setTitle(R.string.i1v);
        }
        String k3 = lVar.k(qZonePublishMoodBaseActivity.bj(), intent);
        if (!TextUtils.isEmpty(k3)) {
            qZonePublishMoodBaseActivity.f45104j0.setText(k3);
            qZonePublishMoodBaseActivity.f45104j0.setSelection(k3.length());
            this.f52078j = k3;
        }
        qZonePublishMoodBaseActivity.Wm();
        qZonePublishMoodBaseActivity.ui();
        qZonePublishMoodBaseActivity.qi();
    }

    @Override // com.qzone.publish.ui.state.a
    public void r() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        if (s() && qZonePublishMoodBaseActivity.Wj()) {
            f();
        } else {
            qZonePublishMoodBaseActivity.finish();
        }
    }
}
