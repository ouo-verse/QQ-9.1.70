package com.tencent.mobileqq.troop.homework.historymsg;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.ITroopTeacherApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.historymsg.msg.TroopTeacherMsgFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u000245B\u0007\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0014J&\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR#\u0010$\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010'R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/historymsg/TroopTeacherMsgRootFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "tabIndex", "", "isPageIn", "", "vh", "", "kotlin.jvm.PlatformType", "sh", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "onBackEvent", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Landroidx/viewpager2/widget/ViewPager2;", "D", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "E", "Lkotlin/Lazy;", "th", "()Ljava/lang/String;", "troopUin", UserInfo.SEX_FEMALE, "rh", "()I", GetAdInfoRequest.SOURCE_FROM, "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "fragments", "H", "I", "curTabIndex", "<init>", "()V", "a", "TabItem", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeacherMsgRootFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private QUIPageTabBar tabBar;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy sourceFrom;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Fragment> fragments;

    /* renamed from: H, reason: from kotlin metadata */
    private int curTabIndex;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/historymsg/TroopTeacherMsgRootFragment$TabItem;", "", "content", "", "tabType", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getTabType", "()I", "MSG", "FILE", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class TabItem {
        private static final /* synthetic */ TabItem[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TabItem FILE;
        public static final TabItem MSG;

        @NotNull
        private final String content;
        private final int tabType;

        private static final /* synthetic */ TabItem[] $values() {
            return new TabItem[]{MSG, FILE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50907);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            MSG = new TabItem("MSG", 0, "\u6240\u6709\u6d88\u606f", 1);
            FILE = new TabItem("FILE", 1, "\u6587\u4ef6", 2);
            $VALUES = $values();
        }

        TabItem(String str, int i3, String str2, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
            } else {
                this.content = str2;
                this.tabType = i16;
            }
        }

        public static TabItem valueOf(String str) {
            return (TabItem) Enum.valueOf(TabItem.class, str);
        }

        public static TabItem[] values() {
            return (TabItem[]) $VALUES.clone();
        }

        @NotNull
        public final String getContent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }

        public final int getTabType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.tabType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/historymsg/TroopTeacherMsgRootFragment$a;", "", "", "title", "troopUin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "Landroid/os/Bundle;", "extData", "", "a", "PAGE_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.historymsg.TroopTeacherMsgRootFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@Nullable String title, @Nullable String troopUin, @Nullable ArrayList<String> uinList, @Nullable Bundle extData) {
            boolean z16;
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, title, troopUin, uinList, extData);
                return;
            }
            if (troopUin != null && troopUin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (uinList == null || uinList.isEmpty()) {
                    z17 = true;
                }
                if (!z17) {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.putExtra("title", title);
                    intent.putExtra("troopUin", troopUin);
                    intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, uinList);
                    if (extData == null) {
                        extData = new Bundle();
                    }
                    intent.putExtras(extData);
                    QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, TroopTeacherMsgRootFragment.class);
                    return;
                }
            }
            if (uinList != null) {
                num = Integer.valueOf(uinList.size());
            } else {
                num = null;
            }
            QLog.e("TroopTeacherHistoryMsgRootFragment.", 1, "openPage err, troopUin:" + troopUin + ", uid size:" + num);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/homework/historymsg/TroopTeacherMsgRootFragment$b", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends FragmentStateAdapter {
        static IPatchRedirector $redirector_;

        b() {
            super(TroopTeacherMsgRootFragment.this);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeacherMsgRootFragment.this);
            }
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
            }
            Object obj = TroopTeacherMsgRootFragment.this.fragments.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "fragments[position]");
            TroopTeacherMsgRootFragment troopTeacherMsgRootFragment = TroopTeacherMsgRootFragment.this;
            Fragment fragment = (Fragment) obj;
            Bundle bundle = new Bundle();
            bundle.putAll(troopTeacherMsgRootFragment.getArguments());
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return TroopTeacherMsgRootFragment.this.fragments.size();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeacherMsgRootFragment() {
        Lazy lazy;
        Lazy lazy2;
        ArrayList<Fragment> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.homework.historymsg.TroopTeacherMsgRootFragment$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeacherMsgRootFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? TroopTeacherMsgRootFragment.this.requireArguments().getString("troopUin", "") : (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.troopUin = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.homework.historymsg.TroopTeacherMsgRootFragment$sourceFrom$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeacherMsgRootFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
                
                    r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
                 */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Integer invoke() {
                    Integer intOrNull;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String string = TroopTeacherMsgRootFragment.this.requireArguments().getString("source_from");
                    int value = (string == null || intOrNull == null) ? IHWTroopUIApi.TeacherMsgSourceFrom.UNKNOWN.getValue() : intOrNull.intValue();
                    return Integer.valueOf(value);
                }
            });
            this.sourceFrom = lazy2;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new TroopTeacherMsgFragment(), ((ITroopTeacherApi) QRoute.api(ITroopTeacherApi.class)).createTeacherFileFragment());
            this.fragments = arrayListOf;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final int rh() {
        return ((Number) this.sourceFrom.getValue()).intValue();
    }

    private final String sh() {
        return requireArguments().getString("title", "");
    }

    private final String th() {
        return (String) this.troopUin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(TroopTeacherMsgRootFragment this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vh(this$0.curTabIndex, false);
        this$0.vh(i3, true);
        this$0.curTabIndex = i3;
    }

    private final void vh(int tabIndex, boolean isPageIn) {
        String str;
        HashMap hashMapOf;
        if (TabItem.values().length <= tabIndex) {
            return;
        }
        VideoReport.setPageId(getView(), "pg_group_teacher_msg_detail");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("group_id", th());
        pairArr[1] = TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, Integer.valueOf(TabItem.values()[tabIndex].getTabType()));
        if (rh() == IHWTroopUIApi.TeacherMsgSourceFrom.PUSH.getValue()) {
            str = AegisLogger.PUSH;
        } else {
            str = "msg_list";
        }
        pairArr[2] = TuplesKt.to(IFileBrowserService.FILE_BROWSER_PAGE_FROM, str);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        VideoReport.setPageParams(getView(), new PageParams(hashMapOf));
        VideoReport.ignorePageInOutEvent(getView(), true);
        if (isPageIn) {
            VideoReport.reportPgIn(getView());
        } else {
            VideoReport.reportPgOut(getView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.j_7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.tab_bar)");
        this.tabBar = (QUIPageTabBar) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.view_pager)");
        this.viewPager = (ViewPager2) findViewById2;
        QUIPageTabBar qUIPageTabBar = this.tabBar;
        ViewPager2 viewPager2 = null;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar = null;
        }
        TabItem[] values = TabItem.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (TabItem tabItem : values) {
            arrayList.add(tabItem.getContent());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        qUIPageTabBar.setTabData((String[]) array);
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        viewPager22.setAdapter(new b());
        QUIPageTabBar qUIPageTabBar2 = this.tabBar;
        if (qUIPageTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar2 = null;
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        qUIPageTabBar2.bindViewPager2(viewPager23);
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager2 = viewPager24;
        }
        viewPager2.setUserInputEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.g1u;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (rh() == IHWTroopUIApi.TeacherMsgSourceFrom.PUSH.getValue()) {
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            QBaseActivity qBaseActivity = getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            String troopUin = th();
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            String troopNameForPush = TroopInfoRepo.INSTANCE.getTroopNameForPush(th());
            String troopUin2 = th();
            Intrinsics.checkNotNullExpressionValue(troopUin2, "troopUin");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin2);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            iAIOStarterApi.navigateToAIO(qBaseActivity, 2, troopUin, troopNameForPush, j3, new Bundle());
        }
        return super.onBackEvent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroyView();
            vh(this.curTabIndex, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(sh());
        QUIPageTabBar qUIPageTabBar = this.tabBar;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar = null;
        }
        qUIPageTabBar.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.troop.homework.historymsg.a
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                TroopTeacherMsgRootFragment.uh(TroopTeacherMsgRootFragment.this, i3, z16);
            }
        });
        vh(this.curTabIndex, true);
    }
}
