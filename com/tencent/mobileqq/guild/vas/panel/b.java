package com.tencent.mobileqq.guild.vas.panel;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface a {
        void a();
    }

    void a();

    void b();

    void d(String str, String str2, String str3, Drawable drawable);

    void e(int i3, int i16);

    void g(Activity activity, List<giftList$GroupGiftItem> list, a aVar, long j3);

    void onFreeGiftCountDownEnd();

    void onFreeGiftCountDownStart();

    void toRechargePanel(String str);

    void toastSendError();

    void updateCoins(long j3, String str);

    void updateGiftPanel(List<giftList$GroupGiftItem> list);
}
