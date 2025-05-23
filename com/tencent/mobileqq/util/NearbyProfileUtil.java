package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.utils.StringUtil;

/* loaded from: classes20.dex */
public class NearbyProfileUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f306392a = {"\u7537", "\u5973"};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f306393b = {R.drawable.ezy, R.drawable.f161794f05};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f306394c = {"\u672a\u77e5", "\u4fdd\u5bc6", "\u5355\u8eab", "\u604b\u7231\u4e2d", "\u5df2\u5a5a"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f306395d = {"", "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7", "\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f306396e = {IProfileCardConst.NAME_NO_LIMIT, "\u8ba1\u7b97\u673a/\u4e92\u8054\u7f51/\u901a\u4fe1", "\u751f\u4ea7/\u5de5\u827a/\u5236\u9020", "\u533b\u7597/\u62a4\u7406/\u5236\u836f", "\u91d1\u878d/\u94f6\u884c/\u6295\u8d44/\u4fdd\u9669", "\u5546\u4e1a/\u670d\u52a1\u4e1a/\u4e2a\u4f53\u7ecf\u8425", "\u6587\u5316/\u5e7f\u544a/\u4f20\u5a92", "\u5a31\u4e50/\u827a\u672f/\u8868\u6f14", "\u5f8b\u5e08/\u6cd5\u52a1", "\u6559\u80b2/\u57f9\u8bad", "\u516c\u52a1\u5458/\u884c\u653f/\u4e8b\u4e1a\u5355\u4f4d", "\u6a21\u7279", "\u7a7a\u59d0", "\u5b66\u751f", "\u5176\u4ed6\u804c\u4e1a"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f306397f = {"", "IT", "\u5236\u9020", "\u533b\u7597", "\u91d1\u878d", "\u5546\u4e1a", "\u6587\u5316", "\u827a\u672f", "\u6cd5\u5f8b", "\u6559\u80b2", "\u884c\u653f", "\u6a21\u7279", "\u7a7a\u59d0", "\u5b66\u751f", ""};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f306398g = {R.drawable.f5n, R.drawable.f161721eo2, R.drawable.f161721eo2, R.drawable.f161721eo2, R.drawable.f1h, R.drawable.f1h, R.drawable.f161856f60, R.drawable.f161856f60, R.drawable.f161781ey1, R.drawable.f161781ey1, R.drawable.f161781ey1, R.drawable.f5n, R.drawable.f5n, R.drawable.f2d, R.drawable.f5n};

    /* renamed from: com.tencent.mobileqq.util.NearbyProfileUtil$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f306399d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f306400e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f306401f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ l92.a f306402h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f306403i;

        @Override // java.lang.Runnable
        public void run() {
            NearbyPeopleCard nearbyPeopleCard;
            EntityManager createEntityManager = this.f306399d.getEntityManagerFactory().createEntityManager();
            byte[] bArr = null;
            long j3 = 0;
            if (createEntityManager != null) {
                long j16 = this.f306400e;
                if (j16 > 0) {
                    nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "tinyId=?", new String[]{String.valueOf(j16)});
                } else {
                    nearbyPeopleCard = null;
                }
                if (nearbyPeopleCard == null && !StringUtil.isEmpty(this.f306401f)) {
                    nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{this.f306401f});
                }
                if (nearbyPeopleCard != null) {
                    bArr = nearbyPeopleCard.vSeed;
                    j3 = nearbyPeopleCard.feedPreviewTime;
                }
                createEntityManager.close();
            }
            NearbyProfileUtil.a(this.f306402h, this.f306399d, this.f306400e, this.f306401f, this.f306403i, bArr, j3, false, 0L, false, 0L, 0);
        }
    }

    public static final void a(l92.a aVar, QQAppInterface qQAppInterface, long j3, String str, int i3, byte[] bArr, long j16, boolean z16, long j17, boolean z17, long j18, int i16) {
        int i17 = 51;
        if (j3 > 0) {
            if (ProfileEntryUtils.isFromFreshNews(i3)) {
                aVar.h2(qQAppInterface.getCurrentAccountUin(), "0", 45, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, j3, true, z16, j17, z17, j18, i16);
                return;
            }
            if (ProfileEntryUtils.isFromDating(i3)) {
                aVar.h2(qQAppInterface.getCurrentAccountUin(), "0", 39, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, j3, true, z16, j17, z17, j18, i16);
                return;
            }
            if (i3 == 16) {
                aVar.h2(qQAppInterface.getCurrentAccountUin(), "0", 46, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, j3, true, z16, j17, z17, j18, i16);
                return;
            }
            if (i3 == 38) {
                aVar.h2(qQAppInterface.getCurrentAccountUin(), "0", 47, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, j3, true, z16, j17, z17, j18, i16);
                return;
            }
            if (i3 == 100) {
                aVar.h2(qQAppInterface.getCurrentAccountUin(), "0", 49, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, j3, true, z16, j17, z17, j18, i16);
                return;
            } else if (i3 == 51) {
                aVar.h2(qQAppInterface.getCurrentAccountUin(), "0", 51, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, j3, true, z16, j17, z17, j18, i16);
                return;
            } else {
                aVar.h2(qQAppInterface.getCurrentAccountUin(), "0", 41, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, j3, true, z16, j17, z17, j18, i16);
                return;
            }
        }
        if (str.equals(qQAppInterface.getCurrentAccountUin())) {
            aVar.h2(qQAppInterface.getCurrentAccountUin(), qQAppInterface.getCurrentAccountUin(), 0, 0L, (byte) 0, 0L, 0L, null, "", c(), 10004, null, 0L, true, z16, j17, z17, j18, i16);
            return;
        }
        if (ProfileEntryUtils.isFromHotChat(i3)) {
            i17 = 42;
        } else if (ProfileEntryUtils.isFromFreshNews(i3)) {
            i17 = 45;
        } else if (ProfileEntryUtils.isFromDating(i3)) {
            i17 = 39;
        } else if (i3 == 16) {
            i17 = 46;
        } else if (i3 == 38) {
            i17 = 47;
        } else if (i3 != 51) {
            i17 = 6;
        }
        aVar.h2(qQAppInterface.getCurrentAccountUin(), str, i17, j16, (byte) 0, 0L, 0L, bArr, "", c(), 10004, null, 0L, true, z16, j17, z17, j18, i16);
    }

    public static final String b(int i3) {
        if (i3 >= 1 && i3 <= 12) {
            return f306395d[i3];
        }
        return "";
    }

    private static final long c() {
        return 38916L;
    }

    public static final String d(int i3) {
        if (i3 >= 1 && i3 <= 14) {
            return f306396e[i3];
        }
        return "";
    }

    public static final String e(int i3) {
        if (i3 >= 0 && i3 <= 14) {
            return f306397f[i3];
        }
        return "";
    }

    public static boolean f(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return true;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        NearbyPeopleCard nearbyPeopleCard = null;
        if (createEntityManager != null) {
            if (!StringUtil.isEmpty(currentAccountUin)) {
                nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{currentAccountUin});
            }
            createEntityManager.close();
        }
        if (nearbyPeopleCard == null || nearbyPeopleCard.switchGiftVisible == 0) {
            return true;
        }
        return false;
    }

    public static boolean g(int i3) {
        if (i3 != -1 && (i3 < 0 || i3 >= f306396e.length)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(QQAppInterface qQAppInterface, boolean z16) {
        if (qQAppInterface == null) {
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_nearby_people_card", true);
        bundle.putShort("key_new_profile_modified_flag", (short) 1);
        bundle.putShort("key_flower_visible_switch", (short) (!z16 ? 1 : 0));
        bundle.putBoolean("key_nearby_people_card_force_update", true);
        final l92.a aVar = (l92.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
        if (aVar != null) {
            qQAppInterface.execute(new Runnable() { // from class: com.tencent.mobileqq.util.NearbyProfileUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    l92.a.this.G(bundle, null, null, false, false, false, false);
                }
            });
        }
    }
}
