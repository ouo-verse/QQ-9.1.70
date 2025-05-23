package com.tencent.mobileqq.search.searchdetail.content.template.ai;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.MarkdownTextView;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchShareInfo;
import com.tencent.mobileqq.search.api.ISearchShare;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.AICardFeedBackPopupWindow;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.ChooseAIModePopupWindow;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.FadeFrameLayout;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.SearchItemAdapter;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.HunYuanData;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel;
import com.tencent.mobileqq.search.searchdetail.multimedia.p;
import com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.SearchAICard;
import com.tencent.qqnt.kernel.nativeinterface.SearchAIInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchLayOut;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import com.tencent.qqnt.kernel.nativeinterface.SearchModelInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import hp2.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 p2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001qB\u0007\u00a2\u0006\u0004\bn\u0010oJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u001cH\u0002J6\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001f2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00110!H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001fH\u0002J\n\u0010*\u001a\u0004\u0018\u00010)H\u0002J\b\u0010+\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0012\u0010/\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010-H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0011022\u0006\u00101\u001a\u00020\u001fH\u0002JJ\u0010>\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u0002062\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010;\u001a\u00020:2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<H\u0002J\u0014\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001102H\u0002J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000bH\u0002R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001f0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR\u0016\u0010_\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010^R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00140X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010ZR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00140X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010ZR \u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0d0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010ZR\u001c\u0010i\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00140X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010ZR\u0016\u0010k\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010^R\u0014\u0010m\u001a\u00020\u00148TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010l\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/NetSearchHunYuanSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/b;", "Landroid/view/View;", "containerView", "", "y", "", "getViewStubLayoutId", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLayOut;", "layoutInfo", "", "L", "data", "I0", "position", "", "", "payload", "z0", "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "topView", "r0", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/a;", "u0", "view", "", "reportEId", "", "elementParam", "Q0", "state", "M0", "t0", "content", "s0", "Lcom/tencent/android/androidbypass/parser/a;", "H0", "S0", "R0", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btn", "U0", "v0", "modelName", "", "J0", IECDtReport.ACTION_IDENTIFIER, "eid", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", IECDtReport.ACTION_EXPOSE_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "endExposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "dynamicParams", "w0", "L0", "K0", "Lhp2/v;", "D", "Lhp2/v;", "binding", "E", "Lcom/tencent/android/androidbypass/parser/a;", "markdownParser", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/NetSearchHunYuanViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/NetSearchHunYuanViewModel;", "viewModel", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/SearchItemAdapter;", "G", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/SearchItemAdapter;", "searchItemAdapter", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/AICardFeedBackPopupWindow;", "H", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/AICardFeedBackPopupWindow;", "feedBackPopupWindow", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow;", "I", "Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/ui/ChooseAIModePopupWindow;", "chooseAIModePopupWindow", "Landroidx/lifecycle/Observer;", "J", "Landroidx/lifecycle/Observer;", "titleObserver", "K", "dataObserver", "Ljava/lang/String;", "lastContent", "M", "moreChatBtnObserver", "N", "expandedBtnObserver", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchListDetail;", "P", "refObserver", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "refContainerObserver", BdhLogUtil.LogTag.Tag_Req, "lastModelNameForReport", "()Z", "overrideBackground", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchHunYuanSection extends BaseSearchTemplateSection<NetSearchHunYuanItem> {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private v binding;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.parser.a markdownParser;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private NetSearchHunYuanViewModel viewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private SearchItemAdapter searchItemAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AICardFeedBackPopupWindow feedBackPopupWindow;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ChooseAIModePopupWindow chooseAIModePopupWindow;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Observer<String> titleObserver = new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.k
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            NetSearchHunYuanSection.T0(NetSearchHunYuanSection.this, (String) obj);
        }
    };

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Observer<HunYuanData> dataObserver = new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.l
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            NetSearchHunYuanSection.y0(NetSearchHunYuanSection.this, (HunYuanData) obj);
        }
    };

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String lastContent = "";

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Observer<Boolean> moreChatBtnObserver = new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.m
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            NetSearchHunYuanSection.N0(NetSearchHunYuanSection.this, (Boolean) obj);
        }
    };

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Observer<Boolean> expandedBtnObserver = new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.n
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            NetSearchHunYuanSection.G0(NetSearchHunYuanSection.this, (Boolean) obj);
        }
    };

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<SearchListDetail>> refObserver = new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.d
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            NetSearchHunYuanSection.P0(NetSearchHunYuanSection.this, (List) obj);
        }
    };

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Observer<? super Boolean> refContainerObserver = new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.e
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            NetSearchHunYuanSection.O0(NetSearchHunYuanSection.this, (Boolean) obj);
        }
    };

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String lastModelNameForReport = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/NetSearchHunYuanSection$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "", "a", "LOADING_URL", "Ljava/lang/String;", "", "MAX_LINE_COUNT", "I", "REPORT_EID_CONTENT", "REPORT_EID_ERROR", "TAG", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String a(@NotNull SearchJump searchJump) {
            boolean z16;
            Intrinsics.checkNotNullParameter(searchJump, "<this>");
            String str = searchJump.jumpAndLink;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return searchJump.jumpAndLink;
            }
            return searchJump.jumpLink;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J*\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/template/ai/NetSearchHunYuanSection$b", "Lee0/b;", "Landroid/content/Context;", "context", "", "buttonType", "sizeType", "f", "type", "themeId", tl.h.F, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends ee0.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int f(@Nullable Context context, int buttonType, int sizeType) {
            return com.tencent.qqnt.aio.utils.l.b(12);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int h(@Nullable Context context, int type, int sizeType, int themeId) {
            return com.tencent.qqnt.aio.utils.l.b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(NetSearchHunYuanSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this$0.viewModel;
        if (netSearchHunYuanViewModel != null) {
            netSearchHunYuanViewModel.O2();
        }
        com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
        v vVar = this$0.binding;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        LinearLayout linearLayout = vVar.f405763i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
        com.tencent.mobileqq.search.report.a.f(aVar, "clck", linearLayout, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(NetSearchHunYuanSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this$0.viewModel;
        if (netSearchHunYuanViewModel != null) {
            netSearchHunYuanViewModel.O2();
        }
        com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
        v vVar = this$0.binding;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        LinearLayout linearLayout = vVar.f405763i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
        com.tencent.mobileqq.search.report.a.f(aVar, "clck", linearLayout, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(NetSearchHunYuanSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this$0.viewModel;
        if (netSearchHunYuanViewModel != null) {
            netSearchHunYuanViewModel.O2();
        }
        com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
        v vVar = this$0.binding;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        LinearLayout linearLayout = vVar.f405763i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
        com.tencent.mobileqq.search.report.a.f(aVar, "clck", linearLayout, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(NetSearchHunYuanSection this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v vVar = this$0.binding;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        ImageView imageView = vVar.f405769o;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingIcon");
        p.b(imageView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(NetSearchHunYuanSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this$0.viewModel;
        if (netSearchHunYuanViewModel != null) {
            netSearchHunYuanViewModel.V2(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(NetSearchHunYuanSection this$0, Boolean isShowExpandedBtn) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v vVar = this$0.binding;
        v vVar2 = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        LinearLayout linearLayout = vVar.f405764j;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.expand");
        Intrinsics.checkNotNullExpressionValue(isShowExpandedBtn, "isShowExpandedBtn");
        p.b(linearLayout, isShowExpandedBtn.booleanValue());
        if (isShowExpandedBtn.booleanValue()) {
            v vVar3 = this$0.binding;
            if (vVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar3 = null;
            }
            vVar3.f405760f.setMaxLines(9);
            v vVar4 = this$0.binding;
            if (vVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                vVar2 = vVar4;
            }
            vVar2.f405761g.setDrawSize(ViewUtils.dip2px(24.0f));
            return;
        }
        v vVar5 = this$0.binding;
        if (vVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar5 = null;
        }
        vVar5.f405760f.setMaxLines(Integer.MAX_VALUE);
        v vVar6 = this$0.binding;
        if (vVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vVar2 = vVar6;
        }
        vVar2.f405761g.setDrawSize(0.0f);
    }

    private final com.tencent.android.androidbypass.parser.a H0() {
        if (this.markdownParser == null) {
            com.tencent.android.androidbypass.enhance.i iVar = new com.tencent.android.androidbypass.enhance.i();
            o oVar = o.f284142a;
            v vVar = this.binding;
            v vVar2 = null;
            if (vVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar = null;
            }
            Context context = vVar.getMContainer().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            float a16 = oVar.a(context);
            v vVar3 = this.binding;
            if (vVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar3 = null;
            }
            iVar.f72206v = vVar3.getMContainer().getContext().getColor(R.color.qui_common_brand_standard);
            iVar.f72210z = (int) (4 * a16);
            iVar.B = 7;
            iVar.C = 1;
            iVar.f72209y = 0.875f;
            v vVar4 = this.binding;
            if (vVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                vVar2 = vVar4;
            }
            iVar.f72205u = vVar2.getMContainer().getContext().getColor(R.color.qui_common_text_primary);
            iVar.f72208x = 0.65f;
            iVar.f72207w = 0.1f;
            float f16 = 8.0f * a16;
            iVar.f72180c = f16;
            float f17 = 12.0f * a16;
            iVar.f72184e = f17;
            iVar.Z = f17;
            iVar.Q = a16 * 1.0f;
            iVar.S = f16;
            iVar.U = f17;
            this.markdownParser = com.tencent.qqnt.markdown.g.f359430a.g().h(iVar).b();
        }
        return this.markdownParser;
    }

    private final Map<String, Object> J0(String modelName) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ai_model_types", modelName);
        return linkedHashMap;
    }

    private final String K0(int state) {
        String A2;
        Pair<String, String> q26;
        String second;
        if (M0(state)) {
            NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
            if (netSearchHunYuanViewModel == null || (q26 = netSearchHunYuanViewModel.q2()) == null || (second = q26.getSecond()) == null) {
                return "";
            }
            return second;
        }
        if (state != 4) {
            if (state != 5) {
                if (state != 6) {
                    return "";
                }
                return "\u7f51\u7edc\u8fde\u63a5\u8d85\u65f6\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5";
            }
            NetSearchHunYuanViewModel netSearchHunYuanViewModel2 = this.viewModel;
            if (netSearchHunYuanViewModel2 == null || (A2 = netSearchHunYuanViewModel2.A2()) == null) {
                return "\u95ee\u7b54\u7ed3\u679c\u8bf7\u6c42\u5931\u8d25";
            }
            return A2;
        }
        return "\u95ee\u7b54\u7ed3\u679c\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5";
    }

    private final Map<String, Object> L0() {
        String str;
        MediatorLiveData<HunYuanData> u26;
        HunYuanData value;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
        if (netSearchHunYuanViewModel == null || (u26 = netSearchHunYuanViewModel.u2()) == null || (value = u26.getValue()) == null || (str = K0(value.getState())) == null) {
            str = "";
        }
        linkedHashMap.put("failreason", str);
        return linkedHashMap;
    }

    private final boolean M0(int state) {
        String str;
        Pair<String, String> q26;
        if (state == 8) {
            NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
            if (netSearchHunYuanViewModel != null && (q26 = netSearchHunYuanViewModel.q2()) != null) {
                str = q26.getFirst();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, HippyQQConstants.HIPPY_CHANNEL)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(final NetSearchHunYuanSection this$0, Boolean isShowBtn) {
        String str;
        String str2;
        SearchAICard aiCard;
        SearchButton searchButton;
        SearchAICard aiCard2;
        SearchButton searchButton2;
        SearchJump searchJump;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this$0.viewModel;
        v vVar = null;
        if (netSearchHunYuanViewModel != null && (aiCard2 = netSearchHunYuanViewModel.getAiCard()) != null && (searchButton2 = aiCard2.button) != null && (searchJump = searchButton2.jumpLink) != null) {
            str = INSTANCE.a(searchJump);
        } else {
            str = null;
        }
        v vVar2 = this$0.binding;
        if (vVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar2 = null;
        }
        VideoReport.setElementParam(vVar2.f405768n, "jump_link", str);
        v vVar3 = this$0.binding;
        if (vVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar3 = null;
        }
        QUIButton qUIButton = vVar3.f405768n;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.gotoMoreChatBtn");
        Intrinsics.checkNotNullExpressionValue(isShowBtn, "isShowBtn");
        p.b(qUIButton, isShowBtn.booleanValue());
        v vVar4 = this$0.binding;
        if (vVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar4 = null;
        }
        QUIButton qUIButton2 = vVar4.f405768n;
        NetSearchHunYuanViewModel netSearchHunYuanViewModel2 = this$0.viewModel;
        if (netSearchHunYuanViewModel2 == null || (aiCard = netSearchHunYuanViewModel2.getAiCard()) == null || (searchButton = aiCard.button) == null || (str2 = searchButton.title) == null) {
            str2 = "\u66f4\u591a\u89e3\u7b54";
        }
        qUIButton2.setText(str2);
        rn2.j jVar = rn2.j.f431768a;
        v vVar5 = this$0.binding;
        if (vVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vVar = vVar5;
        }
        QUIButton qUIButton3 = vVar.f405768n;
        Intrinsics.checkNotNullExpressionValue(qUIButton3, "binding.gotoMoreChatBtn");
        rn2.j.u(jVar, qUIButton3, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$moreChatBtnObserver$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view) {
                final NetSearchHunYuanViewModel netSearchHunYuanViewModel3;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                netSearchHunYuanViewModel3 = NetSearchHunYuanSection.this.viewModel;
                if (netSearchHunYuanViewModel3 != null) {
                    final NetSearchHunYuanSection netSearchHunYuanSection = NetSearchHunYuanSection.this;
                    netSearchHunYuanViewModel3.J2(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$moreChatBtnObserver$1$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            g.a.a(NetSearchHunYuanSection.this, netSearchHunYuanViewModel3.getAiCard().button.jumpLink, null, 2, null);
                        }
                    });
                }
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(NetSearchHunYuanSection this$0, Boolean isShowRefContainer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v vVar = this$0.binding;
        v vVar2 = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        ConstraintLayout constraintLayout = vVar.f405773s;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.refContainer");
        Intrinsics.checkNotNullExpressionValue(isShowRefContainer, "isShowRefContainer");
        p.b(constraintLayout, isShowRefContainer.booleanValue());
        if (isShowRefContainer.booleanValue()) {
            v vVar3 = this$0.binding;
            if (vVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                vVar2 = vVar3;
            }
            ConstraintLayout constraintLayout2 = vVar2.f405773s;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.refContainer");
            this$0.r0(constraintLayout2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(NetSearchHunYuanSection this$0, List refList) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        v vVar = this$0.binding;
        SearchItemAdapter searchItemAdapter = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        TextView textView = vVar.f405775u;
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this$0.viewModel;
        if (netSearchHunYuanViewModel == null || (str = netSearchHunYuanViewModel.getRefTitle()) == null) {
            str = "\u53c2\u8003\u8d44\u6599";
        }
        textView.setText(str);
        SearchItemAdapter searchItemAdapter2 = this$0.searchItemAdapter;
        if (searchItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchItemAdapter");
        } else {
            searchItemAdapter = searchItemAdapter2;
        }
        Intrinsics.checkNotNullExpressionValue(refList, "refList");
        searchItemAdapter.setItems(refList);
    }

    private final void Q0(View view, boolean visible, String reportEId, Map<String, ? extends Object> elementParam) {
        boolean z16;
        if (view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (visible != z16) {
            if (visible) {
                com.tencent.mobileqq.search.report.a.f283716a.d("dt_imp", view, reportEId, elementParam);
            } else {
                com.tencent.mobileqq.search.report.a.f283716a.d("dt_imp_end", view, reportEId, elementParam);
            }
        }
        p.b(view, visible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(View view) {
        Activity activity;
        Object obj;
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
        if (netSearchHunYuanViewModel != null) {
            ArrayList<SearchModelInfo> modelList = netSearchHunYuanViewModel.getAiCard().aiInfo.modelListInfo.modelInfos;
            if (netSearchHunYuanViewModel.getAiCard().aiInfo.modelListInfo.choose) {
                Intrinsics.checkNotNullExpressionValue(modelList, "modelList");
                if (!modelList.isEmpty()) {
                    if (this.chooseAIModePopupWindow == null) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
                        if (dtReportIoc != null) {
                            obj = Integer.valueOf(dtReportIoc.getPageMode());
                        } else {
                            obj = SearchDetailFragment.Companion.PageMode.MODE_NORMAL;
                        }
                        linkedHashMap.put(PictureConst.KEY_PAGE_MODE, obj);
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "view.context");
                        this.chooseAIModePopupWindow = new ChooseAIModePopupWindow(context, linkedHashMap, new Function2<Integer, SearchModelInfo, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$showChooseModelPopupWindow$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, SearchModelInfo searchModelInfo) {
                                invoke(num.intValue(), searchModelInfo);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i3, @NotNull SearchModelInfo newModel) {
                                NetSearchHunYuanViewModel netSearchHunYuanViewModel2;
                                Intrinsics.checkNotNullParameter(newModel, "newModel");
                                af afVar = af.f284993a;
                                QLog.i("QS.NetSearchHunYuanDelegate", 1, "choose model=" + newModel + " pos=" + i3 + " ", null);
                                netSearchHunYuanViewModel2 = NetSearchHunYuanSection.this.viewModel;
                                if (netSearchHunYuanViewModel2 != null) {
                                    netSearchHunYuanViewModel2.l2(newModel);
                                }
                            }
                        });
                    }
                    int[] iArr = new int[2];
                    v vVar = this.binding;
                    if (vVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar = null;
                    }
                    vVar.f405780z.getLocationOnScreen(iArr);
                    int[] iArr2 = new int[2];
                    Context context2 = view.getContext();
                    if (context2 instanceof Activity) {
                        activity = (Activity) context2;
                    } else {
                        activity = null;
                    }
                    if (activity == null) {
                        return;
                    }
                    activity.getWindow().getDecorView().getLocationOnScreen(iArr2);
                    int i3 = 0;
                    int dip2px = ((iArr[0] - ViewUtils.dip2px(16.0f)) - ViewUtils.dip2px(20.0f)) - iArr2[0];
                    Iterator<SearchModelInfo> it = modelList.iterator();
                    int i16 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual(it.next().modelRealName, netSearchHunYuanViewModel.getCurrentModeInfo().getSearchModelInfo().modelRealName)) {
                                break;
                            } else {
                                i16++;
                            }
                        } else {
                            i16 = -1;
                            break;
                        }
                    }
                    if (i16 >= 0) {
                        i3 = i16;
                    }
                    ChooseAIModePopupWindow chooseAIModePopupWindow = this.chooseAIModePopupWindow;
                    if (chooseAIModePopupWindow != null) {
                        v vVar2 = this.binding;
                        if (vVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            vVar2 = null;
                        }
                        TextView textView = vVar2.f405780z;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvAi");
                        chooseAIModePopupWindow.p(textView, modelList, i3, dip2px);
                    }
                    af afVar = af.f284993a;
                    if (QLog.isDebugVersion()) {
                        QLog.d("QS.NetSearchHunYuanDelegate", 2, "show choose model list selectedPos=" + i16 + " " + netSearchHunYuanViewModel.getLastSelectedModeRealName(), (Throwable) null);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0() {
        String str;
        Activity activity;
        SearchAICard aiCard;
        SearchAIInfo searchAIInfo;
        SearchAICard aiCard2;
        SearchAIInfo searchAIInfo2;
        af afVar = af.f284993a;
        String str2 = "QS.NetSearchHunYuanDelegate";
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
        String str3 = null;
        if (netSearchHunYuanViewModel != null && (aiCard2 = netSearchHunYuanViewModel.getAiCard()) != null && (searchAIInfo2 = aiCard2.aiInfo) != null) {
            str = searchAIInfo2.questionId;
        } else {
            str = null;
        }
        QLog.i(str2, 1, "start share questionId=" + str, null);
        v vVar = this.binding;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        Context context = vVar.getMContainer().getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            ISearchShare iSearchShare = (ISearchShare) QRoute.api(ISearchShare.class);
            View containerView = getContainerView();
            NetSearchHunYuanViewModel netSearchHunYuanViewModel2 = this.viewModel;
            if (netSearchHunYuanViewModel2 != null && (aiCard = netSearchHunYuanViewModel2.getAiCard()) != null && (searchAIInfo = aiCard.aiInfo) != null) {
                str3 = searchAIInfo.questionId;
            }
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "viewModel?.aiCard?.aiInfo?.questionId ?: \"\"");
            }
            iSearchShare.share(activity, containerView, new SearchShareInfo(str3, "pg_qq_network_search_result_level2_page"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(NetSearchHunYuanSection this$0, String title) {
        boolean z16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        int i26 = 0;
        if (title.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = null;
        if (z16) {
            v vVar = this$0.binding;
            if (vVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar = null;
            }
            vVar.f405778x.setVisibility(8);
        } else {
            v vVar2 = this$0.binding;
            if (vVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar2 = null;
            }
            vVar2.f405778x.setVisibility(0);
        }
        v vVar3 = this$0.binding;
        if (vVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar3 = null;
        }
        vVar3.f405778x.setText(title);
        SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = this$0.getDtReportIoc();
        if (dtReportIoc != null) {
            i26 = dtReportIoc.getPageMode();
        }
        if (!companion.c(i26)) {
            v vVar4 = this$0.binding;
            if (vVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar4 = null;
            }
            vVar4.f405778x.setTextSize(1, 20.0f);
            int dip2px = ViewUtils.dip2px(7.0f);
            v vVar5 = this$0.binding;
            if (vVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar5 = null;
            }
            LinearLayout linearLayout = vVar5.f405771q;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.loadingView");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            int i27 = -2;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
                if (layoutParams2 != null) {
                    i18 = layoutParams2.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
                if (layoutParams3 != null) {
                    i19 = layoutParams3.height;
                } else {
                    i19 = -2;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            marginLayoutParams.topMargin = dip2px;
            linearLayout.setLayoutParams(marginLayoutParams);
            v vVar6 = this$0.binding;
            if (vVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar6 = null;
            }
            LinearLayout linearLayout2 = vVar6.f405763i;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
            ViewGroup.LayoutParams layoutParams4 = linearLayout2.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
            } else {
                marginLayoutParams2 = null;
            }
            if (marginLayoutParams2 == null) {
                ViewGroup.LayoutParams layoutParams5 = linearLayout2.getLayoutParams();
                if (layoutParams5 != null) {
                    i16 = layoutParams5.width;
                } else {
                    i16 = -2;
                }
                ViewGroup.LayoutParams layoutParams6 = linearLayout2.getLayoutParams();
                if (layoutParams6 != null) {
                    i17 = layoutParams6.height;
                } else {
                    i17 = -2;
                }
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(i16, i17);
            }
            marginLayoutParams2.topMargin = dip2px;
            linearLayout2.setLayoutParams(marginLayoutParams2);
            v vVar7 = this$0.binding;
            if (vVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar7 = null;
            }
            FadeFrameLayout fadeFrameLayout = vVar7.f405761g;
            Intrinsics.checkNotNullExpressionValue(fadeFrameLayout, "binding.contentWrapper");
            ViewGroup.LayoutParams layoutParams7 = fadeFrameLayout.getLayoutParams();
            if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams7;
            }
            if (marginLayoutParams3 == null) {
                ViewGroup.LayoutParams layoutParams8 = fadeFrameLayout.getLayoutParams();
                if (layoutParams8 != null) {
                    i3 = layoutParams8.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams9 = fadeFrameLayout.getLayoutParams();
                if (layoutParams9 != null) {
                    i27 = layoutParams9.height;
                }
                marginLayoutParams3 = new ViewGroup.MarginLayoutParams(i3, i27);
            }
            marginLayoutParams3.topMargin = dip2px;
            fadeFrameLayout.setLayoutParams(marginLayoutParams3);
        }
    }

    private final void U0(QUIButton btn) {
        if (btn != null) {
            btn.setQUIButtonResHelper(new b());
        }
    }

    private final void r0(View topView) {
        v vVar = this.binding;
        v vVar2 = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        LinearLayout linearLayout = vVar.f405758d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomLayout");
        p.b(linearLayout, true);
        v vVar3 = this.binding;
        if (vVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar3 = null;
        }
        ViewGroup.LayoutParams layoutParams = vVar3.f405758d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.topToBottom = topView.getId();
        v vVar4 = this.binding;
        if (vVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vVar2 = vVar4;
        }
        vVar2.f405758d.setLayoutParams(layoutParams2);
    }

    private final void s0(String content) {
        boolean z16;
        boolean z17;
        boolean z18;
        NetSearchHunYuanViewModel netSearchHunYuanViewModel;
        SearchAICard aiCard;
        SearchText searchText;
        String str;
        boolean isBlank;
        MediatorLiveData<HunYuanData> u26;
        HunYuanData value;
        MutableLiveData<Boolean> t26;
        com.tencent.android.androidbypass.parser.a H0 = H0();
        if (H0 != null) {
            v vVar = this.binding;
            if (vVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar = null;
            }
            a.C0724a.a(H0, content, vVar.f405760f, null, 4, null);
        }
        if (content.length() > this.lastContent.length()) {
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                String substring = content.substring(this.lastContent.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                QLog.d("QS.NetSearchHunYuanDelegate", 2, "bindContent new " + substring, (Throwable) null);
            }
        } else {
            af afVar2 = af.f284993a;
            if (QLog.isDebugVersion()) {
                QLog.d("QS.NetSearchHunYuanDelegate", 2, "bindContent " + content, (Throwable) null);
            }
        }
        this.lastContent = content;
        NetSearchHunYuanViewModel netSearchHunYuanViewModel2 = this.viewModel;
        boolean z19 = false;
        if (netSearchHunYuanViewModel2 != null && (t26 = netSearchHunYuanViewModel2.t2()) != null) {
            z16 = Intrinsics.areEqual(t26.getValue(), Boolean.TRUE);
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null && dtReportIoc.c()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            v vVar2 = this.binding;
            if (vVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar2 = null;
            }
            if (vVar2.f405760f.getLineCount() > 9) {
                if (QLog.isDebugVersion()) {
                    QLog.d("QS.NetSearchHunYuanDelegate", 2, "bindContent not ai mode show expand btn", (Throwable) null);
                }
                NetSearchHunYuanViewModel netSearchHunYuanViewModel3 = this.viewModel;
                if (netSearchHunYuanViewModel3 != null) {
                    netSearchHunYuanViewModel3.V2(true);
                }
            }
        }
        NetSearchHunYuanViewModel netSearchHunYuanViewModel4 = this.viewModel;
        if (netSearchHunYuanViewModel4 != null && (u26 = netSearchHunYuanViewModel4.u2()) != null && (value = u26.getValue()) != null && value.getState() == 3) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            NetSearchHunYuanViewModel netSearchHunYuanViewModel5 = this.viewModel;
            if (netSearchHunYuanViewModel5 != null && (aiCard = netSearchHunYuanViewModel5.getAiCard()) != null && (searchText = aiCard.content) != null && (str = searchText.text) != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z19 = true;
                }
            }
            if (z19 && (netSearchHunYuanViewModel = this.viewModel) != null) {
                netSearchHunYuanViewModel.W2();
            }
        }
    }

    private final void t0() {
        int i3;
        String str;
        SearchAICard aiCard;
        SearchIcon searchIcon;
        SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        boolean z16 = false;
        if (dtReportIoc != null) {
            i3 = dtReportIoc.getPageMode();
        } else {
            i3 = 0;
        }
        if (!companion.c(i3)) {
            NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
            if (netSearchHunYuanViewModel != null && (aiCard = netSearchHunYuanViewModel.getAiCard()) != null && (searchIcon = aiCard.icon) != null) {
                str = searchIcon.iconLink;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (str.length() > 0) {
                z16 = true;
            }
            if (z16) {
                Option url = Option.obtain().setUrl(str);
                v vVar = this.binding;
                if (vVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar = null;
                }
                Option option = url.setTargetView(vVar.f405756b);
                SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
                Intrinsics.checkNotNullExpressionValue(option, "option");
                searchPicLoader.e(option, null);
            }
        }
    }

    private final void u0(HunYuanData data) {
        String str;
        NetSearchHunYuanDepositary.ModelInfo currentModeInfo;
        SearchModelInfo searchModelInfo;
        boolean z16;
        boolean z17 = true;
        v vVar = null;
        switch (data.getState()) {
            case 1:
                v vVar2 = this.binding;
                if (vVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar2 = null;
                }
                LinearLayout linearLayout = vVar2.f405771q;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.loadingView");
                p.b(linearLayout, true);
                v vVar3 = this.binding;
                if (vVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar3 = null;
                }
                LinearLayout linearLayout2 = vVar3.f405763i;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
                Q0(linearLayout2, false, "em_bas_ai_request_failed", L0());
                v vVar4 = this.binding;
                if (vVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar4 = null;
                }
                MarkdownTextView markdownTextView = vVar4.f405760f;
                Intrinsics.checkNotNullExpressionValue(markdownTextView, "binding.content");
                Q0(markdownTextView, false, "em_bas_ai_content", J0(this.lastModelNameForReport));
                v vVar5 = this.binding;
                if (vVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar5 = null;
                }
                LinearLayout linearLayout3 = vVar5.f405764j;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.expand");
                p.b(linearLayout3, false);
                v vVar6 = this.binding;
                if (vVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar6 = null;
                }
                ConstraintLayout constraintLayout = vVar6.f405773s;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.refContainer");
                p.b(constraintLayout, false);
                v vVar7 = this.binding;
                if (vVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar7 = null;
                }
                QUIButton qUIButton = vVar7.f405768n;
                Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.gotoMoreChatBtn");
                p.b(qUIButton, false);
                v vVar8 = this.binding;
                if (vVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar8 = null;
                }
                vVar8.f405758d.setVisibility(8);
                v vVar9 = this.binding;
                if (vVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    vVar = vVar9;
                }
                vVar.f405770p.setText(ap2.b.INSTANCE.a().getLoadingText());
                return;
            case 2:
            case 3:
            case 7:
            case 9:
                v vVar10 = this.binding;
                if (vVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar10 = null;
                }
                LinearLayout linearLayout4 = vVar10.f405771q;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.loadingView");
                p.b(linearLayout4, false);
                v vVar11 = this.binding;
                if (vVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar11 = null;
                }
                LinearLayout linearLayout5 = vVar11.f405763i;
                Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.errorView");
                Q0(linearLayout5, false, "em_bas_ai_request_failed", L0());
                NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
                if (netSearchHunYuanViewModel != null && (currentModeInfo = netSearchHunYuanViewModel.getCurrentModeInfo()) != null && (searchModelInfo = currentModeInfo.getSearchModelInfo()) != null) {
                    str = searchModelInfo.modelRealName;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                this.lastModelNameForReport = str;
                v vVar12 = this.binding;
                if (vVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar12 = null;
                }
                MarkdownTextView markdownTextView2 = vVar12.f405760f;
                Intrinsics.checkNotNullExpressionValue(markdownTextView2, "binding.content");
                Q0(markdownTextView2, true, "em_bas_ai_content", J0(this.lastModelNameForReport));
                v vVar13 = this.binding;
                if (vVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar13 = null;
                }
                ConstraintLayout constraintLayout2 = vVar13.f405773s;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.refContainer");
                if (constraintLayout2.getVisibility() != 0) {
                    z17 = false;
                }
                if (z17) {
                    v vVar14 = this.binding;
                    if (vVar14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        vVar = vVar14;
                    }
                    ConstraintLayout constraintLayout3 = vVar.f405773s;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.refContainer");
                    r0(constraintLayout3);
                    return;
                }
                v vVar15 = this.binding;
                if (vVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    vVar = vVar15;
                }
                FadeFrameLayout fadeFrameLayout = vVar.f405761g;
                Intrinsics.checkNotNullExpressionValue(fadeFrameLayout, "binding.contentWrapper");
                r0(fadeFrameLayout);
                return;
            case 4:
            case 5:
            case 6:
            case 8:
                v vVar16 = this.binding;
                if (vVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar16 = null;
                }
                LinearLayout linearLayout6 = vVar16.f405771q;
                Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.loadingView");
                p.b(linearLayout6, false);
                v vVar17 = this.binding;
                if (vVar17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar17 = null;
                }
                LinearLayout linearLayout7 = vVar17.f405763i;
                Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.errorView");
                Q0(linearLayout7, true, "em_bas_ai_request_failed", L0());
                v vVar18 = this.binding;
                if (vVar18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar18 = null;
                }
                MarkdownTextView markdownTextView3 = vVar18.f405760f;
                Intrinsics.checkNotNullExpressionValue(markdownTextView3, "binding.content");
                if (data.getState() == 6) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Q0(markdownTextView3, z16, "em_bas_ai_content", J0(this.lastModelNameForReport));
                if (data.getState() != 5 && !M0(data.getState())) {
                    v vVar19 = this.binding;
                    if (vVar19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar19 = null;
                    }
                    ImageView imageView = vVar19.f405776v;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.retryBtn");
                    p.b(imageView, true);
                } else {
                    v vVar20 = this.binding;
                    if (vVar20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar20 = null;
                    }
                    ImageView imageView2 = vVar20.f405776v;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.retryBtn");
                    p.b(imageView2, false);
                }
                v vVar21 = this.binding;
                if (vVar21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vVar21 = null;
                }
                vVar21.f405762h.setText(K0(data.getState()));
                v vVar22 = this.binding;
                if (vVar22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    vVar = vVar22;
                }
                LinearLayout linearLayout8 = vVar.f405763i;
                Intrinsics.checkNotNullExpressionValue(linearLayout8, "binding.errorView");
                r0(linearLayout8);
                return;
            default:
                return;
        }
    }

    private final void v0() {
        int i3;
        Integer num;
        SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            i3 = dtReportIoc.getPageMode();
        } else {
            i3 = 0;
        }
        if (companion.c(i3)) {
            v vVar = this.binding;
            if (vVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar = null;
            }
            vVar.f405779y.setVisibility(8);
            v vVar2 = this.binding;
            if (vVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar2 = null;
            }
            vVar2.f405777w.setVisibility(8);
            v vVar3 = this.binding;
            if (vVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar3 = null;
            }
            vVar3.f405767m.setVisibility(8);
            v vVar4 = this.binding;
            if (vVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar4 = null;
            }
            ViewGroup.LayoutParams layoutParams = vVar4.f405778x.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.topToTop = 0;
            layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, 0, ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
            v vVar5 = this.binding;
            if (vVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar5 = null;
            }
            vVar5.f405778x.setLayoutParams(layoutParams2);
        } else {
            v vVar6 = this.binding;
            if (vVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar6 = null;
            }
            LinearLayout linearLayout = vVar6.f405779y;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.titleLayout");
            p.b(linearLayout, true);
            v vVar7 = this.binding;
            if (vVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar7 = null;
            }
            FrameLayout frameLayout = vVar7.f405777w;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.shareBtn");
            p.b(frameLayout, true);
            v vVar8 = this.binding;
            if (vVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar8 = null;
            }
            FrameLayout frameLayout2 = vVar8.f405767m;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.feedbackEntry");
            p.b(frameLayout2, true);
        }
        af afVar = af.f284993a;
        if (QLog.isDebugVersion()) {
            String str = "QS.NetSearchHunYuanDelegate";
            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc2 = getDtReportIoc();
            if (dtReportIoc2 != null) {
                num = Integer.valueOf(dtReportIoc2.getPageMode());
            } else {
                num = null;
            }
            QLog.d(str, 2, "bindTitle pageMode=" + num, (Throwable) null);
        }
    }

    private final void w0(String identifier, String eid, View view, ExposurePolicy exposePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy, IDynamicParams dynamicParams) {
        com.tencent.mobileqq.search.report.a.b(com.tencent.mobileqq.search.report.a.f283716a, identifier + "_" + view.hashCode(), eid, view, exposePolicy, endExposurePolicy, clickPolicy, null, dynamicParams, 64, null);
    }

    static /* synthetic */ void x0(NetSearchHunYuanSection netSearchHunYuanSection, String str, String str2, View view, ExposurePolicy exposurePolicy, EndExposurePolicy endExposurePolicy, ClickPolicy clickPolicy, IDynamicParams iDynamicParams, int i3, Object obj) {
        ExposurePolicy exposurePolicy2;
        EndExposurePolicy endExposurePolicy2;
        ClickPolicy clickPolicy2;
        IDynamicParams iDynamicParams2;
        if ((i3 & 8) != 0) {
            exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy2 = exposurePolicy;
        }
        if ((i3 & 16) != 0) {
            endExposurePolicy2 = EndExposurePolicy.REPORT_NONE;
        } else {
            endExposurePolicy2 = endExposurePolicy;
        }
        if ((i3 & 32) != 0) {
            clickPolicy2 = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy2 = clickPolicy;
        }
        if ((i3 & 64) != 0) {
            iDynamicParams2 = null;
        } else {
            iDynamicParams2 = iDynamicParams;
        }
        netSearchHunYuanSection.w0(str, str2, view, exposurePolicy2, endExposurePolicy2, clickPolicy2, iDynamicParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(NetSearchHunYuanSection this$0, HunYuanData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        this$0.u0(data);
        this$0.s0(data.getContent());
        this$0.t0();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public int D(@NotNull NetSearchHunYuanItem data) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            i3 = dtReportIoc.getPageMode();
        } else {
            i3 = 0;
        }
        if (companion.c(i3)) {
            return 0;
        }
        return super.D(data);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public int L(@NotNull SearchLayOut layoutInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            i3 = dtReportIoc.getPageMode();
        } else {
            i3 = 0;
        }
        if (companion.c(i3)) {
            return 0;
        }
        return super.L(layoutInfo);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: M */
    protected boolean getOverrideBackground() {
        int i3;
        SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            i3 = dtReportIoc.getPageMode();
        } else {
            i3 = 0;
        }
        return companion.c(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (!attached) {
            AICardFeedBackPopupWindow aICardFeedBackPopupWindow = this.feedBackPopupWindow;
            if (aICardFeedBackPopupWindow != null) {
                aICardFeedBackPopupWindow.r();
            }
            ChooseAIModePopupWindow chooseAIModePopupWindow = this.chooseAIModePopupWindow;
            if (chooseAIModePopupWindow != null) {
                chooseAIModePopupWindow.j();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
        if (netSearchHunYuanViewModel != null) {
            netSearchHunYuanViewModel.u2().removeObserver(this.dataObserver);
            netSearchHunYuanViewModel.B2().removeObserver(this.titleObserver);
            netSearchHunYuanViewModel.F2().removeObserver(this.expandedBtnObserver);
            netSearchHunYuanViewModel.y2().removeObserver(this.refObserver);
            netSearchHunYuanViewModel.H2().removeObserver(this.refContainerObserver);
            netSearchHunYuanViewModel.onDestroy();
        }
        AICardFeedBackPopupWindow aICardFeedBackPopupWindow = this.feedBackPopupWindow;
        if (aICardFeedBackPopupWindow != null) {
            aICardFeedBackPopupWindow.r();
        }
        ChooseAIModePopupWindow chooseAIModePopupWindow = this.chooseAIModePopupWindow;
        if (chooseAIModePopupWindow != null) {
            chooseAIModePopupWindow.j();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        boolean z16;
        String str;
        super.onVisibleChanged(visible);
        v vVar = this.binding;
        v vVar2 = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        MarkdownTextView markdownTextView = vVar.f405760f;
        Intrinsics.checkNotNullExpressionValue(markdownTextView, "binding.content");
        boolean z17 = true;
        if (markdownTextView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "dt_imp";
        if (z16) {
            if (visible) {
                str = "dt_imp";
            } else {
                str = "dt_imp_end";
            }
            com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
            v vVar3 = this.binding;
            if (vVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar3 = null;
            }
            MarkdownTextView markdownTextView2 = vVar3.f405760f;
            Intrinsics.checkNotNullExpressionValue(markdownTextView2, "binding.content");
            aVar.d(str, markdownTextView2, "em_bas_ai_content", J0(this.lastModelNameForReport));
        }
        v vVar4 = this.binding;
        if (vVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar4 = null;
        }
        LinearLayout linearLayout = vVar4.f405763i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
        if (linearLayout.getVisibility() != 0) {
            z17 = false;
        }
        if (z17) {
            if (!visible) {
                str2 = "dt_imp_end";
            }
            com.tencent.mobileqq.search.report.a aVar2 = com.tencent.mobileqq.search.report.a.f283716a;
            v vVar5 = this.binding;
            if (vVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                vVar2 = vVar5;
            }
            LinearLayout linearLayout2 = vVar2.f405763i;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
            aVar2.d(str2, linearLayout2, "em_bas_ai_request_failed", L0());
        }
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
        if (netSearchHunYuanViewModel != null) {
            netSearchHunYuanViewModel.M2(visible);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable final View containerView) {
        List emptyList;
        if (containerView != null) {
            v e16 = v.e(containerView);
            Intrinsics.checkNotNullExpressionValue(e16, "bind(view)");
            this.binding = e16;
            v vVar = null;
            if (e16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                e16 = null;
            }
            ImageView imageView = e16.f405769o;
            v vVar2 = this.binding;
            if (vVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar2 = null;
            }
            imageView.setColorFilter(new PorterDuffColorFilter(vVar2.f405769o.getContext().getColor(R.color.qui_common_text_primary), PorterDuff.Mode.SRC_IN));
            v vVar3 = this.binding;
            if (vVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar3 = null;
            }
            TextView textView = vVar3.f405772r;
            v vVar4 = this.binding;
            if (vVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar4 = null;
            }
            textView.setMaxWidth(x.f(vVar4.f405772r.getContext()).b() - com.tencent.qqnt.aio.utils.l.b(205));
            v vVar5 = this.binding;
            if (vVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar5 = null;
            }
            vVar5.f405780z.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetSearchHunYuanSection.B0(NetSearchHunYuanSection.this, view);
                }
            });
            v vVar6 = this.binding;
            if (vVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar6 = null;
            }
            vVar6.f405778x.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetSearchHunYuanSection.C0(NetSearchHunYuanSection.this, view);
                }
            });
            v vVar7 = this.binding;
            if (vVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar7 = null;
            }
            vVar7.f405763i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetSearchHunYuanSection.D0(NetSearchHunYuanSection.this, view);
                }
            });
            rn2.j jVar = rn2.j.f431768a;
            v vVar8 = this.binding;
            if (vVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar8 = null;
            }
            TextView textView2 = vVar8.f405772r;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.modelName");
            rn2.j.u(jVar, textView2, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$doOnInitView$1$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    v vVar9;
                    Intrinsics.checkNotNullParameter(it, "it");
                    NetSearchHunYuanSection.this.R0(containerView);
                    vVar9 = NetSearchHunYuanSection.this.binding;
                    if (vVar9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar9 = null;
                    }
                    VideoReport.reportEvent("clck", vVar9.f405772r, new HashMap());
                }
            }, 3, null);
            v vVar9 = this.binding;
            if (vVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar9 = null;
            }
            ImageView imageView2 = vVar9.f405759e;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.chooseModel");
            rn2.j.u(jVar, imageView2, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$doOnInitView$1$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    v vVar10;
                    v vVar11;
                    Intrinsics.checkNotNullParameter(it, "it");
                    NetSearchHunYuanSection netSearchHunYuanSection = NetSearchHunYuanSection.this;
                    vVar10 = netSearchHunYuanSection.binding;
                    v vVar12 = null;
                    if (vVar10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar10 = null;
                    }
                    TextView textView3 = vVar10.f405772r;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.modelName");
                    netSearchHunYuanSection.R0(textView3);
                    vVar11 = NetSearchHunYuanSection.this.binding;
                    if (vVar11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        vVar12 = vVar11;
                    }
                    VideoReport.reportEvent("clck", vVar12.f405772r, new HashMap());
                }
            }, 3, null);
            v vVar10 = this.binding;
            if (vVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar10 = null;
            }
            FrameLayout frameLayout = vVar10.f405777w;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.shareBtn");
            rn2.j.u(jVar, frameLayout, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$doOnInitView$1$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel;
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel2;
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel3;
                    SearchAICard aiCard;
                    SearchAIInfo searchAIInfo;
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel4;
                    SearchAICard aiCard2;
                    SearchAIInfo searchAIInfo2;
                    String str;
                    boolean isBlank;
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel5;
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel6;
                    SearchAICard aiCard3;
                    SearchAIInfo searchAIInfo3;
                    Intrinsics.checkNotNullParameter(it, "it");
                    netSearchHunYuanViewModel = NetSearchHunYuanSection.this.viewModel;
                    Integer s26 = netSearchHunYuanViewModel != null ? netSearchHunYuanViewModel.s2() : null;
                    boolean z16 = false;
                    if (((((s26 != null && s26.intValue() == 7) || (s26 != null && s26.intValue() == 8)) || (s26 != null && s26.intValue() == 4)) || (s26 != null && s26.intValue() == 5)) || (s26 != null && s26.intValue() == 6)) {
                        af afVar = af.f284993a;
                        NetSearchHunYuanSection netSearchHunYuanSection = NetSearchHunYuanSection.this;
                        String str2 = "QS.NetSearchHunYuanDelegate";
                        netSearchHunYuanViewModel5 = netSearchHunYuanSection.viewModel;
                        Integer s27 = netSearchHunYuanViewModel5 != null ? netSearchHunYuanViewModel5.s2() : null;
                        netSearchHunYuanViewModel6 = netSearchHunYuanSection.viewModel;
                        QLog.w(str2, 1, "can't share here state=" + s27 + " questionId=" + ((netSearchHunYuanViewModel6 == null || (aiCard3 = netSearchHunYuanViewModel6.getAiCard()) == null || (searchAIInfo3 = aiCard3.aiInfo) == null) ? null : searchAIInfo3.questionId), null);
                        ToastUtil.a().e("\u8be5\u5185\u5bb9\u4e0d\u652f\u6301\u5206\u4eab");
                        return;
                    }
                    if (s26 != null && s26.intValue() == 3) {
                        netSearchHunYuanViewModel4 = NetSearchHunYuanSection.this.viewModel;
                        if (netSearchHunYuanViewModel4 != null && (aiCard2 = netSearchHunYuanViewModel4.getAiCard()) != null && (searchAIInfo2 = aiCard2.aiInfo) != null && (str = searchAIInfo2.questionId) != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str);
                            if (!isBlank) {
                                z16 = true;
                            }
                        }
                        if (z16) {
                            NetSearchHunYuanSection.this.S0();
                            return;
                        }
                    }
                    af afVar2 = af.f284993a;
                    NetSearchHunYuanSection netSearchHunYuanSection2 = NetSearchHunYuanSection.this;
                    String str3 = "QS.NetSearchHunYuanDelegate";
                    netSearchHunYuanViewModel2 = netSearchHunYuanSection2.viewModel;
                    Integer s28 = netSearchHunYuanViewModel2 != null ? netSearchHunYuanViewModel2.s2() : null;
                    netSearchHunYuanViewModel3 = netSearchHunYuanSection2.viewModel;
                    QLog.w(str3, 1, "can't share here state=" + s28 + " questionId=" + ((netSearchHunYuanViewModel3 == null || (aiCard = netSearchHunYuanViewModel3.getAiCard()) == null || (searchAIInfo = aiCard.aiInfo) == null) ? null : searchAIInfo.questionId), null);
                    ToastUtil.a().e("\u56de\u7b54\u751f\u6210\u5b8c\u6210\u540e\u624d\u80fd\u5206\u4eab");
                }
            }, 3, null);
            v vVar11 = this.binding;
            if (vVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar11 = null;
            }
            FrameLayout frameLayout2 = vVar11.f405767m;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.feedbackEntry");
            rn2.j.u(jVar, frameLayout2, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$doOnInitView$1$7
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel;
                    AICardFeedBackPopupWindow aICardFeedBackPopupWindow;
                    AICardFeedBackPopupWindow aICardFeedBackPopupWindow2;
                    NetSearchHunYuanViewModel netSearchHunYuanViewModel2;
                    AICardFeedBackPopupWindow aICardFeedBackPopupWindow3;
                    SearchAICard aiCard;
                    Intrinsics.checkNotNullParameter(it, "it");
                    netSearchHunYuanViewModel = NetSearchHunYuanSection.this.viewModel;
                    ArrayList<SearchText> reportTextList = (netSearchHunYuanViewModel == null || (aiCard = netSearchHunYuanViewModel.getAiCard()) == null) ? null : aiCard.getReportTextList();
                    if (reportTextList == null) {
                        reportTextList = new ArrayList<>();
                    }
                    aICardFeedBackPopupWindow = NetSearchHunYuanSection.this.feedBackPopupWindow;
                    if (aICardFeedBackPopupWindow == null && (!reportTextList.isEmpty())) {
                        NetSearchHunYuanSection netSearchHunYuanSection = NetSearchHunYuanSection.this;
                        Context context = containerView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "view.context");
                        netSearchHunYuanSection.feedBackPopupWindow = new AICardFeedBackPopupWindow(context);
                        aICardFeedBackPopupWindow3 = NetSearchHunYuanSection.this.feedBackPopupWindow;
                        if (aICardFeedBackPopupWindow3 != null) {
                            aICardFeedBackPopupWindow3.x(al.a(containerView.getContext(), 28.0f), -al.a(containerView.getContext(), 5.0f));
                        }
                    }
                    aICardFeedBackPopupWindow2 = NetSearchHunYuanSection.this.feedBackPopupWindow;
                    if (aICardFeedBackPopupWindow2 != null) {
                        netSearchHunYuanViewModel2 = NetSearchHunYuanSection.this.viewModel;
                        aICardFeedBackPopupWindow2.y(it, reportTextList, netSearchHunYuanViewModel2 != null ? netSearchHunYuanViewModel2.getCurrentModeInfo() : null);
                    }
                }
            }, 3, null);
            com.tencent.mobileqq.search.searchdetail.multimedia.o oVar = com.tencent.mobileqq.search.searchdetail.multimedia.o.f284545a;
            v vVar12 = this.binding;
            if (vVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar12 = null;
            }
            ImageView imageView3 = vVar12.f405769o;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.loadingIcon");
            oVar.f("", imageView3, "https://downv6.qq.com/innovate/search/search_ai_loading_ispt.png", new IPicLoadStateListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.h
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    NetSearchHunYuanSection.E0(NetSearchHunYuanSection.this, loadState, option);
                }
            });
            v vVar13 = this.binding;
            if (vVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar13 = null;
            }
            vVar13.f405766l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetSearchHunYuanSection.F0(NetSearchHunYuanSection.this, view);
                }
            });
            v vVar14 = this.binding;
            if (vVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar14 = null;
            }
            RecyclerView recyclerView = vVar14.f405774t;
            recyclerView.setLayoutManager(new LinearLayoutManager(containerView.getContext()));
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            SearchItemAdapter searchItemAdapter = new SearchItemAdapter(emptyList, new Function1<SearchListDetail, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$doOnInitView$1$10$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SearchListDetail searchListDetail) {
                    invoke2(searchListDetail);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SearchListDetail searchRefItem) {
                    Intrinsics.checkNotNullParameter(searchRefItem, "searchRefItem");
                    g.a.a(NetSearchHunYuanSection.this, searchRefItem.jumpLink, null, 2, null);
                }
            });
            this.searchItemAdapter = searchItemAdapter;
            recyclerView.setAdapter(searchItemAdapter);
            v vVar15 = this.binding;
            if (vVar15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar15 = null;
            }
            U0(vVar15.f405768n);
            o oVar2 = o.f284142a;
            v vVar16 = this.binding;
            if (vVar16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar16 = null;
            }
            Context context = vVar16.f405760f.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.content.context");
            float a16 = oVar2.a(context);
            v vVar17 = this.binding;
            if (vVar17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vVar17 = null;
            }
            vVar17.f405760f.setTextSize(1, 16 * a16);
            v vVar18 = this.binding;
            if (vVar18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                vVar = vVar18;
            }
            vVar.f405760f.setLineSpacing(com.tencent.mobileqq.search.util.l.d(3) * a16, 1.0f);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull final NetSearchHunYuanItem data, int position, @Nullable List<Object> payload) {
        LifecycleOwner lifecyclerOwner;
        Intrinsics.checkNotNullParameter(data, "data");
        v0();
        NetSearchHunYuanViewModel netSearchHunYuanViewModel = this.viewModel;
        if (netSearchHunYuanViewModel != null) {
            netSearchHunYuanViewModel.u2().removeObserver(this.dataObserver);
            netSearchHunYuanViewModel.B2().removeObserver(this.titleObserver);
            netSearchHunYuanViewModel.F2().removeObserver(this.expandedBtnObserver);
            netSearchHunYuanViewModel.y2().removeObserver(this.refObserver);
            netSearchHunYuanViewModel.H2().removeObserver(this.refContainerObserver);
            netSearchHunYuanViewModel.G2().removeObserver(this.moreChatBtnObserver);
        }
        this.viewModel = data.getViewModel();
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null && (lifecyclerOwner = dtReportIoc.getLifecyclerOwner()) != null) {
            NetSearchHunYuanViewModel viewModel = data.getViewModel();
            viewModel.u2().observe(lifecyclerOwner, this.dataObserver);
            viewModel.B2().observe(lifecyclerOwner, this.titleObserver);
            viewModel.F2().observe(lifecyclerOwner, this.expandedBtnObserver);
            viewModel.y2().observe(lifecyclerOwner, this.refObserver);
            viewModel.H2().observe(lifecyclerOwner, this.refContainerObserver);
            viewModel.G2().observe(lifecyclerOwner, this.moreChatBtnObserver);
            MutableLiveData<String> x26 = viewModel.x2();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.NetSearchHunYuanSection$doOnBindData$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String modeShowName) {
                    v vVar;
                    v vVar2;
                    boolean isBlank;
                    v vVar3;
                    vVar = NetSearchHunYuanSection.this.binding;
                    if (vVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar = null;
                    }
                    vVar.f405772r.setText(modeShowName);
                    vVar2 = NetSearchHunYuanSection.this.binding;
                    if (vVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar2 = null;
                    }
                    ImageView imageView = vVar2.f405759e;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.chooseModel");
                    Intrinsics.checkNotNullExpressionValue(modeShowName, "modeShowName");
                    isBlank = StringsKt__StringsJVMKt.isBlank(modeShowName);
                    p.b(imageView, (isBlank ^ true) && data.getViewModel().getAiCard().aiInfo.modelListInfo.choose);
                    af afVar = af.f284993a;
                    String str = "QS.NetSearchHunYuanDelegate";
                    vVar3 = NetSearchHunYuanSection.this.binding;
                    if (vVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vVar3 = null;
                    }
                    ImageView imageView2 = vVar3.f405759e;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.chooseModel");
                    QLog.i(str, 1, "can choose model=" + (imageView2.getVisibility() == 0), null);
                }
            };
            x26.observe(lifecyclerOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NetSearchHunYuanSection.A0(Function1.this, obj);
                }
            });
        }
        String itemId = data.getCommonInfo().getItemId();
        v vVar = this.binding;
        v vVar2 = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar = null;
        }
        FrameLayout frameLayout = vVar.f405767m;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.feedbackEntry");
        x0(this, itemId, "em_bas_ai_feedback", frameLayout, null, null, null, null, 120, null);
        String itemId2 = data.getCommonInfo().getItemId();
        v vVar3 = this.binding;
        if (vVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar3 = null;
        }
        TextView textView = vVar3.f405766l;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.expandTv");
        x0(this, itemId2, "em_bas_expand", textView, null, null, null, null, 120, null);
        String itemId3 = data.getCommonInfo().getItemId();
        v vVar4 = this.binding;
        if (vVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar4 = null;
        }
        QUIButton qUIButton = vVar4.f405768n;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.gotoMoreChatBtn");
        x0(this, itemId3, "em_bas_more_answers", qUIButton, null, null, null, null, 120, null);
        String itemId4 = data.getCommonInfo().getItemId();
        v vVar5 = this.binding;
        if (vVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vVar5 = null;
        }
        FrameLayout frameLayout2 = vVar5.f405777w;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.shareBtn");
        x0(this, itemId4, "em_bas_ai_share_card", frameLayout2, null, null, null, null, 120, null);
        String itemId5 = data.getCommonInfo().getItemId();
        v vVar6 = this.binding;
        if (vVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vVar2 = vVar6;
        }
        TextView textView2 = vVar2.f405772r;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.modelName");
        x0(this, itemId5, "em_bas_model_toggle", textView2, null, null, ClickPolicy.REPORT_NONE, null, 88, null);
    }
}
