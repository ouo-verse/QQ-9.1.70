package com.tencent.mobileqq.guild.aisearch;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.AIChatListPart;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputSendEvent;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002=>B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d`\u001eH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIChatListPart;", "Lcom/tencent/mobileqq/guild/aisearch/x;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "chatAnswerData", "", "K9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/guild/aisearch/TouchCaptureRecyclerView;", "d", "Lcom/tencent/mobileqq/guild/aisearch/TouchCaptureRecyclerView;", "chatRvList", "Lre1/e;", "e", "Lre1/e;", "jumpBtnController", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "f", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "currentAiChatSession", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", tl.h.F, "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "aiChatListViewModel", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListPart$a;", "i", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListPart$a;", "chatReportState", "Lcom/tencent/mobileqq/guild/aisearch/ChatListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/aisearch/ChatListAdapter;", "chatListAdapter", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIChatListPart extends x implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String D = "https://downv6.qq.com/innovate/guild/search/guild_ai_search_loading_ispt.png";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TouchCaptureRecyclerView chatRvList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private re1.e jumpBtnController;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AiChatSession currentAiChatSession;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiChatListViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChatReportState chatReportState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ChatListAdapter chatListAdapter;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u0000 \u00042\u00020\u0001:\u0001\rB/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000bH\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001a\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIChatListPart$a;", "", "", "f", "e", "", "d", "", "sessionId", "queryText", "answerId", "", "state", "a", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "b", "getQueryText", tl.h.F, "c", "getAnswerId", "g", "I", "()I", "j", "(I)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.AIChatListPart$a, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class ChatReportState {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String sessionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String queryText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String answerId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int state;

        public ChatReportState() {
            this(null, null, null, 0, 15, null);
        }

        public static /* synthetic */ ChatReportState b(ChatReportState chatReportState, String str, String str2, String str3, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = chatReportState.sessionId;
            }
            if ((i16 & 2) != 0) {
                str2 = chatReportState.queryText;
            }
            if ((i16 & 4) != 0) {
                str3 = chatReportState.answerId;
            }
            if ((i16 & 8) != 0) {
                i3 = chatReportState.state;
            }
            return chatReportState.a(str, str2, str3, i3);
        }

        @NotNull
        public final ChatReportState a(@NotNull String sessionId, @NotNull String queryText, @NotNull String answerId, int state) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(queryText, "queryText");
            Intrinsics.checkNotNullParameter(answerId, "answerId");
            return new ChatReportState(sessionId, queryText, answerId, state);
        }

        /* renamed from: c, reason: from getter */
        public final int getState() {
            return this.state;
        }

        public final boolean d() {
            int i3 = this.state;
            if (i3 != 6 && i3 != 8 && i3 != 7) {
                return false;
            }
            return true;
        }

        public final void e() {
            boolean z16;
            Map mapOf;
            if (this.sessionId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int i3 = this.state;
                int i16 = 5;
                if (i3 > 5 && i3 < 9) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isDevelopLevel()) {
                        Log.d("guild.ai.search.AIChatListPart", "reportOnError: state=" + this);
                    }
                    Pair[] pairArr = new Pair[4];
                    pairArr[0] = TuplesKt.to("sgrp_ai_session_id", this.sessionId);
                    pairArr[1] = TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, this.queryText);
                    pairArr[2] = TuplesKt.to("sgrp_dialog_id", this.answerId);
                    int i17 = this.state;
                    if (i17 != 6) {
                        if (i17 != 7) {
                            if (i17 != 8) {
                                i16 = -2;
                            }
                        }
                        pairArr[3] = TuplesKt.to("sgrp_output_progress", Integer.valueOf(i16));
                        mapOf = MapsKt__MapsKt.mapOf(pairArr);
                        VideoReport.reportEvent("ev_sgrp_ai_search_abnormal_out", mapOf);
                        return;
                    }
                    i16 = 4;
                    pairArr[3] = TuplesKt.to("sgrp_output_progress", Integer.valueOf(i16));
                    mapOf = MapsKt__MapsKt.mapOf(pairArr);
                    VideoReport.reportEvent("ev_sgrp_ai_search_abnormal_out", mapOf);
                    return;
                }
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("guild.ai.search.AIChatListPart", "reportOnError: sessionId is empty or state is not for report (" + this + ")");
            }
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChatReportState)) {
                return false;
            }
            ChatReportState chatReportState = (ChatReportState) other;
            if (Intrinsics.areEqual(this.sessionId, chatReportState.sessionId) && Intrinsics.areEqual(this.queryText, chatReportState.queryText) && Intrinsics.areEqual(this.answerId, chatReportState.answerId) && this.state == chatReportState.state) {
                return true;
            }
            return false;
        }

        public final void f() {
            boolean z16;
            Map mapOf;
            int i3 = 1;
            if (this.sessionId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && this.state < 5) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("guild.ai.search.AIChatListPart", "reportOnExit: state=" + this);
                }
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("sgrp_ai_session_id", this.sessionId);
                pairArr[1] = TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, this.queryText);
                pairArr[2] = TuplesKt.to("sgrp_dialog_id", this.answerId);
                int i16 = this.state;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3 && i16 != 4) {
                            i3 = -1;
                        } else {
                            i3 = 3;
                        }
                    } else {
                        i3 = 2;
                    }
                }
                pairArr[3] = TuplesKt.to("sgrp_output_progress", Integer.valueOf(i3));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                VideoReport.reportEvent("ev_sgrp_ai_search_abnormal_out", mapOf);
                return;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("guild.ai.search.AIChatListPart", "reportOnExit: sessionId is empty or state is not for report (" + this + ")");
            }
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.answerId = str;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.queryText = str;
        }

        public int hashCode() {
            return (((((this.sessionId.hashCode() * 31) + this.queryText.hashCode()) * 31) + this.answerId.hashCode()) * 31) + this.state;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sessionId = str;
        }

        public final void j(int i3) {
            this.state = i3;
        }

        @NotNull
        public String toString() {
            return "ChatReportState(sessionId=" + this.sessionId + ", queryText=" + this.queryText + ", answerId=" + this.answerId + ", state=" + this.state + ")";
        }

        public ChatReportState(@NotNull String sessionId, @NotNull String queryText, @NotNull String answerId, int i3) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(queryText, "queryText");
            Intrinsics.checkNotNullParameter(answerId, "answerId");
            this.sessionId = sessionId;
            this.queryText = queryText;
            this.answerId = answerId;
            this.state = i3;
        }

        public /* synthetic */ ChatReportState(String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? "" : str3, (i16 & 8) != 0 ? 1 : i3);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIChatListPart$b;", "", "", "THINKING_LOGO", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "AI_MSG_LLM_SOURCE_TYPE", "I", "AI_MSG_SPACE_TYPE", "AI_MSG_TYPE", "SEND_QUERY", "SHARE_AI_MSG_TYPE", "TAG", "USER_MSG_TYPE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.AIChatListPart$b, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return AIChatListPart.D;
        }

        Companion() {
        }
    }

    public AIChatListPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIChatListViewModel>() { // from class: com.tencent.mobileqq.guild.aisearch.AIChatListPart$aiChatListViewModel$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes12.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f213930a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f213930a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new AIChatListViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIChatListViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                Fragment hostFragment = AIChatListPart.this.getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                ViewModel viewModel = new ViewModelProvider(hostFragment, new a(hostFragment)).get(AIChatListViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (AIChatListViewModel) viewModel;
            }
        });
        this.aiChatListViewModel = lazy;
        this.chatReportState = new ChatReportState(null, null, null, 0, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIChatListViewModel J9() {
        return (AIChatListViewModel) this.aiChatListViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(ChatAnswerData chatAnswerData) {
        re1.e eVar = this.jumpBtnController;
        ChatListAdapter chatListAdapter = null;
        re1.e eVar2 = null;
        re1.e eVar3 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpBtnController");
            eVar = null;
        }
        eVar.o(chatAnswerData.getState());
        int state = chatAnswerData.getState();
        if (state != 1) {
            if (state != 2 && state != 4) {
                if (state == 5) {
                    ChatListAdapter chatListAdapter2 = this.chatListAdapter;
                    if (chatListAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
                        chatListAdapter2 = null;
                    }
                    chatListAdapter2.E0(new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AIChatListPart.L9(AIChatListPart.this);
                        }
                    });
                    re1.e eVar4 = this.jumpBtnController;
                    if (eVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jumpBtnController");
                    } else {
                        eVar2 = eVar4;
                    }
                    eVar2.h();
                    return;
                }
                return;
            }
            ChatListAdapter chatListAdapter3 = this.chatListAdapter;
            if (chatListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
                chatListAdapter3 = null;
            }
            chatListAdapter3.x0();
            TouchCaptureRecyclerView touchCaptureRecyclerView = this.chatRvList;
            if (touchCaptureRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatRvList");
                touchCaptureRecyclerView = null;
            }
            touchCaptureRecyclerView.R();
            re1.e eVar5 = this.jumpBtnController;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpBtnController");
            } else {
                eVar3 = eVar5;
            }
            eVar3.l();
            return;
        }
        ChatListAdapter chatListAdapter4 = this.chatListAdapter;
        if (chatListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
        } else {
            chatListAdapter = chatListAdapter4;
        }
        chatListAdapter.y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(AIChatListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TouchCaptureRecyclerView touchCaptureRecyclerView = this$0.chatRvList;
        if (touchCaptureRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatRvList");
            touchCaptureRecyclerView = null;
        }
        touchCaptureRecyclerView.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        IocPromise ioc = RFWIocAbilityProvider.g().getIoc(z.class);
        TouchCaptureRecyclerView touchCaptureRecyclerView = this.chatRvList;
        if (touchCaptureRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatRvList");
            touchCaptureRecyclerView = null;
        }
        ioc.originView(touchCaptureRecyclerView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.aisearch.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                AIChatListPart.N9((z) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(z zVar) {
        zVar.f8(GuildAISearchConfBean.INSTANCE.a().getCom.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants.KEY_PAGE_TITLE java.lang.String());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildAISearchInputSendEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        String str;
        if (Intrinsics.areEqual(action, "send_query")) {
            M9();
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputSendEvent");
            GuildAISearchInputSendEvent guildAISearchInputSendEvent = (GuildAISearchInputSendEvent) args;
            AIChatListViewModel J9 = J9();
            String searchText = guildAISearchInputSendEvent.getSearchText();
            String modelType = guildAISearchInputSendEvent.getModelInfo().getModelType();
            AiChatSession aiChatSession = this.currentAiChatSession;
            if (aiChatSession == null || (str = aiChatSession.getSessionId()) == null) {
                str = "";
            }
            J9.U1(searchText, modelType, str);
            ChatListAdapter chatListAdapter = this.chatListAdapter;
            if (chatListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
                chatListAdapter = null;
            }
            chatListAdapter.B0(guildAISearchInputSendEvent.getModelInfo());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ChatListAdapter chatListAdapter = this.chatListAdapter;
        if (chatListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
            chatListAdapter = null;
        }
        chatListAdapter.z0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.sfu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ai_chat_list)");
        this.chatRvList = (TouchCaptureRecyclerView) findViewById;
        this.jumpBtnController = new re1.e(rootView);
        AIChatListViewModel J9 = J9();
        Activity hostActivity = getPartHost().getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "partHost.hostActivity");
        this.chatListAdapter = new ChatListAdapter(J9, hostActivity, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIChatListPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String sessionId) {
                AIChatListViewModel J92;
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                J92 = AIChatListPart.this.J9();
                J92.T1(sessionId);
            }
        }, new Function1<ChatAnswerData, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIChatListPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatAnswerData chatAnswerData) {
                invoke2(chatAnswerData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ChatAnswerData chatAnswerData) {
                AIChatListPart.ChatReportState chatReportState;
                TouchCaptureRecyclerView touchCaptureRecyclerView;
                AIChatListPart.ChatReportState chatReportState2;
                AIChatListPart.ChatReportState chatReportState3;
                AIChatListPart.ChatReportState chatReportState4;
                AIChatListPart.ChatReportState chatReportState5;
                AIChatListPart.ChatReportState chatReportState6;
                Intrinsics.checkNotNullParameter(chatAnswerData, "chatAnswerData");
                chatReportState = AIChatListPart.this.chatReportState;
                if (chatReportState.getState() != chatAnswerData.getState()) {
                    chatReportState2 = AIChatListPart.this.chatReportState;
                    AIChatListPart.ChatReportState b16 = AIChatListPart.ChatReportState.b(chatReportState2, null, null, null, 0, 15, null);
                    chatReportState3 = AIChatListPart.this.chatReportState;
                    chatReportState3.j(chatAnswerData.getState());
                    Logger logger = Logger.f235387a;
                    AIChatListPart aIChatListPart = AIChatListPart.this;
                    if (QLog.isColorLevel()) {
                        Logger.a d16 = logger.d();
                        chatReportState6 = aIChatListPart.chatReportState;
                        d16.d("guild.ai.search.AIChatListPart", 2, "reportState: " + b16 + " -> " + chatReportState6);
                    }
                    chatReportState4 = AIChatListPart.this.chatReportState;
                    if (chatReportState4.d()) {
                        chatReportState5 = AIChatListPart.this.chatReportState;
                        chatReportState5.e();
                    }
                }
                touchCaptureRecyclerView = AIChatListPart.this.chatRvList;
                if (touchCaptureRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatRvList");
                    touchCaptureRecyclerView = null;
                }
                touchCaptureRecyclerView.d0(chatAnswerData);
                AIChatListPart.this.K9(chatAnswerData);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIChatListPart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                re1.e eVar;
                eVar = AIChatListPart.this.jumpBtnController;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpBtnController");
                    eVar = null;
                }
                eVar.f(false, true);
            }
        });
        TouchCaptureRecyclerView touchCaptureRecyclerView = this.chatRvList;
        if (touchCaptureRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatRvList");
            touchCaptureRecyclerView = null;
        }
        touchCaptureRecyclerView.setLayoutManager(new SafeLinearLayoutManager(touchCaptureRecyclerView.getContext()));
        ChatListAdapter chatListAdapter = this.chatListAdapter;
        if (chatListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
            chatListAdapter = null;
        }
        touchCaptureRecyclerView.setAdapter(chatListAdapter);
        touchCaptureRecyclerView.setCheckShowJumpButton(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIChatListPart$onInitView$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                re1.e eVar;
                eVar = AIChatListPart.this.jumpBtnController;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpBtnController");
                    eVar = null;
                }
                re1.e.g(eVar, z16, false, 2, null);
            }
        });
        touchCaptureRecyclerView.setItemAnimator(null);
        FlowKt.launchIn(FlowKt.onEach(J9().Q1(), new AIChatListPart$onInitView$5(this, null)), LifecycleOwnerKt.getLifecycleScope(com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this)));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        this.chatReportState.f();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildAISearchInputSendEvent) {
            broadcastMessage("send_query", event);
        }
    }
}
