package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.utils.ap;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.AvatarGridAdapter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qbar.QbarCrashCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.QQToastUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAvatarWallEditActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, TroopPhotoController.d, DragView.OnGestureChangeListener, TroopPhotoController.f {
    static IPatchRedirector $redirector_;
    String A0;

    /* renamed from: a0, reason: collision with root package name */
    protected View f293541a0;

    /* renamed from: b0, reason: collision with root package name */
    protected DragView f293542b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Gallery f293543c0;

    /* renamed from: d0, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.widget.h f293544d0;

    /* renamed from: e0, reason: collision with root package name */
    public GridView f293545e0;

    /* renamed from: f0, reason: collision with root package name */
    public AvatarGridAdapter f293546f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ImageButton f293547g0;

    /* renamed from: h0, reason: collision with root package name */
    protected ImageView f293548h0;

    /* renamed from: i0, reason: collision with root package name */
    protected Button f293549i0;

    /* renamed from: j0, reason: collision with root package name */
    private k f293550j0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f293551k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f293552l0;

    /* renamed from: m0, reason: collision with root package name */
    protected String f293553m0;

    /* renamed from: n0, reason: collision with root package name */
    protected int f293554n0;

    /* renamed from: o0, reason: collision with root package name */
    protected String f293555o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f293556p0;

    /* renamed from: q0, reason: collision with root package name */
    protected boolean f293557q0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f293558r0;

    /* renamed from: s0, reason: collision with root package name */
    protected boolean f293559s0;

    /* renamed from: t0, reason: collision with root package name */
    CookieManager f293560t0;

    /* renamed from: u0, reason: collision with root package name */
    protected Rect f293561u0;

    /* renamed from: v0, reason: collision with root package name */
    Set<String> f293562v0;

    /* renamed from: w0, reason: collision with root package name */
    TroopPhotoController f293563w0;

    /* renamed from: x0, reason: collision with root package name */
    TroopPhotoController f293564x0;

    /* renamed from: y0, reason: collision with root package name */
    com.tencent.mobileqq.phonecontact.permission.b f293565y0;

    /* renamed from: z0, reason: collision with root package name */
    private long f293566z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293575d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f293576e;

        a(URLDrawable uRLDrawable, String str) {
            this.f293575d = uRLDrawable;
            this.f293576e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarWallEditActivity.this, uRLDrawable, str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopAvatarWallEditActivity.this.savePhoto(this.f293575d, this.f293576e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends AsyncTask<Void, Void, String> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293578a;

        b(URLDrawable uRLDrawable) {
            this.f293578a = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this, (Object) uRLDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            if (ap.a(TroopAvatarWallEditActivity.this, this.f293578a)) {
                String string = TroopAvatarWallEditActivity.this.getString(R.string.cwj);
                if (QLog.isColorLevel()) {
                    QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "savePhoto:");
                    return string;
                }
                return string;
            }
            return TroopAvatarWallEditActivity.this.getString(R.string.cwi);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                QQToast.makeText(TroopAvatarWallEditActivity.this, str, 0).show(TroopAvatarWallEditActivity.this.getTitleBarHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements URLDrawableHandler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void doCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload onFileDownloadFailed", new Object[0]));
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else if (QLog.isColorLevel()) {
                QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload onFileDownloadStarted", new Object[0]));
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadSucceed(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            } else if (QLog.isColorLevel()) {
                QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload onFileDownloadSucceed", new Object[0]));
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void publishProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload publishProgress", new Object[0]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements AdapterView.OnItemLongClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopAvatarWallEditActivity.this.b3();
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                TroopAvatarWallEditActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            if (view == null) {
                return;
            }
            TroopAvatarWallEditActivity troopAvatarWallEditActivity = TroopAvatarWallEditActivity.this;
            troopAvatarWallEditActivity.f293552l0 = i3;
            TroopPhotoController troopPhotoController = troopAvatarWallEditActivity.f293563w0;
            if (troopPhotoController != null) {
                troopPhotoController.F(i3);
            }
            TroopAvatarWallEditActivity troopAvatarWallEditActivity2 = TroopAvatarWallEditActivity.this;
            if (!troopAvatarWallEditActivity2.f293558r0) {
                ReportController.o(troopAvatarWallEditActivity2.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, troopAvatarWallEditActivity2.f293553m0, "0", "", "");
            } else {
                ReportController.o(troopAvatarWallEditActivity2.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, troopAvatarWallEditActivity2.f293553m0, "1", "", "");
            }
            if (TroopAvatarWallEditActivity.this.f293550j0 != null) {
                TroopAvatarWallEditActivity.this.f293550j0.a(i3);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapterView);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f293584d;

        g(ActionSheet actionSheet) {
            this.f293584d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0 && System.currentTimeMillis() - TroopAvatarWallEditActivity.this.f293566z0 > 500) {
                TroopAvatarWallEditActivity troopAvatarWallEditActivity = TroopAvatarWallEditActivity.this;
                troopAvatarWallEditActivity.f293563w0.B(troopAvatarWallEditActivity.f293552l0);
                TroopAvatarWallEditActivity.this.f293566z0 = System.currentTimeMillis();
            }
            this.f293584d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class h implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        String f293586d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f293587e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293588f;

        h(ActionSheet actionSheet, URLDrawable uRLDrawable) {
            this.f293587e = actionSheet;
            this.f293588f = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAvatarWallEditActivity.this, actionSheet, uRLDrawable);
            } else {
                this.f293586d = TroopAvatarWallEditActivity.this.f293544d0.c(TroopAvatarWallEditActivity.this.f293552l0);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            String content = this.f293587e.getContent(i3);
            if (TroopAvatarWallEditActivity.this.getString(R.string.bsj).equals(content)) {
                TroopAvatarWallEditActivity.this.forward(this.f293588f, this.f293586d);
            } else if (TroopAvatarWallEditActivity.this.getString(R.string.bst).equals(content)) {
                TroopAvatarWallEditActivity.this.savePic(this.f293588f);
            } else if (TroopAvatarWallEditActivity.this.getString(R.string.bsr).equals(content)) {
                TroopAvatarWallEditActivity troopAvatarWallEditActivity = TroopAvatarWallEditActivity.this;
                troopAvatarWallEditActivity.onQRDecodeSucceed(troopAvatarWallEditActivity.A0, this.f293586d);
            }
            this.f293587e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class i extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URLDrawable f293590a;

        i(URLDrawable uRLDrawable) {
            this.f293590a = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                TroopAvatarWallEditActivity.this.Z2(this.f293590a);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            TroopAvatarWallEditActivity troopAvatarWallEditActivity = TroopAvatarWallEditActivity.this;
            QQToast.makeText(troopAvatarWallEditActivity, troopAvatarWallEditActivity.getString(R.string.cwi), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class k {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Context f293593a;

        /* renamed from: b, reason: collision with root package name */
        private LinearLayout f293594b;

        /* renamed from: c, reason: collision with root package name */
        private Drawable f293595c;

        /* renamed from: d, reason: collision with root package name */
        private Drawable f293596d;

        /* renamed from: e, reason: collision with root package name */
        LinearLayout.LayoutParams f293597e;

        k(@NonNull LinearLayout linearLayout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) linearLayout);
                return;
            }
            Context context = linearLayout.getContext();
            this.f293593a = context;
            this.f293594b = linearLayout;
            this.f293595c = com.tencent.mobileqq.troop.utils.a.b(context.getResources(), Color.parseColor("#66ffffff"), this.f293593a.getResources().getDrawable(R.drawable.a69));
            this.f293596d = com.tencent.mobileqq.troop.utils.a.b(this.f293593a.getResources(), Color.parseColor("#ffffffff"), this.f293593a.getResources().getDrawable(R.drawable.a69));
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                this.f293595c.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
                this.f293596d.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
            }
            int dip2px = ScreenUtil.dip2px(7.5f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
            this.f293597e = layoutParams;
            layoutParams.leftMargin = ScreenUtil.dip2px(7.0f);
        }

        void a(int i3) {
            Drawable drawable;
            int childCount = this.f293594b.getChildCount();
            if (i3 >= 0 && i3 < childCount) {
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = this.f293594b.getChildAt(i16);
                    if (i3 == i16) {
                        drawable = this.f293596d;
                    } else {
                        drawable = this.f293595c;
                    }
                    childAt.setBackgroundDrawable(drawable);
                }
            }
        }

        void b(int i3) {
            if (this.f293594b.getChildCount() != i3) {
                this.f293594b.removeAllViews();
                while (i3 > 0) {
                    View view = new View(this.f293593a);
                    view.setLayoutParams(this.f293597e);
                    this.f293594b.addView(view);
                    i3--;
                }
            }
            a(0);
        }
    }

    public TroopAvatarWallEditActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f293552l0 = -1;
        this.f293556p0 = false;
        this.f293557q0 = true;
        this.f293558r0 = false;
        this.f293559s0 = false;
        this.f293562v0 = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2() {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", this.f293553m0);
        bundle.putInt("type", 1);
        TroopAvatarController troopAvatarController = new TroopAvatarController(this, this, this.app, bundle);
        this.f293564x0 = troopAvatarController;
        troopAvatarController.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2() {
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
        }
        ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
        URL uRL4TroopPhoto = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(com.tencent.mobileqq.troop.avatar.a.f294527k, this.f293553m0, 0)));
        if (uRL4TroopPhoto == null) {
            W2(1);
            return;
        }
        File file = AbsDownloader.getFile(uRL4TroopPhoto.toString());
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = uRL4TroopPhoto;
            if (file != null && file.exists()) {
                z17 = true;
            } else {
                z17 = false;
            }
            objArr[1] = Boolean.valueOf(z17);
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload %s %b", objArr));
        }
        if (file == null || !file.exists()) {
            DownloadParams downloadParams = new DownloadParams();
            downloadParams.url = uRL4TroopPhoto;
            downloadParams.urlStr = uRL4TroopPhoto.toString();
            try {
                file = new NearbyImgDownloader().loadImageFile(downloadParams, new c());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (file != null && file.exists()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("insertAvatar f exists=%b", Boolean.valueOf(z16)));
        }
        if (z16) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100161", false);
            if (this.f293564x0 == null && !isSwitchOn) {
                P2();
            }
            runOnUiThread(new Runnable(isSwitchOn, file) { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.14
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f293567d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ File f293568e;

                {
                    this.f293567d = isSwitchOn;
                    this.f293568e = file;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TroopAvatarWallEditActivity.this, Boolean.valueOf(isSwitchOn), file);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopAvatarWallEditActivity troopAvatarWallEditActivity = TroopAvatarWallEditActivity.this;
                    if (troopAvatarWallEditActivity.f293564x0 == null && this.f293567d) {
                        troopAvatarWallEditActivity.P2();
                    }
                    TroopPhotoController troopPhotoController = TroopAvatarWallEditActivity.this.f293564x0;
                    if (troopPhotoController != null && !troopPhotoController.G(this.f293568e.getPath(), null)) {
                        TroopAvatarWallEditActivity.this.W2(4);
                    }
                }
            });
            return;
        }
        W2(3);
    }

    private void R2(Intent intent) {
        if (this.f293563w0 == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        String stringExtra2 = intent.getStringExtra(ITroopPhotoUtilsApi.KEY_CLIP_INFO);
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("doOnNewIntent clip=%s path=%s", stringExtra2, stringExtra));
            }
            this.f293563w0.G(stringExtra, stringExtra2);
        }
    }

    private boolean S2(QQPermission qQPermission) {
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    private void T2(Bundle bundle) {
        this.f293543c0 = (Gallery) findViewById(R.id.gallery);
        View findViewById = findViewById(R.id.icb);
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int i16 = getResources().getDisplayMetrics().heightPixels;
        Point point = new Point();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        boolean z16 = this.f293557q0;
        if (!z16 && this.f293556p0) {
            point = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(this, 107);
            layoutParams.bottomMargin = BaseAIOUtils.f(45.0f, getResources());
        } else if (z16 && this.f293556p0) {
            point.set(i3, ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(i3));
        } else {
            int f16 = BaseAIOUtils.f(60.0f, getResources());
            point.set(i3, i16 - f16);
            layoutParams.removeRule(13);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = f16;
        }
        layoutParams.width = point.x;
        layoutParams.height = point.y;
        findViewById.setLayoutParams(layoutParams);
        com.tencent.mobileqq.troop.widget.h hVar = new com.tencent.mobileqq.troop.widget.h(this, this.app, this.f293553m0, point.x, point.y, this.f293543c0);
        this.f293544d0 = hVar;
        hVar.m(this.f293555o0);
        this.f293544d0.n(!bundle.getBoolean("from_photo_wall", false));
        this.f293544d0.j(bundle.getBoolean("is_use_path", false));
        this.f293544d0.h(this.f293557q0);
        this.f293544d0.i(this.f293556p0);
        Point clipRectSize = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(this, 107);
        this.f293544d0.k(clipRectSize.x, clipRectSize.y);
        this.f293543c0.setContentDescription(HardCodeUtil.qqStr(R.string.ubi));
        this.f293543c0.setSpacing(getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.f293543c0.enableDoubleTap(!this.f293556p0);
        this.f293543c0.enableScaleGesture(!this.f293556p0);
        this.f293543c0.setAdapter((SpinnerAdapter) this.f293544d0);
        if (this.f293557q0 && !this.f293556p0) {
            this.f293543c0.setOnItemLongClickListener(new d());
        }
        if (!this.f293556p0) {
            this.f293543c0.setOnItemClickListener(new e());
        }
        this.f293543c0.setOnItemSelectedListener(new f());
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                EntityManager createEntityManager = TroopAvatarWallEditActivity.this.app.getEntityManagerFactory().createEntityManager();
                Setting setting = (Setting) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, "troop_" + TroopAvatarWallEditActivity.this.f293553m0);
                createEntityManager.close();
                TroopAvatarWallEditActivity.this.runOnUiThread(new Runnable(setting) { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.4.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Setting f293570d;

                    {
                        this.f293570d = setting;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) setting);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            TroopAvatarWallEditActivity.this.f293544d0.l(this.f293570d);
                        }
                    }
                });
            }
        }, null, true);
        DragView dragView = (DragView) findViewById(R.id.bq8);
        this.f293542b0 = dragView;
        dragView.setGestureChangeListener(this);
        this.f293542b0.setEnableDrag(!this.f293556p0);
        this.f293542b0.setRatioModify(true);
        Rect rect = this.f293561u0;
        if (rect != null) {
            this.f293542b0.setOriginRect(rect);
        }
    }

    private void U2(Bundle bundle) {
        GridView gridView = (GridView) findViewById(R.id.a3h);
        this.f293545e0 = gridView;
        if (this.f293557q0 && this.f293556p0) {
            gridView.setVisibility(0);
            this.f293545e0.setOnItemClickListener(this);
            this.f293545e0.setEdgeEffectEnabled(false);
            this.f293545e0.setOverScrollMode(2);
            this.f293546f0 = new AvatarGridAdapter(new WeakReference(this), this.f293545e0, this.app, this.f293553m0, !this.f293558r0, this.f293556p0, "Grp_Admin_data");
            getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            ((RelativeLayout) findViewById(R.id.ich)).setMinimumHeight((this.f293546f0.b(this) * 2) + UIUtils.b(this, 10.0f));
            return;
        }
        gridView.setVisibility(8);
    }

    private void V2() {
        if (this.f293556p0 && this.f293557q0) {
            this.f293547g0.setVisibility(0);
            this.f293547g0.setOnClickListener(this);
            this.f293547g0.setContentDescription(getResources().getString(R.string.ajx));
        } else {
            this.f293547g0.setVisibility(8);
        }
        if (!this.f293557q0 && this.f293556p0) {
            this.f293549i0.setVisibility(0);
            this.f293549i0.setOnClickListener(this);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.djp);
        this.f293551k0 = linearLayout;
        if (this.f293557q0 && !this.f293556p0) {
            linearLayout.setVisibility(0);
            k kVar = new k(this.f293551k0);
            this.f293550j0 = kVar;
            kVar.b(this.f293544d0.getCount());
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(URLDrawable uRLDrawable) {
        String str = BaseApplication.getContext().getFilesDir().getPath() + "/Tencent/QQ_Images/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + this.f293553m0 + Utils.Crc64String(uRLDrawable.getURL().toString());
        File file2 = new File(str2);
        if (!file2.exists()) {
            try {
                if (file2.createNewFile()) {
                    savePhoto(uRLDrawable, file2.getPath());
                    return;
                }
                return;
            } catch (IOException unused) {
                QQToast.makeText(this, getString(R.string.cwi), 0).show();
                return;
            }
        }
        DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.h4e)).setMessage(getString(R.string.cwb)).setPositiveButton(getString(R.string.h1a), new a(uRLDrawable, str2)).setNegativeButton(getString(R.string.f171142no), new j()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3() {
        Gallery gallery = this.f293543c0;
        if (gallery == null) {
            QQToast.makeText(this, getString(R.string.boo), 0).show();
            return;
        }
        View selectedView = gallery.getSelectedView();
        if (selectedView == null) {
            QQToast.makeText(this, getString(R.string.boo), 0).show();
            return;
        }
        Drawable drawable = ((ImageView) selectedView.findViewById(R.id.image)).getDrawable();
        if (drawable != null && (drawable instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getStatus() != 1) {
                QQToast.makeText(this, getString(R.string.boo), 0).show();
                return;
            }
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            actionSheet.addButton(R.string.bsj, 1);
            actionSheet.addButton(R.string.bst, 1);
            if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
                ThreadManagerV2.executeOnFileThread(new Runnable(uRLDrawable, actionSheet) { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ URLDrawable f293572d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ActionSheet f293573e;

                    {
                        this.f293572d = uRLDrawable;
                        this.f293573e = actionSheet;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TroopAvatarWallEditActivity.this, uRLDrawable, actionSheet);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "QR Check Start!");
                            }
                            Bundle bundle = new Bundle();
                            String url = this.f293572d.getURL().toString();
                            TroopAvatarWallEditActivity troopAvatarWallEditActivity = TroopAvatarWallEditActivity.this;
                            if (troopAvatarWallEditActivity.f293560t0 == null) {
                                CookieSyncManager.createInstance(troopAvatarWallEditActivity.getApplicationContext());
                                TroopAvatarWallEditActivity.this.f293560t0 = CookieManager.getInstance();
                            }
                            String cookie = TroopAvatarWallEditActivity.this.f293560t0.getCookie(url);
                            if (cookie != null) {
                                bundle.putString("Cookie", cookie);
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "Get cookie: " + com.tencent.biz.common.util.k.e(cookie, new String[0]) + " from " + com.tencent.biz.common.util.k.f(url, new String[0]));
                                }
                            }
                            String e16 = com.tencent.biz.common.util.e.e(BaseApplication.getContext(), url, bundle);
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "saveTmpImage path = " + e16);
                            }
                            TroopAvatarWallEditActivity.this.A0 = e16;
                            QbarCrashCollector.sCurrentUrl = com.tencent.biz.common.util.k.f(url, new String[0]);
                            if (!TextUtils.isEmpty(e16)) {
                                ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(e16).getAbsolutePath()), (Context) TroopAvatarWallEditActivity.this, 1, false);
                                if (decodeQQCodeFromFile != null && decodeQQCodeFromFile.l()) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "has QRCode ");
                                    }
                                    TroopAvatarWallEditActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.6.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                            } else {
                                                AnonymousClass6.this.f293573e.addButton(R.string.bsr);
                                                AnonymousClass6.this.f293573e.updateAllButton();
                                            }
                                        }
                                    });
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "no QRCode ");
                            }
                            QbarCrashCollector.sCurrentUrl = null;
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.e("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "showMenuActionSheet error : " + e17.getMessage());
                            }
                        } catch (UnsatisfiedLinkError e18) {
                            if (QLog.isColorLevel()) {
                                QLog.e("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "showMenuActionSheet error : " + e18.getMessage());
                            }
                        }
                    }
                });
            }
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new h(actionSheet, uRLDrawable));
            actionSheet.show();
            return;
        }
        QQToast.makeText(this, getString(R.string.boo), 0).show();
    }

    private void c3(boolean z16, boolean z17) {
        com.tencent.mobileqq.troop.widget.h hVar;
        AvatarGridAdapter avatarGridAdapter;
        String deepToString;
        TroopPhotoController troopPhotoController = this.f293563w0;
        if (troopPhotoController == null) {
            return;
        }
        if (this.f293557q0) {
            List<com.tencent.mobileqq.troop.avatar.a> n3 = troopPhotoController.n();
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(z16);
                objArr[1] = Boolean.valueOf(z17);
                if (n3 == null) {
                    deepToString = "";
                } else {
                    deepToString = Arrays.deepToString(n3.toArray());
                }
                objArr[2] = deepToString;
                QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet [%b,%b] %s", objArr));
            }
            if (n3 != null && (avatarGridAdapter = this.f293546f0) != null && z17) {
                avatarGridAdapter.f(n3);
            }
            if (n3 != null && (hVar = this.f293544d0) != null && z16) {
                hVar.g(n3);
                k kVar = this.f293550j0;
                if (kVar != null) {
                    kVar.b(this.f293544d0.getCount());
                    this.f293550j0.a(this.f293552l0);
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.avatar.a l3 = troopPhotoController.l();
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", l3));
        }
        ArrayList arrayList = new ArrayList(1);
        if (l3 != null) {
            arrayList.add(l3);
            this.f293549i0.setEnabled(!l3.f294533e);
        }
        com.tencent.mobileqq.troop.widget.h hVar2 = this.f293544d0;
        if (hVar2 != null) {
            hVar2.g(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePhoto(URLDrawable uRLDrawable, String str) {
        new b(uRLDrawable).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePic(URLDrawable uRLDrawable) {
        QQPermission qQPermission;
        String str = this.f293555o0;
        if (str != null) {
            ReportController.o(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, str, "", "", "");
        }
        boolean z16 = true;
        if (uRLDrawable.getStatus() != 1) {
            return;
        }
        if (VersionUtils.isM()) {
            qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP, QQPermissionConstants.Business.SCENE.QQ_TROOP_PHOTO));
            z16 = S2(qQPermission);
        } else {
            qQPermission = null;
        }
        if (!z16) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new i(uRLDrawable));
        } else {
            Z2(uRLDrawable);
        }
    }

    private void startChatAndSendMsg(Bundle bundle) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        m3.putExtras(new Bundle(bundle));
        startActivity(m3);
        finish();
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
    public void B2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            c3(true, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
    public void C1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else if (this.f293557q0) {
            if (this.f293543c0.getSelectedItemPosition() != i3) {
                this.f293543c0.setSelection(i3);
            }
            c3(false, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
    public void H1(com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar, (Object) bVar);
            return;
        }
        if (this.f293557q0) {
            if (aVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "onUpdateItem null == info");
                    return;
                }
                return;
            }
            if (aVar.f294537i == 1 && this.f293559s0) {
                int i3 = bVar.f294520a;
                if (i3 == 1) {
                    this.f293559s0 = false;
                    Y2();
                    return;
                } else {
                    if (i3 == 2) {
                        W2(5);
                        return;
                    }
                    return;
                }
            }
            if (bVar.f294520a == 1) {
                QQToastUtil.showQQToastInUiThread(2, getString(R.string.f180023_y));
            }
            AvatarGridAdapter avatarGridAdapter = this.f293546f0;
            if (avatarGridAdapter != null) {
                avatarGridAdapter.h(aVar, bVar);
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.avatar.a item = this.f293544d0.getItem(0);
        if (aVar != null && item == aVar) {
            this.f293549i0.setEnabled(!aVar.f294533e);
            this.f293544d0.o(aVar, bVar);
        }
        if (aVar != null && aVar.f294537i == 1 && bVar.f294520a == 1) {
            TroopPhotoController.Q(((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this, 0), 2);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.f
    public boolean N0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, i3)).booleanValue();
        }
        if (this.f293559s0 && i3 == 0) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.12
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopAvatarWallEditActivity.this.Q2();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, null, true);
            return true;
        }
        return false;
    }

    protected void W2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", Integer.valueOf(i3)));
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            TroopPhotoController troopPhotoController = this.f293563w0;
            if (troopPhotoController != null) {
                troopPhotoController.E(i3);
                return;
            }
            return;
        }
        runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.15
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f293569d;

            {
                this.f293569d = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAvatarWallEditActivity.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopPhotoController troopPhotoController2 = TroopAvatarWallEditActivity.this.f293563w0;
                if (troopPhotoController2 != null) {
                    troopPhotoController2.E(this.f293569d);
                }
            }
        });
    }

    protected void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        TroopPhotoController troopPhotoController = this.f293563w0;
        if (troopPhotoController != null && (troopPhotoController instanceof TroopAvatarController)) {
            troopPhotoController.R();
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
    public void Z(com.tencent.mobileqq.troop.avatar.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        } else if (this.f293557q0) {
            c3(true, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
    public void c0(com.tencent.mobileqq.troop.avatar.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
            return;
        }
        if (this.f293557q0) {
            ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
            if (aVar.f294531c == 1 && !TextUtils.isEmpty(aVar.f294530b) && iTroopAvatarUtilApi.isNumeric(aVar.f294530b)) {
                this.f293562v0.add(aVar.f294530b);
            }
            List<com.tencent.mobileqq.troop.avatar.a> n3 = this.f293563w0.n();
            if (n3 == null || n3.size() == 0) {
                finish();
            }
            c3(true, true);
            int i3 = this.f293552l0;
            if (i3 >= 0) {
                this.f293563w0.F(i3);
            }
        }
    }

    @QQPermissionDenied(1)
    @TargetApi(23)
    public void denied() {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
        com.tencent.mobileqq.phonecontact.permission.b bVar = this.f293565y0;
        if (bVar != null && (runnable = bVar.f258492c) != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        TroopPhotoController troopPhotoController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 != 21) {
                if (i3 == 257 && (troopPhotoController = this.f293563w0) != null) {
                    troopPhotoController.I();
                    return;
                }
                return;
            }
            startChatAndSendMsg(intent.getExtras());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        TroopPhotoController troopAvatarController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && !TextUtils.isEmpty(qQAppInterface.getAccount())) {
            setContentView(R.layout.ahg);
            Bundle extras = getIntent().getExtras();
            findViewById(R.id.ier).setVisibility(0);
            View findViewById = findViewById(R.id.a4f);
            this.f293541a0 = findViewById;
            findViewById.setBackgroundColor(-16777216);
            this.f293547g0 = (ImageButton) findViewById(R.id.bf5);
            this.f293549i0 = (Button) findViewById(R.id.afx);
            this.f293556p0 = extras.getBoolean("IS_EDIT");
            this.f293557q0 = extras.getBoolean("IS_COVER", true);
            this.f293559s0 = extras.getBoolean("isUseClassAvatar", false);
            if (extras.getInt(ITroopUtilsApi.VISTOR_TYPE, 1) != 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f293558r0 = z16;
            ArrayList<TroopClipPic> parcelableArrayList = extras.getParcelableArrayList("PHOTO_LIST");
            this.f293553m0 = extras.getString("troop_uin");
            if (this.f293558r0 && (parcelableArrayList == null || parcelableArrayList.size() == 0)) {
                finish();
                return true;
            }
            if (!this.f293558r0 && TextUtils.isEmpty(this.f293553m0)) {
                finish();
                return true;
            }
            this.f293552l0 = extras.getInt("index", -1);
            this.f293554n0 = extras.getInt(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME, 0);
            Rect rect = (Rect) extras.getParcelable("KEY_THUMBNAL_BOUND");
            this.f293561u0 = rect;
            if (rect != null && LiuHaiUtils.hasInitHasNotch && LiuHaiUtils.sHasNotch) {
                int notchInScreenHeight = LiuHaiUtils.getNotchInScreenHeight(this);
                Rect rect2 = this.f293561u0;
                rect2.top -= notchInScreenHeight;
                rect2.bottom -= notchInScreenHeight;
            }
            if (!this.f293556p0) {
                setTheme(R.style.f174263uc);
            }
            ImageView imageView = (ImageView) findViewById(R.id.f164559a43);
            this.f293548h0 = imageView;
            imageView.setVisibility(0);
            this.f293548h0.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f293548h0.getLayoutParams();
            marginLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.f293548h0.getContext()) + BaseAIOUtils.f(5.0f, this.f293548h0.getResources());
            this.f293548h0.setLayoutParams(marginLayoutParams);
            this.f293548h0.setOnClickListener(this);
            if (ThemeUtil.isInNightMode(this.app)) {
                Drawable drawable = getResources().getDrawable(R.drawable.clt);
                drawable.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
                this.f293548h0.setImageDrawable(drawable);
            }
            U2(extras);
            T2(extras);
            V2();
            if (!this.f293558r0) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("troopUin", this.f293553m0);
                bundle2.putInt("type", 1);
                if (this.f293557q0) {
                    troopAvatarController = new TroopPhotoController(this, this, this.app, bundle2);
                } else {
                    troopAvatarController = new TroopAvatarController(this, this, this.app, bundle2);
                }
                this.f293563w0 = troopAvatarController;
                troopAvatarController.d();
                this.f293563w0.c(this);
                this.f293563w0.D(this.f293554n0);
                this.f293563w0.K(false);
                this.f293563w0.F(this.f293552l0);
                this.f293563w0.O(this);
                this.f293563w0.M(this.f293557q0);
            } else {
                ArrayList arrayList = new ArrayList();
                for (TroopClipPic troopClipPic : parcelableArrayList) {
                    if (troopClipPic != null) {
                        arrayList.add(com.tencent.mobileqq.troop.avatar.a.b(troopClipPic, null));
                    }
                }
                com.tencent.mobileqq.troop.widget.h hVar = this.f293544d0;
                if (hVar != null) {
                    hVar.g(arrayList);
                    this.f293543c0.setSelection(this.f293552l0);
                    k kVar = this.f293550j0;
                    if (kVar != null) {
                        kVar.b(this.f293544d0.getCount());
                        this.f293550j0.a(this.f293552l0);
                    }
                }
            }
            R2(getIntent());
            return true;
        }
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.widget.h hVar = this.f293544d0;
        if (hVar != null) {
            hVar.e();
        }
        TroopPhotoController troopPhotoController = this.f293563w0;
        if (troopPhotoController != null) {
            troopPhotoController.C();
        }
        TroopPhotoController troopPhotoController2 = this.f293564x0;
        if (troopPhotoController2 != null) {
            troopPhotoController2.C();
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        } else {
            R2(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Intent intent = new Intent();
        if (this.f293562v0.size() > 0) {
            intent.putStringArrayListExtra(ITroopPhotoUtilsApi.KEY_DEL_PICS, new ArrayList<>(this.f293562v0));
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("finish delPics=%s", Arrays.toString(this.f293562v0.toArray())));
        }
        setResult(-1, intent);
        super.finish();
    }

    void forward(URLDrawable uRLDrawable, String str) {
        String str2 = this.f293555o0;
        if (str2 != null) {
            ReportController.o(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, str2, "", "", "");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE);
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = sDKPrivatePath + this.f293553m0 + Utils.Crc64String(uRLDrawable.getURL().toString());
        if (!new File(str3).exists()) {
            try {
                str3 = uRLDrawable.saveTo(str3);
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("foward", 2, "IOException", e16);
                }
            }
        }
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str3);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str3);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(this, intent, 21);
    }

    @QQPermissionGrant(1)
    public void grant() {
        com.tencent.mobileqq.phonecontact.permission.b bVar;
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user grant = ");
        if (VersionUtils.isM()) {
            Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
            if (applicationContext.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && applicationContext.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0 && (bVar = this.f293565y0) != null && (runnable = bVar.f258491b) != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.bf5) {
                if (!NetworkUtil.isNetSupport(this)) {
                    QQToast.makeText(this, getString(R.string.cjm), 0).show(getResources().getDimensionPixelOffset(R.dimen.title_bar_height));
                } else {
                    ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
                    actionSheet.addButton(R.string.bsg, 3);
                    actionSheet.addCancelButton(R.string.cancel);
                    actionSheet.setOnButtonClickListener(new g(actionSheet));
                    actionSheet.show();
                }
            } else if (id5 == R.id.f164122k9) {
                if (this.f293557q0 && !this.f293556p0) {
                    b3();
                }
            } else if (id5 == R.id.f164559a43) {
                finish();
            } else if (id5 == R.id.afx) {
                this.f293563w0.H();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onClickDragView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onClickDragView", new Object[0]));
        }
        finish();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onContentMove(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onContentMove %.1f", Float.valueOf(f16)));
        }
        this.f293541a0.setAlpha(f16);
        this.f293548h0.setVisibility(8);
        if (this.f293557q0) {
            this.f293551k0.setVisibility(8);
        }
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onGestureFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "onGestureFinish");
        }
        finish();
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (this.f293563w0 == null) {
            return;
        }
        com.tencent.mobileqq.troop.avatar.a item = this.f293546f0.getItem(i3);
        if (item != null) {
            if (4 != item.f294531c) {
                this.f293563w0.F(i3);
                return;
            } else if (!NetworkUtil.isNetSupport(this)) {
                QQToast.makeText(this, getString(R.string.cjm), 0).show(getResources().getDimensionPixelOffset(R.dimen.title_bar_height));
                return;
            } else {
                this.f293563w0.H();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TROOP_AVATAR_WALL, 2, "avatarInfo = null, position=" + i3);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (82 == keyEvent.getKeyCode()) {
            if (this.f293557q0 && !this.f293556p0) {
                b3();
                return true;
            }
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
    }

    void onQRDecodeSucceed(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra("fromPicQRDecode", true);
        intent.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, str2, null, null, null, 7));
        RouteUtils.startActivity(this, intent, "/qrscan/scanner");
    }

    @Override // com.tencent.widget.DragView.OnGestureChangeListener
    public void onResetPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onResetPosition", new Object[0]));
        }
        if (this.f293556p0) {
            return;
        }
        this.f293541a0.setAlpha(1.0f);
        this.f293548h0.setVisibility(0);
        if (this.f293557q0) {
            this.f293551k0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
    }
}
