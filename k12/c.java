package k12;

import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface c {
    com.tencent.mobileqq.qqgift.data.service.c a(long j3, int i3);

    List<giftList$GroupGiftItem> b(String str);

    long c();

    void d(String str);

    void getCoins();

    void preLoadGiftData(String str);

    void sendGift(long j3, int i3, int i16);
}
