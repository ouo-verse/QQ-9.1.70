package com.dataline.activities;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.dataline.nt.DataLineRecentContactUtil;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.file.SendInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOutputStream;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationDataline;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.DataLineFaceDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.utils.cg;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.chats.api.IChatsUnreadAPI;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qui.quiblurview.QQBlur;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.TokenResUtils;
import com.tencent.util.hapticcreator.HapticUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import com.tencent.widget.XPanelContainer;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.slf4j.Marker;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.DATALINE, scene = "dataline")
/* loaded from: classes.dex */
public class LiteActivity extends IphoneTitleBarActivity implements Observer, Handler.Callback, View.OnClickListener, XPanelContainer.g, PhotoListPanel.e, com.tencent.qqnt.kernel.invorker.d {

    /* renamed from: e1, reason: collision with root package name */
    public static String f32035e1 = "dataline.LiteActivity";

    /* renamed from: f1, reason: collision with root package name */
    private static boolean f32036f1 = false;

    /* renamed from: g1, reason: collision with root package name */
    protected static String f32037g1;
    TextView A0;
    ImageView B0;
    private boolean E0;
    private boolean F0;
    private QQCustomDialog G0;
    private QQBlurView H0;
    private ViewTreeObserver.OnGlobalLayoutListener J0;
    private LiteCopyPromptHelper K0;
    private ViewGroup M0;
    private InputLinearLayout N0;
    public View O0;
    public ImageButton P0;
    public ImageButton Q0;
    public TextView R0;
    public LinearLayout S0;
    protected TopGestureLayout T0;
    private QQPermission U0;
    BubblePopupWindow Y0;

    /* renamed from: a0, reason: collision with root package name */
    public XPanelContainer f32038a0;

    /* renamed from: b0, reason: collision with root package name */
    PhotoListPanel f32040b0;

    /* renamed from: d0, reason: collision with root package name */
    TextView f32044d0;

    /* renamed from: e0, reason: collision with root package name */
    XListView f32046e0;

    /* renamed from: f0, reason: collision with root package name */
    ScrollerRunnable f32047f0;

    /* renamed from: g0, reason: collision with root package name */
    TextView f32048g0;

    /* renamed from: h0, reason: collision with root package name */
    protected RelativeLayout f32049h0;

    /* renamed from: o0, reason: collision with root package name */
    int f32056o0;

    /* renamed from: p0, reason: collision with root package name */
    XEditTextEx f32057p0;

    /* renamed from: q0, reason: collision with root package name */
    TextWatcher f32058q0;

    /* renamed from: r0, reason: collision with root package name */
    Button f32059r0;

    /* renamed from: s0, reason: collision with root package name */
    am f32060s0;

    /* renamed from: z0, reason: collision with root package name */
    RelativeLayout f32067z0;

    /* renamed from: c0, reason: collision with root package name */
    SessionInfo f32042c0 = new SessionInfo();

    /* renamed from: i0, reason: collision with root package name */
    public int f32050i0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    protected String f32051j0 = AppConstants.DATALINE_PC_UIN;

    /* renamed from: k0, reason: collision with root package name */
    DataLineMsgSetList f32052k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    DatalineSessionAdapter f32053l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    List<Long> f32054m0 = new ArrayList();

    /* renamed from: n0, reason: collision with root package name */
    boolean f32055n0 = false;

    /* renamed from: t0, reason: collision with root package name */
    QQCustomDialog f32061t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    boolean f32062u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    ForwardBaseOption f32063v0 = null;

    /* renamed from: w0, reason: collision with root package name */
    MqqHandler f32064w0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f32065x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    protected boolean f32066y0 = false;
    boolean C0 = false;
    boolean D0 = true;
    private boolean I0 = false;
    private boolean L0 = false;
    public View.OnClickListener V0 = new g();
    public View.OnClickListener W0 = new h();
    com.tencent.mobileqq.app.k X0 = new com.tencent.mobileqq.app.k() { // from class: com.dataline.activities.LiteActivity.27

        /* compiled from: P */
        /* renamed from: com.dataline.activities.LiteActivity$27$7, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass7 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AnonymousClass27 f32101d;

            @Override // java.lang.Runnable
            public void run() {
                LiteActivity.this.f32053l0.notifyDataSetChanged();
                LiteActivity liteActivity = LiteActivity.this;
                LiteActivity.n3(liteActivity.f32047f0, liteActivity.f32046e0);
                LiteActivity.h4(LiteActivity.this.f32046e0);
                LiteActivity.this.app.getMessageFacade().t1(LiteActivity.this.f32050i0).l();
                DataLineRecentContactUtil.f32313a.w(LiteActivity.this.f32050i0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void a(boolean z16, long j3) {
            super.a(z16, j3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void b(final long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.b(j3, str, i3, z16, z17, j16);
            final int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.4
                @Override // java.lang.Runnable
                public void run() {
                    DataLineMsgRecord d16 = LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).d(j3);
                    if (d16 == null || d16.isSendFromLocal()) {
                        return;
                    }
                    DataLineMsgSet v3 = LiteActivity.this.app.getDataLineMsgProxy(devTypeBySeId).v(j3);
                    if (v3 != null && !v3.isSingle()) {
                        LiteActivity liteActivity = LiteActivity.this;
                        if (!liteActivity.f32053l0.G(j3, liteActivity.f32046e0)) {
                            LiteActivity.this.f32053l0.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    LiteActivity.this.f32053l0.notifyDataSetChanged();
                    if (!d16.bIsResendOrRecvFile) {
                        LiteActivity liteActivity2 = LiteActivity.this;
                        LiteActivity.n3(liteActivity2.f32047f0, liteActivity2.f32046e0);
                        LiteActivity.h4(LiteActivity.this.f32046e0);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void c(final long j3, String str, int i3, boolean z16, boolean z17, long j16) {
            super.c(j3, str, i3, z16, z17, j16);
            final int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.5
                @Override // java.lang.Runnable
                public void run() {
                    DataLineMsgRecord d16 = LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).d(j3);
                    if (d16 == null || !d16.isSendFromLocal()) {
                        return;
                    }
                    LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).l();
                    DataLineRecentContactUtil.f32313a.w(devTypeBySeId);
                    DataLineMsgSet v3 = LiteActivity.this.app.getDataLineMsgProxy(devTypeBySeId).v(j3);
                    if (v3 != null && !v3.isSingle()) {
                        LiteActivity liteActivity = LiteActivity.this;
                        if (!liteActivity.f32053l0.G(j3, liteActivity.f32046e0)) {
                            LiteActivity.this.f32053l0.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    LiteActivity.this.f32053l0.notifyDataSetChanged();
                    if (!d16.bIsResendOrRecvFile) {
                        LiteActivity liteActivity2 = LiteActivity.this;
                        LiteActivity.n3(liteActivity2.f32047f0, liteActivity2.f32046e0);
                        LiteActivity.h4(LiteActivity.this.f32046e0);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void h(final long j3, final float f16) {
            super.h(j3, f16);
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.3
                @Override // java.lang.Runnable
                public void run() {
                    LiteActivity liteActivity = LiteActivity.this;
                    liteActivity.f32053l0.I(j3, liteActivity.f32046e0, f16);
                }
            });
        }

        @Override // com.tencent.mobileqq.app.k
        @TargetApi(11)
        protected void i(int i3, String str, long j3) {
            DataLineMsgRecord.getDevTypeBySeId(j3);
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.8
                @Override // java.lang.Runnable
                public void run() {
                    LiteActivity.this.f32053l0.notifyDataSetChanged();
                    LiteActivity liteActivity = LiteActivity.this;
                    LiteActivity.n3(liteActivity.f32047f0, liteActivity.f32046e0);
                    LiteActivity.h4(LiteActivity.this.f32046e0);
                    LiteActivity.this.app.getMessageFacade().t1(LiteActivity.this.f32050i0).l();
                    DataLineRecentContactUtil.f32313a.w(LiteActivity.this.f32050i0);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void j(final boolean z16, final long j3, final String str) {
            super.j(z16, j3, str);
            final int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!z16) {
                        LiteActivity.this.e3(1048576L);
                    }
                    DataLineMsgRecord d16 = LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).d(j3);
                    DataLineMsgSet v3 = LiteActivity.this.app.getDataLineMsgProxy(devTypeBySeId).v(j3);
                    if (v3 != null && !v3.isSingle()) {
                        LiteActivity liteActivity = LiteActivity.this;
                        if (!liteActivity.f32053l0.G(j3, liteActivity.f32046e0)) {
                            LiteActivity.this.f32053l0.notifyDataSetChanged();
                        }
                    } else {
                        LiteActivity.this.f32053l0.notifyDataSetChanged();
                        if (d16 != null && !d16.bIsResendOrRecvFile) {
                            LiteActivity liteActivity2 = LiteActivity.this;
                            LiteActivity.n3(liteActivity2.f32047f0, liteActivity2.f32046e0);
                            LiteActivity.h4(LiteActivity.this.f32046e0);
                        }
                    }
                    LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).l();
                    DataLineRecentContactUtil.f32313a.w(devTypeBySeId);
                    if (QLog.isColorLevel()) {
                        QLog.d(LiteActivity.f32035e1, 2, "LiteActivity.onRecvFile, msgId[" + j3 + "], sPath = " + str + "], set[" + v3 + "], msgItem[" + d16);
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.app.k
        protected void k() {
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.10
                @Override // java.lang.Runnable
                public void run() {
                    LiteActivity.this.f32053l0.notifyDataSetChanged();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void l(boolean z16, final long j3, String str) {
            super.l(z16, j3, str);
            final int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.1
                @Override // java.lang.Runnable
                public void run() {
                    DataLineMsgRecord d16 = LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).d(j3);
                    DataLineMsgSet v3 = LiteActivity.this.app.getDataLineMsgProxy(devTypeBySeId).v(j3);
                    if (v3 != null && !v3.isSingle()) {
                        LiteActivity liteActivity = LiteActivity.this;
                        if (!liteActivity.f32053l0.G(j3, liteActivity.f32046e0)) {
                            LiteActivity.this.f32053l0.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    LiteActivity.this.f32053l0.notifyDataSetChanged();
                    if (d16 != null && !d16.bIsResendOrRecvFile) {
                        LiteActivity liteActivity2 = LiteActivity.this;
                        LiteActivity.n3(liteActivity2.f32047f0, liteActivity2.f32046e0);
                        LiteActivity.h4(LiteActivity.this.f32046e0);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.k
        public void m(boolean z16, Long l3, String str) {
            super.m(z16, l3, str);
            final int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(l3.longValue());
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.6
                @Override // java.lang.Runnable
                public void run() {
                    LiteActivity.this.f32053l0.notifyDataSetChanged();
                    LiteActivity liteActivity = LiteActivity.this;
                    LiteActivity.n3(liteActivity.f32047f0, liteActivity.f32046e0);
                    LiteActivity.h4(LiteActivity.this.f32046e0);
                    LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).l();
                    DataLineRecentContactUtil.f32313a.w(devTypeBySeId);
                }
            });
        }

        @Override // com.tencent.mobileqq.app.k
        protected void r(long j3) {
            LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.27.9
                @Override // java.lang.Runnable
                public void run() {
                    LiteActivity.this.f32053l0.notifyDataSetChanged();
                }
            });
        }
    };
    private PointF Z0 = new PointF();

    /* renamed from: a1, reason: collision with root package name */
    public View.OnLongClickListener f32039a1 = new m();

    /* renamed from: b1, reason: collision with root package name */
    public View.OnTouchListener f32041b1 = new n();

    /* renamed from: c1, reason: collision with root package name */
    FMObserver f32043c1 = new q();

    /* renamed from: d1, reason: collision with root package name */
    Runnable f32045d1 = new Runnable() { // from class: com.dataline.activities.LiteActivity.37
        @Override // java.lang.Runnable
        public void run() {
            TextView textView = LiteActivity.this.f32048g0;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    };

    /* compiled from: P */
    /* renamed from: com.dataline.activities.LiteActivity$11, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ LiteActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.D0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.dataline.activities.LiteActivity$29, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass29 implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DataLineMsgRecord f32106d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DataLineMsgSet f32107e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f32108f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f32109h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f32110i;

        /* compiled from: P */
        /* renamed from: com.dataline.activities.LiteActivity$29$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements DialogInterface.OnClickListener {
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(final DialogInterface dialogInterface, int i3) {
                final DataLineMsgSet dataLineMsgSet;
                final boolean z16;
                final DataLineHandler dataLineHandler = (DataLineHandler) LiteActivity.this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                DataLineMsgSet dataLineMsgSet2 = AnonymousClass29.this.f32107e;
                if (!dataLineMsgSet2.isReportPause && dataLineMsgSet2.getGroupType() == -2335) {
                    DataLineMsgSet dataLineMsgSet3 = AnonymousClass29.this.f32107e;
                    dataLineMsgSet3.isReportPause = true;
                    if (!dataLineMsgSet3.isSingle()) {
                        com.dataline.util.b.i(LiteActivity.this.app);
                    } else {
                        com.dataline.util.b.j(LiteActivity.this.app);
                    }
                }
                if (AnonymousClass29.this.f32107e.getGroupType() == -2000 && !AnonymousClass29.this.f32107e.isSingle()) {
                    com.dataline.util.b.k(LiteActivity.this.app);
                }
                if (!AnonymousClass29.this.f32107e.isSingle() && AnonymousClass29.this.f32107e.getGroupType() != -2335) {
                    dataLineHandler.j3(AnonymousClass29.this.f32107e.getGroupId(), 0L, true);
                } else {
                    Iterator<DataLineMsgRecord> it = AnonymousClass29.this.f32107e.values().iterator();
                    while (it.hasNext()) {
                        DataLineMsgRecord next = it.next();
                        dataLineHandler.j3(next.groupId, next.sessionid, true);
                    }
                    if (AnonymousClass29.this.f32107e.values().size() == 1 && AnonymousClass29.this.f32107e.getGroupType() == -2005) {
                        AnonymousClass29 anonymousClass29 = AnonymousClass29.this;
                        int setIndex = LiteActivity.this.f32052k0.getSetIndex(anonymousClass29.f32107e.values().get(0).sessionid) + 1;
                        if (setIndex < LiteActivity.this.f32052k0.size() && LiteActivity.this.f32052k0.get(setIndex).values().get(0).msgtype == -5041 && Long.parseLong(LiteActivity.this.f32052k0.get(setIndex).values().get(0).getExtInfoFromExtStr("tim_aio_file_msg_uiniseq")) == AnonymousClass29.this.f32107e.values().get(0).sessionid) {
                            dataLineMsgSet = LiteActivity.this.f32052k0.get(setIndex);
                            z16 = true;
                            ThreadManagerV2.excute(new Runnable() { // from class: com.dataline.activities.LiteActivity.29.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    dataLineHandler.q3(AnonymousClass29.this.f32107e);
                                    if (z16) {
                                        dataLineHandler.q3(dataLineMsgSet);
                                    }
                                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.dataline.activities.LiteActivity.29.1.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            LiteActivity.this.f32053l0.e();
                                            LiteActivity.this.f32053l0.notifyDataSetChanged();
                                            dialogInterface.dismiss();
                                        }
                                    });
                                }
                            }, 32, null, true);
                        }
                    }
                }
                z16 = false;
                dataLineMsgSet = null;
                ThreadManagerV2.excute(new Runnable() { // from class: com.dataline.activities.LiteActivity.29.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dataLineHandler.q3(AnonymousClass29.this.f32107e);
                        if (z16) {
                            dataLineHandler.q3(dataLineMsgSet);
                        }
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.dataline.activities.LiteActivity.29.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LiteActivity.this.f32053l0.e();
                                LiteActivity.this.f32053l0.notifyDataSetChanged();
                                dialogInterface.dismiss();
                            }
                        });
                    }
                }, 32, null, true);
            }
        }

        /* compiled from: P */
        /* renamed from: com.dataline.activities.LiteActivity$29$a */
        /* loaded from: classes.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        AnonymousClass29(DataLineMsgRecord dataLineMsgRecord, DataLineMsgSet dataLineMsgSet, Context context, int i3, String str) {
            this.f32106d = dataLineMsgRecord;
            this.f32107e = dataLineMsgSet;
            this.f32108f = context;
            this.f32109h = i3;
            this.f32110i = str;
        }

        @Override // android.view.View.OnClickListener
        @SuppressLint({"NewApi"})
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (R.id.ba_ == view.getId()) {
                com.tencent.mobileqq.statistics.s.a(LiteActivity.this.app.getApplication().getApplicationContext(), LiteActivity.this.app.getCurrentAccountUin(), "dl_copy");
                ((ClipboardManager) LiteActivity.this.f32046e0.getContext().getSystemService("clipboard")).setText(this.f32106d.f203106msg);
                int Q3 = LiteActivity.this.Q3();
                ReportController.o(LiteActivity.this.app, "dc00898", "", "", "0X800AD63", "0X800AD63", 1, 0, "" + Q3, "", "", "");
            } else if (R.id.bfg == view.getId()) {
                com.tencent.mobileqq.statistics.s.a(LiteActivity.this.app.getApplication().getApplicationContext(), LiteActivity.this.app.getCurrentAccountUin(), "dl_delete");
                AnonymousClass1 anonymousClass1 = new AnonymousClass1();
                a aVar = new a();
                Context context = this.f32108f;
                DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f171080c42), this.f32108f.getString(R.string.c3h), R.string.cancel, R.string.c4k, anonymousClass1, aVar).show();
                int R3 = LiteActivity.this.R3(this.f32106d, this.f32109h);
                int Q32 = LiteActivity.this.Q3();
                ReportController.o(LiteActivity.this.app, "dc00898", "", "", "0X800AD5D", "0X800AD5D", R3, 0, "" + Q32, "", "", "");
            } else if (R.id.cjs == view.getId()) {
                Intent x36 = LiteActivity.this.x3(this.f32106d, this.f32109h);
                if (x36 != null) {
                    ForwardBaseOption.startForwardActivityForResult(LiteActivity.this, x36, 4);
                } else {
                    LiteActivity liteActivity = LiteActivity.this;
                    QQToast.makeText(liteActivity, liteActivity.getResources().getString(R.string.f237377gw), 0).show();
                }
                int R32 = LiteActivity.this.R3(this.f32106d, this.f32109h);
                int Q33 = LiteActivity.this.Q3();
                ReportController.o(LiteActivity.this.app, "dc00898", "", "", "0X800AD5B", "0X800AD5B", R32, 0, "" + Q33, "", "", "");
            } else if (R.id.c39 == view.getId()) {
                if (this.f32110i.isEmpty()) {
                    QfavBuilder.k0(null, this.f32106d.f203106msg).C(LiteActivity.this.app).h(LiteActivity.this.getActivity(), LiteActivity.this.app.getAccount());
                    cooperation.qqfav.d.e(LiteActivity.this.app, 64, 1);
                } else {
                    int i3 = this.f32109h;
                    if (i3 == -2000) {
                        QfavBuilder.e0(this.f32110i).C(LiteActivity.this.app).h(LiteActivity.this.getActivity(), LiteActivity.this.app.getAccount());
                        cooperation.qqfav.d.e(LiteActivity.this.app, 64, 3);
                    } else if (i3 == -2005 || i3 == -2009) {
                        QfavBuilder qfavBuilder = new QfavBuilder(3);
                        LiteActivity liteActivity2 = LiteActivity.this;
                        qfavBuilder.w(liteActivity2.app, liteActivity2, this.f32110i);
                    }
                }
                int R33 = LiteActivity.this.R3(this.f32106d, this.f32109h);
                int Q34 = LiteActivity.this.Q3();
                ReportController.o(LiteActivity.this.app, "dc00898", "", "", "0X800AD5C", "0X800AD5C", R33, 0, "" + Q34, "", "", "");
            } else if (R.id.kkb == view.getId()) {
                LiteActivity.this.X3(this.f32106d, this.f32109h, this.f32110i);
            } else if (R.id.f164035i0 == view.getId()) {
                LiteActivity.this.W3(this.f32107e, this.f32106d, this.f32109h);
            } else if (R.id.jc8 == view.getId()) {
                ReportController.o(LiteActivity.this.app, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
                TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
                DataLineMsgRecord dataLineMsgRecord = this.f32106d;
                teamWorkFileImportInfo.f292077h = dataLineMsgRecord.path;
                String str = dataLineMsgRecord.filename;
                teamWorkFileImportInfo.f292074f = str;
                teamWorkFileImportInfo.R = FileManagerUtil.getFileType(str);
                LiteActivity liteActivity3 = LiteActivity.this;
                SessionInfo sessionInfo = liteActivity3.f32042c0;
                teamWorkFileImportInfo.f292070d = sessionInfo.f179555d;
                teamWorkFileImportInfo.f292072e = sessionInfo.f179557e;
                teamWorkFileImportInfo.J = 1;
                teamWorkFileImportInfo.f292078h0 = this.f32106d.filesize;
                com.tencent.mobileqq.teamwork.u.e(teamWorkFileImportInfo, this.f32108f, liteActivity3.app, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.dataline.activities.LiteActivity$36, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass36 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Message f32122d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f32123e;
        final /* synthetic */ LiteActivity this$0;

        @Override // java.lang.Runnable
        public void run() {
            CharSequence messageText;
            String j3;
            String str = this.f32122d.senderuin;
            if (str == null || !str.equalsIgnoreCase(this.this$0.app.getCurrentAccountUin())) {
                LiteActivity liteActivity = this.this$0;
                if (!liteActivity.f32062u0) {
                    if (liteActivity.f32048g0 == null) {
                        liteActivity.f32048g0 = new TextView(this.this$0);
                        this.this$0.f32048g0.setId(R.id.msgbox);
                        this.this$0.f32048g0.setSingleLine();
                        LiteActivity liteActivity2 = this.this$0;
                        liteActivity2.f32048g0.setBackgroundDrawable(liteActivity2.getResources().getDrawable(R.drawable.f160452hj));
                        this.this$0.f32048g0.setGravity(17);
                        this.this$0.f32048g0.setTextSize(2, 14.0f);
                        this.this$0.f32048g0.setBackgroundResource(R.drawable.f160452hj);
                        LiteActivity liteActivity3 = this.this$0;
                        liteActivity3.f32048g0.setTextColor(liteActivity3.getResources().getColorStateList(R.color.skin_float_btn));
                        LiteActivity liteActivity4 = this.this$0;
                        liteActivity4.f32048g0.setPadding((int) (((IphoneTitleBarActivity) liteActivity4).mDensity * 10.0f), this.this$0.f32048g0.getPaddingTop(), (int) (((IphoneTitleBarActivity) this.this$0).mDensity * 10.0f), this.this$0.f32048g0.getPaddingBottom());
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.this$0.getResources().getDimension(R.dimen.f158856qt));
                        LiteActivity liteActivity5 = this.this$0;
                        liteActivity5.f32049h0.addView(liteActivity5.f32048g0, layoutParams);
                        LiteActivity liteActivity6 = this.this$0;
                        liteActivity6.f32048g0.setOnClickListener(liteActivity6);
                    }
                    this.this$0.f32048g0.setVisibility(0);
                    Message message = this.f32122d;
                    int i3 = message.msgtype;
                    if (i3 == -2016) {
                        String[] split = message.f203106msg.split("\\|");
                        if (split != null && split.length > 0) {
                            messageText = split[0].trim();
                        } else {
                            messageText = "";
                        }
                    } else if (i3 == -2011) {
                        AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(message.msgData);
                        if (d16 != null) {
                            messageText = d16.mMsgBrief;
                        } else {
                            messageText = this.f32122d.f203106msg;
                        }
                    } else {
                        messageText = message.getMessageText();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    if (this.f32122d.nickName != null) {
                        sb5.append("[");
                        sb5.append(c61.a.a(this.f32123e.getStringExtra("uinname")));
                        sb5.append("] ");
                        sb5.append(c61.a.a(this.f32122d.nickName));
                    } else {
                        String stringExtra = this.f32123e.getStringExtra("uinname");
                        if (stringExtra != null && stringExtra.length() != 0) {
                            int i16 = this.f32122d.istroop;
                            if (7000 == i16) {
                                String stringExtra2 = this.f32123e.getStringExtra("subAccountLatestNick");
                                if (stringExtra2 == null || stringExtra2.length() == 0) {
                                    stringExtra2 = this.f32122d.senderuin;
                                }
                                sb5.append(stringExtra);
                                sb5.append("-");
                                sb5.append(stringExtra2);
                            } else if (1010 != i16 && 1001 != i16 && 10002 != i16) {
                                sb5.append(c61.a.a(stringExtra));
                            } else {
                                if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(this.f32122d.frienduin)) {
                                    j3 = com.tencent.mobileqq.utils.ac.j(this.this$0.app, this.f32122d.senderuin);
                                    if (TextUtils.isEmpty(j3)) {
                                        j3 = this.f32122d.senderuin;
                                    }
                                } else {
                                    j3 = com.tencent.mobileqq.utils.ac.j(this.this$0.app, this.f32122d.frienduin);
                                    if (TextUtils.isEmpty(j3)) {
                                        j3 = this.f32122d.frienduin;
                                    }
                                }
                                sb5.append(stringExtra);
                                sb5.append("-");
                                sb5.append(j3);
                                if (this.f32122d.msgtype == -1024) {
                                    messageText = String.format(this.this$0.getResources().getString(R.string.ffq), j3);
                                }
                            }
                        } else {
                            sb5.append(this.f32122d.frienduin);
                        }
                    }
                    sb5.append(MsgSummary.STR_COLON);
                    if (messageText instanceof QQText) {
                        try {
                            this.this$0.f32048g0.setText(((QQText) messageText).append(sb5.toString(), true, 1, 16));
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(LiteActivity.f32035e1, 2, e16.toString());
                            }
                        }
                    } else {
                        sb5.append(messageText);
                        this.this$0.f32048g0.setText(sb5.toString());
                    }
                    this.this$0.f32048g0.requestLayout();
                    this.this$0.f32048g0.setTag(this.f32123e);
                    Handler handler = this.this$0.f32048g0.getHandler();
                    if (handler != null) {
                        handler.removeCallbacks(this.this$0.f32045d1);
                        handler.postDelayed(this.this$0.f32045d1, 10000L);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (LiteActivity.this.f32057p0.getLineCount() > 3 && !LiteActivity.this.L0 && !SimpleUIUtil.getSimpleUISwitch()) {
                LiteActivity.this.P0.setVisibility(0);
            } else {
                LiteActivity.this.P0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class aa implements DialogInterface.OnClickListener {
        aa() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ab implements View.OnTouchListener {
        ab() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                LiteActivity.this.f32038a0.s();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ac implements ValueAnimator.AnimatorUpdateListener {
        ac() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LiteActivity.this.f32057p0.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            LiteActivity.this.f32057p0.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ad implements ValueAnimator.AnimatorUpdateListener {
        ad() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LiteActivity.this.N0.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            LiteActivity.this.N0.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ah implements DataLineMsgProxy.a {
        ah() {
        }

        @Override // com.tencent.mobileqq.app.proxy.DataLineMsgProxy.a
        public void a(int i3) {
            if (LiteActivity.this.isFinishing() || LiteActivity.this.isDestroyed()) {
                return;
            }
            if (i3 > 0) {
                LiteActivity.this.f32053l0.e();
                LiteActivity.this.f32053l0.notifyDataSetChanged();
                LiteActivity.this.f32046e0.setSelectionFromBottom(i3, 0);
            }
            LiteActivity.this.f32046e0.springBackOverScrollHeaderView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class aj implements InputFilter {
        aj() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int length = 4500 - (spanned.length() - (i18 - i17));
            if (length <= 0) {
                LiteActivity.this.S4();
                return "";
            }
            if (length >= i16 - i3) {
                return null;
            }
            int i19 = length + i3;
            if (!Character.isHighSurrogate(charSequence.charAt(i19 - 1)) || i19 - 1 != i3) {
                LiteActivity.this.S4();
                return charSequence.subSequence(i3, i19);
            }
            LiteActivity.this.S4();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ak {
        void onResult(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface al {
        void a(Bitmap bitmap, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class am {

        /* renamed from: a, reason: collision with root package name */
        LiteActivity f32156a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<String> f32157b;

        /* renamed from: c, reason: collision with root package name */
        int f32158c;

        public am(LiteActivity liteActivity) {
            this.f32156a = liteActivity;
        }

        public void a(Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                if (intent.getBooleanExtra("dataline_share_finish", false)) {
                    return;
                }
                intent.putExtra("dataline_share_finish", true);
                String type = intent.getType();
                if (TextUtils.isEmpty(type)) {
                    return;
                }
                if (extras == null) {
                    QLog.e(LiteActivity.f32035e1, 1, "LiteJumpAction:doShare type is [" + type + "], action is [" + intent.getAction() + "]");
                    return;
                }
                if (type.startsWith("text") && !extras.containsKey("android.intent.extra.STREAM")) {
                    this.f32156a.D4(extras.getString("android.intent.extra.TEXT"));
                    return;
                }
                if (type.startsWith("message")) {
                    this.f32156a.D4(((SpannableString) extras.get("android.intent.extra.TEXT")).toString());
                    return;
                }
                if (type.startsWith("image")) {
                    if (intent.getAction().equals("android.intent.action.SEND")) {
                        Uri uri = (Uri) extras.get("android.intent.extra.STREAM");
                        if (uri == null) {
                            LiteActivity.Q4(LiteActivity.this);
                            return;
                        }
                        ArrayList<Uri> arrayList = new ArrayList<>();
                        arrayList.add(uri);
                        c(arrayList, true);
                        return;
                    }
                    ArrayList<Uri> arrayList2 = (ArrayList) extras.get("android.intent.extra.STREAM");
                    if (arrayList2.size() > 50) {
                        LiteActivity.P4(LiteActivity.this);
                        return;
                    } else {
                        c(arrayList2, true);
                        return;
                    }
                }
                if (intent.getAction().equals("android.intent.action.SEND")) {
                    Uri uri2 = (Uri) extras.get("android.intent.extra.STREAM");
                    if (uri2 == null) {
                        LiteActivity.Q4(LiteActivity.this);
                        return;
                    }
                    if ("text/x-vcard".equals(type) && "content".equals(uri2.getScheme())) {
                        new ap().execute(LiteActivity.this.getApplicationContext(), uri2);
                        return;
                    }
                    ArrayList<Uri> arrayList3 = new ArrayList<>();
                    arrayList3.add(uri2);
                    c(arrayList3, false);
                    return;
                }
                c((ArrayList) extras.get("android.intent.extra.STREAM"), false);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        String b(Uri uri) {
            return FileProvider7Helper.getRealPathFromContentURI(LiteActivity.this.getApplicationContext(), uri);
        }

        void c(ArrayList<Uri> arrayList, boolean z16) {
            if (arrayList == null) {
                LiteActivity.Q4(LiteActivity.this);
                return;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            if (arrayList.size() == 1) {
                String b16 = b(arrayList.get(0));
                if (!TextUtils.isEmpty(b16) && new VFSFile(b16).canRead()) {
                    arrayList2.add(b16);
                } else {
                    arrayList2.add(LiteActivity.this.S3(arrayList.get(0)));
                    this.f32157b = arrayList2;
                    this.f32158c = z16 ? 1 : 0;
                    return;
                }
            } else {
                Iterator<Uri> it = arrayList.iterator();
                while (it.hasNext()) {
                    String b17 = b(it.next());
                    if (!TextUtils.isEmpty(b17)) {
                        arrayList2.add(b17);
                    }
                }
            }
            LiteActivity.this.z4(arrayList2, z16 ? 1 : 0);
        }

        public void d() {
            if (this.f32157b == null || this.f32158c == -1) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(LiteActivity.f32035e1, 1, "sendMultipleFileWithFileProvider. [fileType] = " + this.f32158c);
                Iterator<String> it = this.f32157b.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    QLog.i(LiteActivity.f32035e1, 1, "[filePath] = " + next);
                }
            }
            LiteActivity.this.z4(this.f32157b, this.f32158c);
            this.f32157b = null;
            this.f32158c = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class an extends AsyncTask<Bundle, Integer, Void> {
        an() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Bundle... bundleArr) {
            ArrayList<String> stringArrayList = bundleArr[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
            if (stringArrayList == null) {
                return null;
            }
            d(stringArrayList);
            return null;
        }

        DataLineMsgRecord b(String str, int i3, int i16, int i17) {
            DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
            dataLineMsgRecord.path = str;
            dataLineMsgRecord.msgtype = -2000;
            dataLineMsgRecord.groupId = i3;
            dataLineMsgRecord.groupSize = i16;
            dataLineMsgRecord.groupIndex = i17;
            return dataLineMsgRecord;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r26) {
            LiteActivity.this.p4(false);
        }

        void d(List<String> list) {
            DataLineHandler dataLineHandler = (DataLineHandler) LiteActivity.this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            while (true) {
                int size = list.size();
                int i3 = 0;
                if (size <= 3) {
                    while (i3 < size) {
                        i3++;
                    }
                    return;
                }
                if (size > 3 && size < 50) {
                    ArrayList arrayList = new ArrayList();
                    int s36 = dataLineHandler.s3();
                    while (i3 < size) {
                        arrayList.add(b(list.get(i3), s36, size, i3));
                        i3++;
                    }
                    com.dataline.util.b.m(LiteActivity.this.app);
                    LiteActivity.this.finish();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                int s37 = dataLineHandler.s3();
                for (int i16 = 0; i16 < 50; i16++) {
                    arrayList2.add(b(list.get(i16), s37, 50, i16));
                }
                com.dataline.util.b.m(LiteActivity.this.app);
                LiteActivity.this.finish();
                for (int i17 = 0; i17 < 50; i17++) {
                    list.remove(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ao extends AsyncTask<Bundle, Integer, Void> {
        ao() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Bundle... bundleArr) {
            bundleArr[0].getStringArrayList("PhotoConst.PHOTO_PATHS");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r26) {
            LiteActivity.this.p4(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ap extends AsyncTask<Object, Void, Uri> {
        ap() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.io.OutputStream] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Uri doInBackground(Object... objArr) {
            String str;
            VFSFileOutputStream vFSFileOutputStream;
            StringBuilder sb5;
            Context context = (Context) objArr[0];
            Uri uri = (Uri) objArr[1];
            String str2 = AppConstants.SDCARD_SHARE_VCARD;
            ContentResolver contentResolver = context.getContentResolver();
            ?? r56 = {InputMethodUtil.SOUGOU_URI_DISPLAYNAME};
            Cursor query = ContactsMonitor.query(contentResolver, uri, r56, null, null, null);
            if (query != null && query.moveToFirst()) {
                str = query.getString(0);
                query.close();
            } else {
                if (query != null) {
                    query.close();
                }
                str = "save_contact.vcf";
            }
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (!FileUtils.fileExists(str2)) {
                        new VFSFile(str2).mkdirs();
                    }
                    vFSFileOutputStream = new VFSFileOutputStream(new VFSFile(str2 + str));
                } catch (Exception e16) {
                    e = e16;
                    vFSFileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    r56 = 0;
                    if (0 != 0) {
                    }
                    if (r56 != 0) {
                    }
                    Uri.parse("file://" + str2 + str);
                    throw th;
                }
                try {
                    AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                    if (openAssetFileDescriptor != null) {
                        fileInputStream = openAssetFileDescriptor.createInputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            vFSFileOutputStream.write(bArr, 0, read);
                        }
                        vFSFileOutputStream.flush();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    try {
                        vFSFileOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    sb5 = new StringBuilder();
                } catch (Exception e19) {
                    e = e19;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (vFSFileOutputStream != null) {
                        try {
                            vFSFileOutputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    sb5 = new StringBuilder();
                    sb5.append("file://");
                    sb5.append(str2);
                    sb5.append(str);
                    return Uri.parse(sb5.toString());
                }
                sb5.append("file://");
                sb5.append(str2);
                sb5.append(str);
                return Uri.parse(sb5.toString());
            } catch (Throwable th6) {
                th = th6;
                if (0 != 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                }
                if (r56 != 0) {
                    try {
                        r56.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                Uri.parse("file://" + str2 + str);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @TargetApi(17)
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Uri uri) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(path);
                LiteActivity.this.z4(arrayList, 0);
            } else if (!LiteActivity.this.isFinishing() && !LiteActivity.this.isDestroyed()) {
                LiteActivity.Q4(LiteActivity.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32163d;

        b(long j3) {
            this.f32163d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (LiteActivity.this.getIntent().getIntExtra("forward_type", -1) == 11) {
                ReportCenter.f().p(LiteActivity.this.app.getAccount(), "", String.valueOf(this.f32163d), "1000", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "0", false);
            }
            if (QLog.isColorLevel()) {
                QLog.i(LiteActivity.f32035e1, 2, "qbShowShareResultDialog stay");
            }
            if (LiteActivity.this.getIntent().getBooleanExtra("MigSdkShareNotDone", false)) {
                LiteActivity.this.getIntent().putExtra("MigSdkShareNotDone", false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32165d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f32166e;

        c(long j3, Context context) {
            this.f32165d = j3;
            this.f32166e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (LiteActivity.this.getIntent().getIntExtra("forward_type", -1) == 11) {
                ReportCenter.f().p(LiteActivity.this.app.getAccount(), "", String.valueOf(this.f32165d), "1000", "51", "0", false);
            }
            if (QLog.isColorLevel()) {
                QLog.i(LiteActivity.f32035e1, 2, "qbShowShareResultDialog back");
            }
            if (LiteActivity.this.getIntent().getBooleanExtra("MigSdkShareNotDone", false)) {
                LiteActivity.this.getIntent().putExtra("MigSdkShareNotDone", false);
                ForwardSdkBaseOption.F(LiteActivity.this, true, "sendToMyComputer", this.f32165d);
            } else {
                ForwardSdkBaseOption.F(LiteActivity.this, true, "shareToQQ", this.f32165d);
            }
            com.tencent.biz.common.util.k.k(this.f32166e, 0, "", "");
            if (LiteActivity.this.g4()) {
                LiteActivity.this.finish();
            }
            if (LiteActivity.this.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
                try {
                    LiteActivity.this.getActivity().moveTaskToBack(true);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LiteActivity.f32035e1, 2, "qbShowShareResultDialog ", th5);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class e implements BubblePopupWindow.OnDismissListener {
        e() {
        }

        @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
        public void onDismiss() {
            LiteActivity.this.Y0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.activity.aio.l.f179531g = true;
            com.tencent.mobileqq.statistics.s.a(LiteActivity.this.app.getApplication().getApplicationContext(), LiteActivity.this.app.getCurrentAccountUin(), "dl_ckadv");
            com.dataline.compose.d dVar = com.dataline.compose.d.f32301a;
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(LiteActivity.this, dVar.a(dVar.b(LiteActivity.this.f32051j0), 7));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.activity.aio.l.f179531g = true;
            LiteActivity.this.z3((com.dataline.util.h) ((com.dataline.util.h) view.getTag()).clone());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.activity.aio.l.f179531g = true;
            LiteActivity.this.y3((com.dataline.util.h) view.getTag());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class i implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DataLineMsgSet f32172d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.dataline.util.h f32173e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f32174f;

        i(DataLineMsgSet dataLineMsgSet, com.dataline.util.h hVar, ActionSheet actionSheet) {
            this.f32172d = dataLineMsgSet;
            this.f32173e = hVar;
            this.f32174f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                if (this.f32172d.getGroupType() == -1000) {
                    LiteActivity.this.t4(this.f32173e.j().f32445c, this.f32173e.j().f32446d, -1);
                } else if (this.f32172d.getGroupType() == -2000) {
                    this.f32172d.setPaused(false);
                    Iterator<DataLineMsgRecord> it = this.f32172d.values().iterator();
                    while (it.hasNext()) {
                        DataLineMsgRecord next = it.next();
                        if (DataLineMsgSet.isCanReciveOrResend(next)) {
                            LiteActivity.this.t4(next.path, next.sessionid, 0);
                        }
                    }
                } else if (this.f32172d.getGroupType() == -2005 || this.f32172d.getGroupType() == -2009) {
                    this.f32172d.setPaused(false);
                    Iterator<DataLineMsgRecord> it5 = this.f32172d.values().iterator();
                    while (it5.hasNext()) {
                        DataLineMsgRecord next2 = it5.next();
                        if (DataLineMsgSet.isCanReciveOrResend(next2)) {
                            LiteActivity.this.t4(next2.path, next2.sessionid, 2);
                        }
                    }
                }
            }
            this.f32174f.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class k implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f32177d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DataLineMsgSet f32178e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f32179f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ActionSheet f32180h;

        k(long j3, DataLineMsgSet dataLineMsgSet, List list, ActionSheet actionSheet) {
            this.f32177d = j3;
            this.f32178e = dataLineMsgSet;
            this.f32179f = list;
            this.f32180h = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                LiteActivity.this.a5(this.f32177d, this.f32178e, this.f32179f, false);
            }
            this.f32180h.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class l implements QQBlur.a {

        /* renamed from: a, reason: collision with root package name */
        private View f32182a;

        l() {
            this.f32182a = LiteActivity.this.findViewById(R.id.fyc);
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.a
        public boolean a() {
            if (!LiteActivity.this.f32046e0.isDirty() && !this.f32182a.isDirty()) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class m implements View.OnLongClickListener {
        m() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            com.tencent.mobileqq.activity.aio.l.f179531g = true;
            HapticUtil.INSTANCE.play(view);
            boolean N4 = LiteActivity.this.N4(view);
            EventCollector.getInstance().onViewLongClicked(view);
            return N4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class n implements View.OnTouchListener {
        n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                LiteActivity.this.Z0.x = motionEvent.getRawX();
                LiteActivity.this.Z0.y = motionEvent.getRawY();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class o implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f32186d;

        o(List list) {
            this.f32186d = list;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DataLineHandler dataLineHandler = (DataLineHandler) LiteActivity.this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            dataLineHandler.x4(113);
            dataLineHandler.f4(116);
            ArrayList arrayList = new ArrayList();
            for (DataLineMsgRecord dataLineMsgRecord : this.f32186d) {
                if (dataLineMsgRecord.fileMsgStatus == 1 && dataLineMsgRecord.strMoloKey != null) {
                    com.dataline.util.b.g(LiteActivity.this.app);
                }
                arrayList.add(Long.valueOf(dataLineMsgRecord.sessionid));
            }
            dataLineHandler.c4(arrayList);
            LiteActivity.this.f32053l0.notifyDataSetChanged();
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class p implements DialogInterface.OnClickListener {
        p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class q extends FMObserver {
        q() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d(LiteActivity.f32035e1, 2, "OnFileTransferEnd : isSuccess[" + z16 + "], uniseq[" + j3 + "], nSessionId[" + j16 + str + "], peerType[" + i3 + "]");
            }
            FileManagerEntity D = LiteActivity.this.app.getFileManagerDataCenter().D(j16);
            if (D == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(LiteActivity.f32035e1, 2, "OnFileTransferEnd faild, get entity is faild, sessionId[" + String.valueOf(j16) + "]");
                    return;
                }
                return;
            }
            if (z16) {
                FileManagerUtil.dealWithTransFileSuc(j16);
                return;
            }
            int i17 = D.nOpType;
            if (i17 == 4 || i17 == 6) {
                FileManagerUtil.dealWithTransFileFaild(j16, i16, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class r implements ViewTreeObserver.OnGlobalLayoutListener {
        r() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int bottom = LiteActivity.this.f32046e0.getBottom() - LiteActivity.this.N0.getTop();
            if (LiteActivity.this.N0.getVisibility() == 0 && LiteActivity.this.f32046e0.getPaddingBottom() != bottom) {
                XListView xListView = LiteActivity.this.f32046e0;
                xListView.setPadding(xListView.getPaddingLeft(), LiteActivity.this.f32046e0.getPaddingTop(), LiteActivity.this.f32046e0.getPaddingRight(), bottom);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class s extends QQPermission.BasePermissionsListener {
        s() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class t implements PhotoListPanel.i {
        t() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class v implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InputStream f32196d;

        v(InputStream inputStream) {
            this.f32196d = inputStream;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                this.f32196d.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            LiteActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class w implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f32198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InputStream f32199e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f32200f;

        w(String str, InputStream inputStream, long j3) {
            this.f32198d = str;
            this.f32199e = inputStream;
            this.f32200f = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                LiteActivity.this.w3(this.f32198d, this.f32199e, this.f32200f);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(LiteActivity.f32035e1, 2, "copy file error", e16);
                }
                LiteActivity liteActivity = LiteActivity.this;
                liteActivity.O4(liteActivity.L3());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class x implements DialogInterface.OnClickListener {
        x() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LiteActivity.this.E0 = false;
            LiteActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class y implements DialogInterface.OnDismissListener {
        y() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (LiteActivity.this.E0) {
                LiteActivity.this.E0 = false;
                LiteActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class z implements DialogInterface.OnClickListener {
        z() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LiteActivity.this.finish();
        }
    }

    static void A3(final String str, final Context context, final ak akVar) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.19
            @Override // java.lang.Runnable
            public void run() {
                String e16 = n0.a.e(context, str);
                ak akVar2 = akVar;
                if (akVar2 != null) {
                    akVar2.onResult(e16);
                }
            }
        });
    }

    private boolean C3() {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.d(f32035e1, 1, "qqAppInterface is null");
            return false;
        }
        if (!QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").containsKey("dataLineReportMMKVTag" + qQAppInterface.getCurrentUin()) && 0.1d >= Math.random()) {
            return true;
        }
        return false;
    }

    public static void C4(QQAppInterface qQAppInterface, String str, Context context) {
        A3(str, context, new ak() { // from class: com.dataline.activities.LiteActivity.18
            @Override // com.dataline.activities.LiteActivity.ak
            public void onResult(String str2) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.dataline.activities.LiteActivity.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
    }

    private static void D3(String str) {
        VFSFile vFSFile = new VFSFile(str);
        if (!vFSFile.exists()) {
            return;
        }
        for (VFSFile vFSFile2 : vFSFile.listFiles()) {
            if (System.currentTimeMillis() - vFSFile2.lastModified() > 86400000) {
                vFSFile2.delete();
            }
        }
    }

    static Drawable F4(Context context, String str) {
        Shader.TileMode tileMode;
        Bitmap bitmap;
        int i3;
        try {
            Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
            Drawable drawable = context.getResources().getDrawable(P3());
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
                tileMode = ((BitmapDrawable) drawable).getTileModeX();
                i3 = ((BitmapDrawable) drawable).getGravity();
            } else if (drawable instanceof SkinnableBitmapDrawable) {
                bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                tileMode = ((SkinnableBitmapDrawable) drawable).getTileModeX();
                i3 = ((SkinnableBitmapDrawable) drawable).getGravity();
            } else {
                tileMode = tileMode2;
                bitmap = null;
                i3 = 119;
            }
            if (bitmap != null && tileMode != Shader.TileMode.REPEAT && i3 == 48) {
                ChatBackgroundDrawable chatBackgroundDrawable = new ChatBackgroundDrawable(context.getResources(), bitmap);
                chatBackgroundDrawable.setGravity(i3);
                return chatBackgroundDrawable;
            }
            return context.getResources().getDrawable(P3());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("LiteActivity setAIOBackgroundBmp 2", 2, e16.getMessage());
            }
            return context.getResources().getDrawable(R.drawable.gub);
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("LiteActivity setAIOBackgroundBmp 1", 2, e17.getMessage());
            }
            return context.getResources().getDrawable(R.drawable.gub);
        }
    }

    public static void G4(IphoneTitleBarActivity iphoneTitleBarActivity, ViewGroup viewGroup) {
        SharedPreferences mMKVData = ChatBackgroundUtil.getMMKVData(iphoneTitleBarActivity, iphoneTitleBarActivity.app.getCurrentAccountUin());
        String str = AppConstants.DATALINE_PC_UIN;
        String[] strArr = {str, AppConstants.Preferences.CHAT_UNIFORM_BG_PATH};
        if (mMKVData.getString(str, null) == null && mMKVData.getString(strArr[1], null) == null) {
            H4(iphoneTitleBarActivity, viewGroup, "null");
            return;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            String string = mMKVData.getString(strArr[i3], null);
            if (string != null) {
                if (!"".equals(string) && !"null".equals(string) && !"none".equals(string)) {
                    if (!new VFSFile(string).exists()) {
                        H4(iphoneTitleBarActivity, viewGroup, "null");
                        return;
                    } else if (H4(iphoneTitleBarActivity, viewGroup, string)) {
                        return;
                    }
                } else {
                    H4(iphoneTitleBarActivity, viewGroup, string);
                    return;
                }
            }
        }
        H4(iphoneTitleBarActivity, viewGroup, "null");
    }

    private void H3() {
        if (this.f32062u0 && !g4()) {
            RouteUtils.startActivity(this, new Intent(), RouterConstants.UI_ROUTER_SPLASH);
        }
    }

    static boolean H4(final IphoneTitleBarActivity iphoneTitleBarActivity, final ViewGroup viewGroup, final String str) {
        String str2 = (String) viewGroup.getTag(R.id.f163835o);
        if (str != null && !"".equals(str) && !"null".equals(str)) {
            if ("none".equals(str)) {
                viewGroup.setBackgroundDrawable(F4(iphoneTitleBarActivity, str));
                viewGroup.setTag(R.id.f163835o, "null");
                return true;
            }
            if (!str.equals(str2)) {
                M3(str, new al() { // from class: com.dataline.activities.LiteActivity.14
                    @Override // com.dataline.activities.LiteActivity.al
                    public void a(final Bitmap bitmap, final boolean z16) {
                        if (bitmap != null || z16) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.dataline.activities.LiteActivity.14.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Drawable chatBackgroundDrawable;
                                    if (z16) {
                                        Drawable drawable = IphoneTitleBarActivity.this.getResources().getDrawable(LiteActivity.d3());
                                        Bundle bundle = new Bundle();
                                        bundle.putBoolean("key_use_rect", true);
                                        bundle.putBoolean("key_double_bitmap", true);
                                        chatBackgroundDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "-chatBg-", drawable, new int[]{0}, "-chatBg-", bundle);
                                    } else {
                                        chatBackgroundDrawable = new ChatBackgroundDrawable(IphoneTitleBarActivity.this.getResources(), bitmap);
                                    }
                                    viewGroup.setBackgroundDrawable(chatBackgroundDrawable);
                                    AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                    viewGroup.setTag(R.id.f163835o, str);
                                    viewGroup.setTag(R.id.f163834n, chatBackgroundDrawable);
                                    LiteActivity.l3(IphoneTitleBarActivity.this);
                                }
                            });
                        }
                    }
                });
                return true;
            }
            return true;
        }
        if (!"null".equals(str2)) {
            viewGroup.setBackgroundDrawable(F4(iphoneTitleBarActivity, str));
            viewGroup.setTag(R.id.f163835o, "null");
            return true;
        }
        return true;
    }

    private void J4(View view) {
        VideoReport.setPageId(view, "pg_aio");
        HashMap hashMap = new HashMap();
        VideoReport.resetPageParams(view);
        hashMap.put("type_aio_pg", String.valueOf(5));
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.setPageContentId(view, String.valueOf(SystemClock.elapsedRealtime()), true);
    }

    static void M3(final String str, final al alVar) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.15
            @Override // java.lang.Runnable
            public void run() {
                if (ChatBackgroundManager.t(new File(str))) {
                    alVar.a(null, true);
                    return;
                }
                Bitmap c16 = com.tencent.mobileqq.util.j.c(str);
                al alVar2 = alVar;
                if (alVar2 != null) {
                    alVar2.a(c16, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O4(String str) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(this, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(getString(R.string.f173206i10));
        qQCustomDialog.setMessage(str);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setNegativeButton(getString(R.string.button_back), new z());
        qQCustomDialog.show();
    }

    private static int P3() {
        return R.drawable.qui_common_bg_chat_bg;
    }

    public static void P4(Context context) {
        DialogUtil.createCustomDialog(context, 233, context.getString(R.string.f173206i10), context.getString(R.string.c3z), R.string.c3b, R.string.c3b, new aa(), (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Q3() {
        int i3 = this.f32050i0;
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        return 0;
    }

    public static void Q4(Context context) {
        DialogUtil.createCustomDialog(context, 233, context.getString(R.string.f173206i10), context.getString(R.string.c3q), R.string.c3b, R.string.c3b, new d(), (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R3(DataLineMsgRecord dataLineMsgRecord, int i3) {
        if (i3 == -1000) {
            return 1;
        }
        if (i3 == -2000) {
            return 2;
        }
        if (i3 == -2009) {
            return 4;
        }
        if (i3 != -2005) {
            return 1;
        }
        int fileType = FileManagerUtil.getFileType(dataLineMsgRecord.filename);
        if (fileType == 0) {
            return 3;
        }
        if (fileType == 2) {
            return 6;
        }
        return 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0147: MOVE (r13 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]) (LINE:328), block:B:48:0x0147 */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String S3(Uri uri) {
        Cursor cursor;
        Cursor cursor2;
        ContentResolver contentResolver = getContentResolver();
        String[] strArr = new String[1];
        Cursor cursor3 = null;
        try {
            try {
                cursor = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (cursor3 != null) {
                }
                throw th;
            }
            try {
                if (cursor == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w(f32035e1, 2, "query file failed");
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
                int columnIndex = cursor.getColumnIndex("_size");
                cursor.moveToFirst();
                long j3 = cursor.getLong(columnIndex);
                if (((float) j3) > FileUtils.getAvailableExternalMemorySize()) {
                    f32037g1 = getString(R.string.hiw);
                    cursor.close();
                    return null;
                }
                strArr[0] = cursor.getString(columnIndexOrThrow);
                String str = getExternalCacheDir() + "/share/";
                D3(str);
                String str2 = str + FileUtils.getUnitFileName(str, strArr[0]);
                VFSFile vFSFile = new VFSFile(str);
                if (!vFSFile.exists() && !vFSFile.mkdirs()) {
                    O4(HardCodeUtil.qqStr(R.string.nqf));
                    cursor.close();
                    return null;
                }
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w(f32035e1, 2, "open input stream failed");
                    }
                    cursor.close();
                    return null;
                }
                if (j3 > 209715200) {
                    this.F0 = true;
                    QQCustomDialog qQCustomDialog = new QQCustomDialog(this, R.style.qZoneInputDialog);
                    qQCustomDialog.setContentView(R.layout.f167856jn);
                    qQCustomDialog.setTitle(getString(R.string.f173206i10));
                    qQCustomDialog.setMessage(getString(R.string.b8t));
                    qQCustomDialog.setCanceledOnTouchOutside(false);
                    qQCustomDialog.setCancelable(false);
                    qQCustomDialog.setNegativeButton(getString(R.string.f170647xd), new v(openInputStream));
                    qQCustomDialog.setPositiveButton(getString(R.string.ans), new w(str2, openInputStream, j3));
                    qQCustomDialog.show();
                } else {
                    w3(str2, openInputStream, j3);
                }
                cursor.close();
                return str2;
            } catch (Exception e17) {
                e = e17;
                this.E0 = false;
                if (QLog.isColorLevel()) {
                    QLog.w(f32035e1, 2, "query file error", e);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            cursor3 = cursor2;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S4() {
        QQToast qQToast = new QQToast(this);
        qQToast.setToastIcon(QQToast.getIconRes(1));
        qQToast.setType(1);
        qQToast.setDuration(2000);
        qQToast.setToastMsg(R.string.c8h);
        qQToast.show();
    }

    private View U4() {
        long currentTimeMillis = System.currentTimeMillis();
        PhotoListPanel photoListPanel = (PhotoListPanel) View.inflate(this, R.layout.f168785ar4, null);
        this.f32040b0 = photoListPanel;
        photoListPanel.setCustomOnClickListener(this);
        Intent intent = new Intent();
        String account = this.app.getAccount();
        String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(account), f32035e1);
        String customFaceFilePath = this.app.getCustomFaceFilePath(1, account, 0);
        intent.putExtra("key_my_uin", account);
        intent.putExtra("key_my_nick", nickWithUid);
        intent.putExtra("key_my_head_dir", customFaceFilePath);
        intent.putExtra("key_disable_presend", true);
        intent.putExtra("key_disable_quality_cb", true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 5);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 50);
        intent.putExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, 100000002432L);
        intent.putExtra(PeakConstants.CUSTOM_PHOTOLIST_PANEL_EDITBTN_REPORT_ACTION_NAME, "0X8005F28");
        this.f32040b0.u(this.app, this, this.f32042c0, intent);
        this.f32040b0.setSelectLimitListener(new t());
        if (QLog.isColorLevel()) {
            QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return this.f32040b0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W3(DataLineMsgSet dataLineMsgSet, DataLineMsgRecord dataLineMsgRecord, int i3) {
        u4(dataLineMsgSet);
        int i16 = 1;
        if (i3 != -2000 && i3 == -2005) {
            i16 = FileManagerUtil.getFileType(dataLineMsgRecord.filename) == 0 ? 3 : 2;
        }
        int Q3 = Q3();
        QQAppInterface qQAppInterface = this.app;
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800AD61", "0X800AD61", i16, 0, "" + Q3, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X3(DataLineMsgRecord dataLineMsgRecord, int i3, String str) {
        FileManagerEntity fileManagerEntity;
        int i16;
        int i17;
        com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_save2weiyun");
        long fileSizes = FileUtils.getFileSizes(str);
        String fileName = FileManagerUtil.getFileName(str);
        if (dataLineMsgRecord.nWeiyunSessionId != 0) {
            fileManagerEntity = this.app.getFileManagerDataCenter().D(dataLineMsgRecord.nWeiyunSessionId);
        } else {
            fileManagerEntity = null;
        }
        FileManagerEntity fileManagerEntity2 = fileManagerEntity;
        if (FileManagerUtil.is2GOr3G() && fileSizes > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FMDialogUtil.a(getActivity(), R.string.b_v, R.string.b_y, new af(dataLineMsgRecord, fileManagerEntity2, fileName, str));
        } else if (fileManagerEntity2 == null) {
            int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid);
            com.tencent.mobileqq.filemanager.util.d.h(FileManagerUtil.cutLongName(fileName) + getString(R.string.f170976be1));
            dataLineMsgRecord.nWeiyunSessionId = this.app.getFileManagerEngine().F0(str, null, this.app.getAccount(), "", 0, false).nSessionId;
            this.app.getMessageFacade().t1(devTypeBySeId).j(dataLineMsgRecord.msgId);
        } else {
            com.tencent.mobileqq.filemanager.util.d.h(FileManagerUtil.cutLongName(fileName) + getString(R.string.f170976be1));
            this.app.getFileManagerEngine().o0(dataLineMsgRecord.nWeiyunSessionId);
        }
        if (i3 == -2000) {
            i17 = 1;
        } else if (i3 == -2005) {
            int fileType = FileManagerUtil.getFileType(dataLineMsgRecord.filename);
            if (fileType == 0) {
                i17 = 2;
            } else if (fileType == 2) {
                i17 = 3;
            } else {
                i17 = 4;
            }
        } else {
            i16 = 4;
            int Q3 = Q3();
            ReportController.o(this.app, "dc00898", "", "", "0X800AD60", "0X800AD60", i16, 0, "" + Q3, "", "", "");
        }
        i16 = i17;
        int Q32 = Q3();
        ReportController.o(this.app, "dc00898", "", "", "0X800AD60", "0X800AD60", i16, 0, "" + Q32, "", "", "");
    }

    static void Z4(ScrollerRunnable scrollerRunnable, XListView xListView, int i3) {
        if (xListView != null) {
            try {
                scrollerRunnable.t(i3, -1, null, 3, false);
            } catch (IllegalArgumentException unused) {
                xListView.setSelection(i3);
            } catch (SecurityException unused2) {
                xListView.setSelection(i3);
            }
            xListView.setTranscriptMode(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a5(long j3, DataLineMsgSet dataLineMsgSet, List<Long> list, boolean z16) {
        int i3;
        if (!e3(j3)) {
            return;
        }
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        dataLineMsgSet.setPaused(false);
        if (dataLineHandler.c4(list)) {
            Iterator<DataLineMsgRecord> it = dataLineMsgSet.values().iterator();
            while (it.hasNext()) {
                DataLineMsgRecord next = it.next();
                if (DataLineMsgSet.isCanReciveOrResend(next)) {
                    next.bIsResendOrRecvFile = true;
                    next.fileMsgStatus = 0L;
                    next.progress = 0.0f;
                }
            }
            this.f32053l0.notifyDataSetChanged();
            return;
        }
        if (z16) {
            i3 = R.string.ahr;
        } else {
            i3 = R.string.c4x;
        }
        com.tencent.mobileqq.filemanager.util.d.e(i3);
    }

    private void b4() {
        VideoReport.addToDetectionWhitelist(this);
        J4(getWindow().getDecorView());
    }

    private void b5() {
        final com.tencent.mobileqq.config.business.qfile.d datalineConfig = ((IQFileConfigManager) this.app.getRuntimeService(IQFileConfigManager.class)).getDatalineConfig();
        if (!datalineConfig.d()) {
            QLog.d(f32035e1, 1, "Don't need sync");
            return;
        }
        final MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        final String str = this.app.getCurrentAccountUin() + "dataline_record_isSynced";
        if (from.decodeBool(str, false)) {
            return;
        }
        final DataLineMsgProxy dataLineMsgProxy = this.app.getDataLineMsgProxy(0);
        ThreadManagerV2.excute(new Runnable() { // from class: com.dataline.activities.LiteActivity.56
            @Override // java.lang.Runnable
            public void run() {
                if (LiteActivity.this.o4(dataLineMsgProxy)) {
                    from.encodeBool(str, true);
                    datalineConfig.g(LiteActivity.this.app, false);
                    QLog.d(LiteActivity.f32035e1, 2, "sync file assistant record end");
                }
            }
        }, 32, null, true);
    }

    static /* bridge */ /* synthetic */ int d3() {
        return P3();
    }

    private void dismissDialog() {
        QQCustomDialog qQCustomDialog = this.G0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g4() {
        if (SplashActivity.sWeakInstance != null && SplashActivity.sWeakInstance.get() != null) {
            return true;
        }
        return false;
    }

    public static void h4(XListView xListView) {
        if (xListView != null) {
            xListView.setSelection(xListView.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i4(DataLineMsgRecord dataLineMsgRecord, DataLineMsgRecord dataLineMsgRecord2) {
        return Long.compare(dataLineMsgRecord.time, dataLineMsgRecord2.time);
    }

    @TargetApi(19)
    private void initBlur() {
        this.I0 = ThemeUtil.isDefaultOrDIYTheme(false);
        QQBlurView qQBlurView = (QQBlurView) findViewById(R.id.kmg);
        this.H0 = qQBlurView;
        qQBlurView.setVisibility(0);
        if (!this.I0) {
            return;
        }
        this.H0.j(this.mContentView);
        QQBlurView qQBlurView2 = this.H0;
        qQBlurView2.m(qQBlurView2);
        this.H0.z(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
        this.H0.A(8.0f);
        this.H0.l(8);
        this.H0.setDirtyListener(new l());
        this.H0.x();
        this.J0 = new r();
        this.f32046e0.getViewTreeObserver().addOnGlobalLayoutListener(this.J0);
    }

    static void l3(IphoneTitleBarActivity iphoneTitleBarActivity) {
        View findViewById = iphoneTitleBarActivity.findViewById(R.id.ecd);
        if (ThemeUtil.isInNightMode(iphoneTitleBarActivity.app)) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public static void n3(final ScrollerRunnable scrollerRunnable, final XListView xListView) {
        if (xListView != null) {
            xListView.postDelayed(new Runnable() { // from class: com.dataline.activities.LiteActivity.28
                @Override // java.lang.Runnable
                public void run() {
                    if (XListView.this.getCount() > 2) {
                        ScrollerRunnable scrollerRunnable2 = scrollerRunnable;
                        XListView xListView2 = XListView.this;
                        LiteActivity.Z4(scrollerRunnable2, xListView2, xListView2.getCount());
                    }
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o4(DataLineMsgProxy dataLineMsgProxy) {
        if (f32036f1) {
            return false;
        }
        f32036f1 = true;
        QLog.d(f32035e1, 2, "sync file assistant record start");
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.imcore.message.f messageProxy = qQAppInterface.getMessageProxy(0);
        if (messageProxy == null) {
            return false;
        }
        List<MessageRecord> e16 = ((com.tencent.mobileqq.persistence.g) messageProxy.D()).e("select * from " + MessageRecord.getTableName(AppConstants.DATALINE_NEW_VERSION_UIN, 0), new String[0]);
        if (e16 != null && !e16.isEmpty()) {
            QLog.d(f32035e1, 2, "File assistant records size = " + e16.size());
            List<DataLineMsgRecord> g16 = new com.tencent.mobileqq.filemanager.fileassistant.util.a(qQAppInterface).g(e16, false, null);
            HashSet hashSet = new HashSet();
            Iterator<DataLineMsgRecord> it = g16.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(it.next().msgseq));
            }
            List<DataLineMsgRecord> p16 = dataLineMsgProxy.p();
            if (p16 != null && !p16.isEmpty()) {
                for (DataLineMsgRecord dataLineMsgRecord : p16) {
                    if (!dataLineMsgRecord.isSend() && !hashSet.contains(Long.valueOf(dataLineMsgRecord.msgseq))) {
                        g16.add(dataLineMsgRecord);
                    }
                }
            }
            Collections.sort(g16, new Comparator() { // from class: com.dataline.activities.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i46;
                    i46 = LiteActivity.i4((DataLineMsgRecord) obj, (DataLineMsgRecord) obj2);
                    return i46;
                }
            });
            dataLineMsgProxy.j();
            Iterator<DataLineMsgRecord> it5 = g16.iterator();
            while (it5.hasNext()) {
                dataLineMsgProxy.h(it5.next());
            }
        } else {
            QLog.d(f32035e1, 2, "File assistant records is empty");
        }
        f32036f1 = false;
        return true;
    }

    public static boolean p3(QQAppInterface qQAppInterface, long j3) {
        FileManagerEntity D;
        if (j3 == 0 || (D = qQAppInterface.getFileManagerDataCenter().D(j3)) == null) {
            return true;
        }
        if ((D.getCloudType() == 2 || D.status != 1) && D.nOpType == 6 && D.status != 1) {
            return true;
        }
        return false;
    }

    public static boolean r3(QQAppInterface qQAppInterface, DataLineMsgRecord dataLineMsgRecord) {
        return p3(qQAppInterface, dataLineMsgRecord.nWeiyunSessionId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(boolean z16) {
        if (z16) {
            this.f32067z0.setVisibility(0);
            int i3 = this.f32050i0;
            if (i3 == 1) {
                this.A0.setText(R.string.agr);
                return;
            } else {
                if (i3 == 2) {
                    this.A0.setText(R.string.zqh);
                    return;
                }
                return;
            }
        }
        this.f32067z0.setVisibility(4);
    }

    private void s4() {
        final int i3;
        final DataLineMsgProxy dataLineMsgProxy;
        final QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.d(f32035e1, 1, "qqAppInterface is null");
            return;
        }
        final DataLineMsgProxy dataLineMsgProxy2 = qQAppInterface.getDataLineMsgProxy(0);
        boolean isPadDevice = DataLineMsgRecord.isPadDevice();
        final MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        if (isPadDevice) {
            i3 = 2;
            dataLineMsgProxy = qQAppInterface.getDataLineMsgProxy(2);
        } else {
            i3 = 1;
            dataLineMsgProxy = qQAppInterface.getDataLineMsgProxy(1);
        }
        if (dataLineMsgProxy2 != null && dataLineMsgProxy != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.dataline.activities.LiteActivity.57
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap = new HashMap();
                    List<DataLineMsgRecord> p16 = dataLineMsgProxy2.p();
                    String str = "0";
                    if (p16 != null && p16.size() != 0) {
                        QLog.d(LiteActivity.f32035e1, 1, "device_type = 0 , dataLineMsgRecordsPc.size is " + p16.size());
                        hashMap.put("device_type_pc", "0");
                        hashMap.put("msg_count_pc", p16.size() + "");
                    } else {
                        QLog.d(LiteActivity.f32035e1, 1, "device_type = 0 , dataLineMsgRecords is null or empty");
                        hashMap.put("device_type_pc", "0");
                        hashMap.put("msg_count_pc", "0");
                    }
                    List<DataLineMsgRecord> p17 = dataLineMsgProxy.p();
                    if (p17 != null && p17.size() != 0) {
                        QLog.d(LiteActivity.f32035e1, 1, "device_type = " + i3 + " , dataLineMsgRecordsPc.size is " + p17.size());
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(i3);
                        sb5.append("");
                        hashMap.put("device_type_mobile", sb5.toString());
                        hashMap.put("msg_count_mobile", p17.size() + "");
                    } else {
                        QLog.d(LiteActivity.f32035e1, 1, "device_type = " + i3 + " , dataLineMsgRecordsMobile is null or empty");
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(i3);
                        sb6.append("");
                        hashMap.put("device_type_mobile", sb6.toString());
                        hashMap.put("msg_count_mobile", "0");
                    }
                    QQAppInterface qQAppInterface2 = qQAppInterface;
                    if (qQAppInterface2 != null) {
                        str = qQAppInterface2.getCurrentUin();
                    }
                    QLog.d(LiteActivity.f32035e1, 1, "params = " + hashMap);
                    QQBeaconReport.report(str, "dataline_msg_count_info", hashMap);
                    from.encodeBool("dataLineReportMMKVTag" + str, true);
                }
            }, 32, null, true);
        } else {
            QLog.d(f32035e1, 1, "dataLineMsgProxyPc is null or dataLineMsgProxyMobile is null");
        }
    }

    private void send() {
        String obj = this.f32057p0.getText().toString();
        if (obj != null && obj.length() > 0) {
            com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_cktxt");
            D4(new QQText(obj, 45, 32, 6000).toString());
            this.f32057p0.setText("");
            M4();
        }
    }

    private void u4(DataLineMsgSet dataLineMsgSet) {
        ArrayList<DataLineMsgRecord> values;
        boolean z16;
        DataLineMsgRecord dataLineMsgRecord = null;
        if (dataLineMsgSet == null || (values = dataLineMsgSet.values()) == null || values.size() == 0 || (dataLineMsgRecord = dataLineMsgSet.getFirstItem()) == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(getApplicationContext(), getString(R.string.cwa), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        final MessageForPic messageForPic = new MessageForPic();
        messageForPic.size = dataLineMsgRecord.filesize;
        messageForPic.senderuin = dataLineMsgRecord.senderuin;
        messageForPic.selfuin = this.app.getAccount();
        messageForPic.frienduin = dataLineMsgRecord.frienduin;
        messageForPic.time = dataLineMsgRecord.time;
        messageForPic.issend = dataLineMsgRecord.issend;
        messageForPic.uuid = dataLineMsgRecord.serverPath;
        messageForPic.busiType = dataLineMsgRecord.busId;
        messageForPic.istroop = 7;
        messageForPic.subVersion = 5;
        messageForPic.path = dataLineMsgRecord.path;
        QLog.i(f32035e1, 1, "savePicsAsCustomFace, path:" + messageForPic.path + " uuid:" + messageForPic.uuid + " size:" + messageForPic.size);
        if (FileUtils.fileExists(messageForPic.path) && dataLineMsgRecord.md5 == null) {
            QLog.i(f32035e1, 1, "savePicsAsCustomFace, calc md5!");
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.30
                @Override // java.lang.Runnable
                public void run() {
                    MessageForPic messageForPic2 = messageForPic;
                    messageForPic2.md5 = FileUtils.calcMd5(messageForPic2.path);
                    LiteActivity.this.runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.30.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass30 anonymousClass30 = AnonymousClass30.this;
                            LiteActivity.this.v4(messageForPic);
                        }
                    });
                }
            });
        } else {
            messageForPic.md5 = HexUtil.bytes2HexStr(dataLineMsgRecord.md5);
            v4(messageForPic);
        }
    }

    private void v3() {
        int i3;
        DataLineMsgSetList dataLineMsgSetList = this.f32052k0;
        if (dataLineMsgSetList != null) {
            i3 = dataLineMsgSetList.size();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            if (!this.C0 && TextUtils.isEmpty(T3())) {
                s3(true);
                return;
            } else {
                s3(false);
                return;
            }
        }
        s3(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4(MessageForPic messageForPic) {
        if (messageForPic == null) {
            QQToast.makeText(getApplicationContext(), getString(R.string.cwa), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        QLog.i(f32035e1, 1, "savePicsAsCustomFace, md5:" + messageForPic.md5);
        URLDrawable drawable = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL(messageForPic, 1, DataLineFaceDownloader.PROTOCOL_DATALINE_FACE), -1, -1, null, null, false);
        drawable.setTag(messageForPic);
        com.tencent.mobileqq.activity.aio.photo.c.e(this, this.app, drawable, messageForPic.frienduin, getResources().getDimensionPixelSize(R.dimen.title_bar_height), null, messageForPic.picExtraData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3(final String str, final InputStream inputStream, final long j3) {
        this.E0 = true;
        ThreadManagerV2.post(new Runnable() { // from class: com.dataline.activities.LiteActivity.45
            /* JADX WARN: Removed duplicated region for block: B:39:0x011b A[Catch: all -> 0x0151, TryCatch #12 {all -> 0x0151, blocks: (B:19:0x0036, B:37:0x0115, B:39:0x011b, B:40:0x0124), top: B:18:0x0036 }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x012e  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0147 A[Catch: IOException -> 0x014b, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x014b, blocks: (B:47:0x0147, B:89:0x00f9), top: B:2:0x0005 }] */
            /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0155  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x014c -> B:37:0x0150). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Throwable th5;
                FileOutputStream fileOutputStream;
                VFSFile vFSFile;
                byte[] bArr;
                int i3 = 0;
                byte[] bArr2 = null;
                try {
                    try {
                        vFSFile = new VFSFile(str);
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = null;
                    } catch (Throwable th6) {
                        th5 = th6;
                        fileOutputStream = null;
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                if (!vFSFile.exists() && !vFSFile.createNewFile()) {
                    LiteActivity.this.f32064w0.sendEmptyMessage(1);
                    LiteActivity.this.E0 = false;
                    try {
                        inputStream.close();
                        return;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        return;
                    }
                }
                fileOutputStream = new FileOutputStream(str);
                try {
                    try {
                        bArr2 = ByteArrayPool.getGenericInstance().getBuf(8192);
                        long j16 = 0;
                        long j17 = 0;
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                try {
                                    if (!LiteActivity.this.E0) {
                                        break;
                                    }
                                    j16 += read;
                                    fileOutputStream.write(bArr2, i3, read);
                                    double d16 = j16 - j17;
                                    long j18 = j3;
                                    bArr = bArr2;
                                    if (d16 / j18 > 0.1d) {
                                        try {
                                            MqqHandler mqqHandler = LiteActivity.this.f32064w0;
                                            mqqHandler.sendMessage(mqqHandler.obtainMessage(3, (int) ((j16 / j18) * 100.0d), 0));
                                            j17 = j16;
                                        } catch (Exception e19) {
                                            e = e19;
                                            bArr2 = bArr;
                                            if (QLog.isColorLevel()) {
                                            }
                                            LiteActivity.this.f32064w0.sendEmptyMessage(1);
                                            if (bArr2 != null) {
                                            }
                                            LiteActivity.this.E0 = false;
                                            try {
                                                inputStream.close();
                                            } catch (IOException e26) {
                                                e26.printStackTrace();
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                        } catch (Throwable th7) {
                                            th5 = th7;
                                            bArr2 = bArr;
                                            if (bArr2 != null) {
                                            }
                                            LiteActivity.this.E0 = false;
                                            try {
                                                inputStream.close();
                                            } catch (IOException e27) {
                                                e27.printStackTrace();
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                        }
                                    }
                                    bArr2 = bArr;
                                    i3 = 0;
                                } catch (Exception e28) {
                                    e = e28;
                                    if (QLog.isColorLevel()) {
                                        QLog.w(LiteActivity.f32035e1, 2, "resolve file error", e);
                                    }
                                    LiteActivity.this.f32064w0.sendEmptyMessage(1);
                                    if (bArr2 != null) {
                                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                                    }
                                    LiteActivity.this.E0 = false;
                                    inputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    return;
                                } catch (Throwable th8) {
                                    th = th8;
                                    th5 = th;
                                    if (bArr2 != null) {
                                        ByteArrayPool.getGenericInstance().returnBuf(bArr2);
                                    }
                                    LiteActivity.this.E0 = false;
                                    inputStream.close();
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            throw th5;
                                        } catch (IOException e29) {
                                            e29.printStackTrace();
                                            throw th5;
                                        }
                                    }
                                    throw th5;
                                }
                            } catch (Exception e36) {
                                e = e36;
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        }
                        bArr = bArr2;
                        if (j16 == 0) {
                            LiteActivity.f32037g1 = LiteActivity.this.getString(R.string.b8k);
                            LiteActivity.this.f32064w0.sendEmptyMessage(1);
                        }
                        try {
                            if (LiteActivity.this.E0) {
                                MqqHandler mqqHandler2 = LiteActivity.this.f32064w0;
                                mqqHandler2.sendMessage(mqqHandler2.obtainMessage(3, 100, 0));
                                LiteActivity.this.f32064w0.sendEmptyMessageDelayed(2, 200L);
                            } else {
                                IOUtils.closeQuietly(fileOutputStream);
                                vFSFile.delete();
                            }
                            if (bArr != null) {
                                ByteArrayPool.getGenericInstance().returnBuf(bArr);
                            }
                            LiteActivity.this.E0 = false;
                            try {
                                inputStream.close();
                            } catch (IOException e37) {
                                e37.printStackTrace();
                            }
                            fileOutputStream.close();
                        } catch (Exception e38) {
                            e = e38;
                            bArr2 = bArr;
                            if (QLog.isColorLevel()) {
                            }
                            LiteActivity.this.f32064w0.sendEmptyMessage(1);
                            if (bArr2 != null) {
                            }
                            LiteActivity.this.E0 = false;
                            inputStream.close();
                            if (fileOutputStream != null) {
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            bArr2 = bArr;
                            th5 = th;
                            if (bArr2 != null) {
                            }
                            LiteActivity.this.E0 = false;
                            inputStream.close();
                            if (fileOutputStream != null) {
                            }
                        }
                    } catch (Throwable th11) {
                        th = th11;
                    }
                } catch (Exception e39) {
                    e = e39;
                }
            }
        }, 5, null, true);
        if (this.G0 == null) {
            QQCustomDialog createCustomProgressDialog = DialogUtil.createCustomProgressDialog(this, getString(R.string.aex), HardCodeUtil.qqStr(R.string.j6l), new x());
            this.G0 = createCustomProgressDialog;
            createCustomProgressDialog.setOnDismissListener(new y());
        }
        this.G0.show();
    }

    private void w4() {
        am amVar = this.f32060s0;
        if (amVar == null) {
            return;
        }
        amVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent x3(DataLineMsgRecord dataLineMsgRecord, int i3) {
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        intent.putExtra(AppConstants.Key.FORWARD_NT_MSG_ID, dataLineMsgRecord.uniseq);
        intent.putExtra("isFromDataline", true);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID, this.f32042c0.f179557e);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, 8);
        intent.putExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, this.f32042c0.f179555d);
        if (i3 != -2009 && i3 != -2005 && i3 != -2000) {
            if (i3 != -1000) {
                return null;
            }
            intent.putExtra("forward_type", -1);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, dataLineMsgRecord.f203106msg);
            return intent;
        }
        intent.putExtra("forward_type", 0);
        intent.putExtra("forward _key_nojump", true);
        intent.putExtra("not_forward", true);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, dataLineMsgRecord.path);
        if (-2009 == i3) {
            intent.putExtra("datalineFileType", 2);
        }
        if (-2000 == i3) {
            intent.putExtra("datalineFileType", 0);
            return intent;
        }
        return intent;
    }

    void B3() {
        ArrayList arrayList = new ArrayList();
        o oVar = new o(arrayList);
        p pVar = new p();
        Iterator<DataLineMsgSet> it = this.f32052k0.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
            boolean z16 = false;
            while (it5.hasNext()) {
                DataLineMsgRecord next = it5.next();
                if (DataLineMsgSet.isFileType(next) && !next.isread && next.fileMsgStatus == 1) {
                    if (!z16) {
                        i3++;
                        z16 = true;
                    }
                    arrayList.add(next);
                    i16++;
                }
            }
        }
        if (i3 >= 3) {
            String format = String.format(getString(R.string.c5i), Integer.valueOf(i3), Integer.valueOf(i16));
            ((DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).f4(115);
            DialogUtil.createCustomDialog(this, 230, getString(R.string.f171080c42), format, R.string.cancel, R.string.f171077c35, oVar, pVar).show();
        }
    }

    boolean B4(Intent intent, int i3) {
        FileManagerEntity D;
        int S2;
        boolean z16;
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
        if (forwardFileInfo == null || (D = this.app.getFileManagerDataCenter().D(forwardFileInfo.n())) == null || (S2 = DataLineHandler.S2(D)) == 0) {
            return false;
        }
        if (S2 != 1) {
            if (S2 != 2) {
                if (S2 != 3) {
                    QLog.w(f32035e1, 1, "forwardFile fileFrom " + S2 + " is not handled");
                    return false;
                }
                if (i3 == 101) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (f3(forwardFileInfo, z16, this.f32050i0) == null) {
                    return false;
                }
                finish();
            } else if (this.f32050i0 == 0) {
                this.app.getFileManagerEngine().G(forwardFileInfo.n(), forwardFileInfo.q(), forwardFileInfo.k(), Long.parseLong(this.app.getCurrentAccountUin()), "", 7, forwardFileInfo.j());
            } else {
                this.app.getFileManagerEngine().G(forwardFileInfo.n(), forwardFileInfo.q(), forwardFileInfo.k(), Long.parseLong(this.app.getCurrentAccountUin()), "", 6003, forwardFileInfo.j());
            }
        } else {
            this.app.getFileManagerEngine().w(3, forwardFileInfo.n(), this.f32050i0);
        }
        return true;
    }

    void D4(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 4500) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.nqe), 1).show(getTitleBarHeight());
            return;
        }
        if (getIntent().getBooleanExtra("isMigSdkShare", false)) {
            ReportController.o(this.app, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send one from sdk:0X800492D.");
            }
        }
        int i3 = this.f32050i0;
        if (i3 == 1) {
            str2 = AppConstants.DATALINE_IPAD_UIN;
        } else if (i3 == 2) {
            str2 = AppConstants.DATALINE_PHONE_UIN;
        } else {
            str2 = AppConstants.DATALINE_PC_UIN;
        }
        com.tencent.qqnt.mycomputer.utils.c.f359781a.f(str, str2, false, null);
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "sendTextMessage");
        ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this, 8, PeerUid.DATALINE_PC_UID, getResources().getString(R.string.c5f), 0L, new Bundle());
        finish();
        ReportController.o(this.app, "dc00898", "", "", "0X800AD68", "0X800AD68", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public View E2(int i3) {
        boolean z16;
        if (i3 == 4) {
            if (this.U0.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.U0.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new s());
                return null;
            }
            return U4();
        }
        return null;
    }

    protected void E3(int i3, int i16) {
        d5();
        if (i16 == 0) {
            this.C0 = false;
        } else if (1 == i16) {
            this.C0 = true;
        }
        v3();
    }

    void E4(String str) {
        if (str == null) {
            return;
        }
        ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).myComputerSendFileFromPhoto(PeerUid.DATALINE_PC_UID, str);
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "sendMultipleFile");
        ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this, 8, PeerUid.DATALINE_PC_UID, getResources().getString(R.string.c5f), 0L, new Bundle());
        finish();
    }

    void F3(Observable observable, Object obj) {
        updateUnreadNumOnTitleBar();
        if (obj instanceof DataLineMsgRecord) {
            DataLineMsgRecord dataLineMsgRecord = (DataLineMsgRecord) obj;
            DataLineMsgSet v3 = this.app.getDataLineMsgProxy(DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid)).v(dataLineMsgRecord.sessionid);
            if (QLog.isDevelopLevel()) {
                QLog.d("AutoTest_Xandy", 4, "SessionID:" + dataLineMsgRecord.sessionid + ", Show:" + System.currentTimeMillis());
            }
            if (!DataLineMsgSet.isSingle(dataLineMsgRecord) && v3 != null && v3.getComeCount() > 1) {
                if (!this.f32053l0.G(dataLineMsgRecord.sessionid, this.f32046e0)) {
                    this.f32053l0.notifyDataSetChanged();
                }
            } else {
                this.f32053l0.notifyDataSetChanged();
            }
        } else if (obj instanceof Message) {
            String str = ((Message) obj).frienduin;
            if (str == null) {
                return;
            }
            if (str.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
                this.f32053l0.notifyDataSetChanged();
            }
        } else if (obj instanceof RecentUser) {
            String str2 = ((RecentUser) obj).uin;
            if (str2 == null) {
                return;
            }
            if (str2.endsWith(String.valueOf(AppConstants.DATALINE_PC_UIN))) {
                this.f32053l0.notifyDataSetChanged();
            }
        }
        if (obj instanceof ChatMessage) {
            ((MessageRecord) obj).isSendFromLocal();
        }
    }

    public void G3(boolean z16) {
        if (this.T0 == null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null && (childAt instanceof DragFrameLayout)) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.T0 = (TopGestureLayout) childAt2;
            }
        }
        TopGestureLayout topGestureLayout = this.T0;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
    }

    public void I3(ArrayList<String> arrayList) {
        HashMap<String, String> i3;
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1052);
        intent.putExtra(PeakConstants.REQUEST_CODE, 55);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        intent.putExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
        intent.putExtra(PeakConstants.IS_TROOP_SEND_MIXED_MSG, false);
        intent.putExtra(PeakConstants.DISABLE_UPLOAD_TO_TROOP_ALBUM, true);
        intent.putExtra(PeakConstants.UPLOAD_CHECKBOX_IS_CHECKED, true);
        intent.putExtra(PeakConstants.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR, false);
        intent.putExtra(PeakConstants.QZONE_ALBUM_FROM_AIO, true);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 40);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationDataline.F);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationDataline.G);
        int l3 = PlusPanelUtils.l(this.app, this, this.f32042c0, arrayList, intent, activityURIRequest);
        activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, "");
        activityURIRequest.extra().putString(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "");
        activityURIRequest.extra().putInt(com.tencent.mobileqq.utils.d.f307603i, 55);
        activityURIRequest.extra().putBoolean(PeakConstants.SHOW_MAGIC_USE_PASTER, true);
        activityURIRequest.extra().putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 5);
        activityURIRequest.extra().putBoolean(PeakConstants.ALBUM_SHOW_ORI_BUTTON, true);
        if (com.tencent.mobileqq.util.ab.a()) {
            activityURIRequest.extra().putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
        }
        if (l3 != -1) {
            PhotoListPanel photoListPanel = this.f32040b0;
            if (photoListPanel != null && (i3 = photoListPanel.i()) != null) {
                activityURIRequest.extra().putSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP, i3);
            }
            activityURIRequest.setRequestCode(l3);
        }
        QRoute.startUri(activityURIRequest);
        QAlbumUtil.anim(this, false, true);
        com.tencent.mobileqq.hitrate.d dVar = r05.a.f430452a;
        if (dVar != null) {
            dVar.d();
        }
    }

    void I4() {
        for (Long l3 : this.f32054m0) {
            this.app.getMessageFacade().t1(this.f32050i0).m(l3.longValue());
            if (QLog.isColorLevel()) {
                QLog.d(f32035e1, 2, "setMsgFailedWhenQuesting: session = " + l3.longValue());
            }
        }
        this.f32054m0.clear();
    }

    public void J3() {
        this.L0 = true;
        G3(false);
        TextView textView = this.f32048g0;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ViewGroup viewGroup = this.M0;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        this.S0.setVisibility(8);
        this.P0.setVisibility(8);
        this.Q0.setVisibility(0);
        this.R0.setVisibility(0);
        this.R0.setEnabled(this.f32059r0.isEnabled());
        this.O0.getLayoutParams().height = -1;
        this.f32057p0.getLayoutParams().height = -1;
        this.f32057p0.getLayoutParams().width = -1;
        this.f32057p0.setMaxLines(100);
        this.f32057p0.setGravity(48);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.N0.getHeight(), this.N0.getBottom());
        ofInt.addUpdateListener(new ad());
        ofInt.addListener(new ae());
        ofInt.setDuration(100L).setRepeatCount(0);
        ofInt.start();
    }

    DataLineMsgRecord K3(DataLineHandler dataLineHandler, SendInfo sendInfo, int i3, int i16, int i17, int i18) {
        if (sendInfo == null) {
            return null;
        }
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        String c16 = sendInfo.c();
        String e16 = sendInfo.e();
        dataLineMsgRecord.sessionid = sendInfo.b();
        dataLineMsgRecord.path = c16;
        dataLineMsgRecord.thumbPath = e16;
        dataLineMsgRecord.msgtype = DataLineHandler.C4(i3);
        dataLineMsgRecord.groupId = i16;
        dataLineMsgRecord.groupSize = i17;
        dataLineMsgRecord.groupIndex = i18;
        return dataLineMsgRecord;
    }

    protected String L3() {
        String str = f32037g1;
        if (str == null) {
            return getString(R.string.hiy);
        }
        return str;
    }

    void L4(Intent intent) {
        boolean z16 = true;
        if (intent.getIntExtra("aio_msg_source", 999) != 1) {
            z16 = false;
        }
        this.f32065x0 = z16;
        if (z16) {
            com.tencent.mobileqq.activity.aio.l.f179531g = false;
            this.f32066y0 = false;
        }
    }

    void M4() {
        String str;
        int i3;
        Editable editable;
        XEditTextEx xEditTextEx;
        XEditTextEx xEditTextEx2;
        int i16 = this.f32050i0;
        if (i16 == 1) {
            str = AppConstants.DATALINE_IPAD_UIN;
            i3 = 6003;
        } else if (i16 == 2) {
            str = AppConstants.DATALINE_PHONE_UIN;
            i3 = 6005;
        } else {
            str = AppConstants.DATALINE_PC_UIN;
            i3 = 6000;
        }
        String str2 = str;
        int i17 = i3;
        XEditTextEx xEditTextEx3 = this.f32057p0;
        if (xEditTextEx3 != null) {
            editable = xEditTextEx3.getText();
        } else {
            editable = null;
        }
        String T3 = T3();
        if (StringUtil.isEmpty(T3) && (xEditTextEx2 = this.f32057p0) != null && StringUtil.isEmpty(String.valueOf(xEditTextEx2.getText()))) {
            return;
        }
        if (!StringUtil.isEmpty(T3) && (xEditTextEx = this.f32057p0) != null && T3.equals(String.valueOf(xEditTextEx.getText()))) {
            return;
        }
        DraftTextManager h16 = DraftTextManager.h(this.app);
        if (editable != null && editable.length() > 0) {
            DraftTextInfo draftTextInfo = new DraftTextInfo();
            draftTextInfo.uin = str2;
            draftTextInfo.type = i17;
            draftTextInfo.text = editable.toString();
            draftTextInfo.time = NetConnInfoCenter.getServerTimeMillis();
            h16.k(this.app, draftTextInfo);
            DataLineRecentContactUtil.f32313a.u(draftTextInfo);
        } else {
            DraftTextInfo draftTextInfo2 = new DraftTextInfo();
            draftTextInfo2.uin = str2;
            h16.b(this.app, str2, i17);
            DataLineRecentContactUtil.f32313a.j(draftTextInfo2);
        }
        QQMessageFacade messageFacade = this.app.getMessageFacade();
        DraftSummaryInfo e16 = h16.e(this.app, str2, i17);
        if (e16 != null) {
            messageFacade.L1(str2, i17, "", e16.getSummary(), e16.getTime());
        } else {
            messageFacade.L1(str2, i17, "", "", 0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0223 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean N4(View view) {
        DataLineMsgSet d16;
        DataLineMsgRecord firstItem;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        int[] iArr;
        Integer valueOf;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        BubblePopupWindow bubblePopupWindow = this.Y0;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            return true;
        }
        com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
        com.dataline.util.h hVar = (com.dataline.util.h) view.getTag();
        if (hVar == null || (d16 = hVar.d()) == null || (firstItem = d16.getFirstItem()) == null) {
            return false;
        }
        int groupType = d16.getGroupType();
        String str = "";
        if (d16.isSingle()) {
            int groupType2 = d16.getGroupType();
            if (groupType2 != -2335 && groupType2 != -2009 && groupType2 != -2005) {
                if (groupType2 != -2000) {
                    if (groupType2 != -1000) {
                        relativeLayout3 = null;
                    } else {
                        relativeLayout3 = hVar.j().f32444b;
                        aVar.b(R.id.ba_, view.getContext().getString(R.string.aet), R.drawable.cb5);
                        aVar.b(R.id.cjs, view.getContext().getString(R.string.f170968bc0), R.drawable.cbd);
                        aVar.b(R.id.c39, view.getContext().getString(R.string.b3m), R.drawable.cbc);
                    }
                } else {
                    relativeLayout3 = hVar.c().f32413d;
                    str = firstItem.path;
                    if (com.tencent.mobileqq.activity.aio.l.x(1) == 1 && FileUtils.fileExistsAndNotEmpty(firstItem.path) && Float.compare(firstItem.progress, 1.0f) == 0) {
                        aVar.b(R.id.f164035i0, getString(R.string.bs_), R.drawable.cbb);
                    }
                }
            } else {
                if (firstItem.bIsMoloImage) {
                    relativeLayout3 = hVar.c().f32413d;
                } else {
                    relativeLayout3 = hVar.a().f32406m;
                    if (relativeLayout3 == null) {
                        relativeLayout3 = (RelativeLayout) hVar.f().f32431a;
                    }
                }
                str = firstItem.path;
            }
            if (relativeLayout3 == null) {
                return false;
            }
            Context context = relativeLayout3.getContext();
            if (firstItem.canForward()) {
                aVar.b(R.id.cjs, context.getString(R.string.f171078c40), R.drawable.cbd);
            }
            if (FileUtils.fileExistsAndNotEmpty(str) && firstItem.strMoloKey == null) {
                if (d16.getGroupType() == -2005) {
                    boolean n3 = TencentDocConvertConfigProcessor.a().n();
                    long docsImportFileMaxSize = FileManagerUtil.getDocsImportFileMaxSize(firstItem.filename);
                    String e16 = TencentDocImportFileInfoProcessor.c().e();
                    if (TextUtils.isEmpty(e16)) {
                        e16 = ITeamWorkUtils.FILE_WORD_XLS;
                    }
                    if (n3 && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsSupport(str, firstItem.filename, e16)) {
                        relativeLayout4 = relativeLayout3;
                        if (firstItem.filesize <= docsImportFileMaxSize) {
                            ReportController.o(this.app, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
                            aVar.b(R.id.jc8, view.getContext().getString(R.string.hy8), R.drawable.cbo);
                        }
                        if (d16.getGroupType() != -2000) {
                            aVar.b(R.id.c39, view.getContext().getString(R.string.b3m), R.drawable.cbc);
                        } else if (d16.getGroupType() == -2009 && FileUtils.fileExistsAndNotEmpty(str)) {
                            aVar.b(R.id.c39, view.getContext().getString(R.string.b3m), R.drawable.cbc);
                        } else if (d16.getGroupType() == -2005 && FileUtils.fileExistsAndNotEmpty(str)) {
                            aVar.b(R.id.c39, view.getContext().getString(R.string.b3m), R.drawable.cbc);
                        }
                        if (r3(this.app, firstItem)) {
                            aVar.b(R.id.kkb, context.getString(R.string.iol), R.drawable.cbq);
                        }
                    }
                }
                relativeLayout4 = relativeLayout3;
                if (d16.getGroupType() != -2000) {
                }
                if (r3(this.app, firstItem)) {
                }
            } else {
                relativeLayout4 = relativeLayout3;
            }
            relativeLayout2 = relativeLayout4;
        } else {
            int groupType3 = d16.getGroupType();
            if (groupType3 != -2335 && groupType3 != -2009 && groupType3 != -2005) {
                if (groupType3 != -2000) {
                    relativeLayout2 = null;
                    if (relativeLayout2 == null) {
                        return false;
                    }
                } else {
                    relativeLayout = hVar.e().f32424d;
                }
            } else if (firstItem.bIsMoloImage) {
                relativeLayout = hVar.e().f32424d;
            } else {
                relativeLayout = hVar.a().f32406m;
            }
            relativeLayout2 = relativeLayout;
            if (relativeLayout2 == null) {
            }
        }
        String str2 = str;
        Context context2 = relativeLayout2.getContext();
        aVar.b(R.id.bfg, context2.getString(R.string.c3j), R.drawable.cb9);
        if (d16.getGroupType() != -2000) {
            d16.getGroupType();
        }
        AnonymousClass29 anonymousClass29 = new AnonymousClass29(firstItem, d16, context2, groupType, str2);
        InputLinearLayout inputLinearLayout = this.N0;
        if (inputLinearLayout != null) {
            iArr = new int[2];
            inputLinearLayout.getLocationInWindow(iArr);
        } else {
            iArr = null;
        }
        RelativeLayout relativeLayout5 = hVar.f32392i;
        PointF pointF = this.Z0;
        int i3 = (int) pointF.x;
        int i16 = (int) pointF.y;
        if (iArr == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(iArr[1]);
        }
        BubblePopupWindow e17 = com.tencent.mobileqq.utils.s.e(relativeLayout5, i3, i16, aVar, anonymousClass29, valueOf);
        this.Y0 = e17;
        e17.setOnDismissListener(new e());
        return true;
    }

    @Override // com.tencent.qqnt.kernel.invorker.d
    public void O0(int i3, int i16, @Nullable List<RecentContactInfo> list) {
        if (i3 != 1) {
            return;
        }
        updateUnreadNumOnTitleBar();
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.e
    public boolean R(PhotoListPanel photoListPanel) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = photoListPanel.f179647f.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int p16 = photoListPanel.f179650h.p(next);
            if (1 == p16) {
                arrayList2.add(next);
            } else if (p16 == 0) {
                arrayList.add(next);
            }
            j3 += new VFSFile(next).length();
        }
        if (j3 == 0) {
            Q4(this);
            return true;
        }
        if (NetworkUtil.isNetworkAvailable(this) && !NetworkUtil.isWifiConnected(this) && j3 > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FMDialogUtil.a(this, R.string.b_v, R.string.f170958ba0, new u(arrayList, arrayList2));
        } else {
            if (!arrayList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
                new an().execute(bundle);
            }
            if (!arrayList2.isEmpty()) {
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList2);
                new ao().execute(bundle2);
            }
        }
        photoListPanel.Q();
        ReportController.o(null, "CliOper", "", "", "0X8005A2F", "0X8005A2F", 0, 0, photoListPanel.f179647f.size() + "", "", "", "");
        return true;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public boolean T(int i3) {
        return false;
    }

    String T3() {
        String str;
        int i3;
        int i16 = this.f32050i0;
        if (i16 == 1) {
            str = AppConstants.DATALINE_IPAD_UIN;
            i3 = 6003;
        } else if (i16 == 2) {
            str = AppConstants.DATALINE_PHONE_UIN;
            i3 = 6005;
        } else {
            str = AppConstants.DATALINE_PC_UIN;
            i3 = 6000;
        }
        return DraftTextManager.h(this.app).f(this.app, str, i3);
    }

    void U3(Intent intent) {
        String str;
        int i3;
        String str2;
        AbsShareMsg absShareMsg;
        int i16;
        ArrayList arrayList;
        int intExtra = intent.getIntExtra("dataline_forward_type", -1);
        if (intExtra == -1) {
            return;
        }
        intent.getIntExtra("dataline_forward_type", -1);
        long longExtra = intent.getLongExtra("req_share_id", 0L);
        if (intent.getBooleanExtra("sendMultiple", false)) {
            if (intExtra == 100) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("dataline_forward_pathlist");
            if (stringArrayListExtra == null) {
                Bundle extras = intent.getExtras();
                if (extras == null || (arrayList = extras.getParcelableArrayList("fileinfo_array")) == null) {
                    arrayList = null;
                }
                if (arrayList == null) {
                    Y4();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    DataLineMsgRecord f36 = f3((ForwardFileInfo) it.next(), false, this.f32050i0);
                    if (f36 != null) {
                        if (DataLineMsgSet.isSingle(f36)) {
                            new ArrayList().add(f36);
                            finish();
                            z16 = true;
                        } else {
                            arrayList2.add(f36);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    finish();
                } else if (!z16) {
                    Y4();
                }
            } else {
                Iterator<String> it5 = stringArrayListExtra.iterator();
                boolean z17 = false;
                while (it5.hasNext()) {
                    String next = it5.next();
                    if (next == null || next.equals("/")) {
                        if (!z17) {
                            Y4();
                            z17 = true;
                        }
                        it5.remove();
                    }
                }
                if (!stringArrayListExtra.isEmpty()) {
                    z4(stringArrayListExtra, i16);
                } else if (!z17) {
                    Y4();
                }
            }
        } else {
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (B4(intent, intExtra)) {
                return;
            }
            switch (intExtra) {
                case 100:
                    com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_file");
                    Bundle extras2 = intent.getExtras();
                    SessionInfo sessionInfo = this.f32042c0;
                    FileManagerEntity m3 = QfavHelper.m(extras2, sessionInfo.f179557e, sessionInfo.f179555d);
                    if (m3 != null) {
                        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
                        if (forwardFileInfo != null) {
                            i3 = forwardFileInfo.L;
                        } else {
                            i3 = 0;
                        }
                        FileManagerEngine fileManagerEngine = this.app.getFileManagerEngine();
                        SessionInfo sessionInfo2 = this.f32042c0;
                        fileManagerEngine.C0(m3, sessionInfo2.f179557e, "", sessionInfo2.f179555d, i3);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("dataline_forward_path");
                    if (stringExtra != null && !stringExtra.equals("")) {
                        String[] split = stringExtra.split(";");
                        arrayList3.clear();
                        for (int i17 = 0; i17 < split.length; i17++) {
                            try {
                                str = URLDecoder.decode(split[i17], "UTF-8");
                            } catch (UnsupportedEncodingException unused) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + split[i17]);
                                    return;
                                }
                                return;
                            } catch (IllegalArgumentException unused2) {
                                str = split[i17];
                            }
                            if (!TextUtils.isEmpty(str)) {
                                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                                    arrayList3.add(str);
                                } else {
                                    D4(str);
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.e("qqdataline", 2, "shareFromMigSdk|file path invalid. path=" + str);
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            z4(arrayList3, 0);
                            if (intent.getBooleanExtra("isMigSdkShare", false)) {
                                ReportController.o(this.app, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
                                if (QLog.isColorLevel()) {
                                    QLog.e("qqdataline", 2, "shareFromMigSdk|report send file:0X8004932.");
                                    break;
                                }
                            }
                        }
                    } else {
                        Y4();
                        return;
                    }
                    break;
                case 101:
                    com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_image");
                    String stringExtra2 = intent.getStringExtra("dataline_forward_path");
                    if (stringExtra2 == null) {
                        QLog.e(f32035e1, 1, "handleForwardRequest forward image, extras: " + intent.getExtras().toString());
                        break;
                    } else {
                        String[] split2 = stringExtra2.split(";");
                        arrayList3.clear();
                        for (int i18 = 0; i18 < split2.length; i18++) {
                            try {
                                if (FileUtils.fileExists(split2[i18])) {
                                    str2 = split2[i18];
                                } else {
                                    str2 = URLDecoder.decode(split2[i18], "UTF-8");
                                }
                            } catch (UnsupportedEncodingException unused3) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("qqdataline", 2, "shareFromMigSdk|decode exp. imageUrls[i]=" + split2[i18]);
                                    return;
                                }
                                return;
                            } catch (IllegalArgumentException unused4) {
                                str2 = split2[i18];
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
                                    arrayList3.add(str2);
                                } else {
                                    D4(str2);
                                    ReportController.o(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                                    if (QLog.isColorLevel()) {
                                        QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                                    }
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.e("qqdataline", 2, "gotoQfavShareMsg|file path invalid. path=" + str2);
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            z4(arrayList3, 1);
                            if (intent.getBooleanExtra("isMigSdkShare", false)) {
                                if (arrayList3.size() > 1) {
                                    ReportController.o(this.app, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
                                    if (QLog.isColorLevel()) {
                                        QLog.e("qqdataline", 2, "shareFromMigSdk|report send multi pic:0X8004930.");
                                        break;
                                    }
                                } else if (arrayList3.size() == 1) {
                                    ReportController.o(this.app, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
                                    if (QLog.isColorLevel()) {
                                        QLog.e("qqdataline", 2, "shareFromMigSdk|report single pics:0X800492F.");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 102:
                    String stringExtra3 = intent.getStringExtra("dataline_forward_text");
                    if (stringExtra3 != null && stringExtra3.length() > 0) {
                        if (cg.f307525d.matcher(stringExtra3).find()) {
                            com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_link");
                        } else {
                            com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_text");
                        }
                        D4(stringExtra3);
                        break;
                    }
                    break;
                default:
                    com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_forwardin_other");
                    break;
            }
        }
        if (!this.f32062u0) {
            this.f32062u0 = intent.getExtras().getBoolean(AppConstants.Key.SHARE_FLAG);
        }
        boolean z18 = intent.getExtras().getBoolean("refuse_show_share_result_dialog", false);
        if (this.f32062u0 && !z18) {
            Bundle extras3 = intent.getExtras();
            String string = extras3.getString("app_name");
            if (longExtra == 0) {
                AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(extras3);
                if (e16 != null && (e16 instanceof AbsShareMsg)) {
                    absShareMsg = (AbsShareMsg) e16;
                } else {
                    absShareMsg = null;
                }
                if (absShareMsg != null) {
                    longExtra = absShareMsg.mSourceAppid;
                }
            }
            n4(longExtra, string);
        }
    }

    void V3(Intent intent) {
        String stringExtra;
        if (intent.hasExtra("JumpAction.Text") && (stringExtra = intent.getStringExtra("JumpAction.Text")) != null && stringExtra.length() > 0) {
            this.f32057p0.setText(stringExtra);
            this.f32057p0.requestFocus();
            this.f32057p0.setSelection(stringExtra.length());
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.f32057p0, 0);
        }
    }

    void V4() {
        QQToast qQToast = new QQToast(this);
        qQToast.setToastIcon(R.drawable.hac);
        qQToast.setDuration(2000);
        qQToast.setToastMsg(R.string.c57);
        qQToast.show(this.f32046e0.getHeight() / 2);
    }

    void X4() {
        QQToast qQToast = new QQToast(this);
        qQToast.setToastIcon(R.drawable.hac);
        qQToast.setDuration(2000);
        qQToast.setToastMsg(R.string.c58);
        qQToast.show(this.f32046e0.getHeight() / 2);
    }

    void Y4() {
        QQToast qQToast = new QQToast(this);
        qQToast.setToastIcon(R.drawable.hac);
        qQToast.setDuration(2000);
        qQToast.setToastMsg(R.string.f171085c51);
        qQToast.show(this.f32046e0.getHeight() / 2);
    }

    public void a4(boolean z16) {
        this.L0 = false;
        G3(true);
        ViewGroup viewGroup = this.M0;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        this.S0.setVisibility(0);
        this.f32059r0.setEnabled(this.R0.isEnabled());
        this.R0.setVisibility(8);
        this.Q0.setVisibility(8);
        this.N0.getLayoutParams().height = -2;
        this.O0.getLayoutParams().height = -2;
        if (z16) {
            this.N0.setPadding(0, BaseAIOUtils.f(8.0f, this.app.getApplication().getResources()), 0, 0);
            this.f32057p0.getLayoutParams().height = -2;
            ((FrameLayout.LayoutParams) this.f32057p0.getLayoutParams()).setMargins(BaseAIOUtils.f(14.0f, this.app.getApplication().getResources()), 0, 0, 0);
            this.f32057p0.setMaxLines(6);
            this.f32057p0.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg);
            this.f32057p0.setGravity(16);
            this.f32057p0.setPadding(BaseAIOUtils.f(11.0f, this.app.getApplication().getResources()), BaseAIOUtils.f(6.0f, this.app.getApplication().getResources()), BaseAIOUtils.f(11.0f, this.app.getApplication().getResources()), BaseAIOUtils.f(6.0f, this.app.getApplication().getResources()));
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f32057p0.getHeight(), BaseAIOUtils.f(100.0f, this.app.getApplication().getResources()));
        ofInt.addUpdateListener(new ac());
        ofInt.addListener(new com.tencent.mobileqq.widget.f() { // from class: com.dataline.activities.LiteActivity.52
            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiteActivity.this.N0.setPadding(0, BaseAIOUtils.f(8.0f, LiteActivity.this.app.getApplication().getResources()), 0, 0);
                LiteActivity.this.f32057p0.getLayoutParams().height = -2;
                ((FrameLayout.LayoutParams) LiteActivity.this.f32057p0.getLayoutParams()).setMargins(BaseAIOUtils.f(14.0f, LiteActivity.this.app.getApplication().getResources()), 0, 0, 0);
                LiteActivity.this.f32057p0.setMaxLines(6);
                LiteActivity.this.f32057p0.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg);
                LiteActivity.this.f32057p0.setGravity(16);
                LiteActivity liteActivity = LiteActivity.this;
                liteActivity.f32057p0.setPadding(BaseAIOUtils.f(11.0f, liteActivity.app.getApplication().getResources()), BaseAIOUtils.f(6.0f, LiteActivity.this.app.getApplication().getResources()), BaseAIOUtils.f(11.0f, LiteActivity.this.app.getApplication().getResources()), BaseAIOUtils.f(6.0f, LiteActivity.this.app.getApplication().getResources()));
                LiteActivity.this.f32057p0.requestLayout();
                LiteActivity.this.f32064w0.postDelayed(new Runnable() { // from class: com.dataline.activities.LiteActivity.52.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LiteActivity.this.f32057p0.getLineCount() > 3) {
                            LiteActivity.this.P0.setVisibility(0);
                        } else {
                            LiteActivity.this.P0.setVisibility(8);
                        }
                    }
                }, 100L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt.setDuration(100L).setRepeatCount(0);
        ofInt.start();
    }

    void c4() {
        XEditTextEx xEditTextEx = (XEditTextEx) findViewById(R.id.input);
        this.f32057p0 = xEditTextEx;
        TextWatcher textWatcher = this.f32058q0;
        if (textWatcher != null) {
            xEditTextEx.removeTextChangedListener(textWatcher);
        } else {
            this.f32058q0 = new ai();
        }
        try {
            this.f32057p0.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        } catch (Exception e16) {
            QLog.e(f32035e1, 1, "input set error", e16);
        }
        this.f32057p0.addTextChangedListener(this.f32058q0);
        this.f32057p0.setFilters(new InputFilter[]{new aj()});
        com.tencent.devicelib.a.a(this, this.f32057p0);
        d4();
        this.f32057p0.setOnTouchListener(new View.OnTouchListener() { // from class: com.dataline.activities.LiteActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (QLog.isColorLevel()) {
                    QLog.d(LiteActivity.f32035e1, 2, "ontouch--fcc----: " + motionEvent.getAction());
                }
                LiteActivity.this.e5();
                LiteActivity.this.s3(false);
                LiteActivity.this.f32057p0.postDelayed(new Runnable() { // from class: com.dataline.activities.LiteActivity.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiteActivity.h4(LiteActivity.this.f32046e0);
                    }
                }, 200L);
                LiteActivity.this.f32057p0.onTouch(view, motionEvent);
                return false;
            }
        });
        this.f32057p0.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void c5() {
        if (((Boolean) SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue()) {
            View findViewById = this.N0.findViewById(R.id.ix5);
            findViewById.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
            findViewById.setVisibility(0);
            Drawable background = this.N0.getBackground();
            if (background != null) {
                background.setVisible(false, false);
                return;
            }
            return;
        }
        Drawable background2 = this.N0.getBackground();
        if (background2 != null) {
            background2.setVisible(true, false);
        }
        this.N0.findViewById(R.id.ix5).setVisibility(8);
    }

    void d4() {
        int i3 = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
        this.f32056o0 = ChatTextSizeSettingActivity.H2(this);
        int i16 = 8;
        if (i3 != 0 && (i3 == 2 || i3 == 3)) {
            i16 = 6;
        }
        this.f32057p0.setMaxLines(i16);
        this.f32057p0.setTextSize(0, this.f32056o0);
    }

    protected void d5() {
        this.f32038a0.m();
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
        ArrayList<SendInfo> parcelableArrayListExtra;
        ArrayList<SendInfo> parcelableArrayListExtra2;
        PhotoListPanel photoListPanel;
        super.doOnActivityResult(i3, i16, intent);
        if (!f4()) {
            j3(null);
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 7) {
                            if (i3 != 10004) {
                                if (i3 != 101) {
                                    if (i3 == 102) {
                                        this.f32053l0.notifyDataSetChanged();
                                        return;
                                    }
                                    return;
                                } else {
                                    if (i16 == -1) {
                                        p4(false);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (i16 == -1 && (photoListPanel = this.f32040b0) != null) {
                                photoListPanel.D(i3, intent);
                                return;
                            }
                            return;
                        }
                        v3();
                        return;
                    }
                    if (i16 == -1 && intent != null) {
                        String string = intent.getExtras().getString("textMsg");
                        if (string.length() > 0) {
                            D4(string);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i16 == -1) {
                    p4(false);
                    return;
                }
                return;
            }
            if (i16 == -1 && intent != null && (parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("sendInfo")) != null && parcelableArrayListExtra2.size() > 0) {
                x4(parcelableArrayListExtra2, 2);
                parcelableArrayListExtra2.clear();
                p4(false);
                return;
            }
            return;
        }
        if (i16 == -1 && intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("sendInfo")) != null && parcelableArrayListExtra.size() > 0) {
            x4(parcelableArrayListExtra, 1);
            parcelableArrayListExtra.clear();
            p4(false);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        super.doOnBackPressed();
        H3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        DataLineMsgRecord firstItem;
        DataLineMsgRecord firstItem2;
        ImageView imageView;
        ca.a(this);
        super.doOnCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.f156897em);
        setContentView(R.layout.k_);
        SystemBarActivityModule.setStatusBarBlue(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rlCommenTitle);
        this.M0 = viewGroup;
        if (viewGroup != null && (imageView = (ImageView) viewGroup.findViewById(R.id.f165972dz1)) != null) {
            ViewCompat.setImportantForAccessibility(imageView, 2);
        }
        this.N0 = (InputLinearLayout) findViewById(R.id.inputBar);
        this.U0 = QQPermissionFactory.getQQPermission(this);
        onCreateRightView();
        onCreateCenterView();
        onCreateLeftView();
        setTitle(R.string.c5f);
        getWindow().setBackgroundDrawable(null);
        g3(getIntent());
        L4(getIntent());
        initTitleBar();
        this.f32067z0 = (RelativeLayout) findViewById(R.id.l2v);
        this.A0 = (TextView) findViewById(R.id.ecc);
        this.B0 = (ImageView) findViewById(R.id.ecb);
        if (this.f32050i0 == 1) {
            ReportController.o(this.app, "CliOper", "", "", "0X8005D19", "0X8005D19", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.d(f32035e1, 2, "=== dataline report event into ipad 0X8005D19 ");
            }
        }
        this.f32060s0 = new am(this);
        this.app.getFileManagerNotifyCenter().addObserver(this.f32043c1);
        QQMessageFacade messageFacade = this.app.getMessageFacade();
        if (messageFacade != null) {
            messageFacade.addObserver(this);
        }
        ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).addExpandRecentContactListener(this);
        this.f32052k0 = this.app.getDataLineMsgProxy(this.f32050i0).o(true);
        this.f32053l0 = new com.dataline.util.f(this, this.f32052k0, this, this.app);
        initListView();
        c4();
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        dataLineHandler.F = true;
        ScrollerRunnable scrollerRunnable = new ScrollerRunnable(this.f32046e0);
        this.f32047f0 = scrollerRunnable;
        scrollerRunnable.q();
        this.f32049h0 = (RelativeLayout) findViewById(R.id.awl);
        XPanelContainer xPanelContainer = (XPanelContainer) findViewById(R.id.root);
        this.f32038a0 = xPanelContainer;
        xPanelContainer.setOnPanelChangeListener(this);
        e4();
        this.f32038a0.c(this.f32057p0);
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.f32046e0, false);
        }
        Button button = (Button) findViewById(R.id.imy);
        this.f32059r0 = button;
        button.setOnClickListener(this);
        e5();
        addObserver(this.X0);
        B3();
        this.app.getMessageFacade().t1(this.f32050i0).l();
        DataLineRecentContactUtil.f32313a.w(this.f32050i0);
        if (bundle == null) {
            this.f32064w0.postDelayed(new Runnable() { // from class: com.dataline.activities.LiteActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    LiteActivity liteActivity = LiteActivity.this;
                    liteActivity.m4(liteActivity.getIntent());
                }
            }, 200L);
        }
        u3(getIntent());
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (registerProxySvcPackHandler.P2() == 0 && !registerProxySvcPackHandler.L2()) {
            registerProxySvcPackHandler.Z2();
            registerProxySvcPackHandler.d3(true);
        }
        if (!this.f32052k0.isEmpty()) {
            SharedPreferences sharedPreferences = getSharedPreferences("first_enter_dataline", 0);
            int i3 = sharedPreferences.getInt("year", -1);
            int i16 = sharedPreferences.getInt("month", -1);
            int i17 = sharedPreferences.getInt("day", -1);
            Calendar calendar = Calendar.getInstance();
            int i18 = calendar.get(1);
            int i19 = calendar.get(2);
            int i26 = calendar.get(5);
            if (i18 != i3 || i19 != i16 || i26 != i17) {
                DataLineMsgSetList dataLineMsgSetList = this.f32052k0;
                DataLineMsgSet dataLineMsgSet = dataLineMsgSetList.get(dataLineMsgSetList.size() - 1);
                if (dataLineMsgSet != null && (firstItem = dataLineMsgSet.getFirstItem()) != null && firstItem.msgtype != -5000) {
                    Iterator<DataLineMsgSet> it = this.f32052k0.iterator();
                    while (it.hasNext()) {
                        DataLineMsgSet next = it.next();
                        if (next != null && (firstItem2 = next.getFirstItem()) != null && firstItem2.msgtype == -5000) {
                            try {
                                it.remove();
                                this.app.getDataLineMsgProxy(this.f32050i0).D(next);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    Long u36 = dataLineHandler.u3(0, this.f32050i0);
                    DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
                    dataLineMsgRecord.msgId = u36.longValue();
                    dataLineMsgRecord.sessionid = u36.longValue();
                    dataLineMsgRecord.msgtype = -5000;
                    dataLineMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
                    dataLineMsgRecord.isread = true;
                    this.app.getDataLineMsgProxy(this.f32050i0).i(dataLineMsgRecord);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putInt("year", i18);
                    edit.putInt("month", i19);
                    edit.putInt("day", i26);
                    edit.commit();
                }
            }
        }
        initBlur();
        this.O0 = findViewById(R.id.cpx);
        this.P0 = (ImageButton) findViewById(R.id.cpu);
        this.Q0 = (ImageButton) findViewById(R.id.d5n);
        this.S0 = (LinearLayout) findViewById(R.id.cq8);
        this.R0 = (TextView) findViewById(R.id.cpv);
        this.P0.setOnClickListener(this);
        this.Q0.setOnClickListener(this);
        this.R0.setOnClickListener(this);
        if (AppSetting.f99565y) {
            this.P0.setContentDescription(HardCodeUtil.qqStr(R.string.nqc));
            this.Q0.setContentDescription(HardCodeUtil.qqStr(R.string.nqb));
        }
        LiteCopyPromptHelper liteCopyPromptHelper = new LiteCopyPromptHelper(this, this.f32038a0, this.app, this.f32057p0);
        this.K0 = liteCopyPromptHelper;
        liteCopyPromptHelper.m();
        b4();
        SimpleModeHelper.t(this.S0, this.f32059r0);
        b5();
        if (C3()) {
            s4();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        ScrollerRunnable scrollerRunnable = this.f32047f0;
        if (scrollerRunnable != null) {
            scrollerRunnable.stop();
        }
        if (this.app.getMessageFacade() != null) {
            this.app.getMessageFacade().t1(this.f32050i0).l();
            DataLineRecentContactUtil.f32313a.w(this.f32050i0);
            this.app.getMessageFacade().t1(this.f32050i0).f();
            this.app.getMessageFacade().deleteObserver(this);
            this.f32053l0.notifyDataSetChanged();
        }
        ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).removeExpandRecentContactListener(this);
        com.tencent.mobileqq.app.k kVar = this.X0;
        if (kVar != null) {
            removeObserver(kVar);
        }
        if (this.f32043c1 != null) {
            this.app.getFileManagerNotifyCenter().deleteObserver(this.f32043c1);
        }
        QQCustomDialog qQCustomDialog = this.f32061t0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f32061t0 = null;
        }
        this.f32050i0 = -1;
        if (this.app.getFileManagerProxy() != null) {
            this.app.getFileManagerProxy().Z();
        }
        this.f32057p0.setVisibility(8);
        PhotoListPanel photoListPanel = this.f32040b0;
        if (photoListPanel != null) {
            photoListPanel.setSelectLimitListener(null);
        }
        FileManagerUtil.clearRememberPicSelectForQlink(this);
        if (this.I0) {
            this.f32046e0.getViewTreeObserver().removeGlobalOnLayoutListener(this.J0);
            this.H0.onDestroy();
        }
        this.K0.n();
        QLog.d(f32035e1, 1, "doOnDestroy");
        if (this.f32062u0 && !getIntent().getBooleanExtra("isMigSdkShare", false)) {
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        l4(intent);
        M4();
        r4(intent);
        m4(intent);
        this.f32053l0.notifyDataSetChanged();
        u3(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        QLog.d(f32035e1, 1, "doOnPause");
        ((DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).m4();
        this.app.getDataLineMsgProxy(this.f32050i0).O();
        if (this.I0) {
            this.H0.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        G4(this, this.f32038a0);
        this.f32053l0.notifyDataSetChanged();
        PhotoListPanel photoListPanel = this.f32040b0;
        if (photoListPanel != null && photoListPanel.getVisibility() == 0) {
            this.f32040b0.N();
        }
        ApngImage.playByTag(0);
        c5();
        if (this.I0) {
            this.H0.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        M4();
    }

    @TargetApi(18)
    boolean e3(long j3) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            X4();
            return false;
        }
        if (new StatFs(AppConstants.SDCARD_ROOT).getAvailableBytes() < j3) {
            V4();
            return false;
        }
        return true;
    }

    void e4() {
        int i3 = this.f32050i0;
        if (i3 == 1) {
            SessionInfo sessionInfo = this.f32042c0;
            sessionInfo.f179557e = AppConstants.DATALINE_IPAD_UIN;
            sessionInfo.f179555d = 6003;
            sessionInfo.f179563i = getResources().getString(R.string.c5g);
            return;
        }
        if (i3 == 2) {
            SessionInfo sessionInfo2 = this.f32042c0;
            sessionInfo2.f179557e = AppConstants.DATALINE_PHONE_UIN;
            sessionInfo2.f179555d = 6005;
            sessionInfo2.f179563i = getResources().getString(R.string.f16273218);
            return;
        }
        SessionInfo sessionInfo3 = this.f32042c0;
        sessionInfo3.f179557e = AppConstants.DATALINE_PC_UIN;
        sessionInfo3.f179555d = 6000;
        sessionInfo3.f179563i = getResources().getString(R.string.c5f);
    }

    void e5() {
        String obj = this.f32057p0.getText().toString();
        if (obj != null && obj.length() > 0) {
            if (this.L0) {
                this.R0.setEnabled(true);
                return;
            } else {
                this.f32059r0.setEnabled(true);
                return;
            }
        }
        if (this.L0) {
            this.R0.setEnabled(false);
        } else {
            this.f32059r0.setEnabled(false);
        }
    }

    DataLineMsgRecord f3(ForwardFileInfo forwardFileInfo, boolean z16, int i3) {
        FileManagerEntity D = this.app.getFileManagerDataCenter().D(forwardFileInfo.n());
        if (D == null) {
            return null;
        }
        int S2 = DataLineHandler.S2(D);
        if (!DataLineHandler.U2(S2)) {
            return null;
        }
        int R2 = DataLineHandler.R2(forwardFileInfo.f(), z16);
        if (!z16 && R2 == 1) {
            R2 = 0;
        }
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.msgtype = DataLineHandler.C4(R2);
        dataLineMsgRecord.sessionid = ((DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).u3(0, i3).longValue();
        dataLineMsgRecord.filename = forwardFileInfo.f();
        dataLineMsgRecord.filesize = forwardFileInfo.g();
        dataLineMsgRecord.fileUuid = forwardFileInfo.s();
        dataLineMsgRecord.fileFrom = S2;
        dataLineMsgRecord.thumbPath = forwardFileInfo.p();
        if (!TextUtils.isEmpty(D.strFileMd5)) {
            dataLineMsgRecord.md5 = HexUtil.hexStr2Bytes(D.strFileMd5);
        }
        if (!TextUtils.isEmpty(D.peerUin)) {
            dataLineMsgRecord.uOwnerUin = Long.parseLong(D.peerUin.replace(Marker.ANY_NON_NULL_MARKER, ""));
        }
        if (TextUtils.isEmpty(forwardFileInfo.l())) {
            dataLineMsgRecord.path = forwardFileInfo.f();
        } else {
            dataLineMsgRecord.path = forwardFileInfo.l();
        }
        return dataLineMsgRecord;
    }

    boolean f4() {
        RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
        if (registerProxySvcPackHandler.P2() != 0 && registerProxySvcPackHandler.Q2() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        M4();
        ((DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).F = false;
        I4();
        if (this.f32065x0 && com.tencent.mobileqq.activity.aio.l.f179531g && !this.f32066y0) {
            super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
            this.f32066y0 = true;
        }
    }

    protected void g3(Intent intent) {
        int i3 = this.f32050i0;
        String str = this.f32051j0;
        String stringExtra = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        this.f32051j0 = stringExtra;
        if (stringExtra != null && stringExtra.length() != 0) {
            if (this.f32051j0.equals(AppConstants.DATALINE_IPAD_UIN)) {
                if (((RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                    setTitle(R.string.c5g);
                } else {
                    setTitle(R.string.f16272217);
                }
                this.f32050i0 = 1;
            } else if (this.f32051j0.equals(AppConstants.DATALINE_PC_UIN)) {
                setTitle(R.string.c5f);
                this.f32050i0 = 0;
            } else if (this.f32051j0.equals(AppConstants.DATALINE_PHONE_UIN)) {
                setTitle(R.string.f16273218);
                this.f32050i0 = 2;
            }
        } else if (this.f32050i0 == -1) {
            int intExtra = intent.getIntExtra("device_type", -1);
            this.f32050i0 = intExtra;
            if (intExtra == 1) {
                if (((RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                    setTitle(R.string.c5g);
                } else {
                    setTitle(R.string.f16272217);
                }
                this.f32051j0 = AppConstants.DATALINE_IPAD_UIN;
            } else if (intExtra == 2) {
                setTitle(R.string.f16273218);
                this.f32051j0 = AppConstants.DATALINE_PHONE_UIN;
            } else {
                setTitle(R.string.c5f);
                this.f32051j0 = AppConstants.DATALINE_PC_UIN;
                this.f32050i0 = 0;
            }
        } else {
            this.f32050i0 = i3;
            this.f32051j0 = str;
        }
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        dataLineHandler.f194549h = this.f32051j0;
        dataLineHandler.f194551i = this.f32050i0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public float getDensity() {
        return this.mDensity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 14) {
                        if (i3 == 15) {
                            v3();
                            return false;
                        }
                        return false;
                    }
                    E3(message.arg1, message.arg2);
                    return false;
                }
                QLog.i(f32035e1, 2, "progress: " + message.arg1);
                this.G0.setProgress(message.arg1);
                return false;
            }
            dismissDialog();
            w4();
            return false;
        }
        dismissDialog();
        O4(L3());
        return false;
    }

    void initListView() {
        XListView xListView = (XListView) findViewById(R.id.ec_);
        this.f32046e0 = xListView;
        xListView.setStackFromBottom(true);
        this.f32046e0.setAdapter((ListAdapter) this.f32053l0);
        this.f32046e0.setOverScrollHeader(LayoutInflater.from(this).inflate(R.layout.f167787hh, (ViewGroup) null));
        this.f32046e0.setSelection(this.f32053l0.getCount());
        this.f32046e0.setOnTouchListener(new ab());
        this.f32046e0.setOverScrollListener(new ag());
    }

    void initTitleBar() {
        ImageView imageView = this.rightViewImg;
        imageView.setContentDescription(getResources().getText(R.string.f171076c34));
        imageView.setVisibility(0);
        imageView.setImageResource(TokenResUtils.getTokenRes(R.drawable.b4n, R.drawable.qui_chat_settings_icon_navigation_01));
        imageView.setOnClickListener(new f());
        if (AppSetting.f99565y) {
            this.rightViewImg.setContentDescription(HardCodeUtil.qqStr(R.string.nqj));
        }
        l4(getIntent());
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
            this.mLeftBackIcon.setVisibility(0);
            this.leftView.setVisibility(8);
        } else {
            this.leftView.setVisibility(0);
            this.mLeftBackIcon.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.e
    public boolean j(PhotoListPanel photoListPanel) {
        ArrayList<String> arrayList;
        if (QLog.isColorLevel()) {
            QLog.d(f32035e1, 2, "onAlbumBtnClicked");
        }
        if (!photoListPanel.f179647f.isEmpty()) {
            arrayList = new ArrayList<>(photoListPanel.f179647f);
        } else {
            arrayList = null;
        }
        I3(arrayList);
        photoListPanel.Q();
        ReportController.o(null, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
        return true;
    }

    void j3(String str) {
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
        dataLineMsgRecord.msgtype = -2334;
        dataLineMsgRecord.isread = true;
        dataLineMsgRecord.issuc = false;
        dataLineMsgRecord.issend = 255;
        dataLineMsgRecord.f203106msg = str;
        this.f32052k0.appendToList(dataLineMsgRecord);
        this.f32053l0.notifyDataSetChanged();
    }

    void k4() {
        this.app.getMessageFacade().t1(this.f32050i0).e(15, new ah());
    }

    void l4(Intent intent) {
        View findViewById;
        String stringExtra;
        setLeftViewName(intent);
        String charSequence = this.leftView.getText().toString();
        if (charSequence.contains(getString(R.string.hvn))) {
            this.f32044d0 = this.leftView;
            com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4recent");
            updateUnreadNumOnTitleBar();
        } else if (charSequence.contains(getString(R.string.c75))) {
            com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4buddylist");
        } else if (charSequence.contains(getString(R.string.b7l))) {
            com.tencent.mobileqq.statistics.s.a(this.app.getApplication().getApplicationContext(), this.app.getCurrentAccountUin(), "dl_op4dongtai");
        }
        if (intent != null && intent.getExtras() != null) {
            this.f32055n0 = intent.getExtras().getBoolean("isBack2Root");
            intent.getExtras().putBoolean("isBack2Root", false);
        }
        if (intent != null && (stringExtra = intent.getStringExtra("LASTFROM")) != null) {
            this.leftView.setText(stringExtra);
            this.f32044d0 = this.leftView;
        }
        if (intent != null && !TextUtils.isEmpty(intent.getAction()) && (intent.getAction().equals("android.intent.action.SEND") || intent.getAction().equals("android.intent.action.SEND_MULTIPLE"))) {
            this.f32055n0 = true;
            this.leftView.setText(getString(R.string.hvn));
            this.f32044d0 = this.leftView;
            updateUnreadNumOnTitleBar();
        }
        if (intent != null && intent.getIntExtra("dataline_forward_type", -1) != -1) {
            if (!this.f32062u0) {
                this.f32062u0 = intent.getExtras().getBoolean(AppConstants.Key.SHARE_FLAG);
            }
            if (!this.f32062u0) {
                this.f32055n0 = true;
                this.leftView.setText(getString(R.string.hvn));
                this.f32044d0 = this.leftView;
                updateUnreadNumOnTitleBar();
            }
        }
        if (AppSetting.f99565y && (findViewById = findViewById(R.id.e89)) != null) {
            ViewCompat.setImportantForAccessibility(findViewById, 1);
            AccessibilityUtil.p(findViewById, getString(R.string.f170549u3));
        }
    }

    public void m4(Intent intent) {
        if (intent.getBooleanExtra("MigSdkShareNotDone", false)) {
            this.f32063v0 = com.tencent.mobileqq.forward.k.d(intent, this.app, this);
            Bundle bundle = new Bundle();
            bundle.putString("uin", String.valueOf(AppConstants.DATALINE_PC_UIN));
            bundle.putInt("uintype", -1);
            this.f32063v0.buildForwardDialog(com.tencent.mobileqq.forward.e.S3.intValue(), bundle);
            return;
        }
        String T3 = T3();
        this.f32057p0.setText(T3);
        if (!TextUtils.isEmpty(T3)) {
            BaseAIOUtils.o(this.f32057p0);
            this.f32057p0.setSelection(T3.length());
        }
        int intExtra = intent.getIntExtra(com.tencent.mobileqq.utils.d.f307603i, -1);
        if (55 == intExtra) {
            if (intent.getExtras().containsKey("PhotoConst.PHOTO_PATHS")) {
                ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
                if (stringArrayList.size() > 0) {
                    y4(stringArrayList);
                    PhotoListPanel photoListPanel = this.f32040b0;
                    if (photoListPanel != null) {
                        photoListPanel.Q();
                    }
                    XPanelContainer xPanelContainer = this.f32038a0;
                    if (xPanelContainer != null) {
                        xPanelContainer.s();
                        return;
                    }
                    return;
                }
            }
            if (intent.getExtras().containsKey("file_send_path")) {
                E4(intent.getExtras().getString("file_send_path"));
                PhotoListPanel photoListPanel2 = this.f32040b0;
                if (photoListPanel2 != null) {
                    photoListPanel2.Q();
                }
                XPanelContainer xPanelContainer2 = this.f32038a0;
                if (xPanelContainer2 != null) {
                    xPanelContainer2.s();
                }
            }
        } else if (56 == intExtra) {
            E4(intent.getExtras().getString("file_send_path"));
            PhotoListPanel photoListPanel3 = this.f32040b0;
            if (photoListPanel3 != null) {
                photoListPanel3.Q();
            }
        }
        if (intent.getBooleanExtra(PeakConstants.SEND_FLAG, false)) {
            getIntent().removeExtra(PeakConstants.SEND_FLAG);
            y4(intent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS"));
            PhotoListPanel photoListPanel4 = this.f32040b0;
            if (photoListPanel4 != null) {
                photoListPanel4.Q();
            }
        }
        if (intent.getBooleanExtra("isMigSdkShare", false)) {
            getIntent().putExtra("isMigSdkShare", true);
        }
        U3(intent);
        V3(intent);
    }

    void n4(long j3, String str) {
        if (isFinishing()) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.f32061t0;
        if (qQCustomDialog != null) {
            qQCustomDialog.show();
            return;
        }
        String string = getString(R.string.hih);
        if (str != null) {
            string = string + str;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 232, (String) null, this.app.getApplication().getString(R.string.hik), string, this.app.getApplication().getString(R.string.hii), new b(j3), new c(j3, this));
        this.f32061t0 = createCustomDialog;
        createCustomDialog.show();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (this.f32057p0 != null) {
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f32057p0.getWindowToken(), 0);
        }
        boolean booleanExtra = getIntent().getBooleanExtra("isMigSdkShare", false);
        if (this.f32062u0) {
            if (booleanExtra) {
                long longExtra = getIntent().getLongExtra("req_share_id", 0L);
                if (longExtra > 0) {
                    ForwardSdkBaseOption.F(this, true, "sendToMyComputer", longExtra);
                }
                return super.onBackEvent();
            }
            long longExtra2 = getIntent().getLongExtra(AppConstants.Key.SHARE_RES_ID, 0L);
            if (longExtra2 > 0) {
                ForwardSdkBaseOption.F(this, true, "shareToQQ", com.tencent.mobileqq.utils.h.f(longExtra2));
            }
            H3();
            return super.onBackEvent();
        }
        ApngImage.pauseAll();
        if (this.f32055n0 || booleanExtra) {
            Intent aliasIntent = SplashActivity.getAliasIntent(this);
            aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.setFlags(67108864);
            startActivity(aliasIntent);
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.activity.aio.l.f179531g = true;
        int id5 = view.getId();
        ReportController.o(this.app, "CliOper", "", "", "0X8004078", "0X8004078", 0, 0, "", "", "", "");
        if (id5 == R.id.imy) {
            send();
        } else if (id5 == R.id.d5n) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009F36", "0X8009F36", 4, 0, "", "", "", "");
            a4(false);
        } else if (id5 == R.id.cpu) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009F27", "0X8009F27", 4, 0, "", "", "", "");
            J3();
        } else if (id5 == R.id.cpv) {
            if (this.L0) {
                a4(false);
            }
            send();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void onPanelChanged(int i3, int i16) {
        this.f32064w0.obtainMessage(14, i3, i16).sendToTarget();
    }

    public void p4(boolean z16) {
        this.f32053l0.notifyDataSetChanged();
        this.app.getMessageFacade().t1(this.f32050i0).l();
        DataLineRecentContactUtil.f32313a.w(this.f32050i0);
        if (!z16) {
            n3(this.f32047f0, this.f32046e0);
            h4(this.f32046e0);
        }
    }

    protected void r4(Intent intent) {
        L4(intent);
        int i3 = this.f32050i0;
        g3(intent);
        int i16 = this.f32050i0;
        if (i3 != i16) {
            DataLineMsgProxy dataLineMsgProxy = this.app.getDataLineMsgProxy(i16);
            if (dataLineMsgProxy == null) {
                DataLineMsgSetList dataLineMsgSetList = new DataLineMsgSetList();
                this.f32052k0 = dataLineMsgSetList;
                this.f32053l0.z(dataLineMsgSetList);
                if (QLog.isColorLevel()) {
                    QLog.d(f32035e1, 2, "onCreate datalineMsgEntities = new DataLineMsgSetList()");
                }
            } else {
                DataLineMsgSetList o16 = dataLineMsgProxy.o(true);
                this.f32052k0 = o16;
                this.f32053l0.z(o16);
            }
            this.f32053l0.notifyDataSetChanged();
        }
    }

    public void t3() {
        this.f32064w0.obtainMessage(15, 0, 0).sendToTarget();
    }

    void t4(String str, long j3, int i3) {
        if (!f4()) {
            j3(null);
            return;
        }
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(j3);
        DataLineMsgRecord d16 = this.app.getMessageFacade().t1(devTypeBySeId).d(j3);
        if (d16 == null) {
            return;
        }
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        d16.bIsResendOrRecvFile = true;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                this.app.getMessageFacade().t1(devTypeBySeId).h(j3);
                D4(str);
            } else {
                FileUtils.fileExists(str);
                if (d16.nOpType == 35) {
                    dataLineHandler.X3(d16);
                } else {
                    dataLineHandler.y3().k(d16, devTypeBySeId, 2);
                }
            }
        }
        this.f32053l0.notifyDataSetChanged();
    }

    void u3(Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
            if (!intent.getAction().equals("android.intent.action.SEND") && !intent.getAction().equals("android.intent.action.SEND_MULTIPLE")) {
                if (intent.getAction().equals("android.intent.action.MAIN") && intent.getBooleanExtra("system_share_multi_send", false)) {
                    this.f32060s0.a(intent);
                    return;
                }
                return;
            }
            this.f32060s0.a(intent);
        }
    }

    @Override // java.util.Observer
    public void update(final Observable observable, final Object obj) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            F3(observable, obj);
        } else {
            new Handler(mainLooper).post(new Runnable() { // from class: com.dataline.activities.LiteActivity.38
                @Override // java.lang.Runnable
                public void run() {
                    LiteActivity.this.F3(observable, obj);
                }
            });
        }
    }

    void updateUnreadNumOnTitleBar() {
        final int unreadCountByListType = ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(1);
        runOnUiThread(new Runnable() { // from class: com.dataline.activities.LiteActivity.20
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = LiteActivity.this.f32044d0;
                if (textView == null || !textView.getText().toString().startsWith(LiteActivity.this.getString(R.string.hvn))) {
                    return;
                }
                int i3 = unreadCountByListType;
                if (i3 > 0) {
                    if (i3 > 99) {
                        LiteActivity.this.f32044d0.setText(LiteActivity.this.getString(R.string.hvn) + "(99+)");
                        return;
                    }
                    LiteActivity.this.f32044d0.setText(LiteActivity.this.getString(R.string.hvn) + "(" + unreadCountByListType + ")");
                    return;
                }
                LiteActivity liteActivity = LiteActivity.this;
                liteActivity.f32044d0.setText(liteActivity.getString(R.string.hvn));
            }
        });
    }

    void x4(ArrayList<SendInfo> arrayList, int i3) {
        if (arrayList == null) {
            return;
        }
        DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        while (true) {
            int size = arrayList.size();
            if (size <= 3) {
                for (int i16 = 0; i16 < size; i16++) {
                    K3(dataLineHandler, arrayList.get(i16), i3, 0, 0, 0);
                }
                return;
            }
            if (size > 3 && size < 50) {
                ArrayList arrayList2 = new ArrayList();
                int s36 = dataLineHandler.s3();
                ArrayList arrayList3 = arrayList2;
                for (int i17 = 0; i17 < size; i17++) {
                    DataLineMsgRecord K3 = K3(dataLineHandler, arrayList.get(i17), i3, s36, size, i17);
                    if (K3 != null) {
                        arrayList3.add(K3);
                    }
                    if (DataLineMsgSet.isSingle(i3, s36)) {
                        if (K3 != null) {
                            K3.groupId = 0;
                            K3.groupIndex = 0;
                            K3.groupSize = 0;
                        }
                        arrayList3.size();
                        arrayList3 = new ArrayList();
                    }
                }
                arrayList3.size();
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            int s37 = dataLineHandler.s3();
            ArrayList arrayList5 = arrayList4;
            for (int i18 = 0; i18 < 50; i18++) {
                DataLineMsgRecord K32 = K3(dataLineHandler, arrayList.get(i18), i3, s37, 50, i18);
                if (K32 != null) {
                    arrayList5.add(K32);
                }
                if (DataLineMsgSet.isSingle(i3, s37)) {
                    if (K32 != null) {
                        K32.groupId = 0;
                        K32.groupIndex = 0;
                        K32.groupSize = 0;
                    }
                    arrayList5.size();
                    arrayList5 = new ArrayList();
                }
            }
            arrayList5.size();
            for (int i19 = 0; i19 < 50; i19++) {
                arrayList.remove(0);
            }
        }
    }

    void y3(com.dataline.util.h hVar) {
        String str;
        String format;
        if (!NetworkUtil.isNetSupport(getActivity())) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.cjm);
            return;
        }
        DataLineMsgSet d16 = hVar.d();
        if (!FileManagerUtil.is2GOr3G() || !d16.isFileType() || d16.getFileTotalSize() <= 3145728) {
            str = "";
        } else {
            str = getString(R.string.b_x);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DataLineMsgRecord> it = d16.values().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            DataLineMsgRecord next = it.next();
            if (DataLineMsgSet.isCanReciveOrResend(next)) {
                j3 += next.filesize;
                arrayList.add(Long.valueOf(next.sessionid));
            }
        }
        if (arrayList.size() == 0 && !d16.isSingle()) {
            int totalCount = d16.getTotalCount() - d16.getComeCount();
            if (d16.getGroupType() != -2000 && (d16.getGroupType() != -2335 || !d16.getFirstItem().bIsMoloImage)) {
                format = String.format(getString(R.string.c4n), Integer.valueOf(totalCount));
            } else {
                format = String.format(getString(R.string.c4b), Integer.valueOf(totalCount));
            }
            DialogUtil.createCustomDialog(this, 230, getString(R.string.f171080c42), format, R.string.f171151ok, R.string.f171151ok, (DialogInterface.OnClickListener) null, new j()).show();
            return;
        }
        if (d16.isSendFromLocal() && !com.tencent.mobileqq.filemanager.util.q.f(d16.getFirstItem().path)) {
            a5(j3, d16, arrayList, true);
            return;
        }
        if (str.equals("") && d16.getGroupType() == -2000 && !d16.isSingle()) {
            str = String.format(getString(R.string.c4d), Integer.valueOf(arrayList.size()));
        }
        if (str.equals("")) {
            str = getString(R.string.f171087c53);
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.setMainTitle(str);
        actionSheet.addButton(getResources().getString(R.string.bf7), 1);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new k(j3, d16, arrayList, actionSheet));
        actionSheet.show();
    }

    void y4(List<String> list) {
        if (list == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String str : list) {
            int fileType = FileManagerUtil.getFileType(str);
            if (2 == fileType) {
                arrayList2.add(str);
            } else if (fileType == 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
            new an().execute(bundle);
        }
        if (!arrayList2.isEmpty()) {
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList2);
            new ao().execute(bundle2);
        }
    }

    void z3(com.dataline.util.h hVar) {
        String str;
        if (!NetworkUtil.isNetSupport(getActivity())) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.cjm);
            return;
        }
        DataLineMsgSet d16 = hVar.d();
        if (FileManagerUtil.is2GOr3G() && d16.isFileType() && d16.getFileTotalSize() > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            str = getString(R.string.f170958ba0);
        } else if (d16.getGroupType() == -1000) {
            str = getString(R.string.c56);
        } else if (d16.getGroupType() != -2000 || d16.isSingle()) {
            str = "";
        } else {
            Iterator<DataLineMsgRecord> it = d16.values().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (DataLineMsgSet.isCanReciveOrResend(it.next())) {
                    i3++;
                }
            }
            str = String.format(getString(R.string.c4e), Integer.valueOf(i3));
        }
        if (str.equals("")) {
            str = getString(R.string.f171089c55);
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.setMainTitle(str);
        actionSheet.addButton(getResources().getString(R.string.bf8), 1);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new i(d16, hVar, actionSheet));
        actionSheet.show();
    }

    void z4(ArrayList<String> arrayList, int i3) {
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f32035e1, 2, "sendMultipleFile paths is null !!!!!!");
                return;
            }
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (com.tencent.qqnt.aio.element.file.util.a.e(next) == 0) {
                arrayList2.add(next);
            } else {
                arrayList3.add(next);
            }
        }
        if (arrayList2.size() >= 4) {
            arrayList = arrayList3;
        } else {
            arrayList2.clear();
        }
        Iterator<String> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).myComputerSendFileFromPhoto(PeerUid.DATALINE_PC_UID, it5.next());
        }
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "sendMultipleFile");
        ((IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class)).navigateToAIOActivity(this, 8, PeerUid.DATALINE_PC_UID, getResources().getString(R.string.c5f), 0L, new Bundle());
        if (!arrayList2.isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.dataline.activities.LiteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).myComputerSendMultiFileFromPhoto(PeerUid.DATALINE_PC_UID, arrayList2);
                }
            }, 800L);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class af implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataLineMsgRecord f32147a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f32148b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32149c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f32150d;

        af(DataLineMsgRecord dataLineMsgRecord, FileManagerEntity fileManagerEntity, String str, String str2) {
            this.f32147a = dataLineMsgRecord;
            this.f32148b = fileManagerEntity;
            this.f32149c = str;
            this.f32150d = str2;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(this.f32147a.sessionid);
            if (this.f32148b == null) {
                com.tencent.mobileqq.filemanager.util.d.h(FileManagerUtil.cutLongName(this.f32149c) + LiteActivity.this.getString(R.string.f170976be1));
                this.f32147a.nWeiyunSessionId = LiteActivity.this.app.getFileManagerEngine().F0(this.f32150d, null, LiteActivity.this.app.getAccount(), "", 0, false).nSessionId;
                LiteActivity.this.app.getMessageFacade().t1(devTypeBySeId).j(this.f32147a.msgId);
                return;
            }
            com.tencent.mobileqq.filemanager.util.d.h(FileManagerUtil.cutLongName(this.f32149c) + LiteActivity.this.getString(R.string.f170976be1));
            LiteActivity.this.app.getFileManagerEngine().o0(this.f32147a.nWeiyunSessionId);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class u implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f32193a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f32194b;

        u(ArrayList arrayList, ArrayList arrayList2) {
            this.f32193a = arrayList;
            this.f32194b = arrayList2;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            if (!this.f32193a.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.f32193a);
                new an().execute(bundle);
            }
            if (!this.f32194b.isEmpty()) {
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("PhotoConst.PHOTO_PATHS", this.f32194b);
                new ao().execute(bundle2);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ae extends com.tencent.mobileqq.widget.f {
        ae() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LiteActivity.this.N0.setPadding(0, 0, 0, 0);
            ((FrameLayout.LayoutParams) LiteActivity.this.f32057p0.getLayoutParams()).setMargins(0, 0, 0, 0);
            LiteActivity liteActivity = LiteActivity.this;
            liteActivity.f32057p0.setPadding(BaseAIOUtils.f(24.0f, liteActivity.app.getApplication().getResources()), BaseAIOUtils.f(10.0f, LiteActivity.this.app.getApplication().getResources()), BaseAIOUtils.f(24.0f, LiteActivity.this.app.getApplication().getResources()), 0);
            LiteActivity.this.N0.getLayoutParams().height = -1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void E() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ag implements OverScrollViewListener {
        ag() {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            LiteActivity.this.k4();
            return true;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class ai implements TextWatcher {
        ai() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LiteActivity.this.e5();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
