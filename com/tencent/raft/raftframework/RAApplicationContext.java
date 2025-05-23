package com.tencent.raft.raftframework;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.raftframework.constant.RAFTConstants;
import com.tencent.raft.raftframework.declare.IRADeclareManager;
import com.tencent.raft.raftframework.declare.RADeclareManager;
import com.tencent.raft.raftframework.log.ILogDelegate;
import com.tencent.raft.raftframework.log.RLog;
import com.tencent.raft.raftframework.service.IRAServiceManager;
import com.tencent.raft.raftframework.service.RAServiceManager;
import com.tencent.raft.raftframework.sla.SLAReporter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RAApplicationContext {
    static IPatchRedirector $redirector_ = null;
    public static final String INIT_CLASS = "com.tencent.raft.generate.RaftServiceEntryMap";
    public static final String TAG = "RAApplicationContext";
    private static RAApplicationContext sInstance;
    private Context mContext;
    private IRADeclareManager mDeclareManager;
    private boolean mHasStartUp;
    private SLAReporter mSLAReporter;
    private IRAServiceManager mServiceManager;

    RAApplicationContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHasStartUp = false;
        }
    }

    public static RAApplicationContext getGlobalContext() {
        if (sInstance == null) {
            sInstance = new RAApplicationContext();
        }
        return sInstance;
    }

    public static RAApplicationContext newInstance() {
        return new RAApplicationContext();
    }

    public static void setLogDelegate(ILogDelegate iLogDelegate) {
        RLog.setLogDelegate(iLogDelegate);
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mContext;
    }

    public synchronized String getDeclareConstant(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        return this.mDeclareManager.getDeclareConstant(str);
    }

    public synchronized Object getDeclareService(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        long nanoTime = System.nanoTime();
        Object declareService = this.mDeclareManager.getDeclareService(str);
        SLAReporter sLAReporter = this.mSLAReporter;
        if (declareService != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sLAReporter.reportGetServiceFinish(nanoTime, z16);
        return declareService;
    }

    public synchronized <T> T getService(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return (T) getService(cls, null);
        }
        return (T) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cls);
    }

    public boolean hasStartUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mHasStartUp;
    }

    public synchronized void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        RLog.d(TAG, "shutdown [" + hashCode() + "]");
        this.mHasStartUp = false;
        this.mServiceManager.destroy();
        this.mServiceManager = null;
        this.mDeclareManager.destroy();
        this.mDeclareManager = null;
        SLAReporter sLAReporter = this.mSLAReporter;
        if (sLAReporter != null) {
            sLAReporter.release();
            this.mSLAReporter = null;
        }
        this.mContext = null;
    }

    public synchronized void startup(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            startup(context, true);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }

    public synchronized <T> T getService(Class<T> cls, IServiceProvider iServiceProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) cls, (Object) iServiceProvider);
        }
        long nanoTime = System.nanoTime();
        T t16 = (T) this.mServiceManager.getService(cls, iServiceProvider);
        this.mSLAReporter.reportGetServiceFinish(nanoTime, t16 != null);
        return t16;
    }

    public synchronized void startup(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16));
            return;
        }
        if (this.mSLAReporter == null) {
            this.mSLAReporter = new SLAReporter(context);
        }
        this.mSLAReporter.open(z16);
        this.mSLAReporter.reportOnFrameworkStartup();
        RLog.d(TAG, "startup [" + hashCode() + "], current RAFT version:" + RAFTConstants.RAFT_VERSION);
        if (!this.mHasStartUp) {
            this.mContext = context;
            this.mServiceManager = new RAServiceManager(INIT_CLASS);
            this.mDeclareManager = new RADeclareManager(INIT_CLASS);
            this.mHasStartUp = true;
            this.mSLAReporter.reportOnFrameworkStartupFinish();
            return;
        }
        RLog.e(TAG, "cannot startup again");
        throw new IllegalStateException("cannot startup again");
    }
}
