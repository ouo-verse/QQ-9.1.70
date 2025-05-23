package com.tencent.qqlive.module.videoreport.sample;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.sample.SampleInfo;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleInfoManager {
    private static final String KEY_SAMPLE_DEVICE_ID = "key_sample_device_id";
    private static final String KEY_SAMPLE_RANDOM = "key_sample_random";
    private static final String SYSTEM_FLAG = "0";
    private static final int TOTAL_RANGE = 10000;
    private final Map<String, Map<String, SampleInfo>> eidToEventKeyToSampleInfoMap;
    private final Map<String, SampleInfo> elementSampleInfoMap;
    private final Map<String, SampleInfo> pageSampleInfoMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final SampleInfoManager INSTANCE = new SampleInfoManager();

        InstanceHolder() {
        }
    }

    private SampleInfo createElementSampleInfo(String str) {
        SampleInfo elementSampleInfoById = getElementSampleInfoById(str);
        if (elementSampleInfoById != null) {
            return elementSampleInfoById;
        }
        SampleInfo sampleInfo = new SampleInfo(2, str);
        this.elementSampleInfoMap.put(str, sampleInfo);
        return sampleInfo;
    }

    private SampleInfo createPageSampleInfo(String str) {
        SampleInfo pageSampleInfoById = getPageSampleInfoById(str);
        if (pageSampleInfoById == null) {
            SampleInfo sampleInfo = new SampleInfo(1, str);
            this.pageSampleInfoMap.put(str, sampleInfo);
            return sampleInfo;
        }
        return pageSampleInfoById;
    }

    private SampleInfo createSampleInfoById(@SampleInfo.NodeType int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            return createElementSampleInfo(str);
        }
        return createPageSampleInfo(str);
    }

    private int genRandomNumber() {
        SecureRandom secureRandom;
        Context context = ReportUtils.getContext();
        if (context == null) {
            return 0;
        }
        String str = (String) SPUtils.get(context, KEY_SAMPLE_RANDOM, "");
        if (TextUtils.isEmpty(str)) {
            String str2 = (String) SPUtils.get(context, KEY_SAMPLE_DEVICE_ID, "");
            if (TextUtils.isEmpty(str2)) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException unused) {
                    secureRandom = new SecureRandom();
                }
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                str2 = SampleUtils.bytesToHex(bArr) + String.valueOf(System.currentTimeMillis()) + "0";
                SPUtils.put(context, KEY_SAMPLE_DEVICE_ID, str2);
            }
            str = String.valueOf(SampleUtils.getBKDRHashCode(str2) % 10000);
            SPUtils.put(context, KEY_SAMPLE_RANDOM, str);
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused2) {
            return 0;
        }
    }

    @Nullable
    private Map<String, SampleInfo> getEventKey2SampleInfo(Object obj) {
        if (obj == null) {
            return null;
        }
        String elementId = DataRWProxy.getElementId(obj);
        if (TextUtils.isEmpty(elementId)) {
            return null;
        }
        return this.eidToEventKeyToSampleInfoMap.get(elementId);
    }

    public static SampleInfoManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private boolean isElementSampleHit(Object obj, String str) {
        return isSampleHit(getElementSampleInfoByObject(obj, str));
    }

    private boolean isElementSeparatelyRate() {
        if (SampleMutex.curEidSampleMode() == 2) {
            return true;
        }
        return false;
    }

    private boolean isPageSampleHit(Object obj) {
        return isSampleHit(getPageSampleInfoByObject(obj));
    }

    private void startElementSample(Object obj) {
        if (isElementSeparatelyRate()) {
            Map<String, SampleInfo> eventKey2SampleInfo = getEventKey2SampleInfo(obj);
            if (eventKey2SampleInfo != null && !eventKey2SampleInfo.isEmpty()) {
                Iterator<SampleInfo> it = eventKey2SampleInfo.values().iterator();
                while (it.hasNext()) {
                    startSample(it.next());
                }
                return;
            }
            return;
        }
        SampleInfo elementSampleInfoByObject = getElementSampleInfoByObject(obj, null);
        if (elementSampleInfoByObject != null) {
            startSample(elementSampleInfoByObject);
        }
    }

    private void unLockElementSampleInfo(Object obj) {
        if (isElementSeparatelyRate()) {
            Map<String, SampleInfo> eventKey2SampleInfo = getEventKey2SampleInfo(obj);
            if (eventKey2SampleInfo != null && !eventKey2SampleInfo.isEmpty()) {
                for (SampleInfo sampleInfo : eventKey2SampleInfo.values()) {
                    if (sampleInfo != null) {
                        sampleInfo.setIsLocked(false);
                    }
                }
                return;
            }
            return;
        }
        SampleInfo elementSampleInfoByObject = getElementSampleInfoByObject(obj, null);
        if (elementSampleInfoByObject != null) {
            elementSampleInfoByObject.setIsLocked(false);
        }
    }

    private void unLockPageSampleInfo(Object obj) {
        SampleInfo pageSampleInfoByObject = getPageSampleInfoByObject(obj);
        if (pageSampleInfoByObject != null) {
            pageSampleInfoByObject.setIsLocked(false);
        }
    }

    public synchronized void clearElementsSampleRate() {
        this.elementSampleInfoMap.clear();
    }

    public synchronized void clearPagesSampleRate() {
        this.pageSampleInfoMap.clear();
    }

    public SampleInfo getElementSampleInfo(String str, String str2) {
        Map<String, SampleInfo> map;
        if (isElementSeparatelyRate()) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (map = this.eidToEventKeyToSampleInfoMap.get(str)) == null) {
                return null;
            }
            return map.get(str2);
        }
        return getElementSampleInfoById(str);
    }

    public SampleInfo getElementSampleInfoById(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.elementSampleInfoMap.get(str);
    }

    public SampleInfo getElementSampleInfoByObject(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return getElementSampleInfo(DataRWProxy.getElementId(obj), str);
    }

    public SampleInfo getPageSampleInfoById(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.pageSampleInfoMap.get(str);
    }

    public SampleInfo getPageSampleInfoByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        return getPageSampleInfoById(DataRWProxy.getPageId(obj));
    }

    public boolean isSampleHit(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return true;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 104396:
                if (str.equals("imp")) {
                    c16 = 0;
                    break;
                }
                break;
            case 3056273:
                if (str.equals("clck")) {
                    c16 = 1;
                    break;
                }
                break;
            case 3438940:
                if (str.equals("pgin")) {
                    c16 = 2;
                    break;
                }
                break;
            case 106613239:
                if (str.equals("pgout")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1925548520:
                if (str.equals("imp_end")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
            case 4:
                return isElementSampleHit(obj, str);
            case 2:
            case 3:
                return isPageSampleHit(obj);
            default:
                return true;
        }
    }

    public synchronized void setElementSampleRate(String str, Map<String, Float> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                for (Map.Entry<String, Float> entry : map.entrySet()) {
                    SampleInfo createElementSampleInfo = createElementSampleInfo(str, entry.getKey());
                    if (createElementSampleInfo != null) {
                        createElementSampleInfo.setSampleRate(entry.getValue().floatValue());
                    }
                }
            }
        }
    }

    public synchronized void setSampleRate(@SampleInfo.NodeType int i3, String str, float f16) {
        SampleInfo createSampleInfoById = createSampleInfoById(i3, str);
        if (createSampleInfoById != null) {
            createSampleInfoById.setSampleRate(f16);
        }
    }

    public void startSample(@SampleInfo.NodeType int i3, Object obj) {
        if (obj == null) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            startElementSample(obj);
        } else {
            SampleInfo pageSampleInfoByObject = getPageSampleInfoByObject(obj);
            if (pageSampleInfoByObject != null) {
                startSample(pageSampleInfoByObject);
            }
        }
    }

    public void unLockSampleInfo(@SampleInfo.NodeType int i3, Object obj) {
        if (obj == null) {
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                unLockElementSampleInfo(obj);
                return;
            }
            return;
        }
        unLockPageSampleInfo(obj);
    }

    SampleInfoManager() {
        this.elementSampleInfoMap = new ConcurrentHashMap();
        this.pageSampleInfoMap = new ConcurrentHashMap();
        this.eidToEventKeyToSampleInfoMap = new ConcurrentHashMap();
    }

    private SampleInfo createElementSampleInfo(String str, String str2) {
        if (isElementSeparatelyRate()) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            SampleInfo elementSampleInfo = getElementSampleInfo(str, str2);
            if (elementSampleInfo == null) {
                elementSampleInfo = new SampleInfo(2, str);
                Map<String, SampleInfo> map = this.eidToEventKeyToSampleInfoMap.get(str);
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put(str2, elementSampleInfo);
                this.eidToEventKeyToSampleInfoMap.put(str, map);
            }
            return elementSampleInfo;
        }
        return createElementSampleInfo(str);
    }

    private void startSample(SampleInfo sampleInfo) {
        if (sampleInfo == null) {
            return;
        }
        sampleInfo.setIsHit(genRandomNumber() <= ((int) (sampleInfo.getSampleRate() * 100.0f)));
        sampleInfo.setIsLocked(true);
    }

    private boolean isSampleHit(SampleInfo sampleInfo) {
        if (sampleInfo == null) {
            return true;
        }
        return sampleInfo.isHit();
    }
}
