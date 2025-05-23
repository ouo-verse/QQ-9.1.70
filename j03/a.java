package j03;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.g;
import com.tencent.mobileqq.vas.bubble.diy.BubbleDiyComu$Bubble_GetDiyText_Req;
import com.tencent.mobileqq.vas.bubble.diy.BubbleDiyComu$Bubble_Req;
import com.tencent.mobileqq.vas.bubble.diy.BubbleDiyComu$Bubble_Req_Comm;
import com.tencent.mobileqq.vas.bubble.diy.BubbleDiyComu$Bubble_Rsp;
import com.tencent.mobileqq.vas.bubble.diy.BubbleDiyComu$UserTextInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ8\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H\u0002J&\u0010\f\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lj03/a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uinAndDiyIds", "Lcom/tencent/mobileqq/vas/bubble/diy/BubbleDiyComu$UserTextInfo;", "textInfoList", "", "a", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observer", "b", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    private final void a(ArrayList<String> uinAndDiyIds, ArrayList<BubbleDiyComu$UserTextInfo> textInfoList) {
        List split$default;
        long j3;
        Iterator<String> it = uinAndDiyIds.iterator();
        while (it.hasNext()) {
            String uinAndDiyId = it.next();
            BubbleDiyComu$UserTextInfo bubbleDiyComu$UserTextInfo = new BubbleDiyComu$UserTextInfo();
            Intrinsics.checkNotNullExpressionValue(uinAndDiyId, "uinAndDiyId");
            split$default = StringsKt__StringsKt.split$default((CharSequence) uinAndDiyId, new String[]{"_"}, false, 0, 6, (Object) null);
            int i3 = 0;
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length == 2) {
                try {
                    j3 = Long.parseLong(strArr[0]);
                    try {
                        i3 = Integer.parseInt(strArr[1]);
                    } catch (NumberFormatException e16) {
                        e = e16;
                        QLog.e("RequestDiyBubbleData", 1, "", e);
                        if (j3 > 0) {
                            bubbleDiyComu$UserTextInfo.text_uin.set(j3);
                            bubbleDiyComu$UserTextInfo.text_id.set(i3);
                            textInfoList.add(bubbleDiyComu$UserTextInfo);
                        }
                    }
                } catch (NumberFormatException e17) {
                    e = e17;
                    j3 = 0;
                }
                if (j3 > 0 && i3 > 0) {
                    bubbleDiyComu$UserTextInfo.text_uin.set(j3);
                    bubbleDiyComu$UserTextInfo.text_id.set(i3);
                    textInfoList.add(bubbleDiyComu$UserTextInfo);
                }
            }
        }
    }

    public final void b(@NotNull ArrayList<String> uinAndDiyIds, @NotNull BusinessObserver observer) {
        Intrinsics.checkNotNullParameter(uinAndDiyIds, "uinAndDiyIds");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (uinAndDiyIds.isEmpty()) {
            return;
        }
        BubbleDiyComu$Bubble_Req_Comm bubbleDiyComu$Bubble_Req_Comm = new BubbleDiyComu$Bubble_Req_Comm();
        bubbleDiyComu$Bubble_Req_Comm.platform.set(109L);
        bubbleDiyComu$Bubble_Req_Comm.osver.set(Build.VERSION.RELEASE);
        bubbleDiyComu$Bubble_Req_Comm.mqqver.set(g.f308459b.getSubVersion());
        BubbleDiyComu$Bubble_GetDiyText_Req bubbleDiyComu$Bubble_GetDiyText_Req = new BubbleDiyComu$Bubble_GetDiyText_Req();
        ArrayList<BubbleDiyComu$UserTextInfo> arrayList = new ArrayList<>();
        a(uinAndDiyIds, arrayList);
        if (arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.i("RequestDiyBubbleData", 2, "no diy id need request: " + TextUtils.join(",", uinAndDiyIds));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RequestDiyBubbleData", 2, "try fetchDiyTexts: " + TextUtils.join(",", uinAndDiyIds));
        }
        bubbleDiyComu$Bubble_GetDiyText_Req.user_text_info.set(arrayList);
        BubbleDiyComu$Bubble_Req bubbleDiyComu$Bubble_Req = new BubbleDiyComu$Bubble_Req();
        bubbleDiyComu$Bubble_Req.cmd.set(1);
        bubbleDiyComu$Bubble_Req.packet_seq.set(System.currentTimeMillis());
        bubbleDiyComu$Bubble_Req.comm.set(bubbleDiyComu$Bubble_Req_Comm);
        bubbleDiyComu$Bubble_Req.reqcmd_0x01.set(bubbleDiyComu$Bubble_GetDiyText_Req);
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("bubble.1", bubbleDiyComu$Bubble_Req, BubbleDiyComu$Bubble_Rsp.class, observer);
    }
}
