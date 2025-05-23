package li0;

import android.net.Uri;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00022\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lli0/b;", "", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/TicketIdentifier;", "id", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "detail", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f414604a = new b();

    b() {
    }

    public final String a(String id5, TicketDetail detail) {
        return Uri.parse("mqqapi://ecommerce/open?").buildUpon().appendQueryParameter("target", String.valueOf(52)).appendQueryParameter("page_name", "ticket_detail_page").appendQueryParameter(WadlProxyConsts.CHANNEL, "2").appendQueryParameter("name", detail.name).appendQueryParameter("id", id5).appendQueryParameter("deadline_str", detail.deadlineStr).appendQueryParameter("condition", detail.condition).appendQueryParameter("contact", detail.contact).appendQueryParameter("note", detail.note).build().toString();
    }
}
