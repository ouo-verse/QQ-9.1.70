package com.tencent.mobileqq.qqpermission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager;
import com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler;
import com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler;
import com.tencent.mobileqq.qqpermission.permissionhandler.NotificationPermissionHandler;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import com.tencent.mobileqq.qqpermission.view.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes17.dex */
public class QQPermission {
    static IPatchRedirector $redirector_ = null;
    public static final int DENIED = -1;
    public static final int GRANTED = 0;
    private static final int MAX_REQUEST_PERMISSION_SIZE = 3;
    public static final int NOTIFY_TYPE_DIALOG = 2;
    public static final int NOTIFY_TYPE_VIEW = 1;
    private static final String TAG = "QQPermission";
    private ArrayList<BasePermissionHandler> handlers;
    protected Activity mActivity;
    private AndroidPermissionHandler mAndroidPermissionHandler;
    BusinessConfig mBusinessConfig;
    protected Context mContext;
    protected Fragment mFragment;

    /* loaded from: classes17.dex */
    public static abstract class BasePermissionsListener {
        static IPatchRedirector $redirector_;
        private String[] mRequestPermissions;

        public BasePermissionsListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String[] getRequestPermissions() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String[]) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.mRequestPermissions;
        }

        public boolean isShowGuide(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list)).booleanValue();
            }
            return true;
        }

        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QPLog.i(QQPermission.TAG, "onAllGranted");
            }
        }

        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) list2);
                return;
            }
            QPLog.i(QQPermission.TAG, "onDenied: " + list + " results:" + list2);
        }

        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, (Object) list2);
                return;
            }
            QPLog.i(QQPermission.TAG, "onDeniedWithoutShowDlg: " + list + " results:" + list2);
        }

        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) permissionRequestDialog, (Object) list);
                return;
            }
            QPLog.i(QQPermission.TAG, "onDialogShow: " + list);
        }

        public void onMultiSceneDialogDenied() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                QPLog.i(QQPermission.TAG, "onMultiSceneHintDialogDenied.");
            }
        }

        public void onMultiSceneDialogShow(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
            } else {
                QPLog.i(QQPermission.TAG, "onMultiSceneDialogOnShow.");
            }
        }

        @Deprecated
        public void onUncertain(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QPLog.i(QQPermission.TAG, "onUncertain: " + str);
        }

        public void onViewShow(PermissionRequestView permissionRequestView, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) permissionRequestView, (Object) list);
                return;
            }
            QPLog.i(QQPermission.TAG, "onViewShow: " + list);
        }
    }

    /* loaded from: classes17.dex */
    private static class MultiPermissionRequester extends BasePermissionsListener {
        static IPatchRedirector $redirector_ = null;
        private static final int groupSize = 5;
        private static Map<String, Integer> permission2GroupId;
        private List<BasePermissionHandler> mHandlers;
        private int mIndexOfHandler;
        private BasePermissionsListener mListener;
        private int mNotifyType;
        private List<List<String>> mPartPermissions;
        private QQPermission mQQPermission;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31913);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 10)) {
                redirector.redirect((short) 10);
                return;
            }
            ArrayMap arrayMap = new ArrayMap();
            permission2GroupId = arrayMap;
            arrayMap.put(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, 0);
            permission2GroupId.put(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, 0);
            permission2GroupId.put("android.permission.ACCESS_COARSE_LOCATION", 1);
            permission2GroupId.put("android.permission.ACCESS_FINE_LOCATION", 1);
            permission2GroupId.put(QQPermissionConstants.Permission.READ_CONTACTS, 2);
            permission2GroupId.put(QQPermissionConstants.Permission.WRITE_CONTACTS, 2);
            permission2GroupId.put(QQPermissionConstants.Permission.BLUETOOTH_SCAN, 4);
            permission2GroupId.put(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE, 4);
            permission2GroupId.put(QQPermissionConstants.Permission.BLUETOOTH_CONNECT, 4);
        }

        public MultiPermissionRequester(QQPermission qQPermission, String[] strArr, int i3, BasePermissionsListener basePermissionsListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQPermission, strArr, Integer.valueOf(i3), basePermissionsListener);
                return;
            }
            this.mQQPermission = qQPermission;
            this.mNotifyType = i3;
            this.mListener = basePermissionsListener;
            basePermissionsListener.mRequestPermissions = (String[]) Arrays.copyOf(strArr, strArr.length);
            initHandler2Permissions(strArr);
        }

        private void initHandler2Permissions(String[] strArr) {
            this.mIndexOfHandler = 0;
            this.mHandlers = new ArrayList();
            this.mPartPermissions = new ArrayList();
            ArrayList arrayList = new ArrayList(5);
            for (int i3 = 0; i3 < 5; i3++) {
                arrayList.add(i3, -1);
            }
            for (String str : strArr) {
                BasePermissionHandler permissionHandler = this.mQQPermission.getPermissionHandler(str);
                Integer num = permission2GroupId.get(str);
                if (num == null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str);
                    this.mPartPermissions.add(arrayList2);
                    this.mHandlers.add(permissionHandler);
                } else if (((Integer) arrayList.get(num.intValue())).intValue() == -1) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str);
                    this.mPartPermissions.add(arrayList3);
                    this.mHandlers.add(permissionHandler);
                    arrayList.add(num.intValue(), Integer.valueOf(this.mPartPermissions.size() - 1));
                } else {
                    this.mPartPermissions.get(((Integer) arrayList.get(num.intValue())).intValue()).add(str);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public boolean isShowGuide(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list)).booleanValue();
            }
            return this.mListener.isShowGuide(list);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            super.onAllGranted();
            this.mIndexOfHandler++;
            if (!requestNext()) {
                this.mListener.onAllGranted();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
                this.mListener.onDenied(list, list2);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDeniedWithoutShowDlg(list, list2);
                this.mListener.onDeniedWithoutShowDlg(list, list2);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) permissionRequestDialog, (Object) list);
            } else {
                super.onDialogShow(permissionRequestDialog, list);
                this.mListener.onDialogShow(permissionRequestDialog, list);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onUncertain(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                super.onUncertain(str);
                this.mListener.onUncertain(str);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onViewShow(PermissionRequestView permissionRequestView, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) permissionRequestView, (Object) list);
            } else {
                super.onViewShow(permissionRequestView, list);
                this.mListener.onViewShow(permissionRequestView, list);
            }
        }

        public boolean requestNext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            QPLog.i(QQPermission.TAG, "requestNext: " + this.mIndexOfHandler);
            if (this.mIndexOfHandler < this.mHandlers.size()) {
                this.mHandlers.get(this.mIndexOfHandler).requestPermissions(this.mPartPermissions.get(this.mIndexOfHandler), this.mNotifyType, this);
                return true;
            }
            return false;
        }
    }

    QQPermission(Activity activity) {
        this(activity, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
    }

    private boolean check(String[] strArr) {
        if (isIllegalSize(strArr)) {
            QPLog.e(TAG, "check: illegal size");
            return false;
        }
        return QQPermissionBusinessManager.check(this.mBusinessConfig, strArr);
    }

    private static int checkSysPermission(Context context, String str) {
        if (context != null && context.checkSelfPermission(str) == 0) {
            return 0;
        }
        return -1;
    }

    public static void enterModule(String str) {
        QLog.d(TAG, 1, "enterModule. id: " + str);
        com.tencent.qmethod.monitor.a.q().d(str).d();
    }

    public static void exitAllModule(String str) {
        QLog.d(TAG, 1, "exitAllModule. id: " + str);
        com.tencent.qmethod.monitor.a.q().d(str).f();
    }

    public static void exitModule(String str) {
        QLog.d(TAG, 1, "exitModule. id: " + str);
        com.tencent.qmethod.monitor.a.q().d(str).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasePermissionHandler getPermissionHandler(String str) {
        if (this.handlers == null) {
            initHandlers();
        }
        Iterator<BasePermissionHandler> it = this.handlers.iterator();
        while (it.hasNext()) {
            BasePermissionHandler next = it.next();
            if (next.canHandle(str)) {
                return next;
            }
        }
        return this.mAndroidPermissionHandler;
    }

    private void initHandlers() {
        ArrayList<BasePermissionHandler> arrayList = new ArrayList<>();
        this.handlers = arrayList;
        arrayList.add(new NotificationPermissionHandler(this));
        this.mAndroidPermissionHandler = new AndroidPermissionHandler(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0022, code lost:
    
        if (r10.equals(com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isIllegalSize(String[] strArr) {
        int length = strArr.length;
        int length2 = strArr.length;
        int i3 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (true) {
            char c16 = 3;
            if (i3 < length2) {
                String str = strArr[i3];
                str.hashCode();
                switch (str.hashCode()) {
                    case -1888586689:
                        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -406040016:
                        if (str.equals(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE)) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case -63024214:
                        if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 1365911975:
                        break;
                }
                c16 = '\uffff';
                switch (c16) {
                    case 0:
                        z19 = true;
                        break;
                    case 1:
                        z16 = true;
                        break;
                    case 2:
                        z18 = true;
                        break;
                    case 3:
                        z17 = true;
                        break;
                }
                i3++;
            } else {
                if (z16 && z17) {
                    length--;
                }
                if (z18 && z19) {
                    length--;
                }
                if (length > 0 && length <= 3) {
                    return false;
                }
                return true;
            }
        }
    }

    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Activity) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mActivity;
    }

    public BusinessConfig getBusinessConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BusinessConfig) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mBusinessConfig;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Context) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mContext;
    }

    public Fragment getFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Fragment) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mFragment;
    }

    public int hasPermission(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        BasePermissionHandler permissionHandler = getPermissionHandler(str);
        int checkPermission = permissionHandler != null ? permissionHandler.checkPermission(str) : -1;
        QPLog.i(TAG, "requestPermission: " + str + ", " + checkPermission);
        return checkPermission;
    }

    public void onRequestPermissionResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        AndroidPermissionHandler androidPermissionHandler = this.mAndroidPermissionHandler;
        if (androidPermissionHandler != null) {
            androidPermissionHandler.onRequestPermissionResult(i3, strArr, iArr);
        }
    }

    public void requestPermissions(String[] strArr, int i3, BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, strArr, Integer.valueOf(i3), basePermissionsListener);
            return;
        }
        QPLog.i(TAG, "requestPermissions: " + Arrays.toString(strArr) + ", " + i3);
        if (!check(strArr)) {
            QPLog.e(TAG, "requestPermissions: illegal request!");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(strArr, i3, basePermissionsListener) { // from class: com.tencent.mobileqq.qqpermission.QQPermission.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String[] f274291d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f274292e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ BasePermissionsListener f274293f;

                {
                    this.f274291d = strArr;
                    this.f274292e = i3;
                    this.f274293f = basePermissionsListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQPermission.this, strArr, Integer.valueOf(i3), basePermissionsListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        new MultiPermissionRequester(QQPermission.this, this.f274291d, this.f274292e, this.f274293f).requestNext();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBusinessConfig(BusinessConfig businessConfig) {
        this.mBusinessConfig = businessConfig;
        QPLog.d(TAG, "setBusiness: " + this.mBusinessConfig);
    }

    QQPermission(Fragment fragment) {
        this(null, fragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQPermission(Activity activity, Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) fragment);
            return;
        }
        this.mActivity = activity;
        this.mFragment = fragment;
        if (activity != null) {
            this.mContext = activity;
        } else if (fragment != null) {
            this.mContext = fragment.getContext();
        }
    }

    public int hasPermission(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        BasePermissionHandler permissionHandler = getPermissionHandler(str2);
        int checkPermission = permissionHandler != null ? permissionHandler.checkPermission(str, str2) : -1;
        QPLog.i(TAG, "requestPermission: " + str2 + ", " + checkPermission);
        return checkPermission;
    }

    public static int hasPermission(Context context, String str, String str2) {
        if (context == null) {
            QLog.e(TAG, 1, "hasPermission mContext is null.");
            return -1;
        }
        int checkSysPermission = checkSysPermission(context, str2);
        if (checkSysPermission == -1) {
            QLog.e(TAG, 1, "hasPermission SystemPermission is denied. result:" + checkSysPermission);
            return checkSysPermission;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            QLog.e(TAG, 1, "hasPermission pm is null. result:" + checkSysPermission);
            return checkSysPermission;
        }
        String permissionGroupName = PermissionUtil.getPermissionGroupName(packageManager, str2);
        if (permissionGroupName == null) {
            QLog.e(TAG, 1, "hasPermission permissionGroup is null. result:" + checkSysPermission);
            return checkSysPermission;
        }
        Map<String, String> map = QQPermissionConstants.BUSINESS_MODULE_MAP;
        if (!map.containsKey(str)) {
            QLog.e(TAG, 1, "hasPermission not find moduleId. result:" + checkSysPermission);
            return checkSysPermission;
        }
        String str3 = map.get(str);
        int i3 = !com.tencent.mobileqq.qqpermission.multiscene.a.d(context, str3, permissionGroupName) ? 1 : 0;
        QPLog.i(TAG, "requestPermission: businessId: " + str + " moduleId: " + str3 + " permission: " + str2 + " permissionGroup: " + permissionGroupName + " result: " + i3);
        return i3;
    }
}
