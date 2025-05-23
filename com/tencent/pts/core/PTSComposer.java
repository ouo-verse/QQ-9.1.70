package com.tencent.pts.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;

/* loaded from: classes22.dex */
public class PTSComposer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PTSComposer";
    private Application.ActivityLifecycleCallbacks activityLifecycleCallback;
    private float containerWidth;
    private String frameTreeString;
    private boolean hasDestroyed;
    private String jsonData;
    private String pageName;
    private PTSAppInstance ptsAppInstance;
    private IPTSUpdateDataListener updateDataListener;

    /* loaded from: classes22.dex */
    public interface IPTSUpdateDataListener {
        void onDataUpdated(String str);
    }

    PTSComposer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.hasDestroyed = false;
        }
    }

    public static PTSComposer buildComposer(String str, String str2, String str3, IPTSLiteEventListener iPTSLiteEventListener) {
        return buildComposer(str, str2, str3, PTSDeviceUtil.getScreenWidthDp(), iPTSLiteEventListener);
    }

    private boolean rebuildPtsAppInstance(boolean z16) {
        boolean z17;
        boolean z18 = false;
        if (!z16) {
            PTSLog.i(TAG, "[rebuildPtsAppInstance] shouldRebuild = false.");
            return false;
        }
        try {
            z17 = true;
            PTSAppInstance build = new PTSAppInstance.Builder().withRootNodeType(1).withItemData(new PTSItemData.Builder().withPageName(this.pageName).withFrameTreeJson(this.frameTreeString).withJsonData(this.jsonData).build()).withContainerWidth(this.containerWidth).withLiteEventListener(null).build();
            this.ptsAppInstance = build;
            build.setPtsComposer(this);
            try {
                this.hasDestroyed = false;
            } catch (IllegalArgumentException e16) {
                e = e16;
                z18 = true;
                PTSLog.e(TAG, "[rebuildPtsAppInstance] pageName = " + this.pageName + ", e = " + e);
                z17 = z18;
                PTSLog.i(TAG, "[rebuildPtsAppInstance], rebuildRes = " + z17 + ", pageName = " + this.pageName);
                return z17;
            } catch (Exception e17) {
                e = e17;
                z18 = true;
                PTSLog.e(TAG, "[rebuildPtsAppInstance] pageName = " + this.pageName + ", e = " + e);
                z17 = z18;
                PTSLog.i(TAG, "[rebuildPtsAppInstance], rebuildRes = " + z17 + ", pageName = " + this.pageName);
                return z17;
            }
        } catch (IllegalArgumentException e18) {
            e = e18;
        } catch (Exception e19) {
            e = e19;
        }
        PTSLog.i(TAG, "[rebuildPtsAppInstance], rebuildRes = " + z17 + ", pageName = " + this.pageName);
        return z17;
    }

    private void registerActivityLifecycleCallbacks(Context context) {
        if ((context instanceof Activity) && this.activityLifecycleCallback == null) {
            Application application = ((Activity) context).getApplication();
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks(application) { // from class: com.tencent.pts.core.PTSComposer.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Application val$application;

                {
                    this.val$application = application;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSComposer.this, (Object) application);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                        iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                        return;
                    }
                    PTSLog.i(PTSComposer.TAG, "[onActivityDestroyed]");
                    PTSAppInstance pTSAppInstance = PTSComposer.this.ptsAppInstance;
                    if (pTSAppInstance != null && pTSAppInstance.getContext() == activity) {
                        PTSComposer.this.destroy();
                        Application application2 = this.val$application;
                        if (application2 != null) {
                            application2.unregisterActivityLifecycleCallbacks(PTSComposer.this.activityLifecycleCallback);
                            PTSLog.i(PTSComposer.TAG, "[unregisterActivityLifecycleCallbacks] finished, appInstance = " + pTSAppInstance);
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                    }
                }
            };
            this.activityLifecycleCallback = activityLifecycleCallbacks;
            if (application != null) {
                application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                PTSLog.i(TAG, "[registerActivityLifecycleCallbacks] finished, appInstance = " + this.ptsAppInstance);
            }
        }
    }

    private void unregisterLifecycleCallbacks(Context context) {
        Application application;
        if ((context instanceof Activity) && (application = ((Activity) context).getApplication()) != null) {
            application.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallback);
            PTSLog.i(TAG, "[unregisterLifecycleCallbacks] finished");
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!this.hasDestroyed) {
            unregisterLifecycleCallbacks(this.ptsAppInstance.getContext());
            this.updateDataListener = null;
            this.ptsAppInstance.onDestroy();
            this.hasDestroyed = true;
            PTSLog.i(TAG, "[destroy] PTSComposer.");
            return;
        }
        PTSLog.i(TAG, "[destroy] hasDestroyed, no need to call.");
    }

    public String getJsonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.jsonData;
    }

    public String getPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.pageName;
    }

    public PTSAppInstance getPtsAppInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PTSAppInstance) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.ptsAppInstance;
    }

    public PTSItemView layoutToView(PTSItemView pTSItemView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (PTSItemView) iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSItemView);
        }
        if (pTSItemView == null) {
            PTSLog.e(TAG, "[layoutToView] convertView is null.");
            return null;
        }
        if (this.hasDestroyed) {
            PTSLog.i(TAG, "[layoutToView] failed, PTSComposer has been destroyed.");
            return pTSItemView;
        }
        Context context = pTSItemView.getContext();
        if (context == null) {
            PTSLog.i(TAG, "[layoutToView] failed, context is null.");
            return pTSItemView;
        }
        this.ptsAppInstance.setContext(context);
        PTSRootNode rootNode = this.ptsAppInstance.getRootNode();
        if (rootNode != null) {
            rootNode.setRootView(pTSItemView);
        } else {
            PTSLog.e(TAG, "[layoutTopView] ptsRootNode is null.");
        }
        pTSItemView.bindData(this.ptsAppInstance);
        registerActivityLifecycleCallbacks(pTSItemView.getContext());
        return pTSItemView;
    }

    public void setData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (this.hasDestroyed) {
            PTSLog.i(TAG, "[setData] failed, PTSComposer has been destroyed.");
            return;
        }
        PTSItemData itemData = this.ptsAppInstance.getItemData();
        this.ptsAppInstance.setItemData(new PTSItemData.Builder().withPageName(itemData.getPageName()).withFrameTreeJson(itemData.getFrameTreeJson()).withJsonData(str).build());
        this.jsonData = str;
    }

    public void triggerExposureEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.ptsAppInstance.triggerExposureEvent();
        }
    }

    public String updateData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (this.hasDestroyed) {
            PTSLog.i(TAG, "[setData] failed, PTSComposer has been destroyed.");
            return this.jsonData;
        }
        String updateData = this.ptsAppInstance.updateData(str);
        this.jsonData = updateData;
        IPTSUpdateDataListener iPTSUpdateDataListener = this.updateDataListener;
        if (iPTSUpdateDataListener != null) {
            iPTSUpdateDataListener.onDataUpdated(updateData);
        }
        return this.jsonData;
    }

    public static PTSComposer buildComposer(String str, String str2, String str3, float f16, IPTSLiteEventListener iPTSLiteEventListener) {
        PTSAppInstance build = new PTSAppInstance.Builder().withRootNodeType(1).withItemData(new PTSItemData.Builder().withPageName(str).withFrameTreeJson(str2).withJsonData(str3).build()).withContainerWidth(f16).withLiteEventListener(iPTSLiteEventListener).build();
        PTSComposer pTSComposer = new PTSComposer();
        pTSComposer.ptsAppInstance = build;
        pTSComposer.pageName = str;
        pTSComposer.frameTreeString = str2;
        pTSComposer.jsonData = str3;
        pTSComposer.containerWidth = f16;
        build.setPtsComposer(pTSComposer);
        return pTSComposer;
    }

    public PTSItemView layoutToView(PTSItemView pTSItemView, IPTSLiteEventListener iPTSLiteEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PTSItemView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSItemView, (Object) iPTSLiteEventListener);
        }
        if (pTSItemView == null) {
            PTSLog.e(TAG, "[layoutToView] convertView is null.");
            return null;
        }
        if (this.hasDestroyed) {
            PTSLog.i(TAG, "[layoutToView] failed, PTSComposer has been destroyed.");
            return pTSItemView;
        }
        PTSItemView layoutToView = layoutToView(pTSItemView);
        this.ptsAppInstance.setPtsLiteEventListener(iPTSLiteEventListener);
        return layoutToView;
    }

    public PTSItemView layoutToView(PTSItemView pTSItemView, IPTSLiteEventListener iPTSLiteEventListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PTSItemView) iPatchRedirector.redirect((short) 3, this, pTSItemView, iPTSLiteEventListener, Boolean.valueOf(z16));
        }
        if (pTSItemView == null) {
            PTSLog.e(TAG, "[layoutToView] convertView is null.");
            return null;
        }
        if (this.hasDestroyed && !rebuildPtsAppInstance(z16)) {
            PTSLog.i(TAG, "[layoutToView] failed, PTSComposer has been destroyed.");
            return pTSItemView;
        }
        PTSItemView layoutToView = layoutToView(pTSItemView);
        this.ptsAppInstance.setPtsLiteEventListener(iPTSLiteEventListener);
        return layoutToView;
    }

    public static PTSComposer buildComposer(String str, String str2, String str3, IPTSLiteEventListener iPTSLiteEventListener, IPTSUpdateDataListener iPTSUpdateDataListener) {
        PTSComposer buildComposer = buildComposer(str, str2, str3, PTSDeviceUtil.getScreenWidthDp(), iPTSLiteEventListener);
        buildComposer.updateDataListener = iPTSUpdateDataListener;
        return buildComposer;
    }
}
