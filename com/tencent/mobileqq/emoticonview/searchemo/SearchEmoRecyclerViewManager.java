package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonCompositeInfo;
import com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerView;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmoticonListAdapter;
import com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.bz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u0001:\u0002bcBI\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010-\u001a\u00020\u0017\u0012\u0006\u0010/\u001a\u00020\u001d\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00108\u001a\u000207\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\u000e\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u0010\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u0010<\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00100\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010;R\"\u0010Q\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010=\u001a\u0004\bR\u0010?\"\u0004\bS\u0010AR\"\u0010T\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u00100\u001a\u0004\bU\u0010D\"\u0004\bV\u0010FR\u0018\u0010W\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010IR\"\u0010X\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010K\u001a\u0004\bY\u0010M\"\u0004\bZ\u0010OR\"\u0010[\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010K\u001a\u0004\b\\\u0010M\"\u0004\b]\u0010O\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerViewManager;", "", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchResult;", "result", "", "onHandleRecommendResult", "", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "recItemList", "compositeItemList", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoFooterData;", "footerItemList", "", "searchKeyWords", "analyzeRecommendDataAndNotify", "onHandleCompositeResult", "analyzeCompositeDataAndNotify", "", "isComposite", "searchWord", "reportSearchResultExpose", "destroy", "compositeTab", "", "curSearchWords", "switchTab", "isCompositeTab", "needRequestAfterSwitch", "checkIsCompositeTab", "", "loadingStatus", "updateLoadingStatus", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerView;", "getCurRecyclerView", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;", "getCurAdapter", "clearData", "updateLoadMore", "onHandleResult", "Lmqq/app/AppRuntime;", "mAppRuntime", "Lmqq/app/AppRuntime;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "enterSearchWords", "Ljava/lang/CharSequence;", "mFromType", "I", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "mEmotionEventCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;", "mInfoAndActionCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;", "mDialog", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;", "mRecommendRecyclerView", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerView;", "mRecommendAdapter", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;", "getMRecommendAdapter", "()Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;", "setMRecommendAdapter", "(Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;)V", "mRecommendLoadingStatus", "getMRecommendLoadingStatus", "()I", "setMRecommendLoadingStatus", "(I)V", "Lcom/tencent/mobileqq/util/bz;", "mRecommendReportHelper", "Lcom/tencent/mobileqq/util/bz;", "mRecommendLoadMore", "Z", "getMRecommendLoadMore", "()Z", "setMRecommendLoadMore", "(Z)V", "mCompositeRecyclerView", "mCompositeAdapter", "getMCompositeAdapter", "setMCompositeAdapter", "mCompositeLoadingStatus", "getMCompositeLoadingStatus", "setMCompositeLoadingStatus", "mCompositeReportHelper", "mCompositeLoadMore", "getMCompositeLoadMore", "setMCompositeLoadMore", "mIsCompositeTab", "getMIsCompositeTab", "setMIsCompositeTab", "Landroid/view/View;", "mParentView", "<init>", "(Lmqq/app/AppRuntime;Landroid/content/Context;Landroid/view/View;Ljava/lang/CharSequence;ILcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;)V", "Companion", "SearchEmotionDialogReportHelper", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class SearchEmoRecyclerViewManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SearchEmoRecyclerViewMa";

    @NotNull
    private final CharSequence enterSearchWords;

    @Nullable
    private AppRuntime mAppRuntime;

    @NotNull
    private SearchEmoticonListAdapter mCompositeAdapter;
    private volatile boolean mCompositeLoadMore;
    private int mCompositeLoadingStatus;

    @NotNull
    private SearchEmoRecyclerView mCompositeRecyclerView;

    @Nullable
    private bz mCompositeReportHelper;

    @NotNull
    private final Context mContext;

    @NotNull
    private final SearchEmoticonDialog mDialog;

    @NotNull
    private IEmoticonEventCallback mEmotionEventCallback;
    private final int mFromType;

    @NotNull
    private final InfoAndActionCb mInfoAndActionCb;
    private boolean mIsCompositeTab;

    @NotNull
    private SearchEmoticonListAdapter mRecommendAdapter;
    private volatile boolean mRecommendLoadMore;
    private int mRecommendLoadingStatus;

    @NotNull
    private SearchEmoRecyclerView mRecommendRecyclerView;

    @Nullable
    private bz mRecommendReportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerViewManager$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoRecyclerViewManager$SearchEmotionDialogReportHelper;", "Lcom/tencent/mobileqq/util/bz;", "", "position", "", "dispatchItemImp", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;", "adapter", "Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoticonListAdapter;)V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private static final class SearchEmotionDialogReportHelper extends bz {
        static IPatchRedirector $redirector_;

        @NotNull
        private final SearchEmoticonListAdapter adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchEmotionDialogReportHelper(@NotNull RecyclerView recycleView, @NotNull SearchEmoticonListAdapter adapter) {
            super(recycleView, null);
            Intrinsics.checkNotNullParameter(recycleView, "recycleView");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recycleView, (Object) adapter);
            } else {
                this.adapter = adapter;
            }
        }

        @Override // com.tencent.mobileqq.util.bz
        public void dispatchItemImp(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, position);
                return;
            }
            List<String> itemKeyByPosition = this.adapter.getItemKeyByPosition(position);
            if (itemKeyByPosition == null) {
                return;
            }
            int i3 = 0;
            for (String str : itemKeyByPosition) {
                int i16 = i3 + 1;
                if (!getDisplayItemSet().contains(str)) {
                    this.adapter.onItemDisplay(position, i3, str);
                    getDisplayItemSet().add(str);
                }
                i3 = i16;
            }
        }

        @NotNull
        public final SearchEmoticonListAdapter getAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SearchEmoticonListAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.adapter;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23545);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchEmoRecyclerViewManager(@Nullable AppRuntime appRuntime, @NotNull Context mContext, @NotNull View mParentView, @NotNull CharSequence enterSearchWords, int i3, @NotNull IEmoticonEventCallback mEmotionEventCallback, @NotNull InfoAndActionCb mInfoAndActionCb, @NotNull SearchEmoticonDialog mDialog) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mParentView, "mParentView");
        Intrinsics.checkNotNullParameter(enterSearchWords, "enterSearchWords");
        Intrinsics.checkNotNullParameter(mEmotionEventCallback, "mEmotionEventCallback");
        Intrinsics.checkNotNullParameter(mInfoAndActionCb, "mInfoAndActionCb");
        Intrinsics.checkNotNullParameter(mDialog, "mDialog");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, mContext, mParentView, enterSearchWords, Integer.valueOf(i3), mEmotionEventCallback, mInfoAndActionCb, mDialog);
            return;
        }
        this.mAppRuntime = appRuntime;
        this.mContext = mContext;
        this.enterSearchWords = enterSearchWords;
        this.mFromType = i3;
        this.mEmotionEventCallback = mEmotionEventCallback;
        this.mInfoAndActionCb = mInfoAndActionCb;
        this.mDialog = mDialog;
        View findViewById = mParentView.findViewById(R.id.t6r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mParentView.findViewById(R.id.big_error_container)");
        BigErrorContainer bigErrorContainer = (BigErrorContainer) findViewById;
        View findViewById2 = mParentView.findViewById(R.id.f71433o5);
        SearchEmoRecyclerView searchEmoRecyclerView = (SearchEmoRecyclerView) findViewById2;
        SearchEmoticonListAdapter searchEmoticonListAdapter = new SearchEmoticonListAdapter(this.mAppRuntime, mContext, bigErrorContainer, i3, false, this.mEmotionEventCallback, mInfoAndActionCb);
        this.mRecommendAdapter = searchEmoticonListAdapter;
        searchEmoRecyclerView.setAdapter(searchEmoticonListAdapter);
        searchEmoRecyclerView.setCallback(new SearchEmoRecyclerView.SearchEmoRecyclerViewCb() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerViewManager$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoRecyclerViewManager.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerView.SearchEmoRecyclerViewCb
            public void recyclerViewScrollToBottom() {
                SearchEmoticonDialog searchEmoticonDialog;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (SearchEmoRecyclerViewManager.this.getMRecommendLoadingStatus() == 1 && !SearchEmoRecyclerViewManager.this.getMRecommendLoadMore()) {
                    SearchEmoRecyclerViewManager.this.setMRecommendLoadMore(true);
                    searchEmoticonDialog = SearchEmoRecyclerViewManager.this.mDialog;
                    searchEmoticonDialog.onLoadMore(false);
                }
            }
        });
        clearData(false, enterSearchWords.toString());
        searchEmoRecyclerView.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(searchEmoRecyclerView, "this");
        this.mRecommendReportHelper = new SearchEmotionDialogReportHelper(searchEmoRecyclerView, this.mRecommendAdapter);
        searchEmoRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerViewManager$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                    return;
                }
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState == 0) {
                    VideoReport.traversePage(recyclerView);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mParentView.findViewById\u2026\n            })\n        }");
        this.mRecommendRecyclerView = searchEmoRecyclerView;
        View findViewById3 = mParentView.findViewById(R.id.f164871u34);
        SearchEmoRecyclerView searchEmoRecyclerView2 = (SearchEmoRecyclerView) findViewById3;
        SearchEmoticonListAdapter searchEmoticonListAdapter2 = new SearchEmoticonListAdapter(this.mAppRuntime, mContext, bigErrorContainer, i3, true, this.mEmotionEventCallback, mInfoAndActionCb);
        this.mCompositeAdapter = searchEmoticonListAdapter2;
        searchEmoRecyclerView2.setAdapter(searchEmoticonListAdapter2);
        searchEmoRecyclerView2.setCallback(new SearchEmoRecyclerView.SearchEmoRecyclerViewCb() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerViewManager$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchEmoRecyclerViewManager.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerView.SearchEmoRecyclerViewCb
            public void recyclerViewScrollToBottom() {
                SearchEmoticonDialog searchEmoticonDialog;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (SearchEmoRecyclerViewManager.this.getMCompositeLoadingStatus() == 1 && !SearchEmoRecyclerViewManager.this.getMCompositeLoadMore()) {
                    SearchEmoRecyclerViewManager.this.setMCompositeLoadMore(true);
                    searchEmoticonDialog = SearchEmoRecyclerViewManager.this.mDialog;
                    searchEmoticonDialog.onLoadMore(true);
                }
            }
        });
        clearData(true, enterSearchWords.toString());
        Intrinsics.checkNotNullExpressionValue(searchEmoRecyclerView2, "this");
        this.mCompositeReportHelper = new SearchEmotionDialogReportHelper(searchEmoRecyclerView2, this.mCompositeAdapter);
        searchEmoRecyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoRecyclerViewManager$2$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                    return;
                }
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (newState == 0) {
                    VideoReport.traversePage(recyclerView);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mParentView.findViewById\u2026\n            })\n        }");
        this.mCompositeRecyclerView = searchEmoRecyclerView2;
    }

    private final void analyzeCompositeDataAndNotify(List<EmotionSearchItem> compositeItemList, List<SearchEmoFooterData> footerItemList, String searchKeyWords) {
        boolean z16;
        boolean z17;
        if (compositeItemList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (footerItemList.size() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z16) {
            int i3 = 0;
            int i16 = 0;
            for (Object obj : compositeItemList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add(new HotPicSearchEmoticonCompositeInfo(3, arrayList2.size() + 1, searchKeyWords, (EmotionSearchItem) obj));
                i3++;
                if (i3 == SearchEmoticonListAdapter.INSTANCE.viewTypeToMaxDataCount(4)) {
                    arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(4, i3));
                    i3 = 0;
                }
                i16 = i17;
            }
            if (i3 != 0) {
                arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(4, i3));
            }
        }
        if (z17) {
            int i18 = 0;
            for (Object obj2 : footerItemList) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add((SearchEmoFooterData) obj2);
                arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(1, 1));
                i18 = i19;
            }
        }
        this.mCompositeAdapter.setDataForOuter(arrayList2, arrayList, searchKeyWords, false);
    }

    private final void analyzeRecommendDataAndNotify(List<EmotionSearchItem> recItemList, List<EmotionSearchItem> compositeItemList, List<SearchEmoFooterData> footerItemList, String searchKeyWords) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = true;
        if (recItemList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (compositeItemList.size() > 0 && this.mDialog.getMSupportCompositeEmo()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (footerItemList.size() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z17) {
            arrayList2.add(SearchEmoCompositeTitleData.INSTANCE);
            arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(2, 1));
            int i3 = 0;
            int i16 = 0;
            for (Object obj : compositeItemList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                EmotionSearchItem emotionSearchItem = (EmotionSearchItem) obj;
                if (i16 <= 7) {
                    arrayList2.add(new HotPicSearchEmoticonCompositeInfo(3, arrayList2.size() + 1, searchKeyWords, emotionSearchItem));
                    i3++;
                    if (i3 == SearchEmoticonListAdapter.INSTANCE.viewTypeToMaxDataCount(4)) {
                        arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(4, i3));
                        i3 = 0;
                    }
                }
                i16 = i17;
            }
            if (i3 != 0) {
                arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(4, i3));
            }
        }
        if (z16) {
            if (z17) {
                arrayList2.add(SearchEmoRecommendTitleData.INSTANCE);
                arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(3, 1));
            }
            int i18 = 0;
            int i19 = 0;
            for (Object obj2 : recItemList) {
                int i26 = i19 + 1;
                if (i19 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add(new HotPicSearchEmoticonInfo(3, arrayList2.size() + 1, searchKeyWords, (EmotionSearchItem) obj2));
                i18++;
                if (i18 == SearchEmoticonListAdapter.INSTANCE.viewTypeToMaxDataCount(5)) {
                    arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(5, i18));
                    i18 = 0;
                }
                i19 = i26;
            }
            if (i18 != 0) {
                arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(5, i18));
            }
        }
        if (z18) {
            int i27 = 0;
            for (Object obj3 : footerItemList) {
                int i28 = i27 + 1;
                if (i27 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add((SearchEmoFooterData) obj3);
                arrayList.add(new SearchEmoticonListAdapter.ViewTypeInfo(1, 1));
                i27 = i28;
            }
        }
        SearchEmoticonListAdapter searchEmoticonListAdapter = this.mRecommendAdapter;
        if (!z16 || !z17) {
            z19 = false;
        }
        searchEmoticonListAdapter.setDataForOuter(arrayList2, arrayList, searchKeyWords, z19);
    }

    public static /* synthetic */ void clearData$default(SearchEmoRecyclerViewManager searchEmoRecyclerViewManager, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        searchEmoRecyclerViewManager.clearData(z16, str);
    }

    private final void onHandleCompositeResult(IEmotionSearchManagerService.EmotionSearchResult result) {
        int i3;
        Map<String, ? extends Object> mapOf;
        boolean z16;
        int i16 = 3;
        if (result.getResult() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSearchCallBack success isHasMore:" + result.isHasMore());
            }
            List<EmotionSearchItem> resultItemList = result.getItemList();
            if (!this.mCompositeAdapter.checkDataContainEmotion()) {
                List<EmotionSearchItem> list = resultItemList;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    updateLoadingStatus(true, 8);
                }
            }
            if (result.isHasMore()) {
                i3 = 1;
            } else {
                i3 = 3;
            }
            updateLoadingStatus(true, i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(SearchEmoFooterData.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(resultItemList, "resultItemList");
            String str = result.searchTask.searchKeyWords;
            Intrinsics.checkNotNullExpressionValue(str, "result.searchTask.searchKeyWords");
            analyzeCompositeDataAndNotify(resultItemList, arrayList, str);
            IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask = result.searchTask;
            if (emotionSearchTask.startIndex == 0) {
                String str2 = emotionSearchTask.searchKeyWords;
                Intrinsics.checkNotNullExpressionValue(str2, "result.searchTask.searchKeyWords");
                reportSearchResultExpose(true, str2);
                if (this.mDialog.getMSupportCompositeEmo()) {
                    ReportController.o(this.mAppRuntime, "dc00898", "", "", "0X800C582", "0X800C582", 0, 0, "", "", "", result.searchTask.searchKeyWords);
                }
                EmotionDaTongReportUtil emotionDaTongReportUtil = EmotionDaTongReportUtil.INSTANCE;
                emotionDaTongReportUtil.setElementId(this.mCompositeRecyclerView, EmotionDaTongReportUtil.EM_BAS_SEARCH_RESULTS_PLATE);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_CONTAINS_SYNTHETIC, 1), TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, 2), TuplesKt.to("search_query_text", result.searchTask.searchKeyWords));
                emotionDaTongReportUtil.reportImp(this.mCompositeRecyclerView, mapOf);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSearchCallBack fail");
            }
            int i17 = this.mCompositeLoadingStatus;
            if (i17 != 0 && i17 != 5) {
                if (result.getResult() != -102 && result.getResult() != -100) {
                    if (result.getResult() != -104) {
                        i16 = 2;
                    }
                } else {
                    i16 = 7;
                }
            } else {
                i16 = 4;
            }
            updateLoadingStatus(true, i16);
        }
        this.mCompositeLoadMore = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onHandleRecommendResult(IEmotionSearchManagerService.EmotionSearchResult result) {
        int i3;
        Map<String, ? extends Object> mapOf;
        byte b16;
        int i16 = 3;
        if (result.getResult() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSearchCallBack success isHasMore:" + result.isHasMore());
            }
            List<EmotionSearchItem> recItemList = result.getItemList();
            if (!this.mCompositeAdapter.checkDataContainEmotion()) {
                List<EmotionSearchItem> list = recItemList;
                if (list != null && !list.isEmpty()) {
                    b16 = false;
                } else {
                    b16 = true;
                }
                if (b16 != false) {
                    updateLoadingStatus(false, 8);
                }
            }
            if (result.isHasMore()) {
                i3 = 1;
            } else {
                i3 = 3;
            }
            updateLoadingStatus(false, i3);
            List<EmotionSearchItem> topCompositeList = result.getTopCompositeList();
            if (topCompositeList == null) {
                topCompositeList = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(SearchEmoFooterData.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(recItemList, "recItemList");
            String str = result.searchTask.searchKeyWords;
            Intrinsics.checkNotNullExpressionValue(str, "result.searchTask.searchKeyWords");
            analyzeRecommendDataAndNotify(recItemList, topCompositeList, arrayList, str);
            IEmotionSearchManagerService.EmotionSearchTask emotionSearchTask = result.searchTask;
            if (emotionSearchTask.startIndex == 0) {
                String str2 = emotionSearchTask.searchKeyWords;
                Intrinsics.checkNotNullExpressionValue(str2, "result.searchTask.searchKeyWords");
                reportSearchResultExpose(false, str2);
                int i17 = !topCompositeList.isEmpty() ? 1 : 0;
                if (this.mDialog.getMSupportCompositeEmo() && i17 != 0) {
                    ReportController.o(this.mAppRuntime, "dc00898", "", "", "0X800C580", "0X800C580", 0, 0, "", "", "", result.searchTask.searchKeyWords);
                }
                EmotionDaTongReportUtil emotionDaTongReportUtil = EmotionDaTongReportUtil.INSTANCE;
                emotionDaTongReportUtil.setElementId(this.mRecommendRecyclerView, EmotionDaTongReportUtil.EM_BAS_SEARCH_RESULTS_PLATE);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_CONTAINS_SYNTHETIC, Integer.valueOf(i17)), TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, 1), TuplesKt.to("search_query_text", result.searchTask.searchKeyWords));
                emotionDaTongReportUtil.reportImp(this.mRecommendRecyclerView, mapOf);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSearchCallBack fail");
            }
            int i18 = this.mRecommendLoadingStatus;
            if (i18 != 0 && i18 != 5) {
                if (result.getResult() != -102 && result.getResult() != -100) {
                    if (result.getResult() != -104) {
                        i16 = 2;
                    }
                } else {
                    i16 = 7;
                }
            } else {
                i16 = 4;
            }
            updateLoadingStatus(false, i16);
        }
        this.mRecommendLoadMore = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void reportSearchResultExpose(boolean isComposite, String searchWord) {
        int i3;
        String str;
        int i16 = this.mFromType;
        int i17 = 2;
        if (i16 != 1) {
            if (i16 != 2) {
                i17 = 0;
            } else {
                i3 = 1;
                if (!isComposite) {
                    str = "2";
                } else {
                    str = "1";
                }
                ReportController.o(this.mAppRuntime, "dc00898", "", "", "0X800C525", "0X800C525", i3, 0, str, "", "", searchWord);
            }
        }
        i3 = i17;
        if (!isComposite) {
        }
        ReportController.o(this.mAppRuntime, "dc00898", "", "", "0X800C525", "0X800C525", i3, 0, str, "", "", searchWord);
    }

    public final boolean checkIsCompositeTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.mIsCompositeTab;
    }

    public final void clearData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            clearData$default(this, this.mIsCompositeTab, null, 2, null);
        } else {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.mRecommendAdapter.destroy();
        this.mCompositeAdapter.destroy();
        bz bzVar = this.mRecommendReportHelper;
        if (bzVar != null) {
            bzVar.clear();
        }
        bz bzVar2 = this.mCompositeReportHelper;
        if (bzVar2 != null) {
            bzVar2.clear();
        }
        this.mRecommendLoadMore = false;
        this.mCompositeLoadMore = false;
    }

    @NotNull
    public final SearchEmoticonListAdapter getCurAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (SearchEmoticonListAdapter) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        if (this.mIsCompositeTab) {
            return this.mCompositeAdapter;
        }
        return this.mRecommendAdapter;
    }

    @NotNull
    public final SearchEmoRecyclerView getCurRecyclerView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (SearchEmoRecyclerView) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (this.mIsCompositeTab) {
            return this.mCompositeRecyclerView;
        }
        return this.mRecommendRecyclerView;
    }

    @NotNull
    public final SearchEmoticonListAdapter getMCompositeAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SearchEmoticonListAdapter) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mCompositeAdapter;
    }

    public final boolean getMCompositeLoadMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mCompositeLoadMore;
    }

    public final int getMCompositeLoadingStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mCompositeLoadingStatus;
    }

    public final boolean getMIsCompositeTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mIsCompositeTab;
    }

    @NotNull
    public final SearchEmoticonListAdapter getMRecommendAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SearchEmoticonListAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mRecommendAdapter;
    }

    public final boolean getMRecommendLoadMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mRecommendLoadMore;
    }

    public final int getMRecommendLoadingStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mRecommendLoadingStatus;
    }

    public final boolean needRequestAfterSwitch(boolean isCompositeTab) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, isCompositeTab)).booleanValue();
        }
        if (isCompositeTab) {
            i3 = this.mCompositeLoadingStatus;
        } else {
            i3 = this.mRecommendLoadingStatus;
        }
        if (i3 != 0 && i3 != 7 && i3 != 2 && i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    public final void onHandleResult(@NotNull IEmotionSearchManagerService.EmotionSearchResult result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        String keywords = this.mDialog.getKeywords(this.mInfoAndActionCb.getCurSearchWords());
        QLog.i(TAG, 1, "onHandleResult searchTask words: " + result.searchTask.searchKeyWords + ", mCurSearchWords: " + keywords);
        if (!TextUtils.equals(result.searchTask.searchKeyWords, keywords)) {
            return;
        }
        if (result.searchTask.taskType == 2) {
            onHandleCompositeResult(result);
        } else {
            onHandleRecommendResult(result);
        }
    }

    public final void setMCompositeAdapter(@NotNull SearchEmoticonListAdapter searchEmoticonListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) searchEmoticonListAdapter);
        } else {
            Intrinsics.checkNotNullParameter(searchEmoticonListAdapter, "<set-?>");
            this.mCompositeAdapter = searchEmoticonListAdapter;
        }
    }

    public final void setMCompositeLoadMore(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mCompositeLoadMore = z16;
        }
    }

    public final void setMCompositeLoadingStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mCompositeLoadingStatus = i3;
        }
    }

    public final void setMIsCompositeTab(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mIsCompositeTab = z16;
        }
    }

    public final void setMRecommendAdapter(@NotNull SearchEmoticonListAdapter searchEmoticonListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) searchEmoticonListAdapter);
        } else {
            Intrinsics.checkNotNullParameter(searchEmoticonListAdapter, "<set-?>");
            this.mRecommendAdapter = searchEmoticonListAdapter;
        }
    }

    public final void setMRecommendLoadMore(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mRecommendLoadMore = z16;
        }
    }

    public final void setMRecommendLoadingStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mRecommendLoadingStatus = i3;
        }
    }

    public final void switchTab(boolean compositeTab, @NotNull CharSequence curSearchWords) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(compositeTab), curSearchWords);
            return;
        }
        Intrinsics.checkNotNullParameter(curSearchWords, "curSearchWords");
        this.mIsCompositeTab = compositeTab;
        if (compositeTab) {
            this.mRecommendRecyclerView.setVisibility(8);
            this.mRecommendRecyclerView.smoothScrollToPosition(0);
            this.mCompositeRecyclerView.setVisibility(0);
            this.mRecommendAdapter.hideBigErrorContainer();
            ReportController.o(this.mAppRuntime, "dc00898", "", "", "0X800C583", "0X800C583", 0, 0, "", "", "", curSearchWords.toString());
        } else {
            this.mRecommendRecyclerView.setVisibility(0);
            this.mCompositeRecyclerView.setVisibility(8);
            this.mCompositeRecyclerView.smoothScrollToPosition(0);
            this.mCompositeAdapter.hideBigErrorContainer();
        }
        if (TextUtils.equals(this.mDialog.getLastTaskSearchWords(compositeTab), curSearchWords) && !needRequestAfterSwitch(compositeTab)) {
            if (compositeTab) {
                i3 = this.mCompositeLoadingStatus;
            } else {
                i3 = this.mRecommendLoadingStatus;
            }
            if (i3 == 8) {
                updateLoadingStatus(compositeTab, 8);
                return;
            }
            return;
        }
        this.mDialog.loadSearchPicData(compositeTab, curSearchWords);
    }

    public final void updateLoadMore(boolean isComposite) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, isComposite);
        } else if (isComposite) {
            this.mCompositeLoadMore = false;
        } else {
            this.mRecommendLoadMore = false;
        }
    }

    public final void updateLoadingStatus(int loadingStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            updateLoadingStatus(this.mIsCompositeTab, loadingStatus);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, loadingStatus);
        }
    }

    public final void clearData(boolean isComposite, @NotNull String searchKeyWords) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(isComposite), searchKeyWords);
            return;
        }
        Intrinsics.checkNotNullParameter(searchKeyWords, "searchKeyWords");
        if (isComposite) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(SearchEmoFooterData.INSTANCE);
            Unit unit = Unit.INSTANCE;
            analyzeCompositeDataAndNotify(arrayList, arrayList2, searchKeyWords);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(SearchEmoFooterData.INSTANCE);
        Unit unit2 = Unit.INSTANCE;
        analyzeRecommendDataAndNotify(arrayList3, arrayList4, arrayList5, searchKeyWords);
    }

    public final void updateLoadingStatus(boolean isComposite, int loadingStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(isComposite), Integer.valueOf(loadingStatus));
        } else if (isComposite) {
            this.mCompositeLoadingStatus = loadingStatus;
            this.mCompositeAdapter.updateLoadingStatus(loadingStatus, true);
        } else {
            this.mRecommendLoadingStatus = loadingStatus;
            this.mRecommendAdapter.updateLoadingStatus(loadingStatus, false);
        }
    }
}
