package com.tencent.qqnt.chathistory.api.impl;

import android.app.Activity;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.multimsg.save.a;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi;
import com.tencent.qqnt.chathistory.api.impl.ChatHistoryMultiActionApiImpl;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u000256B\u0007\u00a2\u0006\u0004\b2\u00103J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002JV\u0010#\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000426\u0010\"\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u001cH\u0016J\u001e\u0010$\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/impl/ChatHistoryMultiActionApiImpl;", "Lcom/tencent/qqnt/chathistory/api/IChatHistoryMultiActionApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Lcom/tencent/qqnt/chathistory/api/impl/ChatHistoryMultiActionApiImpl$a;", "fileSaveReqList", "", "startSaveMultiRichMedia", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "buildFileSaveReqList", "", "fileSize", "elementId", "msgRecord", "", "filePath", "getFileSaveReq", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "fileSaveReq", "", "checkFileExists", "Lcom/tencent/mobileqq/multimsg/save/a;", "fileSaveDialog", "doSaveMedia", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "result", "errMsg", "deleteCallBack", "deleteChatFile", "saveMedia", "totalLength", "J", "totalSuccessSize", "totalCount", "I", "successCount", "failCount", "Ljava/util/concurrent/CopyOnWriteArrayList;", "downloadReqList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "kernelMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "<init>", "()V", "Companion", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ChatHistoryMultiActionApiImpl implements IChatHistoryMultiActionApi {
    private static final b Companion = new b(null);

    @Deprecated
    public static final String TAG = "HistoryLog::ChatHistoryMultiActionApiImpl";
    private CopyOnWriteArrayList<RichMediaElementGetReq> downloadReqList = new CopyOnWriteArrayList<>();
    private int failCount;
    private IKernelMsgListener kernelMsgListener;
    private int successCount;
    private int totalCount;
    private long totalLength;
    private long totalSuccessSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/impl/ChatHistoryMultiActionApiImpl$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/chathistory/api/impl/ChatHistoryMultiActionApiImpl$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<Activity> f353283a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChatHistoryMultiActionApiImpl f353284b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<ChatRecordMediaSaveReq> f353285c;

        c(WeakReference<Activity> weakReference, ChatHistoryMultiActionApiImpl chatHistoryMultiActionApiImpl, List<ChatRecordMediaSaveReq> list) {
            this.f353283a = weakReference;
            this.f353284b = chatHistoryMultiActionApiImpl;
            this.f353285c = list;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            Activity activity = this.f353283a.get();
            if (activity != null) {
                this.f353284b.startSaveMultiRichMedia(activity, this.f353285c);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<ChatRecordMediaSaveReq> buildFileSaveReqList(List<MsgRecord> msgRecordList) {
        ChatRecordMediaSaveReq chatRecordMediaSaveReq;
        String str;
        String str2;
        Integer num;
        String str3;
        Integer num2;
        String str4;
        String str5;
        if (msgRecordList.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : msgRecordList) {
            ArrayList<MsgElement> arrayList2 = msgRecord.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
            for (MsgElement msgElement : arrayList2) {
                long j3 = msgElement != null ? msgElement.elementId : 0L;
                int i3 = msgElement.elementType;
                if (i3 == 2) {
                    PicElement picElement = msgElement.picElement;
                    if (picElement != null) {
                        Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
                        String a16 = aj.a(picElement);
                        if (a16 != null) {
                            str5 = a16;
                            PicElement picElement2 = msgElement.picElement;
                            chatRecordMediaSaveReq = getFileSaveReq(picElement2 != null ? picElement2.fileSize : 0L, j3, msgRecord, str5);
                        }
                    }
                    str5 = "";
                    PicElement picElement22 = msgElement.picElement;
                    chatRecordMediaSaveReq = getFileSaveReq(picElement22 != null ? picElement22.fileSize : 0L, j3, msgRecord, str5);
                } else if (i3 == 5) {
                    VideoElement videoElement = msgElement.videoElement;
                    if (videoElement != null) {
                        Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
                        String e16 = aj.e(videoElement);
                        if (e16 != null) {
                            str4 = e16;
                            VideoElement videoElement2 = msgElement.videoElement;
                            chatRecordMediaSaveReq = getFileSaveReq(videoElement2 != null ? videoElement2.fileSize : 0L, j3, msgRecord, str4);
                        }
                    }
                    str4 = "";
                    VideoElement videoElement22 = msgElement.videoElement;
                    chatRecordMediaSaveReq = getFileSaveReq(videoElement22 != null ? videoElement22.fileSize : 0L, j3, msgRecord, str4);
                } else {
                    if (i3 == 3) {
                        FileElement fileElement = msgElement.fileElement;
                        if ((fileElement == null || (num2 = fileElement.subElementType) == null || num2.intValue() != 1) ? false : true) {
                            FileElement fileElement2 = msgElement.fileElement;
                            str = fileElement2 != null ? fileElement2.filePath : null;
                            if (str == null) {
                                str3 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(str, "element.fileElement?.filePath ?: \"\"");
                                str3 = str;
                            }
                            FileElement fileElement3 = msgElement.fileElement;
                            chatRecordMediaSaveReq = getFileSaveReq(fileElement3 != null ? fileElement3.fileSize : 0L, j3, msgRecord, str3);
                        }
                    }
                    if (msgElement.elementType == 3) {
                        FileElement fileElement4 = msgElement.fileElement;
                        if ((fileElement4 == null || (num = fileElement4.subElementType) == null || num.intValue() != 2) ? false : true) {
                            FileElement fileElement5 = msgElement.fileElement;
                            str = fileElement5 != null ? fileElement5.filePath : null;
                            if (str == null) {
                                str2 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(str, "element.fileElement?.filePath ?: \"\"");
                                str2 = str;
                            }
                            FileElement fileElement6 = msgElement.fileElement;
                            chatRecordMediaSaveReq = getFileSaveReq(fileElement6 != null ? fileElement6.fileSize : 0L, j3, msgRecord, str2);
                        }
                    }
                    chatRecordMediaSaveReq = null;
                }
                if (chatRecordMediaSaveReq != null) {
                    arrayList.add(chatRecordMediaSaveReq);
                }
            }
        }
        return arrayList;
    }

    private final boolean checkFileExists(RichMediaElementGetReq fileSaveReq) {
        File file = new File(fileSaveReq.filePath);
        if (!file.exists()) {
            return false;
        }
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d(TAG, 2, "isFileExist " + file.getName() + " exists");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSaveMedia(final Activity activity, String filePath, final com.tencent.mobileqq.multimsg.save.a fileSaveDialog) {
        RFWSaveUtil.insertMedia(activity, filePath, new Consumer() { // from class: com.tencent.qqnt.chathistory.api.impl.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ChatHistoryMultiActionApiImpl.doSaveMedia$lambda$11(ChatHistoryMultiActionApiImpl.this, activity, fileSaveDialog, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSaveMedia$lambda$11(final ChatHistoryMultiActionApiImpl this$0, final Activity activity, final com.tencent.mobileqq.multimsg.save.a fileSaveDialog, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(fileSaveDialog, "$fileSaveDialog");
        QLog.d(TAG, 1, "chat record media save to album, result: " + rFWSaveMediaResultBean.isSuccess);
        if (rFWSaveMediaResultBean.isSuccess) {
            this$0.successCount++;
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.chathistory.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryMultiActionApiImpl.doSaveMedia$lambda$11$lambda$9(com.tencent.mobileqq.multimsg.save.a.this, this$0);
                }
            });
        } else {
            this$0.failCount++;
            QLog.e(TAG, 1, "chat record media save to album error");
        }
        QLog.d(TAG, 1, "save count: success=" + this$0.successCount + ", fail=" + this$0.failCount + ", total=" + this$0.totalCount);
        if (this$0.successCount + this$0.failCount >= this$0.totalCount) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.chathistory.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    ChatHistoryMultiActionApiImpl.doSaveMedia$lambda$11$lambda$10(com.tencent.mobileqq.multimsg.save.a.this, this$0, activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSaveMedia$lambda$11$lambda$10(com.tencent.mobileqq.multimsg.save.a fileSaveDialog, ChatHistoryMultiActionApiImpl this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(fileSaveDialog, "$fileSaveDialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        fileSaveDialog.dismiss();
        int i3 = this$0.successCount;
        QQToast.makeText(activity, i3 == this$0.totalCount ? R.string.f173075h42 : i3 == 0 ? R.string.h3x : R.string.h4c, 0).show();
        this$0.successCount = 0;
        this$0.failCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSaveMedia$lambda$11$lambda$9(com.tencent.mobileqq.multimsg.save.a fileSaveDialog, ChatHistoryMultiActionApiImpl this$0) {
        Intrinsics.checkNotNullParameter(fileSaveDialog, "$fileSaveDialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fileSaveDialog.Q((int) ((this$0.totalSuccessSize / this$0.totalLength) * 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSaveMultiRichMedia(Activity activity, List<ChatRecordMediaSaveReq> fileSaveReqList) {
        final com.tencent.mobileqq.multimsg.save.a aVar = new com.tencent.mobileqq.multimsg.save.a(activity);
        aVar.P(new a.b() { // from class: com.tencent.qqnt.chathistory.api.impl.b
            @Override // com.tencent.mobileqq.multimsg.save.a.b
            public final void cancel() {
                ChatHistoryMultiActionApiImpl.startSaveMultiRichMedia$lambda$5$lambda$4(ChatHistoryMultiActionApiImpl.this, aVar);
            }
        });
        aVar.show();
        for (ChatRecordMediaSaveReq chatRecordMediaSaveReq : fileSaveReqList) {
            if (checkFileExists(chatRecordMediaSaveReq.getRichMediaElementGetReq())) {
                this.totalSuccessSize += chatRecordMediaSaveReq.getFileSize();
                String str = chatRecordMediaSaveReq.getRichMediaElementGetReq().filePath;
                Intrinsics.checkNotNullExpressionValue(str, "saveReq.richMediaElementGetReq.filePath");
                doSaveMedia(activity, str, aVar);
            } else {
                QLog.d(TAG, 1, "start media download path: " + chatRecordMediaSaveReq.getRichMediaElementGetReq().filePath);
                d dVar = new d(chatRecordMediaSaveReq, this, activity, aVar);
                this.kernelMsgListener = dVar;
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.addMsgListener(dVar);
                }
                this.downloadReqList.add(chatRecordMediaSaveReq.getRichMediaElementGetReq());
                w e17 = com.tencent.qqnt.msg.f.e();
                if (e17 != null) {
                    e17.getRichMediaElement(chatRecordMediaSaveReq.getRichMediaElementGetReq());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startSaveMultiRichMedia$lambda$5$lambda$4(ChatHistoryMultiActionApiImpl this$0, com.tencent.mobileqq.multimsg.save.a this_apply) {
        w e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        for (RichMediaElementGetReq req : this$0.downloadReqList) {
            w e17 = com.tencent.qqnt.msg.f.e();
            if (e17 != null) {
                Intrinsics.checkNotNullExpressionValue(req, "req");
                e17.cancelGetRichMediaElement(req);
            }
            IKernelMsgListener iKernelMsgListener = this$0.kernelMsgListener;
            if (iKernelMsgListener != null && (e16 = com.tencent.qqnt.msg.f.e()) != null) {
                e16.removeMsgListener(iKernelMsgListener);
            }
        }
        this$0.downloadReqList.clear();
        this_apply.dismiss();
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi
    public void deleteChatFile(Contact peer, List<MsgRecord> msgRecordList, Function2<? super Integer, ? super String, Unit> deleteCallBack) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        Intrinsics.checkNotNullParameter(deleteCallBack, "deleteCallBack");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "need QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        for (MsgRecord msgRecord : msgRecordList) {
            MsgElement i3 = MsgExtKt.i(msgRecord, 3);
            if (i3 != null) {
                FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(i3.elementId, String.valueOf(msgRecord.peerUin), msgRecord.chatType);
                if (E == null) {
                    QLog.e(TAG, 1, "fileManagerDataCenter return null entity, elementId : " + i3.elementId + ", peerUin : " + msgRecord.peerUin + ", chatType : " + msgRecord.chatType);
                } else {
                    qQAppInterface.getFileManagerEngine().i(E.nSessionId);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi
    public void saveMedia(Activity activity, List<MsgRecord> msgRecordList) {
        List<MsgRecord> distinct;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        WeakReference weakReference = new WeakReference(activity);
        distinct = CollectionsKt___CollectionsKt.distinct(msgRecordList);
        List<ChatRecordMediaSaveReq> buildFileSaveReqList = buildFileSaveReqList(distinct);
        int size = buildFileSaveReqList.size();
        this.totalCount = size;
        QLog.i(TAG, 1, "char record save size: " + size);
        if (buildFileSaveReqList.isEmpty()) {
            QQToast.makeText(activity, activity.getString(R.string.h46), 0).show();
            return;
        }
        Iterator<T> it = buildFileSaveReqList.iterator();
        while (it.hasNext()) {
            this.totalLength += ((ChatRecordMediaSaveReq) it.next()).getFileSize();
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SHARE, QQPermissionConstants.Business.SCENE.SHARE_SAVE_PIC));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(activity, config)");
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(weakReference, this, buildFileSaveReqList));
            return;
        }
        Activity activity2 = (Activity) weakReference.get();
        if (activity2 != null) {
            startSaveMultiRichMedia(activity2, buildFileSaveReqList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/chathistory/api/impl/ChatHistoryMultiActionApiImpl$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "onRichMediaProgerssUpdate", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements IKernelMsgListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatRecordMediaSaveReq f353286d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ChatHistoryMultiActionApiImpl f353287e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f353288f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.multimsg.save.a f353289h;

        d(ChatRecordMediaSaveReq chatRecordMediaSaveReq, ChatHistoryMultiActionApiImpl chatHistoryMultiActionApiImpl, Activity activity, com.tencent.mobileqq.multimsg.save.a aVar) {
            this.f353286d = chatRecordMediaSaveReq;
            this.f353287e = chatHistoryMultiActionApiImpl;
            this.f353288f = activity;
            this.f353289h = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(com.tencent.mobileqq.multimsg.save.a fileSaveDialog, ChatHistoryMultiActionApiImpl this$0, Activity activity) {
            Intrinsics.checkNotNullParameter(fileSaveDialog, "$fileSaveDialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            fileSaveDialog.dismiss();
            int i3 = this$0.successCount;
            QQToast.makeText(activity, i3 == this$0.totalCount ? R.string.f173075h42 : i3 == 0 ? R.string.h3x : R.string.h4c, 0).show();
            this$0.successCount = 0;
            this$0.failCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(com.tencent.mobileqq.multimsg.save.a fileSaveDialog, ChatHistoryMultiActionApiImpl this$0, FileTransNotifyInfo fileTransNotifyInfo) {
            Intrinsics.checkNotNullParameter(fileSaveDialog, "$fileSaveDialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            fileSaveDialog.Q((int) ((this$0.totalSuccessSize + (fileTransNotifyInfo.fileProgress / this$0.totalLength)) * 100));
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(FileTransNotifyInfo notifyInfo) {
            if (notifyInfo != null && notifyInfo.fileDownType == 1 && notifyInfo.msgId == this.f353286d.getRichMediaElementGetReq().msgId && notifyInfo.msgElementId == this.f353286d.getRichMediaElementGetReq().elementId) {
                if (QLog.isColorLevel()) {
                    QLog.d(ChatHistoryMultiActionApiImpl.TAG, 2, "downType: " + notifyInfo.fileDownType + ", info:" + notifyInfo);
                }
                this.f353287e.totalSuccessSize += notifyInfo.fileProgress;
                if (notifyInfo.fileErrCode == 0) {
                    ChatHistoryMultiActionApiImpl chatHistoryMultiActionApiImpl = this.f353287e;
                    Activity activity = this.f353288f;
                    String str = notifyInfo.filePath;
                    Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
                    chatHistoryMultiActionApiImpl.doSaveMedia(activity, str, this.f353289h);
                } else {
                    ChatHistoryMultiActionApiImpl chatHistoryMultiActionApiImpl2 = this.f353287e;
                    chatHistoryMultiActionApiImpl2.failCount++;
                    int unused = chatHistoryMultiActionApiImpl2.failCount;
                    QLog.d(ChatHistoryMultiActionApiImpl.TAG, 1, "save count: success=" + this.f353287e.successCount + ", fail=" + this.f353287e.failCount + ", total=" + this.f353287e.totalCount);
                    if (this.f353287e.successCount + this.f353287e.failCount >= this.f353287e.totalCount) {
                        final Activity activity2 = this.f353288f;
                        final com.tencent.mobileqq.multimsg.save.a aVar = this.f353289h;
                        final ChatHistoryMultiActionApiImpl chatHistoryMultiActionApiImpl3 = this.f353287e;
                        activity2.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.chathistory.api.impl.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                ChatHistoryMultiActionApiImpl.d.c(com.tencent.mobileqq.multimsg.save.a.this, chatHistoryMultiActionApiImpl3, activity2);
                            }
                        });
                    }
                }
                this.f353287e.downloadReqList.remove(this.f353286d.getRichMediaElementGetReq());
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.removeMsgListener(this);
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaProgerssUpdate(final FileTransNotifyInfo notifyInfo) {
            QLog.d(ChatHistoryMultiActionApiImpl.TAG, 2, "update progress: " + (notifyInfo != null ? Long.valueOf(notifyInfo.fileProgress) : null));
            if (notifyInfo != null) {
                Activity activity = this.f353288f;
                final com.tencent.mobileqq.multimsg.save.a aVar = this.f353289h;
                final ChatHistoryMultiActionApiImpl chatHistoryMultiActionApiImpl = this.f353287e;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.chathistory.api.impl.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatHistoryMultiActionApiImpl.d.d(com.tencent.mobileqq.multimsg.save.a.this, chatHistoryMultiActionApiImpl, notifyInfo);
                    }
                });
            }
        }
    }

    private final ChatRecordMediaSaveReq getFileSaveReq(long fileSize, long elementId, MsgRecord msgRecord, String filePath) {
        return new ChatRecordMediaSaveReq(fileSize, new RichMediaElementGetReq(msgRecord.msgId, msgRecord.peerUid, msgRecord.chatType, elementId, 1, 0, filePath, 0L, 3, 0));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chathistory/api/impl/ChatHistoryMultiActionApiImpl$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "fileSize", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "richMediaElementGetReq", "<init>", "(JLcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.api.impl.ChatHistoryMultiActionApiImpl$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class ChatRecordMediaSaveReq {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long fileSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final RichMediaElementGetReq richMediaElementGetReq;

        public ChatRecordMediaSaveReq(long j3, RichMediaElementGetReq richMediaElementGetReq) {
            Intrinsics.checkNotNullParameter(richMediaElementGetReq, "richMediaElementGetReq");
            this.fileSize = j3;
            this.richMediaElementGetReq = richMediaElementGetReq;
        }

        /* renamed from: a, reason: from getter */
        public final long getFileSize() {
            return this.fileSize;
        }

        /* renamed from: b, reason: from getter */
        public final RichMediaElementGetReq getRichMediaElementGetReq() {
            return this.richMediaElementGetReq;
        }

        public int hashCode() {
            return (com.tencent.mobileqq.perf.api.impl.b.a(this.fileSize) * 31) + this.richMediaElementGetReq.hashCode();
        }

        public String toString() {
            return "ChatRecordMediaSaveReq(fileSize=" + this.fileSize + ", richMediaElementGetReq=" + this.richMediaElementGetReq + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChatRecordMediaSaveReq)) {
                return false;
            }
            ChatRecordMediaSaveReq chatRecordMediaSaveReq = (ChatRecordMediaSaveReq) other;
            return this.fileSize == chatRecordMediaSaveReq.fileSize && Intrinsics.areEqual(this.richMediaElementGetReq, chatRecordMediaSaveReq.richMediaElementGetReq);
        }
    }
}
