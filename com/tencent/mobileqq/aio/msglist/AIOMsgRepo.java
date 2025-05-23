package com.tencent.mobileqq.aio.msglist;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.factory.C2CAIOFactory;
import com.tencent.mobileqq.aio.factory.param.o;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgSimpleInfo;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext;
import com.tencent.mobileqq.aio.msglist.msgprocessor.ClickPushMsgProcessor;
import com.tencent.mobileqq.aio.msglist.msgrepo.AccessibilityMsgRepo;
import com.tencent.mobileqq.aio.msglist.msgrepo.AvatarAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.BgTextColorAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.ConfigChangeAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.GagModeChangeAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.LongShotAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.MsgEliminateAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.MsgLocationAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.MsgMosaicAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.MsgNotificationAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.MultiSelectAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.NickNameAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.ReplySuggestionAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.RichMediaAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.StreamMsgAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.ThemeChangeAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.TofuAuthenticationAbility;
import com.tencent.mobileqq.aio.msglist.msgrepo.UnreadMsgNotifyAbility;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.aio.utils.ac;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.impl.AIOMsgProcessManagerImpl;
import com.tencent.qqnt.aio.nick.MemberLevelInfoCache;
import com.tencent.qqnt.chathistory.api.IMsgMigrationApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GetMsgsStatusEnum;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgsReq;
import com.tencent.qqnt.kernel.nativeinterface.RoamDatemsg;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import defpackage.MsgListUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u0096\u00012\u00020\u0001:\u0001?B3\u0012\u0006\u0010]\u001a\u00020Z\u0012\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001\u0012\f\u0010b\u001a\b\u0012\u0004\u0012\u00020_0^\u0012\b\u0010e\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u0017\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010\u001d\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0004H\u0002J\u001e\u0010&\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010%\u001a\u00020\u0018H\u0002JB\u0010/\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0'2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-H\u0002J\b\u00100\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0002H\u0016J\b\u00102\u001a\u00020\u0002H\u0016J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\b032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b03H\u0016J\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\b0'2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0'H\u0016J\u0010\u0010:\u001a\u00020\u00022\u0006\u00109\u001a\u000208H\u0016J\u0006\u0010;\u001a\u00020\u001aJ\b\u0010<\u001a\u00020\u0002H\u0016J\u0006\u0010=\u001a\u00020\u0004J\u0006\u0010>\u001a\u00020\u0002J\b\u0010?\u001a\u00020\u0002H\u0016J\u0010\u0010@\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u001aH\u0016J\u0018\u0010C\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u001aH\u0016J(\u0010G\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00182\b\u0010D\u001a\u0004\u0018\u00010-2\u0006\u0010F\u001a\u00020EJ \u0010H\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020-2\b\b\u0002\u0010#\u001a\u00020\u0004J\b\u0010I\u001a\u00020\u0002H\u0016J4\u0010K\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u0004J\u0018\u0010L\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u0004J\u0016\u0010M\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0014J\u0014\u0010N\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\b0'J\u0010\u0010P\u001a\u00020\u00022\u0006\u0010O\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0018H\u0016J\b\u0010R\u001a\u00020\u0018H\u0016J*\u0010V\u001a\u00020-2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020\u00042\n\b\u0002\u0010U\u001a\u0004\u0018\u00010TJ\u0016\u0010Y\u001a\u00020-2\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u0004R\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020_0^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR$\u0010l\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001e\u0010p\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u00048\u0002@BX\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010oR\u0016\u0010~\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010rR3\u0010\u0086\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0080\u00010\u007fj\n\u0012\u0005\u0012\u00030\u0080\u0001`\u0081\u00018TX\u0094\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010oR:\u0010\u008d\u0001\u001a\u001d\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0089\u00010\u007fj\u000e\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0089\u0001`\u0081\u00018\u0014X\u0094\u0004\u00a2\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u0085\u0001R \u0010\u0091\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u0083\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "", "R0", "", "successDbMs", "w1", "Lcom/tencent/mobileqq/aio/msg/service/p;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "Z0", "Lcom/tencent/mobileqq/aio/factory/param/o;", "useDelegate", "q1", "firstLoad", "p1", "h1", "r1", "Lcom/tencent/aio/data/AIOContact;", "contact", "j1", "Lcom/tencent/aio/msgservice/h;", "needContinueGetMsg", ICustomDataEditor.STRING_ARRAY_PARAM_1, "", "X0", "", "reqMsgId", PreDownloadConstants.RPORT_KEY_REQ_TIME, "e1", "Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;", "statusEnum", "y1", "Lcom/tencent/qqnt/kernel/nativeinterface/RoamDatemsg;", "roamDatemsg", "ignoreErrCode", "k1", "count", "A1", "", TabPreloadItem.TAB_NAME_MESSAGE, "msgSeq", "msgId", "msgTime", "forceFlush", "Landroid/os/Bundle;", "extrs", "c1", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "L", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "list", "b", "displayList", "k", "", "source", "i", "Q0", "e", "f1", "x1", "a", tl.h.F, "beginMsgSeq", "endMsgSeq", "f", "extra", "Lcom/tencent/mobileqq/aio/event/MsgNavigationEvent$NavigateBySeqEvent;", "intent", "t1", "u1", "o", "includeDeleteMsg", "l1", ICustomDataEditor.NUMBER_PARAM_1, "g1", "i1", "headElimination", "T", "P0", "W0", "needFlush", "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "replyMsgInfo", "U0", "checkCurrentFocus", "scrollAnimation", "Y0", "Lcom/tencent/aio/api/runtime/a;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/y;", "t", "Ljava/lang/ref/WeakReference;", "weakMsgListVMApi", "u", "Lcom/tencent/mobileqq/aio/factory/param/o;", "msgDelegate", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;", "getGetMsgsAndImportStatus", "()Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;", "setGetMsgsAndImportStatus", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetMsgsStatusEnum;)V", "getMsgsAndImportStatus", "<set-?>", "w", "Z", "hasLatestMsg", HippyTKDListViewAdapter.X, "J", "mFirstUnreadSeq", "y", "Lcom/tencent/aio/data/msglist/a;", "mEnterLatestMsg", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtoptip/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtoptip/b;", "mNewMsgTipHelper", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "firstPull", "B", "msgReqTime", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "S0", "()Ljava/util/ArrayList;", "mMsgProcessors", "D", "mHasFocusBottom", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "E", "Ljava/util/ArrayList;", "k0", "msgRepoAbilityList", UserInfo.SEX_FEMALE, "T0", "()Z", "msgReqTimeCheckSwitch", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/ref/WeakReference;Lcom/tencent/mobileqq/aio/factory/param/o;)V", "G", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOMsgRepo extends BaseMsgRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: A, reason: from kotlin metadata */
    private boolean firstPull;

    /* renamed from: B, reason: from kotlin metadata */
    private long msgReqTime;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMsgProcessors;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mHasFocusBottom;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.aio.msglist.msgrepo.g<?>> msgRepoAbilityList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgReqTimeCheckSwitch;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<y> weakMsgListVMApi;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.factory.param.o msgDelegate;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GetMsgsStatusEnum getMsgsAndImportStatus;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean hasLatestMsg;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private long mFirstUnreadSeq;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a mEnterLatestMsg;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.b mNewMsgTipHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.AIOMsgRepo$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58115);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgRepo(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull final CoroutineScope scope, @NotNull WeakReference<y> weakMsgListVMApi, @Nullable com.tencent.mobileqq.aio.factory.param.o oVar) {
        super(aioContext, scope);
        Lazy lazy;
        ArrayList<com.tencent.mobileqq.aio.msglist.msgrepo.g<?>> arrayListOf;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(weakMsgListVMApi, "weakMsgListVMApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aioContext, scope, weakMsgListVMApi, oVar);
            return;
        }
        this.aioContext = aioContext;
        this.weakMsgListVMApi = weakMsgListVMApi;
        this.msgDelegate = oVar;
        this.hasLatestMsg = true;
        this.mFirstUnreadSeq = -1L;
        this.mNewMsgTipHelper = new com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.b();
        this.firstPull = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<AbsAIOMsgProcessor>>(scope) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgRepo$mMsgProcessors$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ CoroutineScope $scope;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$scope = scope;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgRepo.this, (Object) scope);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<AbsAIOMsgProcessor> invoke() {
                com.tencent.aio.api.runtime.a aVar;
                com.tencent.aio.api.runtime.a aVar2;
                com.tencent.aio.api.runtime.a aVar3;
                com.tencent.aio.api.runtime.a aVar4;
                com.tencent.aio.api.runtime.a aVar5;
                com.tencent.aio.api.runtime.a aVar6;
                com.tencent.aio.api.runtime.a aVar7;
                com.tencent.aio.api.runtime.a aVar8;
                com.tencent.aio.api.runtime.a aVar9;
                com.tencent.aio.api.runtime.a aVar10;
                com.tencent.aio.api.runtime.a aVar11;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ArrayList<AbsAIOMsgProcessor> arrayList = new ArrayList<>();
                AIOMsgRepo aIOMsgRepo = AIOMsgRepo.this;
                CoroutineScope coroutineScope = this.$scope;
                aVar = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.g(aVar, coroutineScope));
                aVar2 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.h(aVar2, coroutineScope));
                aVar3 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.b(aVar3, coroutineScope));
                aVar4 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.a(aVar4, coroutineScope));
                aVar5 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.f(aVar5, coroutineScope));
                aVar6 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.i(aVar6, coroutineScope));
                aVar7 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.d(aVar7, coroutineScope));
                aVar8 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.c(aVar8, coroutineScope));
                AIOMsgProcessManagerImpl a16 = AIOMsgProcessManagerImpl.INSTANCE.a();
                aVar9 = aIOMsgRepo.aioContext;
                arrayList.addAll(a16.create(aVar9, coroutineScope));
                aVar10 = aIOMsgRepo.aioContext;
                arrayList.add(new com.tencent.mobileqq.aio.msglist.msgprocessor.e(aVar10, coroutineScope));
                aVar11 = aIOMsgRepo.aioContext;
                arrayList.add(new ClickPushMsgProcessor(aVar11, coroutineScope));
                return arrayList;
            }
        });
        this.mMsgProcessors = lazy;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new MsgEliminateAbility(this, D(), scope), new NickNameAbility(this, D(), scope), new BgTextColorAbility(this, D(), scope), new GagModeChangeAbility(this, D(), scope), new com.tencent.mobileqq.aio.msglist.msgrepo.e(this, D(), scope), new TofuAuthenticationAbility(this, D(), scope), new AvatarAbility(this, D(), scope), new MsgNotificationAbility(this, D(), scope), new RichMediaAbility(this, D(), scope), new MsgMosaicAbility(this, D(), scope), new UnreadMsgNotifyAbility(this, D(), scope), new MsgLocationAbility(this, D(), scope), new com.tencent.mobileqq.aio.msglist.msgrepo.c(this, D(), scope), new com.tencent.mobileqq.aio.msglist.msgrepo.y(this, D(), scope), new com.tencent.mobileqq.aio.msglist.msgrepo.a(this, D(), scope), new ConfigChangeAbility(this, D(), scope), new StreamMsgAbility(this, D(), scope), new LongShotAbility(this, D(), scope), new MultiSelectAbility(this, D(), scope), new com.tencent.mobileqq.aio.msglist.msgrepo.k(this, D(), scope), new ThemeChangeAbility(this, D(), scope), new ReplySuggestionAbility(this, D(), scope), new com.tencent.mobileqq.aio.msglist.msgrepo.b(this, D(), scope));
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            arrayListOf.add(new AccessibilityMsgRepo(this, D(), scope));
        }
        this.msgRepoAbilityList = arrayListOf;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOMsgRepo$msgReqTimeCheckSwitch$2.INSTANCE);
        this.msgReqTimeCheckSwitch = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, int count) {
        boolean z16;
        if (rsp.d()) {
            if (rsp.a().size() < count) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.hasLatestMsg = z16;
            QLog.d("AIOMsgRepo", 1, "updateHasLatestMsg hasLatestMsg=" + z16 + " size=" + rsp.a().size());
        }
    }

    private final void R0() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.j(com.tencent.mobileqq.aio.utils.o.b(D().g().r().c())), new AIOMsgRepo$getFirstUnreadMsgSeq$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T0() {
        return ((Boolean) this.msgReqTimeCheckSwitch.getValue()).booleanValue();
    }

    public static /* synthetic */ Bundle V0(AIOMsgRepo aIOMsgRepo, long j3, long j16, boolean z16, MsgSimpleInfo msgSimpleInfo, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 8) != 0) {
                msgSimpleInfo = null;
            }
            return aIOMsgRepo.U0(j3, j16, z16, msgSimpleInfo);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNavigationBundle");
    }

    private final int X0() {
        if (this.firstPull) {
            this.firstPull = false;
            return P0();
        }
        return 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(com.tencent.mobileqq.aio.msg.service.p<com.tencent.aio.data.msglist.a> rsp, boolean successDbMs) {
        boolean z16;
        QLog.i("AIOMsgRepo", 1, "handleFirstPage, succ = " + rsp.d() + ", data size = " + rsp.a().size() + ", status = " + rsp.e());
        if (rsp.d()) {
            this.getMsgsAndImportStatus = rsp.e();
            this.hasLatestMsg = true;
            QLog.d("AIOMsgRepo", 1, "handleFirstPage update hasLatestMsg=true");
        }
        com.tencent.qqnt.trace.a aVar = com.tencent.qqnt.trace.a.f362326a;
        if (rsp.d() && (!rsp.a().isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.c("handleFirstPage success=" + z16 + ", successDbMs=" + successDbMs);
        if (rsp.d() && (!rsp.a().isEmpty())) {
            MsgList M = M();
            M.clear();
            M.addAllWithFilter(rsp.a());
            l0(rsp.a());
            p0(IMsgListRepository.MsgListRepoOpType.LoadFirst, M(), Y0(true, false), "handle_first_page");
            if (!successDbMs) {
                aVar.e("NOTIFY_DATA");
            }
            a.f190445a.a(rsp.a(), "FirstRoam");
        } else {
            p0(IMsgListRepository.MsgListRepoOpType.LoadFirst, M(), null, "handle_first_page");
        }
        g1(rsp);
        D().e().h(AIOMsgEvent.GetFirstMsgEndEvent.f188270d);
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).h(rsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, boolean firstLoad, boolean needContinueGetMsg) {
        AIOContact aIOContact;
        boolean z16;
        List<? extends com.tencent.aio.data.msglist.a> list;
        AIOSession r16 = this.aioContext.g().r();
        if (r16 != null) {
            aIOContact = r16.c();
        } else {
            aIOContact = null;
        }
        Intrinsics.checkNotNull(aIOContact);
        if (j1(aIOContact)) {
            QLog.d("AIOMsgRepo", 1, "[handleGetLatestDbMsgs] current not load first latest msg.");
            return;
        }
        QLog.i("AIOMsgRepo", 1, "[handleGetLatestDbMsgs], firstLoad=" + firstLoad + " succ=" + rsp.d() + " dataSize=" + rsp.a().size());
        if (rsp.d()) {
            this.hasLatestMsg = true;
            QLog.d("AIOMsgRepo", 1, "handleGetLatestDbMsgs update hasLatestMsg=true");
        }
        com.tencent.qqnt.trace.a aVar = com.tencent.qqnt.trace.a.f362326a;
        if (rsp.d() && (!rsp.a().isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.c("handleGetLatestDbMsgs success=" + z16);
        if (rsp.d() && (!rsp.a().isEmpty())) {
            MsgList M = M();
            M.clear();
            M.addAll(rsp.a());
            l0(rsp.a());
            Bundle Y0 = Y0(!firstLoad, false);
            Y0.putBoolean("need_continue_get_msg", needContinueGetMsg);
            p0(IMsgListRepository.MsgListRepoOpType.LoadFirst, M, Y0, "get_last_db");
            if (firstLoad) {
                aVar.e("NOTIFY_DATA");
                ac acVar = ac.f194103a;
                com.tencent.aio.api.runtime.a D = D();
                list = CollectionsKt___CollectionsKt.toList(M);
                acVar.b(D, list);
            }
        } else if (rsp.a().isEmpty()) {
            this.aioContext.e().h(new AIOMsgListEvent.EmptyMsgList(needContinueGetMsg));
        }
        g1(rsp);
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).i(rsp);
        }
        a.f190445a.a(rsp.a(), "LatestDbMsgs");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b1(AIOMsgRepo aIOMsgRepo, com.tencent.aio.msgservice.h hVar, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z17 = false;
            }
            aIOMsgRepo.a1(hVar, z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleGetLatestDbMsgs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(List<? extends com.tencent.aio.data.msglist.a> msgList, long msgSeq, long msgId, long msgTime, boolean forceFlush, Bundle extrs) {
        long j3;
        long j16;
        boolean z16;
        Object first;
        Bundle bundle;
        Object first2;
        boolean z17;
        if (msgList.size() == 0) {
            QLog.i("AIOMsgRepo", 1, "[handleNavigationGetListRsp]: " + QLog.getStackTraceString(new Throwable("msgList is empty")));
            return;
        }
        Iterator<? extends com.tencent.aio.data.msglist.a> it = msgList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getMsgSeq() == msgSeq) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgList);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) first2;
            z16 = forceFlush;
            j16 = aVar.getMsgSeq();
            j3 = aVar.getMsgId();
        } else {
            j3 = msgId;
            j16 = msgSeq;
            z16 = true;
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgList);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) first;
        QLog.i("AIOMsgRepo", 1, "[handleNavigationGetListRsp]: msgSeq is " + msgSeq + ", msgId is " + msgId + ", forceFlush is " + forceFlush + ", index is " + i3 + ", firstMsgSeq is " + aIOMsgItem.getMsgSeq() + ", firstMsgTime is " + aIOMsgItem.getMsgRecord().msgTime);
        MsgList M = M();
        M.clear();
        M.addAll(msgList);
        l0(msgList);
        if (extrs == null) {
            bundle = V0(this, j16, j3, z16, null, 8, null);
        } else {
            bundle = extrs;
        }
        bundle.putLong("navigate_time", msgTime);
        p0(IMsgListRepository.MsgListRepoOpType.LoadFirst, M(), bundle, "msg_navigation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d1(AIOMsgRepo aIOMsgRepo, List list, long j3, long j16, long j17, boolean z16, Bundle bundle, int i3, Object obj) {
        Bundle bundle2;
        if (obj == null) {
            if ((i3 & 32) != 0) {
                bundle2 = null;
            } else {
                bundle2 = bundle;
            }
            aIOMsgRepo.c1(list, j3, j16, j17, z16, bundle2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleNavigationGetListRsp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(com.tencent.mobileqq.aio.msg.service.p<com.tencent.aio.data.msglist.a> rsp, long reqMsgId, long reqTime) {
        Object firstOrNull;
        long j3;
        QLog.i("AIOMsgRepo", 1, "handleTopPage, succ = " + rsp.d() + ", data size = " + rsp.a().size() + ", status = " + rsp.e());
        if (rsp.d()) {
            MsgList M = M();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) M);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            if (aVar != null) {
                j3 = aVar.getMsgId();
            } else {
                j3 = 0;
            }
            if (j3 != reqMsgId) {
                QLog.d("AIOMsgRepo", 1, "handleTopPage not match msgId:" + j3 + ", reqMsgId:" + reqMsgId);
                BaseMsgRepo.o0(this, M, "top_page", IMsgListRepository.MsgListRepoOpType.LoadPrePageFail, null, 8, null);
                return;
            }
            if (reqTime < this.msgReqTime && T0()) {
                QLog.i("AIOMsgRepo", 1, "[handleTopPage]: rsp is not match latest req, req time is " + reqTime);
                BaseMsgRepo.o0(this, M, "top_page", IMsgListRepository.MsgListRepoOpType.LoadPrePage, null, 8, null);
                return;
            }
            this.getMsgsAndImportStatus = rsp.e();
            if (!rsp.a().isEmpty()) {
                M.addAll(0, rsp.a());
                l0(rsp.a());
            }
            QLog.i("AIOMsgRepo", 1, "handleTopPage,  displaylist=" + M.size());
            p0(IMsgListRepository.MsgListRepoOpType.LoadPrePage, M, null, "top_page");
            y1(this.getMsgsAndImportStatus);
            return;
        }
        BaseMsgRepo.o0(this, M(), "top_page", IMsgListRepository.MsgListRepoOpType.LoadPrePageFail, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h1() {
        return Intrinsics.areEqual(this.aioContext.g().n(), C2CAIOFactory.class.getName());
    }

    private final boolean j1(AIOContact contact) {
        if (contact == null || contact.e() != 201) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(RoamDatemsg roamDatemsg, boolean ignoreErrCode) {
        AIOContact c16 = D().g().r().c();
        Contact contact = new Contact(c16.e(), c16.j(), "");
        x1();
        QLog.i("AIOMsgRepo", 1, "[loadMsgByTime]: mcontact is " + contact);
        if (c16.e() == 1) {
            int P0 = P0();
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().j(contact, roamDatemsg.msgTime, roamDatemsg.clientSeq, P0), new AIOMsgRepo$loadFirstPageByRoamDatemsg$1(ignoreErrCode, this, P0, roamDatemsg, null)), zs.b.a(Dispatchers.INSTANCE)), J());
            r1();
        } else if (c16.e() == 2) {
            l1(roamDatemsg.msgSeq, 0L, true, true, ignoreErrCode);
        }
    }

    public static /* synthetic */ void m1(AIOMsgRepo aIOMsgRepo, long j3, long j16, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        boolean z19;
        boolean z26;
        boolean z27;
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z19 = false;
            } else {
                z19 = z16;
            }
            if ((i3 & 8) != 0) {
                z26 = false;
            } else {
                z26 = z17;
            }
            if ((i3 & 16) != 0) {
                z27 = false;
            } else {
                z27 = z18;
            }
            aIOMsgRepo.l1(j3, j16, z19, z26, z27);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadFirstPageBySeq");
    }

    public static /* synthetic */ void o1(AIOMsgRepo aIOMsgRepo, long j3, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            aIOMsgRepo.n1(j3, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadFirstPageByTime");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1(boolean firstLoad) {
        QLog.i("AIOMsgRepo", 1, "[loadFirstPageFromDb] firstLoad=" + firstLoad);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().b(P0(), D().g().r()), new AIOMsgRepo$loadFirstPageFromDb$1(this, firstLoad, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    private final void q1(com.tencent.mobileqq.aio.factory.param.o useDelegate) {
        QLog.i("AIOMsgRepo", 1, "[loadLatestDbMsgs]");
        D().e().h(new AIOMsgListEvent.LoadRoamFirstMsgEvent(1));
        if (useDelegate != null && useDelegate.e()) {
            com.tencent.qqnt.trace.a.f362326a.c("loadLatestDbMsgs1");
            final StopWatch i3 = new StopWatch("loadLatestDbMsgs", false, 2, null).i();
            useDelegate.a(new o.a(this) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgRepo$loadLatestDbMsgs$1
                static IPatchRedirector $redirector_;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ AIOMsgRepo f190430b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f190430b = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) StopWatch.this, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.aio.factory.param.o.a
                public void a(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, boolean needContinueGetMsg, @NotNull List<MsgRecord> remainMsgList) {
                    boolean z16;
                    CoroutineScope J;
                    com.tencent.aio.api.runtime.a D;
                    boolean h16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    boolean z17 = false;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, rsp, Boolean.valueOf(needContinueGetMsg), remainMsgList);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    Intrinsics.checkNotNullParameter(remainMsgList, "remainMsgList");
                    StopWatch.this.e("on load msg");
                    if (remainMsgList.size() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    J = this.f190430b.J();
                    BuildersKt__Builders_commonKt.launch$default(J, zs.b.a(Dispatchers.INSTANCE), null, new AIOMsgRepo$loadLatestDbMsgs$1$onLoad$1(StopWatch.this, this.f190430b, rsp, needContinueGetMsg, z16, null), 2, null);
                    if (!needContinueGetMsg) {
                        D = this.f190430b.D();
                        D.e().h(new AIOMsgListEvent.LoadRoamFirstMsgEvent(2));
                        if (z16) {
                            h16 = this.f190430b.h1();
                            if (h16) {
                                QLog.i("AIOMsgRepo", 1, "loadLatestDbMsgs, load more messages for c2c");
                                this.f190430b.p1(false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    AIOMsgRepo aIOMsgRepo = this.f190430b;
                    if (rsp.d() && (!rsp.a().isEmpty())) {
                        z17 = true;
                    }
                    aIOMsgRepo.w1(z17);
                }
            });
        } else {
            com.tencent.qqnt.trace.a.f362326a.c("loadLatestDbMsgs no Delegate");
            p1(true);
        }
    }

    private final void r1() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().e(1, D().g().r()), new AIOMsgRepo$loadOneLatestDbMsg$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(AIOMsgRepo this$0) {
        Object firstOrNull;
        Long l3;
        Long l16;
        long j3;
        long j16;
        MsgRecord msgRecord;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this$0.M());
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        this$0.msgReqTime = serverTimeMillis;
        AIOMsgItem aIOMsgItem = null;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        if (aVar != null) {
            l16 = Long.valueOf(aVar.getMsgId());
        } else {
            l16 = null;
        }
        QLog.i("AIOMsgRepo", 1, "loadTopPage, topLastMsg seq = " + l3 + ", msgId = " + l16 + ", reqTime = " + serverTimeMillis);
        com.tencent.aio.msgservice.g gVar = new com.tencent.aio.msgservice.g(this$0.D().g().r(), aVar, this$0.X0());
        if (aVar != null) {
            j3 = aVar.getMsgId();
        } else {
            j3 = 0;
        }
        if (aVar instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) aVar;
        }
        if (aIOMsgItem != null && (msgRecord = aIOMsgItem.getMsgRecord()) != null) {
            j16 = msgRecord.getMsgTime();
        } else {
            j16 = 0;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this$0.i0().n(gVar, this$0.Q0(), j16), new AIOMsgRepo$loadPrePage$1$1(this$0, j3, serverTimeMillis, null)), zs.b.a(Dispatchers.INSTANCE)), this$0.J());
    }

    public static /* synthetic */ void v1(AIOMsgRepo aIOMsgRepo, long j3, Bundle bundle, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            aIOMsgRepo.u1(j3, bundle, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadRangePage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(boolean successDbMs) {
        com.tencent.qqnt.trace.a.f362326a.c("loadRoamFirstMsgs");
        long currentTimeMillis = System.currentTimeMillis();
        D().e().h(new AIOMsgListEvent.LoadRoamFirstMsgEvent(3));
        QLog.i("AIOMsgRepo", 1, "[loadRoamFirstMsgs], needContinueGetMsg=true");
        com.tencent.aio.msgservice.c cVar = new com.tencent.aio.msgservice.c(D().g().r(), P0());
        com.tencent.aio.pref.a.f69788j.a("requestService");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().d(cVar, Q0()), new AIOMsgRepo$loadRoamFirstMsgs$1(this, successDbMs, currentTimeMillis, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    private final void y1(GetMsgsStatusEnum statusEnum) {
        int i3;
        com.tencent.qqnt.kernel.api.w msgService;
        Integer dataImportUserLevel;
        if (statusEnum != null) {
            if (statusEnum != GetMsgsStatusEnum.KGETDONEBUTIMPORTING) {
                QLog.i("AIOMsgRepo", 1, "the statusEnum is not KGETDONEBUTIMPORTING");
                return;
            }
            IKernelService i16 = com.tencent.qqnt.msg.f.i();
            if (i16 != null && (msgService = i16.getMsgService()) != null && (dataImportUserLevel = msgService.getDataImportUserLevel()) != null) {
                i3 = dataImportUserLevel.intValue();
            } else {
                i3 = 0;
            }
            int i17 = i3;
            if (i17 != 3) {
                QLog.i("AIOMsgRepo", 1, "the user level is not high");
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOMsgRepo.z1();
                    }
                });
                IMsgMigrationApi.a.a((IMsgMigrationApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMsgMigrationApi.class), "0X800C514", i17, 0, null, null, null, null, 124, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1() {
        QQToast.makeText(BaseApplication.context, R.string.ysa, 0).show();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.L();
            R0();
        }
    }

    public int P0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return 15;
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.Q();
        QLog.i("AIOMsgRepo", 1, "[onCreate]: AIOMsgRepo " + hashCode());
        Iterator<T> it = S0().iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).d();
        }
        this.mHasFocusBottom = false;
        X(120);
    }

    public final long Q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return D().g().l().getLong("key_notify_app_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public ArrayList<AbsAIOMsgProcessor> S0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (ArrayList) this.mMsgProcessors.getValue();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void T(boolean headElimination) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, headElimination);
            return;
        }
        super.T(headElimination);
        if (!headElimination) {
            this.hasLatestMsg = false;
            QLog.d("AIOMsgRepo", 1, "onMsgElimination hasLatestMsg=false");
        }
    }

    @NotNull
    public final Bundle U0(long msgSeq, long msgId, boolean needFlush, @Nullable MsgSimpleInfo replyMsgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Bundle) iPatchRedirector.redirect((short) 29, this, Long.valueOf(msgSeq), Long.valueOf(msgId), Boolean.valueOf(needFlush), replyMsgInfo);
        }
        Bundle bundle = new Bundle();
        if (msgSeq > 0) {
            bundle.putLong("navigate_seq", msgSeq);
        }
        if (msgId > 0) {
            bundle.putLong("navigate_id", msgId);
        }
        bundle.putBoolean(HippyQQPagView.FunctionName.FLUSH, needFlush);
        if (replyMsgInfo != null) {
            bundle.putParcelable("reply_msg_info", replyMsgInfo);
        }
        return bundle;
    }

    public int W0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return 15;
    }

    @NotNull
    public final Bundle Y0(boolean checkCurrentFocus, boolean scrollAnimation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Bundle) iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(checkCurrentFocus), Boolean.valueOf(scrollAnimation));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("set_bottom", true);
        bundle.putBoolean("check_current_focus", checkCurrentFocus);
        bundle.putBoolean("scroll_animation", scrollAnimation);
        return bundle;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
        Object lastOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) M());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
            AIOUtil.f194084a.h(D().g().r());
            if (aVar != null) {
                j3 = aVar.getMsgId();
            } else {
                j3 = 0;
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            QLog.d("AIOMsgRepo", 1, "[loadNextPage]: reqMsgId is " + j3 + ", reqTime is " + serverTimeMillis);
            this.msgReqTime = serverTimeMillis;
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().g(new com.tencent.aio.msgservice.f(D().g().r(), j3, 28, false)), new AIOMsgRepo$loadNextPage$1(this, j3, serverTimeMillis, 28, null)), zs.b.a(Dispatchers.INSTANCE)), J());
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Collection) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        MsgList M = M();
        if (M.isEmpty()) {
            return list;
        }
        HashSet hashSet = new HashSet();
        Iterator<com.tencent.aio.data.msglist.a> it = M.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(it.next().getMsgId()));
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.q
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgRepo.s1(AIOMsgRepo.this);
                }
            }, null, 2, null);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void f(long beginMsgSeq, long endMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(beginMsgSeq), Long.valueOf(endMsgSeq));
        }
    }

    public final boolean f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        GetMsgsStatusEnum getMsgsStatusEnum = this.getMsgsAndImportStatus;
        if (getMsgsStatusEnum != null) {
            if (getMsgsStatusEnum == GetMsgsStatusEnum.KDONE || getMsgsStatusEnum == GetMsgsStatusEnum.KGETDONEBUTOTHERERROR) {
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g1(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) rsp);
            return;
        }
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (rsp.d() && (!rsp.a().isEmpty())) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) rsp.a());
            this.mEnterLatestMsg = (com.tencent.aio.data.msglist.a) last;
        }
        D().e().h(new AIOMsgListEvent.LatestDbMsgNotify(this.mEnterLatestMsg));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, msgSeq);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) source);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("AIOMsgRepo", 1, "loadFirstPage, source:" + source);
        this.mHasFocusBottom = false;
        x1();
        q1(this.msgDelegate);
    }

    public final boolean i1(@NotNull List<? extends com.tencent.aio.data.msglist.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) list)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            return true;
        }
        return this.hasLatestMsg;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull final List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        return (List) MsgListUtil.f24918a.n("AIOMsgRepo", "beforeMsgToScreen", QLog.isDevelopLevel(), new Function0<List<? extends com.tencent.aio.data.msglist.a>>(displayList, this) { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgRepo$beforeMsgToScreen$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ List<com.tencent.aio.data.msglist.a> $displayList;
            final /* synthetic */ AIOMsgRepo this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.$displayList = displayList;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) displayList, (Object) this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends com.tencent.aio.data.msglist.a> invoke() {
                com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.b bVar;
                long j3;
                com.tencent.aio.data.msglist.a aVar;
                com.tencent.aio.api.runtime.a D;
                long j16;
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                List<com.tencent.aio.data.msglist.a> list = this.$displayList;
                List<? extends com.tencent.aio.data.msglist.a> arrayList = new ArrayList<>();
                for (Object obj : list) {
                    if (((com.tencent.aio.data.msglist.a) obj) instanceof AIOMsgItem) {
                        arrayList.add(obj);
                    }
                }
                AIOMsgRepo aIOMsgRepo = this.this$0;
                for (com.tencent.aio.data.msglist.a aVar2 : arrayList) {
                    Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                    AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar2;
                    long msgSeq = aIOMsgItem.getMsgSeq();
                    j16 = aIOMsgRepo.mFirstUnreadSeq;
                    if (msgSeq < j16) {
                        z16 = true;
                        if (aIOMsgItem.getMsgRecord().sendStatus != 1) {
                            aIOMsgItem.q1(z16);
                        }
                    }
                    z16 = false;
                    aIOMsgItem.q1(z16);
                }
                Iterator<T> it = this.this$0.S0().iterator();
                while (it.hasNext()) {
                    arrayList = ((AbsAIOMsgProcessor) it.next()).a(arrayList);
                }
                bVar = this.this$0.mNewMsgTipHelper;
                List<com.tencent.aio.data.msglist.a> list2 = this.$displayList;
                j3 = this.this$0.mFirstUnreadSeq;
                aVar = this.this$0.mEnterLatestMsg;
                long msgSeq2 = aVar != null ? aVar.getMsgSeq() : -1L;
                D = this.this$0.D();
                bVar.b(list2, j3, msgSeq2, D.g().r().c());
                return arrayList;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo
    @NotNull
    public ArrayList<com.tencent.mobileqq.aio.msglist.msgrepo.g<?>> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.msgRepoAbilityList;
    }

    public final void l1(long msgSeq, long msgId, boolean includeDeleteMsg, boolean forceFlush, boolean ignoreErrCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(msgSeq), Long.valueOf(msgId), Boolean.valueOf(includeDeleteMsg), Boolean.valueOf(forceFlush), Boolean.valueOf(ignoreErrCode));
            return;
        }
        QLog.d("AIOMsgRepo", 1, "loadFirstPageBySeq msgSeq=" + msgSeq);
        x1();
        int P0 = P0();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().h(new com.tencent.aio.msgservice.d(D().g().r(), msgSeq, P0, false), includeDeleteMsg), new AIOMsgRepo$loadFirstPageBySeq$1(ignoreErrCode, this, P0, msgSeq, msgId, forceFlush, null)), zs.b.a(Dispatchers.INSTANCE)), J());
        r1();
    }

    public final void n1(long msgTime, boolean ignoreErrCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Long.valueOf(msgTime), Boolean.valueOf(ignoreErrCode));
            return;
        }
        AIOContact c16 = D().g().r().c();
        Contact contact = new Contact(c16.e(), c16.j(), "");
        QLog.i("AIOMsgRepo", 1, "[loadFirstPageByTime]: msgTime is " + msgTime + ", contact is " + contact);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i0().o(contact, msgTime), new AIOMsgRepo$loadFirstPageByTime$1(ignoreErrCode, this, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        QLog.d("AIOMsgRepo", 1, "navigateToBottom");
        if (i1(M())) {
            QLog.d("AIOMsgRepo", 1, "navigateToBottom has latest msg");
            p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, M(), Y0(false, false), "unread_bubble");
        } else {
            v("nav2bottom");
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgRepo, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        QLog.i("AIOMsgRepo", 1, "[onDestroy]: AIOMsgRepo " + hashCode());
        Iterator<T> it = S0().iterator();
        while (it.hasNext()) {
            ((AbsAIOMsgProcessor) it.next()).e();
        }
        MemberLevelInfoCache.INSTANCE.b().j();
        this.msgDelegate = null;
        this.firstPull = true;
        this.msgReqTime = 0L;
    }

    public final void t1(long beginMsgSeq, int count, @Nullable Bundle extra, @NotNull MsgNavigationEvent.NavigateBySeqEvent intent) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(beginMsgSeq), Integer.valueOf(count), extra, intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.d("AIOMsgRepo", 1, "loadRangePage beginMsgSeq=" + beginMsgSeq + ", count=" + count);
        x1();
        if (extra != null) {
            z16 = extra.getBoolean("navigate_order_down", false);
        } else {
            z16 = false;
        }
        if (extra != null) {
            i3 = extra.getInt("extra_count", 0);
        } else {
            i3 = 0;
        }
        AIOMsgServiceWithContext i06 = i0();
        MsgsReq msgsReq = new MsgsReq();
        msgsReq.peer = com.tencent.mobileqq.aio.utils.o.b(D().g().r().c());
        msgsReq.byType = 2;
        msgsReq.msgSeq = beginMsgSeq;
        msgsReq.cnt = count;
        msgsReq.queryOrder = z16;
        msgsReq.includeDeleteMsg = false;
        msgsReq.extraCnt = i3;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i06.i(msgsReq), new AIOMsgRepo$loadRangePage$2(this, count, beginMsgSeq, extra, z16, intent, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    public final void u1(long msgId, @NotNull Bundle extra, boolean ignoreErrCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(msgId), extra, Boolean.valueOf(ignoreErrCode));
            return;
        }
        Intrinsics.checkNotNullParameter(extra, "extra");
        QLog.i("AIOMsgRepo", 1, "[loadRangePage]: msgId is " + msgId);
        x1();
        int W0 = W0();
        boolean z16 = extra.getBoolean("navigate_order_down", false);
        int i3 = extra.getInt("extra_count", 0);
        AIOMsgServiceWithContext i06 = i0();
        MsgsReq msgsReq = new MsgsReq();
        Contact b16 = com.tencent.mobileqq.aio.utils.o.b(D().g().r().c());
        b16.guildId = "";
        msgsReq.peer = b16;
        msgsReq.byType = 1;
        msgsReq.msgId = msgId;
        msgsReq.cnt = W0;
        msgsReq.queryOrder = z16;
        msgsReq.includeSelf = true;
        msgsReq.extraCnt = i3;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(i06.i(msgsReq), new AIOMsgRepo$loadRangePage$4(ignoreErrCode, this, W0, extra, z16, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    public final void x1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.getMsgsAndImportStatus = null;
            QLog.d("AIOMsgRepo", 1, "resetPreMsgStatus");
        }
    }
}
