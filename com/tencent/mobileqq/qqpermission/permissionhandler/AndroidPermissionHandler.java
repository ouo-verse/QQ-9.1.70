package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.util.PermissionDialogUtil;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.IPermissionRequester;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;

/* loaded from: classes17.dex */
public class AndroidPermissionHandler extends BasePermissionHandler {
    static IPatchRedirector $redirector_ = null;
    private static final int INITIAL_CALLBACK_SIZE = 4;
    public static final int RESULT_FOREVER = 3;
    public static final int RESULT_GRANTED = 0;
    public static final int RESULT_RATIONAL = 1;
    public static final int RESULT_UN_NOTIFY = 2;
    private static final String TAG = "AndroidPermissionHandler";
    private static AtomicInteger requestCode;
    private IAccountCallback callback;
    private List<String> grantedPermissions;
    private QQPermissionCallback mAppPermissionCallback;
    private SparseArray<AndroidPermissionCallback> mRequestingCallbacks;
    private QQCustomDialog sCustomDialog;

    /* loaded from: classes17.dex */
    public static abstract class AndroidPermissionCallback {
        static IPatchRedirector $redirector_ = null;
        private static final String TAG = "AndroidPermissionCallback";
        private boolean isFromNeedRationale;
        private ArrayMap<String, Boolean> mBeforeNeedRationales;
        protected QQPermission.BasePermissionsListener mListener;
        protected AndroidPermissionHandler mPermissionHandler;

        public AndroidPermissionCallback(AndroidPermissionHandler androidPermissionHandler, QQPermission.BasePermissionsListener basePermissionsListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) androidPermissionHandler, (Object) basePermissionsListener);
                return;
            }
            this.mPermissionHandler = androidPermissionHandler;
            this.mListener = basePermissionsListener;
            this.mBeforeNeedRationales = new ArrayMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBeforeShouldRationale() {
            this.mBeforeNeedRationales.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean getBeforeNeedRationale(String str) {
            return this.mBeforeNeedRationales.getOrDefault(str, Boolean.FALSE).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void putBeforeNeedRationale(String str, boolean z16) {
            this.mBeforeNeedRationales.put(str, Boolean.valueOf(z16));
        }

        void onDenied(List<String> list, List<Integer> list2) {
            QPLog.i(TAG, "onDenied: " + list + " " + list2);
        }

        void onGranted() {
            QPLog.i(TAG, "onGranted");
            this.mPermissionHandler.closeToast();
        }

        void onNeedRationale(List<String> list, String str) {
            QPLog.i(TAG, "onNeedRationale: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class AndroidPermissionText {
        static IPatchRedirector $redirector_;
        private static final int DEFAULT_PERMISSION_REQ_CONTENT;
        private static final int DEFAULT_PERMISSION_REQ_TITLE;
        private static final ArrayMap<String, Integer> PERMISSION_REQ_CONTENTS;
        private static final ArrayMap<String, Integer> PERMISSION_REQ_TITLES;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32020);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            DEFAULT_PERMISSION_REQ_TITLE = R.string.f202624y0;
            DEFAULT_PERMISSION_REQ_CONTENT = R.string.f202614xz;
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
            PERMISSION_REQ_CONTENTS = arrayMap;
            ArrayMap<String, Integer> arrayMap2 = new ArrayMap<>();
            PERMISSION_REQ_TITLES = arrayMap2;
            if (AppSetting.m() >= 31) {
                arrayMap2.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(R.string.f202664y4));
            } else {
                arrayMap2.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(R.string.f202704y8));
            }
            arrayMap2.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(R.string.f202704y8));
            arrayMap.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(R.string.f202694y7));
            arrayMap2.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(R.string.f202704y8));
            arrayMap.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(R.string.f202694y7));
            arrayMap2.put(QQPermissionConstants.Permission.READ_CONTACTS, Integer.valueOf(R.string.f202594xx));
            arrayMap.put(QQPermissionConstants.Permission.READ_CONTACTS, Integer.valueOf(R.string.f202584xw));
            arrayMap2.put(QQPermissionConstants.Permission.WRITE_CONTACTS, Integer.valueOf(R.string.f202594xx));
            arrayMap.put(QQPermissionConstants.Permission.WRITE_CONTACTS, Integer.valueOf(R.string.f202584xw));
            arrayMap2.put(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, Integer.valueOf(R.string.f202784yf));
            arrayMap.put(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, Integer.valueOf(R.string.f202774ye));
            arrayMap2.put(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, Integer.valueOf(R.string.f202784yf));
            arrayMap.put(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, Integer.valueOf(R.string.f202774ye));
            arrayMap2.put(QQPermissionConstants.Permission.CAMERA, Integer.valueOf(R.string.f202574xv));
            arrayMap.put(QQPermissionConstants.Permission.CAMERA, Integer.valueOf(R.string.f202564xu));
            arrayMap2.put(QQPermissionConstants.Permission.RECORD_AUDIO, Integer.valueOf(R.string.f202764yd));
            arrayMap.put(QQPermissionConstants.Permission.RECORD_AUDIO, Integer.valueOf(R.string.f202754yc));
            arrayMap2.put(QQPermissionConstants.Permission.READ_SMS, Integer.valueOf(R.string.f202744yb));
            arrayMap.put(QQPermissionConstants.Permission.READ_SMS, Integer.valueOf(R.string.f202734ya));
            arrayMap2.put(QQPermissionConstants.Permission.WRITE_CALENDAR, Integer.valueOf(R.string.f202554xt));
            arrayMap.put(QQPermissionConstants.Permission.WRITE_CALENDAR, Integer.valueOf(R.string.f202544xs));
            arrayMap2.put(QQPermissionConstants.Permission.GET_INSTALLED_APPS, Integer.valueOf(R.string.f202684y6));
            arrayMap.put(QQPermissionConstants.Permission.GET_INSTALLED_APPS, Integer.valueOf(R.string.f202674y5));
            arrayMap2.put(QQPermissionConstants.Permission.PERMISSION_NOTIFICATION, Integer.valueOf(R.string.f202724y_));
            arrayMap.put(QQPermissionConstants.Permission.PERMISSION_NOTIFICATION, Integer.valueOf(R.string.f202714y9));
            arrayMap2.put(QQPermissionConstants.Permission.ACTIVITY_RECOGNITION, Integer.valueOf(R.string.f202514xp));
            arrayMap.put(QQPermissionConstants.Permission.ACTIVITY_RECOGNITION, Integer.valueOf(R.string.f202504xo));
            arrayMap2.put(QQPermissionConstants.Permission.BLUETOOTH_CONNECT, Integer.valueOf(R.string.f202534xr));
            arrayMap.put(QQPermissionConstants.Permission.BLUETOOTH_CONNECT, Integer.valueOf(R.string.f202524xq));
            arrayMap2.put(QQPermissionConstants.Permission.BLUETOOTH_SCAN, Integer.valueOf(R.string.f202534xr));
            arrayMap.put(QQPermissionConstants.Permission.BLUETOOTH_SCAN, Integer.valueOf(R.string.f202524xq));
        }

        AndroidPermissionText() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static List<String> filterPermissions(List<String> list) {
            ArrayList arrayList = new ArrayList(list);
            if (list.contains(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) && list.contains(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE)) {
                arrayList.remove(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            }
            if (list.contains("android.permission.ACCESS_FINE_LOCATION") && list.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.remove("android.permission.ACCESS_COARSE_LOCATION");
            }
            if (list.contains(QQPermissionConstants.Permission.BLUETOOTH_SCAN) && list.contains(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) && list.contains(QQPermissionConstants.Permission.BLUETOOTH_CONNECT)) {
                arrayList.remove(QQPermissionConstants.Permission.BLUETOOTH_SCAN);
                arrayList.remove(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);
            }
            return arrayList;
        }

        private static String getContent(Context context, String str) {
            int intValue;
            Integer num = PERMISSION_REQ_CONTENTS.get(str);
            if (num == null) {
                intValue = DEFAULT_PERMISSION_REQ_CONTENT;
            } else {
                intValue = num.intValue();
            }
            return context.getString(intValue);
        }

        public static String getPermissionReqContent(Context context, List<String> list) {
            if (list != null && !list.isEmpty()) {
                String string = context.getString(R.string.f202604xy);
                String string2 = context.getString(R.string.f202804yh);
                String string3 = context.getString(R.string.f202794yg);
                StringBuilder sb5 = new StringBuilder();
                List<String> filterPermissions = filterPermissions(list);
                for (int i3 = 0; i3 < filterPermissions.size(); i3++) {
                    String content = getContent(context, filterPermissions.get(i3));
                    if (i3 == 0) {
                        sb5.append(content);
                    } else if (i3 < filterPermissions.size() - 1) {
                        sb5.append(string2);
                        sb5.append(content);
                    } else {
                        sb5.append(string3);
                        sb5.append(content);
                    }
                }
                return String.format(string, sb5.toString());
            }
            return "";
        }

        public static String getPermissionReqTitle(Context context, List<String> list) {
            if (list != null && !list.isEmpty()) {
                String string = context.getString(R.string.f202814yi);
                String string2 = context.getString(R.string.f202804yh);
                String string3 = context.getString(R.string.f202794yg);
                StringBuilder sb5 = new StringBuilder();
                List<String> filterPermissions = filterPermissions(list);
                for (int i3 = 0; i3 < filterPermissions.size(); i3++) {
                    String title = getTitle(context, filterPermissions.get(i3));
                    if (i3 == 0) {
                        sb5.append(title);
                    } else if (i3 < filterPermissions.size() - 1) {
                        sb5.append(string2);
                        sb5.append(title);
                    } else {
                        sb5.append(string3);
                        sb5.append(title);
                    }
                }
                return String.format(string, sb5.toString());
            }
            return "";
        }

        private static String getTitle(Context context, String str) {
            int intValue;
            Integer num = PERMISSION_REQ_TITLES.get(str);
            if (num == null) {
                intValue = DEFAULT_PERMISSION_REQ_TITLE;
            } else {
                intValue = num.intValue();
            }
            return context.getString(intValue);
        }
    }

    /* loaded from: classes17.dex */
    private static class DialogPermissionCallback extends AndroidPermissionCallback {
        static IPatchRedirector $redirector_;
        private Context mContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes17.dex */
        public class a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PermissionRequestDialog f274318d;

            a(PermissionRequestDialog permissionRequestDialog) {
                this.f274318d = permissionRequestDialog;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogPermissionCallback.this, (Object) permissionRequestDialog);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    DialogPermissionCallback.this.mPermissionHandler.closeToast();
                    if (this.f274318d.getCustomDismissListener() != null) {
                        this.f274318d.getCustomDismissListener().onDismiss(dialogInterface);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }

        public DialogPermissionCallback(AndroidPermissionHandler androidPermissionHandler, Context context, QQPermission.BasePermissionsListener basePermissionsListener) {
            super(androidPermissionHandler, basePermissionsListener);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, androidPermissionHandler, context, basePermissionsListener);
            } else {
                this.mContext = context;
            }
        }

        private boolean isNeedShowGuide(List<String> list, List<String> list2) {
            if (!hasLocationPermissions(list) || list2.size() != 1 || !list2.contains("android.permission.ACCESS_FINE_LOCATION")) {
                return true;
            }
            return this.mListener.isShowGuide(list2);
        }

        private void toShowDialog(List<String> list, List<String> list2) {
            PermissionRequestDialog buildRequestDialog = this.mPermissionHandler.buildRequestDialog(AndroidPermissionText.getPermissionReqTitle(this.mContext, list2), AndroidPermissionText.getPermissionReqContent(this.mContext, list2));
            this.mListener.onDialogShow(buildRequestDialog, list2);
            buildRequestDialog.setInnerDismissListener(new a(buildRequestDialog));
            if (!isNeedShowGuide(list, list2)) {
                this.mPermissionHandler.closeToast();
                return;
            }
            try {
                buildRequestDialog.show();
            } catch (WindowManager.BadTokenException e16) {
                QLog.e(AndroidPermissionHandler.TAG, 1, "toShowDialog e " + e16.getMessage());
            }
        }

        public boolean hasLocationPermissions(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list)).booleanValue();
            }
            if (list.isEmpty()) {
                return false;
            }
            boolean z16 = false;
            boolean z17 = false;
            for (String str : list) {
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    z17 = true;
                } else if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    z16 = true;
                }
                if (z16 && z17) {
                    break;
                }
            }
            if (!z16 || !z17) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
        void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            this.mListener.onDenied(list, list2);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list2.get(i3).intValue() != 1 && list2.get(i3).intValue() != 2) {
                    if (list2.get(i3).intValue() == 3) {
                        arrayList.add(list.get(i3));
                    }
                } else {
                    this.mListener.onDeniedWithoutShowDlg(list, list2);
                    this.mPermissionHandler.closeToast();
                    return;
                }
            }
            toShowDialog(list, arrayList);
        }

        @Override // com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
        void onGranted() {
            super.onGranted();
            this.mListener.onAllGranted();
        }

        @Override // com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
        @RequiresApi(api = 23)
        void onNeedRationale(List<String> list, String str) {
            super.onNeedRationale(list, str);
            this.mPermissionHandler.doRequestPermission(list, this);
        }
    }

    /* loaded from: classes17.dex */
    private static class ViewPermissionCallback extends AndroidPermissionCallback {
        static IPatchRedirector $redirector_;
        private Context mContext;
        private boolean mIsClickSetting;
        private PermissionRequestView mRequestView;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes17.dex */
        public class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f274320d;

            a(List list) {
                this.f274320d = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ViewPermissionCallback.this, (Object) list);
                }
            }

            @Override // android.view.View.OnClickListener
            @RequiresApi(api = 23)
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ViewPermissionCallback.this.mIsClickSetting = true;
                    ViewPermissionCallback viewPermissionCallback = ViewPermissionCallback.this;
                    viewPermissionCallback.mPermissionHandler.doRequestPermission(this.f274320d, viewPermissionCallback);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public ViewPermissionCallback(AndroidPermissionHandler androidPermissionHandler, Context context, QQPermission.BasePermissionsListener basePermissionsListener) {
            super(androidPermissionHandler, basePermissionsListener);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, androidPermissionHandler, context, basePermissionsListener);
            } else {
                this.mContext = context;
            }
        }

        private void toShowView(List<String> list) {
            if (this.mRequestView == null) {
                this.mRequestView = new PermissionRequestView(this.mContext);
            }
            this.mRequestView.setOnSettingClickListener(new a(list));
            this.mRequestView.setTitle(AndroidPermissionText.getPermissionReqTitle(this.mContext, list));
            this.mRequestView.setContent(AndroidPermissionText.getPermissionReqContent(this.mContext, list));
            this.mListener.onViewShow(this.mRequestView, list);
        }

        @Override // com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
        void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            this.mListener.onDenied(list, list2);
            this.mPermissionHandler.closeToast();
            ArrayList arrayList = new ArrayList();
            boolean z16 = false;
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str = list.get(i3);
                int intValue = list2.get(i3).intValue();
                if (intValue == 0 || intValue == 1 || intValue == 2) {
                    z16 = true;
                    if (intValue == 0) {
                    }
                }
                arrayList.add(str);
            }
            toShowView(arrayList);
            if (!z16 && this.mIsClickSetting) {
                this.mIsClickSetting = false;
                PermissionUtil.gotoSettingPage(this.mContext);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
        void onGranted() {
            super.onGranted();
            this.mListener.onAllGranted();
        }

        @Override // com.tencent.mobileqq.qqpermission.permissionhandler.AndroidPermissionHandler.AndroidPermissionCallback
        void onNeedRationale(List<String> list, String str) {
            super.onNeedRationale(list, str);
            toShowView(list);
        }
    }

    /* loaded from: classes17.dex */
    class a implements IAccountCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AndroidPermissionHandler.this);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            } else {
                QLog.d(AndroidPermissionHandler.TAG, 1, "onAccountChanged closeToast");
                AndroidPermissionHandler.this.closeToast();
            }
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason logoutReason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) logoutReason);
            } else {
                QLog.d(AndroidPermissionHandler.TAG, 1, "onLogout closeToast");
                AndroidPermissionHandler.this.closeToast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements QQPermissionCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AndroidPermissionHandler.this);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        @RequiresApi(api = 23)
        public void deny(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), strArr, iArr);
            } else {
                AndroidPermissionHandler.this.onRequestPermissionResult(i3, strArr, iArr);
            }
        }

        @Override // mqq.app.QQPermissionCallback
        @RequiresApi(api = 23)
        public void grant(int i3, String[] strArr, int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), strArr, iArr);
                return;
            }
            if (iArr == null) {
                iArr = new int[strArr.length];
                for (int i16 = 0; i16 < strArr.length; i16++) {
                    iArr[i16] = 0;
                }
            }
            AndroidPermissionHandler.this.onRequestPermissionResult(i3, strArr, iArr);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            requestCode = new AtomicInteger(1000);
        }
    }

    public AndroidPermissionHandler(QQPermission qQPermission) {
        super(qQPermission);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQPermission);
            return;
        }
        this.grantedPermissions = new ArrayList();
        this.callback = new a();
        this.mRequestingCallbacks = new SparseArray<>(4);
    }

    @RequiresApi(api = 23)
    private int checkSelfPermission(String str) {
        return this.mContext.checkSelfPermission(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeToast() {
        QQCustomDialog qQCustomDialog = this.sCustomDialog;
        if (qQCustomDialog != null) {
            if (qQCustomDialog.isShowing()) {
                this.sCustomDialog.cancel();
            }
            this.sCustomDialog = null;
        }
        unregisterAccountCallBack();
    }

    private QQPermissionCallback getAppPermissionCallback() {
        if (this.mAppPermissionCallback == null) {
            this.mAppPermissionCallback = new b();
        }
        return this.mAppPermissionCallback;
    }

    private boolean getMultiScenePermission(List<String> list) {
        String permissionGroup = getPermissionGroup(list);
        if (TextUtils.isEmpty(permissionGroup)) {
            QLog.e(TAG, 1, "getMultiScenePermission. permissionGroup is empty");
            return true;
        }
        String str = QQPermissionConstants.BUSINESS_MODULE_MAP.get(this.mQQPermission.getBusinessConfig().getBusinessId());
        if (str == null) {
            return true;
        }
        return com.tencent.mobileqq.qqpermission.multiscene.a.d(this.mContext, str, permissionGroup);
    }

    private String getPermissionGroup(List<String> list) {
        if (this.mContext == null) {
            return null;
        }
        Iterator<String> it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            String permissionGroupName = PermissionUtil.getPermissionGroupName(this.mContext.getPackageManager(), it.next());
            if (TextUtils.isEmpty(str)) {
                str = permissionGroupName;
            } else if (!permissionGroupName.equals(str)) {
                QLog.e(TAG, 1, "both request two permissionGroup. " + permissionGroupName + ", " + str);
            }
        }
        return str;
    }

    private IPermissionRequester getPermissionRequester() {
        ComponentCallbacks2 componentCallbacks2 = this.mActivity;
        if (componentCallbacks2 instanceof IPermissionRequester) {
            return (IPermissionRequester) componentCallbacks2;
        }
        Fragment fragment = this.mFragment;
        if (fragment != null && (fragment.getActivity() instanceof IPermissionRequester)) {
            return (IPermissionRequester) this.mFragment.getActivity();
        }
        ActivityResultCaller activityResultCaller = this.mFragment;
        if (activityResultCaller instanceof IPermissionRequester) {
            return (IPermissionRequester) activityResultCaller;
        }
        return null;
    }

    private static boolean hasFinalLocationPermission(String[] strArr) {
        for (String str : strArr) {
            if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                return true;
            }
        }
        return false;
    }

    private void registerAccountCallBack() {
        QLog.d(TAG, 1, "registerAccountCallBack");
        MobileQQ.sMobileQQ.registerAccountCallback(this.callback);
    }

    @RequiresApi(api = 23)
    private void requestSysPermissions(@NonNull String[] strArr, int i3) {
        Activity activity = this.mActivity;
        if (activity == null) {
            Fragment fragment = this.mFragment;
            if (fragment != null) {
                activity = fragment.getActivity();
            } else {
                activity = null;
            }
        }
        if (activity != null) {
            String str = strArr[0];
            if (hasFinalLocationPermission(strArr)) {
                str = "android.permission.ACCESS_FINE_LOCATION";
            }
            this.sCustomDialog = (QQCustomDialog) PermissionDialogUtil.show(activity, this.mQQPermission.getBusinessConfig(), str);
            registerAccountCallBack();
        }
        try {
            IPermissionRequester permissionRequester = getPermissionRequester();
            if (permissionRequester != null) {
                QPLog.i(TAG, "requestSysPermissions: use IPermissionRequester api.");
                permissionRequester.requestPermissions(getAppPermissionCallback(), i3, strArr);
                return;
            }
            Activity activity2 = this.mActivity;
            if (activity2 != null) {
                PermissionMonitor.requestPermissions(activity2, strArr, i3);
                return;
            }
            Fragment fragment2 = this.mFragment;
            if (fragment2 != null) {
                if (fragment2.getActivity() != null && this.mFragment.isAdded()) {
                    this.mFragment.requestPermissions(strArr, i3);
                    return;
                }
                QPLog.e(TAG, "requestSysPermissions: fragment is not attached.");
            }
        } catch (ActivityNotFoundException e16) {
            QPLog.e(TAG, "requestSysPermissions: ActivityNotFoundException", e16);
        }
    }

    private void setMultiScenePermissionAuth(List<String> list) {
        String permissionGroup = getPermissionGroup(list);
        if (TextUtils.isEmpty(permissionGroup)) {
            QLog.e(TAG, 1, "getMultiScenePermission. permissionGroup is empty");
            return;
        }
        com.tencent.mobileqq.qqpermission.multiscene.a.e(this.mContext, QQPermissionConstants.BUSINESS_MODULE_MAP.get(this.mQQPermission.getBusinessConfig().getBusinessId()), permissionGroup, true);
    }

    @RequiresApi(api = 23)
    private boolean shouldShowRequestPermissionRationale(String str) {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    private void unregisterAccountCallBack() {
        QLog.d(TAG, 1, "unregisterAccountCallBack");
        MobileQQ.sMobileQQ.unregisterAccountCallback(this.callback);
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public boolean canHandle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public int checkPermission(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? checkSelfPermission(str) == 0 ? 0 : -1 : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
    }

    @RequiresApi(api = 23)
    public void doRequestPermission(List<String> list, AndroidPermissionCallback androidPermissionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            androidPermissionCallback.clearBeforeShouldRationale();
            for (String str : list) {
                androidPermissionCallback.putBeforeNeedRationale(str, shouldShowRequestPermissionRationale(str));
            }
            QPLog.i(TAG, "doRequestPermission: permission=" + list + ", shouldShowRequestPermissionRationale=" + androidPermissionCallback.mBeforeNeedRationales + ", requestCode=" + requestCode + ", size=" + this.mRequestingCallbacks.size());
            int andIncrement = requestCode.getAndIncrement();
            this.mRequestingCallbacks.put(andIncrement, androidPermissionCallback);
            requestSysPermissions((String[]) list.toArray(new String[0]), andIncrement);
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) list, (Object) androidPermissionCallback);
    }

    @RequiresApi(api = 23)
    public void onRequestPermissionResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), strArr, iArr);
            return;
        }
        QPLog.i(TAG, "onRequestPermissionResult: " + i3 + ", permissions: " + Arrays.toString(strArr) + ", result: " + Arrays.toString(iArr));
        AndroidPermissionCallback androidPermissionCallback = this.mRequestingCallbacks.get(i3);
        this.mRequestingCallbacks.delete(i3);
        if (androidPermissionCallback != null && strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean z16 = true;
            for (int i16 = 0; i16 < strArr.length; i16++) {
                arrayList.add(strArr[i16]);
                if (iArr[i16] == 0) {
                    arrayList2.add(0);
                } else {
                    boolean shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale(strArr[i16]);
                    boolean beforeNeedRationale = androidPermissionCallback.getBeforeNeedRationale(strArr[i16]);
                    if (shouldShowRequestPermissionRationale) {
                        arrayList2.add(1);
                    } else if (beforeNeedRationale) {
                        arrayList2.add(2);
                    } else {
                        arrayList2.add(3);
                    }
                    z16 = false;
                }
            }
            if (androidPermissionCallback.mPermissionHandler.grantedPermissions.size() != 0) {
                for (String str : androidPermissionCallback.mPermissionHandler.grantedPermissions) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                        arrayList2.add(0);
                        QPLog.e(TAG, "beforeGrantedPermission add: " + str);
                    }
                }
            }
            if (z16) {
                setMultiScenePermissionAuth(arrayList);
                androidPermissionCallback.onGranted();
                return;
            } else {
                androidPermissionCallback.onDenied(arrayList, arrayList2);
                return;
            }
        }
        QPLog.e(TAG, "onRequestPermissionResult: callback=" + androidPermissionCallback);
    }

    public void requestAndroidPermissions(List<String> list, AndroidPermissionCallback androidPermissionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list, (Object) androidPermissionCallback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.grantedPermissions.clear();
        for (String str : list) {
            if (checkSelfPermission(str) == -1) {
                arrayList.add(str);
            } else {
                this.grantedPermissions.add(str);
            }
        }
        if (arrayList.size() == 0) {
            if (getMultiScenePermission(this.grantedPermissions)) {
                androidPermissionCallback.onGranted();
                return;
            }
            com.tencent.mobileqq.qqpermission.multiscene.a.f(this.mContext, QQPermissionConstants.BUSINESS_MODULE_MAP.get(this.mQQPermission.getBusinessConfig().getBusinessId()), getPermissionGroup(this.grantedPermissions), androidPermissionCallback.mListener);
            return;
        }
        for (String str2 : arrayList) {
            if (shouldShowRequestPermissionRationale(str2)) {
                androidPermissionCallback.onNeedRationale(arrayList, str2);
                return;
            }
        }
        doRequestPermission(arrayList, androidPermissionCallback);
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public void requestPermissions(List<String> list, int i3, QQPermission.BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, Integer.valueOf(i3), basePermissionsListener);
        } else if (i3 == 2) {
            requestAndroidPermissions(list, new DialogPermissionCallback(this, this.mContext, basePermissionsListener));
        } else if (i3 == 1) {
            requestAndroidPermissions(list, new ViewPermissionCallback(this, this.mContext, basePermissionsListener));
        }
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public int checkPermission(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        int checkPermission = checkPermission(str2);
        if (checkPermission == -1) {
            QLog.e(TAG, 1, "hasPermission SystemPermission is denied. result:" + checkPermission);
            return checkPermission;
        }
        Context context = this.mContext;
        if (context == null) {
            QLog.e(TAG, 1, "hasPermission mContext is null. result:" + checkPermission);
            return checkPermission;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            QLog.e(TAG, 1, "hasPermission pm is null. result:" + checkPermission);
            return checkPermission;
        }
        String permissionGroupName = PermissionUtil.getPermissionGroupName(packageManager, str2);
        if (permissionGroupName == null) {
            QLog.e(TAG, 1, "hasPermission permissionGroup is null. result:" + checkPermission);
            return checkPermission;
        }
        Map<String, String> map = QQPermissionConstants.BUSINESS_MODULE_MAP;
        if (!map.containsKey(str)) {
            QLog.e(TAG, 1, "hasPermission not find moduleId. result:" + checkPermission);
            return checkPermission;
        }
        String str3 = map.get(str);
        int i3 = 1 ^ (com.tencent.mobileqq.qqpermission.multiscene.a.d(this.mContext, str3, permissionGroupName) ? 1 : 0);
        QPLog.i(TAG, "requestPermission: businessId: " + str + " moduleId: " + str3 + " permission: " + str2 + " permissionGroup: " + permissionGroupName + " result: " + i3);
        return i3;
    }
}
