package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.comment.abovebar.QFSCommentAtBar;
import com.tencent.biz.qqcircle.comment.abovebar.QFSCommentRecPicBar;
import com.tencent.biz.qqcircle.comment.abovebar.QFSCommentRecStickersBar;
import com.tencent.biz.qqcircle.comment.aicomment.QFSAiCommentPanel;
import com.tencent.biz.qqcircle.comment.album.QFSAlbumView;
import com.tencent.biz.qqcircle.comment.album.QFSHalfScreenAlbumSheetView;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.emoji.QFSCommentPicPreview;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.comment.sticker.c;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentEmotionRedPointEvent;
import com.tencent.biz.qqcircle.events.QFSFavEmojiTabSelectEvent;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSCommentPicSelectEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.be;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cm;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser;
import com.tencent.richframework.text.rich.parser.RichTextEmojiParser;
import com.tencent.richframework.text.rich.style.EditTextLinkMovementMethod;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends QFSBaseInputPopupWindow implements SimpleEventReceiver, com.tencent.biz.qqcircle.comment.abovebar.a {
    private static final int I0 = 2131244357;
    private static final int J0 = 2131245159;
    private static final int K0 = 2131244912;
    private static final int L0 = 2131245093;
    private static final String M0 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1910843u);
    private static final String N0 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1898440h);
    private View A0;
    private View B0;
    private final List<com.tencent.biz.qqcircle.comment.abovebar.b> C0;
    private boolean D0;
    private boolean E0;
    private boolean F0;
    private boolean G0;
    private com.tencent.biz.qqcircle.comment.wrapper.d H0;
    private FrameLayout W;
    private View X;
    private QFSAiCommentPanel Y;
    private QFSHalfScreenAlbumSheetView Z;

    /* renamed from: a0, reason: collision with root package name */
    private QFSCommentInputWindowConfig f83942a0;

    /* renamed from: b0, reason: collision with root package name */
    private IEmoticonMainPanel f83943b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f83944c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f83945d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f83946e0;

    /* renamed from: f0, reason: collision with root package name */
    private LinearLayout f83947f0;

    /* renamed from: g0, reason: collision with root package name */
    protected LinearLayout f83948g0;

    /* renamed from: h0, reason: collision with root package name */
    private RelativeLayout f83949h0;

    /* renamed from: i0, reason: collision with root package name */
    private ImageButton f83950i0;

    /* renamed from: j0, reason: collision with root package name */
    private ImageButton f83951j0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageButton f83952k0;

    /* renamed from: l0, reason: collision with root package name */
    private ViewGroup f83953l0;

    /* renamed from: m0, reason: collision with root package name */
    private ImageButton f83954m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f83955n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f83956o0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f83957p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f83958q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f83959r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f83960s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f83961t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f83962u0;

    /* renamed from: v0, reason: collision with root package name */
    private QFSCommentPicPreview f83963v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f83964w0;

    /* renamed from: x0, reason: collision with root package name */
    private FeedCloudMeta$StFeed f83965x0;

    /* renamed from: y0, reason: collision with root package name */
    private be f83966y0;

    /* renamed from: z0, reason: collision with root package name */
    private o20.d f83967z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements EmoticonCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (u.this.F.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = u.this.F.getText();
                int selectionStart = u.this.F.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(u.this.F.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = u.this.F.getSelectionStart();
                int selectionEnd = u.this.F.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                u.this.F.getEditableText().replace(selectionStart, selectionEnd, HostEmotionUtil.getFaceString(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = u.this.F.getSelectionStart();
                int selectionEnd2 = u.this.F.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    String emoString = HostEmotionUtil.getEmoString(i3, i16);
                    if (emoString != null && u.this.F.getEditableText() != null) {
                        u.this.F.getEditableText().replace(selectionStart2, selectionEnd2, emoString);
                    }
                    u.this.F.requestFocus();
                }
                HostEmotionUtil.addToCommonUse(systemAndEmojiEmoticonInfo);
                return;
            }
            if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
                if (!ud2.a.f438849a.e() && GifDrawable.isGifFile(new File(((IFavoriteEmoticonInfo) emoticonInfo).getPath()))) {
                    QCircleToast.o(u.N0, 0);
                    return;
                }
                IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) emoticonInfo;
                String url = iFavoriteEmoticonInfo.getUrl();
                String path = iFavoriteEmoticonInfo.getPath();
                if (TextUtils.isEmpty(url)) {
                    QLog.w("QFSBaseInputPopupWindow", 1, "[send] invalid url");
                    QCircleToast.o("\u8d44\u6e90\u6b63\u5728\u4e0a\u4f20\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0);
                } else {
                    u.this.P2(url, path);
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements com.tencent.biz.qqcircle.comment.emoji.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.comment.emoji.b
        public EditText getAIOInput() {
            return u.this.F;
        }

        @Override // com.tencent.biz.qqcircle.comment.emoji.b
        public IEmoticonMainPanel getIEmoticonMainPanel() {
            if (!(u.this.X instanceof IEmoticonMainPanel)) {
                return u.this.f83943b0;
            }
            return (IEmoticonMainPanel) u.this.X;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements IEmoticonMainPanel.OnPanelTabSelectedCallBack {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel.OnPanelTabSelectedCallBack
        public void onPanelTabSelected(int i3) {
            if (i3 == 4) {
                ud2.a.f438849a.i();
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentEmotionRedPointEvent());
                SimpleEventBus.getInstance().dispatchEvent(new QFSFavEmojiTabSelectEvent(false));
            }
            u.this.f83964w0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends QQPermission.BasePermissionsListener {
        d() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            u.this.y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g implements RichTextClickableImageSpanParser.OnStatusListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Editable f83976a;

        g(Editable editable) {
            this.f83976a = editable;
        }

        @Override // com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser.OnStatusListener
        public void onClick(int i3, String str) {
            if (i3 == 0 && u.this.f83966y0 != null && TextUtils.equals(str, u.this.f83966y0.c())) {
                com.tencent.biz.qqcircle.helpers.l.e().j(u.this.f83966y0.a(), true);
            }
        }

        @Override // com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser.OnStatusListener
        public void onLoadImageSuccess(Drawable drawable) {
            u.this.C0(this.f83976a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16 = false;
            if (i3 == 4 || i3 == 6) {
                if (u.this.p1()) {
                    QCircleToast.o(u.M0, 0);
                } else {
                    QFSBaseInputPopupWindow.b bVar = u.this.K;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class i implements f.b {
        i() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardClosed() {
            u.this.x2();
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardOpened(int i3) {
            u.this.u1(i3);
        }
    }

    public u(@NonNull QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        super(qFSCommentInputWindowConfig.activity);
        QFSFeedCommentInfo qFSFeedCommentInfo;
        float f16;
        this.f83943b0 = null;
        boolean z16 = false;
        this.f83959r0 = false;
        this.f83960s0 = false;
        this.f83961t0 = false;
        this.f83962u0 = false;
        this.f83964w0 = uq3.k.b().e("sp_key_emoji_last_selected_emoji_tab", 7);
        this.C0 = new ArrayList();
        this.F0 = true;
        if (qFSCommentInputWindowConfig.activity != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            this.f83942a0 = qFSCommentInputWindowConfig;
            this.f83965x0 = qFSFeedCommentInfo.mFeed;
            this.f83962u0 = qFSCommentInputWindowConfig.isShowRecPicBar;
            o20.d dVar = new o20.d(this.S, qFSCommentInputWindowConfig.reportBean);
            this.f83967z0 = dVar;
            dVar.f421797e = this.f83965x0;
            D2(this.f83953l0, qFSCommentInputWindowConfig.needShowPublishIcon);
            D2(this.f83954m0, qFSCommentInputWindowConfig.needShowPublishIcon);
            K2();
            D2(this.f83950i0, qFSCommentInputWindowConfig.isAllowAiComment);
            ImageButton imageButton = this.f83951j0;
            if ((!qFSCommentInputWindowConfig.needShowPublishIcon || !qFSCommentInputWindowConfig.isAllowAiComment) && qFSCommentInputWindowConfig.needShowAtIcon) {
                z16 = true;
            }
            D2(imageButton, z16);
            if (qFSCommentInputWindowConfig.isShowEmoji) {
                j2();
            }
            h2();
            LinearLayout linearLayout = this.f83948g0;
            if (!qFSCommentInputWindowConfig.isShowPostBtn && !qFSCommentInputWindowConfig.needShowAt) {
                f16 = L1();
            } else {
                f16 = 0.0f;
            }
            linearLayout.setTranslationX(f16);
            u2();
            i1();
            this.H0 = new com.tencent.biz.qqcircle.comment.wrapper.d(this.E, this);
            ud2.a.f438849a.h(G1());
            M2();
        }
    }

    private void A2(ImageView imageView, @DrawableRes int i3) {
        boolean z16;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(ResourcesCompat.getDrawable(imageView.getResources(), i3, null));
        if (i3 == R.drawable.qui_keyboard_circle) {
            z16 = true;
        } else {
            z16 = false;
        }
        imageView.setTag(Boolean.valueOf(z16));
    }

    private void D2(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private int F1() {
        Context application;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_comment_input_adjust_emoji_colum_count", true);
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.isFullScreen && isSwitchOn) {
            WeakReference<Context> weakReference = this.D;
            if (weakReference != null && weakReference.get() != null) {
                application = this.D.get();
            } else {
                application = RFWApplication.getApplication();
            }
            int min = Math.min(17, ((Math.max(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth()) - (I1() * 2)) - (DisplayUtil.dip2px(application, 9.0f) * 2)) / DisplayUtil.dip2px(application, 48.0f));
            QLog.d("QFSBaseInputPopupWindow", 1, "[getEmojiPanelColumCount] emoji colum: " + min);
            return min;
        }
        return EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI;
    }

    private void F2() {
        MovementMethod editTextLinkMovementMethod;
        if (this.F != null && this.f83942a0 != null) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_comment_input_scroll", true);
            CommentEditText commentEditText = this.F;
            if (isSwitchOn && this.f83942a0.isFullScreen) {
                editTextLinkMovementMethod = new LinkMovementMethod();
            } else {
                editTextLinkMovementMethod = EditTextLinkMovementMethod.getInstance();
            }
            commentEditText.setMovementMethod(editTextLinkMovementMethod);
        }
    }

    private String G1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f83965x0;
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    private int I1() {
        WeakReference<Context> weakReference = this.D;
        if (weakReference != null && weakReference.get() != null) {
            return DisplayUtil.dip2px(this.D.get(), 54.0f);
        }
        return 0;
    }

    private void I2(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        if (qFSCommentInputWindowConfig != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            qFSFeedCommentInfo.mCommentText = j0();
            this.f83960s0 = true;
            k0(this.F);
            V1();
            View view = this.X;
            if (view != null) {
                view.setVisibility(8);
            }
            QFSAiCommentPanel qFSAiCommentPanel = this.Y;
            if (qFSAiCommentPanel != null && qFSAiCommentPanel.getVisibility() != 0) {
                this.Y.v();
                this.Y.w(qFSCommentInputWindowConfig);
            }
            j1();
            Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
            while (it.hasNext()) {
                it.next().k(true);
            }
        }
    }

    private String J1() {
        QCircleReportBean qCircleReportBean;
        String dtPageId;
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig == null || (qCircleReportBean = qFSCommentInputWindowConfig.reportBean) == null || (dtPageId = qCircleReportBean.getDtPageId()) == null) {
            return "";
        }
        return dtPageId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        this.f83959r0 = true;
        if (this.X == null) {
            j2();
        }
        ud2.a.f438849a.j(G1());
        D2(this.X, true);
        j1();
        Z1(false);
        k0(this.F);
        a2();
        d2();
        Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
        while (it.hasNext()) {
            it.next().k(true);
        }
        VideoReport.setElementId(this.X, QCircleDaTongConstant.ElementId.EM_XSJ_EMOTICON_TAB);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("dt_pgid", J1());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", this.X, buildElementParams);
    }

    private int K1() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar;
        int i3 = QFSBaseInputPopupWindow.U;
        if (i3 == 0 && (fVar = this.N) != null) {
            return fVar.i();
        }
        return Math.max(i3, com.tencent.biz.qqcircle.widgets.comment.f.f93570g);
    }

    private void K2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig == null) {
            return;
        }
        if (!qFSCommentInputWindowConfig.showPicEntranceRedPoint) {
            qFSCommentInputWindowConfig.showPicEntranceRedPoint = com.tencent.biz.qqcircle.comment.emoji.o.c();
            if (this.f83942a0.needShowPublishIcon) {
                com.tencent.biz.qqcircle.comment.emoji.o.e();
            }
        }
        D2(this.f83955n0, this.f83942a0.showPicEntranceRedPoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L1() {
        WeakReference<Context> weakReference = this.D;
        if (weakReference != null && weakReference.get() != null) {
            return DisplayUtil.dip2px(this.D.get(), 59.0f);
        }
        return 0;
    }

    private boolean L2() {
        IOrderElement groupActivatingElement = com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(M1(), "comment_input_above_bar");
        if ((groupActivatingElement instanceof com.tencent.biz.qqcircle.comment.abovebar.c) && ((com.tencent.biz.qqcircle.comment.abovebar.c) groupActivatingElement).s()) {
            return true;
        }
        return false;
    }

    private void M2() {
        if (this.f83956o0 == null) {
            return;
        }
        if (ud2.a.f438849a.b()) {
            this.f83956o0.setVisibility(0);
        } else {
            this.f83956o0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 != R.id.f33440wg && id5 != R.id.f33470wj) {
                if (id5 == R.id.f33450wh) {
                    x1(view);
                }
            } else {
                z2();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1(Editable editable, String str) {
        if (RichTextClickableImageSpanParser.match(str)) {
            RichTextClickableImageSpanParser.parseClickableImageSpan(editable, new g(editable));
        }
    }

    private void P1(QFSCommentPicSelectEvent qFSCommentPicSelectEvent) {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig == null) {
            QLog.e("QFSBaseInputPopupWindow", 1, "[handleCommentPicSelect] config is null. ");
            return;
        }
        qFSCommentInputWindowConfig.commentPicPath = qFSCommentPicSelectEvent.getPath();
        this.f83942a0.commentPicWidth = qFSCommentPicSelectEvent.getWidth();
        this.f83942a0.commentPicHeight = qFSCommentPicSelectEvent.getHeight();
        R2(qFSCommentPicSelectEvent.getPath());
        showKeyboard();
        d2();
    }

    private void Q1() {
        QLog.d("QFSBaseInputPopupWindow", 1, "->handleConfigChangeEvent");
        dismiss();
    }

    private void Q2(String str, String str2) {
        if (this.f83963v0 == null) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(M1(), "comment_input_above_bar");
        this.f83963v0.B(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1(Editable editable) {
        if (!RichTextClickableImageSpanParser.match(editable) && this.f83966y0 != null) {
            this.f83966y0 = null;
            com.tencent.biz.qqcircle.helpers.l.e().l(this.f83965x0);
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
            if (qFSCommentInputWindowConfig != null) {
                qFSCommentInputWindowConfig.goodsContent = "";
            }
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(M1(), "comment_input_above_bar");
        }
    }

    private void S1() {
        com.tencent.biz.qqcircle.utils.z.b(this.f83942a0.activity, 2, new d(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_PUBLISH_FEED), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(Editable editable, String str) {
        int indexOf = str.indexOf(47);
        if (indexOf >= 0 && indexOf < str.length() - 1 && com.tencent.biz.qqcircle.widgets.comment.d.f93568a.matcher(str).find()) {
            RichTextEmojiParser.asyncParseSmiley(new RichTextPreloadConfig.TextImageSpanConfig().setIconSize(20).setVerticalAlignment(0), editable, null);
        }
    }

    private void U1(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE.equals(aSEngineTabStatusEvent.getBusinessKey()) && !aSEngineTabStatusEvent.isSelected()) {
            dismiss();
        }
    }

    private void V1() {
        A2(this.f83950i0, J0);
        A2(this.f83952k0, K0);
        A2(this.f83954m0, L0);
    }

    private void Z1(boolean z16) {
        this.f83960s0 = false;
        QFSAiCommentPanel qFSAiCommentPanel = this.Y;
        if (qFSAiCommentPanel != null) {
            qFSAiCommentPanel.j();
        }
        if (z16) {
            Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
            while (it.hasNext()) {
                it.next().k(false);
            }
        }
    }

    private void a2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.isAllowAiComment) {
            A2(this.f83950i0, R.drawable.qui_lucy_icon_primary);
        }
        A2(this.f83952k0, J0);
        A2(this.f83954m0, L0);
    }

    private void c2(boolean z16, boolean z17) {
        View view = this.X;
        if (view != null) {
            view.setVisibility(8);
        }
        if (z16) {
            D0(this.F, 0);
        }
        if (z17 && !this.G0) {
            Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
            while (it.hasNext()) {
                it.next().k(false);
            }
        }
    }

    private void d2() {
        QFSHalfScreenAlbumSheetView qFSHalfScreenAlbumSheetView = this.Z;
        if (qFSHalfScreenAlbumSheetView != null && qFSHalfScreenAlbumSheetView.k()) {
            this.Z.i();
        }
    }

    private void e1(@NonNull List<HostSelectMemberUtils.QCircleResultData> list) {
        this.S.addAll(list);
    }

    private void e2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.isAllowAiComment) {
            A2(this.f83950i0, R.drawable.qui_lucy_icon_primary);
        }
        A2(this.f83952k0, K0);
        A2(this.f83954m0, L0);
    }

    private void f1() {
        if (this.Z != null) {
            return;
        }
        this.Z = new QFSHalfScreenAlbumSheetView(this.E.getContext());
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        QFSAlbumView qFSAlbumView = new QFSAlbumView(this.E.getContext());
        qFSAlbumView.setCustomReportBean(this.f83967z0.f421796d);
        this.Z.n(qFSAlbumView, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 80;
        ((ViewGroup) this.E).addView(this.Z, layoutParams2);
    }

    private void f2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.isAllowAiComment) {
            A2(this.f83950i0, R.drawable.qui_lucy_icon_primary);
        }
        A2(this.f83954m0, J0);
        A2(this.f83952k0, K0);
    }

    private void g1(View view) {
        FrameLayout frameLayout;
        i2();
        if (view != null && view.getParent() == null && (frameLayout = this.W) != null) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            com.tencent.mobileqq.qui.b.f276860a.a(view, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        }
    }

    private void g2(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        int i3;
        View view = this.A0;
        if (view != null) {
            if (qFSCommentInputWindowConfig.isFullScreen) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
        if (qFSCommentInputWindowConfig.isFullScreen) {
            return;
        }
        this.C0.add(new com.tencent.biz.qqcircle.comment.abovebar.c(this.E, this, this.F));
        if (qFSCommentInputWindowConfig.needShowAtIcon) {
            this.C0.add(new QFSCommentAtBar(this.E, this, this.F));
        }
        QFSFeedCommentInfo qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo;
        if (qFSFeedCommentInfo == null) {
            feedCloudMeta$StFeed = null;
        } else {
            feedCloudMeta$StFeed = qFSFeedCommentInfo.mFeed;
        }
        if (com.tencent.biz.qqcircle.comment.sticker.b.a(feedCloudMeta$StFeed) && qFSCommentInputWindowConfig.needShowRecommendBar) {
            this.C0.add(new QFSCommentRecStickersBar(this.E, this, this.F));
        }
        com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
        if (aaVar.z(getFeed()) && aaVar.F() && !aaVar.t()) {
            this.C0.add(new QFSCommentRecPicBar(this.E, this, this.F));
        }
        QFSCommentAtHelper.s0(false);
        QFSCommentAtHelper.r0(false);
    }

    private void h1(int i3) {
        FrameLayout frameLayout = this.W;
        if (frameLayout != null && frameLayout.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
            layoutParams.height = i3;
            this.W.setLayoutParams(layoutParams);
            QLog.d("QFSBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + i3);
        }
    }

    private void h2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig;
        WeakReference<Context> weakReference = this.D;
        if (weakReference != null && weakReference.get() != null && (qFSCommentInputWindowConfig = this.f83942a0) != null && qFSCommentInputWindowConfig.isAllowAiComment) {
            QLog.d("QFSBaseInputPopupWindow", 1, "[initAiCommentPanel] ");
            QFSAiCommentPanel qFSAiCommentPanel = new QFSAiCommentPanel(this.D.get());
            this.Y = qFSAiCommentPanel;
            qFSAiCommentPanel.setCommentItemClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.this.N1(view);
                }
            });
            g1(this.Y);
            this.Y.j();
        }
    }

    private void i1() {
        View view;
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && (view = this.B0) != null && this.W != null && qFSCommentInputWindowConfig.isFullScreen) {
            view.setPadding(I1(), 0, I1(), 0);
            this.W.setPadding(I1(), 0, I1(), 0);
        }
    }

    private void i2() {
        if (this.W == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.W = frameLayout;
            frameLayout.setBackgroundColor(QFSQUIUtilsKt.d(frameLayout.getContext(), R.color.qui_common_bg_middle_light));
            this.W.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
            this.f83947f0.addView(this.W, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    private void j1() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar;
        int i3 = QFSBaseInputPopupWindow.U;
        if (i3 == 0 && (fVar = this.N) != null) {
            int i16 = fVar.i();
            if (bz.o()) {
                double d16 = i16;
                if (d16 < DisplayUtil.getScreenHeight() * 0.3d || d16 > DisplayUtil.getScreenHeight() * 0.7d) {
                    i16 = (int) (DisplayUtil.getScreenHeight() * 0.7d);
                    QLog.d("QFSBaseInputPopupWindow", 1, "keyboard height too small or large. realHeight: " + i16);
                }
            }
            h1(i16);
            return;
        }
        h1(Math.max(i3, com.tencent.biz.qqcircle.widgets.comment.f.f93570g));
    }

    private void k2() {
        n2();
        this.F.addTextChangedListener(new f());
    }

    private void l1(EmoticonCallback emoticonCallback) {
        IEmoticonMainPanelService.PanelBuilder defaultPanelType = ((IEmoticonMainPanelService) QCircleServiceImpl.getAppInterface().getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(getContext(), 100005).setShowEmotionPanelDeleteButton(true).setTopTab().setDefaultPanelType(this.f83964w0);
        FavoriteEmoticonInfo favoriteEmoticonInfo = new FavoriteEmoticonInfo();
        favoriteEmoticonInfo.eId = "358";
        FavoriteEmoticonInfo favoriteEmoticonInfo2 = new FavoriteEmoticonInfo();
        favoriteEmoticonInfo2.eId = "359";
        PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo("");
        picEmoticonInfo.type = 6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(favoriteEmoticonInfo);
        arrayList.add(favoriteEmoticonInfo2);
        arrayList.add(picEmoticonInfo);
        defaultPanelType.setFilterEmotionData(4, arrayList);
        IEmoticonMainPanel create = defaultPanelType.setCallBack(emoticonCallback).setDisableMoreEmotionButton(true).setStyleChange(true).keepLottieMerged(true).setHideAllSettingTabs(true).addTabLRPadding().setEmoticonListProvider(new EmoticonListProvider() { // from class: com.tencent.biz.qqcircle.comment.t
            @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
            public final List getEmotionPanelInfo(boolean z16, boolean z17) {
                List q26;
                q26 = u.this.q2(z16, z17);
                return q26;
            }
        }).setPanelInteractionListener(new com.tencent.biz.qqcircle.comment.emoji.u(new b())).create();
        this.f83943b0 = create;
        create.setTabSelectedCallBack(new c());
    }

    private void l2() {
        com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(this.E);
        this.N = fVar;
        fVar.a(new i());
    }

    private String m1(@NonNull List<HostSelectMemberUtils.QCircleResultData> list, @NonNull List<HostSelectMemberUtils.QCircleResultData> list2, String str, String str2, int i3) {
        String str3;
        String str4;
        if (i3 >= list.size()) {
            e1(list2);
            return str2;
        }
        HostSelectMemberUtils.QCircleResultData qCircleResultData = list.get(i3);
        if (qCircleResultData == null) {
            return m1(list, list2, str, str2, i3 + 1);
        }
        if (TextUtils.isEmpty(qCircleResultData.name)) {
            str3 = qCircleResultData.uin;
        } else {
            str3 = qCircleResultData.name;
        }
        if (!TextUtils.isEmpty(str3)) {
            list2.add(qCircleResultData);
            String str5 = "@" + str3;
            this.F.d(str5, qCircleResultData);
            str4 = str2 + str5 + " ";
        } else {
            str4 = str2;
        }
        int u36 = uq3.c.u3();
        String str6 = str + str4;
        if (str6.length() < u36) {
            return m1(list, list2, str, str4, i3 + 1);
        }
        if (n1(str6) <= u36) {
            return m1(list, list2, str, str4, i3 + 1);
        }
        if (i3 <= list2.size() && i3 > 0) {
            e1(new ArrayList<>(list2.subList(0, i3)));
        }
        if (list.size() > 0 && i3 < list.size() - 1) {
            QCircleToast.o(M0, 0);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2() {
        this.F.addTextChangedListener(new e());
    }

    private int n1(CharSequence charSequence) {
        int i3 = 0;
        int i16 = 0;
        while (com.tencent.biz.qqcircle.widgets.comment.d.f93568a.matcher(charSequence).find()) {
            i16 += (r0.end() - r0.start()) - 2;
        }
        Matcher matcher = RichTextClickableImageSpanParser.CLICKABLE_IMAGE_SPAN_TAG_GROUP_PATTERN.matcher(charSequence);
        while (matcher.find()) {
            i3 += matcher.end() - matcher.start();
        }
        return (charSequence.length() - i16) - i3;
    }

    private void n2() {
        this.F.setOnEditorActionListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(boolean z16) {
        float f16;
        boolean p26 = p2();
        if (p26 == this.E0 && !z16) {
            return;
        }
        this.D0 = true;
        this.E0 = p26;
        if (this.f83948g0 != null && this.F != null && this.f83944c0 != null) {
            QLog.d("QFSBaseInputPopupWindow", 1, "[changeTextInputStyle] " + p26);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f83948g0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f83944c0.getLayoutParams();
            layoutParams.removeRule(3);
            layoutParams3.removeRule(3);
            layoutParams.removeRule(8);
            layoutParams3.removeRule(8);
            layoutParams2.height = -2;
            if (Of()) {
                layoutParams.addRule(8, R.id.f371316f);
                layoutParams3.addRule(8, R.id.f371316f);
            } else if (p26) {
                layoutParams.addRule(3, R.id.jha);
                layoutParams3.addRule(3, R.id.jha);
            }
            if (!p26 && !Of()) {
                f16 = 0.0f;
            } else {
                f16 = 8.0f;
            }
            layoutParams2.bottomMargin = cx.a(f16);
            if (!p26 && !Of()) {
                layoutParams2.addRule(6, R.id.f43981ny);
                layoutParams2.addRule(8, R.id.f43981ny);
            } else {
                layoutParams2.removeRule(6);
                layoutParams2.removeRule(8);
            }
            this.f83948g0.setLayoutParams(layoutParams);
            this.F.setLayoutParams(layoutParams2);
        }
    }

    private boolean p2() {
        CommentEditText commentEditText = this.F;
        if (commentEditText == null || commentEditText.getLayout() == null) {
            return false;
        }
        if (this.F.getLayout().getLineWidth(0) <= i0() && this.F.getLayout().getLineCount() <= 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List q2(boolean z16, boolean z17) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
        boolean s16 = cq.f92752a.s(this.f83965x0);
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.needShowFavoriteTab && !s16) {
            arrayList.add(new EmotionPanelInfo(4, 4, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(int i3, String str, String str2) {
        if (this.f83963v0 == null) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(M1(), "comment_input_above_bar");
        this.f83963v0.D(str, str2);
        C0("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(DialogInterface dialogInterface, int i3) {
        I2(this.f83942a0);
        uq3.k.a().j("sp_key_show_ai_comment_agreement_dialog", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2() {
        this.G0 = false;
        Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
        while (it.hasNext()) {
            it.next().k(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int i3) {
        boolean z16;
        QLog.d("QFSBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
        if (!this.F0) {
            return;
        }
        c2(false, !this.f83962u0);
        e2();
        FrameLayout frameLayout = this.W;
        if (frameLayout != null && frameLayout.getLayoutParams() != null && this.W.getLayoutParams().height != i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QFSBaseInputPopupWindow.U != i3 || z16) {
            QFSBaseInputPopupWindow.U = i3;
            h1(i3);
        }
        this.J = true;
        this.f83959r0 = false;
        this.f83961t0 = false;
        this.f83960s0 = false;
        this.f83962u0 = false;
    }

    private void u2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig;
        CommentEditText commentEditText = this.F;
        if (commentEditText != null && (qFSCommentInputWindowConfig = this.f83942a0) != null && qFSCommentInputWindowConfig.isFullScreen) {
            commentEditText.setMaxLines(2);
        }
    }

    private void v1(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        String str;
        String str2;
        if (qFSCommentInputWindowConfig != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFeedCommentInfo.mFeed;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            String str3 = "";
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            buildElementParams.put("xsj_feed_id", str);
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_AI_ICON);
            if (qFSCommentInputWindowConfig.commentInfo.mComment == null) {
                str2 = "cmt";
            } else {
                str2 = "reply";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str2);
            QCircleReportBean qCircleReportBean = qFSCommentInputWindowConfig.reportBean;
            if (qCircleReportBean != null) {
                str3 = qCircleReportBean.getDtPageId();
            }
            buildElementParams.put("xsj_custom_pgid", str3);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2() {
        LinearLayout linearLayout;
        if (this.f83945d0 != null && this.f83946e0 != null && (linearLayout = this.f83944c0) != null) {
            linearLayout.setVisibility(8);
            int n16 = n1(this.F.getText().toString());
            int u36 = uq3.c.u3();
            if (n16 >= u36 - 10) {
                this.f83944c0.setVisibility(0);
                this.f83945d0.setText(String.valueOf(n16));
                this.f83946e0.setText("/" + u36);
            }
        }
    }

    private void w1() {
        QFSFeedCommentInfo qFSFeedCommentInfo;
        String str;
        String str2;
        String str3;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            int M = QFSCommentHelper.L().M(this.f83965x0, qFSFeedCommentInfo.mComment, qFSFeedCommentInfo.mReply);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f83965x0;
            String str4 = "";
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            buildElementParams.put("xsj_feed_id", str);
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_VIDEO_ICON);
            if (M == 1) {
                str2 = "cmt";
            } else {
                str2 = "reply";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str2);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, af.v());
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.f83965x0;
            if (feedCloudMeta$StFeed2 == null || (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) == null) {
                str3 = "";
            } else {
                str3 = feedCloudMeta$StUser.f398463id.get();
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str3);
            QCircleReportBean qCircleReportBean = this.f83942a0.reportBean;
            if (qCircleReportBean != null) {
                str4 = qCircleReportBean.getDtPageId();
            }
            buildElementParams.put("xsj_custom_pgid", str4);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
        }
    }

    private void w2() {
        if (L2()) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(M1(), "comment_input_above_bar");
        } else {
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(M1(), "comment_input_above_bar");
        }
    }

    private void x1(View view) {
        if (view != null && (view.getTag() instanceof FeedCloudMeta$StComment)) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) view.getTag();
            this.f83967z0.f421800h = feedCloudMeta$StComment.content.get();
            this.f83967z0.f421801i = feedCloudMeta$StComment.f398447id.get();
            this.F.setText(x0(feedCloudMeta$StComment.content.get(), true));
            this.F.setSelection(feedCloudMeta$StComment.content.get().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2() {
        QLog.d("QFSBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
        if (this.f83959r0) {
            this.f83959r0 = false;
        } else if (this.f83960s0) {
            this.f83960s0 = false;
        } else if (this.f83961t0) {
            this.f83961t0 = false;
        } else if (!this.R && !this.f83958q0) {
            dismiss();
        }
        this.J = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2() {
        this.f83961t0 = true;
        f1();
        Z1(false);
        k0(this.F);
        c2(false, false);
        f2();
        QFSHalfScreenAlbumSheetView qFSHalfScreenAlbumSheetView = this.Z;
        if (qFSHalfScreenAlbumSheetView != null) {
            qFSHalfScreenAlbumSheetView.setVisibility(0);
            h1(Math.max(QFSBaseInputPopupWindow.U, com.tencent.biz.qqcircle.widgets.comment.f.f93570g));
            this.Z.q(K1());
        }
        Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
        while (it.hasNext()) {
            it.next().k(true);
        }
    }

    private void z2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig;
        QFSFeedCommentInfo qFSFeedCommentInfo;
        if (this.Y != null && (qFSCommentInputWindowConfig = this.f83942a0) != null && (qFSFeedCommentInfo = qFSCommentInputWindowConfig.commentInfo) != null) {
            qFSFeedCommentInfo.mCommentText = j0();
            this.Y.v();
            this.Y.u(this.f83942a0);
        }
    }

    public String A1() {
        QFSCommentPicPreview qFSCommentPicPreview = this.f83963v0;
        if (qFSCommentPicPreview == null) {
            return "";
        }
        return qFSCommentPicPreview.p();
    }

    public int B1() {
        QFSCommentPicPreview qFSCommentPicPreview = this.f83963v0;
        if (qFSCommentPicPreview == null) {
            return 0;
        }
        return qFSCommentPicPreview.q();
    }

    public void B2(be beVar) {
        this.f83966y0 = beVar;
    }

    public String C1() {
        QFSCommentPicPreview qFSCommentPicPreview = this.f83963v0;
        if (qFSCommentPicPreview == null) {
            return "";
        }
        return qFSCommentPicPreview.r();
    }

    public void C2(boolean z16) {
        int i3;
        ImageView imageView = this.f83957p0;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            if (i3 != imageView.getVisibility()) {
                this.f83957p0.setVisibility(i3);
                this.f83957p0.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qvideo_skin_comment_tag_gengwang_richtext));
            }
        }
    }

    public be E1() {
        return this.f83966y0;
    }

    public void G2(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        boolean z16;
        o20.d dVar = this.f83967z0;
        if (feedCloudMeta$StComment != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        dVar.f421793a = z16;
        dVar.f421798f = feedCloudMeta$StComment;
        dVar.f421799g = feedCloudMeta$StReply;
    }

    public void H2(QFSCommentInputWindowConfig qFSCommentInputWindowConfig) {
        try {
            show();
            l2();
            g2(qFSCommentInputWindowConfig);
            e0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.n
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.s0();
                }
            });
            e0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.o
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.m2();
                }
            }, 200L);
            if (qFSCommentInputWindowConfig.isShowEmoji) {
                h1(Math.max(QFSBaseInputPopupWindow.U, com.tencent.biz.qqcircle.widgets.comment.f.f93570g));
                e0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.this.J2();
                    }
                }, 200L);
            } else if (qFSCommentInputWindowConfig.isShowAiComment) {
                I2(qFSCommentInputWindowConfig);
            } else if (qFSCommentInputWindowConfig.isShowHalfScreenPicPanel) {
                y2();
            } else {
                this.G0 = true;
                h1(QFSBaseInputPopupWindow.U);
                D0(this.F, 200);
                e0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.this.t2();
                    }
                }, 200L);
            }
            com.tencent.biz.qqcircle.comment.wrapper.d dVar = this.H0;
            if (dVar != null) {
                dVar.c();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(18, G1(), true));
            ak.f83788a.a();
        } catch (Exception e16) {
            QLog.e("QFSBaseInputPopupWindow", 1, "[show] error: ", e16);
        }
    }

    public String M1() {
        return String.valueOf(this.E.hashCode());
    }

    public void N2(QCircleAtUpdateEvent qCircleAtUpdateEvent) {
        Intent intent;
        if (fb0.a.b("QFSBaseInputPopupWindowupdateAtUser", 500L)) {
            return;
        }
        if (qCircleAtUpdateEvent != null && (intent = qCircleAtUpdateEvent.mData) != null) {
            if (intent.getExtras() != null) {
                t1();
                S8(HostSelectMemberUtils.getResultList(qCircleAtUpdateEvent.mData));
            }
            this.R = false;
            D0(this.F, 200);
            return;
        }
        D0(this.F, 200);
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public boolean O2() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && (!qFSCommentInputWindowConfig.isAllowAiComment || !qFSCommentInputWindowConfig.needShowPublishIcon)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public boolean Of() {
        if (TextUtils.isEmpty(y1()) && TextUtils.isEmpty(C1())) {
            return false;
        }
        return true;
    }

    public void P2(String str, String str2) {
        WeakReference<Context> weakReference;
        if (!TextUtils.isEmpty(str) && (weakReference = this.D) != null && weakReference.get() != null) {
            Q2(str, str2);
        }
    }

    public void R2(String str) {
        if (this.f83963v0 != null && !TextUtils.isEmpty(str)) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(M1(), "comment_input_above_bar");
            this.f83963v0.A(str);
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public QFSCommentInputWindowConfig R4() {
        return this.f83942a0;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public String S8(List<HostSelectMemberUtils.QCircleResultData> list) {
        if (list == null || this.F == null) {
            return "";
        }
        if (list.size() == 0) {
            r0(true);
            return "";
        }
        t1();
        return m1(list, new ArrayList(), ((Object) this.F.getText()) + "", "", 0);
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public boolean V8(int i3) {
        int u36 = uq3.c.u3();
        if (this.F.getText().length() + i3 < u36 || n1(this.F.getText()) + i3 <= u36) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public void Z3(boolean z16) {
        this.R = z16;
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    public int d0() {
        return R.layout.g9j;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public o20.d d8() {
        return this.f83967z0;
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow, com.tencent.biz.qqcircle.widgets.comment.a, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        QLog.d("QFSBaseInputPopupWindow", 1, "dismiss. ");
        this.F0 = false;
        super.dismiss();
        com.tencent.biz.qqcircle.immersive.manager.e.a().clearGroup(M1(), "comment_input_above_bar");
        Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        com.tencent.biz.qqcircle.comment.wrapper.d dVar = this.H0;
        if (dVar != null) {
            dVar.a();
        }
        this.C0.clear();
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(18, G1(), false));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QFSCommentPicSelectEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    @NonNull
    public FeedCloudMeta$StFeed getFeed() {
        return this.f83965x0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    public float i0() {
        return super.i0() - this.f83948g0.getMeasuredWidth();
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public List<HostSelectMemberUtils.QCircleResultData> i9() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    public void initView() {
        super.initView();
        this.A0 = this.E.findViewById(R.id.u1m);
        this.B0 = this.E.findViewById(R.id.f3588132);
        this.f83949h0 = (RelativeLayout) this.E.findViewById(R.id.f95425ey);
        this.f83950i0 = (ImageButton) this.E.findViewById(R.id.tcm);
        this.f83951j0 = (ImageButton) this.E.findViewById(R.id.tfi);
        this.f83952k0 = (ImageButton) this.E.findViewById(R.id.ah5);
        this.f83953l0 = (ViewGroup) this.E.findViewById(R.id.f164677tg1);
        this.f83954m0 = (ImageButton) this.E.findViewById(R.id.tfz);
        this.f83955n0 = this.E.findViewById(R.id.tg8);
        this.f83956o0 = this.E.findViewById(R.id.teg);
        this.f83945d0 = (TextView) this.E.findViewById(R.id.f112576oa);
        this.f83944c0 = (LinearLayout) this.E.findViewById(R.id.f125037kz);
        this.f83946e0 = (TextView) this.E.findViewById(R.id.f112586ob);
        this.f83957p0 = (ImageView) this.E.findViewById(R.id.yce);
        this.f83948g0 = (LinearLayout) this.E.findViewById(R.id.f43981ny);
        this.f83947f0 = (LinearLayout) this.E.findViewById(R.id.yrk);
        QFSCommentPicPreview qFSCommentPicPreview = (QFSCommentPicPreview) this.E.findViewById(R.id.f371316f);
        this.f83963v0 = qFSCommentPicPreview;
        qFSCommentPicPreview.setHostProxy(this);
        i2();
        A2(this.f83951j0, I0);
    }

    protected void j2() {
        WeakReference<Context> weakReference = this.D;
        if (weakReference != null && weakReference.get() != null) {
            AbstractGifImage.resumeAll();
            a aVar = new a();
            ud2.a aVar2 = ud2.a.f438849a;
            boolean c16 = aVar2.c();
            if (MobileQQ.sProcessId == 1 && c16) {
                l1(aVar);
            }
            IEmoticonMainPanel iEmoticonMainPanel = this.f83943b0;
            if (iEmoticonMainPanel == null) {
                this.X = HostEmotionUtil.getEmojiPanel(this.D.get(), this.F, aVar, F1());
            } else {
                this.X = iEmoticonMainPanel.getView();
            }
            aVar2.j(G1());
            this.X.setVisibility(0);
            this.X.setBackgroundColor(QFSQUIUtilsKt.d(this.D.get(), R.color.qui_common_bg_middle_light));
            IEmoticonMainPanel iEmoticonMainPanel2 = this.f83943b0;
            if (iEmoticonMainPanel2 != null) {
                if (c16) {
                    iEmoticonMainPanel2.showAllTabs();
                    this.f83943b0.enableHorizontalScroll();
                } else {
                    iEmoticonMainPanel2.hideAllTabs();
                    this.f83943b0.disableHorizontalScroll();
                }
            }
            QLog.d("QFSBaseInputPopupWindow", 1, "[initEmojiPanel] ");
            g1(this.X);
        }
    }

    public void k1() {
        ImageView imageView = this.f83957p0;
        if (imageView == null) {
            return;
        }
        cm.c(imageView, QCirclePluginGlobalInfo.m());
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public boolean ka() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && !qFSCommentInputWindowConfig.needShowAtIcon) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    public void l0() {
        super.l0();
        this.f83949h0.setOnClickListener(this);
        this.f83952k0.setOnClickListener(this);
        this.f83954m0.setOnClickListener(this);
        this.f83950i0.setOnClickListener(this);
        this.f83951j0.setOnClickListener(this);
        k2();
        F2();
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public void m3(boolean z16) {
        boolean z17;
        QFSCommentHelper L = QFSCommentHelper.L();
        LinearLayout linearLayout = this.f83948g0;
        Button button = this.G;
        if (!z16 && this.F.getText().length() <= 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        L.l(linearLayout, button, z17, L1());
        o1(true);
        if (!z16 && QFSCommentRecPicClusterHelper.f83716a.J(G1())) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSRecPicStateEvent(3, G1()));
        } else if (!z16) {
            w2();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("QFSBaseInputPopupWindow", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z16;
        String str;
        QCircleReportBean qCircleReportBean;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSBaseInputPopupWindow" + view.getId())) {
            if ((view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("QFSBaseInputPopupWindow", 1, "onClick:" + view.getId());
            int id5 = view.getId();
            if (z16) {
                QLog.d("QFSBaseInputPopupWindow", 1, "btn_keyboard");
                c2(true, true);
                Z1(false);
                d2();
            } else if (id5 == R.id.ah5) {
                QLog.d("QFSBaseInputPopupWindow", 1, "btn_emotion");
                J2();
                ud2.a.f438849a.g();
                M2();
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentEmotionRedPointEvent());
            } else if (id5 != R.id.jha && id5 != R.id.f95425ey) {
                if (id5 == R.id.aiz) {
                    if (p1()) {
                        QCircleToast.o(M0, 0);
                    } else {
                        QFSBaseInputPopupWindow.b bVar = this.K;
                        if (bVar != null) {
                            bVar.a();
                        }
                    }
                } else if (id5 != R.id.tfi && id5 != R.id.f354011r) {
                    if (id5 == R.id.yns) {
                        QLog.d("QFSBaseInputPopupWindow", 1, "btn_ecommerce");
                        this.f83958q0 = true;
                        com.tencent.biz.qqcircle.helpers.l.e().g(this.f83965x0);
                        dismiss();
                    } else if (id5 == R.id.tfz) {
                        com.tencent.biz.qqcircle.comment.emoji.o.i(3);
                        this.f83955n0.setVisibility(8);
                        S1();
                    } else if (id5 == R.id.tcm) {
                        boolean c16 = uq3.k.a().c("sp_key_show_ai_comment_agreement_dialog", false);
                        v1(this.f83942a0);
                        if (!c16) {
                            Context context = getContext();
                            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.m
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    u.this.s2(dialogInterface, i3);
                                }
                            };
                            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
                            if (qFSCommentInputWindowConfig != null && (qCircleReportBean = qFSCommentInputWindowConfig.reportBean) != null) {
                                str = qCircleReportBean.getDtPageId();
                            } else {
                                str = "";
                            }
                            af.K(context, onClickListener, str);
                        } else {
                            I2(this.f83942a0);
                        }
                    }
                } else {
                    QLog.d("QFSBaseInputPopupWindow", 1, "btn_mention");
                    r0(true);
                }
            } else {
                QLog.d("QFSBaseInputPopupWindow", 1, "text_input");
                c2(true, true);
                Z1(false);
                d2();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("QFSBaseInputPopupWindow", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        uq3.k.b().m("sp_key_emoji_last_selected_emoji_tab", this.f83964w0);
        QFSCommentAtHelper.Q();
        com.tencent.biz.qqcircle.immersive.manager.e.a().clearGroup(M1(), "comment_input_above_bar");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            Q1();
        } else if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            U1((ASEngineTabStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSCommentPicSelectEvent) {
            P1((QFSCommentPicSelectEvent) simpleBaseEvent);
        }
    }

    protected boolean p1() {
        return V8(0);
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    public void r0(boolean z16) {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.isFullScreen) {
            QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f1905442d), 0, true, false);
        } else {
            if (!uq3.c.K()) {
                super.r0(z16);
                return;
            }
            if (z16) {
                this.F.getText().insert(this.F.getSelectionStart(), "@");
            }
            D0(this.F, 200);
        }
    }

    public void r1() {
        QFSCommentPicPreview qFSCommentPicPreview = this.f83963v0;
        if (qFSCommentPicPreview == null) {
            return;
        }
        qFSCommentPicPreview.k();
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public void showKeyboard() {
        D0(this.F, 0);
    }

    public void t1() {
        Iterator<com.tencent.biz.qqcircle.comment.abovebar.b> it = this.C0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.biz.qqcircle.comment.abovebar.b next = it.next();
            if (next instanceof QFSCommentRecStickersBar) {
                ((QFSCommentRecStickersBar) next).D();
                break;
            }
        }
        int t16 = af.t(this.F);
        int selectionStart = this.F.getSelectionStart();
        if (t16 >= 0 && selectionStart > t16 && !this.F.getText().toString().substring(t16, selectionStart).contains(" ")) {
            this.F.getEditableText().delete(t16, selectionStart);
        }
        for (com.tencent.biz.qqcircle.comment.abovebar.b bVar : this.C0) {
            if (bVar instanceof QFSCommentRecStickersBar) {
                ((QFSCommentRecStickersBar) bVar).r();
                return;
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public boolean wg() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.f83942a0;
        if (qFSCommentInputWindowConfig != null && qFSCommentInputWindowConfig.allowShowGoodsView && qFSCommentInputWindowConfig.commentInfo != null && com.tencent.biz.qqcircle.helpers.l.e().h(getFeed(), this.f83942a0.commentInfo.mComment, null) && TextUtils.isEmpty(this.f83942a0.goodsContent)) {
            return true;
        }
        return false;
    }

    public String y1() {
        QFSCommentPicPreview qFSCommentPicPreview = this.f83963v0;
        if (qFSCommentPicPreview == null) {
            return "";
        }
        return qFSCommentPicPreview.m();
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.a
    public c.b y9() {
        return new c.b() { // from class: com.tencent.biz.qqcircle.comment.s
            @Override // com.tencent.biz.qqcircle.comment.sticker.c.b
            public final void a(int i3, String str, String str2) {
                u.this.r2(i3, str, str2);
            }
        };
    }

    public String z1() {
        String o16 = this.f83963v0.o();
        if (TextUtils.isEmpty(o16)) {
            return HexUtil.bytes2HexStr(MD5.getFileMd5(A1()));
        }
        return o16;
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    protected void m0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z16;
            QFSCommentHelper L = QFSCommentHelper.L();
            u uVar = u.this;
            LinearLayout linearLayout = uVar.f83948g0;
            Button button = uVar.G;
            if (uVar.F.getText().length() <= 0 && !u.this.Of()) {
                z16 = false;
            } else {
                z16 = true;
            }
            L.l(linearLayout, button, z16, u.this.L1());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private int f83973d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f83974e = 0;

        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            if (u.this.p1()) {
                int i3 = this.f83973d;
                u.this.C0(editable.delete(i3, this.f83974e + i3));
                QCircleToast.o(u.M0, 0);
                return;
            }
            String obj = editable.toString();
            int i16 = this.f83973d;
            String substring = obj.substring(i16, this.f83974e + i16);
            u.this.T1(editable, substring);
            u.this.O1(editable, substring);
            u.this.v2();
            this.f83973d = 0;
            this.f83974e = 0;
            u.this.R1(editable);
            u.this.o1(!r5.D0);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null) {
                return;
            }
            this.f83973d = i3;
            this.f83974e = i17;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
