package k12;

import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GetGiftListRsp;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<giftList$GroupGiftItem> f411402a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f411403b = true;

    /* renamed from: c, reason: collision with root package name */
    private String f411404c = "";

    /* renamed from: d, reason: collision with root package name */
    private long f411405d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f411406e = 0;

    public String a() {
        return this.f411404c;
    }

    public List<giftList$GroupGiftItem> b() {
        return this.f411402a;
    }

    public long c() {
        return this.f411406e;
    }

    public boolean d() {
        return this.f411403b;
    }

    public void e(String str) {
        this.f411404c = str;
    }

    public void f(giftList$GetGiftListRsp giftlist_getgiftlistrsp) {
        if (giftlist_getgiftlistrsp == null) {
            return;
        }
        this.f411403b = giftlist_getgiftlistrsp.hasMore.get();
        this.f411402a = giftlist_getgiftlistrsp.giftList.get();
        this.f411404c = giftlist_getgiftlistrsp.attachInfo.get();
        this.f411406e = giftlist_getgiftlistrsp.total.get();
        this.f411405d = System.currentTimeMillis() + (giftlist_getgiftlistrsp.duration.get() * 1000);
    }
}
