package com.tencent.ecommerce.base.share.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J<\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0018H\u0016J\"\u0010 \u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u0004H\u0016J \u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/a;", "Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "title", "", "", "shareActions", "shareOperations", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "listener", "", "showShareActionSheet", "Lcom/tencent/ecommerce/base/share/api/e;", "param", "Lcom/tencent/ecommerce/base/share/api/IECShareCallback;", "callback", "requestCode", "Lcom/tencent/ecommerce/base/share/api/c;", "data", "shareMsgToQQ", "Lcom/tencent/ecommerce/base/share/api/d;", "shareMsgToQZone", "Lcom/tencent/ecommerce/base/share/api/f;", "", "shareMsgToWx", "shareMsgToTimeLine", "Landroid/app/Activity;", "Lcom/tencent/ecommerce/base/share/api/h;", "shortCutInfo", "Lcom/tencent/ecommerce/base/share/api/IECAddShortCutCallback;", "addShortCut", "filePath", "copyImageFileToMediaStorage", "Lcom/tencent/ecommerce/base/share/api/g;", "shareMsgToXhs", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECShareProxy {
    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    @Nullable
    public String copyImageFileToMediaStorage(@NotNull String filePath) {
        return null;
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public boolean shareMsgToTimeLine(@NotNull Context activity, @NotNull ECWxShareData data) {
        return true;
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public boolean shareMsgToWx(@NotNull Context activity, @NotNull ECWxShareData data) {
        return true;
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void showShareActionSheet(@NotNull Context activity, @NotNull ECShareParam param, @Nullable IECShareCallback callback) {
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void showShareActionSheet(@NotNull Context activity, @NotNull String title, @NotNull List<Integer> shareActions, @NotNull List<Integer> shareOperations, @NotNull ECActionItemClickListener listener) {
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void addShortCut(@NotNull Activity activity, @NotNull ShortCutInfo shortCutInfo, @Nullable IECAddShortCutCallback callback) {
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void shareMsgToQQ(@NotNull Context activity, int requestCode, @NotNull ECQQShareData data) {
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void shareMsgToQZone(@NotNull Context activity, int requestCode, @NotNull ECQZoneShareData data) {
    }

    @Override // com.tencent.ecommerce.base.share.api.IECShareProxy
    public void shareMsgToXhs(@NotNull Context activity, @NotNull ECXhsShareData data, @NotNull IECShareCallback callback) {
    }
}
