package com.tencent.mobileqq.richmedia.depend;

import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/richmedia/depend/d;", "Lcom/tencent/mobileqq/richmedia/depend/c;", "", "mediaId", "Lcom/tencent/mobileqq/richmedia/depend/RichMediaDownloadType;", "type", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "L1", "cancelDownload", ICustomDataEditor.STRING_PARAM_8, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "C0", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface d extends c {
    void C0(@NotNull String mediaId);

    void L1(@NotNull String mediaId, @NotNull RichMediaDownloadType type, @Nullable Activity activity);

    void cancelDownload(@NotNull String mediaId);

    void onDestroy();

    void s8(@NotNull String mediaId);
}
