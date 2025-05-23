package com.tencent.mobileqq.nearby.now.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.IModelUtil;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.h;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ShortVideoCommentsView extends LinearLayout implements com.tencent.mobileqq.nearby.now.view.b, View.OnLayoutChangeListener, IShortVideoCommentsView {
    private static final int COMMENT_DELETE = 5;
    public static final int COMMENT_DELETE_ADMIN = 2;
    public static final int COMMENT_DELETE_ANCHOR = 4;
    public static final int COMMENT_DELETE_RECORDER = 3;
    public static final int COMMENT_DELETE_SELF = 1;
    private static int COMMENT_ITEM_HEIGHT = 0;
    private static final int COMMENT_TOP_OR_DELETE = 3;
    private static final int COMMENT_UNTOP_OR_DELETE = 4;
    private static final int JOIN_FANS_REQUEST_CODE = 301;
    private static final int MAX_INPUT_LENGTH = 140;
    private static final int OPEN_NOBEL_REQUEST_CODE = 300;
    private static final int REQUEST_FOR_BIND_PHONE = 302;
    private static final String TAG = "ShortVideoComments";
    public QQAppInterface app;
    private BottomAreaRunnable bottomAreaRunnable;
    private TextView btnPermissionDeniedJump;
    private TextView btnSend;
    private TextView commentCountTextView;
    private View commentCountView;
    private boolean commentVisibleReport;
    private View coverView;
    private View dividerView;
    private boolean downScrollReport;
    private EditText etInput;
    private FocusInputRunnable focusInputRunnable;
    private boolean hasPermission;
    private LinearLayout headerContainer;
    private boolean isEnd;
    private boolean isKeyboardShow;
    private boolean isLoading;
    private int lastScrollY;
    private Map<Integer, Integer> listViewItemHeights;
    private LinearLayout llInut;
    private ListView lvComments;
    private com.tencent.mobileqq.nearby.now.view.a mAdapter;
    public Comments mComments;
    public ImageView mEmptyCloseBtn;
    private FrameLayout mFooterView;
    private View mHeadInfoMask;
    private View mHeadOperater;
    private String mHintText;
    private HorizontalBallLoadingView mHorizontalBallLoadingView;
    private IModelUtil.a mIMediaInfoListener;
    private boolean mIsDestroy;
    private int mKeyboardHeight;
    private TextView mLocationText;
    private MedalInfo mMedalInfo;
    private int mNameMaxWidth;
    private boolean mOpenMedalPage;
    private IPlayOperationViewModel mPlayOperationViewModel;
    private s92.a mPresenter;
    private Comments.Comment mReplyObject;
    private View mRootView;
    private long mSelfUin;
    private Paint mTextPaint;
    private VideoData mVideoData;
    private boolean needToOpenKeyboard;
    private String noPermissionJumpUrl;
    public View playerView;
    private TextView recoderEndTextView;
    private TextView recoderFromTextView;
    private View recoderInfoView;
    private TextView recoderNameTextView;
    private TextView recoderTimeTextView;
    private TextView recoderTitleTextView;
    private TopicLabelListView recoderTopicLabelListView;
    private View recorderTopDivider;
    private RelativeLayout rlInputBlock;
    private RelativeLayout rlNoPermission;
    private boolean scrollToTop;
    private TextView tvPermissionDeniedReason;
    private boolean userInput;
    private h.b videoViewHolder;
    private boolean waitForScrollToTop;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class BottomAreaRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f252800d;

        BottomAreaRunnable(int i3) {
            this.f252800d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = this.f252800d;
            if (i3 == 0) {
                ShortVideoCommentsView.this.rlNoPermission.setVisibility(8);
                ShortVideoCommentsView.this.rlInputBlock.setVisibility(0);
            } else {
                if (i3 != 1) {
                    ShortVideoCommentsView.this.rlInputBlock.setVisibility(8);
                    ShortVideoCommentsView.this.rlNoPermission.setVisibility(8);
                    return;
                }
                ShortVideoCommentsView.this.rlInputBlock.setVisibility(8);
                if (ShortVideoCommentsView.this.mVideoData != null && ShortVideoCommentsView.this.mVideoData.f252693d != 4) {
                    ShortVideoCommentsView.this.rlNoPermission.setVisibility(0);
                }
                ShortVideoCommentsView.this.ensureBottomAreaLineCorrent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class FocusInputRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f252801d;

        FocusInputRunnable(long j3) {
            this.f252801d = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - this.f252801d > 1000) {
                return;
            }
            ShortVideoCommentsView.this.etInput.setFocusable(true);
            ShortVideoCommentsView.this.etInput.setFocusableInTouchMode(true);
            ShortVideoCommentsView.this.etInput.requestFocus();
            ThreadManager.getUIHandler().postDelayed(this, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            ShortVideoCommentsView.this.mReplyObject = (Comments.Comment) adapterView.getAdapter().getItem(i3);
            if (ShortVideoCommentsView.this.mReplyObject == null) {
                return;
            }
            if (ShortVideoCommentsView.this.mReplyObject.f252672m == ShortVideoCommentsView.this.app.getLongAccountUin()) {
                ShortVideoCommentsView.this.showToast(HardCodeUtil.qqStr(R.string.f172708ti0));
                ShortVideoCommentsView.this.mReplyObject = null;
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u56de\u590d ");
            if (ShortVideoCommentsView.this.mReplyObject.f252671i.length() >= 6) {
                sb5.append(ShortVideoCommentsView.this.mReplyObject.f252671i.substring(0, 5));
                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            } else {
                sb5.append(ShortVideoCommentsView.this.mReplyObject.f252671i);
            }
            ShortVideoCommentsView.this.etInput.setText("");
            ShortVideoCommentsView.this.etInput.setHint(sb5);
            if (!ShortVideoCommentsView.this.hasPermission) {
                ShortVideoCommentsView.this.postBottomAreaRunnable(1);
            } else {
                ShortVideoCommentsView.this.showComment();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        b() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Comments.Comment comment = (Comments.Comment) adapterView.getAdapter().getItem(i3);
            if (comment == null) {
                return true;
            }
            long parseLong = Long.parseLong(ShortVideoCommentsView.this.app.getCurrentAccountUin());
            if (comment.f252672m == parseLong) {
                ShortVideoCommentsView.this.showDelSheet(comment);
                return true;
            }
            if (ShortVideoCommentsView.this.mVideoData.Q == parseLong) {
                ShortVideoCommentsView.this.showDelAndReportSheet(comment);
                return false;
            }
            ShortVideoCommentsView.this.showReportSheet(comment);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((Activity) ShortVideoCommentsView.this.getContext()).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                ShortVideoCommentsView.this.recoderNameTextView.setTextColor(-16777216);
                return false;
            }
            ShortVideoCommentsView.this.recoderNameTextView.setTextColor(HWColorFormat.COLOR_FormatVendorStartUnused);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LocationInfo f252815d;

        h(LocationInfo locationInfo) {
            this.f252815d = locationInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Intent intent = new Intent(ShortVideoCommentsView.this.getContext(), (Class<?>) QQBrowserActivity.class);
            LocationInfo locationInfo = this.f252815d;
            String str3 = locationInfo.lng;
            String str4 = locationInfo.lat;
            String str5 = locationInfo.name;
            String format = String.format("https://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str4, str3, TextUtils.isEmpty(str5) ? this.f252815d.getCity() : str5, str5);
            intent.putExtra("url", format);
            ShortVideoCommentsView.this.getContext().startActivity(intent);
            if (QLog.isColorLevel()) {
                QLog.i(ShortVideoCommentsView.TAG, 2, "when click location label ; the url is :" + format);
            }
            com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(ShortVideoCommentsView.this.app).i("dc00899").a("grp_lbs").f("data_card").d("clk_lbs").h(String.valueOf(ShortVideoCommentsView.this.mVideoData.D));
            String[] strArr = new String[4];
            if (TextUtils.equals(String.valueOf(ShortVideoCommentsView.this.mVideoData.D), ShortVideoCommentsView.this.app.getCurrentAccountUin())) {
                str = "1";
            } else {
                str = "2";
            }
            strArr[0] = str;
            strArr[1] = "";
            strArr[2] = "";
            if (ShortVideoCommentsView.this.mVideoData != null) {
                str2 = ShortVideoCommentsView.this.mVideoData.f252695e;
            } else {
                str2 = "0";
            }
            strArr[3] = str2;
            h16.b(strArr).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class i implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f252817d;

        i(Activity activity) {
            this.f252817d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.mobileqq.nearby.l.d(this.f252817d, 302);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 2, "openBindPhonePage");
            }
            ShortVideoCommentsView shortVideoCommentsView = ShortVideoCommentsView.this;
            shortVideoCommentsView.reportBindPhoneAction(shortVideoCommentsView.app, "playpage_phone_clk");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class k implements IModelUtil.a {
        k() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShortVideoCommentsView.this.clearInput();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class m implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comments.Comment f252822d;

        m(Comments.Comment comment) {
            this.f252822d = comment;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ShortVideoCommentsView.this.onCommentsDeleteClick(this.f252822d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class o implements View.OnTouchListener {
        o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class q implements View.OnTouchListener {
        q() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShortVideoCommentsView.this.hideInputKeyboard();
            ShortVideoCommentsView.this.coverView.setVisibility(8);
            ShortVideoCommentsView.this.postBottomAreaRunnable(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class t implements View.OnTouchListener {
        t() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            boolean unused = ShortVideoCommentsView.this.isKeyboardShow;
            ShortVideoCommentsView.this.showComment();
            ShortVideoCommentsView.this.ensureInputFocused();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String obj = ShortVideoCommentsView.this.etInput.getText().toString();
            if (obj.isEmpty()) {
                ShortVideoCommentsView shortVideoCommentsView = ShortVideoCommentsView.this;
                shortVideoCommentsView.showToast(shortVideoCommentsView.getContext().getResources().getString(R.string.dxe));
                return;
            }
            if (obj.length() > 140) {
                ShortVideoCommentsView shortVideoCommentsView2 = ShortVideoCommentsView.this;
                shortVideoCommentsView2.showToast(shortVideoCommentsView2.getContext().getResources().getString(R.string.dxf));
                return;
            }
            Comments.Comment comment = new Comments.Comment();
            comment.f252672m = Long.parseLong(ShortVideoCommentsView.this.app.getCurrentAccountUin());
            comment.C = "";
            String string = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + ShortVideoCommentsView.this.app.getCurrentAccountUin(), 4).getString("nick", "");
            if (TextUtils.isEmpty(string)) {
                string = ShortVideoCommentsView.this.app.getCurrentNickname();
            }
            comment.f252671i = string;
            comment.f252668e = obj;
            comment.f252669f = System.currentTimeMillis() / 1000;
            comment.K = ShortVideoCommentsView.this.mMedalInfo;
            if (ShortVideoCommentsView.this.mReplyObject != null && (ShortVideoCommentsView.this.mReplyObject.f252672m > 0 || ShortVideoCommentsView.this.mReplyObject.E > 0)) {
                comment.H = ShortVideoCommentsView.this.mReplyObject.C;
                comment.F = ShortVideoCommentsView.this.mReplyObject.f252671i;
                comment.G = ShortVideoCommentsView.this.mReplyObject.f252672m;
                comment.J = ShortVideoCommentsView.this.mReplyObject.E;
                comment.I = ShortVideoCommentsView.this.mReplyObject.D;
            }
            ShortVideoCommentsView.this.mPresenter.g(comment);
            ShortVideoCommentsView.this.addCommentDirectly(comment);
            ReportController.o(ShortVideoCommentsView.this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_reply", 0, 0, "", "", "", "");
        }
    }

    public ShortVideoCommentsView(Context context) {
        super(context);
        this.isLoading = false;
        this.isEnd = false;
        this.isKeyboardShow = false;
        this.mIsDestroy = false;
        this.mOpenMedalPage = false;
        this.scrollToTop = false;
        this.hasPermission = false;
        this.listViewItemHeights = new HashMap();
        this.commentVisibleReport = false;
        this.lastScrollY = 0;
        this.downScrollReport = false;
        this.mHintText = "";
        this.mIMediaInfoListener = new k();
        COMMENT_ITEM_HEIGHT = (int) ba.dp2px(getContext(), 60.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureBottomAreaLineCorrent() {
        if ((this.mComments.f252665f.isEmpty() || this.mAdapter.f252863i) && this.rlNoPermission.getVisibility() == 0 && (this.tvPermissionDeniedReason.getText() == null || this.tvPermissionDeniedReason.getText().length() == 0)) {
            this.dividerView.setVisibility(8);
        } else {
            this.dividerView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureInputFocused() {
        if (this.focusInputRunnable != null) {
            ThreadManager.getUIHandler().post(this.focusInputRunnable);
        }
        this.focusInputRunnable = new FocusInputRunnable(System.currentTimeMillis());
        ThreadManager.getUIHandler().postDelayed(this.focusInputRunnable, 100L);
    }

    private int getDeleteType(Comments.Comment comment) {
        if (comment.f252672m == this.app.getLongAccountUin()) {
            return 1;
        }
        if (this.app.getLongAccountUin() == this.mVideoData.D) {
            return 4;
        }
        return this.app.getLongAccountUin() == this.mVideoData.Q ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getVerticalScroll() {
        ListView listView = this.lvComments;
        if (listView == null || listView.getChildCount() <= 0) {
            return 0;
        }
        View childAt = this.lvComments.getChildAt(0);
        int i3 = -childAt.getTop();
        this.listViewItemHeights.put(Integer.valueOf(this.lvComments.getFirstVisiblePosition()), Integer.valueOf(childAt.getHeight()));
        for (int i16 = 0; i16 < this.lvComments.getFirstVisiblePosition(); i16++) {
            if (this.listViewItemHeights.get(Integer.valueOf(i16)) != null) {
                i3 += this.listViewItemHeights.get(Integer.valueOf(i16)).intValue();
            }
        }
        return i3;
    }

    private void handleDeleteFail(Comments.Comment comment) {
        if (this.mAdapter.c(comment)) {
            showToast(getResources().getString(R.string.dxc));
        }
    }

    private void inputWidgetRegisterListener() {
        this.etInput.addTextChangedListener(new s());
        this.etInput.setOnTouchListener(new t());
        registerCommentsListViewListener();
        this.llInut.setOnClickListener(new u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCommentsDeleteClick(Comments.Comment comment) {
        this.mPresenter.d(comment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScrollToTop(boolean z16) {
        LinearLayout linearLayout;
        if (this.waitForScrollToTop) {
            return;
        }
        this.scrollToTop = z16;
        int verticalScroll = getVerticalScroll();
        if (!this.commentVisibleReport && (linearLayout = this.headerContainer) != null && linearLayout.getMeasuredHeight() > 0 && (getContext() instanceof Activity)) {
            Activity activity = (Activity) getContext();
            if (this.headerContainer.getMeasuredHeight() <= ba.getScreenHeight(getContext()) - ViewUtils.getStatusBarHeight(activity) || this.headerContainer.getMeasuredHeight() - verticalScroll <= (r1 - ViewUtils.getStatusBarHeight(activity)) - ba.dp2px(getContext(), 50.0f)) {
                this.commentVisibleReport = true;
                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_exp").LvInd1().reportByVideo(this.app);
                final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.28
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(ShortVideoCommentsView.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_com_exp").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
                        String[] strArr = new String[4];
                        String str = "";
                        strArr[0] = "";
                        strArr[1] = String.valueOf(bVar.getSelfGender());
                        strArr[2] = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom();
                        if (TextUtils.equals(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
                            str = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFeedId();
                        }
                        strArr[3] = str;
                        h16.b(strArr).g();
                    }
                }, 16, null, false);
            }
        }
        IPlayOperationViewModel iPlayOperationViewModel = this.mPlayOperationViewModel;
        if (iPlayOperationViewModel != null) {
            iPlayOperationViewModel.setTopOperationBkg(verticalScroll);
        }
    }

    private String parseTopicTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("#");
        if (indexOf == -1) {
            return str;
        }
        String[] split = str.split("#");
        if (indexOf <= 0) {
            return "";
        }
        return split[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postBottomAreaRunnable(int i3) {
        if (this.bottomAreaRunnable != null) {
            ThreadManager.getUIHandler().post(this.bottomAreaRunnable);
        }
        this.bottomAreaRunnable = new BottomAreaRunnable(i3);
        ThreadManager.getUIHandler().post(this.bottomAreaRunnable);
    }

    private void registerCommentsListViewListener() {
        this.lvComments.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i3) {
                if (i3 == 0) {
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !ShortVideoCommentsView.this.mComments.f252665f.isEmpty() && !ShortVideoCommentsView.this.isLoading && !ShortVideoCommentsView.this.isEnd) {
                        ShortVideoCommentsView.this.loadMore();
                    }
                    if (ShortVideoCommentsView.this.mVideoData != null) {
                        String str = ShortVideoCommentsView.this.mVideoData.f252695e;
                    }
                    if (ShortVideoCommentsView.this.mVideoData != null) {
                        long j3 = ShortVideoCommentsView.this.mVideoData.D;
                    }
                    int verticalScroll = ShortVideoCommentsView.this.getVerticalScroll();
                    if (verticalScroll < ShortVideoCommentsView.this.lastScrollY || verticalScroll < ba.dp2px(ShortVideoCommentsView.this.getContext(), 40.0f)) {
                        if (!ShortVideoCommentsView.this.userInput) {
                            ShortVideoCommentsView.this.hideInputKeyboard();
                            ShortVideoCommentsView.this.postBottomAreaRunnable(2);
                        }
                    } else {
                        if (!ShortVideoCommentsView.this.downScrollReport) {
                            ShortVideoCommentsView.this.downScrollReport = true;
                        }
                        ShortVideoCommentsView.this.showBottomeArea();
                    }
                    ShortVideoCommentsView.this.lastScrollY = verticalScroll;
                    if (ShortVideoCommentsView.this.lvComments == null || ShortVideoCommentsView.this.lvComments.getChildCount() <= 0 || ShortVideoCommentsView.this.lvComments.getChildAt(0).getTop() != 0 || ShortVideoCommentsView.this.userInput) {
                        return;
                    }
                    ShortVideoCommentsView.this.waitForScrollToTop = true;
                    ShortVideoCommentsView.this.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ShortVideoCommentsView.this.waitForScrollToTop = false;
                        }
                    }, 100L);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
                if (i3 != 0) {
                    ShortVideoCommentsView.this.onScrollToTop(false);
                    return;
                }
                View childAt = ShortVideoCommentsView.this.lvComments.getChildAt(0);
                if (childAt == null || childAt.getTop() != 0) {
                    ShortVideoCommentsView.this.onScrollToTop(false);
                } else {
                    ShortVideoCommentsView.this.onScrollToTop(true);
                }
            }
        });
        this.lvComments.setOnItemClickListener(new a());
        this.lvComments.setLongClickable(true);
        this.lvComments.setOnItemLongClickListener(new b());
    }

    private void removeFailedComment(Comments.Comment comment) {
        this.mComments.f252665f.remove(comment);
        this.mAdapter.notifyDataSetChanged();
        TextView textView = this.commentCountTextView;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        Comments comments = this.mComments;
        long j3 = comments.f252663d - 1;
        comments.f252663d = j3;
        sb5.append(String.valueOf(j3));
        sb5.append(")");
        textView.setText(sb5.toString());
        IPlayOperationViewModel iPlayOperationViewModel = this.mPlayOperationViewModel;
        if (iPlayOperationViewModel != null) {
            iPlayOperationViewModel.setCommentsCount(this.mComments.f252663d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteConfirmDialog(Comments.Comment comment) {
        DialogUtil.createCustomDialog(getContext(), 232, null, getResources().getString(R.string.dxb), new m(comment), new n()).show();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void addCommentInView(Comments.Comment comment) {
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_suc").LvInd1().reportByVideo(this.app);
        final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.19
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(ShortVideoCommentsView.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_com_suc").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
                String[] strArr = new String[4];
                String str = "";
                strArr[0] = "";
                strArr[1] = String.valueOf(bVar.getSelfGender());
                strArr[2] = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom();
                if (TextUtils.equals(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
                    str = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFeedId();
                }
                strArr[3] = str;
                h16.b(strArr).g();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public boolean canPlayNext() {
        return (!this.scrollToTop || this.rlInputBlock.getVisibility() == 0 || this.rlNoPermission.getVisibility() == 0 || this.mPlayOperationViewModel.isDialogShow() || this.mPlayOperationViewModel.isJubaoDialogShow()) ? false : true;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public AppInterface getApp() {
        return this.app;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public View getPlayerView() {
        return this.playerView;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public Comments getmComments() {
        return this.mComments;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public ImageView getmEmptyCloseBtn() {
        return this.mEmptyCloseBtn;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void hideInputKeyboard() {
        if (this.etInput == null) {
            return;
        }
        if (this.isKeyboardShow && getContext() != null) {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.etInput.getWindowToken(), 0);
            this.isKeyboardShow = false;
        }
        this.userInput = false;
        this.etInput.clearFocus();
        this.coverView.setVisibility(8);
        if (this.focusInputRunnable != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.focusInputRunnable);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void hideLoading() {
        HorizontalBallLoadingView horizontalBallLoadingView;
        if (this.mPresenter.e() > 0 && (horizontalBallLoadingView = this.mHorizontalBallLoadingView) != null) {
            horizontalBallLoadingView.setVisibility(8);
        }
        this.isLoading = false;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void init(Object obj, VideoData videoData) {
        this.videoViewHolder = (h.b) obj;
        this.mVideoData = videoData;
        this.needToOpenKeyboard = false;
        onCreate();
        onCreateView();
        onActivityCreated(null, 0);
        initRecorderInfoView();
        initLocationView();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void initLocationView() {
        LocationInfo locationInfo = this.mVideoData.f252698f0;
        if (locationInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "initLocationView: lbsInfo null!");
            }
            this.mLocationText.setVisibility(8);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initLocationView:" + locationInfo.toString());
        }
        if (locationInfo.isCityEmpty() && locationInfo.isNameEmpty()) {
            return;
        }
        this.mLocationText.setVisibility(0);
        String name = locationInfo.getName();
        if (TextUtils.isEmpty(name)) {
            name = locationInfo.getCity();
        }
        this.mLocationText.setText(name);
        if (!TextUtils.isEmpty(locationInfo.getName()) && !locationInfo.name.endsWith(HardCodeUtil.qqStr(R.string.f172710ti2))) {
            if (this.mVideoData.f252693d != VideoData.f252689l0) {
                this.mLocationText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.eyw, 0, 0, 0);
                this.mLocationText.setTextColor(Color.parseColor("#576B95"));
            }
            this.mLocationText.setEnabled(true);
            this.mLocationText.setOnClickListener(new h(locationInfo));
            return;
        }
        if (this.mVideoData.f252693d != VideoData.f252689l0) {
            this.mLocationText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ezx, 0, 0, 0);
            this.mLocationText.setTextColor(Color.parseColor("#777777"));
        }
        this.mLocationText.setOnClickListener(null);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void initRecorderInfoView() {
        String str;
        VideoData videoData = this.mVideoData;
        if (videoData != null && !videoData.a()) {
            String str2 = this.mVideoData.W;
            String str3 = "";
            if (str2 != null && !str2.isEmpty()) {
                str3 = this.mVideoData.W.replace("\n", "").replace("\r", "").trim();
            }
            CharSequence a16 = eo.a(getContext(), this.mVideoData.f252704j0, parseTopicTitle(str3));
            if (TextUtils.isEmpty(a16)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "topicTitle is null or the length is 0");
                }
                this.recoderTitleTextView.setVisibility(8);
                this.recoderTopicLabelListView.setVisibility(8);
                this.recorderTopDivider.setVisibility(8);
            } else {
                this.recoderTopicLabelListView.setVisibility(8);
                this.recoderTitleTextView.setVisibility(0);
                if (a16 instanceof SpannableString) {
                    this.recoderTitleTextView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.recoderTitleTextView.setText(a16);
            }
            VideoData videoData2 = this.mVideoData;
            long j3 = videoData2.D;
            long j16 = videoData2.Q;
            if (j3 == j16) {
                this.recoderFromTextView.setVisibility(8);
                this.recoderEndTextView.setVisibility(8);
                this.recoderNameTextView.setVisibility(8);
            } else if (videoData2.Y == j16 && videoData2.f252692c0 != 4) {
                this.recoderFromTextView.setText(HardCodeUtil.qqStr(R.string.f172705th1));
                this.recoderEndTextView.setText(HardCodeUtil.qqStr(R.string.tgu));
                this.recoderEndTextView.setVisibility(0);
                String str4 = this.mVideoData.N;
                if (str4 != null && str4.length() > 6) {
                    str4 = str4.substring(0, 6) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.recoderNameTextView.setText(str4);
            } else {
                this.recoderFromTextView.setText(HardCodeUtil.qqStr(R.string.ths));
                this.recoderEndTextView.setVisibility(8);
                String str5 = this.mVideoData.P;
                if (str5 != null && str5.length() > 6) {
                    str5 = str5.substring(0, 6) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.recoderNameTextView.setText(str5);
            }
            this.recoderNameTextView.setOnTouchListener(new g());
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - (this.mVideoData.U * 1000);
            if (serverTimeMillis < 0) {
                str = "1\u5206\u949f\u524d";
            } else if (serverTimeMillis < 3600000) {
                str = (((serverTimeMillis / 60) / 1000) + 1) + HardCodeUtil.qqStr(R.string.f172706th3);
            } else if (serverTimeMillis < 86400000) {
                str = (((serverTimeMillis / 60) / 60) / 1000) + HardCodeUtil.qqStr(R.string.tic);
            } else if (serverTimeMillis < 31536000000L) {
                str = ((((serverTimeMillis / 24) / 60) / 60) / 1000) + HardCodeUtil.qqStr(R.string.th_);
            } else {
                str = (((((serverTimeMillis / 365) / 24) / 60) / 60) / 1000) + HardCodeUtil.qqStr(R.string.tgw);
            }
            this.recoderTimeTextView.setText(str);
            this.recoderInfoView.setVisibility(0);
            return;
        }
        this.recoderInfoView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public boolean isScrollTop() {
        return this.scrollToTop;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void jump2Report(Comments.Comment comment) {
        Context context = getContext();
        if (comment.f252672m > 0 && (context instanceof BaseActivity)) {
            BaseActivity baseActivity = (BaseActivity) context;
            ProfileCardUtil.g0(baseActivity, 0L, comment.f252672m + "", null, 20006, "", new ProfileCardUtil.b().c(comment.f252668e).a());
            return;
        }
        QQToast.makeText(context, 2, HardCodeUtil.qqStr(R.string.tgm), 0).show();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void onActivityCreated(Comments comments, int i3) {
        if (this.mVideoData.f252693d != 4) {
            this.mPresenter.i();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void onCreate() {
        Comments comments = new Comments();
        this.mComments = comments;
        comments.f252665f = new ArrayList();
        this.mPresenter = new s92.a(this, this.mVideoData, this.app);
        this.mSelfUin = this.app.getLongAccountUin();
        this.mNameMaxWidth = (int) (ba.getScreenWidth(getContext()) - ba.dp2px(getContext(), 85.0f));
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setTextSize(ba.dp2px(getContext(), 12.0f));
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public View onCreateView() {
        View inflate;
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.axp, (ViewGroup) this, true);
        this.mKeyboardHeight = ba.getScreenHeight(getContext()) / 3;
        this.mRootView.setOnClickListener(new l());
        this.lvComments = (ListView) this.mRootView.findViewById(R.id.ehw);
        VideoData videoData = this.mVideoData;
        if (videoData == null || videoData.f252693d == 1 || videoData.a()) {
            this.lvComments.setOnTouchListener(new o());
        }
        if (this.mVideoData == null) {
            return null;
        }
        this.mAdapter = new com.tencent.mobileqq.nearby.now.view.a(getContext(), this.mComments, this.mVideoData, this.mPresenter, this.mTextPaint, this.mNameMaxWidth);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.axo, (ViewGroup) this, false);
        this.playerView = inflate2;
        h.b bVar = this.videoViewHolder;
        bVar.f252892b = (ViewGroup) inflate2;
        bVar.f252893c = (RelativeLayout) inflate2.findViewById(R.id.fvd);
        this.videoViewHolder.f252895e = (ImageDisplayView) this.playerView.findViewById(R.id.de9);
        this.videoViewHolder.f252894d = (OperationView) this.playerView.findViewById(R.id.ffc);
        OperationView operationView = this.videoViewHolder.f252894d;
        operationView.f252793f = this.app;
        operationView.c();
        this.videoViewHolder.f252896f = (QQStoryVideoPlayerErrorView) this.playerView.findViewById(R.id.fg9);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.videoViewHolder.f252896f.getLayoutParams();
        layoutParams.height = ba.getScreenHeight(this.videoViewHolder.f252896f.getContext());
        layoutParams.width = ba.getScreenWidth(this.videoViewHolder.f252896f.getContext());
        this.videoViewHolder.f252896f.setLayoutParams(layoutParams);
        this.videoViewHolder.f252896f.requestLayout();
        this.videoViewHolder.f252896f.setOnClickListener(new p());
        VideoData videoData2 = this.mVideoData;
        if (videoData2 != null) {
            int i3 = videoData2.f252692c0;
            if (i3 == VideoData.f252689l0) {
                this.videoViewHolder.f252893c.setVisibility(8);
                this.videoViewHolder.f252895e.setVisibility(8);
            } else if (i3 == 4) {
                this.videoViewHolder.f252895e.setVisibility(0);
                this.videoViewHolder.f252893c.setVisibility(8);
            } else {
                this.videoViewHolder.f252893c.setVisibility(0);
                this.videoViewHolder.f252895e.setVisibility(8);
            }
            this.videoViewHolder.f252896f.setVisibility(8);
            this.mPlayOperationViewModel = this.videoViewHolder.f252894d.b();
        }
        View inflate3 = LayoutInflater.from(getContext()).inflate(R.layout.axq, (ViewGroup) this, false);
        this.recoderInfoView = inflate3;
        this.recorderTopDivider = inflate3.findViewById(R.id.i4c);
        this.recoderTitleTextView = (TextView) this.recoderInfoView.findViewById(R.id.kbs);
        this.recoderTopicLabelListView = (TopicLabelListView) this.recoderInfoView.findViewById(R.id.kby);
        this.recoderTimeTextView = (TextView) this.recoderInfoView.findViewById(R.id.kbp);
        this.recoderFromTextView = (TextView) this.recoderInfoView.findViewById(R.id.k8_);
        this.recoderNameTextView = (TextView) this.recoderInfoView.findViewById(R.id.tv_name);
        this.recoderEndTextView = (TextView) this.recoderInfoView.findViewById(R.id.k7r);
        int i16 = this.mVideoData.f252692c0;
        int i17 = VideoData.f252689l0;
        if (i16 == i17) {
            this.mLocationText = (TextView) this.recoderInfoView.findViewById(R.id.k77);
        } else {
            this.mLocationText = (TextView) this.recoderInfoView.findViewById(R.id.k76);
        }
        this.recoderInfoView.setVisibility(0);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.headerContainer = linearLayout;
        linearLayout.setBackgroundColor(Color.parseColor("#00000000"));
        float screenHeight = ba.getScreenHeight(this.videoViewHolder.f252895e.getContext()) - ViewUtils.getStatusBarHeight((Activity) this.videoViewHolder.f252895e.getContext());
        float screenWidth = ba.getScreenWidth(this.videoViewHolder.f252895e.getContext());
        if (this.mVideoData.f252693d == 4) {
            this.headerContainer.setBackgroundColor(Color.parseColor("#000000"));
            AbsListView.LayoutParams layoutParams2 = new AbsListView.LayoutParams(-1, -1);
            layoutParams2.width = (int) screenWidth;
            layoutParams2.height = (int) screenHeight;
            this.headerContainer.setLayoutParams(layoutParams2);
            this.headerContainer.requestLayout();
        }
        this.recoderInfoView.setBackgroundColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.commentCountView.setBackgroundColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.headerContainer.setOrientation(1);
        int i18 = this.mVideoData.f252693d;
        if (i18 != 1) {
            if (i18 == i17) {
                inflate = LayoutInflater.from(getContext()).inflate(R.layout.axl, (ViewGroup) this.headerContainer, true);
            } else {
                inflate = LayoutInflater.from(getContext()).inflate(R.layout.axl, (ViewGroup) this.mRootView.findViewById(R.id.ell), true);
            }
            this.mPlayOperationViewModel.setHeadBinding(inflate);
            this.videoViewHolder.f252897g = inflate;
            if (this.mVideoData.f252693d == i17) {
                this.mPlayOperationViewModel.setHeadInfoMaskWhiteMode();
                this.recoderInfoView.findViewById(R.id.i4a).setVisibility(8);
            }
        }
        if (this.mVideoData.f252693d == i17) {
            this.headerContainer.addView(this.recoderInfoView);
            this.headerContainer.addView(this.playerView, (int) screenWidth, -2);
            this.headerContainer.addView(this.commentCountView);
            this.commentCountView.findViewById(R.id.jta).setVisibility(0);
        } else {
            this.headerContainer.addView(this.playerView, (int) screenWidth, -2);
            this.headerContainer.addView(this.recoderInfoView);
            this.headerContainer.addView(this.commentCountView);
        }
        this.lvComments.addHeaderView(this.headerContainer);
        this.lvComments.setAdapter((ListAdapter) this.mAdapter);
        if (this.mVideoData.f252693d == 4) {
            showEmptyCloseBtn();
            this.lvComments.setOnTouchListener(new q());
        } else {
            IStoryRelayoutUtil iStoryRelayoutUtil = (IStoryRelayoutUtil) QRoute.api(IStoryRelayoutUtil.class);
            h.b bVar2 = this.videoViewHolder;
            VideoData videoData3 = this.mVideoData;
            iStoryRelayoutUtil.dynamicChangeStoryContainerView(bVar2, videoData3.f252696e0, videoData3.f252694d0);
            this.mFooterView = null;
            this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
            this.mHorizontalBallLoadingView = null;
            this.lvComments.addFooterView(this.mFooterView);
        }
        if (this.mVideoData.a()) {
            this.recoderInfoView.setVisibility(8);
            this.commentCountView.setVisibility(8);
        }
        View findViewById = this.mRootView.findViewById(R.id.kw9);
        this.coverView = findViewById;
        findViewById.setOnClickListener(new r());
        this.btnSend = (TextView) this.mRootView.findViewById(R.id.ajy);
        this.llInut = (LinearLayout) this.mRootView.findViewById(R.id.ee6);
        this.etInput = (EditText) this.mRootView.findViewById(R.id.byp);
        inputWidgetRegisterListener();
        this.rlNoPermission = (RelativeLayout) this.mRootView.findViewById(R.id.f166802id0);
        this.tvPermissionDeniedReason = (TextView) this.mRootView.findViewById(R.id.e1t);
        this.btnPermissionDeniedJump = (TextView) this.mRootView.findViewById(R.id.ain);
        this.rlInputBlock = (RelativeLayout) this.mRootView.findViewById(R.id.ibt);
        hideInputKeyboard();
        this.dividerView = this.mRootView.findViewById(R.id.kw_);
        ((INearbyReportHelper) QRoute.api(INearbyReportHelper.class)).reportTrendDetailExp(this.app, String.valueOf(this.mVideoData.D));
        return this.mRootView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hideInputKeyboard();
        this.mPresenter.h();
        this.mIsDestroy = true;
        com.tencent.mobileqq.nearby.now.view.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.e(true);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i28 != 0 && i18 != 0) {
            int i29 = i28 - i18;
            int i36 = this.mKeyboardHeight;
            if (i29 > i36) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.29
                    @Override // java.lang.Runnable
                    public void run() {
                        ShortVideoCommentsView.this.isKeyboardShow = true;
                        ShortVideoCommentsView.this.etInput.requestFocus();
                        ShortVideoCommentsView.this.coverView.setVisibility(0);
                    }
                });
            } else if (i18 - i28 > i36) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.30
                    @Override // java.lang.Runnable
                    public void run() {
                        ShortVideoCommentsView.this.isKeyboardShow = false;
                        ShortVideoCommentsView.this.clearInput();
                        ShortVideoCommentsView.this.coverView.setVisibility(8);
                        ShortVideoCommentsView.this.postBottomAreaRunnable(2);
                    }
                });
            }
        }
        if (this.lastScrollY == 0) {
            this.lastScrollY = getVerticalScroll();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void onPause() {
        hideInputKeyboard();
        this.mRootView.removeOnLayoutChangeListener(this);
    }

    public void onPermissionDenied(int i3, long j3, String str, String str2, String str3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "onPermissionDenied() called with: code = [" + i3 + "], uin = [" + j3 + "], text = [" + str + "], btnText = [" + str2 + "], bindPhoneUrl = [" + str3 + "], noCredit = [" + i16 + "]");
        }
    }

    public void onPermissionGranted(String str, String str2) {
        TextView textView;
        EditText editText;
        if (this.rlNoPermission.getVisibility() == 0 || this.rlInputBlock.getVisibility() == 0) {
            postBottomAreaRunnable(0);
        }
        this.hasPermission = true;
        if (!TextUtils.isEmpty(str) && (editText = this.etInput) != null) {
            editText.setHint(str);
            this.mHintText = str;
        } else if (this.etInput != null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "onPermissionGranted text ie empty! etinput use defualt hint ");
            }
            String string = getContext().getResources().getString(R.string.dxa);
            this.mHintText = string;
            this.etInput.setHint(string);
        }
        if (!TextUtils.isEmpty(str2) && (textView = this.btnSend) != null) {
            textView.setText(str2);
        } else if (this.btnSend != null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "onPermissionGranted btnText ie empty! btnSend use defualt text ");
            }
            this.btnSend.setText(getContext().getResources().getString(R.string.dxi));
        }
        if (this.needToOpenKeyboard) {
            showInputKeyboard();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void onResume() {
        this.mRootView.addOnLayoutChangeListener(this);
        if (this.mVideoData.f252693d != 4) {
            onPermissionGranted("", "");
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (i3 == 0) {
            onResume();
        } else {
            onPause();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void removeCommentDirectly(Comments.Comment comment) {
        if (this.mComments.f252665f.contains(comment)) {
            this.mComments.f252665f.remove(comment);
            this.mAdapter.notifyDataSetChanged();
            this.mComments.f252663d--;
            this.commentCountTextView.setText("(" + String.valueOf(this.mComments.f252663d) + ")");
            IPlayOperationViewModel iPlayOperationViewModel = this.mPlayOperationViewModel;
            if (iPlayOperationViewModel != null) {
                iPlayOperationViewModel.setCommentsCount(this.mComments.f252663d);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void scrollToComment() {
        if (this.hasPermission) {
            this.rlNoPermission.setVisibility(8);
            this.rlInputBlock.setVisibility(0);
        } else {
            this.rlInputBlock.setVisibility(8);
            VideoData videoData = this.mVideoData;
            if (videoData != null && videoData.f252693d != 4) {
                this.rlNoPermission.setVisibility(0);
            }
            ensureBottomAreaLineCorrent();
        }
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.25
            @Override // java.lang.Runnable
            public void run() {
                if ((ShortVideoCommentsView.COMMENT_ITEM_HEIGHT * ShortVideoCommentsView.this.mComments.f252665f.size()) + ShortVideoCommentsView.this.commentCountView.getMeasuredHeight() >= ba.getScreenHeight(ShortVideoCommentsView.this.getContext())) {
                    ShortVideoCommentsView.this.lvComments.setSelectionFromTop(1, ShortVideoCommentsView.COMMENT_ITEM_HEIGHT + ShortVideoCommentsView.this.commentCountView.getMeasuredHeight());
                } else {
                    ShortVideoCommentsView.this.lvComments.setSelection(ShortVideoCommentsView.this.mComments.f252665f.size() + 1);
                }
            }
        }, 100L);
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.26
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoCommentsView shortVideoCommentsView = ShortVideoCommentsView.this;
                shortVideoCommentsView.lastScrollY = shortVideoCommentsView.getVerticalScroll();
            }
        }, 200L);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void scrollToTop() {
        hideInputKeyboard();
        this.coverView.setVisibility(8);
        this.rlInputBlock.setVisibility(8);
        this.rlNoPermission.setVisibility(8);
        this.lvComments.setSelection(0);
        this.lastScrollY = 0;
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.22
            @Override // java.lang.Runnable
            public void run() {
                if (ShortVideoCommentsView.this.lvComments == null || ShortVideoCommentsView.this.lvComments.getChildCount() <= 0) {
                    return;
                }
                if (ShortVideoCommentsView.this.lvComments.getChildAt(0).getTop() != 0) {
                    ShortVideoCommentsView.this.lvComments.setSelection(0);
                    ThreadManager.getUIHandler().postDelayed(this, 10L);
                } else {
                    ThreadManager.getUIHandler().removeCallbacks(this);
                }
            }
        }, 10L);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void setApp(AppInterface appInterface) {
        this.app = (QQAppInterface) appInterface;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void setPlayerView(View view) {
        this.playerView = view;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void setVideoData(VideoData videoData) {
        this.mVideoData = videoData;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void setmComments(Comments comments) {
        this.mComments = comments;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void setmEmptyCloseBtn(ImageView imageView) {
        this.mEmptyCloseBtn = imageView;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void showBadNetworkConnection() {
        this.mAdapter.f252863i = true;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void showBindPhone(String str) {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 2, "shortVideoComments showBindPhone, tip=" + str + ", activity=" + baseActivity);
        }
        if (TextUtils.isEmpty(str) || baseActivity == null) {
            return;
        }
        DialogUtil.createNoTitleDialog(baseActivity, str, R.string.cancel, R.string.fm7, new i(baseActivity), new j()).show();
        reportBindPhoneAction(this.app, "playpage_phone_exp");
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void showBottomeArea() {
        if (this.hasPermission) {
            postBottomAreaRunnable(0);
        } else {
            postBottomAreaRunnable(1);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void showComment() {
        if (this.hasPermission) {
            this.userInput = true;
            this.rlNoPermission.setVisibility(8);
            this.rlInputBlock.setVisibility(0);
            showInputKeyboard();
            ensureInputFocused();
            return;
        }
        this.rlInputBlock.setVisibility(8);
        this.rlNoPermission.setVisibility(0);
        ensureBottomAreaLineCorrent();
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.23
            @Override // java.lang.Runnable
            public void run() {
                if ((ShortVideoCommentsView.COMMENT_ITEM_HEIGHT * ShortVideoCommentsView.this.mComments.f252665f.size()) + ShortVideoCommentsView.this.commentCountView.getMeasuredHeight() >= ba.getScreenHeight(ShortVideoCommentsView.this.getContext())) {
                    ShortVideoCommentsView.this.lvComments.setSelectionFromTop(1, ShortVideoCommentsView.COMMENT_ITEM_HEIGHT + ShortVideoCommentsView.this.commentCountView.getMeasuredHeight());
                } else {
                    ShortVideoCommentsView.this.lvComments.setSelection(ShortVideoCommentsView.this.mComments.f252665f.size() + 1);
                }
            }
        }, 100L);
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.24
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoCommentsView shortVideoCommentsView = ShortVideoCommentsView.this;
                shortVideoCommentsView.lastScrollY = shortVideoCommentsView.getVerticalScroll();
            }
        }, 200L);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void showDataInView(Comments comments) {
        this.mAdapter.f252863i = false;
        long j3 = comments.f252663d;
        if (j3 != 0 || !comments.f252664e) {
            this.mComments.f252663d = j3;
        }
        this.mComments.f252664e = comments.f252664e;
        List<Comments.Comment> list = comments.f252665f;
        if (list != null && list.size() > 0) {
            this.mComments.f252665f.addAll(comments.f252665f);
            this.mAdapter.notifyDataSetChanged();
        }
        this.isEnd = comments.f252664e;
        this.isLoading = false;
        this.commentCountTextView.setText("(" + String.valueOf(this.mComments.f252663d) + ")");
        IPlayOperationViewModel iPlayOperationViewModel = this.mPlayOperationViewModel;
        if (iPlayOperationViewModel != null) {
            iPlayOperationViewModel.setCommentsCount(this.mComments.f252663d);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void showDelAndReportSheet(Comments.Comment comment) {
        ActionSheet create = ActionSheet.create(getContext());
        create.addButton(HardCodeUtil.qqStr(R.string.th8), 1);
        create.addButton(HardCodeUtil.qqStr(R.string.tha), 1);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new e(comment, create));
        create.show();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void showDelSheet(Comments.Comment comment) {
        ActionSheet create = ActionSheet.create(getContext());
        create.addButton(HardCodeUtil.qqStr(R.string.thk), 1);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new c(comment, create));
        create.show();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void showEmptyCloseBtn() {
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.bw_);
        this.mEmptyCloseBtn = imageView;
        imageView.setOnClickListener(new f());
        this.mEmptyCloseBtn.setVisibility(0);
    }

    public void showInputKeyboard() {
        EditText editText = this.etInput;
        if (editText == null) {
            return;
        }
        editText.requestFocus();
        if (!this.isKeyboardShow && getContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            this.etInput.getWindowToken();
            inputMethodManager.showSoftInput(this.etInput, 0);
            this.isKeyboardShow = true;
        }
        this.coverView.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void showLoading() {
        HorizontalBallLoadingView horizontalBallLoadingView;
        if (this.mPresenter.e() <= 0 || (horizontalBallLoadingView = this.mHorizontalBallLoadingView) == null) {
            return;
        }
        horizontalBallLoadingView.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void showReportSheet(Comments.Comment comment) {
        ActionSheet create = ActionSheet.create(getContext());
        create.addButton(HardCodeUtil.qqStr(R.string.tho), 1);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new d(comment, create));
        create.show();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void showToast(String str) {
        if (getContext() != null) {
            QQToast.makeText(getContext(), 0, str, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class n implements DialogInterface.OnClickListener {
        n() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCommentDirectly(Comments.Comment comment) {
        int i3 = 0;
        while (true) {
            if (i3 >= this.mComments.f252665f.size()) {
                break;
            }
            if (this.mComments.f252665f.get(i3).f252670h != 2) {
                this.mComments.f252665f.add(i3, comment);
                break;
            }
            i3++;
        }
        if (!this.mComments.f252665f.contains(comment)) {
            this.mComments.f252665f.add(comment);
        }
        this.mAdapter.notifyDataSetChanged();
        TextView textView = this.commentCountTextView;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        Comments comments = this.mComments;
        long j3 = comments.f252663d + 1;
        comments.f252663d = j3;
        sb5.append(String.valueOf(j3));
        sb5.append(")");
        textView.setText(sb5.toString());
        IPlayOperationViewModel iPlayOperationViewModel = this.mPlayOperationViewModel;
        if (iPlayOperationViewModel != null) {
            iPlayOperationViewModel.setCommentsCount(this.mComments.f252663d);
        }
        clearInput();
        if (getContext() instanceof Activity) {
            ba.getScreenHeight(getContext());
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.18
                @Override // java.lang.Runnable
                public void run() {
                    ShortVideoCommentsView.this.scrollToComment();
                    ShortVideoCommentsView shortVideoCommentsView = ShortVideoCommentsView.this;
                    shortVideoCommentsView.lastScrollY = shortVideoCommentsView.getVerticalScroll();
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInput() {
        this.mReplyObject = null;
        this.etInput.setText("");
        this.etInput.clearFocus();
        if (!TextUtils.isEmpty(this.mHintText)) {
            this.etInput.setHint(this.mHintText);
        } else {
            this.etInput.setHint(getContext().getResources().getString(R.string.dxa));
        }
        hideInputKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMore() {
        this.isLoading = true;
        this.mPresenter.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comments.Comment f252804d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f252805e;

        c(Comments.Comment comment, ActionSheet actionSheet) {
            this.f252804d = comment;
            this.f252805e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                ShortVideoCommentsView.this.showDeleteConfirmDialog(this.f252804d);
            }
            ActionSheet actionSheet = this.f252805e;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comments.Comment f252807d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f252808e;

        d(Comments.Comment comment, ActionSheet actionSheet) {
            this.f252807d = comment;
            this.f252808e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                ShortVideoCommentsView.this.jump2Report(this.f252807d);
            }
            ActionSheet actionSheet = this.f252808e;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b7  */
    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportBindPhoneAction(AppInterface appInterface, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = "";
        try {
            if (this.mVideoData == null) {
                str2 = "";
                str3 = str2;
                str4 = str3;
            } else {
                String str6 = this.mVideoData.M + "";
                try {
                    String str7 = this.mVideoData.L + "";
                    try {
                        String str8 = this.mVideoData.D + "";
                        try {
                            str5 = str8;
                            str4 = str7;
                            str3 = str6;
                            str2 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + appInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
                        } catch (Exception e16) {
                            e = e16;
                            str2 = "";
                            str5 = str8;
                            str4 = str7;
                            str3 = str6;
                            if (QLog.isColorLevel()) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str4 = str7;
                        str3 = str6;
                        str2 = "";
                    }
                } catch (Exception e18) {
                    e = e18;
                    str4 = "";
                    str3 = str6;
                    str2 = str4;
                }
            }
            try {
                ReportController.o((QQAppInterface) appInterface, "dc00899", "grp_lbs", str5, "video", str, 0, 0, str2, str3, str4, "");
            } catch (Exception e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_NEARBY_BIND_PHONE, 2, "reportBindPhoneAction: exp=" + e.toString());
                }
                if (QLog.isColorLevel()) {
                }
            }
        } catch (Exception e26) {
            e = e26;
            str2 = "";
            str3 = str2;
            str4 = str3;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 2, "reportBindPhoneAction: action=" + str + ", toUin=" + str5 + ", gender=" + str3 + ", age=" + str4 + ", level=" + str2);
        }
    }

    public void showToast(String str, int i3) {
        if (getContext() != null) {
            QQToast.makeText(getContext(), i3, str, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comments.Comment f252810d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f252811e;

        e(Comments.Comment comment, ActionSheet actionSheet) {
            this.f252810d = comment;
            this.f252811e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                ShortVideoCommentsView.this.jump2Report(this.f252810d);
            } else if (i3 == 1) {
                ShortVideoCommentsView.this.showDeleteConfirmDialog(this.f252810d);
            }
            ActionSheet actionSheet = this.f252811e;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.b
    public void publishCommentFailed(Comments.Comment comment, int i3, String str) {
        if (comment != null) {
            if (i3 == 10003) {
                showToast(getContext().getResources().getString(R.string.dxh));
            } else if (i3 == 10009) {
                showBindPhone(str);
            } else {
                showToast(getContext().getResources().getString(R.string.dxj));
            }
            this.etInput.requestFocus();
            removeFailedComment(comment);
            ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_fail").LvInd1().reportByVideo(this.app);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 != 300 && i3 != 301) {
            if (i3 == 302 && QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 2, "shortVideoComments onActivityResult, requestCode=" + i3 + ", resultCode=" + i16);
                return;
            }
            return;
        }
        onPermissionGranted("", "");
    }

    protected void updateUIForTextFeeds() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    private void deleteReport(int i3) {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView
    public void addLoadingErrorView(Object obj) {
    }

    private void deleteReportResult(int i3, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class s implements TextWatcher {
        s() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (ShortVideoCommentsView.this.etInput != null && q92.a.g(editable.toString()) > 140) {
                int selectionEnd = Selection.getSelectionEnd(editable);
                ShortVideoCommentsView.this.etInput.setText(q92.a.a(editable.toString(), 0, 140).toString());
                Editable text = ShortVideoCommentsView.this.etInput.getText();
                if (selectionEnd > text.length()) {
                    selectionEnd = text.length();
                }
                Selection.setSelection(text, selectionEnd);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
