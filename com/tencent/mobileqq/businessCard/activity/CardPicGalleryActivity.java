package com.tencent.mobileqq.businessCard.activity;

import ProfileLogic.QC.setUserProfileRsp;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationProfileCustomCover;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes11.dex */
public class CardPicGalleryActivity extends BaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static final String[] A0;

    /* renamed from: a0, reason: collision with root package name */
    View f200836a0;

    /* renamed from: b0, reason: collision with root package name */
    TextView f200837b0;

    /* renamed from: c0, reason: collision with root package name */
    Gallery f200838c0;

    /* renamed from: d0, reason: collision with root package name */
    ImageView f200839d0;

    /* renamed from: e0, reason: collision with root package name */
    boolean f200840e0;

    /* renamed from: f0, reason: collision with root package name */
    ArrayList<String> f200841f0;

    /* renamed from: g0, reason: collision with root package name */
    int f200842g0;

    /* renamed from: h0, reason: collision with root package name */
    Drawable f200843h0;

    /* renamed from: i0, reason: collision with root package name */
    int f200844i0;

    /* renamed from: j0, reason: collision with root package name */
    ViewGroup f200845j0;

    /* renamed from: k0, reason: collision with root package name */
    int f200846k0;

    /* renamed from: l0, reason: collision with root package name */
    boolean f200847l0;

    /* renamed from: m0, reason: collision with root package name */
    boolean f200848m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f200849n0;

    /* renamed from: o0, reason: collision with root package name */
    protected int f200850o0;

    /* renamed from: p0, reason: collision with root package name */
    long f200851p0;

    /* renamed from: q0, reason: collision with root package name */
    String f200852q0;

    /* renamed from: r0, reason: collision with root package name */
    String f200853r0;

    /* renamed from: s0, reason: collision with root package name */
    private Uri f200854s0;

    /* renamed from: t0, reason: collision with root package name */
    private FriendProfilePhotoHelper f200855t0;

    /* renamed from: u0, reason: collision with root package name */
    private ImageView f200856u0;

    /* renamed from: v0, reason: collision with root package name */
    private View f200857v0;

    /* renamed from: w0, reason: collision with root package name */
    private View f200858w0;

    /* renamed from: x0, reason: collision with root package name */
    private View f200859x0;

    /* renamed from: y0, reason: collision with root package name */
    BaseAdapter f200860y0;

    /* renamed from: z0, reason: collision with root package name */
    private SVIPObserver f200861z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                CardPicGalleryActivity.this.T2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f200863d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f200864e;

        b(ActionSheet actionSheet, URLDrawable uRLDrawable) {
            this.f200863d = actionSheet;
            this.f200864e = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CardPicGalleryActivity.this, actionSheet, uRLDrawable);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else {
                CardPicGalleryActivity.this.h3(this.f200863d, i3, this.f200864e);
                this.f200863d.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f200866d;

        c(ActionSheet actionSheet) {
            this.f200866d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this, (Object) actionSheet);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                CardPicGalleryActivity cardPicGalleryActivity = CardPicGalleryActivity.this;
                if (2 == cardPicGalleryActivity.f200850o0) {
                    cardPicGalleryActivity.S2(view);
                    CardPicGalleryActivity cardPicGalleryActivity2 = CardPicGalleryActivity.this;
                    QQAppInterface qQAppInterface = cardPicGalleryActivity2.app;
                    if (cardPicGalleryActivity2.f200847l0) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", 4, 0, str, "", "", "");
                }
                this.f200866d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URLDrawable f200868a;

        d(URLDrawable uRLDrawable) {
            this.f200868a = uRLDrawable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                CardPicGalleryActivity.this.savePicWithOverwrite(this.f200868a);
            }
        }
    }

    /* loaded from: classes11.dex */
    class e extends BaseAdapter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            ArrayList<String> arrayList = CardPicGalleryActivity.this.f200841f0;
            if (arrayList != null && i3 < arrayList.size() && i3 >= 0) {
                return CardPicGalleryActivity.this.f200841f0.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            ArrayList<String> arrayList = CardPicGalleryActivity.this.f200841f0;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            o oVar;
            URLDrawable drawable;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = CardPicGalleryActivity.this.getLayoutInflater().inflate(R.layout.asb, (ViewGroup) null);
                    oVar = new o();
                    oVar.f200882a = (URLImageView) view.findViewById(R.id.ar3);
                    view.setTag(oVar);
                } else {
                    oVar = (o) view.getTag();
                }
                String item = getItem(i3);
                CardPicGalleryActivity cardPicGalleryActivity = CardPicGalleryActivity.this;
                if (cardPicGalleryActivity.f200842g0 != 0 && cardPicGalleryActivity.f200843h0 == null) {
                    cardPicGalleryActivity.f200843h0 = cardPicGalleryActivity.getResources().getDrawable(CardPicGalleryActivity.this.f200842g0);
                }
                if (item != null) {
                    try {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        Drawable drawable2 = CardPicGalleryActivity.this.f200843h0;
                        if (drawable2 != null) {
                            drawable = URLDrawable.getDrawable(item, drawable2, drawable2);
                        } else {
                            drawable = URLDrawable.getDrawable(item, obtain);
                        }
                        oVar.f200882a.setImageDrawable(drawable);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    CardPicGalleryActivity cardPicGalleryActivity2 = CardPicGalleryActivity.this;
                    if (cardPicGalleryActivity2.f200850o0 == 1 && !cardPicGalleryActivity2.f200840e0) {
                        cardPicGalleryActivity2.f200839d0.setVisibility(8);
                    } else {
                        cardPicGalleryActivity2.f200839d0.setVisibility(0);
                    }
                } else {
                    try {
                        Drawable drawable3 = CardPicGalleryActivity.this.f200843h0;
                        if (drawable3 != null) {
                            oVar.f200882a.setImageDrawable(URLDrawable.getDrawable("https://aaa", drawable3, drawable3));
                        } else {
                            oVar.f200882a.setImageDrawable(null);
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    CardPicGalleryActivity.this.f200839d0.setVisibility(8);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* loaded from: classes11.dex */
    class f extends SVIPObserver {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onDefaultCardRsp(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16 && (obj instanceof setUserProfileRsp)) {
                int i3 = ((setUserProfileRsp) obj).ret;
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "mSvipObserver: [setUserProfileRsp] ret=" + i3);
                }
                if (i3 == 0) {
                    if (CardPicGalleryActivity.this.app != null) {
                        AllInOne allInOne = new AllInOne(CardPicGalleryActivity.this.app.getCurrentAccountUin(), 0);
                        allInOne.lastActivity = 1;
                        allInOne.profileEntryType = 8;
                        ProfileUtils.openProfileCard(CardPicGalleryActivity.this, allInOne);
                        QQToast.makeText(CardPicGalleryActivity.this, 0, R.string.i8f, 0).show();
                    }
                    CardPicGalleryActivity.this.finish();
                    return;
                }
                QQToast.makeText(CardPicGalleryActivity.this, 1, R.string.i8c, 0).show();
                return;
            }
            if ("profilelogic.setUserProfile".equals(obj)) {
                QQToast.makeText(CardPicGalleryActivity.this, 1, R.string.i8c, 0).show();
            }
        }
    }

    /* loaded from: classes11.dex */
    class g implements FriendProfilePhotoHelper.b {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
        public void notifyUser(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                QQToast.makeText(BaseApplication.getContext(), i16, i3, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
        public void onUploadResult(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            } else if (bArr != null) {
                CardPicGalleryActivity.this.n3(bArr);
            }
        }

        @Override // com.tencent.mobileqq.activity.FriendProfilePhotoHelper.b
        public void updateCover(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            } else if (bArr != null) {
                CardPicGalleryActivity.this.n3(bArr);
            }
        }
    }

    /* loaded from: classes11.dex */
    class h implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                CardPicGalleryActivity.this.f200844i0 = i3;
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

    /* loaded from: classes11.dex */
    class i implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            if (!CardPicGalleryActivity.this.isFinishing()) {
                if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                    CardPicGalleryActivity cardPicGalleryActivity = CardPicGalleryActivity.this;
                    if (cardPicGalleryActivity.f200848m0) {
                        cardPicGalleryActivity.finish();
                        return;
                    }
                }
                CardPicGalleryActivity.this.t3();
            }
        }
    }

    /* loaded from: classes11.dex */
    class j implements AdapterView.OnItemLongClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
            }
            CardPicGalleryActivity.this.showActionSheet();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f200876d;

        k(int i3) {
            this.f200876d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this, i3);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            float f16 = intValue;
            CardPicGalleryActivity.this.f200856u0.setTranslationY(f16);
            if (CardPicGalleryActivity.this.f200858w0.getBackground() != null) {
                CardPicGalleryActivity.this.f200858w0.getBackground().setAlpha((intValue / this.f200876d) * 255);
            }
            CardPicGalleryActivity.this.f200859x0.setAlpha((f16 * 1.0f) / this.f200876d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class l implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            CardPicGalleryActivity.this.f200857v0.setVisibility(0);
            if (CardPicGalleryActivity.this.f200858w0.getParent() != null) {
                ((ViewGroup) CardPicGalleryActivity.this.f200858w0.getParent()).removeView(CardPicGalleryActivity.this.f200858w0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            CardPicGalleryActivity.this.f200857v0.setVisibility(0);
            CardPicGalleryActivity.this.f200856u0.setVisibility(8);
            CardPicGalleryActivity.this.f200858w0.setVisibility(8);
            if (CardPicGalleryActivity.this.f200858w0.getParent() != null) {
                ((ViewGroup) CardPicGalleryActivity.this.f200858w0.getParent()).removeView(CardPicGalleryActivity.this.f200858w0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            CardPicGalleryActivity.this.f200857v0.setVisibility(4);
            CardPicGalleryActivity.this.f200857v0.setAlpha(1.0f);
            CardPicGalleryActivity.this.f200858w0.setVisibility(0);
            CardPicGalleryActivity.this.f200858w0.setBackgroundColor(Color.parseColor("#ff000000"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f200879d;

        m(int i3) {
            this.f200879d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this, i3);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            float f16 = intValue;
            CardPicGalleryActivity.this.f200856u0.setTranslationY(f16);
            if (CardPicGalleryActivity.this.f200858w0.getBackground() != null) {
                CardPicGalleryActivity.this.f200858w0.getBackground().setAlpha((intValue / (-this.f200879d)) * 255);
            }
            View view = CardPicGalleryActivity.this.f200859x0;
            int i3 = this.f200879d;
            float f17 = f16 * 1.0f;
            view.setAlpha((i3 + f17) / i3);
            ImageView imageView = CardPicGalleryActivity.this.f200856u0;
            int i16 = this.f200879d;
            imageView.setAlpha((i16 + f17) / i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class n implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            if (CardPicGalleryActivity.this.f200858w0.getParent() != null) {
                ((ViewGroup) CardPicGalleryActivity.this.f200858w0.getParent()).removeView(CardPicGalleryActivity.this.f200858w0);
            }
            CardPicGalleryActivity.this.finish();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            CardPicGalleryActivity.this.f200856u0.setVisibility(8);
            CardPicGalleryActivity.this.f200858w0.setVisibility(8);
            if (CardPicGalleryActivity.this.f200858w0.getParent() != null) {
                ((ViewGroup) CardPicGalleryActivity.this.f200858w0.getParent()).removeView(CardPicGalleryActivity.this.f200858w0);
            }
            CardPicGalleryActivity.this.finish();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            CardPicGalleryActivity.this.f200857v0.setVisibility(4);
            CardPicGalleryActivity.this.f200856u0.setVisibility(0);
            CardPicGalleryActivity.this.f200858w0.setVisibility(0);
            CardPicGalleryActivity.this.f200858w0.setBackgroundColor(Color.parseColor("#ff000000"));
        }
    }

    /* loaded from: classes11.dex */
    static class o {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        URLImageView f200882a;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71103);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            A0 = new String[]{"em_cover_set_qzone", "em_cover_set_album", "em_cover_set_shoot", "em_cover_set_cancel"};
        }
    }

    public CardPicGalleryActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200844i0 = -1;
        this.f200847l0 = false;
        this.f200848m0 = false;
        this.f200849n0 = false;
        this.f200850o0 = 1;
        this.f200860y0 = new e();
        this.f200861z0 = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(View view) {
        if (!shouldReport()) {
            return;
        }
        VideoReport.reportEvent("clck", view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        this.f200854s0 = ProfileCardUtils.enterSnapshot(this, 1021);
        ReportController.o(this.app, "CliOper", "", "", "0X8006A89", "0X8006A89", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "defaultcard", "photo_takeaphoto", "", 1, 0, 0, "", "", "");
    }

    private Rect V2() {
        ImageView Y2 = Y2();
        if (Y2 == null) {
            return null;
        }
        ImageView imageView = (ImageView) Y2.findViewById(R.id.ar3);
        Rect rect = new Rect();
        if (imageView == null) {
            return null;
        }
        imageView.getGlobalVisibleRect(rect);
        return rect;
    }

    private ImageView Y2() {
        View selectedView;
        Gallery gallery = this.f200838c0;
        if (gallery == null || (selectedView = gallery.getSelectedView()) == null) {
            return null;
        }
        return (ImageView) selectedView.findViewById(R.id.ar3);
    }

    private int Z2() {
        Rect V2 = V2();
        if (V2 == null) {
            return -1;
        }
        return V2.top;
    }

    private void b3(Intent intent) {
        String string = intent.getExtras().getString("guild_id");
        String string2 = intent.getExtras().getString("uin");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            if (((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getGuildInfo(string) == null) {
                QLog.e("qqBaseActivity", 1, "handlerStartGuildChartAndSendMsg guildInfo is null, id:" + string);
                return;
            }
            if (!((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome() && ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab()) {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(this, new LaunchGuildChatPieParam().l(string).b(string2).k(intent.getExtras()).r(false).a());
                return;
            }
            com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().f(string).b(string2).d(com.tencent.guild.aio.factory.a.class.getName()).a();
            if (AppSetting.t(QBaseActivity.sTopActivity)) {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(QBaseActivity.sTopActivity, a16);
            } else {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatActivity(QBaseActivity.sTopActivity, a16);
            }
        }
    }

    private void c3() {
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().clearFlags(67108864);
        getWindow().setStatusBarColor(0);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void d3(ActionSheet actionSheet) {
        if (!shouldReport()) {
            return;
        }
        VideoReport.addToDetectionWhitelist(actionSheet.getOwnerActivity());
        VideoReport.setPageId(actionSheet.mContentContainer, "pg_user_profile_cover_set");
        int childCount = actionSheet.mContentContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            e3(actionSheet, i3, childCount);
        }
    }

    private void e3(ActionSheet actionSheet, int i3, int i16) {
        Object findViewById;
        int i17 = i16 - 1;
        if (i3 < i17) {
            findViewById = actionSheet.getItemViewById(i3).titleTv;
        } else {
            findViewById = actionSheet.mContentContainer.getChildAt(i17).findViewById(R.id.action_sheet_btnCancel);
        }
        String[] strArr = A0;
        if (i3 > strArr.length) {
            return;
        }
        VideoReport.setElementId(findViewById, strArr[i3]);
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", findViewById, null);
    }

    private void f3(boolean z16, View view) {
        int i3;
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this, "pg_user_profile_coverview");
        HashMap hashMap = new HashMap();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("user_profile_host_guest_type", Integer.valueOf(i3));
        VideoReport.setPageParams(this, new PageParams(hashMap));
        VideoReport.setElementId(view, "em_coverview_top_right_set");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_FIRST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void g3(URLDrawable uRLDrawable, int i3, int i16) {
        OutputStream outputStream;
        StringBuilder sb5;
        Bitmap drawabletoBitmapV2 = BaseImageUtil.drawabletoBitmapV2(uRLDrawable, i3, i16);
        boolean z16 = false;
        Uri uri = null;
        AssetFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = 0;
        uri = null;
        if (drawabletoBitmapV2 != null && !drawabletoBitmapV2.isRecycled()) {
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = getContentResolver();
            String str = "mobileqq_card_pic_" + Long.toString(System.currentTimeMillis()) + ".jpg";
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
            Uri insert = contentResolver.insert(uri2, contentValues);
            try {
                if (insert != null) {
                    try {
                        outputStream = contentResolver.openOutputStream(insert);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        outputStream = null;
                        QLog.e("qqBaseActivity", 1, "savePicWithOverwrite, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        if (z16) {
                        }
                    } catch (IllegalStateException e17) {
                        e = e17;
                        outputStream = null;
                        QLog.e("qqBaseActivity", 1, "savePicWithOverwrite, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        if (z16) {
                        }
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        outputStream = null;
                        QLog.e("qqBaseActivity", 1, "savePicWithOverwrite, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        if (z16) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (autoCloseOutputStream != 0) {
                            try {
                                autoCloseOutputStream.close();
                            } catch (IOException e19) {
                                QLog.e("qqBaseActivity", 1, "savePicWithOverwrite finally, error = " + e19);
                            }
                        }
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                if (outputStream != null) {
                    try {
                        z16 = drawabletoBitmapV2.compress(Bitmap.CompressFormat.JPEG, 75, outputStream);
                    } catch (FileNotFoundException e26) {
                        e = e26;
                        QLog.e("qqBaseActivity", 1, "savePicWithOverwrite, error = " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e27) {
                                e = e27;
                                sb5 = new StringBuilder();
                                sb5.append("savePicWithOverwrite finally, error = ");
                                sb5.append(e);
                                QLog.e("qqBaseActivity", 1, sb5.toString());
                                if (!z16) {
                                    py3.b.e(contentResolver, insert, null, null);
                                }
                                uri = insert;
                                if (z16) {
                                }
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        if (z16) {
                        }
                    } catch (IllegalStateException e28) {
                        e = e28;
                        QLog.e("qqBaseActivity", 1, "savePicWithOverwrite, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        if (z16) {
                        }
                    } catch (OutOfMemoryError e29) {
                        e = e29;
                        QLog.e("qqBaseActivity", 1, "savePicWithOverwrite, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        if (z16) {
                        }
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e36) {
                        e = e36;
                        sb5 = new StringBuilder();
                        sb5.append("savePicWithOverwrite finally, error = ");
                        sb5.append(e);
                        QLog.e("qqBaseActivity", 1, sb5.toString());
                        if (!z16) {
                        }
                        uri = insert;
                        if (z16) {
                        }
                    }
                }
                if (!z16 && insert != null) {
                    py3.b.e(contentResolver, insert, null, null);
                }
                uri = insert;
            } catch (Throwable th6) {
                th = th6;
                autoCloseOutputStream = "image/jpeg";
            }
        }
        if (z16) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            sendBroadcast(intent);
            QQToastUtil.showQQToastInUiThread(2, HardCodeUtil.qqStr(R.string.cwj));
            return;
        }
        QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f174752wp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(byte[] bArr) {
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.f200855t0;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.k(bArr);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            u3(null);
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        CardPicGalleryActivity.this.u3(null);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    private void p3(URLDrawable uRLDrawable) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.BUSINESS_CARD_PHOTO));
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new d(uRLDrawable));
        } else {
            savePicWithOverwrite(uRLDrawable);
        }
    }

    private void r3() {
        ArrayList<String> arrayList = this.f200841f0;
        if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(this.f200841f0.get(0))) {
            this.f200856u0.setImageDrawable(URLDrawable.getDrawable(this.f200841f0.get(0), URLDrawable.URLDrawableOptions.obtain()));
            this.f200856u0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3() {
        int i3;
        if (this.f200858w0.getParent() == null) {
            addContentView(this.f200858w0, new ViewGroup.LayoutParams(-1, -1));
        }
        r3();
        int Z2 = Z2();
        Rect V2 = V2();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f200856u0.getLayoutParams();
        if (V2 == null) {
            i3 = 0;
        } else {
            i3 = V2.bottom - V2.top;
        }
        layoutParams.height = i3;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, Z2);
        ofInt.setDuration(350L);
        ofInt.addUpdateListener(new k(Z2));
        ofInt.addListener(new l());
        ofInt.start();
    }

    private void savePic(URLDrawable uRLDrawable) {
        p3(uRLDrawable);
    }

    private boolean shouldReport() {
        if (this.f200850o0 == 2 && this.f200847l0 && ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3() {
        int i3;
        if (this.f200858w0.getParent() == null) {
            addContentView(this.f200858w0, new ViewGroup.LayoutParams(-1, -1));
        }
        r3();
        int Z2 = Z2();
        Rect V2 = V2();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f200856u0.getLayoutParams();
        if (V2 == null) {
            i3 = 0;
        } else {
            i3 = V2.bottom - V2.top;
        }
        layoutParams.height = i3;
        layoutParams.topMargin = Z2;
        c3();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, -Z2);
        ofInt.setDuration(350L);
        ofInt.addUpdateListener(new m(Z2));
        ofInt.addListener(new n());
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(Card card) {
        FriendProfilePhotoHelper friendProfilePhotoHelper = this.f200855t0;
        if (friendProfilePhotoHelper != null) {
            friendProfilePhotoHelper.m(card);
        }
    }

    protected void R2(ActionSheet actionSheet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) actionSheet);
            return;
        }
        int i3 = this.f200850o0;
        if (i3 != 1) {
            if (i3 == 2) {
                if (this.f200847l0 && ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                    actionSheet.addButton(R.string.f159881ti);
                    actionSheet.addButton(R.string.f159861tg);
                    actionSheet.addButton(R.string.f159871th);
                    actionSheet.addCancelButton(R.string.cancel);
                    return;
                }
                if (this.f200846k0 > 0 && !this.f200847l0) {
                    actionSheet.addButton(R.string.bsx);
                }
                actionSheet.addButton(R.string.bsj);
                actionSheet.addButton(R.string.bst);
                actionSheet.addButton(R.string.bsh);
                actionSheet.addCancelButton(R.string.cancel);
                return;
            }
            return;
        }
        actionSheet.addButton(R.string.f171485fa3);
        if (this.f200849n0) {
            actionSheet.addButton(R.string.f_l, 3);
        }
        actionSheet.addCancelButton(R.string.cancel);
    }

    void U2(URLDrawable uRLDrawable) {
        String W2 = W2(uRLDrawable);
        try {
            if (this.app != null) {
                QfavBuilder.e0(W2).h(this, this.app.getCurrentAccountUin());
            }
            cooperation.qqfav.d.e(null, 40, 3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("qqBaseActivity", 2, "", e16);
            }
            QQToast.makeText(this, getString(R.string.bfz), 0).show();
        }
    }

    String W2(URLDrawable uRLDrawable) {
        File fileInLocal = uRLDrawable.getFileInLocal();
        if (fileInLocal == null) {
            return null;
        }
        return fileInLocal.getAbsolutePath();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 != 10) {
            if (i3 == 21) {
                if (i16 == -1) {
                    try {
                        if (intent.getExtras() != null && !intent.getExtras().isEmpty() && intent.getExtras().getInt("uintype", 0) != 10027) {
                            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
                            Bundle bundle = new Bundle(intent.getExtras());
                            m3.putExtras(bundle);
                            if (bundle.getInt("uintype", 0) == 10014) {
                                b3(m3);
                            } else {
                                startActivity(m3);
                            }
                            finish();
                            return;
                        }
                        return;
                    } catch (NullPointerException unused) {
                        QLog.i("qqBaseActivity", 1, "FORWARD_REQUEST on activity jump fail because new bundle NullPointerException");
                        return;
                    }
                }
                return;
            }
            if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit() && i3 == 1020) {
                if (i16 == -1) {
                    intent.putExtra("req_code_key", i3);
                    this.f200855t0.j(i16, intent);
                    return;
                }
                return;
            }
            if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit() && i3 == 1021 && i16 == -1) {
                intent.putExtra("req_code_key", i3);
                intent.putExtra("upload_uri_key", this.f200854s0);
                this.f200855t0.j(i16, intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = false;
        this.isClearCoverLayer = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.asa);
        if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
            this.f200855t0 = new FriendProfilePhotoHelper(this, new g());
        }
        Intent intent = getIntent();
        this.f200841f0 = intent.getStringArrayListExtra("business_card_pics");
        this.f200840e0 = intent.getBooleanExtra("is_edit_mode", false);
        this.f200850o0 = intent.getIntExtra("extra_mode", 1);
        this.f200842g0 = intent.getIntExtra("extra_default", 0);
        this.f200849n0 = intent.getBooleanExtra("is_from_profile", false);
        this.f200846k0 = intent.getIntExtra("default_card_id", 0);
        this.f200847l0 = intent.getBooleanExtra("is_from_mine_profile", false);
        this.f200848m0 = intent.getBooleanExtra("is_from_profile_edit", false);
        View findViewById = findViewById(R.id.jqb);
        this.f200836a0 = findViewById;
        z81.e.d(this, findViewById);
        TextView textView = (TextView) findViewById(R.id.a47);
        this.f200837b0 = textView;
        textView.setOnClickListener(this);
        this.f200838c0 = (Gallery) findViewById(R.id.gallery);
        ImageView imageView = (ImageView) findViewById(R.id.cqp);
        this.f200839d0 = imageView;
        imageView.setOnClickListener(this);
        if (this.f200850o0 == 1 && !this.f200840e0) {
            this.f200839d0.setVisibility(8);
        }
        this.f200838c0.setSpacing(getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.f200838c0.setAdapter((SpinnerAdapter) this.f200860y0);
        this.f200838c0.setOnItemSelectedListener(new h());
        ViewGroup viewGroup = (ViewGroup) super.findViewById(R.id.f164744ar2);
        this.f200845j0 = viewGroup;
        if (this.f200850o0 == 2) {
            String str = "";
            if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit() && this.f200848m0) {
                this.f200837b0.setText("");
            } else {
                this.f200837b0.setVisibility(8);
            }
            this.f200838c0.setOnItemClickListener(new i());
            this.f200838c0.setOnItemLongClickListener(new j());
            this.f200845j0.setOnClickListener(this);
            SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0);
            this.f200851p0 = sharedPreferences.getLong("recommend_id", 0L);
            this.f200852q0 = sharedPreferences.getString("recommend_url", "");
            this.f200853r0 = sharedPreferences.getString("recommend_desc", "");
            TextView textView2 = (TextView) this.f200845j0.findViewById(R.id.jga);
            ImageView imageView2 = (ImageView) this.f200845j0.findViewById(R.id.dgi);
            Drawable drawable = getResources().getDrawable(R.drawable.h7o);
            if (!TextUtils.isEmpty(this.f200852q0) && !TextUtils.isEmpty(this.f200853r0)) {
                textView2.setText(this.f200853r0);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = ViewUtils.dip2px(75.0f);
                obtain.mRequestHeight = ViewUtils.dip2px(80.0f);
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                imageView2.setImageDrawable(URLDrawable.getDrawable(this.f200852q0, obtain));
            } else {
                textView2.setText(HardCodeUtil.qqStr(R.string.k_h));
                imageView2.setImageDrawable(drawable);
            }
            if (this.f200847l0) {
                this.f200845j0.setVisibility(8);
            }
            QQAppInterface qQAppInterface = this.app;
            if (qQAppInterface != null) {
                str = qQAppInterface.getCurrentAccountUin();
            }
            ReportController.o(qQAppInterface, "CliOper", "", str, "card_mall", "0X8007B2A", 0, 0, String.valueOf(this.f200851p0), "", "", "");
            QQAppInterface qQAppInterface2 = this.app;
            if (this.f200847l0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800A88B", "0X800A88B", i3, 0, "", "", "", "");
        } else {
            viewGroup.setVisibility(8);
        }
        addObserver(this.f200861z0);
        this.f200857v0 = findViewById(R.id.tod);
        View inflate = LayoutInflater.from(this).inflate(R.layout.f168392fs2, (ViewGroup) null);
        this.f200858w0 = inflate;
        this.f200856u0 = (ImageView) inflate.findViewById(R.id.xi5);
        this.f200859x0 = this.f200858w0.findViewById(R.id.spt);
        if (!((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit() || !this.f200848m0) {
            this.f200857v0.setAlpha(0.0f);
            c3();
            this.f200857v0.post(new Runnable() { // from class: com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CardPicGalleryActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        CardPicGalleryActivity.this.f200857v0.setVisibility(4);
                        CardPicGalleryActivity.this.s3();
                    }
                }
            });
        }
        if (this.f200839d0.getVisibility() == 0) {
            f3(this.f200847l0, this.f200839d0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        FriendProfilePhotoHelper friendProfilePhotoHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit() && (friendProfilePhotoHelper = this.f200855t0) != null) {
            friendProfilePhotoHelper.c();
            this.f200855t0 = null;
        }
        removeObserver(this.f200861z0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
            int intExtra = intent.getIntExtra("req_code_key", 0);
            if (intExtra != 1020 && intExtra != 1021) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    intent.putExtra("req_code_key", 1025);
                    this.f200855t0.j(-1, intent);
                }
            } else {
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
                    this.f200855t0.f(intent, stringArrayListExtra2);
                }
            }
            setResult(-1, intent);
            finish();
        }
    }

    void forward(URLDrawable uRLDrawable, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        String W2 = W2(uRLDrawable);
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, W2);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, uRLDrawable.getURL().toString());
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, W2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(this, intent, 21);
    }

    protected void h3(ActionSheet actionSheet, int i3, URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, actionSheet, Integer.valueOf(i3), uRLDrawable);
            return;
        }
        int i16 = this.f200850o0;
        if (i16 != 1) {
            if (i16 == 2) {
                if (this.f200847l0 && ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                    j3(actionSheet, i3);
                    return;
                } else {
                    i3(i3, uRLDrawable);
                    return;
                }
            }
            return;
        }
        l3(i3, uRLDrawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void i3(int i3, URLDrawable uRLDrawable) {
        int i16;
        String str;
        String str2;
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) uRLDrawable);
            return;
        }
        int i17 = this.f200846k0;
        if (i17 == 0 || this.f200847l0) {
            i3++;
        }
        String str3 = "";
        if (i3 != 0) {
            i16 = 1;
            if (i3 != 1) {
                i16 = 2;
                if (i3 != 2) {
                    i16 = 3;
                    if (i3 != 3) {
                        i16 = 0;
                    } else {
                        U2(uRLDrawable);
                        QQAppInterface qQAppInterface2 = this.app;
                        if (qQAppInterface2 != null) {
                            str3 = qQAppInterface2.getCurrentAccountUin();
                        }
                        VasWebviewUtil.reportCommercialDrainage(str3, "defaultcard", QCircleDaTongConstant.ElementParamValue.COLLECT, "", 1, 0, 0, "", Integer.toString(this.f200846k0), "");
                    }
                } else {
                    savePic(uRLDrawable);
                    QQAppInterface qQAppInterface3 = this.app;
                    if (qQAppInterface3 != null) {
                        str3 = qQAppInterface3.getCurrentAccountUin();
                    }
                    VasWebviewUtil.reportCommercialDrainage(str3, "defaultcard", "save", "", 1, 0, 0, "", Integer.toString(this.f200846k0), "");
                }
            } else {
                ArrayList<String> arrayList = this.f200841f0;
                if (arrayList != null && this.f200844i0 >= 0) {
                    int size = arrayList.size();
                    int i18 = this.f200844i0;
                    if (size > i18) {
                        str2 = this.f200841f0.get(i18);
                        forward(uRLDrawable, str2);
                        qQAppInterface = this.app;
                        if (qQAppInterface != null) {
                            str3 = qQAppInterface.getCurrentAccountUin();
                        }
                        VasWebviewUtil.reportCommercialDrainage(str3, "defaultcard", "send", "", 1, 0, 0, "", Integer.toString(this.f200846k0), "");
                    }
                }
                str2 = "";
                forward(uRLDrawable, str2);
                qQAppInterface = this.app;
                if (qQAppInterface != null) {
                }
                VasWebviewUtil.reportCommercialDrainage(str3, "defaultcard", "send", "", 1, 0, 0, "", Integer.toString(this.f200846k0), "");
            }
        } else {
            QQAppInterface qQAppInterface4 = this.app;
            if (qQAppInterface4 != null && i17 > 0) {
                ((ISVIPHandler) qQAppInterface4.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setDefaultCardId(this.f200846k0);
                QQAppInterface qQAppInterface5 = this.app;
                if (qQAppInterface5 != null) {
                    str3 = qQAppInterface5.getCurrentAccountUin();
                }
                VasWebviewUtil.reportCommercialDrainage(str3, "defaultcard", "set_mydefaultcard", "", 1, 0, 0, "", Integer.toString(this.f200846k0), "");
            }
            i16 = 5;
        }
        int i19 = i16;
        QQAppInterface qQAppInterface6 = this.app;
        if (this.f200847l0) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(qQAppInterface6, "dc00898", "", "", "0X800A88C", "0X800A88C", i19, 0, str, "", "", "");
    }

    protected void j3(ActionSheet actionSheet, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) actionSheet, i3);
            return;
        }
        S2(actionSheet.getItemViewById(i3).titleTv);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.BUSINESS_CARD_PHOTO));
                    if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
                        return;
                    } else {
                        T2();
                        return;
                    }
                }
                return;
            }
            Intent intent = new Intent(this, (Class<?>) NewPhotoListActivity.class);
            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 44);
            intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationProfileCustomCover.F);
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
            intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, false);
            intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
            intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
            intent.putExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
            intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
            int s16 = ProfileCardUtil.s(this);
            int q16 = ProfileCardUtil.q(this);
            intent.putExtra(PeakConstants.CLIP_WIDTH, s16);
            intent.putExtra(PeakConstants.CLIP_HEIGHT, q16);
            intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
            intent.putExtra(PeakConstants.TARGET_WIDTH, s16);
            intent.putExtra(PeakConstants.TARGET_HEIGHT, q16);
            intent.putExtra(PeakConstants.TARGET_PATH, ProfileCardUtil.r());
            intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
            intent.putExtra(IProfileCardConst.KEY_COVER_PICK_GALLERY, true);
            startActivity(intent);
            QAlbumUtil.anim(this, false, true);
            ReportController.o(this.app, "CliOper", "", "", "0X8006A87", "0X8006A87", 0, 0, "", "", "", "");
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "defaultcard", "photo_album", "", 1, 0, 0, "", "", "");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_personal_album_enter_model", 2);
        bundle.putInt("_input_max", 1);
        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, true);
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = this.app.getCurrentAccountUin();
        bundle.putString("keyAction", "actionSelectPicture");
        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
        QZoneHelper.forwardToPersonalAlbumSelect(this, userInfo, bundle, 1020);
        ReportController.o(this.app, "CliOper", "", "", "0X8006A88", "0X8006A88", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "defaultcard", "photo_qzone", "", 1, 0, 0, "", "", "");
    }

    protected void l3(int i3, URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) uRLDrawable);
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                Intent intent = new Intent();
                intent.putExtra("delete_pic", true);
                setResult(-1, intent);
                finish();
                return;
            }
            return;
        }
        savePic(uRLDrawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit() && this.f200848m0) {
            finish();
            return true;
        }
        t3();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view == this.f200839d0) {
            S2(view);
            showActionSheet();
        } else if (view == this.f200837b0) {
            onBackEvent();
        } else if (view == this.f200845j0) {
            ProfileCardUtil.E(this, this.app.getCurrentAccountUin(), "inside.friendCardBackground", 1, 1, 1, "recommendId=" + this.f200851p0, false);
            QQAppInterface qQAppInterface = this.app;
            String str2 = "";
            if (qQAppInterface == null) {
                str = "";
            } else {
                str = qQAppInterface.getCurrentAccountUin();
            }
            ReportController.o(qQAppInterface, "CliOper", "", str, "card_mall", "0X8004DC0", 0, 0, String.valueOf(this.f200851p0), "", "", "");
            QQAppInterface qQAppInterface2 = this.app;
            if (qQAppInterface2 != null) {
                str2 = qQAppInterface2.getCurrentAccountUin();
            }
            VasWebviewUtil.reportCommercialDrainage(str2, "defaultcard", "click_card_others", "", 1, 0, 0, "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (82 == keyEvent.getKeyCode()) {
            showActionSheet();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    void savePicWithOverwrite(final URLDrawable uRLDrawable) {
        if (uRLDrawable.getStatus() != 1) {
            return;
        }
        ImageView imageView = (ImageView) findViewById(R.id.ar3);
        final int measuredWidth = imageView.getMeasuredWidth();
        final int measuredHeight = imageView.getMeasuredHeight();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.businessCard.activity.a
            @Override // java.lang.Runnable
            public final void run() {
                CardPicGalleryActivity.this.g3(uRLDrawable, measuredWidth, measuredHeight);
            }
        }, 64, null, true);
    }

    protected void showActionSheet() {
        Gallery gallery;
        View selectedView;
        Drawable drawable;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if ((this.f200850o0 != 1 || this.f200840e0) && (gallery = this.f200838c0) != null && (selectedView = gallery.getSelectedView()) != null && (drawable = ((ImageView) selectedView.findViewById(R.id.ar3)).getDrawable()) != null && (drawable instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (this.f200843h0 == null && uRLDrawable.getStatus() != 1) {
                return;
            }
            ActionSheet create = ActionSheet.create(this);
            R2(create);
            create.setOnButtonClickListener(new b(create, uRLDrawable));
            create.setOnBottomCancelListener(new c(create));
            create.show();
            d3(create);
            if (2 == this.f200850o0) {
                QQAppInterface qQAppInterface = this.app;
                if (qQAppInterface != null) {
                    str = qQAppInterface.getCurrentAccountUin();
                } else {
                    str = "";
                }
                VasWebviewUtil.reportCommercialDrainage(str, "defaultcard", "click_more", "", 1, 0, 0, "", Integer.toString(this.f200846k0), "");
            }
        }
    }
}
