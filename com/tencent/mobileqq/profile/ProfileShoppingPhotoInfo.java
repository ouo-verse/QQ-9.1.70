package com.tencent.mobileqq.profile;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class ProfileShoppingPhotoInfo extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int FOLLOW_TYPE_CANCEL_CARE = 3;
    public static final int FOLLOW_TYPE_NORMAL_CARE = 1;
    public static final int FOLLOW_TYPE_NOT_CARE = 2;
    public static final String TAG = "ProfileShoppingPhotoInfo";
    private static Object mLock;
    public static LRULinkedHashMap<String, ProfileShoppingPhotoInfo> photoWinCache;
    public int accountFlag;
    public String bindShoppingNo;
    public int certifiedGrade;
    public int followType;
    public byte[] picByteData;
    public int seqNo;
    public String shopName;

    @unique
    public String uin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73789);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            photoWinCache = new LRULinkedHashMap<>(20);
            mLock = new Object();
        }
    }

    public ProfileShoppingPhotoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.certifiedGrade = 0;
        }
    }

    public static byte[] converPhoto2RawData(List<j> list) {
        ArrayList arrayList = new ArrayList();
        for (j jVar : list) {
            if (jVar != null) {
                arrayList.add(jVar.a());
            }
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeList(arrayList);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static ProfileShoppingPhotoInfo getPhotoInfo(QQAppInterface qQAppInterface, String str) {
        ProfileShoppingPhotoInfo profileShoppingPhotoInfo;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "func getPhotoInfo begins");
        }
        synchronized (mLock) {
            profileShoppingPhotoInfo = photoWinCache.get(str);
        }
        if (profileShoppingPhotoInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "func getPhotoInfo ends, in cache." + profileShoppingPhotoInfo.getPrintInfo());
            }
            return profileShoppingPhotoInfo;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        ProfileShoppingPhotoInfo profileShoppingPhotoInfo2 = (ProfileShoppingPhotoInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ProfileShoppingPhotoInfo.class, str);
        createEntityManager.close();
        synchronized (mLock) {
            if (profileShoppingPhotoInfo2 != null && str != null) {
                photoWinCache.put(str, profileShoppingPhotoInfo2);
            }
        }
        if (QLog.isColorLevel()) {
            String str2 = "";
            if (profileShoppingPhotoInfo2 != null) {
                str2 = profileShoppingPhotoInfo2.getPrintInfo();
            }
            QLog.d(TAG, 2, "func getPhotoInfo ends, read from db." + str2);
        }
        return profileShoppingPhotoInfo2;
    }

    public static List<j> parseShoppingPhotoJson(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            jSONArray = new JSONObject(str).getJSONArray(IPublicAccountConfigAttr.CONFIG_ATTR);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "parse json err:" + e16.getMessage());
            }
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (1 == jSONObject.getInt("type") && (jSONArray2 = jSONObject.getJSONArray(DownloadInfo.spKey_Config)) != null && jSONArray2.length() > 0) {
                    int length2 = jSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        j jVar = new j();
                        jVar.f260195b = jSONArray2.getJSONObject(i16).getString("url");
                        jVar.f260194a = jSONArray2.getJSONObject(i16).getJSONArray("pic_url").getString(0);
                        arrayList.add(jVar);
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static void savePhotoInfo2DB(ProfileShoppingPhotoInfo profileShoppingPhotoInfo, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "func savePhotoInfo2DB begins, photoInfo:" + profileShoppingPhotoInfo);
        }
        if (profileShoppingPhotoInfo == null) {
            return;
        }
        synchronized (mLock) {
            if (profileShoppingPhotoInfo != null) {
                String str = profileShoppingPhotoInfo.uin;
                if (str != null) {
                    photoWinCache.put(str, profileShoppingPhotoInfo);
                }
            }
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        if (profileShoppingPhotoInfo.getStatus() == 1000) {
            createEntityManager.persist(profileShoppingPhotoInfo);
        } else {
            createEntityManager.update(profileShoppingPhotoInfo);
        }
        createEntityManager.close();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "func savePhotoInfo2DB ends." + profileShoppingPhotoInfo.getPrintInfo());
        }
    }

    public List<j> getPhotoFromRawData() {
        ArrayList<String> readArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        if (this.picByteData == null) {
            return arrayList;
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                byte[] bArr = this.picByteData;
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                readArrayList = obtain.readArrayList(getClass().getClassLoader());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "func getPhotoFromRawData err:" + e16.getMessage());
                }
            }
            if (readArrayList != null && readArrayList.size() != 0) {
                for (String str : readArrayList) {
                    j jVar = new j();
                    jVar.b(str);
                    arrayList.add(jVar);
                }
                return arrayList;
            }
            return arrayList;
        } finally {
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    public String getPrintInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "/n Info->[uin]:" + this.uin + ",[seqNo]:" + this.seqNo + ",[followType]:" + this.followType + ",[accountFlag]:" + this.accountFlag + ",[shopName]:" + this.shopName + ",[bindShoppingNo]:" + this.bindShoppingNo;
    }
}
