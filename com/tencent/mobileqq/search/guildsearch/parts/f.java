package com.tencent.mobileqq.search.guildsearch.parts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.search.guildsearch.parts.f;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.SearchController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.UnifySearchTabInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\t*\u00017\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u001b\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J*\u0010\u001d\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u001eH\u0016R\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/parts/f;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/text/TextWatcher;", "", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "getMessage", "handleBroadcastMessage", "onPartDestroy", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "d", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "B9", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "E9", "(Lcom/tencent/mobileqq/widget/search/QUISearchBar;)V", "searchBar", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchRelativeViewModel;", "e", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchRelativeViewModel;", "viewModel", "f", "Ljava/lang/String;", "keyword", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", tl.h.F, "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "requestJob", "", "i", "Z", "isWaitToFinish", "com/tencent/mobileqq/search/guildsearch/parts/f$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/guildsearch/parts/f$b;", "actionCallback", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends Part implements TextWatcher {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public QUISearchBar searchBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildSearchRelativeViewModel viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String keyword;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b requestJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isWaitToFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b actionCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/guildsearch/parts/f$b", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements QUISearchBar.ActionCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(f this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.broadcastMessage("scroll_to_top", "onSearch");
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            f.this.D9();
            QUISearchBar B9 = f.this.B9();
            SearchController.defaultCancelAction(B9, B9.getSearchController(), true);
            InputMethodUtil.hide(f.this.B9().getInputWidget());
            if (f.this.getPartHost() instanceof Fragment) {
                Object partHost = f.this.getPartHost();
                Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                if (((Fragment) partHost).isStateSaved() && f.this.getActivity() != null && AppSetting.t(f.this.getActivity()) && SearchUtils.L0(f.this.getActivity())) {
                    f.this.isWaitToFinish = true;
                    return 1;
                }
            }
            SearchController.defaultBackAction(f.this.B9(), f.this.B9().getSearchController());
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            f.this.B9().getInputWidget().requestFocus();
            f.this.B9().getInputWidget().setCursorVisible(true);
            InputMethodUtil.show(f.this.B9().getInputWidget());
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            boolean isBlank;
            String obj = f.this.B9().getInputWidget().getText().toString();
            isBlank = StringsKt__StringsJVMKt.isBlank(obj);
            if (!isBlank) {
                f.this.B9().getInputWidget().setCursorVisible(false);
                f.this.B9().getInputWidget().clearFocus();
                InputMethodUtil.hide(f.this.B9().getInputWidget());
                SearchDetailFragment.Companion.NetSearchPageParam netSearchPageParam = new SearchDetailFragment.Companion.NetSearchPageParam(obj, "", 24, 13, false, 3L, "", System.currentTimeMillis(), "", null, null, 0, 3584, null);
                SearchDetailFragment.Companion companion = SearchDetailFragment.INSTANCE;
                Context context = f.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                companion.d(context, netSearchPageParam, "");
                f.this.B9().getInputWidget().setText("");
                final f fVar = f.this;
                C11736d.b(50, new Runnable() { // from class: com.tencent.mobileqq.search.guildsearch.parts.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.b.b(f.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this$0.B9().getInputWidget(), "em_sgrp_search_box", "clck", new HashMap());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9() {
        HashMap hashMap = new HashMap();
        hashMap.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, B9().getInputWidget().getText().toString());
        VideoReport.setElementId(B9().getCancelView(), "em_sgrp_cancel_btn");
        VideoReport.setElementClickPolicy(B9().getCancelView(), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(B9().getCancelView(), ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", B9().getCancelView(), hashMap);
    }

    @NotNull
    public final QUISearchBar B9() {
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar != null) {
            return qUISearchBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        return null;
    }

    public final void E9(@NotNull QUISearchBar qUISearchBar) {
        Intrinsics.checkNotNullParameter(qUISearchBar, "<set-?>");
        this.searchBar = qUISearchBar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s16) {
        String str;
        String obj;
        boolean z16;
        Job f16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = null;
        if (s16 != null) {
            str = s16.toString();
        } else {
            str = null;
        }
        QLog.i("QQSearch.Local.Guild.SearchBoxPart", 2, "afterTextChanged " + str);
        if (s16 != null && (obj = s16.toString()) != null) {
            this.keyword = obj;
            if (obj.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                broadcastMessage("MESSAGE_SHOW_SEARCH_FRAME", this.keyword);
                com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = this.requestJob;
                if (bVar2 != null && (f16 = bVar2.f()) != null) {
                    Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
                }
                GuildSearchRelativeViewModel guildSearchRelativeViewModel = this.viewModel;
                if (guildSearchRelativeViewModel != null) {
                    bVar = guildSearchRelativeViewModel.N1(obj, new UnifySearchTabInfo("\u9891\u9053", 3L), 24, 13);
                }
                this.requestJob = bVar;
                return;
            }
            broadcastMessage("MESSAGE_HIDE_SEARCH_FRAME", this.keyword);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "MESSAGE_GET_CURRENT_KEYWORD")) {
            return B9().getInputWidget().getText().toString();
        }
        return super.getMessage(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "MESSAGE_ON_LIST_SCROLL")) {
            if (B9().getInputWidget().isCursorVisible()) {
                B9().getInputWidget().setCursorVisible(false);
                InputMethodUtil.hide(B9().getInputWidget());
                B9().getInputWidget().clearFocus();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, "MESSAGE_CLEAR_SEARCH_TEXT")) {
            Logger.f235387a.d().d("QQSearch.Local.Guild.SearchBoxPart", 1, " MESSAGE_CLEAR_SEARCH_TEXT " + args);
            B9().getInputWidget().setText("");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f166395zp4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.net_search_bar)");
        E9((QUISearchBar) findViewById);
        B9().bindSearchChain(false);
        B9().setActionCallback(this.actionCallback);
        B9().getInputWidget().addTextChangedListener(this);
        this.viewModel = (GuildSearchRelativeViewModel) getViewModel(GuildSearchRelativeViewModel.class);
        B9().getInputWidget().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.guildsearch.parts.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.C9(f.this, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        B9().unbindSearchChain(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        if (activity != null && ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).isInSplitViewMode(activity)) {
            InputMethodUtil.show(B9().getInputWidget());
        }
        if (this.isWaitToFinish) {
            SearchController.defaultBackAction(B9(), B9().getSearchController());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
    }
}
