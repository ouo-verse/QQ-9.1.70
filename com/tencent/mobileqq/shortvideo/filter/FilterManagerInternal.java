package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.sveffects.SLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public final class FilterManagerInternal {
    public static final String TAG = "FilterManagerInternal";
    private QQFilterRenderManager mCommonParam;
    private QQFaceDetectBase mFaceDetect;
    private volatile boolean mReleased;
    private volatile boolean isCaptureMode = false;
    private final FilterCacheQueue mCacheQueue = new FilterCacheQueue();
    private Stack<FilterChain> mChains = new Stack<>();
    private boolean needFaceDetect = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class FilterChain {
        String info;
        int[] mFilters;
        String mId;
        Object[] mParams;
        FilterChain oldTopChain = null;
        ArrayList<QQBaseFilter> mHighCache = new ArrayList<>();
        boolean mCreateResume = true;

        FilterChain(int[] iArr, Object[] objArr) {
            this.mFilters = iArr;
            this.mParams = objArr;
            generateID();
            this.info = FilterCreateFactory.getLogInfo(this.mFilters);
        }

        void generateID() {
            StringBuilder sb5 = new StringBuilder();
            int[] iArr = this.mFilters;
            if (iArr != null) {
                for (int i3 : iArr) {
                    sb5.append(i3);
                    sb5.append("_");
                }
            }
            this.mId = sb5.toString();
        }

        void getFilterParams(ArrayList<Object> arrayList) {
            Object[] objArr = this.mParams;
            if (objArr != null) {
                arrayList.addAll(Arrays.asList(objArr));
            }
        }

        void getFilterTypes(ArrayList<Integer> arrayList) {
            int[] iArr = this.mFilters;
            if (iArr != null) {
                for (int i3 : iArr) {
                    arrayList.add(Integer.valueOf(i3));
                }
            }
        }

        String getId() {
            return this.mId;
        }

        Object getParam(int i3) {
            Object[] objArr = this.mParams;
            if (objArr != null && i3 >= 0 && i3 < objArr.length) {
                return objArr[i3];
            }
            return null;
        }

        boolean hasFilterType(int i3) {
            int[] iArr = this.mFilters;
            if (iArr != null) {
                for (int i16 : iArr) {
                    if (i16 == i3) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilterManagerInternal() {
        this.mReleased = false;
        this.mReleased = false;
    }

    private synchronized void checkStackIsLeakage() {
        if (this.mChains.size() >= 10) {
            HashMap hashMap = new HashMap();
            Iterator<FilterChain> it = this.mChains.iterator();
            while (it.hasNext()) {
                FilterChain next = it.next();
                if (hashMap.containsKey(next.getId())) {
                    hashMap.put(next.getId(), Integer.valueOf(((Integer) hashMap.get(next.getId())).intValue() + 1));
                } else {
                    hashMap.put(next.getId(), 1);
                }
            }
            int i3 = 0;
            for (String str : hashMap.keySet()) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                if (intValue >= 2) {
                    i3++;
                    printLog("checkStackIsLeakage", " key=" + str + " value=" + intValue, null);
                }
            }
            printLog("checkStackIsLeakage", " count=" + i3 + " traceInfo=" + generateStackTrace(), null);
        }
    }

    private void checkThreadSecurity(String str) {
        if (isExeInGlThread()) {
            return;
        }
        throw new RuntimeException("\u5728\u975e\u6e32\u67d3\u7ebf\u7a0b\u6267\u884c: [" + str + "] threadName=" + Thread.currentThread().getName());
    }

    private void decQuote(FilterChain filterChain) {
        if (filterChain.mFilters != null) {
            Iterator<QQBaseFilter> it = filterChain.mHighCache.iterator();
            while (it.hasNext()) {
                it.next().mQuoteCount.decrementAndGet();
            }
        }
        filterChain.mHighCache.clear();
    }

    private void initHighCache(FilterChain filterChain) {
        if (filterChain.mFilters != null) {
            int i3 = 0;
            while (true) {
                int[] iArr = filterChain.mFilters;
                if (i3 < iArr.length) {
                    filterChain.mHighCache.add(this.mCacheQueue.getFilterByType(iArr[i3]));
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void insertFollowSerial(int i3, Object obj, ArrayList<Integer> arrayList, ArrayList<Object> arrayList2) {
        int size = arrayList.size();
        int i16 = 0;
        int i17 = 0;
        while (i16 < size && i3 >= arrayList.get(i16).intValue()) {
            i17 = i16 + 1;
            i16 = i17;
        }
        arrayList.add(i17, Integer.valueOf(i3));
        if (i17 > arrayList2.size()) {
            int size2 = i17 - arrayList2.size();
            for (int i18 = 0; i18 < size2; i18++) {
                arrayList2.add(null);
            }
        }
        arrayList2.add(i17, obj);
    }

    @TargetApi(17)
    private boolean isExeInGlThread() {
        if (EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT) {
            return true;
        }
        return false;
    }

    private boolean isOldChainFollowSerial(ArrayList<Integer> arrayList) {
        int intValue = arrayList.get(0).intValue();
        int i3 = 1;
        while (i3 < arrayList.size()) {
            int intValue2 = arrayList.get(i3).intValue();
            if (intValue > intValue2) {
                return false;
            }
            i3++;
            intValue = intValue2;
        }
        return true;
    }

    private void newAddQuote(FilterChain filterChain) {
        if (filterChain.mFilters != null) {
            int i3 = 0;
            while (true) {
                int[] iArr = filterChain.mFilters;
                if (i3 < iArr.length) {
                    QQBaseFilter filterByTypeWithCreate = this.mCacheQueue.getFilterByTypeWithCreate(iArr[i3], this.mCommonParam);
                    filterByTypeWithCreate.mQuoteCount.getAndIncrement();
                    filterByTypeWithCreate.setSpecificParam(filterChain.getParam(i3));
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private synchronized void popAndReleaseInternal(String str, boolean z16) {
        checkThreadSecurity("popAndReleaseInternal");
        try {
            FilterChain peek = this.mChains.peek();
            if (peek == null) {
                this.mChains.pop();
                printLog("popAndReleaseInternal", "currentChain=null", null);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (peek.mId.equalsIgnoreCase(str)) {
                    this.mChains.pop();
                    printLog("popAndReleaseInternal", "pop " + peek.info, null);
                    runChainPauseInternal(peek);
                    decQuote(peek);
                    recoveryTopChainParams();
                    printLog("popAndReleaseInternal", "needRelease " + z16, null);
                    if (z16) {
                        releaseChainResource(peek);
                    }
                    return;
                }
                throw new RuntimeException("popAndRelease Id=" + str + " currentChain.mId=" + peek.mId);
            }
            throw new RuntimeException("popAndRelease Id=" + str + " needRelease=" + z16 + " realID=" + peek.mId);
        } catch (EmptyStackException e16) {
            printLog("popAndReleaseInternal", "EmptyStackException", e16);
        }
    }

    private static void printLog(String str, String str2, Throwable th5) {
        if (th5 != null) {
            if (SLog.isEnable()) {
                SLog.e(TAG, str + MsgSummary.STR_COLON + str2, th5);
                return;
            }
            return;
        }
        if (SLog.isEnable()) {
            SLog.i(TAG, str + MsgSummary.STR_COLON + str2);
        }
    }

    private synchronized void printStackReleaseInfo() {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek != null) {
                printLog("printReleaseInfo", "top " + peek.info, null);
            }
            if (this.mChains.size() > 0) {
                Iterator<FilterChain> it = this.mChains.iterator();
                while (it.hasNext()) {
                    FilterChain next = it.next();
                    if (next != null) {
                        printLog("printReleaseInfo", "For " + next.info, null);
                    }
                }
            } else {
                printLog("printReleaseInfo", " mChains.size()=0", null);
            }
        } catch (EmptyStackException unused) {
            printLog("printReleaseInfo", " EmptyStackException", null);
        }
    }

    private synchronized String pushChainInternal(int[] iArr, Object[] objArr) {
        FilterChain filterChain;
        FilterChain filterChain2;
        try {
            filterChain = this.mChains.peek();
        } catch (EmptyStackException e16) {
            e16.printStackTrace();
            printLog("pushChainInternal", " EmptyStackException[First push] size=" + this.mChains.size(), null);
            filterChain = null;
        }
        filterChain2 = new FilterChain(iArr, objArr);
        filterChain2.oldTopChain = filterChain;
        newAddQuote(filterChain2);
        this.mChains.push(filterChain2);
        printLog("pushChainInternal", filterChain2.info, null);
        checkStackIsLeakage();
        return filterChain2.getId();
    }

    private void pushChainRunSecurity(FilterChain filterChain, FilterChain filterChain2) {
        initHighCache(filterChain);
        if (filterChain2 != null) {
            runChainPauseInternal(filterChain2);
        }
    }

    private void recoveryTopChainParams() {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek == null) {
                this.mChains.pop();
                printLog("recoveryTopChainParams", "peek currentChain=null", null);
                return;
            }
            printLog("recoveryTopChainParams", "peek " + peek.info, null);
            if (peek.mFilters != null) {
                for (int i3 = 0; i3 < peek.mFilters.length; i3++) {
                    peek.mHighCache.get(i3).setSpecificParam(peek.getParam(i3));
                }
            }
            runChainResumeInternal(peek);
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "recoveryTopChainParams: peek=null", e16);
            }
        }
    }

    private void releaseChainResource(FilterChain filterChain) {
        printLog("releaseChainResource", filterChain.info, null);
        int[] iArr = filterChain.mFilters;
        if (iArr != null) {
            for (int i3 : iArr) {
                QQBaseFilter filterByType = this.mCacheQueue.getFilterByType(i3);
                if (filterByType.mQuoteCount.get() == 0) {
                    printLog("releaseChainResource", " [cnt=0] name=" + filterByType.getClass().getName(), null);
                    filterByType.onSurfaceDestroy();
                    filterByType.mStatus = 0;
                    this.mCacheQueue.removeFilter(i3);
                }
            }
        }
    }

    private void runChainPauseInternal(FilterChain filterChain) {
        if (filterChain != null && filterChain.mFilters != null) {
            Iterator<QQBaseFilter> it = filterChain.mHighCache.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
            printLog("runChainPauseInternal ", filterChain.info, null);
        }
    }

    private void runChainResumeInternal(FilterChain filterChain) {
        if (filterChain != null && filterChain.mFilters != null) {
            Iterator<QQBaseFilter> it = filterChain.mHighCache.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
            printLog("runChainResumeInternal ", filterChain.info, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeCamera(int i3) {
        if (!this.mReleased) {
            Iterator<QQBaseFilter> it = this.mCacheQueue.getFilterList().iterator();
            while (it.hasNext()) {
                it.next().onChangeCamera(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQBaseFilter currentChainGetFilter(int i3) {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek != null && peek.hasFilterType(i3)) {
                return this.mCacheQueue.getFilterByType(i3);
            }
        } catch (EmptyStackException unused) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "currentChainGetFilter: EmptyStackException ", null);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean currentChinaHasFilter(int i3) {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek != null) {
                return peek.hasFilterType(i3);
            }
            return false;
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "currentChinaHasFilter: EmptyStackException ", e16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized String generateStackTrace() {
        StringBuilder sb5;
        sb5 = new StringBuilder();
        try {
            FilterChain peek = this.mChains.peek();
            sb5.append("current: ");
            if (peek != null) {
                sb5.append(peek.info);
            } else {
                sb5.append("null");
            }
            sb5.append("\n");
            sb5.append("stacktrace: ");
            int size = this.mChains.size();
            sb5.append(size);
            if (size > 0) {
                for (int size2 = this.mChains.size() - 1; size2 >= 0; size2--) {
                    FilterChain filterChain = this.mChains.get(size2);
                    sb5.append("\n");
                    sb5.append(filterChain.info);
                }
            }
        } catch (EmptyStackException unused) {
            sb5.append("stack empty!");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAllActiveFilter(List<QQBaseFilter> list) {
        for (QQBaseFilter qQBaseFilter : this.mCacheQueue.getFilterList()) {
            if (qQBaseFilter.isFilterWork()) {
                list.add(qQBaseFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCacheFilterInfo() {
        StringBuilder sb5 = new StringBuilder();
        Collection<QQBaseFilter> filterList = this.mCacheQueue.getFilterList();
        int size = filterList.size();
        sb5.append(size);
        sb5.append(ProgressTracer.SEPARATOR);
        if (size > 0) {
            Iterator<QQBaseFilter> it = filterList.iterator();
            while (it.hasNext()) {
                sb5.append(FilterCreateFactory.getFilterTag(it.next().mFilterType));
                sb5.append(QbAddrData.DATA_SPLITER);
            }
            return sb5.substring(0, sb5.length() - 1);
        }
        return "empty!";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getCurrentChainData(ArrayList<Integer> arrayList, ArrayList<Object> arrayList2) {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek != null) {
                peek.getFilterTypes(arrayList);
                peek.getFilterParams(arrayList2);
                return true;
            }
            return false;
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "getCurrentChainData: EmptyStackException ", e16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getCurrentChainId() {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek != null) {
                return peek.getId();
            }
            return null;
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "getCurrentChainId: EmptyStackException ", e16);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getFilterSpecificParam(int i3) {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek != null && peek.hasFilterType(i3)) {
                return this.mCacheQueue.getFilterByType(i3).getSpecificParam();
            }
            return null;
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "getFilterSpecificParam: EmptyStackException ", e16);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean hasAllResourceActiveFilter() {
        Iterator<QQBaseFilter> it = this.mCacheQueue.getFilterList().iterator();
        while (it.hasNext()) {
            if (it.next().isFilterWork()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String insertNewFilterToOldChain_pushChain(int i3, Object obj) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Object> arrayList2 = new ArrayList<>();
        if (getCurrentChainData(arrayList, arrayList2) && arrayList.size() > 0) {
            if (isOldChainFollowSerial(arrayList)) {
                insertFollowSerial(i3, obj, arrayList, arrayList2);
            } else {
                int size = arrayList.size() - arrayList2.size();
                for (int i16 = 0; i16 < size; i16++) {
                    arrayList2.add(null);
                }
                arrayList.add(Integer.valueOf(i3));
                arrayList2.add(obj);
            }
        } else {
            arrayList.add(Integer.valueOf(i3));
            arrayList2.add(obj);
        }
        return push(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFilterWork(int i3) {
        try {
            FilterChain peek = this.mChains.peek();
            if (peek != null && peek.hasFilterType(i3)) {
                return this.mCacheQueue.getFilterByType(i3).isFilterWork();
            }
            return false;
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "isFilterWork: EmptyStackException ", e16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needFaceDetect() {
        return this.needFaceDetect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onCurrentChainPause() {
        try {
            checkThreadSecurity("onCurrentChainPause");
            runChainPauseInternal(this.mChains.peek());
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "onCurrentChainPause: EmptyStackException ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void onCurrentChainResume() {
        try {
            checkThreadSecurity("onCurrentChainResume");
            runChainResumeInternal(this.mChains.peek());
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "onCurrentChainResume: EmptyStackException ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pop(String str) {
        popAndReleaseInternal(str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popAndRelease(String str) {
        popAndReleaseInternal(str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String push(ArrayList<Integer> arrayList, ArrayList<Object> arrayList2) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = arrayList.get(i3).intValue();
        }
        return push(iArr, arrayList2 != null ? arrayList2.toArray() : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseAllResource() {
        printLog("releaseAllResource", "releaseAllResource currentThreadName=" + Thread.currentThread().getName(), null);
        this.mReleased = true;
        printStackReleaseInfo();
        this.mChains.clear();
        for (QQBaseFilter qQBaseFilter : this.mCacheQueue.getFilterList()) {
            qQBaseFilter.onSurfaceDestroy();
            qQBaseFilter.mStatus = 0;
            printLog("releaseAllResource", "releaseAllResource " + qQBaseFilter.getClass().getName(), null);
        }
        this.mCacheQueue.clearAll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int runChain(int i3) {
        FilterChain filterChain;
        int i16;
        printLog("runChain", "runChain currentThreadName=" + Thread.currentThread().getName(), null);
        if (this.mReleased) {
            SLog.e(TAG, "runChain: mReleased=true");
            return i3;
        }
        try {
            filterChain = this.mChains.peek();
        } catch (EmptyStackException unused) {
            printLog(TAG, "peek == null", null);
            filterChain = null;
        }
        if (filterChain == null) {
            printLog("runChain", "peek currentChain=null", null);
            return i3;
        }
        if (filterChain.mFilters == null) {
            return i3;
        }
        if (filterChain.mCreateResume) {
            pushChainRunSecurity(filterChain, filterChain.oldTopChain);
        }
        Iterator<QQBaseFilter> it = filterChain.mHighCache.iterator();
        while (true) {
            i16 = 2;
            if (!it.hasNext()) {
                break;
            }
            QQBaseFilter next = it.next();
            int i17 = next.mStatus;
            if (i17 == 0) {
                next.onSurfaceCreate();
                next.onSurfaceChange(this.mCommonParam.getFilterWidth(), this.mCommonParam.getFilterHeight());
                next.mStatus = 2;
            } else if (i17 == 1) {
                next.onSurfaceChange(this.mCommonParam.getFilterWidth(), this.mCommonParam.getFilterHeight());
                next.mStatus = 2;
            }
        }
        if (filterChain.mCreateResume) {
            runChainResumeInternal(filterChain);
            filterChain.mCreateResume = false;
        }
        this.needFaceDetect = false;
        Iterator<QQBaseFilter> it5 = filterChain.mHighCache.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            if (it5.next().needFaceDetect()) {
                this.needFaceDetect = true;
                break;
            }
        }
        QQFilterLogManager.setLogStart("mFaceDetect");
        QQFaceDetectBase qQFaceDetectBase = this.mFaceDetect;
        if (this.needFaceDetect) {
            i16 = 1;
        }
        qQFaceDetectBase.setFaceDetectType(i16);
        this.mFaceDetect.setCaptureMode(this.isCaptureMode);
        if (this.needFaceDetect) {
            this.mFaceDetect.setInputTextureID(i3);
            this.mFaceDetect.onDrawFrame();
            i3 = this.mFaceDetect.getOutputTextureID();
        }
        QQFilterLogManager.setLogEnd("mFaceDetect: needFaceDetect=" + this.needFaceDetect);
        Iterator<QQBaseFilter> it6 = filterChain.mHighCache.iterator();
        while (it6.hasNext()) {
            QQBaseFilter next2 = it6.next();
            next2.setCaptureMode(this.isCaptureMode);
            QQFilterLogManager.setOnDrawFilterStart();
            next2.setInputTextureID(i3);
            next2.onDrawFrame();
            i3 = next2.getOutputTextureID();
            QQFilterLogManager.setOnDrawFilterEnd("runChain: " + next2.getClass().getName());
        }
        GLES20.glDisable(2929);
        FrameBufferCache.getInstance().forceRecycle();
        return i3;
    }

    public void setCaptureMode(boolean z16) {
        this.isCaptureMode = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCommonParam(QQFilterRenderManager qQFilterRenderManager) {
        this.mCommonParam = qQFilterRenderManager;
        this.mFaceDetect = new QQFaceDetectBase(qQFilterRenderManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFilterSpecificParam(int i3, Object obj) {
        FilterChain filterChain;
        try {
            filterChain = this.mChains.peek();
        } catch (EmptyStackException e16) {
            if (SLog.isEnable()) {
                SLog.e(TAG, "setFilterSpecificParam: EmptyStackException ", e16);
            }
            filterChain = null;
        }
        if (filterChain != null && filterChain.hasFilterType(i3)) {
            this.mCacheQueue.getFilterByType(i3).setSpecificParam(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNeedFaceDetectFlip(boolean z16) {
        this.mFaceDetect.setNeedFlip(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String push(int[] iArr, Object[] objArr) {
        return pushChainInternal(iArr, objArr);
    }

    String push(int[] iArr) {
        return push(iArr, (Object[]) null);
    }
}
