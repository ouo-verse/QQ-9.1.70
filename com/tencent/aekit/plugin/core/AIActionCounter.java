package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AIActionCounter {
    static IPatchRedirector $redirector_;
    private static Map<Integer, ActionCounter> actionCounterList;
    private static Map<String, ActionCounter> commonActionCounterMap;

    /* compiled from: P */
    /* renamed from: com.tencent.aekit.plugin.core.AIActionCounter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12077);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AEDetectorType.values().length];
            $SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType = iArr;
            try {
                iArr[AEDetectorType.HAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[AEDetectorType.VOICE_RECOGNIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ActionCounter {
        static IPatchRedirector $redirector_;
        public int count;
        public boolean locked;
        public long updateTime;

        public ActionCounter(int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            this.locked = false;
            this.count = i3;
            this.updateTime = j3;
        }

        public void clear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.count = 0;
            this.updateTime = 0L;
            this.locked = false;
        }

        public void lockCounter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.locked = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12096);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            actionCounterList = new Hashtable();
            commonActionCounterMap = new Hashtable();
        }
    }

    public AIActionCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearAction(AEDetectorType aEDetectorType) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[aEDetectorType.ordinal()];
        if (i3 == 1) {
            for (int i16 : PTHandAttr.handTypes) {
                clearAction(i16);
            }
            return;
        }
        if (i3 != 2) {
            return;
        }
        Iterator<Map.Entry<String, ActionCounter>> it = commonActionCounterMap.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.startsWith(aEDetectorType.value)) {
                clearAction(key);
            }
        }
    }

    public static void clearAll() {
        actionCounterList.clear();
        commonActionCounterMap.clear();
    }

    public static Map<Integer, Integer> getActions(AEDetectorType aEDetectorType) {
        HashMap hashMap = new HashMap();
        if (AnonymousClass1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[aEDetectorType.ordinal()] == 1) {
            for (int i3 : PTHandAttr.handTypes) {
                ActionCounter actionCounter = actionCounterList.get(Integer.valueOf(i3));
                if (actionCounter != null) {
                    hashMap.put(Integer.valueOf(i3), Integer.valueOf(actionCounter.count));
                } else {
                    hashMap.put(Integer.valueOf(i3), 0);
                }
            }
        }
        return hashMap;
    }

    public static Map<String, Integer> getCommonActions(AEDetectorType aEDetectorType) {
        HashMap hashMap = new HashMap();
        if (AnonymousClass1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[aEDetectorType.ordinal()] == 2) {
            for (Map.Entry<String, ActionCounter> entry : commonActionCounterMap.entrySet()) {
                String key = entry.getKey();
                if (key.startsWith(aEDetectorType.name())) {
                    String substring = key.substring(aEDetectorType.value.length());
                    ActionCounter value = entry.getValue();
                    if (value != null) {
                        hashMap.put(substring, Integer.valueOf(value.count));
                    } else {
                        hashMap.put(substring, 0);
                    }
                }
            }
        }
        return hashMap;
    }

    public static void lockAction(AEDetectorType aEDetectorType) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[aEDetectorType.ordinal()];
        if (i3 == 1) {
            for (int i16 : PTHandAttr.handTypes) {
                lockAction(i16);
            }
            return;
        }
        if (i3 != 2) {
            return;
        }
        Iterator<Map.Entry<String, ActionCounter>> it = commonActionCounterMap.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.startsWith(aEDetectorType.name())) {
                lockAction(key);
            }
        }
    }

    public static void updateAction(int i3) {
        ActionCounter actionCounter = actionCounterList.get(Integer.valueOf(i3));
        if (actionCounter == null) {
            actionCounter = new ActionCounter(0, -1L);
        }
        if (actionCounter.locked) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - actionCounter.updateTime > 1000) {
            actionCounter.count++;
            actionCounter.updateTime = currentTimeMillis;
        }
        actionCounterList.put(Integer.valueOf(i3), actionCounter);
    }

    private static void clearAction(int i3) {
        ActionCounter actionCounter = actionCounterList.get(Integer.valueOf(i3));
        if (actionCounter != null) {
            actionCounter.clear();
        }
    }

    private static void lockAction(int i3) {
        ActionCounter actionCounter = actionCounterList.get(Integer.valueOf(i3));
        if (actionCounter != null) {
            actionCounter.lockCounter();
        }
    }

    public static void updateAction(String str) {
        ActionCounter actionCounter = commonActionCounterMap.get(str);
        if (actionCounter == null) {
            actionCounter = new ActionCounter(0, -1L);
        }
        if (actionCounter.locked) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - actionCounter.updateTime > 1000) {
            actionCounter.count++;
            actionCounter.updateTime = currentTimeMillis;
        }
        commonActionCounterMap.put(str, actionCounter);
    }

    private static void clearAction(String str) {
        ActionCounter actionCounter = commonActionCounterMap.get(str);
        if (actionCounter != null) {
            actionCounter.clear();
        }
    }

    private static void lockAction(String str) {
        ActionCounter actionCounter = commonActionCounterMap.get(str);
        if (actionCounter != null) {
            actionCounter.lockCounter();
        }
    }
}
