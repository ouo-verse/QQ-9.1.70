package com.tencent.mobileqq.guild.media.core.logic;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCurrPlaySongRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProListenTogetherRspHead;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wh2.dn;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\f*\u0003bfj\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0001tB\u0017\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010F\u001a\u00020C\u00a2\u0006\u0004\bq\u0010rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J4\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u00132\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'J\u0010\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010'J\u0010\u0010-\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020#J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J\u0010\u00102\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\rJ\u000e\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020#J\u000e\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\rJ\u0006\u00107\u001a\u00020\u0005J\u0006\u00108\u001a\u00020\rJ\u0006\u00109\u001a\u00020\u0005J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\u000e\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0015R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010HR\u0016\u0010V\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010NR\u001e\u0010Z\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010HR\u0016\u0010`\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010QR\u0016\u0010a\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010NR\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001a\u0004\u0018\u00010'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bn\u0010o\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/ab;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessNode;", "businessNode", "", "P0", "", "guildId", "channelId", "musicId", "Lorg/json/JSONObject;", "j0", "", "operate", "Y0", "result", "msg", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "O0", "", "b0", "U0", "", "", "M0", ark.ARKMETADATA_JSON, "R0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPlayNodeExtInfo;", "playExtraInfo", ICustomDataEditor.STRING_ARRAY_PARAM_1, "uid", "c0", "status", "", "d0", "errCode", "i0", "Lcom/tencent/mobileqq/guild/media/listen/presenter/a;", "listenUiAction", "X0", "listenBaseUiAction", "W0", "reStart", "e1", "g1", "S0", "T0", "from", "e0", "needShow", "Q0", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "b1", "c1", "J0", "F0", "E0", "p", "u", "time", "V0", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom;", "e", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom;", "trtcCloud", "Lcom/tencent/mobileqq/guild/media/core/f;", "f", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", tl.h.F, "I", "musicPlayId", "i", "Ljava/lang/String;", "curPlayId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "needRetry", BdhLogUtil.LogTag.Tag_Conn, "J", "musicStartTime", "D", "musicVolume", "E", "isSelfCaptain", "Ljava/lang/ref/WeakReference;", UserInfo.SEX_FEMALE, "Ljava/lang/ref/WeakReference;", "_listenUIActionRef", "G", "Lcom/tencent/mobileqq/guild/media/listen/presenter/a;", "listenBaseUIAction", "H", "curPlayStatus", "hasPlayedMs", "markSelfChangeVolume", "com/tencent/mobileqq/guild/media/core/logic/ab$d", "K", "Lcom/tencent/mobileqq/guild/media/core/logic/ab$d;", "musicObserver", "com/tencent/mobileqq/guild/media/core/logic/ab$b", "L", "Lcom/tencent/mobileqq/guild/media/core/logic/ab$b;", "bizNodeUpdateObserver", "com/tencent/mobileqq/guild/media/core/logic/ab$c", "M", "Lcom/tencent/mobileqq/guild/media/core/logic/ab$c;", "gProObserver", "I0", "()Lcom/tencent/mobileqq/guild/media/listen/presenter/a;", "listenUIAction", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom;Lcom/tencent/mobileqq/guild/media/core/f;)V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ab extends h {

    /* renamed from: C */
    private long musicStartTime;

    /* renamed from: D, reason: from kotlin metadata */
    private int musicVolume;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isSelfCaptain;

    /* renamed from: F */
    @Nullable
    private WeakReference<com.tencent.mobileqq.guild.media.listen.presenter.a> _listenUIActionRef;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.listen.presenter.a listenBaseUIAction;

    /* renamed from: H, reason: from kotlin metadata */
    private int curPlayStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private long hasPlayedMs;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean markSelfChangeVolume;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private d musicObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final b bizNodeUpdateObserver;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final c gProObserver;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final ITRTCAudioRoom trtcCloud;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: h */
    private final int musicPlayId;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private String curPlayId;

    /* renamed from: m */
    private boolean needRetry;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ab$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/e;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.e> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.e event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getBizNode().getNodeType() == 5) {
                ab.this.P0(event.getBizNode());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ab$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "info", "", "sourceNum", PublicAccountMessageUtilImpl.ITEM_GRAY_TIPS, "", "onPushAVChannelPlayListChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushAVChannelPlayListChange(@Nullable String guildId, @Nullable String channelId, @Nullable String info, int sourceNum, @Nullable String r65) {
            super.onPushAVChannelPlayListChange(guildId, channelId, info, sourceNum, r65);
            QLog.d("QGMC.MediaListen.ListenHelper", 4, "onPushAVChannelPlayListChange " + r65);
            if (!StringUtil.isEmpty(info)) {
                ((IMiniContainer) QRoute.api(IMiniContainer.class)).dispatchNativeEvent("guildAvSimpleListener", ab.this.R0(info));
            }
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = ab.this.I0();
            if (I0 != null) {
                I0.b(sourceNum);
            }
            MediaChannelCore.INSTANCE.a().o0().F0(sourceNum);
            if (!StringUtil.isEmpty(r65)) {
                com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
                Intrinsics.checkNotNull(r65);
                d16.i(new com.tencent.mobileqq.guild.media.core.notify.v(r65));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/ab$d", "Lcom/tencent/mobileqq/guild/media/core/logic/i;", "", "id", "errCode", "", "onStart", "", "curPtsMS", "durationMS", "onPlayProgress", "onComplete", "b", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements i {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.i
        public void b(int id5) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "onStop id " + id5 + " ");
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.i
        public void onComplete(int id5, int errCode) {
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = ab.this.I0();
            if (I0 != null) {
                I0.e();
            }
            com.tencent.mobileqq.guild.media.listen.presenter.a aVar = ab.this.listenBaseUIAction;
            if (aVar != null) {
                aVar.e();
            }
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "onComplete id " + id5 + " - errcode " + errCode);
            ab.this.i0(errCode);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.i
        public void onPause(int i3) {
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = ab.this.I0();
            if (I0 != null) {
                I0.e();
            }
            com.tencent.mobileqq.guild.media.listen.presenter.a aVar = ab.this.listenBaseUIAction;
            if (aVar != null) {
                aVar.e();
            }
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "onPause id " + i3 + " ");
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.i
        public void onPlayProgress(int id5, long curPtsMS, long durationMS) {
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = ab.this.I0();
            if (I0 != null) {
                I0.g(curPtsMS, durationMS);
            }
            com.tencent.mobileqq.guild.media.listen.presenter.a aVar = ab.this.listenBaseUIAction;
            if (aVar != null) {
                aVar.g(curPtsMS, durationMS);
            }
            ab.this.hasPlayedMs = curPtsMS;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.i
        public void onStart(int id5, int errCode) {
            QLog.d("QGMC.MediaListen.ListenHelper", 4, "onStart id " + id5 + " - errcode " + errCode);
            boolean z16 = true;
            if (ab.this.curPlayStatus == 1) {
                com.tencent.mobileqq.guild.media.listen.presenter.a I0 = ab.this.I0();
                if (I0 != null) {
                    I0.a();
                }
                com.tencent.mobileqq.guild.media.listen.presenter.a aVar = ab.this.listenBaseUIAction;
                if (aVar != null) {
                    aVar.a();
                }
            }
            com.tencent.mobileqq.guild.performance.report.aa aaVar = com.tencent.mobileqq.guild.performance.report.aa.f230980i;
            GuildCounterNames guildCounterNames = GuildCounterNames.GUILD_LISTEN;
            HashMap<String, String> O0 = ab.this.O0(errCode, "av_channel_listen_start_res");
            if (errCode != 0) {
                z16 = false;
            }
            aaVar.z("av_channel_listen_start_res", guildCounterNames, O0, z16);
            ab.this.i0(errCode);
        }
    }

    public ab(@NotNull ITRTCAudioRoom trtcCloud, @NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(trtcCloud, "trtcCloud");
        Intrinsics.checkNotNullParameter(core, "core");
        this.trtcCloud = trtcCloud;
        this.core = core;
        this.musicPlayId = 1;
        this.curPlayId = "";
        this.needRetry = true;
        this.musicVolume = 30;
        this.musicObserver = new d();
        this.bizNodeUpdateObserver = new b();
        this.gProObserver = new c();
    }

    public static final void H0(String channelID, ab this$0, int i3, String str, IGProGetCurrPlaySongRsp iGProGetCurrPlaySongRsp) {
        Intrinsics.checkNotNullParameter(channelID, "$channelID");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QGMC.MediaListen.ListenHelper", 1, "getCurrPlaySong res " + i3 + " errMsg " + str);
        if (i3 == 0) {
            QLog.d("QGMC.MediaListen.ListenHelper", 4, "getCurSong backgroundColorList " + iGProGetCurrPlaySongRsp.getPlayInfo().getPlayNodeInfo().getBackgroundColorList());
            MediaChannelCore.Companion companion = MediaChannelCore.INSTANCE;
            companion.a().o0().l0(iGProGetCurrPlaySongRsp.getPlayInfo());
            companion.a().o0().J0(iGProGetCurrPlaySongRsp.getPlayInfo().getSongInfo());
            companion.a().o0().F0((int) iGProGetCurrPlaySongRsp.getPlayInfo().getPlayNodeExInfo().getSourceNum());
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.u(false, channelID));
            int playState = iGProGetCurrPlaySongRsp.getPlayInfo().getPlayNodeExInfo().getPlayState();
            IGProPlayNodeExtInfo playNodeExInfo = iGProGetCurrPlaySongRsp.getPlayInfo().getPlayNodeExInfo();
            String playNodeId = iGProGetCurrPlaySongRsp.getPlayInfo().getPlayNodeInfo().getPlayNodeId();
            Intrinsics.checkNotNullExpressionValue(playNodeId, "getCurrPlaySongRsp.playI\u2026o.playNodeInfo.playNodeId");
            this$0.curPlayId = playNodeId;
            this$0.curPlayStatus = playState;
            this$0.c0(playNodeExInfo.getCompereTinyid());
            if (playState == 1) {
                f1(this$0, false, 1, null);
            }
            if (playNodeExInfo.getEnableVolume()) {
                QLog.d("QGMC.MediaListen.ListenHelper", 1, "enableVolume " + playNodeExInfo.getVolume());
                this$0.b1(playNodeExInfo.getVolume());
            }
        }
    }

    public final com.tencent.mobileqq.guild.media.listen.presenter.a I0() {
        WeakReference<com.tencent.mobileqq.guild.media.listen.presenter.a> weakReference = this._listenUIActionRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final Map<String, Object> M0() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()));
        hashMap.put("sgrp_sub_channel_id", com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c()));
        hashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()))));
        hashMap.put("duration", Long.valueOf(NetConnInfoCenter.getServerTime() - this.musicStartTime));
        if (com.tencent.mobileqq.guild.media.core.m.k(com.tencent.mobileqq.guild.media.core.j.c())) {
            hashMap.put("sgrp_user_type_list", "1");
        } else {
            hashMap.put("sgrp_user_type_list", "0");
        }
        return hashMap;
    }

    public final HashMap<String, String> O0(int result, String msg2) {
        String str;
        HashMap<String, String> hashMapOf;
        IGProPlayNodeExtInfo playNodeExInfo;
        IGProPlayNodeInfo playNodeInfo;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("msg", msg2);
        IGProPlayInfo I = com.tencent.mobileqq.guild.media.core.j.c().I();
        Long l3 = null;
        if (I != null && (playNodeInfo = I.getPlayNodeInfo()) != null) {
            str = playNodeInfo.getPlayNodeId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("music_id", str);
        pairArr[2] = TuplesKt.to("operate_result", String.valueOf(result));
        IGProPlayInfo I2 = com.tencent.mobileqq.guild.media.core.j.c().I();
        if (I2 != null && (playNodeExInfo = I2.getPlayNodeExInfo()) != null) {
            l3 = Long.valueOf(playNodeExInfo.getCompereTinyid());
        }
        pairArr[3] = TuplesKt.to("host_id", String.valueOf(l3));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        return hashMapOf;
    }

    public final void P0(IGProBusinessNode businessNode) {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        HashMap hashMapOf3;
        String d16 = com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c());
        String b16 = com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c());
        IGProPlayInfo playInfo = businessNode.getPlayInfo();
        IGProPlayNodeExtInfo playNodeExInfo = businessNode.getPlayInfo().getPlayNodeExInfo();
        if (playNodeExInfo.getPushScene().getVolume()) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "pushScene from volume change! " + this.markSelfChangeVolume);
            if (!this.markSelfChangeVolume) {
                b1(playNodeExInfo.getVolume());
                return;
            }
            return;
        }
        Intrinsics.checkNotNullExpressionValue(playNodeExInfo, "playNodeExInfo");
        a1(playNodeExInfo);
        c0(playNodeExInfo.getCompereTinyid());
        MediaChannelCore.Companion companion = MediaChannelCore.INSTANCE;
        companion.a().o0().l0(playInfo);
        companion.a().o0().F0((int) playNodeExInfo.getSourceNum());
        if (!Intrinsics.areEqual(this.curPlayId, playInfo.getPlayNodeInfo().getPlayNodeId())) {
            String playNodeId = playInfo.getPlayNodeInfo().getPlayNodeId();
            Intrinsics.checkNotNullExpressionValue(playNodeId, "playInfo.playNodeInfo.playNodeId");
            this.curPlayId = playNodeId;
            this.curPlayStatus = playNodeExInfo.getPlayState();
            this.core.o0().J0(businessNode.getPlayInfo().getSongInfo());
            IMiniContainer iMiniContainer = (IMiniContainer) QRoute.api(IMiniContainer.class);
            hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("name", "guildAvPlayNextMusic"), TuplesKt.to("params", j0(d16, b16, this.curPlayId)));
            iMiniContainer.dispatchNativeEvent("guildAvSimpleListener", hashMapOf3);
            f1(this, false, 1, null);
        } else if (Intrinsics.areEqual(playInfo.getPlayNodeInfo().getPlayNodeId(), this.curPlayId)) {
            if (this.curPlayStatus != playNodeExInfo.getPlayState()) {
                int playState = playNodeExInfo.getPlayState();
                if (playState != 1) {
                    if (playState != 2) {
                        this.curPlayStatus = playNodeExInfo.getPlayState();
                    } else {
                        this.curPlayStatus = playNodeExInfo.getPlayState();
                        IMiniContainer iMiniContainer2 = (IMiniContainer) QRoute.api(IMiniContainer.class);
                        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("name", "guildAvPauseMusic"), TuplesKt.to("params", j0(d16, b16, this.curPlayId)));
                        iMiniContainer2.dispatchNativeEvent("guildAvSimpleListener", hashMapOf2);
                        QLog.d("QGMC.MediaListen.ListenHelper", 4, "pauseDuration " + playNodeExInfo.getPauseDuration());
                        S0();
                    }
                } else if (this.curPlayStatus == 2) {
                    this.curPlayStatus = playNodeExInfo.getPlayState();
                    this.core.o0().J0(businessNode.getPlayInfo().getSongInfo());
                    IMiniContainer iMiniContainer3 = (IMiniContainer) QRoute.api(IMiniContainer.class);
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("name", "guildAvResumeMusic"), TuplesKt.to("params", l0(this, d16, b16, null, 4, null)));
                    iMiniContainer3.dispatchNativeEvent("guildAvSimpleListener", hashMapOf);
                    f1(this, false, 1, null);
                }
            } else if (this.curPlayStatus == 1) {
                f1(this, false, 1, null);
            }
        }
        QLog.d("QGMC.MediaListen.ListenHelper", 1, "handleListenTogetherInfoChange playStatus " + this.curPlayStatus + " curPlayId " + this.curPlayId);
        com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.u(false, b16));
        if (this.curPlayStatus != 5 && this.musicStartTime == 0) {
            this.musicStartTime = System.currentTimeMillis();
        }
        if (this.curPlayStatus == 5) {
            g1();
            U0();
            companion.a().y0().b(com.tencent.mobileqq.guild.util.bw.k());
        }
    }

    public final Map<String, Object> R0(String r65) {
        Map<String, Object> emptyMap;
        try {
            JSONObject jSONObject = new JSONObject(r65);
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    hashMap.put(str, new JSONArray(jSONObject.optString(str)));
                } catch (Exception unused) {
                    String optString = jSONObject.optString(str);
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(key)");
                    hashMap.put(str, optString);
                }
            }
            return hashMap;
        } catch (JSONException e16) {
            QLog.e("QGMC.MediaListen.ListenHelper", 1, e16, new Object[0]);
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }

    private final void U0() {
        if (this.musicStartTime > 0) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent("ev_sgrp_avchannel_aio_musicplayer", M0());
        }
        this.musicStartTime = 0L;
    }

    private final void Y0(final int operate) {
        IGProPlayNodeExtInfo playNodeExInfo;
        if (StringUtil.isEmpty(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a)) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "setMusicOpt selfUserInfo id is empty");
            return;
        }
        IGProPlayInfo I = com.tencent.mobileqq.guild.media.core.j.c().I();
        boolean z16 = false;
        if (I != null && (playNodeExInfo = I.getPlayNodeExInfo()) != null) {
            long compereTinyid = playNodeExInfo.getCompereTinyid();
            String str = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "getDataHub().selfUserInfo.id");
            if (compereTinyid == Long.parseLong(str)) {
                z16 = true;
            }
        }
        if (!z16) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "setMusicOpt " + operate + " has no right!");
            return;
        }
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.l().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface().getRuntim\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        if (!StringUtil.isEmpty(guildID) && !StringUtil.isEmpty(E)) {
            iGPSService.setListenTogetherPlayOpt(Long.parseLong(guildID), Long.parseLong(E), operate, new dn() { // from class: com.tencent.mobileqq.guild.media.core.logic.z
                @Override // wh2.dn
                public final void a(int i3, String str2, IGProListenTogetherRspHead iGProListenTogetherRspHead) {
                    ab.Z0(ab.this, operate, i3, str2, iGProListenTogetherRspHead);
                }
            });
        } else {
            QLog.d("QGMC.MediaListen.ListenHelper", 4, "setMusicOpt err guild or channel id");
        }
    }

    public static final void Z0(ab this$0, int i3, int i16, String errMsg, IGProListenTogetherRspHead iGProListenTogetherRspHead) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d("QGMC.MediaListen.ListenHelper", 1, "setListenTogetherPlayOpt res " + i16 + " errMsg " + errMsg);
        com.tencent.mobileqq.guild.performance.report.aa aaVar = com.tencent.mobileqq.guild.performance.report.aa.f230980i;
        GuildCounterNames guildCounterNames = GuildCounterNames.GUILD_LISTEN;
        HashMap<String, String> O0 = this$0.O0(i16, "av_channel_listen_req_operate");
        O0.put(EntityManager.KEY_OPERATE_TYPE, String.valueOf(i3));
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        O0.put("err_msg", errMsg);
        Unit unit = Unit.INSTANCE;
        if (i16 != 0) {
            z16 = false;
        }
        aaVar.z("av_channel_listen_req_operate", guildCounterNames, O0, z16);
        if (i16 != 0) {
            if (StringUtil.isEmpty(errMsg)) {
                errMsg = "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            }
            QQToast.makeText(BaseApplication.context, errMsg, 0).show();
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = this$0.I0();
            if (I0 != null) {
                I0.h(i3);
            }
        }
    }

    private final void a1(IGProPlayNodeExtInfo iGProPlayNodeExtInfo) {
        com.tencent.mobileqq.guild.media.listen.presenter.a I0;
        if (d0(iGProPlayNodeExtInfo.getPlayState())) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "checkIsFirstStartMusic true");
            if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) != 2 && com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) != 6) {
                MediaChannelCore.INSTANCE.a().y0().b(4);
                if (com.tencent.mobileqq.guild.util.bw.k() == 1 && (I0 = I0()) != null) {
                    I0.c();
                }
            }
            if (iGProPlayNodeExtInfo.getEnableVolume()) {
                b1(iGProPlayNodeExtInfo.getVolume());
            }
        }
    }

    private final long b0() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        IGProPlayInfo I = com.tencent.mobileqq.guild.media.core.j.c().I();
        Intrinsics.checkNotNull(I);
        long startPlayTime = serverTimeMillis - I.getPlayNodeExInfo().getStartPlayTime();
        IGProPlayInfo I2 = com.tencent.mobileqq.guild.media.core.j.c().I();
        Intrinsics.checkNotNull(I2);
        QLog.d("QGMC.MediaListen.ListenHelper", 4, "calculateStartTime startPlayTime " + I2.getPlayNodeExInfo().getStartPlayTime());
        QLog.d("QGMC.MediaListen.ListenHelper", 1, "calculateStartTime hasPlayedTime " + startPlayTime);
        if (startPlayTime >= 0) {
            Intrinsics.checkNotNull(com.tencent.mobileqq.guild.media.core.j.c().I());
            if (startPlayTime <= r4.getPlayNodeInfo().getPlaySourceDuration() * 1000) {
                return startPlayTime;
            }
        }
        return 0L;
    }

    private final void c0(long uid) {
        if (Intrinsics.areEqual(String.valueOf(uid), com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a) && !this.isSelfCaptain) {
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = I0();
            if (I0 != null) {
                I0.j(R.string.f1495812o, R.string.f146610un);
            }
            this.isSelfCaptain = true;
        }
    }

    private final boolean d0(int status) {
        int i3 = this.curPlayStatus;
        if ((i3 == 0 || i3 == 5) && status != 5) {
            return true;
        }
        return false;
    }

    public static final void d1(int i3, String str, IGProListenTogetherRspHead iGProListenTogetherRspHead) {
        QLog.d("QGMC.MediaListen.ListenHelper", 1, "result - " + i3 + ", errMsg - " + str);
    }

    public static /* synthetic */ void f0(ab abVar, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        abVar.e0(i3);
    }

    public static /* synthetic */ void f1(ab abVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        abVar.e1(z16);
    }

    public final void i0(int errCode) {
        if (errCode != -4002 && errCode != -4001) {
            if (errCode == 0) {
                this.needRetry = true;
                return;
            }
            return;
        }
        if (this.needRetry) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "dealWithCompleteError retry");
            f1(this, false, 1, null);
            this.needRetry = false;
        } else {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "dealWithCompleteError retry failed");
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = I0();
            if (I0 != null) {
                I0.showToast(R.string.f1496112r);
            }
        }
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.z("av_channel_listen_start_res", GuildCounterNames.GUILD_LISTEN, O0(errCode, "av_channel_listen_start_res"), false);
    }

    private final JSONObject j0(String guildId, String channelId, String musicId) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("guildId", guildId);
            jSONObject.put("channelId", channelId);
            if (musicId != null) {
                jSONObject.put("musicId", musicId);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    static /* synthetic */ JSONObject l0(ab abVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        return abVar.j0(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        if (com.tencent.mobileqq.guild.media.core.j.c().I() != null) {
            this.musicStartTime = NetConnInfoCenter.getServerTime();
        }
        this.trtcCloud.n(this.musicObserver);
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).addObserver(this.gProObserver);
        this.core.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.e.class, this.bizNodeUpdateObserver);
    }

    public final void F0() {
        IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.l().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface().getRuntim\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        final String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        if (!StringUtil.isEmpty(guildID) && !StringUtil.isEmpty(E)) {
            iGPSService.getCurrPlaySong(Long.parseLong(guildID), Long.parseLong(E), new wh2.bx() { // from class: com.tencent.mobileqq.guild.media.core.logic.aa
                @Override // wh2.bx
                public final void a(int i3, String str, IGProGetCurrPlaySongRsp iGProGetCurrPlaySongRsp) {
                    ab.H0(E, this, i3, str, iGProGetCurrPlaySongRsp);
                }
            });
        } else {
            QLog.d("QGMC.MediaListen.ListenHelper", 4, "getCurSong err guild or channel id");
        }
    }

    /* renamed from: J0, reason: from getter */
    public final int getMusicVolume() {
        return this.musicVolume;
    }

    public final void Q0(boolean needShow) {
        com.tencent.mobileqq.guild.media.listen.presenter.a I0 = I0();
        if (I0 != null) {
            I0.i(needShow);
        }
    }

    public final void S0() {
        this.trtcCloud.H(this.musicPlayId);
        if (this.curPlayStatus != 2) {
            Y0(2);
        }
    }

    public final void T0() {
        Y0(4);
    }

    public final void V0(long time) {
        this.core.o0().O0(time);
    }

    public final void W0(@Nullable com.tencent.mobileqq.guild.media.listen.presenter.a listenBaseUiAction) {
        this.listenBaseUIAction = listenBaseUiAction;
    }

    public final void X0(@Nullable com.tencent.mobileqq.guild.media.listen.presenter.a listenUiAction) {
        this._listenUIActionRef = new WeakReference<>(listenUiAction);
    }

    public final void b1(int r46) {
        QLog.d("QGMC.MediaListen.ListenHelper", 4, "setMusicVolume " + r46);
        this.musicVolume = r46;
        this.trtcCloud.setMusicPlayoutVolume(this.musicPlayId, r46);
        if (this.musicVolume == 0) {
            com.tencent.mobileqq.guild.media.listen.presenter.a I0 = I0();
            if (I0 != null) {
                I0.f(0);
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.media.listen.presenter.a I02 = I0();
        if (I02 != null) {
            I02.f(8);
        }
    }

    public final void c1() {
        if (this.isSelfCaptain || MediaChannelUtils.f228046a.v(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo())) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "setMusicVolumeByAdminRole start");
            IRuntimeService runtimeService = com.tencent.mobileqq.guild.util.ch.l().getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface()\n         \u2026va, ProcessConstant.MAIN)");
            IGPSService iGPSService = (IGPSService) runtimeService;
            String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
            String E = com.tencent.mobileqq.guild.media.core.j.a().E();
            if (!StringUtil.isEmpty(guildID) && !StringUtil.isEmpty(E)) {
                iGPSService.setListenTogetherPlayVolumeByAdmin(Long.parseLong(guildID), Long.parseLong(E), this.musicVolume, new dn() { // from class: com.tencent.mobileqq.guild.media.core.logic.y
                    @Override // wh2.dn
                    public final void a(int i3, String str, IGProListenTogetherRspHead iGProListenTogetherRspHead) {
                        ab.d1(i3, str, iGProListenTogetherRspHead);
                    }
                });
            } else {
                QLog.d("QGMC.MediaListen.ListenHelper", 4, "setMusicVolumeByAdminRole err guild or channel id");
            }
        }
        this.markSelfChangeVolume = true;
    }

    public final void e0(int from) {
        com.tencent.mobileqq.guild.media.listen.presenter.a I0 = I0();
        if (I0 != null) {
            I0.d(from);
        }
    }

    public final void e1(boolean reStart) {
        int i3 = this.curPlayStatus;
        if (i3 != 1 && !reStart) {
            Y0(1);
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "just setMusicOpt");
            return;
        }
        if (reStart && i3 != 1) {
            QLog.d("QGMC.MediaListen.ListenHelper", 1, "reStart but curPlayStatus != GGProPlayState.PLAYING");
            return;
        }
        IGProPlayInfo I = com.tencent.mobileqq.guild.media.core.j.c().I();
        if (I != null && I.getSongInfo().getPlayUrlList().size() >= 1) {
            if (I.getPlayNodeExInfo().getStartPlayTime() != 0) {
                String str = I.getSongInfo().getPlayUrlList().get(0);
                if (reStart) {
                    this.trtcCloud.x(this.musicPlayId, false, str, this.hasPlayedMs);
                } else {
                    this.trtcCloud.x(this.musicPlayId, false, str, b0());
                }
                this.trtcCloud.setMusicPlayoutVolume(this.musicPlayId, this.musicVolume);
                com.tencent.mobileqq.guild.performance.report.aa.f230980i.z("av_channel_listen_start", GuildCounterNames.GUILD_LISTEN, O0(0, "av_channel_listen_start"), true);
                return;
            }
            return;
        }
        QLog.d("QGMC.MediaListen.ListenHelper", 1, "startMusic null");
    }

    public final void g1() {
        this.trtcCloud.p(this.musicPlayId);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        super.p();
        E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        U0();
        this.curPlayStatus = 0;
        this.markSelfChangeVolume = false;
        this.curPlayId = "";
        this.needRetry = true;
        this.isSelfCaptain = false;
        this.trtcCloud.n(null);
        this.trtcCloud.p(this.musicPlayId);
        this.musicVolume = 30;
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).deleteObserver(this.gProObserver);
        this.core.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.e.class, this.bizNodeUpdateObserver);
    }
}
