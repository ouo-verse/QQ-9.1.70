package com.tencent.state.square.interaction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.cache.DiskLruCache;
import com.tencent.state.square.download.DownloadCallback;
import com.tencent.state.square.download.Source;
import com.tencent.state.square.download.SquareDownloader;
import com.tencent.state.square.download.TaskProgress;
import com.tencent.state.square.download.TaskResponse;
import com.tencent.state.square.like.LikeDataManager;
import com.tencent.zplan.common.utils.d;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00af\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001PB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJW\u0010\u001f\u001a\u00020\u001a2O\u0010 \u001aK\u0012\u0015\u0012\u0013\u0018\u00010\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001a\u0018\u00010!Jq\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062Q\b\u0002\u0010 \u001aK\u0012\u0015\u0012\u0013\u0018\u00010-\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001a\u0018\u00010!J\u0018\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u0004H\u0002J_\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u00042O\u0010 \u001aK\u0012\u0015\u0012\u0013\u0018\u000104\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001a\u0018\u00010!Ji\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062Q\b\u0002\u0010 \u001aK\u0012\u0015\u0012\u0013\u0018\u000108\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001a\u0018\u00010!J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140;2\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\u0014J\u0006\u0010=\u001a\u00020\u001aJ\u000e\u0010>\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020AJG\u0010B\u001a\u00020\u001a2\u0006\u00100\u001a\u00020*2\u0006\u0010C\u001a\u00020\u00042!\u0010D\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u001a0E2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0HJ\u000e\u0010I\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006JV\u0010J\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010K\u001a\u00020826\u0010 \u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001a0LJH\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020\u000428\u0010 \u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001a\u0018\u00010LR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018\u00a8\u0006Q"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionManager;", "", "()V", "CACHE_DIR_NAME", "", "MAX_CACHE_COUNT", "", "RECORD_LIST_FINISH_CURSOR", "cacheDir", "Ljava/io/File;", "getCacheDir", "()Ljava/io/File;", "diskCache", "Lcom/tencent/state/square/cache/DiskLruCache;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/state/square/download/SquareDownloader;", "interactionService", "Lcom/tencent/state/square/interaction/InteractionService;", "mRecordDetailUnReadInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", "mRecordSquareUnReadInfo", "mSquarePushListener", "com/tencent/state/square/interaction/InteractionManager$mSquarePushListener$1", "Lcom/tencent/state/square/interaction/InteractionManager$mSquarePushListener$1;", "clearUnread", "", "unreadScene", "destroyPush", "pushService", "Lcom/tencent/state/square/api/ISquarePushService;", "getAllInteractiveOptions", "callback", "Lkotlin/Function3;", "Lcom/tencent/state/square/interaction/InteractionSettingOptionList;", "Lkotlin/ParameterName;", "name", "result", "errorCode", "msg", "getInteractionOptions", "interactedUin", "", "targetStatus", "targetRichStatus", "Lcom/tencent/state/square/interaction/InteractionOptionsInfo;", "info", "getInteractionPagCachePath", "optionID", "url", "getInteractionRecord", "cursorId", "Lcom/tencent/state/square/interaction/InteractionRecordList;", "getInteractionSettings", "status", "richStatus", "Lcom/tencent/state/square/interaction/InteractionSettings;", "getMutableRecordUnreadLiveData", "getRecordUnreadLiveData", "Landroidx/lifecycle/LiveData;", "getSquareInteractionUnread", "init", "initPush", "interact", "interactData", "Lcom/tencent/state/square/interaction/InteractionManager$InteractData;", "loadPagResource", "pagURL", "onSuccess", "Lkotlin/Function1;", "path", "onFailed", "Lkotlin/Function0;", "refreshInteractionUnread", "saveInteractionSettings", QCircleDaTongConstant.ElementParamValue.SETTINGS, "Lkotlin/Function2;", "textCheck", "text", "code", "InteractData", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionManager {
    private static final String CACHE_DIR_NAME = "interaction_cache";
    public static final InteractionManager INSTANCE;
    private static final int MAX_CACHE_COUNT = 200;
    public static final String RECORD_LIST_FINISH_CURSOR = "0";
    private static final DiskLruCache diskCache;
    private static final SquareDownloader downloader;
    private static final InteractionService interactionService;
    private static final MutableLiveData<InteractionUnreadInfo> mRecordDetailUnReadInfo;
    private static final MutableLiveData<InteractionUnreadInfo> mRecordSquareUnReadInfo;
    private static final InteractionManager$mSquarePushListener$1 mSquarePushListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009c\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012Q\b\u0002\u0010\u000e\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010%J\u000b\u00103\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\rH\u00c6\u0003JR\u00107\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fH\u00c6\u0003J\u00b5\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2Q\b\u0002\u0010\u000e\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010=\u001a\u00020\u0005H\u00d6\u0001J\t\u0010>\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aRc\u0010\u000e\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a\u00a8\u0006?"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionManager$InteractData;", "", "interactedUin", "", "targetStatus", "", "targetRichStatus", "optionId", "optionTmp", "Lcom/tencent/state/square/interaction/InteractionOption;", "interactionType", "appId", "interactedUinList", "", "callback", "Lkotlin/Function3;", "Lcom/tencent/state/square/interaction/InteractionResult;", "Lkotlin/ParameterName;", "name", "result", "errorCode", "", "msg", "", "(JIILjava/lang/Long;Lcom/tencent/state/square/interaction/InteractionOption;II[JLkotlin/jvm/functions/Function3;)V", "getAppId", "()I", "getCallback", "()Lkotlin/jvm/functions/Function3;", IECSearchBar.METHOD_SET_CALLBACK, "(Lkotlin/jvm/functions/Function3;)V", "getInteractedUin", "()J", "getInteractedUinList", "()[J", "getInteractionType", "getOptionId", "()Ljava/lang/Long;", "setOptionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOptionTmp", "()Lcom/tencent/state/square/interaction/InteractionOption;", "setOptionTmp", "(Lcom/tencent/state/square/interaction/InteractionOption;)V", "getTargetRichStatus", "getTargetStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JIILjava/lang/Long;Lcom/tencent/state/square/interaction/InteractionOption;II[JLkotlin/jvm/functions/Function3;)Lcom/tencent/state/square/interaction/InteractionManager$InteractData;", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class InteractData {
        private final int appId;
        private Function3<? super InteractionResult, ? super Integer, ? super String, Unit> callback;
        private final long interactedUin;
        private final long[] interactedUinList;
        private final int interactionType;
        private Long optionId;
        private InteractionOption optionTmp;
        private final int targetRichStatus;
        private final int targetStatus;

        public InteractData(long j3, int i3, int i16, Long l3, InteractionOption interactionOption, int i17, int i18, long[] interactedUinList, Function3<? super InteractionResult, ? super Integer, ? super String, Unit> function3) {
            Intrinsics.checkNotNullParameter(interactedUinList, "interactedUinList");
            this.interactedUin = j3;
            this.targetStatus = i3;
            this.targetRichStatus = i16;
            this.optionId = l3;
            this.optionTmp = interactionOption;
            this.interactionType = i17;
            this.appId = i18;
            this.interactedUinList = interactedUinList;
            this.callback = function3;
        }

        /* renamed from: component1, reason: from getter */
        public final long getInteractedUin() {
            return this.interactedUin;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTargetStatus() {
            return this.targetStatus;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTargetRichStatus() {
            return this.targetRichStatus;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getOptionId() {
            return this.optionId;
        }

        /* renamed from: component5, reason: from getter */
        public final InteractionOption getOptionTmp() {
            return this.optionTmp;
        }

        /* renamed from: component6, reason: from getter */
        public final int getInteractionType() {
            return this.interactionType;
        }

        /* renamed from: component7, reason: from getter */
        public final int getAppId() {
            return this.appId;
        }

        /* renamed from: component8, reason: from getter */
        public final long[] getInteractedUinList() {
            return this.interactedUinList;
        }

        public final Function3<InteractionResult, Integer, String, Unit> component9() {
            return this.callback;
        }

        public final InteractData copy(long interactedUin, int targetStatus, int targetRichStatus, Long optionId, InteractionOption optionTmp, int interactionType, int appId, long[] interactedUinList, Function3<? super InteractionResult, ? super Integer, ? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(interactedUinList, "interactedUinList");
            return new InteractData(interactedUin, targetStatus, targetRichStatus, optionId, optionTmp, interactionType, appId, interactedUinList, callback);
        }

        public final int getAppId() {
            return this.appId;
        }

        public final Function3<InteractionResult, Integer, String, Unit> getCallback() {
            return this.callback;
        }

        public final long getInteractedUin() {
            return this.interactedUin;
        }

        public final long[] getInteractedUinList() {
            return this.interactedUinList;
        }

        public final int getInteractionType() {
            return this.interactionType;
        }

        public final Long getOptionId() {
            return this.optionId;
        }

        public final InteractionOption getOptionTmp() {
            return this.optionTmp;
        }

        public final int getTargetRichStatus() {
            return this.targetRichStatus;
        }

        public final int getTargetStatus() {
            return this.targetStatus;
        }

        public int hashCode() {
            int a16 = ((((c.a(this.interactedUin) * 31) + this.targetStatus) * 31) + this.targetRichStatus) * 31;
            Long l3 = this.optionId;
            int hashCode = (a16 + (l3 != null ? l3.hashCode() : 0)) * 31;
            InteractionOption interactionOption = this.optionTmp;
            int hashCode2 = (((((hashCode + (interactionOption != null ? interactionOption.hashCode() : 0)) * 31) + this.interactionType) * 31) + this.appId) * 31;
            long[] jArr = this.interactedUinList;
            int hashCode3 = (hashCode2 + (jArr != null ? Arrays.hashCode(jArr) : 0)) * 31;
            Function3<? super InteractionResult, ? super Integer, ? super String, Unit> function3 = this.callback;
            return hashCode3 + (function3 != null ? function3.hashCode() : 0);
        }

        public final void setCallback(Function3<? super InteractionResult, ? super Integer, ? super String, Unit> function3) {
            this.callback = function3;
        }

        public final void setOptionId(Long l3) {
            this.optionId = l3;
        }

        public final void setOptionTmp(InteractionOption interactionOption) {
            this.optionTmp = interactionOption;
        }

        public String toString() {
            return "InteractData(interactedUin=" + this.interactedUin + ", targetStatus=" + this.targetStatus + ", targetRichStatus=" + this.targetRichStatus + ", optionId=" + this.optionId + ", optionTmp=" + this.optionTmp + ", interactionType=" + this.interactionType + ", appId=" + this.appId + ", interactedUinList=" + Arrays.toString(this.interactedUinList) + ", callback=" + this.callback + ")";
        }

        public /* synthetic */ InteractData(long j3, int i3, int i16, Long l3, InteractionOption interactionOption, int i17, int i18, long[] jArr, Function3 function3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, i3, i16, l3, interactionOption, i17, i18, jArr, (i19 & 256) != 0 ? null : function3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InteractData)) {
                return false;
            }
            InteractData interactData = (InteractData) other;
            return this.interactedUin == interactData.interactedUin && this.targetStatus == interactData.targetStatus && this.targetRichStatus == interactData.targetRichStatus && Intrinsics.areEqual(this.optionId, interactData.optionId) && Intrinsics.areEqual(this.optionTmp, interactData.optionTmp) && this.interactionType == interactData.interactionType && this.appId == interactData.appId && Intrinsics.areEqual(this.interactedUinList, interactData.interactedUinList) && Intrinsics.areEqual(this.callback, interactData.callback);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.state.square.interaction.InteractionManager$mSquarePushListener$1] */
    static {
        InteractionManager interactionManager = new InteractionManager();
        INSTANCE = interactionManager;
        DiskLruCache diskLruCache = new DiskLruCache(interactionManager.getCacheDir(), 200, null, 4, null);
        diskCache = diskLruCache;
        downloader = new SquareDownloader(diskLruCache);
        interactionService = new InteractionService();
        mRecordDetailUnReadInfo = new MutableLiveData<>();
        mRecordSquareUnReadInfo = new MutableLiveData<>();
        mSquarePushListener = new ISquarePushListener() { // from class: com.tencent.state.square.interaction.InteractionManager$mSquarePushListener$1
            @Override // com.tencent.state.square.api.ISquarePushListener
            public void onResult(byte[] data) {
                Intrinsics.checkNotNullParameter(data, "data");
                InteractionManager interactionManager2 = InteractionManager.INSTANCE;
                interactionManager2.refreshInteractionUnread(2);
                interactionManager2.refreshInteractionUnread(1);
                LikeDataManager.INSTANCE.refreshStickers();
            }
        };
    }

    InteractionManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearUnread(int unreadScene) {
        interactionService.clearUnread(unreadScene, new Function1<Integer, Unit>() { // from class: com.tencent.state.square.interaction.InteractionManager$clearUnread$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(int i3) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                InteractionUnreadInfo interactionUnreadInfo;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                InteractionUnreadInfo interactionUnreadInfo2;
                InteractionManager interactionManager = InteractionManager.INSTANCE;
                mutableLiveData = InteractionManager.mRecordDetailUnReadInfo;
                mutableLiveData2 = InteractionManager.mRecordDetailUnReadInfo;
                InteractionUnreadInfo interactionUnreadInfo3 = (InteractionUnreadInfo) mutableLiveData2.getValue();
                if (interactionUnreadInfo3 == null || (interactionUnreadInfo = InteractionUnreadInfo.copy$default(interactionUnreadInfo3, 0, null, 2, null)) == null) {
                    interactionUnreadInfo = new InteractionUnreadInfo(0, null, 2, null);
                }
                mutableLiveData.postValue(interactionUnreadInfo);
                mutableLiveData3 = InteractionManager.mRecordSquareUnReadInfo;
                mutableLiveData4 = InteractionManager.mRecordSquareUnReadInfo;
                InteractionUnreadInfo interactionUnreadInfo4 = (InteractionUnreadInfo) mutableLiveData4.getValue();
                if (interactionUnreadInfo4 == null || (interactionUnreadInfo2 = InteractionUnreadInfo.copy$default(interactionUnreadInfo4, 0, null, 2, null)) == null) {
                    interactionUnreadInfo2 = new InteractionUnreadInfo(0, null, 2, null);
                }
                mutableLiveData3.postValue(interactionUnreadInfo2);
            }
        });
    }

    private final File getCacheDir() {
        return new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), CACHE_DIR_NAME);
    }

    private final String getInteractionPagCachePath(long optionID, String url) {
        return getCacheDir() + "/interaction_option_" + optionID + util.base64_pad_url + d.c(url) + ".pag";
    }

    public final void destroyPush(ISquarePushService pushService) {
        Intrinsics.checkNotNullParameter(pushService, "pushService");
        pushService.removeListener(5, mSquarePushListener);
    }

    public final void getAllInteractiveOptions(final Function3<? super InteractionSettingOptionList, ? super Integer, ? super String, Unit> callback) {
        interactionService.getAllInteractiveOptions(0, 0, new Function3<InteractionSettingOptionList, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionManager$getAllInteractiveOptions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(InteractionSettingOptionList interactionSettingOptionList, Integer num, String str) {
                invoke(interactionSettingOptionList, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(InteractionSettingOptionList interactionSettingOptionList, int i3, String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Function3 function3 = Function3.this;
                if (function3 != null) {
                }
            }
        });
    }

    public final void getInteractionOptions(long interactedUin, int targetStatus, int targetRichStatus, Function3<? super InteractionOptionsInfo, ? super Integer, ? super String, Unit> callback) {
        interactionService.getInteractionOptions(interactedUin, targetStatus, targetRichStatus, callback);
    }

    public final void getInteractionRecord(String cursorId, final Function3<? super InteractionRecordList, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(cursorId, "cursorId");
        interactionService.getInteractionRecord(cursorId, new Function3<InteractionRecordList, Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionManager$getInteractionRecord$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(InteractionRecordList interactionRecordList, Integer num, String str) {
                invoke(interactionRecordList, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(InteractionRecordList interactionRecordList, int i3, String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                if (interactionRecordList != null || i3 != 0) {
                    InteractionManager.INSTANCE.clearUnread(2);
                }
                Function3 function3 = Function3.this;
                if (function3 != null) {
                }
            }
        });
    }

    public final void getInteractionSettings(int status, int richStatus, Function3<? super InteractionSettings, ? super Integer, ? super String, Unit> callback) {
        interactionService.getInteractionSettings(status, richStatus, callback);
    }

    public final InteractionUnreadInfo getSquareInteractionUnread() {
        InteractionUnreadInfo value = mRecordSquareUnReadInfo.getValue();
        if (value == null) {
            value = new InteractionUnreadInfo(0, null, 3, null);
        }
        Intrinsics.checkNotNullExpressionValue(value, "mRecordSquareUnReadInfo.\u2026: InteractionUnreadInfo()");
        return value;
    }

    public final void init() {
        if (!getCacheDir().exists()) {
            getCacheDir().mkdirs();
        }
        diskCache.build();
    }

    public final void initPush(ISquarePushService pushService) {
        Intrinsics.checkNotNullParameter(pushService, "pushService");
        pushService.addListener(5, mSquarePushListener);
    }

    public final void interact(InteractData interactData) {
        Intrinsics.checkNotNullParameter(interactData, "interactData");
        interactionService.interact(interactData);
    }

    public final void loadPagResource(long optionID, String pagURL, final Function1<? super String, Unit> onSuccess, final Function0<Unit> onFailed) {
        Intrinsics.checkNotNullParameter(pagURL, "pagURL");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        if (Intrinsics.areEqual(pagURL, "")) {
            onFailed.invoke();
            return;
        }
        String interactionPagCachePath = getInteractionPagCachePath(optionID, pagURL);
        if (new File(interactionPagCachePath).exists()) {
            onSuccess.invoke(interactionPagCachePath);
        } else {
            downloader.addHighTask(new Source(pagURL, interactionPagCachePath), new DownloadCallback() { // from class: com.tencent.state.square.interaction.InteractionManager$loadPagResource$1
                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskFailed(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    onFailed.invoke();
                }

                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskProgress(Source source, TaskResponse response, TaskProgress progress) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    Intrinsics.checkNotNullParameter(progress, "progress");
                    DownloadCallback.DefaultImpls.onTaskProgress(this, source, response, progress);
                }

                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskStart(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    DownloadCallback.DefaultImpls.onTaskStart(this, source, response);
                }

                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskSuccess(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    Function1.this.invoke(source.getCachePath());
                }
            });
        }
    }

    public final void refreshInteractionUnread(final int unreadScene) {
        interactionService.getInteractionUnread(unreadScene, new Function2<InteractionUnreadInfo, Integer, Unit>() { // from class: com.tencent.state.square.interaction.InteractionManager$refreshInteractionUnread$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(InteractionUnreadInfo interactionUnreadInfo, Integer num) {
                invoke(interactionUnreadInfo, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(InteractionUnreadInfo interactionUnreadInfo, int i3) {
                MutableLiveData mutableRecordUnreadLiveData;
                if (interactionUnreadInfo == null || i3 != 0) {
                    return;
                }
                mutableRecordUnreadLiveData = InteractionManager.INSTANCE.getMutableRecordUnreadLiveData(unreadScene);
                mutableRecordUnreadLiveData.postValue(interactionUnreadInfo);
            }
        });
    }

    public final void saveInteractionSettings(int status, int richStatus, InteractionSettings settings, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(callback, "callback");
        interactionService.saveInteractionSettings(status, richStatus, settings, callback);
    }

    public final void textCheck(String text, final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(text, "text");
        interactionService.textCheck(text, new Function2<Integer, String, Unit>() { // from class: com.tencent.state.square.interaction.InteractionManager$textCheck$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Function2 function2 = Function2.this;
                if (function2 != null) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableLiveData<InteractionUnreadInfo> getMutableRecordUnreadLiveData(int unreadScene) {
        if (unreadScene == 2) {
            return mRecordDetailUnReadInfo;
        }
        return mRecordSquareUnReadInfo;
    }

    public final LiveData<InteractionUnreadInfo> getRecordUnreadLiveData(int unreadScene) {
        if (unreadScene == 2) {
            return mRecordDetailUnReadInfo;
        }
        return mRecordSquareUnReadInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getInteractionSettings$default(InteractionManager interactionManager, int i3, int i16, Function3 function3, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            function3 = null;
        }
        interactionManager.getInteractionSettings(i3, i16, function3);
    }

    public static /* synthetic */ void getInteractionOptions$default(InteractionManager interactionManager, long j3, int i3, int i16, Function3 function3, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            function3 = null;
        }
        interactionManager.getInteractionOptions(j3, i3, i16, function3);
    }
}
