package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.enrique.stackblur.StackBlurManager;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.screendetect.a;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_SCREENSHOT, scene = QQPermissionConstants.Business.SCENE.SAVE_SCREENSHOT)
/* loaded from: classes18.dex */
public class ScreenShotFragment extends PublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private ImageView D;
    private TextView E;
    private RecyclerView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private boolean K;
    private QQAppInterface L;
    private ScreenShotHelper M;
    private List<ResultRecord> N;
    private com.tencent.mobileqq.screendetect.a P;
    private LinearLayoutManager Q;
    private View R;
    private LinearLayout S;
    private LinearLayout T;
    private ImageView U;
    private ElasticHorScrView V;
    private GridView W;
    private DragView X;
    private Gallery Y;
    private Handler Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f282450a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f282451b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f282452c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f282453d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f282454e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f282455f0;

    /* renamed from: g0, reason: collision with root package name */
    private a.InterfaceC8526a f282456g0;

    /* renamed from: h0, reason: collision with root package name */
    private Bitmap f282457h0;

    /* renamed from: i0, reason: collision with root package name */
    private RelativeLayout f282458i0;

    /* renamed from: j0, reason: collision with root package name */
    private ForwardBaseOption f282459j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f282460k0;

    /* renamed from: l0, reason: collision with root package name */
    private BaseActivity f282461l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f282462m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f282463n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f282464o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f282465p0;

    /* renamed from: q0, reason: collision with root package name */
    protected AdapterView.OnItemClickListener f282466q0;

    /* renamed from: r0, reason: collision with root package name */
    private Runnable f282467r0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class MyResultReceiver extends ResultReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ScreenShotFragment> f282469d;

        public MyResultReceiver(ScreenShotFragment screenShotFragment) {
            super(new Handler(Looper.getMainLooper()));
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) screenShotFragment);
            } else {
                this.f282469d = new WeakReference<>(screenShotFragment);
            }
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            FragmentActivity activity;
            ArrayList parcelableArrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
                return;
            }
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "onReceiveResult() called with: resultCode = [" + i3 + "], resultData = [" + bundle + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
            }
            ScreenShotFragment screenShotFragment = this.f282469d.get();
            if (screenShotFragment != null && bundle != null && (activity = screenShotFragment.getActivity()) != null && !activity.isFinishing() && bundle.getInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO) == 2 && i3 == -1 && (parcelableArrayList = bundle.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET)) != null) {
                screenShotFragment.N.clear();
                screenShotFragment.N.addAll(parcelableArrayList);
                screenShotFragment.P.t(parcelableArrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements a.InterfaceC8526a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.screendetect.a.InterfaceC8526a
        public void onItemClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "ScreenShotInnerAdapter OnItemClickListener : position = " + i3 + ", view = " + view);
            }
            ScreenShotFragment.this.Vh(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                ScreenShotFragment.this.bi();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDeniedWithoutShowDlg(list, list2);
                DialogUtil.showPermissionDialogForStorage(ScreenShotFragment.this.f282461l0, ScreenShotFragment.this.getString(R.string.f200984tl));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements OnApplyWindowInsetsListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this);
            }
        }

        @Override // android.support.v4.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WindowInsetsCompat) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) windowInsetsCompat);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onApplyWindowInsets current is liuhai style!");
            }
            ScreenShotFragment.this.li();
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a extends QQPermission.BasePermissionsListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            String str;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "OnItemClickListener : position = " + i3 + ", view = " + view + ", id = " + j3);
            }
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            int i17 = ((g) tag).f282485c.action;
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 9) {
                        if (i17 != 10) {
                            if (i17 != 50) {
                                if (i17 != 171) {
                                    str = null;
                                } else {
                                    str = "6";
                                }
                            } else {
                                ScreenShotHelper.m("0X800A77D", 0);
                                str = "5";
                            }
                        } else {
                            ScreenShotHelper.m("0X8009FF3", 0);
                            str = "4";
                        }
                    } else {
                        ScreenShotHelper.m("0X8009FF2", 0);
                        str = "3";
                    }
                } else {
                    ScreenShotHelper.m("0X8009FF1", 0);
                    str = "2";
                }
            } else {
                ScreenShotHelper.m("0X8009FF0", 0);
                str = "1";
            }
            if (ScreenShotFragment.this.f282464o0 && str != null) {
                ScreenShotHelper.n("0X800A9A9", str, "1");
            }
            if (i17 == 9 || i17 == 10) {
                if (!WXShareHelper.b0().e0()) {
                    i16 = R.string.f173257ih1;
                } else if (!WXShareHelper.b0().f0()) {
                    i16 = R.string.f173258ih2;
                } else {
                    i16 = -1;
                }
                if (i16 != -1) {
                    QQToast.makeText(ScreenShotFragment.this.getBaseActivity(), ScreenShotFragment.this.getBaseActivity().getString(i16), 0).show(ScreenShotFragment.this.getBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    return;
                }
            }
            if (i17 == 2) {
                ScreenShotFragment.Yh(ScreenShotFragment.this.getBaseActivity(), ScreenShotFragment.this.f282453d0);
                return;
            }
            if (i17 != 3) {
                if (i17 != 9) {
                    if (i17 != 10) {
                        if (i17 != 12) {
                            if (i17 != 39) {
                                if (i17 != 50) {
                                    if (i17 == 171) {
                                        ScreenShotFragment screenShotFragment = ScreenShotFragment.this;
                                        screenShotFragment.ci(screenShotFragment.getBaseActivity(), ScreenShotFragment.this.f282453d0);
                                        return;
                                    }
                                    return;
                                }
                                ScreenShotFragment screenShotFragment2 = ScreenShotFragment.this;
                                screenShotFragment2.Sh(screenShotFragment2.f282453d0);
                                return;
                            }
                            File file = new File(ScreenShotFragment.this.f282453d0);
                            QQPermission qQPermission = QQPermissionFactory.getQQPermission(ScreenShotFragment.this.f282461l0, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SHARE, QQPermissionConstants.Business.SCENE.SHARE_SAVE_PIC));
                            if (qQPermission == null) {
                                QQToast.makeText(ScreenShotFragment.this.getBaseActivity(), 2, ScreenShotFragment.this.getBaseActivity().getString(R.string.h3y), 0).show();
                                return;
                            }
                            if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a());
                                return;
                            }
                            if (file.exists()) {
                                com.tencent.mobileqq.activity.aio.photo.c.n(ScreenShotFragment.this.getBaseActivity(), file, Utils.Crc64String(file.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
                                QQToast.makeText(ScreenShotFragment.this.getBaseActivity(), 2, ScreenShotFragment.this.getBaseActivity().getString(R.string.f173075h42), 0).show();
                            }
                            ScreenShotFragment.this.finishActivity();
                            return;
                        }
                        ScreenShotFragment screenShotFragment3 = ScreenShotFragment.this;
                        screenShotFragment3.di(screenShotFragment3.getBaseActivity(), ScreenShotFragment.this.f282453d0, ScreenShotFragment.this.f282455f0);
                        return;
                    }
                    ScreenShotFragment screenShotFragment4 = ScreenShotFragment.this;
                    screenShotFragment4.ei(screenShotFragment4.f282453d0, ScreenShotFragment.this.f282457h0);
                    return;
                }
                if (PicShareToWX.f().h() && PicShareToWX.f().j(ScreenShotFragment.this.f282453d0)) {
                    PicShareToWX.f().q(ScreenShotFragment.this.getBaseActivity(), ScreenShotFragment.this.L, ScreenShotFragment.this.f282453d0, 3);
                    ReportController.o(null, "dc00898", "", "", "0X800A505", "0X800A505", 0, 0, "", "", "", "");
                    return;
                } else {
                    ScreenShotFragment screenShotFragment5 = ScreenShotFragment.this;
                    screenShotFragment5.gi(screenShotFragment5.f282453d0, ScreenShotFragment.this.f282457h0);
                    return;
                }
            }
            ScreenShotFragment screenShotFragment6 = ScreenShotFragment.this;
            screenShotFragment6.fi(screenShotFragment6.getBaseActivity(), ScreenShotFragment.this.f282453d0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class f extends BaseAdapter implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private List<ShareActionSheetBuilder.ActionSheetItem> f282476d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f282477e;

        /* renamed from: f, reason: collision with root package name */
        private int f282478f;

        /* renamed from: h, reason: collision with root package name */
        private a f282479h;

        /* renamed from: i, reason: collision with root package name */
        private Resources f282480i;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        private static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private final Drawable f282481a;

            /* renamed from: b, reason: collision with root package name */
            private final Drawable f282482b;

            a(Context context) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                    return;
                }
                Resources resources = context.getResources();
                this.f282481a = resources.getDrawable(R.drawable.f160036m);
                this.f282482b = resources.getDrawable(R.drawable.f160039o);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Drawable d(Drawable drawable) {
                Drawable mutate = drawable.getConstantState().newDrawable().mutate();
                mutate.setColorFilter(Integer.MAX_VALUE, PorterDuff.Mode.MULTIPLY);
                return mutate;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Drawable e(Drawable drawable) {
                return new LayerDrawable(new Drawable[]{drawable, this.f282482b});
            }

            Drawable c(Drawable drawable, int i3, int i16) {
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f282481a, drawable});
                layerDrawable.setLayerInset(1, i3, i16, i3, i16);
                return layerDrawable;
            }

            StateListDrawable f(Drawable drawable, Drawable drawable2) {
                int[] iArr = {android.R.attr.state_pressed};
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(iArr, drawable2);
                stateListDrawable.addState(new int[0], drawable);
                return stateListDrawable;
            }
        }

        public f(Context context, List<ShareActionSheetBuilder.ActionSheetItem> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) list);
                return;
            }
            this.f282478f = 0;
            this.f282476d = list;
            this.f282477e = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareActionSheetBuilder.ActionSheetItem getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ShareActionSheetBuilder.ActionSheetItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (this.f282476d != null && i3 >= 0) {
                int i16 = -1;
                for (int i17 = 0; i17 < this.f282476d.size(); i17++) {
                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f282476d.get(i17);
                    if (actionSheetItem != null && actionSheetItem.visibility == 0) {
                        i16++;
                    }
                    if (i16 == i3) {
                        return actionSheetItem;
                    }
                }
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            List<ShareActionSheetBuilder.ActionSheetItem> list = this.f282476d;
            int i3 = 0;
            if (list == null) {
                return 0;
            }
            for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
                if (actionSheetItem != null && actionSheetItem.visibility == 0) {
                    i3++;
                }
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            g gVar;
            int i16;
            int i17;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i18 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (this.f282480i == null) {
                    this.f282480i = viewGroup.getContext().getResources();
                }
                if (this.f282478f == 0) {
                    this.f282478f = (int) this.f282480i.getDimension(R.dimen.f158592jv);
                }
                if (this.f282479h == null) {
                    this.f282479h = new a(viewGroup.getContext());
                }
                if (view == null) {
                    view = this.f282477e.inflate(R.layout.f167788hi, viewGroup, false);
                    gVar = new g();
                    gVar.f282484b = (ImageView) view.findViewById(R.id.iqu);
                    gVar.f282483a = (TextView) view.findViewById(R.id.iqv);
                    view.setTag(gVar);
                    view.setFocusable(true);
                } else {
                    gVar = (g) view.getTag();
                }
                ShareActionSheetBuilder.ActionSheetItem item = getItem(i3);
                gVar.f282485c = item;
                if (item == null) {
                    QLog.e("ScreenShotFragment", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + i3 + ") == null !!!");
                } else {
                    view.setId(item.f307296id);
                    TextView textView = gVar.f282483a;
                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = gVar.f282485c;
                    String str = actionSheetItem.label;
                    int i19 = actionSheetItem.firstLineCount;
                    if (i19 <= 0) {
                        i19 = 6;
                    }
                    textView.setText(ScreenShotFragment.Ph(str, i19));
                    if (QQTheme.isNowSimpleUI()) {
                        i16 = DownloadCardView.COLOR_APP_VERSION;
                    } else {
                        i16 = RichStatus.ACTION_COLOR_NORMAL;
                    }
                    int i26 = (16777215 & i16) | HWColorFormat.COLOR_FormatVendorStartUnused;
                    TextView textView2 = gVar.f282483a;
                    if (!gVar.f282485c.enable) {
                        i16 = i26;
                    }
                    textView2.setTextColor(i16);
                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem2 = gVar.f282485c;
                    if (actionSheetItem2.iconNeedBg) {
                        Drawable drawable = actionSheetItem2.iconDrawable;
                        if (drawable == null) {
                            drawable = this.f282480i.getDrawable(actionSheetItem2.icon);
                        }
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = drawable.getIntrinsicHeight();
                        int i27 = this.f282478f;
                        if (i27 > intrinsicWidth) {
                            i17 = (int) ((i27 - intrinsicWidth) / 2.0f);
                        } else {
                            i17 = 0;
                        }
                        if (i27 > intrinsicHeight) {
                            i18 = (int) ((i27 - intrinsicHeight) / 2.0f);
                        }
                        Drawable c16 = this.f282479h.c(drawable, i17, i18);
                        if (gVar.f282485c.enable) {
                            gVar.f282484b.setImageDrawable(this.f282479h.f(c16, this.f282479h.e(c16)));
                        } else {
                            gVar.f282484b.setImageDrawable(this.f282479h.d(c16));
                        }
                        gVar.f282484b.setBackground(null);
                    } else {
                        gVar.f282484b.setImageResource(R.drawable.f160037n);
                        ShareActionSheetBuilder.ActionSheetItem actionSheetItem3 = gVar.f282485c;
                        Drawable drawable2 = actionSheetItem3.iconDrawable;
                        if (drawable2 != null) {
                            gVar.f282484b.setBackground(drawable2);
                        } else {
                            gVar.f282484b.setBackgroundResource(actionSheetItem3.icon);
                        }
                    }
                    if (AppSetting.f99565y) {
                        String str2 = gVar.f282485c.label;
                        if (str2 == null) {
                            str2 = "";
                        }
                        view.setContentDescription(str2);
                    }
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f282483a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f282484b;

        /* renamed from: c, reason: collision with root package name */
        public ShareActionSheetBuilder.ActionSheetItem f282485c;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ScreenShotFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.K = false;
        this.N = new ArrayList();
        this.Z = new Handler(Looper.getMainLooper());
        this.f282454e0 = false;
        this.f282456g0 = new a();
        this.f282466q0 = new d();
        this.f282467r0 = new Runnable() { // from class: com.tencent.mobileqq.screendetect.ScreenShotFragment.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (ScreenShotFragment.this.f282453d0 != null) {
                    try {
                        ScreenShotFragment screenShotFragment = ScreenShotFragment.this;
                        screenShotFragment.Oh(screenShotFragment.f282453d0);
                    } catch (OutOfMemoryError e16) {
                        QLog.w("ScreenShotFragment", 2, e16.getMessage());
                    }
                }
            }
        };
    }

    private Bitmap Lh(Bitmap bitmap, int i3) {
        float height;
        float width;
        Matrix matrix = new Matrix();
        matrix.setRotate(i3, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        if (i3 == 90) {
            height = bitmap.getHeight();
            width = 0.0f;
        } else {
            height = bitmap.getHeight();
            width = bitmap.getWidth();
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        matrix.postTranslate(height - fArr[2], width - fArr[5]);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, matrix, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    private void Mh() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = 1;
        if (this.E.getVisibility() == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i26 = i3 + 0;
        if (this.G.getVisibility() == 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        int i27 = i26 + i16;
        if (this.H.getVisibility() == 0) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        int i28 = i27 + i17;
        if (this.I.getVisibility() == 0) {
            i18 = 1;
        } else {
            i18 = 0;
        }
        int i29 = i28 + i18;
        if (this.J.getVisibility() != 0) {
            i19 = 0;
        }
        if (i29 + i19 >= 4) {
            this.E.setTextSize(12.0f);
            this.G.setTextSize(12.0f);
            this.H.setTextSize(12.0f);
            this.I.setTextSize(12.0f);
            this.J.setTextSize(12.0f);
        }
    }

    private void Nh() {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment bindData");
        }
        if (this.f282453d0 != null) {
            ThreadManager.getSubThreadHandler().postDelayed(this.f282467r0, 100L);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseActivity());
        this.Q = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.F.setLayoutManager(this.Q);
        com.tencent.mobileqq.screendetect.a aVar = new com.tencent.mobileqq.screendetect.a(getBaseActivity(), this.L, this.F, 0);
        this.P = aVar;
        aVar.u(this.f282456g0);
        this.F.setAdapter(this.P);
        this.P.t(this.N);
        List<ShareActionSheetBuilder.ActionSheetItem> list = Th()[0];
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(getBaseActivity().getResources().getDimensionPixelSize(R.dimen.ayi));
        StaticLayout staticLayout = new StaticLayout(Ph(Uh(list), 6), textPaint, this.f282450a0, Layout.Alignment.ALIGN_CENTER, 1.0f, this.f282451b0, true);
        this.V.setOverScrollMode(2);
        Iterator<ShareActionSheetBuilder.ActionSheetItem> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().visibility == 0) {
                i3++;
            }
        }
        int i16 = this.f282450a0 + 20 + 20;
        this.W.setColumnWidth(i16);
        this.W.setNumColumns(i3);
        ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
        GridView gridView = this.W;
        gridView.setPadding(16, gridView.getPaddingTop(), 16, this.W.getPaddingBottom());
        layoutParams.width = (i3 * i16) + 0 + 0;
        layoutParams.height = this.f282450a0 + this.f282452c0 + staticLayout.getHeight();
        this.W.setLayoutParams(layoutParams);
        this.W.setAdapter((ListAdapter) new f(getBaseActivity(), list));
        this.W.setSelector(new ColorDrawable(0));
        this.W.setOnItemClickListener(this.f282466q0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(String str) {
        Bitmap bitmap;
        if (getBaseActivity() != null && !getBaseActivity().isFinishing()) {
            Bitmap Zh = Zh(str);
            this.f282457h0 = Zh;
            if (Zh == null) {
                QLog.e("ScreenShotFragment", 1, "run: screenBitmap == null");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "screenBitmap : width = " + this.f282457h0.getWidth() + ", height = " + this.f282457h0.getHeight());
            }
            if (this.f282457h0.getHeight() > 16 && this.f282457h0.getWidth() > 16) {
                int height = this.f282457h0.getHeight();
                if (this.f282464o0) {
                    QLog.d("ScreenShotFragment", 1, "long pic blur background change start, height is : ", Integer.valueOf(height));
                    int height2 = this.R.getHeight();
                    if (height2 != 0 && height > height2) {
                        height = height2;
                    } else if (getBaseActivity() != null && height > ScreenUtil.getInstantScreenHeight(getBaseActivity())) {
                        height = ScreenUtil.getInstantScreenHeight(getBaseActivity());
                    }
                    QLog.d("ScreenShotFragment", 1, "long pic blur background change finish, height is : ", Integer.valueOf(height), " rootHeight is : ", Integer.valueOf(height2));
                }
                try {
                    bitmap = Bitmap.createScaledBitmap(this.f282457h0, (int) (r3.getWidth() * 0.0625f), (int) (height * 0.0625f), false);
                } catch (OutOfMemoryError unused) {
                    QLog.e("ScreenShotFragment", 1, "create scale Bitmap error : out of memory");
                    bitmap = null;
                }
                Canvas canvas = new Canvas(this.f282457h0);
                if (!this.f282454e0) {
                    canvas.drawColor(Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
                }
                canvas.setBitmap(null);
                if (this.D != null) {
                    this.Z.post(new Runnable() { // from class: com.tencent.mobileqq.screendetect.ScreenShotFragment.6
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else if (ScreenShotFragment.this.D != null) {
                                ScreenShotFragment.this.D.setImageBitmap(ScreenShotFragment.this.f282457h0);
                            }
                        }
                    });
                }
                if (bitmap == null) {
                    QLog.e("ScreenShotFragment", 1, "run: scaledBitmap == null");
                    return;
                }
                Bitmap process = new StackBlurManager(bitmap).process(4);
                if (process == null) {
                    QLog.e("ScreenShotFragment", 1, "run: blured bitmap is null");
                    return;
                }
                Canvas canvas2 = new Canvas(bitmap);
                canvas2.drawColor(0);
                canvas2.drawBitmap(process, 0.0f, 0.0f, (Paint) null);
                if ("1103".equals(ThemeUtil.curThemeId)) {
                    canvas2.drawColor(Color.parseColor("#4DEBEDF5"));
                } else {
                    canvas2.drawColor(Color.parseColor("#7F03081A"));
                }
                canvas2.setBitmap(null);
                if (this.R != null) {
                    this.Z.post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.screendetect.ScreenShotFragment.7
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Bitmap f282468d;

                        {
                            this.f282468d = bitmap;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotFragment.this, (Object) bitmap);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f282468d);
                            if (ScreenShotFragment.this.R == null) {
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ScreenShotFragment", 2, "tryToSetBlurBackground() called with: root = [" + ScreenShotFragment.this.R + "], blurBitmap = [" + this.f282468d + "]");
                            }
                            ScreenShotFragment.this.R.setBackgroundDrawable(bitmapDrawable);
                        }
                    });
                }
            }
        }
    }

    protected static String Ph(String str, int i3) {
        if (str != null && str.length() > i3) {
            return str.substring(0, i3) + "\n" + str.substring(i3);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(String str) {
        AIOGalleryUtils.e(this.f282461l0, str, 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh(int i3) {
        Intent intent;
        ResultRecord resultRecord = this.N.get(i3);
        if (resultRecord != null) {
            ai(resultRecord.uinType);
            if (getBaseActivity().getIntent() != null) {
                intent = getBaseActivity().getIntent();
            } else {
                intent = null;
            }
            if (intent == null) {
                intent = new Intent();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment handleIconItemClick");
            }
            Bundle bundle = new Bundle();
            bundle.putString("uin", resultRecord.uin);
            bundle.putString("troop_uin", resultRecord.groupUin);
            bundle.putString("uinname", resultRecord.name);
            bundle.putInt("uintype", resultRecord.type);
            bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
            intent.setData(Uri.parse(this.f282453d0));
            intent.putExtra("forward_type", 1);
            intent.putExtra(AppConstants.Key.KEY_SHARE_FROM_SCREEN_SHOT, true);
            if (this.f282459j0 == null) {
                this.f282459j0 = k.d(intent, getBaseActivity().app, getBaseActivity());
            }
            if (resultRecord.uinType == 6000) {
                this.f282459j0.buildForwardDialog(com.tencent.mobileqq.forward.e.S3.intValue(), bundle);
                return;
            } else {
                this.f282459j0.buildForwardDialog(com.tencent.mobileqq.forward.e.N3.intValue(), bundle);
                return;
            }
        }
        QLog.e("ScreenShotFragment", 2, "handleIconItemClick : position = " + i3 + ", data is null!");
    }

    private void Wh() {
        Bundle arguments = getArguments();
        this.f282462m0 = arguments.getBoolean("is_aio_page_with_msg", false);
        this.f282463n0 = arguments.getBoolean("switch_bottom_layout", false);
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "handlerArg: mHasMsg = " + this.f282462m0 + ", mSwitchLayout = " + this.f282463n0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xh(boolean z16) {
        QQToast.makeText(getBaseActivity(), 2, "\u8bf7\u624b\u52a8\u9009\u62e9\u56fe\u7247", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Yh(Activity activity, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment launchFriendPicker path = " + str);
        }
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.putExtras(bundle);
        intent.putExtra("forward_type", 1);
        intent.putExtra("key_allow_multiple_forward_from_limit", false);
        intent.putExtra(AppConstants.Key.KEY_SHARE_FROM_SCREEN_SHOT, true);
        intent.putExtra(AppConstants.Key.KEY_SHARE_FROM_SCREEN_SHOT_NEED_FINISH, true);
        intent.setData(Uri.parse(str));
        activity.startActivityForResult(intent, 3);
    }

    private void ai(int i3) {
        String str;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 1006) {
                    if (i3 != 3000) {
                        if (i3 == 6000) {
                            ScreenShotHelper.m("0X8009FEE", 5);
                            str = "3";
                        }
                    } else {
                        ScreenShotHelper.m("0X8009FEE", 3);
                    }
                } else {
                    ScreenShotHelper.m("0X8009FEE", 4);
                }
                str = null;
            } else {
                ScreenShotHelper.m("0X8009FEE", 2);
                str = "2";
            }
        } else {
            ScreenShotHelper.m("0X8009FEE", 1);
            str = "1";
        }
        if (this.f282464o0 && str != null) {
            ScreenShotHelper.n("0X800A9A7", str, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi() {
        QQToast.makeText(getBaseActivity(), R.string.f173075h42, 0).show();
        File file = new File(this.f282453d0);
        com.tencent.mobileqq.activity.aio.photo.c.n(getBaseActivity(), file, Utils.Crc64String(file.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(BaseActivity baseActivity, String str) {
        ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).shareSpringPicToGuild(baseActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(BaseActivity baseActivity, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "shareMsgToSina start!");
        }
        WBShareHelper h16 = WBShareHelper.h(4);
        if (h16 == null) {
            QLog.d("ScreenShotFragment", 1, "wbShareHelper is null");
            QQToast.makeText(baseActivity, "\u6682\u65e0\u6cd5\u5206\u4eab\u5230\u5fae\u535a", 0).show();
            return;
        }
        if (!h16.j(baseActivity)) {
            QQToast.makeText(baseActivity, "\u62b1\u6b49\uff0c\u4f60\u672a\u5b89\u88c5\u5fae\u535a\u5ba2\u6237\u7aef\uff0c\u65e0\u6cd5\u8fdb\u884c\u5fae\u535a\u5206\u4eab", 0).show();
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "  ";
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(baseActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_SHARE, QQPermissionConstants.Business.SCENE.SHARE_SAVE_PIC));
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new e());
            return;
        }
        if (Build.VERSION.SDK_INT <= 29) {
            h16.p(baseActivity, str2, new String[]{str});
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            AIOGalleryUtils.p(getBaseActivity(), file, Utils.Crc64String(file.getAbsolutePath() + NetConnInfoCenter.getServerTime()), new AIOGalleryUtils.d() { // from class: com.tencent.mobileqq.screendetect.b
                @Override // com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.d
                public final void onSavePhotoResult(boolean z16) {
                    ScreenShotFragment.this.Xh(z16);
                }
            });
        }
        h16.r(baseActivity, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(String str, Bitmap bitmap) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToFriendCircle");
        }
        WXShareHelper.b0().w0(str, bitmap, 1, false);
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(BaseActivity baseActivity, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToQzone");
        }
        QQAppInterface qQAppInterface = (QQAppInterface) baseActivity.getAppRuntime();
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        bundle.putStringArrayList("images", arrayList);
        QZoneShareManager.publishToQzone(qQAppInterface, getBaseActivity(), bundle, null, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(String str, Bitmap bitmap) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToWXFriend");
        }
        WXShareHelper.b0().w0(str, bitmap, 0, false);
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
        }
    }

    private void initUI(View view) {
        int i3;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ihw);
        this.f282458i0 = relativeLayout;
        relativeLayout.setOnClickListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.ihy);
        this.D = imageView;
        imageView.setOnClickListener(this);
        this.S = (LinearLayout) view.findViewById(R.id.ihs);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.ihx);
        this.C = imageView2;
        imageView2.setOnClickListener(this);
        if (AppSetting.f99565y) {
            this.C.setContentDescription(HardCodeUtil.qqStr(R.string.t5h));
        }
        this.F = (RecyclerView) view.findViewById(R.id.ihr);
        TextView textView = (TextView) view.findViewById(R.id.iqr);
        this.E = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.bri);
        this.G = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) view.findViewById(R.id.mdb);
        this.H = textView3;
        boolean z16 = false;
        if (!this.f282462m0 && !this.f282465p0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        ViewUtils.setVisible(textView3, i3);
        this.H.setOnClickListener(this);
        TextView textView4 = (TextView) view.findViewById(R.id.f109346fk);
        this.I = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) view.findViewById(R.id.f110316i7);
        this.J = textView5;
        textView5.setOnClickListener(this);
        this.X = (DragView) view.findViewById(R.id.bq8);
        this.Y = (Gallery) view.findViewById(R.id.gallery);
        this.T = (LinearLayout) view.findViewById(R.id.iht);
        ImageView imageView3 = (ImageView) this.R.findViewById(R.id.a4d);
        this.U = imageView3;
        if (AppSetting.f99565y) {
            imageView3.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
        }
        this.U.setOnClickListener(this);
        ElasticHorScrView elasticHorScrView = (ElasticHorScrView) view.findViewById(R.id.irb);
        this.V = elasticHorScrView;
        elasticHorScrView.setMove(true);
        this.W = (GridView) view.findViewById(R.id.f165392cx3);
        if (this.f282464o0) {
            this.D.setVisibility(8);
            this.X.setVisibility(0);
            this.Y.setAdapter((SpinnerAdapter) new com.tencent.mobileqq.gallery.view.a(Collections.singletonList(this.f282453d0)));
            this.Y.setSpacing(getResources().getDimensionPixelSize(R.dimen.f158920sg));
            this.Y.setSelection(0);
            this.X.setRatioModify(true);
            this.X.setEnableDrag(false);
            RelativeLayout relativeLayout2 = this.f282458i0;
            relativeLayout2.setPadding(relativeLayout2.getPaddingLeft(), this.f282458i0.getPaddingTop(), this.f282458i0.getPaddingRight(), 0);
            if (com.tencent.mobileqq.startup.permission.a.f(getBaseActivity())) {
                bi();
            } else {
                QQPermissionFactory.getQQPermission(this).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b());
            }
            ((TextView) view.findViewById(R.id.ihu)).setText(HardCodeUtil.qqStr(R.string.w2p));
        }
        if (this.f282465p0) {
            this.H.setText(HardCodeUtil.qqStr(R.string.vxu));
        }
        RelativeLayout relativeLayout3 = this.f282458i0;
        relativeLayout3.setPadding(relativeLayout3.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(getBaseActivity()) + 15, this.f282458i0.getPaddingRight(), this.f282458i0.getPaddingBottom());
        this.C.setContentDescription(getString(R.string.vyu));
        BaseActivity baseActivity = getBaseActivity();
        Uri fromFile = Uri.fromFile(new File(this.f282453d0));
        TextView textView6 = this.J;
        TextView textView7 = this.I;
        if (this.H.getVisibility() != 0) {
            z16 = true;
        }
        ScreenShotHelper.a(baseActivity, fromFile, textView6, textView7, z16);
        view.findViewById(R.id.vl9).setVisibility(this.H.getVisibility());
        view.findViewById(R.id.vl_).setVisibility(this.I.getVisibility());
        view.findViewById(R.id.vla).setVisibility(this.J.getVisibility());
        Mh();
    }

    private void ji() {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity");
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 2);
        intent.putExtra("PARAM_ActivityResultReceiver", new MyResultReceiver(this));
        this.f282461l0.startActivity(intent);
        this.f282461l0.overridePendingTransition(0, 0);
        QLog.d("ScreenShotFragment", 1, "startGetRecentForwardUserList");
    }

    private void ki(boolean z16) {
        if (z16) {
            this.S.setVisibility(0);
            this.T.setVisibility(8);
            if (this.N.size() == 0) {
                ji();
                return;
            }
            return;
        }
        this.S.setVisibility(8);
        this.T.setVisibility(0);
        if (this.f282464o0) {
            ScreenShotHelper.n("0X800A9A8", "1", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (LiuHaiUtils.hasNotchInScreenWrapper(getBaseActivity())) {
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume current is liuhai style!");
            }
            LiuHaiUtils.enableNotch(getBaseActivity());
        }
    }

    public void Qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment exitScreenShotScreen");
        }
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
        }
    }

    public void Rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            baseActivity.finish();
            baseActivity.overridePendingTransition(0, 0);
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity, because app is null!");
            }
        }
    }

    public List<ShareActionSheetBuilder.ActionSheetItem>[] Th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(50));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        return new ArrayList[]{arrayList};
    }

    protected String Uh(List<ShareActionSheetBuilder.ActionSheetItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        String str = "";
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str2 = list.get(i3).label;
            if (str2.length() > str.length()) {
                str = str2;
            }
        }
        return str;
    }

    public Bitmap Zh(String str) {
        Bitmap copy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Bitmap) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            j.d(file.getAbsolutePath(), options);
            int i3 = options.outHeight;
            options.inSampleSize = (i3 - this.f282460k0) / i3;
            options.inJustDecodeBounds = false;
            if (this.f282454e0) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                copy = j.d(file.getAbsolutePath(), options).copy(Bitmap.Config.ARGB_8888, true);
            } else {
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                copy = j.d(file.getAbsolutePath(), options).copy(Bitmap.Config.RGB_565, true);
            }
            if (copy.getWidth() > copy.getHeight()) {
                copy = Lh(copy, 90);
            }
            return copy;
        } catch (OutOfMemoryError e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ScreenShotFragment", 2, "makeShareBitmap", e16);
            return null;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ScreenShotFragment", 2, "makeShareBitmap", th5);
            return null;
        }
    }

    public void finishActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            baseActivity.finish();
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity");
            }
            baseActivity.overridePendingTransition(0, 0);
        }
        if (this.f282464o0) {
            ScreenShotHelper.n("0X800A9AD", "1", "");
        }
    }

    public void hi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startCrop");
        if (this.f282453d0 == null) {
            QLog.e("ScreenShotFragment", 1, "crop error : mCurrentPath is null");
        } else {
            getBaseActivity().startActivityForResult(((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(getBaseActivity(), this.f282453d0, true, true, true, true, true, false, false, false, 2, 133, 0, false, null), 5);
        }
    }

    public void ii() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startEdit");
        }
        if (this.f282453d0 == null) {
            return;
        }
        getBaseActivity().startActivityForResult(((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(getBaseActivity(), this.f282453d0, true, true, true, true, true, false, false, false, 2, 122, 0, false, null), 1);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.initWindowStyleAndAnimation(activity);
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "onActivityResult requestCode = ", i3 + ", resultCode = " + i16);
        }
        if (i3 == 1) {
            Qh();
            return;
        }
        if (i3 == 2) {
            Qh();
        } else if (i3 == 3) {
            Qh();
        } else if (i3 == 101) {
            Qh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.ihx && id5 != R.id.ihy) {
                if (id5 == R.id.iqr) {
                    ki(false);
                    ScreenShotHelper.m("0X8009FEF", 0);
                } else if (id5 == R.id.bri) {
                    if (this.f282464o0) {
                        hi();
                        ScreenShotHelper.n("0X800A9AA", "1", "");
                    } else {
                        ii();
                        ScreenShotHelper.m("0X8009FF4", 0);
                    }
                } else if (id5 != R.id.mdb) {
                    if (id5 == R.id.a4d) {
                        ki(true);
                    } else if (id5 == R.id.ihw) {
                        finishActivity();
                    } else if (id5 == R.id.f109346fk) {
                        Intent intent = new Intent();
                        intent.putExtra("preResult", (String) this.I.getTag());
                        ScreenShotHelper.k(getBaseActivity(), this.f282453d0, 2, intent);
                        ScreenShotHelper.m("0X800AC94", 0);
                        this.K = true;
                    } else if (id5 == R.id.f110316i7) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("preResult", (String) this.J.getTag());
                        ScreenShotHelper.k(getBaseActivity(), this.f282453d0, 1, intent2);
                        ScreenShotHelper.m("0X800AC93", 0);
                        this.f282461l0.finish();
                    }
                }
            } else {
                finishActivity();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate");
        }
        if (getBaseActivity() == null) {
            QLog.e("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate activity has gone!");
        }
        this.f282461l0 = getBaseActivity();
        this.M = new ScreenShotHelper();
        QQAppInterface qQAppInterface = getBaseActivity().app;
        this.L = qQAppInterface;
        if (qQAppInterface == null) {
            Rh();
            return;
        }
        this.f282450a0 = getBaseActivity().getResources().getDimensionPixelSize(R.dimen.f158592jv);
        this.f282451b0 = getBaseActivity().getResources().getDimensionPixelOffset(R.dimen.f158595jy);
        this.f282452c0 = getBaseActivity().getResources().getDimensionPixelOffset(R.dimen.f158594jx);
        Intent intent = getBaseActivity().getIntent();
        if (intent != null) {
            this.f282453d0 = intent.getStringExtra("screen_path");
            this.f282454e0 = intent.getBooleanExtra("screen_has_alpha", false);
            this.f282464o0 = intent.getBooleanExtra("is_web_screen_long_shot", false);
            this.f282465p0 = intent.getBooleanExtra("is_screen_shot_from_web", false);
            if (this.f282464o0) {
                ScreenShotHelper.n("0X800A9A6", "1", "");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            view = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreateView");
            }
            Wh();
            View inflate = layoutInflater.inflate(R.layout.b1m, viewGroup, false);
            this.R = inflate;
            inflate.setBackgroundColor(Color.parseColor("#aa000000"));
            this.f282460k0 = getBaseActivity().getResources().getDimensionPixelSize(R.dimen.av8);
            initUI(this.R);
            Nh();
            ki(!this.f282463n0);
            view = this.R;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onDestroy");
        }
        com.tencent.mobileqq.screendetect.a aVar = this.P;
        if (aVar != null) {
            aVar.onDestroy();
        }
        if (this.f282467r0 != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.f282467r0);
        }
        Bitmap bitmap = this.f282457h0;
        if (bitmap != null) {
            bitmap.recycle();
            this.f282457h0 = null;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onPause");
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume");
        }
        BaseActivity baseActivity = getBaseActivity();
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(baseActivity);
        if (systemBarComp != null) {
            systemBarComp.setgetStatusBarVisible(false, 0);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            ViewCompat.setOnApplyWindowInsetsListener(baseActivity.getWindow().getDecorView(), new c());
        } else {
            li();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onStop();
        if (this.K) {
            this.f282461l0.finish();
        }
    }
}
