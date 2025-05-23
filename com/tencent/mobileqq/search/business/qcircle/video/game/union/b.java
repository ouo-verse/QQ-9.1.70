package com.tencent.mobileqq.search.business.qcircle.video.game.union;

import android.view.View;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<ro2.b> f283085a = new ArrayList();

    public void a(ro2.b bVar) {
        this.f283085a.add(bVar);
    }

    public void b(HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp, int i3, int i16) {
        for (ro2.b bVar : this.f283085a) {
            if (bVar != null) {
                bVar.d(headTemplatePB$SearchTemplateResp, i3, i16);
            }
        }
        d();
    }

    public void c(View view) {
        for (ro2.b bVar : this.f283085a) {
            if (bVar != null) {
                bVar.e(view);
            }
        }
    }

    public void d() {
        ro2.a aVar = null;
        boolean z16 = true;
        for (ro2.b bVar : this.f283085a) {
            if (bVar instanceof ro2.a) {
                aVar = (ro2.a) bVar;
            } else if (!bVar.c()) {
                z16 = false;
            }
        }
        if (aVar != null && z16) {
            aVar.f();
        }
    }
}
