package com.tencent.mobileqq.search.searchdetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.search.searchdetail.eventbus.ThemeChangedEvent;
import com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaVideoView;
import com.tencent.mobileqq.search.searchdetail.searchbox.SearchHistoryPart;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListPart;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u0001:\u0002-.B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\nJ\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "qh", "", "initViews", "Landroid/view/ViewGroup;", "contentView", "sh", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "th", "", "uh", "initViewModel", "rh", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "keyword", "vh", "onPostThemeChanged", "needImmersive", "isWrapContent", "Lcom/tencent/mobileqq/search/searchdetail/m;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/m;", "viewModel", "D", "Landroid/view/ViewGroup;", "root", "<init>", "()V", "E", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailFragment extends QPublicBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private m viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup root;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0011%B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0015\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion;", "", "", "pageMode", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$a;", "pageParam", "", "isSingle", "", "d", "Landroid/os/Bundle;", "fragmentArgs", "a", "", "c", "PARAM_FUNCTION_PAYLOAD", "Ljava/lang/String;", "PARAM_HIDE_TAB", "PARAM_HINT", "PARAM_KEYWORD", "PARAM_QUERY_SOURCE", "PARAM_SEARCH_STAMP", "PARAM_SESSION_ID", "PARAM_SUG_TRACE_ID", "PARAM_TAB_MASK", "PARAM_USER_SOURCE", "PARAM_VOICE_AI_SEARCH_MODE", "PARAM_WX_PARENT_TYPE", "PARAM_WX_PRE_SEARCH_ID", "TAG", "<init>", "()V", "PageMode", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$PageMode;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "MODE_NORMAL_AI", "MODE_VOICE_AI_SEARCH", "MODE_NORMAL", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public enum PageMode {
            MODE_NORMAL_AI(2),
            MODE_VOICE_AI_SEARCH(1),
            MODE_NORMAL(0);


            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final int value;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$PageMode$a;", "", "", "pageMode", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.search.searchdetail.SearchDetailFragment$Companion$PageMode$a, reason: from kotlin metadata */
            /* loaded from: classes18.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final boolean a(int pageMode) {
                    return false;
                }

                Companion() {
                }
            }

            PageMode(int i3) {
                this.value = i3;
            }

            public final int getValue() {
                return this.value;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\b\b\u0002\u0010'\u001a\u00020#\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u0012\b\b\u0002\u0010+\u001a\u00020#\u0012\b\b\u0002\u0010-\u001a\u00020\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\u0006\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\b\b\u0002\u00104\u001a\u00020\b\u00a2\u0006\u0004\b5\u00106J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\"\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0014\u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010)\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b(\u0010\u0010R\u0017\u0010+\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b*\u0010&R\u0017\u0010-\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b\r\u0010\u0010R\"\u0010/\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000e\u001a\u0004\b,\u0010\u0010\"\u0004\b.\u0010\u0012R\"\u00102\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\"\u00104\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b3\u0010\u001b\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$a;", "", "Landroid/content/Intent;", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "keyword", "b", "c", "hint", "I", "f", "()I", "p", "(I)V", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "k", "userSource", "e", "Z", "()Z", "hideTab", "", "J", "j", "()J", "tabMask", "g", "sessionId", tl.h.F, "startSearchTime", "i", "functionPayload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sugTraceId", "l", "setWxSugSearchId", "wxSugSearchId", "o", "pageMode", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIZJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.searchdetail.SearchDetailFragment$Companion$a, reason: from toString */
        /* loaded from: classes18.dex */
        public static final /* data */ class NetSearchPageParam {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String keyword;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String hint;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private int querySource;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            private final int userSource;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            private final boolean hideTab;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
            private final long tabMask;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final String sessionId;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
            private final long startSearchTime;

            /* renamed from: i, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String functionPayload;

            /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private String sugTraceId;

            /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private String wxSugSearchId;

            /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
            private int pageMode;

            public NetSearchPageParam() {
                this(null, null, 0, 0, false, 0L, null, 0L, null, null, null, 0, 4095, null);
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final String getFunctionPayload() {
                return this.functionPayload;
            }

            /* renamed from: b, reason: from getter */
            public final boolean getHideTab() {
                return this.hideTab;
            }

            @NotNull
            /* renamed from: c, reason: from getter */
            public final String getHint() {
                return this.hint;
            }

            @NotNull
            /* renamed from: d, reason: from getter */
            public final String getKeyword() {
                return this.keyword;
            }

            /* renamed from: e, reason: from getter */
            public final int getPageMode() {
                return this.pageMode;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NetSearchPageParam)) {
                    return false;
                }
                NetSearchPageParam netSearchPageParam = (NetSearchPageParam) other;
                if (Intrinsics.areEqual(this.keyword, netSearchPageParam.keyword) && Intrinsics.areEqual(this.hint, netSearchPageParam.hint) && this.querySource == netSearchPageParam.querySource && this.userSource == netSearchPageParam.userSource && this.hideTab == netSearchPageParam.hideTab && this.tabMask == netSearchPageParam.tabMask && Intrinsics.areEqual(this.sessionId, netSearchPageParam.sessionId) && this.startSearchTime == netSearchPageParam.startSearchTime && Intrinsics.areEqual(this.functionPayload, netSearchPageParam.functionPayload) && Intrinsics.areEqual(this.sugTraceId, netSearchPageParam.sugTraceId) && Intrinsics.areEqual(this.wxSugSearchId, netSearchPageParam.wxSugSearchId) && this.pageMode == netSearchPageParam.pageMode) {
                    return true;
                }
                return false;
            }

            /* renamed from: f, reason: from getter */
            public final int getQuerySource() {
                return this.querySource;
            }

            @NotNull
            /* renamed from: g, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            /* renamed from: h, reason: from getter */
            public final long getStartSearchTime() {
                return this.startSearchTime;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode = ((((((this.keyword.hashCode() * 31) + this.hint.hashCode()) * 31) + this.querySource) * 31) + this.userSource) * 31;
                boolean z16 = this.hideTab;
                int i3 = z16;
                if (z16 != 0) {
                    i3 = 1;
                }
                return ((((((((((((((hashCode + i3) * 31) + androidx.fragment.app.a.a(this.tabMask)) * 31) + this.sessionId.hashCode()) * 31) + androidx.fragment.app.a.a(this.startSearchTime)) * 31) + this.functionPayload.hashCode()) * 31) + this.sugTraceId.hashCode()) * 31) + this.wxSugSearchId.hashCode()) * 31) + this.pageMode;
            }

            @NotNull
            /* renamed from: i, reason: from getter */
            public final String getSugTraceId() {
                return this.sugTraceId;
            }

            /* renamed from: j, reason: from getter */
            public final long getTabMask() {
                return this.tabMask;
            }

            /* renamed from: k, reason: from getter */
            public final int getUserSource() {
                return this.userSource;
            }

            @NotNull
            /* renamed from: l, reason: from getter */
            public final String getWxSugSearchId() {
                return this.wxSugSearchId;
            }

            public final void m(@NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                intent.putExtra("keyword", this.keyword);
                intent.putExtra("hint", this.hint);
                intent.putExtra("user_source", this.userSource);
                intent.putExtra("hide_tab", this.hideTab);
                intent.putExtra("tab_mask", this.tabMask);
                intent.putExtra(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, this.querySource);
                intent.putExtra("sessionId", this.sessionId);
                intent.putExtra("start_search_stamp", this.startSearchTime);
                intent.putExtra("func_payload", this.functionPayload);
                intent.putExtra("sug_trace_id", this.sugTraceId);
                intent.putExtra("wx_search_id", this.wxSugSearchId);
                intent.putExtra("voice_ai_mode", this.pageMode);
            }

            public final void n(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.keyword = str;
            }

            public final void o(int i3) {
                this.pageMode = i3;
            }

            public final void p(int i3) {
                this.querySource = i3;
            }

            public final void q(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.sugTraceId = str;
            }

            @NotNull
            public String toString() {
                String str = "NetSearchPageParam(keyword='" + ag.b(this.keyword, 0, 1, null) + "', hint='" + ag.b(this.hint, 0, 1, null) + "', querySource=" + this.querySource + ", userSource=" + this.userSource + ", hideTab=" + this.hideTab + ", tabMask=" + this.tabMask + ", sessionId='" + this.sessionId + "', startSearchTime=" + this.startSearchTime + ", functionPayload='" + ag.b(this.functionPayload, 0, 1, null) + "', sugTraceId='" + this.sugTraceId + "', wxSugSearchId='" + this.wxSugSearchId + "', pageMode=" + this.pageMode + ")";
                Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply {\n\u2026             }.toString()");
                return str;
            }

            public NetSearchPageParam(@NotNull String keyword, @NotNull String hint, int i3, int i16, boolean z16, long j3, @NotNull String sessionId, long j16, @NotNull String functionPayload, @NotNull String sugTraceId, @NotNull String wxSugSearchId, int i17) {
                Intrinsics.checkNotNullParameter(keyword, "keyword");
                Intrinsics.checkNotNullParameter(hint, "hint");
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                Intrinsics.checkNotNullParameter(functionPayload, "functionPayload");
                Intrinsics.checkNotNullParameter(sugTraceId, "sugTraceId");
                Intrinsics.checkNotNullParameter(wxSugSearchId, "wxSugSearchId");
                this.keyword = keyword;
                this.hint = hint;
                this.querySource = i3;
                this.userSource = i16;
                this.hideTab = z16;
                this.tabMask = j3;
                this.sessionId = sessionId;
                this.startSearchTime = j16;
                this.functionPayload = functionPayload;
                this.sugTraceId = sugTraceId;
                this.wxSugSearchId = wxSugSearchId;
                this.pageMode = i17;
            }

            public /* synthetic */ NetSearchPageParam(String str, String str2, int i3, int i16, boolean z16, long j3, String str3, long j16, String str4, String str5, String str6, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
                this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) == 0 ? z16 : false, (i18 & 32) != 0 ? 1L : j3, (i18 & 64) != 0 ? "" : str3, (i18 & 128) != 0 ? 0L : j16, (i18 & 256) != 0 ? "" : str4, (i18 & 512) != 0 ? "" : str5, (i18 & 1024) == 0 ? str6 : "", (i18 & 2048) != 0 ? PageMode.MODE_NORMAL.getValue() : i17);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Class<? extends QPublicBaseFragment> b(int pageMode) {
            return SearchDetailFragment.class;
        }

        public static /* synthetic */ void e(Companion companion, Context context, NetSearchPageParam netSearchPageParam, String str, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = "";
            }
            companion.d(context, netSearchPageParam, str);
        }

        @NotNull
        public final NetSearchPageParam a(@NotNull Bundle fragmentArgs) {
            Intrinsics.checkNotNullParameter(fragmentArgs, "fragmentArgs");
            String sessionId = fragmentArgs.getString("sessionId", "");
            String keyword = fragmentArgs.getString("keyword", "");
            String hint = fragmentArgs.getString("hint", "");
            int i3 = fragmentArgs.getInt(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, 0);
            int i16 = fragmentArgs.getInt("user_source", 0);
            long j3 = fragmentArgs.getLong("tab_mask", 1L);
            boolean z16 = fragmentArgs.getBoolean("hide_tab", false);
            long j16 = fragmentArgs.getLong("start_search_stamp", 0L);
            String functionPayload = fragmentArgs.getString("func_payload", "");
            String sugTraceId = fragmentArgs.getString("sug_trace_id", "");
            String wxSugSearchId = fragmentArgs.getString("wx_search_id", "");
            int i17 = fragmentArgs.getInt("voice_ai_mode", PageMode.MODE_NORMAL.getValue());
            Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
            Intrinsics.checkNotNullExpressionValue(hint, "hint");
            Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
            Intrinsics.checkNotNullExpressionValue(functionPayload, "functionPayload");
            Intrinsics.checkNotNullExpressionValue(sugTraceId, "sugTraceId");
            Intrinsics.checkNotNullExpressionValue(wxSugSearchId, "wxSugSearchId");
            return new NetSearchPageParam(keyword, hint, i3, i16, z16, j3, sessionId, j16, functionPayload, sugTraceId, wxSugSearchId, i17);
        }

        public final boolean c(int pageMode) {
            return PageMode.INSTANCE.a(pageMode);
        }

        public final void d(@NotNull Context context, @NotNull NetSearchPageParam pageParam, @NotNull String isSingle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageParam, "pageParam");
            Intrinsics.checkNotNullParameter(isSingle, "isSingle");
            Intent intent = new Intent();
            pageParam.m(intent);
            if (Intrinsics.areEqual("1", isSingle)) {
                intent.addFlags(335544320);
            }
            if (context instanceof Activity) {
                QPublicFragmentActivity.start(context, intent, b(pageParam.getPageMode()));
                ((Activity) context).overridePendingTransition(R.anim.f154431s, R.anim.f154430r);
            } else {
                intent.addFlags(268435456);
                QPublicFragmentActivity.start(BaseApplication.getContext(), intent, b(pageParam.getPageMode()));
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$a;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment;", "a", "Lmqq/util/WeakReference;", "fragmentRef", "<init>", "(Lmqq/util/WeakReference;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<SearchDetailFragment> fragmentRef;

        public a(@NotNull WeakReference<SearchDetailFragment> fragmentRef) {
            Intrinsics.checkNotNullParameter(fragmentRef, "fragmentRef");
            this.fragmentRef = fragmentRef;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            HashMap th5;
            SearchDetailFragment searchDetailFragment = this.fragmentRef.get();
            if (searchDetailFragment == null || (th5 = searchDetailFragment.th()) == null) {
                return new HashMap();
            }
            return th5;
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = new ViewModelProvider(this).get(m.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ailViewModel::class.java)");
        m mVar = (m) viewModel;
        this.viewModel = mVar;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            mVar = null;
        }
        mVar.init(getArguments());
    }

    private final void initViews() {
        NetSearchMultiMediaVideoView.INSTANCE.a(true);
    }

    private final boolean qh() {
        Integer num;
        if (!ap2.a.f26672a.a()) {
            return false;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt("user_source", 0));
        } else {
            num = null;
        }
        if ((num == null || num.intValue() != 1) && ((num == null || num.intValue() != 6) && ((num == null || num.intValue() != 8) && ((num == null || num.intValue() != 9) && ((num == null || num.intValue() != 19) && (num == null || num.intValue() != 11)))))) {
            return false;
        }
        return true;
    }

    private final boolean rh() {
        if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeSimpleNight()) {
            return false;
        }
        return true;
    }

    private final void sh(ViewGroup contentView) {
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("pageId", "pg_qq_network_search_result_level2_page");
        m mVar = this.viewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            mVar = null;
        }
        hashMap.put("user_source", Integer.valueOf(mVar.getUserSource()));
        VideoReport.setEventDynamicParams(contentView, new a(new WeakReference(this)));
        VideoReport.setPageId(contentView, "pg_qq_network_search_result_level2_page");
        VideoReport.setPageParams(contentView, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Object> th() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(PictureConst.KEY_PAGE_MODE, Integer.valueOf(uh()));
        return hashMap;
    }

    private final int uh() {
        Part part = getPartManager().getPart(SearchDetailTabListPart.class.getName());
        if (part instanceof SearchDetailTabListPart) {
            Object message = ((SearchDetailTabListPart) part).getMessage("getPageMode", null);
            if (message instanceof Integer) {
                return ((Number) message).intValue();
            }
        }
        return Companion.PageMode.MODE_NORMAL.getValue();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        List<Part> mutableListOf2;
        int i3 = 1;
        SearchPageType searchPageType = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        if (!qh()) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.search.searchdetail.searchbox.k(b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0), new SearchHistoryPart(), new SearchDetailTabListPart(), new SearchAnimPart());
            return mutableListOf;
        }
        af afVar = af.f284993a;
        if (QLog.isDebugVersion()) {
            QLog.d("QS.QQSearch.NetDetail.SearchDetailFragment", 2, "canUseAudio", (Throwable) null);
        }
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.search.searchdetail.searchbox.k(searchPageType, i3, b18 == true ? 1 : 0), new SearchHistoryPart(), new SearchDetailTabListPart(), new SearchAnimPart(), new com.tencent.mobileqq.search.searchdetail.searchbox.g());
        return mutableListOf2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h2j;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QQPermission.enterModule("qq_big_search");
        QCirclePluginGlobalInfo.h(getContext());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQPermission.exitModule("qq_big_search");
        QCirclePluginGlobalInfo.i();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        SimpleEventBus.getInstance().dispatchEvent(new ThemeChangedEvent(rh()));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewGroup viewGroup = this.root;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            viewGroup = null;
        }
        VideoReport.setEventDynamicParams(viewGroup, new a(new WeakReference(this)));
        com.tencent.mobileqq.guild.report.b.g("functional_qq_search", "QQSearch.NetDetail.SearchDetailFragment");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewGroup viewGroup = (ViewGroup) view;
        this.root = viewGroup;
        initViews();
        initViewModel();
        sh(viewGroup);
    }

    public final void vh(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Part part = getPartManager().getPart(SearchAnimPart.class.getName());
        if (part instanceof SearchAnimPart) {
            ((SearchAnimPart) part).M9(keyword);
        }
    }
}
