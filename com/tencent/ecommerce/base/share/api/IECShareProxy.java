package com.tencent.ecommerce.base.share.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J>\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\nH&J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H&J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0016H&J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0018H&J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0018H&J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0010H&J\"\u0010\"\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010!H&J\u0012\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u0004H&\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/IECShareProxy;", "", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "title", "", "", "shareActions", "shareOperations", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "listener", "", "showShareActionSheet", "Lcom/tencent/ecommerce/base/share/api/e;", "param", "Lcom/tencent/ecommerce/base/share/api/IECShareCallback;", "callback", "requestCode", "Lcom/tencent/ecommerce/base/share/api/c;", "data", "shareMsgToQQ", "Lcom/tencent/ecommerce/base/share/api/d;", "shareMsgToQZone", "Lcom/tencent/ecommerce/base/share/api/f;", "", "shareMsgToWx", "shareMsgToTimeLine", "Lcom/tencent/ecommerce/base/share/api/g;", "shareMsgToXhs", "Landroid/app/Activity;", "Lcom/tencent/ecommerce/base/share/api/h;", "shortCutInfo", "Lcom/tencent/ecommerce/base/share/api/IECAddShortCutCallback;", "addShortCut", "filePath", "copyImageFileToMediaStorage", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECShareProxy {
    void addShortCut(@NotNull Activity activity, @NotNull ShortCutInfo shortCutInfo, @Nullable IECAddShortCutCallback callback);

    @Nullable
    String copyImageFileToMediaStorage(@NotNull String filePath);

    void shareMsgToQQ(@NotNull Context activity, int requestCode, @NotNull ECQQShareData data);

    void shareMsgToQZone(@NotNull Context activity, int requestCode, @NotNull ECQZoneShareData data);

    boolean shareMsgToTimeLine(@NotNull Context activity, @NotNull ECWxShareData data);

    boolean shareMsgToWx(@NotNull Context activity, @NotNull ECWxShareData data);

    void shareMsgToXhs(@NotNull Context activity, @NotNull ECXhsShareData data, @NotNull IECShareCallback callback);

    void showShareActionSheet(@NotNull Context activity, @NotNull ECShareParam param, @Nullable IECShareCallback callback);

    void showShareActionSheet(@NotNull Context activity, @NotNull String title, @NotNull List<Integer> shareActions, @NotNull List<Integer> shareOperations, @NotNull ECActionItemClickListener listener);
}
