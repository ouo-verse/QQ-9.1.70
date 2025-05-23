package ll;

import com.tencent.qqnt.kernel.nativeinterface.RichMsgType;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StRichMsg;
import ef.d;
import fj.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mk.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000e"}, d2 = {"Lll/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StRichMsg;", "stRichMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "commonExt", "", "b", "a", "", "richMsgItems", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414984a = new a();

    a() {
    }

    private final String a(StRichMsg stRichMsg, StCommonExt commonExt) {
        long g16;
        String str = stRichMsg.uin;
        if (!(str == null || str.length() == 0)) {
            g16 = d.k(stRichMsg.uin);
        } else {
            g16 = h.f416877a.g(stRichMsg.uid, commonExt);
        }
        return "@{uin:" + g16 + ",nick:" + s.f399470a.a(String.valueOf(g16), stRichMsg.name) + ",who:" + stRichMsg.who + "}";
    }

    private final String b(StRichMsg stRichMsg, StCommonExt commonExt) {
        return "{url:" + h.f416877a.a(stRichMsg.url, commonExt) + ",text:" + stRichMsg.content + "}";
    }

    public final String c(List<StRichMsg> richMsgItems, StCommonExt commonExt) {
        StringBuilder sb5 = new StringBuilder();
        if (richMsgItems != null) {
            for (StRichMsg stRichMsg : richMsgItems) {
                int i3 = stRichMsg.type;
                if (i3 == RichMsgType.KRICHMSGTYPEPLAINTEXT.ordinal()) {
                    sb5.append(stRichMsg.content);
                } else if (i3 == RichMsgType.KRICHMSGTYPEAT.ordinal()) {
                    sb5.append(f414984a.a(stRichMsg, commonExt));
                } else if (i3 == RichMsgType.KRICHMSGTYPEURL.ordinal()) {
                    sb5.append(f414984a.b(stRichMsg, commonExt));
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    public static /* synthetic */ String d(a aVar, List list, StCommonExt stCommonExt, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            stCommonExt = null;
        }
        return aVar.c(list, stCommonExt);
    }
}
