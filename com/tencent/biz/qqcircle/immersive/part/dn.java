package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import androidx.lifecycle.Observer;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dn extends u {

    /* renamed from: d, reason: collision with root package name */
    private final Class<? extends com.tencent.biz.qqcircle.viewmodels.a> f87987d;

    public dn(Class<? extends com.tencent.biz.qqcircle.viewmodels.a> cls) {
        this.f87987d = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z9(Integer num) {
        broadcastMessage("layer_notify_visit_count_part_gone", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QFSMiddlePageShowTypePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ((com.tencent.biz.qqcircle.immersive.layer.base.e) getViewModel(this.f87987d)).a2().observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.dm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dn.this.z9((Integer) obj);
            }
        });
    }
}
