package com.tencent.mobileqq.filemanager.util;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u001b\u0010\u0010\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/MultiPicReporter;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "b", "", "e", "", "d", "Ljava/util/Random;", "Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "c", "Lkotlin/Lazy;", "()Z", "shouldReport", "<init>", "()V", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MultiPicReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MultiPicReporter f209186a = new MultiPicReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Random random = new Random();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy shouldReport;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.filemanager.util.MultiPicReporter$shouldReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean e16;
                e16 = MultiPicReporter.f209186a.e();
                return Boolean.valueOf(e16);
            }
        });
        shouldReport = lazy;
    }

    MultiPicReporter() {
    }

    private final FileElement b(FileTransNotifyInfo notifyInfo) {
        MsgRecord msgRecord;
        ArrayList<MsgElement> arrayList;
        MsgRecord msgRecord2 = notifyInfo.msgRecord;
        boolean z16 = false;
        if (msgRecord2 != null && MsgExtKt.B(msgRecord2)) {
            z16 = true;
        }
        if (z16 && (msgRecord = notifyInfo.msgRecord) != null && (arrayList = msgRecord.elements) != null) {
            for (MsgElement msgElement : arrayList) {
                if (msgElement.elementId == notifyInfo.msgElementId) {
                    return msgElement.fileElement;
                }
            }
        }
        return null;
    }

    private final boolean c() {
        return ((Boolean) shouldReport.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        if (random.nextInt(100) == 0) {
            return true;
        }
        return false;
    }

    public final void d(@NotNull FileTransNotifyInfo notifyInfo) {
        FileElement b16;
        int intValue;
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        if (!c() || (b16 = b(notifyInfo)) == null) {
            return;
        }
        Integer num = b16.transferStatus;
        Integer num2 = notifyInfo.msgRecord.fileGroupSize;
        if (num2 == null) {
            intValue = 0;
        } else {
            intValue = num2.intValue();
        }
        MsgRecord msgRecord = notifyInfo.msgRecord;
        Intrinsics.checkNotNullExpressionValue(msgRecord, "notifyInfo.msgRecord");
        boolean S = MsgExtKt.S(msgRecord);
        if ((num == null || num.intValue() != 4) && (num == null || num.intValue() != 5)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("multi_pic_send_total_cnt", String.valueOf(intValue));
        hashMap.put("multi_pic_status", String.valueOf(num));
        hashMap.put("multi_pic_send_type", String.valueOf(S ? 1 : 0));
        QLog.d("MultiPicReporter", 1, "reportMultiPicSendResult params:" + hashMap);
        com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "FileTransfer", hashMap);
    }
}
