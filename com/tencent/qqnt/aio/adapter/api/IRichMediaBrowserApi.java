package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H&Jh\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0016H&J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH&J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H&J*\u0010\"\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H&Jb\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018H&\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IRichMediaBrowserApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterAIOEmotionPreview", "", "app", "Lmqq/app/AppRuntime;", "context", "Landroid/content/Context;", "aioMsgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "view", "Landroid/view/View;", "extras", "Landroid/os/Bundle;", "enterFileBrowser", "appRuntime", "source", "", "enterImagePreview", "picMsgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "isOnePic", "", "aioRichMediaList", "", "previewGIFWithEmotionViewer", "enterMultiImagePreviewWithPath", "currentIndex", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "enterMultiPicBrowser", "enterOnlineFileBrowser", "fileElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "enterPttPreview", "pttElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "enterVideoPreview", "playPosition", "", "isMute", "isOneItemOnly", "extraInfo", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IRichMediaBrowserApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IRichMediaBrowserApi iRichMediaBrowserApi, AppRuntime appRuntime, Context context, View view, AIOMsgItem aIOMsgItem, MsgElement msgElement, boolean z16, Bundle bundle, List list, boolean z17, int i3, Object obj) {
            View view2;
            MsgElement msgElement2;
            Bundle bundle2;
            List list2;
            boolean z18;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    view2 = null;
                } else {
                    view2 = view;
                }
                if ((i3 & 16) != 0) {
                    msgElement2 = null;
                } else {
                    msgElement2 = msgElement;
                }
                if ((i3 & 64) != 0) {
                    bundle2 = null;
                } else {
                    bundle2 = bundle;
                }
                if ((i3 & 128) != 0) {
                    list2 = null;
                } else {
                    list2 = list;
                }
                if ((i3 & 256) != 0) {
                    z18 = true;
                } else {
                    z18 = z17;
                }
                iRichMediaBrowserApi.enterImagePreview(appRuntime, context, view2, aIOMsgItem, msgElement2, z16, bundle2, list2, z18);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterImagePreview");
        }
    }

    void enterAIOEmotionPreview(@NotNull AppRuntime app, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem, @Nullable View view, @Nullable Bundle extras);

    void enterFileBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem);

    void enterFileBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem, int source);

    void enterImagePreview(@NotNull AppRuntime app, @NotNull Context context, @Nullable View view, @NotNull AIOMsgItem aioMsgItem, @Nullable MsgElement picMsgElement, boolean isOnePic, @Nullable Bundle extras, @Nullable List<? extends AIOMsgItem> aioRichMediaList, boolean previewGIFWithEmotionViewer);

    void enterMultiImagePreviewWithPath(@NotNull View view, int currentIndex, @NotNull MsgRecord msgRecord);

    void enterMultiPicBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem);

    void enterOnlineFileBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull FileElement fileElement);

    void enterPttPreview(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable PttElement pttElement);

    void enterVideoPreview(@NotNull AppRuntime app, @NotNull Context context, @Nullable View view, @NotNull AIOMsgItem aioMsgItem, long playPosition, boolean isMute, boolean isOneItemOnly, @Nullable Bundle extraInfo, @Nullable List<? extends AIOMsgItem> aioRichMediaList);
}
