package com.tencent.biz.qqcircle.immersive.tab;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.utils.o;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSHRGameTabCallbackEvent;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSOpenCommentEvent;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSOpenPersonalDetailPageEvent;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSOpenSharePanelEvent;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StTabInfo;
import qqcircle.QQCircleFeedBase$StTabJumpUrlInfo;
import qqcircle.QQCircleFeedBase$StTabOpInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00019B\u0017\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00105\u001a\u00020\u0010\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016`\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/\u00a8\u0006:"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/tab/QFSGameTabFragment;", "Lcom/tencent/biz/qqcircle/immersive/tab/QFSAutoMemoryFragment;", "Lcom/tencent/mobileqq/qqecommerce/biz/event/QFSHRGameTabCallbackEvent;", "callbackEvent", "", "uh", "Lfeedcloud/FeedCloudMeta$StFeed;", "pbFeed", OcrConfig.CHINESE, "stFeed", "xh", "yh", "", "wh", "Landroid/os/Bundle;", "vh", "", "getContentLayoutId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getDaTongPageId", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getLogTag", "getPageId", "Lcooperation/qqcircle/report/QCircleReportBean;", "getReportBean", "load", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "th", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/d;", "G", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/d;", "hrFragmentModel", "", "H", "Z", "hadDestroy", "I", "hadAddFragment", "J", "currentTabIndex", "Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;", "tabInfo", "tabIndex", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;I)V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSGameTabFragment extends QFSAutoMemoryFragment {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqecommerce.biz.hr.api.d hrFragmentModel;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean hadDestroy;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hadAddFragment;

    /* renamed from: J, reason: from kotlin metadata */
    private int currentTabIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/tab/QFSGameTabFragment$a;", "", "Lcom/tencent/biz/qqcircle/beans/QCircleTabInfo;", "tabInfo", "", "a", "", "EVENT_COMMENT_COUNT_UPDATE", "Ljava/lang/String;", "EVENT_PRAISE_UPDATE", "EVENT_QQ_CIR_TAB_CLICK", "HR_GAME_PAGE_NAME", "KEY_DISABLE_CHANGE_SYSTEM_BAR", "KEY_PAGE_NAME", "KEY_QQ_BOTTOM_BAR_HEIGHT", "PAGE_ID", "PARAM_COMMENT_COUNT", "PARAM_FEED_ID", "PARAM_PRAISED_COUNT", "PARAM_PRAISED_STATUS", "STAGE_GAME_TAB_PAGE", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.tab.QFSGameTabFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable QCircleTabInfo tabInfo) {
            String str;
            boolean contains$default;
            boolean contains$default2;
            QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
            QQCircleFeedBase$StTabOpInfo qQCircleFeedBase$StTabOpInfo;
            QQCircleFeedBase$StTabJumpUrlInfo qQCircleFeedBase$StTabJumpUrlInfo;
            PBStringField pBStringField;
            if (tabInfo != null && (qQCircleFeedBase$StTabInfo = tabInfo.mTab) != null && (qQCircleFeedBase$StTabOpInfo = qQCircleFeedBase$StTabInfo.tabInfoByOperators) != null && (qQCircleFeedBase$StTabJumpUrlInfo = qQCircleFeedBase$StTabOpInfo.jumpUrlInfo) != null && (pBStringField = qQCircleFeedBase$StTabJumpUrlInfo.jumpUrl) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "ecommerce/open?", false, 2, (Object) null);
                if (contains$default) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "page_name=", false, 2, (Object) null);
                    if (!contains$default2) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSGameTabFragment(@NotNull QCircleTabInfo tabInfo, int i3) {
        super(tabInfo, i3);
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        this.hrFragmentModel = ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).createHRFragmentModel();
        this.currentTabIndex = -1;
    }

    private final void uh(QFSHRGameTabCallbackEvent callbackEvent) {
        if (callbackEvent.getEventType() == 1) {
            callbackEvent.getCallback().invoke(Integer.valueOf(this.currentTabIndex));
        }
    }

    private final Bundle vh() {
        String str;
        QQCircleFeedBase$StTabOpInfo tabDiyConfig;
        QQCircleFeedBase$StTabJumpUrlInfo qQCircleFeedBase$StTabJumpUrlInfo;
        PBStringField pBStringField;
        Bundle bundle = new Bundle();
        try {
            QCircleTabInfo qCircleTabInfo = this.E;
            if (qCircleTabInfo != null && (tabDiyConfig = qCircleTabInfo.getTabDiyConfig()) != null && (qQCircleFeedBase$StTabJumpUrlInfo = tabDiyConfig.jumpUrlInfo) != null && (pBStringField = qQCircleFeedBase$StTabJumpUrlInfo.jumpUrl) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
        } catch (Exception e16) {
            QLog.e("QFSGameTabFragment", 1, "gameJumpUrlParamsToBundle error: " + e16);
        }
        if (str == null) {
            return bundle;
        }
        Uri parse = Uri.parse(str);
        for (String str2 : parse.getQueryParameterNames()) {
            bundle.putString(str2, parse.getQueryParameter(str2));
        }
        return bundle;
    }

    private final float wh() {
        float b16;
        b16 = d.b(DisplayUtil.dip2px(getActivity(), 54.0f));
        return b16;
    }

    private final void xh(FeedCloudMeta$StFeed stFeed) {
        t40.b bVar = (t40.b) getIocInterface(t40.b.class);
        if (bVar == null) {
            QLog.d("QFSGameTabFragment", 1, "[openCommentPanel] folder ioc should not be null.");
            return;
        }
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeed = stFeed;
        qFSCommentInfo.mFeedBlockData = new e30.b(stFeed);
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mIsShowMask = true;
        bVar.onHandlerMessage("event_open_comment", qFSCommentInfo);
    }

    private final void yh(FeedCloudMeta$StFeed stFeed) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(stFeed.poster.f398463id.get());
        com.tencent.biz.qqcircle.launcher.c.d0(getActivity(), qCircleInitBean);
    }

    private final void zh(FeedCloudMeta$StFeed pbFeed) {
        QCircleShareInfo c16 = au.c(pbFeed);
        c16.isShowBarrageSwitch = false;
        c16.isShareBottomBarrageSwitch = o.e(pbFeed);
        c16.isShowPlayRate = false;
        c16.feed = pbFeed;
        c16.feedBlockData = new e30.b(pbFeed);
        c16.mReportBean = getReportBean();
        getPartManager().broadcastMessage("share_action_show_share_sheet", c16);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QFSSharePart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168683gd3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSAutoMemoryFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return "pg_xsj_game_tab_page";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> list = super.getEventClass();
        list.add(QFSOpenCommentEvent.class);
        list.add(QFSOpenSharePanelEvent.class);
        list.add(QFSOpenPersonalDetailPageEvent.class);
        list.add(QCirclePolyPraiseUpdateEvent.class);
        list.add(QCircleCommentCountUpdateEvent.class);
        list.add(QFSPageSelectEvent.class);
        list.add(QFSHRGameTabCallbackEvent.class);
        Intrinsics.checkNotNullExpressionValue(list, "list");
        return list;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSGameTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 97;
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        FragmentActivity activity = getActivity();
        boolean z16 = false;
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        }
        if (!z16 && !this.hadDestroy && !this.hadAddFragment) {
            com.tencent.mobileqq.qqecommerce.biz.hr.api.d dVar = this.hrFragmentModel;
            Bundle bundle = new Bundle();
            bundle.putString("page_name", "game_content_page");
            bundle.putFloat("qqBottomBarHeight", wh());
            bundle.putBoolean("disable_change_system_bar", true);
            bundle.putAll(vh());
            dVar.getFragment(bundle, new Function1<Fragment, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.tab.QFSGameTabFragment$load$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
                    invoke2(fragment);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Fragment fragment) {
                    Intrinsics.checkNotNullParameter(fragment, "fragment");
                    if (QFSGameTabFragment.this.isAdded()) {
                        QFSGameTabFragment.this.getChildFragmentManager().beginTransaction().add(R.id.f43361m_, fragment).commitAllowingStateLoss();
                    } else {
                        QLog.e("QFSGameTabFragment", 1, "[load] isAdded return false");
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.hadDestroy = true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.hrFragmentModel.manualOnStop();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        Map<String, ? extends Object> mapOf;
        Map<String, ? extends Object> mapOf2;
        super.onReceiveEvent(event);
        if (QLog.isColorLevel()) {
            QLog.d("QFSGameTabFragment", 2, "onReceiveEvent: event=" + event);
        }
        if (event instanceof QFSOpenSharePanelEvent) {
            QFSOpenSharePanelEvent qFSOpenSharePanelEvent = (QFSOpenSharePanelEvent) event;
            if (qFSOpenSharePanelEvent.getPbFeed() instanceof FeedCloudMeta$StFeed) {
                MessageMicro<?> pbFeed = qFSOpenSharePanelEvent.getPbFeed();
                Intrinsics.checkNotNull(pbFeed, "null cannot be cast to non-null type feedcloud.FeedCloudMeta.StFeed");
                zh((FeedCloudMeta$StFeed) pbFeed);
                return;
            }
            return;
        }
        if (event instanceof QFSOpenCommentEvent) {
            QFSOpenCommentEvent qFSOpenCommentEvent = (QFSOpenCommentEvent) event;
            if (qFSOpenCommentEvent.getPbFeed() instanceof FeedCloudMeta$StFeed) {
                MessageMicro<?> pbFeed2 = qFSOpenCommentEvent.getPbFeed();
                Intrinsics.checkNotNull(pbFeed2, "null cannot be cast to non-null type feedcloud.FeedCloudMeta.StFeed");
                xh((FeedCloudMeta$StFeed) pbFeed2);
                return;
            }
            return;
        }
        if (event instanceof QFSOpenPersonalDetailPageEvent) {
            QFSOpenPersonalDetailPageEvent qFSOpenPersonalDetailPageEvent = (QFSOpenPersonalDetailPageEvent) event;
            if (qFSOpenPersonalDetailPageEvent.getPbFeed() instanceof FeedCloudMeta$StFeed) {
                MessageMicro<?> pbFeed3 = qFSOpenPersonalDetailPageEvent.getPbFeed();
                Intrinsics.checkNotNull(pbFeed3, "null cannot be cast to non-null type feedcloud.FeedCloudMeta.StFeed");
                yh((FeedCloudMeta$StFeed) pbFeed3);
                return;
            }
            return;
        }
        if (event instanceof QCirclePolyPraiseUpdateEvent) {
            com.tencent.mobileqq.qqecommerce.biz.hr.api.d dVar = this.hrFragmentModel;
            QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent = (QCirclePolyPraiseUpdateEvent) event;
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("feed_id", qCirclePolyPraiseUpdateEvent.mTargetFeedId), TuplesKt.to("praised_count", Integer.valueOf(qCirclePolyPraiseUpdateEvent.mPraisedNum)), TuplesKt.to("praised_status", Integer.valueOf(qCirclePolyPraiseUpdateEvent.mPraisedStatus)));
            dVar.sendEvent("event_praise_update", mapOf2);
            return;
        }
        if (event instanceof QCircleCommentCountUpdateEvent) {
            com.tencent.mobileqq.qqecommerce.biz.hr.api.d dVar2 = this.hrFragmentModel;
            QCircleCommentCountUpdateEvent qCircleCommentCountUpdateEvent = (QCircleCommentCountUpdateEvent) event;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("feed_id", qCircleCommentCountUpdateEvent.getFeedId()), TuplesKt.to("comment_count", Integer.valueOf(qCircleCommentCountUpdateEvent.getCount())));
            dVar2.sendEvent("event_comment_count_update", mapOf);
            return;
        }
        if (event instanceof QFSPageSelectEvent) {
            this.currentTabIndex = ((QFSPageSelectEvent) event).mSelectPosition;
        } else if (event instanceof QFSHRGameTabCallbackEvent) {
            uh((QFSHRGameTabCallbackEvent) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSAutoMemoryFragment
    public void th() {
        Map<String, ? extends Object> emptyMap;
        QLog.i("QFSGameTabFragment", 1, "scrollToTopAndRefresh");
        com.tencent.mobileqq.qqecommerce.biz.hr.api.d dVar = this.hrFragmentModel;
        emptyMap = MapsKt__MapsKt.emptyMap();
        dVar.sendEvent("qq_cir_tab_click", emptyMap);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.qqcircle.richframework.part.a
    @NotNull
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = new QCircleReportBean();
        qCircleReportBean.setPageId(qCircleReportBean.getPageId());
        qCircleReportBean.setDtPageId(getDaTongPageId());
        return qCircleReportBean;
    }
}
