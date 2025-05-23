package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.homepage.ui.Facade.ui.FacadeViewDialog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cf extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f55088d;

    /* renamed from: e, reason: collision with root package name */
    private long f55089e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55090f;

    /* renamed from: h, reason: collision with root package name */
    private int f55091h;

    /* renamed from: i, reason: collision with root package name */
    private FacadeViewDialog f55092i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements FacadeViewDialog.g {
        a() {
        }

        @Override // com.qzone.homepage.ui.Facade.ui.FacadeViewDialog.g
        public void onEnter() {
            cf.this.C9();
        }
    }

    private void D9() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_FACADE, QzoneConfig.SECONDARY_QZFACADE_VISIBLE, "1").equals("1")) {
            try {
                FacadeViewDialog f06 = FacadeViewDialog.f0(getActivity());
                this.f55092i = f06;
                f06.i0(this.f55089e);
                this.f55092i.g0(new a());
                this.f55092i.show();
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.util.j.d("crash", "", e16);
            }
        }
    }

    protected void C9() {
        com.qzone.proxy.feedcomponent.util.j.f("QZoneUserHomeFacadePart", "onFacadeDismiss: ");
        broadcastMessage("SHOW_PLUS_ICON_LONG_CLICK_BUBBLE", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeFacadePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f55088d = wVar;
        this.f55089e = wVar.getMUin();
        this.f55091h = this.f55088d.getMEntryType();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        if (this.f55090f) {
            broadcastMessage("SHOW_PLUS_ICON_LONG_CLICK_BUBBLE", null);
            return;
        }
        com.qzone.reborn.feedx.viewmodel.w wVar = this.f55088d;
        if (wVar != null && wVar.getInitBean() != null && !this.f55088d.getInitBean().isShowFacade()) {
            broadcastMessage("SHOW_PLUS_ICON_LONG_CLICK_BUBBLE", null);
        } else {
            this.f55090f = true;
            D9();
        }
    }
}
