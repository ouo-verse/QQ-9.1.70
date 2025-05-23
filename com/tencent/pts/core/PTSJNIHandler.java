package com.tencent.pts.core;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSJNIHandler {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private static HashMap<Integer, PTSAppInstance> sAppInstanceMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37156);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = "PTSJNIHandler";
            sAppInstanceMap = new HashMap<>();
        }
    }

    public PTSJNIHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addPTSAppInstance(PTSAppInstance pTSAppInstance) {
        if (pTSAppInstance == null) {
            return;
        }
        sAppInstanceMap.put(Integer.valueOf(pTSAppInstance.getUniqueID()), pTSAppInstance);
    }

    public static void clearPTSAppInstance() {
        sAppInstanceMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PTSAppInstance getAppInstance(int i3) {
        return sAppInstanceMap.get(Integer.valueOf(i3));
    }

    public static float[] getCustomTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5) {
        return PTSNodeFactory.getCustomTextMeasuredSize(fArr, str, str2, str3, str4, str5);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getPageInfo(int i3, String str) {
        String str2;
        PTSAppInstance appInstance = getAppInstance(i3);
        String str3 = "";
        if (appInstance != null) {
            PTSItemData itemData = appInstance.getItemData();
            if (itemData != null) {
                str2 = itemData.getJSONData();
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str2;
                }
                PTSLog.i(TAG, "[getPageInfo], key = " + str + ", res = " + str3);
                return str3;
            }
            PTSLog.e(TAG, "[getPageInfo], data is null.");
        } else {
            PTSLog.e(TAG, "[getPageInfo], app not found.");
        }
        str2 = "";
        if (!TextUtils.isEmpty(str2)) {
        }
        PTSLog.i(TAG, "[getPageInfo], key = " + str + ", res = " + str3);
        return str3;
    }

    public static float[] getRichTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return PTSNodeFactory.getRichTextMeasuredSize(fArr, str, str2, str3, str4, str5, str6, str7);
    }

    public static float[] getTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, int i3) {
        PTSAppInstance appInstance = getAppInstance(i3);
        return appInstance != null ? appInstance.getTextMeasuredSize(fArr, str, str2, str3, str4) : new float[2];
    }

    public static void layoutRefreshCallback(List<PTSLayoutTempPatch> list, int i3) {
        PTSThreadUtil.runOnUIThread(new Runnable(i3, list) { // from class: com.tencent.pts.core.PTSJNIHandler.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$appInstanceUniqueID;
            final /* synthetic */ List val$layoutTempPatchList;

            {
                this.val$appInstanceUniqueID = i3;
                this.val$layoutTempPatchList = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PTSAppInstance appInstance = PTSJNIHandler.getAppInstance(this.val$appInstanceUniqueID);
                    if (appInstance != null) {
                        PTSLayoutTempPatch.applyLayoutTempPatchList(this.val$layoutTempPatchList, appInstance);
                        return;
                    } else {
                        PTSLog.e(PTSJNIHandler.TAG, "[layoutRefreshCallback], app not found.");
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    public static boolean refreshNodeList(List<PTSNodeInfo> list, int i3) {
        PTSThreadUtil.runOnUIThread(new Runnable(i3, list) { // from class: com.tencent.pts.core.PTSJNIHandler.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$appInstanceUniqueID;
            final /* synthetic */ List val$nodeInfoList;

            {
                this.val$appInstanceUniqueID = i3;
                this.val$nodeInfoList = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PTSAppInstance appInstance = PTSJNIHandler.getAppInstance(this.val$appInstanceUniqueID);
                    if (appInstance != null) {
                        if (appInstance.getRootNode() == null) {
                            PTSLog.e(PTSJNIHandler.TAG, "[refreshNodeList], rootNode is null.");
                            return;
                        } else {
                            appInstance.getRootNode().refreshNodeList(this.val$nodeInfoList);
                            return;
                        }
                    }
                    PTSLog.e(PTSJNIHandler.TAG, "refreshNodeList, app not found.");
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
        return true;
    }

    public static void removePTSAppInstance(PTSAppInstance pTSAppInstance) {
        if (pTSAppInstance == null) {
            return;
        }
        sAppInstanceMap.remove(Integer.valueOf(pTSAppInstance.getUniqueID()));
    }

    public static float[] getCustomTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6) {
        return PTSNodeFactory.getCustomTextMeasuredSize(fArr, str, str2, str3, str4, str5, str6);
    }

    public static float[] getCustomTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return PTSNodeFactory.getCustomTextMeasuredSize(fArr, str, str2, str3, str4, str5, str6, str7);
    }

    public static float[] getTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5) {
        return PTSNodeFactory.getTextMeasuredSize(fArr, str, str2, str3, str4, str5);
    }

    public static float[] getTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6) {
        return PTSNodeFactory.getTextMeasuredSize(fArr, str, str2, str3, str4, str5, str6);
    }
}
