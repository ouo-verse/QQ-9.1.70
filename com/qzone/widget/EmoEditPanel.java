package com.qzone.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.business.qboss.QbossAdvDesc;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.QZoneBarrageEffectPanel;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.common.activities.base.QZoneSuperFontPanel;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.feed.business.model.QQEmoCommentDataManager;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.publish.service.PersonalFontService;
import com.qzone.publish.service.QzoneBarrageEffectService;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.reborn.widget.QZoneSoftHeightProvider;
import com.qzone.util.ToastUtil;
import com.qzone.util.ao;
import com.qzone.util.ap;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.font.IFontManager;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.DefaultBarrageEffectInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes37.dex */
public class EmoEditPanel extends RelativeLayout implements TextWatcher {
    public static al D1;
    private boolean A0;
    private String A1;
    private Activity B0;
    private int B1;
    private View C;
    private Handler C0;
    private am C1;
    private ViewGroup D;
    private com.qzone.widget.util.d D0;
    private RelativeLayout E;
    public boolean E0;
    private CaptureEditText F;
    private boolean F0;
    private TextView G;
    private boolean G0;
    private ImageView H;
    private boolean H0;
    private Button I;
    private String I0;
    private CheckBox J;
    private boolean J0;
    private ImageView K;
    private boolean K0;
    private View L;
    private int L0;
    private QZoneCheckBox M;
    private int M0;
    private QZoneCheckBox N;
    private QbossAdvDesc N0;
    private QbossAdvDesc O0;
    private LinearLayout P;
    private ImageView P0;
    private ImageView Q;
    private String Q0;
    private TextView R;
    private ImageView R0;
    private LinearLayout S;
    private ImageView S0;
    public RapidCommentEmoView T;
    private LinearLayout T0;
    private RedDotImageView U;
    private CheckBox U0;
    private RedDotImageView V;
    private TextView V0;
    private TextView W;
    private ImageView W0;
    private boolean X0;
    private QbossAdvDesc Y0;
    private String Z0;

    /* renamed from: a0, reason: collision with root package name */
    private QZoneFontTabView f60237a0;

    /* renamed from: a1, reason: collision with root package name */
    private int f60238a1;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f60239b0;

    /* renamed from: b1, reason: collision with root package name */
    private String f60240b1;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f60241c0;

    /* renamed from: c1, reason: collision with root package name */
    private int f60242c1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f60243d;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f60244d0;

    /* renamed from: d1, reason: collision with root package name */
    private int f60245d1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f60246e;

    /* renamed from: e0, reason: collision with root package name */
    private LinearLayout f60247e0;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f60248e1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f60249f;

    /* renamed from: f0, reason: collision with root package name */
    private ImageView f60250f0;

    /* renamed from: f1, reason: collision with root package name */
    private SharedPreferences f60251f1;

    /* renamed from: g0, reason: collision with root package name */
    private LinearLayout f60252g0;

    /* renamed from: g1, reason: collision with root package name */
    private int f60253g1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f60254h;

    /* renamed from: h0, reason: collision with root package name */
    private ImageView f60255h0;

    /* renamed from: h1, reason: collision with root package name */
    public String f60256h1;

    /* renamed from: i, reason: collision with root package name */
    private int f60257i;

    /* renamed from: i0, reason: collision with root package name */
    private LinearLayout f60258i0;

    /* renamed from: i1, reason: collision with root package name */
    private View.OnClickListener f60259i1;

    /* renamed from: j0, reason: collision with root package name */
    private View f60260j0;

    /* renamed from: j1, reason: collision with root package name */
    private Animation.AnimationListener f60261j1;

    /* renamed from: k0, reason: collision with root package name */
    private View f60262k0;

    /* renamed from: k1, reason: collision with root package name */
    private QZoneBarrageEffectPanel f60263k1;

    /* renamed from: l0, reason: collision with root package name */
    private int f60264l0;

    /* renamed from: l1, reason: collision with root package name */
    EmoticonCallback f60265l1;

    /* renamed from: m, reason: collision with root package name */
    private boolean f60266m;

    /* renamed from: m0, reason: collision with root package name */
    private int f60267m0;

    /* renamed from: m1, reason: collision with root package name */
    private View.OnClickListener f60268m1;

    /* renamed from: n0, reason: collision with root package name */
    private int f60269n0;

    /* renamed from: n1, reason: collision with root package name */
    private final View.OnClickListener f60270n1;

    /* renamed from: o0, reason: collision with root package name */
    private int f60271o0;

    /* renamed from: o1, reason: collision with root package name */
    private View.OnClickListener f60272o1;

    /* renamed from: p0, reason: collision with root package name */
    private int f60273p0;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f60274p1;

    /* renamed from: q0, reason: collision with root package name */
    private QZoneSoftHeightProvider f60275q0;

    /* renamed from: q1, reason: collision with root package name */
    private View.OnClickListener f60276q1;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f60277r0;

    /* renamed from: r1, reason: collision with root package name */
    private View.OnClickListener f60278r1;

    /* renamed from: s0, reason: collision with root package name */
    private ExtendGridView f60279s0;

    /* renamed from: s1, reason: collision with root package name */
    private View.OnClickListener f60280s1;

    /* renamed from: t0, reason: collision with root package name */
    private ag f60281t0;

    /* renamed from: t1, reason: collision with root package name */
    private View.OnClickListener f60282t1;

    /* renamed from: u0, reason: collision with root package name */
    private List<Friend> f60283u0;

    /* renamed from: u1, reason: collision with root package name */
    private View.OnClickListener f60284u1;

    /* renamed from: v0, reason: collision with root package name */
    private ai f60285v0;

    /* renamed from: v1, reason: collision with root package name */
    private int f60286v1;

    /* renamed from: w0, reason: collision with root package name */
    private ak f60287w0;

    /* renamed from: w1, reason: collision with root package name */
    private int f60288w1;

    /* renamed from: x0, reason: collision with root package name */
    private ah f60289x0;

    /* renamed from: x1, reason: collision with root package name */
    private String f60290x1;

    /* renamed from: y0, reason: collision with root package name */
    private int f60291y0;

    /* renamed from: y1, reason: collision with root package name */
    private int f60292y1;

    /* renamed from: z0, reason: collision with root package name */
    protected t5.a f60293z0;

    /* renamed from: z1, reason: collision with root package name */
    private int f60294z1;

    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(EmoEditPanel.this.Q0)) {
                if (((Integer) view.getTag()).intValue() == 0) {
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 2, 2), false, false);
                } else if (((Integer) view.getTag()).intValue() == 1) {
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 2, 4), false, false);
                }
                yo.d.b(EmoEditPanel.this.getContext(), new yo.g(EmoEditPanel.this.Q0));
                EmoEditPanel.this.Q0 = null;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    class aa implements View.OnClickListener {
        aa() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZLog.isColorLevel()) {
                QZLog.d("selPic", 2, "selPic clicked on EmoEditPanel");
            }
            if (EmoEditPanel.this.f60275q0 != null) {
                EmoEditPanel.this.f60275q0.d();
            }
            if (EmoEditPanel.this.f60289x0 != null) {
                EmoEditPanel.this.f60289x0.O();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    class ab implements View.OnClickListener {
        ab() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (EmoEditPanel.this.f60237a0 != null && EmoEditPanel.this.f60237a0.f45368i != null) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("selFont", 2, "selFont clicked on EmoEditPanel");
                }
                long j3 = LocalMultiProcConfig.getLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, -1L);
                long O = EmoEditPanel.this.f60237a0.f45368i.O();
                if (EmoEditPanel.this.U.f() && O > j3) {
                    LocalMultiProcConfig.putLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, O);
                }
                boolean z16 = false;
                EmoEditPanel.this.U.h(false);
                if (EmoEditPanel.this.f60237a0.getVisibility() == 0) {
                    EmoEditPanel.this.c1();
                } else {
                    EmoEditPanel.this.U0();
                    EmoEditPanel.this.a2();
                    if (EmoEditPanel.this.X0 && EmoEditPanel.this.Y0 != null && !TextUtils.isEmpty(EmoEditPanel.this.Y0.res_traceinfo)) {
                        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(EmoEditPanel.this.Y0.res_traceinfo, LoginData.getInstance().getUinString());
                    }
                    z16 = true;
                }
                if (EmoEditPanel.this.f60289x0 != null) {
                    EmoEditPanel.this.f60289x0.V(z16);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ac extends View.AccessibilityDelegate {
        ac() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ad implements View.OnClickListener {
        ad() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (EmoEditPanel.this.f60263k1 != null) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("selBarrageEffect", 2, "selBarrageEffect clicked on EmoEditPanel");
                }
                if (EmoEditPanel.this.f60263k1.getVisibility() == 0) {
                    EmoEditPanel.this.X0();
                    z16 = false;
                } else {
                    EmoEditPanel.this.U0();
                    EmoEditPanel.this.V1();
                    z16 = true;
                }
                if (EmoEditPanel.this.f60289x0 != null) {
                    EmoEditPanel.this.f60289x0.V(z16);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ae implements AdapterView.OnItemClickListener {
        ae() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (EmoEditPanel.this.f60281t0 != null) {
                EmoEditPanel.this.f60281t0.c(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class af implements QZoneSoftHeightProvider.a {
        af() {
        }

        @Override // com.qzone.reborn.widget.QZoneSoftHeightProvider.a
        public void a(boolean z16, int i3) {
            QLog.d("EmoEditPanel", 2, "onHeightChanged keyboardHeight=" + i3 + " isOpen=" + z16);
            if (z16) {
                EmoEditPanel.this.f60257i = 1;
                EmoEditPanel.this.o0(i3);
                EmoEditPanel.this.f60264l0 = i3;
            } else if (EmoEditPanel.this.f60257i == 1) {
                EmoEditPanel.this.o0(0);
            }
        }
    }

    /* loaded from: classes37.dex */
    public interface ah {
        void O();

        void Q1();

        void V(boolean z16);

        void f2();

        void onSend(String str);

        void p1();

        void r(boolean z16);
    }

    /* loaded from: classes37.dex */
    public interface ai {
        void onCancel(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public interface aj {
        void a(int i3);
    }

    /* loaded from: classes37.dex */
    public interface ak {
        void a(int i3);

        void onHide();
    }

    /* loaded from: classes37.dex */
    public static class al {

        /* renamed from: a, reason: collision with root package name */
        public final int f60313a;

        /* renamed from: b, reason: collision with root package name */
        public final BusinessFeedData f60314b;

        /* renamed from: c, reason: collision with root package name */
        public final int f60315c;

        public al(int i3, BusinessFeedData businessFeedData, int i16) {
            this.f60313a = i3;
            this.f60314b = businessFeedData;
            this.f60315c = i16;
        }
    }

    /* loaded from: classes37.dex */
    public interface am {
        void a(CharSequence charSequence, int i3, int i16, int i17);
    }

    /* loaded from: classes37.dex */
    class b extends AnimateUtils.AnimationAdapter {
        b() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            EmoEditPanel.this.y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements QZoneFontPanel.e {
        c() {
        }

        @Override // com.qzone.common.activities.base.QZoneFontPanel.e
        public void a(PersonalFontData.FontInfo fontInfo) {
            int i3;
            if (EmoEditPanel.this.f60237a0 != null && EmoEditPanel.this.f60237a0.f45369m != null && fontInfo != null && ((i3 = fontInfo.fontFormatType) == 3 || i3 == 4)) {
                EmoEditPanel.this.f60237a0.f45369m.l0();
                ((IFontManager) QRoute.api(IFontManager.class)).setDefaultSuperFont(LoginData.getInstance().getUin(), null);
            }
            if (fontInfo != null && fontInfo.f51895id > 0) {
                if (EmoEditPanel.this.M0 < 0) {
                    EmoEditPanel emoEditPanel = EmoEditPanel.this;
                    emoEditPanel.M0 = emoEditPanel.L0;
                }
                EmoEditPanel emoEditPanel2 = EmoEditPanel.this;
                emoEditPanel2.setEmoMaxLength(emoEditPanel2.M0);
            }
            if (EmoEditPanel.this.f60263k1 != null) {
                EmoEditPanel.this.f60263k1.k0();
            }
            if (TextUtils.isEmpty(EmoEditPanel.this.O0())) {
                return;
            }
            int i16 = fontInfo != null ? fontInfo.f51895id : -1;
            int i17 = fontInfo != null ? fontInfo.fontFormatType : -1;
            String str = fontInfo != null ? fontInfo.fontUrl : null;
            Intent intent = new Intent("FeedActionPanelActivity.font_select");
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID, i16);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE, i17);
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL, str);
            EmoEditPanel.this.B0.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements QZoneFontPanel.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f60318a;

        d(boolean z16) {
            this.f60318a = z16;
        }

        @Override // com.qzone.common.activities.base.QZoneFontPanel.f
        public void a() {
            if (this.f60318a) {
                ClickReport.c(604, 7, "1", true, new String[0]);
            } else {
                ClickReport.c(431, 9, "1", true, new String[0]);
            }
        }
    }

    /* loaded from: classes37.dex */
    class i implements EmoticonCallback {
        i() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (EmoEditPanel.this.F.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = EmoEditPanel.this.F.getText();
                int selectionStart = EmoEditPanel.this.F.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(EmoEditPanel.this.F.getText(), selectionStart);
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

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = EmoEditPanel.this.F.getSelectionStart();
                int selectionEnd = EmoEditPanel.this.F.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                if (emoticonInfo.type == 1) {
                    EmoEditPanel.this.F.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                } else {
                    EmoEditPanel.this.F.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getEmojiString(((SystemEmoticonInfo) emoticonInfo).code));
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class k extends HdAsyncAction {
        k(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            if (obj instanceof String) {
                ArrayList arrayList = new ArrayList();
                arrayList.add((String) obj);
                EmoEditPanel.this.T0(arrayList);
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class l extends HdAsyncAction {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RapidCommentExpressionInfo f60327a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Looper looper, RapidCommentExpressionInfo rapidCommentExpressionInfo) {
            super(looper);
            this.f60327a = rapidCommentExpressionInfo;
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            QQEmoCommentDataManager C = QQEmoCommentDataManager.C();
            RapidCommentExpressionInfo rapidCommentExpressionInfo = this.f60327a;
            return doNext(true, C.u(rapidCommentExpressionInfo.f60639d, Long.valueOf(rapidCommentExpressionInfo.f60640e)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class m implements aj {
        m() {
        }

        @Override // com.qzone.widget.EmoEditPanel.aj
        public void a(int i3) {
            LocalMultiProcConfig.putInt("EmoWindowHeight", i3);
            EmoEditPanel.this.f60267m0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class n implements aj {
        n() {
        }

        @Override // com.qzone.widget.EmoEditPanel.aj
        public void a(int i3) {
            LocalMultiProcConfig.putInt("FontPanelHeight", i3);
            EmoEditPanel.this.f60269n0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class o implements View.OnTouchListener {
        o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return false;
            }
            EmoEditPanel.this.U0();
            if (QZLog.isColorLevel()) {
                QZLog.e("EmoEditPanel", "Input View is focused\uff1a" + EmoEditPanel.this.L0().isFocused());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class p implements aj {
        p() {
        }

        @Override // com.qzone.widget.EmoEditPanel.aj
        public void a(int i3) {
            LocalMultiProcConfig.putInt("BarragePanelHeight", i3);
            EmoEditPanel.this.f60271o0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class q implements aj {
        q() {
        }

        @Override // com.qzone.widget.EmoEditPanel.aj
        public void a(int i3) {
            LocalMultiProcConfig.putInt("SharePanelHeight", i3);
            EmoEditPanel.this.f60273p0 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class r implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f60334d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ aj f60335e;

        r(ViewGroup viewGroup, aj ajVar) {
            this.f60334d = viewGroup;
            this.f60335e = ajVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (this.f60334d.getHeight() > 0) {
                EmoEditPanel.this.o0(this.f60334d.getHeight());
            }
            aj ajVar = this.f60335e;
            if (ajVar != null) {
                ajVar.a(this.f60334d.getHeight());
            }
            if (this.f60334d.getParent() != null) {
                this.f60334d.removeOnLayoutChangeListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class s extends AnimatorListenerAdapter {
        s() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            EmoEditPanel.this.f60239b0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class t extends AnimatorListenerAdapter {
        t() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            EmoEditPanel.this.f60285v0.onCancel(EmoEditPanel.this.F.getEditableText().toString());
        }
    }

    /* loaded from: classes37.dex */
    class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (EmoEditPanel.this.N != null) {
                EmoEditPanel.this.f60248e1 = !r0.f60248e1;
                if (EmoEditPanel.this.f60251f1 != null) {
                    EmoEditPanel.this.f60251f1.edit().putBoolean("forward_and_comment", EmoEditPanel.this.f60248e1).apply();
                }
                EmoEditPanel.this.R1();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.h_f && EmoEditPanel.this.f60289x0 != null) {
                EmoEditPanel.this.f60289x0.Q1();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    class w implements View.OnClickListener {
        w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            int G0 = EmoEditPanel.this.G0();
            int N0 = EmoEditPanel.this.N0();
            boolean m26 = EmoEditPanel.this.m2(G0, N0);
            if (G0 <= 0) {
                m26 = EmoEditPanel.this.f60277r0;
            }
            if (!m26) {
                QZLog.i("EmoEditPanel", "onClick: " + G0 + " " + N0 + " " + EmoEditPanel.this.f60277r0);
                if (G0 > 0) {
                    ToastUtil.s(com.qzone.util.l.a(R.string.m5r), 4);
                }
            } else {
                if (EmoEditPanel.D1 != null) {
                    ap apVar = ap.f59791b;
                    al alVar = EmoEditPanel.D1;
                    apVar.e(alVar.f60313a, 27, alVar.f60315c, alVar.f60314b);
                    EmoEditPanel.D1 = null;
                }
                if (EmoEditPanel.this.f60266m) {
                    if (EmoEditPanel.this.f60289x0 != null) {
                        EmoEditPanel.this.f60289x0.p1();
                        ClickReport.q("608", "6", "0", true);
                    }
                } else {
                    String B0 = EmoEditPanel.this.B0(EmoEditPanel.this.O0());
                    boolean z16 = EmoEditPanel.this.f60238a1 != 0;
                    if (TextUtils.isEmpty(B0) && !EmoEditPanel.this.f60277r0 && !z16) {
                        if (B0 != null && B0.length() == 0) {
                            EmoEditPanel.this.j2(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastInputIsNull", "\u8f93\u5165\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a"));
                        }
                    } else {
                        if (B0 == null) {
                            str = "";
                        } else {
                            str = B0.trim();
                        }
                        if (TextUtils.isEmpty(str) && !EmoEditPanel.this.f60277r0 && !z16) {
                            EmoEditPanel.this.j2(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastInputIsNull", "\u8f93\u5165\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a"));
                        } else {
                            if (z16 && TextUtils.isEmpty(B0)) {
                                B0 = "\u2000";
                            }
                            if (EmoEditPanel.this.f60289x0 != null) {
                                String replaceAll = EmoEditPanel.this.i0(B0).replaceAll(com.qzone.util.l.a(R.string.m5n), com.qzone.util.l.a(R.string.m5f)).replaceAll(com.qzone.util.l.a(R.string.m5i), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2192465w), "/chigua");
                                String a16 = com.qzone.util.g.a(QzoneEmotionUtils.splash2Emo(replaceAll));
                                if (!TextUtils.isEmpty(a16)) {
                                    a16 = a16.trim();
                                }
                                EmoEditPanel.this.f60289x0.onSend(a16);
                                if (TextUtils.isEmpty(replaceAll)) {
                                    LpReportInfo_pf00064.allReport(85, 1, 1);
                                } else {
                                    LpReportInfo_pf00064.allReport(85, 1, 2);
                                }
                            }
                            if (EmoEditPanel.this.f60274p1) {
                                if (!EmoEditPanel.this.f60266m) {
                                    EmoEditPanel.this.F.setText("");
                                    EmoEditPanel.this.r0();
                                }
                            } else {
                                EmoEditPanel.this.Y0(true, false);
                            }
                            EmoEditPanel.this.r0();
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    class x implements View.OnClickListener {
        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (EmoEditPanel.this.T.getVisibility() == 0) {
                EmoEditPanel.this.f60254h = false;
                EmoEditPanel.this.a1();
            } else {
                EmoEditPanel.this.f60254h = true;
                EmoEditPanel.this.U0();
                EmoEditPanel.this.Y1();
            }
            if (EmoEditPanel.this.f60289x0 != null) {
                EmoEditPanel.this.f60289x0.r(EmoEditPanel.this.f60254h);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class y implements View.OnClickListener {
        y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int selectionStart = EmoEditPanel.this.F.getSelectionStart();
            if (EmoEditPanel.this.f60238a1 > 0 && selectionStart < EmoEditPanel.this.f60238a1 && EmoEditPanel.this.F.length() >= EmoEditPanel.this.f60238a1) {
                EmoEditPanel.this.F.setSelection(EmoEditPanel.this.f60238a1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    class z implements View.OnClickListener {
        z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZLog.isColorLevel()) {
                QZLog.d("ClickTest", 2, "\u597d\u53cb\u9009\u62e9\u5668 onClick");
            }
            if (!EmoEditPanel.this.B0.getIntent().getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.KEY_AT_CLICK_HIDE_KEYBOARD, false)) {
                EmoEditPanel.this.U0();
                EmoEditPanel.this.F.requestFocus();
            }
            if (EmoEditPanel.this.f60289x0 != null) {
                EmoEditPanel.this.f60289x0.f2();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public EmoEditPanel(Context context) {
        super(context);
        this.f60243d = true;
        this.f60246e = true;
        this.f60249f = false;
        this.f60257i = 0;
        this.f60266m = false;
        this.f60277r0 = false;
        this.f60283u0 = new ArrayList();
        this.f60293z0 = new t5.a();
        this.A0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.H0 = false;
        this.J0 = true;
        this.L0 = 0;
        this.M0 = -1;
        this.X0 = false;
        this.f60238a1 = 0;
        this.f60242c1 = -1;
        this.f60245d1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "CommentMaxInputCnt", 600);
        this.f60259i1 = new a();
        this.f60261j1 = new b();
        this.f60265l1 = new i();
        this.f60268m1 = new j();
        this.f60270n1 = new u();
        this.f60272o1 = new v();
        this.f60274p1 = false;
        this.f60276q1 = new w();
        this.f60278r1 = new x();
        this.f60280s1 = new z();
        this.f60282t1 = new aa();
        this.f60284u1 = new ab();
        this.f60286v1 = -1;
        this.f60288w1 = -1;
        this.f60290x1 = "";
        this.f60292y1 = -1;
        this.f60294z1 = -1;
        this.A1 = "";
        this.B1 = 0;
        this.C1 = null;
    }

    private void A0() {
        if (!this.A0) {
            throw new IllegalStateException("please call initUI() first");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B0(String str) {
        if (TextUtils.isEmpty(str) || this.f60238a1 <= 0) {
            return str;
        }
        int length = str.length();
        int i3 = this.f60238a1;
        return length >= i3 ? str.substring(i3) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G0() {
        Editable editableText;
        CaptureEditText captureEditText = this.F;
        if (captureEditText == null || (editableText = captureEditText.getEditableText()) == null) {
            return 0;
        }
        return editableText.length();
    }

    private void H1() {
        m2(G0(), N0());
        this.I.setEnabled(true);
        this.I.setSelected(true);
    }

    private void I1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("content");
            String optString2 = jSONObject.optString("emotion");
            int optInt = jSONObject.optInt("count", 0);
            L0().setText(optString);
            L0().setSelection(optString.length());
            if (optString2 != null && optInt > 0) {
                setLikeComment(optString2, optInt);
            }
            H1();
        } catch (JSONException e16) {
            QZLog.d("EmoEditPanel", 4, "parseCancheAndSet: " + e16.getMessage(), e16);
        }
    }

    private void K1() {
        RapidCommentEmoView rapidCommentEmoView = this.T;
        if (rapidCommentEmoView != null && rapidCommentEmoView.getVisibility() == 0) {
            this.T.setVisibility(8);
        }
        QZoneFontTabView qZoneFontTabView = this.f60237a0;
        if (qZoneFontTabView != null && qZoneFontTabView.getVisibility() == 0) {
            this.f60237a0.setVisibility(8);
        }
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel = this.f60263k1;
        if (qZoneBarrageEffectPanel != null && qZoneBarrageEffectPanel.getVisibility() == 0) {
            this.f60263k1.setVisibility(8);
        }
        LinearLayout linearLayout = this.f60239b0;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.f60239b0.setVisibility(8);
    }

    private void M1() {
        this.A1 = "";
        this.f60292y1 = -1;
        this.f60294z1 = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int N0() {
        int i3 = this.L0;
        return i3 > 0 ? i3 : this.f60245d1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String O0() {
        QQTextBuilder qQTextBuilder;
        CaptureEditText captureEditText = this.F;
        if (captureEditText == null) {
            return "";
        }
        if ((captureEditText.getText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) this.F.getText()) != null) {
            return qQTextBuilder.toPlainText();
        }
        return this.F.getEditableText().toString();
    }

    private boolean Q1(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.I0 = str;
        int lastIndexOf = str.lastIndexOf("<{@QzOnEaT@}>");
        if (lastIndexOf != -1) {
            String substring = str.substring(lastIndexOf + 13);
            if (lastIndexOf == 0) {
                return false;
            }
            str = str.substring(0, lastIndexOf);
            i2(substring);
        }
        I1(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1() {
        QZoneCheckBox qZoneCheckBox = this.N;
        if (qZoneCheckBox == null) {
            return;
        }
        qZoneCheckBox.setChecked(this.f60248e1);
        LinearLayout linearLayout = this.P;
        if (linearLayout != null) {
            linearLayout.setContentDescription(BaseApplicationImpl.sApplication.getResources().getString(this.f60248e1 ? R.string.f2194166c : R.string.f2194266d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(ArrayList<String> arrayList) {
        Intent intent = this.B0.getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("contentIntentKey", "");
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IMAGELIST_CONTENT_INTENT, arrayList);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, "");
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, y1());
        Y0(false, true);
        this.B0.setResult(-1, intent);
        this.B0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i0(String str) {
        if (str == null) {
            return "";
        }
        List<Friend> list = this.f60283u0;
        if (list != null && list.size() != 0) {
            for (Friend friend : this.f60283u0) {
                String str2 = friend.mName;
                if (str2 == null) {
                    str2 = friend.mUin + "";
                }
                String str3 = "@{uin:" + friend.mUin + ",nick:" + str2.replace("%", "%25").replace(",", "%2C").replace("}", "%7D") + "}";
                String str4 = "@" + com.qzone.common.activities.base.aj.m(friend.mName);
                if (!TextUtils.isEmpty(friend.mName) && str.contains(str4)) {
                    str = com.qzone.util.am.j(str4, str, str3);
                }
            }
        }
        return str;
    }

    private void i2(String str) {
        int i3;
        int i16;
        int i17;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i18 = 0;
        this.B1 = 0;
        List<Friend> list = this.f60283u0;
        if (list == null) {
            this.f60283u0 = new ArrayList();
        } else {
            list.clear();
        }
        while (true) {
            int indexOf = str.indexOf("@{uin:", i18);
            int indexOf2 = str.indexOf(",", i18);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 < (i3 = indexOf + 6)) {
                return;
            }
            int i19 = indexOf2 + 1;
            long parseLong = Long.parseLong(str.substring(i3, indexOf2));
            if (parseLong < 10001) {
                i18 = i19;
            } else {
                int indexOf3 = str.indexOf("nick:", i19);
                int indexOf4 = str.indexOf("}", i19);
                if (indexOf3 == -1 || indexOf4 == -1 || indexOf4 < (i16 = indexOf3 + 5)) {
                    return;
                }
                int i26 = indexOf4 + 1;
                String replace = str.substring(i16, indexOf4).replace("%2C", ",").replace("%7D", "}").replace("%25", "%");
                Friend friend = new Friend();
                friend.mUin = parseLong;
                friend.mName = replace;
                String str2 = "@" + replace;
                if (this.B1 < str2.length()) {
                    i17 = str2.length();
                } else {
                    i17 = this.B1;
                }
                this.B1 = i17;
                this.f60283u0.add(friend);
                i18 = i26;
            }
        }
    }

    private int j1(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return Math.max(str.indexOf("\u25a2"), str.lastIndexOf("\u2000"));
    }

    private void l0(Activity activity, int i3, boolean z16, boolean z17) {
        QZoneFontPanel qZoneFontPanel;
        QZoneFontTabView qZoneFontTabView;
        QZoneFontPanel qZoneFontPanel2;
        QZoneFontTabView qZoneFontTabView2 = new QZoneFontTabView(activity, null, this.F, LoginData.getInstance().getUin());
        this.f60237a0 = qZoneFontTabView2;
        qZoneFontTabView2.setOrientation(1);
        this.f60237a0.setVisibility(8);
        RelativeLayout relativeLayout = this.E;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f60237a0, new LinearLayout.LayoutParams(-1, -2));
        }
        if (i3 > 0) {
            this.f60237a0.setSelectFontId(i3);
        }
        this.f60237a0.f(B1(), z17);
        this.f60237a0.setFontItemClickListener(new c());
        if (!PersonalFontService.K().M() && (qZoneFontTabView = this.f60237a0) != null && (qZoneFontPanel2 = qZoneFontTabView.f45368i) != null) {
            qZoneFontPanel2.d0(true);
        }
        QZoneFontTabView qZoneFontTabView3 = this.f60237a0;
        if (qZoneFontTabView3 != null && (qZoneFontPanel = qZoneFontTabView3.f45368i) != null) {
            qZoneFontPanel.setReportCallback(new d(z16));
        }
        if (D1()) {
            this.f60237a0.h();
            this.f60237a0.setSuperFontItemClickListener(new f());
        }
        if (C1()) {
            this.f60237a0.g();
        }
    }

    private void l1() {
        this.f60267m0 = LocalMultiProcConfig.getInt("EmoWindowHeight", 0);
        this.f60269n0 = LocalMultiProcConfig.getInt("FontPanelHeight", 0);
        this.f60271o0 = LocalMultiProcConfig.getInt("BarragePanelHeight", 0);
        this.f60273p0 = LocalMultiProcConfig.getInt("SharePanelHeight", 0);
    }

    private void l2(int i3) {
        String q06;
        if (TextUtils.isEmpty(F0().f())) {
            return;
        }
        List<Friend> list = this.f60283u0;
        String str = "";
        if (list != null && list.size() > 0 && (q06 = q0()) != null) {
            str = q06;
        }
        F0().j(K0(), str, i3);
    }

    private void m1(final QbossAdvDesc qbossAdvDesc) {
        VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.9
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (LoginData.getInstance().isQzoneVip()) {
                    str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_svUJcaCyIZ.png";
                } else {
                    str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_eiEc6zwDkg.png";
                }
                File imageFile = ImageLoader.getInstance().getImageFile(str);
                if (imageFile != null && imageFile.exists()) {
                    EmoEditPanel.this.B0.runOnUiThread(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            EmoEditPanel.this.m0(qbossAdvDesc);
                        }
                    });
                } else {
                    ImageLoader.getInstance().loadImage(str, (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m2(int i3, int i16) {
        TextView textView = this.W;
        if (textView == null) {
            return i3 <= i16;
        }
        if (i3 < i16 - 10) {
            textView.setVisibility(8);
            return true;
        }
        if (i3 <= i16) {
            textView.setTextColor(-12071520);
            this.W.setText(com.qzone.util.l.a(R.string.m5j) + (i16 - i3) + com.qzone.util.l.a(R.string.m5k));
            this.W.setVisibility(0);
            return true;
        }
        textView.setTextColor(-43705);
        this.W.setText(com.qzone.util.l.a(R.string.m5h) + (i3 - i16) + com.qzone.util.l.a(R.string.m5l));
        this.W.setVisibility(0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        if (this.B0 == null || this.D == null) {
            return;
        }
        QZoneSoftHeightProvider f16 = new QZoneSoftHeightProvider(this.B0, this.D).f();
        this.f60275q0 = f16;
        this.f60264l0 = f16.e();
        this.f60275q0.i(new af());
    }

    private String q0() {
        return com.qzone.common.activities.base.aj.d(this.f60283u0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        List<Friend> list = this.f60283u0;
        if (list != null) {
            list.clear();
        }
    }

    private boolean r1() {
        String str;
        return (this.f60292y1 == -1 || this.f60294z1 == -1 || (str = this.A1) == null || str.length() <= 0) ? false : true;
    }

    private boolean s1() {
        return false;
    }

    private void t0(int i3) {
        this.F.getEditableText().delete(0, i3);
        this.f60238a1 = 0;
        this.f60242c1 = 0;
        this.f60240b1 = null;
    }

    private boolean v1(String str, boolean z16) {
        List<Friend> list;
        if ((r1() || !z16) && (list = this.f60283u0) != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Friend friend = this.f60283u0.get(i3);
                if (friend != null && friend.mName != null && str != null) {
                    if (!str.equalsIgnoreCase("@" + friend.mName)) {
                        if (str.equalsIgnoreCase("@" + friend.mName + " ")) {
                        }
                    }
                    if (!z16) {
                        return true;
                    }
                    this.f60283u0.remove(i3);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean w1() {
        if (s1()) {
            int length = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str = EmotcationConstants.SYS_EMOTICON_SYMBOL[i3];
                if (str != null && str.equalsIgnoreCase(this.f60290x1)) {
                    return true;
                }
                String str2 = this.f60290x1;
                if (str2 != null && str2.equalsIgnoreCase(com.qzone.util.l.a(R.string.m5o))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean A1() {
        CheckBox checkBox = this.J;
        return checkBox != null && checkBox.isChecked();
    }

    protected boolean B1() {
        return false;
    }

    protected boolean C1() {
        return false;
    }

    public int D0() {
        View view = this.C;
        if (view != null) {
            return view.getBottom();
        }
        return 0;
    }

    protected boolean D1() {
        return this.f60243d;
    }

    public ArrayList<String> E0() {
        return this.f60281t0.f60311d;
    }

    public t5.a F0() {
        if (this.f60293z0 == null) {
            this.f60293z0 = new t5.a();
        }
        return this.f60293z0;
    }

    public void F1() {
        c2();
        L1();
    }

    public int H0() {
        return this.f60242c1;
    }

    public String I0() {
        return this.f60240b1;
    }

    public String J0() {
        A0();
        return B0(this.F.getEditableText().toString());
    }

    public void J1() {
        CaptureEditText captureEditText = this.F;
        if (captureEditText != null) {
            captureEditText.setClickable(true);
            this.F.setFocusable(true);
            this.F.setFocusableInTouchMode(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String K0() {
        boolean z16;
        String J0 = J0();
        JSONObject jSONObject = new JSONObject();
        boolean z17 = true;
        try {
            z16 = false;
            if (!TextUtils.isEmpty(J0)) {
                jSONObject.put("content", J0);
                z17 = false;
            }
        } catch (JSONException e16) {
            QZLog.d("EmoEditPanel", 4, "getEditContentForCache: " + e16.getMessage(), e16);
        }
        if (this.f60242c1 > 0 && !TextUtils.isEmpty(this.f60240b1)) {
            jSONObject.put("emotion", this.f60240b1);
            jSONObject.put("count", this.f60242c1);
            if (z16) {
                return jSONObject.toString();
            }
            return null;
        }
        z16 = z17;
        if (z16) {
        }
    }

    public EditText L0() {
        A0();
        return this.F;
    }

    public void L1() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.34
            @Override // java.lang.Runnable
            public void run() {
                if (EmoEditPanel.this.f60275q0 != null && !EmoEditPanel.this.f60275q0.isShowing()) {
                    EmoEditPanel.this.n1();
                }
                if (EmoEditPanel.this.f60257i != 1) {
                    return;
                }
                EmoEditPanel.this.g2();
            }
        }, com.qzone.reborn.configx.g.f53821a.k().n());
    }

    public String P0() {
        String str;
        String O0 = O0();
        String str2 = "";
        if (TextUtils.isEmpty(O0) && !this.f60277r0) {
            return "";
        }
        if (O0 == null) {
            str = "";
        } else {
            str = O0.trim();
        }
        if (TextUtils.isEmpty(str) && !this.f60277r0) {
            return "";
        }
        int i3 = this.L0;
        if (i3 <= 0) {
            i3 = QZoneConfigHelper.a0();
        }
        if (J0().length() > i3) {
            return "";
        }
        if (this.f60289x0 != null) {
            str2 = com.qzone.util.g.a(QzoneEmotionUtils.splash2Emo(i0(O0).replaceAll(com.qzone.util.l.a(R.string.m5g), com.qzone.util.l.a(R.string.m5p)).replaceAll(com.qzone.util.l.a(R.string.m5m), "/MM")));
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.trim();
            }
        }
        r0();
        return str2;
    }

    public boolean P1() {
        return Q1(F0().d());
    }

    public QzoneBarrageEffectData.BarrageEffectInfo Q0() {
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel = this.f60263k1;
        if (qZoneBarrageEffectPanel == null) {
            return null;
        }
        qZoneBarrageEffectPanel.X();
        return this.f60263k1.F();
    }

    public PersonalFontData.FontInfo R0() {
        QZoneFontPanel qZoneFontPanel;
        QZoneFontTabView qZoneFontTabView = this.f60237a0;
        if (qZoneFontTabView == null || (qZoneFontPanel = qZoneFontTabView.f45368i) == null) {
            return null;
        }
        qZoneFontPanel.g0();
        return this.f60237a0.f45368i.R();
    }

    public QzoneSuperPersonalFontData.SuperFontInfo S0() {
        QZoneSuperFontPanel qZoneSuperFontPanel;
        QZoneFontTabView qZoneFontTabView = this.f60237a0;
        if (qZoneFontTabView == null || (qZoneSuperFontPanel = qZoneFontTabView.f45369m) == null) {
            return null;
        }
        qZoneSuperFontPanel.X();
        return this.f60237a0.f45369m.I();
    }

    public void T1() {
        View view = this.L;
        if (view == null || this.K0) {
            return;
        }
        view.setVisibility(0);
    }

    public void U0() {
        int i3 = this.f60257i;
        if (i3 == 2) {
            a1();
            return;
        }
        if (i3 == 3) {
            c1();
            return;
        }
        if (i3 == 4) {
            X0();
        } else if (i3 != 5) {
            g2();
        } else {
            h1();
        }
    }

    public void U1(int i3, boolean z16) {
        RedDotImageView redDotImageView = this.V;
        if (redDotImageView != null) {
            redDotImageView.setVisibility(0);
            if (this.f60263k1 == null) {
                j0(this.B0, i3, z16);
            }
        }
    }

    public void V0() {
        View view = this.L;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void V1() {
        if (this.f60257i == 4 || this.f60263k1 == null) {
            return;
        }
        this.f60257i = 4;
        ao.a(getContext(), this.F);
        this.V.setImageResource(R.drawable.qui_keyboard_circle);
        this.V.setContentDescription(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2202768o));
        ak akVar = this.f60287w0;
        if (akVar != null) {
            akVar.onHide();
        }
        this.f60263k1.setVisibility(0);
        p0(this.f60263k1, this.f60271o0, new p());
    }

    public void W1(String str, String str2) {
        this.f60256h1 = str2;
        QZoneSoftHeightProvider qZoneSoftHeightProvider = this.f60275q0;
        if (qZoneSoftHeightProvider != null && qZoneSoftHeightProvider.e() == 0) {
            this.F.clearFocus();
        }
        if (!this.G0) {
            this.F.requestFocus();
            this.C.setVisibility(8);
            postDelayed(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.27
                @Override // java.lang.Runnable
                public void run() {
                    EmoEditPanel.this.C.setVisibility(0);
                    if (EmoEditPanel.this.D0 != null) {
                        EmoEditPanel.this.D0.a(EmoEditPanel.this.C);
                    }
                    EmoEditPanel emoEditPanel = EmoEditPanel.this;
                    emoEditPanel.o0(emoEditPanel.f60264l0);
                }
            }, 20L);
        }
        if (this.T.getVisibility() != 0) {
            this.F.setHint("");
            if (!TextUtils.isEmpty(str)) {
                this.F.setHint(com.qzone.util.g.a(str));
            } else {
                this.F.setHint(R.string.glb);
            }
        }
    }

    public void X0() {
        this.f60263k1.setVisibility(8);
        this.V.setImageResource(R.drawable.qui_special_effect);
        this.V.setContentDescription(BaseApplicationImpl.sApplication.getResources().getString(R.string.gqb));
        if (this.C.getVisibility() == 0) {
            g2();
        }
    }

    public void X1() {
        ImageView imageView = this.K;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void Y0(boolean z16, boolean z17) {
        if (QZLog.isColorLevel()) {
            QZLog.e("EmoEditPanel", "hideCommentWindow");
        }
        if (this.C.getVisibility() == 0) {
            ao.a(getContext(), this.F);
            ak akVar = this.f60287w0;
            if (akVar != null) {
                akVar.onHide();
            }
            l2(1);
            if (!this.f60266m) {
                this.F.setText("");
            }
            if (!z16 && !this.f60266m) {
                r0();
            }
            this.B1 = 0;
        }
        if (this.f60285v0 != null && !z16 && !z17) {
            com.qzone.widget.util.d dVar = this.D0;
            if (dVar != null) {
                dVar.b(this.C, null);
                this.D0.f(this, new t());
                return;
            }
            return;
        }
        if (this.C.getVisibility() == 0) {
            this.K.setImageResource(R.drawable.qui_emoticon);
            this.C.setVisibility(8);
        }
        RapidCommentEmoView rapidCommentEmoView = this.T;
        if (rapidCommentEmoView != null && rapidCommentEmoView.getVisibility() == 0) {
            this.K.setImageResource(R.drawable.qui_emoticon);
            this.T.setVisibility(8);
        }
        ImageView imageView = this.P0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        LinearLayout linearLayout = this.f60239b0;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            return;
        }
        this.f60239b0.setVisibility(8);
    }

    public void Y1() {
        if (this.f60257i == 2 || this.T == null) {
            return;
        }
        if (this.G0) {
            this.F.requestFocus();
        }
        this.f60257i = 2;
        ao.a(getContext(), this.F);
        this.K.setImageResource(R.drawable.qui_keyboard_circle);
        this.K.setContentDescription(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2202768o));
        this.T.setVisibility(0);
        this.T.l();
        ClickReport.n("", "", "", LoginData.getInstance().getUin(), true, 359, 1, 2);
        p0(this.T, this.f60267m0, new m());
    }

    public void Z0() {
        ImageView imageView = this.K;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void Z1(int i3, boolean z16, boolean z17) {
        QZoneFontPanel qZoneFontPanel;
        RedDotImageView redDotImageView = this.U;
        if (redDotImageView != null) {
            redDotImageView.setVisibility(0);
            QZoneFontTabView qZoneFontTabView = this.f60237a0;
            if (qZoneFontTabView == null || qZoneFontTabView.f45368i == null) {
                l0(this.B0, i3, z16, z17);
                QZoneFontTabView qZoneFontTabView2 = this.f60237a0;
                if (qZoneFontTabView2 == null || (qZoneFontPanel = qZoneFontTabView2.f45368i) == null) {
                    return;
                }
                if (LocalMultiProcConfig.getLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, -1L) < qZoneFontPanel.O()) {
                    this.U.h(true);
                }
            }
        }
    }

    public void a1() {
        this.T.setVisibility(8);
        this.K.setImageResource(R.drawable.qui_emoticon);
        this.K.setContentDescription(BaseApplicationImpl.sApplication.getResources().getString(R.string.gq9));
        if (this.C.getVisibility() == 0) {
            g2();
        }
    }

    public void a2() {
        QZoneFontPanel qZoneFontPanel;
        if (this.f60257i == 3 || this.f60237a0 == null) {
            return;
        }
        this.f60257i = 3;
        ao.a(getContext(), this.F);
        if (!PersonalFontService.K().M() && (qZoneFontPanel = this.f60237a0.f45368i) != null) {
            qZoneFontPanel.d0(true);
        }
        this.U.clearAsyncImage();
        this.U.setImageResource(R.drawable.qui_keyboard_circle);
        this.U.setContentDescription(BaseApplicationImpl.sApplication.getResources().getString(R.string.f2202768o));
        ak akVar = this.f60287w0;
        if (akVar != null && !(this.B0 instanceof FeedActionPanelActivity)) {
            akVar.onHide();
        }
        this.f60237a0.setVisibility(0);
        p0(this.f60237a0, this.f60269n0, new n());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.J0) {
            l2(2);
        }
    }

    public void b1() {
        RedDotImageView redDotImageView = this.U;
        if (redDotImageView != null) {
            redDotImageView.setVisibility(8);
        }
    }

    public void b2() {
        if (this.N != null) {
            SharedPreferences sharedPreferences = this.f60251f1;
            if (sharedPreferences != null) {
                this.f60248e1 = sharedPreferences.getBoolean("forward_and_comment", true);
            }
            this.N.setVisibility(0);
            this.R.setVisibility(0);
            R1();
        }
    }

    public void c1() {
        this.f60237a0.setVisibility(8);
        setFontIconChange();
        if (this.C.getVisibility() == 0) {
            g2();
        }
    }

    public void c2() {
        if (this.f60249f) {
            return;
        }
        this.f60249f = true;
        postDelayed(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.13
            @Override // java.lang.Runnable
            public void run() {
                EmoEditPanel.this.k2();
            }
        }, 300L);
    }

    public void d1() {
        QZoneCheckBox qZoneCheckBox = this.N;
        if (qZoneCheckBox != null) {
            this.f60248e1 = false;
            qZoneCheckBox.setVisibility(8);
            this.R.setVisibility(8);
        }
    }

    public void e2() {
        LinearLayout linearLayout = this.S;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    public void f1() {
        ImageView imageView = this.R0;
        if (imageView == null || this.S0 == null || this.T0 == null) {
            return;
        }
        imageView.setVisibility(8);
        this.S0.setVisibility(8);
        this.T0.setVisibility(8);
    }

    public void f2() {
        if (this.f60257i == 5 || this.f60239b0 == null) {
            return;
        }
        this.f60257i = 5;
        this.F.clearFocus();
        ao.a(getContext(), this.F);
        this.I.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionPanelForward", "\u53d1\u9001"));
        this.C.setVisibility(0);
        this.f60260j0.setVisibility(0);
        this.f60239b0.setVisibility(0);
        com.qzone.widget.util.d dVar = this.D0;
        if (dVar != null) {
            dVar.a(this.C);
            this.D0.a(this.f60239b0);
            this.D0.e(this, null);
        }
        p0(this.f60239b0, this.f60273p0, new q());
    }

    public void g1() {
        LinearLayout linearLayout = this.S;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void g2() {
        if (this.B0.isFinishing() || this.B0.isDestroyed()) {
            return;
        }
        this.F.requestFocus();
        this.f60257i = 1;
        K1();
        ao.c(getContext(), this.F);
    }

    public void h1() {
        com.qzone.widget.util.d dVar = this.D0;
        if (dVar != null) {
            dVar.b(this.f60239b0, new s());
        }
        this.I.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ActionPanelSend", "\u53d1\u9001"));
        if (this.C.getVisibility() != 0 || this.f60254h) {
            return;
        }
        g2();
    }

    public void h2() {
        ImageView imageView = this.Q;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void i1() {
        ImageView imageView = this.Q;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void j0(Activity activity, int i3, boolean z16) {
        QZoneBarrageEffectPanel qZoneBarrageEffectPanel = new QZoneBarrageEffectPanel(activity, this.F, LoginData.getInstance().getUin());
        this.f60263k1 = qZoneBarrageEffectPanel;
        qZoneBarrageEffectPanel.setVisibility(8);
        RelativeLayout relativeLayout = this.E;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f60263k1, 0, new LinearLayout.LayoutParams(-1, (int) (ViewUtils.getScreenWidth() * 0.67f)));
        }
        if (i3 > 0) {
            this.f60263k1.d0(i3);
        }
        DefaultBarrageEffectInfo defaultBarrageEffectInfo = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultBarrageEffectInfo(LoginData.getInstance().getUin());
        if (defaultBarrageEffectInfo != null && defaultBarrageEffectInfo.itemId > 0) {
            if (this.M0 < 0) {
                this.M0 = this.L0;
            }
            setEmoMaxLength(QZoneConfigHelper.Y());
        }
        this.f60263k1.setFontItemClickListener(new g());
        if (!QzoneBarrageEffectService.G().H()) {
            this.f60263k1.U(true);
        }
        this.f60263k1.setReportCallback(new h());
    }

    protected void j2(String str) {
        ToastUtil.r(str);
    }

    public void k1(final QbossAdvDesc qbossAdvDesc) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.11
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (qbossAdvDesc != null) {
                    try {
                        str = new JSONObject(qbossAdvDesc.res_data).getString("img");
                    } catch (Exception unused) {
                        str = "";
                    }
                    File imageFile = ImageLoader.getInstance().getImageFile(str);
                    if (imageFile == null || !imageFile.exists()) {
                        return;
                    }
                    ImageLoader.getInstance().loadImage(str, (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
                    QZLog.i("EmoEditPanel", "initGifCommentIcon \u6587\u4ef6\u4e0d\u5b58\u5728\uff0c\u4f5c\u9884\u4e0b\u8f7d");
                }
            }
        });
    }

    public void n0(Activity activity) {
        if (this.f60239b0 != null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.bg_, (ViewGroup) null);
        this.f60239b0 = linearLayout;
        linearLayout.setVisibility(8);
        this.f60241c0 = (LinearLayout) this.f60239b0.findViewById(R.id.f163924ci);
        this.f60244d0 = (ImageView) this.f60239b0.findViewById(R.id.s9u);
        this.f60247e0 = (LinearLayout) this.f60239b0.findViewById(R.id.f163925cj);
        this.f60250f0 = (ImageView) this.f60239b0.findViewById(R.id.s9w);
        this.f60252g0 = (LinearLayout) this.f60239b0.findViewById(R.id.f163926ck);
        this.f60255h0 = (ImageView) this.f60239b0.findViewById(R.id.s9v);
        RelativeLayout relativeLayout = this.E;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f60239b0, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void o0(int i3) {
        if (this.D0 == null || this.B0.isFinishing() || this.B0.isDestroyed()) {
            return;
        }
        this.D0.c(this.f60262k0, i3);
    }

    public void o1(Activity activity, boolean z16, boolean z17, boolean z18, boolean z19) {
        ImageView imageView;
        this.B0 = activity;
        this.G0 = z19;
        this.C0 = new Handler();
        this.D0 = new com.qzone.widget.util.d();
        this.F0 = true;
        this.f60251f1 = activity.getSharedPreferences("Qzone_Emo_Edit", 0);
        this.D = (ViewGroup) activity.findViewById(R.id.f166479fi1);
        this.C = findViewById(R.id.h8v);
        if (QQTheme.isNowThemeIsNightForQzone() && this.C.findViewById(R.id.bmt) != null) {
            this.C.findViewById(R.id.bmt).setVisibility(8);
        }
        this.F = (CaptureEditText) findViewById(R.id.h_0);
        this.E = (RelativeLayout) findViewById(R.id.hgm);
        this.F.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        this.M = (QZoneCheckBox) findViewById(R.id.h_h);
        this.S = (LinearLayout) findViewById(R.id.h_f);
        this.G = (TextView) findViewById(R.id.h_j);
        this.H = (ImageView) findViewById(R.id.h_l);
        this.T0 = (LinearLayout) findViewById(R.id.h_g);
        this.R0 = (ImageView) findViewById(R.id.h9m);
        this.S0 = (ImageView) findViewById(R.id.h8o);
        this.U0 = (CheckBox) findViewById(R.id.h_i);
        this.V0 = (TextView) findViewById(R.id.h_k);
        this.W0 = (ImageView) findViewById(R.id.h_m);
        this.W = (TextView) findViewById(R.id.h8w);
        this.f60258i0 = (LinearLayout) findViewById(R.id.bgj);
        this.f60262k0 = findViewById(R.id.f67803eb);
        this.f60260j0 = findViewById(R.id.f67723e4);
        n1();
        l1();
        f1();
        if (Build.VERSION.SDK_INT >= 31) {
            J1();
        }
        this.F.setLayerType(1, null);
        this.F.addTextChangedListener(this);
        this.F.setContainer(this);
        this.F.setOnTouchListener(new o());
        this.F.setOnClickListener(new y());
        Button button = (Button) findViewById(R.id.h8u);
        this.I = button;
        button.setGravity(17);
        this.I.setOnClickListener(this.f60276q1);
        LinearLayout linearLayout = this.S;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this.f60272o1);
        }
        this.I.setEnabled(false);
        this.I.setSelected(false);
        this.I.setAccessibilityDelegate(new ac());
        if (QQTheme.isVasTheme()) {
            this.I.setBackgroundResource(R.drawable.ldf);
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.f68583gf);
        this.P = linearLayout2;
        linearLayout2.setOnClickListener(this.f60270n1);
        this.N = (QZoneCheckBox) findViewById(R.id.h9n);
        TextView textView = (TextView) findViewById(R.id.h9o);
        this.R = textView;
        textView.setFocusable(false);
        k0(z16, z17, z18);
        ImageView imageView2 = (ImageView) findViewById(R.id.h9g);
        this.K = imageView2;
        imageView2.setOnClickListener(this.f60278r1);
        View findViewById = findViewById(R.id.h8m);
        this.L = findViewById;
        findViewById.setOnClickListener(this.f60280s1);
        ImageView imageView3 = (ImageView) findViewById(R.id.h_d);
        this.Q = imageView3;
        imageView3.setOnClickListener(this.f60282t1);
        rn.h.a(this.Q, "qui_image", R.color.qui_common_icon_primary);
        RedDotImageView redDotImageView = (RedDotImageView) findViewById(R.id.h9l);
        this.U = redDotImageView;
        redDotImageView.setOffSet(ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(2.0f));
        setQbossFontIconGif(m5.a.H().G());
        this.U.setOnClickListener(this.f60284u1);
        RedDotImageView redDotImageView2 = (RedDotImageView) findViewById(R.id.h8n);
        this.V = redDotImageView2;
        redDotImageView2.setOnClickListener(new ad());
        this.A0 = true;
        this.C.post(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.6
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                EmoEditPanel.this.I.getHitRect(rect);
                rect.top -= 20;
                rect.left -= 20;
                rect.right += 20;
                rect.bottom += 20;
                TouchDelegate touchDelegate = new TouchDelegate(rect, EmoEditPanel.this.I);
                if (View.class.isInstance(EmoEditPanel.this.I.getParent())) {
                    ((View) EmoEditPanel.this.I.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
        this.f60281t0 = new ag();
        ExtendGridView extendGridView = (ExtendGridView) findViewById(R.id.dek);
        this.f60279s0 = extendGridView;
        ((RelativeLayout.LayoutParams) extendGridView.getLayoutParams()).addRule(2, R.id.h8v);
        this.f60279s0.setAdapter((ListAdapter) this.f60281t0);
        this.f60279s0.setOnItemClickListener(new ae());
        v0();
        if (this.S == null || !p1() || (imageView = (ImageView) this.S.findViewById(R.id.h_l)) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        View view = this.C;
        if (view == null) {
            return;
        }
        int top = view.getTop();
        int i19 = this.f60253g1;
        if (top == 0) {
            this.f60253g1 = top;
            return;
        }
        if (top == i19) {
            return;
        }
        this.f60253g1 = top;
        if (top > i19 && getHeight() == this.f60291y0) {
            ak akVar = this.f60287w0;
            if (akVar != null) {
                akVar.onHide();
            }
        } else if (this.f60287w0 != null && this.C.getHeight() + this.C.getTop() + ViewUtils.dpToPx(50.0f) < ViewUtils.getScreenHeight()) {
            this.f60287w0.a(top);
        }
        this.f60291y0 = getHeight();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        String obj;
        int j16;
        String str;
        this.F.removeTextChangedListener(this);
        if (charSequence == null) {
            this.F.addTextChangedListener(this);
            N1();
            M1();
            return;
        }
        if ((!this.F0 || (str = this.I0) == null || !str.startsWith("@")) && !this.H0 && this.f60289x0 != null && i17 == 1 && i16 == 0 && charSequence.toString().substring(i3, i3 + 1).equals("@")) {
            if (QZLog.isColorLevel()) {
                QZLog.d("ClickTest", 2, "\u8f93\u5165@\u547c\u8d77\u597d\u53cb\u9009\u62e9\u5668");
            }
            a1();
            this.E0 = true;
            this.f60289x0.f2();
        }
        this.F0 = false;
        if (w1()) {
            this.F.getEditableText().delete(this.f60286v1, this.f60288w1);
        }
        if (v1(this.A1, false)) {
            this.F.getEditableText().delete(this.f60292y1, this.f60294z1);
        }
        int i18 = this.f60238a1;
        if (i18 > 0 && i3 <= i18 - 1 && (j16 = j1((obj = this.F.getEditableText().toString()))) > -1) {
            int i19 = j16 + 1;
            if (!("\u25a2x" + this.f60242c1 + "\u2000|\u2000").equals(obj.substring(0, i19))) {
                t0(Math.max(i19, i3 + i17));
            }
        }
        N1();
        M1();
        H1();
        am amVar = this.C1;
        if (amVar != null) {
            amVar.a(charSequence, i3, i16, i17);
        }
        this.F.addTextChangedListener(this);
    }

    public boolean p1() {
        return FontSettingManager.getFontLevel() > 17.0f;
    }

    public boolean q1() {
        return this.C.getVisibility() == 0;
    }

    public void s0() {
        String str;
        if (TextUtils.isEmpty(F0().f())) {
            return;
        }
        List<Friend> list = this.f60283u0;
        if (list == null || list.size() <= 0 || (str = q0()) == null) {
            str = "";
        }
        F0().j("", str, 1);
    }

    public void setAllowEmpty(boolean z16) {
        Button button;
        QZLog.i("EmoEditPanel", "setAllowEmpty: " + z16);
        this.f60277r0 = z16;
        if (!z16 || (button = this.I) == null) {
            return;
        }
        button.setEnabled(true);
        this.I.setSelected(true);
    }

    public void setAtqunUser(boolean z16) {
        this.K0 = z16;
    }

    public void setEmoMaxLength(int i3) {
        this.L0 = i3;
        H1();
    }

    public void setFontIconChange() {
        try {
            RedDotImageView redDotImageView = this.U;
            if (redDotImageView == null) {
                return;
            }
            redDotImageView.setContentDescription(BaseApplicationImpl.sApplication.getResources().getString(R.string.gqw));
            if (this.Y0 != null && this.X0 && !TextUtils.isEmpty(this.Z0)) {
                if (this.Z0.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) && !m5.a.H().I()) {
                    this.U.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.U.setPlayingGif(true);
                    this.U.setNeedGifStream(true);
                    this.U.setAsyncImageListener(new AsyncImageable.AsyncImageListener() { // from class: com.qzone.widget.EmoEditPanel.12
                        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                        public void onImageFailed(AsyncImageable asyncImageable) {
                            EmoEditPanel.this.B0.runOnUiThread(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.12.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    EmoEditPanel.this.U.setPlayingGif(false);
                                    EmoEditPanel.this.U.setNeedGifStream(false);
                                    EmoEditPanel.this.U.setImageResource(R.drawable.qui_aa_method);
                                }
                            });
                        }

                        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                        public void onImageLoaded(AsyncImageable asyncImageable) {
                            if (asyncImageable == null || !(asyncImageable.getDrawable() instanceof NewGifDrawable)) {
                                return;
                            }
                            NewGifDrawable newGifDrawable = (NewGifDrawable) asyncImageable.getDrawable();
                            newGifDrawable.setLoopCount(1);
                            newGifDrawable.setGifPlayListener(new a());
                        }

                        /* renamed from: com.qzone.widget.EmoEditPanel$12$a */
                        /* loaded from: classes37.dex */
                        class a implements NewGifDrawable.GifPlayListener {
                            a() {
                            }

                            @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                            public void onGifStartPlay(NewGifDrawable newGifDrawable) {
                                QZLog.i("EmoEditPanel", "onGifStartPlay");
                            }

                            @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                            public void onGifStopPlay(NewGifDrawable newGifDrawable) {
                                QZLog.i("EmoEditPanel", "onGifStopPlay");
                                newGifDrawable.stop();
                                m5.a.H().M(true);
                                newGifDrawable.recycleForGifPlay();
                                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(EmoEditPanel.this.Y0.res_traceinfo, LoginData.getInstance().getUinString());
                            }

                            @Override // com.tencent.component.media.gif.NewGifDrawable.GifPlayListener
                            public void onGifPlaying(NewGifDrawable newGifDrawable) {
                            }
                        }

                        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                        public void onImageStarted(AsyncImageable asyncImageable) {
                        }

                        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
                        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
                        }
                    });
                    QZLog.i("EmoEditPanel", "\u64ad\u653egif");
                } else {
                    if (!this.Z0.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                        if (!m5.a.H().I()) {
                            m5.a.H().M(true);
                            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.Y0.res_traceinfo, LoginData.getInstance().getUinString());
                        }
                        this.U.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    } else {
                        this.U.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                    this.U.setNeedGifStream(false);
                    QZLog.i("EmoEditPanel", "\u64ad\u653e\u9759\u6001\u56fe");
                }
                QZLog.i("EmoEditPanel", "fontgifurl =" + this.Z0);
                this.U.getImageOption().needCache = false;
                this.U.setAsyncImage(this.Z0);
                return;
            }
            QZLog.i("EmoEditPanel", "setdefualicon");
            this.U.setImageResource(R.drawable.qui_aa_method);
        } catch (Exception unused) {
        }
    }

    public void setForbiddenInputAt(boolean z16) {
        this.H0 = z16;
    }

    public void setFriendOnly(List<Friend> list) {
        if (list != null) {
            this.f60283u0.addAll(list);
            return;
        }
        throw new NullPointerException("Friend List is null");
    }

    public void setIsShowFont(boolean z16) {
        QZLog.i("EmoEditPanel", "isShowFontType =" + z16);
        this.X0 = z16;
    }

    public void setNeedSuperFont(boolean z16) {
        this.f60243d = z16;
    }

    public void setOnCancelCallback(ai aiVar) {
        this.f60285v0 = aiVar;
    }

    public void setOnPanelClickCallBack(ah ahVar) {
        this.f60289x0 = ahVar;
    }

    public void setOnShareClickCallBack(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.f60241c0;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        }
        LinearLayout linearLayout2 = this.f60247e0;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(onClickListener);
        }
        LinearLayout linearLayout3 = this.f60252g0;
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(onClickListener);
        }
    }

    public void setPicCommentVisiblity(boolean z16) {
        ImageView imageView = this.Q;
        if (imageView != null) {
            if (z16) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
                this.f60279s0.setVisibility(8);
            }
        }
    }

    public void setPrivData(String str) {
        if (!this.f60266m || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.I == null) {
            Button button = (Button) findViewById(R.id.h8u);
            this.I = button;
            button.setOnClickListener(this.f60276q1);
        }
        this.I.setText(str);
    }

    public void setPrivateIconChecked(boolean z16) {
        QZoneCheckBox qZoneCheckBox = this.M;
        if (qZoneCheckBox != null) {
            qZoneCheckBox.setChecked(z16);
            if (z16) {
                com.qzone.adapter.feedcomponent.i.H().W1("357", "1", "1");
            } else {
                com.qzone.adapter.feedcomponent.i.H().W1("357", "1", "2");
            }
        }
    }

    public void setQbossFontIconGif(QbossAdvDesc qbossAdvDesc) {
        this.Y0 = qbossAdvDesc;
        if (qbossAdvDesc != null) {
            try {
                this.Z0 = new JSONObject(qbossAdvDesc.res_data).getString("img");
                setFontIconChange();
            } catch (Exception unused) {
            }
        }
    }

    public void setSendBtnText(String str) {
        Button button = this.I;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setShareIconAlpha(BusinessFeedData businessFeedData) {
        if (com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask, 14)) {
            O1(this.f60241c0, 1.0f);
            S1(this.f60241c0, true);
        } else {
            O1(this.f60241c0, 0.3f);
            S1(this.f60241c0, false);
        }
        if (businessFeedData.getVideoInfo() != null) {
            businessFeedData.getLocalInfo();
        }
        if (com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask, 13)) {
            O1(this.f60247e0, 1.0f);
            O1(this.f60252g0, 1.0f);
            S1(this.f60247e0, true);
            S1(this.f60252g0, true);
            return;
        }
        O1(this.f60247e0, 0.3f);
        O1(this.f60252g0, 0.3f);
        S1(this.f60247e0, false);
        S1(this.f60252g0, false);
    }

    public void setStateChangeCallback(ak akVar) {
        this.f60287w0 = akVar;
    }

    public void setTextOutSideWatcher(am amVar) {
        this.C1 = amVar;
    }

    public void setUpdateCacheInternal(boolean z16) {
        this.J0 = z16;
    }

    public void setVideoEditMode(boolean z16, boolean z17, boolean z18) {
        this.f60266m = z16;
        if (z16) {
            if (this.I == null) {
                Button button = (Button) findViewById(R.id.h8u);
                this.I = button;
                button.setOnClickListener(this.f60276q1);
            }
            if (z17) {
                this.I.setVisibility(8);
                if (this.J == null) {
                    CheckBox checkBox = (CheckBox) findViewById(R.id.f166675ha3);
                    this.J = checkBox;
                    checkBox.setOnCheckedChangeListener(new e());
                }
                this.J.setChecked(z18);
                this.J.setVisibility(0);
                return;
            }
            this.I.setEnabled(true);
            setAllowEmpty(true);
        }
    }

    public boolean t1() {
        RapidCommentEmoView rapidCommentEmoView = this.T;
        return rapidCommentEmoView != null && rapidCommentEmoView.getVisibility() == 0;
    }

    public boolean u1() {
        return this.f60248e1;
    }

    public void v0() {
        if (this.K0) {
            this.L.setVisibility(8);
            this.T0.setVisibility(8);
            this.U0.setVisibility(8);
            this.V0.setVisibility(8);
            this.W0.setVisibility(8);
            this.S.setVisibility(8);
        }
    }

    public void x0() {
        QZoneSoftHeightProvider qZoneSoftHeightProvider = this.f60275q0;
        if (qZoneSoftHeightProvider != null) {
            qZoneSoftHeightProvider.d();
        }
        com.qzone.widget.util.d dVar = this.D0;
        if (dVar != null) {
            dVar.g();
        }
        ao.a(getContext(), this.F);
    }

    public boolean x1() {
        ExtendGridView extendGridView = this.f60279s0;
        return extendGridView != null && extendGridView.getVisibility() == 0;
    }

    public boolean y1() {
        QZoneCheckBox qZoneCheckBox = this.M;
        if (qZoneCheckBox != null) {
            return qZoneCheckBox.isChecked();
        }
        return false;
    }

    public void z0(boolean z16) {
        this.f60274p1 = z16;
    }

    public boolean z1() {
        LinearLayout linearLayout = this.f60239b0;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class g implements QZoneBarrageEffectPanel.b {
        g() {
        }

        @Override // com.qzone.common.activities.base.QZoneBarrageEffectPanel.b
        public void onClick(int i3) {
            if (i3 <= 0) {
                if (EmoEditPanel.this.M0 < 0) {
                    EmoEditPanel emoEditPanel = EmoEditPanel.this;
                    emoEditPanel.M0 = emoEditPanel.L0;
                }
                EmoEditPanel emoEditPanel2 = EmoEditPanel.this;
                emoEditPanel2.setEmoMaxLength(emoEditPanel2.M0);
                return;
            }
            if (EmoEditPanel.this.M0 < 0) {
                EmoEditPanel emoEditPanel3 = EmoEditPanel.this;
                emoEditPanel3.M0 = emoEditPanel3.L0;
            }
            EmoEditPanel.this.setEmoMaxLength(QZoneConfigHelper.Y());
            if (EmoEditPanel.this.f60237a0 != null && EmoEditPanel.this.f60237a0.f45369m != null) {
                EmoEditPanel.this.f60237a0.f45369m.l0();
            }
            if (EmoEditPanel.this.f60237a0 == null || EmoEditPanel.this.f60237a0.f45368i == null) {
                return;
            }
            EmoEditPanel.this.f60237a0.f45368i.y0();
        }

        @Override // com.qzone.common.activities.base.QZoneBarrageEffectPanel.b
        public void a(int i3) {
        }
    }

    private void N1() {
        this.f60286v1 = -1;
        this.f60288w1 = -1;
        this.f60290x1 = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.P0 = null;
        if (this.R0 != null) {
            this.T0.setVisibility(8);
            this.R0.setVisibility(8);
            this.S0.setVisibility(8);
        }
    }

    public void W0() {
        this.f60246e = false;
        RedDotImageView redDotImageView = this.V;
        if (redDotImageView != null) {
            redDotImageView.setVisibility(8);
        }
    }

    public void u0() {
        this.C1 = null;
    }

    /* loaded from: classes37.dex */
    public class ag extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<String> f60311d;

        public ag() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(int i3) {
            ArrayList<String> arrayList = this.f60311d;
            if (arrayList == null || arrayList.size() <= i3) {
                return;
            }
            this.f60311d.remove(i3);
            EmoEditPanel.this.setAllowEmpty(!this.f60311d.isEmpty());
            e();
            notifyDataSetChanged();
        }

        private void e() {
            if (getCount() <= 0) {
                EmoEditPanel.this.f60279s0.setVisibility(8);
                EmoEditPanel.this.B0.findViewById(R.id.f166479fi1).setBackgroundColor(0);
            }
            int left = EmoEditPanel.this.Q.getLeft() - ((int) (ViewUtils.getDensity() * 6.0f));
            int dimensionPixelSize = EmoEditPanel.this.getResources().getDimensionPixelSize(R.dimen.f158794p3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) EmoEditPanel.this.f60279s0.getLayoutParams();
            marginLayoutParams.width = (dimensionPixelSize * getCount()) + (EmoEditPanel.this.getResources().getDimensionPixelSize(R.dimen.f158795p4) * 2);
            marginLayoutParams.setMargins(left, 0, 0, 0);
            EmoEditPanel.this.f60279s0.setLayoutParams(marginLayoutParams);
            EmoEditPanel.this.f60279s0.setNumColumns(getCount());
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getItem(int i3) {
            ArrayList<String> arrayList = this.f60311d;
            if (arrayList == null || arrayList.size() <= i3) {
                return null;
            }
            return this.f60311d.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<String> arrayList = this.f60311d;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public void d(ArrayList<String> arrayList) {
            if (arrayList == null) {
                return;
            }
            this.f60311d = arrayList;
            e();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View inflate = view == null ? EmoEditPanel.this.B0.getLayoutInflater().inflate(R.layout.bgg, (ViewGroup) null) : view;
            AsyncImageView asyncImageView = (AsyncImageView) inflate.findViewById(R.id.f166844im4);
            int dimensionPixelSize = EmoEditPanel.this.getResources().getDimensionPixelSize(R.dimen.f158794p3);
            int dimensionPixelSize2 = EmoEditPanel.this.getResources().getDimensionPixelSize(R.dimen.f158793p2);
            asyncImageView.setTag(null);
            String item = getItem(i3);
            if (item != null) {
                asyncImageView.setNeedGifStream(false);
                asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                asyncImageView.setAdjustViewBounds(false);
                asyncImageView.applyDefaultImage();
                asyncImageView.setAsyncImage(item);
                asyncImageView.setTag(item);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            }
            inflate.setLayoutParams(layoutParams);
            inflate.setContentDescription(com.qzone.util.l.a(R.string.m5q) + (i3 + 1) + com.qzone.util.l.a(R.string.m5e));
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        int i3;
        if (this.P0 == null || this.R0 == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(280L);
        alphaAnimation.setFillAfter(true);
        this.R0.startAnimation(alphaAnimation);
        this.U.setVisibility(0);
        if (this.V == null || !this.f60246e) {
            i3 = 0;
        } else {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(280L);
            alphaAnimation2.setStartOffset(80);
            alphaAnimation2.setFillAfter(true);
            this.S0.startAnimation(alphaAnimation2);
            this.V.setVisibility(0);
            i3 = 80;
        }
        int i16 = i3 + 80;
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation3.setDuration(280L);
        alphaAnimation3.setStartOffset(i16);
        alphaAnimation3.setFillAfter(true);
        this.U0.startAnimation(alphaAnimation3);
        this.M.setVisibility(0);
        AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation4.setDuration(280L);
        alphaAnimation4.setStartOffset(i16 + 80);
        alphaAnimation4.setFillAfter(true);
        this.V0.startAnimation(alphaAnimation4);
        this.G.setVisibility(0);
        this.H.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
        animationSet.setDuration(280L);
        animationSet.setStartOffset(r1 + 80);
        animationSet.setFillAfter(true);
        this.P0.startAnimation(animationSet);
        animationSet.setAnimationListener(this.f60261j1);
        removeView(this.P0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2() {
        int i3;
        if (this.P0 != null) {
            if ((this.N0 == null && this.O0 == null) || this.R0 == null) {
                return;
            }
            int[] iArr = new int[2];
            this.C.getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            getLocationInWindow(iArr2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            layoutParams.topMargin = ((iArr[1] - iArr2[1]) - ar.e(43.0f)) - getPaddingTop();
            layoutParams.leftMargin = (getWidth() - ar.e(15.0f)) - ar.e(228.0f);
            this.T0.setVisibility(this.K0 ? 8 : 0);
            this.U.setVisibility(8);
            this.R0.setVisibility(0);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(280L);
            this.R0.startAnimation(scaleAnimation);
            RedDotImageView redDotImageView = this.V;
            if (redDotImageView == null || !this.f60246e) {
                i3 = 80;
            } else {
                redDotImageView.setVisibility(8);
                this.S0.setVisibility(0);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(280L);
                scaleAnimation2.setStartOffset(80);
                this.S0.startAnimation(scaleAnimation2);
                i3 = 160;
            }
            this.M.setVisibility(8);
            this.U0.setVisibility(0);
            ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(280L);
            scaleAnimation3.setStartOffset(i3);
            this.U0.startAnimation(scaleAnimation3);
            int i16 = i3 + 80;
            this.G.setVisibility(8);
            this.V0.setVisibility(0);
            ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation4.setDuration(280L);
            scaleAnimation4.setStartOffset(i16);
            this.V0.startAnimation(scaleAnimation4);
            int i17 = i16 + 80;
            this.H.setVisibility(8);
            this.W0.setVisibility(0);
            ScaleAnimation scaleAnimation5 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation5.setDuration(280L);
            scaleAnimation5.setStartOffset(i17);
            this.W0.startAnimation(scaleAnimation5);
            int i18 = i17 + 80;
            this.P0.setVisibility(0);
            this.P0.setOnClickListener(LoginData.getInstance().isQzoneVip() ? null : this.f60259i1);
            this.P0.setTag(Integer.valueOf(this.N0 != null ? 0 : 1));
            this.P0.requestLayout();
            ScaleAnimation scaleAnimation6 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation6.setDuration(280L);
            scaleAnimation6.setStartOffset(i18);
            this.P0.startAnimation(scaleAnimation6);
            VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.14
                @Override // java.lang.Runnable
                public void run() {
                    if (EmoEditPanel.this.N0 == null) {
                        if (EmoEditPanel.this.O0 != null) {
                            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 1, 4), false, false);
                            m5.a.H().C(LoginData.getInstance().getUinString(), 2864);
                            EmoEditPanel.this.O0 = null;
                            return;
                        }
                        return;
                    }
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(225, 1, 2), false, false);
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(EmoEditPanel.this.N0.res_traceinfo, LoginData.getInstance().getUinString());
                    m5.a.H().C(LoginData.getInstance().getUinString(), 2655);
                    EmoEditPanel.this.N0 = null;
                }
            });
            postDelayed(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.15
                @Override // java.lang.Runnable
                public void run() {
                    EmoEditPanel.this.e1();
                }
            }, 2660L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(QbossAdvDesc qbossAdvDesc) {
        String str;
        if (qbossAdvDesc != null) {
            this.P0 = new ImageView(getContext());
            if (LoginData.getInstance().isQzoneVip()) {
                str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_svUJcaCyIZ.png";
            } else {
                str = "https://qzonestyle.gtimg.cn/aoi/sola/20190924213435_eiEc6zwDkg.png";
            }
            try {
                this.Q0 = new JSONObject(qbossAdvDesc.res_data).optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            Drawable loadImage = ImageLoader.getInstance().loadImage(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.widget.EmoEditPanel.10
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str2, final Drawable drawable, ImageLoader.Options options) {
                    if (EmoEditPanel.this.B0 != null) {
                        EmoEditPanel.this.B0.runOnUiThread(new Runnable() { // from class: com.qzone.widget.EmoEditPanel.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (EmoEditPanel.this.P0 != null) {
                                    EmoEditPanel.this.P0.setImageDrawable(drawable);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str2, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str2, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                }
            });
            if (loadImage != null) {
                this.P0.setImageDrawable(loadImage);
            }
            addView(this.P0, new RelativeLayout.LayoutParams(ar.e(228.0f), ar.e(43.0f)));
            this.P0.setVisibility(8);
        }
    }

    public void d2(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.f60279s0.setVisibility(0);
            this.f60281t0.d(arrayList);
        } else if (this.f60281t0.getCount() <= 0) {
            this.f60279s0.setVisibility(8);
        }
    }

    public void setFriendOnly(Friend friend) {
        if (friend != null) {
            this.f60283u0.add(friend);
            return;
        }
        throw new NullPointerException("Friend List is null");
    }

    /* loaded from: classes37.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag() instanceof RapidCommentExpressionInfo) {
                RapidCommentExpressionInfo rapidCommentExpressionInfo = (RapidCommentExpressionInfo) view.getTag();
                String str = rapidCommentExpressionInfo.f60639d;
                long j3 = rapidCommentExpressionInfo.f60640e;
                ClickReport.j(LoginData.getInstance().getUin(), "", "", "", true, "359", "2", str + "_" + j3, "", "", str, Long.toString(j3));
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_EMOTICON_COMMENT, QzoneConfig.SECONDARY_USE_QQ_EMOTICON_COMMENT, 0) == 0) {
                    EmoEditPanel.this.w0(rapidCommentExpressionInfo);
                } else {
                    Intent intent = EmoEditPanel.this.B0.getIntent();
                    if (intent == null) {
                        intent = new Intent();
                    }
                    intent.putExtra("contentIntentKey", "");
                    intent.putExtra("rapidCommentCommitInfo", rapidCommentExpressionInfo);
                    intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, "");
                    intent.putExtra("isRapidComment", true);
                    intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_PRIVATE_COMMENT, EmoEditPanel.this.y1());
                    EmoEditPanel.this.Y0(false, true);
                    EmoEditPanel.this.B0.setResult(-1, intent);
                    EmoEditPanel.this.B0.finish();
                }
                if ("fav_tab_id".equals(rapidCommentExpressionInfo.f60639d)) {
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(431, 12, 2), false, true);
                    com.tencent.mobileqq.webview.util.y.a(LoginData.getInstance().getUinString(), null, null, null, 0, 0L, "ep_mall", "send_collection", "0", 0, 0, 1, null, "", "1", null, null);
                } else {
                    LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(431, 12, 5), false, true);
                    com.tencent.mobileqq.webview.util.y.a(LoginData.getInstance().getUinString(), null, null, null, 0, 0L, "ep_mall", "send_emoticon", "0", 0, 0, 1, null, rapidCommentExpressionInfo.f60639d, "1", null, null);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private int C0(CharSequence charSequence, int i3) {
        if (charSequence != null && charSequence.length() > 1) {
            int length = charSequence.length() > i3 ? i3 : charSequence.length();
            for (int i16 = 1; length >= 0 && i16 <= this.B1; i16++) {
                if (charSequence.charAt(length) == '@' && v1(charSequence.toString().substring(length, i3 + 1), false)) {
                    return length;
                }
                length--;
            }
        }
        return -1;
    }

    private void O1(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    private void S1(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setEnabled(z16);
    }

    private void k0(boolean z16, boolean z17, boolean z18) {
        RapidCommentEmoView rapidCommentEmoView = (RapidCommentEmoView) findViewById(R.id.hvd);
        this.T = rapidCommentEmoView;
        rapidCommentEmoView.setIsActionPanel(true);
        this.T.i(this.B0, true, this.f60265l1, z16, this.f60268m1, z17, z18);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        RelativeLayout relativeLayout = this.E;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            View view = this.f60262k0;
            if (view != null) {
                this.E.addView(view);
            }
            this.E.addView(this.T, layoutParams);
        }
        this.T.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        if (rapidCommentExpressionInfo == null) {
            return;
        }
        HdAsync.with(this).then(new l(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), rapidCommentExpressionInfo)).then(new k(Looper.getMainLooper())).call();
    }

    public void E1(Intent intent) {
        CaptureEditText captureEditText;
        int i3;
        CaptureEditText captureEditText2;
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        if (this.E0 && (captureEditText2 = this.F) != null) {
            int selectionStart = captureEditText2.getSelectionStart();
            Editable editableText = this.F.getEditableText();
            int i16 = selectionStart - 1;
            if (editableText.toString().substring(i16, selectionStart).equals("@")) {
                editableText.delete(i16, selectionStart);
            }
            this.E0 = false;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
        if (parcelableArrayListExtra != null) {
            Iterator it = parcelableArrayListExtra.iterator();
            String str = "";
            while (it.hasNext()) {
                ResultRecord resultRecord = (ResultRecord) it.next();
                Friend friend = new Friend();
                if (!TextUtils.isEmpty(resultRecord.name)) {
                    friend.mName = resultRecord.name;
                } else {
                    friend.mName = resultRecord.uin;
                }
                try {
                    long longValue = Long.valueOf(resultRecord.uin).longValue();
                    friend.mUin = longValue;
                    if (friend.mName != null && longValue != 0) {
                        if (this.f60283u0 == null) {
                            this.f60283u0 = new ArrayList();
                        }
                        this.f60283u0.add(friend);
                        String str2 = "@" + friend.mName + " ";
                        str = str + str2;
                        if (this.B1 < str2.length()) {
                            i3 = str2.length();
                        } else {
                            i3 = this.B1;
                        }
                        this.B1 = i3;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            if (TextUtils.isEmpty(str) || (captureEditText = this.F) == null) {
                return;
            }
            com.qzone.util.am.g(str, captureEditText.getSelectionStart(), this.F);
        }
    }

    public void setLikeComment(String str, int i3) {
        if (str == null) {
            return;
        }
        String str2 = this.f60240b1;
        int i16 = this.f60242c1;
        this.f60242c1 = i3;
        this.f60240b1 = str;
        if (str2 != null && str2.equals(str) && i3 == 1) {
            this.f60242c1 += i16;
        }
        int selectionStart = this.F.getSelectionStart();
        String obj = this.F.getText().toString();
        QZLog.d("EmoEditPanel", 4, "setLikeComment " + obj + ", selection = " + selectionStart + ", len = " + this.f60238a1);
        int i17 = this.f60238a1;
        if (i17 > 0) {
            selectionStart -= i17;
            try {
                obj = obj.substring(i17);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        Drawable loadImageSync = ImageLoader.getInstance().loadImageSync(str);
        if (loadImageSync == null) {
            ImageLoader.getInstance().downloadImageOnly(str, null);
        }
        this.F.setText(M0(loadImageSync, obj, this.f60242c1));
        this.F.setSelection(Math.min(selectionStart + this.f60238a1, this.F.length()));
    }

    private void p0(ViewGroup viewGroup, int i3, aj ajVar) {
        if (viewGroup == null) {
            return;
        }
        if (i3 > 0) {
            o0(i3);
        } else {
            viewGroup.measure(0, 0);
            viewGroup.addOnLayoutChangeListener(new r(viewGroup, ajVar));
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        if (i16 == 1 && i17 == 0) {
            try {
                int C0 = C0(charSequence, i3);
                this.f60292y1 = C0;
                if (C0 == -1) {
                    M1();
                } else {
                    this.f60294z1 = i3;
                    this.A1 = charSequence.toString().substring(this.f60292y1, this.f60294z1 + 1);
                    N1();
                    if (QZLog.isColorLevel()) {
                        QZLog.d("Edit", 2, "atStatr=" + this.f60286v1 + ",atEnd=" + this.f60288w1 + ",tmp=" + this.A1);
                    }
                }
            } catch (Exception unused) {
                N1();
                M1();
            }
        }
        CaptureEditText captureEditText = this.F;
        if (captureEditText != null) {
            captureEditText.setBeforeChangeLineCount(captureEditText.getLineCount());
        }
    }

    private CharSequence M0(Drawable drawable, String str, int i3) {
        if (i3 > 0 && drawable != null) {
            String str2 = "\u25a2x" + i3 + "\u2000|\u2000";
            SpannableString spannableString = new SpannableString(str2 + str);
            int i16 = AreaConst.f48747dp2;
            int i17 = AreaConst.dp18;
            drawable.setBounds(i16, 0, i17 + i16, i17);
            VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 1);
            verticalCenterImageSpan.setPadding(0, i16);
            ColorDrawable colorDrawable = new ColorDrawable(com.qzone.adapter.feedcomponent.i.H().p1() ? 872415231 : 855836698);
            colorDrawable.setBounds(0, 0, AreaConst.dp0_5, AreaConst.dp12);
            VerticalCenterImageSpan verticalCenterImageSpan2 = new VerticalCenterImageSpan(colorDrawable, 1);
            spannableString.setSpan(verticalCenterImageSpan, 0, 1, 17);
            int length = str2.length() - 2;
            spannableString.setSpan(verticalCenterImageSpan2, length, length + 1, 17);
            this.f60238a1 = str2.length();
            return spannableString;
        }
        this.f60238a1 = 0;
        return str;
    }

    public void setCanShowGuideAdv(int i3) {
        if (i3 == 0) {
            QbossAdvDesc J = m5.a.H().J(LoginData.getInstance().getUin(), 2655);
            this.N0 = J;
            if (J != null) {
                m1(J);
                return;
            }
            return;
        }
        if (i3 != 1) {
            return;
        }
        QbossAdvDesc J2 = m5.a.H().J(LoginData.getInstance().getUin(), 2864);
        this.O0 = J2;
        if (J2 != null) {
            m1(J2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class f implements QZoneSuperFontPanel.c {
        f() {
        }

        @Override // com.qzone.common.activities.base.QZoneSuperFontPanel.c
        public void onClick(int i3) {
            PersonalFontData.FontInfo R;
            int i16;
            if (EmoEditPanel.this.F == null) {
                return;
            }
            if (EmoEditPanel.this.f60237a0 != null && EmoEditPanel.this.f60237a0.f45368i != null && (R = EmoEditPanel.this.f60237a0.f45368i.R()) != null && ((i16 = R.fontFormatType) == 3 || i16 == 4)) {
                EmoEditPanel.this.f60237a0.f45368i.y0();
            }
            if (i3 > 0) {
                if (EmoEditPanel.this.M0 < 0) {
                    EmoEditPanel emoEditPanel = EmoEditPanel.this;
                    emoEditPanel.M0 = emoEditPanel.L0;
                }
                EmoEditPanel emoEditPanel2 = EmoEditPanel.this;
                emoEditPanel2.setEmoMaxLength(emoEditPanel2.M0);
            }
            if (EmoEditPanel.this.f60263k1 != null) {
                EmoEditPanel.this.f60263k1.k0();
            }
            if (EmoEditPanel.this.F.getText() != null) {
                EmoEditPanel.this.F.getText().length();
            }
        }

        @Override // com.qzone.common.activities.base.QZoneSuperFontPanel.c
        public void a(int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class h implements QZoneBarrageEffectPanel.c {
        h() {
        }

        @Override // com.qzone.common.activities.base.QZoneBarrageEffectPanel.c
        public void a() {
        }
    }

    public void G1() {
    }

    public EmoEditPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60243d = true;
        this.f60246e = true;
        this.f60249f = false;
        this.f60257i = 0;
        this.f60266m = false;
        this.f60277r0 = false;
        this.f60283u0 = new ArrayList();
        this.f60293z0 = new t5.a();
        this.A0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.H0 = false;
        this.J0 = true;
        this.L0 = 0;
        this.M0 = -1;
        this.X0 = false;
        this.f60238a1 = 0;
        this.f60242c1 = -1;
        this.f60245d1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "CommentMaxInputCnt", 600);
        this.f60259i1 = new a();
        this.f60261j1 = new b();
        this.f60265l1 = new i();
        this.f60268m1 = new j();
        this.f60270n1 = new u();
        this.f60272o1 = new v();
        this.f60274p1 = false;
        this.f60276q1 = new w();
        this.f60278r1 = new x();
        this.f60280s1 = new z();
        this.f60282t1 = new aa();
        this.f60284u1 = new ab();
        this.f60286v1 = -1;
        this.f60288w1 = -1;
        this.f60290x1 = "";
        this.f60292y1 = -1;
        this.f60294z1 = -1;
        this.A1 = "";
        this.B1 = 0;
        this.C1 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        }
    }

    public EmoEditPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60243d = true;
        this.f60246e = true;
        this.f60249f = false;
        this.f60257i = 0;
        this.f60266m = false;
        this.f60277r0 = false;
        this.f60283u0 = new ArrayList();
        this.f60293z0 = new t5.a();
        this.A0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.H0 = false;
        this.J0 = true;
        this.L0 = 0;
        this.M0 = -1;
        this.X0 = false;
        this.f60238a1 = 0;
        this.f60242c1 = -1;
        this.f60245d1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "CommentMaxInputCnt", 600);
        this.f60259i1 = new a();
        this.f60261j1 = new b();
        this.f60265l1 = new i();
        this.f60268m1 = new j();
        this.f60270n1 = new u();
        this.f60272o1 = new v();
        this.f60274p1 = false;
        this.f60276q1 = new w();
        this.f60278r1 = new x();
        this.f60280s1 = new z();
        this.f60282t1 = new aa();
        this.f60284u1 = new ab();
        this.f60286v1 = -1;
        this.f60288w1 = -1;
        this.f60290x1 = "";
        this.f60292y1 = -1;
        this.f60294z1 = -1;
        this.A1 = "";
        this.B1 = 0;
        this.C1 = null;
    }
}
