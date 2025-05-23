package aw0;

import android.text.TextUtils;
import bw0.c;
import com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$GetFansGroupInfoRsp;
import com.tencent.mobileqq.qqgift.data.service.d;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static int a(d dVar) {
        if (dVar == null) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "getGiftLevel", "giftData is null");
            return -1;
        }
        if (TextUtils.isEmpty(dVar.f264872b0)) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "getGiftLevel", "fansGroupLevel is null");
            return -1;
        }
        return Integer.valueOf(dVar.f264872b0).intValue();
    }

    public static boolean b(TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp) {
        if (trpcFansGroupOuterClass$GetFansGroupInfoRsp == null) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "hasFansGroup", "hasFansGroup, mFansGroupRsp is null");
            return false;
        }
        if (!c.d()) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "hasFansGroup", "false, is not Enable");
            return false;
        }
        return trpcFansGroupOuterClass$GetFansGroupInfoRsp.group_info.has_fans_group.get();
    }

    public static boolean c(d dVar) {
        if (dVar == null) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "isFansGroupGift", "giftData is null");
            return false;
        }
        if (TextUtils.isEmpty(dVar.f264871a0) || dVar.f264871a0.compareTo("1") != 0) {
            return false;
        }
        return true;
    }

    public static boolean d(TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp) {
        if (trpcFansGroupOuterClass$GetFansGroupInfoRsp == null) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "isJoinFansGroup", "mFansGroupRsp is null");
            return false;
        }
        if (trpcFansGroupOuterClass$GetFansGroupInfoRsp.group_info.status.get() != 1) {
            return false;
        }
        return true;
    }

    public static boolean e(d dVar, TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp) {
        if (dVar == null) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "isUnlockGift", "giftData is null");
            return false;
        }
        if (!d(trpcFansGroupOuterClass$GetFansGroupInfoRsp)) {
            rt0.a.f("ICGameGift|ICGameGiftFansGroup", "isUnlockGift", "do not join fansgroup");
            return false;
        }
        int a16 = a(dVar);
        if (-1 == a16) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "isUnlockGift", "need fansGroupLevel is -1");
            return true;
        }
        int i3 = trpcFansGroupOuterClass$GetFansGroupInfoRsp.level_info.level.get();
        if (i3 < a16) {
            return false;
        }
        rt0.a.f("ICGameGift|ICGameGiftFansGroup", "isUnlockGift", "unlock fansGroupGift, curLevel=" + i3 + ", needLevel=" + a16);
        return true;
    }

    public static String f(TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp) {
        if (trpcFansGroupOuterClass$GetFansGroupInfoRsp != null) {
            return ("fansgroupinfo{ join_status=" + trpcFansGroupOuterClass$GetFansGroupInfoRsp.group_info.status.get()) + ", level=" + trpcFansGroupOuterClass$GetFansGroupInfoRsp.level_info.level.get() + " }";
        }
        return "";
    }
}
