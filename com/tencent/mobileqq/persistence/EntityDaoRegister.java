package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.ShieldListInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class EntityDaoRegister {
    public static final String TAG = "EntityDaoRegister";
    private static HashMap<Class, OGAbstractDao> mDaoMap = new HashMap<>(8);
    private static HashMap<Class, Class> mDaoClassMap = new HashMap<>(8);

    static {
        System.nanoTime();
        mDaoClassMap.put(ResourcePluginInfo.class, o.class);
        mDaoClassMap.put(HotChatInfo.class, c.class);
        mDaoClassMap.put(NearbyPeopleCard.class, i.class);
        mDaoClassMap.put(ExpiredPushBanner.class, b.class);
        mDaoClassMap.put(ShieldListInfo.class, p.class);
        mDaoClassMap.put(QZoneCover.class, n.class);
        mDaoClassMap.put(QQOperationViopTipTask.class, m.class);
        mDaoClassMap.put(PublicAccountInfo.class, k.class);
    }

    public static OGAbstractDao getEntityDao(Class cls) {
        OGAbstractDao oGAbstractDao = mDaoMap.get(cls);
        if (oGAbstractDao != null) {
            return oGAbstractDao;
        }
        Class cls2 = mDaoClassMap.get(cls);
        if (cls2 != null) {
            synchronized (mDaoMap) {
                oGAbstractDao = mDaoMap.get(cls);
                if (oGAbstractDao == null) {
                    try {
                        OGAbstractDao oGAbstractDao2 = (OGAbstractDao) cls2.newInstance();
                        try {
                            mDaoMap.put(cls, oGAbstractDao2);
                            return oGAbstractDao2;
                        } catch (IllegalAccessException e16) {
                            e = e16;
                            oGAbstractDao = oGAbstractDao2;
                            e.printStackTrace();
                            return oGAbstractDao;
                        } catch (InstantiationException e17) {
                            e = e17;
                            oGAbstractDao = oGAbstractDao2;
                            e.printStackTrace();
                            return oGAbstractDao;
                        }
                    } catch (IllegalAccessException e18) {
                        e = e18;
                    } catch (InstantiationException e19) {
                        e = e19;
                    }
                }
            }
        }
        return oGAbstractDao;
    }
}
