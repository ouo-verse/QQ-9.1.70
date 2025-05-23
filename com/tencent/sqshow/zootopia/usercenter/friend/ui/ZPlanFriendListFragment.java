package com.tencent.sqshow.zootopia.usercenter.friend.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterEmptyView;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabTitleData;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabView;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import su4.f;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 V2\u00020\u0001:\u0001ZB\u0007\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001d\u0010\u0014\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u001a\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0002J&\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010+\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u001aH\u0014J\b\u0010.\u001a\u00020\nH\u0016R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020 0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010MR\u0016\u0010W\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006["}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanFriendListFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "", "initIntent", "Landroid/view/View;", "contentView", "Sh", "view", "Uh", "Th", "", "fi", "gi", "Lsu4/d;", "result", "Zh", "ci", "bi", "", "Lsu4/f;", "ai", "([Lsu4/f;)V", "di", "ei", "", "error", "", "message", "Yh", "position", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/FriendListPageView;", "Wh", "tabType", "Xh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "isWrapContent", "getSubSource", "onBackPressedEvent", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView;", "N", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView;", "tabView", "Landroidx/viewpager/widget/ViewPager;", "P", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "emptyView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "backView", "", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "tabDataList", "", "T", "Ljava/util/Map;", "pageViewMap", "Lid3/d;", "U", "Lid3/d;", "dtReporter", "V", "I", "defaultTabType", "", "W", "J", "uin", "X", "currentTagIndex", "Y", "Z", "isCleared", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendListFragment extends ZootopiaBaseFragment {

    /* renamed from: Z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: N, reason: from kotlin metadata */
    private ZPlanTabView tabView;

    /* renamed from: P, reason: from kotlin metadata */
    private ViewPager viewPager;

    /* renamed from: Q, reason: from kotlin metadata */
    private ZPlanUserCenterEmptyView emptyView;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView backView;

    /* renamed from: S, reason: from kotlin metadata */
    private final List<ZPlanTabTitleData> tabDataList = new ArrayList();

    /* renamed from: T, reason: from kotlin metadata */
    private final Map<Integer, FriendListPageView> pageViewMap = new LinkedHashMap();

    /* renamed from: U, reason: from kotlin metadata */
    private final id3.d dtReporter = new id3.d(null, 1, null);

    /* renamed from: V, reason: from kotlin metadata */
    private int defaultTabType;

    /* renamed from: W, reason: from kotlin metadata */
    private long uin;

    /* renamed from: X, reason: from kotlin metadata */
    private int currentTagIndex;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isCleared;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanFriendListFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "fromSource", "", "uin", "", "tabType", "Landroid/os/Bundle;", "bundle", "", "a", "KEY_TAB_TYPE", "Ljava/lang/String;", "KEY_UIN", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanFriendListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, ZootopiaSource fromSource, String uin, int tabType, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fromSource, "fromSource");
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putBoolean("key_need_gesture_back", false);
            bundle2.putString("uid", uin);
            bundle2.putInt("key_tab_type", tabType);
            ZootopiaActivity.Companion.c(ZootopiaActivity.INSTANCE, context, ZPlanFriendListFragment.class, fromSource, bundle2, false, 16, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanFriendListFragment$b", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$b;", "", "current", "Landroid/view/View;", "tab", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ZPlanTabView.b {
        b() {
        }

        @Override // com.tencent.sqshow.zootopia.widget.tab.ZPlanTabView.b
        public void a(int current, View tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            ZPlanFriendListFragment.this.currentTagIndex = current;
            if (!ZPlanFriendListFragment.this.tabDataList.isEmpty()) {
                HashMap hashMap = new HashMap();
                hashMap.put("zplan_tab_id", ((ZPlanTabTitleData) ZPlanFriendListFragment.this.tabDataList.get(ZPlanFriendListFragment.this.currentTagIndex)).getId());
                hashMap.put("zplan_tab_name", ((ZPlanTabTitleData) ZPlanFriendListFragment.this.tabDataList.get(ZPlanFriendListFragment.this.currentTagIndex)).getTitle());
                id3.d.i(ZPlanFriendListFragment.this.dtReporter, tab, "em_zplan_tab_btn", hashMap, true, true, null, false, false, 224, null);
            }
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanFriendListFragment$d", "Landroidx/viewpager/widget/PagerAdapter;", "", "getCount", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", "", "instantiateItem", "Landroid/view/View;", "view", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "", "isViewFromObject", "", "destroyItem", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends PagerAdapter {
        d() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object any) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(any, "any");
            container.removeView((View) any);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return ZPlanFriendListFragment.this.tabDataList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            ZPlanFriendListFragment zPlanFriendListFragment = ZPlanFriendListFragment.this;
            Context context = container.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "container.context");
            FriendListPageView Wh = zPlanFriendListFragment.Wh(position, context);
            Wh.setParam(ZPlanFriendListFragment.this.uin, ((ZPlanTabTitleData) ZPlanFriendListFragment.this.tabDataList.get(position)).getId().intValue(), ((ZPlanTabTitleData) ZPlanFriendListFragment.this.tabDataList.get(position)).getTitle());
            container.addView(Wh);
            return Wh;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object any) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(any, "any");
            return Intrinsics.areEqual(view, any);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanFriendListFragment$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<su4.d> {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(su4.d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZPlanFriendListFragment.this.Zh(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZPlanFriendListFragment.this.Yh(error, message);
        }
    }

    private final void Sh(View contentView) {
        HashMap hashMap = new HashMap();
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Ch()));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.dtReporter.j(activity, contentView, "pg_zplan_friendship", hashMap);
        }
    }

    private final void Th() {
        ImageView imageView = this.backView;
        if (imageView == null || !(!this.tabDataList.isEmpty())) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ZPlanTabTitleData zPlanTabTitleData = this.tabDataList.get(this.currentTagIndex);
        linkedHashMap.put("zplan_tab_id", String.valueOf(zPlanTabTitleData.getId().intValue()));
        linkedHashMap.put("zplan_tab_name", zPlanTabTitleData.getTitle());
        id3.d.i(this.dtReporter, imageView, "em_zplan_back_btn", linkedHashMap, true, true, null, false, false, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(ZPlanFriendListFragment this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        if (!this$0.tabDataList.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ZPlanTabTitleData zPlanTabTitleData = this$0.tabDataList.get(this$0.currentTagIndex);
            linkedHashMap.put("zplan_tab_id", String.valueOf(zPlanTabTitleData.getId().intValue()));
            linkedHashMap.put("zplan_tab_name", zPlanTabTitleData.getTitle());
            this$0.dtReporter.c("clck", view, linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FriendListPageView Wh(int position, Context context) {
        FriendListPageView friendListPageView = this.pageViewMap.get(Integer.valueOf(position));
        if (friendListPageView != null) {
            return friendListPageView;
        }
        FriendListPageView friendListPageView2 = new FriendListPageView(context);
        this.pageViewMap.put(Integer.valueOf(position), friendListPageView2);
        return friendListPageView2;
    }

    private final int Xh(int tabType) {
        if (this.tabDataList.isEmpty()) {
            return 0;
        }
        int size = this.tabDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (tabType == this.tabDataList.get(i3).getId().intValue()) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(int error, String message) {
        QLog.e("ZPlanFriendListFragment_", 1, "handleRequestError :: error == " + error + " , message == " + message);
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.emptyView;
        if (zPlanUserCenterEmptyView != null) {
            zPlanUserCenterEmptyView.setVisibility(0);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView2 = this.emptyView;
        if (zPlanUserCenterEmptyView2 != null) {
            ZPlanUserCenterEmptyView.setMode$default(zPlanUserCenterEmptyView2, ZPlanUserCenterEmptyView.MODE.MODE_NO_NETWORK, false, null, 4, null);
        }
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView3 = this.emptyView;
        if (zPlanUserCenterEmptyView3 != null) {
            zPlanUserCenterEmptyView3.setText(R.string.xws);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(su4.d result) {
        QLog.i("ZPlanFriendListFragment_", 1, "getAllFriendList success :: tabSize == " + result.f434777b.length + " ,userSize == " + result.f434776a.length);
        bi(result);
        ei();
        di();
        ci(result);
        Th();
    }

    private final void bi(su4.d result) {
        f[] fVarArr = result.f434777b;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "result.relationPageInfoList");
        ai(fVarArr);
    }

    private final void ci(su4.d result) {
        Iterator<Map.Entry<Integer, FriendListPageView>> it = this.pageViewMap.entrySet().iterator();
        while (it.hasNext()) {
            FriendListPageView value = it.next().getValue();
            if (value.getTabType() == this.defaultTabType) {
                value.c(result, true);
            } else {
                FriendListPageView.h(value, true, null, 2, null);
            }
        }
        ViewPager viewPager = this.viewPager;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(Xh(this.defaultTabType));
    }

    private final void di() {
        ZPlanTabView zPlanTabView = this.tabView;
        if (zPlanTabView != null) {
            zPlanTabView.setTabData(this.tabDataList);
        }
        ZPlanTabView zPlanTabView2 = this.tabView;
        if (zPlanTabView2 != null) {
            zPlanTabView2.setCurrentPosition(Xh(this.defaultTabType));
        }
        ZPlanTabView zPlanTabView3 = this.tabView;
        if (zPlanTabView3 != null) {
            zPlanTabView3.setViewPager(this.viewPager);
        }
        ZPlanTabView zPlanTabView4 = this.tabView;
        if (zPlanTabView4 != null) {
            zPlanTabView4.setOnCurrentTabClickListener(new b());
        }
        this.currentTagIndex = Xh(this.defaultTabType);
    }

    private final void ei() {
        d dVar = new d();
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.setAdapter(dVar);
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(2);
        }
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            viewPager3.setOnPageChangeListener(new c());
        }
    }

    private final boolean fi() {
        return Intrinsics.areEqual(String.valueOf(this.uin), MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
    }

    private final void gi() {
        if (this.uin <= 0) {
            QLog.e("ZPlanFriendListFragment_", 1, "requestData error :: uin not valid");
        }
        lc4.a.e(lc4.a.f414373a, this.uin, this.defaultTabType, null, new e(), 4, null);
    }

    private final void initIntent() {
        long j3;
        Long longOrNull;
        Bundle extras = requireActivity().getIntent().getExtras();
        if (extras != null) {
            this.defaultTabType = extras.getInt("key_tab_type");
            String string = extras.getString("uid");
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "getString(KEY_UIN)");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                    this.uin = j3;
                }
            }
            j3 = 0;
            this.uin = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_FRIEND_LIST;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.dh5, container, false);
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        Sh(contentView);
        return contentView;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initIntent();
        Uh(view);
        gi();
    }

    private final void Uh(final View view) {
        ZPlanTabView zPlanTabView;
        view.findViewById(R.id.pu7).setPadding(0, Bh(), 0, 0);
        this.tabView = (ZPlanTabView) view.findViewById(R.id.pwb);
        if (fi() && (zPlanTabView = this.tabView) != null) {
            zPlanTabView.setNeedTabCount();
        }
        this.viewPager = (ViewPager) view.findViewById(R.id.pwd);
        this.emptyView = (ZPlanUserCenterEmptyView) view.findViewById(R.id.pw_);
        ImageView imageView = (ImageView) view.findViewById(R.id.pw9);
        this.backView = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.friend.ui.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZPlanFriendListFragment.Vh(ZPlanFriendListFragment.this, view, view2);
                }
            });
        }
    }

    private final void ai(f[] result) {
        String joinToString$default;
        this.tabDataList.clear();
        for (f fVar : result) {
            int i3 = fVar.f434786a;
            if (i3 > 0) {
                String str = fVar.f434788c;
                Intrinsics.checkNotNullExpressionValue(str, "pageInfo.name");
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(CommonExKt.d(fVar.f434787b), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                this.tabDataList.add(new ZPlanTabTitleData(i3, str, joinToString$default));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanFriendListFragment$c", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            if (ZPlanFriendListFragment.this.tabDataList.size() > position) {
                int intValue = ((ZPlanTabTitleData) ZPlanFriendListFragment.this.tabDataList.get(position)).getId().intValue();
                QLog.d("ZPlanFriendListFragment_", 1, "page Selected " + position + " => type: " + intValue + " and isCleared: " + ZPlanFriendListFragment.this.isCleared);
                if (intValue != 2 || ZPlanFriendListFragment.this.isCleared) {
                    return;
                }
                ZPlanRedDotManager.f373437a.i(2);
                ZPlanFriendListFragment.this.isCleared = true;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
