package com.tencent.mobileqq.onlinestatus.shareposter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends e {
    private Drawable P0;

    public a(ShareActionSheetV2.Param param) {
        super(param);
    }

    @Override // com.tencent.mobileqq.onlinestatus.shareposter.e
    protected void A0(Drawable drawable) {
        ((ImageView) this.G.findViewById(R.id.fd9)).setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.onlinestatus.shareposter.e
    public void D0() {
        super.D0();
        ((URLImageView) this.G.findViewById(R.id.zyb)).setImageDrawable(this.P0);
    }

    public void E0(Drawable drawable) {
        this.P0 = drawable;
    }

    @Override // com.tencent.mobileqq.onlinestatus.shareposter.e
    protected int u0() {
        return R.layout.f167530dq1;
    }

    @Override // com.tencent.mobileqq.onlinestatus.shareposter.e
    protected void C0(AppInterface appInterface) {
    }
}
