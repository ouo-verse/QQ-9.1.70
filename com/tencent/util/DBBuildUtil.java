package com.tencent.util;

import com.tencent.mobileqq.activity.aio.QcircleRedDotEntity;
import com.tencent.mobileqq.activity.aio.QzoneRedDotEntity;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PYMKBizEntryInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PushSwitchGrayTipsInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ReportedBanner;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TempMsgInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfoExt;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.bridge.DBVersionProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.troop.aionickicon.TroopMemberIconData;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTIntimateBaseEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import nd2.aa;
import nd2.ab;
import nd2.ac;
import nd2.ad;
import nd2.ae;
import nd2.af;
import nd2.ag;
import nd2.p;
import nd2.q;
import nd2.r;
import nd2.s;
import nd2.t;
import nd2.u;
import nd2.v;
import nd2.w;
import nd2.x;
import nd2.y;
import nd2.z;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DBBuildUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DBInjectUtil";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends Interceptor<Void>>> sDBCorruptionInterceptorList;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 2)
    public static ArrayList<Class<? extends Entity>> sDBCreateTableList;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends IEntityManagerFactoryBuilderService>> sDBService;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends DBUpgradeEntity>> sDBUpgradeEntityList;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends Interceptor<Class>>> sTableColumnCheckInterceptorList;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/mqq/Inject_MqqCustomizedConfig.yml", version = 1)
    public static ArrayList<Class<? extends Entity>> sVerifyTableList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends IEntityManagerFactoryBuilderService>> arrayList = new ArrayList<>();
        sDBService = arrayList;
        arrayList.add(com.tencent.mobileqq.persistence.bridge.c.class);
        ArrayList<Class<? extends Entity>> arrayList2 = new ArrayList<>();
        sDBCreateTableList = arrayList2;
        arrayList2.add(Groups.class);
        sDBCreateTableList.add(Friends.class);
        sDBCreateTableList.add(RecentUser.class);
        sDBCreateTableList.add(Ability.class);
        sDBCreateTableList.add(NTIntimateBaseEntity.class);
        sDBCreateTableList.add(NTIntimateBaseEntity.class);
        sDBCreateTableList.add(Card.class);
        sDBCreateTableList.add(DiscussionInfo.class);
        sDBCreateTableList.add(PhoneContact.class);
        sDBCreateTableList.add(DataLineMsgRecord.class);
        sDBCreateTableList.add(PYMKBizEntryInfo.class);
        sDBCreateTableList.add(EmoticonPackage.class);
        sDBCreateTableList.add(Emoticon.class);
        sDBCreateTableList.add(EmoticonTab.class);
        sDBCreateTableList.add(RoamSetting.class);
        sDBCreateTableList.add(ShieldListInfo.class);
        sDBCreateTableList.add(ContactCard.class);
        sDBCreateTableList.add(QZoneCover.class);
        sDBCreateTableList.add(SearchHistory.class);
        sDBCreateTableList.add(ExtensionInfo.class);
        sDBCreateTableList.add(ExpiredPushBanner.class);
        sDBCreateTableList.add(HotChatInfo.class);
        sDBCreateTableList.add(SpecialCareInfo.class);
        sDBCreateTableList.add(FileManagerEntity.class);
        sDBCreateTableList.add(ReportedBanner.class);
        sDBCreateTableList.add(MedalInfo.class);
        sDBCreateTableList.add(TempMsgInfo.class);
        sDBCreateTableList.add(PushSwitchGrayTipsInfo.class);
        sDBCreateTableList.add(AppletsAccountInfo.class);
        sDBCreateTableList.add(ColorNote.class);
        sDBCreateTableList.add(FrontBackData.class);
        sDBCreateTableList.add(TofuItem.class);
        sDBCreateTableList.add(TroopEssenceMsgItem.class);
        sDBCreateTableList.add(QcircleRedDotEntity.class);
        sDBCreateTableList.add(QzoneRedDotEntity.class);
        sDBCreateTableList.add(TofuLimitMsg.class);
        sDBCreateTableList.add(TroopMemberIconData.class);
        sDBCreateTableList.add(TroopMemberInfoExt.class);
        sDBCreateTableList.add(TroopExtDBInfo.class);
        sDBCreateTableList.add(QQStrangerUserInfo.class);
        ArrayList<Class<? extends Entity>> arrayList3 = new ArrayList<>();
        sVerifyTableList = arrayList3;
        arrayList3.add(MessageRecord.class);
        sVerifyTableList.add(RecentUser.class);
        sVerifyTableList.add(Friends.class);
        ArrayList<Class<? extends Interceptor<Void>>> arrayList4 = new ArrayList<>();
        sDBCorruptionInterceptorList = arrayList4;
        arrayList4.add(ld2.b.class);
        sDBCorruptionInterceptorList.add(ld2.d.class);
        sDBCorruptionInterceptorList.add(ld2.c.class);
        ArrayList<Class<? extends Interceptor<Class>>> arrayList5 = new ArrayList<>();
        sTableColumnCheckInterceptorList = arrayList5;
        arrayList5.add(nd2.i.class);
        sTableColumnCheckInterceptorList.add(nd2.f.class);
        sTableColumnCheckInterceptorList.add(nd2.m.class);
        sTableColumnCheckInterceptorList.add(nd2.o.class);
        sTableColumnCheckInterceptorList.add(z.class);
        sTableColumnCheckInterceptorList.add(nd2.n.class);
        sTableColumnCheckInterceptorList.add(x.class);
        sTableColumnCheckInterceptorList.add(q.class);
        sTableColumnCheckInterceptorList.add(nd2.e.class);
        sTableColumnCheckInterceptorList.add(ae.class);
        sTableColumnCheckInterceptorList.add(nd2.h.class);
        sTableColumnCheckInterceptorList.add(ac.class);
        sTableColumnCheckInterceptorList.add(ab.class);
        sTableColumnCheckInterceptorList.add(t.class);
        sTableColumnCheckInterceptorList.add(w.class);
        sTableColumnCheckInterceptorList.add(nd2.a.class);
        sTableColumnCheckInterceptorList.add(p.class);
        sTableColumnCheckInterceptorList.add(s.class);
        sTableColumnCheckInterceptorList.add(u.class);
        sTableColumnCheckInterceptorList.add(v.class);
        sTableColumnCheckInterceptorList.add(af.class);
        sTableColumnCheckInterceptorList.add(r.class);
        sTableColumnCheckInterceptorList.add(y.class);
        sTableColumnCheckInterceptorList.add(nd2.b.class);
        sTableColumnCheckInterceptorList.add(ad.class);
        sTableColumnCheckInterceptorList.add(aa.class);
        sTableColumnCheckInterceptorList.add(nd2.k.class);
        sTableColumnCheckInterceptorList.add(nd2.d.class);
        sTableColumnCheckInterceptorList.add(ag.class);
        sTableColumnCheckInterceptorList.add(nd2.g.class);
        sTableColumnCheckInterceptorList.add(nd2.l.class);
        sTableColumnCheckInterceptorList.add(nd2.c.class);
        ArrayList<Class<? extends DBUpgradeEntity>> arrayList6 = new ArrayList<>();
        sDBUpgradeEntityList = arrayList6;
        arrayList6.add(md2.r.class);
        sDBUpgradeEntityList.add(md2.u.class);
        sDBUpgradeEntityList.add(md2.w.class);
        sDBUpgradeEntityList.add(md2.x.class);
        sDBUpgradeEntityList.add(md2.z.class);
        sDBUpgradeEntityList.add(md2.aa.class);
        sDBUpgradeEntityList.add(md2.ab.class);
        sDBUpgradeEntityList.add(md2.ac.class);
        sDBUpgradeEntityList.add(md2.ad.class);
        sDBUpgradeEntityList.add(md2.ae.class);
        sDBUpgradeEntityList.add(md2.af.class);
        sDBUpgradeEntityList.add(md2.a.class);
        sDBUpgradeEntityList.add(md2.b.class);
        sDBUpgradeEntityList.add(md2.c.class);
        sDBUpgradeEntityList.add(md2.d.class);
        sDBUpgradeEntityList.add(md2.e.class);
        sDBUpgradeEntityList.add(md2.f.class);
        sDBUpgradeEntityList.add(md2.g.class);
        sDBUpgradeEntityList.add(md2.h.class);
        sDBUpgradeEntityList.add(md2.i.class);
        sDBUpgradeEntityList.add(md2.j.class);
        sDBUpgradeEntityList.add(md2.k.class);
        sDBUpgradeEntityList.add(md2.l.class);
        sDBUpgradeEntityList.add(md2.m.class);
        sDBUpgradeEntityList.add(md2.n.class);
        sDBUpgradeEntityList.add(md2.o.class);
        sDBUpgradeEntityList.add(md2.p.class);
        sDBUpgradeEntityList.add(md2.q.class);
        sDBUpgradeEntityList.add(md2.s.class);
        sDBUpgradeEntityList.add(md2.t.class);
        sDBUpgradeEntityList.add(md2.v.class);
        sDBUpgradeEntityList.add(md2.y.class);
    }

    public DBBuildUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static List<Interceptor<Void>> createDBCorruptionInterceptorList() {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<? extends Interceptor<Void>>> it = sDBCorruptionInterceptorList.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().newInstance());
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
        return arrayList;
    }

    private static List<DBUpgradeEntity> createDBUpgradeEntityList() {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<? extends DBUpgradeEntity>> it = sDBUpgradeEntityList.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().newInstance());
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
        return arrayList;
    }

    private static List<Entity> createOnDBCreateTableList(IEntityManagerFactoryBuilderService iEntityManagerFactoryBuilderService) {
        ArrayList arrayList = new ArrayList(Arrays.asList(iEntityManagerFactoryBuilderService.getDBCreateTableProvider().get()));
        Iterator<Class<? extends Entity>> it = sDBCreateTableList.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().newInstance());
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
        return arrayList;
    }

    private static List<Interceptor<Class>> createTableColumnCheckList() {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<? extends Interceptor<Class>>> it = sTableColumnCheckInterceptorList.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().newInstance());
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
        return arrayList;
    }

    public static QQEntityManagerFactory.Builder getDefaultEntityManagerFactoryBuilder(String str) {
        QQEntityManagerFactory.Builder builder = new QQEntityManagerFactory.Builder(str, new DBVersionProvider());
        try {
            IEntityManagerFactoryBuilderService newInstance = sDBService.get(0).newInstance();
            builder.tableEntityList(createOnDBCreateTableList(newInstance)).verifyClassList(sVerifyTableList).corruptionInterceptors(createDBCorruptionInterceptorList()).onDBTableVerifyFailListener(newInstance.getDBVerifyFailHandler()).tableColumnCheckInterceptors(createTableColumnCheckList()).onDBUpgradeListener(newInstance.getDBUpGradeListener()).dbUpgradeEntityList(createDBUpgradeEntityList()).afterDBUpgradeListener(newInstance.getDBUpGradeFinishListener());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return builder;
    }
}
