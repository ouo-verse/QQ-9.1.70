package ij4;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.qqlive.common.api.AegisLogger;
import nr4.e;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static int a(d dVar) {
        if (dVar == null) {
            AegisLogger.e("Gift|GiftFansGroup", "getGiftLevel", "giftData is null");
            return -1;
        }
        if (TextUtils.isEmpty(dVar.f264872b0)) {
            AegisLogger.e("Gift|GiftFansGroup", "getGiftLevel", "fansGroupLevel is null");
            return -1;
        }
        return Integer.valueOf(dVar.f264872b0).intValue();
    }

    public static boolean b(nr4.d dVar) {
        if (dVar == null) {
            AegisLogger.e("Gift|GiftFansGroup", "hasFansGroup", "hasFansGroup, mFansGroupRsp is null");
            return false;
        }
        if (!jj4.d.g()) {
            AegisLogger.e("Gift|GiftFansGroup", "hasFansGroup", "false, is not Enable");
            return false;
        }
        return dVar.f421217d.f421210f;
    }

    public static boolean c(d dVar) {
        if (dVar == null) {
            AegisLogger.e("Gift|GiftFansGroup", "isFansGroupGift", "giftData is null");
            return false;
        }
        if (TextUtils.isEmpty(dVar.f264871a0) || dVar.f264871a0.compareTo("1") != 0) {
            return false;
        }
        return true;
    }

    public static boolean d(nr4.d dVar) {
        if (dVar == null) {
            AegisLogger.e("Gift|GiftFansGroup", "isJoinFansGroup", "mFansGroupRsp is null");
            return false;
        }
        if (dVar.f421217d.f421205a != 1) {
            return false;
        }
        return true;
    }

    public static boolean e(d dVar, nr4.d dVar2) {
        if (dVar == null) {
            AegisLogger.e("Gift|GiftFansGroup", "isUnlockGift", "giftData is null");
            return false;
        }
        if (!d(dVar2)) {
            AegisLogger.i("Gift|GiftFansGroup", "isUnlockGift", "do not join fansgroup");
            return false;
        }
        int a16 = a(dVar);
        if (-1 == a16) {
            AegisLogger.e("Gift|GiftFansGroup", "isUnlockGift", "need fansGroupLevel is -1");
            return true;
        }
        int i3 = dVar2.f421216c.f421220b;
        if (i3 < a16) {
            return false;
        }
        AegisLogger.i("Gift|GiftFansGroup", "isUnlockGift", "unlock fansGroupGift, curLevel=" + i3 + ", needLevel=" + a16);
        return true;
    }

    public static String f(nr4.d dVar) {
        int i3;
        if (dVar != null && dVar.f421217d != null) {
            String str = "fansgroupinfo{ join_status=" + dVar.f421217d.f421205a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(", level=");
            e eVar = dVar.f421216c;
            if (eVar != null) {
                i3 = eVar.f421220b;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append(" }");
            return sb5.toString();
        }
        return "";
    }
}
