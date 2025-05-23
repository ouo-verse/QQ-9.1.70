package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import androidx.annotation.UiThread;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.aisearch.SSESearchConfig;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u0001GB\u000f\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007J\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0007J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR%\u0010\"\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00070\u00070\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R%\u0010%\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00070\u00070\u001c8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010&\u001a\u0004\u0018\u00010\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R$\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0017\u0010<\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u0002078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010;R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u0002000?8F\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "reason", "", "ignoreState", "M1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "aiSearchInfo", "e2", "d2", "W1", "onCleared", "b2", NodeProps.VISIBLE, "c2", "O1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "Lkotlin/collections/ArrayList;", "T1", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchDepositary;", "i", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchDepositary;", "dsSearchDepositary", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "X1", "()Landroidx/lifecycle/MutableLiveData;", "isShowExpandedBtn", BdhLogUtil.LogTag.Tag_Conn, "U1", "hasShowExpandedBtn", "<set-?>", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "P1", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "Lkotlinx/coroutines/Job;", "E", "Lkotlinx/coroutines/Job;", "searchJob", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/p;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_aiSearchStateFlow", "G", "Ljava/util/ArrayList;", "feedbackList", "", "H", "I", "S1", "()I", "delayTime", "R1", "dataState", "Lkotlinx/coroutines/flow/StateFlow;", "Q1", "()Lkotlinx/coroutines/flow/StateFlow;", "aiSearchStateFlow", "Lcom/tencent/mobileqq/guild/aisearch/aa;", "sseSearchConfig", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/aa;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DSSearchViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> hasShowExpandedBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IGProGuildSearchAISearchInfo aiSearchInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Job searchJob;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableStateFlow<DSSearchData> _aiSearchStateFlow;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<SearchText> feedbackList;

    /* renamed from: H, reason: from kotlin metadata */
    private final int delayTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DSSearchDepositary dsSearchDepositary;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isShowExpandedBtn;

    public DSSearchViewModel(@NotNull SSESearchConfig sseSearchConfig) {
        int i3;
        Intrinsics.checkNotNullParameter(sseSearchConfig, "sseSearchConfig");
        this.dsSearchDepositary = new DSSearchDepositary(sseSearchConfig);
        Boolean bool = Boolean.FALSE;
        this.isShowExpandedBtn = new MutableLiveData<>(bool);
        this.hasShowExpandedBtn = new MutableLiveData<>(bool);
        this._aiSearchStateFlow = StateFlowKt.MutableStateFlow(new DSSearchData(1, "", "", 0L, 0L, 16, null));
        ArrayList<SearchText> arrayList = new ArrayList<>();
        SearchText searchText = new SearchText();
        searchText.text = "\u4e0e\u95ee\u9898\u65e0\u5173";
        arrayList.add(searchText);
        SearchText searchText2 = new SearchText();
        searchText2.text = "\u4fe1\u606f\u6709\u8bef";
        arrayList.add(searchText2);
        SearchText searchText3 = new SearchText();
        searchText3.text = "\u4e0d\u6613\u7406\u89e3";
        arrayList.add(searchText3);
        SearchText searchText4 = new SearchText();
        searchText4.text = "\u5176\u4ed6";
        arrayList.add(searchText4);
        this.feedbackList = arrayList;
        if (Intrinsics.areEqual(sseSearchConfig.getScene(), "ALL_GUILD")) {
            i3 = GuildAISearchConfBean.INSTANCE.a().getNeed_parse_delay();
        } else {
            i3 = 0;
        }
        this.delayTime = i3;
    }

    private final void M1(String reason, boolean ignoreState) {
        String str;
        if (R1() == 5 && !ignoreState) {
            Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchViewModel", 1, "already load finish " + reason);
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        IGProGuildSearchAISearchInfo aiSearchInfo = getAiSearchInfo();
        if (aiSearchInfo != null) {
            str = aiSearchInfo.getSearchKey();
        } else {
            str = null;
        }
        d16.i("QQGuildInSearchTag.DSSearchViewModel", 1, "begin beginSearchDeepSeek " + reason + " " + str);
        a2();
        Z1();
    }

    static /* synthetic */ void N1(DSSearchViewModel dSSearchViewModel, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        dSSearchViewModel.M1(str, z16);
    }

    private final int R1() {
        return this._aiSearchStateFlow.getValue().getState();
    }

    private final void Z1() {
        String str;
        Job job = this.searchJob;
        if (job != null) {
            job.cancel(new CancellationException("new search launched"));
        }
        IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo = this.aiSearchInfo;
        if (iGProGuildSearchAISearchInfo != null) {
            str = iGProGuildSearchAISearchInfo.getSearchKey();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        this.searchJob = FlowKt.launchIn(FlowKt.onEach(this.dsSearchDepositary.l(str), new DSSearchViewModel$launchNewSearch$1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final void a2() {
        this._aiSearchStateFlow.setValue(new DSSearchData(1, "", "", 0L, 0L, 16, null));
    }

    public final boolean O1() {
        if (R1() != 6 && R1() != 8) {
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: P1, reason: from getter */
    public final IGProGuildSearchAISearchInfo getAiSearchInfo() {
        return this.aiSearchInfo;
    }

    @NotNull
    public final StateFlow<DSSearchData> Q1() {
        return this._aiSearchStateFlow;
    }

    /* renamed from: S1, reason: from getter */
    public final int getDelayTime() {
        return this.delayTime;
    }

    @NotNull
    public final ArrayList<SearchText> T1() {
        return this.feedbackList;
    }

    @NotNull
    public final MutableLiveData<Boolean> U1() {
        return this.hasShowExpandedBtn;
    }

    @NotNull
    public final String W1() {
        String str;
        IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo = this.aiSearchInfo;
        if (iGProGuildSearchAISearchInfo != null) {
            str = iGProGuildSearchAISearchInfo.getDefaultText();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final MutableLiveData<Boolean> X1() {
        return this.isShowExpandedBtn;
    }

    @UiThread
    public final void b2() {
        if (O1()) {
            N1(this, TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, false, 2, null);
        }
    }

    public final void c2(boolean visible) {
        this.isShowExpandedBtn.setValue(Boolean.valueOf(visible));
        if (visible) {
            this.hasShowExpandedBtn.setValue(Boolean.TRUE);
        }
    }

    @UiThread
    public final void d2() {
        Job job = this.searchJob;
        if (job != null) {
            job.cancel(new CancellationException("stop previous search"));
        }
    }

    @UiThread
    public final void e2(@NotNull IGProGuildSearchAISearchInfo aiSearchInfo) {
        String str;
        Intrinsics.checkNotNullParameter(aiSearchInfo, "aiSearchInfo");
        IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo = this.aiSearchInfo;
        if (iGProGuildSearchAISearchInfo != null) {
            str = iGProGuildSearchAISearchInfo.getSearchKey();
        } else {
            str = null;
        }
        boolean z16 = !Intrinsics.areEqual(str, aiSearchInfo.getSearchKey());
        Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchViewModel", 1, "updateSearchKeyAndAiSearchInfo searchKeyChanged=" + z16 + " key=" + aiSearchInfo.getSearchKey());
        this.aiSearchInfo = aiSearchInfo;
        if (z16) {
            a2();
            MutableLiveData<Boolean> mutableLiveData = this.hasShowExpandedBtn;
            Boolean bool = Boolean.FALSE;
            mutableLiveData.setValue(bool);
            this.isShowExpandedBtn.setValue(bool);
            M1("searchKey changed", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        d2();
        super.onCleared();
    }
}
