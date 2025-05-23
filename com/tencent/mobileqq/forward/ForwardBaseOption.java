package com.tencent.mobileqq.forward;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.dataline.activities.LiteActivity;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkQQApi;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog;
import com.tencent.mobileqq.forward.dialog.ForwardDialog;
import com.tencent.mobileqq.forward.preview.ForwardPreView;
import com.tencent.mobileqq.forward.preview.ForwardPreViewForShareActionSheet;
import com.tencent.mobileqq.forward.preview.ForwardPreViewForShareDialog;
import com.tencent.mobileqq.forward.preview.ForwardPreviewConst$PreviewType;
import com.tencent.mobileqq.forward.utils.TempChatUtils;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IShareReport;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendShareApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.IForwardPreviewPanelApi;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.cw;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import com.tencent.qqnt.aio.gallery.api.INTGalleryApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k0.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class ForwardBaseOption extends com.tencent.mobileqq.forward.a implements com.tencent.mobileqq.forward.e, com.tencent.mobileqq.forward.f, DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_ = null;
    private static final int ACTION_CLICK = 2;
    private static final int ACTION_EXPOSE = 1;
    public static final int DATA_LINE_PC_FIRST_ORDER = 2;
    public static final int DATA_LINE_PC_KEEP_RECENT_ORDER = 1;
    public static final int DATA_LINE_PC_NO_NEED = 0;
    public static final String FORWARD_INPUT_VIEW_HIDE = "share_dialog_input_view_hide";
    private static final String GUILD_FORWARD_BUGFIX_SWITCH = "guild_forward_fix_switch";
    private static final String KEY_BUNDLE = "key_forward_base_option_bundle";
    public static String KEY_THUMB_STYLE_CENTERINSIDE = null;
    public static String PERFORMANCE_TAG = null;
    private static final String QQ_RELATION_FORWARD_PREVIEW = "qq_relation_forward_preview";
    public static final String TAG = "ForwardOption.ForwardBaseOption";
    public static volatile long clickShareBeginTime;
    public static volatile long decodeRoundTime;
    public static volatile long loadPicTime;
    static int mURLDrawableUrlWidth;
    static SimpleDateFormat sSdf;
    public static volatile long threadChagedTime;
    protected QQAppInterface app;
    protected long appid;
    public boolean fromCreateDiscussion;
    boolean isFormJump;
    private boolean isFromFav;
    boolean isNOneedJumpToAIO;
    protected boolean isSdkShare;
    boolean isURLDrawablFoward;
    protected Activity mActivity;
    protected Context mAppContext;
    String mBigURLDrawableUrl;
    protected String mBottomSheetPreviewLeaveMessage;
    protected String mCallActivity;
    protected QQCustomDialog mConfirmDialog;
    float mDensity;
    protected List<q> mEventListeners;
    protected Bundle mExtraData;
    protected Set<Integer> mForwardAbilities;
    protected ArrayList<ResultRecord> mForwardDataLineTargets;
    protected ForwardPreView mForwardPreView;
    protected int mForwardReportType;
    private ArrayList<ResultRecord> mForwardTargets;
    protected ArrayList<ResultRecord> mForwardTargetsWithoutDataLine;
    protected String mForwardText;
    String mForwardThumb;
    protected boolean mFromSharePanelPreviewAndSend;
    protected Intent mIntent;
    protected boolean mIsFromDatalineAIO;
    protected boolean mIsFromOutsideShare;
    protected boolean mNeedInterrupFinishActivity;
    DialogInterface.OnClickListener mOnCancleListener;
    DialogInterface.OnClickListener mOnConfirmListener;
    View.OnClickListener mOnEditListener;
    private Bundle mOriginExtraData;
    protected QQProgressDialog mProgressDialog;
    protected QQProgressDialog mQQProgressDialog;
    protected com.tencent.biz.widgets.f mResultDlg;
    DialogInterface.OnClickListener mResultListener;
    private QQProgressDialog mSendingProgressDialog;
    protected com.tencent.mobileqq.sharehelper.e mShareActionReportHelper;
    protected int mShareDataLineSupportType;
    protected String mSharePanelLeaveMsg;
    protected com.tencent.biz.widgets.e mShareResultDialog;
    protected boolean mSurpportTroopDiscussionTmpConv;
    String mURLDrawableUrl;
    com.tencent.mobileqq.discussion.observer.a updateDiscussionInfoObserver;
    protected boolean useBottomSheetPreviewFromBusiness;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f210584d;

        a(String str) {
            this.f210584d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(ForwardBaseOption.this.app, "CliOper", "", "", "0X800514A", "0X800514A", 0, 0, "", "", "", "");
                Parcelable parcelable = ForwardBaseOption.this.mExtraData.getParcelable(AppConstants.Key.FORWARD_MSG_FOR_PIC);
                if (parcelable instanceof MessageForPic) {
                    ForwardBaseOption.this.startToAioImagePreviewWithPath(view, ((MessageForPic) parcelable).path, this.f210584d);
                } else if (!(parcelable instanceof AIOImageData)) {
                    ForwardBaseOption.this.handleClickOtherData(view, this.f210584d);
                } else if (!r05.a.c()) {
                    ForwardBaseOption.this.handleClickAIOImageData((AIOImageData) parcelable, this.f210584d);
                } else {
                    QLog.d(ForwardBaseOption.TAG, 1, "handleClickAIOImageData oldSwitchOpen return");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements r {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements com.tencent.mobileqq.sharepanel.forward.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.f
        @Nullable
        public View a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            return ForwardBaseOption.this.getContentPreview();
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.f
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return ForwardBaseOption.this.needSendMessage();
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.f
        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements com.tencent.mobileqq.sharepanel.forward.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.a
        public void a(@NotNull CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
                return;
            }
            ForwardBaseOption.this.mBottomSheetPreviewLeaveMessage = charSequence.toString();
            ForwardBaseOption.this.getConfirmListener().onClick(null, 0);
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.a
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.i(ForwardBaseOption.TAG, 1, "BottomSheetPreviewDialog onCancel.");
                ForwardBaseOption.this.forwardOnCancel();
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.a
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                QLog.i(ForwardBaseOption.TAG, 1, "BottomSheetPreviewDialog onDismiss.");
                ForwardBaseOption.this.onDismiss(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements com.tencent.mobileqq.sharepanel.forward.e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.e
        @androidx.annotation.Nullable
        public Map<String, Object> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("come_from", 2);
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements ForwardNewVersionDialog.j {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // com.tencent.mobileqq.forward.ForwardNewVersionDialog.j
        public boolean a(View view) {
            ArrayList<ResultRecord> parcelableArrayList;
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            }
            boolean[] booleanArray = ForwardBaseOption.this.mExtraData.getBooleanArray(AppConstants.Key.FORWARD_IS_WRITE_TOGETHER);
            try {
                parcelableArrayList = ForwardBaseOption.this.mExtraData.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
                string = ForwardBaseOption.this.mExtraData.getString(AppConstants.Key.FORWARD_SOURCE_UIN);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                for (ResultRecord resultRecord : parcelableArrayList) {
                    if (resultRecord.getUinType() == 1 && string.equals(resultRecord.uin)) {
                        for (boolean z16 : booleanArray) {
                            if (z16) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            String string2 = ForwardBaseOption.this.mExtraData.getString("uin");
            if (ForwardBaseOption.this.mExtraData.getInt("uintype") == 1 && string2.equals(string)) {
                for (boolean z17 : booleanArray) {
                    if (z17) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements ForwardDialog.i {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // com.tencent.mobileqq.forward.dialog.ForwardDialog.i
        public boolean a(View view) {
            ArrayList<ResultRecord> parcelableArrayList;
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            }
            boolean[] booleanArray = ForwardBaseOption.this.mExtraData.getBooleanArray(AppConstants.Key.FORWARD_IS_WRITE_TOGETHER);
            try {
                parcelableArrayList = ForwardBaseOption.this.mExtraData.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
                string = ForwardBaseOption.this.mExtraData.getString(AppConstants.Key.FORWARD_SOURCE_UIN);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                for (ResultRecord resultRecord : parcelableArrayList) {
                    if (resultRecord.getUinType() == 1 && string.equals(resultRecord.uin)) {
                        for (boolean z16 : booleanArray) {
                            if (z16) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            String string2 = ForwardBaseOption.this.mExtraData.getString("uin");
            if (ForwardBaseOption.this.mExtraData.getInt("uintype") == 1 && string2.equals(string)) {
                for (boolean z17 : booleanArray) {
                    if (z17) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h extends a.c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    k0.a.j(ForwardBaseOption.this.mActivity, 0);
                    ForwardBaseOption.this.mActivity.finish();
                }
            }
        }

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // k0.a.c
        public void b(AsyncTask<Integer, Integer, String> asyncTask, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) asyncTask, i3);
                return;
            }
            try {
                k0.a.o(ForwardBaseOption.this.mActivity, asyncTask, i3, new a());
                super.b(asyncTask, i3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i extends a.c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f210595a;

            a(Runnable runnable) {
                this.f210595a = runnable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) runnable);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                this.f210595a.run();
                k0.a.j(ForwardBaseOption.this.mActivity, 0);
                ForwardBaseOption.this.mActivity.finish();
            }
        }

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // k0.a.c
        public void a(int i3, Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) runnable);
                return;
            }
            try {
                k0.a.o(ForwardBaseOption.this.mActivity, null, i3, new a(runnable));
                super.a(i3, runnable);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 != -2) {
                if (i3 == -1) {
                    if (ForwardBaseOption.this.isSdkShare) {
                        ReportCenter.f().q(ForwardBaseOption.this.app.getAccount(), "", String.valueOf(ForwardBaseOption.this.appid), "1000", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "0", false, ForwardBaseOption.this.isSdkShare);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(ForwardBaseOption.TAG, 2, "-->showQfavResultDialog--onClick--send call");
                    }
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(ForwardBaseOption.this.appid), "shareToQQ")));
                    intent.setPackage(ForwardBaseOption.this.mActivity.getIntent().getStringExtra("pkg_name"));
                    PendingIntent activity = PendingIntent.getActivity(ForwardBaseOption.this.mActivity, 0, intent, 335544320);
                    Intent intent2 = new Intent();
                    intent2.putExtra(AppConstants.Key.SHARE_FLAG, true);
                    if (ForwardBaseOption.this.appid > 0) {
                        intent2.putExtra(AppConstants.Key.ACTIVITY_FINISH_RUN_PENDING_INTENT, activity);
                    }
                    ForwardBaseOption forwardBaseOption = ForwardBaseOption.this;
                    QfavHelper.i(forwardBaseOption.mActivity, forwardBaseOption.app.getAccount(), intent2, -1, true);
                    cooperation.qqfav.d.g(ForwardBaseOption.this.app, 5, 0);
                    ForwardBaseOption.this.mActivity.setResult(1);
                    return;
                }
                return;
            }
            if (ForwardBaseOption.this.isSdkShare) {
                ReportCenter.f().q(ForwardBaseOption.this.app.getAccount(), "", String.valueOf(ForwardBaseOption.this.appid), "1000", "51", "0", false, ForwardBaseOption.this.isSdkShare);
            }
            ForwardBaseOption.this.endForwardCallback(true);
            ForwardBaseOption.this.mActivity.setResult(1);
            ForwardBaseOption.this.mActivity.finish();
            if (QLog.isColorLevel()) {
                QLog.i(ForwardBaseOption.TAG, 2, "-->showQfavResultDialog--onClick--back call");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class k extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void w(boolean z16, Object obj) {
            DiscussionInfo h16;
            QQCustomDialog qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(ForwardBaseOption.TAG, 2, "updateDiscussionInfo start: isSuccess=" + z16);
            }
            String string = ForwardBaseOption.this.mExtraData.getString("uin");
            ArrayList arrayList = (ArrayList) obj;
            int indexOf = arrayList.indexOf(string);
            if (indexOf != -1) {
                Boolean bool = (Boolean) arrayList.get(indexOf + 1);
                if (z16 && bool.booleanValue() && (h16 = ((com.tencent.mobileqq.app.n) ForwardBaseOption.this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(string)) != null && !TextUtils.isEmpty(h16.discussionName) && (qQCustomDialog = ForwardBaseOption.this.mConfirmDialog) != null) {
                    qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.mod) + com.tencent.mobileqq.forward.f.f211019g4 + h16.discussionName);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f210599a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72024);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ForwardPreviewConst$PreviewType.values().length];
            f210599a = iArr;
            try {
                iArr[ForwardPreviewConst$PreviewType.SHARE_ACTION_SHEET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f210599a[ForwardPreviewConst$PreviewType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ForwardBaseOption.TAG, 2, "-->qbShowShareResultDialog--stay");
                    }
                    ForwardBaseOption.this.mActivity.finish();
                    Intent aliasIntent = SplashActivity.getAliasIntent(ForwardBaseOption.this.mActivity);
                    aliasIntent.addFlags(335544320);
                    ForwardBaseOption.this.mActivity.startActivity(aliasIntent);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(ForwardBaseOption.TAG, 2, "qbShowShareResultDialog back");
            }
            if (!ForwardBaseOption.this.mActivity.isFinishing()) {
                ForwardBaseOption.this.mShareResultDialog.dismiss();
            }
            ForwardBaseOption.this.mActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements Function0<Unit> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                QLog.d(ForwardBaseOption.TAG, 1, "onClick call forward");
                n.this.a();
                return null;
            }
        }

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        void a() {
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).clearExpandGuildList();
            ForwardBaseOption.this.updateRecentForwardUser();
            Iterator<q> it = ForwardBaseOption.this.mEventListeners.iterator();
            while (it.hasNext()) {
                it.next().a(ForwardBaseOption.this);
            }
            Bundle bundle = ForwardBaseOption.this.mExtraData;
            if (bundle != null) {
                boolean z16 = bundle.getBoolean("needShareCallBack");
                int i3 = ForwardBaseOption.this.mExtraData.getInt("miniAppShareFrom");
                boolean z17 = ForwardBaseOption.this.mExtraData.getBoolean("miniAppNeedOnlyPreview", false);
                if (z17) {
                    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_DIRECT_SHARE_SUC_CALLBACK, null, null);
                } else if (z16) {
                    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
                }
                ForwardBaseOption.this.reportMiniAppClickConfirm(i3);
                String string = ForwardBaseOption.this.mExtraData.getString("miniAppShareAppid");
                int i16 = ForwardBaseOption.this.mExtraData.getInt("miniAppShareAppType");
                int i17 = ForwardBaseOption.this.mExtraData.getInt("miniAppShareScene");
                int i18 = ForwardBaseOption.this.mExtraData.getInt("miniAppShareType");
                int i19 = ForwardBaseOption.this.mExtraData.getInt("uintype");
                String string2 = ForwardBaseOption.this.mExtraData.getString("uin");
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportShare(string, i16, i17, i18, i19, string2);
                if (z17) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ForwardBaseOption.TAG, 2, "deal OnClickListener return by needOnlyPreview");
                        return;
                    }
                    return;
                }
                if (IShareChatApi.GAV_ARK_APP_NAME.equalsIgnoreCase(ForwardBaseOption.this.mExtraData.getString("forward_ark_app_name")) && !ForwardBaseOption.this.isMultiTarget2Send()) {
                    IShareChatApi iShareChatApi = (IShareChatApi) QRoute.api(IShareChatApi.class);
                    ForwardBaseOption forwardBaseOption = ForwardBaseOption.this;
                    if (iShareChatApi.shareGAVArkMsg(forwardBaseOption.app, forwardBaseOption.mExtraData.getString("forward_ark_app_meta"), string2, i19, ForwardBaseOption.this.getQavInputStr())) {
                        if (QLog.isColorLevel()) {
                            QLog.d(ForwardBaseOption.TAG, 2, "deal OnClickListener return by ark message");
                            return;
                        }
                        return;
                    }
                }
                if (ForwardBaseOption.this.singleTargetSendLocalProcess()) {
                    QLog.d(ForwardBaseOption.TAG, 2, "deal OnClickListener return by singleTargetSendLocalProcess");
                    return;
                }
                if (ForwardBaseOption.this.isMultiTarget2Send()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ForwardBaseOption.TAG, 2, "deal OnClickListener doing isMultiTarget2Send");
                    }
                    ForwardBaseOption.this.sendToMultiTarget();
                } else if (!ForwardBaseOption.this.sendToSingleTarget(string)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ForwardBaseOption.TAG, 2, "sendToSingleTarget return false");
                        return;
                    }
                    return;
                }
            }
            ForwardBaseOption.this.dialogExposeOrClickDaTongReport(2);
            Bundle bundle2 = ForwardBaseOption.this.mExtraData;
            if (bundle2 != null && bundle2.getBoolean(ForwardRecentActivity.KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS, false)) {
                ReportController.o(ForwardBaseOption.this.app, "dc00898", "", "", "0X800A4A2", "0X800A4A2", 0, 0, "0", "", "", "");
            }
            ForwardBaseOption.this.reportEmotionMachineEvents();
            if ("caller_aecamera".equals(ForwardBaseOption.this.mCallActivity)) {
                ForwardBaseOption.this.reportToAECameraEvents();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.i(ForwardBaseOption.TAG, 1, "before prepareTempChat uin=" + ForwardBaseOption.this.mExtraData.getString("uin") + ", toUinType=" + ForwardBaseOption.this.mExtraData.getInt("uintype") + ", guildId=" + ForwardBaseOption.this.mExtraData.getString("guild_id"));
            TempChatUtils tempChatUtils = TempChatUtils.f211074a;
            ForwardBaseOption forwardBaseOption = ForwardBaseOption.this;
            tempChatUtils.a(forwardBaseOption.mActivity, forwardBaseOption.mExtraData, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class o implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ForwardBaseOption.this.forwardOnCancel();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                if (i3 != -2) {
                    if (i3 == -1) {
                        ForwardBaseOption.this.onPositiveResult();
                        return;
                    }
                    return;
                }
                ForwardBaseOption.this.onNegativeResult();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface q {
        void a(ForwardBaseOption forwardBaseOption);

        void b(ForwardBaseOption forwardBaseOption);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface r {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72035);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 153)) {
            redirector.redirect((short) 153);
            return;
        }
        KEY_THUMB_STYLE_CENTERINSIDE = "key_thumb_style_centerinside";
        clickShareBeginTime = 0L;
        loadPicTime = 0L;
        decodeRoundTime = 0L;
        threadChagedTime = 0L;
        PERFORMANCE_TAG = "performance_test";
        sSdf = null;
    }

    public ForwardBaseOption(Intent intent) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.mBottomSheetPreviewLeaveMessage = "";
        this.mResultDlg = null;
        this.isSdkShare = false;
        this.appid = 0L;
        this.fromCreateDiscussion = false;
        this.isNOneedJumpToAIO = false;
        this.isFormJump = false;
        this.mForwardReportType = 11;
        this.mIsFromOutsideShare = false;
        this.mIsFromDatalineAIO = false;
        this.isFromFav = false;
        this.mShareResultDialog = null;
        this.updateDiscussionInfoObserver = new k();
        this.mIntent = intent;
        if (intent.getExtras() != null) {
            bundle = intent.getExtras();
        } else {
            bundle = new Bundle();
        }
        this.mExtraData = bundle;
        this.isFromFav = bundle.getBoolean("isFromFavorites", false);
        this.mFromSharePanelPreviewAndSend = this.mExtraData.getBoolean(AppConstants.Key.SHARE_REQ_FROM_NEW_PANEL, false);
        this.useBottomSheetPreviewFromBusiness = this.mExtraData.getBoolean(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, false);
        this.mAppContext = BaseApplicationImpl.getApplication().getApplicationContext();
        this.mSurpportTroopDiscussionTmpConv = false;
        this.mEventListeners = new ArrayList();
    }

    private void buildDialogWithContentView() {
        ForwardNewVersionDialog forwardNewVersionDialog = new ForwardNewVersionDialog(this.mActivity);
        this.mConfirmDialog = forwardNewVersionDialog;
        forwardNewVersionDialog.y0(!needShowEditInput());
        forwardNewVersionDialog.C0(210);
        forwardNewVersionDialog.s0(buildNewVersionContentView());
        forwardNewVersionDialog.setCanceledOnTouchOutside(false);
        forwardNewVersionDialog.w0(getDialogTitle(), getEditHint(), this.mActivity.getResources().getString(getDialogLeftBtn()), this.mActivity.getResources().getString(getDialogRightBtn()), getConfirmListener(), getCancelListener());
        forwardNewVersionDialog.D0(new f());
        showForwardTargetAvatar(forwardNewVersionDialog);
        if (!this.mActivity.isFinishing()) {
            forwardNewVersionDialog.show();
            dialogExposeOrClickDaTongReport(1);
        }
        this.mConfirmDialog.setOnDismissListener(this);
    }

    private void buildDialogWithPreView() {
        ForwardPreView buildForwardPreView = buildForwardPreView(ForwardPreviewConst$PreviewType.NORMAL);
        if (!(buildForwardPreView instanceof ForwardPreViewForShareDialog)) {
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            ForwardDialog forwardDialog = new ForwardDialog(this.mActivity);
            forwardDialog.u0((ForwardPreViewForShareDialog) buildForwardPreView);
            this.mConfirmDialog = forwardDialog;
            forwardDialog.y0(!needShowEditInput());
            forwardDialog.B0(210);
            forwardDialog.setCanceledOnTouchOutside(false);
            forwardDialog.getWindow().setFlags(256, 256);
            forwardDialog.w0(getDialogTitle(), getEditHint(), this.mActivity.getResources().getString(getDialogLeftBtn()), this.mActivity.getResources().getString(getDialogRightBtn()), getConfirmListener(), getCancelListener());
            forwardDialog.C0(new g());
            showForwardTargetAvatar(forwardDialog);
            if (!this.mActivity.isFinishing()) {
                forwardDialog.show();
                dialogExposeOrClickDaTongReport(1);
            }
            this.mConfirmDialog.setOnDismissListener(this);
            return;
        }
        QLog.e(TAG, 1, "buildDialogWithPreView mActivity status error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dialogExposeOrClickDaTongReport(int i3) {
        if (this.mShareActionReportHelper == null) {
            initShareActionReportHelper();
        }
        if (i3 == 1) {
            this.mShareActionReportHelper.e("em_sendview_send_button");
        } else {
            this.mShareActionReportHelper.c("em_sendview_send_button");
        }
    }

    private ArrayList<SharePanelContactItem> getItemFromForwardTargets() {
        ArrayList<SharePanelContactItem> arrayList = new ArrayList<>();
        Iterator<ResultRecord> it = this.mForwardTargets.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            String str = next.uin;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String str3 = next.name;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = next.guildId;
            if (str4 != null) {
                str2 = str4;
            }
            SharePanelContactItem sharePanelContactItem = new SharePanelContactItem(str, next.uinType, str3);
            sharePanelContactItem.k(str2);
            arrayList.add(sharePanelContactItem);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable getNormalDrawable(String str) {
        URL generateURLForNew;
        Exception e16;
        URLDrawable uRLDrawable;
        if (str == null || (generateURLForNew = RegionalThumbDownloader.generateURLForNew(str, ScreenUtil.dip2px(100.0f), ScreenUtil.dip2px(300.0f))) == null || !AbsDownloader.hasFile(generateURLForNew.toString())) {
            return null;
        }
        String url = generateURLForNew.toString();
        if (!TextUtils.isEmpty(url)) {
            str = url;
        }
        try {
            uRLDrawable = URLDrawable.getDrawable(str);
            try {
                URLDrawableHelper.decodeLocalImage(uRLDrawable, null, false);
            } catch (Exception e17) {
                e16 = e17;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getNormalDrawable urlString url is illegal = " + e16);
                }
                return uRLDrawable;
            }
        } catch (Exception e18) {
            e16 = e18;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    private ArrayList<SharePanelContactItem> getTargetList() {
        ArrayList<SharePanelContactItem> arrayList = new ArrayList<>();
        if (isMultiTarget2Send()) {
            arrayList.addAll(getItemFromForwardTargets());
        } else {
            String string = this.mExtraData.getString("uin");
            int i3 = this.mExtraData.getInt("uintype", 0);
            if (TextUtils.isEmpty(string)) {
                QLog.e(TAG, 1, "buildBottomSheetDialog but uin is empty.");
                return arrayList;
            }
            String uinNameByUinType = getUinNameByUinType(i3);
            if (TextUtils.isEmpty(uinNameByUinType)) {
                QLog.e(TAG, 1, "buildBottomSheetDialog but name is empty.");
                return arrayList;
            }
            arrayList.add(new SharePanelContactItem(string, i3, uinNameByUinType));
        }
        return arrayList;
    }

    private String getTitleStr(String str) {
        String qqStr = HardCodeUtil.qqStr(R.string.mog);
        if (str.startsWith(qqStr)) {
            str = str.substring(qqStr.length());
        }
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable getURLDrawable() {
        String str;
        String str2 = this.mBigURLDrawableUrl;
        if (str2 != null && AbsDownloader.hasFile(str2)) {
            str = this.mBigURLDrawableUrl;
        } else {
            str = this.mURLDrawableUrl;
        }
        if (str != null) {
            File uRLDrawableForwardImageFile = getURLDrawableForwardImageFile(str, HippyBridge.URI_SCHEME_FILE);
            if (uRLDrawableForwardImageFile != null && uRLDrawableForwardImageFile.exists()) {
                String absolutePath = uRLDrawableForwardImageFile.getAbsolutePath();
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(absolutePath) { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.15
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f210571d;

                    {
                        this.f210571d = absolutePath;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this, (Object) absolutePath);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ForwardBaseOption.this.mExtraData.putString("EditImagePath", this.f210571d);
                        }
                    }
                });
                URL generateURLForNew = RegionalThumbDownloader.generateURLForNew(absolutePath, ScreenUtil.dip2px(100.0f), ScreenUtil.dip2px(300.0f));
                if (generateURLForNew != null) {
                    str = generateURLForNew.toString();
                }
                if (TextUtils.isEmpty(str)) {
                    str = absolutePath;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getURLDrawable updateImageView  fixedUrlString=" + str);
                }
            }
            try {
                return URLDrawable.getDrawable(str);
            } catch (Exception e16) {
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.d(TAG, 2, "getURLDrawable fixedUrlString url is illegal = " + e16);
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "getURLDrawable isURLDrawablFoward is true, but mBigURLDrawableUrl and URLDrawableUrl are null");
        }
        return null;
    }

    private File getURLDrawableForwardImageFile(String str, String str2) {
        File file;
        if (str.toLowerCase(Locale.US).startsWith(str2)) {
            file = null;
            try {
                if (str.substring(0, str2.length()).equalsIgnoreCase(str2)) {
                    file = new File(str.substring(str2.length()));
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        } else {
            file = AbsDownloader.getFile(AbsDownloader.covertUrlForAioImage(str));
        }
        boolean booleanExtra = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if (booleanExtra || booleanExtra2) {
            return new File(this.mURLDrawableUrl);
        }
        return file;
    }

    private String getUinNameByUinType(int i3) {
        String qqStr;
        if (i3 != 6000) {
            if (i3 != 6003) {
                if (i3 != 6005) {
                    qqStr = this.mExtraData.getString("uinname");
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f169742j6);
                }
            } else if (((RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                qqStr = "\u6211\u7684iPad";
            } else {
                qqStr = "\u6211\u7684Pad";
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.cf5);
        }
        if (qqStr == null) {
            return "";
        }
        return qqStr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickAIOImageData(AIOImageData aIOImageData, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getImageEditListener from AIOImageData");
        }
        if (aIOImageData.f(4) && aIOImageData.a(4) != null) {
            startToAioImagePreview(aIOImageData, str);
            return;
        }
        if (aIOImageData.f(2) && aIOImageData.a(2) != null) {
            startToAioImagePreview(aIOImageData, str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Edit Forward Image: image does not exist");
        }
    }

    private void handleClickMessageForPic(MessageForPic messageForPic, String str, r rVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getImageEditListener from MessageForPic");
        }
        File file = new File(messageForPic.path);
        if (file.exists()) {
            file.length();
        }
        startToAioImagePreview(messageForPic, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickOtherData(View view, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getImageEditListener from other");
        }
        String string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
        if (string != null) {
            startToAioImagePreviewWithPath(view, string, str);
            return;
        }
        if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Edit Forward Image: from QZone");
            }
            this.mExtraData.putBoolean(AppConstants.Key.FORWARD_IS_QZONE_SHARE, true);
            startToAioImagePreviewWithPath(view, this.mForwardThumb, str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Edit Forward Image: Unknown source");
        }
    }

    private void hideSendingDialog() {
        QQProgressDialog qQProgressDialog = this.mSendingProgressDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mSendingProgressDialog.dismiss();
        }
    }

    private void initShareActionReportHelper() {
        int i3;
        this.mShareActionReportHelper = new com.tencent.mobileqq.sharehelper.e(this.mActivity);
        HashMap hashMap = new HashMap();
        StringBuilder sb5 = new StringBuilder();
        ArrayList<ResultRecord> arrayList = this.mForwardTargets;
        if (arrayList == null) {
            sb5.append(this.mExtraData.getString("uin"));
        } else if (arrayList.size() > 0) {
            Iterator<ResultRecord> it = this.mForwardTargets.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().uin);
                sb5.append(",");
            }
        }
        hashMap.put("to_uin", sb5);
        if (isDirectShareDialog()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sendview_pop_source", Integer.valueOf(i3));
        this.mShareActionReportHelper.b(QCircleDaTongConstant.PageId.PG_SENDVIEW_POP, hashMap);
        this.mShareActionReportHelper.a(new ArrayList<String>() { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
                } else {
                    add("em_sendview_send_button");
                }
            }
        });
    }

    private boolean isLegalUinType(RecentUser recentUser) {
        if (recentUser.getType() != 1020 && recentUser.getType() != 1008 && recentUser.getType() != 1005 && recentUser.getType() != 1009 && recentUser.getType() != 1021 && recentUser.getType() != 1001 && recentUser.getType() != 10002 && recentUser.getType() != 10004 && recentUser.getType() != 1022 && recentUser.getType() != 1032 && recentUser.getType() != 6003 && recentUser.getType() != 6005 && recentUser.getType() != 1033 && recentUser.getType() != 1034 && recentUser.getType() != 7000 && recentUser.getType() != 6004 && recentUser.getType() != 9501) {
            return true;
        }
        return false;
    }

    private boolean isNeedAddToList(RecentUser recentUser) {
        if (recentUser != null && !Utils.J(recentUser.uin) && ((recentUser.getType() != 1006 || isSupportAbility(com.tencent.mobileqq.forward.e.U3)) && isLegalUinType(recentUser) && ((recentUser.getType() != 1 || !isHotChat(recentUser.uin)) && ((recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) && ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || this.mSurpportTroopDiscussionTmpConv))))) {
            return true;
        }
        return false;
    }

    public static boolean isTempAIO(Bundle bundle) {
        int i3 = bundle.getInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1);
        if (i3 != 1004 && i3 != 1000) {
            return false;
        }
        return true;
    }

    private void prepareResultTargets() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fs_forward_result_targets_revert", false)) {
            return;
        }
        ArrayList<ResultRecord> arrayList = this.mForwardTargets;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mIntent.putParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET, this.mForwardTargets);
            return;
        }
        String string = this.mExtraData.getString("uin");
        int i3 = this.mExtraData.getInt("uintype", 0);
        String string2 = this.mExtraData.getString("uinname");
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.uin = string;
        resultRecord.uinType = i3;
        resultRecord.name = string2;
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        arrayList2.add(resultRecord);
        this.mIntent.putParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET, arrayList2);
    }

    private void reportEmotionMachineEvent(String str, int i3) {
        Intent intent = this.mIntent;
        if (intent != null && ("ChatActivity".equals(intent.getStringExtra("caller_name")) || "SplashActivity".equals(this.mIntent.getStringExtra("caller_name")))) {
            com.tencent.mobileqq.activity.aio.item.i.h(this.app, i3, this.mIntent.getStringExtra(AppConstants.Key.FORWARD_PHOTO_SENDER_UIN), this.mIntent.getStringExtra(AppConstants.Key.FORWARD_PHOTO_MD5), "0X8009F55", str);
            return;
        }
        Intent intent2 = this.mIntent;
        if (intent2 != null && "PublicTransFragmentActivity".equals(intent2.getStringExtra("caller_name"))) {
            com.tencent.mobileqq.activity.aio.item.i.h(this.app, i3, this.mIntent.getStringExtra(AppConstants.Key.FORWARD_PHOTO_SENDER_UIN), this.mIntent.getStringExtra(AppConstants.Key.FORWARD_PHOTO_MD5), "0X8009F56", str);
        }
    }

    private void reportMatchFriendTestShare(String str, int i3) {
        int i16;
        if (!this.mExtraData.getBoolean(ForwardRecentActivity.KEY_FORWARD_MATCH_FRIEND_TEST_SHARE, false)) {
            return;
        }
        if (i3 == 1046) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        ((IMatchFriendShareApi) QRoute.api(IMatchFriendShareApi.class)).reportShareSendEvent(this.mActivity, this.app, i16, str);
    }

    private void reportShareMusic(boolean z16, boolean z17, int i3, String str) {
        boolean z18;
        String str2;
        String str3;
        if (i3 != 1 && i3 != 2) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportClickSend ,isAudioReqType = " + z16 + ",isMusicArkView = " + z17 + ",isForwardC2cOrGroup = " + z18);
        }
        if ((z16 || z17) && z18) {
            if (i3 == 1) {
                str2 = "c2c_AIO";
            } else {
                str2 = "Grp_AIO";
            }
            String str4 = str2;
            if (i3 == 1) {
                str3 = "";
            } else {
                str3 = str;
            }
            ReportController.o(null, "dc00899", str4, "", "music_tab", "musicark_share", 0, 0, str3, "", "", "");
        }
    }

    private void reportShareVideo(Bundle bundle, int i3, String str) {
        String str2;
        boolean z16;
        String str3;
        long j3 = bundle.getLong("req_share_id", 0L);
        if (j3 == 0) {
            String string = bundle.getString("forward_ark_app_meta");
            if (TextUtils.isEmpty(string)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reportClickSend arkAppId is empty");
                    return;
                }
                return;
            } else {
                str2 = null;
                try {
                    JSONObject optJSONObject = new JSONObject(string).optJSONObject("news");
                    if (optJSONObject != null) {
                        str2 = optJSONObject.optString("appid");
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        } else {
            str2 = j3 + "";
        }
        String str4 = str2;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportClickSend ,isForwardC2cOrGroup = " + z16);
        }
        if ("101492711".equals(str4) && z16) {
            if (i3 == 1) {
                str3 = "c2c_AIO";
            } else {
                str3 = "Grp_AIO";
            }
            ReportController.o(null, "dc00899", str3, "", "video_tab", "videoark_share", 0, 0, str, str4, "", "");
        }
    }

    private void sendDefaultMessage(String str) {
        Bundle bundle;
        if (!TextUtils.isEmpty(str) && (bundle = this.mExtraData) != null) {
            sendMessage2TargetOnConfirm(bundle.getString("uin"), this.mExtraData.getString("troop_uin"), this.mExtraData.getInt("uintype"), str);
        }
    }

    private void showSendingDialog() {
        if (this.mSendingProgressDialog == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mActivity, 0, R.layout.gza, 17);
            this.mSendingProgressDialog = qQProgressDialog;
            qQProgressDialog.setContentView(R.layout.bwu);
            this.mSendingProgressDialog.setMessage("\u6b63\u5728\u53d1\u9001");
            this.mSendingProgressDialog.setCancelable(true);
        }
        if (this.mSendingProgressDialog.isShowing()) {
            this.mSendingProgressDialog.dismiss();
        }
        this.mSendingProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startForward(Context context, Intent intent, Class<?> cls, int i3, String str) {
        if (context != null) {
            com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.k();
            intent.setClass(context, cls);
            intent.putExtra("forward_source_business_type", i3);
            intent.putExtra("forward_source_sub_business_type", str);
            context.startActivity(intent);
        }
    }

    @Deprecated
    public static void startForwardActivity(Context context, Intent intent) {
        startForwardActivity(context, intent, ForwardRecentActivity.class, -1, "");
    }

    @Deprecated
    public static void startForwardActivityForResult(Activity activity, Intent intent, int i3) {
        startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, i3, -1, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startForwardForResult(Activity activity, Intent intent, Class<?> cls, int i3, int i16, String str) {
        com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.k();
        intent.setClass(activity, cls);
        intent.putExtra("caller_name", activity.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", i16);
        intent.putExtra("forward_source_sub_business_type", str);
        activity.startActivityForResult(intent, i3);
    }

    private void startPhotoPlus(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startPhotoPlus: path=" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.mActivity.startActivity(((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this.mActivity, str, true, true, true, true, true, 2, 99, 6));
            this.mActivity.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    private void startToAioImagePreview(MessageForPic messageForPic, String str) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startToAioImagePreview: uniseq=");
            sb5.append(messageForPic != null ? Long.valueOf(messageForPic.uniseq) : "");
            QLog.d(TAG, 2, sb5.toString());
        }
        if (messageForPic != null) {
            AIOImageProviderService aIOImageProviderService = new AIOImageProviderService(this.app.getCurrentUin(), str, 0, messageForPic);
            Bundle bundle = new Bundle();
            bundle.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
            enterImageGallery(bundle, aIOImageProviderService, com.tencent.mobileqq.activity.aio.photo.c.t(messageForPic));
            reportClickContentAction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startToAioImagePreviewWithPath(View view, String str, String str2) {
        ImageView imageView;
        AIOMsgItem d16;
        ArrayList<MsgElement> elements;
        PicElement picElement;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startToAioImagePreviewWithPath: path=" + str);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            if (!new File(str).exists() && (d16 = com.tencent.qqnt.aio.forward.l.e().d()) != null && d16.getMsgRecord() != null && (elements = d16.getMsgRecord().getElements()) != null && !elements.isEmpty() && elements.get(0).getElementType() == 2 && (picElement = elements.get(0).getPicElement()) != null) {
                str = ((INTGalleryApi) QRoute.api(INTGalleryApi.class)).getPicPath(picElement);
            }
            QLog.d(TAG, 1, "imagePath=" + str);
            Bundle bundle = new Bundle();
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            rFWLayerItemMediaInfo.setMediaId("0_0");
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(str);
            rFWPicInfo.setUrl(str);
            rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setBigPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
            ArrayList arrayList = new ArrayList();
            arrayList.add(rFWLayerItemMediaInfo);
            if (view instanceof ImageView) {
                imageView = (ImageView) view;
            } else {
                imageView = null;
            }
            RFWLayerLaunchUtil.addExtraDataToStore(bundle, arrayList);
            RFWLayerLaunchUtil.jumpToGallery(this.mActivity, imageView, arrayList, 0, (Class<? extends CompatPublicActivity>) QQGalleryActivity.class, (Class<? extends CompatPublicFragment>) ForwardLayerFragment.class, bundle);
            reportClickContentAction();
        }
    }

    protected String acquireEmoticonInput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (String) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return getUserInputStr();
    }

    public void addEventListener(q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 151)) {
            iPatchRedirector.redirect((short) 151, (Object) this, (Object) qVar);
        } else {
            this.mEventListeners.add(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addFavoriteAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.mIntent.getBooleanExtra("k_favorites", true)) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.T3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addImageEditListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this);
        } else {
            this.mConfirmDialog.setImageOnClickListener(getImageEditListener(new b()));
        }
    }

    protected void addOtherEditListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addSourceNameView(String str, QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, (Object) str, (Object) qQCustomDialog);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addSourceNameView start! sourceName =" + str);
        }
        if (str != null && !"".equals(str) && qQCustomDialog != null) {
            TextView textView = new TextView(this.mActivity);
            textView.setText(str);
            textView.setTextSize(12.0f);
            textView.setPadding(0, 0, 0, 0);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-8355712);
            qQCustomDialog.addView(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return ((Boolean) iPatchRedirector.redirect((short) 84, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this);
        } else {
            if (TextUtils.isEmpty(this.mForwardText)) {
                return;
            }
            this.mConfirmDialog.setMessageWithEmo(this.mForwardText, this.mDensity);
        }
    }

    public void afterCreateDiscuss(String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            iPatchRedirector.redirect((short) 137, this, str, str2, bundle);
            return;
        }
        this.fromCreateDiscussion = true;
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putString("uin", str);
        bundle2.putInt("uintype", 1);
        bundle2.putBoolean("new_create_troop", true);
        bundle2.putString("uinname", HardCodeUtil.qqStr(R.string.mof) + str2);
        buildForwardDialog(com.tencent.mobileqq.forward.e.Q3.intValue(), bundle2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean allowDiscussAbility() {
        boolean z16;
        ArrayList<DiscussionInfo> k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            return ((Boolean) iPatchRedirector.redirect((short) 118, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (nVar != null && (k3 = nVar.k()) != null && k3.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->allowDiscussAbility--allow = " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean allowFriendAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            return ((Boolean) iPatchRedirector.redirect((short) 120, (Object) this)).booleanValue();
        }
        try {
            return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isHasFriend(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid(), TAG);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "allowFriendAbility get all friend failed: " + e16);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "-->allowFriendAbility--allow = false");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean allowPhoneContactAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            return ((Boolean) iPatchRedirector.redirect((short) 117, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        if (TextUtils.isEmpty(this.app.getAccount())) {
            QLog.e(TAG, 1, "-->allowPhoneContactAbility--allow = false, uin is empty");
            return false;
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService == null || !iPhoneContactService.isBindContactOk()) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->allowPhoneContactAbility--allow = " + z16);
        }
        return z16;
    }

    protected boolean allowQZoneAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return ((Boolean) iPatchRedirector.redirect((short) 121, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->allowQZoneAbility--allow = false");
            return false;
        }
        return false;
    }

    public boolean allowRecentUser(@NonNull RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Boolean) iPatchRedirector.redirect((short) 79, (Object) this, (Object) recentUser)).booleanValue();
        }
        Set<Integer> set = this.mForwardAbilities;
        if (set != null && !set.contains(com.tencent.mobileqq.forward.e.S3) && (AppConstants.DATALINE_PC_UIN.equals(recentUser.uin) || AppConstants.DATALINE_NEW_VERSION_UIN.equals(recentUser.uin))) {
            return false;
        }
        if (this.isFromFav) {
            if (6003 == recentUser.getType() || 6005 == recentUser.getType()) {
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean allowSmartDeviceAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            return ((Boolean) iPatchRedirector.redirect((short) 122, (Object) this)).booleanValue();
        }
        boolean booleanExtra = this.mIntent.getBooleanExtra("sendMultiple", false);
        boolean z16 = true;
        if (MultiMsgManager.w().u() <= 1) {
            z16 = false;
        }
        int i3 = this.mExtraData.getInt(ShortVideoConstants.FROM_BUSI_TYPE);
        if (!booleanExtra && !z16 && i3 != 2) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "-->allowSmartDeviceAbility--allow = false");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->allowSmartDeviceAbility--allow = false");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean allowTroopAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return ((Boolean) iPatchRedirector.redirect((short) 119, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        boolean z17 = false;
        try {
            if (((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache().size() <= 0) {
                z16 = false;
            }
            z17 = z16;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "allowTroopAbility: ", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->allowTroopAbility--allow = " + z17);
        }
        return z17;
    }

    protected final void buildBottomSheetPreviewDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this);
            return;
        }
        com.tencent.mobileqq.sharepanel.forward.g createV2 = ((IForwardPreviewPanelApi) QRoute.api(IForwardPreviewPanelApi.class)).createV2((FragmentActivity) this.mActivity, getTargetList(), new c());
        createV2.b(new d());
        createV2.a(new e());
        createV2.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(11)
    public final void buildConfirmDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (useNewVersionDialog()) {
            if (useBottomSheetPreview()) {
                buildBottomSheetPreviewDialog();
                return;
            } else {
                buildsNewVersionDialog();
                return;
            }
        }
        isShowArkFromSdk();
        int editTextType = getEditTextType();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->buildConfirmDialog--editTextType = " + editTextType);
        }
        if (editTextType == 0) {
            buildNullInputEditTypeConfirmDialog();
        } else if (editTextType == 1) {
            buildSystemEmoticonEditTypeConfirmDialog();
        } else if (editTextType == 2) {
            buildSystemAMDEmojiEmoticonEditTypeConfirmDialog();
        } else if (editTextType == 3) {
            this.mConfirmDialog = com.tencent.mobileqq.utils.ak.j(this.mActivity, getDialogTitle(), getDialogContent(), null, getConfirmListener(), getCancelListener(), this.mActivity.getResources().getInteger(R.integer.f167158k), false);
        } else if (editTextType == 4) {
            this.mConfirmDialog = com.tencent.mobileqq.utils.ak.l(this.mActivity, getDialogTitle(), this.mExtraData.getString("choose_friend_content"), this.mExtraData.getString("choose_friend_subcontent"), this.mExtraData.getStringArrayList("choose_friend_feedbacks"), null, getConfirmListener(), getCancelListener(), this.mActivity.getResources().getInteger(R.integer.f167158k), false);
        } else {
            this.mConfirmDialog = com.tencent.mobileqq.utils.ak.j(this.mActivity, getDialogTitle(), getDialogContent(), null, getConfirmListener(), getCancelListener(), this.mActivity.getResources().getInteger(R.integer.f167158k), false);
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog instanceof cw) {
            showForwardTargetAvatar((cw) qQCustomDialog);
        }
        String editHint = getEditHint();
        if (!TextUtils.isEmpty(editHint)) {
            this.mConfirmDialog.setEditLint(editHint);
        }
        if (this.mExtraData.getBoolean("miniAppNeedOnlyPreview", false)) {
            ((QQCustomArkDialog) this.mConfirmDialog).J0(getDialogTitle());
            ((QQCustomArkDialog) this.mConfirmDialog).K0();
        }
        hideDialogInputViewProcess();
        this.mConfirmDialog.setOnDismissListener(this);
        this.mConfirmDialog.adjustTitle();
        adjustDialogProperty();
        this.mConfirmDialog.setMsgMaxLineWithEnd(this.mForwardText, 3, QQEmojiUtil.containsEmoji(this.mForwardText), QQSysFaceUtil.containsExpression(this.mForwardText));
        if (addStructView(this.mConfirmDialog)) {
            updateImageView(this.mForwardThumb, this.mConfirmDialog);
        }
        if (this.mExtraData.getInt(KEY_THUMB_STYLE_CENTERINSIDE, 0) == 1) {
            this.mConfirmDialog.setPreviewImageScaleType(true);
        }
        SimpleModeHelper.y(this.mConfirmDialog);
        if (!this.mActivity.isFinishing()) {
            this.mConfirmDialog.show();
            dialogExposeOrClickDaTongReport(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.O3);
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.P3);
        }
        if (allowPhoneContactAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.U3);
        }
        if (allowQZoneAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.R3);
        }
        this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.V3);
    }

    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, i3, (Object) bundle);
            return;
        }
        clickShareBeginTime = System.currentTimeMillis();
        if (!handleDialog()) {
            return;
        }
        if (this.mOriginExtraData == null) {
            this.mOriginExtraData = new Bundle();
        }
        this.mOriginExtraData.clear();
        this.mOriginExtraData.putAll(this.mExtraData);
        if (i3 >= 0) {
            this.mExtraData.putInt("key_forward_ability_type", i3);
        }
        if (bundle != null) {
            this.mIsFromOutsideShare = bundle.getBoolean(AppConstants.Key.FORWARD_FROM_OUTSIDE_SHARE, false);
            this.mIsFromDatalineAIO = bundle.getBoolean(AppConstants.Key.FORWARD_FROM_DATALINE_AIO, false);
            ((IShareReport) QRoute.api(IShareReport.class)).setUinType(String.valueOf(this.mExtraData.getInt("uintype")));
            this.mCallActivity = bundle.getString("caller_name", "");
            this.mExtraData.putAll(bundle);
        }
        prepareForwardTargets();
        prepareResultTargets();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[FORWARD_SHOW_DIALOG]invoke ForwardOption.buildConfirmDialog");
        }
        buildConfirmDialog();
    }

    public ForwardPreView buildForwardPreView(ForwardPreviewConst$PreviewType forwardPreviewConst$PreviewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (ForwardPreView) iPatchRedirector.redirect((short) 101, (Object) this, (Object) forwardPreviewConst$PreviewType);
        }
        if (this.mActivity == null) {
            return null;
        }
        int i3 = l.f210599a[forwardPreviewConst$PreviewType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            ForwardPreViewForShareDialog forwardPreViewForShareDialog = new ForwardPreViewForShareDialog(this.mActivity);
            this.mForwardPreView = forwardPreViewForShareDialog;
            forwardPreViewForShareDialog.a(buildNewVersionContentView());
            this.mForwardPreView.setShareIntent(this.mIntent);
            this.mForwardPreView.setCaller(this.mActivity);
            return this.mForwardPreView;
        }
        ForwardPreViewForShareActionSheet forwardPreViewForShareActionSheet = new ForwardPreViewForShareActionSheet(this.mActivity);
        this.mForwardPreView = forwardPreViewForShareActionSheet;
        forwardPreViewForShareActionSheet.a(buildNewVersionContentView());
        this.mForwardPreView.setShareIntent(this.mIntent);
        this.mForwardPreView.setCaller(this.mActivity);
        return this.mForwardPreView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return (View) iPatchRedirector.redirect((short) 97, (Object) this);
        }
        return null;
    }

    protected void buildNullInputEditTypeConfirmDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        int i3 = this.mExtraData.getInt("forward_type");
        if (i3 != 27 && i3 != 39 && i3 != 46 && i3 != 52 && i3 != 53 && i3 != 42) {
            this.mConfirmDialog = DialogUtil.createCustomDialog(this.mActivity, getDialogTitle(), getDialogContent(), getEditHint(), getDialogLeftBtn(), getDialogRightBtn(), getConfirmListener(), getCancelListener());
            return;
        }
        QQCustomDialogWtihEmoticonInput b16 = com.tencent.mobileqq.utils.ak.b(this.mActivity, getDialogTitle(), this.mExtraData, this.mActivity.getResources().getInteger(R.integer.f167158k));
        this.mConfirmDialog = b16;
        b16.setMessage("");
        this.mConfirmDialog.setNegativeButton(R.string.cancel, getCancelListener());
        this.mConfirmDialog.setPositiveButton(R.string.a1p, getConfirmListener());
        this.mConfirmDialog.show();
    }

    protected void buildSystemAMDEmojiEmoticonEditTypeConfirmDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        int i3 = this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        if (this.mExtraData.getBoolean("is_ark_display_share", false) && i3 != 5) {
            this.mConfirmDialog = com.tencent.mobileqq.utils.ak.b(this.mActivity, getDialogTitle(), this.mExtraData, this.mActivity.getResources().getInteger(R.integer.f167158k));
            String string = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_ARK_INFO);
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    String optString = jSONObject.optString("app");
                    String optString2 = jSONObject.optString("view");
                    String optString3 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        com.tencent.mobileqq.ark.g.b(this.app, optString, "AIOArkSdkSelectSend", 1, 0, 0L, 0L, 0L, optString2, "");
                    }
                } catch (JSONException unused) {
                }
            }
            this.mConfirmDialog.setMessage("");
            this.mConfirmDialog.setNegativeButton(R.string.cancel, getCancelListener());
            this.mConfirmDialog.setPositiveButton(R.string.a1p, getConfirmListener());
            this.mConfirmDialog.show();
            return;
        }
        this.mConfirmDialog = com.tencent.mobileqq.utils.ak.i(this.mActivity, getDialogTitle(), getDialogContent(), null, getConfirmListener(), getCancelListener(), this.mActivity.getResources().getInteger(R.integer.f167158k));
        int i16 = this.mExtraData.getInt("key_forward_ability_type");
        boolean booleanExtra = this.mIntent.getBooleanExtra(ForwardRecentActivity.FORWARD_ABILITY_ENTRENCE_SHOW_IN_SHARE, false);
        if (i16 == com.tencent.mobileqq.forward.e.R3.intValue() && booleanExtra) {
            QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = (QQCustomDialogWtihEmoticonInput) this.mConfirmDialog;
            qQCustomDialogWtihEmoticonInput.s0();
            qQCustomDialogWtihEmoticonInput.getEditText().setHint(HardCodeUtil.qqStr(R.string.moa));
        }
    }

    protected void buildSystemEmoticonEditTypeConfirmDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        checkMetaLegality();
        if (this.mExtraData.getBoolean("is_ark_display_share") && this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5_PARSE_META_SUCCESS)) {
            QQCustomDialogWtihEmoticonInput b16 = com.tencent.mobileqq.utils.ak.b(this.mActivity, getDialogTitle(), this.mExtraData, this.mActivity.getResources().getInteger(R.integer.f167158k));
            this.mConfirmDialog = b16;
            b16.setMessage("");
            this.mConfirmDialog.setNegativeButton(R.string.cancel, getCancelListener());
            this.mConfirmDialog.setPositiveButton(R.string.a1p, getConfirmListener());
            this.mConfirmDialog.show();
            return;
        }
        this.mConfirmDialog = com.tencent.mobileqq.utils.ak.k(this.mActivity, getDialogTitle(), getDialogContent(), null, getConfirmListener(), getCancelListener());
    }

    protected void buildsNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this);
        } else if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(QQ_RELATION_FORWARD_PREVIEW, false)) {
            buildDialogWithPreView();
        } else {
            buildDialogWithContentView();
        }
    }

    public void checkMetaLegality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        String string = this.mExtraData.getString("forward_ark_app_meta");
        boolean z16 = false;
        if (!TextUtils.isEmpty(string)) {
            try {
                new JSONObject(string);
                z16 = true;
            } catch (Exception e16) {
                com.tencent.mobileqq.ark.d.d(TAG, String.format("CheckMetaLegality,appMeta is parse error and msg=%s", e16.getMessage()));
            }
        }
        this.mExtraData.putBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5_PARSE_META_SUCCESS, z16);
    }

    protected void decodeAndSetLocalImage(Drawable drawable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, this, drawable, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            URLDrawableHelper.decodeLocalImage((URLDrawable) drawable, this.app.getCurrentAccountUin(), true);
        }
        if (drawable != null && !z16) {
            drawable.setBounds(BaseImageUtil.calculateThumbBounds(drawable, 36, 100, this.mDensity));
        }
    }

    public void doOnRestoreInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) bundle);
            return;
        }
        Bundle bundle2 = bundle.getBundle(KEY_BUNDLE);
        if (bundle2 != null) {
            buildForwardDialog(bundle2.getInt("key_forward_ability_type", com.tencent.mobileqq.forward.e.N3.intValue()), bundle2);
        }
    }

    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) bundle);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            processSaveInstanceBundle(bundle);
            bundle.putBundle(KEY_BUNDLE, this.mExtraData);
        }
    }

    protected void doPublicAccountReportForSingleTarget(int i3) {
        String string;
        byte[] byteArrayExtra;
        AbsStructMsg d16;
        String str;
        String str2;
        int i16;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, i3);
            return;
        }
        Bundle bundle = this.mExtraData;
        boolean z16 = false;
        if (bundle != null && (z16 = bundle.getBoolean(QZoneShareManager.QZONE_SHARE_FROM_WEB, false))) {
            String string2 = this.mExtraData.getString("struct_uin");
            if (string2 == null) {
                str = "";
            } else {
                str = string2;
            }
            String string3 = this.mExtraData.getString("struct_url");
            if (string3 == null) {
                string3 = "";
            }
            String string4 = this.mExtraData.getString("strurt_msgid");
            if (string4 == null) {
                str2 = "";
            } else {
                str2 = string4;
            }
            String articleId = ((IPublicAccountDetailActivity) QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(string3);
            if (i3 == com.tencent.mobileqq.forward.e.R3.intValue()) {
                i16 = 1002;
            } else {
                i16 = 1001;
            }
            String string5 = this.mExtraData.getString("source_puin");
            if (string5 != null && !"".equals(string5)) {
                String string6 = this.mExtraData.getString("uin");
                if (string6 == null || i16 == 1002) {
                    str3 = "";
                } else {
                    str3 = string6;
                }
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str3, "0X8005B07", "0X8005B07", i16, 0, string5, str2, string3, articleId, false);
            } else {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X80059DC", "0X80059DC", i16, 0, str, str2, string3, articleId, false);
            }
        }
        Bundle bundle2 = this.mExtraData;
        if (bundle2 != null && !z16 && (string = bundle2.getString("source_puin")) != null && (byteArrayExtra = this.mIntent.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES)) != null && (d16 = com.tencent.mobileqq.structmsg.i.d(byteArrayExtra)) != null) {
            String string7 = this.mExtraData.getString("uin");
            if (string7 == null) {
                string7 = "";
            }
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, string7, "0X8005B06", "0X8005B06", 0, 0, string, "" + d16.msgId, "", "", false);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8005B06", string7, string, "" + d16.msgId, "", "");
        }
    }

    public void endForwardCallback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            iPatchRedirector.redirect((short) 138, (Object) this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enterImageGallery(Bundle bundle, AIOImageProviderService aIOImageProviderService, AIORichMediaData aIORichMediaData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, bundle, aIOImageProviderService, aIORichMediaData);
        } else {
            r05.a.a(this.mActivity, bundle, aIOImageProviderService, aIORichMediaData, 19001, 4);
        }
    }

    public void filterRecentForwardList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, (Object) this, (Object) list);
        }
    }

    protected boolean forward2FriendOrTroopOrDiscussion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, i3)).booleanValue();
        }
        if (i3 == 1 || i3 == 0 || i3 == 1006 || i3 == 3000 || i3 == 1000 || i3 == 10014 || i3 == 1046) {
            return true;
        }
        return isMultiTarget2Send();
    }

    public void forwardDirectly(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
            return;
        }
        if (this.mFromSharePanelPreviewAndSend) {
            prepareForwardTargets();
            this.mSharePanelLeaveMsg = str;
            forwardOnConfirm();
            updateRecentForwardUser();
            if (this.mIntent.getBooleanExtra("is_need_show_toast", true)) {
                ForwardUtils.s0(this.app, 500L);
                return;
            }
            return;
        }
        forwardOnConfirm();
        sendDefaultMessage(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forwardOnCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this);
            return;
        }
        this.fromCreateDiscussion = false;
        if (this.mExtraData.getBoolean("miniAppNeedOnlyPreview", false)) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_DIRECT_SHARE_FAIL_CALLBACK, null, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "do forwardOnCancel");
        }
        Bundle bundle = this.mOriginExtraData;
        if (bundle != null && !bundle.isEmpty()) {
            this.mExtraData.clear();
            this.mExtraData.putAll(this.mOriginExtraData);
            this.mOriginExtraData.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this);
            return;
        }
        if (isMultiTarget2Send()) {
            List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
            if (multiTargetWithoutDataLine != null && !multiTargetWithoutDataLine.isEmpty()) {
                int size = multiTargetWithoutDataLine.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ResultRecord resultRecord = multiTargetWithoutDataLine.get(i3);
                    if (needSendMessage()) {
                        sendMessage2TargetOnConfirm(resultRecord.uin, getTroopUin(resultRecord), resultRecord.getUinType());
                    }
                }
                this.mExtraData.putBoolean("isBack2Root", true);
                realForwardTo();
                return;
            }
            return;
        }
        reportSendAction();
        if (this.fromCreateDiscussion) {
            ReportController.o(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
            this.fromCreateDiscussion = false;
        }
        if (needSendMessage()) {
            sendMessageOnConfirm();
        }
        forwardToTarget();
    }

    public void forwardToDataLine(int i3) {
        int r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            iPatchRedirector.redirect((short) 124, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->forwardToDataLine--type = " + i3);
        }
        boolean booleanExtra = this.mIntent.getBooleanExtra("isJumpAIO", false);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean booleanExtra3 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if (!booleanExtra && !booleanExtra2 && !booleanExtra3) {
            Bundle bundle = new Bundle();
            String str = AppConstants.DATALINE_PC_UIN;
            if (i3 == com.tencent.mobileqq.forward.e.X3.intValue()) {
                str = AppConstants.DATALINE_IPAD_UIN;
            } else if (i3 == com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
                str = AppConstants.DATALINE_PHONE_UIN;
            }
            bundle.putAll(this.mExtraData);
            Intent intent = new Intent();
            h hVar = new h();
            DataLineHandler dataLineHandler = (DataLineHandler) this.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            if (this.mIntent.getBooleanExtra("sendMultiple", false)) {
                sendDatalineMultiple(intent);
                bundle.putAll(intent.getExtras());
                r16 = dataLineHandler.y3().h(str, bundle, hVar);
                sendDataLineMessage(bundle, str, null);
            } else {
                sendDatalineSingle(intent);
                bundle.putAll(intent.getExtras());
                r16 = dataLineHandler.y3().r(str, bundle, hVar);
                sendDataLineMessage(bundle, str, null);
            }
            if (!isMultiTarget2Send() && r16 == 0) {
                if (getForwardSrcBusinessType() == 100600) {
                    this.mActivity.setResult(-1, this.mIntent);
                    this.mActivity.finish();
                    return;
                }
                k0.a.j(this.mActivity, r16);
                this.mIntent.putExtra("NOCANCEL4DATALIN", true);
                if (getForwardSrcBusinessType() == 100200) {
                    this.mActivity.setResult(-1, this.mIntent);
                } else {
                    this.mActivity.setResult(0, this.mIntent);
                }
                this.mActivity.finish();
                return;
            }
            return;
        }
        if (booleanExtra2 || booleanExtra3) {
            this.mExtraData.remove(PeakConstants.SEND_FLAG);
            this.mIntent.removeExtra(PeakConstants.SEND_FLAG);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->forwardToDataLine jumpAIO ");
        }
        jumpToDataLineAIOForwad(i3);
    }

    public void forwardToFavorite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this);
            return;
        }
        int realShareToQfav = realShareToQfav();
        if (this.mActivity.isFinishing()) {
            return;
        }
        showQfavResultDialog(realShareToQfav);
    }

    public void forwardToMyComputer(int i3) {
        int singleForwardToMyComputer;
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            iPatchRedirector.redirect((short) 125, (Object) this, i3);
            return;
        }
        QLog.d(TAG, 1, "-->forwardToMyComputer--type = " + i3);
        Bundle bundle2 = new Bundle();
        String str = AppConstants.DATALINE_PC_UIN;
        if (i3 == com.tencent.mobileqq.forward.e.X3.intValue()) {
            str = AppConstants.DATALINE_IPAD_UIN;
        } else if (i3 == com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
            str = AppConstants.DATALINE_PHONE_UIN;
        }
        Intent intent = new Intent();
        Bundle bundle3 = this.mExtraData;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
            if (this.mExtraData.getBoolean("forward_jump_to_data_line_aio", false)) {
                intent.putExtra("forward_jump_to_data_line_aio", true);
            }
        }
        intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, str);
        i iVar = new i();
        if (this.mIntent.getBooleanExtra("sendMultiple", false) && (bundle = this.mExtraData) != null && (bundle.get("android.intent.extra.STREAM") != null || this.mExtraData.get("PhotoConst.PHOTO_PATHS") != null)) {
            sendDatalineMultiple(intent);
            if (intent.getExtras() != null) {
                bundle2.putAll(intent.getExtras());
            }
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "multipleForwardToMyComputer param " + bundle2);
            singleForwardToMyComputer = ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).multipleForwardToMyComputer(str, bundle2, iVar);
            sendDataLineMessage(bundle2, str, null);
        } else {
            sendDatalineSingle(intent);
            if (intent.getExtras() != null) {
                bundle2.putAll(intent.getExtras());
            }
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "singleForwardToMyComputer param " + bundle2);
            singleForwardToMyComputer = ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).singleForwardToMyComputer(str, bundle2, iVar);
            sendDataLineMessage(bundle2, str, null);
        }
        if (!isMultiTarget2Send() && singleForwardToMyComputer == 0) {
            if (getForwardSrcBusinessType() == 100600) {
                this.mActivity.setResult(-1, this.mIntent);
                this.mActivity.finish();
                return;
            }
            k0.a.j(this.mActivity, singleForwardToMyComputer);
            this.mIntent.putExtra("NOCANCEL4DATALIN", true);
            if (getForwardSrcBusinessType() == 100200) {
                this.mActivity.setResult(-1, this.mIntent);
            } else if (this.mIntent.getBooleanExtra("key_flag_from_plugin", false)) {
                this.mActivity.setResult(-1);
            } else {
                this.mActivity.setResult(0, this.mIntent);
            }
            Bundle bundle4 = this.mExtraData;
            if (bundle4 != null && bundle4.getBoolean("forward_jump_to_data_line_aio", false)) {
                navigateToAIO(str, intent.getExtras());
            } else {
                this.mActivity.finish();
            }
        }
    }

    protected void forwardToQQStory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            iPatchRedirector.redirect((short) 134, (Object) this);
        }
    }

    protected void forwardToQZone(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            iPatchRedirector.redirect((short) 133, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forwardToTarget() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this);
            return;
        }
        this.mExtraData.putBoolean("isBack2Root", true);
        if (!realForwardTo()) {
            ReportController.o(this.app, "CliOper", "", "", "0X8004047", "0X8004047", 0, 0, "", "", "", "");
        }
    }

    int get820ReportForwardMsgType(int i3) {
        switch (i3) {
            case -5:
                return 6;
            case -3:
            case 1001:
                return 10;
            case -1:
                return 1;
            case 1:
                return 2;
            case 3:
                return 5;
            case 8:
                return 3;
            case 14:
                return 7;
            case 20:
            case 23:
                return 8;
            case 21:
                return 4;
            case 24:
                return 9;
            case 27:
            case 35:
            case 38:
            case 39:
            case 42:
            case 46:
            case 52:
            case 53:
                return 11;
            default:
                return 100;
        }
    }

    int get820ReportForwardTargetType(String str, int i3) {
        if (AppConstants.DATALINE_PC_UIN.equals(str)) {
            return 4;
        }
        if ("-1010".equals(str)) {
            return 6;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3000) {
                    if (com.tencent.mobileqq.activity.i.a(i3)) {
                        return 3;
                    }
                    return 100;
                }
                return 7;
            }
            return 2;
        }
        if (!this.app.getCurrentAccountUin().equals(str)) {
            return 1;
        }
        return 5;
    }

    int get8855ReportForwardTargetType(String str, int i3) {
        if (AppConstants.DATALINE_PC_UIN.equals(str)) {
            return 5;
        }
        if ("-1010".equals(str)) {
            return 6;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            if (i3 != 3000) {
                if (i3 != 10014 && i3 != 10016) {
                    if (com.tencent.mobileqq.activity.i.a(i3)) {
                        return 4;
                    }
                    return 100;
                }
                return 2;
            }
            return 3;
        }
        if (this.app.getCurrentAccountUin().equals(str)) {
            return 5;
        }
        return 0;
    }

    void getAIOThumImageSize() {
        if (mURLDrawableUrlWidth <= 0) {
            mURLDrawableUrlWidth = ((((WindowManager) this.mAppContext.getSystemService("window")).getDefaultDisplay().getWidth() - (this.mAppContext.getResources().getDimensionPixelSize(R.dimen.f159225xv) * 2)) - (this.mAppContext.getResources().getDimensionPixelSize(R.dimen.f159227xx) * 3)) / 4;
        }
    }

    public QQAppInterface getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 150)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 150, (Object) this);
        }
        return this.app;
    }

    protected final DialogInterface.OnClickListener getCancelListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        if (this.mOnCancleListener == null) {
            this.mOnCancleListener = new o();
        }
        return this.mOnCancleListener;
    }

    protected final DialogInterface.OnClickListener getConfirmListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        if (this.mOnConfirmListener == null) {
            this.mOnConfirmListener = new n();
        }
        return this.mOnConfirmListener;
    }

    public View getContentPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return (View) iPatchRedirector.redirect((short) 99, (Object) this);
        }
        if (useNewVersionDialog()) {
            QLog.d(TAG, 2, "getContentPreview is use new version dialog!");
            View buildNewVersionContentView = buildNewVersionContentView();
            if (buildNewVersionContentView.getParent() != null) {
                ((ViewGroup) buildNewVersionContentView.getParent()).removeView(buildNewVersionContentView);
            }
            return buildNewVersionContentView;
        }
        return null;
    }

    protected List<ResultRecord> getDataLineMultiTarget() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (List) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.mForwardDataLineTargets;
    }

    protected int getDefaultEditTextType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        if (needShowEditInput()) {
            return 2;
        }
        return 0;
    }

    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "DialogContent:mForwardText=" + this.mForwardText);
        }
        return this.mForwardText;
    }

    public int getDialogLeftBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return R.string.cancel;
    }

    public int getDialogRightBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return R.string.a1p;
    }

    public String getDialogTitle() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        int i3 = this.mExtraData.getInt("key_forward_ability_type");
        if (i3 == com.tencent.mobileqq.forward.e.R3.intValue()) {
            str = "QQ\u7a7a\u95f4";
        } else if (i3 != com.tencent.mobileqq.forward.e.S3.intValue() && i3 != com.tencent.mobileqq.forward.e.X3.intValue() && i3 != com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
            if (i3 == com.tencent.mobileqq.forward.e.T3.intValue()) {
                str = HardCodeUtil.qqStr(R.string.mo_);
            } else if (i3 == com.tencent.mobileqq.forward.e.Z3.intValue()) {
                str = vc0.a.f441361a;
            } else {
                str = this.mExtraData.getString("uinname");
            }
        } else {
            int i16 = this.mExtraData.getInt("uintype", -1);
            if (i16 == 6000) {
                str = HardCodeUtil.qqStr(R.string.cf5);
            } else if (i16 == 6005) {
                str = HardCodeUtil.qqStr(R.string.f169742j6);
            } else if (i16 == 6003) {
                if (((RegisterProxySvcPackHandler) this.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).U2()) {
                    str = "\u6211\u7684iPad";
                } else {
                    str = "\u6211\u7684Pad";
                }
            } else {
                str = "";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return HardCodeUtil.qqStr(R.string.moe) + str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getEditHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        int i3 = this.mExtraData.getInt("uintype", 0);
        int i16 = this.mExtraData.getInt("key_forward_ability_type");
        if (forward2FriendOrTroopOrDiscussion(i3)) {
            return HardCodeUtil.qqStr(R.string.moc);
        }
        if (i16 != com.tencent.mobileqq.forward.e.S3.intValue() && i16 != com.tencent.mobileqq.forward.e.X3.intValue() && i16 != com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
            return "";
        }
        return HardCodeUtil.qqStr(R.string.moh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getEditTextType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.mExtraData.getInt("emoInputType", getDefaultEditTextType());
    }

    public float getElasticScaleRation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 140)) ? getElasticScaleRation(this.mActivity, f16) : ((Float) iPatchRedirector.redirect((short) 140, this, Float.valueOf(f16))).floatValue();
    }

    public Bundle getExtras() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            return (Bundle) iPatchRedirector.redirect((short) 136, (Object) this);
        }
        return this.mExtraData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap getFilePathBitmap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (Bitmap) iPatchRedirector.redirect((short) 86, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.util.j.c(str);
    }

    public Set<Integer> getForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.mForwardAbilities == null) {
            this.mForwardAbilities = new HashSet();
            try {
                buildForwardAbility();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getForwardAbility failed: " + e16);
            }
        }
        return this.mForwardAbilities;
    }

    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 107)) ? getForwardRecentList(list, false) : (List) iPatchRedirector.redirect((short) 107, (Object) this, (Object) list);
    }

    public int getForwardSrcBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 141)) ? getForwardSrcBusinessType(this.mExtraData) : ((Integer) iPatchRedirector.redirect((short) 141, (Object) this)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View.OnClickListener getImageEditListener(r rVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 74, (Object) this, (Object) rVar);
        }
        String string = this.mExtraData.getString("uin");
        if (this.mOnEditListener == null) {
            this.mOnEditListener = new a(string);
        }
        return this.mOnEditListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ResultRecord> getMultiTarget() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (List) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.mForwardTargets;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ResultRecord> getMultiTargetWithoutDataLine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (List) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.mForwardTargetsWithoutDataLine;
    }

    public String getQavInputStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return getUserInputStr();
    }

    protected final DialogInterface.OnClickListener getResultListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (DialogInterface.OnClickListener) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        if (this.mResultListener == null) {
            this.mResultListener = new p();
        }
        return this.mResultListener;
    }

    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String stringExtra = this.mIntent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_TITLE);
        if (TextUtils.isEmpty(stringExtra)) {
            return HardCodeUtil.qqStr(R.string.moi);
        }
        return stringExtra;
    }

    protected String getTroopUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (String) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        Bundle bundle = this.mExtraData;
        return bundle == null ? "" : bundle.getInt("uintype") == 10014 ? this.mExtraData.getString("guild_id") : this.mExtraData.getString("troop_uin");
    }

    public String getUserInputStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (String) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        if (useBottomSheetPreview()) {
            return this.mBottomSheetPreviewLeaveMessage;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog instanceof QQCustomDialogWtihEmoticonInput) {
            return ((QQCustomDialogWtihEmoticonInput) qQCustomDialog).getInputValue();
        }
        if (qQCustomDialog instanceof ForwardNewVersionDialog) {
            return ((ForwardNewVersionDialog) qQCustomDialog).getInputValue();
        }
        if (qQCustomDialog instanceof ForwardDialog) {
            return ((ForwardDialog) qQCustomDialog).getInputValue();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleDialog mConfirmDialog exist");
                return false;
            }
            return false;
        }
        com.tencent.biz.widgets.f fVar = this.mResultDlg;
        if (fVar != null && fVar.isShowing()) {
            this.mResultDlg.dismiss();
        }
        hideProgressDialog();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleForwardFromFavorite(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return ((Boolean) iPatchRedirector.redirect((short) 103, (Object) this, (Object) intent)).booleanValue();
        }
        boolean z16 = this.mExtraData.getBoolean("isFromFavorites");
        if (!z16) {
            String string = this.mExtraData.getString("app_name");
            if (!TextUtils.isEmpty(string) && string.equals(this.mActivity.getString(R.string.b48))) {
                z16 = true;
            }
        }
        if (z16) {
            this.mExtraData.putBoolean("isBack2Root", true);
            this.mExtraData.putString("leftBackText", this.mActivity.getString(R.string.hvn));
            intent.putExtras(this.mExtraData);
        }
        boolean z17 = this.mExtraData.getBoolean("isFromAIOPlus");
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    public boolean handleQZoneClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            return ((Boolean) iPatchRedirector.redirect((short) 149, (Object) this)).booleanValue();
        }
        return false;
    }

    protected void hideDialogInputViewProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        Intent intent = this.mIntent;
        if (intent != null && intent.getBooleanExtra(FORWARD_INPUT_VIEW_HIDE, false)) {
            QQCustomDialog qQCustomDialog = this.mConfirmDialog;
            if (qQCustomDialog instanceof QQCustomArkDialog) {
                ((QQCustomArkDialog) qQCustomDialog).K0();
            }
        }
    }

    public void hideProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            iPatchRedirector.redirect((short) 115, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.mProgressDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void initApp(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
        } else {
            this.app = qQAppInterface;
        }
    }

    public void initContext(QQAppInterface qQAppInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) activity);
            return;
        }
        this.app = qQAppInterface;
        this.mActivity = activity;
        this.mDensity = activity.getResources().getDisplayMetrics().density;
    }

    public boolean isDirectShareDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 148)) {
            return ((Boolean) iPatchRedirector.redirect((short) 148, (Object) this)).booleanValue();
        }
        Intent intent = this.mIntent;
        if (intent == null || intent.getIntExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 0) != 1) {
            return false;
        }
        return true;
    }

    public boolean isFromFav() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.isFromFav;
    }

    public boolean isFromJumpActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isFormJump;
    }

    public boolean isFromLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return ((Boolean) iPatchRedirector.redirect((short) 111, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean isFromSharePullRecentList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            return ((Boolean) iPatchRedirector.redirect((short) 147, (Object) this)).booleanValue();
        }
        Intent intent = this.mIntent;
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1);
        if (intExtra != 1 && intExtra != 2) {
            return false;
        }
        return true;
    }

    public boolean isHotChat(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            return ((Boolean) iPatchRedirector.redirect((short) 123, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isMultiTarget2Send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        List<ResultRecord> multiTarget = getMultiTarget();
        if (multiTarget != null && !multiTarget.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isNeedShowToast(int i3, String str, int i16) {
        ForwardFileInfo forwardFileInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            return ((Boolean) iPatchRedirector.redirect((short) 139, this, Integer.valueOf(i3), str, Integer.valueOf(i16))).booleanValue();
        }
        if (i16 == com.tencent.mobileqq.forward.e.S3.intValue() || i16 == com.tencent.mobileqq.forward.e.X3.intValue() || i16 == com.tencent.mobileqq.forward.e.f211017e4.intValue() || this.isSdkShare || (this instanceof ForwardSendHongBaoOption) || (this instanceof ForwardChooseFriendOption) || this.mExtraData.getInt(AppConstants.Key.KEY_GAME_ID) > 0) {
            return false;
        }
        boolean booleanExtra = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
        boolean booleanExtra2 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
        if (!booleanExtra && !booleanExtra2) {
            if (i3 == 1) {
                boolean z16 = !((com.tencent.mobileqq.troop.utils.aj) this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(str, true).f300235b;
                if (!z16 || !(this instanceof ForwardFileOption) || (forwardFileInfo = ((ForwardFileOption) this).f210624d) == null || forwardFileInfo.getType() != 10006) {
                    return z16;
                }
            } else if (i3 != 10014 || !((IGuildForwardUtilsApi) QRoute.api(IGuildForwardUtilsApi.class)).checkTextExceedLimit(this.mExtraData)) {
                return true;
            }
            return false;
        }
        return false;
    }

    protected void isShowArkFromSdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        int i3 = this.mExtraData.getInt("key_forward_ability_type");
        if (i3 == com.tencent.mobileqq.forward.e.T3.intValue() || i3 == com.tencent.mobileqq.forward.e.W3.intValue() || i3 == com.tencent.mobileqq.forward.e.Z3.intValue() || i3 == com.tencent.mobileqq.forward.e.R3.intValue()) {
            this.mExtraData.putBoolean("is_ark_display_share", false);
        }
    }

    public boolean isSupportAbility(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) num)).booleanValue();
        }
        Set<Integer> set = this.mForwardAbilities;
        if (set != null && set.contains(num)) {
            return true;
        }
        return false;
    }

    public boolean isSupportMultiFriend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            return ((Boolean) iPatchRedirector.redirect((short) 110, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isSurpportTroopDiscussionTmpConv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            return ((Boolean) iPatchRedirector.redirect((short) 116, (Object) this)).booleanValue();
        }
        return this.mSurpportTroopDiscussionTmpConv;
    }

    protected void jumpToDataLineAIOForwad(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            iPatchRedirector.redirect((short) 130, (Object) this, i3);
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) LiteActivity.class);
        if (i3 == com.tencent.mobileqq.forward.e.X3.intValue()) {
            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_IPAD_UIN);
            intent.putExtra("device_type", 1);
        } else if (i3 == com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PHONE_UIN);
            intent.putExtra("device_type", 0);
        } else {
            intent.putExtra(IProfileProtocolConst.PARAM_TARGET_UIN, AppConstants.DATALINE_PC_UIN);
            intent.putExtra("device_type", 0);
        }
        if (this.mIntent.getBooleanExtra("isFromShare", false)) {
            this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mo9));
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            this.mExtraData.putBoolean("isBack2Root", true);
        }
        intent.putExtras(this.mExtraData);
        intent.putExtra("MigSdkShareNotDone", false);
        if (this.mIntent.getBooleanExtra("sendMultiple", false)) {
            sendDatalineMultiple(intent);
        } else {
            sendDatalineSingle(intent);
        }
        this.mActivity.startActivity(intent);
        this.mExtraData.putBoolean("isBack2Root", false);
        intent.putExtras(this.mExtraData);
        this.mActivity.setResult(0, intent);
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void navigateToAIO(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            iPatchRedirector.redirect((short) 126, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        if (AppConstants.DATALINE_PC_UIN.equals(str)) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick PeerUid.DATALINE_PC_UID is u_rK7NMsbv2ZjEGPdCuOiCfw ,f.uin is " + str);
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
            Context context = this.mAppContext;
            iAIOStarterApi.navigateToAIO(context, 8, PeerUid.DATALINE_PC_UID, context.getResources().getString(R.string.c5f), 0L, bundle);
            return;
        }
        if (AppConstants.DATALINE_PHONE_UIN.equals(str)) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick PeerUid.DATALINE_PHONE_UIN is u_Wcc5rknRRqRO8y5gxMD6sA ,f.uin is " + str);
            IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
            Context context2 = this.mAppContext;
            iAIOStarterApi2.navigateToAIO(context2, 8, PeerUid.DATALINE_PHONE_UID, context2.getResources().getString(R.string.f16273218), 0L, bundle);
            return;
        }
        if (AppConstants.DATALINE_IPAD_UIN.equals(str)) {
            RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
            if (registerProxySvcPackHandler != null && registerProxySvcPackHandler.U2()) {
                QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick ipad PeerUid.DATALINE_PAD_UID is u_l7jpPIZxQo0mzJwoEt-SKw ,f.uin is " + str);
                IAIOStarterApi iAIOStarterApi3 = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
                Context context3 = this.mAppContext;
                iAIOStarterApi3.navigateToAIO(context3, 8, PeerUid.DATALINE_PAD_UID, context3.getResources().getString(R.string.c5g), 0L, bundle);
                return;
            }
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "onClick pad PeerUid.DATALINE_PAD_UID is u_l7jpPIZxQo0mzJwoEt-SKw ,f.uin is " + str);
            IAIOStarterApi iAIOStarterApi4 = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.b(IAIOStarterApi.class);
            Context context4 = this.mAppContext;
            iAIOStarterApi4.navigateToAIO(context4, 8, PeerUid.DATALINE_PAD_UID, context4.getResources().getString(R.string.f16272217), 0L, bundle);
        }
    }

    protected boolean needCheckGag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this, i3)).booleanValue();
        }
        try {
            if (!((IFeatureRuntimeService) this.app.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("forward_check_gay_only_for_troop") || i3 == 1) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "needCheckGag", e16);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needSendMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean needShowEditInput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        int i3 = this.mExtraData.getInt("uintype", 0);
        int i16 = this.mExtraData.getInt("key_forward_ability_type");
        if (this.mExtraData.getBoolean(FORWARD_INPUT_VIEW_HIDE, false)) {
            return false;
        }
        if (i3 != 10014 && !forward2FriendOrTroopOrDiscussion(i3) && i16 != com.tencent.mobileqq.forward.e.S3.intValue() && i16 != com.tencent.mobileqq.forward.e.X3.intValue() && i16 != com.tencent.mobileqq.forward.e.f211017e4.intValue() && i3 != 1024 && i3 != 1025) {
            return false;
        }
        return true;
    }

    public void onActivityCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<q> it = this.mEventListeners.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog instanceof QQCustomArkDialog) {
            ((QQCustomArkDialog) qQCustomDialog).O0(2);
        }
        QQCustomDialog qQCustomDialog2 = this.mConfirmDialog;
        if (qQCustomDialog2 != null && qQCustomDialog2.isShowing()) {
            this.mConfirmDialog.dismiss();
        }
        this.app.removeObserver(this.updateDiscussionInfoObserver);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r5.mActivity.getIntent().getBooleanExtra(com.tencent.mobileqq.app.AppConstants.Key.KEY_SHARE_FROM_SCREEN_SHOT_NEED_FINISH, false) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (r5.mActivity.getIntent().getIntExtra(com.qzone.preview.service.base.PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1) == 5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        if (r5.mActivity.getIntent().getIntExtra(com.qzone.preview.service.base.PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1) == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        if (r5.mActivity.getIntent().getIntExtra(com.qzone.preview.service.base.PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1) == 6) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // android.content.DialogInterface.OnDismissListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) dialogInterface);
            return;
        }
        Activity activity = this.mActivity;
        if (!(activity instanceof DirectForwardActivity) || this.mNeedInterrupFinishActivity) {
            z16 = false;
            if (activity.getIntent() != null) {
            }
            if (this.mActivity.getIntent() != null) {
            }
            if (this.mActivity.getIntent() != null) {
            }
            if (this.mActivity.getIntent() != null) {
            }
            if (z16) {
                this.mActivity.finish();
            }
            if (!(this.mConfirmDialog instanceof QQCustomArkDialog)) {
                QLog.d(TAG, 1, "QQCustomArkDialog dismiss");
                return;
            }
            return;
        }
        z16 = true;
        if (z16) {
        }
        if (!(this.mConfirmDialog instanceof QQCustomArkDialog)) {
        }
    }

    protected void onNegativeResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog instanceof QQCustomArkDialog) {
            ((QQCustomArkDialog) qQCustomDialog).O0(0);
        }
    }

    protected void onPositiveResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog instanceof QQCustomArkDialog) {
            ((QQCustomArkDialog) qQCustomDialog).O0(1);
        }
        QQProgressDialog qQProgressDialog = this.mQQProgressDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mQQProgressDialog.dismiss();
        }
    }

    public void preForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ReportController.o(this.app, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "0", "", "", "");
        }
    }

    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        this.mForwardThumb = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_THUMB);
        this.isURLDrawablFoward = this.mIntent.getBooleanExtra(AppConstants.Key.FORWARD_URLDRAWABLE, false);
        this.mURLDrawableUrl = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL);
        this.mBigURLDrawableUrl = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL);
        this.mForwardText = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_TEXT);
        this.isFormJump = this.mIntent.getBooleanExtra(AppConstants.Key.FORWARD_IS_FROMJUMP, false);
        this.mShareDataLineSupportType = this.mIntent.getIntExtra(AppConstants.Key.KEY_SHARE_DATA_LINE_SUPPORT_TYPE, 0);
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            if (bundle.getInt("forward_type", -1) == 11) {
                this.isSdkShare = true;
            }
            this.appid = this.mExtraData.getLong("req_share_id", 0L);
        }
        getAIOThumImageSize();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void prepareForwardTargets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this);
            return;
        }
        this.mForwardTargets = this.mExtraData.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        this.mForwardTargetsWithoutDataLine = new ArrayList<>();
        this.mForwardDataLineTargets = new ArrayList<>();
        ArrayList<ResultRecord> arrayList = this.mForwardTargets;
        if (arrayList != null) {
            Iterator<ResultRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                int i3 = next.uinType;
                if (i3 != 6000 && i3 != 6003 && i3 != 6005) {
                    this.mForwardTargetsWithoutDataLine.add(next);
                } else {
                    this.mForwardDataLineTargets.add(next);
                }
            }
        }
    }

    public void processSaveInstanceBundle(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, (Object) bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean realForwardTo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            return ((Boolean) iPatchRedirector.redirect((short) 104, (Object) this, z16)).booleanValue();
        }
        if (this.mFromSharePanelPreviewAndSend) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtras(this.mExtraData);
        this.mActivity.setResult(-1, intent);
        if (z16) {
            this.mActivity.finish();
        }
        return false;
    }

    protected int realShareToQfav() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return ((Integer) iPatchRedirector.redirect((short) 100, (Object) this)).intValue();
        }
        return -1;
    }

    public void rebuildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.mForwardAbilities = new HashSet();
        try {
            buildForwardAbility();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "rebuildForwardAbility failed:" + e16);
        }
    }

    public void removeAbility(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) num);
            return;
        }
        Set<Integer> set = this.mForwardAbilities;
        if (set != null) {
            set.remove(num);
        }
    }

    public void removeDataInExtra(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) str);
            return;
        }
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            bundle.remove(str);
        }
    }

    public void removeEventListener(q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            iPatchRedirector.redirect((short) 152, (Object) this, (Object) qVar);
        } else {
            this.mEventListeners.remove(qVar);
        }
    }

    public void reportClickContentAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            iPatchRedirector.redirect((short) 145, (Object) this);
        } else {
            ReportController.o(this.app, "dc00898", "", "", "0X8009BE9", "0X8009BE9", this.mForwardReportType, 0, "", "", "", "");
        }
    }

    public void reportClickSend() {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            iPatchRedirector.redirect((short) 144, (Object) this);
            return;
        }
        if (sSdf == null) {
            sSdf = new SimpleDateFormat(DateUtil.DATE_FORMAT_14);
        }
        int forwardSrcBusinessType = getForwardSrcBusinessType();
        String str = "";
        String string = this.mExtraData.getString("forward_source_sub_business_type", "");
        String format = sSdf.format(Long.valueOf(System.currentTimeMillis()));
        int i19 = this.mExtraData.getInt("forward_type", Integer.MAX_VALUE);
        int i26 = get820ReportForwardMsgType(i19);
        boolean z16 = true;
        boolean z17 = !TextUtils.isEmpty(getUserInputStr());
        int i27 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportClickSend srcBusinessType = " + forwardSrcBusinessType + ",srcSubBusinessType = " + string + ",forwardType = " + i19 + ",forwardMsgType = " + i26 + ",hasLeftAMessage = " + z17 + ",operateTime = " + format);
        }
        ArrayList<ResultRecord> arrayList = this.mForwardTargets;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ResultRecord> it = this.mForwardTargets.iterator();
            i3 = -1;
            while (it.hasNext()) {
                ResultRecord next = it.next();
                String str2 = next.uin;
                int i28 = next.uinType;
                int i29 = get8855ReportForwardTargetType(str2, i28);
                QQAppInterface qQAppInterface = this.app;
                int i36 = this.mExtraData.getInt("via", i27);
                String valueOf = String.valueOf(i29);
                if (this.mExtraData.getBoolean("onlySingleSelection", true)) {
                    i18 = 1;
                } else {
                    i18 = 2;
                }
                ReportController.o(qQAppInterface, "dc00898", "", str2, "0X800C01E", "0X800C01E", i36, 0, "2", valueOf, String.valueOf(i18), "");
                reportMatchFriendTestShare(str2, i28);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reportClickSend multi,,targetUin = " + str2 + ",targetUinType = " + i28 + ",forwardTargetType = " + i29 + ",srcSubBusinessType = " + string);
                }
                str = str2;
                i27 = 2;
                i3 = i29;
                z16 = true;
            }
            i17 = i27;
        } else {
            this.mExtraData.getInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE);
            int i37 = this.mExtraData.getInt("uintype");
            str = this.mExtraData.getString("uin");
            i3 = get8855ReportForwardTargetType(str, i37);
            QQAppInterface qQAppInterface2 = this.app;
            int i38 = this.mExtraData.getInt("via", 2);
            String valueOf2 = String.valueOf(i3);
            z16 = true;
            if (this.mExtraData.getBoolean("onlySingleSelection", true)) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            ReportController.o(qQAppInterface2, "dc00898", "", str, "0X800C01E", "0X800C01E", i38, 0, "1", valueOf2, String.valueOf(i16), "");
            reportMatchFriendTestShare(str, i37);
            if (QLog.isColorLevel()) {
                i17 = 2;
                QLog.d(TAG, 2, "reportClickSend single,,targetUin = " + str + ",targetUinType = " + i37 + ",forwardTargetType = " + i3 + ",srcSubBusinessType = " + string);
            } else {
                i17 = 2;
            }
        }
        if (i17 != this.mExtraData.getInt(AppConstants.Key.SHARE_REQ_TYPE)) {
            z16 = false;
        }
        reportShareMusic(z16, "music".equals(this.mExtraData.getString("forward_ark_app_view")), i3, str);
        reportShareVideo(this.mExtraData, i3, str);
    }

    protected void reportEmotionMachineEvents() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this);
            return;
        }
        if (isMultiTarget2Send()) {
            for (ResultRecord resultRecord : getMultiTarget()) {
                reportEmotionMachineEvent(resultRecord.uin, resultRecord.getUinType());
            }
            return;
        }
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            str = bundle.getString("uin");
        } else {
            str = "";
        }
        Bundle bundle2 = this.mExtraData;
        int i3 = -1;
        if (bundle2 != null) {
            i3 = bundle2.getInt("uintype", -1);
        }
        reportEmotionMachineEvent(str, i3);
    }

    public void reportFinalSelectedTargets() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            iPatchRedirector.redirect((short) 143, (Object) this);
            return;
        }
        int i16 = 2;
        if (this.mExtraData == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reportFinalSelectedTargets return, mExtraData is null");
                return;
            }
            return;
        }
        if (sSdf == null) {
            sSdf = new SimpleDateFormat(DateUtil.DATE_FORMAT_14);
        }
        int forwardSrcBusinessType = getForwardSrcBusinessType();
        String string = this.mExtraData.getString("forward_source_sub_business_type", "");
        String format = sSdf.format(Long.valueOf(System.currentTimeMillis()));
        int i17 = this.mExtraData.getInt("forward_type", Integer.MAX_VALUE);
        int i18 = get820ReportForwardMsgType(i17);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportFinalSelectedTargets srcBusinessType = " + forwardSrcBusinessType + ",srcSubBusinessType = " + string + ",forwardType = " + i17 + ",forwardMsgType = " + i18 + ",operateTime = " + format);
        }
        ArrayList<ResultRecord> arrayList = this.mForwardTargets;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ResultRecord> it = this.mForwardTargets.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                String str = next.uin;
                int i19 = next.uinType;
                int i26 = get8855ReportForwardTargetType(str, i19);
                QQAppInterface qQAppInterface = this.app;
                int i27 = this.mExtraData.getInt("via", i16);
                String valueOf = String.valueOf(i26);
                Iterator<ResultRecord> it5 = it;
                if (this.mExtraData.getBoolean("onlySingleSelection", true)) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(qQAppInterface, "dc00898", "", str, "0X800C01E", "0X800C01E", i27, 0, "2", valueOf, String.valueOf(i3), "");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reportFinalSelectedTargets multi,,targetUin = " + str + ",targetUinType = " + i19 + ",forwardTargetType = " + i26 + ",srcSubBusinessType = " + string);
                }
                it = it5;
                i16 = 2;
            }
            return;
        }
        int i28 = this.mExtraData.getInt("uintype");
        String string2 = this.mExtraData.getString("uin");
        int i29 = get8855ReportForwardTargetType(string2, i28);
        QQAppInterface qQAppInterface2 = this.app;
        int i36 = this.mExtraData.getInt("via", 2);
        String valueOf2 = String.valueOf(i29);
        int i37 = 1;
        if (!this.mExtraData.getBoolean("onlySingleSelection", true)) {
            i37 = 2;
        }
        ReportController.o(qQAppInterface2, "dc00898", "", string2, "0X800C01E", "0X800C01E", i36, 0, "1", valueOf2, String.valueOf(i37), "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportFinalSelectedTargets single,,targetUin = " + string2 + ",targetUinType = " + i28 + ",forwardTargetType = " + i29 + ",srcSubBusinessType = " + string);
        }
    }

    public void reportForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Bundle bundle = this.mExtraData;
        if (bundle != null && bundle.getBoolean(ForwardRecentActivity.KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS, false)) {
            ReportController.o(this.app, "dc00898", "", "", "0X800A220", "0X800A220", 0, 0, "0", "", "", "");
        }
        reportFinalSelectedTargets();
    }

    protected void reportMiniAppClickConfirm(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, i3);
            return;
        }
        switch (i3) {
            case 10:
                reportMiniAppEventByIPC("user_click", "more_about", "share", "success");
                return;
            case 11:
                reportMiniAppEventByIPC("user_click", "custom_button", "share_QQ", "success");
                return;
            case 12:
                reportMiniAppEventByIPC("user_click", "more_button", "share_QQ", "success");
                return;
            default:
                return;
        }
    }

    protected void reportMiniAppEventByIPC(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, str, str2, str3, str4);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_mini_report_event_action_type", str);
        bundle.putString("key_mini_report_event_sub_action_type", str2);
        bundle.putString("key_mini_report_event_reserves", str3);
        bundle.putString("key_mini_report_event_reserves2", str4);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
    }

    public void reportOnSearch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public void reportSendAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            iPatchRedirector.redirect((short) 146, (Object) this);
        } else {
            ReportController.o(this.app, "dc00898", "", "", "0X8009BEA", "0X8009BEA", this.mForwardReportType, 0, "", "", "", "");
            reportClickSend();
        }
    }

    protected void reportSendToSingleTarget() {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            z16 = bundle.getBoolean(IPublicAccountDetailActivity.FROMADCARD, false);
        } else {
            z16 = false;
        }
        if (z16) {
            String string = this.mExtraData.getString(IPublicAccountJavascriptInterface.KEY_PUB_UIN);
            if (string == null) {
                str5 = "";
            } else {
                str5 = string;
            }
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, str5, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
        }
        if (this.mExtraData != null && this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false)) {
            int i3 = this.mExtraData.getInt("forward_type");
            if (i3 == 21) {
                str4 = "0X800780B";
            } else if (i3 != 1) {
                str3 = "";
                ReportController.o(this.app, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
            } else {
                str4 = "0X8007811";
            }
            str3 = str4;
            ReportController.o(this.app, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
        }
        Bundle bundle2 = this.mExtraData;
        if (bundle2 != null && bundle2.getBoolean("forward_report_confirm")) {
            String string2 = this.mExtraData.getString("forward_report_confirm_action_name");
            String string3 = this.mExtraData.getString("forward_report_confirm_reverse2");
            if (string2 == null) {
                str = "";
            } else {
                str = string2;
            }
            if (string3 == null) {
                str2 = "";
            } else {
                str2 = string3;
            }
            ReportController.o(this.app, "CliOper", "", "", str, str, 0, 0, str2, "", "", "");
        }
        if (this.isSdkShare) {
            ReportCenter.f().q(this.app.getAccount(), "", String.valueOf(this.appid), "1000", "50", "0", false, this.isSdkShare);
        }
        Bundle bundle3 = this.mExtraData;
        if (bundle3 != null && bundle3.getInt("extra_key_from_apollo") > 0) {
            ff.T(null, "cmshow", "Apollo", "QQSend", 0, 0, new String[0]);
        }
        Bundle bundle4 = this.mExtraData;
        if (bundle4 != null && bundle4.getBoolean("KEY_FROM_OCR", false)) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009C8E", "0X8009C8E", 0, 0, "", "", "", "");
        }
        Bundle bundle5 = this.mExtraData;
        if (bundle5 != null && bundle5.getBoolean("KEY_FROM_TRANSLATE", false)) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009C85", "0X8009C85", 0, 0, "", "", "", "");
        }
    }

    public void reportShowForwardRecent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 142)) {
            iPatchRedirector.redirect((short) 142, (Object) this);
            return;
        }
        int forwardSrcBusinessType = getForwardSrcBusinessType();
        String string = this.mExtraData.getString("forward_source_sub_business_type", "");
        int i3 = get820ReportForwardMsgType(this.mExtraData.getInt("forward_type", Integer.MAX_VALUE));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportShowForwardRecent srcBusinessType = " + forwardSrcBusinessType + ",srcSubBusinessType = " + string);
        }
        ReportController.o(this.app, "dc00898", "", "", "0X800A7EB", "0X800A7EB", forwardSrcBusinessType, 0, "", "", String.valueOf(i3), string);
    }

    protected void reportToAECameraEvents() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        if (isMultiTarget2Send()) {
            Iterator<ResultRecord> it = getMultiTarget().iterator();
            while (it.hasNext()) {
                bundle.putLong("key_receiver_type", it.next().getUinType());
                QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", bundle, null);
            }
            return;
        }
        Bundle bundle2 = this.mExtraData;
        if (bundle2 != null) {
            j3 = bundle2.getInt("uintype", -1);
        } else {
            j3 = -1;
        }
        bundle.putLong("key_receiver_type", j3);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "ae_camera_get_info_client", "action_get_send_to_info", bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendDataLineMessage(Bundle bundle, String str, a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            iPatchRedirector.redirect((short) 127, this, bundle, str, cVar);
            return;
        }
        String userInputStr = getUserInputStr();
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app)) {
            sendFileAssistantMessage(userInputStr, str, cVar);
        } else {
            sendOldDataLineMessage(userInputStr, str, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendDatalineMultiple(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            iPatchRedirector.redirect((short) 131, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendDatalineSingle(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 132)) {
            iPatchRedirector.redirect((short) 132, (Object) this, (Object) intent);
        }
    }

    protected void sendFileAssistantMessage(String str, String str2, a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            iPatchRedirector.redirect((short) 128, this, str, str2, cVar);
            return;
        }
        sendMessage2TargetOnConfirm(this.mExtraData.getString("uin"), this.mExtraData.getString("troop_uin"), this.mExtraData.getInt("uintype"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 70)) ? sendMessage2TargetOnConfirm(str, str2, i3, "") : ((Boolean) iPatchRedirector.redirect((short) 70, this, str, str2, Integer.valueOf(i3))).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessageOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
            return;
        }
        String string = this.mExtraData.getString("uin");
        String troopUin = getTroopUin();
        int i3 = this.mExtraData.getInt("uintype");
        if (sendMessage2TargetOnConfirm(string, troopUin, i3)) {
            int i16 = 1;
            if (i3 != 0) {
                if (i3 == 1) {
                    i16 = 2;
                } else if (i3 == 3000) {
                    i16 = 3;
                } else {
                    i16 = 0;
                }
            }
            ReportController.o(this.app, "CliOper", "", "", "0X8009AAE", "0X8009AAE", i16, 0, "", "", "", "");
        }
    }

    protected void sendOldDataLineMessage(String str, String str2, a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            iPatchRedirector.redirect((short) 129, this, str, str2, cVar);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "sendDataLineMessage: invoked.  textAndEmoji: " + str);
            }
            sendDatalineSingle(new Intent());
            Bundle bundle = new Bundle();
            bundle.putBoolean("sendMultiple", false);
            bundle.putInt("dataline_forward_type", 102);
            bundle.putString("dataline_forward_text", str);
            int f16 = com.tencent.qqnt.mycomputer.utils.c.f359781a.f(str, str2, false, null);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "sendDataLineMessage: invoked.  noteRet: " + f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendToMultiTarget() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        ArrayList<ResultRecord> arrayList = this.mForwardDataLineTargets;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < this.mForwardDataLineTargets.size(); i3++) {
                ResultRecord resultRecord = this.mForwardDataLineTargets.get(i3);
                if (i3 == this.mForwardDataLineTargets.size() - 1 && this.mForwardTargetsWithoutDataLine.isEmpty()) {
                    this.mExtraData.putBoolean("forward_jump_to_data_line_aio", true);
                }
                int i16 = resultRecord.uinType;
                if (i16 == 6000) {
                    forwardToMyComputer(com.tencent.mobileqq.forward.e.S3.intValue());
                } else if (i16 == 6003) {
                    forwardToMyComputer(com.tencent.mobileqq.forward.e.X3.intValue());
                } else if (i16 == 6005) {
                    forwardToMyComputer(com.tencent.mobileqq.forward.e.f211017e4.intValue());
                }
            }
            ArrayList<ResultRecord> arrayList2 = this.mForwardTargetsWithoutDataLine;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                this.mIntent.putExtra("NOCANCEL4DATALIN", true);
                this.mActivity.setResult(0, this.mIntent);
                this.mActivity.finish();
            }
            this.mExtraData.putParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET, this.mForwardTargetsWithoutDataLine);
            this.mIntent.putParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET, this.mForwardTargetsWithoutDataLine);
        }
        forwardOnConfirm();
        if (!this.isSdkShare) {
            if (this.mExtraData.getBoolean("system_share", false)) {
                if (1 != this.mExtraData.getInt("forward_type", Integer.MAX_VALUE) || !this.mIntent.getBooleanExtra("sendMultiple", false)) {
                    ForwardUtils.R(this.mActivity, this.mExtraData);
                    return;
                }
                return;
            }
            if (this.mIsFromOutsideShare && !this.mIsFromDatalineAIO) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.7
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardBaseOption.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ForwardBaseOption.this.showOutsideShareResultDialog();
                        }
                    }
                }, 500L);
                return;
            }
            this.mActivity.finish();
            if (this.mIntent.getBooleanExtra("is_need_show_toast", true)) {
                ForwardUtils.s0(this.app, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sendToSingleTarget(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this, (Object) str)).booleanValue();
        }
        String string = this.mExtraData.getString("uin");
        int i3 = this.mExtraData.getInt("uintype", 0);
        if (((com.tencent.mobileqq.troop.utils.aj) this.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(string, true).f300235b && needCheckGag(i3)) {
            QQToast.makeText(this.app.getApp(), R.string.emm, 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return false;
        }
        int i16 = getExtras().getInt("key_forward_ability_type");
        QLog.d(TAG, 1, "-->getConfirmListener--onClick--type = " + i16);
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(this.app) && (i16 == com.tencent.mobileqq.forward.e.S3.intValue() || i16 == com.tencent.mobileqq.forward.e.X3.intValue() || i16 == com.tencent.mobileqq.forward.e.f211017e4.intValue())) {
            this.mExtraData.putString("uin", AppConstants.DATALINE_NEW_VERSION_UIN);
            this.mExtraData.putInt("uintype", 0);
            this.mExtraData.putString("uinname", this.mAppContext.getString(R.string.f187533u9));
            Bundle bundle = this.mExtraData;
            Integer num = com.tencent.mobileqq.forward.e.O3;
            bundle.putInt("key_forward_ability_type", num.intValue());
            i16 = num.intValue();
        }
        try {
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Throwable", th5);
            }
        }
        if (i16 != com.tencent.mobileqq.forward.e.S3.intValue() && i16 != com.tencent.mobileqq.forward.e.X3.intValue() && i16 != com.tencent.mobileqq.forward.e.f211017e4.intValue()) {
            if (i16 == com.tencent.mobileqq.forward.e.T3.intValue()) {
                forwardToFavorite();
            } else if (i16 == com.tencent.mobileqq.forward.e.Z3.intValue()) {
                forwardToQQStory();
            } else if (i16 == com.tencent.mobileqq.forward.e.R3.intValue()) {
                QQCustomDialog qQCustomDialog = this.mConfirmDialog;
                if (qQCustomDialog instanceof QQCustomDialogWtihEmoticonInput) {
                    str2 = ((QQCustomDialogWtihEmoticonInput) qQCustomDialog).j0();
                } else {
                    str2 = null;
                }
                forwardToQZone(str2);
            } else {
                forwardOnConfirm();
            }
            if (this.mIntent.getBooleanExtra("is_need_show_toast", true) && isNeedShowToast(i3, string, i16)) {
                ForwardUtils.s0(this.app, 300L);
            }
            doPublicAccountReportForSingleTarget(i16);
            reportSendToSingleTarget();
            return true;
        }
        forwardToMyComputer(i16);
        if (this.mIntent.getBooleanExtra("is_need_show_toast", true)) {
            ForwardUtils.s0(this.app, 300L);
        }
        doPublicAccountReportForSingleTarget(i16);
        reportSendToSingleTarget();
        return true;
    }

    protected void setDialogPreviewImage(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) qQCustomDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPreviewImage(Drawable drawable, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 89)) {
            setPreviewImage(drawable, z16, i3, false);
        } else {
            iPatchRedirector.redirect((short) 89, this, drawable, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void showForwardTargetAvatar(cw cwVar) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) cwVar);
            return;
        }
        if (cwVar == null) {
            return;
        }
        List<ResultRecord> multiTarget = getMultiTarget();
        if (multiTarget == null) {
            int i3 = this.mExtraData.getInt("uintype", 0);
            Bundle bundle = this.mExtraData;
            if (i3 == 10014) {
                str2 = "guild_id";
            } else {
                str2 = "uin";
            }
            String string = bundle.getString(str2);
            boolean z16 = this.mExtraData.getBoolean("new_create_troop", false);
            String dialogTitle = getDialogTitle();
            if ((forward2FriendOrTroopOrDiscussion(i3) || i3 == 10014 || i3 == 10008) && !TextUtils.isEmpty(dialogTitle)) {
                cwVar.a0(this.app, this.mActivity, string, i3, getTitleStr(dialogTitle), z16);
                return;
            }
            return;
        }
        if (multiTarget.size() == 1) {
            ResultRecord resultRecord = multiTarget.get(0);
            if (resultRecord.uinType == 10014) {
                str = resultRecord.guildId;
            } else {
                str = resultRecord.uin;
            }
            cwVar.a0(this.app, this.mActivity, str, resultRecord.getUinType(), resultRecord.name, false);
            return;
        }
        cwVar.b0(this.app, this.mActivity, multiTarget, true);
    }

    protected void showOutsideShareResultDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            if (this.mShareResultDialog == null) {
                this.mShareResultDialog = new com.tencent.biz.widgets.e(this.mActivity);
            }
            String string = this.app.getApplication().getString(R.string.hih);
            String string2 = this.mExtraData.getString("app_name");
            if (string2 != null) {
                string = string + string2;
            }
            m mVar = new m();
            this.mShareResultDialog.O(string, mVar);
            this.mShareResultDialog.P(mVar);
            this.mShareResultDialog.show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, " qbShowShareResultDialog error mActivity = null");
        }
    }

    protected void showProgressDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this);
            return;
        }
        if (this.mQQProgressDialog == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mActivity);
            this.mQQProgressDialog = qQProgressDialog;
            qQProgressDialog.setCanceledOnTouchOutside(true);
        }
        if (this.mQQProgressDialog.isShowing()) {
            return;
        }
        this.mQQProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showQfavResultDialog(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            iPatchRedirector.redirect((short) 135, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->showQfavResultDialog--code = " + i3);
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.mConfirmDialog.dismiss();
        }
        hideProgressDialog();
        j jVar = new j();
        com.tencent.biz.widgets.f fVar = this.mResultDlg;
        if (fVar == null) {
            this.mResultDlg = new com.tencent.biz.widgets.f(this.mActivity);
        } else {
            fVar.dismiss();
        }
        String string = this.mActivity.getString(R.string.button_back);
        if (!TextUtils.isEmpty(this.mExtraData.getString("app_name"))) {
            string = string + this.mExtraData.getString("app_name");
        }
        this.mResultDlg.O(string, jVar);
        this.mResultDlg.Q(R.string.b1s);
        com.tencent.biz.widgets.f fVar2 = this.mResultDlg;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        fVar2.R(z16);
        this.mResultDlg.Q(R.string.hjb);
        this.mResultDlg.P(0);
        this.mResultDlg.U(R.string.hjc);
        this.mResultDlg.S(this.mActivity.getString(R.string.cou), jVar);
        try {
            this.mResultDlg.show();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "-->showQfavResultDialog--resultDlg.show() failed");
            }
        }
    }

    protected boolean singleTargetSendLocalProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this)).booleanValue();
        }
        Intent intent = this.mIntent;
        if (intent == null || !intent.getBooleanExtra("share_not_send_by_client", false)) {
            return false;
        }
        if (this.mActivity != null && this.mExtraData != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("uin", this.mExtraData.getString("uin"));
            intent2.putExtra("uintype", this.mExtraData.getInt("uintype", 0));
            intent2.putExtra("guild_id", this.mExtraData.getString("guild_id"));
            intent2.putExtra("share_emoji_text", acquireEmoticonInput());
            intent2.putExtra("share_process_by_caller", true);
            this.mActivity.setResult(-1, intent2);
            this.mActivity.finish();
        } else {
            QLog.d(TAG, 1, "-->onConfirmButtonClickOnly error ");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void updateImageView(String str, QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, (Object) str, (Object) qQCustomDialog);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateImageView: filepath=" + str);
        }
        ThreadManagerV2.excute(new Runnable(str, qQCustomDialog) { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.14
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f210569d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QQCustomDialog f210570e;

            {
                this.f210569d = str;
                this.f210570e = qQCustomDialog;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ForwardBaseOption.this, str, qQCustomDialog);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Drawable uRLDrawable;
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ForwardBaseOption forwardBaseOption = ForwardBaseOption.this;
                if (!forwardBaseOption.isURLDrawablFoward) {
                    uRLDrawable = forwardBaseOption.getNormalDrawable(this.f210569d);
                    ForwardBaseOption.loadPicTime = System.currentTimeMillis();
                    long j3 = ForwardBaseOption.loadPicTime - ForwardBaseOption.clickShareBeginTime;
                    QLog.d(ForwardBaseOption.PERFORMANCE_TAG, 2, "loadPicCost" + j3);
                    if (uRLDrawable == null) {
                        ForwardBaseOption.this.setDialogPreviewImage(this.f210570e);
                        if (QLog.isColorLevel()) {
                            QLog.d(ForwardBaseOption.TAG, 2, "updateImageView getNormalDrawable null");
                            return;
                        }
                        return;
                    }
                } else {
                    uRLDrawable = forwardBaseOption.getURLDrawable();
                    if (uRLDrawable == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(ForwardBaseOption.TAG, 2, "updateImageView getURLDrawable null");
                            return;
                        }
                        return;
                    }
                }
                ForwardBaseOption forwardBaseOption2 = ForwardBaseOption.this;
                forwardBaseOption2.decodeAndSetLocalImage(uRLDrawable, forwardBaseOption2.isURLDrawablFoward);
                ArrayList arrayList = (ArrayList) ForwardBaseOption.this.mExtraData.get("PhotoConst.PHOTO_PATHS");
                ForwardBaseOption.decodeRoundTime = System.currentTimeMillis();
                QLog.d(ForwardBaseOption.PERFORMANCE_TAG, 2, "decodeAndSetLocalImage cost:" + (ForwardBaseOption.decodeRoundTime - ForwardBaseOption.loadPicTime));
                ForwardBaseOption forwardBaseOption3 = ForwardBaseOption.this;
                if (arrayList != null) {
                    i3 = arrayList.size();
                } else {
                    i3 = 0;
                }
                forwardBaseOption3.setPreviewImage(uRLDrawable, true, i3, ForwardBaseOption.this.isURLDrawablFoward);
                if (QLog.isColorLevel()) {
                    QLog.d(ForwardBaseOption.TAG, 2, "updateImageView end! ");
                }
            }
        }, 64, null, false);
    }

    public void updateRecentForwardUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        if (isMultiTarget2Send()) {
            Iterator<ResultRecord> it = this.mForwardTargets.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                ForwardUtils.i0(this.app, next.uin, next.uinType, next.guildId);
            }
            return;
        }
        String string = this.mExtraData.getString("uin");
        int i3 = this.mExtraData.getInt("uintype");
        String string2 = this.mExtraData.getString("guild_id");
        QLog.i(TAG, 1, "[updateRecentForwardUser] toUin=" + string + ",toUinType=" + i3);
        ForwardUtils.i0(this.app, string, i3, string2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean useBottomSheetPreview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Boolean) iPatchRedirector.redirect((short) 98, (Object) this)).booleanValue();
        }
        boolean enable = ((IForwardPreviewPanelApi) QRoute.api(IForwardPreviewPanelApi.class)).enable();
        QLog.i(TAG, 1, "[useBottomSheetPreview], globalSwitch=" + enable + ", businessFlag" + this.useBottomSheetPreviewFromBusiness);
        if (enable && this.useBottomSheetPreviewFromBusiness) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return ((Boolean) iPatchRedirector.redirect((short) 96, (Object) this)).booleanValue();
        }
        return false;
    }

    public static float getElasticScaleRation(Activity activity, float f16) {
        if (activity == null) {
            return f16;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        float width = defaultDisplay.getWidth() * f16;
        float dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.f158688md);
        if (dimensionPixelSize <= width) {
            return f16;
        }
        float width2 = dimensionPixelSize / defaultDisplay.getWidth();
        return (width2 <= f16 || ((double) width2) >= 1.0d) ? f16 : width2;
    }

    public static int getForwardSrcBusinessType(Bundle bundle) {
        int i3;
        int i16 = bundle.getInt("forward_source_business_type", -1);
        if (i16 == -1) {
            i3 = bundle.getInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1);
            if (i3 == 0) {
                i16 = AudienceReportConst.EVENT_ID_ENTER_ROOM_SUCCESS;
            } else if (i3 == 1) {
                i16 = 100100;
            } else if (i3 == 3000) {
                i16 = BusinessInfoCheckUpdateItem.UIAPPID_TROOP_ASSISTANT_FEEDS;
            }
        } else {
            i3 = -11;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getForwardSrcBusinessType, srcBusinessType = " + i16 + ",sourceUinType = " + i3);
        }
        return i16;
    }

    @Deprecated
    public static void startForwardActivity(Context context, Intent intent, Class<?> cls) {
        startForwardActivity(context, intent, cls, -1, "");
    }

    @Deprecated
    public static void startForwardActivityForResult(Activity activity, Intent intent, Class<?> cls, int i3) {
        startForwardActivityForResult(activity, intent, cls, i3, -1, "");
    }

    public List<RecentUser> getForwardRecentList(List<RecentUser> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            return (List) iPatchRedirector.redirect((short) 108, this, list, Boolean.valueOf(z16));
        }
        boolean isFromSharePullRecentList = isFromSharePullRecentList();
        ArrayList arrayList = new ArrayList();
        if (!z16 && isFromSharePullRecentList && this.mShareDataLineSupportType == 2) {
            RecentUser recentUser = new RecentUser(AppConstants.DATALINE_PC_UIN, 6000);
            recentUser.displayName = HardCodeUtil.qqStr(R.string.cf5);
            arrayList.add(recentUser);
        }
        for (RecentUser recentUser2 : list) {
            if (!z16 && isFromSharePullRecentList && this.mShareDataLineSupportType == 1 && recentUser2 != null && TextUtils.equals(recentUser2.uin, AppConstants.DATALINE_PC_UIN)) {
                arrayList.add(recentUser2);
            } else if (isNeedAddToList(recentUser2)) {
                arrayList.add(recentUser2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getForwardRecentList result size is: " + arrayList.size());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3, String str3) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Boolean) iPatchRedirector.redirect((short) 71, this, str, str2, Integer.valueOf(i3), str3)).booleanValue();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = getUserInputStr();
        }
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(this.mSharePanelLeaveMsg)) {
            str3 = this.mSharePanelLeaveMsg;
        }
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "sendMessageOnConfirm: invoked.  textAndEmoji: " + str3);
        }
        this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str3);
        int c16 = com.tencent.mobileqq.activity.aio.forward.b.d().c();
        if (isMultiTarget2Send()) {
            int[] intArray = this.mExtraData.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
            this.mExtraData.remove("KEY_MSG_FORWARD_ID_ARRAY");
            if (intArray != null) {
                iArr = new int[intArray.length + 1];
                if (intArray.length > 0) {
                    System.arraycopy(intArray, 0, iArr, 0, intArray.length);
                }
                iArr[intArray.length] = c16;
            } else {
                iArr = new int[]{c16};
            }
            this.mExtraData.putIntArray("KEY_MSG_FORWARD_ID_ARRAY", iArr);
        } else {
            this.mExtraData.putInt("KEY_MSG_FORWARD_ID", c16);
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        if (((this instanceof ForwardShareCardOption) && !((IArkQQApi) QRoute.api(IArkQQApi.class)).isArkCustomDialog(this.mConfirmDialog) && !this.useBottomSheetPreviewFromBusiness) || NtMsgForwardUtils.f(this.mExtraData)) {
            return true;
        }
        int i16 = sessionInfo.f179555d;
        if (i16 == 10014 || i16 == 10016) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(GUILD_FORWARD_BUGFIX_SWITCH, false);
            QLog.d(TAG, 1, "sendMessage2TargetOnConfirm guild use common road switch: " + isSwitchOn);
            if (!isSwitchOn) {
                com.tencent.mobileqq.activity.aio.forward.b.d().h(sessionInfo, str3, c16);
                return true;
            }
        }
        if (this.mExtraData.getInt("forward_type") != 1060 && this.mExtraData.getInt("forward_type") != 1068) {
            com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, str3);
            this.mExtraData.remove(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        }
        return true;
    }

    protected void setPreviewImage(Drawable drawable, boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 90)) {
            this.mActivity.runOnUiThread(new Runnable(drawable, z16, i3, z17) { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.13
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Drawable f210565d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f210566e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f210567f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f210568h;

                {
                    this.f210565d = drawable;
                    this.f210566e = z16;
                    this.f210567f = i3;
                    this.f210568h = z17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ForwardBaseOption.this, drawable, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (ForwardBaseOption.this.mConfirmDialog.isShowing()) {
                        ForwardBaseOption.this.mConfirmDialog.setPreviewImage(this.f210565d, this.f210566e, this.f210567f, this.f210568h);
                        ForwardBaseOption.this.addOtherEditListener();
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 90, this, drawable, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        }
    }

    public static void startForwardActivity(Context context, Intent intent, int i3) {
        startForwardActivity(context, intent, ForwardRecentActivity.class, i3, "");
    }

    public static void startForwardActivityForResult(Activity activity, Intent intent, int i3, int i16) {
        startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, i3, i16, "");
    }

    public static void startForwardActivity(Activity activity, Intent intent, int i3, String str) {
        startForwardActivity(activity, intent, ForwardRecentActivity.class, i3, str);
    }

    public static void startForwardActivityForResult(Activity activity, String str, Intent intent, int i3, int i16) {
        startForwardActivityForResult(activity, str, intent, (Class<?>) ForwardRecentActivity.class, i3, i16);
    }

    protected String getTroopUin(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 69)) ? resultRecord == null ? "" : resultRecord.groupUin : (String) iPatchRedirector.redirect((short) 69, (Object) this, (Object) resultRecord);
    }

    static void startForwardActivity(Context context, Intent intent, Class<?> cls, int i3, String str) {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101182", false);
        boolean z16 = Looper.getMainLooper() == Looper.myLooper();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switchToUIThreadSwitch = " + isSwitchOn + " isMainThread = " + z16);
        }
        if (isSwitchOn && !z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(context, intent, cls, i3, str) { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f210560d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Intent f210561e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Class f210562f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f210563h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f210564i;

                {
                    this.f210560d = context;
                    this.f210561e = intent;
                    this.f210562f = cls;
                    this.f210563h = i3;
                    this.f210564i = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, context, intent, cls, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ForwardBaseOption.startForward(this.f210560d, this.f210561e, this.f210562f, this.f210563h, this.f210564i);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            startForward(context, intent, cls, i3, str);
        }
    }

    public static void startForwardActivityForResult(Activity activity, Intent intent, int i3, int i16, String str) {
        startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, i3, i16, str);
    }

    public static void startForwardActivityForResult(Activity activity, Intent intent, Class<?> cls, int i3, int i16, String str) {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101182", false);
        boolean z16 = Looper.getMainLooper() == Looper.myLooper();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switchToUIThreadSwitch = " + isSwitchOn + " isMainThread = " + z16);
        }
        if (isSwitchOn && !z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity, intent, cls, i3, i16, str) { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f210572d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Intent f210573e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Class f210574f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f210575h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f210576i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f210577m;

                {
                    this.f210572d = activity;
                    this.f210573e = intent;
                    this.f210574f = cls;
                    this.f210575h = i3;
                    this.f210576i = i16;
                    this.f210577m = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, activity, intent, cls, Integer.valueOf(i3), Integer.valueOf(i16), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ForwardBaseOption.startForwardForResult(this.f210572d, this.f210573e, (Class<?>) this.f210574f, this.f210575h, this.f210576i, this.f210577m);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            startForwardForResult(activity, intent, cls, i3, i16, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return ((Boolean) iPatchRedirector.redirect((short) 105, (Object) this)).booleanValue();
        }
        if (isMultiTarget2Send()) {
            return realForwardTo(false);
        }
        return realForwardTo(true);
    }

    public void showProgressDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this, i3);
            return;
        }
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new QQProgressDialog(this.mActivity, this.mAppContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        this.mProgressDialog.setMessage(i3);
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.mProgressDialog.show();
    }

    static void startForwardForResult(Activity activity, String str, Intent intent, Class<?> cls, int i3, int i16) {
        com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.k();
        intent.setClass(activity, cls);
        if (TextUtils.isEmpty(str)) {
            intent.putExtra("caller_name", activity.getClass().getSimpleName());
        } else {
            intent.putExtra("caller_name", str);
        }
        intent.putExtra("forward_source_business_type", i16);
        activity.startActivityForResult(intent, i3);
    }

    private void startToAioImagePreview(AIORichMediaData aIORichMediaData, String str) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startToAioImagePreview: msgId=");
            sb5.append(aIORichMediaData != null ? Long.valueOf(aIORichMediaData.f179628d) : "");
            QLog.d(TAG, 2, sb5.toString());
        }
        if (aIORichMediaData != null) {
            AIOImageProviderService aIOImageProviderService = new AIOImageProviderService(this.app.getCurrentUin(), str, 0, null);
            Bundle bundle = new Bundle();
            bundle.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
            enterImageGallery(bundle, aIOImageProviderService, aIORichMediaData);
            reportClickContentAction();
        }
    }

    static void startForwardActivityForResult(Activity activity, String str, Intent intent, Class<?> cls, int i3, int i16) {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101182", false);
        boolean z16 = Looper.getMainLooper() == Looper.myLooper();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "switchToUIThreadSwitch = " + isSwitchOn + " isMainThread = " + z16);
        }
        if (isSwitchOn && !z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity, str, intent, cls, i3, i16) { // from class: com.tencent.mobileqq.forward.ForwardBaseOption.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f210578d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f210579e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Intent f210580f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Class f210581h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f210582i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f210583m;

                {
                    this.f210578d = activity;
                    this.f210579e = str;
                    this.f210580f = intent;
                    this.f210581h = cls;
                    this.f210582i = i3;
                    this.f210583m = i16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, activity, str, intent, cls, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ForwardBaseOption.startForwardForResult(this.f210578d, this.f210579e, this.f210580f, (Class<?>) this.f210581h, this.f210582i, this.f210583m);
                    }
                }
            });
        } else {
            startForwardForResult(activity, str, intent, cls, i3, i16);
        }
    }
}
