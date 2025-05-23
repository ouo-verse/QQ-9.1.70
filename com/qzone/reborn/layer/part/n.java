package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/layer/part/n;", "Lcom/qzone/reborn/layer/part/am;", "Landroid/os/Bundle;", "data", "", "initIntentData", "Luk/a;", "aa", "", "ua", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends am {
    @Override // com.qzone.reborn.layer.part.am, com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected uk.a aa() {
        ViewModel viewModel = getViewModel(uk.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneLayerA\u2026ectViewModel::class.java)");
        return (uk.a) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart, com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        uk.c cVar = (uk.c) getViewModel(uk.c.class);
        if (cVar != null) {
            Activity activity = getActivity();
            cVar.g2(activity != null ? activity.getIntent() : null);
        }
    }

    @Override // com.qzone.reborn.layer.part.am, com.qzone.reborn.layer.part.QZoneFeedxLayerControlPart
    protected boolean ua() {
        return true;
    }
}
