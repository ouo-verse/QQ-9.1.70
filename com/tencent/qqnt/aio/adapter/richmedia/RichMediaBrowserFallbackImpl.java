package com.tencent.qqnt.aio.adapter.richmedia;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.adapter.richmedia.RichMediaBrowserFallbackImpl;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.f;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\\\u0010+\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010'2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010)H\u0016J^\u00100\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010'2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010)2\u0006\u0010/\u001a\u00020$H\u0016J4\u00101\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010.\u001a\u0004\u0018\u00010'H\u0016J \u00104\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u00103\u001a\u0002022\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J(\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u00107\u001a\u000202H\u0016J(\u00109\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00108\u001a\u00020\u000fH\u0016J*\u0010<\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J \u0010=\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/richmedia/RichMediaBrowserFallbackImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IRichMediaBrowserApi;", "Landroid/content/Context;", "context", "", "thumbPath", "videoPath", "", "previewVideo", "sourcePath", "previewPic", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "getMsgElementForFile", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "getMsgElementForVideo", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", "getVideoElement", "getThumbPath", "msgItem", "getVideoPath", "Ljava/io/File;", "file", "Landroid/net/Uri;", "getUriForFile", "Lmqq/app/AppRuntime;", "app", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "", "playPosition", "", "isMute", "isOneItemOnly", "Landroid/os/Bundle;", "extraInfo", "", "aioRichMediaList", "enterVideoPreview", "picMsgElement", "isOnePic", "extras", "previewGIFWithEmotionViewer", "enterImagePreview", "enterAIOEmotionPreview", "", "currentIndex", "enterMultiImagePreviewWithPath", "appRuntime", "enterFileBrowser", "source", "fileElement", "enterOnlineFileBrowser", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "pttElement", "enterPttPreview", "enterMultiPicBrowser", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class RichMediaBrowserFallbackImpl implements IRichMediaBrowserApi {
    private static final int SOURCE_OTHER = 1;

    @NotNull
    private static final String TAG = "RichMediaBrowserFallbackImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterOnlineFileBrowser$lambda$2(Contact contact, MsgRecord msgRecord, final Context context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(context, "$context");
        w e16 = f.e();
        if (e16 != null) {
            e16.reqToOfflineSendMsg(contact, msgRecord.msgId, new IOperateCallback() { // from class: ru3.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    RichMediaBrowserFallbackImpl.enterOnlineFileBrowser$lambda$2$lambda$1(context, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterOnlineFileBrowser$lambda$2$lambda$1(final Context context, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.i(TAG, 1, "reqToOfflineSendMsg result:" + i3 + "  errMsg:" + str);
        if (i3 != 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ru3.d
                @Override // java.lang.Runnable
                public final void run() {
                    RichMediaBrowserFallbackImpl.enterOnlineFileBrowser$lambda$2$lambda$1$lambda$0(context, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterOnlineFileBrowser$lambda$2$lambda$1$lambda$0(Context context, int i3, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "\u8f6c\u79bb\u7ebf\u5931\u8d25 result:" + i3 + "  errMsg:" + str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterOnlineFileBrowser$lambda$5(Contact contact, MsgRecord msgRecord, final Context context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(context, "$context");
        w e16 = f.e();
        if (e16 != null) {
            e16.refuseReceiveOnlineFileMsg(contact, msgRecord.msgId, new IOperateCallback() { // from class: ru3.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    RichMediaBrowserFallbackImpl.enterOnlineFileBrowser$lambda$5$lambda$4(context, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterOnlineFileBrowser$lambda$5$lambda$4(final Context context, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QLog.i(TAG, 1, "refuseReceiveOnlineFileMsg result:" + i3 + "  errMsg:" + str);
        if (i3 != 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ru3.h
                @Override // java.lang.Runnable
                public final void run() {
                    RichMediaBrowserFallbackImpl.enterOnlineFileBrowser$lambda$5$lambda$4$lambda$3(context, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterOnlineFileBrowser$lambda$5$lambda$4$lambda$3(Context context, int i3, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "\u62d2\u6536\u5931\u8d25 result:" + i3 + "  errMsg:" + str, 0).show();
    }

    private final FileElement getMsgElementForFile(MsgRecord msgRecord) {
        if (msgRecord.msgType != 3) {
            return null;
        }
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                return next.fileElement;
            }
        }
        return null;
    }

    private final MsgElement getMsgElementForVideo(MsgRecord msgRecord) {
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 5) {
                return next;
            }
        }
        return null;
    }

    private final String getThumbPath(MsgRecord msgRecord) {
        String f16;
        VideoElement videoElement = getVideoElement(msgRecord);
        if (videoElement == null || (f16 = aj.f(videoElement)) == null) {
            return "";
        }
        return f16;
    }

    private final Uri getUriForFile(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, "com.tencent.qqnt.aio_file.provider", file);
        }
        return Uri.fromFile(file);
    }

    private final VideoElement getVideoElement(MsgRecord msgRecord) {
        MsgElement msgElementForVideo = getMsgElementForVideo(msgRecord);
        if (msgElementForVideo != null) {
            return msgElementForVideo.videoElement;
        }
        return null;
    }

    private final String getVideoPath(MsgRecord msgItem) {
        String e16;
        VideoElement videoElement = getVideoElement(msgItem);
        if (videoElement == null || (e16 = aj.e(videoElement)) == null) {
            return "";
        }
        return e16;
    }

    private final void previewPic(Context context, String sourcePath) {
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterAIOEmotionPreview(@NotNull AppRuntime app, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem, @Nullable View view, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Toast.makeText(context, "enterAIOEmotionPreview not implemented", 1).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterFileBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        enterFileBrowser(appRuntime, context, aioMsgItem, 1);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterImagePreview(@NotNull AppRuntime app, @NotNull Context context, @Nullable View view, @NotNull AIOMsgItem aioMsgItem, @Nullable MsgElement picMsgElement, boolean isOnePic, @Nullable Bundle extras, @Nullable List<? extends AIOMsgItem> aioRichMediaList, boolean previewGIFWithEmotionViewer) {
        Object first;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        if (MsgExtKt.M(msgRecord)) {
            previewPic(context, msgRecord.elements.get(0).picElement);
            return;
        }
        if (MsgExtKt.w(msgRecord)) {
            FileElement msgElementForFile = getMsgElementForFile(msgRecord);
            if (msgElementForFile != null) {
                Collection<String> values = msgElementForFile.picThumbPath.values();
                Intrinsics.checkNotNullExpressionValue(values, "element.picThumbPath.values");
                first = CollectionsKt___CollectionsKt.first(values);
                Intrinsics.checkNotNullExpressionValue(first, "element.picThumbPath.values.first()");
                previewPic(context, (String) first);
                return;
            }
            return;
        }
        if (picMsgElement != null) {
            previewPic(context, picMsgElement.picElement);
        } else {
            Toast.makeText(context, "enterImagePreview not implemented", 1).show();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterMultiImagePreviewWithPath(@NotNull View view, int currentIndex, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Toast.makeText(view.getContext(), "enterMultiImagePreviewWithPath not implemented", 1).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterMultiPicBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Toast.makeText(context, "enterMultiPicBrowser not implemented", 1).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterOnlineFileBrowser(@NotNull AppRuntime appRuntime, @NotNull final Context context, @NotNull final MsgRecord msgRecord, @NotNull FileElement fileElement) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElement, "fileElement");
        final Contact contact = new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context);
        qQCustomDialog.setContentView(R.layout.custom_dialog);
        qQCustomDialog.setTitle("\u5904\u7406\u5728\u7ebf\u6587\u4ef6");
        qQCustomDialog.setMessage("\u8bf7\u9009\u62e9\u300c\u8f6c\u79bb\u7ebf\u300d\u6216\u8005\u300c\u62d2\u6536\u300d");
        qQCustomDialog.setPositiveButton("\u8f6c\u79bb\u7ebf", new DialogInterface.OnClickListener() { // from class: ru3.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RichMediaBrowserFallbackImpl.enterOnlineFileBrowser$lambda$2(Contact.this, msgRecord, context, dialogInterface, i3);
            }
        });
        qQCustomDialog.setNegativeButton("\u62d2\u6536", new DialogInterface.OnClickListener() { // from class: ru3.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RichMediaBrowserFallbackImpl.enterOnlineFileBrowser$lambda$5(Contact.this, msgRecord, context, dialogInterface, i3);
            }
        });
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterPttPreview(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull MsgRecord msgRecord, @Nullable PttElement pttElement) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterVideoPreview(@NotNull AppRuntime app, @NotNull Context context, @Nullable View view, @NotNull AIOMsgItem aioMsgItem, long playPosition, boolean isMute, boolean isOneItemOnly, @Nullable Bundle extraInfo, @Nullable List<? extends AIOMsgItem> aioRichMediaList) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        if (MsgExtKt.Y(msgRecord)) {
            previewVideo(context, getThumbPath(msgRecord), getVideoPath(msgRecord));
            return;
        }
        if (MsgExtKt.w(msgRecord)) {
            FileElement msgElementForFile = getMsgElementForFile(msgRecord);
            if (msgElementForFile != null) {
                String str = msgElementForFile.filePath;
                Intrinsics.checkNotNullExpressionValue(str, "element.filePath");
                String str2 = msgElementForFile.filePath;
                Intrinsics.checkNotNullExpressionValue(str2, "element.filePath");
                previewVideo(context, str, str2);
                return;
            }
            return;
        }
        Toast.makeText(context, "enterVideoPreview not implemented", 1).show();
    }

    private final void previewPic(Context context, PicElement picElement) {
        if (picElement == null) {
            return;
        }
        String a16 = aj.a(picElement);
        if (!new File(a16).exists()) {
            a16 = aj.b(picElement, 0);
            if (!new File(a16).exists()) {
                a16 = aj.b(picElement, 720);
            }
        }
        if (a16 == null) {
            a16 = "";
        }
        previewPic(context, a16);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterFileBrowser(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull AIOMsgItem aioMsgItem, int source) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Iterator<MsgElement> it = aioMsgItem.getMsgRecord().elements.iterator();
        String str = null;
        boolean z16 = true;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                FileElement fileElement = next.fileElement;
                String str2 = fileElement.filePath;
                Integer num = fileElement.invalidState;
                if (num == null || num.intValue() != 0) {
                    z16 = false;
                }
                str = str2;
            }
        }
        if (z16 && str != null) {
            try {
                File file = new File(str);
                Uri uriForFile = getUriForFile(context, file);
                String mimeType = MimeTypesTools.getMimeType(context, file.getName());
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, uriForFile);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(268435456);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, mimeType);
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                Toast.makeText(context, R.string.f201294uf, 1).show();
                return;
            }
        }
        QQToast.makeText(context, 1, R.string.f201284ue, 1).show();
    }

    private final void previewVideo(Context context, String thumbPath, String videoPath) {
    }
}
