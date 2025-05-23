package com.tencent.mobileqq.guild.channellist;

import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.base.extension.FlowKt$throttle$1;
import com.tencent.mobileqq.guild.channellist.process.ItemsProcessEvent;
import com.tencent.mobileqq.guild.channellist.process.Processors;
import com.tencent.mobileqq.guild.channellist.process.ReplaceResult;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bf;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bb\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001 \u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u0002:\u0002\u0084\u0001B\u0011\u0012\u0006\u0010\u0019\u001a\u00020\n\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0013\u0010\u0004\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0002J(\u0010\r\u001a\u00020\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J7\u0010\u0015\u001a\u00020\u0014\"\b\b\u0000\u0010\u000f*\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\nH\u0003J!\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u000f\u0010!\u001a\u00020 H\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u0003H\u0002J\b\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\u0003H\u0014J\b\u0010(\u001a\u00020\u0003H\u0016J\u0006\u0010)\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020\u0003J\n\u0010,\u001a\u0004\u0018\u00010+H\u0007J\u0012\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\nH\u0007J\u0012\u00101\u001a\u0004\u0018\u00010+2\u0006\u00100\u001a\u00020/H\u0007R\u0017\u0010\u0019\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00140S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00140W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR \u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0[0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010UR\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00140W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010YR\u001c\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010a0`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00140S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010UR(\u0010l\u001a\u0004\u0018\u00010\u001a2\b\u0010g\u001a\u0004\u0018\u00010\u001a8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR$\u0010n\u001a\u00020\n2\u0006\u0010g\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u00103\u001a\u0004\bm\u00105R\u0014\u0010r\u001a\u00020o8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bp\u0010qR\u0017\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00140s8F\u00a2\u0006\u0006\u001a\u0004\bt\u0010uR\u0017\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00140s8F\u00a2\u0006\u0006\u001a\u0004\bw\u0010uR\u001d\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0[0s8F\u00a2\u0006\u0006\u001a\u0004\by\u0010uR\u0017\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00140s8F\u00a2\u0006\u0006\u001a\u0004\b{\u0010uR\u0019\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010a0s8F\u00a2\u0006\u0006\u001a\u0004\b}\u0010uR\u0018\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140s8F\u00a2\u0006\u0006\u001a\u0004\b\u007f\u0010u\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/ChannelListViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/theme/d;", "", "z2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/guild/channellist/process/b;", "event", "Lkotlin/Pair;", "", "", "processData", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/mobileqq/guild/channellist/c;", "T", "oldItem", "newItem", "", "list", "", "B2", "(Lcom/tencent/mobileqq/guild/channellist/c;Lcom/tencent/mobileqq/guild/channellist/c;Ljava/util/List;)Z", "from", "v2", "guildId", "", "categoryId", "p2", "(Ljava/lang/String;Ljava/lang/Long;)Z", "C2", "r2", "com/tencent/mobileqq/guild/channellist/ChannelListViewModel$b", "u2", "()Lcom/tencent/mobileqq/guild/channellist/ChannelListViewModel$b;", "g2", NowProxyConstants.AccountInfoKey.A2, "account", "onAccountChanged", "onCleared", "onThemeChanged", "x2", "w2", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "q2", "source", "y2", "Lzq1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "t2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "Lkotlinx/coroutines/Job;", "D", "Lkotlinx/coroutines/Job;", "collectJob", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "E", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", UserInfo.SEX_FEMALE, "Z", "firstTimeUpdate", "Lcom/tencent/mobileqq/guild/channellist/process/Processors;", "G", "Lcom/tencent/mobileqq/guild/channellist/process/Processors;", "processors", "H", "Lcom/tencent/mobileqq/guild/channellist/ChannelListViewModel$b;", "gproObserver", "I", "Ljava/util/List;", "channelList", "", "J", "Ljava/util/Map;", "channelMap", "Ljs1/a;", "K", "Ljs1/a;", "delayRefreshStatus", "Landroidx/lifecycle/MutableLiveData;", "L", "Landroidx/lifecycle/MutableLiveData;", "_isChannelAdminLiveData", "Lcom/tencent/mobileqq/guild/util/cn;", "M", "Lcom/tencent/mobileqq/guild/util/cn;", "_finishLiveData", "", "N", "_dataListLiveData", "P", "_themeChangedLiveData", "Le12/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Le12/a;", "_guildInfo", BdhLogUtil.LogTag.Tag_Req, "_channelCreatePermission", "<set-?>", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Long;", "i2", "()Ljava/lang/Long;", "channelCategoryId", "k2", "chatTitle", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getIgpsService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "Landroidx/lifecycle/LiveData;", "o2", "()Landroidx/lifecycle/LiveData;", "themeChangedLiveData", "m2", "finishLiveData", "l2", "dataListLiveData", ICustomDataEditor.STRING_PARAM_2, "isChannelAdminLiveData", ICustomDataEditor.NUMBER_PARAM_2, "guildInfo", "j2", "channelCreatePermission", "<init>", "(Ljava/lang/String;)V", "U", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelListViewModel extends ef1.b implements com.tencent.mobileqq.guild.theme.d {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Job collectJob;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private RuntimeServiceHolder serviceHolder;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean firstTimeUpdate;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Processors processors;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b gproObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<c> channelList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private Map<String, c> channelMap;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private js1.a delayRefreshStatus;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isChannelAdminLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _finishLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<c>> _dataListLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _themeChangedLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final e12.a<IGProGuildInfo> _guildInfo;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _channelCreatePermission;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Long channelCategoryId;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String chatTitle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/ChannelListViewModel$a;", "", "", "Lcom/tencent/mobileqq/guild/channellist/c;", "", "", "b", "", "REFRESH_GAP_MID", "J", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channellist.ChannelListViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, c> b(List<? extends c> list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (c cVar : list) {
                if (cVar instanceof TextChannelData) {
                    linkedHashMap.put(String.valueOf(((TextChannelData) cVar).getChannelUin()), cVar);
                } else if (cVar instanceof AppChannelData) {
                    linkedHashMap.put(String.valueOf(((AppChannelData) cVar).getChannelUin()), cVar);
                }
            }
            return linkedHashMap;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J \u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0014J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J\u001a\u0010\u001b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J.\u0010\u001f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001dH\u0014J\u001c\u0010\"\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J,\u0010&\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0014\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/channellist/ChannelListViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "refreshSource", "", "", "extras", "", "b", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "onGuildInfoUpdated", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "", "channelIdList", "onChannelListAdded", "onChannelListUpdated", "channelUin", "onChannelInfoUpdated", "", "expireTime", "onShutUpStateChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "onChannelPermissionChanged", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "channelId", "oldVisibleType", "newVisibleType", "onChannelVisibleChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        private final void b(String guildId, String refreshSource, Object... extras) {
            if (!Intrinsics.areEqual(guildId, ChannelListViewModel.this.getGuildId())) {
                return;
            }
            Logger.a d16 = Logger.f235387a.d();
            String arrays = Arrays.toString(extras);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            d16.i("Guild.NewHome.subFrag.ChannelListViewModel", 1, "handleChannelListEvent: " + refreshSource + ", guildId=" + guildId + ", extras=" + arrays);
            ChannelListViewModel.this.y2(refreshSource);
        }

        private final void e(String guildId) {
            if (Intrinsics.areEqual(guildId, ChannelListViewModel.this.getGuildId())) {
                ChannelListViewModel.this._finishLiveData.setValue(Boolean.TRUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            e(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            IGProChannelInfo channelInfo = ChannelListViewModel.this.getIgpsService().getChannelInfo(channelUin);
            if (channelInfo == null || !Intrinsics.areEqual(channelInfo.getGuildId(), ChannelListViewModel.this.getGuildId())) {
                return;
            }
            b(ChannelListViewModel.this.getGuildId(), "CHANNEL_INFO_UPDATE", new Object[0]);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelListAdded(@Nullable String guildId, @NotNull List<String> channelIdList) {
            Intrinsics.checkNotNullParameter(channelIdList, "channelIdList");
            b(guildId, "CHANNEL_LIST_ADD", channelIdList);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, ChannelListViewModel.this.getGuildId())) {
                Logger.f235387a.d().i("Guild.NewHome.subFrag.ChannelListViewModel", 1, "onChannelListUpdated: " + guildId + "}");
                b(guildId, "CHANNEL_LIST_UPDATE", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@Nullable String guildId, @Nullable HashSet<String> channelIds) {
            b(guildId, "CHANNEL_PERMISSION_UPDATE", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(@Nullable String guildId, @Nullable String channelId, int oldVisibleType, int newVisibleType) {
            b(guildId, "CHANNEL_VISIBLE_CHANGED", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            e(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            e(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, ChannelListViewModel.this.getGuildId())) {
                ChannelListViewModel.this._guildInfo.setValue(ch.L(guildId));
                b(guildId, "GUILD_INFO_UPDATE", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx permission) {
            b(guildId, "GUILD_PERMISSION_UPDATE", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            e(guildId);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            b(guildId, "SHUT_UP_STATE_UPDATE", new Object[0]);
        }
    }

    public ChannelListViewModel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.serviceHolder = new RuntimeServiceHolder();
        this.firstTimeUpdate = true;
        this.processors = Processors.INSTANCE.a();
        this.gproObserver = u2();
        this.channelList = new ArrayList();
        this.channelMap = new LinkedHashMap();
        this.delayRefreshStatus = new js1.a(false, false, false, 0, 15, null);
        this._isChannelAdminLiveData = new MutableLiveData<>();
        this._finishLiveData = new cn<>();
        this._dataListLiveData = new MutableLiveData<>();
        this._themeChangedLiveData = new cn<>();
        this._guildInfo = new e12.a<>();
        this._channelCreatePermission = new MutableLiveData<>();
        this.chatTitle = "\u8ba8\u8bba\u7ec4";
        g2();
        q2();
        GuildThemeManager.g(this);
    }

    private final void A2() {
        getIgpsService().deleteObserver(this.gproObserver);
    }

    @UiThread
    private final <T extends c> boolean B2(T oldItem, T newItem, List<c> list) {
        int indexOf = list.indexOf(oldItem);
        if (indexOf == -1) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "replaceInList: " + oldItem + " " + newItem;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.subFrag.ChannelListViewModel", 1, (String) it.next(), null);
            }
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                String str2 = "replaceInList[" + i3 + "]: " + ((c) obj);
                if (str2 instanceof String) {
                    bVar2.a().add(str2);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.NewHome.subFrag.ChannelListViewModel", 1, (String) it5.next(), null);
                }
                i3 = i16;
            }
            com.tencent.mobileqq.guild.util.s.f("Guild.NewHome.subFrag.ChannelListViewModel", "replaceInList: oldItem not found in list", new IllegalStateException());
            return false;
        }
        list.set(indexOf, newItem);
        return true;
    }

    private final void C2() {
        boolean r26 = r2();
        if (!Intrinsics.areEqual(this._isChannelAdminLiveData.getValue(), Boolean.valueOf(r26))) {
            this._isChannelAdminLiveData.setValue(Boolean.valueOf(r26));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D2(ItemsProcessEvent<?> event, Pair<String, ? extends Object> processData) {
        c cVar = this.channelMap.get(processData.getFirst());
        if (cVar != null) {
            ReplaceResult n3 = event.c().n(cVar, processData.getSecond());
            if (n3.getReplacedItem() != null) {
                this.channelMap.put(processData.getFirst(), n3.getReplacedItem());
                B2(cVar, n3.getReplacedItem(), this.channelList);
            }
        }
    }

    private final void g2() {
        getIgpsService().addObserver(this.gproObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService getIgpsService() {
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (Intrinsics.areEqual("", "VASH_TAG")) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RuntimeServiceHolder", 1, "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...");
            } else if (logger.c()) {
                String str = "VASH_TAG: _obtain(, " + IGPSService.class.getSimpleName() + ") calling...";
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    Logger logger2 = Logger.f235387a;
                    if (logger2.c() && QLog.isColorLevel()) {
                        logger2.d().d("RuntimeServiceHolder", 1, String.valueOf(charAt));
                    }
                }
            }
        }
        return (IGPSService) runtimeServiceHolder.b("", IGPSService.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        Job job = this.collectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        final Flow<ItemsProcessEvent<?>> d16 = this.processors.d();
        Flow onEach = FlowKt.onEach(new Flow<ItemsProcessEvent<?>>() { // from class: com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass2 implements FlowCollector<ItemsProcessEvent<?>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f215256d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ ChannelListViewModel f215257e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$$inlined$filter$1$2", f = "ChannelListViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, ChannelListViewModel channelListViewModel) {
                    this.f215256d = flowCollector;
                    this.f215257e = channelListViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(ItemsProcessEvent<?> itemsProcessEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f215256d;
                                if (Intrinsics.areEqual(itemsProcessEvent.getGuildId(), this.f215257e.getGuildId())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(itemsProcessEvent, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super ItemsProcessEvent<?>> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new ChannelListViewModel$collectProcessorEventSource$2(this, null));
        Ref.LongRef longRef = new Ref.LongRef();
        Job launchIn = FlowKt.launchIn(FlowKt.m2026catch(FlowKt.onEach(FlowKt.debounce(onEach, new FlowKt$throttle$1(longRef, 500L)), new ChannelListViewModel$collectProcessorEventSource$$inlined$throttle$default$1(longRef, null, this)), new ChannelListViewModel$collectProcessorEventSource$4(this, null)), ViewModelKt.getViewModelScope(this));
        this.collectJob = launchIn;
        if (launchIn != null) {
            launchIn.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.ChannelListViewModel$collectProcessorEventSource$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    Logger.f235387a.d().i("Guild.NewHome.subFrag.ChannelListViewModel", 1, "collectProcessorEventSource completed, " + th5);
                }
            });
        }
    }

    private final boolean p2(String guildId, Long categoryId) {
        if (categoryId == null) {
            Logger.f235387a.d().w("Guild.NewHome.subFrag.ChannelListViewModel", 1, "hasCreateChannelPermission categoryId is null");
            return com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().getGuildPermission(guildId).a(20001);
        }
        if (com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().getGuildPermission(guildId).a(20001) || com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().getCategoryPermission(guildId, categoryId.toString()).a(20001)) {
            return true;
        }
        return false;
    }

    private final boolean r2() {
        return ch.m0(this.guildId);
    }

    private final b u2() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void v2(String from) {
        boolean z16;
        boolean z17 = true;
        if (!this.delayRefreshStatus.a(10)) {
            js1.a aVar = this.delayRefreshStatus;
            aVar.c(aVar.getDelayRefreshTimes() + 1);
            Logger.f235387a.d().w("Guild.NewHome.subFrag.ChannelListViewModel", 1, "notifyDataListChanged but return from:" + from + ", delayRefreshStatus:" + this.delayRefreshStatus);
            return;
        }
        C2();
        this.delayRefreshStatus.c(0);
        ArrayList arrayList = new ArrayList();
        boolean p26 = p2(this.guildId, this.channelCategoryId);
        boolean a16 = bf.f235464a.a();
        Logger.f235387a.d().i("Guild.NewHome.subFrag.ChannelListViewModel", 1, "update from:" + from + ", canCreate: " + p26 + " && " + a16 + ", isEmpty:" + this.channelList.isEmpty());
        if (p26 && a16) {
            z16 = true;
        } else {
            z16 = false;
        }
        MutableLiveData<Boolean> mutableLiveData = this._channelCreatePermission;
        if (!z16 || this.channelList.isEmpty()) {
            z17 = false;
        }
        mutableLiveData.setValue(Boolean.valueOf(z17));
        if (this.channelList.isEmpty()) {
            String r16 = QQGuildUIUtil.r(R.string.f142330j3);
            Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild_chat_empty_description)");
            arrayList.add(new EmptyPageData(3, "\u6682\u65e0\u8ba8\u8bba\u7ec4", r16, z16));
        } else {
            arrayList.addAll(this.channelList);
            arrayList.add(new r(QQGuildUIUtil.f(150.0f)));
        }
        this._dataListLiveData.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z2(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ChannelListViewModel$refreshChannelsInner$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: i2, reason: from getter */
    public final Long getChannelCategoryId() {
        return this.channelCategoryId;
    }

    @NotNull
    public final LiveData<Boolean> j2() {
        return this._channelCreatePermission;
    }

    @NotNull
    /* renamed from: k2, reason: from getter */
    public final String getChatTitle() {
        return this.chatTitle;
    }

    @NotNull
    public final LiveData<List<c>> l2() {
        return this._dataListLiveData;
    }

    @NotNull
    public final LiveData<Boolean> m2() {
        return this._finishLiveData;
    }

    @NotNull
    public final LiveData<IGProGuildInfo> n2() {
        return this._guildInfo;
    }

    @NotNull
    public final LiveData<Boolean> o2() {
        return this._themeChangedLiveData;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger.f235387a.d().i("Guild.NewHome.subFrag.ChannelListViewModel", 1, "onAccountChanged, " + account);
        A2();
        super.onAccountChanged(account);
        this.processors.f(account);
        this.serviceHolder = new RuntimeServiceHolder();
        g2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        A2();
        this.processors.g();
        Job job = this.collectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        GuildThemeManager.j(this);
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        this._themeChangedLiveData.setValue(Boolean.TRUE);
    }

    @UiThread
    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b q2() {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.NewHome.subFrag.ChannelListViewModel refresh", null, null, Boolean.TRUE, new ChannelListViewModel$initData$1(this, null), 6, null);
        Intrinsics.checkNotNull(e16);
        Job a16 = e16.a();
        Intrinsics.checkNotNull(a16);
        a16.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.ChannelListViewModel$initData$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("Guild.NewHome.subFrag.ChannelListViewModel", 1, "init completed, " + th5);
            }
        });
        return e16;
    }

    @NotNull
    public final LiveData<Boolean> s2() {
        return this._isChannelAdminLiveData;
    }

    @UiThread
    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b t2(@NotNull zq1.e item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.NewHome.subFrag.ChannelListViewModel markRead", null, null, Boolean.TRUE, new ChannelListViewModel$markRead$1(item, null), 6, null);
    }

    public final void w2() {
        this.delayRefreshStatus.d(false);
        if (this.delayRefreshStatus.getDelayRefreshTimes() > 0) {
            v2("onRedPointDragEnd");
        }
    }

    public final void x2() {
        this.delayRefreshStatus.d(true);
    }

    @UiThread
    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b y2(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b e16 = CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.NewHome.subFrag.ChannelListViewModel refresh", null, null, Boolean.TRUE, new ChannelListViewModel$refreshChannels$1(this, source, null), 6, null);
        Intrinsics.checkNotNull(e16);
        Job a16 = e16.a();
        Intrinsics.checkNotNull(a16);
        a16.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.channellist.ChannelListViewModel$refreshChannels$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("Guild.NewHome.subFrag.ChannelListViewModel", 1, "refreshChannels completed, " + th5);
            }
        });
        return e16;
    }
}
