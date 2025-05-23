package com.tencent.mobileqq.profile.PersonalityLabel;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileKoiLikeApi;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.bs;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes16.dex */
public class PersonalityLabelGalleryActivity extends IphoneTitleBarActivity implements View.OnClickListener, Handler.Callback, PLUploadManager.b {
    static IPatchRedirector $redirector_;
    private boolean A0;
    private boolean B0;
    private ConcurrentHashMap<Long, byte[]> C0;
    private ConcurrentHashMap<Long, Integer> D0;
    HashSet<Long> E0;
    boolean F0;
    Drawable G0;
    QQToast H0;
    QQToast I0;
    Handler J0;
    Handler K0;
    boolean L0;
    int M0;
    TextPaint N0;
    boolean O0;
    boolean P0;
    volatile boolean Q0;
    FriendListHandler R0;
    protected TopGestureLayout S0;
    PLUploadManager T0;
    ActionSheet U0;
    int V0;
    BroadcastReceiver W0;
    private com.tencent.mobileqq.profile.PersonalityLabel.c X0;
    ar Y0;
    QQProgressDialog.b Z0;

    /* renamed from: a0, reason: collision with root package name */
    private float f259808a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f259809b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f259810c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f259811d0;

    /* renamed from: e0, reason: collision with root package name */
    private XListView f259812e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f259813f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f259814g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f259815h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f259816i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f259817j0;

    /* renamed from: k0, reason: collision with root package name */
    private ViewStub f259818k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f259819l0;

    /* renamed from: m0, reason: collision with root package name */
    private Button f259820m0;

    /* renamed from: n0, reason: collision with root package name */
    private Button f259821n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f259822o0;

    /* renamed from: p0, reason: collision with root package name */
    private Button f259823p0;

    /* renamed from: q0, reason: collision with root package name */
    private TextView f259824q0;

    /* renamed from: r0, reason: collision with root package name */
    private ListViewAdapter f259825r0;

    /* renamed from: s0, reason: collision with root package name */
    QQProgressDialog f259826s0;

    /* renamed from: t0, reason: collision with root package name */
    private ProfilePersonalityLabelInfo f259827t0;

    /* renamed from: u0, reason: collision with root package name */
    private ConcurrentHashMap<Long, PersonalityLabelInfo> f259828u0;

    /* renamed from: v0, reason: collision with root package name */
    private long f259829v0;

    /* renamed from: w0, reason: collision with root package name */
    private List<String> f259830w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f259831x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f259832y0;

    /* renamed from: z0, reason: collision with root package name */
    private AllInOne f259833z0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class ListViewAdapter extends BaseAdapter implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* loaded from: classes16.dex */
        class a extends RecyclerView.OnScrollListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PersonalityLabelInfo f259843d;

            a(PersonalityLabelInfo personalityLabelInfo) {
                this.f259843d = personalityLabelInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ListViewAdapter.this, (Object) personalityLabelInfo);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, i3);
                } else if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelGalleryActivity", 2, "onScrollStateChanged newState:" + i3);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z16 = false;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelGalleryActivity", 2, "onScrolled dx:" + i3 + " dy:" + i16);
                }
                if (i3 > 0) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                    int childCount = staggeredGridLayoutManager.getChildCount();
                    int itemCount = staggeredGridLayoutManager.getItemCount();
                    int i17 = staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0];
                    Object obj = PersonalityLabelGalleryActivity.this.D0.get(Long.valueOf(this.f259843d.f259897id));
                    if (obj != null && ((Integer) obj).intValue() == 1) {
                        z16 = true;
                    }
                    if (!PersonalityLabelGalleryActivity.this.B0 && !z16 && childCount > 0 && i17 >= itemCount - 1) {
                        PersonalityLabelGalleryActivity.this.B0 = true;
                        QLog.i("PersonalityLabelGalleryActivity", 2, "load more photos");
                        PersonalityLabelHandler personalityLabelHandler = (PersonalityLabelHandler) PersonalityLabelGalleryActivity.this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL);
                        if (!PersonalityLabelGalleryActivity.this.f259811d0) {
                            str = PersonalityLabelGalleryActivity.this.f259809b0;
                        } else {
                            str = PersonalityLabelGalleryActivity.this.app.getCurrentAccountUin();
                        }
                        personalityLabelHandler.G2(str, this.f259843d.f259897id, 20, (byte[]) PersonalityLabelGalleryActivity.this.C0.get(Long.valueOf(this.f259843d.f259897id)));
                    }
                }
            }
        }

        /* loaded from: classes16.dex */
        class b implements ActionSheet.OnButtonClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PersonalityLabelInfo f259845d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ActionSheet f259846e;

            b(PersonalityLabelInfo personalityLabelInfo, ActionSheet actionSheet) {
                this.f259845d = personalityLabelInfo;
                this.f259846e = actionSheet;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ListViewAdapter.this, personalityLabelInfo, actionSheet);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                    return;
                }
                if (i3 == 0) {
                    ListViewAdapter.this.c(this.f259845d);
                } else if (i3 == 1) {
                    PersonalityLabelGalleryActivity.this.f259829v0 = this.f259845d.f259897id;
                    ListViewAdapter.this.b(this.f259845d);
                }
                this.f259846e.superDismiss();
            }
        }

        /* loaded from: classes16.dex */
        class c implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f259848d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ PersonalityLabelInfo f259849e;

            c(View view, PersonalityLabelInfo personalityLabelInfo) {
                this.f259848d = view;
                this.f259849e = personalityLabelInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ListViewAdapter.this, view, personalityLabelInfo);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                m mVar = (m) this.f259848d.getTag(R.id.bf5);
                if (mVar != null) {
                    PersonalityLabelGalleryActivity.this.C3(mVar.f259885m, this.f259849e.f259897id);
                }
            }
        }

        /* loaded from: classes16.dex */
        class d implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ListViewAdapter.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }

        ListViewAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(PersonalityLabelInfo personalityLabelInfo) {
            Intent intent = new Intent();
            intent.setClass(PersonalityLabelGalleryActivity.this, NewPhotoListActivity.class);
            intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 48);
            intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(9, Math.max(PersonalityLabelGalleryActivity.this.f259827t0.maxPhotoCount - personalityLabelInfo.photoCount, 0)));
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", PersonalityLabelGalleryActivity.this.getClass().getName());
            intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
            intent.putExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
            intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, false);
            intent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
            intent.putExtra("label_id", personalityLabelInfo.f259897id);
            PersonalityLabelGalleryActivity.this.startActivity(intent);
            QAlbumUtil.anim(PersonalityLabelGalleryActivity.this, false, true);
        }

        private void d(m mVar, PersonalityLabelInfo personalityLabelInfo) {
            int i3;
            PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
            if (personalityLabelGalleryActivity.L0) {
                if (mVar.f259877e.getVisibility() != 8) {
                    mVar.f259877e.setVisibility(8);
                }
                if (mVar.f259878f.getVisibility() != 0) {
                    mVar.f259878f.setVisibility(0);
                }
                if (mVar.f259880h.getVisibility() != 8) {
                    mVar.f259880h.setVisibility(8);
                }
                if (mVar.f259879g.getVisibility() != 0) {
                    mVar.f259879g.setVisibility(0);
                }
                mVar.f259876d.setTag(personalityLabelInfo);
                mVar.f259876d.setOnClickListener(this);
                mVar.f259876d.setTag(R.id.f164032hq, 4);
                mVar.f259876d.setTag(R.id.bf5, mVar);
            } else if (personalityLabelGalleryActivity.f259811d0) {
                if (mVar.f259877e.getVisibility() != 0) {
                    mVar.f259877e.setVisibility(0);
                }
                if (mVar.f259878f.getVisibility() != 0) {
                    mVar.f259878f.setVisibility(0);
                }
                if (mVar.f259880h.getVisibility() != 8) {
                    mVar.f259880h.setVisibility(8);
                }
                if (mVar.f259879g.getVisibility() != 8) {
                    mVar.f259879g.setVisibility(8);
                }
                mVar.f259876d.setTag(personalityLabelInfo);
                mVar.f259876d.setOnClickListener(this);
                mVar.f259876d.setTag(R.id.f164032hq, 1);
            } else {
                if (mVar.f259877e.getVisibility() != 8) {
                    mVar.f259877e.setVisibility(8);
                }
                if (mVar.f259878f.getVisibility() != 8) {
                    mVar.f259878f.setVisibility(8);
                }
                if (mVar.f259880h.getVisibility() != 0) {
                    mVar.f259880h.setVisibility(0);
                }
                if (mVar.f259879g.getVisibility() != 8) {
                    mVar.f259879g.setVisibility(8);
                }
                mVar.f259876d.setTag(personalityLabelInfo);
                mVar.f259876d.setOnClickListener(this);
                mVar.f259876d.setTag(R.id.f164032hq, 3);
            }
            ImageView imageView = mVar.f259878f;
            if (PersonalityLabelGalleryActivity.this.L0) {
                i3 = R.drawable.afu;
            } else {
                i3 = R.drawable.afo;
            }
            imageView.setImageResource(i3);
        }

        private void e(m mVar, PersonalityLabelInfo personalityLabelInfo) {
            int i3;
            if (mVar.f259877e.getVisibility() != 8) {
                mVar.f259877e.setVisibility(8);
            }
            mVar.f259876d.setTag(personalityLabelInfo);
            mVar.f259876d.setOnClickListener(this);
            PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
            if (personalityLabelGalleryActivity.L0) {
                f(mVar);
            } else if (personalityLabelGalleryActivity.f259811d0) {
                g(mVar);
            } else {
                h(mVar);
            }
            ImageView imageView = mVar.f259878f;
            if (PersonalityLabelGalleryActivity.this.L0) {
                i3 = R.drawable.afu;
            } else {
                i3 = R.drawable.afo;
            }
            imageView.setImageResource(i3);
        }

        private void f(m mVar) {
            if (mVar.f259878f.getVisibility() != 0) {
                mVar.f259878f.setVisibility(0);
            }
            if (mVar.f259880h.getVisibility() != 8) {
                mVar.f259880h.setVisibility(8);
            }
            if (mVar.f259879g.getVisibility() != 0) {
                mVar.f259879g.setVisibility(0);
            }
            mVar.f259876d.setTag(R.id.f164032hq, 4);
            mVar.f259876d.setTag(R.id.bf5, mVar);
        }

        private void g(m mVar) {
            if (mVar.f259878f.getVisibility() != 8) {
                mVar.f259878f.setVisibility(8);
            }
            if (mVar.f259880h.getVisibility() != 8) {
                mVar.f259880h.setVisibility(8);
            }
            if (mVar.f259879g.getVisibility() != 8) {
                mVar.f259879g.setVisibility(8);
            }
            mVar.f259876d.setTag(R.id.f164032hq, 1);
        }

        private void h(m mVar) {
            if (mVar.f259878f.getVisibility() != 8) {
                mVar.f259878f.setVisibility(8);
            }
            if (mVar.f259879g.getVisibility() != 8) {
                mVar.f259879g.setVisibility(8);
            }
            if (mVar.f259880h.getVisibility() != 0) {
                mVar.f259880h.setVisibility(0);
            }
            mVar.f259876d.setTag(R.id.f164032hq, 3);
        }

        public void b(PersonalityLabelInfo personalityLabelInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) personalityLabelInfo);
                return;
            }
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = PersonalityLabelGalleryActivity.this.app.getCurrentAccountUin();
            userInfo.nickname = PersonalityLabelGalleryActivity.this.app.getCurrentNickname();
            Bundle bundle = new Bundle();
            bundle.putString("key_title", PersonalityLabelGalleryActivity.this.getString(R.string.gjv));
            bundle.putInt("key_personal_album_enter_model", 1);
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, true);
            bundle.putInt("_input_max", Math.min(9, Math.max(PersonalityLabelGalleryActivity.this.f259827t0.maxPhotoCount - personalityLabelInfo.photoCount, 0)));
            bundle.putBoolean("show_album", false);
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
            QZoneHelper.forwardToPersonalAlbumSelect(PersonalityLabelGalleryActivity.this, userInfo, bundle, 1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (PersonalityLabelGalleryActivity.this.f259827t0 != null && PersonalityLabelGalleryActivity.this.f259827t0.personalityLabelInfos != null) {
                return PersonalityLabelGalleryActivity.this.f259827t0.personalityLabelInfos.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            if (PersonalityLabelGalleryActivity.this.f259827t0 != null && PersonalityLabelGalleryActivity.this.f259827t0.personalityLabelInfos != null) {
                return PersonalityLabelGalleryActivity.this.f259827t0.personalityLabelInfos.get(i3);
            }
            return null;
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
            m mVar;
            View view2;
            int color;
            boolean z16;
            boolean booleanValue;
            int i16;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (view == null) {
                    view2 = PersonalityLabelGalleryActivity.this.getLayoutInflater().inflate(R.layout.ayy, viewGroup, false);
                    mVar = new m();
                    mVar.f259875c = view2.findViewById(R.id.czp);
                    mVar.f259874b = (TextView) view2.findViewById(R.id.e1s);
                    mVar.f259876d = view2.findViewById(R.id.f164501zx);
                    mVar.f259877e = (ImageView) view2.findViewById(R.id.f164032hq);
                    mVar.f259878f = (ImageView) view2.findViewById(R.id.f164033hr);
                    mVar.f259879g = (ImageView) view2.findViewById(R.id.bf5);
                    mVar.f259880h = (ImageView) view2.findViewById(R.id.l77);
                    mVar.f259881i = (GlowCountRecyclerView) view2.findViewById(R.id.i4m);
                    mVar.f259882j = (TextView) view2.findViewById(R.id.l79);
                    mVar.f259883k = view2.findViewById(R.id.jni);
                    mVar.f259884l = view2.findViewById(R.id.b8q);
                    mVar.f259883k.setOnClickListener(this);
                    mVar.f259883k.setTag(R.id.f164032hq, 5);
                    if (!PersonalityLabelGalleryActivity.this.f259811d0) {
                        mVar.f259882j.setTextColor(Color.parseColor("#777777"));
                    }
                    mVar.f259881i.setTextSizeDp(12);
                    mVar.f259881i.addItemDecoration(new l());
                    view2.setTag(mVar);
                } else {
                    mVar = (m) view.getTag();
                    view2 = view;
                }
                TextView textView = (TextView) view2.findViewById(R.id.sdi);
                if (QQTheme.isNowThemeIsNight()) {
                    color = -1;
                } else {
                    color = PersonalityLabelGalleryActivity.this.getResources().getColor(R.color.skin_color_white);
                }
                textView.setTextColor(color);
                mVar.f259885m = view2;
                PersonalityLabelInfo personalityLabelInfo = (PersonalityLabelInfo) getItem(i3);
                if (personalityLabelInfo == null) {
                    QLog.d("PersonalityLabelGalleryActivity", 1, "getView labelInfo == null");
                } else {
                    mVar.f259873a = personalityLabelInfo.f259897id;
                    Integer num = (Integer) mVar.f259875c.getTag(R.id.e1s);
                    if (((IProfileKoiLikeApi) QRoute.api(IProfileKoiLikeApi.class)).isSpecialPersonalLabel(personalityLabelInfo.f259897id)) {
                        int specialPersonalLabelTextColor = ((IProfileKoiLikeApi) QRoute.api(IProfileKoiLikeApi.class)).getSpecialPersonalLabelTextColor(personalityLabelInfo.f259897id);
                        if (num == null || num.intValue() != specialPersonalLabelTextColor) {
                            mVar.f259875c.setBackgroundDrawable(new ColorDrawable(specialPersonalLabelTextColor));
                            mVar.f259874b.setTextColor(specialPersonalLabelTextColor);
                            mVar.f259875c.setTag(R.id.e1s, Integer.valueOf(specialPersonalLabelTextColor));
                        }
                    } else if (num == null || num.intValue() != personalityLabelInfo.bgColor) {
                        mVar.f259875c.setBackgroundDrawable(new ColorDrawable(personalityLabelInfo.bgColor));
                        mVar.f259874b.setTextColor(personalityLabelInfo.bgColor);
                        mVar.f259875c.setTag(R.id.e1s, Integer.valueOf(personalityLabelInfo.bgColor));
                    }
                    if (!mVar.f259874b.getText().equals(personalityLabelInfo.text)) {
                        mVar.f259874b.setText(personalityLabelInfo.text);
                    }
                    if (((IProfileKoiLikeApi) QRoute.api(IProfileKoiLikeApi.class)).isSpecialPersonalLabel(personalityLabelInfo.f259897id)) {
                        e(mVar, personalityLabelInfo);
                    } else {
                        d(mVar, personalityLabelInfo);
                    }
                    mVar.f259876d.setTag(R.id.l79, mVar);
                    if (!PersonalityLabelGalleryActivity.this.f259811d0) {
                        if (personalityLabelInfo.praiseFlag > 0) {
                            mVar.f259880h.setImageResource(R.drawable.f161817f20);
                        } else {
                            mVar.f259880h.setImageResource(R.drawable.f161813ag0);
                        }
                    }
                    if (PersonalityLabelGalleryActivity.this.f259811d0) {
                        mVar.f259882j.setOnClickListener(this);
                        mVar.f259882j.setTag(personalityLabelInfo);
                        mVar.f259882j.setTag(R.id.f164032hq, 2);
                    }
                    i(personalityLabelInfo, mVar);
                    boolean z36 = PersonalityLabelGalleryActivity.this.z3(i3);
                    if (z36) {
                        PersonalityLabelGalleryActivity.this.P0 = true;
                    }
                    if (mVar.f259883k.getVisibility() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z36 != z16) {
                        View view4 = mVar.f259883k;
                        if (z36) {
                            i16 = 0;
                        } else {
                            i16 = 8;
                        }
                        view4.setVisibility(i16);
                    }
                    mVar.f259881i.setLayoutManager(new StaggeredGridLayoutManager(1, 0));
                    mVar.f259881i.setAdapter(new n(personalityLabelInfo.f259897id));
                    mVar.f259881i.setText(personalityLabelInfo.photoCount + "\u5f20");
                    TopGestureLayout topGestureLayout = PersonalityLabelGalleryActivity.this.S0;
                    List<PersonalityLabelPhoto> list = personalityLabelInfo.personalityLabelPhotos;
                    if (list != null && list.size() > 0) {
                        mVar.f259881i.setVisibility(0);
                        mVar.f259881i.setOnScrollListener(new a(personalityLabelInfo));
                    } else {
                        mVar.f259881i.setVisibility(8);
                    }
                    Object tag = mVar.f259884l.getTag();
                    if (tag == null) {
                        booleanValue = false;
                    } else {
                        booleanValue = ((Boolean) tag).booleanValue();
                    }
                    boolean contains = PersonalityLabelGalleryActivity.this.E0.contains(Long.valueOf(personalityLabelInfo.f259897id));
                    if (contains != booleanValue) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mVar.f259884l.getLayoutParams();
                        if (!contains) {
                            i17 = -2;
                        }
                        layoutParams.height = i17;
                        mVar.f259884l.setLayoutParams(layoutParams);
                        mVar.f259884l.setTag(Boolean.valueOf(contains));
                    }
                    if (PersonalityLabelGalleryActivity.this.E0.size() > 0) {
                        PersonalityLabelGalleryActivity.this.K0.post(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ListViewAdapter.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    PersonalityLabelGalleryActivity.this.D3();
                                }
                            }
                        });
                    }
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        void i(PersonalityLabelInfo personalityLabelInfo, m mVar) {
            String string;
            QQAppInterface qQAppInterface;
            String charSequence = mVar.f259882j.getText().toString();
            float f16 = 0.5f;
            if (personalityLabelInfo.praiseCount > 0) {
                PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                if (personalityLabelGalleryActivity.M0 <= 0) {
                    personalityLabelGalleryActivity.M0 = (int) (personalityLabelGalleryActivity.getResources().getDisplayMetrics().widthPixels - (PersonalityLabelGalleryActivity.this.f259808a0 * 95.0f));
                }
                PersonalityLabelGalleryActivity personalityLabelGalleryActivity2 = PersonalityLabelGalleryActivity.this;
                if (personalityLabelGalleryActivity2.N0 == null) {
                    personalityLabelGalleryActivity2.N0 = new TextPaint();
                }
                PersonalityLabelGalleryActivity personalityLabelGalleryActivity3 = PersonalityLabelGalleryActivity.this;
                personalityLabelGalleryActivity3.N0.setTextSize(personalityLabelGalleryActivity3.f259808a0 * 14.0f);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(personalityLabelInfo.praiseCount);
                sb5.insert(0, "\u5171").append("\u4e2a\u8d5e");
                int measureText = (int) (PersonalityLabelGalleryActivity.this.N0.measureText(sb5.toString()) + 0.5f);
                StringBuilder sb6 = new StringBuilder();
                for (int i3 = 0; i3 < personalityLabelInfo.zanUins.size(); i3++) {
                    String str = personalityLabelInfo.zanUins.get(i3).nick;
                    if (TextUtils.isEmpty(str) && (qQAppInterface = PersonalityLabelGalleryActivity.this.app) != null) {
                        str = ac.F(qQAppInterface, String.valueOf(personalityLabelInfo.zanUins.get(i3).uin));
                    }
                    sb6.append(str);
                    if (i3 == personalityLabelInfo.zanUins.size() - 1) {
                        sb6.append("\uff0c");
                    } else {
                        sb6.append("\u3001");
                    }
                }
                string = TextUtils.ellipsize(sb6.toString(), PersonalityLabelGalleryActivity.this.N0, r4.M0 - measureText, TextUtils.TruncateAt.END).toString() + sb5.toString();
            } else {
                string = PersonalityLabelGalleryActivity.this.getResources().getString(R.string.fpn);
            }
            if (!TextUtils.equals(string, charSequence)) {
                mVar.f259882j.setText(string);
            }
            TextView textView = mVar.f259882j;
            if (!PersonalityLabelGalleryActivity.this.L0) {
                f16 = 1.0f;
            }
            textView.setAlpha(f16);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String format;
            String F;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag(R.id.f164032hq);
                if (tag != null && (tag instanceof Integer)) {
                    int intValue = ((Integer) tag).intValue();
                    if (intValue == 1) {
                        PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                        if (personalityLabelGalleryActivity.O0) {
                            personalityLabelGalleryActivity.O0 = false;
                            personalityLabelGalleryActivity.J3();
                            if (PersonalityLabelGalleryActivity.this.K0.hasMessages(2)) {
                                PersonalityLabelGalleryActivity.this.K0.removeMessages(2);
                            }
                            PersonalityLabelGalleryActivity.this.K0.sendEmptyMessage(2);
                        }
                        PersonalityLabelInfo personalityLabelInfo = (PersonalityLabelInfo) view.getTag();
                        if (personalityLabelInfo != null) {
                            ActionSheet create = ActionSheet.create(view.getContext());
                            create.addButton("\u4ece\u624b\u673a\u76f8\u518c\u9009\u62e9");
                            create.addButton("\u4ece\u7a7a\u95f4\u76f8\u518c\u9009\u62e9");
                            create.addCancelButton("\u53d6\u6d88");
                            create.setOnButtonClickListener(new b(personalityLabelInfo, create));
                            create.show();
                            ReportController.o(PersonalityLabelGalleryActivity.this.app, "dc00898", "", "", "0X8007FD2", "0X8007FD2", 0, 0, "", "", "", "");
                        }
                    } else if (intValue == 2) {
                        if (!PersonalityLabelGalleryActivity.this.L0) {
                            PersonalityLabelInfo personalityLabelInfo2 = (PersonalityLabelInfo) view.getTag();
                            Intent intent = new Intent(PersonalityLabelGalleryActivity.this, (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/labzan?_wv=1027&labelId=" + personalityLabelInfo2.f259897id);
                            PersonalityLabelGalleryActivity.this.startActivity(intent);
                        }
                    } else if (intValue == 3) {
                        PersonalityLabelInfo personalityLabelInfo3 = (PersonalityLabelInfo) view.getTag();
                        if (personalityLabelInfo3.praiseFlag <= 0) {
                            ((PersonalityLabelHandler) PersonalityLabelGalleryActivity.this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).P2(PersonalityLabelGalleryActivity.this.f259809b0, personalityLabelInfo3.f259897id);
                            personalityLabelInfo3.praiseFlag = 1;
                            personalityLabelInfo3.praiseCount++;
                            int size = personalityLabelInfo3.zanUins.size();
                            PersonalityLabelZan personalityLabelZan = null;
                            if (size > 0) {
                                for (int i3 = size - 1; i3 >= 0; i3--) {
                                    if (personalityLabelInfo3.zanUins.get(i3).uin == Long.valueOf(PersonalityLabelGalleryActivity.this.getCurrentAccountUin()).longValue()) {
                                        personalityLabelZan = personalityLabelInfo3.zanUins.remove(i3);
                                    }
                                }
                            }
                            PersonalityLabelZan personalityLabelZan2 = new PersonalityLabelZan();
                            personalityLabelZan2.uin = Long.valueOf(PersonalityLabelGalleryActivity.this.getCurrentAccountUin()).longValue();
                            if (personalityLabelZan != null) {
                                F = personalityLabelZan.nick;
                            } else {
                                QQAppInterface qQAppInterface = PersonalityLabelGalleryActivity.this.app;
                                F = ac.F(qQAppInterface, qQAppInterface.getCurrentAccountUin());
                            }
                            personalityLabelZan2.nick = F;
                            personalityLabelInfo3.zanUins.add(0, personalityLabelZan2);
                            i(personalityLabelInfo3, (m) view.getTag(R.id.l79));
                            ((ImageView) view.findViewById(R.id.l77)).setImageResource(R.drawable.f161817f20);
                            PersonalityLabelGalleryActivity.this.A0 = true;
                            if (PersonalityLabelGalleryActivity.this.J0.hasMessages(0)) {
                                PersonalityLabelGalleryActivity.this.J0.removeMessages(0);
                            }
                            PersonalityLabelGalleryActivity personalityLabelGalleryActivity2 = PersonalityLabelGalleryActivity.this;
                            PersonalityLabelGalleryActivity.this.J0.sendMessageDelayed(personalityLabelGalleryActivity2.J0.obtainMessage(0, personalityLabelGalleryActivity2.f259827t0), 500L);
                            ReportController.o(PersonalityLabelGalleryActivity.this.app, "dc00898", "", "", "0X8007FD0", "0X8007FD0", 0, 0, "", "", "", "");
                        } else {
                            PersonalityLabelGalleryActivity personalityLabelGalleryActivity3 = PersonalityLabelGalleryActivity.this;
                            if (personalityLabelGalleryActivity3.H0 == null) {
                                personalityLabelGalleryActivity3.H0 = QQToast.makeText(personalityLabelGalleryActivity3, "\u6bcf\u4e2a\u6807\u7b7e\u6bcf\u5929\u53ea\u80fd\u70b9\u4e00\u4e2a\u8d5e\u54e6\u3002", 0);
                            }
                            if (!PersonalityLabelGalleryActivity.this.H0.isShowing()) {
                                PersonalityLabelGalleryActivity personalityLabelGalleryActivity4 = PersonalityLabelGalleryActivity.this;
                                personalityLabelGalleryActivity4.H0.show(personalityLabelGalleryActivity4.getTitleBarHeight());
                            }
                        }
                    } else if (intValue == 4) {
                        PersonalityLabelInfo personalityLabelInfo4 = (PersonalityLabelInfo) view.getTag();
                        int i16 = personalityLabelInfo4.photoCount;
                        if (i16 > 0) {
                            format = String.format("\u786e\u8ba4\u5220\u9664\u6807\u7b7e \u201c%s\u201d\uff0c\u5176\u4e2d\u5305\u542b%d\u5f20\u7167\u7247\uff1f", personalityLabelInfo4.text, Integer.valueOf(i16));
                        } else {
                            format = String.format("\u786e\u8ba4\u5220\u9664\u6807\u7b7e \u201c%s\u201d\uff1f", personalityLabelInfo4.text);
                        }
                        DialogUtil.createNoTitleDialog(PersonalityLabelGalleryActivity.this, format, R.string.cancel, R.string.bbl, new c(view, personalityLabelInfo4), new d()).show();
                    } else if (intValue == 5) {
                        PersonalityLabelGalleryActivity.this.J3();
                        view.setVisibility(8);
                        PersonalityLabelGalleryActivity.this.O0 = false;
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ValueAnimator f259852d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f259853e;

        a(ValueAnimator valueAnimator, View view) {
            this.f259852d = valueAnimator;
            this.f259853e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PersonalityLabelGalleryActivity.this, valueAnimator, view);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) this.f259852d.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.f259853e.getLayoutParams();
            layoutParams.height = intValue;
            this.f259853e.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f259855d;

        b(long j3) {
            this.f259855d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PersonalityLabelGalleryActivity.this, Long.valueOf(j3));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Iterator<PersonalityLabelInfo> it = PersonalityLabelGalleryActivity.this.f259827t0.personalityLabelInfos.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PersonalityLabelInfo next = it.next();
                if (this.f259855d == next.f259897id) {
                    PersonalityLabelGalleryActivity.this.f259827t0.personalityLabelInfos.remove(next);
                    PersonalityLabelGalleryActivity.this.f259827t0.remainCount++;
                    PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                    personalityLabelGalleryActivity.F3(personalityLabelGalleryActivity.f259827t0, false);
                    PersonalityLabelGalleryActivity.this.A0 = true;
                    if (!PersonalityLabelGalleryActivity.this.v3()) {
                        PersonalityLabelGalleryActivity personalityLabelGalleryActivity2 = PersonalityLabelGalleryActivity.this;
                        if (personalityLabelGalleryActivity2.L0) {
                            personalityLabelGalleryActivity2.P3(false);
                        }
                    }
                    if (PersonalityLabelGalleryActivity.this.J0.hasMessages(0)) {
                        PersonalityLabelGalleryActivity.this.J0.removeMessages(0);
                    }
                    PersonalityLabelGalleryActivity personalityLabelGalleryActivity3 = PersonalityLabelGalleryActivity.this;
                    PersonalityLabelGalleryActivity.this.J0.sendMessageDelayed(personalityLabelGalleryActivity3.J0.obtainMessage(0, personalityLabelGalleryActivity3.f259827t0), 500L);
                }
            }
            ((PersonalityLabelHandler) PersonalityLabelGalleryActivity.this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).D2(this.f259855d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f259857d;

        c(ObjectAnimator objectAnimator) {
            this.f259857d = objectAnimator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this, (Object) objectAnimator);
            }
        }

        private ImageView e(ObjectAnimator objectAnimator) {
            return (ImageView) objectAnimator.getTarget();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            ImageView e16 = e(this.f259857d);
            if (e16 != null) {
                if (PersonalityLabelGalleryActivity.this.L0) {
                    i3 = R.drawable.afu;
                } else {
                    i3 = R.drawable.afo;
                }
                e16.setImageResource(i3);
                e16.setRotation(0.0f);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            ImageView e16 = e(this.f259857d);
            if (e16 != null) {
                if (PersonalityLabelGalleryActivity.this.L0) {
                    i3 = R.drawable.afu;
                } else {
                    i3 = R.drawable.afo;
                }
                e16.setImageResource(i3);
                e16.setRotation(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* loaded from: classes16.dex */
    class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelGalleryActivity", 2, "onUpdateFriendInfo refresh UI uin:" + str + " suc:" + z16);
            }
            if (z16 && TextUtils.equals(PersonalityLabelGalleryActivity.this.f259809b0, str) && !PersonalityLabelGalleryActivity.this.f259811d0) {
                PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                personalityLabelGalleryActivity.f259810c0 = ac.F(personalityLabelGalleryActivity.app, personalityLabelGalleryActivity.f259809b0);
                if (!TextUtils.equals(PersonalityLabelGalleryActivity.this.f259809b0, PersonalityLabelGalleryActivity.this.f259810c0)) {
                    PersonalityLabelGalleryActivity.this.I3();
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class e implements QQProgressDialog.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
        public void onBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!PersonalityLabelGalleryActivity.this.Q0) {
                PersonalityLabelGalleryActivity.this.Q0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static /* synthetic */ class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f259861a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73702);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f259861a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f259861a[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class g implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            int i3 = f.f259861a[baseAction.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    PersonalityLabelGalleryActivity.this.P3(true);
                    return null;
                }
                return null;
            }
            PersonalityLabelGalleryActivity.this.onBackEvent();
            return null;
        }
    }

    /* loaded from: classes16.dex */
    class h extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && intent.getAction().equalsIgnoreCase("com.tencent.mobileqq.card.modify_personality_label")) {
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelGalleryActivity", 2, "receive broadcast modify pl info");
                }
                Bundle bundleExtra = intent.getBundleExtra(SpecialProxy.KEY_DATA);
                if (bundleExtra != null && bundleExtra.getBoolean("onTagChanged")) {
                    PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                    personalityLabelGalleryActivity.F0 = true;
                    personalityLabelGalleryActivity.t3();
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class i extends com.tencent.mobileqq.profile.PersonalityLabel.c {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profile.PersonalityLabel.c
        public void onDelPersonalityLabelPhoto(boolean z16, String str, long j3, long j16) {
            PersonalityLabelInfo personalityLabelInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelGalleryActivity", 2, "onDelPersonalityLabelPhoto suc:" + z16 + "," + str + "," + j3 + "," + j16);
            }
            if (!PersonalityLabelGalleryActivity.this.f259811d0 || !str.equals(PersonalityLabelGalleryActivity.this.app.getCurrentAccountUin()) || (personalityLabelInfo = (PersonalityLabelInfo) PersonalityLabelGalleryActivity.this.f259828u0.get(Long.valueOf(j3))) == null) {
                return;
            }
            for (int i3 = 0; i3 < personalityLabelInfo.personalityLabelPhotos.size(); i3++) {
                if (personalityLabelInfo.personalityLabelPhotos.get(i3).fileId == j16) {
                    if (personalityLabelInfo.personalityLabelPhotos.remove(i3) != null) {
                        PersonalityLabelGalleryActivity.this.A0 = true;
                        personalityLabelInfo.photoCount--;
                        PersonalityLabelGalleryActivity.this.Q3(j3, false);
                    }
                    PersonalityLabelGalleryActivity.this.f259825r0.notifyDataSetChanged();
                    return;
                }
            }
        }

        @Override // com.tencent.mobileqq.profile.PersonalityLabel.c
        public void onGetPersonalityLabel(boolean z16, String str, ProfilePersonalityLabelInfo profilePersonalityLabelInfo, byte[] bArr, int i3) {
            String str2;
            int i16;
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, profilePersonalityLabelInfo, bArr, Integer.valueOf(i3));
                return;
            }
            if (i3 != 1) {
                return;
            }
            if (!TextUtils.isEmpty(PersonalityLabelGalleryActivity.this.f259809b0)) {
                str2 = PersonalityLabelGalleryActivity.this.f259809b0;
            } else {
                str2 = PersonalityLabelGalleryActivity.this.app.getCurrentAccountUin();
            }
            if (!str2.equals(str)) {
                return;
            }
            if (z16 && profilePersonalityLabelInfo != null) {
                PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                if (personalityLabelGalleryActivity.F0) {
                    personalityLabelGalleryActivity.E0.clear();
                    if (PersonalityLabelGalleryActivity.this.f259827t0 == null) {
                        size = 0;
                    } else {
                        size = PersonalityLabelGalleryActivity.this.f259827t0.getSize();
                    }
                    int i17 = 0;
                    for (int size2 = profilePersonalityLabelInfo.getSize() - size; size2 > 0; size2--) {
                        PersonalityLabelGalleryActivity.this.E0.add(Long.valueOf(profilePersonalityLabelInfo.personalityLabelInfos.get(i17).f259897id));
                        i17++;
                    }
                    PersonalityLabelGalleryActivity.this.F0 = false;
                }
                if (profilePersonalityLabelInfo.getSize() > 0 && PersonalityLabelGalleryActivity.this.f259811d0) {
                    for (int i18 = 0; i18 < profilePersonalityLabelInfo.personalityLabelInfos.size(); i18++) {
                        PersonalityLabelInfo personalityLabelInfo = profilePersonalityLabelInfo.personalityLabelInfos.get(i18);
                        PersonalityLabelGalleryActivity.this.T0.d(personalityLabelInfo.f259897id, personalityLabelInfo, true);
                    }
                }
                PersonalityLabelGalleryActivity.this.F3(profilePersonalityLabelInfo, true);
                if (PersonalityLabelGalleryActivity.this.J0.hasMessages(0)) {
                    PersonalityLabelGalleryActivity.this.J0.removeMessages(0);
                }
                PersonalityLabelGalleryActivity.this.J0.sendMessageDelayed(PersonalityLabelGalleryActivity.this.J0.obtainMessage(0, profilePersonalityLabelInfo), 500L);
                return;
            }
            if (!z16) {
                if (!NetworkUtil.isNetSupport(PersonalityLabelGalleryActivity.this)) {
                    PersonalityLabelGalleryActivity personalityLabelGalleryActivity2 = PersonalityLabelGalleryActivity.this;
                    personalityLabelGalleryActivity2.showToast(personalityLabelGalleryActivity2.getResources().getString(R.string.f171137ci2));
                } else {
                    PersonalityLabelGalleryActivity personalityLabelGalleryActivity3 = PersonalityLabelGalleryActivity.this;
                    personalityLabelGalleryActivity3.showToast(personalityLabelGalleryActivity3.getResources().getString(R.string.c5o));
                }
                PersonalityLabelGalleryActivity personalityLabelGalleryActivity4 = PersonalityLabelGalleryActivity.this;
                if (personalityLabelGalleryActivity4.f259827t0 != null && PersonalityLabelGalleryActivity.this.f259827t0.getSize() > 0) {
                    i16 = 8;
                } else {
                    i16 = 0;
                }
                personalityLabelGalleryActivity4.R3(i16, "\u52a0\u8f7d\u5931\u8d25", false);
            }
        }

        @Override // com.tencent.mobileqq.profile.PersonalityLabel.c
        public void onGetPersonalityLabelPhotos(boolean z16, String str, long j3, PersonalityLabelInfo personalityLabelInfo, int i3, byte[] bArr) {
            String str2;
            PersonalityLabelInfo personalityLabelInfo2;
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Long.valueOf(j3), personalityLabelInfo, Integer.valueOf(i3), bArr);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetPersonalityLabelPhotos : isSuccess = ");
                sb5.append(z16);
                sb5.append(", uin = ");
                sb5.append(str);
                sb5.append(", labelId = ");
                sb5.append(j3);
                sb5.append(", completeFlag = ");
                sb5.append(i3);
                sb5.append(", cookie = ");
                String str3 = "null";
                if (bArr == null) {
                    obj = "null";
                } else {
                    obj = bArr;
                }
                sb5.append(obj);
                sb5.append(", labelInfo = ");
                if (personalityLabelInfo != null) {
                    str3 = personalityLabelInfo.toString();
                }
                sb5.append(str3);
                QLog.i("PersonalityLabelGalleryActivity", 2, sb5.toString());
            }
            if (!TextUtils.isEmpty(PersonalityLabelGalleryActivity.this.f259809b0)) {
                str2 = PersonalityLabelGalleryActivity.this.f259809b0;
            } else {
                str2 = PersonalityLabelGalleryActivity.this.app.getCurrentAccountUin();
            }
            if (str2.equals(str)) {
                PersonalityLabelGalleryActivity.this.B0 = false;
            }
            if (z16 && personalityLabelInfo != null && (personalityLabelInfo2 = (PersonalityLabelInfo) PersonalityLabelGalleryActivity.this.f259828u0.get(Long.valueOf(j3))) != null) {
                if (PersonalityLabelGalleryActivity.this.C0.get(Long.valueOf(j3)) == null) {
                    personalityLabelInfo2.personalityLabelPhotos.clear();
                    if (PersonalityLabelGalleryActivity.this.f259811d0) {
                        personalityLabelInfo.photoCount += PersonalityLabelGalleryActivity.this.T0.d(j3, personalityLabelInfo, true);
                    }
                }
                personalityLabelInfo2.personalityLabelPhotos.addAll(personalityLabelInfo.personalityLabelPhotos);
                PersonalityLabelGalleryActivity.this.D0.put(Long.valueOf(j3), Integer.valueOf(i3));
                if (bArr != null) {
                    PersonalityLabelGalleryActivity.this.C0.put(Long.valueOf(j3), bArr);
                }
                PersonalityLabelGalleryActivity.this.A3(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ValueAnimator f259865d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f259866e;

        j(ValueAnimator valueAnimator, View view) {
            this.f259865d = valueAnimator;
            this.f259866e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PersonalityLabelGalleryActivity.this, valueAnimator, view);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            int intValue = ((Integer) this.f259865d.getAnimatedValue()).intValue();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f259866e.getLayoutParams();
            layoutParams.height = intValue;
            this.f259866e.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class k extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ m f259868d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f259869e;

        k(m mVar, View view) {
            this.f259868d = mVar;
            this.f259869e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PersonalityLabelGalleryActivity.this, mVar, view);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            PersonalityLabelGalleryActivity.this.E0.remove(Long.valueOf(this.f259868d.f259873a));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f259869e.getLayoutParams();
            layoutParams.height = -2;
            this.f259869e.setLayoutParams(layoutParams);
            this.f259869e.setTag(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            PersonalityLabelGalleryActivity.this.E0.remove(Long.valueOf(this.f259868d.f259873a));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f259869e.getLayoutParams();
            layoutParams.height = -2;
            this.f259869e.setLayoutParams(layoutParams);
            this.f259869e.setTag(Boolean.FALSE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class l extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f259871d;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
            } else {
                this.f259871d = (int) (PersonalityLabelGalleryActivity.this.f259808a0 * 3.0f);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            } else {
                rect.right = this.f259871d;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f259873a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f259874b;

        /* renamed from: c, reason: collision with root package name */
        public View f259875c;

        /* renamed from: d, reason: collision with root package name */
        public View f259876d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f259877e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f259878f;

        /* renamed from: g, reason: collision with root package name */
        public ImageView f259879g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f259880h;

        /* renamed from: i, reason: collision with root package name */
        public GlowCountRecyclerView f259881i;

        /* renamed from: j, reason: collision with root package name */
        public TextView f259882j;

        /* renamed from: k, reason: collision with root package name */
        View f259883k;

        /* renamed from: l, reason: collision with root package name */
        View f259884l;

        /* renamed from: m, reason: collision with root package name */
        View f259885m;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class n extends RecyclerView.Adapter<o> implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f259886d;

        /* renamed from: e, reason: collision with root package name */
        private int f259887e;

        /* loaded from: classes16.dex */
        class a implements ActionSheet.OnButtonClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PLUploadManager.a f259889d;

            a(PLUploadManager.a aVar) {
                this.f259889d = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this, (Object) aVar);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                    return;
                }
                if (i3 != 0) {
                    if (i3 == 1) {
                        PersonalityLabelInfo personalityLabelInfo = (PersonalityLabelInfo) PersonalityLabelGalleryActivity.this.f259828u0.get(Long.valueOf(n.this.f259886d));
                        if (personalityLabelInfo == null) {
                            PersonalityLabelGalleryActivity.this.U0.superDismiss();
                            return;
                        }
                        int i16 = 0;
                        while (true) {
                            if (i16 < personalityLabelInfo.personalityLabelPhotos.size()) {
                                if (personalityLabelInfo.personalityLabelPhotos.get(i16).uniseq == this.f259889d.f259797c.uniseq) {
                                    personalityLabelInfo.personalityLabelPhotos.remove(i16);
                                    break;
                                }
                                i16++;
                            } else {
                                i16 = -1;
                                break;
                            }
                        }
                        if (i16 < 0) {
                            PersonalityLabelGalleryActivity.this.U0.superDismiss();
                            return;
                        }
                        personalityLabelInfo.photoCount--;
                        n nVar = n.this;
                        PersonalityLabelGalleryActivity.this.S3(nVar.f259886d, personalityLabelInfo);
                        n nVar2 = n.this;
                        PersonalityLabelGalleryActivity.this.T0.a(nVar2.f259886d, this.f259889d.f259797c);
                    }
                } else {
                    n nVar3 = n.this;
                    PersonalityLabelGalleryActivity.this.T0.e(nVar3.f259886d, this.f259889d.f259797c);
                }
                PersonalityLabelGalleryActivity.this.U0.superDismiss();
            }
        }

        public n(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PersonalityLabelGalleryActivity.this, Long.valueOf(j3));
            } else {
                this.f259887e = (int) (PersonalityLabelGalleryActivity.this.f259808a0 * 120.0f);
                this.f259886d = j3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<PersonalityLabelPhoto> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            PersonalityLabelInfo personalityLabelInfo = (PersonalityLabelInfo) PersonalityLabelGalleryActivity.this.f259828u0.get(Long.valueOf(this.f259886d));
            if (personalityLabelInfo != null && (list = personalityLabelInfo.personalityLabelPhotos) != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            return 0;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PLUploadManager.a aVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            } else if (!PersonalityLabelGalleryActivity.this.L0 && view.getId() == R.id.f166508fp3) {
                Object tag = view.getTag();
                Object tag2 = view.getTag(R.id.f166508fp3);
                if (tag2 != null && (tag2 instanceof PLUploadManager.a)) {
                    PLUploadManager.a aVar2 = (PLUploadManager.a) tag2;
                    if (aVar2.f259799e == 3) {
                        PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                        if (personalityLabelGalleryActivity.U0 == null) {
                            personalityLabelGalleryActivity.U0 = ActionSheet.create(view.getContext());
                            PersonalityLabelGalleryActivity.this.U0.addButton("\u91cd\u65b0\u4e0a\u4f20");
                            PersonalityLabelGalleryActivity.this.U0.addButton("\u5220\u9664");
                            PersonalityLabelGalleryActivity.this.U0.addCancelButton("\u53d6\u6d88");
                        }
                        PersonalityLabelGalleryActivity.this.U0.setOnButtonClickListener(new a(aVar2));
                        PersonalityLabelGalleryActivity.this.U0.show();
                    }
                }
                if (tag != null && (tag instanceof Integer)) {
                    int intValue = ((Integer) tag).intValue();
                    PersonalityLabelInfo personalityLabelInfo = (PersonalityLabelInfo) PersonalityLabelGalleryActivity.this.f259828u0.get(Long.valueOf(this.f259886d));
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    int i3 = intValue;
                    for (int i16 = 0; i16 < personalityLabelInfo.personalityLabelPhotos.size(); i16++) {
                        PersonalityLabelPhoto personalityLabelPhoto = personalityLabelInfo.personalityLabelPhotos.get(i16);
                        if (PersonalityLabelGalleryActivity.this.f259811d0) {
                            aVar = PersonalityLabelGalleryActivity.this.T0.b(this.f259886d, personalityLabelPhoto);
                        } else {
                            aVar = null;
                        }
                        if (aVar != null && aVar.f259799e == 3) {
                            if (i16 < intValue) {
                                i3--;
                            }
                        } else {
                            arrayList.add(personalityLabelPhoto.getOriginUrl());
                            arrayList2.add(String.valueOf(personalityLabelPhoto.fileId));
                        }
                    }
                    Intent intent = new Intent(PersonalityLabelGalleryActivity.this, (Class<?>) TroopAvatarWallPreviewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("index", i3);
                    bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
                    bundle.putStringArrayList("photoIds", arrayList2);
                    bundle.putBoolean(IProfileCardConst.KEY_DELETE_ABILITY, PersonalityLabelGalleryActivity.this.f259811d0);
                    if (((IProfileKoiLikeApi) QRoute.api(IProfileKoiLikeApi.class)).isSpecialPersonalLabel(personalityLabelInfo.f259897id)) {
                        bundle.putBoolean("SHOW_MENU", false);
                        bundle.putBoolean("is_show_action", false);
                    } else {
                        bundle.putBoolean("SHOW_MENU", true);
                        bundle.putBoolean("is_show_action", true);
                    }
                    bundle.putBoolean("IS_EDIT", false);
                    bundle.putBoolean("is_use_path", true);
                    bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, false);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(TroopAvatarWallPreviewActivity.KEY_FROM_PERSONALITY_LABEL, true);
                    bundle2.putLong("label_id", this.f259886d);
                    bundle.putBundle(TroopAvatarWallPreviewActivity.KEY_BUNDLE_DATA_EXTRA, bundle2);
                    intent.putExtras(bundle);
                    PersonalityLabelGalleryActivity.this.startActivity(intent);
                    ReportController.o(PersonalityLabelGalleryActivity.this.app, "dc00898", "", "", "0X8007FD1", "0X8007FD1", 0, 0, "", "", "", "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(o oVar, int i3) {
            PLUploadManager.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) oVar, i3);
            } else {
                PersonalityLabelInfo personalityLabelInfo = (PersonalityLabelInfo) PersonalityLabelGalleryActivity.this.f259828u0.get(Long.valueOf(this.f259886d));
                PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                if (personalityLabelGalleryActivity.G0 == null) {
                    personalityLabelGalleryActivity.G0 = personalityLabelGalleryActivity.getResources().getDrawable(R.color.f156899eo);
                }
                String str = personalityLabelInfo.personalityLabelPhotos.get(i3).localThumbPath;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        URL url = new URL("file:///" + new File(str).getAbsolutePath());
                        ImageView imageView = oVar.f259892e;
                        int i16 = this.f259887e;
                        Drawable drawable = PersonalityLabelGalleryActivity.this.G0;
                        imageView.setImageDrawable(URLDrawable.getDrawable(url, i16, i16, drawable, drawable));
                    } catch (MalformedURLException e16) {
                        e16.printStackTrace();
                    }
                } else {
                    String str2 = personalityLabelInfo.personalityLabelPhotos.get(i3).get350SizeUrl();
                    if (!str2.startsWith("http") && !str2.startsWith("https")) {
                        try {
                            URL url2 = new URL("file:///" + new File(str2).getAbsolutePath());
                            ImageView imageView2 = oVar.f259892e;
                            int i17 = this.f259887e;
                            Drawable drawable2 = PersonalityLabelGalleryActivity.this.G0;
                            imageView2.setImageDrawable(URLDrawable.getDrawable(url2, i17, i17, drawable2, drawable2));
                        } catch (MalformedURLException e17) {
                            e17.printStackTrace();
                        }
                    } else {
                        int i18 = this.f259887e;
                        Drawable drawable3 = PersonalityLabelGalleryActivity.this.G0;
                        oVar.f259892e.setImageDrawable(URLDrawable.getDrawable(str2, i18, i18, drawable3, drawable3));
                    }
                }
                if (PersonalityLabelGalleryActivity.this.f259811d0) {
                    aVar = PersonalityLabelGalleryActivity.this.T0.b(this.f259886d, personalityLabelInfo.personalityLabelPhotos.get(i3));
                    PersonalityLabelGalleryActivity.this.n3(aVar, personalityLabelInfo.personalityLabelPhotos.get(i3), oVar);
                } else {
                    aVar = null;
                }
                oVar.f259891d.setTag(R.id.f166508fp3, aVar);
                oVar.f259891d.setTag(Integer.valueOf(i3));
                oVar.f259891d.setOnClickListener(this);
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(oVar, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public o onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (o) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            return new o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168830az1, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class o extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f259891d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f259892e;

        /* renamed from: f, reason: collision with root package name */
        ImageView f259893f;

        /* renamed from: h, reason: collision with root package name */
        MessageProgressView f259894h;

        public o(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this, (Object) view);
                return;
            }
            float f16 = PersonalityLabelGalleryActivity.this.f259808a0 * 2.0f;
            this.f259891d = (RelativeLayout) view.findViewById(R.id.f166508fp3);
            ImageView imageView = (ImageView) view.findViewById(R.id.fnh);
            this.f259892e = imageView;
            ((CornerImageView) imageView).setRadius(f16);
            ((CornerImageView) this.f259892e).setPressMask(true);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.c28);
            this.f259893f = imageView2;
            ((CornerImageView) imageView2).setRadius(f16);
        }
    }

    public PersonalityLabelGalleryActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f259828u0 = new ConcurrentHashMap<>();
        this.f259830w0 = new ArrayList();
        this.f259832y0 = 0;
        this.A0 = false;
        this.B0 = false;
        this.C0 = new ConcurrentHashMap<>();
        this.D0 = new ConcurrentHashMap<>();
        this.E0 = new HashSet<>();
        this.F0 = false;
        this.J0 = new Handler(ThreadManagerV2.getFileThreadLooper(), this);
        this.K0 = new Handler(Looper.getMainLooper(), this);
        this.L0 = false;
        this.M0 = 0;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = true;
        this.V0 = -1;
        this.W0 = new h();
        this.X0 = new i();
        this.Y0 = new d();
        this.Z0 = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3(long j3) {
        for (int i3 = 0; i3 < this.f259812e0.getChildCount(); i3++) {
            m mVar = (m) this.f259812e0.getChildAt(i3).getTag();
            if (mVar != null && mVar.f259873a == j3) {
                mVar.f259881i.getAdapter().notifyDataSetChanged();
                return;
            }
        }
    }

    private void E3(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        List<PersonalityLabelInfo> list;
        this.V0 = -1;
        if (profilePersonalityLabelInfo != null && (list = profilePersonalityLabelInfo.personalityLabelInfos) != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (!((IProfileKoiLikeApi) QRoute.api(IProfileKoiLikeApi.class)).isSpecialPersonalLabel(list.get(i3).f259897id)) {
                    this.V0 = i3;
                    return;
                }
            }
        }
    }

    private void G3(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.getSize() > 0) {
            return;
        }
        if (this.f259817j0 == null) {
            try {
                this.f259817j0 = this.f259818k0.inflate();
            } catch (OutOfMemoryError unused) {
                System.gc();
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelGalleryActivity", 2, "setEmptyText inflate empty view outOfMemoryError");
                }
                try {
                    this.f259817j0 = this.f259818k0.inflate();
                } catch (OutOfMemoryError unused2) {
                    QLog.e("PersonalityLabelGalleryActivity", 1, "setEmptyText is error!");
                }
            }
        }
        View view = this.f259817j0;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.bww);
        TextView textView = (TextView) this.f259817j0.findViewById(R.id.bwt);
        TextView textView2 = (TextView) this.f259817j0.findViewById(R.id.f165096bx2);
        View findViewById2 = this.f259817j0.findViewById(R.id.f165091bw4);
        if (this.f259811d0) {
            textView.setText(R.string.fp_);
            textView2.setText(getString(R.string.fp6));
            findViewById2.setOnClickListener(this);
            return;
        }
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.isCloseByUser == 1) {
            textView.setText(R.string.fp5);
            findViewById2.setVisibility(8);
            textView2.setVisibility(8);
            if (findViewById.getPaddingBottom() <= 0) {
                findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + BaseAIOUtils.f(73.0f, getResources()));
                return;
            }
            return;
        }
        textView.setText(R.string.fp_);
        findViewById2.setVisibility(8);
        textView2.setText(getString(R.string.fp9));
        if (findViewById.getPaddingBottom() <= 0) {
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom() + BaseAIOUtils.f(73.0f, getResources()));
        }
    }

    private void H3() {
        com.tencent.mobileqq.qqexpand.manager.e eVar;
        boolean z16;
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = this.f259827t0;
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.personalityLabelInfos != null && (eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)) != null) {
            if (this.f259827t0.personalityLabelInfos.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelGalleryActivity", 2, "setHasPersonalLabelSP\uff1a " + z16);
            }
            eVar.M(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3() {
        if (!this.f259811d0) {
            int i3 = (int) (getResources().getDisplayMetrics().widthPixels - ((this.f259808a0 * 57.0f) + 0.5f));
            if (this.N0 == null) {
                this.N0 = new TextPaint();
            }
            this.N0.setTextSize(this.f259808a0 * 28.0f);
            int measureText = (int) (this.N0.measureText("\u7684\u6807\u7b7e") + 0.5f);
            String str = this.f259810c0;
            if (str == null) {
                this.f259814g0.setText("ta\u7684\u6807\u7b7e");
                return;
            }
            String charSequence = TextUtils.ellipsize(str, this.N0, i3 - measureText, TextUtils.TruncateAt.END).toString();
            this.f259814g0.setText(charSequence + "\u7684\u6807\u7b7e");
            return;
        }
        this.f259814g0.setText(R.string.qyv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J3() {
        getSharedPreferences("personality_label" + this.f259809b0, 0).edit().putBoolean("tips_displayed", true).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3(int i3) {
        if (this.L0 && i3 == 0) {
            i3 = 8;
        }
        if (this.f259816i0.getVisibility() != i3) {
            this.f259816i0.setVisibility(i3);
        }
    }

    private void M3(String str, QQProgressDialog.b bVar) {
        if (isFinishing()) {
            return;
        }
        if (this.f259826s0 == null) {
            this.f259826s0 = new QQProgressDialog(this, getTitleBarHeight());
        }
        this.f259826s0.O(bVar);
        this.f259826s0.setMessage(str);
        if (isFinishing()) {
            return;
        }
        this.f259826s0.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3(boolean z16) {
        int i3;
        if (!this.L0) {
            if (!NetworkUtil.isNetSupport(this)) {
                showToast(getResources().getString(R.string.f171137ci2));
                return;
            } else if (isTitleProgressShowing()) {
                showToast("\u8bf7\u7b49\u5f85\u6570\u636e\u52a0\u8f7d\u5b8c\u6bd5");
                return;
            }
        }
        this.L0 = !this.L0;
        K3();
        View view = this.f259819l0;
        if (this.f259811d0 && !this.L0 && v3()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (this.K0.hasMessages(2)) {
            this.K0.removeMessages(2);
        }
        this.K0.sendEmptyMessage(2);
        if (this.L0 && this.P0) {
            this.O0 = false;
            J3();
        }
        if (this.f259827t0.unreadCount > 0) {
            L3(0);
        }
        B3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S3(long j3, PersonalityLabelInfo personalityLabelInfo) {
        boolean z16;
        int i3;
        for (int i16 = 0; i16 < this.f259812e0.getChildCount(); i16++) {
            m mVar = (m) this.f259812e0.getChildAt(i16).getTag();
            if (mVar != null && mVar.f259873a == j3) {
                boolean z17 = true;
                if (personalityLabelInfo.getSize() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (mVar.f259881i.getVisibility() != 0) {
                    z17 = false;
                }
                if (z17 != z16) {
                    GlowCountRecyclerView glowCountRecyclerView = mVar.f259881i;
                    if (z16) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    glowCountRecyclerView.setVisibility(i3);
                }
                mVar.f259881i.setText(personalityLabelInfo.photoCount + "\u5f20");
                mVar.f259881i.getAdapter().notifyDataSetChanged();
                mVar.f259881i.smoothScrollToPosition(0);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWaittingDialog() {
        QQProgressDialog qQProgressDialog = this.f259826s0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing() && !isFinishing()) {
            this.f259826s0.dismiss();
        }
    }

    private void j3() {
        RelativeLayout relativeLayout;
        if (isInMultiWindow() && (relativeLayout = this.titleRoot) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.titleRoot.setLayoutParams(marginLayoutParams);
        }
    }

    private void l3() {
        M3(new StringBuilder("\u6b63\u5728\u5904\u7406...").toString(), this.Z0);
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList(9);
                for (int size = PersonalityLabelGalleryActivity.this.f259830w0.size() - 1; size >= 0; size--) {
                    String str = (String) PersonalityLabelGalleryActivity.this.f259830w0.get(size);
                    if (PersonalityLabelGalleryActivity.this.Q0) {
                        PersonalityLabelGalleryActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.5.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    PersonalityLabelGalleryActivity.this.dismissWaittingDialog();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                        return;
                    }
                    CompressInfo compressInfo = new CompressInfo(str, 0);
                    compressInfo.K = 0;
                    ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo);
                    try {
                        QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label uploadPhoto(),  src_path = " + compressInfo.D + " src_Exist:" + new File(compressInfo.D).exists());
                        QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label uploadPhoto(), thumb_path = " + compressInfo.H + " dest_Exist:" + new File(compressInfo.H).exists());
                    } catch (NullPointerException unused) {
                        QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label uploadPhoto(), thumb_path = " + compressInfo.H + " src_path = " + compressInfo.D);
                    }
                    if (!TextUtils.isEmpty(compressInfo.H)) {
                        arrayList.add(compressInfo);
                        try {
                            URL url = new URL("file:///" + new File(compressInfo.H).getAbsolutePath());
                            int i3 = (int) (PersonalityLabelGalleryActivity.this.f259808a0 * 120.0f);
                            Drawable drawable = PersonalityLabelGalleryActivity.this.G0;
                            URLDrawable.getDrawable(url, i3, i3, drawable, drawable).startDownload();
                        } catch (MalformedURLException e16) {
                            e16.printStackTrace();
                        }
                    } else {
                        PersonalityLabelGalleryActivity.this.runOnUiThread(new Runnable(size) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.5.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f259838d;

                            {
                                this.f259838d = size;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this, size);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    QQToast.makeText(PersonalityLabelGalleryActivity.this.getApplicationContext(), 0, String.format("\u4e0a\u4f20\u56fe\u7247\u5931\u8d25", Integer.valueOf(this.f259838d + 1)), 0).show();
                                }
                            }
                        });
                    }
                }
                if (arrayList.size() > 0) {
                    PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                    personalityLabelGalleryActivity.T0.g(arrayList, personalityLabelGalleryActivity.f259829v0);
                }
                PersonalityLabelGalleryActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.5.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            PersonalityLabelGalleryActivity.this.dismissWaittingDialog();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }, null, true);
    }

    public static int p3(byte[] bArr) {
        return ByteBuffer.wrap(bArr).getInt();
    }

    private void r3(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        List<PersonalityLabelInfo> list;
        this.f259828u0.clear();
        if (profilePersonalityLabelInfo != null && (list = profilePersonalityLabelInfo.personalityLabelInfos) != null && list.size() > 0) {
            for (PersonalityLabelInfo personalityLabelInfo : profilePersonalityLabelInfo.personalityLabelInfos) {
                this.f259828u0.put(Long.valueOf(personalityLabelInfo.f259897id), personalityLabelInfo);
            }
        }
    }

    private void s3(Intent intent) {
        if (intent != null) {
            this.f259832y0 = intent.getIntExtra(IProfileCardConst.KEY_FROM_TYPE, this.f259832y0);
            this.f259833z0 = (AllInOne) intent.getParcelableExtra("personality_label_allinone");
            this.f259809b0 = intent.getStringExtra("uin");
            this.f259810c0 = intent.getStringExtra("nickname");
            if (TextUtils.isEmpty(this.f259809b0)) {
                QQToast.makeText(this, "\u6253\u5f00\u6807\u7b7e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0);
                finish();
                return;
            }
            if (TextUtils.isEmpty(this.f259810c0) && !this.f259809b0.equals(this.app.getCurrentAccountUin())) {
                String F = ac.F(this.app, this.f259809b0);
                this.f259810c0 = F;
                if (TextUtils.isEmpty(F) || TextUtils.equals(this.f259810c0, this.f259809b0)) {
                    FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    this.R0 = friendListHandler;
                    friendListHandler.getFriendInfo(this.f259809b0);
                }
            }
            if (this.f259832y0 == 3) {
                this.F0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        QQToast.makeText(BaseApplication.getContext(), str, 0).show(getTitleBarHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3() {
        ((PersonalityLabelHandler) this.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL)).F2(this.f259809b0, 1);
    }

    private String u3(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.personalityLabelInfos != null) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<PersonalityLabelInfo> it = profilePersonalityLabelInfo.personalityLabelInfos.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().text);
                if (it.hasNext()) {
                    sb5.append("\u3001");
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public static byte[] x3(int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i3);
        return allocate.array();
    }

    private void y3(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        List<PersonalityLabelInfo> list;
        StringBuilder sb5 = new StringBuilder();
        if (profilePersonalityLabelInfo != null && (list = profilePersonalityLabelInfo.personalityLabelInfos) != null) {
            int i3 = 0;
            for (PersonalityLabelInfo personalityLabelInfo : list) {
                sb5.append("&label_for_qq");
                sb5.append(i3);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(personalityLabelInfo.text);
                i3++;
            }
        }
        String str = "mqqapi://qcircle/openqqpublish?target=12&share_preview_type=2" + sb5.toString();
        QLog.d("PersonalityLabelGalleryActivity", 1, "[jumpQCircleSharePreview]: " + str);
        com.tencent.biz.qqcircle.launcher.c.g(this, str);
    }

    void B3() {
        for (int i3 = 0; i3 < this.f259812e0.getChildCount(); i3++) {
            View childAt = this.f259812e0.getChildAt(i3);
            Object tag = childAt.getTag();
            if (tag != null && (tag instanceof m)) {
                ImageView imageView = ((m) tag).f259878f;
                if (imageView == null) {
                    return;
                }
                ObjectAnimator objectAnimator = (ObjectAnimator) childAt.getTag(R.id.f164033hr);
                if (objectAnimator == null) {
                    objectAnimator = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.ROTATION, 0.0f, 45.0f);
                    objectAnimator.setDuration(100L);
                    objectAnimator.addListener(new c(objectAnimator));
                    childAt.setTag(R.id.f164033hr, objectAnimator);
                }
                objectAnimator.start();
            }
        }
    }

    void C3(View view, long j3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(view.getHeight(), 0);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new a(ofInt, view));
        ofInt.addListener(new b(j3));
        ofInt.start();
    }

    void D3() {
        boolean booleanValue;
        this.f259812e0.setSelection(0);
        int i3 = (int) (this.f259808a0 * 87.0f);
        int i16 = 0;
        for (int childCount = this.f259812e0.getChildCount() - 1; childCount >= 0; childCount--) {
            Object tag = this.f259812e0.getChildAt(childCount).getTag();
            if (tag != null && (tag instanceof m)) {
                m mVar = (m) tag;
                View view = mVar.f259884l;
                Object tag2 = view.getTag();
                if (tag2 == null) {
                    booleanValue = false;
                } else {
                    booleanValue = ((Boolean) tag2).booleanValue();
                }
                if (booleanValue) {
                    ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
                    ofInt.setInterpolator(new DecelerateInterpolator(1.0f));
                    ofInt.addUpdateListener(new j(ofInt, view));
                    ofInt.addListener(new k(mVar, view));
                    ofInt.setDuration(200L);
                    ofInt.setStartDelay(i16);
                    ofInt.start();
                    this.E0.remove(Long.valueOf(mVar.f259873a));
                    i16 += 150;
                }
            }
        }
    }

    void F3(ProfilePersonalityLabelInfo profilePersonalityLabelInfo, boolean z16) {
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "refreshUI " + z16 + " label:" + profilePersonalityLabelInfo);
        }
        if (profilePersonalityLabelInfo == null) {
            return;
        }
        boolean z17 = true;
        if (!this.f259811d0 && profilePersonalityLabelInfo.isCloseByUser == 1) {
            profilePersonalityLabelInfo.personalityLabelInfos.clear();
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelGalleryActivity", 2, "refreshUI guest isCloseByUser=true");
            }
        }
        this.f259827t0 = profilePersonalityLabelInfo;
        r3(profilePersonalityLabelInfo);
        E3(profilePersonalityLabelInfo);
        this.f259825r0.notifyDataSetChanged();
        G3(profilePersonalityLabelInfo);
        View view = this.f259817j0;
        if (view != null) {
            this.f259812e0.setEmptyView(view);
        }
        K3();
        View view2 = this.f259819l0;
        int i17 = 8;
        if (this.f259811d0 && !this.L0 && v3()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view2.setVisibility(i3);
        if (z16) {
            R3(8, "", false);
            int i18 = profilePersonalityLabelInfo.unreadCount;
            if (i18 > 0) {
                this.f259816i0.setText(String.format(com.tencent.mobileqq.profile.PersonalityLabel.a.f259944b, Integer.valueOf(i18)));
                this.f259816i0.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this);
                        }
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        EventCollector.getInstance().onViewClickedBefore(view3);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view3);
                        } else {
                            Intent intent = new Intent(PersonalityLabelGalleryActivity.this, (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
                            PersonalityLabelGalleryActivity.this.startActivity(intent);
                            PersonalityLabelGalleryActivity.this.f259827t0.praiseCount += PersonalityLabelGalleryActivity.this.f259827t0.unreadCount;
                            PersonalityLabelGalleryActivity.this.f259827t0.unreadCount = 0;
                            PersonalityLabelGalleryActivity.this.f259812e0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.3.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                        PersonalityLabelGalleryActivity.this.L3(8);
                                    } else {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    }
                                }
                            }, 500L);
                            ReportController.o(PersonalityLabelGalleryActivity.this.app, "dc00898", "", "", "0X8007FCF", "0X8007FCF", 0, 0, "", "", "", "");
                        }
                        EventCollector.getInstance().onViewClicked(view3);
                    }
                });
                L3(0);
            } else {
                L3(8);
            }
            for (int i19 = 0; i19 < this.f259827t0.getSize(); i19++) {
                PersonalityLabelInfo personalityLabelInfo = profilePersonalityLabelInfo.personalityLabelInfos.get(i19);
                this.D0.put(Long.valueOf(personalityLabelInfo.f259897id), Integer.valueOf(personalityLabelInfo.isComplete() ? 1 : 0));
            }
        }
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo2 = this.f259827t0;
        if (profilePersonalityLabelInfo2 == null || profilePersonalityLabelInfo2.personalityLabelInfos == null || profilePersonalityLabelInfo2.getSize() <= 0) {
            z17 = false;
        }
        boolean r65 = uq3.c.r6();
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        Button button = this.f259821n0;
        if (!studyModeSwitch && r65 && z17) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        button.setVisibility(i16);
        View view3 = this.f259822o0;
        if (!studyModeSwitch && r65 && z17) {
            i17 = 0;
        }
        view3.setVisibility(i17);
    }

    void K3() {
        int i3;
        if (this.f259811d0) {
            if (!this.L0) {
                this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.f170869aw3));
                this.quiSecNavBar.setLeftType(2);
            } else {
                this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.b9f));
                this.quiSecNavBar.setLeftType(0);
            }
            this.quiSecNavBar.setOnBaseTitleBarClickListener(new g());
            if (v3()) {
                this.quiSecNavBar.setRightType(1);
            } else {
                this.quiSecNavBar.setRightType(0);
            }
        }
        if (this.L0) {
            this.f259814g0.setText(R.string.f202934yu);
            this.f259815h0.setText(R.string.fp7);
            return;
        }
        I3();
        TextView textView = this.f259815h0;
        if (this.f259811d0) {
            i3 = R.string.fp6;
        } else {
            i3 = R.string.fp8;
        }
        textView.setText(i3);
    }

    protected void Q3(long j3, boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (this.C0.get(Long.valueOf(j3)) != null) {
            Integer num = this.D0.get(Long.valueOf(j3));
            if (num != null && num.intValue() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelGalleryActivity", 2, "updateCookieIndex labelId:" + j3 + " add:" + z16 + " completed:" + z17);
            }
            byte[] bArr = this.C0.get(Long.valueOf(j3));
            if (!z17 && bArr.length > 0) {
                int p36 = p3(bArr);
                if (!z16) {
                    i3 = -1;
                }
                int i17 = p36 + i3;
                if (i17 >= 0) {
                    i16 = i17;
                }
                this.C0.put(Long.valueOf(j3), x3(i16));
            }
        }
    }

    void R3(int i3, String str, boolean z16) {
        if (this.f259824q0 == null) {
            this.f259824q0 = (TextView) findViewById(R.id.loading);
        }
        if (!TextUtils.isEmpty(str) && !str.equals(this.f259824q0.getText())) {
            this.f259824q0.setText(str);
        }
        if (i3 != this.f259824q0.getVisibility()) {
            this.f259824q0.setVisibility(i3);
        }
        if (z16) {
            if (!isTitleProgressShowing()) {
                startTitleProgress();
            }
        } else if (isTitleProgressShowing()) {
            stopTitleProgress();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1 && i16 == -1 && intent != null && (stringArrayListExtra = intent.getStringArrayListExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH)) != null && stringArrayListExtra.size() > 0) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "pick photo from qzone size:" + stringArrayListExtra.size());
            if (this.f259829v0 > 0) {
                this.f259830w0.clear();
                this.f259830w0.addAll(stringArrayListExtra);
                this.f259831x0 = 0;
                if (NetworkUtil.isNetworkAvailable(getApplicationContext())) {
                    this.Q0 = false;
                    l3();
                } else {
                    QQToast.makeText(getApplicationContext(), 0, R.string.f171137ci2, 0).show();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.ayz);
        s3(getIntent());
        this.f259811d0 = this.app.getCurrentAccountUin().equals(this.f259809b0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.card.modify_personality_label");
        intentFilter.setPriority(Integer.MAX_VALUE);
        registerReceiver(this.W0, intentFilter);
        this.f259808a0 = getResources().getDisplayMetrics().density;
        this.f259812e0 = (XListView) findViewById(R.id.ebs);
        View inflate = getLayoutInflater().inflate(R.layout.f168829az0, (ViewGroup) this.f259812e0, false);
        this.f259813f0 = inflate;
        this.f259812e0.addHeaderView(inflate);
        this.f259818k0 = (ViewStub) findViewById(R.id.bx4);
        ListViewAdapter listViewAdapter = new ListViewAdapter();
        this.f259825r0 = listViewAdapter;
        this.f259812e0.setAdapter((ListAdapter) listViewAdapter);
        this.f259819l0 = findViewById(R.id.f164624ac1);
        this.f259823p0 = (Button) findViewById(R.id.f166866ir0);
        this.f259820m0 = (Button) findViewById(R.id.f164030hl);
        this.f259821n0 = (Button) findViewById(R.id.ub7);
        this.f259822o0 = findViewById(R.id.uah);
        this.f259823p0.setOnClickListener(this);
        this.f259820m0.setOnClickListener(this);
        this.f259821n0.setOnClickListener(this);
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && uq3.c.r6() && this.f259811d0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Button button = this.f259821n0;
        int i16 = 8;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        button.setVisibility(i3);
        View view = this.f259822o0;
        if (z16) {
            i16 = 0;
        }
        view.setVisibility(i16);
        if (z16) {
            ProfileCardBubbleUtil.showCreateLabelVideoTips(this, this.f259822o0);
        }
        this.app.addObserver(this.Y0);
        addObserver(this.X0);
        this.f259814g0 = (TextView) this.f259813f0.findViewById(R.id.kbs);
        I3();
        this.f259815h0 = (TextView) this.f259813f0.findViewById(R.id.f167042k73);
        this.f259816i0 = (TextView) this.f259813f0.findViewById(R.id.kc5);
        if (this.f259811d0) {
            this.O0 = !getSharedPreferences("personality_label" + this.f259809b0, 0).getBoolean("tips_displayed", false);
        }
        FlingHandler flingHandler = GestureActivityModule.getFlingHandler(this);
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler)) {
            TopGestureLayout topGestureLayout = new TopGestureLayout(this);
            this.S0 = topGestureLayout;
            ((FlingGestureHandler) flingHandler).setTopLayout(topGestureLayout);
        }
        PLUploadManager pLUploadManager = (PLUploadManager) this.app.getManager(QQManagerFactory.PERSONALITY_LABELS_UPLOAD_MGR);
        this.T0 = pLUploadManager;
        if (this.f259811d0) {
            pLUploadManager.f(this);
        }
        R3(0, "\u6b63\u5728\u52a0\u8f7d...", true);
        this.J0.sendEmptyMessage(1);
        j3();
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH");
        PageParams pageParams = new PageParams(hashMap);
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this, "pg_qq_my_tag_page");
        VideoReport.setPageParams(this, pageParams);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH");
        VideoReport.setElementId(this.f259821n0, "em_qq_create_video");
        VideoReport.setElementParams(this.f259821n0, hashMap2);
        ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady(QQWinkConstants.ENTRY_QQ_WORLD, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnDestroy();
        bs.c().d();
        this.T0.f(null);
        this.J0.removeCallbacksAndMessages(null);
        this.K0.removeCallbacksAndMessages(null);
        removeObserver(this.X0);
        unregisterReceiver(this.W0);
        removeObserver(this.Y0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelGalleryActivity", 2, "select photos from phone album : size = " + stringArrayListExtra.size());
            }
            long longExtra = intent.getLongExtra("label_id", 0L);
            this.f259829v0 = longExtra;
            if (longExtra > 0) {
                this.f259830w0.clear();
                this.f259830w0.addAll(stringArrayListExtra);
                this.f259831x0 = 0;
                if (NetworkUtil.isNetworkAvailable(getApplicationContext())) {
                    this.Q0 = false;
                    l3();
                } else {
                    QQToast.makeText(getApplicationContext(), 0, R.string.f171137ci2, 0).show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnResume();
            w3();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnStop();
        H3();
        if (this.P0) {
            this.O0 = false;
            J3();
            if (this.K0.hasMessages(2)) {
                this.K0.removeMessages(2);
            }
            this.K0.sendEmptyMessage(2);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = message.what;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    this.f259825r0.notifyDataSetChanged();
                    if (message.arg1 == 1) {
                        this.f259812e0.setSelection(0);
                    }
                }
            } else {
                if (this.f259832y0 == 3) {
                    profilePersonalityLabelInfo = null;
                } else {
                    profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) FileUtils.readObject("profile_personality_v1.2_" + this.f259809b0);
                    if (profilePersonalityLabelInfo != null && (i3 = profilePersonalityLabelInfo.unreadCount) > 0) {
                        profilePersonalityLabelInfo.praiseCount += i3;
                        profilePersonalityLabelInfo.unreadCount = 0;
                    }
                }
                if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.getSize() > 0) {
                    for (int i17 = 0; i17 < profilePersonalityLabelInfo.personalityLabelInfos.size(); i17++) {
                        PersonalityLabelInfo personalityLabelInfo = profilePersonalityLabelInfo.personalityLabelInfos.get(i17);
                        this.T0.d(personalityLabelInfo.f259897id, personalityLabelInfo, false);
                    }
                }
                runOnUiThread(new Runnable(profilePersonalityLabelInfo) { // from class: com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ProfilePersonalityLabelInfo f259834d;

                    {
                        this.f259834d = profilePersonalityLabelInfo;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PersonalityLabelGalleryActivity.this, (Object) profilePersonalityLabelInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        int i18;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (!PersonalityLabelGalleryActivity.this.isFinishing()) {
                            PersonalityLabelGalleryActivity.this.F3(this.f259834d, false);
                            if (NetworkUtil.isNetSupport(PersonalityLabelGalleryActivity.this)) {
                                PersonalityLabelGalleryActivity.this.t3();
                                return;
                            }
                            PersonalityLabelGalleryActivity personalityLabelGalleryActivity = PersonalityLabelGalleryActivity.this;
                            personalityLabelGalleryActivity.showToast(personalityLabelGalleryActivity.getResources().getString(R.string.f171137ci2));
                            ProfilePersonalityLabelInfo profilePersonalityLabelInfo2 = this.f259834d;
                            if (profilePersonalityLabelInfo2 != null && profilePersonalityLabelInfo2.getSize() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            PersonalityLabelGalleryActivity personalityLabelGalleryActivity2 = PersonalityLabelGalleryActivity.this;
                            if (z16) {
                                i18 = 8;
                            } else {
                                i18 = 0;
                            }
                            personalityLabelGalleryActivity2.R3(i18, "\u52a0\u8f7d\u5931\u8d25", false);
                        }
                    }
                });
            }
        } else {
            ProfilePersonalityLabelInfo profilePersonalityLabelInfo2 = (ProfilePersonalityLabelInfo) message.obj;
            if (this.f259811d0) {
                str = this.app.getCurrentAccountUin();
            } else {
                str = this.f259809b0;
            }
            FileUtils.writeObject("profile_personality_v1.2_" + str, profilePersonalityLabelInfo2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager.b
    public void l2(List<PersonalityLabelPhoto> list, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, list, Long.valueOf(j3));
            return;
        }
        PersonalityLabelInfo personalityLabelInfo = this.f259828u0.get(Long.valueOf(j3));
        if (personalityLabelInfo == null) {
            return;
        }
        personalityLabelInfo.personalityLabelPhotos.addAll(0, list);
        personalityLabelInfo.photoCount += list.size();
        S3(j3, personalityLabelInfo);
        if (this.J0.hasMessages(0)) {
            this.J0.removeMessages(0);
        }
        this.J0.sendMessageDelayed(this.J0.obtainMessage(0, this.f259827t0), 200L);
    }

    void n3(PLUploadManager.a aVar, PersonalityLabelPhoto personalityLabelPhoto, o oVar) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label bindProgressState id:" + personalityLabelPhoto.fileId + " key:" + personalityLabelPhoto.uniseq + " item:" + aVar);
        }
        int i3 = 8;
        if (!personalityLabelPhoto.local) {
            MessageProgressView messageProgressView = oVar.f259894h;
            if (messageProgressView != null) {
                oVar.f259891d.removeView(messageProgressView);
                oVar.f259894h = null;
            }
            if (oVar.f259893f.getVisibility() != 8) {
                oVar.f259893f.setVisibility(8);
                return;
            }
            return;
        }
        String l3 = Long.toString(personalityLabelPhoto.uniseq);
        if (aVar == null) {
            MessageProgressView messageProgressView2 = oVar.f259894h;
            if (messageProgressView2 != null) {
                messageProgressView2.a(l3);
                oVar.f259894h.q(l3);
                oVar.f259891d.removeView(oVar.f259894h);
                oVar.f259894h = null;
            }
            if (oVar.f259893f.getVisibility() != 8) {
                oVar.f259893f.setVisibility(8);
                return;
            }
            return;
        }
        int i16 = aVar.f259799e;
        boolean z17 = true;
        if (i16 != 0 && i16 != 1 && i16 != 2) {
            if (i16 == 3 || i16 == 4) {
                MessageProgressView messageProgressView3 = oVar.f259894h;
                if (messageProgressView3 != null) {
                    messageProgressView3.a(l3);
                    if (aVar.f259799e != 3 && oVar.f259894h.o(l3)) {
                        if (aVar.f259799e == 4) {
                            oVar.f259894h.setDrawStatus(1);
                            oVar.f259894h.setAnimProgress(100, l3);
                        }
                    } else {
                        oVar.f259894h.q(l3);
                        oVar.f259891d.removeView(oVar.f259894h);
                        oVar.f259894h = null;
                    }
                }
                if (aVar.f259799e == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (oVar.f259893f.getVisibility() != 0) {
                    z17 = false;
                }
                if (z16 != z17) {
                    ImageView imageView = oVar.f259893f;
                    if (z16) {
                        i3 = 0;
                    }
                    imageView.setVisibility(i3);
                    return;
                }
                return;
            }
            return;
        }
        if (oVar.f259894h == null) {
            MessageProgressView messageProgressView4 = new MessageProgressView(this);
            messageProgressView4.setRadius(this.f259808a0 * 2.0f, false);
            messageProgressView4.setCustomSize(1);
            messageProgressView4.setShowCorner(false);
            messageProgressView4.setProgressBackgroudColor(HWColorFormat.COLOR_FormatVendorStartUnused);
            float f16 = this.f259808a0;
            oVar.f259891d.addView(messageProgressView4, new RelativeLayout.LayoutParams((int) (f16 * 120.0f), (int) (f16 * 120.0f)));
            oVar.f259894h = messageProgressView4;
        }
        oVar.f259894h.a(l3);
        if (aVar.f259799e != 2) {
            oVar.f259894h.setDrawStatus(1);
            oVar.f259894h.setAnimProgress(0, l3);
        } else {
            oVar.f259894h.setDrawStatus(1);
            oVar.f259894h.setAnimProgress(aVar.f259800f, l3);
        }
        if (oVar.f259893f.getVisibility() != 8) {
            oVar.f259893f.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.L0) {
            P3(true);
            return true;
        }
        if (this.A0 && this.f259832y0 == 3) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.card.modify_personality_label");
            Bundle bundle = new Bundle();
            bundle.putBoolean("onTagChanged", true);
            intent.putExtra(SpecialProxy.KEY_DATA, bundle);
            sendBroadcast(intent);
        }
        Intent intent2 = new Intent();
        intent2.putExtra(IProfileCardConst.KEY_PERSONALITY_LABEL_GALLERY_RESULT, u3(this.f259827t0));
        setResult(-1, intent2);
        if (this.f259832y0 == 4 && (str = this.f259809b0) != null && str.equalsIgnoreCase(this.app.getCurrentAccountUin())) {
            AllInOne allInOne = new AllInOne(this.f259809b0, 0);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("single_top", true);
            ProfileActivity.J2(getActivity(), allInOne, bundle2);
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (view == this.f259823p0 && (profilePersonalityLabelInfo = this.f259827t0) != null) {
            if (profilePersonalityLabelInfo != null) {
                Intent intent = new Intent(this, (Class<?>) PersonalityLabelShareActivity.class);
                intent.putExtra("data", (Parcelable) this.f259827t0);
                startActivity(intent);
                ReportController.o(this.app, "dc00898", "", "", "0X8007FD4", "0X8007FD4", 0, 0, "0", "0", "", "");
            }
        } else if (view != this.f259820m0 && R.id.f165091bw4 != view.getId()) {
            if (view == this.f259821n0 && uq3.c.r6()) {
                y3(this.f259827t0);
            }
        } else {
            ReportController.o(this.app, "dc00898", "", "", "0X8007FD3", "0X8007FD3", 0, 0, "0", "0", "", "");
            ProfilePersonalityLabelInfo profilePersonalityLabelInfo2 = this.f259827t0;
            if (profilePersonalityLabelInfo2 != null && profilePersonalityLabelInfo2.remainCount <= 0) {
                if (this.I0 == null) {
                    this.I0 = QQToast.makeText(this, "\u6700\u591a\u53ea\u80fd\u6dfb\u52a010\u4e2a\u6807\u7b7e\u3002", 0);
                }
                if (!this.I0.isShowing()) {
                    this.I0.show(getTitleBarHeight());
                }
            } else {
                ProfileCardUtil.k0(this.app.getCurrentAccountUin(), this.app, this, false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    boolean v3() {
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = this.f259827t0;
        if (profilePersonalityLabelInfo != null && profilePersonalityLabelInfo.getSize() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager.b
    public void w0(long j3, PLUploadManager.a aVar) {
        m mVar;
        o oVar;
        Object tag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), aVar);
            return;
        }
        PersonalityLabelPhoto personalityLabelPhoto = aVar.f259797c;
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState:" + personalityLabelPhoto.uniseq + " state:" + aVar.f259799e + " progress:" + aVar.f259800f);
        }
        if (aVar.f259799e == 4) {
            Q3(j3, true);
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.f259812e0.getChildCount()) {
                mVar = (m) this.f259812e0.getChildAt(i3).getTag();
                if (mVar != null && mVar.f259873a == j3) {
                    break;
                } else {
                    i3++;
                }
            } else {
                mVar = null;
                break;
            }
        }
        if (mVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find holder");
        }
        int i16 = 0;
        while (true) {
            if (i16 < mVar.f259881i.getChildCount()) {
                oVar = (o) mVar.f259881i.getChildViewHolder(mVar.f259881i.getChildAt(i16));
                if (oVar == null) {
                    tag = null;
                } else {
                    tag = oVar.f259891d.getTag(R.id.f166508fp3);
                }
                if (tag != null && (tag instanceof PLUploadManager.a) && ((PLUploadManager.a) tag).f259797c.uniseq == personalityLabelPhoto.uniseq) {
                    break;
                } else {
                    i16++;
                }
            } else {
                oVar = null;
                break;
            }
        }
        if (oVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelGalleryActivity", 2, "personality_label onUpdateState find childHolder");
        }
        n3(aVar, personalityLabelPhoto, oVar);
        int i17 = aVar.f259799e;
        if (i17 == 4) {
            this.A0 = true;
            oVar.f259891d.setTag(R.id.f166508fp3, null);
            if (this.J0.hasMessages(0)) {
                this.J0.removeMessages(0);
            }
            this.J0.sendMessageDelayed(this.J0.obtainMessage(0, this.f259827t0), 200L);
            return;
        }
        if (i17 == 3) {
            QQToast.makeText(this, 0, "\u4e0a\u4f20\u56fe\u7247\u5931\u8d25", 0).show();
        }
    }

    void w3() {
        if (!this.f259811d0) {
            this.quiSecNavBar.setRightType(0);
        }
    }

    boolean z3(int i3) {
        if (this.f259811d0 && !this.L0 && this.O0 && i3 == this.V0) {
            return true;
        }
        return false;
    }
}
