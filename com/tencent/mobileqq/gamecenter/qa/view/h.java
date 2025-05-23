package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyGameListFragment;
import com.tencent.mobileqq.gamecenter.qa.model.GameListItem;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001[B\u001d\u0012\u0006\u0010)\u001a\u00020&\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020+0*\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J \u0010 \u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00106R\u0018\u0010@\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00106R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010OR\u0016\u0010R\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010T\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0016\u0010W\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/h;", "Landroid/view/View$OnClickListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup$LayoutParams;", "g", "", "j", "t", "r", "", "position", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Lvd1/b;", "sessionInfo", "", "isGuildManager", "p", "i", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/gamecenter/qa/model/GameListItem;", "selectGame", "o", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", tl.h.F, "destroy", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;", "d", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;", "mGameQAUI", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lmqq/util/WeakReference;", "mActivityRef", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "mConfigView", "Lcom/tencent/mobileqq/gamecenter/qa/view/c;", "Lcom/tencent/mobileqq/gamecenter/qa/view/c;", "mConfigGuidePagerAdapter", "Landroid/widget/Button;", "Landroid/widget/Button;", "mConfigBtn", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mGameSelectedNameView", BdhLogUtil.LogTag.Tag_Conn, "mBindRobotTxtView", "D", "mConfigGuideIndicator1", "E", "mConfigGuideIndicator2", "Lcom/tencent/mobileqq/widget/QQViewPager;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/QQViewPager;", "mGuideViewPager", "G", "Ljava/lang/Boolean;", "mRobotBinded", "H", "Ljava/lang/Integer;", "mAppid", "I", "Lvd1/b;", "mSessionInfo", "", "J", "mLastClickSelectGameTime", "K", "mLastClickBindRobotTime", "L", "mLastClickStartTime", "M", "Z", "mIsShow", "<init>", "(Lcom/tencent/mobileqq/gamecenter/qa/view/GameQAUI;Lmqq/util/WeakReference;)V", "N", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h implements View.OnClickListener, ViewPager.OnPageChangeListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mBindRobotTxtView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Button mConfigGuideIndicator1;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Button mConfigGuideIndicator2;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQViewPager mGuideViewPager;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Boolean mRobotBinded;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Integer mAppid;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private vd1.b mSessionInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private long mLastClickSelectGameTime;

    /* renamed from: K, reason: from kotlin metadata */
    private long mLastClickBindRobotTime;

    /* renamed from: L, reason: from kotlin metadata */
    private long mLastClickStartTime;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mIsShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GameQAUI mGameQAUI;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<QBaseActivity> mActivityRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mConfigView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mConfigGuidePagerAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button mConfigBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mGameSelectedNameView;

    public h(@NotNull GameQAUI mGameQAUI, @NotNull WeakReference<QBaseActivity> mActivityRef) {
        Intrinsics.checkNotNullParameter(mGameQAUI, "mGameQAUI");
        Intrinsics.checkNotNullParameter(mActivityRef, "mActivityRef");
        this.mGameQAUI = mGameQAUI;
        this.mActivityRef = mActivityRef;
        this.mRobotBinded = Boolean.FALSE;
        this.mAppid = 0;
    }

    private final void e() {
        QBaseActivity qBaseActivity;
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        QBaseActivity qBaseActivity2 = qBaseActivity;
        Intrinsics.checkNotNull(qBaseActivity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        Boolean bool = this.mRobotBinded;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue()) {
            IGuildRobotPageApi iGuildRobotPageApi = (IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class);
            vd1.b bVar = this.mSessionInfo;
            Intrinsics.checkNotNull(bVar);
            String str = bVar.f441456a;
            Intrinsics.checkNotNullExpressionValue(str, "mSessionInfo!!.guildId");
            iGuildRobotPageApi.openRobotAuthorizeFragment(qBaseActivity2, Long.parseLong(str), Long.parseLong("2854202702"), Long.parseLong("144115218681192658"), "\u6e38\u620f\u95ee\u7b54\u52a9\u624b", new vw1.d() { // from class: com.tencent.mobileqq.gamecenter.qa.view.e
                @Override // vw1.d
                public final void a(int i3, String str2) {
                    h.f(h.this, i3, str2);
                }
            }, 13);
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar2 = this.mSessionInfo;
            Intrinsics.checkNotNull(bVar2);
            gameStrategyChannelEntry.guildId = bVar2.f441456a;
            vd1.b bVar3 = this.mSessionInfo;
            Intrinsics.checkNotNull(bVar3);
            gameStrategyChannelEntry.channelId = bVar3.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907207", "907717", "20", "", GameQAUtil.i(this.mGameQAUI.U(), gameStrategyChannelEntry));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(h this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d("GameQAConfigViewController", 1, "onAuthorized, code=", Integer.valueOf(i3), ", message=", str);
        if (i3 != 0 && i3 != 32004) {
            z16 = false;
        }
        this$0.mRobotBinded = Boolean.valueOf(z16);
        this$0.t();
        this$0.r();
        Boolean bool = this$0.mRobotBinded;
        Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
        if (bool.booleanValue()) {
            QQToast.makeText(BaseApplication.getContext(), "\u5df2\u6dfb\u52a0\u95ee\u7b54\u673a\u5668\u4eba", 0).show();
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar = this$0.mSessionInfo;
            Intrinsics.checkNotNull(bVar);
            gameStrategyChannelEntry.guildId = bVar.f441456a;
            vd1.b bVar2 = this$0.mSessionInfo;
            Intrinsics.checkNotNull(bVar2);
            gameStrategyChannelEntry.channelId = bVar2.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907207", "907718", "20", "", GameQAUtil.i(this$0.mGameQAUI.U(), gameStrategyChannelEntry));
        }
    }

    private final ViewGroup.LayoutParams g(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(context) + context.getResources().getDimensionPixelOffset(R.dimen.title_bar_height);
        return layoutParams;
    }

    private final void j() {
        String str;
        IGuildRobotConfigApi iGuildRobotConfigApi = (IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class);
        vd1.b bVar = this.mSessionInfo;
        if (bVar != null) {
            str = bVar.f441456a;
        } else {
            str = null;
        }
        iGuildRobotConfigApi.checkRobotStatusInGuild("2854202702", str, new com.tencent.mobileqq.guild.api.f() { // from class: com.tencent.mobileqq.gamecenter.qa.view.d
            @Override // com.tencent.mobileqq.guild.api.f
            public final void a(boolean z16) {
                h.k(h.this, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final h this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mRobotBinded = Boolean.valueOf(z16);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.g
            @Override // java.lang.Runnable
            public final void run() {
                h.l(h.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t();
    }

    private final void m() {
        QBaseActivity qBaseActivity;
        WeakReference<QBaseActivity> weakReference = this.mActivityRef;
        QBaseActivity qBaseActivity2 = null;
        if (weakReference != null) {
            qBaseActivity = weakReference.get();
        } else {
            qBaseActivity = null;
        }
        Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        WeakReference<QBaseActivity> weakReference2 = this.mActivityRef;
        if (weakReference2 != null) {
            qBaseActivity2 = weakReference2.get();
        }
        Intrinsics.checkNotNull(qBaseActivity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QQGameStrategyGameListFragment qQGameStrategyGameListFragment = new QQGameStrategyGameListFragment(this.mGameQAUI, new WeakReference(qBaseActivity2));
        vd1.b bVar = this.mSessionInfo;
        if (bVar != null) {
            qQGameStrategyGameListFragment.wh(bVar);
        }
        FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        supportFragmentManager.beginTransaction().add(qQGameStrategyGameListFragment, "GameQAConfigViewController").commit();
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar2 = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar2);
        gameStrategyChannelEntry.guildId = bVar2.f441456a;
        vd1.b bVar3 = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar3);
        gameStrategyChannelEntry.channelId = bVar3.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907207", "907714", "20", "", GameQAUtil.i(this.mGameQAUI.U(), gameStrategyChannelEntry));
    }

    private final void n() {
        Integer num = this.mAppid;
        if (num != null) {
            this.mGameQAUI.E0(num.intValue(), "144115218681192658");
        }
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar);
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        vd1.b bVar2 = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar2);
        gameStrategyChannelEntry.channelId = bVar2.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907207", "907719", "20", "", GameQAUtil.i(this.mGameQAUI.U(), gameStrategyChannelEntry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(h this$0, View view, MotionEvent motionEvent) {
        ViewParent parent;
        ViewParent parent2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            QQViewPager qQViewPager = this$0.mGuideViewPager;
            if (qQViewPager != null && (parent2 = qQViewPager.getParent()) != null) {
                parent2.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            QQViewPager qQViewPager2 = this$0.mGuideViewPager;
            if (qQViewPager2 != null && (parent = qQViewPager2.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }

    private final void r() {
        boolean z16;
        Button button = this.mConfigBtn;
        if (button != null) {
            Integer num = this.mAppid;
            if ((num == null || num.intValue() != 0) && Intrinsics.areEqual(this.mRobotBinded, Boolean.TRUE)) {
                z16 = true;
            } else {
                z16 = false;
            }
            button.setEnabled(z16);
        }
    }

    private final void s(int position) {
        if (position == 0) {
            Button button = this.mConfigGuideIndicator1;
            Intrinsics.checkNotNull(button);
            button.setSelected(true);
            Button button2 = this.mConfigGuideIndicator2;
            Intrinsics.checkNotNull(button2);
            button2.setSelected(false);
            return;
        }
        Button button3 = this.mConfigGuideIndicator1;
        Intrinsics.checkNotNull(button3);
        button3.setSelected(false);
        Button button4 = this.mConfigGuideIndicator2;
        Intrinsics.checkNotNull(button4);
        button4.setSelected(true);
    }

    private final void t() {
        if (Intrinsics.areEqual(this.mRobotBinded, Boolean.TRUE)) {
            TextView textView = this.mBindRobotTxtView;
            if (textView != null) {
                textView.setText("\u5df2\u6dfb\u52a0");
                return;
            }
            return;
        }
        TextView textView2 = this.mBindRobotTxtView;
        if (textView2 != null) {
            textView2.setText("\u53bb\u6388\u6743");
        }
    }

    public void destroy() {
        h();
        QQViewPager qQViewPager = this.mGuideViewPager;
        if (qQViewPager != null) {
            qQViewPager.removeOnPageChangeListener(this);
        }
    }

    public void h() {
        ViewParent viewParent;
        RelativeLayout relativeLayout = this.mConfigView;
        if (relativeLayout != null) {
            viewParent = relativeLayout.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            this.mGameQAUI.e0().removeView(this.mConfigView);
        }
        this.mIsShow = false;
    }

    public void i() {
        if (this.mIsShow) {
            j();
        }
    }

    public void o(@NotNull GameListItem selectGame) {
        Intrinsics.checkNotNullParameter(selectGame, "selectGame");
        TextView textView = this.mGameSelectedNameView;
        if (textView != null) {
            textView.setText(selectGame.getName());
        }
        this.mAppid = Integer.valueOf(selectGame.getAppid());
        r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.tdq) {
            if (System.currentTimeMillis() - this.mLastClickStartTime >= 2000) {
                this.mLastClickStartTime = System.currentTimeMillis();
                n();
            }
        } else if (num != null && num.intValue() == R.id.xxh) {
            if (System.currentTimeMillis() - this.mLastClickSelectGameTime >= 2000) {
                this.mLastClickSelectGameTime = System.currentTimeMillis();
                m();
            }
        } else if (num != null && num.intValue() == R.id.f165846xt0 && System.currentTimeMillis() - this.mLastClickBindRobotTime >= 2000) {
            this.mLastClickBindRobotTime = System.currentTimeMillis();
            e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        s(position);
    }

    public void p(@NotNull vd1.b sessionInfo, boolean isGuildManager) {
        ViewParent viewParent;
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        QLog.d("GameQAConfigViewController", 1, "showConfigView, sessionInfo=", sessionInfo, ", isGuildManager=", Boolean.valueOf(isGuildManager));
        RelativeLayout relativeLayout2 = this.mConfigView;
        ViewGroup.LayoutParams layoutParams = null;
        if (relativeLayout2 != null) {
            viewParent = relativeLayout2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            return;
        }
        RelativeLayout e06 = this.mGameQAUI.e0();
        this.mSessionInfo = sessionInfo;
        this.mIsShow = true;
        if (this.mConfigView == null) {
            View inflate = LayoutInflater.from(e06.getContext()).inflate(R.layout.ebr, (ViewGroup) e06, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            this.mConfigView = (RelativeLayout) inflate;
        }
        RelativeLayout relativeLayout3 = this.mConfigView;
        Context context = e06.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewRoot.context");
        e06.addView(relativeLayout3, g(context));
        RelativeLayout relativeLayout4 = this.mConfigView;
        if (relativeLayout4 != null) {
            relativeLayout = (RelativeLayout) relativeLayout4.findViewById(R.id.u6g);
        } else {
            relativeLayout = null;
        }
        Intrinsics.checkNotNull(relativeLayout);
        View findViewById = relativeLayout.findViewById(R.id.u6x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "configRootView.findViewB\u2026container_manager_config)");
        RelativeLayout relativeLayout5 = (RelativeLayout) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.f113176px);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "configRootView.findViewB\u2026d.txt_member_config_tips)");
        Button button = (Button) relativeLayout.findViewById(R.id.tdq);
        this.mConfigBtn = button;
        if (button != null) {
            button.setEnabled(false);
        }
        this.mGuideViewPager = (QQViewPager) relativeLayout.findViewById(R.id.f11884759);
        this.mConfigGuideIndicator1 = (Button) relativeLayout.findViewById(R.id.tes);
        this.mConfigGuideIndicator2 = (Button) relativeLayout.findViewById(R.id.tet);
        QQViewPager qQViewPager = this.mGuideViewPager;
        if (qQViewPager != null) {
            qQViewPager.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.f
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean q16;
                    q16 = h.q(h.this, view, motionEvent);
                    return q16;
                }
            });
        }
        QQViewPager qQViewPager2 = this.mGuideViewPager;
        if (qQViewPager2 != null) {
            qQViewPager2.removeOnPageChangeListener(this);
        }
        QQViewPager qQViewPager3 = this.mGuideViewPager;
        if (qQViewPager3 != null) {
            qQViewPager3.addOnPageChangeListener(this);
        }
        QQViewPager qQViewPager4 = this.mGuideViewPager;
        if (qQViewPager4 != null) {
            qQViewPager4.setPageMargin(com.tencent.mobileqq.utils.x.a(16.0f));
        }
        if (isGuildManager) {
            relativeLayout5.setVisibility(0);
            findViewById2.setVisibility(8);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.f113326qb);
            this.mGameSelectedNameView = textView;
            if (textView != null) {
                textView.setText(BaseApplication.getContext().getString(R.string.f1368905d));
            }
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.f112906p7);
            this.mBindRobotTxtView = textView2;
            if (textView2 != null) {
                textView2.setText(BaseApplication.getContext().getString(R.string.f13675050));
            }
            j();
            Button button2 = this.mConfigBtn;
            if (button2 != null) {
                button2.setOnClickListener(this);
            }
            View findViewById3 = e06.findViewById(R.id.xxh);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "viewRoot.findViewById(R.id.item_select_game)");
            ((RelativeLayout) findViewById3).setOnClickListener(this);
            View findViewById4 = e06.findViewById(R.id.f165846xt0);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "viewRoot.findViewById(R.id.item_config_robot)");
            ((RelativeLayout) findViewById4).setOnClickListener(this);
        } else {
            relativeLayout5.setVisibility(8);
            findViewById2.setVisibility(0);
            QQViewPager qQViewPager5 = this.mGuideViewPager;
            if (qQViewPager5 != null) {
                layoutParams = qQViewPager5.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.height = com.tencent.mobileqq.utils.x.a(424.0f);
            }
        }
        if (this.mConfigGuidePagerAdapter == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("https://img.gamecenter.qq.com/xgame/gm/1656313053180_eab41a4733c3f22d9dec9dec7532f54e.png");
            arrayList.add("https://img.gamecenter.qq.com/xgame/gm/1656313058819_69d289c2a48f7220b69a12cc67b1767a.png");
            this.mConfigGuidePagerAdapter = new c(arrayList, isGuildManager);
        }
        QQViewPager qQViewPager6 = this.mGuideViewPager;
        if (qQViewPager6 != null) {
            qQViewPager6.setAdapter(this.mConfigGuidePagerAdapter);
        }
        c cVar = this.mConfigGuidePagerAdapter;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        QQViewPager qQViewPager7 = this.mGuideViewPager;
        if (qQViewPager7 != null) {
            qQViewPager7.setCurrentItem(0);
        }
        s(0);
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar);
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        vd1.b bVar2 = this.mSessionInfo;
        Intrinsics.checkNotNull(bVar2);
        gameStrategyChannelEntry.channelId = bVar2.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907207", "907713", "8", "", GameQAUtil.i(this.mGameQAUI.U(), gameStrategyChannelEntry));
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}
