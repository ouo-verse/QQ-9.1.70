package com.tencent.qqnt.kernel.api.impl;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.api.impl.GuildMsgService;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildBinaryDataCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildGroupBubbleCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestGetMsgAbstractsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGuildMatchedOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MatchKey;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SceneInfoParam;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001SB\u0019\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J,\u0010\u0019\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J4\u0010\u001b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J<\u0010\u001f\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u001e\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u001cj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016JB\u0010(\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020#0\u001cj\b\u0012\u0004\u0012\u00020#`\u001d2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J\u001c\u0010*\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010+\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J\"\u0010.\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010-H\u0016J\"\u00100\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020 H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020 H\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u00101\u001a\u00020 H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020 H\u0016J,\u0010:\u001a\u00020\u00062\"\u00109\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020706j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u000207`8H\u0016J$\u0010=\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u0001072\u0010\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u00010\u001cH\u0016J\u0012\u0010>\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010A\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016J0\u0010D\u001a\u00020\u00062\u0006\u0010;\u001a\u0002072\f\u0010<\u001a\b\u0012\u0004\u0012\u0002070\u001c2\u0006\u0010B\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010CH\u0016J<\u0010I\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010HH\u0016J2\u0010L\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020J0\u001cj\b\u0012\u0004\u0012\u00020J`\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010'H\u0016\u00a8\u0006T"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/GuildMsgService;", "Lcom/tencent/qqnt/kernel/api/impl/GuildMsgBaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGuildMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGuildMsgService;", "Lcom/tencent/qqnt/kernel/api/t;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z4", "startGuildMsgSync", "Lcom/tencent/qqnt/kernel/nativeinterface/MatchKey;", "matchKey", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuildMatchedOperateCallback;", "result", "isGuildChannelSync", "", WSPublicAccReport.SOP_NAME_FOCUS, "setFocusOnGuild", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "beginSeq", "endSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "cb", "getMsgsBySeqRange", "callbackInMainThread", ICustomDataEditor.STRING_ARRAY_PARAM_5, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "seqList", "getMsgsBySeqList", "", "scenes", "onScenesChangeForSilenceMode", "Lcom/tencent/qqnt/kernel/nativeinterface/SceneInfoParam;", "sceneInfo", "isLocal", "isDelete", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "setGroupGuildMsgRead", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildBinaryDataCallback;", "getGuildGroupTransData", "setGroupGuildBubbleRead", "needFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGuildGroupBubbleCallback;", "getGuildGroupBubble", "needSummary", "fetchGroupGuildUnread", "flag", "setGroupGuildFlag", "setGuildUDCFlag", "setGuildTabUserFlag", "setBuildMode", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", "setConfigurationServiceData", "guildId", "channelIds", "refreshMsgAbstracts", "getChannelFreqLimitInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "insertGameResultAsMsgToDb", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestGetMsgAbstractsCallback;", "getGuestMsgAbstracts", "startSeq", "cnt", "queryOrder", "Lcom/tencent/qqnt/kernel/nativeinterface/IGuestMsgOperateCallback;", "getGuestMsgByRange", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "sendSummonMsg", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGuildMsgService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildMsgService extends GuildMsgBaseService<IKernelGuildMsgListener, IKernelGuildMsgService> implements com.tencent.qqnt.kernel.api.t {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/GuildMsgService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.GuildMsgService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000]\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006H\u0016J$\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0018\u001a\u00020\u00042\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0006\u0018\u00010\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u001dH\u0016\u00a8\u0006\u001f"}, d2 = {"com/tencent/qqnt/kernel/api/impl/GuildMsgService$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGuildMsgListener;", "", "flag", "", "onRecvUDCFlag", "Ljava/util/ArrayList;", "", "msgBuf", "onRecvS2CMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/FirstViewGroupGuildInfo;", "firstViewGroupGuildInfos", "onFirstViewGroupGuildMapping", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "bFind", "Lcom/tencent/qqnt/kernel/nativeinterface/FreqLimitInfo;", "freqLimitInfo", "onChannelFreqLimitInfoUpdate", "Ljava/util/HashMap;", "", "", "channelMsgIds", "onMsgEventListUpdate", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGuildNotifyInfo;", "notifyInfo", "onGroupGuildUpdate", "onRecvGroupGuildFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildMsgAbFlag;", "onGuildMsgAbFlagChanged", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IKernelGuildMsgListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IKernelGuildMsgListener f357246b;

        b(IKernelGuildMsgListener iKernelGuildMsgListener) {
            this.f357246b = iKernelGuildMsgListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, (Object) iKernelGuildMsgListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(IKernelGuildMsgListener listener, Contact contact, boolean z16, FreqLimitInfo freqLimitInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onChannelFreqLimitInfoUpdate(contact, z16, freqLimitInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(IKernelGuildMsgListener listener, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onFirstViewGroupGuildMapping(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(IKernelGuildMsgListener listener, GroupGuildNotifyInfo groupGuildNotifyInfo) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onGroupGuildUpdate(groupGuildNotifyInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(IKernelGuildMsgListener listener, GuildMsgAbFlag guildMsgAbFlag) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onGuildMsgAbFlagChanged(guildMsgAbFlag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(IKernelGuildMsgListener listener, HashMap hashMap) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onMsgEventListUpdate(hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(IKernelGuildMsgListener listener, int i3) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onRecvGroupGuildFlag(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(IKernelGuildMsgListener listener, ArrayList arrayList) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onRecvS2CMsg(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(IKernelGuildMsgListener listener, int i3) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onRecvUDCFlag(i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onChannelFreqLimitInfoUpdate(@Nullable final Contact peer, final boolean bFind, @Nullable final FreqLimitInfo freqLimitInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, peer, Boolean.valueOf(bFind), freqLimitInfo);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ii
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.i(IKernelGuildMsgListener.this, peer, bFind, freqLimitInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onFirstViewGroupGuildMapping(@Nullable final ArrayList<FirstViewGroupGuildInfo> firstViewGroupGuildInfos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) firstViewGroupGuildInfos);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ij
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.j(IKernelGuildMsgListener.this, firstViewGroupGuildInfos);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onGroupGuildUpdate(@Nullable final GroupGuildNotifyInfo notifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) notifyInfo);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ik
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.k(IKernelGuildMsgListener.this, notifyInfo);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onGuildMsgAbFlagChanged(@Nullable final GuildMsgAbFlag flag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) flag);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ih
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.l(IKernelGuildMsgListener.this, flag);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onMsgEventListUpdate(@Nullable final HashMap<String, ArrayList<Long>> channelMsgIds) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) channelMsgIds);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.in
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.m(IKernelGuildMsgListener.this, channelMsgIds);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onRecvGroupGuildFlag(final int flag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, flag);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.il
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.n(IKernelGuildMsgListener.this, flag);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onRecvS2CMsg(@Nullable final ArrayList<Byte> msgBuf) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgBuf);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.im
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.o(IKernelGuildMsgListener.this, msgBuf);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgListener
        public void onRecvUDCFlag(final int flag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, flag);
                return;
            }
            GuildMsgService guildMsgService = GuildMsgService.this;
            final IKernelGuildMsgListener iKernelGuildMsgListener = this.f357246b;
            guildMsgService.postHandleWithLoginCheck(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ig
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgService.b.p(IKernelGuildMsgListener.this, flag);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgService(@Nullable IKernelGuildMsgService iKernelGuildMsgService, @NotNull py content) {
        super("GuildMsgService", content, iKernelGuildMsgService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelGuildMsgService, (Object) content);
        }
    }

    @NotNull
    public final IKernelGuildMsgListener Z4(@NotNull IKernelGuildMsgListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IKernelGuildMsgListener) iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new b(listener);
    }

    public void a5(@Nullable final Contact peer, final long beginSeq, final long endSeq, boolean callbackInMainThread, @Nullable IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, peer, Long.valueOf(beginSeq), Long.valueOf(endSeq), Boolean.valueOf(callbackInMainThread), cb5);
        } else {
            J4("getMsgsBySeqRange", cb5, callbackInMainThread, new Function1<IMsgOperateCallback, Unit>(peer, beginSeq, endSeq) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$getMsgsBySeqRange$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $beginSeq;
                final /* synthetic */ long $endSeq;
                final /* synthetic */ Contact $peer;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$peer = peer;
                    this.$beginSeq = beginSeq;
                    this.$endSeq = endSeq;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, peer, Long.valueOf(beginSeq), Long.valueOf(endSeq));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IMsgOperateCallback iMsgOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iMsgOperateCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getMsgsBySeqRange(this.$peer, this.$beginSeq, this.$endSeq, iMsgOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void fetchGroupGuildUnread(@NotNull final Contact peer, final boolean needSummary, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, peer, Boolean.valueOf(needSummary), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            check("fetchGroupGuildUnread", cb5, new Function1<IOperateCallback, Unit>(peer, needSummary) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$fetchGroupGuildUnread$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $needSummary;
                final /* synthetic */ Contact $peer;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$peer = peer;
                    this.$needSummary = needSummary;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, peer, Boolean.valueOf(needSummary));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.fetchGroupGuildUnread(this.$peer, this.$needSummary, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void getChannelFreqLimitInfo(@Nullable final Contact peer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) peer);
        } else {
            check("getChannelFreqLimitInfo", new Function0<Unit>(peer) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$getChannelFreqLimitInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Contact $peer;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$peer = peer;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, (Object) peer);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getChannelFreqLimitInfo(this.$peer);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void getGuestMsgAbstracts(@NotNull final String guildId, @NotNull final ArrayList<String> channelIds, final int random, @Nullable IGuestGetMsgAbstractsCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, guildId, channelIds, Integer.valueOf(random), result);
            return;
        }
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        F4("getGuestMsgAbstracts", result, new Function1<IGuestGetMsgAbstractsCallback, Unit>(guildId, channelIds, random) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$getGuestMsgAbstracts$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $channelIds;
            final /* synthetic */ String $guildId;
            final /* synthetic */ int $random;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$guildId = guildId;
                this.$channelIds = channelIds;
                this.$random = random;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, guildId, channelIds, Integer.valueOf(random));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGuestGetMsgAbstractsCallback);
                }
                IKernelGuildMsgService service = GuildMsgService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getGuestMsgAbstracts(this.$guildId, this.$channelIds, this.$random, iGuestGetMsgAbstractsCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void getGuestMsgByRange(@Nullable final Contact peer, final long startSeq, final int cnt, final boolean queryOrder, final int random, @Nullable IGuestMsgOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, peer, Long.valueOf(startSeq), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), Integer.valueOf(random), result);
        } else {
            G4("getGuestMsgByRange", result, new Function1<IGuestMsgOperateCallback, Unit>(peer, startSeq, cnt, queryOrder, random) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$getGuestMsgByRange$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $cnt;
                final /* synthetic */ Contact $peer;
                final /* synthetic */ boolean $queryOrder;
                final /* synthetic */ int $random;
                final /* synthetic */ long $startSeq;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$peer = peer;
                    this.$startSeq = startSeq;
                    this.$cnt = cnt;
                    this.$queryOrder = queryOrder;
                    this.$random = random;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, peer, Long.valueOf(startSeq), Integer.valueOf(cnt), Boolean.valueOf(queryOrder), Integer.valueOf(random));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGuestMsgOperateCallback iGuestMsgOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGuestMsgOperateCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGuestMsgByRange(this.$peer, this.$startSeq, this.$cnt, this.$queryOrder, this.$random, iGuestMsgOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void getGuildGroupBubble(@NotNull final Contact peer, final boolean needFetch, @Nullable IGetGuildGroupBubbleCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, peer, Boolean.valueOf(needFetch), cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            E4("getGuildGroupBubble", cb5, new Function1<IGetGuildGroupBubbleCallback, Unit>(peer, needFetch) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$getGuildGroupBubble$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $needFetch;
                final /* synthetic */ Contact $peer;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$peer = peer;
                    this.$needFetch = needFetch;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, peer, Boolean.valueOf(needFetch));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGuildGroupBubbleCallback iGetGuildGroupBubbleCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGuildGroupBubbleCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGuildGroupBubble(this.$peer, this.$needFetch, iGetGuildGroupBubbleCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void getGuildGroupTransData(@Nullable final Contact peer, @Nullable IGetGuildBinaryDataCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) peer, (Object) cb5);
        } else {
            check("getGuildGroupTransData", cb5, new Function1<IGetGuildBinaryDataCallback, Unit>(peer) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$getGuildGroupTransData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Contact $peer;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$peer = peer;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, (Object) peer);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGuildBinaryDataCallback iGetGuildBinaryDataCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGuildBinaryDataCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGuildGroupTransData(this.$peer, iGetGuildBinaryDataCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void getMsgsBySeqList(@Nullable final Contact peer, @Nullable final ArrayList<Long> seqList, @Nullable IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, peer, seqList, cb5);
        } else {
            I4("getMsgsBySeqList", cb5, new Function1<IMsgOperateCallback, Unit>(peer, seqList) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$getMsgsBySeqList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Contact $peer;
                final /* synthetic */ ArrayList<Long> $seqList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$peer = peer;
                    this.$seqList = seqList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, peer, seqList);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IMsgOperateCallback iMsgOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iMsgOperateCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getMsgsBySeqList(this.$peer, this.$seqList, iMsgOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void getMsgsBySeqRange(@Nullable Contact peer, long beginSeq, long endSeq, @Nullable IMsgOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, peer, Long.valueOf(beginSeq), Long.valueOf(endSeq), cb5);
        } else {
            a5(peer, beginSeq, endSeq, true, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void insertGameResultAsMsgToDb(@Nullable final MsgRecord msg2, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) msg2, (Object) cb5);
        } else {
            check("insertGameResultAsMsgToDb", cb5, new Function1<IOperateCallback, Unit>(msg2) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$insertGameResultAsMsgToDb$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ MsgRecord $msg;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$msg = msg2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, (Object) msg2);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.insertGameResultAsMsgToDb(this.$msg, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void isGuildChannelSync(@Nullable final MatchKey matchKey, @Nullable final IGuildMatchedOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) matchKey, (Object) result);
        } else {
            H4("isGuildChannelSync", result, new Function1<IGuildMatchedOperateCallback, Unit>(matchKey, result) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$isGuildChannelSync$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ MatchKey $matchKey;
                final /* synthetic */ IGuildMatchedOperateCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$matchKey = matchKey;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, matchKey, result);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGuildMatchedOperateCallback iGuildMatchedOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGuildMatchedOperateCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.isGuildChannelSync(this.$matchKey, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void onScenesChangeForSilenceMode(final int scenes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, scenes);
        } else {
            check("onScenesChangeForSilenceMode", new Function0<Unit>(scenes) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$onScenesChangeForSilenceMode$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $scenes;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$scenes = scenes;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, scenes);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.onScenesChangeForSilenceMode(this.$scenes);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void q(@NotNull IKernelGuildMsgListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            addListener(listener, new Function1<IKernelGuildMsgListener, Long>() { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$addGuildMsgListener$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Long invoke(@NotNull IKernelGuildMsgListener it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service != null) {
                        return Long.valueOf(service.addKernelGuildMsgListener(GuildMsgService.this.Z4(it)));
                    }
                    return null;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void refreshMsgAbstracts(@Nullable final String guildId, @Nullable final ArrayList<String> channelIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) guildId, (Object) channelIds);
        } else {
            check("refreshMsgAbstracts", new Function0<Unit>(guildId, channelIds) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$refreshMsgAbstracts$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<String> $channelIds;
                final /* synthetic */ String $guildId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$guildId = guildId;
                    this.$channelIds = channelIds;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, guildId, channelIds);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.refreshMsgAbstracts(this.$guildId, this.$channelIds);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void sendSummonMsg(@NotNull final Contact peer, @NotNull final ArrayList<MsgElement> msgElements, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, peer, msgElements, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        check("sendSummonMsg", cb5, new Function1<IOperateCallback, Unit>(peer, msgElements) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$sendSummonMsg$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<MsgElement> $msgElements;
            final /* synthetic */ Contact $peer;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$peer = peer;
                this.$msgElements = msgElements;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, peer, msgElements);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelGuildMsgService service = GuildMsgService.this.getService();
                if (service == null) {
                    return null;
                }
                service.sendSummonMsg(this.$peer, this.$msgElements, new HashMap<>(), iOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setBuildMode(final int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, flag);
        } else {
            check("setBuildMode", new Function0<Unit>(flag) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setBuildMode$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $flag;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$flag = flag;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, flag);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setBuildMode(this.$flag);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setConfigurationServiceData(@NotNull final HashMap<Long, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) map);
        } else {
            Intrinsics.checkNotNullParameter(map, "map");
            check("SetConfigurationServiceData", new Function0<Unit>(map) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setConfigurationServiceData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ HashMap<Long, String> $map;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$map = map;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, (Object) map);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setConfigurationServiceData(this.$map);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setFocusOnGuild(final boolean focus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, focus);
        } else {
            check("setFocusOnGuild", new Function0<Unit>(focus) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setFocusOnGuild$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $focus;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$focus = focus;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, Boolean.valueOf(focus));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setFocusOnGuild(this.$focus);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setGroupGuildBubbleRead(@NotNull final Contact peer, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) peer, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            check("setGroupGuildBubbleRead", cb5, new Function1<IOperateCallback, Unit>(peer) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setGroupGuildBubbleRead$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Contact $peer;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$peer = peer;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, (Object) peer);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGroupGuildBubbleRead(this.$peer, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setGroupGuildFlag(final int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, flag);
        } else {
            check("setGroupGuildFlag", new Function0<Unit>(flag) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setGroupGuildFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $flag;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$flag = flag;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, flag);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGroupGuildFlag(this.$flag);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setGroupGuildMsgRead(@NotNull final Contact peer, @NotNull final ArrayList<SceneInfoParam> sceneInfo, final boolean isLocal, final boolean isDelete, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, peer, sceneInfo, Boolean.valueOf(isLocal), Boolean.valueOf(isDelete), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(sceneInfo, "sceneInfo");
        check("setGroupGuildMsgRead", cb5, new Function1<IOperateCallback, Unit>(peer, sceneInfo, isLocal, isDelete) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setGroupGuildMsgRead$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $isDelete;
            final /* synthetic */ boolean $isLocal;
            final /* synthetic */ Contact $peer;
            final /* synthetic */ ArrayList<SceneInfoParam> $sceneInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$peer = peer;
                this.$sceneInfo = sceneInfo;
                this.$isLocal = isLocal;
                this.$isDelete = isDelete;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GuildMsgService.this, peer, sceneInfo, Boolean.valueOf(isLocal), Boolean.valueOf(isDelete));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelGuildMsgService service = GuildMsgService.this.getService();
                if (service == null) {
                    return null;
                }
                service.setGroupGuildMsgRead(this.$peer, this.$sceneInfo, this.$isLocal, this.$isDelete, iOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setGuildTabUserFlag(final int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, flag);
        } else {
            check("setGuildTabUserFlag", new Function0<Unit>(flag) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setGuildTabUserFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $flag;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$flag = flag;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, flag);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGuildTabUserFlag(this.$flag);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void setGuildUDCFlag(final int flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, flag);
        } else {
            check("setGuildUDCFlag", new Function0<Unit>(flag) { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$setGuildUDCFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $flag;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$flag = flag;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this, flag);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setGuildUDCFlag(this.$flag);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.t
    public void startGuildMsgSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            check("startGuildMsgSync", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.GuildMsgService$startGuildMsgSync$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildMsgService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelGuildMsgService service = GuildMsgService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.startGuildMsgSync();
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
