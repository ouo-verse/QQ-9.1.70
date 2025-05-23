package cooperation.qzone.share;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MOBILE_OPERATION.operation_forward_req;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.util.h;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.o;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.g;
import com.tencent.open.appcommon.d;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.NewIntent;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneShareActivity extends IphoneTitleBarActivity {
    public static final String BROADCAST_SHARE_UPDATE = "com.tencent.qq.shareupdate";
    public static final String EXTRA_INPUT_MAX_LEN = "inputmax";
    public static final String EXTRA_INTENT_KEY_PARCELABLE = "extraIntentKeyParcelable";
    public static final String EXTRA_KEY_CONTENT_INTENT = "contentIntentKey";
    public static final String EXTRA_KEY_REQUEST_CODE = "extraRequestCode";
    public static final String KEY_ASK_ANONYMOUSLY_SHARE_TYPE = "askAnonymouslyShareType";
    public static final String KEY_IS_SHARED_FROM_ASK_ANONYMOUSLY = "isSharedFromAskAnonymously";
    public static final String KEY_IS_SHARED_FROM_MINI_PROGRAM = "isSharedFromMiniProgram";
    public static final String KEY_IS_SHARED_FROM_THIRD_PARTY = "isSharedFromThirdParty";
    public static final String KEY_MINI_SHARE_APP_IS_FROM_INNER_BUTTON = "miniShareIsFromInnerButton";
    public static final String KEY_MINI_SHARE_APP_OPEN_ID = "miniShareOpenId";
    public static final String KEY_MINI_SHARE_APP_PKG_NAME = "miniSharePkgName";
    public static final String KEY_MINI_SHARE_APP_RICH_ID = "miniShareAppRichId";
    public static final String KEY_MINI_SHARE_PARAM_APP_ID = "miniShareParamAppId";
    public static final String KEY_MINI_SHARE_PARAM_BUSINESS_TYPE = "miniShareParamBusinessType";
    public static final String KEY_MINI_SHARE_PARAM_DESCRIPTION = "miniShareParamDescription";
    public static final String KEY_MINI_SHARE_PARAM_ICON_URL = "miniShareParamIconUrl";
    public static final String KEY_MINI_SHARE_PARAM_JUMP_URL = "miniShareParamJumpUrl";
    public static final String KEY_MINI_SHARE_PARAM_PIC_URL = "miniShareParamPicUrl";
    public static final String KEY_MINI_SHARE_PARAM_SHARE_SCENE = "miniShareParamShareScene";
    public static final String KEY_MINI_SHARE_PARAM_TEMPLATE_TYPE = "miniShareParamTemplateType";
    public static final String KEY_MINI_SHARE_PARAM_TITLE = "miniShareParamTitle";
    public static final String KEY_MINI_SHARE_PARAM_VERSION_TYPE = "miniShareParamVersionType";
    public static final String KEY_MINI_SHARE_PRRAM_VERSION_ID = "miniShareParamVersionId";
    public static final String KEY_MINI_SHARE_SHARE_ORIGIN = "miniShareOrigin";
    private static final String SDK_SHARE_CALLBACK_CANCEL = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel";
    private static final String SDK_SHARE_CALLBACK_COMPLETE = "tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}";
    public static final String SHOW_AT_ICON = "showaticon";
    public static final String SHOW_EMOTION_ICON = "showemotionicon";
    public static final String TAG = "QZoneShare";
    protected View desToolbar;
    protected InputMethodManager imm;
    RelativeLayout line;
    private int mAtMaxLen;
    public List<Friend> mAtUserList;
    private RelativeLayout mConatainer;
    protected boolean mIsGettingAppinfo;
    private String mOwnUin;
    private QQProgressDialog mProgressDialog;
    private QZoneShareData mShareData;
    private FrameLayout mThumbContainer;
    private URLImageView mThumbView;
    public EditText mViewEdit;
    private TextView mViewForwardSummary;
    private TextView mViewForwardTitle;
    private TextView preMeasureSummaryTextArea;
    private int rootHeight;
    protected View viewAtUser;
    protected View viewDivider;
    protected SystemEmoticonPanel viewEmoView;
    protected ImageView viewSmiley;
    protected TextView viewTextCount;
    public static final Pattern AT_PATTERN = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
    protected static final String simpleClassname = QZoneShareActivity.class.getSimpleName();
    protected static final Object sAppinfoLock = new Object();
    public boolean isResemeInited = false;
    public int mMaxLen = 0;
    public boolean showMaxLen = true;
    protected boolean hintHidden = false;
    protected boolean emoShow = false;
    protected boolean emoShowing = false;
    protected boolean isKeyboardHidden = false;
    protected boolean isInputAt = false;
    private boolean isSharedFromMiniProgram = false;
    private boolean needShareCallback = false;
    private boolean isFromInnerButton = false;
    private boolean isSharedFromAskAnonymously = false;
    private int askAnonymouslyShareType = 0;
    private boolean mIsCanShowKeyboard = true;
    private int mShowAtIcon = 1;
    private int mShowEmoIcon = 1;
    private int atStatr = -1;
    private int atEnd = -1;
    private String tmpAtCode = "";
    private String mThumbUrl = null;
    private String mTitle = null;
    private String mSummary = null;
    private String mHint = null;
    protected long mTempTime = 0;
    protected GetAppInfoProto$GetAppinfoResponse mGetAppinfoResponse = null;
    protected d mAppinfoObserver = new d() { // from class: cooperation.qzone.share.QZoneShareActivity.18
        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            synchronized (QZoneShareActivity.sAppinfoLock) {
                QZoneShareActivity.this.mIsGettingAppinfo = false;
                if (z16) {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                            getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                            QZoneShareActivity.this.mGetAppinfoResponse = getAppInfoProto$GetAppinfoResponse;
                            if (QLog.isColorLevel()) {
                                QLog.d(QZoneShareActivity.TAG, 2, "get appinfo time = " + (System.currentTimeMillis() - QZoneShareActivity.this.mTempTime));
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QZoneShareActivity.TAG, 2, e16.getMessage());
                        }
                    }
                }
                QZoneShareActivity.sAppinfoLock.notify();
            }
        }
    };
    BroadcastReceiver receiver = new BroadcastReceiver() { // from class: cooperation.qzone.share.QZoneShareActivity.21
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qq.shareupdate".equals(intent.getAction())) {
                ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneShareActivity.this.updateData();
                    }
                }, null, true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cooperation.qzone.share.QZoneShareActivity$23, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static /* synthetic */ class AnonymousClass23 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$biz$qui$quisecnavbar$BaseAction;

        static {
            int[] iArr = new int[BaseAction.values().length];
            $SwitchMap$com$tencent$biz$qui$quisecnavbar$BaseAction = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$biz$qui$quisecnavbar$BaseAction[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cooperation.qzone.share.QZoneShareActivity$4, reason: invalid class name */
    /* loaded from: classes38.dex */
    public class AnonymousClass4 implements MiniAppCmdInterface {
        AnonymousClass4() {
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            final long j3;
            final String str;
            if (!z16 || jSONObject == null) {
                if (jSONObject != null) {
                    QZoneShareActivity.this.needShareCallback = jSONObject.optBoolean("needShareCallBack");
                    j3 = jSONObject.optLong("retCode");
                    str = jSONObject.optString("errMsg");
                } else {
                    j3 = -1;
                    str = null;
                }
                if (!QZoneShareActivity.this.needShareCallback) {
                    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
                }
                QZoneShareActivity.this.runOnUiThread(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        long j16 = j3;
                        if (j16 != -100070004 && j16 != -1000710003) {
                            QZoneShareActivity.this.hideProgressDialog();
                            QZoneShareActivity.this.callbackShareFail();
                            ((IMiniAppService) QRoute.api(IMiniAppService.class)).shareErrorToast(QZoneShareActivity.this, j3, str);
                            QZoneShareActivity.this.finish();
                            return;
                        }
                        if (QZoneShareActivity.this.isFinishing()) {
                            QLog.d(QZoneShareActivity.TAG, 1, "current activity is finishing, not show dialog.");
                            return;
                        }
                        QZoneShareActivity.this.hideProgressDialog();
                        QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                        DialogUtil.createCustomDialog(qZoneShareActivity, 233, qZoneShareActivity.getString(R.string.hix), str, new DialogInterface.OnClickListener() { // from class: cooperation.qzone.share.QZoneShareActivity.4.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                QLog.e(QZoneShareActivity.TAG, 1, "dialog click ");
                                QZoneShareActivity.this.finish();
                            }
                        }, null).show();
                    }
                });
                return;
            }
            String optString = jSONObject.optString("jump_url");
            QZoneShareActivity.this.needShareCallback = jSONObject.optBoolean("needShareCallBack");
            if (QZoneShareActivity.this.mShareData != null && QZoneShareActivity.this.mShareData.xcxMapEx != null) {
                QZoneShareActivity.this.mShareData.xcxMapEx.put(operation_forward_req.XCX_MAPEX_KEY_FAKE_LINK, optString);
            }
            if (!QZoneShareActivity.this.needShareCallback) {
                QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
            }
            QZoneShareActivity.this.handleShareData();
            QZoneShareActivity.this.runOnUiThread(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.4.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneShareActivity.this.updateLayout();
                    QZoneShareActivity.this.updateImageView();
                    QZoneShareActivity.this.hideProgressDialog();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cooperation.qzone.share.QZoneShareActivity$6, reason: invalid class name */
    /* loaded from: classes38.dex */
    public class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
            if (qZoneShareActivity.app != null && qZoneShareActivity.mShareData.appid > 0 && !TextUtils.isEmpty(QZoneShareActivity.this.mShareData.pkgname)) {
                QZoneShareActivity qZoneShareActivity2 = QZoneShareActivity.this;
                if (!qZoneShareActivity2.checkAppinfoLocked(qZoneShareActivity2.app, qZoneShareActivity2.mShareData.appid, QZoneShareActivity.this.mShareData.pkgname)) {
                    return;
                }
            }
            final int contentWordCount = QZoneShareActivity.this.getContentWordCount();
            final int maxWordCnt = QZoneShareActivity.this.getMaxWordCnt();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.6.1
                @Override // java.lang.Runnable
                public void run() {
                    long j3;
                    boolean z16;
                    if (contentWordCount > maxWordCnt) {
                        QQToast.makeText(QZoneShareActivity.this, 4, R.string.f173054gr0, 0).show();
                        return;
                    }
                    QZoneShareActivity.this.hideKeyboardAndEmo();
                    final String splash2Emo = QzoneEmotionUtils.splash2Emo(QZoneShareActivity.this.getEditText());
                    try {
                        j3 = Long.parseLong(QZoneShareActivity.this.mShareData.shareUin);
                    } catch (Exception unused) {
                        j3 = 0;
                    }
                    if (j3 <= 0) {
                        j3 = QZoneShareActivity.this.app.getLongAccountUin();
                    }
                    if (j3 <= 0) {
                        j3 = QZoneShareActivity.this.app.getLongAccountUin();
                    }
                    final ArrayList<String> arrayList = QZoneShareActivity.this.mShareData.mImageUrls;
                    if (arrayList != null) {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!TextUtils.isEmpty(next) && !next.startsWith("http://") && !next.startsWith("https://")) {
                                z16 = false;
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                        NewIntent newIntent = new NewIntent(QZoneShareActivity.this, QzoneShareServlet.class);
                        newIntent.putExtra("reason", splash2Emo);
                        newIntent.putExtra("uin", j3);
                        newIntent.putExtra("sharedata", QZoneShareActivity.this.mShareData);
                        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
                        QLog.e(QZoneShareActivity.TAG, 1, "startShare()");
                    } else {
                        ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long j16;
                                if (new ArrayList(arrayList).equals(QZoneShareManager.batchUploadImages(arrayList, QZoneShareActivity.this.app.getAccount(), "1"))) {
                                    QLog.e(QZoneShareActivity.TAG, 1, "imageChangeError!");
                                }
                                try {
                                    j16 = Long.parseLong(QZoneShareActivity.this.mShareData.shareUin);
                                } catch (Exception unused2) {
                                    j16 = 0;
                                }
                                if (j16 <= 0) {
                                    j16 = QZoneShareActivity.this.app.getLongAccountUin();
                                }
                                NewIntent newIntent2 = new NewIntent(QZoneShareActivity.this, QzoneShareServlet.class);
                                newIntent2.putExtra("reason", splash2Emo);
                                newIntent2.putExtra("uin", j16);
                                newIntent2.putExtra("sharedata", QZoneShareActivity.this.mShareData);
                                BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent2);
                                QLog.e(QZoneShareActivity.TAG, 1, "startShare()");
                            }
                        }, null, false);
                    }
                    if (QZoneShareActivity.this.mShareData.from != 1) {
                        QZoneShareActivity.this.askAnonymouslyReport();
                        Intent intent = QZoneShareActivity.this.getIntent();
                        if (intent != null ? intent.getBooleanExtra("is_need_show_toast", true) : true) {
                            QQToast.makeText(QZoneShareActivity.this, 5, HardCodeUtil.qqStr(R.string.s8o), 0).show();
                        }
                    } else {
                        QZoneShareActivity qZoneShareActivity3 = QZoneShareActivity.this;
                        qZoneShareActivity3.startSdkCallback(qZoneShareActivity3, qZoneShareActivity3.mShareData, true);
                    }
                    QZoneShareActivity qZoneShareActivity4 = QZoneShareActivity.this;
                    qZoneShareActivity4.setResult(-1, qZoneShareActivity4.getIntent());
                    QZoneShareActivity.this.finish();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajustDesToolbar(boolean z16) {
        if (this.isKeyboardHidden && !z16) {
            this.desToolbar.setVisibility(4);
        } else {
            this.desToolbar.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void askAnonymouslyReport() {
        if (this.isSharedFromAskAnonymously && this.askAnonymouslyShareType == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800B46E", "0X800B46E", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackShareFail() {
        if (this.isSharedFromMiniProgram) {
            Bundle bundle = new Bundle();
            bundle.putString("key_mini_report_event_action_type", "user_click");
            if (this.isFromInnerButton) {
                bundle.putString("key_mini_report_event_sub_action_type", "custom_button");
            } else {
                bundle.putString("key_mini_report_event_sub_action_type", "more_button");
            }
            bundle.putString("key_mini_report_event_reserves", "share_QZ");
            bundle.putString("key_mini_report_event_reserves2", "fail");
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
            if (this.needShareCallback) {
                QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_FAIL_CALLBACK, null, null);
            }
        }
    }

    private void callbackShareSuccess() {
        if (this.isSharedFromMiniProgram) {
            Bundle bundle = new Bundle();
            bundle.putString("key_mini_report_event_action_type", "user_click");
            if (this.isFromInnerButton) {
                bundle.putString("key_mini_report_event_sub_action_type", "custom_button");
            } else {
                bundle.putString("key_mini_report_event_sub_action_type", "more_button");
            }
            bundle.putString("key_mini_report_event_reserves", "share_QZ");
            bundle.putString("key_mini_report_event_reserves2", "success");
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
            if (this.needShareCallback) {
                QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
            }
        }
    }

    public static String filterText(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str.toString().replace("\r\n", " ").replace("\n", " "), " ");
        StringBuffer stringBuffer = new StringBuffer();
        while (stringTokenizer.hasMoreTokens()) {
            stringBuffer.append(stringTokenizer.nextToken() + TokenParser.SP);
        }
        return stringBuffer.toString().trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findAtSymbol(CharSequence charSequence, int i3) {
        return InputViewPanelControl.findAtSymbol(charSequence, i3, this.mAtMaxLen, this.mAtUserList, this.atStatr, this.atEnd, this.tmpAtCode);
    }

    private void getAppinfo(AppInterface appInterface, long j3, String str) {
        this.mTempTime = System.currentTimeMillis();
        this.mIsGettingAppinfo = true;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String o16 = g.o(this, str, currentTimeMillis + "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "-->sdk_share, getting appinfo in construct. sign: " + o16);
        }
        Share.n(appInterface, this, appInterface.getCurrentAccountUin(), j3, o16, currentTimeMillis, this.mAppinfoObserver, str);
    }

    private int getTitleLineCount(String str, int i3, int i16) {
        TextView textView = new TextView(BaseApplication.getContext());
        textView.setText(str);
        textView.setTextSize(2, i3);
        textView.setMaxLines(2);
        textView.measure(View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return textView.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShareData() {
        QZoneShareData qZoneShareData;
        QZoneShareData qZoneShareData2 = this.mShareData;
        if (qZoneShareData2 != null) {
            if (this.isSharedFromAskAnonymously) {
                this.mThumbUrl = IProfileCardConst.SHARE_TO_QZONE_ICON_URL;
            } else {
                ArrayList<String> arrayList = qZoneShareData2.mImageUrls;
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<String> it = this.mShareData.mImageUrls.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (!TextUtils.isEmpty(next)) {
                            this.mThumbUrl = next;
                            break;
                        }
                    }
                }
            }
            this.mTitle = TextUtils.isEmpty(this.mShareData.mTitle) ? null : this.mShareData.mTitle.trim();
            QZoneShareData qZoneShareData3 = this.mShareData;
            String str = qZoneShareData3.mSummary;
            if (str != null) {
                qZoneShareData3.mSummary = str.trim();
            }
            this.mSummary = TextUtils.isEmpty(this.mShareData.mSummary) ? null : this.mShareData.mSummary.trim();
            if (!TextUtils.isEmpty(this.mTitle) && !TextUtils.isEmpty(this.mSummary)) {
                if (this.mTitle.equals(this.mSummary)) {
                    this.mSummary = null;
                } else if (this.mTitle.length() > 20) {
                    if (this.mSummary.startsWith(this.mTitle.substring(0, 20))) {
                        this.mSummary = null;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "params: " + this.mShareData.toString());
            }
            if (!TextUtils.isEmpty(this.mShareData.mDefaultForwardReason)) {
                this.mViewEdit.setText(this.mShareData.mDefaultForwardReason);
            }
        }
        openIdConfirm(this.mShareData);
        report(this.mShareData);
        if (this.app == null || (qZoneShareData = this.mShareData) == null || qZoneShareData.appid <= 0 || TextUtils.isEmpty(qZoneShareData.pkgname)) {
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        QZoneShareData qZoneShareData4 = this.mShareData;
        getAppinfo(qQAppInterface, qZoneShareData4.appid, qZoneShareData4.pkgname);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMatchAt(String str, boolean z16) {
        return InputViewPanelControl.isMatchAt(str, z16, this.mAtUserList, this.atStatr, this.atEnd, this.tmpAtCode);
    }

    public static final boolean isValidUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initUI$0(View view, BaseAction baseAction) {
        int i3 = AnonymousClass23.$SwitchMap$com$tencent$biz$qui$quisecnavbar$BaseAction[baseAction.ordinal()];
        if (i3 == 1) {
            onBackEvent();
            return null;
        }
        if (i3 != 2) {
            return null;
        }
        startShare();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAt() {
        this.tmpAtCode = "";
        this.atStatr = -1;
        this.atEnd = -1;
    }

    private void startShare() {
        callbackShareSuccess();
        if (!NetworkUtil.isNetSupport(this)) {
            h.T(1, R.string.f171139ci4);
        } else {
            ThreadManagerV2.postImmediately(new AnonymousClass6(), null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateData() {
        if (this.mShareData == null) {
            this.mShareData = new QZoneShareData();
        }
        if (this.mShareData.from != 2) {
            return;
        }
        String string = LocalMultiProcConfig.getString("msharecururl", "");
        if (!TextUtils.isEmpty(string) && string.equals(this.mShareData.mWebUrl)) {
            String string2 = LocalMultiProcConfig.getString("msharetitle", "");
            String string3 = LocalMultiProcConfig.getString("msharedesc", "");
            String string4 = LocalMultiProcConfig.getString("msharethumb", "");
            String string5 = LocalMultiProcConfig.getString("mshareurl", "");
            int i3 = LocalMultiProcConfig.getInt("msharefrom", -1);
            String str = null;
            String trim = TextUtils.isEmpty(string2) ? null : string2.trim();
            String trim2 = TextUtils.isEmpty(string3) ? null : string3.trim();
            boolean z16 = false;
            if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(trim2) || (!trim.equals(trim2) && (trim.length() <= 20 || !trim2.startsWith(trim.substring(0, 20))))) {
                str = trim2;
            }
            boolean z17 = true;
            if (!TextUtils.isEmpty(trim) && !trim.equals(this.mTitle)) {
                this.mTitle = trim;
                this.mShareData.mTitle = trim;
                z16 = true;
            }
            if (!TextUtils.isEmpty(str) && !str.equals(this.mSummary)) {
                this.mSummary = str;
                this.mShareData.mSummary = str;
                z16 = true;
            }
            if (TextUtils.isEmpty(string4) || string4.equals(this.mThumbUrl)) {
                z17 = z16;
            } else {
                this.mThumbUrl = string4;
                ArrayList<String> arrayList = this.mShareData.mImageUrls;
                if (arrayList != null) {
                    arrayList.clear();
                    this.mShareData.mImageUrls.add(string4);
                } else {
                    new ArrayList().add(string4);
                }
            }
            if (!TextUtils.isEmpty(string5) && !string5.equals(this.mShareData.targetUrl)) {
                this.mShareData.targetUrl = string5;
            }
            if (z17) {
                this.mShareData.iUrlInfoFrm = i3;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.22
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneShareActivity.this.updateLayout();
                    }
                });
            }
        }
    }

    private void updateForwardSummary() {
        this.mViewForwardSummary.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(handleATContent(this.mSummary)), 3, 16));
    }

    private void updateForwardTitle() {
        this.mViewForwardTitle.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(handleATContent(this.mTitle)), 3, 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageView() {
        URLDrawable drawable;
        Drawable drawable2 = getResources().getDrawable(R.drawable.ase);
        if (!TextUtils.isEmpty(this.mThumbUrl)) {
            if (com.qzone.reborn.configx.g.f53821a.k().q()) {
                c.a().h(Option.obtain().setUrl(this.mThumbUrl).setTargetView(this.mThumbView).setRequestWidth(ViewUtils.dpToPx(70.0f)).setRequestHeight(ViewUtils.dpToPx(70.0f)).setLoadingDrawable(drawable2).setFailDrawable(drawable2));
                return;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = drawable2;
            obtain.mFailedDrawable = drawable2;
            obtain.mRequestHeight = ViewUtils.dpToPx(70.0f);
            obtain.mRequestWidth = ViewUtils.dpToPx(70.0f);
            if (isValidUrl(this.mThumbUrl)) {
                drawable = URLDrawable.getDrawable(this.mThumbUrl, obtain);
            } else {
                drawable = URLDrawable.getDrawable(new File(this.mThumbUrl), obtain);
            }
            this.mThumbView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.mThumbView.setImageDrawable(drawable);
            return;
        }
        this.mThumbView.setBackgroundDrawable(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        QZoneShareData qZoneShareData;
        ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_text_primary);
        ColorStateList colorStateList2 = getResources().getColorStateList(R.color.qui_common_text_secondary);
        if (TextUtils.isEmpty(this.mTitle)) {
            this.mViewForwardTitle.setVisibility(8);
            this.mViewForwardSummary.setVisibility(0);
            if (TextUtils.isEmpty(this.mSummary) && (qZoneShareData = this.mShareData) != null) {
                this.mViewForwardSummary.setText(qZoneShareData.targetUrl);
            } else {
                updateForwardSummary();
            }
            if (colorStateList != null) {
                this.mViewForwardSummary.setTextColor(colorStateList);
            }
            this.mViewForwardSummary.setMaxLines(2);
        } else if (TextUtils.isEmpty(this.mSummary)) {
            this.mViewForwardTitle.setVisibility(0);
            this.mViewForwardSummary.setVisibility(8);
            updateForwardTitle();
            if (colorStateList != null) {
                this.mViewForwardTitle.setTextColor(colorStateList);
            }
            this.mViewForwardTitle.setMaxLines(2);
        } else if (getTitleLineCount(this.mTitle, 14, ((ViewUtils.getScreenWidth() - ViewUtils.dpToPx(24.0f)) - ViewUtils.dpToPx(24.0f)) - ViewUtils.dpToPx(80.0f)) > 1) {
            this.mViewForwardTitle.setVisibility(0);
            this.mViewForwardSummary.setVisibility(8);
            updateForwardTitle();
            if (colorStateList != null) {
                this.mViewForwardTitle.setTextColor(colorStateList);
            }
            this.mViewForwardTitle.setMaxLines(2);
        } else {
            this.mViewForwardTitle.setVisibility(0);
            if (colorStateList != null) {
                this.mViewForwardTitle.setTextColor(colorStateList);
            }
            this.mViewForwardSummary.setVisibility(0);
            if (colorStateList != null) {
                this.mViewForwardSummary.setTextColor(colorStateList2);
            }
            updateForwardTitle();
            this.mViewForwardTitle.setMaxLines(1);
            updateForwardSummary();
            this.mViewForwardSummary.setMaxLines(1);
        }
        this.mThumbView.setBackgroundDrawable(getResources().getDrawable(R.drawable.ase));
    }

    protected void addAtUser(ArrayList<ResultRecord> arrayList) {
        EditText editText = this.mViewEdit;
        if (editText == null) {
            return;
        }
        if (this.isInputAt) {
            int selectionStart = editText.getSelectionStart();
            Editable editableText = this.mViewEdit.getEditableText();
            if (editableText != null && !TextUtils.isEmpty(editableText.toString())) {
                int i3 = selectionStart - 1;
                if (editableText.toString().substring(i3, selectionStart).equals("@")) {
                    editableText.delete(i3, selectionStart);
                }
            }
            this.isInputAt = false;
        }
        this.mAtMaxLen = InputViewPanelControl.addAtUser(this.mViewEdit, arrayList, this.mAtUserList, this.mAtMaxLen);
    }

    protected final void addEmoPanel() {
        this.mViewEdit.setEditableFactory(o.f292704d);
        try {
            this.viewEmoView = InputViewPanelControl.createEmoPanel(this, this.mViewEdit);
            onAddEmoPanel();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == 0) {
            this.isInputAt = false;
        } else {
            if (i3 != 1000) {
                return;
            }
            onAtUserResult(i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        try {
            unregisterReceiver(this.receiver);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        hideKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        registerReceiver(this.receiver, new IntentFilter("com.tencent.qq.shareupdate"));
        if (!this.isResemeInited) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneShareActivity.this.updateData();
                }
            }, null, true);
            this.isResemeInited = true;
        } else {
            updateImageView();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        EditText editText;
        super.doOnWindowFocusChanged(z16);
        if (!z16 || (editText = this.mViewEdit) == null) {
            return;
        }
        editText.setFocusable(true);
        this.mViewEdit.requestFocus();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.14
            @Override // java.lang.Runnable
            public void run() {
                EditText editText2 = QZoneShareActivity.this.mViewEdit;
                if (editText2 != null) {
                    Editable text = editText2.getText();
                    QZoneShareActivity.this.mViewEdit.setSelection(text != null ? text.length() : 0);
                }
                if (QZoneShareActivity.this.isFinishing()) {
                    return;
                }
                QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                if (qZoneShareActivity.emoShow) {
                    return;
                }
                qZoneShareActivity.showKeyboard();
            }
        }, 300L);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        ForwardRecentActivity.notifyResultReceiver(getIntent(), this);
        super.finish();
    }

    public int getContentWordCount() {
        EditText editText = this.mViewEdit;
        if (editText != null) {
            return filterText(getStringFromEditText(editText)).length();
        }
        return 0;
    }

    protected final String getEditText() {
        return InputViewPanelControl.getEditText(this.mViewEdit, this.mAtUserList);
    }

    protected int getMaxWordCnt() {
        int i3 = this.mMaxLen;
        return i3 > 0 ? i3 : QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONESETTINGS_MAXUGCTEXTCOUNT, 2000);
    }

    protected View getRoot() {
        return this.mConatainer;
    }

    public String handleATContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        Matcher matcher = AT_PATTERN.matcher(sb5);
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                int indexOf = group.indexOf("uin:") + 4;
                int indexOf2 = group.indexOf(",nick:");
                group.substring(indexOf, indexOf2);
                String str2 = "@" + group.substring(indexOf2 + 6, group.length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
                sb5.replace(start, end, str2);
                i3 += group.length() - str2.length();
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
                return str;
            }
        }
        return sb5.toString();
    }

    protected boolean hideEmoView() {
        SystemEmoticonPanel systemEmoticonPanel = this.viewEmoView;
        if (systemEmoticonPanel == null || this.viewDivider == null || this.viewSmiley == null || !this.emoShow) {
            return false;
        }
        this.emoShow = false;
        systemEmoticonPanel.setVisibility(8);
        this.viewDivider.setVisibility(4);
        ajustDesToolbar(this.emoShow);
        this.viewSmiley.setImageResource(R.drawable.qui_emoticon);
        return true;
    }

    protected boolean hideKeyboard() {
        return hideKeyboard(true);
    }

    protected void hideKeyboardAndEmo() {
        hideKeyboardAndEmo(true);
    }

    public void hideProgressDialog() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.20
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneShareActivity.this.mProgressDialog == null || !QZoneShareActivity.this.mProgressDialog.isShowing()) {
                    return;
                }
                try {
                    QZoneShareActivity.this.mProgressDialog.dismiss();
                } catch (Exception e16) {
                    QLog.e(QZoneShareActivity.TAG, 1, e16.getMessage());
                }
            }
        });
    }

    protected void onAddEmoPanel() {
        View root = getRoot();
        if (root instanceof RelativeLayout) {
            final RelativeLayout relativeLayout = (RelativeLayout) root;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.line = new RelativeLayout(this);
            this.desToolbar = LayoutInflater.from(this).inflate(R.layout.f169040hm3, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(10);
            this.desToolbar.setVisibility(4);
            this.line.addView(this.desToolbar, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams3.addRule(3, this.desToolbar.getId());
            View inflate = LayoutInflater.from(this).inflate(R.layout.bjh, (ViewGroup) null);
            this.viewDivider = inflate;
            View findViewById = inflate.findViewById(R.id.bv9);
            findViewById.setVisibility(0);
            findViewById.setBackgroundResource(R.drawable.qui_common_border_standard_bg);
            this.line.addView(this.viewDivider, layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) (ViewUtils.getDensity() * 150.0f));
            layoutParams4.addRule(3, this.viewDivider.getId());
            this.line.addView(this.viewEmoView, layoutParams4);
            this.viewEmoView.setVisibility(8);
            this.viewEmoView.setBackgroundColor(getResources().getColor(R.color.qui_common_bg_top_light));
            relativeLayout.addView(this.line, layoutParams);
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cooperation.qzone.share.QZoneShareActivity.7
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    relativeLayout.getWindowVisibleDisplayFrame(rect);
                    if (rect.bottom > QZoneShareActivity.this.rootHeight) {
                        QZoneShareActivity.this.rootHeight = rect.bottom;
                    }
                    int i3 = QZoneShareActivity.this.rootHeight - rect.bottom;
                    if (i3 <= 0) {
                        QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                        if (!qZoneShareActivity.emoShow) {
                            qZoneShareActivity.desToolbar.setVisibility(4);
                            relativeLayout.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                    QZoneShareActivity.this.desToolbar.setVisibility(0);
                    relativeLayout.setPadding(0, 0, 0, i3);
                }
            });
        }
    }

    protected void onAtUserResult(int i3, Intent intent) {
        addAtUser(intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET));
    }

    protected void onBack() {
        hideKeyboardAndEmo();
        QZoneShareData qZoneShareData = this.mShareData;
        if (qZoneShareData.from == 1) {
            startSdkCallback(this, qZoneShareData, false);
        }
        setResult(0, getIntent());
        onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        callbackShareFail();
        return super.onBackEvent();
    }

    @Override // mqq.app.AppActivity, android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        if (com.qzone.reborn.configx.g.f53821a.b().m0()) {
            super.onRestoreInstanceState(bundle);
        }
    }

    protected void onTextCountChange() {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.13
            @Override // java.lang.Runnable
            public void run() {
                final int contentWordCount = QZoneShareActivity.this.getContentWordCount() - QZoneShareActivity.this.getMaxWordCnt();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TextView textView = QZoneShareActivity.this.viewTextCount;
                        if (textView == null) {
                            return;
                        }
                        if (contentWordCount > 0) {
                            String str = HardCodeUtil.qqStr(R.string.s8l) + contentWordCount + HardCodeUtil.qqStr(R.string.s8x);
                            QZoneShareActivity.this.viewTextCount.setTextColor(QZoneShareActivity.this.getResources().getColor(R.color.a_d));
                            QZoneShareActivity.this.viewTextCount.setText(str);
                            if (QZoneShareActivity.this.viewTextCount.getVisibility() != 0) {
                                QZoneShareActivity.this.viewTextCount.setVisibility(0);
                            }
                            QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                            if (qZoneShareActivity.showMaxLen) {
                                QQToast.makeText(qZoneShareActivity, R.string.f173054gr0, 0).show();
                                QZoneShareActivity.this.showMaxLen = false;
                                return;
                            }
                            return;
                        }
                        if (textView.getVisibility() != 8) {
                            QZoneShareActivity.this.viewTextCount.setVisibility(8);
                        }
                    }
                });
            }
        }, null, true);
    }

    protected void setEventAtUser() {
        View view = this.viewAtUser;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: cooperation.qzone.share.QZoneShareActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                RDMEtraMsgCollector.getInstance().addNoramlClickAction(QZoneShareActivity.simpleClassname, view2);
                QZoneShareActivity.this.hideKeyboardAndEmo(false);
                Intent intent = new Intent();
                intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
                ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(QZoneShareActivity.this, intent, 1000);
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
    }

    protected void setEventEditView() {
        EditText editText = this.mViewEdit;
        if (editText == null) {
            return;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: cooperation.qzone.share.QZoneShareActivity.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                QZoneShareActivity.this.mViewEdit.removeTextChangedListener(this);
                if (charSequence == null) {
                    QZoneShareActivity.this.mViewEdit.addTextChangedListener(this);
                    QZoneShareActivity.this.resetAt();
                    return;
                }
                if (i17 == 1 && i16 == 0 && charSequence.toString().substring(i3, i3 + 1).equals("@")) {
                    QZoneShareActivity.this.hideKeyboardAndEmo(false);
                    QZoneShareActivity.this.isInputAt = true;
                    Intent intent = new Intent();
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
                    intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
                    ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(QZoneShareActivity.this, intent, 1000);
                }
                QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                if (qZoneShareActivity.isMatchAt(qZoneShareActivity.tmpAtCode, false)) {
                    QZoneShareActivity.this.mViewEdit.getEditableText().delete(QZoneShareActivity.this.atStatr, QZoneShareActivity.this.atEnd);
                }
                QZoneShareActivity.this.resetAt();
                QZoneShareActivity.this.onTextCountChange();
                QZoneShareActivity.this.mViewEdit.addTextChangedListener(this);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                if ((i16 == 1 || i16 == 2) && i17 == 0) {
                    try {
                        QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                        qZoneShareActivity.atStatr = qZoneShareActivity.findAtSymbol(charSequence, i3 + i16);
                        if (QZoneShareActivity.this.atStatr == -1) {
                            QZoneShareActivity.this.resetAt();
                        } else {
                            QZoneShareActivity.this.atEnd = i3;
                            QZoneShareActivity.this.tmpAtCode = charSequence.toString().substring(QZoneShareActivity.this.atStatr, QZoneShareActivity.this.atEnd + i16);
                        }
                    } catch (Exception unused) {
                        QZoneShareActivity.this.resetAt();
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.mViewEdit.setOnTouchListener(new View.OnTouchListener() { // from class: cooperation.qzone.share.QZoneShareActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                EditText editText2;
                QZoneShareActivity.this.hideEmoView();
                QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                if (qZoneShareActivity.hintHidden || (editText2 = qZoneShareActivity.mViewEdit) == null) {
                    return false;
                }
                editText2.setHint("");
                QZoneShareActivity.this.hintHidden = true;
                return false;
            }
        });
    }

    protected void setEventSmiley() {
        ImageView imageView = this.viewSmiley;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cooperation.qzone.share.QZoneShareActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                if (!qZoneShareActivity.emoShow) {
                    qZoneShareActivity.showEmoView();
                } else {
                    qZoneShareActivity.showKeyboard();
                    QZoneShareActivity.this.hideEmoView();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    protected void showEmoView() {
        if (this.viewEmoView == null || this.viewDivider == null || this.viewSmiley == null || this.emoShowing) {
            return;
        }
        hideKeyboard();
        this.mViewEdit.requestFocus();
        this.emoShowing = true;
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.12
            @Override // java.lang.Runnable
            public void run() {
                QZoneShareActivity.this.viewEmoView.setVisibility(0);
                QZoneShareActivity.this.viewDivider.setVisibility(0);
                QZoneShareActivity.this.viewSmiley.setImageResource(R.drawable.qui_keyboard_circle);
                QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                qZoneShareActivity.emoShow = true;
                qZoneShareActivity.emoShowing = false;
                qZoneShareActivity.ajustDesToolbar(true);
            }
        }, 100L);
    }

    protected void showKeyboard() {
        InputMethodManager inputMethodManager;
        EditText editText;
        if (!this.mIsCanShowKeyboard || (inputMethodManager = this.imm) == null || (editText = this.mViewEdit) == null) {
            return;
        }
        inputMethodManager.showSoftInput(editText, 2);
        this.isKeyboardHidden = false;
    }

    protected final void showOpenIdConfirmDialog(final Activity activity, final QZoneShareData qZoneShareData) {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: cooperation.qzone.share.QZoneShareActivity.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (i3 != 0) {
                    return;
                }
                QZoneShareActivity.this.startSdkCallback(activity, qZoneShareData, false);
                activity.setResult(0, QZoneShareActivity.this.getIntent());
                activity.finish();
            }
        };
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setMessage(R.string.d65);
        createCustomDialog.setTitle(R.string.b1v);
        createCustomDialog.setNegativeButton(R.string.cancel, onClickListener);
        createCustomDialog.setPositiveButton(R.string.hin, onClickListener);
        createCustomDialog.setCancelable(false);
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            createCustomDialog.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.toString());
        }
    }

    public void showProgressDialog(final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.19
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneShareActivity.this.mProgressDialog == null) {
                    QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                    QZoneShareActivity qZoneShareActivity2 = QZoneShareActivity.this;
                    qZoneShareActivity.mProgressDialog = new QQProgressDialog(qZoneShareActivity2, qZoneShareActivity2.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
                QZoneShareActivity.this.mProgressDialog.setMessage(i3);
                try {
                    if (QZoneShareActivity.this.isFinishing()) {
                        QLog.d(QZoneShareActivity.TAG, 1, "current activity is finishing, not show dialog.");
                    } else {
                        QZoneShareActivity.this.mProgressDialog.show();
                    }
                } catch (Exception e16) {
                    QLog.e(QZoneShareActivity.TAG, 1, e16.getMessage());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        return true;
    }

    private void report(QZoneShareData qZoneShareData) {
        if (qZoneShareData != null && qZoneShareData.mShareBeginTime > 0) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("url", qZoneShareData.targetUrl);
            hashMap.put("time_cost", String.valueOf(System.currentTimeMillis() - qZoneShareData.mShareBeginTime));
            hashMap.put("time_interval", String.valueOf((System.currentTimeMillis() - qZoneShareData.mShareBeginTime) / 100));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "timecost:" + (System.currentTimeMillis() - qZoneShareData.mShareBeginTime));
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.mOwnUin, StatisticCollector.QZONE_SHARE_TIMECOST, true, 0L, 0L, hashMap, (String) null, true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "timecost: -1");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnCreate()");
        }
        if (getIntent() == null) {
            QLog.e(TAG, 1, "onCreate getIntent is null");
            finish();
        }
        getWindow().setSoftInputMode(3);
        initUI();
        initData();
        updateLayout();
        if (!ImmersiveUtils.statusHeightCorrect && !isInMultiWindow()) {
            getWindow().getDecorView().post(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ImmersiveUtils.correctStatusBarHeight(QZoneShareActivity.this.getWindow())) {
                        QZoneShareActivity.this.recreate();
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.mThumbUrl) && !isValidUrl(this.mThumbUrl) && getIntent().getBooleanExtra(QZoneShareManager.QZONE_SHARE_KEY_REUQIRE_STORAGE_PERMISSION, false)) {
            if (QZonePermission.requestStoragePermission(this, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.share.QZoneShareActivity.2
                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                public void onAllGranted() {
                    super.onAllGranted();
                    QZoneShareActivity.this.updateImageView();
                }
            }, QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
                updateImageView();
            }
        } else {
            updateImageView();
        }
        return false;
    }

    protected boolean hideKeyboard(boolean z16) {
        EditText editText;
        InputMethodManager inputMethodManager = this.imm;
        if (inputMethodManager == null || (editText = this.mViewEdit) == null || !inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0)) {
            return false;
        }
        if (z16) {
            this.mViewEdit.clearFocus();
        }
        this.isKeyboardHidden = true;
        return true;
    }

    protected void hideKeyboardAndEmo(boolean z16) {
        if (this.mViewEdit == null) {
            return;
        }
        hideKeyboard(z16);
        hideEmoView();
    }

    public static String getStringFromEditText(EditText editText) {
        if (editText == null) {
            return "";
        }
        Editable text = editText.getText();
        if (text instanceof QQTextBuilder) {
            return ((QQTextBuilder) text).toPlainText();
        }
        return text.toString();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mShareData = (QZoneShareData) intent.getParcelableExtra("extraIntentKeyParcelable");
        this.isSharedFromMiniProgram = intent.getBooleanExtra(KEY_IS_SHARED_FROM_MINI_PROGRAM, false);
        this.isSharedFromAskAnonymously = intent.getBooleanExtra(KEY_IS_SHARED_FROM_ASK_ANONYMOUSLY, false);
        String stringExtra = intent.getStringExtra("qzone_uin");
        this.mOwnUin = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.mOwnUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
        if (this.isSharedFromAskAnonymously) {
            this.askAnonymouslyShareType = intent.getIntExtra(KEY_ASK_ANONYMOUSLY_SHARE_TYPE, 0);
        }
        if (this.isSharedFromMiniProgram) {
            showProgressDialog(R.string.hjn);
            boolean booleanExtra = intent.getBooleanExtra(KEY_IS_SHARED_FROM_THIRD_PARTY, false);
            final String stringExtra2 = intent.getStringExtra(KEY_MINI_SHARE_PARAM_APP_ID);
            final String stringExtra3 = intent.getStringExtra(KEY_MINI_SHARE_PARAM_TITLE);
            final String stringExtra4 = intent.getStringExtra(KEY_MINI_SHARE_PARAM_DESCRIPTION);
            final int intExtra = intent.getIntExtra(KEY_MINI_SHARE_PARAM_SHARE_SCENE, 1);
            final int intExtra2 = intent.getIntExtra(KEY_MINI_SHARE_PARAM_TEMPLATE_TYPE, 1);
            final int intExtra3 = intent.getIntExtra(KEY_MINI_SHARE_PARAM_BUSINESS_TYPE, 0);
            final String stringExtra5 = intent.getStringExtra(KEY_MINI_SHARE_PARAM_PIC_URL);
            final String stringExtra6 = intent.getStringExtra(KEY_MINI_SHARE_PARAM_JUMP_URL);
            String stringExtra7 = intent.getStringExtra(KEY_MINI_SHARE_PARAM_ICON_URL);
            final int intExtra4 = intent.getIntExtra(KEY_MINI_SHARE_PARAM_VERSION_TYPE, -1);
            String stringExtra8 = intent.getStringExtra(KEY_MINI_SHARE_PRRAM_VERSION_ID);
            final String stringExtra9 = intent.getStringExtra(KEY_MINI_SHARE_APP_RICH_ID);
            String stringExtra10 = intent.getStringExtra(KEY_MINI_SHARE_APP_PKG_NAME);
            String stringExtra11 = intent.getStringExtra(KEY_MINI_SHARE_APP_OPEN_ID);
            final int intExtra5 = intent.getIntExtra(KEY_MINI_SHARE_SHARE_ORIGIN, 0);
            this.isFromInnerButton = intent.getBooleanExtra(KEY_MINI_SHARE_APP_IS_FROM_INNER_BUTTON, false);
            QZoneShareData qZoneShareData = new QZoneShareData();
            this.mShareData = qZoneShareData;
            qZoneShareData.mTitle = stringExtra3;
            if (stringExtra9 != null) {
                try {
                    qZoneShareData.appid = Long.parseLong(stringExtra9);
                } catch (NumberFormatException e16) {
                    QLog.e(TAG, 1, "Long.parseLong(appRichId) get an Exception", e16);
                }
            }
            QZoneShareData qZoneShareData2 = this.mShareData;
            qZoneShareData2.openId = stringExtra11;
            qZoneShareData2.pkgname = stringExtra10;
            qZoneShareData2.mSummary = stringExtra4;
            qZoneShareData2.mImageUrls = new ArrayList<>();
            if (!StringUtil.isEmpty(stringExtra5)) {
                this.mShareData.mImageUrls.add(stringExtra5);
            } else if (!StringUtil.isEmpty(stringExtra7)) {
                this.mShareData.mImageUrls.add(stringExtra7);
            }
            if (booleanExtra) {
                this.mShareData.from = 1;
            }
            this.mShareData.xcxMapEx = new HashMap();
            this.mShareData.xcxMapEx.put(operation_forward_req.XCX_MAPEX_KEY_PATH, stringExtra6);
            this.mShareData.xcxMapEx.put(operation_forward_req.XCX_MAPEX_KEY_APPID, stringExtra2);
            this.mShareData.xcxMapEx.put(operation_forward_req.XCX_MAPEX_KEY_SOURCE_TYPE, String.valueOf(intExtra3));
            final AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            if (TextUtils.isEmpty(stringExtra7)) {
                iMiniAppService.getAppInfoById(null, stringExtra2, stringExtra6, String.valueOf(intExtra4), null, new MiniAppCmdInterface() { // from class: cooperation.qzone.share.QZoneShareActivity.5
                    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
                    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onCmdListener(boolean z16, JSONObject jSONObject) {
                        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo;
                        byte[] bArr;
                        final String str = "";
                        if (z16) {
                            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo2 = null;
                            try {
                                bArr = (byte[]) jSONObject.opt("mini_app_info_pb_data");
                                iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            try {
                                iNTERFACE$StApiAppInfo.mergeFrom(bArr);
                            } catch (Throwable th6) {
                                th = th6;
                                iNTERFACE$StApiAppInfo2 = iNTERFACE$StApiAppInfo;
                                QLog.e(QZoneShareActivity.TAG, 1, "", th);
                                iNTERFACE$StApiAppInfo = iNTERFACE$StApiAppInfo2;
                                if (iNTERFACE$StApiAppInfo == null) {
                                }
                            }
                            if (iNTERFACE$StApiAppInfo == null) {
                                String str2 = stringExtra3;
                                String str3 = stringExtra4;
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = iNTERFACE$StApiAppInfo.appName.get();
                                }
                                String str4 = str2;
                                if (TextUtils.isEmpty(stringExtra4)) {
                                    str3 = iNTERFACE$StApiAppInfo.desc.get();
                                }
                                String str5 = str3;
                                if (QZoneShareActivity.this.mShareData != null) {
                                    QZoneShareActivity.this.mShareData.mTitle = str4;
                                    QZoneShareActivity.this.mShareData.mSummary = str5;
                                    if (QZoneShareActivity.this.mShareData.mImageUrls != null && QZoneShareActivity.this.mShareData.mImageUrls.size() == 0) {
                                        QZoneShareActivity.this.mShareData.mImageUrls.add(iNTERFACE$StApiAppInfo.icon.get());
                                    }
                                }
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).shareAsQzoneFeeds(stringExtra2, str4, str5, intExtra, intExtra2, intExtra3, stringExtra5, null, stringExtra6, iNTERFACE$StApiAppInfo.icon.get(), intExtra4, iNTERFACE$StApiAppInfo.versionId.get(), stringExtra9, intExtra5, anonymousClass4);
                                return;
                            }
                            QZoneShareActivity.this.runOnUiThread(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QZoneShareActivity.this.hideProgressDialog();
                                    QQToast.makeText(QZoneShareActivity.this, 1, R.string.c_y, 1).show();
                                    QZoneShareActivity.this.finish();
                                }
                            });
                            return;
                        }
                        final long optLong = jSONObject != null ? jSONObject.optLong("retCode") : 0L;
                        if (jSONObject != null) {
                            str = jSONObject.optString("errMsg");
                        }
                        QZoneShareActivity.this.runOnUiThread(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).shareErrorToast(QZoneShareActivity.this, optLong, str);
                                QZoneShareActivity.this.hideProgressDialog();
                                QZoneShareActivity.this.finish();
                            }
                        });
                    }
                });
                return;
            } else {
                iMiniAppService.shareAsQzoneFeeds(stringExtra2, stringExtra3, stringExtra4, intExtra, intExtra2, intExtra3, stringExtra5, null, stringExtra6, stringExtra7, intExtra4, stringExtra8, stringExtra9, intExtra5, anonymousClass4);
                return;
            }
        }
        handleShareData();
    }

    protected boolean checkAppinfoLocked(AppInterface appInterface, long j3, String str) {
        int i3;
        Object obj = sAppinfoLock;
        synchronized (obj) {
            if (this.mIsGettingAppinfo) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
                }
                try {
                    showProgressDialog(R.string.b1z);
                    obj.wait(5000L);
                } catch (InterruptedException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "check app info locked ex", e16);
                    }
                }
                i3 = 2;
            } else {
                if (this.mGetAppinfoResponse == null) {
                    this.mIsGettingAppinfo = true;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String o16 = g.o(this, str, currentTimeMillis + "");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "-->sdk_share, checkAppinfoLocked, sign: " + o16 + ", appinfo is null.");
                    }
                    showProgressDialog(R.string.b1z);
                    i3 = 2;
                    Share.n(appInterface, this, appInterface.getCurrentAccountUin(), j3, o16, currentTimeMillis, this.mAppinfoObserver, str);
                    try {
                        obj.wait(5000L);
                    } catch (InterruptedException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "check app info locked ex", e17);
                        }
                    }
                }
                i3 = 2;
            }
        }
        GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = this.mGetAppinfoResponse;
        if (getAppInfoProto$GetAppinfoResponse == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, i3, "-->sdk_share, response is null and show result dialog.");
            }
            hideProgressDialog();
            return true;
        }
        int i16 = getAppInfoProto$GetAppinfoResponse.ret.get();
        if (i16 != 110507 && i16 != 110401) {
            hideProgressDialog();
            return true;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qzone.share.QZoneShareActivity.17
            @Override // java.lang.Runnable
            public void run() {
                QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                QQToast.makeText(qZoneShareActivity, qZoneShareActivity.mGetAppinfoResponse.f342197msg.get(), 0).show();
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d(TAG, i3, "-->sdk_share, response ret: " + i16 + " and show result dialog.");
        }
        hideProgressDialog();
        return false;
    }

    private void initUI() {
        setContentView(R.layout.bha);
        this.quiSecNavBar.setRightText(HardCodeUtil.qqStr(R.string.go8));
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new Function2() { // from class: cooperation.qzone.share.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$initUI$0;
                lambda$initUI$0 = QZoneShareActivity.this.lambda$initUI$0((View) obj, (BaseAction) obj2);
                return lambda$initUI$0;
            }
        });
        this.mConatainer = (RelativeLayout) findViewById(R.id.f69553j2);
        this.mViewEdit = (EditText) findViewById(R.id.f69573j4);
        this.mThumbContainer = (FrameLayout) findViewById(R.id.f69583j5);
        this.mThumbView = (URLImageView) findViewById(R.id.f69593j6);
        TextView textView = (TextView) findViewById(R.id.f69643ja);
        this.mViewForwardTitle = textView;
        textView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        TextView textView2 = (TextView) findViewById(R.id.f69623j9);
        this.mViewForwardSummary = textView2;
        textView2.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        this.mViewEdit.getRootView().setBackgroundColor(-1);
        addEmoPanel();
        this.viewAtUser = findViewById(R.id.h8m);
        setEventAtUser();
        this.viewSmiley = (ImageView) findViewById(R.id.h9g);
        setEventSmiley();
        setEventEditView();
        this.viewTextCount = (TextView) findViewById(R.id.f69633j_);
        this.imm = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.mAtUserList = new ArrayList();
    }

    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.viewEmoView.getVisibility() == 0) {
                hideEmoView();
                return true;
            }
            onBack();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    public void openIdConfirm(final QZoneShareData qZoneShareData) {
        String str;
        if (qZoneShareData == null || qZoneShareData.from != 1 || "login".equals(qZoneShareData.jFrom)) {
            return;
        }
        String str2 = qZoneShareData.shareUin;
        final String str3 = qZoneShareData.openId;
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(this.mOwnUin)) {
                return;
            }
            showOpenIdConfirmDialog(this, qZoneShareData);
        } else {
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            OpenID openID = QZoneShareManager.getOpenID(BaseApplicationImpl.getApplication().getRuntime(), String.valueOf(qZoneShareData.appid), new BusinessObserver() { // from class: cooperation.qzone.share.QZoneShareActivity.15
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(int i3, boolean z16, Object obj) {
                    String str4;
                    if (i3 != 1 || !(obj instanceof OpenID) || (str4 = ((OpenID) obj).openID) == null || str4.equals(str3)) {
                        return;
                    }
                    QZoneShareActivity qZoneShareActivity = QZoneShareActivity.this;
                    qZoneShareActivity.showOpenIdConfirmDialog(qZoneShareActivity, qZoneShareData);
                }
            });
            if (openID == null || (str = openID.openID) == null || str.equals(str3)) {
                return;
            }
            showOpenIdConfirmDialog(this, qZoneShareData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSdkCallback(Activity activity, QZoneShareData qZoneShareData, boolean z16) {
        if (activity == null || qZoneShareData == null) {
            return;
        }
        if (TextUtils.isEmpty(qZoneShareData.action)) {
            qZoneShareData.action = "shareToQzone";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sdk_share:sdk callback=" + z16 + " appid=" + qZoneShareData.appid + " action=" + qZoneShareData.action);
        }
        Intent intent = new Intent();
        if (z16) {
            intent.setData(Uri.parse(String.format(SDK_SHARE_CALLBACK_COMPLETE, Long.valueOf(qZoneShareData.appid), qZoneShareData.action)));
        } else {
            intent.setData(Uri.parse(String.format(SDK_SHARE_CALLBACK_CANCEL, Long.valueOf(qZoneShareData.appid), qZoneShareData.action)));
        }
        intent.setPackage(qZoneShareData.pkgname);
        QZoneHelper.addSource(intent);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e16) {
            QLog.e(TAG, 1, e16.getStackTrace());
        }
    }
}
