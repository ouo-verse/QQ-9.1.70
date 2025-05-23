package com.tencent.mobileqq.vas.pendant.drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantShopSeriesInfo;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class AvatarPendantManagerImpl implements IAvatarPendantManager {

    /* renamed from: m, reason: collision with root package name */
    private static volatile AvatarPendantManagerImpl f310447m;

    /* renamed from: i, reason: collision with root package name */
    private List<? extends AvatarInPendantHeadportraitInfo> f310452i;

    /* renamed from: e, reason: collision with root package name */
    private long f310449e = -1;

    /* renamed from: h, reason: collision with root package name */
    private final List<AvatarPendantShopSeriesInfo> f310451h = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final PendantInfoLruCache f310450f = new PendantInfoLruCache(10);

    /* renamed from: d, reason: collision with root package name */
    private boolean f310448d = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class PendantInfoLruCache extends LruLinkedHashMap<Long, IPendantInfo> {
        private static final long serialVersionUID = 1;

        public PendantInfoLruCache(int i3) {
            super(i3);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterator<IPendantInfo> it = values().iterator();
            while (it.hasNext()) {
                it.next().setPause(true);
            }
            super.clear();
        }

        @Override // com.tencent.mobileqq.vas.pendant.drawable.LruLinkedHashMap, java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Long, IPendantInfo> entry) {
            if (size() > this.maxCapacity) {
                if (QLog.isColorLevel()) {
                    QLog.d("AvatarPendantManager", 2, "entryRemoved key=" + entry.getKey());
                }
                entry.getValue().setPause(true);
                return true;
            }
            return false;
        }
    }

    AvatarPendantManagerImpl() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    private String a(String str) {
        int read;
        StringBuilder sb5 = new StringBuilder();
        ?? r46 = 0;
        r46 = 0;
        r46 = 0;
        try {
        } catch (Exception e16) {
            QLog.e("AvatarPendantManager", 1, "getConfigContent error: ", e16);
        }
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    char[] cArr = new char[2048];
                    while (true) {
                        read = bufferedReader.read(cArr);
                        if (read <= 0) {
                            break;
                        }
                        sb5.append(cArr, 0, read);
                    }
                    bufferedReader.close();
                    r46 = read;
                } catch (Exception e17) {
                    e = e17;
                    r46 = bufferedReader;
                    QLog.e("AvatarPendantManager", 1, "getConfigContent error: ", e);
                    if (r46 != 0) {
                        r46.close();
                        r46 = r46;
                    }
                    return sb5.toString();
                } catch (Throwable th5) {
                    th = th5;
                    r46 = bufferedReader;
                    if (r46 != 0) {
                        try {
                            r46.close();
                        } catch (Exception e18) {
                            QLog.e("AvatarPendantManager", 1, "getConfigContent error: ", e18);
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            }
            return sb5.toString();
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Nullable
    private IPendantInfo b() {
        return null;
    }

    public static AvatarPendantManagerImpl c() {
        if (f310447m == null) {
            synchronized (AvatarPendantManagerImpl.class) {
                if (f310447m == null) {
                    f310447m = new AvatarPendantManagerImpl();
                }
            }
        }
        return f310447m;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void clear() {
        synchronized (this.f310450f) {
            Iterator<IPendantInfo> it = this.f310450f.values().iterator();
            while (it.hasNext()) {
                it.next().clearCache();
            }
            this.f310450f.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deletePendants(HashMap<String, Integer> hashMap, ArrayList<String> arrayList) {
        FileWriter fileWriter;
        Throwable th5;
        IOException e16;
        if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantManager", 2, "deletePendants, map=" + hashMap + ", excludeList=" + arrayList);
        }
        JSONArray pendantLocalVersionInfo = getPendantLocalVersionInfo();
        boolean z16 = false;
        for (int i3 = 0; i3 < pendantLocalVersionInfo.length(); i3++) {
            try {
                JSONObject jSONObject = pendantLocalVersionInfo.getJSONObject(i3);
                String string = jSONObject.getString("id");
                if (hashMap.containsKey(string)) {
                    if (arrayList != null && arrayList.contains(string)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AvatarPendantManager", 2, "deletePendants, resource not deleted, pendantId=" + string);
                        }
                        jSONObject.remove("version");
                        jSONObject.put("version", hashMap.get(string));
                        z16 = true;
                    }
                    FileUtils.deleteDirectory(VasConstant.PENDANT_DOWN_LOAD_DIR + string);
                    jSONObject.remove("version");
                    jSONObject.put("version", hashMap.get(string));
                    z16 = true;
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        if (z16) {
            try {
                fileWriter = new FileWriter(new File(BaseApplication.getContext().getFilesDir() + "/pendant_info", "pendant_local.cfg"), false);
            } catch (IOException e18) {
                fileWriter = null;
                e16 = e18;
            } catch (Throwable th6) {
                fileWriter = null;
                th5 = th6;
                if (fileWriter != null) {
                }
                throw th5;
            }
            try {
                try {
                    fileWriter.write(pendantLocalVersionInfo.toString());
                    fileWriter.flush();
                    try {
                        fileWriter.close();
                    } catch (IOException e19) {
                        e = e19;
                        if (!QLog.isColorLevel()) {
                            return;
                        }
                        QLog.i("AvatarPendantManager", 2, "deletePendants exception", e);
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e26) {
                            if (QLog.isColorLevel()) {
                                QLog.i("AvatarPendantManager", 2, "deletePendants exception", e26);
                            }
                        }
                    }
                    throw th5;
                }
            } catch (IOException e27) {
                e16 = e27;
                e16.printStackTrace();
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e28) {
                        e = e28;
                        if (!QLog.isColorLevel()) {
                            return;
                        }
                        QLog.i("AvatarPendantManager", 2, "deletePendants exception", e);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    public File getAvatarPendantBaseResouceDir() {
        File file = new File(VasConstant.PENDANT_DOWN_LOAD_DIR);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (QLog.isColorLevel()) {
                QLog.i("AvatarPendantManager", 2, "getAvatarPendantBaseResouceDir dir:" + file.getAbsolutePath() + " create result:" + mkdirs);
            }
        }
        return file;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    public List<AvatarInPendantHeadportraitInfo> getFaceCache() {
        return this.f310452i;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    public IPendantInfo getPendantInfo(long j3) {
        return getPendantInfo(j3, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray getPendantLocalVersionInfo() {
        JSONArray jSONArray;
        File file = new File(getPendentBaseDir(), "pendant_local.cfg");
        if (file.exists()) {
            try {
                jSONArray = new JSONArray(a(file.getAbsolutePath()));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (jSONArray != null) {
                return new JSONArray();
            }
            return jSONArray;
        }
        jSONArray = null;
        if (jSONArray != null) {
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    public List<AvatarPendantShopSeriesInfo> getPendantShopSeriesCache() {
        return this.f310451h;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public File getPendentBaseDir() {
        File file = new File(BaseApplication.getContext().getFilesDir(), "pendant_info");
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (QLog.isColorLevel()) {
                QLog.i("AvatarPendantManager", 2, "getPendentBaseDir dir:" + file.getAbsolutePath() + " create result:" + mkdirs);
            }
        }
        return file;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public boolean isShowPendant(long j3) {
        if (this.f310449e != j3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void onDestroy() {
        synchronized (this.f310450f) {
            this.f310450f.clear();
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setFaceCache(@NonNull List<? extends AvatarInPendantHeadportraitInfo> list) {
        this.f310452i = list;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setPlayAnimatinDelay() {
        this.f310448d = false;
        synchronized (this.f310450f) {
            Iterator<IPendantInfo> it = this.f310450f.values().iterator();
            while (it.hasNext()) {
                it.next().setPause(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setPlayAnimatinImmediately() {
        this.f310448d = true;
        synchronized (this.f310450f) {
            Iterator<IPendantInfo> it = this.f310450f.values().iterator();
            while (it.hasNext()) {
                it.next().setPause(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setUnShowMsgId(long j3) {
        this.f310449e = j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00da, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00dc, code lost:
    
        com.tencent.qphone.base.util.QLog.i("AvatarPendantManager", 2, "updateAllPendantLocalVersionInfo4 exception", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00fe, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray updateAllPendantLocalVersionInfo() {
        ?? hasNext;
        FileWriter fileWriter;
        IOException e16;
        JSONArray pendantLocalVersionInfo = getPendantLocalVersionInfo();
        File[] listFiles = new File(VasConstant.PENDANT_DOWN_LOAD_DIR).listFiles();
        HashSet hashSet = new HashSet();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    hashSet.add(file.getName());
                }
            }
        }
        HashSet hashSet2 = new HashSet();
        for (int i3 = 0; i3 < pendantLocalVersionInfo.length(); i3++) {
            try {
                hashSet2.add(pendantLocalVersionInfo.getJSONObject(i3).getString("id"));
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("AvatarPendantManager", 2, "updateAllPendantLocalVersionInfo1 exception", e17);
                }
            }
        }
        hashSet.removeAll(hashSet2);
        Iterator it = hashSet.iterator();
        boolean z16 = false;
        while (true) {
            hasNext = it.hasNext();
            if (hasNext == 0) {
                break;
            }
            String str = (String) it.next();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("version", 0);
                pendantLocalVersionInfo.mo162put(jSONObject);
            } catch (JSONException e18) {
                if (QLog.isColorLevel()) {
                    QLog.i("AvatarPendantManager", 2, "updateAllPendantLocalVersionInfo2 exception", e18);
                }
            }
            z16 = true;
        }
        if (z16) {
            Writer writer = null;
            try {
                try {
                    fileWriter = new FileWriter(new File(BaseApplication.getContext().getFilesDir() + "/pendant_info", "pendant_local.cfg"), false);
                } catch (IOException e19) {
                    fileWriter = null;
                    e16 = e19;
                } catch (Throwable th5) {
                    th = th5;
                    if (writer != null) {
                    }
                    throw th;
                }
                try {
                    fileWriter.write(pendantLocalVersionInfo.toString());
                    fileWriter.flush();
                    try {
                        fileWriter.close();
                    } catch (IOException e26) {
                        e = e26;
                    }
                } catch (IOException e27) {
                    e16 = e27;
                    if (QLog.isColorLevel()) {
                        QLog.i("AvatarPendantManager", 2, "updateAllPendantLocalVersionInfo3 exception", e16);
                    }
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e28) {
                            e = e28;
                        }
                    }
                    return pendantLocalVersionInfo;
                }
            } catch (Throwable th6) {
                th = th6;
                writer = hasNext;
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e29) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AvatarPendantManager", 2, "updateAllPendantLocalVersionInfo4 exception", e29);
                        }
                    }
                }
                throw th;
            }
        }
        return pendantLocalVersionInfo;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    public IPendantInfo getPendantInfo(long j3, boolean z16) {
        IPendantInfo iPendantInfo;
        IPendantInfo b16 = b();
        if (b16 != null) {
            return b16;
        }
        synchronized (this.f310450f) {
            iPendantInfo = this.f310450f.get(Long.valueOf(j3));
            if (iPendantInfo != null) {
                if (QLog.isDebugVersion()) {
                    QLog.d("AvatarPendantManager", 4, "getPendantInfo pendantId=" + j3 + " from cache");
                }
            } else {
                iPendantInfo = new l(j3);
                this.f310450f.put(Long.valueOf(j3), iPendantInfo);
            }
            if (z16) {
                iPendantInfo.setPause(this.f310448d);
            }
        }
        return iPendantInfo;
    }
}
