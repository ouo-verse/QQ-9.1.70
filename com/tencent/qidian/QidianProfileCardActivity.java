package com.tencent.qidian;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.membersetting.ITroopMemberSettingApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ITroopMemberCardApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes22.dex */
public class QidianProfileCardActivity extends ProfileActivity {
    static IPatchRedirector $redirector_;
    public QQProgressDialog A0;
    public BmqqUserSimpleInfo B0;
    QidianManager C0;
    FriendsManager D0;
    CardHandler E0;
    private boolean F0;
    private boolean G0;
    private boolean H0;
    PhotoWallViewForQiDianProfile.c I0;
    private com.tencent.mobileqq.avatar.observer.a J0;
    protected com.tencent.mobileqq.troop.api.observer.e K0;
    private ar L0;
    private View.OnLongClickListener M0;
    private View.OnClickListener N0;
    private CardObserver O0;
    private ProfileCardObserver P0;
    private com.tencent.qidian.controller.a Q0;
    private mx.a R0;
    private QQToastNotifier S0;
    QQCustomDialog T0;
    private String U0;
    private String V0;
    com.tencent.mobileqq.hitrate.b W0;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f342698a0;

    /* renamed from: b0, reason: collision with root package name */
    public ImageView f342699b0;

    /* renamed from: c0, reason: collision with root package name */
    public ImageView f342700c0;

    /* renamed from: d0, reason: collision with root package name */
    public LinearLayout f342701d0;

    /* renamed from: e0, reason: collision with root package name */
    public LinearLayout f342702e0;

    /* renamed from: f0, reason: collision with root package name */
    private BounceScrollView f342703f0;

    /* renamed from: g0, reason: collision with root package name */
    private RelativeLayout f342704g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f342705h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f342706i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f342707j0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f342708k0;

    /* renamed from: l0, reason: collision with root package name */
    private ImageView f342709l0;

    /* renamed from: m0, reason: collision with root package name */
    ProfileCardInfo f342710m0;

    /* renamed from: n0, reason: collision with root package name */
    public Bitmap f342711n0;

    /* renamed from: o0, reason: collision with root package name */
    private x f342712o0;

    /* renamed from: p0, reason: collision with root package name */
    public QidianExternalInfo f342713p0;

    /* renamed from: q0, reason: collision with root package name */
    private QidianCorpInfo f342714q0;

    /* renamed from: r0, reason: collision with root package name */
    private QidianProfileUiInfo f342715r0;

    /* renamed from: s0, reason: collision with root package name */
    public ConcurrentHashMap<String, w> f342716s0;

    /* renamed from: t0, reason: collision with root package name */
    public ConcurrentHashMap<String, Drawable> f342717t0;

    /* renamed from: u0, reason: collision with root package name */
    Dialog f342718u0;

    /* renamed from: v0, reason: collision with root package name */
    private ActionSheet f342719v0;

    /* renamed from: w0, reason: collision with root package name */
    private ActionSheet f342720w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f342721x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f342722y0;

    /* renamed from: z0, reason: collision with root package name */
    int f342723z0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class ForwardRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QidianProfileCardActivity> f342735d;

        /* renamed from: e, reason: collision with root package name */
        private URLDrawable f342736e;

        ForwardRunnable(QidianProfileCardActivity qidianProfileCardActivity, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qidianProfileCardActivity, (Object) uRLDrawable);
            } else {
                this.f342735d = new WeakReference<>(qidianProfileCardActivity);
                this.f342736e = uRLDrawable;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QidianProfileCardActivity qidianProfileCardActivity = this.f342735d.get();
            if (qidianProfileCardActivity == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("forward_type", 1);
            String str = AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE;
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = str + Utils.Crc64String(qidianProfileCardActivity.f342710m0.allInOne.uin) + Utils.Crc64String(this.f342736e.getURL().toString());
            if (!new File(str2).exists()) {
                try {
                    str2 = this.f342736e.saveTo(str2);
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QidianProfileCardActivity", 2, "IOException", e16);
                    }
                    qidianProfileCardActivity.runOnUiThread(new Runnable(qidianProfileCardActivity) { // from class: com.tencent.qidian.QidianProfileCardActivity.ForwardRunnable.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ QidianProfileCardActivity f342737d;

                        {
                            this.f342737d = qidianProfileCardActivity;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardRunnable.this, (Object) qidianProfileCardActivity);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                QQToast.makeText(this.f342737d, HardCodeUtil.qqStr(R.string.qbz), 0).show(this.f342737d.getTitleBarHeight());
                            }
                        }
                    });
                    return;
                }
            }
            bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, true);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, this.f342736e.getURL().toString());
            bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str2);
            bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, this.f342736e.getURL().toString());
            bundle.putString(AppConstants.Key.FORWARD_EXTRA, str2);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(qidianProfileCardActivity, intent, 21);
        }
    }

    /* loaded from: classes22.dex */
    public static class QidianCompoundProfileItem implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<QidianCompoundProfileItem> CREATOR;
        public String C;
        public String D;

        /* renamed from: d, reason: collision with root package name */
        public String f342738d;

        /* renamed from: e, reason: collision with root package name */
        public String f342739e;

        /* renamed from: f, reason: collision with root package name */
        public String f342740f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f342741h;

        /* renamed from: i, reason: collision with root package name */
        public int f342742i;

        /* renamed from: m, reason: collision with root package name */
        public boolean f342743m;

        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<QidianCompoundProfileItem> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QidianCompoundProfileItem createFromParcel(Parcel parcel) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QidianCompoundProfileItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                QidianCompoundProfileItem qidianCompoundProfileItem = new QidianCompoundProfileItem();
                qidianCompoundProfileItem.f342738d = parcel.readString();
                qidianCompoundProfileItem.f342739e = parcel.readString();
                qidianCompoundProfileItem.f342740f = parcel.readString();
                boolean z17 = true;
                if (parcel.readByte() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qidianCompoundProfileItem.f342741h = z16;
                qidianCompoundProfileItem.f342742i = parcel.readInt();
                if (parcel.readByte() == 0) {
                    z17 = false;
                }
                qidianCompoundProfileItem.f342743m = z17;
                qidianCompoundProfileItem.C = parcel.readString();
                qidianCompoundProfileItem.D = parcel.readString();
                return qidianCompoundProfileItem;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QidianCompoundProfileItem[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (QidianCompoundProfileItem[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new QidianCompoundProfileItem[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77525);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                CREATOR = new a();
            }
        }

        public QidianCompoundProfileItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f342741h = false;
                this.f342743m = false;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeString(this.f342738d);
            parcel.writeString(this.f342739e);
            parcel.writeString(this.f342740f);
            parcel.writeByte(this.f342741h ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f342742i);
            parcel.writeByte(this.f342743m ? (byte) 1 : (byte) 0);
            parcel.writeString(this.C);
            parcel.writeString(this.D);
        }
    }

    /* loaded from: classes22.dex */
    public static class QidianSimpleProfileItem implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<QidianSimpleProfileItem> CREATOR;
        public boolean C;
        public boolean D;
        public int E;

        /* renamed from: d, reason: collision with root package name */
        public String f342744d;

        /* renamed from: e, reason: collision with root package name */
        public String f342745e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f342746f;

        /* renamed from: h, reason: collision with root package name */
        public int f342747h;

        /* renamed from: i, reason: collision with root package name */
        public int f342748i;

        /* renamed from: m, reason: collision with root package name */
        public String f342749m;

        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<QidianSimpleProfileItem> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QidianSimpleProfileItem createFromParcel(Parcel parcel) {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QidianSimpleProfileItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                QidianSimpleProfileItem qidianSimpleProfileItem = new QidianSimpleProfileItem();
                qidianSimpleProfileItem.f342744d = parcel.readString();
                qidianSimpleProfileItem.f342745e = parcel.readString();
                boolean z18 = true;
                if (parcel.readByte() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qidianSimpleProfileItem.f342746f = z16;
                qidianSimpleProfileItem.f342747h = parcel.readInt();
                qidianSimpleProfileItem.f342748i = parcel.readInt();
                qidianSimpleProfileItem.f342749m = parcel.readString();
                if (parcel.readByte() != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                qidianSimpleProfileItem.C = z17;
                if (parcel.readByte() == 0) {
                    z18 = false;
                }
                qidianSimpleProfileItem.D = z18;
                qidianSimpleProfileItem.E = parcel.readInt();
                return qidianSimpleProfileItem;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QidianSimpleProfileItem[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (QidianSimpleProfileItem[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new QidianSimpleProfileItem[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77527);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                CREATOR = new a();
            }
        }

        public QidianSimpleProfileItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f342747h = 1;
            this.f342748i = 0;
            this.C = false;
            this.D = false;
            this.E = 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeString(this.f342744d);
            parcel.writeString(this.f342745e);
            parcel.writeByte(this.f342746f ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f342747h);
            parcel.writeInt(this.f342748i);
            parcel.writeString(this.f342749m);
            parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class SavePhotoRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QidianProfileCardActivity> f342750d;

        /* renamed from: e, reason: collision with root package name */
        private URLDrawable f342751e;

        /* renamed from: f, reason: collision with root package name */
        private String f342752f;

        SavePhotoRunnable(QidianProfileCardActivity qidianProfileCardActivity, URLDrawable uRLDrawable, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qidianProfileCardActivity, uRLDrawable, str);
                return;
            }
            this.f342750d = new WeakReference<>(qidianProfileCardActivity);
            this.f342751e = uRLDrawable;
            this.f342752f = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.qidian.QidianProfileCardActivity, android.content.Context, android.app.Activity] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QidianProfileCardActivity qidianProfileCardActivity = this.f342750d.get();
            if (qidianProfileCardActivity == 0) {
                return;
            }
            ?? r16 = 2131895714;
            r16 = 2131895714;
            try {
                String saveTo = this.f342751e.saveTo(this.f342752f);
                if (saveTo != null) {
                    BaseImageUtil.savePhotoToSysAlbum(qidianProfileCardActivity, saveTo);
                    r16 = qidianProfileCardActivity.getString(R.string.cwj) + " " + saveTo;
                } else {
                    r16 = qidianProfileCardActivity.getString(R.string.cwi);
                }
            } catch (IOException unused) {
                r16 = qidianProfileCardActivity.getString(r16);
            } catch (OutOfMemoryError unused2) {
                r16 = qidianProfileCardActivity.getString(r16);
            }
            qidianProfileCardActivity.runOnUiThread(new Runnable(qidianProfileCardActivity, r16) { // from class: com.tencent.qidian.QidianProfileCardActivity.SavePhotoRunnable.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QidianProfileCardActivity f342753d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f342754e;

                {
                    this.f342753d = qidianProfileCardActivity;
                    this.f342754e = r16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SavePhotoRunnable.this, qidianProfileCardActivity, r16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(this.f342753d, this.f342754e, 0).show(this.f342753d.getTitleBarHeight());
                    }
                }
            });
        }
    }

    /* loaded from: classes22.dex */
    class a implements PhotoWallViewForQiDianProfile.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // com.tencent.qidian.PhotoWallViewForQiDianProfile.c
        public void a(com.tencent.qidian.data.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (aVar != null) {
                String str = aVar.f342872b;
                if (!TextUtils.isEmpty(str)) {
                    QidianProfileCardActivity.this.g4(str);
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            super.onUpdateCustomHead(z16, str);
            if (z16) {
                if (str.equals(QidianProfileCardActivity.this.f342710m0.allInOne.uin)) {
                    if (SimpleUIUtil.getSimpleUISwitch()) {
                        QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                        qidianProfileCardActivity.f342711n0 = qidianProfileCardActivity.app.getFaceBitmap(str, (byte) 2, false);
                    } else {
                        QidianProfileCardActivity qidianProfileCardActivity2 = QidianProfileCardActivity.this;
                        qidianProfileCardActivity2.f342711n0 = qidianProfileCardActivity2.app.getFaceBitmap(str, false);
                    }
                    QidianProfileCardActivity.this.n4();
                    return;
                }
                w wVar = QidianProfileCardActivity.this.f342716s0.get(str);
                if (wVar != null) {
                    QidianProfileCardActivity.this.o4(wVar.f342799b, wVar.f342798a.get(), wVar.f342800c, true);
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    class c extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopMemberCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            try {
                if (QidianProfileCardActivity.this.isFinishing()) {
                    QLog.d("QidianProfileCardActivity", 1, "onGetTroopMemberCard return because is finished!");
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QidianProfileCardActivity", 2, "onGetTroopMemberCard: isSuccess " + z16);
                }
                if (z16) {
                    Object[] objArr = (Object[]) obj;
                    long longValue = ((Long) objArr[0]).longValue();
                    TroopMemberCard troopMemberCard = (TroopMemberCard) objArr[2];
                    if (longValue != Long.parseLong(QidianProfileCardActivity.this.f342710m0.allInOne.troopCode)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QidianProfileCardActivity", 2, "onGetTroopMemberCard: troopUin != mTroopUin, " + longValue + "!=" + QidianProfileCardActivity.this.f342710m0.allInOne.troopUin);
                            return;
                        }
                        return;
                    }
                    if (troopMemberCard == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QidianProfileCardActivity", 2, "onGetTroopMemberCard: troopMemberCard is null");
                            return;
                        }
                        return;
                    }
                    long j3 = troopMemberCard.memberUin;
                    if (j3 != Long.parseLong(QidianProfileCardActivity.this.f342710m0.allInOne.uin)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QidianProfileCardActivity", 2, "onGetTroopMemberCard: memberUin != mMemberUin, " + j3 + "!=" + QidianProfileCardActivity.this.f342710m0.allInOne.uin);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("QidianProfileCardActivity", 2, "updateParams: uint32_result:" + troopMemberCard.result + " memberRole:" + troopMemberCard.memberRole);
                    }
                    QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                    ProfileCardInfo profileCardInfo = qidianProfileCardActivity.f342710m0;
                    profileCardInfo.troopMemberCard = troopMemberCard;
                    profileCardInfo.troopShowMoreBtn = true;
                    if (troopMemberCard.result == 260 && troopMemberCard.memberRole == 0) {
                        QQToast.makeText(qidianProfileCardActivity, 1, HardCodeUtil.qqStr(R.string.msz), 0).show();
                        if (!((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).isQiDianPrivateTroop(QidianProfileCardActivity.this.f342710m0.allInOne.troopCode)) {
                            QidianProfileCardActivity.this.f342710m0.isTroopMemberCard = false;
                            return;
                        } else {
                            QidianProfileCardActivity.this.f342710m0.troopShowMoreBtn = false;
                            return;
                        }
                    }
                    if (troopMemberCard.titleId == 0) {
                        qidianProfileCardActivity.G3(troopMemberCard);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianProfileCardActivity", 2, "onGetTroopMemberCard: updateCardInfo");
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("QidianProfileCardActivity", 2, "onGetTroopMemberCard:" + e16);
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    class d extends ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
            } else if (z16 && QidianProfileCardActivity.this.f342710m0.allInOne.uin.equals(String.valueOf(obj))) {
                QidianProfileCardActivity.this.T3();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            QidianProfileCardActivity qidianProfileCardActivity;
            FriendsManager friendsManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16 && z17) {
                AllInOne allInOne = QidianProfileCardActivity.this.f342710m0.allInOne;
                if (allInOne.uin != null && !ProfilePAUtils.isPaTypeFriend(allInOne) && (friendsManager = (qidianProfileCardActivity = QidianProfileCardActivity.this).D0) != null && friendsManager.c0(qidianProfileCardActivity.f342710m0.allInOne.uin)) {
                    QidianProfileCardActivity qidianProfileCardActivity2 = QidianProfileCardActivity.this;
                    if (!qidianProfileCardActivity2.f342710m0.allInOne.uin.equals(qidianProfileCardActivity2.app.getCurrentAccountUin())) {
                        QidianProfileCardActivity qidianProfileCardActivity3 = QidianProfileCardActivity.this;
                        AllInOne allInOne2 = qidianProfileCardActivity3.f342710m0.allInOne;
                        allInOne2.f260789pa = 1;
                        qidianProfileCardActivity3.y4(allInOne2.uin);
                        QidianProfileCardActivity.this.T3();
                    }
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    class e implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public String f342759d;

        /* renamed from: e, reason: collision with root package name */
        public BubblePopupWindow f342760e;

        /* renamed from: f, reason: collision with root package name */
        private View.OnClickListener f342761f;

        /* loaded from: classes22.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    ((ClipboardManager) QidianProfileCardActivity.this.getSystemService("clipboard")).setText(e.this.f342759d);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* loaded from: classes22.dex */
        class b implements BubblePopupWindow.OnDismissListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public void onDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    e.this.f342760e = null;
                }
            }
        }

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
                return;
            }
            this.f342759d = "";
            this.f342760e = null;
            this.f342761f = new a();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                int id5 = view.getId();
                this.f342759d = String.valueOf(view.getTag());
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                aVar.a(id5, HardCodeUtil.qqStr(R.string.qbw));
                BubblePopupWindow c16 = com.tencent.mobileqq.utils.s.c(view, aVar, this.f342761f);
                this.f342760e = c16;
                c16.setOnDismissListener(new b());
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* loaded from: classes22.dex */
    class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private long f342765d;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            } else {
                this.f342765d = 0L;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Card card;
            String[] split;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.f342765d) >= 1000) {
                    this.f342765d = currentTimeMillis;
                    com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) view.getTag();
                    int i3 = bVar.f260135a;
                    if (i3 != 4) {
                        if (i3 != 20) {
                            if (i3 != 82) {
                                if (i3 != 106) {
                                    if (i3 != 7) {
                                        if (i3 != 8) {
                                            if (i3 == 75) {
                                                QidianProfileCardActivity.this.g4(String.valueOf(bVar.f260136b));
                                            } else if (i3 != 76) {
                                                switch (i3) {
                                                    case 47:
                                                        QidianProfileCardActivity.this.C3(String.valueOf(bVar.f260136b));
                                                        break;
                                                    case 48:
                                                        String[] strArr = (String[]) bVar.f260136b;
                                                        QidianProfileCardActivity.this.E3(strArr[0], strArr[1]);
                                                        break;
                                                    case 49:
                                                        QidianProfileCardActivity.this.t4(String.valueOf(bVar.f260136b));
                                                        break;
                                                    case 51:
                                                        QidianProfileCardActivity.this.s4(String.valueOf(bVar.f260136b));
                                                        break;
                                                    case 52:
                                                        QidianProfileCardActivity.this.v4(String.valueOf(bVar.f260136b));
                                                        break;
                                                    case 53:
                                                        QidianProfileCardActivity.this.D3();
                                                        break;
                                                    case 54:
                                                        QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                                                        ax c16 = bi.c(qidianProfileCardActivity.app, qidianProfileCardActivity, String.valueOf(bVar.f260136b));
                                                        if (c16 != null) {
                                                            c16.b();
                                                            break;
                                                        }
                                                        break;
                                                    case 55:
                                                        QidianProfileCardActivity.this.B3();
                                                        break;
                                                }
                                            } else {
                                                String valueOf = String.valueOf(bVar.f260136b);
                                                if (!TextUtils.isEmpty(valueOf) && valueOf.contains("|") && (split = valueOf.split("\\|")) != null && split.length == 2) {
                                                    QidianProfileCardActivity.this.h4(split[0], split[1]);
                                                }
                                            }
                                        } else {
                                            QidianProfileCardActivity.this.A3(((Integer) bVar.f260136b).intValue());
                                        }
                                    } else {
                                        QidianProfileCardActivity.this.u3();
                                    }
                                }
                                QidianProfileCardActivity.this.w4((com.tencent.qidian.data.c) bVar.f260136b, i3);
                            } else if (!QidianProfileCardActivity.this.H0) {
                                QidianProfileCardActivity.this.H0 = true;
                                QidianProfileCardActivity qidianProfileCardActivity2 = QidianProfileCardActivity.this;
                                ProfileCardInfo profileCardInfo = qidianProfileCardActivity2.f342710m0;
                                if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
                                    qidianProfileCardActivity2.a4(card.vQzoneCoverInfo);
                                } else {
                                    qidianProfileCardActivity2.showLoading(R.string.d7n);
                                    QidianProfileCardActivity qidianProfileCardActivity3 = QidianProfileCardActivity.this;
                                    ProfileCardInfo profileCardInfo2 = qidianProfileCardActivity3.f342710m0;
                                    if (profileCardInfo2 != null && profileCardInfo2.allInOne != null) {
                                        CardHandler cardHandler = qidianProfileCardActivity3.E0;
                                        String currentAccountUin = qidianProfileCardActivity3.app.getCurrentAccountUin();
                                        AllInOne allInOne = QidianProfileCardActivity.this.f342710m0.allInOne;
                                        cardHandler.m3(currentAccountUin, allInOne.uin, 1, 0L, (byte) 1, 0L, 0L, new byte[]{0}, "", ProfileUtils.getControl(allInOne, false), 10004, new byte[]{0}, (byte) 0);
                                    }
                                }
                            }
                        } else {
                            ReportController.n(QidianProfileCardActivity.this.app, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "1", "1", "", "");
                            QidianProfileCardActivity qidianProfileCardActivity4 = QidianProfileCardActivity.this;
                            if (qidianProfileCardActivity4.f342723z0 == 6) {
                                ChatActivityUtils.h0(qidianProfileCardActivity4.app, qidianProfileCardActivity4, 1024, qidianProfileCardActivity4.f342710m0.allInOne.uin, qidianProfileCardActivity4.f342713p0.nickname, null, true, null, true, true, null, "from_internal");
                            } else {
                                ProfileBottomContainer.enterAudioCall(qidianProfileCardActivity4.app, qidianProfileCardActivity4, qidianProfileCardActivity4.f342710m0);
                            }
                        }
                    } else {
                        QidianProfileCardActivity.this.r4(String.valueOf(bVar.f260136b));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class g implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f342767d;

        g(String str) {
            this.f342767d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this, (Object) str);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
            if (qidianProfileCardActivity.f342723z0 == 1) {
                if (i3 == 0) {
                    qidianProfileCardActivity.z3(this.f342767d);
                } else if (i3 == 1) {
                    qidianProfileCardActivity.B3();
                }
            } else if (i3 == 0) {
                qidianProfileCardActivity.z3(this.f342767d);
            }
            QidianProfileCardActivity.this.f342720w0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class h implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f342769d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f342770e;

        h(boolean z16, String str) {
            this.f342769d = z16;
            this.f342770e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QidianProfileCardActivity.this, Boolean.valueOf(z16), str);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            boolean z16 = this.f342769d;
            QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
            if (qidianProfileCardActivity.f342723z0 == 1) {
                if (i3 == z16) {
                    qidianProfileCardActivity.z3(this.f342770e);
                } else if (i3 == (z16 ? 1 : 0) + 1) {
                    if (qidianProfileCardActivity.C0.X(qidianProfileCardActivity.f342710m0.allInOne.uin)) {
                        QidianProfileCardActivity.this.B3();
                    } else {
                        QidianProfileCardActivity.this.F3(this.f342770e);
                    }
                } else if (i3 == (z16 ? 1 : 0) + 2) {
                    qidianProfileCardActivity.F3(this.f342770e);
                }
            } else if (i3 == z16) {
                qidianProfileCardActivity.z3(this.f342770e);
            } else if (i3 == (z16 ? 1 : 0) + 1) {
                qidianProfileCardActivity.F3(this.f342770e);
            }
            if (this.f342769d && i3 == 0) {
                return;
            }
            QidianProfileCardActivity.this.f342719v0.dismiss();
        }
    }

    /* loaded from: classes22.dex */
    class i extends CardObserver {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onGetAccountType(boolean z16, BmqqAccountType bmqqAccountType) {
            ProfileCardInfo profileCardInfo;
            String str;
            AllInOne allInOne;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bmqqAccountType);
                return;
            }
            super.onGetAccountType(z16, bmqqAccountType);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetAccountType isSuccess: ");
                sb5.append(z16);
                sb5.append(" | type: ");
                sb5.append(bmqqAccountType);
                sb5.append(" | cardInfo.allinone.uin: ");
                ProfileCardInfo profileCardInfo2 = QidianProfileCardActivity.this.f342710m0;
                if (profileCardInfo2 != null && (allInOne = profileCardInfo2.allInOne) != null) {
                    str = allInOne.uin;
                } else {
                    str = "null";
                }
                sb5.append(str);
                QLog.d("QidianProfileCardActivity", 2, sb5.toString());
            }
            if (bmqqAccountType != null && bmqqAccountType.getUin() != null && (profileCardInfo = QidianProfileCardActivity.this.f342710m0) != null && profileCardInfo.allInOne != null && bmqqAccountType.getUin().equals(QidianProfileCardActivity.this.f342710m0.allInOne.uin)) {
                QidianProfileCardActivity.this.f342723z0 = bmqqAccountType.getAccountType();
                QidianProfileCardActivity.this.T3();
                QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                if (qidianProfileCardActivity.f342723z0 == 1) {
                    qidianProfileCardActivity.C0.z(qidianProfileCardActivity, bmqqAccountType);
                } else {
                    qidianProfileCardActivity.removeLoading();
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    class j extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            QidianProfileCardActivity.this.removeLoading();
            if (z16 && obj != null && (obj instanceof Card)) {
                QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                qidianProfileCardActivity.f342710m0.card = (Card) obj;
                if (qidianProfileCardActivity.H0) {
                    QidianProfileCardActivity qidianProfileCardActivity2 = QidianProfileCardActivity.this;
                    qidianProfileCardActivity2.a4(qidianProfileCardActivity2.f342710m0.card.vQzoneCoverInfo);
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    class k extends com.tencent.qidian.controller.a {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
        @Override // com.tencent.qidian.controller.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void h(boolean z16, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            boolean z18 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), hashMap);
                return;
            }
            super.h(z16, hashMap);
            QidianProfileCardActivity.this.removeLoading();
            if (z16 && hashMap != null) {
                if (hashMap.containsKey("external") && hashMap.get("external") != null) {
                    QidianExternalInfo qidianExternalInfo = (QidianExternalInfo) hashMap.get("external");
                    if (!QidianProfileCardActivity.this.f342710m0.allInOne.uin.equals(qidianExternalInfo.uin)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not current uin");
                            return;
                        }
                        return;
                    } else if (!qidianExternalInfo.equals(QidianProfileCardActivity.this.f342713p0)) {
                        QidianProfileCardActivity.this.f342713p0 = qidianExternalInfo;
                        z17 = true;
                    }
                }
                if (hashMap.containsKey("ConfigGroupInfo") && hashMap.get("ConfigGroupInfo") != null) {
                    QidianProfileUiInfo qidianProfileUiInfo = (QidianProfileUiInfo) hashMap.get("ConfigGroupInfo");
                    if (!qidianProfileUiInfo.equals(QidianProfileCardActivity.this.f342715r0)) {
                        QidianProfileCardActivity.this.f342715r0 = qidianProfileUiInfo;
                        if (!z18) {
                            QidianProfileCardActivity.this.C4(6);
                            QidianProfileCardActivity.this.T3();
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not change");
                                return;
                            }
                            return;
                        }
                    }
                }
                z18 = z17;
                if (!z18) {
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo fail");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qidian.controller.a
        public void i(boolean z16, HashMap<String, Object> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashMap);
                return;
            }
            super.i(z16, hashMap);
            QidianProfileCardActivity.this.removeLoading();
            if (z16 && hashMap != null && hashMap.containsKey("external") && hashMap.get("external") != null && hashMap.containsKey("corp") && hashMap.get("corp") != null && hashMap.containsKey("ConfigGroupInfo") && hashMap.get("ConfigGroupInfo") != null) {
                QidianExternalInfo qidianExternalInfo = (QidianExternalInfo) hashMap.get("external");
                QidianCorpInfo qidianCorpInfo = (QidianCorpInfo) hashMap.get("corp");
                QidianProfileUiInfo qidianProfileUiInfo = (QidianProfileUiInfo) hashMap.get("ConfigGroupInfo");
                if (QidianProfileCardActivity.this.f342710m0.allInOne.uin.equals(qidianExternalInfo.uin)) {
                    if (!qidianExternalInfo.equals(QidianProfileCardActivity.this.f342713p0) || !qidianCorpInfo.equals(QidianProfileCardActivity.this.f342714q0) || !qidianProfileUiInfo.equals(QidianProfileCardActivity.this.f342715r0)) {
                        z17 = true;
                    }
                    if (z17) {
                        QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                        qidianProfileCardActivity.f342713p0 = qidianExternalInfo;
                        qidianProfileCardActivity.f342714q0 = qidianCorpInfo;
                        QidianProfileCardActivity.this.f342715r0 = qidianProfileUiInfo;
                        QidianProfileCardActivity.this.C4(1);
                        QidianProfileCardActivity.this.T3();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not change");
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not current uin");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo fail");
            }
        }
    }

    /* loaded from: classes22.dex */
    class l extends mx.a {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // mx.a
        protected void a(boolean z16, BmqqUserSimpleInfo bmqqUserSimpleInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bmqqUserSimpleInfo);
                return;
            }
            QidianProfileCardActivity.this.removeLoading();
            if (z16 && bmqqUserSimpleInfo != null) {
                if (bmqqUserSimpleInfo.mBmqqUin.equals(QidianProfileCardActivity.this.f342710m0.allInOne.uin)) {
                    if (!bmqqUserSimpleInfo.equals(QidianProfileCardActivity.this.B0)) {
                        QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                        qidianProfileCardActivity.B0 = bmqqUserSimpleInfo;
                        qidianProfileCardActivity.C4(0);
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not change");
                            return;
                        }
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver not current uin");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QidianProfileCardActivity", 2, "BmqqBusinessObserver fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class n implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f342777d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.qidian.data.c f342778e;

        n(Drawable drawable, com.tencent.qidian.data.c cVar) {
            this.f342777d = drawable;
            this.f342778e = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QidianProfileCardActivity.this, drawable, cVar);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                Drawable drawable = this.f342777d;
                if (drawable instanceof URLDrawable) {
                    QidianProfileCardActivity.this.u4((URLDrawable) drawable, this.f342778e.f342878b);
                }
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class o implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f342780d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f342781e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f342782f;

        o(ActionSheet actionSheet, URLDrawable uRLDrawable, String str) {
            this.f342780d = actionSheet;
            this.f342781e = uRLDrawable;
            this.f342782f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QidianProfileCardActivity.this, actionSheet, uRLDrawable, str);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (view == null) {
                this.f342780d.dismiss();
                return;
            }
            String content = this.f342780d.getContent(i3);
            if (TextUtils.isEmpty(content)) {
                this.f342780d.dismiss();
                return;
            }
            if (content.equals(QidianProfileCardActivity.this.getString(R.string.bsj))) {
                QidianProfileCardActivity.this.H3(this.f342781e);
            } else if (content.equals(QidianProfileCardActivity.this.getString(R.string.bst))) {
                QidianProfileCardActivity.this.savePic(this.f342781e);
            } else if (content.equals(QidianProfileCardActivity.this.getString(R.string.f0p))) {
                QidianProfileCardActivity.this.y3(this.f342782f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class q implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f342785d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f342786e;

        q(URLDrawable uRLDrawable, String str) {
            this.f342785d = uRLDrawable;
            this.f342786e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QidianProfileCardActivity.this, uRLDrawable, str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QidianProfileCardActivity.this.savePhoto(this.f342785d, this.f342786e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class r implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                ProfileCardUtil.A0(qidianProfileCardActivity, qidianProfileCardActivity.f342699b0, qidianProfileCardActivity.f342710m0.allInOne.uin);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class s implements BounceScrollView.d {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void ae(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        @Override // com.tencent.mobileqq.widget.BounceScrollView.d
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class t implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TextView textView = QidianProfileCardActivity.this.f342707j0;
                if (QidianProfileCardActivity.this.G0) {
                    i3 = 1;
                } else {
                    i3 = 3;
                }
                textView.setMaxLines(i3);
                QidianProfileCardActivity.this.G0 = !r0.G0;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class u implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QidianProfileCardActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class v extends URLDrawableDownListener.Adapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<URLImageView> f342792d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<QQAppInterface> f342793e;

        /* renamed from: f, reason: collision with root package name */
        String f342794f;

        /* renamed from: h, reason: collision with root package name */
        WeakReference<Drawable> f342795h;

        /* renamed from: i, reason: collision with root package name */
        boolean f342796i;

        /* renamed from: m, reason: collision with root package name */
        WeakReference<QidianProfileCardActivity> f342797m;

        public v(QidianProfileCardActivity qidianProfileCardActivity, QQAppInterface qQAppInterface, URLImageView uRLImageView, String str, Drawable drawable, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qidianProfileCardActivity, qQAppInterface, uRLImageView, str, drawable, Boolean.valueOf(z16));
                return;
            }
            this.f342792d = null;
            this.f342793e = null;
            this.f342794f = "";
            this.f342795h = null;
            this.f342796i = true;
            this.f342797m = null;
            this.f342792d = new WeakReference<>(uRLImageView);
            this.f342794f = str;
            this.f342793e = new WeakReference<>(qQAppInterface);
            this.f342795h = new WeakReference<>(drawable);
            this.f342796i = z16;
            this.f342797m = new WeakReference<>(qidianProfileCardActivity);
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            super.onLoadSuccessed(view, uRLDrawable);
            URLImageView uRLImageView = this.f342792d.get();
            QQAppInterface qQAppInterface = this.f342793e.get();
            QidianProfileCardActivity qidianProfileCardActivity = this.f342797m.get();
            if (uRLImageView != null && qQAppInterface != null && qidianProfileCardActivity != null && !TextUtils.isEmpty(this.f342794f)) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(QidianProfileCardActivity.I3(qQAppInterface, uRLDrawable, this.f342796i));
                if (this.f342796i) {
                    qidianProfileCardActivity.f342717t0.put(this.f342794f, bitmapDrawable);
                }
                uRLImageView.setImageDrawable(bitmapDrawable);
            }
        }
    }

    /* loaded from: classes22.dex */
    public static class w {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<URLImageView> f342798a;

        /* renamed from: b, reason: collision with root package name */
        public int f342799b;

        /* renamed from: c, reason: collision with root package name */
        public String f342800c;

        public w(URLImageView uRLImageView, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, uRLImageView, Integer.valueOf(i3), str);
                return;
            }
            this.f342799b = 0;
            this.f342800c = "";
            this.f342798a = new WeakReference<>(uRLImageView);
            this.f342799b = i3;
            this.f342800c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class x extends Handler {
        static IPatchRedirector $redirector_;

        x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 0) {
                try {
                    QidianProfileCardActivity.this.f342699b0.setBackgroundDrawable(new BitmapDrawable(QidianProfileCardActivity.this.getResources(), QidianProfileCardActivity.this.f342711n0));
                } catch (Exception unused) {
                }
            }
            super.handleMessage(message);
        }
    }

    public QidianProfileCardActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342710m0 = new ProfileCardInfo();
        this.f342722y0 = 0;
        this.f342723z0 = 4;
        this.A0 = null;
        this.G0 = false;
        this.H0 = false;
        this.I0 = new a();
        this.J0 = new b();
        this.K0 = new c();
        this.L0 = new d();
        this.M0 = new e();
        this.N0 = new f();
        this.O0 = new i();
        this.P0 = new j();
        this.Q0 = new k();
        this.R0 = new l();
        this.U0 = "";
        this.V0 = "";
        this.W0 = new com.tencent.mobileqq.hitrate.b("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.getQZonePluginName());
    }

    private void B4(int i3) {
        this.f342702e0.removeAllViews();
        if (i3 != 1 && i3 != 6) {
            if (i3 == 0 || i3 == 2) {
                n3();
                return;
            }
            return;
        }
        QidianProfileUiInfo qidianProfileUiInfo = this.f342715r0;
        if (qidianProfileUiInfo != null) {
            Iterator<QidianProfileUiInfo.b> it = qidianProfileUiInfo.getConfigGroupInfos().iterator();
            while (it.hasNext()) {
                t3(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3(final TroopMemberCard troopMemberCard) {
        ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
        AllInOne allInOne = this.f342710m0.allInOne;
        iTroopMemberListRepoApi.fetchTroopMemberInfo(allInOne.troopCode, allInOne.uin, false, null, "QidianProfileCardActivity", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.qidian.a
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                QidianProfileCardActivity.b4(TroopMemberCard.this, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H3(URLDrawable uRLDrawable) {
        ThreadManagerV2.executeOnFileThread(new ForwardRunnable(this, uRLDrawable));
    }

    public static Bitmap I3(QQAppInterface qQAppInterface, URLDrawable uRLDrawable, boolean z16) {
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (currDrawable != null) {
            if (currDrawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) currDrawable).getBitmap();
                if (z16) {
                    return QQAppInterface.getCircleFaceBitmap(bitmap, 50, 50);
                }
                return bitmap;
            }
            if (currDrawable instanceof SkinnableBitmapDrawable) {
                Bitmap bitmap2 = ((SkinnableBitmapDrawable) currDrawable).getBitmap();
                if (z16) {
                    return QQAppInterface.getCircleFaceBitmap(bitmap2, 50, 50);
                }
                return bitmap2;
            }
            Bitmap drawabletoBitmap = BaseImageUtil.drawabletoBitmap(currDrawable);
            if (z16) {
                return QQAppInterface.getCircleFaceBitmap(drawabletoBitmap, 50, 50);
            }
            return drawabletoBitmap;
        }
        return null;
    }

    private String J3(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        PhoneContact queryContactByCodeNumber;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null && (queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(ProfileUtils.getMobileNumberWithNationCode(profileCardInfo.allInOne))) != null) {
            return queryContactByCodeNumber.uin;
        }
        return null;
    }

    private String K3() {
        QidianExternalInfo qidianExternalInfo;
        String str;
        if (!TextUtils.isEmpty(this.f342710m0.allInOne.remark)) {
            QLog.i("QidianProfileCardActivity", 1, "[getDisplayName] allInOne.remark:" + this.f342710m0.allInOne.remark);
            return this.f342710m0.allInOne.remark;
        }
        int i3 = this.f342723z0;
        if (i3 == 0) {
            BmqqUserSimpleInfo bmqqUserSimpleInfo = this.B0;
            if (bmqqUserSimpleInfo != null && !TextUtils.isEmpty(bmqqUserSimpleInfo.mBmqqNickName)) {
                QLog.i("QidianProfileCardActivity", 1, "[getDisplayName] mBmqqUserInfo.mBmqqNickName:" + this.B0.mBmqqNickName);
                return this.B0.mBmqqNickName;
            }
        } else if ((i3 == 1 || i3 == 6) && (qidianExternalInfo = this.f342713p0) != null) {
            if (TextUtils.isEmpty(qidianExternalInfo.nickname)) {
                str = this.f342713p0.uin;
            } else {
                str = this.f342713p0.nickname;
            }
            QLog.i("QidianProfileCardActivity", 1, "[getDisplayName] mExternalInfo uin:" + this.f342713p0.uin + ", nick:" + str);
            return str;
        }
        QLog.i("QidianProfileCardActivity", 1, "[getDisplayName] uin:" + this.f342710m0.allInOne.uin);
        return this.f342710m0.allInOne.uin;
    }

    private boolean V3() {
        return PackageUtil.isPackageInstalled(getApplicationContext(), "com.tencent.mm");
    }

    private com.tencent.mobileqq.profile.b W3(int i3, String str, String str2, String str3) {
        switch (i3) {
            case 1:
                return new com.tencent.mobileqq.profile.b(52, str2);
            case 2:
                return new com.tencent.mobileqq.profile.b(4, str2);
            case 3:
                return new com.tencent.mobileqq.profile.b(47, str2);
            case 4:
                return new com.tencent.mobileqq.profile.b(48, new String[]{str, str2});
            case 5:
                return new com.tencent.mobileqq.profile.b(76, str3);
            case 6:
                return new com.tencent.mobileqq.profile.b(75, str2);
            case 7:
                return new com.tencent.mobileqq.profile.b(54, str3);
            case 8:
            default:
                return null;
            case 9:
                return new com.tencent.mobileqq.profile.b(82, str3);
        }
    }

    private boolean X3() {
        AllInOne allInOne;
        ProfileCardInfo profileCardInfo = this.f342710m0;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null) {
            String str = allInOne.troopCode;
            QLog.i("QidianProfileCardActivity", 1, "[jumpFromTroop] troopCode:" + str);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("QidianProfileCardActivity", 1, "[jumpFromTroop] app is null");
                return false;
            }
            TroopInfo k3 = ((TroopManager) peekAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
            if (k3 == null) {
                QLog.e("QidianProfileCardActivity", 1, "[jumpFromTroop] troopInfo is null");
                return false;
            }
            return i4(k3);
        }
        QLog.i("QidianProfileCardActivity", 1, "[jumpFromTroop] cardInfo.allInOne is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b4(TroopMemberCard troopMemberCard, TroopMemberInfo troopMemberInfo) {
        boolean z16;
        if (troopMemberInfo != null) {
            troopMemberCard.titleId = troopMemberInfo.titleId;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[fetchTroopMemberTitleId] titleId:");
            sb5.append(troopMemberCard.titleId);
            sb5.append(", info:");
            if (troopMemberInfo != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("QidianProfileCardActivity", 2, sb5.toString());
        }
    }

    private void clearData() {
        ConcurrentHashMap<String, w> concurrentHashMap = this.f342716s0;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, Drawable> concurrentHashMap2 = this.f342717t0;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        this.f342713p0 = null;
        this.f342714q0 = null;
        this.f342715r0 = null;
        this.f342719v0 = null;
        this.f342720w0 = null;
        this.B0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d4(String str, final Intent intent) {
        IProfileDataService iProfileDataService = (IProfileDataService) this.app.getRuntimeService(IProfileDataService.class, "");
        this.f342710m0.card = iProfileDataService.getProfileCard(str, true);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        final boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "QidianProfileCardActivity");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QidianProfileCardActivity");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qidian.c
            @Override // java.lang.Runnable
            public final void run() {
                QidianProfileCardActivity.this.c4(intent, isFriend, friendsSimpleInfoWithUid);
            }
        });
    }

    private void e4(int i3) {
        boolean z16 = false;
        if (i3 != 6 ? i3 != 1 ? (i3 == 2 || i3 == 0) && this.B0 == null : this.f342713p0 == null || this.f342710m0.card == null : this.f342713p0 == null) {
            z16 = true;
        }
        if (z16) {
            ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.qidian.QidianProfileCardActivity.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f342733d;

                {
                    this.f342733d = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QidianProfileCardActivity.this.l4(this.f342733d);
                    }
                }
            }, 8, null, true);
        }
    }

    private void f4(int i3) {
        if (i3 == 4) {
            showLoading(R.string.d7n);
        }
        if (this.C0.D(this.f342710m0.allInOne.uin, true)) {
            this.C0.N(this.f342710m0.allInOne.uin, false);
        } else if (this.C0.M(this.f342710m0.allInOne.uin, false)) {
            this.C0.z(this, new BmqqAccountType(this.f342710m0.allInOne.uin, 1));
        } else {
            this.C0.T(this.f342710m0.allInOne.uin);
        }
        if (i3 == 6) {
            ((QidianHandler) this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).N2(Long.parseLong(this.f342710m0.allInOne.uin));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g4(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("http")) {
            str = "https://" + str;
        }
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("isShowAd", false);
        intent.putExtra("big_brother_source_key", "biz_src_qycp");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h4(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) QQMapActivity.class);
        intent.putExtra(QCircleSchemeAttr.Polymerize.LAT, str);
        intent.putExtra("lon", str2);
        startActivity(intent);
    }

    private boolean i4(TroopInfo troopInfo) {
        ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).checkAndUpdateTroopInfo(troopInfo, this.f342710m0.allInOne);
        AllInOne allInOne = this.f342710m0.allInOne;
        String str = allInOne.troopCode;
        final String str2 = allInOne.uin;
        final Intent intent = new Intent();
        intent.putExtra("troopUin", str);
        intent.putExtra("memberUin", str2);
        ProfileCardInfo profileCardInfo = this.f342710m0;
        if (profileCardInfo.troopMemberCard == null) {
            profileCardInfo.troopMemberCard = new TroopMemberCard();
        }
        try {
            this.f342710m0.troopMemberCard.memberUin = Long.parseLong(str2);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
        ProfileCardInfo profileCardInfo2 = this.f342710m0;
        TroopMemberCard troopMemberCard = profileCardInfo2.troopMemberCard;
        troopMemberCard.memberUid = profileCardInfo2.allInOne.uid;
        intent.putExtra("troopMemberCard", troopMemberCard);
        intent.putExtra(IProfileProtocolConst.PARAM_TROOP_CODE, troopInfo.troopcode);
        intent.putExtra("troopName", troopInfo.getTroopDisplayName());
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface == null) {
            QLog.e("QidianProfileCardActivity", 1, "[openTroopMoreInner] mApp is null");
            return false;
        }
        intent.putExtra("hwCard", ((IBizTroopMemberInfoService) qQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getHWTroopMemberCard(str, str2));
        intent.putExtra("qidian_private_troop", ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).isQiDianPrivateTroop(str));
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, this.f342710m0.allInOne);
        intent.putExtra("detailProfileUrl", ProfileCardUtil.t(this.app, this, this.f342710m0));
        intent.putExtra("qidianshowUin", QidianManager.w(this.app, str2));
        intent.putExtra("hasGatherFriend", ac.n0(this.app));
        if (TextUtils.isEmpty(this.f342710m0.allInOne.nickname)) {
            this.f342710m0.allInOne.nickname = ac.f(this.app, str2);
        }
        intent.putExtra("isQidianMaster", ((QidianManager) this.app.getManager(QQManagerFactory.QIDIAN_MANAGER)).R(str2));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qidian.b
            @Override // java.lang.Runnable
            public final void run() {
                QidianProfileCardActivity.this.d4(str2, intent);
            }
        }, 32, null, false);
        return true;
    }

    private void initUI() {
        Resources resources = getResources();
        this.f342721x0 = resources.getDimensionPixelSize(R.dimen.title_bar_height) - ((int) (resources.getDisplayMetrics().density * 66.0f));
        this.f342698a0 = (LinearLayout) findViewById(R.id.al_);
        this.f342704g0 = (RelativeLayout) findViewById(R.id.d3z);
        ImageView imageView = (ImageView) findViewById(R.id.d39);
        this.f342699b0 = imageView;
        imageView.setOnClickListener(new r());
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            this.f342699b0.setImageDrawable(getResources().getDrawable(R.drawable.eag));
        }
        this.f342700c0 = (ImageView) findViewById(R.id.knh);
        this.f342701d0 = (LinearLayout) findViewById(R.id.b8q);
        this.f342702e0 = (LinearLayout) findViewById(R.id.dro);
        BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.common_xlistview);
        this.f342703f0 = bounceScrollView;
        bounceScrollView.mScrollFlag = 1;
        bounceScrollView.setVerticalScrollBarEnabled(false);
        this.f342703f0.setOnScrollChangedListener(new s());
        this.f342705h0 = (TextView) findViewById(R.id.f5e);
        this.f342706i0 = (TextView) findViewById(R.id.dza);
        this.f342707j0 = (TextView) findViewById(R.id.ivs);
        findViewById(R.id.iwa).setOnClickListener(new t());
        ImageView imageView2 = (ImageView) findViewById(R.id.e8_);
        this.f342708k0 = imageView2;
        imageView2.setOnClickListener(new u());
        ImageView imageView3 = (ImageView) findViewById(R.id.ias);
        this.f342709l0 = imageView3;
        imageView3.setTag(new com.tencent.mobileqq.profile.b(53, null));
        this.f342709l0.setOnClickListener(this.N0);
        T3();
    }

    private boolean isForbidByAnyType(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo == null) {
            return false;
        }
        return profileCardInfo.isForbidByAnyType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k4, reason: merged with bridge method [inline-methods] */
    public void c4(Intent intent, boolean z16, com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        String str;
        int i3;
        Map<String, String> buddyRemark;
        String str2 = this.f342710m0.allInOne.uin;
        intent.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, z16);
        if (!z16) {
            ArrayList<String> arrayList = new ArrayList<>();
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
            if (!TextUtils.isEmpty(uidFromUin)) {
                arrayList.add(uidFromUin);
            } else {
                QLog.e("QidianProfileCardActivity", 1, "openTroopMoreInnerFinal, uid is empty, " + str2);
            }
            com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
            if (b16 != null && !arrayList.isEmpty() && (buddyRemark = b16.getBuddyRemark(arrayList)) != null && buddyRemark.containsKey(uidFromUin)) {
                intent.putExtra("key_remark", buddyRemark.get(uidFromUin));
            }
        }
        if (dVar != null) {
            intent.putExtra("specialFlag", (int) dVar.e().byteValue());
            if (dVar.B()) {
                intent.putExtra("key_remark", dVar.r());
                intent.putExtra(MiniAppTranRoomIdServlet.KEY_GROUP_ID, dVar.f());
                QQAppInterface qQAppInterface = this.app;
                intent.putExtra("key_current_nick", ac.y(qQAppInterface, qQAppInterface.getCurrentAccountUin()));
                intent.putExtra("key_group_name", ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).getGroupName(dVar.f()));
                intent.putExtra("key_not_disturb", FriendsStatusUtil.k(str2, this.app));
                intent.putExtra("key_is_shield", ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isShieldFriend(dVar.getUid(), "QidianProfileCardActivity"));
                intent.putExtra("key_type_gather", dVar.n());
                intent.putExtra("key_is_has_interaction", com.tencent.mobileqq.mutualmark.c.l(this.app, str2, true));
                intent.putExtra("key_is_specialcare", ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2), "QidianProfileCardActivity"));
            }
        }
        intent.putExtra("businessCard", BusinessCardUtils.a(this.app, this.f342710m0));
        com.tencent.mobileqq.unifiedname.b bVar = this.f342710m0.profileName;
        boolean z17 = false;
        if (bVar != null && bVar.f305806b.size() > 0) {
            intent.putExtra("SHARE_NICK_NAME", this.f342710m0.profileName.f305806b.get(0).f305804b);
        }
        Card card = this.f342710m0.card;
        if (card != null && !TextUtils.isEmpty(card.addSrcName)) {
            intent.putExtra("cur_add_source", this.f342710m0.card.addSrcName);
        }
        Card card2 = this.f342710m0.card;
        if (card2 != null) {
            intent.putExtra("key_nick_name", card2.strNick);
        }
        if (z16) {
            intent.putExtra("friend_intimate_open", FriendIntimateRelationshipHelper.m(this.app.getCurrentUin()));
            intent.putExtra("friend_intimate_bind_url", FriendIntimateRelationshipHelper.b(this.f342710m0.allInOne.uin));
            com.tencent.mobileqq.mutualmark.info.c e16 = com.tencent.mobileqq.mutualmark.c.e(this.app, this.f342710m0.allInOne.uin, true);
            if (e16 != null) {
                str = com.tencent.mobileqq.activity.aio.intimate.e.b(this, e16.f252085a);
                int i16 = e16.f252101q;
                z17 = e16.d();
                i3 = i16;
            } else {
                str = "";
                i3 = 0;
            }
            intent.putExtra("friend_intimate_bind_name", str);
            intent.putExtra("friend_intimate_isExtinguish", z17);
            intent.putExtra("friend_intimate_bind_res_icon", i3);
        }
        intent.putExtra("isMsgShielded", U3(this.f342710m0));
        intent.putExtra("isGather", ((ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class)).isGatherFriend(this.f342710m0));
        intent.putExtra("isForbidAccount", isForbidByAnyType(this.f342710m0));
        String uidFromUin2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f342710m0.allInOne.uin);
        QLog.i("QidianProfileCardActivity", 1, "[openTroopMoreInnerFinal] getFriendsDetailInfoWithUid");
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(uidFromUin2, "QidianProfileCardActivity", new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c>(intent) { // from class: com.tencent.qidian.QidianProfileCardActivity.30
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Intent f342729a;

            {
                this.f342729a = intent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this, (Object) intent);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
                ProfileCardInfo profileCardInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                boolean z18 = true;
                QLog.i("QidianProfileCardActivity", 1, "[openTroopMoreInnerFinal] getFriendsDetailInfoWithUid onQueryResult");
                if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty() && (profileCardInfo = QidianProfileCardActivity.this.f342710m0) != null && profileCardInfo.allInOne.f260789pa != 1) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = eVar.b().get(0);
                    Intent intent2 = this.f342729a;
                    if (cVar.n().byteValue() != 1) {
                        z18 = false;
                    }
                    intent2.putExtra("isGather", z18);
                } else {
                    this.f342729a.putExtra("isGather", false);
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qidian.QidianProfileCardActivity.30.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass30.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                        if (qidianProfileCardActivity != null && !qidianProfileCardActivity.isFinishing()) {
                            AnonymousClass30.this.f342729a.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
                            ITroopMemberSettingApi iTroopMemberSettingApi = (ITroopMemberSettingApi) QRoute.api(ITroopMemberSettingApi.class);
                            AnonymousClass30 anonymousClass30 = AnonymousClass30.this;
                            iTroopMemberSettingApi.openMemberSetting(QidianProfileCardActivity.this, anonymousClass30.f342729a, 8);
                            return;
                        }
                        QLog.i("QidianProfileCardActivity", 1, "openTroopMoreInnerFinal end. activity destroyed");
                    }
                });
            }
        });
    }

    private void n3() {
        if (this.B0 != null) {
            QidianProfileUiInfo.b bVar = new QidianProfileUiInfo.b();
            bVar.f342858a = new ArrayList(5);
            new QidianProfileUiInfo.c();
            QidianProfileUiInfo.c cVar = new QidianProfileUiInfo.c();
            cVar.f342859a = 1;
            cVar.f342860b = 0;
            cVar.f342861c = HardCodeUtil.qqStr(R.string.f172382qc0);
            cVar.f342862d = this.f342710m0.allInOne.uin;
            bVar.f342858a.add(cVar);
            QidianProfileUiInfo.c cVar2 = new QidianProfileUiInfo.c();
            cVar2.f342859a = 1;
            cVar2.f342860b = 2;
            cVar2.f342861c = getResources().getString(R.string.exr);
            String str = this.B0.mBmqqMobileNum;
            cVar2.f342862d = str;
            cVar2.f342863e = str;
            bVar.f342858a.add(cVar2);
            QidianProfileUiInfo.c cVar3 = new QidianProfileUiInfo.c();
            cVar3.f342859a = 1;
            cVar3.f342860b = 1;
            cVar3.f342861c = getResources().getString(R.string.hvm);
            String str2 = this.B0.mBmqqTelphone;
            cVar3.f342862d = str2;
            cVar3.f342863e = str2;
            bVar.f342858a.add(cVar3);
            QidianProfileUiInfo.c cVar4 = new QidianProfileUiInfo.c();
            cVar4.f342859a = 1;
            cVar4.f342860b = 3;
            cVar4.f342861c = getResources().getString(R.string.f171100c72);
            String str3 = this.B0.mBmqqEmail;
            cVar4.f342862d = str3;
            cVar4.f342863e = str3;
            bVar.f342858a.add(cVar4);
            QidianProfileUiInfo.c cVar5 = new QidianProfileUiInfo.c();
            cVar5.f342859a = 1;
            cVar5.f342861c = getResources().getString(R.string.f171191d11);
            cVar5.f342862d = this.B0.mBmqqCompany;
            if (nx.a.e(getApplicationContext(), this.B0.mBmqqUin) && !TextUtils.isEmpty(this.B0.mBmqqMasterUin) && nx.a.f(this.B0.mBmqqMasterUin)) {
                cVar5.f342860b = 7;
                cVar5.f342864f = "mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.B0.mBmqqMasterUin;
                cVar5.f342865g = this.B0.isCertified();
            } else {
                cVar5.f342860b = 0;
                cVar5.f342865g = this.B0.isCertified();
            }
            bVar.f342858a.add(cVar5);
            t3(bVar);
        }
    }

    private View p3(int i3, int i16, View.OnClickListener onClickListener) {
        return r3(i3, i16, onClickListener, -1);
    }

    private void p4() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.qidian.QidianProfileCardActivity.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                    qidianProfileCardActivity.f342711n0 = qidianProfileCardActivity.app.getFaceBitmap(qidianProfileCardActivity.f342710m0.allInOne.uin, (byte) 2, true);
                } else {
                    QidianProfileCardActivity qidianProfileCardActivity2 = QidianProfileCardActivity.this;
                    qidianProfileCardActivity2.f342711n0 = qidianProfileCardActivity2.app.getFaceBitmap(qidianProfileCardActivity2.f342710m0.allInOne.uin, true);
                }
                QidianProfileCardActivity.this.n4();
            }
        });
    }

    private View r3(int i3, int i16, View.OnClickListener onClickListener, int i17) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        View inflate = View.inflate(this, i16, null);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.abw);
        inflate.setVisibility(0);
        Button button = (Button) inflate.findViewById(R.id.txt);
        button.setText(i3);
        button.setOnClickListener(onClickListener);
        layoutParams.weight = 1.0f;
        layoutParams.rightMargin = dimensionPixelSize;
        if (i17 >= 0) {
            this.f342698a0.addView(inflate, i17, layoutParams);
        } else {
            this.f342698a0.addView(inflate, layoutParams);
        }
        return button;
    }

    private ArrayList<View> s3() {
        ArrayList<View> arrayList = new ArrayList<>();
        QidianExternalInfo qidianExternalInfo = this.f342713p0;
        if (qidianExternalInfo != null && qidianExternalInfo.getCompanyShowCaseInfos() != null && this.f342713p0.getCompanyShowCaseInfos().size() > 0) {
            LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.an8, (ViewGroup) null);
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.b8q);
            PhotoWallViewForQiDianProfile photoWallViewForQiDianProfile = new PhotoWallViewForQiDianProfile(getApplicationContext());
            photoWallViewForQiDianProfile.setPhotoWallCallback(this.I0);
            photoWallViewForQiDianProfile.a(getApplicationContext(), this.f342713p0.getCompanyShowCaseInfos());
            photoWallViewForQiDianProfile.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.addView(photoWallViewForQiDianProfile);
            arrayList.add(linearLayout);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePhoto(URLDrawable uRLDrawable, String str) {
        ThreadManagerV2.executeOnFileThread(new SavePhotoRunnable(this, uRLDrawable, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePic(URLDrawable uRLDrawable) {
        if (uRLDrawable.getStatus() != 1) {
            return;
        }
        String str = AppConstants.SDCARD_IMG_SAVE;
        new File(str).mkdirs();
        String str2 = str + Utils.Crc64String(this.f342710m0.allInOne.uin) + Utils.Crc64String(uRLDrawable.getURL().toString());
        File file = new File(str2);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    savePhoto(uRLDrawable, file.getPath());
                    return;
                }
                return;
            } catch (IOException unused) {
                QQToast.makeText(this, getString(R.string.cwi), 0).show();
                return;
            }
        }
        DialogUtil.createCustomDialog(this, 230).setTitle(getString(R.string.h4e)).setMessage(getString(R.string.cwb)).setPositiveButton(getString(R.string.h1a), new q(uRLDrawable, str2)).setNegativeButton(getString(R.string.f171142no), new p()).show();
    }

    private void setNewRemark(String str) {
        ProfileCardInfo profileCardInfo = this.f342710m0;
        profileCardInfo.allInOne.remark = str;
        ProfileNameUtils.updateNameArray(profileCardInfo, 4, str);
        ProfileNameUtils.updateProfileName(this.f342710m0);
        this.f342705h0.setText(K3());
    }

    private void t3(QidianProfileUiInfo.b bVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList<View> s36 = s3();
        List<QidianProfileUiInfo.c> list = bVar.f342858a;
        if (list != null) {
            int size = list.size();
            ArrayList<View> arrayList2 = null;
            ArrayList<View> arrayList3 = null;
            for (int i3 = 0; i3 < size; i3++) {
                QidianProfileUiInfo.c cVar = list.get(i3);
                if (cVar != null) {
                    int i16 = cVar.f342859a;
                    boolean z16 = true;
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 != 6) {
                                }
                            } else {
                                arrayList2 = v3();
                            }
                        } else {
                            arrayList3 = w3();
                        }
                    }
                    if (i3 != size - 1) {
                        z16 = false;
                    }
                    arrayList.add(x3(cVar, z16));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                if (view != null) {
                    this.f342702e0.addView(view);
                }
            }
            Iterator<View> it5 = s36.iterator();
            while (it5.hasNext()) {
                View next = it5.next();
                if (next != null) {
                    this.f342702e0.addView(next);
                }
            }
            LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.an9, (ViewGroup) null);
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.b8q);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(ViewUtils.dip2px(15.0f), 0, 0, 0);
            if (arrayList2 != null) {
                Iterator<View> it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    View next2 = it6.next();
                    if (linearLayout2.getChildCount() > 6) {
                        break;
                    } else if (next2 != null) {
                        linearLayout2.addView(next2, layoutParams);
                    }
                }
            }
            if (arrayList3 != null) {
                Iterator<View> it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    View next3 = it7.next();
                    if (linearLayout2.getChildCount() > 6) {
                        break;
                    } else if (next3 != null) {
                        linearLayout2.addView(next3, layoutParams);
                    }
                }
            }
            if (linearLayout2.getChildCount() > 0) {
                this.f342702e0.addView(linearLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u4(URLDrawable uRLDrawable, String str) {
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this);
        createMenuSheet.addButton(R.string.bsj);
        createMenuSheet.addButton(R.string.bst);
        createMenuSheet.addButton(R.string.f0p);
        createMenuSheet.addCancelButton(R.string.cancel);
        createMenuSheet.setOnButtonClickListener(new o(createMenuSheet, uRLDrawable, str));
        createMenuSheet.show();
    }

    private ArrayList<View> v3() {
        ArrayList<View> arrayList = new ArrayList<>(6);
        if (this.f342713p0 != null && L3() != null && L3().size() > 0) {
            for (com.tencent.qidian.data.b bVar : L3()) {
                RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.an_, (ViewGroup) null);
                URLImageView uRLImageView = (URLImageView) relativeLayout.findViewById(R.id.icon);
                TextView textView = (TextView) relativeLayout.findViewById(R.id.f5e);
                ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.asu);
                TextView textView2 = (TextView) relativeLayout.findViewById(R.id.bg6);
                uRLImageView.post(new Runnable(bVar, uRLImageView) { // from class: com.tencent.qidian.QidianProfileCardActivity.11
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.qidian.data.b f342726d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ URLImageView f342727e;

                    {
                        this.f342726d = bVar;
                        this.f342727e = uRLImageView;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QidianProfileCardActivity.this, bVar, uRLImageView);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        String valueOf = String.valueOf(this.f342726d.f342874a);
                        QidianProfileCardActivity.this.f342716s0.put(valueOf, new w(this.f342727e, 3, valueOf));
                        QidianProfileCardActivity.this.o4(3, this.f342727e, valueOf, false);
                    }
                });
                textView.setText(String.valueOf(bVar.f342876c));
                relativeLayout.setOnClickListener(this.N0);
                textView2.setText(HardCodeUtil.qqStr(R.string.qbs));
                relativeLayout.setTag(new com.tencent.mobileqq.profile.b(51, String.valueOf(bVar.f342874a)));
                imageView.setVisibility(8);
                arrayList.add(relativeLayout);
            }
        }
        return arrayList;
    }

    private ArrayList<View> w3() {
        ArrayList<View> arrayList = new ArrayList<>(6);
        if (this.f342713p0 != null && M3() != null && M3().size() > 0) {
            for (com.tencent.qidian.data.c cVar : M3()) {
                RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.an_, (ViewGroup) null);
                URLImageView uRLImageView = (URLImageView) relativeLayout.findViewById(R.id.icon);
                TextView textView = (TextView) relativeLayout.findViewById(R.id.f5e);
                ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.asu);
                TextView textView2 = (TextView) relativeLayout.findViewById(R.id.bg6);
                uRLImageView.post(new Runnable(cVar, uRLImageView) { // from class: com.tencent.qidian.QidianProfileCardActivity.10
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ com.tencent.qidian.data.c f342724d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ URLImageView f342725e;

                    {
                        this.f342724d = cVar;
                        this.f342725e = uRLImageView;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QidianProfileCardActivity.this, cVar, uRLImageView);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        com.tencent.qidian.data.c cVar2 = this.f342724d;
                        int i3 = cVar2.f342879c;
                        boolean z16 = true;
                        if (i3 != 1 && i3 != 2) {
                            z16 = false;
                        }
                        if (z16) {
                            str = cVar2.f342882f;
                        } else {
                            str = cVar2.f342877a;
                        }
                        QidianProfileCardActivity.this.f342716s0.put(cVar2.f342877a, new w(this.f342725e, i3, str));
                        QidianProfileCardActivity.this.o4(this.f342724d.f342879c, this.f342725e, str, false);
                    }
                });
                textView.setText(cVar.f342878b);
                relativeLayout.setOnClickListener(this.N0);
                int i3 = cVar.f342879c;
                if (i3 == 0) {
                    textView2.setText(R.string.f0v);
                    relativeLayout.setTag(new com.tencent.mobileqq.profile.b(49, cVar.f342877a));
                } else if (i3 == 1) {
                    textView2.setText(R.string.f0w);
                    relativeLayout.setTag(new com.tencent.mobileqq.profile.b(50, cVar));
                } else if (i3 == 2) {
                    textView2.setText(R.string.f196624ht);
                    relativeLayout.setTag(new com.tencent.mobileqq.profile.b(106, cVar));
                }
                int i16 = cVar.f342879c;
                if (i16 == 0 && cVar.f342880d == 1) {
                    imageView.setVisibility(0);
                    imageView.setBackgroundResource(R.drawable.dlr);
                } else if (i16 == 1 && cVar.f342880d == 1) {
                    imageView.setVisibility(0);
                    imageView.setBackgroundResource(R.drawable.eb5);
                } else {
                    imageView.setVisibility(8);
                }
                arrayList.add(relativeLayout);
            }
        }
        return arrayList;
    }

    private View x3(QidianProfileUiInfo.c cVar, boolean z16) {
        String str;
        boolean z17;
        String str2 = cVar.f342862d;
        if (str2 != null) {
            if (!TextUtils.isEmpty(str2.trim()) || cVar.f342870l == 11 || cVar.f342861c.equals(HardCodeUtil.qqStr(R.string.qbt))) {
                QidianSimpleProfileItem qidianSimpleProfileItem = new QidianSimpleProfileItem();
                qidianSimpleProfileItem.f342744d = cVar.f342861c;
                qidianSimpleProfileItem.f342745e = cVar.f342862d;
                qidianSimpleProfileItem.f342747h = cVar.f342859a;
                qidianSimpleProfileItem.f342748i = cVar.f342860b;
                if (!TextUtils.isEmpty(cVar.f342864f)) {
                    str = cVar.f342864f;
                } else {
                    str = cVar.f342863e;
                }
                qidianSimpleProfileItem.f342749m = str;
                if (qidianSimpleProfileItem.f342748i != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                qidianSimpleProfileItem.f342746f = z17;
                qidianSimpleProfileItem.C = z16;
                qidianSimpleProfileItem.D = cVar.f342865g;
                qidianSimpleProfileItem.E = cVar.f342870l;
                return P3(qidianSimpleProfileItem);
            }
            return null;
        }
        return null;
    }

    private void x4() {
        this.f342710m0.isTroopMemberCard = !TextUtils.isEmpty(r0.allInOne.troopCode);
        ProfileCardInfo profileCardInfo = this.f342710m0;
        if (profileCardInfo.isTroopMemberCard) {
            profileCardInfo.troopUin = profileCardInfo.allInOne.troopCode;
            profileCardInfo.troopMemberCard = new TroopMemberCard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y3(String str) {
        ClipboardMonitor.setText((android.content.ClipboardManager) getSystemService("clipboard"), str);
        if (V3()) {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(componentName);
            startActivity(intent);
            return;
        }
        g4("https://weixin.qq.com/d");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y4(String str) {
        if (!TextUtils.isEmpty(str) && this.D0 != null) {
            ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.qidian.QidianProfileCardActivity.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f342728d;

                {
                    this.f342728d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Friends v3 = QidianProfileCardActivity.this.D0.v(this.f342728d);
                    if (v3 != null && (str2 = v3.remark) != null) {
                        if (str2.equals(v3.name)) {
                            QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                            CardHandler cardHandler = qidianProfileCardActivity.E0;
                            String currentAccountUin = qidianProfileCardActivity.app.getCurrentAccountUin();
                            AllInOne allInOne = QidianProfileCardActivity.this.f342710m0.allInOne;
                            cardHandler.m3(currentAccountUin, allInOne.uin, 1, 0L, (byte) 1, 0L, 0L, new byte[]{0}, "", ProfileUtils.getControl(allInOne, false), 10004, new byte[]{0}, (byte) 0);
                        }
                    } else {
                        str2 = "";
                    }
                    QidianProfileCardActivity.this.f342710m0.allInOne.remark = str2;
                }
            }, 8, null, true);
        }
    }

    private void z4(int i3) {
        String K3;
        String str;
        String str2;
        ImageView imageView;
        boolean z16 = true;
        QLog.i("QidianProfileCardActivity", 1, "[updateHead] type:" + i3);
        String str3 = "";
        if (i3 != 1 && i3 != 6) {
            if (i3 != 0 && i3 != 2) {
                str2 = "";
                str = str2;
            } else {
                K3 = K3();
                BmqqUserSimpleInfo bmqqUserSimpleInfo = this.B0;
                if (bmqqUserSimpleInfo != null && !TextUtils.isEmpty(bmqqUserSimpleInfo.mBmqqJobTitle)) {
                    str = this.B0.mBmqqJobTitle;
                    String str4 = str3;
                    str3 = K3;
                    str2 = str4;
                }
                str = "";
                str3 = K3;
                str2 = str;
            }
        } else {
            K3 = K3();
            QidianExternalInfo qidianExternalInfo = this.f342713p0;
            if (qidianExternalInfo != null) {
                if (TextUtils.isEmpty(qidianExternalInfo.job)) {
                    str = "";
                } else {
                    QidianExternalInfo qidianExternalInfo2 = this.f342713p0;
                    str = qidianExternalInfo2.job;
                    int i16 = qidianExternalInfo2.verity;
                }
                if (!TextUtils.isEmpty(this.f342713p0.sign)) {
                    str3 = this.f342713p0.sign;
                }
                String str42 = str3;
                str3 = K3;
                str2 = str42;
            }
            str = "";
            str3 = K3;
            str2 = str;
        }
        this.f342705h0.setText(str3);
        this.f342706i0.setText(str);
        this.f342707j0.setText(str2);
        QidianExternalInfo qidianExternalInfo3 = this.f342713p0;
        if (qidianExternalInfo3 == null) {
            return;
        }
        if (qidianExternalInfo3.verity != 2) {
            z16 = false;
        }
        if (z16 && (imageView = this.f342700c0) != null) {
            imageView.setVisibility(4);
        }
    }

    public void A3(int i3) {
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
            return;
        }
        if (i3 == 1) {
            Intent intent = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent.addFlags(67108864);
            String str2 = this.f342710m0.allInOne.uin;
            if (this.D0.c0(str2)) {
                str = ac.G(this.app, str2);
                intent.putExtra(AppConstants.Key.QIDIAN_IS_FRIEND, true);
                i16 = 0;
            } else {
                str = null;
                i16 = 1025;
            }
            intent.putExtra("uin", str2);
            intent.putExtra("uintype", i16);
            if (str != null) {
                intent.putExtra("uinname", str);
            }
            startActivity(intent);
            return;
        }
        if (i3 == 6) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) ChatActivity.class);
            intent2.addFlags(67108864);
            String str3 = this.f342710m0.allInOne.uin;
            intent2.putExtra("uin", str3);
            if (this.D0.c0(str3)) {
                intent2.putExtra("uinname", ac.G(this.app, str3));
                intent2.putExtra(AppConstants.Key.QIDIAN_IS_FRIEND, true);
            }
            intent2.putExtra("uintype", 1024);
            ((QidianHandler) this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).w3(str3, intent2);
            return;
        }
        ProfileBottomContainer.enterChat(this.app, this, this.f342710m0);
    }

    public void B3() {
        AllInOne allInOne;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        QidianExternalInfo qidianExternalInfo = this.f342713p0;
        if (qidianExternalInfo != null && !TextUtils.isEmpty(qidianExternalInfo.masterUin) && (allInOne = this.f342710m0.allInOne) != null && !TextUtils.isEmpty(allInOne.uin)) {
            CrmUtils.i(this.app, this, this.f342713p0.masterUin, this.f342710m0.allInOne.uin);
        } else {
            notifyUser(R.string.bui, 1);
        }
    }

    public void C3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            return;
        }
        super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + str)));
    }

    public void C4(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        z4(i3);
        B4(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QidianProfileCardActivity", 2, "Show finish");
        }
    }

    public void D3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (this.f342710m0 == null || X3()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ProfileCardMoreActivity.class);
        if (TextUtils.isEmpty(this.U0)) {
            Friends v3 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).v(this.f342710m0.allInOne.uin);
            if (v3 != null && !TextUtils.isEmpty(v3.name)) {
                this.U0 = v3.name;
            } else {
                QidianExternalInfo qidianExternalInfo = this.f342713p0;
                if (qidianExternalInfo != null) {
                    this.U0 = qidianExternalInfo.nickname;
                }
            }
        }
        intent.putExtra("key_nick_name", this.U0);
        if (this.f342723z0 == 6) {
            intent.putExtra("key_qidian_detail_url", this.V0);
        }
        BusinessCard a16 = BusinessCardUtils.a(this.app, this.f342710m0);
        AllInOne allInOne = this.f342710m0.allInOne;
        Intent q06 = ProfileCardUtil.q0(intent, allInOne.uin, this.app, allInOne, a16);
        q06.addFlags(536870912);
        super.startActivityForResult(q06, 1012);
    }

    public void E3(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("QidianProfileCardActivity", 2, "enterNewPage content is null");
            }
        } else {
            Intent intent = new Intent(this, (Class<?>) QidianProfileAllTextActivity.class);
            intent.putExtra("title", str);
            intent.putExtra("content", str2);
            super.startActivity(intent);
        }
    }

    public void F3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
            return;
        }
        if (str != null && str.length() > 0) {
            super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI + str)));
        }
    }

    public List<com.tencent.qidian.data.b> L3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (List) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        if (this.f342723z0 == 6) {
            return this.f342713p0.getGroupItemsCorp();
        }
        return this.f342713p0.getGroupItemsUser();
    }

    public List<com.tencent.qidian.data.c> M3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (List) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        if (this.f342723z0 == 6) {
            return this.f342713p0.getPublicAccountItemsCorp();
        }
        return this.f342713p0.getPublicAccountItemsUser();
    }

    public View P3(QidianSimpleProfileItem qidianSimpleProfileItem) {
        List<QidianProfileUiInfo.b> list;
        QidianProfileUiInfo.b next;
        List<QidianProfileUiInfo.c> list2;
        QidianProfileUiInfo.a aVar;
        QidianProfileUiInfo qidianProfileUiInfo;
        List<QidianProfileUiInfo.b> list3;
        QidianProfileUiInfo.b next2;
        List<QidianProfileUiInfo.c> list4;
        QidianExternalInfo qidianExternalInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this, (Object) qidianSimpleProfileItem);
        }
        int i3 = qidianSimpleProfileItem.E;
        int i16 = R.drawable.eaj;
        int i17 = 11;
        if (i3 != 11 && !qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbp))) {
            if (qidianSimpleProfileItem.E == 1 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbj))) {
                i16 = R.drawable.eap;
            } else if (qidianSimpleProfileItem.E == 2 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbl))) {
                i16 = R.drawable.ean;
            } else if (qidianSimpleProfileItem.E == 3 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbn))) {
                i16 = R.drawable.eal;
            } else if (qidianSimpleProfileItem.E == 4 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbv))) {
                i16 = R.drawable.qq_profilecard_item_account;
            } else if (qidianSimpleProfileItem.E == 5 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbk))) {
                i16 = R.drawable.eai;
            } else if (qidianSimpleProfileItem.E == 6 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbr))) {
                i16 = R.drawable.eam;
            } else if (qidianSimpleProfileItem.E != 7 && !qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qby))) {
                if (qidianSimpleProfileItem.E == 8 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbo))) {
                    i16 = R.drawable.eao;
                } else {
                    if (qidianSimpleProfileItem.E == 9 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbx))) {
                        return null;
                    }
                    i16 = (qidianSimpleProfileItem.E == 10 || qidianSimpleProfileItem.f342744d.equals("QQ\u7a7a\u95f4")) ? R.drawable.eaq : R.drawable.eak;
                }
            }
            RelativeLayout relativeLayout = (RelativeLayout) super.getLayoutInflater().inflate(R.layout.ana, (ViewGroup) this.f342702e0, false);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.e7j);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.f166255ew1);
            ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.f166795ia4);
            ImageView imageView3 = (ImageView) relativeLayout.findViewById(R.id.evz);
            textView.setText(qidianSimpleProfileItem.f342745e);
            if (!qidianSimpleProfileItem.f342746f) {
                imageView2.setVisibility(4);
                relativeLayout.setLongClickable(true);
                relativeLayout.setTag(qidianSimpleProfileItem.f342745e);
                relativeLayout.setOnLongClickListener(this.M0);
            } else {
                relativeLayout.setTag(W3(qidianSimpleProfileItem.f342748i, qidianSimpleProfileItem.f342744d, qidianSimpleProfileItem.f342745e, qidianSimpleProfileItem.f342749m));
                relativeLayout.setClickable(true);
                relativeLayout.setOnClickListener(this.N0);
                imageView2.setVisibility(0);
            }
            if (qidianSimpleProfileItem.D) {
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            imageView.setImageResource(i16);
            if ((qidianSimpleProfileItem.E == 5 || qidianSimpleProfileItem.f342744d.equals(HardCodeUtil.qqStr(R.string.qbu))) && (qidianProfileUiInfo = this.f342715r0) != null && (list3 = qidianProfileUiInfo.mConfigGroupInfos) != null) {
                Iterator<QidianProfileUiInfo.b> it = list3.iterator();
                while (it.hasNext() && (next2 = it.next()) != null && (list4 = next2.f342858a) != null) {
                    for (QidianProfileUiInfo.c cVar : list4) {
                        if (cVar != null && (cVar.f342870l == 5 || cVar.f342861c.equals(HardCodeUtil.qqStr(R.string.qbq)))) {
                            relativeLayout.setTag(W3(qidianSimpleProfileItem.f342748i, qidianSimpleProfileItem.f342744d, qidianSimpleProfileItem.f342745e, cVar.f342868j + "|" + cVar.f342869k));
                        }
                    }
                }
            }
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.uyr);
            textView2.setVisibility(8);
            if (qidianSimpleProfileItem.f342748i == 2 && (qidianExternalInfo = this.f342713p0) != null && !TextUtils.isEmpty(qidianExternalInfo.mobile)) {
                textView2.setVisibility(0);
                if (this.f342713p0.isExternalMobileVerified()) {
                    textView2.setText(R.string.f213765r3);
                    textView2.setTextColor(Color.parseColor("#7CE7C2"));
                    textView2.setBackgroundResource(R.drawable.kfz);
                } else {
                    textView2.setText(R.string.f213755r2);
                    textView2.setTextColor(Color.parseColor("#FFCD9C"));
                    textView2.setBackgroundResource(R.drawable.kfy);
                }
            }
            return relativeLayout;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) getLayoutInflater().inflate(R.layout.an7, (ViewGroup) this.f342702e0, false);
        ImageView imageView4 = (ImageView) relativeLayout2.findViewById(R.id.e7j);
        TextView textView3 = (TextView) relativeLayout2.findViewById(R.id.f166255ew1);
        TextView textView4 = (TextView) relativeLayout2.findViewById(R.id.adg);
        ImageView imageView5 = (ImageView) relativeLayout2.findViewById(R.id.f166795ia4);
        ImageView imageView6 = (ImageView) relativeLayout2.findViewById(R.id.evz);
        imageView4.setImageResource(R.drawable.eaj);
        QidianProfileUiInfo qidianProfileUiInfo2 = this.f342715r0;
        if (qidianProfileUiInfo2 != null && (list = qidianProfileUiInfo2.mConfigGroupInfos) != null) {
            Iterator<QidianProfileUiInfo.b> it5 = list.iterator();
            while (it5.hasNext() && (next = it5.next()) != null && (list2 = next.f342858a) != null) {
                for (QidianProfileUiInfo.c cVar2 : list2) {
                    if (cVar2 != null && ((cVar2.f342870l == i17 || cVar2.f342861c.equals(HardCodeUtil.qqStr(R.string.qbm))) && (aVar = cVar2.f342866h) != null)) {
                        textView3.setText(aVar.f342854a);
                        textView4.setText(cVar2.f342866h.f342856c);
                        relativeLayout2.setTag(W3(qidianSimpleProfileItem.f342748i, qidianSimpleProfileItem.f342744d, cVar2.f342866h.f342857d, qidianSimpleProfileItem.f342749m));
                        this.V0 = cVar2.f342866h.f342857d;
                        QidianExternalInfo qidianExternalInfo2 = this.f342713p0;
                        if (qidianExternalInfo2 != null) {
                            if ((qidianExternalInfo2.verity == 2) && !TextUtils.isEmpty(qidianExternalInfo2.verify_url) && HttpUtil.isValidUrl(this.f342713p0.verify_url)) {
                                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                                obtain.mLoadingDrawable = getResources().getDrawable(R.drawable.eah);
                                obtain.mFailedDrawable = getResources().getDrawable(R.drawable.eah);
                                obtain.mPlayGifImage = false;
                                obtain.mGifRoundCorner = 0.0f;
                                obtain.mRequestWidth = 20;
                                obtain.mRequestHeight = 20;
                                URLDrawable drawable = URLDrawable.getDrawable(this.f342713p0.verify_url, obtain);
                                if (imageView6 != null) {
                                    imageView6.setMaxWidth(20);
                                    imageView6.setMaxHeight(20);
                                    imageView6.setVisibility(0);
                                    imageView6.setImageDrawable(drawable);
                                }
                            }
                        }
                    }
                    i17 = 11;
                }
            }
        }
        if (!qidianSimpleProfileItem.f342746f) {
            imageView5.setVisibility(4);
            relativeLayout2.setLongClickable(true);
            relativeLayout2.setTag(qidianSimpleProfileItem.f342745e);
            relativeLayout2.setOnLongClickListener(this.M0);
        } else {
            relativeLayout2.setClickable(true);
            relativeLayout2.setOnClickListener(this.N0);
            imageView5.setVisibility(0);
        }
        return relativeLayout2;
    }

    public Drawable Q3(URLImageView uRLImageView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Drawable) iPatchRedirector.redirect((short) 17, (Object) this, (Object) uRLImageView, (Object) str);
        }
        URLDrawable uRLDrawable = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QidianProfileCardActivity", 4, "getWeixinPAFaceDrawable load net error, " + e16.getMessage());
            }
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() != 2) {
            if (uRLDrawable.getStatus() == 1) {
                return new BitmapDrawable(I3(this.app, uRLDrawable, !SimpleUIUtil.getSimpleUISwitch()));
            }
            uRLImageView.setURLDrawableDownListener(new v(this, this.app, uRLImageView, str, BaseImageUtil.getDefaultFaceDrawable(), !SimpleUIUtil.getSimpleUISwitch()));
            return uRLDrawable;
        }
        return BaseImageUtil.getDefaultFaceDrawable();
    }

    public Drawable R3(URLImageView uRLImageView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Drawable) iPatchRedirector.redirect((short) 18, (Object) this, (Object) uRLImageView, (Object) str);
        }
        URLDrawable uRLDrawable = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QidianProfileCardActivity", 4, "getWeixinPAQrDrawable load net error, " + e16.getMessage());
            }
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() != 2) {
            if (uRLDrawable.getStatus() == 1) {
                return uRLDrawable;
            }
            uRLImageView.setURLDrawableDownListener(new v(this, this.app, uRLImageView, str, getResources().getDrawable(R.drawable.h7n), false));
            return uRLDrawable;
        }
        return BaseImageUtil.getDefaultFaceDrawable();
    }

    public boolean S3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (QidianManager.K(this.f342722y0)) {
            return true;
        }
        this.f342723z0 = this.C0.n(this.f342710m0.allInOne.uin, this.app);
        if (QLog.isColorLevel()) {
            QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.f342723z0);
        }
        int i3 = this.f342723z0;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            return true;
        }
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 6) {
                    return true;
                }
            } else {
                showLoading(R.string.d7n);
                return true;
            }
        } else {
            CrmUtils.n(this, null, this.f342710m0.allInOne.uin, true, -1, true, -1);
        }
        return false;
    }

    public void T3() {
        boolean isPaTypeCanTalk;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        int i3 = this.f342723z0;
        if (i3 != 1 && i3 != 2 && i3 != 0 && i3 != 6) {
            return;
        }
        this.f342698a0.removeAllViews();
        boolean isPaTypeCanAddAsFriend = ProfilePAUtils.isPaTypeCanAddAsFriend(this.f342710m0.allInOne);
        if (this.f342723z0 == 6) {
            isPaTypeCanTalk = true;
        } else {
            isPaTypeCanTalk = ProfilePAUtils.isPaTypeCanTalk(this.f342710m0.allInOne);
        }
        boolean isPaTypeCanFreeCall = ProfilePAUtils.isPaTypeCanFreeCall(this.f342710m0.allInOne);
        int i16 = this.f342723z0;
        int i17 = R.layout.anc;
        if (i16 == 1 && this.C0.X(this.f342710m0.allInOne.uin)) {
            p3(R.string.f0r, R.layout.anc, this.N0).setTag(new com.tencent.mobileqq.profile.b(55, null));
        } else if (this.f342723z0 == 6 && this.C0.B(this.f342710m0.allInOne.uin)) {
            p3(R.string.bug, R.layout.anc, this.N0).setTag(new com.tencent.mobileqq.profile.b(20, null));
        } else if (isPaTypeCanFreeCall && this.f342723z0 != 6) {
            p3(R.string.bug, R.layout.anc, this.N0).setTag(new com.tencent.mobileqq.profile.b(20, null));
        }
        if (isPaTypeCanTalk) {
            p3(R.string.fcd, R.layout.anb, this.N0).setTag(new com.tencent.mobileqq.profile.b(8, Integer.valueOf(this.f342723z0)));
        }
        if (isPaTypeCanAddAsFriend) {
            if (this.f342698a0.getChildCount() <= 0) {
                i17 = R.layout.f168770gu2;
            }
            r3(R.string.btk, i17, this.N0, 0).setTag(new com.tencent.mobileqq.profile.b(7, null));
        }
    }

    boolean U3(ProfileCardInfo profileCardInfo) {
        String str;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(profileCardInfo.allInOne.uin);
        int i3 = profileCardInfo.allInOne.f260789pa;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 86 && i3 != 41 && i3 != 42) {
                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "QidianProfileCardActivity")) {
                    return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isShieldFriend(uidFromUin, "QidianProfileCardActivity");
                }
                ShieldMsgManger shieldMsgManger = (ShieldMsgManger) this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
                if (shieldMsgManger == null) {
                    return false;
                }
                if (ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne)) {
                    str = profileCardInfo.allInOne.uin;
                } else if (ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne)) {
                    str = J3(this.app, profileCardInfo);
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return shieldMsgManger.h(str);
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QidianProfileCardActivity");
            if (friendsSimpleInfoWithUid == null || friendsSimpleInfoWithUid.f() != -1002) {
                z16 = false;
            }
            return z16;
        }
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isShieldFriend(uidFromUin, "QidianProfileCardActivity");
    }

    public void a4(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) bArr);
        } else {
            ThreadManagerV2.post(new Runnable(bArr) { // from class: com.tencent.qidian.QidianProfileCardActivity.31
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ byte[] f342732d;

                {
                    this.f342732d = bArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this, (Object) bArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String currentNickname = QidianProfileCardActivity.this.app.getCurrentNickname();
                    if (TextUtils.isEmpty(currentNickname)) {
                        currentNickname = QidianProfileCardActivity.this.app.getCurrentNickname();
                    }
                    QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                    userInfo.qzone_uin = QidianProfileCardActivity.this.app.getCurrentAccountUin();
                    userInfo.nickname = currentNickname;
                    QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                    AllInOne allInOne = qidianProfileCardActivity.f342710m0.allInOne;
                    QZoneHelper.forwardToUserHome(qidianProfileCardActivity, userInfo, allInOne.uin, allInOne.lastActivity, -1, 5, qidianProfileCardActivity.W0, this.f342732d, false);
                    QidianProfileCardActivity.this.H0 = false;
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.ProfileActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 != 1012) {
                if (i3 == 99000) {
                    super.setResult(-1);
                    super.finish();
                    return;
                }
                return;
            }
            if (intent != null) {
                if (intent.getBooleanExtra("finchat", false)) {
                    super.finish();
                    return;
                }
                String stringExtra = intent.getStringExtra("remark");
                if (!com.tencent.mobileqq.util.Utils.p(this.f342710m0.allInOne.remark, stringExtra)) {
                    setNewRemark(stringExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = true;
        super.doOnCreate(bundle);
        this.F0 = ThemeUtil.isInNightMode(this.app);
        if (QLog.isColorLevel()) {
            QLog.d(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, 2, "open profile card start " + System.currentTimeMillis());
        }
        this.C0 = (QidianManager) this.app.getManager(QQManagerFactory.QIDIAN_MANAGER);
        this.D0 = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.E0 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        try {
            setContentView(R.layout.f168769an4);
            this.f342710m0.allInOne = (AllInOne) super.getIntent().getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
            if (this.f342710m0.allInOne == null) {
                this.f342710m0.allInOne = new AllInOne(super.getIntent().getStringExtra("uin"), 104);
            }
            this.f342722y0 = super.getIntent().getIntExtra("cspecialflag", 0);
            AllInOne allInOne = this.f342710m0.allInOne;
            if (allInOne != null && (str = allInOne.uin) != null) {
                FriendsManager friendsManager = this.D0;
                if (friendsManager != null && friendsManager.c0(str) && !this.f342710m0.allInOne.uin.equals(this.app.getCurrentAccountUin())) {
                    this.f342710m0.allInOne.f260789pa = 1;
                }
                this.f342710m0.nameArray = new String[8];
                clearData();
                this.app.addObserver(this.L0);
                this.app.addObserver(this.J0);
                this.app.addObserver(this.R0);
                this.app.addObserver(this.Q0);
                this.app.addObserver(this.O0);
                this.app.addObserver(this.P0);
                this.app.addObserver(this.K0);
                if (!S3()) {
                    super.finish();
                    return false;
                }
                x4();
                this.f342712o0 = new x();
                this.f342716s0 = new ConcurrentHashMap<>();
                this.f342717t0 = new ConcurrentHashMap<>();
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qidian.QidianProfileCardActivity.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                        ProfileNameUtils.initNameArray(qidianProfileCardActivity.app, qidianProfileCardActivity.f342710m0);
                        ProfileNameUtils.updateProfileName(QidianProfileCardActivity.this.f342710m0);
                    }
                }, 8, null, true);
                f4(this.f342723z0);
                initUI();
                p4();
                e4(this.f342723z0);
                m4();
                if (QLog.isColorLevel()) {
                    QLog.d(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, 2, "open profile card end " + System.currentTimeMillis());
                }
                return true;
            }
            super.finish();
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            finish();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.doOnDestroy();
        Dialog dialog = this.f342718u0;
        if (dialog != null && dialog.isShowing()) {
            this.f342718u0.dismiss();
            this.f342718u0 = null;
        }
        this.app.removeObserver(this.L0);
        this.app.removeObserver(this.J0);
        this.app.removeObserver(this.Q0);
        this.app.removeObserver(this.O0);
        this.app.removeObserver(this.P0);
        this.app.removeObserver(this.R0);
        this.app.removeObserver(this.K0);
        clearData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (intent.getBooleanExtra("key_back_from_add_friend", false)) {
            doOnActivityResult(IProfileCardConst.REQUEST_FOR_ADD_FRIEND, -1, intent);
        }
        AllInOne allInOne = (AllInOne) intent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
        if (allInOne != null && allInOne.uin.equals(this.f342710m0.allInOne.uin)) {
            f4(this.f342723z0);
        }
        if (allInOne != null && !allInOne.uin.equals(this.f342710m0.allInOne.uin)) {
            startActivity(intent);
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnResume();
            y4(this.f342710m0.allInOne.uin);
        }
    }

    public void l4(int i3) {
        EntityManager createEntityManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (i3 == 1) {
            createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
            try {
                this.f342713p0 = (QidianExternalInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QidianExternalInfo.class, this.f342710m0.allInOne.uin);
                this.f342715r0 = (QidianProfileUiInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QidianProfileUiInfo.class, this.f342710m0.allInOne.uin);
                FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                ProfileCardInfo profileCardInfo = this.f342710m0;
                profileCardInfo.card = friendsManager.r(profileCardInfo.allInOne.uin);
                QidianExternalInfo qidianExternalInfo = this.f342713p0;
                if (qidianExternalInfo != null && !TextUtils.isEmpty(qidianExternalInfo.masterUin)) {
                    this.f342714q0 = (QidianCorpInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QidianCorpInfo.class, this.f342713p0.masterUin);
                }
                if (createEntityManager != null) {
                    createEntityManager.close();
                }
            } finally {
            }
        } else if (i3 != 0 && i3 != 2) {
            if (i3 == 6) {
                createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
                try {
                    this.f342713p0 = (QidianExternalInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QidianExternalInfo.class, this.f342710m0.allInOne.uin);
                    this.f342715r0 = (QidianProfileUiInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QidianProfileUiInfo.class, this.f342710m0.allInOne.uin);
                    if (createEntityManager != null) {
                        createEntityManager.close();
                    }
                } finally {
                }
            }
        } else {
            EntityManager createEntityManager2 = this.app.getEntityManagerFactory().createEntityManager();
            try {
                this.B0 = (BmqqUserSimpleInfo) DBMethodProxy.find(createEntityManager2, (Class<? extends Entity>) BmqqUserSimpleInfo.class, this.f342710m0.allInOne.uin);
                if (createEntityManager2 != null) {
                    createEntityManager2.close();
                }
            } finally {
                if (createEntityManager2 != null) {
                    createEntityManager2.close();
                }
            }
        }
        QidianExternalInfo qidianExternalInfo2 = this.f342713p0;
        if (qidianExternalInfo2 != null) {
            qidianExternalInfo2.initList();
        }
        runOnUiThread(new Runnable(i3) { // from class: com.tencent.qidian.QidianProfileCardActivity.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f342734d;

            {
                this.f342734d = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QidianProfileCardActivity.this.C4(this.f342734d);
                }
            }
        });
    }

    public void m4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ProfileCardInfo profileCardInfo = this.f342710m0;
        if (profileCardInfo != null && profileCardInfo.allInOne != null && profileCardInfo.isTroopMemberCard) {
            QLog.i("QidianProfileCardActivity", 1, "requestTroopMemberInfo is called");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qidian.QidianProfileCardActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianProfileCardActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ITroopMemberCardApi iTroopMemberCardApi = (ITroopMemberCardApi) QRoute.api(ITroopMemberCardApi.class);
                    QidianProfileCardActivity qidianProfileCardActivity = QidianProfileCardActivity.this;
                    iTroopMemberCardApi.requestTroopMemberInfo(qidianProfileCardActivity.app, qidianProfileCardActivity.f342710m0, "QidianProfileCardActivity");
                }
            }, 16, null, true);
        } else {
            QLog.i("QidianProfileCardActivity", 1, "[requestTroopMemberInfo] is not troop member card");
        }
    }

    public void n4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        x xVar = this.f342712o0;
        if (xVar != null) {
            xVar.sendMessage(obtain);
        }
    }

    public void notifyUser(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.S0 == null) {
            this.S0 = new QQToastNotifier(this);
        }
        this.S0.notifyUser(i3, getTitleBarHeight(), 0, i16);
    }

    public void o4(int i3, URLImageView uRLImageView, String str, boolean z16) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), uRLImageView, str, Boolean.valueOf(z16));
            return;
        }
        if (!TextUtils.isEmpty(str) && uRLImageView != null) {
            if (!z16 && this.f342717t0.containsKey(str) && this.f342717t0.get(str) != null) {
                uRLImageView.setImageDrawable(this.f342717t0.get(str));
                return;
            }
            if (i3 == 0) {
                drawable = FaceDrawable.getFaceDrawable(this.app, 1, str);
            } else if (i3 != 1 && i3 != 2) {
                QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
                qQProAvatarDrawable.q(this, 4, str);
                drawable = qQProAvatarDrawable;
            } else {
                drawable = Q3(uRLImageView, str);
            }
            if (drawable != null) {
                this.f342717t0.put(str, drawable);
                uRLImageView.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 21) {
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
            m3.putExtras(new Bundle(intent.getExtras()));
            startActivity(m3);
            finish();
            return;
        }
        if (i3 == 8 && intent != null && intent.getExtras() != null) {
            TroopMemberCard troopMemberCard = (TroopMemberCard) intent.getSerializableExtra("troopMemberCard");
            if (troopMemberCard != null) {
                this.f342710m0.troopMemberCard = troopMemberCard;
            }
            if (intent.getBooleanExtra("finchat", false)) {
                super.finish();
            } else {
                setNewRemark(intent.getStringExtra("remark"));
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.ProfileActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void r4(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        this.f342719v0 = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        QidianExternalInfo qidianExternalInfo = this.f342713p0;
        if (qidianExternalInfo != null && !qidianExternalInfo.isExternalMobileVerified()) {
            this.f342719v0.addButton(super.getResources().getStringArray(R.array.f155154g)[4], 1);
            z16 = true;
        } else {
            z16 = false;
        }
        this.f342719v0.addButton(super.getResources().getStringArray(R.array.f155154g)[0], 1);
        if (this.f342723z0 == 1 && this.C0.X(this.f342710m0.allInOne.uin)) {
            this.f342719v0.addButton(super.getResources().getStringArray(R.array.f155154g)[1], 1);
        }
        this.f342719v0.addButton(super.getResources().getStringArray(R.array.f155154g)[2], 1);
        this.f342719v0.addCancelButton(super.getResources().getStringArray(R.array.f155154g)[3]);
        this.f342719v0.setOnButtonClickListener(new h(z16, str));
        this.f342719v0.show();
    }

    public void removeLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.A0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.A0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
        } else {
            super.requestWindowFeature(1);
            getWindow().setFormat(-3);
        }
    }

    public void s4(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            TroopUtils.I(this, aq.b(str, 31), 2);
        }
    }

    public void showLoading(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (this.A0 == null) {
            this.A0 = new QQProgressDialog(this, getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        this.A0.setCanceledOnTouchOutside(true);
        this.A0.setMessage(i3);
        this.A0.show();
    }

    public void t4(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(IPublicAccountUtil.NEED_FINISH, true);
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent, this.app, this, str, -1);
    }

    public void u3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
        QidianExternalInfo qidianExternalInfo = this.f342713p0;
        if (qidianExternalInfo != null) {
            this.f342710m0.profileName.f305805a.f305804b = qidianExternalInfo.nickname;
        }
        ProfileBottomContainer.addFriend(this.app, this, this.f342710m0, this.f342718u0);
    }

    public void v4(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        if (this.f342720w0 == null) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            this.f342720w0 = actionSheet;
            actionSheet.addButton(super.getResources().getStringArray(R.array.f155155h)[0], 1);
            if (this.f342723z0 == 1 && this.C0.X(this.f342710m0.allInOne.uin)) {
                this.f342720w0.addButton(super.getResources().getStringArray(R.array.f155155h)[1]);
            }
            this.f342720w0.addCancelButton(super.getResources().getStringArray(R.array.f155155h)[2]);
            this.f342720w0.setOnButtonClickListener(new g(str));
        }
        this.f342720w0.show();
    }

    public void w4(com.tencent.qidian.data.c cVar, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) cVar, i3);
            return;
        }
        String str = cVar.f342883g;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.T0 == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 0, R.layout.ane, (String) null, (String) null, getString(R.string.close), getString(R.string.close), new m(), (DialogInterface.OnClickListener) null);
            this.T0 = createCustomDialog;
            createCustomDialog.setCanceledOnTouchOutside(true);
        }
        if (i3 == 50) {
            i16 = R.string.f0u;
        } else {
            i16 = R.string.f196614hs;
        }
        this.T0.setMessageCount(super.getString(i16));
        Drawable R3 = R3((URLImageView) this.T0.framePreviewImage, str);
        this.T0.setPreviewImage(R3, true, 1);
        if (this.T0.getWindow() != null) {
            this.T0.getWindow().findViewById(R.id.cla).setOnLongClickListener(new n(R3, cVar));
        }
        this.T0.show();
    }

    public void z3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        if (str != null && str.length() > 0) {
            super.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + str)));
        }
    }
}
