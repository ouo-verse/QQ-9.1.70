package com.qzone.reborn.feedpro.widget.header;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.component.banner.util.QZoneAvatarLoopAnimationManager;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUserKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFriendFeedPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.VisitorInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.state.data.SquareJSConst;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010E\u001a\u00020\u0013\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0014R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001dR\u0018\u00101\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u001dR\u0018\u00103\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001dR\u0018\u00105\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u001dR\u0018\u00108\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010$R\u0016\u0010<\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010$R\u0016\u0010>\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010$R\u0016\u0010@\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010$R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProHeaderInfoElement;", "Lcom/qzone/reborn/feedpro/widget/header/d;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;", "headRsp", "", "y", "Ljava/util/ArrayList;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lkotlin/collections/ArrayList;", "visitorList", HippyTKDListViewAdapter.X, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", QCircleAlphaUserReporter.KEY_USER, "u", "", SquareJSConst.Params.PARAMS_UIN_LIST, "w", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isClick", "r", "onInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "k", "f", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "getAvatarView", "()Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "setAvatarView", "(Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;)V", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "getNickName", "()Landroid/widget/TextView;", "setNickName", "(Landroid/widget/TextView;)V", "nickName", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "visitorAvatarLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "avatar1", BdhLogUtil.LogTag.Tag_Conn, "avatar2", "D", "avatar3", "E", "avatar4", UserInfo.SEX_FEMALE, "Landroid/view/View;", "visitorInfoContainer", "G", "visitorCountText", "H", "visitorCountTodayText", "I", "visitorCountTodayTempPoint", "J", "visitorCountTodayTempText", "Lcom/qzone/component/banner/util/QZoneAvatarLoopAnimationManager;", "K", "Lcom/qzone/component/banner/util/QZoneAvatarLoopAnimationManager;", "loopAnimManager", "containerView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProHeaderInfoElement extends d {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneUserAvatarView avatar2;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneUserAvatarView avatar3;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneUserAvatarView avatar4;

    /* renamed from: F, reason: from kotlin metadata */
    private View visitorInfoContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView visitorCountText;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView visitorCountTodayText;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView visitorCountTodayTempPoint;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView visitorCountTodayTempText;

    /* renamed from: K, reason: from kotlin metadata */
    private QZoneAvatarLoopAnimationManager loopAnimManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nickName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup visitorAvatarLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatar1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProHeaderInfoElement(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.avatarView = (QZoneUserAvatarView) containerView.findViewById(R.id.mwd);
        this.nickName = (TextView) containerView.findViewById(R.id.mwf);
        this.visitorAvatarLayout = (ViewGroup) containerView.findViewById(R.id.mwj);
        this.avatar1 = (QZoneUserAvatarView) containerView.findViewById(R.id.nc6);
        this.avatar2 = (QZoneUserAvatarView) containerView.findViewById(R.id.nc8);
        this.avatar3 = (QZoneUserAvatarView) containerView.findViewById(R.id.nc_);
        this.avatar4 = (QZoneUserAvatarView) containerView.findViewById(R.id.ncb);
        this.visitorInfoContainer = containerView.findViewById(R.id.mwo);
        View findViewById = containerView.findViewById(R.id.mwk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026pro_header_visitor_count)");
        this.visitorCountText = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.mwl);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ader_visitor_count_today)");
        this.visitorCountTodayText = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mwm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026r_count_today_temp_point)");
        this.visitorCountTodayTempPoint = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.mwn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026or_count_today_temp_text)");
        this.visitorCountTodayTempText = (TextView) findViewById4;
    }

    private final void s() {
        vo.c.v(h().getContext(), LoginData.getInstance().getUin());
        r(this.visitorInfoContainer, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QzoneFeedProHeaderInfoElement this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b9, code lost:
    
        if (r7 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(GetFriendFeedPageHeadRsp headRsp) {
        ArrayList<CommonUser> arrayList;
        List<StUser> list;
        int collectionSizeOrDefault;
        TextView textView = this.nickName;
        if (textView != null) {
            textView.setText(LoginData.getInstance().getNickName(""));
        }
        VisitorInfo visitorInfo = headRsp.visitor;
        this.visitorCountText.setText(String.valueOf(visitorInfo != null ? visitorInfo.visitorCnt : 0));
        VisitorInfo visitorInfo2 = headRsp.visitor;
        int i3 = visitorInfo2 != null ? visitorInfo2.todayVisitorCnt : 0;
        if (i3 <= 0) {
            this.visitorCountTodayTempText.setVisibility(8);
            this.visitorCountTodayTempPoint.setVisibility(8);
            this.visitorCountTodayText.setVisibility(8);
        } else {
            this.visitorCountTodayTempText.setVisibility(0);
            this.visitorCountTodayTempPoint.setVisibility(0);
            this.visitorCountTodayText.setVisibility(0);
            this.visitorCountTodayText.setText(Marker.ANY_NON_NULL_MARKER + i3);
        }
        View view = this.visitorInfoContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.header.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QzoneFeedProHeaderInfoElement.z(QzoneFeedProHeaderInfoElement.this, view2);
                }
            });
        }
        View view2 = this.visitorInfoContainer;
        if (view2 != null) {
            com.qzone.reborn.feedpro.utils.aa.m(com.qzone.reborn.feedpro.utils.aa.f54263a, view2, 0.0f, 1, null);
        }
        VisitorInfo visitorInfo3 = headRsp.visitor;
        if (visitorInfo3 != null && (list = visitorInfo3.todayVisitors) != null) {
            List<StUser> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                CommonUser common2 = CommonUserKt.toCommon((StUser) it.next());
                if (common2 == null) {
                    common2 = new CommonUser();
                }
                arrayList2.add(common2);
            }
            arrayList = bg.f302144a.n(arrayList2);
        }
        arrayList = new ArrayList<>();
        x(arrayList);
        r(this.visitorInfoContainer, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QzoneFeedProHeaderInfoElement this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.header.d
    public String k() {
        return "QzoneFeedProHeaderInfoElement";
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void onDestroy() {
        RFWLog.i(k(), RFWLog.USR, "mLoopAnimManager is destroying");
        QZoneAvatarLoopAnimationManager qZoneAvatarLoopAnimationManager = this.loopAnimManager;
        if (qZoneAvatarLoopAnimationManager != null) {
            qZoneAvatarLoopAnimationManager.i();
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.avatarView;
        if (qZoneUserAvatarView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.i(com.qzone.reborn.feedpro.utils.aa.f54263a, qZoneUserAvatarView2, h().getContext(), 0, true, 2, null);
        }
        TextView textView = this.nickName;
        if (textView != null) {
            textView.setText(LoginData.getInstance().getNickName(""));
        }
        MutableLiveData<GetFriendFeedPageHeadRsp> b26 = ((com.qzone.reborn.feedpro.viewmodel.p) l(com.qzone.reborn.feedpro.viewmodel.p.class)).b2();
        LifecycleOwner j3 = j();
        final Function1<GetFriendFeedPageHeadRsp, Unit> function1 = new Function1<GetFriendFeedPageHeadRsp, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProHeaderInfoElement$onInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetFriendFeedPageHeadRsp getFriendFeedPageHeadRsp) {
                invoke2(getFriendFeedPageHeadRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GetFriendFeedPageHeadRsp it) {
                QzoneFeedProHeaderInfoElement qzoneFeedProHeaderInfoElement = QzoneFeedProHeaderInfoElement.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qzoneFeedProHeaderInfoElement.y(it);
            }
        };
        b26.observe(j3, new Observer() { // from class: com.qzone.reborn.feedpro.widget.header.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProHeaderInfoElement.t(Function1.this, obj);
            }
        });
        q(this.avatarView);
    }

    private final void w(ArrayList<String> uinList) {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.avatar1, this.avatar2, this.avatar3, this.avatar4);
        if (this.loopAnimManager == null) {
            this.loopAnimManager = new QZoneAvatarLoopAnimationManager(arrayListOf, uinList);
        }
        QZoneAvatarLoopAnimationManager qZoneAvatarLoopAnimationManager = this.loopAnimManager;
        if (qZoneAvatarLoopAnimationManager != null) {
            qZoneAvatarLoopAnimationManager.u(10);
        }
        QZoneAvatarLoopAnimationManager qZoneAvatarLoopAnimationManager2 = this.loopAnimManager;
        if (qZoneAvatarLoopAnimationManager2 != null) {
            qZoneAvatarLoopAnimationManager2.v(ThreadManagerV2.getUIHandlerV2());
        }
        QZoneAvatarLoopAnimationManager qZoneAvatarLoopAnimationManager3 = this.loopAnimManager;
        if (qZoneAvatarLoopAnimationManager3 != null) {
            qZoneAvatarLoopAnimationManager3.w();
        }
    }

    private final void q(View view) {
        if (view != null) {
            fo.c.q(view, "em_qz_avatar", null);
        }
    }

    private final void r(View view, boolean isClick) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pendant_type", 2);
            if (this.visitorCountTodayText.getVisibility() == 0) {
                hashMap.put("have_today_visitor", 1);
            } else {
                hashMap.put("have_today_visitor", 0);
            }
            if (isClick) {
                fo.c.e("em_qz_pendant", "pg_bas_social_updates", view, hashMap);
            } else {
                fo.c.g("em_qz_pendant", "pg_bas_social_updates", view, hashMap);
            }
        }
    }

    private final void u(QZoneUserAvatarView avatarView, CommonUser user) {
        if (avatarView == null || TextUtils.isEmpty(user.getUin())) {
            return;
        }
        avatarView.setVisibility(0);
        avatarView.setCommonUser(user);
        avatarView.setIsShieldJumpToMainPage(true);
        avatarView.setOnClickHookListener(new QZoneUserAvatarView.a() { // from class: com.qzone.reborn.feedpro.widget.header.i
            @Override // com.qzone.reborn.feedx.widget.QZoneUserAvatarView.a
            public final void a(View view) {
                QzoneFeedProHeaderInfoElement.v(QzoneFeedProHeaderInfoElement.this, view);
            }
        });
        avatarView.setOnClickListener(null);
    }

    private final void x(ArrayList<CommonUser> visitorList) {
        ArrayList<QZoneUserAvatarView> arrayListOf;
        int collectionSizeOrDefault;
        if (visitorList == null || visitorList.isEmpty()) {
            ViewGroup viewGroup = this.visitorAvatarLayout;
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = this.visitorAvatarLayout;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.avatar1, this.avatar2, this.avatar3, this.avatar4);
        for (QZoneUserAvatarView qZoneUserAvatarView : arrayListOf) {
            if (qZoneUserAvatarView != null) {
                qZoneUserAvatarView.setVisibility(8);
            }
        }
        if (!visitorList.isEmpty()) {
            QZoneUserAvatarView qZoneUserAvatarView2 = this.avatar1;
            CommonUser commonUser = visitorList.get(0);
            Intrinsics.checkNotNullExpressionValue(commonUser, "visitorList[0]");
            u(qZoneUserAvatarView2, commonUser);
        }
        if (visitorList.size() >= 2) {
            QZoneUserAvatarView qZoneUserAvatarView3 = this.avatar2;
            CommonUser commonUser2 = visitorList.get(1);
            Intrinsics.checkNotNullExpressionValue(commonUser2, "visitorList[1]");
            u(qZoneUserAvatarView3, commonUser2);
        }
        if (visitorList.size() >= 3) {
            QZoneUserAvatarView qZoneUserAvatarView4 = this.avatar3;
            CommonUser commonUser3 = visitorList.get(2);
            Intrinsics.checkNotNullExpressionValue(commonUser3, "visitorList[2]");
            u(qZoneUserAvatarView4, commonUser3);
        }
        if (visitorList.size() >= 4) {
            QZoneUserAvatarView qZoneUserAvatarView5 = this.avatar4;
            CommonUser commonUser4 = visitorList.get(3);
            Intrinsics.checkNotNullExpressionValue(commonUser4, "visitorList[3]");
            u(qZoneUserAvatarView5, commonUser4);
            bg bgVar = bg.f302144a;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(visitorList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = visitorList.iterator();
            while (it.hasNext()) {
                String uin = ((CommonUser) it.next()).getUin();
                if (uin == null) {
                    uin = "";
                }
                arrayList.add(uin);
            }
            w(bgVar.n(arrayList));
        }
    }
}
