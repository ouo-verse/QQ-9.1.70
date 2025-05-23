package com.tencent.mobileqq.wink.preprocess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.p;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.preprocess.WinkShareProcessTransFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes21.dex */
public class WinkShareProcessTransFragment extends QPublicBaseFragment implements View.OnClickListener {
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private TextView L;
    private String M;
    private Handler N;
    private ProgressBar P;
    private ImageView Q;
    private String R;
    private String S;
    private String T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private p Y = new p();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f325344a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f325345b;

        a(Intent intent, String str) {
            this.f325344a = intent;
            this.f325345b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Intent intent, String str) {
            if (!WinkShareProcessTransFragment.this.Hh(intent, str)) {
                QQToast.makeText(WinkShareProcessTransFragment.this.getActivity().getApplicationContext(), 1, R.string.f216375y5, 1);
                WinkShareProcessTransFragment.this.Eh();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3) {
            WinkShareProcessTransFragment.this.L.setText(WinkShareProcessTransFragment.this.M + i3 + "%");
            WinkShareProcessTransFragment.this.P.setProgress(i3);
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean z16) {
            if (WinkShareProcessTransFragment.this.U) {
                return;
            }
            if (z16) {
                if (!WinkShareProcessTransFragment.this.Hh(this.f325344a, this.f325345b)) {
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final Intent intent = this.f325344a;
                    final String str = this.f325345b;
                    uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkShareProcessTransFragment.a.this.c(intent, str);
                        }
                    }, 3000L);
                    return;
                }
                return;
            }
            if (WinkShareProcessTransFragment.this.Q != null) {
                WinkShareProcessTransFragment.this.Q.setImageResource(R.drawable.otf);
            }
            QQToast.makeText(WinkShareProcessTransFragment.this.getActivity().getApplicationContext(), 1, R.string.f216375y5, 1);
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(final int i3) {
            if (!WinkShareProcessTransFragment.this.U && i3 > 0 && i3 <= 100) {
                if (i3 == 100 && !WinkShareProcessTransFragment.this.V) {
                    i3 = 99;
                }
                WinkShareProcessTransFragment.this.getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkShareProcessTransFragment.a.this.d(i3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f325347a;

        b(Intent intent) {
            this.f325347a = intent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            WinkShareProcessTransFragment.this.W = false;
            WinkShareProcessTransFragment.this.Eh();
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            WinkShareProcessTransFragment.this.W = false;
            WinkShareProcessTransFragment.this.Dh(this.f325347a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            super.onDeniedWithoutShowDlg(list, list2);
            WinkShareProcessTransFragment.this.W = false;
            WinkShareProcessTransFragment.this.Eh();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
            permissionRequestDialog.setOnDisAllowClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.preprocess.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkShareProcessTransFragment.b.this.b(view);
                }
            });
        }
    }

    private void Ch(Intent intent) {
        QLog.d("WinkShareProcessTransFragment", 1, "checkPermission");
        this.W = false;
        if (getActivity() != null && getActivity().getWindow() != null) {
            View decorView = getActivity().getWindow().getDecorView();
            Context activity = getActivity();
            if (decorView.getParent() instanceof View) {
                activity = ((View) decorView.getParent()).getContext();
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission((Activity) activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_PUBLISH_FEED));
            if (qQPermission == null) {
                return;
            }
            this.W = true;
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(intent));
            return;
        }
        QLog.d("WinkShareProcessTransFragment", 1, "requestPermissions error with null activity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(final Intent intent) {
        if (Hh(intent, this.D)) {
            return;
        }
        if (!TextUtils.isEmpty(this.D)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.f
                @Override // java.lang.Runnable
                public final void run() {
                    WinkShareProcessTransFragment.this.Jh(intent);
                }
            }, 64, null, false);
        } else if (!TextUtils.isEmpty(this.C)) {
            com.tencent.mobileqq.wink.downloader.a.a(this.C, new a(intent, com.tencent.mobileqq.wink.downloader.a.b(this.C)));
        } else {
            Eh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        this.U = true;
        Intent intent = getActivity().getIntent();
        intent.putExtra("wink_share_result", false);
        WinkContext.INSTANCE.d().m().j(getActivity(), intent.getExtras());
        getActivity().finish();
    }

    private void Fh() {
        if (!TextUtils.isEmpty(this.R) && !TextUtils.isEmpty(this.I) && !TextUtils.isEmpty(this.J) && !TextUtils.isEmpty(this.T)) {
            m.e(this.R, this.I, this.J, this.T);
        } else {
            QLog.e("WinkShareProcessTransFragment", 1, " getBattleInfo error ");
        }
    }

    private void Gh(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.C = jSONObject.optString("video_url");
            this.D = jSONObject.optString("local_video_path");
            this.E = jSONObject.optString("video_height");
            this.F = jSONObject.optString("video_width");
            this.G = jSONObject.optString("video_size");
            this.H = jSONObject.optString("cover_image");
            this.I = jSONObject.optString("game_id");
            this.J = jSONObject.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
            this.K = jSONObject.optString("direct_publish");
        } catch (Exception e16) {
            QLog.e("WinkShareProcessTransFragment", 1, " s = " + str + " exception= " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hh(Intent intent, String str) {
        LocalMediaInfo buildLocalMediaInfoByPath;
        if (!this.V) {
            this.V = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(QQWinkConstants.ENTRY_QQ_WORLD);
        }
        QLog.d("WinkShareProcessTransFragment", 1, "jumpToEditOrPublish = " + str);
        if (!TextUtils.isEmpty(str) && (buildLocalMediaInfoByPath = ((IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class)).buildLocalMediaInfoByPath(str)) != null && buildLocalMediaInfoByPath.mediaHeight > 0) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(buildLocalMediaInfoByPath);
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(str);
            HashMap hashMap = new HashMap();
            hashMap.put(str, buildLocalMediaInfoByPath);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, arrayList);
            extras.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList2);
            extras.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            extras.putSerializable("PeakConstants.selectedMediaInfoHashMap", hashMap);
            extras.putString(QQWinkConstants.SCHEMA_OPERATION_ACTIVITY_ID, m.d(this.R));
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                if (this.V && !"1".equals(this.K)) {
                    com.tencent.mobileqq.wink.f.v(activity, extras);
                } else {
                    com.tencent.mobileqq.wink.g.f322861a.m(activity, new Intent().putExtras(extras));
                }
                QLog.d("WinkShareProcessTransFragment", 1, "jumpToEdit end");
                activity.finish();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih() {
        this.L.setText(this.M + "100%");
        this.P.setProgress(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(Intent intent) {
        try {
            String saveFileUriToFile = FileUtils.saveFileUriToFile(getContext(), this.D, "opensdk_tmp");
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.g
                @Override // java.lang.Runnable
                public final void run() {
                    WinkShareProcessTransFragment.this.Ih();
                }
            });
            if (!TextUtils.isEmpty(saveFileUriToFile)) {
                Hh(intent, saveFileUriToFile);
            } else {
                Eh();
            }
        } catch (Exception e16) {
            QLog.e("WinkShareProcessTransFragment", 1, "Error while saving file: " + e16.getMessage());
            Eh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh() {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady()) {
            QLog.d("WinkShareProcessTransFragment", 1, "isFlashCameraResReady false");
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchAllEssentialBundles();
        } else {
            this.V = true;
        }
        com.tencent.mobileqq.wink.g.f322861a.p(getActivity());
    }

    private void parseIntent(Intent intent) {
        String stringExtra = intent.getStringExtra(QQWinkConstants.WINK_SHARE_EXTRADATA);
        intent.removeExtra(QQWinkConstants.WINK_SHARE_EXTRADATA);
        HashMap hashMap = (HashMap) intent.getSerializableExtra("key_attrs");
        if (hashMap != null && !hashMap.isEmpty()) {
            this.R = (String) hashMap.get(QQWinkConstants.WINK_SHARE_APPID);
            this.S = (String) hashMap.get(QQWinkConstants.WINK_SHARE_PKGNAME);
            this.T = (String) hashMap.get(QQWinkConstants.WINK_SHARE_OPENID);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            Gh(stringExtra);
            Fh();
        }
        if (!TextUtils.isEmpty(this.D)) {
            Ch(intent);
        } else {
            Dh(intent);
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.qzone.common.activities.titlebuilder.f
    public Handler getMainHandler() {
        if (this.N == null) {
            this.N = new Handler(Looper.getMainLooper());
        }
        return this.N;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null && getActivity().getIntent() != null) {
            parseIntent(getActivity().getIntent());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.e
            @Override // java.lang.Runnable
            public final void run() {
                WinkShareProcessTransFragment.this.Kh();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Eh();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f123957i2) {
            Eh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.Y.a(bundle, getActivity().getIntent());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        setStatusBarImmersive();
        View inflate = layoutInflater.inflate(R.layout.i7v, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.Y.a(null, getActivity().getIntent());
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getActivity().getWindow());
        if (this.W && this.X) {
            Ch(getActivity().getIntent());
        }
        this.X = false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.Y.c(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.X = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.M = getString(R.string.f216385y6);
        this.L = (TextView) view.findViewById(R.id.f123947i1);
        this.P = (ProgressBar) view.findViewById(R.id.g1o);
        ImageView imageView = (ImageView) view.findViewById(R.id.f123957i2);
        this.Q = imageView;
        imageView.setOnClickListener(this);
    }

    protected void setStatusBarImmersive() {
        if (getActivity() != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
    }
}
