package com.tencent.qqnt.kernel.api.impl;

import androidx.annotation.WorkerThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.ContactThirdPartyBusinessInfos;
import com.tencent.qqnt.kernel.nativeinterface.ContactTopData;
import com.tencent.qqnt.kernel.nativeinterface.EnterOrExitMsgListInfo;
import com.tencent.qqnt.kernel.nativeinterface.GameMsgBoxConfig;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentJumpCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentSnapShotCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.NotificationCommonInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtra;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactFetchParam;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactJumpInfoVer2;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u008e\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001WB\u001e\u0012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\f\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0003J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J8\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132&\u0010\u0017\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00150\u0007j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015`\u0016H\u0002J \u0010\u001b\u001a\u00020\u00052\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0007j\b\u0012\u0004\u0012\u00020\u0019`\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u001cH\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002J2\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)2\b\u0010'\u001a\u0004\u0018\u00010+H\u0016J$\u0010.\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050-H\u0016J$\u0010/\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050-H\u0016J$\u00100\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050-H\u0016J$\u00101\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050-H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J*\u00108\u001a\u00020\u00052\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0007j\b\u0012\u0004\u0012\u00020\u001c`\u00162\b\u00107\u001a\u0004\u0018\u00010&H\u0016J*\u00109\u001a\u00020\u00052\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0007j\b\u0012\u0004\u0012\u00020\u0019`\u00162\b\u00107\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010:\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010;H\u0016J\u001c\u0010?\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010\u00192\b\u0010>\u001a\u0004\u0018\u00010&H\u0016J\u001c\u0010B\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010G\u001a\u00020\u00052\u0006\u0010D\u001a\u00020C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J$\u0010J\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eJ\u0010\u0010K\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0016J\u0014\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0NH\u0016J\u0018\u0010Q\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00192\u0006\u0010'\u001a\u00020PH\u0016J\u001e\u0010S\u001a\u00020\u00052\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010'\u001a\u00020PH\u0016J\u001a\u0010V\u001a\u00020\u00052\u0006\u0010U\u001a\u00020T2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010W\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001eH\u0016J \u0010Y\u001a\u0012\u0012\f\u0012\n X*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\nH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020[H\u0016J2\u0010`\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\"2\u0016\u0010_\u001a\u0012\u0012\u0004\u0012\u00020^0\u0007j\b\u0012\u0004\u0012\u00020^`\u00162\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010b\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\n2\u0006\u0010'\u001a\u00020aH\u0016J\u0019\u0010c\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\bc\u0010dJ$\u0010g\u001a\u00020\u00052\u0010\u0010f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010h\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u000e\u0010k\u001a\b\u0012\u0004\u0012\u00020j0iH\u0016J2\u0010n\u001a\u00020\u00052\u001e\u0010m\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010l\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010l\u0018\u0001`\u00162\b\u0010'\u001a\u0004\u0018\u00010&H\u0016R$\u0010q\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00150o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR2\u0010y\u001a \u0012\u0004\u0012\u00020\n\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050-0v0u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010xR2\u0010{\u001a \u0012\u0004\u0012\u00020\n\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050-0v0u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010xR(\u0010|\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001e0u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010xR \u0010}\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010xR \u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010xR.\u0010\u0081\u0001\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00050-0u8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010xR$\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\b0u8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010xR \u0010\u0088\u0001\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/RecentContactService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactService;", "Lcom/tencent/qqnt/kernel/api/aa;", "", "x4", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "changedRecentContactLists", "", "seq", Constants.BASE_IN_HOTFIX, "oldInfo", "y4", Constants.DEBUG_INFO, "info", "J4", "K4", "Lcom/tencent/qqnt/kernel/invorker/d;", "listener", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/ArrayList;", "list", "C4", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "infoList", "A4", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "z4", "", "B4", "Lcom/tencent/qqnt/kernel/nativeinterface/AnchorPointContactInfo;", "anchor", "", "fetchOld", "listType", "count", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactJumpInfoVer2;", "lastInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentJumpCallback;", "jumpToSpecifyRecentContactVer2", "Lkotlin/Function1;", "g0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "s0", "u0", "addExpandRecentContactListener", "removeExpandRecentContactListener", "l", "b0", "deleteList", "cb", "deleteRecentContacts", "a0", "clearRecentContacts", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentGetContactCallback;", "getRecentContactInfos", "peer", "result", "addRecentContact", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactData;", "contact", "upsertRecentContactManually", "", "status", "", "guildId", "setGuildDisplayStatus", "unreadCnt", "changedList", "L4", "getUnreadCountByListType", "chatType", "getUnreadCountNoiseByChatType", "", "getUnreadCountNoiseMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetContactsCallback;", "F0", "contacts", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/EnterOrExitMsgListInfo;", "enterOrExitInfo", "enterOrExitMsgList", "a", "kotlin.jvm.PlatformType", "I4", "i", "Lcom/tencent/qqnt/kernel/invorker/c;", "e0", "isTop", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactTopData;", "contactList", "setContactListTop", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentSnapShotCallback;", "getRecentContactListSnapShot", "c0", "(Ljava/lang/Integer;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/GameMsgBoxConfig;", Constants.Configs.CONFIGS, "updateGameMsgConfigs", "setAllGameMsgRead", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/kernel/data/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/kernel/nativeinterface/ContactThirdPartyBusinessInfos;", "contactsThirdPartyBusinessInfos", "setThirdPartyBusinessInfos", "", "Ljava/util/List;", "expandRecentContactListener", "e", "Lcom/tencent/qqnt/kernel/invorker/c;", "expandNotificationListener", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "mapListener", tl.h.F, "mapGuildListener", "mapGuildDataList", "mapUnreadCache", BdhLogUtil.LogTag.Tag_Conn, "mapUnreadByChatTypeCache", "D", "mapContactNotificationListener", "E", "mapChangeInfo", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "H4", "()Z", "mapRefreshSyncSwitch", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "G", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RecentContactService extends BaseService<IKernelRecentContactListener, IKernelRecentContactService> implements com.tencent.qqnt.kernel.api.aa {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Integer> mapUnreadByChatTypeCache;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<com.tencent.qqnt.kernel.data.a, Unit>> mapContactNotificationListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, RecentContactListChangedInfo> mapChangeInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mapRefreshSyncSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<WeakReference<com.tencent.qqnt.kernel.invorker.d>> expandRecentContactListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.kernel.invorker.c expandNotificationListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>>> mapListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>>> mapGuildListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, List<RecentContactInfo>> mapGuildDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Integer> mapUnreadCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/RecentContactService$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.RecentContactService$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52706);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentContactService(@Nullable IKernelRecentContactService iKernelRecentContactService, @NotNull py content) {
        super("RecentContactService", content, iKernelRecentContactService);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelRecentContactService, (Object) content);
            return;
        }
        this.expandRecentContactListener = new ArrayList();
        this.mapListener = new ConcurrentHashMap<>();
        this.mapGuildListener = new ConcurrentHashMap<>();
        this.mapGuildDataList = new ConcurrentHashMap<>();
        this.mapUnreadCache = new ConcurrentHashMap<>();
        this.mapUnreadByChatTypeCache = new ConcurrentHashMap<>();
        this.mapContactNotificationListener = new ConcurrentHashMap<>();
        this.mapChangeInfo = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(RecentContactService$mapRefreshSyncSwitch$2.INSTANCE);
        this.mapRefreshSyncSwitch = lazy;
        com.tencent.qqnt.kernel.utils.o.f359277a.a("RecentContactServiceAddDefaultListener", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService.1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    RecentContactService.this.x4();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A4(ArrayList<Contact> infoList) {
        for (Contact contact : infoList) {
            if (contact.chatType == 116) {
                contact.peerUid = "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B4(List<RecentContactInfo> infoList) {
        Iterator<T> it = infoList.iterator();
        while (it.hasNext()) {
            z4((RecentContactInfo) it.next());
        }
    }

    private final void C4(com.tencent.qqnt.kernel.invorker.d listener, ArrayList<WeakReference<com.tencent.qqnt.kernel.invorker.d>> list) {
        com.tencent.qqnt.kernel.invorker.d dVar;
        for (WeakReference<com.tencent.qqnt.kernel.invorker.d> weakReference : this.expandRecentContactListener) {
            if (weakReference != null && (dVar = weakReference.get()) != null && dVar != listener) {
                list.add(weakReference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo] */
    /* JADX WARN: Type inference failed for: r0v33, types: [T, com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo] */
    @WorkerThread
    public final void D4(ArrayList<RecentContactListChangedInfo> changedRecentContactLists, int seq) {
        int i3;
        int i16;
        Object valueOf;
        boolean z16;
        boolean isDebugVersion;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = changedRecentContactLists.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RecentContactListChangedInfo recentContactListChangedInfo = (RecentContactListChangedInfo) next;
            if (recentContactListChangedInfo.changedList == null || recentContactListChangedInfo.sortedContactList == null) {
                i3 = 1;
            }
            if (i3 == 0) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ?? r06 = (RecentContactListChangedInfo) it5.next();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = r06;
            int i17 = r06.listType;
            long j3 = r06.unreadCnt;
            int i18 = r06.notificationType;
            long j16 = r06.cacheLocation;
            boolean z17 = r06.moreDataAtTheBottom;
            int size = r06.sortedContactList.size();
            int size2 = ((RecentContactListChangedInfo) objectRef.element).changedList.size();
            ArrayList<RecentContactInfo> arrayList2 = ((RecentContactListChangedInfo) objectRef.element).changedList;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                i16 = i3;
            } else {
                i16 = 1;
            }
            Object obj = "";
            if (i16 != 0) {
                valueOf = "";
            } else {
                valueOf = Long.valueOf(((RecentContactListChangedInfo) objectRef.element).changedList.get(i3).contactId);
            }
            HashMap<Integer, Integer> hashMap = ((RecentContactListChangedInfo) objectRef.element).unreadCntDetail.unreadCntByType;
            if (hashMap != null && !hashMap.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                obj = Integer.valueOf(((RecentContactListChangedInfo) objectRef.element).unreadCntDetail.unreadCntByType.size());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onRecentContactListChangedV2] seq=");
            sb5.append(seq);
            Iterator it6 = it5;
            sb5.append(", listtype=");
            sb5.append(i17);
            sb5.append(", unreadCnt=");
            sb5.append(j3);
            sb5.append(", notifyType=");
            sb5.append(i18);
            sb5.append(", loc=");
            sb5.append(j16);
            sb5.append(", moreAtBottom=");
            sb5.append(z17);
            sb5.append(", sortSize=");
            sb5.append(size);
            sb5.append(", changeSize=");
            sb5.append(size2);
            sb5.append(", changeFirst=");
            sb5.append(valueOf);
            sb5.append(" unreadCntByType=");
            sb5.append(obj);
            QLog.d("RecentContactService", 1, sb5.toString());
            T t16 = objectRef.element;
            if (((RecentContactListChangedInfo) t16).listType == 1) {
                com.tencent.qqnt.kernel.utils.h.f359261a.e(((RecentContactListChangedInfo) t16).changedList.size());
                objectRef.element = y4((RecentContactListChangedInfo) objectRef.element);
                this.mapUnreadByChatTypeCache.clear();
                this.mapUnreadByChatTypeCache.putAll(((RecentContactListChangedInfo) objectRef.element).unreadCntDetail.unreadCntByType);
                this.mapUnreadByChatTypeCache.put(1, Integer.valueOf(((RecentContactListChangedInfo) objectRef.element).unreadCntDetail.unclassifiableC2CUnreadCnt));
                QLog.i("RecentContactService", 1, "unreadCntByType " + this.mapUnreadByChatTypeCache.get(103));
            }
            G4((RecentContactListChangedInfo) objectRef.element);
            J4((RecentContactListChangedInfo) objectRef.element);
            CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>> copyOnWriteArraySet = this.mapListener.get(Integer.valueOf(((RecentContactListChangedInfo) objectRef.element).listType));
            if (copyOnWriteArraySet != null) {
                Intrinsics.checkNotNullExpressionValue(copyOnWriteArraySet, "mapListener[it.listType]");
                Iterator<T> it7 = copyOnWriteArraySet.iterator();
                while (it7.hasNext()) {
                    Function1 function1 = (Function1) it7.next();
                    try {
                        QLog.i("RecentContactService", 1, "[onRecentContactListChangedV2] update listener=" + ((RecentContactListChangedInfo) objectRef.element).listType);
                        function1.invoke(objectRef.element);
                    } finally {
                        if (!isDebugVersion) {
                        }
                    }
                }
            }
            if (H4()) {
                this.mapUnreadCache.put(Integer.valueOf(((RecentContactListChangedInfo) objectRef.element).listType), Integer.valueOf((int) ((RecentContactListChangedInfo) objectRef.element).unreadCnt));
                QLog.i("RecentContactService", 1, "mapUnreadCache " + this.mapUnreadCache.get(1));
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ll
                @Override // java.lang.Runnable
                public final void run() {
                    RecentContactService.E4(RecentContactService.this, objectRef);
                }
            }, 240, null, false);
            i3 = 0;
            it5 = it6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void E4(RecentContactService this$0, Ref.ObjectRef it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        T t16 = it.element;
        int i3 = ((RecentContactListChangedInfo) t16).listType;
        int i16 = (int) ((RecentContactListChangedInfo) t16).unreadCnt;
        ArrayList<RecentContactInfo> arrayList = ((RecentContactListChangedInfo) t16).changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "it.changedList");
        this$0.L4(i3, i16, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F4(int i3, int i16, boolean z16, AnchorPointContactInfo anchor, IOperateCallback iOperateCallback, int i17, String str) {
        Intrinsics.checkNotNullParameter(anchor, "$anchor");
        QLog.d("RecentContactService", 1, "[fetchRecentContactInfo] listType=" + i3 + ", count=" + i16 + ", fetchOld=" + z16 + ", pos=" + anchor.pos + " err=" + i17 + ", msg=" + str);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i17, str);
        }
    }

    private final void G4(RecentContactListChangedInfo oldInfo) {
        boolean z16;
        if (oldInfo.listType != 6) {
            return;
        }
        String a16 = com.tencent.qqnt.kernel.util.b.f359257a.a();
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("RecentContactService", 4, "[filterSpecificEvent] try to filter uid=" + a16);
        }
        Iterator<RecentContactInfo> it = oldInfo.changedList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "oldInfo.changedList.iterator()");
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().peerUid, a16)) {
                it.remove();
                return;
            }
        }
    }

    private final boolean H4() {
        return ((Boolean) this.mapRefreshSyncSwitch.getValue()).booleanValue();
    }

    private final void J4(RecentContactListChangedInfo info) {
        ArrayList<RecentContactInfo> arrayList;
        RecentContactListChangedInfo recentContactListChangedInfo = this.mapChangeInfo.get(Integer.valueOf(info.listType));
        if (recentContactListChangedInfo != null) {
            arrayList = recentContactListChangedInfo.getChangedList();
        } else {
            arrayList = null;
        }
        RecentContactListChangedInfo recentContactListChangedInfo2 = new RecentContactListChangedInfo(info.listType, info.sortedContactList, com.tencent.qqnt.kernel.util.b.f359257a.b(arrayList, info), K4(info, recentContactListChangedInfo), info.unreadCnt, info.unreadFlag, info.cacheLocation, info.firstContactPos, info.atTheTop, info.atTheBottom);
        recentContactListChangedInfo2.unreadCntDetail = info.unreadCntDetail;
        recentContactListChangedInfo2.moreDataAtTheBottom = info.moreDataAtTheBottom;
        this.mapChangeInfo.put(Integer.valueOf(info.listType), recentContactListChangedInfo2);
    }

    private final int K4(RecentContactListChangedInfo info, RecentContactListChangedInfo oldInfo) {
        int i3 = info.notificationType;
        if (i3 != 1) {
            boolean z16 = false;
            if (oldInfo != null && oldInfo.notificationType == 1) {
                z16 = true;
            }
            if (!z16) {
                return i3;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x4() {
        l(new IKernelRecentContactListener() { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$addDefaultListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecentContactService.this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
            public /* synthetic */ void onDeletedContactsNotify(ArrayList arrayList) {
                com.tencent.qqnt.kernel.nativeinterface.bh.a(this, arrayList);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
            public /* synthetic */ void onMsgUnreadCountUpdate(HashMap hashMap) {
                com.tencent.qqnt.kernel.nativeinterface.bh.b(this, hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
            public /* synthetic */ void onRecentContactListChanged(ArrayList arrayList, ArrayList arrayList2, RecentContactExtra recentContactExtra) {
                com.tencent.qqnt.kernel.nativeinterface.bh.c(this, arrayList, arrayList2, recentContactExtra);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
            public void onRecentContactListChangedVer2(@Nullable final ArrayList<RecentContactListChangedInfo> changedRecentContactLists, final int seq) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) changedRecentContactLists, seq);
                    return;
                }
                if (changedRecentContactLists != null && !changedRecentContactLists.isEmpty()) {
                    com.tencent.qqnt.kernel.utils.n nVar = com.tencent.qqnt.kernel.utils.n.f359273a;
                    final RecentContactService recentContactService = RecentContactService.this;
                    nVar.f(new Function0<Unit>(changedRecentContactLists, seq) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$addDefaultListener$1$onRecentContactListChangedVer2$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ ArrayList<RecentContactListChangedInfo> $changedRecentContactLists;
                        final /* synthetic */ int $seq;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$changedRecentContactLists = changedRecentContactLists;
                            this.$seq = seq;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, RecentContactService.this, changedRecentContactLists, Integer.valueOf(seq));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                RecentContactService.this.D4(this.$changedRecentContactLists, this.$seq);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    return;
                }
                QLog.i("RecentContactService", 1, "[onRecentContactListChangedV2] changed list is empty");
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener
            public void onRecentContactNotification(@Nullable ArrayList<RecentContactInfo> changedList, @NotNull NotificationCommonInfo commonInfo, int seq) {
                ConcurrentHashMap concurrentHashMap;
                com.tencent.qqnt.kernel.invorker.c cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, changedList, commonInfo, Integer.valueOf(seq));
                    return;
                }
                Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
                if (changedList != null) {
                    RecentContactService recentContactService = RecentContactService.this;
                    for (RecentContactInfo recentContactInfo : changedList) {
                        cVar = recentContactService.expandNotificationListener;
                        if (cVar != null) {
                            cVar.a(recentContactInfo, commonInfo, seq);
                        }
                    }
                }
                concurrentHashMap = RecentContactService.this.mapContactNotificationListener;
                Iterator it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(new com.tencent.qqnt.kernel.data.a(changedList, commonInfo, seq));
                }
            }
        });
    }

    private final RecentContactListChangedInfo y4(RecentContactListChangedInfo oldInfo) {
        boolean z16;
        String a16 = com.tencent.qqnt.kernel.util.b.f359257a.a();
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("RecentContactService", 4, "[changedRecentContactListForNormalList] try to update uid=" + a16);
            }
            ArrayList<RecentContactInfo> arrayList = oldInfo.changedList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "oldInfo.changedList");
            for (RecentContactInfo recentContactInfo : arrayList) {
                if (Intrinsics.areEqual(recentContactInfo.peerUid, a16)) {
                    long j3 = recentContactInfo.unreadCnt;
                    recentContactInfo.unreadCnt = 0L;
                    ArrayList<SpecificEventTypeInfoInMsgBox> arrayList2 = recentContactInfo.listOfSpecificEventTypeInfosInMsgBox;
                    if (arrayList2 != null) {
                        arrayList2.clear();
                    }
                    long j16 = oldInfo.unreadCnt - j3;
                    oldInfo.unreadCnt = j16;
                    QLog.d("RecentContactService", 1, "[onRecentContactListChangedV2] filter after unread=" + j16);
                }
            }
        }
        return oldInfo;
    }

    private final void z4(RecentContactInfo info) {
        if (info.chatType == 116) {
            info.peerUid = "";
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void F0(@NotNull final Contact contact, @NotNull final IGetContactsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) contact, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(callback, "callback");
        check("findContact", new Function0<Unit>(contact, callback) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$findContact$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetContactsCallback $callback;
            final /* synthetic */ Contact $contact;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$contact = contact;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RecentContactService.this, contact, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                ArrayList<Contact> arrayListOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelRecentContactService service = RecentContactService.this.getService();
                if (service == null) {
                    return null;
                }
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.$contact);
                service.getContacts(arrayListOf, this.$callback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    @Nullable
    /* renamed from: I4, reason: merged with bridge method [inline-methods] */
    public ArrayList<RecentContactInfo> M(int listType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (ArrayList) iPatchRedirector.redirect((short) 31, (Object) this, listType);
        }
        RecentContactListChangedInfo recentContactListChangedInfo = this.mapChangeInfo.get(Integer.valueOf(listType));
        if (recentContactListChangedInfo != null) {
            return recentContactListChangedInfo.getChangedList();
        }
        return null;
    }

    public final void L4(int listType, int unreadCnt, @NotNull List<RecentContactInfo> changedList) {
        com.tencent.qqnt.kernel.invorker.d dVar;
        boolean isDebugVersion;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(listType), Integer.valueOf(unreadCnt), changedList);
            return;
        }
        Intrinsics.checkNotNullParameter(changedList, "changedList");
        if (H4()) {
            this.mapUnreadCache.put(Integer.valueOf(listType), Integer.valueOf(unreadCnt));
        }
        for (WeakReference<com.tencent.qqnt.kernel.invorker.d> weakReference : this.expandRecentContactListener) {
            if (weakReference != null && (dVar = weakReference.get()) != null) {
                try {
                    dVar.O0(listType, unreadCnt, changedList);
                } finally {
                    if (!isDebugVersion) {
                    }
                }
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    @NotNull
    public Flow<com.tencent.qqnt.kernel.data.a> Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Flow) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return FlowKt.callbackFlow(new RecentContactService$registerRencentContactNotification$1(this, null));
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    @Nullable
    public List<RecentContactInfo> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return M(1);
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void a0(@NotNull final ArrayList<Contact> deleteList, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) deleteList, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(deleteList, "deleteList");
        if (QLog.isColorLevel()) {
            QLog.d("RecentContactService", 2, "deleteRecentContactsV2: " + deleteList);
        }
        check("deleteRecentContact", cb5, new Function1<IOperateCallback, Unit>(deleteList) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$deleteRecentContactsV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<Contact> $deleteList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$deleteList = deleteList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactService.this, (Object) deleteList);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                RecentContactService.this.A4(this.$deleteList);
                IKernelRecentContactService service = RecentContactService.this.getService();
                if (service == null) {
                    return null;
                }
                service.deleteRecentContactsVer2(this.$deleteList, iOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void addExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<WeakReference<com.tencent.qqnt.kernel.invorker.d>> arrayList = new ArrayList<>(this.expandRecentContactListener.size() + 1);
        C4(listener, arrayList);
        arrayList.add(new WeakReference<>(listener));
        this.expandRecentContactListener = arrayList;
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void addRecentContact(@Nullable final Contact peer, @Nullable final IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) peer, (Object) result);
        } else {
            check("addRecentContact", new Function0<Unit>(peer, result) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$addRecentContact$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Contact $peer;
                final /* synthetic */ IOperateCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$peer = peer;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RecentContactService.this, peer, result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelRecentContactService service = RecentContactService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addRecentContact(this.$peer, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void b0(@NotNull IKernelRecentContactListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            BaseService.removeListener$default(this, listener, false, new Function1<Long, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$removeRecentContactListener$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                        return;
                    }
                    IKernelRecentContactService service = RecentContactService.this.getService();
                    if (service != null) {
                        service.removeKernelRecentContactListener(j3);
                    }
                }
            }, 2, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void c0(@Nullable Integer listType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) listType);
        } else if (listType == null) {
            this.mapChangeInfo.clear();
        } else {
            this.mapChangeInfo.remove(listType);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void clearRecentContacts(@Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) cb5);
        } else {
            check("clearRecentContacts", cb5, new Function1<IOperateCallback, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$clearRecentContacts$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelRecentContactService service = RecentContactService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.clearRecentContacts(iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void d(@NotNull final List<Contact> contacts, @NotNull final IGetContactsCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) contacts, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(contacts, "contacts");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (contacts.isEmpty()) {
            return;
        }
        check("findContacts", new Function0<Unit>(callback, contacts) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$findContacts$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IGetContactsCallback $callback;
            final /* synthetic */ List<Contact> $contacts;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$callback = callback;
                this.$contacts = contacts;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RecentContactService.this, callback, contacts);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelRecentContactService service = RecentContactService.this.getService();
                if (service == null) {
                    return null;
                }
                ArrayList<Contact> arrayList = new ArrayList<>();
                arrayList.addAll(this.$contacts);
                service.getContacts(arrayList, this.$callback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void deleteRecentContacts(@NotNull final ArrayList<RecentContactInfo> deleteList, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) deleteList, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(deleteList, "deleteList");
        QLog.d("RecentContactService", 1, "deleteRecentContacts");
        check("deleteRecentContact", cb5, new Function1<IOperateCallback, Unit>(deleteList) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$deleteRecentContacts$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<RecentContactInfo> $deleteList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$deleteList = deleteList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactService.this, (Object) deleteList);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                RecentContactService.this.B4(this.$deleteList);
                IKernelRecentContactService service = RecentContactService.this.getService();
                if (service == null) {
                    return null;
                }
                service.deleteRecentContacts(this.$deleteList, iOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void e0(@NotNull com.tencent.qqnt.kernel.invorker.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.expandNotificationListener = listener;
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void enterOrExitMsgList(@NotNull EnterOrExitMsgListInfo enterOrExitInfo, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) enterOrExitInfo, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(enterOrExitInfo, "enterOrExitInfo");
        IKernelRecentContactService service = getService();
        if (service != null) {
            service.enterOrExitMsgList(enterOrExitInfo, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void g0(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, listType, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("RecentContactService", 1, "[addRecentContactListenerV2] listType=" + listType + ", listener=" + listener.hashCode());
        CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>> copyOnWriteArraySet = this.mapListener.get(Integer.valueOf(listType));
        if (copyOnWriteArraySet != null) {
            if (!copyOnWriteArraySet.contains(listener)) {
                copyOnWriteArraySet.add(listener);
            }
        } else {
            CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
            copyOnWriteArraySet2.add(listener);
            this.mapListener.put(Integer.valueOf(listType), copyOnWriteArraySet2);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void getRecentContactInfos(@Nullable IKernelRecentGetContactCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cb5);
            return;
        }
        IKernelRecentContactService service = getService();
        if (service != null) {
            service.getRecentContactInfos(cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void getRecentContactListSnapShot(final int count, @NotNull final IKernelRecentSnapShotCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, count, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            check("getRecentContactListSnapShot", new Function0<Unit>(count, callback) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$getRecentContactListSnapShot$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IKernelRecentSnapShotCallback $callback;
                final /* synthetic */ int $count;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$count = count;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RecentContactService.this, Integer.valueOf(count), callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelRecentContactService service = RecentContactService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getRecentContactListSnapShot(this.$count, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public int getUnreadCountByListType(int listType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, listType)).intValue();
        }
        Integer num = this.mapUnreadCache.get(Integer.valueOf(listType));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public int getUnreadCountNoiseByChatType(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, chatType)).intValue();
        }
        Integer num = this.mapUnreadByChatTypeCache.get(Integer.valueOf(chatType));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    @NotNull
    public Map<Integer, Integer> getUnreadCountNoiseMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Map) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mapUnreadByChatTypeCache;
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    @Nullable
    public RecentContactListChangedInfo i(int listType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (RecentContactListChangedInfo) iPatchRedirector.redirect((short) 32, (Object) this, listType);
        }
        return this.mapChangeInfo.get(Integer.valueOf(listType));
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void jumpToSpecifyRecentContactVer2(@NotNull RecentContactJumpInfoVer2 lastInfo, @Nullable IKernelRecentJumpCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lastInfo, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(lastInfo, "lastInfo");
        IKernelRecentContactService service = getService();
        if (service != null) {
            service.jumpToSpecifyRecentContactVer2(lastInfo, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void l(@NotNull IKernelRecentContactListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            addListener(listener, new Function1<IKernelRecentContactListener, Long>() { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$addRecentContactListener$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentContactService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Long invoke(@NotNull IKernelRecentContactListener it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    IKernelRecentContactService service = RecentContactService.this.getService();
                    if (service != null) {
                        return Long.valueOf(service.addKernelRecentContactListener(it));
                    }
                    return null;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void m(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, listType, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.d("RecentContactService", 1, "[removeRecentContactListenerV2] listType=" + listType + ", listener=" + listener.hashCode());
        CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>> copyOnWriteArraySet = this.mapListener.get(Integer.valueOf(listType));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void removeExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<WeakReference<com.tencent.qqnt.kernel.invorker.d>> arrayList = new ArrayList<>(this.expandRecentContactListener.size());
        C4(listener, arrayList);
        this.expandRecentContactListener = arrayList;
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void s0(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, listType, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>> copyOnWriteArraySet = this.mapGuildListener.get(Integer.valueOf(listType));
        if (copyOnWriteArraySet != null) {
            if (!copyOnWriteArraySet.contains(listener)) {
                copyOnWriteArraySet.add(listener);
            }
        } else {
            CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
            copyOnWriteArraySet2.add(listener);
            this.mapGuildListener.put(Integer.valueOf(listType), copyOnWriteArraySet2);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void setAllGameMsgRead(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) callback);
            return;
        }
        IKernelRecentContactService service = getService();
        if (service != null) {
            service.setAllGameMsgRead(callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void setContactListTop(final boolean isTop, @NotNull final ArrayList<ContactTopData> contactList, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Boolean.valueOf(isTop), contactList, callback);
        } else {
            Intrinsics.checkNotNullParameter(contactList, "contactList");
            check("setContactListTop", new Function0<Unit>(isTop, contactList, callback) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$setContactListTop$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ ArrayList<ContactTopData> $contactList;
                final /* synthetic */ boolean $isTop;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$isTop = isTop;
                    this.$contactList = contactList;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RecentContactService.this, Boolean.valueOf(isTop), contactList, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelRecentContactService service = RecentContactService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setContactListTop(this.$isTop, this.$contactList, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void setGuildDisplayStatus(long status, @Nullable String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(status), guildId);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void setThirdPartyBusinessInfos(@Nullable ArrayList<ContactThirdPartyBusinessInfos> contactsThirdPartyBusinessInfos, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) contactsThirdPartyBusinessInfos, (Object) callback);
            return;
        }
        IKernelRecentContactService service = getService();
        if (service != null) {
            service.setThirdPartyBusinessInfos(contactsThirdPartyBusinessInfos, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void u0(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, listType, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArraySet<Function1<RecentContactListChangedInfo, Unit>> copyOnWriteArraySet = this.mapGuildListener.get(Integer.valueOf(listType));
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void updateGameMsgConfigs(@Nullable ArrayList<GameMsgBoxConfig> configs, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) configs, (Object) callback);
            return;
        }
        IKernelRecentContactService service = getService();
        if (service != null) {
            service.updateGameMsgConfigs(configs, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void upsertRecentContactManually(@Nullable final RecentContactData contact, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) contact, (Object) callback);
        } else {
            if (contact == null) {
                return;
            }
            check("upsertRecentContactManually", new Function0<Unit>(contact, callback) { // from class: com.tencent.qqnt.kernel.api.impl.RecentContactService$upsertRecentContactManually$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ RecentContactData $contact;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$contact = contact;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RecentContactService.this, contact, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelRecentContactService service = RecentContactService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.upsertRecentContactManually(this.$contact, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.aa
    public void v(@NotNull final AnchorPointContactInfo anchor, final boolean fetchOld, final int listType, final int count, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, anchor, Boolean.valueOf(fetchOld), Integer.valueOf(listType), Integer.valueOf(count), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        IKernelRecentContactService service = getService();
        if (service != null) {
            service.fetchAndSubscribeABatchOfRecentContact(new RecentContactFetchParam(listType, fetchOld, count, anchor), new IOperateCallback() { // from class: com.tencent.qqnt.kernel.api.impl.lk
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RecentContactService.F4(listType, count, fetchOld, anchor, callback, i3, str);
                }
            });
        }
    }
}
