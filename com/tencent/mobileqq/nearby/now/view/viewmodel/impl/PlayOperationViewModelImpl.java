package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.av.utils.ba;
import com.tencent.biz.webviewplugin.ad;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.NowSmallVideoHandler;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;
import com.tencent.mobileqq.newnearby.INearbyFollowHelper;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard$NearbyUserFollowReq;
import com.tencent.nowsummarycard.NowSummaryCard$NearbyUserFollowRsp;
import com.tencent.pb.now.ilive_feeds_like$FeedsLikeRsp;
import com.tencent.pb.now.ilive_feeds_like$FeedsUnLikeRsp;
import com.tencent.pb.now.ilive_new_anchor_follow_interface$FollowActionRsp;
import com.tencent.pb.now.ilive_short_video_label$GetShortVideoVideoLabelRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.RoundRelativeLayout;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xada.oidb_0xada$RspBody;

/* loaded from: classes33.dex */
public class PlayOperationViewModelImpl implements IPlayOperationViewModel {
    private static final String TAG = "PlayOperationViewModel";
    public QQAppInterface app;
    private long currentAnchorNowId;
    private int currentAnchorNowUserType;
    private String extraInfo;
    private long extraInfoUid;
    private String feedsId;
    String headUrl;
    private long headerInfoUid;
    private boolean isAggregation;
    private boolean isCanJump;
    private boolean isFollow;
    private boolean isHasVideoLabel;
    private boolean isLiked;
    private boolean isLocal;
    private boolean isMine;
    private boolean isRecord;
    private boolean isShowFollowAnim;
    String jumpUrl;
    private int likes;
    public View mBinding;
    private long mCurrentAnchorUin;
    private Dialog mDeleteConfirmDialog;
    int mFollowBackColor;
    private URLDrawable mForShare;
    private GestureDetector mGestureDetector;
    private long mLastDoubleClickTime;
    private AnimatorSet mLikeAnimationSet;
    private int mRoomid;
    private String nickName;
    private String recordTime;
    private String recordTitle;
    private String shareUrl;
    private String videoSrc;
    private int watchCount;
    public static final String text_first = HardCodeUtil.qqStr(R.string.p9h);
    public static final String text_first_1 = HardCodeUtil.qqStr(R.string.p96);
    public static final String text_end = HardCodeUtil.qqStr(R.string.p8y);
    public static final String text_end_1 = HardCodeUtil.qqStr(R.string.p97);
    public static final String text_end_2 = HardCodeUtil.qqStr(R.string.p9g);
    public static int DIALOG_NO_TITLE = 2;
    private static int COLOR_BLUE = -15550475;
    private static int COLOR_WHITE = -1;
    private int DIALOG_WITH_TITLE = 1;
    private int DIALOG_DELETE_FEED = 6;
    private int DIALOG_DELETE_FEED_CONFIRM = 7;
    private final long DOUBLE_CLICK_INTERVAL = 500;
    VideoData mVideoData = new VideoData();
    private boolean isRequstingLike = false;
    private int mVideoPageSource = -1;
    private StuffContainerView.f mCloseListener = null;
    private View.OnClickListener mOnCommentClickListener = null;
    public View mHeadBinding = null;
    public volatile boolean isDialogShow = false;
    public volatile boolean isJubaoDialogShow = false;
    private boolean isUserClickAni = true;
    private boolean isUseProgressiveMask = true;
    private int operatorMode = 0;
    private z mLiveVideoLabelInfo = new z();
    private aa mRecordVideoLabelInfo = new aa();
    private ab mTopicVideoLabelInfo = new ab();
    private int mLabelType = 0;
    private boolean isFirstTime = true;
    private boolean isClickFollow = false;
    com.tencent.mobileqq.nearby.now.c observer = new e();
    boolean isPlayingAnim = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayOperationViewModelImpl.this.onClickMore(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class aa {

        /* renamed from: a, reason: collision with root package name */
        public String f252919a;

        /* renamed from: b, reason: collision with root package name */
        public String f252920b;

        aa() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public class ab {

        /* renamed from: a, reason: collision with root package name */
        public String f252922a;

        /* renamed from: b, reason: collision with root package name */
        public String f252923b;

        /* renamed from: c, reason: collision with root package name */
        public String f252924c;

        ab() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayOperationViewModelImpl.this.onClickLabelJump(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements INowShortVideoProtoManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoData f252927a;

        c(VideoData videoData) {
            this.f252927a = videoData;
        }

        @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
        public void a(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0 && bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.i(PlayOperationViewModelImpl.TAG, 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get() + " isLiked=" + PlayOperationViewModelImpl.this.isLiked);
                    }
                    if (oidb_0xada_rspbody.busi_buf.has()) {
                        ilive_feeds_like$FeedsLikeRsp ilive_feeds_like_feedslikersp = new ilive_feeds_like$FeedsLikeRsp();
                        ilive_feeds_like_feedslikersp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                        PlayOperationViewModelImpl.this.setLiked(true);
                        PlayOperationViewModelImpl.this.setLikes(ilive_feeds_like_feedslikersp.total.get());
                        this.f252927a.C = PlayOperationViewModelImpl.this.likes;
                        this.f252927a.J = true;
                        PlayOperationViewModelImpl.this.isRequstingLike = false;
                        PlayOperationViewModelImpl.this.isRequstingLike = false;
                        ((u92.c) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).g(PlayOperationViewModelImpl.this.feedsId, ilive_feeds_like_feedslikersp.total.get());
                        if (QLog.isColorLevel()) {
                            QLog.i(PlayOperationViewModelImpl.TAG, 2, "total:   " + ilive_feeds_like_feedslikersp.total.get() + ",ret:     " + ilive_feeds_like_feedslikersp.ret.get());
                            return;
                        }
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w(PlayOperationViewModelImpl.TAG, 1, "err_msg:   " + oidb_0xada_rspbody.err_msg.get() + " isLiked=" + PlayOperationViewModelImpl.this.isLiked + "  e:" + e16);
                    return;
                }
            }
            QLog.w(PlayOperationViewModelImpl.TAG, 1, "errorCode:   " + i3 + " isLiked=" + PlayOperationViewModelImpl.this.isLiked);
            PlayOperationViewModelImpl.this.isRequstingLike = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements INowShortVideoProtoManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoData f252929a;

        d(VideoData videoData) {
            this.f252929a = videoData;
        }

        @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
        public void a(int i3, byte[] bArr, Bundle bundle) {
            if (i3 == 0 && bArr != null) {
                oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                try {
                    oidb_0xada_rspbody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        QLog.i(PlayOperationViewModelImpl.TAG, 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get() + " isLiked=" + PlayOperationViewModelImpl.this.isLiked);
                    }
                    if (oidb_0xada_rspbody.busi_buf.has()) {
                        ilive_feeds_like$FeedsUnLikeRsp ilive_feeds_like_feedsunlikersp = new ilive_feeds_like$FeedsUnLikeRsp();
                        ilive_feeds_like_feedsunlikersp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                        PlayOperationViewModelImpl.this.setLiked(false);
                        PlayOperationViewModelImpl.this.setLikes(ilive_feeds_like_feedsunlikersp.total.get());
                        this.f252929a.C = PlayOperationViewModelImpl.this.likes;
                        this.f252929a.J = false;
                        PlayOperationViewModelImpl.this.isRequstingLike = false;
                        ((u92.c) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).e(PlayOperationViewModelImpl.this.feedsId, ilive_feeds_like_feedsunlikersp.total.get());
                        if (QLog.isColorLevel()) {
                            QLog.i(PlayOperationViewModelImpl.TAG, 2, "total:   " + ilive_feeds_like_feedsunlikersp.total.get() + ",ret:     " + ilive_feeds_like_feedsunlikersp.ret.get());
                            return;
                        }
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w(PlayOperationViewModelImpl.TAG, 1, "err_msg:   " + oidb_0xada_rspbody.err_msg.get() + " isLiked=" + PlayOperationViewModelImpl.this.isLiked + "  e:" + e16);
                    return;
                }
            }
            QLog.w(PlayOperationViewModelImpl.TAG, 1, "errorCode:   " + i3 + " isLiked=" + PlayOperationViewModelImpl.this.isLiked);
            PlayOperationViewModelImpl.this.isRequstingLike = false;
        }
    }

    /* loaded from: classes33.dex */
    class e extends com.tencent.mobileqq.nearby.now.c {
        e() {
        }

        @Override // com.tencent.mobileqq.nearby.now.c
        protected void a(boolean z16, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(PlayOperationViewModelImpl.this.mCurrentAnchorUin + "")) {
                PlayOperationViewModelImpl.this.setFollow(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class f implements DialogInterface.OnDismissListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PlayOperationViewModelImpl.this.isDialogShow = false;
        }
    }

    /* loaded from: classes33.dex */
    class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PlayOperationViewModelImpl.this.reshowOperaView();
            PlayOperationViewModelImpl.this.mGestureDetector.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class i implements ActionSheet.OnDismissListener {
        i() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            PlayOperationViewModelImpl.this.isJubaoDialogShow = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class j implements View.OnTouchListener {
        j() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.b3o).setAlpha(1.0f);
                return false;
            }
            PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.b3o).setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class k implements View.OnTouchListener {
        k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.e9b).setAlpha(1.0f);
                return false;
            }
            PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.e9b).setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class l implements View.OnTouchListener {
        l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.iqz).setAlpha(1.0f);
                return false;
            }
            PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.iqz).setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class m implements View.OnTouchListener {
        m() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.ezx).setAlpha(1.0f);
                return false;
            }
            PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.ezx).setAlpha(0.5f);
            return false;
        }
    }

    /* loaded from: classes33.dex */
    class o extends AnimatorListenerAdapter {
        o() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.chc).setBackgroundDrawable(null);
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.chb).setBackgroundColor(-637534209);
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
            playOperationViewModelImpl.isPlayingAnim = true;
            playOperationViewModelImpl.mHeadBinding.findViewById(R.id.chc).setBackgroundResource(R.drawable.f161780ae3);
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.chb).setBackgroundColor(0);
        }
    }

    /* loaded from: classes33.dex */
    class p extends AnimatorListenerAdapter {
        p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.ch9).setVisibility(8);
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.ch9).setVisibility(0);
        }
    }

    /* loaded from: classes33.dex */
    class q extends GestureDetector.SimpleOnGestureListener {
        q() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class r extends AnimatorListenerAdapter {
        r() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
            playOperationViewModelImpl.isPlayingAnim = false;
            playOperationViewModelImpl.mHeadBinding.findViewById(R.id.che).setVisibility(8);
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.cgp).setTranslationY(0.0f);
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.chd).setTranslationY(0.0f);
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.chi).setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            PlayOperationViewModelImpl.this.isPlayingAnim = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
            playOperationViewModelImpl.isPlayingAnim = true;
            int i3 = playOperationViewModelImpl.mFollowBackColor;
            playOperationViewModelImpl.mHeadBinding.findViewById(R.id.chc).setBackgroundResource(R.drawable.f161780ae3);
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.chc).getBackground().setColorFilter(new LightingColorFilter(-16777216, i3));
            PlayOperationViewModelImpl.this.mHeadBinding.findViewById(R.id.chb).setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class t extends ServletObserver {
        t() {
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.i(PlayOperationViewModelImpl.TAG, 2, "errorCode = [" + i3 + "], bundle = [" + bundle + "]");
            }
            if (i3 != 0) {
                QQToast.makeText(PlayOperationViewModelImpl.this.mBinding.getContext(), 1, HardCodeUtil.qqStr(R.string.f172232ol1), 1).show();
                return;
            }
            NowSummaryCard$NearbyUserFollowRsp nowSummaryCard$NearbyUserFollowRsp = new NowSummaryCard$NearbyUserFollowRsp();
            try {
                nowSummaryCard$NearbyUserFollowRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            QLog.i(PlayOperationViewModelImpl.TAG, 1, "ret_code: " + nowSummaryCard$NearbyUserFollowRsp.ret_code.get() + ", err_msg: " + nowSummaryCard$NearbyUserFollowRsp.err_msg.get().toStringUtf8());
            int i16 = nowSummaryCard$NearbyUserFollowRsp.ret_code.get();
            String stringUtf8 = nowSummaryCard$NearbyUserFollowRsp.err_msg.get().toStringUtf8();
            if (i16 != 0) {
                if (!TextUtils.isEmpty(stringUtf8)) {
                    QQToast.makeText(PlayOperationViewModelImpl.this.mBinding.getContext(), 1, "" + stringUtf8, 1).show();
                    return;
                }
                QQToast.makeText(PlayOperationViewModelImpl.this.mBinding.getContext(), 1, HardCodeUtil.qqStr(R.string.oij), 1).show();
                return;
            }
            PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
            boolean z16 = !playOperationViewModelImpl.isFollow;
            playOperationViewModelImpl.isFollow = z16;
            playOperationViewModelImpl.notifyUIFollow(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayOperationViewModelImpl.this.onClickHeader(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayOperationViewModelImpl.this.onClickNickName(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayOperationViewModelImpl.this.onClickFollow(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayOperationViewModelImpl.this.onClickClose(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayOperationViewModelImpl.this.onClickPublishComment(view);
            INearbyReportHelper iNearbyReportHelper = (INearbyReportHelper) QRoute.api(INearbyReportHelper.class);
            PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
            iNearbyReportHelper.reportTrendDetailCommentClick(playOperationViewModelImpl.app, String.valueOf(playOperationViewModelImpl.mVideoData.D));
        }
    }

    /* loaded from: classes33.dex */
    private class z {
        z() {
        }
    }

    private void animateLike() {
        this.mLikeAnimationSet.cancel();
        this.mLikeAnimationSet.start();
    }

    private AnimatorSet createLikeAnimation(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        animatorSet2.setDuration(200L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
        animatorSet3.setDuration(350L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playSequentially(animatorSet3, animatorSet2);
        return animatorSet;
    }

    private void followNearbyUser() {
        int i3 = this.isFollow ? 2 : 1;
        NowSummaryCard$NearbyUserFollowReq nowSummaryCard$NearbyUserFollowReq = new NowSummaryCard$NearbyUserFollowReq();
        nowSummaryCard$NearbyUserFollowReq.from.set(0);
        nowSummaryCard$NearbyUserFollowReq.id_type.set(0);
        nowSummaryCard$NearbyUserFollowReq.target_id.set(this.mVideoData.E);
        nowSummaryCard$NearbyUserFollowReq.operation.set(i3);
        com.tencent.mobileqq.newnearby.servlet.b.a(new t(), nowSummaryCard$NearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
    }

    private void followNowUser() {
        INowShortVideoProtoManager init = ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.app);
        if (this.isFollow) {
            init.follow(this.mVideoData.Y, this.currentAnchorNowId, this.currentAnchorNowUserType, 11, false, new s());
        } else {
            this.isClickFollow = true;
            init.follow(this.mVideoData.Y, this.currentAnchorNowId, this.currentAnchorNowUserType, 11, true, new INowShortVideoProtoManager.a() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.32
                @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
                public void a(int i3, byte[] bArr, Bundle bundle) {
                    if (i3 != 0 || bArr == null) {
                        return;
                    }
                    oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
                    try {
                        oidb_0xada_rspbody.mergeFrom(bArr);
                        if (QLog.isColorLevel()) {
                            QLog.i(PlayOperationViewModelImpl.TAG, 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get() + "  isFollow:" + PlayOperationViewModelImpl.this.isFollow);
                        }
                        if (oidb_0xada_rspbody.busi_buf.has()) {
                            ilive_new_anchor_follow_interface$FollowActionRsp ilive_new_anchor_follow_interface_followactionrsp = new ilive_new_anchor_follow_interface$FollowActionRsp();
                            ilive_new_anchor_follow_interface_followactionrsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                            if (QLog.isColorLevel()) {
                                QLog.i(PlayOperationViewModelImpl.TAG, 2, "ret:   " + ilive_new_anchor_follow_interface_followactionrsp.ret.get() + ",msg:     " + ilive_new_anchor_follow_interface_followactionrsp.f342148msg.get() + "  isFollow:" + PlayOperationViewModelImpl.this.isFollow);
                            }
                            if (ilive_new_anchor_follow_interface_followactionrsp.ret.get() == 0) {
                                PlayOperationViewModelImpl.this.isFollow = true;
                                if (PlayOperationViewModelImpl.this.isClickFollow) {
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.32.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            PlayOperationViewModelImpl.this.showFollowSuccessAnim();
                                        }
                                    });
                                    PlayOperationViewModelImpl.this.isClickFollow = false;
                                }
                                PlayOperationViewModelImpl.this.mVideoData.I = true;
                                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_focus").genderInd1().reportByVideo(PlayOperationViewModelImpl.this.app);
                                final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.32.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_focus").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
                                PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
                                playOperationViewModelImpl.notifyUIFollow(playOperationViewModelImpl.isFollow);
                                return;
                            }
                            if (TextUtils.isEmpty(ilive_new_anchor_follow_interface_followactionrsp.f342148msg.get())) {
                                return;
                            }
                            QQToast.makeText(BaseApplication.getContext(), 1, ilive_new_anchor_follow_interface_followactionrsp.f342148msg.get(), 0).show();
                        }
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
    }

    private Pair<String, String> getShareTitleAndSummary(Map<String, Object> map) {
        String str;
        String str2;
        String str3 = "";
        if (map == null || map.isEmpty()) {
            str = "";
        } else {
            int intValue = ((Integer) map.get(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE)).intValue();
            if (intValue == 1) {
                str3 = HardCodeUtil.qqStr(R.string.p8u) + "\u300c" + map.get("anchor_nick_name") + "\u300d" + HardCodeUtil.qqStr(R.string.f172301p94);
                str = HardCodeUtil.qqStr(R.string.p8t) + "\u300c" + map.get("anchor_nick_name") + "\u300d" + HardCodeUtil.qqStr(R.string.p9i);
            } else if (intValue == 4) {
                if (!TextUtils.isEmpty((String) map.get("record_title"))) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u300c");
                    sb5.append(map.get("recorder_nick_name"));
                    sb5.append("\u300d");
                    String str4 = text_first;
                    sb5.append(str4);
                    sb5.append("\u3010");
                    sb5.append(map.get("record_title"));
                    sb5.append("\u3011");
                    String str5 = text_end;
                    sb5.append(str5);
                    str3 = sb5.toString();
                    str = "\u300c" + map.get("recorder_nick_name") + "\u300d" + str4 + "\u3010" + map.get("record_title") + "\u3011" + str5;
                } else {
                    str2 = "\u300c" + map.get("recorder_nick_name") + "\u300d" + text_end_2;
                    str3 = str2;
                    str = "";
                }
            } else if (!TextUtils.isEmpty((String) map.get("record_title"))) {
                str3 = "\u300c" + map.get("recorder_nick_name") + "\u300d" + HardCodeUtil.qqStr(R.string.f172297p90) + map.get("record_title") + HardCodeUtil.qqStr(R.string.p8v);
                str = "\u300c" + map.get("recorder_nick_name") + "\u300d" + HardCodeUtil.qqStr(R.string.p9e) + map.get("record_title") + HardCodeUtil.qqStr(R.string.p8x);
            } else {
                str2 = "\u300c" + map.get("recorder_nick_name") + "\u300d" + HardCodeUtil.qqStr(R.string.p9b);
                str3 = str2;
                str = "";
            }
        }
        return new Pair<>(str3, str);
    }

    private void initBottomSelector() {
        this.mBinding.findViewById(R.id.b3o).setOnTouchListener(new j());
        this.mBinding.findViewById(R.id.e9b).setOnTouchListener(new k());
        this.mBinding.findViewById(R.id.iqz).setOnTouchListener(new l());
        this.mBinding.findViewById(R.id.ezx).setOnTouchListener(new m());
    }

    private void initLikeAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.mLikeAnimationSet = animatorSet;
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mLikeAnimationSet.playTogether(createLikeAnimation(this.mBinding.findViewById(R.id.j3q)));
    }

    private void initListener() {
        this.mHeadBinding.findViewById(R.id.d3z).setOnClickListener(new u());
        this.mHeadBinding.findViewById(R.id.f9d).setOnClickListener(new v());
        this.mHeadBinding.findViewById(R.id.che).setOnClickListener(new w());
        this.mHeadBinding.findViewById(R.id.azb).setOnClickListener(new x());
        this.mBinding.findViewById(R.id.b3o).setOnClickListener(new y());
        this.mBinding.findViewById(R.id.e9b).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlayOperationViewModelImpl.this.onClickLike(view);
                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_like_click").genderInd1().reportByVideo(PlayOperationViewModelImpl.this.app);
                final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_like_click").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
                INearbyReportHelper iNearbyReportHelper = (INearbyReportHelper) QRoute.api(INearbyReportHelper.class);
                PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
                iNearbyReportHelper.reportTrendDetailLikeClick(playOperationViewModelImpl.app, String.valueOf(playOperationViewModelImpl.mVideoData.D));
            }
        });
        this.mBinding.findViewById(R.id.iqz).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlayOperationViewModelImpl.this.onClickShare(view);
                ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_fw_click").LvInd1().reportByVideo(PlayOperationViewModelImpl.this.app);
                final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_fw_click").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
                INearbyReportHelper iNearbyReportHelper = (INearbyReportHelper) QRoute.api(INearbyReportHelper.class);
                PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
                iNearbyReportHelper.reportTrendDetailShareClick(playOperationViewModelImpl.app, String.valueOf(playOperationViewModelImpl.mVideoData.D));
            }
        });
        this.mBinding.findViewById(R.id.ezx).setOnClickListener(new a());
        this.mBinding.findViewById(R.id.j3t).setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFollowView$0(int i3, String str, int i16) {
        View findViewById;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[doOnResume]errCode=" + i3 + ", errMsg=" + str + ", status=" + i16);
        }
        this.isFollow = i16 == 1;
        View view = this.mHeadBinding;
        if (view == null || (findViewById = view.findViewById(R.id.che)) == null) {
            return;
        }
        if (!this.isFollow && !this.isMine) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUIFollow(boolean z16) {
        ((NowSmallVideoHandler) this.app.getBusinessHandler(BusinessHandlerFactory.NOW_SMALL_VIDEO_HANDLER)).notifyUI(1000, true, new Object[]{Boolean.valueOf(z16), String.valueOf(this.mVideoData.D)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveDeleteSuccessInfo(String str) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("nearby_callback", 4);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feeds_id", str);
            sharedPreferences.edit().putString("nearby_now_delete_success_js_param", jSONObject.toString()).commit();
        } catch (JSONException unused) {
        }
    }

    private void setViewBgColor(View view, int i3) {
        Drawable background = view.getBackground();
        if (background != null) {
            background.setColorFilter(new LightingColorFilter(-16777216, i3));
            background.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFollowSuccessAnim() {
        if (this.mHeadBinding.findViewById(R.id.chi) == null) {
            return;
        }
        this.mHeadBinding.findViewById(R.id.chc).clearAnimation();
        this.mHeadBinding.findViewById(R.id.ch9).clearAnimation();
        int dp2px = (int) ba.dp2px(this.mHeadBinding.getContext(), 20.0f);
        float f16 = -dp2px;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.cgp), "translationY", 0.0f, f16);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.chd), "translationY", 0.0f, f16);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.chi), "translationY", dp2px, 0.0f);
        this.mHeadBinding.findViewById(R.id.chi).setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat3, ofFloat, ofFloat2);
        animatorSet.setDuration(500L);
        animatorSet.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.che), BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.75f, 0.5f, 0.2f, 0.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.che), BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.75f, 0.5f, 0.25f, 0.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ofFloat4, ofFloat5);
        animatorSet2.addListener(new r());
        animatorSet2.setDuration(500L);
        animatorSet2.setStartDelay(800L);
        animatorSet2.start();
    }

    private void showFollowTipsAnim() {
        if (this.mHeadBinding.findViewById(R.id.cgp) == null) {
            return;
        }
        this.isShowFollowAnim = true;
        this.isPlayingAnim = false;
        this.mHeadBinding.findViewById(R.id.che).setPivotX(ba.dp2px(this.mHeadBinding.getContext(), 55.0f) / 2.0f);
        this.mHeadBinding.findViewById(R.id.che).setPivotY(ba.dp2px(this.mHeadBinding.getContext(), 20.0f) / 2.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.che), BasicAnimation.KeyPath.SCALE_Y, 0.52f, 1.0f, 0.72f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.che), BasicAnimation.KeyPath.SCALE_X, 0.52f, 1.0f, 0.72f, 1.0f);
        ofFloat.setDuration(800L);
        ofFloat2.setDuration(800L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mHeadBinding.findViewById(R.id.ch9), "translationX", 0.0f, ba.dp2px(this.mHeadBinding.getContext(), 55.0f));
        ofFloat3.setStartDelay(1500L);
        ofFloat3.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new o());
        ofFloat3.addListener(new p());
        animatorSet.start();
        ofFloat3.start();
    }

    private void showWhiteHeadBlock() {
        ((TextView) this.mHeadBinding.findViewById(R.id.f9d)).setTextColor(Color.parseColor("#000000"));
        ((TextView) this.mHeadBinding.findViewById(R.id.c0j)).setTextColor(Color.parseColor("#bbbbbb"));
        ((TextView) this.mHeadBinding.findViewById(R.id.cgp)).setTextColor(COLOR_WHITE);
        ((TextView) this.mHeadBinding.findViewById(R.id.chd)).setTextColor(COLOR_WHITE);
        setViewBgColor(this.mHeadBinding.findViewById(R.id.chi), COLOR_WHITE);
        this.mFollowBackColor = COLOR_BLUE;
        if (!this.isPlayingAnim) {
            this.mHeadBinding.findViewById(R.id.chb).setBackgroundColor(COLOR_BLUE);
            this.mHeadBinding.findViewById(R.id.chc).setBackgroundDrawable(null);
        } else {
            setViewBgColor(this.mHeadBinding.findViewById(R.id.chc), COLOR_BLUE);
        }
        this.mHeadBinding.findViewById(R.id.d3h).setBackgroundColor(-1);
        this.mHeadBinding.findViewById(R.id.azd).setVisibility(8);
        this.mHeadBinding.findViewById(R.id.azc).setVisibility(0);
        View findViewById = this.mHeadBinding.findViewById(R.id.d3h).findViewById(R.id.aat);
        if (findViewById.getVisibility() == 8) {
            findViewById.setVisibility(0);
        }
    }

    private void updateFollowView() {
        ((INearbyFollowHelper) QRoute.api(INearbyFollowHelper.class)).followByOption(this.app, this.mBinding.getContext(), "3", String.valueOf(this.mCurrentAnchorUin), new INearbyFollowHelper.a() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.a
            @Override // com.tencent.mobileqq.newnearby.INearbyFollowHelper.a
            public final void a(int i3, String str, int i16) {
                PlayOperationViewModelImpl.this.lambda$updateFollowView$0(i3, str, i16);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void doOnResume() {
        updateFollowView();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public AppInterface getApp() {
        return this.app;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public String getExtraInfo() {
        return this.extraInfo;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean getIsAggregation() {
        return this.isAggregation;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean getIsCanJump() {
        return this.isCanJump;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean getIsFollow() {
        return this.isFollow;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean getIsLiked() {
        return this.isLiked;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean getIsLocal() {
        return this.isLocal;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean getIsMine() {
        return this.isMine;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean getIsRecord() {
        return this.isRecord;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public int getLikes() {
        return this.likes;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public String getNickName() {
        return this.nickName;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public int getOperatorMode() {
        return this.operatorMode;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public String getRecordTime() {
        return this.recordTime;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public String getRecordTitle() {
        return this.recordTitle;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public String getVideoSrc() {
        return this.videoSrc;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public int getWatchCount() {
        return this.watchCount;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public View getmBinding() {
        return this.mBinding;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public View getmHeadBinding() {
        return this.mHeadBinding;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void hideHead() {
        View view = this.mHeadBinding;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public IPlayOperationViewModel init(View view, AppInterface appInterface) {
        this.mBinding = view;
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        this.app = qQAppInterface;
        qQAppInterface.addObserver(this.observer);
        this.mBinding.setOnTouchListener(new g());
        GestureDetector gestureDetector = new GestureDetector(this.mBinding.getContext(), new q());
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.3
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (System.currentTimeMillis() - PlayOperationViewModelImpl.this.mLastDoubleClickTime < 500) {
                    return true;
                }
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
                VideoData videoData = playOperationViewModelImpl.mVideoData;
                if (videoData != null && videoData.f252693d != VideoData.f252689l0) {
                    ((LikeAniView) playOperationViewModelImpl.mBinding.findViewById(R.id.e9a)).b(rawX, rawY);
                }
                if (!PlayOperationViewModelImpl.this.isLiked && !PlayOperationViewModelImpl.this.isRequstingLike && PlayOperationViewModelImpl.this.mBinding.findViewById(R.id.e9a).getVisibility() == 0) {
                    PlayOperationViewModelImpl.this.isUserClickAni = false;
                    PlayOperationViewModelImpl.this.onClickLike(null);
                    ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_double_click").genderInd1().reportByVideo(PlayOperationViewModelImpl.this.app);
                    final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_double_click").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
                PlayOperationViewModelImpl.this.mLastDoubleClickTime = System.currentTimeMillis();
                return true;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return false;
            }
        });
        initLikeAnimation();
        initBottomSelector();
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void initCommentsWidget() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initCommentsWidget:mVideoData=" + this.mVideoData);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initCommentsWidget:mRoomid=" + this.mRoomid + "isHasVideoLabel=" + this.isHasVideoLabel);
        }
        this.mRoomid = 0;
        queryVideoState(this.mVideoData.Y);
        setOpenRoomHeadUrl(this.mVideoData.H);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean isDialogShow() {
        return this.isDialogShow;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean isJubaoDialogShow() {
        return this.isJubaoDialogShow;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickClose(View view) {
        StuffContainerView.f fVar = this.mCloseListener;
        if (fVar != null) {
            fVar.onClose(this.mVideoData.f252692c0);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickFollow(View view) {
        if (!com.tencent.mobileqq.nearby.l.a(view.getContext())) {
            QQToast.makeText(view.getContext(), 0, view.getContext().getResources().getString(R.string.f171137ci2), 0).show();
        } else if (this.mVideoData.F > 0) {
            followNowUser();
        } else {
            followNearbyUser();
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickLabelJump(View view) {
        if (this.isHasVideoLabel) {
            ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_label_click").genderInd1().reportByVideo(this.app);
            final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.13
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_label_click").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
            if (this.mLabelType != 2) {
                return;
            }
            Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", this.app.getCurrentAccountUin());
            intent.putExtra("url", this.mTopicVideoLabelInfo.f252924c);
            view.getContext().startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickMore(View view) {
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_more_click").genderInd1().reportByVideo(this.app);
        final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.19
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_more_click").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
        BaseActivity baseActivity = (BaseActivity) this.mBinding.getContext();
        ActionSheet create = ActionSheet.create(baseActivity);
        if (!this.isMine) {
            create.addButton(R.string.gka, 1);
        } else {
            create.addButton(HardCodeUtil.qqStr(R.string.p8s), 1);
        }
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new h(baseActivity, create));
        create.setOnDismissListener(new i());
        create.show();
        this.isJubaoDialogShow = true;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickPublishComment(View view) {
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_com_click").genderInd1().reportByVideo(this.app);
        final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.22
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_com_click").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
        View.OnClickListener onClickListener = this.mOnCommentClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickShare(View view) {
        String str;
        HashMap hashMap = new HashMap();
        VideoData videoData = this.mVideoData;
        if (videoData.f252692c0 == 4) {
            if (videoData.f252703i0.get(0) != null) {
                str = this.mVideoData.f252703i0.get(0).f252712a;
            } else {
                str = "";
            }
        } else {
            str = videoData.f252700h;
        }
        String str2 = str;
        hashMap.put("record_title", this.mVideoData.W);
        hashMap.put("id", this.feedsId);
        hashMap.put("anchor_nick_name", this.mVideoData.N);
        hashMap.put(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, Integer.valueOf(this.mVideoData.f252692c0));
        hashMap.put("recorder_nick_name", this.mVideoData.P);
        hashMap.put("roomName", this.mVideoData.W);
        hashMap.put("bNewQZone", Boolean.FALSE);
        hashMap.put("source", 6);
        hashMap.put("play_operatro_view_model", this);
        hashMap.put("anchor_uin", Long.valueOf(this.mVideoData.D));
        hashMap.put("record_uin", Long.valueOf(this.mVideoData.Q));
        String str3 = "https://now.qq.com/h5/view_record.html?_wv=1&_bid=2424&from=6&feeds_id=" + this.feedsId;
        String qqStr = HardCodeUtil.qqStr(R.string.p9c);
        String qqStr2 = HardCodeUtil.qqStr(R.string.p9a);
        if (!TextUtils.isEmpty(this.mVideoData.N)) {
            qqStr2 = "\u201c\u300c" + this.mVideoData.N + "\u300d\u201d" + HardCodeUtil.qqStr(R.string.p98);
        }
        ((IShortVideoShareUtil) QRoute.api(IShortVideoShareUtil.class)).showShareActionSheet(this.app, (BaseActivity) this.mBinding.getContext(), String.valueOf(this.mVideoData.D), "", str3, qqStr, qqStr2, str2, str2, this.mForShare, new f());
        this.isDialogShow = true;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public boolean queryVideoState(long j3) {
        ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.app).getShortLabel(j3, this.feedsId, new n());
        return true;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void reshowOperaView() {
        if (this.isRecord || this.isLocal) {
            return;
        }
        this.mBinding.findViewById(R.id.ad7).setVisibility(0);
        this.mBinding.findViewById(R.id.ad7).setAlpha(1.0f);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setAgeAndGender(int i3, int i16) {
        View view = this.mHeadBinding;
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.f164062iw);
            imageView.setVisibility(0);
            if (i16 == 1) {
                imageView.setBackgroundDrawable(imageView.getResources().getDrawable(R.drawable.ezp));
            } else {
                imageView.setBackgroundDrawable(imageView.getResources().getDrawable(R.drawable.ezn));
            }
            if (i16 != 255 && i16 != 0) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setAggregation(boolean z16) {
        this.isAggregation = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setApp(AppInterface appInterface) {
        this.app = (QQAppInterface) appInterface;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setCanJump(boolean z16) {
        this.isCanJump = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setCurrentAnchorUin(long j3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setCurrentAnchorUin,currentAnchorUin:" + j3);
        }
        this.mCurrentAnchorUin = j3;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setDialogShow(boolean z16) {
        this.isDialogShow = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setExtraInfo(String str) {
        this.extraInfo = str;
        ((TextView) this.mHeadBinding.findViewById(R.id.c0j)).setText(str);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setFeedType(int i3) {
        View view = this.mHeadBinding;
        if (view == null || this.isLocal) {
            return;
        }
        view.findViewById(R.id.f166989jp2).setVisibility(0);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setFollow(boolean z16) {
        this.isFollow = z16;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "is follow? " + z16);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "is Mine? " + this.isMine);
        }
        View view = this.mHeadBinding;
        if (view != null) {
            if (!this.isFollow && !this.isMine) {
                view.findViewById(R.id.che).setVisibility(0);
            } else {
                view.findViewById(R.id.che).setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setHeadBinding(View view) {
        this.mHeadBinding = view;
        ((RoundRelativeLayout) view.findViewById(R.id.chb)).a(16);
        this.mHeadBinding.findViewById(R.id.chb).requestLayout();
        ((RoundRelativeLayout) this.mHeadBinding.findViewById(R.id.cha)).a(16);
        this.mHeadBinding.findViewById(R.id.cha).requestLayout();
        initListener();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setHeadInfoMaskWhiteMode() {
        showWhiteHeadBlock();
        this.isUseProgressiveMask = false;
        setOperatorMode(1);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setHeadUrl(String str) {
        this.headUrl = str;
        if (this.mHeadBinding != null) {
            ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage((ImageView) this.mHeadBinding.findViewById(R.id.d3z), str, this.mHeadBinding.getResources().getDrawable(R.drawable.exy), this.mHeadBinding.getResources().getDrawable(R.drawable.exy), null, true);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setIsMine(boolean z16) {
        this.isMine = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setJubaoDialogShow(boolean z16) {
        this.isJubaoDialogShow = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setLiked(boolean z16) {
        this.isLiked = z16;
        this.mBinding.findViewById(R.id.j3p).setSelected(this.isLiked);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setLikes(int i3) {
        this.likes = i3;
        if (i3 > 0) {
            if (this.operatorMode == 1) {
                if (this.isLiked) {
                    ((ImageView) this.mBinding.findViewById(R.id.j3q)).setImageResource(R.drawable.f161788ez2);
                } else {
                    ((ImageView) this.mBinding.findViewById(R.id.j3q)).setImageResource(R.drawable.ezf);
                }
            } else if (this.isLiked) {
                ((ImageView) this.mBinding.findViewById(R.id.j3q)).setImageResource(R.drawable.f161788ez2);
            } else {
                ((ImageView) this.mBinding.findViewById(R.id.j3q)).setImageResource(R.drawable.f161787ez1);
            }
            long j3 = i3;
            ((TextView) this.mBinding.findViewById(R.id.j3p)).setText(q92.a.c(j3));
            this.mBinding.findViewById(R.id.j3p).setContentDescription(String.format(HardCodeUtil.qqStr(R.string.x_p), Long.valueOf(j3)));
            return;
        }
        if (this.operatorMode == 1) {
            ((ImageView) this.mBinding.findViewById(R.id.j3q)).setImageResource(R.drawable.ezf);
        } else {
            ((ImageView) this.mBinding.findViewById(R.id.j3q)).setImageResource(R.drawable.f161787ez1);
        }
        ((TextView) this.mBinding.findViewById(R.id.j3p)).setText(HardCodeUtil.qqStr(R.string.p99));
        this.mBinding.findViewById(R.id.j3p).setContentDescription(HardCodeUtil.qqStr(R.string.p99));
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setLocal(boolean z16) {
        this.isLocal = z16;
        this.mHeadBinding.findViewById(R.id.f166989jp2).setVisibility((this.isRecord || this.isLocal) ? 8 : 0);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setNickName(String str) {
        this.nickName = str;
        ((TextView) this.mHeadBinding.findViewById(R.id.f9d)).setText(str);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setOnCloseListener(Object obj) {
        this.mCloseListener = (StuffContainerView.f) obj;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setOnCommentClickListener(View.OnClickListener onClickListener) {
        this.mOnCommentClickListener = onClickListener;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setOperatorMode(int i3) {
        this.operatorMode = i3;
        this.mBinding.findViewById(R.id.ad7).setBackgroundResource(this.operatorMode == 0 ? R.drawable.f161797af2 : R.drawable.f161798af3);
        ((ImageView) this.mBinding.findViewById(R.id.j3h)).setImageResource(this.operatorMode == 0 ? R.drawable.eyz : R.drawable.f161786ez0);
        ((ImageView) this.mBinding.findViewById(R.id.j3w)).setImageResource(this.operatorMode == 0 ? R.drawable.ez5 : R.drawable.ez6);
        ((ImageView) this.mBinding.findViewById(R.id.j3s)).setImageResource(this.operatorMode == 0 ? R.drawable.f161789ez3 : R.drawable.ez4);
        ((TextView) this.mBinding.findViewById(R.id.j3g)).setTextColor(this.operatorMode == 0 ? -1 : -16777216);
        ((TextView) this.mBinding.findViewById(R.id.j3p)).setTextColor(this.operatorMode == 0 ? -1 : -16777216);
        ((TextView) this.mBinding.findViewById(R.id.j3v)).setTextColor(this.operatorMode == 0 ? -1 : -16777216);
        ((TextView) this.mBinding.findViewById(R.id.j3r)).setTextColor(this.operatorMode != 0 ? -16777216 : -1);
        setLikes(this.likes);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setRecord(boolean z16) {
        this.isRecord = z16;
        this.mHeadBinding.findViewById(R.id.f166989jp2).setVisibility((this.isRecord || this.isLocal) ? 8 : 0);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setRecordTime(String str) {
        this.recordTime = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setRecordTitle(String str) {
        this.recordTitle = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setVideoPageSource(int i3) {
        this.mVideoPageSource = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setVideoSrc(String str) {
        this.videoSrc = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setWatchCount(int i3) {
        this.watchCount = i3;
        setExtraInfo(q92.a.e(this.watchCount) + HardCodeUtil.qqStr(R.string.p9d));
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setmBinding(View view) {
        this.mBinding = view;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setmHeadBinding(View view) {
        this.mHeadBinding = view;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void showIfCan(boolean z16) {
        VideoData videoData = this.mVideoData;
        if (videoData != null && videoData.f252693d != 1) {
            this.mBinding.findViewById(R.id.ffh).setVisibility(z16 ? 0 : 8);
        } else {
            this.mBinding.findViewById(R.id.ffh).setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void updateShowInfo(VideoData videoData) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateShowInfo:mVideoData=" + this.mVideoData);
        }
        this.feedsId = videoData.f252695e;
        this.mVideoData = videoData;
        if (videoData.f252693d == 1) {
            showIfCan(false);
            return;
        }
        this.jumpUrl = videoData.f252706m;
        this.currentAnchorNowId = videoData.F;
        this.currentAnchorNowUserType = videoData.G;
        if (videoData.Y == videoData.Q) {
            setHeadUrl(videoData.T);
            setNickName(videoData.P);
            this.headerInfoUid = videoData.Q;
            this.extraInfoUid = videoData.D;
        } else {
            setHeadUrl(videoData.H);
            setNickName(videoData.N);
            this.headerInfoUid = videoData.D;
            this.extraInfoUid = videoData.Q;
        }
        setWatchCount(videoData.K);
        setAgeAndGender(videoData.L, videoData.M);
        if (videoData.f252693d != 1) {
            setIsMine(videoData.f252705k0 == 1);
            setLiked(videoData.J);
            setLikes(videoData.C);
        }
        setAggregation(this.mVideoData.f252693d == 3);
        setRecord(videoData.f252693d == 1);
        setLocal(videoData.f252693d == 4);
        setCanJump(!TextUtils.isEmpty(videoData.f252706m));
        setFeedType(videoData.f252692c0);
        reshowOperaView();
        int i3 = this.mVideoData.f252692c0;
        this.isFirstTime = false;
        updateFollowView();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void destroy() {
        this.mCloseListener = null;
        this.app.removeObserver(this.observer);
        Dialog dialog = this.mDeleteConfirmDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mDeleteConfirmDialog = null;
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickHeader(View view) {
        QQAppInterface qQAppInterface = this.app;
        int i3 = QQManagerFactory.NEARBY_CARD_MANAGER;
        ((com.tencent.mobileqq.nearby.b) qQAppInterface.getManager(i3)).c().put(this.mVideoData.Y + "", 1);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&from=3");
        String currentAccountUin = this.app.getCurrentAccountUin();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("");
        sb6.append(this.headerInfoUid);
        sb5.append("&mode=" + (currentAccountUin.equals(sb6.toString()) ? 2 : 3));
        view.getContext().startActivity(new Intent(view.getContext(), (Class<?>) JumpActivity.class).setData(Uri.parse("mqq://card/show_pslcard/?source=1&uin=" + this.headerInfoUid + "&card_type=nearby" + sb5.toString() + "&now_id=" + this.mVideoData.F + "&now_user_type=" + this.mVideoData.G)));
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_post_click").genderInd1().reportByVideo(this.app);
        final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.app.getManager(i3);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.17
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.statistics.q h16 = new com.tencent.mobileqq.statistics.q(PlayOperationViewModelImpl.this.app).i("dc00899").a("grp_lbs").f("video").d("playpage_post_click").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
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
        ReportController.o(this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_card", 0, 0, "", "", "", "2");
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickLike(View view) {
        if (!com.tencent.biz.common.util.g.b(this.mBinding.getContext())) {
            QQToast.makeText(this.mBinding.getContext(), 1, HardCodeUtil.qqStr(R.string.f172300p93), 1).show();
            return;
        }
        this.isRequstingLike = true;
        animateLike();
        INowShortVideoProtoManager init = ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.app);
        if (!this.isLiked) {
            VideoData videoData = this.mVideoData;
            View findViewById = this.mBinding.findViewById(R.id.ffh);
            int width = findViewById.getWidth() / 2;
            int height = findViewById.getHeight() / 2;
            if (width == 0 || height == 0) {
                width = ba.getScreenWidth(this.mBinding.getContext()) / 2;
                height = ba.getScreenHeight(this.mBinding.getContext()) / 2;
            }
            if (videoData != null && videoData.f252693d != VideoData.f252689l0) {
                ((LikeAniView) this.mBinding.findViewById(R.id.e9a)).b(width, height);
            }
            init.feedsLike(this.feedsId, new c(videoData), null);
            ReportController.o(this.app, "dc00899", "grp_lbs", "", "new_thing", "clk_like", 0, 0, "", "", "", "2");
            return;
        }
        this.isUserClickAni = true;
        init.feedsUnLike(this.feedsId, new d(this.mVideoData), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class h implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseActivity f252934d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f252935e;

        /* loaded from: classes33.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (!NetworkUtil.isNetworkAvailable(PlayOperationViewModelImpl.this.app.getApp())) {
                    QQToast.makeText(PlayOperationViewModelImpl.this.mBinding.getContext(), 1, HardCodeUtil.qqStr(R.string.p9j), 0).show();
                    return;
                }
                u92.c cVar = (u92.c) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
                VideoData videoData = PlayOperationViewModelImpl.this.mVideoData;
                cVar.c(videoData.f252695e, videoData.U, videoData.f252692c0, new C8142a());
            }

            /* renamed from: com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl$h$a$a, reason: collision with other inner class name */
            /* loaded from: classes33.dex */
            class C8142a implements com.tencent.mobileqq.nearby.profilecard.moment.a {
                C8142a() {
                }

                @Override // com.tencent.mobileqq.nearby.profilecard.moment.a
                public void onResult(boolean z16, String str) {
                    if (z16) {
                        u92.c cVar = (u92.c) PlayOperationViewModelImpl.this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
                        if (cVar != null) {
                            cVar.f(str);
                        }
                        PlayOperationViewModelImpl.this.saveDeleteSuccessInfo(str);
                        if (PlayOperationViewModelImpl.this.mBinding.getContext() instanceof Activity) {
                            ((BaseActivity) PlayOperationViewModelImpl.this.mBinding.getContext()).finish();
                            return;
                        }
                        return;
                    }
                    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.p9k), 0).show();
                }
            }
        }

        h(BaseActivity baseActivity, ActionSheet actionSheet) {
            this.f252934d = baseActivity;
            this.f252935e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            if (i3 == 0) {
                if (PlayOperationViewModelImpl.this.isMine) {
                    PlayOperationViewModelImpl playOperationViewModelImpl = PlayOperationViewModelImpl.this;
                    playOperationViewModelImpl.mDeleteConfirmDialog = DialogUtil.createCustomDialog(playOperationViewModelImpl.mBinding.getContext(), 230, HardCodeUtil.qqStr(R.string.f172299p92), (CharSequence) null, HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.p95), new a(), new b());
                    PlayOperationViewModelImpl.this.mDeleteConfirmDialog.show();
                    ReportController.o(PlayOperationViewModelImpl.this.app, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
                } else {
                    PlayOperationViewModelImpl playOperationViewModelImpl2 = PlayOperationViewModelImpl.this;
                    VideoData videoData = playOperationViewModelImpl2.mVideoData;
                    if (videoData != null && playOperationViewModelImpl2.mHeadBinding != null && playOperationViewModelImpl2.app != null) {
                        String valueOf = String.valueOf(videoData.D);
                        if (!TextUtils.isEmpty(valueOf)) {
                            String str2 = "0";
                            if (!"0".equals(valueOf)) {
                                VideoData videoData2 = PlayOperationViewModelImpl.this.mVideoData;
                                String str3 = "";
                                if (videoData2.f252692c0 == 4) {
                                    if (videoData2.f252703i0.get(0) == null) {
                                        str = "";
                                    } else {
                                        str3 = PlayOperationViewModelImpl.this.mVideoData.f252703i0.get(0).f252712a;
                                        str = "";
                                    }
                                } else {
                                    str = videoData2.f252700h;
                                }
                                ProfileCardUtil.g0(this.f252934d, 0L, valueOf, null, 20006, "", new ProfileCardUtil.b().b(str3).d(str).c(PlayOperationViewModelImpl.this.mVideoData.W).a());
                                ReportController.o(PlayOperationViewModelImpl.this.app, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
                                String valueOf2 = String.valueOf(PlayOperationViewModelImpl.this.mVideoData.D);
                                ad adVar = ad.f97536a;
                                if (adVar.a()) {
                                    BaseActivity baseActivity = this.f252934d;
                                    if (ProfileUtils.isFriend(PlayOperationViewModelImpl.this.app, valueOf2)) {
                                        str2 = "1";
                                    }
                                    adVar.d(baseActivity, "10023", valueOf2, str2, "0");
                                } else {
                                    ((INearbyReportHelper) QRoute.api(INearbyReportHelper.class)).reportTrendDetailSafeReportClick(PlayOperationViewModelImpl.this.app, valueOf2);
                                }
                            }
                        }
                        QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.qqStr(R.string.f172298p91), 0).show();
                        return;
                    }
                }
            }
            ActionSheet actionSheet = this.f252935e;
            if (actionSheet != null) {
                actionSheet.dismiss();
            }
        }

        /* loaded from: classes33.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class n implements INowShortVideoProtoManager.a {
        n() {
        }

        @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
        public void a(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0 || bArr == null) {
                return;
            }
            oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
            try {
                oidb_0xada_rspbody.mergeFrom(bArr);
                if (QLog.isColorLevel()) {
                    QLog.i(PlayOperationViewModelImpl.TAG, 2, "queryVideoState err_msg:   " + oidb_0xada_rspbody.err_msg.get());
                }
                if (oidb_0xada_rspbody.busi_buf.has()) {
                    ilive_short_video_label$GetShortVideoVideoLabelRsp ilive_short_video_label_getshortvideovideolabelrsp = new ilive_short_video_label$GetShortVideoVideoLabelRsp();
                    ilive_short_video_label_getshortvideovideolabelrsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                    PlayOperationViewModelImpl.this.parseShortVideoVideoLabel(ilive_short_video_label_getshortvideovideolabelrsp);
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class s implements INowShortVideoProtoManager.a {
        s() {
        }

        @Override // com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.a
        public void a(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0 || bArr == null) {
                return;
            }
            oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
            try {
                oidb_0xada_rspbody.mergeFrom(bArr);
                if (QLog.isColorLevel()) {
                    QLog.i(PlayOperationViewModelImpl.TAG, 2, "err_msg:   " + oidb_0xada_rspbody.err_msg.get() + "  isFollow:" + PlayOperationViewModelImpl.this.isFollow);
                }
                if (oidb_0xada_rspbody.busi_buf.has()) {
                    ilive_new_anchor_follow_interface$FollowActionRsp ilive_new_anchor_follow_interface_followactionrsp = new ilive_new_anchor_follow_interface$FollowActionRsp();
                    ilive_new_anchor_follow_interface_followactionrsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                    if (QLog.isColorLevel()) {
                        QLog.i(PlayOperationViewModelImpl.TAG, 2, "ret:   " + ilive_new_anchor_follow_interface_followactionrsp.ret.get() + ",msg:     " + ilive_new_anchor_follow_interface_followactionrsp.f342148msg.get() + "  isFollow:" + PlayOperationViewModelImpl.this.isFollow);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void parseShortVideoVideoLabel(Object obj) {
        if (obj == null) {
            return;
        }
        ilive_short_video_label$GetShortVideoVideoLabelRsp ilive_short_video_label_getshortvideovideolabelrsp = (ilive_short_video_label$GetShortVideoVideoLabelRsp) obj;
        this.mRoomid = ilive_short_video_label_getshortvideovideolabelrsp.video_status.root_room_id.get();
        this.mLabelType = ilive_short_video_label_getshortvideovideolabelrsp.type.get();
        TextView textView = (TextView) this.mBinding.findViewById(R.id.krw);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.mBinding.findViewById(R.id.j3t);
        roundRelativeLayout.a(10);
        roundRelativeLayout.requestLayout();
        int i3 = this.mLabelType;
        boolean z16 = false;
        if (i3 == 2) {
            this.mTopicVideoLabelInfo.f252922a = ilive_short_video_label_getshortvideovideolabelrsp.feed_info.feed_id.get().toStringUtf8();
            this.mTopicVideoLabelInfo.f252923b = ilive_short_video_label_getshortvideovideolabelrsp.feed_info.topic.get();
            this.mTopicVideoLabelInfo.f252924c = ilive_short_video_label_getshortvideovideolabelrsp.feed_info.url.get();
            textView.setText(this.mTopicVideoLabelInfo.f252923b);
            roundRelativeLayout.setBackgroundResource(R.drawable.aeo);
            roundRelativeLayout.setVisibility(0);
        } else if (i3 != 3) {
            roundRelativeLayout.setVisibility(8);
        } else {
            this.mRecordVideoLabelInfo.f252919a = ilive_short_video_label_getshortvideovideolabelrsp.video_info.url.get();
            this.mRecordVideoLabelInfo.f252920b = ilive_short_video_label_getshortvideovideolabelrsp.video_info.cover_url.get();
            textView.setText(HardCodeUtil.qqStr(R.string.p8z));
            roundRelativeLayout.setBackgroundResource(R.drawable.aep);
            roundRelativeLayout.setVisibility(0);
        }
        int i16 = this.mLabelType;
        if (i16 != 0 && i16 != 1) {
            z16 = true;
        }
        this.isHasVideoLabel = z16;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setTopOperationBkg(int i3) {
        View view = this.mHeadBinding;
        if (view == null || !this.isUseProgressiveMask) {
            return;
        }
        View findViewById = view.findViewById(R.id.d3h).findViewById(R.id.aat);
        if (i3 > 10 && i3 < 70) {
            float f16 = (i3 - 10) / 60.0f;
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            int intValue = ((Integer) argbEvaluator.evaluate(f16, -1, -16777216)).intValue();
            int intValue2 = ((Integer) argbEvaluator.evaluate(f16, -1, -4473925)).intValue();
            int intValue3 = ((Integer) argbEvaluator.evaluate(f16, -637534209, Integer.valueOf(COLOR_BLUE))).intValue();
            ((Integer) argbEvaluator.evaluate(f16, Integer.valueOf(COLOR_BLUE), -1)).intValue();
            ((TextView) this.mHeadBinding.findViewById(R.id.f9d)).setTextColor(intValue);
            ((TextView) this.mHeadBinding.findViewById(R.id.c0j)).setTextColor(intValue2);
            ((TextView) this.mHeadBinding.findViewById(R.id.cgp)).setTextColor(COLOR_WHITE);
            ((TextView) this.mHeadBinding.findViewById(R.id.chd)).setTextColor(COLOR_WHITE);
            setViewBgColor(this.mHeadBinding.findViewById(R.id.chi), COLOR_WHITE);
            this.mFollowBackColor = intValue3;
            if (!this.isPlayingAnim) {
                this.mHeadBinding.findViewById(R.id.chb).setBackgroundColor(COLOR_BLUE);
                this.mHeadBinding.findViewById(R.id.chc).setBackgroundDrawable(null);
            } else {
                setViewBgColor(this.mHeadBinding.findViewById(R.id.chc), COLOR_BLUE);
            }
            this.mHeadBinding.findViewById(R.id.d3h).setBackgroundColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.mHeadBinding.findViewById(R.id.d3h).getBackground().setAlpha((int) (255.0f * f16));
            this.mHeadBinding.findViewById(R.id.azd).setAlpha(1.0f - f16);
            this.mHeadBinding.findViewById(R.id.azc).setAlpha(f16);
            this.mBinding.findViewById(R.id.j3t).setVisibility(8);
            if (findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        if (i3 <= 10) {
            ((TextView) this.mHeadBinding.findViewById(R.id.f9d)).setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
            ((TextView) this.mHeadBinding.findViewById(R.id.c0j)).setTextColor(Color.parseColor("#b3ffffff"));
            ((TextView) this.mHeadBinding.findViewById(R.id.cgp)).setTextColor(COLOR_WHITE);
            ((TextView) this.mHeadBinding.findViewById(R.id.chd)).setTextColor(COLOR_WHITE);
            setViewBgColor(this.mHeadBinding.findViewById(R.id.chi), COLOR_WHITE);
            this.mFollowBackColor = -637534209;
            if (!this.isPlayingAnim) {
                this.mHeadBinding.findViewById(R.id.chb).setBackgroundColor(COLOR_BLUE);
                this.mHeadBinding.findViewById(R.id.chc).setBackgroundDrawable(null);
            } else {
                setViewBgColor(this.mHeadBinding.findViewById(R.id.chc), COLOR_BLUE);
            }
            this.mHeadBinding.findViewById(R.id.d3h).setBackgroundResource(R.drawable.f161799af4);
            this.mHeadBinding.findViewById(R.id.azd).setAlpha(1.0f);
            this.mHeadBinding.findViewById(R.id.azc).setAlpha(0.0f);
            if (findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
            }
            this.mBinding.findViewById(R.id.j3t).setVisibility(this.isHasVideoLabel ? 0 : 8);
            return;
        }
        if (i3 >= 70) {
            ((TextView) this.mHeadBinding.findViewById(R.id.f9d)).setTextColor(Color.parseColor("#000000"));
            ((TextView) this.mHeadBinding.findViewById(R.id.c0j)).setTextColor(Color.parseColor("#bbbbbb"));
            ((TextView) this.mHeadBinding.findViewById(R.id.cgp)).setTextColor(COLOR_WHITE);
            ((TextView) this.mHeadBinding.findViewById(R.id.chd)).setTextColor(COLOR_WHITE);
            setViewBgColor(this.mHeadBinding.findViewById(R.id.chi), COLOR_WHITE);
            this.mFollowBackColor = COLOR_BLUE;
            if (!this.isPlayingAnim) {
                this.mHeadBinding.findViewById(R.id.chb).setBackgroundColor(COLOR_BLUE);
                this.mHeadBinding.findViewById(R.id.chc).setBackgroundDrawable(null);
            } else {
                Drawable background = this.mHeadBinding.findViewById(R.id.chc).getBackground();
                if (background != null) {
                    background.setColorFilter(new LightingColorFilter(-16777216, COLOR_BLUE));
                    background.invalidateSelf();
                }
            }
            this.mHeadBinding.findViewById(R.id.d3h).setBackgroundColor(-1);
            this.mHeadBinding.findViewById(R.id.azd).setAlpha(0.0f);
            this.mHeadBinding.findViewById(R.id.azc).setAlpha(1.0f);
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setCommentsCount(long j3) {
        if (j3 <= 0) {
            ((TextView) this.mBinding.findViewById(R.id.j3g)).setText(HardCodeUtil.qqStr(R.string.p9f));
        } else {
            ((TextView) this.mBinding.findViewById(R.id.j3g)).setText(q92.a.c(j3));
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void hideCommentsWidget() {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void release() {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void onClickNickName(View view) {
    }

    @Override // com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel
    public void setOpenRoomHeadUrl(String str) {
    }
}
