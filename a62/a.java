package a62;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.Proteus;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ProteusConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.kandian.biz.pts.util.g;
import com.tencent.mobileqq.kandian.biz.pts.util.h;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends VafContext {
    public static void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float fontLevel = FontSettingManager.getFontLevel() / 16.0f;
        if (fontLevel == 0.0f) {
            fontLevel = 1.0f;
        }
        float f16 = displayMetrics.density / fontLevel;
        int i3 = displayMetrics.widthPixels;
        b();
        Utils.init(f16, i3);
    }

    private static void b() {
        Proteus.getInstance().init(new ProteusConfig.ProteusConfigBuilder().withDrawableHelper(new g()).withCustomMethodInterface(new h()).withLogger(new com.tencent.mobileqq.kandian.biz.pts.util.a()).build());
    }
}
