package com.tencent.mobileqq.guild.media.core.logic;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaBusinessType;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.model.AudioQueueState;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.mobileqq.qqguildsdk.data.genc.fh;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.em;
import wh2.er;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0003mqu\u0018\u0000 \u007f2\u00020\u0001:\u0004\u0080\u0001\u0081\u0001B\u000f\u0012\u0006\u0010S\u001a\u00020P\u00a2\u0006\u0004\b}\u0010~J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000f\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J.\u0010\u0011\u001a\u00020\u00022\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J0\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J0\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J*\u0010\u001b\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\"\u001a\u00020!2\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020$H\u0002J\n\u0010'\u001a\u0004\u0018\u00010&H\u0002J\b\u0010(\u001a\u00020\u0002H\u0002J\b\u0010)\u001a\u00020\u0002H\u0002J\u001c\u0010+\u001a\u00020*2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010-\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u00100\u001a\u00020/H\u0002J\u001e\u00104\u001a\u00020*2\u0006\u00101\u001a\u00020\f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f02H\u0002J\f\u00106\u001a\b\u0012\u0004\u0012\u00020\f05J\u000e\u00108\u001a\u00020*2\u0006\u00107\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0002J\u0006\u0010:\u001a\u00020\u0002J\u000e\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u001cJ\u000e\u0010=\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u001cJU\u0010E\u001a\u00020\u00022M\b\u0002\u0010D\u001aG\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(B\u0012\u0013\u0012\u00110*\u00a2\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00020>J\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010G\u001a\u00020\u0002J\u000e\u0010H\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010I\u001a\u00020\u0002H\u0016J\b\u0010J\u001a\u00020\u0002H\u0016J\b\u0010K\u001a\u00020\u0002H\u0016J\b\u0010L\u001a\u00020\u0002H\u0016J\b\u0010M\u001a\u00020\u0002H\u0016J\b\u0010N\u001a\u00020\u0002H\u0016J\u0006\u0010O\u001a\u00020*R\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010Z\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010b\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\f058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\"\u0010l\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bz\u0010{\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper;", "Lcom/tencent/mobileqq/guild/media/core/d;", "", "L1", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAudioLiveUserListRsp;", "rspInfo", "H1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "micList", "Q1", "tinyId", "V0", "guildId", "channelId", "userList", "z1", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "x1", "U0", "y1", "w1", "", "J1", "I1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/o;", "Y0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fc;", "i1", "g1", "Luh2/b;", "b1", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "P1", "R1", "", "R0", "channelUin", Constants.APK_CERTIFICATE, "S0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper;", "h1", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "list", "X0", "", "d1", "userId", "T0", "A1", "C1", "id", "E1", "l1", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "retCode", "retMsg", "needToast", "callback", "r1", ICustomDataEditor.NUMBER_PARAM_1, "p1", "u1", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "K1", "O1", "E0", "u", "k1", "Lcom/tencent/mobileqq/guild/media/core/f;", "f", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", tl.h.F, "I", "c1", "()I", "setMMicQueueState", "(I)V", "mMicQueueState", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$MicSequenceState;", "i", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$MicSequenceState;", "f1", "()Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$MicSequenceState;", "setSelfMicSequenceState", "(Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$MicSequenceState;)V", "selfMicSequenceState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "micSequenceList", BdhLogUtil.LogTag.Tag_Conn, "Z", "e1", "()Z", "N1", "(Z)V", "selfHasEnQueue", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$g", "D", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$g;", "micSequencePermissionUpdateObserver", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$b", "E", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$b;", "audioQueueFinishListener", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$h", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$h;", "observer", "Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "O", "()Lcom/tencent/mobileqq/guild/media/core/MediaBusinessType;", "businessType", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "G", "a", "MicSequenceState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelMicSequenceHelper extends com.tencent.mobileqq.guild.media.core.d {

    /* renamed from: C */
    private boolean selfHasEnQueue;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final g micSequencePermissionUpdateObserver;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b audioQueueFinishListener;

    /* renamed from: F */
    @NotNull
    private final h observer;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: h */
    private int mMicQueueState;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private MicSequenceState selfMicSequenceState;

    /* renamed from: m */
    @NotNull
    private final List<IGProUserInfo> micSequenceList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$MicSequenceState;", "", "(Ljava/lang/String;I)V", "STATUS_ON_MIC", "STATUS_WAITTING", "STATUS_ENQUEUE", "STATUS_DEQUEUE", "USER_STATE_DISABLE", "STATUS_NONE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum MicSequenceState {
        STATUS_ON_MIC,
        STATUS_WAITTING,
        STATUS_ENQUEUE,
        STATUS_DEQUEUE,
        USER_STATE_DISABLE,
        STATUS_NONE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/a;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.a> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            String str = MediaChannelMicSequenceHelper.this.mediaChannelCore.getSelfUserInfo().f228093a;
            if (event.b() != null && event.b().contains(str)) {
                MediaChannelMicSequenceHelper.W0(MediaChannelMicSequenceHelper.this, null, str, 1, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$c", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.i {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "closeMic result: " + result + ", " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((IGProUserInfo) t17).getBusinessInfo().getSortKey()), Long.valueOf(((IGProUserInfo) t16).getBusinessInfo().getSortKey()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$e", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.i {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "setMicrophone,  result = " + result + ", errMsg = " + errMsg + " ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$f", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.i {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "setMicrophone,  result = " + result + ", errMsg = " + errMsg + " ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.bi> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.bi event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelMicSequenceHelper.this.R1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JV\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J4\u0010\u000f\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J>\u0010\u0010\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J:\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J:\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J6\u0010\u0016\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMicSequenceHelper$h", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "playerList", "viewerList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelUserNumInfo", "", "onAVUserInfoChangeNotifyForAll", "userList", "onEnterSpeakQueueNotifyForAll", "onUserWaitingToSpeakNotifyForAll", "onUserSpeakingNotifyForAll", "onUserAVStateResetNotifyForAll", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "onPushAVUserStateChange", "onUserLeaveListNotifyForAll", "channelUin", "onChannelInfoUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h extends GPServiceObserver {
        h() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAVUserInfoChangeNotifyForAll(@Nullable String guildId, @Nullable String channelId, @NotNull ArrayList<IGProUserInfo> playerList, @NotNull ArrayList<IGProUserInfo> viewerList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            Intrinsics.checkNotNullParameter(playerList, "playerList");
            Intrinsics.checkNotNullParameter(viewerList, "viewerList");
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onChannelInfoUpdated, channelUin = " + channelUin);
            if (Intrinsics.areEqual(channelUin, MediaChannelMicSequenceHelper.this.mediaChannelCore.E())) {
                MediaChannelMicSequenceHelper.this.P1();
                if (!MediaChannelMicSequenceHelper.this.G1(channelUin)) {
                    MediaChannelMicSequenceHelper.this.micSequenceList.clear();
                    MediaChannelMicSequenceHelper.this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bd());
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onEnterSpeakQueueNotifyForAll(@Nullable String guildId, @Nullable String channelId, @NotNull ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            Intrinsics.checkNotNullParameter(userList, "userList");
            if (MediaChannelMicSequenceHelper.this.G1(channelId)) {
                MediaChannelMicSequenceHelper.this.w1(guildId, channelId, userList);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushAVUserStateChange(@Nullable IGProAVUserStateChangeInfo userStateInfo) {
            String str;
            MediaChannelMicSequenceHelper mediaChannelMicSequenceHelper = MediaChannelMicSequenceHelper.this;
            if (userStateInfo != null) {
                str = userStateInfo.getChannelId();
            } else {
                str = null;
            }
            if (mediaChannelMicSequenceHelper.G1(str) && userStateInfo != null) {
                MediaChannelMicSequenceHelper.this.x1(userStateInfo);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserAVStateResetNotifyForAll(@NotNull String guildId, @NotNull String channelId, @NotNull ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(userList, "userList");
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onUserAVStateResetNotifyForAll: !!!");
            if (MediaChannelMicSequenceHelper.this.G1(channelId)) {
                MediaChannelMicSequenceHelper.this.y1(guildId, channelId, userList);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserLeaveListNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            Integer num;
            Logger.a d16 = Logger.f235387a.d();
            if (userList != null) {
                num = Integer.valueOf(userList.size());
            } else {
                num = null;
            }
            d16.d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onUserLeaveListNotifyForAll, channelUin = " + channelId + ", userList: " + num);
            if (MediaChannelMicSequenceHelper.this.R0(guildId, channelId) && MediaChannelMicSequenceHelper.this.G1(channelId) && userList != null) {
                MediaChannelMicSequenceHelper.W0(MediaChannelMicSequenceHelper.this, userList, null, 2, null);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserSpeakingNotifyForAll(@NotNull String guildId, @NotNull String channelId, @NotNull ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(userList, "userList");
            if (MediaChannelMicSequenceHelper.this.G1(channelId)) {
                MediaChannelMicSequenceHelper.this.z1(guildId, channelId, userList);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserWaitingToSpeakNotifyForAll(@Nullable String guildId, @Nullable String channelId, @NotNull ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            Intrinsics.checkNotNullParameter(userList, "userList");
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onUserWaitingToSpeakNotifyForAll, channelUin = " + channelId);
            if (MediaChannelMicSequenceHelper.this.G1(channelId)) {
                MediaChannelMicSequenceHelper mediaChannelMicSequenceHelper = MediaChannelMicSequenceHelper.this;
                for (IGProUserInfo iGProUserInfo : userList) {
                    Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onUserWaitingToSpeakNotifyForAll " + iGProUserInfo.getNickName() + ", status = " + iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserAVState());
                    if (Intrinsics.areEqual(String.valueOf(mediaChannelMicSequenceHelper.g1()), iGProUserInfo.getTinyId())) {
                        mediaChannelMicSequenceHelper.R1();
                    }
                }
                MediaChannelMicSequenceHelper.this.Q1(userList);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class i<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((IGProUserInfo) t17).getBusinessInfo().getSortKey()), Long.valueOf(((IGProUserInfo) t16).getBusinessInfo().getSortKey()));
            return compareValues;
        }
    }

    public MediaChannelMicSequenceHelper(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        this.selfMicSequenceState = MicSequenceState.STATUS_NONE;
        this.micSequenceList = new ArrayList();
        this.micSequencePermissionUpdateObserver = new g();
        this.audioQueueFinishListener = new b();
        this.observer = new h();
    }

    public static final void B1(MediaChannelMicSequenceHelper this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleStartMicSequence _result = " + i3 + ",  _errorMsg = " + str + " ");
        if (i3 == 0) {
            this$0.mMicQueueState = 1;
        } else {
            QQToast.makeText(com.tencent.mobileqq.guild.util.ch.i(), str, 0).show();
        }
        this$0.P1();
    }

    public static final void D1(MediaChannelMicSequenceHelper this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleStartMicSequence _result = " + i3 + ",  _errorMsg = " + str + " ");
        if (i3 == 0) {
            this$0.mMicQueueState = 2;
        } else {
            QQToast.makeText(com.tencent.mobileqq.guild.util.ch.i(), str, 0).show();
        }
        this$0.P1();
    }

    public static final void F1(int i3, String str, IGProSecurityResult iGProSecurityResult, String str2) {
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleTopSpeakOrderByAdmin _result = " + i3 + ",  _errorMsg = " + str + ", secResult = " + str + ", _rspInfo = " + str + " ");
    }

    public final boolean G1(String str) {
        IGProChannelInfo a16;
        if (!R0(this.mediaChannelCore.getGuildID(), str) || (a16 = a1()) == null || a16.getVoiceSpeakModeCfg().getSpeakMode() != 2) {
            return false;
        }
        return true;
    }

    private final void H1(int result, String errMsg, IGProAudioLiveUserListRsp rspInfo) {
        Logger.f235387a.d().i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onRequestMicSequenceRequestList: result[" + result + "] errMsg[" + errMsg + "]");
        if (result != 0) {
            return;
        }
        List<IGProUserInfo> userList = rspInfo.getSpeakOrderMemberInfo().getUserList();
        if (userList == null) {
            userList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.micSequenceList.clear();
        this.micSequenceList.addAll(userList);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bd());
        Iterator<T> it = userList.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.mediaChannelCore.getSelfUserInfo().f228093a, ((IGProUserInfo) it.next()).getTinyId())) {
                R1();
            }
        }
    }

    private final long I1(String channelId) {
        try {
            return Long.parseLong(channelId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("parseChannelId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final long J1(String guildId) {
        try {
            return Long.parseLong(guildId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("parseGuildId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final void L1() {
        uh2.b b16 = b1();
        com.tencent.mobileqq.qqguildsdk.data.genc.q qVar = new com.tencent.mobileqq.qqguildsdk.data.genc.q();
        qVar.j(J1(this.mediaChannelCore.getGuildID()));
        qVar.i(I1(this.mediaChannelCore.E()));
        qVar.n(0);
        qVar.p(true);
        qVar.k(false);
        b16.fetchAudioLiveChannelUserList(qVar, new wh2.ad() { // from class: com.tencent.mobileqq.guild.media.core.logic.ai
            @Override // wh2.ad
            public final void a(int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
                MediaChannelMicSequenceHelper.M1(MediaChannelMicSequenceHelper.this, i3, str, iGProAudioLiveUserListRsp);
            }
        });
    }

    public static final void M1(MediaChannelMicSequenceHelper this$0, int i3, String errMsg, IGProAudioLiveUserListRsp userListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(userListRsp, "userListRsp");
        this$0.H1(i3, errMsg, userListRsp);
    }

    public final void P1() {
        IGProVoiceQueueCfg voiceQueueCfg;
        IGProChannelInfo a16 = a1();
        if (a16 != null && (voiceQueueCfg = a16.getVoiceQueueCfg()) != null) {
            this.mMicQueueState = voiceQueueCfg.getVoiceQueueState();
            Logger.f235387a.d().i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "updateMicQueueState: curState = " + getMMicQueueState());
            this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ab(this.mMicQueueState));
        }
        R1();
    }

    public final void Q1(ArrayList<IGProUserInfo> micList) {
        List plus;
        List sortedWith;
        ArrayList arrayList = new ArrayList();
        for (Object obj : micList) {
            if (((IGProUserInfo) obj).getBusinessInfo().getUserAVInfo().isUserInSpeakQueue()) {
                arrayList.add(obj);
            }
        }
        List<IGProUserInfo> list = this.micSequenceList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (true ^ X0((IGProUserInfo) obj2, arrayList)) {
                arrayList2.add(obj2);
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(plus, new i());
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : sortedWith) {
            if (hashSet.add(((IGProUserInfo) obj3).getTinyId())) {
                arrayList3.add(obj3);
            }
        }
        this.micSequenceList.clear();
        this.micSequenceList.addAll(arrayList3);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bd());
        for (IGProUserInfo iGProUserInfo : this.micSequenceList) {
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "updateMicSequenceRequestList name =" + iGProUserInfo.getNickName() + ", sortKey=" + iGProUserInfo.getBusinessInfo().getSortKey() + " status = " + iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserAVState() + ",");
            if (Intrinsics.areEqual(String.valueOf(g1()), iGProUserInfo.getTinyId())) {
                R1();
            }
        }
    }

    public final boolean R0(String guildId, String channelId) {
        if (!TextUtils.equals(guildId, this.mediaChannelCore.getGuildID()) || !TextUtils.equals(channelId, this.mediaChannelCore.E())) {
            return false;
        }
        return true;
    }

    public final void R1() {
        boolean z16;
        MicSequenceState micSequenceState;
        if (this.mediaChannelCore.getSelfUserInfo().E) {
            int userAVState = this.mediaChannelCore.getSelfUserInfo().C.getUserAVInfo().getUserAVState();
            if (userAVState != 1) {
                if (userAVState != 8) {
                    if (userAVState != 3) {
                        if (userAVState != 4) {
                            micSequenceState = MicSequenceState.STATUS_DEQUEUE;
                        } else {
                            micSequenceState = MicSequenceState.STATUS_ON_MIC;
                        }
                    } else {
                        micSequenceState = MicSequenceState.STATUS_WAITTING;
                    }
                } else {
                    micSequenceState = MicSequenceState.STATUS_ENQUEUE;
                }
            } else {
                micSequenceState = MicSequenceState.STATUS_WAITTING;
            }
            this.selfMicSequenceState = micSequenceState;
        } else {
            this.selfMicSequenceState = MicSequenceState.STATUS_DEQUEUE;
        }
        if (!S0() && !k1() && !h1().d0() && !h1().i0() && h1().f0()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.selfMicSequenceState = MicSequenceState.USER_STATE_DISABLE;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "updateSelfMicSequenceState: userAVState = " + this.mediaChannelCore.getSelfUserInfo().C.getUserAVInfo().getUserAVState() + ", selfMicSequenceState = " + getSelfMicSequenceState());
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ao(this.selfMicSequenceState));
        if (this.selfMicSequenceState == MicSequenceState.STATUS_DEQUEUE) {
            this.selfHasEnQueue = false;
        }
    }

    private final boolean S0() {
        return com.tencent.mobileqq.guild.media.core.m.i(com.tencent.mobileqq.guild.media.core.j.c());
    }

    private final void U0() {
        this.mediaChannelCore.J().i(false, new c());
    }

    private final void V0(ArrayList<IGProUserInfo> micList, String tinyId) {
        int collectionSizeOrDefault;
        String joinToString$default;
        List sortedWith;
        Object obj;
        Logger.a d16 = Logger.f235387a.d();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(micList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = micList.iterator();
        while (it.hasNext()) {
            arrayList.add(((IGProUserInfo) it.next()).getTinyId());
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper$deleteMicSequenceRequestList$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(String str) {
                return "tinyId=" + str;
            }
        }, 31, null);
        d16.d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "deleteMicSequenceRequestList: micList[" + joinToString$default + "], tinyId: " + tinyId);
        Object obj2 = null;
        if (!micList.isEmpty()) {
            for (IGProUserInfo iGProUserInfo : micList) {
                List<IGProUserInfo> list = this.micSequenceList;
                List<IGProUserInfo> list2 = list;
                Iterator<T> it5 = list.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), iGProUserInfo.getTinyId())) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                TypeIntrinsics.asMutableCollection(list2).remove(obj);
            }
        }
        if (tinyId != null) {
            List<IGProUserInfo> list3 = this.micSequenceList;
            List<IGProUserInfo> list4 = list3;
            Iterator<T> it6 = list3.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                Object next = it6.next();
                if (Intrinsics.areEqual(((IGProUserInfo) next).getTinyId(), tinyId)) {
                    obj2 = next;
                    break;
                }
            }
            TypeIntrinsics.asMutableCollection(list4).remove(obj2);
        }
        List<IGProUserInfo> list5 = this.micSequenceList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : list5) {
            if (hashSet.add(((IGProUserInfo) obj3).getTinyId())) {
                arrayList2.add(obj3);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new d());
        this.micSequenceList.clear();
        this.micSequenceList.addAll(sortedWith);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bd());
        R1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void W0(MediaChannelMicSequenceHelper mediaChannelMicSequenceHelper, ArrayList arrayList, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = new ArrayList();
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        mediaChannelMicSequenceHelper.V0(arrayList, str);
    }

    private final boolean X0(IGProUserInfo r36, List<? extends IGProUserInfo> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((IGProUserInfo) it.next()).getTinyId(), r36.getTinyId())) {
                return true;
            }
        }
        return false;
    }

    private final com.tencent.mobileqq.qqguildsdk.data.genc.o Y0(String tinyId) {
        long parseLong;
        com.tencent.mobileqq.qqguildsdk.data.genc.o oVar = new com.tencent.mobileqq.qqguildsdk.data.genc.o();
        oVar.b().e(J1(this.mediaChannelCore.getGuildID()));
        oVar.b().d(I1(this.mediaChannelCore.E()));
        try {
            if (TextUtils.isEmpty(tinyId)) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(tinyId);
            }
            oVar.d(parseLong);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getAdminAVReqInfo: parse long error! [" + tinyId + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelMicSequenceHelper", 1, (String) it.next(), null);
            }
        }
        return oVar;
    }

    static /* synthetic */ com.tencent.mobileqq.qqguildsdk.data.genc.o Z0(MediaChannelMicSequenceHelper mediaChannelMicSequenceHelper, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return mediaChannelMicSequenceHelper.Y0(str);
    }

    private final IGProChannelInfo a1() {
        String guildID = this.mediaChannelCore.getGuildID();
        String E = this.mediaChannelCore.E();
        if (!TextUtils.isEmpty(guildID) && !TextUtils.isEmpty(E)) {
            AppInterface l3 = com.tencent.mobileqq.guild.util.ch.l();
            Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
            return com.tencent.mobileqq.guild.util.ch.C(l3, guildID, E);
        }
        return null;
    }

    private final uh2.b b1() {
        AppInterface l3 = com.tencent.mobileqq.guild.util.ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        return (uh2.b) runtimeService;
    }

    public final long g1() {
        try {
            String selfTinyId = ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).getSelfTinyId();
            Intrinsics.checkNotNullExpressionValue(selfTinyId, "gpsService.selfTinyId");
            return Long.parseLong(selfTinyId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getSelfTinyId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelRaiseHandHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final MediaChannelPermissionHelper h1() {
        return com.tencent.mobileqq.guild.media.core.j.a().S();
    }

    private final fc i1(String tinyId) {
        long parseLong;
        fc fcVar = new fc();
        fcVar.a().e(J1(this.mediaChannelCore.getGuildID()));
        fcVar.a().d(I1(this.mediaChannelCore.E()));
        if (TextUtils.isEmpty(tinyId)) {
            parseLong = g1();
        } else {
            parseLong = Long.parseLong(tinyId);
        }
        fcVar.g(parseLong);
        return fcVar;
    }

    static /* synthetic */ fc j1(MediaChannelMicSequenceHelper mediaChannelMicSequenceHelper, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return mediaChannelMicSequenceHelper.i1(str);
    }

    public static final void m1(MediaChannelMicSequenceHelper this$0, long j3, int i3, String str, IGProSecurityResult iGProSecurityResult, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleCancelSpeakOrderByAdmin _result = " + i3 + ",  _errorMsg = " + str + ", secResult = " + str + ", _rspInfo = " + str + " ");
        if (this$0.g1() == j3) {
            this$0.R1();
        }
    }

    public static final void o1(MediaChannelMicSequenceHelper this$0, int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "removeSpeakOrderByUser,  _result = " + i3 + ", _errMsg = " + str + ", rspInfo = " + iGProUserAVRspInfo + " ");
        if (i3 == 0) {
            this$0.R1();
            com.tencent.mobileqq.guild.media.core.j.a().J().i(false, new e());
            this$0.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.c(AudioQueueState.AUDIO_QUEUE_EXIT));
        }
    }

    public static final void q1(MediaChannelMicSequenceHelper this$0, int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "closeSpeakingByUser,  _result = " + i3 + ", _errMsg = " + str + ", rspInfo = " + iGProUserAVRspInfo + " ");
        if (i3 == 0) {
            ac M = com.tencent.mobileqq.guild.media.core.j.a().M();
            String str2 = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str2, "getDataHub().selfUserInfo.id");
            ac.T0(M, str2, false, 2, null);
            com.tencent.mobileqq.guild.media.core.j.a().J().i(false, new f());
            this$0.R1();
            W0(this$0, null, this$0.mediaChannelCore.getSelfUserInfo().f228093a, 1, null);
            this$0.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.c(AudioQueueState.AUDIO_QUEUE_CLOSE));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void s1(MediaChannelMicSequenceHelper mediaChannelMicSequenceHelper, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function3 = new Function3<Integer, String, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper$handleEnqueueMicSequence$1
                public final void invoke(int i16, @NotNull String str, boolean z16) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool) {
                    invoke(num.intValue(), str, bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        mediaChannelMicSequenceHelper.r1(function3);
    }

    public static final void t1(MediaChannelMicSequenceHelper this$0, Function3 callback, int i3, String _errMsg, IGProUserAVRspInfo iGProUserAVRspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "addSpeakOrderByUser,  _result = " + i3 + ", _errMsg = " + _errMsg + ", rspInfo = " + iGProUserAVRspInfo + " ");
        if (i3 == 0) {
            this$0.R1();
            this$0.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.c(AudioQueueState.AUDIO_QUEUE_ENTER));
            this$0.selfHasEnQueue = true;
        } else {
            QQToast.makeText(com.tencent.mobileqq.guild.util.ch.i(), _errMsg, 0).show();
        }
        Integer valueOf = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(_errMsg, "_errMsg");
        callback.invoke(valueOf, _errMsg, Boolean.FALSE);
    }

    public static final void v1(int i3, String errMsg, IGProSecurityResult iGProSecurityResult, String str) {
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "inviteUserQueueForAdmin,  result = " + i3 + ", errMsg = " + errMsg + " ");
        if (i3 == 0) {
            MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            MediaChannelUtils.V(mediaChannelUtils, i3, errMsg, R.string.f14979139, 0, 8, null);
        } else {
            MediaChannelUtils mediaChannelUtils2 = MediaChannelUtils.f228046a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            MediaChannelUtils.V(mediaChannelUtils2, i3, errMsg, 0, 0, 12, null);
        }
    }

    public final void w1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        if (!R0(guildId, channelId)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleOnEnterSpeakQueueNotifyForAll,  channelId[" + channelId + "]");
        for (IGProUserInfo iGProUserInfo : userList) {
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleOnEnterSpeakQueueNotifyForAll " + iGProUserInfo.getNickName() + ",  sortKey=" + iGProUserInfo.getBusinessInfo().getSortKey());
        }
        Q1(userList);
    }

    public final void x1(IGProAVUserStateChangeInfo userStateInfo) {
        if (!R0(userStateInfo.getGuildId().toString(), userStateInfo.getChannelId().toString())) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleOnPushAVUserStateChange: userId = " + userStateInfo.getTinyId() + ", msg = " + userStateInfo.getMsg() + " ");
        if (g1() != userStateInfo.getTinyId()) {
            R1();
            if (this.selfMicSequenceState == MicSequenceState.STATUS_DEQUEUE) {
                W0(this, null, String.valueOf(userStateInfo.getTinyId()), 1, null);
                U0();
            }
        }
    }

    public final void y1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        int collectionSizeOrDefault;
        String joinToString$default;
        if (!R0(guildId, channelId)) {
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = userList.iterator();
        while (it.hasNext()) {
            arrayList.add(((IGProUserInfo) it.next()).getTinyId());
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelMicSequenceHelper$handleOnUserAVStateResetNotifyForAll$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(String str) {
                return "tinyId=" + str;
            }
        }, 31, null);
        d16.i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onUserAVStateResetNotifyForAll, channelUin = " + channelId + "\uff0c id: " + joinToString$default);
        if (userList != null) {
            W0(this, userList, null, 2, null);
        }
    }

    public final void z1(String guildId, String channelId, ArrayList<IGProUserInfo> userList) {
        if (!R0(guildId, channelId)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelMicSequenceHelper", 1, "onUserSpeakingNotifyForAll: user up mic channelUin = " + channelId);
        for (IGProUserInfo iGProUserInfo : userList) {
            Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "user up mic " + iGProUserInfo.getNickName());
            if (Intrinsics.areEqual(String.valueOf(g1()), iGProUserInfo.getTinyId())) {
                R1();
            }
        }
        Q1(userList);
    }

    public final void A1() {
        uh2.b b16 = b1();
        fh fhVar = new fh();
        fhVar.b(1);
        b16.setAVChannelSpeakOrder(J1(this.mediaChannelCore.getGuildID()), I1(this.mediaChannelCore.E()), fhVar, new em() { // from class: com.tencent.mobileqq.guild.media.core.logic.al
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                MediaChannelMicSequenceHelper.B1(MediaChannelMicSequenceHelper.this, i3, str);
            }
        });
    }

    public final void C1() {
        uh2.b b16 = b1();
        fh fhVar = new fh();
        fhVar.b(2);
        b16.setAVChannelSpeakOrder(J1(this.mediaChannelCore.getGuildID()), I1(this.mediaChannelCore.E()), fhVar, new em() { // from class: com.tencent.mobileqq.guild.media.core.logic.am
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                MediaChannelMicSequenceHelper.D1(MediaChannelMicSequenceHelper.this, i3, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelMicSequenceHelper", "onEnterChannel:");
        }
        L1();
        P1();
        R1();
        K1();
    }

    public final void E1(long id5) {
        uh2.b b16 = b1();
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleTopSpeakOrderByAdmin tinyId = " + id5);
        com.tencent.mobileqq.qqguildsdk.data.genc.o Z0 = Z0(this, null, 1, null);
        Z0.d(id5);
        b16.topSpeakOrderByAdmin(Z0, new wh2.c() { // from class: com.tencent.mobileqq.guild.media.core.logic.an
            @Override // wh2.c
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, String str2) {
                MediaChannelMicSequenceHelper.F1(i3, str, iGProSecurityResult, str2);
            }
        });
    }

    public void K1() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelMicSequenceHelper", "registerObservers:");
        }
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.micSequencePermissionUpdateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueFinishListener);
    }

    public final void N1(boolean z16) {
        this.selfHasEnQueue = z16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    @NotNull
    public MediaBusinessType O() {
        return MediaBusinessType.MEDIA_MIC_QUEUE;
    }

    public void O1() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelMicSequenceHelper", "unregisterObserver:");
        }
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.micSequencePermissionUpdateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.a.class, this.audioQueueFinishListener);
    }

    public final boolean T0(@NotNull String userId) {
        Object obj;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Iterator<T> it = this.micSequenceList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), userId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    /* renamed from: c1, reason: from getter */
    public final int getMMicQueueState() {
        return this.mMicQueueState;
    }

    @NotNull
    public final List<IGProUserInfo> d1() {
        return this.micSequenceList;
    }

    /* renamed from: e1, reason: from getter */
    public final boolean getSelfHasEnQueue() {
        return this.selfHasEnQueue;
    }

    @NotNull
    /* renamed from: f1, reason: from getter */
    public final MicSequenceState getSelfMicSequenceState() {
        return this.selfMicSequenceState;
    }

    public final boolean k1() {
        return com.tencent.mobileqq.guild.media.core.m.j(com.tencent.mobileqq.guild.media.core.j.c());
    }

    public final void l1(final long id5) {
        Logger.f235387a.d().d("QGMC.Core.MediaChannelMicSequenceHelper", 1, "handleCancelSpeakOrderByAdmin tinyId = " + id5);
        com.tencent.mobileqq.qqguildsdk.data.genc.o Z0 = Z0(this, null, 1, null);
        Z0.d(id5);
        b1().cancelSpeakOrderByAdmin(Z0, new wh2.c() { // from class: com.tencent.mobileqq.guild.media.core.logic.aj
            @Override // wh2.c
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, String str2) {
                MediaChannelMicSequenceHelper.m1(MediaChannelMicSequenceHelper.this, id5, i3, str, iGProSecurityResult, str2);
            }
        });
    }

    public final void n1() {
        b1().removeSpeakOrderByUser(j1(this, null, 1, null), new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.ao
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                MediaChannelMicSequenceHelper.o1(MediaChannelMicSequenceHelper.this, i3, str, iGProUserAVRspInfo);
            }
        });
    }

    public final void p1() {
        uh2.b b16 = b1();
        fc j16 = j1(this, null, 1, null);
        j16.b().e(11);
        b16.removeSpeakOrderByUser(j16, new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.ak
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                MediaChannelMicSequenceHelper.q1(MediaChannelMicSequenceHelper.this, i3, str, iGProUserAVRspInfo);
            }
        });
    }

    public final void r1(@NotNull final Function3<? super Integer, ? super String, ? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        uh2.b b16 = b1();
        new fh().b(1);
        b16.addSpeakOrderByUser(j1(this, null, 1, null), new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.ah
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                MediaChannelMicSequenceHelper.t1(MediaChannelMicSequenceHelper.this, callback, i3, str, iGProUserAVRspInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelMicSequenceHelper", "onExitChannel:");
        }
        O1();
        this.micSequenceList.clear();
        this.selfHasEnQueue = false;
    }

    public final void u1(@NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        com.tencent.mobileqq.qqguildsdk.data.genc.o Y0 = Y0(tinyId);
        Y0.a().e(12);
        b1().inviteUserQueueForAdmin(Y0, new wh2.c() { // from class: com.tencent.mobileqq.guild.media.core.logic.ap
            @Override // wh2.c
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, String str2) {
                MediaChannelMicSequenceHelper.v1(i3, str, iGProSecurityResult, str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void R() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.d
    public void S() {
    }
}
