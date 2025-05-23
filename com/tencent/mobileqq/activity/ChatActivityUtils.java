package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.adelie.av.api.IAdelieAVActivityApi;
import com.tencent.ads.data.AdParam;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.av.utils.t;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.rtc.node.report.RtcNodeReportMainProcessTask;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFastImage;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.d;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import common.config.service.QzoneConfig;
import cooperation.groupvideo.api.IGroupVideoHelper;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatActivityUtils extends com.tencent.mobileqq.activity.i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f175161a;

    /* renamed from: b, reason: collision with root package name */
    static QQCustomDialog f175162b;

    /* renamed from: c, reason: collision with root package name */
    public static Queue<String> f175163c;

    /* renamed from: d, reason: collision with root package name */
    private static QQProgressDialog f175164d;

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f175165e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.ChatActivityUtils$15, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass15 implements t.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f175166a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f175167b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175168c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qcall.f f175169d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f175170e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Intent f175171f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f175172g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f175173h;

        AnonymousClass15(int i3, int i16, QQAppInterface qQAppInterface, com.tencent.mobileqq.qcall.f fVar, long j3, Intent intent, long j16, String str) {
            this.f175166a = i3;
            this.f175167b = i16;
            this.f175168c = qQAppInterface;
            this.f175169d = fVar;
            this.f175170e = j3;
            this.f175171f = intent;
            this.f175172g = j16;
            this.f175173h = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), qQAppInterface, fVar, Long.valueOf(j3), intent, Long.valueOf(j16), str);
            }
        }

        @Override // com.tencent.av.utils.t.a
        public void a(Context context, String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
                return;
            }
            String str3 = null;
            if (this.f175166a == 0 && this.f175167b == 3000) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatActivityUtils.15.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            AnonymousClass15.this.f175168c.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatActivityUtils.15.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                                        anonymousClass15.f175169d.c(1, anonymousClass15.f175170e, "", "");
                                    }
                                }
                            });
                        }
                    }
                }, 5, null, true);
            }
            int intExtra = this.f175171f.getIntExtra("MultiAVType", 0);
            if (intExtra != 2) {
                str3 = this.f175171f.getComponent().getClassName();
                str2 = context.getClass().getName();
                QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, className[" + str3 + "], contextName[" + str2 + "]");
            } else {
                str2 = null;
            }
            if (intExtra == 2) {
                if (this.f175168c.getAVNotifyCenter().W(1, this.f175172g)) {
                    this.f175168c.getApp().sendBroadcast(new Intent("tencent.video.q2v.back2VideoRoom"));
                } else {
                    ((IGroupVideoHelper) QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(this.f175168c, context, this.f175171f, 1);
                }
            } else if (!TextUtils.isEmpty(str3) && str3.equals("com.tencent.av.ui.AVActivity") && ((!TextUtils.isEmpty(str2) && str2.equals("com.tencent.mobileqq.qcall.QCallDetailActivity")) || str2.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity") || str2.equals("com.tencent.mobileqq.activity.SplashActivity") || str2.equals("com.tencent.mobileqq.activity.recent.RecentT9SearchActivity"))) {
                Intent intent = new Intent(context, (Class<?>) AVLoadingDialogActivity.class);
                intent.putExtra("avactivity_intent", this.f175171f);
                intent.addFlags(268435456);
                QQAudioHelper.p("\u53d1\u8d77\u97f3\u89c6\u9891_start_AVLoadingDialogActivity");
                context.startActivity(intent);
                this.f175171f.setExtrasClassLoader(ResultRecord.class.getClassLoader());
                context.startActivity(this.f175171f);
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(R.anim.f154855e4, 0);
                }
            } else {
                QQAudioHelper.p("\u53d1\u8d77\u97f3\u89c6\u9891_start_AVActivity");
                context.startActivity(this.f175171f);
            }
            if (this.f175166a == 0) {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.ChatActivityUtils.15.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass15.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(AppConstants.CALL_PREF, 0);
                        long K0 = com.tencent.mobileqq.service.message.e.K0() * 1000;
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(AnonymousClass15.this.f175173h, String.valueOf(K0));
                        edit.commit();
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class AddFriendSpan extends URLSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f175176d;

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Context context = view.getContext();
            if ((context instanceof SplashActivity) || (context instanceof ChatActivity)) {
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                textPaint.setColor(this.f175176d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Bundle C;
        final /* synthetic */ String D;
        final /* synthetic */ String E;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175177d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f175178e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f175179f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f175180h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f175181i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ u f175182m;

        a(QQAppInterface qQAppInterface, Context context, int i3, String str, boolean z16, u uVar, Bundle bundle, String str2, String str3) {
            this.f175177d = qQAppInterface;
            this.f175178e = context;
            this.f175179f = i3;
            this.f175180h = str;
            this.f175181i = z16;
            this.f175182m = uVar;
            this.C = bundle;
            this.D = str2;
            this.E = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, Integer.valueOf(i3), str, Boolean.valueOf(z16), uVar, bundle, str2, str3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 1) {
                ChatActivityUtils.g0(this.f175177d, this.f175178e, this.f175179f, this.f175180h, false, this.f175181i, this.f175182m, this.C, this.D, this.E);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Bundle C;
        final /* synthetic */ String D;
        final /* synthetic */ String E;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175183d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f175184e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f175185f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f175186h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f175187i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ u f175188m;

        b(QQAppInterface qQAppInterface, Context context, int i3, String str, boolean z16, u uVar, Bundle bundle, String str2, String str3) {
            this.f175183d = qQAppInterface;
            this.f175184e = context;
            this.f175185f = i3;
            this.f175186h = str;
            this.f175187i = z16;
            this.f175188m = uVar;
            this.C = bundle;
            this.D = str2;
            this.E = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, Integer.valueOf(i3), str, Boolean.valueOf(z16), uVar, bundle, str2, str3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ChatActivityUtils.g0(this.f175183d, this.f175184e, this.f175185f, this.f175186h, false, this.f175187i, this.f175188m, this.C, this.D, this.E);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Bundle C;
        final /* synthetic */ String D;
        final /* synthetic */ String E;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175189d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f175190e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f175191f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f175192h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f175193i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ u f175194m;

        c(QQAppInterface qQAppInterface, Context context, int i3, String str, boolean z16, u uVar, Bundle bundle, String str2, String str3) {
            this.f175189d = qQAppInterface;
            this.f175190e = context;
            this.f175191f = i3;
            this.f175192h = str;
            this.f175193i = z16;
            this.f175194m = uVar;
            this.C = bundle;
            this.D = str2;
            this.E = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, Integer.valueOf(i3), str, Boolean.valueOf(z16), uVar, bundle, str2, str3);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ChatActivityUtils.g0(this.f175189d, this.f175190e, this.f175191f, this.f175192h, this.f175193i, false, this.f175194m, this.C, this.D, this.E);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements t {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f175195a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175196b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f175197c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f175198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f175199e;

        d(Bundle bundle, QQAppInterface qQAppInterface, Context context, int i3, String str) {
            this.f175195a = bundle;
            this.f175196b = qQAppInterface;
            this.f175197c = context;
            this.f175198d = i3;
            this.f175199e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bundle, qQAppInterface, context, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.t
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            QQAudioHelper.p("\u53d1\u8d77\u97f3\u89c6\u9891_\u83b7\u53d6\u4f1a\u8baeid_rsp");
            Bundle bundle = this.f175195a;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("ConfAppID", i3);
            bundle.putInt("MeetingConfID", i16);
            ChatActivityUtils.q(this.f175196b, this.f175197c, this.f175198d, this.f175199e, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements QAVHrMeeting.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f175200a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175201b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f175202c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f175203d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f175204e;

        e(Bundle bundle, QQAppInterface qQAppInterface, Context context, int i3, String str) {
            this.f175200a = bundle;
            this.f175201b = qQAppInterface;
            this.f175202c = context;
            this.f175203d = i3;
            this.f175204e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bundle, qQAppInterface, context, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.utils.QAVHrMeeting.a
        public void onComplete(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            } else {
                this.f175200a.putInt("MeetingStasks", i3);
                ChatActivityUtils.q(this.f175201b, this.f175202c, this.f175203d, this.f175204e, this.f175200a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
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
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements d.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f175205a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f175206b;

        g(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
            this.f175205a = onClickListener;
            this.f175206b = onClickListener2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onClickListener, (Object) onClickListener2);
            }
        }

        @Override // com.tencent.mobileqq.vip.d.b
        public void callback(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChatActivityUtils", 2, "showDlgWithCuOpenCheck type = " + i3);
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3 || i3 == 4) {
                    this.f175206b.onClick(null, 0);
                    return;
                }
                return;
            }
            this.f175205a.onClick(null, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f175207a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQPermission f175208b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f175209c;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    h.this.f175209c.onClick(null, 0);
                }
            }
        }

        h(Activity activity, QQPermission qQPermission, DialogInterface.OnClickListener onClickListener) {
            this.f175207a = activity;
            this.f175208b = qQPermission;
            this.f175209c = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, qQPermission, onClickListener);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.av.utils.ai.l(true);
                ChatActivityUtils.h(this.f175207a, this.f175208b, this.f175209c, true);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) list2);
            } else {
                this.f175209c.onClick(null, 0);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissionRequestDialog, (Object) list);
            } else {
                super.onDialogShow(permissionRequestDialog, list);
                permissionRequestDialog.setOnDismissListener(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f175211a;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    DialogInterface.OnClickListener onClickListener = i.this.f175211a;
                    if (onClickListener != null) {
                        onClickListener.onClick(null, 1);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        i(DialogInterface.OnClickListener onClickListener) {
            this.f175211a = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onClickListener);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            DialogInterface.OnClickListener onClickListener = this.f175211a;
            if (onClickListener != null) {
                onClickListener.onClick(null, 1);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            DialogInterface.OnClickListener onClickListener = this.f175211a;
            if (onClickListener != null) {
                onClickListener.onClick(null, 1);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) permissionRequestDialog, (Object) list);
            } else {
                super.onDialogShow(permissionRequestDialog, list);
                permissionRequestDialog.setOnDisAllowClickListener(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f175213d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175214e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f175215f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ u f175216h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ v f175217i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f175218m;

        j(long j3, QQAppInterface qQAppInterface, Context context, u uVar, v vVar, String str, String str2) {
            this.f175213d = j3;
            this.f175214e = qQAppInterface;
            this.f175215f = context;
            this.f175216h = uVar;
            this.f175217i = vVar;
            this.f175218m = str;
            this.C = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), qQAppInterface, context, uVar, vVar, str, str2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 1) {
                ChatActivityUtils.l0(this.f175213d, this.f175214e, this.f175215f, this.f175216h, this.f175217i, this.f175218m, this.C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;
        final /* synthetic */ boolean D;
        final /* synthetic */ boolean E;
        final /* synthetic */ u F;
        final /* synthetic */ String G;
        final /* synthetic */ Map H;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175219d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f175220e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f175221f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f175222h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f175223i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f175224m;

        k(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, boolean z16, String str3, boolean z17, boolean z18, u uVar, String str4, Map map) {
            this.f175219d = qQAppInterface;
            this.f175220e = context;
            this.f175221f = i3;
            this.f175222h = str;
            this.f175223i = str2;
            this.f175224m = z16;
            this.C = str3;
            this.D = z17;
            this.E = z18;
            this.F = uVar;
            this.G = str4;
            this.H = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), str3, Boolean.valueOf(z17), Boolean.valueOf(z18), uVar, str4, map);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 1) {
                ChatActivityUtils.c0(this.f175219d, this.f175220e, this.f175221f, this.f175222h, this.f175223i, this.f175224m, this.C, this.D, this.E, this.F, this.G, this.H);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
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
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f175225d;

        n(u uVar) {
            this.f175225d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            u uVar = this.f175225d;
            if (uVar != null) {
                uVar.onCancel();
            }
            DataReport.Y(true, false);
            dialogInterface.dismiss();
            DataReport.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f175226d;

        o(u uVar) {
            this.f175226d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            u uVar = this.f175226d;
            if (uVar != null) {
                uVar.onCancel();
            }
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f175227d;

        p(u uVar) {
            this.f175227d = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            u uVar = this.f175227d;
            if (uVar != null) {
                uVar.onCancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String C;
        final /* synthetic */ int D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f175228d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175229e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f175230f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f175231h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f175232i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f175233m;

        q(long j3, QQAppInterface qQAppInterface, Context context, int i3, int i16, DialogInterface.OnClickListener onClickListener, String str, int i17) {
            this.f175228d = j3;
            this.f175229e = qQAppInterface;
            this.f175230f = context;
            this.f175231h = i3;
            this.f175232i = i16;
            this.f175233m = onClickListener;
            this.C = str;
            this.D = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), qQAppInterface, context, Integer.valueOf(i3), Integer.valueOf(i16), onClickListener, str, Integer.valueOf(i17));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ChatActivityUtils.U(this.f175228d, this.f175229e, this.f175230f, this.f175231h, this.f175232i);
            this.f175233m.onClick(dialogInterface, i3);
            ReportController.o(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.C + "", this.D + "", "0", "");
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f175234d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f175235e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f175236f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f175237h;

        r(u uVar, String str, int i3, QQAppInterface qQAppInterface) {
            this.f175234d = uVar;
            this.f175235e = str;
            this.f175236f = i3;
            this.f175237h = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, uVar, str, Integer.valueOf(i3), qQAppInterface);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            u uVar = this.f175234d;
            if (uVar != null) {
                uVar.onCancel();
            }
            ReportController.o(null, "dc00899", "Grp_video", "", "video_jump", "Clk_jump", 0, 0, this.f175235e + "", this.f175236f + "", "1", "");
            QAVHrMeeting.i(this.f175237h, Long.valueOf(this.f175235e).longValue(), null);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class s extends BaseDownloadAsyncTask {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        t f175238e;

        /* renamed from: f, reason: collision with root package name */
        final String f175239f;

        s(String str, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) tVar);
            } else {
                this.f175239f = str;
                this.f175238e = tVar;
            }
        }

        public static void h(String str, String str2, t tVar) {
            String str3 = "https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_confid_by_discid?discid=" + str2;
            QLog.w(str, 1, "getConfId, uin[" + str2 + "]");
            s sVar = new s(str, tVar);
            ArrayList arrayList = new ArrayList();
            com.tencent.av.utils.download.a aVar = new com.tencent.av.utils.download.a();
            aVar.f77096a = str3;
            aVar.f77099d = 1000;
            aVar.f77100e = 1000;
            aVar.f77098c = 0;
            arrayList.add(aVar);
            sVar.execute(arrayList);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0154  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00d5  */
        @Override // com.tencent.av.utils.download.BaseDownloadAsyncTask
        @TargetApi(9)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(com.tencent.av.utils.download.a aVar) {
            String str;
            String str2;
            int i3;
            int i16;
            JSONObject jSONObject;
            int i17;
            int i18;
            JSONObject jSONObject2;
            t tVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            com.tencent.av.utils.download.b bVar = aVar.f77101f;
            int i19 = 0;
            int i26 = -100;
            if (bVar.f77107f) {
                try {
                    str = new String(bVar.f77102a, "UTF-8");
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(this.f175239f, 2, "getConfId.Complete :" + e16.toString());
                    }
                    i26 = -1;
                    str = null;
                }
                if (str != null) {
                    try {
                        jSONObject = new JSONObject(str);
                        i17 = jSONObject.getInt("retcode");
                        if (QLog.isColorLevel()) {
                            QLog.d(this.f175239f, 2, "getConfId.Complete : retcode = " + i17);
                        }
                    } catch (JSONException unused) {
                        str2 = null;
                    } catch (Exception unused2) {
                        str2 = null;
                    }
                    if (i17 == 0 && (jSONObject2 = jSONObject.getJSONObject("result")) != null) {
                        str2 = jSONObject2.getString("result_code");
                        try {
                        } catch (JSONException unused3) {
                            i3 = 0;
                            i16 = -3;
                            if (QLog.isColorLevel()) {
                                QLog.i(this.f175239f, 2, "getConfId.Complete : errorCode = " + str2 + ",ret = -3");
                            }
                            QLog.w(this.f175239f, 1, "getConfId.Complete, ret[" + i16 + "], appId[" + i19 + "], confid[" + i3 + "], content[" + str + "]");
                            tVar = this.f175238e;
                            if (tVar != null) {
                            }
                        } catch (Exception unused4) {
                            i3 = 0;
                            i16 = -4;
                            if (QLog.isColorLevel()) {
                                QLog.i(this.f175239f, 2, "getConfId.Complete : errorCode = " + str2 + ",ret = -4");
                            }
                            QLog.w(this.f175239f, 1, "getConfId.Complete, ret[" + i16 + "], appId[" + i19 + "], confid[" + i3 + "], content[" + str + "]");
                            tVar = this.f175238e;
                            if (tVar != null) {
                            }
                        }
                        if (str2.equals("0")) {
                            String string = jSONObject2.getString("confidshort");
                            String string2 = jSONObject2.getString("pstnappid");
                            if (!TextUtils.isEmpty(string) && string.compareToIgnoreCase("null") != 0) {
                                i3 = Integer.valueOf(string).intValue();
                                try {
                                    i18 = Integer.valueOf(string2).intValue();
                                    i17 = 0;
                                    i19 = i3;
                                    i16 = i17;
                                    i3 = i19;
                                    i19 = i18;
                                } catch (JSONException unused5) {
                                    i16 = -3;
                                    if (QLog.isColorLevel()) {
                                    }
                                    QLog.w(this.f175239f, 1, "getConfId.Complete, ret[" + i16 + "], appId[" + i19 + "], confid[" + i3 + "], content[" + str + "]");
                                    tVar = this.f175238e;
                                    if (tVar != null) {
                                    }
                                } catch (Exception unused6) {
                                    i16 = -4;
                                    if (QLog.isColorLevel()) {
                                    }
                                    QLog.w(this.f175239f, 1, "getConfId.Complete, ret[" + i16 + "], appId[" + i19 + "], confid[" + i3 + "], content[" + str + "]");
                                    tVar = this.f175238e;
                                    if (tVar != null) {
                                    }
                                }
                                QLog.w(this.f175239f, 1, "getConfId.Complete, ret[" + i16 + "], appId[" + i19 + "], confid[" + i3 + "], content[" + str + "]");
                                tVar = this.f175238e;
                                if (tVar != null) {
                                    tVar.a(i19, i3);
                                    this.f175238e = null;
                                    return;
                                }
                                return;
                            }
                            i17 = -2;
                        }
                    }
                    i18 = 0;
                    i16 = i17;
                    i3 = i19;
                    i19 = i18;
                    QLog.w(this.f175239f, 1, "getConfId.Complete, ret[" + i16 + "], appId[" + i19 + "], confid[" + i3 + "], content[" + str + "]");
                    tVar = this.f175238e;
                    if (tVar != null) {
                    }
                }
            } else {
                str = null;
            }
            i16 = i26;
            i3 = 0;
            QLog.w(this.f175239f, 1, "getConfId.Complete, ret[" + i16 + "], appId[" + i19 + "], confid[" + i3 + "], content[" + str + "]");
            tVar = this.f175238e;
            if (tVar != null) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface t {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface u {
        void a();

        void b();

        void onCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class v {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f175240a;

        /* renamed from: b, reason: collision with root package name */
        public String f175241b;

        /* renamed from: c, reason: collision with root package name */
        public String f175242c;

        /* renamed from: d, reason: collision with root package name */
        public String f175243d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f175244e;

        /* renamed from: f, reason: collision with root package name */
        public String f175245f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f175246g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f175247h;

        /* renamed from: i, reason: collision with root package name */
        public String f175248i;

        /* renamed from: j, reason: collision with root package name */
        public Map<String, String> f175249j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f175250k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f175251l;

        /* renamed from: m, reason: collision with root package name */
        public String f175252m;

        protected v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f175252m = "";
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f175161a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        f175162b = null;
        f175163c = new LinkedList();
        f175165e = null;
    }

    static Activity A(long j3, Context context) {
        Activity activity = null;
        if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (!activity2.isFinishing()) {
                activity = activity2;
            }
        }
        if (activity == null) {
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            QLog.w("ChatActivityUtils", 1, "getBaseActivity, Context[" + context + "], baseActivity[" + baseActivity + "], seq[" + j3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            return baseActivity;
        }
        return activity;
    }

    public static String B(int i3) {
        int i16;
        if (i3 != 0) {
            i16 = 1;
            if (i3 != 1) {
                if (i3 != 1000 && i3 != 1001) {
                    if (i3 != 1008) {
                        if (i3 != 1009 && i3 != 1020) {
                            if (i3 != 3000) {
                                if (i3 != 10002 && i3 != 10004 && i3 != 10008 && i3 != 10010) {
                                    switch (i3) {
                                        case 1003:
                                        case 1004:
                                        case 1005:
                                            break;
                                        default:
                                            switch (i3) {
                                                case 1023:
                                                case 1024:
                                                case 1025:
                                                    break;
                                                default:
                                                    i16 = 999;
                                                    break;
                                            }
                                    }
                                }
                            } else {
                                i16 = 2;
                            }
                        }
                    } else {
                        i16 = 4;
                    }
                }
            } else {
                i16 = 3;
            }
        } else {
            i16 = 0;
        }
        return String.valueOf(i16);
    }

    static String C(QQAppInterface qQAppInterface, String str) {
        try {
            String[] split = str.replace(Marker.ANY_NON_NULL_MARKER, "").split(",");
            byte[] bArr = new byte[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                bArr[i3] = Byte.parseByte(split[i3].trim());
            }
            byte[] d16 = d(bArr, y(qQAppInterface.getCurrentAccountUin() + "MasPlay", 32).getBytes("UTF-8"));
            if (d16 != null) {
                return new String(d16, "UTF-8").replace("$", "");
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static MessageRecord D(List<ChatMessage> list, com.tencent.mobileqq.activity.aio.p pVar, QQAppInterface qQAppInterface) {
        ChatMessage chatMessage;
        if (!com.tencent.mobileqq.activity.i.a(pVar.f179555d) || list == null || list.isEmpty()) {
            return null;
        }
        boolean z16 = false;
        if (pVar.f179555d == 1006) {
            chatMessage = list.get(0);
        } else {
            int size = list.size();
            if (pVar.f179555d != 10008) {
                z16 = true;
            }
            int i3 = size - 1;
            while (true) {
                if (i3 >= 0) {
                    ChatMessage chatMessage2 = list.get(i3);
                    if ((!z16 || !chatMessage2.isSend()) && !com.tencent.imcore.message.ad.D(chatMessage2.msgtype)) {
                        chatMessage = chatMessage2;
                        break;
                    }
                    i3--;
                } else {
                    chatMessage = null;
                    break;
                }
            }
            if (chatMessage == null) {
                return null;
            }
        }
        return E(chatMessage, qQAppInterface);
    }

    private static MessageRecord E(MessageRecord messageRecord, QQAppInterface qQAppInterface) {
        int i3 = messageRecord.msgtype;
        if (i3 == -1003 || i3 == -1031 || i3 == -1032 || i3 == -3001 || com.tencent.imcore.message.ao.c(messageRecord.istroop) == 1032 || com.tencent.qqnt.contact.friends.b.f355778a.c(messageRecord.frienduin, "ChatActivityUtils")) {
            return null;
        }
        return messageRecord;
    }

    public static MessageRecord F(List<ChatMessage> list, com.tencent.mobileqq.activity.aio.p pVar, QQAppInterface qQAppInterface) {
        ChatMessage chatMessage;
        if (!com.tencent.mobileqq.activity.i.a(pVar.f179555d) || list == null || list.isEmpty()) {
            return null;
        }
        if (pVar.f179555d == 1006) {
            chatMessage = list.get(0);
        } else {
            int size = list.size() - 1;
            while (true) {
                if (size >= 0) {
                    ChatMessage chatMessage2 = list.get(size);
                    if (!com.tencent.imcore.message.ad.D(chatMessage2.msgtype)) {
                        chatMessage = chatMessage2;
                        break;
                    }
                    size--;
                } else {
                    chatMessage = null;
                    break;
                }
            }
            if (chatMessage == null) {
                return null;
            }
        }
        return E(chatMessage, qQAppInterface);
    }

    public static Integer G(String str, String str2) {
        ConcurrentHashMap<String, Integer> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = f175165e) != null) {
            return concurrentHashMap.get(str + str2);
        }
        return null;
    }

    public static byte[] H(String str) {
        if (str != null && !str.equals("")) {
            String upperCase = str.toUpperCase();
            int length = upperCase.length() / 2;
            char[] charArray = upperCase.toCharArray();
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = (byte) (g(charArray[i16 + 1]) | (g(charArray[i16]) << 4));
            }
            return bArr;
        }
        return null;
    }

    public static void I() {
        QQCustomDialog qQCustomDialog = f175162b;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            f175162b.dismiss();
        }
        f175162b = null;
    }

    public static void J(SessionInfo sessionInfo, Intent intent) {
        if (sessionInfo != null && intent != null) {
            intent.putExtra("uin", sessionInfo.f179557e);
            intent.putExtra("uintype", sessionInfo.f179555d);
            intent.putExtra("uinname", sessionInfo.f179563i);
            intent.putExtra("troop_uin", sessionInfo.f179559f);
            intent.putExtra(AppConstants.Key.PHONENUM, sessionInfo.f179564m);
        }
    }

    public static boolean K(Context context, SessionInfo sessionInfo, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", sessionInfo.f179555d);
            jSONObject.put("uin", com.tencent.imcore.message.an.a(sessionInfo.f179557e));
            if (QLog.isDevelopLevel()) {
                QLog.d("ChatActivityUtils", 4, "isSingleWayFriendTipsBefore curFriendUin:" + sessionInfo.f179557e + "  curType" + sessionInfo.f179555d);
            }
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            jSONArray.mo162put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString(str, jSONArray2);
            return edit.commit();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004d, code lost:
    
        if (((com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService.class)).isShieldFriend(r3, "ChatActivityUtils") != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
    
        if (r8.f() == (-1002)) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean L(QQAppInterface qQAppInterface, int i3, String str, String str2) {
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== uinType = " + i3);
        }
        ShieldMsgManger shieldMsgManger = (ShieldMsgManger) qQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        if (!TextUtils.isEmpty(str)) {
            str3 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        } else {
            str3 = "";
        }
        boolean z16 = true;
        boolean z17 = false;
        if (i3 != 0) {
            if (i3 != 1001 && i3 != 10002 && i3 != 10010) {
                if (i3 != 1011 && shieldMsgManger != null) {
                    if (i3 == 1006 && str == null) {
                        str = com.tencent.mobileqq.utils.ac.m0(qQAppInterface, str2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        z16 = shieldMsgManger.h(str);
                    }
                }
                z16 = z17;
            } else {
                if (shieldMsgManger != null) {
                    z17 = shieldMsgManger.h(str);
                }
                if (!z17) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(str3, "ChatActivityUtils");
                    if (friendsSimpleInfoWithUid != null) {
                    }
                }
                z16 = z17;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== isMsgShield = " + z16);
        }
        return z16;
    }

    public static boolean M(QQAppInterface qQAppInterface, int i3, String str) {
        if ((1024 == i3 && CrmUtils.u(qQAppInterface, str)) || i3 != 0 || com.tencent.qqnt.contact.friends.b.f355778a.c(str, "ChatActivityUtils")) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ChatActivityUtils", 4, "isSingleWayFriend  true");
            return true;
        }
        return true;
    }

    public static boolean N(QQAppInterface qQAppInterface, SessionInfo sessionInfo) {
        return M(qQAppInterface, sessionInfo.f179555d, sessionInfo.f179557e);
    }

    public static boolean O(Context context, SessionInfo sessionInfo, String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ChatActivityUtils", 4, "single friend list: " + string + " curType:" + sessionInfo.f179555d + " curFriendUin:" + sessionInfo.f179557e);
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.has("type") && jSONObject.has("uin")) {
                    int i16 = jSONObject.getInt("type");
                    String string2 = jSONObject.getString("uin");
                    if (i16 == sessionInfo.f179555d && string2.equals(com.tencent.imcore.message.an.a(sessionInfo.f179557e))) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("ChatActivityUtils", 4, "isSingleWayFriendTipsBefore true");
                        }
                        return true;
                    }
                }
            }
            return false;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return true;
        }
    }

    public static boolean P(String str) {
        if (str == null || str.trim().length() <= 0 || str.trim().equals(String.valueOf(0))) {
            return false;
        }
        return true;
    }

    public static void Q(Context context, int i3, int i16) {
        new QQToastNotifier(context).notifyUser(i3, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height), 0, i16);
    }

    public static void R(Activity activity, int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV)).onRequestPermissionResult(i3, strArr, iArr);
        QLog.d("ChatActivityUtils", 1, "onRequestPermissionsResult requestCode=" + i3 + " permissions=" + strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void S(QQAppInterface qQAppInterface, Context context, int i3, String str, Bundle bundle) {
        boolean z16;
        DiscussionInfo h16;
        if (i3 == 3000 && (h16 = ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str)) != null) {
            z16 = true;
            if (h16.isPSTNConf()) {
                QQAudioHelper.p("\u53d1\u8d77\u97f3\u89c6\u9891_\u83b7\u53d6\u4f1a\u8baeid");
                s.h("ChatActivityUtils", h16.uin, new d(bundle, qQAppInterface, context, i3, str));
            } else if (h16.isDiscussHrMeeting() && (bundle == null || !bundle.containsKey("MeetingStasks"))) {
                QQAudioHelper.p("\u53d1\u8d77\u97f3\u89c6\u9891_\u83b7\u53d6hr\u4fe1\u606f");
                QAVHrMeeting.e(qQAppInterface, str, qQAppInterface.getCurrentAccountUin(), new e(bundle, qQAppInterface, context, i3, str));
            }
            if (z16) {
                q(qQAppInterface, context, i3, str, bundle);
                return;
            }
            return;
        }
        z16 = false;
        if (z16) {
        }
    }

    public static void T() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = f175165e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        } else {
            f175165e = new ConcurrentHashMap<>();
        }
    }

    public static void U(long j3, QQAppInterface qQAppInterface, Context context, int i3, int i16) {
        long n3 = qQAppInterface.getAVNotifyCenter().n();
        int o16 = qQAppInterface.getAVNotifyCenter().o();
        int l3 = qQAppInterface.getAVNotifyCenter().l(n3);
        QLog.w("ChatActivityUtils", 1, "sendExitBroadcast, finalType[" + i3 + "], finalAvType[" + i16 + "], chattingType[" + o16 + "], seq[" + j3 + "]");
        if (i3 == 1 || o16 == 1) {
            if (l3 == 2 && i16 != 2) {
                context.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            } else if (l3 != 2 && i16 == 2) {
                Intent intent = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
                com.tencent.av.utils.at.f(intent, j3);
                context.sendBroadcast(intent);
            }
        }
    }

    public static void V(QQAppInterface qQAppInterface, String str, Integer num) {
        boolean z16;
        String str2;
        TroopInfo k3;
        if (!TextUtils.isEmpty(str) && qQAppInterface != null && !TextUtils.isEmpty(qQAppInterface.getCurrentAccountUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("ChatActivityUtils.troop.notification_center.show_red_dot", 2, "setTroopTipStatus, troopUin:" + str + ",status:" + num);
            }
            if (num.intValue() != -1 && num.intValue() != 0) {
                return;
            }
            if (f175165e == null) {
                f175165e = new ConcurrentHashMap<>();
            }
            f175165e.put(str + qQAppInterface.getCurrentAccountUin(), num);
            if (num.intValue() == -1) {
                TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null && (k3 = troopManager.k(str)) != null) {
                    z16 = k3.isOwnerOrAdmin();
                } else {
                    z16 = false;
                }
                if (z16) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, str, str2, "", "");
            }
        }
    }

    public static void W(QQAppInterface qQAppInterface, Activity activity, int i3, String str, String str2, boolean z16) {
        s(qQAppInterface, activity, i3, str, str2, z16, false);
    }

    private static boolean X(Map<String, String> map) {
        if (QLog.isColorLevel()) {
            QLog.i("ChatActivityUtils", 2, "shouldBelieveOnlyAudioFlag called");
        }
        if (map == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatActivityUtils", 2, "shouldBelieveOnlyAudioFlag extras null");
            }
            return false;
        }
        if (!map.containsKey("should_believe_only_audio_flag")) {
            return false;
        }
        String str = map.get("should_believe_only_audio_flag");
        if (QLog.isColorLevel()) {
            QLog.i("ChatActivityUtils", 2, "shouldBelieveOnlyAudioFlag shouldBelieveOnlyAudioFlag is " + str);
        }
        return TextUtils.equals(str, "true");
    }

    public static View Y(Context context, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View view = null;
        if (context == null) {
            return null;
        }
        try {
            view = LayoutInflater.from(context).inflate(R.layout.f167760gc, (ViewGroup) null);
            View findViewById = view.findViewById(R.id.awo);
            TextView textView = (TextView) view.findViewById(R.id.awp);
            ImageView imageView = (ImageView) view.findViewById(R.id.awn);
            if (str != null) {
                textView.setText(str);
            }
            imageView.setOnClickListener(onClickListener2);
            findViewById.setOnClickListener(onClickListener);
        } catch (RuntimeException unused) {
            QLog.e("ChatActivityUtils", 1, "showChatTopBar, RuntimeException");
        }
        return view;
    }

    public static void Z(Context context) {
        DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f6e), context.getString(R.string.f6f), new f(), null).show();
    }

    public static QQCustomDialog a0(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        Context context2;
        if (context instanceof Activity) {
            context2 = context;
        } else {
            context2 = BaseActivity.sTopActivity;
        }
        Activity activity = (Activity) context2;
        if (activity != null && !com.tencent.mobileqq.vip.d.i(activity, 4, new g(onClickListener, onClickListener2), "qav")) {
            return null;
        }
        return PopupDialog.o0(context, 230, str, str2, i16, i17, onClickListener, onClickListener2);
    }

    public static void b0(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                if (f175164d == null) {
                    QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    f175164d = qQProgressDialog;
                    qQProgressDialog.setMessage(R.string.hex);
                }
                f175164d.show();
                QQProgressDialog qQProgressDialog2 = f175164d;
                if (qQProgressDialog2 == null || qQProgressDialog2.isShowing()) {
                    return;
                }
            } catch (Exception unused) {
                QQProgressDialog qQProgressDialog3 = f175164d;
                if (qQProgressDialog3 == null || qQProgressDialog3.isShowing()) {
                    return;
                }
            } catch (Throwable th5) {
                QQProgressDialog qQProgressDialog4 = f175164d;
                if (qQProgressDialog4 != null && !qQProgressDialog4.isShowing()) {
                    f175164d = null;
                }
                throw th5;
            }
            f175164d = null;
        }
    }

    public static boolean c0(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, boolean z16, String str3, boolean z17, boolean z18, u uVar, String str4, Map<String, String> map) {
        boolean z19;
        v vVar;
        boolean z26;
        QBaseActivity qBaseActivity;
        if (!((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).isOpenEntrance()) {
            QLog.d("ChatActivityUtils", 1, "startAdelieVideo fail. no open entrance.");
            QQToast.makeText(context, context.getString(R.string.f222146cq), 1).show();
            return false;
        }
        Throwable th5 = QLog.isDevelopLevel() ? new Throwable("\u6253\u5370\u8c03\u7528\u6808") : null;
        v vVar2 = new v();
        vVar2.f175240a = i3;
        vVar2.f175241b = str;
        vVar2.f175242c = str2;
        vVar2.f175244e = z16;
        vVar2.f175245f = str3;
        vVar2.f175246g = z17;
        vVar2.f175247h = z18;
        vVar2.f175248i = str4;
        vVar2.f175249j = map;
        vVar2.f175250k = true;
        vVar2.f175251l = false;
        long b16 = QQAudioHelper.b();
        QLog.w("ChatActivityUtils", 1, "startAdelieVideo, uinType[" + i3 + "], peerUin[" + LogUtil.getSafePrintUin(str) + "], name[" + str2 + "], onlyAudio[" + z16 + "], extraUin[" + LogUtil.getSafePrintUin(str3) + "], checkShieldMsg[" + z17 + "], checkWifi[" + z18 + "], from[" + str4 + "], seq[" + b16 + "], traceid[" + vVar2.f175252m + "]", th5);
        if (!qQAppInterface.isVideoChatting()) {
            if (context instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) context;
                z26 = true;
            } else {
                QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
                z26 = true;
                QLog.w("ChatActivityUtils", 1, "startVideoCheck, Context[" + context + "], seq[" + b16 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
                qBaseActivity = qBaseActivity2;
            }
            vVar = vVar2;
            z19 = z26;
            if (!n(qBaseActivity, z16, new k(qQAppInterface, context, i3, str, str2, z16, str3, z17, z18, uVar, str4, map), QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV, X(vVar.f175249j))) {
                return false;
            }
            if (qQAppInterface.getAVNotifyCenter().e0()) {
                return com.tencent.mobileqq.activity.k.i(b16, qQAppInterface, context, uVar, vVar).booleanValue();
            }
            if (vVar.f175244e && !pu.c.n(context)) {
                return com.tencent.mobileqq.activity.k.e(b16, qQAppInterface, context, uVar, vVar).booleanValue();
            }
            if (!NetworkUtil.isNetSupport(context)) {
                return com.tencent.mobileqq.activity.k.h(b16, qQAppInterface, context, uVar, vVar).booleanValue();
            }
            boolean isWifiConnected = NetworkUtil.isWifiConnected(context);
            if (vVar.f175247h && !isWifiConnected && !NetworkUtil.isBluetoothSharedNetwork(context)) {
                return com.tencent.mobileqq.activity.k.d(b16, qQAppInterface, context, uVar, vVar, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV).booleanValue();
            }
        } else {
            z19 = true;
            vVar = vVar2;
            Boolean c16 = com.tencent.mobileqq.activity.k.c(b16, qQAppInterface, context, uVar, vVar, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV);
            if (c16 != null) {
                return c16.booleanValue();
            }
        }
        if (uVar != null) {
            uVar.b();
        }
        t(qQAppInterface, context, vVar.f175240a, vVar.f175241b, vVar.f175242c, vVar.f175244e, vVar.f175245f, vVar.f175248i, vVar.f175249j, vVar.f175251l);
        if (uVar != null) {
            uVar.a();
        }
        return z19;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bArr3 = new byte[16];
            for (int i3 = 0; i3 < 16; i3++) {
                bArr3[i3] = bArr2[i3];
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, KeyPropertiesCompact.KEY_ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean d0(QQAppInterface qQAppInterface, Context context, int i3, String str, boolean z16, boolean z17, u uVar, Map<String, String> map) {
        return e0(qQAppInterface, context, i3, str, z16, z17, uVar, map, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:58:0x003d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:59:0x0040. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(Activity activity, SessionInfo sessionInfo, String str, boolean z16, boolean z17, String str2) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        BaseActivity baseActivity;
        if (z17) {
            i27 = 3071;
        } else {
            int i28 = sessionInfo.f179555d;
            i3 = 2;
            if (i28 != 1000) {
                if (i28 != 1001) {
                    if (i28 != 1009) {
                        if (i28 != 1010) {
                            if (i28 != 10004) {
                                int i29 = 3076;
                                if (i28 != 10010) {
                                    if (i28 != 10007) {
                                        if (i28 != 10008) {
                                            i26 = 12;
                                            i29 = 3008;
                                            switch (i28) {
                                                case 1004:
                                                    i16 = 3005;
                                                    break;
                                                case 1005:
                                                    i3 = 12;
                                                    i17 = i29;
                                                    break;
                                                case 1006:
                                                    i16 = 3006;
                                                    break;
                                                default:
                                                    switch (i28) {
                                                        case 1021:
                                                            i16 = 3003;
                                                            break;
                                                        case 1022:
                                                            i27 = 3041;
                                                            break;
                                                        case 1023:
                                                            i17 = 3008;
                                                            i3 = 11;
                                                            break;
                                                        case 1024:
                                                            i16 = 3072;
                                                            i26 = 1;
                                                            break;
                                                        default:
                                                            i18 = BuddySource.DEFAULT;
                                                            break;
                                                    }
                                            }
                                        } else {
                                            i16 = 3080;
                                            i26 = 3;
                                        }
                                        i3 = i26;
                                    } else {
                                        i19 = 7;
                                    }
                                } else {
                                    i19 = 6;
                                }
                                i3 = i19;
                                i17 = i29;
                            } else {
                                i16 = 3043;
                            }
                        } else {
                            i17 = 3019;
                            i3 = 0;
                        }
                    } else {
                        i18 = 3013;
                    }
                    i17 = i18;
                    i3 = 0;
                } else {
                    i17 = 3007;
                }
                if (i17 != 3007 && ((activity instanceof SplashActivity) || (activity instanceof ChatActivity))) {
                    BaseActivity baseActivity2 = (BaseActivity) activity;
                    if (!LBSHandler.D2(baseActivity2.getChatFragment().ph(), str2)) {
                        baseActivity2.getChatFragment().qh().w(baseActivity2.getString(R.string.cgk));
                        return;
                    }
                } else if (i17 == 3019 && ((activity instanceof SplashActivity) || (activity instanceof ChatActivity))) {
                    baseActivity = (BaseActivity) activity;
                    if (!com.tencent.mobileqq.dating.f.a(baseActivity.getChatFragment().ph(), str2)) {
                        baseActivity.getChatFragment().qh().w(baseActivity.getString(R.string.cgk));
                        return;
                    }
                }
                if (sessionInfo.f179555d == 1006) {
                    String str3 = sessionInfo.f179557e;
                    if (str3 != null && str3.length() > 0) {
                        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 2, str2, sessionInfo.f179559f, i17, i3, sessionInfo.f179563i, null, null, str, null));
                        return;
                    }
                    return;
                }
                if (z16) {
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 1, str2, sessionInfo.f179559f, i17, i3, sessionInfo.f179563i, null, AddContactsActivity.class.getName(), str, null));
                    return;
                } else {
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(activity, 1, str2, sessionInfo.f179559f, i17, i3, sessionInfo.f179563i, null, null, str, null), 11);
                    return;
                }
            }
            i16 = 3004;
            i17 = i16;
            if (i17 != 3007) {
            }
            if (i17 == 3019) {
                baseActivity = (BaseActivity) activity;
                if (!com.tencent.mobileqq.dating.f.a(baseActivity.getChatFragment().ph(), str2)) {
                }
            }
            if (sessionInfo.f179555d == 1006) {
            }
        }
        i17 = i27;
        i3 = 11;
        if (i17 != 3007) {
        }
        if (i17 == 3019) {
        }
        if (sessionInfo.f179555d == 1006) {
        }
    }

    public static boolean e0(QQAppInterface qQAppInterface, Context context, int i3, String str, boolean z16, boolean z17, u uVar, Map<String, String> map, String str2, String str3) {
        int L;
        boolean z18;
        if (qQAppInterface == null) {
            return false;
        }
        if (map != null && "true".equals(map.get(BaseProfileQZoneComponent.KEY_IS_VIDEO))) {
            L = 4;
        } else {
            L = qQAppInterface.getAVNotifyCenter().L();
        }
        if (L == 4) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (qQAppInterface.getAVNotifyCenter().h(context, i3, str, z18)) {
            return false;
        }
        return g0(qQAppInterface, context, i3, str, z16, z17, uVar, x(map), str2, str3);
    }

    private static String f(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < 16; i3++) {
            int i16 = bArr[i3];
            if (i16 < 0) {
                i16 += 256;
            }
            char[] cArr = f175161a;
            stringBuffer.append(cArr[i16 >>> 4]);
            stringBuffer.append(cArr[i16 % 16]);
        }
        return stringBuffer.toString();
    }

    public static boolean f0(QQAppInterface qQAppInterface, Context context, int i3, String str, boolean z16, boolean z17, u uVar, Bundle bundle) {
        return g0(qQAppInterface, context, i3, str, z16, z17, uVar, bundle, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV);
    }

    private static byte g(char c16) {
        return (byte) "0123456789ABCDEF".indexOf(c16);
    }

    public static boolean g0(QQAppInterface qQAppInterface, Context context, int i3, String str, boolean z16, boolean z17, u uVar, Bundle bundle, String str2, String str3) {
        int i16;
        int i17;
        long j3;
        long j16;
        int i18;
        boolean z18;
        Bundle bundle2 = bundle;
        long b16 = QQAudioHelper.b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startGroupAudioEx, uinType[");
        sb5.append(i3);
        sb5.append("], uin[");
        sb5.append(str);
        sb5.append("], checkWifi[");
        sb5.append(z16);
        sb5.append("], checkMutex[");
        sb5.append(z17);
        sb5.append("], StartVideoListener[");
        sb5.append(uVar != null);
        sb5.append("], extroBundle[");
        sb5.append(bundle2 != null);
        sb5.append("], fromWhere[");
        sb5.append(bundle2 == null ? "null" : bundle2.getString("Fromwhere"));
        sb5.append("], seq[");
        sb5.append(b16);
        sb5.append("]");
        QLog.w("ChatActivityUtils", 1, sb5.toString());
        QLog.d("ChatActivityUtils", 1, "startGroupAudioEx QAV_CALL_START_COST begin: " + System.currentTimeMillis());
        QQAudioHelper.m("ChatActivityUtils.startGroupAudioEx", bundle2, true);
        if (!i(qQAppInterface, context, uVar, i3, str)) {
            return true;
        }
        long longValue = Long.valueOf(str).longValue();
        int uinType2AVRelationType = com.tencent.av.utils.ba.uinType2AVRelationType(i3);
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        Bundle bundle3 = bundle2;
        com.tencent.av.utils.at.g(bundle3, b16);
        boolean z19 = bundle3.getBoolean(BaseProfileQZoneComponent.KEY_IS_VIDEO, false);
        if (!n(A(b16, context), !z19, new a(qQAppInterface, context, i3, str, z17, uVar, bundle3, str2, str3), str2, str3, bundle3.getBoolean("should_believe_only_audio_flag"))) {
            return true;
        }
        int i19 = bundle3.getInt("MultiAVType", 0);
        if (i19 == 10) {
            com.tencent.mobileqq.utils.cp.i("startGroupAudioEx", qQAppInterface, str);
        }
        if (uinType2AVRelationType == 2) {
            i17 = 1;
            i16 = 1;
        } else {
            i16 = i19;
            i17 = 1;
        }
        if (uinType2AVRelationType == i17) {
            j3 = b16;
            qQAppInterface.getAVNotifyCenter().Y0(j3, z19);
        } else {
            j3 = b16;
        }
        if (j(qQAppInterface, context, uinType2AVRelationType, i3, longValue, i16)) {
            return true;
        }
        if (qQAppInterface.getAVNotifyCenter().X(uinType2AVRelationType, longValue, i16)) {
            j16 = longValue;
            i18 = i16;
            z18 = true;
        } else {
            j16 = longValue;
            long j17 = j3;
            i18 = i16;
            if (!o(qQAppInterface, context, uVar, new b(qQAppInterface, context, i3, str, z17, uVar, bundle3, str2, str3), z16, z19)) {
                return true;
            }
            z18 = true;
            if (l(j17, qQAppInterface, context, uVar, new c(qQAppInterface, context, i3, str, z16, uVar, bundle3, str2, str3), z17, str, uinType2AVRelationType, j16, i18)) {
                return true;
            }
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005776", "0X8005776", 0, 0, "", "", "", "");
        if (uVar != null) {
            uVar.b();
        }
        boolean z26 = z18;
        S(qQAppInterface, context, i3, str, bundle3);
        if (uVar != null) {
            uVar.a();
        }
        qQAppInterface.getAVNotifyCenter().B0(7, j16, i18);
        return z26;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e8 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(Activity activity, QQPermission qQPermission, DialogInterface.OnClickListener onClickListener, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        ArrayList arrayList;
        if (AppSetting.m() >= 31 && Build.VERSION.SDK_INT >= 31) {
            if (activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z16) {
                z27 = com.tencent.av.utils.ai.g(activity);
                z26 = com.tencent.av.utils.ai.i(activity);
                arrayList = new ArrayList();
                if (!z17) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_SCAN);
                }
                if (!z18) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_CONNECT);
                }
                if (!z19) {
                    arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("ChatActivityUtils", 1, "checkBluetoothPermission checkScanResult=" + z17 + " checkConnectResult=" + z18 + " checkAdvertiseResult=" + z19 + " size=" + arrayList.size() + " request=" + z16 + " hasRequestBluetooth=" + z26 + " hasBluetoothDevice=" + z27, new Throwable());
                }
                if (!z16 && arrayList.size() > 0 && qQPermission != null && !z26 && z27) {
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    com.tencent.av.utils.ai.k(activity);
                    qQPermission.requestPermissions(strArr, 2, new i(onClickListener));
                    return false;
                }
                if (z16 && onClickListener != null) {
                    onClickListener.onClick(null, 1);
                }
                if (arrayList.size() > 0) {
                    return true;
                }
                return false;
            }
            z26 = true;
        } else {
            z17 = true;
            z18 = true;
            z19 = true;
            z26 = true;
        }
        z27 = false;
        arrayList = new ArrayList();
        if (!z17) {
        }
        if (!z18) {
        }
        if (!z19) {
        }
        if (QLog.isDevelopLevel()) {
        }
        if (!z16) {
        }
        if (z16) {
            onClickListener.onClick(null, 1);
        }
        if (arrayList.size() > 0) {
        }
    }

    public static boolean h0(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, String str3, boolean z16, String str4, boolean z17, boolean z18, u uVar, String str5) {
        return i0(qQAppInterface, context, i3, str, str2, str3, z16, str4, z17, z18, uVar, str5, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV);
    }

    static boolean i(QQAppInterface qQAppInterface, Context context, u uVar, int i3, String str) {
        Context context2 = context;
        if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
            QLog.d("ChatActivityUtils", 1, "startGroupAudio, Activity isDestroyed!");
            return false;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.d("ChatActivityUtils", 1, "startGroupAudio, \u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528");
            QQToast.makeText(context2, R.string.cgc, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
            return false;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
        if (!AVCoreSystemInfo.isSupportSharpAudio()) {
            QQToast.makeText(context2, R.string.db8, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005769", "0X8005769", 0, 0, "", "", "", "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800576B", "0X800576B", 0, 0, "", "", AVCoreSystemInfo.getCpuReport(), "");
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800576C", "0X800576C", 0, 0, "", "", AVCoreSystemInfo.getModelReport(), "");
            return false;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800576A", "0X800576A", 0, 0, "", "", "", "");
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800576E", "0X800576E", 0, 0, "", "", "", "");
        if (qQAppInterface.getAVNotifyCenter().e0() && !qQAppInterface.isVideoChatting()) {
            QLog.d("ChatActivityUtils", 1, "startGroupAudio, \u6709\u7cfb\u7edf\u7535\u8bdd");
            DataReport.Y(true, true);
            String string = context2.getString(R.string.dg9);
            String string2 = context2.getString(R.string.dfp);
            if (!(context2 instanceof Activity)) {
                context2 = BaseActivity.sTopActivity;
            }
            DialogUtil.createCustomDialog(context2, 230, string2, string, R.string.cancel, R.string.f171151ok, new n(uVar), (DialogInterface.OnClickListener) null).show();
            DataReport.k();
            return false;
        }
        if (!AVCoreSystemInfo.isNormalSharp()) {
            QLog.d("ChatActivityUtils", 1, "startGroupAudio, old engine");
            if (i3 == 1011) {
                DialogUtil.createCustomDialog(context, 230, context2.getString(R.string.dfp), context2.getString(R.string.dkn), R.string.cancel, R.string.ddx, new o(uVar), (DialogInterface.OnClickListener) null).show();
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
                return false;
            }
        }
        if (DiscussionInfo.isValidDisUin(str) || i3 != 3000) {
            return true;
        }
        QLog.d("ChatActivityUtils", 1, "startGroupAudio, invalid discussId: " + str);
        return false;
    }

    public static boolean i0(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, String str3, boolean z16, String str4, boolean z17, boolean z18, u uVar, String str5, String str6, String str7) {
        return k0(qQAppInterface, context, i3, str, str2, str3, z16, str4, z17, z18, uVar, str5, null, str6, str7);
    }

    static boolean j(QQAppInterface qQAppInterface, Context context, int i3, int i16, long j3, int i17) {
        if (i3 == 1 && qQAppInterface.getAVNotifyCenter().W(i3, j3) && qQAppInterface.getAVNotifyCenter().b0() && i16 == 1) {
            long b16 = QQAudioHelper.b();
            if (QLog.isColorLevel()) {
                QLog.w("ChatActivityUtils", 1, "checkGroupInAnotherChating, seq[" + b16 + "]");
            }
            int l3 = qQAppInterface.getAVNotifyCenter().l(qQAppInterface.getAVNotifyCenter().n());
            if (l3 != i17) {
                if (l3 == 10 && i17 == 2) {
                    if (qQAppInterface.getAVNotifyCenter().j0()) {
                        QQToast.makeText(context, R.string.dbi, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    } else {
                        QQToast.makeText(context, R.string.dbk, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                    return true;
                }
                if (l3 == 2 && i17 == 10) {
                    if (qQAppInterface.getAVNotifyCenter().j0()) {
                        QQToast.makeText(context, R.string.dbl, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    } else {
                        QQToast.makeText(context, R.string.dbh, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                    return true;
                }
            }
            if (i17 == 2) {
                Intent intent = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
                com.tencent.av.utils.at.f(intent, b16);
                context.sendBroadcast(intent);
            } else {
                context.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            }
        }
        return false;
    }

    public static boolean j0(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, String str3, boolean z16, String str4, boolean z17, boolean z18, u uVar, String str5, Map<String, String> map) {
        return k0(qQAppInterface, context, i3, str, str2, str3, z16, str4, z17, z18, uVar, str5, map, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV);
    }

    public static boolean k(QQAppInterface qQAppInterface, String str) {
        return com.tencent.qqnt.contact.friends.b.f355778a.c(str, "ChatActivityUtils");
    }

    public static boolean k0(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, String str3, boolean z16, String str4, boolean z17, boolean z18, u uVar, String str5, Map<String, String> map, String str6, String str7) {
        Map<String, String> map2 = map;
        Throwable th5 = QLog.isDevelopLevel() ? new Throwable("\u6253\u5370\u8c03\u7528\u6808") : null;
        v vVar = new v();
        vVar.f175240a = i3;
        vVar.f175241b = str;
        vVar.f175242c = str2;
        vVar.f175243d = str3;
        vVar.f175244e = z16;
        vVar.f175245f = str4;
        vVar.f175246g = z17;
        vVar.f175247h = z18;
        vVar.f175248i = str5;
        vVar.f175249j = map2;
        vVar.f175250k = true;
        vVar.f175251l = false;
        if (i3 == 0 || i3 == 1024 || i3 == 1011) {
            if (map2 == null) {
                map2 = new HashMap<>();
                vVar.f175249j = map2;
            }
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            String e16 = VideoUtil.e(currentAccountUin, "start_dav_talk");
            vVar.f175252m = e16;
            vVar.f175249j.put("trace_id", e16);
            RtcNodeReportMainProcessTask rtcNodeReportMainProcessTask = new RtcNodeReportMainProcessTask(currentAccountUin, str, vVar.f175252m, "from_internal".equalsIgnoreCase(str5) ? "4" : com.tencent.avcore.rtc.node.report.utils.c.f(map2));
            rtcNodeReportMainProcessTask.b(z16);
            rtcNodeReportMainProcessTask.f(vVar.f175240a);
            ThreadManagerV2.executeDelay(rtcNodeReportMainProcessTask, 128, null, true, 3000L);
        }
        long b16 = QQAudioHelper.b();
        QLog.w("ChatActivityUtils", 1, "startVideo, uinType[" + i3 + "], peerUin[" + LogUtil.getSafePrintUin(str) + "], name[" + str2 + "], phoneNum[" + str3 + "], onlyAudio[" + z16 + "], extraUin[" + LogUtil.getSafePrintUin(str4) + "], checkShieldMsg[" + z17 + "], checkWifi[" + z18 + "], from[" + str5 + "], seq[" + b16 + "], traceid[" + vVar.f175252m + "]", th5);
        return l0(b16, qQAppInterface, context, uVar, vVar, str6, str7);
    }

    static boolean l(long j3, QQAppInterface qQAppInterface, Context context, u uVar, DialogInterface.OnClickListener onClickListener, boolean z16, String str, int i3, long j16, int i16) {
        if (z16 && qQAppInterface.isVideoChatting()) {
            int J = qQAppInterface.getAVNotifyCenter().J();
            int H = qQAppInterface.getAVNotifyCenter().H();
            int L = qQAppInterface.getAVNotifyCenter().L();
            if (((H == 1 || H == 2) && J >= 1 && J <= 5) || L == 1 || L == 2) {
                QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                QAVHrMeeting.i(qQAppInterface, Long.valueOf(str).longValue(), null);
                return true;
            }
            if (((H != 3 && H != 4) || J < 1 || J > 5) && L != 3 && L != 4) {
                return false;
            }
            long n3 = qQAppInterface.getAVNotifyCenter().n();
            if (n3 == j16 && i3 != 1 && i3 != 2) {
                if (QLog.isColorLevel()) {
                    QLog.e("ChatActivityUtils", 2, "startGroupAudio-->chatUin==discussid???Why");
                }
                return true;
            }
            long n16 = qQAppInterface.getAVNotifyCenter().n();
            if (n16 <= 0) {
                return false;
            }
            QLog.w("ChatActivityUtils", 1, "checkMutex, chatingRelationId[" + n16 + "], chatUin[" + n3 + "], discussId[" + j16 + "], seq[" + j3 + "]");
            if (n3 == j16 && (i3 == 2 || i3 == 1)) {
                return false;
            }
            String string = context.getString(R.string.dbj);
            int a16 = com.tencent.av.utils.az.a(qQAppInterface, qQAppInterface.getCurrentAccountUin(), str + "");
            PopupDialog.o0(context, 230, null, string, R.string.d_2, R.string.d_d, new q(j3, qQAppInterface, context, i3, i16, onClickListener, str, a16), new r(uVar, str, a16, qQAppInterface));
            ReportController.o(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, str + "", a16 + "", "", "");
            return true;
        }
        if (!z16 || !qQAppInterface.getAVNotifyCenter().a0()) {
            return false;
        }
        QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r15v3 */
    public static boolean l0(long j3, QQAppInterface qQAppInterface, Context context, u uVar, v vVar, String str, String str2) {
        boolean z16;
        String str3;
        ?? r152;
        boolean z17;
        QBaseActivity qBaseActivity;
        int i3;
        Boolean g16;
        Boolean j16;
        if (QQAudioHelper.c(13) == 1) {
            QLog.d("ChatActivityUtils", 1, "\u97f3\u89c6\u9891\u8fdb\u7a0b\u5728\u7b49\u5f85\u8c03\u8bd5\u5668\u8fde\u63a5(\u754c\u9762\u4f1a\u65e0\u54cd\u5e94)");
        }
        if (!qQAppInterface.isVideoChatting()) {
            if (context instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) context;
            } else {
                qBaseActivity = QBaseActivity.sTopActivity;
                QLog.w("ChatActivityUtils", 1, "startVideoCheck, Context[" + context + "], seq[" + j3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            }
            QBaseActivity qBaseActivity2 = qBaseActivity;
            boolean z18 = vVar.f175244e;
            Map<String, String> map = vVar.f175249j;
            if (map != null) {
                if (z18 && !"2".equals(map.get("inviteScene"))) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            }
            if (n(qBaseActivity2, z18, new j(j3, qQAppInterface, context, uVar, vVar, str, str2), str, str2, X(vVar.f175249j))) {
                str3 = "ChatActivityUtils";
                r152 = 1;
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005757", "0X8005757", 0, 0, "", "", "", "");
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X800575B", "0X800575B", 0, 0, "", "", "", "");
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X800575F", "0X800575F", 0, 0, "", "", "", "");
                if (qQAppInterface.getAVNotifyCenter().e0()) {
                    return com.tencent.mobileqq.activity.k.i(j3, qQAppInterface, context, uVar, vVar).booleanValue();
                }
                if (((vVar.f175240a == 1006 && !k(qQAppInterface, vVar.f175241b)) || (i3 = vVar.f175240a) == 1024 || i3 == 1011) && (j16 = com.tencent.mobileqq.activity.k.j(j3, qQAppInterface, context, uVar, vVar)) != null) {
                    return j16.booleanValue();
                }
                if (vVar.f175244e && !pu.c.n(context)) {
                    return com.tencent.mobileqq.activity.k.e(j3, qQAppInterface, context, uVar, vVar).booleanValue();
                }
                if (vVar.f175240a == 1010 && (g16 = com.tencent.mobileqq.activity.k.g(j3, qQAppInterface, context, uVar, vVar, str, str2)) != null) {
                    return g16.booleanValue();
                }
                if (vVar.f175240a == 1044 && ((com.tencent.mobileqq.qqexpand.manager.d) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).b(qBaseActivity2)) {
                    return false;
                }
                z16 = false;
                if (vVar.f175246g && L(qQAppInterface, vVar.f175240a, vVar.f175241b, vVar.f175243d) && vVar.f175240a != 1024) {
                    return com.tencent.mobileqq.activity.k.f(j3, qQAppInterface, context, uVar, vVar, str, str2).booleanValue();
                }
                if (!NetworkUtil.isNetSupport(context)) {
                    return com.tencent.mobileqq.activity.k.h(j3, qQAppInterface, context, uVar, vVar).booleanValue();
                }
                boolean isWifiConnected = NetworkUtil.isWifiConnected(context);
                if (vVar.f175240a == 1024 && !isWifiConnected && NetworkUtil.getSystemNetwork(context) == 2) {
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
                    QQToast.makeText(context, R.string.d_f, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    ReportController.o(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
                    return false;
                }
                if (vVar.f175247h && !isWifiConnected && !NetworkUtil.isBluetoothSharedNetwork(context)) {
                    return com.tencent.mobileqq.activity.k.k(j3, qQAppInterface, context, uVar, vVar, str, str2).booleanValue();
                }
                if (qQAppInterface.getAVNotifyCenter().a0()) {
                    QQToast.makeText(context, R.string.dkm, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    return false;
                }
            } else {
                return false;
            }
        } else {
            z16 = false;
            str3 = "ChatActivityUtils";
            r152 = 1;
            Boolean l3 = com.tencent.mobileqq.activity.k.l(j3, qQAppInterface, context, uVar, vVar, str, str2);
            if (l3 != null) {
                return l3.booleanValue();
            }
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(vVar.f175241b);
        if (((TextUtils.isEmpty(uidFromUin) ? 1 : 0) ^ r152) != 0) {
            z17 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, str3);
        } else {
            QLog.e(str3, (int) r152, "launch video call error with uin:=" + vVar.f175241b);
            z17 = r152;
        }
        if (vVar.f175240a == 0 && !z17) {
            if (QQAudioHelper.c(16) == r152) {
                QQAudioHelper.w(HardCodeUtil.qqStr(R.string.kc6));
            } else {
                PopupDialog.o0(context, 230, context.getString(R.string.dfp), mu.a.a(!z17, z16, z16, context, vVar.f175244e), R.string.cancel, R.string.dcl, new l(), null);
                return z16;
            }
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005766", "0X8005766", 0, 0, "", "", "", "");
        if (uVar != null) {
            uVar.b();
        }
        w(qQAppInterface, context, vVar.f175240a, vVar.f175241b, vVar.f175242c, vVar.f175243d, vVar.f175244e, vVar.f175245f, vVar.f175248i, vVar.f175249j, vVar.f175251l);
        if (uVar != null) {
            uVar.a();
        }
        return r152;
    }

    public static boolean m(Activity activity, boolean z16, DialogInterface.OnClickListener onClickListener) {
        return n(activity, z16, onClickListener, QQPermissionConstants.Business.ID.QQ_QAV, QQPermissionConstants.Business.SCENE.QQ_QAV, true);
    }

    public static void m0(Context context, int i3, int i16) {
        QQToast.makeText(context, i3, i16).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public static boolean n(Activity activity, boolean z16, DialogInterface.OnClickListener onClickListener, String str, String str2, boolean z17) {
        boolean z18;
        boolean z19;
        if (activity == null) {
            return false;
        }
        boolean isFinishing = activity.isFinishing();
        if (activity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (activity.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        boolean g16 = com.tencent.av.r.g1(activity);
        if (QLog.isDevelopLevel() || !z18 || !z19 || g16) {
            QLog.w("ChatActivityUtils", 1, "checkQAVPermission, Camera[" + z18 + "], audio[" + z19 + "], onlyAudio[" + z16 + "], isScreenLocked[" + g16 + "], isFinishing[" + isFinishing + "], shouldBelieveOnlyAudioFlag[" + z17 + "]");
        }
        if (z16) {
            z18 = true;
        }
        boolean h16 = h(activity, null, null, false);
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(str, str2));
        boolean i3 = com.tencent.av.utils.ai.i(activity);
        if (z18 && z19) {
            if (!h16 && !i3 && !com.tencent.av.utils.ai.h()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("ChatActivityUtils", 4, "[checkQAVPermission] only request bluetooth permission.");
                }
                com.tencent.av.utils.ai.l(true);
                h(activity, qQPermission, onClickListener, true);
                return false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("ChatActivityUtils", 4, "[checkQAVPermission] checkBluetooth=" + h16 + " hasRequestBluetoothPermission=" + i3 + "hasCheckBluetooth=" + com.tencent.av.utils.ai.h() + " . skip...");
            }
            com.tencent.av.utils.ai.l(false);
            return true;
        }
        h hVar = new h(activity, qQPermission, onClickListener);
        if (qQPermission == null) {
            return false;
        }
        if (z16 && z17) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, hVar);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO}, 2, hVar);
        }
        return false;
    }

    static boolean o(QQAppInterface qQAppInterface, Context context, u uVar, DialogInterface.OnClickListener onClickListener, boolean z16, boolean z17) {
        String str;
        String str2;
        String str3;
        String str4;
        String string;
        if (z16 && !NetworkUtil.isWifiConnected(BaseApplication.getContext()) && !NetworkUtil.isBluetoothSharedNetwork(BaseApplication.getContext())) {
            if (com.tencent.av.r.C0(com.tencent.av.r.f74233b + qQAppInterface.getCurrentAccountUin()) <= 0) {
                if (NetworkUtil.isMobileNetWork(BaseApplication.getContext())) {
                    str = context.getString(R.string.dfp);
                    str2 = context.getString(R.string.dfl);
                } else {
                    str = null;
                    str2 = null;
                }
                if (NetworkUtil.is3Gor4G(BaseApplication.getContext())) {
                    String string2 = context.getString(R.string.dfp);
                    if (z17) {
                        string = context.getString(R.string.dfm);
                    } else {
                        string = context.getString(R.string.dfn);
                    }
                    str4 = string2;
                    str3 = string;
                } else {
                    str3 = str2;
                    str4 = str;
                }
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                    a0(qQAppInterface, context, 230, str4, str3, R.string.d_2, R.string.d_d, onClickListener, new p(uVar));
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("ChatActivityUtils", 2, "startGAudio title or content is empty");
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public static final String p(Activity activity) {
        return activity.getClass().getName() + "_" + activity.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(QQAppInterface qQAppInterface, Context context, int i3, String str, Bundle bundle) {
        String str2;
        String str3;
        int i16;
        boolean z16;
        int i17;
        Context context2;
        String str4;
        AVNotifyCenter.i Q;
        Bundle bundle2 = bundle;
        QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, uinType[" + i3 + "], uin[" + str + "], seq[" + com.tencent.av.utils.at.b(bundle) + "]");
        QQAudioHelper.m("ChatActivityUtils", bundle2, true);
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (str == null) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(262144);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        long parseLong = Long.parseLong(str);
        int uinType2AVRelationType = com.tencent.av.utils.ba.uinType2AVRelationType(i3);
        int i18 = bundle2.getInt("MultiAVType", 0);
        String string = bundle2.getString("Fromwhere");
        if (uinType2AVRelationType == 2) {
            i18 = 1;
        }
        String string2 = bundle2.getString("jump_from");
        intent.putExtras(bundle2);
        if (("gvideo".equals(string2) || "gvideo_h5".equals(string2)) && i3 == 1) {
            str2 = "]";
            str3 = "MultiAVType";
            i16 = 1;
            z16 = true;
        } else {
            str3 = "MultiAVType";
            long y16 = qQAppInterface.getAVNotifyCenter().y(uinType2AVRelationType, parseLong);
            StringBuilder sb5 = new StringBuilder();
            str2 = "]";
            sb5.append("memberNum[");
            sb5.append(y16);
            String sb6 = sb5.toString();
            if (y16 > 0) {
                int l3 = qQAppInterface.getAVNotifyCenter().l(parseLong);
                String str5 = sb6 + "], srcAVType[" + l3;
                if (i18 != l3 && i3 == 1) {
                    AVNotifyCenter.i Q2 = qQAppInterface.getAVNotifyCenter().Q(parseLong, i18);
                    String str6 = str5 + "], VideoRoomInfo[" + Q2;
                    if (Q2 != null && Q2.f73810d == i18 && Q2.f73809c > 0) {
                        str4 = str6 + "], 1.TYPE_GAUDIO_STATUS_ENTER";
                    } else {
                        str4 = str6 + "], 2.TYPE_GAUDIO_STATUS_CREATE";
                        i16 = 0;
                    }
                } else if (qQAppInterface.getAVNotifyCenter().W(uinType2AVRelationType, parseLong)) {
                    str4 = str5 + "], 3.TYPE_GAUDIO_STATUS_CHATING";
                    i16 = 2;
                } else {
                    str4 = str5 + "], 4.TYPE_GAUDIO_STATUS_ENTER";
                }
                i16 = 1;
            } else {
                str4 = sb6 + "], 5.TYPE_GAUDIO_STATUS_CREATE";
                if (i18 == 2 && (Q = qQAppInterface.getAVNotifyCenter().Q(parseLong, 2)) != null && Q.f73809c > 0) {
                    str4 = str4 + "], 6.TYPE_GAUDIO_STATUS_CREATE";
                    i16 = 1;
                }
                i16 = 0;
            }
            z16 = true;
            QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, " + str4);
        }
        if (i3 == z16) {
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null && troopManager.k(str) == null) {
                z16 = false;
            }
            intent.putExtra("troopmember", z16);
        }
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        intent.putExtra("uin", str);
        intent.putExtra("uinType", i3);
        intent.putExtra("Type", i16);
        intent.putExtra("GroupId", str);
        intent.putExtra(str3, i18);
        intent.putExtra("Fromwhere", string);
        if (QLog.isColorLevel()) {
            i17 = 2;
            QLog.i("ChatActivityUtils", 2, "createOrEnterGroupAudio, from[" + string + str2);
        } else {
            i17 = 2;
        }
        if (i18 != i17) {
            context2 = context;
            intent.setClass(context2, AVActivity.class);
        } else {
            context2 = context;
        }
        com.tencent.av.utils.t.a(context2, str, i18, new AnonymousClass15(i16, i3, qQAppInterface, (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE), parseLong, intent, parseLong, AppConstants.Key.START_GROUP_AUDIO_TIME + qQAppInterface.getCurrentAccountUin()));
    }

    public static boolean r(Context context, String str, int i3, String str2) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str2, "");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ChatActivityUtils", 4, "single friend list: " + string + " curType:" + i3 + " uin:" + str);
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            JSONArray jSONArray2 = new JSONArray();
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                if (jSONObject.has("type") && jSONObject.has("uin")) {
                    int i17 = jSONObject.getInt("type");
                    String string2 = jSONObject.getString("uin");
                    if (i17 != i3 || !string2.equals(com.tencent.imcore.message.an.a(str))) {
                        jSONArray2.mo162put(jSONObject);
                    }
                }
            }
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString(str2, jSONArray2.toString());
            return edit.commit();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void s(QQAppInterface qQAppInterface, Activity activity, int i3, String str, String str2, boolean z16, boolean z17) {
        long j3;
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (i3 == 0) {
                FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                if (friendListHandler != null) {
                    try {
                        j3 = Long.parseLong(str);
                    } catch (Exception unused) {
                        j3 = 0;
                    }
                    if (j3 > 0) {
                        friendListHandler.changeFriendShieldFlag(j3, !z16);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 != 25) {
                ShieldMsgManger shieldMsgManger = (ShieldMsgManger) qQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
                boolean z18 = false;
                if (shieldMsgManger != null) {
                    if (i3 == 1006 && str == null) {
                        try {
                            str = com.tencent.mobileqq.utils.ac.m0(qQAppInterface, str2);
                        } catch (NumberFormatException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("ChatActivityUtils", 2, "shieldMsg", e16);
                            }
                        }
                    }
                    long parseLong = Long.parseLong(str);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(parseLong));
                    if (z16) {
                        shieldMsgManger.m(i3, arrayList);
                    } else {
                        if (z17) {
                            if (f175163c.size() > 5) {
                                f175163c.poll();
                            }
                            f175163c.offer(str);
                        }
                        shieldMsgManger.k(i3, arrayList);
                    }
                    z18 = true;
                }
                if (i3 == 1001 || i3 == 10002) {
                    if (str != null && str.length() > 0) {
                        if (z16) {
                            qQAppInterface.getMsgHandler().S2(str);
                        } else {
                            qQAppInterface.getMsgHandler().o4(str);
                        }
                    }
                    z18 = true;
                }
                if (activity != null && !activity.isFinishing()) {
                    if (z18) {
                        b0(activity);
                        return;
                    } else if (z16) {
                        Q(activity, R.string.hju, 1);
                        return;
                    } else {
                        Q(activity, R.string.hjw, 1);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (activity != null && !activity.isFinishing()) {
            Q(activity, R.string.cgc, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void t(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, boolean z16, String str3, String str4, Map<String, String> map, boolean z17) {
        QLog.d("ChatActivityUtils", 1, "enterAdelieVideo QAV_CALL_START_COST begin: " + System.currentTimeMillis());
        int start = HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{0}, 3000, 101, 4L, Process.myTid(), "bootVideo", true);
        QLog.w("ChatActivityUtils", 1, "avideo enterAdelieVideo called, uinType[" + i3 + "], peerUin[" + str + "], name[" + str2 + "], onlyAudio[" + z16 + "], extraUin[" + str3 + "], from[" + str4 + "]");
        if (qQAppInterface.isVideoChatting() && qQAppInterface.getAVNotifyCenter().P() != 1 && qQAppInterface.getAVNotifyCenter().P() != 3000 && qQAppInterface.getAVNotifyCenter().f0() && qQAppInterface.getAVNotifyCenter().k0() && qQAppInterface.getAVNotifyCenter().P() != 1011 && qQAppInterface.getAVNotifyCenter().P() != 21) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("uinType", i3);
            intent.putExtra("peerUin", str);
            intent.putExtra("extraUin", str3);
            intent.putExtra("isAudioMode", z16);
            if (map != null) {
                intent.putExtra("from", map.get("from"));
            }
            ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).startActivity(context, intent);
            return;
        }
        if (context == null) {
            QLog.e("ChatActivityUtils", 1, "enterVideo fail, context is null");
            return;
        }
        Intent intent2 = new Intent();
        intent2.addFlags(262144);
        intent2.addFlags(268435456);
        intent2.putExtra("uinType", i3);
        intent2.putExtra("uin", str);
        intent2.putExtra("name", str2);
        intent2.putExtra("receive", false);
        intent2.putExtra("isAudioMode", z16);
        intent2.putExtra("extraUin", str3);
        intent2.putExtra("senderStartTime", SystemClock.elapsedRealtime());
        intent2.putExtra("isSender", true);
        intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, z16 ? 3 : 4);
        intent2.putExtra("hc_code", start);
        intent2.putExtra("main_timestamp", System.currentTimeMillis());
        if (qQAppInterface.getAVNotifyCenter().d0(str)) {
            intent2.putExtra("isAudioMode", qQAppInterface.getAVNotifyCenter().C(str) == 1);
            intent2.putExtra("startfromVideoEntry", !z16);
            intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, qQAppInterface.getAVNotifyCenter().C(str));
        }
        if (map != null) {
            intent2.putExtra("from", map.get("from"));
        }
        intent2.putExtra("Fromwhere", str4);
        intent2.putExtra("isOtherTerminalOnChating", qQAppInterface.getAVNotifyCenter().d0(str));
        intent2.putExtra("otherTerminalChatingRoomId", qQAppInterface.getAVNotifyCenter().D(str));
        intent2.putExtra("triggerBeauty", z17);
        intent2.putExtra("isMakingAcall", true);
        ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).startActivity(context, intent2);
        if (z17 && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(R.anim.f154822cw, R.anim.f154823cx);
        }
        if (qQAppInterface.isVideoChatting() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(R.anim.f154832d9, 0);
        }
    }

    public static void u(QQAppInterface qQAppInterface, Activity activity, SessionInfo sessionInfo, int i3, Intent intent, int i16) {
        v(qQAppInterface, activity, sessionInfo, i3, intent, i16, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0201  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void v(QQAppInterface qQAppInterface, Activity activity, SessionInfo sessionInfo, int i3, Intent intent, int i16, boolean z16) {
        String str;
        boolean z17;
        int i17;
        boolean z18;
        int i18;
        int i19;
        Uri uri;
        if (i3 == 1) {
            String string = PreferenceManager.getDefaultSharedPreferences(activity).getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, "");
            if (!string.equalsIgnoreCase("")) {
                if (i16 == 1) {
                    BaseApplication.getContext().getSharedPreferences(PeakConstants.PRESEND_CONFIG_SP, 4).edit().putString(PeakConstants.SHOT_PHOTO_PATH, string).commit();
                }
                uri = Uri.fromFile(new File(string));
            } else {
                uri = null;
            }
            PreferenceManager.getDefaultSharedPreferences(activity).edit().remove(AppConstants.Preferences.CAMERA_PHOTO_PATH).commit();
            if (uri == null) {
                return;
            }
            str = BaseImageUtil.getRealPathFromContentURI(activity, uri);
            if (str != null) {
                BaseImageUtil.savePhotoToSysAlbum(activity, str);
                if (!new File(str).exists()) {
                    QLog.i("ChatActivityUtils", 1, "[enterPhotoPreview] file not exists, path=" + str);
                    QQToast.makeText(activity, activity.getString(R.string.cwd), 0).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    return;
                }
                if (!FileUtils.isPicFile(str)) {
                    QLog.i("ChatActivityUtils", 1, "[enterPhotoPreview] not pic file, path=" + str);
                    QQToast.makeText(activity, activity.getString(R.string.b89), 0).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    return;
                }
            } else {
                QLog.i("ChatActivityUtils", 1, "[enterPhotoPreview] file path is null");
                QQToast.makeText(activity, activity.getString(R.string.cwd), 0).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
        } else {
            str = null;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_PREVIEW_ACTIVITY_URI);
        if (qQAppInterface != null) {
            String account = qQAppInterface.getAccount();
            activityURIRequest.extra().putString(PeakConstants.MY_UIN, account);
            String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(account), "ChatActivityUtils");
            if (nickWithUid != null) {
                activityURIRequest.extra().putString(PeakConstants.MY_NICK, nickWithUid);
            }
            if (((com.tencent.mobileqq.app.ay) qQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)) != null) {
                activityURIRequest.extra().putBoolean("showFlashPic", ((IPicFlash) QRoute.api(IPicFlash.class)).showFlashPicOption(sessionInfo.f179555d, sessionInfo.f179559f));
            }
        }
        activityURIRequest.extra().putString("uin", sessionInfo.f179557e);
        activityURIRequest.extra().putInt("uintype", sessionInfo.f179555d);
        activityURIRequest.extra().putString("troop_uin", sessionInfo.f179559f);
        activityURIRequest.extra().putString("uinname", sessionInfo.f179563i);
        activityURIRequest.extra().putInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, sessionInfo.P);
        activityURIRequest.extra().putInt(ConfessInfo.KEY_CONFESS_TOPICID, sessionInfo.S);
        activityURIRequest.extra().putBoolean("is_anonymous", com.tencent.biz.anonymous.a.h().d(sessionInfo.f179557e));
        if (intent != null) {
            int intExtra = intent.getIntExtra("camera_type", 1);
            activityURIRequest.extra().putInt("camera_type", intExtra);
            if (intExtra == 103) {
                i17 = 10012;
                z17 = true;
                if (SplashActivity.class.isInstance(activity) && !ChatActivity.class.isInstance(activity)) {
                    activityURIRequest.extra().putAll(activity.getIntent().getExtras());
                    i18 = i17;
                } else {
                    z18 = activity instanceof SplashActivity;
                    if (!z18) {
                        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
                        activityURIRequest = BaseAIOUtils.n(activityURIRequest, null);
                    } else if (activity instanceof ChatActivity) {
                        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
                    }
                    activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                    i18 = i17;
                    if (sessionInfo.f179555d != 9501) {
                        if (z18) {
                            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SplashActivity.getAliasName());
                            activityURIRequest = BaseAIOUtils.n(activityURIRequest, null);
                        } else {
                            activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, ChatActivity.class.getName());
                        }
                        activityURIRequest.extra().putInt(com.tencent.mobileqq.utils.d.f307603i, 82);
                        activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
                        activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, false);
                    } else {
                        activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
                        activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
                        activityURIRequest.extra().putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
                    }
                }
                activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 52);
                activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationFastImage.I);
                if (i16 != -1 && !com.tencent.mobileqq.filemanager.fileassistant.util.h.k(sessionInfo.f179557e)) {
                    if (i16 != 8) {
                        if (qQAppInterface != null) {
                            PlusPanelUtils.z(activityURIRequest, sessionInfo, qQAppInterface);
                        }
                        activityURIRequest.extra().putBoolean("callFromFastImage", true);
                        activityURIRequest.extra().putString("FROM_WHERE", "FromFastImage");
                        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1037);
                        activityURIRequest.extra().putString("key_activity_code", p(activity));
                    } else if (i16 == 1) {
                        if (qQAppInterface != null) {
                            PlusPanelUtils.z(activityURIRequest, sessionInfo, qQAppInterface);
                        }
                        activityURIRequest.extra().putString("FROM_WHERE", "FromCamera");
                        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1008);
                    }
                }
                if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.k(sessionInfo.f179557e)) {
                    activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 51);
                    activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationFileAssistant.F);
                    activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationFileAssistant.G);
                    i19 = 2;
                    activityURIRequest.extra().putInt(com.tencent.mobileqq.utils.d.f307603i, 2);
                    z17 = true;
                } else {
                    i19 = i18;
                }
                if (intent != null) {
                    boolean booleanExtra = intent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
                    int intExtra2 = intent.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, -1);
                    activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", booleanExtra);
                    if (intExtra2 == 1039) {
                        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1039);
                    }
                    if (intExtra2 == 1040) {
                        activityURIRequest.extra().putInt(PeakConstants.SEND_BUSINESS_TYPE, 1040);
                    }
                    PhotoUtils.copyReportInfo(intent, activityURIRequest);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
                activityURIRequest.extra().putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
                activityURIRequest.extra().putBoolean(PeakConstants.ALLOW_LOCK, z16);
                activityURIRequest.setFlags(603979776);
                if (z17) {
                    activityURIRequest.setRequestCode(i19);
                }
                if ((activity instanceof Activity) && i16 == 8) {
                    activityURIRequest.setOverridePendingTransition(R.anim.f154556na, R.anim.n_);
                }
                QRoute.startUri(activityURIRequest);
            }
        }
        z17 = false;
        i17 = -1;
        if (SplashActivity.class.isInstance(activity)) {
        }
        z18 = activity instanceof SplashActivity;
        if (!z18) {
        }
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        i18 = i17;
        if (sessionInfo.f179555d != 9501) {
        }
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 52);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationFastImage.I);
        if (i16 != -1) {
            if (i16 != 8) {
            }
        }
        if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.k(sessionInfo.f179557e)) {
        }
        if (intent != null) {
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(str);
        activityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList2);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
        activityURIRequest.extra().putBoolean(PeakConstants.ALLOW_LOCK, z16);
        activityURIRequest.setFlags(603979776);
        if (z17) {
        }
        if (activity instanceof Activity) {
            activityURIRequest.setOverridePendingTransition(R.anim.f154556na, R.anim.n_);
        }
        QRoute.startUri(activityURIRequest);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0708  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x075a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x02f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0384  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void w(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, String str3, boolean z16, String str4, String str5, Map<String, String> map, boolean z17) {
        String str6;
        String str7;
        String str8;
        Class cls;
        boolean z18;
        RespondQueryQQBindingStat selfBindInfo;
        String str9;
        String str10;
        String str11;
        String str12;
        Map<String, String> map2;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        byte[] bArr;
        boolean z19;
        String string;
        int i16;
        int i17;
        String str18;
        int i18;
        byte[] bArr2;
        int i19;
        int i26;
        boolean z26;
        int i27;
        boolean z27;
        int i28;
        String str19;
        Object obj;
        byte[] bArr3;
        Context context2;
        String str20;
        String str21;
        String str22;
        int i29;
        int i36;
        boolean z28;
        String str23;
        boolean z29;
        int a16;
        int i37;
        int i38;
        QQAppInterface qQAppInterface2 = qQAppInterface;
        String str24 = str3;
        String str25 = str4;
        QLog.d("ChatActivityUtils", 1, "enterVideo QAV_CALL_START_COST begin: " + System.currentTimeMillis());
        int start = HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{0}, 3000, 101, 4L, Process.myTid(), "bootVideo", true);
        if (i3 == 1011) {
            if (!com.tencent.av.utils.v.c("random_talk_bg_2.png")) {
                com.tencent.av.utils.v.d(qQAppInterface);
            }
            if (map != null) {
                map.get("chat_type");
                String str26 = map.get("encodeuin");
                if (str26 != null && !TextUtils.isEmpty(str26)) {
                    str6 = C(qQAppInterface2, str26);
                    if (str6 == null) {
                        QLog.e("ChatActivityUtils", 1, "enterVideo Chat AnyOne decode peeruin Err!");
                        return;
                    }
                    QLog.w("ChatActivityUtils", 1, "avideo enterVideo called, uinType[" + i3 + "], peerUin[" + str6 + "], name[" + str2 + "], phoneNum[" + str24 + "], onlyAudio[" + z16 + "], extraUin[" + str25 + "], from[" + str5 + "]");
                    if (!qQAppInterface.isVideoChatting() && qQAppInterface.getAVNotifyCenter().P() != 1 && qQAppInterface.getAVNotifyCenter().P() != 3000 && qQAppInterface.getAVNotifyCenter().f0() && qQAppInterface.getAVNotifyCenter().k0() && qQAppInterface.getAVNotifyCenter().P() != 1011 && qQAppInterface.getAVNotifyCenter().P() != 21) {
                        Intent intent = new Intent(context, (Class<?>) VideoInviteActivity.class);
                        intent.addFlags(268435456);
                        intent.putExtra("uinType", i3);
                        intent.putExtra("peerUin", str6);
                        intent.putExtra("extraUin", str25);
                        intent.putExtra("isAudioMode", z16);
                        context.startActivity(intent);
                        return;
                    }
                    if (i3 != 0) {
                        str8 = "extraUin";
                        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str6), "ChatActivityUtils");
                        if (onlineStatusSimpleInfoWithUid != null) {
                            if (!QLog.isColorLevel()) {
                                str7 = "isAudioMode";
                                i38 = 2;
                                cls = IOnlineStatusInfoService.class;
                            } else {
                                StringBuilder sb5 = new StringBuilder();
                                str7 = "isAudioMode";
                                sb5.append("enterVideo terminal: ");
                                sb5.append(str6);
                                sb5.append(", abilityBits: ");
                                cls = IOnlineStatusInfoService.class;
                                sb5.append(onlineStatusSimpleInfoWithUid.b());
                                sb5.append(", _eSupportVoice: ");
                                sb5.append(1);
                                i38 = 2;
                                QLog.d("ChatActivityUtils", 2, sb5.toString());
                            }
                            if (com.tencent.mobileqq.activity.contacts.friend.a.a(onlineStatusSimpleInfoWithUid.E(), onlineStatusSimpleInfoWithUid.z(), onlineStatusSimpleInfoWithUid.C()) != i38) {
                                z18 = true;
                                if (i3 == 1006 && i3 != 24 && i3 != 25) {
                                    if (TextUtils.isEmpty(str3)) {
                                        PhoneContact queryPhoneContactByUin = ((IPhoneContactService) qQAppInterface2.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(str6);
                                        if (queryPhoneContactByUin != null) {
                                            str24 = queryPhoneContactByUin.mobileNo;
                                        } else if (QLog.isColorLevel()) {
                                            QLog.w("ChatActivityUtils", 2, "enterVideo cannot get phone number");
                                        }
                                    }
                                    str12 = null;
                                    str10 = null;
                                } else {
                                    if (!TextUtils.isEmpty(str6) && TextUtils.isEmpty(str3)) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e("ChatActivityUtils", 2, "enterVideo uinType: " + i3 + ", peerUin: " + str6 + ", name: " + str2 + ", phoneNum: " + str24 + ", onlyAudio: " + z16 + ", extraUin: " + str25);
                                            return;
                                        }
                                        return;
                                    }
                                    selfBindInfo = ((IPhoneContactService) qQAppInterface2.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
                                    if (selfBindInfo == null) {
                                        str10 = selfBindInfo.nationCode;
                                        str9 = selfBindInfo.mobileNo;
                                    } else {
                                        str9 = null;
                                        str10 = null;
                                    }
                                    if (TextUtils.isEmpty(str6)) {
                                        str11 = str9;
                                        if (TextUtils.isEmpty(str3)) {
                                            str24 = str6;
                                        }
                                    } else {
                                        str11 = str9;
                                        str6 = str24;
                                    }
                                    if ((i3 != 24 || i3 == 25) && (selfBindInfo == null || selfBindInfo.nationCode.equals("") || selfBindInfo.mobileNo.equals(""))) {
                                        QQToast.makeText(context, R.string.dga, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                    }
                                    str12 = str11;
                                }
                                if (i3 == 1000) {
                                    TroopManager troopManager = (TroopManager) qQAppInterface2.getManager(QQManagerFactory.TROOP_MANAGER);
                                    String G = troopManager != null ? troopManager.G(str25) : str25;
                                    if (G == null) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e("ChatActivityUtils", 2, "enterVideo can't find troop info!");
                                            return;
                                        }
                                        return;
                                    }
                                    str25 = G;
                                }
                                boolean z36 = z18;
                                if (i3 == 9500) {
                                    map2 = map;
                                    if (map2 != null) {
                                        str13 = map2.get("devSubCode");
                                    } else {
                                        str14 = str25;
                                        str13 = "";
                                        String str27 = str24;
                                        String str28 = str12;
                                        if (i3 != 1011) {
                                            try {
                                                if (map2 == null) {
                                                    QLog.e("ChatActivityUtils", 1, "Parse Sig String Exception");
                                                    return;
                                                }
                                                String str29 = map2.get(PreloadTRTCPlayerParams.KEY_SIG);
                                                if (QLog.isColorLevel()) {
                                                    StringBuilder sb6 = new StringBuilder();
                                                    str15 = PreloadTRTCPlayerParams.KEY_SIG;
                                                    sb6.append("sig string=");
                                                    sb6.append(str29);
                                                    QLog.e("ChatActivityUtils", 2, sb6.toString());
                                                } else {
                                                    str15 = PreloadTRTCPlayerParams.KEY_SIG;
                                                }
                                                String[] split = str29.replace(Marker.ANY_NON_NULL_MARKER, "").split(",");
                                                byte[] bArr4 = new byte[split.length];
                                                str16 = str10;
                                                for (int i39 = 0; i39 < split.length; i39++) {
                                                    bArr4[i39] = Byte.parseByte(split[i39].trim());
                                                }
                                                try {
                                                    str17 = new String(H(str2), "UTF-8");
                                                    try {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.e("ChatActivityUtils", 2, "UTF-8 == " + str17);
                                                        }
                                                    } catch (Exception unused) {
                                                    }
                                                } catch (Exception unused2) {
                                                    str17 = str2;
                                                }
                                                bArr = bArr4;
                                                z19 = true;
                                            } catch (Exception unused3) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("ChatActivityUtils", 2, "Parse Sig String Exception");
                                                    return;
                                                }
                                                return;
                                            }
                                        } else {
                                            str15 = PreloadTRTCPlayerParams.KEY_SIG;
                                            str16 = str10;
                                            str17 = str2;
                                            bArr = VideoMsgTools.s(qQAppInterface2, i3, str6);
                                            z19 = false;
                                        }
                                        boolean z37 = z19;
                                        if ((i3 != 1025 || i3 == 1024) && bArr != null && bArr.length == 3) {
                                            if (!z16) {
                                                string = context.getString(R.string.f0x);
                                            } else {
                                                string = context.getString(R.string.f0y);
                                            }
                                            Context context3 = !(context instanceof Activity) ? context : BaseActivity.sTopActivity;
                                            DialogUtil.createCustomDialog(context3, 230, (String) null, string, (String) null, context3.getString(R.string.f171151ok), new m(), (DialogInterface.OnClickListener) null).show();
                                            return;
                                        }
                                        AppRuntime.Status onlineStatus = ((IOnlineStatusService) qQAppInterface2.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
                                        boolean k3 = k(qQAppInterface2, str6);
                                        ((FriendsManager) qQAppInterface2.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(str6);
                                        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid2 = ((IOnlineStatusInfoService) QRoute.api(cls)).getOnlineStatusSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str6), "ChatActivityUtils");
                                        if (onlineStatusSimpleInfoWithUid2 != null) {
                                            i16 = com.tencent.mobileqq.utils.ac.I(onlineStatusSimpleInfoWithUid2, qQAppInterface2);
                                            i17 = com.tencent.mobileqq.friend.status.b.a(onlineStatusSimpleInfoWithUid2.u(), onlineStatusSimpleInfoWithUid2.z());
                                        } else {
                                            i16 = -1;
                                            i17 = 0;
                                        }
                                        if (VipFunCallUtil.ifUseKuikly()) {
                                            str18 = "Parse Sig String Exception";
                                            i18 = i16;
                                            bArr2 = bArr;
                                            i19 = 0;
                                            i26 = 0;
                                        } else {
                                            int currentUserVipType = ((ISVIPHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
                                            bArr2 = bArr;
                                            if (currentUserVipType == 2) {
                                                str18 = "Parse Sig String Exception";
                                                i18 = i16;
                                                z28 = true;
                                                str23 = null;
                                                i29 = 3;
                                                i36 = 0;
                                            } else {
                                                i29 = 3;
                                                if (currentUserVipType == 3) {
                                                    str18 = "Parse Sig String Exception";
                                                    i18 = i16;
                                                    z28 = true;
                                                    str23 = null;
                                                    i36 = 2;
                                                } else {
                                                    i36 = currentUserVipType;
                                                    str18 = "Parse Sig String Exception";
                                                    i18 = i16;
                                                    z28 = true;
                                                    str23 = null;
                                                }
                                            }
                                            int resIdByUin = VipFunCallUtil.getResIdByUin(qQAppInterface2, str6, i29, z28, str23);
                                            if (resIdByUin != 0) {
                                                if (i3 == 0 || i3 == 1004 || i3 == 1000 || i3 == 1003) {
                                                    com.tencent.mobileqq.vas.h hVar = (com.tencent.mobileqq.vas.h) qQAppInterface2.getManager(QQManagerFactory.COLOR_RING_MANAGER);
                                                    if (!new File(com.tencent.mobileqq.vas.h.e(resIdByUin, 3)).exists() && VipFunCallUtil.isNetworkAllowDowanload()) {
                                                        hVar.g(resIdByUin, 3, false, 0, "colorring");
                                                    }
                                                } else {
                                                    z29 = true;
                                                    a16 = kw.a.a(qQAppInterface2, str6, z29, z29);
                                                    if (a16 == 0) {
                                                        int resourceType = VipFunCallUtil.getResourceType();
                                                        i37 = resIdByUin;
                                                        String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(qQAppInterface2, a16, resourceType, null);
                                                        if (!TextUtils.isEmpty(resourcePathByUrl) && !new File(resourcePathByUrl).exists() && VipFunCallUtil.isNetworkAllowDowanload()) {
                                                            VasUtil.getService().getFunCallManager().startDownload(a16, resourceType, false, 0);
                                                        }
                                                    } else {
                                                        i37 = resIdByUin;
                                                    }
                                                    i19 = i37;
                                                    i26 = i36;
                                                }
                                            }
                                            z29 = true;
                                            qQAppInterface2 = qQAppInterface;
                                            a16 = kw.a.a(qQAppInterface2, str6, z29, z29);
                                            if (a16 == 0) {
                                            }
                                            i19 = i37;
                                            i26 = i36;
                                        }
                                        try {
                                            VipSetFunCallHandler vipSetFunCallHandler = (VipSetFunCallHandler) qQAppInterface2.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
                                            Bundle bundle = new Bundle();
                                            z26 = k3;
                                            try {
                                                bundle.putLong("uin", Long.parseLong(str6));
                                                bundle.putString("phone", "");
                                                vipSetFunCallHandler.P2(2, bundle);
                                            } catch (Exception e16) {
                                                e = e16;
                                                QLog.e("ChatActivityUtils", 1, "VipSetFunCallHandler Error:" + e.getMessage());
                                                if (map2 == null) {
                                                }
                                                if (context == null) {
                                                }
                                            }
                                        } catch (Exception e17) {
                                            e = e17;
                                            z26 = k3;
                                        }
                                        if (map2 == null) {
                                            String str30 = map2.get("inviteScene");
                                            String str31 = map2.get("isAvatarFromH5");
                                            try {
                                                i28 = !TextUtils.isEmpty(str30) ? Integer.parseInt(str30) : 0;
                                                try {
                                                    if (TextUtils.isEmpty(str31)) {
                                                        z27 = false;
                                                    } else {
                                                        z27 = Integer.parseInt(str31) > 0;
                                                    }
                                                } catch (NumberFormatException e18) {
                                                    e = e18;
                                                    z27 = false;
                                                }
                                                try {
                                                    QLog.i("ChatActivityUtils", 2, "inviteScene: " + i28 + ", isAvatarFromH5: " + z27);
                                                    i27 = 1;
                                                } catch (NumberFormatException e19) {
                                                    e = e19;
                                                    i27 = 1;
                                                    QLog.e("ChatActivityUtils", 1, "inviteSceneStr parse error:" + e.getMessage());
                                                    if (context == null) {
                                                    }
                                                }
                                            } catch (NumberFormatException e26) {
                                                e = e26;
                                                z27 = false;
                                                i28 = 0;
                                            }
                                        } else {
                                            i27 = 1;
                                            z27 = false;
                                            i28 = 0;
                                        }
                                        if (context == null) {
                                            QLog.e("ChatActivityUtils", i27, "enterVideo fail, context is null");
                                            return;
                                        }
                                        Intent intent2 = new Intent(context, (Class<?>) AVActivity.class);
                                        intent2.addFlags(262144);
                                        intent2.addFlags(268435456);
                                        intent2.putExtra("uinType", i3);
                                        intent2.putExtra("uin", str6);
                                        intent2.putExtra("name", str17);
                                        intent2.putExtra("selfNation", str16);
                                        intent2.putExtra("selfMobile", str28);
                                        String str32 = str27;
                                        intent2.putExtra("toMobile", str32);
                                        intent2.putExtra("receive", false);
                                        String str33 = str7;
                                        intent2.putExtra(str33, z16);
                                        intent2.putExtra("istatus", onlineStatus.getValue());
                                        intent2.putExtra("remoteStatus", i17);
                                        intent2.putExtra(str8, str14);
                                        intent2.putExtra("extraCode", str13);
                                        intent2.putExtra("isPeerNetworkWell", z36);
                                        intent2.putExtra("inviteScene", i28);
                                        intent2.putExtra("isAvatarFromH5", z27);
                                        intent2.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, z26);
                                        intent2.putExtra("senderStartTime", SystemClock.elapsedRealtime());
                                        intent2.putExtra("isSender", true);
                                        intent2.putExtra("colorRingId", i19);
                                        intent2.putExtra("vipType", i26);
                                        intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, z16 ? 1 : 2);
                                        intent2.putExtra("hc_code", start);
                                        intent2.putExtra("main_timestamp", System.currentTimeMillis());
                                        if (map2 != null) {
                                            String str34 = map2.get("dstClient");
                                            String str35 = map2.get("bindId");
                                            String str36 = map2.get("bindType");
                                            String str37 = map2.get("extraType");
                                            if (str34 != null) {
                                                intent2.putExtra("dstClient", str34);
                                                intent2.putExtra("bindId", str35);
                                                intent2.putExtra("bindType", Integer.valueOf(str36).intValue());
                                                intent2.putExtra("extraType", Integer.valueOf(str37).intValue());
                                                str19 = str15;
                                                String str38 = map2.get(str19);
                                                if (QLog.isColorLevel()) {
                                                    QLog.e("ChatActivityUtils", 2, "sig string=" + str38);
                                                }
                                                if (str38 != null) {
                                                    try {
                                                        bArr3 = HexUtil.hexStr2Bytes(str38);
                                                        HexUtil.printHexString("ChatActivityUtils", bArr3);
                                                        str20 = map2.get(AdParam.ACTID);
                                                        if (str20 != null) {
                                                            intent2.putExtra(GameCenterCommonApiImpl.KEY_ACT_ID, str20);
                                                        }
                                                        if (QLog.isColorLevel()) {
                                                            QLog.e("ChatActivityUtils", 2, "entervideo actid = " + str20);
                                                        }
                                                        intent2.putExtra("start_double_rtc_talk_from_source", com.tencent.avcore.rtc.node.report.utils.c.f(map));
                                                        str21 = map2.get("trace_id");
                                                        if (str21 != null) {
                                                            intent2.putExtra("trace_id", str21);
                                                        }
                                                        obj = "trace_id";
                                                        intent2.putExtra("timestamp", System.currentTimeMillis());
                                                        str22 = map2.get("mp_ext_params");
                                                        if (QLog.isColorLevel()) {
                                                            QLog.e("ChatActivityUtils", 2, "entervideo mp_ext_params = " + str22);
                                                        }
                                                        if (str22 != null) {
                                                            intent2.putExtra("mp_ext_params", str22);
                                                        }
                                                    } catch (Exception unused4) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.e("ChatActivityUtils", 2, str18);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                            } else {
                                                str19 = str15;
                                            }
                                            bArr3 = bArr2;
                                            str20 = map2.get(AdParam.ACTID);
                                            if (str20 != null) {
                                            }
                                            if (QLog.isColorLevel()) {
                                            }
                                            intent2.putExtra("start_double_rtc_talk_from_source", com.tencent.avcore.rtc.node.report.utils.c.f(map));
                                            str21 = map2.get("trace_id");
                                            if (str21 != null) {
                                            }
                                            obj = "trace_id";
                                            intent2.putExtra("timestamp", System.currentTimeMillis());
                                            str22 = map2.get("mp_ext_params");
                                            if (QLog.isColorLevel()) {
                                            }
                                            if (str22 != null) {
                                            }
                                        } else {
                                            str19 = str15;
                                            obj = "trace_id";
                                            bArr3 = bArr2;
                                        }
                                        intent2.putExtra(str19, bArr3);
                                        if (i3 == 1011 && map2 != null) {
                                            String str39 = map2.get("sex");
                                            intent2.putExtra("headUrl", map2.get("headUrl") + str39 + ".jpg");
                                        }
                                        if (qQAppInterface.getAVNotifyCenter().d0(str6)) {
                                            if (qQAppInterface.getAVNotifyCenter().C(str6) == 1) {
                                                intent2.putExtra(str33, true);
                                            } else {
                                                intent2.putExtra(str33, false);
                                            }
                                            intent2.putExtra("startfromVideoEntry", !z16);
                                            intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, qQAppInterface.getAVNotifyCenter().C(str6));
                                        }
                                        intent2.putExtra("from", str5);
                                        intent2.putExtra("Fromwhere", str5);
                                        intent2.putExtra("friendTerminal", i18);
                                        intent2.putExtra("isOtherTerminalOnChating", qQAppInterface.getAVNotifyCenter().d0(str6));
                                        intent2.putExtra("otherTerminalChatingRoomId", qQAppInterface.getAVNotifyCenter().D(str6));
                                        intent2.putExtra("triggerBeauty", z17);
                                        intent2.putExtra("isMakingAcall", true);
                                        if (str6 != null || str32 != null) {
                                            AVNotifyCenter aVNotifyCenter = qQAppInterface.getAVNotifyCenter();
                                            String currentUin = qQAppInterface.getCurrentUin();
                                            if (str6 != null) {
                                                str32 = str6;
                                            }
                                            aVNotifyCenter.k(currentUin, str32, !z16 ? 1 : 0, i3);
                                        }
                                        String className = intent2.getComponent().getClassName();
                                        String name = context.getClass().getName();
                                        if (className.equals("com.tencent.av.ui.AVActivity") && (name.equals("com.tencent.mobileqq.qcall.QCallDetailActivity") || name.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity") || name.equals("com.tencent.mobileqq.activity.SplashActivity") || name.equals("com.tencent.mobileqq.activity.PublicFragmentActivity") || i3 == 9500 || i3 == 1044)) {
                                            context2 = context;
                                            Intent intent3 = new Intent(context2, (Class<?>) AVLoadingDialogActivity.class);
                                            intent3.putExtra("avactivity_intent", intent2);
                                            intent3.addFlags(268435456);
                                            context2.startActivity(intent3);
                                            intent2.setExtrasClassLoader(ResultRecord.class.getClassLoader());
                                            context2.startActivity(intent2);
                                            if (context2 instanceof Activity) {
                                                ((Activity) context2).overridePendingTransition(R.anim.f154855e4, 0);
                                            }
                                        } else {
                                            context2 = context;
                                            context2.startActivity(intent2);
                                        }
                                        if (map2 != null) {
                                            Object obj2 = obj;
                                            if (map2.containsKey(obj2)) {
                                                ThreadManagerV2.excute(new Runnable(map2.get(obj2)) { // from class: com.tencent.mobileqq.activity.ChatActivityUtils.4
                                                    static IPatchRedirector $redirector_;

                                                    /* renamed from: d, reason: collision with root package name */
                                                    final /* synthetic */ String f175175d;

                                                    {
                                                        this.f175175d = r4;
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                                                        }
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        IPatchRedirector iPatchRedirector = $redirector_;
                                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                            iPatchRedirector.redirect((short) 2, (Object) this);
                                                        } else {
                                                            RtcNodeReportMainProcessTask.a(this.f175175d);
                                                        }
                                                    }
                                                }, 128, null, true);
                                            }
                                        }
                                        if (z17 && (context2 instanceof Activity)) {
                                            ((Activity) context2).overridePendingTransition(R.anim.f154822cw, R.anim.f154823cx);
                                        }
                                        if (!qQAppInterface.isVideoChatting() || z37 || i3 == 9500 || !(context2 instanceof Activity)) {
                                            return;
                                        }
                                        ((Activity) context2).overridePendingTransition(R.anim.f154832d9, 0);
                                        return;
                                    }
                                } else {
                                    map2 = map;
                                    str13 = str4;
                                }
                                str14 = str25;
                                String str272 = str24;
                                String str282 = str12;
                                if (i3 != 1011) {
                                }
                                boolean z372 = z19;
                                if (i3 != 1025) {
                                }
                                if (!z16) {
                                }
                                if (!(context instanceof Activity)) {
                                }
                                DialogUtil.createCustomDialog(context3, 230, (String) null, string, (String) null, context3.getString(R.string.f171151ok), new m(), (DialogInterface.OnClickListener) null).show();
                                return;
                            }
                            z18 = false;
                            if (i3 == 1006) {
                            }
                            if (!TextUtils.isEmpty(str6)) {
                            }
                            selfBindInfo = ((IPhoneContactService) qQAppInterface2.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
                            if (selfBindInfo == null) {
                            }
                            if (TextUtils.isEmpty(str6)) {
                            }
                            if (i3 != 24) {
                            }
                            QQToast.makeText(context, R.string.dga, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                        str7 = "isAudioMode";
                    } else {
                        str7 = "isAudioMode";
                        str8 = "extraUin";
                    }
                    cls = IOnlineStatusInfoService.class;
                    z18 = false;
                    if (i3 == 1006) {
                    }
                    if (!TextUtils.isEmpty(str6)) {
                    }
                    selfBindInfo = ((IPhoneContactService) qQAppInterface2.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
                    if (selfBindInfo == null) {
                    }
                    if (TextUtils.isEmpty(str6)) {
                    }
                    if (i3 != 24) {
                    }
                    QQToast.makeText(context, R.string.dga, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            }
        }
        str6 = str;
        QLog.w("ChatActivityUtils", 1, "avideo enterVideo called, uinType[" + i3 + "], peerUin[" + str6 + "], name[" + str2 + "], phoneNum[" + str24 + "], onlyAudio[" + z16 + "], extraUin[" + str25 + "], from[" + str5 + "]");
        if (!qQAppInterface.isVideoChatting()) {
        }
        if (i3 != 0) {
        }
        cls = IOnlineStatusInfoService.class;
        z18 = false;
        if (i3 == 1006) {
        }
        if (!TextUtils.isEmpty(str6)) {
        }
        selfBindInfo = ((IPhoneContactService) qQAppInterface2.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
        if (selfBindInfo == null) {
        }
        if (TextUtils.isEmpty(str6)) {
        }
        if (i3 != 24) {
        }
        QQToast.makeText(context, R.string.dga, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    static Bundle x(Map<String, String> map) {
        String str;
        Bundle bundle = new Bundle();
        if (map != null) {
            if (map.containsKey(AdParam.ACTID)) {
                bundle.putString(GameCenterCommonApiImpl.KEY_ACT_ID, map.get(AdParam.ACTID));
            }
            if (map.containsKey("mp_ext_params")) {
                bundle.putString("mp_ext_params", map.get("mp_ext_params"));
            }
            String str2 = map.get("MultiAVType");
            if (str2 != null) {
                bundle.putInt("MultiAVType", Integer.valueOf(str2).intValue());
            }
            bundle.putBoolean(BaseProfileQZoneComponent.KEY_IS_VIDEO, TextUtils.equals(map.get(BaseProfileQZoneComponent.KEY_IS_VIDEO), "true"));
            String str3 = map.get("Fromwhere");
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("Fromwhere", str3);
            }
            if (map.containsKey("ConfAppID")) {
                bundle.putInt("ConfAppID", Integer.valueOf(map.get("ConfAppID")).intValue());
            }
            if (map.containsKey("MeetingConfID")) {
                bundle.putInt("MeetingConfID", Integer.valueOf(map.get("MeetingConfID")).intValue());
            }
            bundle.putString("jump_from", map.get("jump_from"));
            bundle.putString("enterType", map.get("enterType"));
        }
        if (map != null) {
            str = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String value = entry.getValue();
                str = str + "  [" + entry.getKey() + "]=[" + ((Object) value) + "], [" + value.getClass().getName() + "]\n";
            }
        } else {
            str = "null";
        }
        QLog.w("ChatActivityUtils", 1, "strExtroInfo[extroInfo2Bundle]:\n" + str);
        QQAudioHelper.m("ChatActivityUtils_extroInfo2Bundle", bundle, true);
        return bundle;
    }

    public static String y(String str, int i3) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        if (i3 == 16) {
            return f(messageDigest.digest(str.getBytes("utf-8"))).substring(8, 24);
        }
        return f(messageDigest.digest(str.getBytes("utf-8")));
    }

    public static byte[] z(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        long j3;
        if (jSONObject == null) {
            return null;
        }
        boolean isDevelopLevel = QLog.isDevelopLevel();
        String str17 = PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA;
        if (isDevelopLevel) {
            str = PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA;
            StringBuilder sb5 = new StringBuilder();
            str2 = "action";
            sb5.append(jSONObject.toString());
            sb5.append("");
            QLog.d("ChatActivityUtils", 4, sb5.toString());
        } else {
            str = PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA;
            str2 = "action";
        }
        try {
            if (jSONObject.has("url")) {
                str3 = jSONObject.getString("url");
            } else {
                str3 = null;
            }
            if (jSONObject.has("picture")) {
                str4 = jSONObject.getString("picture");
            } else {
                str4 = null;
            }
            if (jSONObject.has("title")) {
                str5 = jSONObject.getString("title");
            } else {
                str5 = null;
            }
            if (jSONObject.has("summary")) {
                str6 = jSONObject.getString("summary");
            } else {
                str6 = null;
            }
            if (jSONObject.has("brief")) {
                str7 = jSONObject.getString("brief");
            } else {
                str7 = null;
            }
            if (jSONObject.has(TtmlNode.TAG_LAYOUT)) {
                i3 = jSONObject.getInt(TtmlNode.TAG_LAYOUT);
            } else {
                i3 = 2;
            }
            if (jSONObject.has("source")) {
                str8 = jSONObject.getString("source");
            } else {
                str8 = null;
            }
            try {
                if (i3 == 6) {
                    if (jSONObject.has("price")) {
                        str9 = jSONObject.getString("price");
                    } else {
                        str9 = null;
                    }
                    if (jSONObject.has("prunit")) {
                        str10 = jSONObject.getString("prunit");
                    } else {
                        str10 = null;
                    }
                    if (jSONObject.has("icon")) {
                        str11 = jSONObject.getString("icon");
                    } else {
                        str11 = null;
                    }
                    if (jSONObject.has("srcaction")) {
                        str12 = jSONObject.getString("srcaction");
                    } else {
                        str12 = null;
                    }
                    String str18 = str2;
                    if (jSONObject.has(str18)) {
                        str13 = jSONObject.getString(str18);
                    } else {
                        str13 = null;
                    }
                    String str19 = str;
                    if (jSONObject.has(str19)) {
                        str14 = jSONObject.getString(str19);
                    } else {
                        str14 = null;
                    }
                    if (jSONObject.has(str17)) {
                        str15 = jSONObject.getString(str17);
                    } else {
                        str15 = null;
                    }
                    if (!jSONObject.has("appid")) {
                        str16 = "";
                    } else {
                        str16 = jSONObject.getString("appid");
                    }
                    AbsShareMsg.a f16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(41).d(str7).f(7);
                    if (!TextUtils.isEmpty(str16)) {
                        j3 = Long.parseLong(str16);
                    } else {
                        j3 = -1;
                    }
                    AbsShareMsg a16 = f16.c(j3).b(str13, str3, null, null, null).i(str8, str11).h(str12, null, null, str14, str15).e(str3).a();
                    com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(i3);
                    c16.r(str4, str5, str6, str9, str10, 0);
                    a16.addItem(c16);
                    return a16.getBytes();
                }
                String string = jSONObject.getString(IPublicAccountBrowser.KEY_PUB_UIN);
                AbsShareMsg a17 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(21).d(str7).j(str3).i(str8, null).h("plugin", null, null, AppConstants.VALUE.ANDROID_PA_CARD_ACTION_DATA_SCHEME + string, AppConstants.VALUE.IOS_PA_CARD_ACTION_DATA_SCHEME + string).a();
                com.tencent.mobileqq.structmsg.a c17 = com.tencent.mobileqq.structmsg.h.c(2);
                c17.o(str4, str5, str6);
                a17.addItem(c17);
                return a17.getBytes();
            } catch (JSONException unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.e(str17, 4, "createSecondHandProductInfoStructMsg---JSONException");
                    return null;
                }
                return null;
            }
        } catch (JSONException unused2) {
            str17 = "ChatActivityUtils";
        }
    }
}
