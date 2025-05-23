package com.dataline.nt;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.msg.migration.DataLineNTMsgMigrationUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/dataline/nt/f;", "Lcom/tencent/qqnt/aio/msg/b;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "", "b", "", "getBusinessType", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class f implements com.tencent.qqnt.aio.msg.b {
    private final void b(QQAppInterface app, FileElement fileElement, FileManagerEntity entity) {
        CharSequence trim;
        boolean equals;
        CharSequence trim2;
        boolean z16;
        String str = entity.Uuid;
        boolean z17 = false;
        if (str != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) str);
            equals = StringsKt__StringsJVMKt.equals(trim.toString(), "null", true);
            if (!equals) {
                trim2 = StringsKt__StringsKt.trim((CharSequence) str);
                if (trim2.toString().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
        }
        if (z17) {
            return;
        }
        entity.Uuid = fileElement.fileUuid;
        app.getFileManagerDataCenter().f0(entity);
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public void a(@NotNull AIOMsgItem msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getMsgRecord().chatType != 8 || msg2.getMsgRecord().elements.isEmpty()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String str = msg2.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msg.msgRecord.peerUid");
        String d16 = DataLineNTMsgMigrationUtil.d(str);
        String str2 = msg2.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msg.msgRecord.peerUid");
        int i3 = DataLineNTMsgMigrationUtil.i(str2);
        ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(msgElement.elementId, d16, i3);
            if (E != null) {
                Intrinsics.checkNotNullExpressionValue(E, "queryFileEntityByUniseq(\u2026entId, peerUin, peerType)");
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "it.fileElement");
                b(qQAppInterface, fileElement, E);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public int getBusinessType() {
        return 6;
    }
}
