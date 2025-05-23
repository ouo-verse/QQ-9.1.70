package cooperation.qzone;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RDMEtraMsgCollector {
    public static final int ACTIVITY_SIZE = 5;
    public static final int CLICK_SIZE = 10;
    public static final int LIFECYCLE_SIZE = 10;
    private static final String TAG = "RDMEtraMsgCollector";
    private static RDMEtraMsgCollector instance;
    public LoopQueue<String> activityNameQueue = new LoopQueue<>(5);
    public LoopQueue<String> activityEventQueue = new LoopQueue<>(10);
    public LoopQueue<String> userActionQueue = new LoopQueue<>(10);

    RDMEtraMsgCollector() {
    }

    public static synchronized RDMEtraMsgCollector getInstance() {
        RDMEtraMsgCollector rDMEtraMsgCollector;
        synchronized (RDMEtraMsgCollector.class) {
            if (instance == null) {
                instance = new RDMEtraMsgCollector();
            }
            rDMEtraMsgCollector = instance;
        }
        return rDMEtraMsgCollector;
    }

    public void addActionSheetClick(String str, View view, int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Actvity] ");
        sb5.append(str);
        if (view != null) {
            sb5.append("  actionSheet click view  id:0x");
            sb5.append(Integer.toHexString(view.getId()));
        }
        sb5.append(" which:");
        sb5.append(i3);
        getInstance().addUserAction(sb5.toString());
    }

    public void addActivityEvent(String str) {
        LoopQueue<String> loopQueue;
        if (str != null && (loopQueue = this.activityEventQueue) != null) {
            if (loopQueue.isFull()) {
                this.activityEventQueue.remove();
            }
            this.activityEventQueue.add(str);
        }
    }

    public void addActivityName(String str) {
        LoopQueue<String> loopQueue;
        if (str != null && (loopQueue = this.activityNameQueue) != null) {
            if (loopQueue.isFull()) {
                this.activityNameQueue.remove();
            }
            this.activityNameQueue.add(str);
        }
    }

    public void addNoramlClickAction(String str, View view) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Actvity] ");
        sb5.append(str);
        if (view != null) {
            sb5.append("  click view  id:0x");
            sb5.append(Integer.toHexString(view.getId()));
        }
        addUserAction(sb5.toString());
    }

    public void addNormalItemClickAction(String str, ViewGroup viewGroup, View view, int i3, long j3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[Actvity] ");
        sb5.append(str);
        if (viewGroup != null) {
            sb5.append("parent id: ");
            sb5.append(viewGroup.getId());
        }
        if (view != null) {
            sb5.append("view id: ");
            sb5.append(view.getId());
        }
        sb5.append(" onItemclick view  position:0x");
        sb5.append(Integer.toHexString(i3));
        sb5.append(" id");
        sb5.append(j3);
        getInstance().addUserAction(sb5.toString());
    }

    public void addUserAction(String str) {
        if (str != null) {
            try {
                LoopQueue<String> loopQueue = this.userActionQueue;
                if (loopQueue != null) {
                    if (loopQueue.isFull()) {
                        this.userActionQueue.remove();
                    }
                    this.userActionQueue.add(str);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "", e16);
                }
            }
        }
    }

    public void destroy() {
        LoopQueue<String> loopQueue = this.activityNameQueue;
        if (loopQueue != null) {
            loopQueue.clear();
            this.activityNameQueue = null;
        }
        LoopQueue<String> loopQueue2 = this.activityEventQueue;
        if (loopQueue2 != null) {
            loopQueue2.clear();
            this.activityEventQueue = null;
        }
        LoopQueue<String> loopQueue3 = this.userActionQueue;
        if (loopQueue3 != null) {
            loopQueue3.clear();
            this.userActionQueue = null;
        }
        instance = null;
    }

    public String getEtraMsg() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("activityNameQueue:\n");
        LoopQueue<String> loopQueue = this.activityNameQueue;
        if (loopQueue != null) {
            sb5.append(loopQueue);
            sb5.append("\n");
        }
        sb5.append(" \n activityEventQueue:\n");
        LoopQueue<String> loopQueue2 = this.activityEventQueue;
        if (loopQueue2 != null) {
            sb5.append(loopQueue2);
        }
        sb5.append(" \n userActionQueue:\n");
        LoopQueue<String> loopQueue3 = this.userActionQueue;
        if (loopQueue3 != null) {
            sb5.append(loopQueue3);
        }
        return sb5.toString();
    }
}
