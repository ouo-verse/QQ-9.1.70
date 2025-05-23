package com.tencent.mobileqq.guild.media.aio;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.media.aio.a;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.MediaShareLoadInfo;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.media.model.AudioQueueState;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 k2\u00020\u0001:\u0001lB\u0007\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 J\u000e\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020 J\u000e\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020 J\u0006\u0010%\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020&J\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020\u0004R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\"\u00101\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\u00040\u00040*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010-R\"\u00103\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\u00040\u00040*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010-R\"\u00105\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\u00040\u00040*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010-R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000207068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000f0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010FR\u0016\u0010N\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010DR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000f0O8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020+0O8\u0006\u00a2\u0006\f\n\u0004\bU\u0010Q\u001a\u0004\bV\u0010SR\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040O8\u0006\u00a2\u0006\f\n\u0004\bX\u0010Q\u001a\u0004\bY\u0010SR\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00040O8\u0006\u00a2\u0006\f\n\u0004\b[\u0010Q\u001a\u0004\b\\\u0010SR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u0002070O8\u0006\u00a2\u0006\f\n\u0004\b^\u0010Q\u001a\u0004\b_\u0010SR$\u0010h\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$b;", "S1", "", "e2", "Lcom/tencent/mobileqq/guild/media/aio/b$p;", "intent", "", "f2", "Lcom/tencent/mobileqq/guild/media/aio/b$f;", "U1", "Lcom/tencent/mobileqq/guild/media/aio/b$i;", "d2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/guild/media/aio/a;", "event", "j2", "M1", "Lcom/tencent/mobileqq/guild/media/core/data/MediaShareLoadInfo;", "shareInfo", "m2", "o2", "Lcom/tencent/mobileqq/guild/media/aio/b;", "l2", "k2", "", HippyTKDListViewAdapter.X, "y", SemanticAttributes.DbSystemValues.H2, "L1", "g2", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "giftAnimData", "W1", "b2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "X1", "Lcom/tencent/mobileqq/guild/media/core/notify/af;", "c2", "Z1", "i2", "Le12/e;", "Lcom/tencent/mobileqq/guild/media/aio/AioUiState;", "i", "Le12/e;", "_aioUiState", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_shouldShowBizBottomBar", BdhLogUtil.LogTag.Tag_Conn, "_aioPanelOrKeyboardShowState", "D", "_aioPanelOrKeyboardRealShow", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "E", "Landroidx/lifecycle/MutableLiveData;", "_draftEvent", "Lcom/tencent/mobileqq/guild/util/cn;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/util/cn;", "_aioNotifyUiEvent", "Lus0/b;", "G", "Lus0/b;", "aioCtrl", "H", "Z", "aioIsPanelOrKeyBoardShow", "I", "aioInputBarShow", "J", "aioMultiSelectShow", "", "K", "aioCurrentPaddingTop", "L", "aioMsgUiIsOpened", "Landroidx/lifecycle/LiveData;", "M", "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "aioNotifyUiEvent", "N", "P1", "aioUiState", "P", "T1", "shouldShowBizBottomBar", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "O1", "aioPanelOrKeyboardShowState", BdhLogUtil.LogTag.Tag_Req, "R1", "draftValue", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager;", "Q1", "()Lcom/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager;", "setCombineTipsManager", "(Lcom/tencent/mobileqq/guild/media/aio/GuildMediaLocalCombineStyleItemManager;)V", "combineTipsManager", "<init>", "()V", "T", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaAioViewModel extends ViewModel {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Boolean> _aioPanelOrKeyboardShowState;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Boolean> _aioPanelOrKeyboardRealShow;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<GuildAIOInputEditText> _draftEvent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final cn<a> _aioNotifyUiEvent;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private us0.b aioCtrl;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean aioIsPanelOrKeyBoardShow;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean aioInputBarShow;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean aioMultiSelectShow;

    /* renamed from: K, reason: from kotlin metadata */
    private int aioCurrentPaddingTop;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean aioMsgUiIsOpened;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<a> aioNotifyUiEvent;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<AioUiState> aioUiState;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> shouldShowBizBottomBar;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> aioPanelOrKeyboardShowState;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<GuildAIOInputEditText> draftValue;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private GuildMediaLocalCombineStyleItemManager combineTipsManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.e<AioUiState> _aioUiState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.e<Boolean> _shouldShowBizBottomBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel$a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "a", "", "MIN_X_DOWN_START_POS", "I", "", "STR_AUDIO_QUEUE_CLOSE", "Ljava/lang/String;", "STR_AUDIO_QUEUE_ENTER", "STR_AUDIO_QUEUE_EXIT", "STR_FREE_MODE_TIPS", "STR_QUEUE_MODE_TIPS", "STR_RAISE_HAND_MODE_TIPS", "STR_THIRD_APP_MODE_TIPS", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildMediaAioViewModel a(@NotNull FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(com.tencent.mobileqq.guild.media.presenter.g.f229131d).get(GuildMediaAioViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(Guil\u2026AioViewModel::class.java)");
            return (GuildMediaAioViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227802a;

        static {
            int[] iArr = new int[AudioQueueState.values().length];
            try {
                iArr[AudioQueueState.AUDIO_QUEUE_ENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudioQueueState.AUDIO_QUEUE_EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AudioQueueState.AUDIO_QUEUE_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f227802a = iArr;
        }
    }

    public GuildMediaAioViewModel() {
        e12.e<AioUiState> eVar = new e12.e<>();
        this._aioUiState = eVar;
        Boolean bool = Boolean.FALSE;
        e12.e<Boolean> eVar2 = new e12.e<>(bool);
        this._shouldShowBizBottomBar = eVar2;
        e12.e<Boolean> eVar3 = new e12.e<>(bool);
        this._aioPanelOrKeyboardShowState = eVar3;
        this._aioPanelOrKeyboardRealShow = new e12.e<>(bool);
        MutableLiveData<GuildAIOInputEditText> mutableLiveData = new MutableLiveData<>();
        this._draftEvent = mutableLiveData;
        cn<a> cnVar = new cn<>();
        this._aioNotifyUiEvent = cnVar;
        this.aioMsgUiIsOpened = true;
        this.aioNotifyUiEvent = cnVar;
        this.aioUiState = eVar;
        this.shouldShowBizBottomBar = eVar2;
        this.aioPanelOrKeyboardShowState = eVar3;
        this.draftValue = mutableLiveData;
    }

    private final MediaGuidanceConfig.b S1() {
        return MediaGuidanceConfig.INSTANCE.a();
    }

    private final void U1(b.f intent) {
        String str;
        int i3 = b.f227802a[intent.getAudioQueueState().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    str = "\u4f60\u5df2\u4e0b\u9ea6";
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                str = "\u4f60\u5df2\u9000\u51fa\u6392\u9ea6\u961f\u5217";
            }
        } else {
            str = "\u4f60\u5df2\u52a0\u5165\u6392\u9ea6\u961f\u5217";
        }
        String str2 = str;
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            GuildMediaLocalCombineStyleItemManager.l(guildMediaLocalCombineStyleItemManager, Integer.valueOf(R.drawable.guild_media_notify), str2, null, null, 0, 28, null);
        }
    }

    private final void d2(b.i intent) {
        if (intent.getIsMicEnable()) {
            GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
            if (guildMediaLocalCombineStyleItemManager != null) {
                Integer valueOf = Integer.valueOf(R.drawable.guild_media_aio_open_mic);
                String string = BaseApplication.getContext().getString(R.string.f140200db);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ing.guild_audio_open_mic)");
                GuildMediaLocalCombineStyleItemManager.l(guildMediaLocalCombineStyleItemManager, valueOf, string, null, null, 0, 28, null);
                return;
            }
            return;
        }
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager2 = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager2 != null) {
            Integer valueOf2 = Integer.valueOf(R.drawable.guild_media_aio_close_mic);
            String string2 = BaseApplication.getContext().getString(R.string.f139970cp);
            Intrinsics.checkNotNullExpressionValue(string2, "getContext().getString(R\u2026ng.guild_audio_close_mic)");
            GuildMediaLocalCombineStyleItemManager.l(guildMediaLocalCombineStyleItemManager2, valueOf2, string2, null, null, 0, 28, null);
        }
    }

    private final boolean e2() {
        ArrayList<IGProTopMsg> arrayList;
        boolean z16;
        int i3;
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (channelInfo != null) {
            arrayList = channelInfo.getTopMsgList();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Logger.f235387a.d().i("QGMC.GuildMediaAioViewModel", 1, "handleShowAnnounceGuideTips, hasAnnounce.");
            return false;
        }
        if (!((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGuildOrChannelManager(com.tencent.mobileqq.guild.media.core.j.c().r(), com.tencent.mobileqq.guild.media.core.j.c().e())) {
            Logger.f235387a.d().i("QGMC.GuildMediaAioViewModel", 1, "handleShowAnnounceGuideTips, is not manager.");
            return false;
        }
        int N = bw.f235485a.N();
        MediaGuidanceConfig.NavConfigData navConfigData = S1().getNavConfigData();
        JSONArray timesLimit = navConfigData.getTimesLimit();
        if (timesLimit != null) {
            i3 = timesLimit.getInt(0);
        } else {
            i3 = 0;
        }
        if (N < i3) {
            BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.guild.media.core.j.b(), null, null, new GuildMediaAioViewModel$handleShowAnnounceGuideTips$3(navConfigData, this, N, null), 3, null);
            return true;
        }
        return false;
    }

    private final void f2(b.p intent) {
        String str;
        int i3;
        int newSpeakModel = intent.getNewSpeakModel();
        if (newSpeakModel != 1) {
            if (newSpeakModel != 2) {
                if (newSpeakModel != 3) {
                    if (newSpeakModel != 4) {
                        return;
                    } else {
                        str = "\u5b50\u9891\u9053\u5df2\u5207\u6362\u4e3a\u4e3e\u624b\u53d1\u8a00\u6a21\u5f0f";
                    }
                } else if (com.tencent.mobileqq.guild.media.core.j.a().d0().m1()) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    str = String.format("\u5e94\u7528\u8fd0\u884c\u671f\u95f4\uff0c\u9ea6\u4f4d\u533a\u4e0a\u9ea6\u89c4\u5219\u7531 %s \u63a7\u5236", Arrays.copyOf(new Object[]{com.tencent.mobileqq.guild.media.core.j.a().d0().D1()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                } else {
                    return;
                }
            } else {
                str = "\u5b50\u9891\u9053\u5df2\u5207\u6362\u4e3a\u9ea6\u5e8f\u53d1\u8a00\u6a21\u5f0f";
            }
        } else {
            str = "\u5b50\u9891\u9053\u5df2\u5207\u6362\u4e3a\u81ea\u7531\u53d1\u8a00\u6a21\u5f0f";
        }
        String str2 = str;
        if (intent.getNewSpeakModel() == 3) {
            i3 = R.drawable.guild_media_aio_open_mic;
        } else {
            i3 = R.drawable.guild_media_notify;
        }
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            GuildMediaLocalCombineStyleItemManager.l(guildMediaLocalCombineStyleItemManager, Integer.valueOf(i3), str2, null, null, 0, 28, null);
        }
    }

    private final void j2(a event) {
        this._aioNotifyUiEvent.setValue(event);
    }

    private final void n2() {
        boolean z16;
        this._aioPanelOrKeyboardShowState.setValue(Boolean.valueOf(this.aioIsPanelOrKeyBoardShow));
        if (!this.aioMsgUiIsOpened) {
            this._shouldShowBizBottomBar.setValue(Boolean.TRUE);
            return;
        }
        e12.e<Boolean> eVar = this._shouldShowBizBottomBar;
        if (!this.aioInputBarShow && !this.aioMultiSelectShow) {
            z16 = true;
        } else {
            z16 = false;
        }
        eVar.setValue(Boolean.valueOf(z16));
    }

    public final boolean L1() {
        if (this.aioUiState.getValue() != AioUiState.HIDE) {
            return true;
        }
        return false;
    }

    public final void M1() {
        if (e2()) {
            return;
        }
        MediaGuidanceConfig.NavConfigData navConfigData = S1().getNavConfigData();
        if (com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a.size() >= navConfigData.getEffectiveCondition()) {
            l2(new b.d(navConfigData.getIconUrl(), navConfigData.getActiveTips(), navConfigData.getBtnMsg(), String.valueOf(navConfigData.getOpenIndex())));
            QLog.d("QGMC.GuildMediaAioViewModel", 1, "doNeedShowNavTips");
            bw.C1(bw.f235485a, null, 1, null);
        }
    }

    @NotNull
    public final LiveData<a> N1() {
        return this.aioNotifyUiEvent;
    }

    @NotNull
    public final LiveData<Boolean> O1() {
        return this.aioPanelOrKeyboardShowState;
    }

    @NotNull
    public final LiveData<AioUiState> P1() {
        return this.aioUiState;
    }

    @Nullable
    /* renamed from: Q1, reason: from getter */
    public final GuildMediaLocalCombineStyleItemManager getCombineTipsManager() {
        return this.combineTipsManager;
    }

    @NotNull
    public final LiveData<GuildAIOInputEditText> R1() {
        return this.draftValue;
    }

    @NotNull
    public final LiveData<Boolean> T1() {
        return this.shouldShowBizBottomBar;
    }

    public final void W1(@NotNull IGProSendGiftEventData giftAnimData) {
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            guildMediaLocalCombineStyleItemManager.n(giftAnimData);
        }
    }

    public final void X1() {
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            guildMediaLocalCombineStyleItemManager.o();
        }
    }

    public final void Z1() {
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            guildMediaLocalCombineStyleItemManager.p();
        }
    }

    public final void a2(@NotNull IGProSendGiftEventData giftAnimData) {
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            guildMediaLocalCombineStyleItemManager.q(giftAnimData);
        }
    }

    public final void b2(@NotNull IGProSendGiftEventData giftAnimData) {
        Intrinsics.checkNotNullParameter(giftAnimData, "giftAnimData");
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            guildMediaLocalCombineStyleItemManager.r(giftAnimData);
        }
    }

    public final void c2(@NotNull NotifyGiftRankChanged event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
        if (guildMediaLocalCombineStyleItemManager != null) {
            guildMediaLocalCombineStyleItemManager.s(event);
        }
    }

    public final boolean g2() {
        Boolean value = this._aioPanelOrKeyboardRealShow.getValue();
        Intrinsics.checkNotNull(value);
        return value.booleanValue();
    }

    public final boolean h2(float x16, float y16) {
        boolean z16;
        if (this.aioUiState.getValue() == AioUiState.HIDE) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if (y16 > this.aioCurrentPaddingTop && x16 > 80.0f) {
            return true;
        }
        return false;
    }

    public final boolean i2() {
        return com.tencent.mobileqq.guild.util.security.f.f235633d.c(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()));
    }

    public final boolean k2() {
        us0.b bVar = this.aioCtrl;
        if (bVar != null) {
            return bVar.onBackPressed();
        }
        return false;
    }

    public final void l2(@NotNull com.tencent.mobileqq.guild.media.aio.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.j) {
            this.aioCtrl = ((b.j) intent).getAioCtrl();
            this.combineTipsManager = new GuildMediaLocalCombineStyleItemManager(this.aioCtrl);
            return;
        }
        if (intent instanceof b.v) {
            this._aioUiState.setValue(((b.v) intent).getState());
            return;
        }
        if (intent instanceof b.k) {
            j2(new a.C7830a(((b.k) intent).getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String()));
            return;
        }
        if (intent instanceof b.o) {
            us0.b bVar = this.aioCtrl;
            if (bVar != null) {
                bVar.f();
                return;
            }
            return;
        }
        if (intent instanceof b.n) {
            us0.b bVar2 = this.aioCtrl;
            if (bVar2 != null) {
                bVar2.g();
                return;
            }
            return;
        }
        if (intent instanceof b.h) {
            us0.b bVar3 = this.aioCtrl;
            if (bVar3 != null) {
                bVar3.d(((b.h) intent).getClearContent());
                return;
            }
            return;
        }
        if (intent instanceof b.t) {
            b.t tVar = (b.t) intent;
            this.aioIsPanelOrKeyBoardShow = tVar.getIsPanelOrKeyBoardShow();
            this.aioInputBarShow = tVar.getIsAioInputBarShow();
            n2();
            return;
        }
        if (intent instanceof b.u) {
            this._aioPanelOrKeyboardRealShow.setValue(Boolean.valueOf(((b.u) intent).getIsPanelOrKeyBoardShow()));
            return;
        }
        if (intent instanceof b.g) {
            this._draftEvent.setValue(((b.g) intent).getTv());
            return;
        }
        if (intent instanceof b.r) {
            this.aioMultiSelectShow = ((b.r) intent).getIsSelectMode();
            n2();
            return;
        }
        if (intent instanceof b.s) {
            this.aioCurrentPaddingTop = ((b.s) intent).getCom.tencent.mtt.hippy.dom.node.NodeProps.PADDING_TOP java.lang.String();
            return;
        }
        if (intent instanceof b.c) {
            GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager = this.combineTipsManager;
            if (guildMediaLocalCombineStyleItemManager != null) {
                b.c cVar = (b.c) intent;
                GuildMediaLocalCombineStyleItemManager.l(guildMediaLocalCombineStyleItemManager, cVar.getIconRes(), cVar.getMsg(), cVar.getPreSuffix(), cVar.getBgRes(), 0, 16, null);
                return;
            }
            return;
        }
        if (intent instanceof b.a) {
            us0.b bVar4 = this.aioCtrl;
            if (bVar4 != null) {
                bVar4.b();
                return;
            }
            return;
        }
        if (intent instanceof b.d) {
            GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager2 = this.combineTipsManager;
            if (guildMediaLocalCombineStyleItemManager2 != null) {
                b.d dVar = (b.d) intent;
                guildMediaLocalCombineStyleItemManager2.h(dVar.getIconString(), dVar.getActiveMsg(), dVar.getBtnMsg(), dVar.getOpenIndex());
                return;
            }
            return;
        }
        if (intent instanceof b.C7831b) {
            GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager3 = this.combineTipsManager;
            if (guildMediaLocalCombineStyleItemManager3 != null) {
                b.C7831b c7831b = (b.C7831b) intent;
                guildMediaLocalCombineStyleItemManager3.g(c7831b.getGuildId(), c7831b.getTinyId(), c7831b.getNickName(), c7831b.getTipsContent(), c7831b.getBtnMsg());
                return;
            }
            return;
        }
        if (intent instanceof b.e) {
            GuildMediaLocalCombineStyleItemManager guildMediaLocalCombineStyleItemManager4 = this.combineTipsManager;
            if (guildMediaLocalCombineStyleItemManager4 != null) {
                guildMediaLocalCombineStyleItemManager4.t(((b.e) intent).a());
                return;
            }
            return;
        }
        if (intent instanceof b.q) {
            this.aioMsgUiIsOpened = ((b.q) intent).getOpened();
            n2();
            us0.b bVar5 = this.aioCtrl;
            if (bVar5 != null) {
                bVar5.e(Intrinsics.areEqual(this._shouldShowBizBottomBar.getValue(), Boolean.FALSE));
                return;
            }
            return;
        }
        if (intent instanceof b.p) {
            f2((b.p) intent);
            return;
        }
        if (intent instanceof b.l) {
            j2(a.b.f227835a);
            return;
        }
        if (intent instanceof b.m) {
            j2(a.c.f227836a);
        } else if (intent instanceof b.f) {
            U1((b.f) intent);
        } else if (intent instanceof b.i) {
            d2((b.i) intent);
        }
    }

    public final void m2(@NotNull MediaShareLoadInfo shareInfo) {
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        shareInfo.i(new Function3<Boolean, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel$showShareMediaLoadInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, String str) {
                invoke(bool.booleanValue(), bool2.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, boolean z17, @NotNull String tips) {
                Intrinsics.checkNotNullParameter(tips, "tips");
                Logger.f235387a.d().d("QGMC.GuildMediaAioViewModel", 1, "[showShareMediaLoadInfo] showAioTips " + z16 + ", showToast " + z17 + ", tips " + tips);
                if (z16) {
                    if (tips.length() > 0) {
                        GuildMediaLocalCombineStyleItemManager combineTipsManager = GuildMediaAioViewModel.this.getCombineTipsManager();
                        if (combineTipsManager != null) {
                            combineTipsManager.y(tips);
                            return;
                        }
                        return;
                    }
                }
                if (z17) {
                    QQToastUtil.showQQToast(0, tips);
                }
            }
        });
    }

    public final void o2() {
        String string;
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        if (MediaChannelUtils.o(mediaChannelUtils, null, 1, null) == 4 && !com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f()) {
            QLog.d("QGMC.GuildMediaAioViewModel", 1, "\u4e3e\u624b\u6a21\u5f0f\u4e0b \u65e0\u7ba1\u7406\u5458\u4e0d\u5c55\u793atips");
            return;
        }
        if (((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).checkHasAlreadyDoRequest() == ((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).getNONE()) {
            int n3 = mediaChannelUtils.n(com.tencent.mobileqq.guild.media.core.j.c().e());
            if (n3 != 2) {
                if (n3 != 4) {
                    string = BaseApplication.getContext().getString(R.string.f140340dp);
                } else {
                    string = BaseApplication.getContext().getString(R.string.f140420dx);
                }
            } else {
                string = BaseApplication.getContext().getString(R.string.f1495712n);
            }
            String str = string;
            Intrinsics.checkNotNullExpressionValue(str, "when(MediaChannelUtils.g\u2026og_confirm)\n            }");
            MediaGuidanceConfig.NavConfigData inviteOpenMicTipsConfigData = S1().getInviteOpenMicTipsConfigData();
            String str2 = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().P;
            Intrinsics.checkNotNullExpressionValue(str2, "getDataHub().selfUserInfo.guildId");
            String str3 = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str3, "getDataHub().selfUserInfo.id");
            String str4 = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228094b;
            Intrinsics.checkNotNullExpressionValue(str4, "getDataHub().selfUserInfo.name");
            l2(new b.C7831b(str2, str3, str4, inviteOpenMicTipsConfigData.getActiveTips(), str));
            QLog.d("QGMC.GuildMediaAioViewModel", 1, "updateOpenMicTips");
            bw.p1(bw.f235485a, null, 1, null);
            MediaChannelCore.INSTANCE.a().o0().s().setValue(Boolean.FALSE);
        }
    }
}
