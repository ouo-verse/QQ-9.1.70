package com.tencent.qqnt.photopanel.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/photopanel/api/impl/PhotoPanelApiNtImpl;", "Lcom/tencent/qqnt/photopanel/api/IPhotoPanelApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "selectMedias", "", "isHighQuality", "", "onEditBtnClicked", "Landroid/content/Intent;", "intent", "fillIntentForJumpAlbum", "fillIntentForJumpPreview", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "comment", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "listener", "onUp", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PhotoPanelApiNtImpl implements IPhotoPanelApi {
    static IPatchRedirector $redirector_;

    public PhotoPanelApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void fillIntentForJumpAlbum(@NotNull Intent intent, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) aioContext);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        }
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void fillIntentForJumpPreview(@NotNull Intent intent, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) aioContext);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        }
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void onEditBtnClicked(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull List<LocalMediaInfo> selectMedias, boolean isHighQuality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aioContext, selectMedias, Boolean.valueOf(isHighQuality));
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(selectMedias, "selectMedias");
        Toast.makeText(BaseApplication.context, "NT\u6682\u4e0d\u652f\u6301\u7f16\u8f91\u529f\u80fd", 1).show();
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void onUp(@NotNull Activity activity, @NotNull String comment, @NotNull com.tencent.qqnt.qbasealbum.preview.fragment.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, comment, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}
