package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeywordInfo;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeywordRuleInfo;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static List<h> a(oidb_0x496$AioKeyword oidb_0x496_aiokeyword) {
        if (oidb_0x496_aiokeyword != null && oidb_0x496_aiokeyword.has() && oidb_0x496_aiokeyword.keywords.has()) {
            ArrayList arrayList = new ArrayList();
            for (oidb_0x496$AioKeywordInfo oidb_0x496_aiokeywordinfo : oidb_0x496_aiokeyword.keywords.get()) {
                h hVar = new h();
                hVar.f294904a = oidb_0x496_aiokeywordinfo.word.get();
                hVar.f294905b = oidb_0x496_aiokeywordinfo.rule_id.get();
                arrayList.add(hVar);
            }
            return arrayList;
        }
        return null;
    }

    public static List<i> b(oidb_0x496$AioKeyword oidb_0x496_aiokeyword) {
        if (oidb_0x496_aiokeyword != null && oidb_0x496_aiokeyword.has() && oidb_0x496_aiokeyword.rules.has()) {
            ArrayList arrayList = new ArrayList();
            for (oidb_0x496$AioKeywordRuleInfo oidb_0x496_aiokeywordruleinfo : oidb_0x496_aiokeyword.rules.get()) {
                i iVar = new i();
                iVar.f294906a = oidb_0x496_aiokeywordruleinfo.rule_id.get();
                iVar.f294907b = oidb_0x496_aiokeywordruleinfo.start_time.get();
                iVar.f294908c = oidb_0x496_aiokeywordruleinfo.end_time.get();
                iVar.f294909d = oidb_0x496_aiokeywordruleinfo.postion_flag.get();
                iVar.f294910e = oidb_0x496_aiokeywordruleinfo.match_group_class.get();
                iVar.f294911f = oidb_0x496_aiokeywordruleinfo.version.get();
                arrayList.add(iVar);
            }
            return arrayList;
        }
        return null;
    }

    public static oidb_0x496$AioKeyword c() {
        byte[] fileToBytes = FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath("0x496_aio_keyword"));
        oidb_0x496$AioKeyword oidb_0x496_aiokeyword = new oidb_0x496$AioKeyword();
        if (fileToBytes == null) {
            return oidb_0x496_aiokeyword;
        }
        try {
            oidb_0x496_aiokeyword.mergeFrom(fileToBytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopAioKeywordHelper", 2, "get0x496AioKeyword," + e16.toString());
            }
        }
        return oidb_0x496_aiokeyword;
    }

    public static List<String> d(QQAppInterface qQAppInterface) {
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(TroopAioKeyBlackRule.class);
        ArrayList arrayList = new ArrayList();
        if (query == null) {
            return arrayList;
        }
        Iterator<? extends Entity> it = query.iterator();
        while (it.hasNext()) {
            arrayList.add(((TroopAioKeyBlackRule) it.next()).mBlackUinKeywordRuleId);
        }
        createEntityManager.close();
        return arrayList;
    }

    public static TroopAioKeywordTipInfo e(QQAppInterface qQAppInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        TroopAioKeywordTipInfo troopAioKeywordTipInfo = (TroopAioKeywordTipInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TroopAioKeywordTipInfo.class, str);
        createEntityManager.close();
        if (QLog.isColorLevel()) {
            if (troopAioKeywordTipInfo == null) {
                QLog.i("TroopAioKeywordHelper", 2, "getLocalTipInfo, tipInfo = null");
            } else {
                QLog.i("TroopAioKeywordHelper", 2, "getLocalTipInfo, tipInfo = " + troopAioKeywordTipInfo.toString());
            }
        }
        return troopAioKeywordTipInfo;
    }

    public static List<TroopAioKeywordTipInfo> f(QQAppInterface qQAppInterface, String[] strArr) {
        ArrayList arrayList = new ArrayList(15);
        if (strArr != null && strArr.length != 0) {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            for (String str : strArr) {
                TroopAioKeywordTipInfo troopAioKeywordTipInfo = (TroopAioKeywordTipInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TroopAioKeywordTipInfo.class, str);
                if (troopAioKeywordTipInfo != null) {
                    arrayList.add(troopAioKeywordTipInfo);
                }
            }
            createEntityManager.close();
            if (QLog.isColorLevel()) {
                QLog.i("TroopAioKeywordHelper", 2, "getLocalTipInfo, tipInfos=" + arrayList.toString());
            }
        }
        return arrayList;
    }

    public static void g(QQAppInterface qQAppInterface, oidb_0x496$AioKeyword oidb_0x496_aiokeyword) {
        StringBuilder sb5;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = BaseApplication.getContext().openFileOutput("0x496_aio_keyword", 0);
                fileOutputStream.write(oidb_0x496_aiokeyword.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).updateTroopAioKeyWordVersion(BaseApplicationImpl.getApplication(), qQAppInterface.getCurrentAccountUin(), oidb_0x496_aiokeyword.version.get());
                try {
                    fileOutputStream.close();
                } catch (IOException e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("saveFile=");
                        sb5.append(e.toString());
                        QLog.e("TroopAioKeywordHelper", 2, sb5.toString());
                    }
                }
            } catch (IOException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopAioKeywordHelper", 2, "saveFile=" + e17.toString());
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("saveFile=");
                            sb5.append(e.toString());
                            QLog.e("TroopAioKeywordHelper", 2, sb5.toString());
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e19) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TroopAioKeywordHelper", 2, "saveFile=" + e19.toString());
                    }
                }
            }
            throw th5;
        }
    }

    public static void h(QQAppInterface qQAppInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        TroopAioKeyBlackRule troopAioKeyBlackRule = new TroopAioKeyBlackRule();
        troopAioKeyBlackRule.mBlackUinKeywordRuleId = str;
        createEntityManager.persistOrReplace(troopAioKeyBlackRule);
        createEntityManager.close();
    }

    public static void i(QQAppInterface qQAppInterface, List<TroopAioKeywordTipInfo> list) {
        if (list != null && list.size() != 0) {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            Iterator<TroopAioKeywordTipInfo> it = list.iterator();
            while (it.hasNext()) {
                createEntityManager.persistOrReplace(it.next());
            }
            createEntityManager.close();
        }
    }
}
