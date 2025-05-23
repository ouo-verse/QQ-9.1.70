package b23;

import android.R;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import fa1.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements b {
    @Override // fa1.b
    public int getType() {
        return R.layout.activity_list_item;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(context, "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_novel_audio&bundle_name=vas_qqvip_novel_audio&kr_turbo_display=1&modal_mode=1&from=1", null);
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
