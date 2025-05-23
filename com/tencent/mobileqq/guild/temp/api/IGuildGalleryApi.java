package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&JX\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H&J\\\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H&J8\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0018H&\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildGalleryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterFileBrowser", "", "appRuntime", "Lmqq/app/AppRuntime;", "context", "Landroid/content/Context;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "enterImagePreview", "app", "view", "Landroid/view/View;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "isOnePic", "", "extras", "Landroid/os/Bundle;", "aioRichMediaList", "", "enterVideoPreview", "playPosition", "", "isMute", "isOneItemOnly", "extraInfo", "onMsgRevoke", "msgRecordList", "openImagePreview", "url", "", "w", "", h.F, "id", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildGalleryApi extends QRouteApi {
    void enterFileBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull MsgRecord msgRecord);

    void enterImagePreview(@NotNull AppRuntime app, @Nullable Context context, @Nullable View view, @NotNull MsgRecord msgRecord, @Nullable PicElement picElement, boolean isOnePic, @Nullable Bundle extras, @Nullable List<MsgRecord> aioRichMediaList);

    void enterVideoPreview(@NotNull AppRuntime app, @NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable View view, long playPosition, boolean isMute, boolean isOneItemOnly, @Nullable Bundle extraInfo, @Nullable List<MsgRecord> aioRichMediaList);

    void onMsgRevoke(@NotNull List<MsgRecord> msgRecordList);

    void openImagePreview(@NotNull AppRuntime app, @NotNull Context context, @NotNull String url, int w3, int h16, long id5);
}
