package com.tencent.mobileqq.aio.msglist;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.frame.api.DrawerFrameScrollMsgIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListExtEvent;
import com.tencent.mobileqq.aio.event.AIOMsgViewRect;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.event.RobotMsgIntent;
import com.tencent.mobileqq.aio.event.e;
import com.tencent.mobileqq.aio.helper.ae;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msglist.AIOMsgListMviIntent;
import com.tencent.mobileqq.aio.msglist.childvm.AIOMsgRoamListVM;
import com.tencent.mobileqq.aio.msglist.childvm.FileTransferListVM;
import com.tencent.mobileqq.aio.msglist.childvm.LocationShareMsgListChildVM;
import com.tencent.mobileqq.aio.msglist.childvm.MsgItemRefreshBuisVM;
import com.tencent.mobileqq.aio.msglist.childvm.MsgSecurityFoldVM;
import com.tencent.mobileqq.aio.msglist.childvm.MultiSelectMsgListChildVM;
import com.tencent.mobileqq.aio.msglist.childvm.PokeMsgListChildVM;
import com.tencent.mobileqq.aio.msglist.childvm.PttMsgListChildVM;
import com.tencent.mobileqq.aio.msglist.childvm.ScrollMsgListVM;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.msglist.uistate.AIOMsgListViewState;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.notification.AIONotificationExtEvent;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent;
import com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent;
import com.tencent.mobileqq.aio.utils.ak;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.qqnt.aio.api.IAIOAnimationApi;
import com.tencent.qqnt.emotion.relatedemo.l;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import defpackage.MsgListUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n\n\u0002\b\u000e*\u0003{\u0085\u0001\b\u0017\u0018\u0000 \u0090\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0091\u0001B\u0011\u0012\u0006\u0010t\u001a\u00020p\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J@\u0010&\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2&\u0010%\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\fH\u0002J\b\u0010+\u001a\u00020\fH\u0002J\u0014\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002J$\u00104\u001a\u00020\f2\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010.2\b\u00103\u001a\u0004\u0018\u00010.H\u0002J\b\u00105\u001a\u00020\fH\u0002J\b\u00106\u001a\u00020\fH\u0002J\u0010\u00108\u001a\u00020\f2\u0006\u0010\u0013\u001a\u000207H\u0002J\b\u0010:\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001eH\u0002J\b\u0010=\u001a\u00020\u001eH\u0002J\u0010\u0010@\u001a\u00020\f2\u0006\u0010?\u001a\u00020>H\u0002J\u0018\u0010D\u001a\u00020\f2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001eH\u0002J\u0010\u0010G\u001a\u00020\f2\u0006\u0010F\u001a\u00020EH\u0002J \u0010K\u001a\u00020\f2\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020A0Hj\b\u0012\u0004\u0012\u00020A`IH\u0002J\u0010\u0010L\u001a\u00020\f2\u0006\u0010F\u001a\u00020EH\u0002J\u0010\u0010M\u001a\u00020\f2\u0006\u0010B\u001a\u00020AH\u0002J\u0018\u0010O\u001a\u00020>2\u0006\u0010B\u001a\u00020A2\u0006\u0010N\u001a\u00020,H\u0002J\u0010\u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u000207H\u0002J\b\u0010T\u001a\u00020SH\u0002J\b\u0010V\u001a\u00020UH\u0002J\b\u0010W\u001a\u00020\u001eH\u0002J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u00072\u0006\u0010X\u001a\u00020\u001eH\u0002J\u0016\u0010\\\u001a\u00020\f2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020,0\u0007H\u0002J:\u0010^\u001a\u00020\f2\u0006\u0010]\u001a\u00020\u001e2(\b\u0002\u0010%\u001a\"\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0002J\u0010\u0010`\u001a\u00020\f2\u0006\u0010_\u001a\u00020>H\u0002J\b\u0010a\u001a\u00020\fH\u0002J\u0010\u0010d\u001a\u00020\f2\u0006\u0010c\u001a\u00020bH\u0002J\b\u0010e\u001a\u00020\fH\u0002J\u0010\u0010g\u001a\u00020\f2\u0006\u0010f\u001a\u00020>H\u0002J\b\u0010h\u001a\u00020\fH\u0002J\u0016\u0010k\u001a\u00020\f2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020A0iH\u0002J\u0018\u0010n\u001a\u00020\f2\u0006\u0010l\u001a\u00020>2\u0006\u0010m\u001a\u00020\u001eH\u0002J\b\u0010o\u001a\u00020\fH\u0002R\u0017\u0010t\u001a\u00020p8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010q\u001a\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010RR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010}\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\t\u0010\u0083\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010\u008d\u0001\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM;", "Lcom/tencent/mobileqq/aio/msglist/BaseMsgListVM;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Lcom/tencent/aio/api/runtime/emitter/b;", "Lcom/tencent/mobileqq/aio/msglist/y;", "Lcom/tencent/mvi/base/route/g;", "", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "L", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "b0", "intent", "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "implState", "D", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", "state", "b", "", com.tencent.luggage.wxa.c8.c.G, "itemCount", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", "Lcom/tencent/mobileqq/aio/msglist/payload/a;", "Lkotlin/collections/HashMap;", "payLoad", "f", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "r0", "C0", "Lcom/tencent/aio/data/msglist/a;", "msg", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a0", "", "source", "aioTopMsg", "aioBottomMsg", "c0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Lcom/tencent/mobileqq/aio/msglist/z$b;", "m0", "oldScrollX", "n0", "h0", "", "show", "z0", "", "msgId", "status", "J0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "H0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "msgIdList", "I0", "D0", "F0", "msgItem", "B0", "i", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/mobileqq/aio/event/e$e;", "p0", "Lcom/tencent/mobileqq/aio/msglist/z$c;", "o0", "i0", WadlProxyConsts.FLAGS, "Lcom/tencent/mobileqq/aio/event/AIOMsgViewRect;", "d0", "list", "K0", "msgPosition", "t0", "isLongShotMode", "s0", "y0", "Landroid/view/View;", "avatarView", "l0", "w0", "immersive", "L0", "q0", "", "msgSeqSet", "A0", "clip", "bottomPadding", "x0", "u0", "Lcom/tencent/mobileqq/aio/msglist/w;", "Lcom/tencent/mobileqq/aio/msglist/w;", "g0", "()Lcom/tencent/mobileqq/aio/msglist/w;", "mListFetcher", "G", "mRoamState", "Lcom/tencent/mobileqq/aio/msglist/v;", "H", "Lcom/tencent/mobileqq/aio/msglist/v;", "mDirtyStateProvider", "com/tencent/mobileqq/aio/msglist/AIOMsgListVM$c", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM$c;", "mAction", "J", "Lcom/tencent/aio/data/msglist/a;", "topAIOMsg", "K", "bottomAIOMsg", "Z", "mfirstPageByNavigate", "com/tencent/mobileqq/aio/msglist/AIOMsgListVM$d", "M", "Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM$d;", "mActionR", "N", "Lkotlin/Lazy;", "e0", "()Lcom/tencent/mobileqq/aio/msglist/AIOMsgRepo;", "mAIOMsgRepo", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/w;)V", "P", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOMsgListVM extends BaseMsgListVM<at.b, MsgListUiState> implements com.tencent.aio.api.runtime.emitter.b, y {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final w mListFetcher;

    /* renamed from: G, reason: from kotlin metadata */
    private int mRoamState;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private v mDirtyStateProvider;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final c mAction;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a topAIOMsg;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a bottomAIOMsg;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mfirstPageByNavigate;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final d mActionR;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAIOMsgRepo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgListVM$a;", "", "", "DEFAULT_PAGE_SIZE", "I", "MSG_CACHE_SIZE", "NAVIGATION_MSG_SIZE", "PULL_MSG_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.AIOMsgListVM$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVM$b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVM.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        
            if ((!r7.isEmpty()) != false) goto L14;
         */
        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, displayList, lastMsg, firstMsg)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            if (AIOMsgListVM.this.e0().f1()) {
                z16 = true;
            }
            z16 = false;
            if (!z16 && QLog.isColorLevel()) {
                QLog.d("AIOMsgListVM", 2, "enableRefresh " + z16);
            }
            return z16;
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, displayList, lastMsg, firstMsg)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            boolean z16 = !AIOMsgListVM.this.e0().i1(displayList);
            if (!z16 && QLog.isDevelopLevel()) {
                QLog.d("AIOMsgListVM", 4, "enableLoadMore " + z16);
            }
            return z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVM$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOMsgListVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/AIOMsgListVM$d", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgListVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return AIOMsgListVM.this.I(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58028);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMsgListVM(@NotNull w mListFetcher) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mListFetcher, "mListFetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mListFetcher);
            return;
        }
        this.mListFetcher = mListFetcher;
        this.mDirtyStateProvider = new v();
        this.mAction = new c();
        this.mActionR = new d();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOMsgRepo>() { // from class: com.tencent.mobileqq.aio.msglist.AIOMsgListVM$mAIOMsgRepo$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgListVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOMsgRepo invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AIOMsgRepo) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOMsgListVM aIOMsgListVM = AIOMsgListVM.this;
                return aIOMsgListVM.b0((com.tencent.aio.api.runtime.a) aIOMsgListVM.getMContext(), AIOMsgListVM.this.vmScope());
            }
        });
        this.mAIOMsgRepo = lazy;
    }

    private final void A0(Set<Long> msgSeqSet) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : l()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (msgSeqSet.contains(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgSeq()))) {
                QLog.i("AIOMsgListVM", 1, "[highlightMsgView]: findHighlight index " + i3);
                arrayList.add(Integer.valueOf(i3));
            }
            i3 = i16;
        }
        updateUI(new AIOMsgListViewState.HighLightMsgView(arrayList));
    }

    private final boolean B0(long msgId, com.tencent.aio.data.msglist.a msgItem) {
        if (!(msgItem instanceof PttMsgItem) || msgId != msgItem.getMsgId() || !((PttMsgItem) msgItem).C2()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C0() {
        String str;
        Bundle l3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().l();
        long j3 = l3.getLong("key_navigate_msgid", -1L);
        long j16 = l3.getLong("key_navigate_msgseq", -1L);
        long j17 = l3.getLong("key_navigate_time", -1L);
        String str2 = "loadFirstPage: msgTime=" + j17 + ", msgId=" + j3 + ", msgSeq=" + j16;
        com.tencent.qqnt.trace.a.f362326a.c(str2);
        QLog.i("AIOMsgListVM", 1, str2);
        this.mfirstPageByNavigate = true;
        if (j17 > 0) {
            e0().n1(j17, true);
            str = "key_navigate_time";
        } else if (j16 > 0) {
            str = "key_navigate_time";
            AIOMsgRepo.m1(e0(), j16, j3, false, false, true, 12, null);
        } else {
            str = "key_navigate_time";
            if (j3 > 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(HippyQQPagView.FunctionName.FLUSH, true);
                bundle.putLong("navigate_id", j3);
                e0().u1(j3, bundle, true);
            } else {
                e0().i("listVM");
                this.mfirstPageByNavigate = false;
            }
        }
        l3.remove("key_navigate_msgid");
        l3.remove("key_navigate_msgseq");
        l3.remove(str);
    }

    private final void D0(final MsgRecord msgRecord) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.o
            @Override // java.lang.Runnable
            public final void run() {
                AIOMsgListVM.E0(AIOMsgListVM.this, msgRecord);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E(final MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.InputLayoutChange) {
            AIOMsgListEvent.InputLayoutChange inputLayoutChange = (AIOMsgListEvent.InputLayoutChange) intent;
            updateUI(new AIOMsgListViewState.InputBarHeightChangeState(inputLayoutChange.a() - inputLayoutChange.d(), com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j((com.tencent.aio.api.runtime.a) getMContext())));
            return;
        }
        if (intent instanceof AIOMsgListEvent.TopLayoutHeightChange) {
            updateUI(new AIOMsgListViewState.TopLayoutHeightChangeState(((AIOMsgListEvent.TopLayoutHeightChange) intent).a()));
            return;
        }
        if (intent instanceof AIOMsgListEvent.GetMsgListEvent) {
            K0(((AIOMsgListEvent.GetMsgListEvent) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnDeleteMsg) {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.m
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgListVM.j0(AIOMsgListVM.this, intent);
                }
            }, null, 2, null);
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnDeleteMsgs) {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.n
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgListVM.k0(AIOMsgListVM.this, intent);
                }
            }, null, 2, null);
            return;
        }
        if (intent instanceof AIOMsgListEvent.ResendingMsg) {
            J0(((AIOMsgListEvent.ResendingMsg) intent).a(), 1);
            return;
        }
        if (intent instanceof AIOMsgListEvent.MsgContentChangeEvent) {
            AIOMsgListEvent.MsgContentChangeEvent msgContentChangeEvent = (AIOMsgListEvent.MsgContentChangeEvent) intent;
            t0(msgContentChangeEvent.a(), msgContentChangeEvent.b());
            return;
        }
        if (intent instanceof AIOMsgListEvent.ShowBlurMsgView) {
            z0(((AIOMsgListEvent.ShowBlurMsgView) intent).a());
            return;
        }
        if (intent instanceof DrawerFrameScrollMsgIntent) {
            n0(((DrawerFrameScrollMsgIntent) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.NeedPreLoadMsg) {
            updateUI(new AIOMsgListViewState.NeedPreLoadMsg(((AIOMsgListEvent.NeedPreLoadMsg) intent).a()));
            return;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.RefreshAvatarPendant) {
            updateUI(AIOMsgListViewState.UnlockUpdate.f192744d);
            return;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.EnterAIOAnimationStart) {
            updateUI(AIOMsgListViewState.DelayLockUpdate.f192721d);
            return;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.EnterAIOAnimationEnd) {
            if (((MsgItemExternalRefreshEvent.EnterAIOAnimationEnd) intent).a() == IAIOAnimationApi.AnimationScene.AIO_ENTER) {
                updateUI(AIOMsgListViewState.CompleteAIOStartAnimal.f192720d);
                return;
            }
            return;
        }
        if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            s0(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
            return;
        }
        if (intent instanceof AIOMsgListEvent.RefreshLongShotView) {
            updateUI(AIOMsgListViewState.RefreshLongShotView.f192730d);
            return;
        }
        if (intent instanceof AIOMsgListEvent.LoadRoamFirstMsgEvent) {
            this.mRoamState = ((AIOMsgListEvent.LoadRoamFirstMsgEvent) intent).a();
            return;
        }
        if (intent instanceof AIOMsgListEvent.FetchRoamStateEvent) {
            ((AIOMsgListEvent.FetchRoamStateEvent) intent).b(this.mRoamState);
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnAddPttFakeMsg) {
            D0(((AIOMsgListEvent.OnAddPttFakeMsg) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnCancelPttFakeMsg) {
            F0(((AIOMsgListEvent.OnCancelPttFakeMsg) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.GetCurFocusIndex) {
            ((AIOMsgListEvent.GetCurFocusIndex) intent).b(this.mListFetcher.getCurrentFocus());
            return;
        }
        if (intent instanceof AIOMsgListEvent.AddAvatarAreaView) {
            l0(((AIOMsgListEvent.AddAvatarAreaView) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.RemoveAvatarAreaView) {
            w0();
            return;
        }
        if (intent instanceof AIOMsgListEvent.ImmersiveAreaEvent) {
            L0(((AIOMsgListEvent.ImmersiveAreaEvent) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.HideKeyBoardAndPanel) {
            q0();
            return;
        }
        if (intent instanceof AIOTitleContainerMsgIntent.NotifyTitleHeight) {
            AIOTitleContainerMsgIntent.NotifyTitleHeight notifyTitleHeight = (AIOTitleContainerMsgIntent.NotifyTitleHeight) intent;
            updateUI(new AIOMsgListViewState.UpdateTitleHeight(notifyTitleHeight.a(), notifyTitleHeight.b()));
            return;
        }
        if (intent instanceof AIOMsgListEvent.HighLightMsgView) {
            A0(((AIOMsgListEvent.HighLightMsgView) intent).a());
            return;
        }
        if (intent instanceof AIOLifeCycleEvent.OnNewIntent) {
            u0();
            return;
        }
        if (intent instanceof AIOMsgListEvent.GetBeforeAccessibilityDelegate) {
            ((AIOMsgListEvent.GetBeforeAccessibilityDelegate) intent).b(this.mListFetcher.U0());
            return;
        }
        if (intent instanceof AIOMsgListExtEvent.SetTopPadding) {
            updateUI(new AIOMsgListViewState.SetTopPadding(((AIOMsgListExtEvent.SetTopPadding) intent).a()));
            return;
        }
        if (intent instanceof AIOMsgListEvent.SetClipMode) {
            AIOMsgListEvent.SetClipMode setClipMode = (AIOMsgListEvent.SetClipMode) intent;
            x0(setClipMode.b(), setClipMode.a());
        } else if (intent instanceof AIOMsgListEvent.SetBottomPaddingIncrement) {
            updateUI(new AIOMsgListViewState.SetBottomPaddingIncrement(((AIOMsgListEvent.SetBottomPaddingIncrement) intent).a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void E0(AIOMsgListVM this$0, MsgRecord msgRecord) {
        PttMsgItem pttMsgItem;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        List<? extends com.tencent.aio.data.msglist.a> M = this$0.m().M();
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : M) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (msgRecord.msgId == ((com.tencent.aio.data.msglist.a) obj).getMsgId()) {
                z16 = true;
            }
            i3 = i16;
        }
        if (!z16) {
            AIOMsgItem s16 = MsgListUtil.s(MsgListUtil.f24918a, msgRecord, false, ((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().requireContext(), null, 10, null);
            if (s16 instanceof PttMsgItem) {
                pttMsgItem = (PttMsgItem) s16;
            } else {
                pttMsgItem = null;
            }
            if (pttMsgItem != null) {
                pttMsgItem.J2(true);
                pttMsgItem.x1(ae.INSTANCE.a());
                M.add((com.tencent.aio.data.msglist.a) pttMsgItem);
                AIOMsgRepo e06 = this$0.e0();
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(pttMsgItem);
                e06.l0(arrayListOf);
                this$0.e0().p0(IMsgListRepository.MsgListRepoOpType.OtherOperation, M, this$0.e0().Y0(false, true), "add_ptt_fake_msg");
            }
        }
    }

    private final void F0(final long msgId) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.p
            @Override // java.lang.Runnable
            public final void run() {
                AIOMsgListVM.G0(AIOMsgListVM.this, msgId);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(AIOMsgListVM this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MsgList M = this$0.m().M();
        if (M.isEmpty()) {
            return;
        }
        boolean z16 = false;
        int i3 = 0;
        for (com.tencent.aio.data.msglist.a aVar : M) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a oldMsgItem = aVar;
            Intrinsics.checkNotNullExpressionValue(oldMsgItem, "oldMsgItem");
            if (this$0.B0(j3, oldMsgItem)) {
                M.remove(i3);
                z16 = true;
            }
            i3 = i16;
        }
        if (z16) {
            BaseMsgRepo.o0(this$0.e0(), M, "cancel_ptt_fake_msg", null, null, 12, null);
        }
    }

    private final void H0(MsgRecord msgRecord) {
        MsgList M = m().M();
        if (M.isEmpty()) {
            return;
        }
        boolean z16 = false;
        int i3 = 0;
        for (com.tencent.aio.data.msglist.a aVar : M) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (msgRecord.msgId == aVar.getMsgId()) {
                M.remove(i3);
                z16 = true;
            }
            i3 = i16;
        }
        if (z16) {
            BaseMsgRepo.o0(e0(), M, "delete_msg", null, null, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent i3) {
        if (i3 instanceof AIOMsgListEvent.GetCurTopMsg) {
            return new z.d(this.topAIOMsg);
        }
        if (i3 instanceof AIOMsgListEvent.GetFocusIndex) {
            return new z.e(this.mListFetcher.getCurrentFocus());
        }
        if (i3 instanceof AIOMsgListEvent.GetListItemRect) {
            return new z.g(d0(((AIOMsgListEvent.GetListItemRect) i3).a()));
        }
        if (i3 instanceof AIOMsgListEvent.GetFirstPageRealMsgSize) {
            return new z.i(i0());
        }
        if (i3 instanceof AIOMsgListEvent.TopBlurEvent) {
            return m0();
        }
        if (i3 instanceof AIOMsgListEvent.BottomBlurEvent) {
            return m0();
        }
        if (i3 instanceof RobotMsgIntent.GetVideoViewInfo) {
            return p0();
        }
        if (i3 instanceof AIOMsgListEvent.GetBottomPaddingIncrement) {
            return o0();
        }
        return z.k.f192765a;
    }

    private final void I0(ArrayList<Long> msgIdList) {
        MsgList M = m().M();
        if (M.isEmpty()) {
            return;
        }
        boolean z16 = false;
        for (int size = M.size() - 1; -1 < size; size--) {
            if (msgIdList.contains(Long.valueOf(M.get(size).getMsgId()))) {
                M.remove(size);
                z16 = true;
            }
        }
        if (z16) {
            BaseMsgRepo.o0(e0(), M, "delete_msg", null, null, 12, null);
        }
    }

    private final void J0(long msgId, int status) {
        List<com.tencent.aio.data.msglist.a> list;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (TypeIntrinsics.isMutableList(l3)) {
            list = l3;
        } else {
            list = null;
        }
        if (list != null) {
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
                if (aVar.getMsgId() == msgId) {
                    Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                    AIOMsgItem aIOMsgItem = (AIOMsgItem) aVar;
                    l3.set(i3, aIOMsgItem.n(ak.a(aIOMsgItem.getMsgRecord(), status)));
                    updateUI(new AIOMsgListViewState.AIOMsgItemChangedState(i3, 1, new com.tencent.mobileqq.aio.msglist.payload.b().b(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD, new a.ay(status)).a()));
                }
                i3 = i16;
            }
        }
    }

    private final void K0(List<? extends com.tencent.aio.data.msglist.a> list) {
        updateUI(new AIOMsgListViewState.ShotMsgItemState(list));
    }

    private final void L0(boolean immersive) {
        Float valueOf = Float.valueOf(0.0f);
        if (immersive) {
            Float[] fArr = new Float[4];
            for (int i3 = 0; i3 < 4; i3++) {
                fArr[i3] = valueOf;
            }
            fArr[1] = Float.valueOf(com.tencent.aio.view_dsl.dsl.c.b(40));
            fArr[3] = Float.valueOf(com.tencent.aio.view_dsl.dsl.c.b(10));
            updateUI(new AIOMsgListViewState.ImmersiveAreaUiState(3, fArr));
            return;
        }
        Float[] fArr2 = new Float[4];
        for (int i16 = 0; i16 < 4; i16++) {
            fArr2[i16] = valueOf;
        }
        updateUI(new AIOMsgListViewState.ImmersiveAreaUiState(0, fArr2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
    }

    private final AIOMsgItem a0(com.tencent.aio.data.msglist.a msg2) {
        if (msg2 instanceof AIOMsgItem) {
            return (AIOMsgItem) msg2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c0(String source, AIOMsgItem aioTopMsg, AIOMsgItem aioBottomMsg) {
        this.topAIOMsg = aioTopMsg;
        this.bottomAIOMsg = aioBottomMsg;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.MsgListScrollEvent(source, aioTopMsg, aioBottomMsg, (AIOMsgItem) m().H()));
    }

    private final List<AIOMsgViewRect> d0(int flags) {
        ArrayList parcelableArrayList = fetchVBState(new k(flags)).b().getParcelableArrayList("ITEM_RECT_LIST");
        Intrinsics.checkNotNull(parcelableArrayList);
        return parcelableArrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOMsgRepo e0() {
        return (AIOMsgRepo) this.mAIOMsgRepo.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int h0() {
        AIONotificationExtEvent.GetNotificationHeightEvent getNotificationHeightEvent = new AIONotificationExtEvent.GetNotificationHeightEvent(0);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getNotificationHeightEvent);
        QLog.i("AIOMsgListVM", 1, "getNotificationHeight: " + getNotificationHeightEvent.a());
        return getNotificationHeightEvent.a();
    }

    private final int i0() {
        long j3;
        long j16;
        List<com.tencent.aio.data.msglist.a> takeLast;
        AIOMsgItem aIOMsgItem;
        com.tencent.aio.data.msglist.a aVar = this.bottomAIOMsg;
        int i3 = 0;
        if (aVar != null && this.topAIOMsg != null) {
            if (aVar != null) {
                j3 = aVar.getMsgSeq();
            } else {
                j3 = 0;
            }
            com.tencent.aio.data.msglist.a aVar2 = this.topAIOMsg;
            if (aVar2 != null) {
                j16 = aVar2.getMsgSeq();
            } else {
                j16 = 0;
            }
            long j17 = (j3 - j16) + 1;
            if (j17 > 0) {
                takeLast = CollectionsKt___CollectionsKt.takeLast(l(), (int) j17);
                for (com.tencent.aio.data.msglist.a aVar3 : takeLast) {
                    if (aVar3 instanceof AIOMsgItem) {
                        aIOMsgItem = (AIOMsgItem) aVar3;
                    } else {
                        aIOMsgItem = null;
                    }
                    if (aIOMsgItem != null && !com.tencent.mobileqq.aio.utils.d.Q(aIOMsgItem)) {
                        i3++;
                    }
                }
            } else {
                return 0;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(AIOMsgListVM this$0, MsgIntent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        this$0.H0(((AIOMsgListEvent.OnDeleteMsg) intent).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(AIOMsgListVM this$0, MsgIntent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        this$0.I0(((AIOMsgListEvent.OnDeleteMsgs) intent).a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l0(View avatarView) {
        updateUI(new AIOMsgListViewState.AddAvatarAreaView(avatarView));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new FullBackgroundMviIntent.AIOBackgroundDrawable(null));
    }

    private final z.b m0() {
        RecyclerView K0 = this.mListFetcher.K0();
        this.mDirtyStateProvider.b(K0);
        return new z.b(K0, this.mDirtyStateProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0(int oldScrollX) {
        if (oldScrollX == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.CancleSelectEvent.f188283d);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOMsgListVM", false, 2, null));
        }
    }

    private final z.c o0() {
        AIOMsgListViewState.GetBottomPaddingIncrement getBottomPaddingIncrement = new AIOMsgListViewState.GetBottomPaddingIncrement(0, 1, null);
        updateUI(getBottomPaddingIncrement);
        return new z.c(getBottomPaddingIncrement.a());
    }

    private final e.C7244e p0() {
        int i3;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        ListIterator<com.tencent.aio.data.msglist.a> listIterator = l3.listIterator(l3.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous() instanceof ShortVideoMsgItem) {
                    i3 = listIterator.nextIndex();
                    break;
                }
            } else {
                i3 = 0;
                break;
            }
        }
        QLog.i("AIOMsgListVM", 1, "handleGetLastVideoInfo " + i3);
        Bundle b16 = fetchVBState(new l(i3)).b();
        return new e.C7244e(b16.getInt("left", 0), b16.getInt("top", 0), b16.getInt("width", 0), b16.getInt("height", 0));
    }

    private final void q0() {
        updateUI(AIOMsgListViewState.HideKeyBoardAndPanel.f192723d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r0() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("code_hide_external_panel", new Bundle()));
        com.tencent.mobileqq.aio.panel.c cVar = com.tencent.mobileqq.aio.panel.c.f193019a;
        if (cVar.a((com.tencent.aio.api.runtime.a) getMContext())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOMsgListVM", false, 2, null));
        } else if (cVar.b((com.tencent.aio.api.runtime.a) getMContext())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelMsgIntent("AIOMsgListVM", false, 2, null));
        }
    }

    private final void s0(boolean isLongShotMode) {
        updateUI(new AIOMsgListViewState.SetLongShotMode(isLongShotMode));
    }

    private final void t0(int msgPosition, HashMap<AIOMsgItemPayloadType, com.tencent.mobileqq.aio.msglist.payload.a> payLoad) {
        updateUI(new AIOMsgListViewState.AIOMsgItemChangedState(msgPosition, 1, payLoad));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u0() {
        String str;
        String str2;
        Bundle l3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().l();
        long j3 = l3.getLong("key_navigate_msgid", -1L);
        long j16 = l3.getLong("key_navigate_msgseq", -1L);
        long j17 = l3.getLong("key_navigate_time", -1L);
        String str3 = "handleOnNewIntent: msgTime=" + j17 + ", msgId=" + j3 + ", msgSeq=" + j16;
        com.tencent.qqnt.trace.a.f362326a.c(str3);
        QLog.i("AIOMsgListVM", 1, str3);
        if (j3 > 0 || j16 > 0 || j17 > 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(MsgNavigationEvent.NavigationNotify.f188654d);
        }
        if (j17 > 0) {
            AIOMsgRepo.o1(e0(), j17, false, 2, null);
            str = "key_navigate_time";
            str2 = "key_navigate_msgseq";
        } else if (j16 > 0) {
            str = "key_navigate_time";
            str2 = "key_navigate_msgseq";
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateBySeqEvent("other", j16, j3, false, null, false, false, null, 248, null));
        } else {
            str = "key_navigate_time";
            str2 = "key_navigate_msgseq";
            if (j3 > 0) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateByIdEvent("other", j3, false, null, false, null, 60, null));
            }
        }
        l3.remove("key_navigate_msgid");
        l3.remove(str2);
        l3.remove(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w0() {
        updateUI(AIOMsgListViewState.RemoveAvatarAreaView.f192732d);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new FullBackgroundMviIntent.AIOBackgroundDrawable(null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x0(boolean clip, int bottomPadding) {
        com.tencent.mvi.base.route.k kVar;
        int i3;
        updateUI(new AIOMsgListViewState.SetClipMode(clip, bottomPadding));
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        l.a aVar = null;
        if (e16 != null) {
            kVar = e16.k(AIOMsgListEvent.GetBottomLayoutHeight.f188299d);
        } else {
            kVar = null;
        }
        if (kVar instanceof l.a) {
            aVar = (l.a) kVar;
        }
        if (aVar != null) {
            i3 = aVar.a();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            updateUI(new AIOMsgListViewState.InputBarHeightChangeState(i3, com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j((com.tencent.aio.api.runtime.a) getMContext())));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y0() {
        if (!com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j((com.tencent.aio.api.runtime.a) getMContext()) && !am.f194110a.j((com.tencent.aio.api.runtime.a) getMContext())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
        }
    }

    private final void z0(boolean show) {
        updateUI(new AIOMsgListViewState.UpdateMsgListBlurView(show));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @Nullable
    public MsgListUiState D(@NotNull MsgListUiState implState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MsgListUiState) iPatchRedirector.redirect((short) 9, (Object) this, (Object) implState);
        }
        Intrinsics.checkNotNullParameter(implState, "implState");
        if (implState instanceof MsgListState) {
            MsgListState msgListState = (MsgListState) implState;
            return new AIOMsgListDataState(msgListState.getFocusIndex(), (Collection) implState, false, m().H(), msgListState.getUpdateType(), msgListState.getExtra());
        }
        return null;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgListVM
    @NotNull
    public List<com.tencent.mobileqq.aio.msglist.childvm.c> L() {
        List<com.tencent.mobileqq.aio.msglist.childvm.c> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.aio.msglist.childvm.c[]{new MultiSelectMsgListChildVM(this.mListFetcher, this, (com.tencent.aio.api.runtime.a) getMContext()), new com.tencent.mobileqq.aio.msglist.childvm.g(this, (com.tencent.aio.api.runtime.a) getMContext()), new MsgItemRefreshBuisVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new com.tencent.mobileqq.aio.msglist.childvm.d(this, (com.tencent.aio.api.runtime.a) getMContext()), new PokeMsgListChildVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new LocationShareMsgListChildVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new PttMsgListChildVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new ScrollMsgListVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new MsgSecurityFoldVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new FileTransferListVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new AIOMsgRoamListVM(this, (com.tencent.aio.api.runtime.a) getMContext(), e0()), new LongMsgListVM(this, (com.tencent.aio.api.runtime.a) getMContext()), new s(this, (com.tencent.aio.api.runtime.a) getMContext()), new com.tencent.mobileqq.aio.msglist.childvm.b(this, (com.tencent.aio.api.runtime.a) getMContext())});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.c
    public void b(@NotNull MsgListUiState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.b(state);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.AIOMsgListUpdateEvent(l().size()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public AIOMsgRepo b0(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        com.tencent.mobileqq.aio.factory.param.o oVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgRepo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aioContext, (Object) scope);
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        WeakReference weakReference = new WeakReference(this);
        ts.b a16 = ts.c.a(aioContext);
        if (a16 instanceof com.tencent.mobileqq.aio.factory.param.o) {
            oVar = (com.tencent.mobileqq.aio.factory.param.o) a16;
        } else {
            oVar = null;
        }
        return new AIOMsgRepo(aioContext, scope, weakReference, oVar);
    }

    @Override // com.tencent.mobileqq.aio.msglist.y
    public void f(int pos, int itemCount, @Nullable HashMap<AIOMsgItemPayloadType, com.tencent.mobileqq.aio.msglist.payload.a> payLoad) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(pos), Integer.valueOf(itemCount), payLoad);
        } else {
            updateUI(new AIOMsgListViewState.AIOMsgItemChangedState(pos, itemCount, payLoad));
        }
    }

    @NotNull
    public final w g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (w) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mListFetcher;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Set) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.InputLayoutChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.TopLayoutHeightChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetMsgListEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.OnDeleteMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.OnDeleteMsgs");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ResendingMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MsgContentChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ShowBlurMsgView");
        hashSet.add("com.tencent.aio.frame.api.DrawerFrameScrollMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.NeedPreLoadMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgEvent.GetFirstMsgEndEvent");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.RefreshAvatarPendant");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.EnterAIOAnimationStart");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.EnterAIOAnimationEnd");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.RefreshLongShotView");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LoadRoamFirstMsgEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.FetchRoamStateEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.OnAddPttFakeMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.OnCancelPttFakeMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetCurFocusIndex");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.AddAvatarAreaView");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.RemoveAvatarAreaView");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ImmersiveAreaEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.HideKeyBoardAndPanel");
        hashSet.add("com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent.NotifyTitleHeight");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.HighLightMsgView");
        hashSet.add("com.tencent.qqnt.aio.AIOLifeCycleEvent.OnNewIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetBeforeAccessibilityDelegate");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.SetClipMode");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListExtEvent.SetTopPadding");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.SetBottomPaddingIncrement");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Set) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetCurTopMsg");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetFocusIndex");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetListItemRect");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetFirstPageRealMsgSize");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.TopBlurEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.BottomBlurEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.RobotMsgIntent.GetVideoViewInfo");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.GetBottomPaddingIncrement");
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull at.b intent) {
        com.tencent.qqnt.aio.activity.l lVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            C0();
            return;
        }
        if (intent instanceof a.c) {
            m().x();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.StartLoadMsg.f188402d);
            return;
        }
        if (intent instanceof a.C0640a) {
            m().w();
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.c) {
            r0();
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.a) {
            r0();
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.b) {
            y0();
            return;
        }
        if (intent instanceof a.d) {
            w();
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.m) {
            AIOMsgListMviIntent.m mVar = (AIOMsgListMviIntent.m) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.ListScrollStateChanged(mVar.a(), mVar.b()));
            if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 2 && mVar.a() == 0) {
                com.tencent.mobileqq.aio.utils.b.f194119a.a();
                return;
            }
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.l) {
            AIOMsgListMviIntent.l lVar2 = (AIOMsgListMviIntent.l) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.ListScrollDistanceNotify(lVar2.a(), lVar2.b(), lVar2.c()));
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.d) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.BounceScrollStateChanged(((AIOMsgListMviIntent.d) intent).a()));
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.r) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.GetRecyclerView(((AIOMsgListMviIntent.r) intent).a()));
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.n) {
            AIOMsgListMviIntent.n nVar = (AIOMsgListMviIntent.n) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.ListScrolled(nVar.a(), nVar.b()));
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.j) {
            AIOMsgListMviIntent.j jVar = (AIOMsgListMviIntent.j) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.ListBounced(jVar.c(), jVar.a(), jVar.b()));
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.g) {
            ((AIOMsgListMviIntent.g) intent).b(am.f194110a.k((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.f) {
            ((AIOMsgListMviIntent.f) intent).b(l());
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.i) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.CancleSelectEvent.f188283d);
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.o) {
            ts.b a16 = ts.c.a((com.tencent.aio.api.runtime.a) getMContext());
            if (a16 instanceof com.tencent.qqnt.aio.activity.l) {
                lVar = (com.tencent.qqnt.aio.activity.l) a16;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                lVar.b();
                return;
            }
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.p) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOMsgListVM", 2, "send event: on first screen show");
            }
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.OnFirstScreenShow.f188353d);
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.q) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOReserve1CreateModelIntent("aio_unread_bubble", new UnreadMsgIntent.NotifyReplyMsgInfo(((AIOMsgListMviIntent.q) intent).a())));
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.h) {
            ((AIOMsgListMviIntent.h) intent).b(h0());
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.CheckEliminateMsg) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h((MsgIntent) intent);
            return;
        }
        if (intent instanceof AIOMsgListMviIntent.e) {
            if (this.mfirstPageByNavigate) {
                if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 1 || ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 2) {
                    ((AIOMsgListMviIntent.e) intent).b(ViewUtils.dpToPx(88.0f));
                    return;
                }
                return;
            }
            return;
        }
        super.handleIntent(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.runtime.emitter.b
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) configuration);
            return;
        }
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        QLog.d("AIOMsgListVM", 1, "onConfigurationChanged " + configuration);
        ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).resetHelperCache();
        com.tencent.mobileqq.aio.utils.e.f194142a.h(true);
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_configchange_reloadmsg_9015", true)) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.ConfigChangeEvent.f188285d);
        } else {
            e0().i("onConfigurationChanged");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.BaseMsgListVM, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        R();
        AIOPttAudioPlayerManager.f191706d.s(System.identityHashCode(this));
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.b.class).c(this);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void p(@NotNull MsgListIntent.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.p(intent);
        c0("AIOMsgListVM", a0(intent.b()), a0(intent.d()));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        z(e0());
        super.onCreate(context);
        Q();
        AIOPttAudioPlayerManager.f191706d.q(System.identityHashCode(this));
        ml3.a a16 = context.b().a(com.tencent.aio.api.runtime.emitter.b.class);
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        a16.b(this, d16);
    }
}
