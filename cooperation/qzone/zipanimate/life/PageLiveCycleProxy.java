package cooperation.qzone.zipanimate.life;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes28.dex */
public class PageLiveCycleProxy implements PageLifeCycle {
    private static final String TAG = "PageLiveCycleProxy";
    private static Stack<Lifecycle> mLifeCycleList = new Stack<>();
    private static HashMap<Lifecycle, CopyOnWriteArrayList<PageLifeCycle>> mPageLifeCycleList = new HashMap<>();
    private static PageLiveCycleProxy mProxy = new PageLiveCycleProxy();

    public static void addPageLifeCycle(PageLifeCycle pageLifeCycle) {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList;
        if (pageLifeCycle == null || (pageLifeCycleList = getPageLifeCycleList()) == null || pageLifeCycleList.contains(pageLifeCycle)) {
            return;
        }
        pageLifeCycleList.add(pageLifeCycle);
    }

    private static Lifecycle getCurrentLifecycle() {
        if (mLifeCycleList.isEmpty()) {
            return null;
        }
        return mLifeCycleList.peek();
    }

    private static CopyOnWriteArrayList<PageLifeCycle> getPageLifeCycleList() {
        Lifecycle currentLifecycle = getCurrentLifecycle();
        if (currentLifecycle == null) {
            return null;
        }
        if (mPageLifeCycleList.containsKey(currentLifecycle) && mPageLifeCycleList.get(currentLifecycle) != null) {
            return mPageLifeCycleList.get(currentLifecycle);
        }
        CopyOnWriteArrayList<PageLifeCycle> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        mPageLifeCycleList.put(currentLifecycle, copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    private static void onLifeCycleDestory() {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList = getPageLifeCycleList();
        if (pageLifeCycleList == null) {
            return;
        }
        Lifecycle currentLifecycle = getCurrentLifecycle();
        Iterator<PageLifeCycle> it = pageLifeCycleList.iterator();
        while (it.hasNext()) {
            PageLifeCycle next = it.next();
            if (next != null) {
                next.onPageDestroy(null);
            }
        }
        pageLifeCycleList.clear();
        mPageLifeCycleList.remove(currentLifecycle);
    }

    public static void sBindLifeCycle(Lifecycle lifecycle) {
        if (lifecycle != null) {
            try {
                if (mLifeCycleList.search(lifecycle) == 1) {
                    return;
                }
                QLog.i(TAG, 1, "sBindLifeCycle = " + lifecycle.getClass().getName() + " data = " + lifecycle);
                lifecycle.addObserver(mProxy);
                mLifeCycleList.push(lifecycle);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void sUnBindLifeCycle(Lifecycle lifecycle) {
        if (lifecycle != null) {
            try {
                QLog.i(TAG, 1, "sUnBindLifeCycle = " + lifecycle.getClass().getName());
                lifecycle.removeObserver(mProxy);
                if (!mLifeCycleList.isEmpty()) {
                    onLifeCycleDestory();
                    mLifeCycleList.pop();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onLifecycleChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList = getPageLifeCycleList();
        if (pageLifeCycleList == null) {
            return;
        }
        Iterator<PageLifeCycle> it = pageLifeCycleList.iterator();
        while (it.hasNext()) {
            PageLifeCycle next = it.next();
            if (next != null) {
                next.onLifecycleChanged(lifecycleOwner, event);
            }
        }
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageCreate(LifecycleOwner lifecycleOwner) {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList = getPageLifeCycleList();
        if (pageLifeCycleList == null) {
            return;
        }
        Iterator<PageLifeCycle> it = pageLifeCycleList.iterator();
        while (it.hasNext()) {
            PageLifeCycle next = it.next();
            if (next != null) {
                next.onPageCreate(lifecycleOwner);
            }
        }
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPagePause(LifecycleOwner lifecycleOwner) {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList = getPageLifeCycleList();
        if (pageLifeCycleList == null) {
            return;
        }
        Iterator<PageLifeCycle> it = pageLifeCycleList.iterator();
        while (it.hasNext()) {
            PageLifeCycle next = it.next();
            if (next != null) {
                next.onPagePause(lifecycleOwner);
            }
        }
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageResume(LifecycleOwner lifecycleOwner) {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList = getPageLifeCycleList();
        if (pageLifeCycleList == null) {
            return;
        }
        Iterator<PageLifeCycle> it = pageLifeCycleList.iterator();
        while (it.hasNext()) {
            PageLifeCycle next = it.next();
            if (next != null) {
                next.onPageResume(lifecycleOwner);
            }
        }
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageStart(LifecycleOwner lifecycleOwner) {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList = getPageLifeCycleList();
        if (pageLifeCycleList == null) {
            return;
        }
        Iterator<PageLifeCycle> it = pageLifeCycleList.iterator();
        while (it.hasNext()) {
            PageLifeCycle next = it.next();
            if (next != null) {
                next.onPageStart(lifecycleOwner);
            }
        }
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageStop(LifecycleOwner lifecycleOwner) {
        CopyOnWriteArrayList<PageLifeCycle> pageLifeCycleList = getPageLifeCycleList();
        if (pageLifeCycleList == null) {
            return;
        }
        Iterator<PageLifeCycle> it = pageLifeCycleList.iterator();
        while (it.hasNext()) {
            PageLifeCycle next = it.next();
            if (next != null) {
                next.onPageStop(lifecycleOwner);
            }
        }
    }

    @Override // cooperation.qzone.zipanimate.life.PageLifeCycle
    public void onPageDestroy(LifecycleOwner lifecycleOwner) {
    }
}
