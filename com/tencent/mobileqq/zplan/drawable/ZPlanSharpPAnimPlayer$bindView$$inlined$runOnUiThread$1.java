package com.tencent.mobileqq.zplan.drawable;

import android.widget.ImageView;
import com.tencent.image.SharpDrawable;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/zplan/drawable/ZPlanSharpPAnimPlayer$runOnUiThread$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class ZPlanSharpPAnimPlayer$bindView$$inlined$runOnUiThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImageView f332813d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public final void run() {
        SharpDrawable a16 = a.a(null);
        if (a16 != null) {
            this.f332813d.setImageDrawable(a16);
        }
    }
}
