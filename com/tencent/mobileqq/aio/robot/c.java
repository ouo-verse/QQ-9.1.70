package com.tencent.mobileqq.aio.robot;

import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RobotMsgExt;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JT\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/c;", "Lcom/tencent/qqnt/kernel/api/d;", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "msgAttrs", "", "a", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements com.tencent.qqnt.kernel.api.d {
    @Override // com.tencent.qqnt.kernel.api.d
    public void a(long msgId, @NotNull Contact contact, @NotNull ArrayList<MsgElement> msgElements, @NotNull HashMap<Integer, MsgAttributeInfo> msgAttrs) {
        AppRuntime peekAppRuntime;
        MsgAttributeInfo b16;
        Long l3;
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(msgAttrs, "msgAttrs");
        if (contact.chatType != 2 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        Iterator<T> it = msgElements.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            TextElement textElement = ((MsgElement) it.next()).textElement;
            if (textElement != null) {
                Intrinsics.checkNotNullExpressionValue(textElement, "textElement");
                int i3 = textElement.atType;
                if ((i3 & 1) == 0) {
                    if ((i3 & 2) != 0) {
                        ag uixConvertService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getUixConvertService();
                        if (uixConvertService != null) {
                            String str = textElement.atNtUid;
                            Intrinsics.checkNotNullExpressionValue(str, "it.atNtUid");
                            l3 = uixConvertService.z0(str);
                        } else {
                            l3 = null;
                        }
                        if (((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotUin(String.valueOf(l3))) {
                        }
                    }
                }
                z16 = true;
            }
        }
        if (z16) {
            MsgAttributeInfo msgAttributeInfo = msgAttrs.get(9);
            if (msgAttributeInfo == null) {
                msgAttributeInfo = new MsgAttributeInfo();
                msgAttributeInfo.attrType = 9;
            }
            b16 = com.tencent.qqnt.kernel.util.a.f359256a.b(msgAttributeInfo, (i3 & 2) != 0 ? null : null, (i3 & 4) != 0 ? null : null, (i3 & 8) != 0 ? null : null, (i3 & 16) != 0 ? null : null, (i3 & 32) != 0 ? null : null, (i3 & 64) != 0 ? null : null, (i3 & 128) != 0 ? null : null, (i3 & 256) != 0 ? null : null, (i3 & 512) != 0 ? null : null, (i3 & 1024) != 0 ? null : null, (i3 & 2048) != 0 ? null : null, (i3 & 4096) != 0 ? null : new RobotMsgExt(true), (i3 & 8192) != 0 ? null : null, (i3 & 16384) != 0 ? null : null, (i3 & 32768) != 0 ? null : null, (i3 & 65536) != 0 ? null : null, (i3 & 131072) != 0 ? null : null, (i3 & 262144) != 0 ? null : null, (i3 & 524288) != 0 ? null : null, (i3 & 1048576) != 0 ? null : null, (i3 & 2097152) == 0 ? null : null);
            msgAttrs.put(9, b16);
        }
    }
}
