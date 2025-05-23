package com.qzone.reborn.base;

import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/base/QZoneShellActivity;", "Lcom/qzone/reborn/base/QZoneBaseActivity;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "a0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneShellActivity extends QZoneBaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.QZoneBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ViewModelStore viewModelStore;
        super.onDestroy();
        if (isChangingConfigurations() && com.qzone.reborn.configx.g.f53821a.b().l() && (viewModelStore = get_viewModelStore()) != null) {
            viewModelStore.clear();
        }
    }
}
