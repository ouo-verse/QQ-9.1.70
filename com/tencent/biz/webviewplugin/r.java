package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarIpcUpdateAvatarUtilsApiImpl;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.MX3DynamicAvatarRecordActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.phonecontact.data.PhoneInfo;
import com.tencent.mobileqq.phonecontact.data.RecommendedListResp;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import eipc.EIPCResult;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import na1.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r extends WebViewPlugin {
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private Uri f97600d;

    /* renamed from: e, reason: collision with root package name */
    private QQProgressDialog f97601e;

    /* renamed from: f, reason: collision with root package name */
    private int f97602f;

    /* renamed from: h, reason: collision with root package name */
    private int f97603h;

    /* renamed from: i, reason: collision with root package name */
    private int f97604i;

    /* renamed from: m, reason: collision with root package name */
    private int f97605m;
    private com.tencent.mobileqq.emosm.t C = new a();
    private BroadcastReceiver E = new b();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d("NewerGuidePlugin", 2, String.format("mAvatarReceiver.onReceive action=%s", action));
            }
            if ("ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT".equals(action)) {
                String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                boolean booleanExtra = intent.getBooleanExtra(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, false);
                String stringExtra2 = intent.getStringExtra("PhotoConst.SOURCE_FROM");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NewerGuidePlugin", 2, String.format("mAvatarReceiver.onReceive path=%s syncQZone=%s sourceFrom=%s", stringExtra, Boolean.valueOf(booleanExtra), stringExtra2));
                }
                Bundle bundle = new Bundle();
                bundle.putString("key_action", QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR);
                bundle.putString("path", stringExtra);
                bundle.putBoolean(QQAvatarIpcUpdateAvatarUtilsApiImpl.PHOTO_SYNCQZONE, booleanExtra);
                bundle.putString("PhotoConst.SOURCE_FROM", stringExtra2);
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, r.this.C.key, bundle));
                if (r.this.f97601e == null) {
                    Activity a16 = r.this.mRuntime.a();
                    r.this.f97601e = new QQProgressDialog(a16, a16.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    r.this.f97601e.setMessage(HardCodeUtil.qqStr(R.string.onc));
                }
                r.this.f97601e.show();
                return;
            }
            if ("ACTION_NEWER_GUIDE_CMSHOW_AVATAR_RESULT".equals(action)) {
                r.this.N(true, intent.getStringExtra("path"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            r.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements IphonePickerView.PickerViewAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f97613a;

        e(String[] strArr) {
            this.f97613a = strArr;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            return 1;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            return this.f97613a.length;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            return this.f97613a[i16];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements IphonePickerView.IphonePickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActionSheet f97615a;

        f(ActionSheet actionSheet) {
            this.f97615a = actionSheet;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            if (QLog.isColorLevel()) {
                QLog.d("NewerGuidePlugin", 2, String.format("onConfirmBtClicked mSelectedIndex=%s", Integer.valueOf(r.this.f97602f)));
            }
            ActionSheet actionSheet = this.f97615a;
            if (actionSheet != null && actionSheet.isShowing()) {
                this.f97615a.dismiss();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", 1);
                jSONObject.put("index", r.this.f97602f);
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "sendSelectorResp fail", e16);
            }
            r.this.callJs("respSelector", jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            r.this.f97602f = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f97620a;

        h(JSONObject jSONObject) {
            this.f97620a = jSONObject;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            try {
                r.this.S(this.f97620a);
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "grandReadContacts fail.", e16);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", 0);
                r.this.callJs("respUploadContacts", jSONObject.toString());
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "deniedReadContacts fail.", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f97622a;

        i(JSONObject jSONObject) {
            this.f97622a = jSONObject;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            try {
                r.this.F(this.f97622a);
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "grandReadContacts fail.", e16);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            try {
                r.this.callJs("respRecommend", new JSONObject().toString());
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "deniedReadContacts fail.", e16);
            }
        }
    }

    public r() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "NewerGuidePlugin this=" + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(JSONObject jSONObject) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("getRecommended args=%s", jSONObject));
        }
        int parseInt = Integer.parseInt(jSONObject.getString("wantCount"));
        Bundle bundle = new Bundle();
        bundle.putString("key_action", "getRecommendedList");
        bundle.putInt("wantCount", parseInt);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, this.C.key, bundle));
    }

    private void G(JSONObject jSONObject) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("getRecommendedNew args=%s", jSONObject));
        }
        long parseLong = Long.parseLong(jSONObject.getString("uin"));
        int parseInt = Integer.parseInt(jSONObject.getString("startIndex"));
        int parseInt2 = Integer.parseInt(jSONObject.getString(WidgetCacheConstellationData.NUM));
        String string = jSONObject.getString("callback");
        Bundle bundle = new Bundle();
        bundle.putString("key_action", "getRecommendedListNew");
        bundle.putLong("uin", parseLong);
        bundle.putInt("startIndex", parseInt);
        bundle.putInt(WidgetCacheConstellationData.NUM, parseInt2);
        bundle.putString("callback", string);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, this.C.key, bundle));
    }

    public static JSONObject H(String str) {
        try {
            return new JSONObject(((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getSharedPreferences("upload_for_new_guide", str, 4).getString("upload_for_new_guide", ""));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private void I(JSONObject jSONObject) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "handleGetRecommended");
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_NEW_GUIDE, QQPermissionConstants.Business.SCENE.NEW_GUIDE_GET_RECOMMEND));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_CONTACTS) == 0) {
            try {
                F(jSONObject);
                return;
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "grandReadContacts fail.", e16);
                return;
            }
        }
        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_CONTACTS}, 2, new i(jSONObject));
    }

    private void J(JSONObject jSONObject) throws JSONException {
        String str;
        int parseInt = Integer.parseInt(jSONObject.getString("type"));
        try {
            str = jSONObject.getString("uin");
        } catch (Exception unused) {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("handleJumpCard type=%s uin=%s", Integer.valueOf(parseInt), str));
        }
        if (parseInt == 5 || !TextUtils.isEmpty(str)) {
            if (parseInt == 1) {
                EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CommonModule", "getPhoneBindState", null);
                if (callServer.isSuccess()) {
                    AllInOne allInOne = new AllInOne(str, callServer.data.getInt("selfBindState") <= 5 ? 29 : 34);
                    allInOne.profileEntryType = 100;
                    Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.a(), allInOne);
                    profileCardIntentOnly.putExtra("from_newer_guide", true);
                    startActivityForResult(profileCardIntentOnly, (byte) 1);
                    return;
                }
                return;
            }
            if (parseInt == 2) {
                Intent intent = new Intent(this.mRuntime.a(), (Class<?>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetailActivity.class));
                intent.putExtra("uin", str);
                intent.putExtra("from_newer_guide", true);
                this.mRuntime.a().overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
                startActivityForResult(intent, (byte) parseInt);
                return;
            }
            if (parseInt == 3) {
                Bundle b16 = aq.b(String.valueOf(str), 35);
                b16.putString("authSig", jSONObject.optString("authSig"));
                b16.putBoolean("from_newer_guide", true);
                TroopUtils.J(this.mRuntime.a(), b16, 2, 3);
                return;
            }
            if (parseInt != 4) {
                if (parseInt != 5) {
                    return;
                }
                AllInOne allInOne2 = new AllInOne(this.mRuntime.b().getCurrentAccountUin(), 0);
                allInOne2.nickname = this.mRuntime.b().getCurrentNickname();
                allInOne2.profileEntryType = 100;
                Intent profileCardIntentOnly2 = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.a(), allInOne2);
                profileCardIntentOnly2.putExtra("from_newer_guide", true);
                this.mRuntime.a().startActivity(profileCardIntentOnly2);
                return;
            }
            long parseLong = Long.parseLong(str);
            AllInOne allInOne3 = new AllInOne("0", 41);
            allInOne3.profileEntryType = 100;
            Intent intent2 = new Intent(this.mRuntime.a(), (Class<?>) u92.f.class);
            intent2.putExtra("param_mode", 3);
            intent2.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne3);
            intent2.putExtra("param_tiny_id", parseLong);
            intent2.putExtra("from_newer_guide", true);
            startActivityForResult(intent2, (byte) parseInt);
        }
    }

    private void K() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission((QBaseActivity) this.mRuntime.a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_NEW_GUIDE, QQPermissionConstants.Business.SCENE.NEW_GUIDE_SET_AVATAR));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            Q();
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new c());
        }
    }

    private void L(JSONObject jSONObject) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "handleUploadContacts");
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this.mRuntime.a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_NEW_GUIDE, QQPermissionConstants.Business.SCENE.NEW_GUIDE_GET_UP_LOAD_CONTACTS));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_CONTACTS) == 0) {
            try {
                S(jSONObject);
                return;
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "grandReadContacts fail.", e16);
                return;
            }
        }
        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_CONTACTS}, 2, new h(jSONObject));
    }

    private void M() {
        if (this.D) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "registerAvatarReceiver");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
        intentFilter.addAction("ACTION_NEWER_GUIDE_CMSHOW_AVATAR_RESULT");
        this.mRuntime.a().registerReceiver(this.E, intentFilter);
        this.D = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007c, code lost:
    
        if (r6 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0095, code lost:
    
        callJs("respSetAvatar", r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0092, code lost:
    
        if (r6 == null) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N(boolean z16, String str) {
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("sendSetAvatarResp succeed=%s path=%s", Boolean.valueOf(z16), str));
        }
        JSONObject jSONObject = new JSONObject();
        FileInputStream fileInputStream = null;
        try {
            jSONObject.put("result", z16 ? 1 : 0);
            if (z16 && !TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    byte[] bArr = new byte[(int) file.length()];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream2);
                    } catch (Exception e16) {
                        e = e16;
                        bufferedInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                    }
                    try {
                        if (bufferedInputStream.read(bArr) > 0) {
                            jSONObject.put("url", PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 0));
                        }
                        file.delete();
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = fileInputStream2;
                        try {
                            QLog.e("NewerGuidePlugin", 1, "sendSetAvatarResp fail", e);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (bufferedInputStream == null) {
                                try {
                                    bufferedInputStream.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (bufferedInputStream == null) {
                        }
                    }
                }
            }
            bufferedInputStream = null;
            if (fileInputStream != null) {
            }
        } catch (Exception e18) {
            e = e18;
            bufferedInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            bufferedInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        Activity a16 = this.mRuntime.a();
        String[] stringArray = a16.getResources().getStringArray(R.array.f155206av);
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(a16, null);
        ArrayList arrayList = new ArrayList();
        a.b a17 = DynamicAvatarConfProcessor.INSTANCE.a().a();
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "showSetAvatar config.isSupportDynamicAvatar(): " + a17.getIsSupportDynamicAvatar());
        }
        if (isNewerGuideCmShowAvatarEntranceShow()) {
            actionSheet.addButton(getNewerGuideCmShowAvatarEntranceName());
            arrayList.add(33);
            ((IApolloDtReportHelper) QRoute.api(IApolloDtReportHelper.class)).report("set_profile", "photo_settings", "expo", null);
        }
        if (a17.getIsSupportDynamicAvatar()) {
            actionSheet.addButton(stringArray[22]);
            arrayList.add(22);
        }
        actionSheet.addButton(stringArray[24]);
        arrayList.add(24);
        actionSheet.addButton(stringArray[13]);
        arrayList.add(13);
        actionSheet.addCancelButton(stringArray[16]);
        actionSheet.setOnButtonClickListener(new d(arrayList, actionSheet, a16));
        if (a16.isFinishing()) {
            return;
        }
        try {
            actionSheet.show();
        } catch (Exception unused) {
        }
    }

    private void R() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "unregisterAvatarReceiver");
        }
        this.mRuntime.a().unregisterReceiver(this.E);
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(JSONObject jSONObject) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("uploadContacts args=%s", jSONObject));
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_action", "uploadContacts");
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, this.C.key, bundle));
    }

    public static String getNewerGuideCmShowAvatarEntranceName() {
        return ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getNewerGuideCmShowAvatarEntranceName();
    }

    public static String getNewerGuideZplanCmShowAvatarEntranceLink() {
        return ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getNewerGuideZplanCmShowAvatarEntranceLink();
    }

    public static boolean isNewerGuideCmShowAvatarEntranceShow() {
        return ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).isNewerGuideCmShowAvatarEntranceShow();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("callJs func=%s", str));
        }
        super.callJs(str, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "newerguide";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("onActivityResult requestCode=%s resultCode=%s intent=%s", Byte.valueOf(b16), Integer.valueOf(i3), intent));
        }
        try {
            if (b16 == 100) {
                if (i3 != -1 || intent == null) {
                    return;
                }
                N(true, intent.getStringExtra("key_photo_file_path"));
                return;
            }
            if (b16 == 101) {
                if (i3 == -1) {
                    Activity a16 = this.mRuntime.a();
                    String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(a16, this.f97600d);
                    String uploadAvatarTempPath = FaceUtil.getUploadAvatarTempPath();
                    int x16 = ProfileCardUtil.x(a16);
                    Intent intent2 = new Intent();
                    intent2.setClass(a16, PhotoCropForPortraitActivity.class);
                    intent2.putExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME, "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
                    intent2.putExtra("Business_Origin", 100);
                    intent2.putExtra("BUSINESS_ORIGIN_NEW", 100);
                    intent2.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
                    intent2.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
                    intent2.putExtra("PhotoConst.SINGLE_PHOTO_PATH", realPathFromContentURI);
                    intent2.putExtra(PeakConstants.TARGET_PATH, uploadAvatarTempPath);
                    intent2.putExtra(PeakConstants.CLIP_WIDTH, x16);
                    intent2.putExtra(PeakConstants.CLIP_HEIGHT, x16);
                    intent2.putExtra(PeakConstants.TARGET_WIDTH, 1080);
                    intent2.putExtra(PeakConstants.TARGET_HEIGHT, 1080);
                    a16.startActivity(intent2);
                    return;
                }
                return;
            }
            if (i3 == -1 && intent != null) {
                JSONObject jSONObject = new JSONObject();
                int i16 = intent.getBooleanExtra("has_operation", false) ? 1 : 0;
                String stringExtra = intent.getStringExtra("uin");
                jSONObject.put("result", i16);
                jSONObject.put("uin", stringExtra);
                switch (b16) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        str = "respCard";
                        jSONObject.put("type", (int) b16);
                        break;
                    case 6:
                        str = "respTroop";
                        break;
                    case 7:
                        str = "respFriend";
                        break;
                    case 8:
                        str = "respSayHi";
                        break;
                    default:
                        str = null;
                        break;
                }
                if (str != null) {
                    callJs(str, jSONObject.toString());
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NewerGuidePlugin", 1, "onActivityResult no result");
            }
        } catch (Exception e16) {
            QLog.e("NewerGuidePlugin", 1, "onActivityResult fail, requestCode=" + ((int) b16), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "onCreate this=" + this);
        }
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.C);
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, "onDestroy this=" + this);
        }
        super.onDestroy();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.C);
        R();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f97609d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f97610e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f97611f;

        d(ArrayList arrayList, ActionSheet actionSheet, Activity activity) {
            this.f97609d = arrayList;
            this.f97610e = actionSheet;
            this.f97611f = activity;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            Class cls;
            if (i3 >= 0 && i3 < this.f97609d.size()) {
                int intValue = ((Integer) this.f97609d.get(i3)).intValue();
                if (intValue != 13) {
                    if (intValue == 22) {
                        if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68989c)) {
                            cls = MX3DynamicAvatarRecordActivity.class;
                        } else {
                            cls = DynamicAvatarRecordActivity.class;
                        }
                        Intent intent = new Intent(this.f97611f, (Class<?>) cls);
                        intent.putExtra("param_source", 1);
                        intent.putExtra("param_from_newer_guide", true);
                        r.this.startActivityForResult(intent, (byte) 100);
                    } else if (intValue == 24) {
                        String uploadAvatarTempPath = FaceUtil.getUploadAvatarTempPath();
                        int x16 = ProfileCardUtil.x(this.f97611f);
                        Intent intent2 = new Intent();
                        intent2.setClassName("com.tencent.mobileqq", IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_CLASS_NAME);
                        intent2.putExtra(IPhotoLogicFactory.ENTER_FROM, 50);
                        intent2.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationCrop.F);
                        intent2.putExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME, "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
                        intent2.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
                        intent2.putExtra("Business_Origin", 100);
                        intent2.putExtra("BUSINESS_ORIGIN_NEW", 100);
                        intent2.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
                        intent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
                        intent2.putExtra("PhotoConst.IS_SINGLE_MODE", true);
                        intent2.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
                        intent2.putExtra(PeakConstants.TARGET_PATH, uploadAvatarTempPath);
                        intent2.putExtra(PeakConstants.CLIP_WIDTH, x16);
                        intent2.putExtra(PeakConstants.CLIP_HEIGHT, x16);
                        intent2.putExtra(PeakConstants.TARGET_WIDTH, 1080);
                        intent2.putExtra(PeakConstants.TARGET_HEIGHT, 1080);
                        intent2.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
                        intent2.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
                        this.f97611f.startActivity(intent2);
                    } else if (intValue == 33) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("url", r.getNewerGuideZplanCmShowAvatarEntranceLink());
                        RouteUtils.startActivity(this.f97611f, intent3, RouterConstants.UI_ROUTE_BROWSER);
                        ((IApolloDtReportHelper) QRoute.api(IApolloDtReportHelper.class)).report("set_profile", "photo_settings", "click", null);
                    }
                } else if (!QavCameraUsage.a(BaseApplication.getContext())) {
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "photo/");
                    File file = new File(sDKPrivatePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(sDKPrivatePath + System.currentTimeMillis() + ".jpg");
                    Intent intent4 = new Intent();
                    r.this.f97600d = FileProvider7Helper.setSystemCapture(this.f97611f, file2, intent4);
                    r.this.startActivityForResult(intent4, (byte) 101);
                }
                try {
                    this.f97610e.dismiss();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            this.f97610e.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends com.tencent.mobileqq.emosm.t {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x02d5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.emosm.t
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Bundle bundle) {
            Bundle bundle2;
            String string;
            String str;
            String str2;
            if (bundle == null || bundle.getInt("respkey", 0) != r.this.C.key || !"ipc_newer_guide".equals(bundle.getString("cmd"))) {
                return;
            }
            try {
                bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                bundle2.setClassLoader(RecommendedListResp.class.getClassLoader());
                string = bundle2.getString("key_action");
                if (QLog.isColorLevel()) {
                    QLog.d("NewerGuidePlugin", 2, "onResponse action=" + string);
                }
                str = null;
            } catch (Exception e16) {
                QLog.d("NewerGuidePlugin", 1, "mOnRemoteResp fail", e16);
                return;
            }
            if ("uploadContacts".equals(string)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", bundle2.getInt("result"));
                r.this.callJs("respUploadContacts", jSONObject.toString());
            } else if ("getRecommendedList".equals(string)) {
                JSONObject jSONObject2 = new JSONObject();
                String string2 = bundle2.getString("op_result");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject2.put("result", new JSONArray(string2));
                }
                r.this.callJs("respRecommend", jSONObject2.toString());
            } else if ("getRecommendedListNew".equals(string)) {
                RecommendedListResp recommendedListResp = (RecommendedListResp) bundle2.getParcelable("result");
                int i3 = recommendedListResp == null ? -1 : recommendedListResp.f258452d;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", i3);
                if (i3 == 0) {
                    jSONObject3.put("uint32_end", recommendedListResp.f258453e);
                    jSONObject3.put("uint32_next_index", recommendedListResp.f258454f);
                    List<PhoneInfo> list = recommendedListResp.f258455h;
                    if (list != null && !list.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (PhoneInfo phoneInfo : list) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("str_phone", phoneInfo.f258442d);
                            jSONObject4.put("str_nick", phoneInfo.f258443e);
                            jSONObject4.put("str_long_nick", phoneInfo.f258444f);
                            jSONObject4.put("str_head_url", phoneInfo.f258445h);
                            jSONArray.mo162put(jSONObject4);
                        }
                        jSONObject3.put("phoneAddrBook", jSONArray);
                    }
                }
                r.this.callJs(bundle2.getString("callback"), jSONObject3.toString());
            } else {
                if ("sayHi".equals(string)) {
                    String string3 = bundle2.getString("uin");
                    byte[] byteArray = bundle2.getByteArray(PreloadTRTCPlayerParams.KEY_SIG);
                    String string4 = bundle2.getString("nick");
                    String string5 = bundle2.getString("tinyId");
                    if (!TextUtils.isEmpty(string3) && byteArray != null && !TextUtils.isEmpty(string4)) {
                        Intent intent = new Intent(r.this.mRuntime.a(), (Class<?>) ChatActivity.class);
                        intent.addFlags(67108864);
                        intent.putExtra("uin", string3);
                        intent.putExtra("uintype", 1001);
                        intent.putExtra("aio_msg_source", 999);
                        intent.putExtra(AppConstants.Key.KYE_RICH_ACCOST_SIG, byteArray);
                        intent.putExtra("uinname", string4);
                        intent.putExtra("from_newer_guide", true);
                        intent.putExtra("tinyId", string5);
                        r.this.startActivityForResult(intent, (byte) 8);
                    } else {
                        str = String.valueOf(string5);
                        str2 = "respSayHi";
                        if (str == null || str2 == null) {
                            return;
                        }
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("uin", str);
                        jSONObject5.put("result", 0);
                        r.this.callJs(str2, jSONObject5.toString());
                        return;
                    }
                } else if ("joinTroop".equals(string)) {
                    String string6 = bundle2.getString("uin");
                    String string7 = bundle2.getString("name");
                    short s16 = bundle2.getShort("option");
                    String string8 = bundle2.getString("question");
                    String string9 = bundle2.getString("answer");
                    String string10 = bundle2.getString("authSig");
                    if (s16 != 0) {
                        Intent n3 = AddFriendLogicActivity.n3(r.this.mRuntime.a(), string6, string7, s16, 1, string8, string9, null, null, string10);
                        n3.putExtra("from_newer_guide", true);
                        r.this.startActivityForResult(n3, (byte) 6);
                    } else {
                        str2 = "respTroop";
                        str = string6;
                        if (str == null) {
                            return;
                        } else {
                            return;
                        }
                    }
                } else if ("joinTroopByTap".equals(string)) {
                    int i16 = bundle2.getInt("result");
                    String string11 = bundle2.getString("uin");
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("uin", string11);
                    jSONObject6.put("result", i16);
                    r.this.callJs("respTroopByTap", jSONObject6.toString());
                } else if ("followPublicAccount".equals(string)) {
                    int i17 = bundle2.getInt("result");
                    String string12 = bundle2.getString("uin");
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("uin", string12);
                    jSONObject7.put("result", i17);
                    r.this.callJs("respFollow", jSONObject7.toString());
                } else if (QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR.equals(string)) {
                    if (bundle2.getInt("result") == 1) {
                        r.this.N(true, bundle2.getString("path"));
                    } else {
                        Activity a16 = r.this.mRuntime.a();
                        QQToast.makeText(a16, 1, HardCodeUtil.qqStr(R.string.on7), 0).show(a16.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                    if (r.this.f97601e != null) {
                        r.this.f97601e.dismiss();
                    }
                }
                QLog.d("NewerGuidePlugin", 1, "mOnRemoteResp fail", e16);
                return;
            }
            str2 = null;
            if (str == null) {
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }
    }

    private void P(String[] strArr, int i3) {
        if (strArr != null && strArr.length != 0) {
            if (i3 < 0 || i3 >= strArr.length) {
                i3 = 0;
            }
            Activity a16 = this.mRuntime.a();
            IphonePickerView iphonePickerView = (IphonePickerView) a16.getLayoutInflater().inflate(R.layout.avo, (ViewGroup) null);
            iphonePickerView.initialize(new e(strArr));
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(a16);
            createMenuSheet.setCloseAutoRead(true);
            createMenuSheet.setActionContentView(iphonePickerView, null);
            DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) createMenuSheet.findViewById(R.id.f163936cz);
            dispatchActionMoveScrollView.dispatchActionMove = true;
            dispatchActionMoveScrollView.setBackgroundResource(17170445);
            Window window = createMenuSheet.getWindow();
            if (window != null) {
                window.setFlags(16777216, 16777216);
            }
            iphonePickerView.setPickListener(new f(createMenuSheet));
            this.f97602f = i3;
            iphonePickerView.setSelection(0, i3);
            try {
                createMenuSheet.show();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        QLog.d("NewerGuidePlugin", 1, "showSelector invalid params");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuidePlugin", 2, String.format("handleJsRequest pkgName=%s method=%s url=%s args=%s", str2, str3, str, Arrays.toString(strArr)));
        }
        if (!"newerguide".equals(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (str3.equals("uploadContacts")) {
                L(jSONObject);
            } else if (str3.equals("getRecommendedList")) {
                I(jSONObject);
            } else if (str3.equals("getRecommendedListNew")) {
                G(jSONObject);
            } else if (str3.equals("skipGuide")) {
                Intent aliasIntent = SplashActivity.getAliasIntent(this.mRuntime.a());
                aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 1);
                aliasIntent.setFlags(603979776);
                this.mRuntime.a().startActivity(aliasIntent);
            } else {
                String[] strArr2 = null;
                if (str3.equals(QQFriendJsPlugin.API_ADD_FRIEND)) {
                    EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "CommonModule", "getPhoneBindState", null);
                    if (callServer.isSuccess()) {
                        if (callServer.data.getInt("selfBindState") <= 5) {
                            i19 = 3075;
                            i26 = 3;
                        } else {
                            i19 = 3006;
                            i26 = 11;
                        }
                        String string = jSONObject.getString("uin");
                        String string2 = jSONObject.getString("name");
                        WebViewPlugin.b bVar = this.mRuntime;
                        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
                        int switchRequestCode = d16 instanceof com.tencent.mobileqq.webview.swift.af ? ((com.tencent.mobileqq.webview.swift.af) d16).switchRequestCode(this, (byte) 7) : 7;
                        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.mRuntime.a(), 2, string, null, i19, i26, string2, null, null, null, null);
                        startAddFriend.putExtra("from_newer_guide", true);
                        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.mRuntime.a(), startAddFriend, switchRequestCode);
                    }
                } else if (str3.equals("followPublicAccount")) {
                    String string3 = jSONObject.getString("uin");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_action", "followPublicAccount");
                    bundle.putString("uin", string3);
                    ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, this.C.key, bundle));
                } else if (str3.equals("joinTroop")) {
                    String string4 = jSONObject.getString("uin");
                    String string5 = jSONObject.getString("name");
                    String optString = jSONObject.optString("authSig");
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key_action", "joinTroop");
                    bundle2.putString("uin", string4);
                    bundle2.putString("name", string5);
                    bundle2.putString("authSig", optString);
                    ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, this.C.key, bundle2));
                } else if (str3.equals("joinTroopByTap")) {
                    String string6 = jSONObject.getString("uin");
                    String string7 = jSONObject.getString("name");
                    String optString2 = jSONObject.optString("authSig");
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("key_action", "joinTroopByTap");
                    bundle3.putString("uin", string6);
                    bundle3.putString("name", string7);
                    bundle3.putString("authSig", optString2);
                    ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, this.C.key, bundle3));
                } else if (str3.equals("sayHi")) {
                    long parseLong = Long.parseLong(jSONObject.getString("uin"));
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("key_action", "sayHi");
                    bundle4.putLong("tinyId", parseLong);
                    ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_newer_guide", null, this.C.key, bundle4));
                } else if (str3.equals("jumpCard")) {
                    J(jSONObject);
                } else if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR)) {
                    K();
                } else if (str3.equals("selector")) {
                    int i27 = jSONObject.getInt("index");
                    JSONArray jSONArray = jSONObject.getJSONArray("options");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        strArr2 = new String[length];
                        for (int i28 = 0; i28 < length; i28++) {
                            strArr2[i28] = jSONArray.getString(i28);
                        }
                    }
                    P(strArr2, i27);
                } else if (str3.equals("datePicker")) {
                    O(jSONObject.getInt("year"), jSONObject.getInt("month"), jSONObject.getInt("date"));
                } else if (str3.equals("queryUploadProgress")) {
                    String string8 = jSONObject.getString("callback");
                    JSONObject H = H(this.mRuntime.b().getAccount());
                    if (H != null) {
                        i16 = H.optInt("state");
                        i17 = H.optInt("total");
                        i18 = H.optInt("curPer");
                        i3 = H.optInt("expPer");
                    } else {
                        i3 = 0;
                        i16 = 0;
                        i17 = 0;
                        i18 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("NewerGuidePlugin", 2, String.format("METHOD_QUERY_UPLOAD_PROGRESS [%s, %s, %s, %s]", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i3)));
                    }
                    double d17 = i18 / 100.0f;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("state", i16);
                    jSONObject2.put("total", i17);
                    jSONObject2.put("progress", d17);
                    jSONObject2.put("upload_count", (int) (i17 * d17));
                    callJs(string8, jSONObject2.toString());
                } else if (str3.equals("profileAvatar")) {
                    ((IVasFragmentRoute) QRoute.api(IVasFragmentRoute.class)).openAvatarPendantShop(this.mRuntime.a(), "3");
                } else if (str3.equals("profileSex")) {
                    Intent intent = new Intent(this.mRuntime.a(), (Class<?>) FriendProfileMoreInfoActivity.class);
                    intent.putExtra("profile_jump_to_edit", 1);
                    this.mRuntime.a().startActivity(intent);
                } else if (str3.equals("profileBirthday")) {
                    Intent intent2 = new Intent(this.mRuntime.a(), (Class<?>) FriendProfileMoreInfoActivity.class);
                    intent2.putExtra("profile_jump_to_edit", 2);
                    this.mRuntime.a().startActivity(intent2);
                } else if (str3.equals("profileLocation")) {
                    Intent intent3 = new Intent(this.mRuntime.a(), (Class<?>) FriendProfileMoreInfoActivity.class);
                    intent3.putExtra("profile_jump_to_edit", 3);
                    this.mRuntime.a().startActivity(intent3);
                } else if (str3.equals("profileSchool")) {
                    Intent intent4 = new Intent(this.mRuntime.a(), (Class<?>) FriendProfileMoreInfoActivity.class);
                    intent4.putExtra("profile_jump_to_edit", 4);
                    this.mRuntime.a().startActivity(intent4);
                }
            }
            z16 = true;
        } catch (Exception e16) {
            z16 = true;
            QLog.e("NewerGuidePlugin", 1, "handleJsRequest fail", e16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class j implements IphonePickerView.PickerViewAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f97624a;

        public j(int i3) {
            if (i3 < 1897) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
                this.f97624a = calendar.get(1);
                return;
            }
            this.f97624a = i3;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getColumnCount() {
            return 3;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public String getText(int i3, int i16) {
            if (i3 == 0) {
                return (i16 + 1897) + HardCodeUtil.qqStr(R.string.ona);
            }
            if (i3 == 1) {
                return (i16 + 1) + HardCodeUtil.qqStr(R.string.onb);
            }
            if (i3 != 2) {
                return "";
            }
            return (i16 + 1) + HardCodeUtil.qqStr(R.string.on6);
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
        public int getRowCount(int i3) {
            if (i3 == 0) {
                return (this.f97624a - 1897) + 1;
            }
            if (i3 == 1) {
                return 12;
            }
            if (i3 != 2) {
                return 0;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, r.this.f97603h + 1897);
            calendar.set(2, r.this.f97604i);
            calendar.set(5, 1);
            return calendar.getActualMaximum(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements IphonePickerView.IphonePickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IphonePickerView f97617a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionSheet f97618b;

        g(IphonePickerView iphonePickerView, ActionSheet actionSheet) {
            this.f97617a = iphonePickerView;
            this.f97618b = actionSheet;
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            int i3 = r.this.f97603h + 1897;
            int i16 = r.this.f97604i + 1;
            int i17 = r.this.f97605m + 1;
            if (QLog.isColorLevel()) {
                QLog.d("NewerGuidePlugin", 2, String.format("onDismissOperations year=%s month=%s day=%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)));
            }
            ActionSheet actionSheet = this.f97618b;
            if (actionSheet != null && actionSheet.isShowing()) {
                this.f97618b.dismiss();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", 1);
                jSONObject.put("year", i3);
                jSONObject.put("month", i16);
                jSONObject.put("date", i17);
            } catch (Exception e16) {
                QLog.e("NewerGuidePlugin", 1, "sendDatePickerResp fail", e16);
            }
            r.this.callJs("respDatePicker", jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            if (i3 == 0) {
                r.this.f97603h = i16;
            } else if (i3 == 1) {
                r.this.f97604i = i16;
            } else if (i3 == 2) {
                r.this.f97605m = i16;
            }
            IphonePickerView iphonePickerView = this.f97617a;
            if (iphonePickerView != null) {
                if (i3 == 0 || i3 == 1) {
                    iphonePickerView.notifyDataSetChange(2);
                }
            }
        }
    }

    private void O(int i3, int i16, int i17) {
        if (i3 < 1897 || i16 < 1 || i16 > 12 || i17 < 1 || i17 > 31) {
            QLog.d("NewerGuidePlugin", 1, String.format("showDatePicker invalid params year=%s month=%s day=%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)));
            i3 = 1900;
            i16 = 1;
            i17 = 1;
        }
        Activity a16 = this.mRuntime.a();
        IphonePickerView iphonePickerView = (IphonePickerView) a16.getLayoutInflater().inflate(R.layout.avo, (ViewGroup) null);
        iphonePickerView.initialize(new j(-1));
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(a16);
        createMenuSheet.setCloseAutoRead(true);
        createMenuSheet.setActionContentView(iphonePickerView, null);
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) createMenuSheet.findViewById(R.id.f163936cz);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        Window window = createMenuSheet.getWindow();
        if (window != null) {
            window.setFlags(16777216, 16777216);
        }
        iphonePickerView.setPickListener(new g(iphonePickerView, createMenuSheet));
        int i18 = i3 - 1897;
        this.f97603h = i18;
        this.f97604i = i16 - 1;
        this.f97605m = i17 - 1;
        iphonePickerView.setSelection(0, i18);
        iphonePickerView.setSelection(1, this.f97604i);
        iphonePickerView.setSelection(2, this.f97605m);
        try {
            createMenuSheet.show();
        } catch (Exception unused) {
        }
    }
}
