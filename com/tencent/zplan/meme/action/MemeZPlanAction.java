package com.tencent.zplan.meme.action;

import androidx.annotation.Keep;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.model.MemeRecordUserInfo;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.meme.recorder.a;
import com.tencent.zplan.record.recorder.MemeZPlanSingleRecorder;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wx4.PrepareAssetsStatistic;
import yx4.b;
import yx4.c;

@Keep
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 H2\u00020\u0001:\u0001HB\u0093\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010*\u001a\u00020\u000e\u0012\u0006\u0010,\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u000200\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bB\u0010CB9\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010*\u001a\u00020\u000e\u0012\u0006\u0010,\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010D\u001a\u00020\u0002\u00a2\u0006\u0004\bB\u0010EBA\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010*\u001a\u00020\u000e\u0012\u0006\u0010,\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010D\u001a\u00020\u0002\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bB\u0010FBA\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010*\u001a\u00020\u000e\u0012\u0006\u0010,\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010D\u001a\u00020\u0002\u0012\u0006\u00105\u001a\u00020\u0002\u00a2\u0006\u0004\bB\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J!\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016R\u001a\u0010#\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b)\u0010&R\u0017\u0010*\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&R\u001a\u0010,\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b,\u0010$\u001a\u0004\b-\u0010&R\u001a\u0010.\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&R\u001a\u00101\u001a\u0002008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b5\u0010(\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010(\u00a8\u0006I"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "", "getIdDesc", "", "Lcom/tencent/zplan/meme/action/MemeAction$Cache;", "getCachedFiles", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "Lkotlin/Pair;", "", "saveCacheFiles", "saveCoverCacheFiles", "genRecordKey", "", "portraitId", "getSingleActionKey", "success", "", "markOneRecordDone", "(Ljava/lang/Integer;Z)V", "batchCount", "isBatch", "id", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "toMemeRecordParams", "Lorg/json/JSONObject;", "toPreDownloadParams", "Lcom/tencent/zplan/meme/c;", "listener", "checkResource", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "getRecorderClazz", "actionId", "I", "getActionId", "()I", "portraitConfig", "Ljava/lang/String;", "getPortraitId", "frameCount", "getFrameCount", "width", "getWidth", "height", "getHeight", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/action/MODE;", "getMode", "()Lcom/tencent/zplan/meme/action/MODE;", "name", "getName", "()Ljava/lang/String;", QQBrowserActivity.APP_PARAM, "sender", "receiver", "Lcom/tencent/zplan/common/model/AppTheme;", "theme", "senderGender", "receiverGender", "Lcom/tencent/zplan/meme/model/a;", "senderAvatarCharacterInfo", "receiverAvatarCharacterInfo", "<init>", "(IIIILcom/tencent/zplan/meme/action/MODE;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/common/model/AppTheme;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/zplan/meme/model/a;Lcom/tencent/zplan/meme/model/a;Ljava/lang/String;)V", "uin", "(IIIILcom/tencent/zplan/meme/action/MODE;Ljava/lang/String;)V", "(IIIILcom/tencent/zplan/meme/action/MODE;Ljava/lang/String;Lcom/tencent/zplan/meme/model/a;)V", "(IIIILcom/tencent/zplan/meme/action/MODE;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public class MemeZPlanAction extends MemeZPlanBaseAction {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT_PREDOWNLOAD_PARALLELNUM = 6;

    @NotNull
    public static final String TAG = "[zplan][MemePlayer-Action][MemeZPlanAction]";
    public static final int UE_RECORD_FRAME_RATE = 120;
    private static final Lazy assetsProxy$delegate;

    @Nullable
    private static final Lazy defaultRecorder$delegate;
    private static final Lazy globalEnableRecordWithUserData$delegate;
    private static final Lazy memeProxy$delegate;
    private final int actionId;
    private final String extraParams;
    private final int frameCount;
    private final int height;

    @NotNull
    private final MODE mode;

    @NotNull
    private final String name;
    private String portraitConfig;
    private final int portraitId;
    private final int width;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeZPlanAction$Companion;", "", "Lyx4/b;", "assetsProxy$delegate", "Lkotlin/Lazy;", "getAssetsProxy", "()Lyx4/b;", "assetsProxy", "Lyx4/c;", "memeProxy$delegate", "getMemeProxy", "()Lyx4/c;", "memeProxy", "", "globalEnableRecordWithUserData$delegate", "getGlobalEnableRecordWithUserData", "()Z", "globalEnableRecordWithUserData", "Ljava/lang/Class;", "Lcom/tencent/zplan/meme/recorder/a;", "defaultRecorder$delegate", "getDefaultRecorder", "()Ljava/lang/Class;", "defaultRecorder", "", "DEFAULT_PREDOWNLOAD_PARALLELNUM", "I", "", "TAG", "Ljava/lang/String;", "UE_RECORD_FRAME_RATE", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b getAssetsProxy() {
            return (b) MemeZPlanAction.assetsProxy$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getGlobalEnableRecordWithUserData() {
            return ((Boolean) MemeZPlanAction.globalEnableRecordWithUserData$delegate.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c getMemeProxy() {
            return (c) MemeZPlanAction.memeProxy$delegate.getValue();
        }

        @Nullable
        public final Class<a> getDefaultRecorder() {
            return (Class) MemeZPlanAction.defaultRecorder$delegate.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.zplan.meme.action.MemeZPlanAction$Companion$assetsProxy$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final b invoke() {
                return (b) mx4.a.f417748a.a(b.class);
            }
        });
        assetsProxy$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.zplan.meme.action.MemeZPlanAction$Companion$memeProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                Object a16 = mx4.a.f417748a.a(c.class);
                Intrinsics.checkNotNull(a16);
                return (c) a16;
            }
        });
        memeProxy$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.zplan.meme.action.MemeZPlanAction$Companion$globalEnableRecordWithUserData$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                c memeProxy;
                memeProxy = MemeZPlanAction.INSTANCE.getMemeProxy();
                return memeProxy.k();
            }
        });
        globalEnableRecordWithUserData$delegate = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Class<a>>() { // from class: com.tencent.zplan.meme.action.MemeZPlanAction$Companion$defaultRecorder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Class<a> invoke() {
                try {
                    MemeZPlanSingleRecorder.b bVar = MemeZPlanSingleRecorder.Util;
                    return MemeZPlanSingleRecorder.class;
                } catch (Throwable unused) {
                    d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        d.a.b(a16, MemeZPlanAction.TAG, 1, "cant found default recorder for single record", null, 8, null);
                    }
                    return null;
                }
            }
        });
        defaultRecorder$delegate = lazy4;
    }

    public /* synthetic */ MemeZPlanAction(int i3, int i16, int i17, int i18, MODE mode, String str, String str2, String str3, AppTheme appTheme, Integer num, Integer num2, AvatarCharacterInfo avatarCharacterInfo, AvatarCharacterInfo avatarCharacterInfo2, String str4, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, mode, (i19 & 32) != 0 ? "" : str, (i19 & 64) != 0 ? null : str2, str3, (i19 & 256) != 0 ? AppTheme.DAY : appTheme, (i19 & 512) != 0 ? null : num, (i19 & 1024) != 0 ? null : num2, (i19 & 2048) != 0 ? null : avatarCharacterInfo, (i19 & 4096) != 0 ? null : avatarCharacterInfo2, (i19 & 8192) != 0 ? null : str4);
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int batchCount() {
        return 1;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean checkResource(@NotNull final com.tencent.zplan.meme.c listener) {
        boolean k3;
        boolean k16;
        boolean z16;
        List<MemeRecordUserInfo> listOf;
        List<String> listOf2;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Companion companion = INSTANCE;
        b assetsProxy = companion.getAssetsProxy();
        if (assetsProxy == null) {
            return true;
        }
        if (getConfig().getTargetEngine() instanceof EngineType.Filament) {
            k3 = getSenderInfo().j();
        } else {
            k3 = getSenderInfo().k();
        }
        if (getConfig().getTargetEngine() instanceof EngineType.Filament) {
            k16 = getReceiverInfo$record_debug().j();
        } else {
            k16 = getReceiverInfo$record_debug().k();
        }
        if (getConfig().getStickerData().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!k3 && !k16 && !z16) {
            return true;
        }
        if (getConfig().getEnableUserData() == null) {
            getConfig().A(Boolean.valueOf(companion.getGlobalEnableRecordWithUserData()));
        }
        if (getSenderInfo().getAvatarCharacter() != null || getReceiverInfo$record_debug().getAvatarCharacter() != null) {
            getConfig().A(Boolean.TRUE);
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MemeRecordUserInfo[]{getSenderInfo(), getReceiverInfo$record_debug()});
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(this.portraitId));
        assetsProxy.a(listOf, listOf2, this, new yx4.a() { // from class: com.tencent.zplan.meme.action.MemeZPlanAction$checkResource$1
            private final void fillCharacterInfo(MemeRecordUserInfo recordUserInfo, Map<String, AvatarCharacterInfo> avatarCharacters) {
                boolean z17;
                AvatarCharacterInfo avatarCharacterInfo;
                String uin = recordUserInfo.getUin();
                if (uin != null && uin.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17 && avatarCharacters != null && (avatarCharacterInfo = avatarCharacters.get(uin)) != null) {
                    if (Intrinsics.areEqual(MemeZPlanAction.this.getConfig().getEnableUserData(), Boolean.TRUE) && recordUserInfo.getAvatarCharacter() == null) {
                        recordUserInfo.l(avatarCharacterInfo);
                    }
                    recordUserInfo.m(true);
                }
            }

            @Override // yx4.a
            public void onFail(int errorCode, @Nullable String errorMessage) {
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, MemeZPlanAction.TAG, 1, MemeZPlanAction.this.getDesc() + " downloadRecordResource error, errorCode:" + errorCode + ", errorMessage:" + errorMessage, null, 8, null);
                }
                MemeZPlanAction.this.getSenderInfo().m(false);
                MemeZPlanAction.this.getReceiverInfo$record_debug().m(false);
                listener.onResult(errorCode);
            }

            @Override // yx4.a
            public void onSuccess(@Nullable Map<String, AvatarCharacterInfo> avatarCharacters, @Nullable List<jx4.b> stickerConfigList, @NotNull PrepareAssetsStatistic assetsStatistic) {
                String str;
                Object obj;
                boolean z17;
                Intrinsics.checkNotNullParameter(assetsStatistic, "assetsStatistic");
                fillCharacterInfo(MemeZPlanAction.this.getSenderInfo(), avatarCharacters);
                fillCharacterInfo(MemeZPlanAction.this.getReceiverInfo$record_debug(), avatarCharacters);
                MemeZPlanAction.this.getStatistic().q(assetsStatistic);
                MemeZPlanAction memeZPlanAction = MemeZPlanAction.this;
                int i3 = 0;
                String str2 = null;
                if (stickerConfigList != null) {
                    Iterator<T> it = stickerConfigList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (((jx4.b) obj).f411139a == MemeZPlanAction.this.getPortraitId()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    jx4.b bVar = (jx4.b) obj;
                    if (bVar != null) {
                        str2 = bVar.f411140b;
                    }
                }
                memeZPlanAction.portraitConfig = str2;
                str = MemeZPlanAction.this.portraitConfig;
                if (str == null) {
                    i3 = -13431;
                }
                listener.onResult(i3);
            }
        });
        return false;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean clearCache(int id5) {
        String str;
        boolean z16;
        File o16 = Meme.f385754h.o(getKey());
        if (o16 != null) {
            str = o16.getAbsolutePath();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, TAG, 1, getDesc() + " no need to clean, cachePath empty.", null, 8, null);
            }
            return true;
        }
        try {
            com.tencent.zplan.common.utils.c cVar = com.tencent.zplan.common.utils.c.f385288a;
            if (!cVar.h(str)) {
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.b(a17, TAG, 1, getDesc() + " no need to clean, file: " + str + " does not exist.", null, 8, null);
                }
                return true;
            }
            cVar.e(str);
            d a18 = LogUtil.f385285b.a();
            if (a18 != null) {
                d.a.c(a18, TAG, 1, getDesc() + " clear cache success, cachePath: " + str, null, 8, null);
            }
            return true;
        } catch (Throwable th5) {
            d a19 = LogUtil.f385285b.a();
            if (a19 != null) {
                a19.e(TAG, 1, getDesc() + " clear cache error", th5);
            }
            return false;
        }
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanBaseAction
    @NotNull
    public String genRecordKey() {
        return super.genRecordKey() + util.base64_pad_url + this.portraitId;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int getActionId() {
        return this.actionId;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @Nullable
    public List<MemeAction.Cache> getCachedFiles() {
        List<MemeAction.Cache> listOf;
        Meme meme = Meme.f385754h;
        File o16 = meme.o(getKey());
        if (o16 == null) {
            return null;
        }
        MemeResult memeResult = new MemeResult(this, getKey(), o16.getAbsolutePath());
        if (getConfig().getMp4Config().getCover().getSaveCover()) {
            MemeResult.Cover t16 = meme.t(getKey());
            if (t16 == null) {
                return null;
            }
            memeResult.l(t16);
        }
        if (getConfig().getSaveEachFrame2File()) {
            memeResult.m(meme.u(this, getKey()));
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new MemeAction.Cache(getActionId(), memeResult));
        return listOf;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int getHeight() {
        return this.height;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getIdDesc() {
        return "id:" + getActionId();
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanBaseAction, com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public MODE getMode() {
        return this.mode;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getName() {
        return this.name;
    }

    public final int getPortraitId() {
        return this.portraitId;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @Nullable
    public Class<a> getRecorderClazz() {
        Class<a> recorderClazz = super.getRecorderClazz();
        if (recorderClazz == null) {
            return INSTANCE.getDefaultRecorder();
        }
        return recorderClazz;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getSingleActionKey(int portraitId) {
        return getKey();
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public int getWidth() {
        return this.width;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean isBatch() {
        return false;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public void markOneRecordDone(@Nullable Integer portraitId, boolean success) {
        int actionId = getActionId();
        if (portraitId != null && portraitId.intValue() == actionId) {
            setRecordDoneCount(batchCount());
        }
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public Pair<Boolean, MemeResult> saveCacheFiles(@NotNull MemeResult result) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        String recordPath = result.getRecordPath();
        String recordKey = result.getRecordKey();
        Meme meme = Meme.f385754h;
        String str2 = null;
        if (!meme.D(recordPath, recordKey)) {
            return new Pair<>(Boolean.FALSE, new MemeResult(this, recordKey, null));
        }
        File o16 = meme.o(recordKey);
        if (o16 != null) {
            str = o16.getAbsolutePath();
        } else {
            str = null;
        }
        boolean h16 = com.tencent.zplan.common.utils.c.f385288a.h(str);
        Boolean valueOf = Boolean.valueOf(h16);
        if (h16) {
            str2 = str;
        }
        MemeResult memeResult = new MemeResult(this, recordKey, str2);
        if (h16) {
            memeResult.m(result.f());
            memeResult.l(result.getCover());
        }
        Unit unit = Unit.INSTANCE;
        return new Pair<>(valueOf, memeResult);
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public Pair<Boolean, MemeResult> saveCoverCacheFiles(@NotNull MemeResult result) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        String recordKey = result.getRecordKey();
        MemeResult.Cover cover = result.getCover();
        String str2 = null;
        if (cover != null) {
            Meme meme = Meme.f385754h;
            if (!meme.D(cover.getPath(), cover.getKey())) {
                return new Pair<>(Boolean.FALSE, new MemeResult(this, recordKey, null));
            }
            File o16 = meme.o(cover.getKey());
            if (o16 != null) {
                str = o16.getAbsolutePath();
            } else {
                str = null;
            }
            boolean h16 = com.tencent.zplan.common.utils.c.f385288a.h(str);
            Boolean valueOf = Boolean.valueOf(h16);
            MemeResult memeResult = new MemeResult(this, recordKey, null);
            if (h16) {
                memeResult.m(result.f());
                if (h16) {
                    str2 = str;
                }
                memeResult.l(new MemeResult.Cover(str2, cover.getKey()));
            }
            Unit unit = Unit.INSTANCE;
            return new Pair<>(valueOf, memeResult);
        }
        return new Pair<>(Boolean.FALSE, new MemeResult(this, recordKey, null));
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanBaseAction
    @NotNull
    public MemeRecordParams toMemeRecordParams() {
        BusinessConfig a16;
        boolean z16;
        d a17;
        d a18;
        a16 = r1.a((r35 & 1) != 0 ? r1.backgroundColor : 0, (r35 & 2) != 0 ? r1.flipVertical : false, (r35 & 4) != 0 ? r1.saveEachFrame2File : false, (r35 & 8) != 0 ? r1.callbackEachFrameData : false, (r35 & 16) != 0 ? r1.frameType : null, (r35 & 32) != 0 ? r1.maxFrameCount : 0, (r35 & 64) != 0 ? r1.optimization : null, (r35 & 128) != 0 ? r1.camera : null, (r35 & 256) != 0 ? r1.aaType : null, (r35 & 512) != 0 ? r1.aaLevel : null, (r35 & 1024) != 0 ? r1.mp4Config : null, (r35 & 2048) != 0 ? r1.skipHotPatch : null, (r35 & 4096) != 0 ? r1.stickerData : null, (r35 & 8192) != 0 ? r1.useRecordV2 : false, (r35 & 16384) != 0 ? r1.enableUserData : null, (r35 & 32768) != 0 ? r1.actionStyle : 0, (r35 & 65536) != 0 ? getConfig().disableGlassesMetallic : null);
        String str = this.portraitConfig;
        if (str != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(String.valueOf(getActionId()), str);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "wrapper.toString()");
            a16.F(jSONObject2);
            d a19 = LogUtil.f385285b.a();
            if (a19 != null) {
                d.a.c(a19, TAG, 1, "toMemeRecordParams " + getDesc() + " use stickerConfig from downloader callback", null, 8, null);
            }
        } else {
            String stickerData = a16.getStickerData();
            if (stickerData != null && stickerData.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 && (a17 = LogUtil.f385285b.a()) != null) {
                d.a.d(a17, TAG, 1, "toMemeRecordParams " + getDesc() + " stickerConfig null!!", null, 8, null);
            }
        }
        if (getMode() == MODE.MP4 && (a18 = LogUtil.f385285b.a()) != null) {
            d.a.d(a18, TAG, 1, "toMemeRecordParams, actionId:" + getActionId() + ", actionStyle:" + a16.getActionStyle(), null, 8, null);
        }
        return new MemeRecordParams(getKey(), getActionId(), getTaskId(), getSenderInfo().n(), getReceiverInfo$record_debug().n(), getFrameRate(), this.frameCount, getWidth(), getHeight(), getMode(), null, AppTheme.INSTANCE.b(getTheme()), false, a16, "N2L_RecordAction", 0, this.extraParams, 37888, null);
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanBaseAction
    @NotNull
    public List<JSONObject> toPreDownloadParams() {
        int i3;
        List<JSONObject> listOf;
        c cVar = (c) mx4.a.f417748a.a(c.class);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("actionId", getActionId());
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, getTaskId());
        jSONObject.put("frameCount", getMode().toFrameCount());
        if (cVar != null) {
            i3 = cVar.c();
        } else {
            i3 = 6;
        }
        jSONObject.put("parallelNum", i3);
        jSONObject.put("senderGender", getSenderInfo().get_gender());
        jSONObject.put("receiverGender", getReceiverInfo$record_debug().get_gender());
        listOf = CollectionsKt__CollectionsJVMKt.listOf(jSONObject);
        return listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeZPlanAction(int i3, int i16, int i17, int i18, @NotNull MODE mode, @NotNull String sender, @Nullable String str, @NotNull String name, @NotNull AppTheme theme, @Nullable Integer num, @Nullable Integer num2, @Nullable AvatarCharacterInfo avatarCharacterInfo, @Nullable AvatarCharacterInfo avatarCharacterInfo2, @Nullable String str2) {
        super(sender, str, mode, theme, num, num2, avatarCharacterInfo, avatarCharacterInfo2);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.portraitId = i3;
        this.frameCount = i16;
        this.width = i17;
        this.height = i18;
        this.mode = mode;
        this.name = name;
        this.extraParams = str2;
        this.actionId = i3;
        getConfig().B(false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemeZPlanAction(int i3, int i16, int i17, int i18, @NotNull MODE mode, @NotNull String uin) {
        this(i3, i16, i17, i18, mode, uin, null, String.valueOf(i3), null, null, null, null, null, null, 16128, null);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(uin, "uin");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemeZPlanAction(int i3, int i16, int i17, int i18, @NotNull MODE mode, @NotNull String uin, @NotNull AvatarCharacterInfo senderAvatarCharacterInfo) {
        this(i3, i16, i17, i18, mode, uin, null, String.valueOf(i3), null, null, null, senderAvatarCharacterInfo, null, null, 14080, null);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(senderAvatarCharacterInfo, "senderAvatarCharacterInfo");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemeZPlanAction(int i3, int i16, int i17, int i18, @NotNull MODE mode, @NotNull String uin, @NotNull String name) {
        this(i3, i16, i17, i18, mode, uin, null, name, null, null, null, null, null, null, 16128, null);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
