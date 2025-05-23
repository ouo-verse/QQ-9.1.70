package com.tencent.mobileqq.util;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dc {
    public static CardProfile a(BaseQQAppInterface baseQQAppInterface, long j3, int i3) {
        EntityManager createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            boolean z16 = false;
            CardProfile cardProfile = (CardProfile) DBMethodProxy.find(createEntityManager, CardProfile.class, "lEctID=? and type=?", new String[]{Long.toString(j3), Integer.toString(i3)});
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("readFromDb. uin:");
                sb5.append(j3);
                sb5.append(" find:");
                if (cardProfile != null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.i("VoteUtil", 2, sb5.toString());
                return cardProfile;
            }
            return cardProfile;
        }
        return null;
    }

    public static void b(BaseQQAppInterface baseQQAppInterface, long j3, int i3) {
        EntityManager createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            boolean z16 = false;
            CardProfile cardProfile = (CardProfile) DBMethodProxy.find(createEntityManager, CardProfile.class, "lEctID=? and type=?", new String[]{Long.toString(j3), Integer.toString(2)});
            if (cardProfile != null) {
                long j16 = i3;
                cardProfile.bAvailableCnt -= j16;
                cardProfile.bTodayVotedCnt += j16;
                if (cardProfile.getStatus() == 1000) {
                    createEntityManager.persistOrReplace(cardProfile);
                } else {
                    createEntityManager.update(cardProfile);
                }
            }
            CardProfile cardProfile2 = (CardProfile) DBMethodProxy.find(createEntityManager, CardProfile.class, "lEctID=? and type=?", new String[]{Long.toString(j3), Integer.toString(3)});
            if (cardProfile2 != null) {
                long j17 = i3;
                cardProfile2.bAvailableCnt -= j17;
                long j18 = cardProfile2.bTodayVotedCnt + j17;
                cardProfile2.bTodayVotedCnt = j18;
                cardProfile2.bVoteCnt = (short) j18;
                if (cardProfile2.getStatus() == 1000) {
                    createEntityManager.persistOrReplace(cardProfile2);
                } else {
                    createEntityManager.update(cardProfile2);
                }
            }
            createEntityManager.close();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateProfileCardVote. uin:");
                sb5.append(j3);
                sb5.append(" find:");
                if (cardProfile != null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.i("VoteUtil", 2, sb5.toString());
            }
        }
    }
}
