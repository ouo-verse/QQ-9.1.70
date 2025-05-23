package com.tencent.biz.richframework.order;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWOrderElementManager {
    private final Map<String, List<IOrderElement>> mOrderElementGroupMap = new ConcurrentHashMap();
    private final Map<String, Map<IOrderElement, Boolean>> mActivatingElementGroupMap = new ConcurrentHashMap();
    private final LruCache<String, List<IOrderElement>> mHistoryActivatedElementGroupMap = new LruCache<>(100);
    private final LruCache<String, Integer> mDestroyedActivityList = new LruCache<>(50);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum OrderMode {
        NORMAL_MODE,
        ROB_MODE,
        FORCE_MODE,
        WAIT_MODE
    }

    public RFWOrderElementManager() {
        Application application = RFWApplication.getApplication();
        if (application instanceof Application) {
            application.registerActivityLifecycleCallbacks(new RFWOrderManagerActivityCallBacks(this));
        }
    }

    private synchronized void addElementToHistoryActivatedGroup(IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[addElementToHistoryActivatedGroup] element is not valid; " + iOrderElement);
            return;
        }
        String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement);
        if (TextUtils.isEmpty(contextHashCodeCombineGroup)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[addElementToHistoryActivatedGroup] groupContextHashcode should not be null");
            return;
        }
        String groupExtraKey = iOrderElement.getGroupExtraKey();
        if (!TextUtils.isEmpty(groupExtraKey)) {
            contextHashCodeCombineGroup = contextHashCodeCombineGroup + "_" + groupExtraKey;
        }
        if (this.mHistoryActivatedElementGroupMap.get(contextHashCodeCombineGroup) == null) {
            this.mHistoryActivatedElementGroupMap.put(contextHashCodeCombineGroup, new CopyOnWriteArrayList());
        }
        List<IOrderElement> list = this.mHistoryActivatedElementGroupMap.get(contextHashCodeCombineGroup);
        if (isAdded(list, iOrderElement)) {
            int indexOf = list.indexOf(iOrderElement);
            if (indexOf > -1 && indexOf < list.size()) {
                list.remove(indexOf);
            }
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[addElementToHistoryActivatedGroup] remove the exist element: " + iOrderElement.getClass().getSimpleName() + ", index: " + indexOf);
        }
        list.add(iOrderElement);
    }

    private void clearHistoryActivatedElementGroupMap(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str4 = str + "_" + str2;
            if (!TextUtils.isEmpty(str3)) {
                str4 = str4 + "_" + str3;
            }
            RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[clearHistoryActivatedElementGroupMap] groupContextHashCode:" + str4);
            if (this.mHistoryActivatedElementGroupMap.get(str4) != null) {
                this.mHistoryActivatedElementGroupMap.remove(str4);
                return;
            }
            return;
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[clearHistoryActivatedElementGroupMap] is not exist the group. contextHashCode =" + str + ", group =" + str2);
    }

    private <T> void clearLRUByContextInfo(@NonNull LruCache<String, T> lruCache, String str, String str2, String str3) {
        for (String str4 : lruCache.snapshot().keySet()) {
            if (str4.startsWith(str)) {
                if (!TextUtils.isEmpty(str3)) {
                    if (str4.endsWith(str3)) {
                        lruCache.remove(str4);
                    }
                } else {
                    if (!TextUtils.isEmpty(str2) && !str4.contains(str2)) {
                    }
                    lruCache.remove(str4);
                }
            }
        }
    }

    private <T> void clearMapByContextInfo(@NonNull Map<String, T> map, String str, String str2) {
        for (String str3 : map.keySet()) {
            if (str3.startsWith(str) && (TextUtils.isEmpty(str2) || str3.endsWith(str2))) {
                map.remove(str3);
            }
        }
    }

    private void doRealActivate(final IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            return;
        }
        RFWLog.d("RFWOrderElementManager", RFWLog.USR, RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement) + "[doRealActivate] finalActivateElement = " + iOrderElement);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.richframework.order.RFWOrderElementManager.3
            @Override // java.lang.Runnable
            public void run() {
                iOrderElement.onElementActivated();
            }
        });
        updateElementActivateStatus(iOrderElement, true);
        addElementToHistoryActivatedGroup(iOrderElement);
    }

    private IOrderElement getCanActivateMaxPriorityElement(List<IOrderElement> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return null;
        }
        for (IOrderElement iOrderElement : list) {
            if (iOrderElement.isElementCanActivate()) {
                return iOrderElement;
            }
        }
        return null;
    }

    private IOrderElement getFinalCanActivateElement(List<IOrderElement> list, OrderMode orderMode, IOrderElement iOrderElement, long j3) {
        if (RFSafeListUtils.isEmpty(list)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getFinalCanActivateElement] currentOrderElementList should not be null");
            return null;
        }
        if (orderMode == OrderMode.ROB_MODE) {
            return getRobModeElement(iOrderElement);
        }
        if (orderMode == OrderMode.FORCE_MODE) {
            return getForceModeElement(iOrderElement);
        }
        if (orderMode == OrderMode.WAIT_MODE) {
            return getWaitModeElement(list, j3);
        }
        return getNormalModeElement(list);
    }

    private IOrderElement getForceModeElement(IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getForceModeElement] Activate is not valid; " + iOrderElement);
            return null;
        }
        IOrderElement groupActivatingElement = getGroupActivatingElement(iOrderElement);
        if (!iOrderElement.isElementCanActivate()) {
            return null;
        }
        if (!isValidElement(groupActivatingElement)) {
            return iOrderElement;
        }
        RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[getForceModeElement] shouldActivateNewElement = " + iOrderElement + ", activatingElement = " + groupActivatingElement);
        inactivateElement(groupActivatingElement, false);
        return iOrderElement;
    }

    private IOrderElement getNormalModeElement(List<IOrderElement> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getNormalModeElement] currentOrderElementList should not be null");
            return null;
        }
        IOrderElement groupActivatingElement = getGroupActivatingElement(list.get(0));
        if (groupActivatingElement != null) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getNormalModeElement] group has element is activating. activatingElement =" + groupActivatingElement);
            return null;
        }
        for (IOrderElement iOrderElement : list) {
            if (iOrderElement.isElementCanActivate()) {
                return iOrderElement;
            }
        }
        return null;
    }

    private IOrderElement getRobModeElement(IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getRobModeElement] shouldActivateNewElement is not valid; " + iOrderElement);
            return null;
        }
        IOrderElement groupActivatingElement = getGroupActivatingElement(iOrderElement);
        if (iOrderElement.isElementCanActivate()) {
            if (!isValidElement(groupActivatingElement)) {
                return iOrderElement;
            }
            if (iOrderElement.getPriority() > groupActivatingElement.getPriority()) {
                RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[getRobModeElement] shouldActivateNewElement = " + iOrderElement + ", activatingElement = " + groupActivatingElement);
                inactivateElement(groupActivatingElement, false);
                return iOrderElement;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00eb, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private IOrderElement getWaitModeElement(List<IOrderElement> list, long j3) {
        if (RFSafeListUtils.isEmpty(list)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getWaitModeElement] currentOrderElementList should not be null");
            return null;
        }
        IOrderElement groupActivatingElement = getGroupActivatingElement(list.get(0));
        if (groupActivatingElement != null) {
            RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[getWaitModeElement] has element is activating. activatingElement =" + groupActivatingElement);
            return null;
        }
        RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[getWaitModeElement] waitTime = " + j3);
        Iterator<IOrderElement> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            final IOrderElement next = it.next();
            if (next != null) {
                String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(next);
                RFWLog.d("RFWOrderElementManager", RFWLog.USR, contextHashCodeCombineGroup + "[getWaitModeElement] element = " + next.getClass().getSimpleName() + ", element.isDataReady() = " + next.isDataReady() + ", element.isElementCanActivate() = " + next.isElementCanActivate());
                if (!next.isDataReady()) {
                    RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.richframework.order.RFWOrderElementManager.5
                        @Override // java.lang.Runnable
                        public void run() {
                            RFWOrderElementManager.this.notifyGroupActivate(next.getContextHashCode(), next.getGroup());
                        }
                    }, j3);
                    break;
                }
                if (next.isElementCanActivate()) {
                    RFWLog.d("RFWOrderElementManager", RFWLog.USR, contextHashCodeCombineGroup + "[getWaitModeElement] final element = " + next);
                    return next;
                }
            }
        }
    }

    private boolean isAdded(List<IOrderElement> list, @NonNull IOrderElement iOrderElement) {
        for (IOrderElement iOrderElement2 : list) {
            if (iOrderElement2 != null) {
                if (iOrderElement2 == iOrderElement) {
                    return true;
                }
                if (TextUtils.equals(iOrderElement2.getClass().getSimpleName(), iOrderElement.getClass().getSimpleName()) && iOrderElement2.getPriority() == iOrderElement.getPriority()) {
                    if (TextUtils.isEmpty(iOrderElement.getElementExtraKey())) {
                        RFWLog.w("RFWOrderElementManager", RFWLog.USR, "[isAdded] add the same element. old element = " + iOrderElement2 + ", newElement =" + iOrderElement);
                        return true;
                    }
                    if (TextUtils.equals(iOrderElement2.getElementExtraKey(), iOrderElement.getElementExtraKey())) {
                        RFWLog.w("RFWOrderElementManager", RFWLog.USR, "[isAdded] newElement.getElementExtraKey()" + iOrderElement.getElementExtraKey());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isDoSameElementActivate(@NonNull final IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            return true;
        }
        String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement);
        if (getGroupActivatingElement(iOrderElement) != iOrderElement) {
            return false;
        }
        boolean isElementCanActivate = iOrderElement.isElementCanActivate();
        RFWLog.d("RFWOrderElementManager", RFWLog.USR, contextHashCodeCombineGroup + "[isDoSameElementActivate] recall by " + iOrderElement + ", elementCanActivate:" + isElementCanActivate);
        if (isElementCanActivate) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.richframework.order.RFWOrderElementManager.4
                @Override // java.lang.Runnable
                public void run() {
                    iOrderElement.onElementActivated();
                }
            });
        } else {
            inactivateElement(iOrderElement);
        }
        return true;
    }

    private Boolean isListContainElement(List<IOrderElement> list, IOrderElement iOrderElement) {
        if (!RFSafeListUtils.isEmpty(list) && isValidElement(iOrderElement)) {
            return Boolean.valueOf(list.contains(iOrderElement));
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[isListContainElement] element is not valid; " + iOrderElement);
        return Boolean.FALSE;
    }

    private boolean isValidElement(IOrderElement iOrderElement) {
        if (iOrderElement == null || TextUtils.isEmpty(iOrderElement.getContextHashCode()) || TextUtils.isEmpty(iOrderElement.getGroup())) {
            return false;
        }
        for (String str : this.mDestroyedActivityList.snapshot().keySet()) {
            if (TextUtils.isEmpty(iOrderElement.getContextHashCode()) || iOrderElement.getContextHashCode().contains(str)) {
                return false;
            }
        }
        return true;
    }

    private void notifyNextElementActivate(OrderMode orderMode, @NonNull IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            return;
        }
        List<IOrderElement> groupElementList = getGroupElementList(iOrderElement);
        if (RFSafeListUtils.isEmpty(groupElementList)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[notifyNextElementActivate] currentOrderElementList should not be null");
            return;
        }
        List<IOrderElement> historyActivatedElementList = getHistoryActivatedElementList(iOrderElement);
        ArrayList arrayList = new ArrayList();
        for (IOrderElement iOrderElement2 : groupElementList) {
            if (iOrderElement2 != null && iOrderElement2 != iOrderElement && (RFSafeListUtils.isEmpty(historyActivatedElementList) || !historyActivatedElementList.contains(iOrderElement2))) {
                arrayList.add(iOrderElement2);
            }
        }
        doRealActivate(getFinalCanActivateElement(arrayList, orderMode, iOrderElement, 0L));
    }

    private void removeElementFromActivatingGroup(IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[removeElementFromActivatingGroup] element is not valid; " + iOrderElement);
            return;
        }
        String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement);
        if (TextUtils.isEmpty(contextHashCodeCombineGroup)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[removeElementFromActivatingGroup] groupContextHashcode should not be null");
            return;
        }
        Map<IOrderElement, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        for (String str : this.mActivatingElementGroupMap.keySet()) {
            if (!TextUtils.isEmpty(str) && str.contains(contextHashCodeCombineGroup)) {
                concurrentHashMap = this.mActivatingElementGroupMap.get(str);
            }
        }
        if (concurrentHashMap.containsKey(iOrderElement)) {
            concurrentHashMap.remove(iOrderElement);
        }
    }

    private void removeElementFromHistoryActivatedGroup(IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[removeElementFromHistoryActivatedGroup] element is not valid; " + iOrderElement);
            return;
        }
        String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement);
        if (TextUtils.isEmpty(contextHashCodeCombineGroup)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[removeElementFromHistoryActivatedGroup] groupContextHashcode should not be null");
            return;
        }
        if (!TextUtils.isEmpty(iOrderElement.getGroupExtraKey())) {
            contextHashCodeCombineGroup = contextHashCodeCombineGroup + "_" + iOrderElement.getGroupExtraKey();
        }
        List<IOrderElement> arrayList = new ArrayList<>();
        for (String str : this.mHistoryActivatedElementGroupMap.snapshot().keySet()) {
            if (!TextUtils.isEmpty(str) && str.contains(contextHashCodeCombineGroup)) {
                arrayList = this.mHistoryActivatedElementGroupMap.get(str);
            }
        }
        if (arrayList.contains(iOrderElement)) {
            arrayList.remove(iOrderElement);
        }
    }

    private synchronized void updateElementActivateStatus(IOrderElement iOrderElement, boolean z16) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[updateElementActivateStatus] element is not valid; " + iOrderElement);
            return;
        }
        String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement);
        if (TextUtils.isEmpty(contextHashCodeCombineGroup)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[updateElementActivateStatus] groupContextHashcode should not be null");
            return;
        }
        if (!this.mActivatingElementGroupMap.containsKey(contextHashCodeCombineGroup)) {
            if (z16) {
                this.mActivatingElementGroupMap.put(contextHashCodeCombineGroup, new ConcurrentHashMap());
            } else {
                return;
            }
        }
        Map<IOrderElement, Boolean> map = this.mActivatingElementGroupMap.get(contextHashCodeCombineGroup);
        if (!z16) {
            map.remove(iOrderElement);
        } else {
            map.put(iOrderElement, Boolean.valueOf(z16));
        }
    }

    public void addElement(@NonNull IOrderElement iOrderElement) {
        addElement(iOrderElement, true);
    }

    public void clearGroup(String str) {
        clearGroup(str, "");
    }

    public IOrderElement getGroupActivatingElement(@NonNull IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getGroupActivatingElement] element is not valid; " + iOrderElement);
            return null;
        }
        return getGroupActivatingElement(iOrderElement.getContextHashCode(), iOrderElement.getGroup());
    }

    public List<IOrderElement> getGroupElementList(@NonNull IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getGroupElementList] element is not valid; " + iOrderElement);
            return null;
        }
        return getGroupElementList(iOrderElement.getContextHashCode(), iOrderElement.getGroup());
    }

    public List<IOrderElement> getHistoryActivatedElementList(@NonNull IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getHistoryActivatedElementList] element is not valid; " + iOrderElement);
            return null;
        }
        return getHistoryActivatedElementList(iOrderElement.getContextHashCode(), iOrderElement.getGroup(), iOrderElement.getGroupExtraKey());
    }

    public void inactivateElement(@NonNull final IOrderElement iOrderElement, boolean z16) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[onElementInactivated] element is not valid; " + iOrderElement);
            return;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.richframework.order.RFWOrderElementManager.2
            @Override // java.lang.Runnable
            public void run() {
                iOrderElement.onElementInactivated();
            }
        });
        updateElementActivateStatus(iOrderElement, false);
        if (z16) {
            notifyNextElementActivate(OrderMode.NORMAL_MODE, iOrderElement);
        }
    }

    public boolean isElementActivating(@NonNull IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[isElementActivating] element is not valid; " + iOrderElement);
            return false;
        }
        if (getGroupActivatingElement(iOrderElement) == iOrderElement) {
            return true;
        }
        return false;
    }

    public void notifyGroupActivate(@NonNull IOrderElement iOrderElement, OrderMode orderMode, long j3) {
        if (isValidElement(iOrderElement)) {
            notifyGroupActivate(iOrderElement.getContextHashCode(), iOrderElement.getGroup(), orderMode, iOrderElement, j3);
        }
    }

    public void reloadGroupActivate(String str, String str2) {
        reloadGroupActivate(str, str2, "");
    }

    public void removeElement(@NonNull final IOrderElement iOrderElement) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[removeElement] element is not valid; " + iOrderElement);
            return;
        }
        String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement);
        if (TextUtils.isEmpty(contextHashCodeCombineGroup)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[removeElement] groupContextHashcode should not be null");
            return;
        }
        if (!this.mOrderElementGroupMap.containsKey(contextHashCodeCombineGroup)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[removeElement] groupContextHashcode is not exist");
            return;
        }
        List<IOrderElement> list = this.mOrderElementGroupMap.get(contextHashCodeCombineGroup);
        if (isListContainElement(list, iOrderElement).booleanValue()) {
            RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[removeElement] element = " + iOrderElement);
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.richframework.order.RFWOrderElementManager.1
                @Override // java.lang.Runnable
                public void run() {
                    iOrderElement.onElementInactivated();
                }
            });
            list.remove(iOrderElement);
            removeElementFromActivatingGroup(iOrderElement);
            removeElementFromHistoryActivatedGroup(iOrderElement);
        }
    }

    public synchronized void sortElement(@NonNull IOrderElement iOrderElement) {
        List<IOrderElement> groupElementList = getGroupElementList(iOrderElement);
        if (RFSafeListUtils.isEmpty(groupElementList)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[sortElement] group element list is empty");
        } else {
            RFWElementOperateUtils.quickSort(groupElementList, 0, groupElementList.size() - 1);
        }
    }

    public synchronized void addElement(@NonNull IOrderElement iOrderElement, boolean z16) {
        if (!isValidElement(iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[addElement] element is not valid; " + iOrderElement);
            return;
        }
        String contextHashCodeCombineGroup = RFWElementOperateUtils.getContextHashCodeCombineGroup(iOrderElement);
        if (TextUtils.isEmpty(contextHashCodeCombineGroup)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[addElement] groupContextHashcode should not be null");
            return;
        }
        if (!this.mOrderElementGroupMap.containsKey(contextHashCodeCombineGroup)) {
            this.mOrderElementGroupMap.put(contextHashCodeCombineGroup, new CopyOnWriteArrayList());
        }
        List<IOrderElement> list = this.mOrderElementGroupMap.get(contextHashCodeCombineGroup);
        if (isAdded(list, iOrderElement)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[addElement] you can not add the same element : " + iOrderElement.getClass().getSimpleName());
            return;
        }
        list.add(iOrderElement);
        if (z16) {
            RFWElementOperateUtils.quickSort(list, 0, list.size() - 1);
        }
    }

    public void clearGroup(String str, String str2) {
        clearGroup(str, str2, "");
    }

    public void reloadGroupActivate(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str4 = str + "_" + str2;
            List<IOrderElement> groupElementList = getGroupElementList(str, str2);
            clearHistoryActivatedElementGroupMap(str, str2, str3);
            IOrderElement groupActivatingElement = getGroupActivatingElement(str, str2);
            IOrderElement canActivateMaxPriorityElement = getCanActivateMaxPriorityElement(groupElementList);
            if (canActivateMaxPriorityElement == null) {
                RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[reloadGroupActivate] canActivateMaxPriorityElement should not be null");
                inactivateElement(groupActivatingElement, false);
                return;
            }
            if (groupActivatingElement != null && canActivateMaxPriorityElement != groupActivatingElement) {
                RFWLog.e("RFWOrderElementManager", RFWLog.USR, str4 + "[reloadGroupActivate] hide activatingElement: " + groupActivatingElement);
                inactivateElement(groupActivatingElement, false);
            }
            RFWLog.d("RFWOrderElementManager", RFWLog.USR, str4 + "[reloadGroupActivate] canActivateMaxPriorityElement:" + canActivateMaxPriorityElement);
            doRealActivate(canActivateMaxPriorityElement);
            return;
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, new RuntimeException("[reloadGroupActivate] is not exist the group. contextHashCode = " + str + ", group = " + str2));
    }

    public void clearGroup(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, new RuntimeException("[clearGroup] contextHashCode should not be null"));
            return;
        }
        clearMapByContextInfo(this.mOrderElementGroupMap, str, str2);
        clearMapByContextInfo(this.mActivatingElementGroupMap, str, str2);
        clearLRUByContextInfo(this.mHistoryActivatedElementGroupMap, str, str2, str3);
    }

    public void notifyGroupActivate(String str, String str2) {
        notifyGroupActivate(str, str2, OrderMode.NORMAL_MODE, null, 0L);
    }

    public IOrderElement getGroupActivatingElement(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            if (!this.mActivatingElementGroupMap.containsKey(str3)) {
                return null;
            }
            Map<IOrderElement, Boolean> map = this.mActivatingElementGroupMap.get(str3);
            if (RFSafeMapUtils.isEmpty(map)) {
                RFWLog.d("RFWOrderElementManager", RFWLog.USR, str3 + "[getGroupActivatingElement] isActivatingGroupMap not exist.");
                return null;
            }
            for (Map.Entry<IOrderElement, Boolean> entry : map.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    return entry.getKey();
                }
            }
            return null;
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, new RuntimeException("[getGroupActivatingElement] is not exist the group. contextHashCode = " + str + ", group = " + str2));
        return null;
    }

    public List<IOrderElement> getGroupElementList(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return getGroupElementList(String.valueOf(context.hashCode()), str);
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getGroupElementList] is not valid argument. context = " + context + ", group = " + str);
        return null;
    }

    public void notifyGroupActivate(@NonNull IOrderElement iOrderElement) {
        if (isValidElement(iOrderElement)) {
            notifyGroupActivate(iOrderElement.getContextHashCode(), iOrderElement.getGroup(), OrderMode.NORMAL_MODE, iOrderElement, 0L);
        }
    }

    public void inactivateElement(@NonNull IOrderElement iOrderElement) {
        inactivateElement(iOrderElement, true);
    }

    public void notifyGroupActivate(@NonNull IOrderElement iOrderElement, OrderMode orderMode) {
        if (isValidElement(iOrderElement)) {
            notifyGroupActivate(iOrderElement.getContextHashCode(), iOrderElement.getGroup(), orderMode, iOrderElement, 800L);
        }
    }

    public List<IOrderElement> getGroupElementList(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (RFSafeMapUtils.isEmpty(this.mOrderElementGroupMap)) {
                RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[getGroupElementList] mOrderElementPageMap is null");
                return null;
            }
            return this.mOrderElementGroupMap.get(str + "_" + str2);
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, new RuntimeException("[getGroupElementList] is not valid argument. contextHashCode = " + str + ", group = " + str2));
        return null;
    }

    public List<IOrderElement> getHistoryActivatedElementList(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str4 = str + "_" + str2;
            if (!TextUtils.isEmpty(str3)) {
                str4 = str4 + "_" + str3;
            }
            if (this.mHistoryActivatedElementGroupMap.get(str4) == null) {
                return null;
            }
            List<IOrderElement> list = this.mHistoryActivatedElementGroupMap.get(str4);
            RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[getHistoryActivatedElementList] mHistoryActivatedElementGroupMap print");
            RFWElementOperateUtils.printList(list);
            return list;
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, new RuntimeException("[getHistoryActivatedElementList] is not exist the group. contextHashCode = " + str + ", group = " + str2));
        return null;
    }

    public void inactivateElement(String str, String str2) {
        String str3 = str + "_" + str2;
        if (TextUtils.isEmpty(str3)) {
            RFWLog.e("RFWOrderElementManager", RFWLog.USR, "[onElementInactivated] groupContextHashcode should not be null");
            return;
        }
        for (String str4 : this.mOrderElementGroupMap.keySet()) {
            if (str4.contains(str3)) {
                Iterator<IOrderElement> it = this.mOrderElementGroupMap.get(str4).iterator();
                while (it.hasNext()) {
                    inactivateElement(it.next(), false);
                }
            }
        }
    }

    private void notifyGroupActivate(String str, String str2, OrderMode orderMode, IOrderElement iOrderElement, long j3) {
        String str3 = str + "_" + str2;
        if (isValidElement(iOrderElement) && isDoSameElementActivate(iOrderElement)) {
            RFWLog.d("RFWOrderElementManager", RFWLog.USR, str3 + "[notifyGroupActivate] doSameElementActivate");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            doRealActivate(getFinalCanActivateElement(getGroupElementList(str, str2), orderMode, iOrderElement, j3));
            return;
        }
        RFWLog.e("RFWOrderElementManager", RFWLog.USR, new RuntimeException("[notifyGroupActivate] is not exist the group. contextHashCode = " + str + ", group = " + str2));
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class RFWOrderManagerActivityCallBacks implements Application.ActivityLifecycleCallbacks {
        private final WeakReference<RFWOrderElementManager> mRFWOrderElementManagerWeakReference;

        public RFWOrderManagerActivityCallBacks(RFWOrderElementManager rFWOrderElementManager) {
            this.mRFWOrderElementManagerWeakReference = new WeakReference<>(rFWOrderElementManager);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.mRFWOrderElementManagerWeakReference.get() == null) {
                return;
            }
            String valueOf = String.valueOf(activity.hashCode());
            RFWLog.d("RFWOrderElementManager", RFWLog.USR, "[onActivityDestroyed] activity.hashCode =" + valueOf + ", activity = " + activity);
            RFWOrderElementManager rFWOrderElementManager = this.mRFWOrderElementManagerWeakReference.get();
            rFWOrderElementManager.mDestroyedActivityList.put(valueOf, 1);
            rFWOrderElementManager.clearGroup(valueOf);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
