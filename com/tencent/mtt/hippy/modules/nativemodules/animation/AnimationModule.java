package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyEngineLifecycleEventListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.DomActionInterceptor;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.animation.a;
import com.tencent.mtt.hippy.utils.ExceptionUtil;
import com.tencent.mtt.hippy.utils.LogUtils;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
@HippyNativeModule(name = "AnimationModule", thread = HippyNativeModule.Thread.DOM)
/* loaded from: classes20.dex */
public class AnimationModule extends HippyNativeModuleBase implements Handler.Callback, HippyEngineLifecycleEventListener, DomActionInterceptor, a.InterfaceC9228a {
    public static final String ANIMATION_ID = "animationId";
    public static final String EVENT_NAME_ANIMATION_CANCEL = "onHippyAnimationCancel";
    public static final String EVENT_NAME_ANIMATION_END = "onHippyAnimationEnd";
    public static final String EVENT_NAME_ANIMATION_REPEAT = "onHippyAnimationRepeat";
    public static final String EVENT_NAME_ANIMATION_START = "onHippyAnimationStart";
    public static final String FOLLOW = "follow";
    public static final String HANDLE_MESSAGE_BY_ANIMATION = "handleMessageByAnimation";
    public static final String TIMING = "timing";
    public static final String USE_ANIMATION = "useAnimation";

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<a> f337436a;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<b> f337437b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f337438c;

    /* renamed from: d, reason: collision with root package name */
    private long f337439d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<Integer> f337440e;

    /* renamed from: f, reason: collision with root package name */
    private Set<b> f337441f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f337442g;

    public AnimationModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337442g = false;
        this.f337440e = Collections.synchronizedSet(new HashSet());
    }

    private void b() {
        this.f337439d = SystemClock.elapsedRealtime();
        if (this.f337441f == null) {
            this.f337441f = new HashSet();
        }
        this.f337441f.clear();
        synchronized (this.f337440e) {
            Iterator<Integer> it = this.f337440e.iterator();
            while (it.hasNext()) {
                this.f337441f.add(this.f337437b.get(it.next().intValue()));
                it.remove();
            }
        }
        Iterator<b> it5 = this.f337441f.iterator();
        while (it5.hasNext()) {
            a(it5.next());
            it5.remove();
        }
        HippyEngineContext hippyEngineContext = this.mContext;
        if (hippyEngineContext == null || hippyEngineContext.getDomManager() == null) {
            return;
        }
        this.mContext.getDomManager().e();
    }

    @HippyMethod(name = "createAnimation")
    public void createAnimation(int i3, String str, HippyMap hippyMap) {
        if (this.f337436a.get(i3) != null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f337436a.put(i3, null);
        }
        try {
            if (TextUtils.equals(str, TIMING)) {
                a(hippyMap);
                e eVar = new e(i3);
                eVar.a(this);
                eVar.a(hippyMap);
                this.f337436a.append(i3, eVar);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @HippyMethod(name = "createAnimationSet")
    public void createAnimationSet(int i3, HippyMap hippyMap) {
        c cVar = new c(i3);
        cVar.a(this);
        if (hippyMap != null) {
            try {
                if (hippyMap.containsKey("repeatCount")) {
                    cVar.c(hippyMap.getInt("repeatCount"));
                }
                HippyArray array = hippyMap.getArray(Node.CHILDREN_ATTR);
                int size = array.size();
                boolean z16 = false;
                for (int i16 = 0; i16 < size; i16++) {
                    HippyMap map = array.getMap(i16);
                    if (!map.containsKey(ANIMATION_ID)) {
                        break;
                    }
                    int i17 = map.getInt(ANIMATION_ID);
                    if (i16 != 0 && map.containsKey("follow")) {
                        z16 = map.getBoolean("follow");
                    }
                    cVar.a(this.f337436a.get(i17), z16);
                }
            } catch (Throwable th5) {
                LogUtils.d("AnimationModule", "createAnimationSet: " + th5.getMessage());
            }
        }
        this.f337436a.append(i3, cVar);
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        this.f337442g = false;
        this.mContext.removeEngineLifecycleEventListener(this);
        if (this.mContext.getDomManager() != null) {
            this.mContext.getDomManager().b(this);
        }
        int size = this.f337436a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f337436a.valueAt(i3).c();
        }
        this.f337436a.clear();
        super.destroy();
    }

    @HippyMethod(name = "destroyAnimation")
    public void destroyAnimation(int i3) {
        ArrayList<Integer> j3;
        stopAnimation(i3);
        a aVar = this.f337436a.get(i3);
        if ((aVar instanceof c) && (j3 = ((c) aVar).j()) != null) {
            Iterator<Integer> it = j3.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                stopAnimation(intValue);
                this.f337436a.remove(intValue);
            }
        }
        this.f337436a.remove(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r12 != 101) goto L16;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        if (!this.f337442g) {
            return true;
        }
        int i3 = message.what;
        if (i3 == 100) {
            if (!this.f337438c.hasMessages(101)) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = this.f337439d;
                if (elapsedRealtime - j3 < 16) {
                    this.f337438c.sendEmptyMessageDelayed(101, elapsedRealtime - j3);
                }
                a();
            }
            return true;
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void initialize() {
        super.initialize();
        this.mContext.addEngineLifecycleEventListener(this);
        this.f337438c = new Handler(this.mContext.getThreadExecutor().getDomThread().getLooper(), this);
        this.f337436a = new SparseArray<>();
        this.f337437b = new SparseArray<>();
        if (this.mContext.getDomManager() != null) {
            this.mContext.getDomManager().a(this);
        }
        this.f337442g = true;
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
    public void onAnimationCancel(a aVar) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(EVENT_NAME_ANIMATION_CANCEL, Integer.valueOf(aVar.d()));
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
    public void onAnimationEnd(a aVar) {
        onAnimationUpdate(aVar);
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(EVENT_NAME_ANIMATION_END, Integer.valueOf(aVar.d()));
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
    public void onAnimationRepeat(a aVar) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(EVENT_NAME_ANIMATION_REPEAT, Integer.valueOf(aVar.d()));
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
    public void onAnimationStart(a aVar) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(EVENT_NAME_ANIMATION_START, Integer.valueOf(aVar.d()));
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.animation.a.InterfaceC9228a
    public void onAnimationUpdate(a aVar) {
        CopyOnWriteArrayList<Integer> e16;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        this.f337440e.addAll(e16);
        if (this.f337442g && !this.f337438c.hasMessages(100)) {
            this.f337438c.sendEmptyMessage(100);
        }
    }

    @Override // com.tencent.mtt.hippy.dom.node.DomActionInterceptor
    public HippyMap onCreateNode(int i3, HippyRootView hippyRootView, HippyMap hippyMap) {
        return a(i3, hippyRootView, hippyMap);
    }

    @Override // com.tencent.mtt.hippy.dom.node.DomActionInterceptor
    public void onDeleteNode(int i3) {
        a(i3, (HippyRootView) null, (HippyMap) null, (ArrayList<Integer>) null);
    }

    @Override // com.tencent.mtt.hippy.HippyEngineLifecycleEventListener
    public void onEnginePause() {
        Handler handler;
        if (this.f337442g && (handler = this.f337438c) != null) {
            handler.post(new Runnable() { // from class: com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationModule.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AnimationModule.this.f337436a == null) {
                        return;
                    }
                    int size = AnimationModule.this.f337436a.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((a) AnimationModule.this.f337436a.valueAt(i3)).i();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngineLifecycleEventListener
    public void onEngineResume() {
        Handler handler;
        if (this.f337442g && (handler = this.f337438c) != null) {
            handler.post(new Runnable() { // from class: com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationModule.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AnimationModule.this.f337436a == null) {
                        return;
                    }
                    int size = AnimationModule.this.f337436a.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((a) AnimationModule.this.f337436a.valueAt(i3)).h();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mtt.hippy.dom.node.DomActionInterceptor
    public HippyMap onUpdateNode(int i3, HippyRootView hippyRootView, HippyMap hippyMap) {
        return a(i3, hippyRootView, hippyMap);
    }

    @HippyMethod(name = "pauseAnimation")
    public void pauseAnimation(int i3) {
        a aVar = this.f337436a.get(i3);
        if (aVar != null) {
            aVar.i();
        }
    }

    @HippyMethod(name = "resumeAnimation")
    public void resumeAnimation(int i3) {
        a aVar = this.f337436a.get(i3);
        if (aVar != null) {
            aVar.h();
        }
    }

    @HippyMethod(name = QZoneJsConstants.ACTION_START_ANIMATION)
    public void startAnimation(int i3) {
        a aVar = this.f337436a.get(i3);
        if (aVar != null) {
            aVar.b();
        }
    }

    @HippyMethod(name = "stopAnimation")
    public void stopAnimation(int i3) {
        a aVar = this.f337436a.get(i3);
        if (aVar != null) {
            aVar.c();
        }
    }

    @HippyMethod(name = "updateAnimation")
    public void updateAnimation(int i3, HippyMap hippyMap) {
        LogUtils.d("shit", Thread.currentThread().getName());
        a aVar = this.f337436a.get(i3);
        if (aVar != null && (aVar.a() == null || !aVar.a().isRunning())) {
            if (aVar instanceof e) {
                a(hippyMap);
                ((e) aVar).a(hippyMap);
                aVar.onAnimationUpdate(null);
                return;
            }
            return;
        }
        LogUtils.d("AnimationModule", "trying to update a unexisted animation or the animation has started");
    }

    private HippyMap a(int i3, HippyRootView hippyRootView, HippyMap hippyMap) {
        if (hippyMap == null) {
            return null;
        }
        if (hippyMap.containsKey(HANDLE_MESSAGE_BY_ANIMATION) && hippyMap.getBoolean(HANDLE_MESSAGE_BY_ANIMATION)) {
            return hippyMap;
        }
        if (!hippyMap.containsKey(USE_ANIMATION)) {
            a(i3, hippyRootView, (HippyMap) null, (ArrayList<Integer>) null);
            return hippyMap;
        }
        try {
            if (!hippyMap.getBoolean(USE_ANIMATION)) {
                a(i3, hippyRootView, (HippyMap) null, (ArrayList<Integer>) null);
                return hippyMap;
            }
            HippyMap hippyMap2 = new HippyMap();
            ArrayList<Integer> arrayList = new ArrayList<>();
            a(i3, hippyMap, hippyMap2, arrayList);
            a(i3, hippyRootView, hippyMap, arrayList);
            hippyMap2.pushBoolean(HANDLE_MESSAGE_BY_ANIMATION, true);
            return hippyMap2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return hippyMap;
        }
    }

    private boolean b(HippyMap hippyMap) {
        return hippyMap != null && hippyMap.containsKey(ANIMATION_ID) && hippyMap.size() == 1;
    }

    private Object a(int i3, int i16) {
        a aVar = this.f337436a.get(i16);
        if (aVar != null) {
            return aVar.f();
        }
        b bVar = this.f337437b.get(i3);
        if (bVar != null) {
            Iterator<a> it = bVar.d().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.d() == i16) {
                    return next.f();
                }
            }
        }
        return Float.valueOf(Float.NaN);
    }

    private void a() {
        try {
            b();
        } catch (Throwable th5) {
            ExceptionUtil.handleNativeException(this.mContext, th5, "doUpdateAnimationNodes error.");
        }
    }

    private void a(int i3, HippyRootView hippyRootView, HippyMap hippyMap, ArrayList<Integer> arrayList) {
        b bVar = this.f337437b.get(i3);
        if (bVar != null) {
            Iterator<a> it = bVar.d().iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && (arrayList == null || !arrayList.contains(Integer.valueOf(next.f337445a)))) {
                    next.b(i3);
                    it.remove();
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            this.f337437b.remove(i3);
            return;
        }
        if (bVar == null) {
            bVar = new b(i3, hippyRootView);
            this.f337437b.append(i3, bVar);
        }
        Iterator<Integer> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            a aVar = this.f337436a.get(it5.next().intValue());
            if (aVar != null) {
                bVar.a(aVar);
                aVar.a(i3);
            }
        }
        bVar.a(hippyMap);
    }

    private void a(int i3, HippyArray hippyArray, HippyArray hippyArray2, ArrayList<Integer> arrayList) {
        if (hippyArray == null) {
            return;
        }
        int size = hippyArray.size();
        for (int i16 = 0; i16 < size; i16++) {
            Object obj = hippyArray.get(i16);
            if (obj instanceof HippyMap) {
                HippyMap hippyMap = (HippyMap) obj;
                if (b(hippyMap)) {
                    int i17 = hippyMap.getInt(ANIMATION_ID);
                    if (arrayList != null) {
                        arrayList.add(Integer.valueOf(i17));
                    }
                    obj = a(i3, i17);
                    if (obj == null) {
                    }
                    hippyArray2.pushObject(obj);
                } else {
                    HippyMap hippyMap2 = new HippyMap();
                    a(i3, hippyMap, hippyMap2, arrayList);
                    hippyArray2.pushMap(hippyMap2);
                }
            } else {
                if (obj instanceof HippyArray) {
                    HippyArray hippyArray3 = new HippyArray();
                    a(i3, (HippyArray) obj, hippyArray3, arrayList);
                    hippyArray2.pushArray(hippyArray3);
                }
                hippyArray2.pushObject(obj);
            }
        }
    }

    private void a(int i3, HippyMap hippyMap, HippyMap hippyMap2, ArrayList<Integer> arrayList) {
        if (hippyMap == null) {
            return;
        }
        for (String str : hippyMap.keySet()) {
            Object obj = hippyMap.get(str);
            if (obj instanceof HippyMap) {
                HippyMap hippyMap3 = (HippyMap) obj;
                if (b(hippyMap3)) {
                    int i16 = hippyMap3.getInt(ANIMATION_ID);
                    if (arrayList != null) {
                        arrayList.add(Integer.valueOf(i16));
                    }
                    obj = a(i3, i16);
                    if (obj != null) {
                        hippyMap2.pushObject(str, obj);
                    }
                } else {
                    HippyMap hippyMap4 = new HippyMap();
                    a(i3, hippyMap3, hippyMap4, arrayList);
                    hippyMap2.pushMap(str, hippyMap4);
                }
            } else if (obj instanceof HippyArray) {
                HippyArray hippyArray = new HippyArray();
                a(i3, (HippyArray) obj, hippyArray, arrayList);
                hippyMap2.pushArray(str, hippyArray);
            } else {
                hippyMap2.pushObject(str, obj);
            }
        }
    }

    private void a(HippyMap hippyMap) {
        if (hippyMap != null && hippyMap.containsKey("startValue")) {
            Object obj = hippyMap.get("startValue");
            if (obj instanceof HippyMap) {
                int i3 = ((HippyMap) obj).getInt(ANIMATION_ID);
                hippyMap.remove("startValue");
                hippyMap.pushObject("startValue", this.f337436a.get(i3).g());
            }
        }
    }

    private void a(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            HippyMap hippyMap = new HippyMap();
            a(bVar.a(), bVar.c(), hippyMap, (ArrayList<Integer>) null);
            hippyMap.pushBoolean(HANDLE_MESSAGE_BY_ANIMATION, true);
            this.mContext.getDomManager().a(bVar.a(), hippyMap, bVar.b());
        } catch (Throwable th5) {
            LogUtils.d("AnimationModule", "updateAnimationNodeProps: " + th5.getMessage());
        }
    }
}
