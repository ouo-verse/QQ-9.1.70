package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b#\u0010$J/\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0002J9\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/filemanager/fileassistant/util/a;", "", "Lcom/tencent/mobileqq/data/ChatMessage;", "chatMsg", "", "isMixedMsg", "isSend", "Lcom/tencent/mobileqq/data/DataLineMsgRecord;", tl.h.F, "(Lcom/tencent/mobileqq/data/ChatMessage;ZLjava/lang/Boolean;)Lcom/tencent/mobileqq/data/DataLineMsgRecord;", "Lcom/tencent/mobileqq/data/MessageForText;", "chatMessage", "e", "", "msg", "i", "Lcom/tencent/mobileqq/data/MessageForFile;", "c", "Lcom/tencent/mobileqq/data/MessageForPic;", "d", "Lcom/tencent/mobileqq/data/MessageForShortVideo;", "f", "", "a", "path", "", "b", "", "Lcom/tencent/mobileqq/data/MessageRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "g", "(Ljava/util/List;ZLjava/lang/Boolean;)Ljava/util/List;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQAppInterface mApp;

    public a(@NotNull QQAppInterface mApp) {
        Intrinsics.checkNotNullParameter(mApp, "mApp");
        this.mApp = mApp;
    }

    private final void b(DataLineMsgRecord msg2, String path) {
        if (!TextUtils.isEmpty(path) && q.p(path)) {
            msg2.progress = 1.0f;
        } else {
            msg2.fileMsgStatus = 3L;
        }
    }

    private final DataLineMsgRecord c(MessageForFile chatMessage) {
        FileManagerEntity E = this.mApp.getFileManagerDataCenter().E(chatMessage.uniseq, chatMessage.frienduin, chatMessage.istroop);
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.msgtype = -2005;
        dataLineMsgRecord.msgseq = chatMessage.msgseq;
        dataLineMsgRecord.shmsgseq = chatMessage.shmsgseq;
        dataLineMsgRecord.path = E.strFilePath;
        dataLineMsgRecord.filename = E.fileName;
        dataLineMsgRecord.filesize = E.fileSize;
        b(dataLineMsgRecord, E.getFilePath());
        return dataLineMsgRecord;
    }

    private final DataLineMsgRecord d(MessageForPic chatMessage) {
        List split$default;
        int lastIndex;
        String filePath = AbsDownloader.getFilePath(URLDrawableHelper.getURL(chatMessage, 65537, "chatthumb").toString());
        String path = AbsDownloader.getFilePath(URLDrawableHelper.getURL(chatMessage, 1, null).toString());
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.msgtype = -2000;
        dataLineMsgRecord.msgseq = chatMessage.msgseq;
        dataLineMsgRecord.shmsgseq = chatMessage.shmsgseq;
        dataLineMsgRecord.filesize = chatMessage.size;
        dataLineMsgRecord.progress = 1.0f;
        String str = chatMessage.md5;
        Intrinsics.checkNotNullExpressionValue(str, "chatMessage.md5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        dataLineMsgRecord.md5 = bytes;
        dataLineMsgRecord.path = path;
        dataLineMsgRecord.thumbPath = filePath;
        Intrinsics.checkNotNullExpressionValue(path, "path");
        split$default = StringsKt__StringsKt.split$default((CharSequence) path, new String[]{"/"}, false, 0, 6, (Object) null);
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(split$default);
        dataLineMsgRecord.filename = (String) split$default.get(lastIndex);
        return dataLineMsgRecord;
    }

    private final DataLineMsgRecord e(MessageForText chatMessage) {
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.msgtype = -1000;
        dataLineMsgRecord.msgseq = chatMessage.msgseq;
        dataLineMsgRecord.shmsgseq = chatMessage.shmsgseq;
        String str = chatMessage.f203106msg;
        Intrinsics.checkNotNullExpressionValue(str, "chatMessage.msg");
        dataLineMsgRecord.f203106msg = i(str);
        dataLineMsgRecord.progress = 1.0f;
        return dataLineMsgRecord;
    }

    private final DataLineMsgRecord f(MessageForShortVideo chatMessage) {
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.msgtype = -2009;
        dataLineMsgRecord.shmsgseq = chatMessage.shmsgseq;
        dataLineMsgRecord.filename = chatMessage.fileSource;
        dataLineMsgRecord.path = chatMessage.videoFileName;
        dataLineMsgRecord.filesize = chatMessage.videoFileSize;
        dataLineMsgRecord.thumbPath = j.l(chatMessage.thumbMD5, "jpg");
        b(dataLineMsgRecord, chatMessage.videoFileName);
        String str = chatMessage.md5;
        Intrinsics.checkNotNullExpressionValue(str, "chatMessage.md5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        dataLineMsgRecord.md5 = bytes;
        return dataLineMsgRecord;
    }

    private final DataLineMsgRecord h(ChatMessage chatMsg, boolean isMixedMsg, Boolean isSend) {
        int a16;
        DataLineMsgRecord dataLineMsgRecord;
        if (isSend != null) {
            a16 = a(isSend.booleanValue());
        } else {
            a16 = a(h.m(chatMsg));
        }
        if (chatMsg instanceof MessageForFile) {
            dataLineMsgRecord = c((MessageForFile) chatMsg);
        } else if (chatMsg instanceof MessageForPic) {
            dataLineMsgRecord = d((MessageForPic) chatMsg);
        } else if (chatMsg instanceof MessageForText) {
            if (!isMixedMsg || !Intrinsics.areEqual(chatMsg.f203106msg, "\n")) {
                dataLineMsgRecord = e((MessageForText) chatMsg);
            } else {
                dataLineMsgRecord = null;
            }
        } else {
            if (chatMsg instanceof MessageForShortVideo) {
                dataLineMsgRecord = f((MessageForShortVideo) chatMsg);
            }
            dataLineMsgRecord = null;
        }
        if (dataLineMsgRecord == null) {
            return null;
        }
        if (dataLineMsgRecord.f203106msg == null) {
            dataLineMsgRecord.f203106msg = "";
        }
        dataLineMsgRecord.issend = a16;
        dataLineMsgRecord.time = chatMsg.time;
        dataLineMsgRecord.issuc = true;
        dataLineMsgRecord.isread = true;
        dataLineMsgRecord.dataline_type = 0;
        return dataLineMsgRecord;
    }

    private final String i(String msg2) {
        boolean startsWith$default;
        boolean endsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(msg2, "\n", false, 2, null);
        if (startsWith$default) {
            msg2 = msg2.substring(1);
            Intrinsics.checkNotNullExpressionValue(msg2, "this as java.lang.String).substring(startIndex)");
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(msg2, "\n", false, 2, null);
        if (endsWith$default) {
            String substring = msg2.substring(0, msg2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return msg2;
    }

    @NotNull
    public final List<DataLineMsgRecord> g(@Nullable List<? extends MessageRecord> msgList, boolean isMixedMsg, @Nullable Boolean isSend) {
        ArrayList arrayList = new ArrayList();
        if (msgList != null && !msgList.isEmpty()) {
            for (MessageRecord messageRecord : msgList) {
                if (messageRecord instanceof MessageForMixedMsg) {
                    MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) messageRecord;
                    List<MessageRecord> list = messageForMixedMsg.msgElemList;
                    Intrinsics.checkNotNullExpressionValue(list, "msg.msgElemList");
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        ((MessageRecord) it.next()).time = messageRecord.time;
                    }
                    arrayList.addAll(g(messageForMixedMsg.msgElemList, true, Boolean.valueOf(h.m(messageRecord))));
                } else {
                    Intrinsics.checkNotNull(messageRecord, "null cannot be cast to non-null type com.tencent.mobileqq.data.ChatMessage");
                    DataLineMsgRecord h16 = h((ChatMessage) messageRecord, isMixedMsg, isSend);
                    if (h16 != null) {
                        arrayList.add(h16);
                    }
                }
            }
        }
        return arrayList;
    }

    private final int a(boolean isSend) {
        return isSend ? 1 : 0;
    }
}
