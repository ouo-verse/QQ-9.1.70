package com.qzone.reborn.feedx.part;

import android.content.Intent;
import com.tencent.gdtad.IGdtActivityHandler;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedx/part/n;", "Lcom/qzone/reborn/feedx/part/g;", "", "getLogTag", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends g {
    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneFeedxAdActivityResultPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ((IGdtActivityHandler) QRoute.api(IGdtActivityHandler.class)).onActivityResult(new com.tencent.qqnt.avatar.meta.refresh.c(getActivity()), requestCode, resultCode, data);
    }
}
