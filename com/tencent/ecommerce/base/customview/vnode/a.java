package com.tencent.ecommerce.base.customview.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.customview.view.PTSNinePatchView;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends PTSNodeVirtual {

    /* renamed from: a, reason: collision with root package name */
    private String f100663a;

    /* compiled from: P */
    /* renamed from: com.tencent.ecommerce.base.customview.vnode.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C1026a implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            return new PTSNinePatchView((a) pTSNodeVirtual);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            return new a(pTSAppInstance);
        }
    }

    protected a(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "view", "qq-dot-nine-view");
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        super.onParseValueFinished();
        a(this.f100663a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        if (super.setAttribute(str, obj)) {
            return true;
        }
        if (!"src".equalsIgnoreCase(str) || !(obj instanceof String)) {
            return false;
        }
        this.f100663a = (String) obj;
        return true;
    }

    private void a(String str) {
        if (str != null) {
            PTSNinePatchView pTSNinePatchView = (PTSNinePatchView) getView();
            if (str.startsWith("http://") || str.startsWith("https://")) {
                return;
            }
            pTSNinePatchView.setBackgroundResource(getContext().getResources().getIdentifier(str.split("\\.")[0], "drawable", getContext().getPackageName()));
            pTSNinePatchView.setPadding(0, 2, 0, 2);
        }
    }
}
