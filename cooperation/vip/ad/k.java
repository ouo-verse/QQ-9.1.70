package cooperation.vip.ad;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.home.chats.biz.tianshu.TianShuConversationThirdView;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.pb.TianShuAccess;

/* compiled from: P */
/* loaded from: classes28.dex */
public class k extends com.tencent.mobileqq.armap.d {
    private AnimationDrawableProxyView U;
    private TianShuAccess.AdItem V;

    public k(View view) {
        super(view);
    }

    public void n() {
        try {
            int dpToPx = ImmersiveUtils.dpToPx(375.0f);
            int dpToPx2 = ImmersiveUtils.dpToPx(30.0f);
            View view = this.J;
            if (view instanceof TianShuConversationThirdView) {
                ((TianShuConversationThirdView) view).a(dpToPx, dpToPx2);
            }
            c(0, 0, dpToPx, dpToPx2, this.J);
        } catch (Throwable th5) {
            QLog.e("ConvActivePendantHolderBase", 1, th5, new Object[0]);
        }
    }

    public void o(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            QLog.e("ConvActivePendantHolderBase", 2, "showLayer with null ");
            return;
        }
        this.V = adItem;
        String str = null;
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            if (mapEntry.key.get().equals("image")) {
                str = mapEntry.value.get();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", 1);
            URLDrawable apngURLDrawable = VasApngUtil.getApngURLDrawable(str, new int[]{2}, com.tencent.mobileqq.urldrawable.b.f306350a, bundle, null);
            this.f259364m = apngURLDrawable;
            if (apngURLDrawable != null) {
                this.U = new AnimationDrawableProxyView(this.I, this.J, this.f259364m);
                n();
                TianShuAccess.AdItem adItem2 = this.V;
                if (adItem2 != null) {
                    w.a(String.valueOf(adItem2.iAdId.get()), 101, this.V.traceinfo.get());
                }
            }
        }
    }
}
