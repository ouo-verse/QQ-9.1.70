package cooperation.qqcircle.report.perf;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.richframework.thread.RFWThreadManager;

/* loaded from: classes28.dex */
public abstract class AbsPerfTracker implements ITimerListener {
    protected static final int MSG_REPORT_AFTER_ENTER = 4;
    protected static final int MSG_REPORT_AFTER_EXIT = 5;
    protected static final int MSG_REPORT_ENTER = 1;
    protected static final int MSG_REPORT_EXIT = 3;
    protected static final int MSG_REPORT_REGULAR = 2;
    protected boolean mEnableTrackerRatio;
    protected String mReportSeq = "";
    private Handler mTrackerHandler;

    protected abstract boolean enableReport();

    protected abstract boolean enableTracker();

    public abstract void enter(String str);

    public abstract void exit();

    /* JADX INFO: Access modifiers changed from: protected */
    public void generateSeq() {
        this.mReportSeq = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + System.currentTimeMillis();
    }

    protected synchronized Handler getHandler() {
        Handler handler = this.mTrackerHandler;
        if (handler != null) {
            return handler;
        }
        Handler createNewThreadHandler = RFWThreadManager.createNewThreadHandler(getLogTag(), 0, getHandlerCallBack());
        this.mTrackerHandler = createNewThreadHandler;
        return createNewThreadHandler;
    }

    protected abstract Handler.Callback getHandlerCallBack();

    protected abstract String getLogTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeMessage(int i3) {
        Handler handler = getHandler();
        if (handler == null) {
            return;
        }
        handler.removeMessages(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessage(Message message) {
        Handler handler = getHandler();
        if (handler == null) {
            return;
        }
        handler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessageDelay(Message message, long j3) {
        Handler handler = getHandler();
        if (handler == null) {
            return;
        }
        handler.sendMessageDelayed(message, j3);
    }
}
