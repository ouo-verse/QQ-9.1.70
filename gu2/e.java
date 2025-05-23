package gu2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.tvideo.ad.bridge.AdImageView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.data.AdDialogData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends hv2.f {
    @Override // hv2.f
    public tv2.a a(Context context, AttributeSet attributeSet) {
        return new AdImageView(context, attributeSet);
    }

    @Override // hv2.f
    public hv2.a b() {
        return new m();
    }

    @Override // hv2.f
    public boolean c() {
        return true;
    }

    @Override // hv2.f
    public Dialog d(Activity activity, AdDialogData adDialogData) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, adDialogData.m(), adDialogData.o(), adDialogData.s(), adDialogData.r(), adDialogData.n());
        createCustomDialog.setOnCancelListener(adDialogData.l());
        createCustomDialog.setOnDismissListener(adDialogData.p());
        createCustomDialog.setOnShowListener(adDialogData.q());
        createCustomDialog.show();
        return createCustomDialog;
    }
}
